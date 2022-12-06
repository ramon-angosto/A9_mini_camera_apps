package com.alibaba.sdk.android.oss.common.utils;

import com.huawei.hms.framework.common.ContainerUtils;
import com.xiaomi.mipush.sdk.Constants;
import java.net.URLEncoder;
import java.util.Map;

public class HttpUtil {
    public static String urlEncode(String str, String str2) {
        if (str == null) {
            return "";
        }
        try {
            return URLEncoder.encode(str, str2).replace("+", "%20").replace("*", "%2A").replace("%7E", Constants.WAVE_SEPARATOR).replace("%2F", "/");
        } catch (Exception e) {
            throw new IllegalArgumentException("failed to encode url!", e);
        }
    }

    public static String paramToQueryString(Map<String, String> map, String str) {
        if (map == null || map.isEmpty()) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        boolean z = true;
        for (Map.Entry next : map.entrySet()) {
            String str2 = (String) next.getKey();
            String str3 = (String) next.getValue();
            if (!z) {
                sb.append(ContainerUtils.FIELD_DELIMITER);
            }
            sb.append(urlEncode(str2, str));
            if (str3 != null) {
                sb.append(ContainerUtils.KEY_VALUE_DELIMITER);
                sb.append(urlEncode(str3, str));
            }
            z = false;
        }
        return sb.toString();
    }
}
