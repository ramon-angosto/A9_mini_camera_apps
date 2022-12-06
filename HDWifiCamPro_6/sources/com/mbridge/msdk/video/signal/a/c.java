package com.mbridge.msdk.video.signal.a;

import android.app.Activity;
import com.mbridge.msdk.foundation.tools.q;
import com.mbridge.msdk.out.Campaign;
import com.mbridge.msdk.out.NativeListener;
import com.mbridge.msdk.video.signal.c;

/* compiled from: DefaultJSCommon */
public class c implements com.mbridge.msdk.video.signal.c {
    protected boolean a = false;
    protected boolean b = false;
    protected int c = 0;
    protected int d = 0;
    protected int e = 0;
    protected int f = 0;
    protected int g = 1;
    protected int h = -1;
    protected String i;
    protected com.mbridge.msdk.videocommon.d.c j;
    protected com.mbridge.msdk.click.a k;
    public c.a l = new a();
    protected int m = 2;

    public void f() {
    }

    public final void a(int i2) {
        this.m = i2;
    }

    public final void c(int i2) {
        this.c = i2;
    }

    public final void b(int i2) {
        this.d = i2;
    }

    public final void d(int i2) {
        this.e = i2;
    }

    public final int j() {
        if (this.c == 0 && this.b) {
            this.c = 1;
        }
        return this.c;
    }

    public final int k() {
        if (this.d == 0 && this.b) {
            this.d = 1;
        }
        return this.d;
    }

    public final int l() {
        if (this.e == 0 && this.b) {
            this.e = 1;
        }
        return this.e;
    }

    public final void e(int i2) {
        this.f = i2;
    }

    public final int a() {
        return this.f;
    }

    public final boolean m() {
        return this.b;
    }

    public final void a(boolean z) {
        q.a("DefaultJSCommon", "setIsShowingTransparent:" + z);
        this.b = z;
    }

    public final boolean b() {
        return this.a;
    }

    public final void b(boolean z) {
        this.a = z;
    }

    public final void a(String str) {
        q.a("DefaultJSCommon", "setUnitId:" + str);
        this.i = str;
    }

    public final void a(c.a aVar) {
        q.a("DefaultJSCommon", "setTrackingListener:" + aVar);
        this.l = aVar;
    }

    public final void a(com.mbridge.msdk.videocommon.d.c cVar) {
        q.a("DefaultJSCommon", "setSetting:" + cVar);
        this.j = cVar;
    }

    public final void e() {
        q.a("DefaultJSCommon", "release");
        com.mbridge.msdk.click.a aVar = this.k;
        if (aVar != null) {
            aVar.a(false);
            this.k.a((NativeListener.NativeTrackingListener) null);
            this.k.a();
        }
    }

    public void a(int i2, String str) {
        q.a("DefaultJSCommon", "statistics,type:" + i2 + ",json:" + str);
    }

    public final void f(int i2) {
        this.h = i2;
    }

    public final int g() {
        return this.h;
    }

    public String g(int i2) {
        q.a("DefaultJSCommon", "getSDKInfo");
        return "{}";
    }

    public final void h(int i2) {
        q.a("DefaultJSCommon", "setAlertDialogRole " + i2);
        this.g = i2;
    }

    public final int h() {
        q.a("DefaultJSCommon", "getAlertDialogRole " + this.g);
        return this.g;
    }

    public void a(Activity activity) {
        q.a("DefaultJSCommon", "setActivity ");
    }

    public String c() {
        q.a("DefaultJSCommon", "init");
        return "{}";
    }

    public void click(int i2, String str) {
        q.a("DefaultJSCommon", "click:type" + i2 + ",pt:" + str);
    }

    public void handlerH5Exception(int i2, String str) {
        q.a("DefaultJSCommon", "handlerH5Exception,code=" + i2 + ",msg:" + str);
    }

    public void d() {
        q.a("DefaultJSCommon", "finish");
    }

    public void b(String str) {
        q.a("DefaultJSCommon", "setNotchArea");
    }

    public String i() {
        q.a("DefaultJSCommon", "getNotchArea");
        return null;
    }

    /* compiled from: DefaultJSCommon */
    public static class b implements c.a {
        private com.mbridge.msdk.video.signal.c a;
        private c.a b;

        public b(com.mbridge.msdk.video.signal.c cVar, c.a aVar) {
            this.a = cVar;
            this.b = aVar;
        }

