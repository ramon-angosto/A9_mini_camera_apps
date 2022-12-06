package com.xiaomi.channel.commonutils.android;

import com.meizu.cloud.pushsdk.constants.MeizuConstants;

public class h {
    public static String a(String str, String str2) {
        try {
            return (String) Class.forName(MeizuConstants.CLS_NAME_SYSTEM_PROPERTIES).getMethod("get", new Class[]{String.class, String.class}).invoke((Object) null, new Object[]{str, str2});
        } catch (Exception e) {
            e.printStackTrace();
            return str2;
        }
    }
}
