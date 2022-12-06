package com.google.android.gms.internal.ads;

import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import java.io.UnsupportedEncodingException;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public class zzali extends zzakd {
    private final Object zza = new Object();
    private final zzaki zzb;

    public zzali(int i, String str, zzaki zzaki, zzakh zzakh) {
        super(i, str, zzakh);
        this.zzb = zzaki;
    }

    /* access modifiers changed from: protected */
    public final zzakj zzh(zzajz zzajz) {
        String str;
        try {
            byte[] bArr = zzajz.zzb;
            Map map = zzajz.zzc;
            String str2 = "ISO-8859-1";
            if (map != null) {
                String str3 = (String) map.get(HttpHeaders.CONTENT_TYPE);
                if (str3 != null) {
                    String[] split = str3.split(";", 0);
                    int i = 1;
                    while (true) {
                        if (i >= split.length) {
                            break;
                        }
                        String[] split2 = split[i].trim().split("=", 0);
                        if (split2.length == 2 && split2[0].equals("charset")) {
                            str2 = split2[1];
                            break;
                        }
                        i++;
                    }
                }
            }
            str = new String(bArr, str2);
        } catch (UnsupportedEncodingException unused) {
            str = new String(zzajz.zzb);
        }
        return zzakj.zzb(str, zzala.zzb(zzajz));
    }

    /* access modifiers changed from: protected */
    /* renamed from: zzz */
    public void zzo(String str) {
        zzaki zzaki;
        synchronized (this.zza) {
            zzaki = this.zzb;
        }
        zzaki.zza(str);
    }
}
