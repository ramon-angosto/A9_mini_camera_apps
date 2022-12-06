package com.google.android.gms.internal.ads;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.ads.internal.util.zzg;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzdcg {
    private final zzfih zza;
    private final zzcgv zzb;
    private final ApplicationInfo zzc;
    private final String zzd;
    private final List zze;
    private final PackageInfo zzf;
    private final zzgxc zzg;
    private final String zzh;
    private final zzevh zzi;
    private final zzg zzj;

    public zzdcg(zzfih zzfih, zzcgv zzcgv, ApplicationInfo applicationInfo, String str, List list, PackageInfo packageInfo, zzgxc zzgxc, zzg zzg2, String str2, zzevh zzevh) {
        this.zza = zzfih;
        this.zzb = zzcgv;
        this.zzc = applicationInfo;
        this.zzd = str;
        this.zze = list;
        this.zzf = packageInfo;
        this.zzg = zzgxc;
        this.zzh = str2;
        this.zzi = zzevh;
        this.zzj = zzg2;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzcbc zza(zzfzp zzfzp) throws Exception {
        return new zzcbc((Bundle) zzfzp.get(), this.zzb, this.zzc, this.zzd, this.zze, this.zzf, (String) ((zzfzp) this.zzg.zzb()).get(), this.zzh, (zzffx) null, (String) null, ((Boolean) zzay.zzc().zzb(zzbjc.zzgm)).booleanValue() ? this.zzj.zzP() : false);
    }

    public final zzfzp zzb() {
        zzfih zzfih = this.zza;
        return zzfhr.zzc(this.zzi.zza(new Bundle()), zzfib.SIGNALS, zzfih).zza();
    }

    public final zzfzp zzc() {
        zzfzp zzb2 = zzb();
        return this.zza.zza(zzfib.REQUEST_PARCEL, zzb2, (zzfzp) this.zzg.zzb()).zza(new zzdcf(this, zzb2)).zza();
    }
}
