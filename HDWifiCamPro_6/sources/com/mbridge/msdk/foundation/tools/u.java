package com.mbridge.msdk.foundation.tools;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Looper;
import android.os.PowerManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.webkit.WebView;
import android.widget.ImageView;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.b.a;
import com.mbridge.msdk.b.b;
import com.mbridge.msdk.foundation.db.f;
import com.mbridge.msdk.foundation.db.g;
import com.mbridge.msdk.foundation.db.i;
import com.mbridge.msdk.foundation.db.j;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.e;
import com.mbridge.msdk.foundation.tools.i;
import java.net.URLEncoder;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;

/* compiled from: SameTool */
public final class u extends g {
    private static char[] a = {'A', 'p', 'p', 'l', 'i', 'c', 'a', 't', 'i', 'o', 'n', 'I', 'n', 'f', 'o'};
    private static char[] b = {'.', 'X'};
    private static int c = 0;
    private static int d = 1;
    private static int e = 2;
    private static int f = 3;
    private static int g = 0;
    private static int h = 7;
    private static int i = 14;
    private static int j = 19;
    private static int k = 16;
    private static int l = 26;
    private static String m = "[一-龥]";
    private static Pattern n = Pattern.compile(m);
    private static int o = 1;
    private static boolean p = true;
    private static Map<String, String> q;
    private static Map<String, String> r;
    private static volatile Boolean s = null;

    public static <T extends String> boolean a(T t) {
        return t == null || t.length() == 0;
    }

