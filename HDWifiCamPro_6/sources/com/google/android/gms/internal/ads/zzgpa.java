package com.google.android.gms.internal.ads;

import java.security.InvalidKeyException;
import java.util.Arrays;
import kotlin.UByte;
import kotlin.jvm.internal.ByteCompanionObject;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzgpa {
    public static byte[] zza(byte[] bArr, byte[] bArr2) throws InvalidKeyException {
        byte[] bArr3 = bArr;
        byte[] bArr4 = bArr2;
        if (bArr3.length == 32) {
            long[] jArr = new long[11];
            byte[] copyOf = Arrays.copyOf(bArr3, 32);
            copyOf[0] = (byte) (copyOf[0] & 248);
            byte b = copyOf[31] & ByteCompanionObject.MAX_VALUE;
            copyOf[31] = (byte) b;
            copyOf[31] = (byte) (b | 64);
            int i = zzgnx.zzb;
            if (bArr4.length == 32) {
                byte[] copyOf2 = Arrays.copyOf(bArr4, 32);
                copyOf2[31] = (byte) (copyOf2[31] & ByteCompanionObject.MAX_VALUE);
                int i2 = 0;
                while (i2 < 7) {
                    if (!zzgnv.zzb(zzgnx.zza[i2], copyOf2)) {
                        i2++;
                    } else {
                        throw new InvalidKeyException("Banned public key: ".concat(zzgoq.zza(zzgnx.zza[i2])));
                    }
                }
                long[] zzk = zzgop.zzk(copyOf2);
                long[] jArr2 = new long[19];
                long[] jArr3 = new long[19];
                jArr3[0] = 1;
                long[] jArr4 = new long[19];
                jArr4[0] = 1;
                long[] jArr5 = new long[19];
                long[] jArr6 = new long[19];
                long[] jArr7 = new long[19];
                jArr7[0] = 1;
                long[] jArr8 = new long[19];
                long[] jArr9 = new long[19];
                jArr9[0] = 1;
                int i3 = 10;
                System.arraycopy(zzk, 0, jArr2, 0, 10);
                long[] jArr10 = jArr2;
                long[] jArr11 = jArr9;
                long[] jArr12 = jArr7;
                int i4 = 0;
                int i5 = 32;
                while (i4 < i5) {
                    byte b2 = copyOf[(32 - i4) - 1] & UByte.MAX_VALUE;
                    long[] jArr13 = jArr10;
                    long[] jArr14 = jArr11;
                    long[] jArr15 = jArr8;
                    long[] jArr16 = jArr12;
                    int i6 = 0;
                    while (i6 < 8) {
                        int i7 = (b2 >> (7 - i6)) & 1;
                        zzgnx.zza(jArr4, jArr13, i7);
                        zzgnx.zza(jArr5, jArr3, i7);
                        byte[] bArr5 = copyOf;
                        long[] copyOf3 = Arrays.copyOf(jArr4, 10);
                        byte b3 = b2;
                        long[] jArr17 = jArr;
                        long[] jArr18 = new long[19];
                        int i8 = i4;
                        long[] jArr19 = new long[19];
                        int i9 = i6;
                        long[] jArr20 = new long[19];
                        int i10 = i7;
                        long[] jArr21 = new long[19];
                        long[] jArr22 = jArr14;
                        long[] jArr23 = new long[19];
                        long[] jArr24 = new long[19];
                        zzgop.zzi(jArr4, jArr4, jArr5);
                        zzgop.zzh(jArr5, copyOf3, jArr5);
                        long[] copyOf4 = Arrays.copyOf(jArr13, 10);
                        zzgop.zzi(jArr13, jArr13, jArr3);
                        zzgop.zzh(jArr3, copyOf4, jArr3);
                        zzgop.zzb(jArr20, jArr13, jArr5);
                        zzgop.zzb(jArr21, jArr4, jArr3);
                        zzgop.zze(jArr20);
                        zzgop.zzd(jArr20);
                        zzgop.zze(jArr21);
                        zzgop.zzd(jArr21);
                        long[] jArr25 = jArr13;
                        System.arraycopy(jArr20, 0, copyOf4, 0, 10);
                        zzgop.zzi(jArr20, jArr20, jArr21);
                        zzgop.zzh(jArr21, copyOf4, jArr21);
                        zzgop.zzg(jArr24, jArr20);
                        zzgop.zzg(jArr23, jArr21);
                        zzgop.zzb(jArr21, jArr23, zzk);
                        zzgop.zze(jArr21);
                        zzgop.zzd(jArr21);
                        System.arraycopy(jArr24, 0, jArr6, 0, 10);
                        System.arraycopy(jArr21, 0, jArr16, 0, 10);
                        zzgop.zzg(jArr18, jArr4);
                        zzgop.zzg(jArr19, jArr5);
                        zzgop.zzb(jArr15, jArr18, jArr19);
                        zzgop.zze(jArr15);
                        zzgop.zzd(jArr15);
                        zzgop.zzh(jArr19, jArr18, jArr19);
                        long[] jArr26 = new long[19];
                        Arrays.fill(jArr26, 10, 18, 0);
                        zzgop.zzf(jArr26, jArr19, 121665);
                        zzgop.zzd(jArr26);
                        zzgop.zzi(jArr26, jArr26, jArr18);
                        long[] jArr27 = jArr22;
                        zzgop.zzb(jArr27, jArr19, jArr26);
                        zzgop.zze(jArr27);
                        zzgop.zzd(jArr27);
                        int i11 = i10;
                        zzgnx.zza(jArr15, jArr6, i11);
                        zzgnx.zza(jArr27, jArr16, i11);
                        i6 = i9 + 1;
                        byte[] bArr6 = bArr2;
                        jArr14 = jArr5;
                        jArr13 = jArr6;
                        b2 = b3;
                        jArr = jArr17;
                        i4 = i8;
                        jArr6 = jArr25;
                        jArr5 = jArr27;
                        copyOf = bArr5;
                        long[] jArr28 = jArr3;
                        jArr3 = jArr16;
                        jArr16 = jArr28;
                        long[] jArr29 = jArr4;
                        jArr4 = jArr15;
                        jArr15 = jArr29;
                    }
                    byte[] bArr7 = copyOf;
                    long[] jArr30 = jArr;
                    long[] jArr31 = jArr14;
                    i4++;
                    byte[] bArr8 = bArr2;
                    jArr12 = jArr16;
                    jArr8 = jArr15;
                    jArr10 = jArr13;
                    i5 = 32;
                    i3 = 10;
                    jArr11 = jArr31;
                    copyOf = bArr7;
                }
                long[] jArr32 = jArr;
                int i12 = i3;
                long[] jArr33 = new long[i12];
                long[] jArr34 = new long[i12];
                long[] jArr35 = new long[i12];
                long[] jArr36 = new long[i12];
                long[] jArr37 = new long[i12];
                long[] jArr38 = new long[i12];
                long[] jArr39 = new long[i12];
                long[] jArr40 = new long[i12];
                long[] jArr41 = new long[i12];
                long[] jArr42 = new long[i12];
                long[] jArr43 = jArr10;
                long[] jArr44 = new long[i12];
                zzgop.zzg(jArr34, jArr5);
                zzgop.zzg(jArr44, jArr34);
                zzgop.zzg(jArr42, jArr44);
                zzgop.zza(jArr35, jArr42, jArr5);
                zzgop.zza(jArr36, jArr35, jArr34);
                zzgop.zzg(jArr42, jArr36);
                zzgop.zza(jArr37, jArr42, jArr35);
                zzgop.zzg(jArr42, jArr37);
                zzgop.zzg(jArr44, jArr42);
                zzgop.zzg(jArr42, jArr44);
                zzgop.zzg(jArr44, jArr42);
                zzgop.zzg(jArr42, jArr44);
                zzgop.zza(jArr38, jArr42, jArr37);
                zzgop.zzg(jArr42, jArr38);
                zzgop.zzg(jArr44, jArr42);
                for (int i13 = 2; i13 < 10; i13 += 2) {
                    zzgop.zzg(jArr42, jArr44);
                    zzgop.zzg(jArr44, jArr42);
                }
                zzgop.zza(jArr39, jArr44, jArr38);
                zzgop.zzg(jArr42, jArr39);
                zzgop.zzg(jArr44, jArr42);
                for (int i14 = 2; i14 < 20; i14 += 2) {
                    zzgop.zzg(jArr42, jArr44);
                    zzgop.zzg(jArr44, jArr42);
                }
                zzgop.zza(jArr42, jArr44, jArr39);
                zzgop.zzg(jArr44, jArr42);
                zzgop.zzg(jArr42, jArr44);
                for (int i15 = 2; i15 < 10; i15 += 2) {
                    zzgop.zzg(jArr44, jArr42);
                    zzgop.zzg(jArr42, jArr44);
                }
                zzgop.zza(jArr40, jArr42, jArr38);
                zzgop.zzg(jArr42, jArr40);
                zzgop.zzg(jArr44, jArr42);
                for (int i16 = 2; i16 < 50; i16 += 2) {
                    zzgop.zzg(jArr42, jArr44);
                    zzgop.zzg(jArr44, jArr42);
                }
                zzgop.zza(jArr41, jArr44, jArr40);
                zzgop.zzg(jArr44, jArr41);
                zzgop.zzg(jArr42, jArr44);
                for (int i17 = 2; i17 < 100; i17 += 2) {
                    zzgop.zzg(jArr44, jArr42);
                    zzgop.zzg(jArr42, jArr44);
                }
                zzgop.zza(jArr44, jArr42, jArr41);
                zzgop.zzg(jArr42, jArr44);
                zzgop.zzg(jArr44, jArr42);
                for (int i18 = 2; i18 < 50; i18 += 2) {
                    zzgop.zzg(jArr42, jArr44);
                    zzgop.zzg(jArr44, jArr42);
                }
                zzgop.zza(jArr42, jArr44, jArr40);
                zzgop.zzg(jArr44, jArr42);
                zzgop.zzg(jArr42, jArr44);
                zzgop.zzg(jArr44, jArr42);
                zzgop.zzg(jArr42, jArr44);
                zzgop.zzg(jArr44, jArr42);
                zzgop.zza(jArr33, jArr44, jArr36);
                long[] jArr45 = jArr32;
                zzgop.zza(jArr45, jArr4, jArr33);
                long[] jArr46 = new long[10];
                long[] jArr47 = new long[10];
                long[] jArr48 = new long[11];
                long[] jArr49 = new long[11];
                long[] jArr50 = new long[11];
                zzgop.zza(jArr46, zzk, jArr45);
                zzgop.zzi(jArr47, zzk, jArr45);
                long[] jArr51 = new long[10];
                jArr51[0] = 486662;
                zzgop.zzi(jArr49, jArr47, jArr51);
                zzgop.zza(jArr49, jArr49, jArr3);
                long[] jArr52 = jArr43;
                zzgop.zzi(jArr49, jArr49, jArr52);
                zzgop.zza(jArr49, jArr49, jArr46);
                zzgop.zza(jArr49, jArr49, jArr52);
                zzgop.zzf(jArr48, jArr49, 4);
                zzgop.zzd(jArr48);
                zzgop.zza(jArr49, jArr46, jArr3);
                zzgop.zzh(jArr49, jArr49, jArr3);
                zzgop.zza(jArr50, jArr47, jArr52);
                zzgop.zzi(jArr49, jArr49, jArr50);
                zzgop.zzg(jArr49, jArr49);
                if (zzgnv.zzb(zzgop.zzj(jArr48), zzgop.zzj(jArr49))) {
                    return zzgop.zzj(jArr45);
                }
                throw new IllegalStateException("Arithmetic error in curve multiplication with the public key: ".concat(zzgoq.zza(bArr2)));
            }
            throw new InvalidKeyException("Public key length is not 32-byte");
        }
        throw new InvalidKeyException("Private key must have 32 bytes.");
    }

    public static byte[] zzb() {
        byte[] zza = zzgox.zza(32);
        zza[0] = (byte) (zza[0] | 7);
        byte b = zza[31] & 63;
        zza[31] = (byte) b;
        zza[31] = (byte) (b | ByteCompanionObject.MIN_VALUE);
        return zza;
    }

    public static byte[] zzc(byte[] bArr) throws InvalidKeyException {
        if (bArr.length == 32) {
            byte[] bArr2 = new byte[32];
            bArr2[0] = 9;
            return zza(bArr, bArr2);
        }
        throw new InvalidKeyException("Private key must have 32 bytes.");
    }
}
