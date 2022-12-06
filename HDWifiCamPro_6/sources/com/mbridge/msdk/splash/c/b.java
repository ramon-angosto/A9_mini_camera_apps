package com.mbridge.msdk.splash.c;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import androidx.work.WorkRequest;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.b.d;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.CampaignUnit;
import com.mbridge.msdk.foundation.same.c.c;
import com.mbridge.msdk.foundation.tools.SameMD5;
import com.mbridge.msdk.foundation.tools.q;
import com.mbridge.msdk.foundation.tools.u;
import com.mbridge.msdk.foundation.tools.x;
import com.mbridge.msdk.splash.b.a;
import com.mbridge.msdk.splash.c.d;
import com.mbridge.msdk.splash.view.MBSplashView;
import com.mbridge.msdk.videocommon.download.g;
import java.util.ArrayList;
import java.util.List;

/* compiled from: SplashLoadManager */
public final class b {
    /* access modifiers changed from: private */
    public static String a = "SplashLoadManager";
    /* access modifiers changed from: private */
    public String b;
    private String c;
    private long d;
    private long e;
    private a f;
    private Context g = com.mbridge.msdk.foundation.controller.a.e().g();
    /* access modifiers changed from: private */
    public MBSplashView h;
    private d i;
    private boolean j;
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
    private String t;
    /* access modifiers changed from: private */
    public int u;
    /* access modifiers changed from: private */
    public String v = "";
    /* access modifiers changed from: private */
    public Handler w = new Handler(Looper.getMainLooper()) {
        public final void handleMessage(Message message) {
            super.handleMessage(message);
            int i = message.what;
            if (i == 1) {
                Object obj = message.obj;
                int i2 = message.arg1;
                if (obj instanceof CampaignEx) {
                    CampaignEx campaignEx = (CampaignEx) obj;
                    b.this.a(g.a().b(campaignEx.getAdZip()), campaignEx, i2);
                }
            } else if (i == 2) {
                Object obj2 = message.obj;
                if (obj2 instanceof String) {
                    b.this.a(obj2.toString(), b.this.n, b.this.o);
                }
            } else if (i == 3) {
                Object obj3 = message.obj;
                if (obj3 instanceof CampaignEx) {
                    b bVar = b.this;
                    bVar.b((CampaignEx) obj3, bVar.o);
                }
            }
        }
    };
    private Runnable x = new Runnable() {
        public final void run() {
            b bVar = b.this;
            bVar.a("load timeout", bVar.n, b.this.o);
        }
    };

    public final String a() {
        return this.v;
    }

    public b(String str, String str2, long j2) {
        this.c = str;
        this.b = str2;
        this.e = j2;
    }

    public final void a(d dVar) {
        this.i = dVar;
    }

    public final void a(MBSplashView mBSplashView) {
        this.h = mBSplashView;
    }

    public final void a(boolean z) {
        this.j = z;
    }

    public final void a(int i2) {
        this.k = i2;
    }

    public final void a(int i2, int i3) {
        this.m = i2;
        this.l = i3;
    }

    public final void a(String str, int i2) {
        this.q = false;
        this.n = str;
        this.o = i2;
        CampaignEx a2 = a.a(this.h, this.c, this.b, str, this.j, this.k, false, false);
        long timestamp = a2 != null ? a2.getTimestamp() : 0;
        if (this.i.m() != 1 || i2 == 1 || a2 == null) {
            this.p = true;
            if (i2 == 1) {
                List<Integer> r2 = this.i.r();
                if (r2 == null || r2.size() <= 0) {
                    this.d = WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS;
                } else {
                    this.d = (long) (r2.get(0).intValue() * 1000);
                }
            } else {
                long j2 = this.e;
                if (j2 <= 0) {
                    this.d = (long) this.i.n();
                } else {
                    this.d = j2;
                }
            }
            if (this.i == null || timestamp <= 0 || !TextUtils.isEmpty(str)) {
                a(this.d);
                a(this.g, str, i2);
            } else if (System.currentTimeMillis() - timestamp > ((long) (this.i.w() * 1000))) {
                a(this.d);
                a(this.g, str, i2);
            } else {
                a(a2, i2);
            }
        } else {
            a(a2, i2);
        }
    }

    private void a(long j2) {
        this.w.postDelayed(this.x, j2);
    }

