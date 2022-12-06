package com.google.android.gms.internal.ads;

import android.content.SharedPreferences;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzcey implements SharedPreferences.OnSharedPreferenceChangeListener {
    final /* synthetic */ zzcez zza;
    private final String zzb;

    public zzcey(zzcez zzcez, String str) {
        this.zza = zzcez;
        this.zzb = str;
    }

    public final void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        synchronized (this.zza) {
            for (zzcex zzcex : this.zza.zzb) {
                zzcex.zza.zzb(zzcex.zzb, sharedPreferences, this.zzb, str);
            }
        }
    }
}
