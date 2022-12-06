package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.ads.internal.zza;
import com.google.android.gms.ads.internal.zzb;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.Executor;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzdtn {
    /* access modifiers changed from: private */
    public final zzdth zza = new zzdth((zzdtg) null);
    private final zza zzb;
    private final zzcnb zzc;
    private final Context zzd;
    private final zzdxq zze;
    private final zzfir zzf;
    private final Executor zzg;
    private final zzape zzh;
    private final zzcgv zzi;
    private final zzbqj zzj;
    private final zzego zzk;
    private final zzfkm zzl;
    private zzfzp zzm;

    zzdtn(zzdtk zzdtk) {
        this.zzd = zzdtk.zzc;
        this.zzg = zzdtk.zzg;
        this.zzh = zzdtk.zzh;
        this.zzi = zzdtk.zzi;
        this.zzb = zzdtk.zza;
        this.zzc = zzdtk.zzb;
        this.zzj = new zzbqj();
        this.zzk = zzdtk.zzf;
        this.zzl = zzdtk.zzj;
        this.zze = zzdtk.zzd;
        this.zzf = zzdtk.zze;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzcmp zza(zzcmp zzcmp) {
        zzcmp zzcmp2 = zzcmp;
        zzcmp2.zzaf("/result", this.zzj);
        zzcoc zzP = zzcmp.zzP();
        zzdth zzdth = this.zza;
        zzb zzb2 = r2;
        zzb zzb3 = new zzb(this.zzd, (zzcdq) null, (zzcaq) null);
        zzP.zzL((com.google.android.gms.ads.internal.client.zza) null, zzdth, zzdth, zzdth, zzdth, false, (zzbpx) null, zzb2, (zzbyg) null, (zzcdq) null, this.zzk, this.zzl, this.zze, this.zzf, (zzbpv) null, (zzdkn) null, (zzbqm) null, (zzbqg) null);
        return zzcmp2;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzfzp zzc(String str, JSONObject jSONObject, zzcmp zzcmp) throws Exception {
        return this.zzj.zzb(zzcmp, str, jSONObject);
    }

    public final synchronized zzfzp zzd(String str, JSONObject jSONObject) {
        zzfzp zzfzp = this.zzm;
        if (zzfzp == null) {
            return zzfzg.zzi((Object) null);
        }
        return zzfzg.zzn(zzfzp, new zzdsz(this, str, jSONObject), this.zzg);
    }

    public final synchronized void zze(zzfdk zzfdk, zzfdn zzfdn) {
        zzfzp zzfzp = this.zzm;
        if (zzfzp != null) {
            zzfzg.zzr(zzfzp, new zzdtf(this, zzfdk, zzfdn), this.zzg);
        }
    }

    public final synchronized void zzf() {
        zzfzp zzfzp = this.zzm;
        if (zzfzp != null) {
            zzfzg.zzr(zzfzp, new zzdtb(this), this.zzg);
            this.zzm = null;
        }
    }

    public final synchronized void zzg(String str, Map map) {
        zzfzp zzfzp = this.zzm;
        if (zzfzp != null) {
            zzfzg.zzr(zzfzp, new zzdte(this, "sendMessageToNativeJs", map), this.zzg);
        }
    }

    public final synchronized void zzh() {
        Context context = this.zzd;
        zzcgv zzcgv = this.zzi;
        zzbiu zzbiu = zzbjc.zzcR;
        this.zzm = zzfzg.zzm(zzfzg.zzl(new zzcmy(context, this.zzh, zzcgv, this.zzb, (String) zzay.zzc().zzb(zzbiu)), zzchc.zze), new zzdta(this), this.zzg);
        zzchf.zza(this.zzm, "NativeJavascriptExecutor.initializeEngine");
    }

    public final synchronized void zzi(String str, zzbpu zzbpu) {
        zzfzp zzfzp = this.zzm;
        if (zzfzp != null) {
            zzfzg.zzr(zzfzp, new zzdtc(this, str, zzbpu), this.zzg);
        }
    }

    public final void zzj(WeakReference weakReference, String str, zzbpu zzbpu) {
        zzi(str, new zzdtm(this, weakReference, str, zzbpu, (zzdtl) null));
    }

    public final synchronized void zzk(String str, zzbpu zzbpu) {
        zzfzp zzfzp = this.zzm;
        if (zzfzp != null) {
            zzfzg.zzr(zzfzp, new zzdtd(this, str, zzbpu), this.zzg);
        }
    }
}
