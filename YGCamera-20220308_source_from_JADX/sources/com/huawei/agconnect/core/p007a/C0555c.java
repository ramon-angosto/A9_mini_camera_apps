package com.huawei.agconnect.core.p007a;

import com.huawei.agconnect.CustomAuthProvider;
import com.huawei.agconnect.core.service.auth.AuthProvider;
import com.huawei.agconnect.core.service.auth.OnTokenListener;
import com.huawei.agconnect.core.service.auth.Token;
import com.huawei.hmf.tasks.Task;

/* renamed from: com.huawei.agconnect.core.a.c */
class C0555c implements AuthProvider {

    /* renamed from: a */
    final /* synthetic */ CustomAuthProvider f125a;

    /* renamed from: b */
    final /* synthetic */ C0556d f126b;

    C0555c(C0556d dVar, CustomAuthProvider customAuthProvider) {
        this.f126b = dVar;
        this.f125a = customAuthProvider;
    }

    public void addTokenListener(OnTokenListener onTokenListener) {
    }

    public Task<Token> getTokens() {
        return this.f125a.getTokens(false);
    }

    public Task<Token> getTokens(boolean z) {
        return this.f125a.getTokens(z);
    }

    public String getUid() {
        return "";
    }

    public void removeTokenListener(OnTokenListener onTokenListener) {
    }
}
