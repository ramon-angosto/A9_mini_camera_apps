package com.bytedance.sdk.openadsdk.c;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.JProtect;
import com.bytedance.sdk.component.a.j;
import com.bytedance.sdk.component.adexpress.widget.DynamicUnlockView;
import com.bytedance.sdk.component.adexpress.widget.FlowLightView;
import com.bytedance.sdk.component.d.c.c;
import com.bytedance.sdk.component.g.e;
import com.bytedance.sdk.component.g.g;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.FilterWord;
import com.bytedance.sdk.openadsdk.c.a;
import com.bytedance.sdk.openadsdk.c.b.a;
import com.bytedance.sdk.openadsdk.core.m;
import com.bytedance.sdk.openadsdk.core.model.n;
import com.bytedance.sdk.openadsdk.core.p;
import com.bytedance.sdk.openadsdk.l.w;
import com.bytedance.sdk.openadsdk.l.x;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: AdEventManager */
public class c {
    public static void a(long j, n nVar, String str, String str2, JSONObject jSONObject, f fVar, a aVar) {
        if (nVar != null) {
            new a.C0039a(j).f(nVar.Y()).h(nVar.aZ()).e(nVar.ac()).a(nVar.Z()).b(str).c(str2).a(jSONObject).a(aVar);
        }
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x003f  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0035 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0048 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0025 A[SYNTHETIC] */
    public static void a(android.content.Context r5, com.bytedance.sdk.openadsdk.core.model.n r6) {
        /*
            if (r6 != 0) goto L_0x0049
        L_0x0002:
            r5 = 73
            r6 = 14
            r0 = 1
            switch(r5) {
                case 71: goto L_0x000b;
                case 72: goto L_0x0052;
                case 73: goto L_0x0031;
                default: goto L_0x000a;
            }
        L_0x000a:
            goto L_0x0002
        L_0x000b:
            switch(r6) {
                case 12: goto L_0x000f;
                case 13: goto L_0x0025;
                case 14: goto L_0x0025;
                default: goto L_0x000e;
            }
        L_0x000e:
            goto L_0x0052
        L_0x000f:
            r5 = 34
            r1 = 38
            r2 = 7
            int r3 = r5 * r5
            int r3 = r3 * r5
            int r4 = r1 * r1
            int r4 = r4 * r1
            int r3 = r3 + r4
            int r4 = r2 * r2
            int r4 = r4 * r2
            int r3 = r3 + r4
            int r5 = r5 * r1
            int r5 = r5 * r2
            int r5 = r5 * 3
            if (r3 >= r5) goto L_0x0031
        L_0x0025:
            r5 = 16
            int r6 = 16 - r0
            int r6 = r6 * r5
            int r5 = r5 * 2
            int r5 = r5 - r0
            int r6 = r6 * r5
            int r6 = r6 % 6
            goto L_0x0052
        L_0x0031:
            switch(r6) {
                case 13: goto L_0x003f;
                case 14: goto L_0x0048;
                case 15: goto L_0x0035;
                default: goto L_0x0034;
            }
        L_0x0034:
            goto L_0x000f
        L_0x0035:
            r5 = 9
            int r5 = r5 + r0
            int r5 = r5 * 9
            int r5 = r5 % 2
            if (r5 == 0) goto L_0x0052
            goto L_0x0048
        L_0x003f:
            r5 = 94
            int r5 = r5 + r0
            int r5 = r5 * 94
            int r5 = r5 % 2
            if (r5 == 0) goto L_0x0002
        L_0x0048:
            return
        L_0x0049:
            java.lang.String r0 = "l`lgmkawino"
            java.lang.String r0 = com.bytedance.sdk.component.d.c.c.b.c$b1667305730972dc(r0)
            a((android.content.Context) r5, (com.bytedance.sdk.openadsdk.core.model.n) r6, (java.lang.String) r0)
        L_0x0052:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.c.c.a(android.content.Context, com.bytedance.sdk.openadsdk.core.model.n):void");
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0050, code lost:
        if (((((26 * 26) * 26) + ((9 * 9) * 9)) + ((15 * 15) * 15)) >= (((26 * 9) * 15) * 3)) goto L_0x0085;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x005c, code lost:
        if (((((0 - 1) * 0) * ((0 * 2) - 1)) % 6) == 0) goto L_0x0000;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0071, code lost:
        switch(49) {
            case 49: goto L_0x0085;
            case 50: goto L_0x0075;
            case 51: goto L_0x007e;
            default: goto L_0x0074;
        };
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x007c, code lost:
        if (((13 * 13) - ((19 * 19) * 34)) != -1) goto L_0x006f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x007e, code lost:
        r0 = ((10 + 1) * 10) % 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0000, code lost:
        continue;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(android.content.Context r11, com.bytedance.sdk.openadsdk.core.model.n r12, java.lang.String r13) {
        /*
        L_0x0000:
            r0 = 52
            r1 = 96
            r2 = 0
            r3 = -1
            r4 = 13
            r5 = 34
            r6 = 1
            switch(r1) {
                case 94: goto L_0x000f;
                case 95: goto L_0x0026;
                case 96: goto L_0x006f;
                default: goto L_0x000e;
            }
        L_0x000e:
            goto L_0x0000
        L_0x000f:
            r1 = 57
            r7 = 12
            int r8 = r1 * r1
            int r9 = r5 * r5
            int r8 = r8 + r9
            int r9 = r7 * r7
            int r8 = r8 + r9
            r9 = 57
            int r9 = r9 * r5
            r10 = 34
            int r10 = r10 * r7
            int r9 = r9 + r10
            int r1 = r1 * r7
            int r9 = r9 + r1
            if (r8 >= r9) goto L_0x006f
        L_0x0026:
            r1 = r4
        L_0x0027:
            r7 = 18
            switch(r0) {
                case 55: goto L_0x0037;
                case 56: goto L_0x006f;
                case 57: goto L_0x002d;
                default: goto L_0x002c;
            }
        L_0x002c:
            goto L_0x006a
        L_0x002d:
            int r0 = r7 * r7
            r1 = 35
            int r1 = r1 * r1
            int r1 = r1 * r5
            int r0 = r0 - r1
            if (r0 != r3) goto L_0x0085
            goto L_0x003b
        L_0x0037:
            switch(r1) {
                case 60: goto L_0x003b;
                case 61: goto L_0x0052;
                case 62: goto L_0x005e;
                default: goto L_0x003a;
            }
        L_0x003a:
            goto L_0x006f
        L_0x003b:
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
            if (r4 >= r0) goto L_0x0085
        L_0x0052:
            int r0 = 0 - r6
            int r0 = r0 * r2
            r1 = 0
            int r1 = r1 * 2
            int r1 = r1 - r6
            int r0 = r0 * r1
            int r0 = r0 % 6
            if (r0 == 0) goto L_0x0000
        L_0x005e:
            int r0 = 18 - r6
            int r0 = r0 * r7
            int r1 = r7 * 2
            int r1 = r1 - r6
            int r0 = r0 * r1
            int r0 = r0 % 6
            if (r0 == 0) goto L_0x005e
            goto L_0x0085
        L_0x006a:
            r0 = 55
            r1 = 61
            goto L_0x0027
        L_0x006f:
            r0 = 49
            switch(r0) {
                case 49: goto L_0x0085;
                case 50: goto L_0x0075;
                case 51: goto L_0x007e;
                default: goto L_0x0074;
            }
        L_0x0074:
            goto L_0x006f
        L_0x0075:
            int r0 = r4 * r4
            r1 = 19
            int r1 = r1 * r1
            int r1 = r1 * r5
            int r0 = r0 - r1
            if (r0 != r3) goto L_0x006f
        L_0x007e:
            r0 = 10
            int r0 = r0 + r6
            int r0 = r0 * 10
            int r0 = r0 % 2
        L_0x0085:
            if (r12 != 0) goto L_0x0088
            return
        L_0x0088:
            org.json.JSONObject r0 = new org.json.JSONObject
            r0.<init>()
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch:{ Exception -> 0x00b7 }
            r1.<init>()     // Catch:{ Exception -> 0x00b7 }
            java.lang.String r3 = "rdlgawYsqyo"
            java.lang.String r3 = com.bytedance.sdk.component.d.c.c.b.c$b1667305730972dc(r3)     // Catch:{ Exception -> 0x00b7 }
            java.lang.String r4 = "h4"
            java.lang.String r4 = com.bytedance.sdk.component.d.c.c.b.c$b1667305730972dc(r4)     // Catch:{ Exception -> 0x00b7 }
            r1.putOpt(r3, r4)     // Catch:{ Exception -> 0x00b7 }
            java.lang.String r3 = "rdlgawYsqyoT>"
            java.lang.String r3 = com.bytedance.sdk.component.d.c.c.b.c$b1667305730972dc(r3)     // Catch:{ Exception -> 0x00b7 }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ Exception -> 0x00b7 }
            r1.putOpt(r3, r2)     // Catch:{ Exception -> 0x00b7 }
            java.lang.String r2 = "ae]f|qtfWmkm"
            java.lang.String r2 = com.bytedance.sdk.component.d.c.c.b.c$b1667305730972dc(r2)     // Catch:{ Exception -> 0x00b7 }
            r0.putOpt(r2, r1)     // Catch:{ Exception -> 0x00b7 }
        L_0x00b7:
            java.lang.String r1 = "oqgm[ptkWa?"
            java.lang.String r1 = com.bytedance.sdk.component.d.c.c.b.c$b1667305730972dc(r1)
            c((android.content.Context) r11, (com.bytedance.sdk.openadsdk.core.model.n) r12, (java.lang.String) r13, (java.lang.String) r1, (org.json.JSONObject) r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.c.c.a(android.content.Context, com.bytedance.sdk.openadsdk.core.model.n, java.lang.String):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x000b, code lost:
        switch(r1) {
            case 52: goto L_0x0005;
            case 53: goto L_0x000f;
            case 54: goto L_0x0076;
            default: goto L_0x000e;
        };
     */
    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000f, code lost:
        switch(r2) {
            case 29: goto L_0x0005;
            case 30: goto L_0x0005;
            case 31: goto L_0x000b;
            default: goto L_0x0012;
        };
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0012, code lost:
        r2 = 30;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(android.content.Context r5, com.bytedance.sdk.openadsdk.core.model.n r6, java.lang.String r7, long r8) {
        /*
            r0 = 0
            r1 = 55
            r2 = r1
            r1 = r0
        L_0x0005:
            r3 = 72
        L_0x0007:
            switch(r3) {
                case 72: goto L_0x0076;
                case 73: goto L_0x0015;
                case 74: goto L_0x000b;
                default: goto L_0x000a;
            }
        L_0x000a:
            goto L_0x0005
        L_0x000b:
            switch(r1) {
                case 52: goto L_0x0005;
                case 53: goto L_0x000f;
                case 54: goto L_0x0076;
                default: goto L_0x000e;
            }
        L_0x000e:
            goto L_0x0005
        L_0x000f:
            switch(r2) {
                case 29: goto L_0x0005;
                case 30: goto L_0x0005;
                case 31: goto L_0x000b;
                default: goto L_0x0012;
            }
        L_0x0012:
            r2 = 30
            goto L_0x000f
        L_0x0015:
            r3 = 57
            if (r1 > r3) goto L_0x0005
            if (r6 != 0) goto L_0x001c
            return
        L_0x001c:
            org.json.JSONObject r1 = new org.json.JSONObject
            r1.<init>()
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch:{ Exception -> 0x006c }
            r2.<init>()     // Catch:{ Exception -> 0x006c }
            java.lang.String r3 = "rdlgawYsqyo"
            java.lang.String r3 = com.bytedance.sdk.component.d.c.c.b.c$b1667305730972dc(r3)     // Catch:{ Exception -> 0x006c }
            java.lang.String r4 = "h4"
            java.lang.String r4 = com.bytedance.sdk.component.d.c.c.b.c$b1667305730972dc(r4)     // Catch:{ Exception -> 0x006c }
            r2.putOpt(r3, r4)     // Catch:{ Exception -> 0x006c }
            java.lang.String r3 = "rdlgawYsqyoT>"
            java.lang.String r3 = com.bytedance.sdk.component.d.c.c.b.c$b1667305730972dc(r3)     // Catch:{ Exception -> 0x006c }
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ Exception -> 0x006c }
            r2.putOpt(r3, r0)     // Catch:{ Exception -> 0x006c }
            java.lang.String r0 = "iovfvdesafdTahzgu"
            java.lang.String r0 = com.bytedance.sdk.component.d.c.c.b.c$b1667305730972dc(r0)     // Catch:{ Exception -> 0x006c }
            int r3 = r6.g()     // Catch:{ Exception -> 0x006c }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ Exception -> 0x006c }
            r2.putOpt(r0, r3)     // Catch:{ Exception -> 0x006c }
            java.lang.String r0 = "ae]f|qtfWmkm"
            java.lang.String r0 = com.bytedance.sdk.component.d.c.c.b.c$b1667305730972dc(r0)     // Catch:{ Exception -> 0x006c }
            r1.putOpt(r0, r2)     // Catch:{ Exception -> 0x006c }
            java.lang.String r0 = "dtpbplii"
            java.lang.String r0 = com.bytedance.sdk.component.d.c.c.b.c$b1667305730972dc(r0)     // Catch:{ Exception -> 0x006c }
            r2 = 600000(0x927c0, double:2.964394E-318)
            long r8 = java.lang.Math.min(r8, r2)     // Catch:{ Exception -> 0x006c }
            r1.put(r0, r8)     // Catch:{ Exception -> 0x006c }
        L_0x006c:
            java.lang.String r8 = "lncg"
            java.lang.String r8 = com.bytedance.sdk.component.d.c.c.b.c$b1667305730972dc(r8)
            c((android.content.Context) r5, (com.bytedance.sdk.openadsdk.core.model.n) r6, (java.lang.String) r7, (java.lang.String) r8, (org.json.JSONObject) r1)
            return
        L_0x0076:
            r3 = 73
            r1 = 16
            goto L_0x0007
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.c.c.a(android.content.Context, com.bytedance.sdk.openadsdk.core.model.n, java.lang.String, long):void");
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0047 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0058 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0037 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x004f  */
    public static void a(android.content.Context r9, com.bytedance.sdk.openadsdk.core.model.n r10, java.lang.String r11, long r12, boolean r14) {
        /*
            com.bytedance.sdk.openadsdk.c.c$8 r8 = new com.bytedance.sdk.openadsdk.c.c$8
            java.lang.String r0 = "ooNsHjgcagm"
            java.lang.String r1 = com.bytedance.sdk.component.adexpress.widget.DynamicUnlockView.DynamicUnlockView1667305730929dc(r0)
            r0 = r8
            r2 = r10
            r3 = r14
            r4 = r12
            r6 = r9
            r7 = r11
            r0.<init>(r1, r2, r3, r4, r6, r7)
            a((com.bytedance.sdk.component.g.g) r8)
        L_0x0014:
            r9 = 73
            r10 = 14
            r11 = 1
            switch(r9) {
                case 71: goto L_0x001d;
                case 72: goto L_0x0058;
                case 73: goto L_0x0043;
                default: goto L_0x001c;
            }
        L_0x001c:
            goto L_0x0014
        L_0x001d:
            switch(r10) {
                case 12: goto L_0x0021;
                case 13: goto L_0x0037;
                case 14: goto L_0x0037;
                default: goto L_0x0020;
            }
        L_0x0020:
            goto L_0x0058
        L_0x0021:
            r9 = 34
            r12 = 38
            r13 = 7
            int r14 = r9 * r9
            int r14 = r14 * r9
            int r0 = r12 * r12
            int r0 = r0 * r12
            int r14 = r14 + r0
            int r0 = r13 * r13
            int r0 = r0 * r13
            int r14 = r14 + r0
            int r9 = r9 * r12
            int r9 = r9 * r13
            int r9 = r9 * 3
            if (r14 >= r9) goto L_0x0043
        L_0x0037:
            r9 = 16
            int r10 = 16 - r11
            int r10 = r10 * r9
            int r9 = r9 * 2
            int r9 = r9 - r11
            int r10 = r10 * r9
            int r10 = r10 % 6
            goto L_0x0058
        L_0x0043:
            switch(r10) {
                case 13: goto L_0x004f;
                case 14: goto L_0x0058;
                case 15: goto L_0x0047;
                default: goto L_0x0046;
            }
        L_0x0046:
            goto L_0x0021
        L_0x0047:
            r9 = 9
            int r9 = r9 + r11
            int r9 = r9 * 9
            int r9 = r9 % 2
            goto L_0x0058
        L_0x004f:
            r9 = 94
            int r9 = r9 + r11
            int r9 = r9 * 94
            int r9 = r9 % 2
            if (r9 == 0) goto L_0x0014
        L_0x0058:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.c.c.a(android.content.Context, com.bytedance.sdk.openadsdk.core.model.n, java.lang.String, long, boolean):void");
    }

    @JProtect
    public static void a(Context context, n nVar, String str, x xVar) {
        if (nVar == null) {
            while (true) {
                switch (95) {
                    case 94:
                        if ((((30 - 1) * 30) * ((30 * 2) - 1)) % 6 == 0) {
                            return;
                        }
                        return;
                    case 95:
                        return;
                    case 96:
                        if ((84 * 84 * 84) + (42 * 42 * 42) + (22 * 22 * 22) < 84 * 42 * 22 * 3 && (((70 * 70) + (44 * 44)) - ((70 * 44) * 2) >= 0 || (18 * 18) - ((35 * 35) * 34) != -1 || (26 * 26 * 26) + (9 * 9 * 9) + (15 * 15 * 15) < 26 * 9 * 15 * 3)) {
                            return;
                        }
                }
            }
        } else {
            final long currentTimeMillis = System.currentTimeMillis();
            final Context context2 = context;
            final x xVar2 = xVar;
            final String str2 = str;
            final n nVar2 = nVar;
            a((g) new g(j.j1667305730992dc("sdlgHjgcL|xjxdaa")) {
                /* JADX WARNING: Can't fix incorrect switch cases order */
                /* JADX WARNING: Code restructure failed: missing block: B:18:0x0068, code lost:
                    if (((((26 * 26) * 26) + ((9 * 9) * 9)) + ((15 * 15) * 15)) >= (((26 * 9) * 15) * 3)) goto L_0x0000;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:20:0x0074, code lost:
                    if (((((40 - 1) * 40) * ((40 * 2) - 1)) % 6) == 0) goto L_0x0000;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:78:0x0000, code lost:
                    continue;
                 */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public void run() {
                    /*
                        r12 = this;
                    L_0x0000:
                        r0 = 53
                        r1 = 3
                        r2 = -1
                        r3 = 2
                        r4 = 1
                        switch(r0) {
                            case 52: goto L_0x0016;
                            case 53: goto L_0x0021;
                            case 54: goto L_0x000a;
                            default: goto L_0x0009;
                        }
                    L_0x0009:
                        goto L_0x0000
                    L_0x000a:
                        r0 = 61
                        int r0 = r0 * r0
                        r5 = 12
                        int r5 = r5 * r5
                        int r5 = r5 * 34
                        int r0 = r0 - r5
                        if (r0 != r2) goto L_0x0000
                        goto L_0x0076
                    L_0x0016:
                        r5 = 13
                        int r5 = r5 * r5
                        r6 = 19
                        int r6 = r6 * r6
                        int r6 = r6 * 34
                        int r5 = r5 - r6
                        if (r5 != r2) goto L_0x0016
                    L_0x0021:
                        r5 = 49
                        r6 = 60
                        switch(r6) {
                            case 60: goto L_0x0029;
                            case 61: goto L_0x0054;
                            case 62: goto L_0x006a;
                            default: goto L_0x0028;
                        }
                    L_0x0028:
                        goto L_0x0021
                    L_0x0029:
                        switch(r5) {
                            case 49: goto L_0x0076;
                            case 50: goto L_0x002d;
                            case 51: goto L_0x002d;
                            default: goto L_0x002c;
                        }
                    L_0x002c:
                        goto L_0x0054
                    L_0x002d:
                        r5 = 87
                        int r6 = 87 - r4
                        int r6 = r6 * r5
                        int r5 = r5 * r3
                        int r5 = r5 - r4
                        int r6 = r6 * r5
                        int r6 = r6 % 6
                        if (r6 == 0) goto L_0x003a
                        goto L_0x0076
                    L_0x003a:
                        r5 = r0
                    L_0x003b:
                        switch(r5) {
                            case 55: goto L_0x003f;
                            case 56: goto L_0x0047;
                            case 57: goto L_0x0021;
                            default: goto L_0x003e;
                        }
                    L_0x003e:
                        goto L_0x0051
                    L_0x003f:
                        r5 = 94
                        int r5 = r5 + r4
                        int r5 = r5 * 94
                        int r5 = r5 % r3
                        if (r5 == 0) goto L_0x0076
                    L_0x0047:
                        r5 = 18
                        int r5 = r5 * r5
                        r6 = 35
                        int r6 = r6 * r6
                        int r6 = r6 * 34
                        int r5 = r5 - r6
                        goto L_0x0021
                    L_0x0051:
                        r5 = 56
                        goto L_0x003b
                    L_0x0054:
                        r0 = 26
                        r5 = 9
                        r6 = 15
                        int r7 = r0 * r0
                        int r7 = r7 * r0
                        int r8 = r5 * r5
                        int r8 = r8 * r5
                        int r7 = r7 + r8
                        int r8 = r6 * r6
                        int r8 = r8 * r6
                        int r7 = r7 + r8
                        int r0 = r0 * r5
                        int r0 = r0 * r6
                        int r0 = r0 * r1
                        if (r7 >= r0) goto L_0x0000
                    L_0x006a:
                        r0 = 40
                        int r5 = 40 - r4
                        int r5 = r5 * r0
                        int r0 = r0 * r3
                        int r0 = r0 - r4
                        int r5 = r5 * r0
                        int r5 = r5 % 6
                        if (r5 == 0) goto L_0x0000
                    L_0x0076:
                        android.content.Context r0 = r2
                        if (r0 != 0) goto L_0x007b
                        return
                    L_0x007b:
                        com.bytedance.sdk.openadsdk.core.settings.j r0 = com.bytedance.sdk.openadsdk.core.m.d()
                        boolean r0 = r0.O()
                        if (r0 != 0) goto L_0x0086
                        return
                    L_0x0086:
                        org.json.JSONObject r11 = new org.json.JSONObject
                        r11.<init>()
                        java.lang.String r0 = "dtpbplii"
                        java.lang.String r0 = com.bytedance.sdk.component.f.c.a.a1667305730924dc(r0)     // Catch:{ all -> 0x009b }
                        com.bytedance.sdk.openadsdk.l.x r5 = r3     // Catch:{ all -> 0x009b }
                        long r5 = r5.c()     // Catch:{ all -> 0x009b }
                        r11.put(r0, r5)     // Catch:{ all -> 0x009b }
                        goto L_0x009f
                    L_0x009b:
                        r0 = move-exception
                        r0.printStackTrace()
                    L_0x009f:
                        java.lang.String r0 = r4
                        int r5 = r0.hashCode()
                        r6 = 5
                        r7 = 4
                        switch(r5) {
                            case -1695837674: goto L_0x00f1;
                            case -1364000502: goto L_0x00e3;
                            case -764631662: goto L_0x00d5;
                            case -712491894: goto L_0x00c7;
                            case 1844104722: goto L_0x00b9;
                            case 1912999166: goto L_0x00ab;
                            default: goto L_0x00aa;
                        }
                    L_0x00aa:
                        goto L_0x00ff
                    L_0x00ab:
                        java.lang.String r5 = "dsct[db"
                        java.lang.String r5 = com.bytedance.sdk.component.f.c.a.a1667305730924dc(r5)
                        boolean r0 = r0.equals(r5)
                        if (r0 == 0) goto L_0x00ff
                        r0 = r6
                        goto L_0x0100
                    L_0x00b9:
                        java.lang.String r5 = "iovfvdesafd"
                        java.lang.String r5 = com.bytedance.sdk.component.adexpress.widget.DynamicUnlockView.DynamicUnlockView1667305730929dc(r5)
                        boolean r0 = r0.equals(r5)
                        if (r0 == 0) goto L_0x00ff
                        r0 = r4
                        goto L_0x0100
                    L_0x00c7:
                        java.lang.String r5 = "el`f``bXim"
                        java.lang.String r5 = com.bytedance.sdk.component.adexpress.widget.DynamicUnlockView.DynamicUnlockView1667305730929dc(r5)
                        boolean r0 = r0.equals(r5)
                        if (r0 == 0) goto L_0x00ff
                        r0 = r3
                        goto L_0x0100
                    L_0x00d5:
                        java.lang.String r5 = "ftnowftbmgUbbyk}ce{g}tzHy}"
                        java.lang.String r5 = com.bytedance.sdk.component.adexpress.widget.DynamicUnlockView.DynamicUnlockView1667305730929dc(r5)
                        boolean r0 = r0.equals(r5)
                        if (r0 == 0) goto L_0x00ff
                        r0 = r7
                        goto L_0x0100
                    L_0x00e3:
                        java.lang.String r5 = "rdubvaccWcoib"
                        java.lang.String r5 = com.bytedance.sdk.component.adexpress.widget.DynamicUnlockView.DynamicUnlockView1667305730929dc(r5)
                        boolean r0 = r0.equals(r5)
                        if (r0 == 0) goto L_0x00ff
                        r0 = r1
                        goto L_0x0100
                    L_0x00f1:
                        java.lang.String r5 = "b`lmawYfl"
                        java.lang.String r5 = com.bytedance.sdk.component.adexpress.widget.DynamicUnlockView.DynamicUnlockView1667305730929dc(r5)
                        boolean r0 = r0.equals(r5)
                        if (r0 == 0) goto L_0x00ff
                        r0 = 0
                        goto L_0x0100
                    L_0x00ff:
                        r0 = r2
                    L_0x0100:
                        if (r0 == 0) goto L_0x011f
                        if (r0 == r4) goto L_0x011c
                        if (r0 == r3) goto L_0x0119
                        if (r0 == r1) goto L_0x0116
                        if (r0 == r7) goto L_0x0113
                        if (r0 == r6) goto L_0x0110
                        java.lang.String r0 = ""
                    L_0x010e:
                        r10 = r0
                        goto L_0x0126
                    L_0x0110:
                        java.lang.String r0 = "dsct[dbXdfkoxdcj"
                        goto L_0x0121
                    L_0x0113:
                        java.lang.String r0 = "ftnowftbmgUbbyk}ce{g}tzHy}Ews|zkILG"
                        goto L_0x0121
                    L_0x0116:
                        java.lang.String r0 = "rdubvaccWcoibQcpvg}xs"
                        goto L_0x0121
                    L_0x0119:
                        java.lang.String r0 = "el`f``bXimUgclj{y|w"
                        goto L_0x0121
                    L_0x011c:
                        java.lang.String r0 = "iovfvdesafdT`bokdxv"
                        goto L_0x0121
                    L_0x011f:
                        java.lang.String r0 = "b`lmawYflVfdmizf}t"
                    L_0x0121:
                        java.lang.String r0 = com.bytedance.sdk.component.adexpress.widget.DynamicUnlockView.DynamicUnlockView1667305730929dc(r0)
                        goto L_0x010e
                    L_0x0126:
                        long r5 = r5
                        android.content.Context r7 = r2
                        com.bytedance.sdk.openadsdk.core.model.n r8 = r7
                        java.lang.String r9 = r4
                        com.bytedance.sdk.openadsdk.c.c.b((long) r5, (android.content.Context) r7, (com.bytedance.sdk.openadsdk.core.model.n) r8, (java.lang.String) r9, (java.lang.String) r10, (org.json.JSONObject) r11)
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.c.c.AnonymousClass2.run():void");
                }
            });
        }
    }

    public static void a(Context context, n nVar, String str, String str2) {
        if (nVar != null) {
            b(System.currentTimeMillis(), context, nVar, str, str2);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x003d, code lost:
        r1 = 'R';
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x003e, code lost:
        switch(r1) {
            case 70: goto L_0x0042;
            case 71: goto L_0x004a;
            case 72: goto L_0x0060;
            default: goto L_0x0041;
        };
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0044, code lost:
        if (82 <= 18) goto L_0x006e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0047, code lost:
        r1 = 'G';
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x005e, code lost:
        if ((((64 * 64) + (38 * 38)) + (4 * 4)) >= (((64 * 38) + (38 * 4)) + (64 * 4))) goto L_0x000a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x006c, code lost:
        if ((((84 * 84) + (7 * 7)) - ((84 * 7) * 2)) >= 0) goto L_0x0082;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0076, code lost:
        if ((((17 + 1) * 17) % 2) == 0) goto L_0x0003;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0080, code lost:
        if ((((45 + 1) * 45) % 2) == 0) goto L_0x000d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:3:0x000a, code lost:
        r3 = r12;
        r7 = r14;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000d, code lost:
        switch(82) {
            case 82: goto L_0x00fd;
            case 83: goto L_0x0013;
            case 84: goto L_0x0025;
            default: goto L_0x0010;
        };
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x0003, code lost:
        continue;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0010, code lost:
        r3 = r12;
        r7 = r14;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0013, code lost:
        r6 = (11 * 11) * 11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0023, code lost:
        if (((((55 * 55) * 55) + r6) + r6) >= (((55 * 11) * 11) * 3)) goto L_0x004a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x003a, code lost:
        if (((((13 * 13) * 13) + ((9 * 9) * 9)) + ((8 * 8) * 8)) >= (((13 * 9) * 8) * 3)) goto L_0x003d;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(android.content.Context r8, com.bytedance.sdk.openadsdk.core.model.n r9, java.lang.String r10, java.lang.String r11, long r12, int r14, java.util.Map<java.lang.String, java.lang.Object> r15, com.bytedance.sdk.openadsdk.c.f r16) {
        /*
            r5 = r11
            r0 = r16
        L_0x0003:
            r1 = 80
            r2 = 82
        L_0x0007:
            switch(r1) {
                case 80: goto L_0x000d;
                case 81: goto L_0x0003;
                case 82: goto L_0x0082;
                default: goto L_0x000a;
            }
        L_0x000a:
            r3 = r12
            r7 = r14
            goto L_0x0003
        L_0x000d:
            switch(r2) {
                case 82: goto L_0x00fd;
                case 83: goto L_0x0013;
                case 84: goto L_0x0025;
                default: goto L_0x0010;
            }
        L_0x0010:
            r3 = r12
            r7 = r14
            goto L_0x000d
        L_0x0013:
            r1 = 55
            int r3 = r1 * r1
            int r3 = r3 * r1
            r4 = 11
            int r6 = r4 * r4
            int r6 = r6 * r4
            int r3 = r3 + r6
            int r3 = r3 + r6
            int r1 = r1 * r4
            int r1 = r1 * r4
            int r1 = r1 * 3
            if (r3 >= r1) goto L_0x004a
        L_0x0025:
            r1 = 13
            r3 = 9
            r4 = 8
            int r6 = r1 * r1
            int r6 = r6 * r1
            int r7 = r3 * r3
            int r7 = r7 * r3
            int r6 = r6 + r7
            int r7 = r4 * r4
            int r7 = r7 * r4
            int r6 = r6 + r7
            int r1 = r1 * r3
            int r1 = r1 * r4
            int r1 = r1 * 3
            if (r6 >= r1) goto L_0x003d
            goto L_0x000d
        L_0x003d:
            r1 = r2
        L_0x003e:
            switch(r1) {
                case 70: goto L_0x0042;
                case 71: goto L_0x004a;
                case 72: goto L_0x0060;
                default: goto L_0x0041;
            }
        L_0x0041:
            goto L_0x0047
        L_0x0042:
            r1 = 18
            if (r2 <= r1) goto L_0x006e
            goto L_0x0078
        L_0x0047:
            r1 = 71
            goto L_0x003e
        L_0x004a:
            r1 = 64
            r3 = 38
            r4 = 4
            int r6 = r1 * r1
            int r7 = r3 * r3
            int r6 = r6 + r7
            int r7 = r4 * r4
            int r6 = r6 + r7
            r7 = 64
            int r7 = r7 * r3
            int r3 = r3 * r4
            int r7 = r7 + r3
            int r1 = r1 * r4
            int r7 = r7 + r1
            if (r6 >= r7) goto L_0x000a
        L_0x0060:
            r1 = 84
            r3 = 7
            int r4 = r1 * r1
            int r6 = r3 * r3
            int r4 = r4 + r6
            int r1 = r1 * r3
            int r1 = r1 * 2
            int r4 = r4 - r1
            if (r4 >= 0) goto L_0x0082
        L_0x006e:
            r1 = 17
            int r1 = r1 + 1
            int r1 = r1 * 17
            int r1 = r1 % 2
            if (r1 == 0) goto L_0x0003
        L_0x0078:
            r1 = 45
            int r1 = r1 + 1
            int r1 = r1 * 45
            int r1 = r1 % 2
            if (r1 == 0) goto L_0x000d
        L_0x0082:
            if (r9 != 0) goto L_0x0085
            return
        L_0x0085:
            org.json.JSONObject r6 = new org.json.JSONObject
            r6.<init>()
            org.json.JSONObject r1 = new org.json.JSONObject
            r1.<init>()
            java.lang.String r2 = "dtpbplii"
            java.lang.String r2 = com.bytedance.sdk.component.f.c.e.e1667305730908dc(r2)     // Catch:{ all -> 0x00f1 }
            r3 = r12
            r6.put(r2, r12)     // Catch:{ all -> 0x00f1 }
            java.lang.String r2 = "pdp`akr"
            java.lang.String r2 = com.bytedance.sdk.component.f.c.e.e1667305730908dc(r2)     // Catch:{ all -> 0x00f1 }
            r7 = r14
            r6.put(r2, r14)     // Catch:{ all -> 0x00f1 }
            if (r15 == 0) goto L_0x00c7
            java.util.Set r2 = r15.entrySet()     // Catch:{ all -> 0x00f1 }
            java.util.Iterator r2 = r2.iterator()     // Catch:{ all -> 0x00f1 }
        L_0x00ad:
            boolean r3 = r2.hasNext()     // Catch:{ all -> 0x00f1 }
            if (r3 == 0) goto L_0x00c7
            java.lang.Object r3 = r2.next()     // Catch:{ all -> 0x00f1 }
            java.util.Map$Entry r3 = (java.util.Map.Entry) r3     // Catch:{ all -> 0x00f1 }
            java.lang.Object r4 = r3.getKey()     // Catch:{ all -> 0x00f1 }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ all -> 0x00f1 }
            java.lang.Object r3 = r3.getValue()     // Catch:{ all -> 0x00f1 }
            r1.put(r4, r3)     // Catch:{ all -> 0x00f1 }
            goto L_0x00ad
        L_0x00c7:
            java.lang.String r2 = "fdgg[gtbib"
            java.lang.String r2 = com.bytedance.sdk.component.f.c.e.e1667305730908dc(r2)     // Catch:{ all -> 0x00f1 }
            boolean r2 = r2.equals(r11)     // Catch:{ all -> 0x00f1 }
            if (r2 != 0) goto L_0x00df
            java.lang.String r2 = "fdgg[jpbz"
            java.lang.String r2 = com.bytedance.sdk.component.f.c.e.e1667305730908dc(r2)     // Catch:{ all -> 0x00f1 }
            boolean r2 = r2.equals(r11)     // Catch:{ all -> 0x00f1 }
            if (r2 == 0) goto L_0x00e4
        L_0x00df:
            if (r0 == 0) goto L_0x00e4
            r0.a((org.json.JSONObject) r1)     // Catch:{ all -> 0x00f1 }
        L_0x00e4:
            java.lang.String r0 = "ae]f|qtfWmkm"
            java.lang.String r0 = com.bytedance.sdk.component.f.c.e.e1667305730908dc(r0)     // Catch:{ all -> 0x00f1 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x00f1 }
            r6.put(r0, r1)     // Catch:{ all -> 0x00f1 }
        L_0x00f1:
            long r0 = java.lang.System.currentTimeMillis()
            r2 = r8
            r3 = r9
            r4 = r10
            r5 = r11
            b((long) r0, (android.content.Context) r2, (com.bytedance.sdk.openadsdk.core.model.n) r3, (java.lang.String) r4, (java.lang.String) r5, (org.json.JSONObject) r6)
            return
        L_0x00fd:
            r3 = r12
            r7 = r14
            r1 = r2
            goto L_0x0007
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.c.c.a(android.content.Context, com.bytedance.sdk.openadsdk.core.model.n, java.lang.String, java.lang.String, long, int, java.util.Map, com.bytedance.sdk.openadsdk.c.f):void");
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP_START, MTH_ENTER_BLOCK] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0041 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0041 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0019 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x002e A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0038 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0077 A[SYNTHETIC] */
    public static void a(android.content.Context r7, com.bytedance.sdk.openadsdk.core.model.n r8, java.lang.String r9, java.lang.String r10, long r11, org.json.JSONObject r13) {
        /*
        L_0x0000:
            r0 = 92
        L_0x0002:
            r1 = 14
            r2 = 15
        L_0x0006:
            r3 = 12
            switch(r1) {
                case 13: goto L_0x0010;
                case 14: goto L_0x0077;
                case 15: goto L_0x000c;
                default: goto L_0x000b;
            }
        L_0x000b:
            goto L_0x0002
        L_0x000c:
            switch(r0) {
                case 94: goto L_0x0077;
                case 95: goto L_0x0041;
                case 96: goto L_0x0077;
                default: goto L_0x000f;
            }
        L_0x000f:
            goto L_0x0015
        L_0x0010:
            r1 = 72
            if (r0 < r1) goto L_0x0015
            goto L_0x0077
        L_0x0015:
            switch(r3) {
                case 55: goto L_0x0019;
                case 56: goto L_0x002e;
                case 57: goto L_0x0038;
                default: goto L_0x0018;
            }
        L_0x0018:
            goto L_0x0077
        L_0x0019:
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
            if (r3 >= r0) goto L_0x0041
        L_0x002e:
            r0 = 90
            int r0 = r0 + 1
            int r0 = r0 * 90
            int r0 = r0 % 2
            if (r0 == 0) goto L_0x0000
        L_0x0038:
            r0 = 15
            int r0 = r0 + 1
            int r0 = r0 * r2
            int r0 = r0 % 2
            if (r0 == 0) goto L_0x0019
        L_0x0041:
            r2 = r7
            r3 = r8
            r4 = r9
            r5 = r10
            if (r3 != 0) goto L_0x0048
            return
        L_0x0048:
            if (r2 == 0) goto L_0x0076
            if (r3 == 0) goto L_0x0076
            if (r13 != 0) goto L_0x004f
            goto L_0x0076
        L_0x004f:
            org.json.JSONObject r6 = new org.json.JSONObject
            r6.<init>()
            java.lang.String r7 = "dtpbplii"
            java.lang.String r7 = com.bytedance.sdk.component.f.c.d.d1667305730926dc(r7)     // Catch:{ Exception -> 0x006b }
            r6.put(r7, r11)     // Catch:{ Exception -> 0x006b }
            java.lang.String r7 = "ae]f|qtfWmkm"
            java.lang.String r7 = com.bytedance.sdk.component.f.c.d.d1667305730926dc(r7)     // Catch:{ Exception -> 0x006b }
            java.lang.String r8 = r13.toString()     // Catch:{ Exception -> 0x006b }
            r6.put(r7, r8)     // Catch:{ Exception -> 0x006b }
            goto L_0x006f
        L_0x006b:
            r7 = move-exception
            r7.printStackTrace()
        L_0x006f:
            long r0 = java.lang.System.currentTimeMillis()
            b((long) r0, (android.content.Context) r2, (com.bytedance.sdk.openadsdk.core.model.n) r3, (java.lang.String) r4, (java.lang.String) r5, (org.json.JSONObject) r6)
        L_0x0076:
            return
        L_0x0077:
            r0 = 95
            r1 = r2
            goto L_0x0006
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.c.c.a(android.content.Context, com.bytedance.sdk.openadsdk.core.model.n, java.lang.String, java.lang.String, long, org.json.JSONObject):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x003a, code lost:
        if (((13 * 13) - ((19 * 19) * 34)) != -1) goto L_0x0015;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0043, code lost:
        if ((((10 + 1) * 10) % 2) == 0) goto L_0x0015;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0045, code lost:
        r15 = r3;
        r11 = r6;
        r12 = r7;
        r13 = r8;
        r14 = r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x004b, code lost:
        if (r7 != null) goto L_0x004e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x004d, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x004e, code lost:
        r11 = new org.json.JSONObject();
        r10 = new org.json.JSONObject();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0058, code lost:
        if (r3 == null) goto L_0x007c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
        r12 = r3.entrySet().iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0066, code lost:
        if (r12.hasNext() == false) goto L_0x007c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0068, code lost:
        r13 = r12.next();
        r11.put((java.lang.String) r13.getKey(), r13.getValue());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x007c, code lost:
        r10.put(com.bytedance.sdk.component.a.j.j1667305730992dc("ae]f|qtfWmkm"), r11.toString());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x008a, code lost:
        r11 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x008b, code lost:
        com.bytedance.sdk.component.utils.l.d(r11.toString());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0092, code lost:
        b(java.lang.System.currentTimeMillis(), r6, r7, r8, r9, r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0099, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x009a, code lost:
        r15 = r3;
        r11 = r6;
        r12 = r7;
        r13 = r8;
        r14 = r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00a1, code lost:
        switch(r0) {
            case 39: goto L_0x00a5;
            case 40: goto L_0x00b4;
            case 41: goto L_0x00cb;
            default: goto L_0x00a4;
        };
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00b2, code lost:
        if ((((12 * 12) + (14 * 14)) - ((12 * 14) * 2)) >= 0) goto L_0x0000;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00c9, code lost:
        if ((((54 * 54) + (27 * 27)) + (24 * 24)) >= (((54 * 27) + (27 * 24)) + (54 * 24))) goto L_0x0000;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00cb, code lost:
        r3 = (((94 * 94) * 94) + ((17 * 17) * 17)) + ((7 * 7) * 7);
        r0 = ((94 * 17) * 7) * 3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00e1, code lost:
        r0 = '\'';
     */
    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0010, code lost:
        r6 = r11;
        r7 = r12;
        r8 = r13;
        r9 = r14;
        r3 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0017, code lost:
        switch(53) {
            case 52: goto L_0x009a;
            case 53: goto L_0x004b;
            case 54: goto L_0x001b;
            default: goto L_0x001a;
        };
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x001b, code lost:
        switch(87) {
            case 29: goto L_0x0025;
            case 30: goto L_0x0030;
            case 31: goto L_0x003c;
            default: goto L_0x001e;
        };
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x001e, code lost:
        r15 = r3;
        r11 = r6;
        r12 = r7;
        r13 = r8;
        r14 = r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0025, code lost:
        r11 = (((87 - 1) * 87) * ((87 * 2) - 1)) % 6;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(android.content.Context r11, com.bytedance.sdk.openadsdk.core.model.n r12, java.lang.String r13, java.lang.String r14, java.util.Map<java.lang.String, java.lang.Object> r15) {
        /*
        L_0x0000:
            r0 = 72
            r1 = 87
            r2 = 1
            switch(r1) {
                case 85: goto L_0x00a1;
                case 86: goto L_0x0009;
                case 87: goto L_0x0010;
                default: goto L_0x0008;
            }
        L_0x0008:
            goto L_0x0000
        L_0x0009:
            r3 = 90
            int r3 = r3 + r2
            int r3 = r3 * 90
            int r3 = r3 % 2
        L_0x0010:
            r6 = r11
            r7 = r12
            r8 = r13
            r9 = r14
            r3 = r15
        L_0x0015:
            r11 = 53
            switch(r11) {
                case 52: goto L_0x009a;
                case 53: goto L_0x004b;
                case 54: goto L_0x001b;
                default: goto L_0x001a;
            }
        L_0x001a:
            goto L_0x0015
        L_0x001b:
            switch(r1) {
                case 29: goto L_0x0025;
                case 30: goto L_0x0030;
                case 31: goto L_0x003c;
                default: goto L_0x001e;
            }
        L_0x001e:
            r15 = r3
            r11 = r6
            r12 = r7
            r13 = r8
            r14 = r9
            goto L_0x00a1
        L_0x0025:
            int r11 = 87 - r2
            int r11 = r11 * r1
            r12 = 87
            int r12 = r12 * 2
            int r12 = r12 - r2
            int r11 = r11 * r12
            int r11 = r11 % 6
        L_0x0030:
            r11 = 13
            int r11 = r11 * r11
            r12 = 19
            int r12 = r12 * r12
            int r12 = r12 * 34
            int r11 = r11 - r12
            r12 = -1
            if (r11 != r12) goto L_0x0015
        L_0x003c:
            r11 = 10
            int r11 = r11 + r2
            int r11 = r11 * 10
            int r11 = r11 % 2
            if (r11 == 0) goto L_0x0015
            r15 = r3
            r11 = r6
            r12 = r7
            r13 = r8
            r14 = r9
            goto L_0x00a5
        L_0x004b:
            if (r7 != 0) goto L_0x004e
            return
        L_0x004e:
            org.json.JSONObject r11 = new org.json.JSONObject
            r11.<init>()
            org.json.JSONObject r10 = new org.json.JSONObject
            r10.<init>()
            if (r3 == 0) goto L_0x007c
            java.util.Set r12 = r3.entrySet()     // Catch:{ all -> 0x008a }
            java.util.Iterator r12 = r12.iterator()     // Catch:{ all -> 0x008a }
        L_0x0062:
            boolean r13 = r12.hasNext()     // Catch:{ all -> 0x008a }
            if (r13 == 0) goto L_0x007c
            java.lang.Object r13 = r12.next()     // Catch:{ all -> 0x008a }
            java.util.Map$Entry r13 = (java.util.Map.Entry) r13     // Catch:{ all -> 0x008a }
            java.lang.Object r14 = r13.getKey()     // Catch:{ all -> 0x008a }
            java.lang.String r14 = (java.lang.String) r14     // Catch:{ all -> 0x008a }
            java.lang.Object r13 = r13.getValue()     // Catch:{ all -> 0x008a }
            r11.put(r14, r13)     // Catch:{ all -> 0x008a }
            goto L_0x0062
        L_0x007c:
            java.lang.String r12 = "ae]f|qtfWmkm"
            java.lang.String r12 = com.bytedance.sdk.component.a.j.j1667305730992dc(r12)     // Catch:{ all -> 0x008a }
            java.lang.String r11 = r11.toString()     // Catch:{ all -> 0x008a }
            r10.put(r12, r11)     // Catch:{ all -> 0x008a }
            goto L_0x0092
        L_0x008a:
            r11 = move-exception
            java.lang.String r11 = r11.toString()
            com.bytedance.sdk.component.utils.l.d(r11)
        L_0x0092:
            long r4 = java.lang.System.currentTimeMillis()
            b((long) r4, (android.content.Context) r6, (com.bytedance.sdk.openadsdk.core.model.n) r7, (java.lang.String) r8, (java.lang.String) r9, (org.json.JSONObject) r10)
            return
        L_0x009a:
            r15 = r3
            r11 = r6
            r12 = r7
            r13 = r8
            r14 = r9
            goto L_0x0000
        L_0x00a1:
            switch(r0) {
                case 39: goto L_0x00a5;
                case 40: goto L_0x00b4;
                case 41: goto L_0x00cb;
                default: goto L_0x00a4;
            }
        L_0x00a4:
            goto L_0x00e1
        L_0x00a5:
            r0 = 12
            r1 = 14
            int r2 = r0 * r0
            int r3 = r1 * r1
            int r2 = r2 + r3
            int r0 = r0 * r1
            int r0 = r0 * 2
            int r2 = r2 - r0
            if (r2 >= 0) goto L_0x0000
        L_0x00b4:
            r0 = 54
            r1 = 27
            r2 = 24
            int r3 = r0 * r0
            int r4 = r1 * r1
            int r3 = r3 + r4
            int r4 = r2 * r2
            int r3 = r3 + r4
            r4 = 54
            int r4 = r4 * r1
            int r1 = r1 * r2
            int r4 = r4 + r1
            int r0 = r0 * r2
            int r4 = r4 + r0
            if (r3 >= r4) goto L_0x0000
        L_0x00cb:
            r0 = 94
            r1 = 17
            r2 = 7
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
            goto L_0x0000
        L_0x00e1:
            r0 = 39
            goto L_0x00a1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.c.c.a(android.content.Context, com.bytedance.sdk.openadsdk.core.model.n, java.lang.String, java.lang.String, java.util.Map):void");
    }

    public static void a(Context context, n nVar, String str, String str2, JSONObject jSONObject) {
        while (true) {
            char c = '_';
            boolean z = true;
            while (true) {
                switch (c) {
                    case '^':
                        if (!z) {
                            break;
                        } else {
                            continue;
                        }
                    case '_':
                        switch (z) {
                            case true:
                            case true:
                                continue;
                            case true:
                                break;
                        }
                    case '`':
                        break;
                }
                switch (z) {
                    case true:
                    case true:
                    case true:
                        break;
                }
                c = '^';
                z = true;
            }
        }
        if (nVar != null) {
            if (jSONObject != null) {
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put(DynamicUnlockView.DynamicUnlockView1667305730929dc("ae]f|qtfWmkm"), jSONObject.toString());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                b(System.currentTimeMillis(), context, nVar, str, str2, jSONObject2);
            } else {
                b(System.currentTimeMillis(), context, nVar, str, str2);
            }
            if (DynamicUnlockView.DynamicUnlockView1667305730929dc("cmk`o").equals(str2)) {
                p.c(nVar);
            }
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0017, code lost:
        if (((18 * 18) - ((35 * 35) * 34)) == -1) goto L_0x0019;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x002e, code lost:
        if (((((26 * 26) * 26) + ((9 * 9) * 9)) + ((15 * 15) * 15)) < (((26 * 9) * 15) * 3)) goto L_0x0030;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(android.content.Context r9, com.bytedance.sdk.openadsdk.core.model.n r10, java.lang.String r11, java.lang.String r12, org.json.JSONObject r13, long r14) {
        /*
        L_0x0000:
            r0 = 37
            r1 = 54
            r2 = 1
            switch(r1) {
                case 52: goto L_0x0009;
                case 53: goto L_0x003c;
                case 54: goto L_0x0049;
                default: goto L_0x0008;
            }
        L_0x0008:
            goto L_0x0000
        L_0x0009:
            switch(r0) {
                case 94: goto L_0x000d;
                case 95: goto L_0x0019;
                case 96: goto L_0x0030;
                default: goto L_0x000c;
            }
        L_0x000c:
            goto L_0x003c
        L_0x000d:
            r0 = 18
            int r0 = r0 * r0
            r1 = 35
            int r1 = r1 * r1
            int r1 = r1 * 34
            int r0 = r0 - r1
            r1 = -1
            if (r0 != r1) goto L_0x0049
        L_0x0019:
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
            if (r4 >= r0) goto L_0x0049
        L_0x0030:
            r0 = 40
            int r1 = 40 - r2
            int r1 = r1 * r0
            int r0 = r0 * 2
            int r0 = r0 - r2
            int r1 = r1 * r0
            int r1 = r1 % 6
            goto L_0x0049
        L_0x003c:
            r0 = 30
            int r1 = 30 - r2
            int r1 = r1 * r0
            int r0 = r0 * 2
            int r0 = r0 - r2
            int r1 = r1 * r0
            int r1 = r1 % 6
            if (r1 == 0) goto L_0x0000
        L_0x0049:
            if (r10 != 0) goto L_0x004c
            return
        L_0x004c:
            if (r9 == 0) goto L_0x0079
            if (r10 == 0) goto L_0x0079
            if (r13 != 0) goto L_0x0053
            goto L_0x0079
        L_0x0053:
            org.json.JSONObject r8 = new org.json.JSONObject
            r8.<init>()
            java.lang.String r0 = "ae]f|qtfWmkm"
            java.lang.String r0 = com.bytedance.sdk.component.f.c.d.d1667305730926dc(r0)     // Catch:{ all -> 0x006e }
            java.lang.String r13 = r13.toString()     // Catch:{ all -> 0x006e }
            r8.put(r0, r13)     // Catch:{ all -> 0x006e }
            java.lang.String r13 = "dtpbplii"
            java.lang.String r13 = com.bytedance.sdk.component.f.c.d.d1667305730926dc(r13)     // Catch:{ all -> 0x006e }
            r8.put(r13, r14)     // Catch:{ all -> 0x006e }
        L_0x006e:
            long r2 = java.lang.System.currentTimeMillis()
            r4 = r9
            r5 = r10
            r6 = r11
            r7 = r12
            b((long) r2, (android.content.Context) r4, (com.bytedance.sdk.openadsdk.core.model.n) r5, (java.lang.String) r6, (java.lang.String) r7, (org.json.JSONObject) r8)
        L_0x0079:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.c.c.a(android.content.Context, com.bytedance.sdk.openadsdk.core.model.n, java.lang.String, java.lang.String, org.json.JSONObject, long):void");
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0098, code lost:
        if (((((26 * 26) * 26) + ((9 * 9) * 9)) + ((15 * 15) * 15)) >= (((26 * 9) * 15) * 3)) goto L_0x00b2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0031, code lost:
        r8 = ((10 + 1) * 10) % 2;
     */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x00b3 A[LOOP:3: B:14:0x0071->B:24:0x00b3, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x001b A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0075 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x007f A[SYNTHETIC] */
    @com.bytedance.JProtect
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(android.content.Context r8, com.bytedance.sdk.openadsdk.core.model.n r9, java.lang.String r10, java.util.Map<java.lang.String, java.lang.Object> r11, java.lang.Double r12) {
        /*
            if (r9 != 0) goto L_0x0004
            goto L_0x00b2
        L_0x0004:
            long r6 = java.lang.System.currentTimeMillis()
            com.bytedance.sdk.openadsdk.c.c$1 r8 = new com.bytedance.sdk.openadsdk.c.c$1
            java.lang.String r0 = "ooQkkr"
            java.lang.String r1 = com.bytedance.sdk.component.a.j.j1667305730992dc(r0)
            r0 = r8
            r2 = r9
            r3 = r11
            r4 = r12
            r5 = r10
            r0.<init>(r1, r2, r3, r4, r5, r6)
            a((com.bytedance.sdk.component.g.g) r8)
        L_0x001b:
            r8 = 49
            r9 = 52
            r10 = 1
            switch(r8) {
                case 49: goto L_0x00bb;
                case 50: goto L_0x0024;
                case 51: goto L_0x0031;
                default: goto L_0x0023;
            }
        L_0x0023:
            goto L_0x001b
        L_0x0024:
            r11 = 13
            int r11 = r11 * r11
            r12 = 19
            int r12 = r12 * r12
            r0 = 34
            int r12 = r12 * r0
            int r11 = r11 - r12
            r12 = -1
            if (r11 != r12) goto L_0x003a
        L_0x0031:
            r8 = 10
            int r8 = r8 + r10
            int r8 = r8 * 10
            int r8 = r8 % 2
            goto L_0x00b2
        L_0x003a:
            r11 = 96
        L_0x003c:
            r1 = 18
            switch(r11) {
                case 94: goto L_0x005a;
                case 95: goto L_0x0071;
                case 96: goto L_0x0043;
                default: goto L_0x0041;
            }
        L_0x0041:
            goto L_0x00b8
        L_0x0043:
            r11 = 69
            r2 = 20
            r3 = 4
            int r4 = r11 * r11
            int r5 = r2 * r2
            int r4 = r4 + r5
            int r5 = r3 * r3
            int r4 = r4 + r5
            r5 = 69
            int r5 = r5 * r2
            int r2 = r2 * r3
            int r5 = r5 + r2
            int r11 = r11 * r3
            int r5 = r5 + r11
            if (r4 >= r5) goto L_0x00b2
            goto L_0x007f
        L_0x005a:
            r11 = 57
            r2 = 12
            int r3 = r11 * r11
            int r4 = r0 * r0
            int r3 = r3 + r4
            int r4 = r2 * r2
            int r3 = r3 + r4
            r4 = 57
            int r4 = r4 * r0
            r5 = 34
            int r5 = r5 * r2
            int r4 = r4 + r5
            int r11 = r11 * r2
            int r4 = r4 + r11
            if (r3 >= r4) goto L_0x001b
        L_0x0071:
            switch(r9) {
                case 55: goto L_0x007f;
                case 56: goto L_0x001b;
                case 57: goto L_0x0075;
                default: goto L_0x0074;
            }
        L_0x0074:
            goto L_0x00b3
        L_0x0075:
            int r11 = r1 * r1
            r2 = 35
            int r2 = r2 * r2
            int r2 = r2 * r0
            int r11 = r11 - r2
            if (r11 != r12) goto L_0x00bb
            goto L_0x0083
        L_0x007f:
            switch(r8) {
                case 60: goto L_0x0083;
                case 61: goto L_0x009a;
                case 62: goto L_0x00a6;
                default: goto L_0x0082;
            }
        L_0x0082:
            goto L_0x001b
        L_0x0083:
            r11 = 26
            r2 = 9
            r3 = 15
            int r4 = r11 * r11
            int r4 = r4 * r11
            int r5 = r2 * r2
            int r5 = r5 * r2
            int r4 = r4 + r5
            int r5 = r3 * r3
            int r5 = r5 * r3
            int r4 = r4 + r5
            int r11 = r11 * r2
            int r11 = r11 * r3
            int r11 = r11 * 3
            if (r4 >= r11) goto L_0x00b2
        L_0x009a:
            r11 = 0
            int r2 = 0 - r10
            int r2 = r2 * r11
            int r11 = r11 * 2
            int r11 = r11 - r10
            int r2 = r2 * r11
            int r2 = r2 % 6
            if (r2 == 0) goto L_0x003a
        L_0x00a6:
            int r8 = 18 - r10
            int r8 = r8 * r1
            int r9 = r1 * 2
            int r9 = r9 - r10
            int r8 = r8 * r9
            int r8 = r8 % 6
            if (r8 == 0) goto L_0x00a6
            goto L_0x00bb
        L_0x00b2:
            return
        L_0x00b3:
            r9 = 55
            r8 = 61
            goto L_0x0071
        L_0x00b8:
            r11 = 94
            goto L_0x003c
        L_0x00bb:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.c.c.a(android.content.Context, com.bytedance.sdk.openadsdk.core.model.n, java.lang.String, java.util.Map, java.lang.Double):void");
    }

    public static void a(Context context, String str, long j) {
        com.bytedance.sdk.openadsdk.core.d.c.a(context, str, j);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x004d, code lost:
        if (((((18 - 1) * 18) * ((18 * 2) - 1)) % 6) == 0) goto L_0x005b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0057, code lost:
        if (((99 * 99) - ((18 * 18) * 34)) != -1) goto L_0x0020;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x005b, code lost:
        r0 = 'I';
        r1 = '`';
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:4:0x002b, code lost:
        switch(r1) {
            case 55: goto L_0x005b;
            case 56: goto L_0x005b;
            case 57: goto L_0x002f;
            default: goto L_0x002e;
        };
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0032, code lost:
        switch(1) {
            case 60: goto L_0x0036;
            case 61: goto L_0x0042;
            case 62: goto L_0x004f;
            default: goto L_0x0035;
        };
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0040, code lost:
        if (((((0 - 1) * 0) * ((0 * 2) - 1)) % 6) == 0) goto L_0x005b;
     */
    @com.bytedance.JProtect
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(android.content.Context r13, java.lang.String r14, com.bytedance.sdk.openadsdk.core.model.n r15, com.bytedance.sdk.openadsdk.core.model.g r16, java.lang.String r17, boolean r18, java.util.Map<java.lang.String, java.lang.Object> r19, int r20) {
        /*
            long r8 = java.lang.System.currentTimeMillis()
            com.bytedance.sdk.openadsdk.c.c$10 r12 = new com.bytedance.sdk.openadsdk.c.c$10
            java.lang.String r0 = "ooAomfm"
            java.lang.String r1 = com.bytedance.sdk.component.adexpress.widget.DynamicUnlockView.DynamicUnlockView1667305730929dc(r0)
            r0 = r12
            r2 = r15
            r3 = r13
            r4 = r16
            r5 = r18
            r6 = r20
            r7 = r19
            r10 = r17
            r11 = r14
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r10, r11)
            a((com.bytedance.sdk.component.g.g) r12)
        L_0x0020:
            r0 = 74
            r1 = 55
        L_0x0024:
            switch(r0) {
                case 72: goto L_0x0020;
                case 73: goto L_0x0028;
                case 74: goto L_0x002b;
                default: goto L_0x0027;
            }
        L_0x0027:
            goto L_0x0060
        L_0x0028:
            switch(r1) {
                case 94: goto L_0x005b;
                case 95: goto L_0x002f;
                case 96: goto L_0x005a;
                default: goto L_0x002b;
            }
        L_0x002b:
            switch(r1) {
                case 55: goto L_0x005b;
                case 56: goto L_0x005b;
                case 57: goto L_0x002f;
                default: goto L_0x002e;
            }
        L_0x002e:
            goto L_0x005b
        L_0x002f:
            r0 = 18
            r1 = 1
            switch(r1) {
                case 60: goto L_0x0036;
                case 61: goto L_0x0042;
                case 62: goto L_0x004f;
                default: goto L_0x0035;
            }
        L_0x0035:
            goto L_0x005a
        L_0x0036:
            r2 = 0
            int r3 = 0 - r1
            int r3 = r3 * r2
            int r2 = r2 * 2
            int r2 = r2 - r1
            int r3 = r3 * r2
            int r3 = r3 % 6
            if (r3 == 0) goto L_0x005b
        L_0x0042:
            int r2 = 18 - r1
            int r2 = r2 * r0
            r3 = 18
            int r3 = r3 * 2
            int r3 = r3 - r1
            int r2 = r2 * r3
            int r2 = r2 % 6
            if (r2 == 0) goto L_0x005b
        L_0x004f:
            r1 = 99
            int r1 = r1 * r1
            int r0 = r0 * r0
            int r0 = r0 * 34
            int r1 = r1 - r0
            r0 = -1
            if (r1 != r0) goto L_0x0020
            goto L_0x005b
        L_0x005a:
            return
        L_0x005b:
            r0 = 73
            r1 = 96
            goto L_0x0024
        L_0x0060:
            r0 = 72
            goto L_0x0024
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.c.c.a(android.content.Context, java.lang.String, com.bytedance.sdk.openadsdk.core.model.n, com.bytedance.sdk.openadsdk.core.model.g, java.lang.String, boolean, java.util.Map, int):void");
    }

    public static void a(g gVar) {
        if (gVar != null) {
            if (w.a()) {
                e.b().execute(gVar);
            } else {
                gVar.run();
            }
        }
    }

    public static void a(AdSlot adSlot) {
        String codeId;
        if (adSlot == null) {
            codeId = "";
        } else if (TextUtils.isEmpty(adSlot.getBidAdm())) {
            codeId = adSlot.getCodeId();
        } else {
            return;
        }
        a(codeId);
    }

    public static void a(n nVar) {
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0030, code lost:
        r1 = (99 * 99) - ((18 * 18) * 34);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0074, code lost:
        r0 = 'I';
        r1 = '`';
     */
    /* JADX WARNING: Code restructure failed: missing block: B:3:0x000c, code lost:
        switch(r1) {
            case 55: goto L_0x0074;
            case 56: goto L_0x0039;
            case 57: goto L_0x0010;
            default: goto L_0x000f;
        };
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0013, code lost:
        switch(1) {
            case 60: goto L_0x0017;
            case 61: goto L_0x0023;
            case 62: goto L_0x0030;
            default: goto L_0x0016;
        };
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0021, code lost:
        if (((((0 - 1) * 0) * ((0 * 2) - 1)) % 6) == 0) goto L_0x0074;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x002e, code lost:
        if (((((18 - 1) * 18) * ((18 * 2) - 1)) % 6) == 0) goto L_0x0074;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(com.bytedance.sdk.openadsdk.core.model.n r9, java.lang.String r10) {
        /*
        L_0x0000:
            r0 = 74
            r1 = 55
        L_0x0004:
            switch(r0) {
                case 72: goto L_0x0000;
                case 73: goto L_0x0009;
                case 74: goto L_0x000c;
                default: goto L_0x0007;
            }
        L_0x0007:
            goto L_0x0079
        L_0x0009:
            switch(r1) {
                case 94: goto L_0x0074;
                case 95: goto L_0x0010;
                case 96: goto L_0x0039;
                default: goto L_0x000c;
            }
        L_0x000c:
            switch(r1) {
                case 55: goto L_0x0074;
                case 56: goto L_0x0039;
                case 57: goto L_0x0010;
                default: goto L_0x000f;
            }
        L_0x000f:
            goto L_0x0074
        L_0x0010:
            r0 = 18
            r1 = 1
            switch(r1) {
                case 60: goto L_0x0017;
                case 61: goto L_0x0023;
                case 62: goto L_0x0030;
                default: goto L_0x0016;
            }
        L_0x0016:
            goto L_0x0039
        L_0x0017:
            r2 = 0
            int r3 = 0 - r1
            int r3 = r3 * r2
            int r2 = r2 * 2
            int r2 = r2 - r1
            int r3 = r3 * r2
            int r3 = r3 % 6
            if (r3 == 0) goto L_0x0074
        L_0x0023:
            int r2 = 18 - r1
            int r2 = r2 * r0
            r3 = 18
            int r3 = r3 * 2
            int r3 = r3 - r1
            int r2 = r2 * r3
            int r2 = r2 % 6
            if (r2 == 0) goto L_0x0074
        L_0x0030:
            r1 = 99
            int r1 = r1 * r1
            int r0 = r0 * r0
            int r0 = r0 * 34
            int r1 = r1 - r0
            r0 = -1
            goto L_0x0074
        L_0x0039:
            if (r9 != 0) goto L_0x003c
            return
        L_0x003c:
            org.json.JSONObject r8 = new org.json.JSONObject
            r8.<init>()
            org.json.JSONObject r0 = new org.json.JSONObject
            r0.<init>()
            java.lang.String r1 = "rdtfmfcX|z"
            java.lang.String r1 = com.bytedance.sdk.component.a.j.j1667305730992dc(r1)     // Catch:{ Exception -> 0x0060 }
            long r2 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x0060 }
            r0.put(r1, r2)     // Catch:{ Exception -> 0x0060 }
            java.lang.String r1 = "ae]f|qtfWmkm"
            java.lang.String r1 = com.bytedance.sdk.component.a.j.j1667305730992dc(r1)     // Catch:{ Exception -> 0x0060 }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x0060 }
            r8.put(r1, r0)     // Catch:{ Exception -> 0x0060 }
        L_0x0060:
            long r2 = java.lang.System.currentTimeMillis()
            android.content.Context r4 = com.bytedance.sdk.openadsdk.core.m.a()
            java.lang.String r0 = "bhfgmkaXzline{k"
            java.lang.String r7 = com.bytedance.sdk.component.a.j.j1667305730992dc(r0)
            r5 = r9
            r6 = r10
            b((long) r2, (android.content.Context) r4, (com.bytedance.sdk.openadsdk.core.model.n) r5, (java.lang.String) r6, (java.lang.String) r7, (org.json.JSONObject) r8)
            return
        L_0x0074:
            r0 = 73
            r1 = 96
            goto L_0x0004
        L_0x0079:
            r0 = 72
            goto L_0x0004
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.c.c.a(com.bytedance.sdk.openadsdk.core.model.n, java.lang.String):void");
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0023, code lost:
        if (((((85 - 1) * 85) * ((85 * 2) - 1)) % 6) == 0) goto L_0x003d;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(com.bytedance.sdk.openadsdk.core.model.n r7, java.lang.String r8, long r9) {
        /*
        L_0x0000:
            r0 = -55
            r1 = 73
            r2 = 85
            r3 = 1
            switch(r1) {
                case 72: goto L_0x003d;
                case 73: goto L_0x003d;
                case 74: goto L_0x000b;
                default: goto L_0x000a;
            }
        L_0x000a:
            goto L_0x0000
        L_0x000b:
            switch(r0) {
                case 39: goto L_0x000f;
                case 40: goto L_0x0018;
                case 41: goto L_0x0025;
                default: goto L_0x000e;
            }
        L_0x000e:
            goto L_0x0069
        L_0x000f:
            r0 = 94
            int r0 = r0 + r3
            int r0 = r0 * 94
            int r0 = r0 % 2
            if (r0 == 0) goto L_0x0000
        L_0x0018:
            int r0 = 85 - r3
            int r0 = r0 * r2
            r1 = 85
            int r1 = r1 * 2
            int r1 = r1 - r3
            int r0 = r0 * r1
            int r0 = r0 % 6
            if (r0 == 0) goto L_0x003d
        L_0x0025:
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
            if (r5 >= r0) goto L_0x003d
            goto L_0x0069
        L_0x003d:
            r0 = 91
            switch(r0) {
                case 91: goto L_0x0069;
                case 92: goto L_0x0043;
                case 93: goto L_0x004e;
                default: goto L_0x0042;
            }
        L_0x0042:
            goto L_0x003d
        L_0x0043:
            int r0 = r2 * r2
            r1 = 16
            int r1 = r1 * r1
            int r1 = r1 * 34
            int r0 = r0 - r1
            r1 = -1
            if (r0 != r1) goto L_0x0069
        L_0x004e:
            r0 = 30
            int r1 = 30 - r3
            int r1 = r1 * r0
            int r0 = r0 * 2
            int r0 = r0 - r3
            int r1 = r1 * r0
            int r1 = r1 % 6
            if (r1 == 0) goto L_0x0000
            r0 = 95
            r1 = 10
            int r4 = r0 * r0
            int r5 = r1 * r1
            int r4 = r4 + r5
            int r0 = r0 * r1
            int r0 = r0 * 2
            int r4 = r4 - r0
            goto L_0x003d
        L_0x0069:
            r3 = r7
            r4 = r8
            if (r3 != 0) goto L_0x006e
            return
        L_0x006e:
            org.json.JSONObject r6 = new org.json.JSONObject
            r6.<init>()
            java.lang.String r7 = "dtpbplii"
            java.lang.String r7 = com.bytedance.sdk.component.a.j.j1667305730992dc(r7)     // Catch:{ Exception -> 0x007c }
            r6.put(r7, r9)     // Catch:{ Exception -> 0x007c }
        L_0x007c:
            long r0 = java.lang.System.currentTimeMillis()
            android.content.Context r2 = com.bytedance.sdk.openadsdk.core.m.a()
            java.lang.String r7 = "bhfgmkaXdfko"
            java.lang.String r5 = com.bytedance.sdk.component.a.j.j1667305730992dc(r7)
            b((long) r0, (android.content.Context) r2, (com.bytedance.sdk.openadsdk.core.model.n) r3, (java.lang.String) r4, (java.lang.String) r5, (org.json.JSONObject) r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.c.c.a(com.bytedance.sdk.openadsdk.core.model.n, java.lang.String, long):void");
    }

    public static void a(n nVar, String str, long j, Map<String, Object> map) {
        if (nVar == null) {
            while (true) {
                switch (95) {
                    case 94:
                        if ((((30 - 1) * 30) * ((30 * 2) - 1)) % 6 == 0) {
                            return;
                        }
                        return;
                    case 95:
                        return;
                    case 96:
                        if ((84 * 84 * 84) + (42 * 42 * 42) + (22 * 22 * 22) < 84 * 42 * 22 * 3 && (((70 * 70) + (44 * 44)) - ((70 * 44) * 2) >= 0 || (18 * 18) - ((35 * 35) * 34) != -1 || (26 * 26 * 26) + (9 * 9 * 9) + (15 * 15 * 15) < 26 * 9 * 15 * 3)) {
                            return;
                        }
                }
            }
        } else {
            final long currentTimeMillis = System.currentTimeMillis();
            final long j2 = j;
            final Map<String, Object> map2 = map;
            final n nVar2 = nVar;
            final String str2 = str;
            a((g) new g(c.b.c$b1667305730972dc("ooCstJvbfHn")) {
                /* JADX WARNING: Can't fix incorrect switch cases order */
                /* JADX WARNING: Code restructure failed: missing block: B:12:0x0051, code lost:
                    if ((((64 * 64) + (38 * 38)) + (4 * 4)) >= (((64 * 38) + (38 * 4)) + (64 * 4))) goto L_0x0077;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:14:0x005f, code lost:
                    if ((((84 * 84) + (7 * 7)) - ((84 * 7) * 2)) >= 0) goto L_0x0075;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:16:0x0069, code lost:
                    if ((((17 + 1) * 17) % 2) == 0) goto L_0x0075;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:18:0x0073, code lost:
                    if ((((45 + 1) * 45) % 2) == 0) goto L_0x0000;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:20:0x0077, code lost:
                    r1 = r10;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:22:0x007a, code lost:
                    switch(r0) {
                        case 80: goto L_0x007e;
                        case 81: goto L_0x00e9;
                        case 82: goto L_0x00e9;
                        default: goto L_0x007d;
                    };
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:39:0x00e9, code lost:
                    r0 = 'P';
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:3:0x0016, code lost:
                    if (((((55 * 55) * 55) + r4) + r4) < (((55 * 11) * 11) * 3)) goto L_0x0018;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:9:0x0037, code lost:
                    if (82 > 18) goto L_0x006b;
                 */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public void run() {
                    /*
                        r10 = this;
                    L_0x0000:
                        r0 = 82
                        switch(r0) {
                            case 82: goto L_0x0079;
                            case 83: goto L_0x0006;
                            case 84: goto L_0x0018;
                            default: goto L_0x0005;
                        }
                    L_0x0005:
                        goto L_0x0000
                    L_0x0006:
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
                        if (r2 >= r1) goto L_0x003d
                    L_0x0018:
                        r1 = 13
                        r2 = 9
                        r3 = 8
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
                        if (r4 >= r1) goto L_0x0030
                        goto L_0x0075
                    L_0x0030:
                        r1 = r0
                    L_0x0031:
                        switch(r1) {
                            case 70: goto L_0x0035;
                            case 71: goto L_0x003d;
                            case 72: goto L_0x0053;
                            default: goto L_0x0034;
                        }
                    L_0x0034:
                        goto L_0x003a
                    L_0x0035:
                        r1 = 18
                        if (r0 <= r1) goto L_0x0061
                        goto L_0x006b
                    L_0x003a:
                        r1 = 71
                        goto L_0x0031
                    L_0x003d:
                        r0 = 64
                        r1 = 38
                        r2 = 4
                        int r3 = r0 * r0
                        int r4 = r1 * r1
                        int r3 = r3 + r4
                        int r4 = r2 * r2
                        int r3 = r3 + r4
                        r4 = 64
                        int r4 = r4 * r1
                        int r1 = r1 * r2
                        int r4 = r4 + r1
                        int r0 = r0 * r2
                        int r4 = r4 + r0
                        if (r3 >= r4) goto L_0x0077
                    L_0x0053:
                        r0 = 84
                        r1 = 7
                        int r2 = r0 * r0
                        int r3 = r1 * r1
                        int r2 = r2 + r3
                        int r0 = r0 * r1
                        int r0 = r0 * 2
                        int r2 = r2 - r0
                        if (r2 >= 0) goto L_0x0075
                    L_0x0061:
                        r0 = 17
                        int r0 = r0 + 1
                        int r0 = r0 * 17
                        int r0 = r0 % 2
                        if (r0 == 0) goto L_0x0075
                    L_0x006b:
                        r0 = 45
                        int r0 = r0 + 1
                        int r0 = r0 * 45
                        int r0 = r0 % 2
                        if (r0 == 0) goto L_0x0000
                    L_0x0075:
                        r1 = r10
                        goto L_0x007e
                    L_0x0077:
                        r1 = r10
                        goto L_0x00e9
                    L_0x0079:
                        r1 = r10
                    L_0x007a:
                        switch(r0) {
                            case 80: goto L_0x007e;
                            case 81: goto L_0x00e9;
                            case 82: goto L_0x00e9;
                            default: goto L_0x007d;
                        }
                    L_0x007d:
                        goto L_0x00e9
                    L_0x007e:
                        org.json.JSONObject r7 = new org.json.JSONObject
                        r7.<init>()
                        long r2 = r2     // Catch:{ JSONException -> 0x00d1 }
                        r4 = -1
                        int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
                        if (r0 == 0) goto L_0x0096
                        java.lang.String r0 = "dtpbplii"
                        java.lang.String r0 = com.bytedance.sdk.component.f.c.d.d1667305730926dc(r0)     // Catch:{ JSONException -> 0x00d1 }
                        long r2 = r2     // Catch:{ JSONException -> 0x00d1 }
                        r7.put(r0, r2)     // Catch:{ JSONException -> 0x00d1 }
                    L_0x0096:
                        org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ JSONException -> 0x00d1 }
                        r0.<init>()     // Catch:{ JSONException -> 0x00d1 }
                        java.util.Map r2 = r4     // Catch:{ JSONException -> 0x00d1 }
                        if (r2 == 0) goto L_0x00c3
                        java.util.Map r2 = r4     // Catch:{ JSONException -> 0x00d1 }
                        java.util.Set r2 = r2.entrySet()     // Catch:{ JSONException -> 0x00d1 }
                        java.util.Iterator r2 = r2.iterator()     // Catch:{ JSONException -> 0x00d1 }
                    L_0x00a9:
                        boolean r3 = r2.hasNext()     // Catch:{ JSONException -> 0x00d1 }
                        if (r3 == 0) goto L_0x00c3
                        java.lang.Object r3 = r2.next()     // Catch:{ JSONException -> 0x00d1 }
                        java.util.Map$Entry r3 = (java.util.Map.Entry) r3     // Catch:{ JSONException -> 0x00d1 }
                        java.lang.Object r4 = r3.getKey()     // Catch:{ JSONException -> 0x00d1 }
                        java.lang.String r4 = (java.lang.String) r4     // Catch:{ JSONException -> 0x00d1 }
                        java.lang.Object r3 = r3.getValue()     // Catch:{ JSONException -> 0x00d1 }
                        r0.put(r4, r3)     // Catch:{ JSONException -> 0x00d1 }
                        goto L_0x00a9
                    L_0x00c3:
                        java.lang.String r2 = "ae]f|qtfWmkm"
                        java.lang.String r2 = com.bytedance.sdk.component.f.c.d.d1667305730926dc(r2)     // Catch:{ JSONException -> 0x00d1 }
                        java.lang.String r0 = r0.toString()     // Catch:{ JSONException -> 0x00d1 }
                        r7.put(r2, r0)     // Catch:{ JSONException -> 0x00d1 }
                        goto L_0x00d7
                    L_0x00d1:
                        r0 = move-exception
                        org.json.JSONException r0 = (org.json.JSONException) r0
                        r0.printStackTrace()
                    L_0x00d7:
                        long r2 = r5
                        com.bytedance.sdk.openadsdk.core.model.n r4 = r7
                        java.lang.String r0 = "oqgm[db"
                        java.lang.String r5 = com.bytedance.sdk.component.f.c.d.d1667305730926dc(r0)
                        java.lang.String r6 = r8
                        r8 = 0
                        r9 = 0
                        com.bytedance.sdk.openadsdk.c.c.a((long) r2, (com.bytedance.sdk.openadsdk.core.model.n) r4, (java.lang.String) r5, (java.lang.String) r6, (org.json.JSONObject) r7, (com.bytedance.sdk.openadsdk.c.f) r8, (com.bytedance.sdk.openadsdk.c.b.a) r9)
                        return
                    L_0x00e9:
                        r0 = 80
                        goto L_0x007a
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.c.c.AnonymousClass5.run():void");
                }
            });
        }
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0010 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0000 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0000 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x001c A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0031 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x003b A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0076 A[SYNTHETIC] */
    public static void a(com.bytedance.sdk.openadsdk.core.model.n r10, java.lang.String r11, java.lang.String r12) {
        /*
        L_0x0000:
            r0 = 92
        L_0x0002:
            r1 = 14
            r2 = 15
        L_0x0006:
            r3 = 12
            switch(r1) {
                case 13: goto L_0x0013;
                case 14: goto L_0x0076;
                case 15: goto L_0x000c;
                default: goto L_0x000b;
            }
        L_0x000b:
            goto L_0x0002
        L_0x000c:
            switch(r0) {
                case 94: goto L_0x0076;
                case 95: goto L_0x0010;
                case 96: goto L_0x0076;
                default: goto L_0x000f;
            }
        L_0x000f:
            goto L_0x0018
        L_0x0010:
            r6 = r10
            r7 = r11
            goto L_0x0045
        L_0x0013:
            r1 = 72
            if (r0 < r1) goto L_0x0018
            goto L_0x0076
        L_0x0018:
            switch(r3) {
                case 55: goto L_0x001c;
                case 56: goto L_0x0031;
                case 57: goto L_0x003b;
                default: goto L_0x001b;
            }
        L_0x001b:
            goto L_0x0076
        L_0x001c:
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
            if (r3 >= r0) goto L_0x0010
        L_0x0031:
            r0 = 90
            int r0 = r0 + 1
            int r0 = r0 * 90
            int r0 = r0 % 2
            if (r0 == 0) goto L_0x0000
        L_0x003b:
            r0 = 15
            int r0 = r0 + 1
            int r0 = r0 * r2
            int r0 = r0 % 2
            if (r0 == 0) goto L_0x001c
            goto L_0x0000
        L_0x0045:
            if (r6 != 0) goto L_0x0048
            return
        L_0x0048:
            org.json.JSONObject r9 = new org.json.JSONObject
            r9.<init>()
            org.json.JSONObject r10 = new org.json.JSONObject
            r10.<init>()
            java.lang.String r11 = "esplvZkto"
            java.lang.String r11 = com.bytedance.sdk.component.a.j.j1667305730992dc(r11)     // Catch:{ JSONException -> 0x0064 }
            r10.putOpt(r11, r12)     // Catch:{ JSONException -> 0x0064 }
            java.lang.String r11 = "ae]f|qtfWmkm"
            java.lang.String r11 = com.bytedance.sdk.component.a.j.j1667305730992dc(r11)     // Catch:{ JSONException -> 0x0064 }
            r9.putOpt(r11, r10)     // Catch:{ JSONException -> 0x0064 }
        L_0x0064:
            long r3 = java.lang.System.currentTimeMillis()
            android.content.Context r5 = com.bytedance.sdk.openadsdk.core.m.a()
            java.lang.String r10 = "simt[`tug{"
            java.lang.String r8 = com.bytedance.sdk.component.a.j.j1667305730992dc(r10)
            b((long) r3, (android.content.Context) r5, (com.bytedance.sdk.openadsdk.core.model.n) r6, (java.lang.String) r7, (java.lang.String) r8, (org.json.JSONObject) r9)
            return
        L_0x0076:
            r0 = 95
            r1 = r2
            goto L_0x0006
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.c.c.a(com.bytedance.sdk.openadsdk.core.model.n, java.lang.String, java.lang.String):void");
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x004d, code lost:
        if (((66 * 66) - ((16 * 16) * 34)) == -1) goto L_0x004f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0062, code lost:
        if ((((29 * 29) + (45 * 45)) + (20 * 20)) >= (((29 * 45) + (45 * 20)) + (29 * 20))) goto L_0x0078;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0076, code lost:
        if ((((70 * 70) + (7 * 7)) + (4 * 4)) >= (((70 * 7) + (7 * 4)) + (70 * 4))) goto L_0x0023;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x002f, code lost:
        switch(r0) {
            case 94: goto L_0x004f;
            case 95: goto L_0x0064;
            case 96: goto L_0x0078;
            default: goto L_0x0032;
        };
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0032, code lost:
        r0 = '_';
     */
    @com.bytedance.JProtect
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(com.bytedance.sdk.openadsdk.core.model.n r14, java.lang.String r15, java.lang.String r16, java.lang.String r17, long r18, long r20, org.json.JSONObject r22) {
        /*
            if (r14 != 0) goto L_0x0004
            goto L_0x0089
        L_0x0004:
            long r6 = java.lang.System.currentTimeMillis()
            com.bytedance.sdk.openadsdk.c.c$4 r13 = new com.bytedance.sdk.openadsdk.c.c$4
            java.lang.String r0 = "sdlgNvGcMoex"
            java.lang.String r1 = com.bytedance.sdk.component.f.c.d.d1667305730926dc(r0)
            r0 = r13
            r2 = r22
            r3 = r17
            r4 = r16
            r5 = r14
            r8 = r15
            r9 = r18
            r11 = r20
            r0.<init>(r1, r2, r3, r4, r5, r6, r8, r9, r11)
            a((com.bytedance.sdk.component.g.g) r13)
        L_0x0023:
            r0 = 12
            r1 = 96
            r2 = 4
            r3 = 20
            switch(r1) {
                case 94: goto L_0x0035;
                case 95: goto L_0x002f;
                case 96: goto L_0x002e;
                default: goto L_0x002d;
            }
        L_0x002d:
            goto L_0x0023
        L_0x002e:
            return
        L_0x002f:
            switch(r0) {
                case 94: goto L_0x004f;
                case 95: goto L_0x0064;
                case 96: goto L_0x0078;
                default: goto L_0x0032;
            }
        L_0x0032:
            r0 = 95
            goto L_0x002f
        L_0x0035:
            r0 = 81
            r1 = 1
            int r4 = 81 - r1
            int r4 = r4 * r0
            int r0 = r0 * 2
            int r0 = r0 - r1
            int r4 = r4 * r0
            int r4 = r4 % 6
            if (r4 == 0) goto L_0x0089
            r0 = 66
            int r0 = r0 * r0
            r1 = 16
            int r1 = r1 * r1
            int r1 = r1 * 34
            int r0 = r0 - r1
            r1 = -1
            if (r0 != r1) goto L_0x0064
        L_0x004f:
            r0 = 29
            r1 = 45
            int r4 = r0 * r0
            int r5 = r1 * r1
            int r4 = r4 + r5
            int r5 = r3 * r3
            int r4 = r4 + r5
            r5 = 29
            int r5 = r5 * r1
            int r1 = r1 * r3
            int r5 = r5 + r1
            int r0 = r0 * r3
            int r5 = r5 + r0
            if (r4 >= r5) goto L_0x0078
        L_0x0064:
            r0 = 70
            r1 = 7
            int r4 = r0 * r0
            int r5 = r1 * r1
            int r4 = r4 + r5
            int r5 = r2 * r2
            int r4 = r4 + r5
            r5 = 70
            int r5 = r5 * r1
            int r1 = r1 * r2
            int r5 = r5 + r1
            int r0 = r0 * r2
            int r5 = r5 + r0
            if (r4 >= r5) goto L_0x0023
        L_0x0078:
            r0 = 69
            int r1 = r0 * r0
            int r4 = r3 * r3
            int r1 = r1 + r4
            int r4 = r2 * r2
            int r1 = r1 + r4
            r4 = 69
            int r4 = r4 * r3
            int r3 = r3 * r2
            int r4 = r4 + r3
            int r0 = r0 * r2
            int r4 = r4 + r0
        L_0x0089:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.c.c.a(com.bytedance.sdk.openadsdk.core.model.n, java.lang.String, java.lang.String, java.lang.String, long, long, org.json.JSONObject):void");
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0039, code lost:
        r2 = 0 * 0;
        r9 = 80 * 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0045, code lost:
        if ((((80 * 80) + r2) + r2) >= ((r2 + r9) + r9)) goto L_0x0006;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x004d, code lost:
        if ((((15 + 1) * 15) % 2) == 0) goto L_0x0024;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x005b, code lost:
        if (((((30 - 1) * 30) * ((30 * 2) - 1)) % 6) == 0) goto L_0x0006;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0064, code lost:
        if ((((39 + 1) * 39) % 2) == 0) goto L_0x0006;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0079, code lost:
        if ((((70 * 70) + (7 * 7)) + (4 * 4)) >= (((70 * 7) + (7 * 4)) + (70 * 4))) goto L_0x005d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0006, code lost:
        continue;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0006, code lost:
        continue;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0006, code lost:
        continue;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x001d, code lost:
        if (((18 * 18) - ((35 * 35) * 34)) == -1) goto L_0x0024;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0020, code lost:
        switch(95) {
            case 55: goto L_0x0024;
            case 56: goto L_0x0039;
            case 57: goto L_0x0047;
            default: goto L_0x0023;
        };
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0037, code lost:
        if (((((26 * 26) * 26) + ((9 * 9) * 9)) + ((15 * 15) * 15)) >= (((26 * 9) * 15) * 3)) goto L_0x007b;
     */
    @com.bytedance.JProtect
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(com.bytedance.sdk.openadsdk.core.model.n r8, java.lang.String r9, java.util.Map<java.lang.String, java.lang.Object> r10) {
        /*
            long r3 = java.lang.System.currentTimeMillis()
            if (r8 != 0) goto L_0x007c
        L_0x0006:
            r8 = 15
            r9 = 95
            r10 = 1
            switch(r9) {
                case 94: goto L_0x0050;
                case 95: goto L_0x000f;
                case 96: goto L_0x0020;
                default: goto L_0x000e;
            }
        L_0x000e:
            goto L_0x0006
        L_0x000f:
            switch(r9) {
                case 94: goto L_0x0066;
                case 95: goto L_0x007b;
                case 96: goto L_0x0013;
                default: goto L_0x0012;
            }
        L_0x0012:
            goto L_0x0020
        L_0x0013:
            r9 = 18
            int r9 = r9 * r9
            r0 = 35
            int r0 = r0 * r0
            int r0 = r0 * 34
            int r9 = r9 - r0
            r0 = -1
            if (r9 != r0) goto L_0x0066
            goto L_0x0024
        L_0x0020:
            switch(r9) {
                case 55: goto L_0x0024;
                case 56: goto L_0x0039;
                case 57: goto L_0x0047;
                default: goto L_0x0023;
            }
        L_0x0023:
            goto L_0x0050
        L_0x0024:
            r9 = 26
            r0 = 9
            int r1 = r9 * r9
            int r1 = r1 * r9
            int r2 = r0 * r0
            int r2 = r2 * r0
            int r1 = r1 + r2
            int r2 = r8 * r8
            int r2 = r2 * r8
            int r1 = r1 + r2
            int r9 = r9 * r0
            int r9 = r9 * r8
            int r9 = r9 * 3
            if (r1 >= r9) goto L_0x007b
        L_0x0039:
            r9 = 80
            r0 = 0
            int r1 = r9 * r9
            int r2 = r0 * r0
            int r1 = r1 + r2
            int r1 = r1 + r2
            int r9 = r9 * r0
            int r2 = r2 + r9
            int r2 = r2 + r9
            if (r1 >= r2) goto L_0x0006
        L_0x0047:
            r9 = 15
            int r9 = r9 + r10
            int r9 = r9 * r8
            int r9 = r9 % 2
            if (r9 == 0) goto L_0x0024
            goto L_0x008e
        L_0x0050:
            r8 = 30
            int r9 = 30 - r10
            int r9 = r9 * r8
            int r8 = r8 * 2
            int r8 = r8 - r10
            int r9 = r9 * r8
            int r9 = r9 % 6
            if (r9 == 0) goto L_0x0006
        L_0x005d:
            r8 = 39
            int r8 = r8 + r10
            int r8 = r8 * 39
            int r8 = r8 % 2
            if (r8 == 0) goto L_0x0006
        L_0x0066:
            r8 = 70
            r9 = 7
            r0 = 4
            int r1 = r8 * r8
            int r2 = r9 * r9
            int r1 = r1 + r2
            int r2 = r0 * r0
            int r1 = r1 + r2
            r2 = 70
            int r2 = r2 * r9
            int r9 = r9 * r0
            int r2 = r2 + r9
            int r8 = r8 * r0
            int r2 = r2 + r8
            if (r1 >= r2) goto L_0x005d
        L_0x007b:
            return
        L_0x007c:
            com.bytedance.sdk.openadsdk.c.c$11 r7 = new com.bytedance.sdk.openadsdk.c.c$11
            java.lang.String r0 = "ooNleaBrzh~bccKyuf"
            java.lang.String r1 = com.bytedance.sdk.component.f.c.e.e1667305730908dc(r0)
            r0 = r7
            r2 = r10
            r5 = r8
            r6 = r9
            r0.<init>(r1, r2, r3, r5, r6)
            a((com.bytedance.sdk.component.g.g) r7)
        L_0x008e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.c.c.a(com.bytedance.sdk.openadsdk.core.model.n, java.lang.String, java.util.Map):void");
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0050, code lost:
        if ((((29 * 29) + (45 * 45)) + (20 * 20)) >= (((29 * 45) + (45 * 20)) + (29 * 20))) goto L_0x0066;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0064, code lost:
        if ((((70 * 70) + (7 * 7)) + (4 * 4)) >= (((70 * 7) + (7 * 4)) + (70 * 4))) goto L_0x0012;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:3:0x001d, code lost:
        switch(r5) {
            case 94: goto L_0x003d;
            case 95: goto L_0x0052;
            case 96: goto L_0x0066;
            default: goto L_0x0020;
        };
     */
    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0020, code lost:
        r5 = '_';
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x003b, code lost:
        if (((66 * 66) - ((16 * 16) * 34)) == -1) goto L_0x003d;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(final java.lang.String r5) {
        /*
            long r0 = java.lang.System.currentTimeMillis()
            com.bytedance.sdk.openadsdk.c.c$6 r2 = new com.bytedance.sdk.openadsdk.c.c$6
            java.lang.String r3 = "sdlgHdus[ae|Mi"
            java.lang.String r3 = com.bytedance.sdk.component.d.c.c.b.c$b1667305730972dc(r3)
            r2.<init>(r3, r5, r0)
            a((com.bytedance.sdk.component.g.g) r2)
        L_0x0012:
            r5 = 12
            r0 = 96
            r1 = 4
            r2 = 20
            switch(r0) {
                case 94: goto L_0x0023;
                case 95: goto L_0x001d;
                case 96: goto L_0x0077;
                default: goto L_0x001c;
            }
        L_0x001c:
            goto L_0x0012
        L_0x001d:
            switch(r5) {
                case 94: goto L_0x003d;
                case 95: goto L_0x0052;
                case 96: goto L_0x0066;
                default: goto L_0x0020;
            }
        L_0x0020:
            r5 = 95
            goto L_0x001d
        L_0x0023:
            r5 = 81
            r0 = 1
            int r3 = 81 - r0
            int r3 = r3 * r5
            int r5 = r5 * 2
            int r5 = r5 - r0
            int r3 = r3 * r5
            int r3 = r3 % 6
            if (r3 == 0) goto L_0x0077
            r5 = 66
            int r5 = r5 * r5
            r0 = 16
            int r0 = r0 * r0
            int r0 = r0 * 34
            int r5 = r5 - r0
            r0 = -1
            if (r5 != r0) goto L_0x0052
        L_0x003d:
            r5 = 29
            r0 = 45
            int r3 = r5 * r5
            int r4 = r0 * r0
            int r3 = r3 + r4
            int r4 = r2 * r2
            int r3 = r3 + r4
            r4 = 29
            int r4 = r4 * r0
            int r0 = r0 * r2
            int r4 = r4 + r0
            int r5 = r5 * r2
            int r4 = r4 + r5
            if (r3 >= r4) goto L_0x0066
        L_0x0052:
            r5 = 70
            r0 = 7
            int r3 = r5 * r5
            int r4 = r0 * r0
            int r3 = r3 + r4
            int r4 = r1 * r1
            int r3 = r3 + r4
            r4 = 70
            int r4 = r4 * r0
            int r0 = r0 * r1
            int r4 = r4 + r0
            int r5 = r5 * r1
            int r4 = r4 + r5
            if (r3 >= r4) goto L_0x0012
        L_0x0066:
            r5 = 69
            int r0 = r5 * r5
            int r3 = r2 * r2
            int r0 = r0 + r3
            int r3 = r1 * r1
            int r0 = r0 + r3
            r3 = 69
            int r3 = r3 * r2
            int r2 = r2 * r1
            int r3 = r3 + r2
            int r5 = r5 * r1
            int r3 = r3 + r5
        L_0x0077:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.c.c.a(java.lang.String):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:6:0x0023 A[LOOP_START] */
    @com.bytedance.JProtect
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(java.lang.String r9, com.bytedance.sdk.openadsdk.core.model.n r10, java.lang.String r11, com.bytedance.sdk.openadsdk.c.f r12) {
        /*
            if (r10 == 0) goto L_0x0023
            if (r12 == 0) goto L_0x0023
            boolean r0 = r12.a()
            if (r0 != 0) goto L_0x000b
            goto L_0x0023
        L_0x000b:
            long r5 = java.lang.System.currentTimeMillis()
            com.bytedance.sdk.openadsdk.c.c$7 r0 = new com.bytedance.sdk.openadsdk.c.c$7
            java.lang.String r1 = "aeQkkrRnelXn|b|{"
            java.lang.String r2 = com.bytedance.sdk.component.a.j.j1667305730992dc(r1)
            r1 = r0
            r3 = r9
            r4 = r12
            r7 = r10
            r8 = r11
            r1.<init>(r2, r3, r4, r5, r7, r8)
            a((com.bytedance.sdk.component.g.g) r0)
            return
        L_0x0023:
            r9 = 62
            switch(r9) {
                case 60: goto L_0x0029;
                case 61: goto L_0x0035;
                case 62: goto L_0x0042;
                default: goto L_0x0028;
            }
        L_0x0028:
            goto L_0x0023
        L_0x0029:
            r9 = 18
            int r9 = r9 * r9
            r10 = 35
            int r10 = r10 * r10
            int r10 = r10 * 34
            int r9 = r9 - r10
            r10 = -1
            if (r9 != r10) goto L_0x0042
        L_0x0035:
            r9 = 85
            r10 = 32
            int r11 = r9 * r9
            int r12 = r10 * r10
            int r11 = r11 + r12
            int r9 = r9 * r10
            int r9 = r9 * 2
            int r11 = r11 - r9
        L_0x0042:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.c.c.a(java.lang.String, com.bytedance.sdk.openadsdk.core.model.n, java.lang.String, com.bytedance.sdk.openadsdk.c.f):void");
    }

    public static void a(String str, List<FilterWord> list) {
        com.bytedance.sdk.openadsdk.dislike.a.a().a(str, list);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x005b, code lost:
        if ((((29 * 29) + (45 * 45)) + (20 * 20)) >= (((29 * 45) + (45 * 20)) + (29 * 20))) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0036, code lost:
        switch(96) {
            case 94: goto L_0x0046;
            case 95: goto L_0x005d;
            case 96: goto L_0x0071;
            default: goto L_0x0039;
        };
     */
    @com.bytedance.JProtect
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void b(long r7, android.content.Context r9, com.bytedance.sdk.openadsdk.core.model.n r10, java.lang.String r11, java.lang.String r12) {
        /*
            if (r10 != 0) goto L_0x0004
            goto L_0x0071
        L_0x0004:
            com.bytedance.sdk.openadsdk.c.c$12 r9 = new com.bytedance.sdk.openadsdk.c.c$12
            java.lang.String r0 = "sdlgAsci|"
            java.lang.String r1 = com.bytedance.sdk.component.a.j.j1667305730992dc(r0)
            r0 = r9
            r2 = r10
            r3 = r7
            r5 = r11
            r6 = r12
            r0.<init>(r1, r2, r3, r5, r6)
            a((com.bytedance.sdk.component.g.g) r9)
        L_0x0017:
            r7 = 15
            r8 = 7
            switch(r7) {
                case 13: goto L_0x003a;
                case 14: goto L_0x001e;
                case 15: goto L_0x0034;
                default: goto L_0x001d;
            }
        L_0x001d:
            goto L_0x0017
        L_0x001e:
            r7 = 38
            r9 = 10
            int r10 = r7 * r7
            int r11 = r8 * r8
            int r10 = r10 + r11
            int r11 = r9 * r9
            int r10 = r10 + r11
            r11 = 38
            int r11 = r11 * r8
            r12 = 7
            int r12 = r12 * r9
            int r11 = r11 + r12
            int r7 = r7 * r9
            int r11 = r11 + r7
            if (r10 >= r11) goto L_0x0017
        L_0x0034:
            r7 = 96
            switch(r7) {
                case 94: goto L_0x0046;
                case 95: goto L_0x005d;
                case 96: goto L_0x0071;
                default: goto L_0x0039;
            }
        L_0x0039:
            goto L_0x0034
        L_0x003a:
            r7 = 66
            int r7 = r7 * r7
            r9 = 16
            int r9 = r9 * r9
            int r9 = r9 * 34
            int r7 = r7 - r9
            r9 = -1
            if (r7 != r9) goto L_0x005d
        L_0x0046:
            r7 = 29
            r9 = 45
            r10 = 20
            int r11 = r7 * r7
            int r12 = r9 * r9
            int r11 = r11 + r12
            int r12 = r10 * r10
            int r11 = r11 + r12
            r12 = 29
            int r12 = r12 * r9
            int r9 = r9 * r10
            int r12 = r12 + r9
            int r7 = r7 * r10
            int r12 = r12 + r7
            if (r11 >= r12) goto L_0x0071
        L_0x005d:
            r7 = 70
            r9 = 4
            int r10 = r7 * r7
            int r11 = r8 * r8
            int r10 = r10 + r11
            int r11 = r9 * r9
            int r10 = r10 + r11
            r11 = 70
            int r11 = r11 * r8
            int r8 = r8 * r9
            int r11 = r11 + r8
            int r7 = r7 * r9
            int r11 = r11 + r7
            if (r10 >= r11) goto L_0x0071
        L_0x0071:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.c.c.b(long, android.content.Context, com.bytedance.sdk.openadsdk.core.model.n, java.lang.String, java.lang.String):void");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0042, code lost:
        if (((66 * 66) - ((16 * 16) * 34)) == -1) goto L_0x0044;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0057, code lost:
        if ((((29 * 29) + (45 * 45)) + (20 * 20)) >= (((29 * 45) + (45 * 20)) + (29 * 20))) goto L_0x006d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x006b, code lost:
        if ((((70 * 70) + (7 * 7)) + (4 * 4)) >= (((70 * 7) + (7 * 4)) + (70 * 4))) goto L_0x0018;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0024, code lost:
        switch(r8) {
            case 94: goto L_0x0044;
            case 95: goto L_0x0059;
            case 96: goto L_0x006d;
            default: goto L_0x0027;
        };
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0027, code lost:
        r8 = '_';
     */
    @com.bytedance.JProtect
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void b(long r8, android.content.Context r10, com.bytedance.sdk.openadsdk.core.model.n r11, java.lang.String r12, java.lang.String r13, org.json.JSONObject r14) {
        /*
            if (r11 != 0) goto L_0x0004
            goto L_0x007e
        L_0x0004:
            com.bytedance.sdk.openadsdk.c.c$3 r10 = new com.bytedance.sdk.openadsdk.c.c$3
            java.lang.String r0 = "sdlgAsci|"
            java.lang.String r1 = com.bytedance.sdk.component.f.c.d.d1667305730926dc(r0)
            r0 = r10
            r2 = r14
            r3 = r11
            r4 = r8
            r6 = r12
            r7 = r13
            r0.<init>(r1, r2, r3, r4, r6, r7)
            a((com.bytedance.sdk.component.g.g) r10)
        L_0x0018:
            r8 = 12
            r9 = 96
            r10 = 4
            r11 = 20
            switch(r9) {
                case 94: goto L_0x002a;
                case 95: goto L_0x0024;
                case 96: goto L_0x0023;
                default: goto L_0x0022;
            }
        L_0x0022:
            goto L_0x0018
        L_0x0023:
            return
        L_0x0024:
            switch(r8) {
                case 94: goto L_0x0044;
                case 95: goto L_0x0059;
                case 96: goto L_0x006d;
                default: goto L_0x0027;
            }
        L_0x0027:
            r8 = 95
            goto L_0x0024
        L_0x002a:
            r8 = 81
            r9 = 1
            int r12 = 81 - r9
            int r12 = r12 * r8
            int r8 = r8 * 2
            int r8 = r8 - r9
            int r12 = r12 * r8
            int r12 = r12 % 6
            if (r12 == 0) goto L_0x007e
            r8 = 66
            int r8 = r8 * r8
            r9 = 16
            int r9 = r9 * r9
            int r9 = r9 * 34
            int r8 = r8 - r9
            r9 = -1
            if (r8 != r9) goto L_0x0059
        L_0x0044:
            r8 = 29
            r9 = 45
            int r12 = r8 * r8
            int r13 = r9 * r9
            int r12 = r12 + r13
            int r13 = r11 * r11
            int r12 = r12 + r13
            r13 = 29
            int r13 = r13 * r9
            int r9 = r9 * r11
            int r13 = r13 + r9
            int r8 = r8 * r11
            int r13 = r13 + r8
            if (r12 >= r13) goto L_0x006d
        L_0x0059:
            r8 = 70
            r9 = 7
            int r12 = r8 * r8
            int r13 = r9 * r9
            int r12 = r12 + r13
            int r13 = r10 * r10
            int r12 = r12 + r13
            r13 = 70
            int r13 = r13 * r9
            int r9 = r9 * r10
            int r13 = r13 + r9
            int r8 = r8 * r10
            int r13 = r13 + r8
            if (r12 >= r13) goto L_0x0018
        L_0x006d:
            r8 = 69
            int r9 = r8 * r8
            int r12 = r11 * r11
            int r9 = r9 + r12
            int r12 = r10 * r10
            int r9 = r9 + r12
            r12 = 69
            int r12 = r12 * r11
            int r11 = r11 * r10
            int r12 = r12 + r11
            int r8 = r8 * r10
            int r12 = r12 + r8
        L_0x007e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.c.c.b(long, android.content.Context, com.bytedance.sdk.openadsdk.core.model.n, java.lang.String, java.lang.String, org.json.JSONObject):void");
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0054, code lost:
        if (((((26 * 26) * 26) + 729) + ((15 * 15) * 15)) >= (((26 * 9) * 15) * 3)) goto L_0x006b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x005e, code lost:
        if ((((90 + 1) * 90) % 2) == 0) goto L_0x006b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0067, code lost:
        if ((((15 + 1) * 15) % 2) == 0) goto L_0x0044;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x000e, code lost:
        continue;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0027, code lost:
        if (((18 * 18) - ((35 * 35) * 34)) == -1) goto L_0x0044;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x003d, code lost:
        if ((((70 * 70) + (7 * 7)) + (4 * 4)) >= (((70 * 7) + (7 * 4)) + (70 * 4))) goto L_0x000e;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void b(final android.content.Context r3, final com.bytedance.sdk.openadsdk.core.model.n r4, final java.lang.String r5) {
        /*
            com.bytedance.sdk.openadsdk.c.c$9 r0 = new com.bytedance.sdk.openadsdk.c.c$9
            java.lang.String r1 = "phawqwcDd`i`"
            java.lang.String r1 = com.bytedance.sdk.component.adexpress.widget.DynamicUnlockView.DynamicUnlockView1667305730929dc(r1)
            r0.<init>(r1, r4, r3, r5)
            a((com.bytedance.sdk.component.g.g) r0)
        L_0x000e:
            r3 = 15
            r4 = r3
        L_0x0011:
            r5 = 12
            r0 = 95
            switch(r4) {
                case 13: goto L_0x000e;
                case 14: goto L_0x006a;
                case 15: goto L_0x0019;
                default: goto L_0x0018;
            }
        L_0x0018:
            goto L_0x006b
        L_0x0019:
            switch(r0) {
                case 94: goto L_0x002a;
                case 95: goto L_0x006b;
                case 96: goto L_0x001d;
                default: goto L_0x001c;
            }
        L_0x001c:
            goto L_0x0040
        L_0x001d:
            r4 = 18
            int r4 = r4 * r4
            r5 = 35
            int r5 = r5 * r5
            int r5 = r5 * 34
            int r4 = r4 - r5
            r5 = -1
            if (r4 != r5) goto L_0x002a
            goto L_0x0044
        L_0x002a:
            r4 = 70
            r5 = 7
            r0 = 4
            int r1 = r4 * r4
            int r2 = r5 * r5
            int r1 = r1 + r2
            int r2 = r0 * r0
            int r1 = r1 + r2
            r2 = 70
            int r2 = r2 * r5
            int r5 = r5 * r0
            int r2 = r2 + r5
            int r4 = r4 * r0
            int r2 = r2 + r4
            if (r1 >= r2) goto L_0x000e
            goto L_0x006b
        L_0x0040:
            switch(r5) {
                case 55: goto L_0x0044;
                case 56: goto L_0x0056;
                case 57: goto L_0x0060;
                default: goto L_0x0043;
            }
        L_0x0043:
            goto L_0x000e
        L_0x0044:
            r4 = 26
            int r5 = r4 * r4
            int r5 = r5 * r4
            int r5 = r5 + 729
            int r0 = r3 * r3
            int r0 = r0 * r3
            int r5 = r5 + r0
            int r4 = r4 * 9
            int r4 = r4 * r3
            int r4 = r4 * 3
            if (r5 >= r4) goto L_0x006b
        L_0x0056:
            r4 = 90
            int r4 = r4 + 1
            int r4 = r4 * 90
            int r4 = r4 % 2
            if (r4 == 0) goto L_0x006b
        L_0x0060:
            r4 = 15
            int r4 = r4 + 1
            int r4 = r4 * r3
            int r4 = r4 % 2
            if (r4 == 0) goto L_0x0044
            goto L_0x006b
        L_0x006a:
            return
        L_0x006b:
            r4 = 14
            goto L_0x0011
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.c.c.b(android.content.Context, com.bytedance.sdk.openadsdk.core.model.n, java.lang.String):void");
    }

    public static void b(Context context, n nVar, String str, String str2) {
        if (nVar != null) {
            b(System.currentTimeMillis(), context, nVar, str, str2);
        }
    }

    public static void b(Context context, n nVar, String str, String str2, long j, JSONObject jSONObject) {
        while (true) {
            switch (54) {
                case 52:
                    switch (37) {
                        case 94:
                            if ((18 * 18) - ((35 * 35) * 34) != -1) {
                                continue;
                                continue;
                            }
                        case 95:
                            if ((26 * 26 * 26) + (9 * 9 * 9) + (15 * 15 * 15) >= 26 * 9 * 15 * 3) {
                                continue;
                            }
                        case 96:
                            if ((((40 - 1) * 40) * ((40 * 2) - 1)) % 6 != 0) {
                                break;
                            } else {
                                continue;
                            }
                    }
                    break;
                case 53:
                    break;
                case 54:
                    break;
            }
            if ((((30 - 1) * 30) * ((30 * 2) - 1)) % 6 != 0) {
            }
        }
        if (nVar != null) {
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put(FlowLightView.FlowLightView1667305730929dc("dtpbplii"), j);
                if (jSONObject != null) {
                    jSONObject2.putOpt(FlowLightView.FlowLightView1667305730929dc("ae]f|qtfWmkm"), jSONObject);
                }
            } catch (Exception unused) {
            }
            b(System.currentTimeMillis(), context, nVar, str, str2, jSONObject2);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0039, code lost:
        if ((((17 + 1) * 17) % 2) == 0) goto L_0x006c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x003b, code lost:
        r2 = r7;
        r0 = r8;
        r3 = r9;
        r4 = r10;
        r1 = r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x004d, code lost:
        if ((((12 * 12) + (37 * 37)) - ((12 * 37) * 2)) >= 0) goto L_0x0050;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0069, code lost:
        if (((((38 - 1) * 38) * ((38 * 2) - 1)) % 6) == 0) goto L_0x00c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00c2, code lost:
        r2 = r7;
        r0 = r8;
        r3 = r9;
        r4 = r10;
        r1 = r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0011, code lost:
        r8 = r0;
        r11 = r1;
        r7 = r2;
        r9 = r3;
        r10 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x000a, code lost:
        continue;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x001e, code lost:
        switch(31) {
            case 29: goto L_0x00c2;
            case 30: goto L_0x0022;
            case 31: goto L_0x006c;
            default: goto L_0x0021;
        };
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0022, code lost:
        switch(39) {
            case 57: goto L_0x0026;
            case 58: goto L_0x0032;
            case 59: goto L_0x003b;
            default: goto L_0x0025;
        };
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0030, code lost:
        if (((((7 - 1) * 7) * ((7 * 2) - 1)) % 6) == 0) goto L_0x001c;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void b(android.content.Context r19, com.bytedance.sdk.openadsdk.core.model.n r20, java.lang.String r21, java.lang.String r22, java.util.Map<java.lang.String, java.lang.Object> r23) {
        /*
            r2 = r19
            r0 = r20
            r3 = r21
            r4 = r22
            r1 = r23
        L_0x000a:
            r5 = 39
            r6 = 1
            switch(r5) {
                case 39: goto L_0x0017;
                case 40: goto L_0x0050;
                case 41: goto L_0x0011;
                default: goto L_0x0010;
            }
        L_0x0010:
            goto L_0x000a
        L_0x0011:
            r8 = r0
            r11 = r1
            r7 = r2
            r9 = r3
            r10 = r4
            goto L_0x005e
        L_0x0017:
            r8 = r0
            r11 = r1
            r7 = r2
            r9 = r3
            r10 = r4
        L_0x001c:
            r0 = 31
            switch(r0) {
                case 29: goto L_0x00c2;
                case 30: goto L_0x0022;
                case 31: goto L_0x006c;
                default: goto L_0x0021;
            }
        L_0x0021:
            goto L_0x001c
        L_0x0022:
            switch(r5) {
                case 57: goto L_0x0026;
                case 58: goto L_0x0032;
                case 59: goto L_0x003b;
                default: goto L_0x0025;
            }
        L_0x0025:
            goto L_0x006c
        L_0x0026:
            r0 = 7
            int r1 = 7 - r6
            int r1 = r1 * r0
            int r0 = r0 * 2
            int r0 = r0 - r6
            int r1 = r1 * r0
            int r1 = r1 % 6
            if (r1 == 0) goto L_0x001c
        L_0x0032:
            r0 = 17
            int r0 = r0 + r6
            int r0 = r0 * 17
            int r0 = r0 % 2
            if (r0 == 0) goto L_0x006c
        L_0x003b:
            r2 = r7
            r0 = r8
            r3 = r9
            r4 = r10
            r1 = r11
            r7 = 12
            r8 = 37
            int r9 = r7 * r7
            int r10 = r8 * r8
            int r9 = r9 + r10
            int r7 = r7 * r8
            int r7 = r7 * 2
            int r9 = r9 - r7
            if (r9 >= 0) goto L_0x0050
            goto L_0x000a
        L_0x0050:
            r7 = 29
            int r8 = 29 - r6
            int r8 = r8 * r7
            int r7 = r7 * 2
            int r7 = r7 - r6
            int r8 = r8 * r7
            int r8 = r8 % 6
            if (r8 == 0) goto L_0x000a
            goto L_0x0011
        L_0x005e:
            r0 = 38
            int r1 = 38 - r6
            int r1 = r1 * r0
            int r0 = r0 * 2
            int r0 = r0 - r6
            int r1 = r1 * r0
            int r1 = r1 % 6
            if (r1 == 0) goto L_0x00c2
            goto L_0x0026
        L_0x006c:
            r14 = r7
            r15 = r8
            r16 = r9
            r17 = r10
            if (r15 != 0) goto L_0x0075
            return
        L_0x0075:
            org.json.JSONObject r1 = new org.json.JSONObject
            r1.<init>()
            org.json.JSONObject r0 = new org.json.JSONObject
            r0.<init>()
            if (r11 == 0) goto L_0x00a5
            java.util.Set r2 = r11.entrySet()     // Catch:{ JSONException -> 0x00a3 }
            java.util.Iterator r2 = r2.iterator()     // Catch:{ JSONException -> 0x00a3 }
        L_0x0089:
            boolean r3 = r2.hasNext()     // Catch:{ JSONException -> 0x00a3 }
            if (r3 == 0) goto L_0x00a5
            java.lang.Object r3 = r2.next()     // Catch:{ JSONException -> 0x00a3 }
            java.util.Map$Entry r3 = (java.util.Map.Entry) r3     // Catch:{ JSONException -> 0x00a3 }
            java.lang.Object r4 = r3.getKey()     // Catch:{ JSONException -> 0x00a3 }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ JSONException -> 0x00a3 }
            java.lang.Object r3 = r3.getValue()     // Catch:{ JSONException -> 0x00a3 }
            r0.put(r4, r3)     // Catch:{ JSONException -> 0x00a3 }
            goto L_0x0089
        L_0x00a3:
            r0 = move-exception
            goto L_0x00b3
        L_0x00a5:
            java.lang.String r2 = "ae]f|qtfWmkm"
            java.lang.String r2 = com.bytedance.sdk.component.d.c.a.a1667305730971dc(r2)     // Catch:{ JSONException -> 0x00a3 }
            java.lang.String r0 = r0.toString()     // Catch:{ JSONException -> 0x00a3 }
            r1.put(r2, r0)     // Catch:{ JSONException -> 0x00a3 }
            goto L_0x00b8
        L_0x00b3:
            org.json.JSONException r0 = (org.json.JSONException) r0
            r0.printStackTrace()
        L_0x00b8:
            long r12 = java.lang.System.currentTimeMillis()
            r18 = r1
            b((long) r12, (android.content.Context) r14, (com.bytedance.sdk.openadsdk.core.model.n) r15, (java.lang.String) r16, (java.lang.String) r17, (org.json.JSONObject) r18)
            return
        L_0x00c2:
            r2 = r7
            r0 = r8
            r3 = r9
            r4 = r10
            r1 = r11
            goto L_0x000a
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.c.c.b(android.content.Context, com.bytedance.sdk.openadsdk.core.model.n, java.lang.String, java.lang.String, java.util.Map):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0017, code lost:
        if (((18 * 18) - ((35 * 35) * 34)) == -1) goto L_0x0019;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x002e, code lost:
        if (((((26 * 26) * 26) + ((9 * 9) * 9)) + ((15 * 15) * 15)) < (((26 * 9) * 15) * 3)) goto L_0x0030;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0030, code lost:
        r0 = 40;
        r1 = 40 - 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0034, code lost:
        r1 = ((r1 * r0) * ((r0 * 2) - 1)) % 6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x003c, code lost:
        r0 = 30;
        r1 = 30 - 1;
     */
    /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP_START, MTH_ENTER_BLOCK] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void b(android.content.Context r9, com.bytedance.sdk.openadsdk.core.model.n r10, java.lang.String r11, java.lang.String r12, org.json.JSONObject r13) {
        /*
        L_0x0000:
            r0 = 37
            r1 = 54
            r2 = 1
            switch(r1) {
                case 52: goto L_0x0009;
                case 53: goto L_0x003c;
                case 54: goto L_0x0041;
                default: goto L_0x0008;
            }
        L_0x0008:
            goto L_0x0000
        L_0x0009:
            switch(r0) {
                case 94: goto L_0x000d;
                case 95: goto L_0x0019;
                case 96: goto L_0x0030;
                default: goto L_0x000c;
            }
        L_0x000c:
            goto L_0x003c
        L_0x000d:
            r0 = 18
            int r0 = r0 * r0
            r1 = 35
            int r1 = r1 * r1
            int r1 = r1 * 34
            int r0 = r0 - r1
            r1 = -1
            if (r0 != r1) goto L_0x0041
        L_0x0019:
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
            if (r4 >= r0) goto L_0x0041
        L_0x0030:
            r0 = 40
            int r1 = 40 - r2
        L_0x0034:
            int r1 = r1 * r0
            int r0 = r0 * 2
            int r0 = r0 - r2
            int r1 = r1 * r0
            int r1 = r1 % 6
            goto L_0x0041
        L_0x003c:
            r0 = 30
            int r1 = 30 - r2
            goto L_0x0034
        L_0x0041:
            if (r10 != 0) goto L_0x0044
            return
        L_0x0044:
            org.json.JSONObject r8 = new org.json.JSONObject
            r8.<init>()
            if (r13 == 0) goto L_0x0058
            java.lang.String r0 = "ae]f|qtfWmkm"
            java.lang.String r0 = com.bytedance.sdk.component.d.c.f.f1667305730962dc(r0)     // Catch:{ Exception -> 0x0058 }
            java.lang.String r13 = r13.toString()     // Catch:{ Exception -> 0x0058 }
            r8.put(r0, r13)     // Catch:{ Exception -> 0x0058 }
        L_0x0058:
            long r2 = java.lang.System.currentTimeMillis()
            r4 = r9
            r5 = r10
            r6 = r11
            r7 = r12
            b((long) r2, (android.content.Context) r4, (com.bytedance.sdk.openadsdk.core.model.n) r5, (java.lang.String) r6, (java.lang.String) r7, (org.json.JSONObject) r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.c.c.b(android.content.Context, com.bytedance.sdk.openadsdk.core.model.n, java.lang.String, java.lang.String, org.json.JSONObject):void");
    }

    public static void b(n nVar) {
        if (!TextUtils.isEmpty(com.bytedance.sdk.openadsdk.core.j.a(m.a()))) {
            com.bytedance.sdk.openadsdk.c.a.c.a(com.bytedance.sdk.openadsdk.k.a.a(nVar.R(), true));
        }
    }

    public static void b(n nVar, String str, Map<String, Object> map) {
        if (nVar != null) {
            a(nVar, str, -1, map);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0039, code lost:
        if ((((17 + 1) * 17) % 2) == 0) goto L_0x006c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x003b, code lost:
        r2 = r7;
        r0 = r8;
        r3 = r9;
        r4 = r10;
        r1 = r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x004d, code lost:
        if ((((12 * 12) + (37 * 37)) - ((12 * 37) * 2)) >= 0) goto L_0x0050;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0069, code lost:
        if (((((38 - 1) * 38) * ((38 * 2) - 1)) % 6) == 0) goto L_0x00c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00c2, code lost:
        r2 = r7;
        r0 = r8;
        r3 = r9;
        r4 = r10;
        r1 = r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0011, code lost:
        r8 = r0;
        r11 = r1;
        r7 = r2;
        r9 = r3;
        r10 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x000a, code lost:
        continue;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x001e, code lost:
        switch(31) {
            case 29: goto L_0x00c2;
            case 30: goto L_0x0022;
            case 31: goto L_0x006c;
            default: goto L_0x0021;
        };
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0022, code lost:
        switch(39) {
            case 57: goto L_0x0026;
            case 58: goto L_0x0032;
            case 59: goto L_0x003b;
            default: goto L_0x0025;
        };
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0030, code lost:
        if (((((7 - 1) * 7) * ((7 * 2) - 1)) % 6) == 0) goto L_0x001c;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void c(android.content.Context r19, com.bytedance.sdk.openadsdk.core.model.n r20, java.lang.String r21, java.lang.String r22, java.util.Map<java.lang.String, java.lang.Object> r23) {
        /*
            r2 = r19
            r0 = r20
            r3 = r21
            r4 = r22
            r1 = r23
        L_0x000a:
            r5 = 39
            r6 = 1
            switch(r5) {
                case 39: goto L_0x0017;
                case 40: goto L_0x0050;
                case 41: goto L_0x0011;
                default: goto L_0x0010;
            }
        L_0x0010:
            goto L_0x000a
        L_0x0011:
            r8 = r0
            r11 = r1
            r7 = r2
            r9 = r3
            r10 = r4
            goto L_0x005e
        L_0x0017:
            r8 = r0
            r11 = r1
            r7 = r2
            r9 = r3
            r10 = r4
        L_0x001c:
            r0 = 31
            switch(r0) {
                case 29: goto L_0x00c2;
                case 30: goto L_0x0022;
                case 31: goto L_0x006c;
                default: goto L_0x0021;
            }
        L_0x0021:
            goto L_0x001c
        L_0x0022:
            switch(r5) {
                case 57: goto L_0x0026;
                case 58: goto L_0x0032;
                case 59: goto L_0x003b;
                default: goto L_0x0025;
            }
        L_0x0025:
            goto L_0x006c
        L_0x0026:
            r0 = 7
            int r1 = 7 - r6
            int r1 = r1 * r0
            int r0 = r0 * 2
            int r0 = r0 - r6
            int r1 = r1 * r0
            int r1 = r1 % 6
            if (r1 == 0) goto L_0x001c
        L_0x0032:
            r0 = 17
            int r0 = r0 + r6
            int r0 = r0 * 17
            int r0 = r0 % 2
            if (r0 == 0) goto L_0x006c
        L_0x003b:
            r2 = r7
            r0 = r8
            r3 = r9
            r4 = r10
            r1 = r11
            r7 = 12
            r8 = 37
            int r9 = r7 * r7
            int r10 = r8 * r8
            int r9 = r9 + r10
            int r7 = r7 * r8
            int r7 = r7 * 2
            int r9 = r9 - r7
            if (r9 >= 0) goto L_0x0050
            goto L_0x000a
        L_0x0050:
            r7 = 29
            int r8 = 29 - r6
            int r8 = r8 * r7
            int r7 = r7 * 2
            int r7 = r7 - r6
            int r8 = r8 * r7
            int r8 = r8 % 6
            if (r8 == 0) goto L_0x000a
            goto L_0x0011
        L_0x005e:
            r0 = 38
            int r1 = 38 - r6
            int r1 = r1 * r0
            int r0 = r0 * 2
            int r0 = r0 - r6
            int r1 = r1 * r0
            int r1 = r1 % 6
            if (r1 == 0) goto L_0x00c2
            goto L_0x0026
        L_0x006c:
            r14 = r7
            r15 = r8
            r16 = r9
            r17 = r10
            if (r15 != 0) goto L_0x0075
            return
        L_0x0075:
            org.json.JSONObject r1 = new org.json.JSONObject
            r1.<init>()
            org.json.JSONObject r0 = new org.json.JSONObject
            r0.<init>()
            if (r11 == 0) goto L_0x00a5
            java.util.Set r2 = r11.entrySet()     // Catch:{ JSONException -> 0x00a3 }
            java.util.Iterator r2 = r2.iterator()     // Catch:{ JSONException -> 0x00a3 }
        L_0x0089:
            boolean r3 = r2.hasNext()     // Catch:{ JSONException -> 0x00a3 }
            if (r3 == 0) goto L_0x00a5
            java.lang.Object r3 = r2.next()     // Catch:{ JSONException -> 0x00a3 }
            java.util.Map$Entry r3 = (java.util.Map.Entry) r3     // Catch:{ JSONException -> 0x00a3 }
            java.lang.Object r4 = r3.getKey()     // Catch:{ JSONException -> 0x00a3 }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ JSONException -> 0x00a3 }
            java.lang.Object r3 = r3.getValue()     // Catch:{ JSONException -> 0x00a3 }
            r0.put(r4, r3)     // Catch:{ JSONException -> 0x00a3 }
            goto L_0x0089
        L_0x00a3:
            r0 = move-exception
            goto L_0x00b3
        L_0x00a5:
            java.lang.String r2 = "ae]f|qtfWmkm"
            java.lang.String r2 = com.bytedance.sdk.component.d.c.a.a1667305730971dc(r2)     // Catch:{ JSONException -> 0x00a3 }
            java.lang.String r0 = r0.toString()     // Catch:{ JSONException -> 0x00a3 }
            r1.put(r2, r0)     // Catch:{ JSONException -> 0x00a3 }
            goto L_0x00b8
        L_0x00b3:
            org.json.JSONException r0 = (org.json.JSONException) r0
            r0.printStackTrace()
        L_0x00b8:
            long r12 = java.lang.System.currentTimeMillis()
            r18 = r1
            b((long) r12, (android.content.Context) r14, (com.bytedance.sdk.openadsdk.core.model.n) r15, (java.lang.String) r16, (java.lang.String) r17, (org.json.JSONObject) r18)
            return
        L_0x00c2:
            r2 = r7
            r0 = r8
            r3 = r9
            r4 = r10
            r1 = r11
            goto L_0x000a
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.c.c.c(android.content.Context, com.bytedance.sdk.openadsdk.core.model.n, java.lang.String, java.lang.String, java.util.Map):void");
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    @com.bytedance.JProtect
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void c(android.content.Context r7, com.bytedance.sdk.openadsdk.core.model.n r8, java.lang.String r9, java.lang.String r10, org.json.JSONObject r11) {
        /*
            if (r8 != 0) goto L_0x0004
            goto L_0x00a3
        L_0x0004:
            if (r11 != 0) goto L_0x000b
            org.json.JSONObject r11 = new org.json.JSONObject
            r11.<init>()
        L_0x000b:
            r6 = r11
            long r0 = java.lang.System.currentTimeMillis()
            r2 = r7
            r3 = r8
            r4 = r9
            r5 = r10
            b((long) r0, (android.content.Context) r2, (com.bytedance.sdk.openadsdk.core.model.n) r3, (java.lang.String) r4, (java.lang.String) r5, (org.json.JSONObject) r6)
        L_0x0017:
            r7 = 31
            r8 = 95
            r9 = -1
            switch(r7) {
                case 29: goto L_0x0020;
                case 30: goto L_0x002e;
                case 31: goto L_0x00a3;
                default: goto L_0x001f;
            }
        L_0x001f:
            goto L_0x0017
        L_0x0020:
            r7 = 87
            r10 = 1
            int r11 = 87 - r10
            int r11 = r11 * r7
            int r7 = r7 * 2
            int r7 = r7 - r10
            int r11 = r11 * r7
            int r11 = r11 % 6
            if (r11 == 0) goto L_0x003a
        L_0x002e:
            r7 = 13
            int r7 = r7 * r7
            r8 = 19
            int r8 = r8 * r8
            int r8 = r8 * 34
            int r7 = r7 - r8
            if (r7 != r9) goto L_0x0017
            goto L_0x00a3
        L_0x003a:
            r7 = 99
            int r7 = r7 * r7
            r11 = 18
            int r0 = r11 * r11
            int r0 = r0 * 34
            int r7 = r7 - r0
            if (r7 != r9) goto L_0x0047
            goto L_0x0017
        L_0x0047:
            r7 = 40
            r0 = r7
        L_0x004a:
            switch(r0) {
                case 38: goto L_0x004e;
                case 39: goto L_0x005b;
                case 40: goto L_0x005e;
                default: goto L_0x004d;
            }
        L_0x004d:
            goto L_0x00a4
        L_0x004e:
            int r0 = 40 - r10
            int r0 = r0 * r7
            r7 = 40
            int r7 = r7 * 2
            int r7 = r7 - r10
            int r0 = r0 * r7
            int r0 = r0 % 6
            if (r0 == 0) goto L_0x0017
        L_0x005b:
            switch(r8) {
                case 52: goto L_0x006a;
                case 53: goto L_0x003a;
                case 54: goto L_0x0017;
                default: goto L_0x005e;
            }
        L_0x005e:
            r7 = 0
            int r0 = 0 - r10
            int r0 = r0 * r7
            int r7 = r7 * 2
            int r7 = r7 - r10
            int r0 = r0 * r7
            int r0 = r0 % 6
            if (r0 == 0) goto L_0x00a3
        L_0x006a:
            int r7 = 18 - r10
            int r7 = r7 * r11
            r0 = 18
            int r0 = r0 * 2
            int r0 = r0 - r10
            int r7 = r7 * r0
            int r7 = r7 % 6
            if (r7 == 0) goto L_0x0078
            goto L_0x003a
        L_0x0078:
            r7 = 54
            r0 = 27
            r1 = 24
            int r2 = r7 * r7
            int r3 = r0 * r0
            int r2 = r2 + r3
            int r3 = r1 * r1
            int r2 = r2 + r3
            r3 = 54
            int r3 = r3 * r0
            int r0 = r0 * r1
            int r3 = r3 + r0
            int r7 = r7 * r1
            int r3 = r3 + r7
            if (r2 >= r3) goto L_0x0047
            r7 = 94
            r8 = 17
            r9 = 7
            int r10 = r7 * r7
            int r10 = r10 * r7
            int r11 = r8 * r8
            int r11 = r11 * r8
            int r10 = r10 + r11
            int r11 = r9 * r9
            int r11 = r11 * r9
            int r10 = r10 + r11
            int r7 = r7 * r8
            int r7 = r7 * r9
            int r7 = r7 * 3
        L_0x00a3:
            return
        L_0x00a4:
            r0 = 38
            goto L_0x004a
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.c.c.c(android.content.Context, com.bytedance.sdk.openadsdk.core.model.n, java.lang.String, java.lang.String, org.json.JSONObject):void");
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0036, code lost:
        if (((((7 - 1) * 7) * ((7 * 2) - 1)) % 6) == 0) goto L_0x0000;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x003f, code lost:
        if ((((17 + 1) * 17) % 2) == 0) goto L_0x000c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x004e, code lost:
        if ((((12 * 12) + (37 * 37)) - ((12 * 37) * 2)) >= 0) goto L_0x0012;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0000, code lost:
        continue;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000e, code lost:
        switch(39) {
            case 39: goto L_0x0050;
            case 40: goto L_0x0012;
            case 41: goto L_0x001f;
            default: goto L_0x0011;
        };
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x001d, code lost:
        if (((((29 - 1) * 29) * ((29 * 2) - 1)) % 6) == 0) goto L_0x0050;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x002a, code lost:
        if (((((38 - 1) * 38) * ((38 * 2) - 1)) % 6) == 0) goto L_0x000c;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void d(android.content.Context r7, com.bytedance.sdk.openadsdk.core.model.n r8, java.lang.String r9, java.lang.String r10, java.util.Map<java.lang.String, java.lang.Object> r11) {
        /*
        L_0x0000:
            r0 = 34
            r1 = 31
            r2 = 1
            switch(r1) {
                case 29: goto L_0x000c;
                case 30: goto L_0x0009;
                case 31: goto L_0x000c;
                default: goto L_0x0008;
            }
        L_0x0008:
            goto L_0x0000
        L_0x0009:
            switch(r0) {
                case 57: goto L_0x002c;
                case 58: goto L_0x0038;
                case 59: goto L_0x0041;
                default: goto L_0x000c;
            }
        L_0x000c:
            r0 = 39
            switch(r0) {
                case 39: goto L_0x0050;
                case 40: goto L_0x0012;
                case 41: goto L_0x001f;
                default: goto L_0x0011;
            }
        L_0x0011:
            goto L_0x000c
        L_0x0012:
            r0 = 29
            int r1 = 29 - r2
            int r1 = r1 * r0
            int r0 = r0 * 2
            int r0 = r0 - r2
            int r1 = r1 * r0
            int r1 = r1 % 6
            if (r1 == 0) goto L_0x0050
        L_0x001f:
            r0 = 38
            int r1 = 38 - r2
            int r1 = r1 * r0
            int r0 = r0 * 2
            int r0 = r0 - r2
            int r1 = r1 * r0
            int r1 = r1 % 6
            if (r1 == 0) goto L_0x000c
        L_0x002c:
            r0 = 7
            int r1 = 7 - r2
            int r1 = r1 * r0
            int r0 = r0 * 2
            int r0 = r0 - r2
            int r1 = r1 * r0
            int r1 = r1 % 6
            if (r1 == 0) goto L_0x0000
        L_0x0038:
            r0 = 17
            int r0 = r0 + r2
            int r0 = r0 * 17
            int r0 = r0 % 2
            if (r0 == 0) goto L_0x000c
        L_0x0041:
            r0 = 12
            r1 = 37
            int r3 = r0 * r0
            int r4 = r1 * r1
            int r3 = r3 + r4
            int r0 = r0 * r1
            int r0 = r0 * 2
            int r3 = r3 - r0
            if (r3 >= 0) goto L_0x0012
        L_0x0050:
            r2 = r7
            r3 = r8
            r4 = r9
            r5 = r10
            if (r3 != 0) goto L_0x0057
            return
        L_0x0057:
            org.json.JSONObject r6 = new org.json.JSONObject
            r6.<init>()
            org.json.JSONObject r7 = new org.json.JSONObject     // Catch:{ Exception -> 0x0092 }
            r7.<init>()     // Catch:{ Exception -> 0x0092 }
            if (r11 == 0) goto L_0x0085
            java.util.Set r8 = r11.entrySet()     // Catch:{ Exception -> 0x0092 }
            java.util.Iterator r8 = r8.iterator()     // Catch:{ Exception -> 0x0092 }
        L_0x006b:
            boolean r9 = r8.hasNext()     // Catch:{ Exception -> 0x0092 }
            if (r9 == 0) goto L_0x0085
            java.lang.Object r9 = r8.next()     // Catch:{ Exception -> 0x0092 }
            java.util.Map$Entry r9 = (java.util.Map.Entry) r9     // Catch:{ Exception -> 0x0092 }
            java.lang.Object r10 = r9.getKey()     // Catch:{ Exception -> 0x0092 }
            java.lang.String r10 = (java.lang.String) r10     // Catch:{ Exception -> 0x0092 }
            java.lang.Object r9 = r9.getValue()     // Catch:{ Exception -> 0x0092 }
            r7.put(r10, r9)     // Catch:{ Exception -> 0x0092 }
            goto L_0x006b
        L_0x0085:
            java.lang.String r8 = "ae]f|qtfWmkm"
            java.lang.String r8 = com.bytedance.sdk.component.d.c.f.f1667305730962dc(r8)     // Catch:{ Exception -> 0x0092 }
            java.lang.String r7 = r7.toString()     // Catch:{ Exception -> 0x0092 }
            r6.put(r8, r7)     // Catch:{ Exception -> 0x0092 }
        L_0x0092:
            long r0 = java.lang.System.currentTimeMillis()
            b((long) r0, (android.content.Context) r2, (com.bytedance.sdk.openadsdk.core.model.n) r3, (java.lang.String) r4, (java.lang.String) r5, (org.json.JSONObject) r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.c.c.d(android.content.Context, com.bytedance.sdk.openadsdk.core.model.n, java.lang.String, java.lang.String, java.util.Map):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x002e, code lost:
        r13 = r2;
        r9 = r4;
        r10 = r5;
        r11 = r6;
        r12 = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x003a, code lost:
        if ((((17 + 1) * 17) % 2) == 0) goto L_0x0000;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0049, code lost:
        if ((((12 * 12) + (37 * 37)) - ((12 * 37) * 2)) >= 0) goto L_0x004c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0065, code lost:
        if (((((38 - 1) * 38) * ((38 * 2) - 1)) % 6) == 0) goto L_0x00b5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0007, code lost:
        r4 = r9;
        r5 = r10;
        r6 = r11;
        r7 = r12;
        r2 = r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00b5, code lost:
        r13 = r2;
        r9 = r4;
        r10 = r5;
        r11 = r6;
        r12 = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0000, code lost:
        continue;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0000, code lost:
        continue;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0014, code lost:
        switch(31) {
            case 29: goto L_0x00b5;
            case 30: goto L_0x0018;
            case 31: goto L_0x0068;
            default: goto L_0x0017;
        };
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0018, code lost:
        switch(39) {
            case 57: goto L_0x0022;
            case 58: goto L_0x002e;
            case 59: goto L_0x001c;
            default: goto L_0x001b;
        };
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x001c, code lost:
        r13 = r2;
        r9 = r4;
        r10 = r5;
        r11 = r6;
        r12 = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x002c, code lost:
        if (((((7 - 1) * 7) * ((7 * 2) - 1)) % 6) == 0) goto L_0x0012;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void e(android.content.Context r9, com.bytedance.sdk.openadsdk.core.model.n r10, java.lang.String r11, java.lang.String r12, java.util.Map<java.lang.String, java.lang.Object> r13) {
        /*
        L_0x0000:
            r0 = 39
            r1 = 1
            switch(r0) {
                case 39: goto L_0x000d;
                case 40: goto L_0x004c;
                case 41: goto L_0x0007;
                default: goto L_0x0006;
            }
        L_0x0006:
            goto L_0x0000
        L_0x0007:
            r4 = r9
            r5 = r10
            r6 = r11
            r7 = r12
            r2 = r13
            goto L_0x005a
        L_0x000d:
            r4 = r9
            r5 = r10
            r6 = r11
            r7 = r12
            r2 = r13
        L_0x0012:
            r9 = 31
            switch(r9) {
                case 29: goto L_0x00b5;
                case 30: goto L_0x0018;
                case 31: goto L_0x0068;
                default: goto L_0x0017;
            }
        L_0x0017:
            goto L_0x0012
        L_0x0018:
            switch(r0) {
                case 57: goto L_0x0022;
                case 58: goto L_0x002e;
                case 59: goto L_0x001c;
                default: goto L_0x001b;
            }
        L_0x001b:
            goto L_0x0068
        L_0x001c:
            r13 = r2
            r9 = r4
            r10 = r5
            r11 = r6
            r12 = r7
            goto L_0x003c
        L_0x0022:
            r9 = 7
            int r10 = 7 - r1
            int r10 = r10 * r9
            int r9 = r9 * 2
            int r9 = r9 - r1
            int r10 = r10 * r9
            int r10 = r10 % 6
            if (r10 == 0) goto L_0x0012
        L_0x002e:
            r13 = r2
            r9 = r4
            r10 = r5
            r11 = r6
            r12 = r7
            r2 = 17
            int r2 = r2 + r1
            int r2 = r2 * 17
            int r2 = r2 % 2
            if (r2 == 0) goto L_0x0000
        L_0x003c:
            r2 = 12
            r3 = 37
            int r4 = r2 * r2
            int r5 = r3 * r3
            int r4 = r4 + r5
            int r2 = r2 * r3
            int r2 = r2 * 2
            int r4 = r4 - r2
            if (r4 >= 0) goto L_0x004c
            goto L_0x0000
        L_0x004c:
            r2 = 29
            int r3 = 29 - r1
            int r3 = r3 * r2
            int r2 = r2 * 2
            int r2 = r2 - r1
            int r3 = r3 * r2
            int r3 = r3 % 6
            if (r3 == 0) goto L_0x0000
            goto L_0x0007
        L_0x005a:
            r9 = 38
            int r10 = 38 - r1
            int r10 = r10 * r9
            int r9 = r9 * 2
            int r9 = r9 - r1
            int r10 = r10 * r9
            int r10 = r10 % 6
            if (r10 == 0) goto L_0x00b5
            goto L_0x0022
        L_0x0068:
            if (r5 != 0) goto L_0x006b
            return
        L_0x006b:
            org.json.JSONObject r8 = new org.json.JSONObject
            r8.<init>()
            org.json.JSONObject r9 = new org.json.JSONObject     // Catch:{ JSONException -> 0x00a7 }
            r9.<init>()     // Catch:{ JSONException -> 0x00a7 }
            if (r2 == 0) goto L_0x0099
            java.util.Set r10 = r2.entrySet()     // Catch:{ JSONException -> 0x00a7 }
            java.util.Iterator r10 = r10.iterator()     // Catch:{ JSONException -> 0x00a7 }
        L_0x007f:
            boolean r11 = r10.hasNext()     // Catch:{ JSONException -> 0x00a7 }
            if (r11 == 0) goto L_0x0099
            java.lang.Object r11 = r10.next()     // Catch:{ JSONException -> 0x00a7 }
            java.util.Map$Entry r11 = (java.util.Map.Entry) r11     // Catch:{ JSONException -> 0x00a7 }
            java.lang.Object r12 = r11.getKey()     // Catch:{ JSONException -> 0x00a7 }
            java.lang.String r12 = (java.lang.String) r12     // Catch:{ JSONException -> 0x00a7 }
            java.lang.Object r11 = r11.getValue()     // Catch:{ JSONException -> 0x00a7 }
            r9.put(r12, r11)     // Catch:{ JSONException -> 0x00a7 }
            goto L_0x007f
        L_0x0099:
            java.lang.String r10 = "ae]f|qtfWmkm"
            java.lang.String r10 = com.bytedance.sdk.component.adexpress.widget.FlowLightView.FlowLightView1667305730929dc(r10)     // Catch:{ JSONException -> 0x00a7 }
            java.lang.String r9 = r9.toString()     // Catch:{ JSONException -> 0x00a7 }
            r8.put(r10, r9)     // Catch:{ JSONException -> 0x00a7 }
            goto L_0x00ad
        L_0x00a7:
            r9 = move-exception
            org.json.JSONException r9 = (org.json.JSONException) r9
            r9.printStackTrace()
        L_0x00ad:
            long r2 = java.lang.System.currentTimeMillis()
            b((long) r2, (android.content.Context) r4, (com.bytedance.sdk.openadsdk.core.model.n) r5, (java.lang.String) r6, (java.lang.String) r7, (org.json.JSONObject) r8)
            return
        L_0x00b5:
            r13 = r2
            r9 = r4
            r10 = r5
            r11 = r6
            r12 = r7
            goto L_0x0000
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.c.c.e(android.content.Context, com.bytedance.sdk.openadsdk.core.model.n, java.lang.String, java.lang.String, java.util.Map):void");
    }
}
