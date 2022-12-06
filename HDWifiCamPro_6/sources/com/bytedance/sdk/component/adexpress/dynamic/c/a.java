package com.bytedance.sdk.component.adexpress.dynamic.c;

import android.text.TextUtils;
import com.bytedance.sdk.component.adexpress.dynamic.b.f;
import com.bytedance.sdk.component.adexpress.dynamic.b.h;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ComputeRuler */
public class a {
    public Map<String, c> a = new HashMap();
    public Map<String, c> b = new HashMap();
    public Map<String, c> c = new HashMap();
    private double d = Math.random();

    /* JADX WARNING: Removed duplicated region for block: B:29:0x00c1  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00db  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.bytedance.sdk.component.adexpress.dynamic.c.a.c a(com.bytedance.sdk.component.adexpress.dynamic.b.h r13, float r14, float r15) {
        /*
            r12 = this;
            com.bytedance.sdk.component.adexpress.dynamic.b.e r0 = r13.i()
            java.lang.String r0 = r0.c()
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            r1 = 0
            if (r0 == 0) goto L_0x0023
            com.bytedance.sdk.component.adexpress.dynamic.b.e r0 = r13.i()
            com.bytedance.sdk.component.adexpress.dynamic.b.f r0 = r0.e()
            java.lang.String r0 = r0.S()
            if (r0 != 0) goto L_0x0023
            com.bytedance.sdk.component.adexpress.dynamic.c.a$c r13 = new com.bytedance.sdk.component.adexpress.dynamic.c.a$c
            r13.<init>(r1, r1)
            return r13
        L_0x0023:
            com.bytedance.sdk.component.adexpress.dynamic.b.e r0 = r13.i()
            java.lang.String r0 = r0.b()
            java.lang.String r2 = "creative-playable-bait"
            boolean r0 = android.text.TextUtils.equals(r0, r2)
            if (r0 == 0) goto L_0x0039
            com.bytedance.sdk.component.adexpress.dynamic.c.a$c r13 = new com.bytedance.sdk.component.adexpress.dynamic.c.a$c
            r13.<init>(r1, r1)
            return r13
        L_0x0039:
            float r0 = r13.g()
            float r1 = r13.h()
            com.bytedance.sdk.component.adexpress.dynamic.b.e r2 = r13.i()
            com.bytedance.sdk.component.adexpress.dynamic.b.f r2 = r2.e()
            java.lang.String r3 = r2.u()
            java.lang.String r2 = r2.t()
            int r4 = r13.l()
            float r4 = (float) r4
            int r5 = r13.m()
            float r5 = (float) r5
            float r6 = r13.n()
            float r7 = r13.o()
            java.lang.String r8 = "fixed"
            boolean r9 = android.text.TextUtils.equals(r3, r8)
            java.lang.String r10 = "flex"
            java.lang.String r11 = "auto"
            if (r9 == 0) goto L_0x0086
            float r14 = java.lang.Math.min(r0, r14)
            boolean r0 = android.text.TextUtils.equals(r2, r11)
            if (r0 == 0) goto L_0x00b9
            float r0 = r14 - r6
            float r1 = r15 - r7
            com.bytedance.sdk.component.adexpress.dynamic.c.a$c r13 = r12.b((com.bytedance.sdk.component.adexpress.dynamic.b.h) r13, (float) r0, (float) r1)
            float r13 = r13.b
        L_0x0083:
            float r13 = r13 + r7
            r1 = r13
            goto L_0x00b9
        L_0x0086:
            boolean r9 = android.text.TextUtils.equals(r3, r11)
            if (r9 == 0) goto L_0x00a1
            float r14 = r14 - r6
            float r0 = r15 - r7
            com.bytedance.sdk.component.adexpress.dynamic.c.a$c r13 = r12.b((com.bytedance.sdk.component.adexpress.dynamic.b.h) r13, (float) r14, (float) r0)
            float r14 = r13.a
            float r14 = r14 + r6
            boolean r0 = android.text.TextUtils.equals(r2, r11)
            if (r0 == 0) goto L_0x00b9
            float r13 = r13.b
            float r1 = r13 + r7
            goto L_0x00b9
        L_0x00a1:
            boolean r3 = android.text.TextUtils.equals(r3, r10)
            if (r3 == 0) goto L_0x00b8
            boolean r0 = android.text.TextUtils.equals(r2, r11)
            if (r0 == 0) goto L_0x00b9
            float r0 = r14 - r6
            float r1 = r15 - r7
            com.bytedance.sdk.component.adexpress.dynamic.c.a$c r13 = r12.b((com.bytedance.sdk.component.adexpress.dynamic.b.h) r13, (float) r0, (float) r1)
            float r13 = r13.b
            goto L_0x0083
        L_0x00b8:
            r14 = r0
        L_0x00b9:
            java.lang.String r13 = "scale"
            boolean r13 = android.text.TextUtils.equals(r2, r13)
            if (r13 == 0) goto L_0x00db
            float r13 = r14 - r4
            float r13 = r13 / r1
            int r13 = java.lang.Math.round(r13)
            float r13 = (float) r13
            float r13 = r13 + r5
            int r0 = (r13 > r15 ? 1 : (r13 == r15 ? 0 : -1))
            if (r0 <= 0) goto L_0x00d9
            float r13 = r15 - r5
            float r13 = r13 * r1
            int r13 = java.lang.Math.round(r13)
            float r13 = (float) r13
            float r14 = r13 + r4
            goto L_0x00ef
        L_0x00d9:
            r15 = r13
            goto L_0x00ef
        L_0x00db:
            boolean r13 = android.text.TextUtils.equals(r2, r8)
            if (r13 == 0) goto L_0x00e7
            float r1 = r1 + r5
            float r15 = java.lang.Math.min(r1, r15)
            goto L_0x00ef
        L_0x00e7:
            boolean r13 = android.text.TextUtils.equals(r2, r10)
            if (r13 == 0) goto L_0x00ee
            goto L_0x00ef
        L_0x00ee:
            r15 = r1
        L_0x00ef:
            com.bytedance.sdk.component.adexpress.dynamic.c.a$c r13 = new com.bytedance.sdk.component.adexpress.dynamic.c.a$c
            r13.<init>()
            r13.a = r14
            r13.b = r15
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.adexpress.dynamic.c.a.a(com.bytedance.sdk.component.adexpress.dynamic.b.h, float, float):com.bytedance.sdk.component.adexpress.dynamic.c.a$c");
    }

    public c b(h hVar, float f, float f2) {
        c cVar = new c();
        if (hVar.i().e() == null) {
            return cVar;
        }
        c e = e(hVar, f, f2);
        float f3 = e.a;
        float f4 = e.b;
        cVar.a = Math.min(f3, f);
        cVar.b = Math.min(f4, f2);
        return cVar;
    }

    private c e(h hVar, float f, float f2) {
        String str = hVar.b() + "_" + f + "_" + f2;
        if (this.c.containsKey(str)) {
            return this.c.get(str);
        }
        c f3 = f(hVar, f, f2);
        this.c.put(str, f3);
        return f3;
    }

    private c f(h hVar, float f, float f2) {
        new c();
        f e = hVar.i().e();
        hVar.i().c();
        e.J();
        float l = e.l();
        int I = e.I();
        double H = e.H();
        int K = e.K();
        boolean B = e.B();
        boolean L = e.L();
        int C = e.C();
        b bVar = new b();
        bVar.a = l;
        bVar.b = I;
        bVar.c = K;
        bVar.d = H;
        bVar.e = f;
        return a(hVar.i().c(), bVar, B, L, C, hVar);
    }

    private c a(String str, b bVar, boolean z, boolean z2, int i, h hVar) {
        return j.a(str, hVar.i().b(), b.a(bVar).toString(), z, z2, i);
    }

    public c c(h hVar, float f, float f2) {
        if (hVar == null) {
            return null;
        }
        c a2 = a(hVar);
        if (a2 != null && (a2.a != 0.0f || a2.b != 0.0f)) {
            return a2;
        }
        c d2 = d(hVar, f, f2);
        a(hVar, d2);
        return d2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x009c  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00cd  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00ef  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00f6  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x0101  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.bytedance.sdk.component.adexpress.dynamic.c.a.c d(com.bytedance.sdk.component.adexpress.dynamic.b.h r19, float r20, float r21) {
        /*
            r18 = this;
            r0 = r18
            r1 = r20
            r2 = r21
            com.bytedance.sdk.component.adexpress.dynamic.c.a$c r3 = new com.bytedance.sdk.component.adexpress.dynamic.c.a$c
            r3.<init>()
            r4 = 0
            int r5 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r5 <= 0) goto L_0x0127
            int r5 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1))
            if (r5 > 0) goto L_0x0016
            goto L_0x0127
        L_0x0016:
            boolean r5 = r19.q()
            if (r5 == 0) goto L_0x0021
            com.bytedance.sdk.component.adexpress.dynamic.c.a$c r1 = r18.a((com.bytedance.sdk.component.adexpress.dynamic.b.h) r19, (float) r20, (float) r21)
            return r1
        L_0x0021:
            float r5 = r19.g()
            float r6 = r19.h()
            float r7 = r19.n()
            float r8 = r19.o()
            com.bytedance.sdk.component.adexpress.dynamic.b.e r9 = r19.i()
            com.bytedance.sdk.component.adexpress.dynamic.b.f r9 = r9.e()
            java.lang.String r10 = r9.u()
            java.lang.String r9 = r9.t()
            java.lang.String r11 = "flex"
            boolean r12 = android.text.TextUtils.equals(r10, r11)
            java.lang.String r13 = "auto"
            if (r12 != 0) goto L_0x0057
            boolean r12 = android.text.TextUtils.equals(r10, r13)
            if (r12 == 0) goto L_0x0052
            goto L_0x0057
        L_0x0052:
            float r5 = java.lang.Math.min(r5, r1)
            goto L_0x0058
        L_0x0057:
            r5 = r1
        L_0x0058:
            float r5 = r5 - r7
            java.lang.String r12 = "scale"
            boolean r12 = android.text.TextUtils.equals(r9, r12)
            if (r12 == 0) goto L_0x0076
            float r12 = r5 / r6
            int r12 = java.lang.Math.round(r12)
            float r12 = (float) r12
            float r12 = r12 + r8
            int r14 = (r12 > r2 ? 1 : (r12 == r2 ? 0 : -1))
            if (r14 <= 0) goto L_0x008a
            float r5 = r2 - r8
            float r5 = r5 * r6
            int r5 = java.lang.Math.round(r5)
            float r5 = (float) r5
            goto L_0x0089
        L_0x0076:
            boolean r12 = android.text.TextUtils.equals(r9, r13)
            if (r12 != 0) goto L_0x0089
            boolean r12 = android.text.TextUtils.equals(r9, r11)
            if (r12 == 0) goto L_0x0083
            goto L_0x0089
        L_0x0083:
            float r6 = java.lang.Math.min(r6, r2)
            r12 = r6
            goto L_0x008a
        L_0x0089:
            r12 = r2
        L_0x008a:
            float r12 = r12 - r8
            java.util.List r6 = r19.p()
            java.util.Iterator r14 = r6.iterator()
            r15 = r4
            r16 = r15
        L_0x0096:
            boolean r17 = r14.hasNext()
            if (r17 == 0) goto L_0x00c5
            java.lang.Object r17 = r14.next()
            r19 = r14
            r14 = r17
            java.util.List r14 = (java.util.List) r14
            r17 = r3
            com.bytedance.sdk.component.adexpress.dynamic.c.a$c r3 = r0.b((java.util.List<com.bytedance.sdk.component.adexpress.dynamic.b.h>) r14, (float) r5, (float) r12)
            boolean r14 = r0.b((java.util.List<com.bytedance.sdk.component.adexpress.dynamic.b.h>) r14)
            if (r14 == 0) goto L_0x00b6
            r14 = 1065353216(0x3f800000, float:1.0)
            float r4 = r4 + r14
            goto L_0x00bc
        L_0x00b6:
            float r14 = r3.a
            float r15 = java.lang.Math.max(r15, r14)
        L_0x00bc:
            float r3 = r3.b
            float r16 = r16 + r3
            r14 = r19
            r3 = r17
            goto L_0x0096
        L_0x00c5:
            r17 = r3
            boolean r3 = android.text.TextUtils.equals(r10, r13)
            if (r3 == 0) goto L_0x00ef
            int r3 = r6.size()
            float r3 = (float) r3
            int r3 = (r4 > r3 ? 1 : (r4 == r3 ? 0 : -1))
            if (r3 != 0) goto L_0x00d8
            r15 = r1
            goto L_0x00f0
        L_0x00d8:
            java.util.Iterator r3 = r6.iterator()
        L_0x00dc:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x00f0
            java.lang.Object r4 = r3.next()
            java.util.List r4 = (java.util.List) r4
            r0.c((java.util.List<com.bytedance.sdk.component.adexpress.dynamic.b.h>) r4)
            r0.b((java.util.List<com.bytedance.sdk.component.adexpress.dynamic.b.h>) r4, (float) r15, (float) r12)
            goto L_0x00dc
        L_0x00ef:
            r15 = r5
        L_0x00f0:
            boolean r3 = android.text.TextUtils.equals(r9, r13)
            if (r3 == 0) goto L_0x0101
            int r3 = (r16 > r2 ? 1 : (r16 == r2 ? 0 : -1))
            if (r3 > 0) goto L_0x00fd
            r12 = r16
            goto L_0x0116
        L_0x00fd:
            r0.a((java.util.List<java.util.List<com.bytedance.sdk.component.adexpress.dynamic.b.h>>) r6, (float) r15, (float) r12)
            goto L_0x0116
        L_0x0101:
            java.lang.String r3 = "fixed"
            boolean r3 = android.text.TextUtils.equals(r9, r3)
            if (r3 != 0) goto L_0x010f
            boolean r3 = android.text.TextUtils.equals(r9, r11)
            if (r3 == 0) goto L_0x0116
        L_0x010f:
            int r3 = (r12 > r16 ? 1 : (r12 == r16 ? 0 : -1))
            if (r3 >= 0) goto L_0x0116
            r0.a((java.util.List<java.util.List<com.bytedance.sdk.component.adexpress.dynamic.b.h>>) r6, (float) r15, (float) r12)
        L_0x0116:
            float r15 = r15 + r7
            float r12 = r12 + r8
            float r1 = java.lang.Math.min(r15, r1)
            r3 = r17
            r3.a = r1
            float r1 = java.lang.Math.min(r12, r2)
            r3.b = r1
            return r3
        L_0x0127:
            r3.a = r4
            r3.b = r4
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.adexpress.dynamic.c.a.d(com.bytedance.sdk.component.adexpress.dynamic.b.h, float, float):com.bytedance.sdk.component.adexpress.dynamic.c.a$c");
    }

    private void a(List<List<h>> list, float f, float f2) {
        float f3;
        if (list != null && list.size() > 0) {
            boolean z = false;
            for (List<h> a2 : list) {
                if (a(a2, false)) {
                    z = true;
                }
            }
            ArrayList arrayList = new ArrayList();
            for (List next : list) {
                C0027a aVar = new C0027a();
                boolean a3 = a((List<h>) next, !z);
                c b2 = b((List<h>) next, f, f2);
                if (a3) {
                    f3 = 1.0f;
                } else {
                    f3 = b2.b;
                }
                aVar.a = f3;
                aVar.b = !a3;
                arrayList.add(aVar);
            }
            List<C0027a> a4 = i.a(f2, arrayList);
            for (int i = 0; i < list.size(); i++) {
                if (((C0027a) arrayList.get(i)).a != a4.get(i).a) {
                    List list2 = list.get(i);
                    c((List<h>) list2);
                    b((List<h>) list2, f, a4.get(i).a);
                }
            }
        }
    }

    private boolean b(List<h> list) {
        boolean z;
        List<List<h>> p;
        Iterator<h> it = list.iterator();
        while (true) {
            if (it.hasNext()) {
                if (TextUtils.equals(it.next().i().e().u(), "flex")) {
                    z = true;
                    break;
                }
            } else {
                z = false;
                break;
            }
        }
        if (z) {
            return true;
        }
        Iterator<h> it2 = list.iterator();
        while (true) {
            boolean z2 = false;
            while (true) {
                if (!it2.hasNext()) {
                    return z2;
                }
                h next = it2.next();
                if (TextUtils.equals(next.i().e().u(), "auto") && (p = next.p()) != null) {
                    Iterator<List<h>> it3 = p.iterator();
                    boolean z3 = z2;
                    int i = 0;
                    while (true) {
                        if (!it3.hasNext()) {
                            z2 = z3;
                            break;
                        }
                        List next2 = it3.next();
                        i++;
                        if (b((List<h>) next2)) {
                            if (i == next2.size()) {
                                z3 = true;
                            }
                        }
                    }
                }
            }
        }
    }

    private c b(List<h> list, float f, float f2) {
        c a2 = a(list);
        if (a2 != null && (a2.a != 0.0f || a2.b != 0.0f)) {
            return a2;
        }
        c c2 = c(list, f, f2);
        a(list, c2);
        return c2;
    }

    private c c(List<h> list, float f, float f2) {
        float f3;
        d(list);
        c cVar = new c();
        ArrayList<h> arrayList = new ArrayList<>();
        ArrayList<h> arrayList2 = new ArrayList<>();
        for (h next : list) {
            f e = next.i().e();
            if (e.M() == 1 || e.M() == 2) {
                arrayList.add(next);
            }
            if (!(e.M() == 1 || e.M() == 2)) {
                arrayList2.add(next);
            }
        }
        for (h c2 : arrayList) {
            c(c2, f, f2);
        }
        if (arrayList2.size() <= 0) {
            return cVar;
        }
        ArrayList arrayList3 = new ArrayList();
        for (h c3 : arrayList2) {
            arrayList3.add(Float.valueOf(c(c3, f, f2).a));
        }
        ArrayList arrayList4 = new ArrayList();
        int i = 0;
        while (true) {
            f3 = 0.0f;
            if (i >= arrayList2.size()) {
                break;
            }
            h hVar = (h) arrayList2.get(i);
            String u = hVar.i().e().u();
            float g = hVar.g();
            boolean equals = TextUtils.equals(u, "flex");
            if (TextUtils.equals(u, "auto")) {
                List<List<h>> p = hVar.p();
                if (p != null && p.size() > 0) {
                    Iterator<List<h>> it = p.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            if (b(it.next())) {
                                equals = true;
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                }
                equals = false;
            }
            C0027a aVar = new C0027a();
            if (!equals) {
                g = ((Float) arrayList3.get(i)).floatValue();
            }
            aVar.a = g;
            aVar.b = !equals;
            if (equals) {
                f3 = ((Float) arrayList3.get(i)).floatValue();
            }
            aVar.c = f3;
            arrayList4.add(aVar);
            i++;
        }
        a((List<C0027a>) arrayList4, f, (List<h>) arrayList2);
        List<C0027a> a2 = i.a(f, arrayList4);
        float f4 = 0.0f;
        for (int i2 = 0; i2 < arrayList2.size(); i2++) {
            f4 += a2.get(i2).a;
            if (((Float) arrayList3.get(i2)).floatValue() != a2.get(i2).a) {
                d((h) arrayList2.get(i2));
            }
        }
        Iterator it2 = arrayList2.iterator();
        int i3 = 0;
        boolean z = false;
        while (true) {
            if (!it2.hasNext()) {
                break;
            }
            i3++;
            if (!b((h) it2.next())) {
                z = false;
                break;
            } else if (i3 == arrayList2.size()) {
                z = true;
            }
        }
        if (z) {
            f3 = f2;
        }
        ArrayList<c> arrayList5 = new ArrayList<>();
        for (int i4 = 0; i4 < arrayList2.size(); i4++) {
            h hVar2 = (h) arrayList2.get(i4);
            c c4 = c(hVar2, a2.get(i4).a, f2);
            if (!b(hVar2)) {
                f3 = Math.max(f3, c4.b);
            }
            arrayList5.add(c4);
        }
        ArrayList arrayList6 = new ArrayList();
        for (c cVar2 : arrayList5) {
            arrayList6.add(Float.valueOf(cVar2.b));
        }
        if (!z) {
            for (int i5 = 0; i5 < arrayList2.size(); i5++) {
                h hVar3 = (h) arrayList2.get(i5);
                if (b(hVar3) && ((Float) arrayList6.get(i5)).floatValue() != f3) {
                    d(hVar3);
                    c(hVar3, a2.get(i5).a, f3);
                }
            }
        }
        cVar.a = f4;
        cVar.b = f3;
        return cVar;
    }

    private boolean b(h hVar) {
        if (hVar == null) {
            return false;
        }
        if (TextUtils.equals(hVar.i().e().t(), "flex")) {
            return true;
        }
        return c(hVar);
    }

    private boolean c(h hVar) {
        List<List<h>> p;
        if (!hVar.q() && TextUtils.equals(hVar.i().e().t(), "auto") && (p = hVar.p()) != null && p.size() > 0) {
            if (p.size() == 1) {
                for (h b2 : p.get(0)) {
                    if (!b(b2)) {
                        return false;
                    }
                }
                return true;
            }
            for (List<h> a2 : p) {
                if (a(a2, true)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean a(List<h> list, boolean z) {
        boolean z2;
        Iterator<h> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                z2 = false;
                break;
            }
            String t = it.next().i().e().t();
            if (!TextUtils.equals(t, "flex") && (!z || !TextUtils.equals(t, "flex"))) {
            }
        }
        z2 = true;
        if (z2) {
            return true;
        }
        for (h c2 : list) {
            if (c(c2)) {
                return true;
            }
        }
        return false;
    }

    private void a(List<C0027a> list, float f, List<h> list2) {
        float f2 = 0.0f;
        for (C0027a next : list) {
            if (next.b) {
                f2 += next.a;
            }
        }
        if (f2 > f) {
            int i = 0;
            for (int i2 = 0; i2 < list2.size(); i2++) {
                if (list.get(i2).b && list2.get(i2).s()) {
                    i++;
                }
            }
            if (i > 0) {
                float ceil = (float) (Math.ceil((double) (((f2 - f) / ((float) i)) * 1000.0f)) / 1000.0d);
                for (int i3 = 0; i3 < list2.size(); i3++) {
                    C0027a aVar = list.get(i3);
                    if (aVar.b && list2.get(i3).s()) {
                        aVar.a -= ceil;
                    }
                }
            }
        }
    }

    public void a() {
        this.c.clear();
        this.a.clear();
        this.b.clear();
    }

    public c a(h hVar) {
        return this.a.get(e(hVar));
    }

    public c a(List<h> list) {
        return this.b.get(d(list));
    }

    private void d(h hVar) {
        this.a.remove(e(hVar));
        List<List<h>> p = hVar.p();
        if (p != null && p.size() > 0) {
            for (List<h> c2 : p) {
                c(c2);
            }
        }
    }

    private void c(List<h> list) {
        if (list != null && list.size() > 0) {
            this.b.remove(d(list));
            for (h d2 : list) {
                d(d2);
            }
        }
    }

    private String e(h hVar) {
        return hVar.b();
    }

    private String d(List<h> list) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            String b2 = list.get(i).b();
            if (i < list.size() - 1) {
                sb.append(b2);
                sb.append("-");
            } else {
                sb.append(b2);
            }
        }
        return sb.toString();
    }

    private void a(h hVar, c cVar) {
        this.a.put(e(hVar), cVar);
    }

    private void a(List<h> list, c cVar) {
        this.b.put(d(list), cVar);
    }

    /* compiled from: ComputeRuler */
    static class c {
        float a;
        float b;

        public c() {
        }

        public c(float f, float f2) {
            this.a = f;
            this.b = f2;
        }

        public String toString() {
            return "UnitSize{width=" + this.a + ", height=" + this.b + '}';
        }
    }

    /* compiled from: ComputeRuler */
    static class b {
        float a;
        int b;
        int c;
        double d;
        float e;

        b() {
        }

        static JSONObject a(b bVar) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(TtmlNode.ATTR_TTS_FONT_SIZE, (double) bVar.a);
                jSONObject.put("letterSpacing", bVar.b);
                jSONObject.put("lineHeight", bVar.d);
                jSONObject.put("maxWidth", (double) bVar.e);
                jSONObject.put(TtmlNode.ATTR_TTS_FONT_WEIGHT, bVar.c);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            return jSONObject;
        }
    }

    /* renamed from: com.bytedance.sdk.component.adexpress.dynamic.c.a$a  reason: collision with other inner class name */
    /* compiled from: ComputeRuler */
    static class C0027a implements Cloneable {
        float a;
        boolean b;
        float c;

        C0027a() {
        }

        public Object clone() {
            try {
                return (C0027a) super.clone();
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
                return null;
            }
        }
    }
}
