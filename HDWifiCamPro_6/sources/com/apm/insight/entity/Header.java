package com.apm.insight.entity;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.apm.insight.h;
import com.apm.insight.l.p;
import com.apm.insight.l.q;
import com.apm.insight.runtime.s;
import com.vungle.warren.model.ReportDBAdapter;
import java.util.Iterator;
import java.util.Locale;
import java.util.TimeZone;
import org.json.JSONException;
import org.json.JSONObject;

public final class Header {
    private static final String[] a = {"version_code", "manifest_version_code", "aid", "update_version_code"};
    private static String d = null;
    private static int e = -1;
    private static int f = -1;
    private Context b;
    private JSONObject c = new JSONObject();

    public Header(Context context) {
        this.b = context;
    }

    public static Header a(Context context) {
        Header header = new Header(context);
        header.e(header.f());
        return header;
    }

    public static Header a(Context context, long j) {
        Header header;
        s a2 = s.a();
        if (j == 0) {
            j = System.currentTimeMillis();
        }
        JSONObject a3 = a2.a(j);
        if (a3 == null || a3.length() == 0) {
            header = a(h.g());
            header.c();
            try {
                header.f().put("errHeader", 1);
            } catch (Throwable unused) {
            }
        } else {
            header = new Header(h.g());
        }
        b(header);
        header.a(a3);
        return header;
    }

    public static Header a(Header header) {
        addRuntimeHeader(header.f());
        return header;
    }

    public static boolean a() {
        if (e == -1) {
            e = g().contains("64") ? 1 : 0;
        }
        return e == 1;
    }

