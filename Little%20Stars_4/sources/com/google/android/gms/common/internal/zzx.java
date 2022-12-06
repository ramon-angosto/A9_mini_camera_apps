package com.google.android.gms.common.internal;

import java.util.Iterator;

public class zzx {
    private final String separator;

    private zzx(String str) {
        this.separator = str;
    }

    public static zzx zzdk(String str) {
        return new zzx(str);
    }

    public final String zza(Iterable<?> iterable) {
        return zza(new StringBuilder(), iterable).toString();
    }

    public final StringBuilder zza(StringBuilder sb, Iterable<?> iterable) {
        Iterator<?> it = iterable.iterator();
        if (it.hasNext()) {
            while (true) {
                sb.append(zzx(it.next()));
                if (!it.hasNext()) {
                    break;
                }
                sb.append(this.separator);
            }
        }
        return sb;
    }

    /* access modifiers changed from: package-private */
    public CharSequence zzx(Object obj) {
        return obj instanceof CharSequence ? (CharSequence) obj : obj.toString();
    }
}
