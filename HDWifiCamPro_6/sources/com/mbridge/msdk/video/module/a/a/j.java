package com.mbridge.msdk.video.module.a.a;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.tools.p;

/* compiled from: RoundedImageLoaderListener */
public final class j extends e {
    private int a;

    public j(ImageView imageView, int i) {
        super(imageView);
        this.a = i;
    }

    public final void onSuccessLoad(Bitmap bitmap, String str) {
        Bitmap a2;
        if (bitmap != null) {
            try {
                if (this.b != null && !bitmap.isRecycled() && (a2 = p.a(bitmap, 1, this.a)) != null) {
                    this.b.setImageBitmap(a2);
                }
            } catch (Throwable th) {
                if (MBridgeConstans.DEBUG) {
                    th.printStackTrace();
                }
            }
        }
    }
}
