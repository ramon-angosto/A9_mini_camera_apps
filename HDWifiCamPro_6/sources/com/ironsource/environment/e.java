package com.ironsource.environment;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import androidx.browser.trusted.sharing.ShareTarget;
import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import com.ironsource.mediationsdk.config.VersionInfo;
import java.io.DataOutputStream;
import java.lang.Thread;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

public final class e {
    public static String c = "";
    Context a;
    String b;
    /* access modifiers changed from: private */
    public JSONObject d;
    /* access modifiers changed from: private */
    public String e;
    private String f;
    /* access modifiers changed from: private */
    public boolean g;
    private Thread.UncaughtExceptionHandler h;
    /* access modifiers changed from: private */
    public String i;

    static class a {
        static volatile e a = new e((byte) 0);
    }

    private e() {
        this.g = false;
        this.d = new JSONObject();
        this.h = Thread.getDefaultUncaughtExceptionHandler();
        this.b = " ";
        this.i = "https://outcome-crash-report.supersonicads.com/reporter";
        Thread.setDefaultUncaughtExceptionHandler(new d(this.h));
    }

    /* synthetic */ e(byte b2) {
        this();
    }

    public static e a() {
        return a.a;
    }

    private static String a(Context context) {
        ConnectivityManager connectivityManager;
        if (context == null || (connectivityManager = (ConnectivityManager) context.getSystemService("connectivity")) == null) {
            return "none";
        }
        try {
            if (Build.VERSION.SDK_INT >= 23) {
                NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(connectivityManager.getActiveNetwork());
                if (networkCapabilities == null) {
                    return "none";
                }
                if (networkCapabilities.hasTransport(1)) {
                    return "wifi";
                }
                if (networkCapabilities.hasTransport(0)) {
                    return "cellular";
                }
            } else {
                NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
                    if (activeNetworkInfo.getTypeName().equalsIgnoreCase("WIFI")) {
                        return "wifi";
                    }
                    if (activeNetworkInfo.getTypeName().equalsIgnoreCase("MOBILE")) {
                        return "cellular";
                    }
                }
            }
            return "none";
        } catch (Exception e2) {
            e2.printStackTrace();
            return "none";
        }
    }

    public final void a(final Context context, HashSet<String> hashSet, String str, String str2, boolean z, final String str3, int i2, boolean z2) {
        if (context != null) {
            Log.d("automation_log", "init ISCrashReporter");
            this.a = context;
            if (!TextUtils.isEmpty(str2)) {
                this.b = str2;
            }
            if (!TextUtils.isEmpty(str)) {
                this.i = str;
            }
            this.f = str3;
            if (z) {
                a aVar = new a(i2);
                aVar.c = z2;
                aVar.b = true;
                aVar.a = new b() {
                    public final void a() {
                        Map<Thread, StackTraceElement[]> allStackTraces = Thread.getAllStackTraces();
                        StringBuilder sb = new StringBuilder(128);
                        for (Thread next : allStackTraces.keySet()) {
                            StackTraceElement[] stackTrace = next.getStackTrace();
                            if (stackTrace != null && stackTrace.length > 0) {
                                sb.append("*** Thread Name ");
                                sb.append(next.getName());
                                sb.append(" Thread ID ");
                                sb.append(next.getId());
                                sb.append(" (");
                                sb.append(next.getState().toString());
                                sb.append(") ***\n");
                                for (StackTraceElement stackTraceElement : stackTrace) {
                                    sb.append(stackTraceElement.toString());
                                    sb.append(" ");
                                    sb.append(next.getState().toString());
                                    sb.append("\n");
                                }
                            }
                        }
                        e.c = sb.toString();
                    }

                    public final void b() {
                    }
                };
                aVar.start();
            }
            String a2 = a(this.a);
            if (!a2.equals("none")) {
                SharedPreferences sharedPreferences = context.getSharedPreferences("CRep", 0);
                String string = sharedPreferences.getString("String1", this.e);
                String string2 = sharedPreferences.getString("sId", this.f);
                new StringBuilder();
                for (c next : f.a()) {
                    String b2 = next.b();
                    String a3 = next.a();
                    String c2 = next.c();
                    String packageName = context.getPackageName();
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("crashDate", b2);
                        jSONObject.put("stacktraceCrash", a3);
                        jSONObject.put("crashType", c2);
                        jSONObject.put("CrashReporterVersion", "1.0.5");
                        jSONObject.put("SDKVersion", VersionInfo.VERSION);
                        jSONObject.put("deviceLanguage", h.a(context));
                        jSONObject.put("appVersion", c.c(context, packageName));
                        jSONObject.put("deviceOSVersion", h.e());
                        jSONObject.put("network", a2);
                        jSONObject.put("deviceApiLevel", h.f());
                        jSONObject.put("deviceModel", h.g());
                        jSONObject.put("deviceOS", h.i());
                        jSONObject.put("advertisingId", string);
                        jSONObject.put("isLimitAdTrackingEnabled", this.g);
                        jSONObject.put("deviceOEM", h.h());
                        jSONObject.put("systemProperties", System.getProperties());
                        jSONObject.put("bundleId", packageName);
                        jSONObject.put("sId", string2);
                        JSONObject jSONObject2 = new JSONObject();
                        if (hashSet == null || hashSet.isEmpty()) {
                            jSONObject2 = jSONObject;
                        } else {
                            Iterator<String> it = hashSet.iterator();
                            while (it.hasNext()) {
                                String next2 = it.next();
                                try {
                                    if (jSONObject.has(next2)) {
                                        jSONObject2.put(next2, jSONObject.opt(next2));
                                    }
                                } catch (Exception e2) {
                                    e2.printStackTrace();
                                }
                            }
                        }
                        this.d = jSONObject2;
                    } catch (Exception unused) {
                    }
                    if (this.d.length() == 0) {
                        Log.d("ISCrashReport", " Is Empty");
                    } else {
                        new Thread(new Runnable() {
                            public final void run() {
                                try {
                                    HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(e.a().i).openConnection();
                                    httpURLConnection.setRequestMethod(ShareTarget.METHOD_POST);
                                    httpURLConnection.setRequestProperty(HttpHeaders.CONTENT_TYPE, "application/json;charset=UTF-8");
                                    httpURLConnection.setRequestProperty("Accept", "application/json");
                                    httpURLConnection.setDoOutput(true);
                                    httpURLConnection.setDoInput(true);
                                    Log.i("JSON", e.this.d.toString());
                                    DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
                                    dataOutputStream.writeBytes(e.this.d.toString());
                                    dataOutputStream.flush();
                                    dataOutputStream.close();
                                    Log.i("STATUS", String.valueOf(httpURLConnection.getResponseCode()));
                                    Log.i("MSG", httpURLConnection.getResponseMessage());
                                    httpURLConnection.disconnect();
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }
                        }).start();
                        f.c();
                    }
                }
            }
            new Thread(new Runnable() {
                public final void run() {
                    try {
                        String[] C = h.C(context);
                        if (C != null && C.length == 2) {
                            if (!TextUtils.isEmpty(C[0])) {
                                String unused = e.this.e = C[0];
                            }
                            boolean unused2 = e.this.g = Boolean.parseBoolean(C[1]);
                            SharedPreferences.Editor edit = context.getSharedPreferences("CRep", 0).edit();
                            edit.putString("String1", e.this.e);
                            edit.putString("sId", str3);
                            edit.apply();
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
    }
}
