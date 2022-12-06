package com.mbridge.msdk.splash.c;

import android.content.Context;
import android.net.http.SslError;
import android.text.TextUtils;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.q;
import com.mbridge.msdk.splash.view.MBSplashView;
import com.mbridge.msdk.splash.view.MBSplashWebview;
import java.util.ArrayList;
import java.util.List;

/* compiled from: WebViewRenderManager */
public final class d {
    /* access modifiers changed from: private */
    public boolean a;
    /* access modifiers changed from: private */
    public boolean b;

    /* compiled from: WebViewRenderManager */
    static class a {
        /* access modifiers changed from: private */
        public static final d a = new d();
    }

    /* compiled from: WebViewRenderManager */
    public interface b {
        void a();

        void a(int i);

        void a(String str);
    }

    private d() {
        this.a = false;
        this.b = false;
    }

    public final void a() {
        this.a = false;
        this.b = false;
    }

    public final void a(MBSplashView mBSplashView, c cVar, b bVar) {
        String str;
        MBSplashView mBSplashView2 = mBSplashView;
        b bVar2 = bVar;
        if (mBSplashView2 != null && cVar != null) {
            String c2 = cVar.c();
            String b2 = cVar.b();
            CampaignEx d = cVar.d();
            String a2 = cVar.a();
            boolean e = cVar.e();
            int f = cVar.f();
            MBSplashWebview splashWebview = mBSplashView.getSplashWebview();
            if (splashWebview != null) {
                com.mbridge.msdk.splash.signal.b bVar3 = new com.mbridge.msdk.splash.signal.b(mBSplashView.getContext(), b2, c2);
                ArrayList arrayList = new ArrayList();
                arrayList.add(d);
                bVar3.a((List<CampaignEx>) arrayList);
                bVar3.a(e ? 1 : 0);
                bVar3.b(f);
                mBSplashView2.setSplashSignalCommunicationImpl(bVar3);
                if (TextUtils.isEmpty(d.getRequestId())) {
                    str = d.getRequestIdNotice();
                } else {
                    str = d.getRequestId();
                }
                String requestId = splashWebview.getRequestId();
                q.d("WebViewRenderManager", "CampaignEx RequestId = " + str + " WebView RequestId = " + requestId);
                if (TextUtils.isEmpty(requestId) || !requestId.equals(str) || (!this.a && !this.b)) {
                    a();
                    splashWebview.setRequestId(str);
                    com.mbridge.msdk.splash.a.b a3 = com.mbridge.msdk.splash.a.b.a().c(d.getId()).d(d.getRequestId()).g(d.getRequestIdNotice()).b(c2).a(d.isBidCampaign());
                    if (a3 != null) {
                        a3.a("2000067");
                        if (com.mbridge.msdk.foundation.same.report.a.a().c()) {
                            com.mbridge.msdk.foundation.same.report.a.a().a(a3.b());
                        } else {
                            com.mbridge.msdk.foundation.same.report.b.a(a3.b(), com.mbridge.msdk.foundation.controller.a.e().g(), c2);
                        }
                    }
                    long currentTimeMillis = System.currentTimeMillis();
                    final b bVar4 = bVar;
                    final MBSplashView mBSplashView3 = mBSplashView;
                    final CampaignEx campaignEx = d;
                    final String str2 = c2;
                    AnonymousClass1 r8 = r0;
                    final long j = currentTimeMillis;
                    AnonymousClass1 r0 = new com.mbridge.msdk.mbsignalcommon.b.b() {
                        public final void a(WebView webView, int i) {
                            super.a(webView, i);
                            b bVar = bVar4;
                            if (bVar != null) {
                                bVar.a(i);
                            }
                            if (i == 1) {
                                boolean unused = d.this.a = true;
                                mBSplashView3.setH5Ready(true);
                                com.mbridge.msdk.splash.e.a.a(com.mbridge.msdk.foundation.controller.a.e().g(), campaignEx, str2, "", j, 1);
                                com.mbridge.msdk.splash.e.a.a(campaignEx, str2);
                                return;
                            }
                            boolean unused2 = d.this.a = false;
                            mBSplashView3.setH5Ready(false);
                            com.mbridge.msdk.splash.e.a.a(campaignEx, "readyState 2", str2);
                            com.mbridge.msdk.splash.e.a.a(com.mbridge.msdk.foundation.controller.a.e().g(), campaignEx, str2, "readyState 2", j, 3);
                        }

                        public final void a(WebView webView, int i, String str, String str2) {
                            super.a(webView, i, str, str2);
                            b bVar = bVar4;
                            if (bVar != null) {
                                bVar.a(str);
                            }
                            d.this.a();
                            mBSplashView3.setH5Ready(false);
                            CampaignEx campaignEx = campaignEx;
                            com.mbridge.msdk.splash.e.a.a(campaignEx, "error code:" + i + str, str2);
                            Context g = com.mbridge.msdk.foundation.controller.a.e().g();
                            CampaignEx campaignEx2 = campaignEx;
                            String str3 = str2;
                            com.mbridge.msdk.splash.e.a.a(g, campaignEx2, str3, "error code:" + i + str, j, 3);
                        }

                        public final void a(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
                            super.a(webView, sslErrorHandler, sslError);
                            b bVar = bVar4;
                            if (bVar != null) {
                                bVar.a(sslError.toString());
                            }
                            d.this.a();
                            mBSplashView3.setH5Ready(false);
                            CampaignEx campaignEx = campaignEx;
                            com.mbridge.msdk.splash.e.a.a(campaignEx, "error url:" + sslError.getUrl(), str2);
                            Context g = com.mbridge.msdk.foundation.controller.a.e().g();
                            CampaignEx campaignEx2 = campaignEx;
                            String str = str2;
                            com.mbridge.msdk.splash.e.a.a(g, campaignEx2, str, "error url:" + sslError.getUrl(), j, 3);
                        }

                        public final void a(WebView webView, String str) {
                            super.a(webView, str);
                            b bVar = bVar4;
                            if (bVar != null) {
                                bVar.a();
                            }
                            boolean unused = d.this.b = true;
                            if (!campaignEx.isHasMBTplMark()) {
                                mBSplashView3.setH5Ready(true);
                                com.mbridge.msdk.splash.e.a.a(campaignEx, str2);
                                com.mbridge.msdk.splash.e.a.a(com.mbridge.msdk.foundation.controller.a.e().g(), campaignEx, str2, "", j, 1);
                            }
                            com.mbridge.msdk.splash.signal.c.a(webView);
                        }
                    };
                    splashWebview.setWebViewListener(r8);
                    if (!splashWebview.isDestoryed()) {
                        splashWebview.loadUrl(a2);
                        return;
                    }
                    mBSplashView2.setH5Ready(false);
                    com.mbridge.msdk.splash.e.a.a(com.mbridge.msdk.foundation.controller.a.e().g(), d, c2, "webview had destory", currentTimeMillis, 3);
                    return;
                }
                mBSplashView2.setH5Ready(true);
                if (bVar2 != null) {
                    bVar2.a(1);
                }
            }
        }
    }

    /* compiled from: WebViewRenderManager */
    public static class c {
        private String a;
        private String b;
        private CampaignEx c;
        private String d;
        private boolean e;
        private int f;

        public final String a() {
            return this.d;
        }

        public final void a(String str) {
            this.d = str;
        }

        public final String b() {
            return this.a;
        }

        public final void b(String str) {
            this.a = str;
        }

        public final String c() {
            return this.b;
        }

        public final void c(String str) {
            this.b = str;
        }

        public final CampaignEx d() {
            return this.c;
        }

        public final void a(CampaignEx campaignEx) {
            this.c = campaignEx;
        }

        public final boolean e() {
            return this.e;
        }

        public final void a(boolean z) {
            this.e = z;
        }

        public final int f() {
            return this.f;
        }

        public final void a(int i) {
            this.f = i;
        }
    }
}
