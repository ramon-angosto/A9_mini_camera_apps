package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.pm.PackageManager;
import com.google.android.gms.common.wrappers.Wrappers;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzeby implements zzgxi {
    private final zzgxv zza;
    private final zzgxv zzb;

    public zzeby(zzgxv zzgxv, zzgxv zzgxv2) {
        this.zza = zzgxv;
        this.zzb = zzgxv2;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        try {
            return Wrappers.packageManager((Context) this.zza.zzb()).getPackageInfo(((zzebt) this.zzb).zzb().packageName, 0);
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }
}
