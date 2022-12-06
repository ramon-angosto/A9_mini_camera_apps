package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.android.gms.ads.AdFormat;
import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.ads.internal.client.zze;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzfju implements Runnable {
    private final List zza = new ArrayList();
    private final zzfjw zzb;
    private String zzc;
    private String zzd;
    private zzfdv zze;
    private zze zzf;
    private Future zzg;
    private int zzh = 2;

    zzfju(zzfjw zzfjw) {
        this.zzb = zzfjw;
    }

    public final synchronized void run() {
        zzg();
    }

    public final synchronized zzfju zza(zzfjj zzfjj) {
        if (((Boolean) zzbkl.zzc.zze()).booleanValue()) {
            List list = this.zza;
            zzfjj.zzg();
            list.add(zzfjj);
            Future future = this.zzg;
            if (future != null) {
                future.cancel(false);
            }
            this.zzg = zzchc.zzd.schedule(this, (long) ((Integer) zzay.zzc().zzb(zzbjc.zzhz)).intValue(), TimeUnit.MILLISECONDS);
        }
        return this;
    }

    public final synchronized zzfju zzb(String str) {
        if (((Boolean) zzbkl.zzc.zze()).booleanValue() && zzfjt.zze(str)) {
            this.zzc = str;
        }
        return this;
    }

    public final synchronized zzfju zzc(zze zze2) {
        if (((Boolean) zzbkl.zzc.zze()).booleanValue()) {
            this.zzf = zze2;
        }
        return this;
    }

    public final synchronized zzfju zzd(ArrayList arrayList) {
        if (((Boolean) zzbkl.zzc.zze()).booleanValue()) {
            if (!arrayList.contains("banner")) {
                if (!arrayList.contains(AdFormat.BANNER.name())) {
                    if (!arrayList.contains(IronSourceConstants.AD_UNIT_IS_MEDIATION_STATE)) {
                        if (!arrayList.contains(AdFormat.INTERSTITIAL.name())) {
                            if (!arrayList.contains("native")) {
                                if (!arrayList.contains(AdFormat.NATIVE.name())) {
                                    if (!arrayList.contains("rewarded")) {
                                        if (!arrayList.contains(AdFormat.REWARDED.name())) {
                                            if (arrayList.contains("app_open_ad")) {
                                                this.zzh = 7;
                                            } else if (arrayList.contains("rewarded_interstitial") || arrayList.contains(AdFormat.REWARDED_INTERSTITIAL.name())) {
                                                this.zzh = 6;
                                            }
                                        }
                                    }
                                    this.zzh = 5;
                                }
                            }
                            this.zzh = 8;
                        }
                    }
                    this.zzh = 4;
                }
            }
            this.zzh = 3;
        }
        return this;
    }

    public final synchronized zzfju zze(String str) {
        if (((Boolean) zzbkl.zzc.zze()).booleanValue()) {
            this.zzd = str;
        }
        return this;
    }

    public final synchronized zzfju zzf(zzfdv zzfdv) {
        if (((Boolean) zzbkl.zzc.zze()).booleanValue()) {
            this.zze = zzfdv;
        }
        return this;
    }

    public final synchronized void zzg() {
        if (((Boolean) zzbkl.zzc.zze()).booleanValue()) {
            Future future = this.zzg;
            if (future != null) {
                future.cancel(false);
            }
            for (zzfjj zzfjj : this.zza) {
                int i = this.zzh;
                if (i != 2) {
                    zzfjj.zzk(i);
                }
                if (!TextUtils.isEmpty(this.zzc)) {
                    zzfjj.zzd(this.zzc);
                }
                if (!TextUtils.isEmpty(this.zzd) && !zzfjj.zzi()) {
                    zzfjj.zzc(this.zzd);
                }
                zzfdv zzfdv = this.zze;
                if (zzfdv != null) {
                    zzfjj.zzb(zzfdv);
                } else {
                    zze zze2 = this.zzf;
                    if (zze2 != null) {
                        zzfjj.zza(zze2);
                    }
                }
                this.zzb.zzb(zzfjj.zzj());
            }
            this.zza.clear();
        }
    }

    public final synchronized zzfju zzh(int i) {
        if (((Boolean) zzbkl.zzc.zze()).booleanValue()) {
            this.zzh = i;
        }
        return this;
    }
}
