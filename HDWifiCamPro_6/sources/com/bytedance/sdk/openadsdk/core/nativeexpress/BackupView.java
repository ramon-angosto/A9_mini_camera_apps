package com.bytedance.sdk.openadsdk.core.nativeexpress;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.utils.o;
import com.bytedance.sdk.openadsdk.TTAdDislike;
import com.bytedance.sdk.openadsdk.TTDislikeDialogAbstract;
import com.bytedance.sdk.openadsdk.activity.TTDelegateActivity;
import com.bytedance.sdk.openadsdk.c.f;
import com.bytedance.sdk.openadsdk.core.b.a;
import com.bytedance.sdk.openadsdk.core.b.b;
import com.bytedance.sdk.openadsdk.core.m;
import com.bytedance.sdk.openadsdk.core.model.j;
import com.bytedance.sdk.openadsdk.core.model.n;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView;
import com.bytedance.sdk.openadsdk.dislike.c;
import com.bytedance.sdk.openadsdk.l.y;
import com.bytedance.sdk.openadsdk.l.z;

public abstract class BackupView extends FrameLayout {
    private f a;
    /* access modifiers changed from: protected */
    public Context b;
    /* access modifiers changed from: protected */
    public n c;
    protected c d;
    protected TTDislikeDialogAbstract e;
    /* access modifiers changed from: protected */
    public String f = "embeded_ad";
    protected int g;
    protected int h;
    protected int i;
    protected boolean j = true;
    protected boolean k = true;
    protected String l;

    /* access modifiers changed from: protected */
    public abstract void a(View view, int i2, j jVar);

    public Object getTag() {
        return "tt_express_backup_fl_tag_26";
    }

    public BackupView(Context context) {
        super(context);
        setTag("tt_express_backup_fl_tag_26");
    }

    public BackupView(Context context, String str) {
        super(context);
        this.l = str;
        setTag("tt_express_backup_fl_tag_26");
    }

    public void setTag(Object obj) {
        super.setTag("tt_express_backup_fl_tag_26");
    }

    public void setDislikeInner(TTAdDislike tTAdDislike) {
        if (tTAdDislike instanceof c) {
            this.d = (c) tTAdDislike;
        }
    }

    public void setDislikeOuter(TTDislikeDialogAbstract tTDislikeDialogAbstract) {
        n nVar;
        if (!(tTDislikeDialogAbstract == null || (nVar = this.c) == null)) {
            tTDislikeDialogAbstract.setMaterialMeta(nVar.ac(), this.c.ae());
        }
        this.e = tTDislikeDialogAbstract;
    }

    public void a() {
        TTDislikeDialogAbstract tTDislikeDialogAbstract = this.e;
        if (tTDislikeDialogAbstract != null) {
            tTDislikeDialogAbstract.show();
            return;
        }
        c cVar = this.d;
        if (cVar != null) {
            cVar.showDislikeDialog();
        } else {
            TTDelegateActivity.a(this.c, (String) null);
        }
    }

    /* access modifiers changed from: protected */
    public String getNameOrSource() {
        n nVar = this.c;
        if (nVar == null) {
            return "";
        }
        if (nVar.aa() != null && !TextUtils.isEmpty(this.c.aa().b())) {
            return this.c.aa().b();
        }
        if (!TextUtils.isEmpty(this.c.K())) {
            return this.c.K();
        }
        return "";
    }

    /* access modifiers changed from: protected */
    public String getTitle() {
        if (this.c.aa() != null && !TextUtils.isEmpty(this.c.aa().b())) {
            return this.c.aa().b();
        }
        if (!TextUtils.isEmpty(this.c.K())) {
            return this.c.K();
        }
        return !TextUtils.isEmpty(this.c.U()) ? this.c.U() : "";
    }

    /* access modifiers changed from: protected */
    public String getDescription() {
        if (!TextUtils.isEmpty(this.c.U())) {
            return this.c.U();
        }
        return !TextUtils.isEmpty(this.c.V()) ? this.c.V() : "";
    }

    public float getRealWidth() {
        return (float) z.c(this.b, (float) this.g);
    }

    public float getRealHeight() {
        return (float) z.c(this.b, (float) this.h);
    }

    /* access modifiers changed from: protected */
    public void a(View view, boolean z) {
        b bVar;
        if (view != null) {
            if (z) {
                Context context = this.b;
                n nVar = this.c;
                String str = this.f;
                bVar = new a(context, nVar, str, y.a(str));
            } else {
                Context context2 = this.b;
                n nVar2 = this.c;
                String str2 = this.f;
                bVar = new b(context2, nVar2, str2, y.a(str2));
            }
            view.setOnTouchListener(bVar);
            view.setOnClickListener(bVar);
            bVar.a((a) new a() {
                public void a(View view, int i, j jVar) {
                    BackupView.this.a(view, i, jVar);
                }
            });
        }
    }

    /* access modifiers changed from: protected */
    public View getVideoView() {
        NativeVideoTsView nativeVideoTsView;
        n nVar = this.c;
        if (!(nVar == null || this.b == null)) {
            if (n.c(nVar)) {
                try {
                    nativeVideoTsView = new NativeVideoTsView(this.b, this.c, this.f, true, false, this.a);
                    nativeVideoTsView.setVideoCacheUrl(this.l);
                    nativeVideoTsView.setControllerStatusCallBack(new NativeVideoTsView.b() {
                        public void a(boolean z, long j, long j2, long j3, boolean z2) {
                        }
                    });
                    nativeVideoTsView.setIsAutoPlay(this.j);
                    nativeVideoTsView.setIsQuiet(this.k);
                } catch (Throwable unused) {
                }
                if (n.c(this.c) || nativeVideoTsView == null || !nativeVideoTsView.a(0, true, false)) {
                    return null;
                }
                return nativeVideoTsView;
            }
            nativeVideoTsView = null;
            if (n.c(this.c)) {
            }
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public void a(int i2) {
        this.k = m.d().b(String.valueOf(this.i));
        int a2 = m.d().a(i2);
        if (3 == a2) {
            this.j = false;
            return;
        }
        int c2 = o.c(m.a());
        if (1 == a2 && y.c(c2)) {
            this.j = true;
        } else if (2 == a2) {
            if (y.d(c2) || y.c(c2) || y.e(c2)) {
                this.j = true;
            }
        } else if (5 != a2) {
        } else {
            if (y.c(c2) || y.e(c2)) {
                this.j = true;
            }
        }
    }

    /* access modifiers changed from: protected */
    public void a(View view) {
        n nVar = this.c;
        if (nVar != null && nVar.J() != null && view != null) {
            if (this.c.p() != 1 || !this.j) {
                a(view, false);
            } else {
                a(view, true);
            }
        }
    }
}
