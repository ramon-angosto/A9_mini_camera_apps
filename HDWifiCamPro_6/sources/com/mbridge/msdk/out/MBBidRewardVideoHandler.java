package com.mbridge.msdk.out;

import android.content.Context;
import android.text.TextUtils;
import com.mbridge.msdk.foundation.tools.o;
import com.mbridge.msdk.foundation.tools.q;
import com.mbridge.msdk.foundation.tools.u;
import com.mbridge.msdk.reward.a.a;
import com.mbridge.msdk.video.bt.module.b.g;
import com.mbridge.msdk.videocommon.listener.InterVideoOutListener;

public class MBBidRewardVideoHandler {
    private static final String TAG = "MBBidRewardVideoHandler";
    private a controller;

    public MBBidRewardVideoHandler(Context context, String str, String str2) {
        if (com.mbridge.msdk.foundation.controller.a.e().g() == null && context != null) {
            com.mbridge.msdk.foundation.controller.a.e().b(context);
        }
        String d = u.d(str2);
        if (!TextUtils.isEmpty(d)) {
            u.a(str2, d);
        }
        initMBBidRewardVideoHandler(str, str2);
    }

    public MBBidRewardVideoHandler(String str, String str2) {
        String d = u.d(str2);
        if (!TextUtils.isEmpty(d)) {
            u.a(str2, d);
        }
        initMBBidRewardVideoHandler(str, str2);
    }

    private void initMBBidRewardVideoHandler(String str, String str2) {
        try {
            if (this.controller == null) {
                this.controller = new a();
                this.controller.a(false);
                this.controller.b(true);
            }
            this.controller.b(str, str2);
        } catch (Throwable th) {
            q.a(TAG, th.getMessage(), th);
        }
    }

    public void loadFromBid(String str) {
        a aVar = this.controller;
        if (aVar != null) {
            aVar.a(true, str);
        }
    }

    public boolean isBidReady() {
        a aVar = this.controller;
        if (aVar != null) {
            return aVar.e(false);
        }
        return false;
    }

    public String getRequestId() {
        a aVar = this.controller;
        return aVar != null ? aVar.a() : "";
    }

    public void showFromBid() {
        a aVar = this.controller;
        if (aVar != null) {
            aVar.a((String) null, (String) null, (String) null);
        }
    }

    public void showFromBid(String str) {
        a aVar = this.controller;
        if (aVar != null) {
            aVar.a((String) null, str, (String) null);
        }
    }

    public void showFromBid(String str, String str2) {
        a aVar = this.controller;
        if (aVar != null) {
            aVar.a((String) null, str, str2);
        }
    }

    public void setRewardVideoListener(g gVar) {
        a aVar = this.controller;
        if (aVar != null) {
            aVar.a((InterVideoOutListener) new com.mbridge.msdk.video.bt.module.b.a(gVar));
        }
    }

    public void clearVideoCache() {
        try {
            if (this.controller != null) {
                a aVar = this.controller;
                o.a();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void playVideoMute(int i) {
        a aVar = this.controller;
        if (aVar != null) {
            aVar.a(i);
        }
    }

    public void setAlertDialogText(String str, String str2, String str3, String str4) {
        a aVar = this.controller;
        if (aVar != null) {
            aVar.a(str, str2, str3, str4);
        }
    }

    public void setRewardPlus(boolean z) {
        a aVar = this.controller;
        if (aVar != null) {
            aVar.c(z);
        }
    }
}
