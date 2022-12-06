package com.bytedance.sdk.openadsdk.core.bannerexpress;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.api.banner.PAGBannerAdWrapperListener;
import com.bytedance.sdk.openadsdk.core.h;
import com.bytedance.sdk.openadsdk.core.model.n;
import com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView;
import com.bytedance.sdk.openadsdk.l.z;

public class BannerExpressView extends FrameLayout {
    protected final Context a;
    protected NativeExpressView b;
    protected NativeExpressView c;
    protected n d;
    protected AdSlot e;
    protected PAGBannerAdWrapperListener f;
    protected int g;
    protected boolean h;
    protected String i = "banner_ad";

    public BannerExpressView(Context context, n nVar, AdSlot adSlot) {
        super(context);
        this.a = context;
        this.d = nVar;
        this.e = adSlot;
        a();
    }

    /* access modifiers changed from: protected */
    public void a() {
        this.b = new NativeExpressView(this.a, this.d, this.e, this.i);
        addView(this.b, new ViewGroup.LayoutParams(-1, -1));
    }

    public void a(n nVar, AdSlot adSlot) {
        this.c = new NativeExpressView(this.a, nVar, adSlot, this.i);
        this.c.setExpressInteractionListener(new PAGBannerAdWrapperListener() {
            public void onAdDismissed() {
            }

            public void onAdShow(View view, int i) {
            }

            public void onRenderFail(View view, String str, int i) {
            }

            public void onAdClicked(View view, int i) {
                if (BannerExpressView.this.f != null) {
                    BannerExpressView.this.f.onAdClicked(BannerExpressView.this, i);
                }
            }

            public void onRenderSuccess(View view, float f, float f2) {
                BannerExpressView.this.a(f, f2);
                if (BannerExpressView.this.c != null) {
                    BannerExpressView.this.c.setSoundMute(true);
                }
                BannerExpressView.this.e();
            }
        });
        z.a((View) this.c, 8);
        addView(this.c, new ViewGroup.LayoutParams(-1, -1));
    }

    public void setExpressInteractionListener(PAGBannerAdWrapperListener pAGBannerAdWrapperListener) {
        this.f = pAGBannerAdWrapperListener;
        NativeExpressView nativeExpressView = this.b;
        if (nativeExpressView != null) {
            nativeExpressView.setExpressInteractionListener(new PAGBannerAdWrapperListener() {
                public void onAdDismissed() {
                }

                public void onAdShow(View view, int i) {
                }

                public void onAdClicked(View view, int i) {
                    if (BannerExpressView.this.f != null) {
                        BannerExpressView.this.f.onAdClicked(BannerExpressView.this, i);
                    }
                }

                public void onRenderFail(View view, String str, int i) {
                    if (BannerExpressView.this.f != null) {
                        BannerExpressView.this.f.onRenderFail(BannerExpressView.this, str, i);
                    }
                }

                public void onRenderSuccess(View view, float f, float f2) {
                    if (BannerExpressView.this.b != null) {
                        BannerExpressView.this.b.setSoundMute(true);
                    }
                    BannerExpressView.this.a(f, f2);
                    if (BannerExpressView.this.f != null) {
                        BannerExpressView.this.f.onRenderSuccess(BannerExpressView.this, f, f2);
                    }
                }
            });
        }
    }

    /* access modifiers changed from: protected */
    public void a(float f2, float f3) {
        int b2 = (int) z.b(this.a, f2);
        int b3 = (int) z.b(this.a, f3);
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(b2, b3);
        }
        layoutParams.width = b2;
        layoutParams.height = b3;
        setLayoutParams(layoutParams);
    }

    public void b() {
        NativeExpressView nativeExpressView = this.b;
        if (nativeExpressView != null) {
            nativeExpressView.m();
        }
    }

    public void c() {
        if (this.b != null) {
            h.d().f(this.b.getClosedListenerKey());
            removeView(this.b);
            this.b.o();
            this.b = null;
        }
        if (this.c != null) {
            h.d().f(this.c.getClosedListenerKey());
            removeView(this.c);
            this.c.o();
            this.c = null;
        }
        h.d().w();
    }

    public NativeExpressView getCurView() {
        return this.b;
    }

    public NativeExpressView getNextView() {
        return this.c;
    }

    public void setDuration(int i2) {
        this.g = i2;
    }

    private ObjectAnimator a(NativeExpressView nativeExpressView) {
        return ObjectAnimator.ofFloat(nativeExpressView, "translationX", new float[]{0.0f, (float) (-getWidth())});
    }

    private ObjectAnimator b(NativeExpressView nativeExpressView) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(nativeExpressView, "translationX", new float[]{(float) getWidth(), 0.0f});
        ofFloat.addListener(new Animator.AnimatorListener() {
            public void onAnimationCancel(Animator animator) {
            }

            public void onAnimationRepeat(Animator animator) {
            }

            public void onAnimationStart(Animator animator) {
            }

            public void onAnimationEnd(Animator animator) {
                BannerExpressView bannerExpressView = BannerExpressView.this;
                bannerExpressView.h = false;
                bannerExpressView.g();
            }
        });
        return ofFloat;
    }

    public void d() {
        NativeExpressView nativeExpressView = this.c;
        if (nativeExpressView != null) {
            nativeExpressView.m();
        }
    }

    /* access modifiers changed from: protected */
    public void e() {
        try {
            if (!this.h && this.c != null) {
                AnimatorSet animatorSet = new AnimatorSet();
                animatorSet.play(a(this.b)).with(b(this.c));
                animatorSet.setDuration((long) this.g).start();
                z.a((View) this.c, 0);
                this.h = true;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public boolean f() {
        return this.c != null;
    }

    /* access modifiers changed from: private */
    public void g() {
        NativeExpressView nativeExpressView = this.b;
        this.b = this.c;
        this.c = nativeExpressView;
        NativeExpressView nativeExpressView2 = this.c;
        if (nativeExpressView2 != null) {
            removeView(nativeExpressView2);
            this.c.o();
            this.c = null;
        }
    }
}
