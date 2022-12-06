package com.google.android.gms.internal.ads;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public class zzey extends IOException {
    public final int zza;

    public zzey(int i) {
        this.zza = i;
    }

    public zzey(String str, int i) {
        super(str);
        this.zza = i;
    }

    public zzey(String str, Throwable th, int i) {
        super(str, th);
        this.zza = i;
    }

    public zzey(Throwable th, int i) {
        super(th);
        this.zza = i;
    }
}
