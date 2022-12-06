package com.google.android.gms.internal;

import android.util.Log;
import com.google.android.gms.common.internal.zzp;
import com.xiaomi.mipush.sdk.Constants;

public class zzps {
    private final String mTag;
    private final int zzXw;
    private final zzp zzasA;
    private final String zzash;

    private zzps(String str, String str2) {
        this.zzash = str2;
        this.mTag = str;
        this.zzasA = new zzp(str);
        this.zzXw = getLogLevel();
    }

    public zzps(String str, String... strArr) {
        this(str, zzc(strArr));
    }

    private int getLogLevel() {
        int i = 2;
        while (7 >= i && !Log.isLoggable(this.mTag, i)) {
            i++;
        }
        return i;
    }

    private static String zzc(String... strArr) {
        if (strArr.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for (String str : strArr) {
            if (sb.length() > 1) {
                sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
            }
            sb.append(str);
        }
        sb.append(']');
        sb.append(' ');
        return sb.toString();
    }

    /* access modifiers changed from: protected */
    public String format(String str, Object... objArr) {
        if (objArr != null && objArr.length > 0) {
            str = String.format(str, objArr);
        }
        return this.zzash.concat(str);
    }

    public boolean zzX(int i) {
        return this.zzXw <= i;
    }

    public void zza(String str, Object... objArr) {
        if (zzX(2)) {
            Log.v(this.mTag, format(str, objArr));
        }
    }
}
