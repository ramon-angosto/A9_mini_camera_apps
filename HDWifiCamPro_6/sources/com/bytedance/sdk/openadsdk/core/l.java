package com.bytedance.sdk.openadsdk.core;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.sdk.component.f.c.d;
import com.bytedance.sdk.openadsdk.a.b.a;
import com.bytedance.sdk.openadsdk.a.b.g;
import com.bytedance.sdk.openadsdk.api.nativeAd.PAGNativeAd;
import com.bytedance.sdk.openadsdk.c.f;
import com.bytedance.sdk.openadsdk.core.model.n;
import com.com.bytedance.overseas.sdk.a.c;
import java.util.ArrayList;
import java.util.List;

/* compiled from: InteractionManager */
public class l {
    private final n a;
    private c b;
    private final Context c;
    private final PAGNativeAd d;
    private List<View> e = new ArrayList();
    private String f = d.d1667305730926dc("el`f``bXim");
    private g g;
    private long h;
    private Double i = null;
    private f j = new f();
    private a k;

    public l(Context context, PAGNativeAd pAGNativeAd, n nVar, String str, a aVar) {
        this.d = pAGNativeAd;
        this.a = nVar;
        this.c = context;
        this.f = str;
        this.k = aVar;
        if (this.a.L() == 4) {
            this.b = com.com.bytedance.overseas.sdk.a.d.a(this.c, this.a, this.f);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0048, code lost:
        if ((((40 * 40) + (2 * 2)) - ((40 * 2) * 2)) >= 0) goto L_0x0093;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0050, code lost:
        switch(93) {
            case 92: goto L_0x0090;
            case 93: goto L_0x0054;
            case 94: goto L_0x0084;
            default: goto L_0x0053;
        };
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0054, code lost:
        switch(52) {
            case 52: goto L_0x0093;
            case 53: goto L_0x0058;
            case 54: goto L_0x0065;
            default: goto L_0x0057;
        };
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0063, code lost:
        if ((((85 * 85) + (32 * 32)) - ((85 * 32) * 2)) >= 0) goto L_0x0090;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0065, code lost:
        r3 = 0 * 0;
        r6 = 80 * 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0071, code lost:
        if ((((80 * 80) + r3) + r3) >= ((r3 + r6) + r6)) goto L_0x0074;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0074, code lost:
        r7 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0080, code lost:
        if (((((82 - 1) * 82) * ((82 * 2) - 1)) % 6) == 0) goto L_0x001e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x008b, code lost:
        if (((85 * 85) - ((16 * 16) * 34)) != -1) goto L_0x001f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x008d, code lost:
        r7 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0090, code lost:
        r7 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0009, code lost:
        r3 = ((29 * 29) + (45 * 45)) + (20 * 20);
        r4 = ((29 * 45) + (45 * 20)) + (29 * 20);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:?, code lost:
        return r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:?, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:?, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:?, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:4:0x001e, code lost:
        r1 = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0023, code lost:
        switch(61) {
            case 59: goto L_0x0027;
            case 60: goto L_0x003e;
            case 61: goto L_0x004a;
            default: goto L_0x0026;
        };
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x003c, code lost:
        if ((((49 * 49) + (34 * 34)) + (18 * 18)) >= (((49 * 34) + (34 * 18)) + (49 * 18))) goto L_0x0093;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ long a(com.bytedance.sdk.openadsdk.core.l r6, long r7) {
        /*
            r6.h = r7
        L_0x0002:
            r6 = 73
            r0 = 2
            switch(r6) {
                case 72: goto L_0x0009;
                case 73: goto L_0x001e;
                case 74: goto L_0x0075;
                default: goto L_0x0008;
            }
        L_0x0008:
            goto L_0x0002
        L_0x0009:
            r6 = 29
            r1 = 45
            r2 = 20
            int r3 = r6 * r6
            int r4 = r1 * r1
            int r3 = r3 + r4
            int r4 = r2 * r2
            int r3 = r3 + r4
            r4 = 29
            int r4 = r4 * r1
            int r1 = r1 * r2
            int r4 = r4 + r1
            int r6 = r6 * r2
            int r4 = r4 + r6
        L_0x001e:
            r1 = r7
        L_0x001f:
            r6 = 61
            r7 = 34
            switch(r6) {
                case 59: goto L_0x0027;
                case 60: goto L_0x003e;
                case 61: goto L_0x004a;
                default: goto L_0x0026;
            }
        L_0x0026:
            goto L_0x001f
        L_0x0027:
            r6 = 49
            r8 = 18
            int r3 = r6 * r6
            int r4 = r7 * r7
            int r3 = r3 + r4
            int r4 = r8 * r8
            int r3 = r3 + r4
            r4 = 49
            int r4 = r4 * r7
            r5 = 34
            int r5 = r5 * r8
            int r4 = r4 + r5
            int r6 = r6 * r8
            int r4 = r4 + r6
            if (r3 >= r4) goto L_0x0093
        L_0x003e:
            r6 = 40
            int r8 = r6 * r6
            int r3 = r0 * r0
            int r8 = r8 + r3
            int r6 = r6 * r0
            int r6 = r6 * r0
            int r8 = r8 - r6
            if (r8 >= 0) goto L_0x0093
        L_0x004a:
            r6 = 93
            r8 = 52
            r3 = 85
            switch(r6) {
                case 92: goto L_0x0090;
                case 93: goto L_0x0054;
                case 94: goto L_0x0084;
                default: goto L_0x0053;
            }
        L_0x0053:
            goto L_0x004a
        L_0x0054:
            switch(r8) {
                case 52: goto L_0x0093;
                case 53: goto L_0x0058;
                case 54: goto L_0x0065;
                default: goto L_0x0057;
            }
        L_0x0057:
            goto L_0x0084
        L_0x0058:
            r6 = 32
            int r3 = r3 * r3
            int r7 = r6 * r6
            int r3 = r3 + r7
            r7 = 85
            int r7 = r7 * r6
            int r7 = r7 * r0
            int r3 = r3 - r7
            if (r3 >= 0) goto L_0x0090
        L_0x0065:
            r6 = 80
            r7 = 0
            int r8 = r6 * r6
            int r3 = r7 * r7
            int r8 = r8 + r3
            int r8 = r8 + r3
            int r6 = r6 * r7
            int r3 = r3 + r6
            int r3 = r3 + r6
            if (r8 >= r3) goto L_0x0074
            goto L_0x001f
        L_0x0074:
            r7 = r1
        L_0x0075:
            r6 = 82
            r1 = 1
            int r2 = 82 - r1
            int r2 = r2 * r6
            int r6 = r6 * r0
            int r6 = r6 - r1
            int r2 = r2 * r6
            int r2 = r2 % 6
            if (r2 == 0) goto L_0x001e
            r1 = r7
            goto L_0x0093
        L_0x0084:
            int r3 = r3 * r3
            r6 = 16
            int r6 = r6 * r6
            int r6 = r6 * r7
            int r3 = r3 - r6
            r6 = -1
            if (r3 != r6) goto L_0x001f
            r7 = r1
            goto L_0x0009
        L_0x0090:
            r7 = r1
            goto L_0x0002
        L_0x0093:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.l.a(com.bytedance.sdk.openadsdk.core.l, long):long");
    }

    /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP_START, MTH_ENTER_BLOCK] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ com.bytedance.sdk.openadsdk.c.f a(com.bytedance.sdk.openadsdk.core.l r5) {
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
            com.bytedance.sdk.openadsdk.c.f r5 = r5.j
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.l.a(com.bytedance.sdk.openadsdk.core.l):com.bytedance.sdk.openadsdk.c.f");
    }

    private EmptyView a(ViewGroup viewGroup) {
        for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
            View childAt = viewGroup.getChildAt(i2);
            if (childAt instanceof EmptyView) {
                return (EmptyView) childAt;
            }
        }
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP_START, MTH_ENTER_BLOCK] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ com.bytedance.sdk.openadsdk.api.nativeAd.PAGNativeAd b(com.bytedance.sdk.openadsdk.core.l r5) {
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
            com.bytedance.sdk.openadsdk.api.nativeAd.PAGNativeAd r5 = r5.d
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.l.b(com.bytedance.sdk.openadsdk.core.l):com.bytedance.sdk.openadsdk.api.nativeAd.PAGNativeAd");
    }

    /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP_START, MTH_ENTER_BLOCK] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ com.bytedance.sdk.openadsdk.core.model.n c(com.bytedance.sdk.openadsdk.core.l r5) {
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
            com.bytedance.sdk.openadsdk.core.model.n r5 = r5.a
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.l.c(com.bytedance.sdk.openadsdk.core.l):com.bytedance.sdk.openadsdk.core.model.n");
    }

    /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP_START, MTH_ENTER_BLOCK] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ com.bytedance.sdk.openadsdk.a.b.a d(com.bytedance.sdk.openadsdk.core.l r5) {
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
            com.bytedance.sdk.openadsdk.a.b.a r5 = r5.k
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.l.d(com.bytedance.sdk.openadsdk.core.l):com.bytedance.sdk.openadsdk.a.b.a");
    }

    static /* synthetic */ long e(l lVar) {
        long j2 = lVar.h;
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

    /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP_START, MTH_ENTER_BLOCK] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ java.lang.String f(com.bytedance.sdk.openadsdk.core.l r5) {
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
            java.lang.String r5 = r5.f
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.l.f(com.bytedance.sdk.openadsdk.core.l):java.lang.String");
    }

    /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP_START, MTH_ENTER_BLOCK] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ java.util.List g(com.bytedance.sdk.openadsdk.core.l r5) {
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
            java.util.List<android.view.View> r5 = r5.e
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.l.g(com.bytedance.sdk.openadsdk.core.l):java.util.List");
    }

    /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP_START, MTH_ENTER_BLOCK] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ android.content.Context h(com.bytedance.sdk.openadsdk.core.l r5) {
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
            android.content.Context r5 = r5.c
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.l.h(com.bytedance.sdk.openadsdk.core.l):android.content.Context");
    }

    /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP_START, MTH_ENTER_BLOCK] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ java.lang.Double i(com.bytedance.sdk.openadsdk.core.l r5) {
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
            java.lang.Double r5 = r5.i
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.l.i(com.bytedance.sdk.openadsdk.core.l):java.lang.Double");
    }

