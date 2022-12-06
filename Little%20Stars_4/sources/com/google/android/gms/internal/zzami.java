package com.google.android.gms.internal;

import java.io.IOException;

public class zzami extends IOException {
    public zzami(String str) {
        super(str);
    }

    static zzami zzWX() {
        return new zzami("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either than the input has been truncated or that an embedded message misreported its own length.");
    }

    static zzami zzWY() {
        return new zzami("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    static zzami zzWZ() {
        return new zzami("CodedInputStream encountered a malformed varint.");
    }

    static zzami zzXa() {
        return new zzami("Protocol message contained an invalid tag (zero).");
    }

    static zzami zzXb() {
        return new zzami("Protocol message end-group tag did not match expected tag.");
    }

    static zzami zzXc() {
        return new zzami("Protocol message tag had invalid wire type.");
    }

    static zzami zzXd() {
        return new zzami("Protocol message had too many levels of nesting.  May be malicious.  Use CodedInputStream.setRecursionLimit() to increase the depth limit.");
    }
}
