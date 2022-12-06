package com.mbridge.msdk.advanced.b;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import androidx.work.WorkRequest;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.advanced.common.b;
import com.mbridge.msdk.advanced.e.c;
import com.mbridge.msdk.advanced.view.MBNativeAdvancedView;
import com.mbridge.msdk.advanced.view.MBNativeAdvancedWebview;
import com.mbridge.msdk.b.d;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.CampaignUnit;
import com.mbridge.msdk.foundation.tools.SameMD5;
import com.mbridge.msdk.foundation.tools.q;
import com.mbridge.msdk.foundation.tools.u;
import com.mbridge.msdk.foundation.tools.x;
import com.mbridge.msdk.videocommon.download.g;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/* compiled from: NativeAdvancedLoadManager */
public final class a {
    private static String a = "NativeAdvancedLoadManager";
    /* access modifiers changed from: private */
    public String b;
    private String c;
    private long d;
    private com.mbridge.msdk.advanced.a.a e;
    private Context f = com.mbridge.msdk.foundation.controller.a.e().g();
    /* access modifiers changed from: private */
    public MBNativeAdvancedView g;
    private d h;
    private CampaignEx i;
    private int j;
    private int k;
    private int l;
    private int m;
    /* access modifiers changed from: private */
    public String n;
    /* access modifiers changed from: private */
    public int o;
    private boolean p;
    private volatile boolean q;
    private com.mbridge.msdk.videocommon.listener.a r;
    private g.d s;
    private g.d t;
    private String u;
    /* access modifiers changed from: private */
    public int v;
    /* access modifiers changed from: private */
    public String w = "";
    /* access modifiers changed from: private */
    public Handler x = new Handler(Looper.getMainLooper()) {
        public final void handleMessage(Message message) {
            Object obj;
            super.handleMessage(message);
            int i = message.what;
            if (i == 1) {
                Object obj2 = message.obj;
                int i2 = message.arg1;
                if (obj2 != null && (obj2 instanceof CampaignEx)) {
                    CampaignEx campaignEx = (CampaignEx) obj2;
                    a.a(a.this, g.a().b(campaignEx.getAdZip()), campaignEx, i2);
                }
            } else if (i == 2) {
                Object obj3 = message.obj;
                if (obj3 != null && (obj3 instanceof String)) {
                    a.this.a(obj3.toString(), a.this.n, a.this.o);
                }
            } else if (i == 3) {
                Object obj4 = message.obj;
                if (obj4 != null && (obj4 instanceof CampaignEx)) {
                    a aVar = a.this;
                    aVar.b((CampaignEx) obj4, aVar.o);
                }
            } else if (i == 4) {
                Object obj5 = message.obj;
                if (obj5 != null && (obj5 instanceof CampaignEx)) {
                    if (a.this.g != null) {
                        a.this.g.setEndCardReady(true);
                    }
                    a aVar2 = a.this;
                    aVar2.b((CampaignEx) obj5, aVar2.o);
                }
            } else if (i == 5 && (obj = message.obj) != null && (obj instanceof CampaignEx)) {
                if (a.this.g != null) {
                    a.this.g.setVideoReady(true);
                }
                a aVar3 = a.this;
                aVar3.b((CampaignEx) obj, aVar3.o);
            }
        }
    };
    private Runnable y = new Runnable() {
        public final void run() {
            a aVar = a.this;
            aVar.a("load timeout", aVar.n, a.this.o);
        }
    };

    public a(String str, String str2, long j2) {
        this.c = str;
        this.b = str2;
    }

    public final void a(d dVar) {
        this.h = dVar;
    }

    public final void a(MBNativeAdvancedView mBNativeAdvancedView) {
        this.g = mBNativeAdvancedView;
    }

    public final void a(int i2) {
        this.j = i2;
    }

    public final void a(int i2, int i3) {
        this.m = i2;
        this.l = i3;
    }

