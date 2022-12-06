package com.google.android.gms.common.internal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class zzz {

    public static final class zza {
        private final Object zzRm;
        private final List<String> zzask;

        private zza(Object obj) {
            this.zzRm = zzaa.zzz(obj);
            this.zzask = new ArrayList();
        }

        public String toString() {
            StringBuilder sb = new StringBuilder(100);
            sb.append(this.zzRm.getClass().getSimpleName());
            sb.append('{');
            int size = this.zzask.size();
            for (int i = 0; i < size; i++) {
                sb.append(this.zzask.get(i));
                if (i < size - 1) {
                    sb.append(", ");
                }
            }
            sb.append('}');
            return sb.toString();
        }

        public zza zzg(String str, Object obj) {
            List<String> list = this.zzask;
            String str2 = (String) zzaa.zzz(str);
            String valueOf = String.valueOf(String.valueOf(obj));
            StringBuilder sb = new StringBuilder(String.valueOf(str2).length() + 1 + String.valueOf(valueOf).length());
            sb.append(str2);
            sb.append("=");
            sb.append(valueOf);
            list.add(sb.toString());
            return this;
        }
    }

    public static boolean equal(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public static int hashCode(Object... objArr) {
        return Arrays.hashCode(objArr);
    }

    public static zza zzy(Object obj) {
        return new zza(obj);
    }
}
