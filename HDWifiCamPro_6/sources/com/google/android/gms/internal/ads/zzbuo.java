package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.zzt;
import java.util.UUID;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONObject;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzbuo implements zzbua {
    /* access modifiers changed from: private */
    public final zzbuc zza;
    private final zzbud zzb;
    private final zzbtw zzc;
    private final String zzd;

    zzbuo(zzbtw zzbtw, String str, zzbud zzbud, zzbuc zzbuc) {
        this.zzc = zzbtw;
        this.zzd = str;
        this.zzb = zzbud;
        this.zza = zzbuc;
    }

    static /* bridge */ /* synthetic */ void zzd(zzbuo zzbuo, zzbtq zzbtq, zzbtx zzbtx, Object obj, zzchh zzchh) {
        try {
            zzt.zzp();
            String uuid = UUID.randomUUID().toString();
            zzbpt.zzo.zzc(uuid, new zzbun(zzbuo, zzbtq, zzchh));
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("id", uuid);
            jSONObject.put("args", zzbuo.zzb.zzb(obj));
            zzbtx.zzl(zzbuo.zzd, jSONObject);
        } catch (Exception e) {
            zzchh.zze(e);
            zze.zzh("Unable to invokeJavascript", e);
            zzbtq.zzb();
        } catch (Throwable th) {
            zzbtq.zzb();
            throw th;
        }
    }

    public final zzfzp zza(Object obj) throws Exception {
        return zzb(obj);
    }

    public final zzfzp zzb(Object obj) {
        zzchh zzchh = new zzchh();
        zzbtq zzb2 = this.zzc.zzb((zzape) null);
        zzb2.zzi(new zzbul(this, zzb2, obj, zzchh), new zzbum(this, zzchh, zzb2));
        return zzchh;
    }
}
