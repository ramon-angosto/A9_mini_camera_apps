package com.bytedance.sdk.component.adexpress.dynamic.interact.a;

import android.view.MotionEvent;
import android.view.View;
import com.bytedance.sdk.component.adexpress.dynamic.interact.InteractViewContainer;
import com.bytedance.sdk.component.adexpress.dynamic.interact.d;

/* compiled from: LongPressTouch */
public class b implements View.OnTouchListener {
    private float a;
    private float b;
    private long c;
    private boolean d;
    private InteractViewContainer e;
    private d f;

    public b(InteractViewContainer interactViewContainer, d dVar) {
        this.e = interactViewContainer;
        this.f = dVar;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.c = System.currentTimeMillis();
            this.a = motionEvent.getX();
            this.b = motionEvent.getY();
            this.e.c();
        } else if (action != 1) {
            if (action == 2) {
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                if (Math.abs(x - this.a) >= com.bytedance.sdk.component.adexpress.c.b.a(com.bytedance.sdk.component.adexpress.d.a(), 10.0f) || Math.abs(y - this.b) >= com.bytedance.sdk.component.adexpress.c.b.a(com.bytedance.sdk.component.adexpress.d.a(), 10.0f)) {
                    this.d = true;
                    this.e.d();
                }
            }
        } else if (this.d) {
            return false;
        } else {
            if (System.currentTimeMillis() - this.c >= 1500) {
                d dVar = this.f;
                if (dVar != null) {
                    dVar.a();
                }
            } else {
                this.e.d();
            }
        }
        return true;
    }
}
