package com.google.android.gms.internal;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

public final class zzakk {
    public zzakf zza(Reader reader) throws zzakg, zzako {
        try {
            zzalw zzalw = new zzalw(reader);
            zzakf zzh = zzh(zzalw);
            if (!zzh.zzVI()) {
                if (zzalw.zzWa() != zzalx.END_DOCUMENT) {
                    throw new zzako("Did not consume the entire document.");
                }
            }
            return zzh;
        } catch (zzalz e) {
            throw new zzako((Throwable) e);
        } catch (IOException e2) {
            throw new zzakg((Throwable) e2);
        } catch (NumberFormatException e3) {
            throw new zzako((Throwable) e3);
        }
    }

    public zzakf zzh(zzalw zzalw) throws zzakg, zzako {
        boolean isLenient = zzalw.isLenient();
        zzalw.setLenient(true);
        try {
            zzakf zzh = zzalg.zzh(zzalw);
            zzalw.setLenient(isLenient);
            return zzh;
        } catch (StackOverflowError e) {
            String valueOf = String.valueOf(zzalw);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 36);
            sb.append("Failed parsing JSON source: ");
            sb.append(valueOf);
            sb.append(" to Json");
            throw new zzakj(sb.toString(), e);
        } catch (OutOfMemoryError e2) {
            String valueOf2 = String.valueOf(zzalw);
            StringBuilder sb2 = new StringBuilder(String.valueOf(valueOf2).length() + 36);
            sb2.append("Failed parsing JSON source: ");
            sb2.append(valueOf2);
            sb2.append(" to Json");
            throw new zzakj(sb2.toString(), e2);
        } catch (Throwable th) {
            zzalw.setLenient(isLenient);
            throw th;
        }
    }

    public zzakf zziR(String str) throws zzako {
        return zza(new StringReader(str));
    }
}
