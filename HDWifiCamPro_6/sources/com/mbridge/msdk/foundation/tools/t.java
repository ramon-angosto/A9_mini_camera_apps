package com.mbridge.msdk.foundation.tools;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.b.c;
import com.mbridge.msdk.foundation.same.b.e;
import com.mbridge.msdk.out.NativeListener;
import java.io.File;
import java.util.Iterator;
import java.util.List;

/* compiled from: SameSDKTool */
public final class t extends f {
    public static boolean a = false;
    public static char[] b = {'a', 'n', 'd', 'r', 'o', 'i', 'd', 'c', 'o', 'n', 't', 'e', 'n', 't', 'p', 'm', 'g', 'e', 't', 'C', 'o', 'n', 't', 'e', 'x', 't'};

    /* compiled from: SameSDKTool */
    public static class a {
        private static Intent a(Context context) {
            return new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=com.package.name"));
        }

        private static List<ResolveInfo> b(Context context) {
            try {
                return context.getPackageManager().queryIntentActivities(a(context), 0);
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }

        public static boolean a(String str) {
            return b(str) || c(str);
        }

        public static boolean b(String str) {
            try {
                if (!TextUtils.isEmpty(str)) {
                    return Uri.parse(str).getScheme().equals("market");
                }
                return false;
            } catch (Throwable th) {
                q.d("SDKUtil", Log.getStackTraceString(th));
                return false;
            }
        }

        private static boolean c(String str) {
            Uri parse;
            try {
                if (TextUtils.isEmpty(str) || (parse = Uri.parse(str)) == null || TextUtils.isEmpty(parse.getHost())) {
                    return false;
                }
                if (parse.getHost().equals("play.google.com") || parse.getHost().equals("market.android.com")) {
                    return true;
                }
                return false;
            } catch (Throwable th) {
                q.d("SDKUtil", Log.getStackTraceString(th));
            }
            return false;
        }

        public static boolean a(Context context, String str, NativeListener.NativeTrackingListener nativeTrackingListener) {
            try {
                List<ResolveInfo> b = b(context);
                if (b != null) {
                    if (b.size() > 0) {
                        if (!b(str)) {
                            if (c(str)) {
                                str = "market://" + str.substring(str.indexOf("details?id="));
                            } else {
                                str = null;
                            }
                        }
                        if (TextUtils.isEmpty(str)) {
                            return false;
                        }
                        Intent a = a(context);
                        a.setData(Uri.parse(str));
                        a.addFlags(268435456);
                        Iterator<ResolveInfo> it = b.iterator();
                        while (true) {
                            if (it.hasNext()) {
                                if (it.next().activityInfo.packageName.equals("com.android.vending")) {
                                    a.setPackage("com.android.vending");
                                    break;
                                }
                            } else {
                                break;
                            }
                        }
                        context.startActivity(a);
                        t.a(nativeTrackingListener);
                        return true;
                    }
                }
                return false;
            } catch (Throwable th) {
                q.d("SDKUtil", Log.getStackTraceString(th));
                return false;
            }
        }
    }

