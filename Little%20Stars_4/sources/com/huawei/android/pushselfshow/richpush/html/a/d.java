package com.huawei.android.pushselfshow.richpush.html.a;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import com.huawei.android.pushagent.c.a.e;
import com.huawei.android.pushselfshow.richpush.html.api.NativeToJsMessageQueue;
import com.huawei.android.pushselfshow.richpush.html.api.d;
import com.huawei.android.pushselfshow.utils.a;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import org.json.JSONException;
import org.json.JSONObject;

public class d implements h {
    public boolean a = false;
    public int b;
    public int c;
    private NativeToJsMessageQueue d;
    private String e;
    /* access modifiers changed from: private */
    public Activity f;

    public d(Activity activity) {
        e.e("PushSelfShowLog", "init App");
        this.f = activity;
    }

    private void a(String str, String str2, boolean z) {
        NativeToJsMessageQueue nativeToJsMessageQueue;
        String str3;
        d.a aVar;
        try {
            e.a("PushSelfShowLog", "enter launchApp , appPackageName =" + str + ",and msg.intentUri is " + str2 + " boolean appmarket is " + z);
            String str4 = "error";
            if (str != null) {
                if (str.trim().length() != 0) {
                    Intent a2 = a.a((Context) this.f, str);
                    if (a2 != null) {
                        if (str2 != null) {
                            try {
                                Intent parseUri = Intent.parseUri(str2, 0);
                                e.e("PushSelfShowLog", "Intent.parseUri(intentUri, 0)，" + a2.toURI());
                                if (a.a((Context) this.f, str, parseUri).booleanValue()) {
                                    a2 = parseUri;
                                }
                            } catch (Exception e2) {
                                e.a("PushSelfShowLog", "intentUri error ", (Throwable) e2);
                            }
                        }
                        if (this.a) {
                            e.e("PushSelfShowLog", " APP_OPEN startActivityForResult " + a2.toURI());
                            this.f.startActivityForResult(a2, this.b);
                        } else {
                            e.e("PushSelfShowLog", " APP_OPEN start " + a2.toURI());
                            this.f.startActivity(a2);
                        }
                        nativeToJsMessageQueue = this.d;
                        str3 = this.e;
                        aVar = d.a.OK;
                        str4 = "success";
                    } else if (z) {
                        a(str);
                        return;
                    } else {
                        e.e("PushSelfShowLog", "APP_NOT_EXIST and appmaeket is false");
                        nativeToJsMessageQueue = this.d;
                        str3 = this.e;
                        aVar = d.a.APP_NOT_EXIST;
                    }
                    nativeToJsMessageQueue.a(str3, aVar, str4, (JSONObject) null);
                    return;
                }
            }
            this.d.a(this.e, d.a.JSON_EXCEPTION, str4, (JSONObject) null);
        } catch (Exception e3) {
            e.c("PushSelfShowLog", e3.toString(), e3);
        }
    }

    private void a(JSONObject jSONObject) {
        String str;
        boolean z;
        String str2 = null;
        if (jSONObject == null || !jSONObject.has("package-name")) {
            this.d.a(this.e, d.a.JSON_EXCEPTION, "error", (JSONObject) null);
            return;
        }
        try {
            str = jSONObject.getString("package-name");
            try {
                if (jSONObject.has("intent-uri")) {
                    str2 = jSONObject.getString("intent-uri");
                }
                z = jSONObject.has("appmarket") ? jSONObject.getBoolean("appmarket") : false;
            } catch (Exception e2) {
                e = e2;
                z = false;
                e.d("PushSelfShowLog", "openApp param failed ", e);
                e.b("PushSelfShowLog", "packageName is %s , appmarket is %s ,bResult is %s ", str, Boolean.valueOf(z), Boolean.valueOf(this.a));
                a(str, str2, z);
            }
            try {
                if (jSONObject.has("requestCode") && jSONObject.has("resultCode")) {
                    this.b = jSONObject.getInt("requestCode");
                    this.c = jSONObject.getInt("resultCode");
                    this.a = true;
                }
            } catch (Exception e3) {
                e = e3;
                e.d("PushSelfShowLog", "openApp param failed ", e);
                e.b("PushSelfShowLog", "packageName is %s , appmarket is %s ,bResult is %s ", str, Boolean.valueOf(z), Boolean.valueOf(this.a));
                a(str, str2, z);
            }
        } catch (Exception e4) {
            e = e4;
            str = null;
            z = false;
            e.d("PushSelfShowLog", "openApp param failed ", e);
            e.b("PushSelfShowLog", "packageName is %s , appmarket is %s ,bResult is %s ", str, Boolean.valueOf(z), Boolean.valueOf(this.a));
            a(str, str2, z);
        }
        e.b("PushSelfShowLog", "packageName is %s , appmarket is %s ,bResult is %s ", str, Boolean.valueOf(z), Boolean.valueOf(this.a));
        a(str, str2, z);
    }

