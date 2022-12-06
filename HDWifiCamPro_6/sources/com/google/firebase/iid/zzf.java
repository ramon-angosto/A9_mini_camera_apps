package com.google.firebase.iid;

import android.os.Build;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.util.Log;

/* compiled from: com.google.firebase:firebase-iid@@20.0.0 */
public class zzf implements Parcelable {
    public static final Parcelable.Creator<zzf> CREATOR = new zze();
    private Messenger zza;
    private zzo zzb;

    /* compiled from: com.google.firebase:firebase-iid@@20.0.0 */
    public static final class zza extends ClassLoader {
        /* access modifiers changed from: protected */
        public final Class<?> loadClass(String str, boolean z) throws ClassNotFoundException {
            if (!"com.google.android.gms.iid.MessengerCompat".equals(str)) {
                return super.loadClass(str, z);
            }
            if (!FirebaseInstanceId.zzd()) {
                return zzf.class;
            }
            Log.d("FirebaseInstanceId", "Using renamed FirebaseIidMessengerCompat class");
            return zzf.class;
        }
    }

    public zzf(IBinder iBinder) {
        if (Build.VERSION.SDK_INT >= 21) {
            this.zza = new Messenger(iBinder);
        } else {
            this.zzb = new zzr(iBinder);
        }
    }

    public int describeContents() {
        return 0;
    }

    public final void zza(Message message) throws RemoteException {
        Messenger messenger = this.zza;
        if (messenger != null) {
            messenger.send(message);
        } else {
            this.zzb.zza(message);
        }
    }

    private final IBinder zza() {
        Messenger messenger = this.zza;
        return messenger != null ? messenger.getBinder() : this.zzb.asBinder();
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        try {
            return zza().equals(((zzf) obj).zza());
        } catch (ClassCastException unused) {
            return false;
        }
    }

    public int hashCode() {
        return zza().hashCode();
    }

    public void writeToParcel(Parcel parcel, int i) {
        Messenger messenger = this.zza;
        if (messenger != null) {
            parcel.writeStrongBinder(messenger.getBinder());
        } else {
            parcel.writeStrongBinder(this.zzb.asBinder());
        }
    }
}
