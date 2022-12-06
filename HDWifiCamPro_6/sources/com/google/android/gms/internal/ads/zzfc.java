package com.google.android.gms.internal.ads;

import android.net.Uri;
import androidx.browser.trusted.sharing.ShareTarget;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzfc {
    public final Uri zza;
    public final int zzb;
    public final byte[] zzc;
    public final Map zzd;
    @Deprecated
    public final long zze;
    public final long zzf;
    public final long zzg;
    public final String zzh;
    public final int zzi;

    static {
        zzbh.zzb("media3.datasource");
    }

    private zzfc(Uri uri, long j, int i, byte[] bArr, Map map, long j2, long j3, String str, int i2, Object obj) {
        long j4 = j2;
        long j5 = j + j4;
        boolean z = false;
        zzdd.zzd(j5 >= 0);
        zzdd.zzd(j4 >= 0);
        long j6 = -1;
        if (j3 > 0) {
            j6 = j3;
        } else if (j3 != -1) {
            j6 = j3;
            zzdd.zzd(z);
            this.zza = uri;
            this.zzb = 1;
            this.zzc = null;
            this.zzd = Collections.unmodifiableMap(new HashMap(map));
            this.zzf = j4;
            this.zze = j5;
            this.zzg = j6;
            this.zzh = null;
            this.zzi = i2;
        }
        z = true;
        zzdd.zzd(z);
        this.zza = uri;
        this.zzb = 1;
        this.zzc = null;
        this.zzd = Collections.unmodifiableMap(new HashMap(map));
        this.zzf = j4;
        this.zze = j5;
        this.zzg = j6;
        this.zzh = null;
        this.zzi = i2;
    }

    /* synthetic */ zzfc(Uri uri, long j, int i, byte[] bArr, Map map, long j2, long j3, String str, int i2, Object obj, zzfb zzfb) {
        this(uri, 0, 1, (byte[]) null, map, j2, -1, (String) null, i2, (Object) null);
    }

    public static String zza(int i) {
        return ShareTarget.METHOD_GET;
    }

    public final String toString() {
        String valueOf = String.valueOf(this.zza);
        long j = this.zzf;
        long j2 = this.zzg;
        int i = this.zzi;
        return "DataSpec[" + zza(1) + " " + valueOf + ", " + j + ", " + j2 + ", null, " + i + "]";
    }

    public final boolean zzb(int i) {
        return (this.zzi & i) == i;
    }

    @Deprecated
    public zzfc(Uri uri, byte[] bArr, long j, long j2, long j3, String str, int i) {
        this(uri, j - j2, 1, (byte[]) null, Collections.emptyMap(), j2, j3, (String) null, i, (Object) null);
    }
}
