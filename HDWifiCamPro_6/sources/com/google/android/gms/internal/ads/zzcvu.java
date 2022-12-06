package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.common.util.Clock;
import java.util.concurrent.Executor;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzcvu implements zzbbq {
    private zzcmp zza;
    private final Executor zzb;
    private final zzcvg zzc;
    private final Clock zzd;
    private boolean zze = false;
    private boolean zzf = false;
    private final zzcvj zzg = new zzcvj();

    public zzcvu(Executor executor, zzcvg zzcvg, Clock clock) {
        this.zzb = executor;
        this.zzc = zzcvg;
        this.zzd = clock;
    }

    private final void zzg() {
        try {
            JSONObject zza2 = this.zzc.zzb(this.zzg);
            if (this.zza != null) {
                this.zzb.execute(new zzcvt(this, zza2));
            }
        } catch (JSONException e) {
            zze.zzb("Failed to call video active view js", e);
        }
    }

    public final void zza() {
        this.zze = false;
    }

    public final void zzb() {
        this.zze = true;
        zzg();
    }

    public final void zzc(zzbbp zzbbp) {
        boolean z;
        zzcvj zzcvj = this.zzg;
        if (this.zzf) {
            z = false;
        } else {
            z = zzbbp.zzj;
        }
        zzcvj.zza = z;
        zzcvj.zzd = this.zzd.elapsedRealtime();
        this.zzg.zzf = zzbbp;
        if (this.zze) {
            zzg();
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzd(JSONObject jSONObject) {
        this.zza.zzl("AFMA_updateActiveView", jSONObject);
    }

    public final void zze(boolean z) {
        this.zzf = z;
    }

    public final void zzf(zzcmp zzcmp) {
        this.zza = zzcmp;
    }
}
