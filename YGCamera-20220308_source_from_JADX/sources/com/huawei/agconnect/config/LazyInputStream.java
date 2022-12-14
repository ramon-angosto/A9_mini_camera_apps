package com.huawei.agconnect.config;

import android.content.Context;
import com.huawei.agconnect.config.p006a.C0550j;
import java.io.InputStream;

public abstract class LazyInputStream {
    private final Context mContext;
    private InputStream mInput;

    public LazyInputStream(Context context) {
        this.mContext = context;
    }

    public final void close() {
        C0550j.m68a(this.mInput);
    }

    public abstract InputStream get(Context context);

    public InputStream loadInputStream() {
        if (this.mInput == null) {
            this.mInput = get(this.mContext);
        }
        return this.mInput;
    }
}
