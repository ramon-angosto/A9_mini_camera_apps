package sg.bigo.ads.ad.splash;

import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;
import sg.bigo.ads.R;
import sg.bigo.ads.ad.b;
import sg.bigo.ads.ad.interstitial.AdCountDownButton;
import sg.bigo.ads.ad.interstitial.j;
import sg.bigo.ads.api.Ad;
import sg.bigo.ads.api.AdError;
import sg.bigo.ads.api.AdOptionsView;
import sg.bigo.ads.api.MediaView;
import sg.bigo.ads.api.NativeAd;
import sg.bigo.ads.api.SplashAd;
import sg.bigo.ads.api.SplashAdInteractionListener;
import sg.bigo.ads.api.SplashAdRequest;
import sg.bigo.ads.api.a.h;
import sg.bigo.ads.api.core.c;
import sg.bigo.ads.api.core.g;
import sg.bigo.ads.common.utils.d;
import sg.bigo.ads.common.utils.l;
import sg.bigo.ads.common.utils.o;

public final class b extends sg.bigo.ads.ad.b<SplashAd> implements SplashAd {
    private final sg.bigo.ads.ad.a.b j;
    private ViewGroup k;
    /* access modifiers changed from: private */
    public final a l;
    /* access modifiers changed from: private */
    public boolean m = false;
    /* access modifiers changed from: private */
    public l n;
    /* access modifiers changed from: private */
    public long o;
    private String p;
    private final h q;

    static class a implements SplashAdInteractionListener {
        SplashAdInteractionListener b;

        private a() {
        }

        /* synthetic */ a(byte b2) {
            this();
        }

        public void onAdClicked() {
            SplashAdInteractionListener splashAdInteractionListener = this.b;
            if (splashAdInteractionListener != null) {
                splashAdInteractionListener.onAdClicked();
            }
        }

        public void onAdClosed() {
            SplashAdInteractionListener splashAdInteractionListener = this.b;
            if (splashAdInteractionListener != null) {
                splashAdInteractionListener.onAdClosed();
            }
        }

        public void onAdError(AdError adError) {
            SplashAdInteractionListener splashAdInteractionListener = this.b;
            if (splashAdInteractionListener != null) {
                splashAdInteractionListener.onAdError(adError);
            }
        }

        public void onAdFinished() {
            SplashAdInteractionListener splashAdInteractionListener = this.b;
            if (splashAdInteractionListener != null) {
                splashAdInteractionListener.onAdFinished();
            }
        }

        public void onAdImpression() {
            SplashAdInteractionListener splashAdInteractionListener = this.b;
            if (splashAdInteractionListener != null) {
                splashAdInteractionListener.onAdImpression();
            }
        }

        public void onAdOpened() {
            SplashAdInteractionListener splashAdInteractionListener = this.b;
            if (splashAdInteractionListener != null) {
                splashAdInteractionListener.onAdOpened();
            }
        }

        public void onAdSkipped() {
            SplashAdInteractionListener splashAdInteractionListener = this.b;
            if (splashAdInteractionListener != null) {
                splashAdInteractionListener.onAdSkipped();
            }
        }
    }

    public b(g gVar) {
        super(gVar);
        sg.bigo.ads.ad.a.b a2 = sg.bigo.ads.ad.a.a.a(gVar.a.l(), gVar);
        if (a2 != null) {
            this.j = a2;
            this.q = gVar.a.b().p();
            this.p = gVar.a.f();
            this.l = new a() {
                public final void onAdImpression() {
                    super.onAdImpression();
                    b.a(b.this);
                }
            };
            this.j.setAdInteractionListener(this.l);
            return;
        }
        throw new IllegalArgumentException("Illegal adx type.");
    }

