package com.mbridge.msdk.video.module.a.a;

import android.content.Context;
import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.db.f;
import com.mbridge.msdk.foundation.db.g;
import com.mbridge.msdk.foundation.db.i;
import com.mbridge.msdk.foundation.db.j;
import com.mbridge.msdk.foundation.db.o;
import com.mbridge.msdk.foundation.db.p;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.e;
import com.mbridge.msdk.foundation.entity.m;
import com.mbridge.msdk.foundation.same.a.d;
import com.mbridge.msdk.foundation.same.report.b;
import com.mbridge.msdk.foundation.tools.q;
import com.mbridge.msdk.foundation.tools.x;
import com.mbridge.msdk.videocommon.b.c;
import com.mbridge.msdk.videocommon.download.a;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: StatisticsOnNotifyListener */
public class k extends f {
    protected boolean a;
    protected CampaignEx b;
    protected boolean c = false;
    protected a d;
    protected c e;
    protected String f;
    protected String g;
    protected com.mbridge.msdk.video.module.a.a h = new f();
    protected int i = 1;
    private boolean j = false;
    private boolean k = false;
    private boolean l = false;

    public k(CampaignEx campaignEx, a aVar, c cVar, String str, String str2, com.mbridge.msdk.video.module.a.a aVar2, int i2, boolean z) {
        if (!z && campaignEx != null && x.b(str2) && aVar != null && aVar2 != null) {
            this.b = campaignEx;
            this.g = str;
            this.f = str2;
            this.d = aVar;
            this.e = cVar;
            this.h = aVar2;
            this.a = true;
            this.i = i2;
            this.c = false;
        } else if (z && campaignEx != null && x.b(str2) && aVar2 != null) {
            this.b = campaignEx;
            this.g = str;
            this.f = str2;
            this.d = aVar;
            this.e = cVar;
            this.h = aVar2;
            this.a = true;
            this.i = i2;
            this.c = true;
        }
    }

    public void a(int i2, Object obj) {
        super.a(i2, obj);
        this.h.a(i2, obj);
    }

    public final void a(int i2) {
        if (this.b == null) {
            return;
        }
        if (i2 == 1 || i2 == 2) {
            com.mbridge.msdk.video.module.b.a.a(com.mbridge.msdk.foundation.controller.a.e().g(), this.b, i2, this.i);
        }
    }

    public final void a() {
        if (this.a && this.b != null) {
            m mVar = new m("2000061", this.b.getId(), this.b.getRequestId(), this.b.getRequestIdNotice(), this.f, com.mbridge.msdk.foundation.tools.m.n(com.mbridge.msdk.foundation.controller.a.e().g()));
            mVar.a(this.b.isMraid() ? m.a : m.b);
            b.b(mVar, com.mbridge.msdk.foundation.controller.a.e().g(), this.f);
        }
    }

    public final void a(int i2, String str) {
        if (this.b != null) {
            b.c(new m("2000062", this.b.getId(), this.b.getRequestId(), this.b.getRequestIdNotice(), this.f, com.mbridge.msdk.foundation.tools.m.n(com.mbridge.msdk.foundation.controller.a.e().g()), i2, str), com.mbridge.msdk.foundation.controller.a.e().g(), this.f);
        }
    }

    public final void b(int i2) {
        CampaignEx campaignEx = this.b;
        if (campaignEx != null) {
            String noticeUrl = campaignEx.getNoticeUrl();
            if (TextUtils.isEmpty(noticeUrl)) {
                return;
            }
            if (i2 == 1 || i2 == 2) {
                if (!noticeUrl.contains("endscreen_type")) {
                    StringBuilder sb = new StringBuilder(noticeUrl);
                    if (noticeUrl.contains("?")) {
                        sb.append("&endscreen_type=");
                        sb.append(i2);
                    } else {
                        sb.append("?endscreen_type=");
                        sb.append(i2);
                    }
                    noticeUrl = sb.toString();
                } else if (i2 == 2) {
                    if (noticeUrl.contains("endscreen_type=1")) {
                        noticeUrl = noticeUrl.replace("endscreen_type=1", "endscreen_type=2");
                    }
                } else if (noticeUrl.contains("endscreen_type=2")) {
                    noticeUrl = noticeUrl.replace("endscreen_type=2", "endscreen_type=1");
                }
                this.b.setNoticeUrl(noticeUrl);
            }
        }
    }

