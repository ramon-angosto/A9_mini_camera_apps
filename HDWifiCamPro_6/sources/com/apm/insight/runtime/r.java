package com.apm.insight.runtime;

import android.text.TextUtils;
import com.apm.insight.b;
import com.apm.insight.c;
import com.apm.insight.h;
import com.apm.insight.l.i;
import com.apm.insight.l.o;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import org.json.JSONArray;

public class r {
    private static File a;

    public static class a {
        public String a;
        public String b;
        public long c;

        a(String str) {
            String[] split = str.split("\\s+");
            if (split.length == 3) {
                this.a = split[0];
                this.b = split[1];
                try {
                    this.c = Long.parseLong(split[2]);
                } catch (Throwable th) {
                    c a2 = b.a();
                    a2.a("NPTH_CATCH", (Throwable) new RuntimeException("err ProcessTrack line:" + str, th));
                }
            } else {
                c a3 = b.a();
                a3.a("NPTH_CATCH", (Throwable) new RuntimeException("err ProcessTrack line:" + str));
            }
        }
    }

    private static File a() {
        if (a == null) {
            String c = com.apm.insight.l.a.c(h.g());
            if (c == null) {
                return null;
            }
            long currentTimeMillis = System.currentTimeMillis();
            String j = o.j(h.g());
            a = new File(j, "apminsight/ProcessTrack/" + ((currentTimeMillis - (currentTimeMillis % 86400000)) / 86400000) + '/' + c.replace(':', '_') + ".txt");
        }
        return a;
    }

    public static File a(long j) {
        String j2 = o.j(h.g());
        return new File(j2, "apminsight/ProcessTrack/" + ((j - (j % 86400000)) / 86400000));
    }

    public static HashMap<String, a> a(long j, String str) {
        File file = new File(o.j(h.g()), "apminsight/ProcessTrack/" + ((j - (j % 86400000)) / 86400000));
        String[] list = file.list();
        HashMap<String, a> hashMap = new HashMap<>();
        if (list != null) {
            for (String str2 : list) {
                File file2 = new File(file, str2);
                long length = file2.length();
                try {
                    JSONArray a2 = i.a(file2, length > 1048576 ? length - 524288 : 0);
                    int length2 = a2.length() - 1;
                    while (true) {
                        if (length2 < 0) {
                            break;
                        }
                        String optString = a2.optString(length2);
                        if (!TextUtils.isEmpty(optString)) {
                            if (optString.startsWith(str)) {
                                hashMap.put(str2.replace('_', ':').replace(".txt", ""), new a(optString));
                                break;
                            }
                        }
                        length2--;
                    }
                } catch (IOException unused) {
                }
            }
        }
        return hashMap;
    }

    public static void a(String str, String str2) {
        try {
            File a2 = a();
            if (a2 != null) {
                i.a(a2, str + ' ' + str2 + ' ' + System.currentTimeMillis() + 10, true);
            }
        } catch (Throwable unused) {
        }
    }
}
