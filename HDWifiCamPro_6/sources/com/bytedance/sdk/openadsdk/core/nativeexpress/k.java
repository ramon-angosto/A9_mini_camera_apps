package com.bytedance.sdk.openadsdk.core.nativeexpress;

import android.view.View;
import com.bytedance.sdk.component.adexpress.b.a;
import com.bytedance.sdk.component.adexpress.b.c;
import com.bytedance.sdk.component.adexpress.b.f;
import com.bytedance.sdk.component.adexpress.b.l;
import com.bytedance.sdk.component.adexpress.b.m;
import com.bytedance.sdk.component.adexpress.theme.ThemeStatusBroadcastReceiver;
import com.bytedance.sdk.openadsdk.l.w;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: NativeRender */
public class k extends a<BackupView> {
    AtomicBoolean a = new AtomicBoolean(false);
    private BackupView b;
    private View c;
    private c d;
    private f e;
    private l f;

    public k(View view, ThemeStatusBroadcastReceiver themeStatusBroadcastReceiver, l lVar) {
        this.c = view;
        this.f = lVar;
    }

    public void a(f fVar) {
        this.e = fVar;
        w.a((Runnable) new Runnable() {
            public void run() {
                k.this.b();
            }
        });
    }

    /* access modifiers changed from: private */
    public void b() {
        if (!this.a.get()) {
            c cVar = this.d;
            boolean z = false;
            if (cVar != null && cVar.a((NativeExpressView) this.c, 0)) {
                z = true;
            }
            if (!z) {
                this.e.a(107);
                return;
            }
            this.f.c().e();
            this.b = (BackupView) this.c.findViewWithTag("tt_express_backup_fl_tag_26");
            if (this.b != null) {
                m mVar = new m();
                BackupView backupView = this.b;
                float f2 = 0.0f;
                float realWidth = backupView == null ? 0.0f : backupView.getRealWidth();
                BackupView backupView2 = this.b;
                if (backupView2 != null) {
                    f2 = backupView2.getRealHeight();
                }
                mVar.a(true);
                mVar.a((double) realWidth);
                mVar.b((double) f2);
                this.e.a(this.b, mVar);
                return;
            }
            this.e.a(107);
        }
    }

    /* renamed from: a */
    public BackupView e() {
        return this.b;
    }

    public void a(c cVar) {
        this.d = cVar;
    }
}
