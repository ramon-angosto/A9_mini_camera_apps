package com.google.firebase.iid;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.PowerManager;
import android.util.Log;
import com.google.firebase.FirebaseApp;
import java.io.IOException;

/* compiled from: com.google.firebase:firebase-iid@@20.0.0 */
final class zzav implements Runnable {
    private final long zza;
    private final PowerManager.WakeLock zzb = ((PowerManager) zza().getSystemService("power")).newWakeLock(1, "fiid-sync");
    private final FirebaseInstanceId zzc;
    private final zzax zzd;

    zzav(FirebaseInstanceId firebaseInstanceId, zzai zzai, zzax zzax, long j) {
        this.zzc = firebaseInstanceId;
        this.zzd = zzax;
        this.zza = j;
        this.zzb.setReferenceCounted(false);
    }

    public final void run() {
        if (zzaq.zza().zza(zza())) {
            this.zzb.acquire();
        }
        try {
            this.zzc.zza(true);
            if (!this.zzc.zzf()) {
                this.zzc.zza(false);
                if (zzaq.zza().zza(zza())) {
                    this.zzb.release();
                }
            } else if (!zzaq.zza().zzb(zza()) || zzb()) {
                if (!zzc() || !this.zzd.zza(this.zzc)) {
                    this.zzc.zza(this.zza);
                } else {
                    this.zzc.zza(false);
                }
                if (zzaq.zza().zza(zza())) {
                    this.zzb.release();
                }
            } else {
                new zzau(this).zza();
                if (zzaq.zza().zza(zza())) {
                    this.zzb.release();
                }
            }
        } catch (IOException e) {
            String message = e.getMessage();
            StringBuilder sb = new StringBuilder(String.valueOf(message).length() + 93);
            sb.append("Topic sync or token retrieval failed on hard failure exceptions: ");
            sb.append(message);
            sb.append(". Won't retry the operation.");
            Log.e("FirebaseInstanceId", sb.toString());
            this.zzc.zza(false);
            if (zzaq.zza().zza(zza())) {
                this.zzb.release();
            }
        } catch (Throwable th) {
            if (zzaq.zza().zza(zza())) {
                this.zzb.release();
            }
            throw th;
        }
    }

    private final boolean zzc() throws IOException {
        zzas zzb2 = this.zzc.zzb();
        if (!this.zzc.zza(zzb2)) {
            return true;
        }
        try {
            String zzc2 = this.zzc.zzc();
            if (zzc2 == null) {
                Log.e("FirebaseInstanceId", "Token retrieval failed: null");
                return false;
            }
            if (Log.isLoggable("FirebaseInstanceId", 3)) {
                Log.d("FirebaseInstanceId", "Token successfully retrieved");
            }
            if ((zzb2 == null || (zzb2 != null && !zzc2.equals(zzb2.zza))) && FirebaseApp.DEFAULT_APP_NAME.equals(this.zzc.zza().getName())) {
                if (Log.isLoggable("FirebaseInstanceId", 3)) {
                    String valueOf = String.valueOf(this.zzc.zza().getName());
                    Log.d("FirebaseInstanceId", valueOf.length() != 0 ? "Invoking onNewToken for app: ".concat(valueOf) : new String("Invoking onNewToken for app: "));
                }
                Intent intent = new Intent("com.google.firebase.messaging.NEW_TOKEN");
                intent.putExtra("token", zzc2);
                Context zza2 = zza();
                Intent intent2 = new Intent(zza2, FirebaseInstanceIdReceiver.class);
                intent2.setAction("com.google.firebase.MESSAGING_EVENT");
                intent2.putExtra("wrapped_intent", intent);
                zza2.sendBroadcast(intent2);
            }
            return true;
        } catch (IOException e) {
            if ("SERVICE_NOT_AVAILABLE".equals(e.getMessage()) || "INTERNAL_SERVER_ERROR".equals(e.getMessage())) {
                Log.e("FirebaseInstanceId", "Token retrieval failed without exception message. Will retry token retrieval");
                return false;
            } else if (e.getMessage() == null) {
                String message = e.getMessage();
                StringBuilder sb = new StringBuilder(String.valueOf(message).length() + 52);
                sb.append("Token retrieval failed: ");
                sb.append(message);
                sb.append(". Will retry token retrieval");
                Log.e("FirebaseInstanceId", sb.toString());
                return false;
            } else {
                throw e;
            }
        } catch (SecurityException unused) {
            Log.e("FirebaseInstanceId", "Token retrieval failed with SecurityException. Will retry token retrieval");
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    public final Context zza() {
        return this.zzc.zza().getApplicationContext();
    }

    /* access modifiers changed from: package-private */
    public final boolean zzb() {
        ConnectivityManager connectivityManager = (ConnectivityManager) zza().getSystemService("connectivity");
        NetworkInfo activeNetworkInfo = connectivityManager != null ? connectivityManager.getActiveNetworkInfo() : null;
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }
}
