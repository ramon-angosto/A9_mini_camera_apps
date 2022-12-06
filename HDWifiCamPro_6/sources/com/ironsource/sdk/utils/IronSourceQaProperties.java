package com.ironsource.sdk.utils;

import java.util.HashMap;
import java.util.Map;

public class IronSourceQaProperties {
    private static IronSourceQaProperties a;
    private static Map<String, String> b = new HashMap();

    private IronSourceQaProperties() {
    }

    public static IronSourceQaProperties getInstance() {
        if (a == null) {
            a = new IronSourceQaProperties();
        }
        return a;
    }

    public static boolean isInitialized() {
        return a != null;
    }

    public Map<String, String> getParameters() {
        return b;
    }

    public void setQaParameter(String str, String str2) {
        if (str != null && str2 != null) {
            b.put(str, str2);
        }
    }
}
