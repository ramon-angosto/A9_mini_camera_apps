package sg.bigo.ads.common.utils;

import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import sg.bigo.ads.common.k.a;

public final class m {
    private static final byte[] a = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    private static final byte[] b = {1, 2, 3, 4, 5, 6, 7, 8, 9, 16, 17, 18, 19, 20, 21, 22};

    public static String a(String str, String str2) {
        try {
            return o.a(a(str.getBytes("UTF-8"), o.e(str2)));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static byte[] a(byte[] bArr) {
        return a(bArr, b);
    }

    private static byte[] a(byte[] bArr, byte[] bArr2) {
        if (bArr == null || bArr2 == null) {
            return null;
        }
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr2, "AES");
        IvParameterSpec ivParameterSpec = new IvParameterSpec(a);
        try {
            Cipher instance = Cipher.getInstance("AES/CBC/PKCS5Padding");
            instance.init(1, secretKeySpec, ivParameterSpec);
            return instance.doFinal(bArr);
        } catch (NoSuchAlgorithmException unused) {
            a.a(0, "SDKCipher", "sdk cipher.encrypt failed, no such algorithm");
            return bArr;
        } catch (InvalidAlgorithmParameterException | InvalidKeyException | BadPaddingException | IllegalBlockSizeException | NoSuchPaddingException unused2) {
            a.a(0, "SDKCipher", "sdk cipher.encrypt failed");
            return null;
        }
    }

    public static String b(String str, String str2) {
        try {
            return new String(b(o.e(str), o.e(str2)), "UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
            a.a(0, "SDKCipher", "Failed to decrypt data: ".concat(String.valueOf(str)));
            return null;
        }
    }

    public static byte[] b(byte[] bArr) {
        return b(bArr, b);
    }

    private static byte[] b(byte[] bArr, byte[] bArr2) {
        StringBuilder sb;
        if (bArr == null || bArr2 == null) {
            return null;
        }
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr2, "AES");
        IvParameterSpec ivParameterSpec = new IvParameterSpec(a);
        try {
            Cipher instance = Cipher.getInstance("AES/CBC/PKCS5Padding");
            instance.init(2, secretKeySpec, ivParameterSpec);
            return instance.doFinal(bArr);
        } catch (NoSuchAlgorithmException unused) {
            a.a(0, "SDKCipher", "sdk cipher.decrypt new key failed, input len:" + bArr.length + ",input data:" + Arrays.toString(bArr));
            return bArr;
        } catch (InvalidKeyException unused2) {
            sb = new StringBuilder("sdk cipher.decrypt new key failed,input len:");
            sb.append(bArr.length);
            sb.append(",input data:");
            sb.append(Arrays.toString(bArr));
            a.a(0, "SDKCipher", sb.toString());
            return null;
        } catch (InvalidAlgorithmParameterException unused3) {
            sb = new StringBuilder("sdk cipher.decrypt new key failed,input len:");
            sb.append(bArr.length);
            sb.append(",input data:");
            sb.append(Arrays.toString(bArr));
            a.a(0, "SDKCipher", sb.toString());
            return null;
        } catch (NoSuchPaddingException unused4) {
            sb = new StringBuilder("sdk cipher.decrypt new key failed,input len:");
            sb.append(bArr.length);
            sb.append(",input data:");
            sb.append(Arrays.toString(bArr));
            a.a(0, "SDKCipher", sb.toString());
            return null;
        } catch (IllegalBlockSizeException unused5) {
            sb = new StringBuilder("sdk cipher.decrypt new key failed,input len:");
            sb.append(bArr.length);
            sb.append(",input data:");
            sb.append(Arrays.toString(bArr));
            a.a(0, "SDKCipher", sb.toString());
            return null;
        } catch (BadPaddingException unused6) {
            sb = new StringBuilder("sdk cipher.decrypt new key failed,input len:");
            sb.append(bArr.length);
            sb.append(",input data:");
            sb.append(Arrays.toString(bArr));
            a.a(0, "SDKCipher", sb.toString());
            return null;
        }
    }
}
