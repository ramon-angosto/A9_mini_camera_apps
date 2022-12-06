package com.bytedance.sdk.openadsdk.core.b;

import android.content.Context;
import android.util.SparseArray;
import android.view.View;
import com.bytedance.sdk.openadsdk.core.b.c;
import com.bytedance.sdk.openadsdk.core.model.n;

/* compiled from: RewardBarClickListener */
public abstract class e extends a {
    /* access modifiers changed from: protected */
    public abstract void a(View view, float f, float f2, float f3, float f4, SparseArray<c.a> sparseArray, int i, int i2, int i3, boolean z);

    public e(Context context, n nVar, String str, int i) {
        super(context, nVar, str, i);
    }

    public void a(View view, float f, float f2, float f3, float f4, SparseArray<c.a> sparseArray, boolean z) {
        View view2 = view;
        if (a(view, z)) {
            a(view, f, f2, f3, f4, sparseArray, this.A, this.y, this.z, z);
        }
        super.a(view, f, f2, f3, f4, sparseArray, z);
    }
}