    public final void a(String str, int i2) {
        CampaignEx campaignEx;
        this.q = false;
        this.n = str;
        this.o = i2;
        this.i = null;
        if (this.g == null) {
            a("MBAdvancedNativeView is null", str, i2);
            return;
        }
        if (TextUtils.isEmpty(this.n)) {
            campaignEx = c.a(this.g, this.c, this.b, str, this.j, false, false);
        } else {
            campaignEx = c.a(this.g, this.c, this.b, str, this.j, false, true);
        }
        long timestamp = campaignEx != null ? campaignEx.getTimestamp() : 0;
        d dVar = this.h;
        if (dVar == null || dVar.m() != 1 || this.g == null || campaignEx == null) {
            this.p = false;
            d dVar2 = this.h;
            if (dVar2 != null) {
                List<Integer> r2 = dVar2.r();
                if (r2 == null || r2.size() <= 0) {
                    this.d = WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS;
                } else {
                    this.d = (long) (r2.get(0).intValue() * 1000);
                }
            } else {
                this.d = WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS;
            }
            if (this.h == null || timestamp <= 0 || !TextUtils.isEmpty(str)) {
                a(this.d);
                a(this.f, str, i2);
            } else if (System.currentTimeMillis() - timestamp > ((long) (this.h.w() * 1000))) {
                a(this.d);
                a(this.f, str, i2);
            } else {
                a(campaignEx, i2);
            }
        } else {
            a(campaignEx, i2);
        }
    }

    private void a(long j2) {
        this.x.postDelayed(this.y, j2);
    }

    public final String a() {
        return this.w;
    }

    private void a(Context context, final String str, final int i2) {
        b.a();
        if (context == null) {
            try {
                a("Context is null", str, i2);
            } catch (Exception e2) {
                e2.printStackTrace();
                a("Load exception", str, i2);
                this.v = 0;
            }
        } else if (x.a(this.b)) {
            a("UnitId is null", str, i2);
        } else {
            com.mbridge.msdk.foundation.same.net.h.d a2 = a(i2, this.u);
            if (a2 == null) {
                a("Load param is null", str, i2);
                return;
            }
            if (a2 != null && !TextUtils.isEmpty(str)) {
                a2.a("token", str);
            }
            String e3 = u.e(this.b);
            if (!TextUtils.isEmpty(e3)) {
                a2.a("j", e3);
            }
            com.mbridge.msdk.advanced.e.a aVar = new com.mbridge.msdk.advanced.e.a(context);
            AnonymousClass6 r5 = new c(i2) {
                public final void a(CampaignUnit campaignUnit, final int i) {
                    try {
                        a.a(a.this, campaignUnit, i, a.this.b, str);
                        String unused = a.this.w = campaignUnit.getRequestId();
                    } catch (Exception e) {
                        e.printStackTrace();
                        if (a.this.x != null) {
                            a.this.x.post(new Runnable() {
                                public final void run() {
                                    a.this.a("Exception after load success", str, i);
                                }
                            });
                        }
                        a.this.v = 0;
                    }
                }

                public final void a(int i, final String str) {
                    if (a.this.x != null) {
                        a.this.x.post(new Runnable() {
                            public final void run() {
                                a.this.a(str, str, i2);
                            }
                        });
                    }
                    a.this.v = 0;
                }
            };
            r5.a(str);
            r5.d = this.b;
            r5.e = this.c;
            r5.f = 298;
            if (!com.mbridge.msdk.foundation.same.net.g.d.c().b() || !TextUtils.isEmpty(str)) {
                aVar.a(1, com.mbridge.msdk.foundation.same.net.g.d.c().a(str), a2, r5);
            } else {
                aVar.b(1, com.mbridge.msdk.foundation.same.net.g.d.c().a(str), a2, r5);
            }
        }
    }

