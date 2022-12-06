package com.google.android.gms.internal;

import java.io.IOException;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public final class zzals extends zzakr<Time> {
    public static final zzaks zzbXD = new zzaks() {
        public <T> zzakr<T> zza(zzajz zzajz, zzalv<T> zzalv) {
            if (zzalv.zzWl() == Time.class) {
                return new zzals();
            }
            return null;
        }
    };
    private final DateFormat zzbYd = new SimpleDateFormat("hh:mm:ss a");

    public synchronized void zza(zzaly zzaly, Time time) throws IOException {
        zzaly.zziU(time == null ? null : this.zzbYd.format(time));
    }

    /* renamed from: zzn */
    public synchronized Time zzb(zzalw zzalw) throws IOException {
        if (zzalw.zzWa() == zzalx.NULL) {
            zzalw.nextNull();
            return null;
        }
        try {
            return new Time(this.zzbYd.parse(zzalw.nextString()).getTime());
        } catch (ParseException e) {
            throw new zzako((Throwable) e);
        }
    }
}
