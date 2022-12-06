package com.google.android.gms.internal.ads;

import android.net.Uri;
import java.io.EOFException;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzaxw {
    private final zzauz[] zza;
    private final zzava zzb;
    private zzauz zzc;

    public zzaxw(zzauz[] zzauzArr, zzava zzava) {
        this.zza = zzauzArr;
        this.zzb = zzava;
    }

    public final void zza() {
        if (this.zzc != null) {
            this.zzc = null;
        }
    }

    public final zzauz zzb(zzauy zzauy, Uri uri) throws IOException, InterruptedException {
        zzauz zzauz = this.zzc;
        if (zzauz != null) {
            return zzauz;
        }
        zzauz[] zzauzArr = this.zza;
        int length = zzauzArr.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                break;
            }
            zzauz zzauz2 = zzauzArr[i];
            try {
                if (zzauz2.zzg(zzauy)) {
                    this.zzc = zzauz2;
                    zzauy.zze();
                    break;
                }
                zzauy.zze();
                i++;
            } catch (EOFException unused) {
            } catch (Throwable th) {
                zzauy.zze();
                throw th;
            }
        }
        zzauz zzauz3 = this.zzc;
        if (zzauz3 != null) {
            zzauz3.zzd(this.zzb);
            return this.zzc;
        }
        String zzk = zzbar.zzk(this.zza);
        throw new zzayu("None of the available extractors (" + zzk + ") could read the stream.", uri);
    }
}
