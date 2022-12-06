package com.google.android.gms.internal.consent_sdk;

import android.app.Application;
import android.content.SharedPreferences;
import android.util.Log;
import com.mbridge.msdk.MBridgeConstans;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* compiled from: com.google.android.ump:user-messaging-platform@@2.0.0 */
public final class zzam {
    private final Application zza;
    private final SharedPreferences zzb;
    private final Set<String> zzc = new HashSet(this.zzb.getStringSet("written_values", Collections.emptySet()));

    zzam(Application application) {
        this.zza = application;
        this.zzb = application.getSharedPreferences("__GOOGLE_FUNDING_CHOICE_SDK_INTERNAL__", 0);
    }

    public final int zza() {
        return this.zzb.getInt("consent_status", 0);
    }

    public final Map<String, String> zzb() {
        String str;
        Application application = this.zza;
        Set<String> stringSet = this.zzb.getStringSet("stored_info", Collections.emptySet());
        HashMap hashMap = new HashMap();
        for (String next : stringSet) {
            zzby zza2 = zzca.zza(application, next);
            if (zza2 == null) {
                String valueOf = String.valueOf(next);
                Log.d("UserMessagingPlatform", valueOf.length() != 0 ? "Fetching request info: failed for key: ".concat(valueOf) : new String("Fetching request info: failed for key: "));
            } else {
                Object obj = application.getSharedPreferences(zza2.zza, 0).getAll().get(zza2.zzb);
                if (obj == null) {
                    String valueOf2 = String.valueOf(next);
                    Log.d("UserMessagingPlatform", valueOf2.length() != 0 ? "Stored info not exists: ".concat(valueOf2) : new String("Stored info not exists: "));
                } else {
                    if (obj instanceof Boolean) {
                        str = true != ((Boolean) obj).booleanValue() ? MBridgeConstans.ENDCARD_URL_TYPE_PL : "1";
                    } else if (obj instanceof Number) {
                        str = obj.toString();
                    } else if (obj instanceof String) {
                        str = (String) obj;
                    } else {
                        String valueOf3 = String.valueOf(next);
                        Log.d("UserMessagingPlatform", valueOf3.length() != 0 ? "Failed to fetch stored info: ".concat(valueOf3) : new String("Failed to fetch stored info: "));
                    }
                    hashMap.put(next, str);
                }
            }
        }
        return hashMap;
    }

    public final Set<String> zzc() {
        return this.zzc;
    }

    public final void zzd() {
        zzca.zzb(this.zza, this.zzc);
        this.zzc.clear();
        this.zzb.edit().remove("stored_info").remove("consent_status").remove("consent_type").apply();
    }

    public final void zze() {
        this.zzb.edit().putStringSet("written_values", this.zzc).apply();
    }

    public final void zzf(int i) {
        this.zzb.edit().putInt("consent_status", i).apply();
    }

    public final void zzg(Set<String> set) {
        this.zzb.edit().putStringSet("stored_info", set).apply();
    }
}
