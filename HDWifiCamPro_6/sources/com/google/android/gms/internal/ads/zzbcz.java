package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zze;
import java.util.PriorityQueue;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzbcz {
    static long zza(long j, int i) {
        if (i == 1) {
            return j;
        }
        return ((i & 1) == 0 ? zza((j * j) % 1073807359, i >> 1) : j * (zza((j * j) % 1073807359, i >> 1) % 1073807359)) % 1073807359;
    }

    static String zzb(String[] strArr, int i, int i2) {
        int i3 = i2 + i;
        if (strArr.length < i3) {
            zze.zzg("Unable to construct shingle");
            return "";
        }
        StringBuilder sb = new StringBuilder();
        while (true) {
            int i4 = i3 - 1;
            if (i < i4) {
                sb.append(strArr[i]);
                sb.append(' ');
                i++;
            } else {
                sb.append(strArr[i4]);
                return sb.toString();
            }
        }
    }

    public static void zzc(String[] strArr, int i, int i2, PriorityQueue priorityQueue) {
        String[] strArr2 = strArr;
        int length = strArr2.length;
        if (length < 6) {
            zzd(i, zze(strArr2, 0, length), zzb(strArr2, 0, length), length, priorityQueue);
            return;
        }
        long zze = zze(strArr2, 0, 6);
        zzd(i, zze, zzb(strArr2, 0, 6), 6, priorityQueue);
        long zza = zza(16785407, 5);
        int i3 = 1;
        while (true) {
            int length2 = strArr2.length;
            if (i3 < length2 - 5) {
                zze = ((((((zze + 1073807359) - ((((((long) zzbcv.zza(strArr2[i3 - 1])) + 2147483647L) % 1073807359) * zza) % 1073807359)) % 1073807359) * 16785407) % 1073807359) + ((((long) zzbcv.zza(strArr2[i3 + 5])) + 2147483647L) % 1073807359)) % 1073807359;
                zzd(i, zze, zzb(strArr2, i3, 6), length2, priorityQueue);
                i3++;
            } else {
                return;
            }
        }
    }

    static void zzd(int i, long j, String str, int i2, PriorityQueue priorityQueue) {
        zzbcy zzbcy = new zzbcy(j, str, i2);
        if ((priorityQueue.size() != i || (((zzbcy) priorityQueue.peek()).zzc <= zzbcy.zzc && ((zzbcy) priorityQueue.peek()).zza <= zzbcy.zza)) && !priorityQueue.contains(zzbcy)) {
            priorityQueue.add(zzbcy);
            if (priorityQueue.size() > i) {
                priorityQueue.poll();
            }
        }
    }

    private static long zze(String[] strArr, int i, int i2) {
        long zza = (((long) zzbcv.zza(strArr[0])) + 2147483647L) % 1073807359;
        for (int i3 = 1; i3 < i2; i3++) {
            zza = (((zza * 16785407) % 1073807359) + ((((long) zzbcv.zza(strArr[i3])) + 2147483647L) % 1073807359)) % 1073807359;
        }
        return zza;
    }
}
