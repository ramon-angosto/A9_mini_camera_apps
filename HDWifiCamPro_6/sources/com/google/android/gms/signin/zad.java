package com.google.android.gms.signin;

import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.signin.internal.SignInClientImpl;

/* compiled from: com.google.android.gms:play-services-base@@18.0.0 */
public final class zad {
    public static final Api.ClientKey<SignInClientImpl> zaa = new Api.ClientKey<>();
    public static final Api.ClientKey<SignInClientImpl> zab = new Api.ClientKey<>();
    public static final Api.AbstractClientBuilder<SignInClientImpl, SignInOptions> zac = new zaa();
    static final Api.AbstractClientBuilder<SignInClientImpl, zac> zad = new zab();
    public static final Scope zae = new Scope(Scopes.PROFILE);
    public static final Scope zaf = new Scope("email");
    public static final Api<SignInOptions> zag = new Api<>("SignIn.API", zac, zaa);
    public static final Api<zac> zah = new Api<>("SignIn.INTERNAL_API", zad, zab);
}
