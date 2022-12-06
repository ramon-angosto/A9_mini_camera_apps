package com.huawei.secure.android.common.encrypt.hash;

import android.text.TextUtils;
import com.bumptech.glide.load.Key;
import com.huawei.secure.android.common.encrypt.utils.C0932b;
import com.huawei.secure.android.common.encrypt.utils.HexUtil;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public abstract class HMACSHA256 {
    private static final String TAG = HMACSHA256.class.getSimpleName();

    /* renamed from: i */
    private static final String f1075i = "";

    /* renamed from: s */
    private static final String f1076s = "HmacSHA256";

    /* renamed from: t */
    private static final int f1077t = 32;

    public static String hmacSHA256Encrypt(String str, String str2) {
        return (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) ? "" : hmacSHA256Encrypt(str, HexUtil.hexStr2ByteArray(str2));
    }

    public static String hmacSHA256Encrypt(String str, byte[] bArr) {
        if (!TextUtils.isEmpty(str) && bArr != null) {
            if (bArr.length < 32) {
                C0932b.m1497f(TAG, "hmac key length is not right");
                return "";
            }
            try {
                SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, f1076s);
                Mac instance = Mac.getInstance(secretKeySpec.getAlgorithm());
                instance.init(secretKeySpec);
                return HexUtil.byteArray2HexStr(instance.doFinal(str.getBytes(Key.STRING_CHARSET_NAME)));
            } catch (UnsupportedEncodingException | InvalidKeyException | NoSuchAlgorithmException e) {
                String str2 = TAG;
                C0932b.m1497f(str2, "hmacsha256 encrypt exception" + e.getMessage());
            }
        }
        return "";
    }
}
