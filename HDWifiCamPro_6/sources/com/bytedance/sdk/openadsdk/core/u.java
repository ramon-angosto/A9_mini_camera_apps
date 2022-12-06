package com.bytedance.sdk.openadsdk.core;

import android.content.Context;
import android.net.Uri;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import com.bytedance.JProtect;
import com.bytedance.sdk.component.a.r;
import com.bytedance.sdk.component.adexpress.b.j;
import com.bytedance.sdk.component.adexpress.d.b;
import com.bytedance.sdk.component.adexpress.widget.DynamicUnlockView;
import com.bytedance.sdk.component.adexpress.widget.FlowLightView;
import com.bytedance.sdk.component.d.c.c;
import com.bytedance.sdk.component.d.c.f;
import com.bytedance.sdk.component.utils.k;
import com.bytedance.sdk.component.utils.l;
import com.bytedance.sdk.component.utils.x;
import com.bytedance.sdk.component.widget.SSWebView;
import com.bytedance.sdk.openadsdk.c.m;
import com.bytedance.sdk.openadsdk.core.model.n;
import com.bytedance.sdk.openadsdk.core.nativeexpress.i;
import com.bytedance.sdk.openadsdk.f.c;
import com.bytedance.sdk.openadsdk.f.d;
import com.bytedance.sdk.openadsdk.jslistener.e;
import com.bytedance.sdk.openadsdk.jslistener.h;
import com.bytedance.sdk.openadsdk.l.w;
import com.bytedance.sdk.openadsdk.l.y;
import com.bytedance.sdk.openadsdk.l.z;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: TTAndroidObject */
public class u implements b, x.a, com.bytedance.sdk.openadsdk.f.b {
    private static final Map<String, Boolean> g = new ConcurrentHashMap();
    private com.bytedance.sdk.openadsdk.jslistener.b A;
    private h B;
    private boolean C = true;
    private List<n> D;
    private HashMap<String, i> E;
    private boolean F = false;
    private boolean G = false;
    private m H;
    private r I;
    private String J;
    private boolean K = false;
    private com.bytedance.sdk.openadsdk.core.widget.a.a L;
    protected Map<String, Object> a;
    boolean b;
    boolean c = false;
    private WeakReference<SSWebView> d;
    private x e;
    private String f;
    private WeakReference<Context> h;
    private c i;
    private String j;
    private WeakReference<View> k;
    private String l;
    private int m;
    private String n;
    private int o;
    private boolean p = true;
    private n q;
    private j r;
    private i s;
    private JSONObject t;
    private d u;
    private com.bytedance.sdk.openadsdk.jslistener.a v;
    private e w;
    private com.bytedance.sdk.openadsdk.jslistener.d x;
    private JSONObject y;
    private com.bytedance.sdk.openadsdk.core.b.d z;

    /* compiled from: TTAndroidObject */
    public static class a {
        public String a;
        public String b;
        public String c;
        public JSONObject d;
        public int e;
    }

    static {
        g.put(com.bytedance.sdk.component.a.j.j1667305730992dc("lne\\asci|"), Boolean.TRUE);
        g.put(com.bytedance.sdk.component.a.j.j1667305730992dc("pskueqc"), Boolean.TRUE);
        g.put(com.bytedance.sdk.component.a.j.j1667305730992dc("dhqseqeoWdoxlij"), Boolean.TRUE);
        g.put(c.b.c$b1667305730972dc("ctqwkhYb~ld"), Boolean.TRUE);
        g.put(c.b.c$b1667305730972dc("lne\\asci|V|8"), Boolean.TRUE);
    }

    public u(Context context) {
        this.h = new WeakReference<>(context);
        this.e = new x(Looper.getMainLooper(), this);
    }

