package com.mbridge.msdk.foundation.same.report;

import android.content.Context;
import android.text.TextUtils;
import androidx.browser.trusted.sharing.ShareTarget;
import androidx.core.app.NotificationCompat;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.db.f;
import com.mbridge.msdk.foundation.db.g;
import com.mbridge.msdk.foundation.db.m;
import com.mbridge.msdk.foundation.entity.CampaignUnit;
import com.mbridge.msdk.foundation.entity.k;
import com.mbridge.msdk.foundation.same.net.g.d;
import com.mbridge.msdk.foundation.same.report.d.a;
import com.mbridge.msdk.foundation.same.report.d.b;
import com.mbridge.msdk.foundation.tools.q;
import com.mbridge.msdk.out.Campaign;
import com.mbridge.msdk.out.Frame;
import com.vungle.warren.VungleApiClient;
import java.io.File;
import java.net.URLEncoder;

/* compiled from: ReportController */
public class c {
    public static final String a = c.class.getSimpleName();
    /* access modifiers changed from: private */
    public Context b;
    private int c = 0;

    public c(Context context, int i) {
        this.b = context;
        this.c = i;
    }

    public c(Context context) {
        this.b = context.getApplicationContext();
    }

    public final void a(int i, String str) {
        new a(this.b).c(0, d.c().a, d.a(NotificationCompat.CATEGORY_EVENT, d.a((Campaign) null, i, "request"), this.b, str), new b() {
            public final void a(String str) {
            }

            public final void b(String str) {
            }
        });
    }

    public final void a(final k kVar, final Boolean bool) {
        if (kVar == null) {
            return;
        }
        if (kVar.c().equals(ShareTarget.METHOD_GET)) {
            new a(this.b).a(0, kVar.b(), (com.mbridge.msdk.foundation.same.net.h.d) null, new b() {
                public final void b(String str) {
                }

                public final void a(String str) {
                    m.a((f) g.a(c.this.b)).a(kVar.b());
                    if (bool.booleanValue() && m.a((f) g.a(c.this.b)).b() > 20) {
                        com.mbridge.msdk.foundation.controller.b.a().c();
                    }
                }
            });
        } else if (kVar.c().equals(ShareTarget.METHOD_POST)) {
            a aVar = new a(this.b);
            if (!TextUtils.isEmpty(kVar.d())) {
                com.mbridge.msdk.foundation.same.net.h.d a2 = d.a(kVar.d(), this.b, kVar.a());
                if (kVar.e() > 0) {
                    a2.a("retry", kVar.e() + "");
                }
                aVar.c(0, kVar.b(), a2, new b() {
                    public final void a(String str) {
                        m.a((f) g.a(c.this.b)).a(kVar.d(), kVar.b(), kVar.f());
                        if (bool.booleanValue() && m.a((f) g.a(c.this.b)).a() > 0) {
                            com.mbridge.msdk.foundation.controller.b.a().c();
                        }
                    }

                    public final void b(String str) {
                        m.a((f) g.a(c.this.b)).a(kVar);
                    }
                });
            }
        }
    }

    public final void a(String str, String str2, String str3) {
        try {
            a aVar = new a(this.b);
            String str4 = "click_type=" + URLEncoder.encode("1", "utf-8") + "&" + "cid" + "=" + URLEncoder.encode(str, "utf-8") + "&" + MBridgeConstans.PROPERTIES_UNIT_ID + "=" + URLEncoder.encode(str2, "utf-8") + "&" + "key" + "=" + URLEncoder.encode("2000027", "utf-8") + "&" + "http_url" + "=" + URLEncoder.encode(str3, "utf-8");
            if (a.a().c()) {
                a.a().a(str4);
                return;
            }
            aVar.c(0, d.c().a, d.a(str4, this.b, str2), new b() {
                public final void a(String str) {
                }

                public final void b(String str) {
                }
            });
        } catch (Exception e) {
            q.d(a, e.getMessage());
        }
    }

    public final void a(String str, final File file) {
        new a(this.b).c(0, d.c().a, d.a(this.b, str), new b() {
            public final void b(String str) {
            }

            public final void a(String str) {
                File file = file;
                if (file != null) {
                    file.delete();
                }
            }
        });
    }

    public final void a(final String str, String str2, String str3, Frame frame) {
        a aVar = new a(this.b);
        com.mbridge.msdk.foundation.same.net.h.d a2 = d.a(str2, this.b, str3);
        if (frame != null) {
            a2.a("session_id", frame.getSessionId());
            a2.a(CampaignUnit.JSON_KEY_PARENT_SESSION_ID, frame.getParentSessionId());
        }
        aVar.c(0, d.c().a, a2, new b() {
            public final void b(String str) {
            }

            public final void a(String str) {
                if ("click_duration".equals(str) || "load_duration".equals(str)) {
                    com.mbridge.msdk.foundation.controller.b.a().c();
                }
            }
        });
    }

