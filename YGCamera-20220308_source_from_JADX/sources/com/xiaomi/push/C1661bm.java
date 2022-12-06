package com.xiaomi.push;

import android.net.Uri;
import android.text.TextUtils;
import com.bumptech.glide.load.Key;
import com.xiaomi.channel.commonutils.logger.C1524b;
import java.io.UnsupportedEncodingException;
import java.security.InvalidParameterException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

/* renamed from: com.xiaomi.push.bm */
public class C1661bm {
    /* renamed from: a */
    public static String m2721a(String str) {
        try {
            return String.valueOf(C1660bl.m2718a(MessageDigest.getInstance("SHA1").digest(str.getBytes(Key.STRING_CHARSET_NAME))));
        } catch (UnsupportedEncodingException | Exception | NoSuchAlgorithmException e) {
            C1524b.m2154a("CloudCoder.hash4SHA1 ", e);
            throw new IllegalStateException("failed to SHA1");
        }
    }

    /* renamed from: a */
    public static String m2722a(String str, String str2, Map<String, String> map, String str3) {
        if (!TextUtils.isEmpty(str3)) {
            ArrayList<String> arrayList = new ArrayList<>();
            if (str != null) {
                arrayList.add(str.toUpperCase());
            }
            if (str2 != null) {
                arrayList.add(Uri.parse(str2).getEncodedPath());
            }
            boolean z = true;
            if (map != null && !map.isEmpty()) {
                for (Map.Entry entry : new TreeMap(map).entrySet()) {
                    arrayList.add(String.format("%s=%s", new Object[]{entry.getKey(), entry.getValue()}));
                }
            }
            arrayList.add(str3);
            StringBuilder sb = new StringBuilder();
            for (String str4 : arrayList) {
                if (!z) {
                    sb.append('&');
                }
                sb.append(str4);
                z = false;
            }
            return m2721a(sb.toString());
        }
        throw new InvalidParameterException("security is not nullable");
    }
}
