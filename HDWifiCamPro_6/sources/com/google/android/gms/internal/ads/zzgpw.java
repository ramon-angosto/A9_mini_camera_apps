package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Locale;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public abstract class zzgpw implements Iterable, Serializable {
    private static final Comparator zza = new zzgpn();
    public static final zzgpw zzb = new zzgps(zzgro.zzd);
    private static final zzgpv zzd = new zzgpv((zzgpu) null);
    private int zzc = 0;

    static {
        int i = zzgph.zza;
    }

    zzgpw() {
    }

    static void zzB(int i, int i2) {
        if (((i2 - (i + 1)) | i) >= 0) {
            return;
        }
        if (i < 0) {
            throw new ArrayIndexOutOfBoundsException("Index < 0: " + i);
        }
        throw new ArrayIndexOutOfBoundsException("Index > length: " + i + ", " + i2);
    }

    public static zzgpt zzt() {
        return new zzgpt(128);
    }

    /* JADX WARNING: type inference failed for: r3v0, types: [java.util.Collection, java.lang.Iterable] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.android.gms.internal.ads.zzgpw zzu(java.lang.Iterable r3) {
        /*
            boolean r0 = r3 instanceof java.util.Collection
            if (r0 != 0) goto L_0x0015
            java.util.Iterator r0 = r3.iterator()
            r1 = 0
        L_0x0009:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x0019
            r0.next()
            int r1 = r1 + 1
            goto L_0x0009
        L_0x0015:
            int r1 = r3.size()
        L_0x0019:
            if (r1 != 0) goto L_0x001e
            com.google.android.gms.internal.ads.zzgpw r3 = zzb
            return r3
        L_0x001e:
            java.util.Iterator r3 = r3.iterator()
            com.google.android.gms.internal.ads.zzgpw r3 = zzc(r3, r1)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzgpw.zzu(java.lang.Iterable):com.google.android.gms.internal.ads.zzgpw");
    }

    public static zzgpw zzv(byte[] bArr) {
        return zzw(bArr, 0, bArr.length);
    }

    public static zzgpw zzw(byte[] bArr, int i, int i2) {
        zzq(i, i + i2, bArr.length);
        byte[] bArr2 = new byte[i2];
        System.arraycopy(bArr, i, bArr2, 0, i2);
        return new zzgps(bArr2);
    }

    public static zzgpw zzx(String str) {
        return new zzgps(str.getBytes(zzgro.zzb));
    }

    public static zzgpw zzy(InputStream inputStream) throws IOException {
        zzgpw zzgpw;
        ArrayList arrayList = new ArrayList();
        int i = 256;
        while (true) {
            byte[] bArr = new byte[i];
            int i2 = 0;
            while (i2 < i) {
                int read = inputStream.read(bArr, i2, i - i2);
                if (read == -1) {
                    break;
                }
                i2 += read;
            }
            if (i2 == 0) {
                zzgpw = null;
            } else {
                zzgpw = zzw(bArr, 0, i2);
            }
            if (zzgpw == null) {
                return zzu(arrayList);
            }
            arrayList.add(zzgpw);
            i = Math.min(i + i, 8192);
        }
    }

    static zzgpw zzz(byte[] bArr) {
        return new zzgps(bArr);
    }

    public abstract boolean equals(Object obj);

    public final int hashCode() {
        int i = this.zzc;
        if (i == 0) {
            int zzd2 = zzd();
            i = zzi(zzd2, 0, zzd2);
            if (i == 0) {
                i = 1;
            }
            this.zzc = i;
        }
        return i;
    }

    public final String toString() {
        Locale locale = Locale.ROOT;
        Object[] objArr = new Object[3];
        objArr[0] = Integer.toHexString(System.identityHashCode(this));
        objArr[1] = Integer.valueOf(zzd());
        objArr[2] = zzd() <= 50 ? zzgtw.zza(this) : zzgtw.zza(zzk(0, 47)).concat("...");
        return String.format(locale, "<ByteString@%s size=%d contents=\"%s\">", objArr);
    }

    public final String zzA(Charset charset) {
        return zzd() == 0 ? "" : zzm(charset);
    }

    @Deprecated
    public final void zzC(byte[] bArr, int i, int i2, int i3) {
        zzq(0, i3, zzd());
        zzq(i2, i2 + i3, bArr.length);
        if (i3 > 0) {
            zze(bArr, 0, i2, i3);
        }
    }

    public final boolean zzD() {
        return zzd() == 0;
    }

    public final byte[] zzE() {
        int zzd2 = zzd();
        if (zzd2 == 0) {
            return zzgro.zzd;
        }
        byte[] bArr = new byte[zzd2];
        zze(bArr, 0, 0, zzd2);
        return bArr;
    }

    public abstract byte zza(int i);

    /* access modifiers changed from: package-private */
    public abstract byte zzb(int i);

    public abstract int zzd();

    /* access modifiers changed from: protected */
    public abstract void zze(byte[] bArr, int i, int i2, int i3);

    /* access modifiers changed from: protected */
    public abstract int zzf();

    /* access modifiers changed from: protected */
    public abstract boolean zzh();

    /* access modifiers changed from: protected */
    public abstract int zzi(int i, int i2, int i3);

    /* access modifiers changed from: protected */
    public abstract int zzj(int i, int i2, int i3);

    public abstract zzgpw zzk(int i, int i2);

    public abstract zzgqe zzl();

    /* access modifiers changed from: protected */
    public abstract String zzm(Charset charset);

    public abstract ByteBuffer zzn();

    /* access modifiers changed from: package-private */
    public abstract void zzo(zzgpl zzgpl) throws IOException;

    public abstract boolean zzp();

    /* access modifiers changed from: protected */
    public final int zzr() {
        return this.zzc;
    }

    /* renamed from: zzs */
    public zzgpq iterator() {
        return new zzgpm(this);
    }

    private static zzgpw zzc(Iterator it, int i) {
        if (i <= 0) {
            throw new IllegalArgumentException(String.format("length (%s) must be >= 1", new Object[]{Integer.valueOf(i)}));
        } else if (i == 1) {
            return (zzgpw) it.next();
        } else {
            int i2 = i >>> 1;
            zzgpw zzc2 = zzc(it, i2);
            zzgpw zzc3 = zzc(it, i - i2);
            if (Integer.MAX_VALUE - zzc2.zzd() >= zzc3.zzd()) {
                return zzgtg.zzG(zzc2, zzc3);
            }
            int zzd2 = zzc2.zzd();
            int zzd3 = zzc3.zzd();
            throw new IllegalArgumentException("ByteString would be too long: " + zzd2 + "+" + zzd3);
        }
    }

    static int zzq(int i, int i2, int i3) {
        int i4 = i2 - i;
        if ((i | i2 | i4 | (i3 - i2)) >= 0) {
            return i4;
        }
        if (i < 0) {
            throw new IndexOutOfBoundsException("Beginning index: " + i + " < 0");
        } else if (i2 < i) {
            throw new IndexOutOfBoundsException("Beginning index larger than ending index: " + i + ", " + i2);
        } else {
            throw new IndexOutOfBoundsException("End index: " + i2 + " >= " + i3);
        }
    }
}
