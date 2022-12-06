package com.google.android.gms.internal;

import android.content.Context;

public final class zzte {
    public static void zza(Context context, String str, Throwable th) {
        StackTraceElement[] stackTrace = th.getStackTrace();
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < stackTrace.length && i < 2) {
            sb.append(stackTrace[i].toString());
            sb.append("\n");
            i++;
        }
        zztc zztc = new zztc(context, 10);
        zztc.zza(str, (byte[]) null, str, sb.toString());
        zztc.send();
    }

    public static void zza(Context context, Throwable th) {
        zza(context, "GMS_WTF", th);
    }
}
