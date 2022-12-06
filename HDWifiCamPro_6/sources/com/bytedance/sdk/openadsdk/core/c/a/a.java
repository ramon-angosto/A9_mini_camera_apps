package com.bytedance.sdk.openadsdk.core.c.a;

import android.util.SparseArray;
import android.view.View;
import com.bytedance.sdk.component.adexpress.b.j;
import com.bytedance.sdk.component.utils.t;
import com.bytedance.sdk.openadsdk.core.b.c;
import com.bytedance.sdk.openadsdk.core.model.j;
import com.bytedance.sdk.openadsdk.l.z;
import java.lang.ref.WeakReference;

/* compiled from: DynamicClickListener */
public class a extends c implements com.bytedance.sdk.component.adexpress.dynamic.d.a {
    protected WeakReference<View> a;
    protected WeakReference<View> b;
    private j c;

    public void a(j jVar) {
        this.c = jVar;
    }

    public void a(View view) {
        this.a = new WeakReference<>(view);
    }

    public void b(View view) {
        this.b = new WeakReference<>(view);
    }

    public void a(View view, float f, float f2, float f3, float f4, SparseArray<c.a> sparseArray, boolean z) {
        a(view, ((Integer) view.getTag()).intValue(), f, f2, f3, f4, sparseArray);
    }

    private void a(View view, int i, float f, float f2, float f3, float f4, SparseArray<c.a> sparseArray) {
        if (this.c != null) {
            int[] iArr = new int[2];
            int[] iArr2 = new int[2];
            WeakReference<View> weakReference = this.b;
            if (weakReference != null) {
                int[] a2 = z.a((View) weakReference.get());
                if (a2 != null) {
                    iArr = a2;
                }
                int[] c2 = z.c((View) this.b.get());
                if (c2 != null) {
                    iArr2 = c2;
                }
            }
            String str = "";
            try {
                if (view.getTag(t.e(view.getContext(), "tt_id_click_area_type")) != null) {
                    str = String.valueOf(view.getTag(t.e(view.getContext(), "tt_id_click_area_type")));
                }
            } catch (Exception unused) {
            }
            this.c.a(view, i, new j.a().d(f).c(f2).b(f3).a(f4).b(this.w).a(this.x).c(iArr[0]).d(iArr[1]).e(iArr2[0]).f(iArr2[1]).a(sparseArray).a(this.C).a(str).a());
        }
    }
}
