package com.google.android.gms.internal;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class zzamg implements Cloneable {
    private Object zzbIu;
    private zzame<?, ?> zzcag;
    private List<zzaml> zzcah;

    zzamg() {
        this.zzcah = new ArrayList();
    }

    <T> zzamg(zzame<?, T> zzame, T t) {
        this.zzcag = zzame;
        this.zzbIu = t;
    }

    private byte[] toByteArray() throws IOException {
        byte[] bArr = new byte[zzy()];
        writeTo(zzamc.zzO(bArr));
        return bArr;
    }

    public boolean equals(Object obj) {
        List<zzaml> list;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzamg)) {
            return false;
        }
        zzamg zzamg = (zzamg) obj;
        if (this.zzbIu == null || zzamg.zzbIu == null) {
            List<zzaml> list2 = this.zzcah;
            if (list2 != null && (list = zzamg.zzcah) != null) {
                return list2.equals(list);
            }
            try {
                return Arrays.equals(toByteArray(), zzamg.toByteArray());
            } catch (IOException e) {
                throw new IllegalStateException(e);
            }
        } else {
            zzame<?, ?> zzame = this.zzcag;
            if (zzame != zzamg.zzcag) {
                return false;
            }
            if (!zzame.zzbSs.isArray()) {
                return this.zzbIu.equals(zzamg.zzbIu);
            }
            Object obj2 = this.zzbIu;
            return obj2 instanceof byte[] ? Arrays.equals((byte[]) obj2, (byte[]) zzamg.zzbIu) : obj2 instanceof int[] ? Arrays.equals((int[]) obj2, (int[]) zzamg.zzbIu) : obj2 instanceof long[] ? Arrays.equals((long[]) obj2, (long[]) zzamg.zzbIu) : obj2 instanceof float[] ? Arrays.equals((float[]) obj2, (float[]) zzamg.zzbIu) : obj2 instanceof double[] ? Arrays.equals((double[]) obj2, (double[]) zzamg.zzbIu) : obj2 instanceof boolean[] ? Arrays.equals((boolean[]) obj2, (boolean[]) zzamg.zzbIu) : Arrays.deepEquals((Object[]) obj2, (Object[]) zzamg.zzbIu);
        }
    }

    public int hashCode() {
        try {
            return Arrays.hashCode(toByteArray()) + 527;
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    /* access modifiers changed from: package-private */
    public void writeTo(zzamc zzamc) throws IOException {
        Object obj = this.zzbIu;
        if (obj != null) {
            this.zzcag.zza(obj, zzamc);
            return;
        }
        for (zzaml writeTo : this.zzcah) {
            writeTo.writeTo(zzamc);
        }
    }

    /* renamed from: zzWW */
    public final zzamg clone() {
        Object clone;
        zzamg zzamg = new zzamg();
        try {
            zzamg.zzcag = this.zzcag;
            if (this.zzcah == null) {
                zzamg.zzcah = null;
            } else {
                zzamg.zzcah.addAll(this.zzcah);
            }
            if (this.zzbIu != null) {
                if (this.zzbIu instanceof zzamj) {
                    clone = (zzamj) ((zzamj) this.zzbIu).clone();
                } else if (this.zzbIu instanceof byte[]) {
                    clone = ((byte[]) this.zzbIu).clone();
                } else {
                    int i = 0;
                    if (this.zzbIu instanceof byte[][]) {
                        byte[][] bArr = (byte[][]) this.zzbIu;
                        byte[][] bArr2 = new byte[bArr.length][];
                        zzamg.zzbIu = bArr2;
                        while (i < bArr.length) {
                            bArr2[i] = (byte[]) bArr[i].clone();
                            i++;
                        }
                    } else if (this.zzbIu instanceof boolean[]) {
                        clone = ((boolean[]) this.zzbIu).clone();
                    } else if (this.zzbIu instanceof int[]) {
                        clone = ((int[]) this.zzbIu).clone();
                    } else if (this.zzbIu instanceof long[]) {
                        clone = ((long[]) this.zzbIu).clone();
                    } else if (this.zzbIu instanceof float[]) {
                        clone = ((float[]) this.zzbIu).clone();
                    } else if (this.zzbIu instanceof double[]) {
                        clone = ((double[]) this.zzbIu).clone();
                    } else if (this.zzbIu instanceof zzamj[]) {
                        zzamj[] zzamjArr = (zzamj[]) this.zzbIu;
                        zzamj[] zzamjArr2 = new zzamj[zzamjArr.length];
                        zzamg.zzbIu = zzamjArr2;
                        while (i < zzamjArr.length) {
                            zzamjArr2[i] = (zzamj) zzamjArr[i].clone();
                            i++;
                        }
                    }
                }
                zzamg.zzbIu = clone;
            }
            return zzamg;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    /* access modifiers changed from: package-private */
    public <T> T zza(zzame<?, T> zzame) {
        if (this.zzbIu == null) {
            this.zzcag = zzame;
            this.zzbIu = zzame.zzV(this.zzcah);
            this.zzcah = null;
        } else if (!this.zzcag.equals(zzame)) {
            throw new IllegalStateException("Tried to getExtension with a different Extension.");
        }
        return this.zzbIu;
    }

    /* access modifiers changed from: package-private */
    public <T> void zza(zzame<?, T> zzame, T t) {
        this.zzcag = zzame;
        this.zzbIu = t;
        this.zzcah = null;
    }

    /* access modifiers changed from: package-private */
    public void zza(zzaml zzaml) {
        this.zzcah.add(zzaml);
    }

    /* access modifiers changed from: package-private */
    public int zzy() {
        Object obj = this.zzbIu;
        if (obj != null) {
            return this.zzcag.zzaP(obj);
        }
        int i = 0;
        for (zzaml zzy : this.zzcah) {
            i += zzy.zzy();
        }
        return i;
    }
}
