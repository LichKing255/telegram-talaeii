package org.telegram.tgnet;

public class TLRPC$TL_updateConfig extends TLRPC$Update {
    public static int constructor = -1574314746;

    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
    }
}
