package com.bytedance.sdk.component.adexpress.dynamic.animation.a;

import android.animation.ObjectAnimator;
import android.view.View;
import com.bytedance.sdk.component.adexpress.dynamic.b.a;
import com.bytedance.sdk.component.utils.t;
import java.util.ArrayList;
import java.util.List;

/* compiled from: MarqueeAnimation */
public class f extends d {
    public f(View view, a aVar) {
        super(view, aVar);
    }

    /* access modifiers changed from: package-private */
    public List<ObjectAnimator> a() {
        this.c.setTag(t.e(this.c.getContext(), "tt_id_width"), Integer.valueOf(this.b.c()));
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.c, "marqueeValue", new float[]{0.0f, 1.0f}).setDuration((long) ((int) (this.b.j() * 1000.0d)));
        ArrayList arrayList = new ArrayList();
        arrayList.add(a(duration));
        return arrayList;
    }
}
