package com.huawei.hms.base.log;

import android.os.Process;
import android.util.Log;
import java.text.SimpleDateFormat;
import java.util.Locale;

/* renamed from: com.huawei.hms.base.log.c */
/* compiled from: LogRecord */
public class C0686c {

    /* renamed from: a */
    public final StringBuilder f422a = new StringBuilder();

    /* renamed from: b */
    public String f423b = null;

    /* renamed from: c */
    public String f424c = "HMS";

    /* renamed from: d */
    public int f425d = 0;

    /* renamed from: e */
    public long f426e = 0;

    /* renamed from: f */
    public long f427f = 0;

    /* renamed from: g */
    public String f428g;

    /* renamed from: h */
    public int f429h;

    /* renamed from: i */
    public int f430i;

    /* renamed from: j */
    public int f431j = 0;

    public C0686c(int i, String str, int i2, String str2) {
        this.f431j = i;
        this.f423b = str;
        this.f425d = i2;
        if (str2 != null) {
            this.f424c = str2;
        }
        mo13325b();
    }

    /* renamed from: a */
    public static String m404a(int i) {
        if (i == 3) {
            return "D";
        }
        if (i == 4) {
            return "I";
        }
        if (i != 5) {
            return i != 6 ? String.valueOf(i) : "E";
        }
        return "W";
    }

    /* renamed from: b */
    public final C0686c mo13325b() {
        this.f426e = System.currentTimeMillis();
        Thread currentThread = Thread.currentThread();
        this.f427f = currentThread.getId();
        this.f429h = Process.myPid();
        StackTraceElement[] stackTrace = currentThread.getStackTrace();
        int length = stackTrace.length;
        int i = this.f431j;
        if (length > i) {
            StackTraceElement stackTraceElement = stackTrace[i];
            this.f428g = stackTraceElement.getFileName();
            this.f430i = stackTraceElement.getLineNumber();
        }
        return this;
    }

    /* renamed from: c */
    public String mo13327c() {
        StringBuilder sb = new StringBuilder();
        mo13326b(sb);
        return sb.toString();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        mo13326b(sb);
        mo13324a(sb);
        return sb.toString();
    }

    /* renamed from: a */
    public <T> C0686c mo13321a(T t) {
        this.f422a.append(t);
        return this;
    }

    /* renamed from: a */
    public C0686c mo13322a(Throwable th) {
        mo13321a(10).mo13321a(Log.getStackTraceString(th));
        return this;
    }

    /* renamed from: a */
    public String mo13323a() {
        StringBuilder sb = new StringBuilder();
        mo13324a(sb);
        return sb.toString();
    }

    /* renamed from: a */
    public final StringBuilder mo13324a(StringBuilder sb) {
        sb.append(' ');
        sb.append(this.f422a.toString());
        return sb;
    }

    /* renamed from: b */
    public final StringBuilder mo13326b(StringBuilder sb) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.getDefault());
        sb.append('[');
        sb.append(simpleDateFormat.format(Long.valueOf(this.f426e)));
        String a = m404a(this.f425d);
        sb.append(' ');
        sb.append(a);
        sb.append('/');
        sb.append(this.f424c);
        sb.append('/');
        sb.append(this.f423b);
        sb.append(' ');
        sb.append(this.f429h);
        sb.append(':');
        sb.append(this.f427f);
        sb.append(' ');
        sb.append(this.f428g);
        sb.append(':');
        sb.append(this.f430i);
        sb.append(']');
        return sb;
    }
}
