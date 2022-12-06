package com.alibaba.sdk.android.oss.common.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;

public class HttpUtil {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final String ISO_8859_1_CHARSET = "iso-8859-1";
    private static final String JAVA_CHARSET = "utf-8";

    public static String urlEncode(String str, String str2) {
        if (str == null) {
            return "";
        }
        try {
            return URLEncoder.encode(str, str2).replace("+", "%20").replace("*", "%2A").replace("%7E", "~").replace("%2F", "/");
        } catch (UnsupportedEncodingException e) {
            throw new IllegalArgumentException("failed to encode url!", e);
        }
    }

    public static String paramToQueryString(Map<String, String> map, String str) throws UnsupportedEncodingException {
        if (map == null || map.size() == 0) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        boolean z = true;
        for (Map.Entry next : map.entrySet()) {
            String str2 = (String) next.getKey();
            String str3 = (String) next.getValue();
            if (!z) {
                sb.append("&");
            }
            sb.append(str2);
            if (str3 != null) {
                sb.append("=");
                sb.append(urlEncode(str3, str));
            }
            z = false;
        }
        return sb.toString();
    }

    public static void convertHeaderCharsetFromIso88591(Map<String, String> map) {
        convertHeaderCharset(map, ISO_8859_1_CHARSET, "utf-8");
    }

    public static void convertHeaderCharsetToIso88591(Map<String, String> map) {
        convertHeaderCharset(map, "utf-8", ISO_8859_1_CHARSET);
    }

    private static void convertHeaderCharset(Map<String, String> map, String str, String str2) {
        for (Map.Entry next : map.entrySet()) {
            if (next.getValue() != null) {
                try {
                    next.setValue(new String(((String) next.getValue()).getBytes(str), str2));
                } catch (UnsupportedEncodingException unused) {
                    throw new AssertionError("Invalid charset name.");
                }
            }
        }
    }
}
