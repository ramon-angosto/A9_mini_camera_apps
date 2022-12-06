package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.zzq;
import com.google.android.gms.common.zzc;
import java.util.Collection;

public class GetServiceRequest extends AbstractSafeParcelable {
    public static final Parcelable.Creator<GetServiceRequest> CREATOR = new zzj();
    final int version;
    String zzarA;
    IBinder zzarB;
    Scope[] zzarC;
    Bundle zzarD;
    Account zzarE;
    long zzarF;
    final int zzary;
    int zzarz;

    public GetServiceRequest(int i) {
        this.version = 3;
        this.zzarz = zzc.GOOGLE_PLAY_SERVICES_VERSION_CODE;
        this.zzary = i;
    }

    GetServiceRequest(int i, int i2, int i3, String str, IBinder iBinder, Scope[] scopeArr, Bundle bundle, Account account, long j) {
        this.version = i;
        this.zzary = i2;
        this.zzarz = i3;
        this.zzarA = str;
        if (i < 2) {
            this.zzarE = zzaS(iBinder);
        } else {
            this.zzarB = iBinder;
            this.zzarE = account;
        }
        this.zzarC = scopeArr;
        this.zzarD = bundle;
        this.zzarF = j;
    }

    private Account zzaS(IBinder iBinder) {
        if (iBinder != null) {
            return zza.zza(zzq.zza.zzaT(iBinder));
        }
        return null;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzj.zza(this, parcel, i);
    }

    public GetServiceRequest zzb(zzq zzq) {
        if (zzq != null) {
            this.zzarB = zzq.asBinder();
        }
        return this;
    }

    public GetServiceRequest zzc(Account account) {
        this.zzarE = account;
        return this;
    }

    public GetServiceRequest zzd(Collection<Scope> collection) {
        this.zzarC = (Scope[]) collection.toArray(new Scope[collection.size()]);
        return this;
    }

    public GetServiceRequest zzdf(String str) {
        this.zzarA = str;
        return this;
    }

    public GetServiceRequest zzl(Bundle bundle) {
        this.zzarD = bundle;
        return this;
    }
}
