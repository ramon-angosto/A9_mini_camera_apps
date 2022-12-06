package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads-lite@@21.3.0 */
final class zzbiz implements zzblh {
    final /* synthetic */ zzbja zza;

    zzbiz(zzbja zzbja) {
        this.zza = zzbja;
    }

    public final Boolean zza(String str, boolean z) {
        try {
            return Boolean.valueOf(this.zza.zze.getBoolean(str, z));
        } catch (ClassCastException unused) {
            return Boolean.valueOf(this.zza.zze.getString(str, String.valueOf(z)));
        }
    }

    public final Double zzb(String str, double d) {
        try {
            return Double.valueOf((double) this.zza.zze.getFloat(str, (float) d));
        } catch (ClassCastException unused) {
            return Double.valueOf(this.zza.zze.getString(str, String.valueOf(d)));
        }
    }

    public final Long zzc(String str, long j) {
        try {
            return Long.valueOf(this.zza.zze.getLong(str, j));
        } catch (ClassCastException unused) {
            return Long.valueOf((long) this.zza.zze.getInt(str, (int) j));
        }
    }

    public final String zzd(String str, String str2) {
        return this.zza.zze.getString(str, str2);
    }
}
