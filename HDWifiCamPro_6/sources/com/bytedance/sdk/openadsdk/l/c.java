package com.bytedance.sdk.openadsdk.l;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.SystemClock;
import android.util.Log;
import com.bytedance.sdk.component.utils.l;
import com.bytedance.sdk.openadsdk.core.m;
import com.mbridge.msdk.playercommon.exoplayer2.source.chunk.ChunkedTrackBlacklistUtil;

/* compiled from: BatteryDataWatcher */
public class c {
    static int a = -1;
    static float b;
    private static long c;

    private static void a(Intent intent) {
        if (intent.getIntExtra("status", -1) == 2) {
            a = 1;
        } else {
            a = 0;
        }
        b = ((float) (intent.getIntExtra("level", -1) * 100)) / ((float) intent.getIntExtra("scale", -1));
        l.b("BatteryDataWatcher", "updateFromIntent: status=" + a + ", level=" + b);
    }

    public static a a() {
        if (c == 0 || SystemClock.elapsedRealtime() - c > ChunkedTrackBlacklistUtil.DEFAULT_TRACK_BLACKLIST_MS) {
            Intent registerReceiver = m.a().registerReceiver((BroadcastReceiver) null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
            Log.d("BatteryDataWatcher", "obtainCurrentState: registerReceiver result is " + registerReceiver);
            if (registerReceiver != null) {
                a(registerReceiver);
                c = SystemClock.elapsedRealtime();
            }
        }
        a aVar = new a(a, b);
        l.b("BatteryDataWatcher", "obtainCurrentState: " + aVar.a + ", " + aVar.b);
        return aVar;
    }

    /* compiled from: BatteryDataWatcher */
    public static class a {
        public final int a;
        public final float b;

        public a(int i, float f) {
            this.a = i;
            this.b = f;
        }
    }
}
