package com.vungle.warren.utility;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;
import java.util.List;

class SafeObjectInputStream extends ObjectInputStream {
    private final List<Class<?>> allowed;

    SafeObjectInputStream(InputStream inputStream, List<Class<?>> list) throws IOException {
        super(inputStream);
        this.allowed = list;
    }

    /* access modifiers changed from: protected */
    public Class<?> resolveClass(ObjectStreamClass objectStreamClass) throws ClassNotFoundException, IOException {
        Class<?> resolveClass = super.resolveClass(objectStreamClass);
        if (this.allowed == null || Number.class.isAssignableFrom(resolveClass) || String.class.equals(resolveClass) || Boolean.class.equals(resolveClass) || resolveClass.isArray() || this.allowed.contains(resolveClass)) {
            return resolveClass;
        }
        throw new IOException("Deserialization is not allowed for " + objectStreamClass.getName());
    }
}
