package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.internal.view.SupportMenu;
import com.google.android.gms.common.internal.Hide;
import com.google.android.gms.internal.zzbgm;

@Hide
public final class zzda implements Creator<DataItemAssetParcelable> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        String str = null;
        int zzd = zzbgm.zzd(parcel);
        String str2 = null;
        while (parcel.dataPosition() < zzd) {
            int readInt = parcel.readInt();
            switch (SupportMenu.USER_MASK & readInt) {
                case 2:
                    str2 = zzbgm.zzq(parcel, readInt);
                    break;
                case 3:
                    str = zzbgm.zzq(parcel, readInt);
                    break;
                default:
                    zzbgm.zzb(parcel, readInt);
                    break;
            }
        }
        zzbgm.zzaf(parcel, zzd);
        return new DataItemAssetParcelable(str2, str);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new DataItemAssetParcelable[i];
    }
}
