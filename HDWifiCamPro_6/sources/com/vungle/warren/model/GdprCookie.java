package com.vungle.warren.model;

import android.text.TextUtils;
import com.google.gson.JsonObject;
import com.vungle.warren.persistence.DatabaseHelper;
import com.vungle.warren.persistence.Repository;
import com.vungle.warren.utility.TimeoutProvider;
import java.util.concurrent.TimeUnit;

public class GdprCookie {
    public static String CONSENT_MESSAGE_VERSION = "consent_message_version";
    public static String CONSENT_SOURCE = "consent_source";
    public static String CONSENT_STATUS = "consent_status";
    public static String NO_INTERACTION = "no_interaction";
    public static String TIMESTAMP = "timestamp";
    public static String UNKNOWN = "unknown";
    private final Cookie cookie;
    private final Repository repository;

    public GdprCookie(Repository repository2, TimeoutProvider timeoutProvider) {
        this.repository = repository2;
        Cookie cookie2 = repository2.load(Cookie.CONSENT_COOKIE, Cookie.class).get(timeoutProvider.getTimeout(), TimeUnit.MILLISECONDS);
        this.cookie = cookie2 == null ? createDefaultCookie() : cookie2;
    }

    public String getConsentStatus() {
        Cookie cookie2 = this.cookie;
        return cookie2 != null ? cookie2.getString(CONSENT_STATUS) : "unknown";
    }

    public String getSource() {
        Cookie cookie2 = this.cookie;
        return cookie2 != null ? cookie2.getString(CONSENT_SOURCE) : NO_INTERACTION;
    }

    public Long getTimeStamp() {
        Cookie cookie2 = this.cookie;
        return Long.valueOf(cookie2 != null ? cookie2.getLong(TIMESTAMP).longValue() : 0);
    }

    public String getMessageVersion() {
        Cookie cookie2 = this.cookie;
        return cookie2 != null ? cookie2.getString(CONSENT_MESSAGE_VERSION) : "";
    }

    private Cookie createDefaultCookie() {
        Cookie cookie2 = new Cookie(Cookie.CONSENT_COOKIE);
        cookie2.putValue(CONSENT_MESSAGE_VERSION, "");
        cookie2.putValue(CONSENT_STATUS, UNKNOWN);
        cookie2.putValue(CONSENT_SOURCE, NO_INTERACTION);
        cookie2.putValue(TIMESTAMP, 0L);
        return cookie2;
    }

    public void save(JsonObject jsonObject) throws DatabaseHelper.DBException {
        boolean z = JsonUtil.hasNonNull(jsonObject, "is_country_data_protected") && jsonObject.get("is_country_data_protected").getAsBoolean();
        String str = "";
        String asString = JsonUtil.hasNonNull(jsonObject, "consent_title") ? jsonObject.get("consent_title").getAsString() : str;
        String asString2 = JsonUtil.hasNonNull(jsonObject, "consent_message") ? jsonObject.get("consent_message").getAsString() : str;
        String asString3 = JsonUtil.hasNonNull(jsonObject, "consent_message_version") ? jsonObject.get("consent_message_version").getAsString() : str;
        String asString4 = JsonUtil.hasNonNull(jsonObject, "button_accept") ? jsonObject.get("button_accept").getAsString() : str;
        String asString5 = JsonUtil.hasNonNull(jsonObject, "button_deny") ? jsonObject.get("button_deny").getAsString() : str;
        this.cookie.putValue("is_country_data_protected", Boolean.valueOf(z));
        Cookie cookie2 = this.cookie;
        if (TextUtils.isEmpty(asString)) {
            asString = "Targeted Ads";
        }
        cookie2.putValue("consent_title", asString);
        Cookie cookie3 = this.cookie;
        if (TextUtils.isEmpty(asString2)) {
            asString2 = "To receive more relevant ad content based on your interactions with our ads, click \"I Consent\" below. Either way, you will see the same amount of ads.";
        }
        cookie3.putValue("consent_message", asString2);
        if (!"publisher".equalsIgnoreCase(this.cookie.getString(CONSENT_SOURCE))) {
            Cookie cookie4 = this.cookie;
            String str2 = CONSENT_MESSAGE_VERSION;
            if (!TextUtils.isEmpty(asString3)) {
                str = asString3;
            }
            cookie4.putValue(str2, str);
        }
        Cookie cookie5 = this.cookie;
        if (TextUtils.isEmpty(asString4)) {
            asString4 = "I Consent";
        }
        cookie5.putValue("button_accept", asString4);
        Cookie cookie6 = this.cookie;
        if (TextUtils.isEmpty(asString5)) {
            asString5 = "I Do Not Consent";
        }
        cookie6.putValue("button_deny", asString5);
        this.repository.save(this.cookie);
    }
}
