package com.google.android.gms.internal.ads;

import java.util.Set;
import javax.annotation.CheckForNull;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzfyk extends zzfyi {
    private zzfyk() {
        super((zzfyh) null);
    }

    /* synthetic */ zzfyk(zzfyh zzfyh) {
        super((zzfyh) null);
    }

    /* access modifiers changed from: package-private */
    public final int zza(zzfyl zzfyl) {
        int zzA;
        synchronized (zzfyl) {
            zzA = zzfyl.zzA(zzfyl);
        }
        return zzA;
    }

    /* access modifiers changed from: package-private */
    public final void zzb(zzfyl zzfyl, @CheckForNull Set set, Set set2) {
        synchronized (zzfyl) {
            if (zzfyl.seenExceptions == null) {
                Set unused = zzfyl.seenExceptions = set2;
            }
        }
    }
}
