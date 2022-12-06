package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.ads.internal.client.zzq;
import com.google.android.gms.ads.internal.zzb;
import com.google.android.gms.ads.internal.zzt;
import java.util.concurrent.Executor;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzdsi {
    private final zzfef zza;
    private final Executor zzb;
    private final zzduy zzc;
    private final zzdtt zzd;
    private final Context zze;
    private final zzdxq zzf;
    private final zzfir zzg;
    private final zzfkm zzh;
    private final zzego zzi;

    public zzdsi(zzfef zzfef, Executor executor, zzduy zzduy, Context context, zzdxq zzdxq, zzfir zzfir, zzfkm zzfkm, zzego zzego, zzdtt zzdtt) {
        this.zza = zzfef;
        this.zzb = executor;
        this.zzc = zzduy;
        this.zze = context;
        this.zzf = zzdxq;
        this.zzg = zzfir;
        this.zzh = zzfkm;
        this.zzi = zzego;
        this.zzd = zzdtt;
    }

    private final void zzh(zzcmp zzcmp) {
        zzi(zzcmp);
        zzcmp.zzaf("/video", zzbpt.zzl);
        zzcmp.zzaf("/videoMeta", zzbpt.zzm);
        zzcmp.zzaf("/precache", new zzclc());
        zzcmp.zzaf("/delayPageLoaded", zzbpt.zzp);
        zzcmp.zzaf("/instrument", zzbpt.zzn);
        zzcmp.zzaf("/log", zzbpt.zzg);
        zzcmp.zzaf("/click", zzbpt.zza((zzdkn) null));
        if (this.zza.zzb != null) {
            zzcmp.zzP().zzC(true);
            zzcmp.zzaf("/open", new zzbqf((zzb) null, (zzbxz) null, (zzego) null, (zzdxq) null, (zzfir) null));
        } else {
            zzcmp.zzP().zzC(false);
        }
        if (zzt.zzn().zzu(zzcmp.getContext())) {
            zzcmp.zzaf("/logScionEvent", new zzbqa(zzcmp.getContext()));
        }
    }

    private static final void zzi(zzcmp zzcmp) {
        zzcmp.zzaf("/videoClicked", zzbpt.zzh);
        zzcmp.zzP().zzE(true);
        if (((Boolean) zzay.zzc().zzb(zzbjc.zzcT)).booleanValue()) {
            zzcmp.zzaf("/getNativeAdViewSignals", zzbpt.zzs);
        }
        zzcmp.zzaf("/getNativeClickMeta", zzbpt.zzt);
    }

    public final zzfzp zza(JSONObject jSONObject) {
        return zzfzg.zzn(zzfzg.zzn(zzfzg.zzi((Object) null), new zzdry(this), this.zzb), new zzdrz(this, jSONObject), this.zzb);
    }

    public final zzfzp zzb(String str, String str2, zzfdk zzfdk, zzfdn zzfdn, zzq zzq) {
        return zzfzg.zzn(zzfzg.zzi((Object) null), new zzdsb(this, zzq, zzfdk, zzfdn, str, str2), this.zzb);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzfzp zzc(JSONObject jSONObject, zzcmp zzcmp) throws Exception {
        zzchg zza2 = zzchg.zza(zzcmp);
        if (this.zza.zzb != null) {
            zzcmp.zzai(zzcoe.zzd());
        } else {
            zzcmp.zzai(zzcoe.zze());
        }
        zzcmp.zzP().zzz(new zzdrx(this, zzcmp, zza2));
        zzcmp.zzl("google.afma.nativeAds.renderVideo", jSONObject);
        return zza2;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzfzp zzd(zzq zzq, zzfdk zzfdk, zzfdn zzfdn, String str, String str2, Object obj) throws Exception {
        zzcmp zza2 = this.zzc.zza(zzq, zzfdk, zzfdn);
        zzchg zza3 = zzchg.zza(zza2);
        if (this.zza.zzb != null) {
            zzh(zza2);
            zza2.zzai(zzcoe.zzd());
        } else {
            zzdtq zzb2 = this.zzd.zzb();
            zzdtq zzdtq = zzb2;
            zzdtq zzdtq2 = zzb2;
            zzdtq zzdtq3 = zzb2;
            zzdtq zzdtq4 = zzb2;
            zzdtq zzdtq5 = zzb2;
            zzdtq zzdtq6 = zzb2;
            zzcoc zzP = zza2.zzP();
            zzb zzb3 = r3;
            zzb zzb4 = new zzb(this.zze, (zzcdq) null, (zzcaq) null);
            zzP.zzL(zzdtq, zzdtq5, zzdtq2, zzdtq4, zzdtq6, false, (zzbpx) null, zzb3, (zzbyg) null, (zzcdq) null, this.zzi, this.zzh, this.zzf, this.zzg, (zzbpv) null, zzdtq3, (zzbqm) null, (zzbqg) null);
            zzi(zza2);
        }
        zza2.zzP().zzz(new zzdsc(this, zza2, zza3));
        zza2.zzad(str, str2, (String) null);
        return zza3;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzfzp zze(Object obj) throws Exception {
        zzcmp zza2 = this.zzc.zza(zzq.zzc(), (zzfdk) null, (zzfdn) null);
        zzchg zza3 = zzchg.zza(zza2);
        zzh(zza2);
        zza2.zzP().zzF(new zzdsa(zza3));
        zza2.loadUrl((String) zzay.zzc().zzb(zzbjc.zzcS));
        return zza3;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzf(zzcmp zzcmp, zzchg zzchg, boolean z) {
        if (!(this.zza.zza == null || zzcmp.zzs() == null)) {
            zzcmp.zzs().zzs(this.zza.zza);
        }
        zzchg.zzb();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzg(zzcmp zzcmp, zzchg zzchg, boolean z) {
        if (z) {
            if (!(this.zza.zza == null || zzcmp.zzs() == null)) {
                zzcmp.zzs().zzs(this.zza.zza);
            }
            zzchg.zzb();
            return;
        }
        zzchg.zze(new zzekr(1, "Html video Web View failed to load."));
    }
}
