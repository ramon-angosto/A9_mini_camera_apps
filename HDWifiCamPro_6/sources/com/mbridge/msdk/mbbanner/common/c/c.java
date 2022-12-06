package com.mbridge.msdk.mbbanner.common.c;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Base64;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.mbridge.msdk.b.d;
import com.mbridge.msdk.foundation.db.f;
import com.mbridge.msdk.foundation.db.j;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.o;
import com.mbridge.msdk.foundation.tools.q;
import com.mbridge.msdk.foundation.tools.u;
import com.mbridge.msdk.mbbanner.common.b.a;
import com.mbridge.msdk.mbbanner.common.util.BannerUtils;
import com.mbridge.msdk.mbbanner.view.MBBannerWebView;
import com.mbridge.msdk.mbsignalcommon.b.b;
import com.mbridge.msdk.mbsignalcommon.windvane.g;
import com.mbridge.msdk.out.Campaign;
import com.mbridge.msdk.out.MBBannerView;
import com.mbridge.msdk.out.NativeListener;
import com.mbridge.msdk.videocommon.download.h;
import com.mbridge.msdk.widget.FeedBackButton;
import java.io.File;
import java.util.List;
import org.json.JSONObject;

/* compiled from: BannerShowManager */
public final class c {
    /* access modifiers changed from: private */
    public static String b = "BannerShowManager";
    private View.OnClickListener A = new View.OnClickListener() {
        public final void onClick(View view) {
            if (c.this.p) {
                c.b(c.this);
            }
        }
    };
    private a B = new a() {
        public final void a(int i) {
            if (i == 2) {
                c.c(c.this);
            } else {
                c.this.f();
            }
        }

        public final void a(String str) {
            c.b(c.this);
        }

        public final void a() {
            c.b(c.this);
        }

        public final void b(int i) {
            if (i == 1) {
                c.this.d();
                c.this.a("", 1);
                return;
            }
            c.this.c();
        }

        public final void a(CampaignEx campaignEx) {
            c.this.a(campaignEx);
        }

        public final void a(boolean z) {
            if (c.this.c != null) {
                boolean unused = c.this.o = z;
                if (z) {
                    c.this.c.c();
                } else {
                    c.this.c.d();
                }
            }
        }

        public final void a(boolean z, String str) {
            try {
                if (c.this.c == null) {
                    return;
                }
                if (TextUtils.isEmpty(str)) {
                    c.this.c.a();
                    c.this.c.b();
                    return;
                }
                CampaignEx parseCampaignWithBackData = CampaignEx.parseCampaignWithBackData(CampaignEx.campaignToJsonObject(c.this.e));
                parseCampaignWithBackData.setClickURL(str);
                if (z) {
                    String i = c.this.q;
                    if (parseCampaignWithBackData != null) {
                        try {
                            if (!TextUtils.isEmpty(str)) {
                                new com.mbridge.msdk.foundation.same.report.c(com.mbridge.msdk.foundation.controller.a.e().g()).b(parseCampaignWithBackData.getRequestId(), parseCampaignWithBackData.getRequestIdNotice(), parseCampaignWithBackData.getId(), i, str, parseCampaignWithBackData.isBidCampaign());
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
                c.this.a(parseCampaignWithBackData);
            } catch (Exception e2) {
                q.d(c.b, e2.getMessage());
            }
        }
    };
    private b C = new b() {
        public final void a(WebView webView, String str) {
            boolean unused = c.this.l = true;
            q.d("BannerCallJS", "fireOnSignalCommunication");
            g.a().a(webView);
            boolean unused2 = c.this.n = true;
            if (c.this.e != null && !c.this.e.isHasMBTplMark()) {
                c.this.d();
                c.this.a("", 1);
            }
        }

        public final void a(WebView webView, int i, String str, String str2) {
            c.this.a(str);
            c.this.a(str, 2);
        }
    };
    com.mbridge.msdk.click.a a;
    /* access modifiers changed from: private */
    public com.mbridge.msdk.mbbanner.common.b.c c;
    private boolean d;
    /* access modifiers changed from: private */
    public CampaignEx e;
    /* access modifiers changed from: private */
    public MBBannerView f;
    /* access modifiers changed from: private */
    public ImageView g;
    /* access modifiers changed from: private */
    public MBBannerWebView h;
    private ImageView i;
    private boolean j;
    private boolean k;
    /* access modifiers changed from: private */
    public boolean l;
    private boolean m;
    /* access modifiers changed from: private */
    public boolean n;
    /* access modifiers changed from: private */
    public boolean o;
    /* access modifiers changed from: private */
    public boolean p;
    /* access modifiers changed from: private */
    public String q;
    private String r;
    private List<CampaignEx> s;
    private int t;
    private long u = 15000;
    private com.mbridge.msdk.mbbanner.common.bridge.a v;
    private Handler w = new Handler(Looper.getMainLooper()) {
        public final void handleMessage(Message message) {
            super.handleMessage(message);
            int i = message.what;
        }
    };
    private com.mbridge.msdk.foundation.same.e.a x = new com.mbridge.msdk.foundation.same.e.a() {
        public final void b() {
        }

        public final void a() {
            c.this.a("banner render failed because render is timeout");
        }
    };
    /* access modifiers changed from: private */
    public float y;
    /* access modifiers changed from: private */
    public float z;

    public c(MBBannerView mBBannerView, com.mbridge.msdk.mbbanner.common.b.c cVar, String str, String str2, boolean z2, d dVar) {
        this.d = z2;
        this.f = mBBannerView;
        this.q = str2;
        this.r = str;
        this.c = new com.mbridge.msdk.mbbanner.common.b.g(cVar, dVar);
    }

    public final void a(boolean z2, int i2) {
        this.t = i2;
        if (i2 == 0) {
            d e2 = com.mbridge.msdk.b.b.a().e(com.mbridge.msdk.foundation.controller.a.e().h(), this.q);
            if (e2 != null) {
                z2 = e2.c() == 1;
            } else {
                return;
            }
        }
        this.d = z2;
    }

    public final void a(boolean z2) {
        this.d = z2;
    }

    /* access modifiers changed from: private */
    public void c() {
        if (this.f != null) {
            MBBannerWebView mBBannerWebView = this.h;
            if (!(mBBannerWebView == null || mBBannerWebView.getParent() == null)) {
                this.f.removeView(this.h);
            }
            if (this.g == null) {
                this.g = new ImageView(com.mbridge.msdk.foundation.controller.a.e().g());
                this.g.setOnTouchListener(new View.OnTouchListener() {
                    public final boolean onTouch(View view, MotionEvent motionEvent) {
                        float unused = c.this.y = motionEvent.getRawX();
                        float unused2 = c.this.z = motionEvent.getRawY();
                        String b = c.b;
                        q.d(b, c.this.y + "  " + c.this.z);
                        return false;
                    }
                });
                this.g.setOnClickListener(new View.OnClickListener() {
                    public final void onClick(View view) {
                        c.this.a(BannerUtils.managerCampaignEX(com.mbridge.msdk.mbsignalcommon.communication.b.a(c.this.y, c.this.z), c.this.e));
                    }
                });
            }
            String imageUrl = this.e.getImageUrl();
            if (!TextUtils.isEmpty(imageUrl)) {
                com.mbridge.msdk.foundation.same.c.b.a(com.mbridge.msdk.foundation.controller.a.e().g()).a(imageUrl, (com.mbridge.msdk.foundation.same.c.c) new com.mbridge.msdk.foundation.same.c.c() {
                    public final void onSuccessLoad(Bitmap bitmap, String str) {
                        if (c.this.g != null) {
                            c.this.g.setImageBitmap(bitmap);
                        }
                        boolean unused = c.this.l = true;
                        c.m(c.this);
                        c.this.f();
                        c.this.d();
                    }

                    public final void onFailedLoad(String str, String str2) {
                        c.this.a("banner show failed because banner default view is exception");
                    }
                });
            } else {
                a("banner show failed because campain is exception");
            }
        } else {
            a("banner show failed because banner view is exception");
        }
    }

    private String b(CampaignEx campaignEx) {
        if (campaignEx == null) {
            return "";
        }
        String b2 = h.a().b(campaignEx.getBannerUrl());
        if (TextUtils.isEmpty(b2)) {
            b2 = campaignEx.getBannerHtml();
            if (campaignEx.isActiveOm()) {
                try {
                    File file = new File(b2);
                    if (file.exists()) {
                        return o.a(file);
                    }
                    return "";
                } catch (Exception unused) {
                    File file2 = new File(b2);
                    if (file2.exists() && file2.isFile() && file2.canRead()) {
                        return "file:////" + b2;
                    }
                }
            } else {
                File file3 = new File(b2);
                if (file3.exists() && file3.isFile() && file3.canRead()) {
                    return "file:////" + b2;
                }
            }
        }
        return b2;
    }

    /* access modifiers changed from: private */
    public void a(String str) {
        if (this.e != null && !e()) {
            this.w.removeCallbacks(this.x);
            com.mbridge.msdk.mbbanner.common.b.c cVar = this.c;
            if (cVar != null) {
                cVar.a(str);
            }
            com.mbridge.msdk.foundation.same.report.d.b(com.mbridge.msdk.foundation.controller.a.e().g(), this.e, this.q, str);
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x01d8  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x01f2  */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x02f1  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void d() {
        /*
            r23 = this;
            r1 = r23
            java.lang.String r2 = "true"
            boolean r0 = r1.l
            r3 = 1
            if (r0 == 0) goto L_0x0047
            boolean r0 = r1.m
            if (r0 != 0) goto L_0x0047
            com.mbridge.msdk.mbbanner.common.b.c r0 = r1.c
            if (r0 == 0) goto L_0x0047
            r1.m = r3
            android.os.Handler r0 = r1.w
            com.mbridge.msdk.foundation.same.e.a r4 = r1.x
            r0.removeCallbacks(r4)
            com.mbridge.msdk.foundation.entity.CampaignEx r0 = r1.e
            if (r0 == 0) goto L_0x0047
            boolean r0 = r0.isCallbacked()
            if (r0 != 0) goto L_0x0047
            com.mbridge.msdk.foundation.entity.CampaignEx r0 = r1.e
            r0.setCallbacked(r3)
            com.mbridge.msdk.mbbanner.common.b.c r0 = r1.c
            java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx> r4 = r1.s
            r0.a((java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx>) r4)
            com.mbridge.msdk.foundation.controller.a r0 = com.mbridge.msdk.foundation.controller.a.e()
            android.content.Context r0 = r0.g()
            com.mbridge.msdk.foundation.entity.CampaignEx r4 = r1.e
            int r4 = r4.getMaitve()
            com.mbridge.msdk.foundation.entity.CampaignEx r5 = r1.e
            java.lang.String r5 = r5.getMaitve_src()
            com.mbridge.msdk.click.b.a((android.content.Context) r0, (int) r4, (java.lang.String) r5)
        L_0x0047:
            boolean r0 = r1.l
            if (r0 == 0) goto L_0x02f7
            boolean r0 = r1.j
            if (r0 == 0) goto L_0x02f7
            boolean r0 = r1.k
            if (r0 == 0) goto L_0x02f7
            boolean r0 = r1.m
            if (r0 == 0) goto L_0x02f7
            com.mbridge.msdk.foundation.entity.CampaignEx r0 = r1.e
            if (r0 == 0) goto L_0x02f7
            boolean r0 = r23.e()
            if (r0 != 0) goto L_0x02f7
            com.mbridge.msdk.out.MBBannerView r0 = r1.f
            r4 = 0
            if (r0 != 0) goto L_0x0067
            goto L_0x0073
        L_0x0067:
            boolean r0 = com.mbridge.msdk.foundation.tools.z.a(r0)
            if (r0 != 0) goto L_0x0073
            boolean r0 = r1.o
            if (r0 != 0) goto L_0x0073
            r5 = r3
            goto L_0x0074
        L_0x0073:
            r5 = r4
        L_0x0074:
            r6 = 1000(0x3e8, double:4.94E-321)
            if (r5 != 0) goto L_0x0084
            com.mbridge.msdk.out.MBBannerView r0 = r1.f
            if (r0 == 0) goto L_0x0084
            com.mbridge.msdk.mbbanner.common.c.c$11 r8 = new com.mbridge.msdk.mbbanner.common.c.c$11
            r8.<init>()
            r0.postDelayed(r8, r6)
        L_0x0084:
            boolean r0 = r1.n
            if (r0 == 0) goto L_0x01ee
            if (r5 == 0) goto L_0x01ee
            r8 = 2
            int[] r9 = new int[r8]
            com.mbridge.msdk.out.MBBannerView r0 = r1.f
            r0.getLocationInWindow(r9)
            com.mbridge.msdk.mbbanner.view.MBBannerWebView r0 = r1.h
            r10 = r9[r4]
            float r10 = (float) r10
            r11 = r9[r3]
            float r11 = (float) r11
            java.lang.String r12 = "fireOnBannerWebViewShow"
            java.lang.String r13 = "BannerCallJS"
            com.mbridge.msdk.foundation.tools.q.d(r13, r12)
            org.json.JSONObject r14 = new org.json.JSONObject     // Catch:{ all -> 0x00da }
            r14.<init>()     // Catch:{ all -> 0x00da }
            java.lang.String r15 = "startX"
            double r6 = (double) r10     // Catch:{ all -> 0x00da }
            r14.put(r15, r6)     // Catch:{ all -> 0x00da }
            java.lang.String r6 = "startY"
            double r10 = (double) r11     // Catch:{ all -> 0x00da }
            r14.put(r6, r10)     // Catch:{ all -> 0x00da }
            java.lang.String r6 = "scale"
            com.mbridge.msdk.foundation.controller.a r7 = com.mbridge.msdk.foundation.controller.a.e()     // Catch:{ all -> 0x00da }
            android.content.Context r7 = r7.g()     // Catch:{ all -> 0x00da }
            float r7 = com.mbridge.msdk.foundation.tools.u.d((android.content.Context) r7)     // Catch:{ all -> 0x00da }
            double r10 = (double) r7     // Catch:{ all -> 0x00da }
            r14.put(r6, r10)     // Catch:{ all -> 0x00da }
            java.lang.String r6 = r14.toString()     // Catch:{ all -> 0x00da }
            byte[] r6 = r6.getBytes()     // Catch:{ all -> 0x00da }
            java.lang.String r6 = android.util.Base64.encodeToString(r6, r8)     // Catch:{ all -> 0x00da }
            com.mbridge.msdk.mbsignalcommon.windvane.g r7 = com.mbridge.msdk.mbsignalcommon.windvane.g.a()     // Catch:{ all -> 0x00da }
            java.lang.String r10 = "webviewshow"
            r7.a((android.webkit.WebView) r0, (java.lang.String) r10, (java.lang.String) r6)     // Catch:{ all -> 0x00da }
            goto L_0x00de
        L_0x00da:
            r0 = move-exception
            com.mbridge.msdk.foundation.tools.q.a(r13, r12, r0)
        L_0x00de:
            com.mbridge.msdk.mbbanner.view.MBBannerWebView r0 = r1.h
            r6 = r9[r4]
            r7 = r9[r3]
            com.mbridge.msdk.out.MBBannerView r9 = r1.f
            int r9 = r9.getWidth()
            com.mbridge.msdk.out.MBBannerView r10 = r1.f
            int r10 = r10.getHeight()
            com.mbridge.msdk.foundation.controller.a r11 = com.mbridge.msdk.foundation.controller.a.e()     // Catch:{ all -> 0x01c1 }
            android.content.Context r11 = r11.g()     // Catch:{ all -> 0x01c1 }
            android.content.res.Resources r11 = r11.getResources()     // Catch:{ all -> 0x01c1 }
            android.content.res.Configuration r11 = r11.getConfiguration()     // Catch:{ all -> 0x01c1 }
            int r11 = r11.orientation     // Catch:{ all -> 0x01c1 }
            org.json.JSONObject r12 = new org.json.JSONObject     // Catch:{ all -> 0x01c1 }
            r12.<init>()     // Catch:{ all -> 0x01c1 }
            java.lang.String r14 = "orientation"
            if (r11 != r8) goto L_0x010e
            java.lang.String r8 = "landscape"
            goto L_0x0115
        L_0x010e:
            if (r11 != r3) goto L_0x0113
            java.lang.String r8 = "portrait"
            goto L_0x0115
        L_0x0113:
            java.lang.String r8 = "undefined"
        L_0x0115:
            r12.put(r14, r8)     // Catch:{ all -> 0x01c1 }
            java.lang.String r8 = "locked"
            r12.put(r8, r2)     // Catch:{ all -> 0x01c1 }
            com.mbridge.msdk.foundation.controller.a r8 = com.mbridge.msdk.foundation.controller.a.e()     // Catch:{ all -> 0x01c1 }
            android.content.Context r8 = r8.g()     // Catch:{ all -> 0x01c1 }
            int r8 = com.mbridge.msdk.foundation.tools.m.h(r8)     // Catch:{ all -> 0x01c1 }
            float r8 = (float) r8     // Catch:{ all -> 0x01c1 }
            com.mbridge.msdk.foundation.controller.a r11 = com.mbridge.msdk.foundation.controller.a.e()     // Catch:{ all -> 0x01c1 }
            android.content.Context r11 = r11.g()     // Catch:{ all -> 0x01c1 }
            int r11 = com.mbridge.msdk.foundation.tools.m.i(r11)     // Catch:{ all -> 0x01c1 }
            float r11 = (float) r11     // Catch:{ all -> 0x01c1 }
            com.mbridge.msdk.foundation.controller.a r14 = com.mbridge.msdk.foundation.controller.a.e()     // Catch:{ all -> 0x01c1 }
            android.content.Context r14 = r14.g()     // Catch:{ all -> 0x01c1 }
            java.util.HashMap r14 = com.mbridge.msdk.foundation.tools.m.j(r14)     // Catch:{ all -> 0x01c1 }
            java.lang.String r15 = "width"
            java.lang.Object r15 = r14.get(r15)     // Catch:{ all -> 0x01c1 }
            java.lang.Integer r15 = (java.lang.Integer) r15     // Catch:{ all -> 0x01c1 }
            int r15 = r15.intValue()     // Catch:{ all -> 0x01c1 }
            java.lang.String r3 = "height"
            java.lang.Object r3 = r14.get(r3)     // Catch:{ all -> 0x01c1 }
            java.lang.Integer r3 = (java.lang.Integer) r3     // Catch:{ all -> 0x01c1 }
            int r3 = r3.intValue()     // Catch:{ all -> 0x01c1 }
            java.util.HashMap r14 = new java.util.HashMap     // Catch:{ all -> 0x01c1 }
            r14.<init>()     // Catch:{ all -> 0x01c1 }
            java.lang.String r4 = "placementType"
            r22 = r5
            java.lang.String r5 = "inline"
            r14.put(r4, r5)     // Catch:{ all -> 0x01bf }
            java.lang.String r4 = "state"
            java.lang.String r5 = "default"
            r14.put(r4, r5)     // Catch:{ all -> 0x01bf }
            java.lang.String r4 = "viewable"
            r14.put(r4, r2)     // Catch:{ all -> 0x01bf }
            java.lang.String r2 = "currentAppOrientation"
            r14.put(r2, r12)     // Catch:{ all -> 0x01bf }
            com.mbridge.msdk.mbsignalcommon.mraid.a r16 = com.mbridge.msdk.mbsignalcommon.mraid.a.a()     // Catch:{ all -> 0x01bf }
            float r2 = (float) r6     // Catch:{ all -> 0x01bf }
            float r4 = (float) r7     // Catch:{ all -> 0x01bf }
            float r5 = (float) r9     // Catch:{ all -> 0x01bf }
            float r6 = (float) r10     // Catch:{ all -> 0x01bf }
            r17 = r0
            r18 = r2
            r19 = r4
            r20 = r5
            r21 = r6
            r16.a(r17, r18, r19, r20, r21)     // Catch:{ all -> 0x01bf }
            com.mbridge.msdk.mbsignalcommon.mraid.a r16 = com.mbridge.msdk.mbsignalcommon.mraid.a.a()     // Catch:{ all -> 0x01bf }
            r17 = r0
            r18 = r2
            r19 = r4
            r20 = r5
            r21 = r6
            r16.b(r17, r18, r19, r20, r21)     // Catch:{ all -> 0x01bf }
            com.mbridge.msdk.mbsignalcommon.mraid.a r2 = com.mbridge.msdk.mbsignalcommon.mraid.a.a()     // Catch:{ all -> 0x01bf }
            r2.b(r0, r8, r11)     // Catch:{ all -> 0x01bf }
            com.mbridge.msdk.mbsignalcommon.mraid.a r2 = com.mbridge.msdk.mbsignalcommon.mraid.a.a()     // Catch:{ all -> 0x01bf }
            float r4 = (float) r15     // Catch:{ all -> 0x01bf }
            float r3 = (float) r3     // Catch:{ all -> 0x01bf }
            r2.c(r0, r4, r3)     // Catch:{ all -> 0x01bf }
            com.mbridge.msdk.mbsignalcommon.mraid.a r2 = com.mbridge.msdk.mbsignalcommon.mraid.a.a()     // Catch:{ all -> 0x01bf }
            r2.a((android.webkit.WebView) r0, (java.util.Map<java.lang.String, java.lang.Object>) r14)     // Catch:{ all -> 0x01bf }
            com.mbridge.msdk.mbsignalcommon.mraid.a r2 = com.mbridge.msdk.mbsignalcommon.mraid.a.a()     // Catch:{ all -> 0x01bf }
            r2.a(r0)     // Catch:{ all -> 0x01bf }
            goto L_0x01c9
        L_0x01bf:
            r0 = move-exception
            goto L_0x01c4
        L_0x01c1:
            r0 = move-exception
            r22 = r5
        L_0x01c4:
            java.lang.String r2 = "transInfoForMraid"
            com.mbridge.msdk.foundation.tools.q.a(r13, r2, r0)
        L_0x01c9:
            r2 = 0
            r1.n = r2
            com.mbridge.msdk.foundation.entity.CampaignEx r0 = r1.e
            java.lang.String r0 = r0.getImageUrl()
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x01f0
            com.mbridge.msdk.foundation.controller.a r0 = com.mbridge.msdk.foundation.controller.a.e()
            android.content.Context r0 = r0.g()
            com.mbridge.msdk.foundation.same.c.b r0 = com.mbridge.msdk.foundation.same.c.b.a((android.content.Context) r0)
            com.mbridge.msdk.foundation.entity.CampaignEx r2 = r1.e
            java.lang.String r2 = r2.getImageUrl()
            r0.c(r2)
            goto L_0x01f0
        L_0x01ee:
            r22 = r5
        L_0x01f0:
            if (r22 == 0) goto L_0x02f1
            android.widget.ImageView r0 = r1.g
            java.lang.String r2 = "banner"
            if (r0 == 0) goto L_0x023a
            int r0 = r0.getVisibility()
            if (r0 != 0) goto L_0x023a
            com.mbridge.msdk.foundation.entity.CampaignEx r0 = r1.e
            if (r0 == 0) goto L_0x02cc
            if (r0 == 0) goto L_0x022b
            com.mbridge.msdk.foundation.controller.a r3 = com.mbridge.msdk.foundation.controller.a.e()
            android.content.Context r3 = r3.g()
            java.lang.String r4 = r1.q
            r1.c(r0, r3, r4)
            com.mbridge.msdk.foundation.controller.a r3 = com.mbridge.msdk.foundation.controller.a.e()
            android.content.Context r3 = r3.g()
            java.lang.String r4 = r1.q
            r1.b(r0, r3, r4)
            com.mbridge.msdk.foundation.controller.a r3 = com.mbridge.msdk.foundation.controller.a.e()
            android.content.Context r3 = r3.g()
            java.lang.String r4 = r1.q
            r1.a((com.mbridge.msdk.foundation.entity.CampaignEx) r0, (android.content.Context) r3, (java.lang.String) r4)
        L_0x022b:
            com.mbridge.msdk.foundation.entity.CampaignEx r0 = r1.e
            r3 = 1
            r0.setReport(r3)
            java.lang.String r0 = r1.q
            com.mbridge.msdk.foundation.entity.CampaignEx r3 = r1.e
            com.mbridge.msdk.foundation.same.a.d.a((java.lang.String) r0, (com.mbridge.msdk.foundation.entity.CampaignEx) r3, (java.lang.String) r2)
            goto L_0x02cc
        L_0x023a:
            java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx> r0 = r1.s
            if (r0 == 0) goto L_0x02cc
            int r0 = r0.size()
            if (r0 <= 0) goto L_0x02cc
            r0 = 0
            r3 = 0
            r4 = 0
        L_0x0247:
            java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx> r5 = r1.s
            int r5 = r5.size()
            if (r0 >= r5) goto L_0x02a0
            java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx> r5 = r1.s
            java.lang.Object r5 = r5.get(r0)
            com.mbridge.msdk.foundation.entity.CampaignEx r5 = (com.mbridge.msdk.foundation.entity.CampaignEx) r5
            boolean r5 = r5.isHasMBTplMark()
            if (r5 != 0) goto L_0x029d
            if (r0 == 0) goto L_0x026d
            java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx> r5 = r1.s
            java.lang.Object r5 = r5.get(r0)
            com.mbridge.msdk.foundation.entity.CampaignEx r5 = (com.mbridge.msdk.foundation.entity.CampaignEx) r5
            boolean r5 = r5.isReport()
            if (r5 != 0) goto L_0x029d
        L_0x026d:
            java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx> r3 = r1.s
            java.lang.Object r3 = r3.get(r0)
            com.mbridge.msdk.foundation.entity.CampaignEx r3 = (com.mbridge.msdk.foundation.entity.CampaignEx) r3
            com.mbridge.msdk.foundation.controller.a r4 = com.mbridge.msdk.foundation.controller.a.e()
            android.content.Context r4 = r4.g()
            java.lang.String r5 = r1.q
            r1.c(r3, r4, r5)
            java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx> r3 = r1.s
            java.lang.Object r3 = r3.get(r0)
            com.mbridge.msdk.foundation.entity.CampaignEx r3 = (com.mbridge.msdk.foundation.entity.CampaignEx) r3
            r4 = 1
            r3.setReport(r4)
            java.lang.String r3 = r1.q
            java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx> r4 = r1.s
            java.lang.Object r4 = r4.get(r0)
            com.mbridge.msdk.foundation.entity.CampaignEx r4 = (com.mbridge.msdk.foundation.entity.CampaignEx) r4
            com.mbridge.msdk.foundation.same.a.d.a((java.lang.String) r3, (com.mbridge.msdk.foundation.entity.CampaignEx) r4, (java.lang.String) r2)
            r4 = r0
            r3 = 1
        L_0x029d:
            int r0 = r0 + 1
            goto L_0x0247
        L_0x02a0:
            if (r3 == 0) goto L_0x02cc
            java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx> r0 = r1.s
            java.lang.Object r0 = r0.get(r4)
            com.mbridge.msdk.foundation.entity.CampaignEx r0 = (com.mbridge.msdk.foundation.entity.CampaignEx) r0
            com.mbridge.msdk.foundation.controller.a r2 = com.mbridge.msdk.foundation.controller.a.e()
            android.content.Context r2 = r2.g()
            java.lang.String r3 = r1.q
            r1.b(r0, r2, r3)
            java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx> r0 = r1.s
            java.lang.Object r0 = r0.get(r4)
            com.mbridge.msdk.foundation.entity.CampaignEx r0 = (com.mbridge.msdk.foundation.entity.CampaignEx) r0
            com.mbridge.msdk.foundation.controller.a r2 = com.mbridge.msdk.foundation.controller.a.e()
            android.content.Context r2 = r2.g()
            java.lang.String r3 = r1.q
            r1.a((com.mbridge.msdk.foundation.entity.CampaignEx) r0, (android.content.Context) r2, (java.lang.String) r3)
        L_0x02cc:
            r2 = 1
            r1.p = r2
            com.mbridge.msdk.mbbanner.common.b.c r0 = r1.c
            if (r0 == 0) goto L_0x02d8
            com.mbridge.msdk.foundation.entity.CampaignEx r3 = r1.e
            r0.a((com.mbridge.msdk.foundation.entity.CampaignEx) r3)
        L_0x02d8:
            android.os.Handler r0 = r1.w
            r3 = 1000(0x3e8, double:4.94E-321)
            r0.sendEmptyMessageDelayed(r2, r3)
            com.mbridge.msdk.foundation.controller.a r0 = com.mbridge.msdk.foundation.controller.a.e()
            android.content.Context r0 = r0.g()
            com.mbridge.msdk.foundation.entity.CampaignEx r2 = r1.e
            java.lang.String r3 = r1.q
            java.lang.String r4 = ""
            com.mbridge.msdk.foundation.same.report.d.a((android.content.Context) r0, (com.mbridge.msdk.foundation.entity.CampaignEx) r2, (java.lang.String) r3, (java.lang.String) r4)
            goto L_0x02f7
        L_0x02f1:
            com.mbridge.msdk.foundation.entity.CampaignEx r0 = r1.e
            r2 = 0
            r0.setReport(r2)
        L_0x02f7:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.mbbanner.common.c.c.d():void");
    }

    private synchronized boolean e() {
        boolean isReport;
        isReport = this.e.isReport();
        if (!isReport) {
            this.e.setReport(true);
        }
        return isReport;
    }

    /* access modifiers changed from: private */
    public void f() {
        ImageView imageView;
        if (this.d && (imageView = this.i) != null) {
            if (imageView.getVisibility() != 0) {
                this.i.setVisibility(0);
                this.i.setOnClickListener(this.A);
            }
            if (this.i.getParent() == null && this.f != null) {
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(u.b(com.mbridge.msdk.foundation.controller.a.e().g(), 12.0f), u.b(com.mbridge.msdk.foundation.controller.a.e().g(), 12.0f));
                layoutParams.addRule(11);
                layoutParams.addRule(10);
                this.f.addView(this.i, layoutParams);
            }
        }
    }

    public final void a() {
        if (this.c != null) {
            this.c = null;
        }
        MBBannerWebView mBBannerWebView = this.h;
        if (mBBannerWebView != null) {
            mBBannerWebView.setWebViewListener((com.mbridge.msdk.mbsignalcommon.windvane.d) null);
        }
        if (this.C != null) {
            this.C = null;
        }
        ImageView imageView = this.i;
        if (imageView != null) {
            imageView.setOnClickListener((View.OnClickListener) null);
        }
        ImageView imageView2 = this.g;
        if (imageView2 != null) {
            imageView2.setOnClickListener((View.OnClickListener) null);
        }
        MBBannerView mBBannerView = this.f;
        if (mBBannerView != null) {
            mBBannerView.removeAllViews();
        }
        MBBannerWebView mBBannerWebView2 = this.h;
        if (mBBannerWebView2 != null) {
            mBBannerWebView2.release();
        }
        com.mbridge.msdk.mbbanner.common.bridge.a aVar = this.v;
        if (aVar != null) {
            aVar.a();
        }
        if (this.B != null) {
            this.B = null;
        }
        com.mbridge.msdk.foundation.b.b.a().b(this.q);
    }

    public final void b(boolean z2) {
        this.j = z2;
        d();
        if (!z2) {
            CampaignEx campaignEx = this.e;
            String str = this.q;
            if (campaignEx != null) {
                String a2 = com.mbridge.msdk.mbsignalcommon.mraid.c.a(campaignEx.getId());
                if (!TextUtils.isEmpty(a2)) {
                    new com.mbridge.msdk.foundation.same.report.c(com.mbridge.msdk.foundation.controller.a.e().g()).a(campaignEx.getRequestId(), campaignEx.getRequestIdNotice(), campaignEx.getId(), str, a2, campaignEx.isBidCampaign());
                    com.mbridge.msdk.mbsignalcommon.mraid.c.b(campaignEx.getId());
                }
            }
        }
    }

    public final void c(boolean z2) {
        this.k = z2;
        d();
    }

    private void a(CampaignEx campaignEx, Context context, String str) {
        if (campaignEx != null) {
            try {
                List<String> pv_urls = campaignEx.getPv_urls();
                if (pv_urls != null && pv_urls.size() > 0) {
                    for (String a2 : pv_urls) {
                        com.mbridge.msdk.click.a.a(context, campaignEx, str, a2, false, true);
                    }
                }
            } catch (Throwable th) {
                q.d(b, th.getMessage());
            }
        }
    }

    private void b(CampaignEx campaignEx, Context context, String str) {
        if (campaignEx != null) {
            try {
                if (!TextUtils.isEmpty(campaignEx.getOnlyImpressionURL())) {
                    com.mbridge.msdk.click.a.a(context, campaignEx, str, campaignEx.getOnlyImpressionURL(), false, true);
                }
            } catch (Throwable th) {
                q.d(b, th.getMessage());
            }
        }
    }

    private void c(final CampaignEx campaignEx, final Context context, String str) {
        if (!TextUtils.isEmpty(campaignEx.getImpressionURL())) {
            new Thread(new Runnable() {
                public final void run() {
                    try {
                        j.a((f) com.mbridge.msdk.foundation.db.g.a(context)).b(campaignEx.getId());
                    } catch (Exception e) {
                        q.d(c.b, e.getMessage());
                    }
                }
            }).start();
            com.mbridge.msdk.click.a.a(context, campaignEx, str, campaignEx.getImpressionURL(), false, true);
        }
        if (!TextUtils.isEmpty(str) && campaignEx.getNativeVideoTracking() != null && campaignEx.getNativeVideoTracking().i() != null) {
            com.mbridge.msdk.click.a.a(context, campaignEx, str, campaignEx.getNativeVideoTracking().i(), false, false);
        }
    }

    public final void a(CampaignEx campaignEx) {
        if (this.p) {
            if (this.a == null) {
                this.a = new com.mbridge.msdk.click.a(com.mbridge.msdk.foundation.controller.a.e().g(), this.q);
            }
            this.a.a((NativeListener.NativeTrackingListener) new NativeListener.TrackingExListener() {
                public final void onDismissLoading(Campaign campaign) {
                }

                public final void onDownloadFinish(Campaign campaign) {
                }

                public final void onDownloadProgress(int i) {
                }

                public final void onDownloadStart(Campaign campaign) {
                }

                public final void onFinishRedirection(Campaign campaign, String str) {
                }

                public final boolean onInterceptDefaultLoadingDialog() {
                    return false;
                }

                public final void onRedirectionFailed(Campaign campaign, String str) {
                }

                public final void onShowLoading(Campaign campaign) {
                }

                public final void onStartRedirection(Campaign campaign, String str) {
                }

                public final void onLeaveApp() {
                    if (c.this.c != null) {
                        c.this.c.b();
                    }
                }
            });
            campaignEx.setCampaignUnitId(this.q);
            this.a.a(campaignEx);
            if (!this.e.isReportClick()) {
                this.e.setReportClick(true);
                Context g2 = com.mbridge.msdk.foundation.controller.a.e().g();
                if (!(campaignEx == null || campaignEx.getNativeVideoTracking() == null || campaignEx.getNativeVideoTracking().e() == null)) {
                    com.mbridge.msdk.click.a.a(g2, campaignEx, campaignEx.getCampaignUnitId(), campaignEx.getNativeVideoTracking().e(), false, false);
                }
            }
            com.mbridge.msdk.mbbanner.common.b.c cVar = this.c;
            if (cVar != null) {
                cVar.a();
            }
        }
    }

    /* access modifiers changed from: private */
    public void a(String str, int i2) {
        if (this.e != null) {
            com.mbridge.msdk.mbbanner.common.d.a.a(com.mbridge.msdk.mbbanner.common.a.a.a().c(this.e.getId()).b(this.q).e(this.e.getRequestId()).d(this.e.getRequestIdNotice()).g(str).a(i2).a(this.e.isBidCampaign()), this.q);
        }
    }

    public final void a(int i2, int i3, int i4, int i5) {
        if (i2 != i4 || i3 != i5) {
            MBBannerWebView mBBannerWebView = this.h;
            q.d("BannerCallJS", "fireOnBannerViewSizeChange");
            try {
                com.mbridge.msdk.mbsignalcommon.mraid.a.a().a((WebView) mBBannerWebView, (float) i2, (float) i3);
            } catch (Throwable th) {
                q.a("BannerCallJS", "fireOnBannerViewSizeChange", th);
            }
        }
    }

    private void d(boolean z2) {
        if (this.f != null) {
            FeedBackButton a2 = com.mbridge.msdk.foundation.b.b.a().a(this.q);
            if (com.mbridge.msdk.foundation.b.b.a().b() && z2 && a2 != null) {
                ViewGroup viewGroup = (ViewGroup) a2.getParent();
                if (viewGroup != null) {
                    viewGroup.removeView(a2);
                }
                a2.setVisibility(0);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) a2.getLayoutParams();
                if (layoutParams == null) {
                    layoutParams = new RelativeLayout.LayoutParams(com.mbridge.msdk.foundation.b.b.a, com.mbridge.msdk.foundation.b.b.b);
                }
                layoutParams.addRule(12);
                a2.setLayoutParams(layoutParams);
                this.f.addView(a2);
            }
            com.mbridge.msdk.foundation.b.b.a().a(this.q, (com.mbridge.msdk.foundation.b.a) new com.mbridge.msdk.foundation.b.a() {
                public final void a() {
                    String str;
                    c.this.f.onPause();
                    try {
                        JSONObject jSONObject = new JSONObject();
                        if (com.mbridge.msdk.foundation.controller.a.e().g() != null) {
                            jSONObject.put("status", 1);
                        }
                        str = jSONObject.toString();
                    } catch (Throwable th) {
                        q.a(c.b, th.getMessage(), th);
                        str = "";
                    }
                    g.a().a((WebView) c.this.h, "onFeedbackAlertStatusNotify", Base64.encodeToString(str.getBytes(), 2));
                }

                public final void b() {
                    String str;
                    c.this.f.onResume();
                    try {
                        JSONObject jSONObject = new JSONObject();
                        if (com.mbridge.msdk.foundation.controller.a.e().g() != null) {
                            jSONObject.put("status", 2);
                        }
                        str = jSONObject.toString();
                    } catch (Throwable th) {
                        q.a(c.b, th.getMessage(), th);
                        str = "";
                    }
                    g.a().a((WebView) c.this.h, "onFeedbackAlertStatusNotify", Base64.encodeToString(str.getBytes(), 2));
                }

                public final void a(String str) {
                    String str2;
                    c.this.f.onResume();
                    try {
                        JSONObject jSONObject = new JSONObject();
                        if (com.mbridge.msdk.foundation.controller.a.e().g() != null) {
                            jSONObject.put("status", 2);
                        }
                        str2 = jSONObject.toString();
                    } catch (Throwable th) {
                        q.a(c.b, th.getMessage(), th);
                        str2 = "";
                    }
                    g.a().a((WebView) c.this.h, "onFeedbackAlertStatusNotify", Base64.encodeToString(str2.getBytes(), 2));
                }
            });
            com.mbridge.msdk.foundation.b.b.a().a(this.q, this.e);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0029  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(com.mbridge.msdk.foundation.entity.CampaignUnit r10) {
        /*
            r9 = this;
            r0 = 0
            if (r10 == 0) goto L_0x001c
            java.util.ArrayList r10 = r10.getAds()
            r9.s = r10
            java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx> r10 = r9.s
            if (r10 == 0) goto L_0x001c
            int r10 = r10.size()
            if (r10 <= 0) goto L_0x001c
            java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx> r10 = r9.s
            java.lang.Object r10 = r10.get(r0)
            com.mbridge.msdk.foundation.entity.CampaignEx r10 = (com.mbridge.msdk.foundation.entity.CampaignEx) r10
            goto L_0x001d
        L_0x001c:
            r10 = 0
        L_0x001d:
            r9.e = r10
            com.mbridge.msdk.foundation.entity.CampaignEx r10 = r9.e
            if (r10 != 0) goto L_0x0029
            java.lang.String r10 = "banner show failed because campain is exception"
            r9.a((java.lang.String) r10)
            return
        L_0x0029:
            android.os.Handler r10 = r9.w
            com.mbridge.msdk.foundation.same.e.a r1 = r9.x
            r10.removeCallbacks(r1)
            boolean r10 = r9.d
            r1 = 8
            if (r10 == 0) goto L_0x006a
            android.widget.ImageView r10 = r9.i
            if (r10 != 0) goto L_0x006a
            android.widget.ImageView r10 = new android.widget.ImageView
            com.mbridge.msdk.foundation.controller.a r2 = com.mbridge.msdk.foundation.controller.a.e()
            android.content.Context r2 = r2.g()
            r10.<init>(r2)
            r9.i = r10
            android.widget.ImageView r10 = r9.i
            com.mbridge.msdk.foundation.controller.a r2 = com.mbridge.msdk.foundation.controller.a.e()
            android.content.Context r2 = r2.g()
            java.lang.String r3 = "mbridge_banner_close"
            java.lang.String r4 = "drawable"
            int r2 = com.mbridge.msdk.foundation.tools.k.a(r2, r3, r4)
            r10.setBackgroundResource(r2)
            android.widget.ImageView r10 = r9.i
            r10.setVisibility(r1)
            android.widget.ImageView r10 = r9.i
            java.lang.String r2 = "closeButton"
            r10.setContentDescription(r2)
        L_0x006a:
            r9.l = r0
            r9.m = r0
            r9.p = r0
            com.mbridge.msdk.foundation.entity.CampaignEx r10 = r9.e
            java.lang.String r10 = r10.getBannerHtml()
            boolean r10 = android.text.TextUtils.isEmpty(r10)
            if (r10 == 0) goto L_0x0088
            com.mbridge.msdk.foundation.entity.CampaignEx r10 = r9.e
            java.lang.String r10 = r10.getBannerUrl()
            boolean r10 = android.text.TextUtils.isEmpty(r10)
            if (r10 != 0) goto L_0x00e8
        L_0x0088:
            com.mbridge.msdk.mbbanner.common.a.a r10 = com.mbridge.msdk.mbbanner.common.a.a.a()
            com.mbridge.msdk.foundation.entity.CampaignEx r2 = r9.e
            java.lang.String r2 = r2.getId()
            com.mbridge.msdk.mbbanner.common.a.a r10 = r10.c(r2)
            com.mbridge.msdk.foundation.entity.CampaignEx r2 = r9.e
            java.lang.String r2 = r2.getRequestId()
            com.mbridge.msdk.mbbanner.common.a.a r10 = r10.e(r2)
            com.mbridge.msdk.foundation.entity.CampaignEx r2 = r9.e
            java.lang.String r2 = r2.getRequestIdNotice()
            com.mbridge.msdk.mbbanner.common.a.a r10 = r10.d(r2)
            java.lang.String r2 = r9.q
            com.mbridge.msdk.mbbanner.common.a.a r10 = r10.b(r2)
            com.mbridge.msdk.foundation.entity.CampaignEx r2 = r9.e
            boolean r2 = r2.isBidCampaign()
            com.mbridge.msdk.mbbanner.common.a.a r10 = r10.a((boolean) r2)
            java.lang.String r2 = r9.q
            if (r10 == 0) goto L_0x00e8
            java.lang.String r3 = "2000067"
            r10.a((java.lang.String) r3)
            com.mbridge.msdk.foundation.same.report.a r3 = com.mbridge.msdk.foundation.same.report.a.a()
            boolean r3 = r3.c()
            if (r3 == 0) goto L_0x00d9
            com.mbridge.msdk.foundation.same.report.a r2 = com.mbridge.msdk.foundation.same.report.a.a()
            java.lang.String r10 = r10.b()
            r2.a((java.lang.String) r10)
            goto L_0x00e8
        L_0x00d9:
            java.lang.String r10 = r10.b()
            com.mbridge.msdk.foundation.controller.a r3 = com.mbridge.msdk.foundation.controller.a.e()
            android.content.Context r3 = r3.g()
            com.mbridge.msdk.foundation.same.report.b.a((java.lang.String) r10, (android.content.Context) r3, (java.lang.String) r2)
        L_0x00e8:
            android.os.Handler r10 = r9.w
            com.mbridge.msdk.foundation.same.e.a r2 = r9.x
            long r3 = r9.u
            r10.postDelayed(r2, r3)
            com.mbridge.msdk.foundation.entity.CampaignEx r10 = r9.e
            java.lang.String r4 = r9.b((com.mbridge.msdk.foundation.entity.CampaignEx) r10)
            boolean r10 = android.text.TextUtils.isEmpty(r4)
            r8 = 2
            if (r10 != 0) goto L_0x01c8
            com.mbridge.msdk.out.MBBannerView r10 = r9.f
            if (r10 == 0) goto L_0x01bd
            com.mbridge.msdk.mbbanner.view.MBBannerWebView r10 = r9.h
            if (r10 != 0) goto L_0x0130
            com.mbridge.msdk.mbbanner.view.MBBannerWebView r10 = new com.mbridge.msdk.mbbanner.view.MBBannerWebView
            com.mbridge.msdk.foundation.controller.a r2 = com.mbridge.msdk.foundation.controller.a.e()
            android.content.Context r2 = r2.g()
            r10.<init>(r2)
            r9.h = r10
            com.mbridge.msdk.mbbanner.view.MBBannerWebView r10 = r9.h
            android.widget.RelativeLayout$LayoutParams r2 = new android.widget.RelativeLayout$LayoutParams
            r3 = -1
            r2.<init>(r3, r3)
            r10.setLayoutParams(r2)
            com.mbridge.msdk.mbbanner.view.MBBannerWebView r10 = r9.h
            com.mbridge.msdk.mbbanner.view.a r2 = new com.mbridge.msdk.mbbanner.view.a
            java.lang.String r3 = r9.q
            java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx> r5 = r9.s
            com.mbridge.msdk.mbbanner.common.b.a r6 = r9.B
            r2.<init>(r3, r5, r6)
            r10.setWebViewClient(r2)
        L_0x0130:
            android.widget.ImageView r10 = r9.g
            if (r10 == 0) goto L_0x0137
            r10.setVisibility(r1)
        L_0x0137:
            com.mbridge.msdk.mbbanner.view.MBBannerWebView r10 = r9.h
            int r10 = r10.getVisibility()
            if (r10 == 0) goto L_0x0144
            com.mbridge.msdk.mbbanner.view.MBBannerWebView r10 = r9.h
            r10.setVisibility(r0)
        L_0x0144:
            com.mbridge.msdk.mbbanner.view.MBBannerWebView r10 = r9.h
            android.view.ViewParent r10 = r10.getParent()
            if (r10 != 0) goto L_0x0153
            com.mbridge.msdk.out.MBBannerView r10 = r9.f
            com.mbridge.msdk.mbbanner.view.MBBannerWebView r0 = r9.h
            r10.addView(r0)
        L_0x0153:
            com.mbridge.msdk.foundation.entity.CampaignEx r10 = r9.e
            boolean r10 = r10.isMraid()
            r9.d((boolean) r10)
            com.mbridge.msdk.foundation.b.b r10 = com.mbridge.msdk.foundation.b.b.a()
            java.lang.String r0 = r9.q
            com.mbridge.msdk.foundation.entity.CampaignEx r1 = r9.e
            r10.a((java.lang.String) r0, (com.mbridge.msdk.foundation.entity.CampaignEx) r1)
            r9.f()
            com.mbridge.msdk.mbbanner.common.bridge.a r10 = new com.mbridge.msdk.mbbanner.common.bridge.a
            com.mbridge.msdk.out.MBBannerView r0 = r9.f
            android.content.Context r0 = r0.getContext()
            java.lang.String r1 = r9.r
            java.lang.String r2 = r9.q
            r10.<init>(r0, r1, r2)
            r9.v = r10
            com.mbridge.msdk.mbbanner.common.bridge.a r10 = r9.v
            java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx> r0 = r9.s
            r10.a((java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx>) r0)
            com.mbridge.msdk.mbbanner.common.bridge.a r10 = r9.v
            com.mbridge.msdk.mbbanner.common.b.a r0 = r9.B
            r10.a((com.mbridge.msdk.mbbanner.common.b.a) r0)
            com.mbridge.msdk.mbbanner.common.bridge.a r10 = r9.v
            int r0 = r9.t
            r10.a((int) r0)
            com.mbridge.msdk.mbbanner.view.MBBannerWebView r10 = r9.h
            com.mbridge.msdk.mbsignalcommon.b.b r0 = r9.C
            r10.setWebViewListener(r0)
            com.mbridge.msdk.mbbanner.view.MBBannerWebView r10 = r9.h
            com.mbridge.msdk.mbbanner.common.bridge.a r0 = r9.v
            r10.setObject(r0)
            java.lang.String r10 = "file"
            boolean r10 = r4.startsWith(r10)
            if (r10 != 0) goto L_0x01b7
            com.mbridge.msdk.mbbanner.view.MBBannerWebView r2 = r9.h
            com.mbridge.msdk.foundation.entity.CampaignEx r10 = r9.e
            java.lang.String r3 = r10.getBannerUrl()
            r7 = 0
            java.lang.String r5 = "text/html"
            java.lang.String r6 = "utf-8"
            r2.loadDataWithBaseURL(r3, r4, r5, r6, r7)
            goto L_0x01c7
        L_0x01b7:
            com.mbridge.msdk.mbbanner.view.MBBannerWebView r10 = r9.h
            r10.loadUrl(r4)
            goto L_0x01c7
        L_0x01bd:
            java.lang.String r10 = "banner render failed because banner view is null"
            r9.a((java.lang.String) r10, (int) r8)
            java.lang.String r10 = "banner show failed because banner view is exception"
            r9.a((java.lang.String) r10)
        L_0x01c7:
            r0 = 1
        L_0x01c8:
            if (r0 != 0) goto L_0x01ea
            com.mbridge.msdk.foundation.entity.CampaignEx r10 = r9.e
            java.lang.String r10 = r10.getBannerHtml()
            boolean r10 = android.text.TextUtils.isEmpty(r10)
            if (r10 == 0) goto L_0x01e2
            com.mbridge.msdk.foundation.entity.CampaignEx r10 = r9.e
            java.lang.String r10 = r10.getBannerUrl()
            boolean r10 = android.text.TextUtils.isEmpty(r10)
            if (r10 != 0) goto L_0x01e7
        L_0x01e2:
            java.lang.String r10 = "banner render failed because res load failed"
            r9.a((java.lang.String) r10, (int) r8)
        L_0x01e7:
            r9.c()
        L_0x01ea:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.mbbanner.common.c.c.a(com.mbridge.msdk.foundation.entity.CampaignUnit):void");
    }

    static /* synthetic */ void b(c cVar) {
        MBBannerWebView mBBannerWebView = cVar.h;
        if (!(mBBannerWebView == null || mBBannerWebView.getParent() == null)) {
            cVar.f.removeView(cVar.h);
        }
        ImageView imageView = cVar.g;
        if (!(imageView == null || imageView.getParent() == null)) {
            cVar.g.setVisibility(8);
            cVar.f.removeView(cVar.g);
        }
        ImageView imageView2 = cVar.i;
        if (!(imageView2 == null || imageView2.getParent() == null)) {
            cVar.f.removeView(cVar.i);
            cVar.i.setVisibility(8);
        }
        com.mbridge.msdk.mbbanner.common.a.a c2 = com.mbridge.msdk.mbbanner.common.a.a.a().b(cVar.q).e(cVar.e.getRequestId()).d(cVar.e.getRequestIdNotice()).c(cVar.e.getId());
        com.mbridge.msdk.mbbanner.common.a.a a2 = c2.f(cVar.e.getCreativeId() + "").a(cVar.e.isBidCampaign());
        String str = cVar.q;
        if (a2 != null) {
            a2.a("2000069");
            if (com.mbridge.msdk.foundation.same.report.a.a().c()) {
                com.mbridge.msdk.foundation.same.report.a.a().a(a2.b());
            } else {
                com.mbridge.msdk.foundation.same.report.b.a(a2.b(), com.mbridge.msdk.foundation.controller.a.e().g(), str);
            }
        }
        BannerUtils.inserCloseId(cVar.q, cVar.s);
        com.mbridge.msdk.mbbanner.common.b.c cVar2 = cVar.c;
        if (cVar2 != null) {
            cVar2.e();
        }
    }

    static /* synthetic */ void c(c cVar) {
        ImageView imageView;
        if (cVar.d && (imageView = cVar.i) != null && imageView.getVisibility() == 0) {
            cVar.i.setVisibility(8);
            cVar.i.setOnClickListener((View.OnClickListener) null);
            if (cVar.f != null && cVar.i.getParent() != null) {
                cVar.f.removeView(cVar.i);
            }
        }
    }

    static /* synthetic */ void m(c cVar) {
        if (cVar.g != null) {
            MBBannerWebView mBBannerWebView = cVar.h;
            if (mBBannerWebView != null) {
                mBBannerWebView.setVisibility(8);
            }
            if (cVar.g.getVisibility() != 0) {
                cVar.g.setVisibility(0);
            }
            if (cVar.f != null) {
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
                layoutParams.addRule(10);
                cVar.g.setScaleType(ImageView.ScaleType.FIT_XY);
                if (cVar.g.getParent() == null) {
                    cVar.f.addView(cVar.g, layoutParams);
                }
                cVar.d(true);
            }
        }
    }
}
