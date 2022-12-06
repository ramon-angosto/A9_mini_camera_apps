package sg.bigo.ads.ad.interstitial;

import android.app.Activity;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.mbridge.msdk.playercommon.exoplayer2.DefaultRenderersFactory;
import sg.bigo.ads.R;
import sg.bigo.ads.ad.interstitial.AdCountDownButton;
import sg.bigo.ads.api.MediaView;
import sg.bigo.ads.api.a.h;
import sg.bigo.ads.common.utils.a;
import sg.bigo.ads.common.utils.l;
import sg.bigo.ads.common.utils.s;
import sg.bigo.ads.core.adview.f;

public abstract class a extends h {
    public int a = -1;
    protected View b;
    protected f c = new f() {
        public final void a(int i, int i2, int i3, int i4) {
            sg.bigo.ads.common.k.a.a(0, 4, "emptyClick", "emptyClick stop event Propagation");
        }
    };
    public h d;
    protected h e;
    public boolean f = false;
    protected final Handler g = new Handler(Looper.getMainLooper());
    protected String h;
    protected l i;
    protected l j;
    private int p = -1;
    private k s;
    /* access modifiers changed from: private */
    public int t = 0;
    /* access modifiers changed from: private */
    public int u = 0;
    private final Runnable v = new Runnable() {
        public final void run() {
            a.this.e();
        }
    };

    protected a(Activity activity) {
        super(activity);
    }

    static /* synthetic */ double a(int i2, int i3, int i4, int i5) {
        return (double) Math.max(Math.abs(i2 - i4), Math.abs(i3 - i5));
    }

    /* access modifiers changed from: protected */
    public abstract k a();

    public final void a(int i2) {
        this.p = this.a;
        this.a = i2;
    }

    /* access modifiers changed from: protected */
    public final void a(long j2) {
        if (j2 > 0) {
            f();
            this.g.removeCallbacks(this.v);
            this.g.postDelayed(this.v, j2);
            return;
        }
        e();
    }

