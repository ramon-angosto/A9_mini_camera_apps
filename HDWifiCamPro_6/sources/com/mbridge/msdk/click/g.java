package com.mbridge.msdk.click;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.mbridge.msdk.click.CommonJumpLoader;
import com.mbridge.msdk.click.e;
import com.mbridge.msdk.click.f;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.e.a;
import com.mbridge.msdk.foundation.same.e.b;
import com.mbridge.msdk.foundation.tools.t;
import java.util.concurrent.Semaphore;

/* compiled from: WebViewSpiderLoader */
public final class g extends c implements a.b {
    /* access modifiers changed from: private */
    public d a;
    /* access modifiers changed from: private */
    public CommonJumpLoader.JumpLoaderResult b;
    /* access modifiers changed from: private */
    public boolean c = true;
    /* access modifiers changed from: private */
    public boolean d;
    private Context e;
    private b f;
    /* access modifiers changed from: private */
    public e.a g;
    private Handler h = new Handler(Looper.getMainLooper());

    public g(Context context) {
        this.e = context;
        this.f = new b(context, 2);
    }

    public final void a(String str, d dVar, boolean z, String str2, String str3, CampaignEx campaignEx, boolean z2, boolean z3) {
        this.a = dVar;
        this.d = z;
        this.f.a(new a(this.e, str, str2, str3, campaignEx, z2, z3), this);
    }

    public final void a() {
        this.c = false;
    }

    /* compiled from: WebViewSpiderLoader */
    private class a extends com.mbridge.msdk.foundation.same.e.a {
        private final Semaphore e = new Semaphore(0);
        private final Context f;
        private String g;
        private String h;
        private String i;
        private CampaignEx j;
        private boolean k;
        private boolean l;
        private f.a m = new f.a() {
            public final boolean c(String str) {
                return false;
            }

            public final boolean a(String str) {
                boolean a2 = a.this.a(str);
                if (a2) {
                    a();
                }
                return a2;
            }

            public final boolean b(String str) {
                boolean a2 = a.this.a(str);
                if (a2) {
                    a();
                }
                return a2;
            }

            public final void a(String str, boolean z, String str2) {
                boolean unused = a.this.a(str);
                g.this.b.setContent(str2);
                a();
            }

            private void a() {
                synchronized (g.this) {
                    g.this.b.setSuccess(true);
                    a.this.e.release();
                }
            }

            public final void a(int i, String str, String str2, String str3) {
                if (!TextUtils.isEmpty(str2)) {
                    g.this.b.setExceptionMsg(str2);
                }
                if (!TextUtils.isEmpty(str3)) {
                    g.this.b.setContent(str3);
                }
                boolean unused = a.this.a(str);
                a();
            }
        };

        public final void b() {
        }

        public a(Context context, String str, String str2, String str3, CampaignEx campaignEx, boolean z, boolean z2) {
            this.f = context;
            this.g = str;
            this.h = str2;
            this.i = str3;
            this.j = campaignEx;
            this.k = z;
            this.l = z2;
        }

