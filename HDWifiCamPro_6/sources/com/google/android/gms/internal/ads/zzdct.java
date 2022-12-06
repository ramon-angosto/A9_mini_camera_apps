package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.ads.internal.client.zzdg;
import com.google.android.gms.ads.internal.client.zzu;
import com.google.android.gms.ads.internal.zzt;
import java.util.List;
import org.json.JSONException;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzdct extends zzdg {
    private final String zza;
    private final String zzb;
    private final String zzc;
    private final String zzd;
    private final List zze;
    private final long zzf;
    private final String zzg;
    private final zzehh zzh;
    private final Bundle zzi;

    public zzdct(zzfdk zzfdk, String str, zzehh zzehh, zzfdn zzfdn, String str2) {
        String str3;
        String str4;
        String str5 = null;
        if (zzfdk == null) {
            str3 = null;
        } else {
            str3 = zzfdk.zzac;
        }
        this.zzb = str3;
        this.zzc = str2;
        if (zzfdn == null) {
            str4 = null;
        } else {
            str4 = zzfdn.zzb;
        }
        this.zzd = str4;
        if ("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter".equals(str) || "com.google.ads.mediation.customevent.CustomEventAdapter".equals(str)) {
            try {
                str5 = zzfdk.zzw.getString("class_name");
            } catch (JSONException unused) {
            }
        }
        this.zza = str5 != null ? str5 : str;
        this.zze = zzehh.zzc();
        this.zzh = zzehh;
        this.zzf = zzt.zzB().currentTimeMillis() / 1000;
        if (!((Boolean) zzay.zzc().zzb(zzbjc.zzfT)).booleanValue() || zzfdn == null) {
            this.zzi = new Bundle();
        } else {
            this.zzi = zzfdn.zzj;
        }
        this.zzg = (!((Boolean) zzay.zzc().zzb(zzbjc.zzhV)).booleanValue() || zzfdn == null || TextUtils.isEmpty(zzfdn.zzh)) ? "" : zzfdn.zzh;
    }

    public final long zzc() {
        return this.zzf;
    }

    public final String zzd() {
        return this.zzg;
    }

    public final Bundle zze() {
        return this.zzi;
    }

    public final zzu zzf() {
        zzehh zzehh = this.zzh;
        if (zzehh != null) {
            return zzehh.zza();
        }
        return null;
    }

    public final String zzg() {
        return this.zza;
    }

    public final String zzh() {
        return this.zzc;
    }

    public final String zzi() {
        return this.zzb;
    }

    public final List zzj() {
        return this.zze;
    }

    public final String zzk() {
        return this.zzd;
    }
}
