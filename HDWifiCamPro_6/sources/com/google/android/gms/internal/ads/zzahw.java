package com.google.android.gms.internal.ads;

import kotlin.UByte;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzahw extends zzyu {
    public zzahw(zzel zzel, long j, long j2) {
        super(new zzyp(), new zzahv(zzel, (zzahu) null), j, 0, j + 1, 0, j2, 188, 1000);
    }

    static /* bridge */ /* synthetic */ int zzh(byte[] bArr, int i) {
        return (bArr[i + 3] & UByte.MAX_VALUE) | ((bArr[i] & UByte.MAX_VALUE) << 24) | ((bArr[i + 1] & UByte.MAX_VALUE) << 16) | ((bArr[i + 2] & UByte.MAX_VALUE) << 8);
    }
}
