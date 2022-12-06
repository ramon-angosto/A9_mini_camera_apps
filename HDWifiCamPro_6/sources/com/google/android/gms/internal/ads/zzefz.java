package com.google.android.gms.internal.ads;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzefz {
    public static int zza(SQLiteDatabase sQLiteDatabase, int i) {
        int i2 = 0;
        if (i == 2) {
            return 0;
        }
        Cursor zzh = zzh(sQLiteDatabase, i);
        if (zzh.getCount() > 0) {
            zzh.moveToNext();
            i2 = zzh.getInt(zzh.getColumnIndexOrThrow(AppMeasurementSdk.ConditionalUserProperty.VALUE));
        }
        zzh.close();
        return i2;
    }

    public static long zzb(SQLiteDatabase sQLiteDatabase, int i) {
        long j;
        Cursor zzh = zzh(sQLiteDatabase, 2);
        if (zzh.getCount() > 0) {
            zzh.moveToNext();
            j = zzh.getLong(zzh.getColumnIndexOrThrow(AppMeasurementSdk.ConditionalUserProperty.VALUE));
        } else {
            j = 0;
        }
        zzh.close();
        return j;
    }

    public static ArrayList zzc(SQLiteDatabase sQLiteDatabase) {
        ArrayList arrayList = new ArrayList();
        Cursor query = sQLiteDatabase.query("offline_signal_contents", new String[]{"serialized_proto_data"}, (String) null, (String[]) null, (String) null, (String) null, (String) null);
        while (query.moveToNext()) {
            try {
                arrayList.add(zzbgy.zzi(query.getBlob(query.getColumnIndexOrThrow("serialized_proto_data"))));
            } catch (zzgrq e) {
                zze.zzg("Unable to deserialize proto from offline signals database:");
                zze.zzg(e.getMessage());
            }
        }
        query.close();
        return arrayList;
    }

    public static void zzd(SQLiteDatabase sQLiteDatabase, long j, byte[] bArr) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("timestamp", Long.valueOf(j));
        contentValues.put("serialized_proto_data", bArr);
        if (sQLiteDatabase.update("offline_signal_contents", contentValues, "timestamp = ?", new String[]{String.valueOf(j)}) == 0) {
            sQLiteDatabase.insert("offline_signal_contents", (String) null, contentValues);
        }
    }

    public static void zze(SQLiteDatabase sQLiteDatabase) {
        zzi(sQLiteDatabase, "failed_requests", 0);
        zzi(sQLiteDatabase, "total_requests", 0);
        zzi(sQLiteDatabase, "completed_requests", 0);
        ContentValues contentValues = new ContentValues();
        contentValues.put("statistic_name", "last_successful_request_time");
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.VALUE, 0L);
        sQLiteDatabase.insert("offline_signal_statistics", (String) null, contentValues);
    }

    public static void zzf(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.delete("offline_signal_contents", (String) null, (String[]) null);
        zzj(sQLiteDatabase, "failed_requests", 0);
        zzj(sQLiteDatabase, "total_requests", 0);
        zzj(sQLiteDatabase, "completed_requests", 0);
    }

    public static void zzg(SQLiteDatabase sQLiteDatabase, boolean z, boolean z2) {
        if (!z2) {
            sQLiteDatabase.execSQL(String.format("UPDATE offline_signal_statistics SET value = value+1 WHERE statistic_name = '%s'", new Object[]{"total_requests"}));
            return;
        }
        sQLiteDatabase.execSQL(String.format("UPDATE offline_signal_statistics SET value = value+1 WHERE statistic_name = '%s'", new Object[]{"completed_requests"}));
        if (!z) {
            sQLiteDatabase.execSQL(String.format("UPDATE offline_signal_statistics SET value = value+1 WHERE statistic_name = '%s'", new Object[]{"failed_requests"}));
        }
    }

    private static Cursor zzh(SQLiteDatabase sQLiteDatabase, int i) {
        String[] strArr = {AppMeasurementSdk.ConditionalUserProperty.VALUE};
        String[] strArr2 = new String[1];
        if (i == 0) {
            strArr2[0] = "failed_requests";
        } else if (i == 1) {
            strArr2[0] = "total_requests";
        } else if (i != 2) {
            strArr2[0] = "completed_requests";
        } else {
            strArr2[0] = "last_successful_request_time";
        }
        return sQLiteDatabase.query("offline_signal_statistics", strArr, "statistic_name = ?", strArr2, (String) null, (String) null, (String) null);
    }

    private static void zzi(SQLiteDatabase sQLiteDatabase, String str, int i) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("statistic_name", str);
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.VALUE, 0);
        sQLiteDatabase.insert("offline_signal_statistics", (String) null, contentValues);
    }

    private static void zzj(SQLiteDatabase sQLiteDatabase, String str, int i) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.VALUE, 0);
        sQLiteDatabase.update("offline_signal_statistics", contentValues, "statistic_name = ?", new String[]{str});
    }
}
