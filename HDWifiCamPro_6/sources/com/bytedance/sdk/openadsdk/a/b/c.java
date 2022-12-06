package com.bytedance.sdk.openadsdk.a.b;

import android.content.Context;
import android.util.Pair;
import android.view.View;
import com.a.a.a.a.b.g;
import com.bykv.vk.openvk.component.video.api.d.c;
import com.bytedance.sdk.component.utils.o;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.core.f.f;
import com.bytedance.sdk.openadsdk.core.m;
import com.bytedance.sdk.openadsdk.core.model.n;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView;
import com.bytedance.sdk.openadsdk.l.y;
import com.bytedance.sdk.openadsdk.multipro.b.a;
import java.util.List;

/* compiled from: PAGFeedVideoAdImpl */
public class c extends i implements c.C0021c, c.d, a.C0055a {
    private d h;
    /* access modifiers changed from: private */
    public final a i;
    private boolean j = false;
    private boolean k = true;
    private AdSlot l;

    public c(Context context, n nVar, int i2, AdSlot adSlot) {
        super(context, nVar, i2);
        this.e = i2;
        this.l = adSlot;
        this.i = new a();
        a(this.f);
        a("embeded_ad");
        this.d.a(this);
    }

    public View f() {
        NativeVideoTsView nativeVideoTsView;
        if (!(this.b == null || this.c == null)) {
            if (n.c(this.b)) {
                try {
                    nativeVideoTsView = new NativeVideoTsView(this.c, this.b, this.a.a());
                    if (this.b != null && this.b.aw()) {
                        f a = nativeVideoTsView.a((List<Pair<View, g>>) null);
                        if (this.d != null) {
                            this.d.a(a);
                        }
                    }
                    if (this.d != null) {
                        this.d.a(nativeVideoTsView);
                    }
                    nativeVideoTsView.setVideoAdClickListenerTTNativeAd(this);
                    nativeVideoTsView.setAdCreativeClickListener(new NativeVideoTsView.a() {
                        public void a(View view, int i) {
                            if (c.this.a != null) {
                                c.this.a.a(view, i);
                            }
                        }
                    });
                    nativeVideoTsView.setControllerStatusCallBack(new NativeVideoTsView.b() {
                        public void a(boolean z, long j, long j2, long j3, boolean z2) {
                            c.this.i.a = z;
                            c.this.i.e = j;
                            c.this.i.f = j2;
                            c.this.i.g = j3;
                            c.this.i.d = z2;
                        }
                    });
                    nativeVideoTsView.setVideoAdLoadListener(this);
                    nativeVideoTsView.setVideoAdInteractionListener(this);
                    if (5 == this.e) {
                        nativeVideoTsView.setIsAutoPlay(this.j ? this.l.isAutoPlay() : this.k);
                    } else {
                        nativeVideoTsView.setIsAutoPlay(this.k);
                    }
                    nativeVideoTsView.setIsQuiet(m.d().b(String.valueOf(this.f)));
                } catch (Exception unused) {
                }
                if (n.c(this.b) || nativeVideoTsView == null || !nativeVideoTsView.a(0, true, false)) {
                    return null;
                }
                return nativeVideoTsView;
            }
            nativeVideoTsView = null;
            if (n.c(this.b)) {
            }
        }
        return null;
    }

    public void a(int i2) {
        int a = m.d().a(i2);
        int c = o.c(m.a());
        if (3 == a) {
            this.j = false;
            this.k = false;
        } else if (1 == a && y.c(c)) {
            this.j = false;
            this.k = true;
        } else if (2 == a) {
            if (y.d(c) || y.c(c) || y.e(c)) {
                this.j = false;
                this.k = true;
            }
        } else if (4 == a) {
            this.j = true;
        } else if (5 == a && (y.c(c) || y.e(c))) {
            this.k = true;
        }
        if (this.d != null) {
            this.d.a(this.j);
        }
    }

    public void a(d dVar) {
        this.h = dVar;
    }

    public void b_() {
        d dVar = this.h;
        if (dVar != null) {
            dVar.a(this);
        }
    }

    public void a(int i2, int i3) {
        d dVar = this.h;
        if (dVar != null) {
            dVar.a(i2, i3);
        }
    }

    public void c_() {
        d dVar = this.h;
        if (dVar != null) {
            dVar.b(this);
        }
    }

    public void d_() {
        d dVar = this.h;
        if (dVar != null) {
            dVar.c(this);
        }
    }

    public void e_() {
        d dVar = this.h;
        if (dVar != null) {
            dVar.d(this);
        }
    }

    public void a(long j2, long j3) {
        d dVar = this.h;
        if (dVar != null) {
            dVar.a(j2, j3);
        }
    }

    public void a_() {
        d dVar = this.h;
        if (dVar != null) {
            dVar.e(this);
        }
    }

    public a g() {
        return this.i;
    }

    /* access modifiers changed from: protected */
    public void a(String str) {
        super.a(str);
    }

    public void showPrivacyActivity() {
        if (this.d != null) {
            this.d.i();
        }
    }
}
