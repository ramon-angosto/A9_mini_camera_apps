package com.mbridge.msdk.splash.c;

import android.text.TextUtils;
import com.mbridge.msdk.b.b;
import com.mbridge.msdk.foundation.db.e;
import com.mbridge.msdk.foundation.db.f;
import com.mbridge.msdk.foundation.db.g;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.splash.c.d;
import com.mbridge.msdk.splash.view.MBSplashView;
import com.mbridge.msdk.videocommon.download.c;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ResManager */
public final class a {
    public static e a = e.a((f) g.a(com.mbridge.msdk.foundation.controller.a.e().g()));
    private static String b = "ResManager";
    private static int c = 1;

    public static CampaignEx a(MBSplashView mBSplashView, String str, String str2, String str3, boolean z, int i, boolean z2, boolean z3) {
        if (a == null) {
            a = e.a((f) g.a(com.mbridge.msdk.foundation.controller.a.e().g()));
        }
        com.mbridge.msdk.b.a b2 = b.a().b(com.mbridge.msdk.foundation.controller.a.e().h());
        if (b2 == null) {
            b2 = b.a().b();
        }
        long B = b2.B() * 1000;
        long v = b2.v() * 1000;
        if (a == null) {
            a = e.a((f) g.a(com.mbridge.msdk.foundation.controller.a.e().g()));
        }
        a.b(v, str2);
        List<CampaignEx> a2 = a.a(str2, 0, 0, c, !TextUtils.isEmpty(str3));
        if (a2 == null || a2.size() <= 0) {
            return null;
        }
        CampaignEx campaignEx = a2.get(0);
        if (TextUtils.isEmpty(campaignEx.getAdZip()) && TextUtils.isEmpty(campaignEx.getAdHtml())) {
            return null;
        }
        long currentTimeMillis = System.currentTimeMillis();
        long j = currentTimeMillis - B;
        if (!z2) {
            if (((campaignEx.getPlct() <= 0 || (campaignEx.getPlct() * 1000) + campaignEx.getTimestamp() < currentTimeMillis) && (campaignEx.getPlct() > 0 || campaignEx.getTimestamp() < j)) || !a(mBSplashView, campaignEx, str, str2, z, i, z3)) {
                return null;
            }
            return a(campaignEx);
        } else if ((campaignEx.getPlct() <= 0 || (campaignEx.getPlct() * 1000) + campaignEx.getTimestamp() < currentTimeMillis) && (campaignEx.getPlct() > 0 || campaignEx.getTimestamp() < j)) {
            if (!a(mBSplashView, campaignEx, str, str2, z, i, z3) || !campaignEx.isSpareOffer(B, v)) {
                return null;
            }
            return a(campaignEx);
        } else if (a(mBSplashView, campaignEx, str, str2, z, i, z3)) {
            return a(campaignEx);
        } else {
            return null;
        }
    }

    private static CampaignEx a(CampaignEx campaignEx) {
        if (!TextUtils.isEmpty(campaignEx.getAdZip()) || (!TextUtils.isEmpty(campaignEx.getAdHtml()) && campaignEx.getAdHtml().contains("<MBTPLMARK>"))) {
            campaignEx.setHasMBTplMark(true);
            campaignEx.setIsMraid(false);
        } else {
            campaignEx.setHasMBTplMark(false);
            campaignEx.setIsMraid(true);
        }
        return campaignEx;
    }

    private static boolean a(MBSplashView mBSplashView, CampaignEx campaignEx, String str, String str2, boolean z, int i, boolean z2) {
        boolean z3;
        MBSplashView mBSplashView2 = mBSplashView;
        String str3 = str2;
        if (campaignEx == null) {
            return false;
        }
        mBSplashView.clearResState();
        if (!TextUtils.isEmpty(campaignEx.getVideoUrlEncode())) {
            boolean z4 = mBSplashView.isVideoReady() || c.getInstance().a(297, str2, campaignEx.isBidCampaign());
            if (!z4) {
                a(mBSplashView, campaignEx, str2);
            } else {
                mBSplashView.setVideoReady(true);
            }
            z3 = z4;
        } else {
            z3 = true;
        }
        if (!TextUtils.isEmpty(campaignEx.getAdZip()) && !mBSplashView.isH5Ready()) {
            String b2 = com.mbridge.msdk.videocommon.download.g.a().b(campaignEx.getAdZip());
            if (TextUtils.isEmpty(b2)) {
                z3 = false;
            } else if (!z2) {
                a(mBSplashView, b2, campaignEx, str, str2, z, i);
            }
        }
        if (TextUtils.isEmpty(campaignEx.getAdZip()) && !TextUtils.isEmpty(campaignEx.getAdHtml()) && !mBSplashView.isH5Ready()) {
            String b3 = b(campaignEx.getAdHtml());
            if (TextUtils.isEmpty(b3)) {
                return false;
            }
            if (!z2) {
                a(mBSplashView, b3, campaignEx, str, str2, z, i);
            }
        }
        return z3;
    }

