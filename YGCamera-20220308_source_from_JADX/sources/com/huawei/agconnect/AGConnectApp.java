package com.huawei.agconnect;

import android.content.Context;
import com.huawei.agconnect.config.p006a.C0541a;

public abstract class AGConnectApp {
    public static AGConnectApp getInstance() {
        return C0541a.getInstance();
    }

    private static AGConnectApp getInstance(String str) {
        return C0541a.getInstance(str);
    }

    public static AGConnectApp initialize(Context context) {
        return C0541a.initialize(context);
    }

    private static AGConnectApp initialize(Context context, String str) {
        return C0541a.initialize(context, str);
    }

    public abstract void setApiKey(String str);

    public abstract void setClientId(String str);

    public abstract void setClientSecret(String str);

    public abstract void setCustomAuthProvider(CustomAuthProvider customAuthProvider);

    public abstract void setCustomCredentialsProvider(CustomCredentialsProvider customCredentialsProvider);

    public abstract void setParam(String str, String str2);
}
