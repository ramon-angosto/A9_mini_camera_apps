package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.content.Context;
import android.os.Binder;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.internal.zzq;
import com.google.android.gms.common.zze;

public class zza extends zzq.zza {
    int zzaqn;

    public static Account zza(zzq zzq) {
        if (zzq != null) {
            long clearCallingIdentity = Binder.clearCallingIdentity();
            try {
                return zzq.getAccount();
            } catch (RemoteException unused) {
                Log.w("AccountAccessor", "Remote account accessor probably died");
            } finally {
                Binder.restoreCallingIdentity(clearCallingIdentity);
            }
        }
        return null;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zza)) {
            return false;
        }
        zza zza = (zza) obj;
        Account account = null;
        return account.equals(account);
    }

    public Account getAccount() {
        int callingUid = Binder.getCallingUid();
        if (callingUid == this.zzaqn) {
            return null;
        }
        if (zze.zze((Context) null, callingUid)) {
            this.zzaqn = callingUid;
            return null;
        }
        throw new SecurityException("Caller is not GooglePlayServices");
    }
}
