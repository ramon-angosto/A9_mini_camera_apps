package com.mbridge.msdk.mbnative.controller;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.b.c;
import com.mbridge.msdk.b.d;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.CampaignUnit;
import com.mbridge.msdk.foundation.entity.j;
import com.mbridge.msdk.foundation.tools.q;
import com.mbridge.msdk.out.Campaign;
import com.mbridge.msdk.out.Frame;
import com.mbridge.msdk.out.OnImageLoadListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: NativePreloadController */
public class b {
    private static final String d = b.class.getSimpleName();
    /* access modifiers changed from: private */
    public static Map<String, Map<Long, Object>> e = new HashMap();
    private static Map<String, Boolean> f = new HashMap();
    private static Map<String, j> g = new HashMap();
    /* access modifiers changed from: private */
    public static Map<String, Integer> h = new HashMap();
    private static Map<String, Integer> i = new HashMap();
    private static b j = null;
    private static int u = -1;
    private static int v = -2;
    Queue<Integer> a = null;
    Queue<Long> b = null;
    protected List<Integer> c;
    private c k;
    private com.mbridge.msdk.click.a l;
    private d m;
    private String n;
    /* access modifiers changed from: private */
    public Handler o;
    private int p = 0;
    private Map<String, Object> q;
    private List<Integer> r;
    private List<Integer> s;
    /* access modifiers changed from: private */
    public boolean t;
    /* access modifiers changed from: private */
    public boolean w;
    private int x;
    private int y;
    private com.mbridge.msdk.foundation.same.e.b z = new com.mbridge.msdk.foundation.same.e.b(com.mbridge.msdk.foundation.controller.a.e().g());

