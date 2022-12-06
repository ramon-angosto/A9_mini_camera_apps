package com.google.android.gms.internal.ads;

import java.io.File;
import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzaov implements zzfos {
    final /* synthetic */ zzfms zza;

    zzaov(zzaox zzaox, zzfms zzfms) {
        this.zza = zzfms;
    }

    public final boolean zza(File file) {
        try {
            return this.zza.zza(file);
        } catch (GeneralSecurityException unused) {
            return false;
        }
    }
}
