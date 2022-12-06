package com.bytedance.sdk.openadsdk.core.b;

import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import com.bytedance.sdk.component.utils.t;
import com.bytedance.sdk.openadsdk.core.b.c;
import com.bytedance.sdk.openadsdk.core.f.a;

/* compiled from: VastClickListenerWrapper */
public abstract class g extends c {
    private final String a;
    private final a b;
    private c c;

    public abstract void a();

    public g(String str, a aVar) {
        this(str, aVar, (c) null);
    }

    public g(String str, a aVar, c cVar) {
        this.a = str;
        this.b = aVar;
        this.c = cVar;
    }

    public void a(c cVar) {
        this.c = cVar;
    }

    /* access modifiers changed from: protected */
    public void a(View view, float f, float f2, float f3, float f4, SparseArray<c.a> sparseArray, boolean z) {
        View view2 = view;
        a aVar = this.b;
        if (aVar != null) {
            aVar.e(this.a);
        }
        if (view2 != null) {
            if (view.getId() == t.e(view.getContext(), "tt_reward_ad_appname")) {
                view.setTag(t.e(view.getContext(), "tt_id_vast_click_type"), "VAST_TITLE");
            } else if (view.getId() == t.e(view.getContext(), "tt_reward_ad_description")) {
                view.setTag(t.e(view.getContext(), "tt_id_vast_click_type"), "VAST_DESCRIPTION");
            } else {
                view.setTag(t.e(view.getContext(), "tt_id_vast_click_type"), this.a);
            }
        }
        c cVar = this.c;
        if (cVar != null) {
            cVar.w = this.w;
            this.c.x = this.x;
            this.c.y = this.y;
            this.c.z = this.y;
            this.c.A = this.y;
            this.c.a(view, f, f2, f3, f4, sparseArray, z);
        }
        a();
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        return super.onTouch(view, motionEvent);
    }
}