    public final void a(String str, com.mbridge.msdk.foundation.entity.d dVar, String str2) {
        a aVar = new a(this.b);
        String a2 = com.mbridge.msdk.foundation.entity.d.a(dVar);
        if (!TextUtils.isEmpty(a2)) {
            if (a.a().c()) {
                a.a().a(a2);
                return;
            }
            aVar.c(0, d.c().a, d.a(a2, this.b, str2), new b() {
                public final void a(String str) {
                }

                public final void b(String str) {
                }
            });
        }
    }

    public final void a() {
        try {
            if (d.a()) {
                a aVar = new a(this.b);
                String h = com.mbridge.msdk.foundation.controller.a.e().h();
                com.mbridge.msdk.b.a b2 = com.mbridge.msdk.b.b.a().b(h);
                if (b2 == null) {
                    b2 = com.mbridge.msdk.b.b.a().b();
                }
                int q = b2.q();
                String str = "key=2000053&Appid=" + h + "&" + "uptips2" + "=" + b2.p() + "&" + "info_status" + "=" + com.mbridge.msdk.foundation.controller.authoritycontroller.a.a().c() + "&" + "iseu" + "=" + q;
                String i = com.mbridge.msdk.foundation.tools.m.i();
                if (!TextUtils.isEmpty(i)) {
                    str = str + "&" + VungleApiClient.GAID + "=" + i;
                }
                String str2 = str + "&" + "GDPR_area" + "=" + b2.af() + "&" + "GDPR_consent" + "=" + com.mbridge.msdk.foundation.controller.authoritycontroller.a.a().e();
                if (a.a().c()) {
                    a.a().a(str2);
                    return;
                }
                aVar.c(0, d.c().a, d.a(str2, this.b, ""), new b() {
                    public final void a(String str) {
                    }

                    public final void b(String str) {
                    }
                });
                d.b();
            }
        } catch (Throwable th) {
            q.d(a, th.getMessage());
        }
    }

