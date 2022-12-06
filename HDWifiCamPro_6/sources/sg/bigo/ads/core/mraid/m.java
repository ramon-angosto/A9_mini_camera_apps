package sg.bigo.ads.core.mraid;

import android.graphics.Rect;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

final class m {
    List<Rect> a = new ArrayList();

    static class a {
        final int a;
        final int b;

        a(int i, int i2) {
            this.a = i;
            this.b = i2;
        }

        /* access modifiers changed from: package-private */
        public final boolean a(a aVar) {
            return this.a <= aVar.b && this.b >= aVar.a;
        }

        public final String toString() {
            return String.format("Range: %s - %s", new Object[]{Integer.valueOf(this.a), Integer.valueOf(this.b)});
        }
    }

    m(List<Rect> list, int[] iArr) {
        List<Integer> a2 = a(list);
        int i = 0;
        while (i < a2.size() - 1) {
            int intValue = a2.get(i).intValue();
            i++;
            int intValue2 = a2.get(i).intValue();
            if (intValue < intValue2) {
                a aVar = new a(intValue, intValue2);
                this.a.addAll(b(aVar, a(aVar, list)));
            }
        }
        Collections.sort(this.a, new Comparator<Rect>() {
            public final /* synthetic */ int compare(Object obj, Object obj2) {
                Rect rect = (Rect) obj;
                Rect rect2 = (Rect) obj2;
                return (rect.width() * rect.height()) - (rect2.width() * rect2.height());
            }
        });
        for (Rect offset : this.a) {
            offset.offset(-iArr[0], -iArr[1]);
        }
    }

    private List<Integer> a(List<Rect> list) {
        ArrayList arrayList = new ArrayList();
        for (Rect next : list) {
            arrayList.add(Integer.valueOf(next.left));
            arrayList.add(Integer.valueOf(next.right));
        }
        Collections.sort(arrayList, new Comparator<Integer>() {
            public final /* synthetic */ int compare(Object obj, Object obj2) {
                return ((Integer) obj).intValue() - ((Integer) obj2).intValue();
            }
        });
        return arrayList;
    }

    private static List<a> a(List<a> list, a aVar) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            a aVar2 = list.get(i);
            if (!aVar.a(aVar2)) {
                arrayList.add(aVar2);
            } else if (aVar.a(aVar2)) {
                aVar = new a(aVar.a < aVar2.a ? aVar.a : aVar2.a, aVar.b > aVar2.b ? aVar.b : aVar2.b);
            }
        }
        arrayList.add(aVar);
        return arrayList;
    }

    private static List<a> a(a aVar, List<Rect> list) {
        List<a> arrayList = new ArrayList<>();
        for (Rect next : list) {
            if (aVar.a < next.right && aVar.b > next.left) {
                arrayList = a(arrayList, new a(next.top, next.bottom));
            }
        }
        return arrayList;
    }

    private static List<Rect> b(a aVar, List<a> list) {
        ArrayList arrayList = new ArrayList();
        for (a next : list) {
            arrayList.add(new Rect(aVar.a, next.a, aVar.b, next.b));
        }
        return arrayList;
    }

    /* access modifiers changed from: package-private */
    public final float a() {
        float f = 0.0f;
        for (Rect next : this.a) {
            f += (float) (next.width() * next.height());
        }
        return f;
    }
}
