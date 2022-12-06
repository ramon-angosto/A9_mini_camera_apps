package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzfgs {
    private final zzfgl zza;
    private final zzfzp zzb;
    private boolean zzc = false;
    private boolean zzd = false;

    public zzfgs(zzffq zzffq, zzfgk zzfgk, zzfgl zzfgl) {
        this.zza = zzfgl;
        this.zzb = zzfzg.zzg(zzfzg.zzn(zzfgk.zza(zzfgl), new zzfgq(this, zzfgk, zzffq, zzfgl), zzfgl.zzb()), Exception.class, new zzfgr(this, zzfgk), zzfgl.zzb());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0032, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0034, code lost:
        return null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized com.google.android.gms.internal.ads.zzfzp zza(com.google.android.gms.internal.ads.zzfgl r3) {
        /*
            r2 = this;
            monitor-enter(r2)
            boolean r0 = r2.zzd     // Catch:{ all -> 0x0035 }
            r1 = 0
            if (r0 != 0) goto L_0x0033
            boolean r0 = r2.zzc     // Catch:{ all -> 0x0035 }
            if (r0 == 0) goto L_0x000b
            goto L_0x0033
        L_0x000b:
            com.google.android.gms.internal.ads.zzfgl r0 = r2.zza     // Catch:{ all -> 0x0035 }
            com.google.android.gms.internal.ads.zzfga r0 = r0.zza()     // Catch:{ all -> 0x0035 }
            if (r0 == 0) goto L_0x0031
            com.google.android.gms.internal.ads.zzfga r0 = r3.zza()     // Catch:{ all -> 0x0035 }
            if (r0 == 0) goto L_0x0031
            com.google.android.gms.internal.ads.zzfgl r0 = r2.zza     // Catch:{ all -> 0x0035 }
            com.google.android.gms.internal.ads.zzfga r0 = r0.zza()     // Catch:{ all -> 0x0035 }
            com.google.android.gms.internal.ads.zzfga r3 = r3.zza()     // Catch:{ all -> 0x0035 }
            boolean r3 = r0.equals(r3)     // Catch:{ all -> 0x0035 }
            if (r3 != 0) goto L_0x002a
            goto L_0x0031
        L_0x002a:
            r3 = 1
            r2.zzc = r3     // Catch:{ all -> 0x0035 }
            com.google.android.gms.internal.ads.zzfzp r3 = r2.zzb     // Catch:{ all -> 0x0035 }
            monitor-exit(r2)
            return r3
        L_0x0031:
            monitor-exit(r2)
            return r1
        L_0x0033:
            monitor-exit(r2)
            return r1
        L_0x0035:
            r3 = move-exception
            monitor-exit(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzfgs.zza(com.google.android.gms.internal.ads.zzfgl):com.google.android.gms.internal.ads.zzfzp");
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzfzp zzb(zzfgk zzfgk, zzffq zzffq, zzfgl zzfgl, zzffz zzffz) throws Exception {
        synchronized (this) {
            this.zzd = true;
            zzfgk.zzb(zzffz);
            if (!this.zzc) {
                zzffq.zzd(zzfgl.zza(), zzffz);
                zzfzp zzi = zzfzg.zzi((Object) null);
                return zzi;
            }
            zzfzp zzi2 = zzfzg.zzi(new zzfgj(zzffz, zzfgl));
            return zzi2;
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzfzp zzc(zzfgk zzfgk, Exception exc) throws Exception {
        synchronized (this) {
            this.zzd = true;
            throw exc;
        }
    }

    public final synchronized void zzd(zzfzc zzfzc) {
        zzfzg.zzr(zzfzg.zzn(this.zzb, zzfgp.zza, this.zza.zzb()), zzfzc, this.zza.zzb());
    }
}
