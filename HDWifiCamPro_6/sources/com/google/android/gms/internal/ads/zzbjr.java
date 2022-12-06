package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.ads.internal.zzt;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;

@Deprecated
@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzbjr {
    private final List zza = new LinkedList();
    private final Map zzb = new LinkedHashMap();
    private final Object zzc = new Object();

    public zzbjr(boolean z, String str, String str2) {
        this.zzb.put("action", "make_wv");
        this.zzb.put("ad_format", str2);
    }

    public static final zzbjo zzf() {
        return new zzbjo(zzt.zzB().elapsedRealtime(), (String) null, (zzbjo) null);
    }

    public final zzbjq zza() {
        zzbjq zzbjq;
        boolean booleanValue = ((Boolean) zzay.zzc().zzb(zzbjc.zzbD)).booleanValue();
        StringBuilder sb = new StringBuilder();
        HashMap hashMap = new HashMap();
        synchronized (this.zzc) {
            for (zzbjo zzbjo : this.zza) {
                long zza2 = zzbjo.zza();
                String zzc2 = zzbjo.zzc();
                zzbjo zzb2 = zzbjo.zzb();
                if (zzb2 != null && zza2 > 0) {
                    sb.append(zzc2);
                    sb.append('.');
                    sb.append(zza2 - zzb2.zza());
                    sb.append(',');
                    if (booleanValue) {
                        if (!hashMap.containsKey(Long.valueOf(zzb2.zza()))) {
                            hashMap.put(Long.valueOf(zzb2.zza()), new StringBuilder(zzc2));
                        } else {
                            StringBuilder sb2 = (StringBuilder) hashMap.get(Long.valueOf(zzb2.zza()));
                            sb2.append('+');
                            sb2.append(zzc2);
                        }
                    }
                }
            }
            this.zza.clear();
            String str = null;
            if (!TextUtils.isEmpty((CharSequence) null)) {
                sb.append((String) null);
            } else if (sb.length() > 0) {
                sb.setLength(sb.length() - 1);
            }
            StringBuilder sb3 = new StringBuilder();
            if (booleanValue) {
                for (Map.Entry entry : hashMap.entrySet()) {
                    sb3.append((CharSequence) entry.getValue());
                    sb3.append('.');
                    sb3.append(zzt.zzB().currentTimeMillis() + (((Long) entry.getKey()).longValue() - zzt.zzB().elapsedRealtime()));
                    sb3.append(',');
                }
                if (sb3.length() > 0) {
                    sb3.setLength(sb3.length() - 1);
                }
                str = sb3.toString();
            }
            zzbjq = new zzbjq(sb.toString(), str);
        }
        return zzbjq;
    }

    public final Map zzb() {
        Map map;
        synchronized (this.zzc) {
            zzt.zzo().zzf();
            map = this.zzb;
        }
        return map;
    }

    public final void zzc(zzbjr zzbjr) {
        synchronized (this.zzc) {
        }
    }

    public final void zzd(String str, String str2) {
        zzbjh zzf;
        if (!TextUtils.isEmpty(str2) && (zzf = zzt.zzo().zzf()) != null) {
            synchronized (this.zzc) {
                zzbjn zza2 = zzf.zza(str);
                Map map = this.zzb;
                map.put(str, zza2.zza((String) map.get(str), str2));
            }
        }
    }

    public final boolean zze(zzbjo zzbjo, long j, String... strArr) {
        synchronized (this.zzc) {
            for (int i = 0; i <= 0; i++) {
                this.zza.add(new zzbjo(j, strArr[i], zzbjo));
            }
        }
        return true;
    }
}
