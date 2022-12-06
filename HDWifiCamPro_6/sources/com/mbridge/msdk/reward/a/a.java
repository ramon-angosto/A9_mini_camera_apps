package com.mbridge.msdk.reward.a;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import androidx.vectordrawable.graphics.drawable.PathInterpolatorCompat;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.db.f;
import com.mbridge.msdk.foundation.db.g;
import com.mbridge.msdk.foundation.db.i;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.e;
import com.mbridge.msdk.foundation.tools.o;
import com.mbridge.msdk.foundation.tools.q;
import com.mbridge.msdk.foundation.tools.w;
import com.mbridge.msdk.foundation.tools.x;
import com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView;
import com.mbridge.msdk.out.MBridgeIds;
import com.mbridge.msdk.out.RewardInfo;
import com.mbridge.msdk.reward.adapter.c;
import com.mbridge.msdk.video.bt.module.b.h;
import com.mbridge.msdk.videocommon.a;
import com.mbridge.msdk.videocommon.download.j;
import com.mbridge.msdk.videocommon.listener.InterVideoOutListener;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

/* compiled from: RewardVideoController */
public class a {
    private static Map<String, Integer> K = new HashMap();
    private static ConcurrentHashMap<String, String> L = new ConcurrentHashMap<>();
    public static String a;
    public static Map<String, d> b = new HashMap();
    /* access modifiers changed from: private */
    public boolean A = false;
    /* access modifiers changed from: private */
    public boolean B = false;
    private boolean C = false;
    private boolean D = false;
    /* access modifiers changed from: private */
    public boolean E;
    /* access modifiers changed from: private */
    public boolean F = false;
    /* access modifiers changed from: private */
    public ArrayList<Integer> G = new ArrayList<>(7);
    /* access modifiers changed from: private */
    public boolean H = false;
    private final Object I = new Object();
    /* access modifiers changed from: private */
    public boolean J = false;
    private Queue<Integer> M;
    private String N;
    private g O = null;
    private volatile boolean P = true;
    private volatile boolean Q = false;
    /* access modifiers changed from: private */
    public volatile boolean R = false;
    /* access modifiers changed from: private */
    public volatile boolean S = false;
    /* access modifiers changed from: private */
    public volatile boolean T = false;
    /* access modifiers changed from: private */
    public volatile boolean U = false;
    /* access modifiers changed from: private */
    public volatile boolean V = false;
    /* access modifiers changed from: private */
    public List<CampaignEx> W;
    /* access modifiers changed from: private */
    public List<CampaignEx> X;
    volatile boolean c = false;
    volatile boolean d = false;
    volatile boolean e = false;
    volatile boolean f = false;
    volatile boolean g = false;
    /* access modifiers changed from: private */
    public Context h;
    private int i;
    /* access modifiers changed from: private */
    public com.mbridge.msdk.reward.adapter.d j;
    /* access modifiers changed from: private */
    public com.mbridge.msdk.videocommon.d.c k;
    private com.mbridge.msdk.videocommon.d.a l;
    /* access modifiers changed from: private */
    public volatile InterVideoOutListener m;
    /* access modifiers changed from: private */
    public volatile c n;
    private String o;
    /* access modifiers changed from: private */
    public String p;
    /* access modifiers changed from: private */
    public MBridgeIds q;
    private String r;
    /* access modifiers changed from: private */
    public volatile String s;
    /* access modifiers changed from: private */
    public String t;
    private int u = 0;
    /* access modifiers changed from: private */
    public Handler v = new Handler(Looper.getMainLooper()) {
        public final void handleMessage(Message message) {
            Message message2 = message;
            switch (message2.what) {
                case 8:
                    if (a.this.W != null && a.this.W.size() > 0) {
                        boolean z = (a.this.X == null || a.this.X.size() <= 0) ? false : !TextUtils.isEmpty(((CampaignEx) a.this.X.get(0)).getCMPTEntryUrl());
                        int nscpt = ((CampaignEx) a.this.W.get(0)).getNscpt();
                        if (a.this.j == null || !a.this.j.a((List<CampaignEx>) a.this.W, z, nscpt)) {
                            if (a.this.n != null && a.this.E) {
                                com.mbridge.msdk.videocommon.a.a();
                                com.mbridge.msdk.videocommon.a.b();
                                c.a(a.this.n, "load timeout");
                                return;
                            }
                            return;
                        } else if (a.this.n != null && a.this.E) {
                            c.a(a.this.n, a.this.s, a.this.p);
                            return;
                        } else {
                            return;
                        }
                    } else {
                        return;
                    }
                case 9:
                    if (a.this.m != null && a.this.E) {
                        Object obj = message2.obj;
                        if (obj instanceof String) {
                            obj.toString();
                        }
                        Bundle data = message.getData();
                        if (data != null && data.containsKey(MBridgeConstans.PLACEMENT_ID)) {
                            boolean isEmpty = TextUtils.isEmpty(data.getString(MBridgeConstans.PLACEMENT_ID));
                        }
                        try {
                            if (a.this.B) {
                                a.j(a.this);
                            }
                            a.this.m.onVideoLoadSuccess(a.this.q);
                            return;
                        } catch (Exception e) {
                            if (MBridgeConstans.DEBUG) {
                                e.printStackTrace();
                                return;
                            }
                            return;
                        }
                    } else {
                        return;
                    }
                case 16:
                case 18:
                    if (a.this.m != null && a.this.E) {
                        Object obj2 = message2.obj;
                        String obj3 = obj2 instanceof String ? obj2.toString() : "";
                        com.mbridge.msdk.videocommon.a.a();
                        com.mbridge.msdk.videocommon.a.b();
                        try {
                            if (a.this.B) {
                                a.j(a.this);
                            }
                            a.this.m.onVideoLoadFail(a.this.q, obj3);
                            return;
                        } catch (Exception e2) {
                            if (MBridgeConstans.DEBUG) {
                                e2.printStackTrace();
                                return;
                            }
                            return;
                        }
                    } else {
                        return;
                    }
                case 17:
                    if (a.this.m != null && a.this.E) {
                        Object obj4 = message2.obj;
                        if (obj4 instanceof String) {
                            obj4.toString();
                        }
                        Bundle data2 = message.getData();
                        if (data2 != null && data2.containsKey(MBridgeConstans.PLACEMENT_ID)) {
                            boolean isEmpty2 = TextUtils.isEmpty(data2.getString(MBridgeConstans.PLACEMENT_ID));
                        }
                        try {
                            if (a.this.B) {
                                a.j(a.this);
                            }
                            a.this.m.onLoadSuccess(a.this.q);
                            return;
                        } catch (Exception e3) {
                            if (MBridgeConstans.DEBUG) {
                                e3.printStackTrace();
                                return;
                            }
                            return;
                        }
                    } else {
                        return;
                    }
                case 1001001:
                    a.this.d(false);
                    return;
                case 1001002:
                    int E = a.this.k != null ? a.this.k.E() : 0;
                    if (a.this.j != null) {
                        if (a.this.j.b()) {
                            if (a.this.n != null) {
                                q.a("RewardVideoController", "load timeout task called for onVideoLoadSuccess by isReady exception");
                                try {
                                    List<CampaignEx> d = a.this.j.d();
                                    if (d != null && d.size() > 0) {
                                        Context g = com.mbridge.msdk.foundation.controller.a.e().g();
                                        com.mbridge.msdk.reward.b.a.a(d.get(0), g, "load timeout task called onVideoLoadSuccess after " + E + "s exception", a.this.p, a.this.B, "", "", (long) E);
                                        com.mbridge.msdk.reward.b.a.a(a.this.h, d, a.this.p, 0);
                                    }
                                } catch (Throwable th) {
                                    q.d("RewardVideoController", th.getMessage());
                                }
                                c.b(a.this.n, a.this.s, a.this.p);
                                return;
                            }
                            return;
                        } else if (a.this.j.f(false)) {
                            if (!a.this.j.b()) {
                                a.this.j.e(false);
                                if (a.this.j.f(true)) {
                                    if (!a.this.j.b()) {
                                        if (a.this.n != null) {
                                            q.a("RewardVideoController", "load timeout task called for onVideoLoadFail after " + E + "s exception");
                                        }
                                        a.this.j.e(true);
                                        return;
                                    } else if (a.this.n != null) {
                                        q.a("RewardVideoController", "load timeout task called for onVideoLoadSuccess by isReady but updateCampaignsLoadTimeoutState exception");
                                        a.this.j.d(true);
                                        try {
                                            List<CampaignEx> d2 = a.this.j.d();
                                            if (d2 != null && d2.size() > 0) {
                                                Context g2 = com.mbridge.msdk.foundation.controller.a.e().g();
                                                com.mbridge.msdk.reward.b.a.a(d2.get(0), g2, "load timeout task called onVideoLoadSuccess after " + E + "s exception", a.this.p, a.this.B, "", "", (long) E);
                                                com.mbridge.msdk.reward.b.a.a(a.this.h, d2, a.this.p, 0);
                                            }
                                        } catch (Throwable th2) {
                                            q.d("RewardVideoController", th2.getMessage());
                                        }
                                        c.b(a.this.n, a.this.s, a.this.p);
                                        return;
                                    } else {
                                        return;
                                    }
                                } else if (a.this.n != null) {
                                    q.a("RewardVideoController", "load timeout task called for onVideoLoadFail after " + E + "s exception");
                                    return;
                                } else {
                                    return;
                                }
                            } else if (a.this.n != null) {
                                q.a("RewardVideoController", "load timeout task called for onVideoLoadSuccess by isReady but updateCampaignsLoadTimeoutState exception");
                                a.this.j.d(false);
                                try {
                                    List<CampaignEx> d3 = a.this.j.d();
                                    if (d3 != null && d3.size() > 0) {
                                        Context g3 = com.mbridge.msdk.foundation.controller.a.e().g();
                                        com.mbridge.msdk.reward.b.a.a(d3.get(0), g3, "load timeout task called onVideoLoadSuccess after " + E + "s exception", a.this.p, a.this.B, "", "", (long) E);
                                        com.mbridge.msdk.reward.b.a.a(a.this.h, d3, a.this.p, 0);
                                    }
                                } catch (Throwable th3) {
                                    q.d("RewardVideoController", th3.getMessage());
                                }
                                c.b(a.this.n, a.this.s, a.this.p);
                                return;
                            } else {
                                return;
                            }
                        } else if (a.this.j.f(true)) {
                            if (!a.this.j.b()) {
                                if (a.this.n != null) {
                                    q.a("RewardVideoController", "load timeout task called for onVideoLoadFail after " + E + " s");
                                }
                                a.this.j.e(true);
                                return;
                            } else if (a.this.n != null) {
                                q.a("RewardVideoController", "load timeout task called for onVideoLoadSuccess by isReady but updateCampaignsLoadTimeoutState");
                                a.this.j.d(true);
                                try {
                                    List<CampaignEx> d4 = a.this.j.d();
                                    if (d4 != null && d4.size() > 0) {
                                        Context g4 = com.mbridge.msdk.foundation.controller.a.e().g();
                                        com.mbridge.msdk.reward.b.a.a(d4.get(0), g4, "load timeout task called onVideoLoadSuccess after " + E + "s exception", a.this.p, a.this.B, "", "", (long) E);
                                        com.mbridge.msdk.reward.b.a.a(a.this.h, d4, a.this.p, 0);
                                    }
                                } catch (Throwable th4) {
                                    q.d("RewardVideoController", th4.getMessage());
                                }
                                c.b(a.this.n, a.this.s, a.this.p);
                                return;
                            } else {
                                return;
                            }
                        } else if (a.this.n != null) {
                            q.a("RewardVideoController", "load timeout task called for onVideoLoadFail after " + E + " s");
                            return;
                        } else {
                            return;
                        }
                    } else if (a.this.n != null) {
                        q.a("RewardVideoController", "load timeout task called for onVideoLoadFail by mRewardMvVideoAdapter is null exception");
                        return;
                    } else {
                        return;
                    }
                default:
                    return;
            }
        }
    };
    /* access modifiers changed from: private */
    public int w = 2;
    private int x;
    private int y;
    private int z;

    public final void a(boolean z2) {
        this.A = z2;
    }

    public final void b(boolean z2) {
        this.B = z2;
    }

    public final void a(int i2) {
        this.w = i2;
    }

    public final String a() {
        com.mbridge.msdk.reward.adapter.d dVar = this.j;
        return dVar != null ? dVar.a(this.H) : "";
    }

    public final void a(String str, String str2, String str3, String str4) {
        if (!TextUtils.isEmpty(str)) {
            Context context = this.h;
            w.a(context, "MBridge_ConfirmTitle" + this.p, str.trim());
        }
        if (!TextUtils.isEmpty(str2)) {
            Context context2 = this.h;
            w.a(context2, "MBridge_ConfirmContent" + this.p, str2.trim());
        }
        if (!TextUtils.isEmpty(str4)) {
            Context context3 = this.h;
            w.a(context3, "MBridge_CancelText" + this.p, str4.trim());
        }
        if (!TextUtils.isEmpty(str3)) {
            Context context4 = this.h;
            w.a(context4, "MBridge_ConfirmText" + this.p, str3.trim());
        }
    }

    public final void c(boolean z2) {
        this.F = z2;
    }

    public final void a(int i2, int i3, int i4) {
        this.x = i2;
        this.y = i3;
        if (this.y == com.mbridge.msdk.foundation.same.a.q) {
            this.z = i4 < 0 ? 5 : i4;
        }
        if (this.y == com.mbridge.msdk.foundation.same.a.p) {
            this.z = i4 < 0 ? 80 : i4;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            int i5 = 1;
            jSONObject.put("ivRewardEnable", 1);
            jSONObject.put("ivRewardMode", i2 == com.mbridge.msdk.foundation.same.a.n ? 0 : 1);
            if (i3 == com.mbridge.msdk.foundation.same.a.p) {
                i5 = 0;
            }
            jSONObject.put("ivRewardPlayValueMode", i5);
            jSONObject.put("ivRewardPlayValue", i4);
            com.mbridge.msdk.b.b.a();
            String str = this.p;
            String jSONObject2 = jSONObject.toString();
            com.mbridge.msdk.foundation.a.a.a.a().a("ivreward_" + str, jSONObject2);
        } catch (Exception unused) {
            q.d("RewardVideoController", "setIVRewardEnable to SP was ERROR");
        }
    }

