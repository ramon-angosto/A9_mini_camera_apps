package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzauv implements Comparator<zzauu>, Parcelable {
    public static final Parcelable.Creator<zzauv> CREATOR = new zzaus();
    public final int zza;
    private final zzauu[] zzb;
    private int zzc;

    zzauv(Parcel parcel) {
        this.zzb = (zzauu[]) parcel.createTypedArray(zzauu.CREATOR);
        this.zza = this.zzb.length;
    }

    public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
        zzauu zzauu = (zzauu) obj;
        zzauu zzauu2 = (zzauu) obj2;
        if (zzash.zzb.equals(zzauu.zze)) {
            return !zzash.zzb.equals(zzauu2.zze) ? 1 : 0;
        }
        return zzauu.zze.compareTo(zzauu2.zze);
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return Arrays.equals(this.zzb, ((zzauv) obj).zzb);
    }

    public final int hashCode() {
        int i = this.zzc;
        if (i != 0) {
            return i;
        }
        int hashCode = Arrays.hashCode(this.zzb);
        this.zzc = hashCode;
        return hashCode;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedArray(this.zzb, 0);
    }

    public final zzauu zza(int i) {
        return this.zzb[i];
    }

    public zzauv(List list) {
        this(false, (zzauu[]) list.toArray(new zzauu[list.size()]));
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v9, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v3, resolved type: com.google.android.gms.internal.ads.zzauu[]} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private zzauv(boolean r3, com.google.android.gms.internal.ads.zzauu... r4) {
        /*
            r2 = this;
            r2.<init>()
            if (r3 == 0) goto L_0x000c
            java.lang.Object r3 = r4.clone()
            r4 = r3
            com.google.android.gms.internal.ads.zzauu[] r4 = (com.google.android.gms.internal.ads.zzauu[]) r4
        L_0x000c:
            java.util.Arrays.sort(r4, r2)
            r3 = 1
        L_0x0010:
            int r0 = r4.length
            if (r3 >= r0) goto L_0x0044
            int r0 = r3 + -1
            r0 = r4[r0]
            java.util.UUID r0 = r0.zze
            r1 = r4[r3]
            java.util.UUID r1 = r1.zze
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x002a
            int r3 = r3 + 1
            goto L_0x0010
        L_0x002a:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            r3 = r4[r3]
            java.util.UUID r3 = r3.zze
            java.lang.String r3 = java.lang.String.valueOf(r3)
            java.lang.String r3 = java.lang.String.valueOf(r3)
            java.lang.String r4 = "Duplicate data for uuid: "
            java.lang.String r3 = r4.concat(r3)
            r0.<init>(r3)
            throw r0
        L_0x0044:
            r2.zzb = r4
            r2.zza = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzauv.<init>(boolean, com.google.android.gms.internal.ads.zzauu[]):void");
    }

    public zzauv(zzauu... zzauuArr) {
        this(true, zzauuArr);
    }
}
