package com.google.android.gms.internal.ads;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import java.io.FileInputStream;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzeu extends zzer {
    private final ContentResolver zza;
    private Uri zzb;
    private AssetFileDescriptor zzc;
    private FileInputStream zzd;
    private long zze;
    private boolean zzf;

    public zzeu(Context context) {
        super(false);
        this.zza = context.getContentResolver();
    }

    public final int zza(byte[] bArr, int i, int i2) throws zzet {
        if (i2 == 0) {
            return 0;
        }
        long j = this.zze;
        if (j == 0) {
            return -1;
        }
        if (j != -1) {
            try {
                i2 = (int) Math.min(j, (long) i2);
            } catch (IOException e) {
                throw new zzet(e, 2000);
            }
        }
        FileInputStream fileInputStream = this.zzd;
        int i3 = zzen.zza;
        int read = fileInputStream.read(bArr, i, i2);
        if (read == -1) {
            return -1;
        }
        long j2 = this.zze;
        if (j2 != -1) {
            this.zze = j2 - ((long) read);
        }
        zzg(read);
        return read;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00ec, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x00f9, code lost:
        r3 = com.ironsource.mediationsdk.utils.IronSourceConstants.IS_INSTANCE_OPENED;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x00ff, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x0100, code lost:
        throw r0;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00f9  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00ff A[ExcHandler: zzet (r0v1 'e' com.google.android.gms.internal.ads.zzet A[CUSTOM_DECLARE]), Splitter:B:1:0x0004] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final long zzb(com.google.android.gms.internal.ads.zzfc r16) throws com.google.android.gms.internal.ads.zzet {
        /*
            r15 = this;
            r1 = r15
            r0 = r16
            r3 = 1
            android.net.Uri r4 = r0.zza     // Catch:{ zzet -> 0x00ff, IOException -> 0x00ee }
            r1.zzb = r4     // Catch:{ zzet -> 0x00ff, IOException -> 0x00ee }
            r15.zzi(r16)     // Catch:{ zzet -> 0x00ff, IOException -> 0x00ee }
            java.lang.String r5 = "content"
            android.net.Uri r6 = r0.zza     // Catch:{ zzet -> 0x00ff, IOException -> 0x00ee }
            java.lang.String r6 = r6.getScheme()     // Catch:{ zzet -> 0x00ff, IOException -> 0x00ee }
            boolean r5 = r5.equals(r6)     // Catch:{ zzet -> 0x00ff, IOException -> 0x00ee }
            if (r5 == 0) goto L_0x002c
            android.os.Bundle r5 = new android.os.Bundle     // Catch:{ zzet -> 0x00ff, IOException -> 0x00ee }
            r5.<init>()     // Catch:{ zzet -> 0x00ff, IOException -> 0x00ee }
            java.lang.String r6 = "android.provider.extra.ACCEPT_ORIGINAL_MEDIA_FORMAT"
            r5.putBoolean(r6, r3)     // Catch:{ zzet -> 0x00ff, IOException -> 0x00ee }
            android.content.ContentResolver r6 = r1.zza     // Catch:{ zzet -> 0x00ff, IOException -> 0x00ee }
            java.lang.String r7 = "*/*"
            android.content.res.AssetFileDescriptor r5 = r6.openTypedAssetFileDescriptor(r4, r7, r5)     // Catch:{ zzet -> 0x00ff, IOException -> 0x00ee }
            goto L_0x0034
        L_0x002c:
            android.content.ContentResolver r5 = r1.zza     // Catch:{ zzet -> 0x00ff, IOException -> 0x00ee }
            java.lang.String r6 = "r"
            android.content.res.AssetFileDescriptor r5 = r5.openAssetFileDescriptor(r4, r6)     // Catch:{ zzet -> 0x00ff, IOException -> 0x00ee }
        L_0x0034:
            r1.zzc = r5     // Catch:{ zzet -> 0x00ff, IOException -> 0x00ee }
            if (r5 == 0) goto L_0x00ca
            long r6 = r5.getLength()     // Catch:{ zzet -> 0x00ff, IOException -> 0x00ee }
            java.io.FileInputStream r4 = new java.io.FileInputStream     // Catch:{ zzet -> 0x00ff, IOException -> 0x00ee }
            java.io.FileDescriptor r8 = r5.getFileDescriptor()     // Catch:{ zzet -> 0x00ff, IOException -> 0x00ee }
            r4.<init>(r8)     // Catch:{ zzet -> 0x00ff, IOException -> 0x00ee }
            r1.zzd = r4     // Catch:{ zzet -> 0x00ff, IOException -> 0x00ee }
            r8 = -1
            int r10 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            r11 = 2008(0x7d8, float:2.814E-42)
            r12 = 0
            if (r10 == 0) goto L_0x005d
            long r13 = r0.zzf     // Catch:{ zzet -> 0x00ff, IOException -> 0x00ee }
            int r13 = (r13 > r6 ? 1 : (r13 == r6 ? 0 : -1))
            if (r13 > 0) goto L_0x0057
            goto L_0x005d
        L_0x0057:
            com.google.android.gms.internal.ads.zzet r0 = new com.google.android.gms.internal.ads.zzet     // Catch:{ zzet -> 0x00ff, IOException -> 0x00ee }
            r0.<init>(r12, r11)     // Catch:{ zzet -> 0x00ff, IOException -> 0x00ee }
            throw r0     // Catch:{ zzet -> 0x00ff, IOException -> 0x00ee }
        L_0x005d:
            long r13 = r5.getStartOffset()     // Catch:{ zzet -> 0x00ff, IOException -> 0x00ee }
            long r2 = r0.zzf     // Catch:{ zzet -> 0x00ff, IOException -> 0x00ee }
            long r2 = r2 + r13
            long r2 = r4.skip(r2)     // Catch:{ zzet -> 0x00ff, IOException -> 0x00ee }
            long r2 = r2 - r13
            long r13 = r0.zzf     // Catch:{ zzet -> 0x00ff, IOException -> 0x00ee }
            int r13 = (r2 > r13 ? 1 : (r2 == r13 ? 0 : -1))
            if (r13 != 0) goto L_0x00c4
            r13 = 0
            if (r10 != 0) goto L_0x0096
            java.nio.channels.FileChannel r2 = r4.getChannel()     // Catch:{ zzet -> 0x00ff, IOException -> 0x00ee }
            long r3 = r2.size()     // Catch:{ zzet -> 0x00ff, IOException -> 0x00ee }
            int r6 = (r3 > r13 ? 1 : (r3 == r13 ? 0 : -1))
            if (r6 != 0) goto L_0x0083
            r1.zze = r8     // Catch:{ zzet -> 0x00ff, IOException -> 0x00ee }
            r2 = r8
            goto L_0x009e
        L_0x0083:
            long r6 = r2.position()     // Catch:{ zzet -> 0x00ff, IOException -> 0x00ee }
            long r2 = r3 - r6
            r1.zze = r2     // Catch:{ zzet -> 0x00ff, IOException -> 0x00ee }
            int r4 = (r2 > r13 ? 1 : (r2 == r13 ? 0 : -1))
            if (r4 < 0) goto L_0x0090
            goto L_0x009e
        L_0x0090:
            com.google.android.gms.internal.ads.zzet r0 = new com.google.android.gms.internal.ads.zzet     // Catch:{ zzet -> 0x00ff, IOException -> 0x00ee }
            r0.<init>(r12, r11)     // Catch:{ zzet -> 0x00ff, IOException -> 0x00ee }
            throw r0     // Catch:{ zzet -> 0x00ff, IOException -> 0x00ee }
        L_0x0096:
            long r2 = r6 - r2
            r1.zze = r2     // Catch:{ zzet -> 0x00ff, IOException -> 0x00ee }
            int r4 = (r2 > r13 ? 1 : (r2 == r13 ? 0 : -1))
            if (r4 < 0) goto L_0x00be
        L_0x009e:
            long r4 = r0.zzg
            int r6 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1))
            if (r6 == 0) goto L_0x00ae
            int r6 = (r2 > r8 ? 1 : (r2 == r8 ? 0 : -1))
            if (r6 == 0) goto L_0x00ac
            long r4 = java.lang.Math.min(r2, r4)
        L_0x00ac:
            r1.zze = r4
        L_0x00ae:
            r2 = 1
            r1.zzf = r2
            r15.zzj(r16)
            long r2 = r0.zzg
            int r0 = (r2 > r8 ? 1 : (r2 == r8 ? 0 : -1))
            if (r0 == 0) goto L_0x00bb
            return r2
        L_0x00bb:
            long r2 = r1.zze
            return r2
        L_0x00be:
            com.google.android.gms.internal.ads.zzet r0 = new com.google.android.gms.internal.ads.zzet     // Catch:{ zzet -> 0x00ff, IOException -> 0x00ee }
            r0.<init>(r12, r11)     // Catch:{ zzet -> 0x00ff, IOException -> 0x00ee }
            throw r0     // Catch:{ zzet -> 0x00ff, IOException -> 0x00ee }
        L_0x00c4:
            com.google.android.gms.internal.ads.zzet r0 = new com.google.android.gms.internal.ads.zzet     // Catch:{ zzet -> 0x00ff, IOException -> 0x00ee }
            r0.<init>(r12, r11)     // Catch:{ zzet -> 0x00ff, IOException -> 0x00ee }
            throw r0     // Catch:{ zzet -> 0x00ff, IOException -> 0x00ee }
        L_0x00ca:
            com.google.android.gms.internal.ads.zzet r0 = new com.google.android.gms.internal.ads.zzet     // Catch:{ zzet -> 0x00ff, IOException -> 0x00ee }
            java.io.IOException r2 = new java.io.IOException     // Catch:{ zzet -> 0x00ff, IOException -> 0x00ee }
            java.lang.String r3 = java.lang.String.valueOf(r4)     // Catch:{ zzet -> 0x00ff, IOException -> 0x00ee }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ zzet -> 0x00ff, IOException -> 0x00ee }
            r4.<init>()     // Catch:{ zzet -> 0x00ff, IOException -> 0x00ee }
            java.lang.String r6 = "Could not open file descriptor for: "
            r4.append(r6)     // Catch:{ zzet -> 0x00ff, IOException -> 0x00ee }
            r4.append(r3)     // Catch:{ zzet -> 0x00ff, IOException -> 0x00ee }
            java.lang.String r3 = r4.toString()     // Catch:{ zzet -> 0x00ff, IOException -> 0x00ee }
            r2.<init>(r3)     // Catch:{ zzet -> 0x00ff, IOException -> 0x00ee }
            r3 = 2000(0x7d0, float:2.803E-42)
            r0.<init>(r2, r3)     // Catch:{ zzet -> 0x00ff, IOException -> 0x00ec }
            throw r0     // Catch:{ zzet -> 0x00ff, IOException -> 0x00ec }
        L_0x00ec:
            r0 = move-exception
            goto L_0x00f1
        L_0x00ee:
            r0 = move-exception
            r3 = 2000(0x7d0, float:2.803E-42)
        L_0x00f1:
            com.google.android.gms.internal.ads.zzet r2 = new com.google.android.gms.internal.ads.zzet
            boolean r4 = r0 instanceof java.io.FileNotFoundException
            r5 = 1
            if (r5 == r4) goto L_0x00f9
            goto L_0x00fb
        L_0x00f9:
            r3 = 2005(0x7d5, float:2.81E-42)
        L_0x00fb:
            r2.<init>(r0, r3)
            throw r2
        L_0x00ff:
            r0 = move-exception
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzeu.zzb(com.google.android.gms.internal.ads.zzfc):long");
    }

    public final Uri zzc() {
        return this.zzb;
    }

    public final void zzd() throws zzet {
        this.zzb = null;
        try {
            FileInputStream fileInputStream = this.zzd;
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            this.zzd = null;
            try {
                AssetFileDescriptor assetFileDescriptor = this.zzc;
                if (assetFileDescriptor != null) {
                    assetFileDescriptor.close();
                }
                this.zzc = null;
                if (this.zzf) {
                    this.zzf = false;
                    zzh();
                }
            } catch (IOException e) {
                throw new zzet(e, 2000);
            } catch (Throwable th) {
                this.zzc = null;
                if (this.zzf) {
                    this.zzf = false;
                    zzh();
                }
                throw th;
            }
        } catch (IOException e2) {
            throw new zzet(e2, 2000);
        } catch (Throwable th2) {
            this.zzd = null;
            try {
                AssetFileDescriptor assetFileDescriptor2 = this.zzc;
                if (assetFileDescriptor2 != null) {
                    assetFileDescriptor2.close();
                }
                this.zzc = null;
                if (this.zzf) {
                    this.zzf = false;
                    zzh();
                }
                throw th2;
            } catch (IOException e3) {
                throw new zzet(e3, 2000);
            } catch (Throwable th3) {
                this.zzc = null;
                if (this.zzf) {
                    this.zzf = false;
                    zzh();
                }
                throw th3;
            }
        }
    }
}
