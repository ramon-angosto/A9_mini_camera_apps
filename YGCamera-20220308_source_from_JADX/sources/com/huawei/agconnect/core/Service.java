package com.huawei.agconnect.core;

import com.huawei.agconnect.annotation.Singleton;
import java.lang.reflect.Modifier;

public class Service {

    /* renamed from: a */
    private Class<?> f114a;

    /* renamed from: b */
    private Class<?> f115b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public boolean f116c;

    public static class Builder {

        /* renamed from: a */
        Class<?> f117a;

        /* renamed from: b */
        Class<?> f118b;

        /* renamed from: c */
        private boolean f119c;

        private Builder(Class<?> cls, Class<?> cls2) {
            if (cls == null) {
                throw new IllegalArgumentException("the interface parameter cannot be NULL");
            } else if (cls2 == null) {
                throw new IllegalArgumentException("the clazz parameter cannot be NULL");
            } else if (cls2.isInterface() || !Modifier.isPublic(cls2.getModifiers())) {
                throw new IllegalArgumentException("the clazz parameter must be interface type and public");
            } else {
                this.f117a = cls;
                this.f118b = cls2;
                this.f119c = cls2.isAnnotationPresent(Singleton.class);
            }
        }

        public Service build() {
            Service service = new Service(this.f117a, this.f118b);
            boolean unused = service.f116c = this.f119c;
            return service;
        }

        public Builder isSingleton(boolean z) {
            this.f119c = z;
            return this;
        }
    }

    private Service(Class<?> cls, Class<?> cls2) {
        this.f114a = cls;
        this.f115b = cls2;
    }

    public static Builder builder(Class<?> cls) {
        return new Builder(cls, cls);
    }

    public static Builder builder(Class<?> cls, Class<?> cls2) {
        return new Builder(cls, cls2);
    }

    public Class<?> getInterface() {
        return this.f114a;
    }

    public Class<?> getType() {
        return this.f115b;
    }

    public boolean isSingleton() {
        return this.f116c;
    }
}
