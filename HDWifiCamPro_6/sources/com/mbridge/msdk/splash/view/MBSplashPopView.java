package com.mbridge.msdk.splash.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.c.b;
import com.mbridge.msdk.foundation.same.c.c;
import com.mbridge.msdk.foundation.tools.p;
import com.mbridge.msdk.foundation.tools.q;
import com.mbridge.msdk.foundation.tools.u;
import com.mbridge.msdk.out.MBridgeIds;
import com.mbridge.msdk.splash.d.d;
import java.util.concurrent.atomic.AtomicInteger;

public class MBSplashPopView extends RelativeLayout {
    public static final int TYPE_POP_DEFAULT = 1;
    public static final int TYPE_POP_LARGE = 4;
    public static final int TYPE_POP_MEDIUM = 3;
    public static final int TYPE_POP_SMALL = 2;
    private static final AtomicInteger c = new AtomicInteger(1);
    View.OnClickListener a;
    View.OnClickListener b;
    /* access modifiers changed from: private */
    public String d;
    /* access modifiers changed from: private */
    public String e;
    private int f;
    /* access modifiers changed from: private */
    public CampaignEx g;
    /* access modifiers changed from: private */
    public d h;
    /* access modifiers changed from: private */
    public ImageView i;
    /* access modifiers changed from: private */
    public ImageView j;
    /* access modifiers changed from: private */
    public ImageView k;
    private ImageView l;
    private TextView m;
    private TextView n;
    /* access modifiers changed from: private */
    public TextView o;
    /* access modifiers changed from: private */
    public int p;
    /* access modifiers changed from: private */
    public Handler q;
    private boolean r;
    private com.mbridge.msdk.click.a s;
    /* access modifiers changed from: private */
    public Runnable t;

    static /* synthetic */ int l(MBSplashPopView mBSplashPopView) {
        int i2 = mBSplashPopView.p;
        mBSplashPopView.p = i2 - 1;
        return i2;
    }

    public MBSplashPopView(Context context, a aVar, d dVar) {
        super(context);
        this.f = 1;
        this.p = -1;
        this.q = new Handler();
        this.r = false;
        this.t = new Runnable() {
            public final void run() {
                if (MBSplashPopView.this.o == null) {
                    return;
                }
                if (MBSplashPopView.this.p == 0) {
                    int unused = MBSplashPopView.this.p = -1;
                    MBSplashPopView.this.g();
                    MBSplashPopView.this.q.removeCallbacks(MBSplashPopView.this.t);
                    if (MBSplashPopView.this.h != null) {
                        MBSplashPopView.this.h.a(new MBridgeIds(MBSplashPopView.this.d, MBSplashPopView.this.e), 5);
                        return;
                    }
                    return;
                }
                MBSplashPopView.l(MBSplashPopView.this);
                MBSplashPopView.this.o.setText(String.valueOf(MBSplashPopView.this.p));
                MBSplashPopView.this.q.postDelayed(MBSplashPopView.this.t, 1000);
            }
        };
        this.a = new View.OnClickListener() {
            public final void onClick(View view) {
                if (MBSplashPopView.this.h != null) {
                    MBSplashPopView mBSplashPopView = MBSplashPopView.this;
                    MBSplashPopView.a(mBSplashPopView, mBSplashPopView.g);
                }
            }
        };
        this.b = new View.OnClickListener() {
            public final void onClick(View view) {
                if (MBSplashPopView.this.p <= 0 && MBSplashPopView.this.h != null) {
                    MBSplashPopView.this.h.a(new MBridgeIds(MBSplashPopView.this.d, MBSplashPopView.this.e), 4);
                }
            }
        };
        if (aVar != null) {
            this.e = aVar.b();
            this.d = aVar.a();
            this.f = aVar.c();
            this.g = aVar.d();
            this.h = dVar;
            a();
            return;
        }
        throw new IllegalArgumentException("Parameters is NULL, can't gen view.");
    }