    private com.mbridge.msdk.foundation.same.net.h.d a(int i2, String str) {
        String h2 = com.mbridge.msdk.foundation.controller.a.e().h();
        String md5 = SameMD5.getMD5(com.mbridge.msdk.foundation.controller.a.e().h() + com.mbridge.msdk.foundation.controller.a.e().i());
        com.mbridge.msdk.foundation.same.net.h.d dVar = new com.mbridge.msdk.foundation.same.net.h.d();
        String a2 = com.mbridge.msdk.foundation.same.a.d.a(this.b, "h5_native");
        String b2 = u.b(this.f, this.b);
        com.mbridge.msdk.foundation.same.net.g.b.a(dVar, "app_id", h2);
        com.mbridge.msdk.foundation.same.net.g.b.a(dVar, MBridgeConstans.PROPERTIES_UNIT_ID, this.b);
        if (!TextUtils.isEmpty(this.c)) {
            com.mbridge.msdk.foundation.same.net.g.b.a(dVar, MBridgeConstans.PLACEMENT_ID, this.c);
        }
        com.mbridge.msdk.foundation.same.net.g.b.a(dVar, "sign", md5);
        com.mbridge.msdk.foundation.same.net.g.b.a(dVar, "req_type", i2 + "");
        com.mbridge.msdk.foundation.same.net.g.b.a(dVar, "ad_num", "1");
        com.mbridge.msdk.foundation.same.net.g.b.a(dVar, "tnum", "1");
        com.mbridge.msdk.foundation.same.net.g.b.a(dVar, "only_impression", "1");
        com.mbridge.msdk.foundation.same.net.g.b.a(dVar, "ping_mode", "1");
        com.mbridge.msdk.foundation.same.net.g.b.a(dVar, com.mbridge.msdk.foundation.same.net.h.d.b, a2);
        com.mbridge.msdk.foundation.same.net.g.b.a(dVar, com.mbridge.msdk.foundation.same.net.h.d.c, b2);
        com.mbridge.msdk.foundation.same.net.g.b.a(dVar, com.mbridge.msdk.foundation.same.net.h.d.a, str);
        com.mbridge.msdk.foundation.same.net.g.b.a(dVar, "ad_type", 298 + "");
        com.mbridge.msdk.foundation.same.net.g.b.a(dVar, "offset", this.v + "");
        com.mbridge.msdk.foundation.same.net.g.b.a(dVar, CampaignUnit.JSON_KEY_UNIT_SIZE, this.m + "x" + this.l);
        return dVar;
    }

    public final void a(com.mbridge.msdk.advanced.a.a aVar) {
        this.e = aVar;
    }

    public final void b() {
        if (this.e != null) {
            this.e = null;
        }
        a("LoadManager release", this.n, this.o);
        if (this.r != null) {
            this.r = null;
        }
        if (this.s != null) {
            this.s = null;
        }
    }

    private void a(CampaignEx campaignEx, int i2) {
        this.i = campaignEx;
        if (c.a(this.g, campaignEx, this.c, this.b)) {
            b(campaignEx, i2);
        } else {
            c(campaignEx, i2);
        }
    }

    /* access modifiers changed from: private */
    public void b(CampaignEx campaignEx, int i2) {
        if (c.a(this.g, campaignEx, this.c, this.b) && !this.q) {
            c();
            c.a(campaignEx, this.b);
            this.q = true;
            com.mbridge.msdk.advanced.a.a aVar = this.e;
            if (aVar != null) {
                aVar.a(campaignEx, i2);
            }
        }
    }

    /* access modifiers changed from: private */
    public void a(String str, String str2, int i2) {
        if (this.p) {
            this.p = false;
            a(str, i2, str2);
            return;
        }
        b(str, i2);
    }

    private void a(String str, int i2, String str2) {
        CampaignEx a2 = c.a(this.g, this.c, this.b, str2, this.j, true, true);
        if (a2 != null) {
            a(a2, i2);
        } else {
            b(str, i2);
        }
    }

    private void b(String str, int i2) {
        if (!this.q) {
            c();
            this.q = true;
            com.mbridge.msdk.advanced.a.a aVar = this.e;
            if (aVar != null) {
                aVar.a(str, i2);
            }
        }
    }

    private void c() {
        this.x.removeCallbacks(this.y);
    }

    private void c(CampaignEx campaignEx, int i2) {
        MBNativeAdvancedView mBNativeAdvancedView = this.g;
        if (mBNativeAdvancedView != null) {
            mBNativeAdvancedView.clearResState();
        }
        if (!TextUtils.isEmpty(campaignEx.getAdZip())) {
            h(campaignEx, i2);
        }
        if (!TextUtils.isEmpty(campaignEx.getAdHtml())) {
            g(campaignEx, i2);
        }
        if (!TextUtils.isEmpty(campaignEx.getVideoUrlEncode())) {
            i(campaignEx, i2);
        }
        if (!TextUtils.isEmpty(campaignEx.getImageUrl())) {
            f(campaignEx, i2);
        }
        if (!TextUtils.isEmpty(campaignEx.getendcard_url())) {
            e(campaignEx, i2);
        }
        if (!TextUtils.isEmpty(campaignEx.getGifUrl())) {
            d(campaignEx, i2);
        }
    }

