package com.google.firebase.iid;

import com.google.firebase.FirebaseApp;
import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.components.Dependency;
import com.google.firebase.events.Subscriber;
import com.google.firebase.iid.internal.FirebaseInstanceIdInternal;
import com.google.firebase.platforminfo.LibraryVersionComponent;
import com.google.firebase.platforminfo.UserAgentPublisher;
import java.util.Arrays;
import java.util.List;

/* compiled from: com.google.firebase:firebase-iid@@20.0.0 */
public final class Registrar implements ComponentRegistrar {
    public final List<Component<?>> getComponents() {
        return Arrays.asList(new Component[]{Component.builder(FirebaseInstanceId.class).add(Dependency.required(FirebaseApp.class)).add(Dependency.required(Subscriber.class)).add(Dependency.required(UserAgentPublisher.class)).factory(zzak.zza).alwaysEager().build(), Component.builder(FirebaseInstanceIdInternal.class).add(Dependency.required(FirebaseInstanceId.class)).factory(zzal.zza).build(), LibraryVersionComponent.create("fire-iid", "20.0.0")});
    }

    /* compiled from: com.google.firebase:firebase-iid@@20.0.0 */
    private static class zza implements FirebaseInstanceIdInternal {
        private final FirebaseInstanceId zza;

        public zza(FirebaseInstanceId firebaseInstanceId) {
            this.zza = firebaseInstanceId;
        }

        public final String getId() {
            return this.zza.getId();
        }

        public final String getToken() {
            return this.zza.getToken();
        }
    }
}
