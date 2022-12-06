package ms.bd.o.Pgl;

import android.util.SparseArray;

public final class pblb {
    private static final SparseArray<pgla> a = new SparseArray<>();

    public static abstract class pgla {
        public Object a(int i, int i2, long j, String str, Object obj) throws Throwable {
            return a(i2, j, str, obj);
        }

        /* access modifiers changed from: protected */
        public Object a(int i, long j, String str, Object obj) throws Throwable {
            return null;
        }
    }

    public static Object a(int i) {
        return pblk.a(i, 0, 0, (String) null, (Object) null);
    }

    public static Object a(int i, int i2, long j, String str, Object obj) {
        return pblk.a(i, i2, j, str, obj);
    }

    public static void a(int i, pgla pgla2) {
        pgla pgla3 = a.get(i);
        if (pgla3 == null) {
            a.put(i, pgla2);
        } else {
            throw new RuntimeException(String.format((String) pblk.a(16777217, 0, 0, "4fa152", new byte[]{96, 119, 82, 77, 11, 33, 119, 69, 53, 100, 43, 36, 0, 64, 13, 44, 36, 83, 53, 115, 107}), new Object[]{pgla3.toString()}));
        }
    }

    public static Object b(int i, int i2, long j, String str, Object obj) {
        pgla pgla2 = a.get(i);
        if (pgla2 != null) {
            try {
                return pgla2.a(i, i2, j, str, obj);
            } catch (Throwable th) {
                throw new RuntimeException(th);
            }
        } else {
            throw new RuntimeException(String.format((String) pblk.a(16777217, 0, 0, "0b8fa0", new byte[]{46, 112, 11, 17, 81, 35, 54, 3, 44, 50, 97, 105, 88, 82, 87, 41, 37, 66, 101, 63, 37}), new Object[]{Integer.valueOf(i)}));
        }
    }

    public static Object a(int i, long j) {
        return pblk.a(i, 0, j, (String) null, (Object) null);
    }

    public static Object a(int i, String str) {
        return pblk.a(i, 0, 0, str, (Object) null);
    }
}
