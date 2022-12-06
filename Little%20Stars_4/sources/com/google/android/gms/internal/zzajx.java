package com.google.android.gms.internal;

import com.xiaomi.mipush.sdk.Constants;
import java.lang.reflect.Field;
import java.util.Locale;

public enum zzajx implements zzajy {
    IDENTITY {
        public String zzb(Field field) {
            return field.getName();
        }
    },
    UPPER_CAMEL_CASE {
        public String zzb(Field field) {
            return zzajx.zziO(field.getName());
        }
    },
    UPPER_CAMEL_CASE_WITH_SPACES {
        public String zzb(Field field) {
            return zzajx.zziO(zzajx.zzat(field.getName(), " "));
        }
    },
    LOWER_CASE_WITH_UNDERSCORES {
        public String zzb(Field field) {
            return zzajx.zzat(field.getName(), "_").toLowerCase(Locale.ENGLISH);
        }
    },
    LOWER_CASE_WITH_DASHES {
        public String zzb(Field field) {
            return zzajx.zzat(field.getName(), Constants.ACCEPT_TIME_SEPARATOR_SERVER).toLowerCase(Locale.ENGLISH);
        }
    };

    private static String zza(char c, String str, int i) {
        if (i >= str.length()) {
            return String.valueOf(c);
        }
        String valueOf = String.valueOf(str.substring(i));
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 1);
        sb.append(c);
        sb.append(valueOf);
        return sb.toString();
    }

    /* access modifiers changed from: private */
    public static String zzat(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (Character.isUpperCase(charAt) && sb.length() != 0) {
                sb.append(str2);
            }
            sb.append(charAt);
        }
        return sb.toString();
    }

    /* access modifiers changed from: private */
    public static String zziO(String str) {
        char charAt;
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (true) {
            charAt = str.charAt(i);
            if (i < str.length() - 1 && !Character.isLetter(charAt)) {
                sb.append(charAt);
                i++;
            }
        }
        if (i == str.length()) {
            return sb.toString();
        }
        if (Character.isUpperCase(charAt)) {
            return str;
        }
        sb.append(zza(Character.toUpperCase(charAt), str, i + 1));
        return sb.toString();
    }
}
