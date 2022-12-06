package com.huawei.hms.hatool;

import com.bumptech.glide.load.Key;
import com.huawei.secure.android.common.encrypt.utils.HexUtil;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

/* renamed from: com.huawei.hms.hatool.e */
public class C0787e {
    /* renamed from: a */
    public static String m788a(String str, String str2) {
        try {
            return m789a(str, str2.getBytes(Key.STRING_CHARSET_NAME));
        } catch (UnsupportedEncodingException unused) {
            C0841y.m1087c("hmsSdk", "Unsupported encoding exception,utf-8");
            return "";
        }
    }

    /* renamed from: a */
    public static String m789a(String str, byte[] bArr) {
        String str2;
        if (bArr == null || bArr.length == 0) {
            C0841y.m1092f("hmsSdk", "encrypt: content is empty or null");
            return "";
        }
        try {
            return HexUtil.byteArray2HexStr(m791a(bArr, m790a(HexUtil.hexStr2ByteArray(str))));
        } catch (NoSuchAlgorithmException unused) {
            str2 = "encrypt(): getInstance - No such algorithm,transformation";
            C0841y.m1092f("hmsSdk", str2);
            return "";
        } catch (InvalidKeySpecException unused2) {
            str2 = "encrypt(): Invalid key specification";
            C0841y.m1092f("hmsSdk", str2);
            return "";
        }
    }

    /* renamed from: a */
    public static PublicKey m790a(byte[] bArr) {
        return KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(bArr));
    }

    /* renamed from: a */
    public static byte[] m791a(byte[] bArr, PublicKey publicKey) {
        String str;
        if (publicKey != null) {
            try {
                Cipher instance = Cipher.getInstance("RSA/ECB/OAEPWITHSHA-1ANDMGF1PADDING");
                instance.init(1, publicKey);
                return instance.doFinal(bArr);
            } catch (UnsupportedEncodingException unused) {
                str = "rsaEncrypt(): getBytes - Unsupported coding format!";
                C0841y.m1092f("hmsSdk", str);
                return new byte[0];
            } catch (NoSuchAlgorithmException unused2) {
                str = "rsaEncrypt(): getInstance - No such algorithm,transformation";
                C0841y.m1092f("hmsSdk", str);
                return new byte[0];
            } catch (InvalidKeyException unused3) {
                str = "rsaEncrypt(): init - Invalid key!";
                C0841y.m1092f("hmsSdk", str);
                return new byte[0];
            } catch (NoSuchPaddingException unused4) {
                str = "rsaEncrypt():  No such filling parameters ";
                C0841y.m1092f("hmsSdk", str);
                return new byte[0];
            } catch (BadPaddingException unused5) {
                str = "rsaEncrypt():False filling parameters!";
                C0841y.m1092f("hmsSdk", str);
                return new byte[0];
            } catch (IllegalBlockSizeException unused6) {
                str = "rsaEncrypt(): doFinal - The provided block is not filled with";
                C0841y.m1092f("hmsSdk", str);
                return new byte[0];
            }
        } else {
            throw new UnsupportedEncodingException("The loaded public key is null");
        }
    }
}
