package com.bytedance.sdk.component.adexpress.widget;

import android.content.Context;
import android.text.TextUtils;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.sdk.component.utils.t;

public class DynamicUnlockView extends FrameLayout {
    private final TextView a = ((TextView) findViewById(t.e(getContext(), "tt_splash_unlock_text")));
    /* access modifiers changed from: private */
    public final ImageView b = ((ImageView) findViewById(t.e(getContext(), "tt_splash_unlock_go")));
    /* access modifiers changed from: private */
    public final FlowLightView c = ((FlowLightView) findViewById(t.e(getContext(), "tt_splash_arrow_group")));
    /* access modifiers changed from: private */
    public final RotateAnimation d = new RotateAnimation(0.0f, 30.0f, 1, 0.65f, 1, 0.9f);

    public DynamicUnlockView(Context context) {
        super(context);
        inflate(context, t.f(getContext(), "tt_dynamic_splash_interact_unlock"), this);
        this.d.setDuration(300);
        this.d.setRepeatMode(2);
        this.d.setRepeatCount(1);
        this.d.setInterpolator(new LinearInterpolator());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x002e, code lost:
        if (((((18 - 1) * 18) * ((18 * 2) - 1)) % 6) == 0) goto L_0x004f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0039, code lost:
        r4 = r4.toCharArray();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x003e, code lost:
        if (r2 >= r4.length) goto L_0x0049;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0040, code lost:
        r4[r2] = (char) (r4[r2] ^ r2);
        r2 = r2 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x004e, code lost:
        return new java.lang.String(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x004f, code lost:
        r0 = 'J';
        r1 = '7';
     */
    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000c, code lost:
        switch(r1) {
            case 55: goto L_0x0039;
            case 56: goto L_0x004f;
            case 57: goto L_0x0010;
            default: goto L_0x000f;
        };
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0013, code lost:
        switch(1) {
            case 60: goto L_0x0017;
            case 61: goto L_0x0023;
            case 62: goto L_0x0030;
            default: goto L_0x0016;
        };
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0021, code lost:
        if (((((0 - 1) * 0) * ((0 * 2) - 1)) % 6) == 0) goto L_0x0000;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String DynamicUnlockView1667305730929dc(java.lang.String r4) {
        /*
        L_0x0000:
            r0 = 73
            r1 = 96
        L_0x0004:
            r2 = 0
            switch(r0) {
                case 72: goto L_0x004f;
                case 73: goto L_0x0009;
                case 74: goto L_0x000c;
                default: goto L_0x0008;
            }
        L_0x0008:
            goto L_0x0054
        L_0x0009:
            switch(r1) {
                case 94: goto L_0x0000;
                case 95: goto L_0x0010;
                case 96: goto L_0x004f;
                default: goto L_0x000c;
            }
        L_0x000c:
            switch(r1) {
                case 55: goto L_0x0039;
                case 56: goto L_0x004f;
                case 57: goto L_0x0010;
                default: goto L_0x000f;
            }
        L_0x000f:
            goto L_0x0000
        L_0x0010:
            r0 = 18
            r1 = 1
            switch(r1) {
                case 60: goto L_0x0017;
                case 61: goto L_0x0023;
                case 62: goto L_0x0030;
                default: goto L_0x0016;
            }
        L_0x0016:
            goto L_0x004f
        L_0x0017:
            int r3 = 0 - r1
            int r3 = r3 * r2
            r2 = 0
            int r2 = r2 * 2
            int r2 = r2 - r1
            int r3 = r3 * r2
            int r3 = r3 % 6
            if (r3 == 0) goto L_0x0000
        L_0x0023:
            int r2 = 18 - r1
            int r2 = r2 * r0
            r3 = 18
            int r3 = r3 * 2
            int r3 = r3 - r1
            int r2 = r2 * r3
            int r2 = r2 % 6
            if (r2 == 0) goto L_0x004f
        L_0x0030:
            r1 = 99
            int r1 = r1 * r1
            int r0 = r0 * r0
            int r0 = r0 * 34
            int r1 = r1 - r0
            r0 = -1
            goto L_0x0000
        L_0x0039:
            char[] r4 = r4.toCharArray()
        L_0x003d:
            int r0 = r4.length
            if (r2 >= r0) goto L_0x0049
            char r0 = r4[r2]
            r0 = r0 ^ r2
            char r0 = (char) r0
            r4[r2] = r0
            int r2 = r2 + 1
            goto L_0x003d
        L_0x0049:
            java.lang.String r0 = new java.lang.String
            r0.<init>(r4)
            return r0
        L_0x004f:
            r0 = 74
            r1 = 55
            goto L_0x0004
        L_0x0054:
            r0 = 72
            goto L_0x0004
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.adexpress.widget.DynamicUnlockView.DynamicUnlockView1667305730929dc(java.lang.String):java.lang.String");
    }

    /* access modifiers changed from: private */
    public Runnable getHaloAnimation() {
        return new Runnable() {
            public void run() {
                DynamicUnlockView.this.b.startAnimation(DynamicUnlockView.this.d);
                DynamicUnlockView.this.postDelayed(new Runnable() {
                    public void run() {
                        DynamicUnlockView.this.c.a(4);
                    }
                }, 100);
                DynamicUnlockView.this.postDelayed(new Runnable() {
                    public void run() {
                        DynamicUnlockView.this.c.a(4);
                    }
                }, 300);
                DynamicUnlockView dynamicUnlockView = DynamicUnlockView.this;
                dynamicUnlockView.postDelayed(dynamicUnlockView.getHaloAnimation(), 1200);
            }
        };
    }

    public void a() {
        postDelayed(getHaloAnimation(), 300);
    }

    public void b() {
        this.d.cancel();
    }

    public void setText(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "Slide or click to jump to the details page or third-party application";
        }
        TextView textView = this.a;
        if (textView != null) {
            textView.setText(str);
        }
    }
}
