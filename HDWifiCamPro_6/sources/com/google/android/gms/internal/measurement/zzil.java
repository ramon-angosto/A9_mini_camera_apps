package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzik;
import com.google.android.gms.internal.measurement.zzil;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement-base@@20.1.2 */
public abstract class zzil<MessageType extends zzil<MessageType, BuilderType>, BuilderType extends zzik<MessageType, BuilderType>> implements zzlj {
    protected int zzb = 0;

    protected static void zzbw(Iterable iterable, List list) {
        zzkk.zze(iterable);
        if (iterable instanceof zzkr) {
            List zzh = ((zzkr) iterable).zzh();
            zzkr zzkr = (zzkr) list;
            int size = list.size();
            for (Object next : zzh) {
                if (next == null) {
                    int size2 = zzkr.size();
                    String str = "Element at index " + (size2 - size) + " is null.";
                    int size3 = zzkr.size();
                    while (true) {
                        size3--;
                        if (size3 >= size) {
                            zzkr.remove(size3);
                        } else {
                            throw new NullPointerException(str);
                        }
                    }
                } else if (next instanceof zzjb) {
                    zzkr.zzi((zzjb) next);
                } else {
                    zzkr.add((String) next);
                }
            }
        } else if (!(iterable instanceof zzlq)) {
            if ((list instanceof ArrayList) && (iterable instanceof Collection)) {
                ((ArrayList) list).ensureCapacity(list.size() + ((Collection) iterable).size());
            }
            int size4 = list.size();
            for (Object next2 : iterable) {
                if (next2 == null) {
                    int size5 = list.size();
                    String str2 = "Element at index " + (size5 - size4) + " is null.";
                    int size6 = list.size();
                    while (true) {
                        size6--;
                        if (size6 >= size4) {
                            list.remove(size6);
                        } else {
                            throw new NullPointerException(str2);
                        }
                    }
                } else {
                    list.add(next2);
                }
            }
        } else {
            list.addAll((Collection) iterable);
        }
    }

    /* access modifiers changed from: package-private */
    public int zzbu() {
        throw null;
    }

    public final zzjb zzbv() {
        try {
            int zzbz = zzbz();
            zzjb zzjb = zzjb.zzb;
            byte[] bArr = new byte[zzbz];
            zzjj zzC = zzjj.zzC(bArr);
            zzbN(zzC);
            zzC.zzD();
            return new zziy(bArr);
        } catch (IOException e) {
            String name = getClass().getName();
            throw new RuntimeException("Serializing " + name + " to a ByteString threw an IOException (should never happen).", e);
        }
    }

    /* access modifiers changed from: package-private */
    public void zzbx(int i) {
        throw null;
    }

    public final byte[] zzby() {
        try {
            byte[] bArr = new byte[zzbz()];
            zzjj zzC = zzjj.zzC(bArr);
            zzbN(zzC);
            zzC.zzD();
            return bArr;
        } catch (IOException e) {
            String name = getClass().getName();
            throw new RuntimeException("Serializing " + name + " to a byte array threw an IOException (should never happen).", e);
        }
    }
}
