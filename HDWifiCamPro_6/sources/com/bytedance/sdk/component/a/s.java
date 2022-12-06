package com.bytedance.sdk.component.a;

/* compiled from: JsBridgeException */
class s extends Exception {
    int a;

    s(int i) {
        this.a = i;
    }

    s(int i, String str) {
        super(str);
        this.a = i;
    }
}
