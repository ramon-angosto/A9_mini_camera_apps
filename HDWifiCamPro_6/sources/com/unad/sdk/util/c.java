package com.unad.sdk.util;

import android.content.Context;
import java.io.IOException;
import okhttp3.Call;

/* compiled from: OkHttpCallback */
public abstract class c {
    public c(Context context) {
    }

    public abstract void a(Call call, Exception exc);

    public abstract void a(Call call, String str) throws IOException;
}
