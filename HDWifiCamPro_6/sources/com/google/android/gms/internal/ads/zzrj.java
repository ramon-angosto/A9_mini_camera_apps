package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.Looper;
import java.util.ArrayList;
import java.util.HashSet;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public abstract class zzrj implements zzsk {
    private final ArrayList zza = new ArrayList(1);
    private final HashSet zzb = new HashSet(1);
    private final zzsr zzc = new zzsr();
    private final zzpk zzd = new zzpk();
    private Looper zze;
    private zzcn zzf;
    private zznb zzg;

    public final /* synthetic */ zzcn zzG() {
        return null;
    }

    /* access modifiers changed from: protected */
    public final zznb zzb() {
        zznb zznb = this.zzg;
        zzdd.zzb(zznb);
        return zznb;
    }

    /* access modifiers changed from: protected */
    public final zzpk zzc(zzsi zzsi) {
        return this.zzd.zza(0, zzsi);
    }

    /* access modifiers changed from: protected */
    public final zzpk zzd(int i, zzsi zzsi) {
        return this.zzd.zza(i, zzsi);
    }

    /* access modifiers changed from: protected */
    public final zzsr zze(zzsi zzsi) {
        return this.zzc.zza(0, zzsi, 0);
    }

    /* access modifiers changed from: protected */
    public final zzsr zzf(int i, zzsi zzsi, long j) {
        return this.zzc.zza(i, zzsi, 0);
    }

    public final void zzi(zzsj zzsj) {
        boolean isEmpty = this.zzb.isEmpty();
        this.zzb.remove(zzsj);
        if ((!isEmpty) && this.zzb.isEmpty()) {
            zzj();
        }
    }

    /* access modifiers changed from: protected */
    public void zzj() {
    }

    public final void zzk(zzsj zzsj) {
        if (this.zze != null) {
            boolean isEmpty = this.zzb.isEmpty();
            this.zzb.add(zzsj);
            if (isEmpty) {
                zzl();
                return;
            }
            return;
        }
        throw null;
    }

    /* access modifiers changed from: protected */
    public void zzl() {
    }

    public final void zzm(zzsj zzsj, zzfz zzfz, zznb zznb) {
        Looper myLooper = Looper.myLooper();
        Looper looper = this.zze;
        boolean z = true;
        if (!(looper == null || looper == myLooper)) {
            z = false;
        }
        zzdd.zzd(z);
        this.zzg = zznb;
        zzcn zzcn = this.zzf;
        this.zza.add(zzsj);
        if (this.zze == null) {
            this.zze = myLooper;
            this.zzb.add(zzsj);
            zzn(zzfz);
        } else if (zzcn != null) {
            zzk(zzsj);
            zzsj.zza(this, zzcn);
        }
    }

    /* access modifiers changed from: protected */
    public abstract void zzn(zzfz zzfz);

    /* access modifiers changed from: protected */
    public final void zzo(zzcn zzcn) {
        this.zzf = zzcn;
        ArrayList arrayList = this.zza;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            ((zzsj) arrayList.get(i)).zza(this, zzcn);
        }
    }

    public final void zzp(zzsj zzsj) {
        this.zza.remove(zzsj);
        if (this.zza.isEmpty()) {
            this.zze = null;
            this.zzf = null;
            this.zzg = null;
            this.zzb.clear();
            zzq();
            return;
        }
        zzi(zzsj);
    }

    /* access modifiers changed from: protected */
    public abstract void zzq();

    public final void zzr(zzpl zzpl) {
        this.zzd.zzc(zzpl);
    }

    public final void zzs(zzss zzss) {
        this.zzc.zzm(zzss);
    }

    /* access modifiers changed from: protected */
    public final boolean zzt() {
        return !this.zzb.isEmpty();
    }

    public final /* synthetic */ boolean zzu() {
        return true;
    }

    public final void zzg(Handler handler, zzpl zzpl) {
        if (zzpl != null) {
            this.zzd.zzb(handler, zzpl);
            return;
        }
        throw null;
    }

    public final void zzh(Handler handler, zzss zzss) {
        if (zzss != null) {
            this.zzc.zzb(handler, zzss);
            return;
        }
        throw null;
    }
}
