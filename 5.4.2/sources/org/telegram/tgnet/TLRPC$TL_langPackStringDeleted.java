package org.telegram.tgnet;

import org.telegram.tgnet.TLRPC.LangPackString;

public class TLRPC$TL_langPackStringDeleted extends LangPackString {
    public static int constructor = 695856818;

    public void readParams(AbstractSerializedData abstractSerializedData, boolean z) {
        this.key = abstractSerializedData.readString(z);
    }

    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        abstractSerializedData.writeString(this.key);
    }
}
