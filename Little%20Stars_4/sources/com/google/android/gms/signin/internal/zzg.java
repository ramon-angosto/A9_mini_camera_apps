package com.google.android.gms.signin.internal;

import android.accounts.Account;
import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.ResolveAccountRequest;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.common.internal.zzd;
import com.google.android.gms.common.internal.zzk;
import com.google.android.gms.common.internal.zzq;
import com.google.android.gms.internal.zztv;
import com.google.android.gms.internal.zztw;
import com.google.android.gms.signin.internal.zze;

public class zzg extends zzk<zze> implements zztv {
    private final com.google.android.gms.common.internal.zzg zzamS;
    private Integer zzarr;
    private final boolean zzbnn;
    private final Bundle zzbno;

    public zzg(Context context, Looper looper, boolean z, com.google.android.gms.common.internal.zzg zzg, Bundle bundle, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 44, zzg, connectionCallbacks, onConnectionFailedListener);
        this.zzbnn = z;
        this.zzamS = zzg;
        this.zzbno = bundle;
        this.zzarr = zzg.zztC();
    }

    public zzg(Context context, Looper looper, boolean z, com.google.android.gms.common.internal.zzg zzg, zztw zztw, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        this(context, looper, z, zzg, zza(zzg), connectionCallbacks, onConnectionFailedListener);
    }

    private ResolveAccountRequest zzIW() {
        Account zztk = this.zzamS.zztk();
        return new ResolveAccountRequest(zztk, this.zzarr.intValue(), "<<default account>>".equals(zztk.name) ? com.google.android.gms.auth.api.signin.internal.zzk.zzab(getContext()).zzpC() : null);
    }

    public static Bundle zza(com.google.android.gms.common.internal.zzg zzg) {
        zztw zztB = zzg.zztB();
        Integer zztC = zzg.zztC();
        Bundle bundle = new Bundle();
        bundle.putParcelable("com.google.android.gms.signin.internal.clientRequestedAccount", zzg.getAccount());
        if (zztC != null) {
            bundle.putInt("com.google.android.gms.common.internal.ClientSettings.sessionId", zztC.intValue());
        }
        if (zztB != null) {
            bundle.putBoolean("com.google.android.gms.signin.internal.offlineAccessRequested", zztB.zzIQ());
            bundle.putBoolean("com.google.android.gms.signin.internal.idTokenRequested", zztB.zzpk());
            bundle.putString("com.google.android.gms.signin.internal.serverClientId", zztB.zzpn());
            bundle.putBoolean("com.google.android.gms.signin.internal.usePromptModeForAuthCode", true);
            bundle.putBoolean("com.google.android.gms.signin.internal.forceCodeForRefreshToken", zztB.zzpm());
            bundle.putString("com.google.android.gms.signin.internal.hostedDomain", zztB.zzpo());
            bundle.putBoolean("com.google.android.gms.signin.internal.waitForAccessTokenRefresh", zztB.zzIR());
        }
        return bundle;
    }

    public void connect() {
        zza((zzd.zzf) new zzd.zzi());
    }

    public void zzIP() {
        try {
            ((zze) zztm()).zzkJ(this.zzarr.intValue());
        } catch (RemoteException unused) {
            Log.w("SignInClientImpl", "Remote service probably died when clearAccountFromSessionStore is called");
        }
    }

    public void zza(zzq zzq, boolean z) {
        try {
            ((zze) zztm()).zza(zzq, this.zzarr.intValue(), z);
        } catch (RemoteException unused) {
            Log.w("SignInClientImpl", "Remote service probably died when saveDefaultAccount is called");
        }
    }

    public void zza(zzd zzd) {
        zzaa.zzb(zzd, (Object) "Expecting a valid ISignInCallbacks");
        try {
            ((zze) zztm()).zza(new SignInRequest(zzIW()), zzd);
        } catch (RemoteException e) {
            Log.w("SignInClientImpl", "Remote service probably died when signIn is called");
            try {
                zzd.zzb(new SignInResponse(8));
            } catch (RemoteException unused) {
                Log.wtf("SignInClientImpl", "ISignInCallbacks#onSignInComplete should be executed from the same process, unexpected RemoteException.", e);
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: zzef */
    public zze zzab(IBinder iBinder) {
        return zze.zza.zzee(iBinder);
    }

    /* access modifiers changed from: protected */
    public String zzhT() {
        return "com.google.android.gms.signin.service.START";
    }

    /* access modifiers changed from: protected */
    public String zzhU() {
        return "com.google.android.gms.signin.internal.ISignInService";
    }

    /* access modifiers changed from: protected */
    public Bundle zzoO() {
        if (!getContext().getPackageName().equals(this.zzamS.zzty())) {
            this.zzbno.putString("com.google.android.gms.signin.internal.realClientPackageName", this.zzamS.zzty());
        }
        return this.zzbno;
    }

    public boolean zzpd() {
        return this.zzbnn;
    }
}
