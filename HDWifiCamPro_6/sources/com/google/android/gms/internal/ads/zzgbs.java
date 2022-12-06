package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzgbs extends zzgbl {
    private final String zza;
    private final int zzb;

    /* synthetic */ zzgbs(String str, int i, zzgbr zzgbr) {
        this.zza = str;
        this.zzb = i;
    }

    public final String toString() {
        Object[] objArr = new Object[2];
        objArr[0] = this.zza;
        int i = this.zzb - 2;
        objArr[1] = i != 1 ? i != 2 ? i != 3 ? i != 4 ? "UNKNOWN" : "CRUNCHY" : "RAW" : "LEGACY" : "TINK";
        return String.format("(typeUrl=%s, outputPrefixType=%s)", objArr);
    }
}
