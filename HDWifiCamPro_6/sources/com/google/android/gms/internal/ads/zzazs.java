package com.google.android.gms.internal.ads;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public class zzazs extends IOException {
    public final zzazo zza;

    public zzazs(IOException iOException, zzazo zzazo, int i) {
        super(iOException);
        this.zza = zzazo;
    }

    public zzazs(String str, zzazo zzazo, int i) {
        super(str);
        this.zza = zzazo;
    }

    public zzazs(String str, IOException iOException, zzazo zzazo, int i) {
        super(str, iOException);
        this.zza = zzazo;
    }
}
