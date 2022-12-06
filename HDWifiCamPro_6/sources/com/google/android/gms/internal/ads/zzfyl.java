package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzfxx;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.CheckForNull;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
abstract class zzfyl extends zzfxx.zzi {
    private static final zzfyi zzaX;
    private static final Logger zzaY;
    private volatile int remaining;
    /* access modifiers changed from: private */
    @CheckForNull
    public volatile Set<Throwable> seenExceptions = null;

    static {
        Throwable th;
        zzfyi zzfyi;
        Class<zzfyl> cls = zzfyl.class;
        zzaY = Logger.getLogger(cls.getName());
        try {
            zzfyi = new zzfyj(AtomicReferenceFieldUpdater.newUpdater(cls, Set.class, "seenExceptions"), AtomicIntegerFieldUpdater.newUpdater(cls, "remaining"));
            th = null;
        } catch (Error | RuntimeException e) {
            zzfyi = new zzfyk((zzfyh) null);
            th = e;
        }
        zzaX = zzfyi;
        if (th != null) {
            zzaY.logp(Level.SEVERE, "com.google.common.util.concurrent.AggregateFutureState", "<clinit>", "SafeAtomicHelper is broken!", th);
        }
    }

    zzfyl(int i) {
        this.remaining = i;
    }

    static /* synthetic */ int zzA(zzfyl zzfyl) {
        int i = zzfyl.remaining - 1;
        zzfyl.remaining = i;
        return i;
    }

    /* access modifiers changed from: package-private */
    public final int zzB() {
        return zzaX.zza(this);
    }

    /* access modifiers changed from: package-private */
    public final Set zzE() {
        Set<Throwable> set = this.seenExceptions;
        if (set != null) {
            return set;
        }
        Set newSetFromMap = Collections.newSetFromMap(new ConcurrentHashMap());
        zzf(newSetFromMap);
        zzaX.zzb(this, (Set) null, newSetFromMap);
        Set<Throwable> set2 = this.seenExceptions;
        set2.getClass();
        return set2;
    }

    /* access modifiers changed from: package-private */
    public final void zzF() {
        this.seenExceptions = null;
    }

    /* access modifiers changed from: package-private */
    public abstract void zzf(Set set);
}
