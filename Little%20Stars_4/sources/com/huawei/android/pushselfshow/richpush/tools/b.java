package com.huawei.android.pushselfshow.richpush.tools;

public class b {
    public static String a(String str) {
        return ("application/zip".equals(str) || "application/zip_local".equals(str)) ? ".zip" : "text/html".equals(str) ? ".html" : "image/jpeg".equals(str) ? ".jpg" : ".unknow";
    }
}
