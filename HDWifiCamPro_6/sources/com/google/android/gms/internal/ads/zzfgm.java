package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.ads.internal.zzt;
import java.util.ArrayDeque;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzfgm {
    private final zzffq zza;
    private final zzfgk zzb;
    private final zzffm zzc;
    /* access modifiers changed from: private */
    public final ArrayDeque zzd;
    /* access modifiers changed from: private */
    public zzfgs zze;
    /* access modifiers changed from: private */
    public int zzf = 1;

    public zzfgm(zzffq zzffq, zzffm zzffm, zzfgk zzfgk) {
        this.zza = zzffq;
        this.zzc = zzffm;
        this.zzb = zzfgk;
        this.zzd = new ArrayDeque();
        this.zzc.zzb(new zzfgh(this));
    }

    /* access modifiers changed from: private */
    public final synchronized void zzh() {
        if (((Boolean) zzay.zzc().zzb(zzbjc.zzfs)).booleanValue()) {
            if (!zzt.zzo().zzh().zzh().zzh()) {
                this.zzd.clear();
                return;
            }
        }
        if (zzi()) {
            while (!this.zzd.isEmpty()) {
                zzfgl zzfgl = (zzfgl) this.zzd.pollFirst();
                if (zzfgl == null || (zzfgl.zza() != null && this.zza.zze(zzfgl.zza()))) {
                    this.zze = new zzfgs(this.zza, this.zzb, zzfgl);
                    this.zze.zzd(new zzfgi(this, zzfgl));
                    return;
                }
            }
        }
    }

    private final synchronized boolean zzi() {
        return this.zze == null;
    }

    public final synchronized zzfzp zza(zzfgl zzfgl) {
        this.zzf = 2;
        if (zzi()) {
            return null;
        }
        return this.zze.zza(zzfgl);
    }

    public final synchronized void zze(zzfgl zzfgl) {
        this.zzd.add(zzfgl);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzf() {
        synchronized (this) {
            this.zzf = 1;
            zzh();
        }
    }
}
