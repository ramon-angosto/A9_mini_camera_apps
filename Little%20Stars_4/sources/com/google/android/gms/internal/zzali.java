package com.google.android.gms.internal;

import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import java.util.ArrayList;

public final class zzali<E> extends zzakr<Object> {
    public static final zzaks zzbXD = new zzaks() {
        public <T> zzakr<T> zza(zzajz zzajz, zzalv<T> zzalv) {
            Type zzWm = zzalv.zzWm();
            if (!(zzWm instanceof GenericArrayType) && (!(zzWm instanceof Class) || !((Class) zzWm).isArray())) {
                return null;
            }
            Type zzh = zzaky.zzh(zzWm);
            return new zzali(zzajz, zzajz.zza(zzalv.zzl(zzh)), zzaky.zzf(zzh));
        }
    };
    private final Class<E> zzbXE;
    private final zzakr<E> zzbXF;

    public zzali(zzajz zzajz, zzakr<E> zzakr, Class<E> cls) {
        this.zzbXF = new zzalt(zzajz, zzakr, cls);
        this.zzbXE = cls;
    }

    public void zza(zzaly zzaly, Object obj) throws IOException {
        if (obj == null) {
            zzaly.zzWk();
            return;
        }
        zzaly.zzWg();
        int length = Array.getLength(obj);
        for (int i = 0; i < length; i++) {
            this.zzbXF.zza(zzaly, Array.get(obj, i));
        }
        zzaly.zzWh();
    }

    public Object zzb(zzalw zzalw) throws IOException {
        if (zzalw.zzWa() == zzalx.NULL) {
            zzalw.nextNull();
            return null;
        }
        ArrayList arrayList = new ArrayList();
        zzalw.beginArray();
        while (zzalw.hasNext()) {
            arrayList.add(this.zzbXF.zzb(zzalw));
        }
        zzalw.endArray();
        Object newInstance = Array.newInstance(this.zzbXE, arrayList.size());
        for (int i = 0; i < arrayList.size(); i++) {
            Array.set(newInstance, i, arrayList.get(i));
        }
        return newInstance;
    }
}
