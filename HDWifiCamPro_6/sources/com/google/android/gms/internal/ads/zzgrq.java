package com.google.android.gms.internal.ads;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public class zzgrq extends IOException {
    private zzgso zza = null;
    private boolean zzb;

    public zzgrq(IOException iOException) {
        super(iOException.getMessage(), iOException);
    }

    static zzgrp zza() {
        return new zzgrp("Protocol message tag had invalid wire type.");
    }

    static zzgrq zzb() {
        return new zzgrq("Protocol message end-group tag did not match expected tag.");
    }

    static zzgrq zzc() {
        return new zzgrq("Protocol message contained an invalid tag (zero).");
    }

    static zzgrq zzd() {
        return new zzgrq("Protocol message had invalid UTF-8.");
    }

    static zzgrq zze() {
        return new zzgrq("CodedInputStream encountered a malformed varint.");
    }

    static zzgrq zzf() {
        return new zzgrq("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    static zzgrq zzg() {
        return new zzgrq("Failed to parse the message.");
    }

    static zzgrq zzi() {
        return new zzgrq("Protocol message was too large.  May be malicious.  Use CodedInputStream.setSizeLimit() to increase the size limit.");
    }

    static zzgrq zzj() {
        return new zzgrq("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }

    public final zzgrq zzh(zzgso zzgso) {
        this.zza = zzgso;
        return this;
    }

    /* access modifiers changed from: package-private */
    public final void zzk() {
        this.zzb = true;
    }

    /* access modifiers changed from: package-private */
    public final boolean zzl() {
        return this.zzb;
    }

    public zzgrq(String str) {
        super(str);
    }
}
