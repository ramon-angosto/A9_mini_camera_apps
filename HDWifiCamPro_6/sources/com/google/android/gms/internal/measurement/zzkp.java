package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-base@@20.1.2 */
public class zzkp {
    private static final zzjo zzb = zzjo.zza();
    protected volatile zzlj zza;
    private volatile zzjb zzc;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzkp)) {
            return false;
        }
        zzkp zzkp = (zzkp) obj;
        zzlj zzlj = this.zza;
        zzlj zzlj2 = zzkp.zza;
        if (zzlj == null && zzlj2 == null) {
            return zzb().equals(zzkp.zzb());
        }
        if (zzlj != null && zzlj2 != null) {
            return zzlj.equals(zzlj2);
        }
        if (zzlj != null) {
            zzkp.zzc(zzlj.zzbR());
            return zzlj.equals(zzkp.zza);
        }
        zzc(zzlj2.zzbR());
        return this.zza.equals(zzlj2);
    }

    public int hashCode() {
        return 1;
    }

    public final int zza() {
        if (this.zzc != null) {
            return ((zziy) this.zzc).zza.length;
        }
        if (this.zza != null) {
            return this.zza.zzbz();
        }
        return 0;
    }

    public final zzjb zzb() {
        if (this.zzc != null) {
            return this.zzc;
        }
        synchronized (this) {
            if (this.zzc != null) {
                zzjb zzjb = this.zzc;
                return zzjb;
            }
            if (this.zza == null) {
                this.zzc = zzjb.zzb;
            } else {
                this.zzc = this.zza.zzbv();
            }
            zzjb zzjb2 = this.zzc;
            return zzjb2;
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Can't wrap try/catch for region: R(4:7|8|9|10) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0011 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzc(com.google.android.gms.internal.measurement.zzlj r2) {
        /*
            r1 = this;
            com.google.android.gms.internal.measurement.zzlj r0 = r1.zza
            if (r0 == 0) goto L_0x0005
            return
        L_0x0005:
            monitor-enter(r1)
            com.google.android.gms.internal.measurement.zzlj r0 = r1.zza     // Catch:{ all -> 0x001b }
            if (r0 != 0) goto L_0x0019
            r1.zza = r2     // Catch:{ zzkm -> 0x0011 }
            com.google.android.gms.internal.measurement.zzjb r0 = com.google.android.gms.internal.measurement.zzjb.zzb     // Catch:{ zzkm -> 0x0011 }
            r1.zzc = r0     // Catch:{ zzkm -> 0x0011 }
            goto L_0x0017
        L_0x0011:
            r1.zza = r2     // Catch:{ all -> 0x001b }
            com.google.android.gms.internal.measurement.zzjb r2 = com.google.android.gms.internal.measurement.zzjb.zzb     // Catch:{ all -> 0x001b }
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
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzkp.zzc(com.google.android.gms.internal.measurement.zzlj):void");
    }
}
