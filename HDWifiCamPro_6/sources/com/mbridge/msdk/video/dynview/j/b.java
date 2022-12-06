package com.mbridge.msdk.video.dynview.j;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.mbridge.msdk.foundation.tools.k;
import com.mbridge.msdk.foundation.tools.u;
import com.mbridge.msdk.video.dynview.i.b.a;
import com.mbridge.msdk.video.dynview.widget.MBridgeFramLayout;
import com.mbridge.msdk.video.dynview.widget.MBridgeLevelLayoutView;
import com.mbridge.msdk.video.dynview.widget.MBridgeRelativeLayout;
import com.mbridge.msdk.video.dynview.widget.MBridgeTextView;
import com.mbridge.msdk.video.module.MBridgeClickCTAView;

/* compiled from: UIEnergizeWrapper */
public final class b {
    private String a = "mbridge_top_play_bg";
    private String b = "mbridge_top_finger_bg";
    private String c = "mbridge_bottom_play_bg";
    private String d = "mbridge_bottom_finger_bg";
    private String e = "mbridge_tv_count";
    private String f = "mbridge_sound_switch";
    private String g = "mbridge_top_control";
    private String h = "mbridge_tv_title";
    private String i = "mbridge_tv_desc";
    private String j = "mbridge_tv_install";
    private String k = "mbridge_sv_starlevel";
    private String l = "mbridge_tv_cta";
    private String m = "mbridge_native_ec_controller";
    private String n = "mbridge_reward_shape_choice_rl";
    private String o = "#FFFFFF";
    private String p = "#FF000000";
    private String q = "#40000000";
    private String r = "#CAEF79";
    private String s = "#2196F3";
    private String t = "#402196F3";
    private String u = "#8FC31F";
    private String v = "#03A9F4";

    public final void a(View view) {
        if (view != null && (view instanceof MBridgeFramLayout)) {
            MBridgeFramLayout mBridgeFramLayout = (MBridgeFramLayout) view;
            AnimatorSet animatorSet = new AnimatorSet();
            if (view.getContext() != null) {
                ImageView imageView = (ImageView) view.findViewById(a(this.a));
                ImageView imageView2 = (ImageView) view.findViewById(a(this.b));
                ImageView imageView3 = (ImageView) view.findViewById(a(this.c));
                ImageView imageView4 = (ImageView) view.findViewById(a(this.d));
                ObjectAnimator objectAnimator = null;
                ObjectAnimator a2 = imageView != null ? new com.mbridge.msdk.video.dynview.h.b().a(imageView) : null;
                ObjectAnimator b2 = imageView2 != null ? new com.mbridge.msdk.video.dynview.h.b().b(imageView2) : null;
                ObjectAnimator a3 = imageView3 != null ? new com.mbridge.msdk.video.dynview.h.b().a(imageView3) : null;
                if (imageView4 != null) {
                    objectAnimator = new com.mbridge.msdk.video.dynview.h.b().b(imageView4);
                }
                if (a2 != null && a3 != null && b2 != null && objectAnimator != null) {
                    animatorSet.playTogether(new Animator[]{a2, a3, b2, objectAnimator});
                    mBridgeFramLayout.setAnimatorSet(animatorSet);
                }
            }
        }
    }

