package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzemi implements zzehc {
    private final Context zza;
    private final zzcxz zzb;
    private final zzbjx zzc;
    private final zzfzq zzd;
    private final zzfih zze;

    public zzemi(Context context, zzcxz zzcxz, zzfih zzfih, zzfzq zzfzq, zzbjx zzbjx) {
        this.zza = context;
        this.zzb = zzcxz;
        this.zze = zzfih;
        this.zzd = zzfzq;
        this.zzc = zzbjx;
    }

    public final zzfzp zza(zzfdw zzfdw, zzfdk zzfdk) {
        zzcxd zza2 = this.zzb.zza(new zzczt(zzfdw, zzfdk, (String) null), new zzemg(this, new View(this.zza), (zzcmp) null, zzeme.zza, (zzfdl) zzfdk.zzv.get(0)));
        zzemh zzk = zza2.zzk();
        zzfdp zzfdp = zzfdk.zzt;
        zzbjs zzbjs = new zzbjs(zzk, zzfdp.zzb, zzfdp.zza);
        zzfih zzfih = this.zze;
        return zzfhr.zzd(new zzemf(this, zzbjs), this.zzd, zzfib.CUSTOM_RENDER_SYN, zzfih).zzb(zzfib.CUSTOM_RENDER_ACK).zzd(zzfzg.zzi(zza2.zza())).zza();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r1 = r2.zzt;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zzb(com.google.android.gms.internal.ads.zzfdw r1, com.google.android.gms.internal.ads.zzfdk r2) {
        /*
            r0 = this;
            com.google.android.gms.internal.ads.zzbjx r1 = r0.zzc
            if (r1 == 0) goto L_0x000e
            com.google.android.gms.internal.ads.zzfdp r1 = r2.zzt
            if (r1 == 0) goto L_0x000e
            java.lang.String r1 = r1.zza
            if (r1 == 0) goto L_0x000e
            r1 = 1
            return r1
        L_0x000e:
            r1 = 0
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzemi.zzb(com.google.android.gms.internal.ads.zzfdw, com.google.android.gms.internal.ads.zzfdk):boolean");
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzc(zzbjs zzbjs) throws Exception {
        this.zzc.zze(zzbjs);
    }
}
