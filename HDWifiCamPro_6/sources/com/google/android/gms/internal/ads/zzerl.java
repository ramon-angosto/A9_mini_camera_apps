package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzerl implements zzeve {
    private final zzfag zza;

    zzerl(zzfag zzfag) {
        this.zza = zzfag;
    }

    public final int zza() {
        return 15;
    }

    public final zzfzp zzb() {
        zzfag zzfag = this.zza;
        zzerk zzerk = null;
        if (!(zzfag == null || zzfag.zza() == null || zzfag.zza().isEmpty())) {
            zzerk = new zzerk(this);
        }
        return zzfzg.zzi(zzerk);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzc(Bundle bundle) {
        bundle.putString("key_schema", this.zza.zza());
    }
}
