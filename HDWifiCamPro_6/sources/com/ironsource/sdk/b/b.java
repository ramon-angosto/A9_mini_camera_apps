package com.ironsource.sdk.b;

import android.os.Build;
import android.util.Log;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import com.ironsource.environment.e.a;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSchemeDataSource;
import org.json.JSONException;
import org.json.JSONObject;

public class b {
    public a a;
    public d b = new d();
    public WebView c;
    public String d;
    public String e = b.class.getSimpleName();
    private String[] f = {"handleGetViewVisibility"};
    private final String[] g = {"loadWithUrl", "updateAd", "isExternalAdViewInitiated", "handleGetViewVisibility", "sendMessage"};

    private static String d(String str) {
        return String.format("window.ssa.onMessageReceived(%1$s)", new Object[]{str});
    }

    private void e(final String str) {
        final String str2 = "javascript:try{" + str + "}catch(e){console.log(\"JS exception: \" + JSON.stringify(e));}";
        a.a.a(new Runnable() {
            public final void run() {
                try {
                    if (Build.VERSION.SDK_INT >= 19) {
                        b.this.c.evaluateJavascript(str2, (ValueCallback) null);
                    } else {
                        b.this.c.loadUrl(str2);
                    }
                } catch (Throwable unused) {
                    String a2 = b.this.e;
                    Log.e(a2, "injectJavaScriptIntoWebView | Error while trying inject JS into external adUnit: " + str + "Android API level: " + Build.VERSION.SDK_INT);
                }
            }
        });
    }

    public final JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("visibilityParams", this.b.a());
            jSONObject.put("configs", jSONObject2);
            jSONObject.put("adViewId", this.d);
            return jSONObject;
        } catch (JSONException e2) {
            e2.printStackTrace();
            return new JSONObject();
        }
    }

    public JSONObject a(JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("id", jSONObject.getString("id"));
            jSONObject2.put(DataSchemeDataSource.SCHEME_DATA, this.b.a());
        } catch (Exception e2) {
            String str = this.e;
            Log.e(str, "Error while trying execute method buildVisibilityMessageForAdUnit | params: " + jSONObject);
            e2.printStackTrace();
        }
        return jSONObject2;
    }

    public final void a(String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("adViewId", this.d);
            a(str, jSONObject);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public final void a(String str, int i, boolean z) {
        d dVar = this.b;
        boolean z2 = true;
        if (dVar.a.containsKey(str)) {
            dVar.a.put(str, Boolean.valueOf(i == 0));
        }
        dVar.a.put("isShown", Boolean.valueOf(z));
        if ((!dVar.a.get("isWindowVisible").booleanValue() && !dVar.a.get("isVisible").booleanValue()) || !dVar.a.get("isShown").booleanValue()) {
            z2 = false;
        }
        dVar.a.put("isViewVisible", Boolean.valueOf(z2));
        if ((Build.VERSION.SDK_INT <= 22 ? str.equalsIgnoreCase("isWindowVisible") : str.equalsIgnoreCase("isVisible")) && this.a != null && this.b != null) {
            a("containerIsVisible", a());
        }
    }

    public final void a(String str, String str2) {
        a aVar = this.a;
        if (aVar != null) {
            aVar.a(str, str2, this.d);
        }
    }

    public final void a(String str, String str2, String str3) {
        if (this.c == null) {
            String str4 = "No external adUnit attached to ISNAdView while trying to send message: " + str;
            Log.e(this.e, str4);
            this.a.a(str3, str4, this.d);
            return;
        }
        try {
            new JSONObject(str);
        } catch (JSONException unused) {
            str = "\"" + str + "\"";
        }
        e(d(str));
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("adViewId", this.d);
        a(str2, jSONObject);
    }

    public final void a(String str, JSONObject jSONObject) {
        a aVar = this.a;
        if (aVar != null) {
            aVar.a(str, jSONObject);
        }
    }

    public final void b(String str) {
        JSONObject a2 = this.b.a();
        a2.put("adViewId", this.d);
        a(str, a2);
    }

    public boolean c(String str) {
        for (String equalsIgnoreCase : this.f) {
            if (equalsIgnoreCase.equalsIgnoreCase(str)) {
                return true;
            }
        }
        return false;
    }
}