    public b() {
        if (Looper.myLooper() == null) {
            Looper.prepare();
        }
        this.o = new Handler() {
            public final void handleMessage(Message message) {
            }
        };
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v19, resolved type: java.util.List} */
    /* JADX WARNING: type inference failed for: r10v6, types: [java.util.List] */
    /* JADX WARNING: type inference failed for: r10v7 */
    /* JADX WARNING: Can't wrap try/catch for region: R(2:52|53) */
    /* JADX WARNING: Code restructure failed: missing block: B:163:?, code lost:
        com.mbridge.msdk.foundation.tools.q.d(d, "init cam cache failed");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:180:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:?, code lost:
        com.mbridge.msdk.foundation.tools.q.d(d, "ADNUM MUST BE INTEGER");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x0178, code lost:
        r3 = r0.get(com.mbridge.msdk.MBridgeConstans.PRELOAD_RESULT_LISTENER);
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:121:0x02d5 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:162:0x0420 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:52:0x015f */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:124:0x02e6 A[Catch:{ Exception -> 0x0431 }] */
    /* JADX WARNING: Removed duplicated region for block: B:125:0x02f0 A[Catch:{ Exception -> 0x0431 }] */
    /* JADX WARNING: Removed duplicated region for block: B:131:0x0318 A[Catch:{ all -> 0x0420 }] */
    /* JADX WARNING: Removed duplicated region for block: B:164:0x0428 A[Catch:{ Exception -> 0x0431 }] */
    /* JADX WARNING: Removed duplicated region for block: B:177:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x0221 A[Catch:{ Exception -> 0x0431 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(java.util.Map<java.lang.String, java.lang.Object> r22, int r23) {
        /*
            r21 = this;
            r11 = r21
            r0 = r22
            r12 = r23
            java.lang.String r1 = "app_key"
            java.lang.String r2 = "app_id"
            java.lang.String r3 = "preload_result_listener"
            java.lang.String r4 = "ad_num"
            java.lang.String r5 = "catetory"
            java.lang.String r6 = "ad_frame_num"
            java.lang.String r7 = "isPreloadImg"
            java.lang.String r8 = "unit_id"
            java.lang.String r9 = "_"
            r11.q = r0     // Catch:{ Exception -> 0x0431 }
            r13 = 0
            r11.w = r13     // Catch:{ Exception -> 0x0431 }
            boolean r10 = r0.containsKey(r8)     // Catch:{ Exception -> 0x0431 }
            if (r10 != 0) goto L_0x0024
            return
        L_0x0024:
            java.lang.Object r8 = r0.get(r8)     // Catch:{ Exception -> 0x0431 }
            r14 = r8
            java.lang.String r14 = (java.lang.String) r14     // Catch:{ Exception -> 0x0431 }
            int r8 = r12 + 1
            r15 = 2
            int r8 = r8 % r15
            java.util.Map<java.lang.String, java.util.Map<java.lang.Long, java.lang.Object>> r10 = e     // Catch:{ Exception -> 0x0431 }
            java.lang.StringBuilder r15 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0431 }
            r15.<init>()     // Catch:{ Exception -> 0x0431 }
            r15.append(r8)     // Catch:{ Exception -> 0x0431 }
            r15.append(r9)     // Catch:{ Exception -> 0x0431 }
            r15.append(r14)     // Catch:{ Exception -> 0x0431 }
            java.lang.String r8 = r15.toString()     // Catch:{ Exception -> 0x0431 }
            boolean r8 = r10.containsKey(r8)     // Catch:{ Exception -> 0x0431 }
            if (r8 == 0) goto L_0x0064
            java.util.Map<java.lang.String, java.util.Map<java.lang.Long, java.lang.Object>> r8 = e     // Catch:{ Exception -> 0x0431 }
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0431 }
            r10.<init>()     // Catch:{ Exception -> 0x0431 }
            r10.append(r12)     // Catch:{ Exception -> 0x0431 }
            r10.append(r9)     // Catch:{ Exception -> 0x0431 }
            r10.append(r14)     // Catch:{ Exception -> 0x0431 }
            java.lang.String r10 = r10.toString()     // Catch:{ Exception -> 0x0431 }
            boolean r8 = r8.containsKey(r10)     // Catch:{ Exception -> 0x0431 }
            if (r8 != 0) goto L_0x0064
            return
        L_0x0064:
            boolean r8 = android.text.TextUtils.isEmpty(r14)     // Catch:{ Exception -> 0x0431 }
            if (r8 == 0) goto L_0x006b
            return
        L_0x006b:
            boolean r8 = r0.containsKey(r7)     // Catch:{ Exception -> 0x0431 }
            if (r8 == 0) goto L_0x007d
            java.lang.Object r7 = r0.get(r7)     // Catch:{ Exception -> 0x0431 }
            java.lang.Boolean r7 = (java.lang.Boolean) r7     // Catch:{ Exception -> 0x0431 }
            boolean r7 = r7.booleanValue()     // Catch:{ Exception -> 0x0431 }
            r11.t = r7     // Catch:{ Exception -> 0x0431 }
        L_0x007d:
            com.mbridge.msdk.click.a r7 = r11.l     // Catch:{ Exception -> 0x0431 }
            if (r7 != 0) goto L_0x0091
            com.mbridge.msdk.click.a r7 = new com.mbridge.msdk.click.a     // Catch:{ Exception -> 0x0431 }
            com.mbridge.msdk.foundation.controller.a r8 = com.mbridge.msdk.foundation.controller.a.e()     // Catch:{ Exception -> 0x0431 }
            android.content.Context r8 = r8.g()     // Catch:{ Exception -> 0x0431 }
            r7.<init>(r8, r14)     // Catch:{ Exception -> 0x0431 }
            r11.l = r7     // Catch:{ Exception -> 0x0431 }
            goto L_0x0096
        L_0x0091:
            com.mbridge.msdk.click.a r7 = r11.l     // Catch:{ Exception -> 0x0431 }
            r7.a((java.lang.String) r14)     // Catch:{ Exception -> 0x0431 }
        L_0x0096:
            boolean r7 = r0.containsKey(r6)     // Catch:{ Exception -> 0x0431 }
            if (r7 == 0) goto L_0x00a8
            java.lang.Object r6 = r0.get(r6)     // Catch:{ Exception -> 0x0431 }
            java.lang.Integer r6 = (java.lang.Integer) r6     // Catch:{ Exception -> 0x0431 }
            int r6 = r6.intValue()     // Catch:{ Exception -> 0x0431 }
            r11.p = r6     // Catch:{ Exception -> 0x0431 }
        L_0x00a8:
            boolean r6 = r0.containsKey(r5)     // Catch:{ Exception -> 0x0431 }
            if (r6 == 0) goto L_0x00b6
            java.lang.Object r5 = r0.get(r5)     // Catch:{ Exception -> 0x0431 }
            java.lang.String r5 = (java.lang.String) r5     // Catch:{ Exception -> 0x0431 }
            r11.n = r5     // Catch:{ Exception -> 0x0431 }
        L_0x00b6:
            java.util.Map<java.lang.String, java.lang.Boolean> r5 = f     // Catch:{ Exception -> 0x0431 }
            boolean r5 = r5.containsKey(r14)     // Catch:{ Exception -> 0x0431 }
            r15 = 1
            if (r5 == 0) goto L_0x0133
            java.util.Map<java.lang.String, java.lang.Boolean> r5 = f     // Catch:{ Exception -> 0x0431 }
            java.lang.Object r5 = r5.get(r14)     // Catch:{ Exception -> 0x0431 }
            java.lang.Boolean r5 = (java.lang.Boolean) r5     // Catch:{ Exception -> 0x0431 }
            boolean r5 = r5.booleanValue()     // Catch:{ Exception -> 0x0431 }
            if (r5 == 0) goto L_0x0133
            java.util.Map<java.lang.String, java.util.Map<java.lang.Long, java.lang.Object>> r5 = e     // Catch:{ Exception -> 0x0431 }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0431 }
            r6.<init>()     // Catch:{ Exception -> 0x0431 }
            r6.append(r12)     // Catch:{ Exception -> 0x0431 }
            r6.append(r9)     // Catch:{ Exception -> 0x0431 }
            r6.append(r14)     // Catch:{ Exception -> 0x0431 }
            java.lang.String r6 = r6.toString()     // Catch:{ Exception -> 0x0431 }
            java.lang.Object r6 = r5.get(r6)     // Catch:{ Exception -> 0x0431 }
            java.util.Map r6 = (java.util.Map) r6     // Catch:{ Exception -> 0x0431 }
            com.mbridge.msdk.b.b r7 = com.mbridge.msdk.b.b.a()     // Catch:{ Exception -> 0x0431 }
            com.mbridge.msdk.foundation.controller.a r8 = com.mbridge.msdk.foundation.controller.a.e()     // Catch:{ Exception -> 0x0431 }
            java.lang.String r8 = r8.h()     // Catch:{ Exception -> 0x0431 }
            com.mbridge.msdk.b.a r7 = r7.b(r8)     // Catch:{ Exception -> 0x0431 }
            if (r6 == 0) goto L_0x0133
            int r8 = r6.size()     // Catch:{ Exception -> 0x0431 }
            if (r8 <= 0) goto L_0x0133
            java.util.Set r6 = r6.keySet()     // Catch:{ Exception -> 0x0431 }
            java.util.Iterator r6 = r6.iterator()     // Catch:{ Exception -> 0x0431 }
            java.lang.Object r6 = r6.next()     // Catch:{ Exception -> 0x0431 }
            java.lang.Long r6 = (java.lang.Long) r6     // Catch:{ Exception -> 0x0431 }
            long r8 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x0431 }
            if (r7 != 0) goto L_0x011b
            com.mbridge.msdk.b.b r7 = com.mbridge.msdk.b.b.a()     // Catch:{ Exception -> 0x0431 }
            com.mbridge.msdk.b.a r7 = r7.b()     // Catch:{ Exception -> 0x0431 }
        L_0x011b:
            long r16 = r7.B()     // Catch:{ Exception -> 0x0431 }
            r18 = 1000(0x3e8, double:4.94E-321)
            long r16 = r16 * r18
            long r6 = r6.longValue()     // Catch:{ Exception -> 0x0431 }
            long r8 = r8 - r6
            int r6 = (r8 > r16 ? 1 : (r8 == r16 ? 0 : -1))
            if (r6 < 0) goto L_0x0130
            r5.remove(r14)     // Catch:{ Exception -> 0x0431 }
            goto L_0x0133
        L_0x0130:
            if (r12 != r15) goto L_0x0133
            return
        L_0x0133:
            java.util.Map<java.lang.String, java.lang.Boolean> r5 = f     // Catch:{ Exception -> 0x0431 }
            java.lang.Boolean r6 = java.lang.Boolean.valueOf(r15)     // Catch:{ Exception -> 0x0431 }
            r5.put(r14, r6)     // Catch:{ Exception -> 0x0431 }
            r11.y = r15     // Catch:{ Exception -> 0x0431 }
            boolean r5 = r0.containsKey(r4)     // Catch:{ Exception -> 0x015f }
            if (r5 == 0) goto L_0x0166
            java.lang.Object r4 = r0.get(r4)     // Catch:{ Exception -> 0x015f }
            java.lang.Integer r4 = (java.lang.Integer) r4     // Catch:{ Exception -> 0x015f }
            int r4 = r4.intValue()     // Catch:{ Exception -> 0x015f }
            r11.y = r4     // Catch:{ Exception -> 0x015f }
            int r4 = r11.y     // Catch:{ Exception -> 0x015f }
            if (r4 >= r15) goto L_0x0156
            r11.y = r15     // Catch:{ Exception -> 0x015f }
        L_0x0156:
            int r4 = r11.y     // Catch:{ Exception -> 0x015f }
            r5 = 10
            if (r4 <= r5) goto L_0x0166
            r11.y = r5     // Catch:{ Exception -> 0x015f }
            goto L_0x0166
        L_0x015f:
            java.lang.String r4 = d     // Catch:{ Exception -> 0x0431 }
            java.lang.String r5 = "ADNUM MUST BE INTEGER"
            com.mbridge.msdk.foundation.tools.q.d(r4, r5)     // Catch:{ Exception -> 0x0431 }
        L_0x0166:
            java.util.Map<java.lang.String, java.lang.Integer> r4 = h     // Catch:{ Exception -> 0x0431 }
            int r5 = r11.y     // Catch:{ Exception -> 0x0431 }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ Exception -> 0x0431 }
            r4.put(r14, r5)     // Catch:{ Exception -> 0x0431 }
            boolean r4 = r0.containsKey(r3)     // Catch:{ Exception -> 0x0431 }
            r10 = 0
            if (r4 == 0) goto L_0x0187
            java.lang.Object r3 = r0.get(r3)     // Catch:{ Exception -> 0x0431 }
            if (r3 == 0) goto L_0x0187
            com.mbridge.msdk.out.PreloadListener r3 = (com.mbridge.msdk.out.PreloadListener) r3     // Catch:{ Exception -> 0x0431 }
            com.mbridge.msdk.a.a.a r4 = new com.mbridge.msdk.a.a.a     // Catch:{ Exception -> 0x0431 }
            r4.<init>(r3)     // Catch:{ Exception -> 0x0431 }
            r9 = r4
            goto L_0x0188
        L_0x0187:
            r9 = r10
        L_0x0188:
            boolean r3 = r0.containsKey(r2)     // Catch:{ Exception -> 0x0431 }
            if (r3 == 0) goto L_0x01a9
            boolean r3 = r0.containsKey(r1)     // Catch:{ Exception -> 0x0431 }
            if (r3 == 0) goto L_0x01a9
            java.lang.String r3 = "key_word"
            boolean r3 = r0.containsKey(r3)     // Catch:{ Exception -> 0x0431 }
            if (r3 == 0) goto L_0x01a9
            java.lang.Object r2 = r0.get(r2)     // Catch:{ Exception -> 0x0431 }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ Exception -> 0x0431 }
            java.lang.Object r1 = r0.get(r1)     // Catch:{ Exception -> 0x0431 }
            java.lang.String r1 = (java.lang.String) r1     // Catch:{ Exception -> 0x0431 }
            goto L_0x01ab
        L_0x01a9:
            r1 = r10
            r2 = r1
        L_0x01ab:
            com.mbridge.msdk.b.c r3 = r11.k     // Catch:{ Exception -> 0x0431 }
            if (r3 != 0) goto L_0x01b6
            com.mbridge.msdk.b.c r3 = new com.mbridge.msdk.b.c     // Catch:{ Exception -> 0x0431 }
            r3.<init>()     // Catch:{ Exception -> 0x0431 }
            r11.k = r3     // Catch:{ Exception -> 0x0431 }
        L_0x01b6:
            com.mbridge.msdk.b.c r3 = r11.k     // Catch:{ Exception -> 0x0431 }
            com.mbridge.msdk.foundation.controller.a r4 = com.mbridge.msdk.foundation.controller.a.e()     // Catch:{ Exception -> 0x0431 }
            android.content.Context r4 = r4.g()     // Catch:{ Exception -> 0x0431 }
            r3.a((android.content.Context) r4, (java.lang.String) r2, (java.lang.String) r1, (java.lang.String) r14)     // Catch:{ Exception -> 0x0431 }
            com.mbridge.msdk.b.b r1 = com.mbridge.msdk.b.b.a()     // Catch:{ Exception -> 0x0431 }
            com.mbridge.msdk.b.d r1 = r1.e(r2, r14)     // Catch:{ Exception -> 0x0431 }
            r11.m = r1     // Catch:{ Exception -> 0x0431 }
            com.mbridge.msdk.b.d r1 = r11.m     // Catch:{ Exception -> 0x0431 }
            if (r1 != 0) goto L_0x01d7
            com.mbridge.msdk.b.d r1 = com.mbridge.msdk.b.d.d(r14)     // Catch:{ Exception -> 0x0431 }
            r11.m = r1     // Catch:{ Exception -> 0x0431 }
        L_0x01d7:
            java.lang.String r1 = com.mbridge.msdk.MBridgeConstans.PLACEMENT_ID     // Catch:{ Exception -> 0x0431 }
            boolean r1 = r0.containsKey(r1)     // Catch:{ Exception -> 0x0431 }
            java.lang.String r8 = ""
            if (r1 == 0) goto L_0x01fb
            java.lang.String r1 = com.mbridge.msdk.MBridgeConstans.PLACEMENT_ID     // Catch:{ Exception -> 0x0431 }
            java.lang.Object r1 = r0.get(r1)     // Catch:{ Exception -> 0x0431 }
            if (r1 == 0) goto L_0x01fb
            java.lang.String r1 = com.mbridge.msdk.MBridgeConstans.PLACEMENT_ID     // Catch:{ Exception -> 0x0431 }
            java.lang.Object r1 = r0.get(r1)     // Catch:{ Exception -> 0x0431 }
            java.lang.String r1 = (java.lang.String) r1     // Catch:{ Exception -> 0x0431 }
            boolean r2 = android.text.TextUtils.isEmpty(r1)     // Catch:{ Exception -> 0x0431 }
            if (r2 == 0) goto L_0x01f8
            goto L_0x01fb
        L_0x01f8:
            r16 = r1
            goto L_0x01fd
        L_0x01fb:
            r16 = r8
        L_0x01fd:
            com.mbridge.msdk.b.d r1 = r11.m     // Catch:{ Exception -> 0x0431 }
            java.util.List r1 = r1.q()     // Catch:{ Exception -> 0x0431 }
            r11.r = r1     // Catch:{ Exception -> 0x0431 }
            com.mbridge.msdk.b.d r1 = r11.m     // Catch:{ Exception -> 0x0431 }
            java.util.List r1 = r1.r()     // Catch:{ Exception -> 0x0431 }
            r11.c = r1     // Catch:{ Exception -> 0x0431 }
            com.mbridge.msdk.b.d r1 = r11.m     // Catch:{ Exception -> 0x0431 }
            java.util.List r1 = r1.r()     // Catch:{ Exception -> 0x0431 }
            r11.s = r1     // Catch:{ Exception -> 0x0431 }
            java.util.List<java.lang.Integer> r1 = r11.r     // Catch:{ Exception -> 0x0431 }
            if (r1 == 0) goto L_0x0428
            java.util.List<java.lang.Integer> r1 = r11.r     // Catch:{ Exception -> 0x0431 }
            int r1 = r1.size()     // Catch:{ Exception -> 0x0431 }
            if (r1 <= 0) goto L_0x0428
            java.util.LinkedList r1 = new java.util.LinkedList     // Catch:{ Exception -> 0x0431 }
            r1.<init>()     // Catch:{ Exception -> 0x0431 }
            r11.a = r1     // Catch:{ Exception -> 0x0431 }
            java.util.List<java.lang.Integer> r1 = r11.r     // Catch:{ Exception -> 0x0431 }
            java.util.Iterator r1 = r1.iterator()     // Catch:{ Exception -> 0x0431 }
        L_0x022e:
            boolean r2 = r1.hasNext()     // Catch:{ Exception -> 0x0431 }
            if (r2 == 0) goto L_0x0240
            java.lang.Object r2 = r1.next()     // Catch:{ Exception -> 0x0431 }
            java.lang.Integer r2 = (java.lang.Integer) r2     // Catch:{ Exception -> 0x0431 }
            java.util.Queue<java.lang.Integer> r3 = r11.a     // Catch:{ Exception -> 0x0431 }
            r3.add(r2)     // Catch:{ Exception -> 0x0431 }
            goto L_0x022e
        L_0x0240:
            java.util.List<java.lang.Integer> r1 = r11.s     // Catch:{ Exception -> 0x0431 }
            if (r1 == 0) goto L_0x0276
            java.util.List<java.lang.Integer> r1 = r11.s     // Catch:{ Exception -> 0x0431 }
            int r1 = r1.size()     // Catch:{ Exception -> 0x0431 }
            if (r1 <= 0) goto L_0x0276
            java.util.LinkedList r1 = new java.util.LinkedList     // Catch:{ Exception -> 0x0431 }
            r1.<init>()     // Catch:{ Exception -> 0x0431 }
            r11.b = r1     // Catch:{ Exception -> 0x0431 }
            java.util.List<java.lang.Integer> r1 = r11.s     // Catch:{ Exception -> 0x0431 }
            java.util.Iterator r1 = r1.iterator()     // Catch:{ Exception -> 0x0431 }
        L_0x0259:
            boolean r2 = r1.hasNext()     // Catch:{ Exception -> 0x0431 }
            if (r2 == 0) goto L_0x0276
            java.lang.Object r2 = r1.next()     // Catch:{ Exception -> 0x0431 }
            java.lang.Integer r2 = (java.lang.Integer) r2     // Catch:{ Exception -> 0x0431 }
            java.util.Queue<java.lang.Long> r3 = r11.b     // Catch:{ Exception -> 0x0431 }
            int r2 = r2.intValue()     // Catch:{ Exception -> 0x0431 }
            int r2 = r2 * 1000
            long r4 = (long) r2     // Catch:{ Exception -> 0x0431 }
            java.lang.Long r2 = java.lang.Long.valueOf(r4)     // Catch:{ Exception -> 0x0431 }
            r3.add(r2)     // Catch:{ Exception -> 0x0431 }
            goto L_0x0259
        L_0x0276:
            java.util.List<java.lang.Integer> r1 = r11.r     // Catch:{ Exception -> 0x0431 }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r15)     // Catch:{ Exception -> 0x0431 }
            boolean r1 = r1.contains(r2)     // Catch:{ Exception -> 0x0431 }
            if (r1 == 0) goto L_0x02d1
            if (r12 != 0) goto L_0x02d1
            java.util.List<java.lang.Integer> r1 = r11.c     // Catch:{ Exception -> 0x02d1 }
            java.util.List<java.lang.Integer> r2 = r11.r     // Catch:{ Exception -> 0x02d1 }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r15)     // Catch:{ Exception -> 0x02d1 }
            int r2 = r2.indexOf(r3)     // Catch:{ Exception -> 0x02d1 }
            java.lang.Object r1 = r1.get(r2)     // Catch:{ Exception -> 0x02d1 }
            java.lang.Integer r1 = (java.lang.Integer) r1     // Catch:{ Exception -> 0x02d1 }
            int r1 = r1.intValue()     // Catch:{ Exception -> 0x02d1 }
            int r1 = r1 * 1000
            long r3 = (long) r1     // Catch:{ Exception -> 0x02d1 }
            r2 = 1
            com.mbridge.msdk.b.d r6 = r11.m     // Catch:{ Exception -> 0x02d1 }
            r17 = 0
            r1 = r21
            r5 = r23
            r7 = r14
            r20 = r8
            r8 = r16
            r18 = r9
            r10 = r17
            r1.a((int) r2, (long) r3, (int) r5, (com.mbridge.msdk.b.d) r6, (java.lang.String) r7, (java.lang.String) r8, (com.mbridge.msdk.a.a.a) r9, (boolean) r10)     // Catch:{ Exception -> 0x02cd }
            com.mbridge.msdk.mbnative.a.b r1 = com.mbridge.msdk.mbnative.a.c.a(r15)     // Catch:{ Exception -> 0x02cd }
            if (r1 == 0) goto L_0x02cd
            java.lang.Object r1 = r1.b(r14, r13)     // Catch:{ Exception -> 0x02cd }
            java.util.List r1 = (java.util.List) r1     // Catch:{ Exception -> 0x02cd }
            if (r1 == 0) goto L_0x02cd
            int r1 = r1.size()     // Catch:{ Exception -> 0x02cd }
            if (r1 <= 0) goto L_0x02cd
            r10 = r18
            r7 = 0
            r11.a((boolean) r15, (com.mbridge.msdk.a.a.a) r10, (java.lang.String) r7)     // Catch:{ Exception -> 0x02d5 }
            goto L_0x02d5
        L_0x02cd:
            r10 = r18
            r7 = 0
            goto L_0x02d5
        L_0x02d1:
            r20 = r8
            r7 = r10
            r10 = r9
        L_0x02d5:
            com.mbridge.msdk.b.d r3 = r11.m     // Catch:{ Exception -> 0x0431 }
            r1 = r21
            r2 = r23
            r4 = r14
            r5 = r16
            r6 = r10
            r1.a((int) r2, (com.mbridge.msdk.b.d) r3, (java.lang.String) r4, (java.lang.String) r5, (com.mbridge.msdk.a.a.a) r6)     // Catch:{ Exception -> 0x0431 }
            com.mbridge.msdk.b.d r1 = r11.m     // Catch:{ Exception -> 0x0431 }
            if (r1 == 0) goto L_0x02f0
            com.mbridge.msdk.b.d r1 = r11.m     // Catch:{ Exception -> 0x0431 }
            int r1 = r1.u()     // Catch:{ Exception -> 0x0431 }
            int r2 = r11.y     // Catch:{ Exception -> 0x0431 }
            int r1 = r1 * r2
            goto L_0x02f1
        L_0x02f0:
            r1 = r15
        L_0x02f1:
            java.util.Map<java.lang.String, java.lang.Integer> r2 = i     // Catch:{ Exception -> 0x0431 }
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch:{ Exception -> 0x0431 }
            r2.put(r14, r1)     // Catch:{ Exception -> 0x0431 }
            java.lang.String r1 = "com.mbridge.msdk.nativex.view.MBMediaView"
            java.lang.Class.forName(r1)     // Catch:{ all -> 0x0420 }
            java.lang.String r1 = "com.mbridge.msdk.videocommon.download.c"
            java.lang.Class.forName(r1)     // Catch:{ all -> 0x0420 }
            com.mbridge.msdk.foundation.controller.a r1 = com.mbridge.msdk.foundation.controller.a.e()     // Catch:{ all -> 0x0420 }
            android.content.Context r1 = r1.g()     // Catch:{ all -> 0x0420 }
            com.mbridge.msdk.mbnative.controller.c.a(r1, r14)     // Catch:{ all -> 0x0420 }
            com.mbridge.msdk.foundation.tools.o.b()     // Catch:{ all -> 0x0420 }
            boolean r1 = android.text.TextUtils.isEmpty(r14)     // Catch:{ all -> 0x0420 }
            if (r1 != 0) goto L_0x043b
            com.mbridge.msdk.foundation.controller.a r1 = com.mbridge.msdk.foundation.controller.a.e()     // Catch:{ all -> 0x0420 }
            android.content.Context r1 = r1.g()     // Catch:{ all -> 0x0420 }
            com.mbridge.msdk.foundation.db.g r1 = com.mbridge.msdk.foundation.db.g.a((android.content.Context) r1)     // Catch:{ all -> 0x0420 }
            com.mbridge.msdk.foundation.db.e r1 = com.mbridge.msdk.foundation.db.e.a((com.mbridge.msdk.foundation.db.f) r1)     // Catch:{ all -> 0x0420 }
            r1.a()     // Catch:{ all -> 0x0420 }
            java.lang.String r1 = "native_info"
            boolean r1 = r0.containsKey(r1)     // Catch:{ all -> 0x0420 }
            if (r1 == 0) goto L_0x033d
            java.lang.String r1 = "native_info"
            java.lang.Object r0 = r0.get(r1)     // Catch:{ all -> 0x0420 }
            r10 = r0
            java.lang.String r10 = (java.lang.String) r10     // Catch:{ all -> 0x0420 }
            goto L_0x033e
        L_0x033d:
            r10 = r7
        L_0x033e:
            int r0 = r11.a((java.lang.String) r10)     // Catch:{ all -> 0x0420 }
            if (r0 > 0) goto L_0x0346
            int r0 = r11.y     // Catch:{ all -> 0x0420 }
        L_0x0346:
            com.mbridge.msdk.b.b r1 = com.mbridge.msdk.b.b.a()     // Catch:{ all -> 0x0420 }
            r2 = r20
            com.mbridge.msdk.b.d r1 = r1.e(r2, r14)     // Catch:{ all -> 0x0420 }
            r11.m = r1     // Catch:{ all -> 0x0420 }
            com.mbridge.msdk.b.d r1 = r11.m     // Catch:{ all -> 0x0420 }
            if (r1 != 0) goto L_0x035c
            com.mbridge.msdk.b.d r1 = com.mbridge.msdk.b.d.d(r14)     // Catch:{ all -> 0x0420 }
            r11.m = r1     // Catch:{ all -> 0x0420 }
        L_0x035c:
            com.mbridge.msdk.b.d r1 = r11.m     // Catch:{ all -> 0x0420 }
            java.util.List r1 = r1.q()     // Catch:{ all -> 0x0420 }
            r11.r = r1     // Catch:{ all -> 0x0420 }
            java.util.List<java.lang.Integer> r1 = r11.r     // Catch:{ all -> 0x0420 }
            if (r1 == 0) goto L_0x038a
            java.util.List<java.lang.Integer> r1 = r11.r     // Catch:{ all -> 0x0420 }
            int r1 = r1.size()     // Catch:{ all -> 0x0420 }
            if (r1 <= 0) goto L_0x038a
            java.util.List<java.lang.Integer> r1 = r11.r     // Catch:{ all -> 0x0420 }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r15)     // Catch:{ all -> 0x0420 }
            boolean r1 = r1.contains(r2)     // Catch:{ all -> 0x0420 }
            if (r1 == 0) goto L_0x038a
            com.mbridge.msdk.mbnative.a.b r1 = com.mbridge.msdk.mbnative.a.c.a(r15)     // Catch:{ all -> 0x0420 }
            if (r1 == 0) goto L_0x038a
            java.lang.Object r0 = r1.b(r14, r0)     // Catch:{ all -> 0x0420 }
            r10 = r0
            java.util.List r10 = (java.util.List) r10     // Catch:{ all -> 0x0420 }
            goto L_0x038b
        L_0x038a:
            r10 = r7
        L_0x038b:
            if (r10 == 0) goto L_0x043b
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch:{ all -> 0x0420 }
            r0.<init>()     // Catch:{ all -> 0x0420 }
            r1 = r13
        L_0x0393:
            int r2 = r10.size()     // Catch:{ all -> 0x0420 }
            if (r1 >= r2) goto L_0x03af
            java.lang.Object r2 = r10.get(r1)     // Catch:{ all -> 0x0420 }
            com.mbridge.msdk.foundation.entity.CampaignEx r2 = (com.mbridge.msdk.foundation.entity.CampaignEx) r2     // Catch:{ all -> 0x0420 }
            java.lang.String r3 = r2.getVideoUrlEncode()     // Catch:{ all -> 0x0420 }
            boolean r3 = android.text.TextUtils.isEmpty(r3)     // Catch:{ all -> 0x0420 }
            if (r3 != 0) goto L_0x03ac
            r0.add(r2)     // Catch:{ all -> 0x0420 }
        L_0x03ac:
            int r1 = r1 + 1
            goto L_0x0393
        L_0x03af:
            int r1 = r0.size()     // Catch:{ all -> 0x0420 }
            if (r1 <= 0) goto L_0x043b
            java.lang.String r1 = "com.mbridge.msdk.videocommon.download.c"
            java.lang.Class r1 = java.lang.Class.forName(r1)     // Catch:{ all -> 0x0420 }
            java.lang.String r2 = "getInstance"
            java.lang.Class[] r3 = new java.lang.Class[r13]     // Catch:{ all -> 0x0420 }
            java.lang.reflect.Method r2 = r1.getMethod(r2, r3)     // Catch:{ all -> 0x0420 }
            java.lang.Object[] r3 = new java.lang.Object[r13]     // Catch:{ all -> 0x0420 }
            java.lang.Object r2 = r2.invoke(r7, r3)     // Catch:{ all -> 0x0420 }
            java.lang.String r3 = "com.mbridge.msdk.videocommon.listener.a"
            java.lang.Class r3 = java.lang.Class.forName(r3)     // Catch:{ all -> 0x0420 }
            java.lang.String r4 = "createUnitCache"
            r5 = 5
            java.lang.Class[] r5 = new java.lang.Class[r5]     // Catch:{ all -> 0x0420 }
            java.lang.Class<android.content.Context> r6 = android.content.Context.class
            r5[r13] = r6     // Catch:{ all -> 0x0420 }
            java.lang.Class<java.lang.String> r6 = java.lang.String.class
            r5[r15] = r6     // Catch:{ all -> 0x0420 }
            java.lang.Class<java.util.List> r6 = java.util.List.class
            r8 = 2
            r5[r8] = r6     // Catch:{ all -> 0x0420 }
            r6 = 3
            java.lang.Class r8 = java.lang.Integer.TYPE     // Catch:{ all -> 0x0420 }
            r5[r6] = r8     // Catch:{ all -> 0x0420 }
            r6 = 4
            r5[r6] = r3     // Catch:{ all -> 0x0420 }
            java.lang.reflect.Method r3 = r1.getMethod(r4, r5)     // Catch:{ all -> 0x0420 }
            r4 = 5
            java.lang.Object[] r4 = new java.lang.Object[r4]     // Catch:{ all -> 0x0420 }
            com.mbridge.msdk.foundation.controller.a r5 = com.mbridge.msdk.foundation.controller.a.e()     // Catch:{ all -> 0x0420 }
            android.content.Context r5 = r5.g()     // Catch:{ all -> 0x0420 }
            r4[r13] = r5     // Catch:{ all -> 0x0420 }
            r4[r15] = r14     // Catch:{ all -> 0x0420 }
            r5 = 2
            r4[r5] = r0     // Catch:{ all -> 0x0420 }
            r0 = 3
            java.lang.Integer r5 = java.lang.Integer.valueOf(r15)     // Catch:{ all -> 0x0420 }
            r4[r0] = r5     // Catch:{ all -> 0x0420 }
            r0 = 4
            r4[r0] = r7     // Catch:{ all -> 0x0420 }
            r3.invoke(r2, r4)     // Catch:{ all -> 0x0420 }
            java.lang.String r0 = "load"
            java.lang.Class[] r3 = new java.lang.Class[r15]     // Catch:{ all -> 0x0420 }
            java.lang.Class<java.lang.String> r4 = java.lang.String.class
            r3[r13] = r4     // Catch:{ all -> 0x0420 }
            java.lang.reflect.Method r0 = r1.getMethod(r0, r3)     // Catch:{ all -> 0x0420 }
            java.lang.Object[] r1 = new java.lang.Object[r15]     // Catch:{ all -> 0x0420 }
            r1[r13] = r14     // Catch:{ all -> 0x0420 }
            r0.invoke(r2, r1)     // Catch:{ all -> 0x0420 }
            goto L_0x043b
        L_0x0420:
            java.lang.String r0 = d     // Catch:{ Exception -> 0x0431 }
            java.lang.String r1 = "init cam cache failed"
            com.mbridge.msdk.foundation.tools.q.d(r0, r1)     // Catch:{ Exception -> 0x0431 }
            goto L_0x043b
        L_0x0428:
            r10 = r9
            if (r10 == 0) goto L_0x0430
            java.lang.String r0 = "don't have sorceList"
            r10.onPreloadFaild(r0)     // Catch:{ Exception -> 0x0431 }
        L_0x0430:
            return
        L_0x0431:
            r0 = move-exception
            java.lang.String r1 = d
            java.lang.String r0 = com.mbridge.msdk.mbnative.b.a.a(r0)
            com.mbridge.msdk.foundation.tools.q.d(r1, r0)
        L_0x043b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.mbnative.controller.b.a(java.util.Map, int):void");
    }

    private int a(String str) {
        if (str == null) {
            return 0;
        }
        try {
            JSONArray jSONArray = new JSONArray(str);
            if (jSONArray.length() > 0) {
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    JSONObject jSONObject = (JSONObject) jSONArray.opt(i2);
                    if (2 == jSONObject.optInt("id", 0)) {
                        return jSONObject.optInt("ad_num");
                    }
                }
            }
        } catch (Exception e2) {
            q.d(d, com.mbridge.msdk.mbnative.b.a.a(e2));
        }
        return 0;
    }

    private void a(int i2, d dVar, String str, String str2, com.mbridge.msdk.a.a.a aVar) {
        Queue<Integer> queue = this.a;
        if (queue != null && queue.size() > 0) {
            try {
                int intValue = this.a.poll().intValue();
                long j2 = (long) MBridgeConstans.REQUEST_TIME_OUT;
                if (this.b != null && this.b.size() > 0) {
                    j2 = this.b.poll().longValue();
                }
                String str3 = d;
                q.b(str3, "preload start queue adsource = " + intValue);
                a(intValue, j2, str, str2, this.q, i2, dVar, aVar);
            } catch (Throwable unused) {
                q.d(d, "queue poll exception");
            }
        }
    }

    private void a(int i2, long j2, String str, String str2, Map<String, Object> map, int i3, d dVar, com.mbridge.msdk.a.a.a aVar) {
        com.mbridge.msdk.mbnative.a.b<String, List<Campaign>> a2;
        int i4 = i2;
        if (i4 == 1 || (a2 = com.mbridge.msdk.mbnative.a.c.a(i2)) == null) {
            String str3 = str;
        } else {
            String str4 = str;
            List b2 = a2.b(str, this.y);
            if (b2 != null && b2.size() > 0) {
                a(true, aVar, (String) null);
                return;
            }
        }
        com.mbridge.msdk.a.a.a aVar2 = aVar;
        if (i4 == 1) {
            a(i2, j2, i3, dVar, str, str2, aVar, true);
        } else if (i4 != 2) {
            a(i2, j2, i3, dVar, str, str2, aVar, false);
        } else {
            a(2, j2, i3, dVar, str, str2, aVar, false);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v95, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v4, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v22, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v5, resolved type: java.lang.String} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:129:0x02b9 A[Catch:{ Exception -> 0x049b }] */
    /* JADX WARNING: Removed duplicated region for block: B:132:0x02c8 A[Catch:{ Exception -> 0x049b }] */
    /* JADX WARNING: Removed duplicated region for block: B:139:0x02f5 A[Catch:{ Exception -> 0x049b }] */
    /* JADX WARNING: Removed duplicated region for block: B:146:0x030a A[Catch:{ Exception -> 0x049b }] */
    /* JADX WARNING: Removed duplicated region for block: B:150:0x0315  */
    /* JADX WARNING: Removed duplicated region for block: B:154:0x032d A[Catch:{ Exception -> 0x049b }] */
    /* JADX WARNING: Removed duplicated region for block: B:156:0x0330 A[Catch:{ Exception -> 0x049b }] */
    /* JADX WARNING: Removed duplicated region for block: B:159:0x037f A[Catch:{ Exception -> 0x049b }] */
    /* JADX WARNING: Removed duplicated region for block: B:162:0x038a A[Catch:{ Exception -> 0x049b }] */
    /* JADX WARNING: Removed duplicated region for block: B:179:0x044f A[Catch:{ Exception -> 0x049b }] */
    /* JADX WARNING: Removed duplicated region for block: B:183:0x0473 A[Catch:{ Exception -> 0x049b }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(int r25, long r26, int r28, com.mbridge.msdk.b.d r29, java.lang.String r30, java.lang.String r31, com.mbridge.msdk.a.a.a r32, boolean r33) {
        /*
            r24 = this;
            r8 = r24
            r1 = r25
            r9 = r28
            r10 = r30
            r7 = r31
            r11 = r32
            r12 = r33
            java.lang.String r2 = "native_video_height"
            java.lang.String r3 = "native_video_width"
            java.lang.String r0 = "app_key"
            java.lang.String r4 = "1"
            java.lang.String r5 = "native_info"
            java.lang.String r6 = "key_word"
            com.mbridge.msdk.foundation.controller.a r13 = com.mbridge.msdk.foundation.controller.a.e()     // Catch:{ Exception -> 0x049b }
            android.content.Context r13 = r13.g()     // Catch:{ Exception -> 0x049b }
            com.mbridge.msdk.foundation.db.g r13 = com.mbridge.msdk.foundation.db.g.a((android.content.Context) r13)     // Catch:{ Exception -> 0x049b }
            com.mbridge.msdk.foundation.db.e r13 = com.mbridge.msdk.foundation.db.e.a((com.mbridge.msdk.foundation.db.f) r13)     // Catch:{ Exception -> 0x049b }
            r13.a()     // Catch:{ Exception -> 0x049b }
            com.mbridge.msdk.b.d r13 = r8.m     // Catch:{ Exception -> 0x049b }
            int r13 = r13.o()     // Catch:{ Exception -> 0x049b }
            com.mbridge.msdk.b.d r14 = r8.m     // Catch:{ Exception -> 0x049b }
            int r14 = r14.p()     // Catch:{ Exception -> 0x049b }
            com.mbridge.msdk.mbnative.e.a.a r15 = new com.mbridge.msdk.mbnative.e.a.a     // Catch:{ Exception -> 0x049b }
            com.mbridge.msdk.foundation.controller.a r16 = com.mbridge.msdk.foundation.controller.a.e()     // Catch:{ Exception -> 0x049b }
            r29 = r14
            android.content.Context r14 = r16.g()     // Catch:{ Exception -> 0x049b }
            r15.<init>(r14)     // Catch:{ Exception -> 0x049b }
            com.mbridge.msdk.foundation.same.net.h.d r14 = new com.mbridge.msdk.foundation.same.net.h.d     // Catch:{ Exception -> 0x049b }
            r14.<init>()     // Catch:{ Exception -> 0x049b }
            com.mbridge.msdk.foundation.controller.a r16 = com.mbridge.msdk.foundation.controller.a.e()     // Catch:{ Exception -> 0x049b }
            java.lang.String r16 = r16.h()     // Catch:{ Exception -> 0x049b }
            com.mbridge.msdk.foundation.controller.a r17 = com.mbridge.msdk.foundation.controller.a.e()     // Catch:{ Exception -> 0x049b }
            java.lang.String r17 = r17.i()     // Catch:{ Exception -> 0x049b }
            r18 = r15
            java.util.Map<java.lang.String, java.lang.Object> r15 = r8.q     // Catch:{ Exception -> 0x049b }
            r19 = r2
            java.lang.String r2 = "app_id"
            if (r15 == 0) goto L_0x00d2
            java.util.Map<java.lang.String, java.lang.Object> r15 = r8.q     // Catch:{ Exception -> 0x049b }
            boolean r15 = r15.containsKey(r2)     // Catch:{ Exception -> 0x049b }
            if (r15 == 0) goto L_0x00d2
            java.util.Map<java.lang.String, java.lang.Object> r15 = r8.q     // Catch:{ Exception -> 0x049b }
            boolean r15 = r15.containsKey(r0)     // Catch:{ Exception -> 0x049b }
            if (r15 == 0) goto L_0x00d2
            java.util.Map<java.lang.String, java.lang.Object> r15 = r8.q     // Catch:{ Exception -> 0x049b }
            boolean r15 = r15.containsKey(r6)     // Catch:{ Exception -> 0x049b }
            if (r15 == 0) goto L_0x00d2
            java.util.Map<java.lang.String, java.lang.Object> r15 = r8.q     // Catch:{ Exception -> 0x049b }
            java.lang.Object r15 = r15.get(r6)     // Catch:{ Exception -> 0x049b }
            if (r15 == 0) goto L_0x00d2
            java.util.Map<java.lang.String, java.lang.Object> r15 = r8.q     // Catch:{ Exception -> 0x049b }
            java.lang.Object r15 = r15.get(r2)     // Catch:{ Exception -> 0x049b }
            boolean r15 = r15 instanceof java.lang.String     // Catch:{ Exception -> 0x049b }
            if (r15 == 0) goto L_0x009b
            java.util.Map<java.lang.String, java.lang.Object> r15 = r8.q     // Catch:{ Exception -> 0x049b }
            java.lang.Object r15 = r15.get(r2)     // Catch:{ Exception -> 0x049b }
            r16 = r15
            java.lang.String r16 = (java.lang.String) r16     // Catch:{ Exception -> 0x049b }
        L_0x009b:
            java.util.Map<java.lang.String, java.lang.Object> r15 = r8.q     // Catch:{ Exception -> 0x049b }
            java.lang.Object r15 = r15.get(r0)     // Catch:{ Exception -> 0x049b }
            boolean r15 = r15 instanceof java.lang.String     // Catch:{ Exception -> 0x049b }
            if (r15 == 0) goto L_0x00af
            java.util.Map<java.lang.String, java.lang.Object> r15 = r8.q     // Catch:{ Exception -> 0x049b }
            java.lang.Object r0 = r15.get(r0)     // Catch:{ Exception -> 0x049b }
            r17 = r0
            java.lang.String r17 = (java.lang.String) r17     // Catch:{ Exception -> 0x049b }
        L_0x00af:
            java.util.Map<java.lang.String, java.lang.Object> r0 = r8.q     // Catch:{ Exception -> 0x049b }
            java.lang.Object r0 = r0.get(r6)     // Catch:{ Exception -> 0x049b }
            boolean r0 = r0 instanceof java.lang.String     // Catch:{ Exception -> 0x049b }
            if (r0 == 0) goto L_0x00c2
            java.util.Map<java.lang.String, java.lang.Object> r0 = r8.q     // Catch:{ Exception -> 0x049b }
            java.lang.Object r0 = r0.get(r6)     // Catch:{ Exception -> 0x049b }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ Exception -> 0x049b }
            goto L_0x00c3
        L_0x00c2:
            r0 = 0
        L_0x00c3:
            boolean r6 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x049b }
            if (r6 != 0) goto L_0x00d2
            java.lang.String r6 = "smart"
            java.lang.String r0 = com.mbridge.msdk.foundation.tools.l.a((java.lang.String) r0)     // Catch:{ Exception -> 0x049b }
            r14.a(r6, r0)     // Catch:{ Exception -> 0x049b }
        L_0x00d2:
            r0 = r16
            r6 = r17
            r14.a(r2, r0)     // Catch:{ Exception -> 0x049b }
            java.lang.String r2 = "unit_id"
            r14.a(r2, r10)     // Catch:{ Exception -> 0x049b }
            java.lang.String r2 = "req_type"
            r14.a(r2, r4)     // Catch:{ Exception -> 0x049b }
            java.lang.String r2 = r8.n     // Catch:{ Exception -> 0x049b }
            boolean r2 = android.text.TextUtils.isEmpty(r2)     // Catch:{ Exception -> 0x049b }
            if (r2 != 0) goto L_0x00f2
            java.lang.String r2 = "category"
            java.lang.String r15 = r8.n     // Catch:{ Exception -> 0x049b }
            r14.a(r2, r15)     // Catch:{ Exception -> 0x049b }
        L_0x00f2:
            boolean r2 = android.text.TextUtils.isEmpty(r31)     // Catch:{ Exception -> 0x049b }
            if (r2 != 0) goto L_0x00fd
            java.lang.String r2 = com.mbridge.msdk.MBridgeConstans.PLACEMENT_ID     // Catch:{ Exception -> 0x049b }
            r14.a(r2, r7)     // Catch:{ Exception -> 0x049b }
        L_0x00fd:
            java.lang.String r2 = "sign"
            java.lang.StringBuilder r15 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x049b }
            r15.<init>()     // Catch:{ Exception -> 0x049b }
            r15.append(r0)     // Catch:{ Exception -> 0x049b }
            r15.append(r6)     // Catch:{ Exception -> 0x049b }
            java.lang.String r0 = r15.toString()     // Catch:{ Exception -> 0x049b }
            java.lang.String r0 = com.mbridge.msdk.foundation.tools.SameMD5.getMD5(r0)     // Catch:{ Exception -> 0x049b }
            r14.a(r2, r0)     // Catch:{ Exception -> 0x049b }
            java.lang.String r0 = "only_impression"
            r14.a(r0, r4)     // Catch:{ Exception -> 0x049b }
            java.lang.String r0 = com.mbridge.msdk.foundation.tools.u.e((java.lang.String) r30)     // Catch:{ Exception -> 0x049b }
            boolean r2 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x049b }
            if (r2 != 0) goto L_0x0129
            java.lang.String r2 = "j"
            r14.a(r2, r0)     // Catch:{ Exception -> 0x049b }
        L_0x0129:
            java.util.Map<java.lang.String, java.lang.Integer> r0 = h     // Catch:{ Exception -> 0x049b }
            java.lang.Object r0 = r0.get(r10)     // Catch:{ Exception -> 0x049b }
            java.lang.Integer r0 = (java.lang.Integer) r0     // Catch:{ Exception -> 0x049b }
            int r2 = r0.intValue()     // Catch:{ Exception -> 0x049b }
            int r0 = u     // Catch:{ Exception -> 0x049b }
            if (r13 == r0) goto L_0x0489
            if (r13 == 0) goto L_0x0489
            if (r2 != 0) goto L_0x013f
            goto L_0x0489
        L_0x013f:
            r15 = 1
            if (r9 != 0) goto L_0x0188
            com.mbridge.msdk.mbnative.a.b r0 = com.mbridge.msdk.mbnative.a.c.a(r25)     // Catch:{ Exception -> 0x049b }
            if (r12 == 0) goto L_0x0171
            if (r0 == 0) goto L_0x015d
            java.lang.Object r0 = r0.b(r10, r2)     // Catch:{ Exception -> 0x049b }
            java.util.List r0 = (java.util.List) r0     // Catch:{ Exception -> 0x049b }
            if (r0 == 0) goto L_0x015d
            int r0 = r0.size()     // Catch:{ Exception -> 0x049b }
            if (r0 <= 0) goto L_0x015d
            r0 = 0
            r8.a((boolean) r15, (com.mbridge.msdk.a.a.a) r11, (java.lang.String) r0)     // Catch:{ Exception -> 0x049b }
            return
        L_0x015d:
            boolean r0 = r8.w     // Catch:{ Exception -> 0x049b }
            if (r0 == 0) goto L_0x0170
            java.lang.String r2 = ""
            r1 = r24
            r3 = r28
            r4 = r30
            r5 = r31
            r6 = r32
            r1.a((java.lang.String) r2, (int) r3, (java.lang.String) r4, (java.lang.String) r5, (com.mbridge.msdk.a.a.a) r6)     // Catch:{ Exception -> 0x049b }
        L_0x0170:
            return
        L_0x0171:
            if (r1 == r15) goto L_0x0188
            if (r0 == 0) goto L_0x0188
            java.lang.Object r0 = r0.b(r10, r2)     // Catch:{ Exception -> 0x049b }
            java.util.List r0 = (java.util.List) r0     // Catch:{ Exception -> 0x049b }
            if (r0 == 0) goto L_0x0188
            int r0 = r0.size()     // Catch:{ Exception -> 0x049b }
            if (r0 <= 0) goto L_0x0188
            r0 = 0
            r8.a((boolean) r15, (com.mbridge.msdk.a.a.a) r11, (java.lang.String) r0)     // Catch:{ Exception -> 0x049b }
            return
        L_0x0188:
            java.lang.String r6 = "ad_num"
            java.lang.String r15 = ""
            if (r2 == 0) goto L_0x01a0
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x049b }
            r0.<init>()     // Catch:{ Exception -> 0x049b }
            r0.append(r2)     // Catch:{ Exception -> 0x049b }
            r0.append(r15)     // Catch:{ Exception -> 0x049b }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x049b }
            r14.a(r6, r0)     // Catch:{ Exception -> 0x049b }
        L_0x01a0:
            int r0 = r8.p     // Catch:{ Exception -> 0x049b }
            if (r0 == 0) goto L_0x01ba
            java.lang.String r0 = "frame_num"
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x049b }
            r9.<init>()     // Catch:{ Exception -> 0x049b }
            int r12 = r8.p     // Catch:{ Exception -> 0x049b }
            r9.append(r12)     // Catch:{ Exception -> 0x049b }
            r9.append(r15)     // Catch:{ Exception -> 0x049b }
            java.lang.String r9 = r9.toString()     // Catch:{ Exception -> 0x049b }
            r14.a(r0, r9)     // Catch:{ Exception -> 0x049b }
        L_0x01ba:
            java.util.Map<java.lang.String, java.lang.Object> r0 = r8.q     // Catch:{ Exception -> 0x049b }
            boolean r0 = r0.containsKey(r5)     // Catch:{ Exception -> 0x049b }
            if (r0 == 0) goto L_0x0283
            java.util.Map<java.lang.String, java.lang.Object> r0 = r8.q     // Catch:{ Exception -> 0x049b }
            java.lang.Object r0 = r0.get(r5)     // Catch:{ Exception -> 0x049b }
            r9 = r0
            java.lang.String r9 = (java.lang.String) r9     // Catch:{ Exception -> 0x049b }
            boolean r0 = android.text.TextUtils.isEmpty(r9)     // Catch:{ Exception -> 0x049b }
            if (r0 != 0) goto L_0x027c
            java.lang.String r0 = d     // Catch:{ Exception -> 0x049b }
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x049b }
            r12.<init>()     // Catch:{ Exception -> 0x049b }
            java.lang.String r11 = "nativeinfo"
            r12.append(r11)     // Catch:{ Exception -> 0x049b }
            r12.append(r9)     // Catch:{ Exception -> 0x049b }
            java.lang.String r11 = r12.toString()     // Catch:{ Exception -> 0x049b }
            com.mbridge.msdk.foundation.tools.q.d(r0, r11)     // Catch:{ Exception -> 0x049b }
            org.json.JSONArray r0 = new org.json.JSONArray     // Catch:{ JSONException -> 0x0260 }
            r0.<init>(r9)     // Catch:{ JSONException -> 0x0260 }
            int r11 = r0.length()     // Catch:{ JSONException -> 0x0260 }
            if (r11 <= 0) goto L_0x0249
            r21 = r9
            r11 = 0
            r12 = 0
            r20 = 0
        L_0x01f8:
            int r9 = r0.length()     // Catch:{ JSONException -> 0x0245 }
            if (r11 >= r9) goto L_0x023e
            java.lang.Object r9 = r0.opt(r11)     // Catch:{ JSONException -> 0x0245 }
            org.json.JSONObject r9 = (org.json.JSONObject) r9     // Catch:{ JSONException -> 0x0245 }
            r22 = r12
            java.lang.String r12 = "id"
            r23 = r2
            r2 = 0
            int r12 = r9.optInt(r12, r2)     // Catch:{ JSONException -> 0x0238 }
            r2 = 2
            if (r2 != r12) goto L_0x021e
            int r12 = r9.optInt(r6)     // Catch:{ JSONException -> 0x0238 }
            if (r13 <= 0) goto L_0x0233
            r9.put(r6, r13)     // Catch:{ JSONException -> 0x021c }
            goto L_0x0233
        L_0x021c:
            r0 = move-exception
            goto L_0x025d
        L_0x021e:
            r2 = 3
            if (r2 != r12) goto L_0x0231
            int r12 = r9.optInt(r6)     // Catch:{ JSONException -> 0x0238 }
            if (r13 <= 0) goto L_0x022f
            r9.put(r6, r13)     // Catch:{ JSONException -> 0x022b }
            goto L_0x022f
        L_0x022b:
            r0 = move-exception
            r20 = r12
            goto L_0x0269
        L_0x022f:
            r20 = r12
        L_0x0231:
            r12 = r22
        L_0x0233:
            int r11 = r11 + 1
            r2 = r23
            goto L_0x01f8
        L_0x0238:
            r0 = move-exception
            goto L_0x0269
        L_0x023a:
            r0 = move-exception
            r23 = r2
            goto L_0x0269
        L_0x023e:
            r23 = r2
            r22 = r12
            r2 = r20
            goto L_0x024f
        L_0x0245:
            r0 = move-exception
            r23 = r2
            goto L_0x025d
        L_0x0249:
            r23 = r2
            r21 = r9
            r2 = 0
            r12 = 0
        L_0x024f:
            int r9 = java.lang.Math.max(r12, r2)     // Catch:{ JSONException -> 0x025a }
            r8.x = r9     // Catch:{ JSONException -> 0x025a }
            java.lang.String r9 = r0.toString()     // Catch:{ JSONException -> 0x025a }
            goto L_0x0278
        L_0x025a:
            r0 = move-exception
            r20 = r2
        L_0x025d:
            r22 = r12
            goto L_0x0269
        L_0x0260:
            r0 = move-exception
            r23 = r2
            r21 = r9
            r20 = 0
            r22 = 0
        L_0x0269:
            java.lang.String r2 = d     // Catch:{ Exception -> 0x049b }
            java.lang.String r0 = com.mbridge.msdk.mbnative.b.a.a(r0)     // Catch:{ Exception -> 0x049b }
            com.mbridge.msdk.foundation.tools.q.d(r2, r0)     // Catch:{ Exception -> 0x049b }
            r2 = r20
            r9 = r21
            r12 = r22
        L_0x0278:
            r14.a(r5, r9)     // Catch:{ Exception -> 0x049b }
            goto L_0x0280
        L_0x027c:
            r23 = r2
            r2 = 0
            r12 = 0
        L_0x0280:
            r13 = r23
            goto L_0x0290
        L_0x0283:
            r23 = r2
            int r0 = v     // Catch:{ Exception -> 0x049b }
            if (r13 == r0) goto L_0x028c
            if (r13 == 0) goto L_0x028c
            goto L_0x028e
        L_0x028c:
            r13 = r23
        L_0x028e:
            r2 = 0
            r12 = 0
        L_0x0290:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x049b }
            r0.<init>()     // Catch:{ Exception -> 0x049b }
            r0.append(r13)     // Catch:{ Exception -> 0x049b }
            r0.append(r15)     // Catch:{ Exception -> 0x049b }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x049b }
            r14.a(r6, r0)     // Catch:{ Exception -> 0x049b }
            java.lang.String r0 = "ping_mode"
            r14.a(r0, r4)     // Catch:{ Exception -> 0x049b }
            com.mbridge.msdk.b.b r0 = com.mbridge.msdk.b.b.a()     // Catch:{ Exception -> 0x049b }
            com.mbridge.msdk.foundation.controller.a r4 = com.mbridge.msdk.foundation.controller.a.e()     // Catch:{ Exception -> 0x049b }
            java.lang.String r4 = r4.h()     // Catch:{ Exception -> 0x049b }
            com.mbridge.msdk.b.a r0 = r0.b(r4)     // Catch:{ Exception -> 0x049b }
            if (r0 != 0) goto L_0x02c0
            com.mbridge.msdk.b.b r0 = com.mbridge.msdk.b.b.a()     // Catch:{ Exception -> 0x049b }
            r0.b()     // Catch:{ Exception -> 0x049b }
        L_0x02c0:
            java.util.Map<java.lang.String, java.lang.Object> r0 = r8.q     // Catch:{ Exception -> 0x049b }
            boolean r0 = com.mbridge.msdk.mbnative.controller.NativeController.a((java.util.Map<java.lang.String, java.lang.Object>) r0)     // Catch:{ Exception -> 0x049b }
            if (r0 != 0) goto L_0x02e3
            com.mbridge.msdk.foundation.controller.a r0 = com.mbridge.msdk.foundation.controller.a.e()     // Catch:{ Exception -> 0x049b }
            android.content.Context r0 = r0.g()     // Catch:{ Exception -> 0x049b }
            org.json.JSONArray r0 = com.mbridge.msdk.foundation.tools.u.a((android.content.Context) r0, (java.lang.String) r10)     // Catch:{ Exception -> 0x049b }
            int r4 = r0.length()     // Catch:{ Exception -> 0x049b }
            if (r4 <= 0) goto L_0x02e3
            java.lang.String r4 = com.mbridge.msdk.foundation.same.net.h.d.c     // Catch:{ Exception -> 0x049b }
            java.lang.String r0 = com.mbridge.msdk.foundation.tools.u.a((org.json.JSONArray) r0)     // Catch:{ Exception -> 0x049b }
            r14.a(r4, r0)     // Catch:{ Exception -> 0x049b }
        L_0x02e3:
            java.util.Map<java.lang.String, com.mbridge.msdk.foundation.entity.j> r0 = g     // Catch:{ Exception -> 0x049b }
            boolean r0 = r0.containsKey(r10)     // Catch:{ Exception -> 0x049b }
            if (r0 == 0) goto L_0x030a
            java.util.Map<java.lang.String, com.mbridge.msdk.foundation.entity.j> r0 = g     // Catch:{ Exception -> 0x049b }
            java.lang.Object r0 = r0.get(r10)     // Catch:{ Exception -> 0x049b }
            com.mbridge.msdk.foundation.entity.j r0 = (com.mbridge.msdk.foundation.entity.j) r0     // Catch:{ Exception -> 0x049b }
            if (r0 == 0) goto L_0x030a
            r4 = 1
            if (r1 == r4) goto L_0x0305
            r4 = 2
            if (r1 == r4) goto L_0x0300
            int r0 = r0.b()     // Catch:{ Exception -> 0x049b }
            goto L_0x030b
        L_0x0300:
            int r0 = r0.a()     // Catch:{ Exception -> 0x049b }
            goto L_0x030b
        L_0x0305:
            int r0 = r0.b()     // Catch:{ Exception -> 0x049b }
            goto L_0x030b
        L_0x030a:
            r0 = 0
        L_0x030b:
            java.util.Map<java.lang.String, java.lang.Object> r4 = r8.q     // Catch:{ Exception -> 0x049b }
            boolean r4 = r4.containsKey(r5)     // Catch:{ Exception -> 0x049b }
            java.lang.String r5 = "tnum"
            if (r4 == 0) goto L_0x032d
            r4 = 1
            if (r1 != r4) goto L_0x032e
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x049b }
            r4.<init>()     // Catch:{ Exception -> 0x049b }
            int r6 = r8.x     // Catch:{ Exception -> 0x049b }
            r4.append(r6)     // Catch:{ Exception -> 0x049b }
            r4.append(r15)     // Catch:{ Exception -> 0x049b }
            java.lang.String r4 = r4.toString()     // Catch:{ Exception -> 0x049b }
            r14.a(r5, r4)     // Catch:{ Exception -> 0x049b }
            goto L_0x0344
        L_0x032d:
            r4 = 1
        L_0x032e:
            if (r1 != r4) goto L_0x0344
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x049b }
            r4.<init>()     // Catch:{ Exception -> 0x049b }
            int r6 = r8.y     // Catch:{ Exception -> 0x049b }
            r4.append(r6)     // Catch:{ Exception -> 0x049b }
            r4.append(r15)     // Catch:{ Exception -> 0x049b }
            java.lang.String r4 = r4.toString()     // Catch:{ Exception -> 0x049b }
            r14.a(r5, r4)     // Catch:{ Exception -> 0x049b }
        L_0x0344:
            java.lang.String r4 = "offset"
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x049b }
            r5.<init>()     // Catch:{ Exception -> 0x049b }
            r5.append(r0)     // Catch:{ Exception -> 0x049b }
            r5.append(r15)     // Catch:{ Exception -> 0x049b }
            java.lang.String r0 = r5.toString()     // Catch:{ Exception -> 0x049b }
            r14.a(r4, r0)     // Catch:{ Exception -> 0x049b }
            java.lang.String r0 = "ad_type"
            java.lang.String r4 = "42"
            r14.a(r0, r4)     // Catch:{ Exception -> 0x049b }
            java.lang.String r0 = "ad_source_id"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x049b }
            r4.<init>()     // Catch:{ Exception -> 0x049b }
            r4.append(r1)     // Catch:{ Exception -> 0x049b }
            r4.append(r15)     // Catch:{ Exception -> 0x049b }
            java.lang.String r4 = r4.toString()     // Catch:{ Exception -> 0x049b }
            r14.a(r0, r4)     // Catch:{ Exception -> 0x049b }
            java.lang.String r0 = "native"
            java.lang.String r0 = com.mbridge.msdk.foundation.same.a.d.a(r10, r0)     // Catch:{ Exception -> 0x049b }
            boolean r4 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x049b }
            if (r4 != 0) goto L_0x0384
            java.lang.String r4 = com.mbridge.msdk.foundation.same.net.h.d.b     // Catch:{ Exception -> 0x049b }
            r14.a(r4, r0)     // Catch:{ Exception -> 0x049b }
        L_0x0384:
            int r0 = android.os.Build.VERSION.SDK_INT     // Catch:{ Exception -> 0x049b }
            r4 = 14
            if (r0 < r4) goto L_0x03f7
            java.util.Map<java.lang.String, java.lang.Object> r0 = r8.q     // Catch:{ Exception -> 0x049b }
            boolean r0 = r0.containsKey(r3)     // Catch:{ Exception -> 0x049b }
            if (r0 == 0) goto L_0x03bc
            java.util.Map<java.lang.String, java.lang.Object> r0 = r8.q     // Catch:{ Exception -> 0x049b }
            java.lang.Object r0 = r0.get(r3)     // Catch:{ Exception -> 0x049b }
            boolean r0 = r0 instanceof java.lang.Integer     // Catch:{ Exception -> 0x049b }
            if (r0 == 0) goto L_0x03bc
            java.lang.String r0 = "video_width"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x049b }
            r4.<init>()     // Catch:{ Exception -> 0x049b }
            java.util.Map<java.lang.String, java.lang.Object> r5 = r8.q     // Catch:{ Exception -> 0x049b }
            java.lang.Object r3 = r5.get(r3)     // Catch:{ Exception -> 0x049b }
            java.lang.Integer r3 = (java.lang.Integer) r3     // Catch:{ Exception -> 0x049b }
            int r3 = r3.intValue()     // Catch:{ Exception -> 0x049b }
            r4.append(r3)     // Catch:{ Exception -> 0x049b }
            r4.append(r15)     // Catch:{ Exception -> 0x049b }
            java.lang.String r3 = r4.toString()     // Catch:{ Exception -> 0x049b }
            r14.a(r0, r3)     // Catch:{ Exception -> 0x049b }
        L_0x03bc:
            java.util.Map<java.lang.String, java.lang.Object> r0 = r8.q     // Catch:{ Exception -> 0x049b }
            r3 = r19
            boolean r0 = r0.containsKey(r3)     // Catch:{ Exception -> 0x049b }
            if (r0 == 0) goto L_0x03f0
            java.util.Map<java.lang.String, java.lang.Object> r0 = r8.q     // Catch:{ Exception -> 0x049b }
            java.lang.Object r0 = r0.get(r3)     // Catch:{ Exception -> 0x049b }
            boolean r0 = r0 instanceof java.lang.Integer     // Catch:{ Exception -> 0x049b }
            if (r0 == 0) goto L_0x03f0
            java.lang.String r0 = "video_height"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x049b }
            r4.<init>()     // Catch:{ Exception -> 0x049b }
            java.util.Map<java.lang.String, java.lang.Object> r5 = r8.q     // Catch:{ Exception -> 0x049b }
            java.lang.Object r3 = r5.get(r3)     // Catch:{ Exception -> 0x049b }
            java.lang.Integer r3 = (java.lang.Integer) r3     // Catch:{ Exception -> 0x049b }
            int r3 = r3.intValue()     // Catch:{ Exception -> 0x049b }
            r4.append(r3)     // Catch:{ Exception -> 0x049b }
            r4.append(r15)     // Catch:{ Exception -> 0x049b }
            java.lang.String r3 = r4.toString()     // Catch:{ Exception -> 0x049b }
            r14.a(r0, r3)     // Catch:{ Exception -> 0x049b }
        L_0x03f0:
            java.lang.String r0 = "video_version"
            java.lang.String r3 = "2.0"
            r14.a(r0, r3)     // Catch:{ Exception -> 0x049b }
        L_0x03f7:
            com.mbridge.msdk.mbnative.controller.b$a r0 = new com.mbridge.msdk.mbnative.controller.b$a     // Catch:{ Exception -> 0x049b }
            r0.<init>(r1)     // Catch:{ Exception -> 0x049b }
            r0.d = r10     // Catch:{ Exception -> 0x049b }
            r0.e = r7     // Catch:{ Exception -> 0x049b }
            r3 = 42
            r0.f = r3     // Catch:{ Exception -> 0x049b }
            r3 = r23
            r0.f((int) r3)     // Catch:{ Exception -> 0x049b }
            r0.d((int) r12)     // Catch:{ Exception -> 0x049b }
            r0.e((int) r2)     // Catch:{ Exception -> 0x049b }
            r2 = r29
            r0.c((int) r2)     // Catch:{ Exception -> 0x049b }
            r9 = r32
            r0.a((com.mbridge.msdk.a.a.a) r9)     // Catch:{ Exception -> 0x049b }
            r2 = 1
            r11 = r33
            if (r1 != r2) goto L_0x0420
            if (r11 == 0) goto L_0x0423
        L_0x0420:
            r0.b((boolean) r2)     // Catch:{ Exception -> 0x049b }
        L_0x0423:
            java.util.Map<java.lang.String, java.lang.Object> r1 = r8.q     // Catch:{ Exception -> 0x049b }
            java.util.List r1 = com.mbridge.msdk.mbnative.controller.NativeController.b((java.util.Map<java.lang.String, java.lang.Object>) r1)     // Catch:{ Exception -> 0x049b }
            r0.a((java.util.List<java.lang.String>) r1)     // Catch:{ Exception -> 0x049b }
            com.mbridge.msdk.mbnative.controller.b$b r12 = new com.mbridge.msdk.mbnative.controller.b$b     // Catch:{ Exception -> 0x049b }
            r3 = 1
            r1 = r12
            r2 = r24
            r4 = r0
            r5 = r28
            r6 = r30
            r7 = r31
            r1.<init>(r3, r4, r5, r6, r7)     // Catch:{ Exception -> 0x049b }
            r0.a((java.lang.Runnable) r12)     // Catch:{ Exception -> 0x049b }
            r3 = r28
            r0.g(r3)     // Catch:{ Exception -> 0x049b }
            r12.a((com.mbridge.msdk.a.a.a) r9)     // Catch:{ Exception -> 0x049b }
            r12.a((boolean) r11)     // Catch:{ Exception -> 0x049b }
            r12.a((java.lang.String) r10)     // Catch:{ Exception -> 0x049b }
            if (r3 != 0) goto L_0x0473
            com.mbridge.msdk.foundation.same.net.g.d r1 = com.mbridge.msdk.foundation.same.net.g.d.c()     // Catch:{ Exception -> 0x049b }
            boolean r1 = r1.b()     // Catch:{ Exception -> 0x049b }
            if (r1 == 0) goto L_0x0466
            com.mbridge.msdk.foundation.same.net.g.d r1 = com.mbridge.msdk.foundation.same.net.g.d.c()     // Catch:{ Exception -> 0x049b }
            java.lang.String r1 = r1.h     // Catch:{ Exception -> 0x049b }
            r2 = r18
            r3 = 1
            r2.b(r3, r1, r14, r0)     // Catch:{ Exception -> 0x049b }
            goto L_0x0481
        L_0x0466:
            r2 = r18
            com.mbridge.msdk.foundation.same.net.g.d r1 = com.mbridge.msdk.foundation.same.net.g.d.c()     // Catch:{ Exception -> 0x049b }
            java.lang.String r1 = r1.f     // Catch:{ Exception -> 0x049b }
            r3 = 1
            r2.a(r3, r1, r14, r0)     // Catch:{ Exception -> 0x049b }
            goto L_0x0481
        L_0x0473:
            r2 = r18
            r1 = 1
            if (r3 != r1) goto L_0x0481
            com.mbridge.msdk.foundation.same.net.g.d r3 = com.mbridge.msdk.foundation.same.net.g.d.c()     // Catch:{ Exception -> 0x049b }
            java.lang.String r3 = r3.g     // Catch:{ Exception -> 0x049b }
            r2.a(r1, r3, r14, r0)     // Catch:{ Exception -> 0x049b }
        L_0x0481:
            android.os.Handler r0 = r8.o     // Catch:{ Exception -> 0x049b }
            r1 = r26
            r0.postDelayed(r12, r1)     // Catch:{ Exception -> 0x049b }
            goto L_0x04ae
        L_0x0489:
            r3 = r9
            r9 = r11
            java.lang.String r2 = "The request was refused"
            r1 = r24
            r3 = r28
            r4 = r30
            r5 = r31
            r6 = r32
            r1.a((java.lang.String) r2, (int) r3, (java.lang.String) r4, (java.lang.String) r5, (com.mbridge.msdk.a.a.a) r6)     // Catch:{ Exception -> 0x049b }
            return
        L_0x049b:
            r0 = move-exception
            java.lang.String r1 = d
            java.lang.String r2 = com.mbridge.msdk.mbnative.b.a.a(r0)
            com.mbridge.msdk.foundation.tools.q.d(r1, r2)
            java.lang.String r1 = d
            java.lang.String r0 = r0.getMessage()
            com.mbridge.msdk.foundation.tools.q.d(r1, r0)
        L_0x04ae:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.mbnative.controller.b.a(int, long, int, com.mbridge.msdk.b.d, java.lang.String, java.lang.String, com.mbridge.msdk.a.a.a, boolean):void");
    }

    public static void a(int i2, String str) {
        j jVar;
        if (g.containsKey(str)) {
            jVar = g.get(str);
        } else {
            jVar = new j();
        }
        int intValue = h.get(str).intValue();
        int intValue2 = i.containsKey(str) ? i.get(str).intValue() : 1;
        if (i2 == 1) {
            int b2 = jVar.b() + intValue;
            if (b2 > intValue2) {
                b2 = 0;
            }
            jVar.b(b2);
        } else if (i2 == 2) {
            int a2 = jVar.a() + intValue;
            if (a2 > intValue2) {
                a2 = 0;
            }
            jVar.a(a2);
        }
        g.put(str, jVar);
    }

    public static void b(int i2, String str) {
        if (g.containsKey(str)) {
            j jVar = g.get(str);
            if (i2 == 1) {
                jVar.b(0);
            } else if (i2 == 2) {
                jVar.a(0);
            }
            g.put(str, jVar);
        }
    }

    /* compiled from: NativePreloadController */
    public class a extends com.mbridge.msdk.mbnative.e.a.b implements com.mbridge.msdk.foundation.same.e.c {
        /* access modifiers changed from: private */
        public int b;
        /* access modifiers changed from: private */
        public int c;
        /* access modifiers changed from: private */
        public int g;
        /* access modifiers changed from: private */
        public int h;
        /* access modifiers changed from: private */
        public int i;
        private List<String> j = null;
        /* access modifiers changed from: private */
        public boolean k = false;
        /* access modifiers changed from: private */
        public Runnable l;
        /* access modifiers changed from: private */
        public boolean m = true;
        /* access modifiers changed from: private */
        public com.mbridge.msdk.a.a.a n;

