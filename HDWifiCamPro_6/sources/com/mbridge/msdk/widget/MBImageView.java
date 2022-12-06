package com.mbridge.msdk.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.mbridge.msdk.foundation.same.c.b;
import com.mbridge.msdk.foundation.same.c.c;

public class MBImageView extends ImageView {
    private Bitmap a = null;
    private String b;

    public MBImageView(Context context) {
        super(context);
    }

    public MBImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public MBImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void setImageUrl(String str) {
        this.b = str;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        Bitmap bitmap = this.a;
        if (bitmap == null || !bitmap.isRecycled()) {
            super.onDraw(canvas);
        } else if (getContext() != null) {
            b.a(getContext()).a(this.b, (c) new c() {
                public final void onFailedLoad(String str, String str2) {
                }

                public final void onSuccessLoad(Bitmap bitmap, String str) {
                    MBImageView.this.setImageBitmap(bitmap);
                }
            });
        }
    }

    public void setImageBitmap(Bitmap bitmap) {
        this.a = bitmap;
        if (bitmap == null || !bitmap.isRecycled()) {
            super.setImageBitmap(bitmap);
            return;
        }
        this.a = null;
        super.setImageBitmap((Bitmap) null);
    }
}
