package com.bytedance.sdk.openadsdk.component.view;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.utils.l;
import com.bytedance.sdk.component.utils.t;
import com.bytedance.sdk.openadsdk.core.model.j;
import com.bytedance.sdk.openadsdk.core.model.n;
import com.bytedance.sdk.openadsdk.core.nativeexpress.BackupView;
import com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView;

public class OpenScreenAdBackupView extends BackupView {
    private NativeExpressView a;

    public OpenScreenAdBackupView(Context context) {
        super(context);
    }

    /* access modifiers changed from: protected */
    public void a(View view, int i, j jVar) {
        NativeExpressView nativeExpressView = this.a;
        if (nativeExpressView != null) {
            nativeExpressView.a(view, i, jVar);
        }
    }

    public void a(NativeExpressView nativeExpressView, n nVar) {
        this.a = nativeExpressView;
        this.a.addView(this, new FrameLayout.LayoutParams(-1, -1));
        Context context = getContext();
        int f = t.f(context, "tt_app_open_view2");
        int d = nVar.d();
        l.b("OpenScreenAdBackupView", "attachExpressView: splashLayoutId=" + d);
        if (d == 1) {
            f = t.f(context, "tt_app_open_view");
        } else if (d == 3) {
            f = t.f(context, "tt_app_open_view3");
        }
        inflate(context, f, this);
    }
}
