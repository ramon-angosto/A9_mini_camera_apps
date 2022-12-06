package sg.bigo.ads.api.core;

import android.util.SparseArray;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public final class b {
    private static final SparseArray<List<Integer>> a;

    static {
        SparseArray<List<Integer>> sparseArray = new SparseArray<>();
        a = sparseArray;
        sparseArray.put(0, Arrays.asList(new Integer[]{1, 2, 3}));
        a.put(1, Arrays.asList(new Integer[]{1, 2}));
        a.put(2, Collections.singletonList(3));
        a.put(3, Arrays.asList(new Integer[]{1, 2, 3}));
        a.put(4, Collections.singletonList(2));
        a.put(12, Arrays.asList(new Integer[]{1, 2}));
    }

    public static String a(int i) {
        StringBuilder sb = new StringBuilder();
        List<Integer> list = a.get(i);
        if (list != null) {
            for (Integer num : list) {
                if (sb.length() > 0) {
                    sb.append(",");
                }
                sb.append(num);
            }
        }
        return sb.toString();
    }

    public static boolean b(int i) {
        return i == 3 || i == 4;
    }

    public static boolean c(int i) {
        return i == 12;
    }

    public static boolean d(int i) {
        return i != 4;
    }
}
