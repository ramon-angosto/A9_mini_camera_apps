package com.google.android.gms.internal.ads;

import android.database.sqlite.SQLiteDatabase;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final /* synthetic */ class zzefr implements zzfhk {
    public final /* synthetic */ zzefs zza;
    public final /* synthetic */ long zzb;

    public /* synthetic */ zzefr(zzefs zzefs, long j) {
        this.zza = zzefs;
        this.zzb = j;
    }

    public final Object zza(Object obj) {
        zzefs zzefs = this.zza;
        long j = this.zzb;
        SQLiteDatabase sQLiteDatabase = (SQLiteDatabase) obj;
        if (zzefs.zzf()) {
            return null;
        }
        zzbgx zzg = zzbgy.zzg();
        zzg.zzh(j);
        byte[] zzax = ((zzbgy) zzg.zzam()).zzax();
        zzefz.zzg(sQLiteDatabase, false, false);
        zzefz.zzd(sQLiteDatabase, j, zzax);
        return null;
    }
}
