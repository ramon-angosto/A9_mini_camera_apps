package com.google.firebase.iid;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.common.util.concurrent.NamedThreadFactory;
import com.google.android.gms.internal.firebase_messaging.zza;
import com.google.android.gms.internal.firebase_messaging.zzf;
import com.google.android.gms.tasks.Task;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.firebase:firebase-iid@@20.0.0 */
public final class zzv {
    private static zzv zza;
    /* access modifiers changed from: private */
    public final Context zzb;
    /* access modifiers changed from: private */
    public final ScheduledExecutorService zzc;
    private zzw zzd = new zzw(this);
    private int zze = 1;

    public static synchronized zzv zza(Context context) {
        zzv zzv;
        synchronized (zzv.class) {
            if (zza == null) {
                zza = new zzv(context, zza.zza().zza(1, new NamedThreadFactory("MessengerIpcClient"), zzf.zza));
            }
            zzv = zza;
        }
        return zzv;
    }

    private zzv(Context context, ScheduledExecutorService scheduledExecutorService) {
        this.zzc = scheduledExecutorService;
        this.zzb = context.getApplicationContext();
    }

    public final Task<Void> zza(int i, Bundle bundle) {
        return zza(new zzae(zza(), 2, bundle));
    }

    public final Task<Bundle> zzb(int i, Bundle bundle) {
        return zza(new zzaj(zza(), 1, bundle));
    }

    private final synchronized <T> Task<T> zza(zzah<T> zzah) {
        if (Log.isLoggable("MessengerIpcClient", 3)) {
            String valueOf = String.valueOf(zzah);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 9);
            sb.append("Queueing ");
            sb.append(valueOf);
            Log.d("MessengerIpcClient", sb.toString());
        }
        if (!this.zzd.zza((zzah<?>) zzah)) {
            this.zzd = new zzw(this);
            this.zzd.zza((zzah<?>) zzah);
        }
        return zzah.zzb.getTask();
    }

    private final synchronized int zza() {
        int i;
        i = this.zze;
        this.zze = i + 1;
        return i;
    }
}
