package com.google.android.gms.internal.ads;

import android.media.AudioAttributes;
import android.media.AudioFormat;
import android.media.AudioTrack;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zznc {
    private static final AudioAttributes zza = new AudioAttributes.Builder().setUsage(1).setContentType(3).setFlags(0).build();

    public static int zza(int i, int i2) {
        for (int i3 = 8; i3 > 0; i3--) {
            if (AudioTrack.isDirectPlaybackSupported(new AudioFormat.Builder().setEncoding(i).setSampleRate(i2).setChannelMask(zzen.zzj(i3)).build(), zza)) {
                return i3;
            }
        }
        return 0;
    }

    public static int[] zzb() {
        zzfvk zzi = zzfvn.zzi();
        zzfxm zze = zznd.zzc.keySet().iterator();
        while (zze.hasNext()) {
            int intValue = ((Integer) zze.next()).intValue();
            if (AudioTrack.isDirectPlaybackSupported(new AudioFormat.Builder().setChannelMask(12).setEncoding(intValue).setSampleRate(48000).build(), zza)) {
                zzi.zze(Integer.valueOf(intValue));
            }
        }
        zzi.zze(2);
        Object[] array = zzi.zzg().toArray();
        int length = array.length;
        int[] iArr = new int[length];
        int i = 0;
        while (i < length) {
            Object obj = array[i];
            if (obj != null) {
                iArr[i] = ((Number) obj).intValue();
                i++;
            } else {
                throw null;
            }
        }
        return iArr;
    }
}
