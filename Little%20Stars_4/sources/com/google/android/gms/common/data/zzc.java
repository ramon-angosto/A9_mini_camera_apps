package com.google.android.gms.common.data;

import android.database.CharArrayBuffer;
import android.net.Uri;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.common.internal.zzz;

public abstract class zzc {
    protected final DataHolder zzamz;
    protected int zzapa;
    private int zzapb;

    public zzc(DataHolder dataHolder, int i) {
        this.zzamz = (DataHolder) zzaa.zzz(dataHolder);
        zzbN(i);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof zzc)) {
            return false;
        }
        zzc zzc = (zzc) obj;
        return zzz.equal(Integer.valueOf(zzc.zzapa), Integer.valueOf(this.zzapa)) && zzz.equal(Integer.valueOf(zzc.zzapb), Integer.valueOf(this.zzapb)) && zzc.zzamz == this.zzamz;
    }

    /* access modifiers changed from: protected */
    public boolean getBoolean(String str) {
        return this.zzamz.zze(str, this.zzapa, this.zzapb);
    }

    /* access modifiers changed from: protected */
    public byte[] getByteArray(String str) {
        return this.zzamz.zzg(str, this.zzapa, this.zzapb);
    }

    /* access modifiers changed from: protected */
    public float getFloat(String str) {
        return this.zzamz.zzf(str, this.zzapa, this.zzapb);
    }

    /* access modifiers changed from: protected */
    public int getInteger(String str) {
        return this.zzamz.zzc(str, this.zzapa, this.zzapb);
    }

    /* access modifiers changed from: protected */
    public long getLong(String str) {
        return this.zzamz.zzb(str, this.zzapa, this.zzapb);
    }

    /* access modifiers changed from: protected */
    public String getString(String str) {
        return this.zzamz.zzd(str, this.zzapa, this.zzapb);
    }

    public int hashCode() {
        return zzz.hashCode(Integer.valueOf(this.zzapa), Integer.valueOf(this.zzapb), this.zzamz);
    }

    public boolean isDataValid() {
        return !this.zzamz.isClosed();
    }

    /* access modifiers changed from: protected */
    public void zza(String str, CharArrayBuffer charArrayBuffer) {
        this.zzamz.zza(str, this.zzapa, this.zzapb, charArrayBuffer);
    }

    /* access modifiers changed from: protected */
    public void zzbN(int i) {
        zzaa.zzai(i >= 0 && i < this.zzamz.getCount());
        this.zzapa = i;
        this.zzapb = this.zzamz.zzbP(this.zzapa);
    }

    public boolean zzcY(String str) {
        return this.zzamz.zzcY(str);
    }

    /* access modifiers changed from: protected */
    public Uri zzcZ(String str) {
        return this.zzamz.zzh(str, this.zzapa, this.zzapb);
    }

    /* access modifiers changed from: protected */
    public boolean zzda(String str) {
        return this.zzamz.zzi(str, this.zzapa, this.zzapb);
    }

    /* access modifiers changed from: protected */
    public int zzsR() {
        return this.zzapa;
    }
}
