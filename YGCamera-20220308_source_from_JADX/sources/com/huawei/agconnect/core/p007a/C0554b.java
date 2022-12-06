package com.huawei.agconnect.core.p007a;

import com.huawei.agconnect.CustomCredentialsProvider;
import com.huawei.agconnect.core.service.auth.CredentialsProvider;
import com.huawei.agconnect.core.service.auth.Token;
import com.huawei.hmf.tasks.Task;

/* renamed from: com.huawei.agconnect.core.a.b */
class C0554b implements CredentialsProvider {

    /* renamed from: a */
    final /* synthetic */ CustomCredentialsProvider f123a;

    /* renamed from: b */
    final /* synthetic */ C0556d f124b;

    C0554b(C0556d dVar, CustomCredentialsProvider customCredentialsProvider) {
        this.f124b = dVar;
        this.f123a = customCredentialsProvider;
    }

    public Task<Token> getTokens() {
        return this.f123a.getTokens(false);
    }

    public Task<Token> getTokens(boolean z) {
        return this.f123a.getTokens(z);
    }
}
