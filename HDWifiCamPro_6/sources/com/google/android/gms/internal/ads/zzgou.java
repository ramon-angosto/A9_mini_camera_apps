package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.security.Key;
import java.util.Arrays;
import javax.crypto.Mac;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzgou implements zzghu {
    private final ThreadLocal zza = new zzgot(this);
    /* access modifiers changed from: private */
    public final String zzb;
    /* access modifiers changed from: private */
    public final Key zzc;
    private final int zzd;

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public zzgou(java.lang.String r5, java.security.Key r6) throws java.security.GeneralSecurityException {
        /*
            r4 = this;
            r4.<init>()
            com.google.android.gms.internal.ads.zzgot r0 = new com.google.android.gms.internal.ads.zzgot
            r0.<init>(r4)
            r4.zza = r0
            r0 = 2
            boolean r1 = com.google.android.gms.internal.ads.zzgds.zza(r0)
            if (r1 == 0) goto L_0x0092
            r4.zzb = r5
            r4.zzc = r6
            byte[] r6 = r6.getEncoded()
            int r6 = r6.length
            r1 = 16
            if (r6 < r1) goto L_0x008a
            int r6 = r5.hashCode()
            r1 = 4
            r2 = 3
            r3 = 1
            switch(r6) {
                case -1823053428: goto L_0x0051;
                case 392315023: goto L_0x0047;
                case 392315118: goto L_0x003d;
                case 392316170: goto L_0x0033;
                case 392317873: goto L_0x0029;
                default: goto L_0x0028;
            }
        L_0x0028:
            goto L_0x005b
        L_0x0029:
            java.lang.String r6 = "HMACSHA512"
            boolean r6 = r5.equals(r6)
            if (r6 == 0) goto L_0x005b
            r6 = r1
            goto L_0x005c
        L_0x0033:
            java.lang.String r6 = "HMACSHA384"
            boolean r6 = r5.equals(r6)
            if (r6 == 0) goto L_0x005b
            r6 = r2
            goto L_0x005c
        L_0x003d:
            java.lang.String r6 = "HMACSHA256"
            boolean r6 = r5.equals(r6)
            if (r6 == 0) goto L_0x005b
            r6 = r0
            goto L_0x005c
        L_0x0047:
            java.lang.String r6 = "HMACSHA224"
            boolean r6 = r5.equals(r6)
            if (r6 == 0) goto L_0x005b
            r6 = r3
            goto L_0x005c
        L_0x0051:
            java.lang.String r6 = "HMACSHA1"
            boolean r6 = r5.equals(r6)
            if (r6 == 0) goto L_0x005b
            r6 = 0
            goto L_0x005c
        L_0x005b:
            r6 = -1
        L_0x005c:
            if (r6 == 0) goto L_0x0080
            if (r6 == r3) goto L_0x007b
            if (r6 == r0) goto L_0x0078
            if (r6 == r2) goto L_0x0075
            if (r6 != r1) goto L_0x0069
            r5 = 64
            goto L_0x007d
        L_0x0069:
            java.security.NoSuchAlgorithmException r6 = new java.security.NoSuchAlgorithmException
            java.lang.String r0 = "unknown Hmac algorithm: "
            java.lang.String r5 = r0.concat(r5)
            r6.<init>(r5)
            throw r6
        L_0x0075:
            r5 = 48
            goto L_0x007d
        L_0x0078:
            r5 = 32
            goto L_0x007d
        L_0x007b:
            r5 = 28
        L_0x007d:
            r4.zzd = r5
            goto L_0x0084
        L_0x0080:
            r5 = 20
            r4.zzd = r5
        L_0x0084:
            java.lang.ThreadLocal r5 = r4.zza
            r5.get()
            return
        L_0x008a:
            java.security.InvalidAlgorithmParameterException r5 = new java.security.InvalidAlgorithmParameterException
            java.lang.String r6 = "key size too small, need at least 16 bytes"
            r5.<init>(r6)
            throw r5
        L_0x0092:
            java.security.GeneralSecurityException r5 = new java.security.GeneralSecurityException
            java.lang.String r6 = "Can not use HMAC in FIPS-mode, as BoringCrypto module is not available."
            r5.<init>(r6)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzgou.<init>(java.lang.String, java.security.Key):void");
    }

    public final byte[] zza(byte[] bArr, int i) throws GeneralSecurityException {
        if (i <= this.zzd) {
            ((Mac) this.zza.get()).update(bArr);
            return Arrays.copyOf(((Mac) this.zza.get()).doFinal(), i);
        }
        throw new InvalidAlgorithmParameterException("tag size too big");
    }
}