    /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP_START, MTH_ENTER_BLOCK] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.bytedance.sdk.openadsdk.c.f a() {
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
            com.bytedance.sdk.openadsdk.c.f r0 = r5.j
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.l.a():com.bytedance.sdk.openadsdk.c.f");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0017, code lost:
        switch(r4) {
            case 55: goto L_0x0022;
            case 56: goto L_0x000c;
            case 57: goto L_0x0022;
            default: goto L_0x001a;
        };
     */
    /* JADX WARNING: Removed duplicated region for block: B:5:0x0014  */
    /* JADX WARNING: Removed duplicated region for block: B:7:0x001b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(android.view.View r3, int r4) {
        /*
            r2 = this;
            com.bytedance.sdk.openadsdk.a.b.g r4 = r2.g
            r0 = 95
            if (r4 == 0) goto L_0x000c
            com.bytedance.sdk.openadsdk.api.nativeAd.PAGNativeAd r1 = r2.d
            r4.b(r3, r1)
            goto L_0x001f
        L_0x000c:
            r3 = 94
            r4 = 125(0x7d, float:1.75E-43)
        L_0x0010:
            switch(r3) {
                case 94: goto L_0x001b;
                case 95: goto L_0x0014;
                case 96: goto L_0x0017;
                default: goto L_0x0013;
            }
        L_0x0013:
            goto L_0x000c
        L_0x0014:
            switch(r4) {
                case 94: goto L_0x001f;
                case 95: goto L_0x000c;
                case 96: goto L_0x001f;
                default: goto L_0x0017;
            }
        L_0x0017:
            switch(r4) {
                case 55: goto L_0x0022;
                case 56: goto L_0x000c;
                case 57: goto L_0x0022;
                default: goto L_0x001a;
            }
        L_0x001a:
            goto L_0x0022
        L_0x001b:
            r3 = 39
            if (r4 != r3) goto L_0x0022
        L_0x001f:
            r3 = r0
            r4 = r3
            goto L_0x0010
        L_0x0022:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.l.a(android.view.View, int):void");
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x011e, code lost:
        switch(55) {
            case 54: goto L_0x0160;
            case 55: goto L_0x015e;
            case 56: goto L_0x0122;
            default: goto L_0x0121;
        };
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0122, code lost:
        r14 = (16 * 16) * 16;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0132, code lost:
        if (((((99 * 99) * 99) + r14) + r14) >= (((99 * 16) * 16) * 3)) goto L_0x0116;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0136, code lost:
        if (27 <= 11) goto L_0x0139;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0144, code lost:
        if ((((96 * 96) + (39 * 39)) - ((96 * 39) * 2)) >= 0) goto L_0x0116;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x015b, code lost:
        if (((((57 * 57) * 57) + ((49 * 49) * 49)) + ((23 * 23) * 23)) >= (((57 * 49) * 23) * 3)) goto L_0x0116;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x015e, code lost:
        r9 = '(';
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0160, code lost:
        switch(27) {
            case 89: goto L_0x0164;
            case 90: goto L_0x016d;
            case 91: goto L_0x0184;
            default: goto L_0x0163;
        };
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x016b, code lost:
        if ((((52 + 1) * 52) % 2) == 0) goto L_0x0116;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x0182, code lost:
        if ((((94 * 94) + (46 * 46)) + (10 * 10)) >= (((94 * 46) + (46 * 10)) + (94 * 10))) goto L_0x0160;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x0199, code lost:
        if ((((8 * 8) + (39 * 39)) + (25 * 25)) >= (((8 * 39) + (39 * 25)) + (8 * 25))) goto L_0x0116;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x0116, code lost:
        continue;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x0116, code lost:
        continue;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x0116, code lost:
        continue;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x0116, code lost:
        continue;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(final android.view.ViewGroup r9, java.util.List<android.view.View> r10, java.util.List<android.view.View> r11, java.util.List<android.view.View> r12, android.view.View r13, final com.bytedance.sdk.openadsdk.a.b.g r14) {
        /*
            r8 = this;
            r8.g = r14
            com.bytedance.sdk.openadsdk.core.l$1 r0 = new com.bytedance.sdk.openadsdk.core.l$1
            r0.<init>(r9)
            r9.addOnLayoutChangeListener(r0)
            r8.e = r10
            com.bytedance.sdk.openadsdk.core.model.n r0 = r8.a
            com.bytedance.sdk.openadsdk.c.c.a((com.bytedance.sdk.openadsdk.core.model.n) r0)
            com.bytedance.sdk.openadsdk.core.EmptyView r0 = r8.a((android.view.ViewGroup) r9)
            if (r0 != 0) goto L_0x0021
            com.bytedance.sdk.openadsdk.core.EmptyView r0 = new com.bytedance.sdk.openadsdk.core.EmptyView
            android.content.Context r1 = r8.c
            r0.<init>(r1, r9)
            r9.addView(r0)
        L_0x0021:
            r0.a()
            r0.setRefClickViews(r11)
            r1 = 1
            if (r10 == 0) goto L_0x0057
            java.util.List<android.view.View> r2 = r8.e
            java.util.Iterator r2 = r2.iterator()
        L_0x0030:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x0054
            java.lang.Object r3 = r2.next()
            android.view.View r3 = (android.view.View) r3
            if (r3 == 0) goto L_0x0030
            android.content.Context r4 = com.bytedance.sdk.openadsdk.core.m.a()
            java.lang.String r5 = "tu]j`ZotWcoibQyrfffp"
            java.lang.String r5 = com.bytedance.sdk.component.a.j.j1667305730992dc(r5)
            int r4 = com.bytedance.sdk.component.utils.t.e(r4, r5)
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r1)
            r3.setTag(r4, r5)
            goto L_0x0030
        L_0x0054:
            r12.addAll(r10)
        L_0x0057:
            r0.setRefCreativeViews(r12)
            java.util.HashMap r10 = new java.util.HashMap
            r10.<init>()
            java.lang.String r2 = "cmk`oZudmgin"
            java.lang.String r2 = com.bytedance.sdk.component.f.c.d.d1667305730926dc(r2)
            java.lang.Integer r3 = java.lang.Integer.valueOf(r1)
            r10.put(r2, r3)
            com.bytedance.sdk.openadsdk.core.b.b r2 = new com.bytedance.sdk.openadsdk.core.b.b
            android.content.Context r3 = r8.c
            com.bytedance.sdk.openadsdk.core.model.n r4 = r8.a
            java.lang.String r5 = r8.f
            int r6 = com.bytedance.sdk.openadsdk.l.y.a((java.lang.String) r5)
            r2.<init>(r3, r4, r5, r6)
            r2.a((android.view.View) r9)
            r2.b((android.view.View) r13)
            com.com.bytedance.overseas.sdk.a.c r3 = r8.b
            r2.a((com.com.bytedance.overseas.sdk.a.c) r3)
            com.bytedance.sdk.openadsdk.api.nativeAd.PAGNativeAd r3 = r8.d
            r2.a((com.bytedance.sdk.openadsdk.api.nativeAd.PAGNativeAd) r3)
            r2.a((java.util.Map<java.lang.String, java.lang.Object>) r10)
            com.bytedance.sdk.openadsdk.core.l$2 r3 = new com.bytedance.sdk.openadsdk.core.l$2
            r3.<init>(r14)
            r2.a((com.bytedance.sdk.openadsdk.core.b.b.a) r3)
            com.bytedance.sdk.openadsdk.core.b.a r3 = new com.bytedance.sdk.openadsdk.core.b.a
            android.content.Context r4 = r8.c
            com.bytedance.sdk.openadsdk.core.model.n r5 = r8.a
            java.lang.String r6 = r8.f
            int r7 = com.bytedance.sdk.openadsdk.l.y.a((java.lang.String) r6)
            r3.<init>(r4, r5, r6, r7)
            r3.a((android.view.View) r9)
            r3.b((android.view.View) r13)
            com.com.bytedance.overseas.sdk.a.c r13 = r8.b
            r3.a((com.com.bytedance.overseas.sdk.a.c) r13)
            com.bytedance.sdk.openadsdk.api.nativeAd.PAGNativeAd r13 = r8.d
            r3.a((com.bytedance.sdk.openadsdk.api.nativeAd.PAGNativeAd) r13)
            r3.a((java.util.Map<java.lang.String, java.lang.Object>) r10)
            com.bytedance.sdk.openadsdk.core.l$3 r10 = new com.bytedance.sdk.openadsdk.core.l$3
            r10.<init>(r14)
            r3.a((com.bytedance.sdk.openadsdk.core.b.b.a) r10)
            r0.a(r11, r2)
            r0.a(r12, r3)
            com.bytedance.sdk.openadsdk.a.b.a r10 = r8.k
            if (r10 == 0) goto L_0x00e2
            android.widget.ImageView r10 = r10.a()
            if (r10 == 0) goto L_0x00e2
            com.bytedance.sdk.openadsdk.a.b.a r10 = r8.k
            android.widget.ImageView r10 = r10.a()
            r10.setOnClickListener(r3)
            com.bytedance.sdk.openadsdk.a.b.a r10 = r8.k
            android.widget.ImageView r10 = r10.a()
            r10.setOnTouchListener(r3)
        L_0x00e2:
            com.bytedance.sdk.openadsdk.a.b.a r10 = r8.k
            if (r10 == 0) goto L_0x00fe
            com.bytedance.sdk.openadsdk.api.nativeAd.PAGMediaView r10 = r10.b()
            if (r10 == 0) goto L_0x00fe
            com.bytedance.sdk.openadsdk.a.b.a r10 = r8.k
            com.bytedance.sdk.openadsdk.api.nativeAd.PAGMediaView r10 = r10.b()
            r10.setOnClickListener(r3)
            com.bytedance.sdk.openadsdk.a.b.a r10 = r8.k
            com.bytedance.sdk.openadsdk.api.nativeAd.PAGMediaView r10 = r10.b()
            r10.setOnTouchListener(r3)
        L_0x00fe:
            com.bytedance.sdk.openadsdk.a.b.a r10 = r8.k
            if (r10 == 0) goto L_0x0105
            r10.a((com.bytedance.sdk.openadsdk.core.b.a) r3)
        L_0x0105:
            com.bytedance.sdk.openadsdk.core.l$4 r10 = new com.bytedance.sdk.openadsdk.core.l$4
            r10.<init>(r9, r14)
            r0.setCallback(r10)
            r0.setNeedCheckingShow(r1)
        L_0x0110:
            r9 = 41
        L_0x0112:
            switch(r9) {
                case 40: goto L_0x019b;
                case 41: goto L_0x0116;
                case 42: goto L_0x0110;
                default: goto L_0x0115;
            }
        L_0x0115:
            goto L_0x0110
        L_0x0116:
            r9 = 27
            r10 = 40
            r11 = 55
            r12 = 39
            switch(r11) {
                case 54: goto L_0x0160;
                case 55: goto L_0x015e;
                case 56: goto L_0x0122;
                default: goto L_0x0121;
            }
        L_0x0121:
            goto L_0x0116
        L_0x0122:
            r10 = 99
            int r11 = r10 * r10
            int r11 = r11 * r10
            r13 = 16
            int r14 = r13 * r13
            int r14 = r14 * r13
            int r11 = r11 + r14
            int r11 = r11 + r14
            int r10 = r10 * r13
            int r10 = r10 * r13
            int r10 = r10 * 3
            if (r11 >= r10) goto L_0x0116
            r10 = 11
            if (r9 <= r10) goto L_0x0139
            goto L_0x0146
        L_0x0139:
            r10 = 96
            int r11 = r10 * r10
            int r13 = r12 * r12
            int r11 = r11 + r13
            int r10 = r10 * r12
            int r10 = r10 * 2
            int r11 = r11 - r10
            if (r11 >= 0) goto L_0x0116
        L_0x0146:
            r10 = 57
            r11 = 49
            r13 = 23
            int r14 = r10 * r10
            int r14 = r14 * r10
            int r0 = r11 * r11
            int r0 = r0 * r11
            int r14 = r14 + r0
            int r0 = r13 * r13
            int r0 = r0 * r13
            int r14 = r14 + r0
            int r10 = r10 * r11
            int r10 = r10 * r13
            int r10 = r10 * 3
            if (r14 >= r10) goto L_0x0116
            goto L_0x0164
        L_0x015e:
            r9 = r10
            goto L_0x0112
        L_0x0160:
            switch(r9) {
                case 89: goto L_0x0164;
                case 90: goto L_0x016d;
                case 91: goto L_0x0184;
                default: goto L_0x0163;
            }
        L_0x0163:
            goto L_0x019b
        L_0x0164:
            r10 = 52
            int r10 = r10 + r1
            int r10 = r10 * 52
            int r10 = r10 % 2
            if (r10 == 0) goto L_0x0116
        L_0x016d:
            r10 = 94
            r11 = 46
            r13 = 10
            int r14 = r10 * r10
            int r0 = r11 * r11
            int r14 = r14 + r0
            int r0 = r13 * r13
            int r14 = r14 + r0
            r0 = 94
            int r0 = r0 * r11
            int r11 = r11 * r13
            int r0 = r0 + r11
            int r10 = r10 * r13
            int r0 = r0 + r10
            if (r14 >= r0) goto L_0x0160
        L_0x0184:
            r9 = 8
            r10 = 25
            int r11 = r9 * r9
            int r13 = r12 * r12
            int r11 = r11 + r13
            int r13 = r10 * r10
            int r11 = r11 + r13
            r13 = 8
            int r13 = r13 * r12
            r12 = 39
            int r12 = r12 * r10
            int r13 = r13 + r12
            int r9 = r9 * r10
            int r13 = r13 + r9
            if (r11 >= r13) goto L_0x0116
        L_0x019b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.l.a(android.view.ViewGroup, java.util.List, java.util.List, java.util.List, android.view.View, com.bytedance.sdk.openadsdk.a.b.g):void");
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
    public void a(java.lang.Double r6) {
        /*
            r5 = this;
            r5.i = r6
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
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.l.a(java.lang.Double):void");
    }
}
