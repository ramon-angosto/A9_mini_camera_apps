package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;
import com.ironsource.mediationsdk.config.VersionInfo;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzcbm extends zzcbn {
    private final Object zza = new Object();
    private final Context zzb;
    private SharedPreferences zzc;
    private final zzbua zzd;

    public zzcbm(Context context, zzbua zzbua) {
        this.zzb = context.getApplicationContext();
        this.zzd = zzbua;
    }

    public static JSONObject zzc(Context context) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("js", zzcgv.zza().zza);
            jSONObject.put("mf", zzbks.zza.zze());
            jSONObject.put("cl", "474357726");
            jSONObject.put("rapid_rc", "dev");
            jSONObject.put("rapid_rollup", VersionInfo.GIT_BRANCH);
            jSONObject.put("admob_module_version", GooglePlayServicesUtilLight.GOOGLE_PLAY_SERVICES_VERSION_CODE);
            jSONObject.put("dynamite_local_version", ModuleDescriptor.MODULE_VERSION);
            jSONObject.put("dynamite_version", DynamiteModule.getRemoteVersion(context, ModuleDescriptor.MODULE_ID));
            jSONObject.put("container_version", GooglePlayServicesUtilLight.GOOGLE_PLAY_SERVICES_VERSION_CODE);
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    public final zzfzp zza() {
        synchronized (this.zza) {
            if (this.zzc == null) {
                this.zzc = this.zzb.getSharedPreferences("google_ads_flags_meta", 0);
            }
        }
        if (zzt.zzB().currentTimeMillis() - this.zzc.getLong("js_last_update", 0) < ((Long) zzbks.zzb.zze()).longValue()) {
            return zzfzg.zzi((Object) null);
        }
        return zzfzg.zzm(this.zzd.zzb(zzc(this.zzb)), new zzcbl(this), zzchc.zzf);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Void zzb(JSONObject jSONObject) {
        zzbjc.zzd(this.zzb, 1, jSONObject);
        this.zzc.edit().putLong("js_last_update", zzt.zzB().currentTimeMillis()).apply();
        return null;
    }
}
