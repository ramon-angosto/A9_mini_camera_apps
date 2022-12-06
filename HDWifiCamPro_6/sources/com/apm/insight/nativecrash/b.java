package com.apm.insight.nativecrash;

import android.content.Context;
import android.os.Environment;
import com.apm.insight.CrashType;
import com.apm.insight.ICrashFilter;
import com.apm.insight.entity.Header;
import com.apm.insight.h;
import com.apm.insight.l.i;
import com.apm.insight.l.k;
import com.apm.insight.l.o;
import com.apm.insight.l.s;
import com.apm.insight.l.w;
import com.apm.insight.runtime.q;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSchemeDataSource;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class b {
    private static Boolean d;
    private final Context a;
    private JSONObject b = null;
    /* access modifiers changed from: private */
    public C0013b c;

    private static class a {
        /* access modifiers changed from: private */
        public static String b(File file) {
            BufferedReader bufferedReader;
            try {
                bufferedReader = new BufferedReader(new FileReader(file));
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        k.a((Closeable) bufferedReader);
                        return "";
                    }
                    if (readLine.startsWith("[FATAL:jni_android.cc") && readLine.contains("Please include Java exception stack in crash report ttwebview:")) {
                        StringBuilder sb = new StringBuilder();
                        int indexOf = readLine.indexOf(" ttwebview:");
                        sb.append("Caused by: ");
                        sb.append("Please include Java exception stack in crash report");
                        sb.append("\n");
                        sb.append(readLine.substring(indexOf + 11));
                        while (true) {
                            sb.append("\n");
                            String readLine2 = bufferedReader.readLine();
                            if (readLine2 != null) {
                                sb.append(readLine2);
                            } else {
                                String sb2 = sb.toString();
                                k.a((Closeable) bufferedReader);
                                return sb2;
                            }
                        }
                    }
                    k.a((Closeable) bufferedReader);
                    return "";
                } catch (Throwable th) {
                    th = th;
                    try {
                        com.apm.insight.b.a().a("NPTH_CATCH", th);
                        k.a((Closeable) bufferedReader);
                        return "";
                    } catch (Throwable th2) {
                        k.a((Closeable) bufferedReader);
                        throw th2;
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                bufferedReader = null;
                com.apm.insight.b.a().a("NPTH_CATCH", th);
                k.a((Closeable) bufferedReader);
                return "";
            }
        }
    }

    /* renamed from: com.apm.insight.nativecrash.b$b  reason: collision with other inner class name */
    private class C0013b {
        /* access modifiers changed from: private */
        public final d b;
        /* access modifiers changed from: private */
        public final a c;
        /* access modifiers changed from: private */
        public final File d;
        private final File e;

        public C0013b(File file) {
            this.d = file;
            this.e = o.a(h.g(), file.getName());
            this.c = new a(file);
            this.b = new d(file);
            if (this.c.a() && this.b.a() == null) {
                this.b.a(file);
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:10:0x001c A[Catch:{ all -> 0x0017 }] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public long a() {
            /*
                r3 = this;
                com.apm.insight.nativecrash.a r0 = r3.c
                java.util.Map r0 = r0.c()
                if (r0 == 0) goto L_0x0019
                boolean r1 = r0.isEmpty()     // Catch:{ all -> 0x0017 }
                if (r1 != 0) goto L_0x0019
                java.lang.String r1 = "start_time"
                java.lang.Object r0 = r0.get(r1)     // Catch:{ all -> 0x0017 }
                java.lang.String r0 = (java.lang.String) r0     // Catch:{ all -> 0x0017 }
                goto L_0x001a
            L_0x0017:
                r0 = move-exception
                goto L_0x0021
            L_0x0019:
                r0 = 0
            L_0x001a:
                if (r0 == 0) goto L_0x002a
                long r0 = java.lang.Long.parseLong(r0)     // Catch:{ all -> 0x0017 }
                return r0
            L_0x0021:
                com.apm.insight.c r1 = com.apm.insight.b.a()
                java.lang.String r2 = "NPTH_CATCH"
                r1.a((java.lang.String) r2, (java.lang.Throwable) r0)
            L_0x002a:
                long r0 = java.lang.System.currentTimeMillis()
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.apm.insight.nativecrash.b.C0013b.a():long");
        }

        public File b() {
            return this.d;
        }

        public boolean c() {
            return this.c.a();
        }
    }

    public class c extends e {
        c() {
            super();
            this.c = "Total FD Count:";
            this.b = o.i(b.this.c.b());
            this.d = ":";
            this.e = -2;
        }
    }

    public class d extends e {
        d() {
            super();
            this.c = "VmSize:";
            this.b = o.k(b.this.c.b());
            this.d = "\\s+";
            this.e = -1;
        }
    }

    public class e {
        protected File b;
        protected String c;
        protected String d;
        protected int e;

        public e() {
        }

        /* JADX WARNING: Removed duplicated region for block: B:20:0x0042 A[DONT_GENERATE] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public int a() {
            /*
                r5 = this;
                java.io.File r0 = r5.b
                boolean r0 = r0.exists()
                r1 = -1
                if (r0 == 0) goto L_0x004e
                java.io.File r0 = r5.b
                boolean r0 = r0.isFile()
                if (r0 != 0) goto L_0x0012
                goto L_0x004e
            L_0x0012:
                r0 = 0
                java.io.FileReader r2 = new java.io.FileReader     // Catch:{ all -> 0x0036 }
                java.io.File r3 = r5.b     // Catch:{ all -> 0x0036 }
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
            throw new UnsupportedOperationException("Method not decompiled: com.apm.insight.nativecrash.b.e.a():int");
        }

        public int a(String str) {
            int i = this.e;
            if (!str.startsWith(this.c)) {
                return i;
            }
            try {
                i = Integer.parseInt(str.split(this.d)[1].trim());
            } catch (NumberFormatException e2) {
                com.apm.insight.b.a().a("NPTH_CATCH", (Throwable) e2);
            }
            if (i < 0) {
                return -2;
            }
            return i;
        }
    }

    public class f extends e {
        f() {
            super();
            this.c = "Total Threads Count:";
            this.b = o.j(b.this.c.b());
            this.d = ":";
            this.e = -2;
        }
    }

    public b(Context context) {
        this.a = context;
    }

    private String a(String str) {
        StringBuilder sb = new StringBuilder();
        try {
            if (str.length() < 16) {
                sb.append(str);
            } else {
                sb.append(str.charAt(6));
                sb.append(str.charAt(7));
                sb.append(str.charAt(4));
                sb.append(str.charAt(5));
                sb.append(str.charAt(2));
                sb.append(str.charAt(3));
                sb.append(str.charAt(0));
                sb.append(str.charAt(1));
                sb.append(str.charAt(10));
                sb.append(str.charAt(11));
                sb.append(str.charAt(8));
                sb.append(str.charAt(9));
                sb.append(str.charAt(14));
                sb.append(str.charAt(15));
                sb.append(str.charAt(12));
                sb.append(str.charAt(13));
                if (str.length() >= 32) {
                    sb.append(str, 16, 32);
                    sb.append('0');
                }
            }
        } catch (Throwable th) {
            com.apm.insight.b.a().a("NPTH_CATCH", th);
        }
        return sb.toString().toUpperCase();
    }

    private void a(com.apm.insight.entity.a aVar) {
        aVar.a(n());
        aVar.a("is_native_crash", (Object) 1);
        aVar.a("repack_time", (Object) Long.valueOf(System.currentTimeMillis()));
        aVar.a("crash_uuid", (Object) this.c.b().getName());
        aVar.a("jiffy", (Object) Long.valueOf(q.a.a()));
    }

    private void a(Map<String, String> map) {
        String str = "true";
        map.put("has_fds_file", o.i(this.c.b()).exists() ? str : "false");
        File h = o.h(this.c.b());
        map.put("has_logcat_file", (!h.exists() || h.length() <= 128) ? "false" : str);
        map.put("has_maps_file", o.d(this.c.b()).exists() ? str : "false");
        map.put("has_tombstone_file", o.b(this.c.b()).exists() ? str : "false");
        map.put("has_meminfo_file", o.k(this.c.b()).exists() ? str : "false");
        if (!o.j(this.c.b()).exists()) {
            str = "false";
        }
        map.put("has_threads_file", str);
    }

    private void b(com.apm.insight.entity.a aVar) {
        com.apm.insight.entity.d.b(aVar.h());
        HashMap hashMap = new HashMap();
        if (m()) {
            hashMap.put("is_root", "true");
            aVar.a("is_root", (Object) "true");
        } else {
            hashMap.put("is_root", "false");
            aVar.a("is_root", (Object) "false");
        }
        a((Map<String, String>) hashMap);
        int o = o();
        if (o > 0) {
            if (o > 960) {
                hashMap.put("fd_leak", "true");
            } else {
                hashMap.put("fd_leak", "false");
            }
            aVar.a("fd_count", (Object) Integer.valueOf(o));
        }
        int p = p();
        if (p > 0) {
            if (p > 350) {
                hashMap.put("threads_leak", "true");
            } else {
                hashMap.put("threads_leak", "false");
            }
            aVar.a("threads_count", (Object) Integer.valueOf(p));
        }
        int q = q();
        if (q > 0) {
            if (((long) q) > i()) {
                hashMap.put("memory_leak", "true");
            } else {
                hashMap.put("memory_leak", "false");
            }
            aVar.a("memory_size", (Object) Integer.valueOf(q));
        }
        hashMap.put("sdk_version", "1.3.8.nourl-alpha.7");
        hashMap.put("has_java_stack", String.valueOf(aVar.h().opt("java_data") != null));
        JSONArray a2 = c.a(o.l(this.c.d), o.m(this.c.d));
        hashMap.put("leak_threads_count", String.valueOf(a2.length()));
        if (a2.length() > 0) {
            try {
                i.a(o.n(this.c.d), a2, false);
            } catch (Throwable unused) {
            }
        }
        aVar.b();
        aVar.c();
        aVar.c((Map<? extends String, ? extends String>) hashMap);
    }

    private void c(com.apm.insight.entity.a aVar) {
        Map<String, String> b2 = this.c.b.b();
        if (!b2.isEmpty()) {
            JSONArray jSONArray = new JSONArray();
            for (String next : b2.keySet()) {
                String a2 = a(b2.get(next));
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("lib_name", next);
                    jSONObject.put("lib_uuid", a2);
                    jSONArray.put(jSONObject);
                } catch (JSONException e2) {
                    com.apm.insight.b.a().a("NPTH_CATCH", (Throwable) e2);
                }
            }
            aVar.a("crash_lib_uuid", (Object) jSONArray);
        }
    }

    private void d(com.apm.insight.entity.a aVar) {
        File e2 = o.e(this.c.b());
        if (e2.exists() || this.b != null) {
            try {
                aVar.c(this.b == null ? new JSONObject(i.c(e2.getAbsolutePath())) : this.b);
                aVar.a("has_callback", "true");
                if (aVar.h().opt("storage") == null) {
                    aVar.b(w.a(h.g()));
                }
                s.a(aVar, aVar.i(), CrashType.NATIVE);
            } catch (Throwable th) {
                com.apm.insight.b.a().a("NPTH_CATCH", th);
            }
            long j = -1;
            long optLong = aVar.h().optLong("crash_time", -1);
            long optLong2 = aVar.h().optLong("java_end", -1);
            if (!(optLong2 == -1 || optLong == -1)) {
                j = optLong2 - optLong;
            }
            try {
                aVar.b("total_cost", String.valueOf(j));
                aVar.a("total_cost", String.valueOf(j / 1000));
            } catch (Throwable unused) {
            }
        } else {
            aVar.b(w.a(h.g()));
            aVar.a("has_callback", "false");
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x005b A[Catch:{ all -> 0x0061 }] */
    /* JADX WARNING: Removed duplicated region for block: B:20:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0035  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void e(com.apm.insight.entity.a r5) {
        /*
            r4 = this;
            com.apm.insight.nativecrash.b$b r0 = r4.c
            java.io.File r0 = r0.b()
            java.io.File r0 = com.apm.insight.l.o.g((java.io.File) r0)
            boolean r1 = r0.exists()
            java.lang.String r2 = "NPTH_CATCH"
            if (r1 == 0) goto L_0x0023
            java.lang.String r0 = r0.getAbsolutePath()     // Catch:{ all -> 0x001b }
            java.lang.String r0 = com.apm.insight.l.v.a((java.lang.String) r0)     // Catch:{ all -> 0x001b }
            goto L_0x0025
        L_0x001b:
            r0 = move-exception
            com.apm.insight.c r1 = com.apm.insight.b.a()
            r1.a((java.lang.String) r2, (java.lang.Throwable) r0)
        L_0x0023:
            java.lang.String r0 = ""
        L_0x0025:
            com.apm.insight.nativecrash.b$b r1 = r4.c
            java.io.File r1 = r1.b()
            java.io.File r1 = com.apm.insight.l.o.o(r1)
            boolean r3 = r1.exists()
            if (r3 == 0) goto L_0x0055
            java.lang.String r1 = com.apm.insight.nativecrash.b.a.b(r1)
            boolean r3 = r0.isEmpty()
            if (r3 != 0) goto L_0x0054
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r0)
            java.lang.String r0 = "\n"
            r3.append(r0)
            r3.append(r1)
            java.lang.String r0 = r3.toString()
            goto L_0x0055
        L_0x0054:
            r0 = r1
        L_0x0055:
            boolean r1 = r0.isEmpty()     // Catch:{ all -> 0x0061 }
            if (r1 != 0) goto L_0x0069
            java.lang.String r1 = "java_data"
            r5.a((java.lang.String) r1, (java.lang.Object) r0)     // Catch:{ all -> 0x0061 }
            goto L_0x0069
        L_0x0061:
            r5 = move-exception
            com.apm.insight.c r0 = com.apm.insight.b.a()
            r0.a((java.lang.String) r2, (java.lang.Throwable) r5)
        L_0x0069:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.apm.insight.nativecrash.b.e(com.apm.insight.entity.a):void");
    }

    private void f(com.apm.insight.entity.a aVar) {
        File a2 = o.a(this.c.b());
        if (a2.exists()) {
            try {
                aVar.a("native_log", (Object) i.b(i.a(a2.getAbsolutePath(), "\n"), "\n"));
            } catch (Throwable th) {
                com.apm.insight.b.a().a("NPTH_CATCH", th);
            }
        }
    }

    private void g(com.apm.insight.entity.a aVar) {
        BufferedReader bufferedReader;
        File h = o.h(this.c.b());
        if (!h.exists()) {
            NativeImpl.a(h.getAbsolutePath(), String.valueOf(h.i().getLogcatDumpCount()), String.valueOf(h.i().getLogcatLevel()));
        }
        JSONArray jSONArray = new JSONArray();
        String str = " " + this.c.c.c().get("pid") + " ";
        try {
            bufferedReader = new BufferedReader(new FileReader(h));
            try {
                if (h.length() > 512000) {
                    bufferedReader.skip(h.length() - 512000);
                }
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    if ((readLine.length() > 32 ? readLine.substring(0, 31) : readLine).contains(str)) {
                        jSONArray.put(readLine);
                    }
                }
            } catch (Throwable unused) {
            }
        } catch (Throwable unused2) {
            bufferedReader = null;
        }
        k.a((Closeable) bufferedReader);
        aVar.a("logcat", (Object) jSONArray);
    }

    private void h(com.apm.insight.entity.a aVar) {
        Map<String, String> a2 = a();
        if (a2 != null && aVar != null) {
            String str = a2.get("process_name");
            if (str != null) {
                aVar.a("process_name", (Object) str);
            }
            String str2 = a2.get("start_time");
            if (str2 != null) {
                try {
                    aVar.a(Long.decode(str2).longValue());
                } catch (Throwable th) {
                    com.apm.insight.b.a().a("NPTH_CATCH", th);
                }
            }
            String str3 = a2.get("pid");
            if (str3 != null) {
                try {
                    aVar.a("pid", (Object) Long.decode(str3));
                } catch (Throwable th2) {
                    com.apm.insight.b.a().a("NPTH_CATCH", th2);
                }
            }
            String str4 = a2.get("crash_thread_name");
            if (str4 != null) {
                aVar.a("crash_thread_name", (Object) str4);
            }
            String str5 = a2.get("crash_time");
            if (str5 != null) {
                try {
                    aVar.a("crash_time", (Object) Long.decode(str5));
                } catch (Throwable th3) {
                    com.apm.insight.b.a().a("NPTH_CATCH", th3);
                }
            }
            aVar.a(DataSchemeDataSource.SCHEME_DATA, (Object) b());
        }
    }

    public static long i() {
        if (NativeImpl.e()) {
            return Long.MAX_VALUE;
        }
        return Header.a() ? 3891200 : 2867200;
    }

    public static boolean m() {
        Boolean bool = d;
        if (bool != null) {
            return bool.booleanValue();
        }
        String[] strArr = {"/data/local/su", "/data/local/bin/su", "/data/local/xbin/su", "/system/xbin/su", "/system/bin/su", "/system/bin/.ext/su", "/system/bin/failsafe/su", "/system/sd/xbin/su", "/system/usr/we-need-root/su", "/sbin/su", "/su/bin/su"};
        int length = strArr.length;
        int i = 0;
        while (i < length) {
            try {
                if (new File(strArr[i]).exists()) {
                    Boolean bool2 = true;
                    d = bool2;
                    return bool2.booleanValue();
                }
                i++;
            } catch (Throwable th) {
                com.apm.insight.b.a().a("NPTH_CATCH", th);
            }
        }
        Boolean bool3 = false;
        d = bool3;
        return bool3.booleanValue();
    }

    private Header n() {
        Header header = new Header(this.a);
        JSONObject a2 = com.apm.insight.runtime.s.a().a(this.c.a());
        if (a2 != null) {
            header.a(a2);
            header.d();
            header.e();
        }
        Header.b(header);
        return header;
    }

    private int o() {
        return new c().a();
    }

    private int p() {
        return new f().a();
    }

    private int q() {
        return new d().a();
    }

    public Map<String, String> a() {
        C0013b bVar = this.c;
        if (bVar != null) {
            return bVar.c.c();
        }
        return null;
    }

    public void a(File file) {
        this.c = new C0013b(file);
    }

    public String b() {
        C0013b bVar = this.c;
        if (bVar == null) {
            return null;
        }
        String c2 = bVar.b.c();
        return (c2 == null || c2.isEmpty()) ? this.c.c.b() : c2;
    }

    public boolean c() {
        C0013b bVar = this.c;
        if (bVar != null) {
            return bVar.c();
        }
        return false;
    }

    public JSONObject d() {
        File f2 = o.f(this.c.b());
        if (!f2.exists()) {
            return null;
        }
        try {
            String c2 = i.c(f2.getAbsolutePath());
            if (c2 != null && !c2.isEmpty()) {
                return new JSONObject(c2);
            }
        } catch (Throwable th) {
            com.apm.insight.b.a().a("NPTH_CATCH", th);
        }
        return null;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(10:13|(4:16|(1:52)(3:18|19|(2:21|53)(1:51))|25|14)|49|26|27|28|(1:32)|33|34|(2:36|(3:(4:40|(2:42|55)(1:56)|43|38)|54|61)(1:59))(1:58)) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:33:0x00d2 */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00d8 A[Catch:{ IOException -> 0x0110 }] */
    /* JADX WARNING: Removed duplicated region for block: B:58:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void e() {
        /*
            r10 = this;
            java.lang.String r0 = "NPTH_CATCH"
            com.apm.insight.nativecrash.b$b r1 = r10.c     // Catch:{ IOException -> 0x0110 }
            java.io.File r1 = r1.b()     // Catch:{ IOException -> 0x0110 }
            java.io.File r1 = com.apm.insight.l.o.e((java.io.File) r1)     // Catch:{ IOException -> 0x0110 }
            java.io.File r2 = new java.io.File     // Catch:{ IOException -> 0x0110 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0110 }
            r3.<init>()     // Catch:{ IOException -> 0x0110 }
            java.lang.String r4 = r1.getAbsolutePath()     // Catch:{ IOException -> 0x0110 }
            r3.append(r4)     // Catch:{ IOException -> 0x0110 }
            java.lang.String r4 = ".tmp'"
            r3.append(r4)     // Catch:{ IOException -> 0x0110 }
            java.lang.String r3 = r3.toString()     // Catch:{ IOException -> 0x0110 }
            r2.<init>(r3)     // Catch:{ IOException -> 0x0110 }
            boolean r3 = r2.exists()     // Catch:{ IOException -> 0x0110 }
            if (r3 == 0) goto L_0x002f
            r2.delete()     // Catch:{ IOException -> 0x0110 }
        L_0x002f:
            boolean r3 = r1.exists()     // Catch:{ IOException -> 0x0110 }
            r4 = 46
            r5 = 0
            if (r3 == 0) goto L_0x0065
        L_0x0038:
            int r2 = com.apm.insight.nativecrash.NativeCrashCollector.a()     // Catch:{ IOException -> 0x0110 }
            if (r5 >= r2) goto L_0x0118
            java.io.File r2 = new java.io.File     // Catch:{ IOException -> 0x0110 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0110 }
            r3.<init>()     // Catch:{ IOException -> 0x0110 }
            java.lang.String r6 = r1.getAbsolutePath()     // Catch:{ IOException -> 0x0110 }
            r3.append(r6)     // Catch:{ IOException -> 0x0110 }
            r3.append(r4)     // Catch:{ IOException -> 0x0110 }
            r3.append(r5)     // Catch:{ IOException -> 0x0110 }
            java.lang.String r3 = r3.toString()     // Catch:{ IOException -> 0x0110 }
            r2.<init>(r3)     // Catch:{ IOException -> 0x0110 }
            boolean r3 = r2.exists()     // Catch:{ IOException -> 0x0110 }
            if (r3 == 0) goto L_0x0062
            r2.delete()     // Catch:{ IOException -> 0x0110 }
        L_0x0062:
            int r5 = r5 + 1
            goto L_0x0038
        L_0x0065:
            com.apm.insight.entity.a r3 = new com.apm.insight.entity.a     // Catch:{ IOException -> 0x0110 }
            r3.<init>()     // Catch:{ IOException -> 0x0110 }
            r6 = r5
        L_0x006b:
            int r7 = com.apm.insight.nativecrash.NativeCrashCollector.a()     // Catch:{ IOException -> 0x0110 }
            if (r6 >= r7) goto L_0x00b5
            java.io.File r7 = new java.io.File     // Catch:{ IOException -> 0x0110 }
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0110 }
            r8.<init>()     // Catch:{ IOException -> 0x0110 }
            java.lang.String r9 = r1.getAbsolutePath()     // Catch:{ IOException -> 0x0110 }
            r8.append(r9)     // Catch:{ IOException -> 0x0110 }
            r8.append(r4)     // Catch:{ IOException -> 0x0110 }
            r8.append(r6)     // Catch:{ IOException -> 0x0110 }
            java.lang.String r8 = r8.toString()     // Catch:{ IOException -> 0x0110 }
            r7.<init>(r8)     // Catch:{ IOException -> 0x0110 }
            boolean r8 = r7.exists()     // Catch:{ IOException -> 0x0110 }
            if (r8 != 0) goto L_0x0093
            goto L_0x00b2
        L_0x0093:
            java.lang.String r7 = r7.getAbsolutePath()     // Catch:{ JSONException -> 0x00aa }
            java.lang.String r7 = com.apm.insight.l.i.c((java.lang.String) r7)     // Catch:{ JSONException -> 0x00aa }
            org.json.JSONObject r8 = new org.json.JSONObject     // Catch:{ JSONException -> 0x00aa }
            r8.<init>(r7)     // Catch:{ JSONException -> 0x00aa }
            int r7 = r8.length()     // Catch:{ JSONException -> 0x00aa }
            if (r7 <= 0) goto L_0x00b2
            r3.c((org.json.JSONObject) r8)     // Catch:{ JSONException -> 0x00aa }
            goto L_0x00b2
        L_0x00aa:
            r7 = move-exception
            com.apm.insight.c r8 = com.apm.insight.b.a()     // Catch:{ IOException -> 0x0110 }
            r8.a((java.lang.String) r0, (java.lang.Throwable) r7)     // Catch:{ IOException -> 0x0110 }
        L_0x00b2:
            int r6 = r6 + 1
            goto L_0x006b
        L_0x00b5:
            org.json.JSONObject r3 = r3.h()     // Catch:{ IOException -> 0x0110 }
            int r6 = r3.length()     // Catch:{ all -> 0x00d2 }
            if (r6 == 0) goto L_0x00d2
            java.lang.String r6 = "storage"
            java.lang.Object r6 = r3.opt(r6)     // Catch:{ all -> 0x00d2 }
            if (r6 != 0) goto L_0x00d2
            android.content.Context r6 = com.apm.insight.h.g()     // Catch:{ all -> 0x00d2 }
            org.json.JSONObject r6 = com.apm.insight.l.w.a((android.content.Context) r6)     // Catch:{ all -> 0x00d2 }
            com.apm.insight.entity.a.a((org.json.JSONObject) r3, (org.json.JSONObject) r6)     // Catch:{ all -> 0x00d2 }
        L_0x00d2:
            int r6 = r3.length()     // Catch:{ IOException -> 0x0110 }
            if (r6 == 0) goto L_0x0118
            r10.b = r3     // Catch:{ IOException -> 0x0110 }
            com.apm.insight.l.i.b(r2, r3, r5)     // Catch:{ IOException -> 0x0110 }
            boolean r2 = r2.renameTo(r1)     // Catch:{ IOException -> 0x0110 }
            if (r2 == 0) goto L_0x0118
        L_0x00e3:
            int r2 = com.apm.insight.nativecrash.NativeCrashCollector.a()     // Catch:{ IOException -> 0x0110 }
            if (r5 >= r2) goto L_0x0118
            java.io.File r2 = new java.io.File     // Catch:{ IOException -> 0x0110 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0110 }
            r3.<init>()     // Catch:{ IOException -> 0x0110 }
            java.lang.String r6 = r1.getAbsolutePath()     // Catch:{ IOException -> 0x0110 }
            r3.append(r6)     // Catch:{ IOException -> 0x0110 }
            r3.append(r4)     // Catch:{ IOException -> 0x0110 }
            r3.append(r5)     // Catch:{ IOException -> 0x0110 }
            java.lang.String r3 = r3.toString()     // Catch:{ IOException -> 0x0110 }
            r2.<init>(r3)     // Catch:{ IOException -> 0x0110 }
            boolean r3 = r2.exists()     // Catch:{ IOException -> 0x0110 }
            if (r3 == 0) goto L_0x010d
            r2.delete()     // Catch:{ IOException -> 0x0110 }
        L_0x010d:
            int r5 = r5 + 1
            goto L_0x00e3
        L_0x0110:
            r1 = move-exception
            com.apm.insight.c r2 = com.apm.insight.b.a()
            r2.a((java.lang.String) r0, (java.lang.Throwable) r1)
        L_0x0118:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.apm.insight.nativecrash.b.e():void");
    }

    public boolean f() {
        ICrashFilter b2 = h.b().b();
        if (b2 == null) {
            return true;
        }
        try {
            return b2.onNativeCrashFilter(b(), "");
        } catch (Throwable th) {
            com.apm.insight.b.a().a("NPTH_CATCH", th);
            return true;
        }
    }

    public boolean g() {
        return com.apm.insight.e.a.a().a(o.f(this.c.b()).getAbsolutePath());
    }

    public void h() {
        com.apm.insight.e.a.a().a(com.apm.insight.e.a.a.a(o.f(this.c.b()).getAbsolutePath()));
    }

    public JSONObject j() {
        try {
            com.apm.insight.entity.a aVar = new com.apm.insight.entity.a();
            a(aVar);
            h(aVar);
            c(aVar);
            d(aVar);
            e(aVar);
            g(aVar);
            f(aVar);
            b(aVar);
            File f2 = o.f(this.c.b());
            JSONObject h = aVar.h();
            i.a(f2, h, false);
            return h;
        } catch (Throwable th) {
            com.apm.insight.b.a().a("NPTH_CATCH", th);
            return null;
        }
    }

    public boolean k() {
        return i.a(this.c.b());
    }

    public void l() {
        try {
            String absolutePath = this.c.b().getAbsolutePath();
            i.c(absolutePath, Environment.getExternalStorageDirectory().getAbsolutePath() + "/" + "localDebug" + "/" + h.g().getPackageName() + "/" + this.c.b().getName() + ".zip");
        } catch (Throwable th) {
            com.apm.insight.b.a().a("NPTH_CATCH", th);
        }
    }
}
