package com.google.android.gms.internal.ads;

import android.os.Handler;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzej implements zzdn {
    private static final List zza = new ArrayList(50);
    private final Handler zzb;

    public zzej(Handler handler) {
        this.zzb = handler;
    }

    static /* bridge */ /* synthetic */ void zzk(zzei zzei) {
        synchronized (zza) {
            if (zza.size() < 50) {
                zza.add(zzei);
            }
        }
    }

    private static zzei zzl() {
        zzei zzei;
        synchronized (zza) {
            if (zza.isEmpty()) {
                zzei = new zzei((zzeh) null);
            } else {
                List list = zza;
                zzei = (zzei) list.remove(list.size() - 1);
            }
        }
        return zzei;
    }

    public final zzdm zza(int i) {
        zzei zzl = zzl();
        zzl.zzb(this.zzb.obtainMessage(i), this);
        return zzl;
    }

    public final zzdm zzb(int i, Object obj) {
        zzei zzl = zzl();
        zzl.zzb(this.zzb.obtainMessage(i, obj), this);
        return zzl;
    }

    public final zzdm zzc(int i, int i2, int i3) {
        zzei zzl = zzl();
        zzl.zzb(this.zzb.obtainMessage(1, i2, i3), this);
        return zzl;
    }

    public final void zzd(Object obj) {
        this.zzb.removeCallbacksAndMessages((Object) null);
    }

    public final void zze(int i) {
        this.zzb.removeMessages(2);
    }

    public final boolean zzf(int i) {
        return this.zzb.hasMessages(0);
    }

    public final boolean zzg(Runnable runnable) {
        return this.zzb.post(runnable);
    }

    public final boolean zzh(int i) {
        return this.zzb.sendEmptyMessage(i);
    }

    public final boolean zzi(int i, long j) {
        return this.zzb.sendEmptyMessageAtTime(2, j);
    }

    public final boolean zzj(zzdm zzdm) {
        return ((zzei) zzdm).zzc(this.zzb);
    }
}