    public static boolean b(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo == null || !"wifi".equals(activeNetworkInfo.getTypeName().toLowerCase(Locale.US))) {
                return false;
            }
            return true;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public static boolean c(Context context) {
        try {
            if (((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo() != null) {
                return true;
            }
            return false;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public static boolean a(CampaignEx campaignEx) {
        if (campaignEx != null) {
            return !TextUtils.isEmpty(campaignEx.getDeepLinkURL());
        }
        return false;
    }

    public static float d(Context context) {
        if (context == null) {
            return 2.5f;
        }
        try {
            float f2 = context.getResources().getDisplayMetrics().density;
            if (f2 == 0.0f) {
                return 2.5f;
            }
            return f2;
        } catch (Exception e2) {
            e2.printStackTrace();
            return 2.5f;
        }
    }

    public static int a(Context context, float f2) {
        float f3 = 2.5f;
        if (context != null) {
            try {
                float f4 = context.getResources().getDisplayMetrics().density;
                if (f4 != 0.0f) {
                    f3 = f4;
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return (int) ((f2 / f3) + 0.5f);
    }

    public static int b(Context context, float f2) {
        Resources resources;
        if (context == null || (resources = context.getResources()) == null) {
            return 0;
        }
        return (int) ((f2 * resources.getDisplayMetrics().density) + 0.5f);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x001d, code lost:
        if (r2 != null) goto L_0x001f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
        r2.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x002a, code lost:
        if (r2 != null) goto L_0x001f;
     */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0026 A[SYNTHETIC, Splitter:B:19:0x0026] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static long a(java.io.File r4) throws java.lang.Exception {
        /*
            r0 = 0
            r2 = 0
            boolean r3 = r4.exists()     // Catch:{ Exception -> 0x002a, all -> 0x0023 }
            if (r3 == 0) goto L_0x001a
            java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch:{ Exception -> 0x002a, all -> 0x0023 }
            r3.<init>(r4)     // Catch:{ Exception -> 0x002a, all -> 0x0023 }
            int r4 = r3.available()     // Catch:{ Exception -> 0x0018, all -> 0x0015 }
            long r0 = (long) r4
            r2 = r3
            goto L_0x001d
        L_0x0015:
            r4 = move-exception
            r2 = r3
            goto L_0x0024
        L_0x0018:
            r2 = r3
            goto L_0x002a
        L_0x001a:
            r4.createNewFile()     // Catch:{ Exception -> 0x002a, all -> 0x0023 }
        L_0x001d:
            if (r2 == 0) goto L_0x002d
        L_0x001f:
            r2.close()     // Catch:{ Exception -> 0x002d }
            goto L_0x002d
        L_0x0023:
            r4 = move-exception
        L_0x0024:
            if (r2 == 0) goto L_0x0029
            r2.close()     // Catch:{ Exception -> 0x0029 }
        L_0x0029:
            throw r4
        L_0x002a:
            if (r2 == 0) goto L_0x002d
            goto L_0x001f
        L_0x002d:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.tools.u.a(java.io.File):long");
    }

    public static int e(Context context) {
        try {
            Class<?> cls = Class.forName("com.android.internal.R$dimen");
            return context.getResources().getDimensionPixelSize(Integer.parseInt(cls.getField("status_bar_height").get(cls.newInstance()).toString()));
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    public static float f(Context context) {
        return (float) context.getResources().getDisplayMetrics().widthPixels;
    }

    public static int a() {
        int i2 = o;
        o = i2 + 1;
        return i2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x004c A[Catch:{ Exception -> 0x005f }, LOOP:0: B:17:0x004a->B:18:0x004c, LOOP_END] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String a(int r6) {
        /*
            java.lang.String r0 = ""
            com.mbridge.msdk.b.b r1 = com.mbridge.msdk.b.b.a()     // Catch:{ Exception -> 0x005f }
            com.mbridge.msdk.foundation.controller.a r2 = com.mbridge.msdk.foundation.controller.a.e()     // Catch:{ Exception -> 0x005f }
            java.lang.String r2 = r2.h()     // Catch:{ Exception -> 0x005f }
            com.mbridge.msdk.b.a r1 = r1.b(r2)     // Catch:{ Exception -> 0x005f }
            if (r1 != 0) goto L_0x001c
            com.mbridge.msdk.b.b r1 = com.mbridge.msdk.b.b.a()     // Catch:{ Exception -> 0x005f }
            com.mbridge.msdk.b.a r1 = r1.b()     // Catch:{ Exception -> 0x005f }
        L_0x001c:
            org.json.JSONArray r2 = new org.json.JSONArray     // Catch:{ Exception -> 0x005f }
            r2.<init>()     // Catch:{ Exception -> 0x005f }
            if (r1 == 0) goto L_0x0054
            int r1 = r1.C()     // Catch:{ Exception -> 0x005f }
            r3 = 1
            if (r1 != r3) goto L_0x0054
            com.mbridge.msdk.foundation.controller.a r1 = com.mbridge.msdk.foundation.controller.a.e()     // Catch:{ Exception -> 0x005f }
            android.content.Context r1 = r1.g()     // Catch:{ Exception -> 0x005f }
            com.mbridge.msdk.foundation.db.g r1 = com.mbridge.msdk.foundation.db.g.a((android.content.Context) r1)     // Catch:{ Exception -> 0x005f }
            com.mbridge.msdk.foundation.db.j r1 = com.mbridge.msdk.foundation.db.j.a((com.mbridge.msdk.foundation.db.f) r1)     // Catch:{ Exception -> 0x005f }
            long[] r1 = r1.a()     // Catch:{ Exception -> 0x005f }
            if (r1 == 0) goto L_0x0054
            int r3 = r1.length     // Catch:{ Exception -> 0x005f }
            if (r3 <= r6) goto L_0x0049
            if (r6 != 0) goto L_0x0046
            goto L_0x0049
        L_0x0046:
            int r6 = r3 - r6
            goto L_0x004a
        L_0x0049:
            r6 = 0
        L_0x004a:
            if (r6 >= r3) goto L_0x0054
            r4 = r1[r6]     // Catch:{ Exception -> 0x005f }
            r2.put(r4)     // Catch:{ Exception -> 0x005f }
            int r6 = r6 + 1
            goto L_0x004a
        L_0x0054:
            int r6 = r2.length()     // Catch:{ Exception -> 0x005f }
            if (r6 <= 0) goto L_0x0063
            java.lang.String r0 = a((org.json.JSONArray) r2)     // Catch:{ Exception -> 0x005f }
            goto L_0x0063
        L_0x005f:
            r6 = move-exception
            r6.printStackTrace()
        L_0x0063:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.tools.u.a(int):java.lang.String");
    }

    public static String a(JSONArray jSONArray) {
        if (jSONArray == null) {
            return "";
        }
        a b2 = b.a().b(com.mbridge.msdk.foundation.controller.a.e().h());
        if (b2 == null) {
            b2 = b.a().b();
        }
        int u = b2.u();
        if (jSONArray.length() <= u) {
            return jSONArray.toString();
        }
        JSONArray jSONArray2 = new JSONArray();
        for (int i2 = 0; i2 < u; i2++) {
            try {
                jSONArray2.put(jSONArray.get(i2));
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        return jSONArray2.toString();
    }

    public static boolean a(String str, Context context) {
        try {
            if (context.getPackageManager().checkPermission(str, context.getPackageName()) == 0) {
                return true;
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean b(CampaignEx campaignEx) {
        if (campaignEx != null) {
            try {
                return campaignEx.getRetarget_offer() == 1;
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return false;
    }

    public static double b(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                return Double.parseDouble(str);
            }
            return 0.0d;
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0.0d;
        }
    }

    public static int a(Object obj) {
        if (obj == null) {
            return 0;
        }
        try {
            if (obj instanceof String) {
                return Integer.parseInt((String) obj);
            }
            return 0;
        } catch (Throwable th) {
            q.a("SameTools", th.getMessage(), th);
            return 0;
        }
    }

    public static double a(Double d2) {
        try {
            String format = new DecimalFormat("0.00", DecimalFormatSymbols.getInstance(Locale.US)).format(d2);
            if (x.b(format)) {
                return Double.parseDouble(format);
            }
            return 0.0d;
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0.0d;
        }
    }

    private static DisplayMetrics n(Context context) {
        if (context == null) {
            return null;
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        try {
            Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
            if (Build.VERSION.SDK_INT >= 17) {
                defaultDisplay.getRealMetrics(displayMetrics);
                return displayMetrics;
            }
            defaultDisplay.getMetrics(displayMetrics);
            return displayMetrics;
        } catch (Throwable th) {
            th.printStackTrace();
            return context.getResources().getDisplayMetrics();
        }
    }

    public static int g(Context context) {
        if (context == null) {
            return 0;
        }
        try {
            return n(context).heightPixels;
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    public static int h(Context context) {
        if (context == null) {
            return 0;
        }
        try {
            return n(context).widthPixels;
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    public static int i(Context context) {
        if (context == null) {
            return 0;
        }
        try {
            return context.getResources().getDisplayMetrics().widthPixels;
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    public static int j(Context context) {
        if (context == null) {
            return 0;
        }
        try {
            return context.getResources().getDisplayMetrics().heightPixels;
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    public static void a(View view) {
        if (view != null) {
            try {
                if (Build.VERSION.SDK_INT >= 11) {
                    view.setSystemUiVisibility(4102);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public static int k(Context context) {
        if (context != null) {
            return 0;
        }
        try {
            if (context.getResources().getIdentifier("config_showNavigationBar", "bool", "android") != 0) {
                return context.getResources().getDimensionPixelSize(context.getResources().getIdentifier("navigation_bar_height", "dimen", "android"));
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return 0;
    }

    public static void a(ImageView imageView) {
        if (imageView != null) {
            try {
                imageView.setImageResource(0);
                imageView.setImageDrawable((Drawable) null);
                imageView.setImageURI((Uri) null);
                imageView.setImageBitmap((Bitmap) null);
            } catch (Throwable th) {
                if (MBridgeConstans.DEBUG) {
                    th.printStackTrace();
                }
            }
        }
    }

    public static List<String> b(JSONArray jSONArray) {
        if (jSONArray == null) {
            return null;
        }
        try {
            if (jSONArray.length() <= 0) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                String optString = jSONArray.optString(i2);
                if (x.b(optString)) {
                    arrayList.add(optString);
                }
            }
            return arrayList;
        } catch (Throwable th) {
            q.a("SameTools", th.getMessage(), th);
            return null;
        }
    }

    public static String c(String str) {
        try {
            if (x.b(str)) {
                return URLEncoder.encode(str, "utf-8");
            }
            return "";
        } catch (Throwable th) {
            q.a("SameTools", th.getMessage(), th);
            return "";
        }
    }

    public static boolean b() {
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }

    public static boolean l(Context context) {
        try {
            return ((PowerManager) context.getSystemService("power")).isScreenOn();
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public static int m(Context context) {
        PackageInfo packageInfo;
        if (context == null) {
            return 0;
        }
        try {
            if (Build.VERSION.SDK_INT >= 26) {
                packageInfo = WebView.getCurrentWebViewPackage();
            } else {
                packageInfo = context.getPackageManager().getPackageInfo("com.google.android.webview", 1);
            }
            a b2 = b.a().b(com.mbridge.msdk.foundation.controller.a.e().h());
            if (b2 == null) {
                b2 = b.a().b();
            }
            if (packageInfo == null || TextUtils.isEmpty(packageInfo.versionName) || !packageInfo.versionName.equals("77.0.3865.92")) {
                return b2.aj();
            }
            return 5;
        } catch (Exception unused) {
            return 0;
        }
    }

    public static JSONArray a(Context context, String str) {
        JSONArray jSONArray = new JSONArray();
        try {
            a b2 = b.a().b(com.mbridge.msdk.foundation.controller.a.e().h());
            if (b2 == null) {
                b2 = b.a().b();
            }
            if (b2 != null && b2.C() == 1) {
                q.b("SameTools", "fqci cfc:" + b2.C());
                long[] a2 = j.a((f) g.a(context)).a();
                if (a2 != null) {
                    for (long put : a2) {
                        q.b("SameTools", "cfc campaignIds:" + a2);
                        jSONArray.put(put);
                    }
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return jSONArray;
    }

    public static String b(Context context, String str) {
        String str2 = "";
        try {
            JSONArray a2 = a(context, str);
            if (a2.length() > 0) {
                str2 = a(a2);
            }
            q.b("SameTools", "get excludes:" + str2);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return str2;
    }

    public static void a(String str, CampaignEx campaignEx, int i2) {
        if (!TextUtils.isEmpty(str) && campaignEx != null && com.mbridge.msdk.foundation.controller.a.e().g() != null) {
            i a2 = i.a((f) g.a(com.mbridge.msdk.foundation.controller.a.e().g()));
            e eVar = new e();
            eVar.a(System.currentTimeMillis());
            eVar.b(str);
            eVar.a(campaignEx.getId());
            eVar.a(i2);
            a2.a(eVar);
        }
    }

    public static synchronized boolean c(Context context, String str) {
        boolean z;
        synchronized (u.class) {
            z = false;
            if (context != null) {
                if (!TextUtils.isEmpty(str)) {
                    try {
                        if (b(str, context) != null) {
                            z = true;
                        }
                    } catch (Exception unused) {
                    }
                }
            }
        }
        return z;
    }

    private static Object b(String str, Context context) {
        try {
            return Class.forName(String.valueOf(b(c))).getMethod(String.valueOf(b(e)), new Class[]{String.class, Integer.TYPE}).invoke(Class.forName(String.valueOf(b(d))).getMethod(String.valueOf(b(f)), new Class[0]).invoke(context, new Object[0]), new Object[]{str, 8192});
        } catch (Exception unused) {
            return null;
        }
    }

    private static final char[] b(int i2) {
        StringBuilder sb;
        if (i2 == 0) {
            sb = new StringBuilder();
            sb.append(String.valueOf(Arrays.copyOf(t.b, h)));
            sb.append(b[g]);
            sb.append(String.valueOf(Arrays.copyOfRange(t.b, h, i)));
            sb.append(b[g]);
            sb.append(String.valueOf(Arrays.copyOfRange(t.b, i, k)));
            sb.append(b[g]);
            sb.append(String.valueOf(s.c));
        } else if (i2 == 1) {
            sb = new StringBuilder();
            sb.append(String.valueOf(Arrays.copyOf(t.b, h)));
            sb.append(b[g]);
            sb.append(String.valueOf(Arrays.copyOfRange(t.b, h, i)));
            sb.append(b[g]);
            sb.append(String.valueOf(Arrays.copyOfRange(t.b, j, l)));
        } else if (i2 == 2) {
            sb = new StringBuilder();
            sb.append(String.valueOf(Arrays.copyOfRange(t.b, k, j)));
            sb.append(String.valueOf(a));
        } else if (i2 != 3) {
            sb = null;
        } else {
            sb = new StringBuilder();
            sb.append(String.valueOf(Arrays.copyOfRange(t.b, k, j)));
            sb.append(String.valueOf(s.c));
        }
        return sb.toString().toCharArray();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:?, code lost:
        r2 = new java.lang.StringBuilder("&rtins_type=");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:?, code lost:
        r2.append(0);
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x0025 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0042 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static synchronized java.lang.String a(java.lang.String r2, android.content.Context r3, java.lang.String r4) {
        /*
            java.lang.Class<com.mbridge.msdk.foundation.tools.u> r0 = com.mbridge.msdk.foundation.tools.u.class
            monitor-enter(r0)
            android.net.Uri r2 = android.net.Uri.parse(r2)     // Catch:{ Exception -> 0x0025 }
            java.util.Set r2 = r2.getQueryParameterNames()     // Catch:{ Exception -> 0x0025 }
            if (r2 == 0) goto L_0x001b
            int r2 = r2.size()     // Catch:{ Exception -> 0x0025 }
            if (r2 <= 0) goto L_0x001b
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0025 }
            java.lang.String r1 = "&rtins_type="
            r2.<init>(r1)     // Catch:{ Exception -> 0x0025 }
            goto L_0x002c
        L_0x001b:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0025 }
            java.lang.String r1 = "?rtins_type="
            r2.<init>(r1)     // Catch:{ Exception -> 0x0025 }
            goto L_0x002c
        L_0x0023:
            r2 = move-exception
            goto L_0x004b
        L_0x0025:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0023 }
            java.lang.String r1 = "&rtins_type="
            r2.<init>(r1)     // Catch:{ all -> 0x0023 }
        L_0x002c:
            r1 = 0
            java.lang.Object r3 = b((java.lang.String) r4, (android.content.Context) r3)     // Catch:{ Exception -> 0x0042 }
            r4 = 1
            if (r3 == 0) goto L_0x0036
            r3 = r4
            goto L_0x0037
        L_0x0036:
            r3 = r1
        L_0x0037:
            if (r3 == 0) goto L_0x003d
            r2.append(r4)     // Catch:{ Exception -> 0x0042 }
            goto L_0x0045
        L_0x003d:
            r3 = 2
            r2.append(r3)     // Catch:{ Exception -> 0x0042 }
            goto L_0x0045
        L_0x0042:
            r2.append(r1)     // Catch:{ all -> 0x0023 }
        L_0x0045:
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0023 }
            monitor-exit(r0)
            return r2
        L_0x004b:
            monitor-exit(r0)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.tools.u.a(java.lang.String, android.content.Context, java.lang.String):java.lang.String");
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(7:2|3|4|5|6|7|8) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:6:0x000f */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized java.lang.String a(android.content.Context r2, java.lang.String r3, java.lang.String r4) {
        /*
            java.lang.Class<com.mbridge.msdk.foundation.tools.u> r0 = com.mbridge.msdk.foundation.tools.u.class
            monitor-enter(r0)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0015 }
            r1.<init>(r4)     // Catch:{ all -> 0x0015 }
            java.lang.String r2 = a((java.lang.String) r4, (android.content.Context) r2, (java.lang.String) r3)     // Catch:{ Exception -> 0x000f }
            r1.append(r2)     // Catch:{ Exception -> 0x000f }
        L_0x000f:
            java.lang.String r2 = r1.toString()     // Catch:{ all -> 0x0015 }
            monitor-exit(r0)
            return r2
        L_0x0015:
            r2 = move-exception
            monitor-exit(r0)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.tools.u.a(android.content.Context, java.lang.String, java.lang.String):java.lang.String");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:61:0x012d, code lost:
        return r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final synchronized java.lang.String d(java.lang.String r10) {
        /*
            java.lang.Class<com.mbridge.msdk.foundation.tools.u> r0 = com.mbridge.msdk.foundation.tools.u.class
            monitor-enter(r0)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0138 }
            r1.<init>()     // Catch:{ Exception -> 0x0138 }
            com.mbridge.msdk.foundation.controller.a r2 = com.mbridge.msdk.foundation.controller.a.e()     // Catch:{ Exception -> 0x0138 }
            java.lang.String r2 = r2.h()     // Catch:{ Exception -> 0x0138 }
            r1.append(r2)     // Catch:{ Exception -> 0x0138 }
            java.lang.String r2 = "_"
            r1.append(r2)     // Catch:{ Exception -> 0x0138 }
            r1.append(r10)     // Catch:{ Exception -> 0x0138 }
            java.lang.String r10 = r1.toString()     // Catch:{ Exception -> 0x0138 }
            com.mbridge.msdk.b.b r1 = com.mbridge.msdk.b.b.a()     // Catch:{ Exception -> 0x0138 }
            com.mbridge.msdk.foundation.controller.a r2 = com.mbridge.msdk.foundation.controller.a.e()     // Catch:{ Exception -> 0x0138 }
            java.lang.String r2 = r2.h()     // Catch:{ Exception -> 0x0138 }
            com.mbridge.msdk.b.a r1 = r1.b(r2)     // Catch:{ Exception -> 0x0138 }
            r2 = 3
            r3 = 0
            if (r1 == 0) goto L_0x0044
            boolean r2 = r1.Y()     // Catch:{ Exception -> 0x0138 }
            boolean r4 = r1.W()     // Catch:{ Exception -> 0x0138 }
            int r1 = r1.X()     // Catch:{ Exception -> 0x0138 }
            int r1 = java.lang.Math.max(r3, r1)     // Catch:{ Exception -> 0x0138 }
            goto L_0x0049
        L_0x0044:
            r1 = 1
            r4 = r3
            r9 = r2
            r2 = r1
            r1 = r9
        L_0x0049:
            if (r4 == 0) goto L_0x0132
            if (r1 != 0) goto L_0x004f
            goto L_0x0132
        L_0x004f:
            if (r2 == 0) goto L_0x0067
            java.util.Map<java.lang.String, java.lang.String> r4 = q     // Catch:{ Exception -> 0x0138 }
            if (r4 == 0) goto L_0x0067
            java.util.Map<java.lang.String, java.lang.String> r4 = q     // Catch:{ Exception -> 0x0138 }
            boolean r4 = r4.containsKey(r10)     // Catch:{ Exception -> 0x0138 }
            if (r4 == 0) goto L_0x0067
            java.util.Map<java.lang.String, java.lang.String> r1 = q     // Catch:{ Exception -> 0x0138 }
            java.lang.Object r10 = r1.get(r10)     // Catch:{ Exception -> 0x0138 }
            java.lang.String r10 = (java.lang.String) r10     // Catch:{ Exception -> 0x0138 }
            monitor-exit(r0)
            return r10
        L_0x0067:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0138 }
            java.lang.String r5 = ""
            r4.<init>(r5)     // Catch:{ Exception -> 0x0138 }
            java.lang.Exception r5 = new java.lang.Exception     // Catch:{ Exception -> 0x0138 }
            r5.<init>()     // Catch:{ Exception -> 0x0138 }
            java.lang.StackTraceElement[] r5 = r5.getStackTrace()     // Catch:{ Exception -> 0x0138 }
            if (r5 == 0) goto L_0x0142
            int r6 = r5.length     // Catch:{ Exception -> 0x0138 }
            if (r6 <= 0) goto L_0x0142
            java.util.List r5 = a((java.lang.StackTraceElement[]) r5)     // Catch:{ Exception -> 0x0138 }
            java.util.Collections.reverse(r5)     // Catch:{ Exception -> 0x0138 }
            java.util.Iterator r5 = r5.iterator()     // Catch:{ Exception -> 0x0138 }
            java.util.ArrayList r6 = new java.util.ArrayList     // Catch:{ Exception -> 0x0138 }
            r6.<init>()     // Catch:{ Exception -> 0x0138 }
        L_0x008c:
            boolean r7 = r5.hasNext()     // Catch:{ Exception -> 0x0138 }
            if (r7 == 0) goto L_0x00ca
            java.lang.Object r7 = r5.next()     // Catch:{ Exception -> 0x0138 }
            java.lang.String r7 = (java.lang.String) r7     // Catch:{ Exception -> 0x0138 }
            java.lang.String r8 = "com.android"
            boolean r8 = r7.startsWith(r8)     // Catch:{ Exception -> 0x0138 }
            if (r8 != 0) goto L_0x008c
            java.lang.String r8 = "android.os"
            boolean r8 = r7.startsWith(r8)     // Catch:{ Exception -> 0x0138 }
            if (r8 != 0) goto L_0x008c
            java.lang.String r8 = "android.app"
            boolean r8 = r7.startsWith(r8)     // Catch:{ Exception -> 0x0138 }
            if (r8 != 0) goto L_0x008c
            java.lang.String r8 = "java.lang.reflect.Method"
            boolean r8 = r7.startsWith(r8)     // Catch:{ Exception -> 0x0138 }
            if (r8 != 0) goto L_0x008c
            java.lang.String r8 = "android.view"
            boolean r8 = r7.startsWith(r8)     // Catch:{ Exception -> 0x0138 }
            if (r8 != 0) goto L_0x008c
            boolean r8 = r6.contains(r7)     // Catch:{ Exception -> 0x0138 }
            if (r8 != 0) goto L_0x008c
            r6.add(r7)     // Catch:{ Exception -> 0x0138 }
            goto L_0x008c
        L_0x00ca:
            int r5 = r6.size()     // Catch:{ Exception -> 0x0138 }
            int r1 = java.lang.Math.min(r5, r1)     // Catch:{ Exception -> 0x0138 }
            if (r1 <= 0) goto L_0x00eb
        L_0x00d4:
            if (r3 >= r1) goto L_0x00eb
            java.lang.Object r5 = r6.get(r3)     // Catch:{ Exception -> 0x0138 }
            java.lang.String r5 = (java.lang.String) r5     // Catch:{ Exception -> 0x0138 }
            r4.append(r5)     // Catch:{ Exception -> 0x0138 }
            int r5 = r1 + -1
            if (r3 >= r5) goto L_0x00e8
            java.lang.String r5 = "|"
            r4.append(r5)     // Catch:{ Exception -> 0x0138 }
        L_0x00e8:
            int r3 = r3 + 1
            goto L_0x00d4
        L_0x00eb:
            r1 = 0
            java.lang.String r3 = r4.toString()     // Catch:{ Exception -> 0x0138 }
            boolean r3 = android.text.TextUtils.isEmpty(r3)     // Catch:{ Exception -> 0x0138 }
            if (r3 != 0) goto L_0x0104
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch:{ Exception -> 0x0138 }
            r1.<init>()     // Catch:{ Exception -> 0x0138 }
            java.lang.String r3 = "1"
            java.lang.String r4 = r4.toString()     // Catch:{ Exception -> 0x0138 }
            r1.put(r3, r4)     // Catch:{ Exception -> 0x0138 }
        L_0x0104:
            if (r1 == 0) goto L_0x012e
            int r3 = r1.length()     // Catch:{ Exception -> 0x0138 }
            if (r3 <= 0) goto L_0x012e
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x0138 }
            java.lang.String r1 = com.mbridge.msdk.foundation.tools.a.a(r1)     // Catch:{ Exception -> 0x0138 }
            if (r2 == 0) goto L_0x012c
            boolean r2 = android.text.TextUtils.isEmpty(r1)     // Catch:{ Exception -> 0x0138 }
            if (r2 != 0) goto L_0x012c
            java.util.Map<java.lang.String, java.lang.String> r2 = q     // Catch:{ Exception -> 0x0138 }
            if (r2 != 0) goto L_0x0127
            java.util.HashMap r2 = new java.util.HashMap     // Catch:{ Exception -> 0x0138 }
            r2.<init>()     // Catch:{ Exception -> 0x0138 }
            q = r2     // Catch:{ Exception -> 0x0138 }
        L_0x0127:
            java.util.Map<java.lang.String, java.lang.String> r2 = q     // Catch:{ Exception -> 0x0138 }
            r2.put(r10, r1)     // Catch:{ Exception -> 0x0138 }
        L_0x012c:
            monitor-exit(r0)
            return r1
        L_0x012e:
            java.lang.String r10 = ""
            monitor-exit(r0)
            return r10
        L_0x0132:
            java.lang.String r10 = ""
            monitor-exit(r0)
            return r10
        L_0x0136:
            r10 = move-exception
            goto L_0x0146
        L_0x0138:
            r10 = move-exception
            java.lang.String r1 = "SameTools"
            java.lang.String r10 = r10.getMessage()     // Catch:{ all -> 0x0136 }
            com.mbridge.msdk.foundation.tools.q.d(r1, r10)     // Catch:{ all -> 0x0136 }
        L_0x0142:
            java.lang.String r10 = ""
            monitor-exit(r0)
            return r10
        L_0x0146:
            monitor-exit(r0)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.tools.u.d(java.lang.String):java.lang.String");
    }

    public static synchronized void a(String str, String str2) {
        synchronized (u.class) {
            if (r == null) {
                r = new HashMap();
            }
            r.put(com.mbridge.msdk.foundation.controller.a.e().h() + "_" + str, str2);
        }
    }

    public static synchronized String e(String str) {
        synchronized (u.class) {
            String str2 = com.mbridge.msdk.foundation.controller.a.e().h() + "_" + str;
            if (r == null || !r.containsKey(str2)) {
                return null;
            }
            String str3 = r.get(str2);
            return str3;
        }
    }

    private static List<String> a(StackTraceElement[] stackTraceElementArr) {
        ArrayList arrayList = new ArrayList();
        if (stackTraceElementArr != null && stackTraceElementArr.length > 0) {
            for (StackTraceElement className : stackTraceElementArr) {
                arrayList.add(className.getClassName());
            }
        }
        return arrayList;
    }

    public static final int c() {
        if (s == null) {
            try {
                s = i.a.a.e();
            } catch (Exception e2) {
                q.d("SameTools", e2.getMessage());
            }
        }
        if (s != null) {
            return s.booleanValue() ? 1 : 0;
        }
        return -1;
    }

    public static boolean f(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            Uri parse = Uri.parse(str);
            if (parse == null) {
                return false;
            }
            String queryParameter = parse.getQueryParameter(MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW);
            if (TextUtils.isEmpty(queryParameter)) {
                return false;
            }
            if (queryParameter.equals("2") || queryParameter.equals(MBridgeConstans.DYNAMIC_VIEW_TYPE_ALTER_NATIVE_STR_4)) {
                return true;
            }
            return false;
        } catch (Exception e2) {
            q.d("SameTools", e2.getMessage());
        } catch (Throwable unused) {
        }
        return false;
    }

    public static boolean g(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            Uri parse = Uri.parse(str);
            if (parse == null) {
                return false;
            }
            String queryParameter = parse.getQueryParameter(MBridgeConstans.ENDCARD_URL_IS_PLAYABLE);
            if (!TextUtils.isEmpty(queryParameter)) {
                return queryParameter.equals(MBridgeConstans.ENDCARD_URL_TYPE_PL);
            }
            return false;
        } catch (Exception e2) {
            q.d("SameTools", e2.getMessage());
            return false;
        }
    }

    public static boolean h(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            Uri parse = Uri.parse(str);
            if (parse == null) {
                return false;
            }
            String queryParameter = parse.getQueryParameter(MBridgeConstans.DYNAMIC_VIEW_CAN_ANIM);
            if (!TextUtils.isEmpty(queryParameter)) {
                return queryParameter.equals("1");
            }
            return false;
        } catch (Exception e2) {
            q.d("SameTools", e2.getMessage());
            return false;
        }
    }

    public static int i(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        try {
            Uri parse = Uri.parse(str);
            if (parse == null) {
                return -1;
            }
            String queryParameter = parse.getQueryParameter(MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW);
            if (TextUtils.isEmpty(queryParameter)) {
                return -1;
            }
            try {
                return Integer.parseInt(queryParameter);
            } catch (Exception unused) {
                return -1;
            }
        } catch (Exception e2) {
            q.d("SameTools", e2.getMessage());
            return -1;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x004a, code lost:
        if ((r5 + (r3 * 1000)) >= r7) goto L_0x0073;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x006f, code lost:
        if ((r5 + (r3.v() * 1000)) >= r7) goto L_0x0073;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String j(java.lang.String r14) {
        /*
            boolean r0 = android.text.TextUtils.isEmpty(r14)
            java.lang.String r1 = ""
            if (r0 == 0) goto L_0x0009
            return r1
        L_0x0009:
            java.util.concurrent.ConcurrentHashMap r14 = com.mbridge.msdk.foundation.same.a.d.a(r14)
            if (r14 == 0) goto L_0x009a
            int r0 = r14.size()
            if (r0 <= 0) goto L_0x009a
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.Collection r14 = r14.values()
            java.util.Iterator r14 = r14.iterator()
        L_0x0022:
            boolean r2 = r14.hasNext()
            if (r2 == 0) goto L_0x0085
            java.lang.Object r2 = r14.next()
            com.mbridge.msdk.foundation.entity.b r2 = (com.mbridge.msdk.foundation.entity.b) r2
            if (r2 == 0) goto L_0x0022
            long r3 = r2.d()
            long r5 = r2.e()
            long r7 = java.lang.System.currentTimeMillis()
            r9 = 0
            int r9 = (r3 > r9 ? 1 : (r3 == r9 ? 0 : -1))
            r10 = 1
            r11 = 0
            r12 = 1000(0x3e8, double:4.94E-321)
            if (r9 <= 0) goto L_0x004d
            long r3 = r3 * r12
            long r5 = r5 + r3
            int r3 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r3 < 0) goto L_0x0072
            goto L_0x0073
        L_0x004d:
            com.mbridge.msdk.b.b r3 = com.mbridge.msdk.b.b.a()
            com.mbridge.msdk.foundation.controller.a r4 = com.mbridge.msdk.foundation.controller.a.e()
            java.lang.String r4 = r4.h()
            com.mbridge.msdk.b.a r3 = r3.b(r4)
            if (r3 != 0) goto L_0x0067
            com.mbridge.msdk.b.b r3 = com.mbridge.msdk.b.b.a()
            com.mbridge.msdk.b.a r3 = r3.b()
        L_0x0067:
            long r3 = r3.v()
            long r3 = r3 * r12
            long r5 = r5 + r3
            int r3 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r3 < 0) goto L_0x0072
            goto L_0x0073
        L_0x0072:
            r10 = r11
        L_0x0073:
            if (r10 == 0) goto L_0x0022
            java.util.List r2 = r2.c()
            if (r2 == 0) goto L_0x0022
            int r3 = r2.size()
            if (r3 <= 0) goto L_0x0022
            r0.addAll(r2)
            goto L_0x0022
        L_0x0085:
            int r14 = r0.size()
            if (r14 <= 0) goto L_0x009a
            java.util.HashSet r14 = new java.util.HashSet
            r14.<init>(r0)
            r0.clear()
            r0.addAll(r14)
            java.lang.String r1 = r0.toString()
        L_0x009a:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.tools.u.j(java.lang.String):java.lang.String");
    }

    public static final String d() {
        return i.a.a.f();
    }
}
