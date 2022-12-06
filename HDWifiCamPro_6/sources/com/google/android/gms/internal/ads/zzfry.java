package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzfry {
    private static final Map zza = new HashMap();
    /* access modifiers changed from: private */
    public final Context zzb;
    /* access modifiers changed from: private */
    public final zzfrn zzc;
    private final String zzd;
    /* access modifiers changed from: private */
    public final List zze = new ArrayList();
    private final Set zzf = new HashSet();
    private final Object zzg = new Object();
    /* access modifiers changed from: private */
    public boolean zzh;
    private final Intent zzi;
    private final WeakReference zzj;
    private final IBinder.DeathRecipient zzk = new zzfrq(this);
    private final AtomicInteger zzl = new AtomicInteger(0);
    /* access modifiers changed from: private */
    public ServiceConnection zzm;
    /* access modifiers changed from: private */
    public IInterface zzn;
    private final zzfqv zzo;

    public zzfry(Context context, zzfrn zzfrn, String str, Intent intent, zzfqv zzfqv, zzfrt zzfrt, byte[] bArr) {
        this.zzb = context;
        this.zzc = zzfrn;
        this.zzd = "OverlayDisplayService";
        this.zzi = intent;
        this.zzo = zzfqv;
        this.zzj = new WeakReference((Object) null);
    }

    public static /* synthetic */ void zzh(zzfry zzfry) {
        zzfry.zzc.zzd("reportBinderDeath", new Object[0]);
        zzfrt zzfrt = (zzfrt) zzfry.zzj.get();
        if (zzfrt != null) {
            zzfry.zzc.zzd("calling onBinderDied", new Object[0]);
            zzfrt.zza();
        } else {
            zzfry.zzc.zzd("%s : Binder has died.", zzfry.zzd);
            for (zzfro zzc2 : zzfry.zze) {
                zzc2.zzc(zzfry.zzs());
            }
            zzfry.zze.clear();
        }
        zzfry.zzt();
    }

    static /* bridge */ /* synthetic */ void zzn(zzfry zzfry) {
        zzfry.zzc.zzd("linkToDeath", new Object[0]);
        try {
            zzfry.zzn.asBinder().linkToDeath(zzfry.zzk, 0);
        } catch (RemoteException e) {
            zzfry.zzc.zzc(e, "linkToDeath failed", new Object[0]);
        }
    }

    static /* bridge */ /* synthetic */ void zzo(zzfry zzfry) {
        zzfry.zzc.zzd("unlinkToDeath", new Object[0]);
        zzfry.zzn.asBinder().unlinkToDeath(zzfry.zzk, 0);
    }

    private final RemoteException zzs() {
        return new RemoteException(String.valueOf(this.zzd).concat(" : Binder has died."));
    }

    /* access modifiers changed from: private */
    public final void zzt() {
        synchronized (this.zzg) {
            for (TaskCompletionSource trySetException : this.zzf) {
                trySetException.trySetException(zzs());
            }
            this.zzf.clear();
        }
    }

    public final Handler zzc() {
        Handler handler;
        synchronized (zza) {
            if (!zza.containsKey(this.zzd)) {
                HandlerThread handlerThread = new HandlerThread(this.zzd, 10);
                handlerThread.start();
                zza.put(this.zzd, new Handler(handlerThread.getLooper()));
            }
            handler = (Handler) zza.get(this.zzd);
        }
        return handler;
    }

    public final IInterface zze() {
        return this.zzn;
    }

    public final void zzp(zzfro zzfro, TaskCompletionSource taskCompletionSource) {
        synchronized (this.zzg) {
            this.zzf.add(taskCompletionSource);
            taskCompletionSource.getTask().addOnCompleteListener(new zzfrp(this, taskCompletionSource));
        }
        synchronized (this.zzg) {
            if (this.zzl.getAndIncrement() > 0) {
                this.zzc.zza("Already connected to the service.", new Object[0]);
            }
        }
        zzc().post(new zzfrr(this, zzfro.zzb(), zzfro));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzq(TaskCompletionSource taskCompletionSource, Task task) {
        synchronized (this.zzg) {
            this.zzf.remove(taskCompletionSource);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0021, code lost:
        zzc().post(new com.google.android.gms.internal.ads.zzfrs(r4));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x002d, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzr() {
        /*
            r4 = this;
            java.lang.Object r0 = r4.zzg
            monitor-enter(r0)
            java.util.concurrent.atomic.AtomicInteger r1 = r4.zzl     // Catch:{ all -> 0x002e }
            int r1 = r1.get()     // Catch:{ all -> 0x002e }
            if (r1 <= 0) goto L_0x0020
            java.util.concurrent.atomic.AtomicInteger r1 = r4.zzl     // Catch:{ all -> 0x002e }
            int r1 = r1.decrementAndGet()     // Catch:{ all -> 0x002e }
            if (r1 > 0) goto L_0x0014
            goto L_0x0020
        L_0x0014:
            com.google.android.gms.internal.ads.zzfrn r1 = r4.zzc     // Catch:{ all -> 0x002e }
            java.lang.String r2 = "Leaving the connection open for other ongoing calls."
            r3 = 0
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch:{ all -> 0x002e }
            r1.zzd(r2, r3)     // Catch:{ all -> 0x002e }
            monitor-exit(r0)     // Catch:{ all -> 0x002e }
            return
        L_0x0020:
            monitor-exit(r0)     // Catch:{ all -> 0x002e }
            com.google.android.gms.internal.ads.zzfrs r0 = new com.google.android.gms.internal.ads.zzfrs
            r0.<init>(r4)
            android.os.Handler r1 = r4.zzc()
            r1.post(r0)
            return
        L_0x002e:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x002e }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzfry.zzr():void");
    }

    static /* bridge */ /* synthetic */ void zzm(zzfry zzfry, zzfro zzfro) {
        if (zzfry.zzn == null && !zzfry.zzh) {
            zzfry.zzc.zzd("Initiate binding to the service.", new Object[0]);
            zzfry.zze.add(zzfro);
            zzfry.zzm = new zzfrx(zzfry, (zzfrw) null);
            zzfry.zzh = true;
            if (!zzfry.zzb.bindService(zzfry.zzi, zzfry.zzm, 1)) {
                zzfry.zzc.zzd("Failed to bind to the service.", new Object[0]);
                zzfry.zzh = false;
                for (zzfro zzc2 : zzfry.zze) {
                    zzc2.zzc(new zzfrz());
                }
                zzfry.zze.clear();
            }
        } else if (zzfry.zzh) {
            zzfry.zzc.zzd("Waiting to bind to the service.", new Object[0]);
            zzfry.zze.add(zzfro);
        } else {
            zzfro.run();
        }
    }
}
