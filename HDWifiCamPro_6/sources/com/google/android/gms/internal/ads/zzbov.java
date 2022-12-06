package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.text.TextUtils;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final /* synthetic */ class zzbov implements zzfsm {
    public final /* synthetic */ String zza;

    public /* synthetic */ zzbov(String str) {
        this.zza = str;
    }

    public final Object apply(Object obj) {
        String str = this.zza;
        String str2 = (String) obj;
        zzbpu zzbpu = zzbpt.zza;
        if (str2 != null) {
            if (((Boolean) zzbkr.zzf.zze()).booleanValue()) {
                String[] strArr = {".doubleclick.net", ".googleadservices.com", ".googlesyndication.com"};
                String host = Uri.parse(str).getHost();
                int i = 0;
                while (true) {
                    if (i < 3) {
                        if (host.endsWith(strArr[i])) {
                            break;
                        }
                        i++;
                    } else {
                        break;
                    }
                }
            }
            String str3 = (String) zzbkr.zza.zze();
            String str4 = (String) zzbkr.zzb.zze();
            if (!TextUtils.isEmpty(str3)) {
                str = str.replace(str3, str2);
            }
            if (!TextUtils.isEmpty(str4)) {
                Uri parse = Uri.parse(str);
                if (TextUtils.isEmpty(parse.getQueryParameter(str4))) {
                    return parse.buildUpon().appendQueryParameter(str4, str2).toString();
                }
            }
        }
        return str;
    }
}
