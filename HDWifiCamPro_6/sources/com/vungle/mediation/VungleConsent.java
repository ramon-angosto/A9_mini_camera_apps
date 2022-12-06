package com.vungle.mediation;

import com.vungle.warren.Vungle;

public class VungleConsent {
    public static void updateConsentStatus(Vungle.Consent consent, String str) {
        Vungle.updateConsentStatus(consent, str);
    }

    public static Vungle.Consent getCurrentVungleConsent() {
        return Vungle.getConsentStatus();
    }

    public static String getCurrentVungleConsentMessageVersion() {
        return Vungle.getConsentMessageVersion();
    }
}
