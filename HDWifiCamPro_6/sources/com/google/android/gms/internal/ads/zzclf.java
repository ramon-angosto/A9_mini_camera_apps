package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zze;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzclf extends zzclb {
    public zzclf(zzciy zzciy) {
        super(zzciy);
    }

    public final void zzb() {
    }

    public final boolean zzq(String str) {
        String zze = zzcgi.zze(str);
        zzciy zzciy = (zzciy) this.zzc.get();
        if (!(zzciy == null || zze == null)) {
            zzciy.zzv(zze, this);
        }
        zze.zzj("VideoStreamNoopCache is doing nothing.");
        zzc(str, zze, "noop", "Noop cache is a noop.");
        return false;
    }
}
