package com.bytedance.sdk.openadsdk.core.a;

import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTFeedAd;
import com.bytedance.sdk.openadsdk.l.w;
import java.util.List;

/* compiled from: FeedAdListenerAdapter */
public class c implements TTAdNative.FeedAdListener {
    /* access modifiers changed from: private */
    public TTAdNative.FeedAdListener a = null;

    public c(TTAdNative.FeedAdListener feedAdListener) {
        this.a = feedAdListener;
    }

    public void onError(final int i, final String str) {
        if (this.a != null) {
            if (str == null) {
                str = "Unknown exception.";
            }
            w.a((Runnable) new Runnable() {
                public void run() {
                    c.this.a.onError(i, str);
                }
            });
        }
    }

    public void onFeedAdLoad(final List<TTFeedAd> list) {
        if (this.a != null) {
            w.a((Runnable) new Runnable() {
                public void run() {
                    c.this.a.onFeedAdLoad(list);
                }
            });
        }
    }
}
