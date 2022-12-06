package com.meizu.cloud.pushsdk.a.h;

import android.support.v4.media.session.PlaybackStateCompat;

final class j {
    static i a;
    static long b;

    private j() {
    }

    static i a() {
        synchronized (j.class) {
            if (a == null) {
                return new i();
            }
            i iVar = a;
            a = iVar.f;
            iVar.f = null;
            b -= PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH;
            return iVar;
        }
    }

    static void a(i iVar) {
        if (iVar.f != null || iVar.g != null) {
            throw new IllegalArgumentException();
        } else if (!iVar.d) {
            synchronized (j.class) {
                if (b + PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH <= 65536) {
                    b += PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH;
                    iVar.f = a;
                    iVar.c = 0;
                    iVar.b = 0;
                    a = iVar;
                }
            }
        }
    }
}
