package com.mbridge.msdk.advanced.b;

import android.content.Context;
import android.net.http.SslError;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import com.mbridge.msdk.advanced.view.MBNativeAdvancedView;
import com.mbridge.msdk.advanced.view.MBNativeAdvancedWebview;
import com.mbridge.msdk.b.b;
import com.mbridge.msdk.foundation.controller.a;
import com.mbridge.msdk.foundation.db.e;
import com.mbridge.msdk.foundation.db.f;
import com.mbridge.msdk.foundation.db.g;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.q;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ResManager */
public final class c {
    public static e a = e.a((f) g.a(a.e().g()));
    private static String b = "ResManager";
    private static int c = 1;

    public static CampaignEx a(MBNativeAdvancedView mBNativeAdvancedView, String str, String str2, String str3, int i, boolean z, boolean z2) {
        MBNativeAdvancedView mBNativeAdvancedView2 = mBNativeAdvancedView;
        String str4 = str2;
        com.mbridge.msdk.b.a b2 = b.a().b(a.e().h());
        if (b2 == null) {
            b2 = b.a().b();
        }
        long B = b2.B() * 1000;
        long v = b2.v() * 1000;
        if (a == null) {
            a = e.a((f) g.a(a.e().g()));
        }
        a.b(v, str4);
        if (a == null) {
            a = e.a((f) g.a(a.e().g()));
        }
        List<CampaignEx> b3 = a.b(str4, 0, 0, c);
        if (b3 == null || b3.size() <= 0) {
            return null;
        }
        CampaignEx campaignEx = b3.get(0);
        if (TextUtils.isEmpty(campaignEx.getAdZip()) && TextUtils.isEmpty(campaignEx.getAdHtml())) {
            return null;
        }
        long currentTimeMillis = System.currentTimeMillis();
        long j = currentTimeMillis - B;
        if (!z) {
            if ((campaignEx.getPlct() > 0 && (campaignEx.getPlct() * 1000) + campaignEx.getTimestamp() >= currentTimeMillis) || (campaignEx.getPlct() <= 0 && campaignEx.getTimestamp() >= j)) {
                String str5 = "cache campain is picked:";
                if (!a(mBNativeAdvancedView, campaignEx, str, str2, i, z2)) {
                    return null;
                }
                String str6 = b;
                q.d(str6, str5 + campaignEx.getAppName());
                return a(campaignEx);
            } else if (campaignEx.isSpareOffer(B, v) || mBNativeAdvancedView2 == null) {
                return null;
            } else {
                mBNativeAdvancedView2.setVisibility(8);
                return null;
            }
        } else if ((campaignEx.getPlct() > 0 && (campaignEx.getPlct() * 1000) + campaignEx.getTimestamp() >= currentTimeMillis) || (campaignEx.getPlct() <= 0 && campaignEx.getTimestamp() >= j)) {
            String str7 = "cache campain is picked:";
            if (!a(mBNativeAdvancedView, campaignEx, str, str2, i, z2)) {
                return null;
            }
            String str8 = b;
            q.d(str8, str7 + campaignEx.getAppName());
            return a(campaignEx);
        } else if (a(mBNativeAdvancedView, campaignEx, str, str2, i, z2) && campaignEx.isSpareOffer(B, v)) {
            return a(campaignEx);
        } else {
            if (campaignEx.isSpareOffer(B, v) || mBNativeAdvancedView2 == null) {
                return null;
            }
            mBNativeAdvancedView2.setVisibility(8);
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

    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0087, code lost:
        if (r16 == false) goto L_0x0089;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0021, code lost:
        if (r0 != false) goto L_0x0026;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean a(com.mbridge.msdk.advanced.view.MBNativeAdvancedView r11, com.mbridge.msdk.foundation.entity.CampaignEx r12, java.lang.String r13, java.lang.String r14, int r15, boolean r16) {
        /*
            r6 = r11
            r7 = 0
            if (r12 == 0) goto L_0x00d6
            r11.clearResState()
            java.lang.String r0 = r12.getVideoUrlEncode()
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            r8 = 1
            if (r0 != 0) goto L_0x0024
            com.mbridge.msdk.videocommon.download.c r0 = com.mbridge.msdk.videocommon.download.c.getInstance()
            r1 = 298(0x12a, float:4.18E-43)
            boolean r2 = r12.isBidCampaign()
            r9 = r14
            boolean r0 = r0.a(r1, r14, r2)
            if (r0 == 0) goto L_0x0029
            goto L_0x0026
        L_0x0024:
            r9 = r14
            r0 = r8
        L_0x0026:
            r11.setVideoReady(r8)
        L_0x0029:
            r10 = r0
            java.lang.String r0 = r12.getendcard_url()
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x004f
            boolean r0 = r11.isEndCardReady()
            if (r0 != 0) goto L_0x004f
            com.mbridge.msdk.videocommon.download.g r0 = com.mbridge.msdk.videocommon.download.g.a()
            java.lang.String r1 = r12.getendcard_url()
            java.lang.String r0 = r0.b((java.lang.String) r1)
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x004f
            r11.setEndCardReady(r8)
        L_0x004f:
            java.lang.String r0 = r12.getAdZip()
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x008a
            boolean r0 = r11.isH5Ready()
            if (r0 != 0) goto L_0x008a
            com.mbridge.msdk.videocommon.download.g r0 = com.mbridge.msdk.videocommon.download.g.a()
            java.lang.String r1 = r12.getAdZip()
            java.lang.String r1 = r0.b((java.lang.String) r1)
            boolean r0 = android.text.TextUtils.isEmpty(r1)
            if (r0 != 0) goto L_0x0089
            java.lang.String r0 = r12.getRequestId()
            boolean r0 = com.mbridge.msdk.advanced.common.b.a(r0)
            if (r0 == 0) goto L_0x007f
            r11.setH5Ready(r8)
            goto L_0x008a
        L_0x007f:
            r0 = r11
            r2 = r12
            r3 = r13
            r4 = r14
            r5 = r15
            a((com.mbridge.msdk.advanced.view.MBNativeAdvancedView) r0, (java.lang.String) r1, (com.mbridge.msdk.foundation.entity.CampaignEx) r2, (java.lang.String) r3, (java.lang.String) r4, (int) r5)
            if (r16 != 0) goto L_0x008a
        L_0x0089:
            r10 = r7
        L_0x008a:
            java.lang.String r0 = r12.getAdZip()
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L_0x00d5
            java.lang.String r0 = r12.getAdHtml()
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x00d5
            boolean r0 = r11.isH5Ready()
            if (r0 != 0) goto L_0x00d5
            java.lang.String r0 = r12.getAdHtml()
            java.lang.String r1 = b(r0)
            boolean r0 = android.text.TextUtils.isEmpty(r1)
            if (r0 != 0) goto L_0x00d6
            java.lang.String r0 = r12.getRequestId()
            boolean r0 = com.mbridge.msdk.advanced.common.b.a(r0)
            if (r0 == 0) goto L_0x00ca
            r11.setH5Ready(r8)
            boolean r0 = r12.isMraid()
            if (r0 == 0) goto L_0x00c8
            r11.setVideoReady(r8)
        L_0x00c8:
            r7 = r8
            goto L_0x00d6
        L_0x00ca:
            r0 = r11
            r2 = r12
            r3 = r13
            r4 = r14
            r5 = r15
            a((com.mbridge.msdk.advanced.view.MBNativeAdvancedView) r0, (java.lang.String) r1, (com.mbridge.msdk.foundation.entity.CampaignEx) r2, (java.lang.String) r3, (java.lang.String) r4, (int) r5)
            if (r16 != 0) goto L_0x00d5
            goto L_0x00d6
        L_0x00d5:
            r7 = r10
        L_0x00d6:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.advanced.b.c.a(com.mbridge.msdk.advanced.view.MBNativeAdvancedView, com.mbridge.msdk.foundation.entity.CampaignEx, java.lang.String, java.lang.String, int, boolean):boolean");
    }

    private static void a(MBNativeAdvancedView mBNativeAdvancedView, final String str, CampaignEx campaignEx, String str2, String str3, int i) {
        if (mBNativeAdvancedView != null && mBNativeAdvancedView.getAdvancedNativeWebview() != null) {
            com.mbridge.msdk.advanced.d.a.a(com.mbridge.msdk.advanced.common.c.a().c(campaignEx.getId()).d(campaignEx.getRequestId()).g(campaignEx.getRequestIdNotice()).b(str3).a(campaignEx.isBidCampaign()), str3);
            com.mbridge.msdk.advanced.js.b bVar = new com.mbridge.msdk.advanced.js.b(mBNativeAdvancedView.getContext(), str2, str3);
            ArrayList arrayList = new ArrayList();
            arrayList.add(campaignEx);
            bVar.a((List<CampaignEx>) arrayList);
            bVar.a(i);
            mBNativeAdvancedView.setAdvancedNativeSignalCommunicationImpl(bVar);
            final MBNativeAdvancedWebview advancedNativeWebview = mBNativeAdvancedView.getAdvancedNativeWebview();
            long currentTimeMillis = System.currentTimeMillis();
            final CampaignEx campaignEx2 = campaignEx;
            final MBNativeAdvancedView mBNativeAdvancedView2 = mBNativeAdvancedView;
            final String str4 = str3;
            final long j = currentTimeMillis;
            advancedNativeWebview.setWebViewListener(new com.mbridge.msdk.mbsignalcommon.b.b() {
                public final void a(WebView webView, int i) {
                    super.a(webView, i);
                    if (i == 1) {
                        com.mbridge.msdk.advanced.common.b.a(campaignEx2.getRequestId(), true);
                        mBNativeAdvancedView2.setH5Ready(true);
                        com.mbridge.msdk.advanced.d.a.a(a.e().g(), campaignEx2, str4, "", j, 1);
                        return;
                    }
                    mBNativeAdvancedView2.setH5Ready(false);
                    com.mbridge.msdk.advanced.d.a.a(a.e().g(), campaignEx2, str4, "readyState 2", j, 3);
                }

                public final void a(WebView webView, int i, String str, String str2) {
                    super.a(webView, i, str, str2);
                    mBNativeAdvancedView2.setH5Ready(false);
                    Context g = a.e().g();
                    CampaignEx campaignEx = campaignEx2;
                    String str3 = str4;
                    com.mbridge.msdk.advanced.d.a.a(g, campaignEx, str3, "error code:" + i + str, j, 3);
                }

                public final void a(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
                    super.a(webView, sslErrorHandler, sslError);
                    mBNativeAdvancedView2.setH5Ready(false);
                    Context g = a.e().g();
                    CampaignEx campaignEx = campaignEx2;
                    String str = str4;
                    com.mbridge.msdk.advanced.d.a.a(g, campaignEx, str, "error url:" + sslError.getUrl(), j, 3);
                }

                public final void a(WebView webView, String str) {
                    super.a(webView, str);
                    if (!campaignEx2.isHasMBTplMark()) {
                        com.mbridge.msdk.advanced.common.b.a(campaignEx2.getRequestId(), true);
                        mBNativeAdvancedView2.setH5Ready(true);
                        com.mbridge.msdk.advanced.d.a.a(a.e().g(), campaignEx2, str4, "", j, 1);
                    }
                    com.mbridge.msdk.advanced.js.a.a(webView);
                }
            });
            if (!advancedNativeWebview.isDestoryed()) {
                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    public final void run() {
                        advancedNativeWebview.loadUrl(str);
                    }
                });
                return;
            }
            mBNativeAdvancedView.setH5Ready(false);
            com.mbridge.msdk.advanced.d.a.a(a.e().g(), campaignEx, str3, "webview had destory", currentTimeMillis, 3);
        }
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
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.advanced.b.c.b(java.lang.String):java.lang.String");
    }

    public static boolean a(MBNativeAdvancedView mBNativeAdvancedView, CampaignEx campaignEx, String str, String str2) {
        boolean z = false;
        if (mBNativeAdvancedView == null) {
            q.d(b, "mbAdvancedNativeView  is null");
            return false;
        }
        boolean z2 = true;
        if (!TextUtils.isEmpty(campaignEx.getVideoUrlEncode())) {
            z2 = mBNativeAdvancedView.isVideoReady();
            String str3 = b;
            q.d(str3, "isReady isVideoReady:" + z2);
        }
        if (z2 && !TextUtils.isEmpty(campaignEx.getAdZip())) {
            z2 = com.mbridge.msdk.advanced.common.b.a(campaignEx.getRequestId());
            String str4 = b;
            q.d(str4, "isReady getAdZip:" + z2);
        }
        if (z2 && TextUtils.isEmpty(campaignEx.getAdZip()) && !TextUtils.isEmpty(campaignEx.getAdHtml())) {
            z2 = com.mbridge.msdk.advanced.common.b.a(campaignEx.getRequestId());
            String str5 = b;
            q.d(str5, "isReady getAdHtml:" + z2);
        }
        if (!TextUtils.isEmpty(campaignEx.getAdZip()) || !TextUtils.isEmpty(campaignEx.getAdHtml())) {
            z = z2;
        } else {
            q.d(b, "isReady getAdHtml  getAdZip all are empty");
        }
        if (!z || TextUtils.isEmpty(campaignEx.getendcard_url())) {
            return z;
        }
        boolean isEndCardReady = mBNativeAdvancedView.isEndCardReady();
        String str6 = b;
        q.d(str6, "isReady isEndCardReady:" + isEndCardReady);
        return isEndCardReady;
    }

    public static void a(CampaignEx campaignEx, String str) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(campaignEx);
        if (a == null) {
            a = e.a((f) g.a(a.e().g()));
        }
        a.b((List<CampaignEx>) arrayList, str);
    }

    public static void a(String str) {
        if (a == null) {
            a = e.a((f) g.a(a.e().g()));
        }
        a.a(str, 0, c);
    }
}
