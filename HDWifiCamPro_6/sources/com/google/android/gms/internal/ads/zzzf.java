package com.google.android.gms.internal.ads;

import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.PsExtractor;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzzf {
    public static final /* synthetic */ int zza = 0;
    private static final int[] zzb = {1, 2, 2, 2, 2, 3, 3, 4, 4, 5, 6, 6, 6, 7, 8, 8};
    private static final int[] zzc = {-1, 8000, 16000, 32000, -1, -1, 11025, 22050, 44100, -1, -1, 12000, 24000, 48000, -1, -1};
    private static final int[] zzd = {64, 112, 128, PsExtractor.AUDIO_STREAM, 224, 256, 384, 448, 512, 640, 768, 896, 1024, 1152, 1280, 1536, 1920, 2048, 2304, 2560, 2688, 2816, 2823, 2944, 3072, 3840, 4096, 6144, 7680};

    public static zzaf zza(byte[] bArr, String str, String str2, zzx zzx) {
        zzee zzee;
        int i = 0;
        int i2 = -1;
        if (bArr[0] == Byte.MAX_VALUE) {
            zzee = new zzee(bArr, bArr.length);
        } else {
            byte[] copyOf = Arrays.copyOf(bArr, bArr.length);
            byte b = copyOf[0];
            if (b == -2 || b == -1) {
                for (int i3 = 0; i3 < copyOf.length - 1; i3 += 2) {
                    byte b2 = copyOf[i3];
                    int i4 = i3 + 1;
                    copyOf[i3] = copyOf[i4];
                    copyOf[i4] = b2;
                }
            }
            int length = copyOf.length;
            zzee = new zzee(copyOf, length);
            if (copyOf[0] == 31) {
                zzee zzee2 = new zzee(copyOf, length);
                while (zzee2.zza() >= 16) {
                    zzee2.zzj(2);
                    zzee.zze(zzee2.zzc(14), 14);
                }
            }
            zzee.zzg(copyOf, copyOf.length);
        }
        zzee.zzj(60);
        int i5 = zzb[zzee.zzc(6)];
        int i6 = zzc[zzee.zzc(4)];
        int zzc2 = zzee.zzc(5);
        if (zzc2 < 29) {
            i2 = (zzd[zzc2] * 1000) / 2;
        }
        zzee.zzj(10);
        if (zzee.zzc(2) > 0) {
            i = 1;
        }
        zzad zzad = new zzad();
        zzad.zzH(str);
        zzad.zzS(MimeTypes.AUDIO_DTS);
        zzad.zzv(i2);
        zzad.zzw(i5 + i);
        zzad.zzT(i6);
        zzad.zzB((zzx) null);
        zzad.zzK(str2);
        return zzad.zzY();
    }
}
