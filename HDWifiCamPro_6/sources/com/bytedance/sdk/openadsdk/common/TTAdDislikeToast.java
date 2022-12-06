package com.bytedance.sdk.openadsdk.common;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.sdk.openadsdk.core.m;
import com.bytedance.sdk.openadsdk.l.z;

public class TTAdDislikeToast extends FrameLayout {
    private final Handler a;
    /* access modifiers changed from: private */
    public TextView b;

    public TTAdDislikeToast(Context context) {
        this(context, (AttributeSet) null);
    }

    public TTAdDislikeToast(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TTAdDislikeToast(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = new Handler(Looper.getMainLooper());
        setVisibility(8);
        setClickable(false);
        setFocusable(false);
        a(context);
    }

    private void a(Context context) {
        this.b = new TextView(context);
        this.b.setClickable(false);
        this.b.setFocusable(false);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        int b2 = (int) z.b(m.a(), 20.0f);
        int b3 = (int) z.b(m.a(), 12.0f);
        this.b.setPadding(b2, b3, b2, b3);
        this.b.setLayoutParams(layoutParams);
        this.b.setTextColor(-1);
        this.b.setTextSize(16.0f);
        this.b.setGravity(17);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(Color.parseColor("#CC000000"));
        gradientDrawable.setCornerRadius(z.b(m.a(), 6.0f));
        this.b.setBackgroundDrawable(gradientDrawable);
        addView(this.b);
    }

    public void a(final String str) {
        if (!TextUtils.isEmpty(str)) {
            this.a.removeCallbacksAndMessages((Object) null);
            this.a.post(new Runnable() {
                public void run() {
                    if (TTAdDislikeToast.this.b != null) {
                        TTAdDislikeToast.this.b.setText(String.valueOf(str));
                    }
                    TTAdDislikeToast.this.setVisibility(0);
                }
            });
            this.a.postDelayed(new Runnable() {
                public void run() {
                    TTAdDislikeToast.this.setVisibility(8);
                }
            }, 2000);
        }
    }

    public void a() {
        setVisibility(8);
        this.a.removeCallbacksAndMessages((Object) null);
    }

    public void b() {
        setVisibility(8);
        this.a.removeCallbacksAndMessages((Object) null);
    }
}