    public MBSplashPopView(Context context) {
        super(context);
        this.f = 1;
        this.p = -1;
        this.q = new Handler();
        this.r = false;
        this.t = new Runnable() {
            public final void run() {
                if (MBSplashPopView.this.o == null) {
                    return;
                }
                if (MBSplashPopView.this.p == 0) {
                    int unused = MBSplashPopView.this.p = -1;
                    MBSplashPopView.this.g();
                    MBSplashPopView.this.q.removeCallbacks(MBSplashPopView.this.t);
                    if (MBSplashPopView.this.h != null) {
                        MBSplashPopView.this.h.a(new MBridgeIds(MBSplashPopView.this.d, MBSplashPopView.this.e), 5);
                        return;
                    }
                    return;
                }
                MBSplashPopView.l(MBSplashPopView.this);
                MBSplashPopView.this.o.setText(String.valueOf(MBSplashPopView.this.p));
                MBSplashPopView.this.q.postDelayed(MBSplashPopView.this.t, 1000);
            }
        };
        this.a = new View.OnClickListener() {
            public final void onClick(View view) {
                if (MBSplashPopView.this.h != null) {
                    MBSplashPopView mBSplashPopView = MBSplashPopView.this;
                    MBSplashPopView.a(mBSplashPopView, mBSplashPopView.g);
                }
            }
        };
        this.b = new View.OnClickListener() {
            public final void onClick(View view) {
                if (MBSplashPopView.this.p <= 0 && MBSplashPopView.this.h != null) {
                    MBSplashPopView.this.h.a(new MBridgeIds(MBSplashPopView.this.d, MBSplashPopView.this.e), 4);
                }
            }
        };
        this.f = 1;
        q.b("MBSplashPopView", "Please call setPopViewType() to init.");
    }