    public final void b() {
        try {
            if (this.a && this.b != null && x.b(this.f) && com.mbridge.msdk.foundation.controller.a.e().g() != null) {
                i a2 = i.a((f) g.a(com.mbridge.msdk.foundation.controller.a.e().g()));
                e eVar = new e();
                eVar.a(System.currentTimeMillis());
                eVar.b(this.f);
                eVar.a(this.b.getId());
                a2.a(eVar);
            }
        } catch (Throwable th) {
            q.a("NotifyListener", th.getMessage(), th);
        }
    }

    public final void c() {
        try {
            if (this.a && this.b != null && x.b(this.f)) {
                com.mbridge.msdk.videocommon.a.a.a().a(this.b, this.f);
            }
            com.mbridge.msdk.foundation.same.f.b.a().execute(new Runnable() {
                public final void run() {
                    try {
                        com.mbridge.msdk.videocommon.a.a.a().c(k.this.g, k.this.b.getAdType());
                    } catch (Exception e) {
                        if (MBridgeConstans.DEBUG) {
                            e.printStackTrace();
                        }
                    } catch (Throwable th) {
                        q.a("NotifyListener", th.getMessage());
                    }
                }
            });
        } catch (Throwable th) {
            q.a("NotifyListener", th.getMessage(), th);
        }
    }

    /* access modifiers changed from: protected */
    public final void d() {
        a aVar = this.d;
        if (aVar != null) {
            aVar.b(true);
        }
    }

