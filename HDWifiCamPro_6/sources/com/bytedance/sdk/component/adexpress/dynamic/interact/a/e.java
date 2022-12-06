package com.bytedance.sdk.component.adexpress.dynamic.interact.a;

import android.view.MotionEvent;
import android.view.View;
import com.bytedance.sdk.component.adexpress.dynamic.interact.d;

/* compiled from: TapTouch */
public class e implements View.OnTouchListener {
    private static int c = 10;
    private float a;
    private float b;
    private boolean d;
    private d e;

    public e(d dVar) {
        this.e = dVar;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.a = motionEvent.getX();
            this.b = motionEvent.getY();
        } else if (action != 1) {
            if (action == 2) {
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                if (Math.abs(x - this.a) >= ((float) c) || Math.abs(y - this.b) >= ((float) c)) {
                    this.d = true;
                }
            } else if (action == 3) {
                this.d = false;
            }
        } else if (this.d) {
            this.d = false;
            return false;
        } else {
            float x2 = motionEvent.getX();
            float y2 = motionEvent.getY();
            if (Math.abs(x2 - this.a) >= ((float) c) || Math.abs(y2 - this.b) >= ((float) c)) {
                this.d = false;
            } else {
                d dVar = this.e;
                if (dVar != null) {
                    dVar.a();
                }
            }
        }
        return true;
    }
}
