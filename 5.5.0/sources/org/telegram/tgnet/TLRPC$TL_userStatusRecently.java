package org.telegram.tgnet;

public class TLRPC$TL_userStatusRecently extends TLRPC$UserStatus {
    public static int constructor = -496024847;

    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
    }
}
