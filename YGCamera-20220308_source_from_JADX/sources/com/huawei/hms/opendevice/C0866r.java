package com.huawei.hms.opendevice;

import android.text.TextUtils;
import com.bumptech.glide.load.Key;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.HEX;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* renamed from: com.huawei.hms.opendevice.r */
/* compiled from: SHACoder */
public final class C0866r {
    /* renamed from: a */
    public static String m1184a(String str, String str2) {
        try {
            byte[] bytes = str.getBytes(Key.STRING_CHARSET_NAME);
            if (TextUtils.isEmpty(str2)) {
                str2 = "SHA-256";
            }
            MessageDigest instance = MessageDigest.getInstance(str2);
            instance.update(bytes);
            return HEX.encodeHexString(instance.digest(), false);
        } catch (NoSuchAlgorithmException unused) {
            HMSLog.m1377e("SHACoder", "encrypt failed .");
            return null;
        } catch (UnsupportedEncodingException unused2) {
            HMSLog.m1377e("SHACoder", "trans failed .");
            return null;
        }
    }
}