        public final void a(List<String> list) {
            this.j = list;
        }

        public final void c(int i2) {
            this.i = i2;
        }

        public final void d(int i2) {
            this.g = i2;
        }

        public final void e(int i2) {
            this.h = i2;
        }

        public final void f(int i2) {
            this.c = i2;
        }

        public a(int i2) {
            this.b = i2;
        }

        public final void a(com.mbridge.msdk.a.a.a aVar) {
            this.n = aVar;
        }

        public final void b(boolean z) {
            this.m = z;
        }

        public final void a(boolean z) {
            this.k = z;
        }

        public final void a(List<com.mbridge.msdk.foundation.same.net.c.b> list, final CampaignUnit campaignUnit) {
            boolean unused = b.this.w = true;
            b.this.a(true, this.n, (String) null);
            b.this.a(new Thread(new Runnable() {
                public final void run() {
                    boolean z;
                    int i = 1;
                    if (!MBridgeConstans.PRELOAD_RESULT_IN_SUBTHREAD || Looper.myLooper() != null) {
                        z = false;
                    } else {
                        Looper.prepare();
                        z = true;
                    }
                    if (a.this.l != null) {
                        b.this.o.removeCallbacks(a.this.l);
                    }
                    if (b.e.containsKey("0_" + a.this.d)) {
                        b.e.remove("0_" + a.this.d);
                    }
                    if (a.this.i > 0) {
                        if (campaignUnit.ads.size() > a.this.i) {
                            a aVar = a.this;
                            int unused = aVar.c = aVar.i;
                        } else {
                            int unused2 = a.this.c = campaignUnit.ads.size();
                        }
                    } else if (a.this.i == -1) {
                        int unused3 = a.this.c = 0;
                    } else if (a.this.i == -3) {
                        int unused4 = a.this.c = campaignUnit.ads.size();
                    } else if (a.this.i == -2) {
                        if (campaignUnit.getTemplate() == 3) {
                            if (a.this.h != 0) {
                                a aVar2 = a.this;
                                int unused5 = aVar2.c = aVar2.h;
                            }
                        } else if (a.this.g != 0) {
                            a aVar3 = a.this;
                            int unused6 = aVar3.c = aVar3.g;
                        }
                        if (a.this.c <= 0) {
                            int unused7 = a.this.c = ((Integer) b.h.get(a.this.d)).intValue();
                        }
                    }
                    if (campaignUnit.ads.size() < a.this.c) {
                        int unused8 = a.this.c = campaignUnit.ads.size();
                    }
                    ArrayList arrayList = new ArrayList();
                    ArrayList arrayList2 = new ArrayList();
                    for (int i2 = 0; i2 < campaignUnit.ads.size(); i2++) {
                        CampaignEx campaignEx = campaignUnit.ads.get(i2);
                        campaignEx.setCampaignUnitId(a.this.d);
                        if (arrayList.size() < a.this.c && campaignEx.getOfferType() != 99) {
                            arrayList.add(campaignEx);
                            if (!TextUtils.isEmpty(campaignEx.getVideoUrlEncode())) {
                                arrayList2.add(campaignEx);
                            }
                        }
                        b.this.a(b.this.t, (Campaign) campaignEx);
                    }
                    b.a(b.this, (List) arrayList2, a.this.d);
                    if (campaignUnit.getAds().get(0) != null) {
                        i = campaignUnit.getAds().get(0).getType();
                    }
                    com.mbridge.msdk.mbnative.a.b<String, List<Campaign>> a2 = com.mbridge.msdk.mbnative.a.c.a(i);
                    if (a2 != null) {
                        a2.a(a.this.d, arrayList);
                    }
                    b.a(a.this.b, a.this.d);
                    if (Looper.myLooper() != null && z) {
                        Looper.loop();
                    }
                    if (campaignUnit.getAds().get(0) != null) {
                        com.mbridge.msdk.click.b.a(com.mbridge.msdk.foundation.controller.a.e().g(), campaignUnit.getAds().get(0).getMaitve(), campaignUnit.getAds().get(0).getMaitve_src());
                    }
                }
            }));
        }

