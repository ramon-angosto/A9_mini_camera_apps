package com.google.firebase.iid;

import android.os.IBinder;

/* compiled from: com.google.firebase:firebase-iid@@20.0.0 */
final /* synthetic */ class zzab implements Runnable {
    private final zzw zza;
    private final IBinder zzb;

    zzab(zzw zzw, IBinder iBinder) {
        this.zza = zzw;
        this.zzb = iBinder;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x001e, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0020, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0021, code lost:
        r0.zza(0, r1.getMessage());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0029, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x002b, code lost:
        throw r1;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:5:0x000a, B:9:0x000f] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
            r4 = this;
            com.google.firebase.iid.zzw r0 = r4.zza
            android.os.IBinder r1 = r4.zzb
            monitor-enter(r0)
            r2 = 0
            if (r1 != 0) goto L_0x000f
            java.lang.String r1 = "Null service connection"
            r0.zza(r2, r1)     // Catch:{ all -> 0x001e }
            monitor-exit(r0)     // Catch:{ all -> 0x001e }
            return
        L_0x000f:
            com.google.firebase.iid.zzaf r3 = new com.google.firebase.iid.zzaf     // Catch:{ RemoteException -> 0x0020 }
            r3.<init>(r1)     // Catch:{ RemoteException -> 0x0020 }
            r0.zzc = r3     // Catch:{ RemoteException -> 0x0020 }
            r1 = 2
            r0.zza = r1     // Catch:{ all -> 0x001e }
            r0.zza()     // Catch:{ all -> 0x001e }
            monitor-exit(r0)     // Catch:{ all -> 0x001e }
            return
        L_0x001e:
            r1 = move-exception
            goto L_0x002a
        L_0x0020:
            r1 = move-exception
            java.lang.String r1 = r1.getMessage()     // Catch:{ all -> 0x001e }
            r0.zza(r2, r1)     // Catch:{ all -> 0x001e }
            monitor-exit(r0)     // Catch:{ all -> 0x001e }
            return
        L_0x002a:
            monitor-exit(r0)     // Catch:{ all -> 0x001e }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.iid.zzab.run():void");
    }
}
