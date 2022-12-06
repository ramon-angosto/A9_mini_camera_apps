package com.mbridge.msdk.foundation.same.net;

import android.os.Handler;
import android.os.Process;
import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.tools.l;

public class Aa {
    private static final String C_END = "_mv_end";
    private static final String C_START = "mv_channel_";
    private static String a = "";

    private static void b(String str) {
        String str2;
        Integer c;
        if (!TextUtils.isEmpty(str)) {
            try {
                str2 = l.b(str);
            } catch (Throwable th) {
                th.printStackTrace();
                str2 = null;
            }
            if (!TextUtils.isEmpty(str2) && str2.startsWith(C_START) && str2.endsWith(C_END) && (c = c(str2)) != null) {
                a = String.valueOf(c);
            } else if (!MBridgeConstans.DEBUG) {
                a = "";
            } else {
                g();
                throw new RuntimeException("please don't update this value");
            }
        }
    }

    private static Integer c(String str) {
        Integer valueOf;
        Integer num = null;
        if (str != null) {
            int indexOf = str.indexOf(C_START);
            int indexOf2 = str.indexOf(C_END);
            if (!(indexOf == -1 || indexOf2 == -1 || indexOf2 <= indexOf)) {
                try {
                    valueOf = Integer.valueOf(str.substring(indexOf + 11, indexOf2));
                } catch (Throwable th) {
                    th = th;
                    th.printStackTrace();
                    return num;
                }
                try {
                    if (valueOf.intValue() > 0) {
                        return valueOf;
                    }
                    return null;
                } catch (Throwable th2) {
                    Throwable th3 = th2;
                    num = valueOf;
                    th = th3;
                    th.printStackTrace();
                    return num;
                }
            }
        }
        return num;
    }

    public static String a() {
        return a;
    }

    private static void g() {
        new Handler().postDelayed(new Runnable() {
            public final void run() {
                try {
                    Process.killProcess(Process.myPid());
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }, 500);
    }
}
