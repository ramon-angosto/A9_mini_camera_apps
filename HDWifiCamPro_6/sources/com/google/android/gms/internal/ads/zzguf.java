package com.google.android.gms.internal.ads;

import libcore.io.Memory;
import sun.misc.Unsafe;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzguf extends zzguh {
    zzguf(Unsafe unsafe) {
        super(unsafe);
    }

    public final byte zza(long j) {
        return Memory.peekByte((int) j);
    }

    public final double zzb(Object obj, long j) {
        return Double.longBitsToDouble(zzm(obj, j));
    }

    public final float zzc(Object obj, long j) {
        return Float.intBitsToFloat(zzl(obj, j));
    }

    public final void zzd(long j, byte[] bArr, long j2, long j3) {
        Memory.peekByteArray((int) j, bArr, (int) j2, (int) j3);
    }

    public final void zze(Object obj, long j, boolean z) {
        if (zzgui.zzb) {
            zzgui.zzG(obj, j, r3 ? (byte) 1 : 0);
        } else {
            zzgui.zzH(obj, j, r3 ? (byte) 1 : 0);
        }
    }

    public final void zzf(Object obj, long j, byte b) {
        if (zzgui.zzb) {
            zzgui.zzG(obj, j, b);
        } else {
            zzgui.zzH(obj, j, b);
        }
    }

    public final void zzg(Object obj, long j, double d) {
        zzq(obj, j, Double.doubleToLongBits(d));
    }

    public final void zzh(Object obj, long j, float f) {
        zzp(obj, j, Float.floatToIntBits(f));
    }

    public final boolean zzi(Object obj, long j) {
        if (zzgui.zzb) {
            return zzgui.zzw(obj, j);
        }
        return zzgui.zzx(obj, j);
    }
}
