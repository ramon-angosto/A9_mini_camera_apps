package com.google.android.gms.internal;

import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public final class zzalr extends zzakr<Date> {
    public static final zzaks zzbXD = new zzaks() {
        public <T> zzakr<T> zza(zzajz zzajz, zzalv<T> zzalv) {
            if (zzalv.zzWl() == Date.class) {
                return new zzalr();
            }
            return null;
        }
    };
    private final DateFormat zzbYd = new SimpleDateFormat("MMM d, yyyy");

    public synchronized void zza(zzaly zzaly, Date date) throws IOException {
        zzaly.zziU(date == null ? null : this.zzbYd.format(date));
    }

    /* renamed from: zzm */
    public synchronized Date zzb(zzalw zzalw) throws IOException {
        if (zzalw.zzWa() == zzalx.NULL) {
            zzalw.nextNull();
            return null;
        }
        try {
            return new Date(this.zzbYd.parse(zzalw.nextString()).getTime());
        } catch (ParseException e) {
            throw new zzako((Throwable) e);
        }
    }
}
