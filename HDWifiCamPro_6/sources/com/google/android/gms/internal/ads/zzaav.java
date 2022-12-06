package com.google.android.gms.internal.ads;

import android.util.Base64;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzaav {
    public static int zza(int i) {
        int i2 = 0;
        while (i > 0) {
            i2++;
            i >>>= 1;
        }
        return i2;
    }

    public static zzbq zzb(List list) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            String str = (String) list.get(i);
            String[] zzah = zzen.zzah(str, "=");
            if (zzah.length != 2) {
                zzdw.zze("VorbisUtil", "Failed to parse Vorbis comment: ".concat(String.valueOf(str)));
            } else if (zzah[0].equals("METADATA_BLOCK_PICTURE")) {
                try {
                    arrayList.add(zzaci.zzb(new zzef(Base64.decode(zzah[1], 0))));
                } catch (RuntimeException e) {
                    zzdw.zzf("VorbisUtil", "Failed to parse vorbis picture", e);
                }
            } else {
                arrayList.add(new zzady(zzah[0], zzah[1]));
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new zzbq((List) arrayList);
    }

    public static zzaas zzc(zzef zzef, boolean z, boolean z2) throws zzbu {
        if (z) {
            zzd(3, zzef, false);
        }
        String zzx = zzef.zzx((int) zzef.zzq(), zzfsk.zzc);
        long zzq = zzef.zzq();
        String[] strArr = new String[((int) zzq)];
        int length = zzx.length() + 15;
        for (int i = 0; ((long) i) < zzq; i++) {
            String zzx2 = zzef.zzx((int) zzef.zzq(), zzfsk.zzc);
            strArr[i] = zzx2;
            length = length + 4 + zzx2.length();
        }
        if (!z2 || (zzef.zzk() & 1) != 0) {
            return new zzaas(zzx, strArr, length + 1);
        }
        throw zzbu.zza("framing bit expected to be set", (Throwable) null);
    }

    public static boolean zzd(int i, zzef zzef, boolean z) throws zzbu {
        if (zzef.zza() < 7) {
            if (z) {
                return false;
            }
            int zza = zzef.zza();
            throw zzbu.zza("too short header: " + zza, (Throwable) null);
        } else if (zzef.zzk() != i) {
            if (z) {
                return false;
            }
            throw zzbu.zza("expected header type ".concat(String.valueOf(Integer.toHexString(i))), (Throwable) null);
        } else if (zzef.zzk() == 118 && zzef.zzk() == 111 && zzef.zzk() == 114 && zzef.zzk() == 98 && zzef.zzk() == 105 && zzef.zzk() == 115) {
            return true;
        } else {
            if (z) {
                return false;
            }
            throw zzbu.zza("expected characters 'vorbis'", (Throwable) null);
        }
    }
}