    private void a(final a aVar, final JSONObject jSONObject) {
        if (aVar != null) {
            try {
                a(aVar.d, (com.bytedance.sdk.openadsdk.jslistener.c) new com.bytedance.sdk.openadsdk.jslistener.c() {
                });
            } catch (Exception unused) {
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x003a, code lost:
        if ((((94 + 1) * 94) % 2) == 0) goto L_0x001c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x003f, code lost:
        switch(61) {
            case 60: goto L_0x0050;
            case 61: goto L_0x0062;
            case 62: goto L_0x0043;
            default: goto L_0x0042;
        };
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x004d, code lost:
        if (((((0 - 1) * 0) * ((0 * 2) - 1)) % 6) == 0) goto L_0x0015;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0015, code lost:
        continue;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0031, code lost:
        if ((((92 * 92) + (32 * 32)) + (19 * 19)) >= (((92 * 32) + (32 * 19)) + (92 * 19))) goto L_?;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(java.lang.String r5, boolean r6) {
        /*
            r4 = this;
            com.bytedance.sdk.openadsdk.c.m r0 = r4.H
            if (r0 == 0) goto L_0x0062
            r0 = r5
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L_0x000e
            goto L_0x0062
        L_0x000e:
            if (r6 == 0) goto L_0x005d
            com.bytedance.sdk.openadsdk.c.m r6 = r4.H
            r6.a((java.lang.String) r5)
        L_0x0015:
            r5 = 55
            r6 = 1
            switch(r5) {
                case 55: goto L_0x003d;
                case 56: goto L_0x001c;
                case 57: goto L_0x0033;
                default: goto L_0x001b;
            }
        L_0x001b:
            goto L_0x0015
        L_0x001c:
            r5 = 92
            r0 = 32
            r1 = 19
            int r2 = r5 * r5
            int r3 = r0 * r0
            int r2 = r2 + r3
            int r3 = r1 * r1
            int r2 = r2 + r3
            r3 = 92
            int r3 = r3 * r0
            int r0 = r0 * r1
            int r3 = r3 + r0
            int r5 = r5 * r1
            int r3 = r3 + r5
            if (r2 >= r3) goto L_0x0062
        L_0x0033:
            r5 = 94
            int r5 = r5 + r6
            int r5 = r5 * 94
            int r5 = r5 % 2
            if (r5 == 0) goto L_0x001c
            goto L_0x0050
        L_0x003d:
            r5 = 61
            switch(r5) {
                case 60: goto L_0x0050;
                case 61: goto L_0x0062;
                case 62: goto L_0x0043;
                default: goto L_0x0042;
            }
        L_0x0042:
            goto L_0x003d
        L_0x0043:
            r5 = 0
            int r0 = 0 - r6
            int r0 = r0 * r5
            int r5 = r5 * 2
            int r5 = r5 - r6
            int r0 = r0 * r5
            int r0 = r0 % 6
            if (r0 == 0) goto L_0x0015
            goto L_0x0062
        L_0x0050:
            r5 = 18
            int r5 = r5 * r5
            r6 = 35
            int r6 = r6 * r6
            int r6 = r6 * 34
            int r5 = r5 - r6
            r6 = -1
            if (r5 != r6) goto L_0x0062
            goto L_0x0062
        L_0x005d:
            com.bytedance.sdk.openadsdk.c.m r6 = r4.H
            r6.b((java.lang.String) r5)
        L_0x0062:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.u.a(java.lang.String, boolean):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x00b1 A[LOOP_START] */
    @com.bytedance.JProtect
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(org.json.JSONObject r4, int r5) throws java.lang.Exception {
        /*
            r3 = this;
            org.json.JSONArray r5 = new org.json.JSONArray
            r5.<init>()
            java.util.List r0 = r3.p()
            java.util.Iterator r0 = r0.iterator()
        L_0x000d:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x001d
            java.lang.Object r1 = r0.next()
            java.lang.String r1 = (java.lang.String) r1
            r5.put(r1)
            goto L_0x000d
        L_0x001d:
            java.lang.String r0 = "aqrMehc"
            java.lang.String r0 = com.bytedance.sdk.component.a.j.j1667305730992dc(r0)
            java.lang.String r1 = com.bytedance.sdk.openadsdk.common.a.a()
            r4.put(r0, r1)
            java.lang.String r0 = "iolfvDvwFhgn"
            java.lang.String r0 = com.bytedance.sdk.component.a.j.j1667305730992dc(r0)
            java.lang.String r1 = com.bytedance.sdk.openadsdk.common.a.e()
            r4.put(r0, r1)
            java.lang.String r0 = "ahf"
            java.lang.String r0 = com.bytedance.sdk.component.a.j.j1667305730992dc(r0)
            java.lang.String r1 = com.bytedance.sdk.openadsdk.common.a.b()
            r4.put(r0, r1)
            java.lang.String r0 = "seiF`lrngg"
            java.lang.String r0 = com.bytedance.sdk.component.a.j.j1667305730992dc(r0)
            java.lang.String r1 = com.bytedance.sdk.openadsdk.common.a.c()
            r4.put(r0, r1)
            java.lang.String r0 = "aqrUawungg"
            java.lang.String r0 = com.bytedance.sdk.component.a.j.j1667305730992dc(r0)
            java.lang.String r1 = com.bytedance.sdk.openadsdk.common.a.d()
            r4.put(r0, r1)
            java.lang.String r0 = "ndvW}uc"
            java.lang.String r0 = com.bytedance.sdk.component.a.j.j1667305730992dc(r0)
            java.lang.String r1 = com.bytedance.sdk.openadsdk.common.a.f()
            r4.put(r0, r1)
            java.lang.String r0 = "strskwrKaz~"
            java.lang.String r0 = com.bytedance.sdk.component.a.j.j1667305730992dc(r0)
            r4.put(r0, r5)
            java.lang.String r5 = "ddtjg`Oc"
            java.lang.String r5 = com.bytedance.sdk.component.a.j.j1667305730992dc(r5)
            android.content.Context r0 = com.bytedance.sdk.openadsdk.core.m.a()
            java.lang.String r0 = com.bytedance.sdk.openadsdk.common.a.a(r0)
            r4.put(r5, r0)
            android.content.Context r5 = com.bytedance.sdk.openadsdk.core.m.a()
            boolean r5 = com.bytedance.sdk.openadsdk.l.e.a((android.content.Context) r5)
            java.lang.String r0 = "ddtjg`Ywdh~mcc"
            if (r5 == 0) goto L_0x009f
            java.lang.String r5 = com.bytedance.sdk.component.a.j.j1667305730992dc(r0)
            java.lang.String r0 = "AofqklbXXhn"
        L_0x0097:
            java.lang.String r0 = com.bytedance.sdk.component.a.j.j1667305730992dc(r0)
            r4.put(r5, r0)
            goto L_0x00a6
        L_0x009f:
            java.lang.String r5 = com.bytedance.sdk.component.a.j.j1667305730992dc(r0)
            java.lang.String r0 = "Aofqklb"
            goto L_0x0097
        L_0x00a6:
            java.lang.String r5 = "ddtjg`Ysqyo"
            java.lang.String r5 = com.bytedance.sdk.component.a.j.j1667305730992dc(r5)
            java.lang.String r0 = android.os.Build.VERSION.RELEASE
            r4.put(r5, r0)
        L_0x00b1:
            r4 = 13
            switch(r4) {
                case 12: goto L_0x00c4;
                case 13: goto L_0x00d9;
                case 14: goto L_0x00b7;
                default: goto L_0x00b6;
            }
        L_0x00b6:
            goto L_0x00b1
        L_0x00b7:
            r4 = 45
            r5 = 1
            int r0 = 45 - r5
            int r0 = r0 * r4
            int r4 = r4 * 2
            int r4 = r4 - r5
            int r0 = r0 * r4
            int r0 = r0 % 6
            goto L_0x00d9
        L_0x00c4:
            r4 = 92
            r5 = 18
            r0 = 16
            int r1 = r4 * r4
            int r2 = r5 * r5
            int r1 = r1 + r2
            int r2 = r0 * r0
            int r1 = r1 + r2
            r2 = 92
            int r2 = r2 * r5
            int r5 = r5 * r0
            int r2 = r2 + r5
            int r4 = r4 * r0
            int r2 = r2 + r4
        L_0x00d9:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.u.a(org.json.JSONObject, int):void");
    }

    /* JADX WARNING: CFG modification limit reached, blocks count: 134 */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0033, code lost:
        switch(54) {
            case 52: goto L_0x0037;
            case 53: goto L_0x0046;
            case 54: goto L_0x0050;
            default: goto L_0x0036;
        };
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0044, code lost:
        if ((((69 * 69) + (22 * 22)) - ((69 * 22) * 2)) >= 0) goto L_0x005d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x004e, code lost:
        if (((61 * 61) - ((12 * 12) * 34)) != -1) goto L_0x0051;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0050, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0070, code lost:
        if (((((26 * 26) * 26) + ((9 * 9) * 9)) + ((15 * 15) * 15)) < (((26 * 9) * 15) * 3)) goto L_0x0072;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0072, code lost:
        r9 = 0 * 0;
        r7 = 80 * 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x007d, code lost:
        if ((((80 * 80) + r9) + r9) >= ((r9 + r7) + r7)) goto L_0x0022;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0085, code lost:
        if ((((15 + 1) * 15) % 2) == 0) goto L_0x0098;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0087, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0095, code lost:
        if ((((70 * 70) + (44 * 44)) - ((70 * 44) * 2)) >= 0) goto L_0x0098;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x002f, code lost:
        if (((18 * 18) - ((35 * 35) * 34)) != -1) goto L_0x0088;
     */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0051 A[LOOP_START] */
    @com.bytedance.JProtect
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean a(java.lang.String r7, int r8, com.bytedance.sdk.openadsdk.core.model.j r9) {
        /*
            r6 = this;
            r0 = r7
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            r1 = 0
            if (r0 != 0) goto L_0x0098
            java.util.HashMap<java.lang.String, com.bytedance.sdk.openadsdk.core.i> r0 = r6.E
            if (r0 != 0) goto L_0x0010
            goto L_0x0098
        L_0x0010:
            java.lang.Object r7 = r0.get(r7)
            com.bytedance.sdk.openadsdk.core.i r7 = (com.bytedance.sdk.openadsdk.core.i) r7
            r0 = 1
            r2 = 15
            r3 = -1
            r4 = 61
            if (r7 == 0) goto L_0x0022
            r7.a(r8, r9)
            goto L_0x0051
        L_0x0022:
            switch(r4) {
                case 60: goto L_0x0026;
                case 61: goto L_0x0031;
                case 62: goto L_0x005d;
                default: goto L_0x0025;
            }
        L_0x0025:
            goto L_0x0022
        L_0x0026:
            r7 = 18
            int r7 = r7 * r7
            r8 = 35
            int r8 = r8 * r8
            int r8 = r8 * 34
            int r7 = r7 - r8
            if (r7 != r3) goto L_0x0088
        L_0x0031:
            r7 = 54
            switch(r7) {
                case 52: goto L_0x0037;
                case 53: goto L_0x0046;
                case 54: goto L_0x0050;
                default: goto L_0x0036;
            }
        L_0x0036:
            goto L_0x0031
        L_0x0037:
            r7 = 69
            r8 = 22
            int r9 = r7 * r7
            int r5 = r8 * r8
            int r9 = r9 + r5
            int r7 = r7 * r8
            int r7 = r7 * 2
            int r9 = r9 - r7
            if (r9 >= 0) goto L_0x005d
        L_0x0046:
            int r7 = r4 * r4
            r8 = 12
            int r8 = r8 * r8
            int r8 = r8 * 34
            int r7 = r7 - r8
            if (r7 != r3) goto L_0x0051
        L_0x0050:
            return r1
        L_0x0051:
            r7 = 96
            r8 = 51
            switch(r7) {
                case 95: goto L_0x0022;
                case 96: goto L_0x0059;
                case 97: goto L_0x0088;
                default: goto L_0x0058;
            }
        L_0x0058:
            goto L_0x0051
        L_0x0059:
            switch(r8) {
                case 49: goto L_0x0072;
                case 50: goto L_0x007f;
                case 51: goto L_0x0087;
                default: goto L_0x005c;
            }
        L_0x005c:
            goto L_0x0088
        L_0x005d:
            r7 = 26
            r8 = 9
            int r9 = r7 * r7
            int r9 = r9 * r7
            int r5 = r8 * r8
            int r5 = r5 * r8
            int r9 = r9 + r5
            int r5 = r2 * r2
            int r5 = r5 * r2
            int r9 = r9 + r5
            int r7 = r7 * r8
            int r7 = r7 * r2
            int r7 = r7 * 3
            if (r9 >= r7) goto L_0x0098
        L_0x0072:
            r7 = 80
            int r8 = r7 * r7
            int r9 = r1 * r1
            int r8 = r8 + r9
            int r8 = r8 + r9
            int r7 = r7 * r1
            int r9 = r9 + r7
            int r9 = r9 + r7
            if (r8 >= r9) goto L_0x0022
        L_0x007f:
            r7 = 15
            int r7 = r7 + r0
            int r7 = r7 * r2
            int r7 = r7 % 2
            if (r7 == 0) goto L_0x0098
        L_0x0087:
            return r0
        L_0x0088:
            r7 = 70
            r8 = 44
            int r9 = r7 * r7
            int r5 = r8 * r8
            int r9 = r9 + r5
            int r7 = r7 * r8
            int r7 = r7 * 2
            int r9 = r9 - r7
            if (r9 >= 0) goto L_0x0098
            goto L_0x0026
        L_0x0098:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.u.a(java.lang.String, int, com.bytedance.sdk.openadsdk.core.model.j):boolean");
    }

    /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP_START, MTH_ENTER_BLOCK] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ com.bytedance.sdk.openadsdk.core.widget.a.a b(com.bytedance.sdk.openadsdk.core.u r5) {
        /*
        L_0x0000:
            r0 = 73
            switch(r0) {
                case 72: goto L_0x0013;
                case 73: goto L_0x0028;
                case 74: goto L_0x0006;
                default: goto L_0x0005;
            }
        L_0x0005:
            goto L_0x0000
        L_0x0006:
            r0 = 82
            r1 = 1
            int r2 = 82 - r1
            int r2 = r2 * r0
            int r0 = r0 * 2
            int r0 = r0 - r1
            int r2 = r2 * r0
            int r2 = r2 % 6
            goto L_0x0028
        L_0x0013:
            r0 = 29
            r1 = 45
            r2 = 20
            int r3 = r0 * r0
            int r4 = r1 * r1
            int r3 = r3 + r4
            int r4 = r2 * r2
            int r3 = r3 + r4
            r4 = 29
            int r4 = r4 * r1
            int r1 = r1 * r2
            int r4 = r4 + r1
            int r0 = r0 * r2
            int r4 = r4 + r0
        L_0x0028:
            com.bytedance.sdk.openadsdk.core.widget.a.a r5 = r5.L
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.u.b(com.bytedance.sdk.openadsdk.core.u):com.bytedance.sdk.openadsdk.core.widget.a.a");
    }

    public static JSONArray b(List<n> list) {
        JSONArray jSONArray = new JSONArray();
        if (list == null) {
            return jSONArray;
        }
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            jSONArray.put(list.get(i2).ar());
        }
        return jSONArray;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x003b, code lost:
        switch(r6) {
            case 49: goto L_0x005a;
            case 50: goto L_0x0071;
            case 51: goto L_0x007b;
            default: goto L_0x003e;
        };
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0049, code lost:
        if (((((82 - 1) * 82) * ((82 * 2) - 1)) % 6) == 0) goto L_0x008d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0058, code lost:
        if ((((70 * 70) + (44 * 44)) - ((70 * 44) * 2)) >= 0) goto L_0x002b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x006f, code lost:
        if (((((99 * 99) * 99) + ((26 * 26) * 26)) + ((19 * 19) * 19)) >= (((99 * 26) * 19) * 3)) goto L_0x002b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0079, code lost:
        if (((82 * 82) - ((40 * 40) * 34)) != -1) goto L_0x0094;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0085, code lost:
        if (((((0 - 1) * 0) * ((0 * 2) - 1)) % 6) == 0) goto L_0x0094;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0088, code lost:
        r7 = kotlin.text.Typography.less;
        r6 = '1';
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x002b, code lost:
        continue;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x002b, code lost:
        continue;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0037, code lost:
        switch(r7) {
            case 60: goto L_0x003b;
            case 61: goto L_0x003e;
            case 62: goto L_0x004b;
            default: goto L_0x003a;
        };
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void b(java.lang.String r6, org.json.JSONObject r7) {
        /*
            r5 = this;
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ Exception -> 0x0094 }
            r0.<init>()     // Catch:{ Exception -> 0x0094 }
            java.lang.String r1 = "_^opcZr~xl"
            java.lang.String r1 = com.bytedance.sdk.component.f.c.a.a1667305730924dc(r1)     // Catch:{ Exception -> 0x0094 }
            java.lang.String r2 = "c`nofdel"
            java.lang.String r2 = com.bytedance.sdk.component.f.c.a.a1667305730924dc(r2)     // Catch:{ Exception -> 0x0094 }
            r0.put(r1, r2)     // Catch:{ Exception -> 0x0094 }
            java.lang.String r1 = "_^abhidfkbUbh"
            java.lang.String r1 = com.bytedance.sdk.component.f.c.a.a1667305730924dc(r1)     // Catch:{ Exception -> 0x0094 }
            r0.put(r1, r6)     // Catch:{ Exception -> 0x0094 }
            if (r7 == 0) goto L_0x0028
            java.lang.String r6 = "_^rbvdkt"
            java.lang.String r6 = com.bytedance.sdk.component.f.c.a.a1667305730924dc(r6)     // Catch:{ Exception -> 0x0094 }
            r0.put(r6, r7)     // Catch:{ Exception -> 0x0094 }
        L_0x0028:
            r5.p(r0)     // Catch:{ Exception -> 0x0094 }
        L_0x002b:
            r6 = 72
            r7 = 4
            r0 = 56
            r1 = 1
            switch(r0) {
                case 55: goto L_0x008d;
                case 56: goto L_0x0094;
                case 57: goto L_0x0035;
                default: goto L_0x0034;
            }     // Catch:{ Exception -> 0x0094 }
        L_0x0034:
            goto L_0x002b
        L_0x0035:
            r0 = 82
            switch(r7) {
                case 60: goto L_0x003b;
                case 61: goto L_0x003e;
                case 62: goto L_0x004b;
                default: goto L_0x003a;
            }     // Catch:{ Exception -> 0x0094 }
        L_0x003a:
            goto L_0x0088
        L_0x003b:
            switch(r6) {
                case 49: goto L_0x005a;
                case 50: goto L_0x0071;
                case 51: goto L_0x007b;
                default: goto L_0x003e;
            }     // Catch:{ Exception -> 0x0094 }
        L_0x003e:
            int r6 = 82 - r1
            int r6 = r6 * r0
            r7 = 82
            int r7 = r7 * 2
            int r7 = r7 - r1
            int r6 = r6 * r7
            int r6 = r6 % 6
            if (r6 == 0) goto L_0x008d
        L_0x004b:
            r6 = 70
            r7 = 44
            int r2 = r6 * r6
            int r3 = r7 * r7
            int r2 = r2 + r3
            int r6 = r6 * r7
            int r6 = r6 * 2
            int r2 = r2 - r6
            if (r2 >= 0) goto L_0x002b
        L_0x005a:
            r6 = 99
            r7 = 26
            r2 = 19
            int r3 = r6 * r6
            int r3 = r3 * r6
            int r4 = r7 * r7
            int r4 = r4 * r7
            int r3 = r3 + r4
            int r4 = r2 * r2
            int r4 = r4 * r2
            int r3 = r3 + r4
            int r6 = r6 * r7
            int r6 = r6 * r2
            int r6 = r6 * 3
            if (r3 >= r6) goto L_0x002b
        L_0x0071:
            int r0 = r0 * r0
            r6 = 40
            int r6 = r6 * r6
            int r6 = r6 * 34
            int r0 = r0 - r6
            r6 = -1
            if (r0 != r6) goto L_0x0094
        L_0x007b:
            r6 = 0
            int r7 = 0 - r1
            int r7 = r7 * r6
            int r6 = r6 * 2
            int r6 = r6 - r1
            int r7 = r7 * r6
            int r7 = r7 % 6
            if (r7 == 0) goto L_0x0094
            goto L_0x002b
        L_0x0088:
            r7 = 60
            r6 = 49
            goto L_0x0035
        L_0x008d:
            r6 = 39
            int r6 = r6 + r1
            int r6 = r6 * 39
            int r6 = r6 % 2
        L_0x0094:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.u.b(java.lang.String, org.json.JSONObject):void");
    }

    private void c(String str, JSONObject jSONObject) {
        try {
            if (!TextUtils.isEmpty(str)) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put(FlowLightView.FlowLightView1667305730929dc("_^opcZr~xl"), FlowLightView.FlowLightView1667305730929dc("ewgmp"));
                jSONObject2.put(FlowLightView.FlowLightView1667305730929dc("_^guakrXam"), str);
                if (jSONObject != null) {
                    jSONObject2.put(FlowLightView.FlowLightView1667305730929dc("_^rbvdkt"), jSONObject);
                }
                p(jSONObject2);
            }
        } catch (Exception unused) {
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0090, code lost:
        if ((((37 + 1) * 37) % 2) != 0) goto L_0x0092;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0099, code lost:
        if (((3 * 3) - ((5 * 5) * 34)) != -1) goto L_0x0078;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0078, code lost:
        continue;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void d(org.json.JSONObject r8) throws java.lang.Exception {
        /*
            r7 = this;
            java.lang.String r0 = r7.j
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x0015
            java.lang.String r0 = "chf"
            java.lang.String r0 = com.bytedance.sdk.component.a.j.j1667305730992dc(r0)
            java.lang.String r1 = r7.j
            r8.put(r0, r1)
        L_0x0015:
            java.lang.String r0 = r7.l
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x002a
            java.lang.String r0 = "lne\\a}rui"
            java.lang.String r0 = com.bytedance.sdk.component.a.j.j1667305730992dc(r0)
            java.lang.String r1 = r7.l
            r8.put(r0, r1)
        L_0x002a:
            java.lang.String r0 = r7.n
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x003f
            java.lang.String r0 = "dnumhjgcW|xg"
            java.lang.String r0 = com.bytedance.sdk.component.a.j.j1667305730992dc(r0)
            java.lang.String r1 = r7.n
            r8.put(r0, r1)
        L_0x003f:
            java.lang.String r0 = "db"
            java.lang.String r0 = com.bytedance.sdk.component.a.j.j1667305730992dc(r0)
            com.bytedance.sdk.openadsdk.core.settings.j r1 = com.bytedance.sdk.openadsdk.core.m.d()
            java.lang.String r1 = r1.F()
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 == 0) goto L_0x005e
            com.bytedance.sdk.openadsdk.core.settings.j r1 = com.bytedance.sdk.openadsdk.core.m.d()
            java.lang.String r1 = r1.F()
            goto L_0x0064
        L_0x005e:
            java.lang.String r1 = "SF"
            java.lang.String r1 = com.bytedance.sdk.component.a.j.j1667305730992dc(r1)
        L_0x0064:
            r8.put(r0, r1)
            java.lang.String r0 = "l`ldqdab"
            java.lang.String r0 = com.bytedance.sdk.component.a.j.j1667305730992dc(r0)
            android.content.Context r1 = com.bytedance.sdk.openadsdk.core.m.a()
            java.lang.String r1 = com.bytedance.sdk.openadsdk.l.y.h((android.content.Context) r1)
            r8.put(r0, r1)
        L_0x0078:
            r8 = 70
            r0 = 3
            r1 = 9
            r2 = 92
            r3 = 1
            switch(r1) {
                case 9: goto L_0x00a7;
                case 10: goto L_0x0084;
                case 11: goto L_0x00a7;
                default: goto L_0x0083;
            }
        L_0x0083:
            goto L_0x0078
        L_0x0084:
            r4 = -1
            switch(r8) {
                case 40: goto L_0x0089;
                case 41: goto L_0x0092;
                case 42: goto L_0x009b;
                default: goto L_0x0088;
            }
        L_0x0088:
            goto L_0x00a7
        L_0x0089:
            r8 = 37
            int r8 = r8 + r3
            int r8 = r8 * 37
            int r8 = r8 % 2
            if (r8 == 0) goto L_0x00a7
        L_0x0092:
            int r8 = r0 * r0
            r5 = 5
            int r5 = r5 * r5
            int r5 = r5 * 34
            int r8 = r8 - r5
            if (r8 != r4) goto L_0x0078
        L_0x009b:
            r8 = 71
            int r8 = r8 * r8
            r5 = 25
            int r5 = r5 * r5
            int r5 = r5 * 34
            int r8 = r8 - r5
            if (r8 != r4) goto L_0x0078
            goto L_0x00c2
        L_0x00a7:
            switch(r2) {
                case 90: goto L_0x00c2;
                case 91: goto L_0x00ab;
                case 92: goto L_0x00c1;
                default: goto L_0x00aa;
            }
        L_0x00aa:
            goto L_0x00a7
        L_0x00ab:
            r8 = 28
            r4 = 19
            int r5 = r1 * r1
            int r5 = r5 * r1
            int r6 = r8 * r8
            int r6 = r6 * r8
            int r5 = r5 + r6
            int r6 = r4 * r4
            int r6 = r6 * r4
            int r5 = r5 + r6
            r6 = 9
            int r6 = r6 * r8
            int r6 = r6 * r4
            int r6 = r6 * r0
            if (r5 >= r6) goto L_0x00a7
        L_0x00c1:
            return
        L_0x00c2:
            r8 = 39
            r4 = 94
            if (r4 == r8) goto L_0x00c9
            goto L_0x00e0
        L_0x00c9:
            r8 = 18
            r4 = 16
            int r5 = r2 * r2
            int r6 = r8 * r8
            int r5 = r5 + r6
            int r6 = r4 * r4
            int r5 = r5 + r6
            r6 = 92
            int r6 = r6 * r8
            int r8 = r8 * r4
            int r6 = r6 + r8
            r8 = 92
            int r8 = r8 * r4
            int r6 = r6 + r8
            if (r5 >= r6) goto L_0x00a7
        L_0x00e0:
            r8 = 77
            int r4 = 77 - r3
            int r4 = r4 * r8
            int r8 = r8 * 2
            int r8 = r8 - r3
            int r4 = r4 * r8
            int r4 = r4 % 6
            if (r4 == 0) goto L_0x00a7
            goto L_0x0078
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.u.d(org.json.JSONObject):void");
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0046, code lost:
        if ((((94 + 1) * 94) % 2) != 0) goto L_0x0048;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x006a, code lost:
        if (((((26 * 26) * 26) + ((9 * 9) * 9)) + ((15 * 15) * 15)) >= (((26 * 9) * 15) * 3)) goto L_0x0096;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0077, code lost:
        if (((((40 - 1) * 40) * ((40 * 2) - 1)) % 6) == 0) goto L_0x001d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x001d, code lost:
        continue;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void e(org.json.JSONObject r7) throws java.lang.Exception {
        /*
            r6 = this;
            com.bytedance.sdk.openadsdk.core.model.n r0 = r6.q
            java.lang.String r0 = com.bytedance.sdk.openadsdk.core.model.p.b(r0)
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x0096
            java.lang.String r0 = "pmczegjbWz~r`h"
            java.lang.String r0 = com.bytedance.sdk.component.f.c.d.d1667305730926dc(r0)
            com.bytedance.sdk.openadsdk.core.model.n r1 = r6.q
            java.lang.String r1 = com.bytedance.sdk.openadsdk.core.model.p.b(r1)
            r7.put(r0, r1)
        L_0x001d:
            r7 = 49
            r0 = 60
            r1 = -1
            r2 = 1
            switch(r0) {
                case 60: goto L_0x0027;
                case 61: goto L_0x0055;
                case 62: goto L_0x006c;
                default: goto L_0x0026;
            }
        L_0x0026:
            goto L_0x001d
        L_0x0027:
            switch(r7) {
                case 49: goto L_0x0079;
                case 50: goto L_0x002b;
                case 51: goto L_0x002b;
                default: goto L_0x002a;
            }
        L_0x002a:
            goto L_0x0055
        L_0x002b:
            r7 = 87
            int r0 = 87 - r2
            int r0 = r0 * r7
            int r7 = r7 * 2
            int r7 = r7 - r2
            int r0 = r0 * r7
            int r0 = r0 % 6
            if (r0 == 0) goto L_0x0039
            goto L_0x0079
        L_0x0039:
            r7 = 94
            r0 = r7
        L_0x003c:
            switch(r0) {
                case 55: goto L_0x0040;
                case 56: goto L_0x0048;
                case 57: goto L_0x001d;
                default: goto L_0x003f;
            }
        L_0x003f:
            goto L_0x0052
        L_0x0040:
            r0 = 94
            int r0 = r0 + r2
            int r0 = r0 * r7
            int r0 = r0 % 2
            if (r0 == 0) goto L_0x0079
        L_0x0048:
            r7 = 18
            int r7 = r7 * r7
            r0 = 35
            int r0 = r0 * r0
            int r0 = r0 * 34
            int r7 = r7 - r0
            goto L_0x001d
        L_0x0052:
            r0 = 56
            goto L_0x003c
        L_0x0055:
            r7 = 26
            r0 = 9
            r3 = 15
            int r4 = r7 * r7
            int r4 = r4 * r7
            int r5 = r0 * r0
            int r5 = r5 * r0
            int r4 = r4 + r5
            int r5 = r3 * r3
            int r5 = r5 * r3
            int r4 = r4 + r5
            int r7 = r7 * r0
            int r7 = r7 * r3
            int r7 = r7 * 3
            if (r4 >= r7) goto L_0x0096
        L_0x006c:
            r7 = 40
            int r0 = 40 - r2
            int r0 = r0 * r7
            int r7 = r7 * 2
            int r7 = r7 - r2
            int r0 = r0 * r7
            int r0 = r0 % 6
            if (r0 == 0) goto L_0x001d
        L_0x0079:
            r7 = 53
            switch(r7) {
                case 52: goto L_0x008b;
                case 53: goto L_0x0096;
                case 54: goto L_0x007f;
                default: goto L_0x007e;
            }
        L_0x007e:
            goto L_0x0079
        L_0x007f:
            r7 = 61
            int r7 = r7 * r7
            r0 = 12
            int r0 = r0 * r0
            int r0 = r0 * 34
            int r7 = r7 - r0
            if (r7 != r1) goto L_0x0079
            goto L_0x001d
        L_0x008b:
            r7 = 13
            int r7 = r7 * r7
            r0 = 19
            int r0 = r0 * r0
            int r0 = r0 * 34
            int r7 = r7 - r0
            if (r7 != r1) goto L_0x008b
        L_0x0096:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.u.e(org.json.JSONObject):void");
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x003c, code lost:
        if (((((26 * 26) * 26) + ((9 * 9) * 9)) + ((15 * 15) * 15)) >= (((26 * 9) * 15) * 3)) goto L_0x0080;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x003e, code lost:
        r4 = 0 * 0;
        r0 = 80 * 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x004a, code lost:
        if ((((80 * 80) + r4) + r4) >= ((r4 + r0) + r0)) goto L_0x000b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0052, code lost:
        if ((((15 + 1) * 15) % 2) == 0) goto L_0x0029;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0060, code lost:
        if (((((30 - 1) * 30) * ((30 * 2) - 1)) % 6) == 0) goto L_0x000b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0069, code lost:
        if ((((39 + 1) * 39) % 2) == 0) goto L_0x000b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x007e, code lost:
        if ((((70 * 70) + (7 * 7)) + (4 * 4)) >= (((70 * 7) + (7 * 4)) + (70 * 4))) goto L_0x0062;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x000b, code lost:
        continue;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x000b, code lost:
        continue;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x000b, code lost:
        continue;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0022, code lost:
        if (((18 * 18) - ((35 * 35) * 34)) == -1) goto L_0x0029;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0025, code lost:
        switch(95) {
            case 55: goto L_0x0029;
            case 56: goto L_0x003e;
            case 57: goto L_0x004c;
            default: goto L_0x0028;
        };
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void f(org.json.JSONObject r6) {
        /*
            r5 = this;
            if (r6 == 0) goto L_0x000b
            com.bytedance.sdk.openadsdk.c.m r0 = r5.H
            if (r0 != 0) goto L_0x0007
            goto L_0x000b
        L_0x0007:
            r0.b((org.json.JSONObject) r6)
            goto L_0x0054
        L_0x000b:
            r6 = 15
            r0 = 95
            r1 = 1
            switch(r0) {
                case 94: goto L_0x0055;
                case 95: goto L_0x0014;
                case 96: goto L_0x0025;
                default: goto L_0x0013;
            }
        L_0x0013:
            goto L_0x000b
        L_0x0014:
            switch(r0) {
                case 94: goto L_0x006b;
                case 95: goto L_0x0080;
                case 96: goto L_0x0018;
                default: goto L_0x0017;
            }
        L_0x0017:
            goto L_0x0025
        L_0x0018:
            r0 = 18
            int r0 = r0 * r0
            r2 = 35
            int r2 = r2 * r2
            int r2 = r2 * 34
            int r0 = r0 - r2
            r2 = -1
            if (r0 != r2) goto L_0x006b
            goto L_0x0029
        L_0x0025:
            switch(r0) {
                case 55: goto L_0x0029;
                case 56: goto L_0x003e;
                case 57: goto L_0x004c;
                default: goto L_0x0028;
            }
        L_0x0028:
            goto L_0x0055
        L_0x0029:
            r0 = 26
            r2 = 9
            int r3 = r0 * r0
            int r3 = r3 * r0
            int r4 = r2 * r2
            int r4 = r4 * r2
            int r3 = r3 + r4
            int r4 = r6 * r6
            int r4 = r4 * r6
            int r3 = r3 + r4
            int r0 = r0 * r2
            int r0 = r0 * r6
            int r0 = r0 * 3
            if (r3 >= r0) goto L_0x0080
        L_0x003e:
            r0 = 80
            r2 = 0
            int r3 = r0 * r0
            int r4 = r2 * r2
            int r3 = r3 + r4
            int r3 = r3 + r4
            int r0 = r0 * r2
            int r4 = r4 + r0
            int r4 = r4 + r0
            if (r3 >= r4) goto L_0x000b
        L_0x004c:
            r0 = 15
            int r0 = r0 + r1
            int r0 = r0 * r6
            int r0 = r0 % 2
            if (r0 == 0) goto L_0x0029
        L_0x0054:
            return
        L_0x0055:
            r6 = 30
            int r0 = 30 - r1
            int r0 = r0 * r6
            int r6 = r6 * 2
            int r6 = r6 - r1
            int r0 = r0 * r6
            int r0 = r0 % 6
            if (r0 == 0) goto L_0x000b
        L_0x0062:
            r6 = 39
            int r6 = r6 + r1
            int r6 = r6 * 39
            int r6 = r6 % 2
            if (r6 == 0) goto L_0x000b
        L_0x006b:
            r6 = 70
            r0 = 7
            r2 = 4
            int r3 = r6 * r6
            int r4 = r0 * r0
            int r3 = r3 + r4
            int r4 = r2 * r2
            int r3 = r3 + r4
            r4 = 70
            int r4 = r4 * r0
            int r0 = r0 * r2
            int r4 = r4 + r0
            int r6 = r6 * r2
            int r4 = r4 + r6
            if (r3 >= r4) goto L_0x0062
        L_0x0080:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.u.f(org.json.JSONObject):void");
    }

    private void g(JSONObject jSONObject) {
        com.bytedance.sdk.openadsdk.jslistener.b bVar = this.A;
        if (bVar != null && jSONObject != null) {
            bVar.a(jSONObject.optBoolean(com.bytedance.sdk.component.f.c.d.d1667305730926dc("irPfjacu[|i"), false), jSONObject.optInt(com.bytedance.sdk.component.f.c.d.d1667305730926dc("cnff"), -1), jSONObject.optString(com.bytedance.sdk.component.f.c.d.d1667305730926dc("mre"), ""));
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(9:5|6|7|(1:9)|10|11|(1:29)(2:13|(2:15|30)(2:16|28))|17|3) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x0069 */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0073 A[Catch:{ Exception -> 0x00bd }] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x008b A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void h(java.lang.String r10) {
        /*
            r9 = this;
            java.lang.String r0 = "TUCm`winlFhainz"
            java.lang.String r1 = new java.lang.String     // Catch:{ Exception -> 0x00bd }
            r2 = 2
            byte[] r2 = android.util.Base64.decode(r10, r2)     // Catch:{ Exception -> 0x00bd }
            r1.<init>(r2)     // Catch:{ Exception -> 0x00bd }
            java.lang.String r2 = com.bytedance.sdk.component.adexpress.widget.FlowLightView.FlowLightView1667305730929dc(r0)     // Catch:{ Exception -> 0x00bd }
            com.bytedance.sdk.component.utils.l.b((java.lang.String) r2, (java.lang.String) r1)     // Catch:{ Exception -> 0x00bd }
            org.json.JSONArray r2 = new org.json.JSONArray     // Catch:{ Exception -> 0x00bd }
            r2.<init>(r1)     // Catch:{ Exception -> 0x00bd }
            int r1 = r2.length()     // Catch:{ Exception -> 0x00bd }
            r3 = 0
        L_0x001d:
            r4 = 11
            if (r3 >= r1) goto L_0x008e
            com.bytedance.sdk.openadsdk.core.u$a r5 = new com.bytedance.sdk.openadsdk.core.u$a     // Catch:{ Exception -> 0x00bd }
            r5.<init>()     // Catch:{ Exception -> 0x00bd }
            org.json.JSONObject r6 = r2.optJSONObject(r3)     // Catch:{ all -> 0x0069 }
            if (r6 == 0) goto L_0x0069
            java.lang.String r7 = "_^opcZr~xl"
            java.lang.String r7 = com.bytedance.sdk.component.adexpress.widget.FlowLightView.FlowLightView1667305730929dc(r7)     // Catch:{ all -> 0x0069 }
            r8 = 0
            java.lang.String r7 = r6.optString(r7, r8)     // Catch:{ all -> 0x0069 }
            r5.a = r7     // Catch:{ all -> 0x0069 }
            java.lang.String r7 = "_^abhidfkbUbh"
            java.lang.String r7 = com.bytedance.sdk.component.adexpress.widget.FlowLightView.FlowLightView1667305730929dc(r7)     // Catch:{ all -> 0x0069 }
            java.lang.String r7 = r6.optString(r7, r8)     // Catch:{ all -> 0x0069 }
            r5.b = r7     // Catch:{ all -> 0x0069 }
            java.lang.String r7 = "ftl`"
            java.lang.String r7 = com.bytedance.sdk.component.adexpress.widget.FlowLightView.FlowLightView1667305730929dc(r7)     // Catch:{ all -> 0x0069 }
            java.lang.String r7 = r6.optString(r7)     // Catch:{ all -> 0x0069 }
            r5.c = r7     // Catch:{ all -> 0x0069 }
            java.lang.String r7 = "p`pbiv"
            java.lang.String r7 = com.bytedance.sdk.component.adexpress.widget.FlowLightView.FlowLightView1667305730929dc(r7)     // Catch:{ all -> 0x0069 }
            org.json.JSONObject r7 = r6.optJSONObject(r7)     // Catch:{ all -> 0x0069 }
            r5.d = r7     // Catch:{ all -> 0x0069 }
            java.lang.String r7 = "JRQGO"
            java.lang.String r7 = com.bytedance.sdk.component.f.c.e.e1667305730908dc(r7)     // Catch:{ all -> 0x0069 }
            int r6 = r6.optInt(r7)     // Catch:{ all -> 0x0069 }
            r5.e = r6     // Catch:{ all -> 0x0069 }
        L_0x0069:
            java.lang.String r6 = r5.a     // Catch:{ Exception -> 0x00bd }
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6     // Catch:{ Exception -> 0x00bd }
            boolean r6 = android.text.TextUtils.isEmpty(r6)     // Catch:{ Exception -> 0x00bd }
            if (r6 != 0) goto L_0x008b
            java.lang.String r6 = r5.c     // Catch:{ Exception -> 0x00bd }
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6     // Catch:{ Exception -> 0x00bd }
            boolean r6 = android.text.TextUtils.isEmpty(r6)     // Catch:{ Exception -> 0x00bd }
            if (r6 == 0) goto L_0x007e
            goto L_0x008b
        L_0x007e:
            com.bytedance.sdk.component.utils.x r6 = r9.e     // Catch:{ Exception -> 0x00bd }
            android.os.Message r4 = r6.obtainMessage(r4)     // Catch:{ Exception -> 0x00bd }
            r4.obj = r5     // Catch:{ Exception -> 0x00bd }
            com.bytedance.sdk.component.utils.x r5 = r9.e     // Catch:{ Exception -> 0x00bd }
            r5.sendMessage(r4)     // Catch:{ Exception -> 0x00bd }
        L_0x008b:
            int r3 = r3 + 1
            goto L_0x001d
        L_0x008e:
            switch(r4) {
                case 11: goto L_0x00ed;
                case 12: goto L_0x0092;
                case 13: goto L_0x00a7;
                default: goto L_0x0091;
            }
        L_0x0091:
            goto L_0x008e
        L_0x0092:
            r10 = 4
            r0 = 32
            r1 = 25
            int r2 = r10 * r10
            int r3 = r0 * r0
            int r2 = r2 + r3
            int r3 = r1 * r1
            int r2 = r2 + r3
            r3 = 4
            int r3 = r3 * r0
            int r0 = r0 * r1
            int r3 = r3 + r0
            int r10 = r10 * r1
            int r3 = r3 + r10
            if (r2 >= r3) goto L_0x00ed
        L_0x00a7:
            r10 = 46
            r0 = 12
            r1 = 27
            int r2 = r10 * r10
            int r3 = r0 * r0
            int r2 = r2 + r3
            int r3 = r1 * r1
            int r2 = r2 + r3
            r3 = 46
            int r3 = r3 * r0
            int r0 = r0 * r1
            int r3 = r3 + r0
            int r10 = r10 * r1
            int r3 = r3 + r10
            goto L_0x00ed
        L_0x00bd:
            boolean r1 = com.bytedance.sdk.component.utils.l.a()
            if (r1 == 0) goto L_0x00e0
            java.lang.String r0 = com.bytedance.sdk.component.f.c.e.e1667305730908dc(r0)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "f`koaa&sg)zj~~k/zbpa}qqr8ti|<lkzUD\u0002"
            java.lang.String r2 = com.bytedance.sdk.component.f.c.e.e1667305730908dc(r2)
            r1.append(r2)
            r1.append(r10)
            java.lang.String r10 = r1.toString()
            com.bytedance.sdk.component.utils.l.d(r0, r10)
            goto L_0x00ed
        L_0x00e0:
            java.lang.String r10 = com.bytedance.sdk.component.f.c.e.e1667305730908dc(r0)
            java.lang.String r0 = "f`koaa&sg)zj~~k/zbpa}qqr8ti|<lkzUD"
            java.lang.String r0 = com.bytedance.sdk.component.f.c.e.e1667305730908dc(r0)
            com.bytedance.sdk.component.utils.l.d(r10, r0)
        L_0x00ed:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.u.h(java.lang.String):void");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0038, code lost:
        switch(96) {
            case 94: goto L_0x003c;
            case 95: goto L_0x0053;
            case 96: goto L_0x009d;
            default: goto L_0x003b;
        };
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0051, code lost:
        if ((((57 * 57) + (34 * 34)) + (12 * 12)) >= (((57 * 34) + (34 * 12)) + (57 * 12))) goto L_0x0018;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0053, code lost:
        r4 = '1';
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0056, code lost:
        switch(r5) {
            case 55: goto L_0x0064;
            case 56: goto L_0x0018;
            case 57: goto L_0x005a;
            default: goto L_0x0059;
        };
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0061, code lost:
        if (((18 * 18) - ((35 * 35) * 34)) != -1) goto L_0x0034;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0064, code lost:
        switch(r4) {
            case 60: goto L_0x0068;
            case 61: goto L_0x007f;
            case 62: goto L_0x008a;
            default: goto L_0x0067;
        };
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x007d, code lost:
        if (((((26 * 26) * 26) + ((9 * 9) * 9)) + ((15 * 15) * 15)) >= (((26 * 9) * 15) * 3)) goto L_0x009d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0088, code lost:
        if (((((0 - 1) * 0) * ((0 * 2) - 1)) % 6) == 0) goto L_0x0034;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0095, code lost:
        if (((((18 - 1) * 18) * ((18 * 2) - 1)) % 6) == 0) goto L_0x008a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0098, code lost:
        r5 = '7';
        r4 = '=';
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0018, code lost:
        continue;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0018, code lost:
        continue;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0034, code lost:
        continue;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void h(org.json.JSONObject r11) {
        /*
            r10 = this;
            com.bytedance.sdk.openadsdk.core.nativeexpress.i r0 = r10.s
            if (r0 == 0) goto L_0x009d
            if (r11 != 0) goto L_0x0008
            goto L_0x009d
        L_0x0008:
            java.lang.String r0 = "mtvf"
            java.lang.String r0 = com.bytedance.sdk.component.f.b.a.a1667305730938dc(r0)     // Catch:{ Exception -> 0x009d }
            r1 = 0
            boolean r11 = r11.optBoolean(r0, r1)     // Catch:{ Exception -> 0x009d }
            com.bytedance.sdk.openadsdk.core.nativeexpress.i r0 = r10.s     // Catch:{ Exception -> 0x009d }
            r0.a((boolean) r11)     // Catch:{ Exception -> 0x009d }
        L_0x0018:
            r11 = -1
            r0 = 49
            r2 = 34
            r3 = 1
            switch(r0) {
                case 49: goto L_0x0034;
                case 50: goto L_0x0022;
                case 51: goto L_0x002c;
                default: goto L_0x0021;
            }     // Catch:{ Exception -> 0x009d }
        L_0x0021:
            goto L_0x0018
        L_0x0022:
            r0 = 13
            int r0 = r0 * r0
            r1 = 19
            int r1 = r1 * r1
            int r1 = r1 * r2
            int r0 = r0 - r1
            if (r0 != r11) goto L_0x009d
        L_0x002c:
            r11 = 10
            int r11 = r11 + r3
            int r11 = r11 * 10
            int r11 = r11 % 2
            goto L_0x009d
        L_0x0034:
            r4 = 96
            r5 = 52
            switch(r4) {
                case 94: goto L_0x003c;
                case 95: goto L_0x0053;
                case 96: goto L_0x009d;
                default: goto L_0x003b;
            }     // Catch:{ Exception -> 0x009d }
        L_0x003b:
            goto L_0x0034
        L_0x003c:
            r4 = 57
            r6 = 12
            int r7 = r4 * r4
            int r8 = r2 * r2
            int r7 = r7 + r8
            int r8 = r6 * r6
            int r7 = r7 + r8
            r8 = 57
            int r8 = r8 * r2
            r9 = 34
            int r9 = r9 * r6
            int r8 = r8 + r9
            int r4 = r4 * r6
            int r8 = r8 + r4
            if (r7 >= r8) goto L_0x0018
        L_0x0053:
            r4 = r0
        L_0x0054:
            r6 = 18
            switch(r5) {
                case 55: goto L_0x0064;
                case 56: goto L_0x0018;
                case 57: goto L_0x005a;
                default: goto L_0x0059;
            }     // Catch:{ Exception -> 0x009d }
        L_0x0059:
            goto L_0x0098
        L_0x005a:
            int r4 = r6 * r6
            r5 = 35
            int r5 = r5 * r5
            int r5 = r5 * r2
            int r4 = r4 - r5
            if (r4 != r11) goto L_0x0034
            goto L_0x0068
        L_0x0064:
            switch(r4) {
                case 60: goto L_0x0068;
                case 61: goto L_0x007f;
                case 62: goto L_0x008a;
                default: goto L_0x0067;
            }     // Catch:{ Exception -> 0x009d }
        L_0x0067:
            goto L_0x0018
        L_0x0068:
            r4 = 26
            r5 = 9
            r7 = 15
            int r8 = r4 * r4
            int r8 = r8 * r4
            int r9 = r5 * r5
            int r9 = r9 * r5
            int r8 = r8 + r9
            int r9 = r7 * r7
            int r9 = r9 * r7
            int r8 = r8 + r9
            int r4 = r4 * r5
            int r4 = r4 * r7
            int r4 = r4 * 3
            if (r8 >= r4) goto L_0x009d
        L_0x007f:
            int r4 = 0 - r3
            int r4 = r4 * r1
            int r5 = r1 * 2
            int r5 = r5 - r3
            int r4 = r4 * r5
            int r4 = r4 % 6
            if (r4 == 0) goto L_0x0034
        L_0x008a:
            int r4 = 18 - r3
            int r4 = r4 * r6
            r5 = 18
            int r5 = r5 * 2
            int r5 = r5 - r3
            int r4 = r4 * r5
            int r4 = r4 % 6
            if (r4 == 0) goto L_0x008a
            goto L_0x0034
        L_0x0098:
            r5 = 55
            r4 = 61
            goto L_0x0054
        L_0x009d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.u.h(org.json.JSONObject):void");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0066, code lost:
        if (((((26 * 26) * 26) + ((9 * 9) * 9)) + ((15 * 15) * 15)) >= (((26 * 9) * 15) * 3)) goto L_0x009a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0072, code lost:
        if (((((0 - 1) * 0) * ((0 * 2) - 1)) % 6) == 0) goto L_0x0018;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x007d, code lost:
        if (((((18 - 1) * 18) * ((18 * 2) - 1)) % 6) == 0) goto L_0x0074;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x0018, code lost:
        continue;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void i(org.json.JSONObject r10) {
        /*
            r9 = this;
            com.bytedance.sdk.openadsdk.core.nativeexpress.i r0 = r9.s
            if (r0 == 0) goto L_0x009a
            if (r10 != 0) goto L_0x0008
            goto L_0x009a
        L_0x0008:
            java.lang.String r0 = "sucwaQwm"
            java.lang.String r0 = com.bytedance.sdk.component.adexpress.widget.DynamicUnlockView.DynamicUnlockView1667305730929dc(r0)     // Catch:{ Exception -> 0x009a }
            r1 = -1
            int r10 = r10.optInt(r0, r1)     // Catch:{ Exception -> 0x009a }
            com.bytedance.sdk.openadsdk.core.nativeexpress.i r0 = r9.s     // Catch:{ Exception -> 0x009a }
            r0.a((int) r10)     // Catch:{ Exception -> 0x009a }
        L_0x0018:
            r10 = 96
            r0 = 52
            r2 = 13
            r3 = 34
            r4 = 1
            switch(r10) {
                case 94: goto L_0x0025;
                case 95: goto L_0x003c;
                case 96: goto L_0x0085;
                default: goto L_0x0024;
            }     // Catch:{ Exception -> 0x009a }
        L_0x0024:
            goto L_0x0018
        L_0x0025:
            r10 = 57
            r5 = 12
            int r6 = r10 * r10
            int r7 = r3 * r3
            int r6 = r6 + r7
            int r7 = r5 * r5
            int r6 = r6 + r7
            r7 = 57
            int r7 = r7 * r3
            r8 = 34
            int r8 = r8 * r5
            int r7 = r7 + r8
            int r10 = r10 * r5
            int r7 = r7 + r10
            if (r6 >= r7) goto L_0x0085
        L_0x003c:
            r10 = r2
        L_0x003d:
            r5 = 18
            switch(r0) {
                case 55: goto L_0x004d;
                case 56: goto L_0x0085;
                case 57: goto L_0x0043;
                default: goto L_0x0042;
            }     // Catch:{ Exception -> 0x009a }
        L_0x0042:
            goto L_0x0080
        L_0x0043:
            int r10 = r5 * r5
            r0 = 35
            int r0 = r0 * r0
            int r0 = r0 * r3
            int r10 = r10 - r0
            if (r10 != r1) goto L_0x009a
            goto L_0x0051
        L_0x004d:
            switch(r10) {
                case 60: goto L_0x0051;
                case 61: goto L_0x0068;
                case 62: goto L_0x0074;
                default: goto L_0x0050;
            }     // Catch:{ Exception -> 0x009a }
        L_0x0050:
            goto L_0x0085
        L_0x0051:
            r10 = 26
            r0 = 9
            r2 = 15
            int r3 = r10 * r10
            int r3 = r3 * r10
            int r6 = r0 * r0
            int r6 = r6 * r0
            int r3 = r3 + r6
            int r6 = r2 * r2
            int r6 = r6 * r2
            int r3 = r3 + r6
            int r10 = r10 * r0
            int r10 = r10 * r2
            int r10 = r10 * 3
            if (r3 >= r10) goto L_0x009a
        L_0x0068:
            r10 = 0
            int r0 = 0 - r4
            int r0 = r0 * r10
            int r10 = r10 * 2
            int r10 = r10 - r4
            int r0 = r0 * r10
            int r0 = r0 % 6
            if (r0 == 0) goto L_0x0018
        L_0x0074:
            int r10 = 18 - r4
            int r10 = r10 * r5
            int r0 = r5 * 2
            int r0 = r0 - r4
            int r10 = r10 * r0
            int r10 = r10 % 6
            if (r10 == 0) goto L_0x0074
            goto L_0x009a
        L_0x0080:
            r0 = 55
            r10 = 61
            goto L_0x003d
        L_0x0085:
            r10 = 49
            switch(r10) {
                case 49: goto L_0x009a;
                case 50: goto L_0x008b;
                case 51: goto L_0x0093;
                default: goto L_0x008a;
            }     // Catch:{ Exception -> 0x009a }
        L_0x008a:
            goto L_0x0085
        L_0x008b:
            int r2 = r2 * r2
            r10 = 19
            int r10 = r10 * r10
            int r10 = r10 * r3
            int r2 = r2 - r10
            if (r2 != r1) goto L_0x009a
        L_0x0093:
            r10 = 10
            int r10 = r10 + r4
            int r10 = r10 * 10
            int r10 = r10 % 2
        L_0x009a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.u.i(org.json.JSONObject):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x003c, code lost:
        if (((18 * 18) - ((35 * 35) * 34)) != -1) goto L_0x0089;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0040, code lost:
        switch(54) {
            case 52: goto L_0x0044;
            case 53: goto L_0x0053;
            case 54: goto L_0x005c;
            default: goto L_0x0043;
        };
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0051, code lost:
        if ((((69 * 69) + (22 * 22)) - ((69 * 22) * 2)) >= 0) goto L_0x005d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x005a, code lost:
        if (((61 * 61) - ((12 * 12) * 34)) != -1) goto L_0x001d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x005c, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0070, code lost:
        if (((((26 * 26) * 26) + ((9 * 9) * 9)) + ((15 * 15) * 15)) >= (((26 * 9) * 15) * 3)) goto L_0x0088;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0072, code lost:
        r7 = 0 * 0;
        r0 = 80 * 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x007d, code lost:
        if ((((80 * 80) + r7) + r7) >= ((r7 + r0) + r0)) goto L_0x002f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0085, code lost:
        if ((((15 + 1) * 15) % 2) == 0) goto L_0x0088;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0096, code lost:
        if ((((70 * 70) + (44 * 44)) - ((70 * 44) * 2)) >= 0) goto L_0x0099;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0099, code lost:
        if (r10 != false) goto L_0x009c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x009c, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean i(java.lang.String r10) {
        /*
            r9 = this;
            r0 = r10
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            r1 = 1
            if (r0 == 0) goto L_0x000b
            return r1
        L_0x000b:
            java.lang.String r0 = "cmk`oZis`lx"
            java.lang.String r0 = com.bytedance.sdk.component.d.c.f.f1667305730962dc(r0)
            boolean r10 = r0.equals(r10)
            if (r10 != 0) goto L_0x0019
            goto L_0x0088
        L_0x0019:
            boolean r10 = r9.j()
        L_0x001d:
            r0 = 51
            r2 = 96
            r3 = 0
            r4 = 15
            r5 = -1
            r6 = 61
            switch(r2) {
                case 95: goto L_0x002f;
                case 96: goto L_0x002b;
                case 97: goto L_0x0089;
                default: goto L_0x002a;
            }
        L_0x002a:
            goto L_0x001d
        L_0x002b:
            switch(r0) {
                case 49: goto L_0x0072;
                case 50: goto L_0x007f;
                case 51: goto L_0x0099;
                default: goto L_0x002e;
            }
        L_0x002e:
            goto L_0x0089
        L_0x002f:
            switch(r6) {
                case 60: goto L_0x0033;
                case 61: goto L_0x003e;
                case 62: goto L_0x005d;
                default: goto L_0x0032;
            }
        L_0x0032:
            goto L_0x002f
        L_0x0033:
            r0 = 18
            int r0 = r0 * r0
            r2 = 35
            int r2 = r2 * r2
            int r2 = r2 * 34
            int r0 = r0 - r2
            if (r0 != r5) goto L_0x0089
        L_0x003e:
            r0 = 54
            switch(r0) {
                case 52: goto L_0x0044;
                case 53: goto L_0x0053;
                case 54: goto L_0x005c;
                default: goto L_0x0043;
            }
        L_0x0043:
            goto L_0x003e
        L_0x0044:
            r0 = 69
            r2 = 22
            int r7 = r0 * r0
            int r8 = r2 * r2
            int r7 = r7 + r8
            int r0 = r0 * r2
            int r0 = r0 * 2
            int r7 = r7 - r0
            if (r7 >= 0) goto L_0x005d
        L_0x0053:
            int r6 = r6 * r6
            r0 = 12
            int r0 = r0 * r0
            int r0 = r0 * 34
            int r6 = r6 - r0
            if (r6 != r5) goto L_0x001d
        L_0x005c:
            return r3
        L_0x005d:
            r0 = 26
            r2 = 9
            int r7 = r0 * r0
            int r7 = r7 * r0
            int r8 = r2 * r2
            int r8 = r8 * r2
            int r7 = r7 + r8
            int r8 = r4 * r4
            int r8 = r8 * r4
            int r7 = r7 + r8
            int r0 = r0 * r2
            int r0 = r0 * r4
            int r0 = r0 * 3
            if (r7 >= r0) goto L_0x0088
        L_0x0072:
            r0 = 80
            int r2 = r0 * r0
            int r7 = r3 * r3
            int r2 = r2 + r7
            int r2 = r2 + r7
            int r0 = r0 * r3
            int r7 = r7 + r0
            int r7 = r7 + r0
            if (r2 >= r7) goto L_0x002f
        L_0x007f:
            r0 = 15
            int r0 = r0 + r1
            int r0 = r0 * r4
            int r0 = r0 % 2
            if (r0 == 0) goto L_0x0088
            goto L_0x0099
        L_0x0088:
            return r1
        L_0x0089:
            r0 = 70
            r2 = 44
            int r7 = r0 * r0
            int r8 = r2 * r2
            int r7 = r7 + r8
            int r0 = r0 * r2
            int r0 = r0 * 2
            int r7 = r7 - r0
            if (r7 >= 0) goto L_0x0099
            goto L_0x0033
        L_0x0099:
            if (r10 != 0) goto L_0x009c
            goto L_0x002f
        L_0x009c:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.u.i(java.lang.String):boolean");
    }

    private String j(String str) {
        if (this.r != null) {
            return str;
        }
        int i2 = this.m;
        while (true) {
            char c2 = '_';
            char c3 = '_';
            while (true) {
                switch (c2) {
                    case '^':
                        if (c3 != '\'') {
                            break;
                        } else {
                            continue;
                        }
                    case '_':
                        switch (c3) {
                            case '^':
                            case '`':
                                continue;
                            case '_':
                                break;
                        }
                    case '`':
                        break;
                }
                switch (c3) {
                    case '8':
                        break;
                }
                c2 = '^';
                c3 = '}';
            }
        }
        return y.a(i2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0056, code lost:
        switch(95) {
            case 94: goto L_0x0072;
            case 95: goto L_0x009e;
            case 96: goto L_0x005a;
            default: goto L_0x0059;
        };
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0062, code lost:
        if (((61 * 61) - ((21 * 21) * 34)) != -1) goto L_0x004a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0070, code lost:
        if (((((38 - 1) * 38) * ((38 * 2) - 1)) % 6) == 0) goto L_0x0054;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0087, code lost:
        if ((((27 * 27) + (34 * 34)) + (17 * 17)) >= (((27 * 34) + (34 * 17)) + (27 * 17))) goto L_0x008a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0091, code lost:
        if ((((10 + 1) * 10) % 2) == 0) goto L_0x0094;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x009b, code lost:
        if (((5 * 5) - ((28 * 28) * 34)) != -1) goto L_0x009e;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean j(org.json.JSONObject r10) {
        /*
            r9 = this;
            com.bytedance.sdk.openadsdk.core.nativeexpress.i r0 = r9.s
            r1 = 0
            if (r0 == 0) goto L_0x009f
            if (r10 != 0) goto L_0x0009
            goto L_0x009f
        L_0x0009:
            long r2 = r0.c()
            double r2 = (double) r2
            com.bytedance.sdk.openadsdk.core.nativeexpress.i r0 = r9.s
            int r0 = r0.d()
            java.lang.String r4 = "ctpqakrSado"
            java.lang.String r4 = com.bytedance.sdk.component.adexpress.widget.DynamicUnlockView.DynamicUnlockView1667305730929dc(r4)     // Catch:{ Exception -> 0x009f }
            r5 = 4652007308841189376(0x408f400000000000, double:1000.0)
            double r2 = r2 / r5
            r10.put(r4, r2)     // Catch:{ Exception -> 0x009f }
            java.lang.String r2 = "sucwa"
            java.lang.String r2 = com.bytedance.sdk.component.adexpress.widget.DynamicUnlockView.DynamicUnlockView1667305730929dc(r2)     // Catch:{ Exception -> 0x009f }
            r10.put(r2, r0)     // Catch:{ Exception -> 0x009f }
        L_0x002c:
            java.lang.String r10 = "TUCm`winlFhainz"
            java.lang.String r10 = com.bytedance.sdk.component.adexpress.widget.DynamicUnlockView.DynamicUnlockView1667305730929dc(r10)     // Catch:{ Exception -> 0x009f }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x009f }
            r2.<init>()     // Catch:{ Exception -> 0x009f }
            java.lang.String r3 = "ctpqakrSado'yo{u+"
            java.lang.String r3 = com.bytedance.sdk.component.adexpress.widget.DynamicUnlockView.DynamicUnlockView1667305730929dc(r3)     // Catch:{ Exception -> 0x009f }
            r2.append(r3)     // Catch:{ Exception -> 0x009f }
            r2.append(r0)     // Catch:{ Exception -> 0x009f }
            java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x009f }
            com.bytedance.sdk.component.utils.l.b((java.lang.String) r10, (java.lang.String) r2)     // Catch:{ Exception -> 0x009f }
        L_0x004a:
            r10 = 70
            r2 = -1
            r3 = 34
            r4 = 1
            switch(r10) {
                case 70: goto L_0x0054;
                case 71: goto L_0x0054;
                case 72: goto L_0x008a;
                default: goto L_0x0053;
            }     // Catch:{ Exception -> 0x009f }
        L_0x0053:
            goto L_0x004a
        L_0x0054:
            r10 = 95
            switch(r10) {
                case 94: goto L_0x0072;
                case 95: goto L_0x009e;
                case 96: goto L_0x005a;
                default: goto L_0x0059;
            }     // Catch:{ Exception -> 0x009f }
        L_0x0059:
            goto L_0x0065
        L_0x005a:
            r10 = 61
            int r10 = r10 * r10
            r4 = 21
            int r4 = r4 * r4
            int r4 = r4 * r3
            int r10 = r10 - r4
            if (r10 != r2) goto L_0x004a
            goto L_0x002c
        L_0x0065:
            r10 = 38
            int r5 = 38 - r4
            int r5 = r5 * r10
            int r10 = r10 * 2
            int r10 = r10 - r4
            int r5 = r5 * r10
            int r5 = r5 % 6
            if (r5 == 0) goto L_0x0054
        L_0x0072:
            r10 = 27
            r5 = 17
            int r6 = r10 * r10
            int r7 = r3 * r3
            int r6 = r6 + r7
            int r7 = r5 * r5
            int r6 = r6 + r7
            r7 = 27
            int r7 = r7 * r3
            r8 = 34
            int r8 = r8 * r5
            int r7 = r7 + r8
            int r10 = r10 * r5
            int r7 = r7 + r10
            if (r6 >= r7) goto L_0x008a
            goto L_0x009e
        L_0x008a:
            r10 = 10
            int r10 = r10 + r4
            int r10 = r10 * 10
            int r10 = r10 % 2
            if (r10 == 0) goto L_0x0094
            goto L_0x0054
        L_0x0094:
            r10 = 5
            int r10 = r10 * r10
            r5 = 28
            int r5 = r5 * r5
            int r5 = r5 * r3
            int r10 = r10 - r5
            if (r10 != r2) goto L_0x009e
            goto L_0x002c
        L_0x009e:
            return r4
        L_0x009f:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.u.j(org.json.JSONObject):boolean");
    }

    private void k(String str) {
        if (str != null && str.startsWith(com.bytedance.sdk.component.f.c.d.d1667305730926dc("bxvf`dhdm3%$"))) {
            String d1667305730926dc = com.bytedance.sdk.component.f.c.d.d1667305730926dc("bxvf`dhdm3%$hd}qeq{Kxsdkx}~3");
            String d1667305730926dc2 = com.bytedance.sdk.component.f.c.d.d1667305730926dc("bxvf`dhdm3%$|gyqew<gpbe}jowh2");
            try {
                if (str.equals(d1667305730926dc)) {
                    WebView n2 = n();
                    if (n2 != null) {
                        k.a(n2, com.bytedance.sdk.component.f.c.d.d1667305730926dc("j`tbwftnx}0_cxzfq~X@Vgs|4Dzxj|HpWFQ@\u000e\u000e"));
                    }
                } else if (str.startsWith(d1667305730926dc2)) {
                    int length = d1667305730926dc2.length();
                    int indexOf = str.indexOf(38, length);
                    if (indexOf > 0) {
                        String substring = str.substring(length, indexOf);
                        String substring2 = str.substring(indexOf + 1);
                        if (substring.equals(com.bytedance.sdk.component.f.c.d.d1667305730926dc("SBGMAZ@B\\JBZYH[J")) && substring2.length() > 0) {
                            h(substring2);
                        }
                    }
                } else {
                    while (true) {
                        switch (84) {
                            case 84:
                                return;
                            case 85:
                                do {
                                } while ((26 * 26 * 26) + (9 * 9 * 9) + (15 * 15 * 15) >= 26 * 9 * 15 * 3);
                                break;
                            case 86:
                                break;
                        }
                    }
                    do {
                    } while ((((40 - 1) * 40) * ((40 * 2) - 1)) % 6 == 0);
                }
            } catch (Exception unused) {
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0114, code lost:
        switch(r2) {
            case 40: goto L_0x0114;
            case 41: goto L_0x0118;
            case 42: goto L_0x012e;
            default: goto L_0x0117;
        };
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0118, code lost:
        switch(r1) {
            case 70: goto L_0x010c;
            case 71: goto L_0x010c;
            case 72: goto L_0x012e;
            default: goto L_0x011b;
        };
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x010c, code lost:
        continue;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x012e, code lost:
        continue;
     */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x011e A[LOOP:3: B:42:0x011e->B:44:0x0126, LOOP_START, PHI: r1 
      PHI: (r1v15 char) = (r1v14 char), (r1v16 char) binds: [B:41:0x011c, B:44:0x0126] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0129  */
    @com.bytedance.JProtect
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void k(org.json.JSONObject r22) {
        /*
            r21 = this;
            r0 = r21
            r1 = r22
            com.bytedance.sdk.component.adexpress.b.j r2 = r0.r
            if (r2 == 0) goto L_0x014c
            if (r1 != 0) goto L_0x000c
            goto L_0x014c
        L_0x000c:
            com.bytedance.sdk.component.adexpress.b.m r2 = new com.bytedance.sdk.component.adexpress.b.m
            r2.<init>()
            r3 = 1
            r2.a((int) r3)
            java.lang.String r4 = "irPfjacu[|i"
            java.lang.String r4 = com.bytedance.sdk.component.d.c.f.f1667305730962dc(r4)     // Catch:{ Exception -> 0x013b }
            boolean r4 = r1.optBoolean(r4)     // Catch:{ Exception -> 0x013b }
            java.lang.String r5 = "AeQj~`"
            java.lang.String r5 = com.bytedance.sdk.component.d.c.f.f1667305730962dc(r5)     // Catch:{ Exception -> 0x013b }
            org.json.JSONObject r5 = r1.optJSONObject(r5)     // Catch:{ Exception -> 0x013b }
            java.lang.String r6 = "hdkdlq"
            java.lang.String r7 = "whfwl"
            r8 = 0
            if (r5 == 0) goto L_0x0047
            java.lang.String r8 = com.bytedance.sdk.component.d.c.f.f1667305730962dc(r7)     // Catch:{ Exception -> 0x013b }
            double r8 = r5.optDouble(r8)     // Catch:{ Exception -> 0x013b }
            java.lang.String r10 = com.bytedance.sdk.component.d.c.f.f1667305730962dc(r6)     // Catch:{ Exception -> 0x013b }
            double r10 = r5.optDouble(r10)     // Catch:{ Exception -> 0x013b }
            r19 = r8
            r8 = r10
            r10 = r19
            goto L_0x0048
        L_0x0047:
            r10 = r8
        L_0x0048:
            java.lang.String r5 = "vhffkLhag"
            java.lang.String r5 = com.bytedance.sdk.component.d.c.f.f1667305730962dc(r5)     // Catch:{ Exception -> 0x013b }
            org.json.JSONObject r5 = r1.optJSONObject(r5)     // Catch:{ Exception -> 0x013b }
            if (r5 == 0) goto L_0x00d0
            java.lang.String r12 = "x"
            java.lang.String r12 = com.bytedance.sdk.component.d.c.f.f1667305730962dc(r12)     // Catch:{ Exception -> 0x00ca }
            double r12 = r5.optDouble(r12)     // Catch:{ Exception -> 0x00ca }
            java.lang.String r14 = "y"
            java.lang.String r14 = com.bytedance.sdk.component.d.c.f.f1667305730962dc(r14)     // Catch:{ Exception -> 0x00ca }
            double r14 = r5.optDouble(r14)     // Catch:{ Exception -> 0x00ca }
            java.lang.String r7 = com.bytedance.sdk.component.d.c.f.f1667305730962dc(r7)     // Catch:{ Exception -> 0x00ca }
            r16 = r4
            double r3 = r5.optDouble(r7)     // Catch:{ Exception -> 0x00ca }
            java.lang.String r6 = com.bytedance.sdk.component.d.c.f.f1667305730962dc(r6)     // Catch:{ Exception -> 0x00ca }
            double r6 = r5.optDouble(r6)     // Catch:{ Exception -> 0x00ca }
            boolean r17 = r0.l(r5)     // Catch:{ Exception -> 0x00ca }
            if (r17 == 0) goto L_0x00bb
            java.lang.String r17 = "bnpgawTfl`xXb~Cuwf"
            java.lang.String r0 = com.bytedance.sdk.component.d.c.f.f1667305730962dc(r17)     // Catch:{ Exception -> 0x00ca }
            r17 = r8
            double r8 = r5.optDouble(r0)     // Catch:{ Exception -> 0x00ca }
            float r0 = (float) r8     // Catch:{ Exception -> 0x00ca }
            r2.a((float) r0)     // Catch:{ Exception -> 0x00ca }
            java.lang.String r0 = "bnpgawTfl`xXb~]yvzg"
            java.lang.String r0 = com.bytedance.sdk.component.d.c.f.f1667305730962dc(r0)     // Catch:{ Exception -> 0x00ca }
            double r8 = r5.optDouble(r0)     // Catch:{ Exception -> 0x00ca }
            float r0 = (float) r8     // Catch:{ Exception -> 0x00ca }
            r2.b((float) r0)     // Catch:{ Exception -> 0x00ca }
            java.lang.String r0 = "bnpgawTfl`xNbz{|^vra"
            java.lang.String r0 = com.bytedance.sdk.component.d.c.f.f1667305730962dc(r0)     // Catch:{ Exception -> 0x00ca }
            double r8 = r5.optDouble(r0)     // Catch:{ Exception -> 0x00ca }
            float r0 = (float) r8     // Catch:{ Exception -> 0x00ca }
            r2.c((float) r0)     // Catch:{ Exception -> 0x00ca }
            java.lang.String r0 = "bnpgawTfl`xNbz{|@zs}b"
            java.lang.String r0 = com.bytedance.sdk.component.d.c.f.f1667305730962dc(r0)     // Catch:{ Exception -> 0x00ca }
            double r8 = r5.optDouble(r0)     // Catch:{ Exception -> 0x00ca }
            float r0 = (float) r8     // Catch:{ Exception -> 0x00ca }
            r2.d((float) r0)     // Catch:{ Exception -> 0x00ca }
            goto L_0x00bd
        L_0x00bb:
            r17 = r8
        L_0x00bd:
            r2.c((double) r12)     // Catch:{ Exception -> 0x00ca }
            r2.d((double) r14)     // Catch:{ Exception -> 0x00ca }
            r2.e(r3)     // Catch:{ Exception -> 0x00ca }
            r2.f(r6)     // Catch:{ Exception -> 0x00ca }
            goto L_0x00d4
        L_0x00ca:
            r1 = 101(0x65, float:1.42E-43)
            r0 = r21
            goto L_0x013d
        L_0x00d0:
            r16 = r4
            r17 = r8
        L_0x00d4:
            java.lang.String r0 = "mdqpebc"
            java.lang.String r0 = com.bytedance.sdk.component.d.c.f.f1667305730962dc(r0)     // Catch:{ Exception -> 0x0139 }
            r3 = 101(0x65, float:1.42E-43)
            java.lang.String r4 = com.bytedance.sdk.openadsdk.core.g.a(r3)     // Catch:{ Exception -> 0x0135 }
            java.lang.String r0 = r1.optString(r0, r4)     // Catch:{ Exception -> 0x0135 }
            java.lang.String r4 = "cnff"
            java.lang.String r4 = com.bytedance.sdk.component.d.c.f.f1667305730962dc(r4)     // Catch:{ Exception -> 0x0135 }
            int r1 = r1.optInt(r4, r3)     // Catch:{ Exception -> 0x0135 }
            r3 = r16
            r2.a((boolean) r3)     // Catch:{ Exception -> 0x0139 }
            r2.a((double) r10)     // Catch:{ Exception -> 0x0139 }
            r8 = r17
            r2.b((double) r8)     // Catch:{ Exception -> 0x0139 }
            r2.a((java.lang.String) r0)     // Catch:{ Exception -> 0x0139 }
            r2.b((int) r1)     // Catch:{ Exception -> 0x0139 }
            r0 = r21
            com.bytedance.sdk.component.adexpress.b.j r1 = r0.r     // Catch:{ Exception -> 0x013b }
            r1.a(r2)     // Catch:{ Exception -> 0x013b }
            r1 = 27
            r2 = 33
        L_0x010c:
            r3 = 56
        L_0x010e:
            r4 = 17
            switch(r3) {
                case 54: goto L_0x011c;
                case 55: goto L_0x0114;
                case 56: goto L_0x0122;
                default: goto L_0x0113;
            }
        L_0x0113:
            goto L_0x010c
        L_0x0114:
            switch(r2) {
                case 40: goto L_0x0114;
                case 41: goto L_0x0118;
                case 42: goto L_0x012e;
                default: goto L_0x0117;
            }
        L_0x0117:
            goto L_0x0122
        L_0x0118:
            switch(r1) {
                case 70: goto L_0x010c;
                case 71: goto L_0x010c;
                case 72: goto L_0x012e;
                default: goto L_0x011b;
            }
        L_0x011b:
            goto L_0x012e
        L_0x011c:
            if (r2 == r4) goto L_0x0129
        L_0x011e:
            switch(r1) {
                case 89: goto L_0x010c;
                case 90: goto L_0x0122;
                case 91: goto L_0x014c;
                default: goto L_0x0121;
            }
        L_0x0121:
            goto L_0x0126
        L_0x0122:
            r1 = -84
            r2 = r4
            goto L_0x011c
        L_0x0126:
            r1 = 90
            goto L_0x011e
        L_0x0129:
            r3 = 11
            if (r1 <= r3) goto L_0x012e
            goto L_0x010c
        L_0x012e:
            r3 = 54
            r2 = 81
            r1 = 91
            goto L_0x010e
        L_0x0135:
            r0 = r21
            r1 = r3
            goto L_0x013d
        L_0x0139:
            r0 = r21
        L_0x013b:
            r1 = 101(0x65, float:1.42E-43)
        L_0x013d:
            r2.b((int) r1)
            java.lang.String r1 = com.bytedance.sdk.openadsdk.core.g.a(r1)
            r2.a((java.lang.String) r1)
            com.bytedance.sdk.component.adexpress.b.j r1 = r0.r
            r1.a(r2)
        L_0x014c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.u.k(org.json.JSONObject):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0047, code lost:
        switch(r2) {
            case 39: goto L_0x004b;
            case 40: goto L_0x0034;
            case 41: goto L_0x0053;
            default: goto L_0x004a;
        };
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0050, code lost:
        r2 = '\'';
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:?, code lost:
        return false;
     */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x003b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean l(org.json.JSONObject r5) {
        /*
            r4 = this;
            java.lang.String r0 = "bnpgawTfl`xXb~Cuwf"
            java.lang.String r0 = com.bytedance.sdk.component.d.c.a.a1667305730971dc(r0)
            boolean r0 = r5.has(r0)
            r1 = 0
            r2 = 56
            r3 = 60
            if (r0 == 0) goto L_0x0034
            java.lang.String r0 = "bnpgawTfl`xNbz{|^vra"
            java.lang.String r0 = com.bytedance.sdk.component.d.c.a.a1667305730971dc(r0)
            boolean r0 = r5.has(r0)
            if (r0 == 0) goto L_0x0034
            java.lang.String r0 = "bnpgawTfl`xXb~]yvzg"
            java.lang.String r0 = com.bytedance.sdk.component.d.c.a.a1667305730971dc(r0)
            boolean r0 = r5.has(r0)
            if (r0 == 0) goto L_0x0034
            java.lang.String r0 = "bnpgawTfl`xNbz{|@zs}b"
            java.lang.String r0 = com.bytedance.sdk.component.d.c.a.a1667305730971dc(r0)
            boolean r5 = r5.has(r0)
            goto L_0x0043
        L_0x0034:
            r5 = r1
        L_0x0035:
            r0 = 41
        L_0x0037:
            switch(r0) {
                case 40: goto L_0x003b;
                case 41: goto L_0x0053;
                case 42: goto L_0x0035;
                default: goto L_0x003a;
            }
        L_0x003a:
            goto L_0x0035
        L_0x003b:
            switch(r3) {
                case 81: goto L_0x003f;
                case 82: goto L_0x0047;
                case 83: goto L_0x0054;
                default: goto L_0x003e;
            }
        L_0x003e:
            goto L_0x0053
        L_0x003f:
            switch(r2) {
                case 29: goto L_0x0054;
                case 30: goto L_0x0054;
                case 31: goto L_0x0043;
                default: goto L_0x0042;
            }
        L_0x0042:
            goto L_0x0047
        L_0x0043:
            if (r5 == 0) goto L_0x0034
            r5 = 1
            goto L_0x004b
        L_0x0047:
            switch(r2) {
                case 39: goto L_0x004b;
                case 40: goto L_0x0034;
                case 41: goto L_0x0053;
                default: goto L_0x004a;
            }
        L_0x004a:
            goto L_0x0050
        L_0x004b:
            r0 = 40
            r3 = 83
            goto L_0x0037
        L_0x0050:
            r2 = 39
            goto L_0x0047
        L_0x0053:
            r5 = r1
        L_0x0054:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.u.l(org.json.JSONObject):boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0060, code lost:
        switch(r0) {
            case 39: goto L_0x0064;
            case 40: goto L_0x0073;
            case 41: goto L_0x008a;
            default: goto L_0x0063;
        };
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x00a1, code lost:
        r0 = '\'';
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m(org.json.JSONObject r5) {
        /*
            r4 = this;
            if (r5 != 0) goto L_0x0003
            return
        L_0x0003:
            java.lang.String r0 = "TUCm`winlFhainz"
            java.lang.String r0 = com.bytedance.sdk.component.d.c.a.a1667305730971dc(r0)
            java.lang.String r1 = "TUCm`winlFhainz/xp|wxpdSaw{vu~JmABI"
            java.lang.String r1 = com.bytedance.sdk.component.d.c.a.a1667305730971dc(r1)
            com.bytedance.sdk.component.utils.l.b((java.lang.String) r0, (java.lang.String) r1)
            java.lang.String r0 = "tsc`oAgsi"
            java.lang.String r0 = com.bytedance.sdk.component.d.c.a.a1667305730971dc(r0)     // Catch:{ Exception -> 0x00a7 }
            java.lang.String r5 = r5.optString(r0)     // Catch:{ Exception -> 0x00a7 }
            android.net.Uri r5 = android.net.Uri.parse(r5)     // Catch:{ Exception -> 0x00a7 }
            java.lang.String r0 = r5.getScheme()     // Catch:{ Exception -> 0x00a7 }
            java.lang.String r0 = r0.toLowerCase()     // Catch:{ Exception -> 0x00a7 }
            java.lang.String r1 = "bxvf`dhdm"
            java.lang.String r1 = com.bytedance.sdk.component.d.c.a.a1667305730971dc(r1)     // Catch:{ Exception -> 0x00a7 }
            boolean r0 = r1.equals(r0)     // Catch:{ Exception -> 0x00a7 }
            if (r0 == 0) goto L_0x00a7
            com.bytedance.sdk.openadsdk.l.j.a((android.net.Uri) r5, (com.bytedance.sdk.openadsdk.core.u) r4)     // Catch:{ Exception -> 0x00a7 }
        L_0x0037:
            r5 = 40
        L_0x0039:
            r0 = 56
            r1 = 83
            switch(r5) {
                case 40: goto L_0x0041;
                case 41: goto L_0x00a7;
                case 42: goto L_0x00a4;
                default: goto L_0x0040;
            }     // Catch:{ Exception -> 0x00a7 }
        L_0x0040:
            goto L_0x00a4
        L_0x0041:
            switch(r1) {
                case 81: goto L_0x0045;
                case 82: goto L_0x0060;
                case 83: goto L_0x00a4;
                default: goto L_0x0044;
            }     // Catch:{ Exception -> 0x00a7 }
        L_0x0044:
            goto L_0x00a7
        L_0x0045:
            switch(r0) {
                case 29: goto L_0x0049;
                case 30: goto L_0x0049;
                case 31: goto L_0x0055;
                default: goto L_0x0048;
            }     // Catch:{ Exception -> 0x00a7 }
        L_0x0048:
            goto L_0x0060
        L_0x0049:
            r5 = 13
            int r5 = r5 * r5
            r0 = 19
            int r0 = r0 * r0
            int r0 = r0 * 34
            int r5 = r5 - r0
            r0 = -1
            if (r5 != r0) goto L_0x00a4
        L_0x0055:
            r5 = 10
            int r5 = r5 + 1
            int r5 = r5 * 10
            int r5 = r5 % 2
            if (r5 == 0) goto L_0x00a7
            goto L_0x0064
        L_0x0060:
            switch(r0) {
                case 39: goto L_0x0064;
                case 40: goto L_0x0073;
                case 41: goto L_0x008a;
                default: goto L_0x0063;
            }
        L_0x0063:
            goto L_0x00a1
        L_0x0064:
            r5 = 12
            r0 = 14
            int r1 = r5 * r5
            int r2 = r0 * r0
            int r1 = r1 + r2
            int r5 = r5 * r0
            int r5 = r5 * 2
            int r1 = r1 - r5
            if (r1 >= 0) goto L_0x0037
        L_0x0073:
            r5 = 54
            r0 = 27
            r1 = 24
            int r2 = r5 * r5
            int r3 = r0 * r0
            int r2 = r2 + r3
            int r3 = r1 * r1
            int r2 = r2 + r3
            r3 = 54
            int r3 = r3 * r0
            int r0 = r0 * r1
            int r3 = r3 + r0
            int r5 = r5 * r1
            int r3 = r3 + r5
            if (r2 >= r3) goto L_0x0037
        L_0x008a:
            r5 = 94
            r0 = 17
            r1 = 7
            int r2 = r5 * r5
            int r2 = r2 * r5
            int r3 = r0 * r0
            int r3 = r3 * r0
            int r2 = r2 + r3
            int r3 = r1 * r1
            int r3 = r3 * r1
            int r2 = r2 + r3
            int r5 = r5 * r0
            int r5 = r5 * r1
            int r5 = r5 * 3
            if (r2 >= r5) goto L_0x0037
            goto L_0x00a7
        L_0x00a1:
            r0 = 39
            goto L_0x0060
        L_0x00a4:
            r5 = 41
            goto L_0x0039
        L_0x00a7:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.u.m(org.json.JSONObject):void");
    }

    private WebView n() {
        WeakReference<SSWebView> weakReference = this.d;
        if (weakReference == null || weakReference.get() == null) {
            return null;
        }
        return ((SSWebView) this.d.get()).getWebView();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x004f, code lost:
        switch(r5) {
            case 29: goto L_0x0064;
            case 30: goto L_0x005b;
            case 31: goto L_0x0055;
            default: goto L_0x0052;
        };
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0052, code lost:
        r5 = 31;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0055, code lost:
        r8 = r3;
        r3 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:?, code lost:
        return;
     */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x004b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void n(org.json.JSONObject r8) {
        /*
            r7 = this;
            if (r8 == 0) goto L_0x0064
            com.bytedance.sdk.openadsdk.f.d r0 = r7.u
            if (r0 != 0) goto L_0x0008
            goto L_0x0064
        L_0x0008:
            r0 = 0
            r1 = 0
            java.lang.String r2 = "tdobmUthl|iEi}"
            java.lang.String r2 = com.bytedance.sdk.component.f.b.a.a1667305730938dc(r2)     // Catch:{ Exception -> 0x005e }
            org.json.JSONArray r8 = r8.optJSONArray(r2)     // Catch:{ Exception -> 0x005e }
            r2 = 1
            r3 = 72
            if (r8 == 0) goto L_0x0029
            int r4 = r8.length()     // Catch:{ Exception -> 0x005e }
            if (r4 <= 0) goto L_0x0029
            com.bytedance.sdk.openadsdk.f.d r4 = r7.u     // Catch:{ Exception -> 0x005e }
            r4.a(r2, r8)     // Catch:{ Exception -> 0x005e }
            r8 = 95
            r5 = r3
            r3 = r7
            goto L_0x005b
        L_0x0029:
            com.bytedance.sdk.openadsdk.f.d r8 = r7.u     // Catch:{ Exception -> 0x005e }
            r8.a(r1, r0)     // Catch:{ Exception -> 0x005e }
            r8 = r7
        L_0x002f:
            r4 = 40
            switch(r4) {
                case 39: goto L_0x003f;
                case 40: goto L_0x0064;
                case 41: goto L_0x0035;
                default: goto L_0x0034;
            }
        L_0x0034:
            goto L_0x002f
        L_0x0035:
            r4 = 37
            int r4 = r4 + r2
            int r4 = r4 * 37
            int r4 = r4 % 2
            if (r4 == 0) goto L_0x003f
            goto L_0x002f
        L_0x003f:
            r4 = 39
            r5 = 52
            r6 = r3
            r3 = r8
            r8 = r5
            r5 = r6
        L_0x0047:
            switch(r4) {
                case 38: goto L_0x0055;
                case 39: goto L_0x004b;
                case 40: goto L_0x005b;
                default: goto L_0x004a;
            }
        L_0x004a:
            goto L_0x005b
        L_0x004b:
            switch(r8) {
                case 52: goto L_0x0058;
                case 53: goto L_0x0055;
                case 54: goto L_0x004f;
                default: goto L_0x004e;
            }
        L_0x004e:
            goto L_0x005b
        L_0x004f:
            switch(r5) {
                case 29: goto L_0x0064;
                case 30: goto L_0x005b;
                case 31: goto L_0x0055;
                default: goto L_0x0052;
            }
        L_0x0052:
            r5 = 31
            goto L_0x004f
        L_0x0055:
            r8 = r3
            r3 = r5
            goto L_0x003f
        L_0x0058:
            r8 = r3
            r3 = r5
            goto L_0x002f
        L_0x005b:
            r4 = 38
            goto L_0x0047
        L_0x005e:
            r8 = r7
        L_0x005f:
            com.bytedance.sdk.openadsdk.f.d r8 = r8.u
            r8.a(r1, r0)
        L_0x0064:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.u.n(org.json.JSONObject):void");
    }

    @JProtect
    private JSONObject o() {
        try {
            View view = (View) this.k.get();
            View view2 = (View) this.d.get();
            if (view != null) {
                if (view2 != null) {
                    int[] b2 = z.b(view);
                    int[] b3 = z.b(view2);
                    if (b2 != null) {
                        if (b3 != null) {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put(f.f1667305730962dc("x"), z.c(m.a(), (float) (b2[0] - b3[0])));
                            jSONObject.put(f.f1667305730962dc("y"), z.c(m.a(), (float) (b2[1] - b3[1])));
                            jSONObject.put(f.f1667305730962dc("w"), z.c(m.a(), (float) view.getWidth()));
                            jSONObject.put(f.f1667305730962dc("h"), z.c(m.a(), (float) view.getHeight()));
                            jSONObject.put(f.f1667305730962dc("irG{mvr"), true);
                            return jSONObject;
                        }
                    }
                    l.e(f.f1667305730962dc("TUCm`winlFhainz"), f.f1667305730962dc("sdv@hjubJ|~ccGav~2vfgye8iuhuiwpN\u0001MQ\u0004RCE~@O\\|B]FDX]]\u0014\\E\u0017VLVW"));
                    return null;
                }
            }
            l.e(f.f1667305730962dc("TUCm`winlFhainz"), f.f1667305730962dc("sdv@hjubJ|~ccGav~2vfgye8zvtox\\jTUMM\u0004LU\u0007F\\FG"));
            return null;
        } catch (Throwable th) {
            l.a(f.f1667305730962dc("TUCm`winlFhainz"), f.f1667305730962dc("sdv@hjubJ|~ccGav~2vfgye"), th);
            return null;
        }
    }

    private boolean o(JSONObject jSONObject) {
        try {
            jSONObject.put(com.bytedance.sdk.component.f.b.a.a1667305730938dc("csgbplpb{"), b(this.D));
            while (true) {
                char c2 = '_';
                char c3 = '_';
                while (true) {
                    switch (c2) {
                        case '^':
                            if (c3 != '\'') {
                                break;
                            } else {
                                continue;
                            }
                        case '_':
                            switch (c3) {
                                case '^':
                                case '`':
                                    continue;
                                case '_':
                                    break;
                            }
                        case '`':
                            break;
                    }
                    switch (c3) {
                        case '7':
                        case '8':
                        case '9':
                            break;
                    }
                    c2 = '^';
                    c3 = '}';
                }
            }
            return true;
        } catch (Exception unused) {
            return true;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0062, code lost:
        if ((((57 * 57) + (34 * 34)) + (12 * 12)) >= (((57 * 34) + (34 * 12)) + (57 * 12))) goto L_0x0000;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0064, code lost:
        r7 = '1';
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0067, code lost:
        switch(r8) {
            case 55: goto L_0x0075;
            case 56: goto L_0x0000;
            case 57: goto L_0x006b;
            default: goto L_0x006a;
        };
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0072, code lost:
        if (((18 * 18) - ((35 * 35) * 34)) != -1) goto L_0x001d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0075, code lost:
        switch(r7) {
            case 60: goto L_0x0079;
            case 61: goto L_0x008f;
            case 62: goto L_0x009a;
            default: goto L_0x0078;
        };
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x008d, code lost:
        if (((((26 * 26) * 26) + ((9 * 9) * 9)) + ((15 * 15) * 15)) >= (((26 * 9) * 15) * 3)) goto L_0x001d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0098, code lost:
        if (((((0 - 1) * 0) * ((0 * 2) - 1)) % 6) == 0) goto L_0x001d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x00a4, code lost:
        if (((((18 - 1) * 18) * ((18 * 2) - 1)) % 6) == 0) goto L_0x009a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x00a8, code lost:
        r8 = '7';
        r7 = '=';
     */
    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0017, code lost:
        r7 = ((10 + 1) * 10) % 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x001d, code lost:
        r8 = '4';
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0021, code lost:
        switch(96) {
            case 94: goto L_0x004d;
            case 95: goto L_0x0064;
            case 96: goto L_0x0025;
            default: goto L_0x0024;
        };
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.util.List<java.lang.String> p() {
        /*
            r13 = this;
        L_0x0000:
            r0 = 3
            r1 = 0
            r2 = -1
            r3 = 49
            r4 = 34
            r5 = 2
            r6 = 1
            switch(r3) {
                case 49: goto L_0x001d;
                case 50: goto L_0x000d;
                case 51: goto L_0x0017;
                default: goto L_0x000c;
            }
        L_0x000c:
            goto L_0x0000
        L_0x000d:
            r7 = 13
            int r7 = r7 * r7
            r8 = 19
            int r8 = r8 * r8
            int r8 = r8 * r4
            int r7 = r7 - r8
            if (r7 != r2) goto L_0x0025
        L_0x0017:
            r7 = 10
            int r7 = r7 + r6
            int r7 = r7 * 10
            int r7 = r7 % r5
        L_0x001d:
            r7 = 96
            r8 = 52
            switch(r7) {
                case 94: goto L_0x004d;
                case 95: goto L_0x0064;
                case 96: goto L_0x0025;
                default: goto L_0x0024;
            }
        L_0x0024:
            goto L_0x001d
        L_0x0025:
            r2 = 4
            java.lang.String[] r2 = new java.lang.String[r2]
            java.lang.String r3 = "aqrJjci"
            java.lang.String r3 = com.bytedance.sdk.component.d.c.a.a1667305730971dc(r3)
            r2[r1] = r3
            java.lang.String r1 = "aeKmbj"
            java.lang.String r1 = com.bytedance.sdk.component.d.c.a.a1667305730971dc(r1)
            r2[r6] = r1
            java.lang.String r1 = "gdvWahvki}oBbka"
            java.lang.String r1 = com.bytedance.sdk.component.d.c.a.a1667305730971dc(r1)
            r2[r5] = r1
            java.lang.String r1 = "gdvWaHgnImy"
            java.lang.String r1 = com.bytedance.sdk.component.d.c.a.a1667305730971dc(r1)
            r2[r0] = r1
            java.util.List r0 = java.util.Arrays.asList(r2)
            return r0
        L_0x004d:
            r7 = 57
            r9 = 12
            int r10 = r7 * r7
            int r11 = r4 * r4
            int r10 = r10 + r11
            int r11 = r9 * r9
            int r10 = r10 + r11
            r11 = 57
            int r11 = r11 * r4
            r12 = 34
            int r12 = r12 * r9
            int r11 = r11 + r12
            int r7 = r7 * r9
            int r11 = r11 + r7
            if (r10 >= r11) goto L_0x0000
        L_0x0064:
            r7 = r3
        L_0x0065:
            r9 = 18
            switch(r8) {
                case 55: goto L_0x0075;
                case 56: goto L_0x0000;
                case 57: goto L_0x006b;
                default: goto L_0x006a;
            }
        L_0x006a:
            goto L_0x00a8
        L_0x006b:
            int r7 = r9 * r9
            r8 = 35
            int r8 = r8 * r8
            int r8 = r8 * r4
            int r7 = r7 - r8
            if (r7 != r2) goto L_0x001d
            goto L_0x0079
        L_0x0075:
            switch(r7) {
                case 60: goto L_0x0079;
                case 61: goto L_0x008f;
                case 62: goto L_0x009a;
                default: goto L_0x0078;
            }
        L_0x0078:
            goto L_0x0000
        L_0x0079:
            r7 = 26
            r8 = 9
            r10 = 15
            int r11 = r7 * r7
            int r11 = r11 * r7
            int r12 = r8 * r8
            int r12 = r12 * r8
            int r11 = r11 + r12
            int r12 = r10 * r10
            int r12 = r12 * r10
            int r11 = r11 + r12
            int r7 = r7 * r8
            int r7 = r7 * r10
            int r7 = r7 * r0
            if (r11 >= r7) goto L_0x001d
        L_0x008f:
            int r7 = 0 - r6
            int r7 = r7 * r1
            r8 = 0
            int r8 = r8 * r5
            int r8 = r8 - r6
            int r7 = r7 * r8
            int r7 = r7 % 6
            if (r7 == 0) goto L_0x001d
        L_0x009a:
            int r7 = 18 - r6
            int r7 = r7 * r9
            r8 = 18
            int r8 = r8 * r5
            int r8 = r8 - r6
            int r7 = r7 * r8
            int r7 = r7 % 6
            if (r7 == 0) goto L_0x009a
            goto L_0x001d
        L_0x00a8:
            r8 = 55
            r7 = 61
            goto L_0x0065
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.u.p():java.util.List");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x006d, code lost:
        if (((13 * 13) - ((19 * 19) * 34)) != -1) goto L_0x00d8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0076, code lost:
        if ((((10 + 1) * 10) % 2) == 0) goto L_0x00d8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0081, code lost:
        if (((61 * 61) - ((12 * 12) * 34)) != -1) goto L_0x00ce;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0098, code lost:
        if ((((54 * 54) + (27 * 27)) + (24 * 24)) >= (((54 * 27) + (27 * 24)) + (54 * 24))) goto L_0x004f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x009b, code lost:
        r7 = 'S';
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x009d, code lost:
        switch(r7) {
            case 82: goto L_0x00a1;
            case 83: goto L_0x00b7;
            case 84: goto L_0x00ce;
            default: goto L_0x00a0;
        };
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x00b5, code lost:
        if (((((94 * 94) * 94) + ((17 * 17) * 17)) + ((7 * 7) * 7)) < (((94 * 17) * 7) * 3)) goto L_0x00b7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x00cc, code lost:
        if (((((98 * 98) * 98) + ((45 * 45) * 45)) + ((23 * 23) * 23)) >= (((98 * 45) * 23) * 3)) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x00ce, code lost:
        r7 = (71 * 71) - ((25 * 25) * 34);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void p(org.json.JSONObject r7) {
        /*
            r6 = this;
            if (r7 != 0) goto L_0x0004
            goto L_0x00d8
        L_0x0004:
            android.webkit.WebView r0 = r6.n()
            if (r0 == 0) goto L_0x00d8
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "j`tbwftnx}0_cxzfq~X@Vgs|4Dt|p{LDoFWVG@MoXDAyAZDXS\\\u001c"
            java.lang.String r2 = com.bytedance.sdk.component.f.c.a.a1667305730924dc(r2)
            r1.append(r2)
            r1.append(r7)
            java.lang.String r7 = ")"
            java.lang.String r7 = com.bytedance.sdk.component.f.c.a.a1667305730924dc(r7)
            r1.append(r7)
            java.lang.String r7 = r1.toString()
            com.bytedance.sdk.component.utils.k.a(r0, r7)
            boolean r0 = com.bytedance.sdk.component.utils.l.a()
            if (r0 == 0) goto L_0x00d8
            java.lang.String r0 = "TUCm`winlFhainz"
            java.lang.String r0 = com.bytedance.sdk.component.f.c.a.a1667305730924dc(r0)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "jr]nwb&"
            java.lang.String r2 = com.bytedance.sdk.component.f.c.a.a1667305730924dc(r2)
            r1.append(r2)
            r1.append(r7)
            java.lang.String r7 = r1.toString()
            com.bytedance.sdk.component.utils.l.a((java.lang.String) r0, (java.lang.String) r7)
        L_0x004f:
            r7 = 39
            r0 = -1
            r1 = 1
            switch(r7) {
                case 39: goto L_0x00d8;
                case 40: goto L_0x0057;
                case 41: goto L_0x0064;
                default: goto L_0x0056;
            }
        L_0x0056:
            goto L_0x004f
        L_0x0057:
            r2 = 87
            int r3 = 87 - r1
            int r3 = r3 * r2
            int r2 = r2 * 2
            int r2 = r2 - r1
            int r3 = r3 * r2
            int r3 = r3 % 6
            if (r3 == 0) goto L_0x009b
        L_0x0064:
            r2 = 13
            int r2 = r2 * r2
            r3 = 19
            int r3 = r3 * r3
            int r3 = r3 * 34
            int r2 = r2 - r3
            if (r2 != r0) goto L_0x00d8
            r2 = 10
            int r2 = r2 + r1
            int r2 = r2 * 10
            int r2 = r2 % 2
            if (r2 == 0) goto L_0x00d8
            r1 = 61
            int r1 = r1 * r1
            r2 = 12
            int r2 = r2 * r2
            int r2 = r2 * 34
            int r1 = r1 - r2
            if (r1 != r0) goto L_0x00ce
            r1 = 54
            r2 = 27
            r3 = 24
            int r4 = r1 * r1
            int r5 = r2 * r2
            int r4 = r4 + r5
            int r5 = r3 * r3
            int r4 = r4 + r5
            r5 = 54
            int r5 = r5 * r2
            int r2 = r2 * r3
            int r5 = r5 + r2
            int r1 = r1 * r3
            int r5 = r5 + r1
            if (r4 >= r5) goto L_0x004f
            goto L_0x00a1
        L_0x009b:
            r7 = 83
        L_0x009d:
            switch(r7) {
                case 82: goto L_0x00a1;
                case 83: goto L_0x00b7;
                case 84: goto L_0x00ce;
                default: goto L_0x00a0;
            }
        L_0x00a0:
            goto L_0x009b
        L_0x00a1:
            r1 = 94
            r2 = 17
            r3 = 7
            int r4 = r1 * r1
            int r4 = r4 * r1
            int r5 = r2 * r2
            int r5 = r5 * r2
            int r4 = r4 + r5
            int r5 = r3 * r3
            int r5 = r5 * r3
            int r4 = r4 + r5
            int r1 = r1 * r2
            int r1 = r1 * r3
            int r1 = r1 * 3
            if (r4 >= r1) goto L_0x009d
        L_0x00b7:
            r7 = 98
            r1 = 45
            r2 = 23
            int r3 = r7 * r7
            int r3 = r3 * r7
            int r4 = r1 * r1
            int r4 = r4 * r1
            int r3 = r3 + r4
            int r4 = r2 * r2
            int r4 = r4 * r2
            int r3 = r3 + r4
            int r7 = r7 * r1
            int r7 = r7 * r2
            int r7 = r7 * 3
            if (r3 >= r7) goto L_0x00d8
        L_0x00ce:
            r7 = 71
            int r7 = r7 * r7
            r1 = 25
            int r1 = r1 * r1
            int r1 = r1 * 34
            int r7 = r7 - r1
            goto L_0x009b
        L_0x00d8:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.u.p(org.json.JSONObject):void");
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0034, code lost:
        if (((((55 * 55) * 55) + r4) + r4) >= (((55 * 11) * 11) * 3)) goto L_0x0037;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0015, code lost:
        switch(83) {
            case 82: goto L_0x0037;
            case 83: goto L_0x0037;
            case 84: goto L_0x0019;
            default: goto L_0x0018;
        };
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0021, code lost:
        if ((((17 + 1) * 17) % 2) == 0) goto L_0x0024;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0024, code lost:
        r4 = (11 * 11) * 11;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private org.json.JSONObject q(org.json.JSONObject r6) {
        /*
            r5 = this;
            java.lang.String r0 = "ae]f|qtfWmkm"
        L_0x0002:
            r1 = 94
            switch(r1) {
                case 94: goto L_0x0013;
                case 95: goto L_0x0008;
                case 96: goto L_0x0024;
                default: goto L_0x0007;
            }
        L_0x0007:
            goto L_0x0002
        L_0x0008:
            r1 = 45
            int r1 = r1 + 1
            int r1 = r1 * 45
            int r1 = r1 % 2
            if (r1 == 0) goto L_0x0008
            goto L_0x0024
        L_0x0013:
            r1 = 83
            switch(r1) {
                case 82: goto L_0x0037;
                case 83: goto L_0x0037;
                case 84: goto L_0x0019;
                default: goto L_0x0018;
            }
        L_0x0018:
            goto L_0x0013
        L_0x0019:
            r1 = 17
            int r1 = r1 + 1
            int r1 = r1 * 17
            int r1 = r1 % 2
            if (r1 == 0) goto L_0x0024
            goto L_0x0013
        L_0x0024:
            r1 = 55
            int r2 = r1 * r1
            int r2 = r2 * r1
            r3 = 11
            int r4 = r3 * r3
            int r4 = r4 * r3
            int r2 = r2 + r4
            int r2 = r2 + r4
            int r1 = r1 * r3
            int r1 = r1 * r3
            int r1 = r1 * 3
            if (r2 >= r1) goto L_0x0037
            goto L_0x0002
        L_0x0037:
            java.util.Map<java.lang.String, java.lang.Object> r1 = r5.a
            if (r1 == 0) goto L_0x008f
            if (r6 != 0) goto L_0x0042
            org.json.JSONObject r6 = new org.json.JSONObject
            r6.<init>()
        L_0x0042:
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch:{ Exception -> 0x0087 }
            r1.<init>()     // Catch:{ Exception -> 0x0087 }
            java.lang.String r2 = com.bytedance.sdk.component.f.c.a.a1667305730924dc(r0)     // Catch:{ Exception -> 0x0087 }
            r3 = 0
            java.lang.String r2 = r6.optString(r2, r3)     // Catch:{ Exception -> 0x0087 }
            if (r2 == 0) goto L_0x0057
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch:{ Exception -> 0x0087 }
            r1.<init>(r2)     // Catch:{ Exception -> 0x0087 }
        L_0x0057:
            java.util.Map<java.lang.String, java.lang.Object> r2 = r5.a     // Catch:{ Exception -> 0x0087 }
            java.util.Set r2 = r2.entrySet()     // Catch:{ Exception -> 0x0087 }
            java.util.Iterator r2 = r2.iterator()     // Catch:{ Exception -> 0x0087 }
        L_0x0061:
            boolean r3 = r2.hasNext()     // Catch:{ Exception -> 0x0087 }
            if (r3 == 0) goto L_0x007b
            java.lang.Object r3 = r2.next()     // Catch:{ Exception -> 0x0087 }
            java.util.Map$Entry r3 = (java.util.Map.Entry) r3     // Catch:{ Exception -> 0x0087 }
            java.lang.Object r4 = r3.getKey()     // Catch:{ Exception -> 0x0087 }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ Exception -> 0x0087 }
            java.lang.Object r3 = r3.getValue()     // Catch:{ Exception -> 0x0087 }
            r1.put(r4, r3)     // Catch:{ Exception -> 0x0087 }
            goto L_0x0061
        L_0x007b:
            java.lang.String r0 = com.bytedance.sdk.component.f.c.a.a1667305730924dc(r0)     // Catch:{ Exception -> 0x0087 }
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x0087 }
            r6.put(r0, r1)     // Catch:{ Exception -> 0x0087 }
            goto L_0x008f
        L_0x0087:
            r0 = move-exception
            java.lang.String r0 = r0.toString()
            com.bytedance.sdk.component.utils.l.d(r0)
        L_0x008f:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.u.q(org.json.JSONObject):org.json.JSONObject");
    }

    private void q() {
        h hVar = this.B;
        if (hVar != null) {
            hVar.a();
        }
    }

    private void r() {
        h hVar = this.B;
        if (hVar != null) {
            hVar.b();
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x001c, code lost:
        switch(12) {
            case 55: goto L_0x0020;
            case 56: goto L_0x0035;
            case 57: goto L_0x003f;
            default: goto L_0x001f;
        };
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0033, code lost:
        if (((((26 * 26) * 26) + ((9 * 9) * 9)) + ((15 * 15) * 15)) >= (((26 * 9) * 15) * 3)) goto L_0x004c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x003d, code lost:
        if ((((90 + 1) * 90) % 2) == 0) goto L_0x0007;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0046, code lost:
        if ((((15 + 1) * 15) % 2) == 0) goto L_0x0020;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0048, code lost:
        continue;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0048, code lost:
        continue;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void s() {
        /*
            r5 = this;
            com.bytedance.sdk.openadsdk.core.nativeexpress.i r0 = r5.s
            if (r0 == 0) goto L_0x004c
            r0.a()
        L_0x0007:
            r0 = 92
        L_0x0009:
            r1 = 14
            r2 = 15
        L_0x000d:
            r3 = 12
            switch(r1) {
                case 13: goto L_0x0017;
                case 14: goto L_0x0048;
                case 15: goto L_0x0013;
                default: goto L_0x0012;
            }
        L_0x0012:
            goto L_0x0009
        L_0x0013:
            switch(r0) {
                case 94: goto L_0x0048;
                case 95: goto L_0x004c;
                case 96: goto L_0x0048;
                default: goto L_0x0016;
            }
        L_0x0016:
            goto L_0x001c
        L_0x0017:
            r1 = 72
            if (r0 < r1) goto L_0x001c
            goto L_0x0048
        L_0x001c:
            switch(r3) {
                case 55: goto L_0x0020;
                case 56: goto L_0x0035;
                case 57: goto L_0x003f;
                default: goto L_0x001f;
            }
        L_0x001f:
            goto L_0x0048
        L_0x0020:
            r0 = 26
            r1 = 9
            int r3 = r0 * r0
            int r3 = r3 * r0
            int r4 = r1 * r1
            int r4 = r4 * r1
            int r3 = r3 + r4
            int r4 = r2 * r2
            int r4 = r4 * r2
            int r3 = r3 + r4
            int r0 = r0 * r1
            int r0 = r0 * r2
            int r0 = r0 * 3
            if (r3 >= r0) goto L_0x004c
        L_0x0035:
            r0 = 90
            int r0 = r0 + 1
            int r0 = r0 * 90
            int r0 = r0 % 2
            if (r0 == 0) goto L_0x0007
        L_0x003f:
            r0 = 15
            int r0 = r0 + 1
            int r0 = r0 * r2
            int r0 = r0 % 2
            if (r0 == 0) goto L_0x0020
        L_0x0048:
            r0 = 95
            r1 = r2
            goto L_0x000d
        L_0x004c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.u.s():void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:8:0x002a A[LOOP_START] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void t() {
        /*
            r3 = this;
            java.lang.ref.WeakReference<android.content.Context> r0 = r3.h
            if (r0 == 0) goto L_0x0040
            java.lang.Object r0 = r0.get()
            if (r0 == 0) goto L_0x0040
            com.bytedance.sdk.openadsdk.core.settings.j r0 = com.bytedance.sdk.openadsdk.core.m.d()
            java.lang.String r0 = r0.B()
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L_0x001b
            return
        L_0x001b:
            java.lang.ref.WeakReference<android.content.Context> r0 = r3.h
            java.lang.Object r0 = r0.get()
            android.content.Context r0 = (android.content.Context) r0
            com.bytedance.sdk.openadsdk.core.model.n r1 = r3.q
            java.lang.String r2 = r3.J
            com.bytedance.sdk.openadsdk.activity.TTWebsiteActivity.a(r0, r1, r2)
        L_0x002a:
            r0 = 95
            switch(r0) {
                case 94: goto L_0x0039;
                case 95: goto L_0x0040;
                case 96: goto L_0x0030;
                default: goto L_0x002f;
            }
        L_0x002f:
            goto L_0x002a
        L_0x0030:
            r0 = 45
            int r0 = r0 + 1
            int r0 = r0 * 45
        L_0x0036:
            int r0 = r0 % 2
            goto L_0x0040
        L_0x0039:
            r0 = 17
            int r0 = r0 + 1
            int r0 = r0 * 17
            goto L_0x0036
        L_0x0040:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.u.t():void");
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x0051 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0051 A[SYNTHETIC] */
    @com.bytedance.JProtect
    private org.json.JSONObject u() {
        /*
            r12 = this;
            r0 = r12
        L_0x0001:
            r1 = 63
        L_0x0003:
            r2 = 65
            r3 = 74
            r4 = 7
            r5 = 1
            r6 = 0
            switch(r3) {
                case 74: goto L_0x005d;
                case 75: goto L_0x000e;
                case 76: goto L_0x002a;
                default: goto L_0x000d;
            }
        L_0x000d:
            goto L_0x0003
        L_0x000e:
            switch(r2) {
                case 87: goto L_0x0041;
                case 88: goto L_0x0012;
                case 89: goto L_0x0045;
                default: goto L_0x0011;
            }
        L_0x0011:
            goto L_0x002a
        L_0x0012:
            r2 = 79
            r3 = 35
            r7 = 15
            int r8 = r2 * r2
            int r8 = r8 * r2
            int r9 = r3 * r3
            int r9 = r9 * r3
            int r8 = r8 + r9
            int r9 = r7 * r7
            int r9 = r9 * r7
            int r8 = r8 + r9
            int r2 = r2 * r3
            int r2 = r2 * r7
            int r2 = r2 * 3
            if (r8 >= r2) goto L_0x0003
            goto L_0x0045
        L_0x002a:
            r2 = 87
            r3 = 27
            r7 = 17
            int r8 = r2 * r2
            int r8 = r8 * r2
            int r9 = r3 * r3
            int r9 = r9 * r3
            int r8 = r8 + r9
            int r9 = r7 * r7
            int r9 = r9 * r7
            int r8 = r8 + r9
            int r2 = r2 * r3
            int r2 = r2 * r7
            int r2 = r2 * 3
            if (r8 >= r2) goto L_0x005d
        L_0x0041:
            r2 = 5
            if (r1 != r2) goto L_0x0045
            goto L_0x0051
        L_0x0045:
            int r2 = r4 * r4
            int r3 = r6 * r6
            int r2 = r2 + r3
            r3 = 7
            int r3 = r3 * r6
            int r3 = r3 * 2
            int r2 = r2 - r3
            if (r2 >= 0) goto L_0x0041
        L_0x0051:
            r1 = 59
            int r2 = 59 - r5
            int r2 = r2 * r1
            int r1 = r1 * 2
            int r1 = r1 - r5
            int r2 = r2 * r1
            int r2 = r2 % 6
            goto L_0x0001
        L_0x005d:
            org.json.JSONObject r1 = new org.json.JSONObject
            r1.<init>()
            com.bytedance.sdk.openadsdk.core.settings.j r2 = com.bytedance.sdk.openadsdk.core.m.d()
            if (r2 == 0) goto L_0x0134
            com.bytedance.sdk.openadsdk.core.model.n r2 = r0.q     // Catch:{ Exception -> 0x0134 }
            if (r2 == 0) goto L_0x0073
            com.bytedance.sdk.openadsdk.core.model.n r2 = r0.q     // Catch:{ Exception -> 0x0134 }
            int r2 = r2.aW()     // Catch:{ Exception -> 0x0134 }
            goto L_0x0074
        L_0x0073:
            r2 = r6
        L_0x0074:
            com.bytedance.sdk.openadsdk.core.model.n r3 = r0.q     // Catch:{ Exception -> 0x0134 }
            if (r3 == 0) goto L_0x007f
            com.bytedance.sdk.openadsdk.core.model.n r3 = r0.q     // Catch:{ Exception -> 0x0134 }
            int r3 = r3.aR()     // Catch:{ Exception -> 0x0134 }
            goto L_0x0080
        L_0x007f:
            r3 = r6
        L_0x0080:
            com.bytedance.sdk.openadsdk.core.settings.j r7 = com.bytedance.sdk.openadsdk.core.m.d()     // Catch:{ Exception -> 0x0134 }
            java.lang.String r8 = java.lang.String.valueOf(r2)     // Catch:{ Exception -> 0x0134 }
            int r7 = r7.h(r8)     // Catch:{ Exception -> 0x0134 }
            com.bytedance.sdk.openadsdk.core.settings.j r8 = com.bytedance.sdk.openadsdk.core.m.d()     // Catch:{ Exception -> 0x0134 }
            java.lang.String r9 = java.lang.String.valueOf(r2)     // Catch:{ Exception -> 0x0134 }
            int r8 = r8.o(r9)     // Catch:{ Exception -> 0x0134 }
            com.bytedance.sdk.openadsdk.core.settings.j r9 = com.bytedance.sdk.openadsdk.core.m.d()     // Catch:{ Exception -> 0x0134 }
            java.lang.String r10 = java.lang.String.valueOf(r2)     // Catch:{ Exception -> 0x0134 }
            boolean r9 = r9.d(r10)     // Catch:{ Exception -> 0x0134 }
            com.bytedance.sdk.openadsdk.core.model.n r10 = r0.q     // Catch:{ Exception -> 0x0134 }
            boolean r10 = com.bytedance.sdk.openadsdk.core.model.n.c((com.bytedance.sdk.openadsdk.core.model.n) r10)     // Catch:{ Exception -> 0x0134 }
            if (r10 != 0) goto L_0x00bc
            com.bytedance.sdk.openadsdk.core.settings.j r10 = com.bytedance.sdk.openadsdk.core.m.d()     // Catch:{ Exception -> 0x0134 }
            java.lang.String r11 = java.lang.String.valueOf(r2)     // Catch:{ Exception -> 0x0134 }
            int r10 = r10.k(r11)     // Catch:{ Exception -> 0x0134 }
            if (r10 != r5) goto L_0x00bc
            r10 = r5
            goto L_0x00bd
        L_0x00bc:
            r10 = r6
        L_0x00bd:
            if (r3 == r4) goto L_0x00d1
            r4 = 8
            if (r3 != r4) goto L_0x00c4
            goto L_0x00d1
        L_0x00c4:
            com.bytedance.sdk.openadsdk.core.settings.j r3 = com.bytedance.sdk.openadsdk.core.m.d()     // Catch:{ Exception -> 0x0134 }
            java.lang.String r2 = java.lang.String.valueOf(r2)     // Catch:{ Exception -> 0x0134 }
            boolean r2 = r3.b((java.lang.String) r2)     // Catch:{ Exception -> 0x0134 }
            goto L_0x00dd
        L_0x00d1:
            com.bytedance.sdk.openadsdk.core.settings.j r3 = com.bytedance.sdk.openadsdk.core.m.d()     // Catch:{ Exception -> 0x0134 }
            java.lang.String r2 = java.lang.String.valueOf(r2)     // Catch:{ Exception -> 0x0134 }
            boolean r2 = r3.n(r2)     // Catch:{ Exception -> 0x0134 }
        L_0x00dd:
            java.lang.String r3 = "vnk`aZehf}xd`"
            java.lang.String r3 = com.bytedance.sdk.component.adexpress.widget.DynamicUnlockView.DynamicUnlockView1667305730929dc(r3)     // Catch:{ Exception -> 0x0134 }
            r1.put(r3, r2)     // Catch:{ Exception -> 0x0134 }
            java.lang.String r2 = "rw]polvX|`gn"
            java.lang.String r2 = com.bytedance.sdk.component.adexpress.widget.DynamicUnlockView.DynamicUnlockView1667305730929dc(r2)     // Catch:{ Exception -> 0x0134 }
            r1.put(r2, r7)     // Catch:{ Exception -> 0x0134 }
            java.lang.String r2 = "fw]polvX{ae|"
            java.lang.String r2 = com.bytedance.sdk.component.adexpress.widget.DynamicUnlockView.DynamicUnlockView1667305730929dc(r2)     // Catch:{ Exception -> 0x0134 }
            r1.put(r2, r9)     // Catch:{ Exception -> 0x0134 }
            java.lang.String r2 = "iw]polvX|`gn"
            java.lang.String r2 = com.bytedance.sdk.component.adexpress.widget.DynamicUnlockView.DynamicUnlockView1667305730929dc(r2)     // Catch:{ Exception -> 0x0134 }
            r1.put(r2, r8)     // Catch:{ Exception -> 0x0134 }
            java.lang.String r2 = "simt[aotd`an"
            java.lang.String r2 = com.bytedance.sdk.component.adexpress.widget.DynamicUnlockView.DynamicUnlockView1667305730929dc(r2)     // Catch:{ Exception -> 0x0134 }
            com.bytedance.sdk.openadsdk.core.model.n r3 = r0.q     // Catch:{ Exception -> 0x0134 }
            if (r3 == 0) goto L_0x0114
            com.bytedance.sdk.openadsdk.core.model.n r3 = r0.q     // Catch:{ Exception -> 0x0134 }
            boolean r3 = r3.ap()     // Catch:{ Exception -> 0x0134 }
            if (r3 == 0) goto L_0x0114
            goto L_0x0115
        L_0x0114:
            r5 = r6
        L_0x0115:
            r1.put(r2, r5)     // Catch:{ Exception -> 0x0134 }
            java.lang.String r2 = "vhffkZgciy~jxdaa"
            java.lang.String r2 = com.bytedance.sdk.component.adexpress.widget.DynamicUnlockView.DynamicUnlockView1667305730929dc(r2)     // Catch:{ Exception -> 0x0134 }
            com.bytedance.sdk.openadsdk.core.model.n r3 = r0.q     // Catch:{ Exception -> 0x0134 }
            if (r3 == 0) goto L_0x0128
            com.bytedance.sdk.openadsdk.core.model.n r0 = r0.q     // Catch:{ Exception -> 0x0134 }
            int r6 = r0.t()     // Catch:{ Exception -> 0x0134 }
        L_0x0128:
            r1.put(r2, r6)     // Catch:{ Exception -> 0x0134 }
            java.lang.String r0 = "sjks[fnffnoTxbQl|~av"
            java.lang.String r0 = com.bytedance.sdk.component.adexpress.widget.DynamicUnlockView.DynamicUnlockView1667305730929dc(r0)     // Catch:{ Exception -> 0x0134 }
            r1.put(r0, r10)     // Catch:{ Exception -> 0x0134 }
        L_0x0134:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.u.u():org.json.JSONObject");
    }

    /* JADX WARNING: CFG modification limit reached, blocks count: 141 */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0057, code lost:
        if (((((13 * 13) * 13) + ((9 * 9) * 9)) + ((8 * 8) * 8)) < (((13 * 9) * 8) * 3)) goto L_0x0074;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0060, code lost:
        if ((((45 + 1) * 45) % 2) != 0) goto L_0x0062;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0070, code lost:
        switch(96) {
            case 94: goto L_0x0074;
            case 95: goto L_0x0080;
            case 96: goto L_0x008b;
            default: goto L_0x0073;
        };
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x007e, code lost:
        if ((((44 * 44) + (3 * 3)) - ((44 * 3) * 2)) >= 0) goto L_0x0074;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0089, code lost:
        if (((5 * 5) - ((28 * 28) * 34)) != -1) goto L_0x0094;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x008b, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0092, code lost:
        if ((((17 + 1) * 17) % 2) == 0) goto L_0x0068;
     */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x003f A[LOOP_START] */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x005a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean v() {
        /*
            r9 = this;
            com.bytedance.sdk.openadsdk.core.model.n r0 = r9.q
            r1 = 3
            r2 = 8
            r3 = 0
            r4 = 1
            r5 = 2
            if (r0 == 0) goto L_0x003f
            org.json.JSONObject r0 = r0.ak()
            if (r0 == 0) goto L_0x0062
            com.bytedance.sdk.openadsdk.core.model.n r0 = r9.q
            boolean r0 = com.bytedance.sdk.openadsdk.core.model.p.a((com.bytedance.sdk.openadsdk.core.model.n) r0)
            if (r0 != 0) goto L_0x0062
            boolean r0 = r9.F
            if (r0 == 0) goto L_0x001d
            goto L_0x0062
        L_0x001d:
            com.bytedance.sdk.openadsdk.core.model.n r0 = r9.q
            org.json.JSONObject r0 = r0.ak()
            java.lang.String r6 = "p`pfjqYsqyo"
            java.lang.String r6 = com.bytedance.sdk.component.d.c.c.b.c$b1667305730972dc(r6)
            int r0 = r0.optInt(r6)
            if (r0 == r5) goto L_0x0031
            goto L_0x00a3
        L_0x0031:
            com.bytedance.sdk.openadsdk.core.model.n r0 = r9.q
            int r0 = r0.aR()
            if (r0 == r2) goto L_0x003c
            r6 = 7
            if (r0 != r6) goto L_0x0068
        L_0x003c:
            r9.F = r4
            return r4
        L_0x003f:
            r0 = 83
            switch(r0) {
                case 82: goto L_0x005a;
                case 83: goto L_0x0062;
                case 84: goto L_0x0045;
                default: goto L_0x0044;
            }
        L_0x0044:
            goto L_0x003f
        L_0x0045:
            r0 = 13
            r6 = 9
            int r7 = r0 * r0
            int r7 = r7 * r0
            int r8 = r6 * r6
            int r8 = r8 * r6
            int r7 = r7 + r8
            int r8 = r2 * r2
            int r8 = r8 * r2
            int r7 = r7 + r8
            int r0 = r0 * r6
            int r0 = r0 * r2
            int r0 = r0 * r1
            if (r7 >= r0) goto L_0x0062
            goto L_0x0074
        L_0x005a:
            r0 = 45
            int r0 = r0 + r4
            int r0 = r0 * 45
            int r0 = r0 % r5
            if (r0 == 0) goto L_0x00a3
        L_0x0062:
            r0 = 39
            switch(r0) {
                case 39: goto L_0x00a3;
                case 40: goto L_0x0068;
                case 41: goto L_0x003f;
                default: goto L_0x0067;
            }
        L_0x0067:
            goto L_0x0062
        L_0x0068:
            r0 = 96
            r6 = 57
            switch(r6) {
                case 57: goto L_0x0070;
                case 58: goto L_0x008c;
                case 59: goto L_0x0094;
                default: goto L_0x006f;
            }
        L_0x006f:
            goto L_0x0068
        L_0x0070:
            switch(r0) {
                case 94: goto L_0x0074;
                case 95: goto L_0x0080;
                case 96: goto L_0x008b;
                default: goto L_0x0073;
            }
        L_0x0073:
            goto L_0x008c
        L_0x0074:
            r0 = 44
            int r6 = r0 * r0
            int r7 = r1 * r1
            int r6 = r6 + r7
            int r0 = r0 * r1
            int r0 = r0 * r5
            int r6 = r6 - r0
            if (r6 >= 0) goto L_0x0074
        L_0x0080:
            r0 = 5
            int r0 = r0 * r0
            r6 = 28
            int r6 = r6 * r6
            int r6 = r6 * 34
            int r0 = r0 - r6
            r6 = -1
            if (r0 != r6) goto L_0x0094
        L_0x008b:
            return r3
        L_0x008c:
            r0 = 17
            int r0 = r0 + r4
            int r0 = r0 * 17
            int r0 = r0 % r5
            if (r0 == 0) goto L_0x0068
        L_0x0094:
            r0 = 12
            r6 = 37
            int r7 = r0 * r0
            int r8 = r6 * r6
            int r7 = r7 + r8
            int r0 = r0 * r6
            int r0 = r0 * r5
            int r7 = r7 - r0
            if (r7 >= 0) goto L_0x00a3
            goto L_0x005a
        L_0x00a3:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.u.v():boolean");
    }

    /* JADX WARNING: Removed duplicated region for block: B:5:0x0015  */
    /* JADX WARNING: Removed duplicated region for block: B:7:0x001a A[FALL_THROUGH] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x001e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void w() {
        /*
            r3 = this;
            com.bytedance.sdk.openadsdk.f.c r0 = r3.i
            r1 = 95
            if (r0 != 0) goto L_0x000f
            com.bytedance.sdk.openadsdk.core.model.n r0 = r3.q
            com.bytedance.sdk.openadsdk.f.a r0 = com.bytedance.sdk.openadsdk.f.a.a((com.bytedance.sdk.openadsdk.f.b) r3, (com.bytedance.sdk.openadsdk.core.model.n) r0)
            r3.i = r0
            goto L_0x0021
        L_0x000f:
            r0 = r1
            r2 = r0
        L_0x0011:
            switch(r0) {
                case 94: goto L_0x001e;
                case 95: goto L_0x0015;
                case 96: goto L_0x001a;
                default: goto L_0x0014;
            }
        L_0x0014:
            goto L_0x0021
        L_0x0015:
            switch(r2) {
                case 94: goto L_0x000f;
                case 95: goto L_0x0019;
                case 96: goto L_0x000f;
                default: goto L_0x0018;
            }
        L_0x0018:
            goto L_0x001a
        L_0x0019:
            return
        L_0x001a:
            switch(r2) {
                case 55: goto L_0x000f;
                case 56: goto L_0x0021;
                case 57: goto L_0x000f;
                default: goto L_0x001d;
            }
        L_0x001d:
            goto L_0x000f
        L_0x001e:
            r0 = 39
            goto L_0x000f
        L_0x0021:
            r0 = 94
            r2 = 125(0x7d, float:1.75E-43)
            goto L_0x0011
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.u.w():void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP_START, MTH_ENTER_BLOCK] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.bytedance.sdk.component.a.r a() {
        /*
            r5 = this;
        L_0x0000:
            r0 = 73
            switch(r0) {
                case 72: goto L_0x0013;
                case 73: goto L_0x0028;
                case 74: goto L_0x0006;
                default: goto L_0x0005;
            }
        L_0x0005:
            goto L_0x0000
        L_0x0006:
            r0 = 82
            r1 = 1
            int r2 = 82 - r1
            int r2 = r2 * r0
            int r0 = r0 * 2
            int r0 = r0 - r1
            int r2 = r2 * r0
            int r2 = r2 % 6
            goto L_0x0028
        L_0x0013:
            r0 = 29
            r1 = 45
            r2 = 20
            int r3 = r0 * r0
            int r4 = r1 * r1
            int r3 = r3 + r4
            int r4 = r2 * r2
            int r3 = r3 + r4
            r4 = 29
            int r4 = r4 * r1
            int r1 = r1 * r2
            int r4 = r4 + r1
            int r0 = r0 * r2
            int r4 = r4 + r0
        L_0x0028:
            com.bytedance.sdk.component.a.r r0 = r5.I
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.u.a():com.bytedance.sdk.component.a.r");
    }

    /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP_START, MTH_ENTER_BLOCK] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.bytedance.sdk.openadsdk.core.u a(int r6) {
        /*
            r5 = this;
        L_0x0000:
            r0 = 73
            switch(r0) {
                case 72: goto L_0x0013;
                case 73: goto L_0x0028;
                case 74: goto L_0x0006;
                default: goto L_0x0005;
            }
        L_0x0005:
            goto L_0x0000
        L_0x0006:
            r0 = 82
            r1 = 1
            int r2 = 82 - r1
            int r2 = r2 * r0
            int r0 = r0 * 2
            int r0 = r0 - r1
            int r2 = r2 * r0
            int r2 = r2 % 6
            goto L_0x0028
        L_0x0013:
            r0 = 29
            r1 = 45
            r2 = 20
            int r3 = r0 * r0
            int r4 = r1 * r1
            int r3 = r3 + r4
            int r4 = r2 * r2
            int r3 = r3 + r4
            r4 = 29
            int r4 = r4 * r1
            int r1 = r1 * r2
            int r4 = r4 + r1
            int r0 = r0 * r2
            int r4 = r4 + r0
        L_0x0028:
            r5.o = r6
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.u.a(int):com.bytedance.sdk.openadsdk.core.u");
    }

    public u a(View view) {
        while (true) {
            char c2 = '^';
            char c3 = 'K';
            while (true) {
                switch (c2) {
                    case '\\':
                        switch (c3) {
                            case 21:
                                break;
                            case 22:
                                break;
                            case 23:
                                break;
                        }
                    case ']':
                        break;
                    case '^':
                        break;
                }
                c2 = ']';
                c3 = ']';
            }
            while (true) {
                switch (c3) {
                    case '[':
                    case '\\':
                        break;
                    case ']':
                        break;
                    default:
                        c3 = '[';
                }
            }
        }
        this.k = new WeakReference<>(view);
        return this;
    }

    /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP_START, MTH_ENTER_BLOCK] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.bytedance.sdk.openadsdk.core.u a(com.bytedance.sdk.component.adexpress.b.j r6) {
        /*
            r5 = this;
        L_0x0000:
            r0 = 73
            switch(r0) {
                case 72: goto L_0x0013;
                case 73: goto L_0x0028;
                case 74: goto L_0x0006;
                default: goto L_0x0005;
            }
        L_0x0005:
            goto L_0x0000
        L_0x0006:
            r0 = 82
            r1 = 1
            int r2 = 82 - r1
            int r2 = r2 * r0
            int r0 = r0 * 2
            int r0 = r0 - r1
            int r2 = r2 * r0
            int r2 = r2 % 6
            goto L_0x0028
        L_0x0013:
            r0 = 29
            r1 = 45
            r2 = 20
            int r3 = r0 * r0
            int r4 = r1 * r1
            int r3 = r3 + r4
            int r4 = r2 * r2
            int r3 = r3 + r4
            r4 = 29
            int r4 = r4 * r1
            int r1 = r1 * r2
            int r4 = r4 + r1
            int r0 = r0 * r2
            int r4 = r4 + r0
        L_0x0028:
            r5.r = r6
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.u.a(com.bytedance.sdk.component.adexpress.b.j):com.bytedance.sdk.openadsdk.core.u");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0084, code lost:
        if (((13 * 13) - ((19 * 19) * 34)) != -1) goto L_0x0092;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x011f, code lost:
        r10 = '\'';
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0018, code lost:
        switch(r10) {
            case 39: goto L_0x0023;
            case 40: goto L_0x0020;
            case 41: goto L_0x001d;
            default: goto L_0x001b;
        };
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x001d, code lost:
        r10 = r0;
        r0 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0020, code lost:
        r10 = r0;
        r0 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0023, code lost:
        r10 = r0;
        r0 = r4;
     */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x008f  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0096 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x011b A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x0068 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.bytedance.sdk.openadsdk.core.u a(com.bytedance.sdk.component.widget.SSWebView r10) {
        /*
            r9 = this;
            r0 = r10
            r10 = r9
        L_0x0002:
            r1 = 72
            r2 = 87
            r3 = 1
            switch(r2) {
                case 85: goto L_0x0015;
                case 86: goto L_0x000b;
                case 87: goto L_0x0012;
                default: goto L_0x000a;
            }
        L_0x000a:
            goto L_0x0002
        L_0x000b:
            r4 = 90
            int r4 = r4 + r3
            int r4 = r4 * 90
            int r4 = r4 % 2
        L_0x0012:
            r4 = r10
            r5 = r0
            goto L_0x0062
        L_0x0015:
            r4 = r0
            r0 = r10
            r10 = r1
        L_0x0018:
            switch(r10) {
                case 39: goto L_0x0023;
                case 40: goto L_0x0020;
                case 41: goto L_0x001d;
                default: goto L_0x001b;
            }
        L_0x001b:
            goto L_0x011f
        L_0x001d:
            r10 = r0
            r0 = r4
            goto L_0x004b
        L_0x0020:
            r10 = r0
            r0 = r4
            goto L_0x0034
        L_0x0023:
            r10 = r0
            r0 = r4
        L_0x0025:
            r4 = 12
            r5 = 14
            int r6 = r4 * r4
            int r7 = r5 * r5
            int r6 = r6 + r7
            int r4 = r4 * r5
            int r4 = r4 * 2
            int r6 = r6 - r4
            if (r6 >= 0) goto L_0x0002
        L_0x0034:
            r4 = 54
            r5 = 27
            r6 = 24
            int r7 = r4 * r4
            int r8 = r5 * r5
            int r7 = r7 + r8
            int r8 = r6 * r6
            int r7 = r7 + r8
            r8 = 54
            int r8 = r8 * r5
            int r5 = r5 * r6
            int r8 = r8 + r5
            int r4 = r4 * r6
            int r8 = r8 + r4
            if (r7 >= r8) goto L_0x0002
        L_0x004b:
            r4 = 94
            r5 = 17
            r6 = 7
            int r7 = r4 * r4
            int r7 = r7 * r4
            int r8 = r5 * r5
            int r8 = r8 * r5
            int r7 = r7 + r8
            int r8 = r6 * r6
            int r8 = r8 * r6
            int r7 = r7 + r8
            int r4 = r4 * r5
            int r4 = r4 * r6
            int r4 = r4 * 3
            if (r7 >= r4) goto L_0x0012
            goto L_0x0098
        L_0x0062:
            r10 = 53
            switch(r10) {
                case 52: goto L_0x011b;
                case 53: goto L_0x0096;
                case 54: goto L_0x0068;
                default: goto L_0x0067;
            }
        L_0x0067:
            goto L_0x0062
        L_0x0068:
            switch(r2) {
                case 29: goto L_0x006f;
                case 30: goto L_0x007a;
                case 31: goto L_0x0086;
                default: goto L_0x006b;
            }
        L_0x006b:
            r10 = r1
            r0 = r4
            r4 = r5
            goto L_0x0018
        L_0x006f:
            int r10 = 87 - r3
            int r10 = r10 * r2
            r0 = 87
            int r0 = r0 * 2
            int r0 = r0 - r3
            int r10 = r10 * r0
            int r10 = r10 % 6
        L_0x007a:
            r10 = 13
            int r10 = r10 * r10
            r0 = 19
            int r0 = r0 * r0
            int r0 = r0 * 34
            int r10 = r10 - r0
            r0 = -1
            if (r10 != r0) goto L_0x0092
        L_0x0086:
            r10 = 10
            int r10 = r10 + r3
            int r10 = r10 * 10
            int r10 = r10 % 2
            if (r10 == 0) goto L_0x0096
            r10 = r4
            r0 = r5
            goto L_0x0025
        L_0x0092:
            r10 = r4
            r0 = r5
            goto L_0x0012
        L_0x0096:
            r10 = r4
            r0 = r5
        L_0x0098:
            java.lang.String r1 = "wd`um`qwgff"
            java.lang.String r1 = com.bytedance.sdk.component.adexpress.widget.DynamicUnlockView.DynamicUnlockView1667305730929dc(r1)
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r4 = "=<?vw`Ltj;*|ioXfuf2{uf~Tw}!"
            java.lang.String r4 = com.bytedance.sdk.component.adexpress.widget.DynamicUnlockView.DynamicUnlockView1667305730929dc(r4)
            r2.append(r4)
            int r4 = r0.hashCode()
            r2.append(r4)
            java.lang.String r2 = r2.toString()
            com.bytedance.sdk.component.utils.l.e(r1, r2)
            if (r0 != 0) goto L_0x00c3
            android.webkit.WebView r1 = r0.getWebView()
            if (r1 != 0) goto L_0x00c3
            return r10
        L_0x00c3:
            android.webkit.WebView r0 = r0.getWebView()     // Catch:{ Exception -> 0x011a }
            com.bytedance.sdk.component.a.j r0 = com.bytedance.sdk.component.a.r.a(r0)     // Catch:{ Exception -> 0x011a }
            com.bytedance.sdk.openadsdk.g.a r1 = new com.bytedance.sdk.openadsdk.g.a     // Catch:{ Exception -> 0x011a }
            r1.<init>()     // Catch:{ Exception -> 0x011a }
            com.bytedance.sdk.component.a.j r0 = r0.a((com.bytedance.sdk.component.a.a) r1)     // Catch:{ Exception -> 0x011a }
            java.lang.String r1 = "TnwwmdiM[Kxbhjk"
            java.lang.String r1 = com.bytedance.sdk.component.adexpress.widget.DynamicUnlockView.DynamicUnlockView1667305730929dc(r1)     // Catch:{ Exception -> 0x011a }
            com.bytedance.sdk.component.a.j r0 = r0.a((java.lang.String) r1)     // Catch:{ Exception -> 0x011a }
            com.bytedance.sdk.openadsdk.core.u$1 r1 = new com.bytedance.sdk.openadsdk.core.u$1     // Catch:{ Exception -> 0x011a }
            r1.<init>()     // Catch:{ Exception -> 0x011a }
            com.bytedance.sdk.component.a.j r0 = r0.a((com.bytedance.sdk.component.a.l) r1)     // Catch:{ Exception -> 0x011a }
            com.bytedance.sdk.openadsdk.core.h r1 = com.bytedance.sdk.openadsdk.core.h.d()     // Catch:{ Exception -> 0x011a }
            boolean r1 = r1.s()     // Catch:{ Exception -> 0x011a }
            com.bytedance.sdk.component.a.j r0 = r0.a((boolean) r1)     // Catch:{ Exception -> 0x011a }
            com.bytedance.sdk.component.a.j r0 = r0.b(r3)     // Catch:{ Exception -> 0x011a }
            com.bytedance.sdk.component.a.j r0 = r0.a()     // Catch:{ Exception -> 0x011a }
            com.bytedance.sdk.component.a.r r0 = r0.b()     // Catch:{ Exception -> 0x011a }
            r10.I = r0     // Catch:{ Exception -> 0x011a }
            com.bytedance.sdk.component.a.r r0 = r10.I
            com.bytedance.sdk.openadsdk.g.a.e.a((com.bytedance.sdk.component.a.r) r0, (com.bytedance.sdk.openadsdk.core.u) r10)
            com.bytedance.sdk.component.a.r r0 = r10.I
            com.bytedance.sdk.openadsdk.g.a.a.a((com.bytedance.sdk.component.a.r) r0, (com.bytedance.sdk.openadsdk.core.u) r10)
            com.bytedance.sdk.component.a.r r0 = r10.I
            com.bytedance.sdk.openadsdk.g.a.b.a((com.bytedance.sdk.component.a.r) r0, (com.bytedance.sdk.openadsdk.core.u) r10)
            com.bytedance.sdk.component.a.r r0 = r10.I
            com.bytedance.sdk.openadsdk.g.a.c.a((com.bytedance.sdk.component.a.r) r0, (com.bytedance.sdk.openadsdk.core.u) r10)
            com.bytedance.sdk.component.a.r r0 = r10.I
            com.bytedance.sdk.openadsdk.g.a.d.a((com.bytedance.sdk.component.a.r) r0, (com.bytedance.sdk.openadsdk.core.u) r10)
        L_0x011a:
            return r10
        L_0x011b:
            r10 = r4
            r0 = r5
            goto L_0x0002
        L_0x011f:
            r10 = 39
            goto L_0x0018
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.u.a(com.bytedance.sdk.component.widget.SSWebView):com.bytedance.sdk.openadsdk.core.u");
    }

    /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP_START, MTH_ENTER_BLOCK] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.bytedance.sdk.openadsdk.core.u a(com.bytedance.sdk.openadsdk.c.m r6) {
        /*
            r5 = this;
        L_0x0000:
            r0 = 73
            switch(r0) {
                case 72: goto L_0x0013;
                case 73: goto L_0x0028;
                case 74: goto L_0x0006;
                default: goto L_0x0005;
            }
        L_0x0005:
            goto L_0x0000
        L_0x0006:
            r0 = 82
            r1 = 1
            int r2 = 82 - r1
            int r2 = r2 * r0
            int r0 = r0 * 2
            int r0 = r0 - r1
            int r2 = r2 * r0
            int r2 = r2 % 6
            goto L_0x0028
        L_0x0013:
            r0 = 29
            r1 = 45
            r2 = 20
            int r3 = r0 * r0
            int r4 = r1 * r1
            int r3 = r3 + r4
            int r4 = r2 * r2
            int r3 = r3 + r4
            r4 = 29
            int r4 = r4 * r1
            int r1 = r1 * r2
            int r4 = r4 + r1
            int r0 = r0 * r2
            int r4 = r4 + r0
        L_0x0028:
            r5.H = r6
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.u.a(com.bytedance.sdk.openadsdk.c.m):com.bytedance.sdk.openadsdk.core.u");
    }

    /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP_START, MTH_ENTER_BLOCK] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.bytedance.sdk.openadsdk.core.u a(com.bytedance.sdk.openadsdk.core.b.d r6) {
        /*
            r5 = this;
        L_0x0000:
            r0 = 73
            switch(r0) {
                case 72: goto L_0x0013;
                case 73: goto L_0x0028;
                case 74: goto L_0x0006;
                default: goto L_0x0005;
            }
        L_0x0005:
            goto L_0x0000
        L_0x0006:
            r0 = 82
            r1 = 1
            int r2 = 82 - r1
            int r2 = r2 * r0
            int r0 = r0 * 2
            int r0 = r0 - r1
            int r2 = r2 * r0
            int r2 = r2 % 6
            goto L_0x0028
        L_0x0013:
            r0 = 29
            r1 = 45
            r2 = 20
            int r3 = r0 * r0
            int r4 = r1 * r1
            int r3 = r3 + r4
            int r4 = r2 * r2
            int r3 = r3 + r4
            r4 = 29
            int r4 = r4 * r1
            int r1 = r1 * r2
            int r4 = r4 + r1
            int r0 = r0 * r2
            int r4 = r4 + r0
        L_0x0028:
            r5.z = r6
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.u.a(com.bytedance.sdk.openadsdk.core.b.d):com.bytedance.sdk.openadsdk.core.u");
    }

    /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP_START, MTH_ENTER_BLOCK] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.bytedance.sdk.openadsdk.core.u a(com.bytedance.sdk.openadsdk.core.model.n r6) {
        /*
            r5 = this;
        L_0x0000:
            r0 = 73
            switch(r0) {
                case 72: goto L_0x0013;
                case 73: goto L_0x0028;
                case 74: goto L_0x0006;
                default: goto L_0x0005;
            }
        L_0x0005:
            goto L_0x0000
        L_0x0006:
            r0 = 82
            r1 = 1
            int r2 = 82 - r1
            int r2 = r2 * r0
            int r0 = r0 * 2
            int r0 = r0 - r1
            int r2 = r2 * r0
            int r2 = r2 % 6
            goto L_0x0028
        L_0x0013:
            r0 = 29
            r1 = 45
            r2 = 20
            int r3 = r0 * r0
            int r4 = r1 * r1
            int r3 = r3 + r4
            int r4 = r2 * r2
            int r3 = r3 + r4
            r4 = 29
            int r4 = r4 * r1
            int r1 = r1 * r2
            int r4 = r4 + r1
            int r0 = r0 * r2
            int r4 = r4 + r0
        L_0x0028:
            r5.q = r6
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.u.a(com.bytedance.sdk.openadsdk.core.model.n):com.bytedance.sdk.openadsdk.core.u");
    }

    /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP_START, MTH_ENTER_BLOCK] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.bytedance.sdk.openadsdk.core.u a(com.bytedance.sdk.openadsdk.core.nativeexpress.i r6) {
        /*
            r5 = this;
        L_0x0000:
            r0 = 73
            switch(r0) {
                case 72: goto L_0x0013;
                case 73: goto L_0x0028;
                case 74: goto L_0x0006;
                default: goto L_0x0005;
            }
        L_0x0005:
            goto L_0x0000
        L_0x0006:
            r0 = 82
            r1 = 1
            int r2 = 82 - r1
            int r2 = r2 * r0
            int r0 = r0 * 2
            int r0 = r0 - r1
            int r2 = r2 * r0
            int r2 = r2 % 6
            goto L_0x0028
        L_0x0013:
            r0 = 29
            r1 = 45
            r2 = 20
            int r3 = r0 * r0
            int r4 = r1 * r1
            int r3 = r3 + r4
            int r4 = r2 * r2
            int r3 = r3 + r4
            r4 = 29
            int r4 = r4 * r1
            int r1 = r1 * r2
            int r4 = r4 + r1
            int r0 = r0 * r2
            int r4 = r4 + r0
        L_0x0028:
            r5.s = r6
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.u.a(com.bytedance.sdk.openadsdk.core.nativeexpress.i):com.bytedance.sdk.openadsdk.core.u");
    }

    /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP_START, MTH_ENTER_BLOCK] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.bytedance.sdk.openadsdk.core.u a(com.bytedance.sdk.openadsdk.f.d r6) {
        /*
            r5 = this;
        L_0x0000:
            r0 = 73
            switch(r0) {
                case 72: goto L_0x0013;
                case 73: goto L_0x0028;
                case 74: goto L_0x0006;
                default: goto L_0x0005;
            }
        L_0x0005:
            goto L_0x0000
        L_0x0006:
            r0 = 82
            r1 = 1
            int r2 = 82 - r1
            int r2 = r2 * r0
            int r0 = r0 * 2
            int r0 = r0 - r1
            int r2 = r2 * r0
            int r2 = r2 % 6
            goto L_0x0028
        L_0x0013:
            r0 = 29
            r1 = 45
            r2 = 20
            int r3 = r0 * r0
            int r4 = r1 * r1
            int r3 = r3 + r4
            int r4 = r2 * r2
            int r3 = r3 + r4
            r4 = 29
            int r4 = r4 * r1
            int r1 = r1 * r2
            int r4 = r4 + r1
            int r0 = r0 * r2
            int r4 = r4 + r0
        L_0x0028:
            r5.u = r6
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.u.a(com.bytedance.sdk.openadsdk.f.d):com.bytedance.sdk.openadsdk.core.u");
    }

    /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP_START, MTH_ENTER_BLOCK] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.bytedance.sdk.openadsdk.core.u a(com.bytedance.sdk.openadsdk.jslistener.a r6) {
        /*
            r5 = this;
        L_0x0000:
            r0 = 73
            switch(r0) {
                case 72: goto L_0x0013;
                case 73: goto L_0x0028;
                case 74: goto L_0x0006;
                default: goto L_0x0005;
            }
        L_0x0005:
            goto L_0x0000
        L_0x0006:
            r0 = 82
            r1 = 1
            int r2 = 82 - r1
            int r2 = r2 * r0
            int r0 = r0 * 2
            int r0 = r0 - r1
            int r2 = r2 * r0
            int r2 = r2 % 6
            goto L_0x0028
        L_0x0013:
            r0 = 29
            r1 = 45
            r2 = 20
            int r3 = r0 * r0
            int r4 = r1 * r1
            int r3 = r3 + r4
            int r4 = r2 * r2
            int r3 = r3 + r4
            r4 = 29
            int r4 = r4 * r1
            int r1 = r1 * r2
            int r4 = r4 + r1
            int r0 = r0 * r2
            int r4 = r4 + r0
        L_0x0028:
            r5.v = r6
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.u.a(com.bytedance.sdk.openadsdk.jslistener.a):com.bytedance.sdk.openadsdk.core.u");
    }

    /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP_START, MTH_ENTER_BLOCK] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.bytedance.sdk.openadsdk.core.u a(com.bytedance.sdk.openadsdk.jslistener.b r6) {
        /*
            r5 = this;
        L_0x0000:
            r0 = 73
            switch(r0) {
                case 72: goto L_0x0013;
                case 73: goto L_0x0028;
                case 74: goto L_0x0006;
                default: goto L_0x0005;
            }
        L_0x0005:
            goto L_0x0000
        L_0x0006:
            r0 = 82
            r1 = 1
            int r2 = 82 - r1
            int r2 = r2 * r0
            int r0 = r0 * 2
            int r0 = r0 - r1
            int r2 = r2 * r0
            int r2 = r2 % 6
            goto L_0x0028
        L_0x0013:
            r0 = 29
            r1 = 45
            r2 = 20
            int r3 = r0 * r0
            int r4 = r1 * r1
            int r3 = r3 + r4
            int r4 = r2 * r2
            int r3 = r3 + r4
            r4 = 29
            int r4 = r4 * r1
            int r1 = r1 * r2
            int r4 = r4 + r1
            int r0 = r0 * r2
            int r4 = r4 + r0
        L_0x0028:
            r5.A = r6
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.u.a(com.bytedance.sdk.openadsdk.jslistener.b):com.bytedance.sdk.openadsdk.core.u");
    }

    /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP_START, MTH_ENTER_BLOCK] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.bytedance.sdk.openadsdk.core.u a(com.bytedance.sdk.openadsdk.jslistener.d r6) {
        /*
            r5 = this;
        L_0x0000:
            r0 = 73
            switch(r0) {
                case 72: goto L_0x0013;
                case 73: goto L_0x0028;
                case 74: goto L_0x0006;
                default: goto L_0x0005;
            }
        L_0x0005:
            goto L_0x0000
        L_0x0006:
            r0 = 82
            r1 = 1
            int r2 = 82 - r1
            int r2 = r2 * r0
            int r0 = r0 * 2
            int r0 = r0 - r1
            int r2 = r2 * r0
            int r2 = r2 % 6
            goto L_0x0028
        L_0x0013:
            r0 = 29
            r1 = 45
            r2 = 20
            int r3 = r0 * r0
            int r4 = r1 * r1
            int r3 = r3 + r4
            int r4 = r2 * r2
            int r3 = r3 + r4
            r4 = 29
            int r4 = r4 * r1
            int r1 = r1 * r2
            int r4 = r4 + r1
            int r0 = r0 * r2
            int r4 = r4 + r0
        L_0x0028:
            r5.x = r6
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.u.a(com.bytedance.sdk.openadsdk.jslistener.d):com.bytedance.sdk.openadsdk.core.u");
    }

    /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP_START, MTH_ENTER_BLOCK] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.bytedance.sdk.openadsdk.core.u a(com.bytedance.sdk.openadsdk.jslistener.e r6) {
        /*
            r5 = this;
        L_0x0000:
            r0 = 73
            switch(r0) {
                case 72: goto L_0x0013;
                case 73: goto L_0x0028;
                case 74: goto L_0x0006;
                default: goto L_0x0005;
            }
        L_0x0005:
            goto L_0x0000
        L_0x0006:
            r0 = 82
            r1 = 1
            int r2 = 82 - r1
            int r2 = r2 * r0
            int r0 = r0 * 2
            int r0 = r0 - r1
            int r2 = r2 * r0
            int r2 = r2 % 6
            goto L_0x0028
        L_0x0013:
            r0 = 29
            r1 = 45
            r2 = 20
            int r3 = r0 * r0
            int r4 = r1 * r1
            int r3 = r3 + r4
            int r4 = r2 * r2
            int r3 = r3 + r4
            r4 = 29
            int r4 = r4 * r1
            int r1 = r1 * r2
            int r4 = r4 + r1
            int r0 = r0 * r2
            int r4 = r4 + r0
        L_0x0028:
            r5.w = r6
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.u.a(com.bytedance.sdk.openadsdk.jslistener.e):com.bytedance.sdk.openadsdk.core.u");
    }

    /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP_START, MTH_ENTER_BLOCK] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.bytedance.sdk.openadsdk.core.u a(com.bytedance.sdk.openadsdk.jslistener.h r6) {
        /*
            r5 = this;
        L_0x0000:
            r0 = 73
            switch(r0) {
                case 72: goto L_0x0013;
                case 73: goto L_0x0028;
                case 74: goto L_0x0006;
                default: goto L_0x0005;
            }
        L_0x0005:
            goto L_0x0000
        L_0x0006:
            r0 = 82
            r1 = 1
            int r2 = 82 - r1
            int r2 = r2 * r0
            int r0 = r0 * 2
            int r0 = r0 - r1
            int r2 = r2 * r0
            int r2 = r2 % 6
            goto L_0x0028
        L_0x0013:
            r0 = 29
            r1 = 45
            r2 = 20
            int r3 = r0 * r0
            int r4 = r1 * r1
            int r3 = r3 + r4
            int r4 = r2 * r2
            int r3 = r3 + r4
            r4 = 29
            int r4 = r4 * r1
            int r1 = r1 * r2
            int r4 = r4 + r1
            int r0 = r0 * r2
            int r4 = r4 + r0
        L_0x0028:
            r5.B = r6
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.u.a(com.bytedance.sdk.openadsdk.jslistener.h):com.bytedance.sdk.openadsdk.core.u");
    }

    /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP_START, MTH_ENTER_BLOCK] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.bytedance.sdk.openadsdk.core.u a(java.util.List<com.bytedance.sdk.openadsdk.core.model.n> r6) {
        /*
            r5 = this;
        L_0x0000:
            r0 = 73
            switch(r0) {
                case 72: goto L_0x0013;
                case 73: goto L_0x0028;
                case 74: goto L_0x0006;
                default: goto L_0x0005;
            }
        L_0x0005:
            goto L_0x0000
        L_0x0006:
            r0 = 82
            r1 = 1
            int r2 = 82 - r1
            int r2 = r2 * r0
            int r0 = r0 * 2
            int r0 = r0 - r1
            int r2 = r2 * r0
            int r2 = r2 % 6
            goto L_0x0028
        L_0x0013:
            r0 = 29
            r1 = 45
            r2 = 20
            int r3 = r0 * r0
            int r4 = r1 * r1
            int r3 = r3 + r4
            int r4 = r2 * r2
            int r3 = r3 + r4
            r4 = 29
            int r4 = r4 * r1
            int r1 = r1 * r2
            int r4 = r4 + r1
            int r0 = r0 * r2
            int r4 = r4 + r0
        L_0x0028:
            r5.D = r6
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.u.a(java.util.List):com.bytedance.sdk.openadsdk.core.u");
    }

    /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP_START, MTH_ENTER_BLOCK] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.bytedance.sdk.openadsdk.core.u a(java.util.Map<java.lang.String, java.lang.Object> r6) {
        /*
            r5 = this;
        L_0x0000:
            r0 = 73
            switch(r0) {
                case 72: goto L_0x0013;
                case 73: goto L_0x0028;
                case 74: goto L_0x0006;
                default: goto L_0x0005;
            }
        L_0x0005:
            goto L_0x0000
        L_0x0006:
            r0 = 82
            r1 = 1
            int r2 = 82 - r1
            int r2 = r2 * r0
            int r0 = r0 * 2
            int r0 = r0 - r1
            int r2 = r2 * r0
            int r2 = r2 % 6
            goto L_0x0028
        L_0x0013:
            r0 = 29
            r1 = 45
            r2 = 20
            int r3 = r0 * r0
            int r4 = r1 * r1
            int r3 = r3 + r4
            int r4 = r2 * r2
            int r3 = r3 + r4
            r4 = 29
            int r4 = r4 * r1
            int r1 = r1 * r2
            int r4 = r4 + r1
            int r0 = r0 * r2
            int r4 = r4 + r0
        L_0x0028:
            r5.a = r6
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.u.a(java.util.Map):com.bytedance.sdk.openadsdk.core.u");
    }

    /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP_START, MTH_ENTER_BLOCK] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.bytedance.sdk.openadsdk.core.u a(org.json.JSONObject r6) {
        /*
            r5 = this;
        L_0x0000:
            r0 = 73
            switch(r0) {
                case 72: goto L_0x0013;
                case 73: goto L_0x0028;
                case 74: goto L_0x0006;
                default: goto L_0x0005;
            }
        L_0x0005:
            goto L_0x0000
        L_0x0006:
            r0 = 82
            r1 = 1
            int r2 = 82 - r1
            int r2 = r2 * r0
            int r0 = r0 * 2
            int r0 = r0 - r1
            int r2 = r2 * r0
            int r2 = r2 % 6
            goto L_0x0028
        L_0x0013:
            r0 = 29
            r1 = 45
            r2 = 20
            int r3 = r0 * r0
            int r4 = r1 * r1
            int r3 = r3 + r4
            int r4 = r2 * r2
            int r3 = r3 + r4
            r4 = 29
            int r4 = r4 * r1
            int r1 = r1 * r2
            int r4 = r4 + r1
            int r0 = r0 * r2
            int r4 = r4 + r0
        L_0x0028:
            r5.t = r6
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.u.a(org.json.JSONObject):com.bytedance.sdk.openadsdk.core.u");
    }

    /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP_START, MTH_ENTER_BLOCK] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.bytedance.sdk.openadsdk.core.u a(boolean r6) {
        /*
            r5 = this;
        L_0x0000:
            r0 = 73
            switch(r0) {
                case 72: goto L_0x0013;
                case 73: goto L_0x0028;
                case 74: goto L_0x0006;
                default: goto L_0x0005;
            }
        L_0x0005:
            goto L_0x0000
        L_0x0006:
            r0 = 82
            r1 = 1
            int r2 = 82 - r1
            int r2 = r2 * r0
            int r0 = r0 * 2
            int r0 = r0 - r1
            int r2 = r2 * r0
            int r2 = r2 % 6
            goto L_0x0028
        L_0x0013:
            r0 = 29
            r1 = 45
            r2 = 20
            int r3 = r0 * r0
            int r4 = r1 * r1
            int r3 = r3 + r4
            int r4 = r2 * r2
            int r3 = r3 + r4
            r4 = 29
            int r4 = r4 * r1
            int r1 = r1 * r2
            int r4 = r4 + r1
            int r0 = r0 * r2
            int r4 = r4 + r0
        L_0x0028:
            r5.b = r6
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.u.a(boolean):com.bytedance.sdk.openadsdk.core.u");
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x004e, code lost:
        if ((((17 + 1) * 17) % 2) == 0) goto L_0x05ae;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:126:0x02d7, code lost:
        if (r10.equals(com.bytedance.sdk.component.f.c.a.a1667305730924dc("st`pgwoemVk{|Rok")) != false) goto L_0x02db;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:193:0x046a, code lost:
        if (r4 != null) goto L_0x056a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:197:0x048b, code lost:
        r8.put(r4, r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:200:0x049b, code lost:
        if (r4 != null) goto L_0x056a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:229:0x056a, code lost:
        if (r0 != r3) goto L_0x05ad;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:231:0x0574, code lost:
        if (android.text.TextUtils.isEmpty(r1.b) != false) goto L_0x05ad;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:232:0x0576, code lost:
        b(r1.b, r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:233:0x0583, code lost:
        if (com.bytedance.sdk.openadsdk.core.h.d().s() == false) goto L_0x05ad;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:234:0x0585, code lost:
        android.util.Log.d(com.bytedance.sdk.component.f.c.d.d1667305730926dc("TUCm`winlFhainz"), com.bytedance.sdk.component.f.c.d.d1667305730926dc("[KQA)WUWU)|n~~g`~+") + r0 + com.bytedance.sdk.component.f.c.d.d1667305730926dc(" ecwe8") + r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:235:0x05ad, code lost:
        return r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:236:0x05ae, code lost:
        switch(r9) {
            case 39: goto L_0x05c2;
            case 40: goto L_0x05bf;
            case 41: goto L_0x05b4;
            default: goto L_0x05b1;
        };
     */
    /* JADX WARNING: Code restructure failed: missing block: B:239:0x05bc, code lost:
        if (((13 * 13) - ((19 * 19) * 34)) != -1) goto L_0x003f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:241:0x05c2, code lost:
        switch(r8) {
            case 57: goto L_0x05c6;
            case 58: goto L_0x05cd;
            case 59: goto L_0x05d8;
            default: goto L_0x05c5;
        };
     */
    /* JADX WARNING: Code restructure failed: missing block: B:243:0x05cb, code lost:
        if ((((true + (r3 ? 1 : 0)) * 10) % 2) == 0) goto L_0x003f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:245:0x05d6, code lost:
        if (((61 * 61) - ((12 * 12) * 34)) != -1) goto L_0x05f7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:247:0x05f2, code lost:
        if ((((27 * 27) + (34 * 34)) + (17 * 17)) >= (((27 * 34) + (34 * 17)) + (27 * 17))) goto L_0x0006;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:248:0x05f4, code lost:
        r3 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:249:0x05f7, code lost:
        r11 = (11 * 11) * 11;
        r8 = (((55 * 55) * 55) + r11) + r11;
        r3 = ((55 * 11) * 11) * 3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:250:0x0606, code lost:
        r3 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:251:0x0609, code lost:
        r8 = ';';
        r9 = true;
        r3 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:257:0x0006, code lost:
        continue;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x003a, code lost:
        r9 = true;
        r8 = '(';
     */
    @com.bytedance.JProtect
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public org.json.JSONObject a(com.bytedance.sdk.openadsdk.core.u.a r22, int r23) throws java.lang.Exception {
        /*
            r21 = this;
            r2 = r21
            r1 = r22
            r0 = r23
        L_0x0006:
            r4 = 12
            r5 = 10
            r6 = 19
            r7 = 13
            r8 = 14
            r9 = 30
            r10 = 57
            r12 = 2
            r13 = -1
            r14 = 34
            r15 = 3
            r16 = 17
            r3 = 1
            switch(r9) {
                case 30: goto L_0x003f;
                case 31: goto L_0x0020;
                case 32: goto L_0x003a;
                default: goto L_0x001f;
            }
        L_0x001f:
            goto L_0x0006
        L_0x0020:
            r17 = 68
            int r18 = r17 * r17
            int r18 = r18 * 68
            int r19 = r8 * r8
            int r19 = r19 * 14
            int r18 = r18 + r19
            int r19 = r16 * r16
            int r19 = r19 * 17
            int r9 = r18 + r19
            int r17 = r17 * 14
            int r17 = r17 * 17
            int r8 = r17 * 3
            if (r9 >= r8) goto L_0x0050
        L_0x003a:
            r9 = r10
            r8 = 40
            goto L_0x05ae
        L_0x003f:
            r8 = 83
            switch(r8) {
                case 82: goto L_0x0045;
                case 83: goto L_0x0050;
                case 84: goto L_0x05f7;
                default: goto L_0x0044;
            }
        L_0x0044:
            goto L_0x003f
        L_0x0045:
            r9 = r10
        L_0x0046:
            r17 = 17
            int r17 = r17 + 1
            int r17 = r17 * 17
            int r17 = r17 % 2
            if (r17 == 0) goto L_0x05ae
        L_0x0050:
            java.lang.String r8 = "c`no"
            java.lang.String r8 = com.bytedance.sdk.component.f.c.d.d1667305730926dc(r8)
            java.lang.String r9 = r1.a
            boolean r8 = r8.equals(r9)
            if (r8 != 0) goto L_0x0060
            r0 = 0
            return r0
        L_0x0060:
            com.bytedance.sdk.openadsdk.core.h r8 = com.bytedance.sdk.openadsdk.core.h.d()
            boolean r8 = r8.s()
            java.lang.String r9 = "TUCm`winlFhainz"
            if (r8 == 0) goto L_0x00af
            java.lang.String r8 = com.bytedance.sdk.component.f.c.a.a1667305730924dc(r9)
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r17 = "[KQA)WCVU)|n~~g`~+"
            java.lang.String r11 = com.bytedance.sdk.component.f.c.a.a1667305730924dc(r17)
            r10.append(r11)
            r10.append(r0)
            java.lang.String r11 = " lgwljb="
            java.lang.String r11 = com.bytedance.sdk.component.f.c.a.a1667305730924dc(r11)
            r10.append(r11)
            java.lang.String r11 = r1.c
            r10.append(r11)
            java.lang.String r11 = " qcqehu:"
            java.lang.String r11 = com.bytedance.sdk.component.f.c.a.a1667305730924dc(r11)
            r10.append(r11)
            org.json.JSONObject r11 = r1.d
            if (r11 == 0) goto L_0x00a3
            org.json.JSONObject r11 = r1.d
            java.lang.String r11 = r11.toString()
            goto L_0x00a5
        L_0x00a3:
            java.lang.String r11 = ""
        L_0x00a5:
            r10.append(r11)
            java.lang.String r10 = r10.toString()
            android.util.Log.d(r8, r10)
        L_0x00af:
            org.json.JSONObject r8 = new org.json.JSONObject
            r8.<init>()
            java.lang.String r10 = r1.c
            int r11 = r10.hashCode()
            switch(r11) {
                case -2036781162: goto L_0x02cd;
                case -1423303823: goto L_0x02bf;
                case -1330994877: goto L_0x02b0;
                case -1169135450: goto L_0x02a1;
                case -1023873614: goto L_0x0292;
                case -844321441: goto L_0x0283;
                case -800853518: goto L_0x0274;
                case -794273169: goto L_0x0265;
                case -715147645: goto L_0x0256;
                case -511324706: goto L_0x0246;
                case -489318846: goto L_0x0236;
                case -278382602: goto L_0x0226;
                case -173752734: goto L_0x0217;
                case 27837080: goto L_0x0208;
                case 94756344: goto L_0x01f9;
                case 105049135: goto L_0x01e9;
                case 399543522: goto L_0x01d9;
                case 402955465: goto L_0x01ca;
                case 425443791: goto L_0x01ba;
                case 442647767: goto L_0x01aa;
                case 571273292: goto L_0x019b;
                case 650209982: goto L_0x018c;
                case 672928467: goto L_0x017c;
                case 711635577: goto L_0x016c;
                case 885131792: goto L_0x015c;
                case 1107374321: goto L_0x014c;
                case 1151744482: goto L_0x013c;
                case 1237100796: goto L_0x012c;
                case 1532142616: goto L_0x011d;
                case 1634511418: goto L_0x010d;
                case 1713585602: goto L_0x00fd;
                case 1731806400: goto L_0x00ee;
                case 1979895452: goto L_0x00df;
                case 2086000188: goto L_0x00cf;
                case 2105008900: goto L_0x00bf;
                default: goto L_0x00bd;
            }
        L_0x00bd:
            goto L_0x02da
        L_0x00bf:
            java.lang.String r4 = "l`lgwfgwmVigene"
            java.lang.String r4 = com.bytedance.sdk.component.f.c.d.d1667305730926dc(r4)
            boolean r4 = r10.equals(r4)
            if (r4 == 0) goto L_0x02da
            r4 = 16
            goto L_0x02db
        L_0x00cf:
            java.lang.String r4 = "sjksRlbbg"
            java.lang.String r4 = com.bytedance.sdk.component.f.c.a.a1667305730924dc(r4)
            boolean r4 = r10.equals(r4)
            if (r4 == 0) goto L_0x02da
            r4 = 20
            goto L_0x02db
        L_0x00df:
            java.lang.String r4 = "sdlgHja"
            java.lang.String r4 = com.bytedance.sdk.component.f.c.a.a1667305730924dc(r4)
            boolean r4 = r10.equals(r4)
            if (r4 == 0) goto L_0x02da
            r4 = r12
            goto L_0x02db
        L_0x00ee:
            java.lang.String r4 = "pmczegjbWz~r`h"
            java.lang.String r4 = com.bytedance.sdk.component.f.c.a.a1667305730924dc(r4)
            boolean r4 = r10.equals(r4)
            if (r4 == 0) goto L_0x02da
            r4 = r15
            goto L_0x02db
        L_0x00fd:
            java.lang.String r4 = "gdvMaqqhzbNjxl"
            java.lang.String r4 = com.bytedance.sdk.component.f.c.a.a1667305730924dc(r4)
            boolean r4 = r10.equals(r4)
            if (r4 == 0) goto L_0x02da
            r4 = 26
            goto L_0x02db
        L_0x010d:
            java.lang.String r4 = "eof`ewbXdfko"
            java.lang.String r4 = com.bytedance.sdk.component.f.c.a.a1667305730924dc(r4)
            boolean r4 = r10.equals(r4)
            if (r4 == 0) goto L_0x02da
            r4 = 27
            goto L_0x02db
        L_0x011d:
            java.lang.String r4 = "rdolr`Jhimcek"
            java.lang.String r4 = com.bytedance.sdk.component.f.c.a.a1667305730924dc(r4)
            boolean r4 = r10.equals(r4)
            if (r4 == 0) goto L_0x02da
            r4 = r5
            goto L_0x02db
        L_0x012c:
            java.lang.String r4 = "rdlgawBnlOcee~f"
            java.lang.String r4 = com.bytedance.sdk.component.f.c.a.a1667305730924dc(r4)
            boolean r4 = r10.equals(r4)
            if (r4 == 0) goto L_0x02da
            r4 = 18
            goto L_0x02db
        L_0x013c:
            java.lang.String r4 = "mtvfRlbbg"
            java.lang.String r4 = com.bytedance.sdk.component.f.c.a.a1667305730924dc(r4)
            boolean r4 = r10.equals(r4)
            if (r4 == 0) goto L_0x02da
            r4 = 21
            goto L_0x02db
        L_0x014c:
            java.lang.String r4 = "p`wpaRce^`o|Xdcjbb"
            java.lang.String r4 = com.bytedance.sdk.component.f.c.a.a1667305730924dc(r4)
            boolean r4 = r10.equals(r4)
            if (r4 == 0) goto L_0x02da
            r4 = 29
            goto L_0x02db
        L_0x015c:
            java.lang.String r4 = "gdvUkisjm"
            java.lang.String r4 = com.bytedance.sdk.component.f.c.a.a1667305730924dc(r4)
            boolean r4 = r10.equals(r4)
            if (r4 == 0) goto L_0x02da
            r4 = 9
            goto L_0x02db
        L_0x016c:
            java.lang.String r4 = "gdv@qwtbf}\\bhha\\dpfv"
            java.lang.String r4 = com.bytedance.sdk.component.f.c.a.a1667305730924dc(r4)
            boolean r4 = r10.equals(r4)
            if (r4 == 0) goto L_0x02da
            r4 = 23
            goto L_0x02db
        L_0x017c:
            java.lang.String r4 = "c`l`aiYcg~dgcljPqabLuq"
            java.lang.String r4 = com.bytedance.sdk.component.f.c.a.a1667305730924dc(r4)
            boolean r4 = r10.equals(r4)
            if (r4 == 0) goto L_0x02da
            r4 = 14
            goto L_0x02db
        L_0x018c:
            java.lang.String r4 = "gdvWahvki}oBbka"
            java.lang.String r4 = com.bytedance.sdk.component.f.c.a.a1667305730924dc(r4)
            boolean r4 = r10.equals(r4)
            if (r4 == 0) goto L_0x02da
            r4 = 4
            goto L_0x02db
        L_0x019b:
            java.lang.String r4 = "dxlbileSzhi`"
            java.lang.String r4 = com.bytedance.sdk.component.f.c.a.a1667305730924dc(r4)
            boolean r4 = r10.equals(r4)
            if (r4 == 0) goto L_0x02da
            r4 = r6
            goto L_0x02db
        L_0x01aa:
            java.lang.String r4 = "sdlgV`qfzm"
            java.lang.String r4 = com.bytedance.sdk.component.f.c.a.a1667305730924dc(r4)
            boolean r4 = r10.equals(r4)
            if (r4 == 0) goto L_0x02da
            r4 = 11
            goto L_0x02db
        L_0x01ba:
            java.lang.String r4 = "gdvMeqoqmZciN{|d~Wuaw"
            java.lang.String r4 = com.bytedance.sdk.component.f.c.a.a1667305730924dc(r4)
            boolean r4 = r10.equals(r4)
            if (r4 == 0) goto L_0x02da
            r4 = 33
            goto L_0x02db
        L_0x01ca:
            java.lang.String r4 = "irTjargedl"
            java.lang.String r4 = com.bytedance.sdk.component.f.c.a.a1667305730924dc(r4)
            boolean r4 = r10.equals(r4)
            if (r4 == 0) goto L_0x02da
            r4 = 6
            goto L_0x02db
        L_0x01d9:
            java.lang.String r4 = "gdv@hjubJ|~ccGav~"
            java.lang.String r4 = com.bytedance.sdk.component.f.c.a.a1667305730924dc(r4)
            boolean r4 = r10.equals(r4)
            if (r4 == 0) goto L_0x02da
            r4 = 8
            goto L_0x02db
        L_0x01e9:
            java.lang.String r4 = "uoqvfveuakoTm}~Pqu"
            java.lang.String r4 = com.bytedance.sdk.component.f.c.a.a1667305730924dc(r4)
            boolean r4 = r10.equals(r4)
            if (r4 == 0) goto L_0x02da
            r4 = 15
            goto L_0x02db
        L_0x01f9:
            java.lang.String r4 = "cmmpa"
            java.lang.String r4 = com.bytedance.sdk.component.f.c.a.a1667305730924dc(r4)
            boolean r4 = r10.equals(r4)
            if (r4 == 0) goto L_0x02da
            r4 = r14
            goto L_0x02db
        L_0x0208:
            java.lang.String r4 = "dnumhjgcWhz{Slj"
            java.lang.String r4 = com.bytedance.sdk.component.f.c.a.a1667305730924dc(r4)
            boolean r4 = r10.equals(r4)
            if (r4 == 0) goto L_0x02da
            r4 = r7
            goto L_0x02db
        L_0x0217:
            java.lang.String r4 = "gdvWaHgnImy"
            java.lang.String r4 = com.bytedance.sdk.component.f.c.a.a1667305730924dc(r4)
            boolean r4 = r10.equals(r4)
            if (r4 == 0) goto L_0x02da
            r4 = 5
            goto L_0x02db
        L_0x0226:
            java.lang.String r4 = "sdlg[qcji`U{~bjzseMzpf"
            java.lang.String r4 = com.bytedance.sdk.component.f.c.a.a1667305730924dc(r4)
            boolean r4 = r10.equals(r4)
            if (r4 == 0) goto L_0x02da
            r4 = 24
            goto L_0x02db
        L_0x0236:
            java.lang.String r4 = "gdvNeqcuahfFiyo"
            java.lang.String r4 = com.bytedance.sdk.component.f.c.a.a1667305730924dc(r4)
            boolean r4 = r10.equals(r4)
            if (r4 == 0) goto L_0x02da
            r4 = 25
            goto L_0x02db
        L_0x0246:
            java.lang.String r4 = "oqgmTwoqijs"
            java.lang.String r4 = com.bytedance.sdk.component.f.c.a.a1667305730924dc(r4)
            boolean r4 = r10.equals(r4)
            if (r4 == 0) goto L_0x02da
            r4 = 31
            goto L_0x02db
        L_0x0256:
            java.lang.String r4 = "gdvPgwcbfZcqi"
            java.lang.String r4 = com.bytedance.sdk.component.f.c.a.a1667305730924dc(r4)
            boolean r4 = r10.equals(r4)
            if (r4 == 0) goto L_0x02da
            r4 = 7
            goto L_0x02db
        L_0x0265:
            java.lang.String r4 = "aqrJjci"
            java.lang.String r4 = com.bytedance.sdk.component.f.c.a.a1667305730924dc(r4)
            boolean r4 = r10.equals(r4)
            if (r4 == 0) goto L_0x02da
            r4 = 0
            goto L_0x02db
        L_0x0274:
            java.lang.String r4 = "cmk`o@pbf}"
            java.lang.String r4 = com.bytedance.sdk.component.f.c.a.a1667305730924dc(r4)
            boolean r4 = r10.equals(r4)
            if (r4 == 0) goto L_0x02da
            r4 = r16
            goto L_0x02db
        L_0x0283:
            java.lang.String r4 = "wd`um`qX|`gnSy|nsz"
            java.lang.String r4 = com.bytedance.sdk.component.f.c.a.a1667305730924dc(r4)
            boolean r4 = r10.equals(r4)
            if (r4 == 0) goto L_0x02da
            r4 = 30
            goto L_0x02db
        L_0x0292:
            java.lang.String r4 = "oqgmEaJffmZjkhBf~za"
            java.lang.String r4 = com.bytedance.sdk.component.f.c.a.a1667305730924dc(r4)
            boolean r4 = r10.equals(r4)
            if (r4 == 0) goto L_0x02da
            r4 = 32
            goto L_0x02db
        L_0x02a1:
            java.lang.String r4 = "cicmc`PnlleXxlzj"
            java.lang.String r4 = com.bytedance.sdk.component.f.c.a.a1667305730924dc(r4)
            boolean r4 = r10.equals(r4)
            if (r4 == 0) goto L_0x02da
            r4 = 22
            goto L_0x02db
        L_0x02b0:
            java.lang.String r4 = "p`wpaRce^`o|"
            java.lang.String r4 = com.bytedance.sdk.component.f.c.a.a1667305730924dc(r4)
            boolean r4 = r10.equals(r4)
            if (r4 == 0) goto L_0x02da
            r4 = 28
            goto L_0x02db
        L_0x02bf:
            java.lang.String r4 = "aeKmbj"
            java.lang.String r4 = com.bytedance.sdk.component.f.c.a.a1667305730924dc(r4)
            boolean r4 = r10.equals(r4)
            if (r4 == 0) goto L_0x02da
            r4 = r3
            goto L_0x02db
        L_0x02cd:
            java.lang.String r5 = "st`pgwoemVk{|Rok"
            java.lang.String r5 = com.bytedance.sdk.component.f.c.a.a1667305730924dc(r5)
            boolean r5 = r10.equals(r5)
            if (r5 == 0) goto L_0x02da
            goto L_0x02db
        L_0x02da:
            r4 = r13
        L_0x02db:
            switch(r4) {
                case 0: goto L_0x0564;
                case 1: goto L_0x0560;
                case 2: goto L_0x04ce;
                case 3: goto L_0x04c9;
                case 4: goto L_0x049f;
                case 5: goto L_0x0499;
                case 6: goto L_0x0490;
                case 7: goto L_0x046e;
                case 8: goto L_0x0466;
                case 9: goto L_0x0424;
                case 10: goto L_0x041b;
                case 11: goto L_0x0410;
                case 12: goto L_0x03f1;
                case 13: goto L_0x03c9;
                case 14: goto L_0x03be;
                case 15: goto L_0x03b3;
                case 16: goto L_0x039c;
                case 17: goto L_0x0395;
                case 18: goto L_0x038e;
                case 19: goto L_0x0387;
                case 20: goto L_0x0382;
                case 21: goto L_0x037b;
                case 22: goto L_0x0374;
                case 23: goto L_0x036f;
                case 24: goto L_0x0368;
                case 25: goto L_0x0363;
                case 26: goto L_0x035e;
                case 27: goto L_0x0357;
                case 28: goto L_0x0352;
                case 29: goto L_0x034d;
                case 30: goto L_0x0346;
                case 31: goto L_0x0334;
                case 32: goto L_0x0320;
                case 33: goto L_0x02f2;
                case 34: goto L_0x02e0;
                default: goto L_0x02de;
            }
        L_0x02de:
            goto L_0x0569
        L_0x02e0:
            java.lang.String r4 = com.bytedance.sdk.component.f.c.d.d1667305730926dc(r9)
            java.lang.String r5 = "MDVKKAYDDFYN"
            java.lang.String r5 = com.bytedance.sdk.component.f.c.d.d1667305730926dc(r5)
            com.bytedance.sdk.component.utils.l.b((java.lang.String) r4, (java.lang.String) r5)
            r2.f()
            goto L_0x0569
        L_0x02f2:
            java.lang.String r4 = com.bytedance.sdk.component.f.c.d.d1667305730926dc(r9)
            java.lang.String r5 = "MDVKKAY@M]UEMYGYUNAZ@PITMJNTQBZ^t`"
            java.lang.String r5 = com.bytedance.sdk.component.f.c.d.d1667305730926dc(r5)
            com.bytedance.sdk.component.utils.l.b((java.lang.String) r4, (java.lang.String) r5)
            com.bytedance.sdk.openadsdk.core.model.n r4 = r2.q
            if (r4 == 0) goto L_0x0569
            java.lang.String r4 = r4.D()
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            boolean r4 = android.text.TextUtils.isEmpty(r4)
            if (r4 != 0) goto L_0x0569
            java.lang.String r4 = "d`vb"
            java.lang.String r4 = com.bytedance.sdk.component.f.c.d.d1667305730926dc(r4)
            com.bytedance.sdk.openadsdk.core.model.n r5 = r2.q
            java.lang.String r5 = r5.D()
            r8.put(r4, r5)
            goto L_0x0569
        L_0x0320:
            java.lang.String r4 = com.bytedance.sdk.component.f.c.d.d1667305730926dc(r9)
            java.lang.String r5 = "MDVKKAYHXLDTC]KAOPVLXTXSHX]^CQWQkr"
            java.lang.String r5 = com.bytedance.sdk.component.f.c.d.d1667305730926dc(r5)
            com.bytedance.sdk.component.utils.l.b((java.lang.String) r4, (java.lang.String) r5)
            org.json.JSONObject r4 = r1.d
            r2.b((org.json.JSONObject) r4)
            goto L_0x0569
        L_0x0334:
            java.lang.String r4 = com.bytedance.sdk.component.f.c.d.d1667305730926dc(r9)
            java.lang.String r5 = "oqgmTwoqijs"
            java.lang.String r5 = com.bytedance.sdk.component.f.c.d.d1667305730926dc(r5)
            com.bytedance.sdk.component.utils.l.b((java.lang.String) r4, (java.lang.String) r5)
            r2.t()
            goto L_0x0569
        L_0x0346:
            org.json.JSONObject r4 = r1.d
            r2.f((org.json.JSONObject) r4)
            goto L_0x0569
        L_0x034d:
            r2.r()
            goto L_0x0569
        L_0x0352:
            r2.q()
            goto L_0x0569
        L_0x0357:
            org.json.JSONObject r4 = r1.d
            r2.g((org.json.JSONObject) r4)
            goto L_0x0569
        L_0x035e:
            r2.a((com.bytedance.sdk.openadsdk.core.u.a) r1, (org.json.JSONObject) r8)
            goto L_0x0569
        L_0x0363:
            r2.o(r8)
            goto L_0x0569
        L_0x0368:
            org.json.JSONObject r4 = r1.d
            r2.n(r4)
            goto L_0x0569
        L_0x036f:
            r2.j((org.json.JSONObject) r8)
            goto L_0x0569
        L_0x0374:
            org.json.JSONObject r4 = r1.d
            r2.i((org.json.JSONObject) r4)
            goto L_0x0569
        L_0x037b:
            org.json.JSONObject r4 = r1.d
            r2.h((org.json.JSONObject) r4)
            goto L_0x0569
        L_0x0382:
            r2.s()
            goto L_0x0569
        L_0x0387:
            org.json.JSONObject r4 = r1.d
            r2.m(r4)
            goto L_0x0569
        L_0x038e:
            org.json.JSONObject r4 = r1.d
            r2.k((org.json.JSONObject) r4)
            goto L_0x0569
        L_0x0395:
            org.json.JSONObject r4 = r1.d
            r2.c((org.json.JSONObject) r4)
            goto L_0x0569
        L_0x039c:
            java.lang.ref.WeakReference<android.content.Context> r4 = r2.h
            if (r4 == 0) goto L_0x0569
            java.lang.Object r4 = r4.get()
            android.content.Context r4 = (android.content.Context) r4
            if (r4 == 0) goto L_0x0569
            boolean r5 = r4 instanceof com.bytedance.sdk.openadsdk.core.video.c.b
            if (r5 == 0) goto L_0x0569
            com.bytedance.sdk.openadsdk.core.video.c.b r4 = (com.bytedance.sdk.openadsdk.core.video.c.b) r4
            r4.L()
            goto L_0x0569
        L_0x03b3:
            com.bytedance.sdk.openadsdk.f.c r4 = r2.i
            if (r4 == 0) goto L_0x0569
            org.json.JSONObject r5 = r1.d
            r4.a(r5)
            goto L_0x0569
        L_0x03be:
            com.bytedance.sdk.openadsdk.f.c r4 = r2.i
            if (r4 == 0) goto L_0x0569
            org.json.JSONObject r5 = r1.d
            r4.b(r5)
            goto L_0x0569
        L_0x03c9:
            r2.K = r3
            com.bytedance.sdk.openadsdk.core.b.d r4 = r2.z
            if (r4 == 0) goto L_0x03d6
            boolean r5 = r2.C
            r4.a(r5)
            goto L_0x0569
        L_0x03d6:
            com.bytedance.sdk.openadsdk.f.c r4 = r2.i
            if (r4 == 0) goto L_0x0569
            java.lang.ref.WeakReference<android.content.Context> r4 = r2.h
            if (r4 == 0) goto L_0x0569
            java.lang.Object r4 = r4.get()
            android.content.Context r4 = (android.content.Context) r4
            if (r4 == 0) goto L_0x0569
            com.bytedance.sdk.openadsdk.f.c r5 = r2.i
            org.json.JSONObject r6 = r1.d
            java.lang.String r7 = r2.J
            r5.a(r4, r6, r7)
            goto L_0x0569
        L_0x03f1:
            r2.w()
            java.lang.ref.WeakReference<android.content.Context> r4 = r2.h
            if (r4 == 0) goto L_0x0569
            java.lang.Object r4 = r4.get()
            r11 = r4
            android.content.Context r11 = (android.content.Context) r11
            if (r11 == 0) goto L_0x0569
            com.bytedance.sdk.openadsdk.f.c r10 = r2.i
            org.json.JSONObject r12 = r1.d
            java.lang.String r13 = r2.l
            int r14 = r2.m
            boolean r15 = r2.p
            r10.a(r11, r12, r13, r14, r15)
            goto L_0x0569
        L_0x0410:
            r2.c = r3
            com.bytedance.sdk.openadsdk.jslistener.e r4 = r2.w
            if (r4 == 0) goto L_0x0569
            r4.a()
            goto L_0x0569
        L_0x041b:
            com.bytedance.sdk.openadsdk.jslistener.d r4 = r2.x
            if (r4 == 0) goto L_0x0569
            r4.a()
            goto L_0x0569
        L_0x0424:
            android.content.Context r4 = com.bytedance.sdk.openadsdk.core.m.a()
            java.lang.String r5 = "atfjk"
            java.lang.String r5 = com.bytedance.sdk.component.f.c.d.d1667305730926dc(r5)
            java.lang.Object r4 = r4.getSystemService(r5)
            android.media.AudioManager r4 = (android.media.AudioManager) r4
            if (r4 == 0) goto L_0x0456
            int r13 = r4.getStreamVolume(r15)
            java.lang.String r4 = com.bytedance.sdk.component.f.c.a.a1667305730924dc(r9)
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "Mtqjg%phd|gn,301.1Sfp|yZyw{|yo32\u001eBWQV@HS~FF^AH\u0013"
            java.lang.String r6 = com.bytedance.sdk.component.f.c.a.a1667305730924dc(r6)
            r5.append(r6)
            r5.append(r13)
            java.lang.String r5 = r5.toString()
            com.bytedance.sdk.component.utils.l.b((java.lang.String) r4, (java.lang.String) r5)
        L_0x0456:
            if (r13 > 0) goto L_0x045a
            r4 = r3
            goto L_0x045b
        L_0x045a:
            r4 = 0
        L_0x045b:
            java.lang.String r5 = "eof`ewbXe|~n"
            java.lang.String r5 = com.bytedance.sdk.component.f.c.d.d1667305730926dc(r5)
            r8.put(r5, r4)
            goto L_0x0569
        L_0x0466:
            org.json.JSONObject r4 = r2.o()
            if (r4 == 0) goto L_0x0569
            goto L_0x056a
        L_0x046e:
            com.bytedance.sdk.openadsdk.jslistener.a r4 = r2.v
            if (r4 == 0) goto L_0x0569
            int r4 = r4.b()
            com.bytedance.sdk.openadsdk.jslistener.a r5 = r2.v
            int r5 = r5.a()
            java.lang.String r6 = "whfwl"
            java.lang.String r6 = com.bytedance.sdk.component.f.c.a.a1667305730924dc(r6)
            r8.put(r6, r4)
            java.lang.String r4 = "hdkdlq"
            java.lang.String r4 = com.bytedance.sdk.component.f.c.a.a1667305730924dc(r4)
        L_0x048b:
            r8.put(r4, r5)
            goto L_0x0569
        L_0x0490:
            java.lang.String r4 = "vhgtWqgs}z"
            java.lang.String r4 = com.bytedance.sdk.component.f.c.a.a1667305730924dc(r4)
            boolean r5 = r2.G
            goto L_0x048b
        L_0x0499:
            org.json.JSONObject r4 = r2.y
            if (r4 == 0) goto L_0x0569
            goto L_0x056a
        L_0x049f:
            org.json.JSONObject r4 = r2.t
            if (r4 == 0) goto L_0x04c5
            java.lang.String r5 = "sdvwmka"
            java.lang.String r5 = com.bytedance.sdk.component.f.c.a.a1667305730924dc(r5)
            org.json.JSONObject r6 = r2.u()
            r4.put(r5, r6)
            com.bytedance.sdk.openadsdk.core.model.n r4 = r2.q
            if (r4 == 0) goto L_0x04c5
            org.json.JSONObject r4 = r2.t
            java.lang.String r5 = "eyvfjvohf"
            java.lang.String r5 = com.bytedance.sdk.component.f.c.a.a1667305730924dc(r5)
            com.bytedance.sdk.openadsdk.core.model.n r6 = r2.q
            org.json.JSONObject r6 = r6.aB()
            r4.put(r5, r6)
        L_0x04c5:
            org.json.JSONObject r8 = r2.t
            goto L_0x0569
        L_0x04c9:
            r2.e((org.json.JSONObject) r8)
            goto L_0x0569
        L_0x04ce:
            org.json.JSONObject r4 = r1.d
            if (r4 == 0) goto L_0x0569
            java.lang.String r5 = "eyvIwjh"
            java.lang.String r5 = com.bytedance.sdk.component.f.c.a.a1667305730924dc(r5)
            org.json.JSONObject r5 = r4.getJSONObject(r5)
            if (r5 == 0) goto L_0x0569
            java.lang.String r6 = "c`vfcjt~"
            java.lang.String r6 = com.bytedance.sdk.component.f.c.a.a1667305730924dc(r6)
            boolean r6 = r5.has(r6)
            if (r6 == 0) goto L_0x0569
            java.lang.String r6 = "t`e"
            java.lang.String r6 = com.bytedance.sdk.component.f.c.a.a1667305730924dc(r6)
            boolean r6 = r5.has(r6)
            if (r6 == 0) goto L_0x0569
            java.lang.String r6 = "l``fh"
            java.lang.String r6 = com.bytedance.sdk.component.f.c.a.a1667305730924dc(r6)
            boolean r6 = r5.has(r6)
            if (r6 == 0) goto L_0x0569
            java.lang.String r6 = "c`vfcjt~"
            java.lang.String r6 = com.bytedance.sdk.component.f.c.a.a1667305730924dc(r6)
            java.lang.String r11 = r5.getString(r6)
            java.lang.String r6 = "t`e"
            java.lang.String r6 = com.bytedance.sdk.component.f.c.a.a1667305730924dc(r6)
            r5.getString(r6)
            java.lang.String r6 = "l``fh"
            java.lang.String r6 = com.bytedance.sdk.component.f.c.a.a1667305730924dc(r6)
            java.lang.String r13 = r5.getString(r6)
            java.lang.String r6 = "v`nva"
            java.lang.String r6 = com.bytedance.sdk.component.f.c.a.a1667305730924dc(r6)
            long r14 = r4.getLong(r6)
            java.lang.String r6 = "eyvUeisb"
            java.lang.String r6 = com.bytedance.sdk.component.f.c.a.a1667305730924dc(r6)
            long r16 = r4.getLong(r6)
            java.lang.String r4 = "u`]skiodq"
            java.lang.String r4 = com.bytedance.sdk.component.f.c.a.a1667305730924dc(r4)     // Catch:{ Exception -> 0x0542 }
            int r6 = r2.o     // Catch:{ Exception -> 0x0542 }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ Exception -> 0x0542 }
            r5.putOpt(r4, r6)     // Catch:{ Exception -> 0x0542 }
        L_0x0542:
            java.lang.String r4 = "cmk`o"
            java.lang.String r4 = com.bytedance.sdk.component.f.c.a.a1667305730924dc(r4)
            boolean r4 = r4.equals(r13)
            if (r4 == 0) goto L_0x0552
            org.json.JSONObject r5 = r2.q(r5)
        L_0x0552:
            r18 = r5
            int r4 = r2.m
            java.lang.String r12 = com.bytedance.sdk.openadsdk.l.y.a((int) r4)
            com.bytedance.sdk.openadsdk.core.model.n r10 = r2.q
            com.bytedance.sdk.openadsdk.c.c.a((com.bytedance.sdk.openadsdk.core.model.n) r10, (java.lang.String) r11, (java.lang.String) r12, (java.lang.String) r13, (long) r14, (long) r16, (org.json.JSONObject) r18)
            goto L_0x0569
        L_0x0560:
            r2.d((org.json.JSONObject) r8)
            goto L_0x0569
        L_0x0564:
            int r4 = r1.e
            r2.a((org.json.JSONObject) r8, (int) r4)
        L_0x0569:
            r4 = r8
        L_0x056a:
            if (r0 != r3) goto L_0x05ad
            java.lang.String r3 = r1.b
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            boolean r3 = android.text.TextUtils.isEmpty(r3)
            if (r3 != 0) goto L_0x05ad
            java.lang.String r1 = r1.b
            r2.b((java.lang.String) r1, (org.json.JSONObject) r4)
            com.bytedance.sdk.openadsdk.core.h r1 = com.bytedance.sdk.openadsdk.core.h.d()
            boolean r1 = r1.s()
            if (r1 == 0) goto L_0x05ad
            java.lang.String r1 = com.bytedance.sdk.component.f.c.d.d1667305730926dc(r9)
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "[KQA)WUWU)|n~~g`~+"
            java.lang.String r3 = com.bytedance.sdk.component.f.c.d.d1667305730926dc(r3)
            r2.append(r3)
            r2.append(r0)
            java.lang.String r0 = " ecwe8"
            java.lang.String r0 = com.bytedance.sdk.component.f.c.d.d1667305730926dc(r0)
            r2.append(r0)
            r2.append(r4)
            java.lang.String r0 = r2.toString()
            android.util.Log.d(r1, r0)
        L_0x05ad:
            return r4
        L_0x05ae:
            switch(r9) {
                case 39: goto L_0x05c2;
                case 40: goto L_0x05bf;
                case 41: goto L_0x05b4;
                default: goto L_0x05b1;
            }
        L_0x05b1:
            r9 = 11
            goto L_0x0609
        L_0x05b4:
            int r11 = r7 * r7
            int r17 = r6 * r6
            int r17 = r17 * 34
            int r11 = r11 - r17
            if (r11 != r13) goto L_0x003f
            goto L_0x05c6
        L_0x05bf:
            r9 = 11
            goto L_0x0606
        L_0x05c2:
            switch(r8) {
                case 57: goto L_0x05c6;
                case 58: goto L_0x05cd;
                case 59: goto L_0x05d8;
                default: goto L_0x05c5;
            }
        L_0x05c5:
            goto L_0x05bf
        L_0x05c6:
            r11 = 10
            int r11 = r11 + r3
            int r11 = r11 * r5
            int r11 = r11 % r12
            if (r11 == 0) goto L_0x003f
        L_0x05cd:
            r11 = 61
            int r11 = r11 * r11
            int r17 = r4 * r4
            int r17 = r17 * 34
            int r11 = r11 - r17
            if (r11 != r13) goto L_0x05f7
        L_0x05d8:
            r11 = 27
            int r17 = r11 * r11
            int r20 = r14 * r14
            int r17 = r17 + r20
            int r20 = r16 * r16
            int r3 = r17 + r20
            r17 = 27
            int r17 = r17 * 34
            r20 = 34
            int r20 = r20 * 17
            int r17 = r17 + r20
            int r11 = r11 * 17
            int r11 = r17 + r11
            if (r3 >= r11) goto L_0x0006
            r3 = 1
            goto L_0x0046
        L_0x05f7:
            r3 = 55
            int r8 = r3 * r3
            int r8 = r8 * r3
            r9 = 11
            int r11 = r9 * r9
            int r11 = r11 * r9
            int r8 = r8 + r11
            int r8 = r8 + r11
            int r3 = r3 * r9
            int r3 = r3 * r9
            int r3 = r3 * r15
        L_0x0606:
            r3 = 1
            goto L_0x003f
        L_0x0609:
            r3 = 39
            r8 = 59
            r9 = r3
            r3 = 1
            goto L_0x05ae
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.u.a(com.bytedance.sdk.openadsdk.core.u$a, int):org.json.JSONObject");
    }

    public void a(Message message) {
        if (message != null && message.what == 11 && (message.obj instanceof a)) {
            try {
                a((a) message.obj, 1);
            } catch (Exception unused) {
            }
        }
    }

    public void a(String str) {
    }

    public void a(String str, JSONObject jSONObject) {
        c(str, jSONObject);
    }

    @JProtect
    public void a(JSONObject jSONObject, com.bytedance.sdk.openadsdk.jslistener.c cVar) {
        while (true) {
            char c2 = ']';
            char c3 = ']';
            while (true) {
                switch (c2) {
                    case '\\':
                        switch (c3) {
                            case 21:
                                return;
                            case 22:
                            case 23:
                                break;
                        }
                    case ']':
                        while (true) {
                            switch (c3) {
                                case '[':
                                case ']':
                                    break;
                                case '\\':
                                    return;
                                default:
                                    c3 = '[';
                            }
                        }
                    case '^':
                        if (c3 <= 4) {
                            continue;
                        } else {
                            return;
                        }
                }
                c2 = '^';
                c3 = 'K';
            }
        }
    }

    public boolean a(Uri uri) {
        if (uri == null) {
            return false;
        }
        try {
            if (!DynamicUnlockView.DynamicUnlockView1667305730929dc("bxvf`dhdm").equals(uri.getScheme())) {
                return false;
            }
            return g.containsKey(uri.getHost());
        } catch (Exception unused) {
        }
    }

    @JavascriptInterface
    public String adInfo() {
        JSONObject jSONObject = new JSONObject();
        try {
            d(jSONObject);
        } catch (Exception unused) {
        }
        return jSONObject.toString();
    }

    @JavascriptInterface
    public String appInfo() {
        JSONObject jSONObject = new JSONObject();
        try {
            a(jSONObject, 0);
        } catch (Exception unused) {
        }
        return jSONObject.toString();
    }

    /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP_START, MTH_ENTER_BLOCK] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.bytedance.sdk.openadsdk.core.u b(int r6) {
        /*
            r5 = this;
        L_0x0000:
            r0 = 73
            switch(r0) {
                case 72: goto L_0x0013;
                case 73: goto L_0x0028;
                case 74: goto L_0x0006;
                default: goto L_0x0005;
            }
        L_0x0005:
            goto L_0x0000
        L_0x0006:
            r0 = 82
            r1 = 1
            int r2 = 82 - r1
            int r2 = r2 * r0
            int r0 = r0 * 2
            int r0 = r0 - r1
            int r2 = r2 * r0
            int r2 = r2 % 6
            goto L_0x0028
        L_0x0013:
            r0 = 29
            r1 = 45
            r2 = 20
            int r3 = r0 * r0
            int r4 = r1 * r1
            int r3 = r3 + r4
            int r4 = r2 * r2
            int r3 = r3 + r4
            r4 = 29
            int r4 = r4 * r1
            int r1 = r1 * r2
            int r4 = r4 + r1
            int r0 = r0 * r2
            int r4 = r4 + r0
        L_0x0028:
            r5.m = r6
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.u.b(int):com.bytedance.sdk.openadsdk.core.u");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0017, code lost:
        switch(r1) {
            case 91: goto L_0x001b;
            case 92: goto L_0x0000;
            case 93: goto L_0x001b;
            default: goto L_0x001a;
        };
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0020, code lost:
        r1 = '[';
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.bytedance.sdk.openadsdk.core.u b(com.bytedance.sdk.component.widget.SSWebView r3) {
        /*
            r2 = this;
        L_0x0000:
            r0 = 93
            r1 = r0
        L_0x0003:
            switch(r0) {
                case 92: goto L_0x000b;
                case 93: goto L_0x0017;
                case 94: goto L_0x0007;
                default: goto L_0x0006;
            }
        L_0x0006:
            goto L_0x0000
        L_0x0007:
            r0 = 4
            if (r1 > r0) goto L_0x000f
            goto L_0x0000
        L_0x000b:
            switch(r1) {
                case 21: goto L_0x0000;
                case 22: goto L_0x000f;
                case 23: goto L_0x001b;
                default: goto L_0x000e;
            }
        L_0x000e:
            goto L_0x0017
        L_0x000f:
            java.lang.ref.WeakReference r0 = new java.lang.ref.WeakReference
            r0.<init>(r3)
            r2.d = r0
            return r2
        L_0x0017:
            switch(r1) {
                case 91: goto L_0x001b;
                case 92: goto L_0x0000;
                case 93: goto L_0x001b;
                default: goto L_0x001a;
            }
        L_0x001a:
            goto L_0x0020
        L_0x001b:
            r0 = 94
            r1 = 75
            goto L_0x0003
        L_0x0020:
            r1 = 91
            goto L_0x0017
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.u.b(com.bytedance.sdk.component.widget.SSWebView):com.bytedance.sdk.openadsdk.core.u");
    }

    /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP_START, MTH_ENTER_BLOCK] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.bytedance.sdk.openadsdk.core.u b(boolean r6) {
        /*
            r5 = this;
        L_0x0000:
            r0 = 73
            switch(r0) {
                case 72: goto L_0x0013;
                case 73: goto L_0x0028;
                case 74: goto L_0x0006;
                default: goto L_0x0005;
            }
        L_0x0005:
            goto L_0x0000
        L_0x0006:
            r0 = 82
            r1 = 1
            int r2 = 82 - r1
            int r2 = r2 * r0
            int r0 = r0 * 2
            int r0 = r0 - r1
            int r2 = r2 * r0
            int r2 = r2 % 6
            goto L_0x0028
        L_0x0013:
            r0 = 29
            r1 = 45
            r2 = 20
            int r3 = r0 * r0
            int r4 = r1 * r1
            int r3 = r3 + r4
            int r4 = r2 * r2
            int r3 = r3 + r4
            r4 = 29
            int r4 = r4 * r1
            int r1 = r1 * r2
            int r4 = r4 + r1
            int r0 = r0 * r2
            int r4 = r4 + r0
        L_0x0028:
            r5.G = r6
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.u.b(boolean):com.bytedance.sdk.openadsdk.core.u");
    }

    public void b() {
        r rVar = this.I;
        if (rVar != null) {
            rVar.a();
            this.I = null;
        }
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x0144 A[Catch:{ Exception -> 0x01a0 }, LOOP:1: B:65:0x013f->B:67:0x0144, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x0145 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x0191 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x01ae A[SYNTHETIC] */
    public void b(android.net.Uri r15) {
        /*
            r14 = this;
            java.lang.String r0 = "ae]f|qtfWmkm"
            java.lang.String r1 = "eyvqe"
            java.lang.String r2 = "TUCm`winlFhainz"
            java.lang.String r3 = r15.getHost()     // Catch:{ Exception -> 0x01a0 }
            java.lang.String r4 = "lne\\asci|"
            java.lang.String r4 = com.bytedance.sdk.component.adexpress.widget.DynamicUnlockView.DynamicUnlockView1667305730929dc(r4)     // Catch:{ Exception -> 0x01a0 }
            boolean r4 = r4.equals(r3)     // Catch:{ Exception -> 0x01a0 }
            if (r4 != 0) goto L_0x0050
            java.lang.String r4 = "ctqwkhYb~ld"
            java.lang.String r4 = com.bytedance.sdk.component.adexpress.widget.DynamicUnlockView.DynamicUnlockView1667305730929dc(r4)     // Catch:{ Exception -> 0x01a0 }
            boolean r4 = r4.equals(r3)     // Catch:{ Exception -> 0x01a0 }
            if (r4 != 0) goto L_0x0050
            java.lang.String r4 = "lne\\asci|V|8"
            java.lang.String r4 = com.bytedance.sdk.component.adexpress.widget.DynamicUnlockView.DynamicUnlockView1667305730929dc(r4)     // Catch:{ Exception -> 0x01a0 }
            boolean r4 = r4.equals(r3)     // Catch:{ Exception -> 0x01a0 }
            if (r4 == 0) goto L_0x002f
            goto L_0x0050
        L_0x002f:
            java.lang.String r0 = "pskueqc"
            java.lang.String r0 = com.bytedance.sdk.component.adexpress.widget.DynamicUnlockView.DynamicUnlockView1667305730929dc(r0)     // Catch:{ Exception -> 0x01a0 }
            boolean r0 = r0.equals(r3)     // Catch:{ Exception -> 0x01a0 }
            if (r0 != 0) goto L_0x0047
            java.lang.String r0 = "dhqseqeoWdoxlij"
            java.lang.String r0 = com.bytedance.sdk.component.adexpress.widget.DynamicUnlockView.DynamicUnlockView1667305730929dc(r0)     // Catch:{ Exception -> 0x01a0 }
            boolean r0 = r0.equals(r3)     // Catch:{ Exception -> 0x01a0 }
            if (r0 == 0) goto L_0x0191
        L_0x0047:
            java.lang.String r15 = r15.toString()     // Catch:{ Exception -> 0x01a0 }
            r14.k((java.lang.String) r15)     // Catch:{ Exception -> 0x01a0 }
            goto L_0x0145
        L_0x0050:
            java.lang.String r3 = "c`vfcjt~"
            java.lang.String r3 = com.bytedance.sdk.component.adexpress.widget.DynamicUnlockView.DynamicUnlockView1667305730929dc(r3)     // Catch:{ Exception -> 0x01a0 }
            java.lang.String r5 = r15.getQueryParameter(r3)     // Catch:{ Exception -> 0x01a0 }
            java.lang.String r3 = "t`e"
            java.lang.String r3 = com.bytedance.sdk.component.adexpress.widget.DynamicUnlockView.DynamicUnlockView1667305730929dc(r3)     // Catch:{ Exception -> 0x01a0 }
            java.lang.String r3 = r15.getQueryParameter(r3)     // Catch:{ Exception -> 0x01a0 }
            r14.J = r3     // Catch:{ Exception -> 0x01a0 }
            java.lang.String r4 = "l``fh"
            java.lang.String r4 = com.bytedance.sdk.component.adexpress.widget.DynamicUnlockView.DynamicUnlockView1667305730929dc(r4)     // Catch:{ Exception -> 0x01a0 }
            java.lang.String r7 = r15.getQueryParameter(r4)     // Catch:{ Exception -> 0x01a0 }
            boolean r4 = r14.i((java.lang.String) r7)     // Catch:{ Exception -> 0x01a0 }
            if (r4 != 0) goto L_0x0078
            goto L_0x0179
        L_0x0078:
            r8 = 0
            java.lang.String r4 = "v`nva"
            java.lang.String r4 = com.bytedance.sdk.component.adexpress.widget.DynamicUnlockView.DynamicUnlockView1667305730929dc(r4)     // Catch:{ Exception -> 0x0089 }
            java.lang.String r4 = r15.getQueryParameter(r4)     // Catch:{ Exception -> 0x0089 }
            long r10 = java.lang.Long.parseLong(r4)     // Catch:{ Exception -> 0x0089 }
            goto L_0x008a
        L_0x0089:
            r10 = r8
        L_0x008a:
            java.lang.String r4 = "eyv\\rdjrm"
            java.lang.String r4 = com.bytedance.sdk.component.adexpress.widget.DynamicUnlockView.DynamicUnlockView1667305730929dc(r4)     // Catch:{ Exception -> 0x0098 }
            java.lang.String r4 = r15.getQueryParameter(r4)     // Catch:{ Exception -> 0x0098 }
            long r8 = java.lang.Long.parseLong(r4)     // Catch:{ Exception -> 0x0098 }
        L_0x0098:
            r12 = r8
            r4 = 0
            java.lang.String r6 = com.bytedance.sdk.component.adexpress.widget.DynamicUnlockView.DynamicUnlockView1667305730929dc(r1)     // Catch:{ Exception -> 0x01a0 }
            java.lang.String r6 = r15.getQueryParameter(r6)     // Catch:{ Exception -> 0x01a0 }
            r8 = r6
            java.lang.CharSequence r8 = (java.lang.CharSequence) r8     // Catch:{ Exception -> 0x01a0 }
            boolean r8 = android.text.TextUtils.isEmpty(r8)     // Catch:{ Exception -> 0x01a0 }
            if (r8 != 0) goto L_0x00c0
            org.json.JSONObject r8 = new org.json.JSONObject     // Catch:{ Exception -> 0x00c0 }
            r8.<init>(r6)     // Catch:{ Exception -> 0x00c0 }
            java.lang.String r4 = "u`]skiodq"
            java.lang.String r4 = com.bytedance.sdk.component.adexpress.widget.DynamicUnlockView.DynamicUnlockView1667305730929dc(r4)     // Catch:{ Exception -> 0x00bf }
            int r6 = r14.o     // Catch:{ Exception -> 0x00bf }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ Exception -> 0x00bf }
            r8.putOpt(r4, r6)     // Catch:{ Exception -> 0x00bf }
        L_0x00bf:
            r4 = r8
        L_0x00c0:
            java.lang.String r6 = "cmk`o"
            java.lang.String r6 = com.bytedance.sdk.component.adexpress.widget.DynamicUnlockView.DynamicUnlockView1667305730929dc(r6)     // Catch:{ Exception -> 0x01a0 }
            boolean r6 = r6.equals(r7)     // Catch:{ Exception -> 0x01a0 }
            if (r6 == 0) goto L_0x00d0
            org.json.JSONObject r4 = r14.q(r4)     // Catch:{ Exception -> 0x01a0 }
        L_0x00d0:
            java.lang.String r6 = "l`lgmkaXxlxmSh|}c"
            java.lang.String r6 = com.bytedance.sdk.component.adexpress.widget.DynamicUnlockView.DynamicUnlockView1667305730929dc(r6)     // Catch:{ Exception -> 0x01a0 }
            boolean r6 = r6.equals(r7)     // Catch:{ Exception -> 0x01a0 }
            if (r6 != 0) goto L_0x00f0
            java.lang.String r6 = "l`lgmkaXxlxmS~zndb"
            java.lang.String r6 = com.bytedance.sdk.component.adexpress.widget.DynamicUnlockView.DynamicUnlockView1667305730929dc(r6)     // Catch:{ Exception -> 0x01a0 }
            boolean r6 = r6.equals(r7)     // Catch:{ Exception -> 0x01a0 }
            if (r6 == 0) goto L_0x00e9
            goto L_0x00f0
        L_0x00e9:
            java.lang.String r15 = r14.j((java.lang.String) r3)     // Catch:{ Exception -> 0x01a0 }
            r6 = r15
            r3 = r4
            goto L_0x0137
        L_0x00f0:
            org.json.JSONObject r3 = new org.json.JSONObject     // Catch:{ Exception -> 0x019f }
            r3.<init>()     // Catch:{ Exception -> 0x019f }
            java.util.Set r4 = r15.getQueryParameterNames()     // Catch:{ Exception -> 0x019f }
            java.util.Iterator r4 = r4.iterator()     // Catch:{ Exception -> 0x019f }
        L_0x00fd:
            boolean r6 = r4.hasNext()     // Catch:{ Exception -> 0x019f }
            if (r6 == 0) goto L_0x0134
            java.lang.Object r6 = r4.next()     // Catch:{ Exception -> 0x019f }
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ Exception -> 0x019f }
            java.lang.String r8 = com.bytedance.sdk.component.adexpress.widget.DynamicUnlockView.DynamicUnlockView1667305730929dc(r1)     // Catch:{ Exception -> 0x00fd }
            boolean r8 = r8.equals(r6)     // Catch:{ Exception -> 0x00fd }
            if (r8 == 0) goto L_0x012c
            java.lang.String r8 = com.bytedance.sdk.component.adexpress.widget.DynamicUnlockView.DynamicUnlockView1667305730929dc(r0)     // Catch:{ Exception -> 0x00fd }
            org.json.JSONObject r9 = new org.json.JSONObject     // Catch:{ Exception -> 0x00fd }
            java.lang.String r6 = r15.getQueryParameter(r6)     // Catch:{ Exception -> 0x00fd }
            r9.<init>(r6)     // Catch:{ Exception -> 0x00fd }
            java.lang.String r6 = com.bytedance.sdk.component.adexpress.widget.DynamicUnlockView.DynamicUnlockView1667305730929dc(r0)     // Catch:{ Exception -> 0x00fd }
            java.lang.String r6 = r9.optString(r6)     // Catch:{ Exception -> 0x00fd }
            r3.put(r8, r6)     // Catch:{ Exception -> 0x00fd }
            goto L_0x00fd
        L_0x012c:
            java.lang.String r8 = r15.getQueryParameter(r6)     // Catch:{ Exception -> 0x00fd }
            r3.put(r6, r8)     // Catch:{ Exception -> 0x00fd }
            goto L_0x00fd
        L_0x0134:
            java.lang.String r15 = r14.f     // Catch:{ Exception -> 0x019f }
            r6 = r15
        L_0x0137:
            com.bytedance.sdk.openadsdk.core.model.n r4 = r14.q     // Catch:{ Exception -> 0x01a0 }
            r8 = r10
            r10 = r12
            r12 = r3
            com.bytedance.sdk.openadsdk.c.c.a((com.bytedance.sdk.openadsdk.core.model.n) r4, (java.lang.String) r5, (java.lang.String) r6, (java.lang.String) r7, (long) r8, (long) r10, (org.json.JSONObject) r12)     // Catch:{ Exception -> 0x01a0 }
        L_0x013f:
            r15 = 39
            switch(r15) {
                case 37: goto L_0x0145;
                case 38: goto L_0x0191;
                case 39: goto L_0x01ae;
                default: goto L_0x0144;
            }     // Catch:{ Exception -> 0x01a0 }
        L_0x0144:
            goto L_0x013f
        L_0x0145:
            r15 = 26
            switch(r15) {
                case 24: goto L_0x014b;
                case 25: goto L_0x0162;
                case 26: goto L_0x013f;
                default: goto L_0x014a;
            }     // Catch:{ Exception -> 0x01a0 }
        L_0x014a:
            goto L_0x0145
        L_0x014b:
            r15 = 72
            r0 = 40
            r1 = 27
            int r3 = r15 * r15
            int r3 = r3 * r15
            int r4 = r0 * r0
            int r4 = r4 * r0
            int r3 = r3 + r4
            int r4 = r1 * r1
            int r4 = r4 * r1
            int r3 = r3 + r4
            int r15 = r15 * r0
            int r15 = r15 * r1
            int r15 = r15 * 3
            if (r3 >= r15) goto L_0x017a
        L_0x0162:
            r15 = 44
            r0 = 31
            r1 = 1
            int r3 = r15 * r15
            int r4 = r0 * r0
            int r3 = r3 + r4
            int r4 = r1 * r1
            int r3 = r3 + r4
            r4 = 44
            int r4 = r4 * r0
            int r0 = r0 * r1
            int r4 = r4 + r0
            int r15 = r15 * r1
            int r4 = r4 + r15
            if (r3 >= r4) goto L_0x0179
            goto L_0x013f
        L_0x0179:
            return
        L_0x017a:
            r15 = 70
            r0 = 41
            r1 = 25
            int r3 = r15 * r15
            int r4 = r0 * r0
            int r3 = r3 + r4
            int r4 = r1 * r1
            int r3 = r3 + r4
            r4 = 70
            int r4 = r4 * r0
            int r0 = r0 * r1
            int r4 = r4 + r0
            int r15 = r15 * r1
            int r4 = r4 + r15
            if (r3 >= r4) goto L_0x019f
        L_0x0191:
            java.lang.String r15 = com.bytedance.sdk.component.adexpress.widget.DynamicUnlockView.DynamicUnlockView1667305730929dc(r2)     // Catch:{ Exception -> 0x01a0 }
            java.lang.String r0 = "h`lghwSnz3*ecy.bqeq{4fu}t{;trmk"
            java.lang.String r0 = com.bytedance.sdk.component.adexpress.widget.DynamicUnlockView.DynamicUnlockView1667305730929dc(r0)     // Catch:{ Exception -> 0x01a0 }
            com.bytedance.sdk.component.utils.l.d(r15, r0)     // Catch:{ Exception -> 0x01a0 }
            goto L_0x013f
        L_0x019f:
            return
        L_0x01a0:
            r15 = move-exception
            java.lang.String r0 = com.bytedance.sdk.component.adexpress.widget.DynamicUnlockView.DynamicUnlockView1667305730929dc(r2)
            java.lang.String r1 = "h`lgh`Sua)osoh~{y~|)4"
            java.lang.String r1 = com.bytedance.sdk.component.adexpress.widget.DynamicUnlockView.DynamicUnlockView1667305730929dc(r1)
            com.bytedance.sdk.component.utils.l.b((java.lang.String) r0, (java.lang.String) r1, (java.lang.Throwable) r15)
        L_0x01ae:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.u.b(android.net.Uri):void");
    }

    public void b(String str) {
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void b(org.json.JSONObject r9) {
        /*
            r8 = this;
            java.lang.String r0 = "l`lgmkaT|pfn"
            java.lang.String r0 = com.bytedance.sdk.component.d.c.f.f1667305730962dc(r0)
            int r0 = r9.optInt(r0)
            java.lang.String r1 = "usn"
            java.lang.String r1 = com.bytedance.sdk.component.d.c.f.f1667305730962dc(r1)
            java.lang.String r3 = r9.optString(r1)
            java.lang.String r1 = "f`nofdelW|xg"
            java.lang.String r1 = com.bytedance.sdk.component.d.c.f.f1667305730962dc(r1)
            java.lang.String r9 = r9.optString(r1)
            r1 = r3
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 == 0) goto L_0x0028
            return
        L_0x0028:
            if (r0 != 0) goto L_0x0039
            android.webkit.WebView r9 = r8.n()
            if (r9 == 0) goto L_0x0126
            android.webkit.WebView r9 = r8.n()
            r9.loadUrl(r3)
            goto L_0x0126
        L_0x0039:
            r1 = 2
            r2 = 1
            if (r0 != r2) goto L_0x00ad
            java.lang.ref.WeakReference<android.content.Context> r9 = r8.h
            if (r9 == 0) goto L_0x0126
            java.lang.Object r9 = r9.get()
            boolean r9 = r9 instanceof android.app.Activity
            if (r9 == 0) goto L_0x0126
            java.lang.ref.WeakReference<android.content.Context> r9 = r8.h
            java.lang.Object r9 = r9.get()
            android.app.Activity r9 = (android.app.Activity) r9
            android.app.Activity r9 = (android.app.Activity) r9
            com.bytedance.sdk.openadsdk.l.m.a(r9, r3)
        L_0x0056:
            r9 = 78
            r0 = 5
        L_0x0059:
            r3 = 10
            switch(r3) {
                case 8: goto L_0x005f;
                case 9: goto L_0x005f;
                case 10: goto L_0x0126;
                default: goto L_0x005e;
            }
        L_0x005e:
            goto L_0x0059
        L_0x005f:
            r3 = -1
            r4 = 62
            switch(r0) {
                case 45: goto L_0x0080;
                case 46: goto L_0x0126;
                case 47: goto L_0x0066;
                default: goto L_0x0065;
            }
        L_0x0065:
            goto L_0x00a8
        L_0x0066:
            if (r9 < r4) goto L_0x0069
            goto L_0x0072
        L_0x0069:
            r9 = 7
            int r9 = r9 * r9
            int r0 = r2 * r2
            int r0 = r0 * 34
            int r9 = r9 - r0
            if (r9 != r3) goto L_0x0126
        L_0x0072:
            r9 = 40
            int r0 = 40 - r2
            int r0 = r0 * r9
            int r9 = r9 * r1
            int r9 = r9 - r2
            int r0 = r0 * r9
            int r0 = r0 % 6
            if (r0 == 0) goto L_0x00d8
            goto L_0x0126
        L_0x0080:
            r0 = 30
            if (r9 < r0) goto L_0x0085
            goto L_0x0090
        L_0x0085:
            r0 = 75
            int r0 = r0 * r0
            r5 = 33
            int r5 = r5 * r5
            int r5 = r5 * 34
            int r0 = r0 - r5
            if (r0 != r3) goto L_0x00d8
        L_0x0090:
            r0 = 70
            int r0 = r0 + r2
            int r0 = r0 * 70
            int r0 = r0 % r1
            if (r0 == 0) goto L_0x0056
            r0 = 27
            int r5 = r4 * r4
            int r6 = r0 * r0
            int r5 = r5 + r6
            r6 = 62
            int r6 = r6 * r0
            int r6 = r6 * r1
            int r5 = r5 - r6
            if (r5 >= 0) goto L_0x0080
            goto L_0x0126
        L_0x00a8:
            r0 = 45
            r9 = 99
            goto L_0x005f
        L_0x00ad:
            if (r0 != r1) goto L_0x0100
            java.lang.ref.WeakReference<android.content.Context> r0 = r8.h
            if (r0 == 0) goto L_0x0126
            java.lang.Object r0 = r0.get()
            boolean r0 = r0 instanceof android.app.Activity
            if (r0 == 0) goto L_0x0126
            java.lang.ref.WeakReference<android.content.Context> r0 = r8.h
            java.lang.Object r0 = r0.get()
            android.app.Activity r0 = (android.app.Activity) r0
            android.app.Activity r0 = (android.app.Activity) r0
            boolean r0 = com.bytedance.sdk.openadsdk.l.m.b(r0, r3)
            if (r0 != 0) goto L_0x0126
            java.lang.ref.WeakReference<android.content.Context> r0 = r8.h
            java.lang.Object r0 = r0.get()
            android.app.Activity r0 = (android.app.Activity) r0
            android.app.Activity r0 = (android.app.Activity) r0
            com.bytedance.sdk.openadsdk.l.m.a(r0, r9)
        L_0x00d8:
            r9 = 84
            switch(r9) {
                case 84: goto L_0x0126;
                case 85: goto L_0x00de;
                case 86: goto L_0x00f5;
                default: goto L_0x00dd;
            }
        L_0x00dd:
            goto L_0x00d8
        L_0x00de:
            r9 = 18
            r0 = 15
            r3 = 28
            int r4 = r9 * r9
            int r5 = r0 * r0
            int r4 = r4 + r5
            int r5 = r3 * r3
            int r4 = r4 + r5
            r5 = 18
            int r5 = r5 * r0
            int r0 = r0 * r3
            int r5 = r5 + r0
            int r9 = r9 * r3
            int r5 = r5 + r9
            if (r4 >= r5) goto L_0x00d8
        L_0x00f5:
            r9 = 85
            int r0 = 85 - r2
            int r0 = r0 * r9
            int r9 = r9 * r1
            int r9 = r9 - r2
            int r0 = r0 * r9
            int r0 = r0 % 6
            goto L_0x0126
        L_0x0100:
            r9 = 3
            if (r0 != r9) goto L_0x0126
            java.lang.ref.WeakReference<android.content.Context> r9 = r8.h
            if (r9 == 0) goto L_0x0126
            java.lang.Object r9 = r9.get()
            boolean r9 = r9 instanceof android.app.Activity
            if (r9 == 0) goto L_0x0126
            java.lang.ref.WeakReference<android.content.Context> r9 = r8.h
            java.lang.Object r9 = r9.get()
            android.app.Activity r9 = (android.app.Activity) r9
            android.app.Activity r9 = (android.app.Activity) r9
            r2 = r9
            android.content.Context r2 = (android.content.Context) r2
            com.bytedance.sdk.openadsdk.core.model.n r4 = r8.q
            int r5 = r8.m
            java.lang.String r6 = r8.J
            r7 = 0
            com.bytedance.sdk.openadsdk.core.w.b(r2, r3, r4, r5, r6, r7)
        L_0x0126:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.u.b(org.json.JSONObject):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP_START, MTH_ENTER_BLOCK] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.bytedance.sdk.openadsdk.core.model.n c() {
        /*
            r5 = this;
        L_0x0000:
            r0 = 73
            switch(r0) {
                case 72: goto L_0x0013;
                case 73: goto L_0x0028;
                case 74: goto L_0x0006;
                default: goto L_0x0005;
            }
        L_0x0005:
            goto L_0x0000
        L_0x0006:
            r0 = 82
            r1 = 1
            int r2 = 82 - r1
            int r2 = r2 * r0
            int r0 = r0 * 2
            int r0 = r0 - r1
            int r2 = r2 * r0
            int r2 = r2 % 6
            goto L_0x0028
        L_0x0013:
            r0 = 29
            r1 = 45
            r2 = 20
            int r3 = r0 * r0
            int r4 = r1 * r1
            int r3 = r3 + r4
            int r4 = r2 * r2
            int r3 = r3 + r4
            r4 = 29
            int r4 = r4 * r1
            int r1 = r1 * r2
            int r4 = r4 + r1
            int r0 = r0 * r2
            int r4 = r4 + r0
        L_0x0028:
            com.bytedance.sdk.openadsdk.core.model.n r0 = r5.q
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.u.c():com.bytedance.sdk.openadsdk.core.model.n");
    }

    /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP_START, MTH_ENTER_BLOCK] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.bytedance.sdk.openadsdk.core.u c(java.lang.String r6) {
        /*
            r5 = this;
        L_0x0000:
            r0 = 73
            switch(r0) {
                case 72: goto L_0x0013;
                case 73: goto L_0x0028;
                case 74: goto L_0x0006;
                default: goto L_0x0005;
            }
        L_0x0005:
            goto L_0x0000
        L_0x0006:
            r0 = 82
            r1 = 1
            int r2 = 82 - r1
            int r2 = r2 * r0
            int r0 = r0 * 2
            int r0 = r0 - r1
            int r2 = r2 * r0
            int r2 = r2 % 6
            goto L_0x0028
        L_0x0013:
            r0 = 29
            r1 = 45
            r2 = 20
            int r3 = r0 * r0
            int r4 = r1 * r1
            int r3 = r3 + r4
            int r4 = r2 * r2
            int r3 = r3 + r4
            r4 = 29
            int r4 = r4 * r1
            int r1 = r1 * r2
            int r4 = r4 + r1
            int r0 = r0 * r2
            int r4 = r4 + r0
        L_0x0028:
            r5.f = r6
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.u.c(java.lang.String):com.bytedance.sdk.openadsdk.core.u");
    }

    /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP_START, MTH_ENTER_BLOCK] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.bytedance.sdk.openadsdk.core.u c(boolean r6) {
        /*
            r5 = this;
        L_0x0000:
            r0 = 73
            switch(r0) {
                case 72: goto L_0x0013;
                case 73: goto L_0x0028;
                case 74: goto L_0x0006;
                default: goto L_0x0005;
            }
        L_0x0005:
            goto L_0x0000
        L_0x0006:
            r0 = 82
            r1 = 1
            int r2 = 82 - r1
            int r2 = r2 * r0
            int r0 = r0 * 2
            int r0 = r0 - r1
            int r2 = r2 * r0
            int r2 = r2 % 6
            goto L_0x0028
        L_0x0013:
            r0 = 29
            r1 = 45
            r2 = 20
            int r3 = r0 * r0
            int r4 = r1 * r1
            int r3 = r3 + r4
            int r4 = r2 * r2
            int r3 = r3 + r4
            r4 = 29
            int r4 = r4 * r1
            int r1 = r1 * r2
            int r4 = r4 + r1
            int r0 = r0 * r2
            int r4 = r4 + r0
        L_0x0028:
            r5.C = r6
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.u.c(boolean):com.bytedance.sdk.openadsdk.core.u");
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0030, code lost:
        if (((66 * 66) - ((16 * 16) * 34)) == -1) goto L_0x0032;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0045, code lost:
        if ((((29 * 29) + (45 * 45)) + (20 * 20)) >= (((29 * 45) + (45 * 20)) + (29 * 20))) goto L_0x005b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0059, code lost:
        if ((((70 * 70) + (7 * 7)) + (4 * 4)) >= (((70 * 7) + (7 * 4)) + (70 * 4))) goto L_0x0007;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0012, code lost:
        switch(r6) {
            case 94: goto L_0x0032;
            case 95: goto L_0x0047;
            case 96: goto L_0x005b;
            default: goto L_0x0015;
        };
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0015, code lost:
        r6 = '_';
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void c(int r6) {
        /*
            r5 = this;
            com.bytedance.sdk.openadsdk.core.nativeexpress.i r0 = r5.s
            if (r0 == 0) goto L_0x006c
            r0.b(r6)
        L_0x0007:
            r6 = 12
            r0 = 96
            r1 = 4
            r2 = 20
            switch(r0) {
                case 94: goto L_0x0018;
                case 95: goto L_0x0012;
                case 96: goto L_0x006c;
                default: goto L_0x0011;
            }
        L_0x0011:
            goto L_0x0007
        L_0x0012:
            switch(r6) {
                case 94: goto L_0x0032;
                case 95: goto L_0x0047;
                case 96: goto L_0x005b;
                default: goto L_0x0015;
            }
        L_0x0015:
            r6 = 95
            goto L_0x0012
        L_0x0018:
            r6 = 81
            r0 = 1
            int r3 = 81 - r0
            int r3 = r3 * r6
            int r6 = r6 * 2
            int r6 = r6 - r0
            int r3 = r3 * r6
            int r3 = r3 % 6
            if (r3 == 0) goto L_0x006c
            r6 = 66
            int r6 = r6 * r6
            r0 = 16
            int r0 = r0 * r0
            int r0 = r0 * 34
            int r6 = r6 - r0
            r0 = -1
            if (r6 != r0) goto L_0x0047
        L_0x0032:
            r6 = 29
            r0 = 45
            int r3 = r6 * r6
            int r4 = r0 * r0
            int r3 = r3 + r4
            int r4 = r2 * r2
            int r3 = r3 + r4
            r4 = 29
            int r4 = r4 * r0
            int r0 = r0 * r2
            int r4 = r4 + r0
            int r6 = r6 * r2
            int r4 = r4 + r6
            if (r3 >= r4) goto L_0x005b
        L_0x0047:
            r6 = 70
            r0 = 7
            int r3 = r6 * r6
            int r4 = r0 * r0
            int r3 = r3 + r4
            int r4 = r1 * r1
            int r3 = r3 + r4
            r4 = 70
            int r4 = r4 * r0
            int r0 = r0 * r1
            int r4 = r4 + r0
            int r6 = r6 * r1
            int r4 = r4 + r6
            if (r3 >= r4) goto L_0x0007
        L_0x005b:
            r6 = 69
            int r0 = r6 * r6
            int r3 = r2 * r2
            int r0 = r0 + r3
            int r3 = r1 * r1
            int r0 = r0 + r3
            r3 = 69
            int r3 = r3 * r2
            int r2 = r2 * r1
            int r3 = r3 + r2
            int r6 = r6 * r1
            int r3 = r3 + r6
        L_0x006c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.u.c(int):void");
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x017d, code lost:
        if ((((36 * 36) + (18 * 18)) - ((36 * 18) * 2)) >= 0) goto L_0x01b3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x019e, code lost:
        if ((((58 * 58) + (35 * 35)) + (16 * 16)) < (((58 * 35) + (35 * 16)) + (58 * 16))) goto L_0x01a0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x01a2, code lost:
        if (8 < 68) goto L_0x01cb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x01a5, code lost:
        r3 = r1;
        r1 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x01a7, code lost:
        if (r1 == true) goto L_0x01e3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x01a9, code lost:
        if (r1 == true) goto L_0x01af;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x01ad, code lost:
        if (r1 == true) goto L_0x01b1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x01af, code lost:
        r1 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x01b1, code lost:
        r1 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x01c8, code lost:
        if ((((12 * 12) + (13 * 13)) + (20 * 20)) >= (((12 * 13) + (13 * 20)) + (12 * 20))) goto L_0x01cb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x01d7, code lost:
        if (((((17 - 1) * 17) * ((17 * 2) - 1)) % 6) == 0) goto L_0x0156;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x01df, code lost:
        r1.a((android.view.View) null, -1, (com.bytedance.sdk.component.adexpress.c) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x0156, code lost:
        continue;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:?, code lost:
        return;
     */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x01df  */
    /* JADX WARNING: Removed duplicated region for block: B:55:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void c(org.json.JSONObject r42) {
        /*
            r41 = this;
            r0 = r41
            r1 = r42
            if (r1 != 0) goto L_0x0007
            return
        L_0x0007:
            java.lang.String r2 = "TUCm`winlFhainz"
            java.lang.String r2 = com.bytedance.sdk.component.d.c.a.a1667305730971dc(r2)
            java.lang.String r3 = "TUCm`winlFhainz/xp|wxpU{qzq^jxpk"
            java.lang.String r3 = com.bytedance.sdk.component.d.c.a.a1667305730971dc(r3)
            com.bytedance.sdk.component.utils.l.b((java.lang.String) r2, (java.lang.String) r3)
            r2 = -1
            java.lang.String r4 = "aeKg"
            java.lang.String r4 = com.bytedance.sdk.component.d.c.a.a1667305730971dc(r4)     // Catch:{ Exception -> 0x01da }
            java.lang.String r4 = r1.optString(r4)     // Catch:{ Exception -> 0x01da }
            java.lang.String r5 = "asgbP|vb"
            java.lang.String r5 = com.bytedance.sdk.component.d.c.a.a1667305730971dc(r5)     // Catch:{ Exception -> 0x01da }
            r6 = 1
            int r5 = r1.optInt(r5, r6)     // Catch:{ Exception -> 0x01da }
            java.lang.String r7 = "cmk`oDtbi]s{i"
            java.lang.String r7 = com.bytedance.sdk.component.d.c.a.a1667305730971dc(r7)     // Catch:{ Exception -> 0x01da }
            java.lang.String r7 = r1.optString(r7)     // Catch:{ Exception -> 0x01da }
            java.lang.String r8 = "cmk`oLhag"
            java.lang.String r8 = com.bytedance.sdk.component.d.c.a.a1667305730971dc(r8)     // Catch:{ Exception -> 0x01da }
            org.json.JSONObject r8 = r1.optJSONObject(r8)     // Catch:{ Exception -> 0x01da }
            r9 = 0
            if (r8 == 0) goto L_0x00c7
            java.lang.String r11 = "dnum[}"
            java.lang.String r11 = com.bytedance.sdk.component.d.c.a.a1667305730971dc(r11)     // Catch:{ Exception -> 0x01da }
            double r11 = r8.optDouble(r11, r9)     // Catch:{ Exception -> 0x01da }
            java.lang.String r13 = "dnum[|"
            java.lang.String r13 = com.bytedance.sdk.component.d.c.a.a1667305730971dc(r13)     // Catch:{ Exception -> 0x01da }
            double r13 = r8.optDouble(r13, r9)     // Catch:{ Exception -> 0x01da }
            java.lang.String r15 = "uq]{"
            java.lang.String r15 = com.bytedance.sdk.component.d.c.a.a1667305730971dc(r15)     // Catch:{ Exception -> 0x01da }
            double r15 = r8.optDouble(r15, r9)     // Catch:{ Exception -> 0x01da }
            java.lang.String r17 = "uq]z"
            java.lang.String r6 = com.bytedance.sdk.component.d.c.a.a1667305730971dc(r17)     // Catch:{ Exception -> 0x01da }
            double r18 = r8.optDouble(r6, r9)     // Catch:{ Exception -> 0x01da }
            java.lang.String r6 = "dnum[qojm"
            java.lang.String r6 = com.bytedance.sdk.component.d.c.a.a1667305730971dc(r6)     // Catch:{ Exception -> 0x01da }
            double r20 = r8.optDouble(r6, r9)     // Catch:{ Exception -> 0x01da }
            java.lang.String r6 = "uq]wmhc"
            java.lang.String r6 = com.bytedance.sdk.component.d.c.a.a1667305730971dc(r6)     // Catch:{ Exception -> 0x01da }
            double r22 = r8.optDouble(r6, r9)     // Catch:{ Exception -> 0x01da }
            java.lang.String r6 = "btvwkkY"
            java.lang.String r6 = com.bytedance.sdk.component.d.c.a.a1667305730971dc(r6)     // Catch:{ Exception -> 0x01da }
            double r24 = r8.optDouble(r6, r9)     // Catch:{ Exception -> 0x01da }
            java.lang.String r6 = "btvwkkY~"
            java.lang.String r6 = com.bytedance.sdk.component.d.c.a.a1667305730971dc(r6)     // Catch:{ Exception -> 0x01da }
            double r26 = r8.optDouble(r6, r9)     // Catch:{ Exception -> 0x01da }
            java.lang.String r6 = "btvwkkYpam~c"
            java.lang.String r6 = com.bytedance.sdk.component.d.c.a.a1667305730971dc(r6)     // Catch:{ Exception -> 0x01da }
            double r28 = r8.optDouble(r6, r9)     // Catch:{ Exception -> 0x01da }
            java.lang.String r6 = "btvwkkYom`mcx"
            java.lang.String r6 = com.bytedance.sdk.component.d.c.a.a1667305730971dc(r6)     // Catch:{ Exception -> 0x01da }
            double r9 = r8.optDouble(r6, r9)     // Catch:{ Exception -> 0x01da }
            java.lang.String r6 = "rdawMk`h"
            java.lang.String r6 = com.bytedance.sdk.component.d.c.a.a1667305730971dc(r6)     // Catch:{ Exception -> 0x01da }
            org.json.JSONObject r6 = r8.optJSONObject(r6)     // Catch:{ Exception -> 0x01da }
            r8 = r4
            r40 = r6
            r38 = r9
            r9 = r11
            r11 = r15
            r3 = r18
            r30 = r22
            r32 = r24
            r34 = r26
            r36 = r28
            r15 = r7
            r6 = r20
            goto L_0x00d9
        L_0x00c7:
            r8 = r4
            r15 = r7
            r3 = r9
            r6 = r3
            r11 = r6
            r13 = r11
            r30 = r13
            r32 = r30
            r34 = r32
            r36 = r34
            r38 = r36
            r40 = 0
        L_0x00d9:
            java.lang.String r17 = "cmk`oDtbiJkija}i"
            r18 = r15
            java.lang.String r15 = com.bytedance.sdk.component.d.c.a.a1667305730971dc(r17)     // Catch:{ Exception -> 0x01da }
            int r1 = r1.optInt(r15, r2)     // Catch:{ Exception -> 0x01da }
            com.bytedance.sdk.openadsdk.core.model.j$a r15 = new com.bytedance.sdk.openadsdk.core.model.j$a     // Catch:{ Exception -> 0x01da }
            r15.<init>()     // Catch:{ Exception -> 0x01da }
            float r9 = (float) r9     // Catch:{ Exception -> 0x01da }
            com.bytedance.sdk.openadsdk.core.model.j$a r9 = r15.d((float) r9)     // Catch:{ Exception -> 0x01da }
            float r10 = (float) r13     // Catch:{ Exception -> 0x01da }
            com.bytedance.sdk.openadsdk.core.model.j$a r9 = r9.c((float) r10)     // Catch:{ Exception -> 0x01da }
            float r10 = (float) r11     // Catch:{ Exception -> 0x01da }
            com.bytedance.sdk.openadsdk.core.model.j$a r9 = r9.b((float) r10)     // Catch:{ Exception -> 0x01da }
            float r3 = (float) r3     // Catch:{ Exception -> 0x01da }
            com.bytedance.sdk.openadsdk.core.model.j$a r3 = r9.a((float) r3)     // Catch:{ Exception -> 0x01da }
            long r6 = (long) r6     // Catch:{ Exception -> 0x01da }
            com.bytedance.sdk.openadsdk.core.model.j$a r3 = r3.b((long) r6)     // Catch:{ Exception -> 0x01da }
            r9 = r30
            long r6 = (long) r9     // Catch:{ Exception -> 0x01da }
            com.bytedance.sdk.openadsdk.core.model.j$a r3 = r3.a((long) r6)     // Catch:{ Exception -> 0x01da }
            r9 = r32
            int r4 = (int) r9     // Catch:{ Exception -> 0x01da }
            com.bytedance.sdk.openadsdk.core.model.j$a r3 = r3.c((int) r4)     // Catch:{ Exception -> 0x01da }
            r9 = r34
            int r4 = (int) r9     // Catch:{ Exception -> 0x01da }
            com.bytedance.sdk.openadsdk.core.model.j$a r3 = r3.d((int) r4)     // Catch:{ Exception -> 0x01da }
            r9 = r36
            int r4 = (int) r9     // Catch:{ Exception -> 0x01da }
            com.bytedance.sdk.openadsdk.core.model.j$a r3 = r3.e((int) r4)     // Catch:{ Exception -> 0x01da }
            r9 = r38
            int r4 = (int) r9     // Catch:{ Exception -> 0x01da }
            com.bytedance.sdk.openadsdk.core.model.j$a r3 = r3.f((int) r4)     // Catch:{ Exception -> 0x01da }
            r4 = r18
            com.bytedance.sdk.openadsdk.core.model.j$a r3 = r3.a((java.lang.String) r4)     // Catch:{ Exception -> 0x01da }
            r4 = 0
            com.bytedance.sdk.openadsdk.core.model.j$a r3 = r3.a((android.util.SparseArray<com.bytedance.sdk.openadsdk.core.b.c.a>) r4)     // Catch:{ Exception -> 0x01da }
            r4 = 1
            com.bytedance.sdk.openadsdk.core.model.j$a r3 = r3.a((boolean) r4)     // Catch:{ Exception -> 0x01da }
            com.bytedance.sdk.openadsdk.core.model.j$a r3 = r3.b((int) r5)     // Catch:{ Exception -> 0x01da }
            r4 = r40
            com.bytedance.sdk.openadsdk.core.model.j$a r3 = r3.a((org.json.JSONObject) r4)     // Catch:{ Exception -> 0x01da }
            com.bytedance.sdk.openadsdk.core.model.j$a r1 = r3.a((int) r1)     // Catch:{ Exception -> 0x01da }
            com.bytedance.sdk.openadsdk.core.model.j r1 = r1.a()     // Catch:{ Exception -> 0x01da }
            com.bytedance.sdk.component.adexpress.b.j r3 = r0.r     // Catch:{ Exception -> 0x01da }
            if (r3 == 0) goto L_0x0152
            com.bytedance.sdk.component.adexpress.b.j r3 = r0.r     // Catch:{ Exception -> 0x01da }
            r4 = 0
            r3.a(r4, r5, r1)     // Catch:{ Exception -> 0x01da }
        L_0x0152:
            r0.a(r8, r5, r1)     // Catch:{ Exception -> 0x01da }
            r1 = r0
        L_0x0156:
            r3 = 81
            r4 = 29
            switch(r4) {
                case 27: goto L_0x015f;
                case 28: goto L_0x0170;
                case 29: goto L_0x017f;
                default: goto L_0x015d;
            }
        L_0x015d:
            r4 = 1
            goto L_0x0156
        L_0x015f:
            r4 = 40
            r5 = 24
            int r4 = r4 * r4
            int r7 = r4 * 40
            int r7 = r7 + r7
            int r8 = r5 * r5
            int r8 = r8 * r5
            int r7 = r7 + r8
            int r4 = r4 * r5
            int r4 = r4 * 3
            if (r7 >= r4) goto L_0x015f
        L_0x0170:
            r4 = 36
            r5 = 18
            int r7 = r4 * r4
            int r8 = r5 * r5
            int r7 = r7 + r8
            int r4 = r4 * r5
            int r4 = r4 * 2
            int r7 = r7 - r4
            if (r7 >= 0) goto L_0x01b3
        L_0x017f:
            r4 = 7
            r5 = 8
            switch(r3) {
                case 79: goto L_0x0189;
                case 80: goto L_0x01a0;
                case 81: goto L_0x0186;
                default: goto L_0x0185;
            }
        L_0x0185:
            goto L_0x0189
        L_0x0186:
            r3 = r1
            r1 = r5
            goto L_0x01a7
        L_0x0189:
            r3 = 58
            r7 = 35
            r8 = 16
            int r9 = r3 * r3
            int r10 = r7 * r7
            int r9 = r9 + r10
            int r10 = r8 * r8
            int r9 = r9 + r10
            r10 = 58
            int r10 = r10 * r7
            int r7 = r7 * r8
            int r10 = r10 + r7
            int r3 = r3 * r8
            int r10 = r10 + r3
            if (r9 >= r10) goto L_0x01a5
        L_0x01a0:
            r3 = 68
            if (r5 < r3) goto L_0x01cb
            goto L_0x01b3
        L_0x01a5:
            r3 = r1
            r1 = r4
        L_0x01a7:
            if (r1 == r4) goto L_0x01e3
            if (r1 == r5) goto L_0x01af
            r7 = 9
            if (r1 == r7) goto L_0x01b1
        L_0x01af:
            r1 = r3
            goto L_0x01a5
        L_0x01b1:
            r1 = r3
            goto L_0x0156
        L_0x01b3:
            r3 = 12
            r4 = 13
            r5 = 20
            int r7 = r3 * r3
            int r8 = r4 * r4
            int r7 = r7 + r8
            int r8 = r5 * r5
            int r7 = r7 + r8
            r8 = 12
            int r8 = r8 * r4
            int r4 = r4 * r5
            int r8 = r8 + r4
            int r3 = r3 * r5
            int r8 = r8 + r3
            if (r7 >= r8) goto L_0x01cb
            goto L_0x01e3
        L_0x01cb:
            r3 = 17
            r4 = 1
            int r5 = 17 - r4
            int r5 = r5 * r3
            int r3 = r3 * 2
            int r3 = r3 - r4
            int r5 = r5 * r3
            int r5 = r5 % 6
            if (r5 == 0) goto L_0x0156
            goto L_0x01b3
        L_0x01da:
            r1 = r0
        L_0x01db:
            com.bytedance.sdk.component.adexpress.b.j r1 = r1.r
            if (r1 == 0) goto L_0x01e3
            r3 = 0
            r1.a(r3, r2, r3)
        L_0x01e3:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.u.c(org.json.JSONObject):void");
    }

    @JavascriptInterface
    public void changeVideoState(String str) {
        try {
            final JSONObject jSONObject = new JSONObject(str);
            w.a((Runnable) new Runnable() {
                /* JADX WARNING: Code restructure failed: missing block: B:7:0x002a, code lost:
                    if (((((85 - 1) * 85) * ((85 * 2) - 1)) % 6) != 0) goto L_0x002c;
                 */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public void run() {
                    /*
                        r7 = this;
                        com.bytedance.sdk.openadsdk.core.u r0 = com.bytedance.sdk.openadsdk.core.u.this
                        org.json.JSONObject r1 = r0
                        r0.i((org.json.JSONObject) r1)
                    L_0x0007:
                        r0 = -55
                        r1 = 73
                        r2 = 85
                        r3 = 1
                        switch(r1) {
                            case 72: goto L_0x0044;
                            case 73: goto L_0x0044;
                            case 74: goto L_0x0012;
                            default: goto L_0x0011;
                        }
                    L_0x0011:
                        goto L_0x0007
                    L_0x0012:
                        switch(r0) {
                            case 39: goto L_0x0016;
                            case 40: goto L_0x001f;
                            case 41: goto L_0x002c;
                            default: goto L_0x0015;
                        }
                    L_0x0015:
                        goto L_0x0070
                    L_0x0016:
                        r0 = 94
                        int r0 = r0 + r3
                        int r0 = r0 * 94
                        int r0 = r0 % 2
                        if (r0 == 0) goto L_0x0007
                    L_0x001f:
                        int r0 = 85 - r3
                        int r0 = r0 * r2
                        r1 = 85
                        int r1 = r1 * 2
                        int r1 = r1 - r3
                        int r0 = r0 * r1
                        int r0 = r0 % 6
                        if (r0 == 0) goto L_0x0044
                    L_0x002c:
                        r0 = 26
                        r1 = 9
                        r4 = 15
                        int r5 = r0 * r0
                        int r5 = r5 * r0
                        int r6 = r1 * r1
                        int r6 = r6 * r1
                        int r5 = r5 + r6
                        int r6 = r4 * r4
                        int r6 = r6 * r4
                        int r5 = r5 + r6
                        int r0 = r0 * r1
                        int r0 = r0 * r4
                        int r0 = r0 * 3
                        if (r5 >= r0) goto L_0x0044
                        goto L_0x0070
                    L_0x0044:
                        r0 = 91
                        switch(r0) {
                            case 91: goto L_0x0070;
                            case 92: goto L_0x004a;
                            case 93: goto L_0x0055;
                            default: goto L_0x0049;
                        }
                    L_0x0049:
                        goto L_0x0044
                    L_0x004a:
                        int r0 = r2 * r2
                        r1 = 16
                        int r1 = r1 * r1
                        int r1 = r1 * 34
                        int r0 = r0 - r1
                        r1 = -1
                        if (r0 != r1) goto L_0x0044
                    L_0x0055:
                        r0 = 30
                        int r1 = 30 - r3
                        int r1 = r1 * r0
                        int r0 = r0 * 2
                        int r0 = r0 - r3
                        int r1 = r1 * r0
                        int r1 = r1 % 6
                        if (r1 == 0) goto L_0x0007
                        r0 = 95
                        r1 = 10
                        int r4 = r0 * r0
                        int r5 = r1 * r1
                        int r4 = r4 + r5
                        int r0 = r0 * r1
                        int r0 = r0 * 2
                        int r4 = r4 - r0
                        goto L_0x0044
                    L_0x0070:
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.u.AnonymousClass3.run():void");
                }
            });
        } catch (Exception unused) {
        }
    }

    @JavascriptInterface
    public void clickEvent(String str) {
        try {
            final JSONObject jSONObject = new JSONObject(str);
            w.a((Runnable) new Runnable() {
                /* JADX WARNING: Code restructure failed: missing block: B:7:0x002a, code lost:
                    if (((((85 - 1) * 85) * ((85 * 2) - 1)) % 6) != 0) goto L_0x002c;
                 */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public void run() {
                    /*
                        r7 = this;
                        com.bytedance.sdk.openadsdk.core.u r0 = com.bytedance.sdk.openadsdk.core.u.this
                        org.json.JSONObject r1 = r0
                        r0.c((org.json.JSONObject) r1)
                    L_0x0007:
                        r0 = -55
                        r1 = 73
                        r2 = 85
                        r3 = 1
                        switch(r1) {
                            case 72: goto L_0x0044;
                            case 73: goto L_0x0044;
                            case 74: goto L_0x0012;
                            default: goto L_0x0011;
                        }
                    L_0x0011:
                        goto L_0x0007
                    L_0x0012:
                        switch(r0) {
                            case 39: goto L_0x0016;
                            case 40: goto L_0x001f;
                            case 41: goto L_0x002c;
                            default: goto L_0x0015;
                        }
                    L_0x0015:
                        goto L_0x0070
                    L_0x0016:
                        r0 = 94
                        int r0 = r0 + r3
                        int r0 = r0 * 94
                        int r0 = r0 % 2
                        if (r0 == 0) goto L_0x0007
                    L_0x001f:
                        int r0 = 85 - r3
                        int r0 = r0 * r2
                        r1 = 85
                        int r1 = r1 * 2
                        int r1 = r1 - r3
                        int r0 = r0 * r1
                        int r0 = r0 % 6
                        if (r0 == 0) goto L_0x0044
                    L_0x002c:
                        r0 = 26
                        r1 = 9
                        r4 = 15
                        int r5 = r0 * r0
                        int r5 = r5 * r0
                        int r6 = r1 * r1
                        int r6 = r6 * r1
                        int r5 = r5 + r6
                        int r6 = r4 * r4
                        int r6 = r6 * r4
                        int r5 = r5 + r6
                        int r0 = r0 * r1
                        int r0 = r0 * r4
                        int r0 = r0 * 3
                        if (r5 >= r0) goto L_0x0044
                        goto L_0x0070
                    L_0x0044:
                        r0 = 91
                        switch(r0) {
                            case 91: goto L_0x0070;
                            case 92: goto L_0x004a;
                            case 93: goto L_0x0055;
                            default: goto L_0x0049;
                        }
                    L_0x0049:
                        goto L_0x0044
                    L_0x004a:
                        int r0 = r2 * r2
                        r1 = 16
                        int r1 = r1 * r1
                        int r1 = r1 * 34
                        int r0 = r0 - r1
                        r1 = -1
                        if (r0 != r1) goto L_0x0044
                    L_0x0055:
                        r0 = 30
                        int r1 = 30 - r3
                        int r1 = r1 * r0
                        int r0 = r0 * 2
                        int r0 = r0 - r3
                        int r1 = r1 * r0
                        int r1 = r1 % 6
                        if (r1 == 0) goto L_0x0007
                        r0 = 95
                        r1 = 10
                        int r4 = r0 * r0
                        int r5 = r1 * r1
                        int r4 = r4 + r5
                        int r0 = r0 * r1
                        int r0 = r0 * 2
                        int r4 = r4 - r0
                        goto L_0x0044
                    L_0x0070:
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.u.AnonymousClass4.run():void");
                }
            });
        } catch (Exception unused) {
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP_START, MTH_ENTER_BLOCK] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.bytedance.sdk.openadsdk.core.u d(java.lang.String r6) {
        /*
            r5 = this;
        L_0x0000:
            r0 = 73
            switch(r0) {
                case 72: goto L_0x0013;
                case 73: goto L_0x0028;
                case 74: goto L_0x0006;
                default: goto L_0x0005;
            }
        L_0x0005:
            goto L_0x0000
        L_0x0006:
            r0 = 82
            r1 = 1
            int r2 = 82 - r1
            int r2 = r2 * r0
            int r0 = r0 * 2
            int r0 = r0 - r1
            int r2 = r2 * r0
            int r2 = r2 % 6
            goto L_0x0028
        L_0x0013:
            r0 = 29
            r1 = 45
            r2 = 20
            int r3 = r0 * r0
            int r4 = r1 * r1
            int r3 = r3 + r4
            int r4 = r2 * r2
            int r3 = r3 + r4
            r4 = 29
            int r4 = r4 * r1
            int r1 = r1 * r2
            int r4 = r4 + r1
            int r0 = r0 * r2
            int r4 = r4 + r0
        L_0x0028:
            r5.j = r6
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.u.d(java.lang.String):com.bytedance.sdk.openadsdk.core.u");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x004f, code lost:
        switch(93) {
            case 92: goto L_0x0002;
            case 93: goto L_0x0053;
            case 94: goto L_0x0081;
            default: goto L_0x0052;
        };
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0053, code lost:
        switch(52) {
            case 52: goto L_0x008c;
            case 53: goto L_0x0057;
            case 54: goto L_0x0064;
            default: goto L_0x0056;
        };
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0062, code lost:
        if ((((85 * 85) + (32 * 32)) - ((85 * 32) * 2)) >= 0) goto L_0x0002;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0064, code lost:
        r3 = 0 * 0;
        r7 = 80 * 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0070, code lost:
        if ((((80 * 80) + r3) + r3) >= ((r3 + r7) + r7)) goto L_0x0073;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x007e, code lost:
        if (((((82 - 1) * 82) * ((82 * 2) - 1)) % 6) == 0) goto L_0x001e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0088, code lost:
        if (((85 * 85) - ((16 * 16) * 34)) != -1) goto L_0x001e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0002, code lost:
        continue;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0002, code lost:
        continue;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0009, code lost:
        r3 = ((29 * 29) + (45 * 45)) + (20 * 20);
        r4 = ((29 * 45) + (45 * 20)) + (29 * 20);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0022, code lost:
        switch(61) {
            case 59: goto L_0x0026;
            case 60: goto L_0x003d;
            case 61: goto L_0x0049;
            default: goto L_0x0025;
        };
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x003b, code lost:
        if ((((49 * 49) + (34 * 34)) + (18 * 18)) >= (((49 * 34) + (34 * 18)) + (49 * 18))) goto L_0x008c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0047, code lost:
        if ((((40 * 40) + (2 * 2)) - ((40 * 2) * 2)) >= 0) goto L_0x008c;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void d(boolean r7) {
        /*
            r6 = this;
            r6.c = r7
        L_0x0002:
            r7 = 73
            r0 = 2
            switch(r7) {
                case 72: goto L_0x0009;
                case 73: goto L_0x001e;
                case 74: goto L_0x0073;
                default: goto L_0x0008;
            }
        L_0x0008:
            goto L_0x0002
        L_0x0009:
            r7 = 29
            r1 = 45
            r2 = 20
            int r3 = r7 * r7
            int r4 = r1 * r1
            int r3 = r3 + r4
            int r4 = r2 * r2
            int r3 = r3 + r4
            r4 = 29
            int r4 = r4 * r1
            int r1 = r1 * r2
            int r4 = r4 + r1
            int r7 = r7 * r2
            int r4 = r4 + r7
        L_0x001e:
            r7 = 61
            r1 = 34
            switch(r7) {
                case 59: goto L_0x0026;
                case 60: goto L_0x003d;
                case 61: goto L_0x0049;
                default: goto L_0x0025;
            }
        L_0x0025:
            goto L_0x001e
        L_0x0026:
            r7 = 49
            r2 = 18
            int r3 = r7 * r7
            int r4 = r1 * r1
            int r3 = r3 + r4
            int r4 = r2 * r2
            int r3 = r3 + r4
            r4 = 49
            int r4 = r4 * r1
            r5 = 34
            int r5 = r5 * r2
            int r4 = r4 + r5
            int r7 = r7 * r2
            int r4 = r4 + r7
            if (r3 >= r4) goto L_0x008c
        L_0x003d:
            r7 = 40
            int r2 = r7 * r7
            int r3 = r0 * r0
            int r2 = r2 + r3
            int r7 = r7 * r0
            int r7 = r7 * r0
            int r2 = r2 - r7
            if (r2 >= 0) goto L_0x008c
        L_0x0049:
            r7 = 93
            r2 = 52
            r3 = 85
            switch(r7) {
                case 92: goto L_0x0002;
                case 93: goto L_0x0053;
                case 94: goto L_0x0081;
                default: goto L_0x0052;
            }
        L_0x0052:
            goto L_0x0049
        L_0x0053:
            switch(r2) {
                case 52: goto L_0x008c;
                case 53: goto L_0x0057;
                case 54: goto L_0x0064;
                default: goto L_0x0056;
            }
        L_0x0056:
            goto L_0x0081
        L_0x0057:
            r7 = 32
            int r3 = r3 * r3
            int r1 = r7 * r7
            int r3 = r3 + r1
            r1 = 85
            int r1 = r1 * r7
            int r1 = r1 * r0
            int r3 = r3 - r1
            if (r3 >= 0) goto L_0x0002
        L_0x0064:
            r7 = 80
            r1 = 0
            int r2 = r7 * r7
            int r3 = r1 * r1
            int r2 = r2 + r3
            int r2 = r2 + r3
            int r7 = r7 * r1
            int r3 = r3 + r7
            int r3 = r3 + r7
            if (r2 >= r3) goto L_0x0073
            goto L_0x001e
        L_0x0073:
            r7 = 82
            r1 = 1
            int r2 = 82 - r1
            int r2 = r2 * r7
            int r7 = r7 * r0
            int r7 = r7 - r1
            int r2 = r2 * r7
            int r2 = r2 % 6
            if (r2 == 0) goto L_0x001e
            goto L_0x008c
        L_0x0081:
            int r3 = r3 * r3
            r7 = 16
            int r7 = r7 * r7
            int r7 = r7 * r1
            int r3 = r3 - r7
            r7 = -1
            if (r3 != r7) goto L_0x001e
            goto L_0x0009
        L_0x008c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.u.d(boolean):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x002b, code lost:
        if (((((0 - 1) * 0) * ((0 * 2) - 1)) % 6) == 0) goto L_0x0047;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0038, code lost:
        if (((((18 - 1) * 18) * ((18 * 2) - 1)) % 6) == 0) goto L_0x0045;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0042, code lost:
        if (((99 * 99) - ((18 * 18) * 34)) != -1) goto L_0x0045;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0045, code lost:
        if (r0 != false) goto L_0x0047;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0047, code lost:
        r0 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0049, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x004a, code lost:
        r3 = 'I';
        r4 = '`';
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001d, code lost:
        switch(1) {
            case 60: goto L_0x0021;
            case 61: goto L_0x002d;
            case 62: goto L_0x003a;
            default: goto L_0x0020;
        };
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean d() {
        /*
            r6 = this;
            com.bytedance.sdk.openadsdk.core.model.n r0 = r6.q
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L_0x000b
            boolean r0 = r0.o()
            goto L_0x0045
        L_0x000b:
            r0 = r1
        L_0x000c:
            r3 = 74
            r4 = 55
        L_0x0010:
            switch(r3) {
                case 72: goto L_0x000c;
                case 73: goto L_0x0014;
                case 74: goto L_0x0017;
                default: goto L_0x0013;
            }
        L_0x0013:
            goto L_0x004f
        L_0x0014:
            switch(r4) {
                case 94: goto L_0x004a;
                case 95: goto L_0x001b;
                case 96: goto L_0x000c;
                default: goto L_0x0017;
            }
        L_0x0017:
            switch(r4) {
                case 55: goto L_0x0049;
                case 56: goto L_0x0045;
                case 57: goto L_0x001b;
                default: goto L_0x001a;
            }
        L_0x001a:
            goto L_0x004a
        L_0x001b:
            r3 = 18
            switch(r2) {
                case 60: goto L_0x0021;
                case 61: goto L_0x002d;
                case 62: goto L_0x003a;
                default: goto L_0x0020;
            }
        L_0x0020:
            goto L_0x000c
        L_0x0021:
            int r4 = 0 - r2
            int r4 = r4 * r1
            r5 = 0
            int r5 = r5 * 2
            int r5 = r5 - r2
            int r4 = r4 * r5
            int r4 = r4 % 6
            if (r4 == 0) goto L_0x0047
        L_0x002d:
            int r4 = 18 - r2
            int r4 = r4 * r3
            r5 = 18
            int r5 = r5 * 2
            int r5 = r5 - r2
            int r4 = r4 * r5
            int r4 = r4 % 6
            if (r4 == 0) goto L_0x0045
        L_0x003a:
            r4 = 99
            int r4 = r4 * r4
            int r3 = r3 * r3
            int r3 = r3 * 34
            int r4 = r4 - r3
            r3 = -1
            if (r4 != r3) goto L_0x0045
            goto L_0x0049
        L_0x0045:
            if (r0 == 0) goto L_0x000b
        L_0x0047:
            r0 = r2
            goto L_0x004a
        L_0x0049:
            return r0
        L_0x004a:
            r3 = 73
            r4 = 96
            goto L_0x0010
        L_0x004f:
            r3 = 72
            goto L_0x0010
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.u.d():boolean");
    }

    @JavascriptInterface
    public void dynamicTrack(String str) {
        try {
            m(new JSONObject(str));
        } catch (Exception unused) {
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP_START, MTH_ENTER_BLOCK] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.bytedance.sdk.openadsdk.core.u e(java.lang.String r6) {
        /*
            r5 = this;
        L_0x0000:
            r0 = 73
            switch(r0) {
                case 72: goto L_0x0013;
                case 73: goto L_0x0028;
                case 74: goto L_0x0006;
                default: goto L_0x0005;
            }
        L_0x0005:
            goto L_0x0000
        L_0x0006:
            r0 = 82
            r1 = 1
            int r2 = 82 - r1
            int r2 = r2 * r0
            int r0 = r0 * 2
            int r0 = r0 - r1
            int r2 = r2 * r0
            int r2 = r2 % 6
            goto L_0x0028
        L_0x0013:
            r0 = 29
            r1 = 45
            r2 = 20
            int r3 = r0 * r0
            int r4 = r1 * r1
            int r3 = r3 + r4
            int r4 = r2 * r2
            int r3 = r3 + r4
            r4 = 29
            int r4 = r4 * r1
            int r1 = r1 * r2
            int r4 = r4 + r1
            int r0 = r0 * r2
            int r4 = r4 + r0
        L_0x0028:
            r5.l = r6
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.u.e(java.lang.String):com.bytedance.sdk.openadsdk.core.u");
    }

    public boolean e() {
        boolean z2 = this.c;
        while (true) {
            char c2 = ']';
            char c3 = ']';
            while (true) {
                switch (c2) {
                    case '\\':
                        switch (c3) {
                            case 21:
                                break;
                            case 22:
                            case 23:
                                break;
                        }
                    case ']':
                        break;
                    case '^':
                        if (c3 > 4) {
                            break;
                        } else {
                            continue;
                        }
                }
                while (true) {
                    switch (c3) {
                        case '[':
                        case ']':
                            break;
                        case '\\':
                            break;
                        default:
                            c3 = '[';
                    }
                }
                c2 = '^';
                c3 = 'K';
            }
        }
        return z2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP_START, MTH_ENTER_BLOCK] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.bytedance.sdk.openadsdk.core.u f(java.lang.String r6) {
        /*
            r5 = this;
        L_0x0000:
            r0 = 73
            switch(r0) {
                case 72: goto L_0x0013;
                case 73: goto L_0x0028;
                case 74: goto L_0x0006;
                default: goto L_0x0005;
            }
        L_0x0005:
            goto L_0x0000
        L_0x0006:
            r0 = 82
            r1 = 1
            int r2 = 82 - r1
            int r2 = r2 * r0
            int r0 = r0 * 2
            int r0 = r0 - r1
            int r2 = r2 * r0
            int r2 = r2 % 6
            goto L_0x0028
        L_0x0013:
            r0 = 29
            r1 = 45
            r2 = 20
            int r3 = r0 * r0
            int r4 = r1 * r1
            int r3 = r3 + r4
            int r4 = r2 * r2
            int r3 = r3 + r4
            r4 = 29
            int r4 = r4 * r1
            int r1 = r1 * r2
            int r4 = r4 + r1
            int r0 = r0 * r2
            int r4 = r4 + r0
        L_0x0028:
            r5.n = r6
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.u.f(java.lang.String):com.bytedance.sdk.openadsdk.core.u");
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0041  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0078 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0078 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0070 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0037 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x004e A[SYNTHETIC] */
    public void f() {
        /*
            r7 = this;
            java.lang.ref.WeakReference<android.content.Context> r0 = r7.h
            if (r0 == 0) goto L_0x0078
            java.lang.Object r0 = r0.get()
            boolean r0 = r0 instanceof android.app.Activity
            if (r0 == 0) goto L_0x0078
            java.lang.ref.WeakReference<android.content.Context> r0 = r7.h
            java.lang.Object r0 = r0.get()
            android.app.Activity r0 = (android.app.Activity) r0
            android.app.Activity r0 = (android.app.Activity) r0
            boolean r0 = com.bytedance.sdk.openadsdk.l.m.a(r0)
            if (r0 == 0) goto L_0x0078
            java.lang.ref.WeakReference<android.content.Context> r0 = r7.h
            java.lang.Object r0 = r0.get()
            android.app.Activity r0 = (android.app.Activity) r0
            android.app.Activity r0 = (android.app.Activity) r0
            r0.finish()
        L_0x0029:
            r0 = 70
            r1 = -1
            r2 = 1
            switch(r0) {
                case 70: goto L_0x0031;
                case 71: goto L_0x0031;
                case 72: goto L_0x0066;
                default: goto L_0x0030;
            }
        L_0x0030:
            goto L_0x0029
        L_0x0031:
            r0 = 95
            switch(r0) {
                case 94: goto L_0x004e;
                case 95: goto L_0x0078;
                case 96: goto L_0x0037;
                default: goto L_0x0036;
            }
        L_0x0036:
            goto L_0x0041
        L_0x0037:
            r0 = 61
            int r0 = r0 * r0
            r2 = 21
            int r2 = r2 * r2
            int r2 = r2 * 34
            int r0 = r0 - r2
            goto L_0x0029
        L_0x0041:
            r0 = 38
            int r3 = 38 - r2
            int r3 = r3 * r0
            int r0 = r0 * 2
            int r0 = r0 - r2
            int r3 = r3 * r0
            int r3 = r3 % 6
            if (r3 == 0) goto L_0x0031
        L_0x004e:
            r0 = 27
            r3 = 17
            int r4 = r0 * r0
            int r4 = r4 + 1156
            int r5 = r3 * r3
            int r4 = r4 + r5
            r5 = 27
            int r5 = r5 * 34
            r6 = 34
            int r6 = r6 * r3
            int r5 = r5 + r6
            int r0 = r0 * r3
            int r5 = r5 + r0
            if (r4 >= r5) goto L_0x0066
            goto L_0x0078
        L_0x0066:
            r0 = 10
            int r0 = r0 + r2
            int r0 = r0 * 10
            int r0 = r0 % 2
            if (r0 == 0) goto L_0x0070
            goto L_0x0031
        L_0x0070:
            r0 = 5
            int r0 = r0 * r0
            r2 = 28
            int r2 = r2 * r2
            int r2 = r2 * 34
            int r0 = r0 - r2
        L_0x0078:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.u.f():void");
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x001c, code lost:
        switch(12) {
            case 55: goto L_0x0020;
            case 56: goto L_0x0035;
            case 57: goto L_0x003f;
            default: goto L_0x001f;
        };
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0033, code lost:
        if (((((26 * 26) * 26) + ((9 * 9) * 9)) + ((15 * 15) * 15)) >= (((26 * 9) * 15) * 3)) goto L_0x004c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x003d, code lost:
        if ((((90 + 1) * 90) % 2) == 0) goto L_0x0007;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0046, code lost:
        if ((((15 + 1) * 15) % 2) == 0) goto L_0x0020;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0048, code lost:
        continue;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0048, code lost:
        continue;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void g() {
        /*
            r5 = this;
            com.bytedance.sdk.openadsdk.core.nativeexpress.i r0 = r5.s
            if (r0 == 0) goto L_0x004c
            r0.b()
        L_0x0007:
            r0 = 92
        L_0x0009:
            r1 = 14
            r2 = 15
        L_0x000d:
            r3 = 12
            switch(r1) {
                case 13: goto L_0x0017;
                case 14: goto L_0x0048;
                case 15: goto L_0x0013;
                default: goto L_0x0012;
            }
        L_0x0012:
            goto L_0x0009
        L_0x0013:
            switch(r0) {
                case 94: goto L_0x0048;
                case 95: goto L_0x004c;
                case 96: goto L_0x0048;
                default: goto L_0x0016;
            }
        L_0x0016:
            goto L_0x001c
        L_0x0017:
            r1 = 72
            if (r0 < r1) goto L_0x001c
            goto L_0x0048
        L_0x001c:
            switch(r3) {
                case 55: goto L_0x0020;
                case 56: goto L_0x0035;
                case 57: goto L_0x003f;
                default: goto L_0x001f;
            }
        L_0x001f:
            goto L_0x0048
        L_0x0020:
            r0 = 26
            r1 = 9
            int r3 = r0 * r0
            int r3 = r3 * r0
            int r4 = r1 * r1
            int r4 = r4 * r1
            int r3 = r3 + r4
            int r4 = r2 * r2
            int r4 = r4 * r2
            int r3 = r3 + r4
            int r0 = r0 * r1
            int r0 = r0 * r2
            int r0 = r0 * 3
            if (r3 >= r0) goto L_0x004c
        L_0x0035:
            r0 = 90
            int r0 = r0 + 1
            int r0 = r0 * 90
            int r0 = r0 % 2
            if (r0 == 0) goto L_0x0007
        L_0x003f:
            r0 = 15
            int r0 = r0 + 1
            int r0 = r0 * r2
            int r0 = r0 % 2
            if (r0 == 0) goto L_0x0020
        L_0x0048:
            r0 = 95
            r1 = r2
            goto L_0x000d
        L_0x004c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.u.g():void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0045, code lost:
        if ((((85 * 85) + (32 * 32)) - ((85 * 32) * 2)) >= 0) goto L_0x0061;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0047, code lost:
        r3 = 0 * 0;
        r6 = 80 * 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0053, code lost:
        if ((((80 * 80) + r3) + r3) >= ((r3 + r6) + r6)) goto L_0x0067;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x005e, code lost:
        if (((85 * 85) - ((16 * 16) * 34)) != -1) goto L_0x0061;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0063, code lost:
        switch(73) {
            case 72: goto L_0x0073;
            case 73: goto L_0x008a;
            case 74: goto L_0x0067;
            default: goto L_0x0066;
        };
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0067, code lost:
        r2 = (((82 - 1) * 82) * ((82 * 2) - 1)) % 6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0088, code lost:
        if ((((29 * 29) + (45 * 45)) + (20 * 20)) >= (((29 * 45) + (45 * 20)) + (29 * 20))) goto L_0x0002;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:4:0x001e, code lost:
        if ((((49 * 49) + 1156) + (18 * 18)) < (((49 * 34) + (34 * 18)) + (49 * 18))) goto L_0x0020;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x002a, code lost:
        if ((((40 * 40) + (2 * 2)) - ((40 * 2) * 2)) >= 0) goto L_0x008a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0032, code lost:
        switch(93) {
            case 92: goto L_0x0061;
            case 93: goto L_0x0036;
            case 94: goto L_0x0056;
            default: goto L_0x0035;
        };
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0036, code lost:
        switch(52) {
            case 52: goto L_0x0061;
            case 53: goto L_0x003a;
            case 54: goto L_0x0047;
            default: goto L_0x0039;
        };
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void g(java.lang.String r6) {
        /*
            r5 = this;
            r5.J = r6
        L_0x0002:
            r6 = 61
            r0 = 2
            switch(r6) {
                case 59: goto L_0x0009;
                case 60: goto L_0x0020;
                case 61: goto L_0x002c;
                default: goto L_0x0008;
            }
        L_0x0008:
            goto L_0x0002
        L_0x0009:
            r6 = 49
            r1 = 18
            int r2 = r6 * r6
            int r2 = r2 + 1156
            int r3 = r1 * r1
            int r2 = r2 + r3
            r3 = 49
            int r3 = r3 * 34
            r4 = 34
            int r4 = r4 * r1
            int r3 = r3 + r4
            int r6 = r6 * r1
            int r3 = r3 + r6
            if (r2 >= r3) goto L_0x0061
        L_0x0020:
            r6 = 40
            int r1 = r6 * r6
            int r2 = r0 * r0
            int r1 = r1 + r2
            int r6 = r6 * r0
            int r6 = r6 * r0
            int r1 = r1 - r6
            if (r1 >= 0) goto L_0x008a
        L_0x002c:
            r6 = 52
            r1 = 93
            r2 = 85
            switch(r1) {
                case 92: goto L_0x0061;
                case 93: goto L_0x0036;
                case 94: goto L_0x0056;
                default: goto L_0x0035;
            }
        L_0x0035:
            goto L_0x002c
        L_0x0036:
            switch(r6) {
                case 52: goto L_0x0061;
                case 53: goto L_0x003a;
                case 54: goto L_0x0047;
                default: goto L_0x0039;
            }
        L_0x0039:
            goto L_0x0056
        L_0x003a:
            r6 = 32
            int r2 = r2 * r2
            int r1 = r6 * r6
            int r2 = r2 + r1
            r1 = 85
            int r1 = r1 * r6
            int r1 = r1 * r0
            int r2 = r2 - r1
            if (r2 >= 0) goto L_0x0061
        L_0x0047:
            r6 = 80
            r1 = 0
            int r2 = r6 * r6
            int r3 = r1 * r1
            int r2 = r2 + r3
            int r2 = r2 + r3
            int r6 = r6 * r1
            int r3 = r3 + r6
            int r3 = r3 + r6
            if (r2 >= r3) goto L_0x0067
            goto L_0x0061
        L_0x0056:
            int r2 = r2 * r2
            r6 = 16
            int r6 = r6 * r6
            int r6 = r6 * 34
            int r2 = r2 - r6
            r6 = -1
            if (r2 != r6) goto L_0x0061
            goto L_0x0073
        L_0x0061:
            r6 = 73
            switch(r6) {
                case 72: goto L_0x0073;
                case 73: goto L_0x008a;
                case 74: goto L_0x0067;
                default: goto L_0x0066;
            }
        L_0x0066:
            goto L_0x0061
        L_0x0067:
            r6 = 82
            r1 = 1
            int r2 = 82 - r1
            int r2 = r2 * r6
            int r6 = r6 * r0
            int r6 = r6 - r1
            int r2 = r2 * r6
            int r2 = r2 % 6
            goto L_0x0061
        L_0x0073:
            r6 = 29
            r0 = 45
            r1 = 20
            int r2 = r6 * r6
            int r3 = r0 * r0
            int r2 = r2 + r3
            int r3 = r1 * r1
            int r2 = r2 + r3
            r3 = 29
            int r3 = r3 * r0
            int r0 = r0 * r1
            int r3 = r3 + r0
            int r6 = r6 * r1
            int r3 = r3 + r6
            if (r2 >= r3) goto L_0x0002
        L_0x008a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.u.g(java.lang.String):void");
    }

    @JavascriptInterface
    public String getCurrentVideoState() {
        JSONObject jSONObject = new JSONObject();
        j(jSONObject);
        return jSONObject.toString();
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0032, code lost:
        switch(r1) {
            case 39: goto L_0x0036;
            case 40: goto L_0x004b;
            case 41: goto L_0x0058;
            default: goto L_0x0035;
        };
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0049, code lost:
        if (((((39 * 39) * 39) + ((13 * 13) * 13)) + ((9 * 9) * 9)) >= (((39 * 13) * 9) * 3)) goto L_0x0001;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0056, code lost:
        if (((((29 - 1) * 29) * ((29 * 2) - 1)) % 6) == 0) goto L_0x001c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0065, code lost:
        if ((((12 * 12) + (14 * 14)) - ((12 * 14) * 2)) >= 0) goto L_0x0001;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0068, code lost:
        r1 = '\'';
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x001c, code lost:
        continue;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0011, code lost:
        if ((((9 + 1) * 9) % 2) != 0) goto L_0x0013;
     */
    @android.webkit.JavascriptInterface
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String getTemplateInfo() {
        /*
            r8 = this;
            r0 = r8
        L_0x0001:
            r1 = 83
            r2 = 9
            r3 = -1
            r4 = 1
            switch(r1) {
                case 81: goto L_0x000b;
                case 82: goto L_0x0013;
                case 83: goto L_0x001c;
                default: goto L_0x000a;
            }
        L_0x000a:
            goto L_0x0001
        L_0x000b:
            r1 = 9
            int r1 = r1 + r4
            int r1 = r1 * r2
            int r1 = r1 % 2
            if (r1 == 0) goto L_0x001c
        L_0x0013:
            r1 = 82
            int r1 = r1 * r1
            r5 = 40
            int r5 = r5 * r5
            int r5 = r5 * 34
            int r1 = r1 - r5
        L_0x001c:
            r1 = 72
            r5 = 39
            r6 = 29
            switch(r6) {
                case 29: goto L_0x006a;
                case 30: goto L_0x0032;
                case 31: goto L_0x0026;
                default: goto L_0x0025;
            }
        L_0x0025:
            goto L_0x001c
        L_0x0026:
            r1 = 99
            int r1 = r1 * r1
            r7 = 18
            int r7 = r7 * r7
            int r7 = r7 * 34
            int r1 = r1 - r7
            if (r1 != r3) goto L_0x0001
            goto L_0x0036
        L_0x0032:
            switch(r1) {
                case 39: goto L_0x0036;
                case 40: goto L_0x004b;
                case 41: goto L_0x0058;
                default: goto L_0x0035;
            }
        L_0x0035:
            goto L_0x0068
        L_0x0036:
            r1 = 13
            int r7 = r5 * r5
            int r7 = r7 * r5
            int r5 = r1 * r1
            int r5 = r5 * r1
            int r7 = r7 + r5
            int r5 = r2 * r2
            int r5 = r5 * r2
            int r7 = r7 + r5
            r5 = 39
            int r5 = r5 * r1
            int r5 = r5 * r2
            int r5 = r5 * 3
            if (r7 >= r5) goto L_0x0001
        L_0x004b:
            int r1 = 29 - r4
            int r1 = r1 * r6
            r5 = 29
            int r5 = r5 * 2
            int r5 = r5 - r4
            int r1 = r1 * r5
            int r1 = r1 % 6
            if (r1 == 0) goto L_0x001c
        L_0x0058:
            r1 = 12
            r5 = 14
            int r6 = r1 * r1
            int r7 = r5 * r5
            int r6 = r6 + r7
            int r1 = r1 * r5
            int r1 = r1 * 2
            int r6 = r6 - r1
            if (r6 >= 0) goto L_0x0001
            goto L_0x001c
        L_0x0068:
            r1 = r5
            goto L_0x0032
        L_0x006a:
            java.lang.String r1 = "gdvWahvki}oBbka"
            java.lang.String r2 = com.bytedance.sdk.component.f.c.d.d1667305730926dc(r1)
            r0.a((java.lang.String) r2, (boolean) r4)
            org.json.JSONObject r2 = r0.t     // Catch:{ Exception -> 0x00aa }
            if (r2 == 0) goto L_0x009b
            org.json.JSONObject r2 = r0.t     // Catch:{ Exception -> 0x00aa }
            java.lang.String r3 = "sdvwmka"
            java.lang.String r3 = com.bytedance.sdk.component.f.c.d.d1667305730926dc(r3)     // Catch:{ Exception -> 0x00aa }
            org.json.JSONObject r4 = r0.u()     // Catch:{ Exception -> 0x00aa }
            r2.put(r3, r4)     // Catch:{ Exception -> 0x00aa }
            com.bytedance.sdk.openadsdk.core.model.n r2 = r0.q     // Catch:{ Exception -> 0x00aa }
            if (r2 == 0) goto L_0x009b
            org.json.JSONObject r2 = r0.t     // Catch:{ Exception -> 0x00aa }
            java.lang.String r3 = "eyvfjvohf"
            java.lang.String r3 = com.bytedance.sdk.component.f.b.a.a1667305730938dc(r3)     // Catch:{ Exception -> 0x00aa }
            com.bytedance.sdk.openadsdk.core.model.n r4 = r0.q     // Catch:{ Exception -> 0x00aa }
            org.json.JSONObject r4 = r4.aB()     // Catch:{ Exception -> 0x00aa }
            r2.put(r3, r4)     // Catch:{ Exception -> 0x00aa }
        L_0x009b:
            java.lang.String r1 = com.bytedance.sdk.component.f.c.d.d1667305730926dc(r1)     // Catch:{ Exception -> 0x00aa }
            r2 = 0
            r0.a((java.lang.String) r1, (boolean) r2)     // Catch:{ Exception -> 0x00aa }
            org.json.JSONObject r0 = r0.t     // Catch:{ Exception -> 0x00aa }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x00aa }
            return r0
        L_0x00aa:
            java.lang.String r0 = ""
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.u.getTemplateInfo():java.lang.String");
    }

    @JProtect
    public void h() {
        a((JSONObject) null, (com.bytedance.sdk.openadsdk.jslistener.c) new com.bytedance.sdk.openadsdk.jslistener.c() {
        });
        while (true) {
            char c2 = ']';
            char c3 = ']';
            while (true) {
                switch (c2) {
                    case '\\':
                        switch (c3) {
                            case 21:
                            case 22:
                            case 23:
                                break;
                        }
                    case ']':
                        while (true) {
                            switch (c3) {
                                case '[':
                                case '\\':
                                case ']':
                                    break;
                                default:
                                    c3 = '[';
                            }
                        }
                    case '^':
                        if (c3 <= 4) {
                            continue;
                        } else {
                            return;
                        }
                }
                c2 = '^';
                c3 = 'K';
            }
        }
    }

    public boolean i() {
        boolean z2 = this.K;
        while (true) {
            char c2 = '^';
            char c3 = 'K';
            while (true) {
                switch (c2) {
                    case '\\':
                        switch (c3) {
                            case 21:
                                break;
                            case 22:
                            case 23:
                                break;
                        }
                    case ']':
                        break;
                    case '^':
                        break;
                }
                c2 = ']';
                c3 = ']';
            }
            while (true) {
                switch (c3) {
                    case '[':
                    case '\\':
                    case ']':
                        break;
                    default:
                        c3 = '[';
                }
            }
        }
        return z2;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0044, code lost:
        if (((((26 * 26) * 26) + ((9 * 9) * 9)) + ((15 * 15) * 15)) >= (((26 * 9) * 15) * 3)) goto L_0x0059;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x004e, code lost:
        if ((((90 + 1) * 90) % 2) == 0) goto L_0x0017;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0057, code lost:
        if ((((15 + 1) * 15) % 2) == 0) goto L_0x0031;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0059, code lost:
        continue;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0059, code lost:
        continue;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0059, code lost:
        continue;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x002d, code lost:
        switch(12) {
            case 55: goto L_0x0031;
            case 56: goto L_0x0046;
            case 57: goto L_0x0050;
            default: goto L_0x0030;
        };
     */
    @android.webkit.JavascriptInterface
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void initRenderFinish() {
        /*
            r5 = this;
            java.lang.String r0 = "TUCm`winlFhainz"
            java.lang.String r0 = com.bytedance.sdk.component.f.b.a.a1667305730938dc(r0)
            java.lang.String r1 = "iokwV`hcm{Lbbd}g"
            java.lang.String r1 = com.bytedance.sdk.component.f.b.a.a1667305730938dc(r1)
            com.bytedance.sdk.component.utils.l.b((java.lang.String) r0, (java.lang.String) r1)
            com.bytedance.sdk.openadsdk.core.u$6 r0 = new com.bytedance.sdk.openadsdk.core.u$6
            r0.<init>()
            com.bytedance.sdk.openadsdk.l.w.a((java.lang.Runnable) r0)
        L_0x0017:
            r0 = 92
        L_0x0019:
            r1 = 14
            r2 = 15
        L_0x001d:
            r3 = 12
            switch(r1) {
                case 13: goto L_0x0028;
                case 14: goto L_0x0059;
                case 15: goto L_0x0023;
                default: goto L_0x0022;
            }
        L_0x0022:
            goto L_0x0019
        L_0x0023:
            switch(r0) {
                case 94: goto L_0x0059;
                case 95: goto L_0x0027;
                case 96: goto L_0x0059;
                default: goto L_0x0026;
            }
        L_0x0026:
            goto L_0x002d
        L_0x0027:
            return
        L_0x0028:
            r1 = 72
            if (r0 < r1) goto L_0x002d
            goto L_0x0059
        L_0x002d:
            switch(r3) {
                case 55: goto L_0x0031;
                case 56: goto L_0x0046;
                case 57: goto L_0x0050;
                default: goto L_0x0030;
            }
        L_0x0030:
            goto L_0x0059
        L_0x0031:
            r0 = 26
            r1 = 9
            int r3 = r0 * r0
            int r3 = r3 * r0
            int r4 = r1 * r1
            int r4 = r4 * r1
            int r3 = r3 + r4
            int r4 = r2 * r2
            int r4 = r4 * r2
            int r3 = r3 + r4
            int r0 = r0 * r1
            int r0 = r0 * r2
            int r0 = r0 * 3
            if (r3 >= r0) goto L_0x0059
        L_0x0046:
            r0 = 90
            int r0 = r0 + 1
            int r0 = r0 * 90
            int r0 = r0 % 2
            if (r0 == 0) goto L_0x0017
        L_0x0050:
            r0 = 15
            int r0 = r0 + 1
            int r0 = r0 * r2
            int r0 = r0 % 2
            if (r0 == 0) goto L_0x0031
        L_0x0059:
            r0 = 95
            r1 = r2
            goto L_0x001d
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.u.initRenderFinish():void");
    }

    /* access modifiers changed from: package-private */
    public boolean j() {
        n nVar = this.q;
        if (nVar != null) {
            int I2 = nVar.I();
            while (true) {
                char c2 = '_';
                char c3 = '_';
                while (true) {
                    switch (c2) {
                        case '^':
                            if (c3 != '\'') {
                                break;
                            } else {
                                continue;
                            }
                        case '_':
                            switch (c3) {
                                case '^':
                                case '`':
                                    continue;
                                case '_':
                                    if (I2 != 1) {
                                        break;
                                    } else {
                                        return true;
                                    }
                            }
                        case '`':
                            break;
                    }
                    switch (c3) {
                        case '7':
                        case '9':
                            break;
                        case '8':
                            break;
                    }
                    c2 = '^';
                    c3 = '}';
                }
            }
            return false;
        }
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x005e, code lost:
        if (((((26 * 26) * 26) + ((9 * 9) * 9)) + ((15 * 15) * 15)) >= (((26 * 9) * 15) * 3)) goto L_0x0095;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x006a, code lost:
        if (((((0 - 1) * 0) * ((0 * 2) - 1)) % 6) == 0) goto L_0x0016;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0075, code lost:
        if (((((18 - 1) * 18) * ((18 * 2) - 1)) % 6) == 0) goto L_0x006c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0016, code lost:
        continue;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void k() {
        /*
            r10 = this;
            com.bytedance.sdk.openadsdk.f.c r0 = r10.i
            if (r0 == 0) goto L_0x0007
            r0.a()
        L_0x0007:
            boolean r0 = r10.v()
            r1 = -1
            r2 = 13
            r3 = 34
            r4 = 1
            if (r0 == 0) goto L_0x007d
            r10.h()
        L_0x0016:
            r0 = 96
            r5 = 52
            switch(r0) {
                case 94: goto L_0x001e;
                case 95: goto L_0x0034;
                case 96: goto L_0x007d;
                default: goto L_0x001d;
            }
        L_0x001d:
            goto L_0x0016
        L_0x001e:
            r0 = 57
            int r6 = r0 * r0
            int r7 = r3 * r3
            int r6 = r6 + r7
            int r6 = r6 + 144
            r7 = 57
            int r7 = r7 * r3
            r8 = 34
            int r8 = r8 * 12
            int r7 = r7 + r8
            int r0 = r0 * 12
            int r7 = r7 + r0
            if (r6 >= r7) goto L_0x007d
        L_0x0034:
            r0 = r2
        L_0x0035:
            r6 = 18
            switch(r5) {
                case 55: goto L_0x0045;
                case 56: goto L_0x007d;
                case 57: goto L_0x003b;
                default: goto L_0x003a;
            }
        L_0x003a:
            goto L_0x0078
        L_0x003b:
            int r0 = r6 * r6
            r5 = 35
            int r5 = r5 * r5
            int r5 = r5 * r3
            int r0 = r0 - r5
            if (r0 != r1) goto L_0x0095
            goto L_0x0049
        L_0x0045:
            switch(r0) {
                case 60: goto L_0x0049;
                case 61: goto L_0x0060;
                case 62: goto L_0x006c;
                default: goto L_0x0048;
            }
        L_0x0048:
            goto L_0x007d
        L_0x0049:
            r0 = 26
            r5 = 9
            r7 = 15
            int r8 = r0 * r0
            int r8 = r8 * r0
            int r9 = r5 * r5
            int r9 = r9 * r5
            int r8 = r8 + r9
            int r9 = r7 * r7
            int r9 = r9 * r7
            int r8 = r8 + r9
            int r0 = r0 * r5
            int r0 = r0 * r7
            int r0 = r0 * 3
            if (r8 >= r0) goto L_0x0095
        L_0x0060:
            r0 = 0
            int r5 = 0 - r4
            int r5 = r5 * r0
            int r0 = r0 * 2
            int r0 = r0 - r4
            int r5 = r5 * r0
            int r5 = r5 % 6
            if (r5 == 0) goto L_0x0016
        L_0x006c:
            int r0 = 18 - r4
            int r0 = r0 * r6
            int r1 = r6 * 2
            int r1 = r1 - r4
            int r0 = r0 * r1
            int r0 = r0 % 6
            if (r0 == 0) goto L_0x006c
            goto L_0x0095
        L_0x0078:
            r5 = 55
            r0 = 61
            goto L_0x0035
        L_0x007d:
            r0 = 49
            switch(r0) {
                case 49: goto L_0x0095;
                case 50: goto L_0x0083;
                case 51: goto L_0x008c;
                default: goto L_0x0082;
            }
        L_0x0082:
            goto L_0x007d
        L_0x0083:
            int r0 = r2 * r2
            r5 = 19
            int r5 = r5 * r5
            int r5 = r5 * r3
            int r0 = r0 - r5
            if (r0 != r1) goto L_0x007d
        L_0x008c:
            r0 = 10
            int r0 = r0 + r4
            int r0 = r0 * 10
            int r0 = r0 % 2
            if (r0 == 0) goto L_0x007d
        L_0x0095:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.u.k():void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0036, code lost:
        if ((((70 * 70) + (7 * 7)) + (4 * 4)) >= (((70 * 7) + (7 * 4)) + (70 * 4))) goto L_0x0007;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x004d, code lost:
        if (((((26 * 26) * 26) + 729) + ((15 * 15) * 15)) >= (((26 * 9) * 15) * 3)) goto L_0x0065;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0057, code lost:
        if ((((90 + 1) * 90) % 2) == 0) goto L_0x0062;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0060, code lost:
        if ((((15 + 1) * 15) % 2) == 0) goto L_0x003d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0007, code lost:
        continue;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0007, code lost:
        continue;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0062, code lost:
        continue;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0062, code lost:
        continue;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0020, code lost:
        if (((18 * 18) - ((35 * 35) * 34)) == -1) goto L_0x003d;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void l() {
        /*
            r6 = this;
            com.bytedance.sdk.openadsdk.f.c r0 = r6.i
            if (r0 == 0) goto L_0x0065
            r0.b()
        L_0x0007:
            r0 = 15
            r1 = r0
        L_0x000a:
            r2 = 12
            r3 = 95
            switch(r1) {
                case 13: goto L_0x0007;
                case 14: goto L_0x0065;
                case 15: goto L_0x0012;
                default: goto L_0x0011;
            }
        L_0x0011:
            goto L_0x0062
        L_0x0012:
            switch(r3) {
                case 94: goto L_0x0023;
                case 95: goto L_0x0062;
                case 96: goto L_0x0016;
                default: goto L_0x0015;
            }
        L_0x0015:
            goto L_0x0039
        L_0x0016:
            r1 = 18
            int r1 = r1 * r1
            r2 = 35
            int r2 = r2 * r2
            int r2 = r2 * 34
            int r1 = r1 - r2
            r2 = -1
            if (r1 != r2) goto L_0x0023
            goto L_0x003d
        L_0x0023:
            r1 = 70
            r2 = 7
            r3 = 4
            int r4 = r1 * r1
            int r5 = r2 * r2
            int r4 = r4 + r5
            int r5 = r3 * r3
            int r4 = r4 + r5
            r5 = 70
            int r5 = r5 * r2
            int r2 = r2 * r3
            int r5 = r5 + r2
            int r1 = r1 * r3
            int r5 = r5 + r1
            if (r4 >= r5) goto L_0x0007
            goto L_0x0062
        L_0x0039:
            switch(r2) {
                case 55: goto L_0x003d;
                case 56: goto L_0x004f;
                case 57: goto L_0x0059;
                default: goto L_0x003c;
            }
        L_0x003c:
            goto L_0x0007
        L_0x003d:
            r1 = 26
            int r2 = r1 * r1
            int r2 = r2 * r1
            int r2 = r2 + 729
            int r3 = r0 * r0
            int r3 = r3 * r0
            int r2 = r2 + r3
            int r1 = r1 * 9
            int r1 = r1 * r0
            int r1 = r1 * 3
            if (r2 >= r1) goto L_0x0065
        L_0x004f:
            r1 = 90
            int r1 = r1 + 1
            int r1 = r1 * 90
            int r1 = r1 % 2
            if (r1 == 0) goto L_0x0062
        L_0x0059:
            r1 = 15
            int r1 = r1 + 1
            int r1 = r1 * r0
            int r1 = r1 % 2
            if (r1 == 0) goto L_0x003d
        L_0x0062:
            r1 = 14
            goto L_0x000a
        L_0x0065:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.u.l():void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0036, code lost:
        if ((((70 * 70) + (7 * 7)) + (4 * 4)) >= (((70 * 7) + (7 * 4)) + (70 * 4))) goto L_0x0007;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x004d, code lost:
        if (((((26 * 26) * 26) + 729) + ((15 * 15) * 15)) >= (((26 * 9) * 15) * 3)) goto L_0x0065;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0057, code lost:
        if ((((90 + 1) * 90) % 2) == 0) goto L_0x0062;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0060, code lost:
        if ((((15 + 1) * 15) % 2) == 0) goto L_0x003d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0007, code lost:
        continue;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0007, code lost:
        continue;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0062, code lost:
        continue;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0062, code lost:
        continue;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0020, code lost:
        if (((18 * 18) - ((35 * 35) * 34)) == -1) goto L_0x003d;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void m() {
        /*
            r6 = this;
            com.bytedance.sdk.openadsdk.f.c r0 = r6.i
            if (r0 == 0) goto L_0x0065
            r0.c()
        L_0x0007:
            r0 = 15
            r1 = r0
        L_0x000a:
            r2 = 12
            r3 = 95
            switch(r1) {
                case 13: goto L_0x0007;
                case 14: goto L_0x0065;
                case 15: goto L_0x0012;
                default: goto L_0x0011;
            }
        L_0x0011:
            goto L_0x0062
        L_0x0012:
            switch(r3) {
                case 94: goto L_0x0023;
                case 95: goto L_0x0062;
                case 96: goto L_0x0016;
                default: goto L_0x0015;
            }
        L_0x0015:
            goto L_0x0039
        L_0x0016:
            r1 = 18
            int r1 = r1 * r1
            r2 = 35
            int r2 = r2 * r2
            int r2 = r2 * 34
            int r1 = r1 - r2
            r2 = -1
            if (r1 != r2) goto L_0x0023
            goto L_0x003d
        L_0x0023:
            r1 = 70
            r2 = 7
            r3 = 4
            int r4 = r1 * r1
            int r5 = r2 * r2
            int r4 = r4 + r5
            int r5 = r3 * r3
            int r4 = r4 + r5
            r5 = 70
            int r5 = r5 * r2
            int r2 = r2 * r3
            int r5 = r5 + r2
            int r1 = r1 * r3
            int r5 = r5 + r1
            if (r4 >= r5) goto L_0x0007
            goto L_0x0062
        L_0x0039:
            switch(r2) {
                case 55: goto L_0x003d;
                case 56: goto L_0x004f;
                case 57: goto L_0x0059;
                default: goto L_0x003c;
            }
        L_0x003c:
            goto L_0x0007
        L_0x003d:
            r1 = 26
            int r2 = r1 * r1
            int r2 = r2 * r1
            int r2 = r2 + 729
            int r3 = r0 * r0
            int r3 = r3 * r0
            int r2 = r2 + r3
            int r1 = r1 * 9
            int r1 = r1 * r0
            int r1 = r1 * 3
            if (r2 >= r1) goto L_0x0065
        L_0x004f:
            r1 = 90
            int r1 = r1 + 1
            int r1 = r1 * 90
            int r1 = r1 % 2
            if (r1 == 0) goto L_0x0062
        L_0x0059:
            r1 = 15
            int r1 = r1 + 1
            int r1 = r1 * r0
            int r1 = r1 % 2
            if (r1 == 0) goto L_0x003d
        L_0x0062:
            r1 = 14
            goto L_0x000a
        L_0x0065:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.u.m():void");
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0048, code lost:
        if ((((57 * 57) + (34 * 34)) + 144) >= (((57 * 34) + (34 * 12)) + (57 * 12))) goto L_0x000d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x004a, code lost:
        r3 = '1';
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x004d, code lost:
        switch(r4) {
            case 55: goto L_0x005b;
            case 56: goto L_0x000d;
            case 57: goto L_0x0051;
            default: goto L_0x0050;
        };
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0058, code lost:
        if (((18 * 18) - ((35 * 35) * 34)) != -1) goto L_0x002c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x005b, code lost:
        switch(r3) {
            case 60: goto L_0x005f;
            case 61: goto L_0x0076;
            case 62: goto L_0x0082;
            default: goto L_0x005e;
        };
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0074, code lost:
        if (((((26 * 26) * 26) + ((9 * 9) * 9)) + ((15 * 15) * 15)) >= (((26 * 9) * 15) * 3)) goto L_0x000d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0080, code lost:
        if (((((0 - 1) * 0) * ((0 * 2) - 1)) % 6) == 0) goto L_0x002c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x008d, code lost:
        if (((((18 - 1) * 18) * ((18 * 2) - 1)) % 6) == 0) goto L_0x0082;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0090, code lost:
        r4 = '7';
        r3 = '=';
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x000d, code lost:
        continue;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x002c, code lost:
        continue;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0030, code lost:
        switch(96) {
            case 94: goto L_0x0034;
            case 95: goto L_0x004a;
            case 96: goto L_0x00a0;
            default: goto L_0x0033;
        };
     */
    @android.webkit.JavascriptInterface
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void muteVideo(java.lang.String r10) {
        /*
            r9 = this;
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ Exception -> 0x0095 }
            r0.<init>(r10)     // Catch:{ Exception -> 0x0095 }
            com.bytedance.sdk.openadsdk.core.u$2 r10 = new com.bytedance.sdk.openadsdk.core.u$2     // Catch:{ Exception -> 0x0095 }
            r10.<init>(r0)     // Catch:{ Exception -> 0x0095 }
            com.bytedance.sdk.openadsdk.l.w.a((java.lang.Runnable) r10)     // Catch:{ Exception -> 0x0095 }
        L_0x000d:
            r10 = -1
            r0 = 49
            r1 = 34
            r2 = 1
            switch(r0) {
                case 49: goto L_0x002c;
                case 50: goto L_0x0017;
                case 51: goto L_0x0021;
                default: goto L_0x0016;
            }
        L_0x0016:
            goto L_0x000d
        L_0x0017:
            r0 = 13
            int r0 = r0 * r0
            r3 = 19
            int r3 = r3 * r3
            int r3 = r3 * r1
            int r0 = r0 - r3
            if (r0 != r10) goto L_0x00a0
        L_0x0021:
            r10 = 10
            int r10 = r10 + r2
            int r10 = r10 * 10
            int r10 = r10 % 2
            if (r10 == 0) goto L_0x000d
            goto L_0x00a0
        L_0x002c:
            r3 = 96
            r4 = 52
            switch(r3) {
                case 94: goto L_0x0034;
                case 95: goto L_0x004a;
                case 96: goto L_0x00a0;
                default: goto L_0x0033;
            }
        L_0x0033:
            goto L_0x002c
        L_0x0034:
            r3 = 57
            int r5 = r3 * r3
            int r6 = r1 * r1
            int r5 = r5 + r6
            int r5 = r5 + 144
            r6 = 57
            int r6 = r6 * r1
            r7 = 34
            int r7 = r7 * 12
            int r6 = r6 + r7
            int r3 = r3 * 12
            int r6 = r6 + r3
            if (r5 >= r6) goto L_0x000d
        L_0x004a:
            r3 = r0
        L_0x004b:
            r5 = 18
            switch(r4) {
                case 55: goto L_0x005b;
                case 56: goto L_0x000d;
                case 57: goto L_0x0051;
                default: goto L_0x0050;
            }
        L_0x0050:
            goto L_0x0090
        L_0x0051:
            int r3 = r5 * r5
            r4 = 35
            int r4 = r4 * r4
            int r4 = r4 * r1
            int r3 = r3 - r4
            if (r3 != r10) goto L_0x002c
            goto L_0x005f
        L_0x005b:
            switch(r3) {
                case 60: goto L_0x005f;
                case 61: goto L_0x0076;
                case 62: goto L_0x0082;
                default: goto L_0x005e;
            }
        L_0x005e:
            goto L_0x000d
        L_0x005f:
            r3 = 26
            r4 = 9
            r6 = 15
            int r7 = r3 * r3
            int r7 = r7 * r3
            int r8 = r4 * r4
            int r8 = r8 * r4
            int r7 = r7 + r8
            int r8 = r6 * r6
            int r8 = r8 * r6
            int r7 = r7 + r8
            int r3 = r3 * r4
            int r3 = r3 * r6
            int r3 = r3 * 3
            if (r7 >= r3) goto L_0x000d
        L_0x0076:
            r3 = 0
            int r4 = 0 - r2
            int r4 = r4 * r3
            int r3 = r3 * 2
            int r3 = r3 - r2
            int r4 = r4 * r3
            int r4 = r4 % 6
            if (r4 == 0) goto L_0x002c
        L_0x0082:
            int r3 = 18 - r2
            int r3 = r3 * r5
            r4 = 18
            int r4 = r4 * 2
            int r4 = r4 - r2
            int r3 = r3 * r4
            int r3 = r3 % 6
            if (r3 == 0) goto L_0x0082
            goto L_0x002c
        L_0x0090:
            r4 = 55
            r3 = 61
            goto L_0x004b
        L_0x0095:
            java.lang.String r10 = "TUCm`winlFhainz"
            java.lang.String r10 = com.bytedance.sdk.component.f.b.a.a1667305730938dc(r10)
            java.lang.String r0 = ""
            com.bytedance.sdk.component.utils.l.e(r10, r0)
        L_0x00a0:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.u.muteVideo(java.lang.String):void");
    }

    @JavascriptInterface
    public void renderDidFinish(String str) {
        try {
            k(new JSONObject(str));
        } catch (Exception unused) {
        }
    }

    @JavascriptInterface
    public void skipVideo() {
        w.a((Runnable) new Runnable() {
            /* JADX WARNING: Can't fix incorrect switch cases order */
            /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
                return;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:7:0x0033, code lost:
                if (((((26 * 26) * 26) + ((9 * 9) * 9)) + ((15 * 15) * 15)) >= (((26 * 9) * 15) * 3)) goto L_?;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:8:0x0035, code lost:
                r0 = 40;
                r1 = 40 - 1;
             */
            /* JADX WARNING: Removed duplicated region for block: B:1:0x0005 A[LOOP_START] */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void run() {
                /*
                    r6 = this;
                    com.bytedance.sdk.openadsdk.core.u r0 = com.bytedance.sdk.openadsdk.core.u.this
                    r0.s()
                L_0x0005:
                    r0 = 37
                    r1 = 54
                    r2 = 1
                    switch(r1) {
                        case 52: goto L_0x000e;
                        case 53: goto L_0x003a;
                        case 54: goto L_0x0045;
                        default: goto L_0x000d;
                    }
                L_0x000d:
                    goto L_0x0005
                L_0x000e:
                    switch(r0) {
                        case 94: goto L_0x0012;
                        case 95: goto L_0x001e;
                        case 96: goto L_0x0035;
                        default: goto L_0x0011;
                    }
                L_0x0011:
                    goto L_0x003a
                L_0x0012:
                    r0 = 18
                    int r0 = r0 * r0
                    r1 = 35
                    int r1 = r1 * r1
                    int r1 = r1 * 34
                    int r0 = r0 - r1
                    r1 = -1
                    if (r0 != r1) goto L_0x0045
                L_0x001e:
                    r0 = 26
                    r1 = 9
                    r3 = 15
                    int r4 = r0 * r0
                    int r4 = r4 * r0
                    int r5 = r1 * r1
                    int r5 = r5 * r1
                    int r4 = r4 + r5
                    int r5 = r3 * r3
                    int r5 = r5 * r3
                    int r4 = r4 + r5
                    int r0 = r0 * r1
                    int r0 = r0 * r3
                    int r0 = r0 * 3
                    if (r4 >= r0) goto L_0x0045
                L_0x0035:
                    r0 = 40
                    int r1 = 40 - r2
                    goto L_0x003e
                L_0x003a:
                    r0 = 30
                    int r1 = 30 - r2
                L_0x003e:
                    int r1 = r1 * r0
                    int r0 = r0 * 2
                    int r0 = r0 - r2
                    int r1 = r1 * r0
                    int r1 = r1 % 6
                L_0x0045:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.u.AnonymousClass5.run():void");
            }
        });
    }
}