    public static void addOtherHeader(JSONObject jSONObject) {
        if (jSONObject != null) {
            h(jSONObject);
            f(jSONObject);
            g(jSONObject);
            try {
                jSONObject.put("os", "Android");
                jSONObject.put("device_id", h.c().a());
                jSONObject.put("os_version", h());
                jSONObject.put("os_api", Build.VERSION.SDK_INT);
                String str = Build.MODEL;
                String str2 = Build.BRAND;
                if (str == null) {
                    str = str2;
                } else if (str2 != null && !str.contains(str2)) {
                    str = str2 + ' ' + str;
                }
                jSONObject.put("device_model", str);
                jSONObject.put("device_brand", Build.BRAND);
                jSONObject.put("device_manufacturer", Build.MANUFACTURER);
                jSONObject.put("cpu_abi", g());
                Context g = h.g();
                String packageName = g.getPackageName();
                jSONObject.put("package", packageName);
                PackageInfo packageInfo = g.getPackageManager().getPackageInfo(packageName, 0);
                if (packageInfo.applicationInfo != null) {
                    int i = packageInfo.applicationInfo.labelRes;
                    jSONObject.put("display_name", i > 0 ? g.getString(i) : g.getPackageManager().getApplicationLabel(packageInfo.applicationInfo));
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
            d.a(jSONObject);
        }
    }

    public static void addRuntimeHeader(JSONObject jSONObject) {
        i(jSONObject);
        j(jSONObject);
    }

    public static Header b(Context context) {
        Header a2 = a(context);
        a(a2);
        b(a2);
        a2.c();
        a2.d();
        a2.e();
        return a2;
    }

    public static void b(Header header) {
        if (header != null) {
            addOtherHeader(header.f());
        }
    }

    public static boolean b() {
        if (f == -1) {
            f = g().contains("86") ? 1 : 0;
        }
        return f == 1;
    }

    public static boolean b(JSONObject jSONObject) {
        return jSONObject.optInt("unauthentic_version", 0) == 1;
    }

    public static boolean c(JSONObject jSONObject) {
        return jSONObject == null || jSONObject.length() == 0 || (jSONObject.opt("app_version") == null && jSONObject.opt("version_name") == null) || jSONObject.opt("version_code") == null || jSONObject.opt("update_version_code") == null;
    }

    public static boolean d(JSONObject jSONObject) {
        if (!(jSONObject == null || jSONObject.length() == 0)) {
            String optString = jSONObject.optString("aid");
            if (TextUtils.isEmpty(optString)) {
                return true;
            }
            try {
                return Integer.parseInt(optString) <= 0;
            } catch (Throwable unused) {
            }
        }
        return true;
    }

    private void e(JSONObject jSONObject) {
        try {
            jSONObject.put("sdk_version", 1030827);
            jSONObject.put("sdk_version_name", "1.3.8.nourl-alpha.7");
        } catch (Exception unused) {
        }
    }

    private static void f(JSONObject jSONObject) {
        try {
            DisplayMetrics displayMetrics = h.g().getResources().getDisplayMetrics();
            int i = displayMetrics.densityDpi;
            String str = i != 120 ? i != 240 ? i != 320 ? "mdpi" : "xhdpi" : "hdpi" : "ldpi";
            jSONObject.put("density_dpi", i);
            jSONObject.put("display_density", str);
            jSONObject.put("resolution", displayMetrics.heightPixels + "x" + displayMetrics.widthPixels);
        } catch (Exception unused) {
        }
    }

    private static String g() {
        if (d == null) {
            try {
                StringBuilder sb = new StringBuilder();
                if (Build.VERSION.SDK_INT < 21 || Build.SUPPORTED_ABIS.length <= 0) {
                    sb = new StringBuilder(Build.CPU_ABI);
                } else {
                    for (int i = 0; i < Build.SUPPORTED_ABIS.length; i++) {
                        sb.append(Build.SUPPORTED_ABIS[i]);
                        if (i != Build.SUPPORTED_ABIS.length - 1) {
                            sb.append(", ");
                        }
                    }
                }
                if (TextUtils.isEmpty(sb.toString())) {
                    d = "unknown";
                }
                d = sb.toString();
            } catch (Exception e2) {
                q.b((Throwable) e2);
                d = "unknown";
            }
        }
        return d;
    }

    private static void g(JSONObject jSONObject) {
        try {
            String language = h.g().getResources().getConfiguration().locale.getLanguage();
            if (!TextUtils.isEmpty(language)) {
                jSONObject.put("language", language);
            }
            String country = Locale.getDefault().getCountry();
            if (!TextUtils.isEmpty(country)) {
                jSONObject.put(TtmlNode.TAG_REGION, country);
            }
            int rawOffset = TimeZone.getDefault().getRawOffset() / 3600000;
            if (rawOffset < -12) {
                rawOffset = -12;
            }
            if (rawOffset > 12) {
                rawOffset = 12;
            }
            jSONObject.put("timezone", rawOffset);
        } catch (Exception unused) {
        }
    }

    private static String h() {
        String str = Build.VERSION.RELEASE;
        if (str.contains(".")) {
            return str;
        }
        return str + ".0";
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0040 A[Catch:{ all -> 0x0052 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void h(org.json.JSONObject r3) {
        /*
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            boolean r1 = com.apm.insight.l.d.c()     // Catch:{ all -> 0x0052 }
            if (r1 == 0) goto L_0x0011
            java.lang.String r1 = "MIUI-"
        L_0x000d:
            r0.append(r1)     // Catch:{ all -> 0x0052 }
            goto L_0x0035
        L_0x0011:
            boolean r1 = com.apm.insight.l.d.d()     // Catch:{ all -> 0x0052 }
            if (r1 == 0) goto L_0x001a
            java.lang.String r1 = "FLYME-"
            goto L_0x000d
        L_0x001a:
            java.lang.String r1 = com.apm.insight.l.d.a()     // Catch:{ all -> 0x0052 }
            boolean r2 = com.apm.insight.l.d.a(r1)     // Catch:{ all -> 0x0052 }
            if (r2 == 0) goto L_0x0029
            java.lang.String r2 = "EMUI-"
            r0.append(r2)     // Catch:{ all -> 0x0052 }
        L_0x0029:
            boolean r2 = android.text.TextUtils.isEmpty(r1)     // Catch:{ all -> 0x0052 }
            if (r2 != 0) goto L_0x0035
            r0.append(r1)     // Catch:{ all -> 0x0052 }
            java.lang.String r1 = "-"
            goto L_0x000d
        L_0x0035:
            java.lang.String r1 = android.os.Build.VERSION.INCREMENTAL     // Catch:{ all -> 0x0052 }
            r0.append(r1)     // Catch:{ all -> 0x0052 }
            int r1 = r0.length()     // Catch:{ all -> 0x0052 }
            if (r1 <= 0) goto L_0x0049
            java.lang.String r1 = "rom"
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0052 }
            r3.put(r1, r0)     // Catch:{ all -> 0x0052 }
        L_0x0049:
            java.lang.String r0 = "rom_version"
            java.lang.String r1 = com.apm.insight.l.t.a()     // Catch:{ all -> 0x0052 }
            r3.put(r0, r1)     // Catch:{ all -> 0x0052 }
        L_0x0052:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.apm.insight.entity.Header.h(org.json.JSONObject):void");
    }

    private static void i(JSONObject jSONObject) {
        try {
            jSONObject.put("access", p.a(h.g()));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    private static void j(JSONObject jSONObject) {
        try {
            TelephonyManager telephonyManager = (TelephonyManager) h.g().getSystemService("phone");
            if (telephonyManager != null) {
                String networkOperatorName = telephonyManager.getNetworkOperatorName();
                if (!TextUtils.isEmpty(networkOperatorName)) {
                    jSONObject.put("carrier", networkOperatorName);
                }
                String networkOperator = telephonyManager.getNetworkOperator();
                if (!TextUtils.isEmpty(networkOperator)) {
                    jSONObject.put("mcc_mnc", networkOperator);
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:15|16|17|18|41) */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x005f */
    /* JADX WARNING: Missing exception handler attribute for start block: B:26:0x0088 */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x008e A[Catch:{ all -> 0x00b4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00a4 A[Catch:{ all -> 0x00b4 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public org.json.JSONObject a(java.util.Map<java.lang.String, java.lang.Object> r11) {
        /*
            r10 = this;
            java.lang.String r0 = "manifest_version_code"
            java.lang.String r1 = "version_code"
            java.lang.String r2 = "version_name"
            java.lang.String r3 = "iid"
            if (r11 != 0) goto L_0x000d
            org.json.JSONObject r11 = r10.c     // Catch:{ all -> 0x00b4 }
            return r11
        L_0x000d:
            java.util.Set r4 = r11.entrySet()     // Catch:{ all -> 0x00b4 }
            java.util.Iterator r4 = r4.iterator()     // Catch:{ all -> 0x00b4 }
        L_0x0015:
            boolean r5 = r4.hasNext()     // Catch:{ all -> 0x00b4 }
            if (r5 == 0) goto L_0x003f
            java.lang.Object r5 = r4.next()     // Catch:{ all -> 0x00b4 }
            java.util.Map$Entry r5 = (java.util.Map.Entry) r5     // Catch:{ all -> 0x00b4 }
            org.json.JSONObject r6 = r10.c     // Catch:{ all -> 0x00b4 }
            java.lang.Object r7 = r5.getKey()     // Catch:{ all -> 0x00b4 }
            java.lang.String r7 = (java.lang.String) r7     // Catch:{ all -> 0x00b4 }
            boolean r6 = r6.has(r7)     // Catch:{ all -> 0x00b4 }
            if (r6 != 0) goto L_0x0015
            org.json.JSONObject r6 = r10.c     // Catch:{ all -> 0x00b4 }
            java.lang.Object r7 = r5.getKey()     // Catch:{ all -> 0x00b4 }
            java.lang.String r7 = (java.lang.String) r7     // Catch:{ all -> 0x00b4 }
            java.lang.Object r5 = r5.getValue()     // Catch:{ all -> 0x00b4 }
            r6.put(r7, r5)     // Catch:{ all -> 0x00b4 }
            goto L_0x0015
        L_0x003f:
            java.lang.String[] r4 = a     // Catch:{ all -> 0x00b4 }
            int r5 = r4.length     // Catch:{ all -> 0x00b4 }
            r6 = 0
        L_0x0043:
            if (r6 >= r5) goto L_0x006b
            r7 = r4[r6]     // Catch:{ all -> 0x00b4 }
            boolean r8 = r11.containsKey(r7)     // Catch:{ all -> 0x00b4 }
            if (r8 == 0) goto L_0x0068
            java.lang.Object r8 = r11.get(r7)     // Catch:{ all -> 0x005f }
            java.lang.String r8 = java.lang.String.valueOf(r8)     // Catch:{ all -> 0x005f }
            int r8 = java.lang.Integer.parseInt(r8)     // Catch:{ all -> 0x005f }
            org.json.JSONObject r9 = r10.c     // Catch:{ all -> 0x005f }
            r9.put(r7, r8)     // Catch:{ all -> 0x005f }
            goto L_0x0068
        L_0x005f:
            org.json.JSONObject r8 = r10.c     // Catch:{ all -> 0x00b4 }
            java.lang.Object r9 = r11.get(r7)     // Catch:{ all -> 0x00b4 }
            r8.put(r7, r9)     // Catch:{ all -> 0x00b4 }
        L_0x0068:
            int r6 = r6 + 1
            goto L_0x0043
        L_0x006b:
            boolean r4 = r11.containsKey(r1)     // Catch:{ all -> 0x00b4 }
            if (r4 == 0) goto L_0x0088
            boolean r4 = r11.containsKey(r0)     // Catch:{ all -> 0x00b4 }
            if (r4 != 0) goto L_0x0088
            java.lang.Object r1 = r11.get(r1)     // Catch:{ all -> 0x0088 }
            java.lang.String r1 = java.lang.String.valueOf(r1)     // Catch:{ all -> 0x0088 }
            int r1 = java.lang.Integer.parseInt(r1)     // Catch:{ all -> 0x0088 }
            org.json.JSONObject r4 = r10.c     // Catch:{ all -> 0x0088 }
            r4.put(r0, r1)     // Catch:{ all -> 0x0088 }
        L_0x0088:
            boolean r0 = r11.containsKey(r3)     // Catch:{ all -> 0x00b4 }
            if (r0 == 0) goto L_0x009e
            org.json.JSONObject r0 = r10.c     // Catch:{ all -> 0x00b4 }
            java.lang.String r1 = "udid"
            java.lang.Object r4 = r11.get(r3)     // Catch:{ all -> 0x00b4 }
            r0.put(r1, r4)     // Catch:{ all -> 0x00b4 }
            org.json.JSONObject r0 = r10.c     // Catch:{ all -> 0x00b4 }
            r0.remove(r3)     // Catch:{ all -> 0x00b4 }
        L_0x009e:
            boolean r0 = r11.containsKey(r2)     // Catch:{ all -> 0x00b4 }
            if (r0 == 0) goto L_0x00b4
            org.json.JSONObject r0 = r10.c     // Catch:{ all -> 0x00b4 }
            java.lang.String r1 = "app_version"
            java.lang.Object r11 = r11.get(r2)     // Catch:{ all -> 0x00b4 }
            r0.put(r1, r11)     // Catch:{ all -> 0x00b4 }
            org.json.JSONObject r11 = r10.c     // Catch:{ all -> 0x00b4 }
            r11.remove(r2)     // Catch:{ all -> 0x00b4 }
        L_0x00b4:
            org.json.JSONObject r11 = r10.c
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.apm.insight.entity.Header.a(java.util.Map):org.json.JSONObject");
    }

    public JSONObject a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return this.c;
        }
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            try {
                this.c.put(next, jSONObject.opt(next));
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        return this.c;
    }

    public JSONObject c() {
        return a(h.a().a());
    }

    public JSONObject d() {
        try {
            this.c.put("device_id", h.c().a());
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return this.c;
    }

    public JSONObject e() {
        try {
            long f2 = h.a().f();
            if (f2 > 0) {
                this.c.put(ReportDBAdapter.ReportColumns.COLUMN_USER_ID, f2);
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return this.c;
    }

    public JSONObject f() {
        return this.c;
    }
}
