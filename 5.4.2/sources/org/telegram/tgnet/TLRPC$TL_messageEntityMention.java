package org.telegram.tgnet;

import org.telegram.tgnet.TLRPC.MessageEntity;

public class TLRPC$TL_messageEntityMention extends MessageEntity {
    public static int constructor = -100378723;

    public void readParams(AbstractSerializedData abstractSerializedData, boolean z) {
        this.offset = abstractSerializedData.readInt32(z);
        this.length = abstractSerializedData.readInt32(z);
    }

    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        abstractSerializedData.writeInt32(this.offset);
        abstractSerializedData.writeInt32(this.length);
    }
}