        /* JADX WARNING: Removed duplicated region for block: B:21:0x0056  */
        /* JADX WARNING: Removed duplicated region for block: B:79:0x0199 A[EDGE_INSN: B:79:0x0199->B:74:0x0199 ?: BREAK  , SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private com.mbridge.msdk.click.CommonJumpLoader.JumpLoaderResult a(java.lang.String r11, boolean r12, boolean r13, com.mbridge.msdk.foundation.entity.CampaignEx r14) {
            /*
                r10 = this;
                java.lang.String r0 = ""
                com.mbridge.msdk.click.g r1 = com.mbridge.msdk.click.g.this
                boolean r1 = r1.d
                if (r1 == 0) goto L_0x0025
                android.content.Context r1 = r10.f
                java.lang.String r1 = com.mbridge.msdk.b.a.a(r1, r11)
                boolean r2 = android.text.TextUtils.isEmpty(r1)
                if (r2 != 0) goto L_0x0025
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>()
                r2.append(r11)
                r2.append(r1)
                java.lang.String r11 = r2.toString()
            L_0x0025:
                com.mbridge.msdk.click.CommonJumpLoader$JumpLoaderResult r1 = new com.mbridge.msdk.click.CommonJumpLoader$JumpLoaderResult
                r1.<init>()
                com.mbridge.msdk.click.e r2 = new com.mbridge.msdk.click.e
                r2.<init>()
                boolean r3 = r10.b(r11)     // Catch:{ Exception -> 0x0046 }
                if (r3 != 0) goto L_0x0044
                java.net.URI r3 = java.net.URI.create(r11)     // Catch:{ Exception -> 0x0046 }
                java.lang.String r4 = r3.getScheme()     // Catch:{ Exception -> 0x0046 }
                java.lang.String r0 = r3.getHost()     // Catch:{ Exception -> 0x0042 }
                goto L_0x004b
            L_0x0042:
                r3 = move-exception
                goto L_0x0048
            L_0x0044:
                r3 = r0
                goto L_0x004d
            L_0x0046:
                r3 = move-exception
                r4 = r0
            L_0x0048:
                r3.printStackTrace()
            L_0x004b:
                r3 = r0
                r0 = r4
            L_0x004d:
                r4 = 0
                r5 = r3
                r3 = r0
                r0 = r11
                r11 = r4
            L_0x0052:
                r6 = 10
                if (r11 >= r6) goto L_0x0199
                com.mbridge.msdk.click.g r6 = com.mbridge.msdk.click.g.this
                boolean r6 = r6.c
                r7 = 0
                if (r6 != 0) goto L_0x0060
                return r7
            L_0x0060:
                com.mbridge.msdk.click.g r6 = com.mbridge.msdk.click.g.this
                com.mbridge.msdk.click.e$a r8 = r2.a(r0, r12, r13, r14)
                com.mbridge.msdk.click.e.a unused = r6.g = r8
                com.mbridge.msdk.click.g r6 = com.mbridge.msdk.click.g.this
                com.mbridge.msdk.click.e$a r6 = r6.g
                if (r6 != 0) goto L_0x0079
                r1.setUrl(r0)
                r1.setSuccess(r4)
                goto L_0x0199
            L_0x0079:
                com.mbridge.msdk.click.g r6 = com.mbridge.msdk.click.g.this
                com.mbridge.msdk.click.e$a r6 = r6.g
                java.lang.String r6 = r6.h
                boolean r6 = android.text.TextUtils.isEmpty(r6)
                r8 = 1
                if (r6 != 0) goto L_0x00ab
                r1.setUrl(r0)
                com.mbridge.msdk.click.g r11 = com.mbridge.msdk.click.g.this
                com.mbridge.msdk.click.e$a r11 = r11.g
                java.lang.String r11 = r11.h
                r1.setExceptionMsg(r11)
                r1.setType(r8)
                com.mbridge.msdk.click.g r11 = com.mbridge.msdk.click.g.this
                com.mbridge.msdk.click.e$a r11 = r11.g
                java.lang.String r11 = r11.a()
                r1.setHeader(r11)
                r1.setSuccess(r4)
                goto L_0x0199
            L_0x00ab:
                r1.setSuccess(r8)
                com.mbridge.msdk.click.g r6 = com.mbridge.msdk.click.g.this
                com.mbridge.msdk.click.e$a r6 = r6.g
                int r6 = r6.f
                r9 = 301(0x12d, float:4.22E-43)
                if (r6 == r9) goto L_0x00c5
                r9 = 302(0x12e, float:4.23E-43)
                if (r6 == r9) goto L_0x00c5
                r9 = 307(0x133, float:4.3E-43)
                if (r6 != r9) goto L_0x00c3
                goto L_0x00c5
            L_0x00c3:
                r6 = r4
                goto L_0x00c6
            L_0x00c5:
                r6 = r8
            L_0x00c6:
                if (r6 == 0) goto L_0x0170
                r1.setIs302Jump(r8)
                com.mbridge.msdk.click.g r6 = com.mbridge.msdk.click.g.this
                com.mbridge.msdk.click.e$a r6 = r6.g
                java.lang.String r6 = r6.a
                boolean r6 = android.text.TextUtils.isEmpty(r6)
                if (r6 == 0) goto L_0x00e1
                r1.setjumpDone(r8)
                r1.setUrl(r0)
                goto L_0x0199
            L_0x00e1:
                com.mbridge.msdk.click.g r0 = com.mbridge.msdk.click.g.this
                com.mbridge.msdk.click.e$a r0 = r0.g
                java.lang.String r0 = r0.a
                boolean r6 = r10.b(r0)
                if (r6 == 0) goto L_0x0125
                java.lang.String r6 = "/"
                boolean r6 = r0.startsWith(r6)
                if (r6 == 0) goto L_0x011d
                boolean r6 = android.text.TextUtils.isEmpty(r3)
                if (r6 != 0) goto L_0x011d
                boolean r6 = android.text.TextUtils.isEmpty(r5)
                if (r6 != 0) goto L_0x011d
                java.lang.StringBuilder r6 = new java.lang.StringBuilder
                r6.<init>()
                r6.append(r3)
                java.lang.String r3 = "://"
                r6.append(r3)
                r6.append(r5)
                r6.append(r0)
                java.lang.String r0 = r6.toString()
                r3 = r7
                r5 = r3
                goto L_0x013c
            L_0x011d:
                r1.setjumpDone(r8)
                r1.setUrl(r0)
                goto L_0x0199
            L_0x0125:
                boolean r6 = r10.b(r0)
                if (r6 != 0) goto L_0x013c
                java.net.URI r6 = java.net.URI.create(r0)     // Catch:{ Exception -> 0x0138 }
                java.lang.String r3 = r6.getScheme()     // Catch:{ Exception -> 0x0138 }
                java.lang.String r5 = r6.getHost()     // Catch:{ Exception -> 0x0138 }
                goto L_0x013c
            L_0x0138:
                r6 = move-exception
                r6.printStackTrace()
            L_0x013c:
                boolean r6 = com.mbridge.msdk.foundation.tools.t.a.a((java.lang.String) r0)
                if (r6 == 0) goto L_0x0149
                r1.setjumpDone(r8)
                r1.setUrl(r0)
                goto L_0x0199
            L_0x0149:
                com.mbridge.msdk.click.g r6 = com.mbridge.msdk.click.g.this
                boolean r6 = r6.d
                if (r6 == 0) goto L_0x016c
                android.content.Context r6 = r10.f
                java.lang.String r6 = com.mbridge.msdk.b.a.a(r6, r0)
                boolean r7 = android.text.TextUtils.isEmpty(r6)
                if (r7 != 0) goto L_0x016c
                java.lang.StringBuilder r7 = new java.lang.StringBuilder
                r7.<init>()
                r7.append(r0)
                r7.append(r6)
                java.lang.String r0 = r7.toString()
            L_0x016c:
                int r11 = r11 + 1
                goto L_0x0052
            L_0x0170:
                com.mbridge.msdk.click.g r11 = com.mbridge.msdk.click.g.this
                com.mbridge.msdk.click.e$a r11 = r11.g
                int r11 = r11.f
                r12 = 200(0xc8, float:2.8E-43)
                if (r11 != r12) goto L_0x017e
                r11 = r8
                goto L_0x017f
            L_0x017e:
                r11 = r4
            L_0x017f:
                if (r11 == 0) goto L_0x0193
                r1.setjumpDone(r8)
                r1.setUrl(r0)
                com.mbridge.msdk.click.g r11 = com.mbridge.msdk.click.g.this
                com.mbridge.msdk.click.e$a r11 = r11.g
                java.lang.String r11 = r11.g
                r1.setContent(r11)
                goto L_0x0199
            L_0x0193:
                r1.setjumpDone(r4)
                r1.setUrl(r0)
            L_0x0199:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.click.g.a.a(java.lang.String, boolean, boolean, com.mbridge.msdk.foundation.entity.CampaignEx):com.mbridge.msdk.click.CommonJumpLoader$JumpLoaderResult");
        }

        /* access modifiers changed from: private */
        public boolean a(String str) {
            CampaignEx campaignEx = this.j;
            if (campaignEx != null) {
                campaignEx.getLinkType();
            }
            if (t.a.a(str)) {
                g.this.b.setCode(1);
                g.this.b.setUrl(str);
                g.this.b.setjumpDone(true);
                return true;
            }
            g.this.b.setCode(2);
            g.this.b.setUrl(str);
            return false;
        }

