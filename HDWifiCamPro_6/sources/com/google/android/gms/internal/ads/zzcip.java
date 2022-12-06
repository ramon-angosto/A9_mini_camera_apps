package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.view.Surface;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public abstract class zzcip {
    protected static final AtomicInteger zza = new AtomicInteger(0);
    protected static final AtomicInteger zzb = new AtomicInteger(0);

    public static int zzs() {
        return zza.get();
    }

    public static int zzu() {
        return zzb.get();
    }

    public abstract long zzA();

    public abstract long zzB();

    public abstract void zzC(Uri[] uriArr, String str);

    public abstract void zzD(Uri[] uriArr, String str, ByteBuffer byteBuffer, boolean z);

    public abstract void zzE();

    public abstract void zzF(long j);

    public abstract void zzG(int i);

    public abstract void zzH(int i);

    public abstract void zzI(zzcio zzcio);

    public abstract void zzJ(int i);

    public abstract void zzK(int i);

    public abstract void zzL(boolean z);

    public abstract void zzM(boolean z);

    public abstract void zzN(int i);

    public abstract void zzO(Surface surface, boolean z) throws IOException;

    public abstract void zzP(float f, boolean z) throws IOException;

    public abstract void zzQ();

    public abstract boolean zzR();

    public abstract int zzr();

    public abstract int zzt();

    public abstract long zzv();

    public abstract long zzw();

    public abstract long zzx();

    public abstract long zzy();

    public abstract long zzz();
}
