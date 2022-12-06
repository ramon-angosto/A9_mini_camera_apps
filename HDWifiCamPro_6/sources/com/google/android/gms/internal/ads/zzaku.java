package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzaku {
    protected static final Comparator zza = new zzakt();
    private final List zzb = new ArrayList();
    private final List zzc = new ArrayList(64);
    private int zzd = 0;

    public zzaku(int i) {
    }

    private final synchronized void zzc() {
        while (this.zzd > 4096) {
            byte[] bArr = (byte[]) this.zzb.remove(0);
            this.zzc.remove(bArr);
            this.zzd -= bArr.length;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x002e, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void zza(byte[] r4) {
        /*
            r3 = this;
            monitor-enter(r3)
            if (r4 == 0) goto L_0x002d
            int r0 = r4.length     // Catch:{ all -> 0x002a }
            r1 = 4096(0x1000, float:5.74E-42)
            if (r0 <= r1) goto L_0x0009
            goto L_0x002d
        L_0x0009:
            java.util.List r1 = r3.zzb     // Catch:{ all -> 0x002a }
            r1.add(r4)     // Catch:{ all -> 0x002a }
            java.util.List r1 = r3.zzc     // Catch:{ all -> 0x002a }
            java.util.Comparator r2 = zza     // Catch:{ all -> 0x002a }
            int r1 = java.util.Collections.binarySearch(r1, r4, r2)     // Catch:{ all -> 0x002a }
            if (r1 >= 0) goto L_0x001b
            int r1 = -r1
            int r1 = r1 + -1
        L_0x001b:
            java.util.List r2 = r3.zzc     // Catch:{ all -> 0x002a }
            r2.add(r1, r4)     // Catch:{ all -> 0x002a }
            int r4 = r3.zzd     // Catch:{ all -> 0x002a }
            int r4 = r4 + r0
            r3.zzd = r4     // Catch:{ all -> 0x002a }
            r3.zzc()     // Catch:{ all -> 0x002a }
            monitor-exit(r3)
            return
        L_0x002a:
            r4 = move-exception
            monitor-exit(r3)
            throw r4
        L_0x002d:
            monitor-exit(r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaku.zza(byte[]):void");
    }

    public final synchronized byte[] zzb(int i) {
        for (int i2 = 0; i2 < this.zzc.size(); i2++) {
            byte[] bArr = (byte[]) this.zzc.get(i2);
            int length = bArr.length;
            if (length >= i) {
                this.zzd -= length;
                this.zzc.remove(i2);
                this.zzb.remove(bArr);
                return bArr;
            }
        }
        return new byte[i];
    }
}
