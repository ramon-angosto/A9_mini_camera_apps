package com.ironsource.mediationsdk.utils;

import android.text.TextUtils;
import android.util.Base64;
import com.ironsource.environment.a;
import com.ironsource.mediationsdk.logger.IronLog;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class IronSourceAES {
    private static SecretKeySpec a(String str) {
        int i = 32;
        byte[] bArr = new byte[32];
        Arrays.fill(bArr, (byte) 0);
        byte[] bytes = str.getBytes("UTF-8");
        if (bytes.length < 32) {
            i = bytes.length;
        }
        System.arraycopy(bytes, 0, bArr, 0, i);
        return new SecretKeySpec(bArr, "AES");
    }

    public static synchronized String compressAndEncrypt(String str) {
        String compressAndEncrypt;
        synchronized (IronSourceAES.class) {
            compressAndEncrypt = compressAndEncrypt(g.a().b(), str);
        }
        return compressAndEncrypt;
    }

    public static synchronized String compressAndEncrypt(String str, String str2) {
        synchronized (IronSourceAES.class) {
            if (TextUtils.isEmpty(str2)) {
                return "";
            }
            try {
                byte[] b = a.AnonymousClass1.b(str2);
                if (b != null) {
                    String encodeFromBytes = encodeFromBytes(str, b);
                    return encodeFromBytes;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return "";
        }
    }

    public static synchronized String decode(String str, String str2) {
        synchronized (IronSourceAES.class) {
            byte[] decodeToBytes = decodeToBytes(str, str2);
            if (decodeToBytes == null) {
                return "";
            }
            String str3 = new String(decodeToBytes);
            return str3;
        }
    }

    public static synchronized byte[] decodeToBytes(String str, String str2) {
        synchronized (IronSourceAES.class) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            if (TextUtils.isEmpty(str2)) {
                return null;
            }
            try {
                SecretKeySpec a = a(str);
                byte[] bArr = new byte[16];
                Arrays.fill(bArr, (byte) 0);
                IvParameterSpec ivParameterSpec = new IvParameterSpec(bArr);
                byte[] decode = Base64.decode(str2, 0);
                Cipher instance = Cipher.getInstance("AES/CBC/PKCS7Padding");
                instance.init(2, a, ivParameterSpec);
                byte[] doFinal = instance.doFinal(decode);
                return doFinal;
            } catch (Exception e) {
                IronLog ironLog = IronLog.INTERNAL;
                ironLog.error("exception on decryption error: " + e.getMessage());
                e.printStackTrace();
                return null;
            }
        }
    }

    public static synchronized String decryptAndDecompress(String str) {
        String decryptAndDecompress;
        synchronized (IronSourceAES.class) {
            decryptAndDecompress = decryptAndDecompress(g.a().b(), str);
        }
        return decryptAndDecompress;
    }

    public static synchronized String decryptAndDecompress(String str, String str2) {
        synchronized (IronSourceAES.class) {
            if (TextUtils.isEmpty(str2)) {
                return "";
            }
            try {
                byte[] decodeToBytes = decodeToBytes(str, str2);
                if (decodeToBytes != null) {
                    String a = a.AnonymousClass1.a(decodeToBytes);
                    return a;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return "";
        }
    }

    public static synchronized String encode(String str, String str2) {
        synchronized (IronSourceAES.class) {
            if (TextUtils.isEmpty(str)) {
                return "";
            }
            if (TextUtils.isEmpty(str2)) {
                return "";
            }
            try {
                String encodeFromBytes = encodeFromBytes(str, str2.getBytes("UTF8"));
                return encodeFromBytes;
            } catch (Exception e) {
                e.printStackTrace();
                return "";
            }
        }
    }

    public static synchronized String encodeFromBytes(String str, byte[] bArr) {
        synchronized (IronSourceAES.class) {
            if (TextUtils.isEmpty(str)) {
                return "";
            }
            if (bArr == null) {
                return "";
            }
            try {
                SecretKeySpec a = a(str);
                byte[] bArr2 = new byte[16];
                Arrays.fill(bArr2, (byte) 0);
                IvParameterSpec ivParameterSpec = new IvParameterSpec(bArr2);
                Cipher instance = Cipher.getInstance("AES/CBC/PKCS7Padding");
                instance.init(1, a, ivParameterSpec);
                String replaceAll = Base64.encodeToString(instance.doFinal(bArr), 0).replaceAll(System.getProperty("line.separator"), "");
                return replaceAll;
            } catch (Exception e) {
                e.printStackTrace();
                return "";
            }
        }
    }

    public static synchronized String encrypt(String str) {
        String encode;
        synchronized (IronSourceAES.class) {
            encode = encode(g.a().b(), str);
        }
        return encode;
    }
}
