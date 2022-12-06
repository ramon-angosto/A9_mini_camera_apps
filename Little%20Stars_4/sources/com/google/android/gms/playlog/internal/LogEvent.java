package com.google.android.gms.playlog.internal;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.xiaomi.mipush.sdk.Constants;

public class LogEvent extends AbstractSafeParcelable {
    public static final zzc CREATOR = new zzc();
    public final String tag;
    public final int versionCode;
    public final long zzbkO;
    public final long zzbkP;
    public final byte[] zzbkQ;
    public final Bundle zzbkR;

    LogEvent(int i, long j, long j2, String str, byte[] bArr, Bundle bundle) {
        this.versionCode = i;
        this.zzbkO = j;
        this.zzbkP = j2;
        this.tag = str;
        this.zzbkQ = bArr;
        this.zzbkR = bundle;
    }

    public LogEvent(long j, long j2, String str, byte[] bArr, String... strArr) {
        this.versionCode = 1;
        this.zzbkO = j;
        this.zzbkP = j2;
        this.tag = str;
        this.zzbkQ = bArr;
        this.zzbkR = zzf(strArr);
    }

    private static Bundle zzf(String... strArr) {
        if (strArr == null) {
            return null;
        }
        if (strArr.length % 2 == 0) {
            int length = strArr.length / 2;
            if (length == 0) {
                return null;
            }
            Bundle bundle = new Bundle(length);
            for (int i = 0; i < length; i++) {
                int i2 = i * 2;
                bundle.putString(strArr[i2], strArr[i2 + 1]);
            }
            return bundle;
        }
        throw new IllegalArgumentException("extras must have an even number of elements");
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("tag=");
        sb.append(this.tag);
        sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
        sb.append("eventTime=");
        sb.append(this.zzbkO);
        sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
        sb.append("eventUptime=");
        sb.append(this.zzbkP);
        sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
        Bundle bundle = this.zzbkR;
        if (bundle != null && !bundle.isEmpty()) {
            sb.append("keyValues=");
            for (String str : this.zzbkR.keySet()) {
                sb.append("(");
                sb.append(str);
                sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                sb.append(this.zzbkR.getString(str));
                sb.append(")");
                sb.append(" ");
            }
        }
        return sb.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzc.zza(this, parcel, i);
    }
}
