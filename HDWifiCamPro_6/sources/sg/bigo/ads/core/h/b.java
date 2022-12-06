package sg.bigo.ads.core.h;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.Build;
import android.os.SystemClock;
import android.webkit.JavascriptInterface;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import sg.bigo.ads.api.a.e;

public class b extends e {
    private final a a = new a(this, this.c);
    boolean b = false;
    public final C0140b c = new C0140b();
    public c d;
    private c f;

    static class a {
        private final b a;
        private final C0140b b;

        public a(b bVar, C0140b bVar2) {
            this.a = bVar;
            this.b = bVar2;
        }

        @JavascriptInterface
        public final void onCustomJSEventCallback(String str, String str2) {
            sg.bigo.ads.common.k.a.a(0, 3, "UniversalWebView", "onCustomJSEventCallback, eventType: " + str + ", eventJson: " + str2);
            c customWebChromeClient = this.a.getCustomWebChromeClient();
            if (customWebChromeClient != null) {
                customWebChromeClient.a(this.a, str, str2);
            }
        }

        @JavascriptInterface
        public final void webCollect(String str) {
            String str2;
            C0140b bVar = this.b;
            if (bVar.a == null) {
                bVar.a = new ArrayList();
            }
            if (str.contains("notify") && !str.startsWith("[")) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    jSONObject.put("cur", SystemClock.elapsedRealtime());
                    str2 = jSONObject.toString();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                bVar.a.add(str2);
                sg.bigo.ads.common.k.a.a(0, 3, "UniversalWebView", "webCollect: ".concat(String.valueOf(str)));
            }
            str2 = str;
            bVar.a.add(str2);
            sg.bigo.ads.common.k.a.a(0, 3, "UniversalWebView", "webCollect: ".concat(String.valueOf(str)));
        }

        @JavascriptInterface
        public final void webStat(String str, String str2) {
            sg.bigo.ads.common.k.a.a(0, 3, "UniversalWebView", "statUniversalInfo, eventId: " + str + ", msgJson: " + str2);
        }
    }

    /* renamed from: sg.bigo.ads.core.h.b$b  reason: collision with other inner class name */
    public static class C0140b {
        List<String> a;
        List<String> b;
        public Boolean c;
        public Boolean d;
        public long e = -1;
        public long f = -1;
        public long g = -1;

        /* access modifiers changed from: package-private */
        public final boolean a(String str) {
            List<String> list = this.b;
            if (!(str == null || list == null)) {
                for (String equals : list) {
                    if (str.equals(equals)) {
                        return true;
                    }
                }
            }
            return false;
        }
    }

    public final class c {
        private Boolean b;

        private c() {
        }

        public /* synthetic */ c(b bVar, byte b2) {
            this();
        }

        private static boolean a(int[] iArr) {
            if (iArr.length <= 0) {
                return false;
            }
            int length = iArr.length;
            int i = length - 1;
            int i2 = 0;
            while (true) {
                int i3 = length / 2;
                if (i2 >= i3 || i < i3) {
                    return true;
                }
                if (iArr[i2] != iArr[i]) {
                    return false;
                }
                i2++;
                i--;
            }
        }

        public final Boolean a() {
            sg.bigo.ads.common.k.a.a(0, 3, "UniversalWebView", "Try to check not blank by bit");
            if (this.b != null) {
                sg.bigo.ads.common.k.a.a(0, 3, "UniversalWebView", "Has result for checking not blank by bit");
                return this.b;
            } else if (b.this.e) {
                sg.bigo.ads.common.k.a.a(0, 3, "UniversalWebView", "WebView is destroyed stop checking not blank by bit");
                return null;
            } else {
                int width = b.this.getWidth();
                int height = b.this.getHeight();
                if (width > 0 && height > 0) {
                    try {
                        int[] iArr = new int[(width * height)];
                        Bitmap createBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.RGB_565);
                        b.this.draw(new Canvas(createBitmap));
                        createBitmap.getPixels(iArr, 0, width, 0, 0, width, height);
                        createBitmap.recycle();
                        this.b = Boolean.valueOf(!a(iArr));
                        sg.bigo.ads.common.k.a.a(0, 3, "UniversalWebView", "The result of current banner checking not blank by bit: " + this.b);
                        return this.b;
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                return null;
            }
        }
    }

    public b(Context context) {
        super(context);
        addJavascriptInterface(this.a, "bigossp");
    }

    public static void a(C0140b bVar) {
        List<String> list;
        JSONObject optJSONObject;
        if (e.a.h().a(0) && (list = bVar.a) != null && !list.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            for (String next : list) {
                if (next.startsWith("[")) {
                    sb.append(next.substring(1, next.length() - 1));
                    sb.append(",");
                }
                sb.append(next);
                sb.append(",");
            }
            try {
                JSONArray jSONArray = new JSONArray();
                JSONArray jSONArray2 = new JSONArray("[" + sb.substring(0, sb.length() - 1) + "]");
                int length = jSONArray2.length();
                JSONObject jSONObject = null;
                JSONObject jSONObject2 = null;
                for (int i = 0; i < length; i++) {
                    JSONObject optJSONObject2 = jSONArray2.optJSONObject(i);
                    if (optJSONObject2 != null) {
                        String optString = optJSONObject2.optString("type");
                        if ("render_start".equals(optString)) {
                            jSONObject = optJSONObject2;
                        }
                        if ("render".equals(optString) && jSONObject2 == null) {
                            jSONObject2 = optJSONObject2;
                        }
                        if (!"mayError".equals(optString) || ((optJSONObject = optJSONObject2.optJSONObject("params")) != null && bVar.a(optJSONObject.optString("url")))) {
                            jSONArray.put(optJSONObject2);
                        }
                    }
                }
                if (jSONArray.length() > 0) {
                    sg.bigo.ads.core.d.a.a((sg.bigo.ads.api.core.c) null, (int) IronSourceConstants.BN_INSTANCE_LOAD, 10113, jSONArray.toString());
                }
                if (jSONObject == null) {
                    return;
                }
                if (jSONObject2 != null) {
                    bVar.c = Boolean.TRUE;
                    bVar.e = jSONObject2.optLong("cur");
                    return;
                }
                bVar.c = Boolean.FALSE;
                bVar.e = SystemClock.elapsedRealtime();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(int i, WebResourceRequest webResourceRequest, int i2, CharSequence charSequence) {
        if (webResourceRequest != null && Build.VERSION.SDK_INT >= 21) {
            sg.bigo.ads.common.k.a.a(0, 3, "UniversalWebView", "dispatchResourceError, type: " + i + ", url: " + webResourceRequest.getUrl() + ", errorCode: " + i2 + ", desc: " + charSequence);
            C0140b bVar = this.c;
            String valueOf = String.valueOf(webResourceRequest.getUrl());
            if (bVar.b == null) {
                bVar.b = new ArrayList();
            }
            bVar.b.add(valueOf);
        }
    }

    public c getCustomWebChromeClient() {
        return this.f;
    }

    public void setWebChromeClient(WebChromeClient webChromeClient) {
        this.f = webChromeClient instanceof c ? (c) webChromeClient : null;
        super.setWebChromeClient(webChromeClient);
    }
}
