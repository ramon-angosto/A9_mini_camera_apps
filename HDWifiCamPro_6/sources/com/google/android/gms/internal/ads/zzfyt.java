package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import javax.annotation.CheckForNull;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzfyt extends zzfyg {
    /* access modifiers changed from: private */
    @CheckForNull
    public zzfys zza;

    zzfyt(zzfvi zzfvi, boolean z, Executor executor, Callable callable) {
        super(zzfvi, z, false);
        this.zza = new zzfyr(this, callable, executor);
        zzw();
    }

    /* access modifiers changed from: package-private */
    public final void zzg(int i, @CheckForNull Object obj) {
    }

    /* access modifiers changed from: protected */
    public final void zzr() {
        zzfys zzfys = this.zza;
        if (zzfys != null) {
            zzfys.zzh();
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzv() {
        zzfys zzfys = this.zza;
        if (zzfys != null) {
            zzfys.zzf();
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzz(int i) {
        super.zzz(i);
        if (i == 1) {
            this.zza = null;
        }
    }
}
