package com.google.android.gms.internal.ads;

import androidx.work.WorkRequest;

/* compiled from: com.google.android.gms:play-services-ads-lite@@21.3.0 */
public final class zzbkj {
    public static final zzbke zza = zzbkf.zzf("gads:consent:gmscore:dsid:enabled", true);
    public static final zzbke zzb = zzbkf.zzf("gads:consent:gmscore:lat:enabled", true);
    public static final zzbke zzc = new zzbkf("gads:consent:gmscore:backend_url", "https://adservice.google.com/getconfig/pubvendors", 4);
    public static final zzbke zzd = new zzbkf("gads:consent:gmscore:time_out", Long.valueOf(WorkRequest.MIN_BACKOFF_MILLIS), 2);
    public static final zzbke zze = zzbkf.zzf("gads:consent:gmscore:enabled", true);
}
