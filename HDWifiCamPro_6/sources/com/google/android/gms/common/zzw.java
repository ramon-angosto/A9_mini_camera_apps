package com.google.android.gms.common;

import android.util.Log;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-basement@@18.0.0 */
class zzw {
    private static final zzw zzd = new zzw(true, (String) null, (Throwable) null);
    final boolean zza;
    @Nullable
    final String zzb;
    @Nullable
    final Throwable zzc;

    zzw(boolean z, @Nullable String str, @Nullable Throwable th) {
        this.zza = z;
        this.zzb = str;
        this.zzc = th;
    }

    static zzw zzb() {
        return zzd;
    }

    static zzw zzc(String str) {
        return new zzw(false, str, (Throwable) null);
    }

    static zzw zzd(String str, Throwable th) {
        return new zzw(false, str, th);
    }

    /* access modifiers changed from: package-private */
    @Nullable
    public String zza() {
        return this.zzb;
    }

    /* access modifiers changed from: package-private */
    public final void zze() {
        if (!this.zza && Log.isLoggable("GoogleCertificatesRslt", 3)) {
            if (this.zzc != null) {
                Log.d("GoogleCertificatesRslt", zza(), this.zzc);
            } else {
                Log.d("GoogleCertificatesRslt", zza());
            }
        }
    }
}
