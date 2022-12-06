package com.google.firebase.iid;

import android.content.Intent;
import com.google.android.gms.stats.WakeLock;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.firebase:firebase-iid@@20.0.0 */
public final class zzaw {
    private static final long zza = TimeUnit.MINUTES.toMillis(1);
    private static final Object zzb = new Object();
    private static WakeLock zzc;

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0031, code lost:
        return r4;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.content.ComponentName zza(android.content.Context r4, android.content.Intent r5) {
        /*
            java.lang.Object r0 = zzb
            monitor-enter(r0)
            com.google.android.gms.stats.WakeLock r1 = zzc     // Catch:{ all -> 0x0032 }
            r2 = 1
            if (r1 != 0) goto L_0x0014
            com.google.android.gms.stats.WakeLock r1 = new com.google.android.gms.stats.WakeLock     // Catch:{ all -> 0x0032 }
            java.lang.String r3 = "wake:com.google.firebase.iid.WakeLockHolder"
            r1.<init>(r4, r2, r3)     // Catch:{ all -> 0x0032 }
            zzc = r1     // Catch:{ all -> 0x0032 }
            r1.setReferenceCounted(r2)     // Catch:{ all -> 0x0032 }
        L_0x0014:
            java.lang.String r1 = "com.google.firebase.iid.WakeLockHolder.wakefulintent"
            r3 = 0
            boolean r1 = r5.getBooleanExtra(r1, r3)     // Catch:{ all -> 0x0032 }
            zza((android.content.Intent) r5, (boolean) r2)     // Catch:{ all -> 0x0032 }
            android.content.ComponentName r4 = r4.startService(r5)     // Catch:{ all -> 0x0032 }
            if (r4 != 0) goto L_0x0027
            r4 = 0
            monitor-exit(r0)     // Catch:{ all -> 0x0032 }
            return r4
        L_0x0027:
            if (r1 != 0) goto L_0x0030
            com.google.android.gms.stats.WakeLock r5 = zzc     // Catch:{ all -> 0x0032 }
            long r1 = zza     // Catch:{ all -> 0x0032 }
            r5.acquire(r1)     // Catch:{ all -> 0x0032 }
        L_0x0030:
            monitor-exit(r0)     // Catch:{ all -> 0x0032 }
            return r4
        L_0x0032:
            r4 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0032 }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.iid.zzaw.zza(android.content.Context, android.content.Intent):android.content.ComponentName");
    }

    private static void zza(Intent intent, boolean z) {
        intent.putExtra("com.google.firebase.iid.WakeLockHolder.wakefulintent", z);
    }

    public static void zza(Intent intent) {
        synchronized (zzb) {
            if (zzc != null && intent.getBooleanExtra("com.google.firebase.iid.WakeLockHolder.wakefulintent", false)) {
                zza(intent, false);
                zzc.release();
            }
        }
    }
}
