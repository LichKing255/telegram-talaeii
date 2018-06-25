package org.telegram.tgnet;

import org.telegram.tgnet.TLRPC.Bool;
import org.telegram.tgnet.TLRPC.InputPeer;

public class TLRPC$TL_messages_reportSpam extends TLObject {
    public static int constructor = -820669733;
    public InputPeer peer;

    public TLObject deserializeResponse(AbstractSerializedData abstractSerializedData, int i, boolean z) {
        return Bool.TLdeserialize(abstractSerializedData, i, z);
    }

    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        this.peer.serializeToStream(abstractSerializedData);
    }
}
