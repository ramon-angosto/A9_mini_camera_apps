package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import java.util.Collections;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public class zzcxj {
    private final zzczc zza;
    private final View zzb;
    private final zzfdl zzc;
    private final zzcmp zzd;

    public zzcxj(View view, zzcmp zzcmp, zzczc zzczc, zzfdl zzfdl) {
        this.zzb = view;
        this.zzd = zzcmp;
        this.zza = zzczc;
        this.zzc = zzfdl;
    }

    public static final zzdkg zzf(Context context, zzcgv zzcgv, zzfdk zzfdk, zzfef zzfef) {
        return new zzdkg(new zzcxh(context, zzcgv, zzfdk, zzfef), zzchc.zzf);
    }

    public static final Set zzg(zzcyt zzcyt) {
        return Collections.singleton(new zzdkg(zzcyt, zzchc.zzf));
    }

    public static final zzdkg zzh(zzcyr zzcyr) {
        return new zzdkg(zzcyr, zzchc.zze);
    }

    public final View zza() {
        return this.zzb;
    }

    public final zzcmp zzb() {
        return this.zzd;
    }

    public final zzczc zzc() {
        return this.zza;
    }

    public zzdem zzd(Set set) {
        return new zzdem(set);
    }

    public final zzfdl zze() {
        return this.zzc;
    }
}
