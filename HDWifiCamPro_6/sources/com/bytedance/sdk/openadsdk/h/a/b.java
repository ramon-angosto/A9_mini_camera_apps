package com.bytedance.sdk.openadsdk.h.a;

import android.text.TextUtils;
import com.bytedance.JProtect;
import com.bytedance.sdk.component.adexpress.widget.DynamicUnlockView;
import com.bytedance.sdk.component.f.b.a;
import com.bytedance.sdk.component.utils.o;
import com.bytedance.sdk.openadsdk.core.h;
import com.bytedance.sdk.openadsdk.core.m;
import com.bytedance.sdk.openadsdk.h.a.b;
import com.bytedance.sdk.openadsdk.l.y;
import kotlin.text.Typography;
import org.json.JSONObject;

/* compiled from: LogStatsBase */
public class b<T extends b> implements a {
    private String a;
    private String b;
    private String c;
    private String d = a.a1667305730938dc("4/:-4+0");
    private long e = (System.currentTimeMillis() / 1000);
    private int f = 0;
    private String g;
    private int h = 0;
    private String i;
    private String j;
    private String k;
    private String l;

    public static b<b> b() {
        return new b<>();
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0046, code lost:
        if (((((26 * 26) * 26) + ((9 * 9) * 9)) + ((15 * 15) * 15)) < (((26 * 9) * 15) * 3)) goto L_0x0065;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0056, code lost:
        if ((((70 * 70) + (44 * 44)) - ((70 * 44) * 2)) >= 0) goto L_0x0059;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x005d, code lost:
        switch(96) {
            case 95: goto L_0x0000;
            case 96: goto L_0x0061;
            case 97: goto L_0x0049;
            default: goto L_0x0060;
        };
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0061, code lost:
        switch(51) {
            case 49: goto L_0x0065;
            case 50: goto L_0x0073;
            case 51: goto L_0x007b;
            default: goto L_0x0064;
        };
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0065, code lost:
        r7 = 0 * 0;
        r4 = 80 * 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0071, code lost:
        if ((((80 * 80) + r7) + r7) >= ((r7 + r4) + r4)) goto L_0x0000;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0079, code lost:
        if ((((15 + 1) * 15) % 2) == 0) goto L_0x0059;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0000, code lost:
        continue;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0000, code lost:
        continue;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0013, code lost:
        if (((18 * 18) - ((35 * 35) * 34)) == -1) goto L_0x0015;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0017, code lost:
        switch(54) {
            case 52: goto L_0x001b;
            case 53: goto L_0x002a;
            case 54: goto L_0x0059;
            default: goto L_0x001a;
        };
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0028, code lost:
        if ((((69 * 69) + (22 * 22)) - ((69 * 22) * 2)) >= 0) goto L_0x0033;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x002a, code lost:
        r4 = (61 * 61) - ((12 * 12) * 34);
     */
    @com.bytedance.JProtect
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private org.json.JSONObject o() {
        /*
            r8 = this;
        L_0x0000:
            r0 = 1
            r1 = 15
            r2 = -1
            r3 = 61
            switch(r3) {
                case 60: goto L_0x000a;
                case 61: goto L_0x0015;
                case 62: goto L_0x0033;
                default: goto L_0x0009;
            }
        L_0x0009:
            goto L_0x0000
        L_0x000a:
            r4 = 18
            int r4 = r4 * r4
            r5 = 35
            int r5 = r5 * r5
            int r5 = r5 * 34
            int r4 = r4 - r5
            if (r4 != r2) goto L_0x0049
        L_0x0015:
            r4 = 54
            switch(r4) {
                case 52: goto L_0x001b;
                case 53: goto L_0x002a;
                case 54: goto L_0x0059;
                default: goto L_0x001a;
            }
        L_0x001a:
            goto L_0x0015
        L_0x001b:
            r4 = 69
            r5 = 22
            int r6 = r4 * r4
            int r7 = r5 * r5
            int r6 = r6 + r7
            int r4 = r4 * r5
            int r4 = r4 * 2
            int r6 = r6 - r4
            if (r6 >= 0) goto L_0x0033
        L_0x002a:
            int r4 = r3 * r3
            r5 = 12
            int r5 = r5 * r5
            int r5 = r5 * 34
            int r4 = r4 - r5
            goto L_0x0059
        L_0x0033:
            r4 = 26
            r5 = 9
            int r6 = r4 * r4
            int r6 = r6 * r4
            int r7 = r5 * r5
            int r7 = r7 * r5
            int r6 = r6 + r7
            int r7 = r1 * r1
            int r7 = r7 * r1
            int r6 = r6 + r7
            int r4 = r4 * r5
            int r4 = r4 * r1
            int r4 = r4 * 3
            if (r6 >= r4) goto L_0x0059
            goto L_0x0065
        L_0x0049:
            r4 = 70
            r5 = 44
            int r6 = r4 * r4
            int r7 = r5 * r5
            int r6 = r6 + r7
            int r4 = r4 * r5
            int r4 = r4 * 2
            int r6 = r6 - r4
            if (r6 >= 0) goto L_0x0059
            goto L_0x000a
        L_0x0059:
            r4 = 51
            r5 = 96
            switch(r5) {
                case 95: goto L_0x0000;
                case 96: goto L_0x0061;
                case 97: goto L_0x0049;
                default: goto L_0x0060;
            }
        L_0x0060:
            goto L_0x0059
        L_0x0061:
            switch(r4) {
                case 49: goto L_0x0065;
                case 50: goto L_0x0073;
                case 51: goto L_0x007b;
                default: goto L_0x0064;
            }
        L_0x0064:
            goto L_0x0049
        L_0x0065:
            r4 = 80
            r5 = 0
            int r6 = r4 * r4
            int r7 = r5 * r5
            int r6 = r6 + r7
            int r6 = r6 + r7
            int r4 = r4 * r5
            int r7 = r7 + r4
            int r7 = r7 + r4
            if (r6 >= r7) goto L_0x0000
        L_0x0073:
            r4 = 15
            int r4 = r4 + r0
            int r4 = r4 * r1
            int r4 = r4 % 2
            if (r4 == 0) goto L_0x0059
        L_0x007b:
            org.json.JSONObject r1 = new org.json.JSONObject
            r1.<init>()
            java.lang.String r2 = "or"
            java.lang.String r2 = com.bytedance.sdk.component.f.c.e.e1667305730908dc(r2)     // Catch:{ all -> 0x00ca }
            r1.put(r2, r0)     // Catch:{ all -> 0x00ca }
            java.lang.String r0 = "mnffh"
            java.lang.String r0 = com.bytedance.sdk.component.f.c.e.e1667305730908dc(r0)     // Catch:{ all -> 0x00ca }
            java.lang.String r2 = android.os.Build.MODEL     // Catch:{ all -> 0x00ca }
            r1.put(r0, r2)     // Catch:{ all -> 0x00ca }
            java.lang.String r0 = "vdlgkw"
            java.lang.String r0 = com.bytedance.sdk.component.f.c.e.e1667305730908dc(r0)     // Catch:{ all -> 0x00ca }
            java.lang.String r2 = android.os.Build.MANUFACTURER     // Catch:{ all -> 0x00ca }
            r1.put(r0, r2)     // Catch:{ all -> 0x00ca }
            java.lang.String r0 = "p`ahebcXfhgn"
            java.lang.String r0 = com.bytedance.sdk.component.f.c.e.e1667305730908dc(r0)     // Catch:{ all -> 0x00ca }
            java.lang.String r2 = com.bytedance.sdk.openadsdk.l.y.e()     // Catch:{ all -> 0x00ca }
            r1.put(r0, r2)     // Catch:{ all -> 0x00ca }
            java.lang.String r0 = "u`"
            java.lang.String r0 = com.bytedance.sdk.component.f.c.e.e1667305730908dc(r0)     // Catch:{ all -> 0x00ca }
            java.lang.String r2 = com.bytedance.sdk.openadsdk.l.y.c()     // Catch:{ all -> 0x00ca }
            r1.put(r0, r2)     // Catch:{ all -> 0x00ca }
            java.lang.String r0 = "g`kg"
            java.lang.String r0 = com.bytedance.sdk.component.f.c.e.e1667305730908dc(r0)     // Catch:{ all -> 0x00ca }
            com.com.bytedance.overseas.sdk.b.a r2 = com.com.bytedance.overseas.sdk.b.a.a()     // Catch:{ all -> 0x00ca }
            java.lang.String r2 = r2.b()     // Catch:{ all -> 0x00ca }
            r1.put(r0, r2)     // Catch:{ all -> 0x00ca }
        L_0x00ca:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.h.a.b.o():org.json.JSONObject");
    }

    private T p() {
        return this;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x004c, code lost:
        if ((((40 * 40) + (2 * 2)) - ((40 * 2) * 2)) >= 0) goto L_0x0095;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0054, code lost:
        switch(93) {
            case 92: goto L_0x0091;
            case 93: goto L_0x0058;
            case 94: goto L_0x0084;
            default: goto L_0x0057;
        };
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0058, code lost:
        switch(52) {
            case 52: goto L_0x0095;
            case 53: goto L_0x005c;
            case 54: goto L_0x0069;
            default: goto L_0x005b;
        };
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0067, code lost:
        if ((((85 * 85) + (32 * 32)) - ((85 * 32) * 2)) >= 0) goto L_0x0091;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0075, code lost:
        if ((((80 * 80) + r5) + r5) < ((r5 + r9) + r9)) goto L_0x0095;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0078, code lost:
        r4 = (((82 - 1) * 82) * ((82 * 2) - 1)) % 6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x008b, code lost:
        if (((85 * 85) - ((16 * 16) * 34)) != -1) goto L_0x0095;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x008d, code lost:
        r9 = r1;
        r0 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0091, code lost:
        r9 = r1;
        r0 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0095, code lost:
        r1.f = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x009b, code lost:
        return r1.p();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000c, code lost:
        r5 = ((29 * 29) + (45 * 45)) + (20 * 20);
        r6 = ((29 * 45) + (45 * 20)) + (29 * 20);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0021, code lost:
        r1 = r9;
        r3 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0027, code lost:
        switch(61) {
            case 59: goto L_0x002b;
            case 60: goto L_0x0042;
            case 61: goto L_0x004e;
            default: goto L_0x002a;
        };
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0040, code lost:
        if ((((49 * 49) + (34 * 34)) + (18 * 18)) >= (((49 * 34) + (34 * 18)) + (49 * 18))) goto L_0x0095;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public T a(int r9) {
        /*
            r8 = this;
            r0 = r9
            r9 = r8
        L_0x0002:
            r1 = 73
            r2 = 2
            switch(r1) {
                case 72: goto L_0x000c;
                case 73: goto L_0x0021;
                case 74: goto L_0x0009;
                default: goto L_0x0008;
            }
        L_0x0008:
            goto L_0x0002
        L_0x0009:
            r1 = r9
            r3 = r0
            goto L_0x0078
        L_0x000c:
            r1 = 29
            r3 = 45
            r4 = 20
            int r5 = r1 * r1
            int r6 = r3 * r3
            int r5 = r5 + r6
            int r6 = r4 * r4
            int r5 = r5 + r6
            r6 = 29
            int r6 = r6 * r3
            int r3 = r3 * r4
            int r6 = r6 + r3
            int r1 = r1 * r4
            int r6 = r6 + r1
        L_0x0021:
            r1 = r9
            r3 = r0
        L_0x0023:
            r9 = 61
            r0 = 34
            switch(r9) {
                case 59: goto L_0x002b;
                case 60: goto L_0x0042;
                case 61: goto L_0x004e;
                default: goto L_0x002a;
            }
        L_0x002a:
            goto L_0x0023
        L_0x002b:
            r9 = 49
            r4 = 18
            int r5 = r9 * r9
            int r6 = r0 * r0
            int r5 = r5 + r6
            int r6 = r4 * r4
            int r5 = r5 + r6
            r6 = 49
            int r6 = r6 * r0
            r7 = 34
            int r7 = r7 * r4
            int r6 = r6 + r7
            int r9 = r9 * r4
            int r6 = r6 + r9
            if (r5 >= r6) goto L_0x0095
        L_0x0042:
            r9 = 40
            int r4 = r9 * r9
            int r5 = r2 * r2
            int r4 = r4 + r5
            int r9 = r9 * r2
            int r9 = r9 * r2
            int r4 = r4 - r9
            if (r4 >= 0) goto L_0x0095
        L_0x004e:
            r9 = 93
            r4 = 52
            r5 = 85
            switch(r9) {
                case 92: goto L_0x0091;
                case 93: goto L_0x0058;
                case 94: goto L_0x0084;
                default: goto L_0x0057;
            }
        L_0x0057:
            goto L_0x004e
        L_0x0058:
            switch(r4) {
                case 52: goto L_0x0095;
                case 53: goto L_0x005c;
                case 54: goto L_0x0069;
                default: goto L_0x005b;
            }
        L_0x005b:
            goto L_0x0084
        L_0x005c:
            r9 = 32
            int r5 = r5 * r5
            int r0 = r9 * r9
            int r5 = r5 + r0
            r0 = 85
            int r0 = r0 * r9
            int r0 = r0 * r2
            int r5 = r5 - r0
            if (r5 >= 0) goto L_0x0091
        L_0x0069:
            r9 = 80
            r0 = 0
            int r4 = r9 * r9
            int r5 = r0 * r0
            int r4 = r4 + r5
            int r4 = r4 + r5
            int r9 = r9 * r0
            int r5 = r5 + r9
            int r5 = r5 + r9
            if (r4 >= r5) goto L_0x0078
            goto L_0x0095
        L_0x0078:
            r9 = 82
            r0 = 1
            int r4 = 82 - r0
            int r4 = r4 * r9
            int r9 = r9 * r2
            int r9 = r9 - r0
            int r4 = r4 * r9
            int r4 = r4 % 6
            goto L_0x0095
        L_0x0084:
            int r5 = r5 * r5
            r9 = 16
            int r9 = r9 * r9
            int r9 = r9 * r0
            int r5 = r5 - r9
            r9 = -1
            if (r5 != r9) goto L_0x0095
            r9 = r1
            r0 = r3
            goto L_0x000c
        L_0x0091:
            r9 = r1
            r0 = r3
            goto L_0x0002
        L_0x0095:
            r1.f = r3
            com.bytedance.sdk.openadsdk.h.a.b r9 = r1.p()
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.h.a.b.a(int):com.bytedance.sdk.openadsdk.h.a.b");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x004c, code lost:
        if ((((40 * 40) + (2 * 2)) - ((40 * 2) * 2)) >= 0) goto L_0x0095;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0054, code lost:
        switch(93) {
            case 92: goto L_0x0091;
            case 93: goto L_0x0058;
            case 94: goto L_0x0084;
            default: goto L_0x0057;
        };
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0058, code lost:
        switch(52) {
            case 52: goto L_0x0095;
            case 53: goto L_0x005c;
            case 54: goto L_0x0069;
            default: goto L_0x005b;
        };
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0067, code lost:
        if ((((85 * 85) + (32 * 32)) - ((85 * 32) * 2)) >= 0) goto L_0x0091;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0075, code lost:
        if ((((80 * 80) + r5) + r5) < ((r5 + r9) + r9)) goto L_0x0095;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0078, code lost:
        r4 = (((82 - 1) * 82) * ((82 * 2) - 1)) % 6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x008b, code lost:
        if (((85 * 85) - ((16 * 16) * 34)) != -1) goto L_0x0095;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x008d, code lost:
        r9 = r1;
        r0 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0091, code lost:
        r9 = r1;
        r0 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0095, code lost:
        r1.a = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x009b, code lost:
        return r1.p();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000c, code lost:
        r5 = ((29 * 29) + (45 * 45)) + (20 * 20);
        r6 = ((29 * 45) + (45 * 20)) + (29 * 20);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0021, code lost:
        r1 = r9;
        r3 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0027, code lost:
        switch(61) {
            case 59: goto L_0x002b;
            case 60: goto L_0x0042;
            case 61: goto L_0x004e;
            default: goto L_0x002a;
        };
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0040, code lost:
        if ((((49 * 49) + (34 * 34)) + (18 * 18)) >= (((49 * 34) + (34 * 18)) + (49 * 18))) goto L_0x0095;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public T a(java.lang.String r9) {
        /*
            r8 = this;
            r0 = r9
            r9 = r8
        L_0x0002:
            r1 = 73
            r2 = 2
            switch(r1) {
                case 72: goto L_0x000c;
                case 73: goto L_0x0021;
                case 74: goto L_0x0009;
                default: goto L_0x0008;
            }
        L_0x0008:
            goto L_0x0002
        L_0x0009:
            r1 = r9
            r3 = r0
            goto L_0x0078
        L_0x000c:
            r1 = 29
            r3 = 45
            r4 = 20
            int r5 = r1 * r1
            int r6 = r3 * r3
            int r5 = r5 + r6
            int r6 = r4 * r4
            int r5 = r5 + r6
            r6 = 29
            int r6 = r6 * r3
            int r3 = r3 * r4
            int r6 = r6 + r3
            int r1 = r1 * r4
            int r6 = r6 + r1
        L_0x0021:
            r1 = r9
            r3 = r0
        L_0x0023:
            r9 = 61
            r0 = 34
            switch(r9) {
                case 59: goto L_0x002b;
                case 60: goto L_0x0042;
                case 61: goto L_0x004e;
                default: goto L_0x002a;
            }
        L_0x002a:
            goto L_0x0023
        L_0x002b:
            r9 = 49
            r4 = 18
            int r5 = r9 * r9
            int r6 = r0 * r0
            int r5 = r5 + r6
            int r6 = r4 * r4
            int r5 = r5 + r6
            r6 = 49
            int r6 = r6 * r0
            r7 = 34
            int r7 = r7 * r4
            int r6 = r6 + r7
            int r9 = r9 * r4
            int r6 = r6 + r9
            if (r5 >= r6) goto L_0x0095
        L_0x0042:
            r9 = 40
            int r4 = r9 * r9
            int r5 = r2 * r2
            int r4 = r4 + r5
            int r9 = r9 * r2
            int r9 = r9 * r2
            int r4 = r4 - r9
            if (r4 >= 0) goto L_0x0095
        L_0x004e:
            r9 = 93
            r4 = 52
            r5 = 85
            switch(r9) {
                case 92: goto L_0x0091;
                case 93: goto L_0x0058;
                case 94: goto L_0x0084;
                default: goto L_0x0057;
            }
        L_0x0057:
            goto L_0x004e
        L_0x0058:
            switch(r4) {
                case 52: goto L_0x0095;
                case 53: goto L_0x005c;
                case 54: goto L_0x0069;
                default: goto L_0x005b;
            }
        L_0x005b:
            goto L_0x0084
        L_0x005c:
            r9 = 32
            int r5 = r5 * r5
            int r0 = r9 * r9
            int r5 = r5 + r0
            r0 = 85
            int r0 = r0 * r9
            int r0 = r0 * r2
            int r5 = r5 - r0
            if (r5 >= 0) goto L_0x0091
        L_0x0069:
            r9 = 80
            r0 = 0
            int r4 = r9 * r9
            int r5 = r0 * r0
            int r4 = r4 + r5
            int r4 = r4 + r5
            int r9 = r9 * r0
            int r5 = r5 + r9
            int r5 = r5 + r9
            if (r4 >= r5) goto L_0x0078
            goto L_0x0095
        L_0x0078:
            r9 = 82
            r0 = 1
            int r4 = 82 - r0
            int r4 = r4 * r9
            int r9 = r9 * r2
            int r9 = r9 - r0
            int r4 = r4 * r9
            int r4 = r4 % 6
            goto L_0x0095
        L_0x0084:
            int r5 = r5 * r5
            r9 = 16
            int r9 = r9 * r9
            int r9 = r9 * r0
            int r5 = r5 - r9
            r9 = -1
            if (r5 != r9) goto L_0x0095
            r9 = r1
            r0 = r3
            goto L_0x000c
        L_0x0091:
            r9 = r1
            r0 = r3
            goto L_0x0002
        L_0x0095:
            r1.a = r3
            com.bytedance.sdk.openadsdk.h.a.b r9 = r1.p()
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.h.a.b.a(java.lang.String):com.bytedance.sdk.openadsdk.h.a.b");
    }

    @JProtect
    public JSONObject a() {
        while (true) {
            char c2 = Typography.greater;
            while (true) {
                switch (c2) {
                    case '>':
                    case '?':
                        c2 = '@';
                    case '@':
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put(DynamicUnlockView.DynamicUnlockView1667305730929dc("ae]p`nYqm{ybcc"), g());
                            jSONObject.put(DynamicUnlockView.DynamicUnlockView1667305730929dc("aqr\\r`ttafd"), y.g());
                            jSONObject.put(DynamicUnlockView.DynamicUnlockView1667305730929dc("thofwqgjx"), h());
                            jSONObject.put(DynamicUnlockView.DynamicUnlockView1667305730929dc("cnlm[qwm"), o.b(m.a()));
                            jSONObject.put(DynamicUnlockView.DynamicUnlockView1667305730929dc("aqrj`"), TextUtils.isEmpty(h.d().f()) ? "" : h.d().f());
                            jSONObject.put(DynamicUnlockView.DynamicUnlockView1667305730929dc("ddtjg`Ynfoe"), o());
                            if (!TextUtils.isEmpty(c())) {
                                jSONObject.put(com.bytedance.sdk.component.f.c.a.a1667305730924dc("txrf"), c());
                            }
                            jSONObject.put(DynamicUnlockView.DynamicUnlockView1667305730929dc("esplvZehll"), k());
                            if (!TextUtils.isEmpty(l())) {
                                jSONObject.put(DynamicUnlockView.DynamicUnlockView1667305730929dc("esplvZkto"), l());
                            }
                            if (!TextUtils.isEmpty(e())) {
                                jSONObject.put(DynamicUnlockView.DynamicUnlockView1667305730929dc("rhv"), e());
                            }
                            if (!TextUtils.isEmpty(f())) {
                                jSONObject.put(DynamicUnlockView.DynamicUnlockView1667305730929dc("csgbplpbW`n"), f());
                            }
                            if (i() > 0) {
                                jSONObject.put(DynamicUnlockView.DynamicUnlockView1667305730929dc("aevzt`"), i());
                            }
                            if (!TextUtils.isEmpty(j())) {
                                jSONObject.put(DynamicUnlockView.DynamicUnlockView1667305730929dc("rds\\ma"), j());
                            }
                            if (!TextUtils.isEmpty(m())) {
                                jSONObject.put(DynamicUnlockView.DynamicUnlockView1667305730929dc("eyvqe"), m());
                            }
                            if (!TextUtils.isEmpty(d())) {
                                jSONObject.put(DynamicUnlockView.DynamicUnlockView1667305730929dc("ewgmpZc|{k"), d());
                            }
                            if (!TextUtils.isEmpty(n())) {
                                jSONObject.put(DynamicUnlockView.DynamicUnlockView1667305730929dc("dtpbplii"), n());
                            }
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                        return jSONObject;
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x004c, code lost:
        if ((((40 * 40) + (2 * 2)) - ((40 * 2) * 2)) >= 0) goto L_0x0095;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0054, code lost:
        switch(93) {
            case 92: goto L_0x0091;
            case 93: goto L_0x0058;
            case 94: goto L_0x0084;
            default: goto L_0x0057;
        };
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0058, code lost:
        switch(52) {
            case 52: goto L_0x0095;
            case 53: goto L_0x005c;
            case 54: goto L_0x0069;
            default: goto L_0x005b;
        };
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0067, code lost:
        if ((((85 * 85) + (32 * 32)) - ((85 * 32) * 2)) >= 0) goto L_0x0091;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0075, code lost:
        if ((((80 * 80) + r5) + r5) < ((r5 + r9) + r9)) goto L_0x0095;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0078, code lost:
        r4 = (((82 - 1) * 82) * ((82 * 2) - 1)) % 6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x008b, code lost:
        if (((85 * 85) - ((16 * 16) * 34)) != -1) goto L_0x0095;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x008d, code lost:
        r9 = r1;
        r0 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0091, code lost:
        r9 = r1;
        r0 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0095, code lost:
        r1.h = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x009b, code lost:
        return r1.p();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000c, code lost:
        r5 = ((29 * 29) + (45 * 45)) + (20 * 20);
        r6 = ((29 * 45) + (45 * 20)) + (29 * 20);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0021, code lost:
        r1 = r9;
        r3 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0027, code lost:
        switch(61) {
            case 59: goto L_0x002b;
            case 60: goto L_0x0042;
            case 61: goto L_0x004e;
            default: goto L_0x002a;
        };
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0040, code lost:
        if ((((49 * 49) + (34 * 34)) + (18 * 18)) >= (((49 * 34) + (34 * 18)) + (49 * 18))) goto L_0x0095;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public T b(int r9) {
        /*
            r8 = this;
            r0 = r9
            r9 = r8
        L_0x0002:
            r1 = 73
            r2 = 2
            switch(r1) {
                case 72: goto L_0x000c;
                case 73: goto L_0x0021;
                case 74: goto L_0x0009;
                default: goto L_0x0008;
            }
        L_0x0008:
            goto L_0x0002
        L_0x0009:
            r1 = r9
            r3 = r0
            goto L_0x0078
        L_0x000c:
            r1 = 29
            r3 = 45
            r4 = 20
            int r5 = r1 * r1
            int r6 = r3 * r3
            int r5 = r5 + r6
            int r6 = r4 * r4
            int r5 = r5 + r6
            r6 = 29
            int r6 = r6 * r3
            int r3 = r3 * r4
            int r6 = r6 + r3
            int r1 = r1 * r4
            int r6 = r6 + r1
        L_0x0021:
            r1 = r9
            r3 = r0
        L_0x0023:
            r9 = 61
            r0 = 34
            switch(r9) {
                case 59: goto L_0x002b;
                case 60: goto L_0x0042;
                case 61: goto L_0x004e;
                default: goto L_0x002a;
            }
        L_0x002a:
            goto L_0x0023
        L_0x002b:
            r9 = 49
            r4 = 18
            int r5 = r9 * r9
            int r6 = r0 * r0
            int r5 = r5 + r6
            int r6 = r4 * r4
            int r5 = r5 + r6
            r6 = 49
            int r6 = r6 * r0
            r7 = 34
            int r7 = r7 * r4
            int r6 = r6 + r7
            int r9 = r9 * r4
            int r6 = r6 + r9
            if (r5 >= r6) goto L_0x0095
        L_0x0042:
            r9 = 40
            int r4 = r9 * r9
            int r5 = r2 * r2
            int r4 = r4 + r5
            int r9 = r9 * r2
            int r9 = r9 * r2
            int r4 = r4 - r9
            if (r4 >= 0) goto L_0x0095
        L_0x004e:
            r9 = 93
            r4 = 52
            r5 = 85
            switch(r9) {
                case 92: goto L_0x0091;
                case 93: goto L_0x0058;
                case 94: goto L_0x0084;
                default: goto L_0x0057;
            }
        L_0x0057:
            goto L_0x004e
        L_0x0058:
            switch(r4) {
                case 52: goto L_0x0095;
                case 53: goto L_0x005c;
                case 54: goto L_0x0069;
                default: goto L_0x005b;
            }
        L_0x005b:
            goto L_0x0084
        L_0x005c:
            r9 = 32
            int r5 = r5 * r5
            int r0 = r9 * r9
            int r5 = r5 + r0
            r0 = 85
            int r0 = r0 * r9
            int r0 = r0 * r2
            int r5 = r5 - r0
            if (r5 >= 0) goto L_0x0091
        L_0x0069:
            r9 = 80
            r0 = 0
            int r4 = r9 * r9
            int r5 = r0 * r0
            int r4 = r4 + r5
            int r4 = r4 + r5
            int r9 = r9 * r0
            int r5 = r5 + r9
            int r5 = r5 + r9
            if (r4 >= r5) goto L_0x0078
            goto L_0x0095
        L_0x0078:
            r9 = 82
            r0 = 1
            int r4 = 82 - r0
            int r4 = r4 * r9
            int r9 = r9 * r2
            int r9 = r9 - r0
            int r4 = r4 * r9
            int r4 = r4 % 6
            goto L_0x0095
        L_0x0084:
            int r5 = r5 * r5
            r9 = 16
            int r9 = r9 * r9
            int r9 = r9 * r0
            int r5 = r5 - r9
            r9 = -1
            if (r5 != r9) goto L_0x0095
            r9 = r1
            r0 = r3
            goto L_0x000c
        L_0x0091:
            r9 = r1
            r0 = r3
            goto L_0x0002
        L_0x0095:
            r1.h = r3
            com.bytedance.sdk.openadsdk.h.a.b r9 = r1.p()
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.h.a.b.b(int):com.bytedance.sdk.openadsdk.h.a.b");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x004c, code lost:
        if ((((40 * 40) + (2 * 2)) - ((40 * 2) * 2)) >= 0) goto L_0x0095;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0054, code lost:
        switch(93) {
            case 92: goto L_0x0091;
            case 93: goto L_0x0058;
            case 94: goto L_0x0084;
            default: goto L_0x0057;
        };
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0058, code lost:
        switch(52) {
            case 52: goto L_0x0095;
            case 53: goto L_0x005c;
            case 54: goto L_0x0069;
            default: goto L_0x005b;
        };
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0067, code lost:
        if ((((85 * 85) + (32 * 32)) - ((85 * 32) * 2)) >= 0) goto L_0x0091;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0075, code lost:
        if ((((80 * 80) + r5) + r5) < ((r5 + r9) + r9)) goto L_0x0095;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0078, code lost:
        r4 = (((82 - 1) * 82) * ((82 * 2) - 1)) % 6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x008b, code lost:
        if (((85 * 85) - ((16 * 16) * 34)) != -1) goto L_0x0095;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x008d, code lost:
        r9 = r1;
        r0 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0091, code lost:
        r9 = r1;
        r0 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0095, code lost:
        r1.k = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x009b, code lost:
        return r1.p();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000c, code lost:
        r5 = ((29 * 29) + (45 * 45)) + (20 * 20);
        r6 = ((29 * 45) + (45 * 20)) + (29 * 20);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0021, code lost:
        r1 = r9;
        r3 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0027, code lost:
        switch(61) {
            case 59: goto L_0x002b;
            case 60: goto L_0x0042;
            case 61: goto L_0x004e;
            default: goto L_0x002a;
        };
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0040, code lost:
        if ((((49 * 49) + (34 * 34)) + (18 * 18)) >= (((49 * 34) + (34 * 18)) + (49 * 18))) goto L_0x0095;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public T b(java.lang.String r9) {
        /*
            r8 = this;
            r0 = r9
            r9 = r8
        L_0x0002:
            r1 = 73
            r2 = 2
            switch(r1) {
                case 72: goto L_0x000c;
                case 73: goto L_0x0021;
                case 74: goto L_0x0009;
                default: goto L_0x0008;
            }
        L_0x0008:
            goto L_0x0002
        L_0x0009:
            r1 = r9
            r3 = r0
            goto L_0x0078
        L_0x000c:
            r1 = 29
            r3 = 45
            r4 = 20
            int r5 = r1 * r1
            int r6 = r3 * r3
            int r5 = r5 + r6
            int r6 = r4 * r4
            int r5 = r5 + r6
            r6 = 29
            int r6 = r6 * r3
            int r3 = r3 * r4
            int r6 = r6 + r3
            int r1 = r1 * r4
            int r6 = r6 + r1
        L_0x0021:
            r1 = r9
            r3 = r0
        L_0x0023:
            r9 = 61
            r0 = 34
            switch(r9) {
                case 59: goto L_0x002b;
                case 60: goto L_0x0042;
                case 61: goto L_0x004e;
                default: goto L_0x002a;
            }
        L_0x002a:
            goto L_0x0023
        L_0x002b:
            r9 = 49
            r4 = 18
            int r5 = r9 * r9
            int r6 = r0 * r0
            int r5 = r5 + r6
            int r6 = r4 * r4
            int r5 = r5 + r6
            r6 = 49
            int r6 = r6 * r0
            r7 = 34
            int r7 = r7 * r4
            int r6 = r6 + r7
            int r9 = r9 * r4
            int r6 = r6 + r9
            if (r5 >= r6) goto L_0x0095
        L_0x0042:
            r9 = 40
            int r4 = r9 * r9
            int r5 = r2 * r2
            int r4 = r4 + r5
            int r9 = r9 * r2
            int r9 = r9 * r2
            int r4 = r4 - r9
            if (r4 >= 0) goto L_0x0095
        L_0x004e:
            r9 = 93
            r4 = 52
            r5 = 85
            switch(r9) {
                case 92: goto L_0x0091;
                case 93: goto L_0x0058;
                case 94: goto L_0x0084;
                default: goto L_0x0057;
            }
        L_0x0057:
            goto L_0x004e
        L_0x0058:
            switch(r4) {
                case 52: goto L_0x0095;
                case 53: goto L_0x005c;
                case 54: goto L_0x0069;
                default: goto L_0x005b;
            }
        L_0x005b:
            goto L_0x0084
        L_0x005c:
            r9 = 32
            int r5 = r5 * r5
            int r0 = r9 * r9
            int r5 = r5 + r0
            r0 = 85
            int r0 = r0 * r9
            int r0 = r0 * r2
            int r5 = r5 - r0
            if (r5 >= 0) goto L_0x0091
        L_0x0069:
            r9 = 80
            r0 = 0
            int r4 = r9 * r9
            int r5 = r0 * r0
            int r4 = r4 + r5
            int r4 = r4 + r5
            int r9 = r9 * r0
            int r5 = r5 + r9
            int r5 = r5 + r9
            if (r4 >= r5) goto L_0x0078
            goto L_0x0095
        L_0x0078:
            r9 = 82
            r0 = 1
            int r4 = 82 - r0
            int r4 = r4 * r9
            int r9 = r9 * r2
            int r9 = r9 - r0
            int r4 = r4 * r9
            int r4 = r4 % 6
            goto L_0x0095
        L_0x0084:
            int r5 = r5 * r5
            r9 = 16
            int r9 = r9 * r9
            int r9 = r9 * r0
            int r5 = r5 - r9
            r9 = -1
            if (r5 != r9) goto L_0x0095
            r9 = r1
            r0 = r3
            goto L_0x000c
        L_0x0091:
            r9 = r1
            r0 = r3
            goto L_0x0002
        L_0x0095:
            r1.k = r3
            com.bytedance.sdk.openadsdk.h.a.b r9 = r1.p()
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.h.a.b.b(java.lang.String):com.bytedance.sdk.openadsdk.h.a.b");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x004c, code lost:
        if ((((40 * 40) + (2 * 2)) - ((40 * 2) * 2)) >= 0) goto L_0x0095;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0054, code lost:
        switch(93) {
            case 92: goto L_0x0091;
            case 93: goto L_0x0058;
            case 94: goto L_0x0084;
            default: goto L_0x0057;
        };
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0058, code lost:
        switch(52) {
            case 52: goto L_0x0095;
            case 53: goto L_0x005c;
            case 54: goto L_0x0069;
            default: goto L_0x005b;
        };
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0067, code lost:
        if ((((85 * 85) + (32 * 32)) - ((85 * 32) * 2)) >= 0) goto L_0x0091;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0075, code lost:
        if ((((80 * 80) + r5) + r5) < ((r5 + r9) + r9)) goto L_0x0095;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0078, code lost:
        r4 = (((82 - 1) * 82) * ((82 * 2) - 1)) % 6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x008b, code lost:
        if (((85 * 85) - ((16 * 16) * 34)) != -1) goto L_0x0095;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x008d, code lost:
        r9 = r1;
        r0 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0091, code lost:
        r9 = r1;
        r0 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0095, code lost:
        r1.b = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x009b, code lost:
        return r1.p();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000c, code lost:
        r5 = ((29 * 29) + (45 * 45)) + (20 * 20);
        r6 = ((29 * 45) + (45 * 20)) + (29 * 20);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0021, code lost:
        r1 = r9;
        r3 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0027, code lost:
        switch(61) {
            case 59: goto L_0x002b;
            case 60: goto L_0x0042;
            case 61: goto L_0x004e;
            default: goto L_0x002a;
        };
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0040, code lost:
        if ((((49 * 49) + (34 * 34)) + (18 * 18)) >= (((49 * 34) + (34 * 18)) + (49 * 18))) goto L_0x0095;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public T c(java.lang.String r9) {
        /*
            r8 = this;
            r0 = r9
            r9 = r8
        L_0x0002:
            r1 = 73
            r2 = 2
            switch(r1) {
                case 72: goto L_0x000c;
                case 73: goto L_0x0021;
                case 74: goto L_0x0009;
                default: goto L_0x0008;
            }
        L_0x0008:
            goto L_0x0002
        L_0x0009:
            r1 = r9
            r3 = r0
            goto L_0x0078
        L_0x000c:
            r1 = 29
            r3 = 45
            r4 = 20
            int r5 = r1 * r1
            int r6 = r3 * r3
            int r5 = r5 + r6
            int r6 = r4 * r4
            int r5 = r5 + r6
            r6 = 29
            int r6 = r6 * r3
            int r3 = r3 * r4
            int r6 = r6 + r3
            int r1 = r1 * r4
            int r6 = r6 + r1
        L_0x0021:
            r1 = r9
            r3 = r0
        L_0x0023:
            r9 = 61
            r0 = 34
            switch(r9) {
                case 59: goto L_0x002b;
                case 60: goto L_0x0042;
                case 61: goto L_0x004e;
                default: goto L_0x002a;
            }
        L_0x002a:
            goto L_0x0023
        L_0x002b:
            r9 = 49
            r4 = 18
            int r5 = r9 * r9
            int r6 = r0 * r0
            int r5 = r5 + r6
            int r6 = r4 * r4
            int r5 = r5 + r6
            r6 = 49
            int r6 = r6 * r0
            r7 = 34
            int r7 = r7 * r4
            int r6 = r6 + r7
            int r9 = r9 * r4
            int r6 = r6 + r9
            if (r5 >= r6) goto L_0x0095
        L_0x0042:
            r9 = 40
            int r4 = r9 * r9
            int r5 = r2 * r2
            int r4 = r4 + r5
            int r9 = r9 * r2
            int r9 = r9 * r2
            int r4 = r4 - r9
            if (r4 >= 0) goto L_0x0095
        L_0x004e:
            r9 = 93
            r4 = 52
            r5 = 85
            switch(r9) {
                case 92: goto L_0x0091;
                case 93: goto L_0x0058;
                case 94: goto L_0x0084;
                default: goto L_0x0057;
            }
        L_0x0057:
            goto L_0x004e
        L_0x0058:
            switch(r4) {
                case 52: goto L_0x0095;
                case 53: goto L_0x005c;
                case 54: goto L_0x0069;
                default: goto L_0x005b;
            }
        L_0x005b:
            goto L_0x0084
        L_0x005c:
            r9 = 32
            int r5 = r5 * r5
            int r0 = r9 * r9
            int r5 = r5 + r0
            r0 = 85
            int r0 = r0 * r9
            int r0 = r0 * r2
            int r5 = r5 - r0
            if (r5 >= 0) goto L_0x0091
        L_0x0069:
            r9 = 80
            r0 = 0
            int r4 = r9 * r9
            int r5 = r0 * r0
            int r4 = r4 + r5
            int r4 = r4 + r5
            int r9 = r9 * r0
            int r5 = r5 + r9
            int r5 = r5 + r9
            if (r4 >= r5) goto L_0x0078
            goto L_0x0095
        L_0x0078:
            r9 = 82
            r0 = 1
            int r4 = 82 - r0
            int r4 = r4 * r9
            int r9 = r9 * r2
            int r9 = r9 - r0
            int r4 = r4 * r9
            int r4 = r4 % 6
            goto L_0x0095
        L_0x0084:
            int r5 = r5 * r5
            r9 = 16
            int r9 = r9 * r9
            int r9 = r9 * r0
            int r5 = r5 - r9
            r9 = -1
            if (r5 != r9) goto L_0x0095
            r9 = r1
            r0 = r3
            goto L_0x000c
        L_0x0091:
            r9 = r1
            r0 = r3
            goto L_0x0002
        L_0x0095:
            r1.b = r3
            com.bytedance.sdk.openadsdk.h.a.b r9 = r1.p()
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.h.a.b.c(java.lang.String):com.bytedance.sdk.openadsdk.h.a.b");
    }

    /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP_START, MTH_ENTER_BLOCK] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String c() {
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
            java.lang.String r0 = r5.a
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.h.a.b.c():java.lang.String");
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0047, code lost:
        if ((((85 * 85) + (32 * 32)) - ((85 * 32) * 2)) < 0) goto L_0x0049;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0049, code lost:
        r5 = 0 * 0;
        r1 = 80 * 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0055, code lost:
        if ((((80 * 80) + r5) + r5) >= ((r5 + r1) + r1)) goto L_0x0068;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x005f, code lost:
        if (((85 * 85) - ((16 * 16) * 34)) != -1) goto L_0x008d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0064, code lost:
        switch(73) {
            case 72: goto L_0x0076;
            case 73: goto L_0x008d;
            case 74: goto L_0x0068;
            default: goto L_0x0067;
        };
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0073, code lost:
        if (((((82 - 1) * 82) * ((82 * 2) - 1)) % 6) == 0) goto L_0x008d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x008b, code lost:
        if ((((29 * 29) + (45 * 45)) + (20 * 20)) >= (((29 * 45) + (45 * 20)) + (29 * 20))) goto L_0x0002;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0020, code lost:
        if ((((49 * 49) + (34 * 34)) + (18 * 18)) < (((49 * 34) + (34 * 18)) + (49 * 18))) goto L_0x0022;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x002c, code lost:
        if ((((40 * 40) + (2 * 2)) - ((40 * 2) * 2)) >= 0) goto L_0x008d;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public T d(java.lang.String r9) {
        /*
            r8 = this;
            r0 = r9
            r9 = r8
        L_0x0002:
            r1 = 61
            r2 = 34
            r3 = 2
            switch(r1) {
                case 59: goto L_0x000b;
                case 60: goto L_0x0022;
                case 61: goto L_0x002e;
                default: goto L_0x000a;
            }
        L_0x000a:
            goto L_0x0002
        L_0x000b:
            r1 = 49
            r4 = 18
            int r5 = r1 * r1
            int r6 = r2 * r2
            int r5 = r5 + r6
            int r6 = r4 * r4
            int r5 = r5 + r6
            r6 = 49
            int r6 = r6 * r2
            r7 = 34
            int r7 = r7 * r4
            int r6 = r6 + r7
            int r1 = r1 * r4
            int r6 = r6 + r1
            if (r5 >= r6) goto L_0x0062
        L_0x0022:
            r1 = 40
            int r4 = r1 * r1
            int r5 = r3 * r3
            int r4 = r4 + r5
            int r1 = r1 * r3
            int r1 = r1 * r3
            int r4 = r4 - r1
            if (r4 >= 0) goto L_0x008d
        L_0x002e:
            r1 = 52
            r4 = 93
            r5 = 85
            switch(r4) {
                case 92: goto L_0x0062;
                case 93: goto L_0x0038;
                case 94: goto L_0x0058;
                default: goto L_0x0037;
            }
        L_0x0037:
            goto L_0x002e
        L_0x0038:
            switch(r1) {
                case 52: goto L_0x0062;
                case 53: goto L_0x003c;
                case 54: goto L_0x0049;
                default: goto L_0x003b;
            }
        L_0x003b:
            goto L_0x0058
        L_0x003c:
            r1 = 32
            int r5 = r5 * r5
            int r2 = r1 * r1
            int r5 = r5 + r2
            r2 = 85
            int r2 = r2 * r1
            int r2 = r2 * r3
            int r5 = r5 - r2
            if (r5 >= 0) goto L_0x0062
        L_0x0049:
            r1 = 80
            r2 = 0
            int r4 = r1 * r1
            int r5 = r2 * r2
            int r4 = r4 + r5
            int r4 = r4 + r5
            int r1 = r1 * r2
            int r5 = r5 + r1
            int r5 = r5 + r1
            if (r4 >= r5) goto L_0x0068
            goto L_0x008d
        L_0x0058:
            int r5 = r5 * r5
            r1 = 16
            int r1 = r1 * r1
            int r1 = r1 * r2
            int r5 = r5 - r1
            r1 = -1
            if (r5 != r1) goto L_0x008d
            goto L_0x0076
        L_0x0062:
            r1 = 73
            switch(r1) {
                case 72: goto L_0x0076;
                case 73: goto L_0x008d;
                case 74: goto L_0x0068;
                default: goto L_0x0067;
            }
        L_0x0067:
            goto L_0x0062
        L_0x0068:
            r1 = 82
            r2 = 1
            int r4 = 82 - r2
            int r4 = r4 * r1
            int r1 = r1 * r3
            int r1 = r1 - r2
            int r4 = r4 * r1
            int r4 = r4 % 6
            if (r4 == 0) goto L_0x008d
            goto L_0x0062
        L_0x0076:
            r1 = 29
            r2 = 45
            r3 = 20
            int r4 = r1 * r1
            int r5 = r2 * r2
            int r4 = r4 + r5
            int r5 = r3 * r3
            int r4 = r4 + r5
            r5 = 29
            int r5 = r5 * r2
            int r2 = r2 * r3
            int r5 = r5 + r2
            int r1 = r1 * r3
            int r5 = r5 + r1
            if (r4 >= r5) goto L_0x0002
        L_0x008d:
            r9.c = r0
            com.bytedance.sdk.openadsdk.h.a.b r9 = r9.p()
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.h.a.b.d(java.lang.String):com.bytedance.sdk.openadsdk.h.a.b");
    }

    /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP_START, MTH_ENTER_BLOCK] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String d() {
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
            java.lang.String r0 = r5.k
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.h.a.b.d():java.lang.String");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x004c, code lost:
        if ((((40 * 40) + (2 * 2)) - ((40 * 2) * 2)) >= 0) goto L_0x0095;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0054, code lost:
        switch(93) {
            case 92: goto L_0x0091;
            case 93: goto L_0x0058;
            case 94: goto L_0x0084;
            default: goto L_0x0057;
        };
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0058, code lost:
        switch(52) {
            case 52: goto L_0x0095;
            case 53: goto L_0x005c;
            case 54: goto L_0x0069;
            default: goto L_0x005b;
        };
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0067, code lost:
        if ((((85 * 85) + (32 * 32)) - ((85 * 32) * 2)) >= 0) goto L_0x0091;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0075, code lost:
        if ((((80 * 80) + r5) + r5) < ((r5 + r9) + r9)) goto L_0x0095;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0078, code lost:
        r4 = (((82 - 1) * 82) * ((82 * 2) - 1)) % 6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x008b, code lost:
        if (((85 * 85) - ((16 * 16) * 34)) != -1) goto L_0x0095;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x008d, code lost:
        r9 = r1;
        r0 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0091, code lost:
        r9 = r1;
        r0 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0095, code lost:
        r1.g = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x009b, code lost:
        return r1.p();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000c, code lost:
        r5 = ((29 * 29) + (45 * 45)) + (20 * 20);
        r6 = ((29 * 45) + (45 * 20)) + (29 * 20);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0021, code lost:
        r1 = r9;
        r3 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0027, code lost:
        switch(61) {
            case 59: goto L_0x002b;
            case 60: goto L_0x0042;
            case 61: goto L_0x004e;
            default: goto L_0x002a;
        };
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0040, code lost:
        if ((((49 * 49) + (34 * 34)) + (18 * 18)) >= (((49 * 34) + (34 * 18)) + (49 * 18))) goto L_0x0095;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public T e(java.lang.String r9) {
        /*
            r8 = this;
            r0 = r9
            r9 = r8
        L_0x0002:
            r1 = 73
            r2 = 2
            switch(r1) {
                case 72: goto L_0x000c;
                case 73: goto L_0x0021;
                case 74: goto L_0x0009;
                default: goto L_0x0008;
            }
        L_0x0008:
            goto L_0x0002
        L_0x0009:
            r1 = r9
            r3 = r0
            goto L_0x0078
        L_0x000c:
            r1 = 29
            r3 = 45
            r4 = 20
            int r5 = r1 * r1
            int r6 = r3 * r3
            int r5 = r5 + r6
            int r6 = r4 * r4
            int r5 = r5 + r6
            r6 = 29
            int r6 = r6 * r3
            int r3 = r3 * r4
            int r6 = r6 + r3
            int r1 = r1 * r4
            int r6 = r6 + r1
        L_0x0021:
            r1 = r9
            r3 = r0
        L_0x0023:
            r9 = 61
            r0 = 34
            switch(r9) {
                case 59: goto L_0x002b;
                case 60: goto L_0x0042;
                case 61: goto L_0x004e;
                default: goto L_0x002a;
            }
        L_0x002a:
            goto L_0x0023
        L_0x002b:
            r9 = 49
            r4 = 18
            int r5 = r9 * r9
            int r6 = r0 * r0
            int r5 = r5 + r6
            int r6 = r4 * r4
            int r5 = r5 + r6
            r6 = 49
            int r6 = r6 * r0
            r7 = 34
            int r7 = r7 * r4
            int r6 = r6 + r7
            int r9 = r9 * r4
            int r6 = r6 + r9
            if (r5 >= r6) goto L_0x0095
        L_0x0042:
            r9 = 40
            int r4 = r9 * r9
            int r5 = r2 * r2
            int r4 = r4 + r5
            int r9 = r9 * r2
            int r9 = r9 * r2
            int r4 = r4 - r9
            if (r4 >= 0) goto L_0x0095
        L_0x004e:
            r9 = 93
            r4 = 52
            r5 = 85
            switch(r9) {
                case 92: goto L_0x0091;
                case 93: goto L_0x0058;
                case 94: goto L_0x0084;
                default: goto L_0x0057;
            }
        L_0x0057:
            goto L_0x004e
        L_0x0058:
            switch(r4) {
                case 52: goto L_0x0095;
                case 53: goto L_0x005c;
                case 54: goto L_0x0069;
                default: goto L_0x005b;
            }
        L_0x005b:
            goto L_0x0084
        L_0x005c:
            r9 = 32
            int r5 = r5 * r5
            int r0 = r9 * r9
            int r5 = r5 + r0
            r0 = 85
            int r0 = r0 * r9
            int r0 = r0 * r2
            int r5 = r5 - r0
            if (r5 >= 0) goto L_0x0091
        L_0x0069:
            r9 = 80
            r0 = 0
            int r4 = r9 * r9
            int r5 = r0 * r0
            int r4 = r4 + r5
            int r4 = r4 + r5
            int r9 = r9 * r0
            int r5 = r5 + r9
            int r5 = r5 + r9
            if (r4 >= r5) goto L_0x0078
            goto L_0x0095
        L_0x0078:
            r9 = 82
            r0 = 1
            int r4 = 82 - r0
            int r4 = r4 * r9
            int r9 = r9 * r2
            int r9 = r9 - r0
            int r4 = r4 * r9
            int r4 = r4 % 6
            goto L_0x0095
        L_0x0084:
            int r5 = r5 * r5
            r9 = 16
            int r9 = r9 * r9
            int r9 = r9 * r0
            int r5 = r5 - r9
            r9 = -1
            if (r5 != r9) goto L_0x0095
            r9 = r1
            r0 = r3
            goto L_0x000c
        L_0x0091:
            r9 = r1
            r0 = r3
            goto L_0x0002
        L_0x0095:
            r1.g = r3
            com.bytedance.sdk.openadsdk.h.a.b r9 = r1.p()
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.h.a.b.e(java.lang.String):com.bytedance.sdk.openadsdk.h.a.b");
    }

    /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP_START, MTH_ENTER_BLOCK] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String e() {
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
            java.lang.String r0 = r5.b
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.h.a.b.e():java.lang.String");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x004c, code lost:
        if ((((40 * 40) + (2 * 2)) - ((40 * 2) * 2)) >= 0) goto L_0x0095;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0054, code lost:
        switch(93) {
            case 92: goto L_0x0091;
            case 93: goto L_0x0058;
            case 94: goto L_0x0084;
            default: goto L_0x0057;
        };
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0058, code lost:
        switch(52) {
            case 52: goto L_0x0095;
            case 53: goto L_0x005c;
            case 54: goto L_0x0069;
            default: goto L_0x005b;
        };
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0067, code lost:
        if ((((85 * 85) + (32 * 32)) - ((85 * 32) * 2)) >= 0) goto L_0x0091;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0075, code lost:
        if ((((80 * 80) + r5) + r5) < ((r5 + r9) + r9)) goto L_0x0095;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0078, code lost:
        r4 = (((82 - 1) * 82) * ((82 * 2) - 1)) % 6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x008b, code lost:
        if (((85 * 85) - ((16 * 16) * 34)) != -1) goto L_0x0095;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x008d, code lost:
        r9 = r1;
        r0 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0091, code lost:
        r9 = r1;
        r0 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0095, code lost:
        r1.i = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x009b, code lost:
        return r1.p();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000c, code lost:
        r5 = ((29 * 29) + (45 * 45)) + (20 * 20);
        r6 = ((29 * 45) + (45 * 20)) + (29 * 20);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0021, code lost:
        r1 = r9;
        r3 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0027, code lost:
        switch(61) {
            case 59: goto L_0x002b;
            case 60: goto L_0x0042;
            case 61: goto L_0x004e;
            default: goto L_0x002a;
        };
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0040, code lost:
        if ((((49 * 49) + (34 * 34)) + (18 * 18)) >= (((49 * 34) + (34 * 18)) + (49 * 18))) goto L_0x0095;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public T f(java.lang.String r9) {
        /*
            r8 = this;
            r0 = r9
            r9 = r8
        L_0x0002:
            r1 = 73
            r2 = 2
            switch(r1) {
                case 72: goto L_0x000c;
                case 73: goto L_0x0021;
                case 74: goto L_0x0009;
                default: goto L_0x0008;
            }
        L_0x0008:
            goto L_0x0002
        L_0x0009:
            r1 = r9
            r3 = r0
            goto L_0x0078
        L_0x000c:
            r1 = 29
            r3 = 45
            r4 = 20
            int r5 = r1 * r1
            int r6 = r3 * r3
            int r5 = r5 + r6
            int r6 = r4 * r4
            int r5 = r5 + r6
            r6 = 29
            int r6 = r6 * r3
            int r3 = r3 * r4
            int r6 = r6 + r3
            int r1 = r1 * r4
            int r6 = r6 + r1
        L_0x0021:
            r1 = r9
            r3 = r0
        L_0x0023:
            r9 = 61
            r0 = 34
            switch(r9) {
                case 59: goto L_0x002b;
                case 60: goto L_0x0042;
                case 61: goto L_0x004e;
                default: goto L_0x002a;
            }
        L_0x002a:
            goto L_0x0023
        L_0x002b:
            r9 = 49
            r4 = 18
            int r5 = r9 * r9
            int r6 = r0 * r0
            int r5 = r5 + r6
            int r6 = r4 * r4
            int r5 = r5 + r6
            r6 = 49
            int r6 = r6 * r0
            r7 = 34
            int r7 = r7 * r4
            int r6 = r6 + r7
            int r9 = r9 * r4
            int r6 = r6 + r9
            if (r5 >= r6) goto L_0x0095
        L_0x0042:
            r9 = 40
            int r4 = r9 * r9
            int r5 = r2 * r2
            int r4 = r4 + r5
            int r9 = r9 * r2
            int r9 = r9 * r2
            int r4 = r4 - r9
            if (r4 >= 0) goto L_0x0095
        L_0x004e:
            r9 = 93
            r4 = 52
            r5 = 85
            switch(r9) {
                case 92: goto L_0x0091;
                case 93: goto L_0x0058;
                case 94: goto L_0x0084;
                default: goto L_0x0057;
            }
        L_0x0057:
            goto L_0x004e
        L_0x0058:
            switch(r4) {
                case 52: goto L_0x0095;
                case 53: goto L_0x005c;
                case 54: goto L_0x0069;
                default: goto L_0x005b;
            }
        L_0x005b:
            goto L_0x0084
        L_0x005c:
            r9 = 32
            int r5 = r5 * r5
            int r0 = r9 * r9
            int r5 = r5 + r0
            r0 = 85
            int r0 = r0 * r9
            int r0 = r0 * r2
            int r5 = r5 - r0
            if (r5 >= 0) goto L_0x0091
        L_0x0069:
            r9 = 80
            r0 = 0
            int r4 = r9 * r9
            int r5 = r0 * r0
            int r4 = r4 + r5
            int r4 = r4 + r5
            int r9 = r9 * r0
            int r5 = r5 + r9
            int r5 = r5 + r9
            if (r4 >= r5) goto L_0x0078
            goto L_0x0095
        L_0x0078:
            r9 = 82
            r0 = 1
            int r4 = 82 - r0
            int r4 = r4 * r9
            int r9 = r9 * r2
            int r9 = r9 - r0
            int r4 = r4 * r9
            int r4 = r4 % 6
            goto L_0x0095
        L_0x0084:
            int r5 = r5 * r5
            r9 = 16
            int r9 = r9 * r9
            int r9 = r9 * r0
            int r5 = r5 - r9
            r9 = -1
            if (r5 != r9) goto L_0x0095
            r9 = r1
            r0 = r3
            goto L_0x000c
        L_0x0091:
            r9 = r1
            r0 = r3
            goto L_0x0002
        L_0x0095:
            r1.i = r3
            com.bytedance.sdk.openadsdk.h.a.b r9 = r1.p()
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.h.a.b.f(java.lang.String):com.bytedance.sdk.openadsdk.h.a.b");
    }

    /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP_START, MTH_ENTER_BLOCK] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String f() {
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
            java.lang.String r0 = r5.c
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.h.a.b.f():java.lang.String");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x004c, code lost:
        if ((((40 * 40) + (2 * 2)) - ((40 * 2) * 2)) >= 0) goto L_0x0095;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0054, code lost:
        switch(93) {
            case 92: goto L_0x0091;
            case 93: goto L_0x0058;
            case 94: goto L_0x0084;
            default: goto L_0x0057;
        };
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0058, code lost:
        switch(52) {
            case 52: goto L_0x0095;
            case 53: goto L_0x005c;
            case 54: goto L_0x0069;
            default: goto L_0x005b;
        };
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0067, code lost:
        if ((((85 * 85) + (32 * 32)) - ((85 * 32) * 2)) >= 0) goto L_0x0091;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0075, code lost:
        if ((((80 * 80) + r5) + r5) < ((r5 + r9) + r9)) goto L_0x0095;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0078, code lost:
        r4 = (((82 - 1) * 82) * ((82 * 2) - 1)) % 6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x008b, code lost:
        if (((85 * 85) - ((16 * 16) * 34)) != -1) goto L_0x0095;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x008d, code lost:
        r9 = r1;
        r0 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0091, code lost:
        r9 = r1;
        r0 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0095, code lost:
        r1.j = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x009b, code lost:
        return r1.p();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000c, code lost:
        r5 = ((29 * 29) + (45 * 45)) + (20 * 20);
        r6 = ((29 * 45) + (45 * 20)) + (29 * 20);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0021, code lost:
        r1 = r9;
        r3 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0027, code lost:
        switch(61) {
            case 59: goto L_0x002b;
            case 60: goto L_0x0042;
            case 61: goto L_0x004e;
            default: goto L_0x002a;
        };
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0040, code lost:
        if ((((49 * 49) + (34 * 34)) + (18 * 18)) >= (((49 * 34) + (34 * 18)) + (49 * 18))) goto L_0x0095;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public T g(java.lang.String r9) {
        /*
            r8 = this;
            r0 = r9
            r9 = r8
        L_0x0002:
            r1 = 73
            r2 = 2
            switch(r1) {
                case 72: goto L_0x000c;
                case 73: goto L_0x0021;
                case 74: goto L_0x0009;
                default: goto L_0x0008;
            }
        L_0x0008:
            goto L_0x0002
        L_0x0009:
            r1 = r9
            r3 = r0
            goto L_0x0078
        L_0x000c:
            r1 = 29
            r3 = 45
            r4 = 20
            int r5 = r1 * r1
            int r6 = r3 * r3
            int r5 = r5 + r6
            int r6 = r4 * r4
            int r5 = r5 + r6
            r6 = 29
            int r6 = r6 * r3
            int r3 = r3 * r4
            int r6 = r6 + r3
            int r1 = r1 * r4
            int r6 = r6 + r1
        L_0x0021:
            r1 = r9
            r3 = r0
        L_0x0023:
            r9 = 61
            r0 = 34
            switch(r9) {
                case 59: goto L_0x002b;
                case 60: goto L_0x0042;
                case 61: goto L_0x004e;
                default: goto L_0x002a;
            }
        L_0x002a:
            goto L_0x0023
        L_0x002b:
            r9 = 49
            r4 = 18
            int r5 = r9 * r9
            int r6 = r0 * r0
            int r5 = r5 + r6
            int r6 = r4 * r4
            int r5 = r5 + r6
            r6 = 49
            int r6 = r6 * r0
            r7 = 34
            int r7 = r7 * r4
            int r6 = r6 + r7
            int r9 = r9 * r4
            int r6 = r6 + r9
            if (r5 >= r6) goto L_0x0095
        L_0x0042:
            r9 = 40
            int r4 = r9 * r9
            int r5 = r2 * r2
            int r4 = r4 + r5
            int r9 = r9 * r2
            int r9 = r9 * r2
            int r4 = r4 - r9
            if (r4 >= 0) goto L_0x0095
        L_0x004e:
            r9 = 93
            r4 = 52
            r5 = 85
            switch(r9) {
                case 92: goto L_0x0091;
                case 93: goto L_0x0058;
                case 94: goto L_0x0084;
                default: goto L_0x0057;
            }
        L_0x0057:
            goto L_0x004e
        L_0x0058:
            switch(r4) {
                case 52: goto L_0x0095;
                case 53: goto L_0x005c;
                case 54: goto L_0x0069;
                default: goto L_0x005b;
            }
        L_0x005b:
            goto L_0x0084
        L_0x005c:
            r9 = 32
            int r5 = r5 * r5
            int r0 = r9 * r9
            int r5 = r5 + r0
            r0 = 85
            int r0 = r0 * r9
            int r0 = r0 * r2
            int r5 = r5 - r0
            if (r5 >= 0) goto L_0x0091
        L_0x0069:
            r9 = 80
            r0 = 0
            int r4 = r9 * r9
            int r5 = r0 * r0
            int r4 = r4 + r5
            int r4 = r4 + r5
            int r9 = r9 * r0
            int r5 = r5 + r9
            int r5 = r5 + r9
            if (r4 >= r5) goto L_0x0078
            goto L_0x0095
        L_0x0078:
            r9 = 82
            r0 = 1
            int r4 = 82 - r0
            int r4 = r4 * r9
            int r9 = r9 * r2
            int r9 = r9 - r0
            int r4 = r4 * r9
            int r4 = r4 % 6
            goto L_0x0095
        L_0x0084:
            int r5 = r5 * r5
            r9 = 16
            int r9 = r9 * r9
            int r9 = r9 * r0
            int r5 = r5 - r9
            r9 = -1
            if (r5 != r9) goto L_0x0095
            r9 = r1
            r0 = r3
            goto L_0x000c
        L_0x0091:
            r9 = r1
            r0 = r3
            goto L_0x0002
        L_0x0095:
            r1.j = r3
            com.bytedance.sdk.openadsdk.h.a.b r9 = r1.p()
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.h.a.b.g(java.lang.String):com.bytedance.sdk.openadsdk.h.a.b");
    }

    public String g() {
        return TextUtils.isEmpty(this.d) ? "" : this.d;
    }

    public long h() {
        long j2 = this.e;
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
        return j2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x004c, code lost:
        if ((((40 * 40) + (2 * 2)) - ((40 * 2) * 2)) >= 0) goto L_0x0095;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0054, code lost:
        switch(93) {
            case 92: goto L_0x0091;
            case 93: goto L_0x0058;
            case 94: goto L_0x0084;
            default: goto L_0x0057;
        };
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0058, code lost:
        switch(52) {
            case 52: goto L_0x0095;
            case 53: goto L_0x005c;
            case 54: goto L_0x0069;
            default: goto L_0x005b;
        };
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0067, code lost:
        if ((((85 * 85) + (32 * 32)) - ((85 * 32) * 2)) >= 0) goto L_0x0091;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0075, code lost:
        if ((((80 * 80) + r5) + r5) < ((r5 + r9) + r9)) goto L_0x0095;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0078, code lost:
        r4 = (((82 - 1) * 82) * ((82 * 2) - 1)) % 6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x008b, code lost:
        if (((85 * 85) - ((16 * 16) * 34)) != -1) goto L_0x0095;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x008d, code lost:
        r9 = r1;
        r0 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0091, code lost:
        r9 = r1;
        r0 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0095, code lost:
        r1.l = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x009b, code lost:
        return r1.p();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000c, code lost:
        r5 = ((29 * 29) + (45 * 45)) + (20 * 20);
        r6 = ((29 * 45) + (45 * 20)) + (29 * 20);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0021, code lost:
        r1 = r9;
        r3 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0027, code lost:
        switch(61) {
            case 59: goto L_0x002b;
            case 60: goto L_0x0042;
            case 61: goto L_0x004e;
            default: goto L_0x002a;
        };
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0040, code lost:
        if ((((49 * 49) + (34 * 34)) + (18 * 18)) >= (((49 * 34) + (34 * 18)) + (49 * 18))) goto L_0x0095;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public T h(java.lang.String r9) {
        /*
            r8 = this;
            r0 = r9
            r9 = r8
        L_0x0002:
            r1 = 73
            r2 = 2
            switch(r1) {
                case 72: goto L_0x000c;
                case 73: goto L_0x0021;
                case 74: goto L_0x0009;
                default: goto L_0x0008;
            }
        L_0x0008:
            goto L_0x0002
        L_0x0009:
            r1 = r9
            r3 = r0
            goto L_0x0078
        L_0x000c:
            r1 = 29
            r3 = 45
            r4 = 20
            int r5 = r1 * r1
            int r6 = r3 * r3
            int r5 = r5 + r6
            int r6 = r4 * r4
            int r5 = r5 + r6
            r6 = 29
            int r6 = r6 * r3
            int r3 = r3 * r4
            int r6 = r6 + r3
            int r1 = r1 * r4
            int r6 = r6 + r1
        L_0x0021:
            r1 = r9
            r3 = r0
        L_0x0023:
            r9 = 61
            r0 = 34
            switch(r9) {
                case 59: goto L_0x002b;
                case 60: goto L_0x0042;
                case 61: goto L_0x004e;
                default: goto L_0x002a;
            }
        L_0x002a:
            goto L_0x0023
        L_0x002b:
            r9 = 49
            r4 = 18
            int r5 = r9 * r9
            int r6 = r0 * r0
            int r5 = r5 + r6
            int r6 = r4 * r4
            int r5 = r5 + r6
            r6 = 49
            int r6 = r6 * r0
            r7 = 34
            int r7 = r7 * r4
            int r6 = r6 + r7
            int r9 = r9 * r4
            int r6 = r6 + r9
            if (r5 >= r6) goto L_0x0095
        L_0x0042:
            r9 = 40
            int r4 = r9 * r9
            int r5 = r2 * r2
            int r4 = r4 + r5
            int r9 = r9 * r2
            int r9 = r9 * r2
            int r4 = r4 - r9
            if (r4 >= 0) goto L_0x0095
        L_0x004e:
            r9 = 93
            r4 = 52
            r5 = 85
            switch(r9) {
                case 92: goto L_0x0091;
                case 93: goto L_0x0058;
                case 94: goto L_0x0084;
                default: goto L_0x0057;
            }
        L_0x0057:
            goto L_0x004e
        L_0x0058:
            switch(r4) {
                case 52: goto L_0x0095;
                case 53: goto L_0x005c;
                case 54: goto L_0x0069;
                default: goto L_0x005b;
            }
        L_0x005b:
            goto L_0x0084
        L_0x005c:
            r9 = 32
            int r5 = r5 * r5
            int r0 = r9 * r9
            int r5 = r5 + r0
            r0 = 85
            int r0 = r0 * r9
            int r0 = r0 * r2
            int r5 = r5 - r0
            if (r5 >= 0) goto L_0x0091
        L_0x0069:
            r9 = 80
            r0 = 0
            int r4 = r9 * r9
            int r5 = r0 * r0
            int r4 = r4 + r5
            int r4 = r4 + r5
            int r9 = r9 * r0
            int r5 = r5 + r9
            int r5 = r5 + r9
            if (r4 >= r5) goto L_0x0078
            goto L_0x0095
        L_0x0078:
            r9 = 82
            r0 = 1
            int r4 = 82 - r0
            int r4 = r4 * r9
            int r9 = r9 * r2
            int r9 = r9 - r0
            int r4 = r4 * r9
            int r4 = r4 % 6
            goto L_0x0095
        L_0x0084:
            int r5 = r5 * r5
            r9 = 16
            int r9 = r9 * r9
            int r9 = r9 * r0
            int r5 = r5 - r9
            r9 = -1
            if (r5 != r9) goto L_0x0095
            r9 = r1
            r0 = r3
            goto L_0x000c
        L_0x0091:
            r9 = r1
            r0 = r3
            goto L_0x0002
        L_0x0095:
            r1.l = r3
            com.bytedance.sdk.openadsdk.h.a.b r9 = r1.p()
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.h.a.b.h(java.lang.String):com.bytedance.sdk.openadsdk.h.a.b");
    }

    public int i() {
        int i2 = this.f;
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
        return i2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP_START, MTH_ENTER_BLOCK] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String j() {
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
            java.lang.String r0 = r5.g
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.h.a.b.j():java.lang.String");
    }

    public int k() {
        int i2 = this.h;
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
        return i2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP_START, MTH_ENTER_BLOCK] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String l() {
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
            java.lang.String r0 = r5.i
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.h.a.b.l():java.lang.String");
    }

    /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP_START, MTH_ENTER_BLOCK] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String m() {
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
            java.lang.String r0 = r5.j
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.h.a.b.m():java.lang.String");
    }

    /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP_START, MTH_ENTER_BLOCK] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String n() {
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
            java.lang.String r0 = r5.l
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.h.a.b.n():java.lang.String");
    }
}
