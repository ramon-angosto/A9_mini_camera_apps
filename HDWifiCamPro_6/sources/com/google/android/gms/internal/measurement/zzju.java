package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-base@@20.1.2 */
public enum zzju {
    DOUBLE(0, 1, zzkn.DOUBLE),
    FLOAT(1, 1, zzkn.FLOAT),
    INT64(2, 1, zzkn.LONG),
    UINT64(3, 1, zzkn.LONG),
    INT32(4, 1, zzkn.INT),
    FIXED64(5, 1, zzkn.LONG),
    FIXED32(6, 1, zzkn.INT),
    BOOL(7, 1, zzkn.BOOLEAN),
    STRING(8, 1, zzkn.STRING),
    MESSAGE(9, 1, zzkn.MESSAGE),
    BYTES(10, 1, zzkn.BYTE_STRING),
    UINT32(11, 1, zzkn.INT),
    ENUM(12, 1, zzkn.ENUM),
    SFIXED32(13, 1, zzkn.INT),
    SFIXED64(14, 1, zzkn.LONG),
    SINT32(15, 1, zzkn.INT),
    SINT64(16, 1, zzkn.LONG),
    GROUP(17, 1, zzkn.MESSAGE),
    DOUBLE_LIST(18, 2, zzkn.DOUBLE),
    FLOAT_LIST(19, 2, zzkn.FLOAT),
    INT64_LIST(20, 2, zzkn.LONG),
    UINT64_LIST(21, 2, zzkn.LONG),
    INT32_LIST(22, 2, zzkn.INT),
    FIXED64_LIST(23, 2, zzkn.LONG),
    FIXED32_LIST(24, 2, zzkn.INT),
    BOOL_LIST(25, 2, zzkn.BOOLEAN),
    STRING_LIST(26, 2, zzkn.STRING),
    MESSAGE_LIST(27, 2, zzkn.MESSAGE),
    BYTES_LIST(28, 2, zzkn.BYTE_STRING),
    UINT32_LIST(29, 2, zzkn.INT),
    ENUM_LIST(30, 2, zzkn.ENUM),
    SFIXED32_LIST(31, 2, zzkn.INT),
    SFIXED64_LIST(32, 2, zzkn.LONG),
    SINT32_LIST(33, 2, zzkn.INT),
    SINT64_LIST(34, 2, zzkn.LONG),
    DOUBLE_LIST_PACKED(35, 3, zzkn.DOUBLE),
    FLOAT_LIST_PACKED(36, 3, zzkn.FLOAT),
    INT64_LIST_PACKED(37, 3, zzkn.LONG),
    UINT64_LIST_PACKED(38, 3, zzkn.LONG),
    INT32_LIST_PACKED(39, 3, zzkn.INT),
    FIXED64_LIST_PACKED(40, 3, zzkn.LONG),
    FIXED32_LIST_PACKED(41, 3, zzkn.INT),
    BOOL_LIST_PACKED(42, 3, zzkn.BOOLEAN),
    UINT32_LIST_PACKED(43, 3, zzkn.INT),
    ENUM_LIST_PACKED(44, 3, zzkn.ENUM),
    SFIXED32_LIST_PACKED(45, 3, zzkn.INT),
    SFIXED64_LIST_PACKED(46, 3, zzkn.LONG),
    SINT32_LIST_PACKED(47, 3, zzkn.INT),
    SINT64_LIST_PACKED(48, 3, zzkn.LONG),
    GROUP_LIST(49, 2, zzkn.MESSAGE),
    MAP(50, 4, zzkn.VOID);
    
    private static final zzju[] zzZ = null;
    private final zzkn zzab;
    private final int zzac;
    private final Class zzad;

    static {
        int i;
        zzZ = new zzju[r1];
        for (zzju zzju : values()) {
            zzZ[zzju.zzac] = zzju;
        }
    }

    private zzju(int i, int i2, zzkn zzkn) {
        this.zzac = i;
        this.zzab = zzkn;
        zzkn zzkn2 = zzkn.VOID;
        int i3 = i2 - 1;
        if (i3 == 1) {
            this.zzad = zzkn.zza();
        } else if (i3 != 3) {
            this.zzad = null;
        } else {
            this.zzad = zzkn.zza();
        }
        if (i2 == 1) {
            zzkn.ordinal();
        }
    }

    public final int zza() {
        return this.zzac;
    }
}
