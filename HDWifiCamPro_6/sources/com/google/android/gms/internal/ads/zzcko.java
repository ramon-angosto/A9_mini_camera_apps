package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzcko extends zzalm {
    static final zzcko zzb = new zzcko();

    zzcko() {
    }

    public final zzalq zza(String str, byte[] bArr, String str2) {
        if ("moov".equals(str)) {
            return new zzals();
        }
        if ("mvhd".equals(str)) {
            return new zzalt();
        }
        return new zzalu(str);
    }
}
