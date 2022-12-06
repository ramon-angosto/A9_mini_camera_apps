package com.mbridge.msdk.out;

import android.graphics.drawable.Drawable;

public interface OnImageLoadListener {
    void loadError(String str);

    void loadSuccess(Drawable drawable, int i);
}
