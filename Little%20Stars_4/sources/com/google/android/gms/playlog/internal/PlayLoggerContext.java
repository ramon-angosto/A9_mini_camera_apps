package com.google.android.gms.playlog.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.common.internal.zzz;

public class PlayLoggerContext extends AbstractSafeParcelable {
    public static final zze CREATOR = new zze();
    public final String packageName;
    public final int versionCode;
    public final int zzbkZ;
    public final int zzbla;
    public final String zzblb;
    public final String zzblc;
    public final boolean zzbld;
    public final String zzble;
    public final boolean zzblf;
    public final int zzblg;

    public PlayLoggerContext(int i, String str, int i2, int i3, String str2, String str3, boolean z, String str4, boolean z2, int i4) {
        this.versionCode = i;
        this.packageName = str;
        this.zzbkZ = i2;
        this.zzbla = i3;
        this.zzblb = str2;
        this.zzblc = str3;
        this.zzbld = z;
        this.zzble = str4;
        this.zzblf = z2;
        this.zzblg = i4;
    }

    public PlayLoggerContext(String str, int i, int i2, String str2, String str3, String str4, boolean z, int i3) {
        this.versionCode = 1;
        this.packageName = (String) zzaa.zzz(str);
        this.zzbkZ = i;
        this.zzbla = i2;
        this.zzble = str2;
        this.zzblb = str3;
        this.zzblc = str4;
        this.zzbld = !z;
        this.zzblf = z;
        this.zzblg = i3;
    }

    @Deprecated
    public PlayLoggerContext(String str, int i, int i2, String str2, String str3, boolean z) {
        this.versionCode = 1;
        this.packageName = (String) zzaa.zzz(str);
        this.zzbkZ = i;
        this.zzbla = i2;
        this.zzble = null;
        this.zzblb = str2;
        this.zzblc = str3;
        this.zzbld = z;
        this.zzblf = false;
        this.zzblg = 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PlayLoggerContext)) {
            return false;
        }
        PlayLoggerContext playLoggerContext = (PlayLoggerContext) obj;
        return this.versionCode == playLoggerContext.versionCode && this.packageName.equals(playLoggerContext.packageName) && this.zzbkZ == playLoggerContext.zzbkZ && this.zzbla == playLoggerContext.zzbla && zzz.equal(this.zzble, playLoggerContext.zzble) && zzz.equal(this.zzblb, playLoggerContext.zzblb) && zzz.equal(this.zzblc, playLoggerContext.zzblc) && this.zzbld == playLoggerContext.zzbld && this.zzblf == playLoggerContext.zzblf && this.zzblg == playLoggerContext.zzblg;
    }

    public int hashCode() {
        return zzz.hashCode(Integer.valueOf(this.versionCode), this.packageName, Integer.valueOf(this.zzbkZ), Integer.valueOf(this.zzbla), this.zzble, this.zzblb, this.zzblc, Boolean.valueOf(this.zzbld), Boolean.valueOf(this.zzblf), Integer.valueOf(this.zzblg));
    }

    public String toString() {
        return "PlayLoggerContext[" + "versionCode=" + this.versionCode + ',' + "package=" + this.packageName + ',' + "packageVersionCode=" + this.zzbkZ + ',' + "logSource=" + this.zzbla + ',' + "logSourceName=" + this.zzble + ',' + "uploadAccount=" + this.zzblb + ',' + "loggingId=" + this.zzblc + ',' + "logAndroidId=" + this.zzbld + ',' + "isAnonymous=" + this.zzblf + ',' + "qosTier=" + this.zzblg + "]";
    }

    public void writeToParcel(Parcel parcel, int i) {
        zze.zza(this, parcel, i);
    }
}
