package com.mbridge.msdk.reward.adapter;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Base64;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.db.p;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.q;
import com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView;
import com.mbridge.msdk.playercommon.exoplayer2.DefaultRenderersFactory;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSchemeDataSource;
import com.mbridge.msdk.videocommon.a;
import com.mbridge.msdk.videocommon.download.g;
import com.mbridge.msdk.videocommon.listener.InterVideoOutListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

/* compiled from: RewardCampaignsResourceManager */
public final class c {
    /* access modifiers changed from: private */
    public static Map<String, a> c;
    /* access modifiers changed from: private */
    public final h a;
    private ConcurrentHashMap<String, List<CampaignEx>> b;
    /* access modifiers changed from: private */
    public boolean d;
    private volatile List<WindVaneWebView> e;

    /* renamed from: com.mbridge.msdk.reward.adapter.c$c  reason: collision with other inner class name */
    /* compiled from: RewardCampaignsResourceManager */
    public interface C0099c {
        void a(String str, String str2, String str3, List<CampaignEx> list);

        void a(String str, String str2, String str3, List<CampaignEx> list, String str4);
    }

    /* compiled from: RewardCampaignsResourceManager */
    public interface i {
        void a(String str, String str2, String str3, String str4);

        void a(String str, String str2, String str3, String str4, String str5);
    }

    /* compiled from: RewardCampaignsResourceManager */
    public interface j {
        void a(String str, String str2, String str3, String str4, String str5, a.C0105a aVar);

        void a(String str, String str2, String str3, String str4, String str5, a.C0105a aVar, String str6);
    }

    /* compiled from: RewardCampaignsResourceManager */
    private static final class m {
        /* access modifiers changed from: private */
        public static final c a = new c();
    }

    private c() {
        this.e = new ArrayList(6);
        HandlerThread handlerThread = new HandlerThread("mb-reward-load-thread");
        c = new HashMap();
        handlerThread.start();
        this.a = new h(handlerThread.getLooper());
        this.b = new ConcurrentHashMap<>();
    }

    public static c a() {
        return m.a;
    }

