package com.xiaomi.push;

import android.app.KeyguardManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.xiaomi.channel.commonutils.logger.C1524b;

/* renamed from: com.xiaomi.push.aj */
public class C1617aj {
    /* renamed from: a */
    public static boolean m2515a(Context context) {
        try {
            return ((KeyguardManager) context.getSystemService("keyguard")).inKeyguardRestrictedInputMode();
        } catch (Exception e) {
            C1524b.m2155a((Throwable) e);
            return false;
        }
    }

    /* renamed from: b */
    public static boolean m2516b(Context context) {
        Intent intent = null;
        try {
            intent = context.registerReceiver((BroadcastReceiver) null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        } catch (Exception unused) {
        }
        if (intent == null) {
            return false;
        }
        int intExtra = intent.getIntExtra("status", -1);
        return intExtra == 2 || intExtra == 5;
    }
}
