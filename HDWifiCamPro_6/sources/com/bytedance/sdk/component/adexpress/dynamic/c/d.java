package com.bytedance.sdk.component.adexpress.dynamic.c;

import android.text.TextUtils;
import com.bytedance.sdk.component.adexpress.dynamic.b.b;
import com.bytedance.sdk.component.adexpress.dynamic.b.f;
import com.bytedance.sdk.component.adexpress.dynamic.b.h;
import com.bytedance.sdk.component.adexpress.dynamic.b.i;
import com.bytedance.sdk.component.adexpress.dynamic.c.a;
import com.bytedance.sdk.component.utils.l;
import com.mbridge.msdk.MBridgeConstans;
import java.util.List;

/* compiled from: DynamicCanvas */
public class d {
    public b a;
    protected a b = new a();
    private h c;
    private a d;

    /* compiled from: DynamicCanvas */
    static class a {
        float a;
        float b;
        float c;

        a() {
        }
    }

    public void a(a aVar) {
        this.d = aVar;
    }

    public void a() {
        this.b.a();
    }

    public void a(h hVar, float f, float f2) {
        if (hVar != null) {
            this.c = hVar;
        }
        h hVar2 = this.c;
        float g = hVar2.g();
        float h = hVar2.h();
        float f3 = TextUtils.equals(hVar2.i().e().t(), "fixed") ? h : 65536.0f;
        this.b.a();
        this.b.c(hVar2, g, f3);
        a.c a2 = this.b.a(hVar2);
        b bVar = new b();
        bVar.a = f;
        bVar.b = f2;
        if (a2 != null) {
            g = a2.a;
        }
        bVar.c = g;
        if (a2 != null) {
            h = a2.b;
        }
        bVar.d = h;
        bVar.e = "root";
        bVar.i = 1280.0f;
        bVar.f = hVar2;
        bVar.f.c(bVar.a);
        bVar.f.d(bVar.b);
        bVar.f.e(bVar.c);
        bVar.f.f(bVar.d);
        this.a = a(bVar, 0.0f);
        a(this.a);
    }

