package com.google.android.gms.internal.ads;

import java.security.MessageDigest;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzbda extends zzbcr {
    private MessageDigest zzb;
    private final int zzc;
    private final int zzd;

    public zzbda(int i) {
        int i2 = i >> 3;
        this.zzc = (i & 7) > 0 ? i2 + 1 : i2;
        this.zzd = i;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0067, code lost:
        return r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final byte[] zzb(java.lang.String r9) {
        /*
            r8 = this;
            java.lang.Object r0 = r8.zza
            monitor-enter(r0)
            java.security.MessageDigest r1 = r8.zza()     // Catch:{ all -> 0x0068 }
            r8.zzb = r1     // Catch:{ all -> 0x0068 }
            java.security.MessageDigest r1 = r8.zzb     // Catch:{ all -> 0x0068 }
            r2 = 0
            if (r1 != 0) goto L_0x0012
            byte[] r9 = new byte[r2]     // Catch:{ all -> 0x0068 }
            monitor-exit(r0)     // Catch:{ all -> 0x0068 }
            return r9
        L_0x0012:
            r1.reset()     // Catch:{ all -> 0x0068 }
            java.security.MessageDigest r1 = r8.zzb     // Catch:{ all -> 0x0068 }
            java.lang.String r3 = "UTF-8"
            java.nio.charset.Charset r3 = java.nio.charset.Charset.forName(r3)     // Catch:{ all -> 0x0068 }
            byte[] r9 = r9.getBytes(r3)     // Catch:{ all -> 0x0068 }
            r1.update(r9)     // Catch:{ all -> 0x0068 }
            java.security.MessageDigest r9 = r8.zzb     // Catch:{ all -> 0x0068 }
            byte[] r9 = r9.digest()     // Catch:{ all -> 0x0068 }
            int r1 = r9.length     // Catch:{ all -> 0x0068 }
            int r3 = r8.zzc     // Catch:{ all -> 0x0068 }
            if (r1 <= r3) goto L_0x0030
            r1 = r3
        L_0x0030:
            byte[] r1 = new byte[r1]     // Catch:{ all -> 0x0068 }
            int r3 = r1.length     // Catch:{ all -> 0x0068 }
            java.lang.System.arraycopy(r9, r2, r1, r2, r3)     // Catch:{ all -> 0x0068 }
            int r9 = r8.zzd     // Catch:{ all -> 0x0068 }
            r9 = r9 & 7
            if (r9 <= 0) goto L_0x0066
            r3 = 0
        L_0x003e:
            int r9 = r1.length     // Catch:{ all -> 0x0068 }
            r5 = 8
            if (r2 >= r9) goto L_0x004f
            if (r2 <= 0) goto L_0x0046
            long r3 = r3 << r5
        L_0x0046:
            byte r9 = r1[r2]     // Catch:{ all -> 0x0068 }
            r9 = r9 & 255(0xff, float:3.57E-43)
            long r5 = (long) r9     // Catch:{ all -> 0x0068 }
            long r3 = r3 + r5
            int r2 = r2 + 1
            goto L_0x003e
        L_0x004f:
            int r9 = r8.zzd     // Catch:{ all -> 0x0068 }
            r9 = r9 & 7
            int r9 = 8 - r9
            long r2 = r3 >>> r9
            int r9 = r8.zzc     // Catch:{ all -> 0x0068 }
        L_0x0059:
            int r9 = r9 + -1
            if (r9 < 0) goto L_0x0066
            r6 = 255(0xff, double:1.26E-321)
            long r6 = r6 & r2
            int r4 = (int) r6     // Catch:{ all -> 0x0068 }
            byte r4 = (byte) r4     // Catch:{ all -> 0x0068 }
            r1[r9] = r4     // Catch:{ all -> 0x0068 }
            long r2 = r2 >>> r5
            goto L_0x0059
        L_0x0066:
            monitor-exit(r0)     // Catch:{ all -> 0x0068 }
            return r1
        L_0x0068:
            r9 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0068 }
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbda.zzb(java.lang.String):byte[]");
    }
}
