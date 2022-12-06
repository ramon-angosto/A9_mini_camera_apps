package com.mbridge.msdk.reward.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.webkit.WebView;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.CampaignUnit;
import com.mbridge.msdk.foundation.tools.q;
import com.mbridge.msdk.foundation.tools.u;
import com.mbridge.msdk.foundation.tools.x;
import com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView;
import com.mbridge.msdk.mbsignalcommon.windvane.g;
import com.mbridge.msdk.playercommon.exoplayer2.DefaultRenderersFactory;
import com.mbridge.msdk.reward.adapter.c;
import com.mbridge.msdk.reward.player.MBRewardVideoActivity;
import com.mbridge.msdk.video.bt.module.b.h;
import com.mbridge.msdk.video.signal.a.j;
import com.mbridge.msdk.videocommon.a;
import com.mbridge.msdk.videocommon.download.i;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: RewardMVVideoAdapter */
public final class d implements a {
    private int A;
    private int B;
    /* access modifiers changed from: private */
    public CampaignUnit C;
    /* access modifiers changed from: private */
    public List<CampaignEx> D;
    /* access modifiers changed from: private */
    public boolean E = false;
    /* access modifiers changed from: private */
    public long F = 0;
    /* access modifiers changed from: private */
    public C0100d G;
    /* access modifiers changed from: private */
    public boolean H = false;
    /* access modifiers changed from: private */
    public boolean I = false;
    /* access modifiers changed from: private */
    public Handler J = new Handler(Looper.getMainLooper()) {
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v10, resolved type: java.lang.Object[]} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v4, resolved type: java.lang.String} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v6, resolved type: java.lang.String} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v8, resolved type: com.mbridge.msdk.foundation.entity.CampaignEx} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v11, resolved type: com.mbridge.msdk.foundation.entity.CampaignEx} */
        /* JADX WARNING: type inference failed for: r11v0 */
        /* JADX WARNING: type inference failed for: r3v10 */
        /* JADX WARNING: type inference failed for: r3v11 */
        /* JADX WARNING: type inference failed for: r3v12 */
        /* JADX WARNING: type inference failed for: r3v13 */
        /* JADX WARNING: type inference failed for: r11v1 */
        /* JADX WARNING: type inference failed for: r3v15 */
        /* JADX WARNING: type inference failed for: r2v17 */
        /* JADX WARNING: type inference failed for: r11v14 */
        /* JADX WARNING: type inference failed for: r11v15 */
        /* JADX WARNING: type inference failed for: r11v16 */
        /* JADX WARNING: type inference failed for: r11v17 */
        /* JADX WARNING: type inference failed for: r11v18 */
        /* JADX WARNING: Code restructure failed: missing block: B:188:0x060c, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:189:0x060d, code lost:
            r2 = r0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:192:0x0614, code lost:
            if (com.mbridge.msdk.reward.adapter.d.i(r1.a) != null) goto L_0x0616;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:193:0x0616, code lost:
            com.mbridge.msdk.reward.adapter.d.i(r1.a).removeMessages(5);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:194:0x061f, code lost:
            removeMessages(6);
            com.mbridge.msdk.reward.adapter.d.a(r1.a, com.mbridge.msdk.reward.adapter.d.d(r1.a), com.mbridge.msdk.reward.adapter.d.b(r1.a), com.mbridge.msdk.reward.adapter.d.f(r1.a));
         */
        /* JADX WARNING: Code restructure failed: missing block: B:195:0x063d, code lost:
            if (r1.a.i == false) goto L_0x063f;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:196:0x063f, code lost:
            r1.a.i = true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:197:0x0643, code lost:
            if (r11 != 0) goto L_0x0645;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:198:0x0645, code lost:
            com.mbridge.msdk.reward.b.a.a(r11, com.mbridge.msdk.reward.adapter.d.h(r1.a), r2.getMessage(), com.mbridge.msdk.reward.adapter.d.d(r1.a), com.mbridge.msdk.reward.adapter.d.f(r1.a), r11.getRequestId(), r11.getRequestIdNotice());
         */
        /* JADX WARNING: Code restructure failed: missing block: B:199:0x0669, code lost:
            com.mbridge.msdk.reward.b.a.a(r11, com.mbridge.msdk.reward.adapter.d.h(r1.a), r2.getMessage(), com.mbridge.msdk.reward.adapter.d.d(r1.a), com.mbridge.msdk.reward.adapter.d.f(r1.a), "", "");
         */
        /* JADX WARNING: Code restructure failed: missing block: B:200:0x0688, code lost:
            com.mbridge.msdk.reward.adapter.d.a(r1.a).a("errorCode: 3508 errorMessage: data load failed, exception is " + r2.getMessage());
         */
        /* JADX WARNING: Code restructure failed: missing block: B:219:0x071a, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:220:0x071b, code lost:
            r2 = r0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:222:?, code lost:
            com.mbridge.msdk.foundation.tools.q.a("RewardMVVideoAdapter", r2.getLocalizedMessage());
         */
        /* JADX WARNING: Code restructure failed: missing block: B:223:0x0725, code lost:
            if (com.mbridge.msdk.MBridgeConstans.DEBUG != false) goto L_0x0727;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:224:0x0727, code lost:
            r2.printStackTrace();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:250:0x07c9, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:251:0x07ca, code lost:
            com.mbridge.msdk.foundation.tools.q.a("RewardMVVideoAdapter", r0.getMessage());
         */
        /* JADX WARNING: Code restructure failed: missing block: B:252:0x07d3, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:253:0x07d4, code lost:
            r0.printStackTrace();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:267:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:282:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:283:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:288:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:297:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:302:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Multi-variable type inference failed */
        /* JADX WARNING: Removed duplicated region for block: B:106:0x02fe A[SYNTHETIC, Splitter:B:106:0x02fe] */
        /* JADX WARNING: Removed duplicated region for block: B:125:0x03a5 A[SYNTHETIC, Splitter:B:125:0x03a5] */
        /* JADX WARNING: Removed duplicated region for block: B:250:0x07c9 A[ExcHandler: all (r0v1 'th' java.lang.Throwable A[CUSTOM_DECLARE]), Splitter:B:1:0x0008] */
        /* JADX WARNING: Removed duplicated region for block: B:256:0x0226 A[SYNTHETIC] */
        /* JADX WARNING: Removed duplicated region for block: B:92:0x029a A[SYNTHETIC, Splitter:B:92:0x029a] */
        /* JADX WARNING: Unknown top exception splitter block from list: {B:153:0x04ab=Splitter:B:153:0x04ab, B:225:0x072c=Splitter:B:225:0x072c} */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void handleMessage(android.os.Message r26) {
            /*
                r25 = this;
                r1 = r25
                r2 = r26
                java.lang.String r3 = "_"
                java.lang.String r4 = "RewardMVVideoAdapter"
                int r5 = r2.what     // Catch:{ Exception -> 0x07d3, all -> 0x07c9 }
                r6 = 8
                if (r5 == r6) goto L_0x079a
                r6 = 9
                r7 = 4
                r8 = 3
                r9 = 2
                java.lang.String r10 = ""
                r11 = 0
                r12 = 6
                r13 = 5
                r14 = 0
                if (r5 == r6) goto L_0x072c
                r6 = 16
                if (r5 == r6) goto L_0x072c
                r6 = 17
                r15 = 1
                if (r5 == r6) goto L_0x06e5
                switch(r5) {
                    case 1: goto L_0x06d4;
                    case 2: goto L_0x06c3;
                    case 3: goto L_0x06a8;
                    case 4: goto L_0x046b;
                    case 5: goto L_0x00ab;
                    case 6: goto L_0x0029;
                    default: goto L_0x0027;
                }
            L_0x0027:
                goto L_0x07d8
            L_0x0029:
                com.mbridge.msdk.reward.adapter.d r2 = com.mbridge.msdk.reward.adapter.d.this     // Catch:{ Exception -> 0x07d3, all -> 0x07c9 }
                com.mbridge.msdk.reward.adapter.d r3 = com.mbridge.msdk.reward.adapter.d.this     // Catch:{ Exception -> 0x07d3, all -> 0x07c9 }
                java.lang.String r3 = r3.k     // Catch:{ Exception -> 0x07d3, all -> 0x07c9 }
                com.mbridge.msdk.reward.adapter.d r5 = com.mbridge.msdk.reward.adapter.d.this     // Catch:{ Exception -> 0x07d3, all -> 0x07c9 }
                java.util.List r5 = r5.M     // Catch:{ Exception -> 0x07d3, all -> 0x07c9 }
                com.mbridge.msdk.reward.adapter.d r6 = com.mbridge.msdk.reward.adapter.d.this     // Catch:{ Exception -> 0x07d3, all -> 0x07c9 }
                java.util.List r6 = r6.N     // Catch:{ Exception -> 0x07d3, all -> 0x07c9 }
                com.mbridge.msdk.reward.adapter.d r7 = com.mbridge.msdk.reward.adapter.d.this     // Catch:{ Exception -> 0x07d3, all -> 0x07c9 }
                boolean r7 = r7.x     // Catch:{ Exception -> 0x07d3, all -> 0x07c9 }
                com.mbridge.msdk.reward.adapter.d.a((com.mbridge.msdk.reward.adapter.d) r2, (java.lang.String) r3, (java.util.List) r5, (java.util.List) r6, (boolean) r7)     // Catch:{ Exception -> 0x07d3, all -> 0x07c9 }
                com.mbridge.msdk.reward.adapter.d r2 = com.mbridge.msdk.reward.adapter.d.this     // Catch:{ Exception -> 0x07d3, all -> 0x07c9 }
                com.mbridge.msdk.reward.adapter.b r2 = r2.s     // Catch:{ Exception -> 0x07d3, all -> 0x07c9 }
                if (r2 == 0) goto L_0x07d8
                r1.removeMessages(r12)     // Catch:{ Exception -> 0x07d3, all -> 0x07c9 }
                com.mbridge.msdk.reward.adapter.d r2 = com.mbridge.msdk.reward.adapter.d.this     // Catch:{ Exception -> 0x07d3, all -> 0x07c9 }
                android.os.Handler r2 = r2.J     // Catch:{ Exception -> 0x07d3, all -> 0x07c9 }
                if (r2 == 0) goto L_0x0062
                com.mbridge.msdk.reward.adapter.d r2 = com.mbridge.msdk.reward.adapter.d.this     // Catch:{ Exception -> 0x07d3, all -> 0x07c9 }
                android.os.Handler r2 = r2.J     // Catch:{ Exception -> 0x07d3, all -> 0x07c9 }
                r2.removeMessages(r13)     // Catch:{ Exception -> 0x07d3, all -> 0x07c9 }
            L_0x0062:
                com.mbridge.msdk.reward.adapter.d r2 = com.mbridge.msdk.reward.adapter.d.this     // Catch:{ Exception -> 0x07d3, all -> 0x07c9 }
                com.mbridge.msdk.reward.adapter.b r2 = r2.s     // Catch:{ Exception -> 0x07d3, all -> 0x07c9 }
                if (r2 == 0) goto L_0x07d8
                com.mbridge.msdk.reward.adapter.d r2 = com.mbridge.msdk.reward.adapter.d.this     // Catch:{ Exception -> 0x07d3, all -> 0x07c9 }
                boolean r2 = r2.h     // Catch:{ Exception -> 0x07d3, all -> 0x07c9 }
                if (r2 != 0) goto L_0x07d8
                com.mbridge.msdk.reward.adapter.d r2 = com.mbridge.msdk.reward.adapter.d.this     // Catch:{ Exception -> 0x07d3, all -> 0x07c9 }
                r2.h = r15     // Catch:{ Exception -> 0x07d3, all -> 0x07c9 }
                com.mbridge.msdk.reward.adapter.d r2 = com.mbridge.msdk.reward.adapter.d.this     // Catch:{ Exception -> 0x07d3, all -> 0x07c9 }
                java.lang.String r2 = r2.k     // Catch:{ Exception -> 0x07d3, all -> 0x07c9 }
                boolean r2 = android.text.TextUtils.isEmpty(r2)     // Catch:{ Exception -> 0x07d3, all -> 0x07c9 }
                if (r2 != 0) goto L_0x00a0
                long r2 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x07d3, all -> 0x07c9 }
                com.mbridge.msdk.reward.adapter.d r5 = com.mbridge.msdk.reward.adapter.d.this     // Catch:{ Exception -> 0x07d3, all -> 0x07c9 }
                long r5 = r5.K     // Catch:{ Exception -> 0x07d3, all -> 0x07c9 }
                long r2 = r2 - r5
                com.mbridge.msdk.reward.adapter.d r5 = com.mbridge.msdk.reward.adapter.d.this     // Catch:{ Exception -> 0x07d3, all -> 0x07c9 }
                android.content.Context r5 = r5.j     // Catch:{ Exception -> 0x07d3, all -> 0x07c9 }
                com.mbridge.msdk.reward.adapter.d r6 = com.mbridge.msdk.reward.adapter.d.this     // Catch:{ Exception -> 0x07d3, all -> 0x07c9 }
                java.util.List r6 = r6.D     // Catch:{ Exception -> 0x07d3, all -> 0x07c9 }
                com.mbridge.msdk.reward.adapter.d r7 = com.mbridge.msdk.reward.adapter.d.this     // Catch:{ Exception -> 0x07d3, all -> 0x07c9 }
                java.lang.String r7 = r7.k     // Catch:{ Exception -> 0x07d3, all -> 0x07c9 }
                com.mbridge.msdk.reward.b.a.a(r5, r6, r7, r2)     // Catch:{ Exception -> 0x07d3, all -> 0x07c9 }
            L_0x00a0:
                com.mbridge.msdk.reward.adapter.d r2 = com.mbridge.msdk.reward.adapter.d.this     // Catch:{ Exception -> 0x07d3, all -> 0x07c9 }
                com.mbridge.msdk.reward.adapter.b r2 = r2.s     // Catch:{ Exception -> 0x07d3, all -> 0x07c9 }
                r2.a()     // Catch:{ Exception -> 0x07d3, all -> 0x07c9 }
                goto L_0x07d8
            L_0x00ab:
                com.mbridge.msdk.reward.adapter.d r2 = com.mbridge.msdk.reward.adapter.d.this     // Catch:{ Exception -> 0x07d3, all -> 0x07c9 }
                com.mbridge.msdk.reward.adapter.b r2 = r2.s     // Catch:{ Exception -> 0x07d3, all -> 0x07c9 }
                if (r2 == 0) goto L_0x07d8
                com.mbridge.msdk.reward.adapter.d r2 = com.mbridge.msdk.reward.adapter.d.this     // Catch:{ Exception -> 0x07d3, all -> 0x07c9 }
                java.util.List r2 = r2.M     // Catch:{ Exception -> 0x07d3, all -> 0x07c9 }
                if (r2 == 0) goto L_0x0155
                com.mbridge.msdk.reward.adapter.d r2 = com.mbridge.msdk.reward.adapter.d.this     // Catch:{ Exception -> 0x07d3, all -> 0x07c9 }
                java.util.List r2 = r2.M     // Catch:{ Exception -> 0x07d3, all -> 0x07c9 }
                int r2 = r2.size()     // Catch:{ Exception -> 0x07d3, all -> 0x07c9 }
                if (r2 <= 0) goto L_0x0155
                com.mbridge.msdk.reward.adapter.d r2 = com.mbridge.msdk.reward.adapter.d.this     // Catch:{ Exception -> 0x07d3, all -> 0x07c9 }
                java.util.List r2 = r2.M     // Catch:{ Exception -> 0x07d3, all -> 0x07c9 }
                java.lang.Object r2 = r2.get(r14)     // Catch:{ Exception -> 0x07d3, all -> 0x07c9 }
                com.mbridge.msdk.foundation.entity.CampaignEx r2 = (com.mbridge.msdk.foundation.entity.CampaignEx) r2     // Catch:{ Exception -> 0x07d3, all -> 0x07c9 }
                java.lang.String r5 = r2.getCMPTEntryUrl()     // Catch:{ Exception -> 0x07d3, all -> 0x07c9 }
                boolean r5 = android.text.TextUtils.isEmpty(r5)     // Catch:{ Exception -> 0x07d3, all -> 0x07c9 }
                if (r5 != 0) goto L_0x00df
                r5 = r15
                goto L_0x00e0
            L_0x00df:
                r5 = r14
            L_0x00e0:
                int r2 = r2.getNscpt()     // Catch:{ Exception -> 0x07d3, all -> 0x07c9 }
                com.mbridge.msdk.reward.adapter.d r6 = com.mbridge.msdk.reward.adapter.d.this     // Catch:{ Exception -> 0x07d3, all -> 0x07c9 }
                com.mbridge.msdk.reward.adapter.d r7 = com.mbridge.msdk.reward.adapter.d.this     // Catch:{ Exception -> 0x07d3, all -> 0x07c9 }
                java.util.List r7 = r7.D     // Catch:{ Exception -> 0x07d3, all -> 0x07c9 }
                boolean r2 = r6.a((java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx>) r7, (boolean) r5, (int) r2, (boolean) r15)     // Catch:{ Exception -> 0x07d3, all -> 0x07c9 }
                if (r2 == 0) goto L_0x0155
                com.mbridge.msdk.reward.adapter.d r2 = com.mbridge.msdk.reward.adapter.d.this     // Catch:{ Exception -> 0x07d3, all -> 0x07c9 }
                com.mbridge.msdk.reward.adapter.d r3 = com.mbridge.msdk.reward.adapter.d.this     // Catch:{ Exception -> 0x07d3, all -> 0x07c9 }
                java.lang.String r3 = r3.k     // Catch:{ Exception -> 0x07d3, all -> 0x07c9 }
                com.mbridge.msdk.reward.adapter.d r5 = com.mbridge.msdk.reward.adapter.d.this     // Catch:{ Exception -> 0x07d3, all -> 0x07c9 }
                java.util.List r5 = r5.M     // Catch:{ Exception -> 0x07d3, all -> 0x07c9 }
                com.mbridge.msdk.reward.adapter.d r6 = com.mbridge.msdk.reward.adapter.d.this     // Catch:{ Exception -> 0x07d3, all -> 0x07c9 }
                java.util.List r6 = r6.N     // Catch:{ Exception -> 0x07d3, all -> 0x07c9 }
                com.mbridge.msdk.reward.adapter.d r7 = com.mbridge.msdk.reward.adapter.d.this     // Catch:{ Exception -> 0x07d3, all -> 0x07c9 }
                boolean r7 = r7.x     // Catch:{ Exception -> 0x07d3, all -> 0x07c9 }
                com.mbridge.msdk.reward.adapter.d.a((com.mbridge.msdk.reward.adapter.d) r2, (java.lang.String) r3, (java.util.List) r5, (java.util.List) r6, (boolean) r7)     // Catch:{ Exception -> 0x07d3, all -> 0x07c9 }
                r1.sendEmptyMessage(r12)     // Catch:{ Exception -> 0x07d3, all -> 0x07c9 }
                r1.removeMessages(r13)     // Catch:{ Exception -> 0x07d3, all -> 0x07c9 }
                com.mbridge.msdk.reward.adapter.d r2 = com.mbridge.msdk.reward.adapter.d.this     // Catch:{ Exception -> 0x07d3, all -> 0x07c9 }
                boolean r2 = r2.h     // Catch:{ Exception -> 0x07d3, all -> 0x07c9 }
                if (r2 != 0) goto L_0x0154
                com.mbridge.msdk.reward.adapter.d r2 = com.mbridge.msdk.reward.adapter.d.this     // Catch:{ Exception -> 0x07d3, all -> 0x07c9 }
                r2.h = r15     // Catch:{ Exception -> 0x07d3, all -> 0x07c9 }
                com.mbridge.msdk.reward.adapter.d r2 = com.mbridge.msdk.reward.adapter.d.this     // Catch:{ Exception -> 0x07d3, all -> 0x07c9 }
                java.lang.String r2 = r2.k     // Catch:{ Exception -> 0x07d3, all -> 0x07c9 }
                boolean r2 = android.text.TextUtils.isEmpty(r2)     // Catch:{ Exception -> 0x07d3, all -> 0x07c9 }
                if (r2 != 0) goto L_0x014b
                long r2 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x07d3, all -> 0x07c9 }
                com.mbridge.msdk.reward.adapter.d r5 = com.mbridge.msdk.reward.adapter.d.this     // Catch:{ Exception -> 0x07d3, all -> 0x07c9 }
                long r5 = r5.K     // Catch:{ Exception -> 0x07d3, all -> 0x07c9 }
                long r2 = r2 - r5
                com.mbridge.msdk.reward.adapter.d r5 = com.mbridge.msdk.reward.adapter.d.this     // Catch:{ Exception -> 0x07d3, all -> 0x07c9 }
                android.content.Context r5 = r5.j     // Catch:{ Exception -> 0x07d3, all -> 0x07c9 }
                com.mbridge.msdk.reward.adapter.d r6 = com.mbridge.msdk.reward.adapter.d.this     // Catch:{ Exception -> 0x07d3, all -> 0x07c9 }
                java.util.List r6 = r6.D     // Catch:{ Exception -> 0x07d3, all -> 0x07c9 }
                com.mbridge.msdk.reward.adapter.d r7 = com.mbridge.msdk.reward.adapter.d.this     // Catch:{ Exception -> 0x07d3, all -> 0x07c9 }
                java.lang.String r7 = r7.k     // Catch:{ Exception -> 0x07d3, all -> 0x07c9 }
                com.mbridge.msdk.reward.b.a.a(r5, r6, r7, r2)     // Catch:{ Exception -> 0x07d3, all -> 0x07c9 }
            L_0x014b:
                com.mbridge.msdk.reward.adapter.d r2 = com.mbridge.msdk.reward.adapter.d.this     // Catch:{ Exception -> 0x07d3, all -> 0x07c9 }
                com.mbridge.msdk.reward.adapter.b r2 = r2.s     // Catch:{ Exception -> 0x07d3, all -> 0x07c9 }
                r2.a()     // Catch:{ Exception -> 0x07d3, all -> 0x07c9 }
            L_0x0154:
                return
            L_0x0155:
                com.mbridge.msdk.reward.adapter.d r2 = com.mbridge.msdk.reward.adapter.d.this     // Catch:{ Exception -> 0x07d3, all -> 0x07c9 }
                com.mbridge.msdk.reward.adapter.d r5 = com.mbridge.msdk.reward.adapter.d.this     // Catch:{ Exception -> 0x07d3, all -> 0x07c9 }
                java.lang.String r5 = r5.k     // Catch:{ Exception -> 0x07d3, all -> 0x07c9 }
                com.mbridge.msdk.reward.adapter.d r6 = com.mbridge.msdk.reward.adapter.d.this     // Catch:{ Exception -> 0x07d3, all -> 0x07c9 }
                java.util.List r6 = r6.M     // Catch:{ Exception -> 0x07d3, all -> 0x07c9 }
                com.mbridge.msdk.reward.adapter.d r7 = com.mbridge.msdk.reward.adapter.d.this     // Catch:{ Exception -> 0x07d3, all -> 0x07c9 }
                boolean r7 = r7.x     // Catch:{ Exception -> 0x07d3, all -> 0x07c9 }
                com.mbridge.msdk.reward.adapter.d.a((com.mbridge.msdk.reward.adapter.d) r2, (java.lang.String) r5, (java.util.List) r6, (boolean) r7)     // Catch:{ Exception -> 0x07d3, all -> 0x07c9 }
                com.mbridge.msdk.reward.adapter.d r2 = com.mbridge.msdk.reward.adapter.d.this     // Catch:{ Exception -> 0x07d3, all -> 0x07c9 }
                android.os.Handler r2 = r2.J     // Catch:{ Exception -> 0x07d3, all -> 0x07c9 }
                if (r2 == 0) goto L_0x0186
                com.mbridge.msdk.reward.adapter.d r2 = com.mbridge.msdk.reward.adapter.d.this     // Catch:{ Exception -> 0x07d3, all -> 0x07c9 }
                android.os.Handler r2 = r2.J     // Catch:{ Exception -> 0x07d3, all -> 0x07c9 }
                r2.removeMessages(r13)     // Catch:{ Exception -> 0x07d3, all -> 0x07c9 }
                com.mbridge.msdk.reward.adapter.d r2 = com.mbridge.msdk.reward.adapter.d.this     // Catch:{ Exception -> 0x07d3, all -> 0x07c9 }
                android.os.Handler r2 = r2.J     // Catch:{ Exception -> 0x07d3, all -> 0x07c9 }
                r2.removeMessages(r12)     // Catch:{ Exception -> 0x07d3, all -> 0x07c9 }
            L_0x0186:
                com.mbridge.msdk.reward.adapter.d r2 = com.mbridge.msdk.reward.adapter.d.this     // Catch:{ Exception -> 0x07d3, all -> 0x07c9 }
                boolean r2 = r2.i     // Catch:{ Exception -> 0x07d3, all -> 0x07c9 }
                if (r2 != 0) goto L_0x07d8
                com.mbridge.msdk.reward.adapter.d r2 = com.mbridge.msdk.reward.adapter.d.this     // Catch:{ Exception -> 0x07d3, all -> 0x07c9 }
                r2.i = r15     // Catch:{ Exception -> 0x07d3, all -> 0x07c9 }
                com.mbridge.msdk.reward.adapter.d r2 = com.mbridge.msdk.reward.adapter.d.this     // Catch:{ Exception -> 0x07d3, all -> 0x07c9 }
                java.util.List r2 = r2.M     // Catch:{ Exception -> 0x07d3, all -> 0x07c9 }
                if (r2 == 0) goto L_0x01b1
                com.mbridge.msdk.reward.adapter.d r2 = com.mbridge.msdk.reward.adapter.d.this     // Catch:{ Exception -> 0x07d3, all -> 0x07c9 }
                java.util.List r2 = r2.M     // Catch:{ Exception -> 0x07d3, all -> 0x07c9 }
                int r2 = r2.size()     // Catch:{ Exception -> 0x07d3, all -> 0x07c9 }
                if (r2 <= 0) goto L_0x01b1
                com.mbridge.msdk.reward.adapter.d r2 = com.mbridge.msdk.reward.adapter.d.this     // Catch:{ Exception -> 0x07d3, all -> 0x07c9 }
                java.util.List r2 = r2.M     // Catch:{ Exception -> 0x07d3, all -> 0x07c9 }
                java.lang.Object r2 = r2.get(r14)     // Catch:{ Exception -> 0x07d3, all -> 0x07c9 }
                r11 = r2
                com.mbridge.msdk.foundation.entity.CampaignEx r11 = (com.mbridge.msdk.foundation.entity.CampaignEx) r11     // Catch:{ Exception -> 0x07d3, all -> 0x07c9 }
            L_0x01b1:
                if (r11 == 0) goto L_0x01fc
                com.mbridge.msdk.reward.adapter.d r2 = com.mbridge.msdk.reward.adapter.d.this     // Catch:{ Exception -> 0x07d3, all -> 0x07c9 }
                android.content.Context r17 = r2.j     // Catch:{ Exception -> 0x07d3, all -> 0x07c9 }
                java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x07d3, all -> 0x07c9 }
                r2.<init>()     // Catch:{ Exception -> 0x07d3, all -> 0x07c9 }
                java.lang.String r5 = "resource load timeout is tpl: "
                r2.append(r5)     // Catch:{ Exception -> 0x07d3, all -> 0x07c9 }
                java.lang.String r5 = r11.getCMPTEntryUrl()     // Catch:{ Exception -> 0x07d3, all -> 0x07c9 }
                boolean r5 = android.text.TextUtils.isEmpty(r5)     // Catch:{ Exception -> 0x07d3, all -> 0x07c9 }
                if (r5 != 0) goto L_0x01cf
                r5 = r15
                goto L_0x01d0
            L_0x01cf:
                r5 = r14
            L_0x01d0:
                r2.append(r5)     // Catch:{ Exception -> 0x07d3, all -> 0x07c9 }
                java.lang.String r18 = r2.toString()     // Catch:{ Exception -> 0x07d3, all -> 0x07c9 }
                com.mbridge.msdk.reward.adapter.d r2 = com.mbridge.msdk.reward.adapter.d.this     // Catch:{ Exception -> 0x07d3, all -> 0x07c9 }
                java.lang.String r19 = r2.k     // Catch:{ Exception -> 0x07d3, all -> 0x07c9 }
                com.mbridge.msdk.reward.adapter.d r2 = com.mbridge.msdk.reward.adapter.d.this     // Catch:{ Exception -> 0x07d3, all -> 0x07c9 }
                boolean r20 = r2.x     // Catch:{ Exception -> 0x07d3, all -> 0x07c9 }
                if (r11 != 0) goto L_0x01e8
                r21 = r10
                goto L_0x01ee
            L_0x01e8:
                java.lang.String r2 = r11.getRequestId()     // Catch:{ Exception -> 0x07d3, all -> 0x07c9 }
                r21 = r2
            L_0x01ee:
                if (r11 != 0) goto L_0x01f1
                goto L_0x01f5
            L_0x01f1:
                java.lang.String r10 = r11.getRequestIdNotice()     // Catch:{ Exception -> 0x07d3, all -> 0x07c9 }
            L_0x01f5:
                r22 = r10
                r16 = r11
                com.mbridge.msdk.reward.b.a.a(r16, r17, r18, r19, r20, r21, r22)     // Catch:{ Exception -> 0x07d3, all -> 0x07c9 }
            L_0x01fc:
                com.mbridge.msdk.reward.adapter.d r2 = com.mbridge.msdk.reward.adapter.d.this     // Catch:{ Exception -> 0x07d3, all -> 0x07c9 }
                com.mbridge.msdk.reward.adapter.b r2 = r2.s     // Catch:{ Exception -> 0x07d3, all -> 0x07c9 }
                java.lang.String r5 = "errorCode: 3401 errorMessage: resource load timeout"
                r2.a(r5)     // Catch:{ Exception -> 0x07d3, all -> 0x07c9 }
                com.mbridge.msdk.reward.adapter.d r2 = com.mbridge.msdk.reward.adapter.d.this     // Catch:{ Exception -> 0x07d3, all -> 0x07c9 }
                java.util.List r2 = r2.D     // Catch:{ Exception -> 0x07d3, all -> 0x07c9 }
                if (r2 == 0) goto L_0x07d8
                com.mbridge.msdk.reward.adapter.d r2 = com.mbridge.msdk.reward.adapter.d.this     // Catch:{ Exception -> 0x07d3, all -> 0x07c9 }
                java.util.List r2 = r2.D     // Catch:{ Exception -> 0x07d3, all -> 0x07c9 }
                int r2 = r2.size()     // Catch:{ Exception -> 0x07d3, all -> 0x07c9 }
                if (r2 <= 0) goto L_0x07d8
                com.mbridge.msdk.reward.adapter.d r2 = com.mbridge.msdk.reward.adapter.d.this     // Catch:{ Exception -> 0x07d3, all -> 0x07c9 }
                java.util.List r2 = r2.D     // Catch:{ Exception -> 0x07d3, all -> 0x07c9 }
                java.util.Iterator r2 = r2.iterator()     // Catch:{ Exception -> 0x07d3, all -> 0x07c9 }
                r5 = r14
            L_0x0226:
                boolean r6 = r2.hasNext()     // Catch:{ Exception -> 0x07d3, all -> 0x07c9 }
                if (r6 == 0) goto L_0x07d8
                java.lang.Object r6 = r2.next()     // Catch:{ Exception -> 0x07d3, all -> 0x07c9 }
                com.mbridge.msdk.foundation.entity.CampaignEx r6 = (com.mbridge.msdk.foundation.entity.CampaignEx) r6     // Catch:{ Exception -> 0x07d3, all -> 0x07c9 }
                if (r6 == 0) goto L_0x0297
                java.lang.String r7 = r6.getVideoUrlEncode()     // Catch:{ Exception -> 0x0226, all -> 0x07c9 }
                boolean r7 = android.text.TextUtils.isEmpty(r7)     // Catch:{ Exception -> 0x0226, all -> 0x07c9 }
                if (r7 != 0) goto L_0x0297
                com.mbridge.msdk.videocommon.download.i r7 = com.mbridge.msdk.videocommon.download.i.a()     // Catch:{ Exception -> 0x0226, all -> 0x07c9 }
                java.lang.String r8 = r6.getVideoUrlEncode()     // Catch:{ Exception -> 0x0226, all -> 0x07c9 }
                boolean r7 = r7.a((java.lang.String) r8)     // Catch:{ Exception -> 0x0226, all -> 0x07c9 }
                if (r7 != 0) goto L_0x0297
                com.mbridge.msdk.reward.adapter.d r7 = com.mbridge.msdk.reward.adapter.d.this     // Catch:{ Exception -> 0x0295, all -> 0x07c9 }
                android.content.Context r17 = r7.j     // Catch:{ Exception -> 0x0295, all -> 0x07c9 }
                java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0295, all -> 0x07c9 }
                r7.<init>()     // Catch:{ Exception -> 0x0295, all -> 0x07c9 }
                java.lang.String r8 = "resource load timeout exception video is tpl: "
                r7.append(r8)     // Catch:{ Exception -> 0x0295, all -> 0x07c9 }
                java.lang.String r8 = r11.getCMPTEntryUrl()     // Catch:{ Exception -> 0x0295, all -> 0x07c9 }
                boolean r8 = android.text.TextUtils.isEmpty(r8)     // Catch:{ Exception -> 0x0295, all -> 0x07c9 }
                if (r8 != 0) goto L_0x0268
                r8 = r15
                goto L_0x0269
            L_0x0268:
                r8 = r14
            L_0x0269:
                r7.append(r8)     // Catch:{ Exception -> 0x0295, all -> 0x07c9 }
                java.lang.String r18 = r7.toString()     // Catch:{ Exception -> 0x0295, all -> 0x07c9 }
                com.mbridge.msdk.reward.adapter.d r7 = com.mbridge.msdk.reward.adapter.d.this     // Catch:{ Exception -> 0x0295, all -> 0x07c9 }
                java.lang.String r19 = r7.k     // Catch:{ Exception -> 0x0295, all -> 0x07c9 }
                com.mbridge.msdk.reward.adapter.d r7 = com.mbridge.msdk.reward.adapter.d.this     // Catch:{ Exception -> 0x0295, all -> 0x07c9 }
                boolean r20 = r7.x     // Catch:{ Exception -> 0x0295, all -> 0x07c9 }
                java.lang.String r21 = r6.getRequestId()     // Catch:{ Exception -> 0x0295, all -> 0x07c9 }
                java.lang.String r22 = r6.getRequestIdNotice()     // Catch:{ Exception -> 0x0295, all -> 0x07c9 }
                long r7 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x0295, all -> 0x07c9 }
                com.mbridge.msdk.reward.adapter.d r9 = com.mbridge.msdk.reward.adapter.d.this     // Catch:{ Exception -> 0x0295, all -> 0x07c9 }
                long r9 = r9.K     // Catch:{ Exception -> 0x0295, all -> 0x07c9 }
                long r23 = r7 - r9
                r16 = r11
                com.mbridge.msdk.reward.b.a.a(r16, r17, r18, r19, r20, r21, r22, r23)     // Catch:{ Exception -> 0x0295, all -> 0x07c9 }
            L_0x0295:
                r7 = r15
                goto L_0x0298
            L_0x0297:
                r7 = r14
            L_0x0298:
                if (r6 == 0) goto L_0x02fc
                java.lang.String r8 = r6.getendcard_url()     // Catch:{ Exception -> 0x0226, all -> 0x07c9 }
                boolean r8 = android.text.TextUtils.isEmpty(r8)     // Catch:{ Exception -> 0x0226, all -> 0x07c9 }
                if (r8 != 0) goto L_0x02fc
                com.mbridge.msdk.videocommon.download.i r8 = com.mbridge.msdk.videocommon.download.i.a()     // Catch:{ Exception -> 0x0226, all -> 0x07c9 }
                java.lang.String r9 = r6.getendcard_url()     // Catch:{ Exception -> 0x0226, all -> 0x07c9 }
                boolean r8 = r8.b(r9)     // Catch:{ Exception -> 0x0226, all -> 0x07c9 }
                if (r8 != 0) goto L_0x02fc
                com.mbridge.msdk.reward.adapter.d r7 = com.mbridge.msdk.reward.adapter.d.this     // Catch:{ Exception -> 0x02fb, all -> 0x07c9 }
                android.content.Context r17 = r7.j     // Catch:{ Exception -> 0x02fb, all -> 0x07c9 }
                java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x02fb, all -> 0x07c9 }
                r7.<init>()     // Catch:{ Exception -> 0x02fb, all -> 0x07c9 }
                java.lang.String r8 = "resource load timeout exception endcard is tpl: "
                r7.append(r8)     // Catch:{ Exception -> 0x02fb, all -> 0x07c9 }
                java.lang.String r8 = r11.getCMPTEntryUrl()     // Catch:{ Exception -> 0x02fb, all -> 0x07c9 }
                boolean r8 = android.text.TextUtils.isEmpty(r8)     // Catch:{ Exception -> 0x02fb, all -> 0x07c9 }
                if (r8 != 0) goto L_0x02ce
                r8 = r15
                goto L_0x02cf
            L_0x02ce:
                r8 = r14
            L_0x02cf:
                r7.append(r8)     // Catch:{ Exception -> 0x02fb, all -> 0x07c9 }
                java.lang.String r18 = r7.toString()     // Catch:{ Exception -> 0x02fb, all -> 0x07c9 }
                com.mbridge.msdk.reward.adapter.d r7 = com.mbridge.msdk.reward.adapter.d.this     // Catch:{ Exception -> 0x02fb, all -> 0x07c9 }
                java.lang.String r19 = r7.k     // Catch:{ Exception -> 0x02fb, all -> 0x07c9 }
                com.mbridge.msdk.reward.adapter.d r7 = com.mbridge.msdk.reward.adapter.d.this     // Catch:{ Exception -> 0x02fb, all -> 0x07c9 }
                boolean r20 = r7.x     // Catch:{ Exception -> 0x02fb, all -> 0x07c9 }
                java.lang.String r21 = r6.getRequestId()     // Catch:{ Exception -> 0x02fb, all -> 0x07c9 }
                java.lang.String r22 = r6.getRequestIdNotice()     // Catch:{ Exception -> 0x02fb, all -> 0x07c9 }
                long r7 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x02fb, all -> 0x07c9 }
                com.mbridge.msdk.reward.adapter.d r9 = com.mbridge.msdk.reward.adapter.d.this     // Catch:{ Exception -> 0x02fb, all -> 0x07c9 }
                long r9 = r9.K     // Catch:{ Exception -> 0x02fb, all -> 0x07c9 }
                long r23 = r7 - r9
                r16 = r11
                com.mbridge.msdk.reward.b.a.a(r16, r17, r18, r19, r20, r21, r22, r23)     // Catch:{ Exception -> 0x02fb, all -> 0x07c9 }
            L_0x02fb:
                r7 = r15
            L_0x02fc:
                if (r6 == 0) goto L_0x03a3
                java.lang.String r8 = r6.getCMPTEntryUrl()     // Catch:{ Exception -> 0x0226, all -> 0x07c9 }
                boolean r8 = android.text.TextUtils.isEmpty(r8)     // Catch:{ Exception -> 0x0226, all -> 0x07c9 }
                if (r8 != 0) goto L_0x03a3
                com.mbridge.msdk.videocommon.download.i r8 = com.mbridge.msdk.videocommon.download.i.a()     // Catch:{ Exception -> 0x0226, all -> 0x07c9 }
                java.lang.String r9 = r6.getCMPTEntryUrl()     // Catch:{ Exception -> 0x0226, all -> 0x07c9 }
                boolean r8 = r8.b(r9)     // Catch:{ Exception -> 0x0226, all -> 0x07c9 }
                if (r8 != 0) goto L_0x0345
                com.mbridge.msdk.reward.adapter.d r7 = com.mbridge.msdk.reward.adapter.d.this     // Catch:{ Exception -> 0x0343, all -> 0x07c9 }
                android.content.Context r17 = r7.j     // Catch:{ Exception -> 0x0343, all -> 0x07c9 }
                java.lang.String r18 = "resource load timeout exception tpl"
                com.mbridge.msdk.reward.adapter.d r7 = com.mbridge.msdk.reward.adapter.d.this     // Catch:{ Exception -> 0x0343, all -> 0x07c9 }
                java.lang.String r19 = r7.k     // Catch:{ Exception -> 0x0343, all -> 0x07c9 }
                com.mbridge.msdk.reward.adapter.d r7 = com.mbridge.msdk.reward.adapter.d.this     // Catch:{ Exception -> 0x0343, all -> 0x07c9 }
                boolean r20 = r7.x     // Catch:{ Exception -> 0x0343, all -> 0x07c9 }
                java.lang.String r21 = r6.getRequestId()     // Catch:{ Exception -> 0x0343, all -> 0x07c9 }
                java.lang.String r22 = r6.getRequestIdNotice()     // Catch:{ Exception -> 0x0343, all -> 0x07c9 }
                long r7 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x0343, all -> 0x07c9 }
                com.mbridge.msdk.reward.adapter.d r9 = com.mbridge.msdk.reward.adapter.d.this     // Catch:{ Exception -> 0x0343, all -> 0x07c9 }
                long r9 = r9.K     // Catch:{ Exception -> 0x0343, all -> 0x07c9 }
                long r23 = r7 - r9
                r16 = r11
                com.mbridge.msdk.reward.b.a.a(r16, r17, r18, r19, r20, r21, r22, r23)     // Catch:{ Exception -> 0x0343, all -> 0x07c9 }
            L_0x0343:
                r7 = r15
                goto L_0x03a3
            L_0x0345:
                if (r5 != 0) goto L_0x03a3
                if (r7 != 0) goto L_0x03a3
                java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0226, all -> 0x07c9 }
                r8.<init>()     // Catch:{ Exception -> 0x0226, all -> 0x07c9 }
                com.mbridge.msdk.reward.adapter.d r9 = com.mbridge.msdk.reward.adapter.d.this     // Catch:{ Exception -> 0x0226, all -> 0x07c9 }
                java.lang.String r9 = r9.k     // Catch:{ Exception -> 0x0226, all -> 0x07c9 }
                r8.append(r9)     // Catch:{ Exception -> 0x0226, all -> 0x07c9 }
                r8.append(r3)     // Catch:{ Exception -> 0x0226, all -> 0x07c9 }
                java.lang.String r9 = r6.getRequestId()     // Catch:{ Exception -> 0x0226, all -> 0x07c9 }
                r8.append(r9)     // Catch:{ Exception -> 0x0226, all -> 0x07c9 }
                r8.append(r3)     // Catch:{ Exception -> 0x0226, all -> 0x07c9 }
                java.lang.String r9 = r6.getCMPTEntryUrl()     // Catch:{ Exception -> 0x0226, all -> 0x07c9 }
                r8.append(r9)     // Catch:{ Exception -> 0x0226, all -> 0x07c9 }
                java.lang.String r8 = r8.toString()     // Catch:{ Exception -> 0x0226, all -> 0x07c9 }
                com.mbridge.msdk.videocommon.a$a r8 = com.mbridge.msdk.videocommon.a.a(r8)     // Catch:{ Exception -> 0x0226, all -> 0x07c9 }
                if (r8 != 0) goto L_0x03a3
                com.mbridge.msdk.reward.adapter.d r5 = com.mbridge.msdk.reward.adapter.d.this     // Catch:{ Exception -> 0x03a2, all -> 0x07c9 }
                android.content.Context r17 = r5.j     // Catch:{ Exception -> 0x03a2, all -> 0x07c9 }
                java.lang.String r18 = "resource load timeout exception tpl preload"
                com.mbridge.msdk.reward.adapter.d r5 = com.mbridge.msdk.reward.adapter.d.this     // Catch:{ Exception -> 0x03a2, all -> 0x07c9 }
                java.lang.String r19 = r5.k     // Catch:{ Exception -> 0x03a2, all -> 0x07c9 }
                com.mbridge.msdk.reward.adapter.d r5 = com.mbridge.msdk.reward.adapter.d.this     // Catch:{ Exception -> 0x03a2, all -> 0x07c9 }
                boolean r20 = r5.x     // Catch:{ Exception -> 0x03a2, all -> 0x07c9 }
                java.lang.String r21 = r6.getRequestId()     // Catch:{ Exception -> 0x03a2, all -> 0x07c9 }
                java.lang.String r22 = r6.getRequestIdNotice()     // Catch:{ Exception -> 0x03a2, all -> 0x07c9 }
                long r8 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x03a2, all -> 0x07c9 }
                com.mbridge.msdk.reward.adapter.d r5 = com.mbridge.msdk.reward.adapter.d.this     // Catch:{ Exception -> 0x03a2, all -> 0x07c9 }
                long r12 = r5.K     // Catch:{ Exception -> 0x03a2, all -> 0x07c9 }
                long r23 = r8 - r12
                r16 = r11
                com.mbridge.msdk.reward.b.a.a(r16, r17, r18, r19, r20, r21, r22, r23)     // Catch:{ Exception -> 0x03a2, all -> 0x07c9 }
            L_0x03a2:
                r5 = r15
            L_0x03a3:
                if (r6 == 0) goto L_0x0226
                com.mbridge.msdk.foundation.entity.CampaignEx$c r8 = r6.getRewardTemplateMode()     // Catch:{ Exception -> 0x0226, all -> 0x07c9 }
                if (r8 == 0) goto L_0x0226
                com.mbridge.msdk.foundation.entity.CampaignEx$c r8 = r6.getRewardTemplateMode()     // Catch:{ Exception -> 0x0226, all -> 0x07c9 }
                java.lang.String r8 = r8.e()     // Catch:{ Exception -> 0x0226, all -> 0x07c9 }
                boolean r8 = android.text.TextUtils.isEmpty(r8)     // Catch:{ Exception -> 0x0226, all -> 0x07c9 }
                if (r8 != 0) goto L_0x0226
                com.mbridge.msdk.foundation.entity.CampaignEx$c r8 = r6.getRewardTemplateMode()     // Catch:{ Exception -> 0x0226, all -> 0x07c9 }
                java.lang.String r8 = r8.e()     // Catch:{ Exception -> 0x0226, all -> 0x07c9 }
                java.lang.String r9 = "cmpt=1"
                boolean r8 = r8.contains(r9)     // Catch:{ Exception -> 0x0226, all -> 0x07c9 }
                if (r8 != 0) goto L_0x0226
                com.mbridge.msdk.videocommon.download.i r8 = com.mbridge.msdk.videocommon.download.i.a()     // Catch:{ Exception -> 0x0226, all -> 0x07c9 }
                com.mbridge.msdk.foundation.entity.CampaignEx$c r9 = r6.getRewardTemplateMode()     // Catch:{ Exception -> 0x0226, all -> 0x07c9 }
                java.lang.String r9 = r9.e()     // Catch:{ Exception -> 0x0226, all -> 0x07c9 }
                boolean r8 = r8.b(r9)     // Catch:{ Exception -> 0x0226, all -> 0x07c9 }
                if (r8 != 0) goto L_0x0426
                com.mbridge.msdk.reward.adapter.d r7 = com.mbridge.msdk.reward.adapter.d.this     // Catch:{ Exception -> 0x0226, all -> 0x07c9 }
                android.content.Context r17 = r7.j     // Catch:{ Exception -> 0x0226, all -> 0x07c9 }
                java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0226, all -> 0x07c9 }
                r7.<init>()     // Catch:{ Exception -> 0x0226, all -> 0x07c9 }
                java.lang.String r8 = "resource load timeout exception template is tpl: "
                r7.append(r8)     // Catch:{ Exception -> 0x0226, all -> 0x07c9 }
                java.lang.String r8 = r11.getCMPTEntryUrl()     // Catch:{ Exception -> 0x0226, all -> 0x07c9 }
                boolean r8 = android.text.TextUtils.isEmpty(r8)     // Catch:{ Exception -> 0x0226, all -> 0x07c9 }
                if (r8 != 0) goto L_0x03f7
                r8 = r15
                goto L_0x03f8
            L_0x03f7:
                r8 = r14
            L_0x03f8:
                r7.append(r8)     // Catch:{ Exception -> 0x0226, all -> 0x07c9 }
                java.lang.String r18 = r7.toString()     // Catch:{ Exception -> 0x0226, all -> 0x07c9 }
                com.mbridge.msdk.reward.adapter.d r7 = com.mbridge.msdk.reward.adapter.d.this     // Catch:{ Exception -> 0x0226, all -> 0x07c9 }
                java.lang.String r19 = r7.k     // Catch:{ Exception -> 0x0226, all -> 0x07c9 }
                com.mbridge.msdk.reward.adapter.d r7 = com.mbridge.msdk.reward.adapter.d.this     // Catch:{ Exception -> 0x0226, all -> 0x07c9 }
                boolean r20 = r7.x     // Catch:{ Exception -> 0x0226, all -> 0x07c9 }
                java.lang.String r21 = r6.getRequestId()     // Catch:{ Exception -> 0x0226, all -> 0x07c9 }
                java.lang.String r22 = r6.getRequestIdNotice()     // Catch:{ Exception -> 0x0226, all -> 0x07c9 }
                long r6 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x0226, all -> 0x07c9 }
                com.mbridge.msdk.reward.adapter.d r8 = com.mbridge.msdk.reward.adapter.d.this     // Catch:{ Exception -> 0x0226, all -> 0x07c9 }
                long r8 = r8.K     // Catch:{ Exception -> 0x0226, all -> 0x07c9 }
                long r23 = r6 - r8
                r16 = r11
                com.mbridge.msdk.reward.b.a.a(r16, r17, r18, r19, r20, r21, r22, r23)     // Catch:{ Exception -> 0x0226, all -> 0x07c9 }
                goto L_0x0226
            L_0x0426:
                java.lang.String r8 = r6.getCMPTEntryUrl()     // Catch:{ Exception -> 0x0226, all -> 0x07c9 }
                boolean r8 = android.text.TextUtils.isEmpty(r8)     // Catch:{ Exception -> 0x0226, all -> 0x07c9 }
                if (r8 == 0) goto L_0x0226
                if (r7 != 0) goto L_0x0226
                int r7 = r6.getAdType()     // Catch:{ Exception -> 0x0226, all -> 0x07c9 }
                com.mbridge.msdk.videocommon.a$a r7 = com.mbridge.msdk.videocommon.a.a(r7, r6)     // Catch:{ Exception -> 0x0226, all -> 0x07c9 }
                if (r7 != 0) goto L_0x0226
                com.mbridge.msdk.reward.adapter.d r7 = com.mbridge.msdk.reward.adapter.d.this     // Catch:{ Exception -> 0x0226, all -> 0x07c9 }
                android.content.Context r17 = r7.j     // Catch:{ Exception -> 0x0226, all -> 0x07c9 }
                java.lang.String r18 = "resource load timeout exception template preload"
                com.mbridge.msdk.reward.adapter.d r7 = com.mbridge.msdk.reward.adapter.d.this     // Catch:{ Exception -> 0x0226, all -> 0x07c9 }
                java.lang.String r19 = r7.k     // Catch:{ Exception -> 0x0226, all -> 0x07c9 }
                com.mbridge.msdk.reward.adapter.d r7 = com.mbridge.msdk.reward.adapter.d.this     // Catch:{ Exception -> 0x0226, all -> 0x07c9 }
                boolean r20 = r7.x     // Catch:{ Exception -> 0x0226, all -> 0x07c9 }
                java.lang.String r21 = r6.getRequestId()     // Catch:{ Exception -> 0x0226, all -> 0x07c9 }
                java.lang.String r22 = r6.getRequestIdNotice()     // Catch:{ Exception -> 0x0226, all -> 0x07c9 }
                long r6 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x0226, all -> 0x07c9 }
                com.mbridge.msdk.reward.adapter.d r8 = com.mbridge.msdk.reward.adapter.d.this     // Catch:{ Exception -> 0x0226, all -> 0x07c9 }
                long r8 = r8.K     // Catch:{ Exception -> 0x0226, all -> 0x07c9 }
                long r23 = r6 - r8
                r16 = r11
                com.mbridge.msdk.reward.b.a.a(r16, r17, r18, r19, r20, r21, r22, r23)     // Catch:{ Exception -> 0x0226, all -> 0x07c9 }
                goto L_0x0226
            L_0x046b:
                com.mbridge.msdk.reward.adapter.d r3 = com.mbridge.msdk.reward.adapter.d.this     // Catch:{ Exception -> 0x07d3, all -> 0x07c9 }
                com.mbridge.msdk.reward.adapter.b r3 = r3.s     // Catch:{ Exception -> 0x07d3, all -> 0x07c9 }
                if (r3 == 0) goto L_0x07d8
                com.mbridge.msdk.reward.adapter.d r3 = com.mbridge.msdk.reward.adapter.d.this     // Catch:{ Exception -> 0x07d3, all -> 0x07c9 }
                com.mbridge.msdk.reward.adapter.d r5 = com.mbridge.msdk.reward.adapter.d.this     // Catch:{ Exception -> 0x07d3, all -> 0x07c9 }
                java.lang.String r5 = r5.k     // Catch:{ Exception -> 0x07d3, all -> 0x07c9 }
                com.mbridge.msdk.reward.adapter.d r6 = com.mbridge.msdk.reward.adapter.d.this     // Catch:{ Exception -> 0x07d3, all -> 0x07c9 }
                java.util.List r6 = r6.M     // Catch:{ Exception -> 0x07d3, all -> 0x07c9 }
                com.mbridge.msdk.reward.adapter.d r7 = com.mbridge.msdk.reward.adapter.d.this     // Catch:{ Exception -> 0x07d3, all -> 0x07c9 }
                boolean r7 = r7.x     // Catch:{ Exception -> 0x07d3, all -> 0x07c9 }
                com.mbridge.msdk.reward.adapter.d.a((com.mbridge.msdk.reward.adapter.d) r3, (java.lang.String) r5, (java.util.List) r6, (boolean) r7)     // Catch:{ Exception -> 0x07d3, all -> 0x07c9 }
                com.mbridge.msdk.reward.adapter.d r3 = com.mbridge.msdk.reward.adapter.d.this     // Catch:{ Exception -> 0x07d3, all -> 0x07c9 }
                java.util.List r3 = r3.M     // Catch:{ Exception -> 0x07d3, all -> 0x07c9 }
                if (r3 == 0) goto L_0x04ab
                com.mbridge.msdk.reward.adapter.d r3 = com.mbridge.msdk.reward.adapter.d.this     // Catch:{ Exception -> 0x07d3, all -> 0x07c9 }
                java.util.List r3 = r3.M     // Catch:{ Exception -> 0x07d3, all -> 0x07c9 }
                int r3 = r3.size()     // Catch:{ Exception -> 0x07d3, all -> 0x07c9 }
                if (r3 <= 0) goto L_0x04ab
                com.mbridge.msdk.reward.adapter.d r3 = com.mbridge.msdk.reward.adapter.d.this     // Catch:{ Exception -> 0x07d3, all -> 0x07c9 }
                java.util.List r3 = r3.M     // Catch:{ Exception -> 0x07d3, all -> 0x07c9 }
                java.lang.Object r3 = r3.get(r14)     // Catch:{ Exception -> 0x07d3, all -> 0x07c9 }
                r11 = r3
                com.mbridge.msdk.foundation.entity.CampaignEx r11 = (com.mbridge.msdk.foundation.entity.CampaignEx) r11     // Catch:{ Exception -> 0x07d3, all -> 0x07c9 }
            L_0x04ab:
                java.lang.Object r3 = r2.obj     // Catch:{ Exception -> 0x060c, all -> 0x07c9 }
                if (r3 != 0) goto L_0x051b
                com.mbridge.msdk.reward.adapter.d r2 = com.mbridge.msdk.reward.adapter.d.this     // Catch:{ Exception -> 0x060c, all -> 0x07c9 }
                android.os.Handler r2 = r2.J     // Catch:{ Exception -> 0x060c, all -> 0x07c9 }
                if (r2 == 0) goto L_0x04c0
                com.mbridge.msdk.reward.adapter.d r2 = com.mbridge.msdk.reward.adapter.d.this     // Catch:{ Exception -> 0x060c, all -> 0x07c9 }
                android.os.Handler r2 = r2.J     // Catch:{ Exception -> 0x060c, all -> 0x07c9 }
                r2.removeMessages(r13)     // Catch:{ Exception -> 0x060c, all -> 0x07c9 }
            L_0x04c0:
                r1.removeMessages(r12)     // Catch:{ Exception -> 0x060c, all -> 0x07c9 }
                com.mbridge.msdk.reward.adapter.d r2 = com.mbridge.msdk.reward.adapter.d.this     // Catch:{ Exception -> 0x060c, all -> 0x07c9 }
                boolean r2 = r2.i     // Catch:{ Exception -> 0x060c, all -> 0x07c9 }
                if (r2 != 0) goto L_0x07d8
                com.mbridge.msdk.reward.adapter.d r2 = com.mbridge.msdk.reward.adapter.d.this     // Catch:{ Exception -> 0x060c, all -> 0x07c9 }
                r2.i = r15     // Catch:{ Exception -> 0x060c, all -> 0x07c9 }
                if (r11 == 0) goto L_0x04f1
                com.mbridge.msdk.reward.adapter.d r2 = com.mbridge.msdk.reward.adapter.d.this     // Catch:{ Exception -> 0x060c, all -> 0x07c9 }
                android.content.Context r17 = r2.j     // Catch:{ Exception -> 0x060c, all -> 0x07c9 }
                java.lang.String r18 = "data load failed"
                com.mbridge.msdk.reward.adapter.d r2 = com.mbridge.msdk.reward.adapter.d.this     // Catch:{ Exception -> 0x060c, all -> 0x07c9 }
                java.lang.String r19 = r2.k     // Catch:{ Exception -> 0x060c, all -> 0x07c9 }
                com.mbridge.msdk.reward.adapter.d r2 = com.mbridge.msdk.reward.adapter.d.this     // Catch:{ Exception -> 0x060c, all -> 0x07c9 }
                boolean r20 = r2.x     // Catch:{ Exception -> 0x060c, all -> 0x07c9 }
                java.lang.String r21 = r11.getRequestId()     // Catch:{ Exception -> 0x060c, all -> 0x07c9 }
                java.lang.String r22 = r11.getRequestIdNotice()     // Catch:{ Exception -> 0x060c, all -> 0x07c9 }
                r16 = r11
                com.mbridge.msdk.reward.b.a.a(r16, r17, r18, r19, r20, r21, r22)     // Catch:{ Exception -> 0x060c, all -> 0x07c9 }
                goto L_0x050e
            L_0x04f1:
                com.mbridge.msdk.reward.adapter.d r2 = com.mbridge.msdk.reward.adapter.d.this     // Catch:{ Exception -> 0x060c, all -> 0x07c9 }
                android.content.Context r17 = r2.j     // Catch:{ Exception -> 0x060c, all -> 0x07c9 }
                java.lang.String r18 = "data load failed"
                com.mbridge.msdk.reward.adapter.d r2 = com.mbridge.msdk.reward.adapter.d.this     // Catch:{ Exception -> 0x060c, all -> 0x07c9 }
                java.lang.String r19 = r2.k     // Catch:{ Exception -> 0x060c, all -> 0x07c9 }
                com.mbridge.msdk.reward.adapter.d r2 = com.mbridge.msdk.reward.adapter.d.this     // Catch:{ Exception -> 0x060c, all -> 0x07c9 }
                boolean r20 = r2.x     // Catch:{ Exception -> 0x060c, all -> 0x07c9 }
                java.lang.String r21 = ""
                java.lang.String r22 = ""
                r16 = r11
                com.mbridge.msdk.reward.b.a.a(r16, r17, r18, r19, r20, r21, r22)     // Catch:{ Exception -> 0x060c, all -> 0x07c9 }
            L_0x050e:
                com.mbridge.msdk.reward.adapter.d r2 = com.mbridge.msdk.reward.adapter.d.this     // Catch:{ Exception -> 0x060c, all -> 0x07c9 }
                com.mbridge.msdk.reward.adapter.b r2 = r2.s     // Catch:{ Exception -> 0x060c, all -> 0x07c9 }
                java.lang.String r3 = "errorCode: 3506 errorMessage: data load failed"
                r2.a(r3)     // Catch:{ Exception -> 0x060c, all -> 0x07c9 }
                goto L_0x07d8
            L_0x051b:
                java.lang.Object r2 = r2.obj     // Catch:{ Exception -> 0x060c, all -> 0x07c9 }
                java.lang.String r2 = (java.lang.String) r2     // Catch:{ Exception -> 0x060c, all -> 0x07c9 }
                boolean r3 = android.text.TextUtils.isEmpty(r2)     // Catch:{ Exception -> 0x060c, all -> 0x07c9 }
                if (r3 == 0) goto L_0x0591
                com.mbridge.msdk.reward.adapter.d r2 = com.mbridge.msdk.reward.adapter.d.this     // Catch:{ Exception -> 0x060c, all -> 0x07c9 }
                android.os.Handler r2 = r2.J     // Catch:{ Exception -> 0x060c, all -> 0x07c9 }
                if (r2 == 0) goto L_0x0536
                com.mbridge.msdk.reward.adapter.d r2 = com.mbridge.msdk.reward.adapter.d.this     // Catch:{ Exception -> 0x060c, all -> 0x07c9 }
                android.os.Handler r2 = r2.J     // Catch:{ Exception -> 0x060c, all -> 0x07c9 }
                r2.removeMessages(r13)     // Catch:{ Exception -> 0x060c, all -> 0x07c9 }
            L_0x0536:
                r1.removeMessages(r12)     // Catch:{ Exception -> 0x060c, all -> 0x07c9 }
                com.mbridge.msdk.reward.adapter.d r2 = com.mbridge.msdk.reward.adapter.d.this     // Catch:{ Exception -> 0x060c, all -> 0x07c9 }
                boolean r2 = r2.i     // Catch:{ Exception -> 0x060c, all -> 0x07c9 }
                if (r2 != 0) goto L_0x07d8
                com.mbridge.msdk.reward.adapter.d r2 = com.mbridge.msdk.reward.adapter.d.this     // Catch:{ Exception -> 0x060c, all -> 0x07c9 }
                r2.i = r15     // Catch:{ Exception -> 0x060c, all -> 0x07c9 }
                if (r11 == 0) goto L_0x0567
                com.mbridge.msdk.reward.adapter.d r2 = com.mbridge.msdk.reward.adapter.d.this     // Catch:{ Exception -> 0x060c, all -> 0x07c9 }
                android.content.Context r17 = r2.j     // Catch:{ Exception -> 0x060c, all -> 0x07c9 }
                java.lang.String r18 = "data load failed, errorMsg null"
                com.mbridge.msdk.reward.adapter.d r2 = com.mbridge.msdk.reward.adapter.d.this     // Catch:{ Exception -> 0x060c, all -> 0x07c9 }
                java.lang.String r19 = r2.k     // Catch:{ Exception -> 0x060c, all -> 0x07c9 }
                com.mbridge.msdk.reward.adapter.d r2 = com.mbridge.msdk.reward.adapter.d.this     // Catch:{ Exception -> 0x060c, all -> 0x07c9 }
                boolean r20 = r2.x     // Catch:{ Exception -> 0x060c, all -> 0x07c9 }
                java.lang.String r21 = r11.getRequestId()     // Catch:{ Exception -> 0x060c, all -> 0x07c9 }
                java.lang.String r22 = r11.getRequestIdNotice()     // Catch:{ Exception -> 0x060c, all -> 0x07c9 }
                r16 = r11
                com.mbridge.msdk.reward.b.a.a(r16, r17, r18, r19, r20, r21, r22)     // Catch:{ Exception -> 0x060c, all -> 0x07c9 }
                goto L_0x0584
            L_0x0567:
                com.mbridge.msdk.reward.adapter.d r2 = com.mbridge.msdk.reward.adapter.d.this     // Catch:{ Exception -> 0x060c, all -> 0x07c9 }
                android.content.Context r17 = r2.j     // Catch:{ Exception -> 0x060c, all -> 0x07c9 }
                java.lang.String r18 = "data load failed, errorMsg null"
                com.mbridge.msdk.reward.adapter.d r2 = com.mbridge.msdk.reward.adapter.d.this     // Catch:{ Exception -> 0x060c, all -> 0x07c9 }
                java.lang.String r19 = r2.k     // Catch:{ Exception -> 0x060c, all -> 0x07c9 }
                com.mbridge.msdk.reward.adapter.d r2 = com.mbridge.msdk.reward.adapter.d.this     // Catch:{ Exception -> 0x060c, all -> 0x07c9 }
                boolean r20 = r2.x     // Catch:{ Exception -> 0x060c, all -> 0x07c9 }
                java.lang.String r21 = ""
                java.lang.String r22 = ""
                r16 = r11
                com.mbridge.msdk.reward.b.a.a(r16, r17, r18, r19, r20, r21, r22)     // Catch:{ Exception -> 0x060c, all -> 0x07c9 }
            L_0x0584:
                com.mbridge.msdk.reward.adapter.d r2 = com.mbridge.msdk.reward.adapter.d.this     // Catch:{ Exception -> 0x060c, all -> 0x07c9 }
                com.mbridge.msdk.reward.adapter.b r2 = r2.s     // Catch:{ Exception -> 0x060c, all -> 0x07c9 }
                java.lang.String r3 = "errorCode: 3507 errorMessage: data load failed, errorMsg null"
                r2.a(r3)     // Catch:{ Exception -> 0x060c, all -> 0x07c9 }
                goto L_0x07d8
            L_0x0591:
                com.mbridge.msdk.reward.adapter.d r3 = com.mbridge.msdk.reward.adapter.d.this     // Catch:{ Exception -> 0x060c, all -> 0x07c9 }
                android.os.Handler r3 = r3.J     // Catch:{ Exception -> 0x060c, all -> 0x07c9 }
                if (r3 == 0) goto L_0x05a2
                com.mbridge.msdk.reward.adapter.d r3 = com.mbridge.msdk.reward.adapter.d.this     // Catch:{ Exception -> 0x060c, all -> 0x07c9 }
                android.os.Handler r3 = r3.J     // Catch:{ Exception -> 0x060c, all -> 0x07c9 }
                r3.removeMessages(r13)     // Catch:{ Exception -> 0x060c, all -> 0x07c9 }
            L_0x05a2:
                r1.removeMessages(r12)     // Catch:{ Exception -> 0x060c, all -> 0x07c9 }
                com.mbridge.msdk.reward.adapter.d r3 = com.mbridge.msdk.reward.adapter.d.this     // Catch:{ Exception -> 0x060c, all -> 0x07c9 }
                boolean r3 = r3.i     // Catch:{ Exception -> 0x060c, all -> 0x07c9 }
                if (r3 != 0) goto L_0x07d8
                com.mbridge.msdk.reward.adapter.d r3 = com.mbridge.msdk.reward.adapter.d.this     // Catch:{ Exception -> 0x060c, all -> 0x07c9 }
                r3.i = r15     // Catch:{ Exception -> 0x060c, all -> 0x07c9 }
                if (r11 == 0) goto L_0x05d3
                com.mbridge.msdk.reward.adapter.d r3 = com.mbridge.msdk.reward.adapter.d.this     // Catch:{ Exception -> 0x060c, all -> 0x07c9 }
                android.content.Context r17 = r3.j     // Catch:{ Exception -> 0x060c, all -> 0x07c9 }
                com.mbridge.msdk.reward.adapter.d r3 = com.mbridge.msdk.reward.adapter.d.this     // Catch:{ Exception -> 0x060c, all -> 0x07c9 }
                java.lang.String r19 = r3.k     // Catch:{ Exception -> 0x060c, all -> 0x07c9 }
                com.mbridge.msdk.reward.adapter.d r3 = com.mbridge.msdk.reward.adapter.d.this     // Catch:{ Exception -> 0x060c, all -> 0x07c9 }
                boolean r20 = r3.x     // Catch:{ Exception -> 0x060c, all -> 0x07c9 }
                java.lang.String r21 = r11.getRequestId()     // Catch:{ Exception -> 0x060c, all -> 0x07c9 }
                java.lang.String r22 = r11.getRequestIdNotice()     // Catch:{ Exception -> 0x060c, all -> 0x07c9 }
                r16 = r11
                r18 = r2
                com.mbridge.msdk.reward.b.a.a(r16, r17, r18, r19, r20, r21, r22)     // Catch:{ Exception -> 0x060c, all -> 0x07c9 }
                goto L_0x05f0
            L_0x05d3:
                com.mbridge.msdk.reward.adapter.d r3 = com.mbridge.msdk.reward.adapter.d.this     // Catch:{ Exception -> 0x060c, all -> 0x07c9 }
                android.content.Context r17 = r3.j     // Catch:{ Exception -> 0x060c, all -> 0x07c9 }
                com.mbridge.msdk.reward.adapter.d r3 = com.mbridge.msdk.reward.adapter.d.this     // Catch:{ Exception -> 0x060c, all -> 0x07c9 }
                java.lang.String r19 = r3.k     // Catch:{ Exception -> 0x060c, all -> 0x07c9 }
                com.mbridge.msdk.reward.adapter.d r3 = com.mbridge.msdk.reward.adapter.d.this     // Catch:{ Exception -> 0x060c, all -> 0x07c9 }
                boolean r20 = r3.x     // Catch:{ Exception -> 0x060c, all -> 0x07c9 }
                java.lang.String r21 = ""
                java.lang.String r22 = ""
                r16 = r11
                r18 = r2
                com.mbridge.msdk.reward.b.a.a(r16, r17, r18, r19, r20, r21, r22)     // Catch:{ Exception -> 0x060c, all -> 0x07c9 }
            L_0x05f0:
                com.mbridge.msdk.reward.adapter.d r3 = com.mbridge.msdk.reward.adapter.d.this     // Catch:{ Exception -> 0x060c, all -> 0x07c9 }
                com.mbridge.msdk.reward.adapter.b r3 = r3.s     // Catch:{ Exception -> 0x060c, all -> 0x07c9 }
                java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x060c, all -> 0x07c9 }
                r5.<init>()     // Catch:{ Exception -> 0x060c, all -> 0x07c9 }
                java.lang.String r6 = "errorCode: 3507 errorMessage: data load failed, errorMsg is "
                r5.append(r6)     // Catch:{ Exception -> 0x060c, all -> 0x07c9 }
                r5.append(r2)     // Catch:{ Exception -> 0x060c, all -> 0x07c9 }
                java.lang.String r2 = r5.toString()     // Catch:{ Exception -> 0x060c, all -> 0x07c9 }
                r3.a(r2)     // Catch:{ Exception -> 0x060c, all -> 0x07c9 }
                goto L_0x07d8
            L_0x060c:
                r0 = move-exception
                r2 = r0
                com.mbridge.msdk.reward.adapter.d r3 = com.mbridge.msdk.reward.adapter.d.this     // Catch:{ Exception -> 0x07d3, all -> 0x07c9 }
                android.os.Handler r3 = r3.J     // Catch:{ Exception -> 0x07d3, all -> 0x07c9 }
                if (r3 == 0) goto L_0x061f
                com.mbridge.msdk.reward.adapter.d r3 = com.mbridge.msdk.reward.adapter.d.this     // Catch:{ Exception -> 0x07d3, all -> 0x07c9 }
                android.os.Handler r3 = r3.J     // Catch:{ Exception -> 0x07d3, all -> 0x07c9 }
                r3.removeMessages(r13)     // Catch:{ Exception -> 0x07d3, all -> 0x07c9 }
            L_0x061f:
                r1.removeMessages(r12)     // Catch:{ Exception -> 0x07d3, all -> 0x07c9 }
                com.mbridge.msdk.reward.adapter.d r3 = com.mbridge.msdk.reward.adapter.d.this     // Catch:{ Exception -> 0x07d3, all -> 0x07c9 }
                com.mbridge.msdk.reward.adapter.d r5 = com.mbridge.msdk.reward.adapter.d.this     // Catch:{ Exception -> 0x07d3, all -> 0x07c9 }
                java.lang.String r5 = r5.k     // Catch:{ Exception -> 0x07d3, all -> 0x07c9 }
                com.mbridge.msdk.reward.adapter.d r6 = com.mbridge.msdk.reward.adapter.d.this     // Catch:{ Exception -> 0x07d3, all -> 0x07c9 }
                java.util.List r6 = r6.M     // Catch:{ Exception -> 0x07d3, all -> 0x07c9 }
                com.mbridge.msdk.reward.adapter.d r7 = com.mbridge.msdk.reward.adapter.d.this     // Catch:{ Exception -> 0x07d3, all -> 0x07c9 }
                boolean r7 = r7.x     // Catch:{ Exception -> 0x07d3, all -> 0x07c9 }
                com.mbridge.msdk.reward.adapter.d.a((com.mbridge.msdk.reward.adapter.d) r3, (java.lang.String) r5, (java.util.List) r6, (boolean) r7)     // Catch:{ Exception -> 0x07d3, all -> 0x07c9 }
                com.mbridge.msdk.reward.adapter.d r3 = com.mbridge.msdk.reward.adapter.d.this     // Catch:{ Exception -> 0x07d3, all -> 0x07c9 }
                boolean r3 = r3.i     // Catch:{ Exception -> 0x07d3, all -> 0x07c9 }
                if (r3 != 0) goto L_0x07d8
                com.mbridge.msdk.reward.adapter.d r3 = com.mbridge.msdk.reward.adapter.d.this     // Catch:{ Exception -> 0x07d3, all -> 0x07c9 }
                r3.i = r15     // Catch:{ Exception -> 0x07d3, all -> 0x07c9 }
                if (r11 == 0) goto L_0x0669
                com.mbridge.msdk.reward.adapter.d r3 = com.mbridge.msdk.reward.adapter.d.this     // Catch:{ Exception -> 0x07d3, all -> 0x07c9 }
                android.content.Context r17 = r3.j     // Catch:{ Exception -> 0x07d3, all -> 0x07c9 }
                java.lang.String r18 = r2.getMessage()     // Catch:{ Exception -> 0x07d3, all -> 0x07c9 }
                com.mbridge.msdk.reward.adapter.d r3 = com.mbridge.msdk.reward.adapter.d.this     // Catch:{ Exception -> 0x07d3, all -> 0x07c9 }
                java.lang.String r19 = r3.k     // Catch:{ Exception -> 0x07d3, all -> 0x07c9 }
                com.mbridge.msdk.reward.adapter.d r3 = com.mbridge.msdk.reward.adapter.d.this     // Catch:{ Exception -> 0x07d3, all -> 0x07c9 }
                boolean r20 = r3.x     // Catch:{ Exception -> 0x07d3, all -> 0x07c9 }
                java.lang.String r21 = r11.getRequestId()     // Catch:{ Exception -> 0x07d3, all -> 0x07c9 }
                java.lang.String r22 = r11.getRequestIdNotice()     // Catch:{ Exception -> 0x07d3, all -> 0x07c9 }
                r16 = r11
                com.mbridge.msdk.reward.b.a.a(r16, r17, r18, r19, r20, r21, r22)     // Catch:{ Exception -> 0x07d3, all -> 0x07c9 }
                goto L_0x0688
            L_0x0669:
                com.mbridge.msdk.reward.adapter.d r3 = com.mbridge.msdk.reward.adapter.d.this     // Catch:{ Exception -> 0x07d3, all -> 0x07c9 }
                android.content.Context r17 = r3.j     // Catch:{ Exception -> 0x07d3, all -> 0x07c9 }
                java.lang.String r18 = r2.getMessage()     // Catch:{ Exception -> 0x07d3, all -> 0x07c9 }
                com.mbridge.msdk.reward.adapter.d r3 = com.mbridge.msdk.reward.adapter.d.this     // Catch:{ Exception -> 0x07d3, all -> 0x07c9 }
                java.lang.String r19 = r3.k     // Catch:{ Exception -> 0x07d3, all -> 0x07c9 }
                com.mbridge.msdk.reward.adapter.d r3 = com.mbridge.msdk.reward.adapter.d.this     // Catch:{ Exception -> 0x07d3, all -> 0x07c9 }
                boolean r20 = r3.x     // Catch:{ Exception -> 0x07d3, all -> 0x07c9 }
                java.lang.String r21 = ""
                java.lang.String r22 = ""
                r16 = r11
                com.mbridge.msdk.reward.b.a.a(r16, r17, r18, r19, r20, r21, r22)     // Catch:{ Exception -> 0x07d3, all -> 0x07c9 }
            L_0x0688:
                com.mbridge.msdk.reward.adapter.d r3 = com.mbridge.msdk.reward.adapter.d.this     // Catch:{ Exception -> 0x07d3, all -> 0x07c9 }
                com.mbridge.msdk.reward.adapter.b r3 = r3.s     // Catch:{ Exception -> 0x07d3, all -> 0x07c9 }
                java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x07d3, all -> 0x07c9 }
                r5.<init>()     // Catch:{ Exception -> 0x07d3, all -> 0x07c9 }
                java.lang.String r6 = "errorCode: 3508 errorMessage: data load failed, exception is "
                r5.append(r6)     // Catch:{ Exception -> 0x07d3, all -> 0x07c9 }
                java.lang.String r2 = r2.getMessage()     // Catch:{ Exception -> 0x07d3, all -> 0x07c9 }
                r5.append(r2)     // Catch:{ Exception -> 0x07d3, all -> 0x07c9 }
                java.lang.String r2 = r5.toString()     // Catch:{ Exception -> 0x07d3, all -> 0x07c9 }
                r3.a(r2)     // Catch:{ Exception -> 0x07d3, all -> 0x07c9 }
                goto L_0x07d8
            L_0x06a8:
                com.mbridge.msdk.reward.adapter.d r2 = com.mbridge.msdk.reward.adapter.d.this     // Catch:{ Exception -> 0x07d3, all -> 0x07c9 }
                com.mbridge.msdk.reward.adapter.b r2 = r2.s     // Catch:{ Exception -> 0x07d3, all -> 0x07c9 }
                if (r2 == 0) goto L_0x06bb
                com.mbridge.msdk.reward.adapter.d r2 = com.mbridge.msdk.reward.adapter.d.this     // Catch:{ Exception -> 0x07d3, all -> 0x07c9 }
                com.mbridge.msdk.reward.adapter.b r2 = r2.s     // Catch:{ Exception -> 0x07d3, all -> 0x07c9 }
                java.lang.String r3 = "campaign is ok"
                r2.b(r3)     // Catch:{ Exception -> 0x07d3, all -> 0x07c9 }
            L_0x06bb:
                int r2 = com.mbridge.msdk.foundation.same.a.m     // Catch:{ Exception -> 0x07d3, all -> 0x07c9 }
                long r2 = (long) r2     // Catch:{ Exception -> 0x07d3, all -> 0x07c9 }
                r1.sendEmptyMessageDelayed(r13, r2)     // Catch:{ Exception -> 0x07d3, all -> 0x07c9 }
                goto L_0x07d8
            L_0x06c3:
                java.lang.Object r3 = r2.obj     // Catch:{ Exception -> 0x07d3, all -> 0x07c9 }
                if (r3 == 0) goto L_0x06cd
                java.lang.Object r2 = r2.obj     // Catch:{ Exception -> 0x07d3, all -> 0x07c9 }
                java.lang.String r11 = r2.toString()     // Catch:{ Exception -> 0x07d3, all -> 0x07c9 }
            L_0x06cd:
                com.mbridge.msdk.reward.adapter.d r2 = com.mbridge.msdk.reward.adapter.d.this     // Catch:{ Exception -> 0x07d3, all -> 0x07c9 }
                r2.b((java.lang.String) r11)     // Catch:{ Exception -> 0x07d3, all -> 0x07c9 }
                goto L_0x07d8
            L_0x06d4:
                java.lang.Object r3 = r2.obj     // Catch:{ Exception -> 0x07d3, all -> 0x07c9 }
                if (r3 == 0) goto L_0x06de
                java.lang.Object r2 = r2.obj     // Catch:{ Exception -> 0x07d3, all -> 0x07c9 }
                java.lang.String r11 = r2.toString()     // Catch:{ Exception -> 0x07d3, all -> 0x07c9 }
            L_0x06de:
                com.mbridge.msdk.reward.adapter.d r2 = com.mbridge.msdk.reward.adapter.d.this     // Catch:{ Exception -> 0x07d3, all -> 0x07c9 }
                r2.b((java.lang.String) r11)     // Catch:{ Exception -> 0x07d3, all -> 0x07c9 }
                goto L_0x07d8
            L_0x06e5:
                java.lang.Object r2 = r2.obj     // Catch:{ Exception -> 0x071a, all -> 0x07c9 }
                java.lang.Object[] r2 = (java.lang.Object[]) r2     // Catch:{ Exception -> 0x071a, all -> 0x07c9 }
                java.lang.Object[] r2 = (java.lang.Object[]) r2     // Catch:{ Exception -> 0x071a, all -> 0x07c9 }
                r3 = r2[r14]     // Catch:{ Exception -> 0x071a, all -> 0x07c9 }
                r18 = r3
                com.mbridge.msdk.foundation.entity.CampaignEx r18 = (com.mbridge.msdk.foundation.entity.CampaignEx) r18     // Catch:{ Exception -> 0x071a, all -> 0x07c9 }
                r3 = r2[r15]     // Catch:{ Exception -> 0x071a, all -> 0x07c9 }
                r19 = r3
                java.lang.String r19 = (java.lang.String) r19     // Catch:{ Exception -> 0x071a, all -> 0x07c9 }
                r3 = r2[r9]     // Catch:{ Exception -> 0x071a, all -> 0x07c9 }
                r20 = r3
                java.lang.String r20 = (java.lang.String) r20     // Catch:{ Exception -> 0x071a, all -> 0x07c9 }
                r3 = r2[r8]     // Catch:{ Exception -> 0x071a, all -> 0x07c9 }
                r21 = r3
                com.mbridge.msdk.videocommon.d.c r21 = (com.mbridge.msdk.videocommon.d.c) r21     // Catch:{ Exception -> 0x071a, all -> 0x07c9 }
                r2 = r2[r7]     // Catch:{ Exception -> 0x071a, all -> 0x07c9 }
                r17 = r2
                java.lang.String r17 = (java.lang.String) r17     // Catch:{ Exception -> 0x071a, all -> 0x07c9 }
                if (r18 == 0) goto L_0x07d8
                boolean r2 = android.text.TextUtils.isEmpty(r19)     // Catch:{ Exception -> 0x071a, all -> 0x07c9 }
                if (r2 != 0) goto L_0x07d8
                com.mbridge.msdk.reward.adapter.d r2 = com.mbridge.msdk.reward.adapter.d.this     // Catch:{ Exception -> 0x071a, all -> 0x07c9 }
                r16 = r2
                com.mbridge.msdk.reward.adapter.d.a(r16, r17, r18, r19, r20, r21)     // Catch:{ Exception -> 0x071a, all -> 0x07c9 }
                goto L_0x07d8
            L_0x071a:
                r0 = move-exception
                r2 = r0
                java.lang.String r3 = r2.getLocalizedMessage()     // Catch:{ Exception -> 0x07d3, all -> 0x07c9 }
                com.mbridge.msdk.foundation.tools.q.a(r4, r3)     // Catch:{ Exception -> 0x07d3, all -> 0x07c9 }
                boolean r3 = com.mbridge.msdk.MBridgeConstans.DEBUG     // Catch:{ Exception -> 0x07d3, all -> 0x07c9 }
                if (r3 == 0) goto L_0x07d8
                r2.printStackTrace()     // Catch:{ Exception -> 0x07d3, all -> 0x07c9 }
                goto L_0x07d8
            L_0x072c:
                java.lang.Object r2 = r2.obj     // Catch:{ Exception -> 0x0789, all -> 0x07c9 }
                java.lang.Object[] r2 = (java.lang.Object[]) r2     // Catch:{ Exception -> 0x0789, all -> 0x07c9 }
                java.lang.Object[] r2 = (java.lang.Object[]) r2     // Catch:{ Exception -> 0x0789, all -> 0x07c9 }
                r3 = r2[r14]     // Catch:{ Exception -> 0x0789, all -> 0x07c9 }
                r17 = r3
                com.mbridge.msdk.foundation.entity.CampaignEx r17 = (com.mbridge.msdk.foundation.entity.CampaignEx) r17     // Catch:{ Exception -> 0x0789, all -> 0x07c9 }
                r3 = r2[r9]     // Catch:{ Exception -> 0x0789, all -> 0x07c9 }
                r20 = r3
                java.lang.String r20 = (java.lang.String) r20     // Catch:{ Exception -> 0x0789, all -> 0x07c9 }
                r3 = r2[r8]     // Catch:{ Exception -> 0x0789, all -> 0x07c9 }
                r21 = r3
                com.mbridge.msdk.videocommon.d.c r21 = (com.mbridge.msdk.videocommon.d.c) r21     // Catch:{ Exception -> 0x0789, all -> 0x07c9 }
                r3 = r2[r7]     // Catch:{ Exception -> 0x0789, all -> 0x07c9 }
                r16 = r3
                java.lang.String r16 = (java.lang.String) r16     // Catch:{ Exception -> 0x0789, all -> 0x07c9 }
                int r3 = r2.length     // Catch:{ Exception -> 0x0789, all -> 0x07c9 }
                r5 = 7
                if (r3 != r5) goto L_0x0758
                r3 = r2[r13]     // Catch:{ Exception -> 0x0789, all -> 0x07c9 }
                r10 = r3
                java.lang.String r10 = (java.lang.String) r10     // Catch:{ Exception -> 0x0789, all -> 0x07c9 }
                r2 = r2[r12]     // Catch:{ Exception -> 0x0789, all -> 0x07c9 }
                r11 = r2
                com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView r11 = (com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView) r11     // Catch:{ Exception -> 0x0789, all -> 0x07c9 }
            L_0x0758:
                r22 = r10
                r15 = r11
                if (r17 == 0) goto L_0x07d8
                com.mbridge.msdk.reward.adapter.d r2 = com.mbridge.msdk.reward.adapter.d.this     // Catch:{ Exception -> 0x0789, all -> 0x07c9 }
                java.util.concurrent.CopyOnWriteArrayList r2 = r2.u     // Catch:{ Exception -> 0x0789, all -> 0x07c9 }
                if (r2 != 0) goto L_0x077b
                com.mbridge.msdk.reward.adapter.d r2 = com.mbridge.msdk.reward.adapter.d.this     // Catch:{ Exception -> 0x0789, all -> 0x07c9 }
                java.util.List r2 = r2.N     // Catch:{ Exception -> 0x0789, all -> 0x07c9 }
                if (r2 == 0) goto L_0x07d8
                com.mbridge.msdk.reward.adapter.d r14 = com.mbridge.msdk.reward.adapter.d.this     // Catch:{ Exception -> 0x0789, all -> 0x07c9 }
                com.mbridge.msdk.reward.adapter.d r2 = com.mbridge.msdk.reward.adapter.d.this     // Catch:{ Exception -> 0x0789, all -> 0x07c9 }
                java.util.List r18 = r2.N     // Catch:{ Exception -> 0x0789, all -> 0x07c9 }
                java.lang.String r19 = ""
                com.mbridge.msdk.reward.adapter.d.a(r14, r15, r16, r17, r18, r19, r20, r21, r22)     // Catch:{ Exception -> 0x0789, all -> 0x07c9 }
                goto L_0x07d8
            L_0x077b:
                com.mbridge.msdk.reward.adapter.d r14 = com.mbridge.msdk.reward.adapter.d.this     // Catch:{ Exception -> 0x0789, all -> 0x07c9 }
                com.mbridge.msdk.reward.adapter.d r2 = com.mbridge.msdk.reward.adapter.d.this     // Catch:{ Exception -> 0x0789, all -> 0x07c9 }
                java.util.concurrent.CopyOnWriteArrayList r18 = r2.u     // Catch:{ Exception -> 0x0789, all -> 0x07c9 }
                java.lang.String r19 = ""
                com.mbridge.msdk.reward.adapter.d.a(r14, r15, r16, r17, r18, r19, r20, r21, r22)     // Catch:{ Exception -> 0x0789, all -> 0x07c9 }
                goto L_0x07d8
            L_0x0789:
                r0 = move-exception
                r2 = r0
                java.lang.String r3 = r2.getLocalizedMessage()     // Catch:{ Exception -> 0x07d3, all -> 0x07c9 }
                com.mbridge.msdk.foundation.tools.q.a(r4, r3)     // Catch:{ Exception -> 0x07d3, all -> 0x07c9 }
                boolean r3 = com.mbridge.msdk.MBridgeConstans.DEBUG     // Catch:{ Exception -> 0x07d3, all -> 0x07c9 }
                if (r3 == 0) goto L_0x07d8
                r2.printStackTrace()     // Catch:{ Exception -> 0x07d3, all -> 0x07c9 }
                goto L_0x07d8
            L_0x079a:
                com.mbridge.msdk.reward.adapter.d r3 = com.mbridge.msdk.reward.adapter.d.this     // Catch:{ Exception -> 0x07d3, all -> 0x07c9 }
                com.mbridge.msdk.reward.adapter.b r3 = r3.s     // Catch:{ Exception -> 0x07d3, all -> 0x07c9 }
                if (r3 == 0) goto L_0x07d8
                java.lang.Object r2 = r2.obj     // Catch:{ Exception -> 0x07d3, all -> 0x07c9 }
                com.mbridge.msdk.foundation.entity.CampaignEx r2 = (com.mbridge.msdk.foundation.entity.CampaignEx) r2     // Catch:{ Exception -> 0x07d3, all -> 0x07c9 }
                if (r2 == 0) goto L_0x07d8
                com.mbridge.msdk.reward.adapter.d r3 = com.mbridge.msdk.reward.adapter.d.this     // Catch:{ Exception -> 0x07d3, all -> 0x07c9 }
                java.lang.String r3 = r3.k     // Catch:{ Exception -> 0x07d3, all -> 0x07c9 }
                boolean r3 = android.text.TextUtils.isEmpty(r3)     // Catch:{ Exception -> 0x07d3, all -> 0x07c9 }
                if (r3 != 0) goto L_0x07d8
                com.mbridge.msdk.reward.adapter.d r3 = com.mbridge.msdk.reward.adapter.d.this     // Catch:{ Exception -> 0x07d3, all -> 0x07c9 }
                android.content.Context r3 = r3.j     // Catch:{ Exception -> 0x07d3, all -> 0x07c9 }
                com.mbridge.msdk.reward.adapter.d r5 = com.mbridge.msdk.reward.adapter.d.this     // Catch:{ Exception -> 0x07d3, all -> 0x07c9 }
                java.lang.String r5 = r5.k     // Catch:{ Exception -> 0x07d3, all -> 0x07c9 }
                com.mbridge.msdk.reward.b.a.a((android.content.Context) r3, (com.mbridge.msdk.foundation.entity.CampaignEx) r2, (java.lang.String) r5)     // Catch:{ Exception -> 0x07d3, all -> 0x07c9 }
                com.mbridge.msdk.reward.adapter.d r2 = com.mbridge.msdk.reward.adapter.d.this     // Catch:{ Exception -> 0x07d3, all -> 0x07c9 }
                r2.b()     // Catch:{ Exception -> 0x07d3, all -> 0x07c9 }
                goto L_0x07d8
            L_0x07c9:
                r0 = move-exception
                r2 = r0
                java.lang.String r2 = r2.getMessage()
                com.mbridge.msdk.foundation.tools.q.a(r4, r2)
                goto L_0x07d8
            L_0x07d3:
                r0 = move-exception
                r2 = r0
                r2.printStackTrace()
            L_0x07d8:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.reward.adapter.d.AnonymousClass1.handleMessage(android.os.Message):void");
        }
    };
    /* access modifiers changed from: private */
    public long K = 0;
    private String L = "";
    /* access modifiers changed from: private */
    public List<CampaignEx> M;
    /* access modifiers changed from: private */
    public List<CampaignEx> N;
    public String a = "";
    public String b = "";
    public Object c = new Object();
    boolean d = false;
    volatile boolean e = false;
    volatile boolean f = false;
    volatile boolean g = false;
    volatile boolean h = false;
    volatile boolean i = false;
    /* access modifiers changed from: private */
    public Context j;
    /* access modifiers changed from: private */
    public String k;
    /* access modifiers changed from: private */
    public String l;
    private int m;
    private int n;
    private int o;
    private boolean p;
    /* access modifiers changed from: private */
    public String q;
    private h r;
    /* access modifiers changed from: private */
    public volatile b s;
    /* access modifiers changed from: private */
    public com.mbridge.msdk.videocommon.d.c t;
    /* access modifiers changed from: private */
    public CopyOnWriteArrayList<CampaignEx> u = new CopyOnWriteArrayList<>();
    /* access modifiers changed from: private */
    public int v = 2;
    /* access modifiers changed from: private */
    public boolean w;
    /* access modifiers changed from: private */
    public boolean x;
    private String y = "";
    private int z;

    public final String a(boolean z2) {
        List<CampaignEx> a2;
        CampaignEx campaignEx;
        if (!z2) {
            return this.a;
        }
        if (TextUtils.isEmpty(this.b) && (a2 = com.mbridge.msdk.videocommon.download.c.getInstance().a(this.k)) != null && a2.size() > 0 && (campaignEx = a2.get(0)) != null) {
            this.b = campaignEx.getRequestId();
        }
        return this.b;
    }

    public final void b(boolean z2) {
        this.w = z2;
    }

    public final void c(boolean z2) {
        this.x = z2;
    }

    public final void a(String str) {
        this.y = str;
    }

    public final void a(int i2) {
        this.v = i2;
    }

    public final String a() {
        return this.k;
    }

    /* compiled from: RewardMVVideoAdapter */
    private class b implements Runnable {
        private String b;
        private CampaignEx c;
        private String d;
        private String e;
        private com.mbridge.msdk.videocommon.d.c f;
        private int g;
        private d h;

        public b(String str, CampaignEx campaignEx, String str2, String str3, com.mbridge.msdk.videocommon.d.c cVar, int i, d dVar) {
            this.b = str;
            this.c = campaignEx;
            this.d = str2;
            this.e = str3;
            this.f = cVar;
            this.g = i;
            this.h = dVar;
        }

        public final void run() {
            j jVar;
            try {
                a.C0105a aVar = new a.C0105a();
                WindVaneWebView windVaneWebView = new WindVaneWebView(com.mbridge.msdk.foundation.controller.a.e().g());
                aVar.a(windVaneWebView);
                String b2 = com.mbridge.msdk.video.bt.a.c.a().b();
                aVar.a(b2);
                if (d.this.C.getAds() == null || d.this.C.getAds().size() <= 0) {
                    jVar = new j((Activity) null, this.c);
                } else {
                    jVar = new j((Activity) null, this.c, d.this.C.getAds());
                }
                j jVar2 = jVar;
                jVar2.a(this.g);
                jVar2.a(this.e);
                jVar2.c(b2);
                jVar2.a(this.f);
                jVar2.d(d.this.E);
                windVaneWebView.setWebViewListener(new a(this.d, this.b, aVar, this.c, this.h, (b) null, (Handler) null));
                windVaneWebView.setObject(jVar2);
                windVaneWebView.loadUrl(this.d);
            } catch (Exception e2) {
                if (MBridgeConstans.DEBUG) {
                    e2.printStackTrace();
                }
            } catch (Throwable th) {
                q.a("RewardMVVideoAdapter", th.getMessage());
            }
        }
    }

    /* compiled from: RewardMVVideoAdapter */
    private class c implements Runnable {
        private WindVaneWebView b;
        private String c;
        private CampaignEx d;
        private List<CampaignEx> e;
        private String f;
        private String g;
        private com.mbridge.msdk.videocommon.d.c h;
        private int i;
        private d j;

        public c(WindVaneWebView windVaneWebView, String str, CampaignEx campaignEx, List<CampaignEx> list, String str2, String str3, com.mbridge.msdk.videocommon.d.c cVar, int i2, d dVar) {
            this.b = windVaneWebView;
            this.c = str;
            this.d = campaignEx;
            this.e = list;
            this.f = str2;
            this.g = str3;
            this.h = cVar;
            this.i = i2;
            this.j = dVar;
        }

        public final void run() {
            j jVar;
            try {
                a.C0105a aVar = new a.C0105a();
                WindVaneWebView windVaneWebView = new WindVaneWebView(com.mbridge.msdk.foundation.controller.a.e().g());
                aVar.a(windVaneWebView);
                if (this.e == null || this.e.size() <= 0) {
                    jVar = new j((Activity) null, this.d);
                } else {
                    jVar = new j((Activity) null, this.d, this.e);
                }
                j jVar2 = jVar;
                jVar2.a(this.i);
                jVar2.a(this.g);
                jVar2.a(this.h);
                jVar2.d(d.this.E);
                windVaneWebView.setWebViewListener(new f(this.b, this.f, this.c, aVar, this.d, this.j, (c) null, (Handler) null));
                windVaneWebView.setObject(jVar2);
                windVaneWebView.loadUrl(this.f);
            } catch (Exception e2) {
                if (MBridgeConstans.DEBUG) {
                    e2.printStackTrace();
                }
            } catch (Throwable th) {
                q.a("RewardMVVideoAdapter", th.getMessage());
            }
        }
    }

    /* compiled from: RewardMVVideoAdapter */
    private static class a extends com.mbridge.msdk.mbsignalcommon.b.a {
        private d a;
        private String b;
        private String c;
        private a.C0105a d;
        private CampaignEx e;
        private boolean f;
        private boolean g;
        private b h;
        private Handler i;

        public final void a(WebView webView, String str, String str2, int i2, int i3) {
        }

        public a(String str, String str2, a.C0105a aVar, CampaignEx campaignEx, d dVar, b bVar, Handler handler) {
            this.b = str;
            this.c = str2;
            this.d = aVar;
            if (dVar != null) {
                this.a = dVar;
            }
            this.e = campaignEx;
            this.h = bVar;
            this.i = handler;
        }

        public final void a(WebView webView, int i2) {
            Handler handler;
            if (!this.g) {
                b bVar = this.h;
                if (!(bVar == null || (handler = this.i) == null)) {
                    handler.removeCallbacks(bVar);
                }
                i.a().d(this.b, true);
                this.c + "_" + this.b;
                a.C0105a aVar = this.d;
                if (aVar != null) {
                    aVar.a(true);
                }
                List<CampaignEx> a2 = com.mbridge.msdk.videocommon.a.a.a().a(this.c, 1, this.a.x);
                if (a2 != null && a2.size() > 0) {
                    for (CampaignEx rewardTemplateMode : a2) {
                        CampaignEx.c rewardTemplateMode2 = rewardTemplateMode.getRewardTemplateMode();
                        if (rewardTemplateMode2 != null && !TextUtils.isEmpty(rewardTemplateMode2.e()) && !rewardTemplateMode2.e().contains(CampaignEx.KEY_IS_CMPT_ENTRY) && TextUtils.equals(rewardTemplateMode2.e(), this.b)) {
                            if (!TextUtils.isEmpty(this.e.getCMPTEntryUrl()) || this.e.getMof_tplid() != -1) {
                                this.c + "_" + this.e.getMof_tplid() + "_" + this.e.getRequestIdNotice();
                            } else {
                                this.c + "_" + this.e.getRequestIdNotice();
                            }
                            d dVar = this.a;
                            if (dVar == null || !dVar.w) {
                                if (this.e.isBidCampaign()) {
                                    com.mbridge.msdk.videocommon.a.a(94, this.e.getRequestIdNotice(), this.d);
                                }
                            } else if (this.e.isBidCampaign()) {
                                com.mbridge.msdk.videocommon.a.a(287, this.e.getRequestIdNotice(), this.d);
                            }
                        }
                    }
                }
                try {
                    if (this.a != null) {
                        synchronized (this.a) {
                            if (!(this.a == null || !this.a.b() || this.a.J == null)) {
                                Message obtain = Message.obtain();
                                obtain.what = 6;
                                q.a("RVWindVaneWebView", "WHAT_ON_RES_LOAD_SUCCESS TPL");
                                obtain.obj = this.e;
                                this.a.J.sendMessage(obtain);
                                this.a.J.removeMessages(5);
                                this.a = null;
                            }
                        }
                    }
                } catch (Throwable th) {
                    q.a("RVWindVaneWebView", th.getMessage(), th);
                }
                this.g = true;
            }
        }

        public final void a(WebView webView, String str) {
            super.a(webView, str);
            if (!this.f) {
                g.a().a(webView);
                this.f = true;
            }
        }

        public final void a(WebView webView, int i2, String str, String str2) {
            super.a(webView, i2, str, str2);
            try {
                if (this.a != null) {
                    synchronized (this.a) {
                        d.a(this.a, str, str2);
                        this.a = null;
                    }
                }
            } catch (Throwable th) {
                q.a("RVWindVaneWebView", th.getMessage(), th);
            }
        }
    }

    /* compiled from: RewardMVVideoAdapter */
    private static class f extends com.mbridge.msdk.mbsignalcommon.b.b {
        private d a;
        private WindVaneWebView b;
        private String c;
        private String d;
        private a.C0105a e;
        private CampaignEx f;
        private boolean g;
        private boolean h;
        private c i;
        private Handler j;

        public f(WindVaneWebView windVaneWebView, String str, String str2, a.C0105a aVar, CampaignEx campaignEx, d dVar, c cVar, Handler handler) {
            this.b = windVaneWebView;
            this.c = str;
            this.d = str2;
            this.e = aVar;
            if (dVar != null) {
                this.a = dVar;
            }
            this.f = campaignEx;
            this.i = cVar;
            this.j = handler;
        }

        public final void a(WebView webView, int i2) {
            Handler handler;
            if (!this.h) {
                c cVar = this.i;
                if (!(cVar == null || (handler = this.j) == null)) {
                    handler.removeCallbacks(cVar);
                }
                String str = this.d + "_" + this.c;
                a.C0105a aVar = this.e;
                if (aVar != null) {
                    aVar.a(true);
                }
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("type", 1);
                    jSONObject.put("id", str);
                    jSONObject.put("unitid", this.d);
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
                i.a().d(this.c, true);
                com.mbridge.msdk.videocommon.a.a.a().a(this.d, 1, this.a.x);
                d dVar = this.a;
                if (dVar == null || !dVar.w) {
                    if (this.f.isBidCampaign()) {
                        com.mbridge.msdk.videocommon.a.a(94, this.f.getRequestIdNotice(), this.e);
                    }
                } else if (this.f.isBidCampaign()) {
                    com.mbridge.msdk.videocommon.a.a(287, this.f.getRequestIdNotice(), this.e);
                }
                try {
                    if (this.a != null) {
                        synchronized (this.a) {
                            if (!(this.a == null || !this.a.b() || this.a.J == null)) {
                                Message obtain = Message.obtain();
                                obtain.what = 6;
                                obtain.obj = this.f;
                                this.a.J.sendMessage(obtain);
                                this.a.J.removeMessages(5);
                                this.a = null;
                            }
                        }
                    }
                } catch (Throwable th) {
                    q.a("WindVaneWebView", th.getMessage(), th);
                }
                this.h = true;
            }
        }

        public final void a(WebView webView, String str) {
            super.a(webView, str);
            if (!this.g) {
                g.a().a(webView);
                this.g = true;
            }
        }

        public final void a(WebView webView, int i2, String str, String str2) {
            super.a(webView, i2, str, str2);
            try {
                if (this.a != null) {
                    synchronized (this.a) {
                        d.a(this.a, str, str2);
                        this.a = null;
                    }
                }
            } catch (Throwable th) {
                q.a("WindVaneWebView", th.getMessage(), th);
            }
        }
    }

    public d(Context context, String str, String str2) {
        try {
            this.j = context.getApplicationContext();
            this.k = str2;
            this.l = str;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final void a(com.mbridge.msdk.videocommon.d.c cVar) {
        try {
            this.t = cVar;
            if (this.t != null && this.t.C() * 1000 != com.mbridge.msdk.foundation.same.a.m) {
                com.mbridge.msdk.foundation.same.a.m = this.t.C() * 1000;
            }
        } catch (Throwable th) {
            q.a("RewardMVVideoAdapter", th.getMessage(), th);
        }
    }

    public final boolean a(List<CampaignEx> list, boolean z2, int i2) {
        return a(list, z2, i2, false);
    }

    public final boolean a(List<CampaignEx> list, boolean z2, int i2, boolean z3) {
        if (list != null && list.size() > 0) {
            CampaignEx campaignEx = list.get(0);
            if (com.mbridge.msdk.videocommon.download.c.getInstance().a(94, this.k, this.x, list.size(), z2, i2, list, z3)) {
                if (z2) {
                    if (campaignEx.isDynamicView()) {
                        return true;
                    }
                    if (campaignEx.getRsIgnoreCheckRule() != null && campaignEx.getRsIgnoreCheckRule().size() > 0) {
                        if (campaignEx.getRsIgnoreCheckRule().contains(3)) {
                            q.b("RewardMVVideoAdapter", "Is not check big template download status");
                            return true;
                        } else if (campaignEx.getCMPTEntryUrl().equals(campaignEx.getendcard_url()) && campaignEx.getRsIgnoreCheckRule().contains(2)) {
                            q.b("RewardMVVideoAdapter", "Is not check big template of ENDCARD download status");
                            return true;
                        }
                    }
                    i a2 = i.a();
                    if (a2.c(this.k + "_" + campaignEx.getRequestId() + "_" + campaignEx.getCMPTEntryUrl())) {
                        return true;
                    }
                } else if (campaignEx != null && campaignEx.isDynamicView()) {
                    return true;
                } else {
                    if (campaignEx.getRsIgnoreCheckRule() == null || campaignEx.getRsIgnoreCheckRule().size() <= 0 || !campaignEx.getRsIgnoreCheckRule().contains(1)) {
                        if (campaignEx.getRewardTemplateMode() != null && !TextUtils.isEmpty(campaignEx.getRewardTemplateMode().e())) {
                            i a3 = i.a();
                            if (a3.c(this.k + "_" + campaignEx.getRequestId() + "_" + campaignEx.getRewardTemplateMode().e())) {
                                return true;
                            }
                        }
                        return true;
                    }
                    q.b("RewardMVVideoAdapter", "Is not check template download status");
                    return true;
                }
            }
        }
        return false;
    }

    public final boolean b() {
        List<CampaignEx> a2 = com.mbridge.msdk.videocommon.a.a.a().a(this.k, 1, this.x, this.y);
        if (a2 == null || a2.size() <= 0) {
            q.a("RewardVideoController", "database has not can use data");
            return false;
        }
        CampaignEx campaignEx = a2.get(0);
        int b2 = com.mbridge.msdk.videocommon.a.a.a().b(this.k, 1, this.x, this.y);
        if (TextUtils.isEmpty(campaignEx.getCMPTEntryUrl()) || campaignEx.getNscpt() != 1 || a2.size() >= b2) {
            return a(a2, !TextUtils.isEmpty(campaignEx.getCMPTEntryUrl()), campaignEx.getNscpt());
        }
        return false;
    }

    public final boolean c() {
        List<CampaignEx> c2 = com.mbridge.msdk.videocommon.a.a.a().c(this.k, 1, this.x, this.y);
        if (c2 == null || c2.size() <= 0) {
            q.a("test_isReay_db", "database has not can use data");
            return false;
        }
        CampaignEx campaignEx = c2.get(0);
        int b2 = com.mbridge.msdk.videocommon.a.a.a().b(this.k, 1, this.x, this.y);
        if (TextUtils.isEmpty(campaignEx.getCMPTEntryUrl()) || campaignEx.getNscpt() != 1 || c2.size() >= b2) {
            return a(c2, !TextUtils.isEmpty(campaignEx.getCMPTEntryUrl()), campaignEx.getNscpt());
        }
        return false;
    }

    public final void a(h hVar, String str, String str2, int i2, String str3) {
        try {
            this.r = hVar;
            if (this.j != null) {
                if (!x.a(this.k)) {
                    Intent intent = new Intent(this.j, MBRewardVideoActivity.class);
                    intent.addFlags(268435456);
                    intent.putExtra(MBRewardVideoActivity.INTENT_UNITID, this.k);
                    intent.putExtra(MBridgeConstans.PLACEMENT_ID, this.l);
                    intent.putExtra(MBRewardVideoActivity.INTENT_REWARD, str);
                    intent.putExtra(MBRewardVideoActivity.INTENT_MUTE, i2);
                    intent.putExtra(MBRewardVideoActivity.INTENT_ISIV, this.w);
                    intent.putExtra(MBRewardVideoActivity.INTENT_ISBID, this.x);
                    intent.putExtra(MBRewardVideoActivity.INTENT_EXTRADATA, str3);
                    List<CampaignEx> a2 = com.mbridge.msdk.videocommon.download.c.getInstance().a(this.k);
                    boolean z2 = false;
                    if (a2 != null && a2.size() > 0) {
                        CampaignEx campaignEx = a2.get(0);
                        if (campaignEx != null) {
                            this.b = campaignEx.getRequestId();
                        }
                        if (campaignEx != null && !TextUtils.isEmpty(campaignEx.getCMPTEntryUrl())) {
                            z2 = true;
                        }
                        e();
                    } else if (this.r != null) {
                        this.r.a("load failed");
                        return;
                    }
                    intent.putExtra(MBRewardVideoActivity.INTENT_ISBIG_OFFER, z2);
                    if (this.w) {
                        intent.putExtra(MBRewardVideoActivity.INTENT_IVREWARD_MODETYPE, this.z);
                        intent.putExtra(MBRewardVideoActivity.INTENT_IVREWARD_VALUETYPE, this.A);
                        intent.putExtra(MBRewardVideoActivity.INTENT_IVREWARD_VALUE, this.B);
                    }
                    if (!TextUtils.isEmpty(str2)) {
                        intent.putExtra(MBRewardVideoActivity.INTENT_USERID, str2);
                    }
                    RewardUnitCacheManager.getInstance().add(this.l, this.k, this.t);
                    this.j.startActivity(intent);
                    return;
                }
            }
            if (this.r != null) {
                this.r.a("context or unitid is null");
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            h hVar2 = this.r;
            if (hVar2 != null) {
                hVar2.a("show failed, exception is " + e2.getMessage());
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x007e A[Catch:{ Exception -> 0x009c }] */
    /* JADX WARNING: Removed duplicated region for block: B:38:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void e() {
        /*
            r5 = this;
            com.mbridge.msdk.foundation.controller.a r0 = com.mbridge.msdk.foundation.controller.a.e()
            android.content.Context r0 = r0.g()
            com.mbridge.msdk.foundation.db.b r0 = com.mbridge.msdk.foundation.db.b.a((android.content.Context) r0)
            java.lang.String r1 = r5.k
            java.lang.String r2 = r5.b
            java.util.List r0 = r0.b(r1, r2)
            if (r0 == 0) goto L_0x00a6
            int r1 = r0.size()
            java.lang.String r2 = r5.k
            java.lang.String r2 = com.mbridge.msdk.foundation.same.a.d.c(r2)
            if (r1 != 0) goto L_0x0023
            return
        L_0x0023:
            r3 = 1
            java.lang.String r4 = ""
            if (r1 != r3) goto L_0x0044
            r1 = 0
            java.lang.Object r3 = r0.get(r1)     // Catch:{ Exception -> 0x009c }
            if (r3 == 0) goto L_0x006f
            java.lang.Object r3 = r0.get(r1)     // Catch:{ Exception -> 0x009c }
            com.mbridge.msdk.foundation.entity.c r3 = (com.mbridge.msdk.foundation.entity.c) r3     // Catch:{ Exception -> 0x009c }
            java.lang.String r4 = r3.c()     // Catch:{ Exception -> 0x009c }
            java.lang.Object r0 = r0.get(r1)     // Catch:{ Exception -> 0x009c }
            com.mbridge.msdk.foundation.entity.c r0 = (com.mbridge.msdk.foundation.entity.c) r0     // Catch:{ Exception -> 0x009c }
            java.lang.String r0 = r0.b()     // Catch:{ Exception -> 0x009c }
            goto L_0x0070
        L_0x0044:
            boolean r1 = android.text.TextUtils.isEmpty(r2)     // Catch:{ Exception -> 0x009c }
            if (r1 != 0) goto L_0x006f
            java.util.Iterator r0 = r0.iterator()     // Catch:{ Exception -> 0x009c }
        L_0x004e:
            boolean r1 = r0.hasNext()     // Catch:{ Exception -> 0x009c }
            if (r1 == 0) goto L_0x006f
            java.lang.Object r1 = r0.next()     // Catch:{ Exception -> 0x009c }
            com.mbridge.msdk.foundation.entity.c r1 = (com.mbridge.msdk.foundation.entity.c) r1     // Catch:{ Exception -> 0x009c }
            if (r1 == 0) goto L_0x004e
            java.lang.String r3 = r1.a()     // Catch:{ Exception -> 0x009c }
            boolean r3 = r2.equals(r3)     // Catch:{ Exception -> 0x009c }
            if (r3 == 0) goto L_0x004e
            java.lang.String r4 = r1.c()     // Catch:{ Exception -> 0x009c }
            java.lang.String r0 = r1.b()     // Catch:{ Exception -> 0x009c }
            goto L_0x0070
        L_0x006f:
            r0 = r4
        L_0x0070:
            boolean r1 = android.text.TextUtils.isEmpty(r4)     // Catch:{ Exception -> 0x009c }
            if (r1 != 0) goto L_0x00a6
            java.lang.String r1 = r5.b     // Catch:{ Exception -> 0x009c }
            boolean r1 = r4.equals(r1)     // Catch:{ Exception -> 0x009c }
            if (r1 == 0) goto L_0x00a6
            com.mbridge.msdk.foundation.controller.a r1 = com.mbridge.msdk.foundation.controller.a.e()     // Catch:{ Exception -> 0x009c }
            android.content.Context r1 = r1.g()     // Catch:{ Exception -> 0x009c }
            com.mbridge.msdk.foundation.db.b r1 = com.mbridge.msdk.foundation.db.b.a((android.content.Context) r1)     // Catch:{ Exception -> 0x009c }
            java.lang.String r3 = r5.k     // Catch:{ Exception -> 0x009c }
            r1.a((java.lang.String) r2, (java.lang.String) r3)     // Catch:{ Exception -> 0x009c }
            java.lang.String r1 = r5.k     // Catch:{ Exception -> 0x009c }
            java.lang.String r2 = r5.b     // Catch:{ Exception -> 0x009c }
            com.mbridge.msdk.foundation.same.a.d.a((java.lang.String) r1, (java.lang.String) r2, (java.lang.String) r0)     // Catch:{ Exception -> 0x009c }
            java.lang.String r0 = r5.k     // Catch:{ Exception -> 0x009c }
            com.mbridge.msdk.foundation.same.a.d.b(r0)     // Catch:{ Exception -> 0x009c }
            goto L_0x00a6
        L_0x009c:
            r0 = move-exception
            java.lang.String r0 = r0.getMessage()
            java.lang.String r1 = "RewardMVVideoAdapter"
            com.mbridge.msdk.foundation.tools.q.a(r1, r0)
        L_0x00a6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.reward.adapter.d.e():void");
    }

    public final void a(int i2, int i3, boolean z2) {
        a(i2, i3, z2, "", this.E);
    }

    public final void a(int i2, int i3, boolean z2, String str, boolean z3) {
        this.n = i2;
        this.o = i3;
        this.p = z2;
        this.E = z3;
        List<CampaignEx> list = this.D;
        if (list != null) {
            list.clear();
        }
        List<CampaignEx> list2 = this.M;
        if (list2 != null) {
            list2.clear();
        }
        this.e = false;
        this.f = false;
        synchronized (this.c) {
            if (this.g) {
                this.g = false;
            }
        }
        this.i = false;
        this.h = false;
        if (this.j == null) {
            c("Context is null");
        } else if (x.a(this.k)) {
            c("UnitId is null");
        } else if (this.t == null) {
            c("RewardUnitSetting is null");
        } else {
            j();
            k();
            f();
            b(str, z3);
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(36:20|(1:22)(1:23)|24|(1:26)(1:27)|28|(1:30)(1:31)|32|(1:34)|35|(1:37)|38|(1:40)|41|42|(5:44|45|46|(3:48|49|(1:51)(1:52))|53)|54|(1:58)|59|(1:63)|64|(1:66)(1:67)|68|(1:70)|71|72|73|74|75|76|(1:78)(1:79)|80|(3:81|82|(1:84))|85|87|88|(2:93|98)(2:92|97)) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:75:0x0227 */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x0242 A[Catch:{ Exception -> 0x02be }] */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x0245 A[Catch:{ Exception -> 0x02be }] */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x0263 A[Catch:{ Exception -> 0x0273 }] */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x029a A[Catch:{ Exception -> 0x02be }] */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x02b0 A[Catch:{ Exception -> 0x02be }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(java.lang.String r27, boolean r28) {
        /*
            r26 = this;
            r1 = r26
            r0 = r27
            java.lang.String r2 = "1"
            java.lang.String r3 = ""
            android.content.Context r4 = r1.j     // Catch:{ Exception -> 0x02be }
            if (r4 != 0) goto L_0x0012
            java.lang.String r0 = "Context is null"
            r1.c((java.lang.String) r0)     // Catch:{ Exception -> 0x02be }
            return
        L_0x0012:
            java.lang.String r4 = r1.k     // Catch:{ Exception -> 0x02be }
            boolean r4 = com.mbridge.msdk.foundation.tools.x.a(r4)     // Catch:{ Exception -> 0x02be }
            if (r4 == 0) goto L_0x0020
            java.lang.String r0 = "UnitId is null"
            r1.c((java.lang.String) r0)     // Catch:{ Exception -> 0x02be }
            return
        L_0x0020:
            com.mbridge.msdk.videocommon.d.c r4 = r1.t     // Catch:{ Exception -> 0x02be }
            if (r4 != 0) goto L_0x002a
            java.lang.String r0 = "RewardUnitSetting is null"
            r1.c((java.lang.String) r0)     // Catch:{ Exception -> 0x02be }
            return
        L_0x002a:
            boolean r4 = android.text.TextUtils.isEmpty(r27)     // Catch:{ Exception -> 0x02be }
            if (r4 == 0) goto L_0x004a
            com.mbridge.msdk.videocommon.d.c r4 = r1.t     // Catch:{ Exception -> 0x02be }
            int r4 = r4.a()     // Catch:{ Exception -> 0x02be }
            int r4 = r4 * 1000
            long r5 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x02be }
            long r7 = r1.F     // Catch:{ Exception -> 0x02be }
            long r5 = r5 - r7
            long r7 = (long) r4     // Catch:{ Exception -> 0x02be }
            int r4 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r4 >= 0) goto L_0x004a
            java.lang.String r0 = "EXCEPTION_RETURN_EMPTY"
            r1.c((java.lang.String) r0)     // Catch:{ Exception -> 0x02be }
            return
        L_0x004a:
            com.mbridge.msdk.foundation.controller.a r4 = com.mbridge.msdk.foundation.controller.a.e()     // Catch:{ Exception -> 0x02be }
            java.lang.String r4 = r4.h()     // Catch:{ Exception -> 0x02be }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x02be }
            r5.<init>()     // Catch:{ Exception -> 0x02be }
            com.mbridge.msdk.foundation.controller.a r6 = com.mbridge.msdk.foundation.controller.a.e()     // Catch:{ Exception -> 0x02be }
            java.lang.String r6 = r6.h()     // Catch:{ Exception -> 0x02be }
            r5.append(r6)     // Catch:{ Exception -> 0x02be }
            com.mbridge.msdk.foundation.controller.a r6 = com.mbridge.msdk.foundation.controller.a.e()     // Catch:{ Exception -> 0x02be }
            java.lang.String r6 = r6.i()     // Catch:{ Exception -> 0x02be }
            r5.append(r6)     // Catch:{ Exception -> 0x02be }
            java.lang.String r5 = r5.toString()     // Catch:{ Exception -> 0x02be }
            java.lang.String r5 = com.mbridge.msdk.foundation.tools.SameMD5.getMD5(r5)     // Catch:{ Exception -> 0x02be }
            boolean r6 = r1.p     // Catch:{ Exception -> 0x02be }
            if (r6 == 0) goto L_0x007b
            r6 = 2
            goto L_0x007c
        L_0x007b:
            r6 = 3
        L_0x007c:
            com.mbridge.msdk.videocommon.d.c r7 = r1.t     // Catch:{ Exception -> 0x02be }
            r8 = 0
            if (r7 == 0) goto L_0x008e
            com.mbridge.msdk.videocommon.d.c r7 = r1.t     // Catch:{ Exception -> 0x02be }
            int r8 = r7.r()     // Catch:{ Exception -> 0x02be }
            com.mbridge.msdk.videocommon.d.c r7 = r1.t     // Catch:{ Exception -> 0x02be }
            int r7 = r7.s()     // Catch:{ Exception -> 0x02be }
            goto L_0x008f
        L_0x008e:
            r7 = r8
        L_0x008f:
            java.lang.String r9 = r1.q     // Catch:{ Exception -> 0x02be }
            java.lang.String r10 = r1.k     // Catch:{ Exception -> 0x02be }
            java.lang.String r11 = "reward"
            java.lang.String r10 = com.mbridge.msdk.foundation.same.a.d.a(r10, r11)     // Catch:{ Exception -> 0x02be }
            int r11 = r26.g()     // Catch:{ Exception -> 0x02be }
            r1.m = r11     // Catch:{ Exception -> 0x02be }
            java.lang.String r11 = r26.i()     // Catch:{ Exception -> 0x02be }
            int r12 = r1.n     // Catch:{ Exception -> 0x02be }
            boolean r13 = r1.w     // Catch:{ Exception -> 0x02be }
            if (r13 == 0) goto L_0x00ac
            r13 = 287(0x11f, float:4.02E-43)
            goto L_0x00ae
        L_0x00ac:
            r13 = 94
        L_0x00ae:
            com.mbridge.msdk.foundation.same.net.h.d r14 = new com.mbridge.msdk.foundation.same.net.h.d     // Catch:{ Exception -> 0x02be }
            r14.<init>()     // Catch:{ Exception -> 0x02be }
            java.lang.String r15 = "app_id"
            com.mbridge.msdk.foundation.same.net.g.b.a(r14, r15, r4)     // Catch:{ Exception -> 0x02be }
            java.lang.String r4 = "unit_id"
            java.lang.String r15 = r1.k     // Catch:{ Exception -> 0x02be }
            com.mbridge.msdk.foundation.same.net.g.b.a(r14, r4, r15)     // Catch:{ Exception -> 0x02be }
            java.lang.String r4 = r1.l     // Catch:{ Exception -> 0x02be }
            boolean r4 = android.text.TextUtils.isEmpty(r4)     // Catch:{ Exception -> 0x02be }
            if (r4 != 0) goto L_0x00ce
            java.lang.String r4 = com.mbridge.msdk.MBridgeConstans.PLACEMENT_ID     // Catch:{ Exception -> 0x02be }
            java.lang.String r15 = r1.l     // Catch:{ Exception -> 0x02be }
            com.mbridge.msdk.foundation.same.net.g.b.a(r14, r4, r15)     // Catch:{ Exception -> 0x02be }
        L_0x00ce:
            java.lang.String r4 = "sign"
            com.mbridge.msdk.foundation.same.net.g.b.a(r14, r4, r5)     // Catch:{ Exception -> 0x02be }
            java.lang.String r4 = "req_type"
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x02be }
            r5.<init>()     // Catch:{ Exception -> 0x02be }
            r5.append(r6)     // Catch:{ Exception -> 0x02be }
            r5.append(r3)     // Catch:{ Exception -> 0x02be }
            java.lang.String r5 = r5.toString()     // Catch:{ Exception -> 0x02be }
            com.mbridge.msdk.foundation.same.net.g.b.a(r14, r4, r5)     // Catch:{ Exception -> 0x02be }
            java.lang.String r4 = "ad_num"
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x02be }
            r5.<init>()     // Catch:{ Exception -> 0x02be }
            r5.append(r8)     // Catch:{ Exception -> 0x02be }
            r5.append(r3)     // Catch:{ Exception -> 0x02be }
            java.lang.String r5 = r5.toString()     // Catch:{ Exception -> 0x02be }
            com.mbridge.msdk.foundation.same.net.g.b.a(r14, r4, r5)     // Catch:{ Exception -> 0x02be }
            java.lang.String r4 = "tnum"
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x02be }
            r5.<init>()     // Catch:{ Exception -> 0x02be }
            boolean r6 = r1.w     // Catch:{ Exception -> 0x02be }
            if (r6 == 0) goto L_0x0107
            r7 = 1
        L_0x0107:
            r5.append(r7)     // Catch:{ Exception -> 0x02be }
            r5.append(r3)     // Catch:{ Exception -> 0x02be }
            java.lang.String r5 = r5.toString()     // Catch:{ Exception -> 0x02be }
            com.mbridge.msdk.foundation.same.net.g.b.a(r14, r4, r5)     // Catch:{ Exception -> 0x02be }
            java.lang.String r4 = "only_impression"
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x02be }
            r5.<init>()     // Catch:{ Exception -> 0x02be }
            r5.append(r2)     // Catch:{ Exception -> 0x02be }
            r5.append(r3)     // Catch:{ Exception -> 0x02be }
            java.lang.String r5 = r5.toString()     // Catch:{ Exception -> 0x02be }
            com.mbridge.msdk.foundation.same.net.g.b.a(r14, r4, r5)     // Catch:{ Exception -> 0x02be }
            java.lang.String r4 = "ping_mode"
            com.mbridge.msdk.foundation.same.net.g.b.a(r14, r4, r2)     // Catch:{ Exception -> 0x02be }
            java.lang.String r4 = com.mbridge.msdk.foundation.same.net.h.d.b     // Catch:{ Exception -> 0x02be }
            com.mbridge.msdk.foundation.same.net.g.b.a(r14, r4, r10)     // Catch:{ Exception -> 0x02be }
            java.lang.String r4 = com.mbridge.msdk.foundation.same.net.h.d.c     // Catch:{ Exception -> 0x02be }
            com.mbridge.msdk.foundation.same.net.g.b.a(r14, r4, r9)     // Catch:{ Exception -> 0x02be }
            java.lang.String r4 = "ad_source_id"
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x02be }
            r5.<init>()     // Catch:{ Exception -> 0x02be }
            r5.append(r12)     // Catch:{ Exception -> 0x02be }
            r5.append(r3)     // Catch:{ Exception -> 0x02be }
            java.lang.String r5 = r5.toString()     // Catch:{ Exception -> 0x02be }
            com.mbridge.msdk.foundation.same.net.g.b.a(r14, r4, r5)     // Catch:{ Exception -> 0x02be }
            java.lang.String r4 = com.mbridge.msdk.foundation.same.net.h.d.a     // Catch:{ Exception -> 0x02be }
            com.mbridge.msdk.foundation.same.net.g.b.a(r14, r4, r11)     // Catch:{ Exception -> 0x02be }
            java.lang.String r4 = "ad_type"
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x02be }
            r5.<init>()     // Catch:{ Exception -> 0x02be }
            r5.append(r13)     // Catch:{ Exception -> 0x02be }
            r5.append(r3)     // Catch:{ Exception -> 0x02be }
            java.lang.String r5 = r5.toString()     // Catch:{ Exception -> 0x02be }
            com.mbridge.msdk.foundation.same.net.g.b.a(r14, r4, r5)     // Catch:{ Exception -> 0x02be }
            java.lang.String r4 = "offset"
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x02be }
            r5.<init>()     // Catch:{ Exception -> 0x02be }
            int r6 = r1.m     // Catch:{ Exception -> 0x02be }
            r5.append(r6)     // Catch:{ Exception -> 0x02be }
            r5.append(r3)     // Catch:{ Exception -> 0x02be }
            java.lang.String r3 = r5.toString()     // Catch:{ Exception -> 0x02be }
            com.mbridge.msdk.foundation.same.net.g.b.a(r14, r4, r3)     // Catch:{ Exception -> 0x02be }
            com.mbridge.msdk.foundation.same.net.g.d r3 = com.mbridge.msdk.foundation.same.net.g.d.c()     // Catch:{ Exception -> 0x02be }
            java.lang.String r18 = r3.a(r0)     // Catch:{ Exception -> 0x02be }
            boolean r3 = android.text.TextUtils.isEmpty(r27)     // Catch:{ Exception -> 0x02be }
            if (r3 != 0) goto L_0x018d
            java.lang.String r3 = "token"
            r14.a(r3, r0)     // Catch:{ Exception -> 0x02be }
        L_0x018d:
            boolean r3 = r1.w     // Catch:{ Exception -> 0x02be }
            java.lang.String r4 = "0"
            if (r3 == 0) goto L_0x01a9
            int r3 = r1.z     // Catch:{ Exception -> 0x02be }
            int r5 = com.mbridge.msdk.foundation.same.a.o     // Catch:{ Exception -> 0x02be }
            java.lang.String r6 = "ivrwd"
            if (r3 == r5) goto L_0x01a6
            int r3 = r1.z     // Catch:{ Exception -> 0x02be }
            int r5 = com.mbridge.msdk.foundation.same.a.n     // Catch:{ Exception -> 0x02be }
            if (r3 != r5) goto L_0x01a2
            goto L_0x01a6
        L_0x01a2:
            r14.a(r6, r4)     // Catch:{ Exception -> 0x02be }
            goto L_0x01a9
        L_0x01a6:
            r14.a(r6, r2)     // Catch:{ Exception -> 0x02be }
        L_0x01a9:
            com.mbridge.msdk.videocommon.d.b r3 = com.mbridge.msdk.videocommon.d.b.a()     // Catch:{ Exception -> 0x02be }
            com.mbridge.msdk.foundation.controller.a r5 = com.mbridge.msdk.foundation.controller.a.e()     // Catch:{ Exception -> 0x02be }
            java.lang.String r5 = r5.h()     // Catch:{ Exception -> 0x02be }
            java.lang.String r6 = r1.k     // Catch:{ Exception -> 0x02be }
            boolean r7 = r1.w     // Catch:{ Exception -> 0x02be }
            com.mbridge.msdk.videocommon.d.c r3 = r3.a((java.lang.String) r5, (java.lang.String) r6, (boolean) r7)     // Catch:{ Exception -> 0x02be }
            if (r3 == 0) goto L_0x01d2
            java.lang.String r5 = r3.j()     // Catch:{ Exception -> 0x02be }
            boolean r5 = android.text.TextUtils.isEmpty(r5)     // Catch:{ Exception -> 0x02be }
            if (r5 != 0) goto L_0x01d2
            java.lang.String r5 = "u_stid"
            java.lang.String r3 = r3.j()     // Catch:{ Exception -> 0x02be }
            r14.a(r5, r3)     // Catch:{ Exception -> 0x02be }
        L_0x01d2:
            com.mbridge.msdk.videocommon.d.b r3 = com.mbridge.msdk.videocommon.d.b.a()     // Catch:{ Exception -> 0x02be }
            com.mbridge.msdk.videocommon.d.a r3 = r3.b()     // Catch:{ Exception -> 0x02be }
            if (r3 == 0) goto L_0x01ef
            java.lang.String r5 = r3.a()     // Catch:{ Exception -> 0x02be }
            boolean r5 = android.text.TextUtils.isEmpty(r5)     // Catch:{ Exception -> 0x02be }
            if (r5 != 0) goto L_0x01ef
            java.lang.String r5 = "r_stid"
            java.lang.String r3 = r3.a()     // Catch:{ Exception -> 0x02be }
            r14.a(r5, r3)     // Catch:{ Exception -> 0x02be }
        L_0x01ef:
            java.lang.String r3 = "rw_plus"
            if (r28 == 0) goto L_0x01f4
            goto L_0x01f5
        L_0x01f4:
            r2 = r4
        L_0x01f5:
            r14.a(r3, r2)     // Catch:{ Exception -> 0x02be }
            java.lang.String r2 = r1.k     // Catch:{ Exception -> 0x02be }
            java.lang.String r2 = com.mbridge.msdk.foundation.tools.u.e((java.lang.String) r2)     // Catch:{ Exception -> 0x02be }
            boolean r3 = android.text.TextUtils.isEmpty(r2)     // Catch:{ Exception -> 0x02be }
            if (r3 != 0) goto L_0x0209
            java.lang.String r3 = "j"
            r14.a(r3, r2)     // Catch:{ Exception -> 0x02be }
        L_0x0209:
            long r2 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x02be }
            r1.K = r2     // Catch:{ Exception -> 0x02be }
            r4 = 0
            android.content.Context r5 = r1.j     // Catch:{ Exception -> 0x0227 }
            java.lang.String r6 = "start load offer from server"
            java.lang.String r7 = r1.k     // Catch:{ Exception -> 0x0227 }
            boolean r8 = r1.x     // Catch:{ Exception -> 0x0227 }
            java.lang.String r9 = ""
            java.lang.String r10 = ""
            long r2 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x0227 }
            long r11 = r1.K     // Catch:{ Exception -> 0x0227 }
            long r11 = r2 - r11
            com.mbridge.msdk.reward.b.a.a(r4, r5, r6, r7, r8, r9, r10, r11)     // Catch:{ Exception -> 0x0227 }
        L_0x0227:
            com.mbridge.msdk.reward.c.b r2 = new com.mbridge.msdk.reward.c.b     // Catch:{ Exception -> 0x02be }
            android.content.Context r3 = r1.j     // Catch:{ Exception -> 0x02be }
            r2.<init>(r3)     // Catch:{ Exception -> 0x02be }
            com.mbridge.msdk.reward.adapter.d$2 r3 = new com.mbridge.msdk.reward.adapter.d$2     // Catch:{ Exception -> 0x02be }
            r3.<init>()     // Catch:{ Exception -> 0x02be }
            r3.a((java.lang.String) r0)     // Catch:{ Exception -> 0x02be }
            java.lang.String r4 = r1.k     // Catch:{ Exception -> 0x02be }
            r3.d = r4     // Catch:{ Exception -> 0x02be }
            java.lang.String r4 = r1.l     // Catch:{ Exception -> 0x02be }
            r3.e = r4     // Catch:{ Exception -> 0x02be }
            boolean r4 = r1.w     // Catch:{ Exception -> 0x02be }
            if (r4 == 0) goto L_0x0245
            r4 = 287(0x11f, float:4.02E-43)
            goto L_0x0247
        L_0x0245:
            r4 = 94
        L_0x0247:
            r3.f = r4     // Catch:{ Exception -> 0x02be }
            int r4 = com.mbridge.msdk.foundation.same.a.x     // Catch:{ Exception -> 0x02be }
            int r5 = com.mbridge.msdk.foundation.same.a.y     // Catch:{ Exception -> 0x02be }
            int r6 = com.mbridge.msdk.foundation.same.a.w     // Catch:{ Exception -> 0x02be }
            int r7 = com.mbridge.msdk.foundation.same.a.z     // Catch:{ Exception -> 0x02be }
            com.mbridge.msdk.b.b r8 = com.mbridge.msdk.b.b.a()     // Catch:{ Exception -> 0x0273 }
            com.mbridge.msdk.foundation.controller.a r9 = com.mbridge.msdk.foundation.controller.a.e()     // Catch:{ Exception -> 0x0273 }
            java.lang.String r9 = r9.h()     // Catch:{ Exception -> 0x0273 }
            com.mbridge.msdk.b.a r8 = r8.f(r9)     // Catch:{ Exception -> 0x0273 }
            if (r8 == 0) goto L_0x0273
            int r4 = r8.g()     // Catch:{ Exception -> 0x0273 }
            int r5 = r8.h()     // Catch:{ Exception -> 0x0273 }
            int r6 = r8.i()     // Catch:{ Exception -> 0x0273 }
            int r7 = r8.j()     // Catch:{ Exception -> 0x0273 }
        L_0x0273:
            r21 = r4
            r22 = r5
            r20 = r6
            r24 = r7
            com.mbridge.msdk.foundation.same.net.b r4 = new com.mbridge.msdk.foundation.same.net.b     // Catch:{ Exception -> 0x02be }
            int r5 = r1.o     // Catch:{ Exception -> 0x02be }
            int r5 = r5 * 1000
            r25 = 4
            r19 = r4
            r23 = r5
            r19.<init>(r20, r21, r22, r23, r24, r25)     // Catch:{ Exception -> 0x02be }
            com.mbridge.msdk.foundation.same.net.g.d r5 = com.mbridge.msdk.foundation.same.net.g.d.c()     // Catch:{ Exception -> 0x02be }
            boolean r5 = r5.b()     // Catch:{ Exception -> 0x02be }
            if (r5 == 0) goto L_0x02b0
            boolean r5 = android.text.TextUtils.isEmpty(r27)     // Catch:{ Exception -> 0x02be }
            if (r5 == 0) goto L_0x02b0
            r17 = 1
            com.mbridge.msdk.foundation.same.net.g.d r5 = com.mbridge.msdk.foundation.same.net.g.d.c()     // Catch:{ Exception -> 0x02be }
            java.lang.String r18 = r5.a(r0)     // Catch:{ Exception -> 0x02be }
            r16 = r2
            r19 = r14
            r20 = r3
            r21 = r4
            r16.a((int) r17, (java.lang.String) r18, (com.mbridge.msdk.foundation.same.net.h.d) r19, (com.mbridge.msdk.foundation.same.net.e) r20, (com.mbridge.msdk.foundation.same.net.l) r21)     // Catch:{ Exception -> 0x02be }
            goto L_0x02ca
        L_0x02b0:
            r17 = 1
            r16 = r2
            r19 = r14
            r20 = r4
            r21 = r3
            r16.a((int) r17, (java.lang.String) r18, (com.mbridge.msdk.foundation.same.net.h.d) r19, (com.mbridge.msdk.foundation.same.net.l) r20, (com.mbridge.msdk.foundation.same.net.e) r21)     // Catch:{ Exception -> 0x02be }
            goto L_0x02ca
        L_0x02be:
            r0 = move-exception
            r0.printStackTrace()
            java.lang.String r0 = "Load exception"
            r1.c((java.lang.String) r0)
            r26.h()
        L_0x02ca:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.reward.adapter.d.a(java.lang.String, boolean):void");
    }

    /* access modifiers changed from: private */
    public void c(String str) {
        if (this.J == null) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            this.J.sendEmptyMessage(4);
            return;
        }
        Message obtain = Message.obtain();
        obtain.what = 4;
        obtain.obj = str;
        if (str.contains("exception")) {
            this.J.sendMessageAtFrontOfQueue(obtain);
        } else {
            this.J.sendMessage(obtain);
        }
    }

    private void f() {
        if (com.mbridge.msdk.videocommon.a.a.a() != null) {
            try {
                com.mbridge.msdk.b.a b2 = com.mbridge.msdk.b.b.a().b(com.mbridge.msdk.foundation.controller.a.e().h());
                if (b2 == null) {
                    b2 = com.mbridge.msdk.b.b.a().b();
                }
                com.mbridge.msdk.videocommon.a.a.a().a(b2.v() * 1000, this.k);
            } catch (Exception e2) {
                if (MBridgeConstans.DEBUG) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public final void a(b bVar) {
        this.s = bVar;
    }

    public final void d(boolean z2) {
        List<CampaignEx> list;
        if (!z2 && (list = this.D) != null && list.size() > 0) {
            com.mbridge.msdk.videocommon.a.a.a().a(this.k, this.D);
        }
    }

    public final void e(boolean z2) {
        if (z2) {
            List<CampaignEx> list = this.N;
            if (list != null && list.size() > 0) {
                for (CampaignEx next : this.N) {
                    if (next != null) {
                        next.setLoadTimeoutState(0);
                        if (next.getRewardTemplateMode() != null && !TextUtils.isEmpty(next.getRewardTemplateMode().e())) {
                            i a2 = i.a();
                            a2.d(this.k + "_" + next.getRequestId() + "_" + next.getRewardTemplateMode().e(), false);
                        }
                    }
                }
                com.mbridge.msdk.videocommon.a.a.a().a(this.k, this.N, "load_timeout", 0);
                return;
            }
            return;
        }
        List<CampaignEx> list2 = this.D;
        if (list2 != null && list2.size() > 0) {
            for (CampaignEx next2 : this.D) {
                if (next2 != null) {
                    next2.setLoadTimeoutState(0);
                    if (next2.getRewardTemplateMode() != null && !TextUtils.isEmpty(next2.getRewardTemplateMode().e())) {
                        i a3 = i.a();
                        a3.d(this.k + "_" + next2.getRequestId() + "_" + next2.getRewardTemplateMode().e(), false);
                    }
                }
            }
            com.mbridge.msdk.videocommon.a.a.a().a(this.k, this.D, "load_timeout", 0);
        }
    }

    public final boolean f(boolean z2) {
        if (z2) {
            List<CampaignEx> list = this.N;
            if (list == null || list.size() <= 0) {
                return false;
            }
            for (CampaignEx next : this.N) {
                if (next != null) {
                    next.setLoadTimeoutState(1);
                    if (next.getRewardTemplateMode() != null && !TextUtils.isEmpty(next.getRewardTemplateMode().e())) {
                        i a2 = i.a();
                        a2.d(this.k + "_" + next.getRequestId() + "_" + next.getRewardTemplateMode().e(), true);
                    }
                }
            }
            com.mbridge.msdk.videocommon.a.a.a().a(this.k, this.N, "load_timeout", 1);
            return true;
        }
        List<CampaignEx> list2 = this.D;
        if (list2 == null || list2.size() <= 0) {
            return false;
        }
        for (CampaignEx next2 : this.D) {
            if (next2 != null) {
                next2.setLoadTimeoutState(1);
                if (next2.getRewardTemplateMode() != null && !TextUtils.isEmpty(next2.getRewardTemplateMode().e())) {
                    i a3 = i.a();
                    a3.d(this.k + "_" + next2.getRequestId() + "_" + next2.getRewardTemplateMode().e(), true);
                }
            }
        }
        com.mbridge.msdk.videocommon.a.a.a().a(this.k, this.D, "load_timeout", 1);
        return true;
    }

    private void a(String str, List<CampaignEx> list, List<CampaignEx> list2) {
        if (!(com.mbridge.msdk.videocommon.a.a.a() == null || this.C == null)) {
            com.mbridge.msdk.videocommon.a.a.a().b(str);
        }
        if (!(com.mbridge.msdk.videocommon.a.a.a() == null || this.C == null)) {
            com.mbridge.msdk.videocommon.a.a.a().b(str, this.C.getVcn());
        }
        if (list != null && list.size() > 0) {
            if (!(this.C == null || list.get(0) == null)) {
                com.mbridge.msdk.reward.a.a.a(this.C.getRequestId(), list.get(0).getBidToken());
            }
            for (CampaignEx next : list) {
                if (next != null) {
                    com.mbridge.msdk.foundation.same.a.d.a(next.getCampaignUnitId(), next.getRequestId(), next.getId(), next.getPlct(), next.getPlctb(), next.getTimestamp());
                }
            }
        }
        if (list2 != null && list2.size() > 0) {
            for (CampaignEx next2 : list2) {
                if (next2 != null) {
                    com.mbridge.msdk.foundation.same.a.d.b(next2.getCampaignUnitId(), next2.getRequestId());
                }
            }
        }
        com.mbridge.msdk.foundation.same.a.d.b(str);
        com.mbridge.msdk.foundation.db.b.a(com.mbridge.msdk.foundation.controller.a.e().g()).a();
    }

    private void a(CampaignEx campaignEx) {
        try {
            com.mbridge.msdk.videocommon.a.a a2 = com.mbridge.msdk.videocommon.a.a.a();
            if (a2 != null) {
                a2.a(campaignEx);
            }
        } catch (Throwable th) {
            q.a("RewardMVVideoAdapter", th.getMessage(), th);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:102:0x01c3, code lost:
        if (r1 != null) goto L_0x01c5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:104:?, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:109:0x01cf, code lost:
        if (r1 == null) goto L_0x01d2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:119:0x01c3, code lost:
        r1 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:124:0x01bf, code lost:
        r1 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x0120, code lost:
        if (r7 == null) goto L_0x012e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x0148, code lost:
        if (r6.canRead() == false) goto L_0x014a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x0187, code lost:
        if (com.mbridge.msdk.foundation.tools.x.a(r5.getVideoUrlEncode()) != false) goto L_0x0189;
     */
    /* JADX WARNING: Failed to insert additional move for type inference */
    /* JADX WARNING: Removed duplicated region for block: B:100:0x01bb A[Catch:{ Exception -> 0x01cb }] */
    /* JADX WARNING: Removed duplicated region for block: B:113:0x01d5 A[SYNTHETIC, Splitter:B:113:0x01d5] */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x0155 A[Catch:{ Exception -> 0x01cb }] */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x018e A[Catch:{ Exception -> 0x01cb }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx> a(com.mbridge.msdk.foundation.entity.CampaignUnit r13) {
        /*
            r12 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r1 = 0
            com.mbridge.msdk.videocommon.d.c r2 = r12.t     // Catch:{ Exception -> 0x01cb }
            if (r2 == 0) goto L_0x0010
            com.mbridge.msdk.videocommon.d.c r2 = r12.t     // Catch:{ Exception -> 0x01cb }
            int r2 = r2.s()     // Catch:{ Exception -> 0x01cb }
        L_0x0010:
            r2 = 2147483647(0x7fffffff, float:NaN)
            if (r13 == 0) goto L_0x01c3
            java.util.ArrayList r3 = r13.getAds()     // Catch:{ Exception -> 0x01cb }
            if (r3 == 0) goto L_0x01c3
            java.util.ArrayList r3 = r13.getAds()     // Catch:{ Exception -> 0x01cb }
            int r3 = r3.size()     // Catch:{ Exception -> 0x01cb }
            if (r3 <= 0) goto L_0x01c3
            java.util.ArrayList r3 = r13.getAds()     // Catch:{ Exception -> 0x01cb }
            r12.M = r3     // Catch:{ Exception -> 0x01cb }
            r4 = 0
            if (r13 == 0) goto L_0x005a
            java.util.ArrayList r5 = r13.getAds()     // Catch:{ Exception -> 0x01cb }
            if (r5 == 0) goto L_0x005a
            java.util.ArrayList r5 = r13.getAds()     // Catch:{ Exception -> 0x01cb }
            int r5 = r5.size()     // Catch:{ Exception -> 0x01cb }
            if (r5 <= 0) goto L_0x005a
            java.util.ArrayList r13 = r13.getAds()     // Catch:{ Exception -> 0x01cb }
            r5 = r4
        L_0x0043:
            int r6 = r13.size()     // Catch:{ Exception -> 0x01cb }
            if (r5 >= r6) goto L_0x005a
            java.lang.Object r6 = r13.get(r5)     // Catch:{ Exception -> 0x01cb }
            com.mbridge.msdk.foundation.entity.CampaignEx r6 = (com.mbridge.msdk.foundation.entity.CampaignEx) r6     // Catch:{ Exception -> 0x01cb }
            java.lang.String r7 = r12.k     // Catch:{ Exception -> 0x01cb }
            r6.setCampaignUnitId(r7)     // Catch:{ Exception -> 0x01cb }
            r13.set(r5, r6)     // Catch:{ Exception -> 0x01cb }
            int r5 = r5 + 1
            goto L_0x0043
        L_0x005a:
            r13 = r4
        L_0x005b:
            int r5 = r3.size()     // Catch:{ Exception -> 0x01cb }
            if (r13 >= r5) goto L_0x01c3
            if (r13 >= r2) goto L_0x01c3
            java.lang.Object r5 = r3.get(r13)     // Catch:{ Exception -> 0x01cb }
            com.mbridge.msdk.foundation.entity.CampaignEx r5 = (com.mbridge.msdk.foundation.entity.CampaignEx) r5     // Catch:{ Exception -> 0x01cb }
            boolean r6 = r5.isMraid()     // Catch:{ Exception -> 0x01cb }
            if (r6 == 0) goto L_0x0159
            java.lang.String r6 = r5.getMraid()     // Catch:{ Exception -> 0x01cb }
            java.lang.String r6 = r6.trim()     // Catch:{ Exception -> 0x01cb }
            boolean r6 = android.text.TextUtils.isEmpty(r6)     // Catch:{ Exception -> 0x01cb }
            if (r6 != 0) goto L_0x01bf
            int r6 = r5.getAdType()     // Catch:{ Exception -> 0x01cb }
            r7 = 287(0x11f, float:4.02E-43)
            java.lang.String r8 = ""
            if (r6 != r7) goto L_0x008a
            java.lang.String r6 = "3"
            goto L_0x00a1
        L_0x008a:
            int r6 = r5.getAdType()     // Catch:{ Exception -> 0x01cb }
            r7 = 94
            if (r6 != r7) goto L_0x0095
            java.lang.String r6 = "1"
            goto L_0x00a1
        L_0x0095:
            int r6 = r5.getAdType()     // Catch:{ Exception -> 0x01cb }
            r7 = 42
            if (r6 != r7) goto L_0x00a0
            java.lang.String r6 = "2"
            goto L_0x00a1
        L_0x00a0:
            r6 = r8
        L_0x00a1:
            com.mbridge.msdk.foundation.same.b.c r7 = com.mbridge.msdk.foundation.same.b.c.MBRIDGE_700_HTML     // Catch:{ Exception -> 0x010d, all -> 0x010b }
            java.lang.String r7 = com.mbridge.msdk.foundation.same.b.e.b(r7)     // Catch:{ Exception -> 0x010d, all -> 0x010b }
            java.lang.String r9 = r5.getMraid()     // Catch:{ Exception -> 0x010d, all -> 0x010b }
            java.lang.String r9 = com.mbridge.msdk.foundation.tools.SameMD5.getMD5(r9)     // Catch:{ Exception -> 0x010d, all -> 0x010b }
            boolean r10 = android.text.TextUtils.isEmpty(r9)     // Catch:{ Exception -> 0x010d, all -> 0x010b }
            if (r10 == 0) goto L_0x00bd
            long r9 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x010d, all -> 0x010b }
            java.lang.String r9 = java.lang.String.valueOf(r9)     // Catch:{ Exception -> 0x010d, all -> 0x010b }
        L_0x00bd:
            java.lang.String r10 = ".html"
            java.lang.String r9 = r9.concat(r10)     // Catch:{ Exception -> 0x010d, all -> 0x010b }
            java.io.File r10 = new java.io.File     // Catch:{ Exception -> 0x010d, all -> 0x010b }
            r10.<init>(r7, r9)     // Catch:{ Exception -> 0x010d, all -> 0x010b }
            java.io.FileOutputStream r7 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x010d, all -> 0x010b }
            r7.<init>(r10)     // Catch:{ Exception -> 0x010d, all -> 0x010b }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0109 }
            r1.<init>()     // Catch:{ Exception -> 0x0109 }
            java.lang.String r9 = "<script>"
            r1.append(r9)     // Catch:{ Exception -> 0x0109 }
            com.mbridge.msdk.b.b.a r9 = com.mbridge.msdk.b.b.a.a()     // Catch:{ Exception -> 0x0109 }
            java.lang.String r9 = r9.b()     // Catch:{ Exception -> 0x0109 }
            r1.append(r9)     // Catch:{ Exception -> 0x0109 }
            java.lang.String r9 = "</script>"
            r1.append(r9)     // Catch:{ Exception -> 0x0109 }
            java.lang.String r9 = r5.getMraid()     // Catch:{ Exception -> 0x0109 }
            r1.append(r9)     // Catch:{ Exception -> 0x0109 }
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x0109 }
            byte[] r1 = r1.getBytes()     // Catch:{ Exception -> 0x0109 }
            r7.write(r1)     // Catch:{ Exception -> 0x0109 }
            r7.flush()     // Catch:{ Exception -> 0x0109 }
            java.lang.String r1 = r10.getAbsolutePath()     // Catch:{ Exception -> 0x0109 }
            r5.setMraid(r1)     // Catch:{ Exception -> 0x0109 }
            java.lang.String r1 = r12.k     // Catch:{ Exception -> 0x0109 }
            com.mbridge.msdk.foundation.same.report.b.a(r5, r8, r1, r6)     // Catch:{ Exception -> 0x0109 }
            goto L_0x0122
        L_0x0109:
            r1 = move-exception
            goto L_0x0111
        L_0x010b:
            r13 = move-exception
            goto L_0x0153
        L_0x010d:
            r7 = move-exception
            r11 = r7
            r7 = r1
            r1 = r11
        L_0x0111:
            r1.printStackTrace()     // Catch:{ all -> 0x0151 }
            r5.setMraid(r8)     // Catch:{ all -> 0x0151 }
            java.lang.String r1 = r1.getMessage()     // Catch:{ all -> 0x0151 }
            java.lang.String r8 = r12.k     // Catch:{ all -> 0x0151 }
            com.mbridge.msdk.foundation.same.report.b.a(r5, r1, r8, r6)     // Catch:{ all -> 0x0151 }
            if (r7 == 0) goto L_0x012e
        L_0x0122:
            r7.close()     // Catch:{ Exception -> 0x012a, all -> 0x0126 }
            goto L_0x012e
        L_0x0126:
            r13 = move-exception
            r1 = r7
            goto L_0x01d3
        L_0x012a:
            r13 = move-exception
            r1 = r7
            goto L_0x01cc
        L_0x012e:
            r1 = r7
            java.io.File r6 = new java.io.File     // Catch:{ Exception -> 0x01cb }
            java.lang.String r7 = r5.getMraid()     // Catch:{ Exception -> 0x01cb }
            r6.<init>(r7)     // Catch:{ Exception -> 0x01cb }
            boolean r7 = r6.exists()     // Catch:{ Exception -> 0x01cb }
            if (r7 == 0) goto L_0x014a
            boolean r7 = r6.isFile()     // Catch:{ Exception -> 0x01cb }
            if (r7 == 0) goto L_0x014a
            boolean r6 = r6.canRead()     // Catch:{ Exception -> 0x01cb }
            if (r6 != 0) goto L_0x0159
        L_0x014a:
            java.lang.String r5 = "mraid resource write fail"
            r12.c((java.lang.String) r5)     // Catch:{ Exception -> 0x01cb }
            goto L_0x01bf
        L_0x0151:
            r13 = move-exception
            r1 = r7
        L_0x0153:
            if (r1 == 0) goto L_0x0158
            r1.close()     // Catch:{ Exception -> 0x01cb }
        L_0x0158:
            throw r13     // Catch:{ Exception -> 0x01cb }
        L_0x0159:
            if (r5 == 0) goto L_0x01bf
            int r6 = r5.getOfferType()     // Catch:{ Exception -> 0x01cb }
            r7 = 99
            if (r6 == r7) goto L_0x01bf
            boolean r6 = r12.b((com.mbridge.msdk.foundation.entity.CampaignEx) r5)     // Catch:{ Exception -> 0x01cb }
            r7 = 1
            if (r6 == 0) goto L_0x017f
            java.lang.String r6 = r5.getendcard_url()     // Catch:{ Exception -> 0x01cb }
            boolean r6 = com.mbridge.msdk.foundation.tools.x.a(r6)     // Catch:{ Exception -> 0x01cb }
            if (r6 == 0) goto L_0x018b
            java.lang.String r6 = r5.getMraid()     // Catch:{ Exception -> 0x01cb }
            boolean r6 = android.text.TextUtils.isEmpty(r6)     // Catch:{ Exception -> 0x01cb }
            if (r6 == 0) goto L_0x018b
            goto L_0x0189
        L_0x017f:
            java.lang.String r6 = r5.getVideoUrlEncode()     // Catch:{ Exception -> 0x01cb }
            boolean r6 = com.mbridge.msdk.foundation.tools.x.a(r6)     // Catch:{ Exception -> 0x01cb }
            if (r6 == 0) goto L_0x018b
        L_0x0189:
            r6 = r4
            goto L_0x018c
        L_0x018b:
            r6 = r7
        L_0x018c:
            if (r6 == 0) goto L_0x01bb
            int r6 = r5.getWtick()     // Catch:{ Exception -> 0x01cb }
            if (r6 == r7) goto L_0x01b7
            android.content.Context r6 = r12.j     // Catch:{ Exception -> 0x01cb }
            java.lang.String r7 = r5.getPackageName()     // Catch:{ Exception -> 0x01cb }
            boolean r6 = com.mbridge.msdk.foundation.tools.u.c(r6, r7)     // Catch:{ Exception -> 0x01cb }
            if (r6 != 0) goto L_0x01a1
            goto L_0x01b7
        L_0x01a1:
            boolean r6 = com.mbridge.msdk.foundation.tools.u.b((com.mbridge.msdk.foundation.entity.CampaignEx) r5)     // Catch:{ Exception -> 0x01cb }
            if (r6 == 0) goto L_0x01ab
            r0.add(r5)     // Catch:{ Exception -> 0x01cb }
            goto L_0x01bf
        L_0x01ab:
            java.lang.String r6 = r12.k     // Catch:{ Exception -> 0x01cb }
            int r7 = com.mbridge.msdk.foundation.same.a.v     // Catch:{ Exception -> 0x01cb }
            com.mbridge.msdk.foundation.tools.u.a((java.lang.String) r6, (com.mbridge.msdk.foundation.entity.CampaignEx) r5, (int) r7)     // Catch:{ Exception -> 0x01cb }
            java.lang.String r5 = "APP ALREADY INSTALLED"
            r12.L = r5     // Catch:{ Exception -> 0x01cb }
            goto L_0x01bf
        L_0x01b7:
            r0.add(r5)     // Catch:{ Exception -> 0x01cb }
            goto L_0x01bf
        L_0x01bb:
            java.lang.String r5 = "No video campaign"
            r12.L = r5     // Catch:{ Exception -> 0x01cb }
        L_0x01bf:
            int r13 = r13 + 1
            goto L_0x005b
        L_0x01c3:
            if (r1 == 0) goto L_0x01d2
        L_0x01c5:
            r1.close()     // Catch:{ IOException -> 0x01d2 }
            goto L_0x01d2
        L_0x01c9:
            r13 = move-exception
            goto L_0x01d3
        L_0x01cb:
            r13 = move-exception
        L_0x01cc:
            r13.printStackTrace()     // Catch:{ all -> 0x01c9 }
            if (r1 == 0) goto L_0x01d2
            goto L_0x01c5
        L_0x01d2:
            return r0
        L_0x01d3:
            if (r1 == 0) goto L_0x01d8
            r1.close()     // Catch:{ IOException -> 0x01d8 }
        L_0x01d8:
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.reward.adapter.d.a(com.mbridge.msdk.foundation.entity.CampaignUnit):java.util.List");
    }

    private int g() {
        try {
            int a2 = x.b(this.k) ? com.mbridge.msdk.reward.a.a.a(this.k) : 0;
            if (this.t == null || a2 > this.t.t()) {
                return 0;
            }
            return a2;
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    /* access modifiers changed from: private */
    public void h() {
        try {
            if (x.b(this.k)) {
                com.mbridge.msdk.reward.a.a.a(this.k, 0);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private String i() {
        try {
            if (x.b(com.mbridge.msdk.reward.a.a.a)) {
                return com.mbridge.msdk.reward.a.a.a;
            }
            return "";
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    private void j() {
        try {
            if (com.mbridge.msdk.foundation.same.a.d.a != null && com.mbridge.msdk.foundation.same.a.d.a.size() > 0) {
                com.mbridge.msdk.foundation.same.a.d.a.clear();
            }
        } catch (Exception e2) {
            if (MBridgeConstans.DEBUG) {
                e2.printStackTrace();
            }
        }
    }

    private void k() {
        try {
            com.mbridge.msdk.foundation.db.i.a((com.mbridge.msdk.foundation.db.f) com.mbridge.msdk.foundation.db.g.a(this.j)).a(this.k);
        } catch (Exception e2) {
            if (MBridgeConstans.DEBUG) {
                e2.printStackTrace();
            }
        }
    }

    private boolean b(CampaignEx campaignEx) {
        if (campaignEx == null) {
            return false;
        }
        try {
            if (campaignEx.getPlayable_ads_without_video() == 2) {
                return true;
            }
            return false;
        } catch (Throwable th) {
            if (!MBridgeConstans.DEBUG) {
                return false;
            }
            th.printStackTrace();
            return false;
        }
    }

    public final void a(List<CampaignEx> list) {
        this.N = list;
    }

    public final List<CampaignEx> d() {
        return this.D;
    }

    public final void a(int i2, int i3, int i4) {
        this.z = i2;
        this.A = i3;
        this.B = i4;
    }

    public final void b(String str) {
        if (this.t != null && TextUtils.isEmpty(str)) {
            int b2 = this.t.b() * 1000;
            List<CampaignEx> list = this.N;
            if (list != null && list.size() > 0) {
                if (System.currentTimeMillis() - this.N.get(0).getTimestamp() < ((long) b2)) {
                    c("hit ltorwc");
                    return;
                }
            }
        }
        a(str, this.E);
    }

    /* compiled from: RewardMVVideoAdapter */
    public class e implements Runnable {
        private String b;

        public e(String str) {
            this.b = str;
        }

        public final void run() {
            try {
                String unused = d.this.q = u.b(d.this.j, d.this.k);
                if (!d.this.I) {
                    if (!(d.this.G == null || d.this.J == null)) {
                        d.this.J.removeCallbacks(d.this.G);
                    }
                    boolean unused2 = d.this.H = true;
                    if (d.this.J != null) {
                        Message obtainMessage = d.this.J.obtainMessage();
                        obtainMessage.obj = this.b;
                        obtainMessage.what = 1;
                        d.this.J.sendMessage(obtainMessage);
                    }
                    if (!TextUtils.isEmpty(d.this.q)) {
                        q.d("RewardMVVideoAdapter", "excludeId : " + d.this.q);
                    }
                }
            } catch (Exception e) {
                q.d("RewardMVVideoAdapter", e.getMessage());
            }
        }
    }

    /* renamed from: com.mbridge.msdk.reward.adapter.d$d  reason: collision with other inner class name */
    /* compiled from: RewardMVVideoAdapter */
    public class C0100d implements Runnable {
        private String b;

        public C0100d(String str) {
            this.b = str;
        }

        public final void run() {
            try {
                if (!d.this.H) {
                    boolean unused = d.this.I = true;
                    if (d.this.J != null) {
                        Message obtainMessage = d.this.J.obtainMessage();
                        obtainMessage.obj = this.b;
                        obtainMessage.what = 2;
                        d.this.J.sendMessage(obtainMessage);
                    }
                }
            } catch (Exception e) {
                q.d("RewardMVVideoAdapter", e.getMessage());
            }
        }
    }

    private void b(String str, boolean z2) {
        new Thread(new e(str)).start();
        if (this.J != null) {
            this.G = new C0100d(str);
            this.J.postDelayed(this.G, 90000);
            return;
        }
        a(str, z2);
    }

    static /* synthetic */ void a(d dVar, String str, List list, List list2, boolean z2) {
        com.mbridge.msdk.foundation.db.e.a((com.mbridge.msdk.foundation.db.f) com.mbridge.msdk.foundation.db.g.a(com.mbridge.msdk.foundation.controller.a.e().g())).a(str, (List<CampaignEx>) list, (List<CampaignEx>) list2, z2);
        if (list2 != null && list2.size() > 0) {
            Iterator it = list2.iterator();
            while (it.hasNext()) {
                CampaignEx campaignEx = (CampaignEx) it.next();
                if (campaignEx.getRewardTemplateMode() != null && !TextUtils.isEmpty(campaignEx.getRewardTemplateMode().e())) {
                    com.mbridge.msdk.videocommon.a.b(str + "_" + campaignEx.getId() + "_" + campaignEx.getRequestId() + "_" + campaignEx.getRewardTemplateMode().e());
                    com.mbridge.msdk.videocommon.a.b(campaignEx.getAdType(), campaignEx);
                }
            }
        }
        if (z2) {
            dVar.a(str, (List<CampaignEx>) list, (List<CampaignEx>) list2);
        }
    }

    static /* synthetic */ void a(d dVar, String str, List list, boolean z2) {
        if (!TextUtils.isEmpty(str) && list != null && list.size() > 0) {
            com.mbridge.msdk.foundation.db.e.a((com.mbridge.msdk.foundation.db.f) com.mbridge.msdk.foundation.db.g.a(com.mbridge.msdk.foundation.controller.a.e().g())).a(str, (List<CampaignEx>) list, z2);
        }
    }

    static /* synthetic */ void a(d dVar, WindVaneWebView windVaneWebView, String str, CampaignEx campaignEx, List list, String str2, String str3, com.mbridge.msdk.videocommon.d.c cVar, String str4) {
        j jVar;
        d dVar2 = dVar;
        CampaignEx campaignEx2 = campaignEx;
        List list2 = list;
        try {
            a.C0105a aVar = new a.C0105a();
            WindVaneWebView windVaneWebView2 = new WindVaneWebView(com.mbridge.msdk.foundation.controller.a.e().g());
            aVar.a(windVaneWebView2);
            if (list2 == null || list.size() <= 0) {
                jVar = new j((Activity) null, campaignEx2);
            } else {
                jVar = new j((Activity) null, campaignEx2, list2);
            }
            j jVar2 = jVar;
            jVar2.a(dVar2.v);
            jVar2.a(str3);
            jVar2.a(cVar);
            jVar2.d(dVar2.E);
            c cVar2 = r1;
            c cVar3 = new c(windVaneWebView, str3, campaignEx, list, str2, str3, cVar, dVar2.v, dVar);
            windVaneWebView2.setWebViewListener(new f(windVaneWebView, str, str3, aVar, campaignEx, dVar, cVar2, dVar2.J));
            windVaneWebView2.setObject(jVar2);
            windVaneWebView2.loadUrl(str2);
            dVar2.J.postDelayed(cVar2, DefaultRenderersFactory.DEFAULT_ALLOWED_VIDEO_JOINING_TIME_MS);
        } catch (Exception e2) {
            if (MBridgeConstans.DEBUG) {
                e2.printStackTrace();
            }
        } catch (Throwable th) {
            q.a("RewardMVVideoAdapter", th.getMessage());
        }
    }

    static /* synthetic */ void a(d dVar, String str, CampaignEx campaignEx, String str2, String str3, com.mbridge.msdk.videocommon.d.c cVar) {
        j jVar;
        d dVar2 = dVar;
        CampaignEx campaignEx2 = campaignEx;
        try {
            a.C0105a aVar = new a.C0105a();
            WindVaneWebView windVaneWebView = new WindVaneWebView(com.mbridge.msdk.foundation.controller.a.e().g());
            aVar.a(windVaneWebView);
            String b2 = com.mbridge.msdk.video.bt.a.c.a().b();
            aVar.a(b2);
            if (dVar2.C == null || dVar2.C.getAds() == null || dVar2.C.getAds().size() <= 0) {
                jVar = new j((Activity) null, campaignEx2);
            } else {
                jVar = new j((Activity) null, campaignEx2, dVar2.C.getAds());
            }
            j jVar2 = jVar;
            jVar2.a(dVar2.v);
            jVar2.a(str3);
            jVar2.c(b2);
            jVar2.a(cVar);
            jVar2.d(dVar2.E);
            b bVar = new b(str3, campaignEx, str2, str3, cVar, dVar2.v, dVar);
            windVaneWebView.setWebViewListener(new a(str, str3, aVar, campaignEx, dVar, bVar, dVar2.J));
            windVaneWebView.setObject(jVar2);
            windVaneWebView.loadUrl(str2);
            dVar2.J.postDelayed(bVar, DefaultRenderersFactory.DEFAULT_ALLOWED_VIDEO_JOINING_TIME_MS);
        } catch (Exception e2) {
            if (MBridgeConstans.DEBUG) {
                e2.printStackTrace();
            }
        } catch (Throwable th) {
            q.a("RewardMVVideoAdapter", th.getMessage());
        }
    }

    static /* synthetic */ void a(d dVar, String str, String str2) {
        try {
            if (dVar.u != null && !TextUtils.isEmpty(str2)) {
                Iterator<CampaignEx> it = dVar.u.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    CampaignEx next = it.next();
                    if (next != null) {
                        String videoUrlEncode = next.getVideoUrlEncode();
                        if (!TextUtils.isEmpty(videoUrlEncode) && str2.equals(videoUrlEncode)) {
                            dVar.u.remove(next);
                            dVar.a(next);
                            break;
                        }
                        String str3 = next.getendcard_url();
                        if (!TextUtils.isEmpty(str3) && str2.equals(str3)) {
                            dVar.u.remove(next);
                            dVar.a(next);
                            break;
                        }
                        CampaignEx.c rewardTemplateMode = next.getRewardTemplateMode();
                        if (rewardTemplateMode != null) {
                            List<CampaignEx.c.a> f2 = rewardTemplateMode.f();
                            if (f2 != null) {
                                Iterator<CampaignEx.c.a> it2 = f2.iterator();
                                while (true) {
                                    if (it2.hasNext()) {
                                        CampaignEx.c.a next2 = it2.next();
                                        if (next2 != null && next2.b != null && next2.b.contains(str2)) {
                                            dVar.u.remove(next);
                                            dVar.a(next);
                                            break;
                                        }
                                    } else {
                                        break;
                                    }
                                }
                            }
                            String e2 = rewardTemplateMode.e();
                            if (!TextUtils.isEmpty(e2) && str2.equals(e2)) {
                                dVar.u.remove(next);
                                dVar.a(next);
                                break;
                            }
                        } else {
                            continue;
                        }
                    }
                }
                if (dVar.s != null && dVar.u != null && dVar.u.size() == 0) {
                    if (dVar.J != null) {
                        dVar.J.removeMessages(5);
                    }
                    dVar.c(str);
                    dVar.s.a(str);
                }
            } else if (dVar.s != null) {
                if (dVar.J != null) {
                    dVar.J.removeMessages(5);
                }
                dVar.c(str);
                dVar.s.a(str);
            }
        } catch (Throwable th) {
            q.a("RewardMVVideoAdapter", th.getMessage(), th);
        }
    }

    static /* synthetic */ void a(d dVar, CampaignUnit campaignUnit) {
        d dVar2 = dVar;
        final CampaignUnit campaignUnit2 = campaignUnit;
        dVar2.C = campaignUnit2;
        dVar2.D = dVar.a(campaignUnit);
        try {
            CampaignEx campaignEx = campaignUnit.getAds().get(0);
            Context context = dVar2.j;
            StringBuilder sb = new StringBuilder();
            sb.append("start download resource tpl ");
            sb.append(!TextUtils.isEmpty(campaignUnit.getAds().get(0).getCMPTEntryUrl()));
            com.mbridge.msdk.reward.b.a.a(campaignEx, context, sb.toString(), dVar2.k, dVar2.x, "", "", System.currentTimeMillis() - dVar2.K);
        } catch (Exception unused) {
        }
        List<CampaignEx> list = dVar2.D;
        new Thread(new Runnable() {
            public final void run() {
                com.mbridge.msdk.foundation.db.j.a((com.mbridge.msdk.foundation.db.f) com.mbridge.msdk.foundation.db.g.a(d.this.j)).b();
                CampaignUnit campaignUnit = campaignUnit2;
                if (campaignUnit != null && campaignUnit.getAds() != null && campaignUnit2.getAds().size() > 0) {
                    d.a(d.this, (List) campaignUnit2.getAds());
                }
            }
        }).start();
        List<CampaignEx> list2 = dVar2.D;
        if (list2 == null || list2.size() <= 0) {
            q.b("RewardMVVideoAdapter", "onload load fail, callback campaign have not video");
            if (TextUtils.isEmpty(dVar2.L)) {
                dVar2.L = "APP ALREADY INSTALLED";
            }
            dVar2.c(dVar2.L);
            return;
        }
        q.b("RewardMVVideoAdapter", "onload load success size:" + dVar2.D.size());
        Handler handler = dVar2.J;
        if (handler != null) {
            handler.sendEmptyMessage(3);
        }
        if (campaignUnit2 != null) {
            String sessionId = campaignUnit.getSessionId();
            if (x.b(sessionId)) {
                com.mbridge.msdk.reward.a.a.a = sessionId;
            }
        }
        List<CampaignEx> list3 = dVar2.D;
        if (list3 != null) {
            try {
                if (list3.size() > 0) {
                    dVar2.m += list3.size();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        if (dVar2.t == null || dVar2.m > dVar2.t.t()) {
            dVar2.m = 0;
        }
        if (x.b(dVar2.k)) {
            com.mbridge.msdk.reward.a.a.a(dVar2.k, dVar2.m);
        }
        List<CampaignEx> list4 = dVar2.D;
        if (list4 != null && list4.size() > 0) {
            String str = dVar2.l;
            String str2 = dVar2.k;
            List<CampaignEx> list5 = dVar2.D;
            if (com.mbridge.msdk.videocommon.a.a.a() != null) {
                com.mbridge.msdk.videocommon.a.a.a().a(str, str2, list5);
            }
        }
        final CampaignEx campaignEx2 = dVar2.D.get(0);
        final boolean z2 = !TextUtils.isEmpty(campaignEx2.getCMPTEntryUrl());
        final int nscpt = campaignEx2.getNscpt();
        dVar2.e = false;
        dVar2.f = false;
        synchronized (dVar2.c) {
            if (dVar2.g) {
                dVar2.g = false;
            }
        }
        dVar2.i = false;
        dVar2.h = false;
        if (dVar2.x && campaignEx2 != null) {
            com.mbridge.msdk.foundation.db.b.a(com.mbridge.msdk.foundation.controller.a.e().g()).a(campaignEx2.getBidToken(), campaignEx2.getCampaignUnitId(), campaignEx2.getEncryptPrice());
        }
        c.m.a.a(dVar2.j, z2, nscpt, dVar2.x, dVar2.w ? 287 : 94, dVar2.l, dVar2.k, campaignEx2.getRequestId(), dVar2.D, new c.C0099c() {
            public final void a(String str, String str2, String str3, List<CampaignEx> list) {
                final String str4 = str2;
                final List<CampaignEx> list2 = list;
                d.this.e = true;
                if (list2 != null && list.size() > 0) {
                    try {
                        Context h = d.this.j;
                        com.mbridge.msdk.reward.b.a.a(list2.get(0), h, "resource download success is tpl :" + z2, d.this.k, d.this.x, str3, campaignEx2.getRequestIdNotice(), System.currentTimeMillis() - d.this.K);
                    } catch (Exception unused) {
                    }
                }
                if (!z2) {
                    for (final CampaignEx next : list) {
                        if (next == null || next.getRewardTemplateMode() == null || TextUtils.isEmpty(next.getRewardTemplateMode().e()) || next.getRewardTemplateMode().e().contains(CampaignEx.KEY_IS_CMPT_ENTRY) || d.this.J == null) {
                            d dVar = d.this;
                            if (dVar.a((List<CampaignEx>) dVar.D, z2, nscpt)) {
                                d dVar2 = d.this;
                                d.a(dVar2, dVar2.k, (List) list2, d.this.N, d.this.x);
                                if (d.this.J != null) {
                                    d.this.J.removeMessages(5);
                                }
                                if (d.this.s != null && !d.this.h) {
                                    d dVar3 = d.this;
                                    dVar3.h = true;
                                    if (!TextUtils.isEmpty(dVar3.k)) {
                                        com.mbridge.msdk.reward.b.a.a(d.this.j, d.this.D, d.this.k, System.currentTimeMillis() - d.this.K);
                                    }
                                    d.this.s.a();
                                }
                            } else {
                                d dVar4 = d.this;
                                d.a(dVar4, str4, dVar4.M, d.this.x);
                                if (d.this.J != null) {
                                    d.this.J.removeMessages(5);
                                }
                                if (d.this.s != null && !d.this.i) {
                                    d dVar5 = d.this;
                                    dVar5.i = true;
                                    if (!TextUtils.isEmpty(dVar5.k) && d.this.D != null && d.this.D.size() > 0) {
                                        com.mbridge.msdk.reward.b.a.a((CampaignEx) d.this.D.get(0), d.this.j, "have no temp but isReady false", d.this.k, d.this.x, str3, campaignEx2.getRequestIdNotice());
                                    }
                                    d.this.s.a("errorCode: 3503 errorMessage: have no temp but isReady false");
                                }
                            }
                        } else {
                            final String str5 = str;
                            final String str6 = str2;
                            final String str7 = str3;
                            final List<CampaignEx> list3 = list;
                            d.this.J.post(new Runnable() {
                                public final void run() {
                                    c a2 = c.m.a;
                                    boolean l = d.this.E;
                                    Handler i = d.this.J;
                                    boolean m = d.this.w;
                                    boolean f2 = d.this.x;
                                    String e2 = next.getRewardTemplateMode().e();
                                    int o = d.this.v;
                                    CampaignEx campaignEx = campaignEx2;
                                    List c2 = d.this.D;
                                    String b2 = com.mbridge.msdk.videocommon.download.g.a().b(next.getRewardTemplateMode().e());
                                    String str = str5;
                                    String str2 = str6;
                                    String str3 = str7;
                                    String requestIdNotice = next.getRequestIdNotice();
                                    com.mbridge.msdk.videocommon.d.c p = d.this.t;
                                    AnonymousClass1 r17 = r6;
                                    AnonymousClass1 r6 = new c.j() {
                                        public final void a(String str, String str2, String str3, String str4, String str5, a.C0105a aVar) {
                                            try {
                                                Context h = d.this.j;
                                                com.mbridge.msdk.reward.b.a.a((CampaignEx) list3.get(0), h, "preload template success is tpl :" + z2, d.this.k, d.this.x, str7, campaignEx2.getRequestIdNotice(), System.currentTimeMillis() - d.this.K);
                                            } catch (Exception unused) {
                                            }
                                            if (d.this.a((List<CampaignEx>) d.this.D, z2, nscpt)) {
                                                d.a(d.this, d.this.k, list3, d.this.N, d.this.x);
                                                if (d.this.J != null) {
                                                    d.this.J.removeMessages(5);
                                                }
                                                if (d.this.s != null && !d.this.h) {
                                                    d.this.h = true;
                                                    if (!TextUtils.isEmpty(d.this.k)) {
                                                        com.mbridge.msdk.reward.b.a.a(d.this.j, d.this.D, d.this.k, System.currentTimeMillis() - d.this.K);
                                                    }
                                                    d.this.s.a();
                                                    return;
                                                }
                                                return;
                                            }
                                            d.a(d.this, str3, d.this.M, d.this.x);
                                            if (d.this.J != null) {
                                                d.this.J.removeMessages(5);
                                            }
                                            if (d.this.s != null && !d.this.i) {
                                                d.this.i = true;
                                                if (!TextUtils.isEmpty(d.this.k) && d.this.D != null && d.this.D.size() > 0) {
                                                    com.mbridge.msdk.reward.b.a.a((CampaignEx) d.this.D.get(0), d.this.j, "temp preload success but isReady false", d.this.k, d.this.x, str4, campaignEx2.getRequestIdNotice());
                                                }
                                                d.this.s.a("errorCode: 3502 errorMessage: temp preload success but isReady false");
                                            }
                                        }

                                        public final void a(String str, String str2, String str3, String str4, String str5, a.C0105a aVar, String str6) {
                                            String str7 = str6;
                                            try {
                                                Context h = d.this.j;
                                                com.mbridge.msdk.reward.b.a.a((CampaignEx) list3.get(0), h, "preload template failed is tpl :" + z2 + " " + str7, d.this.k, d.this.x, str7, campaignEx2.getRequestIdNotice(), System.currentTimeMillis() - d.this.K);
                                            } catch (Exception unused) {
                                            }
                                            if (campaignEx2.getRsIgnoreCheckRule() == null || campaignEx2.getRsIgnoreCheckRule().size() <= 0 || !campaignEx2.getRsIgnoreCheckRule().contains(1)) {
                                                d.a(d.this, str3, d.this.M, d.this.x);
                                                if (d.this.J != null) {
                                                    d.this.J.removeMessages(5);
                                                }
                                                if (d.this.s != null && !d.this.i) {
                                                    d.this.i = true;
                                                    if (!TextUtils.isEmpty(d.this.k) && d.this.M != null && d.this.M.size() > 0) {
                                                        Context h2 = d.this.j;
                                                        com.mbridge.msdk.reward.b.a.a((CampaignEx) d.this.M.get(0), h2, "temp preload failed: " + str7, d.this.k, d.this.x, str4, campaignEx2.getRequestIdNotice());
                                                    }
                                                    b a2 = d.this.s;
                                                    a2.a("errorCode: 3301 errorMessage: temp preload failed: " + str7);
                                                    return;
                                                }
                                                return;
                                            }
                                            q.b("RewardMVVideoAdapter", "template download fail but hit ignoreCheckRule");
                                        }
                                    };
                                    a2.a(l, i, m, f2, (WindVaneWebView) null, e2, o, campaignEx, c2, b2, str, str2, str3, requestIdNotice, p, r17);
                                }
                            });
                        }
                    }
                } else if (d.this.f && !d.this.g && d.this.J != null) {
                    synchronized (d.this.c) {
                        if (!d.this.g) {
                            d.this.g = true;
                            final String str8 = str3;
                            d.this.J.post(new Runnable() {
                                public final void run() {
                                    c a2 = c.m.a;
                                    boolean l = d.this.E;
                                    Handler i = d.this.J;
                                    boolean m = d.this.w;
                                    boolean f = d.this.x;
                                    String str = str8;
                                    String requestIdNotice = campaignEx2.getRequestIdNotice();
                                    String q = d.this.l;
                                    String str2 = str4;
                                    String cMPTEntryUrl = campaignEx2.getCMPTEntryUrl();
                                    int o = d.this.v;
                                    CampaignEx campaignEx = campaignEx2;
                                    List c2 = d.this.D;
                                    String b2 = com.mbridge.msdk.videocommon.download.g.a().b(campaignEx2.getCMPTEntryUrl());
                                    String str3 = str4;
                                    c cVar = a2;
                                    com.mbridge.msdk.videocommon.d.c p = d.this.t;
                                    AnonymousClass1 r17 = r1;
                                    AnonymousClass1 r1 = new c.j() {
                                        public final void a(String str, String str2, String str3, String str4, String str5, a.C0105a aVar) {
                                            try {
                                                Context h = d.this.j;
                                                com.mbridge.msdk.reward.b.a.a((CampaignEx) list2.get(0), h, "preload template success is tpl :" + z2, d.this.k, d.this.x, str8, campaignEx2.getRequestIdNotice(), System.currentTimeMillis() - d.this.K);
                                            } catch (Exception unused) {
                                            }
                                            if (d.this.a((List<CampaignEx>) d.this.D, z2, nscpt)) {
                                                d.a(d.this, d.this.k, list2, d.this.N, d.this.x);
                                                if (d.this.J != null) {
                                                    d.this.J.removeMessages(5);
                                                }
                                                if (d.this.s != null && !d.this.h) {
                                                    d.this.h = true;
                                                    if (!TextUtils.isEmpty(d.this.k)) {
                                                        com.mbridge.msdk.reward.b.a.a(d.this.j, d.this.D, d.this.k, System.currentTimeMillis() - d.this.K);
                                                    }
                                                    d.this.s.a();
                                                    return;
                                                }
                                                return;
                                            }
                                            d.a(d.this, str3, d.this.M, d.this.x);
                                            if (d.this.J != null) {
                                                d.this.J.removeMessages(5);
                                            }
                                            if (d.this.s != null && !d.this.i) {
                                                d.this.i = true;
                                                if (!TextUtils.isEmpty(d.this.k) && d.this.M != null && d.this.M.size() > 0) {
                                                    com.mbridge.msdk.reward.b.a.a((CampaignEx) d.this.M.get(0), d.this.j, "tpl temp preload success but isReady false", d.this.k, d.this.x, str4, campaignEx2.getRequestIdNotice());
                                                }
                                                d.this.s.a("errorCode: 3505 errorMessage: tpl temp preload success but isReady false");
                                            }
                                        }

                                        public final void a(String str, String str2, String str3, String str4, String str5, a.C0105a aVar, String str6) {
                                            String str7 = str6;
                                            try {
                                                Context h = d.this.j;
                                                com.mbridge.msdk.reward.b.a.a((CampaignEx) list2.get(0), h, "preload template failed is tpl :" + z2 + " " + str7, d.this.k, d.this.x, str8, campaignEx2.getRequestIdNotice(), System.currentTimeMillis() - d.this.K);
                                            } catch (Exception unused) {
                                            }
                                            if (campaignEx2.getRsIgnoreCheckRule() == null || campaignEx2.getRsIgnoreCheckRule().size() <= 0 || !campaignEx2.getRsIgnoreCheckRule().contains(3)) {
                                                d.a(d.this, str3, d.this.M, d.this.x);
                                                if (d.this.J != null) {
                                                    d.this.J.removeMessages(5);
                                                }
                                                if (d.this.s != null && !d.this.i) {
                                                    d.this.i = true;
                                                    if (d.this.M != null && d.this.M.size() > 0) {
                                                        Context h2 = d.this.j;
                                                        com.mbridge.msdk.reward.b.a.a((CampaignEx) d.this.M.get(0), h2, "tpl temp preload failed: " + str7, d.this.k, d.this.x, str4, campaignEx2.getRequestIdNotice());
                                                    }
                                                    b a2 = d.this.s;
                                                    a2.a("errorCode: 3303 errorMessage: tpl temp preload failed: " + str7);
                                                    return;
                                                }
                                                return;
                                            }
                                            q.b("RewardMVVideoAdapter", "template download fail but hit ignoreCheckRule");
                                        }
                                    };
                                    cVar.a(l, i, m, f, str, requestIdNotice, q, str2, cMPTEntryUrl, o, campaignEx, c2, b2, str3, p, r17, false);
                                }
                            });
                        }
                    }
                }
            }

            /* JADX WARNING: Removed duplicated region for block: B:16:0x0071  */
            /* JADX WARNING: Removed duplicated region for block: B:19:? A[RETURN, SYNTHETIC] */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final void a(java.lang.String r17, java.lang.String r18, java.lang.String r19, java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx> r20, java.lang.String r21) {
                /*
                    r16 = this;
                    r6 = r16
                    r3 = r20
                    com.mbridge.msdk.reward.adapter.d r0 = com.mbridge.msdk.reward.adapter.d.this
                    r1 = 0
                    r0.e = r1
                    if (r3 == 0) goto L_0x005f
                    int r0 = r20.size()
                    if (r0 <= 0) goto L_0x005f
                    java.lang.Object r0 = r3.get(r1)     // Catch:{ Exception -> 0x005f }
                    r7 = r0
                    com.mbridge.msdk.foundation.entity.CampaignEx r7 = (com.mbridge.msdk.foundation.entity.CampaignEx) r7     // Catch:{ Exception -> 0x005f }
                    com.mbridge.msdk.reward.adapter.d r0 = com.mbridge.msdk.reward.adapter.d.this     // Catch:{ Exception -> 0x005f }
                    android.content.Context r8 = r0.j     // Catch:{ Exception -> 0x005f }
                    java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x005f }
                    r0.<init>()     // Catch:{ Exception -> 0x005f }
                    java.lang.String r1 = "resource download failed: "
                    r0.append(r1)     // Catch:{ Exception -> 0x005f }
                    r4 = r21
                    r0.append(r4)     // Catch:{ Exception -> 0x0061 }
                    java.lang.String r1 = " is tpl: "
                    r0.append(r1)     // Catch:{ Exception -> 0x0061 }
                    boolean r1 = r0     // Catch:{ Exception -> 0x0061 }
                    r0.append(r1)     // Catch:{ Exception -> 0x0061 }
                    java.lang.String r9 = r0.toString()     // Catch:{ Exception -> 0x0061 }
                    com.mbridge.msdk.reward.adapter.d r0 = com.mbridge.msdk.reward.adapter.d.this     // Catch:{ Exception -> 0x0061 }
                    java.lang.String r10 = r0.k     // Catch:{ Exception -> 0x0061 }
                    com.mbridge.msdk.reward.adapter.d r0 = com.mbridge.msdk.reward.adapter.d.this     // Catch:{ Exception -> 0x0061 }
                    boolean r11 = r0.x     // Catch:{ Exception -> 0x0061 }
                    com.mbridge.msdk.foundation.entity.CampaignEx r0 = r6     // Catch:{ Exception -> 0x0061 }
                    java.lang.String r13 = r0.getRequestIdNotice()     // Catch:{ Exception -> 0x0061 }
                    long r0 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x0061 }
                    com.mbridge.msdk.reward.adapter.d r2 = com.mbridge.msdk.reward.adapter.d.this     // Catch:{ Exception -> 0x0061 }
                    long r14 = r2.K     // Catch:{ Exception -> 0x0061 }
                    long r14 = r0 - r14
                    r12 = r19
                    com.mbridge.msdk.reward.b.a.a(r7, r8, r9, r10, r11, r12, r13, r14)     // Catch:{ Exception -> 0x0061 }
                    goto L_0x0061
                L_0x005f:
                    r4 = r21
                L_0x0061:
                    com.mbridge.msdk.reward.adapter.d r0 = com.mbridge.msdk.reward.adapter.d.this
                    com.mbridge.msdk.reward.adapter.b r0 = r0.s
                    if (r0 == 0) goto L_0x008a
                    com.mbridge.msdk.reward.adapter.d r0 = com.mbridge.msdk.reward.adapter.d.this
                    android.os.Handler r0 = r0.J
                    if (r0 == 0) goto L_0x008a
                    com.mbridge.msdk.reward.adapter.d r0 = com.mbridge.msdk.reward.adapter.d.this
                    android.os.Handler r7 = r0.J
                    com.mbridge.msdk.reward.adapter.d$3$3 r8 = new com.mbridge.msdk.reward.adapter.d$3$3
                    r0 = r8
                    r1 = r16
                    r2 = r18
                    r3 = r20
                    r4 = r21
                    r5 = r19
                    r0.<init>(r2, r3, r4, r5)
                    r7.post(r8)
                L_0x008a:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.reward.adapter.d.AnonymousClass3.a(java.lang.String, java.lang.String, java.lang.String, java.util.List, java.lang.String):void");
            }
        }, new c.i() {
            public final void a(String str, String str2, String str3, String str4) {
            }

            public final void a(String str, final String str2, final String str3, String str4, final String str5) {
                if (z2 || d.this.s == null || d.this.J == null) {
                    if (nscpt == 1) {
                        if (campaignEx2.getRsIgnoreCheckRule() != null && campaignEx2.getRsIgnoreCheckRule().size() > 0) {
                            if (campaignEx2.getRsIgnoreCheckRule().contains(3)) {
                                q.b("RewardMVVideoAdapter", "tpl download fail but hit ignoreCheckRule");
                                return;
                            } else if (campaignEx2.getCMPTEntryUrl().equals(campaignEx2.getendcard_url()) && campaignEx2.getRsIgnoreCheckRule().contains(2)) {
                                q.b("RewardMVVideoAdapter", "endcard download fail but hit ignoreCheckRule at 3203");
                                return;
                            }
                        }
                        if (d.this.s != null && d.this.J != null) {
                            d.this.J.post(new Runnable() {
                                public final void run() {
                                    d.a(d.this, str2, d.this.M, d.this.x);
                                    if (d.this.J != null) {
                                        d.this.J.removeMessages(5);
                                    }
                                    if (!d.this.i && d.this.s != null) {
                                        d.this.i = true;
                                        if (d.this.M != null && d.this.M.size() > 0) {
                                            com.mbridge.msdk.reward.b.a.a((CampaignEx) d.this.M.get(0), d.this.j, "tpl temp resource download failed", d.this.k, d.this.x, str3, campaignEx2.getRequestIdNotice());
                                        }
                                        d.this.s.a("errorCode: 3203 errorMessage: tpl temp resource download failed");
                                    }
                                }
                            });
                        }
                    }
                } else if (campaignEx2.getRsIgnoreCheckRule() == null || campaignEx2.getRsIgnoreCheckRule().size() <= 0 || !campaignEx2.getRsIgnoreCheckRule().contains(1)) {
                    d.this.J.post(new Runnable() {
                        public final void run() {
                            d.a(d.this, str2, d.this.M, d.this.x);
                            if (d.this.J != null) {
                                d.this.J.removeMessages(5);
                            }
                            if (!d.this.i && d.this.s != null) {
                                d.this.i = true;
                                if (d.this.M != null && d.this.M.size() > 0) {
                                    Context h = d.this.j;
                                    com.mbridge.msdk.reward.b.a.a((CampaignEx) d.this.M.get(0), h, "" + str5, d.this.k, d.this.x, str3, campaignEx2.getRequestIdNotice());
                                }
                                d.this.s.a("errorCode: 3202 errorMessage: temp resource download failed");
                            }
                        }
                    });
                } else {
                    q.b("RewardMVVideoAdapter", "template download fail but hit ignoreCheckRule");
                }
            }
        });
        if (z2) {
            c.m.a.a(dVar2.j, campaignEx2, dVar2.l, dVar2.k, campaignEx2.getRequestId(), new c.i() {
                public final void a(final String str, final String str2, final String str3, String str4) {
                    try {
                        CampaignEx campaignEx = campaignEx2;
                        Context h = d.this.j;
                        com.mbridge.msdk.reward.b.a.a(campaignEx, h, "resource download success is tpl :" + z2, d.this.k, d.this.x, str3, campaignEx2.getRequestIdNotice(), System.currentTimeMillis() - d.this.K);
                    } catch (Exception unused) {
                    }
                    d dVar = d.this;
                    dVar.f = true;
                    if (dVar.e && !d.this.g && d.this.J != null) {
                        synchronized (d.this.c) {
                            if (!d.this.g) {
                                d.this.g = true;
                                d.this.J.post(new Runnable() {
                                    public final void run() {
                                        c a2 = c.m.a;
                                        boolean l = d.this.E;
                                        Handler i = d.this.J;
                                        boolean m = d.this.w;
                                        boolean f = d.this.x;
                                        String str = str3;
                                        String requestIdNotice = campaignEx2.getRequestIdNotice();
                                        String str2 = str;
                                        String str3 = str2;
                                        String cMPTEntryUrl = campaignEx2.getCMPTEntryUrl();
                                        int o = d.this.v;
                                        CampaignEx campaignEx = campaignEx2;
                                        List c2 = d.this.D;
                                        String b2 = com.mbridge.msdk.videocommon.download.g.a().b(campaignEx2.getCMPTEntryUrl());
                                        String str4 = str2;
                                        c cVar = a2;
                                        com.mbridge.msdk.videocommon.d.c p = d.this.t;
                                        AnonymousClass1 r17 = r1;
                                        AnonymousClass1 r1 = new c.j() {
                                            public final void a(String str, String str2, String str3, String str4, String str5, a.C0105a aVar) {
                                                try {
                                                    CampaignEx campaignEx = campaignEx2;
                                                    Context h = d.this.j;
                                                    com.mbridge.msdk.reward.b.a.a(campaignEx, h, "preload template success is tpl :" + z2, d.this.k, d.this.x, str3, campaignEx2.getRequestIdNotice(), System.currentTimeMillis() - d.this.K);
                                                } catch (Exception unused) {
                                                }
                                                if (d.this.a((List<CampaignEx>) d.this.D, z2, nscpt)) {
                                                    d.a(d.this, d.this.k, d.this.M, d.this.N, d.this.x);
                                                    if (d.this.J != null) {
                                                        d.this.J.removeMessages(5);
                                                    }
                                                    if (d.this.s != null && !d.this.h) {
                                                        d.this.h = true;
                                                        if (!TextUtils.isEmpty(d.this.k)) {
                                                            com.mbridge.msdk.reward.b.a.a(d.this.j, d.this.D, d.this.k, System.currentTimeMillis() - d.this.K);
                                                        }
                                                        d.this.s.a();
                                                        return;
                                                    }
                                                    return;
                                                }
                                                d.a(d.this, str3, d.this.M, d.this.x);
                                                if (d.this.J != null) {
                                                    d.this.J.removeMessages(5);
                                                }
                                                if (d.this.s != null && !d.this.i) {
                                                    d.this.i = true;
                                                    if (d.this.M != null && d.this.M.size() > 0) {
                                                        com.mbridge.msdk.reward.b.a.a((CampaignEx) d.this.M.get(0), d.this.j, "tpl temp preload success but isReady false", d.this.k, d.this.x, str4, campaignEx2.getRequestIdNotice());
                                                    }
                                                    d.this.s.a("errorCode: 3505 errorMessage: tpl temp preload success but isReady false");
                                                }
                                            }

                                            public final void a(String str, String str2, String str3, String str4, String str5, a.C0105a aVar, String str6) {
                                                String str7 = str6;
                                                d.a(d.this, str3, d.this.M, d.this.x);
                                                try {
                                                    CampaignEx campaignEx = campaignEx2;
                                                    Context h = d.this.j;
                                                    com.mbridge.msdk.reward.b.a.a(campaignEx, h, "preload template failed is tpl :" + z2 + " " + str7, d.this.k, d.this.x, str3, campaignEx2.getRequestIdNotice(), System.currentTimeMillis() - d.this.K);
                                                } catch (Exception unused) {
                                                }
                                                if (d.this.J != null) {
                                                    d.this.J.removeMessages(5);
                                                }
                                                if (d.this.s != null && !d.this.i) {
                                                    d.this.i = true;
                                                    if (d.this.M != null && d.this.M.size() > 0) {
                                                        Context h2 = d.this.j;
                                                        com.mbridge.msdk.reward.b.a.a((CampaignEx) d.this.M.get(0), h2, "tpl temp preload failed: " + str7, d.this.k, d.this.x, str4, campaignEx2.getRequestIdNotice());
                                                    }
                                                    b a2 = d.this.s;
                                                    a2.a("errorCode: 3303 errorMessage: tpl temp preload failed: " + str7);
                                                }
                                            }
                                        };
                                        cVar.a(l, i, m, f, str, requestIdNotice, str2, str3, cMPTEntryUrl, o, campaignEx, c2, b2, str4, p, r17, false);
                                    }
                                });
                            }
                        }
                    }
                }

                public final void a(String str, String str2, String str3, String str4, String str5) {
                    String str6 = str5;
                    if (d.this.M.get(0) != null && d.this.M.size() > 0) {
                        try {
                            Context h = d.this.j;
                            com.mbridge.msdk.reward.b.a.a((CampaignEx) d.this.M.get(0), h, "resource download failed: " + str6 + " is tpl: " + z2, d.this.k, d.this.x, str3, ((CampaignEx) d.this.M.get(0)).getRequestIdNotice(), System.currentTimeMillis() - d.this.K);
                        } catch (Exception unused) {
                        }
                    }
                    if (campaignEx2.getRsIgnoreCheckRule() != null && campaignEx2.getRsIgnoreCheckRule().size() > 0) {
                        if (campaignEx2.getRsIgnoreCheckRule().contains(3)) {
                            q.b("RewardMVVideoAdapter", "tpl download fail but hit ignoreCheckRule");
                            return;
                        } else if (campaignEx2.getCMPTEntryUrl().equals(campaignEx2.getendcard_url()) && campaignEx2.getRsIgnoreCheckRule().contains(2)) {
                            q.b("RewardMVVideoAdapter", "endcard download fail but hit ignoreCheckRule at 3203");
                            return;
                        }
                    }
                    d dVar = d.this;
                    dVar.f = false;
                    d.a(dVar, str2, dVar.M, d.this.x);
                    if (d.this.J != null) {
                        d.this.J.removeMessages(5);
                    }
                    if (d.this.s != null && !d.this.i) {
                        d dVar2 = d.this;
                        dVar2.i = true;
                        if (dVar2.M != null && d.this.M.size() > 0) {
                            Context h2 = d.this.j;
                            com.mbridge.msdk.reward.b.a.a((CampaignEx) d.this.M.get(0), h2, "" + str6, d.this.k, d.this.x, str3, campaignEx2.getRequestIdNotice());
                        }
                        d.this.s.a("errorCode: 3203 errorMessage: tpl temp resource download failed");
                    }
                }
            });
        }
    }

    static /* synthetic */ void a(d dVar, List list) {
        if (dVar.j != null && list != null && list.size() != 0) {
            com.mbridge.msdk.foundation.db.j a2 = com.mbridge.msdk.foundation.db.j.a((com.mbridge.msdk.foundation.db.f) com.mbridge.msdk.foundation.db.g.a(dVar.j));
            for (int i2 = 0; i2 < list.size(); i2++) {
                CampaignEx campaignEx = (CampaignEx) list.get(i2);
                if (!(campaignEx == null || a2 == null || a2.a(campaignEx.getId()))) {
                    com.mbridge.msdk.foundation.entity.f fVar = new com.mbridge.msdk.foundation.entity.f();
                    fVar.a(campaignEx.getId());
                    fVar.a(campaignEx.getFca());
                    fVar.b(campaignEx.getFcb());
                    fVar.d(0);
                    fVar.c(0);
                    fVar.a(System.currentTimeMillis());
                    a2.a(fVar);
                }
            }
        }
    }
}
