package com.huawei.agconnect.core.p007a;

import android.content.Context;
import com.huawei.agconnect.AGConnectInstance;
import com.huawei.agconnect.CustomAuthProvider;
import com.huawei.agconnect.CustomCredentialsProvider;

/* renamed from: com.huawei.agconnect.core.a.a */
public class C0553a extends AGConnectInstance {

    /* renamed from: a */
    private final Context f120a;

    /* renamed from: b */
    private final C0560g f121b;

    /* renamed from: c */
    private C0556d f122c = new C0556d();

    public C0553a(Context context) {
        this.f120a = context;
        this.f121b = new C0560g(new C0558f(context).mo12765a());
    }

    /* renamed from: a */
    public void mo12752a(CustomAuthProvider customAuthProvider) {
        this.f122c.mo12761a(customAuthProvider);
    }

    /* renamed from: a */
    public void mo12753a(CustomCredentialsProvider customCredentialsProvider) {
        this.f122c.mo12762a(customCredentialsProvider);
    }

    public Context getContext() {
        return this.f120a;
    }

    public <T> T getService(Class<? super T> cls) {
        return this.f122c.mo12763a((Class<?>) cls) ? this.f122c.mo12764b(cls) : this.f121b.mo12768a((AGConnectInstance) this, (Class<?>) cls);
    }
}
