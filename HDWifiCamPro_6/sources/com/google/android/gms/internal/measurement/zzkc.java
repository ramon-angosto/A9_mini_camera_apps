package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzjy;
import com.google.android.gms.internal.measurement.zzkc;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: com.google.android.gms:play-services-measurement-base@@20.1.2 */
public abstract class zzkc<MessageType extends zzkc<MessageType, BuilderType>, BuilderType extends zzjy<MessageType, BuilderType>> extends zzil<MessageType, BuilderType> {
    private static final Map zza = new ConcurrentHashMap();
    protected zzmm zzc = zzmm.zzc();
    protected int zzd = -1;

    static zzkc zzbC(Class cls) {
        zzkc zzkc = (zzkc) zza.get(cls);
        if (zzkc == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                zzkc = (zzkc) zza.get(cls);
            } catch (ClassNotFoundException e) {
                throw new IllegalStateException("Class initialization cannot fail.", e);
            }
        }
        if (zzkc == null) {
            zzkc = (zzkc) ((zzkc) zzmv.zze(cls)).zzl(6, (Object) null, (Object) null);
            if (zzkc != null) {
                zza.put(cls, zzkc);
            } else {
                throw new IllegalStateException();
            }
        }
        return zzkc;
    }

    protected static zzkh zzbD() {
        return zzkd.zzf();
    }

    protected static zzki zzbE() {
        return zzky.zzf();
    }

    protected static zzki zzbF(zzki zzki) {
        int size = zzki.size();
        return zzki.zze(size == 0 ? 10 : size + size);
    }

    protected static zzkj zzbG() {
        return zzls.zze();
    }

    protected static zzkj zzbH(zzkj zzkj) {
        int size = zzkj.size();
        return zzkj.zzd(size == 0 ? 10 : size + size);
    }

    static Object zzbK(Method method, Object obj, Object... objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", e);
        } catch (InvocationTargetException e2) {
            Throwable cause = e2.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            } else if (cause instanceof Error) {
                throw ((Error) cause);
            } else {
                throw new RuntimeException("Unexpected exception thrown by generated accessor method.", cause);
            }
        }
    }

    protected static Object zzbL(zzlj zzlj, String str, Object[] objArr) {
        return new zzlt(zzlj, str, objArr);
    }

    protected static void zzbM(Class cls, zzkc zzkc) {
        zza.put(cls, zzkc);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            return zzlr.zza().zzb(getClass()).zzj(this, (zzkc) obj);
        }
        return false;
    }

    public final int hashCode() {
        int i = this.zzb;
        if (i != 0) {
            return i;
        }
        int zzb = zzlr.zza().zzb(getClass()).zzb(this);
        this.zzb = zzb;
        return zzb;
    }

    public final String toString() {
        return zzll.zza(this, super.toString());
    }

    /* access modifiers changed from: protected */
    public final zzjy zzbA() {
        return (zzjy) zzl(5, (Object) null, (Object) null);
    }

    public final zzjy zzbB() {
        zzjy zzjy = (zzjy) zzl(5, (Object) null, (Object) null);
        zzjy.zzaC(this);
        return zzjy;
    }

    public final /* synthetic */ zzli zzbI() {
        return (zzjy) zzl(5, (Object) null, (Object) null);
    }

    public final /* synthetic */ zzli zzbJ() {
        zzjy zzjy = (zzjy) zzl(5, (Object) null, (Object) null);
        zzjy.zzaC(this);
        return zzjy;
    }

    public final void zzbN(zzjj zzjj) throws IOException {
        zzlr.zza().zzb(getClass()).zzi(this, zzjk.zza(zzjj));
    }

    public final /* synthetic */ zzlj zzbR() {
        return (zzkc) zzl(6, (Object) null, (Object) null);
    }

    /* access modifiers changed from: package-private */
    public final int zzbu() {
        return this.zzd;
    }

    /* access modifiers changed from: package-private */
    public final void zzbx(int i) {
        this.zzd = i;
    }

    public final int zzbz() {
        int i = this.zzd;
        if (i != -1) {
            return i;
        }
        int zza2 = zzlr.zza().zzb(getClass()).zza(this);
        this.zzd = zza2;
        return zza2;
    }

    /* access modifiers changed from: protected */
    public abstract Object zzl(int i, Object obj, Object obj2);
}
