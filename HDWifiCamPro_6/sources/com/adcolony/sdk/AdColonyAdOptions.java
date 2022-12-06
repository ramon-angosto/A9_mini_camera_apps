package com.adcolony.sdk;

public class AdColonyAdOptions {
    boolean a;
    boolean b;
    AdColonyUserMetadata c;
    f1 d = c0.b();

    public AdColonyAdOptions enableConfirmationDialog(boolean z) {
        this.a = z;
        c0.b(this.d, "confirmation_enabled", true);
        return this;
    }

    public AdColonyAdOptions enableResultsDialog(boolean z) {
        this.b = z;
        c0.b(this.d, "results_enabled", true);
        return this;
    }

    public Object getOption(String str) {
        return c0.g(this.d, str);
    }

    @Deprecated
    public AdColonyUserMetadata getUserMetadata() {
        return this.c;
    }

    public AdColonyAdOptions setOption(String str, boolean z) {
        if (z0.e(str)) {
            c0.b(this.d, str, z);
        }
        return this;
    }

    @Deprecated
    public AdColonyAdOptions setUserMetadata(AdColonyUserMetadata adColonyUserMetadata) {
        this.c = adColonyUserMetadata;
        c0.a(this.d, "user_metadata", adColonyUserMetadata.b);
        return this;
    }

    public AdColonyAdOptions setOption(String str, double d2) {
        if (z0.e(str)) {
            c0.a(this.d, str, d2);
        }
        return this;
    }

    public AdColonyAdOptions setOption(String str, String str2) {
        if (str != null) {
            c0.a(this.d, str, str2);
        }
        return this;
    }
}
