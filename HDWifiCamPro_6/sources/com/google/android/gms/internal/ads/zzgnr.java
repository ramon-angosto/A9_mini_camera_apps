package com.google.android.gms.internal.ads;

import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.TsExtractor;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import javax.crypto.AEADBadTagException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import kotlin.UByte;
import kotlin.jvm.internal.ByteCompanionObject;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzgnr implements zzgak {
    private static final ThreadLocal zza = new zzgnp();
    private static final ThreadLocal zzb = new zzgnq();
    private final byte[] zzc;
    private final byte[] zzd;
    private final SecretKeySpec zze;
    private final int zzf;

    public zzgnr(byte[] bArr, int i) throws GeneralSecurityException {
        if (!zzgds.zza(1)) {
            throw new GeneralSecurityException("Can not use AES-EAX in FIPS-mode.");
        } else if (i == 12 || i == 16) {
            this.zzf = i;
            zzgoz.zza(bArr.length);
            this.zze = new SecretKeySpec(bArr, "AES");
            Cipher cipher = (Cipher) zza.get();
            cipher.init(1, this.zze);
            this.zzc = zzc(cipher.doFinal(new byte[16]));
            this.zzd = zzc(this.zzc);
        } else {
            throw new IllegalArgumentException("IV size should be either 12 or 16 bytes");
        }
    }

    private static byte[] zzc(byte[] bArr) {
        byte[] bArr2 = new byte[16];
        int i = 0;
        while (i < 15) {
            byte b = bArr[i];
            int i2 = i + 1;
            bArr2[i] = (byte) (((b + b) ^ ((bArr[i2] & UByte.MAX_VALUE) >>> 7)) & 255);
            i = i2;
        }
        byte b2 = bArr[15];
        bArr2[15] = (byte) (((bArr[0] >> 7) & TsExtractor.TS_STREAM_TYPE_E_AC3) ^ (b2 + b2));
        return bArr2;
    }

    private final byte[] zzd(Cipher cipher, int i, byte[] bArr, int i2, int i3) throws IllegalBlockSizeException, BadPaddingException {
        byte[] bArr2;
        int length;
        byte[] bArr3 = new byte[16];
        bArr3[15] = (byte) i;
        if (i3 == 0) {
            return cipher.doFinal(zze(bArr3, this.zzc));
        }
        byte[] doFinal = cipher.doFinal(bArr3);
        int i4 = 0;
        byte[] bArr4 = doFinal;
        int i5 = 0;
        while (i3 - i5 > 16) {
            for (int i6 = 0; i6 < 16; i6++) {
                bArr4[i6] = (byte) (bArr4[i6] ^ bArr[(i2 + i5) + i6]);
            }
            bArr4 = cipher.doFinal(bArr4);
            i5 += 16;
        }
        byte[] copyOfRange = Arrays.copyOfRange(bArr, i5 + i2, i2 + i3);
        if (copyOfRange.length == 16) {
            bArr2 = zze(copyOfRange, this.zzc);
        } else {
            byte[] copyOf = Arrays.copyOf(this.zzd, 16);
            while (true) {
                length = copyOfRange.length;
                if (i4 >= length) {
                    break;
                }
                copyOf[i4] = (byte) (copyOf[i4] ^ copyOfRange[i4]);
                i4++;
            }
            copyOf[length] = (byte) (copyOf[length] ^ ByteCompanionObject.MIN_VALUE);
            bArr2 = copyOf;
        }
        return cipher.doFinal(zze(bArr4, bArr2));
    }

    private static byte[] zze(byte[] bArr, byte[] bArr2) {
        int length = bArr.length;
        byte[] bArr3 = new byte[length];
        for (int i = 0; i < length; i++) {
            bArr3[i] = (byte) (bArr[i] ^ bArr2[i]);
        }
        return bArr3;
    }

    public final byte[] zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        int length = bArr.length;
        int i = (length - this.zzf) - 16;
        if (i >= 0) {
            Cipher cipher = (Cipher) zza.get();
            cipher.init(1, this.zze);
            byte[] zzd2 = zzd(cipher, 0, bArr, 0, this.zzf);
            if (bArr2 == null) {
                bArr2 = new byte[0];
            }
            byte[] bArr3 = bArr2;
            byte[] zzd3 = zzd(cipher, 1, bArr3, 0, bArr3.length);
            byte[] zzd4 = zzd(cipher, 2, bArr, this.zzf, i);
            int i2 = length - 16;
            byte b = 0;
            for (int i3 = 0; i3 < 16; i3++) {
                b = (byte) (b | (((bArr[i2 + i3] ^ zzd3[i3]) ^ zzd2[i3]) ^ zzd4[i3]));
            }
            if (b == 0) {
                Cipher cipher2 = (Cipher) zzb.get();
                cipher2.init(1, this.zze, new IvParameterSpec(zzd2));
                return cipher2.doFinal(bArr, this.zzf, i);
            }
            throw new AEADBadTagException("tag mismatch");
        }
        throw new GeneralSecurityException("ciphertext too short");
    }

    public final byte[] zzb(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        int length = bArr.length;
        int i = this.zzf;
        if (length <= (Integer.MAX_VALUE - i) - 16) {
            byte[] bArr3 = new byte[(i + length + 16)];
            byte[] zza2 = zzgox.zza(i);
            System.arraycopy(zza2, 0, bArr3, 0, this.zzf);
            Cipher cipher = (Cipher) zza.get();
            cipher.init(1, this.zze);
            Cipher cipher2 = cipher;
            byte[] zzd2 = zzd(cipher2, 0, zza2, 0, zza2.length);
            byte[] zzd3 = zzd(cipher2, 1, bArr2, 0, 0);
            Cipher cipher3 = (Cipher) zzb.get();
            cipher3.init(1, this.zze, new IvParameterSpec(zzd2));
            cipher3.doFinal(bArr, 0, length, bArr3, this.zzf);
            byte[] zzd4 = zzd(cipher, 2, bArr3, this.zzf, length);
            int i2 = length + this.zzf;
            for (int i3 = 0; i3 < 16; i3++) {
                bArr3[i2 + i3] = (byte) ((zzd3[i3] ^ zzd2[i3]) ^ zzd4[i3]);
            }
            return bArr3;
        }
        throw new GeneralSecurityException("plaintext too long");
    }
}
