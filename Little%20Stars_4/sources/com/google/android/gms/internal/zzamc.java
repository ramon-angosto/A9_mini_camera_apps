package com.google.android.gms.internal;

import android.support.v4.media.TransportMediator;
import java.io.IOException;
import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ReadOnlyBufferException;

public final class zzamc {
    private final ByteBuffer zzbZZ;

    public static class zza extends IOException {
        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        zza(int r3, int r4) {
            /*
                r2 = this;
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r1 = 108(0x6c, float:1.51E-43)
                r0.<init>(r1)
                java.lang.String r1 = "CodedOutputStream was writing to a flat byte array and ran out of space (pos "
                r0.append(r1)
                r0.append(r3)
                java.lang.String r3 = " limit "
                r0.append(r3)
                r0.append(r4)
                java.lang.String r3 = ")."
                r0.append(r3)
                java.lang.String r3 = r0.toString()
                r2.<init>(r3)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzamc.zza.<init>(int, int):void");
        }
    }

    private zzamc(ByteBuffer byteBuffer) {
        this.zzbZZ = byteBuffer;
        this.zzbZZ.order(ByteOrder.LITTLE_ENDIAN);
    }

    private zzamc(byte[] bArr, int i, int i2) {
        this(ByteBuffer.wrap(bArr, i, i2));
    }

    public static int zzG(int i, int i2) {
        return zzof(i) + zzoc(i2);
    }

    public static int zzH(int i, int i2) {
        return zzof(i) + zzod(i2);
    }

    public static zzamc zzO(byte[] bArr) {
        return zzb(bArr, 0, bArr.length);
    }

    public static int zzQ(byte[] bArr) {
        return zzoh(bArr.length) + bArr.length;
    }

    private static int zza(CharSequence charSequence, int i) {
        int length = charSequence.length();
        int i2 = 0;
        while (i < length) {
            char charAt = charSequence.charAt(i);
            if (charAt < 2048) {
                i2 += (127 - charAt) >>> 31;
            } else {
                i2 += 2;
                if (55296 <= charAt && charAt <= 57343) {
                    if (Character.codePointAt(charSequence, i) >= 65536) {
                        i++;
                    } else {
                        StringBuilder sb = new StringBuilder(39);
                        sb.append("Unpaired surrogate at index ");
                        sb.append(i);
                        throw new IllegalArgumentException(sb.toString());
                    }
                }
            }
            i++;
        }
        return i2;
    }

    private static int zza(CharSequence charSequence, byte[] bArr, int i, int i2) {
        int i3;
        int i4;
        char charAt;
        int length = charSequence.length();
        int i5 = i2 + i;
        int i6 = 0;
        while (i6 < length && (i4 = i6 + i) < i5 && (charAt = charSequence.charAt(i6)) < 128) {
            bArr[i4] = (byte) charAt;
            i6++;
        }
        if (i6 == length) {
            return i + length;
        }
        int i7 = i + i6;
        while (i6 < length) {
            char charAt2 = charSequence.charAt(i6);
            if (charAt2 < 128 && i7 < i5) {
                i3 = i7 + 1;
                bArr[i7] = (byte) charAt2;
            } else if (charAt2 < 2048 && i7 <= i5 - 2) {
                int i8 = i7 + 1;
                bArr[i7] = (byte) ((charAt2 >>> 6) | 960);
                i7 = i8 + 1;
                bArr[i8] = (byte) ((charAt2 & '?') | 128);
                i6++;
            } else if ((charAt2 < 55296 || 57343 < charAt2) && i7 <= i5 - 3) {
                int i9 = i7 + 1;
                bArr[i7] = (byte) ((charAt2 >>> 12) | 480);
                int i10 = i9 + 1;
                bArr[i9] = (byte) (((charAt2 >>> 6) & 63) | 128);
                i3 = i10 + 1;
                bArr[i10] = (byte) ((charAt2 & '?') | 128);
            } else if (i7 <= i5 - 4) {
                int i11 = i6 + 1;
                if (i11 != charSequence.length()) {
                    char charAt3 = charSequence.charAt(i11);
                    if (Character.isSurrogatePair(charAt2, charAt3)) {
                        int codePoint = Character.toCodePoint(charAt2, charAt3);
                        int i12 = i7 + 1;
                        bArr[i7] = (byte) ((codePoint >>> 18) | 240);
                        int i13 = i12 + 1;
                        bArr[i12] = (byte) (((codePoint >>> 12) & 63) | 128);
                        int i14 = i13 + 1;
                        bArr[i13] = (byte) (((codePoint >>> 6) & 63) | 128);
                        i7 = i14 + 1;
                        bArr[i14] = (byte) ((codePoint & 63) | 128);
                        i6 = i11;
                        i6++;
                    } else {
                        i6 = i11;
                    }
                }
                StringBuilder sb = new StringBuilder(39);
                sb.append("Unpaired surrogate at index ");
                sb.append(i6 - 1);
                throw new IllegalArgumentException(sb.toString());
            } else {
                StringBuilder sb2 = new StringBuilder(37);
                sb2.append("Failed writing ");
                sb2.append(charAt2);
                sb2.append(" at index ");
                sb2.append(i7);
                throw new ArrayIndexOutOfBoundsException(sb2.toString());
            }
            i7 = i3;
            i6++;
        }
        return i7;
    }

    private static void zza(CharSequence charSequence, ByteBuffer byteBuffer) {
        if (byteBuffer.isReadOnly()) {
            throw new ReadOnlyBufferException();
        } else if (byteBuffer.hasArray()) {
            try {
                byteBuffer.position(zza(charSequence, byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), byteBuffer.remaining()) - byteBuffer.arrayOffset());
            } catch (ArrayIndexOutOfBoundsException e) {
                BufferOverflowException bufferOverflowException = new BufferOverflowException();
                bufferOverflowException.initCause(e);
                throw bufferOverflowException;
            }
        } else {
            zzb(charSequence, byteBuffer);
        }
    }

    public static int zzaT(long j) {
        return zzaY(j);
    }

    public static int zzaU(long j) {
        return zzaY(j);
    }

    public static int zzaV(long j) {
        return 8;
    }

    public static int zzaW(long j) {
        return zzaY(zzba(j));
    }

    public static int zzaY(long j) {
        if ((-128 & j) == 0) {
            return 1;
        }
        if ((-16384 & j) == 0) {
            return 2;
        }
        if ((-2097152 & j) == 0) {
            return 3;
        }
        if ((-268435456 & j) == 0) {
            return 4;
        }
        if ((-34359738368L & j) == 0) {
            return 5;
        }
        if ((-4398046511104L & j) == 0) {
            return 6;
        }
        if ((-562949953421312L & j) == 0) {
            return 7;
        }
        if ((-72057594037927936L & j) == 0) {
            return 8;
        }
        return (j & Long.MIN_VALUE) == 0 ? 9 : 10;
    }

    public static int zzb(int i, double d) {
        return zzof(i) + zzq(d);
    }

    public static int zzb(int i, zzamj zzamj) {
        return (zzof(i) * 2) + zzd(zzamj);
    }

    public static int zzb(int i, byte[] bArr) {
        return zzof(i) + zzQ(bArr);
    }

    public static zzamc zzb(byte[] bArr, int i, int i2) {
        return new zzamc(bArr, i, i2);
    }

    private static void zzb(CharSequence charSequence, ByteBuffer byteBuffer) {
        int i;
        int length = charSequence.length();
        int i2 = 0;
        while (i2 < length) {
            char charAt = charSequence.charAt(i2);
            if (charAt >= 128) {
                if (charAt < 2048) {
                    i = (charAt >>> 6) | 960;
                } else if (charAt < 55296 || 57343 < charAt) {
                    byteBuffer.put((byte) ((charAt >>> 12) | 480));
                    i = ((charAt >>> 6) & 63) | 128;
                } else {
                    int i3 = i2 + 1;
                    if (i3 != charSequence.length()) {
                        char charAt2 = charSequence.charAt(i3);
                        if (Character.isSurrogatePair(charAt, charAt2)) {
                            int codePoint = Character.toCodePoint(charAt, charAt2);
                            byteBuffer.put((byte) ((codePoint >>> 18) | 240));
                            byteBuffer.put((byte) (((codePoint >>> 12) & 63) | 128));
                            byteBuffer.put((byte) (((codePoint >>> 6) & 63) | 128));
                            byteBuffer.put((byte) ((codePoint & 63) | 128));
                            i2 = i3;
                            i2++;
                        } else {
                            i2 = i3;
                        }
                    }
                    StringBuilder sb = new StringBuilder(39);
                    sb.append("Unpaired surrogate at index ");
                    sb.append(i2 - 1);
                    throw new IllegalArgumentException(sb.toString());
                }
                byteBuffer.put((byte) i);
                charAt = (charAt & '?') | 128;
            }
            byteBuffer.put((byte) charAt);
            i2++;
        }
    }

    public static long zzba(long j) {
        return (j >> 63) ^ (j << 1);
    }

    public static int zzbd(boolean z) {
        return 1;
    }

    public static int zzc(int i, float f) {
        return zzof(i) + zzj(f);
    }

    public static int zzc(int i, zzamj zzamj) {
        return zzof(i) + zze(zzamj);
    }

    public static int zzd(zzamj zzamj) {
        return zzamj.getSerializedSize();
    }

    private static int zzd(CharSequence charSequence) {
        int length = charSequence.length();
        int i = 0;
        while (i < length && charSequence.charAt(i) < 128) {
            i++;
        }
        int i2 = length;
        while (true) {
            if (i < length) {
                char charAt = charSequence.charAt(i);
                if (charAt >= 2048) {
                    i2 += zza(charSequence, i);
                    break;
                }
                i2 += (127 - charAt) >>> 31;
                i++;
            } else {
                break;
            }
        }
        if (i2 >= length) {
            return i2;
        }
        StringBuilder sb = new StringBuilder(54);
        sb.append("UTF-8 length does not fit in int: ");
        sb.append(((long) i2) + 4294967296L);
        throw new IllegalArgumentException(sb.toString());
    }

    public static int zze(int i, long j) {
        return zzof(i) + zzaU(j);
    }

    public static int zze(zzamj zzamj) {
        int serializedSize = zzamj.getSerializedSize();
        return zzoh(serializedSize) + serializedSize;
    }

    public static int zzf(int i, long j) {
        return zzof(i) + zzaV(j);
    }

    public static int zzg(int i, long j) {
        return zzof(i) + zzaW(j);
    }

    public static int zziZ(String str) {
        int zzd = zzd((CharSequence) str);
        return zzoh(zzd) + zzd;
    }

    public static int zzj(float f) {
        return 4;
    }

    public static int zzk(int i, boolean z) {
        return zzof(i) + zzbd(z);
    }

    public static int zzoc(int i) {
        if (i >= 0) {
            return zzoh(i);
        }
        return 10;
    }

    public static int zzod(int i) {
        return zzoh(zzoj(i));
    }

    public static int zzof(int i) {
        return zzoh(zzamm.zzJ(i, 0));
    }

    public static int zzoh(int i) {
        if ((i & -128) == 0) {
            return 1;
        }
        if ((i & -16384) == 0) {
            return 2;
        }
        if ((-2097152 & i) == 0) {
            return 3;
        }
        return (i & -268435456) == 0 ? 4 : 5;
    }

    public static int zzoj(int i) {
        return (i >> 31) ^ (i << 1);
    }

    public static int zzq(double d) {
        return 8;
    }

    public static int zzr(int i, String str) {
        return zzof(i) + zziZ(str);
    }

    public void zzE(int i, int i2) throws IOException {
        zzI(i, 0);
        zzoa(i2);
    }

    public void zzF(int i, int i2) throws IOException {
        zzI(i, 0);
        zzob(i2);
    }

    public void zzI(int i, int i2) throws IOException {
        zzog(zzamm.zzJ(i, i2));
    }

    public void zzP(byte[] bArr) throws IOException {
        zzog(bArr.length);
        zzR(bArr);
    }

    public void zzR(byte[] bArr) throws IOException {
        zzc(bArr, 0, bArr.length);
    }

    public int zzWT() {
        return this.zzbZZ.remaining();
    }

    public void zzWU() {
        if (zzWT() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    public void zza(int i, double d) throws IOException {
        zzI(i, 1);
        zzp(d);
    }

    public void zza(int i, long j) throws IOException {
        zzI(i, 0);
        zzaP(j);
    }

    public void zza(int i, zzamj zzamj) throws IOException {
        zzI(i, 2);
        zzc(zzamj);
    }

    public void zza(int i, byte[] bArr) throws IOException {
        zzI(i, 2);
        zzP(bArr);
    }

    public void zzaP(long j) throws IOException {
        zzaX(j);
    }

    public void zzaQ(long j) throws IOException {
        zzaX(j);
    }

    public void zzaR(long j) throws IOException {
        zzaZ(j);
    }

    public void zzaS(long j) throws IOException {
        zzaX(zzba(j));
    }

    public void zzaX(long j) throws IOException {
        while ((-128 & j) != 0) {
            zzoe((((int) j) & TransportMediator.KEYCODE_MEDIA_PAUSE) | 128);
            j >>>= 7;
        }
        zzoe((int) j);
    }

    public void zzaZ(long j) throws IOException {
        if (this.zzbZZ.remaining() >= 8) {
            this.zzbZZ.putLong(j);
            return;
        }
        throw new zza(this.zzbZZ.position(), this.zzbZZ.limit());
    }

    public void zzb(int i, float f) throws IOException {
        zzI(i, 5);
        zzi(f);
    }

    public void zzb(int i, long j) throws IOException {
        zzI(i, 0);
        zzaQ(j);
    }

    public void zzb(zzamj zzamj) throws IOException {
        zzamj.writeTo(this);
    }

    public void zzbc(boolean z) throws IOException {
        zzoe(z ? 1 : 0);
    }

    public void zzc(byte b) throws IOException {
        if (this.zzbZZ.hasRemaining()) {
            this.zzbZZ.put(b);
            return;
        }
        throw new zza(this.zzbZZ.position(), this.zzbZZ.limit());
    }

    public void zzc(int i, long j) throws IOException {
        zzI(i, 1);
        zzaR(j);
    }

    public void zzc(zzamj zzamj) throws IOException {
        zzog(zzamj.getCachedSize());
        zzamj.writeTo(this);
    }

    public void zzc(byte[] bArr, int i, int i2) throws IOException {
        if (this.zzbZZ.remaining() >= i2) {
            this.zzbZZ.put(bArr, i, i2);
            return;
        }
        throw new zza(this.zzbZZ.position(), this.zzbZZ.limit());
    }

    public void zzd(int i, long j) throws IOException {
        zzI(i, 0);
        zzaS(j);
    }

    public void zzi(float f) throws IOException {
        zzoi(Float.floatToIntBits(f));
    }

    public void zziY(String str) throws IOException {
        try {
            int zzoh = zzoh(str.length());
            if (zzoh == zzoh(str.length() * 3)) {
                int position = this.zzbZZ.position();
                if (this.zzbZZ.remaining() >= zzoh) {
                    this.zzbZZ.position(position + zzoh);
                    zza((CharSequence) str, this.zzbZZ);
                    int position2 = this.zzbZZ.position();
                    this.zzbZZ.position(position);
                    zzog((position2 - position) - zzoh);
                    this.zzbZZ.position(position2);
                    return;
                }
                throw new zza(position + zzoh, this.zzbZZ.limit());
            }
            zzog(zzd((CharSequence) str));
            zza((CharSequence) str, this.zzbZZ);
        } catch (BufferOverflowException e) {
            zza zza2 = new zza(this.zzbZZ.position(), this.zzbZZ.limit());
            zza2.initCause(e);
            throw zza2;
        }
    }

    public void zzj(int i, boolean z) throws IOException {
        zzI(i, 0);
        zzbc(z);
    }

    public void zzoa(int i) throws IOException {
        if (i >= 0) {
            zzog(i);
        } else {
            zzaX((long) i);
        }
    }

    public void zzob(int i) throws IOException {
        zzog(zzoj(i));
    }

    public void zzoe(int i) throws IOException {
        zzc((byte) i);
    }

    public void zzog(int i) throws IOException {
        while ((i & -128) != 0) {
            zzoe((i & TransportMediator.KEYCODE_MEDIA_PAUSE) | 128);
            i >>>= 7;
        }
        zzoe(i);
    }

    public void zzoi(int i) throws IOException {
        if (this.zzbZZ.remaining() >= 4) {
            this.zzbZZ.putInt(i);
            return;
        }
        throw new zza(this.zzbZZ.position(), this.zzbZZ.limit());
    }

    public void zzp(double d) throws IOException {
        zzaZ(Double.doubleToLongBits(d));
    }

    public void zzq(int i, String str) throws IOException {
        zzI(i, 2);
        zziY(str);
    }
}
