package com.google.android.gms.internal.ads;

import android.database.sqlite.SQLiteDatabase;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final /* synthetic */ class zzegm implements zzfhk {
    public final /* synthetic */ zzego zza;
    public final /* synthetic */ zzcgu zzb;
    public final /* synthetic */ String zzc;

    public /* synthetic */ zzegm(zzego zzego, zzcgu zzcgu, String str) {
        this.zza = zzego;
        this.zzb = zzcgu;
        this.zzc = str;
    }

    public final Object zza(Object obj) {
        this.zza.zzg((SQLiteDatabase) obj, this.zzb, this.zzc);
        return null;
    }
}
