package com.google.android.gms.internal;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class zzalq implements zzaks {
    private final zzakz zzbWa;
    private final zzala zzbWj;
    private final zzajy zzbWl;

    public static final class zza<T> extends zzakr<T> {
        private final zzale<T> zzbXH;
        private final Map<String, zzb> zzbYa;

        private zza(zzale<T> zzale, Map<String, zzb> map) {
            this.zzbXH = zzale;
            this.zzbYa = map;
        }

        public void zza(zzaly zzaly, T t) throws IOException {
            if (t == null) {
                zzaly.zzWk();
                return;
            }
            zzaly.zzWi();
            try {
                for (zzb next : this.zzbYa.values()) {
                    if (next.zzaO(t)) {
                        zzaly.zziT(next.name);
                        next.zza(zzaly, (Object) t);
                    }
                }
                zzaly.zzWj();
            } catch (IllegalAccessException unused) {
                throw new AssertionError();
            }
        }

        public T zzb(zzalw zzalw) throws IOException {
            if (zzalw.zzWa() == zzalx.NULL) {
                zzalw.nextNull();
                return null;
            }
            T zzVT = this.zzbXH.zzVT();
            try {
                zzalw.beginObject();
                while (zzalw.hasNext()) {
                    zzb zzb = this.zzbYa.get(zzalw.nextName());
                    if (zzb != null) {
                        if (zzb.zzbYc) {
                            zzb.zza(zzalw, (Object) zzVT);
                        }
                    }
                    zzalw.skipValue();
                }
                zzalw.endObject();
                return zzVT;
            } catch (IllegalStateException e) {
                throw new zzako((Throwable) e);
            } catch (IllegalAccessException e2) {
                throw new AssertionError(e2);
            }
        }
    }

    static abstract class zzb {
        final String name;
        final boolean zzbYb;
        final boolean zzbYc;

        protected zzb(String str, boolean z, boolean z2) {
            this.name = str;
            this.zzbYb = z;
            this.zzbYc = z2;
        }

        /* access modifiers changed from: package-private */
        public abstract void zza(zzalw zzalw, Object obj) throws IOException, IllegalAccessException;

        /* access modifiers changed from: package-private */
        public abstract void zza(zzaly zzaly, Object obj) throws IOException, IllegalAccessException;

        /* access modifiers changed from: package-private */
        public abstract boolean zzaO(Object obj) throws IOException, IllegalAccessException;
    }

    public zzalq(zzakz zzakz, zzajy zzajy, zzala zzala) {
        this.zzbWa = zzakz;
        this.zzbWl = zzajy;
        this.zzbWj = zzala;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000a, code lost:
        r3 = com.google.android.gms.internal.zzall.zza(r1.zzbWa, r2, r4, r3);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.google.android.gms.internal.zzakr<?> zza(com.google.android.gms.internal.zzajz r2, java.lang.reflect.Field r3, com.google.android.gms.internal.zzalv<?> r4) {
        /*
            r1 = this;
            java.lang.Class<com.google.android.gms.internal.zzakt> r0 = com.google.android.gms.internal.zzakt.class
            java.lang.annotation.Annotation r3 = r3.getAnnotation(r0)
            com.google.android.gms.internal.zzakt r3 = (com.google.android.gms.internal.zzakt) r3
            if (r3 == 0) goto L_0x0013
            com.google.android.gms.internal.zzakz r0 = r1.zzbWa
            com.google.android.gms.internal.zzakr r3 = com.google.android.gms.internal.zzall.zza(r0, r2, r4, r3)
            if (r3 == 0) goto L_0x0013
            return r3
        L_0x0013:
            com.google.android.gms.internal.zzakr r2 = r2.zza(r4)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzalq.zza(com.google.android.gms.internal.zzajz, java.lang.reflect.Field, com.google.android.gms.internal.zzalv):com.google.android.gms.internal.zzakr");
    }

    private zzb zza(zzajz zzajz, Field field, String str, zzalv<?> zzalv, boolean z, boolean z2) {
        final boolean zzk = zzalf.zzk(zzalv.zzWl());
        final zzajz zzajz2 = zzajz;
        final Field field2 = field;
        final zzalv<?> zzalv2 = zzalv;
        return new zzb(str, z, z2) {
            final zzakr<?> zzbXU = zzalq.this.zza(zzajz2, field2, (zzalv<?>) zzalv2);

            /* access modifiers changed from: package-private */
            public void zza(zzalw zzalw, Object obj) throws IOException, IllegalAccessException {
                Object zzb = this.zzbXU.zzb(zzalw);
                if (zzb != null || !zzk) {
                    field2.set(obj, zzb);
                }
            }

            /* access modifiers changed from: package-private */
            public void zza(zzaly zzaly, Object obj) throws IOException, IllegalAccessException {
                new zzalt(zzajz2, this.zzbXU, zzalv2.zzWm()).zza(zzaly, field2.get(obj));
            }

            public boolean zzaO(Object obj) throws IOException, IllegalAccessException {
                return this.zzbYb && field2.get(obj) != obj;
            }
        };
    }

    static List<String> zza(zzajy zzajy, Field field) {
        zzaku zzaku = (zzaku) field.getAnnotation(zzaku.class);
        LinkedList linkedList = new LinkedList();
        if (zzaku == null) {
            linkedList.add(zzajy.zzb(field));
        } else {
            linkedList.add(zzaku.value());
            for (String add : zzaku.zzVR()) {
                linkedList.add(add);
            }
        }
        return linkedList;
    }

    private Map<String, zzb> zza(zzajz zzajz, zzalv<?> zzalv, Class<?> cls) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (cls.isInterface()) {
            return linkedHashMap;
        }
        Type zzWm = zzalv.zzWm();
        zzalv<?> zzalv2 = zzalv;
        Class<? super Object> cls2 = cls;
        while (cls2 != Object.class) {
            Field[] declaredFields = cls2.getDeclaredFields();
            int length = declaredFields.length;
            boolean z = false;
            int i = 0;
            while (i < length) {
                Field field = declaredFields[i];
                boolean zza2 = zza(field, true);
                boolean zza3 = zza(field, z);
                if (zza2 || zza3) {
                    field.setAccessible(true);
                    Type zza4 = zzaky.zza(zzalv2.zzWm(), (Class<?>) cls2, field.getGenericType());
                    List<String> zzc = zzc(field);
                    zzb zzb2 = null;
                    int i2 = 0;
                    while (i2 < zzc.size()) {
                        String str = zzc.get(i2);
                        boolean z2 = i2 != 0 ? false : zza2;
                        String str2 = str;
                        zzb zzb3 = zzb2;
                        int i3 = i2;
                        List<String> list = zzc;
                        Field field2 = field;
                        zzb2 = zzb3 == null ? (zzb) linkedHashMap.put(str2, zza(zzajz, field, str2, zzalv.zzl(zza4), z2, zza3)) : zzb3;
                        i2 = i3 + 1;
                        zza2 = z2;
                        zzc = list;
                        field = field2;
                    }
                    zzb zzb4 = zzb2;
                    if (zzb4 != null) {
                        String valueOf = String.valueOf(zzWm);
                        String str3 = zzb4.name;
                        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 37 + String.valueOf(str3).length());
                        sb.append(valueOf);
                        sb.append(" declares multiple JSON fields named ");
                        sb.append(str3);
                        throw new IllegalArgumentException(sb.toString());
                    }
                }
                i++;
                z = false;
            }
            zzalv2 = zzalv.zzl(zzaky.zza(zzalv2.zzWm(), (Class<?>) cls2, cls2.getGenericSuperclass()));
            cls2 = zzalv2.zzWl();
        }
        return linkedHashMap;
    }

    static boolean zza(Field field, boolean z, zzala zzala) {
        return !zzala.zza(field.getType(), z) && !zzala.zza(field, z);
    }

    private List<String> zzc(Field field) {
        return zza(this.zzbWl, field);
    }

    public <T> zzakr<T> zza(zzajz zzajz, zzalv<T> zzalv) {
        Class<? super T> zzWl = zzalv.zzWl();
        if (!Object.class.isAssignableFrom(zzWl)) {
            return null;
        }
        return new zza(this.zzbWa.zzb(zzalv), zza(zzajz, (zzalv<?>) zzalv, (Class<?>) zzWl));
    }

    public boolean zza(Field field, boolean z) {
        return zza(field, z, this.zzbWj);
    }
}
