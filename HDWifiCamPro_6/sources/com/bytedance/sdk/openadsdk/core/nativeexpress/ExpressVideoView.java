package com.bytedance.sdk.openadsdk.core.nativeexpress;

import android.content.Context;
import android.view.View;
import com.bykv.vk.openvk.component.video.api.d.b;
import com.bytedance.sdk.openadsdk.c.f;
import com.bytedance.sdk.openadsdk.core.model.n;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView;
import com.bytedance.sdk.openadsdk.i.d;
import com.bytedance.sdk.openadsdk.l.z;

public class ExpressVideoView extends NativeVideoTsView implements View.OnClickListener {
    private boolean q = false;

    /* access modifiers changed from: protected */
    public void a(boolean z) {
    }

    public ExpressVideoView(Context context, n nVar, String str, f fVar) {
        super(context, nVar, false, str, false, false, fVar);
        if ("draw_ad".equals(str)) {
            this.q = true;
        }
        setOnClickListener(this);
        setNeedNativeVideoPlayBtnVisible(false);
    }

    /* access modifiers changed from: protected */
    public void b() {
        if (!this.e || !n.b(this.l)) {
            this.d = false;
        }
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

    public void setShouldCheckNetChange(boolean z) {
        if (this.b != null) {
            this.b.e(z);
        }
    }

    public void d() {
        if (this.j != null) {
            z.a((View) this.j, 8);
        }
    }

    /* access modifiers changed from: protected */
    public void onWindowVisibilityChanged(int i) {
        if (this.i == null || this.i.getVisibility() != 0) {
            super.onWindowVisibilityChanged(i);
        } else {
            r();
        }
    }

    public void onWindowFocusChanged(boolean z) {
        if (this.i == null || this.i.getVisibility() != 0) {
            super.onWindowFocusChanged(z);
        } else {
            r();
        }
    }

    private void q() {
        z.a((View) this.g, 0);
        z.a((View) this.h, 0);
        z.a((View) this.j, 8);
    }

    private void r() {
        g();
        if (this.g != null) {
            if (this.g.getVisibility() != 0) {
                d.a().a(this.a.J().h(), this.h);
            } else {
                return;
            }
        }
        q();
    }

    public void onClick(View view) {
        if (this.i != null && this.i.getVisibility() == 0) {
            z.e((View) this.g);
        }
        c();
    }

    public void setShowAdInteractionView(boolean z) {
        b o;
        if (this.b != null && (o = this.b.o()) != null) {
            o.a(z);
        }
    }

    /* access modifiers changed from: protected */
    public void e() {
        g();
        z.a((View) this.g, 0);
    }
}
