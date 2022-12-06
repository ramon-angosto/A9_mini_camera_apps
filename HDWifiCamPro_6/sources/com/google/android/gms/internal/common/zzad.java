package com.google.android.gms.internal.common;

import java.util.Iterator;

/* compiled from: com.google.android.gms:play-services-basement@@18.0.0 */
public final class zzad<E> extends zzaa<E> {
    public zzad() {
        super(4);
    }

    public final zzad<E> zzb(E e) {
        super.zza(e);
        return this;
    }

    public final zzad<E> zzc(Iterator<? extends E> it) {
        while (it.hasNext()) {
            super.zza(it.next());
        }
        return this;
    }

    zzad(int i) {
        super(4);
    }
}
