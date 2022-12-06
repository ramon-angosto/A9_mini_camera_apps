package com.huawei.android.pushselfshow.richpush.html.api;

import android.app.Activity;
import android.webkit.WebView;
import com.huawei.android.pushagent.c.a.e;
import com.huawei.android.pushselfshow.richpush.html.api.d;
import java.util.LinkedList;
import object.p2pipcam.utils.DataBaseHelper;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class NativeToJsMessageQueue {
    public WebView a;
    private final LinkedList b = new LinkedList();
    private final a c;
    /* access modifiers changed from: private */
    public final Activity d;
    private String e;

    private class OnlineEventsBridgeMode implements a {
        boolean a = true;
        final Runnable b = new a(this);

        OnlineEventsBridgeMode() {
            e.a("PushSelfShowLog", "OnlineEventsBridgeMode() the webview is " + NativeToJsMessageQueue.this.a);
            NativeToJsMessageQueue.this.a.setNetworkAvailable(true);
        }

        public void onNativeToJsMessageAvailable() {
            NativeToJsMessageQueue.this.d.runOnUiThread(this.b);
        }
    }

    private interface a {
        void onNativeToJsMessageAvailable();
    }

    private static class b {
        final String a;
        final d b;

        b(d dVar, String str) {
            this.a = str;
            this.b = dVar;
        }

        /* access modifiers changed from: package-private */
        public JSONObject a() {
            if (this.b == null) {
                return null;
            }
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(DataBaseHelper.KEY_TYPE, this.b.a());
                if (this.b.b() != null) {
                    jSONObject.put("message", this.b.b());
                }
                jSONObject.put("callbackId", this.a);
                return jSONObject;
            } catch (JSONException unused) {
                return null;
            }
        }
    }

    public NativeToJsMessageQueue(Activity activity, WebView webView, String str) {
        e.a("PushSelfShowLog", "activity is " + activity);
        e.a("PushSelfShowLog", "webView is " + webView);
        e.a("PushSelfShowLog", "localPath is " + str);
        this.d = activity;
        this.a = webView;
        this.e = str;
        this.c = new OnlineEventsBridgeMode();
        b();
    }

    /* access modifiers changed from: private */
    public boolean d() {
        boolean isEmpty;
        synchronized (this) {
            isEmpty = this.b.isEmpty();
        }
        return isEmpty;
    }

    public String a() {
        return this.e;
    }

    public void a(String str, d.a aVar, String str2, JSONObject jSONObject) {
        try {
            e.a("PushSelfShowLog", "addPluginResult status is " + d.c()[aVar.ordinal()]);
            if (str == null) {
                e.e("JsMessageQueue", "Got plugin result with no callbackId");
                return;
            }
            b bVar = new b(jSONObject == null ? new d(str2, aVar) : new d(str2, aVar, jSONObject), str);
            synchronized (this) {
                this.b.add(bVar);
                if (this.c != null) {
                    this.c.onNativeToJsMessageAvailable();
                }
            }
        } catch (Exception e2) {
            e.d("PushSelfShowLog", "addPluginResult failed", e2);
        }
    }

    public void b() {
        synchronized (this) {
            this.b.clear();
        }
    }

    public String c() {
        synchronized (this) {
            if (this.b.isEmpty()) {
                return null;
            }
            JSONArray jSONArray = new JSONArray();
            int size = this.b.size();
            for (int i = 0; i < size; i++) {
                JSONObject a2 = ((b) this.b.removeFirst()).a();
                if (a2 != null) {
                    jSONArray.put(a2);
                }
            }
            String jSONArray2 = jSONArray.toString();
            return jSONArray2;
        }
    }
}
