package com.bytedance.sdk.openadsdk.core.a;

import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
import com.bytedance.sdk.openadsdk.l.w;
import java.util.List;

/* compiled from: NativeExpressAdListenerAdapter */
public class e implements TTAdNative.NativeExpressAdListener {
    /* access modifiers changed from: private */
    public final TTAdNative.NativeExpressAdListener a;

    public e(TTAdNative.NativeExpressAdListener nativeExpressAdListener) {
        this.a = nativeExpressAdListener;
    }

    public void onError(final int i, final String str) {
        if (this.a != null) {
            if (str == null) {
                str = "Unknown exception.";
            }
            w.a((Runnable) new Runnable() {
                public void run() {
                    e.this.a.onError(i, str);
                }
            });
        }
    }

    public void onNativeExpressAdLoad(final List<TTNativeExpressAd> list) {
        if (this.a != null) {
            w.a((Runnable) new Runnable() {
                public void run() {
                    e.this.a.onNativeExpressAdLoad(list);
                }
            });
        }
    }
}
