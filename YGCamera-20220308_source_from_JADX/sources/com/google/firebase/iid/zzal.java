package com.google.firebase.iid;

import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;
import com.google.firebase.iid.Registrar;

/* compiled from: com.google.firebase:firebase-iid@@20.0.0 */
final /* synthetic */ class zzal implements ComponentFactory {
    static final ComponentFactory zza = new zzal();

    private zzal() {
    }

    public final Object create(ComponentContainer componentContainer) {
        return new Registrar.zza((FirebaseInstanceId) componentContainer.get(FirebaseInstanceId.class));
    }
}
