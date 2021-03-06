package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.internal.view.SupportMenu;
import com.google.android.gms.common.internal.Hide;

@Hide
public final class zzdlg implements Creator<zzdlf> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int i = 0;
        int zzd = zzbgm.zzd(parcel);
        float f = 0.0f;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (parcel.dataPosition() < zzd) {
            int readInt = parcel.readInt();
            switch (SupportMenu.USER_MASK & readInt) {
                case 2:
                    i4 = zzbgm.zzg(parcel, readInt);
                    break;
                case 3:
                    i3 = zzbgm.zzg(parcel, readInt);
                    break;
                case 4:
                    i2 = zzbgm.zzg(parcel, readInt);
                    break;
                case 5:
                    i = zzbgm.zzg(parcel, readInt);
                    break;
                case 6:
                    f = zzbgm.zzl(parcel, readInt);
                    break;
                default:
                    zzbgm.zzb(parcel, readInt);
                    break;
            }
        }
        zzbgm.zzaf(parcel, zzd);
        return new zzdlf(i4, i3, i2, i, f);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zzdlf[i];
    }
}