    private void b(JSONObject jSONObject) {
        NativeToJsMessageQueue nativeToJsMessageQueue;
        d.a aVar;
        String str;
        if (jSONObject == null || !jSONObject.has("package-name")) {
            nativeToJsMessageQueue = this.d;
            str = this.e;
            aVar = d.a.JSON_EXCEPTION;
        } else {
            try {
                String string = jSONObject.getString("package-name");
                JSONObject jSONObject2 = new JSONObject();
                PackageManager packageManager = this.f.getPackageManager();
                PackageInfo packageInfo = packageManager.getPackageInfo(string, 0);
                String obj = packageInfo.applicationInfo.loadLabel(packageManager).toString();
                String str2 = packageInfo.versionName;
                int i = packageInfo.versionCode;
                jSONObject2.put("appName", obj);
                jSONObject2.put("versionCode", i);
                jSONObject2.put("versionName", str2);
                this.d.a(this.e, d.a.OK, "success", jSONObject2);
                return;
            } catch (Exception e2) {
                e.d("PushSelfShowLog", "getAppInfo param failed ", e2);
                nativeToJsMessageQueue = this.d;
                str = this.e;
                aVar = d.a.APP_NOT_EXIST;
            }
        }
        nativeToJsMessageQueue.a(str, aVar, "error", (JSONObject) null);
    }

    private String c(JSONObject jSONObject) throws JSONException {
        JSONObject jSONObject2;
        d.a aVar;
        if (jSONObject == null || !jSONObject.has("package-name")) {
            aVar = d.a.JSON_EXCEPTION;
        } else {
            try {
                String string = jSONObject.getString("package-name");
                PackageManager packageManager = this.f.getPackageManager();
                PackageInfo packageInfo = packageManager.getPackageInfo(string, 0);
                String obj = packageInfo.applicationInfo.loadLabel(packageManager).toString();
                String str = packageInfo.versionName;
                int i = packageInfo.versionCode;
                jSONObject2 = com.huawei.android.pushselfshow.richpush.html.api.d.a(d.a.OK);
                jSONObject2.put("appName", obj);
                jSONObject2.put("versionCode", i);
                jSONObject2.put("versionName", str);
            } catch (Exception e2) {
                e.d("PushSelfShowLog", "getAppInfo param failed ", e2);
                aVar = d.a.APP_NOT_EXIST;
            }
            return jSONObject2.toString();
        }
        jSONObject2 = com.huawei.android.pushselfshow.richpush.html.api.d.a(aVar);
        return jSONObject2.toString();
    }