        public final boolean onInterceptDefaultLoadingDialog() {
            c.a aVar = this.b;
            return aVar != null && aVar.onInterceptDefaultLoadingDialog();
        }

        public final void onShowLoading(Campaign campaign) {
            c.a aVar = this.b;
            if (aVar != null) {
                aVar.onShowLoading(campaign);
            }
        }

        public final void onDismissLoading(Campaign campaign) {
            c.a aVar = this.b;
            if (aVar != null) {
                aVar.onDismissLoading(campaign);
            }
        }

        public final void onStartRedirection(Campaign campaign, String str) {
            c.a aVar = this.b;
            if (aVar != null) {
                aVar.onStartRedirection(campaign, str);
            }
        }

        public final void onFinishRedirection(Campaign campaign, String str) {
            c.a aVar = this.b;
            if (aVar != null) {
                aVar.onFinishRedirection(campaign, str);
            }
            com.mbridge.msdk.video.signal.c cVar = this.a;
            if (cVar != null) {
                cVar.d();
            }
        }

        public final void onRedirectionFailed(Campaign campaign, String str) {
            c.a aVar = this.b;
            if (aVar != null) {
                aVar.onRedirectionFailed(campaign, str);
            }
            com.mbridge.msdk.video.signal.c cVar = this.a;
            if (cVar != null) {
                cVar.d();
            }
        }

        public final void onDownloadStart(Campaign campaign) {
            c.a aVar = this.b;
            if (aVar != null) {
                aVar.onDownloadStart(campaign);
            }
        }

        public final void onDownloadFinish(Campaign campaign) {
            c.a aVar = this.b;
            if (aVar != null) {
                aVar.onDownloadFinish(campaign);
            }
        }

        public final void onDownloadProgress(int i) {
            c.a aVar = this.b;
            if (aVar != null) {
                aVar.onDownloadProgress(i);
            }
        }

        public final void a() {
            c.a aVar = this.b;
            if (aVar != null) {
                aVar.a();
            }
        }

        public final void a(boolean z) {
            c.a aVar = this.b;
            if (aVar != null) {
                aVar.a(z);
            }
        }

        public final void a(int i, String str) {
            c.a aVar = this.b;
            if (aVar != null) {
                aVar.a(i, str);
            }
        }

        public final void b() {
            c.a aVar = this.b;
            if (aVar != null) {
                aVar.b();
            }
        }
    }

    /* compiled from: DefaultJSCommon */
    public static class a implements c.a {
        public boolean onInterceptDefaultLoadingDialog() {
            q.a("DefaultJSCommon", "onInterceptDefaultLoadingDialog");
            return false;
        }

        public void onShowLoading(Campaign campaign) {
            q.a("DefaultJSCommon", "onShowLoading,campaign:" + campaign);
        }

        public void onDismissLoading(Campaign campaign) {
            q.a("DefaultJSCommon", "onDismissLoading,campaign:" + campaign);
        }

        public void onStartRedirection(Campaign campaign, String str) {
            q.a("DefaultJSCommon", "onStartRedirection,campaign:" + campaign + ",url:" + str);
        }

        public void onFinishRedirection(Campaign campaign, String str) {
            q.a("DefaultJSCommon", "onFinishRedirection,campaign:" + campaign + ",url:" + str);
        }

        public void onRedirectionFailed(Campaign campaign, String str) {
            q.a("DefaultJSCommon", "onFinishRedirection,campaign:" + campaign + ",url:" + str);
        }

        public void onDownloadStart(Campaign campaign) {
            q.a("DefaultJSCommon", "onDownloadStart,campaign:" + campaign);
        }

        public void onDownloadFinish(Campaign campaign) {
            q.a("DefaultJSCommon", "onDownloadFinish,campaign:" + campaign);
        }

        public void onDownloadProgress(int i) {
            q.a("DefaultJSCommon", "onDownloadProgress,progress:" + i);
        }

        public void a() {
            q.a("DefaultJSCommon", "onInitSuccess");
        }

        public void a(boolean z) {
            q.a("DefaultJSCommon", "onStartInstall");
        }

        public void a(int i, String str) {
            q.a("DefaultJSCommon", "onH5Error,code:" + i + "，msg:" + str);
        }

        public void b() {
            q.a("DefaultJSCommon", "videoLocationReady");
        }
    }
}
