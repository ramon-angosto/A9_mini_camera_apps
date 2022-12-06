package com.google.android.gms.internal.ads;

import com.mbridge.msdk.foundation.tools.SameMD5;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.CountDownLatch;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzans implements Runnable {
    private zzans() {
    }

    /* synthetic */ zzans(zzanr zzanr) {
    }

    public final void run() {
        CountDownLatch countDownLatch;
        try {
            zzant.zzc = MessageDigest.getInstance(SameMD5.TAG);
            countDownLatch = zzant.zzb;
        } catch (NoSuchAlgorithmException unused) {
            countDownLatch = zzant.zzb;
        } catch (Throwable th) {
            zzant.zzb.countDown();
            throw th;
        }
        countDownLatch.countDown();
    }
}
