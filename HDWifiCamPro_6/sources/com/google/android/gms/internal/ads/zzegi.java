package com.google.android.gms.internal.ads;

import android.database.sqlite.SQLiteDatabase;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final /* synthetic */ class zzegi implements Runnable {
    public final /* synthetic */ SQLiteDatabase zza;
    public final /* synthetic */ String zzb;
    public final /* synthetic */ zzcgu zzc;

    public /* synthetic */ zzegi(SQLiteDatabase sQLiteDatabase, String str, zzcgu zzcgu) {
        this.zza = sQLiteDatabase;
        this.zzb = str;
        this.zzc = zzcgu;
    }

    public final void run() {
        zzego.zzf(this.zza, this.zzb, this.zzc);
    }
}
