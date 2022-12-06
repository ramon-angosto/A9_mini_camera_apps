package com.huawei.agconnect.config.p006a;

import android.content.Context;
import android.util.Log;
import com.bumptech.glide.load.Key;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;

/* renamed from: com.huawei.agconnect.config.a.i */
class C0549i extends C0548h {

    /* renamed from: c */
    private final Map<String, String> f110c = new HashMap();

    /* renamed from: d */
    private final Object f111d = new Object();

    /* renamed from: e */
    private SecretKey f112e;

    /* renamed from: f */
    private boolean f113f = true;

    C0549i(Context context, String str) {
        super(context, str);
        try {
            String b = m66b("/AD91D45E3E72DB6989DDCB13287E75061FABCB933D886E6C6ABEF0939B577138");
            String b2 = m66b("/B314B3BF013DF5AC4134E880AF3D2B7C9FFBE8F0305EAC1C898145E2BCF1F21C");
            String b3 = m66b("/C767BD8FDF53E53D059BE95B09E2A71056F5F180AECC62836B287ACA5793421B");
            String b4 = m66b("/DCB3E6D4C2CF80F30D89CDBC412C964DA8381BB84668769391FBCC3E329AD0FD");
            if (b == null || b2 == null || b3 == null || b4 == null) {
                this.f113f = false;
            } else {
                this.f112e = C0547g.m59a(C0545e.m56a(b), C0545e.m56a(b2), C0545e.m56a(b3), C0545e.m56a(b4));
            }
        } catch (NoSuchAlgorithmException | InvalidKeySpecException unused) {
            Log.e("SecurityResourcesReader", "Exception when reading the 'K&I' for 'Config'.");
            this.f112e = null;
        }
    }

    /* renamed from: a */
    private static byte[] m65a(SecretKey secretKey, byte[] bArr) throws GeneralSecurityException {
        if (secretKey == null || bArr == null) {
            throw new NullPointerException("key or cipherText must not be null.");
        }
        byte[] copyOfRange = Arrays.copyOfRange(bArr, 1, 17);
        Cipher instance = Cipher.getInstance("AES/CBC/PKCS5Padding");
        instance.init(2, secretKey, new IvParameterSpec(copyOfRange));
        return instance.doFinal(bArr, copyOfRange.length + 1, (bArr.length - copyOfRange.length) - 1);
    }

    /* renamed from: b */
    private String m66b(String str) {
        return super.getString(str, (String) null);
    }

    public String getString(String str, String str2) {
        if (!this.f113f) {
            String b = m66b(str);
            return b != null ? b : str2;
        } else if (this.f112e == null) {
            Log.e("SecurityResourcesReader", "KEY is null return def directly");
            return str2;
        } else {
            synchronized (this.f111d) {
                String str3 = this.f110c.get(str);
                if (str3 != null) {
                    return str3;
                }
                String b2 = m66b(str);
                if (b2 == null) {
                    return str2;
                }
                try {
                    String str4 = new String(m65a(this.f112e, C0545e.m56a(b2)), Key.STRING_CHARSET_NAME);
                    this.f110c.put(str, str4);
                    return str4;
                } catch (UnsupportedEncodingException | GeneralSecurityException unused) {
                    Log.e("SecurityResourcesReader", "Exception when reading the 'V' for 'Config'.");
                    return str2;
                }
            }
        }
    }
}
