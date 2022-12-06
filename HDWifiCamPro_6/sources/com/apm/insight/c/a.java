package com.apm.insight.c;

import com.apm.insight.h;
import java.io.File;

public class a {
    public static void a() {
        File[] listFiles;
        File file = new File(h.g().getFilesDir(), "apminsight/crashCommand");
        if (file.exists() && (listFiles = file.listFiles()) != null) {
            for (File file2 : listFiles) {
                try {
                    String[] split = file2.getName().split("_");
                    if (split[0].equals(String.valueOf(0))) {
                        a(split);
                    }
                    file2.delete();
                } catch (Throwable unused) {
                }
            }
        }
    }

    private static void a(String... strArr) {
    }
}
