package com.bytedance.sdk.openadsdk.core;

import android.content.Context;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.bytedance.JProtect;
import com.bytedance.sdk.component.a.j;
import com.bytedance.sdk.component.adexpress.widget.FlowLightView;
import com.bytedance.sdk.component.d.c.c;
import com.bytedance.sdk.component.d.c.f;
import com.bytedance.sdk.component.d.k;
import com.bytedance.sdk.component.f.c.d;
import com.bytedance.sdk.component.utils.l;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.FilterWord;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import com.bytedance.sdk.openadsdk.api.init.PAGSdk;
import com.bytedance.sdk.openadsdk.core.model.n;
import com.bytedance.sdk.openadsdk.core.model.s;
import com.bytedance.sdk.openadsdk.core.n;
import com.bytedance.sdk.openadsdk.l.e;
import com.bytedance.sdk.openadsdk.l.x;
import com.bytedance.sdk.openadsdk.l.y;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: NetApiImpl */
public class o implements n<com.bytedance.sdk.openadsdk.c.a> {
    private static volatile boolean f = false;
    private static boolean h = true;
    private final Context a;
    private final boolean b;
    private final String c;
    private long d;
    private int e;
    private com.bytedance.sdk.component.d.o g = new com.bytedance.sdk.component.d.o() {
        public void a(int i, String str, Throwable th) {
        }

        public void a(k kVar) {
        }
    };

    /* compiled from: NetApiImpl */
    public static class a {
        final int a;
        final long b;
        final long c;
        final int d;
        final String e;
        final int f;
        final String g;
        public final com.bytedance.sdk.openadsdk.core.model.a h;
        final String i;
        final ArrayList<Integer> j;

