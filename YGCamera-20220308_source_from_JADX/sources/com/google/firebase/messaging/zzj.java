package com.google.firebase.messaging;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.firebase_messaging.zzk;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.Executor;

/* compiled from: com.google.firebase:firebase-messaging@@20.0.0 */
final class zzj implements Closeable {
    private final URL zza;
    private Task<Bitmap> zzb;
    private volatile InputStream zzc;

    public static zzj zza(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return new zzj(new URL(str));
        } catch (MalformedURLException unused) {
            String valueOf = String.valueOf(str);
            Log.w("FirebaseMessaging", valueOf.length() != 0 ? "Not downloading image, bad URL: ".concat(valueOf) : new String("Not downloading image, bad URL: "));
            return null;
        }
    }

    private zzj(URL url) {
        this.zza = url;
    }

    public final void zza(Executor executor) {
        this.zzb = Tasks.call(executor, new zzi(this));
    }

    public final Task<Bitmap> zza() {
        return (Task) Preconditions.checkNotNull(this.zzb);
    }

    public final Bitmap zzb() throws IOException {
        String valueOf = String.valueOf(this.zza);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 22);
        sb.append("Starting download of: ");
        sb.append(valueOf);
        Log.i("FirebaseMessaging", sb.toString());
        byte[] zzc2 = zzc();
        Bitmap decodeByteArray = BitmapFactory.decodeByteArray(zzc2, 0, zzc2.length);
        if (decodeByteArray != null) {
            if (Log.isLoggable("FirebaseMessaging", 3)) {
                String valueOf2 = String.valueOf(this.zza);
                StringBuilder sb2 = new StringBuilder(String.valueOf(valueOf2).length() + 31);
                sb2.append("Successfully downloaded image: ");
                sb2.append(valueOf2);
                Log.d("FirebaseMessaging", sb2.toString());
            }
            return decodeByteArray;
        }
        String valueOf3 = String.valueOf(this.zza);
        StringBuilder sb3 = new StringBuilder(String.valueOf(valueOf3).length() + 24);
        sb3.append("Failed to decode image: ");
        sb3.append(valueOf3);
        throw new IOException(sb3.toString());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0068, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0069, code lost:
        if (r0 != null) goto L_0x006b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x006f, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0070, code lost:
        com.google.android.gms.internal.firebase_messaging.zzm.zza(r1, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0073, code lost:
        throw r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final byte[] zzc() throws java.io.IOException {
        /*
            r7 = this;
            java.net.URL r0 = r7.zza
            java.net.URLConnection r0 = r0.openConnection()
            int r1 = r0.getContentLength()
            r2 = 1048576(0x100000, float:1.469368E-39)
            if (r1 > r2) goto L_0x0074
            java.io.InputStream r0 = r0.getInputStream()
            r7.zzc = r0     // Catch:{ all -> 0x0066 }
            r3 = 1048577(0x100001, double:5.18066E-318)
            java.io.InputStream r1 = com.google.android.gms.internal.firebase_messaging.zzj.zza((java.io.InputStream) r0, (long) r3)     // Catch:{ all -> 0x0066 }
            byte[] r1 = com.google.android.gms.internal.firebase_messaging.zzj.zza(r1)     // Catch:{ all -> 0x0066 }
            if (r0 == 0) goto L_0x0024
            r0.close()
        L_0x0024:
            r0 = 2
            java.lang.String r3 = "FirebaseMessaging"
            boolean r0 = android.util.Log.isLoggable(r3, r0)
            if (r0 == 0) goto L_0x005a
            int r0 = r1.length
            java.net.URL r4 = r7.zza
            java.lang.String r4 = java.lang.String.valueOf(r4)
            java.lang.String r5 = java.lang.String.valueOf(r4)
            int r5 = r5.length()
            int r5 = r5 + 34
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>(r5)
            java.lang.String r5 = "Downloaded "
            r6.append(r5)
            r6.append(r0)
            java.lang.String r0 = " bytes from "
            r6.append(r0)
            r6.append(r4)
            java.lang.String r0 = r6.toString()
            android.util.Log.v(r3, r0)
        L_0x005a:
            int r0 = r1.length
            if (r0 > r2) goto L_0x005e
            return r1
        L_0x005e:
            java.io.IOException r0 = new java.io.IOException
            java.lang.String r1 = "Image exceeds max size of 1048576"
            r0.<init>(r1)
            throw r0
        L_0x0066:
            r1 = move-exception
            throw r1     // Catch:{ all -> 0x0068 }
        L_0x0068:
            r2 = move-exception
            if (r0 == 0) goto L_0x0073
            r0.close()     // Catch:{ all -> 0x006f }
            goto L_0x0073
        L_0x006f:
            r0 = move-exception
            com.google.android.gms.internal.firebase_messaging.zzm.zza(r1, r0)
        L_0x0073:
            throw r2
        L_0x0074:
            java.io.IOException r0 = new java.io.IOException
            java.lang.String r1 = "Content-Length exceeds max size of 1048576"
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.messaging.zzj.zzc():byte[]");
    }

    public final void close() {
        zzk.zza(this.zzc);
    }
}
