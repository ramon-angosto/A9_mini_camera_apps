package com.google.firebase.messaging;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;
import com.google.android.gms.common.util.concurrent.NamedThreadFactory;
import com.google.android.gms.internal.firebase_messaging.zza;
import com.google.android.gms.internal.firebase_messaging.zzb;
import com.google.android.gms.internal.firebase_messaging.zzf;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.iid.zzaw;
import com.google.firebase.iid.zzaz;
import java.util.concurrent.ExecutorService;

/* compiled from: com.google.firebase:firebase-messaging@@20.0.0 */
public abstract class zzc extends Service {
    private final ExecutorService zza;
    private Binder zzb;
    private final Object zzc;
    private int zzd;
    private int zze;

    public zzc() {
        zzb zza2 = zza.zza();
        String valueOf = String.valueOf(getClass().getSimpleName());
        this.zza = zza2.zza(new NamedThreadFactory(valueOf.length() != 0 ? "Firebase-".concat(valueOf) : new String("Firebase-")), zzf.zza);
        this.zzc = new Object();
        this.zze = 0;
    }

    /* access modifiers changed from: protected */
    public Intent zza(Intent intent) {
        return intent;
    }

    public boolean zzb(Intent intent) {
        return false;
    }

    public abstract void zzc(Intent intent);

    public final synchronized IBinder onBind(Intent intent) {
        if (Log.isLoggable("EnhancedIntentService", 3)) {
            Log.d("EnhancedIntentService", "Service received bind request");
        }
        if (this.zzb == null) {
            this.zzb = new zzaz(new zzf(this));
        }
        return this.zzb;
    }

    /* access modifiers changed from: private */
    /* renamed from: zze */
    public final Task<Void> zzd(Intent intent) {
        if (zzb(intent)) {
            return Tasks.forResult(null);
        }
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.zza.execute(new zze(this, intent, taskCompletionSource));
        return taskCompletionSource.getTask();
    }

    public final int onStartCommand(Intent intent, int i, int i2) {
        synchronized (this.zzc) {
            this.zzd = i2;
            this.zze++;
        }
        Intent zza2 = zza(intent);
        if (zza2 == null) {
            zzf(intent);
            return 2;
        }
        Task<Void> zze2 = zzd(zza2);
        if (zze2.isComplete()) {
            zzf(intent);
            return 2;
        }
        zze2.addOnCompleteListener(zzh.zza, (OnCompleteListener<Void>) new zzg(this, intent));
        return 3;
    }

    public void onDestroy() {
        this.zza.shutdown();
        super.onDestroy();
    }

    private final void zzf(Intent intent) {
        if (intent != null) {
            zzaw.zza(intent);
        }
        synchronized (this.zzc) {
            this.zze--;
            if (this.zze == 0) {
                stopSelfResult(this.zzd);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zza(Intent intent, Task task) {
        zzf(intent);
    }
}
