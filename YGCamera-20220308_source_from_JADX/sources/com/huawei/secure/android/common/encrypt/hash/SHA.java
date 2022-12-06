package com.huawei.secure.android.common.encrypt.hash;

import android.text.TextUtils;
import com.bumptech.glide.load.Key;
import com.huawei.secure.android.common.encrypt.utils.C0932b;
import com.huawei.secure.android.common.encrypt.utils.HexUtil;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public final class SHA {

    /* renamed from: B */
    private static final String f1086B = "SHA-256";
    private static final String TAG = SHA.class.getSimpleName();

    /* renamed from: i */
    private static final String f1087i = "";

    /* renamed from: r */
    private static final String[] f1088r = {f1086B, "SHA-384", "SHA-512"};

    private SHA() {
    }

    public static String sha256Encrypt(String str) {
        return shaEncrypt(str, f1086B);
    }

    public static String shaEncrypt(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            C0932b.m1497f(TAG, "content or algorithm is null.");
            return "";
        } else if (!m1455d(str2)) {
            C0932b.m1497f(TAG, "algorithm is not safe or legal");
            return "";
        } else {
            try {
                MessageDigest instance = MessageDigest.getInstance(str2);
                instance.update(str.getBytes(Key.STRING_CHARSET_NAME));
                return HexUtil.byteArray2HexStr(instance.digest());
            } catch (UnsupportedEncodingException unused) {
                C0932b.m1497f(TAG, "Error in generate SHA UnsupportedEncodingException");
                return "";
            } catch (NoSuchAlgorithmException unused2) {
                C0932b.m1497f(TAG, "Error in generate SHA NoSuchAlgorithmException");
                return "";
            }
        }
    }

    public static boolean validateSHA256(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return false;
        }
        return str2.equals(sha256Encrypt(str));
    }

    public static boolean validateSHA(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
            return false;
        }
        return str2.equals(shaEncrypt(str, str3));
    }

    /* renamed from: d */
    private static boolean m1455d(String str) {
        for (String equals : f1088r) {
            if (equals.equals(str)) {
                return true;
            }
        }
        return false;
    }
}
