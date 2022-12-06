package com.xiaomi.push;

import android.os.Build;
import android.system.Os;
import com.xiaomi.channel.commonutils.logger.C1524b;
import java.io.File;

/* renamed from: com.xiaomi.push.co */
public class C1696co {
    /* renamed from: a */
    public static long m2870a(String str) {
        if (Build.VERSION.SDK_INT < 21) {
            return 0;
        }
        try {
            if (new File(str).exists()) {
                return Os.stat(str).st_size;
            }
            return 0;
        } catch (Exception e) {
            C1524b.m2155a((Throwable) e);
            return 0;
        }
    }
}
