package com.google.android.gms.internal.common;

/* compiled from: com.google.android.gms:play-services-basement@@18.0.0 */
final class zzae<E> extends zzz<E> {
    private final zzag<E> zza;

    zzae(zzag<E> zzag, int i) {
        super(zzag.size(), i);
        this.zza = zzag;
    }

    /* access modifiers changed from: protected */
    public final E zza(int i) {
        return this.zza.get(i);
    }
}
