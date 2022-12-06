package com.google.android.gms.internal;

import java.io.IOException;
import java.io.Writer;

public final class zzalg {

    private static final class zza extends Writer {
        private final Appendable zzbXw;
        private final C0016zza zzbXx;

        /* renamed from: com.google.android.gms.internal.zzalg$zza$zza  reason: collision with other inner class name */
        static class C0016zza implements CharSequence {
            char[] zzbXy;

            C0016zza() {
            }

            public char charAt(int i) {
                return this.zzbXy[i];
            }

            public int length() {
                return this.zzbXy.length;
            }

            public CharSequence subSequence(int i, int i2) {
                return new String(this.zzbXy, i, i2 - i);
            }
        }

        private zza(Appendable appendable) {
            this.zzbXx = new C0016zza();
            this.zzbXw = appendable;
        }

        public void close() {
        }

        public void flush() {
        }

        public void write(int i) throws IOException {
            this.zzbXw.append((char) i);
        }

        public void write(char[] cArr, int i, int i2) throws IOException {
            C0016zza zza = this.zzbXx;
            zza.zzbXy = cArr;
            this.zzbXw.append(zza, i, i2 + i);
        }
    }

    public static Writer zza(Appendable appendable) {
        return appendable instanceof Writer ? (Writer) appendable : new zza(appendable);
    }

    public static void zzb(zzakf zzakf, zzaly zzaly) throws IOException {
        zzalu.zzbYV.zza(zzaly, zzakf);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0016, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001c, code lost:
        throw new com.google.android.gms.internal.zzakg((java.lang.Throwable) r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x001d, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0023, code lost:
        throw new com.google.android.gms.internal.zzako((java.lang.Throwable) r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0024, code lost:
        r2 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0025, code lost:
        r0 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x002a, code lost:
        return com.google.android.gms.internal.zzakh.zzbWr;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0030, code lost:
        throw new com.google.android.gms.internal.zzako((java.lang.Throwable) r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x000f, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0015, code lost:
        throw new com.google.android.gms.internal.zzako((java.lang.Throwable) r2);
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x0016 A[ExcHandler: IOException (r2v5 'e' java.io.IOException A[CUSTOM_DECLARE]), Splitter:B:0:0x0000] */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x001d A[ExcHandler: zzalz (r2v4 'e' com.google.android.gms.internal.zzalz A[CUSTOM_DECLARE]), Splitter:B:0:0x0000] */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0028  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x002b  */
    /* JADX WARNING: Removed duplicated region for block: B:7:0x000f A[ExcHandler: NumberFormatException (r2v6 'e' java.lang.NumberFormatException A[CUSTOM_DECLARE]), Splitter:B:0:0x0000] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.android.gms.internal.zzakf zzh(com.google.android.gms.internal.zzalw r2) throws com.google.android.gms.internal.zzakj {
        /*
            r2.zzWa()     // Catch:{ EOFException -> 0x0024, zzalz -> 0x001d, IOException -> 0x0016, NumberFormatException -> 0x000f }
            r0 = 0
            com.google.android.gms.internal.zzakr<com.google.android.gms.internal.zzakf> r1 = com.google.android.gms.internal.zzalu.zzbYV     // Catch:{ EOFException -> 0x000d, zzalz -> 0x001d, IOException -> 0x0016, NumberFormatException -> 0x000f }
            java.lang.Object r2 = r1.zzb(r2)     // Catch:{ EOFException -> 0x000d, zzalz -> 0x001d, IOException -> 0x0016, NumberFormatException -> 0x000f }
            com.google.android.gms.internal.zzakf r2 = (com.google.android.gms.internal.zzakf) r2     // Catch:{ EOFException -> 0x000d, zzalz -> 0x001d, IOException -> 0x0016, NumberFormatException -> 0x000f }
            return r2
        L_0x000d:
            r2 = move-exception
            goto L_0x0026
        L_0x000f:
            r2 = move-exception
            com.google.android.gms.internal.zzako r0 = new com.google.android.gms.internal.zzako
            r0.<init>((java.lang.Throwable) r2)
            throw r0
        L_0x0016:
            r2 = move-exception
            com.google.android.gms.internal.zzakg r0 = new com.google.android.gms.internal.zzakg
            r0.<init>((java.lang.Throwable) r2)
            throw r0
        L_0x001d:
            r2 = move-exception
            com.google.android.gms.internal.zzako r0 = new com.google.android.gms.internal.zzako
            r0.<init>((java.lang.Throwable) r2)
            throw r0
        L_0x0024:
            r2 = move-exception
            r0 = 1
        L_0x0026:
            if (r0 == 0) goto L_0x002b
            com.google.android.gms.internal.zzakh r2 = com.google.android.gms.internal.zzakh.zzbWr
            return r2
        L_0x002b:
            com.google.android.gms.internal.zzako r0 = new com.google.android.gms.internal.zzako
            r0.<init>((java.lang.Throwable) r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzalg.zzh(com.google.android.gms.internal.zzalw):com.google.android.gms.internal.zzakf");
    }
}
