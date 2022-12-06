package com.huawei.android.pushagent.c;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

public class e {
    public static void a(Context context, int i) {
        Bundle bundle = new Bundle();
        bundle.putInt("operType", 0);
        bundle.putInt("plusType", i);
        context.sendBroadcast(new Intent("com.huawei.android.push.PLUGIN").putExtra("plusReport", bundle).setPackage(context.getPackageName()));
    }

    public static void a(Context context, String str, long j, int i) {
        Bundle bundle = new Bundle();
        bundle.putString("content", str);
        bundle.putLong("cycle", j);
        bundle.putInt("operType", 1);
        bundle.putInt("plusType", i);
        context.sendBroadcast(new Intent("com.huawei.android.push.PLUGIN").putExtra("plusReport", bundle).setPackage(context.getPackageName()));
    }
}
