package com.google.android.gms.common.stats;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.xiaomi.mipush.sdk.Constants;
import java.util.List;

public final class WakeLockEvent extends StatsEvent {
    public static final Parcelable.Creator<WakeLockEvent> CREATOR = new zzg();
    private final long mTimeout;
    final int mVersionCode;
    private final String zzatO;
    private final String zzatP;
    private final String zzatQ;
    private final int zzatR;
    private final List<String> zzatS;
    private final String zzatT;
    private int zzatU;
    private final String zzatV;
    private final float zzatW;
    private final long zzatc;
    private int zzatd;
    private final long zzatk;
    private long zzatm;

    WakeLockEvent(int i, long j, int i2, String str, int i3, List<String> list, String str2, long j2, int i4, String str3, String str4, float f, long j3, String str5) {
        this.mVersionCode = i;
        this.zzatc = j;
        this.zzatd = i2;
        this.zzatO = str;
        this.zzatP = str3;
        this.zzatQ = str5;
        this.zzatR = i3;
        this.zzatm = -1;
        this.zzatS = list;
        this.zzatT = str2;
        this.zzatk = j2;
        this.zzatU = i4;
        this.zzatV = str4;
        this.zzatW = f;
        this.mTimeout = j3;
    }

    public WakeLockEvent(long j, int i, String str, int i2, List<String> list, String str2, long j2, int i3, String str3, String str4, float f, long j3, String str5) {
        this(2, j, i, str, i2, list, str2, j2, i3, str3, str4, f, j3, str5);
    }

    public int getEventType() {
        return this.zzatd;
    }

    public long getTimeMillis() {
        return this.zzatc;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzg.zza(this, parcel, i);
    }

    public String zzuC() {
        return this.zzatT;
    }

    public long zzuD() {
        return this.zzatm;
    }

    public long zzuF() {
        return this.zzatk;
    }

    public String zzuG() {
        String valueOf = String.valueOf(zzuJ());
        int zzuM = zzuM();
        String str = "";
        String join = zzuN() == null ? str : TextUtils.join(Constants.ACCEPT_TIME_SEPARATOR_SP, zzuN());
        int zzuO = zzuO();
        String zzuK = zzuK() == null ? str : zzuK();
        String zzuP = zzuP() == null ? str : zzuP();
        float zzuQ = zzuQ();
        if (zzuL() != null) {
            str = zzuL();
        }
        StringBuilder sb = new StringBuilder("\t".length() + 37 + String.valueOf(valueOf).length() + "\t".length() + "\t".length() + String.valueOf(join).length() + "\t".length() + "\t".length() + String.valueOf(zzuK).length() + "\t".length() + String.valueOf(zzuP).length() + "\t".length() + "\t".length() + String.valueOf(str).length());
        sb.append("\t");
        sb.append(valueOf);
        sb.append("\t");
        sb.append(zzuM);
        sb.append("\t");
        sb.append(join);
        sb.append("\t");
        sb.append(zzuO);
        sb.append("\t");
        sb.append(zzuK);
        sb.append("\t");
        sb.append(zzuP);
        sb.append("\t");
        sb.append(zzuQ);
        sb.append("\t");
        sb.append(str);
        return sb.toString();
    }

    public String zzuJ() {
        return this.zzatO;
    }

    public String zzuK() {
        return this.zzatP;
    }

    public String zzuL() {
        return this.zzatQ;
    }

    public int zzuM() {
        return this.zzatR;
    }

    public List<String> zzuN() {
        return this.zzatS;
    }

    public int zzuO() {
        return this.zzatU;
    }

    public String zzuP() {
        return this.zzatV;
    }

    public float zzuQ() {
        return this.zzatW;
    }

    public long zzuR() {
        return this.mTimeout;
    }
}