        public final void a(final int i2, final String str) {
            b.this.a(new Thread(new Runnable() {
                public final void run() {
                    boolean z;
                    if (!MBridgeConstans.PRELOAD_RESULT_IN_SUBTHREAD || Looper.myLooper() != null) {
                        z = false;
                    } else {
                        Looper.prepare();
                        z = true;
                    }
                    if (!a.this.k) {
                        if (a.this.l != null) {
                            b.this.o.removeCallbacks(a.this.l);
                        }
                        if (a.this.g() == 1 || a.this.m) {
                            b.this.a(str, a.this.g(), a.this.d, a.this.e, a.this.n);
                        }
                    } else if (a.this.m) {
                        b.this.a(str, a.this.g(), a.this.d, a.this.e, a.this.n);
                    }
                    if (i2 == -1) {
                        b.b(a.this.b, a.this.d);
                    }
                    if (Looper.myLooper() != null && z) {
                        Looper.loop();
                    }
                }
            }));
        }

        public final void a(Runnable runnable) {
            this.l = runnable;
        }

        public final void b(final List<Frame> list) {
            b.this.a(new Thread(new Runnable() {
                public final void run() {
                    boolean z;
                    if (!MBridgeConstans.PRELOAD_RESULT_IN_SUBTHREAD || Looper.myLooper() != null) {
                        z = false;
                    } else {
                        Looper.prepare();
                        z = true;
                    }
                    if (!a.this.k && a.this.l != null) {
                        b.this.o.removeCallbacks(a.this.l);
                    }
                    List list = list;
                    if (list != null && list.size() > 0) {
                        for (Frame campaigns : list) {
                            for (CampaignEx a2 : campaigns.getCampaigns()) {
                                b.this.a(b.this.t, (Campaign) a2);
                            }
                        }
                        HashMap hashMap = new HashMap();
                        hashMap.put(Long.valueOf(System.currentTimeMillis()), list);
                        Map f = b.e;
                        if (f.containsKey("1_" + a.this.d)) {
                            Map f2 = b.e;
                            f2.remove("1_" + a.this.d);
                        }
                        Map f3 = b.e;
                        f3.put("1_" + a.this.d, hashMap);
                    }
                    if (Looper.myLooper() != null && z) {
                        Looper.loop();
                    }
                }
            }));
        }
    }