    public static void a(NativeListener.NativeTrackingListener nativeTrackingListener) {
        if (nativeTrackingListener instanceof NativeListener.TrackingExListener) {
            ((NativeListener.TrackingExListener) nativeTrackingListener).onLeaveApp();
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(7:11|(2:12|(2:14|(2:26|16))(0))|17|18|19|20|29) */
    /* JADX WARNING: Code restructure failed: missing block: B:31:?, code lost:
        return;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x006f */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(android.content.Context r8, java.lang.String r9, com.mbridge.msdk.out.NativeListener.NativeTrackingListener r10) {
        /*
            java.lang.String r0 = "com.android.vending"
            android.content.Intent r1 = new android.content.Intent     // Catch:{ Exception -> 0x00a5 }
            java.lang.String r2 = "android.intent.action.VIEW"
            android.net.Uri r3 = android.net.Uri.parse(r9)     // Catch:{ Exception -> 0x00a5 }
            r1.<init>(r2, r3)     // Catch:{ Exception -> 0x00a5 }
            r2 = 268435456(0x10000000, float:2.5243549E-29)
            r1.addFlags(r2)     // Catch:{ Exception -> 0x00a5 }
            android.content.pm.PackageManager r2 = r8.getPackageManager()     // Catch:{ Exception -> 0x00a5 }
            r3 = 0
            java.util.List r2 = r2.queryIntentActivities(r1, r3)     // Catch:{ Exception -> 0x00a5 }
            int r4 = r2.size()     // Catch:{ Exception -> 0x00a5 }
            if (r4 <= 0) goto L_0x0022
            r3 = 1
        L_0x0022:
            java.lang.String r4 = "market://"
            boolean r4 = r9.startsWith(r4)     // Catch:{ Exception -> 0x00a5 }
            java.lang.String r5 = "https://play.google.com/store/apps/details?id="
            java.lang.String r6 = ""
            java.lang.String r7 = "market://details?id="
            if (r4 == 0) goto L_0x0086
            if (r3 != 0) goto L_0x0049
            java.lang.String r9 = r9.replace(r7, r6)     // Catch:{ Exception -> 0x00a5 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00a5 }
            r0.<init>()     // Catch:{ Exception -> 0x00a5 }
            r0.append(r5)     // Catch:{ Exception -> 0x00a5 }
            r0.append(r9)     // Catch:{ Exception -> 0x00a5 }
            java.lang.String r9 = r0.toString()     // Catch:{ Exception -> 0x00a5 }
            b(r8, r9, r10)     // Catch:{ Exception -> 0x00a5 }
            goto L_0x00af
        L_0x0049:
            java.util.Iterator r2 = r2.iterator()     // Catch:{ Exception -> 0x00a5 }
        L_0x004d:
            boolean r3 = r2.hasNext()     // Catch:{ Exception -> 0x00a5 }
            if (r3 == 0) goto L_0x0068
            java.lang.Object r3 = r2.next()     // Catch:{ Exception -> 0x00a5 }
            android.content.pm.ResolveInfo r3 = (android.content.pm.ResolveInfo) r3     // Catch:{ Exception -> 0x00a5 }
            android.content.pm.ActivityInfo r3 = r3.activityInfo     // Catch:{ Exception -> 0x00a5 }
            java.lang.String r3 = r3.packageName     // Catch:{ Exception -> 0x00a5 }
            boolean r3 = r3.equals(r0)     // Catch:{ Exception -> 0x00a5 }
            if (r3 == 0) goto L_0x004d
            java.lang.String r2 = "com.android.vending.AssetBrowserActivity"
            r1.setClassName(r0, r2)     // Catch:{ Exception -> 0x00a5 }
        L_0x0068:
            r8.startActivity(r1)     // Catch:{ Exception -> 0x006f }
            a((com.mbridge.msdk.out.NativeListener.NativeTrackingListener) r10)     // Catch:{ Exception -> 0x006f }
            goto L_0x00af
        L_0x006f:
            java.lang.String r9 = r9.replace(r7, r6)     // Catch:{ Exception -> 0x00a5 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00a5 }
            r0.<init>()     // Catch:{ Exception -> 0x00a5 }
            r0.append(r5)     // Catch:{ Exception -> 0x00a5 }
            r0.append(r9)     // Catch:{ Exception -> 0x00a5 }
            java.lang.String r9 = r0.toString()     // Catch:{ Exception -> 0x00a5 }
            b(r8, r9, r10)     // Catch:{ Exception -> 0x00a5 }
            goto L_0x00af
        L_0x0086:
            java.lang.String r0 = "https://play.google.com/"
            boolean r0 = r9.startsWith(r0)     // Catch:{ Exception -> 0x00a5 }
            if (r0 == 0) goto L_0x00af
            java.lang.String r9 = r9.replace(r5, r6)     // Catch:{ Exception -> 0x00a5 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00a5 }
            r0.<init>()     // Catch:{ Exception -> 0x00a5 }
            r0.append(r7)     // Catch:{ Exception -> 0x00a5 }
            r0.append(r9)     // Catch:{ Exception -> 0x00a5 }
            java.lang.String r9 = r0.toString()     // Catch:{ Exception -> 0x00a5 }
            a(r8, r9, r10)     // Catch:{ Exception -> 0x00a5 }
            goto L_0x00af
        L_0x00a5:
            r8 = move-exception
            java.lang.String r8 = r8.getMessage()
            java.lang.String r9 = "SDKUtil"
            com.mbridge.msdk.foundation.tools.q.d(r9, r8)
        L_0x00af:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.tools.t.a(android.content.Context, java.lang.String, com.mbridge.msdk.out.NativeListener$NativeTrackingListener):void");
    }

    public static void a(Context context, String str, CampaignEx campaignEx, NativeListener.NativeTrackingListener nativeTrackingListener) {
        if (context != null) {
            if (a) {
                b(context, str, nativeTrackingListener);
                return;
            }
            try {
                Class.forName("com.mbridge.msdk.activity.MBCommonActivity");
                Intent intent = new Intent(context, Class.forName("com.mbridge.msdk.activity.MBCommonActivity"));
                if (!TextUtils.isEmpty(str)) {
                    if (a.b(str)) {
                        str = "https://play.google.com/store/apps/details?id=" + str.replace("market://details?id=", "");
                    }
                    intent.putExtra("url", str);
                    q.b("url", "webview url = " + str);
                    intent.setFlags(268435456);
                    intent.putExtra("mvcommon", campaignEx);
                    context.startActivity(intent);
                }
            } catch (Exception unused) {
                b(context, str, nativeTrackingListener);
            }
        }
    }

    public static void b(Context context, String str, NativeListener.NativeTrackingListener nativeTrackingListener) {
        if (str != null && context != null) {
            try {
                if (a.b(str)) {
                    str = "https://play.google.com/store/apps/details?id=" + str.replace("market://details?id=", "");
                }
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
                intent.addFlags(268435456);
                ResolveInfo resolveActivity = context.getPackageManager().resolveActivity(intent, 65536);
                if (resolveActivity != null) {
                    intent.setClassName(resolveActivity.activityInfo.packageName, resolveActivity.activityInfo.name);
                }
                context.startActivity(intent);
                a(nativeTrackingListener);
            } catch (Exception e) {
                e.printStackTrace();
                try {
                    Intent intent2 = new Intent("android.intent.action.VIEW", Uri.parse(str));
                    intent2.addFlags(268468224);
                    context.startActivity(intent2);
                    a(nativeTrackingListener);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        File a2 = e.a(c.MBRIDGE_700_IMG);
        String str2 = "";
        if (!TextUtils.isEmpty(str)) {
            if (str.lastIndexOf("/") == -1) {
                str2 = str.hashCode() + str2;
            } else {
                str2 = (str.hashCode() + str.substring(str.lastIndexOf("/") + 1).hashCode()) + str2;
            }
        }
        return new File(a2, str2).getAbsolutePath();
    }
}
