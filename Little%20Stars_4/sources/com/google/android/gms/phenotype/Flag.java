package com.google.android.gms.phenotype;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.zzz;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Comparator;

public class Flag extends AbstractSafeParcelable implements Comparable<Flag> {
    public static final Parcelable.Creator<Flag> CREATOR = new zzb();
    private static final Charset UTF_8 = Charset.forName("UTF-8");
    public static final zza zzbkJ = new zza();
    final int mVersionCode;
    public final String name;
    final boolean zzaTF;
    final double zzaTH;
    final String zzasH;
    final long zzbkF;
    final byte[] zzbkG;
    public final int zzbkH;
    public final int zzbkI;

    public static class zza implements Comparator<Flag> {
        /* renamed from: zza */
        public int compare(Flag flag, Flag flag2) {
            return flag.zzbkI == flag2.zzbkI ? flag.name.compareTo(flag2.name) : flag.zzbkI - flag2.zzbkI;
        }
    }

    Flag(int i, String str, long j, boolean z, double d, String str2, byte[] bArr, int i2, int i3) {
        this.mVersionCode = i;
        this.name = str;
        this.zzbkF = j;
        this.zzaTF = z;
        this.zzaTH = d;
        this.zzasH = str2;
        this.zzbkG = bArr;
        this.zzbkH = i2;
        this.zzbkI = i3;
    }

    private static int compare(byte b, byte b2) {
        return b - b2;
    }

    private static int compare(int i, int i2) {
        if (i < i2) {
            return -1;
        }
        return i == i2 ? 0 : 1;
    }

    private static int compare(long j, long j2) {
        if (j < j2) {
            return -1;
        }
        return j == j2 ? 0 : 1;
    }

    private static int compare(String str, String str2) {
        if (str == str2) {
            return 0;
        }
        if (str == null) {
            return -1;
        }
        if (str2 == null) {
            return 1;
        }
        return str.compareTo(str2);
    }

    private static int compare(boolean z, boolean z2) {
        if (z == z2) {
            return 0;
        }
        return z ? 1 : -1;
    }

    public boolean equals(Object obj) {
        int i;
        if (obj == null || !(obj instanceof Flag)) {
            return false;
        }
        Flag flag = (Flag) obj;
        if (this.mVersionCode != flag.mVersionCode || !zzz.equal(this.name, flag.name) || (i = this.zzbkH) != flag.zzbkH || this.zzbkI != flag.zzbkI) {
            return false;
        }
        if (i == 1) {
            return this.zzbkF == flag.zzbkF;
        }
        if (i == 2) {
            return this.zzaTF == flag.zzaTF;
        }
        if (i == 3) {
            return this.zzaTH == flag.zzaTH;
        }
        if (i == 4) {
            return zzz.equal(this.zzasH, flag.zzasH);
        }
        if (i == 5) {
            return Arrays.equals(this.zzbkG, flag.zzbkG);
        }
        StringBuilder sb = new StringBuilder(31);
        sb.append("Invalid enum value: ");
        sb.append(i);
        throw new AssertionError(sb.toString());
    }

    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder("Flag(");
        sb.append(this.mVersionCode);
        sb.append(", ");
        sb.append(this.name);
        sb.append(", ");
        int i = this.zzbkH;
        if (i == 1) {
            sb.append(this.zzbkF);
        } else if (i == 2) {
            sb.append(this.zzaTF);
        } else if (i != 3) {
            if (i == 4) {
                sb.append("'");
                str = this.zzasH;
            } else if (i != 5) {
                StringBuilder sb2 = new StringBuilder(31);
                sb2.append("Invalid enum value: ");
                sb2.append(i);
                throw new AssertionError(sb2.toString());
            } else if (this.zzbkG == null) {
                sb.append("null");
            } else {
                sb.append("'");
                str = new String(this.zzbkG, UTF_8);
            }
            sb.append(str);
            sb.append("'");
        } else {
            sb.append(this.zzaTH);
        }
        sb.append(", ");
        sb.append(this.zzbkH);
        sb.append(", ");
        sb.append(this.zzbkI);
        sb.append(")");
        return sb.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzb.zza(this, parcel, i);
    }

    /* renamed from: zza */
    public int compareTo(Flag flag) {
        int compareTo = this.name.compareTo(flag.name);
        if (compareTo != 0) {
            return compareTo;
        }
        int compare = compare(this.zzbkH, flag.zzbkH);
        if (compare != 0) {
            return compare;
        }
        int i = this.zzbkH;
        if (i == 1) {
            return compare(this.zzbkF, flag.zzbkF);
        }
        if (i == 2) {
            return compare(this.zzaTF, flag.zzaTF);
        }
        if (i == 3) {
            return Double.compare(this.zzaTH, flag.zzaTH);
        }
        if (i == 4) {
            return compare(this.zzasH, flag.zzasH);
        }
        if (i == 5) {
            byte[] bArr = this.zzbkG;
            byte[] bArr2 = flag.zzbkG;
            if (bArr == bArr2) {
                return 0;
            }
            if (bArr == null) {
                return -1;
            }
            if (bArr2 == null) {
                return 1;
            }
            for (int i2 = 0; i2 < Math.min(this.zzbkG.length, flag.zzbkG.length); i2++) {
                int compare2 = compare(this.zzbkG[i2], flag.zzbkG[i2]);
                if (compare2 != 0) {
                    return compare2;
                }
            }
            return compare(this.zzbkG.length, flag.zzbkG.length);
        }
        StringBuilder sb = new StringBuilder(31);
        sb.append("Invalid enum value: ");
        sb.append(i);
        throw new AssertionError(sb.toString());
    }
}
