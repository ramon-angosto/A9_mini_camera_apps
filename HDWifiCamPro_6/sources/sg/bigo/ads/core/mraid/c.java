package sg.bigo.ads.core.mraid;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Point;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.ConsoleMessage;
import android.webkit.JsResult;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;
import androidx.vectordrawable.graphics.drawable.PathInterpolatorCompat;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.json.JSONObject;
import sg.bigo.ads.core.mraid.a.a;
import sg.bigo.ads.core.mraid.h;
import sg.bigo.ads.core.mraid.q;

public final class c {
    b a;
    o b;
    boolean c;
    public boolean d;
    private final n e;
    private final h f;
    private C0143c g;
    private final WebViewClient h;

    public interface a extends b {
        void a(String str, String str2);
    }

    public interface b {
        void a();

        void a(int i, int i2, int i3, int i4, a.C0142a aVar, boolean z);

        void a(String str);

        void a(String str, Point point);

        void a(String str, boolean z);

        void a(b bVar);

        void a(boolean z);

        void a(boolean z, i iVar);

        boolean a(JsResult jsResult);

        void b();

        void b(boolean z);

        void c();

        boolean d();

        void e();

        void f();
    }

    /* renamed from: sg.bigo.ads.core.mraid.c$c  reason: collision with other inner class name */
    public static class C0143c extends sg.bigo.ads.core.h.b {
        boolean a;
        private a f;
        private q g;
        private Point h;

        /* renamed from: sg.bigo.ads.core.mraid.c$c$a */
        public interface a {
            void a(b bVar);

            void a(boolean z);
        }

        private C0143c(Context context) {
            super(context);
            if (Build.VERSION.SDK_INT <= 22) {
                this.a = getVisibility() == 0;
                return;
            }
            this.g = new q(this);
            this.g.d = new q.b() {
                public final void a(boolean z, b bVar) {
                    C0143c.this.setMraidViewable(z);
                    C0143c.a(C0143c.this, bVar);
                }
            };
        }

        /* synthetic */ C0143c(Context context, byte b) {
            this(context);
        }

        static /* synthetic */ void a(C0143c cVar, b bVar) {
            a aVar = cVar.f;
            if (aVar != null) {
                aVar.a(bVar);
            }
        }

        /* access modifiers changed from: private */
        public void setMraidViewable(boolean z) {
            if (this.a != z) {
                this.a = z;
                a aVar = this.f;
                if (aVar != null) {
                    aVar.a(z);
                }
            }
        }

        public final void destroy() {
            super.destroy();
            setWebChromeClient((WebChromeClient) null);
            setWebViewClient((WebViewClient) null);
            this.g = null;
            this.f = null;
        }

        public final Point getLastClickPoint() {
            return this.h;
        }

        public final boolean onTouchEvent(MotionEvent motionEvent) {
            if (motionEvent.getActionMasked() == 1) {
                this.h = new Point((int) motionEvent.getX(), (int) motionEvent.getY());
            }
            return super.onTouchEvent(motionEvent);
        }

        /* access modifiers changed from: protected */
        public final void onVisibilityChanged(View view, int i) {
            super.onVisibilityChanged(view, i);
            boolean z = false;
            if (this.g == null) {
                if (i == 0) {
                    z = true;
                }
                setMraidViewable(z);
            } else if (i != 0) {
                setMraidViewable(false);
            }
        }

        /* access modifiers changed from: package-private */
        public final void setVisibilityChangedListener(a aVar) {
            this.f = aVar;
        }
    }

    c(n nVar) {
        this(nVar, new h());
    }

