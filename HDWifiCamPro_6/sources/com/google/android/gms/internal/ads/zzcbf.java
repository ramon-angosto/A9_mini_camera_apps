package com.google.android.gms.internal.ads;

import com.vungle.warren.model.ReportDBAdapter;
import java.util.Arrays;
import java.util.List;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzcbf {
    private final List zza;
    private final String zzb;
    private final String zzc;
    private final String zzd;
    private final boolean zze;
    private final boolean zzf;
    private final String zzg;
    private final String zzh;
    private final String zzi;
    private final int zzj;
    private final JSONObject zzk;
    private final String zzl;
    private final String zzm;

    public zzcbf(JSONObject jSONObject) {
        List list;
        this.zzi = jSONObject.optString("url");
        this.zzb = jSONObject.optString("base_uri");
        this.zzc = jSONObject.optString("post_parameters");
        this.zze = zzj(jSONObject.optString("drt_include"));
        this.zzf = zzj(jSONObject.optString("cookies_include", "true"));
        this.zzg = jSONObject.optString("request_id");
        this.zzd = jSONObject.optString("type");
        String optString = jSONObject.optString(ReportDBAdapter.ReportColumns.COLUMN_ERRORS);
        if (optString == null) {
            list = null;
        } else {
            list = Arrays.asList(optString.split(","));
        }
        this.zza = list;
        this.zzj = jSONObject.optInt("valid", 0) == 1 ? -2 : 1;
        this.zzh = jSONObject.optString("fetched_ad");
        jSONObject.optBoolean("render_test_ad_label");
        JSONObject optJSONObject = jSONObject.optJSONObject("preprocessor_flags");
        this.zzk = optJSONObject == null ? new JSONObject() : optJSONObject;
        this.zzl = jSONObject.optString("analytics_query_ad_event_id");
        jSONObject.optBoolean("is_analytics_logging_enabled");
        this.zzm = jSONObject.optString("pool_key");
    }

    private static boolean zzj(String str) {
        if (str == null) {
            return false;
        }
        if (!str.equals("1")) {
            return str.equals("true");
        }
        return true;
    }

    public final int zza() {
        return this.zzj;
    }

    public final String zzb() {
        return this.zzb;
    }

    public final String zzc() {
        return this.zzm;
    }

    public final String zzd() {
        return this.zzc;
    }

    public final String zze() {
        return this.zzi;
    }

    public final List zzf() {
        return this.zza;
    }

    public final JSONObject zzg() {
        return this.zzk;
    }

    public final boolean zzh() {
        return this.zzf;
    }

    public final boolean zzi() {
        return this.zze;
    }
}
