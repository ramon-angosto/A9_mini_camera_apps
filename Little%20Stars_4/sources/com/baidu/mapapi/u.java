package com.baidu.mapapi;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class u {
    private Bitmap a;

    public u() {
    }

    public u(byte[] bArr) {
        try {
            this.a = BitmapFactory.decodeByteArray(bArr, 0, bArr.length);
        } catch (OutOfMemoryError e) {
            e.printStackTrace();
        }
    }

    public Bitmap a() {
        return this.a;
    }
}
