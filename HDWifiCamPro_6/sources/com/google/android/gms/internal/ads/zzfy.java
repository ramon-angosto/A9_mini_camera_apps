package com.google.android.gms.internal.ads;

import android.net.Uri;
import java.io.IOException;
import java.util.Collections;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzfy implements zzex {
    private final zzex zza;
    private long zzb;
    private Uri zzc;
    private Map zzd;

    public final int zza(byte[] bArr, int i, int i2) throws IOException {
        int zza2 = this.zza.zza(bArr, i, i2);
        if (zza2 != -1) {
            this.zzb += (long) zza2;
        }
        return zza2;
    }

    public final long zzb(zzfc zzfc) throws IOException {
        this.zzc = zzfc.zza;
        this.zzd = Collections.emptyMap();
        long zzb2 = this.zza.zzb(zzfc);
        Uri zzc2 = zzc();
        if (zzc2 != null) {
            this.zzc = zzc2;
            this.zzd = zze();
            return zzb2;
        }
        throw null;
    }

    public final Uri zzc() {
        return this.zza.zzc();
    }

    public final void zzd() throws IOException {
        this.zza.zzd();
    }

    public final Map zze() {
        return this.zza.zze();
    }

    public final long zzg() {
        return this.zzb;
    }

    public final Uri zzh() {
        return this.zzc;
    }

    public final Map zzi() {
        return this.zzd;
    }

    public zzfy(zzex zzex) {
        if (zzex != null) {
            this.zza = zzex;
            this.zzc = Uri.EMPTY;
            this.zzd = Collections.emptyMap();
            return;
        }
        throw null;
    }

    public final void zzf(zzfz zzfz) {
        if (zzfz != null) {
            this.zza.zzf(zzfz);
            return;
        }
        throw null;
    }
}
