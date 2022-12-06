package com.google.android.gms.internal.ads;

import com.shix.shixipc.viewpager.ImagePagerActivity;
import java.util.NoSuchElementException;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
abstract class zzftp extends zzfxn {
    private final int zza;
    private int zzb;

    protected zzftp(int i, int i2) {
        zzfsx.zzb(i2, i, ImagePagerActivity.INDEX);
        this.zza = i;
        this.zzb = i2;
    }

    public final boolean hasNext() {
        return this.zzb < this.zza;
    }

    public final boolean hasPrevious() {
        return this.zzb > 0;
    }

    public final Object next() {
        if (hasNext()) {
            int i = this.zzb;
            this.zzb = i + 1;
            return zza(i);
        }
        throw new NoSuchElementException();
    }

    public final int nextIndex() {
        return this.zzb;
    }

    public final Object previous() {
        if (hasPrevious()) {
            int i = this.zzb - 1;
            this.zzb = i;
            return zza(i);
        }
        throw new NoSuchElementException();
    }

    public final int previousIndex() {
        return this.zzb - 1;
    }

    /* access modifiers changed from: protected */
    public abstract Object zza(int i);
}
