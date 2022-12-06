package com.bytedance.sdk.openadsdk.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.View;
import com.bykv.vk.openvk.component.video.api.d.c;
import com.bytedance.sdk.component.g.e;
import com.bytedance.sdk.component.g.g;
import com.bytedance.sdk.component.utils.l;
import com.bytedance.sdk.component.utils.t;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.a.c.c;
import com.bytedance.sdk.openadsdk.c.c.a.a;
import com.bytedance.sdk.openadsdk.c.c.b.o;
import com.bytedance.sdk.openadsdk.c.f;
import com.bytedance.sdk.openadsdk.core.m;
import com.bytedance.sdk.openadsdk.core.model.n;
import com.bytedance.sdk.openadsdk.core.model.p;
import com.bytedance.sdk.openadsdk.core.r;
import com.bytedance.sdk.openadsdk.core.settings.j;
import com.bytedance.sdk.openadsdk.multipro.b;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class TTFullScreenVideoActivity extends TTBaseVideoActivity {
    private static c S;
    /* access modifiers changed from: private */
    public c R;
    private boolean T;

    /* access modifiers changed from: protected */
    public boolean I() {
        return false;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (b(bundle)) {
            s();
            t();
            d();
            a();
        }
    }

    /* access modifiers changed from: protected */
    public void onSaveInstanceState(Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        S = this.R;
        super.onSaveInstanceState(bundle);
    }

    /* access modifiers changed from: private */
    public void c(final String str) {
        e.c(new g("FullScreen_executeMultiProcessCallback") {
            public void run() {
                try {
                    TTFullScreenVideoActivity.this.a(1).executeFullVideoCallback(TTFullScreenVideoActivity.this.d, str);
                } catch (Throwable th) {
                    l.b("TTFullScreenVideoActivity", "fullscreen_interstitial_ad", "executeFullVideoCallback execute throw Exception : ", th);
                }
            }
        }, 5);
    }

    /* access modifiers changed from: protected */
    public void a(Intent intent) {
        super.a(intent);
        if (intent != null) {
            this.F = intent.getBooleanExtra("is_verity_playable", false);
        }
    }

    private boolean b(Bundle bundle) {
        String stringExtra;
        if (b.c()) {
            Intent intent = getIntent();
            if (!(intent == null || (stringExtra = intent.getStringExtra(TTAdConstant.MULTI_PROCESS_MATERIALMETA)) == null)) {
                try {
                    this.c = com.bytedance.sdk.openadsdk.core.b.a(new JSONObject(stringExtra));
                } catch (Exception e) {
                    l.b("TTFullScreenVideoActivity", "fullscreen_interstitial_ad", "initData MultiGlobalInfo throws ", e);
                }
            }
        } else {
            this.c = r.a().c();
            this.R = r.a().e();
        }
        if (!b.c()) {
            r.a().h();
        }
        if (bundle != null) {
            if (this.R == null) {
                this.R = S;
                S = null;
            }
            try {
                this.c = com.bytedance.sdk.openadsdk.core.b.a(new JSONObject(bundle.getString("material_meta")));
                this.w.set(bundle.getBoolean("has_show_skip_btn"));
                if (this.w.get()) {
                    this.k.d(true);
                    N();
                }
            } catch (Throwable unused) {
            }
        }
        if (this.c == null) {
            l.c("TTFullScreenVideoActivity", "fullscreen_interstitial_ad", "mMaterialMeta is null , no data to display ,the TTFullScreenVideoActivity finished !!");
            finish();
            return false;
        }
        this.n.a(this.c, this.a);
        this.n.a();
        this.c.a(this.c.g(), 8);
        return true;
    }

    /* access modifiers changed from: protected */
    public void H() {
        View k = this.i.k();
        if (k != null) {
            k.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    TTFullScreenVideoActivity.this.o.s();
                    TTFullScreenVideoActivity.this.r();
                    TTFullScreenVideoActivity.this.finish();
                }
            });
        }
        this.k.a((com.bytedance.sdk.openadsdk.component.reward.top.b) new com.bytedance.sdk.openadsdk.component.reward.top.b() {
            public void a(View view) {
                if (p.i(TTFullScreenVideoActivity.this.c) || (com.bytedance.sdk.openadsdk.core.model.l.a(TTFullScreenVideoActivity.this.c) && !TTFullScreenVideoActivity.this.g.get())) {
                    if (b.c()) {
                        TTFullScreenVideoActivity.this.c("onSkippedVideo");
                    } else if (TTFullScreenVideoActivity.this.R != null) {
                        TTFullScreenVideoActivity.this.R.e();
                    }
                    TTFullScreenVideoActivity.this.finish();
                    return;
                }
                o.a aVar = new o.a();
                aVar.a(TTFullScreenVideoActivity.this.m.s());
                aVar.c(TTFullScreenVideoActivity.this.m.u());
                aVar.b(TTFullScreenVideoActivity.this.m.j());
                aVar.e(3);
                aVar.f(TTFullScreenVideoActivity.this.m.r());
                a.a(TTFullScreenVideoActivity.this.m.c(), aVar, TTFullScreenVideoActivity.this.m.a());
                com.bytedance.sdk.openadsdk.core.p.c(TTFullScreenVideoActivity.this.t);
                TTFullScreenVideoActivity.this.m.a("skip", (Map<String, Object>) null);
                TTFullScreenVideoActivity.this.k.d(false);
                if (b.c()) {
                    TTFullScreenVideoActivity.this.c("onSkippedVideo");
                } else if (TTFullScreenVideoActivity.this.R != null) {
                    TTFullScreenVideoActivity.this.R.e();
                }
                if (TTFullScreenVideoActivity.this.h()) {
                    TTFullScreenVideoActivity.this.a(true);
                } else {
                    TTFullScreenVideoActivity.this.finish();
                }
                if (!(TTFullScreenVideoActivity.this.c == null || TTFullScreenVideoActivity.this.c.ax() == null || TTFullScreenVideoActivity.this.m == null)) {
                    TTFullScreenVideoActivity.this.c.ax().a().f(TTFullScreenVideoActivity.this.m.s());
                    TTFullScreenVideoActivity.this.c.ax().a().e(TTFullScreenVideoActivity.this.m.s());
                }
                com.bytedance.sdk.openadsdk.k.a.e.a(TTFullScreenVideoActivity.this.c, 5);
            }

            public void b(View view) {
                TTFullScreenVideoActivity tTFullScreenVideoActivity = TTFullScreenVideoActivity.this;
                tTFullScreenVideoActivity.r = !tTFullScreenVideoActivity.r;
                if (!(TTFullScreenVideoActivity.this.L == null || TTFullScreenVideoActivity.this.L.a() == null)) {
                    TTFullScreenVideoActivity.this.L.a().a(TTFullScreenVideoActivity.this.r);
                }
                TTFullScreenVideoActivity.this.m.b(TTFullScreenVideoActivity.this.r);
                if (!p.j(TTFullScreenVideoActivity.this.c) || TTFullScreenVideoActivity.this.v.get()) {
                    if (p.a(TTFullScreenVideoActivity.this.c)) {
                        TTFullScreenVideoActivity.this.E.a(TTFullScreenVideoActivity.this.r, true);
                    }
                    TTFullScreenVideoActivity.this.o.d(TTFullScreenVideoActivity.this.r);
                    if (TTFullScreenVideoActivity.this.c != null && TTFullScreenVideoActivity.this.c.ax() != null && TTFullScreenVideoActivity.this.c.ax().a() != null && TTFullScreenVideoActivity.this.m != null) {
                        if (TTFullScreenVideoActivity.this.r) {
                            TTFullScreenVideoActivity.this.c.ax().a().h(TTFullScreenVideoActivity.this.m.s());
                        } else {
                            TTFullScreenVideoActivity.this.c.ax().a().i(TTFullScreenVideoActivity.this.m.s());
                        }
                    }
                }
            }

            public void c(View view) {
                TTFullScreenVideoActivity.this.G();
            }
        });
    }

    public boolean a(long j, boolean z) {
        f fVar = new f();
        fVar.a(System.currentTimeMillis(), 1.0f);
        if (this.L == null || !(this.L instanceof com.bytedance.sdk.openadsdk.component.reward.b.c)) {
            this.m.a(this.i.h(), this.c, this.a, I(), fVar);
        } else {
            this.m.a(((com.bytedance.sdk.openadsdk.component.reward.b.c) this.L).d(), this.c, this.a, I(), fVar);
        }
        HashMap hashMap = null;
        if (!TextUtils.isEmpty(this.D)) {
            hashMap = new HashMap();
            hashMap.put("rit_scene", this.D);
        }
        this.m.a((Map<String, Object>) hashMap);
        AnonymousClass4 r1 = new c.a() {
            public void a(long j, int i) {
                TTFullScreenVideoActivity.this.q.removeMessages(ms.bd.o.Pgl.c.COLLECT_MODE_FINANCE);
                TTFullScreenVideoActivity.this.E();
                TTFullScreenVideoActivity.this.M();
                if (com.bytedance.sdk.openadsdk.core.model.l.b(TTFullScreenVideoActivity.this.c)) {
                    TTFullScreenVideoActivity.this.m();
                    TTFullScreenVideoActivity.this.N.set(true);
                } else if (TTFullScreenVideoActivity.this.h()) {
                    TTFullScreenVideoActivity.this.a(false);
                } else {
                    TTFullScreenVideoActivity.this.finish();
                }
            }

            public void b(long j, int i) {
                TTFullScreenVideoActivity.this.q.removeMessages(ms.bd.o.Pgl.c.COLLECT_MODE_FINANCE);
                TTFullScreenVideoActivity.this.D();
                if (!TTFullScreenVideoActivity.this.m.b()) {
                    TTFullScreenVideoActivity.this.E();
                    TTFullScreenVideoActivity.this.m.m();
                    l.c("TTFullScreenVideoActivity", "fullscreen_interstitial_ad", "onError、、、、、、、、");
                    if (TTFullScreenVideoActivity.this.h()) {
                        TTFullScreenVideoActivity.this.a(false, true);
                        TTFullScreenVideoActivity.this.m.a(TTFullScreenVideoActivity.this.m.B() ^ true ? 1 : 0, 2);
                        return;
                    }
                    TTFullScreenVideoActivity.this.finish();
                }
            }

            public void a() {
                TTFullScreenVideoActivity.this.q.removeMessages(ms.bd.o.Pgl.c.COLLECT_MODE_FINANCE);
                TTFullScreenVideoActivity.this.E();
                l.a("TTFullScreenVideoActivity", "fullscreen_interstitial_ad", "onTimeOut、、、、、、、、");
                if (TTFullScreenVideoActivity.this.h()) {
                    TTFullScreenVideoActivity.this.a(false, true);
                } else {
                    TTFullScreenVideoActivity.this.finish();
                }
                TTFullScreenVideoActivity.this.m.a(TTFullScreenVideoActivity.this.m.B() ^ true ? 1 : 0, true ^ TTFullScreenVideoActivity.this.m.B() ? 1 : 0);
                TTFullScreenVideoActivity.this.m.m();
            }

            public void a(long j, long j2) {
                if (!TTFullScreenVideoActivity.this.H && TTFullScreenVideoActivity.this.m.b()) {
                    TTFullScreenVideoActivity.this.m.o();
                }
                if (!TTFullScreenVideoActivity.this.v.get()) {
                    TTFullScreenVideoActivity.this.q.removeMessages(ms.bd.o.Pgl.c.COLLECT_MODE_FINANCE);
                    if (j != TTFullScreenVideoActivity.this.m.f()) {
                        TTFullScreenVideoActivity.this.E();
                    }
                    TTFullScreenVideoActivity.this.m.a(j);
                    TTFullScreenVideoActivity tTFullScreenVideoActivity = TTFullScreenVideoActivity.this;
                    long j3 = j / 1000;
                    tTFullScreenVideoActivity.s = (int) (tTFullScreenVideoActivity.m.C() - ((double) j3));
                    int i = (int) j3;
                    if ((TTFullScreenVideoActivity.this.A.get() || TTFullScreenVideoActivity.this.y.get()) && TTFullScreenVideoActivity.this.m.b()) {
                        TTFullScreenVideoActivity.this.m.o();
                    }
                    TTFullScreenVideoActivity.this.e(i);
                    if (TTFullScreenVideoActivity.this.s >= 0) {
                        TTFullScreenVideoActivity.this.k.a(String.valueOf(TTFullScreenVideoActivity.this.s), (CharSequence) null);
                    }
                    if (TTFullScreenVideoActivity.this.s <= 0) {
                        TTFullScreenVideoActivity.this.N.set(true);
                        l.a("TTFullScreenVideoActivity", "fullscreen_interstitial_ad", "onProgressUpdate、、、、、、、、");
                        if (TTFullScreenVideoActivity.this.h()) {
                            TTFullScreenVideoActivity.this.a(false);
                        } else {
                            TTFullScreenVideoActivity.this.finish();
                        }
                    }
                }
            }
        };
        this.m.a((c.a) r1);
        if (this.i.x != null) {
            this.i.x.a((c.a) r1);
        }
        return a(j, z, (Map<String, Object>) hashMap);
    }

    /* access modifiers changed from: protected */
    public void e(int i) {
        int o = m.d().o(String.valueOf(this.t));
        if (o < 0) {
            o = 5;
        }
        if (m.d().d(String.valueOf(this.t)) && (n.c(this.c) || h())) {
            if (!this.w.getAndSet(true)) {
                this.k.d(true);
            }
            if (i <= o) {
                g(o - i);
                this.k.e(false);
                return;
            }
            N();
        } else if (i >= o) {
            if (!this.w.getAndSet(true)) {
                this.k.d(true);
            }
            N();
        }
    }

    private void N() {
        if (n.c(this.c) || h()) {
            this.k.a((String) null, (CharSequence) j.c);
        } else {
            this.k.a((String) null, (CharSequence) "X");
        }
        this.k.e(true);
    }

    private void g(int i) {
        this.k.a((String) null, (CharSequence) new SpannableStringBuilder(String.format(t.a(m.a(), "tt_skip_ad_time_text"), new Object[]{Integer.valueOf(i)})));
    }

    public void onRewardBarClick(View view) {
        if (!(this.c == null || this.c.an() == 100.0f)) {
            this.T = true;
        }
        if (b.c()) {
            c("onAdVideoBarClick");
            return;
        }
        com.bytedance.sdk.openadsdk.a.c.c cVar = this.R;
        if (cVar != null) {
            cVar.b();
        }
    }

    public void K() {
        if (b.c()) {
            c("onAdShow");
        } else {
            com.bytedance.sdk.openadsdk.a.c.c cVar = this.R;
            if (cVar != null) {
                cVar.a();
            }
        }
        if (J()) {
            this.l.j();
        }
    }

    public void L() {
        if (b.c()) {
            c("onAdVideoBarClick");
            return;
        }
        com.bytedance.sdk.openadsdk.a.c.c cVar = this.R;
        if (cVar != null) {
            cVar.b();
        }
    }

    public void f(int i) {
        if (i == 10002) {
            M();
        }
    }

    public void finish() {
        this.p.b(this.F);
        try {
            O();
        } catch (Exception unused) {
        }
        super.finish();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        O();
        if (b.c()) {
            c("recycleRes");
        }
        this.R = null;
    }

    /* access modifiers changed from: protected */
    public void finalize() throws Throwable {
        super.finalize();
        S = null;
    }

    private void O() {
        if (!this.G) {
            this.G = true;
            if (b.c()) {
                c("onAdClose");
                return;
            }
            com.bytedance.sdk.openadsdk.a.c.c cVar = this.R;
            if (cVar != null) {
                cVar.c();
            }
        }
    }

    /* access modifiers changed from: protected */
    public void M() {
        if (b.c()) {
            c("onVideoComplete");
            return;
        }
        com.bytedance.sdk.openadsdk.a.c.c cVar = this.R;
        if (cVar != null) {
            cVar.d();
        }
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        super.onStop();
        if (b(this.c) && !a(this.c)) {
            if (this.T) {
                this.T = false;
                finish();
            } else if (this.o.y()) {
                finish();
            }
        }
    }

    private boolean a(n nVar) {
        return nVar == null || nVar.an() == 100.0f;
    }

    private boolean b(n nVar) {
        if (nVar == null) {
            return false;
        }
        return m.d().q(String.valueOf(this.t));
    }
}
