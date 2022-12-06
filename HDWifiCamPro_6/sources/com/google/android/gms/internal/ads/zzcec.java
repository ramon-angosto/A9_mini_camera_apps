package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzcec implements zzbbq {
    private final Context zza;
    private final Object zzb;
    private final String zzc;
    private boolean zzd;

    public zzcec(Context context, String str) {
        this.zza = context.getApplicationContext() != null ? context.getApplicationContext() : context;
        this.zzc = str;
        this.zzd = false;
        this.zzb = new Object();
    }

    public final String zza() {
        return this.zzc;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x003e, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzb(boolean r4) {
        /*
            r3 = this;
            com.google.android.gms.internal.ads.zzceu r0 = com.google.android.gms.ads.internal.zzt.zzn()
            android.content.Context r1 = r3.zza
            boolean r0 = r0.zzu(r1)
            if (r0 != 0) goto L_0x000d
            return
        L_0x000d:
            java.lang.Object r0 = r3.zzb
            monitor-enter(r0)
            boolean r1 = r3.zzd     // Catch:{ all -> 0x003f }
            if (r1 != r4) goto L_0x0016
            monitor-exit(r0)     // Catch:{ all -> 0x003f }
            return
        L_0x0016:
            r3.zzd = r4     // Catch:{ all -> 0x003f }
            java.lang.String r4 = r3.zzc     // Catch:{ all -> 0x003f }
            boolean r4 = android.text.TextUtils.isEmpty(r4)     // Catch:{ all -> 0x003f }
            if (r4 == 0) goto L_0x0022
            monitor-exit(r0)     // Catch:{ all -> 0x003f }
            return
        L_0x0022:
            boolean r4 = r3.zzd     // Catch:{ all -> 0x003f }
            if (r4 == 0) goto L_0x0032
            com.google.android.gms.internal.ads.zzceu r4 = com.google.android.gms.ads.internal.zzt.zzn()     // Catch:{ all -> 0x003f }
            android.content.Context r1 = r3.zza     // Catch:{ all -> 0x003f }
            java.lang.String r2 = r3.zzc     // Catch:{ all -> 0x003f }
            r4.zzh(r1, r2)     // Catch:{ all -> 0x003f }
            goto L_0x003d
        L_0x0032:
            com.google.android.gms.internal.ads.zzceu r4 = com.google.android.gms.ads.internal.zzt.zzn()     // Catch:{ all -> 0x003f }
            android.content.Context r1 = r3.zza     // Catch:{ all -> 0x003f }
            java.lang.String r2 = r3.zzc     // Catch:{ all -> 0x003f }
            r4.zzi(r1, r2)     // Catch:{ all -> 0x003f }
        L_0x003d:
            monitor-exit(r0)     // Catch:{ all -> 0x003f }
            return
        L_0x003f:
            r4 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x003f }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcec.zzb(boolean):void");
    }

    public final void zzc(zzbbp zzbbp) {
        zzb(zzbbp.zzj);
    }
}
