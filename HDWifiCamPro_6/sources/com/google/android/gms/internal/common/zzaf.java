package com.google.android.gms.internal.common;

import com.shix.shixipc.viewpager.ImagePagerActivity;
import java.util.List;
import javax.annotation.CheckForNull;

/* compiled from: com.google.android.gms:play-services-basement@@18.0.0 */
final class zzaf extends zzag {
    final transient int zza;
    final transient int zzb;
    final /* synthetic */ zzag zzc;

    zzaf(zzag zzag, int i, int i2) {
        this.zzc = zzag;
        this.zza = i;
        this.zzb = i2;
    }

    public final Object get(int i) {
        zzs.zza(i, this.zzb, ImagePagerActivity.INDEX);
        return this.zzc.get(i + this.zza);
    }

    public final int size() {
        return this.zzb;
    }

    public final /* bridge */ /* synthetic */ List subList(int i, int i2) {
        return subList(i, i2);
    }

    /* access modifiers changed from: package-private */
    public final int zzb() {
        return this.zzc.zzc() + this.zza + this.zzb;
    }

    /* access modifiers changed from: package-private */
    public final int zzc() {
        return this.zzc.zzc() + this.zza;
    }

    /* access modifiers changed from: package-private */
    public final boolean zzf() {
        return true;
    }

    /* access modifiers changed from: package-private */
    @CheckForNull
    public final Object[] zzg() {
        return this.zzc.zzg();
    }

    public final zzag zzh(int i, int i2) {
        zzs.zzc(i, i2, this.zzb);
        zzag zzag = this.zzc;
        int i3 = this.zza;
        return zzag.subList(i + i3, i2 + i3);
    }
}
