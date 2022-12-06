package com.google.firebase.iid;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import androidx.collection.ArrayMap;
import androidx.core.content.ContextCompat;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import java.io.File;
import java.io.IOException;
import java.util.Map;

/* compiled from: com.google.firebase:firebase-iid@@20.0.0 */
final class zzat {
    private final SharedPreferences zza;
    private final Context zzb;
    private final zzq zzc;
    private final Map<String, zzs> zzd;

    public zzat(Context context) {
        this(context, new zzq());
    }

    private zzat(Context context, zzq zzq) {
        this.zzd = new ArrayMap();
        this.zzb = context;
        this.zza = context.getSharedPreferences("com.google.android.gms.appid", 0);
        this.zzc = zzq;
        File file = new File(ContextCompat.getNoBackupFilesDir(this.zzb), "com.google.android.gms.appid-no-backup");
        if (!file.exists()) {
            try {
                if (file.createNewFile() && !zzc()) {
                    Log.i("FirebaseInstanceId", "App restored, clearing state");
                    zzb();
                    FirebaseInstanceId.getInstance().zze();
                }
            } catch (IOException e) {
                if (Log.isLoggable("FirebaseInstanceId", 3)) {
                    String valueOf = String.valueOf(e.getMessage());
                    Log.d("FirebaseInstanceId", valueOf.length() != 0 ? "Error creating file in no backup dir: ".concat(valueOf) : new String("Error creating file in no backup dir: "));
                }
            }
        }
    }

    public final synchronized String zza() {
        return this.zza.getString("topic_operation_queue", "");
    }

    public final synchronized void zza(String str) {
        this.zza.edit().putString("topic_operation_queue", str).apply();
    }

    private final synchronized boolean zzc() {
        return this.zza.getAll().isEmpty();
    }

    private static String zzc(String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 4 + String.valueOf(str2).length() + String.valueOf(str3).length());
        sb.append(str);
        sb.append("|T|");
        sb.append(str2);
        sb.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
        sb.append(str3);
        return sb.toString();
    }

    static String zza(String str, String str2) {
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 3 + String.valueOf(str2).length());
        sb.append(str);
        sb.append("|S|");
        sb.append(str2);
        return sb.toString();
    }

    public final synchronized void zzb() {
        this.zzd.clear();
        zzq.zza(this.zzb);
        this.zza.edit().clear().commit();
    }

    public final synchronized zzas zza(String str, String str2, String str3) {
        return zzas.zza(this.zza.getString(zzc(str, str2, str3), (String) null));
    }

    public final synchronized void zza(String str, String str2, String str3, String str4, String str5) {
        String zza2 = zzas.zza(str4, str5, System.currentTimeMillis());
        if (zza2 != null) {
            SharedPreferences.Editor edit = this.zza.edit();
            edit.putString(zzc(str, str2, str3), zza2);
            edit.commit();
        }
    }

    public final synchronized void zzb(String str, String str2, String str3) {
        String zzc2 = zzc(str, str2, str3);
        SharedPreferences.Editor edit = this.zza.edit();
        edit.remove(zzc2);
        edit.commit();
    }

    public final synchronized zzs zzb(String str) {
        zzs zzs;
        zzs zzs2 = this.zzd.get(str);
        if (zzs2 != null) {
            return zzs2;
        }
        try {
            zzs = this.zzc.zza(this.zzb, str);
        } catch (zzt unused) {
            Log.w("FirebaseInstanceId", "Stored data is corrupt, generating new identity");
            FirebaseInstanceId.getInstance().zze();
            zzs = this.zzc.zzb(this.zzb, str);
        }
        this.zzd.put(str, zzs);
        return zzs;
    }

    public final synchronized void zzc(String str) {
        String concat = String.valueOf(str).concat("|T|");
        SharedPreferences.Editor edit = this.zza.edit();
        for (String next : this.zza.getAll().keySet()) {
            if (next.startsWith(concat)) {
                edit.remove(next);
            }
        }
        edit.commit();
    }
}