    public void a(b bVar) {
        if (bVar != null) {
            l.b("DynamicCanvas", "native parser: type = " + bVar.f.i().b() + "; width = " + bVar.c + "; height = " + bVar.d + "; x = " + bVar.a + "; y = " + bVar.b);
            List<List<b>> list = bVar.g;
            if (list != null && list.size() > 0) {
                for (List<b> next : list) {
                    if (next != null && next.size() > 0) {
                        for (b a2 : next) {
                            a(a2);
                        }
                    }
                }
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:102:0x0253  */
    /* JADX WARNING: Removed duplicated region for block: B:137:0x0327  */
    /* JADX WARNING: Removed duplicated region for block: B:140:0x0331  */
    /* JADX WARNING: Removed duplicated region for block: B:144:0x03b3  */
    /* JADX WARNING: Removed duplicated region for block: B:148:0x03c7  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00e3  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x0203  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.bytedance.sdk.component.adexpress.dynamic.b.b a(com.bytedance.sdk.component.adexpress.dynamic.b.b r37, float r38) {
        /*
            r36 = this;
            r0 = r36
            r1 = r37
            com.bytedance.sdk.component.adexpress.dynamic.b.h r2 = r1.f
            if (r2 != 0) goto L_0x0009
            return r1
        L_0x0009:
            r2.r()
            java.util.List r3 = r2.p()
            if (r3 == 0) goto L_0x0401
            int r4 = r3.size()
            if (r4 > 0) goto L_0x001a
            goto L_0x0401
        L_0x001a:
            com.bytedance.sdk.component.adexpress.dynamic.b.e r4 = r2.i()
            com.bytedance.sdk.component.adexpress.dynamic.b.f r4 = r4.e()
            float r5 = r4.k()
            float r6 = r4.j()
            float r7 = r4.h()
            float r8 = r4.i()
            float r9 = r4.f()
            java.lang.String r10 = r4.z()
            java.lang.String r11 = r4.A()
            float r12 = r1.a
            float r12 = r12 + r8
            float r13 = r1.b
            float r13 = r13 + r5
            float r14 = r1.c
            float r14 = r14 - r8
            float r14 = r14 - r6
            r6 = 1073741824(0x40000000, float:2.0)
            float r9 = r9 * r6
            float r14 = r14 - r9
            float r8 = r1.d
            float r8 = r8 - r5
            float r8 = r8 - r7
            float r8 = r8 - r9
            com.bytedance.sdk.component.adexpress.dynamic.b.i r5 = new com.bytedance.sdk.component.adexpress.dynamic.b.i
            r5.<init>(r12, r13)
            java.util.List<java.util.List<com.bytedance.sdk.component.adexpress.dynamic.b.b>> r7 = r1.g
            if (r7 != 0) goto L_0x0061
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            r1.g = r7
        L_0x0061:
            java.util.Iterator r7 = r3.iterator()
            r13 = 0
        L_0x0066:
            boolean r15 = r7.hasNext()
            if (r15 == 0) goto L_0x007e
            java.lang.Object r15 = r7.next()
            java.util.List r15 = (java.util.List) r15
            com.bytedance.sdk.component.adexpress.dynamic.c.a r9 = r0.b
            com.bytedance.sdk.component.adexpress.dynamic.c.a$c r9 = r9.a((java.util.List<com.bytedance.sdk.component.adexpress.dynamic.b.h>) r15)
            if (r9 == 0) goto L_0x0066
            float r9 = r9.b
            float r13 = r13 + r9
            goto L_0x0066
        L_0x007e:
            int r7 = (r13 > r8 ? 1 : (r13 == r8 ? 0 : -1))
            java.lang.String r9 = "space-between"
            java.lang.String r15 = "space-around"
            java.lang.String r6 = "flex-end"
            r17 = r12
            java.lang.String r12 = "center"
            r18 = r4
            r4 = 1
            if (r7 >= 0) goto L_0x00d3
            boolean r7 = android.text.TextUtils.equals(r11, r12)
            if (r7 == 0) goto L_0x009b
            float r8 = r8 - r13
            r7 = 1073741824(0x40000000, float:2.0)
            float r8 = r8 / r7
            r7 = r8
            goto L_0x00d4
        L_0x009b:
            boolean r7 = android.text.TextUtils.equals(r11, r6)
            if (r7 == 0) goto L_0x00a4
            float r7 = r8 - r13
            goto L_0x00d4
        L_0x00a4:
            boolean r7 = android.text.TextUtils.equals(r11, r15)
            if (r7 == 0) goto L_0x00b8
            float r8 = r8 - r13
            int r7 = r3.size()
            int r7 = r7 + r4
            float r7 = (float) r7
            float r8 = r8 / r7
            float r7 = com.bytedance.sdk.component.adexpress.dynamic.c.i.a(r8)
            r8 = r7
            goto L_0x00d5
        L_0x00b8:
            boolean r7 = android.text.TextUtils.equals(r11, r9)
            if (r7 == 0) goto L_0x00d3
            int r7 = r3.size()
            if (r7 <= r4) goto L_0x00d3
            float r8 = r8 - r13
            int r7 = r3.size()
            int r7 = r7 - r4
            float r7 = (float) r7
            float r8 = r8 / r7
            float r7 = com.bytedance.sdk.component.adexpress.dynamic.c.i.a(r8)
            r8 = r7
            r7 = 0
            goto L_0x00d5
        L_0x00d3:
            r7 = 0
        L_0x00d4:
            r8 = 0
        L_0x00d5:
            float r11 = r5.b
            float r11 = r11 + r7
            r5.b = r11
            r13 = r38
            r11 = 0
        L_0x00dd:
            int r7 = r3.size()
            if (r11 >= r7) goto L_0x03ff
            java.lang.Object r7 = r3.get(r11)
            java.util.List r7 = (java.util.List) r7
            int r11 = r11 + 1
            java.util.List<java.util.List<com.bytedance.sdk.component.adexpress.dynamic.b.b>> r4 = r1.g
            int r4 = r4.size()
            if (r11 < r4) goto L_0x0119
            java.util.List<java.util.List<com.bytedance.sdk.component.adexpress.dynamic.b.b>> r4 = r1.g
            int r4 = r4.size()
            int r4 = r11 - r4
            r19 = 1
            int r4 = r4 + 1
            r20 = r3
            r3 = 0
        L_0x0102:
            if (r3 >= r4) goto L_0x011b
            r38 = r4
            java.util.List<java.util.List<com.bytedance.sdk.component.adexpress.dynamic.b.b>> r4 = r1.g
            r21 = r13
            java.util.ArrayList r13 = new java.util.ArrayList
            r13.<init>()
            r4.add(r13)
            int r3 = r3 + 1
            r4 = r38
            r13 = r21
            goto L_0x0102
        L_0x0119:
            r20 = r3
        L_0x011b:
            r21 = r13
            java.util.Iterator r3 = r7.iterator()
            r4 = 0
        L_0x0122:
            boolean r13 = r3.hasNext()
            r22 = r8
            if (r13 == 0) goto L_0x0163
            java.lang.Object r13 = r3.next()
            com.bytedance.sdk.component.adexpress.dynamic.b.h r13 = (com.bytedance.sdk.component.adexpress.dynamic.b.h) r13
            com.bytedance.sdk.component.adexpress.dynamic.b.e r23 = r13.i()
            com.bytedance.sdk.component.adexpress.dynamic.b.f r23 = r23.e()
            java.lang.String r8 = r23.u()
            r24 = r3
            int r3 = r23.M()
            java.lang.String r1 = "flex"
            boolean r1 = android.text.TextUtils.equals(r8, r1)
            if (r1 != 0) goto L_0x015c
            r1 = 1
            if (r3 == r1) goto L_0x015c
            r1 = 2
            if (r3 != r1) goto L_0x0151
            goto L_0x015c
        L_0x0151:
            com.bytedance.sdk.component.adexpress.dynamic.c.a r1 = r0.b
            com.bytedance.sdk.component.adexpress.dynamic.c.a$c r1 = r1.a((com.bytedance.sdk.component.adexpress.dynamic.b.h) r13)
            if (r1 == 0) goto L_0x015c
            float r1 = r1.a
            float r4 = r4 + r1
        L_0x015c:
            r1 = r37
            r8 = r22
            r3 = r24
            goto L_0x0122
        L_0x0163:
            float r1 = r14 - r4
            r3 = 0
            float r1 = java.lang.Math.max(r1, r3)
            java.util.Iterator r4 = r7.iterator()
            r8 = r3
        L_0x016f:
            boolean r13 = r4.hasNext()
            if (r13 == 0) goto L_0x01a3
            java.lang.Object r13 = r4.next()
            com.bytedance.sdk.component.adexpress.dynamic.b.h r13 = (com.bytedance.sdk.component.adexpress.dynamic.b.h) r13
            com.bytedance.sdk.component.adexpress.dynamic.b.e r16 = r13.i()
            com.bytedance.sdk.component.adexpress.dynamic.b.f r16 = r16.e()
            int r3 = r16.M()
            r24 = r4
            r4 = 1
            if (r3 == r4) goto L_0x019f
            int r3 = r16.M()
            r4 = 2
            if (r3 != r4) goto L_0x0194
            goto L_0x019f
        L_0x0194:
            com.bytedance.sdk.component.adexpress.dynamic.c.a r3 = r0.b
            com.bytedance.sdk.component.adexpress.dynamic.c.a$c r3 = r3.a((com.bytedance.sdk.component.adexpress.dynamic.b.h) r13)
            if (r3 == 0) goto L_0x019f
            float r3 = r3.a
            float r8 = r8 + r3
        L_0x019f:
            r4 = r24
            r3 = 0
            goto L_0x016f
        L_0x01a3:
            int r3 = (r8 > r14 ? 1 : (r8 == r14 ? 0 : -1))
            if (r3 >= 0) goto L_0x01f1
            boolean r3 = android.text.TextUtils.equals(r10, r12)
            if (r3 == 0) goto L_0x01b3
            float r3 = r14 - r8
            r4 = 1073741824(0x40000000, float:2.0)
            float r3 = r3 / r4
            goto L_0x01f2
        L_0x01b3:
            boolean r3 = android.text.TextUtils.equals(r10, r6)
            if (r3 == 0) goto L_0x01bc
            float r3 = r14 - r8
            goto L_0x01f2
        L_0x01bc:
            boolean r3 = android.text.TextUtils.equals(r10, r15)
            if (r3 == 0) goto L_0x01d2
            float r3 = r14 - r8
            int r4 = r7.size()
            r13 = 1
            int r4 = r4 + r13
            float r4 = (float) r4
            float r3 = r3 / r4
            float r3 = com.bytedance.sdk.component.adexpress.dynamic.c.i.a(r3)
            r4 = r3
            goto L_0x01f3
        L_0x01d2:
            r13 = 1
            boolean r3 = android.text.TextUtils.equals(r10, r9)
            if (r3 == 0) goto L_0x01f1
            int r3 = r7.size()
            if (r3 <= r13) goto L_0x01f1
            float r3 = r14 - r8
            int r4 = r7.size()
            float r4 = (float) r4
            r8 = 1065353216(0x3f800000, float:1.0)
            float r4 = r4 - r8
            float r3 = r3 / r4
            float r3 = com.bytedance.sdk.component.adexpress.dynamic.c.i.a(r3)
            r4 = r3
            r3 = 0
            goto L_0x01f3
        L_0x01f1:
            r3 = 0
        L_0x01f2:
            r4 = 0
        L_0x01f3:
            float r8 = r5.a
            float r8 = r8 + r3
            r5.a = r8
            java.util.Iterator r3 = r7.iterator()
            r8 = 0
        L_0x01fd:
            boolean r13 = r3.hasNext()
            if (r13 == 0) goto L_0x0245
            java.lang.Object r13 = r3.next()
            com.bytedance.sdk.component.adexpress.dynamic.b.h r13 = (com.bytedance.sdk.component.adexpress.dynamic.b.h) r13
            r16 = r3
            com.bytedance.sdk.component.adexpress.dynamic.c.a r3 = r0.b
            com.bytedance.sdk.component.adexpress.dynamic.c.a$c r3 = r3.a((com.bytedance.sdk.component.adexpress.dynamic.b.h) r13)
            if (r3 == 0) goto L_0x021c
            com.bytedance.sdk.component.adexpress.dynamic.c.a r3 = r0.b
            com.bytedance.sdk.component.adexpress.dynamic.c.a$c r3 = r3.a((com.bytedance.sdk.component.adexpress.dynamic.b.h) r13)
            float r3 = r3.b
            goto L_0x021d
        L_0x021c:
            r3 = 0
        L_0x021d:
            com.bytedance.sdk.component.adexpress.dynamic.b.e r13 = r13.i()
            com.bytedance.sdk.component.adexpress.dynamic.b.f r13 = r13.e()
            r24 = r3
            int r3 = r13.M()
            r25 = r9
            r9 = 1
            if (r3 == r9) goto L_0x023b
            int r3 = r13.M()
            r9 = 2
            if (r3 != r9) goto L_0x0238
            goto L_0x023b
        L_0x0238:
            r3 = r24
            goto L_0x023c
        L_0x023b:
            r3 = 0
        L_0x023c:
            float r8 = java.lang.Math.max(r8, r3)
            r3 = r16
            r9 = r25
            goto L_0x01fd
        L_0x0245:
            r25 = r9
            java.util.Iterator r3 = r7.iterator()
            r13 = r21
        L_0x024d:
            boolean r9 = r3.hasNext()
            if (r9 == 0) goto L_0x03da
            java.lang.Object r9 = r3.next()
            com.bytedance.sdk.component.adexpress.dynamic.b.h r9 = (com.bytedance.sdk.component.adexpress.dynamic.b.h) r9
            r16 = r3
            com.bytedance.sdk.component.adexpress.dynamic.c.a r3 = r0.b
            com.bytedance.sdk.component.adexpress.dynamic.c.a$c r3 = r3.a((com.bytedance.sdk.component.adexpress.dynamic.b.h) r9)
            com.bytedance.sdk.component.adexpress.dynamic.b.e r21 = r9.i()
            r24 = r10
            com.bytedance.sdk.component.adexpress.dynamic.b.f r10 = r21.e()
            r21 = r13
            int r13 = r10.D()
            float r13 = (float) r13
            r26 = r14
            int r14 = r10.G()
            float r14 = (float) r14
            r27 = r15
            int r15 = r10.E()
            float r15 = (float) r15
            r28 = r4
            int r4 = r10.F()
            float r4 = (float) r4
            r29 = r5
            if (r3 != 0) goto L_0x028d
            r5 = 0
            goto L_0x028f
        L_0x028d:
            float r5 = r3.a
        L_0x028f:
            if (r3 != 0) goto L_0x0295
            r30 = r7
            r3 = 0
            goto L_0x0299
        L_0x0295:
            float r3 = r3.b
            r30 = r7
        L_0x0299:
            java.lang.String r7 = r2.b()
            r31 = r2
            java.lang.String r2 = "root"
            boolean r2 = android.text.TextUtils.equals(r7, r2)
            if (r2 == 0) goto L_0x02a9
            float r2 = (float) r11
            goto L_0x02ab
        L_0x02a9:
            r2 = r21
        L_0x02ab:
            int r7 = r10.M()
            r32 = r11
            r11 = 1
            if (r7 != r11) goto L_0x02c3
            float r7 = r5 - r14
            float r7 = r7 - r4
            float r11 = r3 - r13
            float r11 = r11 - r15
            r21 = r2
            r2 = r37
            com.bytedance.sdk.component.adexpress.dynamic.b.i r7 = r0.a(r2, r10, r7, r11)
            goto L_0x02c9
        L_0x02c3:
            r21 = r2
            r2 = r37
            r7 = r29
        L_0x02c9:
            int r11 = r10.M()
            r33 = r7
            r7 = 2
            if (r11 != r7) goto L_0x02ef
            com.bytedance.sdk.component.adexpress.dynamic.c.a r7 = r0.b
            com.bytedance.sdk.component.adexpress.dynamic.b.h r11 = r0.c
            com.bytedance.sdk.component.adexpress.dynamic.c.a$c r7 = r7.a((com.bytedance.sdk.component.adexpress.dynamic.b.h) r11)
            float r11 = r5 - r14
            float r11 = r11 - r4
            float r33 = r3 - r13
            r34 = r1
            float r1 = r33 - r15
            r35 = r9
            com.bytedance.sdk.component.adexpress.dynamic.c.a$c r9 = new com.bytedance.sdk.component.adexpress.dynamic.c.a$c
            r9.<init>(r11, r1)
            com.bytedance.sdk.component.adexpress.dynamic.b.i r7 = r0.a((com.bytedance.sdk.component.adexpress.dynamic.b.f) r10, (com.bytedance.sdk.component.adexpress.dynamic.c.a.c) r7, (com.bytedance.sdk.component.adexpress.dynamic.c.a.c) r9)
            goto L_0x02f5
        L_0x02ef:
            r34 = r1
            r35 = r9
            r7 = r33
        L_0x02f5:
            java.lang.String r1 = r18.ab()
            int r9 = (r8 > r3 ? 1 : (r8 == r3 ? 0 : -1))
            if (r9 <= 0) goto L_0x0337
            java.lang.String r9 = "flex-start"
            boolean r9 = android.text.TextUtils.equals(r1, r9)
            if (r9 != 0) goto L_0x0337
            int r11 = r1.hashCode()
            r9 = -1364013995(0xffffffffaeb2cc55, float:-8.1307995E-11)
            if (r11 == r9) goto L_0x031c
            r9 = 1742952711(0x67e35907, float:2.1472389E24)
            if (r11 == r9) goto L_0x0314
            goto L_0x0324
        L_0x0314:
            boolean r1 = r1.equals(r6)
            if (r1 == 0) goto L_0x0324
            r1 = 1
            goto L_0x0325
        L_0x031c:
            boolean r1 = r1.equals(r12)
            if (r1 == 0) goto L_0x0324
            r1 = 0
            goto L_0x0325
        L_0x0324:
            r1 = -1
        L_0x0325:
            if (r1 == 0) goto L_0x0331
            r9 = 1
            if (r1 == r9) goto L_0x032b
            goto L_0x0337
        L_0x032b:
            float r9 = r8 - r3
            r1 = r9
            r9 = 1073741824(0x40000000, float:2.0)
            goto L_0x033a
        L_0x0331:
            float r1 = r8 - r3
            r9 = 1073741824(0x40000000, float:2.0)
            float r1 = r1 / r9
            goto L_0x033a
        L_0x0337:
            r9 = 1073741824(0x40000000, float:2.0)
            r1 = 0
        L_0x033a:
            com.bytedance.sdk.component.adexpress.dynamic.b.b r11 = new com.bytedance.sdk.component.adexpress.dynamic.b.b
            r11.<init>()
            float r9 = r7.a
            float r9 = r9 + r4
            r11.a = r9
            float r7 = r7.b
            float r7 = r7 + r13
            float r7 = r7 + r1
            r11.b = r7
            float r1 = r5 - r14
            float r1 = r1 - r4
            r11.c = r1
            float r3 = r3 - r13
            float r3 = r3 - r15
            r11.d = r3
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r3 = r2.e
            r1.append(r3)
            java.lang.String r3 = "."
            r1.append(r3)
            java.lang.String r3 = r35.b()
            r1.append(r3)
            java.lang.String r1 = r1.toString()
            r11.e = r1
            r11.h = r2
            r9 = r35
            r11.f = r9
            r1 = r34
            r11.i = r1
            r7 = r30
            r11.j = r7
            com.bytedance.sdk.component.adexpress.dynamic.b.h r3 = r11.f
            float r4 = r11.a
            r3.c(r4)
            com.bytedance.sdk.component.adexpress.dynamic.b.h r3 = r11.f
            float r4 = r11.b
            r3.d(r4)
            com.bytedance.sdk.component.adexpress.dynamic.b.h r3 = r11.f
            float r4 = r11.c
            r3.e(r4)
            com.bytedance.sdk.component.adexpress.dynamic.b.h r3 = r11.f
            float r4 = r11.d
            r3.f(r4)
            r3 = r21
            com.bytedance.sdk.component.adexpress.dynamic.b.b r4 = r0.a(r11, r3)
            java.util.List<java.util.List<com.bytedance.sdk.component.adexpress.dynamic.b.b>> r9 = r2.g
            r11 = r32
            java.lang.Object r9 = r9.get(r11)
            java.util.List r9 = (java.util.List) r9
            r9.add(r4)
            int r4 = r10.M()
            r9 = 1
            if (r4 == r9) goto L_0x03c7
            int r4 = r10.M()
            r10 = 2
            if (r4 == r10) goto L_0x03c4
            r4 = r29
            float r13 = r4.a
            float r5 = r5 + r28
            float r13 = r13 + r5
            r4.a = r13
            goto L_0x03ca
        L_0x03c4:
            r4 = r29
            goto L_0x03ca
        L_0x03c7:
            r4 = r29
            r10 = 2
        L_0x03ca:
            r13 = r3
            r5 = r4
            r3 = r16
            r10 = r24
            r14 = r26
            r15 = r27
            r4 = r28
            r2 = r31
            goto L_0x024d
        L_0x03da:
            r31 = r2
            r4 = r5
            r24 = r10
            r21 = r13
            r26 = r14
            r27 = r15
            r3 = r17
            r9 = 1
            r2 = r37
            r4.a = r3
            float r1 = r4.b
            float r8 = r8 + r22
            float r1 = r1 + r8
            r4.b = r1
            r1 = r2
            r4 = r9
            r3 = r20
            r8 = r22
            r9 = r25
            r2 = r31
            goto L_0x00dd
        L_0x03ff:
            r2 = r1
            return r2
        L_0x0401:
            r2 = r1
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.adexpress.dynamic.c.d.a(com.bytedance.sdk.component.adexpress.dynamic.b.b, float):com.bytedance.sdk.component.adexpress.dynamic.b.b");
    }

    private i a(f fVar, a.c cVar, a.c cVar2) {
        float X = (float) fVar.X();
        float Z = (float) fVar.Z();
        float Y = (float) fVar.Y();
        float aa = (float) fVar.aa();
        boolean O = fVar.O();
        boolean P = fVar.P();
        boolean Q = fVar.Q();
        boolean R = fVar.R();
        if (!O) {
            if (P) {
                X = ((this.d.a != 0.0f ? this.d.a : cVar.a) - Y) - cVar2.a;
            } else {
                X = 0.0f;
            }
        }
        if (!Q) {
            if (R) {
                Z = ((this.d.b != 0.0f ? this.d.b : cVar.b) - aa) - cVar2.b;
            } else {
                Z = 0.0f;
            }
        }
        return new i(X, Z);
    }

    private i a(b bVar, f fVar, float f, float f2) {
        float f3;
        float f4;
        b bVar2 = bVar;
        float f5 = bVar2.a;
        float f6 = bVar2.b;
        float X = (float) fVar.X();
        float Z = (float) fVar.Z();
        float Y = (float) fVar.Y();
        float aa = (float) fVar.aa();
        boolean O = fVar.O();
        boolean P = fVar.P();
        boolean Q = fVar.Q();
        boolean R = fVar.R();
        String N = fVar.N();
        float f7 = bVar2.c;
        float f8 = bVar2.d;
        if (TextUtils.equals(N, MBridgeConstans.ENDCARD_URL_TYPE_PL)) {
            if (O) {
                f5 = bVar2.a + X;
            } else if (P) {
                f5 = ((bVar2.a + f7) - Y) - f;
            }
            if (Q) {
                f4 = bVar2.b;
            } else {
                if (R) {
                    f3 = bVar2.b;
                    f6 = ((f3 + f8) - aa) - f2;
                }
                return new i(f5, f6);
            }
        } else {
            if (TextUtils.equals(N, "1")) {
                f5 = bVar2.a + ((f7 - f) / 2.0f);
                if (Q) {
                    f4 = bVar2.b;
                } else if (R) {
                    f3 = bVar2.b;
                    f6 = ((f3 + f8) - aa) - f2;
                }
            } else if (TextUtils.equals(N, "2")) {
                f6 = bVar2.b + ((f8 - f2) / 2.0f);
                if (O) {
                    f5 = bVar2.a + X;
                } else if (P) {
                    f5 = ((bVar2.a + f7) - Y) - f;
                }
            } else if (TextUtils.equals(N, MBridgeConstans.ORIGINAL_VIEW_TYPE_SINGLE_STR_3)) {
                f5 = bVar2.a + ((f7 - f) / 2.0f);
                f6 = bVar2.b + ((f8 - f2) / 2.0f);
            }
            return new i(f5, f6);
        }
        f6 = f4 + Z;
        return new i(f5, f6);
    }
}
