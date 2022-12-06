package com.mbridge.msdk.click;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.b.b;
import com.mbridge.msdk.click.CommonJumpLoader;
import com.mbridge.msdk.foundation.db.g;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.d;
import com.mbridge.msdk.foundation.same.report.c;
import com.mbridge.msdk.foundation.tools.m;
import com.mbridge.msdk.foundation.tools.q;
import com.mbridge.msdk.foundation.tools.t;
import com.mbridge.msdk.foundation.tools.x;
import com.mbridge.msdk.out.Campaign;
import com.mbridge.msdk.out.Frame;
import com.mbridge.msdk.out.LoadingActivity;
import com.mbridge.msdk.out.NativeListener;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* compiled from: CommonClickControl */
public final class a {
    public static boolean a = false;
    public static Map<String, Long> b = new HashMap();
    public static Set<String> c = new HashSet();
    /* access modifiers changed from: private */
    public String d;
    private long e;
    /* access modifiers changed from: private */
    public g f = null;
    private Context g = null;
    private CommonJumpLoader h;
    /* access modifiers changed from: private */
    public NativeListener.NativeTrackingListener i = null;
    private c j;
    private com.mbridge.msdk.b.a k;
    private boolean l;
    /* access modifiers changed from: private */
    public boolean m = false;
    private boolean n = true;
    /* access modifiers changed from: private */
    public boolean o;

    public a(Context context, String str) {
        this.k = b.a().b(str);
        if (this.k == null) {
            this.k = b.a().b();
        }
        this.l = this.k.y();
        this.g = context.getApplicationContext();
        this.d = str;
        if (this.f == null) {
            this.f = g.a(this.g);
        }
        this.j = new c(this.g);
    }

    public final void a(String str) {
        this.d = str;
    }

    public final void a(NativeListener.NativeTrackingListener nativeTrackingListener) {
        this.i = nativeTrackingListener;
    }

    public final void a(boolean z) {
        this.n = z;
    }

