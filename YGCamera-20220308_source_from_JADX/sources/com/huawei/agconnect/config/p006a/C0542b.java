package com.huawei.agconnect.config.p006a;

import android.content.Context;
import com.huawei.agconnect.config.LazyInputStream;
import java.io.InputStream;

/* renamed from: com.huawei.agconnect.config.a.b */
class C0542b extends LazyInputStream {

    /* renamed from: a */
    final /* synthetic */ InputStream f99a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C0542b(Context context, InputStream inputStream) {
        super(context);
        this.f99a = inputStream;
    }

    public InputStream get(Context context) {
        return this.f99a;
    }
}
