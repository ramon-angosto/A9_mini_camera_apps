package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-basement@@18.0.0 */
final class zzo implements ServiceConnection, zzs {
    final /* synthetic */ zzr zza;
    private final Map<ServiceConnection, ServiceConnection> zzb = new HashMap();
    private int zzc = 2;
    private boolean zzd;
    private IBinder zze;
    private final zzn zzf;
    private ComponentName zzg;

    public zzo(zzr zzr, zzn zzn) {
        this.zza = zzr;
        this.zzf = zzn;
    }

    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        synchronized (this.zza.zzb) {
            this.zza.zzd.removeMessages(1, this.zzf);
            this.zze = iBinder;
            this.zzg = componentName;
            for (ServiceConnection onServiceConnected : this.zzb.values()) {
                onServiceConnected.onServiceConnected(componentName, iBinder);
            }
            this.zzc = 1;
        }
    }

    public final void onServiceDisconnected(ComponentName componentName) {
        synchronized (this.zza.zzb) {
            this.zza.zzd.removeMessages(1, this.zzf);
            this.zze = null;
            this.zzg = componentName;
            for (ServiceConnection onServiceDisconnected : this.zzb.values()) {
                onServiceDisconnected.onServiceDisconnected(componentName);
            }
            this.zzc = 2;
        }
    }

    public final int zza() {
        return this.zzc;
    }

    public final ComponentName zzb() {
        return this.zzg;
    }

    public final IBinder zzc() {
        return this.zze;
    }

    public final void zzd(ServiceConnection serviceConnection, ServiceConnection serviceConnection2, String str) {
        this.zzb.put(serviceConnection, serviceConnection2);
    }

    public final void zze(String str, Executor executor) {
        this.zzc = 3;
        zzr zzr = this.zza;
        boolean zza2 = zzr.zzf.zza(zzr.zzc, str, this.zzf.zzc(zzr.zzc), this, this.zzf.zza(), executor);
        this.zzd = zza2;
        if (zza2) {
            this.zza.zzd.sendMessageDelayed(this.zza.zzd.obtainMessage(1, this.zzf), this.zza.zzh);
            return;
        }
        this.zzc = 2;
        try {
            zzr zzr2 = this.zza;
            zzr2.zzf.unbindService(zzr2.zzc, this);
        } catch (IllegalArgumentException unused) {
        }
    }

    public final void zzf(ServiceConnection serviceConnection, String str) {
        this.zzb.remove(serviceConnection);
    }

    public final void zzg(String str) {
        this.zza.zzd.removeMessages(1, this.zzf);
        zzr zzr = this.zza;
        zzr.zzf.unbindService(zzr.zzc, this);
        this.zzd = false;
        this.zzc = 2;
    }

    public final boolean zzh(ServiceConnection serviceConnection) {
        return this.zzb.containsKey(serviceConnection);
    }

    public final boolean zzi() {
        return this.zzb.isEmpty();
    }

    public final boolean zzj() {
        return this.zzd;
    }
}
