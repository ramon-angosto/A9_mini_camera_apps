package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzgra;
import com.google.android.gms.internal.ads.zzgre;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public abstract class zzgre<MessageType extends zzgre<MessageType, BuilderType>, BuilderType extends zzgra<MessageType, BuilderType>> extends zzgpf<MessageType, BuilderType> {
    private static final Map zzb = new ConcurrentHashMap();
    protected zzgtz zzc = zzgtz.zzc();
    protected int zzd = -1;

    private static zzgre zza(zzgre zzgre) throws zzgrq {
        if (zzgre == null || zzgre.zzaS()) {
            return zzgre;
        }
        zzgrq zza = new zzgtx(zzgre).zza();
        zza.zzh(zzgre);
        throw zza;
    }

    static zzgre zzaB(Class cls) {
        zzgre zzgre = (zzgre) zzb.get(cls);
        if (zzgre == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                zzgre = (zzgre) zzb.get(cls);
            } catch (ClassNotFoundException e) {
                throw new IllegalStateException("Class initialization cannot fail.", e);
            }
        }
        if (zzgre == null) {
            zzgre = (zzgre) ((zzgre) zzgui.zzg(cls)).zzb(6, (Object) null, (Object) null);
            if (zzgre != null) {
                zzb.put(cls, zzgre);
            } else {
                throw new IllegalStateException();
            }
        }
        return zzgre;
    }

    protected static zzgre zzaC(zzgre zzgre, zzgpw zzgpw) throws zzgrq {
        zzgqq zza = zzgqq.zza();
        zzgqe zzl = zzgpw.zzl();
        zzgre zzgre2 = (zzgre) zzgre.zzb(4, (Object) null, (Object) null);
        try {
            zzgth zzb2 = zzgsw.zza().zzb(zzgre2.getClass());
            zzb2.zzh(zzgre2, zzgqf.zzq(zzl), zza);
            zzb2.zzf(zzgre2);
            try {
                zzl.zzz(0);
                zza(zzgre2);
                zza(zzgre2);
                return zzgre2;
            } catch (zzgrq e) {
                e.zzh(zzgre2);
                throw e;
            }
        } catch (zzgrq e2) {
            e = e2;
            if (e.zzl()) {
                e = new zzgrq((IOException) e);
            }
            e.zzh(zzgre2);
            throw e;
        } catch (zzgtx e3) {
            zzgrq zza2 = e3.zza();
            zza2.zzh(zzgre2);
            throw zza2;
        } catch (IOException e4) {
            if (e4.getCause() instanceof zzgrq) {
                throw ((zzgrq) e4.getCause());
            }
            zzgrq zzgrq = new zzgrq(e4);
            zzgrq.zzh(zzgre2);
            throw zzgrq;
        } catch (RuntimeException e5) {
            if (e5.getCause() instanceof zzgrq) {
                throw ((zzgrq) e5.getCause());
            }
            throw e5;
        }
    }

    protected static zzgre zzaD(zzgre zzgre, byte[] bArr) throws zzgrq {
        zzgre zzc2 = zzc(zzgre, bArr, 0, bArr.length, zzgqq.zza());
        zza(zzc2);
        return zzc2;
    }

    protected static zzgre zzaE(zzgre zzgre, zzgpw zzgpw, zzgqq zzgqq) throws zzgrq {
        zzgqe zzl = zzgpw.zzl();
        zzgre zzgre2 = (zzgre) zzgre.zzb(4, (Object) null, (Object) null);
        try {
            zzgth zzb2 = zzgsw.zza().zzb(zzgre2.getClass());
            zzb2.zzh(zzgre2, zzgqf.zzq(zzl), zzgqq);
            zzb2.zzf(zzgre2);
            try {
                zzl.zzz(0);
                zza(zzgre2);
                return zzgre2;
            } catch (zzgrq e) {
                e.zzh(zzgre2);
                throw e;
            }
        } catch (zzgrq e2) {
            e = e2;
            if (e.zzl()) {
                e = new zzgrq((IOException) e);
            }
            e.zzh(zzgre2);
            throw e;
        } catch (zzgtx e3) {
            zzgrq zza = e3.zza();
            zza.zzh(zzgre2);
            throw zza;
        } catch (IOException e4) {
            if (e4.getCause() instanceof zzgrq) {
                throw ((zzgrq) e4.getCause());
            }
            zzgrq zzgrq = new zzgrq(e4);
            zzgrq.zzh(zzgre2);
            throw zzgrq;
        } catch (RuntimeException e5) {
            if (e5.getCause() instanceof zzgrq) {
                throw ((zzgrq) e5.getCause());
            }
            throw e5;
        }
    }

    protected static zzgre zzaF(zzgre zzgre, InputStream inputStream, zzgqq zzgqq) throws zzgrq {
        zzgqe zzH = zzgqe.zzH(inputStream, 4096);
        zzgre zzgre2 = (zzgre) zzgre.zzb(4, (Object) null, (Object) null);
        try {
            zzgth zzb2 = zzgsw.zza().zzb(zzgre2.getClass());
            zzb2.zzh(zzgre2, zzgqf.zzq(zzH), zzgqq);
            zzb2.zzf(zzgre2);
            zza(zzgre2);
            return zzgre2;
        } catch (zzgrq e) {
            e = e;
            if (e.zzl()) {
                e = new zzgrq((IOException) e);
            }
            e.zzh(zzgre2);
            throw e;
        } catch (zzgtx e2) {
            zzgrq zza = e2.zza();
            zza.zzh(zzgre2);
            throw zza;
        } catch (IOException e3) {
            if (e3.getCause() instanceof zzgrq) {
                throw ((zzgrq) e3.getCause());
            }
            zzgrq zzgrq = new zzgrq(e3);
            zzgrq.zzh(zzgre2);
            throw zzgrq;
        } catch (RuntimeException e4) {
            if (e4.getCause() instanceof zzgrq) {
                throw ((zzgrq) e4.getCause());
            }
            throw e4;
        }
    }

    protected static zzgre zzaG(zzgre zzgre, byte[] bArr, zzgqq zzgqq) throws zzgrq {
        zzgre zzc2 = zzc(zzgre, bArr, 0, bArr.length, zzgqq);
        zza(zzc2);
        return zzc2;
    }

    protected static zzgrj zzaH() {
        return zzgrf.zzf();
    }

    protected static zzgrj zzaI(zzgrj zzgrj) {
        int size = zzgrj.size();
        return zzgrj.zzg(size == 0 ? 10 : size + size);
    }

    protected static zzgrm zzaJ() {
        return zzgsd.zzf();
    }

    protected static zzgrn zzaK() {
        return zzgsx.zze();
    }

    protected static zzgrn zzaL(zzgrn zzgrn) {
        int size = zzgrn.size();
        return zzgrn.zzd(size == 0 ? 10 : size + size);
    }

    static Object zzaO(Method method, Object obj, Object... objArr) {
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

    protected static Object zzaP(zzgso zzgso, String str, Object[] objArr) {
        return new zzgsy(zzgso, str, objArr);
    }

    protected static void zzaQ(Class cls, zzgre zzgre) {
        zzb.put(cls, zzgre);
    }

    private static zzgre zzc(zzgre zzgre, byte[] bArr, int i, int i2, zzgqq zzgqq) throws zzgrq {
        zzgre zzgre2 = (zzgre) zzgre.zzb(4, (Object) null, (Object) null);
        try {
            zzgth zzb2 = zzgsw.zza().zzb(zzgre2.getClass());
            zzb2.zzi(zzgre2, bArr, 0, i2, new zzgpi(zzgqq));
            zzb2.zzf(zzgre2);
            if (zzgre2.zza == 0) {
                return zzgre2;
            }
            throw new RuntimeException();
        } catch (zzgrq e) {
            e = e;
            if (e.zzl()) {
                e = new zzgrq((IOException) e);
            }
            e.zzh(zzgre2);
            throw e;
        } catch (zzgtx e2) {
            zzgrq zza = e2.zza();
            zza.zzh(zzgre2);
            throw zza;
        } catch (IOException e3) {
            if (e3.getCause() instanceof zzgrq) {
                throw ((zzgrq) e3.getCause());
            }
            zzgrq zzgrq = new zzgrq(e3);
            zzgrq.zzh(zzgre2);
            throw zzgrq;
        } catch (IndexOutOfBoundsException unused) {
            zzgrq zzj = zzgrq.zzj();
            zzj.zzh(zzgre2);
            throw zzj;
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            return zzgsw.zza().zzb(getClass()).zzj(this, (zzgre) obj);
        }
        return false;
    }

    public final int hashCode() {
        int i = this.zza;
        if (i != 0) {
            return i;
        }
        int zzb2 = zzgsw.zza().zzb(getClass()).zzb(this);
        this.zza = zzb2;
        return zzb2;
    }

    public final String toString() {
        return zzgsq.zza(this, super.toString());
    }

    public final zzgra zzaA() {
        zzgra zzgra = (zzgra) zzb(5, (Object) null, (Object) null);
        zzgra.zzak(this);
        return zzgra;
    }

    public final /* synthetic */ zzgsn zzaM() {
        return (zzgra) zzb(5, (Object) null, (Object) null);
    }

    public final /* synthetic */ zzgsn zzaN() {
        zzgra zzgra = (zzgra) zzb(5, (Object) null, (Object) null);
        zzgra.zzak(this);
        return zzgra;
    }

    public final void zzaR(zzgql zzgql) throws IOException {
        zzgsw.zza().zzb(getClass()).zzn(this, zzgqm.zza(zzgql));
    }

    public final boolean zzaS() {
        boolean booleanValue = Boolean.TRUE.booleanValue();
        byte byteValue = ((Byte) zzb(1, (Object) null, (Object) null)).byteValue();
        if (byteValue == 1) {
            return true;
        }
        if (byteValue == 0) {
            return false;
        }
        boolean zzk = zzgsw.zza().zzb(getClass()).zzk(this);
        if (!booleanValue) {
            return zzk;
        }
        zzb(2, true != zzk ? null : this, (Object) null);
        return zzk;
    }

    /* access modifiers changed from: package-private */
    public final int zzas() {
        return this.zzd;
    }

    /* access modifiers changed from: package-private */
    public final void zzav(int i) {
        this.zzd = i;
    }

    public final int zzay() {
        int i = this.zzd;
        if (i != -1) {
            return i;
        }
        int zza = zzgsw.zza().zzb(getClass()).zza(this);
        this.zzd = zza;
        return zza;
    }

    /* access modifiers changed from: protected */
    public final zzgra zzaz() {
        return (zzgra) zzb(5, (Object) null, (Object) null);
    }

    /* access modifiers changed from: protected */
    public abstract Object zzb(int i, Object obj, Object obj2);

    public final /* synthetic */ zzgso zzbh() {
        return (zzgre) zzb(6, (Object) null, (Object) null);
    }
}
