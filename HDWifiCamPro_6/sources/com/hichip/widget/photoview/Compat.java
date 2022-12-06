package com.hichip.widget.photoview;

import android.os.Build;
import android.view.View;
import androidx.core.view.MotionEventCompat;

public class Compat {
    private static final int SIXTY_FPS_INTERVAL = 16;

    private static int getPointerIndexEclair(int i) {
        return (i & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8;
    }

    private static int getPointerIndexHoneyComb(int i) {
        return (i & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8;
    }

    public static void postOnAnimation(View view, Runnable runnable) {
        if (Build.VERSION.SDK_INT >= 16) {
            postOnAnimationJellyBean(view, runnable);
        } else {
            view.postDelayed(runnable, 16);
        }
    }

    private static void postOnAnimationJellyBean(View view, Runnable runnable) {
        view.postOnAnimation(runnable);
    }

    public static int getPointerIndex(int i) {
        if (Build.VERSION.SDK_INT >= 11) {
            return getPointerIndexHoneyComb(i);
        }
        return getPointerIndexEclair(i);
    }
}
