package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;

/* compiled from: com.google.android.gms:play-services-base@@18.0.0 */
public final class zadc {
    public static final Status zaa = new Status(8, "The connection to Google Play services was lost");
    final Set<BasePendingResult<?>> zab = Collections.synchronizedSet(Collections.newSetFromMap(new WeakHashMap()));
    private final zadb zac = new zadb(this);

    /* access modifiers changed from: package-private */
    public final void zaa(BasePendingResult<? extends Result> basePendingResult) {
        this.zab.add(basePendingResult);
        basePendingResult.zan(this.zac);
    }

    public final void zab() {
        for (BasePendingResult basePendingResult : (BasePendingResult[]) this.zab.toArray(new BasePendingResult[0])) {
            basePendingResult.zan((zadb) null);
            if (basePendingResult.zam()) {
                this.zab.remove(basePendingResult);
            }
        }
    }
}
