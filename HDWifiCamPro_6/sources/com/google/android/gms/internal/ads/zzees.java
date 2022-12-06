package com.google.android.gms.internal.ads;

import android.content.Context;
import android.text.TextUtils;
import androidx.browser.customtabs.CustomTabsCallback;
import androidx.core.app.NotificationCompat;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.internal.client.zza;
import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.ads.internal.client.zze;
import com.google.android.gms.ads.internal.util.zzs;
import com.google.android.gms.ads.internal.zzt;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.regex.Pattern;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzees implements zzdhr, zza, zzddu, zzdde {
    private final Context zza;
    private final zzfeu zzb;
    private final zzfdw zzc;
    private final zzfdk zzd;
    private final zzego zze;
    private Boolean zzf;
    private final boolean zzg = ((Boolean) zzay.zzc().zzb(zzbjc.zzfU)).booleanValue();
    private final zzfir zzh;
    private final String zzi;

    public zzees(Context context, zzfeu zzfeu, zzfdw zzfdw, zzfdk zzfdk, zzego zzego, zzfir zzfir, String str) {
        this.zza = context;
        this.zzb = zzfeu;
        this.zzc = zzfdw;
        this.zzd = zzfdk;
        this.zze = zzego;
        this.zzh = zzfir;
        this.zzi = str;
    }

    private final zzfiq zzf(String str) {
        zzfiq zzb2 = zzfiq.zzb(str);
        zzb2.zzh(this.zzc, (zzcgc) null);
        zzb2.zzf(this.zzd);
        zzb2.zza("request_id", this.zzi);
        if (!this.zzd.zzu.isEmpty()) {
            zzb2.zza("ancn", (String) this.zzd.zzu.get(0));
        }
        if (this.zzd.zzak) {
            zzb2.zza("device_connectivity", true != zzt.zzo().zzv(this.zza) ? "offline" : CustomTabsCallback.ONLINE_EXTRAS_KEY);
            zzb2.zza("event_timestamp", String.valueOf(zzt.zzB().currentTimeMillis()));
            zzb2.zza("offline_ad", "1");
        }
        return zzb2;
    }

    private final void zzg(zzfiq zzfiq) {
        if (this.zzd.zzak) {
            this.zze.zzd(new zzegq(zzt.zzB().currentTimeMillis(), this.zzc.zzb.zzb.zzb, this.zzh.zza(zzfiq), 2));
            return;
        }
        this.zzh.zzb(zzfiq);
    }

    private final boolean zzh() {
        if (this.zzf == null) {
            synchronized (this) {
                if (this.zzf == null) {
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
                    this.zzf = Boolean.valueOf(z);
                }
            }
        }
        return this.zzf.booleanValue();
    }

    public final void onAdClicked() {
        if (this.zzd.zzak) {
            zzg(zzf(CampaignEx.JSON_NATIVE_VIDEO_CLICK));
        }
    }

    public final void zza(zze zze2) {
        zze zze3;
        if (this.zzg) {
            int i = zze2.zza;
            String str = zze2.zzb;
            if (zze2.zzc.equals(MobileAds.ERROR_DOMAIN) && (zze3 = zze2.zzd) != null && !zze3.zzc.equals(MobileAds.ERROR_DOMAIN)) {
                zze zze4 = zze2.zzd;
                i = zze4.zza;
                str = zze4.zzb;
            }
            String zza2 = this.zzb.zza(str);
            zzfiq zzf2 = zzf("ifts");
            zzf2.zza(IronSourceConstants.EVENTS_ERROR_REASON, "adapter");
            if (i >= 0) {
                zzf2.zza("arec", String.valueOf(i));
            }
            if (zza2 != null) {
                zzf2.zza("areec", zza2);
            }
            this.zzh.zzb(zzf2);
        }
    }

    public final void zzb() {
        if (this.zzg) {
            zzfir zzfir = this.zzh;
            zzfiq zzf2 = zzf("ifts");
            zzf2.zza(IronSourceConstants.EVENTS_ERROR_REASON, "blocked");
            zzfir.zzb(zzf2);
        }
    }

    public final void zzc(zzdmo zzdmo) {
        if (this.zzg) {
            zzfiq zzf2 = zzf("ifts");
            zzf2.zza(IronSourceConstants.EVENTS_ERROR_REASON, "exception");
            if (!TextUtils.isEmpty(zzdmo.getMessage())) {
                zzf2.zza(NotificationCompat.CATEGORY_MESSAGE, zzdmo.getMessage());
            }
            this.zzh.zzb(zzf2);
        }
    }

    public final void zzd() {
        if (zzh()) {
            this.zzh.zzb(zzf("adapter_shown"));
        }
    }

    public final void zze() {
        if (zzh()) {
            this.zzh.zzb(zzf("adapter_impression"));
        }
    }

    public final void zzl() {
        if (zzh() || this.zzd.zzak) {
            zzg(zzf("impression"));
        }
    }
}
