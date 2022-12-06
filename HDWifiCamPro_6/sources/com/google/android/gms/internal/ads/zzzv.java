package com.google.android.gms.internal.ads;

import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import java.util.Collections;
import java.util.List;
import kotlin.jvm.internal.ByteCompanionObject;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzzv {
    public final int zza;
    public final int zzb;
    public final int zzc;
    public final int zzd;
    public final int zze;
    public final int zzf;
    public final int zzg;
    public final int zzh;
    public final int zzi;
    public final long zzj;
    public final zzzu zzk;
    private final zzbq zzl;

    private zzzv(int i, int i2, int i3, int i4, int i5, int i6, int i7, long j, zzzu zzzu, zzbq zzbq) {
        this.zza = i;
        this.zzb = i2;
        this.zzc = i3;
        this.zzd = i4;
        this.zze = i5;
        this.zzf = zzi(i5);
        this.zzg = i6;
        this.zzh = i7;
        this.zzi = zzh(i7);
        this.zzj = j;
        this.zzk = zzzu;
        this.zzl = zzbq;
    }

    public zzzv(byte[] bArr, int i) {
        zzee zzee = new zzee(bArr, bArr.length);
        zzee.zzh(i * 8);
        this.zza = zzee.zzc(16);
        this.zzb = zzee.zzc(16);
        this.zzc = zzee.zzc(24);
        this.zzd = zzee.zzc(24);
        int zzc2 = zzee.zzc(20);
        this.zze = zzc2;
        this.zzf = zzi(zzc2);
        this.zzg = zzee.zzc(3) + 1;
        int zzc3 = zzee.zzc(5) + 1;
        this.zzh = zzc3;
        this.zzi = zzh(zzc3);
        this.zzj = zzen.zzy(zzee.zzc(4), zzee.zzc(32));
        this.zzk = null;
        this.zzl = null;
    }

    private static int zzh(int i) {
        if (i == 8) {
            return 1;
        }
        if (i == 12) {
            return 2;
        }
        if (i == 16) {
            return 4;
        }
        if (i != 20) {
            return i != 24 ? -1 : 6;
        }
        return 5;
    }

    private static int zzi(int i) {
        switch (i) {
            case 8000:
                return 4;
            case 16000:
                return 5;
            case 22050:
                return 6;
            case 24000:
                return 7;
            case 32000:
                return 8;
            case 44100:
                return 9;
            case 48000:
                return 10;
            case 88200:
                return 1;
            case 96000:
                return 11;
            case 176400:
                return 2;
            case 192000:
                return 3;
            default:
                return -1;
        }
    }

    public final long zza() {
        long j = this.zzj;
        return j == 0 ? C.TIME_UNSET : (j * 1000000) / ((long) this.zze);
    }

    public final long zzb(long j) {
        return zzen.zzr((j * ((long) this.zze)) / 1000000, 0, this.zzj - 1);
    }

    public final zzaf zzc(byte[] bArr, zzbq zzbq) {
        bArr[4] = ByteCompanionObject.MIN_VALUE;
        int i = this.zzd;
        if (i <= 0) {
            i = -1;
        }
        zzbq zzd2 = zzd(zzbq);
        zzad zzad = new zzad();
        zzad.zzS(MimeTypes.AUDIO_FLAC);
        zzad.zzL(i);
        zzad.zzw(this.zzg);
        zzad.zzT(this.zze);
        zzad.zzI(Collections.singletonList(bArr));
        zzad.zzM(zzd2);
        return zzad.zzY();
    }

    public final zzbq zzd(zzbq zzbq) {
        zzbq zzbq2 = this.zzl;
        return zzbq2 == null ? zzbq : zzbq2.zzd(zzbq);
    }

    public final zzzv zze(List list) {
        return new zzzv(this.zza, this.zzb, this.zzc, this.zzd, this.zze, this.zzg, this.zzh, this.zzj, this.zzk, zzd(new zzbq(list)));
    }

    public final zzzv zzf(zzzu zzzu) {
        return new zzzv(this.zza, this.zzb, this.zzc, this.zzd, this.zze, this.zzg, this.zzh, this.zzj, zzzu, this.zzl);
    }

    public final zzzv zzg(List list) {
        return new zzzv(this.zza, this.zzb, this.zzc, this.zzd, this.zze, this.zzg, this.zzh, this.zzj, this.zzk, zzd(zzaav.zzb(list)));
    }
}