    static /* synthetic */ void a(b bVar) {
        bVar.o = SystemClock.elapsedRealtime();
        ViewGroup viewGroup = bVar.k;
        final AdCountDownButton adCountDownButton = viewGroup != null ? (AdCountDownButton) viewGroup.findViewById(R.id.splash_btn_skip) : null;
        if (adCountDownButton == null) {
            bVar.m = true;
            bVar.l.onAdFinished();
        } else {
            adCountDownButton.setVisibility(0);
            bVar.n = new l(((long) Math.max(0, bVar.q.a("splash_duration"))) * 1000) {
                public final void a() {
                    if (adCountDownButton.c) {
                        adCountDownButton.c();
                    }
                    boolean unused = b.this.m = true;
                    b.this.l.onAdFinished();
                }

                public final void a(long j) {
                    adCountDownButton.a(j);
                }
            };
            int max = Math.max(0, bVar.q.a("splash_close"));
            adCountDownButton.setWithUnit(true);
            adCountDownButton.setTakeoverTickEvent(true);
            adCountDownButton.setShowCloseButtonInCountdown(true);
            adCountDownButton.setOnCloseListener(new AdCountDownButton.a() {
                public final void a() {
                    b.this.n.b();
                    b.this.l.onAdSkipped();
                    c cVar = b.this.b.a;
                    long j = 0;
                    if (b.this.o > 0) {
                        j = SystemClock.elapsedRealtime() - b.this.o;
                    }
                    sg.bigo.ads.core.d.a.a(cVar, 5, j);
                }
            });
            adCountDownButton.a(max, (AdCountDownButton.b) new AdCountDownButton.b() {
                public final void a() {
                    boolean unused = b.this.m = true;
                }
            });
            bVar.n.c();
            if (Build.VERSION.SDK_INT >= 18) {
                adCountDownButton.getViewTreeObserver().addOnWindowFocusChangeListener(new ViewTreeObserver.OnWindowFocusChangeListener() {
                    public final void onWindowFocusChanged(boolean z) {
                        if (z) {
                            if (!adCountDownButton.c) {
                                adCountDownButton.b();
                            }
                            if (b.this.n.e()) {
                                b.this.n.c();
                                return;
                            }
                            return;
                        }
                        if (!adCountDownButton.c) {
                            adCountDownButton.a();
                        }
                        b.this.n.d();
                    }
                });
            }
        }
        final String k2 = bVar.b.b.k();
        sg.bigo.ads.common.f.c.a(3, new Runnable() {
            public final void run() {
                sg.bigo.ads.controller.c.a.a(k2);
                sg.bigo.ads.common.n.a.b(k2);
                String str = k2;
                sg.bigo.ads.common.n.a.a(str, sg.bigo.ads.common.n.a.a(str) + 1);
                sg.bigo.ads.common.n.a.a(k2, System.currentTimeMillis());
            }
        });
    }

    public final void a(final b.a<SplashAd> aVar) {
        super.a(aVar);
        this.j.a((b.a<NativeAd>) new b.a<NativeAd>() {
            public final /* bridge */ /* synthetic */ void a(Ad ad) {
                aVar.a(b.this);
            }

            public final /* synthetic */ void a(Ad ad, int i, String str) {
                if (i == 1006) {
                    sg.bigo.ads.controller.c.a.a(b.this.b.b.k());
                }
                aVar.a(b.this, i, str);
            }
        });
    }

    public final <ValueType> ValueType b(String str, ValueType valuetype) {
        return this.j.b(str, valuetype);
    }

    public final void destroy() {
        super.destroy();
        this.j.destroy();
        l lVar = this.n;
        if (lVar != null) {
            lVar.b();
        }
    }

    public final SplashAd.Style getStyle() {
        h hVar = this.q;
        return hVar.a("splash_orientation") == 1 ? SplashAd.Style.HORIZONTAL : hVar.a("splash_style") == 1 ? SplashAd.Style.VERTICAL_HALFSCREEN : SplashAd.Style.VERTICAL_FULLSCREEN;
    }

    public final boolean isSkippable() {
        return this.m || isExpired() || this.g;
    }

    public final void setAdInteractionListener(SplashAdInteractionListener splashAdInteractionListener) {
        super.setAdInteractionListener(splashAdInteractionListener);
        this.l.b = splashAdInteractionListener;
    }

