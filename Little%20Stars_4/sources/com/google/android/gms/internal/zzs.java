package com.google.android.gms.internal;

import android.os.SystemClock;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class zzs {
    public static boolean DEBUG = Log.isLoggable(TAG, 2);
    public static String TAG = "Volley";

    static class zza {
        public static final boolean zzaj = zzs.DEBUG;
        private final List<C0026zza> zzak = new ArrayList();
        private boolean zzal = false;

        /* renamed from: com.google.android.gms.internal.zzs$zza$zza  reason: collision with other inner class name */
        private static class C0026zza {
            public final String name;
            public final long time;
            public final long zzam;

            public C0026zza(String str, long j, long j2) {
                this.name = str;
                this.zzam = j;
                this.time = j2;
            }
        }

        zza() {
        }

        private long zzw() {
            if (this.zzak.size() == 0) {
                return 0;
            }
            long j = this.zzak.get(0).time;
            List<C0026zza> list = this.zzak;
            return list.get(list.size() - 1).time - j;
        }

        /* access modifiers changed from: protected */
        public void finalize() throws Throwable {
            if (!this.zzal) {
                zzd("Request on the loose");
                zzs.zzc("Marker log finalized without finish() - uncaught exit point for request", new Object[0]);
            }
        }

        public synchronized void zza(String str, long j) {
            if (!this.zzal) {
                this.zzak.add(new C0026zza(str, j, SystemClock.elapsedRealtime()));
            } else {
                throw new IllegalStateException("Marker added to finished log");
            }
        }

        public synchronized void zzd(String str) {
            this.zzal = true;
            long zzw = zzw();
            if (zzw > 0) {
                long j = this.zzak.get(0).time;
                zzs.zzb("(%-4d ms) %s", Long.valueOf(zzw), str);
                for (C0026zza next : this.zzak) {
                    long j2 = next.time;
                    zzs.zzb("(+%-4d) [%2d] %s", Long.valueOf(j2 - j), Long.valueOf(next.zzam), next.name);
                    j = j2;
                }
            }
        }
    }

    public static void zza(String str, Object... objArr) {
        if (DEBUG) {
            Log.v(TAG, zzd(str, objArr));
        }
    }

    public static void zza(Throwable th, String str, Object... objArr) {
        Log.e(TAG, zzd(str, objArr), th);
    }

    public static void zzb(String str, Object... objArr) {
        Log.d(TAG, zzd(str, objArr));
    }

    public static void zzc(String str, Object... objArr) {
        Log.e(TAG, zzd(str, objArr));
    }

    private static String zzd(String str, Object... objArr) {
        String str2;
        if (objArr != null) {
            str = String.format(Locale.US, str, objArr);
        }
        StackTraceElement[] stackTrace = new Throwable().fillInStackTrace().getStackTrace();
        int i = 2;
        while (true) {
            if (i >= stackTrace.length) {
                str2 = "<unknown>";
                break;
            } else if (!stackTrace[i].getClass().equals(zzs.class)) {
                String className = stackTrace[i].getClassName();
                String substring = className.substring(className.lastIndexOf(46) + 1);
                String substring2 = substring.substring(substring.lastIndexOf(36) + 1);
                String valueOf = String.valueOf(stackTrace[i].getMethodName());
                StringBuilder sb = new StringBuilder(String.valueOf(substring2).length() + 1 + String.valueOf(valueOf).length());
                sb.append(substring2);
                sb.append(".");
                sb.append(valueOf);
                str2 = sb.toString();
                break;
            } else {
                i++;
            }
        }
        return String.format(Locale.US, "[%d] %s: %s", new Object[]{Long.valueOf(Thread.currentThread().getId()), str2, str});
    }
}
