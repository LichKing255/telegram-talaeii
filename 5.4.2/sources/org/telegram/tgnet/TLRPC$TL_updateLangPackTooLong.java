package org.telegram.tgnet;

public class TLRPC$TL_updateLangPackTooLong extends TLRPC$Update {
    public static int constructor = 281165899;

    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
    }
}
