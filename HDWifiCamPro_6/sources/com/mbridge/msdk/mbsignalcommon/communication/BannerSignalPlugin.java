package com.mbridge.msdk.mbsignalcommon.communication;

import android.content.Context;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.q;
import com.mbridge.msdk.mbsignalcommon.windvane.AbsFeedBackForH5;
import com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView;

public class BannerSignalPlugin extends AbsFeedBackForH5 {
    private final String d = "BannerSignalPlugin";
    private c e;

    public void initialize(Context context, WindVaneWebView windVaneWebView) {
        super.initialize(context, windVaneWebView);
        try {
            if (context instanceof c) {
                this.e = (c) context;
            } else if (windVaneWebView.getObject() != null && (windVaneWebView.getObject() instanceof c)) {
                this.e = (c) windVaneWebView.getObject();
            }
        } catch (Throwable th) {
            q.a("BannerSignalPlugin", "initialize", th);
        }
    }

    public void onSignalCommunication(Object obj, String str) {
        try {
            q.d("BannerSignalPlugin", "onSignalCommunication");
            if (this.e != null) {
                this.e.f(obj, str);
            }
        } catch (Throwable th) {
            q.a("BannerSignalPlugin", "onSignalCommunication", th);
        }
    }

    public void readyStatus(Object obj, String str) {
        try {
            q.d("BannerSignalPlugin", "readyStatus");
            if (this.e != null) {
                this.e.c(obj, str);
            }
        } catch (Throwable th) {
            q.a("BannerSignalPlugin", "readyStatus", th);
        }
    }

    public void init(Object obj, String str) {
        try {
            q.d("BannerSignalPlugin", "init");
            if (this.e != null) {
                this.e.a(obj, str);
            }
        } catch (Throwable th) {
            q.a("BannerSignalPlugin", "init", th);
        }
    }

    public void click(Object obj, String str) {
        try {
            q.d("BannerSignalPlugin", CampaignEx.JSON_NATIVE_VIDEO_CLICK);
            if (this.e != null) {
                this.e.b(obj, str);
            }
        } catch (Throwable th) {
            q.a("BannerSignalPlugin", CampaignEx.JSON_NATIVE_VIDEO_CLICK, th);
        }
    }

    public void toggleCloseBtn(Object obj, String str) {
        try {
            q.d("BannerSignalPlugin", "toggleCloseBtn");
            if (this.e != null) {
                this.e.d(obj, str);
            }
        } catch (Throwable th) {
            q.a("BannerSignalPlugin", "toggleCloseBtn", th);
        }
    }

    public void triggerCloseBtn(Object obj, String str) {
        try {
            q.d("BannerSignalPlugin", "triggerCloseBtn");
            if (this.e != null) {
                this.e.e(obj, str);
            }
        } catch (Throwable th) {
            q.a("BannerSignalPlugin", "triggerCloseBtn", th);
        }
    }

    public void sendImpressions(Object obj, String str) {
        try {
            q.d("BannerSignalPlugin", "sendImpressions");
            if (this.e != null) {
                this.e.i(obj, str);
            }
        } catch (Throwable th) {
            q.a("BannerSignalPlugin", "sendImpressions", th);
        }
    }

    public void reportUrls(Object obj, String str) {
        try {
            q.d("BannerSignalPlugin", "reportUrls");
            if (this.e != null) {
                this.e.k(obj, str);
            }
        } catch (Throwable th) {
            q.a("BannerSignalPlugin", "reportUrls", th);
        }
    }

    public void increaseOfferFrequence(Object obj, String str) {
        try {
            q.d("BannerSignalPlugin", "increaseOfferFrequence");
            if (this.e != null) {
                this.e.l(obj, str);
            }
        } catch (Throwable th) {
            q.a("BannerSignalPlugin", "increaseOfferFrequence", th);
        }
    }

    public void resetCountdown(Object obj, String str) {
        try {
            q.d("BannerSignalPlugin", "resetCountdown");
            if (this.e != null) {
                this.e.h(obj, str);
            }
        } catch (Throwable th) {
            q.a("BannerSignalPlugin", "resetCountdown", th);
        }
    }

    public void handlerH5Exception(Object obj, String str) {
        try {
            q.d("BannerSignalPlugin", "handlerH5Exception");
            if (this.e != null) {
                this.e.m(obj, str);
            }
        } catch (Throwable th) {
            q.a("BannerSignalPlugin", "handlerH5Exception", th);
        }
    }

    public void install(Object obj, String str) {
        try {
            q.d("BannerSignalPlugin", "install");
            if (this.e != null) {
                this.e.g(obj, str);
            }
        } catch (Throwable th) {
            q.a("BannerSignalPlugin", "install", th);
        }
    }

    public void getNetstat(Object obj, String str) {
        try {
            q.d("BannerSignalPlugin", "getNetstat");
            if (this.e != null) {
                this.e.o(obj, str);
            }
        } catch (Throwable th) {
            q.a("BannerSignalPlugin", "getNetstat", th);
        }
    }

    public void openURL(Object obj, String str) {
        try {
            q.d("BannerSignalPlugin", "openURL");
            if (this.e != null) {
                this.e.n(obj, str);
            }
        } catch (Throwable th) {
            q.a("BannerSignalPlugin", "openURL", th);
        }
    }

    public void getFileInfo(Object obj, String str) {
        try {
            q.d("BannerSignalPlugin", "getFileInfo");
            if (this.e != null) {
                this.e.j(obj, str);
            }
        } catch (Throwable th) {
            q.a("BannerSignalPlugin", "getFileInfo", th);
        }
    }
}
