package org.telegram.tgnet;

public class TLRPC$TL_decryptedMessageActionAbortKey extends TLRPC$DecryptedMessageAction {
    public static int constructor = -586814357;

    public void readParams(AbstractSerializedData stream, boolean exception) {
        this.exchange_id = stream.readInt64(exception);
    }

    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeInt64(this.exchange_id);
    }
}
