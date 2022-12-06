package com.google.android.gms.common;

import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-basement@@18.0.0 */
final class zzv extends zzw {
    private final Callable<String> zzd;

    /* synthetic */ zzv(Callable callable, zzu zzu) {
        super(false, (String) null, (Throwable) null);
        this.zzd = callable;
    }

    /* access modifiers changed from: package-private */
    public final String zza() {
        try {
            return this.zzd.call();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