    /* access modifiers changed from: protected */
    public final void a(TextView textView) {
        if (textView != null) {
            if (TextUtils.isEmpty(this.h)) {
                textView.setVisibility(8);
                return;
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(2, R.id.inter_ad_info);
            layoutParams.addRule(12, 0);
            layoutParams.leftMargin = 18;
            if (Build.VERSION.SDK_INT >= 17) {
                layoutParams.setMarginStart(18);
            }
            layoutParams.bottomMargin = 15;
            TextView textView2 = (TextView) this.n.findViewById(R.id.inter_advertiser);
            textView2.setLayoutParams(layoutParams);
            textView2.setText(this.h);
        }
    }

    /* access modifiers changed from: protected */
    public void a(AdCountDownButton adCountDownButton) {
    }

    /* access modifiers changed from: protected */
    public void b() {
        f fVar;
        ViewGroup viewGroup;
        f fVar2;
        ViewGroup viewGroup2;
        f fVar3;
        ViewGroup viewGroup3;
        super.b();
        if (this.n != null) {
            if (this.f) {
                long a2 = ((long) this.e.a("video_play_page.guided_click_gesture_show_time")) * 1000;
                if (a2 != 0) {
                    this.j = new l(a2) {
                        public final void a() {
                            a.this.q.getLayoutInflater().inflate(R.layout.bigo_ad_view_slide_gesture, a.this.n);
                            View findViewById = a.this.n.findViewById(R.id.slide_gesture_contain);
                            a aVar = a.this;
                            aVar.b = aVar.n.findViewById(R.id.slide_gesture);
                            if (a.this.b != null) {
                                a.this.b.setTag(16);
                                a.this.y().a(a.this.n, findViewById, a.this.x(), 8, a.this.b);
                                a.this.d();
                                View view = a.this.b;
                                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                                alphaAnimation.setDuration(300);
                                AlphaAnimation alphaAnimation2 = new AlphaAnimation(1.0f, 0.0f);
                                alphaAnimation2.setDuration(200);
                                alphaAnimation2.setStartOffset(200);
                                TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, 160.0f, 0.0f);
                                translateAnimation.setDuration(300);
                                AnimationSet animationSet = new AnimationSet(true);
                                animationSet.addAnimation(translateAnimation);
                                animationSet.addAnimation(alphaAnimation);
                                animationSet.setAnimationListener(new a.C0127a(view, alphaAnimation2) {
                                    final /* synthetic */ View a;
                                    final /* synthetic */ AlphaAnimation b;

                                    {
                                        this.a = r1;
                                        this.b = r2;
                                    }

                                    public final void onAnimationEnd(Animation animation) {
                                        this.a.startAnimation(this.b);
                                    }
                                });
                                alphaAnimation2.setAnimationListener(new a.C0127a(animationSet, view) {
                                    final /* synthetic */ AnimationSet a;
                                    final /* synthetic */ View b;

                                    {
                                        this.a = r1;
                                        this.b = r2;
                                    }

                                    public final void onAnimationEnd(Animation animation) {
                                        this.a.setStartOffset(200);
                                        this.b.startAnimation(this.a);
                                    }
                                });
                                view.startAnimation(animationSet);
                                a.this.b.postDelayed(new Runnable() {
                                    public final void run() {
                                        a.this.c();
                                    }
                                }, DefaultRenderersFactory.DEFAULT_ALLOWED_VIDEO_JOINING_TIME_MS);
                            }
                        }

                        public final void a(long j) {
                        }
                    };
                    this.j.c();
                }
            }
            a(0);
            this.s = a();
            ((i) this.k).n().a(this.f);
            if (this.s.a) {
                this.n.setTag(11);
                sg.bigo.ads.ad.a.a.a(this.n, this.n, 1, ((i) this.k).m);
            } else if (this.f) {
                MediaView mediaView = (MediaView) this.n.findViewById(R.id.inter_media);
                mediaView.setTag(5);
                View findViewById = this.n.findViewById(R.id.inter_ad_info);
                findViewById.setTag(18);
                View findViewById2 = this.n.findViewById(R.id.inter_media_container);
                findViewById2.setTag(9);
                if (this.s.f) {
                    viewGroup = this.n;
                    fVar = ((i) this.k).m;
                } else {
                    viewGroup = this.n;
                    fVar = this.c;
                }
                sg.bigo.ads.ad.a.a.a(viewGroup, mediaView, 8, fVar);
                if (this.s.h) {
                    viewGroup2 = this.n;
                    fVar2 = ((i) this.k).m;
                } else {
                    viewGroup2 = this.n;
                    fVar2 = this.c;
                }
                sg.bigo.ads.ad.a.a.a(viewGroup2, findViewById, 8, fVar2);
                if (this.s.g) {
                    viewGroup3 = this.n;
                    fVar3 = ((i) this.k).m;
                } else {
                    viewGroup3 = this.n;
                    fVar3 = this.c;
                }
                sg.bigo.ads.ad.a.a.a(viewGroup3, findViewById2, 8, fVar3);
            }
            a(this.m);
            a(((long) this.s.b) * 1000);
        }
    }

    public void b(int i2) {
        super.b(i2);
        this.h = ((i) this.k).n().f();
        this.e = ((i) this.k).n().c();
        if (this.e != null) {
            this.f = true;
        }
        this.d = ((i) this.k).n().b().p();
    }

    /* access modifiers changed from: protected */
    public final void c() {
        View findViewById;
        if (this.n != null && (findViewById = this.n.findViewById(R.id.slide_gesture_contain)) != null) {
            AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
            alphaAnimation.setDuration(500);
            alphaAnimation.setAnimationListener(new a.C0127a(findViewById) {
                final /* synthetic */ View a;

                {
                    this.a = r1;
                }

                public final void onAnimationEnd(Animation animation) {
                    s.a(this.a);
                }
            });
            findViewById.startAnimation(alphaAnimation);
            findViewById.setVisibility(8);
        }
    }

