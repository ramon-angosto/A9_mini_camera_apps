package com.google.android.gms.common.stats;

import android.os.Parcel;
import android.os.Parcelable;

public final class ConnectionEvent extends StatsEvent {
    public static final Parcelable.Creator<ConnectionEvent> CREATOR = new zza();
    final int mVersionCode;
    private final long zzatc;
    private int zzatd;
    private final String zzate;
    private final String zzatf;
    private final String zzatg;
    private final String zzath;
    private final String zzati;
    private final String zzatj;
    private final long zzatk;
    private final long zzatl;
    private long zzatm;

    ConnectionEvent(int i, long j, int i2, String str, String str2, String str3, String str4, String str5, String str6, long j2, long j3) {
        this.mVersionCode = i;
        this.zzatc = j;
        this.zzatd = i2;
        this.zzate = str;
        this.zzatf = str2;
        this.zzatg = str3;
        this.zzath = str4;
        this.zzatm = -1;
        this.zzati = str5;
        this.zzatj = str6;
        this.zzatk = j2;
        this.zzatl = j3;
    }

    public ConnectionEvent(long j, int i, String str, String str2, String str3, String str4, String str5, String str6, long j2, long j3) {
        this(1, j, i, str, str2, str3, str4, str5, str6, j2, j3);
    }

    public int getEventType() {
        return this.zzatd;
    }

    public long getTimeMillis() {
        return this.zzatc;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zza.zza(this, parcel, i);
    }

    public String zzuA() {
        return this.zzath;
    }

    public String zzuB() {
        return this.zzati;
    }

    public String zzuC() {
        return this.zzatj;
    }

    public long zzuD() {
        return this.zzatm;
    }

    public long zzuE() {
        return this.zzatl;
    }

    public long zzuF() {
        return this.zzatk;
    }

    public String zzuG() {
        String valueOf = String.valueOf(zzux());
        String valueOf2 = String.valueOf(zzuy());
        String valueOf3 = String.valueOf(zzuz());
        String valueOf4 = String.valueOf(zzuA());
        String str = this.zzati;
        if (str == null) {
            str = "";
        }
        long zzuE = zzuE();
        StringBuilder sb = new StringBuilder("\t".length() + 22 + String.valueOf(valueOf).length() + String.valueOf(valueOf2).length() + "\t".length() + String.valueOf(valueOf3).length() + String.valueOf(valueOf4).length() + "\t".length() + String.valueOf(str).length() + "\t".length());
        sb.append("\t");
        sb.append(valueOf);
        sb.append("/");
        sb.append(valueOf2);
        sb.append("\t");
        sb.append(valueOf3);
        sb.append("/");
        sb.append(valueOf4);
        sb.append("\t");
        sb.append(str);
        sb.append("\t");
        sb.append(zzuE);
        return sb.toString();
    }

    public String zzux() {
        return this.zzate;
    }

    public String zzuy() {
        return this.zzatf;
    }

    public String zzuz() {
        return this.zzatg;
    }
}
