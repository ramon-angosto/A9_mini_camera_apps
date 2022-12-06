package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Iterator;
import kotlin.UByte;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzgrr extends InputStream {
    private Iterator zza;
    private ByteBuffer zzb;
    private int zzc = 0;
    private int zzd;
    private int zze;
    private boolean zzf;
    private byte[] zzg;
    private int zzh;
    private long zzi;

    zzgrr(Iterable iterable) {
        this.zza = iterable.iterator();
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            ByteBuffer byteBuffer = (ByteBuffer) it.next();
            this.zzc++;
        }
        this.zzd = -1;
        if (!zzb()) {
            this.zzb = zzgro.zze;
            this.zzd = 0;
            this.zze = 0;
            this.zzi = 0;
        }
    }

    private final void zza(int i) {
        int i2 = this.zze + i;
        this.zze = i2;
        if (i2 == this.zzb.limit()) {
            zzb();
        }
    }

    private final boolean zzb() {
        this.zzd++;
        if (!this.zza.hasNext()) {
            return false;
        }
        this.zzb = (ByteBuffer) this.zza.next();
        this.zze = this.zzb.position();
        if (this.zzb.hasArray()) {
            this.zzf = true;
            this.zzg = this.zzb.array();
            this.zzh = this.zzb.arrayOffset();
        } else {
            this.zzf = false;
            this.zzi = zzgui.zze(this.zzb);
            this.zzg = null;
        }
        return true;
    }

    public final int read() throws IOException {
        byte zza2;
        if (this.zzd == this.zzc) {
            return -1;
        }
        if (this.zzf) {
            zza2 = this.zzg[this.zze + this.zzh];
            zza(1);
        } else {
            zza2 = zzgui.zza(((long) this.zze) + this.zzi);
            zza(1);
        }
        return zza2 & UByte.MAX_VALUE;
    }

    public final int read(byte[] bArr, int i, int i2) throws IOException {
        if (this.zzd == this.zzc) {
            return -1;
        }
        int limit = this.zzb.limit();
        int i3 = this.zze;
        int i4 = limit - i3;
        if (i2 > i4) {
            i2 = i4;
        }
        if (this.zzf) {
            System.arraycopy(this.zzg, i3 + this.zzh, bArr, i, i2);
            zza(i2);
        } else {
            int position = this.zzb.position();
            ByteBuffer byteBuffer = (ByteBuffer) this.zzb.position(this.zze);
            this.zzb.get(bArr, i, i2);
            ByteBuffer byteBuffer2 = (ByteBuffer) this.zzb.position(position);
            zza(i2);
        }
        return i2;
    }
}
