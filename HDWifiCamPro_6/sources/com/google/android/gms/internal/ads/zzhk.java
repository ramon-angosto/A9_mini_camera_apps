package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Looper;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzhk {
    final Context zza;
    zzde zzb;
    zzftn zzc;
    zzftn zzd;
    zzftn zze;
    zzftn zzf;
    zzftn zzg;
    zzfsm zzh;
    Looper zzi;
    zzk zzj;
    int zzk;
    boolean zzl;
    zzkd zzm;
    long zzn;
    long zzo;
    boolean zzp;
    boolean zzq;
    zzgv zzr;

    static /* synthetic */ zzsh zza(Context context) {
        return new zzrv(context, new zzzd());
    }

    public zzhk(Context context, zzcly zzcly, byte[] bArr) {
        Context context2 = context;
        zzhe zzhe = new zzhe(zzcly, (byte[]) null);
        zzhf zzhf = new zzhf(context2);
        zzhg zzhg = new zzhg(context2);
        zzhh zzhh = zzhh.zza;
        zzhi zzhi = new zzhi(context2);
        zzhj zzhj = zzhj.zza;
        if (context2 != null) {
            this.zza = context2;
            this.zzc = zzhe;
            this.zzd = zzhf;
            this.zze = zzhg;
            this.zzf = zzhh;
            this.zzg = zzhi;
            this.zzh = zzhj;
            this.zzi = zzen.zzE();
            this.zzj = zzk.zza;
            this.zzk = 1;
            this.zzl = true;
            this.zzm = zzkd.zze;
            this.zzr = new zzgv(0.97f, 1.03f, 1000, 1.0E-7f, zzen.zzv(20), zzen.zzv(500), 0.999f, (zzgu) null);
            this.zzb = zzde.zza;
            this.zzn = 500;
            this.zzo = 2000;
            this.zzp = true;
            return;
        }
        throw null;
    }
}
