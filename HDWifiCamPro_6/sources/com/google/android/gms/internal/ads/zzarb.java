package com.google.android.gms.internal.ads;

import java.lang.reflect.InvocationTargetException;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzarb extends zzarq {
    private final zzapi zzi;
    private final long zzj;
    private final long zzk;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzarb(zzaqe zzaqe, String str, String str2, zzamk zzamk, int i, int i2, zzapi zzapi, long j, long j2) {
        super(zzaqe, "X9PgbTHLX0FFxbl3gdPDuVwcglfXy5CDrzo8siaVNaH+OIJ6JI34Wu3QK5rLega4", "JLulXGPEHVwHK+0FG96HP9my+NvwpTQbwIaIZrjn9OU=", zzamk, i, 11);
        this.zzi = zzapi;
        this.zzj = j;
        this.zzk = j2;
    }

    /* access modifiers changed from: protected */
    public final void zza() throws IllegalAccessException, InvocationTargetException {
        zzapi zzapi = this.zzi;
        if (zzapi != null) {
            zzapg zzapg = new zzapg((String) this.zzf.invoke((Object) null, new Object[]{zzapi.zzb(), Long.valueOf(this.zzj), Long.valueOf(this.zzk)}));
            synchronized (this.zze) {
                this.zze.zzz(zzapg.zza.longValue());
                if (zzapg.zzb.longValue() >= 0) {
                    this.zze.zzQ(zzapg.zzb.longValue());
                }
                if (zzapg.zzc.longValue() >= 0) {
                    this.zze.zzf(zzapg.zzc.longValue());
                }
            }
        }
    }
}
