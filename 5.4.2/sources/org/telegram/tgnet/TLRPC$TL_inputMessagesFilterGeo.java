package org.telegram.tgnet;

import org.telegram.tgnet.TLRPC.MessagesFilter;

public class TLRPC$TL_inputMessagesFilterGeo extends MessagesFilter {
    public static int constructor = -419271411;

    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
    }
}
