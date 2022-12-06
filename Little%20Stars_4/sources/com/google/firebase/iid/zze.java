package com.google.firebase.iid;

import com.xiaomi.mipush.sdk.Constants;

public class zze {
    private static final Object zzrs = new Object();
    private final zzg zzbSQ;

    zze(zzg zzg) {
        this.zzbSQ = zzg;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0029, code lost:
        return null;
     */
    @android.support.annotation.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String zzUu() {
        /*
            r5 = this;
            java.lang.Object r0 = zzrs
            monitor-enter(r0)
            com.google.firebase.iid.zzg r1 = r5.zzbSQ     // Catch:{ all -> 0x002a }
            android.content.SharedPreferences r1 = r1.zzUv()     // Catch:{ all -> 0x002a }
            java.lang.String r2 = "topic_operaion_queue"
            r3 = 0
            java.lang.String r1 = r1.getString(r2, r3)     // Catch:{ all -> 0x002a }
            if (r1 == 0) goto L_0x0028
            java.lang.String r2 = ","
            java.lang.String[] r1 = r1.split(r2)     // Catch:{ all -> 0x002a }
            int r2 = r1.length     // Catch:{ all -> 0x002a }
            r4 = 1
            if (r2 <= r4) goto L_0x0028
            r2 = r1[r4]     // Catch:{ all -> 0x002a }
            boolean r2 = android.text.TextUtils.isEmpty(r2)     // Catch:{ all -> 0x002a }
            if (r2 != 0) goto L_0x0028
            r1 = r1[r4]     // Catch:{ all -> 0x002a }
            monitor-exit(r0)     // Catch:{ all -> 0x002a }
            return r1
        L_0x0028:
            monitor-exit(r0)     // Catch:{ all -> 0x002a }
            return r3
        L_0x002a:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x002a }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.iid.zze.zzUu():java.lang.String");
    }

    /* access modifiers changed from: package-private */
    public boolean zziC(String str) {
        synchronized (zzrs) {
            String string = this.zzbSQ.zzUv().getString("topic_operaion_queue", "");
            String valueOf = String.valueOf(str);
            if (!string.startsWith(valueOf.length() != 0 ? Constants.ACCEPT_TIME_SEPARATOR_SP.concat(valueOf) : new String(Constants.ACCEPT_TIME_SEPARATOR_SP))) {
                return false;
            }
            String valueOf2 = String.valueOf(str);
            this.zzbSQ.zzUv().edit().putString("topic_operaion_queue", string.substring((valueOf2.length() != 0 ? Constants.ACCEPT_TIME_SEPARATOR_SP.concat(valueOf2) : new String(Constants.ACCEPT_TIME_SEPARATOR_SP)).length())).apply();
            return true;
        }
    }

    /* access modifiers changed from: package-private */
    public void zziy(String str) {
        synchronized (zzrs) {
            String string = this.zzbSQ.zzUv().getString("topic_operaion_queue", "");
            StringBuilder sb = new StringBuilder(String.valueOf(string).length() + 0 + Constants.ACCEPT_TIME_SEPARATOR_SP.length() + String.valueOf(str).length());
            sb.append(string);
            sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
            sb.append(str);
            this.zzbSQ.zzUv().edit().putString("topic_operaion_queue", sb.toString()).apply();
        }
    }
}
