package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.ads.internal.client.zzs;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzdfj extends zzdij implements zzddu, zzdez {
    private final zzfdk zzb;
    private final AtomicBoolean zzc = new AtomicBoolean();

    public zzdfj(Set set, zzfdk zzfdk) {
        super(set);
        this.zzb = zzfdk;
    }

    private final void zzb() {
        zzs zzs;
        if (((Boolean) zzay.zzc().zzb(zzbjc.zzgI)).booleanValue() && this.zzc.compareAndSet(false, true) && (zzs = this.zzb.zzag) != null && zzs.zza == 3) {
            zzo(new zzdfi(this));
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zza(zzdfl zzdfl) throws Exception {
        zzdfl.zzg(this.zzb.zzag);
    }

    public final void zzh() {
        if (this.zzb.zzb == 1) {
            zzb();
        }
    }

    public final void zzl() {
        int i = this.zzb.zzb;
        if (i == 2 || i == 5 || i == 4 || i == 6 || i == 7) {
            zzb();
        }
    }
}
