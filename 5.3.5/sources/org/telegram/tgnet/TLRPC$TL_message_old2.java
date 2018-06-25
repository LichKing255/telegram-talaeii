package org.telegram.tgnet;

public class TLRPC$TL_message_old2 extends TLRPC$TL_message {
    public static int constructor = 1450613171;

    public void readParams(AbstractSerializedData stream, boolean exception) {
        boolean z;
        boolean z2 = true;
        this.flags = (stream.readInt32(exception) | 256) | 512;
        this.unread = (this.flags & 1) != 0;
        if ((this.flags & 2) != 0) {
            z = true;
        } else {
            z = false;
        }
        this.out = z;
        if ((this.flags & 16) != 0) {
            z = true;
        } else {
            z = false;
        }
        this.mentioned = z;
        if ((this.flags & 32) == 0) {
            z2 = false;
        }
        this.media_unread = z2;
        this.id = stream.readInt32(exception);
        this.from_id = stream.readInt32(exception);
        this.to_id = TLRPC$Peer.TLdeserialize(stream, stream.readInt32(exception), exception);
        this.date = stream.readInt32(exception);
        this.message = stream.readString(exception);
        this.media = TLRPC$MessageMedia.TLdeserialize(stream, stream.readInt32(exception), exception);
        if (this.id < 0 || !(this.media == null || (this.media instanceof TLRPC$TL_messageMediaEmpty) || (this.media instanceof TLRPC$TL_messageMediaWebPage) || this.message == null || this.message.length() == 0 || !this.message.startsWith("-1"))) {
            this.attachPath = stream.readString(exception);
        }
    }

    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        this.flags = this.unread ? this.flags | 1 : this.flags & -2;
        this.flags = this.out ? this.flags | 2 : this.flags & -3;
        this.flags = this.mentioned ? this.flags | 16 : this.flags & -17;
        this.flags = this.media_unread ? this.flags | 32 : this.flags & -33;
        stream.writeInt32(this.flags);
        stream.writeInt32(this.id);
        stream.writeInt32(this.from_id);
        this.to_id.serializeToStream(stream);
        stream.writeInt32(this.date);
        stream.writeString(this.message);
        this.media.serializeToStream(stream);
        stream.writeString(this.attachPath);
    }
}
