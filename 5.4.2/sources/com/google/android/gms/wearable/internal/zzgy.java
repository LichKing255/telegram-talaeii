package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.internal.BaseImplementation.ResultHolder;
import com.google.android.gms.wearable.NodeApi.GetLocalNodeResult;

final class zzgy extends zzgm<GetLocalNodeResult> {
    public zzgy(ResultHolder<GetLocalNodeResult> resultHolder) {
        super(resultHolder);
    }

    public final void zza(zzeg zzeg) {
        zza(new zzfk(zzgd.zzb(zzeg.statusCode), zzeg.zzea));
    }
}
