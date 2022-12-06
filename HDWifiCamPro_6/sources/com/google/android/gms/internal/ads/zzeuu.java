package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.gms.ads.internal.client.zzay;
import com.ironsource.mediationsdk.config.VersionInfo;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzeuu implements zzevd {
    public final boolean zza;
    public final boolean zzb;
    public final String zzc;
    public final boolean zzd;
    public final int zze;
    public final int zzf;
    public final int zzg;

    public zzeuu(boolean z, boolean z2, String str, boolean z3, int i, int i2, int i3) {
        this.zza = z;
        this.zzb = z2;
        this.zzc = str;
        this.zzd = z3;
        this.zze = i;
        this.zzf = i2;
        this.zzg = i3;
    }

    public final /* bridge */ /* synthetic */ void zzf(Object obj) {
        Bundle bundle = (Bundle) obj;
        bundle.putString("js", this.zzc);
        bundle.putBoolean("is_nonagon", true);
        bundle.putString("extra_caps", (String) zzay.zzc().zzb(zzbjc.zzcP));
        bundle.putInt("target_api", this.zze);
        bundle.putInt("dv", this.zzf);
        bundle.putInt("lv", this.zzg);
        Bundle zza2 = zzfeq.zza(bundle, "sdk_env");
        zza2.putBoolean("mf", ((Boolean) zzbks.zza.zze()).booleanValue());
        zza2.putBoolean("instant_app", this.zza);
        zza2.putBoolean("lite", this.zzb);
        zza2.putBoolean("is_privileged_process", this.zzd);
        bundle.putBundle("sdk_env", zza2);
        Bundle zza3 = zzfeq.zza(zza2, "build_meta");
        zza3.putString("cl", "474357726");
        zza3.putString("rapid_rc", "dev");
        zza3.putString("rapid_rollup", VersionInfo.GIT_BRANCH);
        zza2.putBundle("build_meta", zza3);
    }
}
