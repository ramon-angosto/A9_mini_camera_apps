package com.google.android.gms.internal.ads;

import java.io.EOFException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.logging.Level;
import java.util.logging.Logger;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public abstract class zzalm implements zzaln {
    private static final Logger zzb = Logger.getLogger(zzalm.class.getName());
    final ThreadLocal zza = new zzall(this);

    public abstract zzalq zza(String str, byte[] bArr, String str2);

    public final zzalq zzb(zzgwu zzgwu, zzalr zzalr) throws IOException {
        int zza2;
        long j;
        long zzb2 = zzgwu.zzb();
        ((ByteBuffer) this.zza.get()).rewind().limit(8);
        do {
            zza2 = zzgwu.zza((ByteBuffer) this.zza.get());
            if (zza2 == 8) {
                ((ByteBuffer) this.zza.get()).rewind();
                long zze = zzalp.zze((ByteBuffer) this.zza.get());
                byte[] bArr = null;
                if (zze >= 8 || zze <= 1) {
                    byte[] bArr2 = new byte[4];
                    ((ByteBuffer) this.zza.get()).get(bArr2);
                    try {
                        String str = new String(bArr2, "ISO-8859-1");
                        if (zze == 1) {
                            ((ByteBuffer) this.zza.get()).limit(16);
                            zzgwu.zza((ByteBuffer) this.zza.get());
                            ((ByteBuffer) this.zza.get()).position(8);
                            j = zzalp.zzf((ByteBuffer) this.zza.get()) - 16;
                        } else {
                            j = zze == 0 ? zzgwu.zzc() - zzgwu.zzb() : zze - 8;
                        }
                        if ("uuid".equals(str)) {
                            ((ByteBuffer) this.zza.get()).limit(((ByteBuffer) this.zza.get()).limit() + 16);
                            zzgwu.zza((ByteBuffer) this.zza.get());
                            bArr = new byte[16];
                            for (int position = ((ByteBuffer) this.zza.get()).position() - 16; position < ((ByteBuffer) this.zza.get()).position(); position++) {
                                bArr[position - (((ByteBuffer) this.zza.get()).position() - 16)] = ((ByteBuffer) this.zza.get()).get(position);
                            }
                            j -= 16;
                        }
                        long j2 = j;
                        zzalq zza3 = zza(str, bArr, zzalr instanceof zzalq ? ((zzalq) zzalr).zza() : "");
                        zza3.zzc(zzalr);
                        ((ByteBuffer) this.zza.get()).rewind();
                        zza3.zzb(zzgwu, (ByteBuffer) this.zza.get(), j2, this);
                        return zza3;
                    } catch (UnsupportedEncodingException e) {
                        throw new RuntimeException(e);
                    }
                } else {
                    Logger logger = zzb;
                    Level level = Level.SEVERE;
                    StringBuilder sb = new StringBuilder(80);
                    sb.append("Plausibility check failed: size < 8 (size = ");
                    sb.append(zze);
                    sb.append("). Stop parsing!");
                    logger.logp(level, "com.coremedia.iso.AbstractBoxParser", "parseBox", sb.toString());
                    return null;
                }
            }
        } while (zza2 >= 0);
        zzgwu.zze(zzb2);
        throw new EOFException();
    }
}