    private void a(Context context, final String str, final int i2) {
        if (context == null) {
            try {
                a("Context is null", str, i2);
            } catch (Exception e2) {
                e2.printStackTrace();
                a("Load exception", str, i2);
                this.u = 0;
            }
        } else if (x.a(this.b)) {
            a("UnitId is null", str, i2);
        } else {
            com.mbridge.msdk.foundation.same.net.h.d a2 = a(i2, this.t);
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
            com.mbridge.msdk.splash.f.b bVar = new com.mbridge.msdk.splash.f.b(context);
            AnonymousClass3 r5 = new com.mbridge.msdk.splash.f.a(i2) {
                public final void a(CampaignUnit campaignUnit, int i) {
                    try {
                        b.a(b.this, campaignUnit, i, b.this.b, str);
                        String unused = b.this.v = campaignUnit.getRequestId();
                    } catch (Exception e) {
                        e.printStackTrace();
                        b.this.a("Exception after load success", str, i);
                        b.this.u = 0;
                    }
                }

                public final void a(int i, String str) {
                    q.d(b.a, str);
                    b.this.a(str, str, i2);
                    b.this.u = 0;
                }
            };
            r5.a(str);
            r5.d = this.b;
            r5.e = this.c;
            r5.f = 297;
            if (!com.mbridge.msdk.foundation.same.net.g.d.c().b() || !TextUtils.isEmpty(str)) {
                bVar.a(1, com.mbridge.msdk.foundation.same.net.g.d.c().a(str), a2, r5);
            } else {
                bVar.b(1, com.mbridge.msdk.foundation.same.net.g.d.c().a(str), a2, r5);
            }
        }
    }

    private com.mbridge.msdk.foundation.same.net.h.d a(int i2, String str) {
        String h2 = com.mbridge.msdk.foundation.controller.a.e().h();
        String md5 = SameMD5.getMD5(com.mbridge.msdk.foundation.controller.a.e().h() + com.mbridge.msdk.foundation.controller.a.e().i());
        com.mbridge.msdk.foundation.same.net.h.d dVar = new com.mbridge.msdk.foundation.same.net.h.d();
        String a2 = com.mbridge.msdk.foundation.same.a.d.a(this.b, "splash");
        String b2 = u.b(this.g, this.b);
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
        com.mbridge.msdk.foundation.same.net.g.b.a(dVar, "ad_type", 297 + "");
        com.mbridge.msdk.foundation.same.net.g.b.a(dVar, "offset", this.u + "");
        com.mbridge.msdk.foundation.same.net.g.b.a(dVar, CampaignUnit.JSON_KEY_UNIT_SIZE, this.m + "x" + this.l);
        return dVar;
    }

    public final void a(a aVar) {
        this.f = aVar;
    }

    public final void b() {
        if (this.f != null) {
            this.f = null;
        }
        if (this.r != null) {
            this.r = null;
        }
        if (this.s != null) {
            this.s = null;
        }
    }

    private void a(CampaignEx campaignEx, int i2) {
        if (a.a(this.h, campaignEx)) {
            b(campaignEx, i2);
        } else {
            c(campaignEx, i2);
        }
    }

