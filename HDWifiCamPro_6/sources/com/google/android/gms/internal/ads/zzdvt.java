package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final /* synthetic */ class zzdvt implements zzbeo {
    public final /* synthetic */ zzbez zza;
    public final /* synthetic */ String zzb;
    public final /* synthetic */ zzbhp zzc;
    public final /* synthetic */ String zzd;

    public /* synthetic */ zzdvt(zzbez zzbez, String str, zzbhp zzbhp, String str2) {
        this.zza = zzbez;
        this.zzb = str;
        this.zzc = zzbhp;
        this.zzd = str2;
    }

    public final void zza(zzbge zzbge) {
        zzbez zzbez = this.zza;
        String str = this.zzb;
        zzbhp zzbhp = this.zzc;
        String str2 = this.zzd;
        zzbfa zzbfa = (zzbfa) zzbge.zza().zzaA();
        zzbfa.zza(zzbez);
        zzbge.zze(zzbfa);
        zzbfw zzbfw = (zzbfw) zzbge.zzb().zzaA();
        zzbfw.zza(str);
        zzbfw.zzb(zzbhp);
        zzbge.zzg(zzbfw);
        zzbge.zzh(str2);
    }
}
