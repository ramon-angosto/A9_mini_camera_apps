package com.huawei.secure.android.common.webview;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.URLUtil;
import com.huawei.secure.android.common.util.LogsUtil;
import java.net.MalformedURLException;
import java.net.URL;

public class UriUtil {
    private static final String TAG = "UriUtil";

    public static boolean isUrlHostInWhitelist(String str, String[] strArr) {
        if (strArr == null || strArr.length == 0) {
            LogsUtil.m1614e(TAG, "whitelist is null");
            return false;
        }
        for (String isUrlHostMatchWhitelist : strArr) {
            if (isUrlHostMatchWhitelist(str, isUrlHostMatchWhitelist)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isUrlHostSameWhitelist(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            return TextUtils.equals(getHostByURI(str), m1665i(str2));
        }
        Log.e(TAG, "isUrlHostSameWhitelist: url or host is null");
        return false;
    }

    public static boolean isUrlHostSameWhitelist(String str, String[] strArr) {
        if (strArr == null || strArr.length == 0) {
            LogsUtil.m1614e(TAG, "whitelist is null");
            return false;
        }
        for (String isUrlHostSameWhitelist : strArr) {
            if (isUrlHostSameWhitelist(str, isUrlHostSameWhitelist)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isUrlHostMatchWhitelist(String str, String str2) {
        String hostByURI = getHostByURI(str);
        if (TextUtils.isEmpty(hostByURI) || TextUtils.isEmpty(str2)) {
            LogsUtil.m1614e(TAG, "url or whitelist is null");
            return false;
        }
        String i = m1665i(str2);
        if (TextUtils.isEmpty(i)) {
            Log.e(TAG, "whitelist host is null");
            return false;
        } else if (i.equals(hostByURI)) {
            return true;
        } else {
            if (hostByURI.endsWith(i)) {
                try {
                    String substring = hostByURI.substring(0, hostByURI.length() - i.length());
                    if (!substring.endsWith(".")) {
                        return false;
                    }
                    return substring.matches("^[A-Za-z0-9.-]+$");
                } catch (IndexOutOfBoundsException e) {
                    LogsUtil.m1614e(TAG, "IndexOutOfBoundsException" + e.getMessage());
                } catch (Exception e2) {
                    LogsUtil.m1614e(TAG, "Exception : " + e2.getMessage());
                    return false;
                }
            }
            return false;
        }
    }

    public static String getHostByURI(String str) {
        if (TextUtils.isEmpty(str)) {
            LogsUtil.m1620i(TAG, "url is null");
            return str;
        }
        try {
            if (URLUtil.isNetworkUrl(str)) {
                return new URL(str.replaceAll("[\\\\#]", "/")).getHost();
            }
            LogsUtil.m1614e(TAG, "url don't starts with http or https");
            return "";
        } catch (MalformedURLException e) {
            LogsUtil.m1614e(TAG, "getHostByURI error  MalformedURLException : " + e.getMessage());
            return "";
        }
    }

    /* renamed from: i */
    private static String m1665i(String str) {
        if (TextUtils.isEmpty(str)) {
            LogsUtil.m1620i(TAG, "whiteListUrl is null");
            return null;
        } else if (!URLUtil.isNetworkUrl(str)) {
            return str;
        } else {
            return getHostByURI(str);
        }
    }

    public static boolean isUrlHostAndPathInWhitelist(String str, String[] strArr) {
        if (strArr == null || strArr.length == 0) {
            LogsUtil.m1614e(TAG, "whitelist is null");
            return false;
        }
        for (String isUrlHostAndPathMatchWhitelist : strArr) {
            if (isUrlHostAndPathMatchWhitelist(str, isUrlHostAndPathMatchWhitelist)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isUrlHostAndPathMatchWhitelist(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            if (str.contains("..") || str.contains("@")) {
                Log.e(TAG, "url contains unsafe char");
            } else {
                if (!str2.equals(str)) {
                    if (!str.startsWith(str2 + "?")) {
                        if (!str.startsWith(str2 + "#")) {
                            if (!str2.endsWith("/")) {
                                return false;
                            }
                            if (Uri.parse(str).getPathSegments().size() - Uri.parse(str2).getPathSegments().size() != 1) {
                                return false;
                            }
                            return str.startsWith(str2);
                        }
                    }
                }
                return true;
            }
        }
        return false;
    }
}
