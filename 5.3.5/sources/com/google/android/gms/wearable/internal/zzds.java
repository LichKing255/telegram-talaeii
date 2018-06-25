package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.internal.view.SupportMenu;
import com.google.android.gms.common.internal.Hide;
import com.google.android.gms.internal.zzbgm;

@Hide
public final class zzds implements Creator<zzdt> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        boolean z = false;
        int zzd = zzbgm.zzd(parcel);
        boolean z2 = false;
        int i = 0;
        while (parcel.dataPosition() < zzd) {
            int readInt = parcel.readInt();
            switch (SupportMenu.USER_MASK & readInt) {
                case 2:
                    i = zzbgm.zzg(parcel, readInt);
                    break;
                case 3:
                    z2 = zzbgm.zzc(parcel, readInt);
                    break;
                case 4:
                    z = zzbgm.zzc(parcel, readInt);
                    break;
                default:
                    zzbgm.zzb(parcel, readInt);
                    break;
            }
        }
        zzbgm.zzaf(parcel, zzd);
        return new zzdt(i, z2, z);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zzdt[i];
    }
}
