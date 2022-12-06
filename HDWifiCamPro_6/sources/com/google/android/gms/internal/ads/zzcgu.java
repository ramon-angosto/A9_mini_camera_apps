package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads-lite@@21.3.0 */
public class zzcgu implements zzcgh {
    private final String zza;

    public zzcgu() {
        this.zza = null;
    }

    public zzcgu(String str) {
        this.zza = str;
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0089  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean zza(java.lang.String r7) {
        /*
            r6 = this;
            java.lang.String r0 = ". "
            r1 = 0
            boolean r2 = com.google.android.gms.common.util.ClientLibraryUtils.isPackageSide()     // Catch:{ IndexOutOfBoundsException -> 0x0091, IOException -> 0x008f, RuntimeException -> 0x008d }
            if (r2 == 0) goto L_0x000e
            r2 = 263(0x107, float:3.69E-43)
            android.net.TrafficStats.setThreadStatsTag(r2)     // Catch:{ IndexOutOfBoundsException -> 0x0091, IOException -> 0x008f, RuntimeException -> 0x008d }
        L_0x000e:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ IndexOutOfBoundsException -> 0x0091, IOException -> 0x008f, RuntimeException -> 0x008d }
            r2.<init>()     // Catch:{ IndexOutOfBoundsException -> 0x0091, IOException -> 0x008f, RuntimeException -> 0x008d }
            java.lang.String r3 = "Pinging URL: "
            r2.append(r3)     // Catch:{ IndexOutOfBoundsException -> 0x0091, IOException -> 0x008f, RuntimeException -> 0x008d }
            r2.append(r7)     // Catch:{ IndexOutOfBoundsException -> 0x0091, IOException -> 0x008f, RuntimeException -> 0x008d }
            java.lang.String r2 = r2.toString()     // Catch:{ IndexOutOfBoundsException -> 0x0091, IOException -> 0x008f, RuntimeException -> 0x008d }
            com.google.android.gms.internal.ads.zzcgp.zze(r2)     // Catch:{ IndexOutOfBoundsException -> 0x0091, IOException -> 0x008f, RuntimeException -> 0x008d }
            java.net.URL r2 = new java.net.URL     // Catch:{ IndexOutOfBoundsException -> 0x0091, IOException -> 0x008f, RuntimeException -> 0x008d }
            r2.<init>(r7)     // Catch:{ IndexOutOfBoundsException -> 0x0091, IOException -> 0x008f, RuntimeException -> 0x008d }
            java.net.URLConnection r2 = r2.openConnection()     // Catch:{ IndexOutOfBoundsException -> 0x0091, IOException -> 0x008f, RuntimeException -> 0x008d }
            java.net.HttpURLConnection r2 = (java.net.HttpURLConnection) r2     // Catch:{ IndexOutOfBoundsException -> 0x0091, IOException -> 0x008f, RuntimeException -> 0x008d }
            com.google.android.gms.ads.internal.client.zzaw.zzb()     // Catch:{ all -> 0x0093 }
            java.lang.String r3 = r6.zza     // Catch:{ all -> 0x0093 }
            r4 = 60000(0xea60, float:8.4078E-41)
            r2.setConnectTimeout(r4)     // Catch:{ all -> 0x0093 }
            r5 = 1
            r2.setInstanceFollowRedirects(r5)     // Catch:{ all -> 0x0093 }
            r2.setReadTimeout(r4)     // Catch:{ all -> 0x0093 }
            if (r3 == 0) goto L_0x0046
            java.lang.String r4 = "User-Agent"
            r2.setRequestProperty(r4, r3)     // Catch:{ all -> 0x0093 }
        L_0x0046:
            r2.setUseCaches(r1)     // Catch:{ all -> 0x0093 }
            com.google.android.gms.internal.ads.zzcgo r3 = new com.google.android.gms.internal.ads.zzcgo     // Catch:{ all -> 0x0093 }
            r4 = 0
            r3.<init>(r4)     // Catch:{ all -> 0x0093 }
            r3.zzc(r2, r4)     // Catch:{ all -> 0x0093 }
            int r4 = r2.getResponseCode()     // Catch:{ all -> 0x0093 }
            r3.zze(r2, r4)     // Catch:{ all -> 0x0093 }
            r3 = 200(0xc8, float:2.8E-43)
            if (r4 < r3) goto L_0x0064
            r3 = 300(0x12c, float:4.2E-43)
            if (r4 < r3) goto L_0x0062
            goto L_0x0064
        L_0x0062:
            r1 = r5
            goto L_0x0080
        L_0x0064:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0093 }
            r3.<init>()     // Catch:{ all -> 0x0093 }
            java.lang.String r5 = "Received non-success response code "
            r3.append(r5)     // Catch:{ all -> 0x0093 }
            r3.append(r4)     // Catch:{ all -> 0x0093 }
            java.lang.String r4 = " from pinging URL: "
            r3.append(r4)     // Catch:{ all -> 0x0093 }
            r3.append(r7)     // Catch:{ all -> 0x0093 }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x0093 }
            com.google.android.gms.internal.ads.zzcgp.zzj(r3)     // Catch:{ all -> 0x0093 }
        L_0x0080:
            r2.disconnect()     // Catch:{ IndexOutOfBoundsException -> 0x0091, IOException -> 0x008f, RuntimeException -> 0x008d }
            boolean r7 = com.google.android.gms.common.util.ClientLibraryUtils.isPackageSide()
            if (r7 == 0) goto L_0x00e7
            android.net.TrafficStats.clearThreadStatsTag()
            return r1
        L_0x008d:
            r2 = move-exception
            goto L_0x009a
        L_0x008f:
            r2 = move-exception
            goto L_0x009a
        L_0x0091:
            r2 = move-exception
            goto L_0x00c3
        L_0x0093:
            r3 = move-exception
            r2.disconnect()     // Catch:{ IndexOutOfBoundsException -> 0x0091, IOException -> 0x008f, RuntimeException -> 0x008d }
            throw r3     // Catch:{ IndexOutOfBoundsException -> 0x0091, IOException -> 0x008f, RuntimeException -> 0x008d }
        L_0x0098:
            r7 = move-exception
            goto L_0x00ec
        L_0x009a:
            java.lang.String r2 = r2.getMessage()     // Catch:{ all -> 0x0098 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0098 }
            r3.<init>()     // Catch:{ all -> 0x0098 }
            java.lang.String r4 = "Error while pinging URL: "
            r3.append(r4)     // Catch:{ all -> 0x0098 }
            r3.append(r7)     // Catch:{ all -> 0x0098 }
            r3.append(r0)     // Catch:{ all -> 0x0098 }
            r3.append(r2)     // Catch:{ all -> 0x0098 }
            java.lang.String r7 = r3.toString()     // Catch:{ all -> 0x0098 }
            com.google.android.gms.internal.ads.zzcgp.zzj(r7)     // Catch:{ all -> 0x0098 }
            boolean r7 = com.google.android.gms.common.util.ClientLibraryUtils.isPackageSide()
            if (r7 != 0) goto L_0x00bf
            goto L_0x00e7
        L_0x00bf:
            android.net.TrafficStats.clearThreadStatsTag()
            return r1
        L_0x00c3:
            java.lang.String r2 = r2.getMessage()     // Catch:{ all -> 0x0098 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0098 }
            r3.<init>()     // Catch:{ all -> 0x0098 }
            java.lang.String r4 = "Error while parsing ping URL: "
            r3.append(r4)     // Catch:{ all -> 0x0098 }
            r3.append(r7)     // Catch:{ all -> 0x0098 }
            r3.append(r0)     // Catch:{ all -> 0x0098 }
            r3.append(r2)     // Catch:{ all -> 0x0098 }
            java.lang.String r7 = r3.toString()     // Catch:{ all -> 0x0098 }
            com.google.android.gms.internal.ads.zzcgp.zzj(r7)     // Catch:{ all -> 0x0098 }
            boolean r7 = com.google.android.gms.common.util.ClientLibraryUtils.isPackageSide()
            if (r7 != 0) goto L_0x00e8
        L_0x00e7:
            return r1
        L_0x00e8:
            android.net.TrafficStats.clearThreadStatsTag()
            return r1
        L_0x00ec:
            boolean r0 = com.google.android.gms.common.util.ClientLibraryUtils.isPackageSide()
            if (r0 == 0) goto L_0x00f5
            android.net.TrafficStats.clearThreadStatsTag()
        L_0x00f5:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcgu.zza(java.lang.String):boolean");
    }
}
