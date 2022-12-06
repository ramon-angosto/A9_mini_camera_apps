package com.mbridge.msdk.video.module.a.a;

import com.mbridge.msdk.video.module.MBridgeClickMiniCardView;
import com.mbridge.msdk.video.module.a.a;

/* compiled from: MiniCardProxyNotifyListener */
public final class g extends i {
    private MBridgeClickMiniCardView a;

    public g(MBridgeClickMiniCardView mBridgeClickMiniCardView, a aVar) {
        super(aVar);
        this.a = mBridgeClickMiniCardView;
    }

    public final void a(int i, Object obj) {
        boolean z = false;
        switch (i) {
            case 100:
                MBridgeClickMiniCardView mBridgeClickMiniCardView = this.a;
                if (mBridgeClickMiniCardView != null) {
                    mBridgeClickMiniCardView.webviewshow();
                    MBridgeClickMiniCardView mBridgeClickMiniCardView2 = this.a;
                    mBridgeClickMiniCardView2.onSelfConfigurationChanged(mBridgeClickMiniCardView2.getResources().getConfiguration());
                    break;
                }
                break;
            case 101:
            case 102:
                z = true;
                break;
            case 103:
                i = 107;
                break;
        }
        if (!z) {
            super.a(i, obj);
        }
    }
}
