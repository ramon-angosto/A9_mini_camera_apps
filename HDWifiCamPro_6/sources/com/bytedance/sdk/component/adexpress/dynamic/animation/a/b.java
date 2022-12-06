package com.bytedance.sdk.component.adexpress.dynamic.animation.a;

import android.view.View;
import com.bytedance.sdk.component.adexpress.dynamic.b.a;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.d;
import java.util.ArrayList;
import java.util.List;

/* compiled from: AnimationSets */
public class b implements d {
    List<d> a = new ArrayList();

    public b(View view, List<a> list) {
        for (a a2 : list) {
            d a3 = c.a().a(view, a2);
            if (a3 != null) {
                this.a.add(a3);
            }
        }
    }

    public void a() {
        for (d c : this.a) {
            try {
                c.c();
            } catch (Exception unused) {
            }
        }
    }

    public void b() {
        for (d b : this.a) {
            try {
                b.b();
            } catch (Exception unused) {
            }
        }
    }
}
