package org.telegram.tgnet;

import org.telegram.tgnet.TLRPC.SendMessageAction;

public class TLRPC$TL_sendMessageGeoLocationAction extends SendMessageAction {
    public static int constructor = 393186209;

    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
    }
}