    /* access modifiers changed from: protected */
    public final void e() {
        String str;
        try {
            if (this.b != null && this.b.isDynamicView() && d.a.containsKey(this.b.getOnlyImpressionURL())) {
                this.k = true;
            } else if (this.a && !TextUtils.isEmpty(this.b.getOnlyImpressionURL()) && d.a != null && !d.a.containsKey(this.b.getOnlyImpressionURL()) && !this.k) {
                d.a.put(this.b.getOnlyImpressionURL(), Long.valueOf(System.currentTimeMillis()));
                String onlyImpressionURL = this.b.getOnlyImpressionURL();
                if (this.b.getSpareOfferFlag() == 1) {
                    str = onlyImpressionURL + "&to=1&cbt=" + this.b.getCbt() + "&tmorl=" + this.i;
                } else {
                    str = onlyImpressionURL + "&to=0&cbt=" + this.b.getCbt() + "&tmorl=" + this.i;
                }
                String str2 = str;
                if (!this.c) {
                    com.mbridge.msdk.click.a.a(com.mbridge.msdk.foundation.controller.a.e().g(), this.b, this.f, str2, false, true);
                    c();
                }
                this.k = true;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* access modifiers changed from: protected */
    public final void f() {
        String str;
        try {
            if (this.a && !this.j && !TextUtils.isEmpty(this.b.getImpressionURL())) {
                this.j = true;
                if (this.b.isBidCampaign() && this.b != null) {
                    HashMap hashMap = new HashMap();
                    List<com.mbridge.msdk.foundation.entity.c> b2 = com.mbridge.msdk.foundation.db.b.a(com.mbridge.msdk.foundation.controller.a.e().g()).b(this.b.getCampaignUnitId(), this.b.getRequestId());
                    if (!(b2 == null || b2.size() <= 0 || b2.get(0) == null)) {
                        if (b2.get(0).d() == 1) {
                            hashMap.put("encrypt_p=", "encrypt_p=" + b2.get(0).b());
                            hashMap.put("irlfa=", "irlfa=" + 1);
                            for (Map.Entry entry : hashMap.entrySet()) {
                                String str2 = (String) entry.getKey();
                                String str3 = (String) entry.getValue();
                                this.b.setImpressionURL(this.b.getImpressionURL().replaceAll(str2, str3));
                                this.b.setOnlyImpressionURL(this.b.getOnlyImpressionURL().replaceAll(str2, str3));
                            }
                        }
                        q.a("BidReplaceCampignDao", "removeReplace count " + com.mbridge.msdk.foundation.db.b.a(com.mbridge.msdk.foundation.controller.a.e().g()).a(this.b.getRequestId()));
                    }
                }
                String impressionURL = this.b.getImpressionURL();
                if (this.b.getSpareOfferFlag() == 1) {
                    str = impressionURL + "&to=1&cbt=" + this.b.getCbt() + "&tmorl=" + this.i;
                } else {
                    str = impressionURL + "&to=0&cbt=" + this.b.getCbt() + "&tmorl=" + this.i;
                }
                com.mbridge.msdk.click.a.a(com.mbridge.msdk.foundation.controller.a.e().g(), this.b, this.f, str, false, true);
                com.mbridge.msdk.video.module.b.a.a(com.mbridge.msdk.foundation.controller.a.e().g(), this.b);
                new Thread(new Runnable() {
                    public final void run() {
                        try {
                            j.a((f) g.a(com.mbridge.msdk.foundation.controller.a.e().g())).b(k.this.b.getId());
                        } catch (Throwable th) {
                            q.a("NotifyListener", th.getMessage(), th);
                        }
                    }
                }).start();
                if (this.a && d.d != null && !TextUtils.isEmpty(this.b.getId())) {
                    d.a(this.f, this.b, "reward");
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        } catch (Throwable th) {
            q.a("NotifyListener", th.getMessage(), th);
        }
    }

    /* access modifiers changed from: protected */
    public final void g() {
        List<String> pv_urls;
        try {
            if (this.a && !this.l && this.b != null) {
                this.l = true;
                if (!this.c && !this.b.isDynamicView() && (pv_urls = this.b.getPv_urls()) != null && pv_urls.size() > 0) {
                    for (String a2 : pv_urls) {
                        com.mbridge.msdk.click.a.a(com.mbridge.msdk.foundation.controller.a.e().g(), this.b, this.f, a2, false, true);
                    }
                }
            }
        } catch (Throwable th) {
            q.d("NotifyListener", th.getMessage());
        }
    }

    /* access modifiers changed from: protected */
    public final void h() {
        CampaignEx campaignEx = this.b;
        if (campaignEx != null && !TextUtils.isEmpty(campaignEx.getCampaignUnitId()) && this.b.getNativeVideoTracking() != null && this.b.getNativeVideoTracking().h() != null) {
            Context g2 = com.mbridge.msdk.foundation.controller.a.e().g();
            CampaignEx campaignEx2 = this.b;
            com.mbridge.msdk.click.a.a(g2, campaignEx2, campaignEx2.getCampaignUnitId(), this.b.getNativeVideoTracking().h(), false, false);
        }
    }

    /* access modifiers changed from: protected */
    public final void i() {
        try {
            if (this.a && this.d != null) {
                if (this.d.g() != null && !TextUtils.isEmpty(this.d.g().getVideoUrlEncode())) {
                    o.a((f) g.a(com.mbridge.msdk.foundation.controller.a.e().g())).b(this.d.g().getVideoUrlEncode());
                }
                if (!TextUtils.isEmpty(this.d.d())) {
                    File file = new File(this.d.d());
                    if (file.exists() && file.isFile() && file.delete()) {
                        q.a("NotifyListener", "DEL File :" + file.getAbsolutePath());
                    }
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* access modifiers changed from: protected */
    public final void a(String str) {
        try {
            if (this.a) {
                p a2 = p.a((f) g.a(com.mbridge.msdk.foundation.controller.a.e().g()));
                m mVar = null;
                if (!TextUtils.isEmpty(this.b.getNoticeUrl())) {
                    int n = com.mbridge.msdk.foundation.tools.m.n(com.mbridge.msdk.foundation.controller.a.e().g());
                    mVar = new m("2000021", n, this.b.getNoticeUrl(), str, com.mbridge.msdk.foundation.tools.m.a(com.mbridge.msdk.foundation.controller.a.e().g(), n));
                } else if (!TextUtils.isEmpty(this.b.getClickURL())) {
                    int n2 = com.mbridge.msdk.foundation.tools.m.n(com.mbridge.msdk.foundation.controller.a.e().g());
                    mVar = new m("2000021", n2, this.b.getClickURL(), str, com.mbridge.msdk.foundation.tools.m.a(com.mbridge.msdk.foundation.controller.a.e().g(), n2));
                }
                if (mVar != null) {
                    mVar.n(this.b.getId());
                    mVar.e(this.b.getVideoUrlEncode());
                    mVar.p(str);
                    mVar.k(this.b.getRequestId());
                    mVar.l(this.b.getRequestIdNotice());
                    mVar.m(this.f);
                    a2.a(mVar);
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
