package com.google.android.gms.internal.ads;

import com.bytedance.sdk.openadsdk.api.init.PAGSdk;

/* compiled from: com.google.android.gms:play-services-ads-lite@@21.3.0 */
final class zzftf extends zzfti {
    final /* synthetic */ zzftg zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzftf(zzftg zzftg, zzftk zzftk, CharSequence charSequence) {
        super(zzftk, charSequence);
        this.zza = zzftg;
    }

    public final int zzc(int i) {
        return i;
    }

    public final int zzd(int i) {
        int i2 = i + PAGSdk.INIT_LOCAL_FAIL_CODE;
        if (i2 < this.zzb.length()) {
            return i2;
        }
        return -1;
    }
}
