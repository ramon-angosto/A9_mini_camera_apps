package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.Intent;
import com.xiaomi.clientreport.data.Config;
import com.xiaomi.push.C1906iz;

/* renamed from: com.xiaomi.mipush.sdk.t */
public class C1598t {
    /* renamed from: a */
    public static <T extends C1906iz<T, ?>> void m2473a(Context context, Config config) {
        if (config != null) {
            Intent intent = new Intent();
            intent.setAction("action_cr_config");
            intent.putExtra("action_cr_event_switch", config.isEventUploadSwitchOpen());
            intent.putExtra("action_cr_event_frequency", config.getEventUploadFrequency());
            intent.putExtra("action_cr_perf_switch", config.isPerfUploadSwitchOpen());
            intent.putExtra("action_cr_perf_frequency", config.getPerfUploadFrequency());
            intent.putExtra("action_cr_event_en", config.isEventEncrypted());
            intent.putExtra("action_cr_max_file_size", config.getMaxFileLength());
            C1568ao.m2317a(context).mo17137a(intent);
        }
    }
}
