package com.google.android.gms.internal.ads;

import com.shix.shixipc.viewpager.ImagePagerActivity;

/* compiled from: com.google.android.gms:play-services-ads-lite@@21.3.0 */
final class zzftd extends zzfti {
    final /* synthetic */ zzfte zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzftd(zzfte zzfte, zzftk zzftk, CharSequence charSequence) {
        super(zzftk, charSequence);
        this.zza = zzfte;
    }

    /* access modifiers changed from: package-private */
    public final int zzc(int i) {
        return i + 1;
    }

    /* access modifiers changed from: package-private */
    public final int zzd(int i) {
        zzfsj zzfsj = this.zza.zza;
        CharSequence charSequence = this.zzb;
        int length = charSequence.length();
        zzfsx.zzb(i, length, ImagePagerActivity.INDEX);
        while (i < length) {
            if (zzfsj.zzb(charSequence.charAt(i))) {
                return i;
            }
            i++;
        }
        return -1;
    }
}
