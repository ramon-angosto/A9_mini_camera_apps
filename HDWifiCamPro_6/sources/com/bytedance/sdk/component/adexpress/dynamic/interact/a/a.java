package com.bytedance.sdk.component.adexpress.dynamic.interact.a;

import android.graphics.RectF;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.sdk.component.adexpress.dynamic.interact.d;
import com.bytedance.sdk.component.utils.l;
import java.lang.ref.SoftReference;

/* compiled from: LimitBrushTapTouch */
public class a implements View.OnTouchListener {
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
    public SoftReference<ViewGroup> j = new SoftReference<>((Object) null);

    public a(d dVar, int i2, final ViewGroup viewGroup) {
        this.d = dVar;
        if (i2 > 0) {
            this.e = i2;
        }
        if (viewGroup != null) {
            viewGroup.post(new Runnable() {
                public void run() {
                    SoftReference unused = a.this.j = new SoftReference(viewGroup);
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
            int i2 = this.e;
            if (abs < ((float) i2) || abs2 < ((float) i2)) {
                long currentTimeMillis = System.currentTimeMillis() - this.g;
                l.b("limittouch", "d:" + currentTimeMillis + " a:" + abs + " b:" + abs2);
                if ((currentTimeMillis < 200 || (abs < 3.0f && abs2 < 3.0f)) && (dVar = this.d) != null) {
                    dVar.a();
                }
            } else {
                d dVar2 = this.d;
                if (dVar2 != null) {
                    dVar2.a();
                }
            }
        }
        return true;
    }
}
