package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public class zzgru {
    private static final zzgqq zzb = zzgqq.zza();
    protected volatile zzgso zza;
    private volatile zzgpw zzc;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzgru)) {
            return false;
        }
        zzgru zzgru = (zzgru) obj;
        zzgso zzgso = this.zza;
        zzgso zzgso2 = zzgru.zza;
        if (zzgso == null && zzgso2 == null) {
            return zzb().equals(zzgru.zzb());
        }
        if (zzgso != null && zzgso2 != null) {
            return zzgso.equals(zzgso2);
        }
        if (zzgso != null) {
            zzgru.zzc(zzgso.zzbh());
            return zzgso.equals(zzgru.zza);
        }
        zzc(zzgso2.zzbh());
        return this.zza.equals(zzgso2);
    }

    public int hashCode() {
        return 1;
    }

    public final int zza() {
        if (this.zzc != null) {
            return ((zzgps) this.zzc).zza.length;
        }
        if (this.zza != null) {
            return this.zza.zzay();
        }
        return 0;
    }

    public final zzgpw zzb() {
        if (this.zzc != null) {
            return this.zzc;
        }
        synchronized (this) {
            if (this.zzc != null) {
                zzgpw zzgpw = this.zzc;
                return zzgpw;
            }
            if (this.zza == null) {
                this.zzc = zzgpw.zzb;
            } else {
                this.zzc = this.zza.zzat();
            }
            zzgpw zzgpw2 = this.zzc;
            return zzgpw2;
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Can't wrap try/catch for region: R(4:7|8|9|10) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0011 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzc(com.google.android.gms.internal.ads.zzgso r2) {
        /*
            r1 = this;
            com.google.android.gms.internal.ads.zzgso r0 = r1.zza
            if (r0 == 0) goto L_0x0005
            return
        L_0x0005:
            monitor-enter(r1)
            com.google.android.gms.internal.ads.zzgso r0 = r1.zza     // Catch:{ all -> 0x001b }
            if (r0 != 0) goto L_0x0019
            r1.zza = r2     // Catch:{ zzgrq -> 0x0011 }
            com.google.android.gms.internal.ads.zzgpw r0 = com.google.android.gms.internal.ads.zzgpw.zzb     // Catch:{ zzgrq -> 0x0011 }
            r1.zzc = r0     // Catch:{ zzgrq -> 0x0011 }
            goto L_0x0017
        L_0x0011:
            r1.zza = r2     // Catch:{ all -> 0x001b }
            com.google.android.gms.internal.ads.zzgpw r2 = com.google.android.gms.internal.ads.zzgpw.zzb     // Catch:{ all -> 0x001b }
            r1.zzc = r2     // Catch:{ all -> 0x001b }
        L_0x0017:
            monitor-exit(r1)     // Catch:{ all -> 0x001b }
            return
        L_0x0019:
            monitor-exit(r1)     // Catch:{ all -> 0x001b }
            return
        L_0x001b:
            r2 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x001b }
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzgru.zzc(com.google.android.gms.internal.ads.zzgso):void");
    }
}
