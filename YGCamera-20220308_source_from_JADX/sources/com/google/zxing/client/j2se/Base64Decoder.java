package com.google.zxing.client.j2se;

abstract class Base64Decoder {
    private static final Base64Decoder INSTANCE;

    /* access modifiers changed from: package-private */
    public abstract byte[] decode(String str);

    Base64Decoder() {
    }

    static {
        Base64Decoder base64Decoder;
        try {
            Class.forName("java.util.Base64");
            base64Decoder = new Java8Base64Decoder();
        } catch (ClassNotFoundException unused) {
            base64Decoder = new JAXBBase64Decoder();
        }
        INSTANCE = base64Decoder;
    }

    static Base64Decoder getInstance() {
        return INSTANCE;
    }
}