    private c(n nVar, h hVar) {
        this.d = false;
        this.h = new k() {
            public final void a(RenderProcessGoneDetail renderProcessGoneDetail) {
                c cVar = c.this;
                sg.bigo.ads.common.k.a.a(0, "MraidBridge", (renderProcessGoneDetail == null || !renderProcessGoneDetail.didCrash()) ? "Render process is gone" : "Render process has crashed");
                cVar.a();
                if (cVar.a != null) {
                    cVar.a.c();
                }
            }

            public final void onPageFinished(WebView webView, String str) {
                super.onPageFinished(webView, str);
                c cVar = c.this;
                if (!cVar.c) {
                    cVar.c = true;
                    if (cVar.a != null) {
                        cVar.a.a();
                    }
                }
            }

            public final void onReceivedError(WebView webView, int i, String str, String str2) {
                sg.bigo.ads.common.k.a.a(0, "MraidBridge", "Error: ".concat(String.valueOf(str)));
                super.onReceivedError(webView, i, str, str2);
            }

            public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
                return c.this.d(str);
            }
        };
        this.e = nVar;
        this.f = hVar;
    }

    private static int a(int i, int i2) {
        if (i >= i2 && i <= 100000) {
            return i;
        }
        throw new d("Integer parameter out of range: ".concat(String.valueOf(i)));
    }

    private static String a(Rect rect) {
        return rect.left + "," + rect.top + "," + rect.width() + "," + rect.height();
    }

    private static Map<String, String> a(Uri uri) {
        HashMap hashMap = new HashMap();
        for (String next : uri.getQueryParameterNames()) {
            hashMap.put(next, TextUtils.join(",", uri.getQueryParameters(next)));
        }
        return hashMap;
    }

    static C0143c a(Context context) {
        try {
            return new C0143c(context, (byte) 0);
        } catch (Exception e2) {
            e2.printStackTrace();
            sg.bigo.ads.core.d.a.a((sg.bigo.ads.api.core.c) null, (int) PathInterpolatorCompat.MAX_NUM_POINTS, 10100, Log.getStackTraceString(e2));
            return null;
        }
    }

    private static boolean a(String str, boolean z) {
        return str == null ? z : g(str);
    }

    private static boolean a(Map<String, String> map) {
        return a(map.get("shouldUseCustomClose"), false);
    }

    private static String b(Rect rect) {
        return rect.width() + "," + rect.height();
    }

    private boolean d() {
        o oVar = this.b;
        if (oVar != null) {
            return this.d ? oVar.a.a : oVar.a();
        }
        return false;
    }

    private static String e(String str) {
        if (str != null) {
            return str;
        }
        throw new d("Parameter cannot be null");
    }

    private static int f(String str) {
        try {
            return Integer.parseInt(str, 10);
        } catch (NumberFormatException unused) {
            throw new d("Invalid numeric parameter: ".concat(String.valueOf(str)));
        }
    }

    private static boolean g(String str) {
        if ("true".equals(str)) {
            return true;
        }
        if ("false".equals(str)) {
            return false;
        }
        throw new d("Invalid boolean parameter: ".concat(String.valueOf(str)));
    }

    /* access modifiers changed from: package-private */
    public final void a() {
        C0143c cVar = this.g;
        if (cVar != null) {
            cVar.setOnTouchListener((View.OnTouchListener) null);
            this.g.setVisibilityChangedListener((C0143c.a) null);
            this.g.destroy();
            this.g = null;
        }
    }

    public final void a(String str) {
        if (this.g == null) {
            sg.bigo.ads.common.k.a.a(0, "MraidBridge", "MRAID bridge called setContentHtml before WebView was attached");
            return;
        }
        this.c = false;
        sg.bigo.ads.common.k.a.a(0, 3, "MraidBridge", "MraidBridge setContentHtml");
        this.g.loadDataWithBaseURL("http://mraid.bigo.sg", str, "text/html", (String) null, (String) null);
    }

    /* access modifiers changed from: package-private */
    public final void a(b bVar) {
        StringBuilder sb = new StringBuilder("mraidbridge.notifyExposureChangeEvent(");
        sb.append(String.valueOf(bVar.a) + ", " + b.a(bVar.b) + ", " + b.a(bVar.c));
        sb.append(");");
        c(sb.toString());
    }

    /* access modifiers changed from: package-private */
    public final void a(C0143c cVar) {
        this.g = cVar;
        this.g.getSettings().setJavaScriptEnabled(true);
        if (this.e == n.INTERSTITIAL && Build.VERSION.SDK_INT >= 17) {
            cVar.getSettings().setMediaPlaybackRequiresUserGesture(false);
        }
        this.g.setScrollContainer(false);
        this.g.setVerticalScrollBarEnabled(false);
        this.g.setHorizontalScrollBarEnabled(false);
        this.g.setBackgroundColor(0);
        this.g.setWebViewClient(this.h);
        this.g.setWebChromeClient(new sg.bigo.ads.core.h.c() {
            public final void a(WebView webView, String str, String str2) {
                super.a(webView, str, str2);
                if (c.this.a != null && (c.this.a instanceof a)) {
                    ((a) c.this.a).a(str, str2);
                }
            }

            public final boolean onConsoleMessage(ConsoleMessage consoleMessage) {
                return c.this.a != null ? c.this.a.d() : super.onConsoleMessage(consoleMessage);
            }

            public final boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
                return c.this.a != null ? c.this.a.a(jsResult) : super.onJsAlert(webView, str, str2, jsResult);
            }

            public final void onShowCustomView(View view, WebChromeClient.CustomViewCallback customViewCallback) {
                super.onShowCustomView(view, customViewCallback);
            }
        });
        this.b = new o(this.g.getContext());
        this.g.setOnTouchListener(new View.OnTouchListener() {
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                c.this.b.onTouchEvent(motionEvent);
                int action = motionEvent.getAction();
                if ((action != 0 && action != 1) || view.hasFocus()) {
                    return false;
                }
                view.requestFocus();
                return false;
            }
        });
        this.g.setVisibilityChangedListener(new C0143c.a() {
            public final void a(b bVar) {
                if (c.this.a != null) {
                    c.this.a.a(bVar);
                }
            }

            public final void a(boolean z) {
                if (c.this.a != null) {
                    c.this.a.a(z);
                }
            }
        });
    }

    /* access modifiers changed from: package-private */
    public final void a(g gVar, String str) {
        c("window.mraidbridge.notifyErrorEvent(" + JSONObject.quote(gVar.l) + ", " + JSONObject.quote(str) + ")");
    }

    public final void a(j jVar) {
        String str;
        StringBuilder sb = new StringBuilder("mraidbridge.setScreenSize(");
        sb.append(b(jVar.b));
        sb.append(");mraidbridge.setMaxSize(");
        sb.append(b(jVar.d));
        sb.append(");mraidbridge.setCurrentPosition(");
        sb.append(a(jVar.f));
        sb.append(");mraidbridge.setDefaultPosition(");
        sb.append(a(jVar.h));
        sb.append(");mraidbridge.setCurrentAppOrientation(");
        C0143c cVar = this.g;
        if (cVar == null) {
            str = "";
        } else {
            Context context = cVar.getContext();
            Activity activity = context instanceof Activity ? (Activity) context : null;
            String str2 = context.getResources().getConfiguration().orientation == 2 ? "landscape" : "portrait";
            boolean z = false;
            if (activity == null) {
                sg.bigo.ads.common.k.a.a(0, 3, "MraidBridge", "Context is not an Activity, set locked to false");
            } else if (activity.getRequestedOrientation() != -1) {
                z = true;
            }
            str = "'" + str2 + "', " + z;
        }
        sb.append(str);
        sb.append(")");
        c(sb.toString());
        c("mraidbridge.notifySizeChangeEvent(" + b(jVar.f) + ")");
    }

    /* access modifiers changed from: package-private */
    public final void a(n nVar) {
        c("mraidbridge.setPlacementType(" + JSONObject.quote(nVar.toString().toLowerCase(Locale.US)) + ")");
    }

    /* access modifiers changed from: package-private */
    public final void a(p pVar) {
        c("mraidbridge.setState(" + JSONObject.quote(pVar.toString().toLowerCase(Locale.US)) + ")");
    }

    /* access modifiers changed from: package-private */
    public final void a(boolean z) {
        c("mraidbridge.setIsViewable(" + z + ")");
    }

    /* access modifiers changed from: package-private */
    public final void a(boolean z, boolean z2, boolean z3, boolean z4, boolean z5) {
        c("mraidbridge.setSupports(" + z + "," + z2 + "," + z3 + "," + z4 + "," + z5 + ")");
    }

    public final void b(String str) {
        C0143c cVar = this.g;
        if (cVar == null) {
            sg.bigo.ads.common.k.a.a(0, "MraidBridge", "MRAID bridge called setContentHtml while WebView was not attached");
            return;
        }
        this.c = false;
        cVar.loadUrl(str);
    }

    /* access modifiers changed from: package-private */
    public final boolean b() {
        C0143c cVar = this.g;
        return cVar != null && cVar.a;
    }

    /* access modifiers changed from: package-private */
    public final void c(String str) {
        if (this.g == null) {
            sg.bigo.ads.common.k.a.a(0, "MraidBridge", "Attempted to inject Javascript into MRAID WebView while was not attached:\n\t".concat(String.valueOf(str)));
            return;
        }
        sg.bigo.ads.common.k.a.a(0, 3, "MraidBridge", "Injecting Javascript into MRAID WebView:\n\t".concat(String.valueOf(str)));
        this.g.loadUrl("javascript:".concat(String.valueOf(str)));
    }

    /* access modifiers changed from: package-private */
    public final boolean c() {
        return this.g != null;
    }

    /* access modifiers changed from: package-private */
    public final boolean d(String str) {
        a.C0142a aVar;
        a.C0142a aVar2;
        i iVar;
        b bVar;
        try {
            Uri parse = Uri.parse(str);
            if (parse == null) {
                return true;
            }
            String scheme = parse.getScheme();
            String host = parse.getHost();
            if ("mopub".equals(scheme)) {
                if ("failLoad".equals(host) && this.e == n.INLINE && (bVar = this.a) != null) {
                    bVar.b();
                }
                return true;
            }
            if (d() && !CampaignEx.JSON_KEY_MRAID.equals(scheme)) {
                try {
                    StringBuilder sb = new StringBuilder("mraid://open?url=");
                    try {
                        sb.append(URLEncoder.encode(str, "UTF-8"));
                        parse = Uri.parse(sb.toString());
                        host = parse.getHost();
                        scheme = parse.getScheme();
                    } catch (UnsupportedEncodingException unused) {
                        sg.bigo.ads.common.k.a.a(0, "MraidBridge", "Invalid MRAID URL encoding: ".concat(String.valueOf(str)));
                        a(g.OPEN, "Non-mraid URL is invalid");
                        return false;
                    }
                } catch (UnsupportedEncodingException unused2) {
                    String str2 = str;
                    sg.bigo.ads.common.k.a.a(0, "MraidBridge", "Invalid MRAID URL encoding: ".concat(String.valueOf(str)));
                    a(g.OPEN, "Non-mraid URL is invalid");
                    return false;
                }
            }
            if (CampaignEx.JSON_KEY_MRAID.equals(scheme)) {
                final g a2 = g.a(host);
                try {
                    Map<String, String> a3 = a(parse);
                    if (a2.a(this.e)) {
                        if (!d()) {
                            throw new d("Cannot execute this command unless the user clicks");
                        }
                    }
                    if (this.a == null) {
                        throw new d("Invalid state to execute this command");
                    } else if (this.g != null) {
                        switch (a2) {
                            case CLOSE:
                                this.a.f();
                                break;
                            case RESIZE:
                                int a4 = a(f(a3.get("width")), 0);
                                int a5 = a(f(a3.get("height")), 0);
                                int a6 = a(f(a3.get("offsetX")), -100000);
                                int a7 = a(f(a3.get("offsetY")), -100000);
                                String str3 = a3.get("customClosePosition");
                                a.C0142a aVar3 = a.C0142a.TOP_RIGHT;
                                if (TextUtils.isEmpty(str3)) {
                                    aVar = aVar3;
                                } else {
                                    if (str3.equals("top-left")) {
                                        aVar2 = a.C0142a.TOP_LEFT;
                                    } else if (str3.equals("top-right")) {
                                        aVar2 = a.C0142a.TOP_RIGHT;
                                    } else if (str3.equals(TtmlNode.CENTER)) {
                                        aVar2 = a.C0142a.CENTER;
                                    } else if (str3.equals("bottom-left")) {
                                        aVar2 = a.C0142a.BOTTOM_LEFT;
                                    } else if (str3.equals("bottom-right")) {
                                        aVar2 = a.C0142a.BOTTOM_RIGHT;
                                    } else if (str3.equals("top-center")) {
                                        aVar2 = a.C0142a.TOP_CENTER;
                                    } else if (str3.equals("bottom-center")) {
                                        aVar2 = a.C0142a.BOTTOM_CENTER;
                                    } else {
                                        throw new d("Invalid close position: ".concat(String.valueOf(str3)));
                                    }
                                    aVar = aVar2;
                                }
                                this.a.a(a4, a5, a6, a7, aVar, a(a3.get("allowOffscreen"), true));
                                this.a.b(false);
                                break;
                            case UNLOAD:
                                this.a.e();
                                break;
                            case EXPAND:
                                this.a.a(a3.get("url"), a(a3));
                                break;
                            case USE_CUSTOM_CLOSE:
                                this.a.b(a(a3));
                                break;
                            case OPEN:
                                this.a.a(e(a3.get("url")), this.g.getLastClickPoint());
                                break;
                            case SET_ORIENTATION_PROPERTIES:
                                boolean g2 = g(a3.get("allowOrientationChange"));
                                String str4 = a3.get("forceOrientation");
                                if ("portrait".equals(str4)) {
                                    iVar = i.PORTRAIT;
                                } else if ("landscape".equals(str4)) {
                                    iVar = i.LANDSCAPE;
                                } else if ("none".equals(str4)) {
                                    iVar = i.NONE;
                                } else {
                                    throw new d("Invalid orientation: ".concat(String.valueOf(str4)));
                                }
                                this.a.a(g2, iVar);
                                break;
                            case PLAY_VIDEO:
                                this.a.a(e(a3.get("uri")));
                                break;
                            case STORE_PICTURE:
                                String e2 = e(a3.get("uri"));
                                h hVar = this.f;
                                Context context = this.g.getContext();
                                AnonymousClass5 r7 = new h.c() {
                                    public final void a(d dVar) {
                                        c.this.a(a2, dVar.getMessage());
                                    }
                                };
                                if (h.c(context)) {
                                    if (!(context instanceof Activity)) {
                                        Toast.makeText(context, "Downloading image", 0).show();
                                        hVar.a(context, e2, r7);
                                        break;
                                    } else {
                                        new AlertDialog.Builder(context).setTitle("Save Image").setMessage("Download image to Picture gallery?").setNegativeButton("Cancel", (DialogInterface.OnClickListener) null).setPositiveButton("Okay", new DialogInterface.OnClickListener(context, e2, r7) {
                                            final /* synthetic */ Context a;
                                            final /* synthetic */ String b;
                                            final /* synthetic */ c c;

                                            public final void onClick(
/*
Method generation error in method: sg.bigo.ads.core.mraid.h.3.onClick(android.content.DialogInterface, int):void, dex: classes3.dex
                                            jadx.core.utils.exceptions.JadxRuntimeException: Method args not loaded: sg.bigo.ads.core.mraid.h.3.onClick(android.content.DialogInterface, int):void, class status: UNLOADED
                                            	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:278)
                                            	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:116)
                                            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:313)
                                            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
                                            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
                                            	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                                            	at java.util.ArrayList.forEach(ArrayList.java:1259)
                                            	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                                            	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                                            	at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:483)
                                            	at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:472)
                                            	at java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                                            	at java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                                            	at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                                            	at java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:485)
                                            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
                                            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
                                            	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:676)
                                            	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:607)
                                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:364)
                                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:231)
                                            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:123)
                                            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:107)
                                            	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:787)
                                            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:728)
                                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:368)
                                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:231)
                                            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:123)
                                            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:107)
                                            	at jadx.core.codegen.InsnGen.addArgDot(InsnGen.java:91)
                                            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:697)
                                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:368)
                                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:231)
                                            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:123)
                                            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:107)
                                            	at jadx.core.codegen.InsnGen.addArgDot(InsnGen.java:91)
                                            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:697)
                                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:368)
                                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:250)
                                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:221)
                                            	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:109)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
                                            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                                            	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                                            	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:156)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                                            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                                            	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                                            	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:142)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                                            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                                            	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                                            	at jadx.core.codegen.RegionGen.makeSwitch(RegionGen.java:298)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:64)
                                            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                                            	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                                            	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:142)
                                            	at jadx.core.codegen.RegionGen.connectElseIf(RegionGen.java:175)
                                            	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:152)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                                            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                                            	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                                            	at jadx.core.codegen.RegionGen.makeTryCatch(RegionGen.java:311)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:68)
                                            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                                            	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                                            	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:142)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                                            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                                            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                                            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                                            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                                            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                                            	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                                            	at jadx.core.codegen.RegionGen.makeTryCatch(RegionGen.java:311)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:68)
                                            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                                            	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:211)
                                            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:204)
                                            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:318)
                                            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
                                            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
                                            	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                                            	at java.util.ArrayList.forEach(ArrayList.java:1259)
                                            	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                                            	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                                            	at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:483)
                                            	at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:472)
                                            	at java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                                            	at java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                                            	at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                                            	at java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:485)
                                            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
                                            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
                                            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:112)
                                            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:78)
                                            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:44)
                                            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:33)
                                            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:21)
                                            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:61)
                                            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
                                            
*/
                                        }).setCancelable(true).show();
                                        break;
                                    }
                                } else {
                                    sg.bigo.ads.common.k.a.a(0, "MraidBridge", "Error downloading file - the device does not have an SD card mounted, or the Android permission is not granted.");
                                    throw new d("Error downloading file  - the device does not have an SD card mounted, or the Android permission is not granted.");
                                }
                            case CREATE_CALENDAR_EVENT:
                                h.a(this.g.getContext(), a3);
                                break;
                            case UNSPECIFIED:
                                throw new d("Unspecified MRAID Javascript command");
                        }
                        c("window.mraidbridge.nativeCallComplete(" + JSONObject.quote(a2.l) + ")");
                        return true;
                    } else {
                        throw new d("The current WebView is being destroyed");
                    }
                } catch (IllegalArgumentException | d e3) {
                    a(a2, e3.getMessage());
                }
            } else {
                o oVar = this.b;
                return oVar != null && oVar.a();
            }
        } catch (Exception e4) {
            e4.printStackTrace();
            return true;
        }
    }
}
