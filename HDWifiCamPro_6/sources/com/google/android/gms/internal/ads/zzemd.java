package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.internal.client.zze;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public class zzemd extends zzbvp {
    private final zzdcy zza;
    private final zzdkl zzb;
    private final zzdds zzc;
    private final zzdeh zzd;
    private final zzdem zze;
    private final zzdht zzf;
    private final zzdfg zzg;
    private final zzdld zzh;
    private final zzdhp zzi;
    private final zzddn zzj;

    public zzemd(zzdcy zzdcy, zzdkl zzdkl, zzdds zzdds, zzdeh zzdeh, zzdem zzdem, zzdht zzdht, zzdfg zzdfg, zzdld zzdld, zzdhp zzdhp, zzddn zzddn) {
        this.zza = zzdcy;
        this.zzb = zzdkl;
        this.zzc = zzdds;
        this.zzd = zzdeh;
        this.zze = zzdem;
        this.zzf = zzdht;
        this.zzg = zzdfg;
        this.zzh = zzdld;
        this.zzi = zzdhp;
        this.zzj = zzddn;
    }

    public final void zze() {
        this.zza.onAdClicked();
        this.zzb.zzq();
    }

    public final void zzf() {
        this.zzg.zzf(4);
    }

    public final void zzg(int i) {
    }

    public final void zzh(zze zze2) {
    }

    public final void zzi(int i, String str) {
    }

    @Deprecated
    public final void zzj(int i) throws RemoteException {
        zzk(new zze(i, "", AdError.UNDEFINED_DOMAIN, (zze) null, (IBinder) null));
    }

    public final void zzk(zze zze2) {
        this.zzj.zza(zzffe.zzc(8, zze2));
    }

    public final void zzl(String str) {
        zzk(new zze(0, str, AdError.UNDEFINED_DOMAIN, (zze) null, (IBinder) null));
    }

    public void zzm() {
        this.zzc.zza();
        this.zzi.zzb();
    }

    public final void zzn() {
        this.zzd.zzb();
    }

    public final void zzo() {
        this.zze.zzn();
    }

    public final void zzp() {
        this.zzg.zzb();
        this.zzi.zza();
    }

    public final void zzq(String str, String str2) {
        this.zzf.zzbD(str, str2);
    }

    public final void zzr(zzbmy zzbmy, String str) {
    }

    public void zzs(zzcce zzcce) {
    }

    public void zzt(zzcci zzcci) throws RemoteException {
    }

    public void zzu() throws RemoteException {
    }

    public void zzv() {
        this.zzh.zza();
    }

    public final void zzw() {
        this.zzh.zzb();
    }

    public final void zzx() throws RemoteException {
        this.zzh.zzc();
    }

    public void zzy() {
        this.zzh.zzd();
    }
}
