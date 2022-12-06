package com.google.android.gms.internal.ads;

import android.database.sqlite.SQLiteDatabase;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final /* synthetic */ class zzegl implements zzfhk {
    public final /* synthetic */ zzego zza;
    public final /* synthetic */ String zzb;

    public /* synthetic */ zzegl(zzego zzego, String str) {
        this.zza = zzego;
        this.zzb = str;
    }

    public final Object zza(Object obj) {
        zzego.zzi((SQLiteDatabase) obj, this.zzb);
        return null;
    }
}
