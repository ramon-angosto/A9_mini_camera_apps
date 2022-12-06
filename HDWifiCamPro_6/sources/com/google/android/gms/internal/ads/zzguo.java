package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public enum zzguo {
    DOUBLE(zzgup.DOUBLE, 1),
    FLOAT(zzgup.FLOAT, 5),
    INT64(zzgup.LONG, 0),
    UINT64(zzgup.LONG, 0),
    INT32(zzgup.INT, 0),
    FIXED64(zzgup.LONG, 1),
    FIXED32(zzgup.INT, 5),
    BOOL(zzgup.BOOLEAN, 0),
    STRING(zzgup.STRING, 2),
    GROUP(zzgup.MESSAGE, 3),
    MESSAGE(zzgup.MESSAGE, 2),
    BYTES(zzgup.BYTE_STRING, 2),
    UINT32(zzgup.INT, 0),
    ENUM(zzgup.ENUM, 0),
    SFIXED32(zzgup.INT, 5),
    SFIXED64(zzgup.LONG, 1),
    SINT32(zzgup.INT, 0),
    SINT64(zzgup.LONG, 0);
    
    private final zzgup zzt;

    private zzguo(zzgup zzgup, int i) {
        this.zzt = zzgup;
    }

    public final zzgup zza() {
        return this.zzt;
    }
}
