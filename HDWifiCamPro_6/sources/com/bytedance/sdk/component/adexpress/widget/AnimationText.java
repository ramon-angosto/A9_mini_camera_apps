package com.bytedance.sdk.component.adexpress.widget;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher;
import com.bytedance.sdk.component.adexpress.dynamic.c.j;
import com.bytedance.sdk.component.utils.t;
import com.bytedance.sdk.component.utils.x;
import java.util.ArrayList;
import java.util.List;

public class AnimationText extends TextSwitcher implements ViewSwitcher.ViewFactory, x.a {
    Animation.AnimationListener a = new Animation.AnimationListener() {
        public void onAnimationRepeat(Animation animation) {
        }

        public void onAnimationStart(Animation animation) {
        }

        public void onAnimationEnd(Animation animation) {
            if (AnimationText.this.f != null) {
                AnimationText.this.f.setText("");
            }
        }
    };
    private List<String> b = new ArrayList();
    private int c = 0;
    private final int d = 1;
    private Context e;
    /* access modifiers changed from: private */
    public TextView f;
    private int g;
    private int h;
    private float i;
    private int j;
    private int k;
    private int l;
    private int m;
    private Handler n = new x(Looper.getMainLooper(), this);

    public AnimationText(Context context, int i2, float f2, int i3, int i4) {
        super(context);
        this.h = i2;
        this.i = f2;
        this.j = i3;
        this.m = i4;
        c();
    }

    private void c() {
        setFactory(this);
    }

    public void setAnimationType(int i2) {
        this.l = i2;
    }

    public void setAnimationDuration(int i2) {
        this.g = i2;
    }

    public void a() {
        int i2 = this.l;
        if (i2 == 1) {
            setInAnimation(getContext(), t.l(this.e, "tt_text_animation_y_in"));
            setOutAnimation(getContext(), t.l(this.e, "tt_text_animation_y_out"));
        } else if (i2 == 0) {
            setInAnimation(getContext(), t.l(this.e, "tt_text_animation_x_in"));
            setOutAnimation(getContext(), t.l(this.e, "tt_text_animation_x_in"));
            getInAnimation().setInterpolator(new LinearInterpolator());
            getOutAnimation().setInterpolator(new LinearInterpolator());
            getInAnimation().setAnimationListener(this.a);
            getOutAnimation().setAnimationListener(this.a);
        }
        this.n.sendEmptyMessage(1);
    }

    public void setAnimationText(List<String> list) {
        this.b = list;
    }

    public void b() {
        List<String> list = this.b;
        if (list != null && list.size() > 0) {
            int i2 = this.c;
            this.c = i2 + 1;
            this.k = i2;
            setText(this.b.get(this.k));
            if (this.c > this.b.size() - 1) {
                this.c = 0;
            }
        }
    }

    public void setTextColor(int i2) {
        this.h = i2;
    }

    public void setTextSize(float f2) {
        this.i = f2;
    }

    public void setMaxLines(int i2) {
        this.j = i2;
    }

    public View makeView() {
        this.f = new TextView(getContext());
        this.f.setTextColor(this.h);
        this.f.setTextSize(this.i);
        this.f.setMaxLines(this.j);
        if (Build.VERSION.SDK_INT >= 17) {
            this.f.setTextAlignment(this.m);
        }
        return this.f;
    }

    public void a(Message message) {
        if (message.what == 1) {
            b();
            this.n.sendEmptyMessageDelayed(1, (long) this.g);
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        try {
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(j.b(this.b.get(this.k), this.i, false)[0], 1073741824), i2);
        } catch (Exception unused) {
            super.onMeasure(i2, i3);
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.n.removeMessages(1);
    }
}
