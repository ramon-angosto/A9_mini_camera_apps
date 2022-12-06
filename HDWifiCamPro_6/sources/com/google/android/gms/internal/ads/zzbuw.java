package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzt;
import java.util.UUID;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzbuw implements zzfyn {
    private final zzbuc zza;
    private final zzbud zzb;
    private final String zzc = "google.afma.activeView.handleUpdate";
    private final zzfzp zzd;

    zzbuw(zzfzp zzfzp, String str, zzbud zzbud, zzbuc zzbuc) {
        this.zzd = zzfzp;
        this.zzb = zzbud;
        this.zza = zzbuc;
    }

    public final zzfzp zza(Object obj) throws Exception {
        return zzb(obj);
    }

    public final zzfzp zzb(Object obj) {
        return zzfzg.zzn(this.zzd, new zzbuu(this, obj), zzchc.zzf);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzfzp zzc(Object obj, zzbtx zzbtx) throws Exception {
        zzchh zzchh = new zzchh();
        zzt.zzp();
        String uuid = UUID.randomUUID().toString();
        zzbpt.zzo.zzc(uuid, new zzbuv(this, zzchh));
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("id", uuid);
        jSONObject.put("args", (JSONObject) obj);
        zzbtx.zzl(this.zzc, jSONObject);
        return zzchh;
    }
}