    public final void a(String str, int i2, String str2, String str3, com.mbridge.msdk.a.a.a aVar) {
        Log.e(d, str);
        try {
            if ((this.a == null || this.a.size() > 0) && this.a != null) {
                a(i2, this.m, str2, str3, aVar);
                return;
            }
            a(false, aVar, str);
        } catch (Exception e2) {
            if (MBridgeConstans.DEBUG) {
                e2.printStackTrace();
            }
        }
    }

    /* renamed from: com.mbridge.msdk.mbnative.controller.b$b  reason: collision with other inner class name */
    /* compiled from: NativePreloadController */
    public class C0067b implements Runnable {
        private int b;
        private com.mbridge.msdk.foundation.same.e.c c;
        private int d;
        private String e;
        private String f;
        private com.mbridge.msdk.a.a.a g;
        private boolean h = false;

        public final void a(boolean z) {
            this.h = z;
        }

        public final void a(com.mbridge.msdk.a.a.a aVar) {
            this.g = aVar;
        }

        public final void a(String str) {
            this.e = str;
        }

        public C0067b(int i, com.mbridge.msdk.foundation.same.e.c cVar, int i2, String str, String str2) {
            this.b = i;
            this.c = cVar;
            this.d = i2;
            this.e = str;
            this.f = str2;
        }

