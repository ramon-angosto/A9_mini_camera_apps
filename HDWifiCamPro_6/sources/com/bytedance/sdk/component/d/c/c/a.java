package com.bytedance.sdk.component.d.c.c;

import android.graphics.BitmapFactory;

/* compiled from: FileUtil */
public class a {
    public static boolean a(byte[] bArr) {
        if (bArr == null) {
            return false;
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
        if (options.outWidth > 0) {
            return true;
        }
        return false;
    }

    public static boolean b(byte[] bArr) {
        return bArr != null && bArr.length >= 3 && bArr[0] == 71 && bArr[1] == 73 && bArr[2] == 70;
    }
}
