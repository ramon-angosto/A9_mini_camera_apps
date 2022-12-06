package com.mbridge.msdk.mbbanner.common.b;

import android.graphics.Bitmap;
import com.mbridge.msdk.foundation.same.c.c;
import com.mbridge.msdk.mbbanner.common.c.b;

/* compiled from: DownloadImageListener */
public class f implements c {
    private static final String a = f.class.getSimpleName();
    private b b;
    private String c;

    public f(b bVar, String str) {
        if (bVar != null) {
            this.b = bVar;
        }
        this.c = str;
    }

    public void onSuccessLoad(Bitmap bitmap, String str) {
        this.b.a(this.c, 1, str, true);
    }

    public void onFailedLoad(String str, String str2) {
        this.b.a(this.c, 1, str2, false);
    }
}