        public final void run() {
            this.c.a(true);
            int i = this.b;
            if (i == 1) {
                boolean unused = b.this.w = true;
                if (this.h || this.d == 1) {
                    b.this.a("REQUEST_TIMEOUT", this.d, this.e, this.f, this.g);
                }
            } else if (i == 2) {
                b.this.a("REQUEST_TIMEOUT", this.d, this.e, this.f, this.g);
            }
        }
    }

    public static Map<String, Map<Long, Object>> a() {
        return e;
    }

    public static Map<String, Boolean> b() {
        return f;
    }

    public static Map<String, j> c() {
        return g;
    }

    public static Map<String, Integer> d() {
        return h;
    }

    public static Map<String, Integer> e() {
        return i;
    }

    public final void a(boolean z2, com.mbridge.msdk.a.a.a aVar, String str) {
        if (z2) {
            if (aVar != null && !aVar.a()) {
                aVar.a(true);
                aVar.onPreloadSucceed();
            }
        } else if (aVar != null && !aVar.a()) {
            aVar.a(true);
            aVar.onPreloadFaild(str);
        }
    }

    public final void a(boolean z2, Campaign campaign) {
        if (campaign != null) {
            if (z2 && campaign.getIconDrawable() == null) {
                campaign.loadIconUrlAsyncWithBlock((OnImageLoadListener) null);
            }
            if (z2 && campaign.getBigDrawable() == null) {
                campaign.loadImageUrlAsyncWithBlock((OnImageLoadListener) null);
            }
        }
    }

