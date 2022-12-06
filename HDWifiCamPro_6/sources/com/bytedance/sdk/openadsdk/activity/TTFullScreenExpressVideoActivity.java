package com.bytedance.sdk.openadsdk.activity;

import android.text.TextUtils;
import com.bykv.vk.openvk.component.video.api.d.c;
import com.bytedance.sdk.component.utils.l;
import com.bytedance.sdk.openadsdk.c.f;
import com.bytedance.sdk.openadsdk.component.reward.b.c;
import com.bytedance.sdk.openadsdk.core.model.n;
import com.bytedance.sdk.openadsdk.core.model.p;
import com.mbridge.msdk.MBridgeConstans;
import java.util.HashMap;
import java.util.Map;

public class TTFullScreenExpressVideoActivity extends TTFullScreenVideoActivity {
    /* access modifiers changed from: protected */
    public boolean J() {
        return true;
    }

    /* access modifiers changed from: protected */
    public void n() {
    }

    /* access modifiers changed from: protected */
    public void t() {
        if (this.c == null) {
            finish();
            return;
        }
        this.o.a(false);
        super.t();
    }

    /* access modifiers changed from: protected */
    public void d() {
        super.d();
        if (p.i(this.c)) {
            this.o.a(true);
            this.o.b();
            a(false);
            return;
        }
        d(0);
    }

