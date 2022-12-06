package com.google.android.gms.internal.ads;

import java.lang.reflect.InvocationTargetException;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzark extends zzarq {
    private final zzaql zzi;
    private long zzj;

    public zzark(zzaqe zzaqe, String str, String str2, zzamk zzamk, int i, int i2, zzaql zzaql) {
        super(zzaqe, "mkunJHFc5vhTAVOcsaNSYx7OvFB6slgbORGrA/joIDO0IYq5rQvDcAbp2AI6CPUh", "k8GEQUoJxJPI/0jAlfeUix8QD7WaaXAfMcSQAzrpgrU=", zzamk, i, 53);
        this.zzi = zzaql;
        if (zzaql != null) {
            this.zzj = zzaql.zza();
        }
    }

    /* access modifiers changed from: protected */
    public final void zza() throws IllegalAccessException, InvocationTargetException {
        if (this.zzi != null) {
            this.zze.zzP(((Long) this.zzf.invoke((Object) null, new Object[]{Long.valueOf(this.zzj)})).longValue());
        }
    }
}
