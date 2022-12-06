package com.google.android.gms.common.api.internal;

import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.internal.IAccountAccessor;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-base@@18.0.0 */
final class zabu implements BaseGmsClient.ConnectionProgressReportCallbacks, zacs {
    final /* synthetic */ GoogleApiManager zaa;
    /* access modifiers changed from: private */
    public final Api.Client zab;
    /* access modifiers changed from: private */
    public final ApiKey<?> zac;
    private IAccountAccessor zad = null;
    private Set<Scope> zae = null;
    /* access modifiers changed from: private */
    public boolean zaf = false;

    public zabu(GoogleApiManager googleApiManager, Api.Client client, ApiKey<?> apiKey) {
        this.zaa = googleApiManager;
        this.zab = client;
        this.zac = apiKey;
    }

    /* access modifiers changed from: private */
    public final void zag() {
        IAccountAccessor iAccountAccessor;
        if (this.zaf && (iAccountAccessor = this.zad) != null) {
            this.zab.getRemoteService(iAccountAccessor, this.zae);
        }
    }

    public final void onReportServiceBinding(ConnectionResult connectionResult) {
        this.zaa.zat.post(new zabt(this, connectionResult));
    }

    public final void zae(ConnectionResult connectionResult) {
        zabq zabq = (zabq) this.zaa.zap.get(this.zac);
        if (zabq != null) {
            zabq.zas(connectionResult);
        }
    }

    public final void zaf(IAccountAccessor iAccountAccessor, Set<Scope> set) {
        if (iAccountAccessor == null || set == null) {
            Log.wtf("GoogleApiManager", "Received null response from onSignInSuccess", new Exception());
            zae(new ConnectionResult(4));
            return;
        }
        this.zad = iAccountAccessor;
        this.zae = set;
        zag();
    }
}
