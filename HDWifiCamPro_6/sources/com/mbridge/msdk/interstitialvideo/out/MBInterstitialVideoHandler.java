package com.mbridge.msdk.interstitialvideo.out;

import android.content.Context;
import android.text.TextUtils;
import com.mbridge.msdk.b.b;
import com.mbridge.msdk.foundation.tools.o;
import com.mbridge.msdk.foundation.tools.q;
import com.mbridge.msdk.foundation.tools.u;
import com.mbridge.msdk.reward.a.a;
import com.mbridge.msdk.videocommon.listener.InterVideoOutListener;

public class MBInterstitialVideoHandler {
    private a a;

    public MBInterstitialVideoHandler(Context context, String str, String str2) {
        if (com.mbridge.msdk.foundation.controller.a.e().g() == null && context != null) {
            com.mbridge.msdk.foundation.controller.a.e().b(context);
        }
        String d = u.d(str2);
        if (!TextUtils.isEmpty(d)) {
            u.a(str2, d);
        }
        a(str, str2);
    }

    public MBInterstitialVideoHandler(String str, String str2) {
        a(str, str2);
    }

    private void a(String str, String str2) {
        try {
            if (this.a == null) {
                this.a = new a();
                this.a.a(true);
            }
            this.a.b(str, str2);
            b.a().e(str2);
        } catch (Throwable th) {
            q.a("MBRewardVideoHandler", th.getMessage(), th);
        }
    }

    public String getRequestId() {
        a aVar = this.a;
        return aVar != null ? aVar.a() : "";
    }

    public void load() {
        a aVar = this.a;
        if (aVar != null) {
            aVar.d(true);
        }
    }

    public void loadFormSelfFilling() {
        a aVar = this.a;
        if (aVar != null) {
            aVar.d(false);
        }
    }

    public boolean isReady() {
        a aVar = this.a;
        if (aVar != null) {
            return aVar.e(true);
        }
        return false;
    }

    public void show() {
        a aVar = this.a;
        if (aVar != null) {
            aVar.a((String) null, (String) null, (String) null);
        }
    }

    public void setRewardVideoListener(InterstitialVideoListener interstitialVideoListener) {
        a aVar = this.a;
        if (aVar != null) {
            aVar.a((InterVideoOutListener) new com.mbridge.msdk.interstitialvideo.a.a(interstitialVideoListener));
        }
    }

    public void setInterstitialVideoListener(InterstitialVideoListener interstitialVideoListener) {
        a aVar = this.a;
        if (aVar != null) {
            aVar.a((InterVideoOutListener) new com.mbridge.msdk.interstitialvideo.a.a(interstitialVideoListener));
        }
    }

    public void clearVideoCache() {
        try {
            if (this.a != null) {
                a aVar = this.a;
                o.a();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void playVideoMute(int i) {
        a aVar = this.a;
        if (aVar != null) {
            aVar.a(i);
        }
    }

    public void setIVRewardEnable(int i, int i2) {
        a aVar = this.a;
        if (aVar != null) {
            aVar.a(i, com.mbridge.msdk.foundation.same.a.q, i2);
        }
    }

    public void setIVRewardEnable(int i, double d) {
        a aVar = this.a;
        if (aVar != null) {
            aVar.a(i, com.mbridge.msdk.foundation.same.a.p, (int) (d * 100.0d));
        }
    }

    public void setAlertDialogText(String str, String str2, String str3, String str4) {
        a aVar = this.a;
        if (aVar != null) {
            aVar.a(str, str2, str3, str4);
        }
    }
}
