package com.google.android.gms.internal.ads;

import java.io.EOFException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.jvm.internal.ByteCompanionObject;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzayn implements zzavi {
    private final zzayk zza = new zzayk();
    private final zzayj zzb = new zzayj();
    private final zzbak zzc = new zzbak(32);
    private final AtomicInteger zzd = new AtomicInteger();
    private zzayl zze = new zzayl(0, 65536);
    private zzayl zzf = this.zze;
    private zzasw zzg;
    private zzasw zzh;
    private long zzi;
    private int zzj = 65536;
    private zzaym zzk;
    private final zzazp zzl;

    public zzayn(zzazp zzazp, byte[] bArr) {
        this.zzl = zzazp;
    }

    private final int zzo(int i) {
        if (this.zzj == 65536) {
            this.zzj = 0;
            zzayl zzayl = this.zzf;
            if (zzayl.zzc) {
                this.zzf = zzayl.zze;
            }
            zzayl zzayl2 = this.zzf;
            zzazj zzb2 = this.zzl.zzb();
            zzayl zzayl3 = new zzayl(this.zzf.zzb, 65536);
            zzayl2.zzd = zzb2;
            zzayl2.zze = zzayl3;
            zzayl2.zzc = true;
        }
        return Math.min(i, 65536 - this.zzj);
    }

    private final void zzp() {
        this.zza.zzg();
        zzayl zzayl = this.zze;
        if (zzayl.zzc) {
            zzayl zzayl2 = this.zzf;
            zzazj[] zzazjArr = new zzazj[((zzayl2.zzc ? 1 : 0) + (((int) (zzayl2.zza - zzayl.zza)) / 65536))];
            for (int i = 0; i < zzazjArr.length; i++) {
                zzazjArr[i] = zzayl.zzd;
                zzayl.zzd = null;
                zzayl = zzayl.zze;
            }
            this.zzl.zzd(zzazjArr);
        }
        this.zze = new zzayl(0, 65536);
        this.zzf = this.zze;
        this.zzi = 0;
        this.zzj = 65536;
        this.zzl.zzg();
    }

    private final void zzq(long j) {
        while (true) {
            zzayl zzayl = this.zze;
            if (j >= zzayl.zzb) {
                this.zzl.zzc(zzayl.zzd);
                zzayl zzayl2 = this.zze;
                zzayl2.zzd = null;
                this.zze = zzayl2.zze;
            } else {
                return;
            }
        }
    }

    private final void zzr() {
        if (!this.zzd.compareAndSet(1, 0)) {
            zzp();
        }
    }

    private final void zzs(long j, byte[] bArr, int i) {
        zzq(j);
        int i2 = 0;
        while (i2 < i) {
            int i3 = (int) (j - this.zze.zza);
            int min = Math.min(i - i2, 65536 - i3);
            zzazj zzazj = this.zze.zzd;
            System.arraycopy(zzazj.zza, i3, bArr, i2, min);
            j += (long) min;
            i2 += min;
            if (j == this.zze.zzb) {
                this.zzl.zzc(zzazj);
                zzayl zzayl = this.zze;
                zzayl.zzd = null;
                this.zze = zzayl.zze;
            }
        }
    }

    private final boolean zzt() {
        return this.zzd.compareAndSet(0, 1);
    }

    public final void zza(zzasw zzasw) {
        zzasw zzasw2 = zzasw == null ? null : zzasw;
        boolean zzk2 = this.zza.zzk(zzasw2);
        this.zzh = zzasw;
        zzaym zzaym = this.zzk;
        if (zzaym != null && zzk2) {
            zzaym.zzv(zzasw2);
        }
    }

    public final void zzb(zzbak zzbak, int i) {
        if (zzt()) {
            while (i > 0) {
                int zzo = zzo(i);
                zzbak.zzq(this.zzf.zzd.zza, this.zzj, zzo);
                this.zzj += zzo;
                this.zzi += (long) zzo;
                i -= zzo;
            }
            zzr();
            return;
        }
        zzbak.zzw(i);
    }

    public final void zzc(long j, int i, int i2, int i3, zzavh zzavh) {
        if (zzt()) {
            try {
                this.zza.zzh(j, i, this.zzi - ((long) i2), i2, zzavh);
            } finally {
                zzr();
            }
        } else {
            long j2 = j;
            this.zza.zzi(j);
        }
    }

    public final int zzd(zzauy zzauy, int i, boolean z) throws IOException, InterruptedException {
        if (!zzt()) {
            int zzb2 = zzauy.zzb(i);
            if (zzb2 != -1) {
                return zzb2;
            }
            throw new EOFException();
        }
        try {
            int zza2 = zzauy.zza(this.zzf.zzd.zza, this.zzj, zzo(i));
            if (zza2 != -1) {
                this.zzj += zza2;
                this.zzi += (long) zza2;
                return zza2;
            }
            throw new EOFException();
        } finally {
            zzr();
        }
    }

    public final int zze() {
        return this.zza.zza();
    }

    public final int zzf(zzasx zzasx, zzaur zzaur, boolean z, boolean z2, long j) {
        zzaur zzaur2 = zzaur;
        int zzb2 = this.zza.zzb(zzasx, zzaur, z, z2, this.zzg, this.zzb);
        if (zzb2 == -5) {
            this.zzg = zzasx.zza;
            return -5;
        } else if (zzb2 != -4) {
            return -3;
        } else {
            if (!zzaur.zzf()) {
                if (zzaur2.zzc < j) {
                    zzaur2.zza(Integer.MIN_VALUE);
                }
                if (zzaur.zzi()) {
                    zzayj zzayj = this.zzb;
                    long j2 = zzayj.zzb;
                    int i = 1;
                    this.zzc.zzs(1);
                    zzs(j2, this.zzc.zza, 1);
                    long j3 = j2 + 1;
                    byte b = this.zzc.zza[0];
                    byte b2 = b & ByteCompanionObject.MIN_VALUE;
                    byte b3 = b & ByteCompanionObject.MAX_VALUE;
                    zzaup zzaup = zzaur2.zza;
                    if (zzaup.zza == null) {
                        zzaup.zza = new byte[16];
                    }
                    zzs(j3, zzaup.zza, b3);
                    long j4 = j3 + ((long) b3);
                    if (b2 != 0) {
                        this.zzc.zzs(2);
                        zzs(j4, this.zzc.zza, 2);
                        j4 += 2;
                        i = this.zzc.zzj();
                    }
                    int i2 = i;
                    zzaup zzaup2 = zzaur2.zza;
                    int[] iArr = zzaup2.zzd;
                    if (iArr == null || iArr.length < i2) {
                        iArr = new int[i2];
                    }
                    int[] iArr2 = iArr;
                    int[] iArr3 = zzaup2.zze;
                    if (iArr3 == null || iArr3.length < i2) {
                        iArr3 = new int[i2];
                    }
                    int[] iArr4 = iArr3;
                    if (b2 != 0) {
                        int i3 = i2 * 6;
                        this.zzc.zzs(i3);
                        zzs(j4, this.zzc.zza, i3);
                        j4 += (long) i3;
                        this.zzc.zzv(0);
                        for (int i4 = 0; i4 < i2; i4++) {
                            iArr2[i4] = this.zzc.zzj();
                            iArr4[i4] = this.zzc.zzi();
                        }
                    } else {
                        iArr2[0] = 0;
                        iArr4[0] = zzayj.zza - ((int) (j4 - zzayj.zzb));
                    }
                    zzavh zzavh = zzayj.zzd;
                    zzaup zzaup3 = zzaur2.zza;
                    byte[] bArr = zzavh.zzb;
                    byte[] bArr2 = zzaup3.zza;
                    int i5 = zzavh.zza;
                    zzaup3.zzb(i2, iArr2, iArr4, bArr, bArr2, 1);
                    long j5 = zzayj.zzb;
                    int i6 = (int) (j4 - j5);
                    zzayj.zzb = j5 + ((long) i6);
                    zzayj.zza -= i6;
                }
                zzaur2.zzh(this.zzb.zza);
                zzayj zzayj2 = this.zzb;
                long j6 = zzayj2.zzb;
                ByteBuffer byteBuffer = zzaur2.zzb;
                int i7 = zzayj2.zza;
                zzq(j6);
                while (i7 > 0) {
                    int i8 = (int) (j6 - this.zze.zza);
                    int min = Math.min(i7, 65536 - i8);
                    zzazj zzazj = this.zze.zzd;
                    byteBuffer.put(zzazj.zza, i8, min);
                    j6 += (long) min;
                    i7 -= min;
                    if (j6 == this.zze.zzb) {
                        this.zzl.zzc(zzazj);
                        zzayl zzayl = this.zze;
                        zzayl.zzd = null;
                        this.zze = zzayl.zze;
                    }
                }
                zzq(this.zzb.zzc);
            }
            return -4;
        }
    }

    public final long zzg() {
        return this.zza.zzc();
    }

    public final zzasw zzh() {
        return this.zza.zzf();
    }

    public final void zzi() {
        if (this.zzd.getAndSet(2) == 0) {
            zzp();
        }
    }

    public final void zzj(boolean z) {
        int andSet = this.zzd.getAndSet(true != z ? 2 : 0);
        zzp();
        this.zza.zzj();
        if (andSet == 2) {
            this.zzg = null;
        }
    }

    public final void zzk(zzaym zzaym) {
        this.zzk = zzaym;
    }

    public final void zzl() {
        long zzd2 = this.zza.zzd();
        if (zzd2 != -1) {
            zzq(zzd2);
        }
    }

    public final boolean zzm() {
        return this.zza.zzl();
    }

    public final boolean zzn(long j, boolean z) {
        long zze2 = this.zza.zze(j, z);
        if (zze2 == -1) {
            return false;
        }
        zzq(zze2);
        return true;
    }
}
