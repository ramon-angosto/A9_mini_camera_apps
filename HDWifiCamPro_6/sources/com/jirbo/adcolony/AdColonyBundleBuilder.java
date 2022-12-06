package com.jirbo.adcolony;

import android.os.Bundle;

public class AdColonyBundleBuilder {
    private static boolean _showPostAdPopup;
    private static boolean _showPreAdPopup;

    public static void setShowPrePopup(boolean z) {
        _showPreAdPopup = z;
    }

    public static void setShowPostPopup(boolean z) {
        _showPostAdPopup = z;
    }

    public static Bundle build() {
        Bundle bundle = new Bundle();
        bundle.putBoolean("show_pre_popup", _showPreAdPopup);
        bundle.putBoolean("show_post_popup", _showPostAdPopup);
        return bundle;
    }
}
