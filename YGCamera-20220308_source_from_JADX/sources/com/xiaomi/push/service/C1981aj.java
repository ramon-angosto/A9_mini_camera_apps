package com.xiaomi.push.service;

import android.os.Process;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.C1524b;
import com.xiaomi.push.C1608aa;
import com.xiaomi.push.C1700cs;
import com.xiaomi.push.C1745ec;
import com.xiaomi.push.C1857hg;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileReader;
import java.net.Socket;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

/* renamed from: com.xiaomi.push.service.aj */
public class C1981aj {

    /* renamed from: a */
    private static long f3684a = 0;

    /* renamed from: a */
    private static ThreadPoolExecutor f3685a = new ThreadPoolExecutor(1, 1, 20, TimeUnit.SECONDS, new LinkedBlockingQueue());

    /* renamed from: a */
    private static final Pattern f3686a = Pattern.compile("([0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3})");

    /* renamed from: a */
    private static String m4956a(String str) {
        BufferedReader bufferedReader;
        Throwable th;
        try {
            bufferedReader = new BufferedReader(new FileReader(new File(str)));
            try {
                StringBuilder sb = new StringBuilder();
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine != null) {
                        sb.append("\n");
                        sb.append(readLine);
                    } else {
                        String sb2 = sb.toString();
                        C1608aa.m2491a((Closeable) bufferedReader);
                        return sb2;
                    }
                }
            } catch (Exception unused) {
                C1608aa.m2491a((Closeable) bufferedReader);
                return null;
            } catch (Throwable th2) {
                th = th2;
                C1608aa.m2491a((Closeable) bufferedReader);
                throw th;
            }
        } catch (Exception unused2) {
            bufferedReader = null;
            C1608aa.m2491a((Closeable) bufferedReader);
            return null;
        } catch (Throwable th3) {
            bufferedReader = null;
            th = th3;
            C1608aa.m2491a((Closeable) bufferedReader);
            throw th;
        }
    }

    /* renamed from: a */
    public static void m4957a() {
        C1745ec.C1746a a;
        long currentTimeMillis = System.currentTimeMillis();
        if ((f3685a.getActiveCount() <= 0 || currentTimeMillis - f3684a >= 1800000) && C1857hg.mo17753a().mo17753a() && (a = C2027bo.mo18506a().mo18506a()) != null && a.mo17422e() > 0) {
            f3684a = currentTimeMillis;
            m4958a(a.mo17407a(), true);
        }
    }

    /* renamed from: a */
    public static void m4958a(List<String> list, boolean z) {
        f3685a.execute(new C1982ak(list, z));
    }

    /* renamed from: b */
    public static void m4960b() {
        String a = m4956a("/proc/self/net/tcp");
        if (!TextUtils.isEmpty(a)) {
            C1524b.m2141a("dump tcp for uid = " + Process.myUid());
            C1524b.m2141a(a);
        }
        String a2 = m4956a("/proc/self/net/tcp6");
        if (!TextUtils.isEmpty(a2)) {
            C1524b.m2141a("dump tcp6 for uid = " + Process.myUid());
            C1524b.m2141a(a2);
        }
    }

    /* renamed from: b */
    private static boolean m4961b(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        try {
            C1524b.m2141a("ConnectivityTest: begin to connect to " + str);
            Socket socket = new Socket();
            socket.connect(C1700cs.m2904a(str, 5222), 5000);
            socket.setTcpNoDelay(true);
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            C1524b.m2141a("ConnectivityTest: connect to " + str + " in " + currentTimeMillis2);
            socket.close();
            return true;
        } catch (Throwable th) {
            C1524b.m2160d("ConnectivityTest: could not connect to:" + str + " exception: " + th.getClass().getSimpleName() + " description: " + th.getMessage());
            return false;
        }
    }
}