    private void d(final CampaignEx campaignEx, final int i2) {
        com.mbridge.msdk.foundation.same.c.b.a(com.mbridge.msdk.foundation.controller.a.e().g()).a(campaignEx.getGifUrl(), (com.mbridge.msdk.foundation.same.c.c) new com.mbridge.msdk.foundation.same.c.c() {
            public final void onSuccessLoad(Bitmap bitmap, String str) {
                if (a.this.x != null) {
                    a.this.x.post(new Runnable() {
                        public final void run() {
                            a.this.b(campaignEx, i2);
                        }
                    });
                }
            }

            public final void onFailedLoad(String str, String str2) {
                if (a.this.x != null) {
                    a.this.x.post(new Runnable() {
                        public final void run() {
                            a.this.b(campaignEx, i2);
                        }
                    });
                }
            }
        });
    }

    private void e(final CampaignEx campaignEx, final int i2) {
        this.t = new g.d() {
            public final void a(String str) {
                if (a.this.x != null) {
                    Message obtain = Message.obtain();
                    obtain.what = 4;
                    obtain.obj = campaignEx;
                    obtain.arg1 = i2;
                    a.this.x.sendMessage(obtain);
                }
            }

            public final void a(String str, String str2) {
                if (a.this.g != null) {
                    a.this.g.setEndCardReady(false);
                }
                Message obtain = Message.obtain();
                obtain.what = 2;
                obtain.obj = str;
                a.this.x.sendMessage(obtain);
            }
        };
        g.a().b(campaignEx.getendcard_url(), this.t);
    }

