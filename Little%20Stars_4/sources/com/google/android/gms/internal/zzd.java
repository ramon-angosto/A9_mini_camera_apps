package com.google.android.gms.internal;

public class zzd implements zzo {
    private int zzn;
    private int zzo;
    private final int zzp;
    private final float zzq;

    public zzd() {
        this(2500, 1, 1.0f);
    }

    public zzd(int i, int i2, float f) {
        this.zzn = i;
        this.zzp = i2;
        this.zzq = f;
    }

    public void zza(zzr zzr) throws zzr {
        this.zzo++;
        int i = this.zzn;
        this.zzn = (int) (((float) i) + (((float) i) * this.zzq));
        if (!zze()) {
            throw zzr;
        }
    }

    public int zzc() {
        return this.zzn;
    }

    public int zzd() {
        return this.zzo;
    }

    /* access modifiers changed from: protected */
    public boolean zze() {
        return this.zzo <= this.zzp;
    }
}