    public final void a() {
        try {
            this.i = null;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final void a(CampaignEx campaignEx, NativeListener.NativeAdListener nativeAdListener) {
        if (!(nativeAdListener == null || campaignEx == null)) {
            nativeAdListener.onAdClick(campaignEx);
        }
        a(campaignEx);
    }

    private boolean b(CampaignEx campaignEx) {
        Long l2;
        if (campaignEx == null) {
            return true;
        }
        try {
            if (2 != campaignEx.getLinkType() && 3 != campaignEx.getLinkType()) {
                return true;
            }
            String id = campaignEx.getId();
            if (b == null) {
                return true;
            }
            if (b.containsKey(id) && (l2 = b.get(id)) != null) {
                if (l2.longValue() > System.currentTimeMillis() || c.contains(campaignEx.getId())) {
                    return false;
                }
            }
            b.put(campaignEx.getId(), Long.valueOf(System.currentTimeMillis() + ((long) (campaignEx.getClickTimeOutInterval() * 1000))));
            return true;
        } catch (Exception e2) {
            if (!MBridgeConstans.DEBUG) {
                return true;
            }
            e2.printStackTrace();
            return true;
        }
    }

    private void a(CampaignEx campaignEx, String str) {
        if (!TextUtils.isEmpty(str)) {
            a(this.g, campaignEx, this.d, str, true, false);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:36:0x00d5 A[Catch:{ all -> 0x01c8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x0142 A[Catch:{ all -> 0x01c8 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(com.mbridge.msdk.foundation.entity.CampaignEx r12) {
        /*
            r11 = this;
            boolean r0 = r11.b((com.mbridge.msdk.foundation.entity.CampaignEx) r12)     // Catch:{ all -> 0x01c8 }
            if (r0 != 0) goto L_0x0007
            return
        L_0x0007:
            java.lang.String r0 = r12.getNoticeUrl()     // Catch:{ all -> 0x01c8 }
            com.mbridge.msdk.foundation.db.g r1 = r11.f     // Catch:{ all -> 0x01c8 }
            com.mbridge.msdk.foundation.db.c r1 = com.mbridge.msdk.foundation.db.c.a(r1)     // Catch:{ all -> 0x01c8 }
            r1.a()     // Catch:{ all -> 0x01c8 }
            java.lang.String r2 = r12.getId()     // Catch:{ all -> 0x01c8 }
            java.lang.String r3 = r11.d     // Catch:{ all -> 0x01c8 }
            com.mbridge.msdk.click.CommonJumpLoader$JumpLoaderResult r2 = r1.b(r2, r3)     // Catch:{ all -> 0x01c8 }
            if (r2 == 0) goto L_0x0032
            java.lang.String r3 = r2.getNoticeurl()     // Catch:{ all -> 0x01c8 }
            if (r3 == 0) goto L_0x002a
            r3 = 0
            r2.setNoticeurl(r3)     // Catch:{ all -> 0x01c8 }
        L_0x002a:
            r12.setJumpResult(r2)     // Catch:{ all -> 0x01c8 }
            java.lang.String r3 = r11.d     // Catch:{ all -> 0x01c8 }
            r1.a((com.mbridge.msdk.foundation.entity.CampaignEx) r12, (java.lang.String) r3)     // Catch:{ all -> 0x01c8 }
        L_0x0032:
            boolean r1 = com.mbridge.msdk.foundation.tools.u.a((com.mbridge.msdk.foundation.entity.CampaignEx) r12)     // Catch:{ all -> 0x01c8 }
            if (r1 == 0) goto L_0x0078
            com.mbridge.msdk.foundation.tools.i r1 = com.mbridge.msdk.foundation.tools.i.a()     // Catch:{ all -> 0x01c8 }
            r1.a((com.mbridge.msdk.foundation.entity.CampaignEx) r12)     // Catch:{ all -> 0x01c8 }
            android.content.Context r1 = r11.g     // Catch:{ all -> 0x01c8 }
            java.lang.String r3 = r12.getDeepLinkURL()     // Catch:{ all -> 0x01c8 }
            boolean r1 = com.mbridge.msdk.click.b.d(r1, r3)     // Catch:{ all -> 0x01c8 }
            if (r1 == 0) goto L_0x0060
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x01c8 }
            r1.<init>()     // Catch:{ all -> 0x01c8 }
            r1.append(r0)     // Catch:{ all -> 0x01c8 }
            java.lang.String r0 = "&opdptype=1"
            r1.append(r0)     // Catch:{ all -> 0x01c8 }
            java.lang.String r0 = r1.toString()     // Catch:{ all -> 0x01c8 }
            r11.a((com.mbridge.msdk.foundation.entity.CampaignEx) r12, (java.lang.String) r0)     // Catch:{ all -> 0x01c8 }
            return
        L_0x0060:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x01c8 }
            r1.<init>()     // Catch:{ all -> 0x01c8 }
            r1.append(r0)     // Catch:{ all -> 0x01c8 }
            java.lang.String r0 = "&opdptype=0"
            r1.append(r0)     // Catch:{ all -> 0x01c8 }
            java.lang.String r0 = r1.toString()     // Catch:{ all -> 0x01c8 }
            com.mbridge.msdk.foundation.tools.i r1 = com.mbridge.msdk.foundation.tools.i.a()     // Catch:{ all -> 0x01c8 }
            r1.b((com.mbridge.msdk.foundation.entity.CampaignEx) r12)     // Catch:{ all -> 0x01c8 }
        L_0x0078:
            r11.a((com.mbridge.msdk.foundation.entity.CampaignEx) r12, (java.lang.String) r0)     // Catch:{ all -> 0x01c8 }
            boolean r0 = r12.getUserActivation()     // Catch:{ all -> 0x01c8 }
            r1 = 1
            if (r0 != 0) goto L_0x00ba
            android.content.Context r0 = r11.g     // Catch:{ all -> 0x01c8 }
            java.lang.String r3 = r12.getPackageName()     // Catch:{ all -> 0x01c8 }
            boolean r0 = com.mbridge.msdk.click.b.c(r0, r3)     // Catch:{ all -> 0x01c8 }
            if (r0 == 0) goto L_0x00ba
            android.content.Context r0 = r11.g     // Catch:{ all -> 0x01c8 }
            java.lang.String r2 = r12.getPackageName()     // Catch:{ all -> 0x01c8 }
            com.mbridge.msdk.click.b.e(r0, r2)     // Catch:{ all -> 0x01c8 }
            com.mbridge.msdk.out.NativeListener$NativeTrackingListener r0 = r11.i     // Catch:{ all -> 0x01c8 }
            if (r0 == 0) goto L_0x00a4
            com.mbridge.msdk.out.NativeListener$NativeTrackingListener r0 = r11.i     // Catch:{ all -> 0x01c8 }
            java.lang.String r2 = r12.getClickURL()     // Catch:{ all -> 0x01c8 }
            r0.onStartRedirection(r12, r2)     // Catch:{ all -> 0x01c8 }
        L_0x00a4:
            r11.a((com.mbridge.msdk.foundation.entity.CampaignEx) r12, (boolean) r1)     // Catch:{ all -> 0x01c8 }
            com.mbridge.msdk.out.NativeListener$NativeTrackingListener r0 = r11.i     // Catch:{ all -> 0x01c8 }
            if (r0 == 0) goto L_0x00b9
            com.mbridge.msdk.out.NativeListener$NativeTrackingListener r0 = r11.i     // Catch:{ all -> 0x01c8 }
            java.lang.String r1 = r12.getClickURL()     // Catch:{ all -> 0x01c8 }
            r0.onFinishRedirection(r12, r1)     // Catch:{ all -> 0x01c8 }
            com.mbridge.msdk.out.NativeListener$NativeTrackingListener r12 = r11.i     // Catch:{ all -> 0x01c8 }
            com.mbridge.msdk.foundation.tools.t.a((com.mbridge.msdk.out.NativeListener.NativeTrackingListener) r12)     // Catch:{ all -> 0x01c8 }
        L_0x00b9:
            return
        L_0x00ba:
            int r0 = r12.getLinkType()     // Catch:{ all -> 0x01c8 }
            int r3 = r11.b()     // Catch:{ all -> 0x01c8 }
            r4 = 4
            r5 = 9
            r6 = 8
            r7 = 0
            if (r0 == r6) goto L_0x00d1
            if (r0 == r5) goto L_0x00d1
            if (r0 != r4) goto L_0x00cf
            goto L_0x00d1
        L_0x00cf:
            r8 = r7
            goto L_0x00d2
        L_0x00d1:
            r8 = r1
        L_0x00d2:
            r9 = 2
            if (r8 == 0) goto L_0x0142
            java.lang.String r8 = r12.getClickURL()     // Catch:{ all -> 0x01c8 }
            com.mbridge.msdk.out.NativeListener$NativeTrackingListener r10 = r11.i     // Catch:{ all -> 0x01c8 }
            if (r10 == 0) goto L_0x00e2
            com.mbridge.msdk.out.NativeListener$NativeTrackingListener r10 = r11.i     // Catch:{ all -> 0x01c8 }
            r10.onStartRedirection(r12, r8)     // Catch:{ all -> 0x01c8 }
        L_0x00e2:
            boolean r10 = android.text.TextUtils.isEmpty(r8)     // Catch:{ all -> 0x01c8 }
            if (r10 == 0) goto L_0x00f5
            com.mbridge.msdk.out.NativeListener$NativeTrackingListener r0 = r11.i     // Catch:{ all -> 0x01c8 }
            if (r0 == 0) goto L_0x00f1
            com.mbridge.msdk.out.NativeListener$NativeTrackingListener r0 = r11.i     // Catch:{ all -> 0x01c8 }
            r0.onRedirectionFailed(r12, r8)     // Catch:{ all -> 0x01c8 }
        L_0x00f1:
            r11.a((com.mbridge.msdk.click.CommonJumpLoader.JumpLoaderResult) r2, (com.mbridge.msdk.foundation.entity.CampaignEx) r12, (boolean) r1)     // Catch:{ all -> 0x01c8 }
            return
        L_0x00f5:
            if (r0 != r6) goto L_0x010b
            android.content.Context r0 = r11.g     // Catch:{ all -> 0x01c8 }
            com.mbridge.msdk.out.NativeListener$NativeTrackingListener r1 = r11.i     // Catch:{ all -> 0x01c8 }
            com.mbridge.msdk.foundation.tools.t.a(r0, r8, r12, r1)     // Catch:{ all -> 0x01c8 }
            r11.a((com.mbridge.msdk.click.CommonJumpLoader.JumpLoaderResult) r2, (com.mbridge.msdk.foundation.entity.CampaignEx) r12, (boolean) r7)     // Catch:{ all -> 0x01c8 }
            com.mbridge.msdk.out.NativeListener$NativeTrackingListener r0 = r11.i     // Catch:{ all -> 0x01c8 }
            if (r0 == 0) goto L_0x010a
            com.mbridge.msdk.out.NativeListener$NativeTrackingListener r0 = r11.i     // Catch:{ all -> 0x01c8 }
            r0.onFinishRedirection(r12, r8)     // Catch:{ all -> 0x01c8 }
        L_0x010a:
            return
        L_0x010b:
            if (r0 != r5) goto L_0x0121
            android.content.Context r0 = r11.g     // Catch:{ all -> 0x01c8 }
            com.mbridge.msdk.out.NativeListener$NativeTrackingListener r1 = r11.i     // Catch:{ all -> 0x01c8 }
            com.mbridge.msdk.foundation.tools.t.b(r0, r8, r1)     // Catch:{ all -> 0x01c8 }
            r11.a((com.mbridge.msdk.click.CommonJumpLoader.JumpLoaderResult) r2, (com.mbridge.msdk.foundation.entity.CampaignEx) r12, (boolean) r7)     // Catch:{ all -> 0x01c8 }
            com.mbridge.msdk.out.NativeListener$NativeTrackingListener r0 = r11.i     // Catch:{ all -> 0x01c8 }
            if (r0 == 0) goto L_0x0120
            com.mbridge.msdk.out.NativeListener$NativeTrackingListener r0 = r11.i     // Catch:{ all -> 0x01c8 }
            r0.onFinishRedirection(r12, r8)     // Catch:{ all -> 0x01c8 }
        L_0x0120:
            return
        L_0x0121:
            if (r0 != r4) goto L_0x0134
            if (r3 != r9) goto L_0x012d
            android.content.Context r0 = r11.g     // Catch:{ all -> 0x01c8 }
            com.mbridge.msdk.out.NativeListener$NativeTrackingListener r1 = r11.i     // Catch:{ all -> 0x01c8 }
            com.mbridge.msdk.foundation.tools.t.a(r0, r8, r12, r1)     // Catch:{ all -> 0x01c8 }
            goto L_0x0134
        L_0x012d:
            android.content.Context r0 = r11.g     // Catch:{ all -> 0x01c8 }
            com.mbridge.msdk.out.NativeListener$NativeTrackingListener r1 = r11.i     // Catch:{ all -> 0x01c8 }
            com.mbridge.msdk.foundation.tools.t.b(r0, r8, r1)     // Catch:{ all -> 0x01c8 }
        L_0x0134:
            com.mbridge.msdk.out.NativeListener$NativeTrackingListener r0 = r11.i     // Catch:{ all -> 0x01c8 }
            if (r0 == 0) goto L_0x013d
            com.mbridge.msdk.out.NativeListener$NativeTrackingListener r0 = r11.i     // Catch:{ all -> 0x01c8 }
            r0.onFinishRedirection(r12, r8)     // Catch:{ all -> 0x01c8 }
        L_0x013d:
            r11.a((com.mbridge.msdk.click.CommonJumpLoader.JumpLoaderResult) r2, (com.mbridge.msdk.foundation.entity.CampaignEx) r12, (boolean) r7)     // Catch:{ all -> 0x01c8 }
            goto L_0x01d2
        L_0x0142:
            if (r0 != r9) goto L_0x0196
            java.lang.String r0 = r12.getClickURL()     // Catch:{ all -> 0x01c8 }
            java.lang.String r1 = "market://"
            boolean r0 = r0.startsWith(r1)     // Catch:{ all -> 0x01c8 }
            if (r0 != 0) goto L_0x0161
            java.lang.String r0 = r12.getClickURL()     // Catch:{ all -> 0x01c8 }
            java.lang.String r1 = "https://play.google.com/"
            boolean r0 = r0.startsWith(r1)     // Catch:{ all -> 0x01c8 }
            if (r0 == 0) goto L_0x015d
            goto L_0x0161
        L_0x015d:
            r11.a((com.mbridge.msdk.foundation.entity.CampaignEx) r12, (boolean) r7)     // Catch:{ all -> 0x01c8 }
            goto L_0x01d2
        L_0x0161:
            com.mbridge.msdk.out.NativeListener$NativeTrackingListener r0 = r11.i     // Catch:{ all -> 0x01c8 }
            if (r0 == 0) goto L_0x016e
            com.mbridge.msdk.out.NativeListener$NativeTrackingListener r0 = r11.i     // Catch:{ all -> 0x01c8 }
            java.lang.String r1 = r12.getClickURL()     // Catch:{ all -> 0x01c8 }
            r0.onStartRedirection(r12, r1)     // Catch:{ all -> 0x01c8 }
        L_0x016e:
            android.content.Context r0 = r11.g     // Catch:{ all -> 0x01c8 }
            java.lang.String r1 = r12.getClickURL()     // Catch:{ all -> 0x01c8 }
            com.mbridge.msdk.out.NativeListener$NativeTrackingListener r4 = r11.i     // Catch:{ all -> 0x01c8 }
            boolean r0 = com.mbridge.msdk.foundation.tools.t.a.a(r0, r1, r4)     // Catch:{ all -> 0x01c8 }
            if (r0 != 0) goto L_0x0185
            java.lang.String r0 = r12.getClickURL()     // Catch:{ all -> 0x01c8 }
            com.mbridge.msdk.out.NativeListener$NativeTrackingListener r1 = r11.i     // Catch:{ all -> 0x01c8 }
            r11.a((int) r3, (java.lang.String) r0, (com.mbridge.msdk.foundation.entity.CampaignEx) r12, (com.mbridge.msdk.out.NativeListener.NativeTrackingListener) r1)     // Catch:{ all -> 0x01c8 }
        L_0x0185:
            r11.a((com.mbridge.msdk.click.CommonJumpLoader.JumpLoaderResult) r2, (com.mbridge.msdk.foundation.entity.CampaignEx) r12, (boolean) r7)     // Catch:{ all -> 0x01c8 }
            com.mbridge.msdk.out.NativeListener$NativeTrackingListener r0 = r11.i     // Catch:{ all -> 0x01c8 }
            if (r0 == 0) goto L_0x0195
            com.mbridge.msdk.out.NativeListener$NativeTrackingListener r0 = r11.i     // Catch:{ all -> 0x01c8 }
            java.lang.String r1 = r12.getClickURL()     // Catch:{ all -> 0x01c8 }
            r0.onFinishRedirection(r12, r1)     // Catch:{ all -> 0x01c8 }
        L_0x0195:
            return
        L_0x0196:
            r3 = 3
            if (r0 != r3) goto L_0x019d
            r11.a((com.mbridge.msdk.foundation.entity.CampaignEx) r12, (boolean) r7)     // Catch:{ all -> 0x01c8 }
            goto L_0x01d2
        L_0x019d:
            java.lang.String r0 = r12.getClickURL()     // Catch:{ all -> 0x01c8 }
            boolean r3 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x01c8 }
            if (r3 == 0) goto L_0x01b4
            com.mbridge.msdk.out.NativeListener$NativeTrackingListener r3 = r11.i     // Catch:{ all -> 0x01c8 }
            if (r3 == 0) goto L_0x01b0
            com.mbridge.msdk.out.NativeListener$NativeTrackingListener r3 = r11.i     // Catch:{ all -> 0x01c8 }
            r3.onRedirectionFailed(r12, r0)     // Catch:{ all -> 0x01c8 }
        L_0x01b0:
            r11.a((com.mbridge.msdk.click.CommonJumpLoader.JumpLoaderResult) r2, (com.mbridge.msdk.foundation.entity.CampaignEx) r12, (boolean) r1)     // Catch:{ all -> 0x01c8 }
            return
        L_0x01b4:
            com.mbridge.msdk.out.NativeListener$NativeTrackingListener r3 = r11.i     // Catch:{ all -> 0x01c8 }
            if (r3 == 0) goto L_0x01bd
            com.mbridge.msdk.out.NativeListener$NativeTrackingListener r3 = r11.i     // Catch:{ all -> 0x01c8 }
            r3.onFinishRedirection(r12, r0)     // Catch:{ all -> 0x01c8 }
        L_0x01bd:
            android.content.Context r3 = r11.g     // Catch:{ all -> 0x01c8 }
            com.mbridge.msdk.out.NativeListener$NativeTrackingListener r4 = r11.i     // Catch:{ all -> 0x01c8 }
            com.mbridge.msdk.foundation.tools.t.b(r3, r0, r4)     // Catch:{ all -> 0x01c8 }
            r11.a((com.mbridge.msdk.click.CommonJumpLoader.JumpLoaderResult) r2, (com.mbridge.msdk.foundation.entity.CampaignEx) r12, (boolean) r1)     // Catch:{ all -> 0x01c8 }
            goto L_0x01d2
        L_0x01c8:
            r12 = move-exception
            java.lang.String r0 = r12.getMessage()
            java.lang.String r1 = "MBridge SDK M"
            com.mbridge.msdk.foundation.tools.q.a(r1, r0, r12)
        L_0x01d2:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.click.a.a(com.mbridge.msdk.foundation.entity.CampaignEx):void");
    }

    public static void a(Context context, CampaignEx campaignEx, String str, String str2, boolean z, boolean z2) {
        if (context != null) {
            new CommonJumpLoader(context.getApplicationContext()).a(str, campaignEx, new d() {
                public final void a(Object obj) {
                }

                public final void a(Object obj, String str) {
                }

                public final void b(Object obj) {
                }
            }, str2, z, z2);
        }
    }

    public static void a(Context context, CampaignEx campaignEx, String str, String[] strArr, boolean z, boolean z2) {
        if (context != null && campaignEx != null && !TextUtils.isEmpty(str) && strArr != null) {
            CommonJumpLoader commonJumpLoader = new CommonJumpLoader(context.getApplicationContext());
            for (String a2 : strArr) {
                commonJumpLoader.a(str, campaignEx, new d() {
                    public final void a(Object obj) {
                    }

                    public final void a(Object obj, String str) {
                    }

                    public final void b(Object obj) {
                    }
                }, a2, z, z2);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:39:0x00e4 A[Catch:{ Exception -> 0x012f }] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00f9 A[Catch:{ Exception -> 0x012f }] */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x010c A[Catch:{ Exception -> 0x012f }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(final com.mbridge.msdk.foundation.entity.CampaignEx r8, final boolean r9) {
        /*
            r7 = this;
            long r0 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x012f }
            r7.e = r0     // Catch:{ Exception -> 0x012f }
            com.mbridge.msdk.out.NativeListener$NativeTrackingListener r0 = r7.i     // Catch:{ Exception -> 0x012f }
            r1 = 1
            if (r0 == 0) goto L_0x001e
            if (r9 != 0) goto L_0x001e
            com.mbridge.msdk.out.NativeListener$NativeTrackingListener r0 = r7.i     // Catch:{ Exception -> 0x012f }
            java.lang.String r2 = r8.getClickURL()     // Catch:{ Exception -> 0x012f }
            r0.onStartRedirection(r8, r2)     // Catch:{ Exception -> 0x012f }
            com.mbridge.msdk.out.NativeListener$NativeTrackingListener r0 = r7.i     // Catch:{ Exception -> 0x012f }
            boolean r0 = r0.onInterceptDefaultLoadingDialog()     // Catch:{ Exception -> 0x012f }
            r0 = r0 ^ r1
            goto L_0x001f
        L_0x001e:
            r0 = r1
        L_0x001f:
            r2 = 0
            r7.o = r2     // Catch:{ Exception -> 0x012f }
            com.mbridge.msdk.click.CommonJumpLoader$JumpLoaderResult r3 = r8.getJumpResult()     // Catch:{ Exception -> 0x012f }
            if (r3 == 0) goto L_0x0039
            if (r9 != 0) goto L_0x0033
            com.mbridge.msdk.click.CommonJumpLoader$JumpLoaderResult r3 = r8.getJumpResult()     // Catch:{ Exception -> 0x012f }
            boolean r4 = r7.m     // Catch:{ Exception -> 0x012f }
            r7.a((com.mbridge.msdk.foundation.entity.CampaignEx) r8, (com.mbridge.msdk.click.CommonJumpLoader.JumpLoaderResult) r3, (boolean) r1, (boolean) r4)     // Catch:{ Exception -> 0x012f }
        L_0x0033:
            r7.o = r1     // Catch:{ Exception -> 0x012f }
            r7.m = r2     // Catch:{ Exception -> 0x012f }
            r3 = r2
            goto L_0x003a
        L_0x0039:
            r3 = r1
        L_0x003a:
            com.mbridge.msdk.foundation.db.g r4 = r7.f     // Catch:{ Exception -> 0x012f }
            com.mbridge.msdk.foundation.db.c r4 = com.mbridge.msdk.foundation.db.c.a(r4)     // Catch:{ Exception -> 0x012f }
            java.lang.String r5 = r8.getId()     // Catch:{ Exception -> 0x012f }
            java.lang.String r6 = r7.d     // Catch:{ Exception -> 0x012f }
            boolean r4 = r4.a((java.lang.String) r5, (java.lang.String) r6)     // Catch:{ Exception -> 0x012f }
            if (r4 == 0) goto L_0x0052
            com.mbridge.msdk.click.CommonJumpLoader$JumpLoaderResult r4 = r8.getJumpResult()     // Catch:{ Exception -> 0x012f }
            if (r4 != 0) goto L_0x0133
        L_0x0052:
            com.mbridge.msdk.foundation.db.g r4 = r7.f     // Catch:{ Exception -> 0x012f }
            com.mbridge.msdk.foundation.db.c r4 = com.mbridge.msdk.foundation.db.c.a(r4)     // Catch:{ Exception -> 0x012f }
            r4.a()     // Catch:{ Exception -> 0x012f }
            java.lang.String r5 = r8.getId()     // Catch:{ Exception -> 0x012f }
            java.lang.String r6 = r7.d     // Catch:{ Exception -> 0x012f }
            com.mbridge.msdk.click.CommonJumpLoader$JumpLoaderResult r4 = r4.b(r5, r6)     // Catch:{ Exception -> 0x012f }
            if (r4 == 0) goto L_0x007a
            if (r9 != 0) goto L_0x007a
            r8.setJumpResult(r4)     // Catch:{ Exception -> 0x012f }
            if (r3 == 0) goto L_0x0078
            boolean r5 = r7.m     // Catch:{ Exception -> 0x012f }
            r7.a((com.mbridge.msdk.foundation.entity.CampaignEx) r8, (com.mbridge.msdk.click.CommonJumpLoader.JumpLoaderResult) r4, (boolean) r3, (boolean) r5)     // Catch:{ Exception -> 0x012f }
            r7.o = r1     // Catch:{ Exception -> 0x012f }
            r7.m = r2     // Catch:{ Exception -> 0x012f }
            goto L_0x00cf
        L_0x0078:
            r2 = r3
            goto L_0x00cf
        L_0x007a:
            java.lang.String r4 = r8.getClick_mode()     // Catch:{ Exception -> 0x012f }
            java.lang.String r5 = "6"
            boolean r4 = r4.equals(r5)     // Catch:{ Exception -> 0x012f }
            if (r4 == 0) goto L_0x00c9
            java.lang.String r4 = r8.getPackageName()     // Catch:{ Exception -> 0x012f }
            boolean r4 = r4.isEmpty()     // Catch:{ Exception -> 0x012f }
            if (r4 != 0) goto L_0x00c9
            int r4 = r8.getLinkType()     // Catch:{ Exception -> 0x012f }
            r5 = 2
            if (r4 != r5) goto L_0x00c9
            if (r9 != 0) goto L_0x00c9
            android.content.Context r4 = r7.g     // Catch:{ Exception -> 0x012f }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x012f }
            r5.<init>()     // Catch:{ Exception -> 0x012f }
            java.lang.String r6 = "market://details?id="
            r5.append(r6)     // Catch:{ Exception -> 0x012f }
            java.lang.String r6 = r8.getPackageName()     // Catch:{ Exception -> 0x012f }
            r5.append(r6)     // Catch:{ Exception -> 0x012f }
            java.lang.String r5 = r5.toString()     // Catch:{ Exception -> 0x012f }
            com.mbridge.msdk.out.NativeListener$NativeTrackingListener r6 = r7.i     // Catch:{ Exception -> 0x012f }
            com.mbridge.msdk.foundation.tools.t.a.a(r4, r5, r6)     // Catch:{ Exception -> 0x012f }
            com.mbridge.msdk.out.NativeListener$NativeTrackingListener r4 = r7.i     // Catch:{ Exception -> 0x012f }
            if (r4 == 0) goto L_0x00c6
            if (r3 == 0) goto L_0x00c6
            com.mbridge.msdk.out.NativeListener$NativeTrackingListener r3 = r7.i     // Catch:{ Exception -> 0x012f }
            r3.onDismissLoading(r8)     // Catch:{ Exception -> 0x012f }
            com.mbridge.msdk.out.NativeListener$NativeTrackingListener r3 = r7.i     // Catch:{ Exception -> 0x012f }
            r4 = 0
            r3.onFinishRedirection(r8, r4)     // Catch:{ Exception -> 0x012f }
        L_0x00c6:
            r7.o = r1     // Catch:{ Exception -> 0x012f }
            r3 = r2
        L_0x00c9:
            if (r9 == 0) goto L_0x0078
            r7.o = r1     // Catch:{ Exception -> 0x012f }
            r7.m = r2     // Catch:{ Exception -> 0x012f }
        L_0x00cf:
            android.os.Handler r1 = new android.os.Handler     // Catch:{ Exception -> 0x012f }
            android.os.Looper r3 = android.os.Looper.getMainLooper()     // Catch:{ Exception -> 0x012f }
            r1.<init>(r3)     // Catch:{ Exception -> 0x012f }
            com.mbridge.msdk.click.a$3 r3 = new com.mbridge.msdk.click.a$3     // Catch:{ Exception -> 0x012f }
            r3.<init>(r0, r9, r8)     // Catch:{ Exception -> 0x012f }
            r1.post(r3)     // Catch:{ Exception -> 0x012f }
            com.mbridge.msdk.click.CommonJumpLoader r9 = r7.h     // Catch:{ Exception -> 0x012f }
            if (r9 == 0) goto L_0x00e9
            com.mbridge.msdk.click.CommonJumpLoader r9 = r7.h     // Catch:{ Exception -> 0x012f }
            r9.a()     // Catch:{ Exception -> 0x012f }
        L_0x00e9:
            java.util.Set<java.lang.String> r9 = c     // Catch:{ Exception -> 0x012f }
            if (r9 == 0) goto L_0x010c
            java.util.Set<java.lang.String> r9 = c     // Catch:{ Exception -> 0x012f }
            java.lang.String r1 = r8.getId()     // Catch:{ Exception -> 0x012f }
            boolean r9 = r9.contains(r1)     // Catch:{ Exception -> 0x012f }
            if (r9 == 0) goto L_0x010c
            com.mbridge.msdk.out.NativeListener$NativeTrackingListener r9 = r7.i     // Catch:{ Exception -> 0x012f }
            if (r9 == 0) goto L_0x010b
            com.mbridge.msdk.out.NativeListener$NativeTrackingListener r9 = r7.i     // Catch:{ Exception -> 0x012f }
            r9.onDismissLoading(r8)     // Catch:{ Exception -> 0x012f }
            com.mbridge.msdk.out.NativeListener$NativeTrackingListener r9 = r7.i     // Catch:{ Exception -> 0x012f }
            java.lang.String r0 = r8.getClickURL()     // Catch:{ Exception -> 0x012f }
            r9.onFinishRedirection(r8, r0)     // Catch:{ Exception -> 0x012f }
        L_0x010b:
            return
        L_0x010c:
            java.util.Set<java.lang.String> r9 = c     // Catch:{ Exception -> 0x012f }
            if (r9 == 0) goto L_0x0119
            java.util.Set<java.lang.String> r9 = c     // Catch:{ Exception -> 0x012f }
            java.lang.String r1 = r8.getId()     // Catch:{ Exception -> 0x012f }
            r9.add(r1)     // Catch:{ Exception -> 0x012f }
        L_0x0119:
            com.mbridge.msdk.click.CommonJumpLoader r9 = new com.mbridge.msdk.click.CommonJumpLoader     // Catch:{ Exception -> 0x012f }
            android.content.Context r1 = r7.g     // Catch:{ Exception -> 0x012f }
            r9.<init>(r1)     // Catch:{ Exception -> 0x012f }
            r7.h = r9     // Catch:{ Exception -> 0x012f }
            com.mbridge.msdk.click.CommonJumpLoader r9 = r7.h     // Catch:{ Exception -> 0x012f }
            java.lang.String r1 = r7.d     // Catch:{ Exception -> 0x012f }
            com.mbridge.msdk.click.a$4 r3 = new com.mbridge.msdk.click.a$4     // Catch:{ Exception -> 0x012f }
            r3.<init>(r8, r2, r0)     // Catch:{ Exception -> 0x012f }
            r9.a(r1, r8, r3)     // Catch:{ Exception -> 0x012f }
            goto L_0x0133
        L_0x012f:
            r8 = move-exception
            r8.printStackTrace()
        L_0x0133:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.click.a.a(com.mbridge.msdk.foundation.entity.CampaignEx, boolean):void");
    }

    private void a(CommonJumpLoader.JumpLoaderResult jumpLoaderResult, CampaignEx campaignEx, int i2, boolean z) {
        if (campaignEx != null && jumpLoaderResult != null) {
            try {
                long currentTimeMillis = System.currentTimeMillis() - this.e;
                d dVar = new d();
                int n2 = m.n(this.g);
                dVar.a(n2);
                dVar.a(m.a(this.g, n2));
                dVar.j(campaignEx.getRequestId());
                dVar.k(campaignEx.getRequestIdNotice());
                dVar.d(i2);
                dVar.i(currentTimeMillis + "");
                dVar.h(campaignEx.getId());
                dVar.f(jumpLoaderResult.getType());
                if (!TextUtils.isEmpty(jumpLoaderResult.getUrl())) {
                    dVar.g(URLEncoder.encode(jumpLoaderResult.getUrl(), "utf-8"));
                }
                dVar.c((this.e / 1000) + "");
                dVar.b(Integer.parseInt(campaignEx.getLandingType()));
                dVar.c(campaignEx.getLinkType());
                dVar.b(this.d);
                dVar.f(jumpLoaderResult.getType());
                if (!TextUtils.isEmpty(jumpLoaderResult.getUrl())) {
                    dVar.g(URLEncoder.encode(jumpLoaderResult.getUrl(), "utf-8"));
                }
                if (this.l) {
                    dVar.e(jumpLoaderResult.getStatusCode());
                    if (!TextUtils.isEmpty(jumpLoaderResult.getHeader())) {
                        dVar.e(URLEncoder.encode(jumpLoaderResult.getHeader(), "utf-8"));
                    }
                    if (!TextUtils.isEmpty(jumpLoaderResult.getContent())) {
                        dVar.f(URLEncoder.encode(jumpLoaderResult.getContent(), "UTF-8"));
                    }
                    if (!TextUtils.isEmpty(jumpLoaderResult.getExceptionMsg())) {
                        dVar.d(URLEncoder.encode(jumpLoaderResult.getExceptionMsg(), "utf-8"));
                    }
                }
                if (z) {
                    this.j.a("click_jump_error", dVar, this.d);
                    return;
                }
                ArrayList arrayList = new ArrayList();
                arrayList.add(dVar);
                String a2 = d.a((List<d>) arrayList);
                if (!x.b(a2)) {
                    return;
                }
                if (com.mbridge.msdk.foundation.same.report.a.a().c()) {
                    com.mbridge.msdk.foundation.same.report.a.a().a(a2);
                } else {
                    new c(this.g, 0).a("click_jump_success", a2, (String) null, (Frame) null);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public final void a(Campaign campaign, String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            if (campaign != null) {
                CampaignEx campaignEx = null;
                if (campaign instanceof CampaignEx) {
                    campaignEx = (CampaignEx) campaign;
                }
                if ((!str.startsWith("market://") && !str.startsWith("https://play.google.com/")) || t.a.a(this.g, str, this.i) || campaignEx == null) {
                    return;
                }
                if (!TextUtils.isEmpty(campaignEx.getPackageName())) {
                    Context context = this.g;
                    t.a.a(context, "market://details?id=" + campaignEx.getPackageName(), this.i);
                } else if (b() == 2) {
                    t.a(this.g, campaignEx.getClickURL(), campaignEx, this.i);
                } else {
                    t.b(this.g, campaignEx.getClickURL(), this.i);
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* access modifiers changed from: private */
    public void a(CommonJumpLoader.JumpLoaderResult jumpLoaderResult, CampaignEx campaignEx, boolean z) {
        a(jumpLoaderResult, campaignEx, 1, z);
    }

    private void a(int i2, String str, CampaignEx campaignEx, NativeListener.NativeTrackingListener nativeTrackingListener) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            if (i2 == 2) {
                t.a(this.g, str, campaignEx, nativeTrackingListener);
            } else {
                t.b(this.g, str, nativeTrackingListener);
            }
        } catch (Throwable th) {
            q.a("MBridge SDK M", th.getMessage(), th);
        }
    }

    private boolean a(CampaignEx campaignEx, CommonJumpLoader.JumpLoaderResult jumpLoaderResult, boolean z, int i2) {
        boolean z2 = false;
        if (z) {
            try {
                int parseInt = Integer.parseInt(campaignEx.getLandingType());
                if (parseInt == 1) {
                    t.b(this.g, jumpLoaderResult.getUrl(), this.i);
                } else if (parseInt == 2) {
                    t.a(this.g, jumpLoaderResult.getUrl(), campaignEx, this.i);
                } else if (campaignEx.getPackageName() != null) {
                    if (!t.a.a(this.g, "market://details?id=" + campaignEx.getPackageName(), this.i)) {
                        a(i2, jumpLoaderResult.getUrl(), campaignEx, this.i);
                    }
                } else {
                    a(i2, jumpLoaderResult.getUrl(), campaignEx, this.i);
                }
                z2 = true;
            } catch (Throwable th) {
                q.a("MBridge SDK M", th.getMessage(), th);
            }
        }
        if (z2) {
            a(jumpLoaderResult, campaignEx, true);
            if (this.i != null) {
                this.i.onFinishRedirection(campaignEx, jumpLoaderResult.getUrl());
            }
        } else {
            a(jumpLoaderResult, campaignEx, true);
            if (this.i != null && z) {
                this.i.onRedirectionFailed(campaignEx, jumpLoaderResult.getUrl());
            }
        }
        return z2;
    }

    private boolean a(CampaignEx campaignEx, CommonJumpLoader.JumpLoaderResult jumpLoaderResult, boolean z) {
        boolean z2 = false;
        if (z) {
            try {
                t.b(this.g, campaignEx.getClickURL(), this.i);
                z2 = true;
            } catch (Throwable th) {
                q.a("MBridge SDK M", th.getMessage(), th);
            }
        }
        a(jumpLoaderResult, campaignEx, true);
        if (z2) {
            if (this.i != null) {
                this.i.onFinishRedirection(campaignEx, jumpLoaderResult.getUrl());
            }
        } else if (this.i != null) {
            this.i.onRedirectionFailed(campaignEx, jumpLoaderResult.getUrl());
        }
        return z2;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00b0, code lost:
        if (com.mbridge.msdk.foundation.tools.t.a.a(r2, "market://details?id=" + r7.getPackageName(), r6.i) == false) goto L_0x00b2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(com.mbridge.msdk.foundation.entity.CampaignEx r7, com.mbridge.msdk.click.CommonJumpLoader.JumpLoaderResult r8, boolean r9, boolean r10) {
        /*
            r6 = this;
            boolean r0 = r6.n     // Catch:{ Exception -> 0x0154 }
            if (r0 != 0) goto L_0x0005
            return
        L_0x0005:
            r0 = 1
            if (r7 == 0) goto L_0x0144
            if (r8 != 0) goto L_0x000c
            goto L_0x0144
        L_0x000c:
            int r1 = r6.b()     // Catch:{ Exception -> 0x0154 }
            int r2 = r8.getCode()     // Catch:{ Exception -> 0x0154 }
            java.lang.String r3 = r8.getUrl()     // Catch:{ Exception -> 0x0154 }
            boolean r3 = android.text.TextUtils.isEmpty(r3)     // Catch:{ Exception -> 0x0154 }
            r4 = 2
            r5 = 3
            if (r3 == 0) goto L_0x0052
            if (r9 == 0) goto L_0x0052
            int r10 = r7.getLinkType()     // Catch:{ Exception -> 0x0154 }
            if (r10 != r4) goto L_0x0030
            int r10 = r6.b()     // Catch:{ Exception -> 0x0154 }
            r6.a((com.mbridge.msdk.foundation.entity.CampaignEx) r7, (com.mbridge.msdk.click.CommonJumpLoader.JumpLoaderResult) r8, (boolean) r9, (int) r10)     // Catch:{ Exception -> 0x0154 }
            return
        L_0x0030:
            if (r10 != r5) goto L_0x0036
            r6.a((com.mbridge.msdk.foundation.entity.CampaignEx) r7, (com.mbridge.msdk.click.CommonJumpLoader.JumpLoaderResult) r8, (boolean) r9)     // Catch:{ Exception -> 0x0154 }
            return
        L_0x0036:
            android.content.Context r9 = r6.g     // Catch:{ Exception -> 0x0154 }
            java.lang.String r10 = r7.getClickURL()     // Catch:{ Exception -> 0x0154 }
            com.mbridge.msdk.out.NativeListener$NativeTrackingListener r1 = r6.i     // Catch:{ Exception -> 0x0154 }
            com.mbridge.msdk.foundation.tools.t.b(r9, r10, r1)     // Catch:{ Exception -> 0x0154 }
            r6.a((com.mbridge.msdk.click.CommonJumpLoader.JumpLoaderResult) r8, (com.mbridge.msdk.foundation.entity.CampaignEx) r7, (boolean) r0)     // Catch:{ Exception -> 0x0154 }
            com.mbridge.msdk.out.NativeListener$NativeTrackingListener r9 = r6.i     // Catch:{ Exception -> 0x0154 }
            if (r9 == 0) goto L_0x0051
            com.mbridge.msdk.out.NativeListener$NativeTrackingListener r9 = r6.i     // Catch:{ Exception -> 0x0154 }
            java.lang.String r8 = r8.getUrl()     // Catch:{ Exception -> 0x0154 }
            r9.onFinishRedirection(r7, r8)     // Catch:{ Exception -> 0x0154 }
        L_0x0051:
            return
        L_0x0052:
            if (r2 != r0) goto L_0x00cb
            java.lang.String r2 = r7.getPackageName()     // Catch:{ Exception -> 0x0154 }
            boolean r2 = android.text.TextUtils.isEmpty(r2)     // Catch:{ Exception -> 0x0154 }
            if (r2 != 0) goto L_0x0087
            java.lang.String r2 = r8.getUrl()     // Catch:{ Exception -> 0x0154 }
            boolean r2 = android.text.TextUtils.isEmpty(r2)     // Catch:{ Exception -> 0x0154 }
            if (r2 != 0) goto L_0x0087
            java.lang.String r2 = r8.getUrl()     // Catch:{ Exception -> 0x0154 }
            java.lang.String r3 = r7.getPackageName()     // Catch:{ Exception -> 0x0154 }
            boolean r2 = r2.contains(r3)     // Catch:{ Exception -> 0x0154 }
            if (r2 == 0) goto L_0x0087
            if (r9 == 0) goto L_0x0087
            android.content.Context r2 = r6.g     // Catch:{ Exception -> 0x0154 }
            java.lang.String r3 = r8.getUrl()     // Catch:{ Exception -> 0x0154 }
            com.mbridge.msdk.out.NativeListener$NativeTrackingListener r4 = r6.i     // Catch:{ Exception -> 0x0154 }
            boolean r2 = com.mbridge.msdk.foundation.tools.t.a.a(r2, r3, r4)     // Catch:{ Exception -> 0x0154 }
            if (r2 != 0) goto L_0x00bb
            goto L_0x00b2
        L_0x0087:
            if (r9 == 0) goto L_0x00bb
            java.lang.String r2 = r7.getPackageName()     // Catch:{ Exception -> 0x0154 }
            boolean r2 = android.text.TextUtils.isEmpty(r2)     // Catch:{ Exception -> 0x0154 }
            if (r2 != 0) goto L_0x00b2
            android.content.Context r2 = r6.g     // Catch:{ Exception -> 0x0154 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0154 }
            r3.<init>()     // Catch:{ Exception -> 0x0154 }
            java.lang.String r4 = "market://details?id="
            r3.append(r4)     // Catch:{ Exception -> 0x0154 }
            java.lang.String r4 = r7.getPackageName()     // Catch:{ Exception -> 0x0154 }
            r3.append(r4)     // Catch:{ Exception -> 0x0154 }
            java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x0154 }
            com.mbridge.msdk.out.NativeListener$NativeTrackingListener r4 = r6.i     // Catch:{ Exception -> 0x0154 }
            boolean r2 = com.mbridge.msdk.foundation.tools.t.a.a(r2, r3, r4)     // Catch:{ Exception -> 0x0154 }
            if (r2 != 0) goto L_0x00bb
        L_0x00b2:
            java.lang.String r2 = r8.getUrl()     // Catch:{ Exception -> 0x0154 }
            com.mbridge.msdk.out.NativeListener$NativeTrackingListener r3 = r6.i     // Catch:{ Exception -> 0x0154 }
            r6.a((int) r1, (java.lang.String) r2, (com.mbridge.msdk.foundation.entity.CampaignEx) r7, (com.mbridge.msdk.out.NativeListener.NativeTrackingListener) r3)     // Catch:{ Exception -> 0x0154 }
        L_0x00bb:
            com.mbridge.msdk.out.NativeListener$NativeTrackingListener r1 = r6.i     // Catch:{ Exception -> 0x0154 }
            if (r1 == 0) goto L_0x011c
            if (r9 == 0) goto L_0x011c
            com.mbridge.msdk.out.NativeListener$NativeTrackingListener r1 = r6.i     // Catch:{ Exception -> 0x0154 }
            java.lang.String r2 = r8.getUrl()     // Catch:{ Exception -> 0x0154 }
            r1.onFinishRedirection(r7, r2)     // Catch:{ Exception -> 0x0154 }
            goto L_0x011c
        L_0x00cb:
            if (r2 != r5) goto L_0x00ea
            if (r9 == 0) goto L_0x00da
            android.content.Context r1 = r6.g     // Catch:{ Exception -> 0x0154 }
            java.lang.String r2 = r8.getUrl()     // Catch:{ Exception -> 0x0154 }
            com.mbridge.msdk.out.NativeListener$NativeTrackingListener r3 = r6.i     // Catch:{ Exception -> 0x0154 }
            com.mbridge.msdk.foundation.tools.t.b(r1, r2, r3)     // Catch:{ Exception -> 0x0154 }
        L_0x00da:
            com.mbridge.msdk.out.NativeListener$NativeTrackingListener r1 = r6.i     // Catch:{ Exception -> 0x0154 }
            if (r1 == 0) goto L_0x011c
            if (r9 == 0) goto L_0x011c
            com.mbridge.msdk.out.NativeListener$NativeTrackingListener r1 = r6.i     // Catch:{ Exception -> 0x0154 }
            java.lang.String r2 = r8.getUrl()     // Catch:{ Exception -> 0x0154 }
            r1.onFinishRedirection(r7, r2)     // Catch:{ Exception -> 0x0154 }
            goto L_0x011c
        L_0x00ea:
            if (r9 == 0) goto L_0x011c
            int r1 = r7.getLinkType()     // Catch:{ Exception -> 0x0154 }
            if (r5 != r1) goto L_0x00f6
            r6.a((com.mbridge.msdk.foundation.entity.CampaignEx) r7, (com.mbridge.msdk.click.CommonJumpLoader.JumpLoaderResult) r8, (boolean) r9)     // Catch:{ Exception -> 0x0154 }
            return
        L_0x00f6:
            int r1 = r7.getLinkType()     // Catch:{ Exception -> 0x0154 }
            if (r4 != r1) goto L_0x0104
            int r10 = r6.b()     // Catch:{ Exception -> 0x0154 }
            r6.a((com.mbridge.msdk.foundation.entity.CampaignEx) r7, (com.mbridge.msdk.click.CommonJumpLoader.JumpLoaderResult) r8, (boolean) r9, (int) r10)     // Catch:{ Exception -> 0x0154 }
            return
        L_0x0104:
            android.content.Context r1 = r6.g     // Catch:{ Exception -> 0x0154 }
            java.lang.String r2 = r8.getUrl()     // Catch:{ Exception -> 0x0154 }
            com.mbridge.msdk.out.NativeListener$NativeTrackingListener r3 = r6.i     // Catch:{ Exception -> 0x0154 }
            com.mbridge.msdk.foundation.tools.t.b(r1, r2, r3)     // Catch:{ Exception -> 0x0154 }
            com.mbridge.msdk.out.NativeListener$NativeTrackingListener r1 = r6.i     // Catch:{ Exception -> 0x0154 }
            if (r1 == 0) goto L_0x011c
            com.mbridge.msdk.out.NativeListener$NativeTrackingListener r1 = r6.i     // Catch:{ Exception -> 0x0154 }
            java.lang.String r2 = r8.getUrl()     // Catch:{ Exception -> 0x0154 }
            r1.onFinishRedirection(r7, r2)     // Catch:{ Exception -> 0x0154 }
        L_0x011c:
            int r1 = r7.getLinkType()     // Catch:{ Exception -> 0x0154 }
            java.lang.String r2 = r8.getUrl()     // Catch:{ Exception -> 0x0154 }
            boolean r1 = r6.a((int) r1, (java.lang.String) r2)     // Catch:{ Exception -> 0x0154 }
            if (r1 == 0) goto L_0x012f
            r0 = 0
            r6.a((com.mbridge.msdk.click.CommonJumpLoader.JumpLoaderResult) r8, (com.mbridge.msdk.foundation.entity.CampaignEx) r7, (boolean) r0)     // Catch:{ Exception -> 0x0154 }
            goto L_0x0132
        L_0x012f:
            r6.a((com.mbridge.msdk.click.CommonJumpLoader.JumpLoaderResult) r8, (com.mbridge.msdk.foundation.entity.CampaignEx) r7, (boolean) r0)     // Catch:{ Exception -> 0x0154 }
        L_0x0132:
            com.mbridge.msdk.out.NativeListener$NativeTrackingListener r0 = r6.i     // Catch:{ Exception -> 0x0154 }
            if (r0 == 0) goto L_0x0158
            if (r9 != 0) goto L_0x0158
            if (r10 == 0) goto L_0x0158
            com.mbridge.msdk.out.NativeListener$NativeTrackingListener r9 = r6.i     // Catch:{ Exception -> 0x0154 }
            java.lang.String r8 = r8.getUrl()     // Catch:{ Exception -> 0x0154 }
            r9.onFinishRedirection(r7, r8)     // Catch:{ Exception -> 0x0154 }
            goto L_0x0158
        L_0x0144:
            if (r9 == 0) goto L_0x0153
            r6.a((com.mbridge.msdk.click.CommonJumpLoader.JumpLoaderResult) r8, (com.mbridge.msdk.foundation.entity.CampaignEx) r7, (boolean) r0)     // Catch:{ Exception -> 0x0154 }
            com.mbridge.msdk.out.NativeListener$NativeTrackingListener r7 = r6.i     // Catch:{ Exception -> 0x0154 }
            if (r7 == 0) goto L_0x0153
            com.mbridge.msdk.out.NativeListener$NativeTrackingListener r7 = r6.i     // Catch:{ Exception -> 0x0154 }
            r8 = 0
            r7.onRedirectionFailed(r8, r8)     // Catch:{ Exception -> 0x0154 }
        L_0x0153:
            return
        L_0x0154:
            r7 = move-exception
            r7.printStackTrace()
        L_0x0158:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.click.a.a(com.mbridge.msdk.foundation.entity.CampaignEx, com.mbridge.msdk.click.CommonJumpLoader$JumpLoaderResult, boolean, boolean):void");
    }

    private int b() {
        try {
            if (this.k != null) {
                return this.k.t();
            }
            return 1;
        } catch (Exception e2) {
            e2.printStackTrace();
            return 1;
        }
    }

    private boolean a(int i2, String str) {
        if (i2 == 2) {
            try {
                if (!t.a.a(str)) {
                    return false;
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                return false;
            }
        } else if (TextUtils.isEmpty(str)) {
            return false;
        }
        return true;
    }

    static /* synthetic */ void a(a aVar, CampaignEx campaignEx) {
        try {
            Intent intent = new Intent(aVar.g, LoadingActivity.class);
            intent.setFlags(268435456);
            intent.putExtra(CampaignEx.JSON_KEY_ICON_URL, campaignEx.getIconUrl());
            aVar.g.startActivity(intent);
        } catch (Exception e2) {
            q.a("MBridge SDK M", "Exception", e2);
        }
    }

    static /* synthetic */ void f(a aVar) {
        try {
            Intent intent = new Intent();
            intent.setAction("ExitApp");
            aVar.g.sendBroadcast(intent);
        } catch (Exception e2) {
            q.a("MBridge SDK M", "Exception", e2);
        }
    }
}
