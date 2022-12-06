package com.google.android.gms.ads.internal;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.util.zzs;
import com.google.android.gms.internal.ads.zzcaq;
import com.google.android.gms.internal.ads.zzcdq;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzb {
    private final Context zza;
    private boolean zzb;
    private final zzcdq zzc;
    private final zzcaq zzd = new zzcaq(false, Collections.emptyList());

    public zzb(Context context, zzcdq zzcdq, zzcaq zzcaq) {
        this.zza = context;
        this.zzc = zzcdq;
    }

    private final boolean zzd() {
        zzcdq zzcdq = this.zzc;
        return (zzcdq != null && zzcdq.zza().zzf) || this.zzd.zza;
    }

    public final void zza() {
        this.zzb = true;
    }

    public final void zzb(String str) {
        List<String> list;
        if (zzd()) {
            if (str == null) {
                str = "";
            }
            zzcdq zzcdq = this.zzc;
            if (zzcdq != null) {
                zzcdq.zzd(str, (Map) null, 3);
                return;
            }
            zzcaq zzcaq = this.zzd;
            if (zzcaq.zza && (list = zzcaq.zzb) != null) {
                for (String str2 : list) {
                    if (!TextUtils.isEmpty(str2)) {
                        String replace = str2.replace("{NAVIGATION_URL}", Uri.encode(str));
                        zzt.zzp();
                        zzs.zzH(this.zza, "", replace);
                    }
                }
            }
        }
    }

    public final boolean zzc() {
        return !zzd() || this.zzb;
    }
}
