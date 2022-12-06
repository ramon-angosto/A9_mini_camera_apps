package com.google.firebase.messaging;

import android.content.Context;
import java.util.concurrent.Executor;

/* compiled from: com.google.firebase:firebase-messaging@@20.0.0 */
final class zzd {
    private final Executor zza;
    private final Context zzb;
    private final zzk zzc;

    public zzd(Context context, zzk zzk, Executor executor) {
        this.zza = executor;
        this.zzb = context;
        this.zzc = zzk;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x005b A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x005c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zza() {
        /*
            r10 = this;
            com.google.firebase.messaging.zzk r0 = r10.zzc
            java.lang.String r1 = "gcm.n.noui"
            boolean r0 = r0.zzb(r1)
            r1 = 1
            if (r0 == 0) goto L_0x000c
            return r1
        L_0x000c:
            android.content.Context r0 = r10.zzb
            java.lang.String r2 = "keyguard"
            java.lang.Object r0 = r0.getSystemService(r2)
            android.app.KeyguardManager r0 = (android.app.KeyguardManager) r0
            boolean r0 = r0.inKeyguardRestrictedInputMode()
            r2 = 0
            if (r0 != 0) goto L_0x0058
            boolean r0 = com.google.android.gms.common.util.PlatformVersion.isAtLeastLollipop()
            if (r0 != 0) goto L_0x0028
            r3 = 10
            android.os.SystemClock.sleep(r3)
        L_0x0028:
            int r0 = android.os.Process.myPid()
            android.content.Context r3 = r10.zzb
            java.lang.String r4 = "activity"
            java.lang.Object r3 = r3.getSystemService(r4)
            android.app.ActivityManager r3 = (android.app.ActivityManager) r3
            java.util.List r3 = r3.getRunningAppProcesses()
            if (r3 == 0) goto L_0x0058
            java.util.Iterator r3 = r3.iterator()
        L_0x0040:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x0058
            java.lang.Object r4 = r3.next()
            android.app.ActivityManager$RunningAppProcessInfo r4 = (android.app.ActivityManager.RunningAppProcessInfo) r4
            int r5 = r4.pid
            if (r5 != r0) goto L_0x0040
            int r0 = r4.importance
            r3 = 100
            if (r0 != r3) goto L_0x0058
            r0 = r1
            goto L_0x0059
        L_0x0058:
            r0 = r2
        L_0x0059:
            if (r0 == 0) goto L_0x005c
            return r2
        L_0x005c:
            com.google.firebase.messaging.zzk r0 = r10.zzc
            java.lang.String r3 = "gcm.n.image"
            java.lang.String r0 = r0.zza((java.lang.String) r3)
            com.google.firebase.messaging.zzj r0 = com.google.firebase.messaging.zzj.zza((java.lang.String) r0)
            if (r0 == 0) goto L_0x006f
            java.util.concurrent.Executor r3 = r10.zza
            r0.zza((java.util.concurrent.Executor) r3)
        L_0x006f:
            android.content.Context r3 = r10.zzb
            com.google.firebase.messaging.zzk r4 = r10.zzc
            com.google.firebase.messaging.zza r3 = com.google.firebase.messaging.zzb.zza((android.content.Context) r3, (com.google.firebase.messaging.zzk) r4)
            androidx.core.app.NotificationCompat$Builder r4 = r3.zza
            java.lang.String r5 = "FirebaseMessaging"
            if (r0 == 0) goto L_0x00e0
            com.google.android.gms.tasks.Task r6 = r0.zza()     // Catch:{ ExecutionException -> 0x00b9, InterruptedException -> 0x00a9, TimeoutException -> 0x00a0 }
            r7 = 5
            java.util.concurrent.TimeUnit r9 = java.util.concurrent.TimeUnit.SECONDS     // Catch:{ ExecutionException -> 0x00b9, InterruptedException -> 0x00a9, TimeoutException -> 0x00a0 }
            java.lang.Object r6 = com.google.android.gms.tasks.Tasks.await(r6, r7, r9)     // Catch:{ ExecutionException -> 0x00b9, InterruptedException -> 0x00a9, TimeoutException -> 0x00a0 }
            android.graphics.Bitmap r6 = (android.graphics.Bitmap) r6     // Catch:{ ExecutionException -> 0x00b9, InterruptedException -> 0x00a9, TimeoutException -> 0x00a0 }
            r4.setLargeIcon(r6)     // Catch:{ ExecutionException -> 0x00b9, InterruptedException -> 0x00a9, TimeoutException -> 0x00a0 }
            androidx.core.app.NotificationCompat$BigPictureStyle r7 = new androidx.core.app.NotificationCompat$BigPictureStyle     // Catch:{ ExecutionException -> 0x00b9, InterruptedException -> 0x00a9, TimeoutException -> 0x00a0 }
            r7.<init>()     // Catch:{ ExecutionException -> 0x00b9, InterruptedException -> 0x00a9, TimeoutException -> 0x00a0 }
            androidx.core.app.NotificationCompat$BigPictureStyle r6 = r7.bigPicture(r6)     // Catch:{ ExecutionException -> 0x00b9, InterruptedException -> 0x00a9, TimeoutException -> 0x00a0 }
            r7 = 0
            androidx.core.app.NotificationCompat$BigPictureStyle r6 = r6.bigLargeIcon(r7)     // Catch:{ ExecutionException -> 0x00b9, InterruptedException -> 0x00a9, TimeoutException -> 0x00a0 }
            r4.setStyle(r6)     // Catch:{ ExecutionException -> 0x00b9, InterruptedException -> 0x00a9, TimeoutException -> 0x00a0 }
            goto L_0x00e0
        L_0x00a0:
            java.lang.String r4 = "Failed to download image in time, showing notification without it"
            android.util.Log.w(r5, r4)
            r0.close()
            goto L_0x00e0
        L_0x00a9:
            java.lang.String r4 = "Interrupted while downloading image, showing notification without it"
            android.util.Log.w(r5, r4)
            r0.close()
            java.lang.Thread r0 = java.lang.Thread.currentThread()
            r0.interrupt()
            goto L_0x00e0
        L_0x00b9:
            r0 = move-exception
            java.lang.Throwable r0 = r0.getCause()
            java.lang.String r0 = java.lang.String.valueOf(r0)
            java.lang.String r4 = java.lang.String.valueOf(r0)
            int r4 = r4.length()
            int r4 = r4 + 26
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>(r4)
            java.lang.String r4 = "Failed to download image: "
            r6.append(r4)
            r6.append(r0)
            java.lang.String r0 = r6.toString()
            android.util.Log.w(r5, r0)
        L_0x00e0:
            r0 = 3
            boolean r0 = android.util.Log.isLoggable(r5, r0)
            if (r0 == 0) goto L_0x00ec
            java.lang.String r0 = "Showing notification"
            android.util.Log.d(r5, r0)
        L_0x00ec:
            android.content.Context r0 = r10.zzb
            java.lang.String r4 = "notification"
            java.lang.Object r0 = r0.getSystemService(r4)
            android.app.NotificationManager r0 = (android.app.NotificationManager) r0
            java.lang.String r4 = r3.zzb
            androidx.core.app.NotificationCompat$Builder r3 = r3.zza
            android.app.Notification r3 = r3.build()
            r0.notify(r4, r2, r3)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.messaging.zzd.zza():boolean");
    }
}
