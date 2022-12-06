package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Looper;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzed {
    private static zzed zza;
    private final Handler zzb = new Handler(Looper.getMainLooper());
    private final CopyOnWriteArrayList zzc = new CopyOnWriteArrayList();
    private final Object zzd = new Object();
    private int zze = 0;

    private zzed(Context context) {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        zzen.zzA(context, new zzec(this, (zzeb) null), intentFilter);
    }

    public static synchronized zzed zzb(Context context) {
        zzed zzed;
        synchronized (zzed.class) {
            if (zza == null) {
                zza = new zzed(context);
            }
            zzed = zza;
        }
        return zzed;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0016, code lost:
        if (r0.hasNext() == false) goto L_0x0032;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0018, code lost:
        r1 = (java.lang.ref.WeakReference) r0.next();
        r2 = (com.google.android.gms.internal.ads.zzwj) r1.get();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0024, code lost:
        if (r2 == null) goto L_0x002c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0026, code lost:
        com.google.android.gms.internal.ads.zzwl.zzh(r2.zza, r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x002c, code lost:
        r3.zzc.remove(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0032, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x000c, code lost:
        r0 = r3.zzc.iterator();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ void zzc(com.google.android.gms.internal.ads.zzed r3, int r4) {
        /*
            java.lang.Object r0 = r3.zzd
            monitor-enter(r0)
            int r1 = r3.zze     // Catch:{ all -> 0x0033 }
            if (r1 != r4) goto L_0x0009
            monitor-exit(r0)     // Catch:{ all -> 0x0033 }
            return
        L_0x0009:
            r3.zze = r4     // Catch:{ all -> 0x0033 }
            monitor-exit(r0)     // Catch:{ all -> 0x0033 }
            java.util.concurrent.CopyOnWriteArrayList r0 = r3.zzc
            java.util.Iterator r0 = r0.iterator()
        L_0x0012:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0032
            java.lang.Object r1 = r0.next()
            java.lang.ref.WeakReference r1 = (java.lang.ref.WeakReference) r1
            java.lang.Object r2 = r1.get()
            com.google.android.gms.internal.ads.zzwj r2 = (com.google.android.gms.internal.ads.zzwj) r2
            if (r2 == 0) goto L_0x002c
            com.google.android.gms.internal.ads.zzwl r1 = r2.zza
            r1.zzk(r4)
            goto L_0x0012
        L_0x002c:
            java.util.concurrent.CopyOnWriteArrayList r2 = r3.zzc
            r2.remove(r1)
            goto L_0x0012
        L_0x0032:
            return
        L_0x0033:
            r3 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0033 }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzed.zzc(com.google.android.gms.internal.ads.zzed, int):void");
    }

    public final int zza() {
        int i;
        synchronized (this.zzd) {
            i = this.zze;
        }
        return i;
    }

    public final void zzd(zzwj zzwj) {
        Iterator it = this.zzc.iterator();
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            if (weakReference.get() == null) {
                this.zzc.remove(weakReference);
            }
        }
        this.zzc.add(new WeakReference(zzwj));
        this.zzb.post(new zzdz(this, zzwj, (byte[]) null));
    }
}
