package com.bytedance.sdk.component.adexpress.dynamic.interact.a;

import android.view.MotionEvent;
import android.view.View;
import com.bytedance.sdk.component.adexpress.c.b;

/* compiled from: SlideUpTouch */
public class d implements View.OnTouchListener {
    private float a;
    private float b;
    private boolean c;
    private com.bytedance.sdk.component.adexpress.dynamic.interact.d d;
    private int e;

    public d(com.bytedance.sdk.component.adexpress.dynamic.interact.d dVar, int i) {
        this.d = dVar;
        this.e = i;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        com.bytedance.sdk.component.adexpress.dynamic.interact.d dVar;
        int action = motionEvent.getAction();
        if (action == 0) {
            this.a = motionEvent.getY();
        } else if (action != 1) {
            if (action == 2) {
                this.b = motionEvent.getY();
                if (Math.abs(this.b - this.a) > 10.0f) {
                    this.c = true;
                }
            }
        } else if (!this.c) {
            return false;
        } else {
            int b2 = b.b(com.bytedance.sdk.component.adexpress.d.a(), Math.abs(this.b - this.a));
            if (this.b - this.a < 0.0f && b2 > this.e && (dVar = this.d) != null) {
                dVar.a();
            }
        }
        return true;
    }
}