    public final void showInAdContainer(ViewGroup viewGroup) {
        View findViewById;
        sg.bigo.ads.core.d.a.a(this.b.a);
        if (isExpired() || this.g) {
            b(2000, "The ad is expired.");
            return;
        }
        this.k = viewGroup;
        h hVar = this.q;
        int a2 = hVar.a("splash_orientation");
        int a3 = hVar.a("splash_style");
        int i = R.layout.bigo_ad_splash_style_fullscreen;
        if (a2 == 0 && a3 == 1) {
            i = R.layout.bigo_ad_splash_style_halfscreen;
        }
        viewGroup.removeAllViews();
        View.inflate(viewGroup.getContext(), i, viewGroup);
        viewGroup.setTag(11);
        MediaView mediaView = (MediaView) viewGroup.findViewById(R.id.splash_media);
        AdOptionsView adOptionsView = (AdOptionsView) viewGroup.findViewById(R.id.splash_options);
        sg.bigo.ads.api.b bVar = this.b.d;
        if (bVar instanceof SplashAdRequest) {
            SplashAdRequest splashAdRequest = (SplashAdRequest) bVar;
            TextView textView = (TextView) viewGroup.findViewById(R.id.splash_title);
            if (textView != null) {
                if (TextUtils.isEmpty(splashAdRequest.e)) {
                    textView.setVisibility(8);
                } else {
                    textView.setText(splashAdRequest.e);
                }
            }
            ImageView imageView = (ImageView) viewGroup.findViewById(R.id.splash_icon);
            if (imageView != null) {
                if (splashAdRequest.d == 0) {
                    imageView.setVisibility(8);
                } else {
                    imageView.setImageResource(splashAdRequest.d);
                }
            }
        }
        ArrayList arrayList = new ArrayList();
        TextView textView2 = (TextView) viewGroup.findViewById(R.id.splash_advertiser);
        TextView textView3 = (TextView) viewGroup.findViewById(R.id.splash_adtage);
        if (o.b(this.p)) {
            textView2.setVisibility(8);
        } else {
            textView3.setText("Реклама");
            textView2.setText(this.p);
            textView2.setPadding(d.a(textView2.getContext(), 4), d.a(textView2.getContext(), 1), d.a(textView2.getContext(), 4), d.a(textView2.getContext(), 1));
        }
        Button button = (Button) viewGroup.findViewById(R.id.splash_btn_cta);
        if (button != null) {
            button.setTag(7);
            if (!TextUtils.isEmpty(this.j.getCallToAction())) {
                button.setText(this.j.getCallToAction());
            }
            arrayList.add(button);
            if (a.a(this.q)) {
                button.getLayoutParams().width = d.a(button.getContext(), 333);
            }
        }
        new j(this.j).a(viewGroup);
        this.j.registerViewForInteraction(viewGroup, mediaView, (ImageView) null, adOptionsView, (List<View>) arrayList);
        if (mediaView != null) {
            if (a.a(this.q)) {
                mediaView.getLayoutParams().width = -2;
                mediaView.getLayoutParams().height = -1;
            }
            if (this.j.getCreativeType() == NativeAd.CreativeType.VIDEO) {
                mediaView.getVideoExtendedDelegate().a();
            }
        }
        int a4 = this.q.a("splash_clickable_area");
        if (a4 == 1) {
            sg.bigo.ads.ad.a.a.a(viewGroup, viewGroup, 1, this.j);
        } else if (a4 == 2 && mediaView != null) {
            mediaView.setOnTouchListener((View.OnTouchListener) null);
        }
        int a5 = this.q.a("splash_cta_type");
        if (a5 == 5 && button != null) {
            button.setTextSize(2, 15.0f);
            button.setBackground((Drawable) null);
            View findViewById2 = viewGroup.findViewById(R.id.splash_footer_bg);
            if (findViewById2 != null) {
                findViewById2.setVisibility(0);
                findViewById2.setTag(14);
                sg.bigo.ads.ad.a.a.a(viewGroup, findViewById2, 1, this.j);
            }
        }
        ViewGroup viewGroup2 = (ViewGroup) viewGroup.findViewById(R.id.splash_btn_cta_container);
        if (viewGroup2 != null && (findViewById = viewGroup2.findViewById(R.id.splash_btn_cta)) != null) {
            findViewById.setAlpha(0.0f);
            viewGroup2.post(new Runnable(findViewById, viewGroup2, a5) {
                final /* synthetic */ View a;
                final /* synthetic */ ViewGroup b;
                final /* synthetic */ int c;

                public final void run(
/*
Method generation error in method: sg.bigo.ads.ad.splash.a.1.run():void, dex: classes3.dex
                jadx.core.utils.exceptions.JadxRuntimeException: Method args not loaded: sg.bigo.ads.ad.splash.a.1.run():void, class status: UNLOADED
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
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:250)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:221)
                	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:109)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
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
            });
        }
    }
}
