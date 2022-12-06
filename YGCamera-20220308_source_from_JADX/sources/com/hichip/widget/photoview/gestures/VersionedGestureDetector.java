package com.hichip.widget.photoview.gestures;

import android.content.Context;
import android.os.Build;

public final class VersionedGestureDetector {
    public static GestureDetector newInstance(Context context, OnGestureListener onGestureListener) {
        GestureDetector gestureDetector;
        int i = Build.VERSION.SDK_INT;
        if (i < 5) {
            gestureDetector = new CupcakeGestureDetector(context);
        } else if (i < 8) {
            gestureDetector = new EclairGestureDetector(context);
        } else {
            gestureDetector = new FroyoGestureDetector(context);
        }
        gestureDetector.setOnGestureListener(onGestureListener);
        return gestureDetector;
    }
}