    public final void a(int i, int i2, String str, String str2, String str3) {
        try {
            a aVar = new a(this.b);
            StringBuilder sb = new StringBuilder();
            sb.append("key");
            sb.append("=");
            sb.append(URLEncoder.encode("2000058", "utf-8"));
            sb.append("&");
            sb.append("appid");
            sb.append("=");
            sb.append(URLEncoder.encode(com.mbridge.msdk.foundation.controller.a.e().h(), "utf-8"));
            sb.append("&");
            sb.append("dl_type");
            sb.append("=");
            sb.append(URLEncoder.encode(i + "", "utf-8"));
            sb.append("&");
            sb.append("dl_link_type");
            sb.append("=");
            sb.append(URLEncoder.encode(i2 + "", "utf-8"));
            sb.append("&");
            sb.append("rid");
            sb.append("=");
            sb.append(URLEncoder.encode(str, "utf-8"));
            sb.append("&");
            sb.append("rid_n");
            sb.append("=");
            sb.append(URLEncoder.encode(str2, "utf-8"));
            sb.append("&");
            sb.append("cid");
            sb.append("=");
            sb.append(URLEncoder.encode(str3, "utf-8"));
            sb.append("&");
            sb.append("tgt_v");
            sb.append("=");
            sb.append(URLEncoder.encode(com.mbridge.msdk.foundation.tools.m.g(this.b) + "", "utf-8"));
            sb.append("&");
            sb.append("app_v_n");
            sb.append("=");
            sb.append(URLEncoder.encode(com.mbridge.msdk.foundation.tools.m.f(this.b) + "", "utf-8"));
            sb.append("&");
            sb.append("app_v_c");
            sb.append("=");
            sb.append(URLEncoder.encode(com.mbridge.msdk.foundation.tools.m.e(this.b) + "", "utf-8"));
            if (a.a().c()) {
                a.a().a(sb.toString());
                return;
            }
            aVar.c(0, d.c().a, d.a(sb.toString(), this.b, ""), new b() {
                public final void a(String str) {
                }

                public final void b(String str) {
                }
            });
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                e.printStackTrace();
            }
        }
    }

    public final void a(String str, String str2, String str3, String str4, String str5, boolean z) {
        try {
            if (!TextUtils.isEmpty(str5)) {
                a aVar = new a(this.b);
                StringBuilder sb = new StringBuilder();
                if (z) {
                    sb.append("hb=");
                    sb.append(1);
                    sb.append("&");
                }
                sb.append("key");
                sb.append("=");
                sb.append(URLEncoder.encode("2000066", "utf-8"));
                sb.append("&");
                sb.append("rid");
                sb.append("=");
                sb.append(URLEncoder.encode(str, "utf-8"));
                sb.append("&");
                sb.append("rid_n");
                sb.append("=");
                sb.append(URLEncoder.encode(str2, "utf-8"));
                sb.append("&");
                sb.append("cid");
                sb.append("=");
                sb.append(URLEncoder.encode(str3, "utf-8"));
                sb.append("&");
                sb.append(MBridgeConstans.PROPERTIES_UNIT_ID);
                sb.append("=");
                sb.append(URLEncoder.encode(str4, "utf-8"));
                sb.append("&");
                sb.append("err_method");
                sb.append("=");
                sb.append(str5);
                if (a.a().c()) {
                    a.a().a(sb.toString());
                    return;
                }
                aVar.c(0, d.c().a, d.a(sb.toString(), this.b, str4), new b() {
                    public final void a(String str) {
                    }

                    public final void b(String str) {
                    }
                });
            }
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                e.printStackTrace();
            }
        }
    }

    public final void b(String str, String str2, String str3, String str4, String str5, boolean z) {
        try {
            a aVar = new a(this.b);
            StringBuilder sb = new StringBuilder();
            if (z) {
                sb.append("hb=");
                sb.append(1);
                sb.append("&");
            }
            sb.append("key");
            sb.append("=");
            sb.append(URLEncoder.encode("2000065", "utf-8"));
            sb.append("&");
            sb.append("rid");
            sb.append("=");
            sb.append(URLEncoder.encode(str, "utf-8"));
            sb.append("&");
            sb.append("rid_n");
            sb.append("=");
            sb.append(URLEncoder.encode(str2, "utf-8"));
            sb.append("&");
            sb.append("cid");
            sb.append("=");
            sb.append(URLEncoder.encode(str3, "utf-8"));
            sb.append("&");
            sb.append(MBridgeConstans.PROPERTIES_UNIT_ID);
            sb.append("=");
            sb.append(URLEncoder.encode(str4, "utf-8"));
            sb.append("&");
            sb.append("click_url");
            sb.append("=");
            sb.append(URLEncoder.encode(str5, "utf-8"));
            if (a.a().c()) {
                a.a().a(sb.toString());
                return;
            }
            aVar.c(0, d.c().a, d.a(sb.toString(), this.b, str4), new b() {
                public final void a(String str) {
                }

                public final void b(String str) {
                }
            });
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                e.printStackTrace();
            }
        }
    }

    public final void a(String str, String str2, String str3, String str4, String str5) {
        try {
            a aVar = new a(this.b);
            StringBuilder sb = new StringBuilder();
            int n = com.mbridge.msdk.foundation.tools.m.n(this.b);
            sb.append("key");
            sb.append("=");
            sb.append(URLEncoder.encode("2000071", "utf-8"));
            sb.append("&");
            sb.append("rid");
            sb.append("=");
            sb.append(URLEncoder.encode(str, "utf-8"));
            sb.append("&");
            sb.append("rid_n");
            sb.append("=");
            sb.append(URLEncoder.encode(str2, "utf-8"));
            sb.append("&");
            sb.append("cid");
            sb.append("=");
            sb.append(URLEncoder.encode(str3, "utf-8"));
            sb.append("&");
            sb.append(MBridgeConstans.PROPERTIES_UNIT_ID);
            sb.append("=");
            sb.append(URLEncoder.encode(str4, "utf-8"));
            sb.append("&");
            sb.append(IronSourceConstants.EVENTS_ERROR_REASON);
            sb.append("=");
            sb.append(URLEncoder.encode(str5, "utf-8"));
            sb.append("&");
            sb.append("network_type");
            sb.append("=");
            sb.append(URLEncoder.encode(n + "", "utf-8"));
            sb.append("&");
            sb.append(IronSourceConstants.EVENTS_RESULT);
            sb.append("=");
            sb.append(URLEncoder.encode(MBridgeConstans.ENDCARD_URL_TYPE_PL, "utf-8"));
            if (a.a().c()) {
                a.a().a(sb.toString());
                return;
            }
            aVar.c(0, d.c().a, d.a(sb.toString(), this.b, str4), new b() {
                public final void a(String str) {
                }

                public final void b(String str) {
                }
            });
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                e.printStackTrace();
            }
        }
    }

    public final void a(String str, String str2) {
        try {
            a aVar = new a(this.b);
            String h = com.mbridge.msdk.foundation.controller.a.e().h();
            if (com.mbridge.msdk.b.b.a().b(h) == null) {
                com.mbridge.msdk.b.b.a().b();
            }
            String str3 = "key=2000000&Appid=" + h + "&" + IronSourceConstants.EVENTS_ERROR_REASON + "=" + str + "&" + "host" + "=" + str2;
            if (a.a().c()) {
                a.a().a(str3);
                return;
            }
            aVar.c(0, d.c().a, d.a(str3, this.b, ""), new b() {
                public final void a(String str) {
                    q.a("", "reportSettingLoadFailed onSuccess");
                }

                public final void b(String str) {
                    q.a("", "reportSettingLoadFailed onFailed:" + str);
                }
            });
        } catch (Throwable unused) {
            q.d(a, "reportSettingLoadFailed onFailed");
        }
    }
}
