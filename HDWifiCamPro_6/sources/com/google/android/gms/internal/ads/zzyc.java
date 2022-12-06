package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.SystemClock;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzyc {
    private final Handler zza;
    private final zzyd zzb;

    public zzyc(Handler handler, zzyd zzyd) {
        this.zza = zzyd == null ? null : handler;
        this.zzb = zzyd;
    }

    public final void zza(String str, long j, long j2) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new zzxy(this, str, j, j2));
        }
    }

    public final void zzb(String str) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new zzyb(this, str));
        }
    }

    public final void zzc(zzgs zzgs) {
        zzgs.zza();
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new zzxx(this, zzgs));
        }
    }

    public final void zzd(int i, long j) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new zzxs(this, i, j));
        }
    }

    public final void zze(zzgs zzgs) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new zzxw(this, zzgs));
        }
    }

    public final void zzf(zzaf zzaf, zzgt zzgt) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new zzxz(this, zzaf, zzgt));
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzg(String str, long j, long j2) {
        zzyd zzyd = this.zzb;
        int i = zzen.zza;
        zzyd.zzo(str, j, j2);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzh(String str) {
        zzyd zzyd = this.zzb;
        int i = zzen.zza;
        zzyd.zzp(str);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzi(zzgs zzgs) {
        zzgs.zza();
        zzyd zzyd = this.zzb;
        int i = zzen.zza;
        zzyd.zzq(zzgs);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzj(int i, long j) {
        zzyd zzyd = this.zzb;
        int i2 = zzen.zza;
        zzyd.zzk(i, j);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzk(zzgs zzgs) {
        zzyd zzyd = this.zzb;
        int i = zzen.zza;
        zzyd.zzr(zzgs);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzl(zzaf zzaf, zzgt zzgt) {
        int i = zzen.zza;
        this.zzb.zzt(zzaf, zzgt);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzm(Object obj, long j) {
        zzyd zzyd = this.zzb;
        int i = zzen.zza;
        zzyd.zzl(obj, j);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzn(long j, int i) {
        zzyd zzyd = this.zzb;
        int i2 = zzen.zza;
        zzyd.zzs(j, i);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzo(Exception exc) {
        zzyd zzyd = this.zzb;
        int i = zzen.zza;
        zzyd.zzn(exc);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzp(zzda zzda) {
        zzyd zzyd = this.zzb;
        int i = zzen.zza;
        zzyd.zzu(zzda);
    }

    public final void zzq(Object obj) {
        if (this.zza != null) {
            this.zza.post(new zzxt(this, obj, SystemClock.elapsedRealtime()));
        }
    }

    public final void zzr(long j, int i) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new zzxv(this, j, i));
        }
    }

    public final void zzs(Exception exc) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new zzxu(this, exc));
        }
    }

    public final void zzt(zzda zzda) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new zzya(this, zzda));
        }
    }
}
