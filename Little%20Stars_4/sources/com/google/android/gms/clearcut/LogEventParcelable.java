package com.google.android.gms.clearcut;

import android.os.Parcel;
import com.google.android.gms.clearcut.zzb;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.common.internal.zzz;
import com.google.android.gms.internal.zzamo;
import com.google.android.gms.playlog.internal.PlayLoggerContext;
import java.util.Arrays;

public class LogEventParcelable extends AbstractSafeParcelable {
    public static final zzd CREATOR = new zzd();
    public final int versionCode;
    public PlayLoggerContext zzajL;
    public byte[] zzajM;
    public int[] zzajN;
    public final zzamo.zzd zzajO;
    public final zzb.C0000zzb zzajP;
    public final zzb.C0000zzb zzajQ;

    LogEventParcelable(int i, PlayLoggerContext playLoggerContext, byte[] bArr, int[] iArr) {
        this.versionCode = i;
        this.zzajL = playLoggerContext;
        this.zzajM = bArr;
        this.zzajN = iArr;
        this.zzajO = null;
        this.zzajP = null;
        this.zzajQ = null;
    }

    public LogEventParcelable(PlayLoggerContext playLoggerContext, zzamo.zzd zzd, zzb.C0000zzb zzb, zzb.C0000zzb zzb2, int[] iArr) {
        this.versionCode = 1;
        this.zzajL = playLoggerContext;
        this.zzajO = zzd;
        this.zzajP = zzb;
        this.zzajQ = zzb2;
        this.zzajN = iArr;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LogEventParcelable)) {
            return false;
        }
        LogEventParcelable logEventParcelable = (LogEventParcelable) obj;
        return this.versionCode == logEventParcelable.versionCode && zzz.equal(this.zzajL, logEventParcelable.zzajL) && Arrays.equals(this.zzajM, logEventParcelable.zzajM) && Arrays.equals(this.zzajN, logEventParcelable.zzajN) && zzz.equal(this.zzajO, logEventParcelable.zzajO) && zzz.equal(this.zzajP, logEventParcelable.zzajP) && zzz.equal(this.zzajQ, logEventParcelable.zzajQ);
    }

    public int hashCode() {
        return zzz.hashCode(Integer.valueOf(this.versionCode), this.zzajL, this.zzajM, this.zzajN, this.zzajO, this.zzajP, this.zzajQ);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("LogEventParcelable[");
        sb.append(this.versionCode);
        sb.append(", ");
        sb.append(this.zzajL);
        sb.append(", ");
        sb.append("LogEventBytes: ");
        byte[] bArr = this.zzajM;
        String str = null;
        sb.append(bArr == null ? null : new String(bArr));
        sb.append(", ");
        sb.append("TestCodes: ");
        if (this.zzajN != null) {
            str = zzx.zzdk(", ").zza(Arrays.asList(new int[][]{this.zzajN}));
        }
        sb.append(str);
        sb.append(", ");
        sb.append("LogEvent: ");
        sb.append(this.zzajO);
        sb.append(", ");
        sb.append("ExtensionProducer: ");
        sb.append(this.zzajP);
        sb.append(", ");
        sb.append("VeProducer: ");
        sb.append(this.zzajQ);
        sb.append("]");
        return sb.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzd.zza(this, parcel, i);
    }
}
