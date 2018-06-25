package org.telegram.tgnet;

import org.telegram.tgnet.TLRPC.RichText;

public class TLRPC$TL_textStrike extends RichText {
    public static int constructor = -1678197867;
    public RichText text;

    public void readParams(AbstractSerializedData abstractSerializedData, boolean z) {
        this.text = RichText.TLdeserialize(abstractSerializedData, abstractSerializedData.readInt32(z), z);
    }

    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        this.text.serializeToStream(abstractSerializedData);
    }
}
