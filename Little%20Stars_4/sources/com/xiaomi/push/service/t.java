package com.xiaomi.push.service;

import android.os.Process;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.network.Host;
import com.xiaomi.push.protobuf.a;
import com.xiaomi.stats.f;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.Reader;
import java.net.Socket;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

public class t {
    private static final Pattern a = Pattern.compile("([0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3})");
    private static long b = 0;
    private static ThreadPoolExecutor c = new ThreadPoolExecutor(1, 1, 20, TimeUnit.SECONDS, new LinkedBlockingQueue());

    public static void a() {
        a.C0052a d;
        long currentTimeMillis = System.currentTimeMillis();
        if ((c.getActiveCount() <= 0 || currentTimeMillis - b >= 1800000) && f.a().c() && (d = ah.a().d()) != null && d.l() > 0) {
            b = currentTimeMillis;
            a(d.k(), true);
        }
    }

    public static void a(List<String> list, boolean z) {
        c.execute(new u(list, z));
    }

    public static void b() {
        String c2 = c("/proc/self/net/tcp");
        if (!TextUtils.isEmpty(c2)) {
            b.a("dump tcp for uid = " + Process.myUid());
            b.a(c2);
        }
        String c3 = c("/proc/self/net/tcp6");
        if (!TextUtils.isEmpty(c3)) {
            b.a("dump tcp6 for uid = " + Process.myUid());
            b.a(c3);
        }
    }

    /* access modifiers changed from: private */
    public static boolean b(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        try {
            b.a("ConnectivityTest: begin to connect to " + str);
            Socket socket = new Socket();
            socket.connect(Host.b(str, 5222), 5000);
            socket.setTcpNoDelay(true);
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            b.a("ConnectivityTest: connect to " + str + " in " + currentTimeMillis2);
            socket.close();
            return true;
        } catch (Throwable th) {
            b.d("ConnectivityTest: could not connect to:" + str + " exception: " + th.getClass().getSimpleName() + " description: " + th.getMessage());
            return false;
        }
    }

    private static String c(String str) {
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
                        com.xiaomi.channel.commonutils.file.a.a((Reader) bufferedReader);
                        return sb2;
                    }
                }
            } catch (Exception unused) {
                com.xiaomi.channel.commonutils.file.a.a((Reader) bufferedReader);
                return null;
            } catch (Throwable th2) {
                th = th2;
                com.xiaomi.channel.commonutils.file.a.a((Reader) bufferedReader);
                throw th;
            }
        } catch (Exception unused2) {
            bufferedReader = null;
            com.xiaomi.channel.commonutils.file.a.a((Reader) bufferedReader);
            return null;
        } catch (Throwable th3) {
            bufferedReader = null;
            th = th3;
            com.xiaomi.channel.commonutils.file.a.a((Reader) bufferedReader);
            throw th;
        }
    }
}
