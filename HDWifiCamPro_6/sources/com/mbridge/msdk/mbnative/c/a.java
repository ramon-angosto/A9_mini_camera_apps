package com.mbridge.msdk.mbnative.c;

import android.content.Context;
import android.text.TextUtils;
import com.mbridge.msdk.out.Campaign;
import com.mbridge.msdk.out.Frame;
import com.mbridge.msdk.out.NativeListener;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: AdListenerProxy */
public class a implements NativeListener.NativeAdListener {
    private static final String a = a.class.getSimpleName();
    private NativeListener.NativeAdListener b;
    private boolean c = false;
    private String d;
    private Context e;
    private boolean f;

    public final void a(boolean z) {
        this.f = z;
    }

    public final void a(String str) {
        this.d = str;
    }

    public a() {
    }

    public a(NativeListener.NativeAdListener nativeAdListener) {
        this.b = nativeAdListener;
    }

    public final boolean a() {
        return this.c;
    }

    public final void b() {
        this.c = true;
    }

    public void onAdLoaded(List<Campaign> list, int i) {
        CopyOnWriteArrayList copyOnWriteArrayList;
        try {
            this.c = false;
            synchronized (list) {
                copyOnWriteArrayList = new CopyOnWriteArrayList(list);
            }
            if (this.b == null) {
                return;
            }
            if (copyOnWriteArrayList.size() > 0) {
                this.b.onAdLoaded(copyOnWriteArrayList, i);
            } else {
                this.b.onAdLoaded(list, i);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void onAdLoadError(String str) {
        this.c = false;
        NativeListener.NativeAdListener nativeAdListener = this.b;
        if (nativeAdListener != null) {
            nativeAdListener.onAdLoadError(str);
            if (this.e == null) {
                this.e = com.mbridge.msdk.foundation.controller.a.e().g();
            }
            if (!TextUtils.isEmpty(this.d)) {
                com.mbridge.msdk.mbnative.d.a.a(this.e, str, this.d, this.f);
            }
        }
    }

    public void onAdClick(Campaign campaign) {
        NativeListener.NativeAdListener nativeAdListener = this.b;
        if (nativeAdListener != null) {
            nativeAdListener.onAdClick(campaign);
        }
    }

    public void onAdFramesLoaded(List<Frame> list) {
        NativeListener.NativeAdListener nativeAdListener = this.b;
        if (nativeAdListener != null) {
            nativeAdListener.onAdFramesLoaded(list);
        }
    }

    public void onLoggingImpression(int i) {
        NativeListener.NativeAdListener nativeAdListener = this.b;
        if (nativeAdListener != null) {
            nativeAdListener.onLoggingImpression(i);
        }
    }
}
