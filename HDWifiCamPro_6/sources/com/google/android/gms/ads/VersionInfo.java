package com.google.android.gms.ads;

import java.util.Locale;

/* compiled from: com.google.android.gms:play-services-ads-lite@@21.3.0 */
public class VersionInfo {
    protected int zza;
    protected int zzb;
    protected int zzc;

    public VersionInfo(int i, int i2, int i3) {
        this.zza = i;
        this.zzb = i2;
        this.zzc = i3;
    }

    public int getMajorVersion() {
        return this.zza;
    }

    public int getMicroVersion() {
        return this.zzc;
    }

    public int getMinorVersion() {
        return this.zzb;
    }

    public String toString() {
        return String.format(Locale.US, "%d.%d.%d", new Object[]{Integer.valueOf(this.zza), Integer.valueOf(this.zzb), Integer.valueOf(this.zzc)});
    }
}
