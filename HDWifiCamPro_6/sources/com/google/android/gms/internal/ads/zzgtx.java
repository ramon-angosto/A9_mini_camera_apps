package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzgtx extends RuntimeException {
    public zzgtx(zzgso zzgso) {
        super("Message was missing required fields.  (Lite runtime could not determine which fields were missing).");
    }

    public final zzgrq zza() {
        return new zzgrq(getMessage());
    }
}
