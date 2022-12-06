package com.bytedance.sdk.component.adexpress.dynamic.animation.a;

import android.animation.ObjectAnimator;
import android.view.View;
import com.bytedance.sdk.component.adexpress.c.b;
import com.bytedance.sdk.component.adexpress.d;
import com.bytedance.sdk.component.adexpress.dynamic.b.a;
import java.util.ArrayList;
import java.util.List;

/* compiled from: TranslateAnimation */
public class n extends d {
    public n(View view, a aVar) {
        super(view, aVar);
    }

    /* access modifiers changed from: package-private */
    public List<ObjectAnimator> a() {
        float f;
        float a = b.a(d.a(), (float) this.b.f());
        float a2 = b.a(d.a(), (float) this.b.g());
        float f2 = 0.0f;
        if ("reverse".equals(this.b.p())) {
            f = a2;
            a2 = 0.0f;
            f2 = a;
            a = 0.0f;
        } else {
            f = 0.0f;
        }
        this.c.setTranslationX(a);
        this.c.setTranslationY(a2);
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.c, "translationX", new float[]{a, f2}).setDuration((long) ((int) (this.b.j() * 1000.0d)));
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(this.c, "translationY", new float[]{a2, f}).setDuration((long) ((int) (this.b.j() * 1000.0d)));
        ArrayList arrayList = new ArrayList();
        arrayList.add(a(duration));
        arrayList.add(a(duration2));
        return arrayList;
    }
}
