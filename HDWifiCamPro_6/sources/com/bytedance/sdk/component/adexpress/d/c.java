package com.bytedance.sdk.component.adexpress.d;

import android.webkit.JavascriptInterface;
import java.lang.ref.WeakReference;

/* compiled from: TTAndroidObjectProxy */
public class c {
    private WeakReference<b> a;

    public c(b bVar) {
        this.a = new WeakReference<>(bVar);
    }

    public void a(b bVar) {
        this.a = new WeakReference<>(bVar);
    }

    @JavascriptInterface
    public String adInfo() {
        WeakReference<b> weakReference = this.a;
        return (weakReference == null || weakReference.get() == null) ? "" : ((b) this.a.get()).adInfo();
    }

    @JavascriptInterface
    public String appInfo() {
        WeakReference<b> weakReference = this.a;
        return (weakReference == null || weakReference.get() == null) ? "" : ((b) this.a.get()).appInfo();
    }

    @JavascriptInterface
    public String getTemplateInfo() {
        WeakReference<b> weakReference = this.a;
        return (weakReference == null || weakReference.get() == null) ? "" : ((b) this.a.get()).getTemplateInfo();
    }

    @JavascriptInterface
    public void renderDidFinish(String str) {
        WeakReference<b> weakReference = this.a;
        if (weakReference != null && weakReference.get() != null) {
            ((b) this.a.get()).renderDidFinish(str);
        }
    }

    @JavascriptInterface
    public void adAnalysisData(String str) {
        WeakReference<b> weakReference = this.a;
        if (weakReference != null && weakReference.get() != null) {
            ((b) this.a.get()).a(str);
        }
    }

    @JavascriptInterface
    public void muteVideo(String str) {
        WeakReference<b> weakReference = this.a;
        if (weakReference != null && weakReference.get() != null) {
            ((b) this.a.get()).muteVideo(str);
        }
    }

    @JavascriptInterface
    public void dynamicTrack(String str) {
        WeakReference<b> weakReference = this.a;
        if (weakReference != null && weakReference.get() != null) {
            ((b) this.a.get()).dynamicTrack(str);
        }
    }

    @JavascriptInterface
    public void changeVideoState(String str) {
        WeakReference<b> weakReference = this.a;
        if (weakReference != null && weakReference.get() != null) {
            ((b) this.a.get()).changeVideoState(str);
        }
    }

    @JavascriptInterface
    public void clickEvent(String str) {
        WeakReference<b> weakReference = this.a;
        if (weakReference != null && weakReference.get() != null) {
            ((b) this.a.get()).clickEvent(str);
        }
    }

    @JavascriptInterface
    public void skipVideo() {
        WeakReference<b> weakReference = this.a;
        if (weakReference != null && weakReference.get() != null) {
            ((b) this.a.get()).skipVideo();
        }
    }

    @JavascriptInterface
    public String getCurrentVideoState() {
        WeakReference<b> weakReference = this.a;
        return (weakReference == null || weakReference.get() == null) ? "" : ((b) this.a.get()).getCurrentVideoState();
    }

    @JavascriptInterface
    public void initRenderFinish() {
        WeakReference<b> weakReference = this.a;
        if (weakReference != null && weakReference.get() != null) {
            ((b) this.a.get()).initRenderFinish();
        }
    }

    @JavascriptInterface
    public void requestPauseVideo(String str) {
        WeakReference<b> weakReference = this.a;
        if (weakReference != null && weakReference.get() != null) {
            ((b) this.a.get()).b(str);
        }
    }
}
