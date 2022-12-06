package com.google.firebase.iid;

import android.text.TextUtils;
import android.util.Log;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.firebase:firebase-iid@@20.0.0 */
final class zzas {
    private static final long zzb = TimeUnit.DAYS.toMillis(7);
    final String zza;
    private final String zzc;
    private final long zzd;

    private zzas(String str, String str2, long j) {
        this.zza = str;
        this.zzc = str2;
        this.zzd = j;
    }

    static zzas zza(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (!str.startsWith("{")) {
            return new zzas(str, (String) null, 0);
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            return new zzas(jSONObject.getString("token"), jSONObject.getString("appVersion"), jSONObject.getLong("timestamp"));
        } catch (JSONException e) {
            String valueOf = String.valueOf(e);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 23);
            sb.append("Failed to parse token: ");
            sb.append(valueOf);
            Log.w("FirebaseInstanceId", sb.toString());
            return null;
        }
    }

    static String zza(String str, String str2, long j) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("token", str);
            jSONObject.put("appVersion", str2);
            jSONObject.put("timestamp", j);
            return jSONObject.toString();
        } catch (JSONException e) {
            String valueOf = String.valueOf(e);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 24);
            sb.append("Failed to encode token: ");
            sb.append(valueOf);
            Log.w("FirebaseInstanceId", sb.toString());
            return null;
        }
    }

    static String zza(zzas zzas) {
        if (zzas == null) {
            return null;
        }
        return zzas.zza;
    }

    /* access modifiers changed from: package-private */
    public final boolean zzb(String str) {
        return System.currentTimeMillis() > this.zzd + zzb || !str.equals(this.zzc);
    }
}
