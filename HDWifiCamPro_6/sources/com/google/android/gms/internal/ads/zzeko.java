package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.common.util.Clock;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzeko {
    /* access modifiers changed from: private */
    public final Clock zza;
    /* access modifiers changed from: private */
    public final zzekp zzb;
    /* access modifiers changed from: private */
    public final zzfkm zzc;
    private final List zzd = Collections.synchronizedList(new ArrayList());
    /* access modifiers changed from: private */
    public final boolean zze;
    /* access modifiers changed from: private */
    public final zzehh zzf;

    public zzeko(Clock clock, zzekp zzekp, zzehh zzehh, zzfkm zzfkm) {
        this.zza = clock;
        this.zzb = zzekp;
        this.zze = ((Boolean) zzay.zzc().zzb(zzbjc.zzfV)).booleanValue();
        this.zzf = zzehh;
        this.zzc = zzfkm;
    }

    static /* bridge */ /* synthetic */ void zzg(zzeko zzeko, String str, int i, long j, String str2, Integer num) {
        String str3 = str + "." + i + "." + j;
        if (!TextUtils.isEmpty(str2)) {
            str3 = str3 + "." + str2;
        }
        if (((Boolean) zzay.zzc().zzb(zzbjc.zzbu)).booleanValue() && num != null && !TextUtils.isEmpty(str2)) {
            str3 = str3 + "." + num;
        }
        zzeko.zzd.add(str3);
    }

    /* access modifiers changed from: package-private */
    public final zzfzp zze(zzfdw zzfdw, zzfdk zzfdk, zzfzp zzfzp, zzfki zzfki) {
        zzfdn zzfdn = zzfdw.zzb.zzb;
        long elapsedRealtime = this.zza.elapsedRealtime();
        String str = zzfdk.zzx;
        if (str != null) {
            zzfzg.zzr(zzfzp, new zzekn(this, elapsedRealtime, str, zzfdk, zzfdn, zzfki, zzfdw), zzchc.zzf);
        }
        return zzfzp;
    }

    public final String zzf() {
        return TextUtils.join("_", this.zzd);
    }
}
