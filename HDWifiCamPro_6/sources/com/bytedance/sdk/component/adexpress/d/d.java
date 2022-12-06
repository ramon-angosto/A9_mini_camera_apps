package com.bytedance.sdk.component.adexpress.d;

import android.webkit.JavascriptInterface;
import com.bytedance.sdk.component.a.z;
import java.lang.ref.WeakReference;

/* compiled from: WebViewBridgeProxy */
public class d {
    private WeakReference<z> a;

    public d(z zVar) {
        this.a = new WeakReference<>(zVar);
    }

    public void a(z zVar) {
        this.a = new WeakReference<>(zVar);
    }

    @JavascriptInterface
    public void invokeMethod(String str) {
        WeakReference<z> weakReference = this.a;
        if (weakReference != null && weakReference.get() != null) {
            ((z) this.a.get()).invokeMethod(str);
        }
    }
}
