package org.telegram.tgnet;

public class TLRPC$TL_updateContactsReset extends TLRPC$Update {
    public static int constructor = 1887741886;

    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
    }
}