    public String a(String str, JSONObject jSONObject) {
        try {
            return "getAppInfo".equals(str) ? c(jSONObject) : com.huawei.android.pushselfshow.richpush.html.api.d.a(d.a.METHOD_NOT_FOUND_EXCEPTION).toString();
        } catch (JSONException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public void a(int i, int i2, Intent intent) {
        e.e("PushSelfShowLog", "onActivityResult and requestCode is " + i + " resultCode is " + i2 + " intent data is " + intent);
        try {
            if (this.a && i2 == this.c && intent != null) {
                JSONObject jSONObject = new JSONObject();
                JSONObject jSONObject2 = new JSONObject();
                Bundle extras = intent.getExtras();
                if (extras != null) {
                    for (String str : extras.keySet()) {
                        jSONObject2.put(str, extras.get(str));
                    }
                    if (jSONObject2.length() > 0) {
                        jSONObject.put(PushConstants.EXTRA, jSONObject2);
                        this.d.a(this.e, d.a.OK, "status", jSONObject);
                    }
                }
            }
        } catch (Exception | JSONException unused) {
            e.e("PushSelfShowLog", "onActivityResult error");
        }
    }

    public void a(NativeToJsMessageQueue nativeToJsMessageQueue, String str, String str2, JSONObject jSONObject) {
        if (nativeToJsMessageQueue == null) {
            e.a("PushSelfShowLog", "jsMessageQueue is null while run into App exec");
            return;
        }
        this.d = nativeToJsMessageQueue;
        if ("openApp".equals(str)) {
            d();
            if (str2 != null) {
                this.e = str2;
                a(jSONObject);
                return;
            }
        } else if (!"getAppInfo".equals(str)) {
            nativeToJsMessageQueue.a(str2, d.a.METHOD_NOT_FOUND_EXCEPTION, "error", (JSONObject) null);
            return;
        } else if (str2 != null) {
            this.e = str2;
            b(jSONObject);
            return;
        }
        e.a("PushSelfShowLog", "Audio exec callback is null ");
    }

    public void a(String str) {
        Intent intent;
        NativeToJsMessageQueue nativeToJsMessageQueue;
        String str2;
        d.a aVar;
        String str3;
        if (a.a((Context) this.f, "com.huawei.appmarket", new Intent("com.huawei.appmarket.intent.action.AppDetail")).booleanValue()) {
            e.a("PushSelfShowLog", "app not exist && appmarkt exist ,so open appmarket");
            intent = new Intent("com.huawei.appmarket.intent.action.AppDetail");
            intent.putExtra("APP_PACKAGENAME", str);
            intent.setPackage("com.huawei.appmarket");
            intent.setFlags(402653184);
            e.a("PushSelfShowLog", "hwAppmarket only support com.huawei.appmarket.intent.action.AppDetail!");
        } else if (a.c(this.f).size() > 0) {
            e.a("PushSelfShowLog", "app not exist && other appmarkt exist ,so open appmarket");
            intent = new Intent();
            intent.setAction("android.intent.action.VIEW");
            intent.setData(Uri.parse("market://details?id=" + str));
            intent.setFlags(402653184);
        } else {
            e.a("PushSelfShowLog", "app not exist && other appmarkt not exist ,so do nothing");
            try {
                new e(this).start();
            } catch (Exception unused) {
                e.a("PushSelfShowLog", "show Toast.makeText error");
            }
            intent = null;
        }
        if (intent != null) {
            e.e("PushSelfShowLog", "intent is not null " + intent.toURI());
            this.f.startActivity(intent);
            e.e("PushSelfShowLog", "APP_OPEN_APPMARKET and open with appmaeket");
            nativeToJsMessageQueue = this.d;
            str3 = this.e;
            aVar = d.a.APP_OPEN_APPMARKET;
            str2 = "success";
        } else {
            e.a("PushSelfShowLog", "intent is null ");
            e.e("PushSelfShowLog", "APP_OPEN_APPMARKET and not find any  appmaeket");
            nativeToJsMessageQueue = this.d;
            str3 = this.e;
            aVar = d.a.APP_NOT_APPMARKET;
            str2 = "error";
        }
        nativeToJsMessageQueue.a(str3, aVar, str2, (JSONObject) null);
    }

    public void b() {
    }

    public void c() {
        d();
    }

    public void d() {
        this.e = null;
        this.a = false;
        this.b = 0;
        this.c = 0;
    }
}
