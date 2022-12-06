package com.bytedance.sdk.component.adexpress.dynamic.animation.a;

import android.animation.ObjectAnimator;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.sdk.component.adexpress.dynamic.b.a;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget;
import com.bytedance.sdk.component.utils.t;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ScaleAnimation */
public class j extends d {
    public j(View view, a aVar) {
        super(view, aVar);
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        if (viewGroup != null) {
            viewGroup.setClipChildren(false);
            viewGroup.setClipToPadding(false);
            ViewGroup viewGroup2 = (ViewGroup) viewGroup.getParent();
            if (viewGroup2 != null && (viewGroup2 instanceof DynamicBaseWidget)) {
                viewGroup2.setClipChildren(false);
                viewGroup2.setClipToPadding(false);
                ViewGroup viewGroup3 = (ViewGroup) viewGroup2.getParent();
                if (viewGroup3 != null && (viewGroup3 instanceof DynamicBaseWidget)) {
                    viewGroup3.setClipChildren(false);
                    viewGroup3.setClipToPadding(false);
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public List<ObjectAnimator> a() {
        float f;
        float k = (float) this.b.k();
        float l = (float) this.b.l();
        float f2 = 1.0f;
        if ("reverse".equals(this.b.p())) {
            f = 1.0f;
        } else {
            f = l;
            l = 1.0f;
            f2 = k;
            k = 1.0f;
        }
        this.c.setTag(t.e(this.c.getContext(), "tt_id_direction"), this.b.b());
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.c, "scaleX", new float[]{k, f2}).setDuration((long) ((int) (this.b.j() * 1000.0d)));
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(this.c, "scaleY", new float[]{l, f}).setDuration((long) ((int) (this.b.j() * 1000.0d)));
        ArrayList arrayList = new ArrayList();
        arrayList.add(a(duration));
        arrayList.add(a(duration2));
        return arrayList;
    }
}
