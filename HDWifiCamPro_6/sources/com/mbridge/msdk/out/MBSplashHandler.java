package com.mbridge.msdk.out;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.mbridge.msdk.foundation.tools.u;
import com.mbridge.msdk.splash.d.c;

public class MBSplashHandler {
    private static boolean canSkip = true;
    private static int defCountDownS = 5;
    private static int logoSizeH = 0;
    private static int logoSizeW = 0;
    private static int orientation = 1;
    private c splashProvider;

    public MBSplashHandler(String str, String str2) {
        this(str, str2, canSkip, defCountDownS);
    }

    public MBSplashHandler(String str, String str2, boolean z, int i) {
        this(str, str2, z, i, orientation, logoSizeH, logoSizeW);
    }

    public MBSplashHandler(String str, String str2, boolean z, int i, int i2, int i3, int i4) {
        String d = u.d(str2);
        if (!TextUtils.isEmpty(d)) {
            u.a(str2, d);
        }
        this.splashProvider = new c(str, str2);
        this.splashProvider.b(z);
        this.splashProvider.b(i);
        this.splashProvider.a(i2);
        this.splashProvider.a(i3, i4);
    }

    public String getRequestId() {
        c cVar = this.splashProvider;
        return cVar != null ? cVar.e() : "";
    }

    public void setLoadTimeOut(long j) {
        c cVar = this.splashProvider;
        if (cVar != null) {
            cVar.a(j);
        }
    }

    public void setSplashLoadListener(MBSplashLoadListener mBSplashLoadListener) {
        c cVar = this.splashProvider;
        if (cVar != null) {
            cVar.a(mBSplashLoadListener);
        }
    }

    public void setSplashShowListener(MBSplashShowListener mBSplashShowListener) {
        c cVar = this.splashProvider;
        if (cVar != null) {
            cVar.a(mBSplashShowListener);
        }
    }

    public void preLoad() {
        c cVar = this.splashProvider;
        if (cVar != null) {
            cVar.b("");
        }
    }

    public void preLoadByToken(String str) {
        c cVar = this.splashProvider;
        if (cVar != null) {
            cVar.a(str);
        }
    }

    public void loadAndShow(ViewGroup viewGroup) {
        c cVar = this.splashProvider;
        if (cVar != null) {
            cVar.b("", viewGroup);
        }
    }

    public void loadAndShowByToken(String str, ViewGroup viewGroup) {
        c cVar = this.splashProvider;
        if (cVar != null) {
            cVar.a(str, viewGroup);
        }
    }

    public boolean isReady() {
        return isReady("");
    }

    public boolean isReady(String str) {
        c cVar = this.splashProvider;
        if (cVar != null) {
            return cVar.c(str);
        }
        return false;
    }

    public void show(ViewGroup viewGroup) {
        c cVar = this.splashProvider;
        if (cVar != null) {
            cVar.d("", viewGroup);
        }
    }

    public void show(ViewGroup viewGroup, String str) {
        c cVar = this.splashProvider;
        if (cVar != null) {
            cVar.c(str, viewGroup);
        }
    }

    public void setLogoView(View view, int i, int i2) {
        if (this.splashProvider != null) {
            this.splashProvider.a(view, new RelativeLayout.LayoutParams(i, i2));
        }
    }

    public void setOrientation(int i) {
        c cVar = this.splashProvider;
        if (cVar != null) {
            cVar.a(i);
        }
    }

    public void setDevCloseView(ViewGroup viewGroup) {
        c cVar = this.splashProvider;
        if (cVar != null) {
            cVar.a(viewGroup);
        }
    }

    public void setSupportZoomOut(boolean z) {
        c cVar = this.splashProvider;
        if (cVar != null) {
            cVar.c(z);
        }
    }

    public ViewGroup createZoomOutByType(ZoomOutTypeEnum zoomOutTypeEnum) {
        c cVar = this.splashProvider;
        if (cVar != null) {
            return cVar.a(zoomOutTypeEnum);
        }
        return null;
    }

    public void zoomOutAttacked() {
        c cVar = this.splashProvider;
        if (cVar != null) {
            cVar.f();
        }
    }

    public void zoomOutPlayFinish() {
        c cVar = this.splashProvider;
        if (cVar != null) {
            cVar.g();
        }
    }

    public void onResume() {
        c cVar = this.splashProvider;
        if (cVar != null) {
            cVar.h();
        }
    }

    public void onPause() {
        c cVar = this.splashProvider;
        if (cVar != null) {
            cVar.i();
        }
    }

    public void onDestroy() {
        c cVar = this.splashProvider;
        if (cVar != null) {
            cVar.j();
        }
    }

    public void allowClickSplash(boolean z) {
        c cVar = this.splashProvider;
        if (cVar != null) {
            cVar.d(z);
        }
    }
}
