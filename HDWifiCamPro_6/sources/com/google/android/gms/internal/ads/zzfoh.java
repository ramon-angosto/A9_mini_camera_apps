package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzfoh extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzfoh> CREATOR = new zzfoi();
    public final int zza;
    private zzana zzb = null;
    private byte[] zzc;

    zzfoh(int i, byte[] bArr) {
        this.zza = i;
        this.zzc = bArr;
        zzb();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zza);
        byte[] bArr = this.zzc;
        if (bArr == null) {
            bArr = this.zzb.zzax();
        }
        SafeParcelWriter.writeByteArray(parcel, 2, bArr, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final zzana zza() {
        if (this.zzb == null) {
            try {
                this.zzb = zzana.zze(this.zzc, zzgqq.zza());
                this.zzc = null;
            } catch (zzgrq | NullPointerException e) {
                throw new IllegalStateException(e);
            }
        }
        zzb();
        return this.zzb;
    }

    private final void zzb() {
        zzana zzana = this.zzb;
        if (zzana == null && this.zzc != null) {
            return;
        }
        if (zzana != null && this.zzc == null) {
            return;
        }
        if (zzana != null && this.zzc != null) {
            throw new IllegalStateException("Invalid internal representation - full");
        } else if (zzana == null && this.zzc == null) {
            throw new IllegalStateException("Invalid internal representation - empty");
        } else {
            throw new IllegalStateException("Impossible");
        }
    }
}
