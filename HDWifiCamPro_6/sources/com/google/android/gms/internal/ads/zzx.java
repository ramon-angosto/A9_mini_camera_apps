package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzx implements Comparator<zzw>, Parcelable {
    public static final Parcelable.Creator<zzx> CREATOR = new zzu();
    public final String zza;
    public final int zzb;
    private final zzw[] zzc;
    private int zzd;

    zzx(Parcel parcel) {
        this.zza = parcel.readString();
        this.zzc = (zzw[]) zzen.zzH((zzw[]) parcel.createTypedArray(zzw.CREATOR));
        this.zzb = this.zzc.length;
    }

    public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
        zzw zzw = (zzw) obj;
        zzw zzw2 = (zzw) obj2;
        if (zzo.zza.equals(zzw.zza)) {
            return !zzo.zza.equals(zzw2.zza) ? 1 : 0;
        }
        return zzw.zza.compareTo(zzw2.zza);
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            zzx zzx = (zzx) obj;
            return zzen.zzT(this.zza, zzx.zza) && Arrays.equals(this.zzc, zzx.zzc);
        }
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.zza);
        parcel.writeTypedArray(this.zzc, 0);
    }

    public final zzw zza(int i) {
        return this.zzc[i];
    }

    public final zzx zzb(String str) {
        if (zzen.zzT(this.zza, str)) {
            return this;
        }
        return new zzx(str, false, this.zzc);
    }

    public final int hashCode() {
        int i;
        int i2 = this.zzd;
        if (i2 != 0) {
            return i2;
        }
        String str = this.zza;
        if (str == null) {
            i = 0;
        } else {
            i = str.hashCode();
        }
        int hashCode = (i * 31) + Arrays.hashCode(this.zzc);
        this.zzd = hashCode;
        return hashCode;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: com.google.android.gms.internal.ads.zzw[]} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private zzx(java.lang.String r1, boolean r2, com.google.android.gms.internal.ads.zzw... r3) {
        /*
            r0 = this;
            r0.<init>()
            r0.zza = r1
            if (r2 == 0) goto L_0x000e
            java.lang.Object r1 = r3.clone()
            r3 = r1
            com.google.android.gms.internal.ads.zzw[] r3 = (com.google.android.gms.internal.ads.zzw[]) r3
        L_0x000e:
            r0.zzc = r3
            int r1 = r3.length
            r0.zzb = r1
            com.google.android.gms.internal.ads.zzw[] r1 = r0.zzc
            java.util.Arrays.sort(r1, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzx.<init>(java.lang.String, boolean, com.google.android.gms.internal.ads.zzw[]):void");
    }

    public zzx(String str, zzw... zzwArr) {
        this((String) null, true, zzwArr);
    }

    public zzx(List list) {
        this((String) null, false, (zzw[]) list.toArray(new zzw[0]));
    }
}
