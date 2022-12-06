package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import android.os.DeadObjectException;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-base@@18.0.0 */
public final class zaaj implements zabf {
    /* access modifiers changed from: private */
    public final zabi zaa;
    private boolean zab = false;

    public zaaj(zabi zabi) {
        this.zaa = zabi;
    }

    public final <A extends Api.AnyClient, R extends Result, T extends BaseImplementation.ApiMethodImpl<R, A>> T zaa(T t) {
        zab(t);
        return t;
    }

    public final <A extends Api.AnyClient, T extends BaseImplementation.ApiMethodImpl<? extends Result, A>> T zab(T t) {
        try {
            this.zaa.zag.zai.zaa(t);
            zabe zabe = this.zaa.zag;
            Api.Client client = zabe.zac.get(t.getClientKey());
            Preconditions.checkNotNull(client, "Appropriate Api was not requested.");
            if (client.isConnected() || !this.zaa.zab.containsKey(t.getClientKey())) {
                t.run(client);
            } else {
                t.setFailedResult(new Status(17));
            }
        } catch (DeadObjectException unused) {
            this.zaa.zal(new zaah(this, this));
        }
        return t;
    }

    public final void zad() {
    }

    public final void zae() {
        if (this.zab) {
            this.zab = false;
            this.zaa.zal(new zaai(this, this));
        }
    }

    /* access modifiers changed from: package-private */
    public final void zaf() {
        if (this.zab) {
            this.zab = false;
            this.zaa.zag.zai.zab();
            zaj();
        }
    }

    public final void zag(Bundle bundle) {
    }

    public final void zah(ConnectionResult connectionResult, Api<?> api, boolean z) {
    }

    public final void zai(int i) {
        this.zaa.zak((ConnectionResult) null);
        this.zaa.zah.zac(i, this.zab);
    }

    public final boolean zaj() {
        if (this.zab) {
            return false;
        }
        Set<zada> set = this.zaa.zag.zah;
        if (set == null || set.isEmpty()) {
            this.zaa.zak((ConnectionResult) null);
            return true;
        }
        this.zab = true;
        for (zada zah : set) {
            zah.zah();
        }
        return false;
    }
}
