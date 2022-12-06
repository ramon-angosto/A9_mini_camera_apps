package com.bytedance.sdk.component.adexpress.dynamic.animation.a;

import android.animation.ObjectAnimator;
import android.view.View;
import java.util.ArrayList;
import java.util.List;

/* compiled from: AlphaAnimation */
public class a extends d {
    public a(View view, com.bytedance.sdk.component.adexpress.dynamic.b.a aVar) {
        super(view, aVar);
    }

    /* access modifiers changed from: package-private */
    public List<ObjectAnimator> a() {
        float r = ((float) this.b.r()) / 100.0f;
        float s = ((float) this.b.s()) / 100.0f;
        if ("reverse".equals(this.b.p()) && this.b.n() <= 0.0d) {
            float f = s;
            s = r;
            r = f;
        }
        this.c.setAlpha(r);
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.c, "alpha", new float[]{r, s}).setDuration((long) ((int) (this.b.j() * 1000.0d)));
        ArrayList arrayList = new ArrayList();
        arrayList.add(a(duration));
        return arrayList;
    }
}
