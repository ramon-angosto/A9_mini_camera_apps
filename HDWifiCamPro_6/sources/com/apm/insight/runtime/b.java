package com.apm.insight.runtime;

import androidx.work.WorkRequest;
import com.apm.insight.h;
import com.apm.insight.l.i;
import com.apm.insight.l.o;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class b {
    private static long a = -30000;
    private static File b;

    public static String a(long j, String str) {
        try {
            String j2 = o.j(h.g());
            return i.c(new File(j2, "apminsight/TrackInfo/" + ((j - (j % 86400000)) / 86400000) + "/" + str));
        } catch (Throwable th) {
            return th.getMessage();
        }
    }

    public static void a() {
        File file = new File(o.j(h.g()), "apminsight/TrackInfo/");
        String[] list = file.list();
        if (list != null && list.length > 5) {
            Arrays.sort(list);
            for (int i = 0; i < list.length - 5; i++) {
                i.a(new File(file, list[i]));
            }
        }
    }

    public static void a(long j) {
        if (j - a >= WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS) {
            a = j;
            try {
                i.a(b(), String.valueOf(System.currentTimeMillis()), false);
            } catch (IOException unused) {
            }
        }
    }

    private static File b() {
        if (b == null) {
            long currentTimeMillis = System.currentTimeMillis();
            String j = o.j(h.g());
            b = new File(j, "apminsight/TrackInfo/" + ((currentTimeMillis - (currentTimeMillis % 86400000)) / 86400000) + "/" + h.f());
        }
        return b;
    }
}
