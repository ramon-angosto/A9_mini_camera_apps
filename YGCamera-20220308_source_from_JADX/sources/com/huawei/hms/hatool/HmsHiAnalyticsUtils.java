package com.huawei.hms.hatool;

import android.content.Context;
import java.util.LinkedHashMap;

public class HmsHiAnalyticsUtils {
    public static void enableLog() {
        C0812l1.m956a();
    }

    public static boolean getInitFlag() {
        return C0806j1.m884b();
    }

    public static void init(Context context, boolean z, boolean z2, boolean z3, String str, String str2) {
        new C0809k1(context).mo14036a(z).mo14039c(z2).mo14038b(z3).mo14034a(0, str).mo14034a(1, str).mo14035a(str2).mo14037a();
    }

    public static void onEvent(Context context, String str, String str2) {
        C0806j1.m883a(context, str, str2);
    }

    public static void onReport() {
        C0806j1.m885c();
    }

    public static void onEvent(int i, String str, LinkedHashMap<String, String> linkedHashMap) {
        C0806j1.m882a(i, str, linkedHashMap);
    }
}
