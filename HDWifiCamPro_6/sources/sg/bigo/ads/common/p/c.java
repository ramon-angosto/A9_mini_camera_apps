package sg.bigo.ads.common.p;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import sg.bigo.ads.common.k.a;

public final class c {
    private static boolean a(int i) {
        return i == 4;
    }

    public static boolean a(Context context) {
        int b = b(context);
        return c(b) || a(b) || b(b);
    }

    public static int b(Context context) {
        if (context == null) {
            return 0;
        }
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getApplicationContext().getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                return 0;
            }
            int type = activeNetworkInfo.getType();
            if (type == 1) {
                return 3;
            }
            if (type != 0) {
                return 0;
            }
            switch (activeNetworkInfo.getSubtype()) {
                case 1:
                case 2:
                case 4:
                case 7:
                case 11:
                case 16:
                    return 1;
                case 3:
                case 5:
                case 6:
                case 8:
                case 9:
                case 10:
                case 12:
                case 14:
                case 15:
                case 17:
                case 18:
                    return 2;
                case 13:
                    return 4;
                case 20:
                    return 5;
                default:
                    return 0;
            }
        } catch (Throwable th) {
            a.a(0, "NetworkUtil", "exception on get network info:" + th.getMessage());
            return 0;
        }
    }

    private static boolean b(int i) {
        return i == 5;
    }

    private static boolean c(int i) {
        return i == 3;
    }

    public static boolean c(Context context) {
        if (context == null) {
            return true;
        }
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getApplicationContext().getSystemService("connectivity")).getActiveNetworkInfo();
            return activeNetworkInfo != null && activeNetworkInfo.isConnected();
        } catch (Exception e) {
            e.printStackTrace();
            return true;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x005c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String d(android.content.Context r14) {
        /*
            r0 = 3
            java.lang.String r1 = "sp_user_agent"
            java.lang.String r2 = ""
            java.lang.Object r2 = sg.bigo.ads.common.n.b.b(r1, r2, r0)
            java.lang.String r2 = (java.lang.String) r2
            long r3 = java.lang.System.currentTimeMillis()
            r5 = 0
            java.lang.Long r7 = java.lang.Long.valueOf(r5)
            java.lang.String r8 = "sp_user_agent_last_check_ts"
            r9 = 1
            java.lang.Object r7 = sg.bigo.ads.common.n.b.b(r8, r7, r9)
            java.lang.Long r7 = (java.lang.Long) r7
            long r10 = r7.longValue()
            long r10 = r3 - r10
            boolean r7 = android.text.TextUtils.isEmpty(r2)
            if (r7 != 0) goto L_0x003e
            int r5 = (r10 > r5 ? 1 : (r10 == r5 ? 0 : -1))
            if (r5 <= 0) goto L_0x003e
            r5 = 7
            java.util.concurrent.TimeUnit r7 = java.util.concurrent.TimeUnit.DAYS
            r12 = 1
            long r12 = r7.toMillis(r12)
            long r12 = r12 * r5
            int r5 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r5 >= 0) goto L_0x003e
            return r2
        L_0x003e:
            int r2 = android.os.Build.VERSION.SDK_INT
            r5 = 17
            if (r2 < r5) goto L_0x0049
            java.lang.String r14 = android.webkit.WebSettings.getDefaultUserAgent(r14)     // Catch:{ Exception -> 0x0049 }
            goto L_0x004f
        L_0x0049:
            java.lang.String r14 = "http.agent"
            java.lang.String r14 = java.lang.System.getProperty(r14)
        L_0x004f:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            int r5 = r14.length()
            r6 = 0
            r7 = r6
        L_0x005a:
            if (r7 >= r5) goto L_0x0081
            char r10 = r14.charAt(r7)
            r11 = 31
            if (r10 <= r11) goto L_0x006d
            r11 = 127(0x7f, float:1.78E-43)
            if (r10 < r11) goto L_0x0069
            goto L_0x006d
        L_0x0069:
            r2.append(r10)
            goto L_0x007e
        L_0x006d:
            java.lang.Object[] r11 = new java.lang.Object[r9]
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)
            r11[r6] = r10
            java.lang.String r10 = "\\u%04x"
            java.lang.String r10 = java.lang.String.format(r10, r11)
            r2.append(r10)
        L_0x007e:
            int r7 = r7 + 1
            goto L_0x005a
        L_0x0081:
            java.lang.String r14 = r2.toString()
            sg.bigo.ads.common.n.b.a(r1, r14, r0)
            java.lang.Long r0 = java.lang.Long.valueOf(r3)
            sg.bigo.ads.common.n.b.a(r8, r0, r9)
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: sg.bigo.ads.common.p.c.d(android.content.Context):java.lang.String");
    }
}
