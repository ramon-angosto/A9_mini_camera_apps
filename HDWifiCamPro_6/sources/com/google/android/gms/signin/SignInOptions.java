package com.google.android.gms.signin;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.internal.Objects;

/* compiled from: com.google.android.gms:play-services-base@@18.0.0 */
public final class SignInOptions implements Api.ApiOptions.Optional {
    public static final SignInOptions zaa = new SignInOptions(false, false, (String) null, false, (String) null, (String) null, false, (Long) null, (Long) null, (zaf) null);
    private final boolean zab = false;
    private final boolean zac = false;
    private final String zad = null;
    private final boolean zae = false;
    private final String zaf = null;
    private final String zag = null;
    private final boolean zah = false;
    private final Long zai = null;
    private final Long zaj = null;

    /* synthetic */ SignInOptions(boolean z, boolean z2, String str, boolean z3, String str2, String str3, boolean z4, Long l, Long l2, zaf zaf2) {
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SignInOptions)) {
            return false;
        }
        SignInOptions signInOptions = (SignInOptions) obj;
        boolean z = signInOptions.zab;
        boolean z2 = signInOptions.zac;
        String str = signInOptions.zad;
        if (Objects.equal((Object) null, (Object) null)) {
            boolean z3 = signInOptions.zae;
            boolean z4 = signInOptions.zah;
            String str2 = signInOptions.zaf;
            if (Objects.equal((Object) null, (Object) null)) {
                String str3 = signInOptions.zag;
                if (Objects.equal((Object) null, (Object) null)) {
                    Long l = signInOptions.zai;
                    if (Objects.equal((Object) null, (Object) null)) {
                        Long l2 = signInOptions.zaj;
                        if (Objects.equal((Object) null, (Object) null)) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(false, false, null, false, false, null, null, null, null);
    }
}