    private void f(final CampaignEx campaignEx, final int i2) {
        com.mbridge.msdk.foundation.same.c.b.a(com.mbridge.msdk.foundation.controller.a.e().g()).a(campaignEx.getImageUrl(), (com.mbridge.msdk.foundation.same.c.c) new com.mbridge.msdk.foundation.same.c.c() {
            public final void onSuccessLoad(Bitmap bitmap, String str) {
                if (a.this.x != null) {
                    a.this.x.post(new Runnable() {
                        public final void run() {
                            a.this.b(campaignEx, i2);
                        }
                    });
                }
            }

            public final void onFailedLoad(String str, String str2) {
                if (a.this.x != null) {
                    a.this.x.post(new Runnable() {
                        public final void run() {
                            a.this.b(campaignEx, i2);
                        }
                    });
                }
            }
        });
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x008a, code lost:
        if (r2 != null) goto L_0x008c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:?, code lost:
        r2.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00a8, code lost:
        if (r2 != null) goto L_0x008c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00af, code lost:
        if (r6.exists() == false) goto L_0x00d3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00b5, code lost:
        if (r6.isFile() == false) goto L_0x00d3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00bb, code lost:
        if (r6.canRead() == false) goto L_0x00d3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00bd, code lost:
        r9.setAdHtml(r6.getAbsolutePath());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00c6, code lost:
        if (r8.x == null) goto L_0x00da;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00c8, code lost:
        r8.x.post(new com.mbridge.msdk.advanced.b.a.AnonymousClass10(r8));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00d3, code lost:
        a("html file write failed", r8.n, r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00da, code lost:
        if (r2 == null) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:?, code lost:
        r2.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x00e6, code lost:
        r9 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x00e8, code lost:
        r9 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:?, code lost:
        a(r9.getMessage(), r8.n, r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x00f2, code lost:
        if (r2 == null) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x00f6, code lost:
        if (r2 != null) goto L_0x00f8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:?, code lost:
        r2.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x00fb, code lost:
        throw r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:?, code lost:
        return;
     */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00e2 A[SYNTHETIC, Splitter:B:51:0x00e2] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void g(final com.mbridge.msdk.foundation.entity.CampaignEx r9, final int r10) {
        /*
            r8 = this;
            java.lang.String r0 = "8"
            java.lang.String r1 = ""
            r2 = 0
            java.lang.String r3 = r9.getAdHtml()     // Catch:{ Exception -> 0x0097 }
            java.io.File r4 = new java.io.File     // Catch:{ Exception -> 0x0097 }
            r4.<init>(r3)     // Catch:{ Exception -> 0x0097 }
            boolean r3 = r4.exists()     // Catch:{ Exception -> 0x0092 }
            if (r3 != 0) goto L_0x0084
            com.mbridge.msdk.foundation.same.b.c r3 = com.mbridge.msdk.foundation.same.b.c.MBRIDGE_700_HTML     // Catch:{ Exception -> 0x0092 }
            java.lang.String r3 = com.mbridge.msdk.foundation.same.b.e.b(r3)     // Catch:{ Exception -> 0x0092 }
            java.lang.String r5 = r9.getAdHtml()     // Catch:{ Exception -> 0x0092 }
            java.lang.String r5 = com.mbridge.msdk.foundation.tools.y.a(r5)     // Catch:{ Exception -> 0x0092 }
            java.lang.String r5 = com.mbridge.msdk.foundation.tools.SameMD5.getMD5(r5)     // Catch:{ Exception -> 0x0092 }
            boolean r6 = android.text.TextUtils.isEmpty(r5)     // Catch:{ Exception -> 0x0092 }
            if (r6 == 0) goto L_0x0034
            long r5 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x0092 }
            java.lang.String r5 = java.lang.String.valueOf(r5)     // Catch:{ Exception -> 0x0092 }
        L_0x0034:
            java.lang.String r6 = ".html"
            java.lang.String r5 = r5.concat(r6)     // Catch:{ Exception -> 0x0092 }
            java.io.File r6 = new java.io.File     // Catch:{ Exception -> 0x0092 }
            r6.<init>(r3, r5)     // Catch:{ Exception -> 0x0092 }
            boolean r3 = r6.exists()     // Catch:{ Exception -> 0x0090 }
            if (r3 != 0) goto L_0x0085
            java.io.FileOutputStream r3 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x0090 }
            r3.<init>(r6)     // Catch:{ Exception -> 0x0090 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x007f, all -> 0x007b }
            r2.<init>()     // Catch:{ Exception -> 0x007f, all -> 0x007b }
            java.lang.String r4 = "<script>"
            r2.append(r4)     // Catch:{ Exception -> 0x007f, all -> 0x007b }
            com.mbridge.msdk.b.b.a r4 = com.mbridge.msdk.b.b.a.a()     // Catch:{ Exception -> 0x007f, all -> 0x007b }
            java.lang.String r4 = r4.b()     // Catch:{ Exception -> 0x007f, all -> 0x007b }
            r2.append(r4)     // Catch:{ Exception -> 0x007f, all -> 0x007b }
            java.lang.String r4 = "</script>"
            r2.append(r4)     // Catch:{ Exception -> 0x007f, all -> 0x007b }
            java.lang.String r4 = r9.getAdHtml()     // Catch:{ Exception -> 0x007f, all -> 0x007b }
            r2.append(r4)     // Catch:{ Exception -> 0x007f, all -> 0x007b }
            java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x007f, all -> 0x007b }
            byte[] r2 = r2.getBytes()     // Catch:{ Exception -> 0x007f, all -> 0x007b }
            r3.write(r2)     // Catch:{ Exception -> 0x007f, all -> 0x007b }
            r3.flush()     // Catch:{ Exception -> 0x007f, all -> 0x007b }
            r2 = r3
            goto L_0x0085
        L_0x007b:
            r9 = move-exception
            r2 = r3
            goto L_0x00e0
        L_0x007f:
            r2 = move-exception
            r7 = r3
            r3 = r2
            r2 = r7
            goto L_0x0099
        L_0x0084:
            r6 = r4
        L_0x0085:
            java.lang.String r3 = r8.b     // Catch:{ Exception -> 0x0090 }
            com.mbridge.msdk.foundation.same.report.b.a(r9, r1, r3, r0)     // Catch:{ Exception -> 0x0090 }
            if (r2 == 0) goto L_0x00ab
        L_0x008c:
            r2.close()     // Catch:{ Exception -> 0x00e8 }
            goto L_0x00ab
        L_0x0090:
            r3 = move-exception
            goto L_0x0099
        L_0x0092:
            r3 = move-exception
            r6 = r4
            goto L_0x0099
        L_0x0095:
            r9 = move-exception
            goto L_0x00e0
        L_0x0097:
            r3 = move-exception
            r6 = r2
        L_0x0099:
            r3.printStackTrace()     // Catch:{ all -> 0x0095 }
            r9.setMraid(r1)     // Catch:{ all -> 0x0095 }
            java.lang.String r1 = r3.getMessage()     // Catch:{ all -> 0x0095 }
            java.lang.String r3 = r8.b     // Catch:{ all -> 0x0095 }
            com.mbridge.msdk.foundation.same.report.b.a(r9, r1, r3, r0)     // Catch:{ all -> 0x0095 }
            if (r2 == 0) goto L_0x00ab
            goto L_0x008c
        L_0x00ab:
            boolean r0 = r6.exists()     // Catch:{ Exception -> 0x00e8 }
            if (r0 == 0) goto L_0x00d3
            boolean r0 = r6.isFile()     // Catch:{ Exception -> 0x00e8 }
            if (r0 == 0) goto L_0x00d3
            boolean r0 = r6.canRead()     // Catch:{ Exception -> 0x00e8 }
            if (r0 == 0) goto L_0x00d3
            java.lang.String r0 = r6.getAbsolutePath()     // Catch:{ Exception -> 0x00e8 }
            r9.setAdHtml(r0)     // Catch:{ Exception -> 0x00e8 }
            android.os.Handler r0 = r8.x     // Catch:{ Exception -> 0x00e8 }
            if (r0 == 0) goto L_0x00da
            android.os.Handler r0 = r8.x     // Catch:{ Exception -> 0x00e8 }
            com.mbridge.msdk.advanced.b.a$10 r1 = new com.mbridge.msdk.advanced.b.a$10     // Catch:{ Exception -> 0x00e8 }
            r1.<init>(r6, r9, r10)     // Catch:{ Exception -> 0x00e8 }
            r0.post(r1)     // Catch:{ Exception -> 0x00e8 }
            goto L_0x00da
        L_0x00d3:
            java.lang.String r9 = "html file write failed"
            java.lang.String r0 = r8.n     // Catch:{ Exception -> 0x00e8 }
            r8.a((java.lang.String) r9, (java.lang.String) r0, (int) r10)     // Catch:{ Exception -> 0x00e8 }
        L_0x00da:
            if (r2 == 0) goto L_0x00f5
        L_0x00dc:
            r2.close()     // Catch:{ IOException -> 0x00f5 }
            goto L_0x00f5
        L_0x00e0:
            if (r2 == 0) goto L_0x00e5
            r2.close()     // Catch:{ Exception -> 0x00e8 }
        L_0x00e5:
            throw r9     // Catch:{ Exception -> 0x00e8 }
        L_0x00e6:
            r9 = move-exception
            goto L_0x00f6
        L_0x00e8:
            r9 = move-exception
            java.lang.String r9 = r9.getMessage()     // Catch:{ all -> 0x00e6 }
            java.lang.String r0 = r8.n     // Catch:{ all -> 0x00e6 }
            r8.a((java.lang.String) r9, (java.lang.String) r0, (int) r10)     // Catch:{ all -> 0x00e6 }
            if (r2 == 0) goto L_0x00f5
            goto L_0x00dc
        L_0x00f5:
            return
        L_0x00f6:
            if (r2 == 0) goto L_0x00fb
            r2.close()     // Catch:{ IOException -> 0x00fb }
        L_0x00fb:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.advanced.b.a.g(com.mbridge.msdk.foundation.entity.CampaignEx, int):void");
    }

    private void h(final CampaignEx campaignEx, final int i2) {
        this.s = new g.d() {
            public final void a(String str) {
                Message obtain = Message.obtain();
                obtain.what = 1;
                obtain.obj = campaignEx;
                obtain.arg1 = i2;
                a.this.x.sendMessage(obtain);
            }

            public final void a(String str, String str2) {
                Message obtain = Message.obtain();
                obtain.what = 2;
                obtain.obj = str;
                a.this.x.sendMessage(obtain);
            }
        };
        g.a().b(campaignEx.getAdZip(), this.s);
    }

    /* access modifiers changed from: private */
    public void a(CampaignEx campaignEx, String str, int i2) {
        a(str, this.n, i2);
        b(campaignEx, str, 2);
    }

    private void b(CampaignEx campaignEx, String str, int i2) {
        com.mbridge.msdk.advanced.d.a.b(com.mbridge.msdk.advanced.common.c.a().c(campaignEx.getId()).b(this.b).d(campaignEx.getRequestId()).g(campaignEx.getRequestIdNotice()).f(str).b(i2).a(campaignEx.isBidCampaign()), this.b);
    }

    private void i(final CampaignEx campaignEx, int i2) {
        this.r = new com.mbridge.msdk.videocommon.listener.a() {
            public final void a(String str) {
                Message obtain = Message.obtain();
                obtain.obj = campaignEx;
                obtain.what = 5;
                a.this.x.sendMessage(obtain);
            }

            public final void a(String str, String str2) {
                Message obtain = Message.obtain();
                obtain.obj = str;
                obtain.what = 2;
                a.this.x.sendMessage(obtain);
            }
        };
        ArrayList arrayList = new ArrayList();
        arrayList.add(campaignEx);
        com.mbridge.msdk.videocommon.download.c.getInstance().createUnitCache(this.f, this.b, (List<CampaignEx>) arrayList, 298, this.r);
        if (!com.mbridge.msdk.videocommon.download.c.getInstance().a(298, this.b, campaignEx.isBidCampaign())) {
            com.mbridge.msdk.videocommon.download.c.getInstance().load(this.b);
            return;
        }
        this.g.setVideoReady(true);
        b(campaignEx, i2);
    }

    public final String a(String str) {
        if (this.i == null) {
            return "";
        }
        try {
            com.mbridge.msdk.videocommon.download.a a2 = com.mbridge.msdk.videocommon.download.c.getInstance().a(this.b, this.i.getId() + this.i.getVideoUrlEncode() + this.i.getBidToken());
            if (a2 == null || a2.f() != 5) {
                return str;
            }
            String d2 = a2.d();
            if (new File(d2).exists()) {
                return d2;
            }
            return str;
        } catch (Exception e2) {
            q.d(a, e2.getMessage());
            return str;
        }
    }

    static /* synthetic */ void a(a aVar, final String str, CampaignEx campaignEx, int i2) {
        MBNativeAdvancedView mBNativeAdvancedView = aVar.g;
        if (mBNativeAdvancedView != null && mBNativeAdvancedView.getAdvancedNativeWebview() != null) {
            com.mbridge.msdk.advanced.d.a.a(com.mbridge.msdk.advanced.common.c.a().c(campaignEx.getId()).d(campaignEx.getRequestId()).g(campaignEx.getRequestIdNotice()).b(aVar.b).a(campaignEx.isBidCampaign()), aVar.b);
            com.mbridge.msdk.advanced.js.b bVar = new com.mbridge.msdk.advanced.js.b(aVar.g.getContext(), aVar.c, aVar.b);
            ArrayList arrayList = new ArrayList();
            arrayList.add(campaignEx);
            bVar.a((List<CampaignEx>) arrayList);
            bVar.a(aVar.j);
            bVar.b(aVar.k);
            aVar.g.setAdvancedNativeSignalCommunicationImpl(bVar);
            long currentTimeMillis = System.currentTimeMillis();
            final MBNativeAdvancedWebview advancedNativeWebview = aVar.g.getAdvancedNativeWebview();
            if (advancedNativeWebview == null) {
                aVar.a(campaignEx, "webview is null", i2);
            } else if (advancedNativeWebview == null || !advancedNativeWebview.isDestoryed()) {
                final CampaignEx campaignEx2 = campaignEx;
                final int i3 = i2;
                final long j2 = currentTimeMillis;
                advancedNativeWebview.setWebViewListener(new com.mbridge.msdk.mbsignalcommon.b.b() {
                    public final void a(WebView webView, int i) {
                        super.a(webView, i);
                        if (i == 1) {
                            a.this.g.setH5Ready(true);
                            b.a(campaignEx2.getRequestId(), true);
                            a.b(a.this, campaignEx2, i3);
                            com.mbridge.msdk.advanced.d.a.a(com.mbridge.msdk.foundation.controller.a.e().g(), campaignEx2, a.this.b, "", j2, 1);
                            return;
                        }
                        a.this.a(campaignEx2, "readyState 2", i3);
                        com.mbridge.msdk.advanced.d.a.a(com.mbridge.msdk.foundation.controller.a.e().g(), campaignEx2, a.this.b, "readyState 2", j2, 3);
                    }

                    public final void a(WebView webView, int i, String str, String str2) {
                        super.a(webView, i, str, str2);
                        a.this.a(campaignEx2, str, i3);
                        Context g = com.mbridge.msdk.foundation.controller.a.e().g();
                        CampaignEx campaignEx = campaignEx2;
                        String d2 = a.this.b;
                        com.mbridge.msdk.advanced.d.a.a(g, campaignEx, d2, "error code:" + i + str, j2, 3);
                    }

                    public final void a(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
                        super.a(webView, sslErrorHandler, sslError);
                        a aVar = a.this;
                        CampaignEx campaignEx = campaignEx2;
                        aVar.a(campaignEx, "onReceivedSslError:" + sslError.getUrl(), i3);
                        Context g = com.mbridge.msdk.foundation.controller.a.e().g();
                        CampaignEx campaignEx2 = campaignEx2;
                        String d2 = a.this.b;
                        com.mbridge.msdk.advanced.d.a.a(g, campaignEx2, d2, "error url:" + sslError.getUrl(), j2, 3);
                    }

                    public final void a(WebView webView, String str) {
                        super.a(webView, str);
                        if (!campaignEx2.isHasMBTplMark()) {
                            a.this.g.setH5Ready(true);
                            b.a(campaignEx2.getRequestId(), true);
                            a.b(a.this, campaignEx2, i3);
                            com.mbridge.msdk.advanced.d.a.a(com.mbridge.msdk.foundation.controller.a.e().g(), campaignEx2, a.this.b, "", j2, 1);
                        }
                        com.mbridge.msdk.advanced.js.a.a(webView);
                    }
                });
                if (!advancedNativeWebview.isDestoryed()) {
                    Handler handler = aVar.x;
                    if (handler != null) {
                        handler.post(new Runnable() {
                            public final void run() {
                                advancedNativeWebview.loadUrl(str);
                            }
                        });
                        return;
                    }
                    return;
                }
                aVar.a("webview has destory", aVar.n, i2);
                com.mbridge.msdk.advanced.d.a.a(com.mbridge.msdk.foundation.controller.a.e().g(), campaignEx, aVar.b, "webview had destory", currentTimeMillis, 3);
            } else {
                aVar.a(campaignEx, "webview is destroyed", i2);
            }
        }
    }

    static /* synthetic */ void a(a aVar, CampaignUnit campaignUnit, int i2, String str, String str2) {
        ArrayList arrayList;
        if (campaignUnit == null || campaignUnit.getAds() == null) {
            arrayList = null;
        } else {
            arrayList = new ArrayList();
            CampaignEx campaignEx = campaignUnit.getAds().get(0);
            campaignEx.setCampaignUnitId(aVar.b);
            aVar.u = campaignUnit.getSessionId();
            if (campaignEx.getOfferType() != 99 && (!TextUtils.isEmpty(campaignEx.getAdZip()) || !TextUtils.isEmpty(campaignEx.getAdHtml()))) {
                if (u.b(campaignEx)) {
                    campaignEx.setRtinsType(u.c(aVar.f, campaignEx.getPackageName()) ? 1 : 2);
                }
                if (campaignEx.getWtick() == 1 || !u.c(aVar.f, campaignEx.getPackageName())) {
                    arrayList.add(campaignEx);
                } else if (u.b(campaignEx)) {
                    arrayList.add(campaignEx);
                } else {
                    u.a(aVar.b, campaignEx, com.mbridge.msdk.foundation.same.a.v);
                }
            }
        }
        if (arrayList == null || arrayList.size() <= 0) {
            aVar.a("invalid  campaign", str2, i2);
            return;
        }
        try {
            aVar.v++;
            if (aVar.h == null || aVar.v > aVar.h.u()) {
                aVar.v = 0;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        CampaignEx campaignEx2 = (CampaignEx) arrayList.get(0);
        if (!TextUtils.isEmpty(campaignEx2.getAdZip()) || (!TextUtils.isEmpty(campaignEx2.getAdHtml()) && campaignEx2.getAdHtml().contains("<MBTPLMARK>"))) {
            campaignEx2.setHasMBTplMark(true);
            campaignEx2.setIsMraid(false);
        } else {
            campaignEx2.setHasMBTplMark(false);
            campaignEx2.setIsMraid(true);
        }
        aVar.a(campaignEx2, i2);
    }

    static /* synthetic */ void b(a aVar, CampaignEx campaignEx, int i2) {
        if (aVar.g.isH5Ready()) {
            aVar.b(campaignEx, i2);
            aVar.b(campaignEx, "", 1);
        }
    }
}
