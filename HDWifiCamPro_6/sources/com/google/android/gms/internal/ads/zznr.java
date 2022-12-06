package com.google.android.gms.internal.ads;

import android.os.Handler;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zznr {
    private final Handler zza;
    private final zzns zzb;

    public zznr(Handler handler, zzns zzns) {
        this.zza = zzns == null ? null : handler;
        this.zzb = zzns;
    }

    public final void zza(Exception exc) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new zznh(this, exc));
        }
    }

    public final void zzb(Exception exc) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new zznn(this, exc));
        }
    }

    public final void zzc(String str, long j, long j2) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new zznm(this, str, j, j2));
        }
    }

    public final void zzd(String str) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new zzno(this, str));
        }
    }

    public final void zze(zzgs zzgs) {
        zzgs.zza();
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new zzni(this, zzgs));
        }
    }

    public final void zzf(zzgs zzgs) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new zznj(this, zzgs));
        }
    }

    public final void zzg(zzaf zzaf, zzgt zzgt) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new zznp(this, zzaf, zzgt));
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzh(Exception exc) {
        zzns zzns = this.zzb;
        int i = zzen.zza;
        zzns.zzb(exc);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzi(Exception exc) {
        zzns zzns = this.zzb;
        int i = zzen.zza;
        zzns.zzi(exc);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzj(String str, long j, long j2) {
        zzns zzns = this.zzb;
        int i = zzen.zza;
        zzns.zzc(str, j, j2);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzk(String str) {
        zzns zzns = this.zzb;
        int i = zzen.zza;
        zzns.zzd(str);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzl(zzgs zzgs) {
        zzgs.zza();
        zzns zzns = this.zzb;
        int i = zzen.zza;
        zzns.zze(zzgs);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzm(zzgs zzgs) {
        zzns zzns = this.zzb;
        int i = zzen.zza;
        zzns.zzf(zzgs);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzn(zzaf zzaf, zzgt zzgt) {
        int i = zzen.zza;
        this.zzb.zzg(zzaf, zzgt);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzo(long j) {
        zzns zzns = this.zzb;
        int i = zzen.zza;
        zzns.zzh(j);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzp(boolean z) {
        zzns zzns = this.zzb;
        int i = zzen.zza;
        zzns.zzm(z);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzq(int i, long j, long j2) {
        zzns zzns = this.zzb;
        int i2 = zzen.zza;
        zzns.zzj(i, j, j2);
    }

    public final void zzr(long j) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new zznk(this, j));
        }
    }

    public final void zzs(boolean z) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new zznl(this, z));
        }
    }

    public final void zzt(int i, long j, long j2) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new zznq(this, i, j, j2));
        }
    }
}
