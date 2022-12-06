package com.bytedance.sdk.component.adexpress.dynamic.c;

import com.bytedance.sdk.component.adexpress.dynamic.c.a;
import java.util.ArrayList;
import java.util.List;

/* compiled from: FlexComputeRuler */
public class i {
    public static float a(float f) {
        return (float) Math.ceil((double) ((f * 16.0f) / 16.0f));
    }

    public static List<a.C0027a> a(float f, List<a.C0027a> list) {
        ArrayList<a.C0027a> arrayList = new ArrayList<>();
        for (a.C0027a clone : list) {
            arrayList.add((a.C0027a) clone.clone());
        }
        boolean z = true;
        int i = 0;
        int i2 = 0;
        for (a.C0027a aVar : arrayList) {
            if (aVar.b) {
                i = (int) (((float) i) + aVar.a);
            } else {
                i2 = (int) (((float) i2) + aVar.a);
                z = false;
            }
        }
        if (z && f > ((float) i)) {
            return arrayList;
        }
        float f2 = (float) i;
        int i3 = (f > f2 ? 1 : (f == f2 ? 0 : -1));
        float f3 = i3 < 0 ? f / f2 : 1.0f;
        int i4 = (f > f2 ? 1 : (f == f2 ? 0 : -1));
        float f4 = i4 > 0 ? (f - f2) / ((float) i2) : 0.0f;
        if (f4 > 1.0f) {
            ArrayList arrayList2 = new ArrayList();
            boolean z2 = false;
            for (a.C0027a aVar2 : arrayList) {
                if (!aVar2.b && aVar2.c != 0.0f && aVar2.a * f4 > aVar2.c) {
                    aVar2.a = aVar2.c;
                    aVar2.b = true;
                    z2 = true;
                }
                arrayList2.add(aVar2);
            }
            if (z2) {
                return a(f, arrayList2);
            }
        }
        int i5 = 0;
        for (a.C0027a aVar3 : arrayList) {
            if (aVar3.b) {
                aVar3.a = a(aVar3.a * f3);
            } else {
                aVar3.a = a(aVar3.a * f4);
            }
            i5 = (int) (((float) i5) + aVar3.a);
        }
        float f5 = (float) i5;
        if (f5 < f) {
            float f6 = f - f5;
            for (int i6 = 0; i6 < arrayList.size() && f6 > 0.0f; i6 = (i6 + 1) % arrayList.size()) {
                a.C0027a aVar4 = (a.C0027a) arrayList.get(i6);
                if ((i3 < 0 && aVar4.b) || (i4 > 0 && !aVar4.b)) {
                    aVar4.a += 0.0625f;
                    f6 -= 0.0625f;
                }
            }
        }
        return arrayList;
    }
}
