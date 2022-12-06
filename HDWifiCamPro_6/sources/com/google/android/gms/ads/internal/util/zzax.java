package com.google.android.gms.ads.internal.util;

import android.content.Context;
import com.google.android.gms.ads.internal.client.zzaw;
import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.internal.ads.zzajz;
import com.google.android.gms.internal.ads.zzakd;
import com.google.android.gms.internal.ads.zzakg;
import com.google.android.gms.internal.ads.zzakm;
import com.google.android.gms.internal.ads.zzakr;
import com.google.android.gms.internal.ads.zzaks;
import com.google.android.gms.internal.ads.zzakz;
import com.google.android.gms.internal.ads.zzald;
import com.google.android.gms.internal.ads.zzale;
import com.google.android.gms.internal.ads.zzbjc;
import com.google.android.gms.internal.ads.zzbrp;
import com.google.android.gms.internal.ads.zzcgi;
import java.io.File;
import java.util.regex.Pattern;
import javax.net.ssl.SSLSocketFactory;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzax extends zzaks {
    private final Context zzc;

    private zzax(Context context, zzakr zzakr) {
        super(zzakr);
        this.zzc = context;
    }

    public static zzakg zzb(Context context) {
        zzakg zzakg = new zzakg(new zzakz(new File(context.getCacheDir(), "admob_volley"), 20971520), new zzax(context, new zzale((zzald) null, (SSLSocketFactory) null)), 4);
        zzakg.zzd();
        return zzakg;
    }

    public final zzajz zza(zzakd zzakd) throws zzakm {
        if (zzakd.zza() == 0) {
            if (Pattern.matches((String) zzay.zzc().zzb(zzbjc.zzdD), zzakd.zzk())) {
                zzaw.zzb();
                if (zzcgi.zzr(this.zzc, 13400000)) {
                    zzajz zza = new zzbrp(this.zzc).zza(zzakd);
                    if (zza != null) {
                        zze.zza("Got gmscore asset response: ".concat(String.valueOf(zzakd.zzk())));
                        return zza;
                    }
                    zze.zza("Failed to get gmscore asset response: ".concat(String.valueOf(zzakd.zzk())));
                }
            }
        }
        return super.zza(zzakd);
    }
}
