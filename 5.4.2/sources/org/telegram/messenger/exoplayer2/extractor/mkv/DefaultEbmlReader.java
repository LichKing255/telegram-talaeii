package org.telegram.messenger.exoplayer2.extractor.mkv;

import java.util.Stack;
import org.telegram.messenger.exoplayer2.ParserException;
import org.telegram.messenger.exoplayer2.extractor.ExtractorInput;
import org.telegram.messenger.exoplayer2.util.Assertions;

final class DefaultEbmlReader implements EbmlReader {
    private static final int ELEMENT_STATE_READ_CONTENT = 2;
    private static final int ELEMENT_STATE_READ_CONTENT_SIZE = 1;
    private static final int ELEMENT_STATE_READ_ID = 0;
    private static final int MAX_ID_BYTES = 4;
    private static final int MAX_INTEGER_ELEMENT_SIZE_BYTES = 8;
    private static final int MAX_LENGTH_BYTES = 8;
    private static final int VALID_FLOAT32_ELEMENT_SIZE_BYTES = 4;
    private static final int VALID_FLOAT64_ELEMENT_SIZE_BYTES = 8;
    private long elementContentSize;
    private int elementId;
    private int elementState;
    private final Stack<MasterElement> masterElementsStack = new Stack();
    private EbmlReaderOutput output;
    private final byte[] scratch = new byte[8];
    private final VarintReader varintReader = new VarintReader();

    private static final class MasterElement {
        private final long elementEndPosition;
        private final int elementId;

        private MasterElement(int i, long j) {
            this.elementId = i;
            this.elementEndPosition = j;
        }
    }

    DefaultEbmlReader() {
    }

    private long maybeResyncToNextLevel1Element(ExtractorInput extractorInput) {
        extractorInput.resetPeekPosition();
        while (true) {
            extractorInput.peekFully(this.scratch, 0, 4);
            int parseUnsignedVarintLength = VarintReader.parseUnsignedVarintLength(this.scratch[0]);
            if (parseUnsignedVarintLength != -1 && parseUnsignedVarintLength <= 4) {
                int assembleVarint = (int) VarintReader.assembleVarint(this.scratch, parseUnsignedVarintLength, false);
                if (this.output.isLevel1Element(assembleVarint)) {
                    extractorInput.skipFully(parseUnsignedVarintLength);
                    return (long) assembleVarint;
                }
            }
            extractorInput.skipFully(1);
        }
    }

    private double readFloat(ExtractorInput extractorInput, int i) {
        long readInteger = readInteger(extractorInput, i);
        return i == 4 ? (double) Float.intBitsToFloat((int) readInteger) : Double.longBitsToDouble(readInteger);
    }

    private long readInteger(ExtractorInput extractorInput, int i) {
        int i2 = 0;
        extractorInput.readFully(this.scratch, 0, i);
        long j = 0;
        while (i2 < i) {
            j = (j << 8) | ((long) (this.scratch[i2] & 255));
            i2++;
        }
        return j;
    }

    private String readString(ExtractorInput extractorInput, int i) {
        if (i == 0) {
            return TtmlNode.ANONYMOUS_REGION_ID;
        }
        byte[] bArr = new byte[i];
        extractorInput.readFully(bArr, 0, i);
        return new String(bArr);
    }

    public void init(EbmlReaderOutput ebmlReaderOutput) {
        this.output = ebmlReaderOutput;
    }

    public boolean read(ExtractorInput extractorInput) {
        Assertions.checkState(this.output != null);
        while (true) {
            if (this.masterElementsStack.isEmpty() || extractorInput.getPosition() < ((MasterElement) this.masterElementsStack.peek()).elementEndPosition) {
                if (this.elementState == 0) {
                    long readUnsignedVarint = this.varintReader.readUnsignedVarint(extractorInput, true, false, 4);
                    if (readUnsignedVarint == -2) {
                        readUnsignedVarint = maybeResyncToNextLevel1Element(extractorInput);
                    }
                    if (readUnsignedVarint == -1) {
                        return false;
                    }
                    this.elementId = (int) readUnsignedVarint;
                    this.elementState = 1;
                }
                if (this.elementState == 1) {
                    this.elementContentSize = this.varintReader.readUnsignedVarint(extractorInput, false, true, 8);
                    this.elementState = 2;
                }
                int elementType = this.output.getElementType(this.elementId);
                switch (elementType) {
                    case 0:
                        extractorInput.skipFully((int) this.elementContentSize);
                        this.elementState = 0;
                    case 1:
                        long position = extractorInput.getPosition();
                        this.masterElementsStack.add(new MasterElement(this.elementId, this.elementContentSize + position));
                        this.output.startMasterElement(this.elementId, position, this.elementContentSize);
                        this.elementState = 0;
                        return true;
                    case 2:
                        if (this.elementContentSize > 8) {
                            throw new ParserException("Invalid integer size: " + this.elementContentSize);
                        }
                        this.output.integerElement(this.elementId, readInteger(extractorInput, (int) this.elementContentSize));
                        this.elementState = 0;
                        return true;
                    case 3:
                        if (this.elementContentSize > 2147483647L) {
                            throw new ParserException("String element size: " + this.elementContentSize);
                        }
                        this.output.stringElement(this.elementId, readString(extractorInput, (int) this.elementContentSize));
                        this.elementState = 0;
                        return true;
                    case 4:
                        this.output.binaryElement(this.elementId, (int) this.elementContentSize, extractorInput);
                        this.elementState = 0;
                        return true;
                    case 5:
                        if (this.elementContentSize == 4 || this.elementContentSize == 8) {
                            this.output.floatElement(this.elementId, readFloat(extractorInput, (int) this.elementContentSize));
                            this.elementState = 0;
                            return true;
                        }
                        throw new ParserException("Invalid float size: " + this.elementContentSize);
                    default:
                        throw new ParserException("Invalid element type " + elementType);
                }
            }
            this.output.endMasterElement(((MasterElement) this.masterElementsStack.pop()).elementId);
            return true;
        }
    }

    public void reset() {
        this.elementState = 0;
        this.masterElementsStack.clear();
        this.varintReader.reset();
    }
}
