package sg.bigo.ads.controller.f;

import android.content.Context;
import android.os.SystemClock;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import sg.bigo.ads.a.a;
import sg.bigo.ads.api.core.c;
import sg.bigo.ads.core.h.d;
import sg.bigo.ads.core.h.e;

public final class a {
    final c a;
    public final c.b b;
    public final int c;
    boolean d = false;
    String e = "";
    e f;
    long g;

    /* renamed from: sg.bigo.ads.controller.f.a$a  reason: collision with other inner class name */
    interface C0130a {
        void a(String str);

        void a(String str, long j, boolean z, int i);
    }

    public a(c cVar) {
        this.a = cVar;
        this.b = cVar.B();
        this.c = this.b.e();
    }

    static /* synthetic */ void a(a aVar, final String str, int i, final C0130a aVar2) {
        if (i == 0) {
            aVar.a(str, aVar2);
        } else if (i == 2) {
            aVar.g = SystemClock.elapsedRealtime();
            Context context = sg.bigo.ads.common.b.a.a;
            a.C0109a aVar3 = new a.C0109a();
            aVar3.a = str;
            sg.bigo.ads.a.a a2 = aVar3.a();
            sg.bigo.ads.a.c.a(context, a2.a, new a.b() {
                public final void a(Context context, String str, final int i, String str2) {
                    sg.bigo.ads.common.k.a.a(0, 3, "Preload", "Preload by chrome tabs failed, using webView.");
                    a.this.a(str, new C0130a() {
                        public final void a(String str) {
                            if (aVar2 != null) {
                                aVar2.a(str);
                            }
                        }

                        public final void a(String str, long j, boolean z, int i) {
                            if (aVar2 != null) {
                                aVar2.a(str, j, z, d.a(i));
                            }
                        }
                    });
                }

                public final void a(String str, String str2, String str3) {
                    C0130a aVar = aVar2;
                    if (aVar != null) {
                        aVar.a(str, SystemClock.elapsedRealtime() - a.this.g, true, 2);
                    }
                }
            });
        } else {
            sg.bigo.ads.common.k.a.a(0, "Preload", "PreloadLand: error open type.");
        }
    }

    public final void a() {
        sg.bigo.ads.common.k.a.a(0, 3, "Preload", "recycleLandWebView isPreloadWebViewReady=" + this.d);
        e eVar = this.f;
        if (eVar != null) {
            eVar.destroy();
            this.f = null;
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(final String str, final C0130a aVar) {
        this.g = SystemClock.elapsedRealtime();
        aVar.a(str);
        this.f = e.a(sg.bigo.ads.common.b.a.a);
        e eVar = this.f;
        if (eVar != null) {
            eVar.setWebChromeClient(new sg.bigo.ads.core.h.c());
            this.f.setWebViewClient(new d() {
                public final void a(RenderProcessGoneDetail renderProcessGoneDetail) {
                    a.this.f = null;
                    aVar.a(str, SystemClock.elapsedRealtime() - a.this.g, false, 0);
                }

                public final void onPageFinished(WebView webView, String str) {
                    super.onPageFinished(webView, str);
                    sg.bigo.ads.common.k.a.a(0, 3, "Preload", "onPageFinished: url=" + webView.getUrl());
                    aVar.a(str, SystemClock.elapsedRealtime() - a.this.g, true, 0);
                }

                public final void onReceivedError(WebView webView, int i, String str, String str2) {
                    super.onReceivedError(webView, i, str, str2);
                    sg.bigo.ads.common.k.a.b("Preload", "onReceivedError: " + i + " " + str);
                    aVar.a(str, SystemClock.elapsedRealtime() - a.this.g, false, 0);
                }

                public final void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
                    super.onReceivedError(webView, webResourceRequest, webResourceError);
                    if (webResourceRequest.isForMainFrame()) {
                        onReceivedError(webView, webResourceError.getErrorCode(), webResourceError.getDescription().toString(), webResourceRequest.getUrl().toString());
                    }
                }

                public final void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
                    super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
                    if (webResourceRequest.isForMainFrame()) {
                        onReceivedError(webView, webResourceResponse.getStatusCode(), webResourceResponse.getReasonPhrase(), webResourceRequest.getUrl().toString());
                    }
                }
            });
            this.f.setLeft(0);
            this.f.setTop(0);
            this.f.setRight(sg.bigo.ads.common.utils.d.b(sg.bigo.ads.common.b.a.a));
            this.f.setBottom(sg.bigo.ads.common.utils.d.c(sg.bigo.ads.common.b.a.a) - sg.bigo.ads.common.utils.d.a(sg.bigo.ads.common.b.a.a, 55));
            this.f.loadUrl(str);
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean b() {
        int i = this.c;
        return i == 3 || i == 4;
    }
}
