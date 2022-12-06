package com.bytedance.sdk.openadsdk.component.a;

import android.content.Context;
import android.util.SparseArray;
import android.view.View;
import com.bytedance.sdk.component.utils.t;
import com.bytedance.sdk.openadsdk.core.b.c;
import com.bytedance.sdk.openadsdk.core.m;
import com.bytedance.sdk.openadsdk.core.model.n;
import com.bytedance.sdk.openadsdk.k.a.e;

/* compiled from: TTAppOpenAdClickListener */
public class a extends com.bytedance.sdk.openadsdk.core.b.a {
    public a(Context context, n nVar, String str, int i) {
        super(context, nVar, str, i);
    }

    public void a(View view, float f, float f2, float f3, float f4, SparseArray<c.a> sparseArray, boolean z) {
        if (view.getId() == t.e(m.a(), "tt_open_ad_click_button")) {
            a("click_bar");
        } else {
            a("click_material");
        }
        super.a(view, f, f2, f3, f4, sparseArray, z);
        e.a(this.d, 9);
    }
}