        private boolean b(String str) {
            return !URLUtil.isNetworkUrl(str);
        }

        public final void a() {
            if (g.this.a != null) {
                g.this.a.a((Object) null);
            }
            CommonJumpLoader.JumpLoaderResult unused = g.this.b = new CommonJumpLoader.JumpLoaderResult();
            g.this.b.setUrl(this.g);
            CommonJumpLoader.JumpLoaderResult unused2 = g.this.b = a(this.g, this.k, this.l, this.j);
            if (!TextUtils.isEmpty(g.this.b.getExceptionMsg())) {
                g.this.b.setSuccess(true);
            }
            if (g.this.c && g.this.b.isSuccess()) {
                if (g.this.g != null) {
                    g.this.b.setStatusCode(g.this.g.f);
                }
                if (t.a.a(g.this.b.getUrl()) || 200 != g.this.g.f || TextUtils.isEmpty(g.this.b.getContent()) || g.this.b.getContent().contains("EXCEPTION_CAMPAIGN_NOT_ACTIVE")) {
                    if (g.this.g != null) {
                        g.this.b.setType(1);
                        g.this.b.setExceptionMsg(g.this.g.h);
                        g.this.b.setStatusCode(g.this.g.f);
                        g.this.b.setHeader(g.this.g.a());
                        g.this.b.setContent(g.this.g.g);
                    }
                    a(g.this.b.getUrl());
                    return;
                }
                g.this.b.setType(2);
                if (!TextUtils.isEmpty(g.this.b.getContent())) {
                    new f().a(this.h, this.i, this.f, g.this.b.getUrl(), g.this.b.getContent(), this.m);
                } else {
                    try {
                        new f().a(this.h, this.i, this.f, g.this.b.getUrl(), this.m);
                    } catch (Exception unused3) {
                    }
                }
                this.e.acquireUninterruptibly();
            }
        }
    }

    public final void a(a.C0062a aVar) {
        if (aVar == a.C0062a.FINISH && this.c) {
            this.h.post(new Runnable() {
                public final void run() {
                    if (g.this.a == null) {
                        return;
                    }
                    if (g.this.b.isSuccess()) {
                        g.this.a.b(g.this.b);
                    } else {
                        g.this.a.a(g.this.b, g.this.b.getMsg());
                    }
                }
            });
        }
    }
}
