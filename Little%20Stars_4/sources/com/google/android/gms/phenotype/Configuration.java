package com.google.android.gms.phenotype;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.zzz;
import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class Configuration extends AbstractSafeParcelable implements Comparable<Configuration> {
    public static final Parcelable.Creator<Configuration> CREATOR = new zza();
    final int mVersionCode;
    public final int zzbkB;
    public final Flag[] zzbkC;
    public final String[] zzbkD;
    public final Map<String, Flag> zzbkE = new TreeMap();

    Configuration(int i, int i2, Flag[] flagArr, String[] strArr) {
        this.mVersionCode = i;
        this.zzbkB = i2;
        this.zzbkC = flagArr;
        for (Flag flag : flagArr) {
            this.zzbkE.put(flag.name, flag);
        }
        this.zzbkD = strArr;
        String[] strArr2 = this.zzbkD;
        if (strArr2 != null) {
            Arrays.sort(strArr2);
        }
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Configuration)) {
            return false;
        }
        Configuration configuration = (Configuration) obj;
        return this.mVersionCode == configuration.mVersionCode && this.zzbkB == configuration.zzbkB && zzz.equal(this.zzbkE, configuration.zzbkE) && Arrays.equals(this.zzbkD, configuration.zzbkD);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Configuration(");
        sb.append(this.mVersionCode);
        sb.append(", ");
        sb.append(this.zzbkB);
        sb.append(", ");
        sb.append("(");
        for (Flag append : this.zzbkE.values()) {
            sb.append(append);
            sb.append(", ");
        }
        sb.append(")");
        sb.append(", ");
        sb.append("(");
        String[] strArr = this.zzbkD;
        if (strArr != null) {
            for (String append2 : strArr) {
                sb.append(append2);
                sb.append(", ");
            }
        } else {
            sb.append("null");
        }
        sb.append(")");
        sb.append(")");
        return sb.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        zza.zza(this, parcel, i);
    }

    /* renamed from: zza */
    public int compareTo(Configuration configuration) {
        return this.zzbkB - configuration.zzbkB;
    }
}
