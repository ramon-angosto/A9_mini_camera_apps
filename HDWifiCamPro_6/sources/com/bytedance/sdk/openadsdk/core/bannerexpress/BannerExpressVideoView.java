package com.bytedance.sdk.openadsdk.core.bannerexpress;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.api.banner.PAGBannerAdWrapperListener;
import com.bytedance.sdk.openadsdk.core.model.n;
import com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressVideoView;
import com.bytedance.sdk.openadsdk.l.z;
import com.bytedance.sdk.openadsdk.multipro.b.a;

public class BannerExpressVideoView extends BannerExpressView {
    public BannerExpressVideoView(Context context, n nVar, AdSlot adSlot) {
        super(context, nVar, adSlot);
    }

    /* access modifiers changed from: protected */
    public void a() {
        this.b = new NativeExpressVideoView(this.a, this.d, this.e, this.i);
        addView(this.b, new ViewGroup.LayoutParams(-1, -1));
    }

    public void a(n nVar, AdSlot adSlot) {
        this.c = new NativeExpressVideoView(this.a, nVar, adSlot, this.i);
        this.c.setExpressInteractionListener(new PAGBannerAdWrapperListener() {
            public void onAdDismissed() {
            }

            public void onAdShow(View view, int i) {
            }

            public void onRenderFail(View view, String str, int i) {
            }

            public void onAdClicked(View view, int i) {
                if (BannerExpressVideoView.this.f != null) {
                    BannerExpressVideoView.this.f.onAdClicked(BannerExpressVideoView.this, i);
                }
            }

            public void onRenderSuccess(View view, float f, float f2) {
                BannerExpressVideoView.this.a(f, f2);
                BannerExpressVideoView.this.e();
            }
        });
        z.a((View) this.c, 8);
        addView(this.c, new ViewGroup.LayoutParams(-1, -1));
    }

    public a getVideoModel() {
        if (this.b != null) {
            return ((NativeExpressVideoView) this.b).getVideoModel();
        }
        return null;
    }
}
