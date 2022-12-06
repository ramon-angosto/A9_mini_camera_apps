package com.adcolony.sdk;

import androidx.core.app.NotificationCompat;
import com.adcolony.sdk.e0;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.vungle.warren.persistence.IdColumns;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;
import org.json.JSONException;

public class AdColonyEventTracker {
    public static final String CUSTOM_EVENT_1 = "ADCT_CUSTOM_EVENT_1";
    public static final String CUSTOM_EVENT_2 = "ADCT_CUSTOM_EVENT_2";
    public static final String CUSTOM_EVENT_3 = "ADCT_CUSTOM_EVENT_3";
    public static final String CUSTOM_EVENT_4 = "ADCT_CUSTOM_EVENT_4";
    public static final String CUSTOM_EVENT_5 = "ADCT_CUSTOM_EVENT_5";
    public static final String LOGIN_DEFAULT = "ADCT_DEFAULT_LOGIN";
    public static final String LOGIN_FACEBOOK = "ADCT_FACEBOOK_LOGIN";
    public static final String LOGIN_GOOGLE = "ADCT_GOOGLE_LOGIN";
    public static final String LOGIN_LINKEDIN = "ADCT_LINKEDIN_LOGIN";
    public static final String LOGIN_OPENID = "ADCT_OPENID_LOGIN";
    public static final String LOGIN_TWITTER = "ADCT_TWITTER_LOGIN";
    public static final String REGISTRATION_CUSTOM = "ADCT_CUSTOM_REGISTRATION";
    public static final String REGISTRATION_DEFAULT = "ADCT_DEFAULT_REGISTRATION";
    public static final String REGISTRATION_FACEBOOK = "ADCT_FACEBOOK_REGISTRATION";
    public static final String REGISTRATION_GOOGLE = "ADCT_GOOGLE_REGISTRATION";
    public static final String REGISTRATION_LINKEDIN = "ADCT_LINKEDIN_REGISTRATION";
    public static final String REGISTRATION_OPENID = "ADCT_OPENID_REGISTRATION";
    public static final String REGISTRATION_TWITTER = "ADCT_TWITTER_REGISTRATION";
    public static final String SOCIAL_SHARING_CUSTOM = "ADCT_CUSTOM_SHARING";
    public static final String SOCIAL_SHARING_FACEBOOK = "ADCT_FACEBOOK_SHARING";
    public static final String SOCIAL_SHARING_FLICKR = "ADCT_FLICKR_SHARING";
    public static final String SOCIAL_SHARING_FOURSQUARE = "ADCT_FOURSQUARE_SHARING";
    public static final String SOCIAL_SHARING_GOOGLE = "ADCT_GOOGLE_SHARING";
    public static final String SOCIAL_SHARING_INSTAGRAM = "ADCT_INSTAGRAM_SHARING";
    public static final String SOCIAL_SHARING_LINKEDIN = "ADCT_LINKEDIN_SHARING";
    public static final String SOCIAL_SHARING_PINTEREST = "ADCT_PINTEREST_SHARING";
    public static final String SOCIAL_SHARING_SNAPCHAT = "ADCT_SNAPCHAT_SHARING";
    public static final String SOCIAL_SHARING_TUMBLR = "ADCT_TUMBLR_SHARING";
    public static final String SOCIAL_SHARING_TWITTER = "ADCT_TWITTER_SHARING";
    public static final String SOCIAL_SHARING_VIMEO = "ADCT_VIMEO_SHARING";
    public static final String SOCIAL_SHARING_VINE = "ADCT_VINE_SHARING";
    public static final String SOCIAL_SHARING_YOUTUBE = "ADCT_YOUTUBE_SHARING";
    private static final List<f1> a = Collections.synchronizedList(new ArrayList());

    static void a(f1 f1Var) {
        List<f1> list = a;
        synchronized (list) {
            if (200 > list.size()) {
                list.add(f1Var);
            }
        }
    }

    static void b() {
        k b = a.b();
        if (!b.v().equals("") && b.I()) {
            List<f1> list = a;
            synchronized (list) {
                for (f1 b2 : list) {
                    b(b2);
                }
                a.clear();
            }
        }
    }

