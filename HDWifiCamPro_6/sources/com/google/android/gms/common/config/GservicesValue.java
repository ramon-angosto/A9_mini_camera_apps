package com.google.android.gms.common.config;

import android.util.Log;

/* compiled from: com.google.android.gms:play-services-basement@@18.0.0 */
public abstract class GservicesValue<T> {
    private static final Object zzc = new Object();
    protected final String zza;
    protected final T zzb;
    private T zzd = null;

    protected GservicesValue(String str, T t) {
        this.zza = str;
        this.zzb = t;
    }

    public static boolean isInitialized() {
        synchronized (zzc) {
        }
        return false;
    }

    public static GservicesValue<Float> value(String str, Float f) {
        return new zzd(str, f);
    }

    public static GservicesValue<Integer> value(String str, Integer num) {
        return new zzc(str, num);
    }

    public static GservicesValue<Long> value(String str, Long l) {
        return new zzb(str, l);
    }

    public static GservicesValue<String> value(String str, String str2) {
        return new zze(str, str2);
    }

    public static GservicesValue<Boolean> value(String str, boolean z) {
        return new zza(str, Boolean.valueOf(z));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x001b, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:?, code lost:
        r1 = android.os.Binder.clearCallingIdentity();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
        r3 = zza(r4.zza);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
        android.os.Binder.restoreCallingIdentity(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x002a, code lost:
        android.os.StrictMode.setThreadPolicy(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x002d, code lost:
        return r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x002e, code lost:
        r3 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:?, code lost:
        android.os.Binder.restoreCallingIdentity(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0032, code lost:
        throw r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0033, code lost:
        android.os.StrictMode.setThreadPolicy(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0036, code lost:
        throw r1;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:16:0x001d */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final T get() {
        /*
            r4 = this;
            T r0 = r4.zzd
            if (r0 == 0) goto L_0x0005
            return r0
        L_0x0005:
            android.os.StrictMode$ThreadPolicy r0 = android.os.StrictMode.allowThreadDiskReads()
            java.lang.Object r1 = zzc
            monitor-enter(r1)
            monitor-exit(r1)     // Catch:{ all -> 0x003a }
            java.lang.Object r2 = zzc
            monitor-enter(r2)
            monitor-exit(r2)     // Catch:{ all -> 0x0037 }
            java.lang.String r1 = r4.zza     // Catch:{ SecurityException -> 0x001d }
            java.lang.Object r1 = r4.zza(r1)     // Catch:{ SecurityException -> 0x001d }
            android.os.StrictMode.setThreadPolicy(r0)
            return r1
        L_0x001b:
            r1 = move-exception
            goto L_0x0033
        L_0x001d:
            long r1 = android.os.Binder.clearCallingIdentity()     // Catch:{ all -> 0x001b }
            java.lang.String r3 = r4.zza     // Catch:{ all -> 0x002e }
            java.lang.Object r3 = r4.zza(r3)     // Catch:{ all -> 0x002e }
            android.os.Binder.restoreCallingIdentity(r1)     // Catch:{ all -> 0x001b }
            android.os.StrictMode.setThreadPolicy(r0)
            return r3
        L_0x002e:
            r3 = move-exception
            android.os.Binder.restoreCallingIdentity(r1)     // Catch:{ all -> 0x001b }
            throw r3     // Catch:{ all -> 0x001b }
        L_0x0033:
            android.os.StrictMode.setThreadPolicy(r0)
            throw r1
        L_0x0037:
            r0 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x0037 }
            throw r0
        L_0x003a:
            r0 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x003a }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.config.GservicesValue.get():java.lang.Object");
    }

    @Deprecated
    public final T getBinderSafe() {
        return get();
    }

    public void override(T t) {
        Log.w("GservicesValue", "GservicesValue.override(): test should probably call initForTests() first");
        this.zzd = t;
        synchronized (zzc) {
            synchronized (zzc) {
            }
        }
    }

    public void resetOverride() {
        this.zzd = null;
    }

    /* access modifiers changed from: protected */
    public abstract T zza(String str);
}