    /* access modifiers changed from: protected */
    public final void d() {
        View findViewById = this.n.findViewById(R.id.slide_gesture_contain);
        if (findViewById != null) {
            findViewById.setTag(16);
            findViewById.setOnTouchListener(new View.OnTouchListener() {
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    int action = motionEvent.getAction();
                    if (action == 0) {
                        int unused = a.this.t = (int) motionEvent.getX();
                        int unused2 = a.this.u = (int) motionEvent.getY();
                    } else if (action == 1 && a.a(a.this.t, a.this.u, (int) motionEvent.getX(), (int) motionEvent.getY()) > 10.0d) {
                        a.this.c();
                        ((i) a.this.k).m.a(((int) motionEvent.getX()) + view.getLeft(), ((int) motionEvent.getY()) + view.getTop(), 8, ((Integer) view.getTag()).intValue());
                    }
                    return true;
                }
            });
        }
    }

    /* access modifiers changed from: protected */
    public final void e() {
        if (this.m.getVisibility() != 0) {
            this.m.setVisibility(0);
            b.b(this.m);
        }
        if (this.a == 0) {
            this.m.a(this.s.c, (AdCountDownButton.b) null);
        }
    }

    /* access modifiers changed from: protected */
    public final void f() {
        if (this.m.getVisibility() == 0) {
            this.m.clearAnimation();
            this.m.setVisibility(4);
        }
    }

    /* access modifiers changed from: protected */
    public final boolean g() {
        int i2;
        f fVar;
        int i3;
        ViewGroup viewGroup;
        View findViewById;
        View findViewById2;
        if (this.n == null || (i2 = this.a) == 2 || i2 == 8 || !this.s.d) {
            return false;
        }
        this.q.getLayoutInflater().inflate(R.layout.bigo_ad_view_click_guide, this.n);
        View findViewById3 = this.n.findViewById(R.id.click_guide_container);
        if (findViewById3 != null) {
            y().a(this.n, findViewById3, x(), 10, findViewById3);
            findViewById3.setTag(12);
            findViewById3.findViewById(R.id.inter_btn_cta).setTag(17);
            findViewById3.findViewById(R.id.inter_icon).setTag(17);
            if (this.f) {
                i3 = 10;
                if (this.s.i) {
                    viewGroup = this.n;
                } else {
                    viewGroup = this.n;
                    fVar = this.c;
                    sg.bigo.ads.ad.a.a.a(viewGroup, findViewById3, i3, fVar);
                    b.b(findViewById3);
                    findViewById = findViewById3.findViewById(R.id.click_guide);
                    findViewById2 = findViewById3.findViewById(R.id.click_ripple);
                    if (!(findViewById == null || findViewById2 == null)) {
                        RotateAnimation rotateAnimation = new RotateAnimation(0.0f, 10.0f, 1, 0.5f, 1, 0.6f);
                        rotateAnimation.setDuration(200);
                        rotateAnimation.setStartOffset(560);
                        rotateAnimation.setFillAfter(true);
                        RotateAnimation rotateAnimation2 = new RotateAnimation(10.0f, 0.0f, 1, 0.5f, 1, 0.6f);
                        rotateAnimation2.setDuration(240);
                        rotateAnimation2.setFillAfter(true);
                        AnimationSet animationSet = new AnimationSet(false);
                        ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 5.0f, 1.0f, 5.0f, 1, 0.5f, 1, 0.5f);
                        scaleAnimation.setDuration(400);
                        scaleAnimation.setInterpolator(sg.bigo.ads.common.utils.a.a(2));
                        scaleAnimation.setFillAfter(true);
                        animationSet.addAnimation(scaleAnimation);
                        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
                        alphaAnimation.setDuration(400);
                        scaleAnimation.setInterpolator(sg.bigo.ads.common.utils.a.a(2));
                        alphaAnimation.setFillAfter(true);
                        animationSet.addAnimation(alphaAnimation);
                        alphaAnimation.setAnimationListener(new a.C0127a(findViewById2) {
                            final /* synthetic */ View a;

                            {
                                this.a = r1;
                            }

                            public final void onAnimationEnd(Animation animation) {
                                this.a.setVisibility(4);
                            }
                        });
                        rotateAnimation.setAnimationListener(new a.C0127a(findViewById, rotateAnimation2) {
                            final /* synthetic */ View a;
                            final /* synthetic */ Animation b;

                            {
                                this.a = r1;
                                this.b = r2;
                            }

                            public final void onAnimationEnd(Animation animation) {
                                this.a.startAnimation(this.b);
                            }
                        });
                        rotateAnimation2.setAnimationListener(new a.C0127a(findViewById, rotateAnimation, findViewById2, animationSet) {
                            final /* synthetic */ View a;
                            final /* synthetic */ Animation b;
                            final /* synthetic */ View c;
                            final /* synthetic */ AnimationSet d;

                            {
                                this.a = r1;
                                this.b = r2;
                                this.c = r3;
                                this.d = r4;
                            }

                            public final void onAnimationEnd(Animation animation) {
                                this.a.startAnimation(this.b);
                                this.c.setVisibility(0);
                                this.c.startAnimation(this.d);
                            }
                        });
                        findViewById.startAnimation(rotateAnimation);
                    }
                }
            } else {
                viewGroup = this.n;
                i3 = 5;
            }
            fVar = ((i) this.k).m;
            sg.bigo.ads.ad.a.a.a(viewGroup, findViewById3, i3, fVar);
            b.b(findViewById3);
            findViewById = findViewById3.findViewById(R.id.click_guide);
            findViewById2 = findViewById3.findViewById(R.id.click_ripple);
            RotateAnimation rotateAnimation3 = new RotateAnimation(0.0f, 10.0f, 1, 0.5f, 1, 0.6f);
            rotateAnimation3.setDuration(200);
            rotateAnimation3.setStartOffset(560);
            rotateAnimation3.setFillAfter(true);
            RotateAnimation rotateAnimation22 = new RotateAnimation(10.0f, 0.0f, 1, 0.5f, 1, 0.6f);
            rotateAnimation22.setDuration(240);
            rotateAnimation22.setFillAfter(true);
            AnimationSet animationSet2 = new AnimationSet(false);
            ScaleAnimation scaleAnimation2 = new ScaleAnimation(1.0f, 5.0f, 1.0f, 5.0f, 1, 0.5f, 1, 0.5f);
            scaleAnimation2.setDuration(400);
            scaleAnimation2.setInterpolator(sg.bigo.ads.common.utils.a.a(2));
            scaleAnimation2.setFillAfter(true);
            animationSet2.addAnimation(scaleAnimation2);
            AlphaAnimation alphaAnimation2 = new AlphaAnimation(1.0f, 0.0f);
            alphaAnimation2.setDuration(400);
            scaleAnimation2.setInterpolator(sg.bigo.ads.common.utils.a.a(2));
            alphaAnimation2.setFillAfter(true);
            animationSet2.addAnimation(alphaAnimation2);
            alphaAnimation2.setAnimationListener(new a.C0127a(findViewById2) {
                final /* synthetic */ View a;

                {
                    this.a = r1;
                }

                public final void onAnimationEnd(Animation animation) {
                    this.a.setVisibility(4);
                }
            });
            rotateAnimation3.setAnimationListener(new a.C0127a(findViewById, rotateAnimation22) {
                final /* synthetic */ View a;
                final /* synthetic */ Animation b;

                {
                    this.a = r1;
                    this.b = r2;
                }

                public final void onAnimationEnd(Animation animation) {
                    this.a.startAnimation(this.b);
                }
            });
            rotateAnimation22.setAnimationListener(new a.C0127a(findViewById, rotateAnimation3, findViewById2, animationSet2) {
                final /* synthetic */ View a;
                final /* synthetic */ Animation b;
                final /* synthetic */ View c;
                final /* synthetic */ AnimationSet d;

                {
                    this.a = r1;
                    this.b = r2;
                    this.c = r3;
                    this.d = r4;
                }

                public final void onAnimationEnd(Animation animation) {
                    this.a.startAnimation(this.b);
                    this.c.setVisibility(0);
                    this.c.startAnimation(this.d);
                }
            });
            findViewById.startAnimation(rotateAnimation3);
        }
        a(9);
        a(((long) this.s.e) * 1000);
        return true;
    }

    /* access modifiers changed from: protected */
    public final void h() {
        View findViewById;
        if (this.n != null && (findViewById = this.n.findViewById(R.id.click_guide_container)) != null) {
            s.a(findViewById);
        }
    }

    /* access modifiers changed from: protected */
    public final void i() {
        if (this.m.getVisibility() == 0 && this.m.c) {
            j();
        }
    }

    /* access modifiers changed from: protected */
    public final void j() {
        if (k()) {
            super.i();
        }
    }

    /* access modifiers changed from: protected */
    public abstract boolean k();

    /* access modifiers changed from: protected */
    public final int l() {
        switch (this.a) {
            case 1:
                break;
            case 2:
                if (this.p == 5) {
                    return 4;
                }
                break;
            case 3:
                return 3;
            case 5:
            case 6:
                return 4;
            case 7:
            case 8:
                return 5;
            default:
                return 1;
        }
        return 2;
    }

    public void m() {
        if (o()) {
            e();
            h();
        }
    }

    public void n() {
        super.n();
        this.g.removeCallbacksAndMessages((Object) null);
    }

    /* access modifiers changed from: protected */
    public final boolean o() {
        int i2 = this.a;
        return i2 == 2 || i2 == 6 || i2 == 8 || i2 == 9;
    }
}
