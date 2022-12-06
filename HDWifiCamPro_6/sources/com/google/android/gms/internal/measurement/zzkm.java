package com.google.android.gms.internal.measurement;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-measurement-base@@20.1.2 */
public class zzkm extends IOException {
    public zzkm(String str) {
        super(str);
    }

    static zzkl zza() {
        return new zzkl("Protocol message tag had invalid wire type.");
    }

    static zzkm zzb() {
        return new zzkm("Protocol message contained an invalid tag (zero).");
    }

    static zzkm zzc() {
        return new zzkm("Protocol message had invalid UTF-8.");
    }

    static zzkm zzd() {
        return new zzkm("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    static zzkm zze() {
        return new zzkm("Failed to parse the message.");
    }

    static zzkm zzf() {
        return new zzkm("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }
}
