package com.apm.insight.nativecrash;

import android.text.TextUtils;
import com.apm.insight.l.i;
import com.apm.insight.l.o;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;

public class c {

    public static class a extends C0014c {
        a(File file) {
            super(file);
            this.b = "Total FD Count:";
            this.c = ":";
            this.d = -2;
        }
    }

    public static class b extends C0014c {
        b(File file) {
            super(file);
            this.b = "VmSize:";
            this.c = "\\s+";
            this.d = -1;
        }
    }

    /* renamed from: com.apm.insight.nativecrash.c$c  reason: collision with other inner class name */
    public static class C0014c {
        protected File a;
        protected String b;
        protected String c;
        protected int d;

        public C0014c(File file) {
            this.a = file;
        }

        /* JADX WARNING: Removed duplicated region for block: B:20:0x0042 A[DONT_GENERATE] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public int a() {
            /*
                r5 = this;
                java.io.File r0 = r5.a
                boolean r0 = r0.exists()
                r1 = -1
                if (r0 == 0) goto L_0x004e
                java.io.File r0 = r5.a
                boolean r0 = r0.isFile()
                if (r0 != 0) goto L_0x0012
                goto L_0x004e
            L_0x0012:
                r0 = 0
                java.io.FileReader r2 = new java.io.FileReader     // Catch:{ all -> 0x0036 }
                java.io.File r3 = r5.a     // Catch:{ all -> 0x0036 }
                r2.<init>(r3)     // Catch:{ all -> 0x0036 }
                java.io.BufferedReader r3 = new java.io.BufferedReader     // Catch:{ all -> 0x0036 }
                r3.<init>(r2)     // Catch:{ all -> 0x0036 }
                r0 = r1
            L_0x0020:
                java.lang.String r2 = r3.readLine()     // Catch:{ all -> 0x0031 }
                if (r2 == 0) goto L_0x002d
                int r0 = r5.a(r2)     // Catch:{ all -> 0x0031 }
                if (r0 != r1) goto L_0x002d
                goto L_0x0020
            L_0x002d:
                com.apm.insight.l.k.a((java.io.Closeable) r3)
                goto L_0x0046
            L_0x0031:
                r1 = move-exception
                r2 = r1
                r1 = r0
                r0 = r3
                goto L_0x0037
            L_0x0036:
                r2 = move-exception
            L_0x0037:
                com.apm.insight.c r3 = com.apm.insight.b.a()     // Catch:{ all -> 0x0047 }
                java.lang.String r4 = "NPTH_CATCH"
                r3.a((java.lang.String) r4, (java.lang.Throwable) r2)     // Catch:{ all -> 0x0047 }
                if (r0 == 0) goto L_0x0045
                com.apm.insight.l.k.a((java.io.Closeable) r0)
            L_0x0045:
                r0 = r1
            L_0x0046:
                return r0
            L_0x0047:
                r1 = move-exception
                if (r0 == 0) goto L_0x004d
                com.apm.insight.l.k.a((java.io.Closeable) r0)
            L_0x004d:
                throw r1
            L_0x004e:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.apm.insight.nativecrash.c.C0014c.a():int");
        }

        public int a(String str) {
            int i = this.d;
            if (!str.startsWith(this.b)) {
                return i;
            }
            try {
                i = Integer.parseInt(str.split(this.c)[1].trim());
            } catch (NumberFormatException e) {
                com.apm.insight.b.a().a("NPTH_CATCH", (Throwable) e);
            }
            if (i < 0) {
                return -2;
            }
            return i;
        }
    }

    public static class d extends C0014c {
        d(File file) {
            super(file);
        }

        public HashMap<String, List<String>> b() {
            HashMap<String, List<String>> hashMap = new HashMap<>();
            try {
                JSONArray b = i.b(this.a.getAbsolutePath());
                if (b == null) {
                    return hashMap;
                }
                for (int i = 0; i < b.length(); i++) {
                    String optString = b.optString(i);
                    if (!TextUtils.isEmpty(optString)) {
                        if (optString.startsWith("[tid:0") && optString.endsWith("sigstack:0x0]")) {
                            int indexOf = optString.indexOf("[routine:0x");
                            int i2 = indexOf + 11;
                            String substring = indexOf > 0 ? optString.substring(i2, optString.indexOf(93, i2)) : "unknown addr";
                            List list = hashMap.get(substring);
                            if (list == null) {
                                list = new ArrayList();
                                hashMap.put(substring, list);
                            }
                            list.add(optString);
                        }
                    }
                }
                return hashMap;
            } catch (IOException unused) {
            } catch (Throwable th) {
                com.apm.insight.b.a().a("NPTH_CATCH", th);
            }
        }
    }

    public static class e extends C0014c {
        e(File file) {
            super(file);
        }

        public JSONArray a(HashMap<String, List<String>> hashMap) {
            List<String> list;
            JSONArray jSONArray = new JSONArray();
            if (hashMap.isEmpty()) {
                return jSONArray;
            }
            try {
                JSONArray b = i.b(this.a.getAbsolutePath());
                if (b == null) {
                    return jSONArray;
                }
                for (int i = 0; i < b.length(); i++) {
                    String optString = b.optString(i);
                    if (!TextUtils.isEmpty(optString)) {
                        String substring = optString.substring(2, optString.indexOf(":"));
                        if (hashMap.containsKey(substring) && (list = hashMap.get(substring)) != null) {
                            for (String str : list) {
                                jSONArray.put(str + " " + optString);
                            }
                            hashMap.remove(substring);
                        }
                    }
                }
                for (List<String> it : hashMap.values()) {
                    for (String str2 : it) {
                        jSONArray.put(str2 + "  0x000000:unknown");
                    }
                }
                return jSONArray;
            } catch (IOException unused) {
            } catch (Throwable th) {
                com.apm.insight.b.a().a("NPTH_CATCH", th);
            }
        }
    }

    public static class f extends C0014c {
        f(File file) {
            super(file);
            this.b = "Total Threads Count:";
            this.c = ":";
            this.d = -2;
        }
    }

    public static int a(String str) {
        return new a(o.b(str)).a();
    }

    public static JSONArray a(File file, File file2) {
        return new e(file2).a(new d(file).b());
    }

    public static int b(String str) {
        return new f(o.c(str)).a();
    }

    public static int c(String str) {
        return new b(o.d(str)).a();
    }
}
