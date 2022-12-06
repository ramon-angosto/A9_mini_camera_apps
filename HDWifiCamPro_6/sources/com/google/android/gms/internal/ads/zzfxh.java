package com.google.android.gms.internal.ads;

import java.util.AbstractSet;
import java.util.Collection;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
abstract class zzfxh extends AbstractSet {
    zzfxh() {
    }

    public boolean removeAll(Collection collection) {
        return zzfxi.zzd(this, collection);
    }

    public boolean retainAll(Collection collection) {
        if (collection != null) {
            return super.retainAll(collection);
        }
        throw null;
    }
}
