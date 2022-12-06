package com.google.android.gms.internal;

import java.io.IOException;
import java.util.ArrayList;

public final class zzalp extends zzakr<Object> {
    public static final zzaks zzbXD = new zzaks() {
        public <T> zzakr<T> zza(zzajz zzajz, zzalv<T> zzalv) {
            if (zzalv.zzWl() == Object.class) {
                return new zzalp(zzajz);
            }
            return null;
        }
    };
    private final zzajz zzbWz;

    private zzalp(zzajz zzajz) {
        this.zzbWz = zzajz;
    }

    public void zza(zzaly zzaly, Object obj) throws IOException {
        if (obj == null) {
            zzaly.zzWk();
            return;
        }
        zzakr<?> zzk = this.zzbWz.zzk(obj.getClass());
        if (zzk instanceof zzalp) {
            zzaly.zzWi();
            zzaly.zzWj();
            return;
        }
        zzk.zza(zzaly, obj);
    }

    public Object zzb(zzalw zzalw) throws IOException {
        switch (zzalw.zzWa()) {
            case BEGIN_ARRAY:
                ArrayList arrayList = new ArrayList();
                zzalw.beginArray();
                while (zzalw.hasNext()) {
                    arrayList.add(zzb(zzalw));
                }
                zzalw.endArray();
                return arrayList;
            case BEGIN_OBJECT:
                zzald zzald = new zzald();
                zzalw.beginObject();
                while (zzalw.hasNext()) {
                    zzald.put(zzalw.nextName(), zzb(zzalw));
                }
                zzalw.endObject();
                return zzald;
            case STRING:
                return zzalw.nextString();
            case NUMBER:
                return Double.valueOf(zzalw.nextDouble());
            case BOOLEAN:
                return Boolean.valueOf(zzalw.nextBoolean());
            case NULL:
                zzalw.nextNull();
                return null;
            default:
                throw new IllegalStateException();
        }
    }
}