    public MBSplashPopView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f = 1;
        this.p = -1;
        this.q = new Handler();
        this.r = false;
        this.t = new Runnable() {
            public final void run() {
                if (MBSplashPopView.this.o == null) {
                    return;
                }
                if (MBSplashPopView.this.p == 0) {
                    int unused = MBSplashPopView.this.p = -1;
                    MBSplashPopView.this.g();
                    MBSplashPopView.this.q.removeCallbacks(MBSplashPopView.this.t);
                    if (MBSplashPopView.this.h != null) {
                        MBSplashPopView.this.h.a(new MBridgeIds(MBSplashPopView.this.d, MBSplashPopView.this.e), 5);
                        return;
                    }
                    return;
                }
                MBSplashPopView.l(MBSplashPopView.this);
                MBSplashPopView.this.o.setText(String.valueOf(MBSplashPopView.this.p));
                MBSplashPopView.this.q.postDelayed(MBSplashPopView.this.t, 1000);
            }
        };
        this.a = new View.OnClickListener() {
            public final void onClick(View view) {
                if (MBSplashPopView.this.h != null) {
                    MBSplashPopView mBSplashPopView = MBSplashPopView.this;
                    MBSplashPopView.a(mBSplashPopView, mBSplashPopView.g);
                }
            }
        };
        this.b = new View.OnClickListener() {
            public final void onClick(View view) {
                if (MBSplashPopView.this.p <= 0 && MBSplashPopView.this.h != null) {
                    MBSplashPopView.this.h.a(new MBridgeIds(MBSplashPopView.this.d, MBSplashPopView.this.e), 4);
                }
            }
        };
        this.f = 1;
        q.b("MBSplashPopView", "Please call setPopViewType() to init.");
    }

    public MBSplashPopView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f = 1;
        this.p = -1;
        this.q = new Handler();
        this.r = false;
        this.t = new Runnable() {
            public final void run() {
                if (MBSplashPopView.this.o == null) {
                    return;
                }
                if (MBSplashPopView.this.p == 0) {
                    int unused = MBSplashPopView.this.p = -1;
                    MBSplashPopView.this.g();
                    MBSplashPopView.this.q.removeCallbacks(MBSplashPopView.this.t);
                    if (MBSplashPopView.this.h != null) {
                        MBSplashPopView.this.h.a(new MBridgeIds(MBSplashPopView.this.d, MBSplashPopView.this.e), 5);
                        return;
                    }
                    return;
                }
                MBSplashPopView.l(MBSplashPopView.this);
                MBSplashPopView.this.o.setText(String.valueOf(MBSplashPopView.this.p));
                MBSplashPopView.this.q.postDelayed(MBSplashPopView.this.t, 1000);
            }
        };
        this.a = new View.OnClickListener() {
            public final void onClick(View view) {
                if (MBSplashPopView.this.h != null) {
                    MBSplashPopView mBSplashPopView = MBSplashPopView.this;
                    MBSplashPopView.a(mBSplashPopView, mBSplashPopView.g);
                }
            }
        };
        this.b = new View.OnClickListener() {
            public final void onClick(View view) {
                if (MBSplashPopView.this.p <= 0 && MBSplashPopView.this.h != null) {
                    MBSplashPopView.this.h.a(new MBridgeIds(MBSplashPopView.this.d, MBSplashPopView.this.e), 4);
                }
            }
        };
        this.f = 1;
        q.b("MBSplashPopView", "Please call setPopViewType() to init.");
    }

    public MBSplashPopView(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
        this.f = 1;
        this.p = -1;
        this.q = new Handler();
        this.r = false;
        this.t = new Runnable() {
            public final void run() {
                if (MBSplashPopView.this.o == null) {
                    return;
                }
                if (MBSplashPopView.this.p == 0) {
                    int unused = MBSplashPopView.this.p = -1;
                    MBSplashPopView.this.g();
                    MBSplashPopView.this.q.removeCallbacks(MBSplashPopView.this.t);
                    if (MBSplashPopView.this.h != null) {
                        MBSplashPopView.this.h.a(new MBridgeIds(MBSplashPopView.this.d, MBSplashPopView.this.e), 5);
                        return;
                    }
                    return;
                }
                MBSplashPopView.l(MBSplashPopView.this);
                MBSplashPopView.this.o.setText(String.valueOf(MBSplashPopView.this.p));
                MBSplashPopView.this.q.postDelayed(MBSplashPopView.this.t, 1000);
            }
        };
        this.a = new View.OnClickListener() {
            public final void onClick(View view) {
                if (MBSplashPopView.this.h != null) {
                    MBSplashPopView mBSplashPopView = MBSplashPopView.this;
                    MBSplashPopView.a(mBSplashPopView, mBSplashPopView.g);
                }
            }
        };
        this.b = new View.OnClickListener() {
            public final void onClick(View view) {
                if (MBSplashPopView.this.p <= 0 && MBSplashPopView.this.h != null) {
                    MBSplashPopView.this.h.a(new MBridgeIds(MBSplashPopView.this.d, MBSplashPopView.this.e), 4);
                }
            }
        };
        this.f = 1;
        q.b("MBSplashPopView", "Please call setPopViewType() to init.");
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        d dVar = this.h;
        if (dVar != null) {
            dVar.a(new MBridgeIds(this.d, this.e), getWidth(), getHeight(), this.f);
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        release();
    }

    public void setPopViewType(a aVar, d dVar) {
        if (aVar != null) {
            this.e = aVar.b();
            this.d = aVar.a();
            this.f = aVar.c();
            this.g = aVar.d();
            this.h = dVar;
            a();
            return;
        }
        throw new IllegalArgumentException("Parameters is NULL, can't gen view.");
    }

    public void startCountDown() {
        this.q.removeCallbacks(this.t);
        CampaignEx campaignEx = this.g;
        if (campaignEx != null && this.f == 1) {
            int flbSkipTime = campaignEx.getFlbSkipTime();
            if (flbSkipTime > 0) {
                this.p = flbSkipTime;
                TextView textView = this.o;
                if (textView != null) {
                    textView.setText(String.valueOf(this.p));
                    this.q.postDelayed(this.t, 1000);
                    return;
                }
                return;
            }
            g();
        }
    }

    public void reStartCountDown() {
        if (this.r) {
            this.r = false;
            int i2 = this.p;
            if (i2 == -1 || i2 == 0) {
                g();
                return;
            }
            TextView textView = this.o;
            if (textView != null) {
                textView.setText(String.valueOf(i2));
                this.q.postDelayed(this.t, 1000);
            }
        }
    }

    public void pauseCountDown() {
        this.r = true;
        if (this.o != null) {
            this.q.removeCallbacks(this.t);
        }
    }

    public void release() {
        try {
            this.q.removeCallbacks(this.t);
            this.t = null;
            detachAllViewsFromParent();
            this.g = null;
            this.h = null;
        } catch (Exception e2) {
            q.d("MBSplashPopView", e2.getMessage());
        }
    }

    private void a() {
        if (this.g != null) {
            setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
            int i2 = this.f;
            if (i2 == 1) {
                b();
            } else if (i2 == 2) {
                c();
            } else if (i2 == 3) {
                d();
            } else if (i2 == 4) {
                e();
            }
        }
    }

    private void b() {
        ImageView imageView = new ImageView(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(u.b(getContext(), 80.0f), u.b(getContext(), 80.0f));
        layoutParams.addRule(9);
        layoutParams.topMargin = u.b(getContext(), 16.0f);
        imageView.setId(generateViewId());
        imageView.setLayoutParams(layoutParams);
        imageView.setBackgroundResource(getResources().getIdentifier("mbridge_splash_popview_default", "drawable", com.mbridge.msdk.foundation.controller.a.e().b()));
        this.i = new ImageView(getContext());
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(u.b(getContext(), 60.0f), u.b(getContext(), 60.0f));
        layoutParams2.addRule(6, imageView.getId());
        layoutParams2.topMargin = u.b(getContext(), 7.0f);
        layoutParams2.leftMargin = u.b(getContext(), 10.0f);
        this.i.setId(generateViewId());
        this.i.setLayoutParams(layoutParams2);
        this.i.setScaleType(ImageView.ScaleType.FIT_CENTER);
        CampaignEx campaignEx = this.g;
        if (campaignEx != null && !TextUtils.isEmpty(campaignEx.getIconUrl())) {
            a(this.g.getIconUrl(), true);
        }
        this.o = new TextView(getContext());
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams3.addRule(5, imageView.getId());
        layoutParams3.addRule(8, imageView.getId());
        layoutParams3.leftMargin = u.b(getContext(), 62.0f);
        layoutParams3.bottomMargin = u.b(getContext(), 70.0f);
        this.o.setId(generateViewId());
        this.o.setTextSize(10.0f);
        this.o.setTextColor(-1);
        this.o.setGravity(17);
        this.o.setMinWidth(u.b(getContext(), 16.0f));
        this.o.setMaxHeight(u.b(getContext(), 16.0f));
        this.o.setLayoutParams(layoutParams3);
        this.o.setBackgroundResource(getResources().getIdentifier("mbridge_cm_circle_50black", "drawable", com.mbridge.msdk.foundation.controller.a.e().b()));
        addView(imageView);
        addView(this.o);
        addView(this.i);
        CampaignEx campaignEx2 = this.g;
        if (campaignEx2 != null && campaignEx2.getFlbSkipTime() <= 0) {
            g();
        }
        setOnClickListener(this.a);
        this.o.setOnClickListener(this.b);
    }

    private void c() {
        int b2 = u.b(getContext(), 4.0f);
        this.i = new ImageView(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(u.b(getContext(), 28.0f), u.b(getContext(), 28.0f));
        layoutParams.addRule(9);
        this.i.setId(generateViewId());
        this.i.setLayoutParams(layoutParams);
        this.i.setPadding(b2, b2, b2, b2);
        this.i.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        a(this.g.getIconUrl(), false);
        this.m = new TextView(getContext());
        this.m.setId(generateViewId());
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(1, this.i.getId());
        layoutParams2.addRule(6, this.i.getId());
        layoutParams2.addRule(8, this.i.getId());
        layoutParams2.leftMargin = u.b(getContext(), 4.0f);
        layoutParams2.rightMargin = u.b(getContext(), 40.0f);
        this.m.setLayoutParams(layoutParams2);
        this.m.setGravity(16);
        this.m.setTextSize(10.0f);
        this.m.setSelected(true);
        this.m.setEllipsize(TextUtils.TruncateAt.MARQUEE);
        this.m.setMarqueeRepeatLimit(-1);
        this.m.setSingleLine(true);
        this.m.setTextColor(-16777216);
        this.m.setText(this.g.getAppName());
        setBackgroundResource(getResources().getIdentifier("mbridge_shape_corners_bg", "drawable", com.mbridge.msdk.foundation.controller.a.e().b()));
        addView(this.i);
        addView(this.m);
        f();
        setOnClickListener(this.a);
    }

    private void d() {
        int b2 = u.b(getContext(), 4.0f);
        this.i = new ImageView(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(u.b(getContext(), 50.0f), u.b(getContext(), 50.0f));
        layoutParams.addRule(9);
        this.i.setId(generateViewId());
        this.i.setLayoutParams(layoutParams);
        this.i.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.i.setPadding(b2, b2, b2, b2);
        a(this.g.getIconUrl(), false);
        RelativeLayout relativeLayout = new RelativeLayout(getContext());
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams2.addRule(1, this.i.getId());
        layoutParams2.addRule(6, this.i.getId());
        layoutParams2.addRule(8, this.i.getId());
        layoutParams2.leftMargin = u.b(getContext(), 8.0f);
        layoutParams2.rightMargin = u.b(getContext(), 8.0f);
        relativeLayout.setLayoutParams(layoutParams2);
        relativeLayout.setGravity(16);
        this.m = new TextView(getContext());
        this.m.setId(generateViewId());
        this.m.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
        this.m.setGravity(16);
        this.m.setTextSize(12.0f);
        this.m.setSelected(true);
        this.m.setEllipsize(TextUtils.TruncateAt.MARQUEE);
        this.m.setMarqueeRepeatLimit(-1);
        this.m.setSingleLine(true);
        this.m.setTextColor(-16777216);
        this.m.setText(this.g.getAppName());
        this.n = new TextView(getContext());
        this.n.setId(generateViewId());
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams3.addRule(5, this.m.getId());
        layoutParams3.addRule(3, this.m.getId());
        layoutParams3.topMargin = u.b(getContext(), 4.0f);
        layoutParams3.rightMargin = u.b(getContext(), 36.0f);
        this.n.setGravity(16);
        this.n.setLayoutParams(layoutParams3);
        this.n.setTextSize(8.0f);
        this.n.setTextColor(-10066330);
        this.n.setEllipsize(TextUtils.TruncateAt.MARQUEE);
        this.n.setMarqueeRepeatLimit(-1);
        this.n.setSelected(true);
        this.n.setSingleLine(true);
        this.n.setText(this.g.getAppDesc());
        relativeLayout.addView(this.m);
        relativeLayout.addView(this.n);
        setBackgroundResource(getResources().getIdentifier("mbridge_shape_corners_bg", "drawable", com.mbridge.msdk.foundation.controller.a.e().b()));
        addView(this.i);
        addView(relativeLayout);
        f();
        setOnClickListener(this.a);
    }

    private void e() {
        this.k = new ImageView(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, u.b(getContext(), 131.0f));
        layoutParams.addRule(10);
        layoutParams.addRule(14);
        this.k.setScaleType(ImageView.ScaleType.FIT_XY);
        this.k.setId(generateViewId());
        this.k.setLayoutParams(layoutParams);
        a(this.g.getImageUrl());
        this.j = new ImageView(getContext());
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, u.b(getContext(), 131.0f));
        layoutParams2.addRule(10);
        layoutParams2.addRule(14);
        this.j.setScaleType(ImageView.ScaleType.FIT_CENTER);
        this.j.setId(generateViewId());
        this.j.setLayoutParams(layoutParams2);
        b(this.g.getImageUrl());
        this.i = new ImageView(getContext());
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(u.b(getContext(), 50.0f), u.b(getContext(), 50.0f));
        layoutParams3.addRule(9);
        layoutParams3.addRule(3, this.k.getId());
        layoutParams3.topMargin = 20;
        this.i.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.i.setId(generateViewId());
        this.i.setLayoutParams(layoutParams3);
        a(this.g.getIconUrl(), false);
        RelativeLayout relativeLayout = new RelativeLayout(getContext());
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams4.addRule(1, this.i.getId());
        layoutParams4.addRule(6, this.i.getId());
        layoutParams4.addRule(8, this.i.getId());
        layoutParams4.leftMargin = u.b(getContext(), 8.0f);
        layoutParams4.rightMargin = u.b(getContext(), 8.0f);
        relativeLayout.setLayoutParams(layoutParams4);
        relativeLayout.setGravity(16);
        this.m = new TextView(getContext());
        this.m.setId(generateViewId());
        this.m.setGravity(16);
        this.m.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
        this.m.setTextSize(12.0f);
        this.m.setTextColor(-16777216);
        this.m.setEllipsize(TextUtils.TruncateAt.MARQUEE);
        this.m.setMarqueeRepeatLimit(-1);
        this.m.setSelected(true);
        this.m.setSingleLine(true);
        this.m.setText(this.g.getAppName());
        this.n = new TextView(getContext());
        this.n.setId(generateViewId());
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams5.addRule(5, this.m.getId());
        layoutParams5.addRule(3, this.m.getId());
        layoutParams5.topMargin = u.b(getContext(), 4.0f);
        layoutParams5.rightMargin = u.b(getContext(), 36.0f);
        this.n.setGravity(16);
        this.n.setLayoutParams(layoutParams5);
        this.n.setTextSize(8.0f);
        this.n.setTextColor(-10066330);
        this.n.setEllipsize(TextUtils.TruncateAt.MARQUEE);
        this.n.setMarqueeRepeatLimit(-1);
        this.n.setSelected(true);
        this.n.setSingleLine(true);
        this.n.setText(this.g.getAppDesc());
        relativeLayout.addView(this.m);
        relativeLayout.addView(this.n);
        addView(this.k);
        addView(this.j);
        addView(this.i);
        addView(relativeLayout);
        f();
        setOnClickListener(this.a);
    }

    private void f() {
        String str;
        int i2;
        this.l = new ImageView(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(u.b(getContext(), 32.0f), u.b(getContext(), 13.0f));
        layoutParams.addRule(11);
        layoutParams.addRule(8, this.i.getId());
        this.l.setLayoutParams(layoutParams);
        try {
            str = getResources().getConfiguration().locale.getLanguage();
        } catch (Throwable th) {
            q.d("MBSplashPopView", th.getMessage());
            str = "ZH";
        }
        if (str.toUpperCase().equals("CN") || str.toUpperCase().equals("ZH")) {
            i2 = getResources().getIdentifier("mbridge_splash_ad", "drawable", com.mbridge.msdk.foundation.controller.a.e().b());
        } else {
            i2 = getResources().getIdentifier("mbridge_splash_ad_en", "drawable", com.mbridge.msdk.foundation.controller.a.e().b());
        }
        this.l.setBackgroundResource(i2);
        addView(this.l);
    }

    private void a(String str, final boolean z) {
        b.a(com.mbridge.msdk.foundation.controller.a.e().g()).a(str, (c) new c() {
            public final void onSuccessLoad(Bitmap bitmap, String str) {
                Bitmap bitmap2;
                try {
                    if (!bitmap.isRecycled()) {
                        if (z) {
                            int width = bitmap.getWidth();
                            Bitmap createBitmap = Bitmap.createBitmap(width, width, Bitmap.Config.ARGB_8888);
                            Canvas canvas = new Canvas(createBitmap);
                            Paint paint = new Paint();
                            paint.setAntiAlias(true);
                            canvas.drawCircle((float) (width / 2), (float) (width / 2), (float) (width / 2), paint);
                            paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
                            canvas.drawBitmap(bitmap, 0.0f, 0.0f, paint);
                            bitmap2 = createBitmap;
                        } else {
                            bitmap2 = p.a(bitmap, 1, 16);
                        }
                        ImageView a2 = MBSplashPopView.this.i;
                        if (bitmap2 != null) {
                            bitmap = bitmap2;
                        }
                        a2.setImageBitmap(bitmap);
                    }
                } catch (Throwable th) {
                    q.d("MBSplashPopView", th.getMessage());
                }
            }

            public final void onFailedLoad(String str, String str2) {
                q.d("MBSplashPopView", str);
            }
        });
    }

    private void a(String str) {
        b.a(com.mbridge.msdk.foundation.controller.a.e().g()).a(str, (c) new c() {
            public final void onSuccessLoad(Bitmap bitmap, String str) {
                try {
                    if (!bitmap.isRecycled()) {
                        MBSplashPopView.this.k.setImageBitmap(com.mbridge.msdk.splash.a.a.a.a(bitmap, 10));
                    }
                } catch (Throwable th) {
                    q.d("MBSplashPopView", th.getMessage());
                }
            }

            public final void onFailedLoad(String str, String str2) {
                q.d("MBSplashPopView", str);
            }
        });
    }

    private void b(String str) {
        b.a(com.mbridge.msdk.foundation.controller.a.e().g()).a(str, (c) new c() {
            public final void onSuccessLoad(Bitmap bitmap, String str) {
                try {
                    if (!bitmap.isRecycled()) {
                        MBSplashPopView.this.j.setImageBitmap(p.a(bitmap, 1, 16));
                    }
                } catch (Throwable th) {
                    q.d("MBSplashPopView", th.getMessage());
                }
            }

            public final void onFailedLoad(String str, String str2) {
                q.d("MBSplashPopView", str);
            }
        });
    }

    public static int generateViewId() {
        int i2;
        int i3;
        do {
            i2 = c.get();
            i3 = i2 + 1;
            if (i3 > 16777215) {
                i3 = 1;
            }
        } while (!c.compareAndSet(i2, i3));
        return i2;
    }

    /* access modifiers changed from: private */
    public void g() {
        TextView textView = this.o;
        if (textView != null) {
            ViewGroup.LayoutParams layoutParams = textView.getLayoutParams();
            layoutParams.width = u.b(getContext(), 16.0f);
            layoutParams.height = u.b(getContext(), 16.0f);
            this.o.setLayoutParams(layoutParams);
            this.o.setText("");
            this.o.setBackgroundResource(getResources().getIdentifier("mbridge_splash_popview_close", "drawable", com.mbridge.msdk.foundation.controller.a.e().b()));
        }
    }

    public static class a {
        private String a;
        private String b;
        private int c;
        private CampaignEx d;

        public a(String str, String str2, int i, CampaignEx campaignEx) {
            this.a = str;
            this.b = str2;
            this.c = i;
            this.d = campaignEx;
        }

        public final String a() {
            return this.a;
        }

        public final String b() {
            return this.b;
        }

        public final int c() {
            return this.c;
        }

        public final CampaignEx d() {
            return this.d;
        }
    }

    static /* synthetic */ void a(MBSplashPopView mBSplashPopView, CampaignEx campaignEx) {
        if (mBSplashPopView.s == null) {
            mBSplashPopView.s = new com.mbridge.msdk.click.a(com.mbridge.msdk.foundation.controller.a.e().g(), mBSplashPopView.e);
        }
        campaignEx.setCampaignUnitId(mBSplashPopView.e);
        mBSplashPopView.s.a(campaignEx);
        if (!campaignEx.isReportClick()) {
            campaignEx.setReportClick(true);
            com.mbridge.msdk.splash.e.a.a(com.mbridge.msdk.foundation.controller.a.e().g(), campaignEx);
            com.mbridge.msdk.splash.e.a.b(campaignEx, mBSplashPopView.e);
        }
        d dVar = mBSplashPopView.h;
        if (dVar != null) {
            dVar.b(new MBridgeIds(mBSplashPopView.d, mBSplashPopView.e));
            mBSplashPopView.h.a(new MBridgeIds(mBSplashPopView.d, mBSplashPopView.e), 6);
        }
    }
}
