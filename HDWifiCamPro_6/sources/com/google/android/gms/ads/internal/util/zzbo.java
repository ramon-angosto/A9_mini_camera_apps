package com.google.android.gms.ads.internal.util;

import android.content.Context;
import androidx.browser.trusted.sharing.ShareTarget;
import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.common.util.ClientLibraryUtils;
import com.google.android.gms.internal.ads.zzajl;
import com.google.android.gms.internal.ads.zzakg;
import com.google.android.gms.internal.ads.zzakr;
import com.google.android.gms.internal.ads.zzalk;
import com.google.android.gms.internal.ads.zzbjc;
import com.google.android.gms.internal.ads.zzcgo;
import com.google.android.gms.internal.ads.zzchh;
import com.google.android.gms.internal.ads.zzfzp;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzbo {
    @Deprecated
    public static final zzbj zza = new zzbg();
    private static zzakg zzb;
    private static final Object zzc = new Object();

    public zzbo(Context context) {
        zzakg zzakg;
        context = context.getApplicationContext() != null ? context.getApplicationContext() : context;
        synchronized (zzc) {
            if (zzb == null) {
                zzbjc.zzc(context);
                if (!ClientLibraryUtils.isPackageSide()) {
                    if (((Boolean) zzay.zzc().zzb(zzbjc.zzdC)).booleanValue()) {
                        zzakg = zzax.zzb(context);
                        zzb = zzakg;
                    }
                }
                zzakg = zzalk.zza(context, (zzakr) null);
                zzb = zzakg;
            }
        }
    }

    public final zzfzp zza(String str) {
        zzchh zzchh = new zzchh();
        zzb.zza(new zzbn(str, (Map) null, zzchh));
        return zzchh;
    }

    public final zzfzp zzb(int i, String str, Map map, byte[] bArr) {
        String str2 = str;
        zzbl zzbl = new zzbl((zzbk) null);
        zzbh zzbh = new zzbh(this, str2, zzbl);
        zzcgo zzcgo = new zzcgo((String) null);
        zzbi zzbi = new zzbi(this, i, str, zzbl, zzbh, bArr, map, zzcgo);
        if (zzcgo.zzl()) {
            try {
                zzcgo.zzd(str2, ShareTarget.METHOD_GET, zzbi.zzl(), zzbi.zzx());
            } catch (zzajl e) {
                zze.zzj(e.getMessage());
            }
        }
        zzb.zza(zzbi);
        return zzbl;
    }
}