    private static void a(final MBSplashView mBSplashView, CampaignEx campaignEx, String str) {
        AnonymousClass1 r5 = new com.mbridge.msdk.videocommon.listener.a() {
            public final void a(String str) {
                mBSplashView.setVideoReady(true);
            }

            public final void a(String str, String str2) {
                mBSplashView.setVideoReady(false);
            }
        };
        ArrayList arrayList = new ArrayList();
        arrayList.add(campaignEx);
        c.getInstance().createUnitCache(com.mbridge.msdk.foundation.controller.a.e().g(), str, (List<CampaignEx>) arrayList, 297, (com.mbridge.msdk.videocommon.listener.a) r5);
        if (!c.getInstance().a(297, str, campaignEx.isBidCampaign())) {
            c.getInstance().load(str);
        } else {
            mBSplashView.setVideoReady(true);
        }
    }

    private static void a(MBSplashView mBSplashView, String str, CampaignEx campaignEx, String str2, String str3, boolean z, int i) {
        d.c cVar = new d.c();
        cVar.c(str3);
        cVar.b(str2);
        cVar.a(campaignEx);
        cVar.a(str);
        cVar.a(z);
        cVar.a(i);
        d.a.a.a(mBSplashView, cVar, (d.b) null);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:?, code lost:
        return "";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0025, code lost:
        r3 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0026, code lost:
        r3.getMessage();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String b(java.lang.String r3) {
        /*
            java.lang.String r0 = ""
            java.io.File r1 = new java.io.File     // Catch:{ all -> 0x0023 }
            r1.<init>(r3)     // Catch:{ all -> 0x0023 }
            boolean r3 = r1.exists()     // Catch:{ all -> 0x0023 }
            if (r3 == 0) goto L_0x0029
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0023 }
            r3.<init>()     // Catch:{ all -> 0x0023 }
            java.lang.String r2 = "file:///"
            r3.append(r2)     // Catch:{ all -> 0x0023 }
            java.lang.String r1 = r1.getAbsolutePath()     // Catch:{ all -> 0x0023 }
            r3.append(r1)     // Catch:{ all -> 0x0023 }
            java.lang.String r0 = r3.toString()     // Catch:{ all -> 0x0023 }
            goto L_0x0029
        L_0x0023:
            r3 = move-exception
            throw r3     // Catch:{ Exception -> 0x0025 }
        L_0x0025:
            r3 = move-exception
            r3.getMessage()
        L_0x0029:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.splash.c.a.b(java.lang.String):java.lang.String");
    }

    public static boolean a(MBSplashView mBSplashView, CampaignEx campaignEx) {
        if (mBSplashView == null) {
            return false;
        }
        boolean z = true;
        if (!TextUtils.isEmpty(campaignEx.getVideoUrlEncode())) {
            z = mBSplashView.isVideoReady();
        }
        if (z && !TextUtils.isEmpty(campaignEx.getAdZip())) {
            z = mBSplashView.isH5Ready();
        }
        boolean isH5Ready = (!z || !TextUtils.isEmpty(campaignEx.getAdZip()) || TextUtils.isEmpty(campaignEx.getAdHtml())) ? z : mBSplashView.isH5Ready();
        if (!TextUtils.isEmpty(campaignEx.getAdZip()) || !TextUtils.isEmpty(campaignEx.getAdHtml())) {
            return isH5Ready;
        }
        return false;
    }

    public static void a(CampaignEx campaignEx, String str) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(campaignEx);
        if (a == null) {
            a = e.a((f) g.a(com.mbridge.msdk.foundation.controller.a.e().g()));
        }
        a.b((List<CampaignEx>) arrayList, str);
    }

    public static void a(String str) {
        if (a == null) {
            a = e.a((f) g.a(com.mbridge.msdk.foundation.controller.a.e().g()));
        }
        a.a(str, 0, c);
    }
}
