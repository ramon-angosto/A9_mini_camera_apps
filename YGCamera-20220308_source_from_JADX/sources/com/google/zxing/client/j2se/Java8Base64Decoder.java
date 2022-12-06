package com.google.zxing.client.j2se;

import java.lang.reflect.InvocationTargetException;

final class Java8Base64Decoder extends Base64Decoder {
    Java8Base64Decoder() {
    }

    /* access modifiers changed from: package-private */
    public byte[] decode(String str) {
        try {
            Object invoke = Class.forName("java.util.Base64").getMethod("getDecoder", new Class[0]).invoke((Object) null, new Object[0]);
            return (byte[]) Class.forName("java.util.Base64$Decoder").getMethod("decode", new Class[]{String.class}).invoke(invoke, new Object[]{str});
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException e) {
            throw new IllegalStateException(e);
        } catch (InvocationTargetException e2) {
            throw new IllegalStateException(e2.getCause());
        }
    }
}
