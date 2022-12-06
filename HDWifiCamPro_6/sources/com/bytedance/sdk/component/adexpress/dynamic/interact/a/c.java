package com.bytedance.sdk.component.adexpress.dynamic.interact.a;

import android.view.MotionEvent;
import android.view.View;
import com.bytedance.sdk.component.adexpress.c.b;
import com.bytedance.sdk.component.adexpress.dynamic.interact.d;

/* compiled from: SlideRightTouch */
public class c implements View.OnTouchListener {
    private float a;
    private float b;
    private boolean c;
    private d d;
    private int e;

    public c(d dVar) {
        this(dVar, 5);
    }

    public c(d dVar, int i) {
        this.e = 5;
        this.d = dVar;
        if (i > 0) {
            this.e = i;
        }
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        d dVar;
        int action = motionEvent.getAction();
        if (action == 0) {
            this.a = motionEvent.getX();
        } else if (action != 1) {
            if (action == 2) {
                this.b = motionEvent.getX();
                if (Math.abs(this.b - this.a) > 10.0f) {
                    this.c = true;
                }
            }
        } else if (!this.c) {
            return false;
        } else {
            int b2 = b.b(com.bytedance.sdk.component.adexpress.d.a(), Math.abs(this.b - this.a));
            if (this.b > this.a && b2 > this.e && (dVar = this.d) != null) {
                dVar.a();
            }
        }
        return true;
    }
}
