package com.google.android.gms.common;

import java.lang.ref.WeakReference;

/* compiled from: com.google.android.gms:play-services-basement@@18.0.0 */
abstract class zzk extends zzi {
    private static final WeakReference<byte[]> zza = new WeakReference<>((Object) null);
    private WeakReference<byte[]> zzb = zza;

    zzk(byte[] bArr) {
        super(bArr);
    }

    /* access modifiers changed from: protected */
    public abstract byte[] zzb();

    /* access modifiers changed from: package-private */
    public final byte[] zzf() {
        byte[] bArr;
        synchronized (this) {
            bArr = (byte[]) this.zzb.get();
            if (bArr == null) {
                bArr = zzb();
                this.zzb = new WeakReference<>(bArr);
            }
        }
        return bArr;
    }
}
