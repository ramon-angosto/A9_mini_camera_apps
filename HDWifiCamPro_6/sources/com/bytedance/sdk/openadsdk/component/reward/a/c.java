package com.bytedance.sdk.openadsdk.component.reward.a;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.sdk.component.utils.t;
import com.bytedance.sdk.openadsdk.component.reward.top.TopProxyLayout;
import com.bytedance.sdk.openadsdk.component.reward.top.b;
import com.bytedance.sdk.openadsdk.core.m;
import com.bytedance.sdk.openadsdk.core.model.n;
import com.bytedance.sdk.openadsdk.l.z;

/* compiled from: RewardFullTopProxyManager */
public class c {
    TopProxyLayout a;
    com.bytedance.sdk.component.adexpress.dynamic.c b;
    private final Activity c;
    private boolean d = false;

    public c(Activity activity) {
        this.c = activity;
    }

    public void a() {
        if (!this.d) {
            this.d = true;
            e();
        }
    }

    private void e() {
        Activity activity = this.c;
        this.a = (TopProxyLayout) activity.findViewById(t.e(activity, "tt_top_layout_proxy"));
    }

    public void a(boolean z, n nVar) {
        TopProxyLayout topProxyLayout = this.a;
        if (topProxyLayout != null) {
            topProxyLayout.a(z, nVar);
        }
    }

    public void a(boolean z) {
        TopProxyLayout topProxyLayout = this.a;
        if (topProxyLayout != null) {
            topProxyLayout.setShowDislike(z);
        }
    }

    public void b(boolean z) {
        TopProxyLayout topProxyLayout = this.a;
        if (topProxyLayout != null) {
            topProxyLayout.setSoundMute(z);
        }
        com.bytedance.sdk.component.adexpress.dynamic.c cVar = this.b;
        if (cVar != null) {
            cVar.setSoundMute(z);
        }
    }

    public void c(boolean z) {
        TopProxyLayout topProxyLayout = this.a;
        if (topProxyLayout != null) {
            topProxyLayout.setShowSound(z);
        }
    }

    public void d(boolean z) {
        TopProxyLayout topProxyLayout = this.a;
        if (topProxyLayout != null) {
            topProxyLayout.setShowSkip(z);
        }
    }

    public void a(String str, CharSequence charSequence) {
        TopProxyLayout topProxyLayout = this.a;
        if (topProxyLayout != null) {
            topProxyLayout.a((CharSequence) String.valueOf(str), charSequence);
        }
    }

    public void e(boolean z) {
        TopProxyLayout topProxyLayout = this.a;
        if (topProxyLayout != null) {
            topProxyLayout.setSkipEnable(z);
        }
    }

    public void b() {
        TopProxyLayout topProxyLayout = this.a;
        if (topProxyLayout != null) {
            topProxyLayout.a();
        }
    }

    public void c() {
        TopProxyLayout topProxyLayout = this.a;
        if (topProxyLayout != null) {
            topProxyLayout.b();
        }
    }

    public void d() {
        TopProxyLayout topProxyLayout = this.a;
        if (topProxyLayout != null) {
            topProxyLayout.c();
        }
    }

    public void a(b bVar) {
        TopProxyLayout topProxyLayout = this.a;
        if (topProxyLayout != null) {
            topProxyLayout.setListener(bVar);
        }
    }

    public void a(com.bytedance.sdk.component.adexpress.dynamic.c cVar) {
        this.b = cVar;
    }

    public void a(int i) {
        TopProxyLayout topProxyLayout = this.a;
        if (topProxyLayout != null && (topProxyLayout.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            ((ViewGroup.MarginLayoutParams) this.a.getLayoutParams()).topMargin = (int) (((float) i) - z.b((Context) this.c, 20.0f));
        }
    }

    public void b(int i) {
        View findViewById;
        TopProxyLayout topProxyLayout = this.a;
        if (topProxyLayout != null && topProxyLayout.getITopLayout() != null && (findViewById = this.a.getITopLayout().findViewById(t.e(m.a(), "tt_top_dislike"))) != null && (findViewById.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) && findViewById.getWidth() > 0 && findViewById.getVisibility() == 0) {
            int[] iArr = new int[2];
            findViewById.getLocationOnScreen(iArr);
            float width = (float) (i - (iArr[0] + findViewById.getWidth()));
            if (width < z.b((Context) this.c, 16.0f)) {
                ((ViewGroup.MarginLayoutParams) findViewById.getLayoutParams()).rightMargin = (int) (((float) ((ViewGroup.MarginLayoutParams) findViewById.getLayoutParams()).rightMargin) + (z.b((Context) this.c, 16.0f) - width));
                findViewById.requestLayout();
            }
        }
    }

    public void c(int i) {
        this.a.setVisibility(i);
    }
}
