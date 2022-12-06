package com.xiaomi.push;

import com.xiaomi.channel.commonutils.logger.C1524b;
import java.io.File;
import java.util.HashMap;

/* renamed from: com.xiaomi.push.z */
public class C2092z {

    /* renamed from: a */
    private static final HashMap<String, String> f3984a = new HashMap<>();

    static {
        f3984a.put("FFD8FF", "jpg");
        f3984a.put("89504E47", "png");
        f3984a.put("47494638", "gif");
        f3984a.put("474946", "gif");
        f3984a.put("424D", "bmp");
    }

    /* renamed from: a */
    public static long m5389a(File file) {
        long j = 0;
        try {
            File[] listFiles = file.listFiles();
            for (int i = 0; i < listFiles.length; i++) {
                j += listFiles[i].isDirectory() ? m5389a(listFiles[i]) : listFiles[i].length();
            }
        } catch (Exception e) {
            C1524b.m2155a((Throwable) e);
        }
        return j;
    }
}
