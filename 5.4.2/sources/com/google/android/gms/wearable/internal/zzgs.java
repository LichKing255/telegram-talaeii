package com.google.android.gms.wearable.internal;

import android.os.ParcelFileDescriptor.AutoCloseInputStream;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation.ResultHolder;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.wearable.Channel.GetInputStreamResult;
import java.io.InputStream;

final class zzgs extends zzgm<GetInputStreamResult> {
    private final zzbr zzeu;

    public zzgs(ResultHolder<GetInputStreamResult> resultHolder, zzbr zzbr) {
        super(resultHolder);
        this.zzeu = (zzbr) Preconditions.checkNotNull(zzbr);
    }

    public final void zza(zzdm zzdm) {
        InputStream inputStream = null;
        if (zzdm.zzdr != null) {
            inputStream = new zzbj(new AutoCloseInputStream(zzdm.zzdr));
            this.zzeu.zza(new zzbk(inputStream));
        }
        zza(new zzbg(new Status(zzdm.statusCode), inputStream));
    }
}
