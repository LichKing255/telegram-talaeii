package org.telegram.tgnet;

import org.telegram.tgnet.TLRPC.PrivacyKey;

public class TLRPC$TL_privacyKeyStatusTimestamp extends PrivacyKey {
    public static int constructor = -1137792208;

    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
    }
}
