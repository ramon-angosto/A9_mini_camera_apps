package com.google.android.gms.internal.ads;

import javax.annotation.CheckForNull;

/* compiled from: com.google.android.gms:play-services-ads-lite@@21.3.0 */
abstract class zzfti extends zzfsd {
    final CharSequence zzb;
    final zzfsj zzc;
    int zzd = 0;
    int zze;

    protected zzfti(zzftk zzftk, CharSequence charSequence) {
        this.zzc = zzftk.zza;
        this.zze = Integer.MAX_VALUE;
        this.zzb = charSequence;
    }

    /* access modifiers changed from: protected */
    @CheckForNull
    public final /* bridge */ /* synthetic */ Object zza() {
        int i;
        int i2 = this.zzd;
        while (true) {
            int i3 = this.zzd;
            if (i3 != -1) {
                int zzd2 = zzd(i3);
                if (zzd2 == -1) {
                    zzd2 = this.zzb.length();
                    this.zzd = -1;
                    i = -1;
                } else {
                    i = zzc(zzd2);
                    this.zzd = i;
                }
                if (i == i2) {
                    int i4 = i + 1;
                    this.zzd = i4;
                    if (i4 > this.zzb.length()) {
                        this.zzd = -1;
                    }
                } else {
                    if (i2 < zzd2) {
                        this.zzb.charAt(i2);
                    }
                    if (i2 < zzd2) {
                        this.zzb.charAt(zzd2 - 1);
                    }
                    int i5 = this.zze;
                    if (i5 == 1) {
                        zzd2 = this.zzb.length();
                        this.zzd = -1;
                        if (zzd2 > i2) {
                            this.zzb.charAt(zzd2 - 1);
                        }
                    } else {
                        this.zze = i5 - 1;
                    }
                    return this.zzb.subSequence(i2, zzd2).toString();
                }
            } else {
                zzb();
                return null;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public abstract int zzc(int i);

    /* access modifiers changed from: package-private */
    public abstract int zzd(int i);
}
