package org.telegram.tgnet;

import java.util.ArrayList;
import org.telegram.tgnet.TLRPC.Chat;
import org.telegram.tgnet.TLRPC.GroupCall;
import org.telegram.tgnet.TLRPC.GroupCallParticipant;
import org.telegram.tgnet.TLRPC.User;

public class TLRPC$TL_phone_groupCall extends TLObject {
    public static int constructor = 1731723191;
    public GroupCall call;
    public ArrayList<Chat> chats = new ArrayList();
    public ArrayList<GroupCallParticipant> participants = new ArrayList();
    public ArrayList<User> users = new ArrayList();

    public static TLRPC$TL_phone_groupCall TLdeserialize(AbstractSerializedData abstractSerializedData, int i, boolean z) {
        if (constructor == i) {
            TLRPC$TL_phone_groupCall tLRPC$TL_phone_groupCall = new TLRPC$TL_phone_groupCall();
            tLRPC$TL_phone_groupCall.readParams(abstractSerializedData, z);
            return tLRPC$TL_phone_groupCall;
        } else if (!z) {
            return null;
        } else {
            throw new RuntimeException(String.format("can't parse magic %x in TL_phone_groupCall", new Object[]{Integer.valueOf(i)}));
        }
    }

    public void readParams(AbstractSerializedData abstractSerializedData, boolean z) {
        int i = 0;
        this.call = GroupCall.TLdeserialize(abstractSerializedData, abstractSerializedData.readInt32(z), z);
        int i2;
        if (abstractSerializedData.readInt32(z) == 481674261) {
            int readInt32 = abstractSerializedData.readInt32(z);
            i2 = 0;
            while (i2 < readInt32) {
                GroupCallParticipant TLdeserialize = GroupCallParticipant.TLdeserialize(abstractSerializedData, abstractSerializedData.readInt32(z), z);
                if (TLdeserialize != null) {
                    this.participants.add(TLdeserialize);
                    i2++;
                } else {
                    return;
                }
            }
            if (abstractSerializedData.readInt32(z) == 481674261) {
                readInt32 = abstractSerializedData.readInt32(z);
                i2 = 0;
                while (i2 < readInt32) {
                    Chat TLdeserialize2 = Chat.TLdeserialize(abstractSerializedData, abstractSerializedData.readInt32(z), z);
                    if (TLdeserialize2 != null) {
                        this.chats.add(TLdeserialize2);
                        i2++;
                    } else {
                        return;
                    }
                }
                if (abstractSerializedData.readInt32(z) == 481674261) {
                    i2 = abstractSerializedData.readInt32(z);
                    while (i < i2) {
                        User TLdeserialize3 = User.TLdeserialize(abstractSerializedData, abstractSerializedData.readInt32(z), z);
                        if (TLdeserialize3 != null) {
                            this.users.add(TLdeserialize3);
                            i++;
                        } else {
                            return;
                        }
                    }
                } else if (z) {
                    throw new RuntimeException(String.format("wrong Vector magic, got %x", new Object[]{Integer.valueOf(i2)}));
                }
            } else if (z) {
                throw new RuntimeException(String.format("wrong Vector magic, got %x", new Object[]{Integer.valueOf(i2)}));
            }
        } else if (z) {
            throw new RuntimeException(String.format("wrong Vector magic, got %x", new Object[]{Integer.valueOf(i2)}));
        }
    }

    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        int i;
        int i2 = 0;
        abstractSerializedData.writeInt32(constructor);
        this.call.serializeToStream(abstractSerializedData);
        abstractSerializedData.writeInt32(481674261);
        int size = this.participants.size();
        abstractSerializedData.writeInt32(size);
        for (i = 0; i < size; i++) {
            ((GroupCallParticipant) this.participants.get(i)).serializeToStream(abstractSerializedData);
        }
        abstractSerializedData.writeInt32(481674261);
        size = this.chats.size();
        abstractSerializedData.writeInt32(size);
        for (i = 0; i < size; i++) {
            ((Chat) this.chats.get(i)).serializeToStream(abstractSerializedData);
        }
        abstractSerializedData.writeInt32(481674261);
        i = this.users.size();
        abstractSerializedData.writeInt32(i);
        while (i2 < i) {
            ((User) this.users.get(i2)).serializeToStream(abstractSerializedData);
            i2++;
        }
    }
}
