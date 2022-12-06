package com.bytedance.sdk.component.adexpress.dynamic.animation.a;

import android.animation.ObjectAnimator;
import android.view.View;
import com.bytedance.sdk.component.adexpress.c.b;
import com.bytedance.sdk.component.adexpress.d;
import com.bytedance.sdk.component.adexpress.dynamic.b.a;
import java.util.ArrayList;
import java.util.List;

/* compiled from: WaggleAnimation */
public class o extends d {
    public o(View view, a aVar) {
        super(view, aVar);
    }

    /* access modifiers changed from: package-private */
    public List<ObjectAnimator> a() {
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.c, "translationX", new float[]{0.0f, b.a(d.a(), 20.0f), 0.0f, -b.a(d.a(), 20.0f), 0.0f}).setDuration((long) ((int) (this.b.j() * 1000.0d)));
        ArrayList arrayList = new ArrayList();
        arrayList.add(a(duration));
        return arrayList;
    }
}
