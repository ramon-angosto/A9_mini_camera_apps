package com.google.firebase.iid;

import android.text.TextUtils;
import android.util.Log;
import androidx.collection.ArrayMap;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.io.IOException;
import java.util.Map;

/* compiled from: com.google.firebase:firebase-iid@@20.0.0 */
final class zzax {
    private int zza = 0;
    private final Map<Integer, TaskCompletionSource<Void>> zzb = new ArrayMap();
    private final zzat zzc;

    zzax(zzat zzat) {
        this.zzc = zzat;
    }

    /* access modifiers changed from: package-private */
    public final synchronized Task<Void> zza(String str) {
        String zza2;
        TaskCompletionSource taskCompletionSource;
        int i;
        synchronized (this.zzc) {
            zza2 = this.zzc.zza();
            zzat zzat = this.zzc;
            StringBuilder sb = new StringBuilder(String.valueOf(zza2).length() + 1 + String.valueOf(str).length());
            sb.append(zza2);
            sb.append(",");
            sb.append(str);
            zzat.zza(sb.toString());
        }
        taskCompletionSource = new TaskCompletionSource();
        Map<Integer, TaskCompletionSource<Void>> map = this.zzb;
        if (TextUtils.isEmpty(zza2)) {
            i = 0;
        } else {
            i = zza2.split(",").length - 1;
        }
        map.put(Integer.valueOf(this.zza + i), taskCompletionSource);
        return taskCompletionSource.getTask();
    }

    /* access modifiers changed from: package-private */
    public final synchronized boolean zza() {
        return zzb() != null;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001c, code lost:
        if (zza(r5, r0) != false) goto L_0x0020;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001e, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0020, code lost:
        monitor-enter(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:?, code lost:
        r2 = r4.zzb.remove(java.lang.Integer.valueOf(r4.zza));
        zzb(r0);
        r4.zza++;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0037, code lost:
        monitor-exit(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0038, code lost:
        if (r2 == null) goto L_0x0000;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x003a, code lost:
        r2.setResult(null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0016, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zza(com.google.firebase.iid.FirebaseInstanceId r5) throws java.io.IOException {
        /*
            r4 = this;
        L_0x0000:
            monitor-enter(r4)
            java.lang.String r0 = r4.zzb()     // Catch:{ all -> 0x0042 }
            r1 = 1
            if (r0 != 0) goto L_0x0017
            boolean r5 = com.google.firebase.iid.FirebaseInstanceId.zzd()     // Catch:{ all -> 0x0042 }
            if (r5 == 0) goto L_0x0015
            java.lang.String r5 = "FirebaseInstanceId"
            java.lang.String r0 = "topic sync succeeded"
            android.util.Log.d(r5, r0)     // Catch:{ all -> 0x0042 }
        L_0x0015:
            monitor-exit(r4)     // Catch:{ all -> 0x0042 }
            return r1
        L_0x0017:
            monitor-exit(r4)     // Catch:{ all -> 0x0042 }
            boolean r2 = zza(r5, r0)
            if (r2 != 0) goto L_0x0020
            r5 = 0
            return r5
        L_0x0020:
            monitor-enter(r4)
            java.util.Map<java.lang.Integer, com.google.android.gms.tasks.TaskCompletionSource<java.lang.Void>> r2 = r4.zzb     // Catch:{ all -> 0x003f }
            int r3 = r4.zza     // Catch:{ all -> 0x003f }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ all -> 0x003f }
            java.lang.Object r2 = r2.remove(r3)     // Catch:{ all -> 0x003f }
            com.google.android.gms.tasks.TaskCompletionSource r2 = (com.google.android.gms.tasks.TaskCompletionSource) r2     // Catch:{ all -> 0x003f }
            r4.zzb(r0)     // Catch:{ all -> 0x003f }
            int r0 = r4.zza     // Catch:{ all -> 0x003f }
            int r0 = r0 + r1
            r4.zza = r0     // Catch:{ all -> 0x003f }
            monitor-exit(r4)     // Catch:{ all -> 0x003f }
            if (r2 == 0) goto L_0x0000
            r0 = 0
            r2.setResult(r0)
            goto L_0x0000
        L_0x003f:
            r5 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x003f }
            throw r5
        L_0x0042:
            r5 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x0042 }
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.iid.zzax.zza(com.google.firebase.iid.FirebaseInstanceId):boolean");
    }

    private final String zzb() {
        String zza2;
        synchronized (this.zzc) {
            zza2 = this.zzc.zza();
        }
        if (TextUtils.isEmpty(zza2)) {
            return null;
        }
        String[] split = zza2.split(",");
        if (split.length <= 1 || TextUtils.isEmpty(split[1])) {
            return null;
        }
        return split[1];
    }

    private final synchronized boolean zzb(String str) {
        synchronized (this.zzc) {
            String zza2 = this.zzc.zza();
            String valueOf = String.valueOf(str);
            if (!zza2.startsWith(valueOf.length() != 0 ? ",".concat(valueOf) : new String(","))) {
                return false;
            }
            String valueOf2 = String.valueOf(str);
            this.zzc.zza(zza2.substring((valueOf2.length() != 0 ? ",".concat(valueOf2) : new String(",")).length()));
            return true;
        }
    }

    private static boolean zza(FirebaseInstanceId firebaseInstanceId, String str) throws IOException {
        String[] split = str.split("!");
        if (split.length == 2) {
            String str2 = split[0];
            String str3 = split[1];
            char c = 65535;
            try {
                int hashCode = str2.hashCode();
                if (hashCode != 83) {
                    if (hashCode == 85) {
                        if (str2.equals("U")) {
                            c = 1;
                        }
                    }
                } else if (str2.equals("S")) {
                    c = 0;
                }
                if (c == 0) {
                    firebaseInstanceId.zzb(str3);
                    if (FirebaseInstanceId.zzd()) {
                        Log.d("FirebaseInstanceId", "subscribe operation succeeded");
                    }
                } else if (c == 1) {
                    firebaseInstanceId.zzc(str3);
                    if (FirebaseInstanceId.zzd()) {
                        Log.d("FirebaseInstanceId", "unsubscribe operation succeeded");
                    }
                }
            } catch (IOException e) {
                if ("SERVICE_NOT_AVAILABLE".equals(e.getMessage()) || "INTERNAL_SERVER_ERROR".equals(e.getMessage())) {
                    String message = e.getMessage();
                    StringBuilder sb = new StringBuilder(String.valueOf(message).length() + 53);
                    sb.append("Topic operation failed: ");
                    sb.append(message);
                    sb.append(". Will retry Topic operation.");
                    Log.e("FirebaseInstanceId", sb.toString());
                    return false;
                } else if (e.getMessage() == null) {
                    Log.e("FirebaseInstanceId", "Topic operation failed without exception message. Will retry Topic operation.");
                    return false;
                } else {
                    throw e;
                }
            }
        }
        return true;
    }
}
