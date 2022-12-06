package com.google.android.gms.internal.ads;

import javax.annotation.CheckForNull;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
abstract class zzfxw extends zzfyw implements Runnable {
    @CheckForNull
    zzfzp zza;
    @CheckForNull
    Class zzb;
    @CheckForNull
    Object zzc;

    zzfxw(zzfzp zzfzp, Class cls, Object obj) {
        if (zzfzp != null) {
            this.zza = zzfzp;
            this.zzb = cls;
            if (obj != null) {
                this.zzc = obj;
                return;
            }
            throw null;
        }
        throw null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x0074  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0078  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
            r8 = this;
            com.google.android.gms.internal.ads.zzfzp r0 = r8.zza
            java.lang.Class r1 = r8.zzb
            java.lang.Object r2 = r8.zzc
            r3 = 1
            r4 = 0
            if (r0 != 0) goto L_0x000c
            r5 = r3
            goto L_0x000d
        L_0x000c:
            r5 = r4
        L_0x000d:
            if (r1 != 0) goto L_0x0011
            r6 = r3
            goto L_0x0012
        L_0x0011:
            r6 = r4
        L_0x0012:
            r5 = r5 | r6
            if (r2 != 0) goto L_0x0016
            goto L_0x0017
        L_0x0016:
            r3 = r4
        L_0x0017:
            r3 = r3 | r5
            if (r3 != 0) goto L_0x009f
            boolean r3 = r8.isCancelled()
            if (r3 == 0) goto L_0x0022
            goto L_0x009f
        L_0x0022:
            r3 = 0
            r8.zza = r3
            boolean r4 = r0 instanceof com.google.android.gms.internal.ads.zzgai     // Catch:{ ExecutionException -> 0x003e, RuntimeException -> 0x003b, Error -> 0x0039 }
            if (r4 == 0) goto L_0x0031
            r4 = r0
            com.google.android.gms.internal.ads.zzgai r4 = (com.google.android.gms.internal.ads.zzgai) r4     // Catch:{ ExecutionException -> 0x003e, RuntimeException -> 0x003b, Error -> 0x0039 }
            java.lang.Throwable r4 = r4.zzp()     // Catch:{ ExecutionException -> 0x003e, RuntimeException -> 0x003b, Error -> 0x0039 }
            goto L_0x0032
        L_0x0031:
            r4 = r3
        L_0x0032:
            if (r4 != 0) goto L_0x003c
            java.lang.Object r5 = com.google.android.gms.internal.ads.zzfzg.zzp(r0)     // Catch:{ ExecutionException -> 0x003e, RuntimeException -> 0x003b, Error -> 0x0039 }
            goto L_0x0072
        L_0x0039:
            r4 = move-exception
            goto L_0x003c
        L_0x003b:
            r4 = move-exception
        L_0x003c:
            r5 = r3
            goto L_0x0072
        L_0x003e:
            r4 = move-exception
            java.lang.Throwable r5 = r4.getCause()
            if (r5 != 0) goto L_0x0070
            java.lang.NullPointerException r5 = new java.lang.NullPointerException
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = "Future type "
            r6.append(r7)
            java.lang.Class r7 = r0.getClass()
            r6.append(r7)
            java.lang.String r7 = " threw "
            r6.append(r7)
            java.lang.Class r4 = r4.getClass()
            r6.append(r4)
            java.lang.String r4 = " without a cause"
            r6.append(r4)
            java.lang.String r4 = r6.toString()
            r5.<init>(r4)
        L_0x0070:
            r4 = r5
            goto L_0x003c
        L_0x0072:
            if (r4 != 0) goto L_0x0078
            r8.zzd(r5)
            return
        L_0x0078:
            boolean r1 = r1.isInstance(r4)
            if (r1 == 0) goto L_0x009c
            java.lang.Object r0 = r8.zzf(r2, r4)     // Catch:{ all -> 0x008a }
            r8.zzb = r3
            r8.zzc = r3
            r8.zzg(r0)
            return
        L_0x008a:
            r0 = move-exception
            com.google.android.gms.internal.ads.zzfzx.zza(r0)     // Catch:{ all -> 0x0096 }
            r8.zze(r0)     // Catch:{ all -> 0x0096 }
            r8.zzb = r3
            r8.zzc = r3
            return
        L_0x0096:
            r0 = move-exception
            r8.zzb = r3
            r8.zzc = r3
            throw r0
        L_0x009c:
            r8.zzt(r0)
        L_0x009f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzfxw.run():void");
    }

    /* access modifiers changed from: protected */
    @CheckForNull
    public final String zza() {
        String str;
        zzfzp zzfzp = this.zza;
        Class cls = this.zzb;
        Object obj = this.zzc;
        String zza2 = super.zza();
        if (zzfzp != null) {
            str = "inputFuture=[" + zzfzp + "], ";
        } else {
            str = "";
        }
        if (cls != null && obj != null) {
            return str + "exceptionType=[" + cls + "], fallback=[" + obj + "]";
        } else if (zza2 != null) {
            return str.concat(zza2);
        } else {
            return null;
        }
    }

    /* access modifiers changed from: protected */
    public final void zzb() {
        zzs(this.zza);
        this.zza = null;
        this.zzb = null;
        this.zzc = null;
    }

    /* access modifiers changed from: package-private */
    public abstract Object zzf(Object obj, Throwable th) throws Exception;

    /* access modifiers changed from: package-private */
    public abstract void zzg(Object obj);
}
