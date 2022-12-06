package com.mbridge.msdk.out;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import com.mbridge.msdk.foundation.b.b;
import com.mbridge.msdk.foundation.tools.u;
import com.mbridge.msdk.mbbanner.a.a;

public class MBBannerView extends RelativeLayout {
    private String bidToken;
    /* access modifiers changed from: private */
    public a controller;
    private boolean hadAttached;
    private boolean isVisible;
    private BannerAdListener mBannerAdListener;
    private MBridgeIds mBridgeIds;

    public MBBannerView(Context context) {
        this(context, (AttributeSet) null);
    }

    public MBBannerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MBBannerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hadAttached = false;
        this.isVisible = false;
        com.mbridge.msdk.foundation.controller.a.e().a(context);
    }

    public void init(BannerSize bannerSize, String str, String str2) {
        this.mBridgeIds = new MBridgeIds(str, str2);
        String d = u.d(str2);
        if (!TextUtils.isEmpty(d)) {
            u.a(str2, d);
        }
        this.controller = new a(this, bannerSize, str, str2);
        this.controller.c(this.isVisible);
        this.controller.b(this.hadAttached);
    }

    public String getRequestId() {
        a aVar = this.controller;
        return aVar != null ? aVar.a() : "";
    }

    public void updateBannerSize(BannerSize bannerSize) {
        a aVar = this.controller;
        if (aVar != null) {
            aVar.a(bannerSize);
        }
    }

    public void setRefreshTime(int i) {
        a aVar = this.controller;
        if (aVar != null && i >= 0) {
            aVar.a(i);
        }
    }

    public void setAllowShowCloseBtn(boolean z) {
        a aVar = this.controller;
        if (aVar != null) {
            aVar.a(z);
        }
    }

    public void load() {
        a aVar = this.controller;
        if (aVar != null) {
            aVar.b(this.hadAttached);
            this.controller.a("");
            return;
        }
        BannerAdListener bannerAdListener = this.mBannerAdListener;
        if (bannerAdListener != null) {
            bannerAdListener.onLoadFailed(this.mBridgeIds, "banner controler init error，please check it");
        }
    }

    public void loadFromBid(String str) {
        this.bidToken = str;
        if (this.controller == null) {
            BannerAdListener bannerAdListener = this.mBannerAdListener;
            if (bannerAdListener != null) {
                bannerAdListener.onLoadFailed(this.mBridgeIds, "banner controler init error，please check it");
            }
        } else if (!TextUtils.isEmpty(str)) {
            this.controller.b(this.hadAttached);
            this.controller.a(0);
            this.controller.a(str);
        } else {
            BannerAdListener bannerAdListener2 = this.mBannerAdListener;
            if (bannerAdListener2 != null) {
                bannerAdListener2.onLoadFailed(this.mBridgeIds, "banner token is null or empty，please check it");
            }
        }
    }

    public void setBannerAdListener(BannerAdListener bannerAdListener) {
        this.mBannerAdListener = bannerAdListener;
        a aVar = this.controller;
        if (aVar != null) {
            aVar.a(bannerAdListener);
        }
    }

    public void release() {
        if (this.mBannerAdListener != null) {
            this.mBannerAdListener = null;
        }
        a aVar = this.controller;
        if (aVar != null) {
            aVar.a((BannerAdListener) null);
            this.controller.b();
        }
        removeAllViews();
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        updateAttachedState(true);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        updateAttachedState(false);
    }

    private void updateAttachedState(boolean z) {
        this.hadAttached = z;
        a aVar = this.controller;
        if (aVar != null) {
            aVar.b(this.hadAttached);
        }
    }

    /* access modifiers changed from: protected */
    public void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        this.isVisible = i == 0;
        if (this.controller == null) {
            return;
        }
        if (i == 0) {
            delayedNotify();
        } else if (!b.c) {
            this.controller.c(false);
        }
    }

    /* access modifiers changed from: protected */
    public void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        this.isVisible = i == 0;
        if (this.controller == null) {
            return;
        }
        if (i == 0) {
            delayedNotify();
        } else if (!b.c) {
            this.controller.c(false);
        }
    }

    private void delayedNotify() {
        postDelayed(new Runnable() {
            public void run() {
                if (MBBannerView.this.controller != null && !b.c) {
                    MBBannerView.this.controller.c(true);
                }
            }
        }, 200);
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        a aVar = this.controller;
        if (aVar != null) {
            aVar.a(i, i2, i3, i4);
        }
    }

    public void onPause() {
        if (this.controller != null && TextUtils.isEmpty(this.bidToken)) {
            this.controller.d();
        }
    }

    public void onResume() {
        if (this.controller != null && TextUtils.isEmpty(this.bidToken) && !b.c) {
            this.controller.e();
        }
    }
}
