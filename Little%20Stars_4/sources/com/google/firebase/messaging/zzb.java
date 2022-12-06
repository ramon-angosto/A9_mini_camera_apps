package com.google.firebase.messaging;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.measurement.AppMeasurement;

class zzb {
    static AppMeasurement zzbGt;

    private static AppMeasurement zzbC(Context context) {
        try {
            return AppMeasurement.getInstance(context);
        } catch (NoClassDefFoundError unused) {
            return null;
        }
    }

    private static void zzc(Context context, String str, Intent intent) {
        Bundle bundle = new Bundle();
        String stringExtra = intent.getStringExtra("google.c.a.c_id");
        if (stringExtra != null) {
            bundle.putString("_nmid", stringExtra);
        }
        String stringExtra2 = intent.getStringExtra("google.c.a.c_l");
        if (stringExtra2 != null) {
            bundle.putString("_nmn", stringExtra2);
        }
        String stringExtra3 = intent.getStringExtra("from");
        if (stringExtra3 == null || !stringExtra3.startsWith("/topics/")) {
            stringExtra3 = null;
        }
        if (stringExtra3 != null) {
            bundle.putString("_nt", stringExtra3);
        }
        try {
            bundle.putInt("_nmt", Integer.valueOf(intent.getStringExtra("google.c.a.ts")).intValue());
        } catch (NumberFormatException e) {
            Log.w("FirebaseMessaging", "Error while parsing timestamp in GCM event", e);
        }
        if (intent.hasExtra("google.c.a.udt")) {
            try {
                bundle.putInt("_ndt", Integer.valueOf(intent.getStringExtra("google.c.a.udt")).intValue());
            } catch (NumberFormatException e2) {
                Log.w("FirebaseMessaging", "Error while parsing use_device_time in GCM event", e2);
            }
        }
        if (Log.isLoggable("FirebaseMessaging", 3)) {
            String valueOf = String.valueOf(bundle);
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 22 + String.valueOf(valueOf).length());
            sb.append("Sending event=");
            sb.append(str);
            sb.append(" params=");
            sb.append(valueOf);
            Log.d("FirebaseMessaging", sb.toString());
        }
        AppMeasurement zzbC = zzbC(context);
        if (zzbC != null) {
            zzbC.zzd("fcm", str, bundle);
        } else {
            Log.w("FirebaseMessaging", "Unable to log event, missing measurement library");
        }
    }

    public static void zzl(Context context, Intent intent) {
        zzc(context, "_nr", intent);
    }

    public static void zzm(Context context, Intent intent) {
        zzp(context, intent);
        zzc(context, "_no", intent);
    }

    public static void zzn(Context context, Intent intent) {
        zzc(context, "_nd", intent);
    }

    public static void zzo(Context context, Intent intent) {
        zzc(context, "_nf", intent);
    }

    private static void zzp(Context context, Intent intent) {
        if (intent != null && "1".equals(intent.getStringExtra("google.c.a.tc"))) {
            AppMeasurement zzbC = zzbC(context);
            if (zzbC != null) {
                String stringExtra = intent.getStringExtra("google.c.a.c_id");
                zzbC.zza("fcm", "_ln", stringExtra);
                Bundle bundle = new Bundle();
                bundle.putString("source", "Firebase");
                bundle.putString("medium", "notification");
                bundle.putString("campaign", stringExtra);
                zzbC.zzd("fcm", "_cmp", bundle);
                return;
            }
            Log.w("FirebaseMessaging", "Unable to set user property for event tracking, missing measurement library");
        }
    }
}
