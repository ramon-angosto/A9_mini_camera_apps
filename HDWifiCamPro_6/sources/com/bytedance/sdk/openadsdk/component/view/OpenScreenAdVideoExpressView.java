package com.bytedance.sdk.openadsdk.component.view;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import com.bykv.vk.openvk.component.video.api.a;
import com.bykv.vk.openvk.component.video.api.d.c;
import com.bytedance.sdk.component.adexpress.b.d;
import com.bytedance.sdk.component.adexpress.b.l;
import com.bytedance.sdk.component.adexpress.b.m;
import com.bytedance.sdk.component.utils.l;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.c.c.b.o;
import com.bytedance.sdk.openadsdk.component.f.a;
import com.bytedance.sdk.openadsdk.component.h.b;
import com.bytedance.sdk.openadsdk.core.model.n;
import com.bytedance.sdk.openadsdk.core.nativeexpress.ExpressVideoView;
import com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressVideoView;
import org.json.JSONObject;

public class OpenScreenAdVideoExpressView extends NativeExpressVideoView {
    /* access modifiers changed from: private */
    public static final String t = OpenScreenAdVideoExpressView.class.getSimpleName();
    private final a u;
    private final c.a v;
    private final b w;
    /* access modifiers changed from: private */
    public final Handler x = new Handler(Looper.getMainLooper());
    /* access modifiers changed from: private */
    public final Runnable y = new Runnable() {
        public void run() {
            OpenScreenAdVideoExpressView.this.s();
        }
    };

    public OpenScreenAdVideoExpressView(Context context, n nVar, AdSlot adSlot, String str, a aVar, c.a aVar2, b bVar, com.bytedance.sdk.openadsdk.core.video.nativevideo.b bVar2) {
        super(context, nVar, adSlot, str);
        this.u = aVar;
        this.v = aVar2;
        this.w = bVar;
        ExpressVideoView expressVideoView = getExpressVideoView();
        if (expressVideoView != null) {
            expressVideoView.setVideoPlayCallback(bVar2);
        }
    }

    /* access modifiers changed from: private */
    public void s() {
        c nativeVideoController;
        l.b(t, "sendAdVideoPlayBuffer() called");
        ExpressVideoView expressVideoView = getExpressVideoView();
        if (expressVideoView != null && (nativeVideoController = expressVideoView.getNativeVideoController()) != null) {
            o.a aVar = new o.a();
            aVar.a(nativeVideoController.g());
            aVar.c(nativeVideoController.j());
            aVar.b(nativeVideoController.h());
            aVar.f(nativeVideoController.i());
            com.bytedance.sdk.openadsdk.c.c.a.a.e(nativeVideoController.o(), aVar);
        }
    }

    /* access modifiers changed from: protected */
    public void g() {
        this.l = true;
        super.g();
    }

    public int getDynamicShowType() {
        if (this.s == null) {
            return 1;
        }
        return super.getDynamicShowType();
    }

    public void a(d<? extends View> dVar, m mVar) {
        super.a(dVar, mVar);
        b bVar = this.w;
        if (bVar != null) {
            bVar.a();
        }
    }

    public void a(long j, long j2) {
        super.a(j, j2);
        c.a aVar = this.v;
        if (aVar != null) {
            aVar.a(j, j2);
        }
    }

    public void a_() {
        super.a_();
        l.b(t, "onVideoComplete() called");
        a aVar = this.u;
        if (aVar != null) {
            aVar.a();
        }
    }

    public void a(int i, int i2) {
        super.a(i, i2);
        String str = t;
        l.b(str, "onVideoError() called with: errorCode = [" + i + "], extraCode = [" + i2 + "]");
        a aVar = this.u;
        if (aVar != null) {
            aVar.a(this);
        }
    }

    public void e() {
        l.b(t, "onClickDislike() called");
        super.e();
        b bVar = this.w;
        if (bVar != null) {
            bVar.b();
        }
    }

    public void a(View view, int i, com.bytedance.sdk.component.adexpress.c cVar) {
        if (i == -1 || cVar == null || i != 3) {
            super.a(view, i, cVar);
        } else {
            e();
        }
    }

