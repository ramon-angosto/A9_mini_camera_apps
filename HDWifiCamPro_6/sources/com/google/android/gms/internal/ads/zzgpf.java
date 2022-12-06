package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzgpe;
import com.google.android.gms.internal.ads.zzgpf;
import java.io.IOException;
import java.io.OutputStream;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public abstract class zzgpf<MessageType extends zzgpf<MessageType, BuilderType>, BuilderType extends zzgpe<MessageType, BuilderType>> implements zzgso {
    protected int zza = 0;

    /* JADX WARNING: type inference failed for: r3v0, types: [java.util.Collection, java.lang.Object, java.lang.Iterable] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected static void zzau(java.lang.Iterable r3, java.util.List r4) {
        /*
            com.google.android.gms.internal.ads.zzgro.zze(r3)
            boolean r0 = r4 instanceof java.util.ArrayList
            if (r0 == 0) goto L_0x0016
            r0 = r4
            java.util.ArrayList r0 = (java.util.ArrayList) r0
            int r1 = r4.size()
            int r2 = r3.size()
            int r1 = r1 + r2
            r0.ensureCapacity(r1)
        L_0x0016:
            int r0 = r4.size()
            java.util.Iterator r3 = r3.iterator()
        L_0x001e:
            boolean r1 = r3.hasNext()
            if (r1 == 0) goto L_0x005b
            java.lang.Object r1 = r3.next()
            if (r1 != 0) goto L_0x0057
            int r3 = r4.size()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Element at index "
            r1.append(r2)
            int r3 = r3 - r0
            r1.append(r3)
            java.lang.String r3 = " is null."
            r1.append(r3)
            java.lang.String r3 = r1.toString()
            int r1 = r4.size()
        L_0x0049:
            int r1 = r1 + -1
            if (r1 < r0) goto L_0x0051
            r4.remove(r1)
            goto L_0x0049
        L_0x0051:
            java.lang.NullPointerException r4 = new java.lang.NullPointerException
            r4.<init>(r3)
            throw r4
        L_0x0057:
            r4.add(r1)
            goto L_0x001e
        L_0x005b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzgpf.zzau(java.lang.Iterable, java.util.List):void");
    }

    /* access modifiers changed from: package-private */
    public int zzas() {
        throw null;
    }

    public final zzgpw zzat() {
        try {
            int zzay = zzay();
            zzgpw zzgpw = zzgpw.zzb;
            byte[] bArr = new byte[zzay];
            zzgql zzG = zzgql.zzG(bArr);
            zzaR(zzG);
            zzG.zzI();
            return new zzgps(bArr);
        } catch (IOException e) {
            String name = getClass().getName();
            throw new RuntimeException("Serializing " + name + " to a ByteString threw an IOException (should never happen).", e);
        }
    }

    /* access modifiers changed from: package-private */
    public void zzav(int i) {
        throw null;
    }

    public final void zzaw(OutputStream outputStream) throws IOException {
        zzgql zzH = zzgql.zzH(outputStream, zzgql.zzB(zzay()));
        zzaR(zzH);
        zzH.zzN();
    }

    public final byte[] zzax() {
        try {
            byte[] bArr = new byte[zzay()];
            zzgql zzG = zzgql.zzG(bArr);
            zzaR(zzG);
            zzG.zzI();
            return bArr;
        } catch (IOException e) {
            String name = getClass().getName();
            throw new RuntimeException("Serializing " + name + " to a byte array threw an IOException (should never happen).", e);
        }
    }
}
