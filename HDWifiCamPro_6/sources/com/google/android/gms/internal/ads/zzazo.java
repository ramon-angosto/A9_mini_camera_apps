package com.google.android.gms.internal.ads;

import android.net.Uri;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzazo {
    public final Uri zza;
    public final long zzb;
    public final long zzc;
    public final long zzd;

    public zzazo(Uri uri, byte[] bArr, long j, long j2, long j3, String str, int i) {
        boolean z = true;
        zzbac.zzc(j >= 0);
        zzbac.zzc(j2 >= 0);
        if (j3 <= 0) {
            if (j3 == -1) {
                j3 = -1;
            } else {
                z = false;
            }
        }
        zzbac.zzc(z);
        this.zza = uri;
        this.zzb = j;
        this.zzc = j2;
        this.zzd = j3;
    }

    public final String toString() {
        String valueOf = String.valueOf(this.zza);
        String arrays = Arrays.toString((byte[]) null);
        long j = this.zzb;
        long j2 = this.zzc;
        long j3 = this.zzd;
        return "DataSpec[" + valueOf + ", " + arrays + ", " + j + ", " + j2 + ", " + j3 + ", null, 0]";
    }
}
