package com.google.android.gms.internal.ads;

import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final /* synthetic */ class zzefu implements zzfhk {
    public final /* synthetic */ zzefv zza;
    public final /* synthetic */ boolean zzb;
    public final /* synthetic */ ArrayList zzc;
    public final /* synthetic */ zzbgt zzd;
    public final /* synthetic */ zzbhc zze;

    public /* synthetic */ zzefu(zzefv zzefv, boolean z, ArrayList arrayList, zzbgt zzbgt, zzbhc zzbhc) {
        this.zza = zzefv;
        this.zzb = z;
        this.zzc = arrayList;
        this.zzd = zzbgt;
        this.zze = zzbhc;
    }

    public final Object zza(Object obj) {
        zzefv zzefv = this.zza;
        boolean z = this.zzb;
        ArrayList arrayList = this.zzc;
        zzbgt zzbgt = this.zzd;
        zzbhc zzbhc = this.zze;
        SQLiteDatabase sQLiteDatabase = (SQLiteDatabase) obj;
        if (zzefv.zzb.zzf()) {
            return null;
        }
        byte[] zze2 = zzefw.zze(zzefv.zzb, z, arrayList, zzbgt, zzbhc);
        zzefz.zzg(sQLiteDatabase, z, true);
        zzefz.zzd(sQLiteDatabase, zzefv.zzb.zzf.zzd(), zze2);
        return null;
    }
}
