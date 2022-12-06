package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public enum zzgqw {
    DOUBLE(0, 1, zzgrs.DOUBLE),
    FLOAT(1, 1, zzgrs.FLOAT),
    INT64(2, 1, zzgrs.LONG),
    UINT64(3, 1, zzgrs.LONG),
    INT32(4, 1, zzgrs.INT),
    FIXED64(5, 1, zzgrs.LONG),
    FIXED32(6, 1, zzgrs.INT),
    BOOL(7, 1, zzgrs.BOOLEAN),
    STRING(8, 1, zzgrs.STRING),
    MESSAGE(9, 1, zzgrs.MESSAGE),
    BYTES(10, 1, zzgrs.BYTE_STRING),
    UINT32(11, 1, zzgrs.INT),
    ENUM(12, 1, zzgrs.ENUM),
    SFIXED32(13, 1, zzgrs.INT),
    SFIXED64(14, 1, zzgrs.LONG),
    SINT32(15, 1, zzgrs.INT),
    SINT64(16, 1, zzgrs.LONG),
    GROUP(17, 1, zzgrs.MESSAGE),
    DOUBLE_LIST(18, 2, zzgrs.DOUBLE),
    FLOAT_LIST(19, 2, zzgrs.FLOAT),
    INT64_LIST(20, 2, zzgrs.LONG),
    UINT64_LIST(21, 2, zzgrs.LONG),
    INT32_LIST(22, 2, zzgrs.INT),
    FIXED64_LIST(23, 2, zzgrs.LONG),
    FIXED32_LIST(24, 2, zzgrs.INT),
    BOOL_LIST(25, 2, zzgrs.BOOLEAN),
    STRING_LIST(26, 2, zzgrs.STRING),
    MESSAGE_LIST(27, 2, zzgrs.MESSAGE),
    BYTES_LIST(28, 2, zzgrs.BYTE_STRING),
    UINT32_LIST(29, 2, zzgrs.INT),
    ENUM_LIST(30, 2, zzgrs.ENUM),
    SFIXED32_LIST(31, 2, zzgrs.INT),
    SFIXED64_LIST(32, 2, zzgrs.LONG),
    SINT32_LIST(33, 2, zzgrs.INT),
    SINT64_LIST(34, 2, zzgrs.LONG),
    DOUBLE_LIST_PACKED(35, 3, zzgrs.DOUBLE),
    FLOAT_LIST_PACKED(36, 3, zzgrs.FLOAT),
    INT64_LIST_PACKED(37, 3, zzgrs.LONG),
    UINT64_LIST_PACKED(38, 3, zzgrs.LONG),
    INT32_LIST_PACKED(39, 3, zzgrs.INT),
    FIXED64_LIST_PACKED(40, 3, zzgrs.LONG),
    FIXED32_LIST_PACKED(41, 3, zzgrs.INT),
    BOOL_LIST_PACKED(42, 3, zzgrs.BOOLEAN),
    UINT32_LIST_PACKED(43, 3, zzgrs.INT),
    ENUM_LIST_PACKED(44, 3, zzgrs.ENUM),
    SFIXED32_LIST_PACKED(45, 3, zzgrs.INT),
    SFIXED64_LIST_PACKED(46, 3, zzgrs.LONG),
    SINT32_LIST_PACKED(47, 3, zzgrs.INT),
    SINT64_LIST_PACKED(48, 3, zzgrs.LONG),
    GROUP_LIST(49, 2, zzgrs.MESSAGE),
    MAP(50, 4, zzgrs.VOID);
    
    private static final zzgqw[] zzZ = null;
    private final zzgrs zzab;
    private final int zzac;
    private final Class zzad;

    static {
        int i;
        zzZ = new zzgqw[r1];
        for (zzgqw zzgqw : values()) {
            zzZ[zzgqw.zzac] = zzgqw;
        }
    }

    private zzgqw(int i, int i2, zzgrs zzgrs) {
        this.zzac = i;
        this.zzab = zzgrs;
        zzgrs zzgrs2 = zzgrs.VOID;
        int i3 = i2 - 1;
        if (i3 == 1) {
            this.zzad = zzgrs.zza();
        } else if (i3 != 3) {
            this.zzad = null;
        } else {
            this.zzad = zzgrs.zza();
        }
        if (i2 == 1) {
            zzgrs.ordinal();
        }
    }

    public final int zza() {
        return this.zzac;
    }
}
