package org.telegram.tgnet;

import org.telegram.tgnet.TLRPC.DocumentAttribute;

public class TLRPC$TL_documentAttributeAnimated extends DocumentAttribute {
    public static int constructor = 297109817;

    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
    }
}
