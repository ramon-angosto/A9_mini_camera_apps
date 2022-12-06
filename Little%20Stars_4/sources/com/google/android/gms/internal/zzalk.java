package com.google.android.gms.internal;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public final class zzalk extends zzakr<Date> {
    public static final zzaks zzbXD = new zzaks() {
        public <T> zzakr<T> zza(zzajz zzajz, zzalv<T> zzalv) {
            if (zzalv.zzWl() == Date.class) {
                return new zzalk();
            }
            return null;
        }
    };
    private final DateFormat zzbVN = DateFormat.getDateTimeInstance(2, 2, Locale.US);
    private final DateFormat zzbVO = DateFormat.getDateTimeInstance(2, 2);
    private final DateFormat zzbVP = zzVZ();

    private static DateFormat zzVZ() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.US);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        return simpleDateFormat;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(4:6|7|8|9) */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x001a, code lost:
        return r2.zzbVP.parse(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x001b, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0021, code lost:
        throw new com.google.android.gms.internal.zzako(r3, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0012, code lost:
        return r2.zzbVN.parse(r3);
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x0013 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:6:0x000b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized java.util.Date zziS(java.lang.String r3) {
        /*
            r2 = this;
            monitor-enter(r2)
            java.text.DateFormat r0 = r2.zzbVO     // Catch:{ ParseException -> 0x000b }
            java.util.Date r3 = r0.parse(r3)     // Catch:{ ParseException -> 0x000b }
            monitor-exit(r2)
            return r3
        L_0x0009:
            r3 = move-exception
            goto L_0x0022
        L_0x000b:
            java.text.DateFormat r0 = r2.zzbVN     // Catch:{ ParseException -> 0x0013 }
            java.util.Date r3 = r0.parse(r3)     // Catch:{ ParseException -> 0x0013 }
            monitor-exit(r2)
            return r3
        L_0x0013:
            java.text.DateFormat r0 = r2.zzbVP     // Catch:{ ParseException -> 0x001b }
            java.util.Date r3 = r0.parse(r3)     // Catch:{ ParseException -> 0x001b }
            monitor-exit(r2)
            return r3
        L_0x001b:
            r0 = move-exception
            com.google.android.gms.internal.zzako r1 = new com.google.android.gms.internal.zzako     // Catch:{ all -> 0x0009 }
            r1.<init>(r3, r0)     // Catch:{ all -> 0x0009 }
            throw r1     // Catch:{ all -> 0x0009 }
        L_0x0022:
            monitor-exit(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzalk.zziS(java.lang.String):java.util.Date");
    }

    public synchronized void zza(zzaly zzaly, Date date) throws IOException {
        if (date == null) {
            zzaly.zzWk();
        } else {
            zzaly.zziU(this.zzbVN.format(date));
        }
    }

    /* renamed from: zzk */
    public Date zzb(zzalw zzalw) throws IOException {
        if (zzalw.zzWa() != zzalx.NULL) {
            return zziS(zzalw.nextString());
        }
        zzalw.nextNull();
        return null;
    }
}
