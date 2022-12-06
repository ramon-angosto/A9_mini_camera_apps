package com.huawei.agconnect;

import android.content.Context;
import android.util.Log;
import com.huawei.agconnect.config.p006a.C0541a;
import com.huawei.agconnect.core.p007a.C0553a;

public abstract class AGConnectInstance {
    private static AGConnectInstance INSTANCE;

    public static AGConnectInstance getInstance() {
        return INSTANCE;
    }

    public static synchronized void initialize(Context context) {
        synchronized (AGConnectInstance.class) {
            Log.i("AGConnectInstance", "AGConnectInstance#initialize");
            C0541a.initialize(context);
            Context applicationContext = context.getApplicationContext();
            if (applicationContext != null) {
                context = applicationContext;
            }
            if (INSTANCE == null) {
                INSTANCE = new C0553a(context);
            }
        }
    }

    public abstract Context getContext();

    public abstract <T> T getService(Class<? super T> cls);
}
