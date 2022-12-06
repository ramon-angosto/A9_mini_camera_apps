package com.facebook.ads;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AdSDKNotificationManager {
    private static final List<AdSDKNotificationListener> sNotificationListeners = Collections.synchronizedList(new ArrayList());

    public static void addSDKNotificationListener(AdSDKNotificationListener adSDKNotificationListener) {
        synchronized (sNotificationListeners) {
            sNotificationListeners.add(adSDKNotificationListener);
        }
    }

    public static void removeSDKNotificationListener(AdSDKNotificationListener adSDKNotificationListener) {
        synchronized (sNotificationListeners) {
            sNotificationListeners.remove(adSDKNotificationListener);
        }
    }

    public static List<AdSDKNotificationListener> getNotificationListeners() {
        return sNotificationListeners;
    }
}
