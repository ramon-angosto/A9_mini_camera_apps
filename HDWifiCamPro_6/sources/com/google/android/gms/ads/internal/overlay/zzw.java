package com.google.android.gms.ads.internal.overlay;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.internal.ads.zzbjc;
import com.google.android.gms.internal.ads.zzchc;
import com.google.android.gms.internal.ads.zzcmp;
import com.google.android.gms.internal.ads.zzfqq;
import com.google.android.gms.internal.ads.zzfqr;
import com.google.android.gms.internal.ads.zzfqs;
import com.google.android.gms.internal.ads.zzfqt;
import com.google.android.gms.internal.ads.zzfrc;
import com.google.android.gms.internal.ads.zzfre;
import com.google.android.gms.internal.ads.zzfrf;
import com.google.android.gms.internal.ads.zzfrg;
import com.google.android.gms.internal.ads.zzfrh;
import com.google.android.gms.internal.ads.zzfsb;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzw {
    private String zza = null;
    private String zzb = null;
    private zzcmp zzc = null;
    private zzfqs zzd = null;
    private boolean zze = false;
    private zzfrf zzf;

    private final zzfrh zzl() {
        zzfrg zzc2 = zzfrh.zzc();
        if (!((Boolean) zzay.zzc().zzb(zzbjc.zziT)).booleanValue() || TextUtils.isEmpty(this.zzb)) {
            String str = this.zza;
            if (str != null) {
                zzc2.zzb(str);
            } else {
                zzf("Missing session token and/or appId", "onLMDupdate");
            }
        } else {
            zzc2.zza(this.zzb);
        }
        return zzc2.zzc();
    }

    private final void zzm() {
        if (this.zzf == null) {
            this.zzf = new zzv(this);
        }
    }

    public final synchronized void zza(zzcmp zzcmp, Context context) {
        this.zzc = zzcmp;
        if (!zzk(context)) {
            zzf("Unable to bind", "on_play_store_bind");
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("action", "fetch_completed");
        zze("on_play_store_bind", hashMap);
    }

    public final void zzb() {
        zzfqs zzfqs;
        if (!this.zze || (zzfqs = this.zzd) == null) {
            zze.zza("LastMileDelivery not connected");
            return;
        }
        zzfqs.zza(zzl(), this.zzf);
        zzd("onLMDOverlayCollapse");
    }

    public final void zzc() {
        zzfqs zzfqs;
        if (!this.zze || (zzfqs = this.zzd) == null) {
            zze.zza("LastMileDelivery not connected");
            return;
        }
        zzfqq zzc2 = zzfqr.zzc();
        if (!((Boolean) zzay.zzc().zzb(zzbjc.zziT)).booleanValue() || TextUtils.isEmpty(this.zzb)) {
            String str = this.zza;
            if (str != null) {
                zzc2.zzb(str);
            } else {
                zzf("Missing session token and/or appId", "onLMDupdate");
            }
        } else {
            zzc2.zza(this.zzb);
        }
        zzfqs.zzb(zzc2.zzc(), this.zzf);
    }

    /* access modifiers changed from: package-private */
    public final void zzd(String str) {
        zze(str, new HashMap());
    }

    /* access modifiers changed from: package-private */
    public final void zze(String str, Map map) {
        zzchc.zze.execute(new zzu(this, str, map));
    }

    /* access modifiers changed from: package-private */
    public final void zzf(String str, String str2) {
        zze.zza(str);
        if (this.zzc != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("message", str);
            hashMap.put("action", str2);
            zze("onError", hashMap);
        }
    }

    public final void zzg() {
        zzfqs zzfqs;
        if (!this.zze || (zzfqs = this.zzd) == null) {
            zze.zza("LastMileDelivery not connected");
            return;
        }
        zzfqs.zzc(zzl(), this.zzf);
        zzd("onLMDOverlayExpand");
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzh(String str, Map map) {
        zzcmp zzcmp = this.zzc;
        if (zzcmp != null) {
            zzcmp.zzd(str, map);
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzi(zzfre zzfre) {
        if (!TextUtils.isEmpty(zzfre.zzb())) {
            if (!((Boolean) zzay.zzc().zzb(zzbjc.zziT)).booleanValue()) {
                this.zza = zzfre.zzb();
            }
        }
        switch (zzfre.zza()) {
            case 8152:
                zzd("onLMDOverlayOpened");
                return;
            case 8153:
                zzd("onLMDOverlayClicked");
                return;
            case 8155:
                zzd("onLMDOverlayClose");
                return;
            case 8157:
                this.zza = null;
                this.zzb = null;
                this.zze = false;
                return;
            case 8160:
            case 8161:
            case 8162:
                HashMap hashMap = new HashMap();
                hashMap.put(CampaignEx.JSON_NATIVE_VIDEO_ERROR, String.valueOf(zzfre.zza()));
                zze("onLMDOverlayFailedToOpen", hashMap);
                return;
            default:
                return;
        }
    }

    public final void zzj(zzcmp zzcmp, zzfrc zzfrc) {
        if (zzcmp == null) {
            zzf("adWebview missing", "onLMDShow");
            return;
        }
        this.zzc = zzcmp;
        if (this.zze || zzk(zzcmp.getContext())) {
            if (((Boolean) zzay.zzc().zzb(zzbjc.zziT)).booleanValue()) {
                this.zzb = zzfrc.zzg();
            }
            zzm();
            zzfqs zzfqs = this.zzd;
            if (zzfqs != null) {
                zzfqs.zzd(zzfrc, this.zzf);
                return;
            }
            return;
        }
        zzf("LMDOverlay not bound", "on_play_store_bind");
    }

    public final synchronized boolean zzk(Context context) {
        if (!zzfsb.zza(context)) {
            return false;
        }
        try {
            this.zzd = zzfqt.zza(context);
        } catch (NullPointerException e) {
            zze.zza("Error connecting LMD Overlay service");
            zzt.zzo().zzt(e, "LastMileDeliveryOverlay.bindLastMileDeliveryService");
        }
        if (this.zzd == null) {
            this.zze = false;
            return false;
        }
        zzm();
        this.zze = true;
        return true;
    }
}
