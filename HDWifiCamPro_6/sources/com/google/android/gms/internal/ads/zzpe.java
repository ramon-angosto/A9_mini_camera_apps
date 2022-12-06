package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ShortBuffer;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzpe implements zzng {
    private int zzb;
    private float zzc = 1.0f;
    private float zzd = 1.0f;
    private zzne zze = zzne.zza;
    private zzne zzf;
    private zzne zzg;
    private zzne zzh;
    private boolean zzi;
    private zzpd zzj;
    private ByteBuffer zzk;
    private ShortBuffer zzl;
    private ByteBuffer zzm;
    private long zzn;
    private long zzo;
    private boolean zzp;

    public zzpe() {
        zzne zzne = zzne.zza;
        this.zzf = zzne;
        this.zzg = zzne;
        this.zzh = zzne;
        this.zzk = zza;
        this.zzl = this.zzk.asShortBuffer();
        this.zzm = zza;
        this.zzb = -1;
    }

    public final zzne zza(zzne zzne) throws zznf {
        if (zzne.zzd == 2) {
            int i = this.zzb;
            if (i == -1) {
                i = zzne.zzb;
            }
            this.zze = zzne;
            this.zzf = new zzne(i, zzne.zzc, 2);
            this.zzi = true;
            return this.zzf;
        }
        throw new zznf(zzne);
    }

    public final ByteBuffer zzb() {
        int zza;
        zzpd zzpd = this.zzj;
        if (zzpd != null && (zza = zzpd.zza()) > 0) {
            if (this.zzk.capacity() < zza) {
                this.zzk = ByteBuffer.allocateDirect(zza).order(ByteOrder.nativeOrder());
                this.zzl = this.zzk.asShortBuffer();
            } else {
                this.zzk.clear();
                this.zzl.clear();
            }
            zzpd.zzd(this.zzl);
            this.zzo += (long) zza;
            this.zzk.limit(zza);
            this.zzm = this.zzk;
        }
        ByteBuffer byteBuffer = this.zzm;
        this.zzm = zza;
        return byteBuffer;
    }

    public final void zzc() {
        if (zzg()) {
            this.zzg = this.zze;
            this.zzh = this.zzf;
            if (this.zzi) {
                zzne zzne = this.zzg;
                this.zzj = new zzpd(zzne.zzb, zzne.zzc, this.zzc, this.zzd, this.zzh.zzb);
            } else {
                zzpd zzpd = this.zzj;
                if (zzpd != null) {
                    zzpd.zzc();
                }
            }
        }
        this.zzm = zza;
        this.zzn = 0;
        this.zzo = 0;
        this.zzp = false;
    }

    public final void zzd() {
        zzpd zzpd = this.zzj;
        if (zzpd != null) {
            zzpd.zze();
        }
        this.zzp = true;
    }

    public final void zze(ByteBuffer byteBuffer) {
        if (byteBuffer.hasRemaining()) {
            zzpd zzpd = this.zzj;
            if (zzpd != null) {
                ShortBuffer asShortBuffer = byteBuffer.asShortBuffer();
                int remaining = byteBuffer.remaining();
                this.zzn += (long) remaining;
                zzpd.zzf(asShortBuffer);
                byteBuffer.position(byteBuffer.position() + remaining);
                return;
            }
            throw null;
        }
    }

    public final void zzf() {
        this.zzc = 1.0f;
        this.zzd = 1.0f;
        this.zze = zzne.zza;
        zzne zzne = zzne.zza;
        this.zzf = zzne;
        this.zzg = zzne;
        this.zzh = zzne;
        this.zzk = zza;
        this.zzl = this.zzk.asShortBuffer();
        this.zzm = zza;
        this.zzb = -1;
        this.zzi = false;
        this.zzj = null;
        this.zzn = 0;
        this.zzo = 0;
        this.zzp = false;
    }

    public final boolean zzg() {
        if (this.zzf.zzb == -1) {
            return false;
        }
        if (Math.abs(this.zzc - 4.0f) >= 1.0E-4f || Math.abs(this.zzd - 4.0f) >= 1.0E-4f) {
            return true;
        }
        return this.zzf.zzb != this.zze.zzb;
    }

    public final boolean zzh() {
        if (!this.zzp) {
            return false;
        }
        zzpd zzpd = this.zzj;
        if (zzpd != null) {
            return zzpd.zza() == 0;
        }
        return true;
    }

    public final long zzi(long j) {
        long j2 = this.zzo;
        if (j2 < 1024) {
            return (long) (((double) this.zzc) * ((double) j));
        }
        long j3 = this.zzn;
        zzpd zzpd = this.zzj;
        if (zzpd != null) {
            long zzb2 = j3 - ((long) zzpd.zzb());
            int i = this.zzh.zzb;
            int i2 = this.zzg.zzb;
            if (i == i2) {
                return zzen.zzw(j, zzb2, j2);
            }
            return zzen.zzw(j, zzb2 * ((long) i), j2 * ((long) i2));
        }
        throw null;
    }

    public final void zzj(float f) {
        if (this.zzd != f) {
            this.zzd = f;
            this.zzi = true;
        }
    }

    public final void zzk(float f) {
        if (this.zzc != f) {
            this.zzc = f;
            this.zzi = true;
        }
    }
}
