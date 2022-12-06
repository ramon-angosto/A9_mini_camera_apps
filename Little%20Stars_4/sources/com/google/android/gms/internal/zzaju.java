package com.google.android.gms.internal;

import java.lang.reflect.Type;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

final class zzaju implements zzake<Date>, zzakn<Date> {
    private final DateFormat zzbVN;
    private final DateFormat zzbVO;
    private final DateFormat zzbVP;

    zzaju() {
        this(DateFormat.getDateTimeInstance(2, 2, Locale.US), DateFormat.getDateTimeInstance(2, 2));
    }

    public zzaju(int i, int i2) {
        this(DateFormat.getDateTimeInstance(i, i2, Locale.US), DateFormat.getDateTimeInstance(i, i2));
    }

    zzaju(String str) {
        this((DateFormat) new SimpleDateFormat(str, Locale.US), (DateFormat) new SimpleDateFormat(str));
    }

    zzaju(DateFormat dateFormat, DateFormat dateFormat2) {
        this.zzbVN = dateFormat;
        this.zzbVO = dateFormat2;
        this.zzbVP = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.US);
        this.zzbVP.setTimeZone(TimeZone.getTimeZone("UTC"));
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:13|14|15|16|17) */
    /* JADX WARNING: Can't wrap try/catch for region: R(5:8|9|10|11|12) */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001c, code lost:
        return r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:?, code lost:
        r4 = r3.zzbVP.parse(r4.zzVA());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0028, code lost:
        return r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0029, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0033, code lost:
        throw new com.google.android.gms.internal.zzako(r4.zzVA(), r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:?, code lost:
        r4 = r3.zzbVN.parse(r4.zzVA());
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x001d */
    /* JADX WARNING: Missing exception handler attribute for start block: B:8:0x0011 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.util.Date zza(com.google.android.gms.internal.zzakf r4) {
        /*
            r3 = this;
            java.text.DateFormat r0 = r3.zzbVO
            monitor-enter(r0)
            java.text.DateFormat r1 = r3.zzbVO     // Catch:{ ParseException -> 0x0011 }
            java.lang.String r2 = r4.zzVA()     // Catch:{ ParseException -> 0x0011 }
            java.util.Date r4 = r1.parse(r2)     // Catch:{ ParseException -> 0x0011 }
            monitor-exit(r0)     // Catch:{ all -> 0x000f }
            return r4
        L_0x000f:
            r4 = move-exception
            goto L_0x0034
        L_0x0011:
            java.text.DateFormat r1 = r3.zzbVN     // Catch:{ ParseException -> 0x001d }
            java.lang.String r2 = r4.zzVA()     // Catch:{ ParseException -> 0x001d }
            java.util.Date r4 = r1.parse(r2)     // Catch:{ ParseException -> 0x001d }
            monitor-exit(r0)     // Catch:{ all -> 0x000f }
            return r4
        L_0x001d:
            java.text.DateFormat r1 = r3.zzbVP     // Catch:{ ParseException -> 0x0029 }
            java.lang.String r2 = r4.zzVA()     // Catch:{ ParseException -> 0x0029 }
            java.util.Date r4 = r1.parse(r2)     // Catch:{ ParseException -> 0x0029 }
            monitor-exit(r0)     // Catch:{ all -> 0x000f }
            return r4
        L_0x0029:
            r1 = move-exception
            com.google.android.gms.internal.zzako r2 = new com.google.android.gms.internal.zzako     // Catch:{ all -> 0x000f }
            java.lang.String r4 = r4.zzVA()     // Catch:{ all -> 0x000f }
            r2.<init>(r4, r1)     // Catch:{ all -> 0x000f }
            throw r2     // Catch:{ all -> 0x000f }
        L_0x0034:
            monitor-exit(r0)     // Catch:{ all -> 0x000f }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzaju.zza(com.google.android.gms.internal.zzakf):java.util.Date");
    }

    public String toString() {
        return zzaju.class.getSimpleName() + '(' + this.zzbVO.getClass().getSimpleName() + ')';
    }

    public zzakf zza(Date date, Type type, zzakm zzakm) {
        zzakl zzakl;
        synchronized (this.zzbVO) {
            zzakl = new zzakl(this.zzbVN.format(date));
        }
        return zzakl;
    }

    /* renamed from: zza */
    public Date zzb(zzakf zzakf, Type type, zzakd zzakd) throws zzakj {
        if (zzakf instanceof zzakl) {
            Date zza = zza(zzakf);
            if (type == Date.class) {
                return zza;
            }
            if (type == Timestamp.class) {
                return new Timestamp(zza.getTime());
            }
            if (type == java.sql.Date.class) {
                return new java.sql.Date(zza.getTime());
            }
            String valueOf = String.valueOf(getClass());
            String valueOf2 = String.valueOf(type);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 23 + String.valueOf(valueOf2).length());
            sb.append(valueOf);
            sb.append(" cannot deserialize to ");
            sb.append(valueOf2);
            throw new IllegalArgumentException(sb.toString());
        }
        throw new zzakj("The date should be a string value");
    }
}
