package com.google.android.gms.internal.ads;

import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.PsExtractor;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import java.nio.ByteBuffer;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzati {
    public static final /* synthetic */ int zza = 0;
    private static final int[] zzb = {1, 2, 3, 6};
    private static final int[] zzc = {48000, 44100, 32000};
    private static final int[] zzd = {2, 1, 2, 3, 3, 4, 4, 5};

    public static int zza(ByteBuffer byteBuffer) {
        int i = 6;
        if (((byteBuffer.get(byteBuffer.position() + 4) & 192) >> 6) != 3) {
            i = zzb[(byteBuffer.get(byteBuffer.position() + 4) & 48) >> 4];
        }
        return i * 256;
    }

    public static zzasw zzb(zzbak zzbak, String str, String str2, zzauv zzauv) {
        int i = zzc[(zzbak.zzg() & PsExtractor.AUDIO_STREAM) >> 6];
        int zzg = zzbak.zzg();
        int i2 = zzd[(zzg & 56) >> 3];
        if ((zzg & 4) != 0) {
            i2++;
        }
        return zzasw.zzg(str, MimeTypes.AUDIO_AC3, (String) null, -1, -1, i2, i, (List) null, zzauv, 0, str2);
    }

    public static zzasw zzc(zzbak zzbak, String str, String str2, zzauv zzauv) {
        zzbak zzbak2 = zzbak;
        zzbak.zzw(2);
        int i = zzc[(zzbak.zzg() & PsExtractor.AUDIO_STREAM) >> 6];
        int zzg = zzbak.zzg();
        int i2 = zzd[(zzg & 14) >> 1];
        if ((zzg & 1) != 0) {
            i2++;
        }
        return zzasw.zzg(str, MimeTypes.AUDIO_E_AC3, (String) null, -1, -1, i2, i, (List) null, zzauv, 0, str2);
    }
}
