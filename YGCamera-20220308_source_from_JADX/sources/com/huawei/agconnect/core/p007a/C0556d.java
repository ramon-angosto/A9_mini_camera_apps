package com.huawei.agconnect.core.p007a;

import com.huawei.agconnect.CustomAuthProvider;
import com.huawei.agconnect.CustomCredentialsProvider;
import com.huawei.agconnect.core.service.auth.AuthProvider;
import com.huawei.agconnect.core.service.auth.CredentialsProvider;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.huawei.agconnect.core.a.d */
public class C0556d {

    /* renamed from: a */
    private Map<Class<?>, Object> f127a = new HashMap();

    /* renamed from: a */
    public void mo12761a(CustomAuthProvider customAuthProvider) {
        if (customAuthProvider == null) {
            this.f127a.remove(AuthProvider.class);
            return;
        }
        this.f127a.put(AuthProvider.class, new C0555c(this, customAuthProvider));
    }

    /* renamed from: a */
    public void mo12762a(CustomCredentialsProvider customCredentialsProvider) {
        if (customCredentialsProvider == null) {
            this.f127a.remove(CredentialsProvider.class);
            return;
        }
        this.f127a.put(CredentialsProvider.class, new C0554b(this, customCredentialsProvider));
    }

    /* renamed from: a */
    public boolean mo12763a(Class<?> cls) {
        return this.f127a.containsKey(cls) && mo12764b(cls) != null;
    }

    /* renamed from: b */
    public Object mo12764b(Class<?> cls) {
        return this.f127a.get(cls);
    }
}
