package com.google.android.gms.internal.ads;

import java.io.File;
import java.io.FilenameFilter;
import java.util.regex.Pattern;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzfxq implements FilenameFilter {
    private final Pattern zza;

    public zzfxq(Pattern pattern) {
        if (pattern != null) {
            this.zza = pattern;
            return;
        }
        throw null;
    }

    public final boolean accept(File file, String str) {
        return this.zza.matcher(str).matches();
    }
}
