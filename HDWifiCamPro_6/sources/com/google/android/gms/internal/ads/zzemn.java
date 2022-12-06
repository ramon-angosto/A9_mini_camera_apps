package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzemn implements zzehc {
    private final zzbjx zza;
    private final zzfzq zzb;
    private final zzfih zzc;
    /* access modifiers changed from: private */
    public final zzemw zzd;

    public zzemn(zzfih zzfih, zzfzq zzfzq, zzbjx zzbjx, zzemw zzemw, byte[] bArr) {
        this.zzc = zzfih;
        this.zzb = zzfzq;
        this.zza = zzbjx;
        this.zzd = zzemw;
    }

    public final zzfzp zza(zzfdw zzfdw, zzfdk zzfdk) {
        zzchh zzchh = new zzchh();
        zzems zzems = new zzems();
        zzems.zzd(new zzemm(this, zzchh, zzfdw, zzfdk, zzems));
        zzfdp zzfdp = zzfdk.zzt;
        zzbjs zzbjs = new zzbjs(zzems, zzfdp.zzb, zzfdp.zza);
        zzfih zzfih = this.zzc;
        return zzfhr.zzd(new zzeml(this, zzbjs), this.zzb, zzfib.CUSTOM_RENDER_SYN, zzfih).zzb(zzfib.CUSTOM_RENDER_ACK).zzd(zzchh).zza();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r1 = r2.zzt;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zzb(com.google.android.gms.internal.ads.zzfdw r1, com.google.android.gms.internal.ads.zzfdk r2) {
        /*
            r0 = this;
            com.google.android.gms.internal.ads.zzbjx r1 = r0.zza
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
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzemn.zzb(com.google.android.gms.internal.ads.zzfdw, com.google.android.gms.internal.ads.zzfdk):boolean");
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzc(zzbjs zzbjs) throws Exception {
        this.zza.zze(zzbjs);
    }
}
