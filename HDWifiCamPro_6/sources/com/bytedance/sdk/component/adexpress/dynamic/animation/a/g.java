package com.bytedance.sdk.component.adexpress.dynamic.animation.a;

import android.animation.ObjectAnimator;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.sdk.component.adexpress.dynamic.b.a;
import com.bytedance.sdk.component.utils.t;
import java.util.ArrayList;
import java.util.List;

/* compiled from: RippleAnimation */
public class g extends d {
    public g(View view, a aVar) {
        super(view, aVar);
    }

    /* access modifiers changed from: package-private */
    public List<ObjectAnimator> a() {
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.c, "rippleValue", new float[]{0.0f, 1.0f}).setDuration((long) ((int) (this.b.j() * 1000.0d)));
        ((ViewGroup) this.c.getParent()).setClipChildren(false);
        ((ViewGroup) this.c.getParent().getParent()).setClipChildren(false);
        ((ViewGroup) this.c.getParent().getParent().getParent()).setClipChildren(false);
        this.c.setTag(t.e(this.c.getContext(), "tt_id_ripple_bg"), this.b.h());
        ArrayList arrayList = new ArrayList();
        arrayList.add(a(duration));
        return arrayList;
    }
}