    public final void a(Thread thread) {
        if (!MBridgeConstans.PRELOAD_RESULT_IN_SUBTHREAD) {
            thread.run();
        } else {
            thread.start();
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:10|11|19) */
    /* JADX WARNING: Code restructure failed: missing block: B:11:?, code lost:
        com.mbridge.msdk.foundation.tools.q.d(d, "please import the videocommon aar");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
        return;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x007c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ void a(com.mbridge.msdk.mbnative.controller.b r11, java.util.List r12, java.lang.String r13) {
        /*
            java.lang.String r11 = "com.mbridge.msdk.videocommon.download.c"
            if (r12 == 0) goto L_0x008e
            int r0 = r12.size()     // Catch:{ Exception -> 0x0084 }
            if (r0 <= 0) goto L_0x008e
            java.lang.String r0 = "com.mbridge.msdk.nativex.view.MBMediaView"
            java.lang.Class.forName(r0)     // Catch:{ Exception -> 0x007c }
            java.lang.Class.forName(r11)     // Catch:{ Exception -> 0x007c }
            java.lang.Class r11 = java.lang.Class.forName(r11)     // Catch:{ Exception -> 0x007c }
            java.lang.String r0 = "getInstance"
            r1 = 0
            java.lang.Class[] r2 = new java.lang.Class[r1]     // Catch:{ Exception -> 0x007c }
            java.lang.reflect.Method r0 = r11.getMethod(r0, r2)     // Catch:{ Exception -> 0x007c }
            java.lang.Object[] r2 = new java.lang.Object[r1]     // Catch:{ Exception -> 0x007c }
            r3 = 0
            java.lang.Object r0 = r0.invoke(r3, r2)     // Catch:{ Exception -> 0x007c }
            if (r0 == 0) goto L_0x008e
            java.lang.String r2 = "com.mbridge.msdk.videocommon.listener.a"
            java.lang.Class r2 = java.lang.Class.forName(r2)     // Catch:{ Exception -> 0x007c }
            java.lang.String r4 = "createUnitCache"
            r5 = 5
            java.lang.Class[] r6 = new java.lang.Class[r5]     // Catch:{ Exception -> 0x007c }
            java.lang.Class<android.content.Context> r7 = android.content.Context.class
            r6[r1] = r7     // Catch:{ Exception -> 0x007c }
            java.lang.Class<java.lang.String> r7 = java.lang.String.class
            r8 = 1
            r6[r8] = r7     // Catch:{ Exception -> 0x007c }
            java.lang.Class<java.util.List> r7 = java.util.List.class
            r9 = 2
            r6[r9] = r7     // Catch:{ Exception -> 0x007c }
            java.lang.Class r7 = java.lang.Integer.TYPE     // Catch:{ Exception -> 0x007c }
            r10 = 3
            r6[r10] = r7     // Catch:{ Exception -> 0x007c }
            r7 = 4
            r6[r7] = r2     // Catch:{ Exception -> 0x007c }
            java.lang.reflect.Method r2 = r11.getMethod(r4, r6)     // Catch:{ Exception -> 0x007c }
            java.lang.Object[] r4 = new java.lang.Object[r5]     // Catch:{ Exception -> 0x007c }
            com.mbridge.msdk.foundation.controller.a r5 = com.mbridge.msdk.foundation.controller.a.e()     // Catch:{ Exception -> 0x007c }
            android.content.Context r5 = r5.g()     // Catch:{ Exception -> 0x007c }
            r4[r1] = r5     // Catch:{ Exception -> 0x007c }
            r4[r8] = r13     // Catch:{ Exception -> 0x007c }
            r4[r9] = r12     // Catch:{ Exception -> 0x007c }
            java.lang.Integer r12 = java.lang.Integer.valueOf(r8)     // Catch:{ Exception -> 0x007c }
            r4[r10] = r12     // Catch:{ Exception -> 0x007c }
            r4[r7] = r3     // Catch:{ Exception -> 0x007c }
            r2.invoke(r0, r4)     // Catch:{ Exception -> 0x007c }
            java.lang.String r12 = "load"
            java.lang.Class[] r2 = new java.lang.Class[r8]     // Catch:{ Exception -> 0x007c }
            java.lang.Class<java.lang.String> r3 = java.lang.String.class
            r2[r1] = r3     // Catch:{ Exception -> 0x007c }
            java.lang.reflect.Method r11 = r11.getMethod(r12, r2)     // Catch:{ Exception -> 0x007c }
            java.lang.Object[] r12 = new java.lang.Object[r8]     // Catch:{ Exception -> 0x007c }
            r12[r1] = r13     // Catch:{ Exception -> 0x007c }
            r11.invoke(r0, r12)     // Catch:{ Exception -> 0x007c }
            goto L_0x008e
        L_0x007c:
            java.lang.String r11 = d     // Catch:{ Exception -> 0x0084 }
            java.lang.String r12 = "please import the videocommon aar"
            com.mbridge.msdk.foundation.tools.q.d(r11, r12)     // Catch:{ Exception -> 0x0084 }
            goto L_0x008e
        L_0x0084:
            r11 = move-exception
            java.lang.String r12 = d
            java.lang.String r11 = com.mbridge.msdk.mbnative.b.a.a(r11)
            com.mbridge.msdk.foundation.tools.q.d(r12, r11)
        L_0x008e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.mbnative.controller.b.a(com.mbridge.msdk.mbnative.controller.b, java.util.List, java.lang.String):void");
    }
}
