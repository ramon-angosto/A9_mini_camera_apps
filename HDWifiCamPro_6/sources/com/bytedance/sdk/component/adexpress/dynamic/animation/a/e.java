package com.bytedance.sdk.component.adexpress.dynamic.animation.a;

import android.animation.ObjectAnimator;
import android.view.View;
import com.bytedance.sdk.component.adexpress.dynamic.b.a;
import java.util.ArrayList;
import java.util.List;

/* compiled from: CutInAnimation */
public class e extends d {
    public e(View view, a aVar) {
        super(view, aVar);
    }

    /* access modifiers changed from: package-private */
    public List<ObjectAnimator> a() {
        float f = (float) this.c.getLayoutParams().width;
        this.c.setTranslationX(f);
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.c, "translationX", new float[]{f, 0.0f}).setDuration((long) ((int) (this.b.j() * 1000.0d)));
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(this.c, "alpha", new float[]{0.0f, 1.0f}).setDuration((long) ((int) (this.b.j() * 1000.0d)));
        ArrayList arrayList = new ArrayList();
        arrayList.add(a(duration));
        arrayList.add(a(duration2));
        return arrayList;
    }
}
