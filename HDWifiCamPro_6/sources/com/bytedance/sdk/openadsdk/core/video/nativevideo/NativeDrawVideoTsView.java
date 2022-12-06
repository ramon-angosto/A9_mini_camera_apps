package com.bytedance.sdk.openadsdk.core.video.nativevideo;

import android.view.View;
import com.bytedance.sdk.openadsdk.core.m;
import com.bytedance.sdk.openadsdk.core.nativeexpress.n;
import com.bytedance.sdk.openadsdk.i.d;
import com.bytedance.sdk.openadsdk.l.z;

public class NativeDrawVideoTsView extends NativeVideoTsView implements View.OnClickListener {
    private boolean q;

    /* access modifiers changed from: protected */
    public void b() {
        if (!this.e || !n.b(this.l)) {
            this.d = false;
        }
        this.l = "draw_ad";
        m.d().w(String.valueOf(this.a.aW()));
        super.b();
    }

    /* access modifiers changed from: protected */
    public void c() {
        if (this.q) {
            super.c();
        }
    }

    public void setCanInterruptVideoPlay(boolean z) {
        this.q = z;
    }

    /* access modifiers changed from: protected */
    public void onWindowVisibilityChanged(int i) {
        if (this.i == null || this.i.getVisibility() != 0) {
            super.onWindowVisibilityChanged(i);
        } else {
            e();
        }
    }

    public void onWindowFocusChanged(boolean z) {
        if (this.i == null || this.i.getVisibility() != 0) {
            super.onWindowFocusChanged(z);
        } else {
            e();
        }
    }

    private void d() {
        z.a((View) this.g, 0);
        z.a((View) this.h, 0);
        z.a((View) this.j, 8);
    }

    private void e() {
        g();
        if (this.g != null) {
            if (this.g.getVisibility() != 0) {
                d.a().a(this.a.J().h(), this.h);
            } else {
                return;
            }
        }
        d();
    }

    public void onClick(View view) {
        if (this.i != null && this.i.getVisibility() == 0) {
            z.e((View) this.g);
        }
        c();
    }
}
