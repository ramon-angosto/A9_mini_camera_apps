package com.bytedance.sdk.openadsdk.core.nativeexpress;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.utils.l;
import com.bytedance.sdk.component.utils.t;
import com.bytedance.sdk.openadsdk.core.model.j;
import com.bytedance.sdk.openadsdk.core.model.n;
import com.bytedance.sdk.openadsdk.l.z;

public class FullRewardExpressBackupView extends BackupView {
    private View a;
    private NativeExpressView m;
    private FrameLayout n;

    public FullRewardExpressBackupView(Context context) {
        super(context);
        this.b = context;
    }

    public void a(n nVar, NativeExpressView nativeExpressView) {
        l.b("FullRewardExpressBackupView", "show backup view");
        if (nVar != null) {
            setBackgroundColor(-1);
            this.c = nVar;
            this.m = nativeExpressView;
            if (nVar.aR() == 7) {
                this.f = "rewarded_video";
            } else {
                this.f = "fullscreen_interstitial_ad";
            }
            b();
            this.m.addView(this, new ViewGroup.LayoutParams(-2, -2));
        }
    }

    private void b() {
        this.g = (int) z.b(this.b, (float) this.m.getExpectExpressWidth());
        this.h = (int) z.b(this.b, (float) this.m.getExpectExpressWidth());
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(this.g, this.h);
        }
        layoutParams.width = this.g;
        layoutParams.height = this.h;
        if (layoutParams instanceof FrameLayout.LayoutParams) {
            ((FrameLayout.LayoutParams) layoutParams).gravity = 17;
        }
        setLayoutParams(layoutParams);
        this.c.v();
        c();
    }

    private void c() {
        this.a = LayoutInflater.from(this.b).inflate(t.f(this.b, "tt_backup_full_reward"), this, true);
        this.n = (FrameLayout) this.a.findViewById(t.e(this.b, "tt_bu_video_container"));
        this.n.removeAllViews();
    }

    public FrameLayout getVideoContainer() {
        return this.n;
    }

    /* access modifiers changed from: protected */
    public void a(View view, int i, j jVar) {
        NativeExpressView nativeExpressView = this.m;
        if (nativeExpressView != null) {
            nativeExpressView.a(view, i, jVar);
        }
    }

    public View getBackupContainerBackgroundView() {
        return this.a;
    }
}
