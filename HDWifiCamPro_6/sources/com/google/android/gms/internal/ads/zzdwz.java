package com.google.android.gms.internal.ads;

import android.content.Context;
import android.text.TextUtils;
import androidx.browser.customtabs.CustomTabsCallback;
import androidx.core.app.NotificationCompat;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.internal.client.zza;
import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.ads.internal.client.zze;
import com.google.android.gms.ads.internal.client.zzl;
import com.google.android.gms.ads.internal.util.zzs;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.ads.nonagon.signalgeneration.zzf;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.regex.Pattern;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzdwz implements zzdhr, zza, zzddu, zzdde {
    private final Context zza;
    private final zzfeu zzb;
    private final zzdxq zzc;
    private final zzfdw zzd;
    private final zzfdk zze;
    private final zzego zzf;
    private Boolean zzg;
    private final boolean zzh = ((Boolean) zzay.zzc().zzb(zzbjc.zzfU)).booleanValue();

    public zzdwz(Context context, zzfeu zzfeu, zzdxq zzdxq, zzfdw zzfdw, zzfdk zzfdk, zzego zzego) {
        this.zza = context;
        this.zzb = zzfeu;
        this.zzc = zzdxq;
        this.zzd = zzfdw;
        this.zze = zzfdk;
        this.zzf = zzego;
    }

    private final zzdxp zzf(String str) {
        zzdxp zza2 = this.zzc.zza();
        zza2.zze(this.zzd.zzb.zzb);
        zza2.zzd(this.zze);
        zza2.zzb("action", str);
        boolean z = false;
        if (!this.zze.zzu.isEmpty()) {
            zza2.zzb("ancn", (String) this.zze.zzu.get(0));
        }
        if (this.zze.zzak) {
            zza2.zzb("device_connectivity", true != zzt.zzo().zzv(this.zza) ? "offline" : CustomTabsCallback.ONLINE_EXTRAS_KEY);
            zza2.zzb("event_timestamp", String.valueOf(zzt.zzB().currentTimeMillis()));
            zza2.zzb("offline_ad", "1");
        }
        if (((Boolean) zzay.zzc().zzb(zzbjc.zzgd)).booleanValue()) {
            if (zzf.zzd(this.zzd.zza.zza) != 1) {
                z = true;
            }
            zza2.zzb("scar", String.valueOf(z));
            if (z) {
                zzl zzl = this.zzd.zza.zza.zzd;
                zza2.zzc("ragent", zzl.zzp);
                zza2.zzc("rtype", zzf.zza(zzf.zzb(zzl)));
            }
        }
        return zza2;
    }

    private final void zzg(zzdxp zzdxp) {
        if (this.zze.zzak) {
            this.zzf.zzd(new zzegq(zzt.zzB().currentTimeMillis(), this.zzd.zzb.zzb.zzb, zzdxp.zzf(), 2));
            return;
        }
        zzdxp.zzg();
    }

    private final boolean zzh() {
        if (this.zzg == null) {
            synchronized (this) {
                if (this.zzg == null) {
                    String str = (String) zzay.zzc().zzb(zzbjc.zzbm);
                    zzt.zzp();
                    String zzo = zzs.zzo(this.zza);
                    boolean z = false;
                    if (!(str == null || zzo == null)) {
                        try {
                            z = Pattern.matches(str, zzo);
                        } catch (RuntimeException e) {
                            zzt.zzo().zzt(e, "CsiActionsListener.isPatternMatched");
                        }
                    }
                    this.zzg = Boolean.valueOf(z);
                }
            }
        }
        return this.zzg.booleanValue();
    }

    public final void onAdClicked() {
        if (this.zze.zzak) {
            zzg(zzf(CampaignEx.JSON_NATIVE_VIDEO_CLICK));
        }
    }

    public final void zza(zze zze2) {
        zze zze3;
        if (this.zzh) {
            zzdxp zzf2 = zzf("ifts");
            zzf2.zzb(IronSourceConstants.EVENTS_ERROR_REASON, "adapter");
            int i = zze2.zza;
            String str = zze2.zzb;
            if (zze2.zzc.equals(MobileAds.ERROR_DOMAIN) && (zze3 = zze2.zzd) != null && !zze3.zzc.equals(MobileAds.ERROR_DOMAIN)) {
                zze zze4 = zze2.zzd;
                i = zze4.zza;
                str = zze4.zzb;
            }
            if (i >= 0) {
                zzf2.zzb("arec", String.valueOf(i));
            }
            String zza2 = this.zzb.zza(str);
            if (zza2 != null) {
                zzf2.zzb("areec", zza2);
            }
            zzf2.zzg();
        }
    }

    public final void zzb() {
        if (this.zzh) {
            zzdxp zzf2 = zzf("ifts");
            zzf2.zzb(IronSourceConstants.EVENTS_ERROR_REASON, "blocked");
            zzf2.zzg();
        }
    }

    public final void zzc(zzdmo zzdmo) {
        if (this.zzh) {
            zzdxp zzf2 = zzf("ifts");
            zzf2.zzb(IronSourceConstants.EVENTS_ERROR_REASON, "exception");
            if (!TextUtils.isEmpty(zzdmo.getMessage())) {
                zzf2.zzb(NotificationCompat.CATEGORY_MESSAGE, zzdmo.getMessage());
            }
            zzf2.zzg();
        }
    }

    public final void zzd() {
        if (zzh()) {
            zzf("adapter_shown").zzg();
        }
    }

    public final void zze() {
        if (zzh()) {
            zzf("adapter_impression").zzg();
        }
    }

    public final void zzl() {
        if (zzh() || this.zze.zzak) {
            zzg(zzf("impression"));
        }
    }
}