    public final void a(View view, com.mbridge.msdk.video.dynview.b bVar) {
        String str;
        String str2;
        Context context = view != null ? view.getContext() : null;
        if (context != null && bVar != null) {
            TextView textView = (TextView) view.findViewById(a(this.e));
            if (textView != null) {
                textView.setBackgroundResource(k.a(context, "mbridge_reward_shape_progress", "drawable"));
                textView.setTextColor(Color.parseColor(this.o));
                textView.setTextSize(11.0f);
            }
            TextView textView2 = (TextView) view.findViewById(a("mbridge_reward_click_tv"));
            if (textView2 != null) {
                textView2.setTextSize(20.0f);
                if (textView2 instanceof MBridgeTextView) {
                    ((MBridgeTextView) textView2).setObjectAnimator(new com.mbridge.msdk.video.dynview.h.b().c(textView2));
                }
            }
            if (bVar != null) {
                String str3 = this.p;
                String str4 = this.r;
                float f2 = 1.0f;
                float f3 = 5.0f;
                int i2 = bVar.i();
                if (i2 == 302) {
                    str = this.s;
                    str2 = this.v;
                    str3 = this.o;
                    str4 = this.t;
                    f3 = 10.0f;
                } else if (i2 != 802) {
                    str = this.u;
                    str2 = this.r;
                } else {
                    str = this.o;
                    str3 = this.p;
                    str4 = this.q;
                    f2 = 0.5f;
                    f3 = 25.0f;
                    str2 = str;
                }
                float f4 = f3;
                String str5 = str4;
                float f5 = f2;
                float f6 = f4;
                if (textView2 != null) {
                    textView2.setTextColor(Color.parseColor(str3));
                    a.a(textView2, f5, f6, str5, new String[]{str, str2}, GradientDrawable.Orientation.LEFT_RIGHT);
                }
                if (bVar.f() != null) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) bVar.f().getLayoutParams();
                    layoutParams.setMargins(0, 0, 0, 0);
                    bVar.f().setLayoutParams(layoutParams);
                }
                RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(a(this.g));
                if (relativeLayout == null) {
                    return;
                }
                if (com.mbridge.msdk.video.dynview.a.a.a != 0 || com.mbridge.msdk.video.dynview.a.a.b != 0 || com.mbridge.msdk.video.dynview.a.a.c != 0 || com.mbridge.msdk.video.dynview.a.a.d != 0) {
                    relativeLayout.setVisibility(4);
                    RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) relativeLayout.getLayoutParams();
                    layoutParams2.setMargins(layoutParams2.leftMargin + com.mbridge.msdk.video.dynview.a.a.a, layoutParams2.topMargin + com.mbridge.msdk.video.dynview.a.a.c, layoutParams2.rightMargin + com.mbridge.msdk.video.dynview.a.a.b, layoutParams2.bottomMargin + com.mbridge.msdk.video.dynview.a.a.d);
                    relativeLayout.setLayoutParams(layoutParams2);
                    AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 100.0f);
                    alphaAnimation.setDuration(200);
                    relativeLayout.startAnimation(alphaAnimation);
                    relativeLayout.setVisibility(0);
                }
            }
        }
    }

    public final void b(View view, com.mbridge.msdk.video.dynview.b bVar) {
        Context context;
        int i2;
        if (view != null && bVar != null && (context = view.getContext()) != null) {
            if (bVar.e() == 1) {
                view.setBackground(context.getResources().getDrawable(k.a(context, this.n, "drawable")));
                TextView textView = (TextView) view.findViewById(a(this.h));
                if (textView != null) {
                    textView.setTextColor(Color.parseColor(this.p));
                }
                TextView textView2 = (TextView) view.findViewById(a(this.i));
                if (textView2 != null) {
                    textView2.setTextColor(Color.parseColor(this.p));
                }
                i2 = u.b(context, 2.0f);
            } else {
                i2 = u.b(context, 10.0f);
                view.getBackground().setAlpha(100);
            }
            int b2 = u.b(context, 8.0f);
            TextView textView3 = (TextView) view.findViewById(a(this.j));
            if (textView3 != null) {
                textView3.setTextColor(Color.parseColor(this.o));
                textView3.setTextSize(15.0f);
                if (bVar.f() != null && (bVar.f() instanceof MBridgeClickCTAView)) {
                    ((MBridgeClickCTAView) bVar.f()).setObjectAnimator(new com.mbridge.msdk.video.dynview.h.b().c(textView3));
                }
                String str = this.r;
                a.a(textView3, 1.0f, 5.0f, str, new String[]{this.u, str}, GradientDrawable.Orientation.LEFT_RIGHT);
            }
            if (view.getLayoutParams() == null) {
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams.setMargins(i2, i2, i2, b2);
                layoutParams.height = u.b(context, 60.0f);
                view.setLayoutParams(layoutParams);
            }
        }
    }

    public final void c(View view, com.mbridge.msdk.video.dynview.b bVar) {
        if (view != null && bVar != null) {
            if (view.getContext() != null) {
                MBridgeLevelLayoutView mBridgeLevelLayoutView = (MBridgeLevelLayoutView) view.findViewById(a(this.k));
                if (mBridgeLevelLayoutView != null) {
                    if (bVar.e() == 1) {
                        mBridgeLevelLayoutView.setOrientation(1);
                    } else {
                        mBridgeLevelLayoutView.setOrientation(0);
                    }
                }
                RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(a(this.m));
                if (relativeLayout != null) {
                    if (bVar.e() == 1) {
                        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
                        layoutParams.setMargins(layoutParams.leftMargin + com.mbridge.msdk.video.dynview.a.a.a, layoutParams.topMargin + com.mbridge.msdk.video.dynview.a.a.c, layoutParams.rightMargin + com.mbridge.msdk.video.dynview.a.a.b, layoutParams.bottomMargin + com.mbridge.msdk.video.dynview.a.a.d);
                        relativeLayout.setLayoutParams(layoutParams);
                    } else {
                        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -1);
                        layoutParams2.setMargins(layoutParams2.leftMargin + com.mbridge.msdk.video.dynview.a.a.a, layoutParams2.topMargin + com.mbridge.msdk.video.dynview.a.a.c, layoutParams2.rightMargin + com.mbridge.msdk.video.dynview.a.a.b, layoutParams2.bottomMargin + com.mbridge.msdk.video.dynview.a.a.d);
                        relativeLayout.setLayoutParams(layoutParams2);
                    }
                }
                TextView textView = (TextView) view.findViewById(a(this.l));
                if (textView != null) {
                    textView.setTextColor(Color.parseColor(this.o));
                    textView.setTextSize(25.0f);
                    AnimatorSet animatorSet = new AnimatorSet();
                    animatorSet.playTogether(new Animator[]{new com.mbridge.msdk.video.dynview.h.b().c(textView)});
                    if (view instanceof MBridgeFramLayout) {
                        ((MBridgeFramLayout) view).setAnimatorSet(animatorSet);
                    }
                    if (view instanceof MBridgeRelativeLayout) {
                        ((MBridgeRelativeLayout) view).setAnimatorSet(animatorSet);
                    }
                    String str = this.r;
                    a.a(textView, 1.0f, 5.0f, str, new String[]{this.u, str}, GradientDrawable.Orientation.LEFT_RIGHT);
                }
            }
            new com.mbridge.msdk.video.dynview.h.b().c(view, 500);
        }
    }

    private int a(String str) {
        return k.a(com.mbridge.msdk.foundation.controller.a.e().g(), str, "id");
    }
}