    /* access modifiers changed from: private */
    public void b(CampaignEx campaignEx, int i2) {
        if (a.a(this.h, campaignEx) && !this.q) {
            d();
            if (this.p) {
                a.a(campaignEx, this.b);
            }
            this.q = true;
            a aVar = this.f;
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
        CampaignEx a2 = a.a(this.h, this.c, this.b, str2, this.j, this.k, true, false);
        if (a2 != null) {
            a(a2, i2);
        } else {
            b(str, i2);
        }
    }

    private void b(String str, int i2) {
        if (!this.q) {
            d();
            this.q = true;
            a aVar = this.f;
            if (aVar != null) {
                aVar.a(str, i2);
            }
        }
    }

    private void d() {
        this.w.removeCallbacks(this.x);
    }

    private void c(CampaignEx campaignEx, int i2) {
        this.h.clearResState();
        if (!TextUtils.isEmpty(campaignEx.getAdZip())) {
            f(campaignEx, i2);
        }
        if (!TextUtils.isEmpty(campaignEx.getAdHtml())) {
            e(campaignEx, i2);
        }
        if (!TextUtils.isEmpty(campaignEx.getVideoUrlEncode())) {
            g(campaignEx, i2);
        }
        if (!TextUtils.isEmpty(campaignEx.getImageUrl())) {
            d(campaignEx, i2);
        }
    }

    private void d(final CampaignEx campaignEx, final int i2) {
        com.mbridge.msdk.foundation.same.c.b.a(com.mbridge.msdk.foundation.controller.a.e().g()).a(campaignEx.getImageUrl(), (c) new c() {
            public final void onFailedLoad(String str, String str2) {
            }

            public final void onSuccessLoad(Bitmap bitmap, String str) {
                b.this.b(campaignEx, i2);
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
        if (r6.exists() == false) goto L_0x00dd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00b5, code lost:
        if (r6.isFile() == false) goto L_0x00dd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00bb, code lost:
        if (r6.canRead() == false) goto L_0x00dd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00bd, code lost:
        r9.setAdHtml(r6.getAbsolutePath());
        a("file:////" + r6.getAbsolutePath(), r9, r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00dd, code lost:
        a("html file write failed", r8.n, r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00e4, code lost:
        if (r2 == null) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:?, code lost:
        r2.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x00f0, code lost:
        r9 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x00f2, code lost:
        r9 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:?, code lost:
        a(r9.getMessage(), r8.n, r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x00fc, code lost:
        if (r2 == null) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x0100, code lost:
        if (r2 != null) goto L_0x0102;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:?, code lost:
        r2.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x0105, code lost:
        throw r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:?, code lost:
        return;
     */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00ec A[SYNTHETIC, Splitter:B:49:0x00ec] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void e(com.mbridge.msdk.foundation.entity.CampaignEx r9, int r10) {
        /*
            r8 = this;
            java.lang.String r0 = "6"
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
            goto L_0x00ea
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
            r2.close()     // Catch:{ Exception -> 0x00f2 }
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
            goto L_0x00ea
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
            boolean r0 = r6.exists()     // Catch:{ Exception -> 0x00f2 }
            if (r0 == 0) goto L_0x00dd
            boolean r0 = r6.isFile()     // Catch:{ Exception -> 0x00f2 }
            if (r0 == 0) goto L_0x00dd
            boolean r0 = r6.canRead()     // Catch:{ Exception -> 0x00f2 }
            if (r0 == 0) goto L_0x00dd
            java.lang.String r0 = r6.getAbsolutePath()     // Catch:{ Exception -> 0x00f2 }
            r9.setAdHtml(r0)     // Catch:{ Exception -> 0x00f2 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00f2 }
            r0.<init>()     // Catch:{ Exception -> 0x00f2 }
            java.lang.String r1 = "file:////"
            r0.append(r1)     // Catch:{ Exception -> 0x00f2 }
            java.lang.String r1 = r6.getAbsolutePath()     // Catch:{ Exception -> 0x00f2 }
            r0.append(r1)     // Catch:{ Exception -> 0x00f2 }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x00f2 }
            r8.a((java.lang.String) r0, (com.mbridge.msdk.foundation.entity.CampaignEx) r9, (int) r10)     // Catch:{ Exception -> 0x00f2 }
            goto L_0x00e4
        L_0x00dd:
            java.lang.String r9 = "html file write failed"
            java.lang.String r0 = r8.n     // Catch:{ Exception -> 0x00f2 }
            r8.a((java.lang.String) r9, (java.lang.String) r0, (int) r10)     // Catch:{ Exception -> 0x00f2 }
        L_0x00e4:
            if (r2 == 0) goto L_0x00ff
        L_0x00e6:
            r2.close()     // Catch:{ IOException -> 0x00ff }
            goto L_0x00ff
        L_0x00ea:
            if (r2 == 0) goto L_0x00ef
            r2.close()     // Catch:{ Exception -> 0x00f2 }
        L_0x00ef:
            throw r9     // Catch:{ Exception -> 0x00f2 }
        L_0x00f0:
            r9 = move-exception
            goto L_0x0100
        L_0x00f2:
            r9 = move-exception
            java.lang.String r9 = r9.getMessage()     // Catch:{ all -> 0x00f0 }
            java.lang.String r0 = r8.n     // Catch:{ all -> 0x00f0 }
            r8.a((java.lang.String) r9, (java.lang.String) r0, (int) r10)     // Catch:{ all -> 0x00f0 }
            if (r2 == 0) goto L_0x00ff
            goto L_0x00e6
        L_0x00ff:
            return
        L_0x0100:
            if (r2 == 0) goto L_0x0105
            r2.close()     // Catch:{ IOException -> 0x0105 }
        L_0x0105:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.splash.c.b.e(com.mbridge.msdk.foundation.entity.CampaignEx, int):void");
    }

    private void f(final CampaignEx campaignEx, final int i2) {
        this.s = new g.d() {
            public final void a(String str) {
                Message obtain = Message.obtain();
                obtain.what = 1;
                obtain.obj = campaignEx;
                obtain.arg1 = i2;
                b.this.w.sendMessage(obtain);
            }

            public final void a(String str, String str2) {
                b bVar = b.this;
                bVar.a(str, bVar.n, i2);
                Message obtain = Message.obtain();
                obtain.what = 2;
                obtain.obj = str;
                b.this.w.sendMessage(obtain);
            }
        };
        g.a().b(campaignEx.getAdZip(), this.s);
    }

    /* access modifiers changed from: private */
    public void a(String str, final CampaignEx campaignEx, final int i2) {
        d.c cVar = new d.c();
        cVar.c(this.b);
        cVar.b(this.c);
        cVar.a(campaignEx);
        cVar.a(str);
        cVar.a(this.j);
        cVar.a(this.k);
        d.a.a.a(this.h, cVar, new d.b() {
            public final void a() {
                if (!campaignEx.isHasMBTplMark()) {
                    b.b(b.this, campaignEx, i2);
                }
            }

            public final void a(String str) {
                b.this.a(str, b.this.n, i2);
            }

            public final void a(int i) {
                if (i == 1) {
                    b.b(b.this, campaignEx, i2);
                } else {
                    b.this.a("readyState 2", b.this.n, i2);
                }
            }
        });
    }

    private void g(final CampaignEx campaignEx, int i2) {
        this.r = new com.mbridge.msdk.videocommon.listener.a() {
            public final void a(String str) {
                b.this.h.setVideoReady(true);
                Message obtain = Message.obtain();
                obtain.obj = campaignEx;
                obtain.what = 3;
                b.this.w.sendMessage(obtain);
            }

            public final void a(String str, String str2) {
                b.this.h.setVideoReady(false);
                Message obtain = Message.obtain();
                obtain.obj = str;
                obtain.what = 2;
                b.this.w.sendMessage(obtain);
            }
        };
        ArrayList arrayList = new ArrayList();
        arrayList.add(campaignEx);
        com.mbridge.msdk.videocommon.download.c.getInstance().createUnitCache(this.g, this.b, (List<CampaignEx>) arrayList, 297, this.r);
        if (!com.mbridge.msdk.videocommon.download.c.getInstance().a(297, this.b, campaignEx.isBidCampaign())) {
            com.mbridge.msdk.videocommon.download.c.getInstance().load(this.b);
            return;
        }
        this.h.setVideoReady(true);
        b(campaignEx, i2);
    }

    static /* synthetic */ void a(b bVar, CampaignUnit campaignUnit, int i2, String str, String str2) {
        ArrayList arrayList;
        if (campaignUnit == null || campaignUnit.getAds() == null) {
            arrayList = null;
        } else {
            arrayList = new ArrayList();
            CampaignEx campaignEx = campaignUnit.getAds().get(0);
            campaignEx.setCampaignUnitId(bVar.b);
            bVar.t = campaignUnit.getSessionId();
            if (campaignEx.getOfferType() != 99 && (!TextUtils.isEmpty(campaignEx.getAdZip()) || !TextUtils.isEmpty(campaignEx.getAdHtml()))) {
                if (u.b(campaignEx)) {
                    campaignEx.setRtinsType(u.c(bVar.g, campaignEx.getPackageName()) ? 1 : 2);
                }
                if (campaignEx.getWtick() == 1 || !u.c(bVar.g, campaignEx.getPackageName())) {
                    arrayList.add(campaignEx);
                } else if (u.b(campaignEx)) {
                    arrayList.add(campaignEx);
                } else {
                    u.a(bVar.b, campaignEx, com.mbridge.msdk.foundation.same.a.v);
                }
            }
        }
        if (arrayList == null || arrayList.size() <= 0) {
            bVar.a("invalid  campaign", str2, i2);
            return;
        }
        try {
            bVar.u++;
            if (bVar.i == null || bVar.u > bVar.i.u()) {
                bVar.u = 0;
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
        bVar.a(campaignEx2, i2);
    }

    static /* synthetic */ void b(b bVar, CampaignEx campaignEx, int i2) {
        if (!bVar.h.isH5Ready()) {
            bVar.h.setH5Ready(true);
            bVar.b(campaignEx, i2);
        }
    }
}
