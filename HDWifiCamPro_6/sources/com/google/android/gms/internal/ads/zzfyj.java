package com.google.android.gms.internal.ads;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzfyj extends zzfyi {
    final AtomicReferenceFieldUpdater zza;
    final AtomicIntegerFieldUpdater zzb;

    zzfyj(AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, AtomicIntegerFieldUpdater atomicIntegerFieldUpdater) {
        super((zzfyh) null);
        this.zza = atomicReferenceFieldUpdater;
        this.zzb = atomicIntegerFieldUpdater;
    }

    /* access modifiers changed from: package-private */
    public final int zza(zzfyl zzfyl) {
        return this.zzb.decrementAndGet(zzfyl);
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:1:0x0002 A[LOOP:0: B:1:0x0002->B:4:0x000e, LOOP_START] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzb(com.google.android.gms.internal.ads.zzfyl r2, @javax.annotation.CheckForNull java.util.Set r3, java.util.Set r4) {
        /*
            r1 = this;
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r3 = r1.zza
        L_0x0002:
            r0 = 0
            boolean r0 = r3.compareAndSet(r2, r0, r4)
            if (r0 == 0) goto L_0x000a
            goto L_0x0010
        L_0x000a:
            java.lang.Object r0 = r3.get(r2)
            if (r0 == 0) goto L_0x0002
        L_0x0010:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzfyj.zzb(com.google.android.gms.internal.ads.zzfyl, java.util.Set, java.util.Set):void");
    }
}
