package com.google.android.gms.ads.internal;

import com.google.android.gms.internal.ads.zzfjj;
import com.google.android.gms.internal.ads.zzfjw;
import com.google.android.gms.internal.ads.zzfyn;
import com.google.android.gms.internal.ads.zzfzg;
import com.google.android.gms.internal.ads.zzfzp;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final /* synthetic */ class zzd implements zzfyn {
    public final /* synthetic */ zzfjw zza;
    public final /* synthetic */ zzfjj zzb;

    public /* synthetic */ zzd(zzfjw zzfjw, zzfjj zzfjj) {
        this.zza = zzfjw;
        this.zzb = zzfjj;
    }

    public final zzfzp zza(Object obj) {
        zzfjw zzfjw = this.zza;
        zzfjj zzfjj = this.zzb;
        JSONObject jSONObject = (JSONObject) obj;
        boolean optBoolean = jSONObject.optBoolean("isSuccessful", false);
        if (optBoolean) {
            zzt.zzo().zzh().zzu(jSONObject.getString("appSettingsJson"));
        }
        zzfjj.zze(optBoolean);
        zzfjw.zzb(zzfjj.zzj());
        return zzfzg.zzi((Object) null);
    }
}
