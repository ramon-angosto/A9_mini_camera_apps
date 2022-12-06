package com.mbridge.msdk.out;

import android.content.Context;
import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.tools.u;
import com.mbridge.msdk.interstitial.c.a;
import java.util.Map;

public class MBInterstitialHandler {
    private a mController;

    public MBInterstitialHandler(Context context, Map<String, Object> map) {
        if (this.mController == null) {
            this.mController = new a();
        }
        if (map != null && map.containsKey(MBridgeConstans.PROPERTIES_UNIT_ID)) {
            String str = (String) map.get(MBridgeConstans.PROPERTIES_UNIT_ID);
            if (!TextUtils.isEmpty(str)) {
                String d = u.d(str);
                if (!TextUtils.isEmpty(d)) {
                    u.a(str, d);
                }
            }
        }
        this.mController.a(context, map);
        if (com.mbridge.msdk.foundation.controller.a.e().g() == null && context != null) {
            com.mbridge.msdk.foundation.controller.a.e().b(context);
        }
    }

    public void preload() {
        try {
            if (this.mController != null) {
                this.mController.a();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getRequestId() {
        a aVar = this.mController;
        return aVar != null ? aVar.b() : "";
    }

    public void show() {
        try {
            this.mController.c();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setInterstitialListener(InterstitialListener interstitialListener) {
        try {
            if (this.mController != null) {
                this.mController.a(interstitialListener);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