    public static void a(String str, int i2) {
        try {
            if (K != null && x.b(str)) {
                K.put(str, Integer.valueOf(i2));
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static int a(String str) {
        Integer num;
        try {
            if (!x.b(str) || K == null || !K.containsKey(str) || (num = K.get(str)) == null) {
                return 0;
            }
            return num.intValue();
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    public static void a(String str, String str2) {
        ConcurrentHashMap<String, String> concurrentHashMap;
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && (concurrentHashMap = L) != null && !concurrentHashMap.containsKey(str)) {
            L.put(str, str2);
        }
    }

    public final void b() {
        ConcurrentHashMap<String, String> concurrentHashMap;
        if (this.H && (concurrentHashMap = L) != null && !concurrentHashMap.containsKey(a())) {
            L.remove(a());
        }
    }

    public static void insertExcludeId(String str, CampaignEx campaignEx) {
        if (!TextUtils.isEmpty(str) && campaignEx != null && com.mbridge.msdk.foundation.controller.a.e().g() != null) {
            i a2 = i.a((f) g.a(com.mbridge.msdk.foundation.controller.a.e().g()));
            e eVar = new e();
            eVar.a(System.currentTimeMillis());
            eVar.b(str);
            eVar.a(campaignEx.getId());
            a2.a(eVar);
        }
    }

    /* compiled from: RewardVideoController */
    private final class d implements h {
        /* access modifiers changed from: private */
        public a b;
        private int c;
        private Handler d;
        private int e;

        private d(a aVar, int i, Handler handler) {
            this.e = 0;
            this.b = aVar;
            this.c = i;
            this.d = handler;
        }

        public final void a() {
            boolean unused = a.this.J = false;
            try {
                if (this.b != null) {
                    boolean unused2 = this.b.H = true;
                    if (this.b.j != null) {
                        this.b.j.b = "";
                    }
                    this.b.b(this.c);
                    if (a.this.B) {
                        a.j(a.this);
                    }
                    if (this.b.m != null) {
                        this.b.m.onAdShow(a.this.q);
                        this.e = 2;
                    }
                }
            } catch (Throwable th) {
                if (MBridgeConstans.DEBUG) {
                    th.printStackTrace();
                }
            }
        }

        public final void a(boolean z, com.mbridge.msdk.videocommon.b.c cVar) {
            try {
                if (this.b != null && this.b.m != null) {
                    if (cVar == null) {
                        cVar = com.mbridge.msdk.videocommon.b.c.b(this.b.t);
                    }
                    if (a.this.B) {
                        a.j(a.this);
                        a.this.b();
                        com.mbridge.msdk.foundation.same.a.d.d(a.this.p, a.this.a());
                    }
                    this.b.m.onAdClose(a.this.q, new RewardInfo(z, cVar.a(), String.valueOf(cVar.b())));
                    this.e = 7;
                    boolean unused = this.b.H = false;
                    a.this.G.clear();
                    this.b = null;
                }
            } catch (Exception e2) {
                if (MBridgeConstans.DEBUG) {
                    e2.printStackTrace();
                }
            }
        }

        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0073 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void a(java.lang.String r12) {
            /*
                r11 = this;
                r0 = 0
                com.mbridge.msdk.reward.a.a r1 = com.mbridge.msdk.reward.a.a.this     // Catch:{ Exception -> 0x008f }
                boolean unused = r1.J = r0     // Catch:{ Exception -> 0x008f }
                com.mbridge.msdk.reward.a.a r1 = r11.b     // Catch:{ Exception -> 0x008f }
                if (r1 == 0) goto L_0x0099
                com.mbridge.msdk.reward.a.a r1 = com.mbridge.msdk.reward.a.a.this     // Catch:{ Exception -> 0x008f }
                boolean r1 = r1.B     // Catch:{ Exception -> 0x008f }
                if (r1 == 0) goto L_0x0017
                com.mbridge.msdk.reward.a.a r1 = com.mbridge.msdk.reward.a.a.this     // Catch:{ Exception -> 0x008f }
                com.mbridge.msdk.reward.a.a.j(r1)     // Catch:{ Exception -> 0x008f }
            L_0x0017:
                com.mbridge.msdk.reward.a.a r1 = r11.b     // Catch:{ Exception -> 0x008f }
                boolean unused = r1.H = r0     // Catch:{ Exception -> 0x008f }
                com.mbridge.msdk.reward.a.a r1 = r11.b     // Catch:{ Exception -> 0x008f }
                com.mbridge.msdk.videocommon.listener.InterVideoOutListener r1 = r1.m     // Catch:{ Exception -> 0x008f }
                if (r1 == 0) goto L_0x0099
                com.mbridge.msdk.reward.a.a r1 = com.mbridge.msdk.reward.a.a.this     // Catch:{ Exception -> 0x0073 }
                java.util.List r1 = r1.W     // Catch:{ Exception -> 0x0073 }
                if (r1 == 0) goto L_0x0073
                com.mbridge.msdk.reward.a.a r1 = com.mbridge.msdk.reward.a.a.this     // Catch:{ Exception -> 0x0073 }
                java.util.List r1 = r1.W     // Catch:{ Exception -> 0x0073 }
                int r1 = r1.size()     // Catch:{ Exception -> 0x0073 }
                if (r1 <= 0) goto L_0x0073
                com.mbridge.msdk.reward.a.a r1 = com.mbridge.msdk.reward.a.a.this     // Catch:{ Exception -> 0x0073 }
                java.util.List r1 = r1.W     // Catch:{ Exception -> 0x0073 }
                java.lang.Object r1 = r1.get(r0)     // Catch:{ Exception -> 0x0073 }
                r2 = r1
                com.mbridge.msdk.foundation.entity.CampaignEx r2 = (com.mbridge.msdk.foundation.entity.CampaignEx) r2     // Catch:{ Exception -> 0x0073 }
                com.mbridge.msdk.foundation.controller.a r1 = com.mbridge.msdk.foundation.controller.a.e()     // Catch:{ Exception -> 0x0073 }
                android.content.Context r3 = r1.g()     // Catch:{ Exception -> 0x0073 }
                java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0073 }
                r1.<init>()     // Catch:{ Exception -> 0x0073 }
                java.lang.String r4 = "show failed: "
                r1.append(r4)     // Catch:{ Exception -> 0x0073 }
                r1.append(r12)     // Catch:{ Exception -> 0x0073 }
                java.lang.String r4 = r1.toString()     // Catch:{ Exception -> 0x0073 }
                com.mbridge.msdk.reward.a.a r1 = com.mbridge.msdk.reward.a.a.this     // Catch:{ Exception -> 0x0073 }
                java.lang.String r5 = r1.p     // Catch:{ Exception -> 0x0073 }
                com.mbridge.msdk.reward.a.a r1 = com.mbridge.msdk.reward.a.a.this     // Catch:{ Exception -> 0x0073 }
                boolean r6 = r1.B     // Catch:{ Exception -> 0x0073 }
                java.lang.String r7 = ""
                java.lang.String r8 = ""
                r9 = 0
                com.mbridge.msdk.reward.b.a.a(r2, r3, r4, r5, r6, r7, r8, r9)     // Catch:{ Exception -> 0x0073 }
            L_0x0073:
                com.mbridge.msdk.reward.a.a r1 = r11.b     // Catch:{ Exception -> 0x0083 }
                com.mbridge.msdk.videocommon.listener.InterVideoOutListener r1 = r1.m     // Catch:{ Exception -> 0x0083 }
                com.mbridge.msdk.reward.a.a r2 = com.mbridge.msdk.reward.a.a.this     // Catch:{ Exception -> 0x0083 }
                com.mbridge.msdk.out.MBridgeIds r2 = r2.q     // Catch:{ Exception -> 0x0083 }
                r1.onShowFail(r2, r12)     // Catch:{ Exception -> 0x0083 }
                goto L_0x008b
            L_0x0083:
                r12 = move-exception
                boolean r1 = com.mbridge.msdk.MBridgeConstans.DEBUG     // Catch:{ Exception -> 0x008f }
                if (r1 == 0) goto L_0x008b
                r12.printStackTrace()     // Catch:{ Exception -> 0x008f }
            L_0x008b:
                r12 = 4
                r11.e = r12     // Catch:{ Exception -> 0x008f }
                goto L_0x0099
            L_0x008f:
                r12 = move-exception
                r11.e = r0
                boolean r0 = com.mbridge.msdk.MBridgeConstans.DEBUG
                if (r0 == 0) goto L_0x0099
                r12.printStackTrace()
            L_0x0099:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.reward.a.a.d.a(java.lang.String):void");
        }

        public final void a(boolean z, String str, String str2) {
            try {
                if (this.b != null && this.b.m != null) {
                    if (a.this.B) {
                        a.j(a.this);
                    }
                    boolean unused = this.b.H = false;
                    try {
                        this.b.m.onVideoAdClicked(z, a.this.q);
                    } catch (Exception e2) {
                        if (MBridgeConstans.DEBUG) {
                            e2.printStackTrace();
                        }
                    }
                }
            } catch (Exception e3) {
                if (MBridgeConstans.DEBUG) {
                    e3.printStackTrace();
                }
            }
        }

        public final void a(String str, String str2) {
            try {
                if (this.b != null && this.b.m != null) {
                    try {
                        this.b.m.onVideoComplete(a.this.q);
                    } catch (Exception e2) {
                        if (MBridgeConstans.DEBUG) {
                            e2.printStackTrace();
                        }
                    }
                    this.e = 5;
                }
            } catch (Exception e3) {
                if (MBridgeConstans.DEBUG) {
                    e3.printStackTrace();
                }
            }
        }

        public final void a(boolean z, int i) {
            try {
                if (this.b != null && this.b.m != null) {
                    try {
                        this.b.m.onAdCloseWithIVReward(a.this.q, new RewardInfo(z, i));
                    } catch (Exception e2) {
                        if (MBridgeConstans.DEBUG) {
                            e2.printStackTrace();
                        }
                    }
                }
            } catch (Exception e3) {
                if (MBridgeConstans.DEBUG) {
                    e3.printStackTrace();
                }
            }
        }

        public final void b(String str, String str2) {
            try {
                if (this.b != null && this.b.m != null) {
                    try {
                        this.b.m.onEndcardShow(a.this.q);
                        com.mbridge.msdk.foundation.b.b a2 = com.mbridge.msdk.foundation.b.b.a();
                        a2.c(str2 + "_" + 2, 2);
                    } catch (Exception e2) {
                        if (MBridgeConstans.DEBUG) {
                            e2.printStackTrace();
                        }
                    }
                    this.e = 6;
                }
            } catch (Exception e3) {
                if (MBridgeConstans.DEBUG) {
                    e3.printStackTrace();
                }
            }
        }

        public final void a(int i, String str, String str2) {
            this.e = i;
            a aVar = this.b;
            if (aVar != null && !aVar.B && !this.b.A && this.b.k != null && this.b.k.s(this.e) && this.b.n != null && this.b.n.c.get() != 1 && this.b.n.c.get() != 3 && !a.this.G.contains(Integer.valueOf(this.e))) {
                a.this.G.add(Integer.valueOf(this.e));
                int z = this.b.k.z() * 1000;
                if (this.e == 4) {
                    z = PathInterpolatorCompat.MAX_NUM_POINTS;
                }
                Handler handler = this.d;
                if (handler != null) {
                    handler.removeMessages(1001001);
                    this.d.sendEmptyMessageDelayed(1001001, (long) z);
                    return;
                }
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                    public final void run() {
                        if (d.this.b != null) {
                            d.this.b.d(false);
                        }
                    }
                }, (long) z);
            }
        }
    }

    public final void a(InterVideoOutListener interVideoOutListener) {
        this.m = interVideoOutListener;
        this.n = new c(interVideoOutListener, this.v, this.p);
    }

    public final void b(String str, String str2) {
        List<CampaignEx> a2;
        try {
            this.h = com.mbridge.msdk.foundation.controller.a.e().g();
            this.p = str2;
            this.s = str;
            this.q = new MBridgeIds(this.s, this.p);
            this.l = com.mbridge.msdk.videocommon.d.b.a().b();
            com.mbridge.msdk.reward.b.a.a(this.h, this.p);
            o.b();
            j.a().b();
            com.mbridge.msdk.videocommon.download.h.a().b();
            com.mbridge.msdk.videocommon.d.b.a().a(this.p);
            if (!TextUtils.isEmpty(this.p) && (a2 = com.mbridge.msdk.videocommon.a.a.a().a(this.p, 1)) != null && a2.size() > 0) {
                com.mbridge.msdk.videocommon.download.c.getInstance().createUnitCache(this.h, this.p, a2, 94, (com.mbridge.msdk.videocommon.listener.a) null);
            }
            if (this.O == null) {
                this.O = g.a(com.mbridge.msdk.foundation.controller.a.e().g());
            }
        } catch (Throwable th) {
            q.a("RewardVideoController", th.getMessage(), th);
        }
    }

    public final void d(boolean z2) {
        a(z2, "");
    }

    private void c() {
        com.mbridge.msdk.foundation.db.e.a((f) g.a(this.h)).a(this.p);
    }

    private void d() {
        try {
            List<CampaignEx> b2 = com.mbridge.msdk.foundation.db.e.a((f) g.a(this.h)).b(this.p);
            if (b2 != null && b2.size() > 0) {
                for (CampaignEx next : b2) {
                    if (!TextUtils.isEmpty(next.getCMPTEntryUrl())) {
                        com.mbridge.msdk.videocommon.a.b(this.p + "_" + next.getRequestId() + "_" + next.getCMPTEntryUrl());
                        if (next.getRewardTemplateMode() != null && !TextUtils.isEmpty(next.getRewardTemplateMode().e())) {
                            com.mbridge.msdk.videocommon.a.b(this.p + "_" + next.getId() + "_" + next.getRequestId() + "_" + next.getRewardTemplateMode().e());
                        }
                    } else {
                        com.mbridge.msdk.videocommon.a.b(next.getAdType(), next);
                    }
                }
            }
        } catch (Exception unused) {
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(7:72|73|74|(1:78)|79|80|(2:82|106)(1:103)) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:79:0x01d7 */
    /* JADX WARNING: Removed duplicated region for block: B:103:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x01db A[Catch:{ Exception -> 0x01e1 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(boolean r14, java.lang.String r15) {
        /*
            r13 = this;
            java.lang.String r0 = "load exception"
            com.mbridge.msdk.reward.a.a$c r1 = r13.n
            r2 = 1
            r3 = 0
            if (r1 == 0) goto L_0x0045
            com.mbridge.msdk.reward.a.a$c r1 = r13.n
            int r1 = r1.c.get()
            if (r1 != r2) goto L_0x0045
            boolean r15 = r13.E
            if (r15 == 0) goto L_0x0040
            if (r14 == 0) goto L_0x0044
            java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx> r14 = r13.W
            if (r14 == 0) goto L_0x0038
            int r14 = r14.size()
            if (r14 <= 0) goto L_0x0038
            java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx> r14 = r13.W
            java.lang.Object r14 = r14.get(r3)
            r0 = r14
            com.mbridge.msdk.foundation.entity.CampaignEx r0 = (com.mbridge.msdk.foundation.entity.CampaignEx) r0
            android.content.Context r1 = r13.h
            java.lang.String r3 = r13.p
            boolean r4 = r13.B
            java.lang.String r2 = "current unit is loading"
            java.lang.String r5 = ""
            java.lang.String r6 = ""
            com.mbridge.msdk.reward.b.a.b(r0, r1, r2, r3, r4, r5, r6)
        L_0x0038:
            com.mbridge.msdk.reward.a.a$c r14 = r13.n
            java.lang.String r15 = "errorCode: 3501 errorMessage: current unit is loading"
            r14.a((java.lang.String) r15)
            goto L_0x0044
        L_0x0040:
            if (r14 == 0) goto L_0x0044
            r13.E = r14
        L_0x0044:
            return
        L_0x0045:
            com.mbridge.msdk.reward.a.a$c r1 = r13.n
            if (r1 == 0) goto L_0x0055
            com.mbridge.msdk.reward.a.a$c r1 = r13.n
            int r1 = r1.c.get()
            r4 = 3
            if (r1 != r4) goto L_0x0055
            r13.P = r3
            goto L_0x005c
        L_0x0055:
            r13.P = r2
            com.mbridge.msdk.reward.a.a$c r1 = r13.n
            r1.c.set(r2)
        L_0x005c:
            r13.E = r14
            android.os.Handler r1 = r13.v
            r2 = 1001001(0xf4629, float:1.402701E-39)
            r1.removeMessages(r2)
            r13.S = r3
            r13.R = r3
            r13.T = r3
            r13.U = r3
            r13.d()
            r13.c()
            com.mbridge.msdk.reward.adapter.c r1 = com.mbridge.msdk.reward.adapter.c.a()
            r1.b()
            boolean r1 = android.text.TextUtils.isEmpty(r15)     // Catch:{ Exception -> 0x01e1 }
            if (r1 == 0) goto L_0x009c
            boolean r1 = r13.A     // Catch:{ Exception -> 0x01e1 }
            if (r1 == 0) goto L_0x0091
            com.mbridge.msdk.c.b r1 = com.mbridge.msdk.c.b.getInstance()     // Catch:{ Exception -> 0x01e1 }
            java.lang.String r2 = r13.s     // Catch:{ Exception -> 0x01e1 }
            java.lang.String r4 = r13.p     // Catch:{ Exception -> 0x01e1 }
            r1.addInterstitialList(r2, r4)     // Catch:{ Exception -> 0x01e1 }
            goto L_0x009c
        L_0x0091:
            com.mbridge.msdk.c.b r1 = com.mbridge.msdk.c.b.getInstance()     // Catch:{ Exception -> 0x01e1 }
            java.lang.String r2 = r13.s     // Catch:{ Exception -> 0x01e1 }
            java.lang.String r4 = r13.p     // Catch:{ Exception -> 0x01e1 }
            r1.addRewardList(r2, r4)     // Catch:{ Exception -> 0x01e1 }
        L_0x009c:
            boolean r1 = r13.B     // Catch:{ Exception -> 0x01e1 }
            if (r1 == 0) goto L_0x00d6
            boolean r1 = android.text.TextUtils.isEmpty(r15)     // Catch:{ Exception -> 0x01e1 }
            if (r1 == 0) goto L_0x00d6
            com.mbridge.msdk.reward.a.a$c r14 = r13.n     // Catch:{ Exception -> 0x01e1 }
            if (r14 == 0) goto L_0x00d5
            java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx> r14 = r13.W     // Catch:{ Exception -> 0x01e1 }
            if (r14 == 0) goto L_0x00ce
            java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx> r14 = r13.W     // Catch:{ Exception -> 0x01e1 }
            int r14 = r14.size()     // Catch:{ Exception -> 0x01e1 }
            if (r14 <= 0) goto L_0x00ce
            java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx> r14 = r13.W     // Catch:{ Exception -> 0x01e1 }
            java.lang.Object r14 = r14.get(r3)     // Catch:{ Exception -> 0x01e1 }
            r4 = r14
            com.mbridge.msdk.foundation.entity.CampaignEx r4 = (com.mbridge.msdk.foundation.entity.CampaignEx) r4     // Catch:{ Exception -> 0x01e1 }
            android.content.Context r5 = r13.h     // Catch:{ Exception -> 0x01e1 }
            java.lang.String r6 = "bidToken is empty"
            java.lang.String r7 = r13.p     // Catch:{ Exception -> 0x01e1 }
            boolean r8 = r13.B     // Catch:{ Exception -> 0x01e1 }
            java.lang.String r9 = ""
            java.lang.String r10 = ""
            com.mbridge.msdk.reward.b.a.b(r4, r5, r6, r7, r8, r9, r10)     // Catch:{ Exception -> 0x01e1 }
        L_0x00ce:
            com.mbridge.msdk.reward.a.a$c r14 = r13.n     // Catch:{ Exception -> 0x01e1 }
            java.lang.String r15 = "bidToken is empty"
            com.mbridge.msdk.reward.a.a.c.c(r14, r15)     // Catch:{ Exception -> 0x01e1 }
        L_0x00d5:
            return
        L_0x00d6:
            java.util.Map<java.lang.String, java.lang.String> r1 = com.mbridge.msdk.system.a.a     // Catch:{ Exception -> 0x01e1 }
            if (r1 != 0) goto L_0x010a
            com.mbridge.msdk.reward.a.a$c r14 = r13.n     // Catch:{ Exception -> 0x01e1 }
            if (r14 == 0) goto L_0x0109
            java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx> r14 = r13.W     // Catch:{ Exception -> 0x01e1 }
            if (r14 == 0) goto L_0x0102
            java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx> r14 = r13.W     // Catch:{ Exception -> 0x01e1 }
            int r14 = r14.size()     // Catch:{ Exception -> 0x01e1 }
            if (r14 <= 0) goto L_0x0102
            java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx> r14 = r13.W     // Catch:{ Exception -> 0x01e1 }
            java.lang.Object r14 = r14.get(r3)     // Catch:{ Exception -> 0x01e1 }
            r4 = r14
            com.mbridge.msdk.foundation.entity.CampaignEx r4 = (com.mbridge.msdk.foundation.entity.CampaignEx) r4     // Catch:{ Exception -> 0x01e1 }
            android.content.Context r5 = r13.h     // Catch:{ Exception -> 0x01e1 }
            java.lang.String r6 = "init error"
            java.lang.String r7 = r13.p     // Catch:{ Exception -> 0x01e1 }
            boolean r8 = r13.B     // Catch:{ Exception -> 0x01e1 }
            java.lang.String r9 = ""
            java.lang.String r10 = ""
            com.mbridge.msdk.reward.b.a.b(r4, r5, r6, r7, r8, r9, r10)     // Catch:{ Exception -> 0x01e1 }
        L_0x0102:
            com.mbridge.msdk.reward.a.a$c r14 = r13.n     // Catch:{ Exception -> 0x01e1 }
            java.lang.String r15 = "init error"
            com.mbridge.msdk.reward.a.a.c.c(r14, r15)     // Catch:{ Exception -> 0x01e1 }
        L_0x0109:
            return
        L_0x010a:
            com.mbridge.msdk.videocommon.d.b r1 = com.mbridge.msdk.videocommon.d.b.a()     // Catch:{ Exception -> 0x01e1 }
            com.mbridge.msdk.foundation.controller.a r2 = com.mbridge.msdk.foundation.controller.a.e()     // Catch:{ Exception -> 0x01e1 }
            java.lang.String r2 = r2.h()     // Catch:{ Exception -> 0x01e1 }
            java.lang.String r4 = r13.p     // Catch:{ Exception -> 0x01e1 }
            com.mbridge.msdk.videocommon.d.c r1 = r1.a(r2, r4)     // Catch:{ Exception -> 0x01e1 }
            r13.k = r1     // Catch:{ Exception -> 0x01e1 }
            com.mbridge.msdk.videocommon.d.c r1 = r13.k     // Catch:{ Exception -> 0x01e1 }
            if (r1 != 0) goto L_0x015a
            com.mbridge.msdk.foundation.controller.a r1 = com.mbridge.msdk.foundation.controller.a.e()     // Catch:{ Exception -> 0x01e1 }
            java.lang.String r1 = r1.h()     // Catch:{ Exception -> 0x01e1 }
            r13.N = r1     // Catch:{ Exception -> 0x01e1 }
            com.mbridge.msdk.videocommon.d.b r1 = com.mbridge.msdk.videocommon.d.b.a()     // Catch:{ Exception -> 0x01e1 }
            java.lang.String r2 = r13.N     // Catch:{ Exception -> 0x01e1 }
            com.mbridge.msdk.foundation.controller.a r4 = com.mbridge.msdk.foundation.controller.a.e()     // Catch:{ Exception -> 0x01e1 }
            java.lang.String r4 = r4.i()     // Catch:{ Exception -> 0x01e1 }
            java.lang.String r5 = r13.p     // Catch:{ Exception -> 0x01e1 }
            com.mbridge.msdk.reward.a.a$2 r6 = new com.mbridge.msdk.reward.a.a$2     // Catch:{ Exception -> 0x01e1 }
            r6.<init>()     // Catch:{ Exception -> 0x01e1 }
            r1.a(r2, r4, r5, r6)     // Catch:{ Exception -> 0x01e1 }
            com.mbridge.msdk.videocommon.d.b r1 = com.mbridge.msdk.videocommon.d.b.a()     // Catch:{ Exception -> 0x01e1 }
            com.mbridge.msdk.foundation.controller.a r2 = com.mbridge.msdk.foundation.controller.a.e()     // Catch:{ Exception -> 0x01e1 }
            java.lang.String r2 = r2.h()     // Catch:{ Exception -> 0x01e1 }
            java.lang.String r4 = r13.p     // Catch:{ Exception -> 0x01e1 }
            boolean r5 = r13.A     // Catch:{ Exception -> 0x01e1 }
            com.mbridge.msdk.videocommon.d.c r1 = r1.a((java.lang.String) r2, (java.lang.String) r4, (boolean) r5)     // Catch:{ Exception -> 0x01e1 }
            r13.k = r1     // Catch:{ Exception -> 0x01e1 }
        L_0x015a:
            java.lang.String r1 = r13.s     // Catch:{ Exception -> 0x01e1 }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ Exception -> 0x01e1 }
            if (r1 != 0) goto L_0x0169
            com.mbridge.msdk.videocommon.d.c r1 = r13.k     // Catch:{ Exception -> 0x01e1 }
            java.lang.String r2 = r13.s     // Catch:{ Exception -> 0x01e1 }
            r1.b((java.lang.String) r2)     // Catch:{ Exception -> 0x01e1 }
        L_0x0169:
            com.mbridge.msdk.videocommon.d.c r1 = r13.k     // Catch:{ Exception -> 0x01e1 }
            int r1 = r1.E()     // Catch:{ Exception -> 0x01e1 }
            int r1 = r1 * 1000
            android.os.Handler r2 = r13.v     // Catch:{ Exception -> 0x01e1 }
            if (r2 == 0) goto L_0x017e
            android.os.Handler r2 = r13.v     // Catch:{ Exception -> 0x01e1 }
            r4 = 1001002(0xf462a, float:1.402703E-39)
            long r5 = (long) r1     // Catch:{ Exception -> 0x01e1 }
            r2.sendEmptyMessageDelayed(r4, r5)     // Catch:{ Exception -> 0x01e1 }
        L_0x017e:
            com.mbridge.msdk.videocommon.d.c r1 = r13.k     // Catch:{ Exception -> 0x01e1 }
            java.util.Queue r1 = r1.A()     // Catch:{ Exception -> 0x01e1 }
            r13.M = r1     // Catch:{ Exception -> 0x01e1 }
            boolean r1 = r13.f()     // Catch:{ Exception -> 0x0190 }
            if (r1 == 0) goto L_0x0198
            r13.e()     // Catch:{ Exception -> 0x0190 }
            goto L_0x0198
        L_0x0190:
            r1 = move-exception
            boolean r2 = com.mbridge.msdk.MBridgeConstans.DEBUG     // Catch:{ Exception -> 0x01e1 }
            if (r2 == 0) goto L_0x0198
            r1.printStackTrace()     // Catch:{ Exception -> 0x01e1 }
        L_0x0198:
            r13.b((boolean) r14, (java.lang.String) r15)     // Catch:{ Exception -> 0x019d }
            goto L_0x0227
        L_0x019d:
            r14 = move-exception
            java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx> r15 = r13.W     // Catch:{ Exception -> 0x01d7 }
            if (r15 == 0) goto L_0x01d7
            java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx> r15 = r13.W     // Catch:{ Exception -> 0x01d7 }
            int r15 = r15.size()     // Catch:{ Exception -> 0x01d7 }
            if (r15 <= 0) goto L_0x01d7
            java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx> r15 = r13.W     // Catch:{ Exception -> 0x01d7 }
            java.lang.Object r15 = r15.get(r3)     // Catch:{ Exception -> 0x01d7 }
            r4 = r15
            com.mbridge.msdk.foundation.entity.CampaignEx r4 = (com.mbridge.msdk.foundation.entity.CampaignEx) r4     // Catch:{ Exception -> 0x01d7 }
            android.content.Context r5 = r13.h     // Catch:{ Exception -> 0x01d7 }
            java.lang.StringBuilder r15 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x01d7 }
            r15.<init>()     // Catch:{ Exception -> 0x01d7 }
            java.lang.String r1 = "load exception: "
            r15.append(r1)     // Catch:{ Exception -> 0x01d7 }
            java.lang.String r14 = r14.getMessage()     // Catch:{ Exception -> 0x01d7 }
            r15.append(r14)     // Catch:{ Exception -> 0x01d7 }
            java.lang.String r6 = r15.toString()     // Catch:{ Exception -> 0x01d7 }
            java.lang.String r7 = r13.p     // Catch:{ Exception -> 0x01d7 }
            boolean r8 = r13.B     // Catch:{ Exception -> 0x01d7 }
            java.lang.String r9 = ""
            java.lang.String r10 = ""
            r11 = 0
            com.mbridge.msdk.reward.b.a.a(r4, r5, r6, r7, r8, r9, r10, r11)     // Catch:{ Exception -> 0x01d7 }
        L_0x01d7:
            com.mbridge.msdk.reward.a.a$c r14 = r13.n     // Catch:{ Exception -> 0x01e1 }
            if (r14 == 0) goto L_0x0227
            com.mbridge.msdk.reward.a.a$c r14 = r13.n     // Catch:{ Exception -> 0x01e1 }
            com.mbridge.msdk.reward.a.a.c.a((com.mbridge.msdk.reward.a.a.c) r14, (java.lang.String) r0)     // Catch:{ Exception -> 0x01e1 }
            goto L_0x0227
        L_0x01e1:
            r14 = move-exception
            com.mbridge.msdk.reward.a.a$c r15 = r13.n
            if (r15 == 0) goto L_0x0220
            com.mbridge.msdk.reward.a.a$c r15 = r13.n
            com.mbridge.msdk.reward.a.a.c.a((com.mbridge.msdk.reward.a.a.c) r15, (java.lang.String) r0)
            java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx> r15 = r13.W
            if (r15 == 0) goto L_0x0220
            int r15 = r15.size()
            if (r15 <= 0) goto L_0x0220
            java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx> r15 = r13.W
            java.lang.Object r15 = r15.get(r3)
            r0 = r15
            com.mbridge.msdk.foundation.entity.CampaignEx r0 = (com.mbridge.msdk.foundation.entity.CampaignEx) r0
            android.content.Context r1 = r13.h
            java.lang.StringBuilder r15 = new java.lang.StringBuilder
            r15.<init>()
            java.lang.String r2 = "load exception "
            r15.append(r2)
            java.lang.String r2 = r14.getMessage()
            r15.append(r2)
            java.lang.String r2 = r15.toString()
            java.lang.String r3 = r13.p
            boolean r4 = r13.B
            java.lang.String r5 = ""
            java.lang.String r6 = ""
            com.mbridge.msdk.reward.b.a.b(r0, r1, r2, r3, r4, r5, r6)
        L_0x0220:
            boolean r15 = com.mbridge.msdk.MBridgeConstans.DEBUG
            if (r15 == 0) goto L_0x0227
            r14.printStackTrace()
        L_0x0227:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.reward.a.a.a(boolean, java.lang.String):void");
    }

    private void b(boolean z2, String str) {
        if (this.n == null) {
            return;
        }
        if (!this.B) {
            this.V = b(this.p);
            if (!this.V) {
                this.V = false;
                com.mbridge.msdk.reward.adapter.d dVar = this.j;
                if (dVar != null) {
                    dVar.a(this.W);
                }
                this.n.a(this.B);
                a(this.M, z2, str);
            } else if (!j()) {
                List<CampaignEx> list = this.W;
                if (list != null && list.size() > 0) {
                    c.c(this.n, this.s, this.p);
                    CampaignEx campaignEx = list.get(0);
                    this.n.a(this.B);
                    com.mbridge.msdk.reward.adapter.d dVar2 = this.j;
                    if (dVar2 == null || !dVar2.a(list, true ^ TextUtils.isEmpty(campaignEx.getCMPTEntryUrl()), campaignEx.getNscpt())) {
                        a(list, this.j);
                    } else {
                        com.mbridge.msdk.reward.b.a.a(this.h, this.W, this.p, 0);
                        c.b(this.n, this.s, this.p);
                    }
                    if (this.P) {
                        com.mbridge.msdk.reward.adapter.d dVar3 = this.j;
                        if (dVar3 != null) {
                            dVar3.a(this.W);
                        }
                        a(this.M, z2, str);
                    }
                }
            } else {
                this.V = false;
                com.mbridge.msdk.reward.adapter.d dVar4 = this.j;
                if (dVar4 != null) {
                    dVar4.a(this.W);
                }
                this.n.a(this.B);
                a(this.M, z2, str);
            }
        } else {
            List<CampaignEx> a2 = com.mbridge.msdk.videocommon.a.a.a().a(this.p, 1, this.B, "");
            if (a2 == null || a2.size() <= 0) {
                if (!j()) {
                    this.V = false;
                    this.n.a(this.B);
                    a(this.M, z2, str);
                    return;
                }
                com.mbridge.msdk.videocommon.a.a.a().a(this.p, str);
                if (z2 && this.n != null) {
                    c.c(this.n, "checkOverCap failed");
                }
            } else if (!j()) {
                List<CampaignEx> b2 = b(str, a2);
                if (b2 == null || b2.size() <= 0) {
                    List<CampaignEx> a3 = a(str, a2);
                    if (a3 != null && a3.size() > 0) {
                        a(a3, str);
                        com.mbridge.msdk.foundation.db.b.a(com.mbridge.msdk.foundation.controller.a.e().g()).a(str, a3);
                        com.mbridge.msdk.reward.adapter.d dVar5 = this.j;
                        if (dVar5 != null) {
                            dVar5.a(a3);
                        }
                    }
                    this.V = false;
                    this.n.a(this.B);
                    a(this.M, z2, str);
                    return;
                }
                a(b2, str);
            } else {
                com.mbridge.msdk.videocommon.a.a.a().a(this.p, str);
                if (z2 && this.n != null) {
                    c.c(this.n, "checkOverCap failed");
                }
            }
        }
    }

    private void a(List<CampaignEx> list, String str) {
        if (list != null && list.size() > 0) {
            this.V = true;
            this.n.a(this.B);
            c.c(this.n, this.s, this.p);
            CampaignEx campaignEx = list.get(0);
            a(campaignEx.getRequestId(), str);
            com.mbridge.msdk.reward.adapter.d dVar = this.j;
            if (dVar == null || !dVar.a(list, true ^ TextUtils.isEmpty(campaignEx.getCMPTEntryUrl()), campaignEx.getNscpt())) {
                a(list, this.j);
                return;
            }
            com.mbridge.msdk.reward.b.a.a(this.h, this.W, this.p, 0);
            c.b(this.n, this.s, this.p);
        }
    }

    private List<CampaignEx> a(String str, List<CampaignEx> list) {
        ArrayList arrayList = new ArrayList();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        if (list != null) {
            try {
                if (list.size() > 0) {
                    int i2 = 1;
                    for (CampaignEx next : list) {
                        if (next != null) {
                            if (next.getVcn() > i2) {
                                i2 = next.getVcn();
                            }
                            if (next.getTokenRule() == 1) {
                                String requestId = next.getRequestId();
                                if (!TextUtils.isEmpty(requestId)) {
                                    if (linkedHashMap.containsKey(requestId)) {
                                        ((List) linkedHashMap.get(requestId)).add(next);
                                    } else {
                                        ArrayList arrayList2 = new ArrayList();
                                        arrayList2.add(next);
                                        linkedHashMap.put(requestId, arrayList2);
                                    }
                                }
                            } else {
                                String requestId2 = next.getRequestId();
                                if (!TextUtils.isEmpty(requestId2)) {
                                    if (linkedHashMap2.containsKey(requestId2)) {
                                        ((List) linkedHashMap2.get(requestId2)).add(next);
                                    } else {
                                        ArrayList arrayList3 = new ArrayList();
                                        arrayList3.add(next);
                                        linkedHashMap2.put(requestId2, arrayList3);
                                    }
                                }
                            }
                        }
                    }
                    if (!(linkedHashMap2.size() + linkedHashMap.size() < i2 || linkedHashMap.size() <= 0 || linkedHashMap.entrySet() == null || linkedHashMap.entrySet().iterator() == null || linkedHashMap.entrySet().iterator().next() == null || ((Map.Entry) linkedHashMap.entrySet().iterator().next()).getValue() == null)) {
                        arrayList.addAll((Collection) ((Map.Entry) linkedHashMap.entrySet().iterator().next()).getValue());
                        com.mbridge.msdk.foundation.same.a.d.a(this.p, str, i2);
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return arrayList;
    }

    private List<CampaignEx> b(String str, List<CampaignEx> list) {
        ArrayList arrayList = new ArrayList();
        if (list != null && list.size() > 0 && !TextUtils.isEmpty(str)) {
            for (CampaignEx next : list) {
                if (next != null && str.equals(next.getBidToken())) {
                    arrayList.add(next);
                }
            }
        }
        return arrayList;
    }

    private void a(List<CampaignEx> list, com.mbridge.msdk.reward.adapter.d dVar) {
        final CampaignEx campaignEx = list.get(0);
        final boolean z2 = !TextUtils.isEmpty(campaignEx.getCMPTEntryUrl());
        final int nscpt = campaignEx.getNscpt();
        this.c = false;
        this.d = false;
        this.e = false;
        this.f = false;
        this.g = false;
        com.mbridge.msdk.reward.adapter.c a2 = com.mbridge.msdk.reward.adapter.c.a();
        Context context = this.h;
        boolean z3 = this.B;
        final boolean z4 = z2;
        final CampaignEx campaignEx2 = campaignEx;
        final com.mbridge.msdk.reward.adapter.d dVar2 = dVar;
        final int i2 = nscpt;
        int i3 = nscpt;
        final boolean z5 = z2;
        CampaignEx campaignEx3 = campaignEx;
        a2.a(context, z2, nscpt, z3, this.A ? 287 : 94, this.s, this.p, campaignEx.getRequestId(), list, new c.C0099c() {
            public final void a(String str, String str2, String str3, List<CampaignEx> list) {
                String str4 = str2;
                List<CampaignEx> list2 = list;
                a aVar = a.this;
                aVar.c = true;
                if (!z4) {
                    for (final CampaignEx next : list) {
                        if (next == null || next.getRewardTemplateMode() == null || TextUtils.isEmpty(next.getRewardTemplateMode().e()) || next.getRewardTemplateMode().e().contains(CampaignEx.KEY_IS_CMPT_ENTRY) || a.this.v == null) {
                            com.mbridge.msdk.reward.adapter.d dVar = dVar2;
                            if (dVar == null || !dVar.a(list2, z4, i2)) {
                                String str5 = str;
                                a aVar2 = a.this;
                                a.a(aVar2, str4, aVar2.X);
                                if (a.this.n != null && !a.this.f) {
                                    a.this.f = true;
                                    q.a("RewardVideoController", "Cache onVideoLoadFailForCache");
                                    if (a.this.W != null && a.this.W.size() > 0) {
                                        com.mbridge.msdk.reward.b.a.a((CampaignEx) a.this.W.get(0), a.this.h, "have no temp but isReady false", a.this.p, a.this.B, str3, next.getRequestIdNotice());
                                    }
                                    c.d(a.this.n, "errorCode: 3503 errorMessage: have no temp but isReady false");
                                }
                            } else if (a.this.n != null && !a.this.g) {
                                a.this.g = true;
                                q.a("RewardVideoController", "Cache onVideoLoadSuccessForCache");
                                com.mbridge.msdk.reward.b.a.a(a.this.h, list2, a.this.p, 0);
                                c.b(a.this.n, str, str4);
                            }
                        } else {
                            final List<CampaignEx> list3 = list;
                            final String str6 = str;
                            final String str7 = str2;
                            final String str8 = str3;
                            a.this.v.post(new Runnable() {
                                public final void run() {
                                    com.mbridge.msdk.reward.adapter.c a2 = com.mbridge.msdk.reward.adapter.c.a();
                                    boolean r = a.this.F;
                                    Handler q = a.this.v;
                                    boolean p = a.this.A;
                                    boolean i = a.this.B;
                                    String e2 = next.getRewardTemplateMode().e();
                                    int s = a.this.w;
                                    CampaignEx campaignEx = campaignEx2;
                                    List list = list3;
                                    String b2 = com.mbridge.msdk.videocommon.download.g.a().b(next.getRewardTemplateMode().e());
                                    String str = str6;
                                    String str2 = str7;
                                    String str3 = str8;
                                    String requestIdNotice = next.getRequestIdNotice();
                                    com.mbridge.msdk.videocommon.d.c l = a.this.k;
                                    AnonymousClass1 r17 = r6;
                                    AnonymousClass1 r6 = new c.j() {
                                        public final void a(String str, String str2, String str3, String str4, String str5, a.C0105a aVar) {
                                            if (dVar2 == null || !dVar2.a((List<CampaignEx>) list3, z4, i2)) {
                                                a.a(a.this, str3, a.this.X);
                                                if (a.this.n != null && !a.this.f) {
                                                    a.this.f = true;
                                                    if (a.this.W != null && a.this.W.size() > 0) {
                                                        com.mbridge.msdk.reward.b.a.a((CampaignEx) a.this.W.get(0), a.this.h, "temp preload success but isReady false", a.this.p, a.this.B, str4, next.getRequestIdNotice());
                                                    }
                                                    c.d(a.this.n, "errorCode: 3502 errorMessage: temp preload success but isReady false");
                                                }
                                            } else if (a.this.n != null && !a.this.g) {
                                                a.this.g = true;
                                                com.mbridge.msdk.reward.b.a.a(a.this.h, list3, a.this.p, 0);
                                                c.b(a.this.n, str2, str3);
                                            }
                                        }

                                        public final void a(String str, String str2, String str3, String str4, String str5, a.C0105a aVar, String str6) {
                                            a.a(a.this, str3, a.this.X);
                                            if (a.this.n != null && !a.this.f) {
                                                a.this.f = true;
                                                if (a.this.W != null && a.this.W.size() > 0) {
                                                    Context m = a.this.h;
                                                    com.mbridge.msdk.reward.b.a.a((CampaignEx) a.this.W.get(0), m, "temp preload failed: " + str6, a.this.p, a.this.B, str4, next.getRequestIdNotice());
                                                }
                                                c d = a.this.n;
                                                c.d(d, "errorCode: 3301 errorMessage: temp preload failed: " + str6);
                                            }
                                        }
                                    };
                                    a2.a(r, q, p, i, (WindVaneWebView) null, e2, s, campaignEx, list, b2, str, str2, str3, requestIdNotice, l, r17);
                                }
                            });
                        }
                        String str9 = str;
                    }
                    return;
                }
                String str10 = str;
                if (aVar.d && !a.this.e && a.this.v != null) {
                    a aVar3 = a.this;
                    aVar3.e = true;
                    final String str11 = str3;
                    final String str12 = str;
                    final String str13 = str2;
                    final List<CampaignEx> list4 = list;
                    aVar3.v.post(new Runnable() {
                        public final void run() {
                            com.mbridge.msdk.reward.adapter.c a2 = com.mbridge.msdk.reward.adapter.c.a();
                            boolean r = a.this.F;
                            Handler q = a.this.v;
                            boolean p = a.this.A;
                            boolean i = a.this.B;
                            String str = str11;
                            String requestIdNotice = campaignEx2.getRequestIdNotice();
                            String str2 = str12;
                            String str3 = str13;
                            String cMPTEntryUrl = campaignEx2.getCMPTEntryUrl();
                            int s = a.this.w;
                            CampaignEx campaignEx = campaignEx2;
                            List list = list4;
                            String b2 = com.mbridge.msdk.videocommon.download.g.a().b(campaignEx2.getCMPTEntryUrl());
                            String str4 = str13;
                            com.mbridge.msdk.reward.adapter.c cVar = a2;
                            com.mbridge.msdk.videocommon.d.c l = a.this.k;
                            AnonymousClass1 r17 = r1;
                            AnonymousClass1 r1 = new c.j() {
                                public final void a(String str, String str2, String str3, String str4, String str5, a.C0105a aVar) {
                                    if (dVar2 == null || !dVar2.a((List<CampaignEx>) list4, z4, i2)) {
                                        a.a(a.this, str3, a.this.X);
                                        if (a.this.n != null && !a.this.f) {
                                            a.this.f = true;
                                            if (a.this.W != null && a.this.W.size() > 0) {
                                                com.mbridge.msdk.reward.b.a.a((CampaignEx) a.this.W.get(0), a.this.h, "tpl temp preload success but isReady false", a.this.p, a.this.B, str4, campaignEx2.getRequestIdNotice());
                                            }
                                            c.d(a.this.n, "errorCode: 3504 errorMessage: tpl temp preload success but isReady false");
                                        }
                                    } else if (a.this.n != null && !a.this.g) {
                                        a.this.g = true;
                                        q.a("RewardVideoController", "Cache onVideoLoadSuccessForCache");
                                        com.mbridge.msdk.reward.b.a.a(a.this.h, list4, a.this.p, 0);
                                        c.b(a.this.n, str2, str3);
                                    }
                                }

                                public final void a(String str, String str2, String str3, String str4, String str5, a.C0105a aVar, String str6) {
                                    a.a(a.this, str3, a.this.X);
                                    if (a.this.n != null && !a.this.f) {
                                        a.this.f = true;
                                        if (a.this.W != null && a.this.W.size() > 0) {
                                            Context m = a.this.h;
                                            com.mbridge.msdk.reward.b.a.a((CampaignEx) a.this.W.get(0), m, "tpl temp preload failed: " + str6, a.this.p, a.this.B, str4, campaignEx2.getRequestIdNotice());
                                        }
                                        c d = a.this.n;
                                        c.d(d, "errorCode: 3302 errorMessage: tpl temp preload failed: " + str6);
                                    }
                                }
                            };
                            cVar.a(r, q, p, i, str, requestIdNotice, str2, str3, cMPTEntryUrl, s, campaignEx, list, b2, str4, l, r17, true);
                        }
                    });
                }
            }

            public final void a(String str, String str2, String str3, List<CampaignEx> list, String str4) {
                a aVar = a.this;
                aVar.c = false;
                a.a(aVar, str2, aVar.X);
                if (a.this.n != null && !a.this.f) {
                    a aVar2 = a.this;
                    aVar2.f = true;
                    if (aVar2.W != null && a.this.W.size() > 0) {
                        Context m = a.this.h;
                        com.mbridge.msdk.reward.b.a.a((CampaignEx) a.this.W.get(0), m, "" + str4, a.this.p, a.this.B, str3, campaignEx2.getRequestIdNotice());
                    }
                    c.d(a.this.n, "errorCode: 3201 errorMessage: campaign resource download failed");
                }
            }
        }, new c.i() {
            public final void a(String str, String str2, String str3, String str4) {
            }

            public final void a(String str, String str2, String str3, String str4, String str5) {
                a aVar = a.this;
                a.a(aVar, str2, aVar.X);
                if (z2 || a.this.n == null) {
                    if (nscpt == 1 && !a.this.f && a.this.n != null) {
                        a aVar2 = a.this;
                        aVar2.f = true;
                        if (aVar2.W != null && a.this.W.size() > 0) {
                            com.mbridge.msdk.reward.b.a.a((CampaignEx) a.this.W.get(0), a.this.h, "temp resource download failed", a.this.p, a.this.B, str3, campaignEx.getRequestIdNotice());
                        }
                        c.d(a.this.n, "errorCode: 3202 errorMessage: temp resource download failed");
                    }
                } else if (!a.this.f) {
                    a aVar3 = a.this;
                    aVar3.f = true;
                    if (aVar3.W != null && a.this.W.size() > 0) {
                        Context m = a.this.h;
                        com.mbridge.msdk.reward.b.a.a((CampaignEx) a.this.W.get(0), m, "" + str5, a.this.p, a.this.B, str3, campaignEx.getRequestIdNotice());
                    }
                    c.d(a.this.n, "errorCode: 3202 errorMessage: temp resource download failed");
                }
            }
        });
        if (z5) {
            final CampaignEx campaignEx4 = campaignEx3;
            final List<CampaignEx> list2 = list;
            final com.mbridge.msdk.reward.adapter.d dVar3 = dVar;
            final int i4 = i3;
            com.mbridge.msdk.reward.adapter.c.a().a(this.h, campaignEx3, this.s, this.p, campaignEx3.getRequestId(), new c.i() {
                public final void a(final String str, final String str2, final String str3, String str4) {
                    a aVar = a.this;
                    aVar.d = true;
                    if (aVar.c && !a.this.e && a.this.v != null) {
                        a aVar2 = a.this;
                        aVar2.e = true;
                        aVar2.v.post(new Runnable() {
                            public final void run() {
                                com.mbridge.msdk.reward.adapter.c a2 = com.mbridge.msdk.reward.adapter.c.a();
                                boolean r = a.this.F;
                                Handler q = a.this.v;
                                boolean p = a.this.A;
                                boolean i = a.this.B;
                                String str = str3;
                                String requestIdNotice = campaignEx4.getRequestIdNotice();
                                String str2 = str;
                                String str3 = str2;
                                String cMPTEntryUrl = campaignEx4.getCMPTEntryUrl();
                                int s = a.this.w;
                                CampaignEx campaignEx = campaignEx4;
                                List list = list2;
                                String b2 = com.mbridge.msdk.videocommon.download.g.a().b(campaignEx4.getCMPTEntryUrl());
                                String str4 = str2;
                                com.mbridge.msdk.reward.adapter.c cVar = a2;
                                com.mbridge.msdk.videocommon.d.c l = a.this.k;
                                AnonymousClass1 r17 = r1;
                                AnonymousClass1 r1 = new c.j() {
                                    public final void a(String str, String str2, String str3, String str4, String str5, a.C0105a aVar) {
                                        if (!dVar3.a((List<CampaignEx>) list2, z5, i4)) {
                                            a.a(a.this, str3, a.this.X);
                                            if (a.this.n != null && !a.this.f) {
                                                a.this.f = true;
                                                if (a.this.W != null && a.this.W.size() > 0) {
                                                    com.mbridge.msdk.reward.b.a.a((CampaignEx) a.this.W.get(0), a.this.h, "tpl temp preload success but isReady false", a.this.p, a.this.B, str4, campaignEx4.getRequestIdNotice());
                                                }
                                                c.d(a.this.n, "errorCode: 3505 errorMessage: tpl temp preload success but isReady false");
                                            }
                                        } else if (a.this.n != null && !a.this.g) {
                                            a.this.g = true;
                                            q.a("RewardVideoController", "Cache onVideoLoadSuccess");
                                            com.mbridge.msdk.reward.b.a.a(a.this.h, list2, a.this.p, 0);
                                            c.b(a.this.n, str2, str3);
                                        }
                                    }

                                    public final void a(String str, String str2, String str3, String str4, String str5, a.C0105a aVar, String str6) {
                                        a.a(a.this, str3, a.this.X);
                                        if (a.this.n != null && !a.this.f) {
                                            a.this.f = true;
                                            if (a.this.W != null && a.this.W.size() > 0) {
                                                Context m = a.this.h;
                                                com.mbridge.msdk.reward.b.a.a((CampaignEx) a.this.W.get(0), m, "tpl temp preload failed: " + str6, a.this.p, a.this.B, str4, campaignEx4.getRequestIdNotice());
                                            }
                                            c d = a.this.n;
                                            c.d(d, "errorCode: 3303 errorMessage: tpl temp preload failed: " + str6);
                                        }
                                    }
                                };
                                cVar.a(r, q, p, i, str, requestIdNotice, str2, str3, cMPTEntryUrl, s, campaignEx, list, b2, str4, l, r17, true);
                            }
                        });
                    }
                }

                public final void a(String str, String str2, String str3, String str4, String str5) {
                    a aVar = a.this;
                    a.a(aVar, str2, aVar.X);
                    a aVar2 = a.this;
                    aVar2.d = false;
                    if (aVar2.n != null && !a.this.f) {
                        a aVar3 = a.this;
                        aVar3.f = true;
                        if (aVar3.W != null && a.this.W.size() > 0) {
                            Context m = a.this.h;
                            com.mbridge.msdk.reward.b.a.a((CampaignEx) a.this.W.get(0), m, "" + str5, a.this.p, a.this.B, str3, campaignEx4.getRequestIdNotice());
                        }
                        c.d(a.this.n, "errorCode: 3203 errorMessage: tpl temp resource download failed");
                    }
                }
            });
        }
    }

    private boolean b(String str) {
        try {
            if (this.j == null || !str.equals(this.j.a())) {
                this.j = new com.mbridge.msdk.reward.adapter.d(this.h, this.s, str);
                this.j.b(this.A);
                this.j.c(this.B);
            }
            this.j.a(this.w);
            this.j.a(this.k);
        } catch (Exception unused) {
        }
        List<CampaignEx> a2 = com.mbridge.msdk.videocommon.a.a.a().a(str, 1, this.B);
        this.X = com.mbridge.msdk.videocommon.a.a.a().b(str, 1, this.B);
        if (a2 == null || a2.size() <= 0) {
            List<CampaignEx> list = this.W;
            if (list == null) {
                return false;
            }
            list.clear();
            return false;
        }
        List<CampaignEx> list2 = this.W;
        if (list2 == null) {
            this.W = new ArrayList();
        } else {
            list2.clear();
        }
        this.W.addAll(a2);
        return true;
    }

    /* compiled from: RewardVideoController */
    private final class c {
        private WeakReference<InterVideoOutListener> b;
        /* access modifiers changed from: private */
        public volatile AtomicInteger c;
        private Handler d;
        private String e;
        private boolean f;

        private c(InterVideoOutListener interVideoOutListener, Handler handler, String str) {
            this.b = new WeakReference<>(interVideoOutListener);
            this.c = new AtomicInteger(0);
            this.d = handler;
            this.e = str;
        }

        /* access modifiers changed from: private */
        public void a(String str) {
            if (this.d != null) {
                Message obtain = Message.obtain();
                obtain.obj = str;
                obtain.what = 18;
                this.d.sendMessage(obtain);
            }
        }

        public final void a(boolean z) {
            this.f = z;
        }

        static /* synthetic */ void a(c cVar, String str, String str2) {
            Handler handler = cVar.d;
            if (handler != null) {
                handler.removeMessages(1001002);
            }
            WeakReference<InterVideoOutListener> weakReference = cVar.b;
            if (weakReference != null && ((InterVideoOutListener) weakReference.get()) != null) {
                if ((cVar.c.get() == 1 || cVar.c.get() == 3) && cVar.d != null) {
                    cVar.c.set(2);
                    if (!a.this.S) {
                        boolean unused = a.this.S = true;
                        Message obtain = Message.obtain();
                        Bundle bundle = new Bundle();
                        bundle.putString(MBridgeConstans.PLACEMENT_ID, str);
                        bundle.putString(MBridgeConstans.PROPERTIES_UNIT_ID, str2);
                        obtain.setData(bundle);
                        obtain.obj = str2;
                        obtain.what = 9;
                        cVar.d.sendMessage(obtain);
                    }
                }
            }
        }

        static /* synthetic */ void a(c cVar, String str) {
            Handler handler = cVar.d;
            if (handler != null) {
                handler.removeMessages(1001002);
            }
            WeakReference<InterVideoOutListener> weakReference = cVar.b;
            if (weakReference != null && ((InterVideoOutListener) weakReference.get()) != null) {
                if ((cVar.c.get() == 1 || cVar.c.get() == 3) && cVar.d != null) {
                    boolean unused = a.this.T = true;
                    if (!a.this.V || str.contains("resource load timeout")) {
                        boolean unused2 = a.this.U = true;
                    }
                    if (a.this.S) {
                        cVar.c.set(2);
                    }
                    if (a.this.T && a.this.U && !a.this.S) {
                        cVar.c.set(2);
                        Message obtain = Message.obtain();
                        obtain.obj = str;
                        obtain.what = 16;
                        cVar.d.sendMessage(obtain);
                    }
                }
            }
        }

        static /* synthetic */ void b(c cVar, String str, String str2) {
            Handler handler = cVar.d;
            if (handler != null) {
                handler.removeMessages(1001002);
            }
            WeakReference<InterVideoOutListener> weakReference = cVar.b;
            if (weakReference != null && ((InterVideoOutListener) weakReference.get()) != null) {
                if ((cVar.c.get() == 1 || cVar.c.get() == 3) && cVar.d != null) {
                    if (cVar.c.get() == 1) {
                        cVar.c.set(3);
                    }
                    if (!a.this.S) {
                        boolean unused = a.this.S = true;
                        Message obtain = Message.obtain();
                        Bundle bundle = new Bundle();
                        bundle.putString(MBridgeConstans.PLACEMENT_ID, str);
                        bundle.putString(MBridgeConstans.PROPERTIES_UNIT_ID, str2);
                        obtain.setData(bundle);
                        obtain.obj = str2;
                        obtain.what = 9;
                        cVar.d.sendMessage(obtain);
                        if (a.this.T) {
                            cVar.c.set(2);
                        }
                    }
                }
            }
        }

        static /* synthetic */ void c(c cVar, String str) {
            cVar.c.set(2);
            cVar.a(str);
        }

        static /* synthetic */ void c(c cVar, String str, String str2) {
            WeakReference<InterVideoOutListener> weakReference = cVar.b;
            if (weakReference != null && ((InterVideoOutListener) weakReference.get()) != null && cVar.d != null && !a.this.R) {
                boolean unused = a.this.R = true;
                Message obtain = Message.obtain();
                Bundle bundle = new Bundle();
                bundle.putString(MBridgeConstans.PLACEMENT_ID, str);
                bundle.putString(MBridgeConstans.PROPERTIES_UNIT_ID, str2);
                obtain.setData(bundle);
                obtain.obj = str2;
                obtain.what = 17;
                cVar.d.sendMessage(obtain);
            }
        }

        static /* synthetic */ void d(c cVar, String str) {
            WeakReference<InterVideoOutListener> weakReference = cVar.b;
            if (weakReference != null && ((InterVideoOutListener) weakReference.get()) != null) {
                if ((cVar.c.get() == 1 || cVar.c.get() == 3) && cVar.d != null) {
                    boolean unused = a.this.U = true;
                    if (str.contains("resource load timeout")) {
                        boolean unused2 = a.this.T = true;
                    }
                    if (a.this.U && a.this.T && !a.this.S) {
                        cVar.c.set(2);
                        Message obtain = Message.obtain();
                        obtain.obj = str;
                        obtain.what = 16;
                        cVar.d.sendMessage(obtain);
                    }
                }
            }
        }

        static /* synthetic */ void d(c cVar, String str, String str2) {
            WeakReference<InterVideoOutListener> weakReference = cVar.b;
            if (weakReference != null && ((InterVideoOutListener) weakReference.get()) != null) {
                if ((cVar.c.get() == 1 || cVar.c.get() == 3) && cVar.d != null && !a.this.R) {
                    boolean unused = a.this.R = true;
                    Message obtain = Message.obtain();
                    Bundle bundle = new Bundle();
                    bundle.putString(MBridgeConstans.PLACEMENT_ID, str);
                    bundle.putString(MBridgeConstans.PROPERTIES_UNIT_ID, str2);
                    obtain.setData(bundle);
                    obtain.obj = str2;
                    obtain.what = 17;
                    cVar.d.sendMessage(obtain);
                }
            }
        }
    }

    private void e() {
        try {
            List<com.mbridge.msdk.videocommon.b.b> w2 = this.k.w();
            if (w2 != null && w2.size() > 0) {
                for (int i2 = 0; i2 < w2.size(); i2++) {
                    w.a(this.h, this.s + "_" + w2.get(i2).a(), 0);
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private boolean f() {
        int i2;
        try {
            List<com.mbridge.msdk.videocommon.b.b> w2 = this.k.w();
            if (this.l == null) {
                this.l = com.mbridge.msdk.videocommon.d.b.a().b();
            }
            Map<String, Integer> h2 = this.l.h();
            if (w2 == null || w2.size() <= 0) {
                return true;
            }
            for (int i3 = 0; i3 < w2.size(); i3++) {
                com.mbridge.msdk.videocommon.b.b bVar = w2.get(i3);
                if (h2.containsKey(bVar.a() + "")) {
                    i2 = h2.get(bVar.a() + "").intValue();
                } else {
                    i2 = 0;
                }
                Object b2 = w.b(this.h, this.s + "_" + bVar.a(), 0);
                if ((b2 != null ? ((Integer) b2).intValue() : 0) < i2) {
                    return false;
                }
            }
            return true;
        } catch (Exception e2) {
            e2.printStackTrace();
            q.d("RewardVideoController", e2.getMessage());
            return true;
        }
    }

    private void a(Queue<Integer> queue, boolean z2, String str) {
        int i2 = 8;
        if (queue != null) {
            try {
                if (queue.size() > 0) {
                    i2 = queue.poll().intValue();
                }
            } catch (Exception e2) {
                List<CampaignEx> list = this.W;
                if (list != null && list.size() > 0) {
                    com.mbridge.msdk.reward.b.a.b(this.W.get(0), this.h, "can't show because unknow error", this.p, this.B, "", "");
                }
                c("can't show because unknow error");
                if (MBridgeConstans.DEBUG) {
                    e2.printStackTrace();
                    return;
                }
                return;
            }
        }
        try {
            a(1, i2, z2, str);
        } catch (Exception e3) {
            if (this.W != null) {
                if (this.W.size() > 0) {
                    Context context = this.h;
                    com.mbridge.msdk.reward.b.a.b(this.W.get(0), context, "load mv api error:" + e3.getMessage(), this.p, this.B, "", "");
                }
            }
            c("load mv api error:" + e3.getMessage());
        }
    }

    /* access modifiers changed from: private */
    public void c(String str) {
        if (this.n != null) {
            this.U = true;
            c.a(this.n, str);
        }
    }

    private void a(int i2, int i3, boolean z2, String str) {
        try {
            if (this.j == null || !this.p.equals(this.j.a())) {
                this.j = new com.mbridge.msdk.reward.adapter.d(this.h, this.s, this.p);
                this.j.b(this.A);
                this.j.c(this.B);
            }
            if (this.A) {
                this.j.a(this.x, this.y, this.z);
            }
            this.j.a(this.w);
            this.j.a(this.k);
            C0098a aVar = new C0098a(this.j, i2, z2);
            b bVar = new b(this.j, z2);
            bVar.a((Runnable) aVar);
            this.j.a((com.mbridge.msdk.reward.adapter.b) bVar);
            this.v.postDelayed(aVar, (long) (i3 * 1000));
            this.j.a(i2, i3, z2, str, this.F);
        } catch (Exception e2) {
            List<CampaignEx> list = this.W;
            if (list != null && list.size() > 0) {
                com.mbridge.msdk.reward.b.a.b(this.W.get(0), this.h, e2.getMessage(), this.p, this.B, "", "");
            }
            c(e2.getMessage());
        }
    }

    public final void b(int i2) {
        try {
            if (this.O == null) {
                this.O = g.a(com.mbridge.msdk.foundation.controller.a.e().g());
            }
            com.mbridge.msdk.foundation.db.h a2 = com.mbridge.msdk.foundation.db.h.a((f) this.O);
            if (a2 != null) {
                a2.a(this.p);
            }
        } catch (Throwable unused) {
            q.d("RewardVideoController", "can't find DailyPlayCapDao");
        }
        if (i2 == 1) {
            Context context = this.h;
            w.a(context, this.s + "_" + i2, Integer.valueOf(this.i + 1));
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000e, code lost:
        r7 = r13.l.h();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void d(java.lang.String r14) {
        /*
            r13 = this;
            java.lang.String r0 = "1"
            java.lang.String r1 = "_"
            java.lang.String r2 = "RewardVideoController"
            r3 = 3
            r4 = 4
            r5 = 1
            r6 = 0
            com.mbridge.msdk.videocommon.d.a r7 = r13.l     // Catch:{ Exception -> 0x015a }
            if (r7 == 0) goto L_0x0027
            com.mbridge.msdk.videocommon.d.a r7 = r13.l     // Catch:{ Exception -> 0x015a }
            java.util.Map r7 = r7.h()     // Catch:{ Exception -> 0x015a }
            if (r7 == 0) goto L_0x0027
            boolean r8 = r7.containsKey(r0)     // Catch:{ Exception -> 0x015a }
            if (r8 == 0) goto L_0x0027
            java.lang.Object r0 = r7.get(r0)     // Catch:{ Exception -> 0x015a }
            java.lang.Integer r0 = (java.lang.Integer) r0     // Catch:{ Exception -> 0x015a }
            int r0 = r0.intValue()     // Catch:{ Exception -> 0x015a }
            goto L_0x0028
        L_0x0027:
            r0 = r6
        L_0x0028:
            android.content.Context r7 = r13.h     // Catch:{ Exception -> 0x015a }
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x015a }
            r8.<init>()     // Catch:{ Exception -> 0x015a }
            java.lang.String r9 = r13.s     // Catch:{ Exception -> 0x015a }
            r8.append(r9)     // Catch:{ Exception -> 0x015a }
            r8.append(r1)     // Catch:{ Exception -> 0x015a }
            r8.append(r5)     // Catch:{ Exception -> 0x015a }
            java.lang.String r8 = r8.toString()     // Catch:{ Exception -> 0x015a }
            java.lang.Integer r9 = java.lang.Integer.valueOf(r6)     // Catch:{ Exception -> 0x015a }
            java.lang.Object r7 = com.mbridge.msdk.foundation.tools.w.b(r7, r8, r9)     // Catch:{ Exception -> 0x015a }
            if (r7 == 0) goto L_0x006e
            android.content.Context r7 = r13.h     // Catch:{ Exception -> 0x015a }
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x015a }
            r8.<init>()     // Catch:{ Exception -> 0x015a }
            java.lang.String r9 = r13.s     // Catch:{ Exception -> 0x015a }
            r8.append(r9)     // Catch:{ Exception -> 0x015a }
            r8.append(r1)     // Catch:{ Exception -> 0x015a }
            r8.append(r5)     // Catch:{ Exception -> 0x015a }
            java.lang.String r8 = r8.toString()     // Catch:{ Exception -> 0x015a }
            java.lang.Integer r9 = java.lang.Integer.valueOf(r6)     // Catch:{ Exception -> 0x015a }
            java.lang.Object r7 = com.mbridge.msdk.foundation.tools.w.b(r7, r8, r9)     // Catch:{ Exception -> 0x015a }
            java.lang.Integer r7 = (java.lang.Integer) r7     // Catch:{ Exception -> 0x015a }
            int r7 = r7.intValue()     // Catch:{ Exception -> 0x015a }
            r13.i = r7     // Catch:{ Exception -> 0x015a }
        L_0x006e:
            com.mbridge.msdk.reward.adapter.d r7 = r13.j     // Catch:{ Exception -> 0x015a }
            if (r7 != 0) goto L_0x0075
            r13.i()     // Catch:{ Exception -> 0x015a }
        L_0x0075:
            com.mbridge.msdk.reward.adapter.d r7 = r13.j     // Catch:{ Exception -> 0x015a }
            if (r7 == 0) goto L_0x00f3
            java.lang.String r7 = "controller 819"
            com.mbridge.msdk.foundation.tools.q.d(r2, r7)     // Catch:{ Exception -> 0x015a }
            boolean r7 = r13.B     // Catch:{ Exception -> 0x015a }
            if (r7 == 0) goto L_0x0087
            boolean r7 = r13.g()     // Catch:{ Exception -> 0x015a }
            goto L_0x008d
        L_0x0087:
            com.mbridge.msdk.reward.adapter.d r7 = r13.j     // Catch:{ Exception -> 0x015a }
            boolean r7 = r7.b()     // Catch:{ Exception -> 0x015a }
        L_0x008d:
            if (r7 == 0) goto L_0x00bc
            int r1 = r13.i     // Catch:{ Exception -> 0x015a }
            if (r1 < r0) goto L_0x0096
            if (r0 <= 0) goto L_0x0096
            return
        L_0x0096:
            java.lang.String r0 = "invoke adapter show isReady"
            com.mbridge.msdk.foundation.tools.q.b(r2, r0)     // Catch:{ Exception -> 0x015a }
            com.mbridge.msdk.reward.a.a$d r0 = new com.mbridge.msdk.reward.a.a$d     // Catch:{ Exception -> 0x015a }
            android.os.Handler r11 = r13.v     // Catch:{ Exception -> 0x015a }
            r12 = 0
            r10 = 1
            r7 = r0
            r8 = r13
            r9 = r13
            r7.<init>(r9, r10, r11)     // Catch:{ Exception -> 0x015a }
            java.util.Map<java.lang.String, com.mbridge.msdk.reward.a.a$d> r1 = b     // Catch:{ Exception -> 0x015a }
            java.lang.String r7 = r13.p     // Catch:{ Exception -> 0x015a }
            r1.put(r7, r0)     // Catch:{ Exception -> 0x015a }
            com.mbridge.msdk.reward.adapter.d r7 = r13.j     // Catch:{ Exception -> 0x015a }
            java.lang.String r10 = r13.o     // Catch:{ Exception -> 0x015a }
            int r11 = r13.w     // Catch:{ Exception -> 0x015a }
            java.lang.String r12 = r13.r     // Catch:{ Exception -> 0x015a }
            r8 = r0
            r9 = r14
            r7.a((com.mbridge.msdk.video.bt.module.b.h) r8, (java.lang.String) r9, (java.lang.String) r10, (int) r11, (java.lang.String) r12)     // Catch:{ Exception -> 0x015a }
            return
        L_0x00bc:
            boolean r0 = r13.B     // Catch:{ Exception -> 0x015a }
            if (r0 == 0) goto L_0x00c5
            boolean r0 = r13.h()     // Catch:{ Exception -> 0x015a }
            goto L_0x00cb
        L_0x00c5:
            com.mbridge.msdk.reward.adapter.d r0 = r13.j     // Catch:{ Exception -> 0x015a }
            boolean r0 = r0.c()     // Catch:{ Exception -> 0x015a }
        L_0x00cb:
            if (r0 == 0) goto L_0x00f3
            java.lang.String r0 = "invoke adapter show isSpareOfferReady"
            com.mbridge.msdk.foundation.tools.q.b(r2, r0)     // Catch:{ Exception -> 0x015a }
            com.mbridge.msdk.reward.a.a$d r0 = new com.mbridge.msdk.reward.a.a$d     // Catch:{ Exception -> 0x015a }
            android.os.Handler r11 = r13.v     // Catch:{ Exception -> 0x015a }
            r12 = 0
            r10 = 1
            r7 = r0
            r8 = r13
            r9 = r13
            r7.<init>(r9, r10, r11)     // Catch:{ Exception -> 0x015a }
            java.util.Map<java.lang.String, com.mbridge.msdk.reward.a.a$d> r1 = b     // Catch:{ Exception -> 0x015a }
            java.lang.String r7 = r13.p     // Catch:{ Exception -> 0x015a }
            r1.put(r7, r0)     // Catch:{ Exception -> 0x015a }
            com.mbridge.msdk.reward.adapter.d r7 = r13.j     // Catch:{ Exception -> 0x015a }
            java.lang.String r10 = r13.o     // Catch:{ Exception -> 0x015a }
            int r11 = r13.w     // Catch:{ Exception -> 0x015a }
            java.lang.String r12 = r13.r     // Catch:{ Exception -> 0x015a }
            r8 = r0
            r9 = r14
            r7.a((com.mbridge.msdk.video.bt.module.b.h) r8, (java.lang.String) r9, (java.lang.String) r10, (int) r11, (java.lang.String) r12)     // Catch:{ Exception -> 0x015a }
            return
        L_0x00f3:
            int r0 = r13.i     // Catch:{ Exception -> 0x015a }
            if (r0 == 0) goto L_0x0118
            android.content.Context r0 = r13.h     // Catch:{ Exception -> 0x015a }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x015a }
            r7.<init>()     // Catch:{ Exception -> 0x015a }
            java.lang.String r8 = r13.s     // Catch:{ Exception -> 0x015a }
            r7.append(r8)     // Catch:{ Exception -> 0x015a }
            r7.append(r1)     // Catch:{ Exception -> 0x015a }
            r7.append(r5)     // Catch:{ Exception -> 0x015a }
            java.lang.String r1 = r7.toString()     // Catch:{ Exception -> 0x015a }
            java.lang.Integer r7 = java.lang.Integer.valueOf(r6)     // Catch:{ Exception -> 0x015a }
            com.mbridge.msdk.foundation.tools.w.a(r0, r1, r7)     // Catch:{ Exception -> 0x015a }
            r13.d((java.lang.String) r14)     // Catch:{ Exception -> 0x015a }
            return
        L_0x0118:
            com.mbridge.msdk.videocommon.listener.InterVideoOutListener r14 = r13.m     // Catch:{ Exception -> 0x015a }
            if (r14 == 0) goto L_0x012e
            com.mbridge.msdk.videocommon.listener.InterVideoOutListener r14 = r13.m     // Catch:{ Exception -> 0x0126 }
            com.mbridge.msdk.out.MBridgeIds r0 = r13.q     // Catch:{ Exception -> 0x0126 }
            java.lang.String r1 = "can't show because load is failed"
            r14.onShowFail(r0, r1)     // Catch:{ Exception -> 0x0126 }
            goto L_0x012e
        L_0x0126:
            r14 = move-exception
            boolean r0 = com.mbridge.msdk.MBridgeConstans.DEBUG     // Catch:{ Exception -> 0x015a }
            if (r0 == 0) goto L_0x012e
            r14.printStackTrace()     // Catch:{ Exception -> 0x015a }
        L_0x012e:
            boolean r14 = r13.A     // Catch:{ Exception -> 0x015a }
            if (r14 != 0) goto L_0x01a4
            boolean r14 = r13.B     // Catch:{ Exception -> 0x015a }
            if (r14 != 0) goto L_0x01a4
            com.mbridge.msdk.videocommon.d.c r14 = r13.k     // Catch:{ Exception -> 0x015a }
            if (r14 == 0) goto L_0x01a4
            com.mbridge.msdk.videocommon.d.c r14 = r13.k     // Catch:{ Exception -> 0x015a }
            boolean r14 = r14.s(r4)     // Catch:{ Exception -> 0x015a }
            if (r14 == 0) goto L_0x01a4
            com.mbridge.msdk.reward.a.a$c r14 = r13.n     // Catch:{ Exception -> 0x015a }
            if (r14 == 0) goto L_0x01a4
            com.mbridge.msdk.reward.a.a$c r14 = r13.n     // Catch:{ Exception -> 0x015a }
            int r14 = r14.c.get()     // Catch:{ Exception -> 0x015a }
            if (r14 == r5) goto L_0x01a4
            com.mbridge.msdk.reward.a.a$c r14 = r13.n     // Catch:{ Exception -> 0x015a }
            int r14 = r14.c.get()     // Catch:{ Exception -> 0x015a }
            if (r14 == r3) goto L_0x01a4
            r13.d((boolean) r6)     // Catch:{ Exception -> 0x015a }
            goto L_0x01a4
        L_0x015a:
            r14 = move-exception
            boolean r0 = com.mbridge.msdk.MBridgeConstans.DEBUG
            if (r0 == 0) goto L_0x0166
            java.lang.String r0 = r14.getLocalizedMessage()
            com.mbridge.msdk.foundation.tools.q.d(r2, r0)
        L_0x0166:
            com.mbridge.msdk.videocommon.listener.InterVideoOutListener r0 = r13.m
            if (r0 == 0) goto L_0x017b
            com.mbridge.msdk.videocommon.listener.InterVideoOutListener r0 = r13.m     // Catch:{ Exception -> 0x0174 }
            com.mbridge.msdk.out.MBridgeIds r1 = r13.q     // Catch:{ Exception -> 0x0174 }
            java.lang.String r2 = "show exception"
            r0.onShowFail(r1, r2)     // Catch:{ Exception -> 0x0174 }
            goto L_0x017b
        L_0x0174:
            boolean r0 = com.mbridge.msdk.MBridgeConstans.DEBUG
            if (r0 == 0) goto L_0x017b
            r14.printStackTrace()
        L_0x017b:
            boolean r14 = r13.A
            if (r14 != 0) goto L_0x01a4
            boolean r14 = r13.B
            if (r14 != 0) goto L_0x01a4
            com.mbridge.msdk.videocommon.d.c r14 = r13.k
            if (r14 == 0) goto L_0x01a4
            boolean r14 = r14.s(r4)
            if (r14 == 0) goto L_0x01a4
            com.mbridge.msdk.reward.a.a$c r14 = r13.n
            if (r14 == 0) goto L_0x01a4
            com.mbridge.msdk.reward.a.a$c r14 = r13.n
            int r14 = r14.c.get()
            if (r14 == r5) goto L_0x01a4
            com.mbridge.msdk.reward.a.a$c r14 = r13.n
            int r14 = r14.c.get()
            if (r14 == r3) goto L_0x01a4
            r13.d((boolean) r6)
        L_0x01a4:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.reward.a.a.d(java.lang.String):void");
    }

    public final boolean e(boolean z2) {
        try {
            if (j()) {
                return false;
            }
            if (this.B) {
                try {
                    return g();
                } catch (Exception unused) {
                    return false;
                }
            } else {
                if (this.j == null) {
                    i();
                }
                if (this.j == null) {
                    return false;
                }
                boolean b2 = this.j.b();
                return !b2 ? this.j.c() : b2;
            }
        } catch (Throwable th) {
            if (!MBridgeConstans.DEBUG) {
                return false;
            }
            th.printStackTrace();
            return false;
        }
    }

    private boolean g() {
        if (this.j == null) {
            i();
        }
        List<com.mbridge.msdk.foundation.entity.b> a2 = com.mbridge.msdk.videocommon.a.a.a().a(this.p);
        boolean z2 = false;
        if (a2 == null || a2.size() <= 0) {
            return false;
        }
        String c2 = com.mbridge.msdk.foundation.same.a.d.c(this.p);
        if (!TextUtils.isEmpty(c2)) {
            z2 = b(a2, c2);
        }
        if (z2) {
            return z2;
        }
        for (com.mbridge.msdk.foundation.entity.b next : a2) {
            if (next != null) {
                this.j.a(next.b());
                if (this.j.b()) {
                    return true;
                }
            }
        }
        return z2;
    }

    private boolean b(List<com.mbridge.msdk.foundation.entity.b> list, String str) {
        if (list == null) {
            return false;
        }
        for (com.mbridge.msdk.foundation.entity.b next : list) {
            if (next != null && str.equals(next.a())) {
                this.j.a(next.b());
                if (this.j.b()) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean h() {
        if (this.j == null) {
            i();
        }
        List<com.mbridge.msdk.foundation.entity.b> a2 = com.mbridge.msdk.videocommon.a.a.a().a(this.p);
        if (a2 == null || a2.size() <= 0) {
            return false;
        }
        for (com.mbridge.msdk.foundation.entity.b next : a2) {
            if (next != null) {
                this.j.a(next.b());
                if (this.j.c()) {
                    return true;
                }
                com.mbridge.msdk.videocommon.a.a.a().b(this.p, next.b());
            }
        }
        return false;
    }

    private void i() {
        this.j = new com.mbridge.msdk.reward.adapter.d(this.h, this.s, this.p);
        this.j.b(this.A);
        this.j.c(this.B);
        if (this.A) {
            this.j.a(this.x, this.y, this.z);
        }
        this.j.a(this.k);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:140|141|217) */
    /* JADX WARNING: Code restructure failed: missing block: B:101:0x0110, code lost:
        if (com.mbridge.msdk.reward.a.a.c.a(r6.n) == 3) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:102:0x0112, code lost:
        a(false, "");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:104:0x011c, code lost:
        if (j() == false) goto L_0x0162;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:106:0x0120, code lost:
        if (r6.m == null) goto L_0x0134;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:108:?, code lost:
        r6.m.onShowFail(r6.q, "Play more than limit");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:109:0x012c, code lost:
        r7 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:112:0x012f, code lost:
        if (com.mbridge.msdk.MBridgeConstans.DEBUG != false) goto L_0x0131;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:113:0x0131, code lost:
        r7.printStackTrace();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:115:0x0136, code lost:
        if (r6.A != false) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:117:0x013a, code lost:
        if (r6.B != false) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:119:0x013e, code lost:
        if (r6.k == null) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:121:0x0146, code lost:
        if (r6.k.s(4) == false) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:123:0x014a, code lost:
        if (r6.n == null) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:125:0x0152, code lost:
        if (com.mbridge.msdk.reward.a.a.c.a(r6.n) == 1) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:127:0x015a, code lost:
        if (com.mbridge.msdk.reward.a.a.c.a(r6.n) == 3) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:128:0x015c, code lost:
        a(false, "");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:130:0x0168, code lost:
        if (android.text.TextUtils.isEmpty(r6.o) == false) goto L_0x0170;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:131:0x016a, code lost:
        r6.o = com.mbridge.msdk.foundation.tools.m.i();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:133:?, code lost:
        r8 = new java.text.SimpleDateFormat("dd").format(new java.util.Date());
        r9 = (java.lang.String) com.mbridge.msdk.foundation.tools.w.b(r6.h, "reward_date", com.mbridge.msdk.MBridgeConstans.ENDCARD_URL_TYPE_PL);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:134:0x0190, code lost:
        if (android.text.TextUtils.isEmpty(r9) != false) goto L_0x01c4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:136:0x0196, code lost:
        if (android.text.TextUtils.isEmpty(r8) != false) goto L_0x01c4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:138:0x019c, code lost:
        if (r9.equals(r8) != false) goto L_0x01c4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:139:0x019e, code lost:
        com.mbridge.msdk.foundation.tools.w.a(r6.h, "reward_date", r8);
        r8 = r6.h;
        com.mbridge.msdk.foundation.tools.w.a(r8, r6.s + "_" + 1, 0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:141:?, code lost:
        d(r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:177:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:178:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:179:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0028, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:180:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:181:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:182:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:183:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:184:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:185:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:186:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:187:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:188:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:189:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:190:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:191:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:192:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:193:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:194:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:195:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:196:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:197:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:198:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:199:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:200:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:201:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:202:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:203:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:204:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:205:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:206:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:207:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:208:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:217:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x002e, code lost:
        if (r6.n == null) goto L_0x0080;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x003a, code lost:
        if (com.mbridge.msdk.reward.a.a.c.b(r6.n).get() != 1) goto L_0x0080;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x003e, code lost:
        if (r6.m == null) goto L_0x0052;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:?, code lost:
        r6.m.onShowFail(r6.q, "campaing is loading");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x004a, code lost:
        r7 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x004d, code lost:
        if (com.mbridge.msdk.MBridgeConstans.DEBUG != false) goto L_0x004f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x004f, code lost:
        r7.printStackTrace();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0054, code lost:
        if (r6.A != false) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0058, code lost:
        if (r6.B != false) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x005c, code lost:
        if (r6.k == null) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0064, code lost:
        if (r6.k.s(4) == false) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x0068, code lost:
        if (r6.n == null) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x0070, code lost:
        if (com.mbridge.msdk.reward.a.a.c.a(r6.n) == 1) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x0078, code lost:
        if (com.mbridge.msdk.reward.a.a.c.a(r6.n) == 3) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x007a, code lost:
        a(false, "");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x0082, code lost:
        if (r6.h != null) goto L_0x00c8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x0086, code lost:
        if (r6.m == null) goto L_0x009a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:?, code lost:
        r6.m.onShowFail(r6.q, "context is null");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x0092, code lost:
        r7 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x0095, code lost:
        if (com.mbridge.msdk.MBridgeConstans.DEBUG != false) goto L_0x0097;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x0097, code lost:
        r7.printStackTrace();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x009c, code lost:
        if (r6.A != false) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x00a0, code lost:
        if (r6.B != false) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x00a4, code lost:
        if (r6.k == null) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x00ac, code lost:
        if (r6.k.s(4) == false) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x00b0, code lost:
        if (r6.n == null) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x00b8, code lost:
        if (com.mbridge.msdk.reward.a.a.c.a(r6.n) == 1) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x00c0, code lost:
        if (com.mbridge.msdk.reward.a.a.c.a(r6.n) == 3) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x00c2, code lost:
        a(false, "");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x00ca, code lost:
        if (r6.A == false) goto L_0x0118;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x00d2, code lost:
        if (com.mbridge.msdk.foundation.tools.u.c(r6.h) != false) goto L_0x0118;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x00d6, code lost:
        if (r6.m == null) goto L_0x00ea;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:?, code lost:
        r6.m.onShowFail(r6.q, "network exception");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x00e2, code lost:
        r7 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x00e5, code lost:
        if (com.mbridge.msdk.MBridgeConstans.DEBUG != false) goto L_0x00e7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x00e7, code lost:
        r7.printStackTrace();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:0x00ec, code lost:
        if (r6.A != false) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:0x00f0, code lost:
        if (r6.B != false) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:93:0x00f4, code lost:
        if (r6.k == null) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:95:0x00fc, code lost:
        if (r6.k.s(4) == false) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:97:0x0100, code lost:
        if (r6.n == null) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:99:0x0108, code lost:
        if (com.mbridge.msdk.reward.a.a.c.a(r6.n) == 1) goto L_?;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:140:0x01c4 */
    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(java.lang.String r7, java.lang.String r8, java.lang.String r9) {
        /*
            r6 = this;
            r0 = 3
            r1 = 4
            r2 = 0
            r3 = 1
            r6.t = r7     // Catch:{ Exception -> 0x01cb }
            r6.o = r8     // Catch:{ Exception -> 0x01cb }
            r6.r = r9     // Catch:{ Exception -> 0x01cb }
            java.lang.Object r8 = r6.I     // Catch:{ Exception -> 0x01cb }
            monitor-enter(r8)     // Catch:{ Exception -> 0x01cb }
            boolean r9 = r6.J     // Catch:{ all -> 0x01c8 }
            if (r9 == 0) goto L_0x0029
            com.mbridge.msdk.videocommon.listener.InterVideoOutListener r7 = r6.m     // Catch:{ all -> 0x01c8 }
            if (r7 == 0) goto L_0x0027
            com.mbridge.msdk.videocommon.listener.InterVideoOutListener r7 = r6.m     // Catch:{ Exception -> 0x001f }
            com.mbridge.msdk.out.MBridgeIds r9 = r6.q     // Catch:{ Exception -> 0x001f }
            java.lang.String r4 = "campaing is show progressing "
            r7.onShowFail(r9, r4)     // Catch:{ Exception -> 0x001f }
            goto L_0x0027
        L_0x001f:
            r7 = move-exception
            boolean r9 = com.mbridge.msdk.MBridgeConstans.DEBUG     // Catch:{ all -> 0x01c8 }
            if (r9 == 0) goto L_0x0027
            r7.printStackTrace()     // Catch:{ all -> 0x01c8 }
        L_0x0027:
            monitor-exit(r8)     // Catch:{ all -> 0x01c8 }
            return
        L_0x0029:
            r6.J = r3     // Catch:{ all -> 0x01c8 }
            monitor-exit(r8)     // Catch:{ all -> 0x01c8 }
            com.mbridge.msdk.reward.a.a$c r8 = r6.n     // Catch:{ Exception -> 0x01cb }
            if (r8 == 0) goto L_0x0080
            com.mbridge.msdk.reward.a.a$c r8 = r6.n     // Catch:{ Exception -> 0x01cb }
            java.util.concurrent.atomic.AtomicInteger r8 = r8.c     // Catch:{ Exception -> 0x01cb }
            int r8 = r8.get()     // Catch:{ Exception -> 0x01cb }
            if (r8 != r3) goto L_0x0080
            com.mbridge.msdk.videocommon.listener.InterVideoOutListener r7 = r6.m     // Catch:{ Exception -> 0x01cb }
            if (r7 == 0) goto L_0x0052
            com.mbridge.msdk.videocommon.listener.InterVideoOutListener r7 = r6.m     // Catch:{ Exception -> 0x004a }
            com.mbridge.msdk.out.MBridgeIds r8 = r6.q     // Catch:{ Exception -> 0x004a }
            java.lang.String r9 = "campaing is loading"
            r7.onShowFail(r8, r9)     // Catch:{ Exception -> 0x004a }
            goto L_0x0052
        L_0x004a:
            r7 = move-exception
            boolean r8 = com.mbridge.msdk.MBridgeConstans.DEBUG     // Catch:{ Exception -> 0x01cb }
            if (r8 == 0) goto L_0x0052
            r7.printStackTrace()     // Catch:{ Exception -> 0x01cb }
        L_0x0052:
            boolean r7 = r6.A     // Catch:{ Exception -> 0x01cb }
            if (r7 != 0) goto L_0x007f
            boolean r7 = r6.B     // Catch:{ Exception -> 0x01cb }
            if (r7 != 0) goto L_0x007f
            com.mbridge.msdk.videocommon.d.c r7 = r6.k     // Catch:{ Exception -> 0x01cb }
            if (r7 == 0) goto L_0x007f
            com.mbridge.msdk.videocommon.d.c r7 = r6.k     // Catch:{ Exception -> 0x01cb }
            boolean r7 = r7.s(r1)     // Catch:{ Exception -> 0x01cb }
            if (r7 == 0) goto L_0x007f
            com.mbridge.msdk.reward.a.a$c r7 = r6.n     // Catch:{ Exception -> 0x01cb }
            if (r7 == 0) goto L_0x007f
            com.mbridge.msdk.reward.a.a$c r7 = r6.n     // Catch:{ Exception -> 0x01cb }
            int r7 = r7.c.get()     // Catch:{ Exception -> 0x01cb }
            if (r7 == r3) goto L_0x007f
            com.mbridge.msdk.reward.a.a$c r7 = r6.n     // Catch:{ Exception -> 0x01cb }
            int r7 = r7.c.get()     // Catch:{ Exception -> 0x01cb }
            if (r7 == r0) goto L_0x007f
            java.lang.String r7 = ""
            r6.a((boolean) r2, (java.lang.String) r7)     // Catch:{ Exception -> 0x01cb }
        L_0x007f:
            return
        L_0x0080:
            android.content.Context r8 = r6.h     // Catch:{ Exception -> 0x01cb }
            if (r8 != 0) goto L_0x00c8
            com.mbridge.msdk.videocommon.listener.InterVideoOutListener r7 = r6.m     // Catch:{ Exception -> 0x01cb }
            if (r7 == 0) goto L_0x009a
            com.mbridge.msdk.videocommon.listener.InterVideoOutListener r7 = r6.m     // Catch:{ Exception -> 0x0092 }
            com.mbridge.msdk.out.MBridgeIds r8 = r6.q     // Catch:{ Exception -> 0x0092 }
            java.lang.String r9 = "context is null"
            r7.onShowFail(r8, r9)     // Catch:{ Exception -> 0x0092 }
            goto L_0x009a
        L_0x0092:
            r7 = move-exception
            boolean r8 = com.mbridge.msdk.MBridgeConstans.DEBUG     // Catch:{ Exception -> 0x01cb }
            if (r8 == 0) goto L_0x009a
            r7.printStackTrace()     // Catch:{ Exception -> 0x01cb }
        L_0x009a:
            boolean r7 = r6.A     // Catch:{ Exception -> 0x01cb }
            if (r7 != 0) goto L_0x00c7
            boolean r7 = r6.B     // Catch:{ Exception -> 0x01cb }
            if (r7 != 0) goto L_0x00c7
            com.mbridge.msdk.videocommon.d.c r7 = r6.k     // Catch:{ Exception -> 0x01cb }
            if (r7 == 0) goto L_0x00c7
            com.mbridge.msdk.videocommon.d.c r7 = r6.k     // Catch:{ Exception -> 0x01cb }
            boolean r7 = r7.s(r1)     // Catch:{ Exception -> 0x01cb }
            if (r7 == 0) goto L_0x00c7
            com.mbridge.msdk.reward.a.a$c r7 = r6.n     // Catch:{ Exception -> 0x01cb }
            if (r7 == 0) goto L_0x00c7
            com.mbridge.msdk.reward.a.a$c r7 = r6.n     // Catch:{ Exception -> 0x01cb }
            int r7 = r7.c.get()     // Catch:{ Exception -> 0x01cb }
            if (r7 == r3) goto L_0x00c7
            com.mbridge.msdk.reward.a.a$c r7 = r6.n     // Catch:{ Exception -> 0x01cb }
            int r7 = r7.c.get()     // Catch:{ Exception -> 0x01cb }
            if (r7 == r0) goto L_0x00c7
            java.lang.String r7 = ""
            r6.a((boolean) r2, (java.lang.String) r7)     // Catch:{ Exception -> 0x01cb }
        L_0x00c7:
            return
        L_0x00c8:
            boolean r8 = r6.A     // Catch:{ Exception -> 0x01cb }
            if (r8 == 0) goto L_0x0118
            android.content.Context r8 = r6.h     // Catch:{ Exception -> 0x01cb }
            boolean r8 = com.mbridge.msdk.foundation.tools.u.c((android.content.Context) r8)     // Catch:{ Exception -> 0x01cb }
            if (r8 != 0) goto L_0x0118
            com.mbridge.msdk.videocommon.listener.InterVideoOutListener r7 = r6.m     // Catch:{ Exception -> 0x01cb }
            if (r7 == 0) goto L_0x00ea
            com.mbridge.msdk.videocommon.listener.InterVideoOutListener r7 = r6.m     // Catch:{ Exception -> 0x00e2 }
            com.mbridge.msdk.out.MBridgeIds r8 = r6.q     // Catch:{ Exception -> 0x00e2 }
            java.lang.String r9 = "network exception"
            r7.onShowFail(r8, r9)     // Catch:{ Exception -> 0x00e2 }
            goto L_0x00ea
        L_0x00e2:
            r7 = move-exception
            boolean r8 = com.mbridge.msdk.MBridgeConstans.DEBUG     // Catch:{ Exception -> 0x01cb }
            if (r8 == 0) goto L_0x00ea
            r7.printStackTrace()     // Catch:{ Exception -> 0x01cb }
        L_0x00ea:
            boolean r7 = r6.A     // Catch:{ Exception -> 0x01cb }
            if (r7 != 0) goto L_0x0117
            boolean r7 = r6.B     // Catch:{ Exception -> 0x01cb }
            if (r7 != 0) goto L_0x0117
            com.mbridge.msdk.videocommon.d.c r7 = r6.k     // Catch:{ Exception -> 0x01cb }
            if (r7 == 0) goto L_0x0117
            com.mbridge.msdk.videocommon.d.c r7 = r6.k     // Catch:{ Exception -> 0x01cb }
            boolean r7 = r7.s(r1)     // Catch:{ Exception -> 0x01cb }
            if (r7 == 0) goto L_0x0117
            com.mbridge.msdk.reward.a.a$c r7 = r6.n     // Catch:{ Exception -> 0x01cb }
            if (r7 == 0) goto L_0x0117
            com.mbridge.msdk.reward.a.a$c r7 = r6.n     // Catch:{ Exception -> 0x01cb }
            int r7 = r7.c.get()     // Catch:{ Exception -> 0x01cb }
            if (r7 == r3) goto L_0x0117
            com.mbridge.msdk.reward.a.a$c r7 = r6.n     // Catch:{ Exception -> 0x01cb }
            int r7 = r7.c.get()     // Catch:{ Exception -> 0x01cb }
            if (r7 == r0) goto L_0x0117
            java.lang.String r7 = ""
            r6.a((boolean) r2, (java.lang.String) r7)     // Catch:{ Exception -> 0x01cb }
        L_0x0117:
            return
        L_0x0118:
            boolean r8 = r6.j()     // Catch:{ Exception -> 0x01cb }
            if (r8 == 0) goto L_0x0162
            com.mbridge.msdk.videocommon.listener.InterVideoOutListener r7 = r6.m     // Catch:{ Exception -> 0x01cb }
            if (r7 == 0) goto L_0x0134
            com.mbridge.msdk.videocommon.listener.InterVideoOutListener r7 = r6.m     // Catch:{ Exception -> 0x012c }
            com.mbridge.msdk.out.MBridgeIds r8 = r6.q     // Catch:{ Exception -> 0x012c }
            java.lang.String r9 = "Play more than limit"
            r7.onShowFail(r8, r9)     // Catch:{ Exception -> 0x012c }
            goto L_0x0134
        L_0x012c:
            r7 = move-exception
            boolean r8 = com.mbridge.msdk.MBridgeConstans.DEBUG     // Catch:{ Exception -> 0x01cb }
            if (r8 == 0) goto L_0x0134
            r7.printStackTrace()     // Catch:{ Exception -> 0x01cb }
        L_0x0134:
            boolean r7 = r6.A     // Catch:{ Exception -> 0x01cb }
            if (r7 != 0) goto L_0x0161
            boolean r7 = r6.B     // Catch:{ Exception -> 0x01cb }
            if (r7 != 0) goto L_0x0161
            com.mbridge.msdk.videocommon.d.c r7 = r6.k     // Catch:{ Exception -> 0x01cb }
            if (r7 == 0) goto L_0x0161
            com.mbridge.msdk.videocommon.d.c r7 = r6.k     // Catch:{ Exception -> 0x01cb }
            boolean r7 = r7.s(r1)     // Catch:{ Exception -> 0x01cb }
            if (r7 == 0) goto L_0x0161
            com.mbridge.msdk.reward.a.a$c r7 = r6.n     // Catch:{ Exception -> 0x01cb }
            if (r7 == 0) goto L_0x0161
            com.mbridge.msdk.reward.a.a$c r7 = r6.n     // Catch:{ Exception -> 0x01cb }
            int r7 = r7.c.get()     // Catch:{ Exception -> 0x01cb }
            if (r7 == r3) goto L_0x0161
            com.mbridge.msdk.reward.a.a$c r7 = r6.n     // Catch:{ Exception -> 0x01cb }
            int r7 = r7.c.get()     // Catch:{ Exception -> 0x01cb }
            if (r7 == r0) goto L_0x0161
            java.lang.String r7 = ""
            r6.a((boolean) r2, (java.lang.String) r7)     // Catch:{ Exception -> 0x01cb }
        L_0x0161:
            return
        L_0x0162:
            java.lang.String r8 = r6.o     // Catch:{ Exception -> 0x01cb }
            boolean r8 = android.text.TextUtils.isEmpty(r8)     // Catch:{ Exception -> 0x01cb }
            if (r8 == 0) goto L_0x0170
            java.lang.String r8 = com.mbridge.msdk.foundation.tools.m.i()     // Catch:{ Exception -> 0x01cb }
            r6.o = r8     // Catch:{ Exception -> 0x01cb }
        L_0x0170:
            java.text.SimpleDateFormat r8 = new java.text.SimpleDateFormat     // Catch:{ Exception -> 0x01c4 }
            java.lang.String r9 = "dd"
            r8.<init>(r9)     // Catch:{ Exception -> 0x01c4 }
            java.util.Date r9 = new java.util.Date     // Catch:{ Exception -> 0x01c4 }
            r9.<init>()     // Catch:{ Exception -> 0x01c4 }
            java.lang.String r8 = r8.format(r9)     // Catch:{ Exception -> 0x01c4 }
            android.content.Context r9 = r6.h     // Catch:{ Exception -> 0x01c4 }
            java.lang.String r4 = "reward_date"
            java.lang.String r5 = "0"
            java.lang.Object r9 = com.mbridge.msdk.foundation.tools.w.b(r9, r4, r5)     // Catch:{ Exception -> 0x01c4 }
            java.lang.String r9 = (java.lang.String) r9     // Catch:{ Exception -> 0x01c4 }
            boolean r4 = android.text.TextUtils.isEmpty(r9)     // Catch:{ Exception -> 0x01c4 }
            if (r4 != 0) goto L_0x01c4
            boolean r4 = android.text.TextUtils.isEmpty(r8)     // Catch:{ Exception -> 0x01c4 }
            if (r4 != 0) goto L_0x01c4
            boolean r9 = r9.equals(r8)     // Catch:{ Exception -> 0x01c4 }
            if (r9 != 0) goto L_0x01c4
            android.content.Context r9 = r6.h     // Catch:{ Exception -> 0x01c4 }
            java.lang.String r4 = "reward_date"
            com.mbridge.msdk.foundation.tools.w.a(r9, r4, r8)     // Catch:{ Exception -> 0x01c4 }
            android.content.Context r8 = r6.h     // Catch:{ Exception -> 0x01c4 }
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x01c4 }
            r9.<init>()     // Catch:{ Exception -> 0x01c4 }
            java.lang.String r4 = r6.s     // Catch:{ Exception -> 0x01c4 }
            r9.append(r4)     // Catch:{ Exception -> 0x01c4 }
            java.lang.String r4 = "_"
            r9.append(r4)     // Catch:{ Exception -> 0x01c4 }
            r9.append(r3)     // Catch:{ Exception -> 0x01c4 }
            java.lang.String r9 = r9.toString()     // Catch:{ Exception -> 0x01c4 }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r2)     // Catch:{ Exception -> 0x01c4 }
            com.mbridge.msdk.foundation.tools.w.a(r8, r9, r4)     // Catch:{ Exception -> 0x01c4 }
        L_0x01c4:
            r6.d((java.lang.String) r7)     // Catch:{ Exception -> 0x01cb }
            goto L_0x0217
        L_0x01c8:
            r7 = move-exception
            monitor-exit(r8)     // Catch:{ all -> 0x01c8 }
            throw r7     // Catch:{ Exception -> 0x01cb }
        L_0x01cb:
            r7 = move-exception
            boolean r8 = com.mbridge.msdk.MBridgeConstans.DEBUG
            if (r8 == 0) goto L_0x01d9
            java.lang.String r8 = r7.getLocalizedMessage()
            java.lang.String r9 = "RewardVideoController"
            com.mbridge.msdk.foundation.tools.q.d(r9, r8)
        L_0x01d9:
            com.mbridge.msdk.videocommon.listener.InterVideoOutListener r8 = r6.m
            if (r8 == 0) goto L_0x01ee
            com.mbridge.msdk.videocommon.listener.InterVideoOutListener r8 = r6.m     // Catch:{ Exception -> 0x01e7 }
            com.mbridge.msdk.out.MBridgeIds r9 = r6.q     // Catch:{ Exception -> 0x01e7 }
            java.lang.String r4 = "show exception"
            r8.onShowFail(r9, r4)     // Catch:{ Exception -> 0x01e7 }
            goto L_0x01ee
        L_0x01e7:
            boolean r8 = com.mbridge.msdk.MBridgeConstans.DEBUG
            if (r8 == 0) goto L_0x01ee
            r7.printStackTrace()
        L_0x01ee:
            boolean r7 = r6.A
            if (r7 != 0) goto L_0x0217
            boolean r7 = r6.B
            if (r7 != 0) goto L_0x0217
            com.mbridge.msdk.videocommon.d.c r7 = r6.k
            if (r7 == 0) goto L_0x0217
            boolean r7 = r7.s(r1)
            if (r7 == 0) goto L_0x0217
            com.mbridge.msdk.reward.a.a$c r7 = r6.n
            if (r7 == 0) goto L_0x0217
            com.mbridge.msdk.reward.a.a$c r7 = r6.n
            int r7 = r7.c.get()
            if (r7 == r3) goto L_0x0217
            com.mbridge.msdk.reward.a.a$c r7 = r6.n
            int r7 = r7.c.get()
            if (r7 == r0) goto L_0x0217
            r6.d((boolean) r2)
        L_0x0217:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.reward.a.a.a(java.lang.String, java.lang.String, java.lang.String):void");
    }

    private boolean j() {
        try {
            if (this.O == null) {
                this.O = g.a(com.mbridge.msdk.foundation.controller.a.e().g());
            }
            com.mbridge.msdk.foundation.db.h a2 = com.mbridge.msdk.foundation.db.h.a((f) this.O);
            if (this.k == null) {
                this.k = com.mbridge.msdk.videocommon.d.b.a().a(com.mbridge.msdk.foundation.controller.a.e().h(), this.p, this.A);
            }
            int d2 = this.k.d();
            if (a2 == null || !a2.a(this.p, d2)) {
                return false;
            }
            return true;
        } catch (Throwable unused) {
            q.d("RewardVideoController", "cap check error");
            return false;
        }
    }

    /* renamed from: com.mbridge.msdk.reward.a.a$a  reason: collision with other inner class name */
    /* compiled from: RewardVideoController */
    public class C0098a implements Runnable {
        private com.mbridge.msdk.reward.adapter.a b;
        private int c;
        private boolean d;

        public C0098a(com.mbridge.msdk.reward.adapter.a aVar, int i, boolean z) {
            this.b = aVar;
            this.c = i;
            this.d = z;
        }

        public final void run() {
            q.d("RewardVideoController", "adSource=" + this.c + " CommonCancelTimeTask mIsDevCall：" + this.d);
            com.mbridge.msdk.reward.b.a.b((CampaignEx) null, a.this.h, "v3 is timeout", a.this.p, a.this.B, "", "");
            a.this.c("v3 is timeout");
        }
    }

    /* compiled from: RewardVideoController */
    public class b implements com.mbridge.msdk.reward.adapter.b {
        private com.mbridge.msdk.reward.adapter.a b;
        private boolean c;
        private Runnable d;

        public b(com.mbridge.msdk.reward.adapter.a aVar, boolean z) {
            this.b = aVar;
            this.c = z;
        }

        public final void a(Runnable runnable) {
            this.d = runnable;
        }

        public final void b(String str) {
            if (this.d != null) {
                a.this.v.removeCallbacks(this.d);
            }
            if (a.this.n != null) {
                c.d(a.this.n, a.this.s, a.this.p);
            }
        }

        public final void a() {
            if (this.d != null) {
                a.this.v.removeCallbacks(this.d);
            }
            if (a.this.n != null) {
                c.a(a.this.n, a.this.s, a.this.p);
            }
        }

        public final void a(String str) {
            if (this.d != null) {
                a.this.v.removeCallbacks(this.d);
            }
            com.mbridge.msdk.reward.adapter.a aVar = this.b;
            if (aVar != null) {
                aVar.a((com.mbridge.msdk.reward.adapter.b) null);
                this.b = null;
            }
            if (a.this.n != null) {
                c.a(a.this.n, str);
            }
        }
    }

    static /* synthetic */ void j(a aVar) {
        String str;
        if (aVar.q != null) {
            if (aVar.H) {
                String a2 = aVar.a();
                if (!TextUtils.isEmpty(a2)) {
                    ConcurrentHashMap<String, String> concurrentHashMap = L;
                    if (concurrentHashMap != null && concurrentHashMap.containsKey(a2) && !TextUtils.isEmpty(L.get(a2))) {
                        str = L.get(a2);
                        aVar.q.setBidToken(str);
                    }
                } else {
                    return;
                }
            }
            str = "";
            aVar.q.setBidToken(str);
        }
    }

    static /* synthetic */ void a(a aVar, String str, List list) {
        if (list != null && list.size() > 0 && !aVar.S) {
            com.mbridge.msdk.foundation.db.e.a((f) g.a(com.mbridge.msdk.foundation.controller.a.e().g())).a((List<CampaignEx>) list, str);
        }
    }
}
