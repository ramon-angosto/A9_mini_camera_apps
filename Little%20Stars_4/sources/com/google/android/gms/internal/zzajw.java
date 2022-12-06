package com.google.android.gms.internal;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public final class zzajw {
    private final Field zzbVQ;

    public zzajw(Field field) {
        zzakx.zzz(field);
        this.zzbVQ = field;
    }

    public <T extends Annotation> T getAnnotation(Class<T> cls) {
        return this.zzbVQ.getAnnotation(cls);
    }
}
