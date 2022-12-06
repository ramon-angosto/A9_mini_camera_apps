package com.mbridge.msdk.foundation.tools;

import android.text.TextUtils;
import android.util.Base64;
import java.security.MessageDigest;
import java.security.Provider;
import java.security.Security;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* compiled from: AESCBCUtil */
public final class a {
    private static byte[] a = new byte[32];
    private static byte[] b = new byte[16];

    static {
        if (!TextUtils.isEmpty("ebmclXzZOhtU2sRlZxGL8A")) {
            try {
                byte[] digest = MessageDigest.getInstance("sha-384").digest("ebmclXzZOhtU2sRlZxGL8A".getBytes());
                System.arraycopy(digest, 0, a, 0, 32);
                System.arraycopy(digest, 32, b, 0, 16);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static String a(String str) {
        return a(str, a, b);
    }

    private static String a(String str, byte[] bArr, byte[] bArr2) {
        try {
            IvParameterSpec ivParameterSpec = new IvParameterSpec(bArr2);
            SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
            Security.addProvider(new C0064a());
            Cipher instance = Cipher.getInstance("AES/CBC/PKCS7PADDING");
            instance.init(1, secretKeySpec, ivParameterSpec);
            return new String(Base64.encode(instance.doFinal(str.getBytes()), 0));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: com.mbridge.msdk.foundation.tools.a$a  reason: collision with other inner class name */
    /* compiled from: AESCBCUtil */
    public static class C0064a extends Provider {
        public C0064a() {
            super("Crypto", 1.0d, "HARMONY (SHA1 digest; SecureRandom; SHA1withDSA signature)");
            put("SecureRandom.SHA1PRNG", "org.apache.harmony.security.provider.crypto.SHA1PRNG_SecureRandomImpl");
            put("SecureRandom.SHA1PRNG ImplementedIn", "Software");
        }
    }
}