    public void a() {
        super.a();
        l.b(t, "onSkipVideo() called");
        a aVar = this.u;
        if (aVar != null) {
            aVar.a(this);
        }
    }

    public void b_() {
        super.b_();
        com.bykv.vk.openvk.component.video.api.a n = getExpressVideoView().getNativeVideoController().n();
        if (n != null) {
            n.a((a.C0020a) new a.C0020a() {
                public void a(com.bykv.vk.openvk.component.video.api.a aVar, int i, int i2) {
                }

                public void a(com.bykv.vk.openvk.component.video.api.a aVar, long j, long j2) {
                }

                public void b(com.bykv.vk.openvk.component.video.api.a aVar, int i) {
                }

                public void d(com.bykv.vk.openvk.component.video.api.a aVar) {
                }

                public void e(com.bykv.vk.openvk.component.video.api.a aVar) {
                }

                public void a(com.bykv.vk.openvk.component.video.api.a aVar) {
                    OpenScreenAdVideoExpressView.this.x.removeCallbacks(OpenScreenAdVideoExpressView.this.y);
                }

                public void a(com.bykv.vk.openvk.component.video.api.a aVar, long j) {
                    OpenScreenAdVideoExpressView.this.x.removeCallbacks(OpenScreenAdVideoExpressView.this.y);
                }

                public void b(com.bykv.vk.openvk.component.video.api.a aVar) {
                    OpenScreenAdVideoExpressView.this.x.removeCallbacks(OpenScreenAdVideoExpressView.this.y);
                }

                public void a(com.bykv.vk.openvk.component.video.api.a aVar, com.bykv.vk.openvk.component.video.api.c.a aVar2) {
                    OpenScreenAdVideoExpressView.this.x.removeCallbacks(OpenScreenAdVideoExpressView.this.y);
                }

                public void a(com.bykv.vk.openvk.component.video.api.a aVar, boolean z) {
                    OpenScreenAdVideoExpressView.this.x.removeCallbacks(OpenScreenAdVideoExpressView.this.y);
                }

                public void c(com.bykv.vk.openvk.component.video.api.a aVar) {
                    OpenScreenAdVideoExpressView.this.x.removeCallbacks(OpenScreenAdVideoExpressView.this.y);
                }

                public void a(com.bykv.vk.openvk.component.video.api.a aVar, int i, int i2, int i3) {
                    String h = OpenScreenAdVideoExpressView.t;
                    Log.d(h, "onBufferStart() called with: player = [" + aVar + "], reason = [" + i + "], afterFirstFrame = [" + i2 + "], action = [" + i3 + "]");
                    int g = com.bytedance.sdk.openadsdk.core.m.d().g(String.valueOf(OpenScreenAdVideoExpressView.this.i.aW()));
                    OpenScreenAdVideoExpressView.this.x.removeCallbacks(OpenScreenAdVideoExpressView.this.y);
                    OpenScreenAdVideoExpressView.this.x.postDelayed(OpenScreenAdVideoExpressView.this.y, (long) g);
                }

                public void a(com.bykv.vk.openvk.component.video.api.a aVar, int i) {
                    String h = OpenScreenAdVideoExpressView.t;
                    Log.d(h, "onBufferEnd() called with: player = [" + aVar + "], reason = [" + i + "]");
                    OpenScreenAdVideoExpressView.this.x.removeCallbacks(OpenScreenAdVideoExpressView.this.y);
                }
            });
        }
    }

    /* access modifiers changed from: protected */
    public void a(l.a aVar) {
        super.a(aVar);
        aVar.e(com.bytedance.sdk.openadsdk.component.g.a.b());
    }

    /* access modifiers changed from: protected */
    public int getRenderTimeout() {
        return com.bytedance.sdk.openadsdk.component.g.a.a(this.i, com.bytedance.sdk.openadsdk.core.m.d().e(String.valueOf(this.i.aW())));
    }

    /* access modifiers changed from: protected */
    public void a(JSONObject jSONObject) {
        super.a(jSONObject);
        com.bytedance.sdk.openadsdk.component.g.a.a(jSONObject, this.i.aW());
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.x.removeCallbacksAndMessages((Object) null);
    }
}
