package com.google.android.gms.internal.ads;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.ads.internal.util.zzbr;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.util.zzs;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzego extends SQLiteOpenHelper {
    private final Context zza;
    private final zzfzq zzb;

    public zzego(Context context, zzfzq zzfzq) {
        super(context, "AdMobOfflineBufferedPings.db", (SQLiteDatabase.CursorFactory) null, ((Integer) zzay.zzc().zzb(zzbjc.zzhj)).intValue());
        this.zza = context;
        this.zzb = zzfzq;
    }

    static /* synthetic */ void zzf(SQLiteDatabase sQLiteDatabase, String str, zzcgu zzcgu) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("event_state", 1);
        sQLiteDatabase.update("offline_buffered_pings", contentValues, "gws_query_id = ?", new String[]{str});
        zzj(sQLiteDatabase, zzcgu);
    }

    static final void zzi(SQLiteDatabase sQLiteDatabase, String str) {
        sQLiteDatabase.delete("offline_buffered_pings", "gws_query_id = ? AND event_state = ?", new String[]{str, Integer.toString(0)});
    }

    /* JADX INFO: finally extract failed */
    /* access modifiers changed from: private */
    public static void zzj(SQLiteDatabase sQLiteDatabase, zzcgu zzcgu) {
        sQLiteDatabase.beginTransaction();
        try {
            Cursor query = sQLiteDatabase.query("offline_buffered_pings", new String[]{"url"}, "event_state = " + 1, (String[]) null, (String) null, (String) null, "timestamp ASC", (String) null);
            String[] strArr = new String[query.getCount()];
            int i = 0;
            while (query.moveToNext()) {
                int columnIndex = query.getColumnIndex("url");
                if (columnIndex != -1) {
                    strArr[i] = query.getString(columnIndex);
                }
                i++;
            }
            query.close();
            sQLiteDatabase.delete("offline_buffered_pings", "event_state = ?", new String[]{Integer.toString(1)});
            sQLiteDatabase.setTransactionSuccessful();
            sQLiteDatabase.endTransaction();
            for (String zza2 : strArr) {
                zzcgu.zza(zza2);
            }
        } catch (Throwable th) {
            sQLiteDatabase.endTransaction();
            throw th;
        }
    }

    public final void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE offline_buffered_pings (timestamp INTEGER PRIMARY_KEY, gws_query_id TEXT, url TEXT, event_state INTEGER)");
    }

    public final void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS offline_buffered_pings");
    }

    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS offline_buffered_pings");
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Void zza(zzegq zzegq, SQLiteDatabase sQLiteDatabase) throws Exception {
        ContentValues contentValues = new ContentValues();
        contentValues.put("timestamp", Long.valueOf(zzegq.zza));
        contentValues.put("gws_query_id", zzegq.zzb);
        contentValues.put("url", zzegq.zzc);
        contentValues.put("event_state", Integer.valueOf(zzegq.zzd - 1));
        sQLiteDatabase.insert("offline_buffered_pings", (String) null, contentValues);
        zzt.zzp();
        zzbr zzw = zzs.zzw(this.zza);
        if (zzw != null) {
            try {
                zzw.zze(ObjectWrapper.wrap(this.zza));
            } catch (RemoteException e) {
                zze.zzb("Failed to schedule offline ping sender.", e);
            }
        }
        return null;
    }

    public final void zzc(String str) {
        zze(new zzegl(this, str));
    }

    public final void zzd(zzegq zzegq) {
        zze(new zzegj(this, zzegq));
    }

    /* access modifiers changed from: package-private */
    public final void zze(zzfhk zzfhk) {
        zzfzg.zzr(this.zzb.zzb(new zzegh(this)), new zzegn(this, zzfhk), this.zzb);
    }

    /* access modifiers changed from: package-private */
    public final void zzg(SQLiteDatabase sQLiteDatabase, zzcgu zzcgu, String str) {
        this.zzb.execute(new zzegi(sQLiteDatabase, str, zzcgu));
    }

    public final void zzh(zzcgu zzcgu, String str) {
        zze(new zzegm(this, zzcgu, str));
    }
}
