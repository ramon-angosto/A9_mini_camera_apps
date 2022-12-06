package com.google.android.gms.internal;

import android.os.SystemClock;
import com.google.android.gms.internal.zzb;
import java.io.EOFException;
import java.io.File;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class zzv implements zzb {
    private final Map<String, zza> zzaw;
    private long zzax;
    private final File zzay;
    private final int zzaz;

    static class zza {
        public String zza;
        public long zzaA;
        public String zzaB;
        public long zzb;
        public long zzc;
        public long zzd;
        public long zze;
        public Map<String, String> zzf;

        private zza() {
        }

        public zza(String str, zzb.zza zza2) {
            this.zzaB = str;
            this.zzaA = (long) zza2.data.length;
            this.zza = zza2.zza;
            this.zzb = zza2.zzb;
            this.zzc = zza2.zzc;
            this.zzd = zza2.zzd;
            this.zze = zza2.zze;
            this.zzf = zza2.zzf;
        }

        public static zza zzf(InputStream inputStream) throws IOException {
            zza zza2 = new zza();
            if (zzv.zzb(inputStream) == 538247942) {
                zza2.zzaB = zzv.zzd(inputStream);
                zza2.zza = zzv.zzd(inputStream);
                if (zza2.zza.equals("")) {
                    zza2.zza = null;
                }
                zza2.zzb = zzv.zzc(inputStream);
                zza2.zzc = zzv.zzc(inputStream);
                zza2.zzd = zzv.zzc(inputStream);
                zza2.zze = zzv.zzc(inputStream);
                zza2.zzf = zzv.zze(inputStream);
                return zza2;
            }
            throw new IOException();
        }

        public boolean zza(OutputStream outputStream) {
            try {
                zzv.zza(outputStream, 538247942);
                zzv.zza(outputStream, this.zzaB);
                zzv.zza(outputStream, this.zza == null ? "" : this.zza);
                zzv.zza(outputStream, this.zzb);
                zzv.zza(outputStream, this.zzc);
                zzv.zza(outputStream, this.zzd);
                zzv.zza(outputStream, this.zze);
                zzv.zza(this.zzf, outputStream);
                outputStream.flush();
                return true;
            } catch (IOException e) {
                zzs.zzb("%s", e.toString());
                return false;
            }
        }

        public zzb.zza zzb(byte[] bArr) {
            zzb.zza zza2 = new zzb.zza();
            zza2.data = bArr;
            zza2.zza = this.zza;
            zza2.zzb = this.zzb;
            zza2.zzc = this.zzc;
            zza2.zzd = this.zzd;
            zza2.zze = this.zze;
            zza2.zzf = this.zzf;
            return zza2;
        }
    }

    private static class zzb extends FilterInputStream {
        /* access modifiers changed from: private */
        public int zzaC;

        private zzb(InputStream inputStream) {
            super(inputStream);
            this.zzaC = 0;
        }

        public int read() throws IOException {
            int read = super.read();
            if (read != -1) {
                this.zzaC++;
            }
            return read;
        }

        public int read(byte[] bArr, int i, int i2) throws IOException {
            int read = super.read(bArr, i, i2);
            if (read != -1) {
                this.zzaC += read;
            }
            return read;
        }
    }

    public zzv(File file) {
        this(file, 5242880);
    }

    public zzv(File file, int i) {
        this.zzaw = new LinkedHashMap(16, 0.75f, true);
        this.zzax = 0;
        this.zzay = file;
        this.zzaz = i;
    }

    private void removeEntry(String str) {
        zza zza2 = this.zzaw.get(str);
        if (zza2 != null) {
            this.zzax -= zza2.zzaA;
            this.zzaw.remove(str);
        }
    }

    private static int zza(InputStream inputStream) throws IOException {
        int read = inputStream.read();
        if (read != -1) {
            return read;
        }
        throw new EOFException();
    }

    static void zza(OutputStream outputStream, int i) throws IOException {
        outputStream.write((i >> 0) & 255);
        outputStream.write((i >> 8) & 255);
        outputStream.write((i >> 16) & 255);
        outputStream.write((i >> 24) & 255);
    }

    static void zza(OutputStream outputStream, long j) throws IOException {
        outputStream.write((byte) ((int) (j >>> 0)));
        outputStream.write((byte) ((int) (j >>> 8)));
        outputStream.write((byte) ((int) (j >>> 16)));
        outputStream.write((byte) ((int) (j >>> 24)));
        outputStream.write((byte) ((int) (j >>> 32)));
        outputStream.write((byte) ((int) (j >>> 40)));
        outputStream.write((byte) ((int) (j >>> 48)));
        outputStream.write((byte) ((int) (j >>> 56)));
    }

    static void zza(OutputStream outputStream, String str) throws IOException {
        byte[] bytes = str.getBytes("UTF-8");
        zza(outputStream, (long) bytes.length);
        outputStream.write(bytes, 0, bytes.length);
    }

    private void zza(String str, zza zza2) {
        if (!this.zzaw.containsKey(str)) {
            this.zzax += zza2.zzaA;
        } else {
            this.zzax += zza2.zzaA - this.zzaw.get(str).zzaA;
        }
        this.zzaw.put(str, zza2);
    }

    static void zza(Map<String, String> map, OutputStream outputStream) throws IOException {
        if (map != null) {
            zza(outputStream, map.size());
            for (Map.Entry next : map.entrySet()) {
                zza(outputStream, (String) next.getKey());
                zza(outputStream, (String) next.getValue());
            }
            return;
        }
        zza(outputStream, 0);
    }

    private static byte[] zza(InputStream inputStream, int i) throws IOException {
        byte[] bArr = new byte[i];
        int i2 = 0;
        while (i2 < i) {
            int read = inputStream.read(bArr, i2, i - i2);
            if (read == -1) {
                break;
            }
            i2 += read;
        }
        if (i2 == i) {
            return bArr;
        }
        StringBuilder sb = new StringBuilder(50);
        sb.append("Expected ");
        sb.append(i);
        sb.append(" bytes, read ");
        sb.append(i2);
        sb.append(" bytes");
        throw new IOException(sb.toString());
    }

    static int zzb(InputStream inputStream) throws IOException {
        return (zza(inputStream) << 24) | (zza(inputStream) << 0) | 0 | (zza(inputStream) << 8) | (zza(inputStream) << 16);
    }

    static long zzc(InputStream inputStream) throws IOException {
        return ((((long) zza(inputStream)) & 255) << 0) | 0 | ((((long) zza(inputStream)) & 255) << 8) | ((((long) zza(inputStream)) & 255) << 16) | ((((long) zza(inputStream)) & 255) << 24) | ((((long) zza(inputStream)) & 255) << 32) | ((((long) zza(inputStream)) & 255) << 40) | ((((long) zza(inputStream)) & 255) << 48) | ((255 & ((long) zza(inputStream))) << 56);
    }

    private void zzc(int i) {
        long j;
        long j2 = (long) i;
        if (this.zzax + j2 >= ((long) this.zzaz)) {
            if (zzs.DEBUG) {
                zzs.zza("Pruning old cache entries.", new Object[0]);
            }
            long j3 = this.zzax;
            long elapsedRealtime = SystemClock.elapsedRealtime();
            Iterator<Map.Entry<String, zza>> it = this.zzaw.entrySet().iterator();
            int i2 = 0;
            while (it.hasNext()) {
                zza zza2 = (zza) it.next().getValue();
                if (zzf(zza2.zzaB).delete()) {
                    j = j2;
                    this.zzax -= zza2.zzaA;
                } else {
                    j = j2;
                    zzs.zzb("Could not delete cache entry for key=%s, filename=%s", zza2.zzaB, zze(zza2.zzaB));
                }
                it.remove();
                i2++;
                if (((float) (this.zzax + j)) < ((float) this.zzaz) * 0.9f) {
                    break;
                }
                j2 = j;
            }
            if (zzs.DEBUG) {
                zzs.zza("pruned %d files, %d bytes, %d ms", Integer.valueOf(i2), Long.valueOf(this.zzax - j3), Long.valueOf(SystemClock.elapsedRealtime() - elapsedRealtime));
            }
        }
    }

    static String zzd(InputStream inputStream) throws IOException {
        return new String(zza(inputStream, (int) zzc(inputStream)), "UTF-8");
    }

    private String zze(String str) {
        int length = str.length() / 2;
        String valueOf = String.valueOf(String.valueOf(str.substring(0, length).hashCode()));
        String valueOf2 = String.valueOf(String.valueOf(str.substring(length).hashCode()));
        return valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
    }

    static Map<String, String> zze(InputStream inputStream) throws IOException {
        int zzb2 = zzb(inputStream);
        Map<String, String> emptyMap = zzb2 == 0 ? Collections.emptyMap() : new HashMap<>(zzb2);
        for (int i = 0; i < zzb2; i++) {
            emptyMap.put(zzd(inputStream).intern(), zzd(inputStream).intern());
        }
        return emptyMap;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:25|26|(2:35|36)|37|38) */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0023, code lost:
        return;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:37:0x0064 */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x005b A[SYNTHETIC, Splitter:B:32:0x005b] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0067 A[SYNTHETIC, Splitter:B:40:0x0067] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x006a A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void initialize() {
        /*
            r8 = this;
            monitor-enter(r8)
            java.io.File r0 = r8.zzay     // Catch:{ all -> 0x006f }
            boolean r0 = r0.exists()     // Catch:{ all -> 0x006f }
            r1 = 0
            if (r0 != 0) goto L_0x0024
            java.io.File r0 = r8.zzay     // Catch:{ all -> 0x006f }
            boolean r0 = r0.mkdirs()     // Catch:{ all -> 0x006f }
            if (r0 != 0) goto L_0x0022
            java.lang.String r0 = "Unable to create cache dir %s"
            r2 = 1
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch:{ all -> 0x006f }
            java.io.File r3 = r8.zzay     // Catch:{ all -> 0x006f }
            java.lang.String r3 = r3.getAbsolutePath()     // Catch:{ all -> 0x006f }
            r2[r1] = r3     // Catch:{ all -> 0x006f }
            com.google.android.gms.internal.zzs.zzc(r0, r2)     // Catch:{ all -> 0x006f }
        L_0x0022:
            monitor-exit(r8)
            return
        L_0x0024:
            java.io.File r0 = r8.zzay     // Catch:{ all -> 0x006f }
            java.io.File[] r0 = r0.listFiles()     // Catch:{ all -> 0x006f }
            if (r0 != 0) goto L_0x002e
            monitor-exit(r8)
            return
        L_0x002e:
            int r2 = r0.length     // Catch:{ all -> 0x006f }
        L_0x002f:
            if (r1 >= r2) goto L_0x006d
            r3 = r0[r1]     // Catch:{ all -> 0x006f }
            r4 = 0
            java.io.BufferedInputStream r5 = new java.io.BufferedInputStream     // Catch:{ IOException -> 0x0058 }
            java.io.FileInputStream r6 = new java.io.FileInputStream     // Catch:{ IOException -> 0x0058 }
            r6.<init>(r3)     // Catch:{ IOException -> 0x0058 }
            r5.<init>(r6)     // Catch:{ IOException -> 0x0058 }
            com.google.android.gms.internal.zzv$zza r4 = com.google.android.gms.internal.zzv.zza.zzf(r5)     // Catch:{ IOException -> 0x0054, all -> 0x0051 }
            long r6 = r3.length()     // Catch:{ IOException -> 0x0054, all -> 0x0051 }
            r4.zzaA = r6     // Catch:{ IOException -> 0x0054, all -> 0x0051 }
            java.lang.String r6 = r4.zzaB     // Catch:{ IOException -> 0x0054, all -> 0x0051 }
            r8.zza((java.lang.String) r6, (com.google.android.gms.internal.zzv.zza) r4)     // Catch:{ IOException -> 0x0054, all -> 0x0051 }
            r5.close()     // Catch:{ IOException -> 0x006a }
            goto L_0x006a
        L_0x0051:
            r0 = move-exception
            r4 = r5
            goto L_0x005f
        L_0x0054:
            r4 = r5
            goto L_0x0059
        L_0x0056:
            r0 = move-exception
            goto L_0x005f
        L_0x0058:
        L_0x0059:
            if (r3 == 0) goto L_0x0065
            r3.delete()     // Catch:{ all -> 0x0056 }
            goto L_0x0065
        L_0x005f:
            if (r4 == 0) goto L_0x0064
            r4.close()     // Catch:{ IOException -> 0x0064 }
        L_0x0064:
            throw r0     // Catch:{ all -> 0x006f }
        L_0x0065:
            if (r4 == 0) goto L_0x006a
            r4.close()     // Catch:{ IOException -> 0x006a }
        L_0x006a:
            int r1 = r1 + 1
            goto L_0x002f
        L_0x006d:
            monitor-exit(r8)
            return
        L_0x006f:
            r0 = move-exception
            monitor-exit(r8)
            goto L_0x0073
        L_0x0072:
            throw r0
        L_0x0073:
            goto L_0x0072
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzv.initialize():void");
    }

    public synchronized void remove(String str) {
        boolean delete = zzf(str).delete();
        removeEntry(str);
        if (!delete) {
            zzs.zzb("Could not delete cache entry for key=%s, filename=%s", str, zze(str));
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x005b A[SYNTHETIC, Splitter:B:29:0x005b] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0066 A[SYNTHETIC, Splitter:B:38:0x0066] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized com.google.android.gms.internal.zzb.zza zza(java.lang.String r9) {
        /*
            r8 = this;
            monitor-enter(r8)
            java.util.Map<java.lang.String, com.google.android.gms.internal.zzv$zza> r0 = r8.zzaw     // Catch:{ all -> 0x006d }
            java.lang.Object r0 = r0.get(r9)     // Catch:{ all -> 0x006d }
            com.google.android.gms.internal.zzv$zza r0 = (com.google.android.gms.internal.zzv.zza) r0     // Catch:{ all -> 0x006d }
            r1 = 0
            if (r0 != 0) goto L_0x000e
            monitor-exit(r8)
            return r1
        L_0x000e:
            java.io.File r2 = r8.zzf(r9)     // Catch:{ all -> 0x006d }
            com.google.android.gms.internal.zzv$zzb r3 = new com.google.android.gms.internal.zzv$zzb     // Catch:{ IOException -> 0x003e, all -> 0x003b }
            java.io.FileInputStream r4 = new java.io.FileInputStream     // Catch:{ IOException -> 0x003e, all -> 0x003b }
            r4.<init>(r2)     // Catch:{ IOException -> 0x003e, all -> 0x003b }
            r3.<init>(r4)     // Catch:{ IOException -> 0x003e, all -> 0x003b }
            com.google.android.gms.internal.zzv.zza.zzf(r3)     // Catch:{ IOException -> 0x0039 }
            long r4 = r2.length()     // Catch:{ IOException -> 0x0039 }
            int r6 = r3.zzaC     // Catch:{ IOException -> 0x0039 }
            long r6 = (long) r6     // Catch:{ IOException -> 0x0039 }
            long r4 = r4 - r6
            int r5 = (int) r4     // Catch:{ IOException -> 0x0039 }
            byte[] r4 = zza((java.io.InputStream) r3, (int) r5)     // Catch:{ IOException -> 0x0039 }
            com.google.android.gms.internal.zzb$zza r9 = r0.zzb(r4)     // Catch:{ IOException -> 0x0039 }
            r3.close()     // Catch:{ IOException -> 0x0037 }
            monitor-exit(r8)
            return r9
        L_0x0037:
            monitor-exit(r8)
            return r1
        L_0x0039:
            r0 = move-exception
            goto L_0x0040
        L_0x003b:
            r9 = move-exception
            r3 = r1
            goto L_0x0064
        L_0x003e:
            r0 = move-exception
            r3 = r1
        L_0x0040:
            java.lang.String r4 = "%s: %s"
            r5 = 2
            java.lang.Object[] r5 = new java.lang.Object[r5]     // Catch:{ all -> 0x0063 }
            r6 = 0
            java.lang.String r2 = r2.getAbsolutePath()     // Catch:{ all -> 0x0063 }
            r5[r6] = r2     // Catch:{ all -> 0x0063 }
            r2 = 1
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0063 }
            r5[r2] = r0     // Catch:{ all -> 0x0063 }
            com.google.android.gms.internal.zzs.zzb(r4, r5)     // Catch:{ all -> 0x0063 }
            r8.remove(r9)     // Catch:{ all -> 0x0063 }
            if (r3 == 0) goto L_0x0061
            r3.close()     // Catch:{ IOException -> 0x005f }
            goto L_0x0061
        L_0x005f:
            monitor-exit(r8)
            return r1
        L_0x0061:
            monitor-exit(r8)
            return r1
        L_0x0063:
            r9 = move-exception
        L_0x0064:
            if (r3 == 0) goto L_0x006c
            r3.close()     // Catch:{ IOException -> 0x006a }
            goto L_0x006c
        L_0x006a:
            monitor-exit(r8)
            return r1
        L_0x006c:
            throw r9     // Catch:{ all -> 0x006d }
        L_0x006d:
            r9 = move-exception
            monitor-exit(r8)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzv.zza(java.lang.String):com.google.android.gms.internal.zzb$zza");
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:13|14|(1:16)|17|18) */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0044, code lost:
        if (r0.delete() == false) goto L_0x0046;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0046, code lost:
        com.google.android.gms.internal.zzs.zzb("Could not clean up file %s", r0.getAbsolutePath());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0054, code lost:
        return;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0040 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void zza(java.lang.String r7, com.google.android.gms.internal.zzb.zza r8) {
        /*
            r6 = this;
            monitor-enter(r6)
            byte[] r0 = r8.data     // Catch:{ all -> 0x0055 }
            int r0 = r0.length     // Catch:{ all -> 0x0055 }
            r6.zzc((int) r0)     // Catch:{ all -> 0x0055 }
            java.io.File r0 = r6.zzf(r7)     // Catch:{ all -> 0x0055 }
            r1 = 0
            r2 = 1
            java.io.FileOutputStream r3 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x0040 }
            r3.<init>(r0)     // Catch:{ IOException -> 0x0040 }
            com.google.android.gms.internal.zzv$zza r4 = new com.google.android.gms.internal.zzv$zza     // Catch:{ IOException -> 0x0040 }
            r4.<init>(r7, r8)     // Catch:{ IOException -> 0x0040 }
            boolean r5 = r4.zza(r3)     // Catch:{ IOException -> 0x0040 }
            if (r5 == 0) goto L_0x002a
            byte[] r8 = r8.data     // Catch:{ IOException -> 0x0040 }
            r3.write(r8)     // Catch:{ IOException -> 0x0040 }
            r3.close()     // Catch:{ IOException -> 0x0040 }
            r6.zza((java.lang.String) r7, (com.google.android.gms.internal.zzv.zza) r4)     // Catch:{ IOException -> 0x0040 }
            monitor-exit(r6)
            return
        L_0x002a:
            r3.close()     // Catch:{ IOException -> 0x0040 }
            java.lang.String r7 = "Failed to write header for %s"
            java.lang.Object[] r8 = new java.lang.Object[r2]     // Catch:{ IOException -> 0x0040 }
            java.lang.String r3 = r0.getAbsolutePath()     // Catch:{ IOException -> 0x0040 }
            r8[r1] = r3     // Catch:{ IOException -> 0x0040 }
            com.google.android.gms.internal.zzs.zzb(r7, r8)     // Catch:{ IOException -> 0x0040 }
            java.io.IOException r7 = new java.io.IOException     // Catch:{ IOException -> 0x0040 }
            r7.<init>()     // Catch:{ IOException -> 0x0040 }
            throw r7     // Catch:{ IOException -> 0x0040 }
        L_0x0040:
            boolean r7 = r0.delete()     // Catch:{ all -> 0x0055 }
            if (r7 != 0) goto L_0x0053
            java.lang.String r7 = "Could not clean up file %s"
            java.lang.Object[] r8 = new java.lang.Object[r2]     // Catch:{ all -> 0x0055 }
            java.lang.String r0 = r0.getAbsolutePath()     // Catch:{ all -> 0x0055 }
            r8[r1] = r0     // Catch:{ all -> 0x0055 }
            com.google.android.gms.internal.zzs.zzb(r7, r8)     // Catch:{ all -> 0x0055 }
        L_0x0053:
            monitor-exit(r6)
            return
        L_0x0055:
            r7 = move-exception
            monitor-exit(r6)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzv.zza(java.lang.String, com.google.android.gms.internal.zzb$zza):void");
    }

    public File zzf(String str) {
        return new File(this.zzay, zze(str));
    }
}
