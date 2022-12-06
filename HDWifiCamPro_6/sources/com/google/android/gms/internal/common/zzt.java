package com.google.android.gms.internal.common;

import com.shix.shixipc.viewpager.ImagePagerActivity;

/* compiled from: com.google.android.gms:play-services-basement@@18.0.0 */
final class zzt extends zzw {
    final /* synthetic */ zzu zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzt(zzu zzu, zzx zzx, CharSequence charSequence) {
        super(zzx, charSequence);
        this.zza = zzu;
    }

    /* access modifiers changed from: package-private */
    public final int zzc(int i) {
        return i + 1;
    }

    /* access modifiers changed from: package-private */
    public final int zzd(int i) {
        zzo zzo = this.zza.zza;
        CharSequence charSequence = this.zzb;
        int length = charSequence.length();
        zzs.zzb(i, length, ImagePagerActivity.INDEX);
        while (i < length) {
            if (zzo.zza(charSequence.charAt(i))) {
                return i;
            }
            i++;
        }
        return -1;
    }
}