    public final synchronized void a(Context context, boolean z, int i2, boolean z2, int i3, String str, String str2, String str3, List<CampaignEx> list, C0099c cVar, i iVar) {
        String str4 = str2;
        String str5 = str3;
        synchronized (this) {
            String str6 = str4 + "_" + str5;
            c.put(str6, new a(z, z2, i2, list.size(), str2, str3, i3, list));
            this.a.a(str, str4, str5, cVar);
            this.a.a(context);
            this.a.a(str6, list);
            final List<CampaignEx> list2 = list;
            final Context context2 = context;
            final String str7 = str2;
            final int i4 = i3;
            final String str8 = str;
            final String str9 = str3;
            final i iVar2 = iVar;
            this.a.post(new Runnable() {
                /* JADX WARNING: Removed duplicated region for block: B:109:0x026d  */
                /* JADX WARNING: Removed duplicated region for block: B:52:0x0123  */
                /* JADX WARNING: Removed duplicated region for block: B:53:0x0136  */
                /* JADX WARNING: Removed duplicated region for block: B:62:0x0172 A[SYNTHETIC, Splitter:B:62:0x0172] */
                /* JADX WARNING: Removed duplicated region for block: B:70:0x01a6 A[SYNTHETIC, Splitter:B:70:0x01a6] */
                /* JADX WARNING: Removed duplicated region for block: B:77:0x01d2  */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public final void run() {
                    /*
                        r21 = this;
                        r1 = r21
                        java.lang.String r2 = "RewardCampaignsResourceManager"
                        java.util.List r0 = r3
                        if (r0 == 0) goto L_0x02c8
                        int r0 = r0.size()
                        if (r0 <= 0) goto L_0x02c8
                        com.mbridge.msdk.videocommon.download.i r0 = com.mbridge.msdk.videocommon.download.i.a()     // Catch:{ Exception -> 0x0041 }
                        java.util.List r3 = r3     // Catch:{ Exception -> 0x0041 }
                        r0.a((java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx>) r3)     // Catch:{ Exception -> 0x0041 }
                        com.mbridge.msdk.videocommon.download.c r4 = com.mbridge.msdk.videocommon.download.c.getInstance()     // Catch:{ Exception -> 0x0041 }
                        android.content.Context r5 = r4     // Catch:{ Exception -> 0x0041 }
                        java.lang.String r6 = r5     // Catch:{ Exception -> 0x0041 }
                        java.util.List r7 = r3     // Catch:{ Exception -> 0x0041 }
                        int r8 = r6     // Catch:{ Exception -> 0x0041 }
                        com.mbridge.msdk.reward.adapter.c$f r9 = new com.mbridge.msdk.reward.adapter.c$f     // Catch:{ Exception -> 0x0041 }
                        com.mbridge.msdk.reward.adapter.c r0 = com.mbridge.msdk.reward.adapter.c.this     // Catch:{ Exception -> 0x0041 }
                        com.mbridge.msdk.reward.adapter.c$h r0 = r0.a     // Catch:{ Exception -> 0x0041 }
                        java.lang.String r3 = r7     // Catch:{ Exception -> 0x0041 }
                        java.lang.String r10 = r5     // Catch:{ Exception -> 0x0041 }
                        java.lang.String r11 = r8     // Catch:{ Exception -> 0x0041 }
                        r9.<init>(r0, r3, r10, r11)     // Catch:{ Exception -> 0x0041 }
                        r4.createUnitCache((android.content.Context) r5, (java.lang.String) r6, (java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx>) r7, (int) r8, (com.mbridge.msdk.videocommon.listener.a) r9)     // Catch:{ Exception -> 0x0041 }
                        com.mbridge.msdk.videocommon.download.c r0 = com.mbridge.msdk.videocommon.download.c.getInstance()     // Catch:{ Exception -> 0x0041 }
                        java.lang.String r3 = r5     // Catch:{ Exception -> 0x0041 }
                        r0.load(r3)     // Catch:{ Exception -> 0x0041 }
                        goto L_0x004d
                    L_0x0041:
                        r0 = move-exception
                        boolean r3 = com.mbridge.msdk.MBridgeConstans.DEBUG
                        if (r3 == 0) goto L_0x004d
                        java.lang.String r0 = r0.getLocalizedMessage()
                        com.mbridge.msdk.foundation.tools.q.d(r2, r0)
                    L_0x004d:
                        java.util.List r0 = r3
                        java.util.Iterator r3 = r0.iterator()
                    L_0x0053:
                        boolean r0 = r3.hasNext()
                        if (r0 == 0) goto L_0x02c8
                        java.lang.Object r0 = r3.next()
                        r14 = r0
                        com.mbridge.msdk.foundation.entity.CampaignEx r14 = (com.mbridge.msdk.foundation.entity.CampaignEx) r14
                        if (r14 != 0) goto L_0x0063
                        goto L_0x0053
                    L_0x0063:
                        com.mbridge.msdk.foundation.entity.CampaignEx$c r15 = r14.getRewardTemplateMode()
                        java.lang.String r13 = ".zip"
                        if (r15 == 0) goto L_0x0111
                        boolean r0 = r14.isDynamicView()
                        if (r0 != 0) goto L_0x0111
                        java.lang.String r0 = r15.e()
                        boolean r4 = android.text.TextUtils.isEmpty(r0)
                        if (r4 != 0) goto L_0x0111
                        java.lang.String r4 = "cmpt=1"
                        boolean r4 = r0.contains(r4)
                        if (r4 != 0) goto L_0x0111
                        boolean r4 = r0.contains(r13)
                        if (r4 == 0) goto L_0x00d5
                        com.mbridge.msdk.videocommon.download.g r12 = com.mbridge.msdk.videocommon.download.g.a()     // Catch:{ Exception -> 0x00c3 }
                        com.mbridge.msdk.reward.adapter.c$g r11 = new com.mbridge.msdk.reward.adapter.c$g     // Catch:{ Exception -> 0x00c3 }
                        android.content.Context r5 = r4     // Catch:{ Exception -> 0x00c3 }
                        java.lang.String r6 = r7     // Catch:{ Exception -> 0x00c3 }
                        java.lang.String r7 = r5     // Catch:{ Exception -> 0x00c3 }
                        java.lang.String r8 = r8     // Catch:{ Exception -> 0x00c3 }
                        r10 = 859(0x35b, float:1.204E-42)
                        com.mbridge.msdk.reward.adapter.c r4 = com.mbridge.msdk.reward.adapter.c.this     // Catch:{ Exception -> 0x00c3 }
                        com.mbridge.msdk.reward.adapter.c$h r16 = r4.a     // Catch:{ Exception -> 0x00c3 }
                        com.mbridge.msdk.reward.adapter.c$i r9 = r9     // Catch:{ Exception -> 0x00c3 }
                        java.util.List r4 = r3     // Catch:{ Exception -> 0x00c3 }
                        r17 = r4
                        r4 = r11
                        r18 = r9
                        r9 = r14
                        r19 = r11
                        r11 = r16
                        r20 = r12
                        r12 = r18
                        r16 = r3
                        r3 = r13
                        r13 = r17
                        r4.<init>(r5, r6, r7, r8, r9, r10, r11, r12, r13)     // Catch:{ Exception -> 0x00c1 }
                        r5 = r19
                        r4 = r20
                        r4.b(r0, r5)     // Catch:{ Exception -> 0x00c1 }
                        goto L_0x00d2
                    L_0x00c1:
                        r0 = move-exception
                        goto L_0x00c7
                    L_0x00c3:
                        r0 = move-exception
                        r16 = r3
                        r3 = r13
                    L_0x00c7:
                        boolean r4 = com.mbridge.msdk.MBridgeConstans.DEBUG
                        if (r4 == 0) goto L_0x00d2
                        java.lang.String r0 = r0.getLocalizedMessage()
                        com.mbridge.msdk.foundation.tools.q.d(r2, r0)
                    L_0x00d2:
                        r18 = r3
                        goto L_0x0115
                    L_0x00d5:
                        r16 = r3
                        r3 = r13
                        com.mbridge.msdk.videocommon.download.g r13 = com.mbridge.msdk.videocommon.download.g.a()     // Catch:{ Exception -> 0x0102 }
                        com.mbridge.msdk.reward.adapter.c$d r12 = new com.mbridge.msdk.reward.adapter.c$d     // Catch:{ Exception -> 0x0102 }
                        r5 = 859(0x35b, float:1.204E-42)
                        java.lang.String r6 = r7     // Catch:{ Exception -> 0x0102 }
                        java.lang.String r7 = r5     // Catch:{ Exception -> 0x0102 }
                        java.lang.String r8 = r8     // Catch:{ Exception -> 0x0102 }
                        com.mbridge.msdk.reward.adapter.c$i r10 = r9     // Catch:{ Exception -> 0x0102 }
                        com.mbridge.msdk.reward.adapter.c r4 = com.mbridge.msdk.reward.adapter.c.this     // Catch:{ Exception -> 0x0102 }
                        com.mbridge.msdk.reward.adapter.c$h r11 = r4.a     // Catch:{ Exception -> 0x0102 }
                        java.util.List r9 = r3     // Catch:{ Exception -> 0x0102 }
                        r4 = r12
                        r17 = r9
                        r9 = r14
                        r18 = r3
                        r3 = r12
                        r12 = r17
                        r4.<init>(r5, r6, r7, r8, r9, r10, r11, r12)     // Catch:{ Exception -> 0x0100 }
                        r13.b(r0, r3)     // Catch:{ Exception -> 0x0100 }
                        goto L_0x0115
                    L_0x0100:
                        r0 = move-exception
                        goto L_0x0105
                    L_0x0102:
                        r0 = move-exception
                        r18 = r3
                    L_0x0105:
                        boolean r3 = com.mbridge.msdk.MBridgeConstans.DEBUG
                        if (r3 == 0) goto L_0x0115
                        java.lang.String r0 = r0.getLocalizedMessage()
                        com.mbridge.msdk.foundation.tools.q.d(r2, r0)
                        goto L_0x0115
                    L_0x0111:
                        r16 = r3
                        r18 = r13
                    L_0x0115:
                        java.lang.String r10 = r14.getendcard_url()
                        boolean r0 = r14.isDynamicView()
                        boolean r3 = com.mbridge.msdk.foundation.tools.u.g((java.lang.String) r10)
                        if (r0 != 0) goto L_0x0136
                        com.mbridge.msdk.reward.adapter.c r4 = com.mbridge.msdk.reward.adapter.c.this
                        android.content.Context r5 = r4
                        java.lang.String r6 = r7
                        java.lang.String r7 = r5
                        java.lang.String r8 = r8
                        com.mbridge.msdk.reward.adapter.c$i r11 = r9
                        java.util.List r12 = r3
                        r9 = r14
                        com.mbridge.msdk.reward.adapter.c.a(r4, r5, r6, r7, r8, r9, r10, r11, r12)
                        goto L_0x014a
                    L_0x0136:
                        if (r3 == 0) goto L_0x014a
                        com.mbridge.msdk.reward.adapter.c r4 = com.mbridge.msdk.reward.adapter.c.this
                        android.content.Context r5 = r4
                        java.lang.String r6 = r7
                        java.lang.String r7 = r5
                        java.lang.String r8 = r8
                        com.mbridge.msdk.reward.adapter.c$i r11 = r9
                        java.util.List r12 = r3
                        r9 = r14
                        com.mbridge.msdk.reward.adapter.c.a(r4, r5, r6, r7, r8, r9, r10, r11, r12)
                    L_0x014a:
                        java.lang.String r0 = r14.getEndScreenUrl()
                        boolean r0 = android.text.TextUtils.isEmpty(r0)
                        if (r0 != 0) goto L_0x0168
                        boolean r0 = r14.isDynamicView()
                        if (r0 != 0) goto L_0x0168
                        com.mbridge.msdk.videocommon.download.g r0 = com.mbridge.msdk.videocommon.download.g.a()
                        java.lang.String r3 = r14.getEndScreenUrl()
                        r4 = 0
                        com.mbridge.msdk.videocommon.download.g$b r4 = (com.mbridge.msdk.videocommon.download.g.b) r4
                        r0.a(r3, r4)
                    L_0x0168:
                        java.lang.String r0 = r14.getIconUrl()
                        boolean r3 = android.text.TextUtils.isEmpty(r0)
                        if (r3 != 0) goto L_0x019c
                        android.content.Context r3 = r4     // Catch:{ Exception -> 0x0190 }
                        com.mbridge.msdk.foundation.same.c.b r3 = com.mbridge.msdk.foundation.same.c.b.a((android.content.Context) r3)     // Catch:{ Exception -> 0x0190 }
                        com.mbridge.msdk.reward.adapter.c$e r11 = new com.mbridge.msdk.reward.adapter.c$e     // Catch:{ Exception -> 0x0190 }
                        com.mbridge.msdk.reward.adapter.c r4 = com.mbridge.msdk.reward.adapter.c.this     // Catch:{ Exception -> 0x0190 }
                        com.mbridge.msdk.reward.adapter.c$h r5 = r4.a     // Catch:{ Exception -> 0x0190 }
                        r6 = 0
                        java.lang.String r7 = r7     // Catch:{ Exception -> 0x0190 }
                        java.lang.String r8 = r5     // Catch:{ Exception -> 0x0190 }
                        java.lang.String r9 = r8     // Catch:{ Exception -> 0x0190 }
                        r4 = r11
                        r10 = r14
                        r4.<init>(r5, r6, r7, r8, r9, r10)     // Catch:{ Exception -> 0x0190 }
                        r3.a((java.lang.String) r0, (com.mbridge.msdk.foundation.same.c.c) r11)     // Catch:{ Exception -> 0x0190 }
                        goto L_0x019c
                    L_0x0190:
                        r0 = move-exception
                        boolean r3 = com.mbridge.msdk.MBridgeConstans.DEBUG
                        if (r3 == 0) goto L_0x019c
                        java.lang.String r0 = r0.getLocalizedMessage()
                        com.mbridge.msdk.foundation.tools.q.d(r2, r0)
                    L_0x019c:
                        java.lang.String r0 = r14.getImageUrl()
                        boolean r3 = android.text.TextUtils.isEmpty(r0)
                        if (r3 != 0) goto L_0x01d0
                        android.content.Context r3 = r4     // Catch:{ Exception -> 0x01c4 }
                        com.mbridge.msdk.foundation.same.c.b r3 = com.mbridge.msdk.foundation.same.c.b.a((android.content.Context) r3)     // Catch:{ Exception -> 0x01c4 }
                        com.mbridge.msdk.reward.adapter.c$e r11 = new com.mbridge.msdk.reward.adapter.c$e     // Catch:{ Exception -> 0x01c4 }
                        com.mbridge.msdk.reward.adapter.c r4 = com.mbridge.msdk.reward.adapter.c.this     // Catch:{ Exception -> 0x01c4 }
                        com.mbridge.msdk.reward.adapter.c$h r5 = r4.a     // Catch:{ Exception -> 0x01c4 }
                        r6 = 0
                        java.lang.String r7 = r7     // Catch:{ Exception -> 0x01c4 }
                        java.lang.String r8 = r5     // Catch:{ Exception -> 0x01c4 }
                        java.lang.String r9 = r8     // Catch:{ Exception -> 0x01c4 }
                        r4 = r11
                        r10 = r14
                        r4.<init>(r5, r6, r7, r8, r9, r10)     // Catch:{ Exception -> 0x01c4 }
                        r3.a((java.lang.String) r0, (com.mbridge.msdk.foundation.same.c.c) r11)     // Catch:{ Exception -> 0x01c4 }
                        goto L_0x01d0
                    L_0x01c4:
                        r0 = move-exception
                        boolean r3 = com.mbridge.msdk.MBridgeConstans.DEBUG
                        if (r3 == 0) goto L_0x01d0
                        java.lang.String r0 = r0.getLocalizedMessage()
                        com.mbridge.msdk.foundation.tools.q.d(r2, r0)
                    L_0x01d0:
                        if (r15 == 0) goto L_0x02c4
                        java.lang.String r0 = r15.d()
                        boolean r3 = android.text.TextUtils.isEmpty(r0)
                        if (r3 != 0) goto L_0x0255
                        boolean r3 = r14.isDynamicView()
                        if (r3 != 0) goto L_0x0255
                        r3 = r18
                        boolean r3 = r0.contains(r3)
                        if (r3 == 0) goto L_0x0225
                        com.mbridge.msdk.videocommon.download.g r3 = com.mbridge.msdk.videocommon.download.g.a()     // Catch:{ Exception -> 0x0216 }
                        com.mbridge.msdk.reward.adapter.c$g r13 = new com.mbridge.msdk.reward.adapter.c$g     // Catch:{ Exception -> 0x0216 }
                        android.content.Context r5 = r4     // Catch:{ Exception -> 0x0216 }
                        java.lang.String r6 = r7     // Catch:{ Exception -> 0x0216 }
                        java.lang.String r7 = r5     // Catch:{ Exception -> 0x0216 }
                        java.lang.String r8 = r8     // Catch:{ Exception -> 0x0216 }
                        r10 = 313(0x139, float:4.39E-43)
                        com.mbridge.msdk.reward.adapter.c r4 = com.mbridge.msdk.reward.adapter.c.this     // Catch:{ Exception -> 0x0216 }
                        com.mbridge.msdk.reward.adapter.c$h r11 = r4.a     // Catch:{ Exception -> 0x0216 }
                        com.mbridge.msdk.reward.adapter.c$i r12 = r9     // Catch:{ Exception -> 0x0216 }
                        java.util.List r9 = r3     // Catch:{ Exception -> 0x0216 }
                        r4 = r13
                        r17 = r9
                        r9 = r14
                        r18 = r15
                        r15 = r13
                        r13 = r17
                        r4.<init>(r5, r6, r7, r8, r9, r10, r11, r12, r13)     // Catch:{ Exception -> 0x0214 }
                        r3.b(r0, r15)     // Catch:{ Exception -> 0x0214 }
                        goto L_0x0257
                    L_0x0214:
                        r0 = move-exception
                        goto L_0x0219
                    L_0x0216:
                        r0 = move-exception
                        r18 = r15
                    L_0x0219:
                        boolean r3 = com.mbridge.msdk.MBridgeConstans.DEBUG
                        if (r3 == 0) goto L_0x0257
                        java.lang.String r0 = r0.getLocalizedMessage()
                        com.mbridge.msdk.foundation.tools.q.d(r2, r0)
                        goto L_0x0257
                    L_0x0225:
                        r18 = r15
                        com.mbridge.msdk.videocommon.download.g r3 = com.mbridge.msdk.videocommon.download.g.a()     // Catch:{ Exception -> 0x0248 }
                        com.mbridge.msdk.reward.adapter.c$d r13 = new com.mbridge.msdk.reward.adapter.c$d     // Catch:{ Exception -> 0x0248 }
                        r5 = 313(0x139, float:4.39E-43)
                        java.lang.String r6 = r7     // Catch:{ Exception -> 0x0248 }
                        java.lang.String r7 = r5     // Catch:{ Exception -> 0x0248 }
                        java.lang.String r8 = r8     // Catch:{ Exception -> 0x0248 }
                        com.mbridge.msdk.reward.adapter.c$i r10 = r9     // Catch:{ Exception -> 0x0248 }
                        com.mbridge.msdk.reward.adapter.c r4 = com.mbridge.msdk.reward.adapter.c.this     // Catch:{ Exception -> 0x0248 }
                        com.mbridge.msdk.reward.adapter.c$h r11 = r4.a     // Catch:{ Exception -> 0x0248 }
                        java.util.List r12 = r3     // Catch:{ Exception -> 0x0248 }
                        r4 = r13
                        r9 = r14
                        r4.<init>(r5, r6, r7, r8, r9, r10, r11, r12)     // Catch:{ Exception -> 0x0248 }
                        r3.b(r0, r13)     // Catch:{ Exception -> 0x0248 }
                        goto L_0x0257
                    L_0x0248:
                        r0 = move-exception
                        boolean r3 = com.mbridge.msdk.MBridgeConstans.DEBUG
                        if (r3 == 0) goto L_0x0257
                        java.lang.String r0 = r0.getLocalizedMessage()
                        com.mbridge.msdk.foundation.tools.q.d(r2, r0)
                        goto L_0x0257
                    L_0x0255:
                        r18 = r15
                    L_0x0257:
                        java.util.List r0 = r18.f()
                        if (r0 == 0) goto L_0x02c4
                        int r3 = r0.size()
                        if (r3 <= 0) goto L_0x02c4
                        java.util.Iterator r3 = r0.iterator()
                    L_0x0267:
                        boolean r0 = r3.hasNext()
                        if (r0 == 0) goto L_0x02c4
                        java.lang.Object r0 = r3.next()
                        com.mbridge.msdk.foundation.entity.CampaignEx$c$a r0 = (com.mbridge.msdk.foundation.entity.CampaignEx.c.a) r0
                        if (r0 == 0) goto L_0x0267
                        java.util.List<java.lang.String> r4 = r0.b
                        if (r4 == 0) goto L_0x0267
                        java.util.List<java.lang.String> r4 = r0.b
                        int r4 = r4.size()
                        if (r4 <= 0) goto L_0x0267
                        java.util.List<java.lang.String> r0 = r0.b
                        java.util.Iterator r11 = r0.iterator()
                    L_0x0287:
                        boolean r0 = r11.hasNext()
                        if (r0 == 0) goto L_0x0267
                        java.lang.Object r0 = r11.next()
                        java.lang.String r0 = (java.lang.String) r0
                        boolean r4 = android.text.TextUtils.isEmpty(r0)
                        if (r4 != 0) goto L_0x0287
                        android.content.Context r4 = r4     // Catch:{ Exception -> 0x02b7 }
                        com.mbridge.msdk.foundation.same.c.b r12 = com.mbridge.msdk.foundation.same.c.b.a((android.content.Context) r4)     // Catch:{ Exception -> 0x02b7 }
                        com.mbridge.msdk.reward.adapter.c$e r13 = new com.mbridge.msdk.reward.adapter.c$e     // Catch:{ Exception -> 0x02b7 }
                        com.mbridge.msdk.reward.adapter.c r4 = com.mbridge.msdk.reward.adapter.c.this     // Catch:{ Exception -> 0x02b7 }
                        com.mbridge.msdk.reward.adapter.c$h r5 = r4.a     // Catch:{ Exception -> 0x02b7 }
                        r6 = 1
                        java.lang.String r7 = r7     // Catch:{ Exception -> 0x02b7 }
                        java.lang.String r8 = r5     // Catch:{ Exception -> 0x02b7 }
                        java.lang.String r9 = r8     // Catch:{ Exception -> 0x02b7 }
                        r4 = r13
                        r10 = r14
                        r4.<init>(r5, r6, r7, r8, r9, r10)     // Catch:{ Exception -> 0x02b7 }
                        r12.a((java.lang.String) r0, (com.mbridge.msdk.foundation.same.c.c) r13)     // Catch:{ Exception -> 0x02b7 }
                        goto L_0x0287
                    L_0x02b7:
                        r0 = move-exception
                        boolean r4 = com.mbridge.msdk.MBridgeConstans.DEBUG
                        if (r4 == 0) goto L_0x0287
                        java.lang.String r0 = r0.getLocalizedMessage()
                        com.mbridge.msdk.foundation.tools.q.d(r2, r0)
                        goto L_0x0287
                    L_0x02c4:
                        r3 = r16
                        goto L_0x0053
                    L_0x02c8:
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.reward.adapter.c.AnonymousClass1.run():void");
                }
            });
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0053, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x008c, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void a(android.content.Context r14, com.mbridge.msdk.foundation.entity.CampaignEx r15, java.lang.String r16, java.lang.String r17, java.lang.String r18, com.mbridge.msdk.reward.adapter.c.i r19) {
        /*
            r13 = this;
            r9 = r13
            r0 = r16
            r3 = r17
            r5 = r18
            r6 = r19
            monitor-enter(r13)
            com.mbridge.msdk.reward.adapter.c$h r1 = r9.a     // Catch:{ all -> 0x008d }
            r7 = r14
            r1.a(r14)     // Catch:{ all -> 0x008d }
            if (r15 == 0) goto L_0x0054
            java.lang.String r1 = r15.getCMPTEntryUrl()     // Catch:{ all -> 0x008d }
            boolean r2 = r15.isDynamicView()     // Catch:{ all -> 0x008d }
            if (r2 == 0) goto L_0x0054
            com.mbridge.msdk.videocommon.download.i r2 = com.mbridge.msdk.videocommon.download.i.a()     // Catch:{ all -> 0x008d }
            r4 = 1
            r2.b(r1, r4)     // Catch:{ all -> 0x008d }
            android.os.Message r2 = android.os.Message.obtain()     // Catch:{ all -> 0x008d }
            r4 = 105(0x69, float:1.47E-43)
            r2.what = r4     // Catch:{ all -> 0x008d }
            android.os.Bundle r4 = new android.os.Bundle     // Catch:{ all -> 0x008d }
            r4.<init>()     // Catch:{ all -> 0x008d }
            java.lang.String r7 = "unit_id"
            r4.putString(r7, r3)     // Catch:{ all -> 0x008d }
            java.lang.String r7 = com.mbridge.msdk.MBridgeConstans.PLACEMENT_ID     // Catch:{ all -> 0x008d }
            r4.putString(r7, r0)     // Catch:{ all -> 0x008d }
            java.lang.String r7 = "request_id"
            r4.putString(r7, r5)     // Catch:{ all -> 0x008d }
            java.lang.String r7 = "url"
            r4.putString(r7, r1)     // Catch:{ all -> 0x008d }
            r2.setData(r4)     // Catch:{ all -> 0x008d }
            com.mbridge.msdk.reward.adapter.c$h r4 = r9.a     // Catch:{ all -> 0x008d }
            r4.sendMessage(r2)     // Catch:{ all -> 0x008d }
            if (r6 == 0) goto L_0x0052
            r6.a(r0, r3, r5, r1)     // Catch:{ all -> 0x008d }
        L_0x0052:
            monitor-exit(r13)
            return
        L_0x0054:
            if (r15 == 0) goto L_0x008b
            java.lang.String r1 = r15.getCMPTEntryUrl()     // Catch:{ all -> 0x008d }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ all -> 0x008d }
            if (r1 != 0) goto L_0x008b
            com.mbridge.msdk.videocommon.download.g r10 = com.mbridge.msdk.videocommon.download.g.a()     // Catch:{ Exception -> 0x007d }
            java.lang.String r11 = r15.getCMPTEntryUrl()     // Catch:{ Exception -> 0x007d }
            com.mbridge.msdk.reward.adapter.c$2 r12 = new com.mbridge.msdk.reward.adapter.c$2     // Catch:{ Exception -> 0x007d }
            r1 = r12
            r2 = r13
            r3 = r17
            r4 = r16
            r5 = r18
            r6 = r19
            r7 = r14
            r8 = r15
            r1.<init>(r3, r4, r5, r6, r7, r8)     // Catch:{ Exception -> 0x007d }
            r10.b(r11, r12)     // Catch:{ Exception -> 0x007d }
            goto L_0x008b
        L_0x007d:
            r0 = move-exception
            boolean r1 = com.mbridge.msdk.MBridgeConstans.DEBUG     // Catch:{ all -> 0x008d }
            if (r1 == 0) goto L_0x008b
            java.lang.String r1 = "RewardCampaignsResourceManager"
            java.lang.String r0 = r0.getLocalizedMessage()     // Catch:{ all -> 0x008d }
            com.mbridge.msdk.foundation.tools.q.d(r1, r0)     // Catch:{ all -> 0x008d }
        L_0x008b:
            monitor-exit(r13)
            return
        L_0x008d:
            r0 = move-exception
            monitor-exit(r13)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.reward.adapter.c.a(android.content.Context, com.mbridge.msdk.foundation.entity.CampaignEx, java.lang.String, java.lang.String, java.lang.String, com.mbridge.msdk.reward.adapter.c$i):void");
    }

    /* compiled from: RewardCampaignsResourceManager */
    private static final class e implements com.mbridge.msdk.foundation.same.c.c {
        private Handler a;
        private int b;
        private String c;
        private String d;
        private String e;
        private CampaignEx f;

        public e(Handler handler, int i, String str, String str2, String str3, CampaignEx campaignEx) {
            this.a = handler;
            this.b = i;
            this.d = str;
            this.c = str2;
            this.e = str3;
            this.f = campaignEx;
        }

        public final void onSuccessLoad(Bitmap bitmap, String str) {
            com.mbridge.msdk.videocommon.download.i.a().c(str, true);
            Message obtain = Message.obtain();
            obtain.what = this.b == 0 ? 102 : 104;
            Bundle bundle = new Bundle();
            bundle.putString(MBridgeConstans.PROPERTIES_UNIT_ID, this.c);
            bundle.putString(MBridgeConstans.PLACEMENT_ID, this.d);
            bundle.putString("request_id", this.e);
            obtain.setData(bundle);
            this.a.sendMessage(obtain);
        }

        public final void onFailedLoad(String str, String str2) {
            Message obtain = Message.obtain();
            obtain.what = this.b == 0 ? 202 : 204;
            Bundle bundle = new Bundle();
            bundle.putString(MBridgeConstans.PROPERTIES_UNIT_ID, this.c);
            bundle.putString(MBridgeConstans.PLACEMENT_ID, this.d);
            bundle.putString("request_id", this.e);
            obtain.setData(bundle);
            this.a.sendMessage(obtain);
            if (this.f != null) {
                try {
                    p a2 = p.a((com.mbridge.msdk.foundation.db.f) com.mbridge.msdk.foundation.db.g.a(com.mbridge.msdk.foundation.controller.a.e().g()));
                    q.a("RewardCampaignsResourceManager", "campaign is null");
                    com.mbridge.msdk.foundation.entity.m mVar = new com.mbridge.msdk.foundation.entity.m();
                    mVar.o("2000044");
                    mVar.c(com.mbridge.msdk.foundation.tools.m.n(com.mbridge.msdk.foundation.controller.a.e().g()));
                    mVar.n(this.f.getId());
                    mVar.d(this.f.getImageUrl());
                    mVar.k(this.f.getRequestId());
                    mVar.l(this.f.getRequestIdNotice());
                    mVar.m(this.c);
                    mVar.p(str);
                    a2.a(mVar);
                } catch (Exception e2) {
                    if (MBridgeConstans.DEBUG) {
                        q.d("RewardCampaignsResourceManager", e2.getLocalizedMessage());
                    }
                }
            }
        }
    }

    /* compiled from: RewardCampaignsResourceManager */
    private static final class f implements com.mbridge.msdk.videocommon.listener.a {
        private Handler a;
        private final String b;
        private final String c;
        private final String d;

        public f(Handler handler, String str, String str2, String str3) {
            this.a = handler;
            this.c = str;
            this.b = str2;
            this.d = str3;
        }

        public final void a(String str) {
            com.mbridge.msdk.videocommon.download.i.a().a(str, true);
            Message obtain = Message.obtain();
            obtain.what = 100;
            Bundle bundle = new Bundle();
            bundle.putString(MBridgeConstans.PROPERTIES_UNIT_ID, this.b);
            bundle.putString(MBridgeConstans.PLACEMENT_ID, this.c);
            bundle.putString("request_id", this.d);
            bundle.putString("url", str);
            obtain.setData(bundle);
            this.a.sendMessage(obtain);
        }

        public final void a(String str, String str2) {
            com.mbridge.msdk.videocommon.download.i.a().a(str2, false);
            Message obtain = Message.obtain();
            obtain.what = 200;
            Bundle bundle = new Bundle();
            bundle.putString(MBridgeConstans.PROPERTIES_UNIT_ID, this.b);
            bundle.putString(MBridgeConstans.PLACEMENT_ID, this.c);
            bundle.putString("request_id", this.d);
            bundle.putString("url", str2);
            bundle.putString("message", str);
            obtain.setData(bundle);
            this.a.sendMessage(obtain);
        }
    }

    /* compiled from: RewardCampaignsResourceManager */
    private static final class g implements g.d {
        private boolean a = false;
        private Context b;
        private String c;
        private String d;
        private String e;
        private CampaignEx f;
        private int g;
        private Handler h;
        private i i;
        private List<CampaignEx> j;
        private long k;

        public g(Context context, String str, String str2, String str3, CampaignEx campaignEx, int i2, Handler handler, i iVar, List<CampaignEx> list) {
            this.b = context;
            this.d = str;
            this.c = str2;
            this.e = str3;
            this.f = campaignEx;
            this.g = i2;
            this.h = handler;
            this.i = iVar;
            this.j = list;
            this.k = System.currentTimeMillis();
        }

        public final void a(boolean z) {
            this.a = z;
        }

        public final void a(String str) {
            com.mbridge.msdk.videocommon.download.i.a().b(str, true);
            long currentTimeMillis = System.currentTimeMillis() - this.k;
            int i2 = this.g;
            if (i2 == 313) {
                Message obtain = Message.obtain();
                obtain.what = 101;
                Bundle bundle = new Bundle();
                bundle.putString(MBridgeConstans.PROPERTIES_UNIT_ID, this.c);
                bundle.putString(MBridgeConstans.PLACEMENT_ID, this.d);
                bundle.putString("request_id", this.e);
                bundle.putString("url", str);
                obtain.setData(bundle);
                this.h.sendMessage(obtain);
            } else if (i2 == 497) {
                Message obtain2 = Message.obtain();
                obtain2.what = 101;
                Bundle bundle2 = new Bundle();
                bundle2.putString(MBridgeConstans.PROPERTIES_UNIT_ID, this.c);
                bundle2.putString(MBridgeConstans.PLACEMENT_ID, this.d);
                bundle2.putString("request_id", this.e);
                bundle2.putString("url", str);
                obtain2.setData(bundle2);
                this.h.sendMessage(obtain2);
                if (this.a) {
                    try {
                        com.mbridge.msdk.foundation.entity.m mVar = new com.mbridge.msdk.foundation.entity.m("2000043", 14, currentTimeMillis + "", str, this.f.getId(), this.c, "", "1");
                        mVar.k(this.f.getRequestId());
                        mVar.l(this.f.getRequestIdNotice());
                        mVar.n(this.f.getId());
                        mVar.b(this.f.getAdSpaceT());
                        if (this.f.getAdType() == 287) {
                            mVar.h(MBridgeConstans.ORIGINAL_VIEW_TYPE_SINGLE_STR_3);
                        } else if (this.f.getAdType() == 94) {
                            mVar.h("1");
                        }
                        com.mbridge.msdk.foundation.same.report.b.a(mVar, this.c);
                    } catch (Exception e2) {
                        if (MBridgeConstans.DEBUG) {
                            q.d("RewardCampaignsResourceManager", e2.getLocalizedMessage());
                        }
                    }
                }
            } else if (i2 == 859) {
                Message obtain3 = Message.obtain();
                obtain3.what = 103;
                Bundle bundle3 = new Bundle();
                bundle3.putString(MBridgeConstans.PROPERTIES_UNIT_ID, this.c);
                bundle3.putString(MBridgeConstans.PLACEMENT_ID, this.d);
                bundle3.putString("request_id", this.e);
                obtain3.setData(bundle3);
                this.h.sendMessage(obtain3);
                i iVar = this.i;
                if (iVar != null) {
                    iVar.a(this.d, this.c, this.e, str);
                }
                try {
                    com.mbridge.msdk.foundation.entity.m mVar2 = new com.mbridge.msdk.foundation.entity.m();
                    mVar2.o("2000045");
                    if (this.b != null) {
                        mVar2.c(com.mbridge.msdk.foundation.tools.m.n(this.b.getApplicationContext()));
                    }
                    mVar2.d(1);
                    if (this.f != null) {
                        mVar2.n(this.f.getId());
                        mVar2.k(this.f.getRequestId());
                        mVar2.l(this.f.getRequestIdNotice());
                    }
                    mVar2.i(str);
                    mVar2.p("");
                    mVar2.m(this.c);
                    p.a((com.mbridge.msdk.foundation.db.f) com.mbridge.msdk.foundation.db.g.a(com.mbridge.msdk.foundation.controller.a.e().g())).a(mVar2);
                } catch (Exception e3) {
                    if (MBridgeConstans.DEBUG) {
                        q.d("RewardCampaignsResourceManager", e3.getLocalizedMessage());
                    }
                }
            }
        }

        public final void a(String str, String str2) {
            com.mbridge.msdk.videocommon.download.i.a().b(str2, false);
            long currentTimeMillis = System.currentTimeMillis() - this.k;
            int i2 = this.g;
            if (i2 == 313) {
                Message obtain = Message.obtain();
                obtain.what = 101;
                Bundle bundle = new Bundle();
                bundle.putString(MBridgeConstans.PROPERTIES_UNIT_ID, this.c);
                bundle.putString(MBridgeConstans.PLACEMENT_ID, this.d);
                bundle.putString("request_id", this.e);
                bundle.putString("url", str2);
                bundle.putString("message", str);
                obtain.setData(bundle);
                this.h.sendMessage(obtain);
            } else if (i2 == 497) {
                Message obtain2 = Message.obtain();
                obtain2.what = 201;
                Bundle bundle2 = new Bundle();
                bundle2.putString(MBridgeConstans.PROPERTIES_UNIT_ID, this.c);
                bundle2.putString(MBridgeConstans.PLACEMENT_ID, this.d);
                bundle2.putString("request_id", this.e);
                bundle2.putString("url", str2);
                bundle2.putString("message", str);
                obtain2.setData(bundle2);
                this.h.sendMessage(obtain2);
                if (this.a) {
                    try {
                        com.mbridge.msdk.foundation.entity.m mVar = new com.mbridge.msdk.foundation.entity.m("2000043", 3, currentTimeMillis + "", str2, this.f.getId(), this.c, "zip download failed", "1");
                        mVar.k(this.f.getRequestId());
                        mVar.l(this.f.getRequestIdNotice());
                        mVar.n(this.f.getId());
                        mVar.b(this.f.getAdSpaceT());
                        if (this.f.getAdType() == 287) {
                            mVar.h(MBridgeConstans.ORIGINAL_VIEW_TYPE_SINGLE_STR_3);
                        } else if (this.f.getAdType() == 94) {
                            mVar.h("1");
                        }
                        com.mbridge.msdk.foundation.same.report.b.a(mVar, this.c);
                    } catch (Exception e2) {
                        if (MBridgeConstans.DEBUG) {
                            q.d("RewardCampaignsResourceManager", e2.getLocalizedMessage());
                        }
                    }
                }
            } else if (i2 == 859) {
                Message obtain3 = Message.obtain();
                obtain3.what = 203;
                Bundle bundle3 = new Bundle();
                bundle3.putString(MBridgeConstans.PROPERTIES_UNIT_ID, this.c);
                bundle3.putString(MBridgeConstans.PLACEMENT_ID, this.d);
                bundle3.putString("request_id", this.e);
                bundle3.putString("url", str2);
                bundle3.putString("message", str);
                obtain3.setData(bundle3);
                this.h.sendMessage(obtain3);
                i iVar = this.i;
                if (iVar != null) {
                    iVar.a(this.d, this.c, this.e, str2, str);
                }
                try {
                    com.mbridge.msdk.foundation.entity.m mVar2 = new com.mbridge.msdk.foundation.entity.m();
                    mVar2.o("2000045");
                    if (this.b != null) {
                        mVar2.c(com.mbridge.msdk.foundation.tools.m.n(this.b.getApplicationContext()));
                    }
                    mVar2.d(3);
                    if (this.f != null) {
                        mVar2.n(this.f.getId());
                        mVar2.k(this.f.getRequestId());
                        mVar2.l(this.f.getRequestIdNotice());
                    }
                    mVar2.i(str2);
                    mVar2.p(str);
                    mVar2.m(this.c);
                    p.a((com.mbridge.msdk.foundation.db.f) com.mbridge.msdk.foundation.db.g.a(com.mbridge.msdk.foundation.controller.a.e().g())).a(mVar2);
                } catch (Exception e3) {
                    if (MBridgeConstans.DEBUG) {
                        q.d("RewardCampaignsResourceManager", e3.getLocalizedMessage());
                    }
                }
            }
        }
    }

    /* compiled from: RewardCampaignsResourceManager */
    private static final class d implements g.b {
        private boolean a = false;
        private int b;
        private final String c;
        private final String d;
        private final String e;
        private CampaignEx f;
        private i g;
        private Handler h;
        private List<CampaignEx> i;
        private final long j;

        public d(int i2, String str, String str2, String str3, CampaignEx campaignEx, i iVar, Handler handler, List<CampaignEx> list) {
            this.b = i2;
            this.c = str;
            this.d = str2;
            this.e = str3;
            this.f = campaignEx;
            this.g = iVar;
            this.h = handler;
            this.i = list;
            this.j = System.currentTimeMillis();
        }

        public final void a(boolean z) {
            this.a = z;
        }

        public final void a(String str) {
            com.mbridge.msdk.videocommon.download.i.a().b(str, true);
            int i2 = this.b;
            if (i2 == 313) {
                Message obtain = Message.obtain();
                obtain.what = 101;
                Bundle bundle = new Bundle();
                bundle.putString(MBridgeConstans.PROPERTIES_UNIT_ID, this.d);
                bundle.putString(MBridgeConstans.PLACEMENT_ID, this.c);
                bundle.putString("request_id", this.e);
                bundle.putString("url", str);
                obtain.setData(bundle);
                this.h.sendMessage(obtain);
            } else if (i2 == 497) {
                Message obtain2 = Message.obtain();
                obtain2.what = 101;
                Bundle bundle2 = new Bundle();
                bundle2.putString(MBridgeConstans.PROPERTIES_UNIT_ID, this.d);
                bundle2.putString(MBridgeConstans.PLACEMENT_ID, this.c);
                bundle2.putString("request_id", this.e);
                bundle2.putString("url", str);
                obtain2.setData(bundle2);
                this.h.sendMessage(obtain2);
                if (this.a) {
                    long currentTimeMillis = System.currentTimeMillis() - this.j;
                    try {
                        com.mbridge.msdk.foundation.entity.m mVar = new com.mbridge.msdk.foundation.entity.m("2000043", 20, currentTimeMillis + "", str, this.f.getId(), this.d, "", "2");
                        mVar.k(this.f.getRequestId());
                        mVar.l(this.f.getRequestIdNotice());
                        mVar.n(this.f.getId());
                        mVar.b(this.f.getAdSpaceT());
                        if (this.f.getAdType() == 287) {
                            mVar.h(MBridgeConstans.ORIGINAL_VIEW_TYPE_SINGLE_STR_3);
                        } else if (this.f.getAdType() == 94) {
                            mVar.h("1");
                        }
                        com.mbridge.msdk.foundation.same.report.b.a(mVar, this.d);
                    } catch (Exception e2) {
                        if (MBridgeConstans.DEBUG) {
                            q.d("RewardCampaignsResourceManager", e2.getLocalizedMessage());
                        }
                    }
                }
            } else if (i2 == 859) {
                Message obtain3 = Message.obtain();
                obtain3.what = 105;
                Bundle bundle3 = new Bundle();
                bundle3.putString(MBridgeConstans.PROPERTIES_UNIT_ID, this.d);
                bundle3.putString(MBridgeConstans.PLACEMENT_ID, this.c);
                bundle3.putString("request_id", this.e);
                obtain3.setData(bundle3);
                this.h.sendMessage(obtain3);
                i iVar = this.g;
                if (iVar != null) {
                    iVar.a(this.c, this.d, this.e, str);
                }
            }
        }

        public final void a(String str, String str2) {
            com.mbridge.msdk.videocommon.download.i.a().b(str, false);
            int i2 = this.b;
            if (i2 == 313) {
                Message obtain = Message.obtain();
                obtain.what = 201;
                Bundle bundle = new Bundle();
                bundle.putString(MBridgeConstans.PROPERTIES_UNIT_ID, this.d);
                bundle.putString(MBridgeConstans.PLACEMENT_ID, this.c);
                bundle.putString("request_id", this.e);
                bundle.putString("url", str);
                bundle.putString("message", str2);
                obtain.setData(bundle);
                this.h.sendMessage(obtain);
            } else if (i2 == 497) {
                Message obtain2 = Message.obtain();
                obtain2.what = 201;
                Bundle bundle2 = new Bundle();
                bundle2.putString(MBridgeConstans.PROPERTIES_UNIT_ID, this.d);
                bundle2.putString(MBridgeConstans.PLACEMENT_ID, this.c);
                bundle2.putString("request_id", this.e);
                bundle2.putString("url", str);
                bundle2.putString("message", str2);
                obtain2.setData(bundle2);
                this.h.sendMessage(obtain2);
                if (this.a) {
                    long currentTimeMillis = System.currentTimeMillis() - this.j;
                    try {
                        com.mbridge.msdk.foundation.entity.m mVar = new com.mbridge.msdk.foundation.entity.m("2000043", 21, currentTimeMillis + "", str, this.f.getId(), this.d, "url download failed", "2");
                        mVar.k(this.f.getRequestId());
                        mVar.l(this.f.getRequestIdNotice());
                        mVar.n(this.f.getId());
                        mVar.b(this.f.getAdSpaceT());
                        if (this.f.getAdType() == 287) {
                            mVar.h(MBridgeConstans.ORIGINAL_VIEW_TYPE_SINGLE_STR_3);
                        } else if (this.f.getAdType() == 94) {
                            mVar.h("1");
                        }
                        com.mbridge.msdk.foundation.same.report.b.a(mVar, this.d);
                    } catch (Exception e2) {
                        if (MBridgeConstans.DEBUG) {
                            q.d("RewardCampaignsResourceManager", e2.getLocalizedMessage());
                        }
                    }
                }
            } else if (i2 == 859) {
                Message obtain3 = Message.obtain();
                obtain3.what = 205;
                Bundle bundle3 = new Bundle();
                bundle3.putString(MBridgeConstans.PROPERTIES_UNIT_ID, this.d);
                bundle3.putString(MBridgeConstans.PLACEMENT_ID, this.c);
                bundle3.putString("request_id", this.e);
                bundle3.putString("message", str2);
                obtain3.setData(bundle3);
                this.h.sendMessage(obtain3);
                i iVar = this.g;
                if (iVar != null) {
                    iVar.a(this.c, this.d, this.e, str, str2);
                }
            }
        }
    }

    /* compiled from: RewardCampaignsResourceManager */
    private static final class h extends Handler {
        private Context a;
        private ConcurrentHashMap<String, C0099c> b = new ConcurrentHashMap<>();
        private ConcurrentHashMap<String, List<CampaignEx>> c = new ConcurrentHashMap<>();

        public h(Looper looper) {
            super(looper);
        }

        public final void a(String str, String str2, String str3, C0099c cVar) {
            ConcurrentHashMap<String, C0099c> concurrentHashMap = this.b;
            concurrentHashMap.put(str2 + "_" + str3, cVar);
        }

        public final void a(Context context) {
            this.a = context;
        }

        public final void a(String str, List<CampaignEx> list) {
            this.c.put(str, list);
        }

        public final void handleMessage(Message message) {
            String str;
            Message message2 = message;
            Bundle data = message.getData();
            String string = data.getString(MBridgeConstans.PLACEMENT_ID);
            String string2 = data.getString(MBridgeConstans.PROPERTIES_UNIT_ID);
            String string3 = data.getString("request_id");
            String str2 = string2 + "_" + string3;
            a aVar = (a) c.c.get(str2);
            C0099c cVar = this.b.get(str2);
            List list = this.c.get(str2);
            int i = message2.what;
            if (i != 0 && i != 1) {
                switch (i) {
                    case 100:
                    case 101:
                    case 102:
                    case 103:
                    case 104:
                    case 105:
                        break;
                    default:
                        switch (i) {
                            case 200:
                            case 201:
                            case 203:
                            case 205:
                                if (aVar != null && cVar != null) {
                                    String string4 = data.getString("message");
                                    if (string4 == null) {
                                        string4 = "";
                                    }
                                    StringBuilder sb = new StringBuilder();
                                    sb.append("resource download failed ");
                                    int i2 = message2.what;
                                    sb.append(i2 != 200 ? i2 != 201 ? i2 != 203 ? i2 != 205 ? "unknown" : "tpl" : "temp" : "zip/html" : "video");
                                    sb.append(" ");
                                    sb.append(string4);
                                    String sb2 = sb.toString();
                                    CampaignEx campaignEx = null;
                                    if (aVar.h != null && aVar.h.size() > 0) {
                                        campaignEx = aVar.h.get(0);
                                    }
                                    try {
                                        if (!aVar.a || aVar.i == null) {
                                            str = "resource download failed ";
                                            try {
                                                if (com.mbridge.msdk.videocommon.download.c.getInstance().a(94, aVar.e, aVar.b, aVar.d, aVar.a, aVar.c, list)) {
                                                    cVar.a(string, string2, string3, aVar.h);
                                                } else {
                                                    if (!(campaignEx == null || campaignEx.getRsIgnoreCheckRule() == null || campaignEx.getRsIgnoreCheckRule().size() <= 0)) {
                                                        int i3 = message2.what;
                                                        if (i3 != 200) {
                                                            if (i3 != 201) {
                                                                if (i3 != 203) {
                                                                    if (i3 == 205) {
                                                                        if (campaignEx.getRsIgnoreCheckRule().contains(3)) {
                                                                            return;
                                                                        }
                                                                    }
                                                                } else if (campaignEx.getRsIgnoreCheckRule().contains(1)) {
                                                                    return;
                                                                }
                                                            } else if (campaignEx.getRsIgnoreCheckRule().contains(2)) {
                                                                return;
                                                            }
                                                        } else if (campaignEx.getRsIgnoreCheckRule().contains(0)) {
                                                            return;
                                                        }
                                                    }
                                                    cVar.a(string, string2, string3, aVar.h, sb2);
                                                }
                                                this.b.remove(str2);
                                                c.c.remove(str2);
                                                this.c.remove(str2);
                                                return;
                                            } catch (Exception e) {
                                                e = e;
                                                cVar.a(string, string2, string3, aVar.h, str + e.getMessage());
                                                return;
                                            }
                                        } else if (aVar.c == 1) {
                                            if (!(campaignEx == null || campaignEx.getRsIgnoreCheckRule() == null || campaignEx.getRsIgnoreCheckRule().size() <= 0)) {
                                                int i4 = message2.what;
                                                if (i4 != 200) {
                                                    if (i4 != 201) {
                                                        if (i4 != 203) {
                                                            if (i4 == 205) {
                                                                if (!campaignEx.getRsIgnoreCheckRule().contains(3)) {
                                                                    if (aVar.h != null && aVar.h.size() > 0) {
                                                                        CampaignEx campaignEx2 = aVar.h.get(0);
                                                                        if (campaignEx2.getCMPTEntryUrl().equals(campaignEx2.getendcard_url()) && campaignEx.getRsIgnoreCheckRule().contains(2)) {
                                                                            return;
                                                                        }
                                                                    }
                                                                } else {
                                                                    return;
                                                                }
                                                            }
                                                        } else if (campaignEx.getRsIgnoreCheckRule().contains(1)) {
                                                            return;
                                                        }
                                                    } else if (campaignEx.getRsIgnoreCheckRule().contains(2)) {
                                                        return;
                                                    }
                                                } else if (campaignEx.getRsIgnoreCheckRule().contains(0)) {
                                                    return;
                                                }
                                            }
                                            cVar.a(string, string2, string3, aVar.h, sb2);
                                            this.b.remove(str2);
                                            c.c.remove(str2);
                                            this.c.remove(str2);
                                            return;
                                        } else {
                                            String string5 = data.getString("url");
                                            int i5 = message2.what;
                                            if (i5 != 200) {
                                                if (i5 != 201) {
                                                    if (i5 != 203) {
                                                        if (i5 == 205) {
                                                            if (campaignEx == null || campaignEx.getRsIgnoreCheckRule() == null || campaignEx.getRsIgnoreCheckRule().size() <= 0 || !campaignEx.getRsIgnoreCheckRule().contains(3)) {
                                                                aVar.i.clear();
                                                                c.c.remove(str2);
                                                                c.c.put(str2, aVar);
                                                            } else {
                                                                q.b("RewardCampaignsResourceManager", "Is TPL but download BTL Template fail but hit ignoreCheckRule");
                                                                return;
                                                            }
                                                        }
                                                    } else if (campaignEx == null || campaignEx.getRsIgnoreCheckRule() == null || campaignEx.getRsIgnoreCheckRule().size() <= 0 || !campaignEx.getRsIgnoreCheckRule().contains(1)) {
                                                        for (int i6 = 0; i6 < aVar.i.size(); i6++) {
                                                            CampaignEx campaignEx3 = aVar.i.get(i6);
                                                            if (campaignEx3.getRewardTemplateMode() != null && campaignEx3.getRewardTemplateMode().e().equals(string5)) {
                                                                aVar.i.remove(i6);
                                                            }
                                                        }
                                                        c.c.remove(str2);
                                                        c.c.put(str2, aVar);
                                                    } else {
                                                        q.b("RewardCampaignsResourceManager", "Is TPL but download template fail but hit ignoreCheckRule");
                                                        return;
                                                    }
                                                } else if (campaignEx == null || campaignEx.getRsIgnoreCheckRule() == null || campaignEx.getRsIgnoreCheckRule().size() <= 0 || !campaignEx.getRsIgnoreCheckRule().contains(2)) {
                                                    for (int i7 = 0; i7 < aVar.i.size(); i7++) {
                                                        CampaignEx campaignEx4 = aVar.i.get(i7);
                                                        if (campaignEx4.getRewardTemplateMode() != null && campaignEx4.getRewardTemplateMode().d().equals(string5)) {
                                                            aVar.i.remove(i7);
                                                        }
                                                        if (campaignEx4.getendcard_url().equals(string5)) {
                                                            aVar.i.remove(i7);
                                                        }
                                                    }
                                                    c.c.remove(str2);
                                                    c.c.put(str2, aVar);
                                                } else {
                                                    q.b("RewardCampaignsResourceManager", "Is TPL but download endcard fail but hit ignoreCheckRule");
                                                    return;
                                                }
                                            } else if (campaignEx == null || campaignEx.getRsIgnoreCheckRule() == null || campaignEx.getRsIgnoreCheckRule().size() <= 0 || !campaignEx.getRsIgnoreCheckRule().contains(0)) {
                                                for (int i8 = 0; i8 < aVar.i.size(); i8++) {
                                                    if (aVar.i.get(i8).getVideoUrlEncode().equals(string5)) {
                                                        aVar.i.remove(i8);
                                                    }
                                                }
                                                c.c.remove(str2);
                                                c.c.put(str2, aVar);
                                            } else {
                                                q.b("RewardCampaignsResourceManager", "Is TPL but  video download fail but hit ignoreCheckRule");
                                                return;
                                            }
                                            com.mbridge.msdk.videocommon.download.c instance = com.mbridge.msdk.videocommon.download.c.getInstance();
                                            String str3 = aVar.e;
                                            String str4 = "resource download failed ";
                                            try {
                                                if (instance.a(94, str3, aVar.b, aVar.d, aVar.a, aVar.c, list)) {
                                                    cVar.a(string, string2, string3, aVar.h);
                                                    this.b.remove(str2);
                                                    c.c.remove(str2);
                                                    this.c.remove(str2);
                                                    return;
                                                } else if (aVar.i.size() == 0) {
                                                    str3 = str4;
                                                    try {
                                                        cVar.a(string, string2, string3, aVar.h, sb2);
                                                        this.b.remove(str2);
                                                        c.c.remove(str2);
                                                        this.c.remove(str2);
                                                        return;
                                                    } catch (Exception e2) {
                                                        e = e2;
                                                        str = str3;
                                                        cVar.a(string, string2, string3, aVar.h, str + e.getMessage());
                                                        return;
                                                    }
                                                } else {
                                                    return;
                                                }
                                            } catch (Exception e3) {
                                                e = e3;
                                                str = str4;
                                                cVar.a(string, string2, string3, aVar.h, str + e.getMessage());
                                                return;
                                            }
                                        }
                                    } catch (Exception e4) {
                                        e = e4;
                                        str = "resource download failed ";
                                        cVar.a(string, string2, string3, aVar.h, str + e.getMessage());
                                        return;
                                    }
                                } else {
                                    return;
                                }
                            case 202:
                            case 204:
                                break;
                            default:
                                return;
                        }
                }
                boolean z = false;
                if (aVar != null && cVar != null) {
                    try {
                        z = com.mbridge.msdk.videocommon.download.c.getInstance().a(94, aVar.e, aVar.b, aVar.d, aVar.a, aVar.c, list);
                    } catch (Exception e5) {
                        if (MBridgeConstans.DEBUG) {
                            q.d("RewardCampaignsResourceManager", e5.getLocalizedMessage());
                        }
                    }
                    if (z) {
                        cVar.a(string, string2, string3, aVar.h);
                        this.b.remove(str2);
                        c.c.remove(str2);
                        this.c.remove(str2);
                    }
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x003c, code lost:
        return;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x005a */
    /* JADX WARNING: Missing exception handler attribute for start block: B:26:0x00d4 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:36:0x0151 */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x006a  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0175  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0182 A[Catch:{ Exception -> 0x01e6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0188 A[Catch:{ Exception -> 0x01e6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x01ec  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x01f7  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void a(boolean r24, android.os.Handler r25, boolean r26, boolean r27, com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView r28, java.lang.String r29, int r30, com.mbridge.msdk.foundation.entity.CampaignEx r31, java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx> r32, java.lang.String r33, java.lang.String r34, java.lang.String r35, java.lang.String r36, java.lang.String r37, com.mbridge.msdk.videocommon.d.c r38, com.mbridge.msdk.reward.adapter.c.j r39) {
        /*
            r23 = this;
            r15 = r29
            r13 = r31
            r0 = r32
            r14 = r35
            r12 = r36
            monitor-enter(r23)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x020d }
            r1.<init>()     // Catch:{ all -> 0x020d }
            r1.append(r14)     // Catch:{ all -> 0x020d }
            java.lang.String r2 = "_"
            r1.append(r2)     // Catch:{ all -> 0x020d }
            r1.append(r15)     // Catch:{ all -> 0x020d }
            java.lang.String r17 = r1.toString()     // Catch:{ all -> 0x020d }
            long r18 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x020d }
            boolean r1 = com.mbridge.msdk.foundation.tools.u.f((java.lang.String) r29)     // Catch:{ Exception -> 0x01e6 }
            if (r1 == 0) goto L_0x003d
            if (r39 == 0) goto L_0x003b
            r7 = 0
            r1 = r39
            r2 = r17
            r3 = r34
            r4 = r35
            r5 = r36
            r6 = r29
            r1.a(r2, r3, r4, r5, r6, r7)     // Catch:{ Exception -> 0x01e6 }
        L_0x003b:
            monitor-exit(r23)
            return
        L_0x003d:
            com.mbridge.msdk.foundation.controller.a r1 = com.mbridge.msdk.foundation.controller.a.e()     // Catch:{ Exception -> 0x005a }
            android.content.Context r2 = r1.g()     // Catch:{ Exception -> 0x005a }
            java.lang.String r3 = "start preload template "
            long r4 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x005a }
            long r8 = r4 - r18
            r1 = r31
            r4 = r35
            r5 = r27
            r6 = r36
            r7 = r37
            com.mbridge.msdk.reward.b.a.a(r1, r2, r3, r4, r5, r6, r7, r8)     // Catch:{ Exception -> 0x005a }
        L_0x005a:
            com.mbridge.msdk.videocommon.a$a r11 = new com.mbridge.msdk.videocommon.a$a     // Catch:{ Exception -> 0x01e6 }
            r11.<init>()     // Catch:{ Exception -> 0x01e6 }
            com.mbridge.msdk.reward.adapter.c r1 = com.mbridge.msdk.reward.adapter.c.m.a     // Catch:{ Exception -> 0x01e6 }
            r2 = 0
            com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView r1 = r1.a((boolean) r2)     // Catch:{ Exception -> 0x01e6 }
            if (r1 != 0) goto L_0x0175
            r1 = 1
            com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView r2 = new com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView     // Catch:{ Exception -> 0x00f8, all -> 0x007b }
            com.mbridge.msdk.foundation.controller.a r3 = com.mbridge.msdk.foundation.controller.a.e()     // Catch:{ Exception -> 0x00f8, all -> 0x007b }
            android.content.Context r3 = r3.g()     // Catch:{ Exception -> 0x00f8, all -> 0x007b }
            r2.<init>(r3)     // Catch:{ Exception -> 0x00f8, all -> 0x007b }
            r10 = r2
            goto L_0x0176
        L_0x007b:
            r0 = move-exception
            if (r39 == 0) goto L_0x00f6
            r11.a((boolean) r1)     // Catch:{ Exception -> 0x01e6 }
            com.mbridge.msdk.videocommon.download.i r2 = com.mbridge.msdk.videocommon.download.i.a()     // Catch:{ Exception -> 0x01e6 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x01e6 }
            r3.<init>()     // Catch:{ Exception -> 0x01e6 }
            r3.append(r14)     // Catch:{ Exception -> 0x01e6 }
            java.lang.String r4 = "_"
            r3.append(r4)     // Catch:{ Exception -> 0x01e6 }
            r3.append(r12)     // Catch:{ Exception -> 0x01e6 }
            java.lang.String r4 = "_"
            r3.append(r4)     // Catch:{ Exception -> 0x01e6 }
            r3.append(r15)     // Catch:{ Exception -> 0x01e6 }
            java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x01e6 }
            r2.d(r3, r1)     // Catch:{ Exception -> 0x01e6 }
            com.mbridge.msdk.foundation.controller.a r1 = com.mbridge.msdk.foundation.controller.a.e()     // Catch:{ Exception -> 0x00d4 }
            android.content.Context r2 = r1.g()     // Catch:{ Exception -> 0x00d4 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00d4 }
            r1.<init>()     // Catch:{ Exception -> 0x00d4 }
            java.lang.String r3 = "WebView exception: "
            r1.append(r3)     // Catch:{ Exception -> 0x00d4 }
            java.lang.String r0 = r0.getMessage()     // Catch:{ Exception -> 0x00d4 }
            r1.append(r0)     // Catch:{ Exception -> 0x00d4 }
            java.lang.String r3 = r1.toString()     // Catch:{ Exception -> 0x00d4 }
            long r0 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x00d4 }
            long r8 = r0 - r18
            r1 = r31
            r4 = r35
            r5 = r27
            r6 = r36
            r7 = r37
            com.mbridge.msdk.reward.b.a.a(r1, r2, r3, r4, r5, r6, r7, r8)     // Catch:{ Exception -> 0x00d4 }
        L_0x00d4:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x01e6 }
            r0.<init>()     // Catch:{ Exception -> 0x01e6 }
            r0.append(r14)     // Catch:{ Exception -> 0x01e6 }
            java.lang.String r1 = "_"
            r0.append(r1)     // Catch:{ Exception -> 0x01e6 }
            r0.append(r15)     // Catch:{ Exception -> 0x01e6 }
            java.lang.String r2 = r0.toString()     // Catch:{ Exception -> 0x01e6 }
            r1 = r39
            r3 = r34
            r4 = r35
            r5 = r36
            r6 = r29
            r7 = r11
            r1.a(r2, r3, r4, r5, r6, r7)     // Catch:{ Exception -> 0x01e6 }
        L_0x00f6:
            monitor-exit(r23)
            return
        L_0x00f8:
            r0 = move-exception
            if (r39 == 0) goto L_0x0173
            r11.a((boolean) r1)     // Catch:{ Exception -> 0x01e6 }
            com.mbridge.msdk.videocommon.download.i r2 = com.mbridge.msdk.videocommon.download.i.a()     // Catch:{ Exception -> 0x01e6 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x01e6 }
            r3.<init>()     // Catch:{ Exception -> 0x01e6 }
            r3.append(r14)     // Catch:{ Exception -> 0x01e6 }
            java.lang.String r4 = "_"
            r3.append(r4)     // Catch:{ Exception -> 0x01e6 }
            r3.append(r12)     // Catch:{ Exception -> 0x01e6 }
            java.lang.String r4 = "_"
            r3.append(r4)     // Catch:{ Exception -> 0x01e6 }
            r3.append(r15)     // Catch:{ Exception -> 0x01e6 }
            java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x01e6 }
            r2.d(r3, r1)     // Catch:{ Exception -> 0x01e6 }
            com.mbridge.msdk.foundation.controller.a r1 = com.mbridge.msdk.foundation.controller.a.e()     // Catch:{ Exception -> 0x0151 }
            android.content.Context r2 = r1.g()     // Catch:{ Exception -> 0x0151 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0151 }
            r1.<init>()     // Catch:{ Exception -> 0x0151 }
            java.lang.String r3 = "WebView exception: "
            r1.append(r3)     // Catch:{ Exception -> 0x0151 }
            java.lang.String r0 = r0.getMessage()     // Catch:{ Exception -> 0x0151 }
            r1.append(r0)     // Catch:{ Exception -> 0x0151 }
            java.lang.String r3 = r1.toString()     // Catch:{ Exception -> 0x0151 }
            long r0 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x0151 }
            long r8 = r0 - r18
            r1 = r31
            r4 = r35
            r5 = r27
            r6 = r36
            r7 = r37
            com.mbridge.msdk.reward.b.a.a(r1, r2, r3, r4, r5, r6, r7, r8)     // Catch:{ Exception -> 0x0151 }
        L_0x0151:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x01e6 }
            r0.<init>()     // Catch:{ Exception -> 0x01e6 }
            r0.append(r14)     // Catch:{ Exception -> 0x01e6 }
            java.lang.String r1 = "_"
            r0.append(r1)     // Catch:{ Exception -> 0x01e6 }
            r0.append(r15)     // Catch:{ Exception -> 0x01e6 }
            java.lang.String r2 = r0.toString()     // Catch:{ Exception -> 0x01e6 }
            r1 = r39
            r3 = r34
            r4 = r35
            r5 = r36
            r6 = r29
            r7 = r11
            r1.a(r2, r3, r4, r5, r6, r7)     // Catch:{ Exception -> 0x01e6 }
        L_0x0173:
            monitor-exit(r23)
            return
        L_0x0175:
            r10 = r1
        L_0x0176:
            r11.a((com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView) r10)     // Catch:{ Exception -> 0x01e6 }
            r1 = 0
            if (r0 == 0) goto L_0x0188
            int r2 = r32.size()     // Catch:{ Exception -> 0x01e6 }
            if (r2 <= 0) goto L_0x0188
            com.mbridge.msdk.video.signal.a.j r2 = new com.mbridge.msdk.video.signal.a.j     // Catch:{ Exception -> 0x01e6 }
            r2.<init>(r1, r13, r0)     // Catch:{ Exception -> 0x01e6 }
            goto L_0x018d
        L_0x0188:
            com.mbridge.msdk.video.signal.a.j r2 = new com.mbridge.msdk.video.signal.a.j     // Catch:{ Exception -> 0x01e6 }
            r2.<init>(r1, r13)     // Catch:{ Exception -> 0x01e6 }
        L_0x018d:
            r1 = r30
            r9 = r2
            r9.a((int) r1)     // Catch:{ Exception -> 0x01e6 }
            r9.a((java.lang.String) r14)     // Catch:{ Exception -> 0x01e6 }
            r1 = r38
            r9.a((com.mbridge.msdk.videocommon.d.c) r1)     // Catch:{ Exception -> 0x01e6 }
            r1 = r24
            r9.d((boolean) r1)     // Catch:{ Exception -> 0x01e6 }
            com.mbridge.msdk.reward.adapter.c$k r8 = new com.mbridge.msdk.reward.adapter.c$k     // Catch:{ Exception -> 0x01e6 }
            r3 = 0
            r1 = r8
            r2 = r25
            r4 = r26
            r5 = r27
            r6 = r36
            r7 = r39
            r20 = r8
            r8 = r28
            r21 = r9
            r9 = r29
            r22 = r10
            r10 = r34
            r16 = r11
            r11 = r35
            r12 = r16
            r13 = r31
            r14 = r32
            r15 = r18
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15)     // Catch:{ Exception -> 0x01e2 }
            r0 = r20
            r1 = r22
            r1.setWebViewListener(r0)     // Catch:{ Exception -> 0x01e2 }
            r2 = r21
            r1.setObject(r2)     // Catch:{ Exception -> 0x01e2 }
            r0 = r33
            r1.loadUrl(r0)     // Catch:{ Exception -> 0x01e2 }
            r5 = r36
            r1.setRid(r5)     // Catch:{ Exception -> 0x01e0 }
            goto L_0x020b
        L_0x01e0:
            r0 = move-exception
            goto L_0x01e8
        L_0x01e2:
            r0 = move-exception
            r5 = r36
            goto L_0x01e8
        L_0x01e6:
            r0 = move-exception
            r5 = r12
        L_0x01e8:
            boolean r1 = com.mbridge.msdk.MBridgeConstans.DEBUG     // Catch:{ all -> 0x020d }
            if (r1 == 0) goto L_0x01f5
            java.lang.String r1 = "RewardCampaignsResourceManager"
            java.lang.String r2 = r0.getLocalizedMessage()     // Catch:{ all -> 0x020d }
            com.mbridge.msdk.foundation.tools.q.d(r1, r2)     // Catch:{ all -> 0x020d }
        L_0x01f5:
            if (r39 == 0) goto L_0x020b
            r7 = 0
            java.lang.String r8 = r0.getLocalizedMessage()     // Catch:{ all -> 0x020d }
            r1 = r39
            r2 = r17
            r3 = r34
            r4 = r35
            r5 = r36
            r6 = r29
            r1.a(r2, r3, r4, r5, r6, r7, r8)     // Catch:{ all -> 0x020d }
        L_0x020b:
            monitor-exit(r23)
            return
        L_0x020d:
            r0 = move-exception
            monitor-exit(r23)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.reward.adapter.c.a(boolean, android.os.Handler, boolean, boolean, com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView, java.lang.String, int, com.mbridge.msdk.foundation.entity.CampaignEx, java.util.List, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, com.mbridge.msdk.videocommon.d.c, com.mbridge.msdk.reward.adapter.c$j):void");
    }

    /* compiled from: RewardCampaignsResourceManager */
    private static class k extends com.mbridge.msdk.mbsignalcommon.b.b {
        private Handler a;
        private Runnable b;
        private final boolean c;
        private final boolean d;
        private String e;
        private final j f;
        private final WindVaneWebView g;
        private final String h;
        private final String i;
        private final String j;
        private final a.C0105a k;
        private final CampaignEx l;
        private List<CampaignEx> m;
        private long n;
        private boolean o;
        private boolean p;
        private final Runnable q;
        private final Runnable r;

        public k(Handler handler, Runnable runnable, boolean z, boolean z2, String str, j jVar, WindVaneWebView windVaneWebView, String str2, String str3, String str4, a.C0105a aVar, CampaignEx campaignEx, List<CampaignEx> list, long j2) {
            Handler handler2 = handler;
            this.a = handler2;
            this.b = runnable;
            this.c = z;
            this.d = z2;
            this.e = str;
            this.f = jVar;
            this.g = windVaneWebView;
            this.h = str2;
            this.i = str4;
            this.j = str3;
            this.k = aVar;
            this.l = campaignEx;
            this.m = list;
            this.n = j2;
            final j jVar2 = jVar;
            AnonymousClass1 r14 = r0;
            final a.C0105a aVar2 = aVar;
            final String str5 = str4;
            final String str6 = str;
            final String str7 = str2;
            final CampaignEx campaignEx2 = campaignEx;
            final boolean z3 = z2;
            final long j3 = j2;
            final String str8 = str3;
            AnonymousClass1 r0 = new Runnable() {
                public final void run() {
                    WindVaneWebView a2;
                    a.C0105a aVar;
                    if (!(jVar2 == null || (aVar = aVar2) == null)) {
                        aVar.a(true);
                        com.mbridge.msdk.videocommon.download.i a3 = com.mbridge.msdk.videocommon.download.i.a();
                        a3.d(str5 + "_" + str6 + "_" + str7, true);
                        try {
                            com.mbridge.msdk.reward.b.a.a(campaignEx2, com.mbridge.msdk.foundation.controller.a.e().g(), "WebView onPageFinish timeout exception after 5s", str5, z3, str6, campaignEx2.getRequestIdNotice(), System.currentTimeMillis() - j3);
                        } catch (Exception unused) {
                        }
                        j jVar = jVar2;
                        jVar.a(str5 + "_" + str7, str8, str5, str6, str7, aVar2);
                    }
                    a.C0105a aVar2 = aVar2;
                    if (aVar2 != null && (a2 = aVar2.a()) != null) {
                        try {
                            a2.release();
                        } catch (Exception unused2) {
                        }
                    }
                }
            };
            this.r = r14;
            this.q = new Runnable() {
                public final void run() {
                    WindVaneWebView a2;
                    a.C0105a aVar;
                    if (!(jVar2 == null || (aVar = aVar2) == null)) {
                        aVar.a(true);
                        com.mbridge.msdk.videocommon.download.i a3 = com.mbridge.msdk.videocommon.download.i.a();
                        a3.d(str5 + "_" + str6 + "_" + str7, true);
                        try {
                            com.mbridge.msdk.reward.b.a.a(campaignEx2, com.mbridge.msdk.foundation.controller.a.e().g(), "WebView readyState timeout exception after 5s", str5, z3, str6, campaignEx2.getRequestIdNotice(), System.currentTimeMillis() - j3);
                        } catch (Exception unused) {
                        }
                        j jVar = jVar2;
                        jVar.a(str5 + "_" + str7, str8, str5, str6, str7, aVar2);
                    }
                    a.C0105a aVar2 = aVar2;
                    if (aVar2 != null && (a2 = aVar2.a()) != null) {
                        try {
                            a2.release();
                        } catch (Exception unused2) {
                        }
                    }
                }
            };
            if (handler2 != null) {
                handler2.postDelayed(this.r, DefaultRenderersFactory.DEFAULT_ALLOWED_VIDEO_JOINING_TIME_MS);
            }
        }

        public final void a(WebView webView, int i2) {
            Handler handler;
            Runnable runnable;
            Runnable runnable2;
            super.a(webView, i2);
            Handler handler2 = this.a;
            if (!(handler2 == null || (runnable2 = this.q) == null)) {
                handler2.removeCallbacks(runnable2);
            }
            Handler handler3 = this.a;
            if (!(handler3 == null || (runnable = this.r) == null)) {
                handler3.removeCallbacks(runnable);
            }
            if (!this.p) {
                try {
                    com.mbridge.msdk.reward.b.a.a(this.l, com.mbridge.msdk.foundation.controller.a.e().g(), "preload temp readState: " + i2, this.i, this.d, this.e, this.l.getRequestIdNotice(), System.currentTimeMillis() - this.n);
                } catch (Exception unused) {
                }
                String str = this.i + "_" + this.h;
                if (i2 == 1) {
                    Runnable runnable3 = this.b;
                    if (!(runnable3 == null || (handler = this.a) == null)) {
                        handler.removeCallbacks(runnable3);
                    }
                    com.mbridge.msdk.videocommon.download.i.a().d(this.i + "_" + this.e + "_" + this.h, true);
                    a.C0105a aVar = this.k;
                    if (aVar != null) {
                        aVar.a(true);
                    }
                    if (this.c) {
                        if (this.d) {
                            com.mbridge.msdk.videocommon.a.a(287, this.l.getRequestIdNotice(), this.k);
                        } else {
                            com.mbridge.msdk.videocommon.a.b(287, this.l.getRequestIdNotice(), this.k);
                        }
                    } else if (this.d) {
                        com.mbridge.msdk.videocommon.a.a(94, this.l.getRequestIdNotice(), this.k);
                    } else {
                        com.mbridge.msdk.videocommon.a.b(94, this.l.getRequestIdNotice(), this.k);
                    }
                    j jVar = this.f;
                    if (jVar != null) {
                        jVar.a(str, this.j, this.i, this.e, this.h, this.k);
                    }
                } else {
                    j jVar2 = this.f;
                    if (jVar2 != null) {
                        jVar2.a(str, this.j, this.i, this.e, this.h, this.k, "state " + i2);
                    }
                }
                this.p = true;
            }
        }

        public final void a(WebView webView, int i2, String str, String str2) {
            super.a(webView, i2, str, str2);
            com.mbridge.msdk.videocommon.download.i.a().d(this.i + "_" + this.e + "_" + this.h, false);
            try {
                com.mbridge.msdk.reward.b.a.a(this.l, com.mbridge.msdk.foundation.controller.a.e().g(), "WebView onReceivedError exception: " + str, this.i, this.d, this.e, this.l.getRequestIdNotice(), System.currentTimeMillis() - this.n);
            } catch (Exception unused) {
            }
            Handler handler = this.a;
            if (handler != null) {
                if (this.q != null) {
                    handler.removeCallbacks(this.r);
                }
                Runnable runnable = this.q;
                if (runnable != null) {
                    this.a.removeCallbacks(runnable);
                }
            }
            try {
                String str3 = this.i + "_" + this.h;
                if (this.k != null) {
                    this.k.a(false);
                }
                if (this.f != null) {
                    this.f.a(str3, this.j, this.i, this.e, str2, this.k, str);
                }
            } catch (Exception e2) {
                if (MBridgeConstans.DEBUG) {
                    q.d("WindVaneWebView", e2.getLocalizedMessage());
                }
            }
        }

        public final void a(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            super.a(webView, sslErrorHandler, sslError);
            com.mbridge.msdk.videocommon.download.i.a().d(this.i + "_" + this.e + "_" + this.h, false);
            try {
                CampaignEx campaignEx = this.l;
                Context g2 = com.mbridge.msdk.foundation.controller.a.e().g();
                StringBuilder sb = new StringBuilder();
                sb.append("WebView onReceivedSslError exception: ");
                sb.append(sslError == null ? "SSLError" : Integer.toString(sslError.getPrimaryError()));
                com.mbridge.msdk.reward.b.a.a(campaignEx, g2, sb.toString(), this.i, this.d, this.e, this.l.getRequestIdNotice(), System.currentTimeMillis() - this.n);
            } catch (Exception unused) {
            }
            Handler handler = this.a;
            if (handler != null) {
                if (this.q != null) {
                    handler.removeCallbacks(this.r);
                }
                Runnable runnable = this.q;
                if (runnable != null) {
                    this.a.removeCallbacks(runnable);
                }
            }
            try {
                String str = this.i + "_" + this.h;
                if (this.k != null) {
                    this.k.a(false);
                }
                if (this.f != null) {
                    this.f.a(str, this.j, this.i, this.e, this.h, this.k, sslError == null ? "" : Integer.toString(sslError.getPrimaryError()));
                }
            } catch (Exception e2) {
                if (MBridgeConstans.DEBUG) {
                    q.d("WindVaneWebView", e2.getLocalizedMessage());
                }
            }
        }

        public final void a(WebView webView, String str) {
            Runnable runnable;
            Handler handler;
            Runnable runnable2;
            super.a(webView, str);
            Handler handler2 = this.a;
            if (!(handler2 == null || (runnable2 = this.r) == null)) {
                handler2.removeCallbacks(runnable2);
            }
            if (!this.o) {
                try {
                    com.mbridge.msdk.reward.b.a.a(this.l, com.mbridge.msdk.foundation.controller.a.e().g(), "preload temp onPageFinish", this.i, this.d, this.e, this.l.getRequestIdNotice(), System.currentTimeMillis() - this.n);
                } catch (Exception unused) {
                }
                if (!str.contains("wfr=1")) {
                    String str2 = this.i + "_" + this.h;
                    com.mbridge.msdk.videocommon.download.i.a().d(this.i + "_" + this.e + "_" + this.h, true);
                    Runnable runnable3 = this.b;
                    if (!(runnable3 == null || (handler = this.a) == null)) {
                        handler.removeCallbacks(runnable3);
                    }
                    a.C0105a aVar = this.k;
                    if (aVar != null) {
                        aVar.a(true);
                    }
                    if (this.c) {
                        if (this.l.isBidCampaign()) {
                            com.mbridge.msdk.videocommon.a.a(287, this.l.getRequestIdNotice(), this.k);
                        } else {
                            com.mbridge.msdk.videocommon.a.b(287, this.l.getRequestIdNotice(), this.k);
                        }
                    } else if (this.l.isBidCampaign()) {
                        com.mbridge.msdk.videocommon.a.a(94, this.l.getRequestIdNotice(), this.k);
                    } else {
                        com.mbridge.msdk.videocommon.a.b(94, this.l.getRequestIdNotice(), this.k);
                    }
                    j jVar = this.f;
                    if (jVar != null) {
                        jVar.a(str2, this.j, this.i, this.e, this.h, this.k);
                    }
                } else {
                    Handler handler3 = this.a;
                    if (!(handler3 == null || (runnable = this.q) == null)) {
                        handler3.postDelayed(runnable, DefaultRenderersFactory.DEFAULT_ALLOWED_VIDEO_JOINING_TIME_MS);
                    }
                }
                com.mbridge.msdk.mbsignalcommon.windvane.g.a().a(webView);
                this.o = true;
            }
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(13:9|10|11|12|(1:14)|15|(1:37)(3:19|(3:23|(5:26|(4:29|(2:33|69)|34|27)|68|35|24)|67)|36)|38|39|40|41|42|(5:43|44|45|46|47)) */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x01ce, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x01cf, code lost:
        r6 = r14;
        r3 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:?, code lost:
        r42.a(r21, r33, r34, r31, r35, (com.mbridge.msdk.videocommon.a.C0105a) null, r0.getMessage());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x01ef, code lost:
        com.mbridge.msdk.foundation.tools.q.d("RewardCampaignsResourceManager", r0.getLocalizedMessage());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0046, code lost:
        return;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0064 */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0074 A[Catch:{ Exception -> 0x01ce }] */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x00a0 A[Catch:{ Exception -> 0x01ce }] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00fd A[Catch:{ Exception -> 0x01ce }] */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x01d3  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x01ef  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void a(boolean r27, android.os.Handler r28, boolean r29, boolean r30, java.lang.String r31, java.lang.String r32, java.lang.String r33, java.lang.String r34, java.lang.String r35, int r36, com.mbridge.msdk.foundation.entity.CampaignEx r37, java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx> r38, java.lang.String r39, java.lang.String r40, com.mbridge.msdk.videocommon.d.c r41, com.mbridge.msdk.reward.adapter.c.j r42, boolean r43) {
        /*
            r26 = this;
            r1 = r26
            r15 = r31
            r14 = r34
            r0 = r37
            r13 = r38
            r12 = r43
            monitor-enter(r26)
            r1.d = r12     // Catch:{ all -> 0x01fa }
            long r19 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x01fa }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x01fa }
            r2.<init>()     // Catch:{ all -> 0x01fa }
            r2.append(r14)     // Catch:{ all -> 0x01fa }
            java.lang.String r3 = "_"
            r2.append(r3)     // Catch:{ all -> 0x01fa }
            r11 = r35
            r2.append(r11)     // Catch:{ all -> 0x01fa }
            java.lang.String r21 = r2.toString()     // Catch:{ all -> 0x01fa }
            r1.d = r12     // Catch:{ all -> 0x01fa }
            boolean r2 = com.mbridge.msdk.foundation.tools.u.f((java.lang.String) r35)     // Catch:{ all -> 0x01fa }
            if (r2 == 0) goto L_0x0047
            if (r42 == 0) goto L_0x0045
            r0 = 0
            r36 = r42
            r37 = r21
            r38 = r33
            r39 = r34
            r40 = r31
            r41 = r35
            r42 = r0
            r36.a(r37, r38, r39, r40, r41, r42)     // Catch:{ all -> 0x01fa }
        L_0x0045:
            monitor-exit(r26)
            return
        L_0x0047:
            com.mbridge.msdk.foundation.controller.a r2 = com.mbridge.msdk.foundation.controller.a.e()     // Catch:{ Exception -> 0x0064 }
            android.content.Context r3 = r2.g()     // Catch:{ Exception -> 0x0064 }
            java.lang.String r4 = "start preload tpl"
            long r5 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x0064 }
            long r9 = r5 - r19
            r2 = r37
            r5 = r40
            r6 = r30
            r7 = r31
            r8 = r32
            com.mbridge.msdk.reward.b.a.a(r2, r3, r4, r5, r6, r7, r8, r9)     // Catch:{ Exception -> 0x0064 }
        L_0x0064:
            com.mbridge.msdk.videocommon.a$a r10 = new com.mbridge.msdk.videocommon.a$a     // Catch:{ Exception -> 0x01ce }
            r10.<init>()     // Catch:{ Exception -> 0x01ce }
            com.mbridge.msdk.reward.adapter.c r2 = com.mbridge.msdk.reward.adapter.c.m.a     // Catch:{ Exception -> 0x01ce }
            r3 = 1
            com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView r2 = r2.a((boolean) r3)     // Catch:{ Exception -> 0x01ce }
            if (r2 != 0) goto L_0x0081
            com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView r2 = new com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView     // Catch:{ Exception -> 0x01ce }
            com.mbridge.msdk.foundation.controller.a r4 = com.mbridge.msdk.foundation.controller.a.e()     // Catch:{ Exception -> 0x01ce }
            android.content.Context r4 = r4.g()     // Catch:{ Exception -> 0x01ce }
            r2.<init>(r4)     // Catch:{ Exception -> 0x01ce }
        L_0x0081:
            r9 = r2
            r10.a((com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView) r9)     // Catch:{ Exception -> 0x01ce }
            com.mbridge.msdk.video.bt.a.c r2 = com.mbridge.msdk.video.bt.a.c.a()     // Catch:{ Exception -> 0x01ce }
            java.lang.String r8 = r2.b()     // Catch:{ Exception -> 0x01ce }
            com.mbridge.msdk.video.bt.a.c r2 = com.mbridge.msdk.video.bt.a.c.a()     // Catch:{ Exception -> 0x01ce }
            java.lang.String r7 = r2.b()     // Catch:{ Exception -> 0x01ce }
            r10.a((java.lang.String) r7)     // Catch:{ Exception -> 0x01ce }
            if (r13 == 0) goto L_0x00fd
            int r4 = r38.size()     // Catch:{ Exception -> 0x01ce }
            if (r4 <= 0) goto L_0x00fd
            com.mbridge.msdk.videocommon.download.c r4 = com.mbridge.msdk.videocommon.download.c.getInstance()     // Catch:{ Exception -> 0x01ce }
            java.util.List r4 = r4.a((java.lang.String) r14)     // Catch:{ Exception -> 0x01ce }
            if (r4 == 0) goto L_0x00f6
            int r5 = r4.size()     // Catch:{ Exception -> 0x01ce }
            if (r5 <= 0) goto L_0x00f6
            r5 = 0
        L_0x00b1:
            int r6 = r38.size()     // Catch:{ Exception -> 0x01ce }
            if (r5 >= r6) goto L_0x00f6
            java.lang.Object r6 = r13.get(r5)     // Catch:{ Exception -> 0x01ce }
            com.mbridge.msdk.foundation.entity.CampaignEx r6 = (com.mbridge.msdk.foundation.entity.CampaignEx) r6     // Catch:{ Exception -> 0x01ce }
            java.util.Iterator r16 = r4.iterator()     // Catch:{ Exception -> 0x01ce }
        L_0x00c1:
            boolean r17 = r16.hasNext()     // Catch:{ Exception -> 0x01ce }
            if (r17 == 0) goto L_0x00f2
            java.lang.Object r17 = r16.next()     // Catch:{ Exception -> 0x01ce }
            com.mbridge.msdk.foundation.entity.CampaignEx r17 = (com.mbridge.msdk.foundation.entity.CampaignEx) r17     // Catch:{ Exception -> 0x01ce }
            java.lang.String r2 = r17.getId()     // Catch:{ Exception -> 0x01ce }
            java.lang.String r3 = r6.getId()     // Catch:{ Exception -> 0x01ce }
            boolean r2 = r2.equals(r3)     // Catch:{ Exception -> 0x01ce }
            if (r2 == 0) goto L_0x00f0
            java.lang.String r2 = r17.getRequestId()     // Catch:{ Exception -> 0x01ce }
            java.lang.String r3 = r6.getRequestId()     // Catch:{ Exception -> 0x01ce }
            boolean r2 = r2.equals(r3)     // Catch:{ Exception -> 0x01ce }
            if (r2 == 0) goto L_0x00f0
            r2 = 1
            r6.setReady(r2)     // Catch:{ Exception -> 0x01ce }
            r13.set(r5, r6)     // Catch:{ Exception -> 0x01ce }
        L_0x00f0:
            r3 = 1
            goto L_0x00c1
        L_0x00f2:
            int r5 = r5 + 1
            r3 = 1
            goto L_0x00b1
        L_0x00f6:
            com.mbridge.msdk.video.signal.a.j r2 = new com.mbridge.msdk.video.signal.a.j     // Catch:{ Exception -> 0x01ce }
            r3 = 0
            r2.<init>(r3, r0, r13)     // Catch:{ Exception -> 0x01ce }
            goto L_0x0103
        L_0x00fd:
            com.mbridge.msdk.video.signal.a.j r2 = new com.mbridge.msdk.video.signal.a.j     // Catch:{ Exception -> 0x01ce }
            r3 = 0
            r2.<init>(r3, r0)     // Catch:{ Exception -> 0x01ce }
        L_0x0103:
            r6 = r36
            r4 = r2
            r4.a((int) r6)     // Catch:{ Exception -> 0x01ce }
            r2 = r40
            r4.a((java.lang.String) r2)     // Catch:{ Exception -> 0x01ce }
            r4.c((java.lang.String) r7)     // Catch:{ Exception -> 0x01ce }
            r4.d((java.lang.String) r8)     // Catch:{ Exception -> 0x01ce }
            r2 = 1
            r4.c((boolean) r2)     // Catch:{ Exception -> 0x01ce }
            r3 = r41
            r4.a((com.mbridge.msdk.videocommon.d.c) r3)     // Catch:{ Exception -> 0x01ce }
            r2 = r27
            r4.d((boolean) r2)     // Catch:{ Exception -> 0x01ce }
            com.mbridge.msdk.reward.adapter.c$b r5 = new com.mbridge.msdk.reward.adapter.c$b     // Catch:{ Exception -> 0x01ce }
            r16 = 0
            r32 = r5
            r5 = r16
            r2 = r32
            r3 = r27
            r22 = r4
            r4 = r28
            r6 = r29
            r23 = r7
            r7 = r30
            r24 = r8
            r8 = r36
            r25 = r9
            r9 = r35
            r16 = r10
            r10 = r33
            r11 = r34
            r12 = r31
            r13 = r16
            r14 = r37
            r15 = r38
            r16 = r41
            r17 = r42
            r18 = r43
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19)     // Catch:{ Exception -> 0x01c8 }
            r0 = r32
            r2 = r25
            r2.setWebViewListener(r0)     // Catch:{ Exception -> 0x01c8 }
            r0 = r22
            r2.setObject(r0)     // Catch:{ Exception -> 0x01c8 }
            r0 = r39
            r2.loadUrl(r0)     // Catch:{ Exception -> 0x01c8 }
            r3 = r31
            r2.setRid(r3)     // Catch:{ Exception -> 0x01c6 }
            com.mbridge.msdk.video.bt.module.MBridgeBTRootLayout r0 = new com.mbridge.msdk.video.bt.module.MBridgeBTRootLayout     // Catch:{ Exception -> 0x01c6 }
            com.mbridge.msdk.foundation.controller.a r4 = com.mbridge.msdk.foundation.controller.a.e()     // Catch:{ Exception -> 0x01c6 }
            android.content.Context r4 = r4.g()     // Catch:{ Exception -> 0x01c6 }
            r0.<init>(r4)     // Catch:{ Exception -> 0x01c6 }
            android.widget.FrameLayout$LayoutParams r4 = new android.widget.FrameLayout$LayoutParams     // Catch:{ Exception -> 0x01c6 }
            r5 = -1
            r4.<init>(r5, r5)     // Catch:{ Exception -> 0x01c6 }
            r0.setLayoutParams(r4)     // Catch:{ Exception -> 0x01c6 }
            r4 = r24
            r0.setInstanceId(r4)     // Catch:{ Exception -> 0x01c6 }
            r6 = r34
            r0.setUnitId(r6)     // Catch:{ Exception -> 0x01c4 }
            com.mbridge.msdk.video.bt.module.MBridgeBTLayout r7 = new com.mbridge.msdk.video.bt.module.MBridgeBTLayout     // Catch:{ Exception -> 0x01c4 }
            com.mbridge.msdk.foundation.controller.a r8 = com.mbridge.msdk.foundation.controller.a.e()     // Catch:{ Exception -> 0x01c4 }
            android.content.Context r8 = r8.g()     // Catch:{ Exception -> 0x01c4 }
            r7.<init>(r8)     // Catch:{ Exception -> 0x01c4 }
            android.widget.FrameLayout$LayoutParams r8 = new android.widget.FrameLayout$LayoutParams     // Catch:{ Exception -> 0x01c4 }
            r8.<init>(r5, r5)     // Catch:{ Exception -> 0x01c4 }
            r7.setLayoutParams(r8)     // Catch:{ Exception -> 0x01c4 }
            r8 = r23
            r7.setInstanceId(r8)     // Catch:{ Exception -> 0x01c4 }
            r7.setUnitId(r6)     // Catch:{ Exception -> 0x01c4 }
            r7.setWebView(r2)     // Catch:{ Exception -> 0x01c4 }
            com.mbridge.msdk.video.bt.a.c r2 = com.mbridge.msdk.video.bt.a.c.a()     // Catch:{ Exception -> 0x01c4 }
            java.util.LinkedHashMap r2 = r2.b((java.lang.String) r6, (java.lang.String) r3)     // Catch:{ Exception -> 0x01c4 }
            r2.put(r8, r7)     // Catch:{ Exception -> 0x01c4 }
            r2.put(r4, r0)     // Catch:{ Exception -> 0x01c4 }
            android.widget.FrameLayout$LayoutParams r2 = new android.widget.FrameLayout$LayoutParams     // Catch:{ Exception -> 0x01c4 }
            r2.<init>(r5, r5)     // Catch:{ Exception -> 0x01c4 }
            r0.addView(r7, r2)     // Catch:{ Exception -> 0x01c4 }
            goto L_0x01f8
        L_0x01c4:
            r0 = move-exception
            goto L_0x01d1
        L_0x01c6:
            r0 = move-exception
            goto L_0x01cb
        L_0x01c8:
            r0 = move-exception
            r3 = r31
        L_0x01cb:
            r6 = r34
            goto L_0x01d1
        L_0x01ce:
            r0 = move-exception
            r6 = r14
            r3 = r15
        L_0x01d1:
            if (r42 == 0) goto L_0x01eb
            r2 = 0
            java.lang.String r4 = r0.getMessage()     // Catch:{ all -> 0x01fa }
            r36 = r42
            r37 = r21
            r38 = r33
            r39 = r34
            r40 = r31
            r41 = r35
            r42 = r2
            r43 = r4
            r36.a(r37, r38, r39, r40, r41, r42, r43)     // Catch:{ all -> 0x01fa }
        L_0x01eb:
            boolean r2 = com.mbridge.msdk.MBridgeConstans.DEBUG     // Catch:{ all -> 0x01fa }
            if (r2 == 0) goto L_0x01f8
            java.lang.String r2 = "RewardCampaignsResourceManager"
            java.lang.String r0 = r0.getLocalizedMessage()     // Catch:{ all -> 0x01fa }
            com.mbridge.msdk.foundation.tools.q.d(r2, r0)     // Catch:{ all -> 0x01fa }
        L_0x01f8:
            monitor-exit(r26)
            return
        L_0x01fa:
            r0 = move-exception
            monitor-exit(r26)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.reward.adapter.c.a(boolean, android.os.Handler, boolean, boolean, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, com.mbridge.msdk.foundation.entity.CampaignEx, java.util.List, java.lang.String, java.lang.String, com.mbridge.msdk.videocommon.d.c, com.mbridge.msdk.reward.adapter.c$j, boolean):void");
    }

    /* compiled from: RewardCampaignsResourceManager */
    private static class b extends com.mbridge.msdk.mbsignalcommon.b.a {
        private final Handler a;
        private final Runnable b;
        private final boolean c;
        private final boolean d;
        private int e;
        private String f;
        private String g;
        private String h;
        private String i;
        private a.C0105a j;
        private CampaignEx k;
        private List<CampaignEx> l;
        private com.mbridge.msdk.videocommon.d.c m;
        private final j n;
        private boolean o;
        private boolean p;
        private boolean q;
        private int r = 0;
        private boolean s;
        private long t;

        public b(boolean z, Handler handler, Runnable runnable, boolean z2, boolean z3, int i2, String str, String str2, String str3, String str4, a.C0105a aVar, CampaignEx campaignEx, List<CampaignEx> list, com.mbridge.msdk.videocommon.d.c cVar, j jVar, boolean z4, long j2) {
            this.a = handler;
            this.b = runnable;
            this.c = z2;
            this.d = z3;
            this.e = i2;
            this.f = str;
            this.h = str2;
            this.g = str3;
            this.i = str4;
            this.j = aVar;
            this.k = campaignEx;
            this.l = list;
            this.m = cVar;
            this.n = jVar;
            this.o = z4;
            this.s = z;
            this.t = j2;
        }

        public final void a(WebView webView, int i2) {
            Runnable runnable;
            if (!this.q) {
                try {
                    com.mbridge.msdk.reward.b.a.a(this.k, com.mbridge.msdk.foundation.controller.a.e().g(), "preload tpl readyState: " + i2, this.g, this.d, this.i, this.k.getRequestIdNotice(), System.currentTimeMillis() - this.t);
                } catch (Exception unused) {
                }
                String str = this.g + "_" + this.f;
                if (i2 == 1) {
                    if (this.o) {
                        com.mbridge.msdk.videocommon.a.d(this.g + "_" + this.i);
                    } else {
                        com.mbridge.msdk.videocommon.a.c(this.g + "_" + this.i);
                    }
                    com.mbridge.msdk.videocommon.a.a(this.g + "_" + this.i + "_" + this.f, this.j, true, this.o);
                    Handler handler = this.a;
                    if (!(handler == null || (runnable = this.b) == null)) {
                        handler.removeCallbacks(runnable);
                    }
                    com.mbridge.msdk.videocommon.download.i.a().d(this.g + "_" + this.i + "_" + this.f, true);
                    a.C0105a aVar = this.j;
                    if (aVar != null) {
                        aVar.a(true);
                    }
                    j jVar = this.n;
                    if (jVar != null) {
                        jVar.a(str, this.h, this.g, this.i, this.f, this.j);
                    }
                } else {
                    com.mbridge.msdk.videocommon.download.i.a().d(this.g + "_" + this.i + "_" + this.f, false);
                    a.C0105a aVar2 = this.j;
                    if (aVar2 != null) {
                        aVar2.a(false);
                    }
                    j jVar2 = this.n;
                    if (jVar2 != null) {
                        jVar2.a(str, this.h, this.g, this.i, this.f, this.j, "state 2");
                    }
                }
                this.q = true;
            }
        }

        public final void a(WebView webView, String str, String str2, int i2, int i3) {
            boolean z = true;
            if (i2 == 1) {
                try {
                    com.mbridge.msdk.reward.a.a aVar = new com.mbridge.msdk.reward.a.a();
                    aVar.b(false);
                    if (i3 != 2) {
                        z = false;
                    }
                    aVar.a(z);
                    aVar.b(str, str2);
                    aVar.a((InterVideoOutListener) new com.mbridge.msdk.video.bt.module.b.a((com.mbridge.msdk.video.bt.module.b.g) null));
                    aVar.d(false);
                } catch (Exception unused) {
                }
            }
        }

        public final void a(Object obj, String str) {
            Object obj2 = obj;
            if (obj2 != null) {
                try {
                    if (!TextUtils.isEmpty(str)) {
                        String optString = new JSONObject(str).optString("id");
                        com.mbridge.msdk.video.bt.a.c.a().a(obj2, optString);
                        String c2 = com.mbridge.msdk.video.bt.a.c.a().c(optString);
                        CampaignEx a2 = com.mbridge.msdk.video.bt.a.c.a().a(optString);
                        com.mbridge.msdk.videocommon.d.c b2 = com.mbridge.msdk.video.bt.a.c.a().b(optString);
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(a2);
                        com.mbridge.msdk.mbsignalcommon.windvane.a aVar = (com.mbridge.msdk.mbsignalcommon.windvane.a) obj2;
                        if (aVar.a instanceof WindVaneWebView) {
                            WindVaneWebView windVaneWebView = aVar.a;
                            c a3 = m.a;
                            boolean z = this.s;
                            int i2 = this.r == 0 ? 3 : 6;
                            if (windVaneWebView != null) {
                                if (!(a2 == null || b2 == null)) {
                                    try {
                                        if (a2.getRewardTemplateMode() != null) {
                                            if (!TextUtils.isEmpty(c2)) {
                                                if (TextUtils.isEmpty(a2.getRewardTemplateMode().e())) {
                                                    JSONObject jSONObject = new JSONObject();
                                                    jSONObject.put("id", optString);
                                                    JSONObject jSONObject2 = new JSONObject();
                                                    jSONObject2.put(IronSourceConstants.EVENTS_RESULT, 1);
                                                    jSONObject2.put(CampaignEx.JSON_NATIVE_VIDEO_ERROR, "data is null");
                                                    jSONObject.put(DataSchemeDataSource.SCHEME_DATA, jSONObject2);
                                                    com.mbridge.msdk.mbsignalcommon.windvane.g.a().a((WebView) windVaneWebView, "onSubPlayTemplateViewLoad", Base64.encodeToString(jSONObject.toString().getBytes(), 2));
                                                } else if (TextUtils.isEmpty(a2.getRewardTemplateMode().e()) || !a2.getRewardTemplateMode().e().contains(CampaignEx.KEY_IS_CMPT_ENTRY)) {
                                                    new Handler(Looper.getMainLooper()).postDelayed(new Runnable(z, windVaneWebView, a2, arrayList, c2, b2, optString) {
                                                        final /* synthetic */ boolean a;
                                                        final /* synthetic */ WindVaneWebView b;
                                                        final /* synthetic */ CampaignEx c;
                                                        final /* synthetic */ List d;
                                                        final /* synthetic */ String e;
                                                        final /* synthetic */ com.mbridge.msdk.videocommon.d.c f;
                                                        final /* synthetic */ String g;

                                                        {
                                                            this.a = r2;
                                                            this.b = r3;
                                                            this.c = r4;
                                                            this.d = r5;
                                                            this.e = r6;
                                                            this.f = r7;
                                                            this.g = r8;
                                                        }

                                                        public final void run() {
                                                            c.a(c.this, this.a, this.b, this.c.getRewardTemplateMode().e(), 0, this.c, this.d, com.mbridge.msdk.videocommon.download.g.a().b(this.c.getRewardTemplateMode().e()), this.e, this.f, this.g, c.this.d);
                                                        }
                                                    }, (long) (i2 * 1000));
                                                } else {
                                                    q.a("RewardCampaignsResourceManager", "getTeamplateUrl contains cmpt=1");
                                                }
                                            }
                                        }
                                    } catch (Exception e2) {
                                        if (MBridgeConstans.DEBUG) {
                                            q.d("RewardCampaignsResourceManager", e2.getLocalizedMessage());
                                        }
                                    } catch (Throwable th) {
                                        th = th;
                                        q.d("RVWindVaneWebView", th.getMessage());
                                        return;
                                    }
                                }
                                JSONObject jSONObject3 = new JSONObject();
                                try {
                                    jSONObject3.put("id", optString);
                                    JSONObject jSONObject4 = new JSONObject();
                                    jSONObject4.put(IronSourceConstants.EVENTS_RESULT, 2);
                                    jSONObject4.put(CampaignEx.JSON_NATIVE_VIDEO_ERROR, "data is null");
                                    jSONObject3.put(DataSchemeDataSource.SCHEME_DATA, jSONObject4);
                                    com.mbridge.msdk.mbsignalcommon.windvane.g.a().a((WebView) windVaneWebView, "onSubPlayTemplateViewLoad", Base64.encodeToString(jSONObject3.toString().getBytes(), 2));
                                } catch (Exception e3) {
                                    if (MBridgeConstans.DEBUG) {
                                        q.d("RewardCampaignsResourceManager", e3.getLocalizedMessage());
                                    }
                                }
                            }
                            this.r++;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }
        }

        public final void a(WebView webView, String str) {
            Runnable runnable;
            super.a(webView, str);
            if (!this.p) {
                try {
                    com.mbridge.msdk.reward.b.a.a(this.k, com.mbridge.msdk.foundation.controller.a.e().g(), "preload tpl onPageFinish", this.g, this.d, this.i, this.k.getRequestIdNotice(), System.currentTimeMillis() - this.t);
                } catch (Exception unused) {
                }
                String str2 = this.g + "_" + this.f;
                if (!str.contains("wfr=1")) {
                    com.mbridge.msdk.videocommon.download.i.a().d(this.g + "_" + this.i + "_" + this.f, true);
                    Handler handler = this.a;
                    if (!(handler == null || (runnable = this.b) == null)) {
                        handler.removeCallbacks(runnable);
                    }
                    a.C0105a aVar = this.j;
                    if (aVar != null) {
                        aVar.a(true);
                    }
                    j jVar = this.n;
                    if (jVar != null) {
                        jVar.a(str2, this.h, this.g, this.i, this.f, this.j);
                    }
                }
                com.mbridge.msdk.mbsignalcommon.windvane.g.a().a(webView);
                this.p = true;
            }
        }

        public final void a(WebView webView, int i2, String str, String str2) {
            super.a(webView, i2, str, str2);
            com.mbridge.msdk.videocommon.download.i.a().d(this.g + "_" + this.i + "_" + this.f, false);
            if (this.n != null) {
                String str3 = this.g + "_" + this.f;
                a.C0105a aVar = this.j;
                if (aVar != null) {
                    aVar.a(false);
                }
                this.n.a(str3, this.h, this.g, this.i, this.f, this.j, str);
            }
        }
    }

    /* compiled from: RewardCampaignsResourceManager */
    private static class l extends com.mbridge.msdk.mbsignalcommon.b.b {
        private String a;
        private final boolean b;
        private final WindVaneWebView c;
        private final String d;
        private final String e;
        private final a.C0105a f;
        private final CampaignEx g;
        private boolean h;
        private String i;
        private boolean j;
        private boolean k;

        public l(String str, boolean z, WindVaneWebView windVaneWebView, String str2, String str3, a.C0105a aVar, CampaignEx campaignEx, boolean z2, String str4) {
            this.b = z;
            this.c = windVaneWebView;
            this.d = str2;
            this.e = str3;
            this.f = aVar;
            this.g = campaignEx;
            this.a = str;
            this.h = z2;
            this.i = str4;
        }

        public final void a(WebView webView, int i2) {
            if (!this.k) {
                if (this.c != null) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("id", this.a);
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put(IronSourceConstants.EVENTS_RESULT, i2);
                        jSONObject2.put(CampaignEx.JSON_NATIVE_VIDEO_ERROR, "");
                        jSONObject.put(DataSchemeDataSource.SCHEME_DATA, jSONObject2);
                        com.mbridge.msdk.mbsignalcommon.windvane.g.a().a((WebView) this.c, "onSubPlayTemplateViewLoad", Base64.encodeToString(jSONObject.toString().getBytes(), 2));
                    } catch (Exception e2) {
                        if (MBridgeConstans.DEBUG) {
                            q.d("WindVaneWebView", e2.getLocalizedMessage());
                        }
                    }
                }
                String str = this.e + "_" + this.g.getId() + "_" + this.g.getRequestId() + "_" + this.d;
                if (i2 == 1) {
                    com.mbridge.msdk.videocommon.download.i.a().d(this.e + "_" + this.i + "_" + this.d, true);
                    a.C0105a aVar = this.f;
                    if (aVar != null) {
                        aVar.a(true);
                    }
                    if (this.b) {
                        if (this.g.isBidCampaign()) {
                            com.mbridge.msdk.videocommon.a.a(str, this.f, false, this.h);
                        } else {
                            com.mbridge.msdk.videocommon.a.a(str, this.f, false, this.h);
                        }
                    } else if (this.g.isBidCampaign()) {
                        com.mbridge.msdk.videocommon.a.a(str, this.f, false, this.h);
                    } else {
                        com.mbridge.msdk.videocommon.a.a(str, this.f, false, this.h);
                    }
                } else {
                    com.mbridge.msdk.videocommon.download.i.a().d(this.e + "_" + this.i + "_" + this.d, false);
                    a.C0105a aVar2 = this.f;
                    if (aVar2 != null) {
                        aVar2.a(false);
                    }
                }
                this.k = true;
            }
        }

        public final void a(WebView webView, int i2, String str, String str2) {
            com.mbridge.msdk.videocommon.download.i a2 = com.mbridge.msdk.videocommon.download.i.a();
            a2.d(this.e + "_" + this.i + "_" + this.d, false);
            a.C0105a aVar = this.f;
            if (aVar != null) {
                aVar.a(false);
            }
            if (this.c != null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("id", this.a);
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put(IronSourceConstants.EVENTS_RESULT, 2);
                    jSONObject2.put(CampaignEx.JSON_NATIVE_VIDEO_ERROR, str);
                    jSONObject.put(DataSchemeDataSource.SCHEME_DATA, jSONObject2);
                    com.mbridge.msdk.mbsignalcommon.windvane.g.a().a((WebView) this.c, "onSubPlayTemplateViewLoad", Base64.encodeToString(jSONObject.toString().getBytes(), 2));
                } catch (Exception e2) {
                    if (MBridgeConstans.DEBUG) {
                        q.d("WindVaneWebView", e2.getLocalizedMessage());
                    }
                }
            }
        }

        public final void a(WebView webView, String str) {
            if (!this.j) {
                if (!str.contains("wfr=1")) {
                    if (this.c != null) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("id", this.a);
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject2.put(IronSourceConstants.EVENTS_RESULT, 1);
                            jSONObject2.put(CampaignEx.JSON_NATIVE_VIDEO_ERROR, "");
                            jSONObject.put(DataSchemeDataSource.SCHEME_DATA, jSONObject2);
                            com.mbridge.msdk.mbsignalcommon.windvane.g.a().a((WebView) this.c, "componentReact", Base64.encodeToString(jSONObject.toString().getBytes(), 2));
                        } catch (Exception e2) {
                            if (MBridgeConstans.DEBUG) {
                                q.d("WindVaneWebView", e2.getLocalizedMessage());
                            }
                        }
                    }
                    com.mbridge.msdk.videocommon.download.i.a().d(this.e + "_" + this.i + "_" + this.d, true);
                    a.C0105a aVar = this.f;
                    if (aVar != null) {
                        aVar.a(true);
                    }
                    String str2 = this.e + "_" + this.g.getId() + "_" + this.g.getRequestId() + "_" + this.d;
                    if (this.b) {
                        if (this.g.isBidCampaign()) {
                            com.mbridge.msdk.videocommon.a.a(287, this.g.getRequestIdNotice(), this.f);
                        } else {
                            com.mbridge.msdk.videocommon.a.a(str2, this.f, false, this.h);
                        }
                    } else if (this.g.isBidCampaign()) {
                        com.mbridge.msdk.videocommon.a.a(94, this.g.getRequestIdNotice(), this.f);
                    } else {
                        com.mbridge.msdk.videocommon.a.a(str2, this.f, false, this.h);
                    }
                }
                com.mbridge.msdk.mbsignalcommon.windvane.g.a().a(webView);
                this.j = true;
            }
        }
    }

    /* compiled from: RewardCampaignsResourceManager */
    private static class a {
        boolean a;
        boolean b;
        int c;
        int d;
        String e;
        String f;
        int g;
        List<CampaignEx> h;
        CopyOnWriteArrayList<CampaignEx> i;

        public a(boolean z, boolean z2, int i2, int i3, String str, String str2, int i4, List<CampaignEx> list) {
            this.a = z;
            this.b = z2;
            this.c = i2;
            this.d = i3;
            this.e = str;
            this.f = str2;
            this.g = i4;
            this.h = list;
            this.i = new CopyOnWriteArrayList<>(list);
        }
    }

    public final synchronized void b() {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            new Handler(Looper.getMainLooper()).post(new Runnable() {
                public final void run() {
                    c.this.d();
                }
            });
        } else {
            d();
        }
    }

    /* access modifiers changed from: private */
    public void d() {
        try {
            if (this.e == null) {
                this.e = new ArrayList();
            }
            Context g2 = com.mbridge.msdk.foundation.controller.a.e().g();
            if (g2 != null) {
                this.e.add(new WindVaneWebView(g2));
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private synchronized WindVaneWebView a(boolean z) {
        if (this.e == null || this.e.size() <= 0) {
            Context g2 = com.mbridge.msdk.foundation.controller.a.e().g();
            if (g2 != null) {
                this.e.add(new WindVaneWebView(g2));
                if (z) {
                    this.e.add(new WindVaneWebView(g2));
                }
            }
            return null;
        }
        return this.e.remove(0);
    }

    static /* synthetic */ void a(c cVar, Context context, String str, String str2, String str3, CampaignEx campaignEx, String str4, i iVar, List list) {
        c cVar2 = cVar;
        String str5 = str4;
        if (!TextUtils.isEmpty(str4) && !campaignEx.isMraid()) {
            if (!str5.contains(".zip") || !str5.contains("md5filename")) {
                boolean isEmpty = TextUtils.isEmpty(com.mbridge.msdk.videocommon.download.h.a().b(str5));
                try {
                    d dVar = new d(497, str, str2, str3, campaignEx, iVar, cVar2.a, list);
                    dVar.a(isEmpty);
                    com.mbridge.msdk.videocommon.download.g.a().b(str5, dVar);
                } catch (Exception e2) {
                    if (MBridgeConstans.DEBUG) {
                        q.d("RewardCampaignsResourceManager", e2.getLocalizedMessage());
                    }
                }
            } else {
                boolean isEmpty2 = TextUtils.isEmpty(com.mbridge.msdk.videocommon.download.g.a().b(str5));
                try {
                    g gVar = new g(context, str, str2, str3, campaignEx, 497, cVar2.a, iVar, list);
                    gVar.a(isEmpty2);
                    com.mbridge.msdk.videocommon.download.g.a().b(str5, gVar);
                } catch (Exception e3) {
                    if (MBridgeConstans.DEBUG) {
                        q.d("RewardCampaignsResourceManager", e3.getLocalizedMessage());
                    }
                }
            }
        }
    }

    static /* synthetic */ void a(c cVar, boolean z, WindVaneWebView windVaneWebView, String str, int i2, CampaignEx campaignEx, List list, String str2, String str3, com.mbridge.msdk.videocommon.d.c cVar2, String str4, boolean z2) {
        com.mbridge.msdk.video.signal.a.j jVar;
        String str5;
        CampaignEx campaignEx2 = campaignEx;
        List list2 = list;
        String str6 = str3;
        try {
            a.C0105a aVar = new a.C0105a();
            WindVaneWebView a2 = m.a.a(false);
            if (a2 == null) {
                a2 = new WindVaneWebView(com.mbridge.msdk.foundation.controller.a.e().g());
            }
            WindVaneWebView windVaneWebView2 = a2;
            aVar.a(windVaneWebView2);
            if (list2 == null || list.size() <= 0) {
                jVar = new com.mbridge.msdk.video.signal.a.j((Activity) null, campaignEx2);
                str5 = campaignEx.getRequestId();
            } else {
                List<CampaignEx> a3 = com.mbridge.msdk.videocommon.download.c.getInstance().a(str6);
                if (a3 != null && a3.size() > 0) {
                    for (int i3 = 0; i3 < list.size(); i3++) {
                        CampaignEx campaignEx3 = (CampaignEx) list2.get(i3);
                        for (CampaignEx next : a3) {
                            if (next.getId().equals(campaignEx3.getId()) && next.getRequestId().equals(campaignEx3.getRequestId())) {
                                campaignEx3.setReady(true);
                                list2.set(i3, campaignEx3);
                            }
                        }
                    }
                }
                jVar = new com.mbridge.msdk.video.signal.a.j((Activity) null, campaignEx2, list2);
                str5 = ((CampaignEx) list2.get(0)).getRequestId();
            }
            String str7 = str5;
            com.mbridge.msdk.video.signal.a.j jVar2 = jVar;
            jVar2.a(i2);
            jVar2.a(str6);
            jVar2.c(str4);
            jVar2.a(cVar2);
            jVar2.d(z);
            windVaneWebView2.setWebViewListener(new l(str4, false, windVaneWebView, str, str3, aVar, campaignEx, z2, str7));
            windVaneWebView2.setObject(jVar2);
            windVaneWebView2.loadUrl(str2);
            windVaneWebView2.setRid(str7);
        } catch (Exception e2) {
            if (MBridgeConstans.DEBUG) {
                q.d("RewardCampaignsResourceManager", e2.getLocalizedMessage());
            }
        }
    }
}
