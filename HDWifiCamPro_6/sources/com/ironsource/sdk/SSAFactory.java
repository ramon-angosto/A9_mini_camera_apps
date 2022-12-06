package com.ironsource.sdk;

import android.app.Activity;
import android.content.Context;
import com.ironsource.sdk.d.b;

@Deprecated
public class SSAFactory {
    public static f getPublisherInstance(Activity activity) {
        return b.a((Context) activity);
    }

    public static f getPublisherTestInstance(Activity activity, int i) {
        return b.a((Context) activity, i);
    }
}
