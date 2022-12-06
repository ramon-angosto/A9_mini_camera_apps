package com.google.android.gms.internal.ads;

import java.util.Map;
import javax.annotation.CheckForNull;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzfwi {
    @CheckForNull
    static Object zza(Map map, @CheckForNull Object obj) {
        if (map != null) {
            try {
                return map.get(obj);
            } catch (ClassCastException | NullPointerException unused) {
                return null;
            }
        } else {
            throw null;
        }
    }

    static boolean zzb(Map map, @CheckForNull Object obj) {
        if (map == obj) {
            return true;
        }
        if (obj instanceof Map) {
            return map.entrySet().equals(((Map) obj).entrySet());
        }
        return false;
    }
}
