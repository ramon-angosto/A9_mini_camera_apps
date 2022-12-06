package com.google.android.gms.internal.consent_sdk;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.ump:user-messaging-platform@@2.0.0 */
public final class zzbz {
    private final Context zza;
    private final Map<String, SharedPreferences.Editor> zzb = new HashMap();

    public zzbz(Context context) {
        this.zza = context;
    }

    /* access modifiers changed from: private */
    public final SharedPreferences.Editor zzd(String str) {
        if (!this.zzb.containsKey(str)) {
            this.zzb.put(str, this.zza.getSharedPreferences(str, 0).edit());
        }
        return this.zzb.get(str);
    }

    public final void zzb() {
        for (SharedPreferences.Editor apply : this.zzb.values()) {
            apply.apply();
        }
    }

    public final boolean zzc(String str, Object obj) {
        zzby zza2 = zzca.zza(this.zza, str);
        if (zza2 == null) {
            return false;
        }
        SharedPreferences.Editor zzd = zzd(zza2.zza);
        if (obj instanceof Integer) {
            zzd.putInt(zza2.zzb, ((Integer) obj).intValue());
            return true;
        } else if (obj instanceof Long) {
            zzd.putLong(zza2.zzb, ((Long) obj).longValue());
            return true;
        } else if (obj instanceof Double) {
            zzd.putFloat(zza2.zzb, ((Double) obj).floatValue());
            return true;
        } else if (obj instanceof Float) {
            zzd.putFloat(zza2.zzb, ((Float) obj).floatValue());
            return true;
        } else if (obj instanceof Boolean) {
            zzd.putBoolean(zza2.zzb, ((Boolean) obj).booleanValue());
            return true;
        } else if (!(obj instanceof String)) {
            return false;
        } else {
            zzd.putString(zza2.zzb, (String) obj);
            return true;
        }
    }
}
