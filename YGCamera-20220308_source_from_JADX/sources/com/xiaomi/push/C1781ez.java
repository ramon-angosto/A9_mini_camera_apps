package com.xiaomi.push;

import android.util.Pair;
import com.xiaomi.mipush.sdk.Constants;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.xiaomi.push.ez */
public class C1781ez {

    /* renamed from: a */
    private static Vector<Pair<String, Long>> f2265a = new Vector<>();

    /* renamed from: a */
    private static ConcurrentHashMap<String, Long> f2266a = new ConcurrentHashMap<>();

    /* renamed from: a */
    public static String m3467a() {
        StringBuilder sb = new StringBuilder();
        synchronized (f2265a) {
            for (int i = 0; i < f2265a.size(); i++) {
                Pair elementAt = f2265a.elementAt(i);
                sb.append((String) elementAt.first);
                sb.append(Constants.COLON_SEPARATOR);
                sb.append(elementAt.second);
                if (i < f2265a.size() - 1) {
                    sb.append(";");
                }
            }
            f2265a.clear();
        }
        return sb.toString();
    }
}
