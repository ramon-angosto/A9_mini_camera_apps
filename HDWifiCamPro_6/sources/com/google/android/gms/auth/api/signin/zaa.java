package com.google.android.gms.auth.api.signin;

import android.os.Parcelable;
import com.google.android.gms.common.api.Scope;
import java.util.Comparator;

/* compiled from: com.google.android.gms:play-services-base@@18.0.0 */
public final /* synthetic */ class zaa implements Comparator {
    public static final /* synthetic */ zaa zaa = new zaa();

    private /* synthetic */ zaa() {
    }

    public final int compare(Object obj, Object obj2) {
        Parcelable.Creator<GoogleSignInAccount> creator = GoogleSignInAccount.CREATOR;
        return ((Scope) obj).getScopeUri().compareTo(((Scope) obj2).getScopeUri());
    }
}
