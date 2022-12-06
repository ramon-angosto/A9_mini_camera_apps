package com.vungle.warren.locale;

import java.util.Locale;
import java.util.TimeZone;

public class SystemLocaleInfo implements LocaleInfo {
    public String getTimeZoneId() {
        return TimeZone.getDefault().getID();
    }

    public String getLanguage() {
        return Locale.getDefault().getLanguage();
    }
}
