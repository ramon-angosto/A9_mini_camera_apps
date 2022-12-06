package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ShortBuffer;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzaul implements zzatl {
    private int zzb = -1;
    private int zzc = -1;
    private zzauk zzd;
    private float zze = 1.0f;
    private float zzf = 1.0f;
    private ByteBuffer zzg = zza;
    private ShortBuffer zzh = this.zzg.asShortBuffer();
    private ByteBuffer zzi = zza;
    private long zzj;
    private long zzk;
    private boolean zzl;

    public final int zza() {
        return this.zzb;
    }

    public final int zzb() {
        return 2;
    }

    public final ByteBuffer zzc() {
        ByteBuffer byteBuffer = this.zzi;
        this.zzi = zza;
        return byteBuffer;
    }

    public final void zzd() {
        this.zzd = new zzauk(this.zzc, this.zzb);
        this.zzd.zzf(this.zze);
        this.zzd.zze(this.zzf);
        this.zzi = zza;
        this.zzj = 0;
        this.zzk = 0;
        this.zzl = false;
    }

    public final void zze() {
        this.zzd.zzc();
        this.zzl = true;
    }

    public final void zzf(ByteBuffer byteBuffer) {
        if (byteBuffer.hasRemaining()) {
            ShortBuffer asShortBuffer = byteBuffer.asShortBuffer();
            int remaining = byteBuffer.remaining();
            this.zzj += (long) remaining;
            this.zzd.zzd(asShortBuffer);
            byteBuffer.position(byteBuffer.position() + remaining);
        }
        int zza = this.zzd.zza() * this.zzb;
        int i = zza + zza;
        if (i > 0) {
            if (this.zzg.capacity() < i) {
                this.zzg = ByteBuffer.allocateDirect(i).order(ByteOrder.nativeOrder());
                this.zzh = this.zzg.asShortBuffer();
            } else {
                this.zzg.clear();
                this.zzh.clear();
            }
            this.zzd.zzb(this.zzh);
            this.zzk += (long) i;
            this.zzg.limit(i);
            this.zzi = this.zzg;
        }
    }

    public final void zzg() {
        this.zzd = null;
        this.zzg = zza;
        this.zzh = this.zzg.asShortBuffer();
        this.zzi = zza;
        this.zzb = -1;
        this.zzc = -1;
        this.zzj = 0;
        this.zzk = 0;
        this.zzl = false;
    }

    public final boolean zzh(int i, int i2, int i3) throws zzatk {
        if (i3 != 2) {
            throw new zzatk(i, i2, i3);
        } else if (this.zzc == i && this.zzb == i2) {
            return false;
        } else {
            this.zzc = i;
            this.zzb = i2;
            return true;
        }
    }

    public final boolean zzi() {
        return Math.abs(this.zze + -1.0f) >= 0.01f || Math.abs(this.zzf + -1.0f) >= 0.01f;
    }

    public final boolean zzj() {
        if (!this.zzl) {
            return false;
        }
        zzauk zzauk = this.zzd;
        if (zzauk != null) {
            return zzauk.zza() == 0;
        }
        return true;
    }

    public final float zzk(float f) {
        this.zzf = zzbar.zza(1.0f, 0.1f, 8.0f);
        return 1.0f;
    }

    public final float zzl(float f) {
        float zza = zzbar.zza(f, 0.1f, 8.0f);
        this.zze = zza;
        return zza;
    }

    public final long zzm() {
        return this.zzj;
    }

    public final long zzn() {
        return this.zzk;
    }
}
