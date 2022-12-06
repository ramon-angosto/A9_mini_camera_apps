package com.google.android.gms.tasks;

import java.util.concurrent.ExecutionException;

/* compiled from: com.google.android.gms:play-services-tasks@@18.0.1 */
final class zzaf implements zzae {
    private final Object zza = new Object();
    private final int zzb;
    private final zzw<Void> zzc;
    private int zzd;
    private int zze;
    private int zzf;
    private Exception zzg;
    private boolean zzh;

    public zzaf(int i, zzw<Void> zzw) {
        this.zzb = i;
        this.zzc = zzw;
    }

    private final void zza() {
        int i = this.zzd;
        int i2 = this.zze;
        int i3 = i + i2 + this.zzf;
        int i4 = this.zzb;
        if (i3 != i4) {
            return;
        }
        if (this.zzg != null) {
            zzw<Void> zzw = this.zzc;
            StringBuilder sb = new StringBuilder(54);
            sb.append(i2);
            sb.append(" out of ");
            sb.append(i4);
            sb.append(" underlying tasks failed");
            zzw.zza(new ExecutionException(sb.toString(), this.zzg));
        } else if (this.zzh) {
            this.zzc.zzc();
        } else {
            this.zzc.zzb(null);
        }
    }

    public final void onCanceled() {
        synchronized (this.zza) {
            this.zzf++;
            this.zzh = true;
            zza();
        }
    }

    public final void onFailure(Exception exc) {
        synchronized (this.zza) {
            this.zze++;
            this.zzg = exc;
            zza();
        }
    }

    public final void onSuccess(Object obj) {
        synchronized (this.zza) {
            this.zzd++;
            zza();
        }
    }
}
