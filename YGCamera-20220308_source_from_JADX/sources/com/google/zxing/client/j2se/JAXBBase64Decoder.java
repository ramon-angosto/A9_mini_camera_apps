package com.google.zxing.client.j2se;

import java.lang.reflect.InvocationTargetException;

final class JAXBBase64Decoder extends Base64Decoder {
    JAXBBase64Decoder() {
    }

    /* access modifiers changed from: package-private */
    public byte[] decode(String str) {
        try {
            return (byte[]) Class.forName("javax.xml.bind.DatatypeConverter").getMethod("parseBase64Binary", new Class[]{String.class}).invoke((Object) null, new Object[]{str});
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            throw new IllegalStateException(e);
        }
    }
}
