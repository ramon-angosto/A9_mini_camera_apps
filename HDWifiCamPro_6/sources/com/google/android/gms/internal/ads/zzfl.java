package com.google.android.gms.internal.ads;

import android.system.ErrnoException;
import android.system.OsConstants;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzfl {
    /* access modifiers changed from: private */
    public static boolean zzb(Throwable th) {
        return (th instanceof ErrnoException) && ((ErrnoException) th).errno == OsConstants.EACCES;
    }
}
