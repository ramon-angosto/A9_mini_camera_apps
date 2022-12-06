package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.ads.internal.util.zze;
import java.util.HashMap;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzeer implements zzfhk {
    private static final Pattern zza = Pattern.compile("([^;]+=[^;]+)(;\\s|$)", 2);
    private final String zzb;
    private final zzfjj zzc;
    private final zzfju zzd;

    public zzeer(String str, zzfju zzfju, zzfjj zzfjj) {
        this.zzb = str;
        this.zzd = zzfju;
        this.zzc = zzfjj;
    }

    public final /* bridge */ /* synthetic */ Object zza(Object obj) throws Exception {
        String str;
        zzeeq zzeeq = (zzeeq) obj;
        int optInt = zzeeq.zza.optInt("http_timeout_millis", 60000);
        zzcbf zza2 = zzeeq.zzb;
        String str2 = "";
        if (zza2.zza() == -2) {
            HashMap hashMap = new HashMap();
            if (zzeeq.zzb.zzh() && !TextUtils.isEmpty(this.zzb)) {
                if (((Boolean) zzay.zzc().zzb(zzbjc.zzaI)).booleanValue()) {
                    String str3 = this.zzb;
                    if (TextUtils.isEmpty(str3)) {
                        str = str2;
                    } else {
                        Matcher matcher = zza.matcher(str3);
                        str = str2;
                        while (matcher.find()) {
                            String group = matcher.group(1);
                            if (group != null && (group.toLowerCase(Locale.ROOT).startsWith("id=") || group.toLowerCase(Locale.ROOT).startsWith("ide="))) {
                                if (!TextUtils.isEmpty(str)) {
                                    str = str.concat("; ");
                                }
                                str = str.concat(group);
                            }
                        }
                    }
                    if (!TextUtils.isEmpty(str)) {
                        hashMap.put("Cookie", str);
                    }
                } else {
                    hashMap.put("Cookie", this.zzb);
                }
            }
            if (zzeeq.zzb.zzi()) {
                JSONObject optJSONObject = zzeeq.zza.optJSONObject("pii");
                if (optJSONObject != null) {
                    if (!TextUtils.isEmpty(optJSONObject.optString("doritos", str2))) {
                        hashMap.put("x-afma-drt-cookie", optJSONObject.optString("doritos", str2));
                    }
                    if (!TextUtils.isEmpty(optJSONObject.optString("doritos_v2", str2))) {
                        hashMap.put("x-afma-drt-v2-cookie", optJSONObject.optString("doritos_v2", str2));
                    }
                } else {
                    zze.zza("DSID signal does not exist.");
                }
            }
            if (zzeeq.zzb != null && !TextUtils.isEmpty(zzeeq.zzb.zzd())) {
                str2 = zzeeq.zzb.zzd();
            }
            zzfju zzfju = this.zzd;
            zzfjj zzfjj = this.zzc;
            zzfjj.zze(true);
            zzfju.zza(zzfjj);
            return new zzeem(zzeeq.zzb.zze(), optInt, hashMap, str2.getBytes(zzfsk.zzc), "");
        }
        zzfju zzfju2 = this.zzd;
        zzfjj zzfjj2 = this.zzc;
        zzfjj2.zze(false);
        zzfju2.zza(zzfjj2);
        if (zza2.zza() == 1) {
            if (zza2.zzf() != null) {
                str2 = TextUtils.join(", ", zza2.zzf());
                zze.zzg(str2);
            }
            throw new zzebh(2, "Error building request URL: ".concat(String.valueOf(str2)));
        }
        throw new zzebh(1);
    }
}
