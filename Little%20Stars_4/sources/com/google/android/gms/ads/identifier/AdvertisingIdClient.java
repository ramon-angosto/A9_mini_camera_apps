package com.google.android.gms.ads.identifier;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.common.stats.zzb;
import com.google.android.gms.common.zzc;
import com.google.android.gms.internal.zzbu;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class AdvertisingIdClient {
    private final Context mContext;
    com.google.android.gms.common.zza zzpE;
    zzbu zzpF;
    boolean zzpG;
    Object zzpH;
    zza zzpI;
    final long zzpJ;

    public static final class Info {
        private final String zzpO;
        private final boolean zzpP;

        public Info(String str, boolean z) {
            this.zzpO = str;
            this.zzpP = z;
        }

        public String getId() {
            return this.zzpO;
        }

        public boolean isLimitAdTrackingEnabled() {
            return this.zzpP;
        }

        public String toString() {
            String str = this.zzpO;
            boolean z = this.zzpP;
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 7);
            sb.append("{");
            sb.append(str);
            sb.append("}");
            sb.append(z);
            return sb.toString();
        }
    }

    static class zza extends Thread {
        private WeakReference<AdvertisingIdClient> zzpK;
        private long zzpL;
        CountDownLatch zzpM = new CountDownLatch(1);
        boolean zzpN = false;

        public zza(AdvertisingIdClient advertisingIdClient, long j) {
            this.zzpK = new WeakReference<>(advertisingIdClient);
            this.zzpL = j;
            start();
        }

        private void disconnect() {
            AdvertisingIdClient advertisingIdClient = (AdvertisingIdClient) this.zzpK.get();
            if (advertisingIdClient != null) {
                advertisingIdClient.finish();
                this.zzpN = true;
            }
        }

        public void cancel() {
            this.zzpM.countDown();
        }

        public void run() {
            try {
                if (!this.zzpM.await(this.zzpL, TimeUnit.MILLISECONDS)) {
                    disconnect();
                }
            } catch (InterruptedException unused) {
                disconnect();
            }
        }

        public boolean zzbe() {
            return this.zzpN;
        }
    }

    public AdvertisingIdClient(Context context) {
        this(context, 30000);
    }

    public AdvertisingIdClient(Context context, long j) {
        this.zzpH = new Object();
        zzaa.zzz(context);
        this.mContext = context;
        this.zzpG = false;
        this.zzpJ = j;
    }

    public static Info getAdvertisingIdInfo(Context context) throws IOException, IllegalStateException, GooglePlayServicesNotAvailableException, GooglePlayServicesRepairableException {
        AdvertisingIdClient advertisingIdClient = new AdvertisingIdClient(context, -1);
        try {
            advertisingIdClient.zzd(false);
            return advertisingIdClient.getInfo();
        } finally {
            advertisingIdClient.finish();
        }
    }

    public static void setShouldSkipGmsCoreVersionCheck(boolean z) {
    }

    static zzbu zza(Context context, com.google.android.gms.common.zza zza2) throws IOException {
        try {
            return zzbu.zza.zzf(zza2.zza(10000, TimeUnit.MILLISECONDS));
        } catch (InterruptedException unused) {
            throw new IOException("Interrupted exception");
        } catch (Throwable th) {
            throw new IOException(th);
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(7:2|3|(3:5|6|7)|8|9|(1:11)|12) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:8:0x0011 */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0019  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void zzbd() {
        /*
            r6 = this;
            java.lang.Object r0 = r6.zzpH
            monitor-enter(r0)
            com.google.android.gms.ads.identifier.AdvertisingIdClient$zza r1 = r6.zzpI     // Catch:{ all -> 0x0024 }
            if (r1 == 0) goto L_0x0011
            com.google.android.gms.ads.identifier.AdvertisingIdClient$zza r1 = r6.zzpI     // Catch:{ all -> 0x0024 }
            r1.cancel()     // Catch:{ all -> 0x0024 }
            com.google.android.gms.ads.identifier.AdvertisingIdClient$zza r1 = r6.zzpI     // Catch:{ InterruptedException -> 0x0011 }
            r1.join()     // Catch:{ InterruptedException -> 0x0011 }
        L_0x0011:
            long r1 = r6.zzpJ     // Catch:{ all -> 0x0024 }
            r3 = 0
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 <= 0) goto L_0x0022
            com.google.android.gms.ads.identifier.AdvertisingIdClient$zza r1 = new com.google.android.gms.ads.identifier.AdvertisingIdClient$zza     // Catch:{ all -> 0x0024 }
            long r2 = r6.zzpJ     // Catch:{ all -> 0x0024 }
            r1.<init>(r6, r2)     // Catch:{ all -> 0x0024 }
            r6.zzpI = r1     // Catch:{ all -> 0x0024 }
        L_0x0022:
            monitor-exit(r0)     // Catch:{ all -> 0x0024 }
            return
        L_0x0024:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0024 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.identifier.AdvertisingIdClient.zzbd():void");
    }

    static com.google.android.gms.common.zza zzh(Context context) throws IOException, GooglePlayServicesNotAvailableException, GooglePlayServicesRepairableException {
        try {
            context.getPackageManager().getPackageInfo("com.android.vending", 0);
            int isGooglePlayServicesAvailable = zzc.zzqV().isGooglePlayServicesAvailable(context);
            if (isGooglePlayServicesAvailable == 0 || isGooglePlayServicesAvailable == 2) {
                com.google.android.gms.common.zza zza2 = new com.google.android.gms.common.zza();
                Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
                intent.setPackage("com.google.android.gms");
                try {
                    if (zzb.zzuH().zza(context, intent, (ServiceConnection) zza2, 1)) {
                        return zza2;
                    }
                    throw new IOException("Connection failure");
                } catch (Throwable th) {
                    throw new IOException(th);
                }
            } else {
                throw new IOException("Google Play services not available");
            }
        } catch (PackageManager.NameNotFoundException unused) {
            throw new GooglePlayServicesNotAvailableException(9);
        }
    }

    /* access modifiers changed from: protected */
    public void finalize() throws Throwable {
        finish();
        super.finalize();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0032, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void finish() {
        /*
            r3 = this;
            java.lang.String r0 = "Calling this from your main thread can lead to deadlock"
            com.google.android.gms.common.internal.zzaa.zzdd(r0)
            monitor-enter(r3)
            android.content.Context r0 = r3.mContext     // Catch:{ all -> 0x0033 }
            if (r0 == 0) goto L_0x0031
            com.google.android.gms.common.zza r0 = r3.zzpE     // Catch:{ all -> 0x0033 }
            if (r0 != 0) goto L_0x000f
            goto L_0x0031
        L_0x000f:
            boolean r0 = r3.zzpG     // Catch:{ IllegalArgumentException -> 0x001f }
            if (r0 == 0) goto L_0x0027
            com.google.android.gms.common.stats.zzb r0 = com.google.android.gms.common.stats.zzb.zzuH()     // Catch:{ IllegalArgumentException -> 0x001f }
            android.content.Context r1 = r3.mContext     // Catch:{ IllegalArgumentException -> 0x001f }
            com.google.android.gms.common.zza r2 = r3.zzpE     // Catch:{ IllegalArgumentException -> 0x001f }
            r0.zza((android.content.Context) r1, (android.content.ServiceConnection) r2)     // Catch:{ IllegalArgumentException -> 0x001f }
            goto L_0x0027
        L_0x001f:
            r0 = move-exception
            java.lang.String r1 = "AdvertisingIdClient"
            java.lang.String r2 = "AdvertisingIdClient unbindService failed."
            android.util.Log.i(r1, r2, r0)     // Catch:{ all -> 0x0033 }
        L_0x0027:
            r0 = 0
            r3.zzpG = r0     // Catch:{ all -> 0x0033 }
            r0 = 0
            r3.zzpF = r0     // Catch:{ all -> 0x0033 }
            r3.zzpE = r0     // Catch:{ all -> 0x0033 }
            monitor-exit(r3)     // Catch:{ all -> 0x0033 }
            return
        L_0x0031:
            monitor-exit(r3)     // Catch:{ all -> 0x0033 }
            return
        L_0x0033:
            r0 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x0033 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.identifier.AdvertisingIdClient.finish():void");
    }

    public Info getInfo() throws IOException {
        Info info;
        zzaa.zzdd("Calling this from your main thread can lead to deadlock");
        synchronized (this) {
            if (!this.zzpG) {
                synchronized (this.zzpH) {
                    if (this.zzpI == null || !this.zzpI.zzbe()) {
                        throw new IOException("AdvertisingIdClient is not connected.");
                    }
                }
                try {
                    zzd(false);
                    if (!this.zzpG) {
                        throw new IOException("AdvertisingIdClient cannot reconnect.");
                    }
                } catch (RemoteException e) {
                    Log.i("AdvertisingIdClient", "GMS remote exception ", e);
                    throw new IOException("Remote exception");
                } catch (Exception e2) {
                    throw new IOException("AdvertisingIdClient cannot reconnect.", e2);
                }
            }
            zzaa.zzz(this.zzpE);
            zzaa.zzz(this.zzpF);
            info = new Info(this.zzpF.getId(), this.zzpF.zze(true));
        }
        zzbd();
        return info;
    }

    public void start() throws IOException, IllegalStateException, GooglePlayServicesNotAvailableException, GooglePlayServicesRepairableException {
        zzd(true);
    }

    /* access modifiers changed from: protected */
    public void zzd(boolean z) throws IOException, IllegalStateException, GooglePlayServicesNotAvailableException, GooglePlayServicesRepairableException {
        zzaa.zzdd("Calling this from your main thread can lead to deadlock");
        synchronized (this) {
            if (this.zzpG) {
                finish();
            }
            this.zzpE = zzh(this.mContext);
            this.zzpF = zza(this.mContext, this.zzpE);
            this.zzpG = true;
            if (z) {
                zzbd();
            }
        }
    }
}
