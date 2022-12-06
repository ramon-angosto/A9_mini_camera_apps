package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.net.Uri;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzfx extends zzer {
    private final Resources zza;
    private final String zzb;
    private Uri zzc;
    private AssetFileDescriptor zzd;
    private InputStream zze;
    private long zzf;
    private boolean zzg;

    public zzfx(Context context) {
        super(false);
        this.zza = context.getResources();
        this.zzb = context.getPackageName();
    }

    public static Uri buildRawResourceUri(int i) {
        return Uri.parse("rawresource:///" + i);
    }

    public final int zza(byte[] bArr, int i, int i2) throws zzfw {
        if (i2 == 0) {
            return 0;
        }
        long j = this.zzf;
        if (j == 0) {
            return -1;
        }
        if (j != -1) {
            try {
                i2 = (int) Math.min(j, (long) i2);
            } catch (IOException e) {
                throw new zzfw((String) null, e, 2000);
            }
        }
        InputStream inputStream = this.zze;
        int i3 = zzen.zza;
        int read = inputStream.read(bArr, i, i2);
        if (read != -1) {
            long j2 = this.zzf;
            if (j2 != -1) {
                this.zzf = j2 - ((long) read);
            }
            zzg(read);
            return read;
        } else if (this.zzf == -1) {
            return -1;
        } else {
            throw new zzfw("End of stream reached having not read sufficient data.", new EOFException(), 2000);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x003b, code lost:
        if (r3.matches("\\d+") != false) goto L_0x0098;
     */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00b1  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x0151  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final long zzb(com.google.android.gms.internal.ads.zzfc r16) throws com.google.android.gms.internal.ads.zzfw {
        /*
            r15 = this;
            r1 = r15
            r0 = r16
            android.net.Uri r2 = r0.zza
            r1.zzc = r2
            java.lang.String r3 = r2.getScheme()
            java.lang.String r4 = "rawresource"
            boolean r3 = android.text.TextUtils.equals(r4, r3)
            r4 = 2005(0x7d5, float:2.81E-42)
            r5 = 1004(0x3ec, float:1.407E-42)
            r6 = 1
            r7 = 0
            if (r3 != 0) goto L_0x0098
            java.lang.String r3 = r2.getScheme()
            java.lang.String r8 = "android.resource"
            boolean r3 = android.text.TextUtils.equals(r8, r3)
            if (r3 == 0) goto L_0x003f
            java.util.List r3 = r2.getPathSegments()
            int r3 = r3.size()
            if (r3 != r6) goto L_0x003f
            java.lang.String r3 = r2.getLastPathSegment()
            if (r3 == 0) goto L_0x003e
            java.lang.String r9 = "\\d+"
            boolean r3 = r3.matches(r9)
            if (r3 == 0) goto L_0x003f
            goto L_0x0098
        L_0x003e:
            throw r7
        L_0x003f:
            java.lang.String r3 = r2.getScheme()
            boolean r3 = android.text.TextUtils.equals(r8, r3)
            if (r3 == 0) goto L_0x0090
            java.lang.String r3 = r2.getPath()
            if (r3 == 0) goto L_0x008f
            java.lang.String r5 = "/"
            boolean r5 = r3.startsWith(r5)
            if (r5 == 0) goto L_0x005b
            java.lang.String r3 = r3.substring(r6)
        L_0x005b:
            java.lang.String r5 = r2.getHost()
            boolean r8 = android.text.TextUtils.isEmpty(r5)
            if (r8 == 0) goto L_0x0068
            java.lang.String r5 = ""
            goto L_0x0072
        L_0x0068:
            java.lang.String r5 = java.lang.String.valueOf(r5)
            java.lang.String r8 = ":"
            java.lang.String r5 = r5.concat(r8)
        L_0x0072:
            android.content.res.Resources r8 = r1.zza
            java.lang.String r3 = java.lang.String.valueOf(r3)
            java.lang.String r3 = r5.concat(r3)
            java.lang.String r5 = r1.zzb
            java.lang.String r9 = "raw"
            int r3 = r8.getIdentifier(r3, r9, r5)
            if (r3 == 0) goto L_0x0087
            goto L_0x00a2
        L_0x0087:
            com.google.android.gms.internal.ads.zzfw r0 = new com.google.android.gms.internal.ads.zzfw
            java.lang.String r2 = "Resource not found."
            r0.<init>(r2, r7, r4)
            throw r0
        L_0x008f:
            throw r7
        L_0x0090:
            com.google.android.gms.internal.ads.zzfw r0 = new com.google.android.gms.internal.ads.zzfw
            java.lang.String r2 = "URI must either use scheme rawresource or android.resource"
            r0.<init>(r2, r7, r5)
            throw r0
        L_0x0098:
            java.lang.String r3 = r2.getLastPathSegment()     // Catch:{ NumberFormatException -> 0x0170 }
            if (r3 == 0) goto L_0x016e
            int r3 = java.lang.Integer.parseInt(r3)     // Catch:{ NumberFormatException -> 0x0170 }
        L_0x00a2:
            r15.zzi(r16)
            android.content.res.Resources r5 = r1.zza     // Catch:{ NotFoundException -> 0x0166 }
            android.content.res.AssetFileDescriptor r3 = r5.openRawResourceFd(r3)     // Catch:{ NotFoundException -> 0x0166 }
            r1.zzd = r3
            r4 = 2000(0x7d0, float:2.803E-42)
            if (r3 == 0) goto L_0x0151
            long r8 = r3.getLength()
            java.io.FileInputStream r2 = new java.io.FileInputStream
            java.io.FileDescriptor r5 = r3.getFileDescriptor()
            r2.<init>(r5)
            r1.zze = r2
            r10 = -1
            int r5 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            r12 = 2008(0x7d8, float:2.814E-42)
            if (r5 == 0) goto L_0x00d5
            long r13 = r0.zzf     // Catch:{ zzfw -> 0x014f, IOException -> 0x0147 }
            int r13 = (r13 > r8 ? 1 : (r13 == r8 ? 0 : -1))
            if (r13 > 0) goto L_0x00cf
            goto L_0x00d5
        L_0x00cf:
            com.google.android.gms.internal.ads.zzfw r0 = new com.google.android.gms.internal.ads.zzfw     // Catch:{ zzfw -> 0x014f, IOException -> 0x0147 }
            r0.<init>(r7, r7, r12)     // Catch:{ zzfw -> 0x014f, IOException -> 0x0147 }
            throw r0     // Catch:{ zzfw -> 0x014f, IOException -> 0x0147 }
        L_0x00d5:
            long r13 = r3.getStartOffset()     // Catch:{ zzfw -> 0x014f, IOException -> 0x0147 }
            long r6 = r0.zzf     // Catch:{ zzfw -> 0x014f, IOException -> 0x0147 }
            long r6 = r6 + r13
            long r6 = r2.skip(r6)     // Catch:{ zzfw -> 0x014f, IOException -> 0x0147 }
            long r6 = r6 - r13
            long r13 = r0.zzf     // Catch:{ zzfw -> 0x014f, IOException -> 0x0147 }
            int r13 = (r6 > r13 ? 1 : (r6 == r13 ? 0 : -1))
            if (r13 != 0) goto L_0x0140
            r13 = 0
            if (r5 != 0) goto L_0x0112
            java.nio.channels.FileChannel r2 = r2.getChannel()     // Catch:{ zzfw -> 0x014f, IOException -> 0x0147 }
            long r5 = r2.size()     // Catch:{ zzfw -> 0x014f, IOException -> 0x0147 }
            int r5 = (r5 > r13 ? 1 : (r5 == r13 ? 0 : -1))
            if (r5 != 0) goto L_0x00fb
            r1.zzf = r10     // Catch:{ zzfw -> 0x014f, IOException -> 0x0147 }
            r5 = r10
            goto L_0x011a
        L_0x00fb:
            long r5 = r2.size()     // Catch:{ zzfw -> 0x014f, IOException -> 0x0147 }
            long r7 = r2.position()     // Catch:{ zzfw -> 0x014f, IOException -> 0x0147 }
            long r5 = r5 - r7
            r1.zzf = r5     // Catch:{ zzfw -> 0x014f, IOException -> 0x0147 }
            int r2 = (r5 > r13 ? 1 : (r5 == r13 ? 0 : -1))
            if (r2 < 0) goto L_0x010b
            goto L_0x011a
        L_0x010b:
            com.google.android.gms.internal.ads.zzfw r0 = new com.google.android.gms.internal.ads.zzfw     // Catch:{ zzfw -> 0x014f, IOException -> 0x0147 }
            r2 = 0
            r0.<init>(r2, r2, r12)     // Catch:{ zzfw -> 0x014f, IOException -> 0x0147 }
            throw r0     // Catch:{ zzfw -> 0x014f, IOException -> 0x0147 }
        L_0x0112:
            long r5 = r8 - r6
            r1.zzf = r5     // Catch:{ zzfw -> 0x014f, IOException -> 0x0147 }
            int r2 = (r5 > r13 ? 1 : (r5 == r13 ? 0 : -1))
            if (r2 < 0) goto L_0x013a
        L_0x011a:
            long r2 = r0.zzg
            int r4 = (r2 > r10 ? 1 : (r2 == r10 ? 0 : -1))
            if (r4 == 0) goto L_0x012a
            int r4 = (r5 > r10 ? 1 : (r5 == r10 ? 0 : -1))
            if (r4 == 0) goto L_0x0128
            long r2 = java.lang.Math.min(r5, r2)
        L_0x0128:
            r1.zzf = r2
        L_0x012a:
            r2 = 1
            r1.zzg = r2
            r15.zzj(r16)
            long r2 = r0.zzg
            int r0 = (r2 > r10 ? 1 : (r2 == r10 ? 0 : -1))
            if (r0 == 0) goto L_0x0137
            return r2
        L_0x0137:
            long r2 = r1.zzf
            return r2
        L_0x013a:
            com.google.android.gms.internal.ads.zzey r0 = new com.google.android.gms.internal.ads.zzey     // Catch:{ zzfw -> 0x014f, IOException -> 0x0147 }
            r0.<init>(r12)     // Catch:{ zzfw -> 0x014f, IOException -> 0x0147 }
            throw r0     // Catch:{ zzfw -> 0x014f, IOException -> 0x0147 }
        L_0x0140:
            com.google.android.gms.internal.ads.zzfw r0 = new com.google.android.gms.internal.ads.zzfw     // Catch:{ zzfw -> 0x014f, IOException -> 0x0147 }
            r2 = 0
            r0.<init>(r2, r2, r12)     // Catch:{ zzfw -> 0x014f, IOException -> 0x0147 }
            throw r0     // Catch:{ zzfw -> 0x014f, IOException -> 0x0147 }
        L_0x0147:
            r0 = move-exception
            com.google.android.gms.internal.ads.zzfw r2 = new com.google.android.gms.internal.ads.zzfw
            r3 = 0
            r2.<init>(r3, r0, r4)
            throw r2
        L_0x014f:
            r0 = move-exception
            throw r0
        L_0x0151:
            r3 = r7
            com.google.android.gms.internal.ads.zzfw r0 = new com.google.android.gms.internal.ads.zzfw
            java.lang.String r2 = java.lang.String.valueOf(r2)
            java.lang.String r2 = java.lang.String.valueOf(r2)
            java.lang.String r5 = "Resource is compressed: "
            java.lang.String r2 = r5.concat(r2)
            r0.<init>(r2, r3, r4)
            throw r0
        L_0x0166:
            r0 = move-exception
            r3 = r7
            com.google.android.gms.internal.ads.zzfw r2 = new com.google.android.gms.internal.ads.zzfw
            r2.<init>(r3, r0, r4)
            throw r2
        L_0x016e:
            r3 = r7
            throw r3     // Catch:{ NumberFormatException -> 0x0171 }
        L_0x0170:
            r3 = r7
        L_0x0171:
            com.google.android.gms.internal.ads.zzfw r0 = new com.google.android.gms.internal.ads.zzfw
            java.lang.String r2 = "Resource identifier must be an integer."
            r0.<init>(r2, r3, r5)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzfx.zzb(com.google.android.gms.internal.ads.zzfc):long");
    }

    public final Uri zzc() {
        return this.zzc;
    }

    public final void zzd() throws zzfw {
        this.zzc = null;
        try {
            InputStream inputStream = this.zze;
            if (inputStream != null) {
                inputStream.close();
            }
            this.zze = null;
            try {
                AssetFileDescriptor assetFileDescriptor = this.zzd;
                if (assetFileDescriptor != null) {
                    assetFileDescriptor.close();
                }
                this.zzd = null;
                if (this.zzg) {
                    this.zzg = false;
                    zzh();
                }
            } catch (IOException e) {
                throw new zzfw((String) null, e, 2000);
            } catch (Throwable th) {
                this.zzd = null;
                if (this.zzg) {
                    this.zzg = false;
                    zzh();
                }
                throw th;
            }
        } catch (IOException e2) {
            throw new zzfw((String) null, e2, 2000);
        } catch (Throwable th2) {
            this.zze = null;
            try {
                AssetFileDescriptor assetFileDescriptor2 = this.zzd;
                if (assetFileDescriptor2 != null) {
                    assetFileDescriptor2.close();
                }
                this.zzd = null;
                if (this.zzg) {
                    this.zzg = false;
                    zzh();
                }
                throw th2;
            } catch (IOException e3) {
                throw new zzfw((String) null, e3, 2000);
            } catch (Throwable th3) {
                this.zzd = null;
                if (this.zzg) {
                    this.zzg = false;
                    zzh();
                }
                throw th3;
            }
        }
    }
}
