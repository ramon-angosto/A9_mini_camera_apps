package com.google.android.gms.internal;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.zzc;
import java.util.Iterator;

public class zzny extends zznu {
    /* JADX WARNING: type inference failed for: r0v0, types: [com.google.android.gms.common.util.zza, com.google.android.gms.internal.zzoj] */
    public void onStop() {
        super.onStop();
        ? r0 = 0;
        Iterator it = r0.iterator();
        while (it.hasNext()) {
            ((zzc) it.next()).release();
        }
        r0.clear();
        r0.zza(this);
    }

    /* access modifiers changed from: protected */
    public void zza(ConnectionResult connectionResult, int i) {
        zzoj zzoj = null;
        zzoj.zza(connectionResult, i);
    }

    /* access modifiers changed from: protected */
    public void zzrA() {
        zzoj zzoj = null;
        zzoj.zzrA();
    }
}
