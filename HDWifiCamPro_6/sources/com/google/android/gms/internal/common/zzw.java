package com.google.android.gms.internal.common;

import javax.annotation.CheckForNull;

/* compiled from: com.google.android.gms:play-services-basement@@18.0.0 */
abstract class zzw extends zzj<String> {
    final CharSequence zzb;
    final zzo zzc;
    final boolean zzd;
    int zze = 0;
    int zzf;

    protected zzw(zzx zzx, CharSequence charSequence) {
        this.zzc = zzx.zza;
        this.zzd = zzx.zzb;
        this.zzf = Integer.MAX_VALUE;
        this.zzb = charSequence;
    }

    /* access modifiers changed from: protected */
    @CheckForNull
    public final /* bridge */ /* synthetic */ Object zza() {
        int zzd2;
        int i;
        int i2 = this.zze;
        while (true) {
            int i3 = this.zze;
            if (i3 != -1) {
                zzd2 = zzd(i3);
                if (zzd2 == -1) {
                    zzd2 = this.zzb.length();
                    this.zze = -1;
                    i = -1;
                } else {
                    i = zzc(zzd2);
                    this.zze = i;
                }
                if (i == i2) {
                    int i4 = i + 1;
                    this.zze = i4;
                    if (i4 > this.zzb.length()) {
                        this.zze = -1;
                    }
                } else {
                    if (i2 < zzd2) {
                        this.zzb.charAt(i2);
                    }
                    if (i2 < zzd2) {
                        this.zzb.charAt(zzd2 - 1);
                    }
                    if (!this.zzd || i2 != zzd2) {
                        int i5 = this.zzf;
                    } else {
                        i2 = this.zze;
                    }
                }
            } else {
                zzb();
                return null;
            }
        }
        int i52 = this.zzf;
        if (i52 == 1) {
            zzd2 = this.zzb.length();
            this.zze = -1;
            if (zzd2 > i2) {
                this.zzb.charAt(zzd2 - 1);
            }
        } else {
            this.zzf = i52 - 1;
        }
        return this.zzb.subSequence(i2, zzd2).toString();
    }

    /* access modifiers changed from: package-private */
    public abstract int zzc(int i);

    /* access modifiers changed from: package-private */
    public abstract int zzd(int i);
}
