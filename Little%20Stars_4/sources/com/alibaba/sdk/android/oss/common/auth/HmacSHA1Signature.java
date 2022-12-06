package com.alibaba.sdk.android.oss.common.auth;

import com.alibaba.sdk.android.oss.common.utils.BinaryUtil;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public class HmacSHA1Signature {
    private static final String ALGORITHM = "HmacSHA1";
    private static final String DEFAULT_ENCODING = "UTF-8";
    private static final Object LOCK = new Object();
    private static final String VERSION = "1";
    private static Mac macInstance;

    public String getAlgorithm() {
        return ALGORITHM;
    }

    public String getVersion() {
        return VERSION;
    }

    public String computeSignature(String str, String str2) {
        try {
            return BinaryUtil.toBase64String(sign(str.getBytes(DEFAULT_ENCODING), str2.getBytes(DEFAULT_ENCODING)));
        } catch (UnsupportedEncodingException unused) {
            throw new RuntimeException("Unsupported algorithm: UTF-8");
        }
    }

    private byte[] sign(byte[] bArr, byte[] bArr2) {
        Mac mac;
        try {
            if (macInstance == null) {
                synchronized (LOCK) {
                    if (macInstance == null) {
                        macInstance = Mac.getInstance(ALGORITHM);
                    }
                }
            }
            try {
                mac = (Mac) macInstance.clone();
            } catch (CloneNotSupportedException unused) {
                mac = Mac.getInstance(ALGORITHM);
            }
            mac.init(new SecretKeySpec(bArr, ALGORITHM));
            return mac.doFinal(bArr2);
        } catch (NoSuchAlgorithmException unused2) {
            throw new RuntimeException("Unsupported algorithm: HmacSHA1");
        } catch (InvalidKeyException unused3) {
            throw new RuntimeException();
        }
    }
}
