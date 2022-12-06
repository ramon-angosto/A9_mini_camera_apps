package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public abstract class zzfrj extends zzasa implements zzfrk {
    public static zzfrk zzb(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.play.core.lmd.protocol.ILmdOverlayService");
        return queryLocalInterface instanceof zzfrk ? (zzfrk) queryLocalInterface : new zzfri(iBinder);
    }
}
