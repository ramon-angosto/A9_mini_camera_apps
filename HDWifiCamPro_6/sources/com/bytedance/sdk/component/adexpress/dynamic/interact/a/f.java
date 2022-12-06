package com.bytedance.sdk.component.adexpress.dynamic.interact.a;

import android.graphics.RectF;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.sdk.component.adexpress.c.b;
import com.bytedance.sdk.component.adexpress.dynamic.interact.d;
import com.bytedance.sdk.component.utils.t;
import java.lang.ref.SoftReference;

/* compiled from: UnlockTapTouch */
public class f implements View.OnTouchListener {
    private static int c = 10;
    private float a;
    private float b;
    private d d;
    private int e = c;
    private RectF f = new RectF();
    private long g = 0;
    private final int h = 200;
    private final int i = 3;
    /* access modifiers changed from: private */
    public SoftReference<View> j = new SoftReference<>((Object) null);

    public f(d dVar, int i2, final ViewGroup viewGroup) {
        this.d = dVar;
        if (i2 > 0) {
            this.e = i2;
        }
        if (viewGroup != null) {
            viewGroup.post(new Runnable() {
                public void run() {
                    ViewGroup viewGroup = viewGroup;
                    SoftReference unused = f.this.j = new SoftReference(viewGroup.findViewById(t.e(viewGroup.getContext(), "tt_splash_unlock_btn")));
                }
            });
        }
    }

    private RectF a(View view) {
        if (view == null) {
            return new RectF();
        }
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        return new RectF((float) iArr[0], (float) iArr[1], (float) (iArr[0] + view.getWidth()), (float) (iArr[1] + view.getHeight()));
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        d dVar;
        d dVar2;
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f = a(this.j.get());
            this.a = motionEvent.getRawX();
            this.b = motionEvent.getRawY();
            this.g = System.currentTimeMillis();
        } else if (action == 1) {
            RectF rectF = this.f;
            if (rectF != null && !rectF.contains(this.a, this.b)) {
                return false;
            }
            float rawX = motionEvent.getRawX();
            float rawY = motionEvent.getRawY();
            float abs = Math.abs(rawX - this.a);
            float abs2 = Math.abs(rawY - this.b);
            int b2 = b.b(com.bytedance.sdk.component.adexpress.d.a(), Math.abs(rawX - this.a));
            int i2 = c;
            if (abs < ((float) i2) || abs2 < ((float) i2)) {
                if ((System.currentTimeMillis() - this.g < 200 || (abs < 3.0f && abs2 < 3.0f)) && (dVar = this.d) != null) {
                    dVar.a();
                }
            } else if (rawX > this.a && b2 > this.e && (dVar2 = this.d) != null) {
                dVar2.a();
            }
        }
        return true;
    }
}