    public boolean a(long j, boolean z) {
        f fVar;
        if (this.l == null || this.l.a() == null) {
            fVar = new f();
        } else {
            fVar = this.l.a().getAdShowTime();
        }
        f fVar2 = fVar;
        if (this.L == null || !(this.L instanceof c) || this.M) {
            this.m.a(this.l.b(), this.c, this.a, I(), fVar2);
        } else {
            this.m.a(((c) this.L).d(), this.c, this.a, I(), fVar2);
        }
        HashMap hashMap = new HashMap();
        if (this.l != null) {
            hashMap.put("dynamic_show_type", Integer.valueOf(this.l.i()));
        }
        if (!TextUtils.isEmpty(this.D)) {
            hashMap.put("rit_scene", this.D);
        }
        this.m.a((Map<String, Object>) hashMap);
        this.m.a((c.a) new c.a() {
            public void a(long j, int i) {
                TTFullScreenExpressVideoActivity.this.q.removeMessages(ms.bd.o.Pgl.c.COLLECT_MODE_FINANCE);
                TTFullScreenExpressVideoActivity.this.E();
                TTFullScreenExpressVideoActivity.this.l.b(true);
                TTFullScreenExpressVideoActivity.this.M();
                if (TTFullScreenExpressVideoActivity.this.h()) {
                    TTFullScreenExpressVideoActivity.this.a(false);
                } else if (n.c(TTFullScreenExpressVideoActivity.this.c)) {
                    TTFullScreenExpressVideoActivity.this.finish();
                } else if (TTFullScreenExpressVideoActivity.this.l != null && TTFullScreenExpressVideoActivity.this.l.a() != null) {
                    TTFullScreenExpressVideoActivity.this.l.a().a(MBridgeConstans.ENDCARD_URL_TYPE_PL, 0, 0, false);
                    if (TTFullScreenExpressVideoActivity.this.l.h()) {
                        TTFullScreenExpressVideoActivity.this.k.a(MBridgeConstans.ENDCARD_URL_TYPE_PL, (CharSequence) "X");
                        TTFullScreenExpressVideoActivity.this.k.e(true);
                    }
                }
            }

            public void b(long j, int i) {
                TTFullScreenExpressVideoActivity.this.q.removeMessages(ms.bd.o.Pgl.c.COLLECT_MODE_FINANCE);
                TTFullScreenExpressVideoActivity.this.D();
                if (!TTFullScreenExpressVideoActivity.this.m.b()) {
                    TTFullScreenExpressVideoActivity.this.E();
                    TTFullScreenExpressVideoActivity.this.m.m();
                    l.c("TTFullScreenExpressVideoActivity", "fullscreen_interstitial_ad", "onError、、、、、、、、");
                    TTFullScreenExpressVideoActivity.this.l.a(true);
                    if (TTFullScreenExpressVideoActivity.this.h()) {
                        TTFullScreenExpressVideoActivity.this.a(false);
                        TTFullScreenExpressVideoActivity.this.m.a(true ^ TTFullScreenExpressVideoActivity.this.m.B() ? 1 : 0, 2);
                        return;
                    }
                    TTFullScreenExpressVideoActivity.this.finish();
                }
            }

            public void a() {
                TTFullScreenExpressVideoActivity.this.q.removeMessages(ms.bd.o.Pgl.c.COLLECT_MODE_FINANCE);
                TTFullScreenExpressVideoActivity.this.E();
                l.a("TTFullScreenExpressVideoActivity", "fullscreen_interstitial_ad", "onTimeOut、、、、、、、、");
                if (TTFullScreenExpressVideoActivity.this.h()) {
                    TTFullScreenExpressVideoActivity.this.a(false);
                } else {
                    TTFullScreenExpressVideoActivity.this.finish();
                }
                TTFullScreenExpressVideoActivity.this.m.a(TTFullScreenExpressVideoActivity.this.m.B() ^ true ? 1 : 0, TTFullScreenExpressVideoActivity.this.m.B() ^ true ? 1 : 0);
                TTFullScreenExpressVideoActivity.this.m.m();
            }

            public void a(long j, long j2) {
                if (!TTFullScreenExpressVideoActivity.this.H && TTFullScreenExpressVideoActivity.this.m.b()) {
                    TTFullScreenExpressVideoActivity.this.m.o();
                }
                if (!TTFullScreenExpressVideoActivity.this.v.get()) {
                    TTFullScreenExpressVideoActivity.this.q.removeMessages(ms.bd.o.Pgl.c.COLLECT_MODE_FINANCE);
                    if (j != TTFullScreenExpressVideoActivity.this.m.f()) {
                        TTFullScreenExpressVideoActivity.this.E();
                    }
                    if (TTFullScreenExpressVideoActivity.this.m.b()) {
                        TTFullScreenExpressVideoActivity.this.m.a(j);
                        TTFullScreenExpressVideoActivity tTFullScreenExpressVideoActivity = TTFullScreenExpressVideoActivity.this;
                        long j3 = j / 1000;
                        tTFullScreenExpressVideoActivity.s = (int) (tTFullScreenExpressVideoActivity.m.C() - ((double) j3));
                        int i = (int) j3;
                        if ((TTFullScreenExpressVideoActivity.this.A.get() || TTFullScreenExpressVideoActivity.this.y.get()) && TTFullScreenExpressVideoActivity.this.m.b()) {
                            TTFullScreenExpressVideoActivity.this.m.o();
                        }
                        if (!(TTFullScreenExpressVideoActivity.this.l == null || TTFullScreenExpressVideoActivity.this.l.a() == null)) {
                            TTFullScreenExpressVideoActivity.this.l.a().a(String.valueOf(TTFullScreenExpressVideoActivity.this.s), i, 0, false);
                        }
                        if (TTFullScreenExpressVideoActivity.this.l.h() || TTFullScreenExpressVideoActivity.this.c.ba()) {
                            TTFullScreenExpressVideoActivity.this.e(i);
                            if (TTFullScreenExpressVideoActivity.this.s >= 0) {
                                TTFullScreenExpressVideoActivity.this.k.d(true);
                                TTFullScreenExpressVideoActivity.this.k.a(String.valueOf(TTFullScreenExpressVideoActivity.this.s), (CharSequence) null);
                            }
                        }
                        if (TTFullScreenExpressVideoActivity.this.s <= 0) {
                            l.a("TTFullScreenExpressVideoActivity", "fullscreen_interstitial_ad", "onProgressUpdate、、、、、、、、");
                            if (TTFullScreenExpressVideoActivity.this.h()) {
                                TTFullScreenExpressVideoActivity.this.a(false);
                            } else if (n.c(TTFullScreenExpressVideoActivity.this.c)) {
                                TTFullScreenExpressVideoActivity.this.finish();
                            }
                        }
                    }
                }
            }
        });
        return a(j, z, (Map<String, Object>) hashMap);
    }
}
