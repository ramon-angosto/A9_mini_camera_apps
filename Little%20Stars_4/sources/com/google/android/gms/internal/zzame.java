package com.google.android.gms.internal;

import com.google.android.gms.internal.zzamd;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class zzame<M extends zzamd<M>, T> {
    public final int tag;
    protected final int type;
    protected final Class<T> zzbSs;
    protected final boolean zzcab;

    private zzame(int i, Class<T> cls, int i2, boolean z) {
        this.type = i;
        this.zzbSs = cls;
        this.tag = i2;
        this.zzcab = z;
    }

    private T zzW(List<zzaml> list) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            zzaml zzaml = list.get(i);
            if (zzaml.zzcak.length != 0) {
                zza(zzaml, (List<Object>) arrayList);
            }
        }
        int size = arrayList.size();
        if (size == 0) {
            return null;
        }
        Class<T> cls = this.zzbSs;
        T cast = cls.cast(Array.newInstance(cls.getComponentType(), size));
        for (int i2 = 0; i2 < size; i2++) {
            Array.set(cast, i2, arrayList.get(i2));
        }
        return cast;
    }

    private T zzX(List<zzaml> list) {
        if (list.isEmpty()) {
            return null;
        }
        return this.zzbSs.cast(zzV(zzamb.zzN(list.get(list.size() - 1).zzcak)));
    }

    public static <M extends zzamd<M>, T extends zzamj> zzame<M, T> zza(int i, Class<T> cls, long j) {
        return new zzame<>(i, cls, (int) j, false);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzame)) {
            return false;
        }
        zzame zzame = (zzame) obj;
        return this.type == zzame.type && this.zzbSs == zzame.zzbSs && this.tag == zzame.tag && this.zzcab == zzame.zzcab;
    }

    public int hashCode() {
        return ((((((this.type + 1147) * 31) + this.zzbSs.hashCode()) * 31) + this.tag) * 31) + (this.zzcab ? 1 : 0);
    }

    /* access modifiers changed from: protected */
    public Object zzV(zzamb zzamb) {
        Class componentType = this.zzcab ? this.zzbSs.getComponentType() : this.zzbSs;
        try {
            int i = this.type;
            if (i == 10) {
                zzamj zzamj = (zzamj) componentType.newInstance();
                zzamb.zza(zzamj, zzamm.zzoo(this.tag));
                return zzamj;
            } else if (i == 11) {
                zzamj zzamj2 = (zzamj) componentType.newInstance();
                zzamb.zza(zzamj2);
                return zzamj2;
            } else {
                int i2 = this.type;
                StringBuilder sb = new StringBuilder(24);
                sb.append("Unknown type ");
                sb.append(i2);
                throw new IllegalArgumentException(sb.toString());
            }
        } catch (InstantiationException e) {
            String valueOf = String.valueOf(componentType);
            StringBuilder sb2 = new StringBuilder(String.valueOf(valueOf).length() + 33);
            sb2.append("Error creating instance of class ");
            sb2.append(valueOf);
            throw new IllegalArgumentException(sb2.toString(), e);
        } catch (IllegalAccessException e2) {
            String valueOf2 = String.valueOf(componentType);
            StringBuilder sb3 = new StringBuilder(String.valueOf(valueOf2).length() + 33);
            sb3.append("Error creating instance of class ");
            sb3.append(valueOf2);
            throw new IllegalArgumentException(sb3.toString(), e2);
        } catch (IOException e3) {
            throw new IllegalArgumentException("Error reading extension field", e3);
        }
    }

    /* access modifiers changed from: package-private */
    public final T zzV(List<zzaml> list) {
        if (list == null) {
            return null;
        }
        return this.zzcab ? zzW(list) : zzX(list);
    }

    /* access modifiers changed from: protected */
    public void zza(zzaml zzaml, List<Object> list) {
        list.add(zzV(zzamb.zzN(zzaml.zzcak)));
    }

    /* access modifiers changed from: package-private */
    public void zza(Object obj, zzamc zzamc) throws IOException {
        if (this.zzcab) {
            zzc(obj, zzamc);
        } else {
            zzb(obj, zzamc);
        }
    }

    /* access modifiers changed from: package-private */
    public int zzaP(Object obj) {
        return this.zzcab ? zzaQ(obj) : zzaR(obj);
    }

    /* access modifiers changed from: protected */
    public int zzaQ(Object obj) {
        int length = Array.getLength(obj);
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            if (Array.get(obj, i2) != null) {
                i += zzaR(Array.get(obj, i2));
            }
        }
        return i;
    }

    /* access modifiers changed from: protected */
    public int zzaR(Object obj) {
        int zzoo = zzamm.zzoo(this.tag);
        int i = this.type;
        if (i == 10) {
            return zzamc.zzb(zzoo, (zzamj) obj);
        }
        if (i == 11) {
            return zzamc.zzc(zzoo, (zzamj) obj);
        }
        StringBuilder sb = new StringBuilder(24);
        sb.append("Unknown type ");
        sb.append(i);
        throw new IllegalArgumentException(sb.toString());
    }

    /* access modifiers changed from: protected */
    public void zzb(Object obj, zzamc zzamc) {
        try {
            zzamc.zzog(this.tag);
            int i = this.type;
            if (i == 10) {
                int zzoo = zzamm.zzoo(this.tag);
                zzamc.zzb((zzamj) obj);
                zzamc.zzI(zzoo, 4);
            } else if (i == 11) {
                zzamc.zzc((zzamj) obj);
            } else {
                int i2 = this.type;
                StringBuilder sb = new StringBuilder(24);
                sb.append("Unknown type ");
                sb.append(i2);
                throw new IllegalArgumentException(sb.toString());
            }
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    /* access modifiers changed from: protected */
    public void zzc(Object obj, zzamc zzamc) {
        int length = Array.getLength(obj);
        for (int i = 0; i < length; i++) {
            Object obj2 = Array.get(obj, i);
            if (obj2 != null) {
                zzb(obj2, zzamc);
            }
        }
    }
}