    private static void c(f1 f1Var) {
        f1 f = c0.f(f1Var, "payload");
        if (l.H) {
            c0.a(f, "api_key", "bb2cf0647ba654d7228dd3f9405bbc6a");
        } else {
            c0.a(f, "api_key", a.b().v());
        }
        try {
            f1Var.r("payload");
            f1Var.a("payload", f);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private static void d(f1 f1Var) {
        c0.a(f1Var, "timezone", TimeZone.getDefault().getID());
        c0.a(f1Var, "action_time", String.valueOf(Math.round((float) (System.currentTimeMillis() / 1000))));
    }

    public static void logAchievementUnlocked(String str) {
        if (!a(str, "logAchievementUnlocked")) {
            HashMap hashMap = new HashMap();
            hashMap.put("description", str);
            logEvent("achievement_unlocked", hashMap);
        }
    }

    public static void logActivated() {
        logEvent("activated");
    }

    public static void logAdImpression() {
        logEvent("ad_impression");
    }

    public static void logAddToCart(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put(IdColumns.COLUMN_IDENTIFIER, str);
        logEvent("add_to_cart", hashMap);
    }

    public static void logAddToWishlist(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put(IdColumns.COLUMN_IDENTIFIER, str);
        logEvent("add_to_wishlist", hashMap);
    }

    public static void logAppOpen() {
        logEvent("app_open");
    }

    public static void logAppRated() {
        logEvent("app_rated");
    }

    public static void logCheckoutInitiated() {
        logEvent("checkout_initiated");
    }

    public static void logContentView(String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("content_id", str);
        hashMap.put("content_type", str2);
        logEvent("content_view", hashMap);
    }

    public static void logCreditsSpent(String str, Integer num, Double d, String str2) {
        if (str2 == null || str2.length() == 3) {
            HashMap hashMap = new HashMap();
            hashMap.put("name", str);
            hashMap.put("quantity", String.valueOf(num));
            hashMap.put(AppMeasurementSdk.ConditionalUserProperty.VALUE, String.valueOf(d));
            hashMap.put("currency_code", str2);
            logEvent("credits_spent", hashMap);
            return;
        }
        new e0.a().a("Event logCreditsSpentWithName currency code is specified, but a three-letter ISO 4217 code, (e.g.: 'USD'). Event will not be sent.").a(e0.h);
    }

    public static void logCustomEvent(String str, String str2) {
        if (!a(str2, "logCustomEvent")) {
            HashMap hashMap = new HashMap();
            hashMap.put(NotificationCompat.CATEGORY_EVENT, str);
            hashMap.put("description", str2);
            logEvent("custom_event", hashMap);
        }
    }

    public static void logEvent(String str) {
        logEvent(str, (HashMap<String, String>) null);
    }

    public static void logInvite() {
        logEvent("invite");
    }

    public static void logLevelAchieved(Integer num) {
        HashMap hashMap = new HashMap();
        hashMap.put("level_achieved", String.valueOf(num));
        logEvent("level_achieved", hashMap);
    }

    public static void logLogin(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("method", str);
        logEvent("login", hashMap);
    }

    public static void logPaymentInfoAdded() {
        logEvent("payment_info_added");
    }

    public static void logRegistrationCompleted(String str, String str2) {
        if (!a(str2, "logRegistrationCompleted")) {
            HashMap hashMap = new HashMap();
            hashMap.put("method", str);
            hashMap.put("description", str2);
            logEvent("registration_completed", hashMap);
        }
    }

    public static void logReservation() {
        logEvent("reservation");
    }

    public static void logSearch(String str) {
        if (str == null || str.length() <= 512) {
            HashMap hashMap = new HashMap();
            hashMap.put("search_string", str);
            logEvent("search", hashMap);
            return;
        }
        new e0.a().a("logSearch searchString cannot exceed 512 characters. Event will ").a("not be sent.").a(e0.h);
    }

    public static void logSocialSharingEvent(String str, String str2) {
        if (!a(str2, "logSocialSharingEvent")) {
            HashMap hashMap = new HashMap();
            hashMap.put("network", str);
            hashMap.put("description", str2);
            logEvent("social_sharing_event", hashMap);
        }
    }

    public static void logTransaction(String str, Integer num, Double d, String str2, String str3, String str4, String str5) {
        if (!a(str5, "logTransaction")) {
            if (str2 == null || str2.length() == 3) {
                HashMap hashMap = new HashMap();
                hashMap.put(IdColumns.COLUMN_IDENTIFIER, str);
                hashMap.put("quantity", String.valueOf(num));
                hashMap.put("price", String.valueOf(d));
                hashMap.put("currency_code", str2);
                hashMap.put("receipt", str3);
                hashMap.put("store", str4);
                hashMap.put("description", str5);
                logEvent("transaction", hashMap);
                return;
            }
            new e0.a().a("Event logCreditsSpentWithName currency code is specified, but a three-letter ISO 4217 code, (e.g.: 'USD'). Event will not be sent.").a(e0.h);
        }
    }

    public static void logTutorialCompleted() {
        logEvent("tutorial_completed");
    }

    public static void logEvent(String str, HashMap<String, String> hashMap) {
        f1 b = c0.b();
        c0.a(b, "event_name", str);
        f1 b2 = c0.b();
        if (hashMap != null) {
            for (Map.Entry next : hashMap.entrySet()) {
                if (next.getValue() != null && !((String) next.getValue()).equals("null")) {
                    c0.a(b2, (String) next.getKey(), (String) next.getValue());
                }
            }
        }
        d(b2);
        c0.a(b, "payload", b2);
        b(b);
    }

    static boolean a() {
        boolean z;
        List<f1> list = a;
        synchronized (list) {
            z = list.size() != 0;
        }
        return z;
    }

    private static void b(f1 f1Var) {
        k b = a.b();
        if (b.v().equals("") || !b.I()) {
            a(f1Var);
            return;
        }
        c(f1Var);
        new h0("AdColony.log_event", 1, f1Var).c();
    }

    private static boolean a(String str, String str2) {
        if (str == null || str.length() <= 512) {
            return false;
        }
        new e0.a().a("Description of event ").a(str2).a(" must be less").a(" than 512 characters").a(e0.h);
        return true;
    }
}
