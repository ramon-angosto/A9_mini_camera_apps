package com.bytedance.sdk.openadsdk.component.f;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.TextView;
import com.bytedance.sdk.component.utils.t;
import com.bytedance.sdk.openadsdk.component.h.a;
import com.bytedance.sdk.openadsdk.component.view.OpenScreenAdBackupView;
import com.bytedance.sdk.openadsdk.core.m;

/* compiled from: TTAppOpenAdTopLayoutHelper */
public class b {
    private static String a = "Skip";
    /* access modifiers changed from: private */
    public final a b;
    private TextView c;
    private TextView d;
    /* access modifiers changed from: private */
    public a e;
    /* access modifiers changed from: private */
    public int f = 0;
    private float g = 5.0f;
    private int h = 0;
    private ValueAnimator i;
    /* access modifiers changed from: private */
    public boolean j;
    private boolean k;

    public b(a aVar) {
        this.b = aVar;
        a = t.a(m.a(), "tt_txt_skip");
    }

    public void a(Activity activity, OpenScreenAdBackupView openScreenAdBackupView) {
        this.c = (TextView) openScreenAdBackupView.findViewById(t.e(activity, "tt_top_dislike"));
        this.d = (TextView) openScreenAdBackupView.findViewById(t.e(activity, "tt_top_skip"));
        this.c.setText(t.a(m.a(), "tt_reward_feedback"));
        d();
    }

    private void d() {
        this.c.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (b.this.e != null) {
                    b.this.e.b(view);
                }
            }
        });
        this.d.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (b.this.e != null && b.this.j) {
                    b.this.e.a(view);
                }
            }
        });
    }

    public void a() {
        int i2 = (int) (this.g * 1000.0f);
        this.i = ValueAnimator.ofInt(new int[]{0, i2});
        this.i.setDuration((long) i2);
        this.i.setInterpolator(new LinearInterpolator());
        this.i.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                b.this.b.a((long) b.this.f);
                b.this.a(intValue);
            }
        });
    }

    public void a(int i2) {
        this.f = i2;
        float f2 = (((float) i2) * 1.0f) / 1000.0f;
        int ceil = (int) Math.ceil((double) (this.g - f2));
        if (ceil <= 0) {
            ceil = 0;
            a aVar = this.e;
            if (aVar != null && !this.k) {
                aVar.a();
                this.k = true;
            }
        }
        String valueOf = String.valueOf(ceil);
        if (f2 >= ((float) this.h)) {
            valueOf = valueOf + " | " + a;
            this.j = true;
        }
        TextView textView = this.d;
        if (textView != null) {
            textView.setText(valueOf);
        }
        a aVar2 = this.e;
        if (aVar2 != null) {
            aVar2.a(ceil, i2);
        }
    }

    public void a(float f2) {
        this.g = f2;
        if (this.g <= 0.0f) {
            this.g = 5.0f;
        }
        a();
    }

    public void a(a aVar) {
        this.e = aVar;
    }

    public ValueAnimator b() {
        return this.i;
    }

    public int c() {
        return this.h;
    }

    public void b(int i2) {
        this.h = i2;
    }
}
