package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public abstract class zzod implements zzng {
    protected zzne zzb;
    protected zzne zzc;
    private zzne zzd = zzne.zza;
    private zzne zze;
    private ByteBuffer zzf;
    private ByteBuffer zzg;
    private boolean zzh;

    public zzod() {
        ByteBuffer byteBuffer = zza;
        this.zzf = byteBuffer;
        this.zzg = byteBuffer;
        zzne zzne = zzne.zza;
        this.zze = zzne;
        this.zzb = zzne;
        this.zzc = zzne;
    }

    public final zzne zza(zzne zzne) throws zznf {
        this.zzd = zzne;
        this.zze = zzi(zzne);
        return zzg() ? this.zze : zzne.zza;
    }

    public ByteBuffer zzb() {
        ByteBuffer byteBuffer = this.zzg;
        this.zzg = zza;
        return byteBuffer;
    }

    public final void zzc() {
        this.zzg = zza;
        this.zzh = false;
        this.zzb = this.zzd;
        this.zzc = this.zze;
        zzk();
    }

    public final void zzd() {
        this.zzh = true;
        zzl();
    }

    public final void zzf() {
        zzc();
        this.zzf = zza;
        this.zzd = zzne.zza;
        zzne zzne = zzne.zza;
        this.zze = zzne;
        this.zzb = zzne;
        this.zzc = zzne;
        zzm();
    }

    public boolean zzg() {
        return this.zze != zzne.zza;
    }

    public boolean zzh() {
        return this.zzh && this.zzg == zza;
    }

    /* access modifiers changed from: protected */
    public zzne zzi(zzne zzne) throws zznf {
        throw null;
    }

    /* access modifiers changed from: protected */
    public final ByteBuffer zzj(int i) {
        if (this.zzf.capacity() < i) {
            this.zzf = ByteBuffer.allocateDirect(i).order(ByteOrder.nativeOrder());
        } else {
            this.zzf.clear();
        }
        ByteBuffer byteBuffer = this.zzf;
        this.zzg = byteBuffer;
        return byteBuffer;
    }

    /* access modifiers changed from: protected */
    public void zzk() {
    }

    /* access modifiers changed from: protected */
    public void zzl() {
    }

    /* access modifiers changed from: protected */
    public void zzm() {
    }

    /* access modifiers changed from: protected */
    public final boolean zzn() {
        return this.zzg.hasRemaining();
    }
}
