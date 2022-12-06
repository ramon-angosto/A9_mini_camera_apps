package com.apm.insight.g;

import android.content.Context;
import android.os.Process;
import android.os.SystemClock;
import com.apm.insight.CrashType;
import com.apm.insight.Npth;
import com.apm.insight.b.g;
import com.apm.insight.c.b;
import com.apm.insight.entity.a;
import com.apm.insight.h;
import com.apm.insight.l.i;
import com.apm.insight.l.o;
import com.apm.insight.l.r;
import com.apm.insight.l.v;
import com.apm.insight.nativecrash.NativeImpl;
import com.apm.insight.runtime.a.c;
import com.apm.insight.runtime.a.f;
import com.apm.insight.runtime.k;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSchemeDataSource;
import java.io.File;
import java.io.IOException;
import org.json.JSONArray;
import org.json.JSONObject;

public class d implements c {
    /* access modifiers changed from: private */
    public Context a;

    public d(Context context) {
        this.a = context;
    }

    public static int a() {
        return 6;
    }

    public void a(long j, Thread thread, Throwable th, String str, File file, String str2, boolean z) {
        final String str3 = str;
        final File file2 = new File(o.a(this.a), str3);
        a.a().a(file2.getName());
        file2.mkdirs();
        i.f(file2);
        final boolean c = v.c(th);
        final Throwable th2 = th;
        final long j2 = j;
        final String str4 = str2;
        final boolean z2 = z;
        final Thread thread2 = thread;
        a a2 = f.a().a(CrashType.JAVA, (a) null, new c.a() {
            long a = 0;

            public a a(int i2, a aVar) {
                String valueOf;
                String str;
                Object b2;
                String str2;
                this.a = SystemClock.uptimeMillis();
                if (i2 != 0) {
                    if (i2 == 1) {
                        Thread thread = thread2;
                        aVar.a("crash_thread_name", (Object) thread != null ? thread.getName() : "");
                        aVar.a("tid", (Object) Integer.valueOf(Process.myTid()));
                        String str3 = "true";
                        aVar.a("crash_after_crash", Npth.hasCrashWhenJavaCrash() ? str3 : "false");
                        if (!NativeImpl.d()) {
                            str3 = "false";
                        }
                        aVar.a("crash_after_native", str3);
                        a.a().a(thread2, th2, false, aVar);
                    } else if (i2 != 2) {
                        if (i2 == 3) {
                            JSONObject b3 = v.b(Thread.currentThread().getName());
                            if (b3 != null) {
                                aVar.a("all_thread_stacks", (Object) b3);
                            }
                            b2 = k.b(h.f());
                            str2 = "logcat";
                        } else if (i2 != 4) {
                            if (i2 == 5) {
                                b2 = str3;
                                str2 = "crash_uuid";
                            }
                        } else if (!c) {
                            com.apm.insight.l.a.a(d.this.a, aVar.h());
                        }
                        aVar.a(str2, b2);
                    } else {
                        if (c) {
                            com.apm.insight.l.a.a(d.this.a, aVar.h());
                        }
                        JSONArray c2 = g.b().c();
                        long uptimeMillis = SystemClock.uptimeMillis();
                        JSONObject a2 = g.b().a(uptimeMillis).a();
                        JSONArray a3 = com.apm.insight.b.k.a(100, uptimeMillis);
                        aVar.a("history_message", (Object) c2);
                        aVar.a("current_message", (Object) a2);
                        aVar.a("pending_messages", (Object) a3);
                        aVar.a("disable_looper_monitor", String.valueOf(com.apm.insight.runtime.a.d()));
                        valueOf = String.valueOf(b.a());
                        str = "npth_force_apm_crash";
                    }
                    return aVar;
                }
                aVar.a(DataSchemeDataSource.SCHEME_DATA, (Object) v.a(th2));
                aVar.a("isOOM", (Object) Boolean.valueOf(c));
                aVar.a("isJava", (Object) 1);
                aVar.a("crash_time", (Object) Long.valueOf(j2));
                aVar.a("launch_mode", (Object) Integer.valueOf(com.apm.insight.runtime.a.b.b()));
                aVar.a("launch_time", (Object) Long.valueOf(com.apm.insight.runtime.a.b.c()));
                String str4 = str4;
                if (str4 != null) {
                    aVar.a("crash_md5", (Object) str4);
                    aVar.a("crash_md5", str4);
                    boolean z = z2;
                    if (z) {
                        valueOf = String.valueOf(z);
                        str = "has_ignore";
                    }
                }
                return aVar;
                aVar.a(str, valueOf);
                return aVar;
            }

            public a a(int i2, a aVar, boolean z) {
                if (r.a(r.b(i2))) {
                    return aVar;
                }
                try {
                    File file = file2;
                    i.a(new File(file, file2.getName() + "." + i2), aVar.h(), false);
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
                return aVar;
            }

            public void a(Throwable th) {
            }
        }, true);
        long currentTimeMillis = System.currentTimeMillis() - j;
        try {
            a2.a("crash_type", "normal");
            a2.b("crash_cost", String.valueOf(currentTimeMillis));
            a2.a("crash_cost", String.valueOf(currentTimeMillis / 1000));
        } catch (Throwable th3) {
            com.apm.insight.b.a().a("NPTH_CATCH", th3);
        }
        if (!r.a(4)) {
            boolean a3 = r.a(2048);
        }
    }

    public boolean a(Throwable th) {
        return true;
    }
}
