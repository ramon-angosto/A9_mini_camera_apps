package com.huawei.hms.hatool;

import android.util.Pair;
import com.bumptech.glide.load.Key;
import com.huawei.secure.android.common.encrypt.aes.AesCbc;
import com.huawei.secure.android.common.encrypt.utils.HexUtil;
import java.nio.charset.Charset;

/* renamed from: com.huawei.hms.hatool.d */
public class C0784d {

    /* renamed from: a */
    public static final Charset f610a = Charset.forName(Key.STRING_CHARSET_NAME);

    /* renamed from: a */
    public static Pair<byte[], String> m773a(String str) {
        if (str == null || str.length() < 32) {
            return new Pair<>(new byte[0], str);
        }
        String substring = str.substring(0, 32);
        return new Pair<>(HexUtil.hexStr2ByteArray(substring), str.substring(32));
    }

    /* renamed from: a */
    public static String m774a(String str, String str2) {
        Pair<byte[], String> a = m773a(str);
        return new String(AesCbc.decrypt(HexUtil.hexStr2ByteArray((String) a.second), HexUtil.hexStr2ByteArray(str2), (byte[]) a.first), f610a);
    }

    /* renamed from: b */
    public static String m775b(String str, String str2) {
        return HexUtil.byteArray2HexStr(AesCbc.encrypt(str.getBytes(f610a), HexUtil.hexStr2ByteArray(str2)));
    }
}
