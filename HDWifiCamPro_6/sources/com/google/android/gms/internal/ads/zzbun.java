package com.google.android.gms.internal.ads;

import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzbun implements zzbqi {
    final /* synthetic */ zzbuo zza;
    private final zzbtq zzb;
    private final zzchh zzc;

    public zzbun(zzbuo zzbuo, zzbtq zzbtq, zzchh zzchh) {
        this.zza = zzbuo;
        this.zzb = zzbtq;
        this.zzc = zzchh;
    }

    public final void zza(String str) {
        zzbtq zzbtq;
        if (str == null) {
            try {
                this.zzc.zze(new zzbtz());
            } catch (IllegalStateException unused) {
                zzbtq = this.zzb;
            } catch (Throwable th) {
                this.zzb.zzb();
                throw th;
            }
        } else {
            this.zzc.zze(new zzbtz(str));
        }
        zzbtq = this.zzb;
        zzbtq.zzb();
    }

    public final void zzb(JSONObject jSONObject) {
        zzbtq zzbtq;
        try {
            this.zzc.zzd(this.zza.zza.zza(jSONObject));
            zzbtq = this.zzb;
        } catch (IllegalStateException unused) {
            zzbtq = this.zzb;
        } catch (JSONException e) {
            this.zzc.zze(e);
            zzbtq = this.zzb;
        } catch (Throwable th) {
            this.zzb.zzb();
            throw th;
        }
        zzbtq.zzb();
    }
}