        private a(String str, int i2, int i3, String str2, int i4, String str3, com.bytedance.sdk.openadsdk.core.model.a aVar, long j2, long j3, ArrayList<Integer> arrayList) {
            this.a = i2;
            this.d = i3;
            this.e = str2;
            this.g = str3;
            this.h = aVar;
            this.i = str;
            this.f = i4;
            this.b = j2;
            this.c = j3;
            this.j = arrayList;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:11:0x003b, code lost:
            if (((3 * 3) - ((5 * 5) * 34)) != -1) goto L_0x0022;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:37:0x0002, code lost:
            continue;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:42:0x0022, code lost:
            continue;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public static com.bytedance.sdk.openadsdk.core.o.a a(org.json.JSONObject r16, com.bytedance.sdk.openadsdk.AdSlot r17, com.bytedance.sdk.openadsdk.core.model.o r18) {
            /*
                r0 = r16
            L_0x0002:
                r1 = 3
                r2 = 9
                r3 = 1
                r4 = 92
                switch(r4) {
                    case 90: goto L_0x0048;
                    case 91: goto L_0x000c;
                    case 92: goto L_0x0022;
                    default: goto L_0x000b;
                }
            L_0x000b:
                goto L_0x0002
            L_0x000c:
                r5 = 28
                r6 = 19
                int r7 = r2 * r2
                int r7 = r7 * r2
                int r8 = r5 * r5
                int r8 = r8 * r5
                int r7 = r7 + r8
                int r8 = r6 * r6
                int r8 = r8 * r6
                int r7 = r7 + r8
                r8 = 9
                int r8 = r8 * r5
                int r8 = r8 * r6
                int r8 = r8 * r1
                if (r7 >= r8) goto L_0x0071
            L_0x0022:
                switch(r2) {
                    case 9: goto L_0x0071;
                    case 10: goto L_0x0026;
                    case 11: goto L_0x0002;
                    default: goto L_0x0025;
                }
            L_0x0025:
                goto L_0x0022
            L_0x0026:
                r5 = -1
                switch(r4) {
                    case 40: goto L_0x002b;
                    case 41: goto L_0x0034;
                    case 42: goto L_0x003d;
                    default: goto L_0x002a;
                }
            L_0x002a:
                goto L_0x0002
            L_0x002b:
                r6 = 37
                int r6 = r6 + r3
                int r6 = r6 * 37
                int r6 = r6 % 2
                if (r6 == 0) goto L_0x0071
            L_0x0034:
                int r6 = r1 * r1
                r7 = 5
                int r7 = r7 * r7
                int r7 = r7 * 34
                int r6 = r6 - r7
                if (r6 != r5) goto L_0x0022
            L_0x003d:
                r6 = 71
                int r6 = r6 * r6
                r7 = 25
                int r7 = r7 * r7
                int r7 = r7 * 34
                int r6 = r6 - r7
                if (r6 != r5) goto L_0x0022
            L_0x0048:
                r1 = 39
                r2 = 94
                if (r2 == r1) goto L_0x004f
                goto L_0x0065
            L_0x004f:
                r1 = 18
                r2 = 16
                int r4 = r4 * r4
                int r5 = r1 * r1
                int r4 = r4 + r5
                int r5 = r2 * r2
                int r4 = r4 + r5
                r5 = 92
                int r5 = r5 * r1
                int r1 = r1 * r2
                int r5 = r5 + r1
                r1 = 92
                int r1 = r1 * r2
                int r5 = r5 + r1
                if (r4 >= r5) goto L_0x0071
            L_0x0065:
                r1 = 77
                int r2 = 77 - r3
                int r2 = r2 * r1
                int r1 = r1 * 2
                int r1 = r1 - r3
                int r2 = r2 * r1
                int r2 = r2 % 6
                goto L_0x0002
            L_0x0071:
                java.lang.String r1 = "dhf"
                java.lang.String r1 = com.bytedance.sdk.component.a.j.j1667305730992dc(r1)
                java.lang.String r3 = r0.optString(r1)
                java.lang.String r1 = "psm`avunfnUe`kP}b"
                java.lang.String r1 = com.bytedance.sdk.component.a.j.j1667305730992dc(r1)
                int r4 = r0.optInt(r1)
                java.lang.String r1 = "s^pfg`oqmV~x"
                java.lang.String r1 = com.bytedance.sdk.component.a.j.j1667305730992dc(r1)
                long r10 = r0.optLong(r1)
                java.lang.String r1 = "s^qfjaYs{"
                java.lang.String r1 = com.bytedance.sdk.component.a.j.j1667305730992dc(r1)
                long r12 = r0.optLong(r1)
                java.lang.String r1 = "sucwqvYdgmo"
                java.lang.String r1 = com.bytedance.sdk.component.a.j.j1667305730992dc(r1)
                int r5 = r0.optInt(r1)
                java.lang.String r1 = "ddq`"
                java.lang.String r1 = com.bytedance.sdk.component.a.j.j1667305730992dc(r1)
                java.lang.String r6 = r0.optString(r1)
                java.lang.String r1 = "rdsvavrXam"
                java.lang.String r1 = com.bytedance.sdk.component.a.j.j1667305730992dc(r1)
                java.lang.String r8 = r0.optString(r1)
                java.lang.String r1 = "rdcpkk"
                java.lang.String r1 = com.bytedance.sdk.component.a.j.j1667305730992dc(r1)
                int r7 = r0.optInt(r1)
                android.util.Pair r1 = com.bytedance.sdk.openadsdk.core.b.a((org.json.JSONObject) r16, (com.bytedance.sdk.openadsdk.AdSlot) r17, (com.bytedance.sdk.openadsdk.core.model.o) r18)
                if (r1 == 0) goto L_0x00dc
                java.lang.Object r2 = r1.first
                if (r2 == 0) goto L_0x00dc
                java.lang.Object r2 = r1.first
                com.bytedance.sdk.openadsdk.core.model.a r2 = (com.bytedance.sdk.openadsdk.core.model.a) r2
                java.lang.String r9 = "rdsvavrXio~n~"
                java.lang.String r9 = com.bytedance.sdk.component.a.j.j1667305730992dc(r9)
                long r14 = r0.optLong(r9)
                r2.a((long) r14)
            L_0x00dc:
                com.bytedance.sdk.openadsdk.core.o$a r0 = new com.bytedance.sdk.openadsdk.core.o$a
                if (r1 != 0) goto L_0x00e7
                r9 = 0
                r14 = 0
                r2 = r0
                r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r12, r14)
                return r0
            L_0x00e7:
                java.lang.Object r2 = r1.first
                r9 = r2
                com.bytedance.sdk.openadsdk.core.model.a r9 = (com.bytedance.sdk.openadsdk.core.model.a) r9
                java.lang.Object r1 = r1.second
                r14 = r1
                java.util.ArrayList r14 = (java.util.ArrayList) r14
                r2 = r0
                r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r12, r14)
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.o.a.a(org.json.JSONObject, com.bytedance.sdk.openadsdk.AdSlot, com.bytedance.sdk.openadsdk.core.model.o):com.bytedance.sdk.openadsdk.core.o$a");
        }
    }

    /* compiled from: NetApiImpl */
    public static class b {
        public final int a;
        public final boolean b;
        public final s c;

        private b(int i, boolean z, s sVar) {
            this.a = i;
            this.b = z;
            this.c = sVar;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:12:0x004d, code lost:
            if (((((26 * 26) * 26) + ((9 * 9) * 9)) + ((15 * 15) * 15)) >= (((26 * 9) * 15) * 3)) goto L_0x0075;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x004f, code lost:
            r1 = (((40 - 1) * 40) * ((40 * 2) - 1)) % 6;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public static com.bytedance.sdk.openadsdk.core.o.b a(org.json.JSONObject r7) {
            /*
            L_0x0000:
                r0 = 49
                r1 = 60
                r2 = -1
                r3 = 1
                switch(r1) {
                    case 60: goto L_0x000a;
                    case 61: goto L_0x0038;
                    case 62: goto L_0x004f;
                    default: goto L_0x0009;
                }
            L_0x0009:
                goto L_0x0000
            L_0x000a:
                switch(r0) {
                    case 49: goto L_0x005a;
                    case 50: goto L_0x000e;
                    case 51: goto L_0x000e;
                    default: goto L_0x000d;
                }
            L_0x000d:
                goto L_0x0038
            L_0x000e:
                r0 = 87
                int r1 = 87 - r3
                int r1 = r1 * r0
                int r0 = r0 * 2
                int r0 = r0 - r3
                int r1 = r1 * r0
                int r1 = r1 % 6
                if (r1 == 0) goto L_0x001c
                goto L_0x005a
            L_0x001c:
                r0 = 94
                r1 = r0
            L_0x001f:
                switch(r1) {
                    case 55: goto L_0x0023;
                    case 56: goto L_0x002b;
                    case 57: goto L_0x0000;
                    default: goto L_0x0022;
                }
            L_0x0022:
                goto L_0x0035
            L_0x0023:
                r1 = 94
                int r1 = r1 + r3
                int r1 = r1 * r0
                int r1 = r1 % 2
                if (r1 == 0) goto L_0x005a
            L_0x002b:
                r0 = 18
                int r0 = r0 * r0
                r1 = 35
                int r1 = r1 * r1
                int r1 = r1 * 34
                int r0 = r0 - r1
                goto L_0x0000
            L_0x0035:
                r1 = 56
                goto L_0x001f
            L_0x0038:
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
                if (r5 >= r0) goto L_0x0075
            L_0x004f:
                r0 = 40
                int r1 = 40 - r3
                int r1 = r1 * r0
                int r0 = r0 * 2
                int r0 = r0 - r3
                int r1 = r1 * r0
                int r1 = r1 % 6
            L_0x005a:
                r0 = 53
                switch(r0) {
                    case 52: goto L_0x006a;
                    case 53: goto L_0x0075;
                    case 54: goto L_0x0060;
                    default: goto L_0x005f;
                }
            L_0x005f:
                goto L_0x005a
            L_0x0060:
                r0 = 61
                int r0 = r0 * r0
                r1 = 12
                int r1 = r1 * r1
                int r1 = r1 * 34
                int r0 = r0 - r1
                goto L_0x005a
            L_0x006a:
                r0 = 13
                int r0 = r0 * r0
                r1 = 19
                int r1 = r1 * r1
                int r1 = r1 * 34
                int r0 = r0 - r1
                if (r0 != r2) goto L_0x006a
            L_0x0075:
                if (r7 != 0) goto L_0x0079
                r7 = 0
                return r7
            L_0x0079:
                java.lang.String r0 = "cnff"
                java.lang.String r0 = com.bytedance.sdk.component.f.c.a.a1667305730924dc(r0)
                int r0 = r7.optInt(r0)
                java.lang.String r1 = "vdpjb|"
                java.lang.String r1 = com.bytedance.sdk.component.f.c.a.a1667305730924dc(r1)
                boolean r1 = r7.optBoolean(r1)
                java.lang.String r2 = "d`vb"
                java.lang.String r2 = com.bytedance.sdk.component.f.c.a.a1667305730924dc(r2)
                org.json.JSONObject r7 = r7.optJSONObject(r2)
                com.bytedance.sdk.openadsdk.core.model.s r2 = new com.bytedance.sdk.openadsdk.core.model.s
                r2.<init>()
                if (r7 == 0) goto L_0x00d7
                java.lang.String r3 = "rdcpkk"
                java.lang.String r3 = com.bytedance.sdk.component.f.c.a.a1667305730924dc(r3)     // Catch:{ all -> 0x00d3 }
                int r3 = r7.optInt(r3)     // Catch:{ all -> 0x00d3 }
                r2.a((int) r3)     // Catch:{ all -> 0x00d3 }
                java.lang.String r3 = "cnps[qwm"
                java.lang.String r3 = com.bytedance.sdk.component.f.c.a.a1667305730924dc(r3)     // Catch:{ all -> 0x00d3 }
                int r3 = r7.optInt(r3)     // Catch:{ all -> 0x00d3 }
                r2.b(r3)     // Catch:{ all -> 0x00d3 }
                java.lang.String r3 = "rdubvaYfefex"
                java.lang.String r3 = com.bytedance.sdk.component.f.c.a.a1667305730924dc(r3)     // Catch:{ all -> 0x00d3 }
                int r3 = r7.optInt(r3)     // Catch:{ all -> 0x00d3 }
                r2.c(r3)     // Catch:{ all -> 0x00d3 }
                java.lang.String r3 = "rdubvaYiido"
                java.lang.String r3 = com.bytedance.sdk.component.f.c.a.a1667305730924dc(r3)     // Catch:{ all -> 0x00d3 }
                java.lang.String r7 = r7.optString(r3)     // Catch:{ all -> 0x00d3 }
                r2.a((java.lang.String) r7)     // Catch:{ all -> 0x00d3 }
                goto L_0x00d7
            L_0x00d3:
                r7 = move-exception
                r7.printStackTrace()
            L_0x00d7:
                com.bytedance.sdk.openadsdk.core.o$b r7 = new com.bytedance.sdk.openadsdk.core.o$b
                r7.<init>(r0, r1, r2)
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.o.b.a(org.json.JSONObject):com.bytedance.sdk.openadsdk.core.o$b");
        }
    }

    o(Context context) {
        this.a = context;
        this.b = e();
        this.c = g();
    }

    /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP_START, MTH_ENTER_BLOCK] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ android.content.Context a(com.bytedance.sdk.openadsdk.core.o r5) {
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
            android.content.Context r5 = r5.a
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.o.a(com.bytedance.sdk.openadsdk.core.o):android.content.Context");
    }

    private static String a(int i) {
        String str;
        if (i != 120) {
            if (i != 160) {
                if (i == 240) {
                    str = "herj";
                } else if (i == 320) {
                    str = "xifsm";
                } else if (i == 480) {
                    str = "xyjgtl";
                } else if (i == 640) {
                    str = "xyzk`uo";
                }
            }
            return j.j1667305730992dc("merj");
        }
        str = "lerj";
        return j.j1667305730992dc(str);
    }

    public static String a(Context context) {
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(c.b.c$b1667305730972dc("pimma"));
            return telephonyManager == null ? "" : telephonyManager.getSimOperator();
        } catch (Throwable unused) {
            return "";
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0028, code lost:
        if (((((76 - 1) * 76) * ((76 * 2) - 1)) % 6) == 0) goto L_0x006f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static org.json.JSONObject a(com.bytedance.sdk.openadsdk.AdSlot r6) {
        /*
        L_0x0000:
            r0 = 72
            switch(r0) {
                case 71: goto L_0x001c;
                case 72: goto L_0x001a;
                case 73: goto L_0x0006;
                default: goto L_0x0005;
            }
        L_0x0005:
            goto L_0x0000
        L_0x0006:
            r0 = 89
            r1 = 3
            r2 = 13
            int r3 = r0 * r0
            int r4 = r1 * r1
            int r3 = r3 + r4
            int r4 = r2 * r2
            int r3 = r3 + r4
            r4 = 89
            int r4 = r4 * r1
            int r1 = r1 * r2
            int r4 = r4 + r1
            int r0 = r0 * r2
            int r4 = r4 + r0
        L_0x001a:
            r0 = r6
            goto L_0x002b
        L_0x001c:
            r0 = 76
            r1 = 1
            int r2 = 76 - r1
            int r2 = r2 * r0
            int r0 = r0 * 2
            int r0 = r0 - r1
            int r2 = r2 * r0
            int r2 = r2 % 6
            if (r2 == 0) goto L_0x006f
            goto L_0x001a
        L_0x002b:
            r6 = 12
            switch(r6) {
                case 12: goto L_0x006e;
                case 13: goto L_0x0031;
                case 14: goto L_0x0031;
                default: goto L_0x0030;
            }
        L_0x0030:
            goto L_0x002b
        L_0x0031:
            r1 = 63
            int r1 = r1 * r1
            r2 = 48
            int r2 = r2 * r2
            int r2 = r2 * 34
            int r1 = r1 - r2
            r2 = -1
            if (r1 != r2) goto L_0x003e
            goto L_0x006e
        L_0x003e:
            r1 = 4
            r2 = 32
            r3 = 25
            int r4 = r1 * r1
            int r5 = r2 * r2
            int r4 = r4 + r5
            int r5 = r3 * r3
            int r4 = r4 + r5
            r5 = 4
            int r5 = r5 * r2
            int r2 = r2 * r3
            int r5 = r5 + r2
            int r1 = r1 * r3
            int r5 = r5 + r1
            if (r4 >= r5) goto L_0x006c
            r1 = 46
            r2 = 27
            int r3 = r1 * r1
            int r4 = r6 * r6
            int r3 = r3 + r4
            int r4 = r2 * r2
            int r3 = r3 + r4
            r4 = 46
            int r4 = r4 * r6
            r6 = 12
            int r6 = r6 * r2
            int r4 = r4 + r6
            int r1 = r1 * r2
            int r4 = r4 + r1
            if (r3 >= r4) goto L_0x006e
            r6 = r0
            goto L_0x001c
        L_0x006c:
            r6 = r0
            goto L_0x0000
        L_0x006e:
            r6 = r0
        L_0x006f:
            org.json.JSONObject r0 = new org.json.JSONObject
            r0.<init>()
            com.bytedance.sdk.openadsdk.core.settings.j r1 = com.bytedance.sdk.openadsdk.core.m.d()     // Catch:{ Exception -> 0x014c }
            java.lang.String r2 = "pdppkkgkasooSlj"
            java.lang.String r2 = com.bytedance.sdk.component.adexpress.widget.DynamicUnlockView.DynamicUnlockView1667305730929dc(r2)     // Catch:{ Exception -> 0x014c }
            int r1 = r1.J()     // Catch:{ Exception -> 0x014c }
            r0.put(r2, r1)     // Catch:{ Exception -> 0x014c }
            java.lang.String r1 = "llv"
            java.lang.String r1 = com.bytedance.sdk.component.adexpress.widget.DynamicUnlockView.DynamicUnlockView1667305730929dc(r1)     // Catch:{ Exception -> 0x014c }
            int r2 = com.bytedance.sdk.openadsdk.l.e.b()     // Catch:{ Exception -> 0x014c }
            r0.put(r1, r2)     // Catch:{ Exception -> 0x014c }
            java.lang.String r1 = "cnrse"
            java.lang.String r1 = com.bytedance.sdk.component.adexpress.widget.DynamicUnlockView.DynamicUnlockView1667305730929dc(r1)     // Catch:{ Exception -> 0x014c }
            com.bytedance.sdk.openadsdk.core.h r2 = com.bytedance.sdk.openadsdk.core.h.d()     // Catch:{ Exception -> 0x014c }
            int r2 = r2.k()     // Catch:{ Exception -> 0x014c }
            r0.put(r1, r2)     // Catch:{ Exception -> 0x014c }
            java.lang.String r1 = "gerq"
            java.lang.String r1 = com.bytedance.sdk.component.adexpress.widget.DynamicUnlockView.DynamicUnlockView1667305730929dc(r1)     // Catch:{ Exception -> 0x014c }
            com.bytedance.sdk.openadsdk.core.h r2 = com.bytedance.sdk.openadsdk.core.h.d()     // Catch:{ Exception -> 0x014c }
            int r2 = r2.j()     // Catch:{ Exception -> 0x014c }
            r0.put(r1, r2)     // Catch:{ Exception -> 0x014c }
            java.lang.String r1 = "ir]d`utX}zoy"
            java.lang.String r1 = com.bytedance.sdk.component.adexpress.widget.DynamicUnlockView.DynamicUnlockView1667305730929dc(r1)     // Catch:{ Exception -> 0x014c }
            com.bytedance.sdk.openadsdk.core.settings.j r2 = com.bytedance.sdk.openadsdk.core.m.d()     // Catch:{ Exception -> 0x014c }
            int r2 = r2.G()     // Catch:{ Exception -> 0x014c }
            r0.put(r1, r2)     // Catch:{ Exception -> 0x014c }
            java.lang.String r1 = "cbrb"
            java.lang.String r1 = com.bytedance.sdk.component.adexpress.widget.DynamicUnlockView.DynamicUnlockView1667305730929dc(r1)     // Catch:{ Exception -> 0x014c }
            com.bytedance.sdk.openadsdk.core.h r2 = com.bytedance.sdk.openadsdk.core.h.d()     // Catch:{ Exception -> 0x014c }
            int r2 = r2.v()     // Catch:{ Exception -> 0x014c }
            r0.put(r1, r2)     // Catch:{ Exception -> 0x014c }
            if (r6 == 0) goto L_0x012e
            java.util.concurrent.ConcurrentHashMap<java.lang.Integer, com.bytedance.sdk.openadsdk.core.p> r1 = com.bytedance.sdk.openadsdk.core.p.a     // Catch:{ Exception -> 0x014c }
            java.lang.String r2 = r6.getCodeId()     // Catch:{ Exception -> 0x014c }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ Exception -> 0x014c }
            boolean r1 = r1.containsKey(r2)     // Catch:{ Exception -> 0x014c }
            if (r1 == 0) goto L_0x012e
            java.util.concurrent.ConcurrentHashMap<java.lang.Integer, com.bytedance.sdk.openadsdk.core.p> r1 = com.bytedance.sdk.openadsdk.core.p.a     // Catch:{ Exception -> 0x014c }
            java.lang.String r2 = r6.getCodeId()     // Catch:{ Exception -> 0x014c }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ Exception -> 0x014c }
            java.lang.Object r1 = r1.get(r2)     // Catch:{ Exception -> 0x014c }
            com.bytedance.sdk.openadsdk.core.p r1 = (com.bytedance.sdk.openadsdk.core.p) r1     // Catch:{ Exception -> 0x014c }
            if (r1 == 0) goto L_0x012e
            java.lang.String r2 = "l`qweaiji`d"
            java.lang.String r2 = com.bytedance.sdk.component.adexpress.widget.DynamicUnlockView.DynamicUnlockView1667305730929dc(r2)     // Catch:{ Exception -> 0x014c }
            java.lang.String r3 = r1.b()     // Catch:{ Exception -> 0x014c }
            r0.put(r2, r3)     // Catch:{ Exception -> 0x014c }
            java.lang.String r2 = "l`qwfphcdl"
            java.lang.String r2 = com.bytedance.sdk.component.adexpress.widget.DynamicUnlockView.DynamicUnlockView1667305730929dc(r2)     // Catch:{ Exception -> 0x014c }
            java.lang.String r3 = r1.c()     // Catch:{ Exception -> 0x014c }
            r0.put(r2, r3)     // Catch:{ Exception -> 0x014c }
            java.lang.String r2 = "l`qwgiodc"
            java.lang.String r2 = com.bytedance.sdk.component.adexpress.widget.DynamicUnlockView.DynamicUnlockView1667305730929dc(r2)     // Catch:{ Exception -> 0x014c }
            int r3 = r1.d()     // Catch:{ Exception -> 0x014c }
            r0.put(r2, r3)     // Catch:{ Exception -> 0x014c }
            java.lang.String r2 = "l`qwwnow"
            java.lang.String r2 = com.bytedance.sdk.component.adexpress.widget.DynamicUnlockView.DynamicUnlockView1667305730929dc(r2)     // Catch:{ Exception -> 0x014c }
            int r1 = r1.e()     // Catch:{ Exception -> 0x014c }
            r0.put(r2, r1)     // Catch:{ Exception -> 0x014c }
        L_0x012e:
            java.lang.String r1 = "kd{tkwbt"
            java.lang.String r1 = com.bytedance.sdk.component.adexpress.widget.DynamicUnlockView.DynamicUnlockView1667305730929dc(r1)     // Catch:{ Exception -> 0x014c }
            com.bytedance.sdk.openadsdk.core.h r2 = com.bytedance.sdk.openadsdk.core.h.d()     // Catch:{ Exception -> 0x014c }
            java.lang.String r2 = r2.m()     // Catch:{ Exception -> 0x014c }
            a((org.json.JSONObject) r0, (java.lang.String) r1, (java.lang.String) r2)     // Catch:{ Exception -> 0x014c }
            java.lang.String r1 = "d`vb"
            java.lang.String r1 = com.bytedance.sdk.component.adexpress.widget.DynamicUnlockView.DynamicUnlockView1667305730929dc(r1)     // Catch:{ Exception -> 0x014c }
            java.lang.String r6 = b((com.bytedance.sdk.openadsdk.AdSlot) r6)     // Catch:{ Exception -> 0x014c }
            a((org.json.JSONObject) r0, (java.lang.String) r1, (java.lang.String) r6)     // Catch:{ Exception -> 0x014c }
        L_0x014c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.o.a(com.bytedance.sdk.openadsdk.AdSlot):org.json.JSONObject");
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x016a A[Catch:{ Exception -> 0x01c0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x016d A[Catch:{ Exception -> 0x01c0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x018b A[Catch:{ Exception -> 0x01c0 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private org.json.JSONObject a(com.bytedance.sdk.openadsdk.AdSlot r9, int r10, com.bytedance.sdk.openadsdk.core.model.o r11) {
        /*
            r8 = this;
        L_0x0000:
            r0 = 69
            r1 = 2
            r2 = 3
            r3 = 1
            switch(r0) {
                case 69: goto L_0x0041;
                case 70: goto L_0x0009;
                case 71: goto L_0x0020;
                default: goto L_0x0008;
            }
        L_0x0008:
            goto L_0x0000
        L_0x0009:
            r0 = 41
            r4 = 15
            r5 = 23
            int r6 = r0 * r0
            int r7 = r4 * r4
            int r6 = r6 + r7
            int r7 = r5 * r5
            int r6 = r6 + r7
            r7 = 41
            int r7 = r7 * r4
            int r4 = r4 * r5
            int r7 = r7 + r4
            int r0 = r0 * r5
            int r7 = r7 + r0
            if (r6 >= r7) goto L_0x0009
        L_0x0020:
            r0 = 92
            int r0 = r0 * r0
            r4 = 31
            int r4 = r4 * r4
            int r4 = r4 * 34
            int r0 = r0 - r4
            r4 = -1
            if (r0 != r4) goto L_0x002d
            goto L_0x0000
        L_0x002d:
            r0 = 21
            r4 = 24
            int r5 = r4 * r4
            int r5 = r5 * r4
            int r6 = r0 * r0
            int r6 = r6 * r0
            int r6 = r6 + r5
            int r6 = r6 + r5
            r5 = 24
            int r5 = r5 * r0
            int r5 = r5 * r4
            int r5 = r5 * r2
            if (r6 >= r5) goto L_0x002d
            goto L_0x004a
        L_0x0041:
            r0 = r1
        L_0x0042:
            if (r0 == r3) goto L_0x0000
            if (r0 == r1) goto L_0x01c1
            if (r0 == r2) goto L_0x004a
            r0 = r3
            goto L_0x0042
        L_0x004a:
            org.json.JSONObject r0 = new org.json.JSONObject
            r0.<init>()
            java.lang.String r4 = "ie"
            java.lang.String r4 = com.bytedance.sdk.component.d.c.c.b.c$b1667305730972dc(r4)     // Catch:{ Exception -> 0x01c0 }
            java.lang.String r5 = r9.getCodeId()     // Catch:{ Exception -> 0x01c0 }
            r0.put(r4, r5)     // Catch:{ Exception -> 0x01c0 }
            java.lang.String r4 = "aevzt`"
            java.lang.String r4 = com.bytedance.sdk.component.d.c.c.b.c$b1667305730972dc(r4)     // Catch:{ Exception -> 0x01c0 }
            r0.put(r4, r10)     // Catch:{ Exception -> 0x01c0 }
            java.lang.String r4 = r9.getAdId()     // Catch:{ Exception -> 0x01c0 }
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4     // Catch:{ Exception -> 0x01c0 }
            boolean r4 = android.text.TextUtils.isEmpty(r4)     // Catch:{ Exception -> 0x01c0 }
            if (r4 == 0) goto L_0x0089
            java.lang.String r4 = r9.getCreativeId()     // Catch:{ Exception -> 0x01c0 }
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4     // Catch:{ Exception -> 0x01c0 }
            boolean r4 = android.text.TextUtils.isEmpty(r4)     // Catch:{ Exception -> 0x01c0 }
            if (r4 == 0) goto L_0x0089
            java.lang.String r4 = r9.getExt()     // Catch:{ Exception -> 0x01c0 }
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4     // Catch:{ Exception -> 0x01c0 }
            boolean r4 = android.text.TextUtils.isEmpty(r4)     // Catch:{ Exception -> 0x01c0 }
            if (r4 != 0) goto L_0x00dc
        L_0x0089:
            org.json.JSONObject r4 = new org.json.JSONObject     // Catch:{ Exception -> 0x01c0 }
            r4.<init>()     // Catch:{ Exception -> 0x01c0 }
            java.lang.String r5 = r9.getAdId()     // Catch:{ Exception -> 0x01c0 }
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5     // Catch:{ Exception -> 0x01c0 }
            boolean r5 = android.text.TextUtils.isEmpty(r5)     // Catch:{ Exception -> 0x01c0 }
            if (r5 != 0) goto L_0x00a7
            java.lang.String r5 = "ae]j`"
            java.lang.String r5 = com.bytedance.sdk.component.d.c.c.b.c$b1667305730972dc(r5)     // Catch:{ Exception -> 0x01c0 }
            java.lang.String r6 = r9.getAdId()     // Catch:{ Exception -> 0x01c0 }
            r4.put(r5, r6)     // Catch:{ Exception -> 0x01c0 }
        L_0x00a7:
            java.lang.String r5 = r9.getCreativeId()     // Catch:{ Exception -> 0x01c0 }
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5     // Catch:{ Exception -> 0x01c0 }
            boolean r5 = android.text.TextUtils.isEmpty(r5)     // Catch:{ Exception -> 0x01c0 }
            if (r5 != 0) goto L_0x00c0
            java.lang.String r5 = "csgbplpbW`n"
            java.lang.String r5 = com.bytedance.sdk.component.d.c.c.b.c$b1667305730972dc(r5)     // Catch:{ Exception -> 0x01c0 }
            java.lang.String r6 = r9.getCreativeId()     // Catch:{ Exception -> 0x01c0 }
            r4.put(r5, r6)     // Catch:{ Exception -> 0x01c0 }
        L_0x00c0:
            java.lang.String r5 = r9.getExt()     // Catch:{ Exception -> 0x01c0 }
            if (r5 == 0) goto L_0x00d3
            java.lang.String r5 = "eyv"
            java.lang.String r5 = com.bytedance.sdk.component.d.c.c.b.c$b1667305730972dc(r5)     // Catch:{ Exception -> 0x01c0 }
            java.lang.String r6 = r9.getExt()     // Catch:{ Exception -> 0x01c0 }
            r4.put(r5, r6)     // Catch:{ Exception -> 0x01c0 }
        L_0x00d3:
            java.lang.String r5 = "psgum`qXimy"
            java.lang.String r5 = com.bytedance.sdk.component.d.c.c.b.c$b1667305730972dc(r5)     // Catch:{ Exception -> 0x01c0 }
            r0.put(r5, r4)     // Catch:{ Exception -> 0x01c0 }
        L_0x00dc:
            java.lang.String r4 = "rdlgawYjm}bdh"
            java.lang.String r5 = "abaftqccWzcqi"
            if (r11 == 0) goto L_0x0113
            java.lang.String r4 = com.bytedance.sdk.component.d.c.c.b.c$b1667305730972dc(r4)     // Catch:{ Exception -> 0x01c0 }
            int r6 = r11.f     // Catch:{ Exception -> 0x01c0 }
            r0.put(r4, r6)     // Catch:{ Exception -> 0x01c0 }
            int r4 = r11.f     // Catch:{ Exception -> 0x01c0 }
            if (r4 != r3) goto L_0x00ff
            java.lang.String r1 = com.bytedance.sdk.component.d.c.c.b.c$b1667305730972dc(r5)     // Catch:{ Exception -> 0x01c0 }
            int r4 = r9.getImgAcceptedWidth()     // Catch:{ Exception -> 0x01c0 }
        L_0x00f7:
            int r5 = r9.getImgAcceptedHeight()     // Catch:{ Exception -> 0x01c0 }
            r8.a((org.json.JSONObject) r0, (java.lang.String) r1, (int) r4, (int) r5)     // Catch:{ Exception -> 0x01c0 }
            goto L_0x0123
        L_0x00ff:
            int r4 = r11.f     // Catch:{ Exception -> 0x01c0 }
            if (r4 != r1) goto L_0x0123
            java.lang.String r1 = com.bytedance.sdk.component.d.c.c.b.c$b1667305730972dc(r5)     // Catch:{ Exception -> 0x01c0 }
            float r4 = r9.getExpressViewAcceptedWidth()     // Catch:{ Exception -> 0x01c0 }
            float r5 = r9.getExpressViewAcceptedHeight()     // Catch:{ Exception -> 0x01c0 }
            r8.a((org.json.JSONObject) r0, (java.lang.String) r1, (float) r4, (float) r5)     // Catch:{ Exception -> 0x01c0 }
            goto L_0x0123
        L_0x0113:
            java.lang.String r1 = com.bytedance.sdk.component.d.c.c.b.c$b1667305730972dc(r4)     // Catch:{ Exception -> 0x01c0 }
            r0.put(r1, r3)     // Catch:{ Exception -> 0x01c0 }
            java.lang.String r1 = com.bytedance.sdk.component.d.c.c.b.c$b1667305730972dc(r5)     // Catch:{ Exception -> 0x01c0 }
            int r4 = r9.getImgAcceptedWidth()     // Catch:{ Exception -> 0x01c0 }
            goto L_0x00f7
        L_0x0123:
            java.lang.String r1 = "puro[lbt"
            java.lang.String r1 = com.bytedance.sdk.component.d.c.c.b.c$b1667305730972dc(r1)     // Catch:{ Exception -> 0x01c0 }
            java.lang.String r4 = r9.getCodeId()     // Catch:{ Exception -> 0x01c0 }
            org.json.JSONArray r4 = b((java.lang.String) r4)     // Catch:{ Exception -> 0x01c0 }
            r0.put(r1, r4)     // Catch:{ Exception -> 0x01c0 }
            java.lang.String r1 = "pnq"
            java.lang.String r1 = com.bytedance.sdk.component.d.c.c.b.c$b1667305730972dc(r1)     // Catch:{ Exception -> 0x01c0 }
            int r4 = com.bytedance.sdk.openadsdk.AdSlot.getPosition(r10)     // Catch:{ Exception -> 0x01c0 }
            r0.put(r1, r4)     // Catch:{ Exception -> 0x01c0 }
            java.lang.String r1 = "ir]pquvhz}Uo|a"
            java.lang.String r1 = com.bytedance.sdk.component.d.c.c.b.c$b1667305730972dc(r1)     // Catch:{ Exception -> 0x01c0 }
            boolean r4 = r9.isSupportDeepLink()     // Catch:{ Exception -> 0x01c0 }
            r0.put(r1, r4)     // Catch:{ Exception -> 0x01c0 }
            int r1 = r9.getNativeAdType()     // Catch:{ Exception -> 0x01c0 }
            if (r1 > 0) goto L_0x015b
            r1 = 9
            if (r10 == r1) goto L_0x015b
            r1 = 5
            if (r10 != r1) goto L_0x0164
        L_0x015b:
            java.lang.String r1 = "ir]lvlanfVko"
            java.lang.String r1 = com.bytedance.sdk.component.d.c.c.b.c$b1667305730972dc(r1)     // Catch:{ Exception -> 0x01c0 }
            r0.put(r1, r3)     // Catch:{ Exception -> 0x01c0 }
        L_0x0164:
            int r1 = r9.getAdCount()     // Catch:{ Exception -> 0x01c0 }
            if (r1 >= r3) goto L_0x016b
            r1 = r3
        L_0x016b:
            if (r1 <= r2) goto L_0x016e
            r1 = r2
        L_0x016e:
            r2 = 7
            if (r10 == r2) goto L_0x0175
            r2 = 8
            if (r10 != r2) goto L_0x0176
        L_0x0175:
            r1 = r3
        L_0x0176:
            if (r11 == 0) goto L_0x0180
            org.json.JSONArray r11 = r11.e     // Catch:{ Exception -> 0x01c0 }
            if (r11 == 0) goto L_0x0180
            int r1 = r9.getAdCount()     // Catch:{ Exception -> 0x01c0 }
        L_0x0180:
            java.lang.String r11 = "ae]`kphs"
            java.lang.String r11 = com.bytedance.sdk.component.d.c.c.b.c$b1667305730972dc(r11)     // Catch:{ Exception -> 0x01c0 }
            r0.put(r11, r1)     // Catch:{ Exception -> 0x01c0 }
            if (r10 != r3) goto L_0x01c0
            org.json.JSONObject r10 = new org.json.JSONObject     // Catch:{ Exception -> 0x01c0 }
            r10.<init>()     // Catch:{ Exception -> 0x01c0 }
            java.lang.String r11 = "ir]qkqgsmVhjbck}"
            java.lang.String r11 = com.bytedance.sdk.component.d.c.c.b.c$b1667305730972dc(r11)     // Catch:{ Exception -> 0x01c0 }
            int r1 = r9.getIsRotateBanner()     // Catch:{ Exception -> 0x01c0 }
            r10.put(r11, r1)     // Catch:{ Exception -> 0x01c0 }
            java.lang.String r11 = "rnvbp`Ysado"
            java.lang.String r11 = com.bytedance.sdk.component.d.c.c.b.c$b1667305730972dc(r11)     // Catch:{ Exception -> 0x01c0 }
            int r1 = r9.getRotateTime()     // Catch:{ Exception -> 0x01c0 }
            r10.put(r11, r1)     // Catch:{ Exception -> 0x01c0 }
            java.lang.String r11 = "rnvbp`Yhzmoy"
            java.lang.String r11 = com.bytedance.sdk.component.d.c.c.b.c$b1667305730972dc(r11)     // Catch:{ Exception -> 0x01c0 }
            int r9 = r9.getRotateOrder()     // Catch:{ Exception -> 0x01c0 }
            r10.put(r11, r9)     // Catch:{ Exception -> 0x01c0 }
            java.lang.String r9 = "b`lmaw"
            java.lang.String r9 = com.bytedance.sdk.component.d.c.c.b.c$b1667305730972dc(r9)     // Catch:{ Exception -> 0x01c0 }
            r0.put(r9, r10)     // Catch:{ Exception -> 0x01c0 }
        L_0x01c0:
            return r0
        L_0x01c1:
            r0 = r2
            goto L_0x0042
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.o.a(com.bytedance.sdk.openadsdk.AdSlot, int, com.bytedance.sdk.openadsdk.core.model.o):org.json.JSONObject");
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0029  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0039 A[Catch:{ all -> 0x015a }] */
    @com.bytedance.JProtect
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private org.json.JSONObject a(com.bytedance.sdk.openadsdk.AdSlot r11, com.bytedance.sdk.openadsdk.core.model.o r12, int r13) {
        /*
            r10 = this;
            java.lang.String r0 = "aqr"
            java.lang.String r1 = "4/:-4+0"
            java.lang.String r2 = "ae]p`nYqm{ybcc"
            org.json.JSONObject r3 = new org.json.JSONObject
            r3.<init>()
            org.json.JSONObject r4 = new org.json.JSONObject     // Catch:{ all -> 0x015a }
            r4.<init>()     // Catch:{ all -> 0x015a }
            if (r12 == 0) goto L_0x0020
            java.lang.String r5 = r12.a     // Catch:{ all -> 0x015a }
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5     // Catch:{ all -> 0x015a }
            boolean r5 = android.text.TextUtils.isEmpty(r5)     // Catch:{ all -> 0x015a }
            if (r5 == 0) goto L_0x001d
            goto L_0x0020
        L_0x001d:
            java.lang.String r5 = r12.a     // Catch:{ all -> 0x015a }
            goto L_0x0024
        L_0x0020:
            java.lang.String r5 = com.bytedance.sdk.openadsdk.l.y.d()     // Catch:{ all -> 0x015a }
        L_0x0024:
            r6 = 7
            java.lang.String r7 = "rds\\p|vb"
            if (r13 != r6) goto L_0x0039
            if (r12 == 0) goto L_0x005a
            int r6 = r12.b     // Catch:{ all -> 0x015a }
            if (r6 <= 0) goto L_0x005a
            java.lang.String r6 = com.bytedance.sdk.component.f.c.e.e1667305730908dc(r7)     // Catch:{ all -> 0x015a }
            int r7 = r12.b     // Catch:{ all -> 0x015a }
        L_0x0035:
            r4.put(r6, r7)     // Catch:{ all -> 0x015a }
            goto L_0x005a
        L_0x0039:
            r6 = 8
            if (r13 != r6) goto L_0x004a
            if (r12 == 0) goto L_0x005a
            int r6 = r12.c     // Catch:{ all -> 0x015a }
            if (r6 <= 0) goto L_0x005a
            java.lang.String r6 = com.bytedance.sdk.component.f.c.e.e1667305730908dc(r7)     // Catch:{ all -> 0x015a }
            int r7 = r12.c     // Catch:{ all -> 0x015a }
            goto L_0x0035
        L_0x004a:
            r6 = 3
            if (r13 != r6) goto L_0x005a
            if (r12 == 0) goto L_0x005a
            int r6 = r12.d     // Catch:{ all -> 0x015a }
            if (r6 <= 0) goto L_0x005a
            java.lang.String r6 = com.bytedance.sdk.component.f.c.e.e1667305730908dc(r7)     // Catch:{ all -> 0x015a }
            int r7 = r12.d     // Catch:{ all -> 0x015a }
            goto L_0x0035
        L_0x005a:
            com.bytedance.sdk.openadsdk.core.settings.j r6 = com.bytedance.sdk.openadsdk.core.m.d()     // Catch:{ all -> 0x008e }
            java.lang.String r6 = r6.j()     // Catch:{ all -> 0x008e }
            com.bytedance.sdk.openadsdk.core.settings.j r7 = com.bytedance.sdk.openadsdk.core.m.d()     // Catch:{ all -> 0x008e }
            java.lang.String r7 = r7.m()     // Catch:{ all -> 0x008e }
            if (r6 == 0) goto L_0x008e
            if (r7 == 0) goto L_0x008e
            org.json.JSONObject r8 = new org.json.JSONObject     // Catch:{ all -> 0x008e }
            r8.<init>()     // Catch:{ all -> 0x008e }
            java.lang.String r9 = "vdppmjh"
            java.lang.String r9 = com.bytedance.sdk.component.f.c.e.e1667305730908dc(r9)     // Catch:{ all -> 0x008e }
            r8.put(r9, r6)     // Catch:{ all -> 0x008e }
            java.lang.String r6 = "p`pbi"
            java.lang.String r6 = com.bytedance.sdk.component.f.c.e.e1667305730908dc(r6)     // Catch:{ all -> 0x008e }
            r8.put(r6, r7)     // Catch:{ all -> 0x008e }
            java.lang.String r6 = "acvfwq"
            java.lang.String r6 = com.bytedance.sdk.component.f.c.e.e1667305730908dc(r6)     // Catch:{ all -> 0x008e }
            r4.put(r6, r8)     // Catch:{ all -> 0x008e }
        L_0x008e:
            java.lang.String r6 = "rdsvavrXam"
            java.lang.String r6 = com.bytedance.sdk.component.f.c.e.e1667305730908dc(r6)     // Catch:{ all -> 0x015a }
            r4.put(r6, r5)     // Catch:{ all -> 0x015a }
            java.lang.String r6 = com.bytedance.sdk.component.f.c.e.e1667305730908dc(r2)     // Catch:{ all -> 0x015a }
            java.lang.String r7 = com.bytedance.sdk.component.f.c.e.e1667305730908dc(r1)     // Catch:{ all -> 0x015a }
            r4.put(r6, r7)     // Catch:{ all -> 0x015a }
            java.lang.String r6 = "snwqg`Ysqyo"
            java.lang.String r6 = com.bytedance.sdk.component.f.c.e.e1667305730908dc(r6)     // Catch:{ all -> 0x015a }
            java.lang.String r7 = com.bytedance.sdk.component.f.c.e.e1667305730908dc(r0)     // Catch:{ all -> 0x015a }
            r4.put(r6, r7)     // Catch:{ all -> 0x015a }
            java.lang.String r0 = com.bytedance.sdk.component.f.c.e.e1667305730908dc(r0)     // Catch:{ all -> 0x015a }
            org.json.JSONObject r6 = r10.c()     // Catch:{ all -> 0x015a }
            r4.put(r0, r6)     // Catch:{ all -> 0x015a }
            android.content.Context r0 = r10.a     // Catch:{ all -> 0x015a }
            r6 = 1
            org.json.JSONObject r0 = com.bytedance.sdk.openadsdk.l.e.a(r0, r6)     // Catch:{ all -> 0x015a }
            java.lang.String r7 = "ddtjg`"
            java.lang.String r7 = com.bytedance.sdk.component.f.c.e.e1667305730908dc(r7)     // Catch:{ all -> 0x015a }
            r4.put(r7, r0)     // Catch:{ all -> 0x015a }
            java.lang.String r0 = "urgq"
            java.lang.String r0 = com.bytedance.sdk.component.f.c.e.e1667305730908dc(r0)     // Catch:{ all -> 0x015a }
            org.json.JSONObject r7 = a((com.bytedance.sdk.openadsdk.AdSlot) r11)     // Catch:{ all -> 0x015a }
            r4.put(r0, r7)     // Catch:{ all -> 0x015a }
            java.lang.String r0 = "u`"
            java.lang.String r0 = com.bytedance.sdk.component.f.c.e.e1667305730908dc(r0)     // Catch:{ all -> 0x015a }
            java.lang.String r7 = com.bytedance.sdk.openadsdk.l.y.c()     // Catch:{ all -> 0x015a }
            r4.put(r0, r7)     // Catch:{ all -> 0x015a }
            java.lang.String r0 = "cicmj`j"
            java.lang.String r0 = com.bytedance.sdk.component.f.c.e.e1667305730908dc(r0)     // Catch:{ all -> 0x015a }
            java.lang.String r7 = "m`km"
            java.lang.String r7 = com.bytedance.sdk.component.f.c.e.e1667305730908dc(r7)     // Catch:{ all -> 0x015a }
            r4.put(r0, r7)     // Catch:{ all -> 0x015a }
            org.json.JSONArray r0 = new org.json.JSONArray     // Catch:{ all -> 0x015a }
            r0.<init>()     // Catch:{ all -> 0x015a }
            org.json.JSONObject r13 = r10.a((com.bytedance.sdk.openadsdk.AdSlot) r11, (int) r13, (com.bytedance.sdk.openadsdk.core.model.o) r12)     // Catch:{ all -> 0x015a }
            r0.put(r13)     // Catch:{ all -> 0x015a }
            java.lang.String r13 = "aeqokqu"
            java.lang.String r13 = com.bytedance.sdk.component.f.c.e.e1667305730908dc(r13)     // Catch:{ all -> 0x015a }
            r4.put(r13, r0)     // Catch:{ all -> 0x015a }
            r10.a((org.json.JSONObject) r4, (com.bytedance.sdk.openadsdk.core.model.o) r12)     // Catch:{ all -> 0x015a }
            long r12 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x015a }
            r7 = 1000(0x3e8, double:4.94E-321)
            long r12 = r12 / r7
            java.lang.String r0 = "tr"
            java.lang.String r0 = com.bytedance.sdk.component.f.c.e.e1667305730908dc(r0)     // Catch:{ all -> 0x015a }
            r4.put(r0, r12)     // Catch:{ all -> 0x015a }
            java.lang.String r0 = ""
            java.lang.String r7 = r11.getCodeId()     // Catch:{ all -> 0x015a }
            if (r7 == 0) goto L_0x0135
            if (r5 == 0) goto L_0x0135
            java.lang.String r12 = java.lang.String.valueOf(r12)     // Catch:{ all -> 0x015a }
            java.lang.String r11 = r11.getCodeId()     // Catch:{ all -> 0x015a }
            java.lang.String r11 = r12.concat(r11)     // Catch:{ all -> 0x015a }
            java.lang.String r0 = r11.concat(r5)     // Catch:{ all -> 0x015a }
        L_0x0135:
            java.lang.String r11 = "rds\\wlai"
            java.lang.String r11 = com.bytedance.sdk.component.f.c.e.e1667305730908dc(r11)     // Catch:{ all -> 0x015a }
            java.lang.String r12 = com.bytedance.sdk.component.utils.e.a((java.lang.String) r0)     // Catch:{ all -> 0x015a }
            r4.put(r11, r12)     // Catch:{ all -> 0x015a }
            org.json.JSONObject r3 = com.bytedance.sdk.component.utils.a.a((org.json.JSONObject) r4)     // Catch:{ all -> 0x015a }
            java.lang.String r11 = com.bytedance.sdk.component.f.c.e.e1667305730908dc(r2)     // Catch:{ all -> 0x015a }
            java.lang.String r12 = com.bytedance.sdk.component.f.c.e.e1667305730908dc(r1)     // Catch:{ all -> 0x015a }
            r3.put(r11, r12)     // Catch:{ all -> 0x015a }
            java.lang.String r11 = "owgqw`gX~lxxeb`Pdhbv"
            java.lang.String r11 = com.bytedance.sdk.component.f.c.e.e1667305730908dc(r11)     // Catch:{ all -> 0x015a }
            r3.put(r11, r6)     // Catch:{ all -> 0x015a }
        L_0x015a:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.o.a(com.bytedance.sdk.openadsdk.AdSlot, com.bytedance.sdk.openadsdk.core.model.o, int):org.json.JSONObject");
    }

    /* access modifiers changed from: private */
    public void a(long j, String str, int i, a aVar, int i2, String str2) {
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0063, code lost:
        if ((((27 * 27) + (34 * 34)) + (17 * 17)) >= (((27 * 34) + (34 * 17)) + (27 * 17))) goto L_0x0066;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x006d, code lost:
        if ((((10 + 1) * 10) % 2) == 0) goto L_0x0070;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0077, code lost:
        if (((5 * 5) - ((28 * 28) * 34)) != -1) goto L_0x008a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x007b, code lost:
        switch(70) {
            case 70: goto L_0x007f;
            case 71: goto L_0x002c;
            case 72: goto L_0x0066;
            default: goto L_0x007e;
        };
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0087, code lost:
        if (((13 * 13) - ((19 * 19) * 34)) != -1) goto L_0x008a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x002c, code lost:
        continue;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x002c, code lost:
        continue;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(com.bytedance.sdk.openadsdk.c.a r8) {
        /*
            r7 = this;
            if (r8 != 0) goto L_0x0004
            goto L_0x008a
        L_0x0004:
            org.json.JSONObject r8 = r8.c()
            java.lang.String r0 = "lne\\a}rui"
            java.lang.String r0 = com.bytedance.sdk.component.adexpress.widget.DynamicUnlockView.DynamicUnlockView1667305730929dc(r0)
            java.lang.String r1 = ""
            java.lang.String r8 = r8.optString(r0, r1)
            long r0 = com.bytedance.sdk.openadsdk.core.model.n.r((java.lang.String) r8)
            int r8 = com.bytedance.sdk.openadsdk.core.model.n.u((java.lang.String) r8)
            r2 = 0
            int r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r2 != 0) goto L_0x0024
            long r0 = r7.d
        L_0x0024:
            r7.d = r0
            if (r8 != 0) goto L_0x002a
            int r8 = r7.e
        L_0x002a:
            r7.e = r8
        L_0x002c:
            r8 = 95
            r0 = 1
            r1 = -1
            r2 = 34
            switch(r8) {
                case 94: goto L_0x004e;
                case 95: goto L_0x008a;
                case 96: goto L_0x0036;
                default: goto L_0x0035;
            }
        L_0x0035:
            goto L_0x0041
        L_0x0036:
            r8 = 61
            int r8 = r8 * r8
            r3 = 21
            int r3 = r3 * r3
            int r3 = r3 * r2
            int r8 = r8 - r3
            if (r8 != r1) goto L_0x0079
            goto L_0x008a
        L_0x0041:
            r8 = 38
            int r3 = 38 - r0
            int r3 = r3 * r8
            int r8 = r8 * 2
            int r8 = r8 - r0
            int r3 = r3 * r8
            int r3 = r3 % 6
            if (r3 == 0) goto L_0x002c
        L_0x004e:
            r8 = 27
            r3 = 17
            int r4 = r8 * r8
            int r5 = r2 * r2
            int r4 = r4 + r5
            int r5 = r3 * r3
            int r4 = r4 + r5
            r5 = 27
            int r5 = r5 * r2
            r6 = 34
            int r6 = r6 * r3
            int r5 = r5 + r6
            int r8 = r8 * r3
            int r5 = r5 + r8
            if (r4 >= r5) goto L_0x0066
            goto L_0x008a
        L_0x0066:
            r8 = 10
            int r8 = r8 + r0
            int r8 = r8 * 10
            int r8 = r8 % 2
            if (r8 == 0) goto L_0x0070
            goto L_0x002c
        L_0x0070:
            r8 = 5
            int r8 = r8 * r8
            r3 = 28
            int r3 = r3 * r3
            int r3 = r3 * r2
            int r8 = r8 - r3
            if (r8 != r1) goto L_0x008a
        L_0x0079:
            r8 = 70
            switch(r8) {
                case 70: goto L_0x007f;
                case 71: goto L_0x002c;
                case 72: goto L_0x0066;
                default: goto L_0x007e;
            }
        L_0x007e:
            goto L_0x0079
        L_0x007f:
            r8 = 13
            int r8 = r8 * r8
            r0 = 19
            int r0 = r0 * r0
            int r0 = r0 * r2
            int r8 = r8 - r0
            if (r8 != r1) goto L_0x008a
            goto L_0x002c
        L_0x008a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.o.a(com.bytedance.sdk.openadsdk.c.a):void");
    }

    /* access modifiers changed from: private */
    public void a(com.bytedance.sdk.openadsdk.core.model.a aVar) {
        List<n> b2 = aVar.b();
        if (b2 != null && b2.size() != 0) {
            for (int i = 0; i < b2.size(); i++) {
                n nVar = b2.get(i);
                if (nVar != null && nVar.b() == null) {
                    a("", nVar.M());
                    a("", nVar.N());
                    List<com.bytedance.sdk.openadsdk.core.model.k> P = nVar.P();
                    if (P != null && P.size() > 0) {
                        for (int i2 = 0; i2 < P.size(); i2++) {
                            a(nVar, P.get(i2));
                        }
                    }
                    if (nVar.J() != null) {
                        a(nVar.J().h(), (com.bytedance.sdk.openadsdk.core.model.k) null);
                    }
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0047, code lost:
        if ((((69 * 69) + (22 * 22)) - ((69 * 22) * 2)) >= 0) goto L_0x0069;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x004f, code lost:
        if (((61 * 61) - ((12 * 12) * 34)) != -1) goto L_0x0011;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0066, code lost:
        if ((((27 * 27) + (34 * 34)) + (17 * 17)) >= (((27 * 34) + (34 * 17)) + (27 * 17))) goto L_0x0011;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x007c, code lost:
        if (((((26 * 26) * 26) + ((9 * 9) * 9)) + ((15 * 15) * 15)) >= (((26 * 9) * 15) * 3)) goto L_0x0011;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x007e, code lost:
        r5 = 0 * 0;
        r8 = 80 * 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x008a, code lost:
        if ((((80 * 80) + r5) + r5) >= ((r5 + r8) + r8)) goto L_0x00a9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0093, code lost:
        if ((((15 + 1) * 15) % 2) == 0) goto L_0x0011;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0096, code lost:
        r0 = '5';
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x00a6, code lost:
        if ((((70 * 70) + (44 * 44)) - ((70 * 44) * 2)) >= 0) goto L_0x0011;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x00a9, code lost:
        r0 = '6';
        r8 = '=';
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0011, code lost:
        continue;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0011, code lost:
        continue;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0011, code lost:
        continue;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0034, code lost:
        if (((18 * 18) - ((35 * 35) * 34)) != -1) goto L_0x0099;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0036, code lost:
        switch(r0) {
            case 52: goto L_0x003a;
            case 53: goto L_0x0049;
            case 54: goto L_0x0051;
            default: goto L_0x0039;
        };
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(final com.bytedance.sdk.openadsdk.core.model.n r8, com.bytedance.sdk.openadsdk.core.model.k r9) {
        /*
            r7 = this;
            java.lang.String r0 = "ile@efnb"
            java.lang.String r0 = com.bytedance.sdk.component.adexpress.widget.FlowLightView.FlowLightView1667305730929dc(r0)
            java.lang.String r1 = "lncgMhaFfmXn|b|{*1"
            java.lang.String r1 = com.bytedance.sdk.component.adexpress.widget.FlowLightView.FlowLightView1667305730929dc(r1)
            com.bytedance.sdk.component.utils.l.c((java.lang.String) r0, (java.lang.String) r1)
            if (r9 != 0) goto L_0x00ae
        L_0x0011:
            r8 = 51
            r9 = 96
            r0 = 31
            r1 = 15
            r2 = -1
            r3 = 61
            r4 = 34
            switch(r9) {
                case 95: goto L_0x0027;
                case 96: goto L_0x0022;
                case 97: goto L_0x0099;
                default: goto L_0x0021;
            }
        L_0x0021:
            goto L_0x0011
        L_0x0022:
            switch(r8) {
                case 49: goto L_0x007e;
                case 50: goto L_0x008c;
                case 51: goto L_0x0095;
                default: goto L_0x0025;
            }
        L_0x0025:
            goto L_0x0099
        L_0x0027:
            switch(r8) {
                case 60: goto L_0x002c;
                case 61: goto L_0x0036;
                case 62: goto L_0x0069;
                default: goto L_0x002a;
            }
        L_0x002a:
            goto L_0x00a9
        L_0x002c:
            r8 = 18
            int r8 = r8 * r8
            r9 = 35
            int r9 = r9 * r9
            int r9 = r9 * r4
            int r8 = r8 - r9
            if (r8 != r2) goto L_0x0099
        L_0x0036:
            switch(r0) {
                case 52: goto L_0x003a;
                case 53: goto L_0x0049;
                case 54: goto L_0x0051;
                default: goto L_0x0039;
            }
        L_0x0039:
            goto L_0x0096
        L_0x003a:
            r8 = 69
            r9 = 22
            int r0 = r8 * r8
            int r5 = r9 * r9
            int r0 = r0 + r5
            int r8 = r8 * r9
            int r8 = r8 * 2
            int r0 = r0 - r8
            if (r0 >= 0) goto L_0x0069
        L_0x0049:
            int r3 = r3 * r3
            r8 = 12
            int r8 = r8 * r8
            int r8 = r8 * r4
            int r3 = r3 - r8
            if (r3 != r2) goto L_0x0011
        L_0x0051:
            r8 = 27
            r9 = 17
            int r0 = r8 * r8
            int r1 = r4 * r4
            int r0 = r0 + r1
            int r1 = r9 * r9
            int r0 = r0 + r1
            r1 = 27
            int r1 = r1 * r4
            r2 = 34
            int r2 = r2 * r9
            int r1 = r1 + r2
            int r8 = r8 * r9
            int r1 = r1 + r8
            if (r0 >= r1) goto L_0x0011
            goto L_0x00be
        L_0x0069:
            r8 = 26
            r9 = 9
            int r0 = r8 * r8
            int r0 = r0 * r8
            int r5 = r9 * r9
            int r5 = r5 * r9
            int r0 = r0 + r5
            int r5 = r1 * r1
            int r5 = r5 * r1
            int r0 = r0 + r5
            int r8 = r8 * r9
            int r8 = r8 * r1
            int r8 = r8 * 3
            if (r0 >= r8) goto L_0x0011
        L_0x007e:
            r8 = 80
            r9 = 0
            int r0 = r8 * r8
            int r5 = r9 * r9
            int r0 = r0 + r5
            int r0 = r0 + r5
            int r8 = r8 * r9
            int r5 = r5 + r8
            int r5 = r5 + r8
            if (r0 >= r5) goto L_0x00a9
        L_0x008c:
            r8 = 15
            int r8 = r8 + 1
            int r8 = r8 * r1
            int r8 = r8 % 2
            if (r8 == 0) goto L_0x0011
        L_0x0095:
            return
        L_0x0096:
            r0 = 53
            goto L_0x0036
        L_0x0099:
            r8 = 70
            r9 = 44
            int r5 = r8 * r8
            int r6 = r9 * r9
            int r5 = r5 + r6
            int r8 = r8 * r9
            int r8 = r8 * 2
            int r5 = r5 - r8
            if (r5 >= 0) goto L_0x0011
            goto L_0x002c
        L_0x00a9:
            r0 = 54
            r8 = r3
            goto L_0x0027
        L_0x00ae:
            long r0 = java.lang.System.currentTimeMillis()
            com.bytedance.sdk.component.d.j r9 = com.bytedance.sdk.openadsdk.e.a.a((com.bytedance.sdk.openadsdk.core.model.k) r9)
            com.bytedance.sdk.openadsdk.core.o$4 r2 = new com.bytedance.sdk.openadsdk.core.o$4
            r2.<init>(r0, r8)
            r9.a((com.bytedance.sdk.component.d.o) r2)
        L_0x00be:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.o.a(com.bytedance.sdk.openadsdk.core.model.n, com.bytedance.sdk.openadsdk.core.model.k):void");
    }

    /* access modifiers changed from: private */
    public void a(com.bytedance.sdk.openadsdk.core.model.o oVar, x xVar, x xVar2, int i, x xVar3, n nVar, String str) {
        if (m.d().O()) {
            JSONObject jSONObject = new JSONObject();
            long j = 0;
            if (oVar != null) {
                try {
                    if (oVar.g.a > 0) {
                        jSONObject.put(c.b.c$b1667305730972dc("cmkfjqYt|hxSygbu"), xVar.a(oVar.g));
                        j = xVar3.a(oVar.g);
                    }
                } catch (Exception unused) {
                    return;
                }
            }
            jSONObject.put(FlowLightView.FlowLightView1667305730929dc("ndvtkwmX|`gn"), xVar2.a(xVar));
            jSONObject.put(FlowLightView.FlowLightView1667305730929dc("sdtfvZrnel"), i);
            jSONObject.put(FlowLightView.FlowLightView1667305730929dc("cmkfjqYbfmUe`k"), xVar3.a(xVar2));
            n nVar2 = nVar;
            String str2 = str;
            com.bytedance.sdk.openadsdk.c.c.a(this.a, nVar2, str2, c.b.c$b1667305730972dc("lncg[dbX|`gn"), j, jSONObject);
            while (true) {
                switch (8) {
                    case 8:
                    case 9:
                        return;
                    case 10:
                        if ((0 * 0) + (40 * 40) + (26 * 26) < (0 * 40) + (40 * 26) + (0 * 26) && (71 * 71) + (37 * 37) + (27 * 27) < (71 * 37) + (37 * 27) + (71 * 27)) {
                            if (((51 * 51) + (29 * 29)) - ((51 * 29) * 2) < 0 && (75 * 75) - ((33 * 33) * 34) == -1) {
                                int i2 = ((68 + 1) * 68) % 2;
                                return;
                            }
                        } else {
                            return;
                        }
                        break;
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public void a(n.a aVar, com.bytedance.sdk.openadsdk.core.model.b bVar) {
        aVar.a(-1, g.a(-1));
        bVar.a(-1);
        com.bytedance.sdk.openadsdk.core.model.b.a(bVar);
    }

    /* access modifiers changed from: private */
    public void a(n.b bVar) {
        bVar.a(-1, g.a(-1));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x003c, code lost:
        switch(61) {
            case 60: goto L_0x004d;
            case 61: goto L_0x0057;
            case 62: goto L_0x0040;
            default: goto L_0x003f;
        };
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x004a, code lost:
        if (((((0 - 1) * 0) * ((0 * 2) - 1)) % 6) == 0) goto L_0x0012;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0012, code lost:
        continue;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x002e, code lost:
        if ((((92 * 92) + (32 * 32)) + (19 * 19)) >= (((92 * 32) + (32 * 19)) + (92 * 19))) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0037, code lost:
        if ((((94 + 1) * 94) % 2) == 0) goto L_0x0019;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(java.lang.String r5, com.bytedance.sdk.openadsdk.core.model.k r6) {
        /*
            r4 = this;
            r0 = r5
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x0058
            com.bytedance.sdk.component.d.j r5 = com.bytedance.sdk.openadsdk.e.a.a((java.lang.String) r5)
            com.bytedance.sdk.component.d.o r6 = r4.g
            r5.a((com.bytedance.sdk.component.d.o) r6)
        L_0x0012:
            r5 = 55
            r6 = 1
            switch(r5) {
                case 55: goto L_0x003a;
                case 56: goto L_0x0019;
                case 57: goto L_0x0030;
                default: goto L_0x0018;
            }
        L_0x0018:
            goto L_0x0012
        L_0x0019:
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
            if (r2 >= r3) goto L_0x005a
        L_0x0030:
            r5 = 94
            int r5 = r5 + r6
            int r5 = r5 * 94
            int r5 = r5 % 2
            if (r5 == 0) goto L_0x0019
            goto L_0x004d
        L_0x003a:
            r5 = 61
            switch(r5) {
                case 60: goto L_0x004d;
                case 61: goto L_0x0057;
                case 62: goto L_0x0040;
                default: goto L_0x003f;
            }
        L_0x003f:
            goto L_0x003a
        L_0x0040:
            r5 = 0
            int r0 = 0 - r6
            int r0 = r0 * r5
            int r5 = r5 * 2
            int r5 = r5 - r6
            int r0 = r0 * r5
            int r0 = r0 % 6
            if (r0 == 0) goto L_0x0012
            goto L_0x0057
        L_0x004d:
            r5 = 18
            int r5 = r5 * r5
            r6 = 35
            int r6 = r6 * r6
            int r6 = r6 * 34
            int r5 = r5 - r6
            r6 = -1
        L_0x0057:
            return
        L_0x0058:
            if (r6 != 0) goto L_0x005b
        L_0x005a:
            return
        L_0x005b:
            com.bytedance.sdk.component.d.j r5 = com.bytedance.sdk.openadsdk.e.a.a((com.bytedance.sdk.openadsdk.core.model.k) r6)
            com.bytedance.sdk.component.d.o r6 = r4.g
            r5.a((com.bytedance.sdk.component.d.o) r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.o.a(java.lang.String, com.bytedance.sdk.openadsdk.core.model.k):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x001d, code lost:
        switch(r4) {
            case 55: goto L_0x004c;
            case 56: goto L_0x0054;
            case 57: goto L_0x0021;
            default: goto L_0x0020;
        };
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x004c, code lost:
        r3 = 'I';
        r4 = '`';
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(org.json.JSONObject r3, com.bytedance.sdk.openadsdk.core.model.o r4) {
        /*
            r2 = this;
            if (r4 == 0) goto L_0x0054
            org.json.JSONArray r0 = r4.e
            if (r0 != 0) goto L_0x0007
            goto L_0x0054
        L_0x0007:
            java.lang.String r0 = "snwqg`YsmdkbS}|`tdqgK|rd"
            java.lang.String r0 = com.bytedance.sdk.component.f.c.d.d1667305730926dc(r0)     // Catch:{ Exception -> 0x0054 }
            org.json.JSONArray r4 = r4.e     // Catch:{ Exception -> 0x0054 }
            r3.put(r0, r4)     // Catch:{ Exception -> 0x0054 }
        L_0x0012:
            r3 = 74
            r4 = 55
        L_0x0016:
            switch(r3) {
                case 72: goto L_0x0012;
                case 73: goto L_0x001a;
                case 74: goto L_0x001d;
                default: goto L_0x0019;
            }     // Catch:{ Exception -> 0x0054 }
        L_0x0019:
            goto L_0x0051
        L_0x001a:
            switch(r4) {
                case 94: goto L_0x004c;
                case 95: goto L_0x0021;
                case 96: goto L_0x0054;
                default: goto L_0x001d;
            }     // Catch:{ Exception -> 0x0054 }
        L_0x001d:
            switch(r4) {
                case 55: goto L_0x004c;
                case 56: goto L_0x0054;
                case 57: goto L_0x0021;
                default: goto L_0x0020;
            }     // Catch:{ Exception -> 0x0054 }
        L_0x0020:
            goto L_0x004c
        L_0x0021:
            r3 = 18
            r4 = 1
            switch(r4) {
                case 60: goto L_0x0028;
                case 61: goto L_0x0034;
                case 62: goto L_0x0041;
                default: goto L_0x0027;
            }     // Catch:{ Exception -> 0x0054 }
        L_0x0027:
            goto L_0x0054
        L_0x0028:
            r0 = 0
            int r1 = 0 - r4
            int r1 = r1 * r0
            int r0 = r0 * 2
            int r0 = r0 - r4
            int r1 = r1 * r0
            int r1 = r1 % 6
            if (r1 == 0) goto L_0x0054
        L_0x0034:
            int r0 = 18 - r4
            int r0 = r0 * r3
            r1 = 18
            int r1 = r1 * 2
            int r1 = r1 - r4
            int r0 = r0 * r1
            int r0 = r0 % 6
            if (r0 == 0) goto L_0x0054
        L_0x0041:
            r4 = 99
            int r4 = r4 * r4
            int r3 = r3 * r3
            int r3 = r3 * 34
            int r4 = r4 - r3
            r3 = -1
            if (r4 != r3) goto L_0x0054
            goto L_0x0012
        L_0x004c:
            r3 = 73
            r4 = 96
            goto L_0x0016
        L_0x0051:
            r3 = 72
            goto L_0x0016
        L_0x0054:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.o.a(org.json.JSONObject, com.bytedance.sdk.openadsdk.core.model.o):void");
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0042, code lost:
        if (((((87 - 1) * 87) * ((87 * 2) - 1)) % 6) != 0) goto L_0x0044;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0044, code lost:
        r5 = (13 * 13) - ((19 * 19) * 34);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0056, code lost:
        if (((99 * 99) - ((18 * 18) * 34)) != -1) goto L_0x0059;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x005d, code lost:
        switch(40) {
            case 38: goto L_0x0061;
            case 39: goto L_0x006e;
            case 40: goto L_0x00ae;
            default: goto L_0x0060;
        };
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x006c, code lost:
        if (((((40 - 1) * 40) * ((40 * 2) - 1)) % 6) == 0) goto L_0x002d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x006e, code lost:
        switch(95) {
            case 52: goto L_0x0072;
            case 53: goto L_0x004e;
            case 54: goto L_0x002d;
            default: goto L_0x0071;
        };
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x007d, code lost:
        if (((((18 - 1) * 18) * ((18 * 2) - 1)) % 6) == 0) goto L_0x0080;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0095, code lost:
        if ((((54 * 54) + (27 * 27)) + (24 * 24)) >= (((54 * 27) + (27 * 24)) + (54 * 24))) goto L_0x0059;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x00ab, code lost:
        if (((((94 * 94) * 94) + ((17 * 17) * 17)) + ((7 * 7) * 7)) >= (((94 * 17) * 7) * 3)) goto L_0x002d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x002d, code lost:
        continue;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(org.json.JSONObject r5, java.lang.String r6, float r7, float r8) {
        /*
            r4 = this;
            r0 = 0
            int r1 = (r7 > r0 ? 1 : (r7 == r0 ? 0 : -1))
            if (r1 < 0) goto L_0x00ae
            int r0 = (r8 > r0 ? 1 : (r8 == r0 ? 0 : -1))
            if (r0 < 0) goto L_0x00ae
            org.json.JSONObject r0 = new org.json.JSONObject
            r0.<init>()
            org.json.JSONArray r1 = new org.json.JSONArray
            r1.<init>()
            java.lang.String r2 = "whfwl"
            java.lang.String r2 = com.bytedance.sdk.component.d.c.f.f1667305730962dc(r2)     // Catch:{ Exception -> 0x00ae }
            int r7 = (int) r7     // Catch:{ Exception -> 0x00ae }
            r0.put(r2, r7)     // Catch:{ Exception -> 0x00ae }
            java.lang.String r7 = "hdkdlq"
            java.lang.String r7 = com.bytedance.sdk.component.d.c.f.f1667305730962dc(r7)     // Catch:{ Exception -> 0x00ae }
            int r8 = (int) r8     // Catch:{ Exception -> 0x00ae }
            r0.put(r7, r8)     // Catch:{ Exception -> 0x00ae }
            r1.put(r0)     // Catch:{ Exception -> 0x00ae }
            r5.put(r6, r1)     // Catch:{ Exception -> 0x00ae }
        L_0x002d:
            r5 = 31
            r6 = -1
            r7 = 18
            r8 = 1
            switch(r5) {
                case 29: goto L_0x0037;
                case 30: goto L_0x0044;
                case 31: goto L_0x0059;
                default: goto L_0x0036;
            }     // Catch:{ Exception -> 0x00ae }
        L_0x0036:
            goto L_0x002d
        L_0x0037:
            r5 = 87
            int r0 = 87 - r8
            int r0 = r0 * r5
            int r5 = r5 * 2
            int r5 = r5 - r8
            int r0 = r0 * r5
            int r0 = r0 % 6
            if (r0 == 0) goto L_0x004e
        L_0x0044:
            r5 = 13
            int r5 = r5 * r5
            r0 = 19
            int r0 = r0 * r0
            int r0 = r0 * 34
            int r5 = r5 - r0
            goto L_0x0059
        L_0x004e:
            r5 = 99
            int r5 = r5 * r5
            int r0 = r7 * r7
            int r0 = r0 * 34
            int r5 = r5 - r0
            if (r5 != r6) goto L_0x0059
            goto L_0x002d
        L_0x0059:
            r5 = 95
            r0 = 40
            switch(r0) {
                case 38: goto L_0x0061;
                case 39: goto L_0x006e;
                case 40: goto L_0x00ae;
                default: goto L_0x0060;
            }     // Catch:{ Exception -> 0x00ae }
        L_0x0060:
            goto L_0x0059
        L_0x0061:
            int r1 = 40 - r8
            int r1 = r1 * r0
            r0 = 40
            int r0 = r0 * 2
            int r0 = r0 - r8
            int r1 = r1 * r0
            int r1 = r1 % 6
            if (r1 == 0) goto L_0x002d
        L_0x006e:
            switch(r5) {
                case 52: goto L_0x0072;
                case 53: goto L_0x004e;
                case 54: goto L_0x002d;
                default: goto L_0x0071;
            }     // Catch:{ Exception -> 0x00ae }
        L_0x0071:
            goto L_0x00ae
        L_0x0072:
            int r5 = 18 - r8
            int r5 = r5 * r7
            r0 = 18
            int r0 = r0 * 2
            int r0 = r0 - r8
            int r5 = r5 * r0
            int r5 = r5 % 6
            if (r5 == 0) goto L_0x0080
            goto L_0x004e
        L_0x0080:
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
            if (r2 >= r3) goto L_0x0059
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
            if (r2 >= r5) goto L_0x002d
            goto L_0x0059
        L_0x00ae:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.o.a(org.json.JSONObject, java.lang.String, float, float):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x004a, code lost:
        if ((((37 * 37) + 196) + (9 * 9)) >= (((14 * 37) + (37 * 9)) + (14 * 9))) goto L_0x0028;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0054, code lost:
        if ((((15 + 1) * 15) % 2) == 0) goto L_0x006d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0056, code lost:
        switch(r5) {
            case 29: goto L_0x005a;
            case 30: goto L_0x006d;
            case 31: goto L_0x0079;
            default: goto L_0x0059;
        };
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0067, code lost:
        if ((((69 * 69) + (22 * 22)) - ((69 * 22) * 2)) >= 0) goto L_0x0028;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x006a, code lost:
        r5 = 30;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0077, code lost:
        if (((61 * 61) - ((12 * 12) * 34)) != -1) goto L_0x0086;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0084, code lost:
        if (((((38 - 1) * 38) * ((38 * 2) - 1)) % 6) == 0) goto L_0x002e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x002e, code lost:
        r5 = '7';
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0033, code lost:
        switch(16) {
            case 52: goto L_0x004d;
            case 53: goto L_0x0056;
            case 54: goto L_0x0037;
            default: goto L_0x0036;
        };
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(org.json.JSONObject r5, java.lang.String r6, int r7, int r8) {
        /*
            r4 = this;
            if (r7 <= 0) goto L_0x0089
            if (r8 <= 0) goto L_0x0089
            org.json.JSONObject r0 = new org.json.JSONObject
            r0.<init>()
            org.json.JSONArray r1 = new org.json.JSONArray
            r1.<init>()
            java.lang.String r2 = "whfwl"
            java.lang.String r2 = com.bytedance.sdk.component.d.c.f.f1667305730962dc(r2)     // Catch:{ Exception -> 0x0089 }
            r3 = 196(0xc4, float:2.75E-43)
            r0.put(r2, r7)     // Catch:{ Exception -> 0x0089 }
            java.lang.String r7 = "hdkdlq"
            java.lang.String r7 = com.bytedance.sdk.component.d.c.f.f1667305730962dc(r7)     // Catch:{ Exception -> 0x0089 }
            r0.put(r7, r8)     // Catch:{ Exception -> 0x0089 }
            r1.put(r0)     // Catch:{ Exception -> 0x0089 }
            r5.put(r6, r1)     // Catch:{ Exception -> 0x0089 }
        L_0x0028:
            r5 = 73
        L_0x002a:
            switch(r5) {
                case 72: goto L_0x0089;
                case 73: goto L_0x0086;
                case 74: goto L_0x002e;
                default: goto L_0x002d;
            }     // Catch:{ Exception -> 0x0089 }
        L_0x002d:
            goto L_0x0086
        L_0x002e:
            r5 = 55
            r6 = 16
            r7 = 1
            switch(r6) {
                case 52: goto L_0x004d;
                case 53: goto L_0x0056;
                case 54: goto L_0x0037;
                default: goto L_0x0036;
            }     // Catch:{ Exception -> 0x0089 }
        L_0x0036:
            goto L_0x0086
        L_0x0037:
            r5 = 14
            r6 = 37
            r8 = 9
            int r0 = r6 * r6
            int r0 = r0 + r3
            int r1 = r8 * r8
            int r0 = r0 + r1
            r1 = 14
            int r1 = r1 * r6
            int r6 = r6 * r8
            int r1 = r1 + r6
            int r5 = r5 * r8
            int r1 = r1 + r5
            if (r0 >= r1) goto L_0x0028
            goto L_0x005a
        L_0x004d:
            r6 = 15
            int r6 = r6 + r7
            int r6 = r6 * 15
            int r6 = r6 % 2
            if (r6 == 0) goto L_0x006d
        L_0x0056:
            switch(r5) {
                case 29: goto L_0x005a;
                case 30: goto L_0x006d;
                case 31: goto L_0x0079;
                default: goto L_0x0059;
            }     // Catch:{ Exception -> 0x0089 }
        L_0x0059:
            goto L_0x006a
        L_0x005a:
            r5 = 69
            r6 = 22
            int r8 = r5 * r5
            int r0 = r6 * r6
            int r8 = r8 + r0
            int r5 = r5 * r6
            int r5 = r5 * 2
            int r8 = r8 - r5
            if (r8 >= 0) goto L_0x0028
            goto L_0x006d
        L_0x006a:
            r5 = 30
            goto L_0x0056
        L_0x006d:
            r5 = 61
            int r5 = r5 * r5
            r6 = 12
            int r6 = r6 * r6
            int r6 = r6 * 34
            int r5 = r5 - r6
            r6 = -1
            if (r5 != r6) goto L_0x0086
        L_0x0079:
            r5 = 38
            int r6 = 38 - r7
            int r6 = r6 * r5
            int r5 = r5 * 2
            int r5 = r5 - r7
            int r6 = r6 * r5
            int r6 = r6 % 6
            if (r6 == 0) goto L_0x002e
        L_0x0086:
            r5 = 72
            goto L_0x002a
        L_0x0089:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.o.a(org.json.JSONObject, java.lang.String, int, int):void");
    }

    private static void a(JSONObject jSONObject, String str, String str2) throws JSONException {
        if (!TextUtils.isEmpty(str2)) {
            jSONObject.put(str, str2);
        }
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x0000 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x002a A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00c0 A[SYNTHETIC] */
    @com.bytedance.JProtect
    public static java.lang.String b() {
        /*
        L_0x0000:
            r0 = 40
        L_0x0002:
            r1 = 30
            r2 = 57
            r3 = 17
            switch(r1) {
                case 30: goto L_0x0024;
                case 31: goto L_0x000c;
                case 32: goto L_0x0021;
                default: goto L_0x000b;
            }
        L_0x000b:
            goto L_0x0002
        L_0x000c:
            r1 = 68
            r4 = 14
            int r5 = r1 * r1
            int r5 = r5 * r1
            int r6 = r4 * r4
            int r6 = r6 * r4
            int r5 = r5 + r6
            int r6 = r3 * r3
            int r6 = r6 * r3
            int r5 = r5 + r6
            int r1 = r1 * r4
            int r1 = r1 * r3
            int r1 = r1 * 3
            if (r5 >= r1) goto L_0x0000
        L_0x0021:
            r1 = r0
            r0 = r2
            goto L_0x007f
        L_0x0024:
            r0 = 83
            switch(r0) {
                case 82: goto L_0x002a;
                case 83: goto L_0x0035;
                case 84: goto L_0x00c0;
                default: goto L_0x0029;
            }
        L_0x0029:
            goto L_0x0024
        L_0x002a:
            r1 = r0
            r0 = r2
        L_0x002c:
            r4 = 17
            int r4 = r4 + 1
            int r4 = r4 * r3
            int r4 = r4 % 2
            if (r4 == 0) goto L_0x007f
        L_0x0035:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            boolean r1 = com.bytedance.sdk.openadsdk.l.p.e()     // Catch:{ all -> 0x007a }
            if (r1 == 0) goto L_0x004a
            java.lang.String r1 = "MHWJ)"
        L_0x0042:
            java.lang.String r1 = com.bytedance.sdk.component.d.c.c.b.c$b1667305730972dc(r1)     // Catch:{ all -> 0x007a }
            r0.append(r1)     // Catch:{ all -> 0x007a }
            goto L_0x0075
        L_0x004a:
            boolean r1 = com.bytedance.sdk.openadsdk.l.p.b()     // Catch:{ all -> 0x007a }
            if (r1 == 0) goto L_0x0053
            java.lang.String r1 = "FM[NA("
            goto L_0x0042
        L_0x0053:
            java.lang.String r1 = com.bytedance.sdk.openadsdk.l.p.n()     // Catch:{ all -> 0x007a }
            boolean r2 = com.bytedance.sdk.openadsdk.l.p.a(r1)     // Catch:{ all -> 0x007a }
            if (r2 == 0) goto L_0x0066
            java.lang.String r2 = "ELWJ)"
            java.lang.String r2 = com.bytedance.sdk.component.d.c.c.b.c$b1667305730972dc(r2)     // Catch:{ all -> 0x007a }
            r0.append(r2)     // Catch:{ all -> 0x007a }
        L_0x0066:
            r2 = r1
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2     // Catch:{ all -> 0x007a }
            boolean r2 = android.text.TextUtils.isEmpty(r2)     // Catch:{ all -> 0x007a }
            if (r2 != 0) goto L_0x0075
            r0.append(r1)     // Catch:{ all -> 0x007a }
            java.lang.String r1 = "-"
            goto L_0x0042
        L_0x0075:
            java.lang.String r1 = android.os.Build.VERSION.INCREMENTAL     // Catch:{ all -> 0x007a }
            r0.append(r1)     // Catch:{ all -> 0x007a }
        L_0x007a:
            java.lang.String r0 = r0.toString()
            return r0
        L_0x007f:
            r4 = -1
            r5 = 34
            switch(r0) {
                case 39: goto L_0x0091;
                case 40: goto L_0x0024;
                case 41: goto L_0x0086;
                default: goto L_0x0085;
            }
        L_0x0085:
            goto L_0x00d4
        L_0x0086:
            r6 = 13
            int r6 = r6 * r6
            r7 = 19
            int r7 = r7 * r7
            int r7 = r7 * r5
            int r6 = r6 - r7
            if (r6 != r4) goto L_0x0000
            goto L_0x0095
        L_0x0091:
            switch(r1) {
                case 57: goto L_0x0095;
                case 58: goto L_0x009f;
                case 59: goto L_0x00a9;
                default: goto L_0x0094;
            }
        L_0x0094:
            goto L_0x0024
        L_0x0095:
            r6 = 10
            int r6 = r6 + 1
            int r6 = r6 * 10
            int r6 = r6 % 2
            if (r6 == 0) goto L_0x0000
        L_0x009f:
            r6 = 61
            int r6 = r6 * r6
            r7 = 12
            int r7 = r7 * r7
            int r7 = r7 * r5
            int r6 = r6 - r7
            if (r6 != r4) goto L_0x00c0
        L_0x00a9:
            r4 = 27
            int r6 = r4 * r4
            int r7 = r5 * r5
            int r6 = r6 + r7
            int r7 = r3 * r3
            int r6 = r6 + r7
            r7 = 27
            int r7 = r7 * r5
            r5 = 34
            int r5 = r5 * r3
            int r7 = r7 + r5
            int r4 = r4 * r3
            int r7 = r7 + r4
            if (r6 >= r7) goto L_0x0000
            goto L_0x002c
        L_0x00c0:
            r0 = 55
            int r1 = r0 * r0
            int r1 = r1 * r0
            r4 = 11
            int r5 = r4 * r4
            int r5 = r5 * r4
            int r1 = r1 + r5
            int r1 = r1 + r5
            int r0 = r0 * r4
            int r0 = r0 * r4
            int r0 = r0 * 3
            if (r1 >= r0) goto L_0x0024
            goto L_0x0000
        L_0x00d4:
            r0 = 39
            r1 = 59
            goto L_0x007f
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.o.b():java.lang.String");
    }

    private static String b(AdSlot adSlot) {
        String n = h.d().n();
        if (adSlot == null) {
            return TextUtils.isEmpty(n) ? "" : n;
        }
        String userData = adSlot.getUserData();
        if (TextUtils.isEmpty(n)) {
            return userData;
        }
        if (TextUtils.isEmpty(userData)) {
            return n;
        }
        HashSet hashSet = new HashSet();
        try {
            JSONArray jSONArray = new JSONArray(userData);
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                if (jSONObject != null) {
                    hashSet.add(jSONObject.optString(d.d1667305730926dc("n`of"), (String) null));
                }
            }
            try {
                JSONArray jSONArray2 = new JSONArray(n);
                int length2 = jSONArray2.length();
                for (int i2 = 0; i2 < length2; i2++) {
                    JSONObject jSONObject2 = jSONArray2.getJSONObject(i2);
                    if (jSONObject2 != null && !hashSet.contains(jSONObject2.optString(d.d1667305730926dc("n`of"), (String) null))) {
                        jSONArray.put(jSONObject2);
                    }
                }
                return jSONArray.toString();
            } catch (Throwable unused) {
                return userData;
            }
        } catch (Throwable unused2) {
            return n;
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x001f, code lost:
        if ((((84 * 84) + (7 * 7)) - ((84 * 7) * 2)) < 0) goto L_0x0021;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static org.json.JSONArray b(java.lang.String r6) {
        /*
            r0 = 0
            java.util.Set r6 = com.bytedance.sdk.component.adexpress.a.b.a.b(r6)     // Catch:{ Exception -> 0x006a }
            if (r6 == 0) goto L_0x0069
            int r1 = r6.size()     // Catch:{ Exception -> 0x006a }
            if (r1 != 0) goto L_0x002a
        L_0x000d:
            r6 = 13
            switch(r6) {
                case 13: goto L_0x0069;
                case 14: goto L_0x0013;
                case 15: goto L_0x0021;
                default: goto L_0x0012;
            }     // Catch:{ Exception -> 0x006a }
        L_0x0012:
            goto L_0x000d
        L_0x0013:
            r6 = 84
            r1 = 7
            int r2 = r6 * r6
            int r3 = r1 * r1
            int r2 = r2 + r3
            int r6 = r6 * r1
            int r6 = r6 * 2
            int r2 = r2 - r6
            if (r2 >= 0) goto L_0x0069
        L_0x0021:
            r6 = 17
            int r6 = r6 + 1
            int r6 = r6 * 17
            int r6 = r6 % 2
            goto L_0x0069
        L_0x002a:
            org.json.JSONArray r1 = new org.json.JSONArray     // Catch:{ Exception -> 0x006a }
            r1.<init>()     // Catch:{ Exception -> 0x006a }
            java.util.Iterator r6 = r6.iterator()     // Catch:{ Exception -> 0x006a }
        L_0x0033:
            boolean r2 = r6.hasNext()     // Catch:{ Exception -> 0x006a }
            if (r2 == 0) goto L_0x0068
            java.lang.Object r2 = r6.next()     // Catch:{ Exception -> 0x006a }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ Exception -> 0x006a }
            com.bytedance.sdk.component.adexpress.a.c.b r2 = com.bytedance.sdk.component.adexpress.a.b.a.a((java.lang.String) r2)     // Catch:{ Exception -> 0x006a }
            if (r2 == 0) goto L_0x0033
            org.json.JSONObject r3 = new org.json.JSONObject     // Catch:{ Exception -> 0x006a }
            r3.<init>()     // Catch:{ Exception -> 0x006a }
            java.lang.String r4 = "ie"
            java.lang.String r4 = com.bytedance.sdk.component.f.c.d.d1667305730926dc(r4)     // Catch:{ Exception -> 0x006a }
            java.lang.String r5 = r2.b()     // Catch:{ Exception -> 0x006a }
            r3.put(r4, r5)     // Catch:{ Exception -> 0x006a }
            java.lang.String r4 = "me7"
            java.lang.String r4 = com.bytedance.sdk.component.f.c.d.d1667305730926dc(r4)     // Catch:{ Exception -> 0x006a }
            java.lang.String r2 = r2.c()     // Catch:{ Exception -> 0x006a }
            r3.put(r4, r2)     // Catch:{ Exception -> 0x006a }
            r1.put(r3)     // Catch:{ Exception -> 0x006a }
            goto L_0x0033
        L_0x0068:
            return r1
        L_0x0069:
            return r0
        L_0x006a:
            r6 = move-exception
            java.lang.String r1 = "NdvBtlOjxe"
            java.lang.String r1 = com.bytedance.sdk.component.f.c.d.d1667305730926dc(r1)
            java.lang.String r2 = "gdvSewci|]zgEi}50"
            java.lang.String r2 = com.bytedance.sdk.component.f.c.d.d1667305730926dc(r2)
            android.util.Log.e(r1, r2, r6)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.o.b(java.lang.String):org.json.JSONArray");
    }

    private JSONArray b(List<FilterWord> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        for (FilterWord id : list) {
            jSONArray.put(id.getId());
        }
        return jSONArray;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x007e, code lost:
        if (((99 * 99) - ((18 * 18) * 34)) != -1) goto L_0x0082;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0000, code lost:
        continue;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0015, code lost:
        if (((((87 - 1) * 87) * ((87 * 2) - 1)) % 6) != 0) goto L_0x0017;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0020, code lost:
        if (((13 * 13) - ((19 * 19) * 34)) != -1) goto L_0x0000;
     */
    @com.bytedance.JProtect
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private org.json.JSONObject b(java.lang.String r9, java.util.List<com.bytedance.sdk.openadsdk.FilterWord> r10) {
        /*
            r8 = this;
        L_0x0000:
            r0 = 31
            r1 = 18
            r2 = -1
            r3 = 1
            switch(r0) {
                case 29: goto L_0x000a;
                case 30: goto L_0x0017;
                case 31: goto L_0x0022;
                default: goto L_0x0009;
            }
        L_0x0009:
            goto L_0x0000
        L_0x000a:
            r0 = 87
            int r4 = 87 - r3
            int r4 = r4 * r0
            int r0 = r0 * 2
            int r0 = r0 - r3
            int r4 = r4 * r0
            int r4 = r4 % 6
            if (r4 == 0) goto L_0x0077
        L_0x0017:
            r0 = 13
            int r0 = r0 * r0
            r4 = 19
            int r4 = r4 * r4
            int r4 = r4 * 34
            int r0 = r0 - r4
            if (r0 != r2) goto L_0x0000
        L_0x0022:
            r0 = 95
            r4 = 40
            switch(r4) {
                case 38: goto L_0x002a;
                case 39: goto L_0x0037;
                case 40: goto L_0x0082;
                default: goto L_0x0029;
            }
        L_0x0029:
            goto L_0x0022
        L_0x002a:
            int r5 = 40 - r3
            int r5 = r5 * r4
            r4 = 40
            int r4 = r4 * 2
            int r4 = r4 - r3
            int r5 = r5 * r4
            int r5 = r5 % 6
            if (r5 == 0) goto L_0x0000
        L_0x0037:
            switch(r0) {
                case 52: goto L_0x003b;
                case 53: goto L_0x0077;
                case 54: goto L_0x0000;
                default: goto L_0x003a;
            }
        L_0x003a:
            goto L_0x0082
        L_0x003b:
            int r0 = 18 - r3
            int r0 = r0 * r1
            r4 = 18
            int r4 = r4 * 2
            int r4 = r4 - r3
            int r0 = r0 * r4
            int r0 = r0 % 6
            if (r0 == 0) goto L_0x0049
            goto L_0x0077
        L_0x0049:
            r0 = 54
            r4 = 27
            r5 = 24
            int r6 = r0 * r0
            int r7 = r4 * r4
            int r6 = r6 + r7
            int r7 = r5 * r5
            int r6 = r6 + r7
            r7 = 54
            int r7 = r7 * r4
            int r4 = r4 * r5
            int r7 = r7 + r4
            int r0 = r0 * r5
            int r7 = r7 + r0
            if (r6 >= r7) goto L_0x0022
            r0 = 94
            r4 = 17
            r5 = 7
            int r6 = r0 * r0
            int r6 = r6 * r0
            int r7 = r4 * r4
            int r7 = r7 * r4
            int r6 = r6 + r7
            int r7 = r5 * r5
            int r7 = r7 * r5
            int r6 = r6 + r7
            int r0 = r0 * r4
            int r0 = r0 * r5
            int r0 = r0 * 3
            if (r6 >= r0) goto L_0x0022
            goto L_0x0082
        L_0x0077:
            r0 = 99
            int r0 = r0 * r0
            int r1 = r1 * r1
            int r1 = r1 * 34
            int r0 = r0 - r1
            if (r0 != r2) goto L_0x0082
            goto L_0x0000
        L_0x0082:
            org.json.JSONObject r0 = new org.json.JSONObject
            r0.<init>()
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch:{ Exception -> 0x00de }
            r1.<init>()     // Catch:{ Exception -> 0x00de }
            java.lang.String r2 = "abvjkk"
            java.lang.String r2 = com.bytedance.sdk.component.f.c.e.e1667305730908dc(r2)     // Catch:{ Exception -> 0x00de }
            java.lang.String r3 = "dhqomnc"
            java.lang.String r3 = com.bytedance.sdk.component.f.c.e.e1667305730908dc(r3)     // Catch:{ Exception -> 0x00de }
            r1.put(r2, r3)     // Catch:{ Exception -> 0x00de }
            java.lang.String r2 = "thofwqgjx"
            java.lang.String r2 = com.bytedance.sdk.component.f.c.e.e1667305730908dc(r2)     // Catch:{ Exception -> 0x00de }
            long r3 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x00de }
            r1.put(r2, r3)     // Catch:{ Exception -> 0x00de }
            java.lang.String r2 = "ae]p`nYqm{ybcc"
            java.lang.String r2 = com.bytedance.sdk.component.f.c.e.e1667305730908dc(r2)     // Catch:{ Exception -> 0x00de }
            java.lang.String r3 = "4/:-4+0"
            java.lang.String r3 = com.bytedance.sdk.component.f.c.e.e1667305730908dc(r3)     // Catch:{ Exception -> 0x00de }
            r1.put(r2, r3)     // Catch:{ Exception -> 0x00de }
            java.lang.String r2 = "eyvqe"
            java.lang.String r2 = com.bytedance.sdk.component.f.c.e.e1667305730908dc(r2)     // Catch:{ Exception -> 0x00de }
            r1.put(r2, r9)     // Catch:{ Exception -> 0x00de }
            java.lang.String r9 = "fhnwawYpg{nx"
            java.lang.String r9 = com.bytedance.sdk.component.f.c.e.e1667305730908dc(r9)     // Catch:{ Exception -> 0x00de }
            org.json.JSONArray r10 = r8.b((java.util.List<com.bytedance.sdk.openadsdk.FilterWord>) r10)     // Catch:{ Exception -> 0x00de }
            r1.put(r9, r10)     // Catch:{ Exception -> 0x00de }
            org.json.JSONArray r9 = new org.json.JSONArray     // Catch:{ Exception -> 0x00de }
            r9.<init>()     // Catch:{ Exception -> 0x00de }
            r9.put(r1)     // Catch:{ Exception -> 0x00de }
            java.lang.String r10 = "abvjkku"
            java.lang.String r10 = com.bytedance.sdk.component.f.c.e.e1667305730908dc(r10)     // Catch:{ Exception -> 0x00de }
            r0.put(r10, r9)     // Catch:{ Exception -> 0x00de }
        L_0x00de:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.o.b(java.lang.String, java.util.List):org.json.JSONObject");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x014a A[LOOP_START] */
    @com.bytedance.JProtect
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void b(com.bytedance.sdk.openadsdk.AdSlot r15, com.bytedance.sdk.openadsdk.core.model.o r16, int r17, com.bytedance.sdk.openadsdk.core.n.a r18) {
        /*
            r14 = this;
            r11 = r14
            r0 = r15
            r7 = r18
            com.bytedance.sdk.openadsdk.core.k.f()
            com.bytedance.sdk.openadsdk.core.model.b r6 = new com.bytedance.sdk.openadsdk.core.model.b
            r6.<init>()
            r6.a((com.bytedance.sdk.openadsdk.AdSlot) r15)
            boolean r1 = com.bytedance.sdk.openadsdk.core.settings.f.a()
            if (r1 != 0) goto L_0x0029
            if (r7 == 0) goto L_0x0028
            java.lang.String r0 = "Ae\"qatsb{}*b-zj}a}aug{a9jzin{{\f\u0001rOADUB\bJEEXLM[\u0010H]FF\u0015fVV^V^\u001c|s"
            java.lang.String r0 = com.bytedance.sdk.component.f.b.a.a1667305730938dc(r0)
            r1 = 1000(0x3e8, float:1.401E-42)
            r7.a((int) r1, (java.lang.String) r0)
            r6.a((int) r1)
            com.bytedance.sdk.openadsdk.core.model.b.a((com.bytedance.sdk.openadsdk.core.model.b) r6)
        L_0x0028:
            return
        L_0x0029:
            com.bytedance.sdk.openadsdk.core.settings.j r1 = com.bytedance.sdk.openadsdk.core.m.d()
            boolean r1 = r1.I()
            if (r1 != 0) goto L_0x0047
            if (r7 == 0) goto L_0x0046
            r0 = -16
            java.lang.String r1 = com.bytedance.sdk.openadsdk.core.g.a(r0)
            r7.a((int) r0, (java.lang.String) r1)
            r0 = 1001(0x3e9, float:1.403E-42)
            r6.a((int) r0)
            com.bytedance.sdk.openadsdk.core.model.b.a((com.bytedance.sdk.openadsdk.core.model.b) r6)
        L_0x0046:
            return
        L_0x0047:
            if (r7 != 0) goto L_0x004a
            return
        L_0x004a:
            java.lang.String r1 = r15.getCodeId()
            boolean r1 = r14.c((java.lang.String) r1)
            if (r1 == 0) goto L_0x0063
            r0 = -8
            java.lang.String r1 = com.bytedance.sdk.openadsdk.core.g.a(r0)
            r7.a((int) r0, (java.lang.String) r1)
            r6.a((int) r0)
            com.bytedance.sdk.openadsdk.core.model.b.a((com.bytedance.sdk.openadsdk.core.model.b) r6)
            return
        L_0x0063:
            java.lang.String r1 = r15.getBidAdm()
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            r2 = 0
            java.lang.String r3 = "P`ldh`YCmklS@aku"
            r4 = 1
            if (r1 != 0) goto L_0x018b
            com.bytedance.sdk.openadsdk.h.b r1 = com.bytedance.sdk.openadsdk.h.b.a()
            r1.c()
            r1 = 2
            r6.b(r1)
            java.lang.String r5 = r15.getBidAdm()
            r6.a((java.lang.String) r5)
            java.lang.String r5 = "bhfgmka"
            java.lang.String r5 = com.bytedance.sdk.component.f.b.a.a1667305730938dc(r5)
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r9 = "gdvB`%dnlHnf,d}/fp~zp９c8nswp=zvRDAWH\\\u0006WI[YN\fYFJ\u0010CWGAGXR\\\u0019[_JXLK)2'.!+2}h\u000b#/\r)#bn\u001c\u0016fyk"
            java.lang.String r9 = com.bytedance.sdk.component.f.b.a.a1667305730938dc(r9)
            r8.append(r9)
            java.lang.String r9 = r15.getBidAdm()
            java.lang.String r9 = com.bykv.vk.openvk.component.video.api.f.b.a((java.lang.String) r9)
            r8.append(r9)
            java.lang.String r8 = r8.toString()
            com.bytedance.sdk.component.utils.l.b((java.lang.String) r5, (java.lang.String) r8)
            com.bytedance.sdk.openadsdk.core.settings.j r5 = com.bytedance.sdk.openadsdk.core.m.d()
            boolean r5 = r5.M()
            if (r5 == 0) goto L_0x00cc
            com.bytedance.sdk.openadsdk.TTAdManager r5 = com.bytedance.sdk.openadsdk.TTAdSdk.getAdManager()
            int r5 = r5.getDebugLog()
            if (r5 != r4) goto L_0x00cc
            java.lang.String r3 = com.bytedance.sdk.component.f.b.a.a1667305730938dc(r3)
            java.lang.String r4 = r15.getBidAdm()
            android.content.Context r5 = r11.a
            com.bytedance.sdk.openadsdk.l.y.a((java.lang.String) r3, (java.lang.String) r4, (android.content.Context) r5)
        L_0x00cc:
            org.json.JSONObject r3 = new org.json.JSONObject     // Catch:{ all -> 0x0177 }
            java.lang.String r4 = r15.getBidAdm()     // Catch:{ all -> 0x0177 }
            r3.<init>(r4)     // Catch:{ all -> 0x0177 }
            org.json.JSONObject r3 = r14.a((org.json.JSONObject) r3)     // Catch:{ all -> 0x0177 }
            if (r3 != 0) goto L_0x00e0
            r14.a((com.bytedance.sdk.openadsdk.core.n.a) r7, (com.bytedance.sdk.openadsdk.core.model.b) r6)     // Catch:{ all -> 0x0177 }
            goto L_0x0176
        L_0x00e0:
            r10 = r16
            com.bytedance.sdk.openadsdk.core.o$a r0 = com.bytedance.sdk.openadsdk.core.o.a.a(r3, r15, r10)     // Catch:{ all -> 0x0177 }
            java.util.ArrayList<java.lang.Integer> r4 = r0.j     // Catch:{ all -> 0x0177 }
            r6.a((java.util.ArrayList<java.lang.Integer>) r4)     // Catch:{ all -> 0x0177 }
            android.content.Context r4 = r11.a     // Catch:{ all -> 0x0177 }
            java.lang.String r5 = r0.i     // Catch:{ all -> 0x0177 }
            com.bytedance.sdk.openadsdk.core.j.a(r4, r5)     // Catch:{ all -> 0x0177 }
            int r4 = r0.d     // Catch:{ all -> 0x0177 }
            r5 = 20000(0x4e20, float:2.8026E-41)
            if (r4 == r5) goto L_0x0108
            int r1 = r0.d     // Catch:{ all -> 0x0177 }
            java.lang.String r2 = r0.e     // Catch:{ all -> 0x0177 }
            r7.a((int) r1, (java.lang.String) r2)     // Catch:{ all -> 0x0177 }
            int r0 = r0.d     // Catch:{ all -> 0x0177 }
            r6.a((int) r0)     // Catch:{ all -> 0x0177 }
            com.bytedance.sdk.openadsdk.core.model.b.a((com.bytedance.sdk.openadsdk.core.model.b) r6)     // Catch:{ all -> 0x0177 }
            return
        L_0x0108:
            com.bytedance.sdk.openadsdk.core.model.a r4 = r0.h     // Catch:{ all -> 0x0177 }
            if (r4 != 0) goto L_0x0110
            r14.a((com.bytedance.sdk.openadsdk.core.n.a) r7, (com.bytedance.sdk.openadsdk.core.model.b) r6)     // Catch:{ all -> 0x0177 }
            return
        L_0x0110:
            com.bytedance.sdk.openadsdk.core.model.a r4 = r0.h     // Catch:{ all -> 0x0177 }
            java.util.List r4 = r4.b()     // Catch:{ all -> 0x0177 }
            if (r4 == 0) goto L_0x0137
            com.bytedance.sdk.openadsdk.core.model.a r4 = r0.h     // Catch:{ all -> 0x0177 }
            java.util.List r4 = r4.b()     // Catch:{ all -> 0x0177 }
            int r4 = r4.size()     // Catch:{ all -> 0x0177 }
            if (r4 <= 0) goto L_0x0137
            com.bytedance.sdk.openadsdk.core.model.a r4 = r0.h     // Catch:{ all -> 0x0177 }
            java.util.List r4 = r4.b()     // Catch:{ all -> 0x0177 }
            java.lang.Object r2 = r4.get(r2)     // Catch:{ all -> 0x0177 }
            com.bytedance.sdk.openadsdk.core.model.n r2 = (com.bytedance.sdk.openadsdk.core.model.n) r2     // Catch:{ all -> 0x0177 }
            java.lang.String r4 = com.bytedance.sdk.openadsdk.l.y.b((int) r17)     // Catch:{ all -> 0x0177 }
            com.bytedance.sdk.openadsdk.c.c.a((com.bytedance.sdk.openadsdk.core.model.n) r2, (java.lang.String) r4)     // Catch:{ all -> 0x0177 }
        L_0x0137:
            com.bytedance.sdk.openadsdk.core.model.a r2 = r0.h     // Catch:{ all -> 0x0177 }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x0177 }
            r2.c(r3)     // Catch:{ all -> 0x0177 }
            com.bytedance.sdk.openadsdk.core.model.a r2 = r0.h     // Catch:{ all -> 0x0177 }
            r7.a((com.bytedance.sdk.openadsdk.core.model.a) r2, (com.bytedance.sdk.openadsdk.core.model.b) r6)     // Catch:{ all -> 0x0177 }
            com.bytedance.sdk.openadsdk.core.model.a r0 = r0.h     // Catch:{ all -> 0x0177 }
            r14.a((com.bytedance.sdk.openadsdk.core.model.a) r0)     // Catch:{ all -> 0x0177 }
        L_0x014a:
            r0 = 43
            switch(r0) {
                case 41: goto L_0x0150;
                case 42: goto L_0x0167;
                case 43: goto L_0x018a;
                default: goto L_0x014f;
            }
        L_0x014f:
            goto L_0x014a
        L_0x0150:
            r0 = 33
            r2 = 27
            r3 = 22
            int r4 = r0 * r0
            int r4 = r4 * r0
            int r5 = r2 * r2
            int r5 = r5 * r2
            int r4 = r4 + r5
            int r5 = r3 * r3
            int r5 = r5 * r3
            int r4 = r4 + r5
            int r0 = r0 * r2
            int r0 = r0 * r3
            int r0 = r0 * 3
            if (r4 >= r0) goto L_0x018a
        L_0x0167:
            r0 = 29
            r2 = 24
            int r3 = r0 * r0
            int r4 = r2 * r2
            int r3 = r3 + r4
            int r0 = r0 * r2
            int r0 = r0 * r1
            int r3 = r3 - r0
            if (r3 >= 0) goto L_0x0176
            goto L_0x018a
        L_0x0176:
            return
        L_0x0177:
            r0 = move-exception
            java.lang.String r1 = "NdvBtlOjxe"
            java.lang.String r1 = com.bytedance.sdk.component.f.b.a.a1667305730938dc(r1)
            java.lang.String r2 = "gdv#ea&bz{ey6-"
            java.lang.String r2 = com.bytedance.sdk.component.f.b.a.a1667305730938dc(r2)
            com.bytedance.sdk.component.utils.l.c((java.lang.String) r1, (java.lang.String) r2, (java.lang.Throwable) r0)
            r14.a((com.bytedance.sdk.openadsdk.core.n.a) r7, (com.bytedance.sdk.openadsdk.core.model.b) r6)
        L_0x018a:
            return
        L_0x018b:
            r10 = r16
            org.json.JSONObject r1 = r14.a((com.bytedance.sdk.openadsdk.AdSlot) r15, (com.bytedance.sdk.openadsdk.core.model.o) r16, (int) r17)
            if (r1 != 0) goto L_0x01a3
            r0 = -9
            java.lang.String r1 = com.bytedance.sdk.openadsdk.core.g.a(r0)
            r7.a((int) r0, (java.lang.String) r1)
            r6.a((int) r0)
            com.bytedance.sdk.openadsdk.core.model.b.a((com.bytedance.sdk.openadsdk.core.model.b) r6)
            return
        L_0x01a3:
            com.bytedance.sdk.openadsdk.core.settings.j r5 = com.bytedance.sdk.openadsdk.core.m.d()
            boolean r5 = r5.M()
            if (r5 == 0) goto L_0x01c4
            com.bytedance.sdk.openadsdk.TTAdManager r5 = com.bytedance.sdk.openadsdk.TTAdSdk.getAdManager()
            int r5 = r5.getDebugLog()
            if (r5 != r4) goto L_0x01c4
            java.lang.String r5 = r1.toString()
            java.lang.String r3 = com.bytedance.sdk.component.f.b.a.a1667305730938dc(r3)
            android.content.Context r8 = r11.a
            com.bytedance.sdk.openadsdk.l.y.a((java.lang.String) r3, (java.lang.String) r5, (android.content.Context) r8)
        L_0x01c4:
            java.lang.String r3 = "/`rj+db(}gcdb\"}k{>uv`Jwsk6"
            java.lang.String r3 = com.bytedance.sdk.component.f.b.a.a1667305730938dc(r3)
            java.lang.String r3 = com.bytedance.sdk.openadsdk.l.y.a((java.lang.String) r3, (boolean) r4)
            com.bytedance.sdk.openadsdk.i.d r5 = com.bytedance.sdk.openadsdk.i.d.a()
            com.bytedance.sdk.component.f.a r5 = r5.b()
            com.bytedance.sdk.component.f.b.d r12 = r5.b()
            java.lang.String r5 = com.bytedance.sdk.openadsdk.d.d.a(r12, r3)     // Catch:{ Exception -> 0x01e1 }
            r12.a((java.lang.String) r5)     // Catch:{ Exception -> 0x01e1 }
        L_0x01e1:
            r12.a((org.json.JSONObject) r1)
            java.lang.String r1 = r1.toString()
            java.util.Map r1 = com.bytedance.sdk.openadsdk.core.e.c.a(r3, r1)
            if (r1 == 0) goto L_0x021f
            int r3 = r1.size()
            if (r3 <= 0) goto L_0x021f
            java.lang.String r3 = "mrqgo%kt{maCiljjbb("
            java.lang.String r3 = com.bytedance.sdk.component.f.b.a.a1667305730938dc(r3)
            java.lang.String r5 = r1.toString()
            com.bytedance.sdk.component.utils.l.c((java.lang.String) r3, (java.lang.String) r5)
            java.util.Set r3 = r1.keySet()
            java.util.Iterator r3 = r3.iterator()
        L_0x0209:
            boolean r5 = r3.hasNext()
            if (r5 == 0) goto L_0x021f
            java.lang.Object r5 = r3.next()
            java.lang.String r5 = (java.lang.String) r5
            java.lang.Object r8 = r1.get(r5)     // Catch:{ Exception -> 0x0209 }
            java.lang.String r8 = (java.lang.String) r8     // Catch:{ Exception -> 0x0209 }
            r12.b(r5, r8)     // Catch:{ Exception -> 0x0209 }
            goto L_0x0209
        L_0x021f:
            java.lang.String r1 = "Urgq)Dabf}"
            java.lang.String r1 = com.bytedance.sdk.component.f.b.a.a1667305730938dc(r1)     // Catch:{ Exception -> 0x022c }
            java.lang.String r3 = com.bytedance.sdk.openadsdk.l.y.c()     // Catch:{ Exception -> 0x022c }
            r12.b(r1, r3)     // Catch:{ Exception -> 0x022c }
        L_0x022c:
            com.bytedance.sdk.openadsdk.l.x r5 = com.bytedance.sdk.openadsdk.l.x.a()
            java.util.Map r8 = r15.getRequestExtraMap()
            com.bytedance.sdk.openadsdk.core.h r1 = com.bytedance.sdk.openadsdk.core.h.d()
            boolean r1 = r1.s()
            if (r1 == 0) goto L_0x0242
            if (r8 == 0) goto L_0x0242
            r3 = r4
            goto L_0x0243
        L_0x0242:
            r3 = r2
        L_0x0243:
            if (r3 == 0) goto L_0x024e
            java.lang.String r1 = "pfcg[vrfz}"
            java.lang.String r1 = com.bytedance.sdk.component.f.b.a.a1667305730938dc(r1)
            r8.put(r1, r5)
        L_0x024e:
            com.bytedance.sdk.openadsdk.core.o$2 r13 = new com.bytedance.sdk.openadsdk.core.o$2
            r1 = r13
            r2 = r14
            r4 = r8
            r7 = r18
            r8 = r15
            r9 = r17
            r10 = r16
            r1.<init>(r3, r4, r5, r6, r7, r8, r9, r10)
            r12.a((com.bytedance.sdk.component.f.a.a) r13)
            com.bytedance.sdk.openadsdk.core.d r0 = com.bytedance.sdk.openadsdk.core.d.a()
            r0.b()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.o.b(com.bytedance.sdk.openadsdk.AdSlot, com.bytedance.sdk.openadsdk.core.model.o, int, com.bytedance.sdk.openadsdk.core.n$a):void");
    }

    private void b(JSONObject jSONObject, String str) {
        com.bytedance.sdk.component.f.b.d b2 = com.bytedance.sdk.openadsdk.i.d.a().b().b();
        b2.a(str);
        b2.a(jSONObject);
        b2.a();
    }

    @JProtect
    private JSONObject c() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(f.f1667305730962dc("aqrj`"), h.d().f());
            jSONObject.put(f.f1667305730962dc("n`of"), h.d().g());
            g(jSONObject);
            Context a2 = m.a();
            String str = "";
            if (a2 != null) {
                try {
                    str = a2.getPackageResourcePath();
                } catch (Throwable th) {
                    String f1667305730962dc = f.f1667305730962dc("NdvBtlOjxe");
                    l.e(f1667305730962dc, f.f1667305730962dc("f`koaa&sg)mnx-zgu1scdytymstr=wqSUCOHDRNGG\n[MNENWT\u0012CUA^\u0019\u0018\\HISO\u0004\u001f") + th.getMessage());
                }
            }
            jSONObject.put(f.f1667305730962dc("p`ahebcXagymabP`pf{"), str);
            jSONObject.put(f.f1667305730962dc("ir]selbXiyz"), h.d().l());
            if (com.bytedance.sdk.openadsdk.core.e.c.b() != null) {
                jSONObject.put(f.f1667305730962dc("aqi\\wlai"), com.bytedance.sdk.openadsdk.core.e.c.b());
            }
            jSONObject.put(f.f1667305730962dc("aqr\\vphiagmTxdcj"), (System.currentTimeMillis() - PAGSdk.INIT_TIME) / 1000);
            jSONObject.put(f.f1667305730962dc("flumehc"), e.g(this.a));
            jSONObject.put(f.f1667305730962dc("ir]jjlr"), TTAdSdk.isInitSuccess() ? 1 : 0);
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0037, code lost:
        switch(61) {
            case 60: goto L_0x003b;
            case 61: goto L_0x0046;
            case 62: goto L_0x0065;
            default: goto L_0x003a;
        };
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0044, code lost:
        if (((18 * 18) - ((35 * 35) * 34)) != -1) goto L_0x0090;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0048, code lost:
        switch(54) {
            case 52: goto L_0x004c;
            case 53: goto L_0x005b;
            case 54: goto L_0x0064;
            default: goto L_0x004b;
        };
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0059, code lost:
        if ((((69 * 69) + (22 * 22)) - ((69 * 22) * 2)) >= 0) goto L_0x0065;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0062, code lost:
        if (((61 * 61) - ((12 * 12) * 34)) != -1) goto L_0x0026;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0064, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0078, code lost:
        if (((((26 * 26) * 26) + ((9 * 9) * 9)) + ((15 * 15) * 15)) >= (((26 * 9) * 15) * 3)) goto L_0x00a0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x007a, code lost:
        r6 = 0 * 0;
        r9 = 80 * 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0085, code lost:
        if ((((80 * 80) + r6) + r6) >= ((r6 + r9) + r9)) goto L_0x0037;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x008d, code lost:
        if ((((15 + 1) * 15) % 2) == 0) goto L_0x0026;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x009d, code lost:
        if ((((70 * 70) + (44 * 44)) - ((70 * 44) * 2)) >= 0) goto L_0x00a0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0026, code lost:
        continue;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean c(java.lang.String r9) {
        /*
            r8 = this;
            boolean r0 = com.bytedance.sdk.openadsdk.core.d.b.a()
            r1 = 1
            if (r0 == 0) goto L_0x0009
            goto L_0x00a0
        L_0x0009:
            boolean r9 = com.bytedance.sdk.openadsdk.core.d.b.a(r9)
            r0 = 0
            if (r9 == 0) goto L_0x00a1
            java.lang.String r9 = com.bytedance.sdk.openadsdk.core.d.b.b()
            r2 = r9
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 != 0) goto L_0x0026
            android.content.Context r2 = r8.a
            long r3 = java.lang.System.currentTimeMillis()
            com.bytedance.sdk.openadsdk.c.c.a((android.content.Context) r2, (java.lang.String) r9, (long) r3)
        L_0x0026:
            r9 = 51
            r2 = 96
            r3 = 15
            r4 = -1
            r5 = 61
            switch(r2) {
                case 95: goto L_0x0037;
                case 96: goto L_0x0033;
                case 97: goto L_0x0090;
                default: goto L_0x0032;
            }
        L_0x0032:
            goto L_0x0026
        L_0x0033:
            switch(r9) {
                case 49: goto L_0x007a;
                case 50: goto L_0x0087;
                case 51: goto L_0x0037;
                default: goto L_0x0036;
            }
        L_0x0036:
            goto L_0x0090
        L_0x0037:
            switch(r5) {
                case 60: goto L_0x003b;
                case 61: goto L_0x0046;
                case 62: goto L_0x0065;
                default: goto L_0x003a;
            }
        L_0x003a:
            goto L_0x0037
        L_0x003b:
            r9 = 18
            int r9 = r9 * r9
            r2 = 35
            int r2 = r2 * r2
            int r2 = r2 * 34
            int r9 = r9 - r2
            if (r9 != r4) goto L_0x0090
        L_0x0046:
            r9 = 54
            switch(r9) {
                case 52: goto L_0x004c;
                case 53: goto L_0x005b;
                case 54: goto L_0x0064;
                default: goto L_0x004b;
            }
        L_0x004b:
            goto L_0x0046
        L_0x004c:
            r9 = 69
            r2 = 22
            int r6 = r9 * r9
            int r7 = r2 * r2
            int r6 = r6 + r7
            int r9 = r9 * r2
            int r9 = r9 * 2
            int r6 = r6 - r9
            if (r6 >= 0) goto L_0x0065
        L_0x005b:
            int r5 = r5 * r5
            r9 = 12
            int r9 = r9 * r9
            int r9 = r9 * 34
            int r5 = r5 - r9
            if (r5 != r4) goto L_0x0026
        L_0x0064:
            return r1
        L_0x0065:
            r9 = 26
            r2 = 9
            int r6 = r9 * r9
            int r6 = r6 * r9
            int r7 = r2 * r2
            int r7 = r7 * r2
            int r6 = r6 + r7
            int r7 = r3 * r3
            int r7 = r7 * r3
            int r6 = r6 + r7
            int r9 = r9 * r2
            int r9 = r9 * r3
            int r9 = r9 * 3
            if (r6 >= r9) goto L_0x00a0
        L_0x007a:
            r9 = 80
            int r2 = r9 * r9
            int r6 = r0 * r0
            int r2 = r2 + r6
            int r2 = r2 + r6
            int r9 = r9 * r0
            int r6 = r6 + r9
            int r6 = r6 + r9
            if (r2 >= r6) goto L_0x0037
        L_0x0087:
            r9 = 15
            int r9 = r9 + r1
            int r9 = r9 * r3
            int r9 = r9 % 2
            if (r9 == 0) goto L_0x0026
            goto L_0x0037
        L_0x0090:
            r9 = 70
            r2 = 44
            int r6 = r9 * r9
            int r7 = r2 * r2
            int r6 = r6 + r7
            int r9 = r9 * r2
            int r9 = r9 * 2
            int r6 = r6 - r9
            if (r6 >= 0) goto L_0x00a0
            goto L_0x003b
        L_0x00a0:
            return r1
        L_0x00a1:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.o.c(java.lang.String):boolean");
    }

    private boolean c(JSONObject jSONObject) {
        return jSONObject != null && jSONObject.length() > 0;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x003a, code lost:
        switch(r2) {
            case 18: goto L_0x003f;
            case 19: goto L_0x003f;
            case 20: goto L_0x0006;
            default: goto L_0x003d;
        };
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x022b, code lost:
        if (r3 <= 'N') goto L_0x0006;
     */
    @com.bytedance.JProtect
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private org.json.JSONObject d() {
        /*
            r11 = this;
            java.lang.String r0 = "mba"
            java.lang.String r1 = "moa"
            r2 = 26
        L_0x0006:
            r3 = 31
        L_0x0008:
            r4 = 10
            r5 = 1
            switch(r4) {
                case 10: goto L_0x0035;
                case 11: goto L_0x0229;
                case 12: goto L_0x000f;
                default: goto L_0x000e;
            }
        L_0x000e:
            goto L_0x0006
        L_0x000f:
            r4 = 94
            if (r3 == r4) goto L_0x0014
            goto L_0x001d
        L_0x0014:
            r3 = 71
            int r3 = r3 + r5
            int r3 = r3 * 71
            int r3 = r3 % 2
            if (r3 == 0) goto L_0x003a
        L_0x001d:
            r2 = 65
            r3 = 33
            r4 = 27
            int r6 = r2 * r2
            int r6 = r6 * r2
            int r7 = r3 * r3
            int r7 = r7 * r3
            int r6 = r6 + r7
            int r7 = r4 * r4
            int r7 = r7 * r4
            int r6 = r6 + r7
            int r2 = r2 * r3
            int r2 = r2 * r4
            int r2 = r2 * 3
            if (r6 >= r2) goto L_0x0223
            goto L_0x003f
        L_0x0035:
            switch(r3) {
                case 31: goto L_0x0223;
                case 32: goto L_0x003a;
                case 33: goto L_0x0223;
                default: goto L_0x0038;
            }
        L_0x0038:
            goto L_0x0229
        L_0x003a:
            switch(r2) {
                case 18: goto L_0x003f;
                case 19: goto L_0x003f;
                case 20: goto L_0x0006;
                default: goto L_0x003d;
            }
        L_0x003d:
            goto L_0x0223
        L_0x003f:
            org.json.JSONObject r2 = new org.json.JSONObject
            r2.<init>()
            java.lang.String r3 = "u`"
            java.lang.String r3 = com.bytedance.sdk.component.adexpress.widget.DynamicUnlockView.DynamicUnlockView1667305730929dc(r3)     // Catch:{ Exception -> 0x0222 }
            java.lang.String r4 = com.bytedance.sdk.openadsdk.l.y.c()     // Catch:{ Exception -> 0x0222 }
            r2.put(r3, r4)     // Catch:{ Exception -> 0x0222 }
            java.lang.String r3 = "ae]p`nYqm{ybcc"
            java.lang.String r3 = com.bytedance.sdk.component.adexpress.widget.DynamicUnlockView.DynamicUnlockView1667305730929dc(r3)     // Catch:{ Exception -> 0x0222 }
            java.lang.String r4 = "4/:-4+0"
            java.lang.String r4 = com.bytedance.sdk.component.adexpress.widget.DynamicUnlockView.DynamicUnlockView1667305730929dc(r4)     // Catch:{ Exception -> 0x0222 }
            r2.put(r3, r4)     // Catch:{ Exception -> 0x0222 }
            java.lang.String r3 = "sho\\ku"
            java.lang.String r3 = com.bytedance.sdk.component.adexpress.widget.DynamicUnlockView.DynamicUnlockView1667305730929dc(r3)     // Catch:{ Exception -> 0x0222 }
            android.content.Context r4 = r11.a     // Catch:{ Exception -> 0x0222 }
            java.lang.String r4 = a((android.content.Context) r4)     // Catch:{ Exception -> 0x0222 }
            r2.put(r3, r4)     // Catch:{ Exception -> 0x0222 }
            java.lang.String r3 = "rnmw"
            java.lang.String r3 = com.bytedance.sdk.component.adexpress.widget.DynamicUnlockView.DynamicUnlockView1667305730929dc(r3)     // Catch:{ Exception -> 0x0222 }
            boolean r4 = r11.b     // Catch:{ Exception -> 0x0222 }
            r6 = 0
            if (r4 == 0) goto L_0x007c
            r4 = r5
            goto L_0x007d
        L_0x007c:
            r4 = r6
        L_0x007d:
            r2.put(r3, r4)     // Catch:{ Exception -> 0x0222 }
            java.lang.String r3 = "thof~jhb"
            java.lang.String r3 = com.bytedance.sdk.component.adexpress.widget.DynamicUnlockView.DynamicUnlockView1667305730929dc(r3)     // Catch:{ Exception -> 0x0222 }
            int r4 = f()     // Catch:{ Exception -> 0x0222 }
            r2.put(r3, r4)     // Catch:{ Exception -> 0x0222 }
            java.lang.String r3 = "abafwv"
            java.lang.String r3 = com.bytedance.sdk.component.adexpress.widget.DynamicUnlockView.DynamicUnlockView1667305730929dc(r3)     // Catch:{ Exception -> 0x0222 }
            android.content.Context r4 = r11.a     // Catch:{ Exception -> 0x0222 }
            java.lang.String r4 = com.bytedance.sdk.openadsdk.l.n.a(r4)     // Catch:{ Exception -> 0x0222 }
            r2.put(r3, r4)     // Catch:{ Exception -> 0x0222 }
            java.lang.String r3 = "or"
            java.lang.String r3 = com.bytedance.sdk.component.adexpress.widget.DynamicUnlockView.DynamicUnlockView1667305730929dc(r3)     // Catch:{ Exception -> 0x0222 }
            java.lang.String r4 = "Aofqklb"
            java.lang.String r4 = com.bytedance.sdk.component.adexpress.widget.DynamicUnlockView.DynamicUnlockView1667305730929dc(r4)     // Catch:{ Exception -> 0x0222 }
            r2.put(r3, r4)     // Catch:{ Exception -> 0x0222 }
            java.lang.String r3 = "or]uawungg"
            java.lang.String r3 = com.bytedance.sdk.component.adexpress.widget.DynamicUnlockView.DynamicUnlockView1667305730929dc(r3)     // Catch:{ Exception -> 0x0222 }
            java.lang.String r4 = android.os.Build.VERSION.RELEASE     // Catch:{ Exception -> 0x0222 }
            r2.put(r3, r4)     // Catch:{ Exception -> 0x0222 }
            java.lang.String r3 = "or]btl"
            java.lang.String r3 = com.bytedance.sdk.component.adexpress.widget.DynamicUnlockView.DynamicUnlockView1667305730929dc(r3)     // Catch:{ Exception -> 0x0222 }
            int r4 = android.os.Build.VERSION.SDK_INT     // Catch:{ Exception -> 0x0222 }
            r2.put(r3, r4)     // Catch:{ Exception -> 0x0222 }
            java.lang.String r3 = "ddtjg`Ysqyo"
            java.lang.String r3 = com.bytedance.sdk.component.adexpress.widget.DynamicUnlockView.DynamicUnlockView1667305730929dc(r3)     // Catch:{ Exception -> 0x0222 }
            java.lang.String r4 = r11.c     // Catch:{ Exception -> 0x0222 }
            r2.put(r3, r4)     // Catch:{ Exception -> 0x0222 }
            java.lang.String r3 = "ddtjg`Yjgmog"
            java.lang.String r3 = com.bytedance.sdk.component.adexpress.widget.DynamicUnlockView.DynamicUnlockView1667305730929dc(r3)     // Catch:{ Exception -> 0x0222 }
            java.lang.String r4 = android.os.Build.MODEL     // Catch:{ Exception -> 0x0222 }
            r2.put(r3, r4)     // Catch:{ Exception -> 0x0222 }
            java.lang.String r3 = "ddtjg`Yezhdo"
            java.lang.String r3 = com.bytedance.sdk.component.adexpress.widget.DynamicUnlockView.DynamicUnlockView1667305730929dc(r3)     // Catch:{ Exception -> 0x0222 }
            java.lang.String r4 = android.os.Build.BRAND     // Catch:{ Exception -> 0x0222 }
            r2.put(r3, r4)     // Catch:{ Exception -> 0x0222 }
            java.lang.String r3 = "ddtjg`Yjigmmnzzbt`"
            java.lang.String r3 = com.bytedance.sdk.component.adexpress.widget.DynamicUnlockView.DynamicUnlockView1667305730929dc(r3)     // Catch:{ Exception -> 0x0222 }
            java.lang.String r4 = android.os.Build.MANUFACTURER     // Catch:{ Exception -> 0x0222 }
            r2.put(r3, r4)     // Catch:{ Exception -> 0x0222 }
            java.lang.String r3 = "l`ldqdab"
            java.lang.String r3 = com.bytedance.sdk.component.adexpress.widget.DynamicUnlockView.DynamicUnlockView1667305730929dc(r3)     // Catch:{ Exception -> 0x0222 }
            java.util.Locale r4 = java.util.Locale.getDefault()     // Catch:{ Exception -> 0x0222 }
            java.lang.String r4 = r4.getLanguage()     // Catch:{ Exception -> 0x0222 }
            r2.put(r3, r4)     // Catch:{ Exception -> 0x0222 }
            java.lang.String r3 = "rdqlhprngg"
            java.lang.String r3 = com.bytedance.sdk.component.adexpress.widget.DynamicUnlockView.DynamicUnlockView1667305730929dc(r3)     // Catch:{ Exception -> 0x0222 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0222 }
            r4.<init>()     // Catch:{ Exception -> 0x0222 }
            android.content.Context r7 = r11.a     // Catch:{ Exception -> 0x0222 }
            int r7 = com.bytedance.sdk.openadsdk.l.z.d((android.content.Context) r7)     // Catch:{ Exception -> 0x0222 }
            r4.append(r7)     // Catch:{ Exception -> 0x0222 }
            java.lang.String r7 = "x"
            java.lang.String r7 = com.bytedance.sdk.component.adexpress.widget.DynamicUnlockView.DynamicUnlockView1667305730929dc(r7)     // Catch:{ Exception -> 0x0222 }
            r4.append(r7)     // Catch:{ Exception -> 0x0222 }
            android.content.Context r7 = r11.a     // Catch:{ Exception -> 0x0222 }
            int r7 = com.bytedance.sdk.openadsdk.l.z.c((android.content.Context) r7)     // Catch:{ Exception -> 0x0222 }
            r4.append(r7)     // Catch:{ Exception -> 0x0222 }
            java.lang.String r4 = r4.toString()     // Catch:{ Exception -> 0x0222 }
            r2.put(r3, r4)     // Catch:{ Exception -> 0x0222 }
            java.lang.String r3 = "dhqshdXlldxeyw"
            java.lang.String r3 = com.bytedance.sdk.component.adexpress.widget.DynamicUnlockView.DynamicUnlockView1667305730929dc(r3)     // Catch:{ Exception -> 0x0222 }
            android.content.Context r4 = r11.a     // Catch:{ Exception -> 0x0222 }
            int r4 = com.bytedance.sdk.openadsdk.l.z.g(r4)     // Catch:{ Exception -> 0x0222 }
            java.lang.String r4 = a((int) r4)     // Catch:{ Exception -> 0x0222 }
            r2.put(r3, r4)     // Catch:{ Exception -> 0x0222 }
            java.lang.String r3 = "ddlpmqXlyc"
            java.lang.String r3 = com.bytedance.sdk.component.adexpress.widget.DynamicUnlockView.DynamicUnlockView1667305730929dc(r3)     // Catch:{ Exception -> 0x0222 }
            android.content.Context r4 = r11.a     // Catch:{ Exception -> 0x0222 }
            int r4 = com.bytedance.sdk.openadsdk.l.z.g(r4)     // Catch:{ Exception -> 0x0222 }
            r2.put(r3, r4)     // Catch:{ Exception -> 0x0222 }
            java.lang.String r3 = "ddtjg`Ynl"
            java.lang.String r3 = com.bytedance.sdk.component.adexpress.widget.DynamicUnlockView.DynamicUnlockView1667305730929dc(r3)     // Catch:{ Exception -> 0x0222 }
            android.content.Context r4 = r11.a     // Catch:{ Exception -> 0x0222 }
            java.lang.String r4 = com.bytedance.sdk.openadsdk.core.j.a(r4)     // Catch:{ Exception -> 0x0222 }
            r2.put(r3, r4)     // Catch:{ Exception -> 0x0222 }
            java.lang.String r3 = "ahf"
            java.lang.String r3 = com.bytedance.sdk.component.adexpress.widget.DynamicUnlockView.DynamicUnlockView1667305730929dc(r3)     // Catch:{ Exception -> 0x0222 }
            java.lang.String r4 = "1252"
            java.lang.String r4 = com.bytedance.sdk.component.adexpress.widget.DynamicUnlockView.DynamicUnlockView1667305730929dc(r4)     // Catch:{ Exception -> 0x0222 }
            r2.put(r3, r4)     // Catch:{ Exception -> 0x0222 }
            java.lang.String r3 = "rno"
            java.lang.String r3 = com.bytedance.sdk.component.adexpress.widget.DynamicUnlockView.DynamicUnlockView1667305730929dc(r3)     // Catch:{ Exception -> 0x0222 }
            java.lang.String r4 = b()     // Catch:{ Exception -> 0x0222 }
            r2.put(r3, r4)     // Catch:{ Exception -> 0x0222 }
            java.lang.String r3 = "cqw\\ego"
            java.lang.String r3 = com.bytedance.sdk.component.adexpress.widget.DynamicUnlockView.DynamicUnlockView1667305730929dc(r3)     // Catch:{ Exception -> 0x0222 }
            java.lang.String r4 = android.os.Build.CPU_ABI     // Catch:{ Exception -> 0x0222 }
            r2.put(r3, r4)     // Catch:{ Exception -> 0x0222 }
            java.lang.String r3 = "uu"
            java.lang.String r3 = com.bytedance.sdk.component.adexpress.widget.DynamicUnlockView.DynamicUnlockView1667305730929dc(r3)     // Catch:{ Exception -> 0x0222 }
            int r4 = r11.e     // Catch:{ Exception -> 0x0222 }
            r2.put(r3, r4)     // Catch:{ Exception -> 0x0222 }
            java.lang.String r3 = "uhf"
            java.lang.String r3 = com.bytedance.sdk.component.adexpress.widget.DynamicUnlockView.DynamicUnlockView1667305730929dc(r3)     // Catch:{ Exception -> 0x0222 }
            long r7 = r11.d     // Catch:{ Exception -> 0x0222 }
            r2.put(r3, r7)     // Catch:{ Exception -> 0x0222 }
            java.lang.String r3 = "gnmdh`Yfam"
            java.lang.String r3 = com.bytedance.sdk.component.adexpress.widget.DynamicUnlockView.DynamicUnlockView1667305730929dc(r3)     // Catch:{ Exception -> 0x0222 }
            com.com.bytedance.overseas.sdk.b.a r4 = com.com.bytedance.overseas.sdk.b.a.a()     // Catch:{ Exception -> 0x0222 }
            java.lang.String r4 = r4.b()     // Catch:{ Exception -> 0x0222 }
            r2.put(r3, r4)     // Catch:{ Exception -> 0x0222 }
            java.lang.String r3 = "lnabh`Ykigm~mjk"
            java.lang.String r3 = com.bytedance.sdk.component.adexpress.widget.DynamicUnlockView.DynamicUnlockView1667305730929dc(r3)     // Catch:{ Exception -> 0x0222 }
            java.lang.String r4 = com.bytedance.sdk.openadsdk.l.e.c()     // Catch:{ Exception -> 0x0222 }
            r2.put(r3, r4)     // Catch:{ Exception -> 0x0222 }
            float r3 = com.bytedance.sdk.openadsdk.l.e.d()     // Catch:{ Exception -> 0x0222 }
            java.lang.String r4 = "sbpfakYez`mcx"
            java.lang.String r4 = com.bytedance.sdk.component.adexpress.widget.DynamicUnlockView.DynamicUnlockView1667305730929dc(r4)     // Catch:{ Exception -> 0x0222 }
            r7 = 1092616192(0x41200000, float:10.0)
            float r3 = r3 * r7
            double r7 = (double) r3     // Catch:{ Exception -> 0x0222 }
            double r7 = java.lang.Math.ceil(r7)     // Catch:{ Exception -> 0x0222 }
            r9 = 4621819117588971520(0x4024000000000000, double:10.0)
            double r7 = r7 / r9
            r2.put(r4, r7)     // Catch:{ Exception -> 0x0222 }
            java.lang.String r3 = "ir]pgwcbfVemj"
            java.lang.String r3 = com.bytedance.sdk.component.adexpress.widget.DynamicUnlockView.DynamicUnlockView1667305730929dc(r3)     // Catch:{ Exception -> 0x0222 }
            boolean r4 = com.bytedance.sdk.openadsdk.l.e.a()     // Catch:{ Exception -> 0x0222 }
            if (r4 == 0) goto L_0x01dc
            r5 = r6
        L_0x01dc:
            r2.put(r3, r5)     // Catch:{ Exception -> 0x0222 }
            com.bytedance.sdk.openadsdk.core.settings.j r3 = com.bytedance.sdk.openadsdk.core.m.d()     // Catch:{ Exception -> 0x0222 }
            java.lang.String r4 = "fnp`aZjffnjkh"
            java.lang.String r4 = com.bytedance.sdk.component.adexpress.widget.DynamicUnlockView.DynamicUnlockView1667305730929dc(r4)     // Catch:{ Exception -> 0x0222 }
            android.content.Context r5 = r11.a     // Catch:{ Exception -> 0x0222 }
            java.lang.String r6 = "tu]`ljitmVfjbj{nwt"
            java.lang.String r6 = com.bytedance.sdk.component.adexpress.widget.DynamicUnlockView.DynamicUnlockView1667305730929dc(r6)     // Catch:{ Exception -> 0x0222 }
            java.lang.String r5 = com.bytedance.sdk.component.utils.t.a(r5, r6)     // Catch:{ Exception -> 0x0222 }
            r2.put(r4, r5)     // Catch:{ Exception -> 0x0222 }
            java.lang.String r4 = com.bytedance.sdk.component.adexpress.widget.DynamicUnlockView.DynamicUnlockView1667305730929dc(r1)     // Catch:{ Exception -> 0x0222 }
            boolean r4 = r3.x(r4)     // Catch:{ Exception -> 0x0222 }
            if (r4 == 0) goto L_0x020d
            java.lang.String r1 = com.bytedance.sdk.component.adexpress.widget.DynamicUnlockView.DynamicUnlockView1667305730929dc(r1)     // Catch:{ Exception -> 0x0222 }
            java.lang.String r4 = com.bytedance.sdk.openadsdk.l.q.c()     // Catch:{ Exception -> 0x0222 }
            r2.put(r1, r4)     // Catch:{ Exception -> 0x0222 }
        L_0x020d:
            java.lang.String r1 = com.bytedance.sdk.component.adexpress.widget.DynamicUnlockView.DynamicUnlockView1667305730929dc(r0)     // Catch:{ Exception -> 0x0222 }
            boolean r1 = r3.x(r1)     // Catch:{ Exception -> 0x0222 }
            if (r1 == 0) goto L_0x0222
            java.lang.String r0 = com.bytedance.sdk.component.adexpress.widget.DynamicUnlockView.DynamicUnlockView1667305730929dc(r0)     // Catch:{ Exception -> 0x0222 }
            java.lang.String r1 = com.bytedance.sdk.openadsdk.l.q.b()     // Catch:{ Exception -> 0x0222 }
            r2.put(r0, r1)     // Catch:{ Exception -> 0x0222 }
        L_0x0222:
            return r2
        L_0x0223:
            r3 = 32
            r2 = 18
            goto L_0x0008
        L_0x0229:
            r4 = 78
            if (r3 <= r4) goto L_0x0006
        L_0x022d:
            goto L_0x022d
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.o.d():org.json.JSONObject");
    }

    /* access modifiers changed from: private */
    public void d(String str) {
        com.bytedance.sdk.component.f.b.b c2 = com.bytedance.sdk.openadsdk.i.d.a().b().c();
        c2.a(str);
        c2.a((com.bytedance.sdk.component.f.a.a) new com.bytedance.sdk.component.f.a.a() {
            /* JADX WARNING: Can't fix incorrect switch cases order */
            /* JADX WARNING: Code restructure failed: missing block: B:10:0x0051, code lost:
                if ((((70 * 70) + (7 * 7)) + (4 * 4)) >= (((70 * 7) + (7 * 4)) + (70 * 4))) goto L_0x000d;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:3:0x0018, code lost:
                switch(r5) {
                    case 94: goto L_0x002a;
                    case 95: goto L_0x003f;
                    case 96: goto L_0x0053;
                    default: goto L_0x001b;
                };
             */
            /* JADX WARNING: Code restructure failed: missing block: B:4:0x001b, code lost:
                r5 = '_';
             */
            /* JADX WARNING: Code restructure failed: missing block: B:6:0x0028, code lost:
                if (((66 * 66) - ((16 * 16) * 34)) == -1) goto L_0x002a;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:8:0x003d, code lost:
                if ((((29 * 29) + (45 * 45)) + (20 * 20)) >= (((29 * 45) + (45 * 20)) + (29 * 20))) goto L_0x0053;
             */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void a(com.bytedance.sdk.component.f.b.c r5, com.bytedance.sdk.component.f.b r6) {
                /*
                    r4 = this;
                    java.lang.String r5 = "cmkfjq&eamnbbj.|erqvgf"
                    java.lang.String r5 = com.bytedance.sdk.component.d.c.a.a1667305730971dc(r5)
                    java.lang.String r6 = r6.d()
                    com.bytedance.sdk.component.utils.l.b((java.lang.String) r5, (java.lang.String) r6)
                L_0x000d:
                    r5 = 92
                    r6 = 14
                    r0 = 4
                    r1 = 20
                    switch(r6) {
                        case 13: goto L_0x001e;
                        case 14: goto L_0x0064;
                        case 15: goto L_0x0018;
                        default: goto L_0x0017;
                    }
                L_0x0017:
                    goto L_0x000d
                L_0x0018:
                    switch(r5) {
                        case 94: goto L_0x002a;
                        case 95: goto L_0x003f;
                        case 96: goto L_0x0053;
                        default: goto L_0x001b;
                    }
                L_0x001b:
                    r5 = 95
                    goto L_0x0018
                L_0x001e:
                    r5 = 66
                    int r5 = r5 * r5
                    r6 = 16
                    int r6 = r6 * r6
                    int r6 = r6 * 34
                    int r5 = r5 - r6
                    r6 = -1
                    if (r5 != r6) goto L_0x003f
                L_0x002a:
                    r5 = 29
                    r6 = 45
                    int r2 = r5 * r5
                    int r3 = r6 * r6
                    int r2 = r2 + r3
                    int r3 = r1 * r1
                    int r2 = r2 + r3
                    r3 = 29
                    int r3 = r3 * r6
                    int r6 = r6 * r1
                    int r3 = r3 + r6
                    int r5 = r5 * r1
                    int r3 = r3 + r5
                    if (r2 >= r3) goto L_0x0053
                L_0x003f:
                    r5 = 70
                    r6 = 7
                    int r2 = r5 * r5
                    int r3 = r6 * r6
                    int r2 = r2 + r3
                    int r3 = r0 * r0
                    int r2 = r2 + r3
                    r3 = 70
                    int r3 = r3 * r6
                    int r6 = r6 * r0
                    int r3 = r3 + r6
                    int r5 = r5 * r0
                    int r3 = r3 + r5
                    if (r2 >= r3) goto L_0x000d
                L_0x0053:
                    r5 = 69
                    int r6 = r5 * r5
                    int r2 = r1 * r1
                    int r6 = r6 + r2
                    int r2 = r0 * r0
                    int r6 = r6 + r2
                    r2 = 69
                    int r2 = r2 * r1
                    int r1 = r1 * r0
                    int r2 = r2 + r1
                    int r5 = r5 * r0
                    int r2 = r2 + r5
                L_0x0064:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.o.AnonymousClass9.a(com.bytedance.sdk.component.f.b.c, com.bytedance.sdk.component.f.b):void");
            }

            /* JADX WARNING: Can't fix incorrect switch cases order */
            /* JADX WARNING: Code restructure failed: missing block: B:10:0x0050, code lost:
                if ((((70 * 70) + (7 * 7)) + (4 * 4)) >= (((70 * 7) + (7 * 4)) + (70 * 4))) goto L_0x000d;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:3:0x0018, code lost:
                switch(r5) {
                    case 94: goto L_0x002a;
                    case 95: goto L_0x003e;
                    case 96: goto L_0x0052;
                    default: goto L_0x001b;
                };
             */
            /* JADX WARNING: Code restructure failed: missing block: B:4:0x001b, code lost:
                r5 = '_';
             */
            /* JADX WARNING: Code restructure failed: missing block: B:6:0x0028, code lost:
                if (((66 * 66) - ((16 * 16) * 34)) == -1) goto L_0x002a;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:8:0x003c, code lost:
                if ((((29 * 29) + (45 * 45)) + 400) >= (((29 * 45) + (45 * 20)) + (29 * 20))) goto L_0x0052;
             */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void a(com.bytedance.sdk.component.f.b.c r5, java.io.IOException r6) {
                /*
                    r4 = this;
                    java.lang.String r5 = "cmkfjq&eamnbbj.iqx~"
                    java.lang.String r5 = com.bytedance.sdk.component.d.c.a.a1667305730971dc(r5)
                    java.lang.String r6 = r6.toString()
                    com.bytedance.sdk.component.utils.l.b((java.lang.String) r5, (java.lang.String) r6)
                L_0x000d:
                    r5 = 92
                    r6 = 14
                    r0 = 4
                    r1 = 20
                    switch(r6) {
                        case 13: goto L_0x001e;
                        case 14: goto L_0x0062;
                        case 15: goto L_0x0018;
                        default: goto L_0x0017;
                    }
                L_0x0017:
                    goto L_0x000d
                L_0x0018:
                    switch(r5) {
                        case 94: goto L_0x002a;
                        case 95: goto L_0x003e;
                        case 96: goto L_0x0052;
                        default: goto L_0x001b;
                    }
                L_0x001b:
                    r5 = 95
                    goto L_0x0018
                L_0x001e:
                    r5 = 66
                    int r5 = r5 * r5
                    r6 = 16
                    int r6 = r6 * r6
                    int r6 = r6 * 34
                    int r5 = r5 - r6
                    r6 = -1
                    if (r5 != r6) goto L_0x003e
                L_0x002a:
                    r5 = 29
                    r6 = 45
                    int r2 = r5 * r5
                    int r3 = r6 * r6
                    int r2 = r2 + r3
                    int r2 = r2 + 400
                    r3 = 29
                    int r3 = r3 * r6
                    int r6 = r6 * r1
                    int r3 = r3 + r6
                    int r5 = r5 * r1
                    int r3 = r3 + r5
                    if (r2 >= r3) goto L_0x0052
                L_0x003e:
                    r5 = 70
                    r6 = 7
                    int r2 = r5 * r5
                    int r3 = r6 * r6
                    int r2 = r2 + r3
                    int r3 = r0 * r0
                    int r2 = r2 + r3
                    r3 = 70
                    int r3 = r3 * r6
                    int r6 = r6 * r0
                    int r3 = r3 + r6
                    int r5 = r5 * r0
                    int r3 = r3 + r5
                    if (r2 >= r3) goto L_0x000d
                L_0x0052:
                    r5 = 69
                    int r6 = r5 * r5
                    int r6 = r6 + 400
                    int r2 = r0 * r0
                    int r6 = r6 + r2
                    r2 = 69
                    int r2 = r2 * r1
                    int r1 = r1 * r0
                    int r2 = r2 + r1
                    int r5 = r5 * r0
                    int r2 = r2 + r5
                L_0x0062:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.o.AnonymousClass9.a(com.bytedance.sdk.component.f.b.c, java.io.IOException):void");
            }
        });
    }

    @JProtect
    private void d(JSONObject jSONObject) {
        if (h.d().s()) {
            try {
                jSONObject.getJSONObject(d.d1667305730926dc("hdcgaw")).put(d.d1667305730926dc("ahf"), d.d1667305730926dc("4441"));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            JSONObject a2 = com.bytedance.sdk.component.utils.a.a(jSONObject);
            if (c(a2)) {
                jSONObject = a2;
            }
            Map<String, String> e3 = e(jSONObject);
            com.bytedance.sdk.component.f.b.d b2 = com.bytedance.sdk.openadsdk.i.d.a().b().b();
            b2.a(y.m());
            if (e3 != null) {
                for (Map.Entry next : e3.entrySet()) {
                    try {
                        b2.b((String) next.getKey(), (String) next.getValue());
                    } catch (Exception unused) {
                    }
                }
            }
            b2.c(jSONObject.toString());
            try {
                b2.b(d.d1667305730926dc("Urgq)Dabf}"), y.c());
            } catch (Exception unused2) {
            }
            b2.a((com.bytedance.sdk.component.f.a.a) new com.bytedance.sdk.component.f.a.a() {
                /* JADX WARNING: Code restructure failed: missing block: B:11:0x0056, code lost:
                    if ((((69 * 69) + (20 * 20)) + (4 * 4)) >= (((69 * 20) + (20 * 4)) + (69 * 4))) goto L_0x0027;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:13:0x0060, code lost:
                    if (((18 * 18) - ((35 * 35) * 34)) != -1) goto L_0x0084;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:16:0x006e, code lost:
                    if ((((9 + 1) * 9) % 2) == 0) goto L_0x0084;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:18:0x0078, code lost:
                    if (((82 * 82) - ((40 * 40) * 34)) != -1) goto L_?;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:19:0x007a, code lost:
                    r0 = (((0 - 1) * 0) * ((0 * 2) - 1)) % 6;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:28:0x001b, code lost:
                    continue;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:30:?, code lost:
                    return;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:7:0x0027, code lost:
                    switch(39) {
                        case 60: goto L_0x002b;
                        case 61: goto L_0x0042;
                        case 62: goto L_0x0058;
                        default: goto L_0x002a;
                    };
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:9:0x0040, code lost:
                    if ((((57 * 57) + (34 * 34)) + (12 * 12)) >= (((57 * 34) + (34 * 12)) + (57 * 12))) goto L_0x001b;
                 */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public void a(com.bytedance.sdk.component.f.b.c r9, com.bytedance.sdk.component.f.b r10) {
                    /*
                        r8 = this;
                        java.lang.String r9 = "NdvBtlOjxe"
                        if (r10 == 0) goto L_0x0084
                        boolean r0 = r10.f()
                        if (r0 == 0) goto L_0x0084
                        java.lang.String r0 = com.bytedance.sdk.component.d.c.c.b.c$b1667305730972dc(r9)
                        java.lang.String r1 = "ooPfwuii{l0+"
                        java.lang.String r1 = com.bytedance.sdk.component.d.c.c.b.c$b1667305730972dc(r1)
                        java.lang.String r10 = r10.d()
                        com.bytedance.sdk.component.utils.l.b((java.lang.String) r0, (java.lang.String) r1, (java.lang.String) r10)
                    L_0x001b:
                        r10 = 97
                        r0 = 39
                        r1 = -1
                        r2 = 1
                        r3 = 34
                        switch(r10) {
                            case 95: goto L_0x0027;
                            case 96: goto L_0x0063;
                            case 97: goto L_0x0091;
                            default: goto L_0x0026;
                        }
                    L_0x0026:
                        goto L_0x001b
                    L_0x0027:
                        switch(r0) {
                            case 60: goto L_0x002b;
                            case 61: goto L_0x0042;
                            case 62: goto L_0x0058;
                            default: goto L_0x002a;
                        }
                    L_0x002a:
                        goto L_0x0063
                    L_0x002b:
                        r10 = 57
                        r4 = 12
                        int r5 = r10 * r10
                        int r6 = r3 * r3
                        int r5 = r5 + r6
                        int r6 = r4 * r4
                        int r5 = r5 + r6
                        r6 = 57
                        int r6 = r6 * r3
                        r7 = 34
                        int r7 = r7 * r4
                        int r6 = r6 + r7
                        int r10 = r10 * r4
                        int r6 = r6 + r10
                        if (r5 >= r6) goto L_0x001b
                    L_0x0042:
                        r10 = 69
                        r4 = 20
                        r5 = 4
                        int r6 = r10 * r10
                        int r7 = r4 * r4
                        int r6 = r6 + r7
                        int r7 = r5 * r5
                        int r6 = r6 + r7
                        r7 = 69
                        int r7 = r7 * r4
                        int r4 = r4 * r5
                        int r7 = r7 + r4
                        int r10 = r10 * r5
                        int r7 = r7 + r10
                        if (r6 >= r7) goto L_0x0027
                    L_0x0058:
                        r10 = 18
                        int r10 = r10 * r10
                        r0 = 35
                        int r0 = r0 * r0
                        int r0 = r0 * r3
                        int r10 = r10 - r0
                        if (r10 != r1) goto L_0x0084
                        goto L_0x0067
                    L_0x0063:
                        switch(r0) {
                            case 49: goto L_0x0067;
                            case 50: goto L_0x0070;
                            case 51: goto L_0x007a;
                            default: goto L_0x0066;
                        }
                    L_0x0066:
                        goto L_0x0091
                    L_0x0067:
                        r10 = 9
                        int r10 = r10 + r2
                        int r10 = r10 * 9
                        int r10 = r10 % 2
                        if (r10 == 0) goto L_0x0084
                    L_0x0070:
                        r10 = 82
                        int r10 = r10 * r10
                        r0 = 40
                        int r0 = r0 * r0
                        int r0 = r0 * r3
                        int r10 = r10 - r0
                        if (r10 != r1) goto L_0x0091
                    L_0x007a:
                        r10 = 0
                        int r0 = 0 - r2
                        int r0 = r0 * r10
                        int r10 = r10 * 2
                        int r10 = r10 - r2
                        int r0 = r0 * r10
                        int r0 = r0 % 6
                    L_0x0084:
                        java.lang.String r9 = com.bytedance.sdk.component.d.c.c.b.c$b1667305730972dc(r9)
                        java.lang.String r10 = "ooPfwuii{l0+Bhz]ubb|zfs7qj:uiqr"
                        java.lang.String r10 = com.bytedance.sdk.component.d.c.c.b.c$b1667305730972dc(r10)
                        com.bytedance.sdk.component.utils.l.c((java.lang.String) r9, (java.lang.String) r10)
                    L_0x0091:
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.o.AnonymousClass5.a(com.bytedance.sdk.component.f.b.c, com.bytedance.sdk.component.f.b):void");
                }

                /* JADX WARNING: Can't fix incorrect switch cases order */
                /* JADX WARNING: Code restructure failed: missing block: B:10:0x0051, code lost:
                    if ((((29 * 29) + (45 * 45)) + (20 * 20)) >= (((29 * 45) + (45 * 20)) + (29 * 20))) goto L_0x0067;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:12:0x0065, code lost:
                    if ((((70 * 70) + (7 * 7)) + (4 * 4)) >= (((70 * 7) + (7 * 4)) + (70 * 4))) goto L_0x0013;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:3:0x001e, code lost:
                    switch(r5) {
                        case 94: goto L_0x003e;
                        case 95: goto L_0x0053;
                        case 96: goto L_0x0067;
                        default: goto L_0x0021;
                    };
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:4:0x0021, code lost:
                    r5 = '_';
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:8:0x003c, code lost:
                    if (((66 * 66) - ((16 * 16) * 34)) == -1) goto L_0x003e;
                 */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public void a(com.bytedance.sdk.component.f.b.c r5, java.io.IOException r6) {
                    /*
                        r4 = this;
                        java.lang.String r5 = "NdvBtlOjxe"
                        java.lang.String r5 = com.bytedance.sdk.component.d.c.c.b.c$b1667305730972dc(r5)
                        java.lang.String r0 = "ooDbmisum3*"
                        java.lang.String r0 = com.bytedance.sdk.component.d.c.c.b.c$b1667305730972dc(r0)
                        java.lang.String r6 = r6.getMessage()
                        com.bytedance.sdk.component.utils.l.b((java.lang.String) r5, (java.lang.String) r0, (java.lang.String) r6)
                    L_0x0013:
                        r5 = 12
                        r6 = 96
                        r0 = 4
                        r1 = 20
                        switch(r6) {
                            case 94: goto L_0x0024;
                            case 95: goto L_0x001e;
                            case 96: goto L_0x0078;
                            default: goto L_0x001d;
                        }
                    L_0x001d:
                        goto L_0x0013
                    L_0x001e:
                        switch(r5) {
                            case 94: goto L_0x003e;
                            case 95: goto L_0x0053;
                            case 96: goto L_0x0067;
                            default: goto L_0x0021;
                        }
                    L_0x0021:
                        r5 = 95
                        goto L_0x001e
                    L_0x0024:
                        r5 = 81
                        r6 = 1
                        int r2 = 81 - r6
                        int r2 = r2 * r5
                        int r5 = r5 * 2
                        int r5 = r5 - r6
                        int r2 = r2 * r5
                        int r2 = r2 % 6
                        if (r2 == 0) goto L_0x0078
                        r5 = 66
                        int r5 = r5 * r5
                        r6 = 16
                        int r6 = r6 * r6
                        int r6 = r6 * 34
                        int r5 = r5 - r6
                        r6 = -1
                        if (r5 != r6) goto L_0x0053
                    L_0x003e:
                        r5 = 29
                        r6 = 45
                        int r2 = r5 * r5
                        int r3 = r6 * r6
                        int r2 = r2 + r3
                        int r3 = r1 * r1
                        int r2 = r2 + r3
                        r3 = 29
                        int r3 = r3 * r6
                        int r6 = r6 * r1
                        int r3 = r3 + r6
                        int r5 = r5 * r1
                        int r3 = r3 + r5
                        if (r2 >= r3) goto L_0x0067
                    L_0x0053:
                        r5 = 70
                        r6 = 7
                        int r2 = r5 * r5
                        int r3 = r6 * r6
                        int r2 = r2 + r3
                        int r3 = r0 * r0
                        int r2 = r2 + r3
                        r3 = 70
                        int r3 = r3 * r6
                        int r6 = r6 * r0
                        int r3 = r3 + r6
                        int r5 = r5 * r0
                        int r3 = r3 + r5
                        if (r2 >= r3) goto L_0x0013
                    L_0x0067:
                        r5 = 69
                        int r6 = r5 * r5
                        int r2 = r1 * r1
                        int r6 = r6 + r2
                        int r2 = r0 * r0
                        int r6 = r6 + r2
                        r2 = 69
                        int r2 = r2 * r1
                        int r1 = r1 * r0
                        int r2 = r2 + r1
                        int r5 = r5 * r0
                        int r2 = r2 + r5
                    L_0x0078:
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.o.AnonymousClass5.a(com.bytedance.sdk.component.f.b.c, java.io.IOException):void");
                }
            });
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0055, code lost:
        if (((((26 * 26) * 26) + ((9 * 9) * 9)) + ((15 * 15) * 15)) >= (((26 * 9) * 15) * 3)) goto L_0x0039;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0061, code lost:
        if (((((0 - 1) * 0) * ((0 * 2) - 1)) % 6) == 0) goto L_0x0000;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x006c, code lost:
        if (((((18 - 1) * 18) * ((18 * 2) - 1)) % 6) == 0) goto L_0x0063;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0000, code lost:
        continue;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0036, code lost:
        r0 = r11;
        r11 = r10;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.util.Map<java.lang.String, java.lang.String> e(org.json.JSONObject r11) {
        /*
            r10 = this;
        L_0x0000:
            r0 = 52
            r1 = 96
            r2 = -1
            r3 = 13
            r4 = 34
            r5 = 1
            switch(r1) {
                case 94: goto L_0x000e;
                case 95: goto L_0x0025;
                case 96: goto L_0x0039;
                default: goto L_0x000d;
            }
        L_0x000d:
            goto L_0x0000
        L_0x000e:
            r1 = 57
            r6 = 12
            int r7 = r1 * r1
            int r8 = r4 * r4
            int r7 = r7 + r8
            int r8 = r6 * r6
            int r7 = r7 + r8
            r8 = 57
            int r8 = r8 * r4
            r9 = 34
            int r9 = r9 * r6
            int r8 = r8 + r9
            int r1 = r1 * r6
            int r8 = r8 + r1
            if (r7 >= r8) goto L_0x0039
        L_0x0025:
            r1 = r3
        L_0x0026:
            r6 = 18
            switch(r0) {
                case 55: goto L_0x003c;
                case 56: goto L_0x0039;
                case 57: goto L_0x002c;
                default: goto L_0x002b;
            }
        L_0x002b:
            goto L_0x006f
        L_0x002c:
            int r0 = r6 * r6
            r1 = 35
            int r1 = r1 * r1
            int r1 = r1 * r4
            int r0 = r0 - r1
            if (r0 != r2) goto L_0x0036
            goto L_0x0040
        L_0x0036:
            r0 = r11
            r11 = r10
            goto L_0x008b
        L_0x0039:
            r0 = r11
            r11 = r10
            goto L_0x0074
        L_0x003c:
            switch(r1) {
                case 60: goto L_0x0040;
                case 61: goto L_0x0057;
                case 62: goto L_0x0063;
                default: goto L_0x003f;
            }
        L_0x003f:
            goto L_0x0039
        L_0x0040:
            r0 = 26
            r1 = 9
            r7 = 15
            int r8 = r0 * r0
            int r8 = r8 * r0
            int r9 = r1 * r1
            int r9 = r9 * r1
            int r8 = r8 + r9
            int r9 = r7 * r7
            int r9 = r9 * r7
            int r8 = r8 + r9
            int r0 = r0 * r1
            int r0 = r0 * r7
            int r0 = r0 * 3
            if (r8 >= r0) goto L_0x0039
        L_0x0057:
            r0 = 0
            int r1 = 0 - r5
            int r1 = r1 * r0
            int r0 = r0 * 2
            int r0 = r0 - r5
            int r1 = r1 * r0
            int r1 = r1 % 6
            if (r1 == 0) goto L_0x0000
        L_0x0063:
            int r0 = 18 - r5
            int r0 = r0 * r6
            int r1 = r6 * 2
            int r1 = r1 - r5
            int r0 = r0 * r1
            int r0 = r0 % 6
            if (r0 == 0) goto L_0x0063
            goto L_0x0036
        L_0x006f:
            r0 = 55
            r1 = 61
            goto L_0x0026
        L_0x0074:
            r1 = 49
            switch(r1) {
                case 49: goto L_0x008b;
                case 50: goto L_0x007a;
                case 51: goto L_0x0083;
                default: goto L_0x0079;
            }
        L_0x0079:
            goto L_0x0074
        L_0x007a:
            int r1 = r3 * r3
            r6 = 19
            int r6 = r6 * r6
            int r6 = r6 * r4
            int r1 = r1 - r6
            if (r1 != r2) goto L_0x0074
        L_0x0083:
            r1 = 10
            int r1 = r1 + r5
            int r1 = r1 * 10
            int r1 = r1 % 2
            goto L_0x0074
        L_0x008b:
            java.util.HashMap r1 = new java.util.HashMap
            r1.<init>()
            java.lang.String r2 = "Cnlwakr*\\pzn"
            java.lang.String r2 = com.bytedance.sdk.component.adexpress.widget.FlowLightView.FlowLightView1667305730929dc(r2)
            java.lang.String r3 = "aqromfgsafd$f~aa+1q{ugerl$ooz0&"
            java.lang.String r3 = com.bytedance.sdk.component.adexpress.widget.FlowLightView.FlowLightView1667305730929dc(r3)
            r1.put(r2, r3)
            boolean r11 = r11.c((org.json.JSONObject) r0)
            if (r11 == 0) goto L_0x00b4
            java.lang.String r11 = "Cnlwakr*Mgidhd`h"
            java.lang.String r11 = com.bytedance.sdk.component.adexpress.widget.FlowLightView.FlowLightView1667305730929dc(r11)
            java.lang.String r0 = "uokljZuccVoeobjj"
            java.lang.String r0 = com.bytedance.sdk.component.adexpress.widget.FlowLightView.FlowLightView1667305730929dc(r0)
            r1.put(r11, r0)
        L_0x00b4:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.o.e(org.json.JSONObject):java.util.Map");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0031, code lost:
        if (((82 * 82) - ((40 * 40) * 34)) != -1) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0053, code lost:
        if (r1 != false) goto L_0x0066;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:?, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean e() {
        /*
            r0 = 0
            java.io.File r1 = new java.io.File     // Catch:{ Exception -> 0x0067 }
            java.lang.String r2 = "/r{pp`k(j`d$x"
            java.lang.String r2 = com.bytedance.sdk.component.d.c.c.b.c$b1667305730972dc(r2)     // Catch:{ Exception -> 0x0067 }
            r1.<init>(r2)     // Catch:{ Exception -> 0x0067 }
            boolean r1 = r1.exists()     // Catch:{ Exception -> 0x0067 }
        L_0x0010:
            r2 = 140(0x8c, float:1.96E-43)
            r3 = 73
            r4 = 34
            r5 = 1
            switch(r3) {
                case 72: goto L_0x003d;
                case 73: goto L_0x0053;
                case 74: goto L_0x001b;
                default: goto L_0x001a;
            }     // Catch:{ Exception -> 0x0067 }
        L_0x001a:
            goto L_0x0010
        L_0x001b:
            switch(r2) {
                case 52: goto L_0x001f;
                case 53: goto L_0x0028;
                case 54: goto L_0x0033;
                default: goto L_0x001e;
            }     // Catch:{ Exception -> 0x0067 }
        L_0x001e:
            goto L_0x0053
        L_0x001f:
            r2 = 9
            int r2 = r2 + r5
            int r2 = r2 * 9
            int r2 = r2 % 2
            if (r2 == 0) goto L_0x0010
        L_0x0028:
            r1 = 82
            int r1 = r1 * r1
            r2 = 40
            int r2 = r2 * r2
            int r2 = r2 * r4
            int r1 = r1 - r2
            r2 = -1
            if (r1 != r2) goto L_0x0067
        L_0x0033:
            r1 = 90
            int r1 = r1 + r5
            int r1 = r1 * 90
            int r1 = r1 % 2
            if (r1 == 0) goto L_0x0055
            goto L_0x0066
        L_0x003d:
            r2 = 57
            r3 = 12
            int r6 = r2 * r2
            int r7 = r4 * r4
            int r6 = r6 + r7
            int r7 = r3 * r3
            int r6 = r6 + r7
            r7 = 57
            int r7 = r7 * r4
            int r8 = r4 * 12
            int r7 = r7 + r8
            int r2 = r2 * r3
            int r7 = r7 + r2
            if (r6 >= r7) goto L_0x003d
        L_0x0053:
            if (r1 != 0) goto L_0x0066
        L_0x0055:
            java.io.File r1 = new java.io.File     // Catch:{ Exception -> 0x0067 }
            java.lang.String r2 = "/r{pp`k(pkce#~{"
            java.lang.String r2 = com.bytedance.sdk.component.d.c.c.b.c$b1667305730972dc(r2)     // Catch:{ Exception -> 0x0067 }
            r1.<init>(r2)     // Catch:{ Exception -> 0x0067 }
            boolean r1 = r1.exists()     // Catch:{ Exception -> 0x0067 }
            if (r1 == 0) goto L_0x0067
        L_0x0066:
            r0 = r5
        L_0x0067:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.o.e():boolean");
    }

    private static int f() {
        int rawOffset = TimeZone.getDefault().getRawOffset() / 3600000;
        if (rawOffset < -12) {
            rawOffset = -12;
        }
        if (rawOffset > 12) {
            return 12;
        }
        return rawOffset;
    }

    private boolean f(JSONObject jSONObject) {
        if (jSONObject == null) {
            return false;
        }
        try {
            boolean equalsIgnoreCase = jSONObject.optString(FlowLightView.FlowLightView1667305730929dc("mdqpebc")).equalsIgnoreCase(FlowLightView.FlowLightView1667305730929dc("sta`avu"));
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
            return equalsIgnoreCase;
        } catch (Throwable unused) {
            return false;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0055, code lost:
        if (((((26 * 26) * 26) + ((9 * 9) * 9)) + ((15 * 15) * 15)) < (((26 * 9) * 15) * 3)) goto L_0x0057;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0062, code lost:
        if (((((40 - 1) * 40) * ((40 * 2) - 1)) % 6) == 0) goto L_0x008e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0064, code lost:
        r0 = "tw";
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String g() {
        /*
            r7 = this;
            android.content.Context r0 = r7.a
            boolean r0 = com.bytedance.sdk.openadsdk.l.e.b((android.content.Context) r0)
            r1 = -1
            if (r0 == 0) goto L_0x006b
        L_0x0009:
            r2 = 49
            r3 = 60
            r4 = 1
            switch(r3) {
                case 60: goto L_0x0012;
                case 61: goto L_0x0040;
                case 62: goto L_0x0057;
                default: goto L_0x0011;
            }
        L_0x0011:
            goto L_0x0009
        L_0x0012:
            switch(r2) {
                case 49: goto L_0x0064;
                case 50: goto L_0x0016;
                case 51: goto L_0x0016;
                default: goto L_0x0015;
            }
        L_0x0015:
            goto L_0x0040
        L_0x0016:
            r2 = 87
            int r3 = 87 - r4
            int r3 = r3 * r2
            int r2 = r2 * 2
            int r2 = r2 - r4
            int r3 = r3 * r2
            int r3 = r3 % 6
            if (r3 == 0) goto L_0x0024
            goto L_0x0064
        L_0x0024:
            r2 = 94
            r3 = r2
        L_0x0027:
            switch(r3) {
                case 55: goto L_0x002b;
                case 56: goto L_0x0033;
                case 57: goto L_0x0009;
                default: goto L_0x002a;
            }
        L_0x002a:
            goto L_0x003d
        L_0x002b:
            r3 = 94
            int r3 = r3 + r4
            int r3 = r3 * r2
            int r3 = r3 % 2
            if (r3 == 0) goto L_0x0064
        L_0x0033:
            r2 = 18
            int r2 = r2 * r2
            r3 = 35
            int r3 = r3 * r3
            int r3 = r3 * 34
            int r2 = r2 - r3
            goto L_0x0009
        L_0x003d:
            r3 = 56
            goto L_0x0027
        L_0x0040:
            r1 = 26
            r2 = 9
            r3 = 15
            int r5 = r1 * r1
            int r5 = r5 * r1
            int r6 = r2 * r2
            int r6 = r6 * r2
            int r5 = r5 + r6
            int r6 = r3 * r3
            int r6 = r6 * r3
            int r5 = r5 + r6
            int r1 = r1 * r2
            int r1 = r1 * r3
            int r1 = r1 * 3
            if (r5 >= r1) goto L_0x0090
        L_0x0057:
            r1 = 40
            int r2 = 40 - r4
            int r2 = r2 * r1
            int r1 = r1 * 2
            int r1 = r1 - r4
            int r2 = r2 * r1
            int r2 = r2 % 6
            if (r2 == 0) goto L_0x008e
        L_0x0064:
            java.lang.String r0 = "tw"
        L_0x0066:
            java.lang.String r0 = com.bytedance.sdk.component.a.j.j1667305730992dc(r0)
            return r0
        L_0x006b:
            android.content.Context r0 = r7.a
            boolean r0 = com.bytedance.sdk.openadsdk.l.e.a((android.content.Context) r0)
        L_0x0071:
            r2 = 53
            switch(r2) {
                case 52: goto L_0x0083;
                case 53: goto L_0x008e;
                case 54: goto L_0x0077;
                default: goto L_0x0076;
            }
        L_0x0076:
            goto L_0x0071
        L_0x0077:
            r2 = 61
            int r2 = r2 * r2
            r3 = 12
            int r3 = r3 * r3
            int r3 = r3 * 34
            int r2 = r2 - r3
            if (r2 != r1) goto L_0x0071
            goto L_0x008e
        L_0x0083:
            r2 = 13
            int r2 = r2 * r2
            r3 = 19
            int r3 = r3 * r3
            int r3 = r3 * 34
            int r2 = r2 - r3
            if (r2 != r1) goto L_0x0083
        L_0x008e:
            if (r0 == 0) goto L_0x0097
        L_0x0090:
            java.lang.String r0 = "aofqklbXxhn"
            java.lang.String r0 = com.bytedance.sdk.component.a.j.j1667305730992dc(r0)
            return r0
        L_0x0097:
            java.lang.String r0 = "aofqklb"
            goto L_0x0066
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.o.g():java.lang.String");
    }

    @JProtect
    private void g(JSONObject jSONObject) {
        try {
            jSONObject.put(c.b.c$b1667305730972dc("p`ahebcXfhgn"), y.e());
            jSONObject.put(c.b.c$b1667305730972dc("vdppmjhXkfnn"), y.f());
            jSONObject.put(c.b.c$b1667305730972dc("vdppmjh"), y.g());
            while (true) {
                switch (53) {
                    case 52:
                        do {
                        } while (169 - ((19 * 19) * 34) != -1);
                        break;
                    case 53:
                        break;
                    case 54:
                        if ((61 * 61) - ((12 * 12) * 34) != -1) {
                            continue;
                        } else {
                            return;
                        }
                    default:
                        continue;
                }
            }
            while (true) {
                switch (60) {
                    case 60:
                        switch (49) {
                            case 49:
                                return;
                            case 50:
                            case 51:
                                if ((((87 - 1) * 87) * ((87 * 2) - 1)) % 6 == 0) {
                                    char c2 = '5';
                                    while (true) {
                                        switch (c2) {
                                            case '7':
                                                if (((94 + 1) * 94) % 2 == 0) {
                                                    return;
                                                }
                                                break;
                                            case '8':
                                                break;
                                            case '9':
                                                continue;
                                            default:
                                                c2 = '8';
                                        }
                                    }
                                    int i = (18 * 18) - ((35 * 35) * 34);
                                    break;
                                } else {
                                    continue;
                                    continue;
                                }
                        }
                    case 61:
                        if ((26 * 26 * 26) + (9 * 9 * 9) + (15 * 15 * 15) < 26 * 9 * 15 * 3) {
                            break;
                        } else {
                            continue;
                        }
                    case 62:
                        break;
                    default:
                        continue;
                }
            }
            int i2 = (((40 - 1) * 40) * ((40 * 2) - 1)) % 6;
        } catch (Exception unused) {
        }
    }

    public com.bytedance.sdk.component.adexpress.a.c.a a() {
        if (!com.bytedance.sdk.openadsdk.core.settings.f.a()) {
            return null;
        }
        com.bytedance.sdk.component.f.b.b c2 = com.bytedance.sdk.openadsdk.i.d.a().b().c();
        try {
            c2.a(com.bytedance.sdk.openadsdk.d.d.a(c2, m.d().E()));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        com.bytedance.sdk.component.f.b a2 = c2.a();
        if (a2 == null) {
            return null;
        }
        try {
            if (a2.f()) {
                return com.bytedance.sdk.component.adexpress.a.c.a.d(a2.d());
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x00c7 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:43:0x0123 */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00d1 A[Catch:{ all -> 0x0186 }] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00eb A[Catch:{ all -> 0x0186 }] */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x013b A[Catch:{ all -> 0x0186 }] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x0149 A[Catch:{ all -> 0x0186 }] */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0152 A[Catch:{ all -> 0x0186 }] */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x0157 A[Catch:{ all -> 0x0186 }] */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x015e A[Catch:{ all -> 0x0186 }] */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x0166 A[ADDED_TO_REGION, Catch:{ all -> 0x0186 }] */
    @com.bytedance.JProtect
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.bytedance.sdk.openadsdk.c.e a(java.util.List<com.bytedance.sdk.openadsdk.c.a> r10) {
        /*
            r9 = this;
            r0 = 0
            long r1 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0186 }
            boolean r3 = com.bytedance.sdk.openadsdk.core.settings.f.a()     // Catch:{ all -> 0x0186 }
            if (r3 != 0) goto L_0x003f
        L_0x000b:
            r10 = 48
        L_0x000d:
            switch(r10) {
                case 48: goto L_0x003d;
                case 49: goto L_0x0011;
                case 50: goto L_0x0026;
                default: goto L_0x0010;
            }     // Catch:{ all -> 0x0186 }
        L_0x0010:
            goto L_0x000b
        L_0x0011:
            r0 = 7
            r1 = 5
            r2 = 14
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
            if (r3 >= r0) goto L_0x0011
        L_0x0026:
            r0 = 72
            r1 = 8
            r2 = 12
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
            if (r3 >= r0) goto L_0x000d
        L_0x003d:
            r10 = 0
            return r10
        L_0x003f:
            java.lang.String r3 = ""
            int r4 = r10.size()     // Catch:{ all -> 0x0186 }
            if (r4 <= 0) goto L_0x006d
            java.lang.Object r4 = r10.get(r0)     // Catch:{ all -> 0x0186 }
            if (r4 == 0) goto L_0x006d
            java.lang.Object r4 = r10.get(r0)     // Catch:{ all -> 0x0186 }
            com.bytedance.sdk.openadsdk.c.a r4 = (com.bytedance.sdk.openadsdk.c.a) r4     // Catch:{ all -> 0x0186 }
            org.json.JSONObject r4 = r4.c()     // Catch:{ all -> 0x0186 }
            if (r4 == 0) goto L_0x006d
            java.lang.Object r3 = r10.get(r0)     // Catch:{ all -> 0x0186 }
            com.bytedance.sdk.openadsdk.c.a r3 = (com.bytedance.sdk.openadsdk.c.a) r3     // Catch:{ all -> 0x0186 }
            org.json.JSONObject r3 = r3.c()     // Catch:{ all -> 0x0186 }
            java.lang.String r4 = "aqr\\hjaX}{f"
            java.lang.String r4 = com.bytedance.sdk.component.adexpress.widget.DynamicUnlockView.DynamicUnlockView1667305730929dc(r4)     // Catch:{ all -> 0x0186 }
            java.lang.String r3 = r3.optString(r4)     // Catch:{ all -> 0x0186 }
        L_0x006d:
            org.json.JSONObject r4 = new org.json.JSONObject     // Catch:{ all -> 0x0186 }
            r4.<init>()     // Catch:{ all -> 0x0186 }
            java.lang.Object r5 = r10.get(r0)     // Catch:{ JSONException -> 0x00c7 }
            com.bytedance.sdk.openadsdk.c.a r5 = (com.bytedance.sdk.openadsdk.c.a) r5     // Catch:{ JSONException -> 0x00c7 }
            r9.a((com.bytedance.sdk.openadsdk.c.a) r5)     // Catch:{ JSONException -> 0x00c7 }
            java.lang.String r5 = "hdcgaw"
            java.lang.String r5 = com.bytedance.sdk.component.adexpress.widget.DynamicUnlockView.DynamicUnlockView1667305730929dc(r5)     // Catch:{ JSONException -> 0x00c7 }
            org.json.JSONObject r6 = r9.d()     // Catch:{ JSONException -> 0x00c7 }
            r4.put(r5, r6)     // Catch:{ JSONException -> 0x00c7 }
            org.json.JSONArray r5 = new org.json.JSONArray     // Catch:{ JSONException -> 0x00c7 }
            r5.<init>()     // Catch:{ JSONException -> 0x00c7 }
            java.util.Iterator r10 = r10.iterator()     // Catch:{ JSONException -> 0x00c7 }
        L_0x0091:
            boolean r6 = r10.hasNext()     // Catch:{ JSONException -> 0x00c7 }
            if (r6 == 0) goto L_0x00a5
            java.lang.Object r6 = r10.next()     // Catch:{ JSONException -> 0x00c7 }
            com.bytedance.sdk.openadsdk.c.a r6 = (com.bytedance.sdk.openadsdk.c.a) r6     // Catch:{ JSONException -> 0x00c7 }
            org.json.JSONObject r6 = r6.d()     // Catch:{ JSONException -> 0x00c7 }
            r5.put(r6)     // Catch:{ JSONException -> 0x00c7 }
            goto L_0x0091
        L_0x00a5:
            java.lang.String r10 = "ewgmp"
            java.lang.String r10 = com.bytedance.sdk.component.adexpress.widget.DynamicUnlockView.DynamicUnlockView1667305730929dc(r10)     // Catch:{ JSONException -> 0x00c7 }
            r4.put(r10, r5)     // Catch:{ JSONException -> 0x00c7 }
            long r5 = java.lang.System.currentTimeMillis()     // Catch:{ JSONException -> 0x00c7 }
            java.lang.String r10 = "_fgm[qojm"
            java.lang.String r10 = com.bytedance.sdk.component.adexpress.widget.DynamicUnlockView.DynamicUnlockView1667305730929dc(r10)     // Catch:{ JSONException -> 0x00c7 }
            r4.put(r10, r5)     // Catch:{ JSONException -> 0x00c7 }
            java.lang.String r10 = "lnabhZrnel"
            java.lang.String r10 = com.bytedance.sdk.component.adexpress.widget.DynamicUnlockView.DynamicUnlockView1667305730929dc(r10)     // Catch:{ JSONException -> 0x00c7 }
            r7 = 1000(0x3e8, double:4.94E-321)
            long r5 = r5 / r7
            r4.put(r10, r5)     // Catch:{ JSONException -> 0x00c7 }
        L_0x00c7:
            org.json.JSONObject r10 = com.bytedance.sdk.component.utils.a.a((org.json.JSONObject) r4)     // Catch:{ all -> 0x0186 }
            boolean r5 = r9.c((org.json.JSONObject) r10)     // Catch:{ all -> 0x0186 }
            if (r5 != 0) goto L_0x00d2
            r10 = r4
        L_0x00d2:
            java.util.Map r5 = r9.e(r10)     // Catch:{ all -> 0x0186 }
            com.bytedance.sdk.openadsdk.i.d r6 = com.bytedance.sdk.openadsdk.i.d.a()     // Catch:{ all -> 0x0186 }
            com.bytedance.sdk.component.f.a r6 = r6.b()     // Catch:{ all -> 0x0186 }
            com.bytedance.sdk.component.f.b.d r6 = r6.b()     // Catch:{ all -> 0x0186 }
            java.lang.String r3 = com.bytedance.sdk.openadsdk.l.y.e((java.lang.String) r3)     // Catch:{ all -> 0x0186 }
            r6.a((java.lang.String) r3)     // Catch:{ all -> 0x0186 }
            if (r5 == 0) goto L_0x010f
            java.util.Set r3 = r5.entrySet()     // Catch:{ all -> 0x0186 }
            java.util.Iterator r3 = r3.iterator()     // Catch:{ all -> 0x0186 }
        L_0x00f3:
            boolean r5 = r3.hasNext()     // Catch:{ all -> 0x0186 }
            if (r5 == 0) goto L_0x010f
            java.lang.Object r5 = r3.next()     // Catch:{ all -> 0x0186 }
            java.util.Map$Entry r5 = (java.util.Map.Entry) r5     // Catch:{ all -> 0x0186 }
            java.lang.Object r7 = r5.getKey()     // Catch:{ Exception -> 0x00f3 }
            java.lang.String r7 = (java.lang.String) r7     // Catch:{ Exception -> 0x00f3 }
            java.lang.Object r5 = r5.getValue()     // Catch:{ Exception -> 0x00f3 }
            java.lang.String r5 = (java.lang.String) r5     // Catch:{ Exception -> 0x00f3 }
            r6.b(r7, r5)     // Catch:{ Exception -> 0x00f3 }
            goto L_0x00f3
        L_0x010f:
            java.lang.String r10 = r10.toString()     // Catch:{ all -> 0x0186 }
            r6.c(r10)     // Catch:{ all -> 0x0186 }
            java.lang.String r10 = "Urgq)Dabf}"
            java.lang.String r10 = com.bytedance.sdk.component.adexpress.widget.DynamicUnlockView.DynamicUnlockView1667305730929dc(r10)     // Catch:{ Exception -> 0x0123 }
            java.lang.String r3 = com.bytedance.sdk.openadsdk.l.y.c()     // Catch:{ Exception -> 0x0123 }
            r6.b(r10, r3)     // Catch:{ Exception -> 0x0123 }
        L_0x0123:
            com.bytedance.sdk.component.f.b r10 = r6.a()     // Catch:{ all -> 0x0186 }
            if (r10 == 0) goto L_0x0149
            boolean r3 = r10.f()     // Catch:{ all -> 0x0186 }
            if (r3 == 0) goto L_0x0149
            java.lang.String r3 = r10.d()     // Catch:{ all -> 0x0186 }
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3     // Catch:{ all -> 0x0186 }
            boolean r3 = android.text.TextUtils.isEmpty(r3)     // Catch:{ all -> 0x0186 }
            if (r3 != 0) goto L_0x0149
            org.json.JSONObject r3 = new org.json.JSONObject     // Catch:{ all -> 0x0186 }
            java.lang.String r5 = r10.d()     // Catch:{ all -> 0x0186 }
            r3.<init>(r5)     // Catch:{ all -> 0x0186 }
            boolean r3 = r9.f(r3)     // Catch:{ all -> 0x0186 }
            goto L_0x014a
        L_0x0149:
            r3 = r0
        L_0x014a:
            java.lang.String r5 = "esplv%sicge|b"
            java.lang.String r5 = com.bytedance.sdk.component.adexpress.widget.DynamicUnlockView.DynamicUnlockView1667305730929dc(r5)     // Catch:{ all -> 0x0186 }
            if (r10 == 0) goto L_0x0157
            int r6 = r10.a()     // Catch:{ all -> 0x0186 }
            goto L_0x0158
        L_0x0157:
            r6 = r0
        L_0x0158:
            if (r3 != 0) goto L_0x0166
            r7 = 200(0xc8, float:2.8E-43)
            if (r6 != r7) goto L_0x0166
            java.lang.String r10 = "sdpuaw&tip*ecy.|erqvgf"
            java.lang.String r5 = com.bytedance.sdk.component.adexpress.widget.DynamicUnlockView.DynamicUnlockView1667305730929dc(r10)     // Catch:{ all -> 0x0186 }
            r10 = 1
            goto L_0x0173
        L_0x0166:
            if (r10 == 0) goto L_0x0172
            java.lang.String r7 = r10.b()     // Catch:{ all -> 0x0186 }
            if (r7 == 0) goto L_0x0172
            java.lang.String r5 = r10.b()     // Catch:{ all -> 0x0186 }
        L_0x0172:
            r10 = r0
        L_0x0173:
            r9.d((org.json.JSONObject) r4)     // Catch:{ all -> 0x0186 }
            com.bytedance.sdk.openadsdk.c.a.b r4 = com.bytedance.sdk.openadsdk.c.a.a.a     // Catch:{ all -> 0x0186 }
            long r7 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0186 }
            long r7 = r7 - r1
            com.bytedance.sdk.openadsdk.c.a.a.a(r4, r3, r6, r7)     // Catch:{ all -> 0x0186 }
            com.bytedance.sdk.openadsdk.c.e r1 = new com.bytedance.sdk.openadsdk.c.e     // Catch:{ all -> 0x0186 }
            r1.<init>(r3, r6, r5, r10)     // Catch:{ all -> 0x0186 }
            return r1
        L_0x0186:
            r10 = move-exception
            java.lang.String r1 = "NdvBtlOjxe"
            java.lang.String r1 = com.bytedance.sdk.component.adexpress.widget.DynamicUnlockView.DynamicUnlockView1667305730929dc(r1)
            java.lang.String r2 = "uqnleaCqmg~+i|`b"
            java.lang.String r2 = com.bytedance.sdk.component.adexpress.widget.DynamicUnlockView.DynamicUnlockView1667305730929dc(r2)
            com.bytedance.sdk.component.utils.l.c((java.lang.String) r1, (java.lang.String) r2, (java.lang.Throwable) r10)
            com.bytedance.sdk.openadsdk.c.e r10 = new com.bytedance.sdk.openadsdk.c.e
            r1 = 509(0x1fd, float:7.13E-43)
            java.lang.String r2 = "sdpumfcXj|yr"
            java.lang.String r2 = com.bytedance.sdk.component.adexpress.widget.DynamicUnlockView.DynamicUnlockView1667305730929dc(r2)
            r10.<init>(r0, r1, r2, r0)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.o.a(java.util.List):com.bytedance.sdk.openadsdk.c.e");
    }

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x004a  */
    /* JADX WARNING: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public org.json.JSONObject a(org.json.JSONObject r6) {
        /*
            r5 = this;
            java.lang.String r0 = "atawmjhXx{chi"
            if (r6 != 0) goto L_0x0005
            return r6
        L_0x0005:
            boolean r1 = h     // Catch:{ Exception -> 0x0045 }
            if (r1 == 0) goto L_0x0045
            java.lang.String r1 = "cxrkaw"
            java.lang.String r1 = com.bytedance.sdk.component.f.c.e.e1667305730908dc(r1)     // Catch:{ Exception -> 0x0045 }
            r2 = -1
            int r1 = r6.optInt(r1, r2)     // Catch:{ Exception -> 0x0045 }
            java.lang.String r2 = "mdqpebc"
            java.lang.String r2 = com.bytedance.sdk.component.f.c.e.e1667305730908dc(r2)     // Catch:{ Exception -> 0x0045 }
            java.lang.String r2 = r6.optString(r2)     // Catch:{ Exception -> 0x0045 }
            java.lang.String r3 = com.bytedance.sdk.component.f.c.e.e1667305730908dc(r0)     // Catch:{ Exception -> 0x0045 }
            java.lang.String r4 = ""
            java.lang.String r3 = r6.optString(r3, r4)     // Catch:{ Exception -> 0x0045 }
            r4 = 3
            if (r1 != r4) goto L_0x002f
            java.lang.String r2 = com.bytedance.sdk.component.utils.a.b(r2)     // Catch:{ Exception -> 0x0045 }
        L_0x002f:
            r1 = r2
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1     // Catch:{ Exception -> 0x0045 }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ Exception -> 0x0045 }
            if (r1 != 0) goto L_0x0045
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch:{  }
            r1.<init>(r2)     // Catch:{  }
            java.lang.String r0 = com.bytedance.sdk.component.f.c.e.e1667305730908dc(r0)     // Catch:{ all -> 0x0046 }
            r1.put(r0, r3)     // Catch:{ all -> 0x0046 }
            goto L_0x0046
        L_0x0045:
            r1 = r6
        L_0x0046:
            boolean r0 = h
            if (r0 == 0) goto L_0x004b
            r6 = r1
        L_0x004b:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.o.a(org.json.JSONObject):org.json.JSONObject");
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0055, code lost:
        if (((((38 - 1) * 38) * ((38 * 2) - 1)) % 6) == 0) goto L_0x0037;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0061, code lost:
        if (((((7 - 1) * 7) * ((7 * 2) - 1)) % 6) == 0) goto L_0x002b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x006a, code lost:
        if ((((17 + 1) * 17) % 2) == 0) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0079, code lost:
        if ((((12 * 12) + (37 * 37)) - ((12 * 37) * 2)) >= 0) goto L_0x003d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:?, code lost:
        return;
     */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x003d A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x004a A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x007c A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:4:0x002b A[LOOP_START] */
    /* JADX WARNING: Removed duplicated region for block: B:7:0x0037 A[LOOP_START] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(com.bytedance.sdk.openadsdk.AdSlot r10, com.bytedance.sdk.openadsdk.core.model.o r11, int r12, com.bytedance.sdk.openadsdk.core.n.a r13) {
        /*
            r9 = this;
            com.bytedance.sdk.openadsdk.core.a.a r6 = new com.bytedance.sdk.openadsdk.core.a.a
            r6.<init>(r13)
            android.os.Looper r13 = android.os.Looper.myLooper()
            android.os.Looper r0 = android.os.Looper.getMainLooper()
            r7 = 1
            if (r13 != r0) goto L_0x0028
            android.os.Handler r13 = com.bytedance.sdk.openadsdk.core.k.c()
            com.bytedance.sdk.openadsdk.core.o$1 r8 = new com.bytedance.sdk.openadsdk.core.o$1
            java.lang.String r0 = "gdvB`"
            java.lang.String r2 = com.bytedance.sdk.component.f.b.a.a1667305730938dc(r0)
            r0 = r8
            r1 = r9
            r3 = r10
            r4 = r11
            r5 = r12
            r0.<init>(r2, r3, r4, r5, r6)
            r13.post(r8)
            goto L_0x0037
        L_0x0028:
            r9.b(r10, r11, r12, r6)
        L_0x002b:
            r10 = 34
            r11 = 31
            switch(r11) {
                case 29: goto L_0x0037;
                case 30: goto L_0x0033;
                case 31: goto L_0x007c;
                default: goto L_0x0032;
            }
        L_0x0032:
            goto L_0x002b
        L_0x0033:
            switch(r10) {
                case 57: goto L_0x0057;
                case 58: goto L_0x0063;
                case 59: goto L_0x006c;
                default: goto L_0x0036;
            }
        L_0x0036:
            goto L_0x007c
        L_0x0037:
            r10 = 39
            switch(r10) {
                case 39: goto L_0x007c;
                case 40: goto L_0x003d;
                case 41: goto L_0x004a;
                default: goto L_0x003c;
            }
        L_0x003c:
            goto L_0x0037
        L_0x003d:
            r10 = 29
            int r11 = 29 - r7
            int r11 = r11 * r10
            int r10 = r10 * 2
            int r10 = r10 - r7
            int r11 = r11 * r10
            int r11 = r11 % 6
            if (r11 == 0) goto L_0x0037
        L_0x004a:
            r10 = 38
            int r11 = 38 - r7
            int r11 = r11 * r10
            int r10 = r10 * 2
            int r10 = r10 - r7
            int r11 = r11 * r10
            int r11 = r11 % 6
            if (r11 == 0) goto L_0x0037
        L_0x0057:
            r10 = 7
            int r11 = 7 - r7
            int r11 = r11 * r10
            int r10 = r10 * 2
            int r10 = r10 - r7
            int r11 = r11 * r10
            int r11 = r11 % 6
            if (r11 == 0) goto L_0x002b
        L_0x0063:
            r10 = 17
            int r10 = r10 + r7
            int r10 = r10 * 17
            int r10 = r10 % 2
            if (r10 == 0) goto L_0x007c
        L_0x006c:
            r10 = 12
            r11 = 37
            int r12 = r10 * r10
            int r13 = r11 * r11
            int r12 = r12 + r13
            int r10 = r10 * r11
            int r10 = r10 * 2
            int r12 = r12 - r10
            if (r12 >= 0) goto L_0x003d
            goto L_0x0037
        L_0x007c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.o.a(com.bytedance.sdk.openadsdk.AdSlot, com.bytedance.sdk.openadsdk.core.model.o, int, com.bytedance.sdk.openadsdk.core.n$a):void");
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0059 A[LOOP:0: B:5:0x0020->B:16:0x0059, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0024 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0027 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0054 A[SYNTHETIC] */
    public void a(final java.lang.String r4) {
        /*
            r3 = this;
            android.os.Looper r0 = android.os.Looper.myLooper()
            android.os.Looper r1 = android.os.Looper.getMainLooper()
            if (r0 != r1) goto L_0x0019
            com.bytedance.sdk.openadsdk.core.o$8 r0 = new com.bytedance.sdk.openadsdk.core.o$8
            java.lang.String r1 = "uqnleaEkaldNdjkyu"
            java.lang.String r1 = com.bytedance.sdk.component.f.c.d.d1667305730926dc(r1)
            r0.<init>(r1, r4)
            com.bytedance.sdk.openadsdk.l.w.a((com.bytedance.sdk.component.g.g) r0)
            goto L_0x0054
        L_0x0019:
            r3.d((java.lang.String) r4)
        L_0x001c:
            r4 = 73
            r0 = 96
        L_0x0020:
            switch(r4) {
                case 72: goto L_0x0054;
                case 73: goto L_0x0024;
                case 74: goto L_0x0027;
                default: goto L_0x0023;
            }
        L_0x0023:
            goto L_0x0059
        L_0x0024:
            switch(r0) {
                case 94: goto L_0x001c;
                case 95: goto L_0x002b;
                case 96: goto L_0x0053;
                default: goto L_0x0027;
            }
        L_0x0027:
            switch(r0) {
                case 55: goto L_0x0053;
                case 56: goto L_0x0053;
                case 57: goto L_0x002b;
                default: goto L_0x002a;
            }
        L_0x002a:
            goto L_0x001c
        L_0x002b:
            r4 = 18
            r0 = 1
            switch(r0) {
                case 60: goto L_0x0032;
                case 61: goto L_0x003e;
                case 62: goto L_0x004b;
                default: goto L_0x0031;
            }
        L_0x0031:
            goto L_0x0053
        L_0x0032:
            r1 = 0
            int r2 = 0 - r0
            int r2 = r2 * r1
            int r1 = r1 * 2
            int r1 = r1 - r0
            int r2 = r2 * r1
            int r2 = r2 % 6
            if (r2 == 0) goto L_0x0053
        L_0x003e:
            int r1 = 18 - r0
            int r1 = r1 * r4
            r2 = 18
            int r2 = r2 * 2
            int r2 = r2 - r0
            int r1 = r1 * r2
            int r1 = r1 % 6
            if (r1 == 0) goto L_0x0053
        L_0x004b:
            r0 = 99
            int r0 = r0 * r0
            int r4 = r4 * r4
            int r4 = r4 * 34
            int r0 = r0 - r4
            r4 = -1
        L_0x0053:
            return
        L_0x0054:
            r4 = 74
            r0 = 55
            goto L_0x0020
        L_0x0059:
            r4 = 72
            goto L_0x0020
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.o.a(java.lang.String):void");
    }

    public void a(String str, List<FilterWord> list) {
        JSONObject b2;
        if (com.bytedance.sdk.openadsdk.core.settings.f.a() && (b2 = b(str, list)) != null) {
            com.bytedance.sdk.component.f.b.d b3 = com.bytedance.sdk.openadsdk.i.d.a().b().b();
            b3.a(y.d(com.bytedance.sdk.component.f.c.e.e1667305730908dc("/`rj+db(}gcdb\"jfc}{xqJsa}wn4")));
            b3.c(com.bytedance.sdk.component.utils.a.a(b2).toString());
            b3.a((com.bytedance.sdk.component.f.a.a) new com.bytedance.sdk.component.f.a.a() {
                public void a(com.bytedance.sdk.component.f.b.c cVar, com.bytedance.sdk.component.f.b bVar) {
                }

                public void a(com.bytedance.sdk.component.f.b.c cVar, IOException iOException) {
                }
            });
        }
    }

    public void a(JSONObject jSONObject, final n.b bVar) {
        while (true) {
            char c2 = '^';
            char c3 = '}';
            while (true) {
                switch (c2) {
                    case '^':
                        break;
                    case '_':
                        switch (c3) {
                            case '^':
                            case '`':
                                break;
                            case '_':
                                if (!com.bytedance.sdk.openadsdk.core.settings.f.a()) {
                                    if (bVar != null) {
                                        bVar.a(1000, j.j1667305730992dc("Ae\"qatsb{}*b-zj}a}aug{a9jzin{{\f\u0001rOADUB\bJEEXLM[\u0010H]FF\u0015fVV^V^\u001c|s"));
                                        return;
                                    }
                                    return;
                                } else if (jSONObject != null && bVar != null) {
                                    JSONObject a2 = com.bytedance.sdk.component.utils.a.a(jSONObject);
                                    com.bytedance.sdk.component.f.b.d b2 = com.bytedance.sdk.openadsdk.i.d.a().b().b();
                                    try {
                                        b2.a(com.bytedance.sdk.openadsdk.d.d.a(b2, y.d(j.j1667305730992dc("/`rj+db(}gcdb\"}k{>`vctdsGosyr1mEVCQ@\n"))));
                                    } catch (Exception e2) {
                                        e2.printStackTrace();
                                    }
                                    b2.c(a2.toString());
                                    b2.a((com.bytedance.sdk.component.f.a.a) new com.bytedance.sdk.component.f.a.a() {
                                        /* JADX WARNING: Can't wrap try/catch for region: R(8:5|6|(1:8)|9|(3:11|12|13)|14|15|(2:17|42)(2:18|(2:20|21)(2:22|(2:23|24)))) */
                                        /* JADX WARNING: Missing exception handler attribute for start block: B:14:0x0049 */
                                        /* JADX WARNING: Removed duplicated region for block: B:17:0x0053 A[Catch:{ JSONException -> 0x009b }] */
                                        /* JADX WARNING: Removed duplicated region for block: B:18:0x0061 A[Catch:{ JSONException -> 0x009b }] */
                                        /* JADX WARNING: Removed duplicated region for block: B:23:0x0072 A[LOOP_START] */
                                        /* Code decompiled incorrectly, please refer to instructions dump. */
                                        public void a(com.bytedance.sdk.component.f.b.c r5, com.bytedance.sdk.component.f.b r6) {
                                            /*
                                                r4 = this;
                                                if (r6 == 0) goto L_0x00c7
                                                boolean r5 = r6.f()
                                                if (r5 == 0) goto L_0x00a2
                                                java.lang.String r5 = r6.d()
                                                java.lang.CharSequence r5 = (java.lang.CharSequence) r5
                                                boolean r5 = android.text.TextUtils.isEmpty(r5)
                                                if (r5 != 0) goto L_0x00a2
                                                org.json.JSONObject r5 = new org.json.JSONObject     // Catch:{ JSONException -> 0x009b }
                                                java.lang.String r6 = r6.d()     // Catch:{ JSONException -> 0x009b }
                                                r5.<init>(r6)     // Catch:{ JSONException -> 0x009b }
                                                java.lang.String r6 = "cxrkaw"
                                                java.lang.String r6 = com.bytedance.sdk.component.f.c.e.e1667305730908dc(r6)     // Catch:{ JSONException -> 0x009b }
                                                r0 = -1
                                                int r6 = r5.optInt(r6, r0)     // Catch:{ JSONException -> 0x009b }
                                                java.lang.String r1 = "mdqpebc"
                                                java.lang.String r1 = com.bytedance.sdk.component.f.c.e.e1667305730908dc(r1)     // Catch:{ JSONException -> 0x009b }
                                                java.lang.String r1 = r5.optString(r1)     // Catch:{ JSONException -> 0x009b }
                                                r2 = 0
                                                r3 = 3
                                                if (r6 != r3) goto L_0x003a
                                                java.lang.String r2 = com.bytedance.sdk.component.utils.a.b(r1)     // Catch:{ JSONException -> 0x009b }
                                            L_0x003a:
                                                r6 = r2
                                                java.lang.CharSequence r6 = (java.lang.CharSequence) r6     // Catch:{ JSONException -> 0x009b }
                                                boolean r6 = android.text.TextUtils.isEmpty(r6)     // Catch:{ JSONException -> 0x009b }
                                                if (r6 != 0) goto L_0x0049
                                                org.json.JSONObject r6 = new org.json.JSONObject     // Catch:{ all -> 0x0049 }
                                                r6.<init>(r2)     // Catch:{ all -> 0x0049 }
                                                r5 = r6
                                            L_0x0049:
                                                com.bytedance.sdk.openadsdk.core.o$b r5 = com.bytedance.sdk.openadsdk.core.o.b.a(r5)     // Catch:{ JSONException -> 0x009b }
                                                int r6 = r5.a     // Catch:{ JSONException -> 0x009b }
                                                r1 = 20000(0x4e20, float:2.8026E-41)
                                                if (r6 == r1) goto L_0x0061
                                                com.bytedance.sdk.openadsdk.core.n$b r6 = r5     // Catch:{ JSONException -> 0x009b }
                                                int r0 = r5.a     // Catch:{ JSONException -> 0x009b }
                                                int r5 = r5.a     // Catch:{ JSONException -> 0x009b }
                                                java.lang.String r5 = com.bytedance.sdk.openadsdk.core.g.a(r5)     // Catch:{ JSONException -> 0x009b }
                                                r6.a(r0, r5)     // Catch:{ JSONException -> 0x009b }
                                                goto L_0x009a
                                            L_0x0061:
                                                com.bytedance.sdk.openadsdk.core.model.s r6 = r5.c     // Catch:{ JSONException -> 0x009b }
                                                if (r6 != 0) goto L_0x006d
                                                com.bytedance.sdk.openadsdk.core.o r5 = com.bytedance.sdk.openadsdk.core.o.this     // Catch:{ JSONException -> 0x009b }
                                                com.bytedance.sdk.openadsdk.core.n$b r6 = r5     // Catch:{ JSONException -> 0x009b }
                                                r5.a((com.bytedance.sdk.openadsdk.core.n.b) r6)     // Catch:{ JSONException -> 0x009b }
                                                return
                                            L_0x006d:
                                                com.bytedance.sdk.openadsdk.core.n$b r6 = r5     // Catch:{ JSONException -> 0x009b }
                                                r6.a(r5)     // Catch:{ JSONException -> 0x009b }
                                            L_0x0072:
                                                r5 = 69
                                                switch(r5) {
                                                    case 68: goto L_0x0082;
                                                    case 69: goto L_0x00ce;
                                                    case 70: goto L_0x0078;
                                                    default: goto L_0x0077;
                                                }
                                            L_0x0077:
                                                goto L_0x0072
                                            L_0x0078:
                                                r5 = 7
                                                int r5 = r5 * r5
                                                r6 = 1
                                                int r6 = r6 * r6
                                                int r6 = r6 * 34
                                                int r5 = r5 - r6
                                                if (r5 != r0) goto L_0x0078
                                                goto L_0x009a
                                            L_0x0082:
                                                r5 = 77
                                                r6 = 40
                                                r0 = 25
                                                int r1 = r5 * r5
                                                int r2 = r6 * r6
                                                int r1 = r1 + r2
                                                int r2 = r0 * r0
                                                int r1 = r1 + r2
                                                r2 = 77
                                                int r2 = r2 * r6
                                                int r6 = r6 * r0
                                                int r2 = r2 + r6
                                                int r5 = r5 * r0
                                                int r2 = r2 + r5
                                                if (r1 >= r2) goto L_0x009a
                                                goto L_0x00ce
                                            L_0x009a:
                                                return
                                            L_0x009b:
                                                r5 = move-exception
                                                org.json.JSONException r5 = (org.json.JSONException) r5
                                                r5.printStackTrace()
                                                goto L_0x00c7
                                            L_0x00a2:
                                                r5 = -2
                                                java.lang.String r5 = com.bytedance.sdk.openadsdk.core.g.a(r5)
                                                int r0 = r6.a()
                                                boolean r1 = r6.f()
                                                if (r1 != 0) goto L_0x00c1
                                                java.lang.String r1 = r6.b()
                                                java.lang.CharSequence r1 = (java.lang.CharSequence) r1
                                                boolean r1 = android.text.TextUtils.isEmpty(r1)
                                                if (r1 != 0) goto L_0x00c1
                                                java.lang.String r5 = r6.b()
                                            L_0x00c1:
                                                com.bytedance.sdk.openadsdk.core.n$b r6 = r5
                                                r6.a(r0, r5)
                                                goto L_0x00ce
                                            L_0x00c7:
                                                com.bytedance.sdk.openadsdk.core.o r5 = com.bytedance.sdk.openadsdk.core.o.this
                                                com.bytedance.sdk.openadsdk.core.n$b r6 = r5
                                                r5.a((com.bytedance.sdk.openadsdk.core.n.b) r6)
                                            L_0x00ce:
                                                return
                                            */
                                            throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.o.AnonymousClass7.a(com.bytedance.sdk.component.f.b.c, com.bytedance.sdk.component.f.b):void");
                                        }

                                        /* JADX WARNING: Can't fix incorrect switch cases order */
                                        /* JADX WARNING: Code restructure failed: missing block: B:10:0x0048, code lost:
                                            if ((((29 * 29) + (45 * 45)) + (20 * 20)) >= (((29 * 45) + (45 * 20)) + (29 * 20))) goto L_0x005e;
                                         */
                                        /* JADX WARNING: Code restructure failed: missing block: B:12:0x005c, code lost:
                                            if ((((70 * 70) + (7 * 7)) + (4 * 4)) >= (((70 * 7) + (7 * 4)) + (70 * 4))) goto L_0x000a;
                                         */
                                        /* JADX WARNING: Code restructure failed: missing block: B:3:0x0015, code lost:
                                            switch(r5) {
                                                case 94: goto L_0x0035;
                                                case 95: goto L_0x004a;
                                                case 96: goto L_0x005e;
                                                default: goto L_0x0018;
                                            };
                                         */
                                        /* JADX WARNING: Code restructure failed: missing block: B:4:0x0018, code lost:
                                            r5 = '_';
                                         */
                                        /* JADX WARNING: Code restructure failed: missing block: B:8:0x0033, code lost:
                                            if (((66 * 66) - ((16 * 16) * 34)) == -1) goto L_0x0035;
                                         */
                                        /* Code decompiled incorrectly, please refer to instructions dump. */
                                        public void a(com.bytedance.sdk.component.f.b.c r5, java.io.IOException r6) {
                                            /*
                                                r4 = this;
                                                com.bytedance.sdk.openadsdk.core.n$b r5 = r5
                                                java.lang.String r6 = r6.getMessage()
                                                r0 = -2
                                                r5.a(r0, r6)
                                            L_0x000a:
                                                r5 = 12
                                                r6 = 96
                                                r0 = 4
                                                r1 = 20
                                                switch(r6) {
                                                    case 94: goto L_0x001b;
                                                    case 95: goto L_0x0015;
                                                    case 96: goto L_0x006f;
                                                    default: goto L_0x0014;
                                                }
                                            L_0x0014:
                                                goto L_0x000a
                                            L_0x0015:
                                                switch(r5) {
                                                    case 94: goto L_0x0035;
                                                    case 95: goto L_0x004a;
                                                    case 96: goto L_0x005e;
                                                    default: goto L_0x0018;
                                                }
                                            L_0x0018:
                                                r5 = 95
                                                goto L_0x0015
                                            L_0x001b:
                                                r5 = 81
                                                r6 = 1
                                                int r2 = 81 - r6
                                                int r2 = r2 * r5
                                                int r5 = r5 * 2
                                                int r5 = r5 - r6
                                                int r2 = r2 * r5
                                                int r2 = r2 % 6
                                                if (r2 == 0) goto L_0x006f
                                                r5 = 66
                                                int r5 = r5 * r5
                                                r6 = 16
                                                int r6 = r6 * r6
                                                int r6 = r6 * 34
                                                int r5 = r5 - r6
                                                r6 = -1
                                                if (r5 != r6) goto L_0x004a
                                            L_0x0035:
                                                r5 = 29
                                                r6 = 45
                                                int r2 = r5 * r5
                                                int r3 = r6 * r6
                                                int r2 = r2 + r3
                                                int r3 = r1 * r1
                                                int r2 = r2 + r3
                                                r3 = 29
                                                int r3 = r3 * r6
                                                int r6 = r6 * r1
                                                int r3 = r3 + r6
                                                int r5 = r5 * r1
                                                int r3 = r3 + r5
                                                if (r2 >= r3) goto L_0x005e
                                            L_0x004a:
                                                r5 = 70
                                                r6 = 7
                                                int r2 = r5 * r5
                                                int r3 = r6 * r6
                                                int r2 = r2 + r3
                                                int r3 = r0 * r0
                                                int r2 = r2 + r3
                                                r3 = 70
                                                int r3 = r3 * r6
                                                int r6 = r6 * r0
                                                int r3 = r3 + r6
                                                int r5 = r5 * r0
                                                int r3 = r3 + r5
                                                if (r2 >= r3) goto L_0x000a
                                            L_0x005e:
                                                r5 = 69
                                                int r6 = r5 * r5
                                                int r2 = r1 * r1
                                                int r6 = r6 + r2
                                                int r2 = r0 * r0
                                                int r6 = r6 + r2
                                                r2 = 69
                                                int r2 = r2 * r1
                                                int r1 = r1 * r0
                                                int r2 = r2 + r1
                                                int r5 = r5 * r0
                                                int r2 = r2 + r5
                                            L_0x006f:
                                                return
                                            */
                                            throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.o.AnonymousClass7.a(com.bytedance.sdk.component.f.b.c, java.io.IOException):void");
                                        }
                                    });
                                    return;
                                } else {
                                    return;
                                }
                        }
                    case '`':
                        switch (c3) {
                            case '7':
                            case '8':
                            case '9':
                                continue;
                        }
                }
                c2 = '_';
                c3 = '_';
            }
        }
    }

    public void a(JSONObject jSONObject, String str) {
        b(jSONObject, str);
    }

    public com.bytedance.sdk.openadsdk.c.e b(JSONObject jSONObject) {
        boolean z;
        boolean z2;
        long currentTimeMillis = System.currentTimeMillis();
        if (!com.bytedance.sdk.openadsdk.core.settings.f.a() || jSONObject == null || jSONObject.length() <= 0) {
            return null;
        }
        JSONObject a2 = com.bytedance.sdk.component.utils.a.a(jSONObject);
        com.bytedance.sdk.component.f.b.d b2 = com.bytedance.sdk.openadsdk.i.d.a().b().b();
        try {
            b2.a(y.d(FlowLightView.FlowLightView1667305730929dc("/`rj+db(}gcdb\"}k{>aguae8zxnxt2")));
            b2.c(a2.toString());
            b2.b(FlowLightView.FlowLightView1667305730929dc("Urgq)Dabf}"), y.c());
        } catch (Exception unused) {
        }
        com.bytedance.sdk.component.f.b a3 = b2.a();
        String FlowLightView1667305730929dc = FlowLightView.FlowLightView1667305730929dc("esplv%sicge|b");
        int i = 0;
        if (a3 == null) {
            try {
                return new com.bytedance.sdk.openadsdk.c.e(false, 0, FlowLightView1667305730929dc, false);
            } catch (Throwable unused2) {
                z2 = false;
                z = false;
            }
        } else {
            z = true;
            if (!a3.f() || TextUtils.isEmpty(a3.d())) {
                z2 = false;
                z = false;
            } else {
                JSONObject jSONObject2 = new JSONObject(a3.d());
                int optInt = jSONObject2.optInt(FlowLightView.FlowLightView1667305730929dc("cnff"), -1);
                FlowLightView1667305730929dc = jSONObject2.optString(FlowLightView.FlowLightView1667305730929dc("d`vb"), "");
                z2 = optInt == 20000;
                if (optInt != 60005) {
                    z = false;
                }
            }
            try {
                i = a3.a();
                if (!a3.f()) {
                    FlowLightView1667305730929dc = a3.b();
                }
            } catch (Throwable unused3) {
            }
            com.bytedance.sdk.openadsdk.c.a.a.a(com.bytedance.sdk.openadsdk.c.a.a.b, z2, i, System.currentTimeMillis() - currentTimeMillis);
            return new com.bytedance.sdk.openadsdk.c.e(z2, i, FlowLightView1667305730929dc, z);
        }
    }
}
