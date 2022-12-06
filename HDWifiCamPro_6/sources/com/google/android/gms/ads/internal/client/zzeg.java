package com.google.android.gms.ads.internal.client;

import android.os.Bundle;
import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads-lite@@21.3.0 */
public final class zzeg {
    private final String zza;
    private final Bundle zzb;
    private final String zzc;

    public zzeg(String str, Bundle bundle, String str2) {
        this.zza = str;
        this.zzb = bundle;
        this.zzc = str2;
    }

    public final Bundle zza() {
        return this.zzb;
    }

    public final String zzb() {
        return this.zza;
    }

    /* access modifiers changed from: package-private */
    public final String zzc() {
        return this.zzc;
    }

    public final String zzd() {
        if (TextUtils.isEmpty(this.zzc)) {
            return "";
        }
        try {
            return new JSONObject(this.zzc).optString("request_id", "");
        } catch (JSONException unused) {
            return "";
        }
    }
}
