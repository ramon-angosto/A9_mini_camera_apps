package com.google.android.gms.security;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.common.zzc;
import com.google.android.gms.common.zze;
import java.lang.reflect.Method;

public class ProviderInstaller {
    public static final String PROVIDER_NAME = "GmsCore_OpenSSL";
    /* access modifiers changed from: private */
    public static final zzc zzbnb = zzc.zzqV();
    private static Method zzbnc = null;
    private static final Object zzrs = new Object();

    public interface ProviderInstallListener {
        void onProviderInstallFailed(int i, Intent intent);

        void onProviderInstalled();
    }

    public static void installIfNeeded(Context context) throws GooglePlayServicesRepairableException, GooglePlayServicesNotAvailableException {
        zzaa.zzb(context, (Object) "Context must not be null");
        zzbnb.zzaf(context);
        Context remoteContext = zze.getRemoteContext(context);
        if (remoteContext != null) {
            synchronized (zzrs) {
                try {
                    if (zzbnc == null) {
                        zzbf(remoteContext);
                    }
                    zzbnc.invoke((Object) null, new Object[]{remoteContext});
                } catch (Exception e) {
                    String valueOf = String.valueOf(e.getMessage());
                    Log.e("ProviderInstaller", valueOf.length() != 0 ? "Failed to install provider: ".concat(valueOf) : new String("Failed to install provider: "));
                    throw new GooglePlayServicesNotAvailableException(8);
                } catch (Throwable th) {
                    throw th;
                }
            }
            return;
        }
        Log.e("ProviderInstaller", "Failed to get remote context");
        throw new GooglePlayServicesNotAvailableException(8);
    }

    public static void installIfNeededAsync(final Context context, final ProviderInstallListener providerInstallListener) {
        zzaa.zzb(context, (Object) "Context must not be null");
        zzaa.zzb(providerInstallListener, (Object) "Listener must not be null");
        zzaa.zzdc("Must be called on the UI thread");
        new AsyncTask<Void, Void, Integer>() {
            /* access modifiers changed from: protected */
            /* renamed from: zzc */
            public Integer doInBackground(Void... voidArr) {
                int connectionStatusCode;
                try {
                    ProviderInstaller.installIfNeeded(context);
                    connectionStatusCode = 0;
                } catch (GooglePlayServicesRepairableException e) {
                    connectionStatusCode = e.getConnectionStatusCode();
                } catch (GooglePlayServicesNotAvailableException e2) {
                    connectionStatusCode = e2.errorCode;
                }
                return Integer.valueOf(connectionStatusCode);
            }

            /* access modifiers changed from: protected */
            /* renamed from: zzg */
            public void onPostExecute(Integer num) {
                if (num.intValue() == 0) {
                    providerInstallListener.onProviderInstalled();
                    return;
                }
                providerInstallListener.onProviderInstallFailed(num.intValue(), ProviderInstaller.zzbnb.zza(context, num.intValue(), "pi"));
            }
        }.execute(new Void[0]);
    }

    private static void zzbf(Context context) throws ClassNotFoundException, NoSuchMethodException {
        zzbnc = context.getClassLoader().loadClass("com.google.android.gms.common.security.ProviderInstallerImpl").getMethod("insertProvider", new Class[]{Context.class});
    }
}
