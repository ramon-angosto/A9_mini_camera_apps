package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzgpe;
import com.google.android.gms.internal.ads.zzgpf;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public abstract class zzgpe<MessageType extends zzgpf<MessageType, BuilderType>, BuilderType extends zzgpe<MessageType, BuilderType>> implements zzgsn {
    /* renamed from: zzag */
    public abstract zzgpe clone();

    /* access modifiers changed from: protected */
    public abstract zzgpe zzah(zzgpf zzgpf);

    public final /* bridge */ /* synthetic */ zzgsn zzai(zzgso zzgso) {
        if (zzbh().getClass().isInstance(zzgso)) {
            return zzah((zzgpf) zzgso);
        }
        throw new IllegalArgumentException("mergeFrom(MessageLite) can only merge messages of the same type.");
    }
}
