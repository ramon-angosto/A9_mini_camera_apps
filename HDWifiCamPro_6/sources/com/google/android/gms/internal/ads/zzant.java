package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzay;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Vector;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzant {
    static boolean zza = false;
    static final CountDownLatch zzb = new CountDownLatch(1);
    /* access modifiers changed from: private */
    public static MessageDigest zzc;
    private static final Object zzd = new Object();
    private static final Object zze = new Object();

    static String zza(zzana zzana, String str) throws GeneralSecurityException, UnsupportedEncodingException {
        byte[] bArr;
        byte[] zzax = zzana.zzax();
        if (((Boolean) zzay.zzc().zzb(zzbjc.zzcw)).booleanValue()) {
            Vector zzb2 = zzb(zzax, 255);
            if (zzb2 == null || zzb2.size() == 0) {
                bArr = zzg(zzf(4096).zzax(), str, true);
            } else {
                zzanm zza2 = zzann.zza();
                int size = zzb2.size();
                for (int i = 0; i < size; i++) {
                    zza2.zza(zzgpw.zzv(zzg((byte[]) zzb2.get(i), str, false)));
                }
                zza2.zzb(zzgpw.zzv(zze(zzax)));
                bArr = ((zzann) zza2.zzam()).zzax();
            }
        } else if (zzaqf.zza != null) {
            byte[] zza3 = zzaqf.zza.zza(zzax, str != null ? str.getBytes() : new byte[0]);
            zzanm zza4 = zzann.zza();
            zza4.zza(zzgpw.zzv(zza3));
            zza4.zzc(3);
            bArr = ((zzann) zza4.zzam()).zzax();
        } else {
            throw new GeneralSecurityException();
        }
        return zzanp.zza(bArr, true);
    }

    static Vector zzb(byte[] bArr, int i) {
        int length;
        if (bArr == null || (length = bArr.length) <= 0) {
            return null;
        }
        int i2 = (length + 254) / 255;
        Vector vector = new Vector();
        int i3 = 0;
        while (i3 < i2) {
            int i4 = i3 * 255;
            try {
                int length2 = bArr.length;
                if (length2 - i4 > 255) {
                    length2 = i4 + 255;
                }
                vector.add(Arrays.copyOfRange(bArr, i4, length2));
                i3++;
            } catch (IndexOutOfBoundsException unused) {
                return null;
            }
        }
        return vector;
    }

    static void zzd() {
        synchronized (zze) {
            if (!zza) {
                zza = true;
                new Thread(new zzans((zzanr) null)).start();
            }
        }
    }

    public static byte[] zze(byte[] bArr) throws NoSuchAlgorithmException {
        byte[] digest;
        synchronized (zzd) {
            zzd();
            MessageDigest messageDigest = null;
            try {
                if (zzb.await(2, TimeUnit.SECONDS)) {
                    MessageDigest messageDigest2 = zzc;
                    if (messageDigest2 != null) {
                        messageDigest = messageDigest2;
                    }
                }
            } catch (InterruptedException unused) {
            }
            if (messageDigest != null) {
                messageDigest.reset();
                messageDigest.update(bArr);
                digest = zzc.digest();
            } else {
                throw new NoSuchAlgorithmException("Cannot compute hash");
            }
        }
        return digest;
    }

    static zzana zzf(int i) {
        zzamk zza2 = zzana.zza();
        zza2.zzD(4096);
        return (zzana) zza2.zzam();
    }

    private static byte[] zzg(byte[] bArr, String str, boolean z) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        byte[] bArr2;
        int i = true != z ? 255 : 239;
        if (bArr.length > i) {
            bArr = zzf(4096).zzax();
        }
        int length = bArr.length;
        if (length < i) {
            byte[] bArr3 = new byte[(i - length)];
            new SecureRandom().nextBytes(bArr3);
            bArr2 = ByteBuffer.allocate(i + 1).put((byte) length).put(bArr).put(bArr3).array();
        } else {
            bArr2 = ByteBuffer.allocate(i + 1).put((byte) length).put(bArr).array();
        }
        if (z) {
            bArr2 = ByteBuffer.allocate(256).put(zze(bArr2)).put(bArr2).array();
        }
        byte[] bArr4 = new byte[256];
        zzanu[] zzanuArr = new zzaot().zzcG;
        int length2 = zzanuArr.length;
        for (int i2 = 0; i2 < 12; i2++) {
            zzanuArr[i2].zza(bArr2, bArr4);
        }
        if (str != null && str.length() > 0) {
            if (str.length() > 32) {
                str = str.substring(0, 32);
            }
            new zzgpd(str.getBytes("UTF-8")).zza(bArr4);
        }
        return bArr4;
    }
}
