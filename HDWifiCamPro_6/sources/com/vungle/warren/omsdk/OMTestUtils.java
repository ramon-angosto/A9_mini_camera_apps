package com.vungle.warren.omsdk;

import com.iab.omid.library.vungle.Omid;

class OMTestUtils {
    OMTestUtils() {
    }

    public static boolean isOmidActive() {
        return Omid.isActive();
    }
}
