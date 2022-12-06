package com.google.android.gms.internal.ads;

import android.os.HandlerThread;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzpw implements zzqk {
    private final zzftn zzb;
    private final zzftn zzc;

    public zzpw(int i, boolean z) {
        zzpu zzpu = new zzpu(i);
        zzpv zzpv = new zzpv(i);
        this.zzb = zzpu;
        this.zzc = zzpv;
    }

    static /* synthetic */ HandlerThread zza(int i) {
        return new HandlerThread(zzpy.zzs(i, "ExoPlayer:MediaCodecAsyncAdapter:"));
    }

    static /* synthetic */ HandlerThread zzb(int i) {
        return new HandlerThread(zzpy.zzs(i, "ExoPlayer:MediaCodecQueueingThread:"));
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0051  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0057  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.ads.zzpy zzc(com.google.android.gms.internal.ads.zzqj r11) throws java.io.IOException {
        /*
            r10 = this;
            com.google.android.gms.internal.ads.zzqn r0 = r11.zza
            java.lang.String r0 = r0.zza
            r1 = 0
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x004d }
            r2.<init>()     // Catch:{ Exception -> 0x004d }
            java.lang.String r3 = "createCodec:"
            r2.append(r3)     // Catch:{ Exception -> 0x004d }
            r2.append(r0)     // Catch:{ Exception -> 0x004d }
            java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x004d }
            int r3 = com.google.android.gms.internal.ads.zzen.zza     // Catch:{ Exception -> 0x004d }
            android.os.Trace.beginSection(r2)     // Catch:{ Exception -> 0x004d }
            android.media.MediaCodec r0 = android.media.MediaCodec.createByCodecName(r0)     // Catch:{ Exception -> 0x004d }
            com.google.android.gms.internal.ads.zzpy r2 = new com.google.android.gms.internal.ads.zzpy     // Catch:{ Exception -> 0x004b }
            com.google.android.gms.internal.ads.zzftn r3 = r10.zzb     // Catch:{ Exception -> 0x004b }
            com.google.android.gms.internal.ads.zzpu r3 = (com.google.android.gms.internal.ads.zzpu) r3     // Catch:{ Exception -> 0x004b }
            int r3 = r3.zza     // Catch:{ Exception -> 0x004b }
            android.os.HandlerThread r6 = zza(r3)     // Catch:{ Exception -> 0x004b }
            com.google.android.gms.internal.ads.zzftn r3 = r10.zzc     // Catch:{ Exception -> 0x004b }
            com.google.android.gms.internal.ads.zzpv r3 = (com.google.android.gms.internal.ads.zzpv) r3     // Catch:{ Exception -> 0x004b }
            int r3 = r3.zza     // Catch:{ Exception -> 0x004b }
            android.os.HandlerThread r7 = zzb(r3)     // Catch:{ Exception -> 0x004b }
            r8 = 0
            r9 = 0
            r4 = r2
            r5 = r0
            r4.<init>(r5, r6, r7, r8, r9)     // Catch:{ Exception -> 0x004b }
            android.os.Trace.endSection()     // Catch:{ Exception -> 0x0048 }
            android.media.MediaFormat r3 = r11.zzb     // Catch:{ Exception -> 0x0048 }
            android.view.Surface r11 = r11.zzd     // Catch:{ Exception -> 0x0048 }
            r4 = 0
            com.google.android.gms.internal.ads.zzpy.zzh(r2, r3, r11, r1, r4)     // Catch:{ Exception -> 0x0048 }
            return r2
        L_0x0048:
            r11 = move-exception
            r1 = r2
            goto L_0x004f
        L_0x004b:
            r11 = move-exception
            goto L_0x004f
        L_0x004d:
            r11 = move-exception
            r0 = r1
        L_0x004f:
            if (r1 != 0) goto L_0x0057
            if (r0 == 0) goto L_0x005a
            r0.release()
            goto L_0x005a
        L_0x0057:
            r1.zzl()
        L_0x005a:
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzpw.zzc(com.google.android.gms.internal.ads.zzqj):com.google.android.gms.internal.ads.zzpy");
    }
}
