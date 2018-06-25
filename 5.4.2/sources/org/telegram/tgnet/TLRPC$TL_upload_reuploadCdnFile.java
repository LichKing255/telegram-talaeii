package org.telegram.tgnet;

import org.telegram.tgnet.TLRPC.TL_cdnFileHash;

public class TLRPC$TL_upload_reuploadCdnFile extends TLObject {
    public static int constructor = 452533257;
    public byte[] file_token;
    public byte[] request_token;

    public TLObject deserializeResponse(AbstractSerializedData abstractSerializedData, int i, boolean z) {
        TLObject tLRPC$Vector = new TLRPC$Vector();
        int readInt32 = abstractSerializedData.readInt32(z);
        for (int i2 = 0; i2 < readInt32; i2++) {
            TL_cdnFileHash TLdeserialize = TL_cdnFileHash.TLdeserialize(abstractSerializedData, abstractSerializedData.readInt32(z), z);
            if (TLdeserialize == null) {
                break;
            }
            tLRPC$Vector.objects.add(TLdeserialize);
        }
        return tLRPC$Vector;
    }

    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        abstractSerializedData.writeByteArray(this.file_token);
        abstractSerializedData.writeByteArray(this.request_token);
    }
}
