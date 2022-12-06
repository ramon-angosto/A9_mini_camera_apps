package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.content.Context;
import android.os.Bundle;
import android.os.IInterface;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.zzd;
import com.google.android.gms.common.internal.zzl;
import java.util.Set;

public abstract class zzk<T extends IInterface> extends zzd<T> implements Api.zze, zzl.zza {
    private final Account zzZB;
    private final Set<Scope> zzacF;
    private final zzg zzamS;

    protected zzk(Context context, Looper looper, int i, zzg zzg, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        this(context, looper, zzm.zzav(context), GoogleApiAvailability.getInstance(), i, zzg, (GoogleApiClient.ConnectionCallbacks) zzaa.zzz(connectionCallbacks), (GoogleApiClient.OnConnectionFailedListener) zzaa.zzz(onConnectionFailedListener));
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    protected zzk(Context context, Looper looper, zzm zzm, GoogleApiAvailability googleApiAvailability, int i, zzg zzg, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, zzm, googleApiAvailability, i, zza(connectionCallbacks), zza(onConnectionFailedListener), zzg.zztz());
        this.zzamS = zzg;
        this.zzZB = zzg.getAccount();
        this.zzacF = zza(zzg.zztw());
    }

    @Nullable
    private static zzd.zzb zza(final GoogleApiClient.ConnectionCallbacks connectionCallbacks) {
        if (connectionCallbacks == null) {
            return null;
        }
        return new zzd.zzb() {
            public void onConnected(@Nullable Bundle bundle) {
                GoogleApiClient.ConnectionCallbacks.this.onConnected(bundle);
            }

            public void onConnectionSuspended(int i) {
                GoogleApiClient.ConnectionCallbacks.this.onConnectionSuspended(i);
            }
        };
    }

    @Nullable
    private static zzd.zzc zza(final GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        if (onConnectionFailedListener == null) {
            return null;
        }
        return new zzd.zzc() {
            public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
                GoogleApiClient.OnConnectionFailedListener.this.onConnectionFailed(connectionResult);
            }
        };
    }

    private Set<Scope> zza(@NonNull Set<Scope> set) {
        Set<Scope> zzb = zzb(set);
        for (Scope contains : zzb) {
            if (!set.contains(contains)) {
                throw new IllegalStateException("Expanding scopes is not permitted, use implied scopes instead");
            }
        }
        return zzb;
    }

    public final Account getAccount() {
        return this.zzZB;
    }

    /* access modifiers changed from: protected */
    @NonNull
    public Set<Scope> zzb(@NonNull Set<Scope> set) {
        return set;
    }

    /* access modifiers changed from: protected */
    public final zzg zztH() {
        return this.zzamS;
    }

    /* access modifiers changed from: protected */
    public final Set<Scope> zzto() {
        return this.zzacF;
    }
}
