package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.clearcut.LogEventParcelable;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.zzg;
import com.google.android.gms.common.internal.zzk;
import com.google.android.gms.internal.zzno;

public class zznm extends zzk<zzno> {
    public zznm(Context context, Looper looper, zzg zzg, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 40, zzg, connectionCallbacks, onConnectionFailedListener);
    }

    public void zza(zznn zznn, LogEventParcelable logEventParcelable) throws RemoteException {
        ((zzno) zztm()).zza(zznn, logEventParcelable);
    }

    /* access modifiers changed from: protected */
    /* renamed from: zzaO */
    public zzno zzab(IBinder iBinder) {
        return zzno.zza.zzaQ(iBinder);
    }

    /* access modifiers changed from: protected */
    public String zzhT() {
        return "com.google.android.gms.clearcut.service.START";
    }

    /* access modifiers changed from: protected */
    public String zzhU() {
        return "com.google.android.gms.clearcut.internal.IClearcutLoggerService";
    }
}
