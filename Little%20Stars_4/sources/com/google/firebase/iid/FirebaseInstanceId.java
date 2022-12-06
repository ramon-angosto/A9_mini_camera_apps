package com.google.firebase.iid;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.Keep;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.WorkerThread;
import android.support.v4.util.ArrayMap;
import android.util.Base64;
import android.util.Log;
import com.google.firebase.FirebaseApp;
import java.io.IOException;
import java.security.KeyPair;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

public class FirebaseInstanceId {
    private static Map<String, FirebaseInstanceId> zzaTZ = new ArrayMap();
    private static zze zzbSC;
    private final FirebaseApp zzbSD;
    private final zzd zzbSE;
    private final String zzbSF = zzUm();

    private FirebaseInstanceId(FirebaseApp firebaseApp, zzd zzd) {
        this.zzbSD = firebaseApp;
        this.zzbSE = zzd;
        if (this.zzbSF != null) {
            FirebaseInstanceIdService.zza(this.zzbSD.getApplicationContext(), this);
            return;
        }
        throw new IllegalStateException("IID failing to initialize, FirebaseApp is missing project ID");
    }

    public static FirebaseInstanceId getInstance() {
        return getInstance(FirebaseApp.getInstance());
    }

    @Keep
    public static synchronized FirebaseInstanceId getInstance(@NonNull FirebaseApp firebaseApp) {
        FirebaseInstanceId firebaseInstanceId;
        synchronized (FirebaseInstanceId.class) {
            firebaseInstanceId = zzaTZ.get(firebaseApp.getOptions().getApplicationId());
            if (firebaseInstanceId == null) {
                zzd zzb = zzd.zzb(firebaseApp.getApplicationContext(), (Bundle) null);
                if (zzbSC == null) {
                    zzbSC = new zze(zzb.zzUs());
                }
                FirebaseInstanceId firebaseInstanceId2 = new FirebaseInstanceId(firebaseApp, zzb);
                zzaTZ.put(firebaseApp.getOptions().getApplicationId(), firebaseInstanceId2);
                firebaseInstanceId = firebaseInstanceId2;
            }
        }
        return firebaseInstanceId;
    }

    static String zza(KeyPair keyPair) {
        try {
            byte[] digest = MessageDigest.getInstance("SHA1").digest(keyPair.getPublic().getEncoded());
            digest[0] = (byte) (((digest[0] & 15) + 112) & 255);
            return Base64.encodeToString(digest, 0, 8, 11);
        } catch (NoSuchAlgorithmException unused) {
            Log.w("FirebaseInstanceId", "Unexpected error, device missing required alghorithms");
            return null;
        }
    }

    static void zza(Context context, zzg zzg) {
        zzg.zzCk();
        Intent intent = new Intent();
        intent.putExtra("CMD", "RST");
        context.sendBroadcast(FirebaseInstanceIdInternalReceiver.zzh(context, intent));
    }

    static int zzaU(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            String valueOf = String.valueOf(e);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 38);
            sb.append("Never happens: can't find own package ");
            sb.append(valueOf);
            Log.w("FirebaseInstanceId", sb.toString());
            return 0;
        }
    }

    static String zzaV(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            String valueOf = String.valueOf(e);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 38);
            sb.append("Never happens: can't find own package ");
            sb.append(valueOf);
            Log.w("FirebaseInstanceId", sb.toString());
            return null;
        }
    }

    static void zzaW(Context context) {
        Intent intent = new Intent();
        intent.setPackage(context.getPackageName());
        intent.putExtra("CMD", "SYNC");
        context.sendBroadcast(FirebaseInstanceIdInternalReceiver.zzh(context, intent));
    }

    static String zzbw(Context context) {
        return getInstance().zzbSD.getOptions().getApplicationId();
    }

    static String zzp(byte[] bArr) {
        return Base64.encodeToString(bArr, 11);
    }

    public void deleteInstanceId() throws IOException {
        this.zzbSE.zzb("*", "*", (Bundle) null);
        this.zzbSE.zzCe();
    }

    @WorkerThread
    public void deleteToken(String str, String str2) throws IOException {
        this.zzbSE.zzb(str, str2, (Bundle) null);
    }

    public long getCreationTime() {
        return this.zzbSE.getCreationTime();
    }

    public String getId() {
        return zza(this.zzbSE.zzCd());
    }

    @Nullable
    public String getToken() {
        String zzUn = zzUn();
        if (zzUn == null) {
            FirebaseInstanceIdService.zzbx(this.zzbSD.getApplicationContext());
        }
        return zzUn;
    }

    @WorkerThread
    public String getToken(String str, String str2) throws IOException {
        return this.zzbSE.getToken(str, str2, (Bundle) null);
    }

    /* access modifiers changed from: package-private */
    public String zzUm() {
        String gcmSenderId = this.zzbSD.getOptions().getGcmSenderId();
        if (gcmSenderId != null) {
            return gcmSenderId;
        }
        String applicationId = this.zzbSD.getOptions().getApplicationId();
        if (applicationId.startsWith("1:")) {
            String[] split = applicationId.split(":");
            if (split.length < 2) {
                return null;
            }
            applicationId = split[1];
            if (applicationId.isEmpty()) {
                return null;
            }
        }
        return applicationId;
    }

    /* access modifiers changed from: package-private */
    @Nullable
    public String zzUn() {
        return this.zzbSE.zzUs().zzi("", this.zzbSF, "*");
    }

    /* access modifiers changed from: package-private */
    public String zzUo() throws IOException {
        return getToken(this.zzbSF, "*");
    }

    /* access modifiers changed from: package-private */
    public zze zzUp() {
        return zzbSC;
    }

    /* access modifiers changed from: package-private */
    public void zziA(String str) throws IOException {
        if (getToken() != null) {
            Bundle bundle = new Bundle();
            String valueOf = String.valueOf(str);
            bundle.putString("gcm.topic", valueOf.length() != 0 ? "/topics/".concat(valueOf) : new String("/topics/"));
            zzd zzd = this.zzbSE;
            String token = getToken();
            String valueOf2 = String.valueOf(str);
            zzd.zzb(token, valueOf2.length() != 0 ? "/topics/".concat(valueOf2) : new String("/topics/"), bundle);
            return;
        }
        throw new IOException("token not available");
    }

    public void zziy(String str) {
        zzbSC.zziy(str);
        FirebaseInstanceIdService.zzbx(this.zzbSD.getApplicationContext());
    }

    /* access modifiers changed from: package-private */
    public void zziz(String str) throws IOException {
        if (getToken() != null) {
            Bundle bundle = new Bundle();
            String valueOf = String.valueOf(str);
            bundle.putString("gcm.topic", valueOf.length() != 0 ? "/topics/".concat(valueOf) : new String("/topics/"));
            zzd zzd = this.zzbSE;
            String token = getToken();
            String valueOf2 = String.valueOf(str);
            zzd.getToken(token, valueOf2.length() != 0 ? "/topics/".concat(valueOf2) : new String("/topics/"), bundle);
            return;
        }
        throw new IOException("token not available");
    }
}
