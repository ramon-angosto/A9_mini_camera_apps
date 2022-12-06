package com.google.firebase.messaging;

import android.app.ActivityManager;
import android.app.KeyguardManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Process;
import android.os.SystemClock;
import android.support.v4.app.NotificationCompat;
import android.text.TextUtils;
import android.util.Log;
import com.google.firebase.iid.FirebaseInstanceIdInternalReceiver;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.util.Arrays;
import java.util.List;
import java.util.MissingFormatArgumentException;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONException;

class zza {
    static zza zzbSV;
    private final Context mContext;
    private final AtomicInteger zzbSW = new AtomicInteger((int) SystemClock.elapsedRealtime());

    private zza(Context context) {
        this.mContext = context.getApplicationContext();
    }

    static boolean zzA(Bundle bundle) {
        return "1".equals(zzf(bundle, "gcm.n.e")) || zzf(bundle, "gcm.n.icon") != null;
    }

    private int zzBN() {
        return this.zzbSW.incrementAndGet();
    }

    private Notification zzD(Bundle bundle) {
        PendingIntent pendingIntent;
        CharSequence zzg = zzg(bundle, "gcm.n.title");
        String zzg2 = zzg(bundle, "gcm.n.body");
        int zzex = zzex(zzf(bundle, "gcm.n.icon"));
        String zzf = zzf(bundle, "gcm.n.color");
        Uri zzey = zzey(zzR(bundle));
        PendingIntent zzE = zzE(bundle);
        if (FirebaseMessagingService.zzT(bundle)) {
            zzE = zza(bundle, zzE);
            pendingIntent = zzS(bundle);
        } else {
            pendingIntent = null;
        }
        NotificationCompat.Builder smallIcon = new NotificationCompat.Builder(this.mContext).setAutoCancel(true).setSmallIcon(zzex);
        if (TextUtils.isEmpty(zzg)) {
            zzg = this.mContext.getApplicationInfo().loadLabel(this.mContext.getPackageManager());
        }
        smallIcon.setContentTitle(zzg);
        if (!TextUtils.isEmpty(zzg2)) {
            smallIcon.setContentText(zzg2);
        }
        if (!TextUtils.isEmpty(zzf)) {
            smallIcon.setColor(Color.parseColor(zzf));
        }
        if (zzey != null) {
            smallIcon.setSound(zzey);
        }
        if (zzE != null) {
            smallIcon.setContentIntent(zzE);
        }
        if (pendingIntent != null) {
            smallIcon.setDeleteIntent(pendingIntent);
        }
        return smallIcon.build();
    }

    private PendingIntent zzE(Bundle bundle) {
        Intent intent;
        String zzf = zzf(bundle, "gcm.n.click_action");
        if (!TextUtils.isEmpty(zzf)) {
            intent = new Intent(zzf);
            intent.setPackage(this.mContext.getPackageName());
            intent.setFlags(268435456);
        } else {
            intent = this.mContext.getPackageManager().getLaunchIntentForPackage(this.mContext.getPackageName());
            if (intent == null) {
                Log.w("FirebaseMessaging", "No activity found to launch app");
                return null;
            }
        }
        Bundle bundle2 = new Bundle(bundle);
        FirebaseMessagingService.zzz(bundle2);
        intent.putExtras(bundle2);
        for (String str : bundle2.keySet()) {
            if (str.startsWith("gcm.n.") || str.startsWith("gcm.notification.")) {
                intent.removeExtra(str);
            }
        }
        return PendingIntent.getActivity(this.mContext, zzBN(), intent, 1073741824);
    }

    static String zzR(Bundle bundle) {
        String zzf = zzf(bundle, "gcm.n.sound2");
        return TextUtils.isEmpty(zzf) ? zzf(bundle, "gcm.n.sound") : zzf;
    }

    private PendingIntent zzS(Bundle bundle) {
        Intent intent = new Intent("com.google.firebase.messaging.NOTIFICATION_DISMISS");
        zza(intent, bundle);
        return PendingIntent.getBroadcast(this.mContext, zzBN(), FirebaseInstanceIdInternalReceiver.zzi(this.mContext, intent), 1073741824);
    }

    private PendingIntent zza(Bundle bundle, PendingIntent pendingIntent) {
        Intent intent = new Intent("com.google.firebase.messaging.NOTIFICATION_OPEN");
        zza(intent, bundle);
        intent.putExtra("pending_intent", pendingIntent);
        return PendingIntent.getBroadcast(this.mContext, zzBN(), FirebaseInstanceIdInternalReceiver.zzi(this.mContext, intent), 1073741824);
    }

    private void zza(Intent intent, Bundle bundle) {
        for (String str : bundle.keySet()) {
            if (str.startsWith("google.c.a.") || str.equals("from")) {
                intent.putExtra(str, bundle.getString(str));
            }
        }
    }

    private void zza(String str, Notification notification) {
        if (Log.isLoggable("FirebaseMessaging", 3)) {
            Log.d("FirebaseMessaging", "Showing notification");
        }
        NotificationManager notificationManager = (NotificationManager) this.mContext.getSystemService("notification");
        if (TextUtils.isEmpty(str)) {
            long uptimeMillis = SystemClock.uptimeMillis();
            StringBuilder sb = new StringBuilder(37);
            sb.append("GCM-Notification:");
            sb.append(uptimeMillis);
            str = sb.toString();
        }
        notificationManager.notify(str, 0, notification);
    }

    static boolean zzaR(Context context) {
        if (((KeyguardManager) context.getSystemService("keyguard")).inKeyguardRestrictedInputMode()) {
            return false;
        }
        int myPid = Process.myPid();
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService(PushConstants.INTENT_ACTIVITY_NAME)).getRunningAppProcesses();
        if (runningAppProcesses == null) {
            return false;
        }
        for (ActivityManager.RunningAppProcessInfo next : runningAppProcesses) {
            if (next.pid == myPid) {
                return next.importance == 100;
            }
        }
        return false;
    }

    static synchronized zza zzbB(Context context) {
        zza zza;
        synchronized (zza.class) {
            if (zzbSV == null) {
                zzbSV = new zza(context);
            }
            zza = zzbSV;
        }
        return zza;
    }

    private static String zzew(String str) {
        return str.substring(6);
    }

    private int zzex(String str) {
        if (!TextUtils.isEmpty(str)) {
            Resources resources = this.mContext.getResources();
            int identifier = resources.getIdentifier(str, "drawable", this.mContext.getPackageName());
            if (identifier != 0) {
                return identifier;
            }
            int identifier2 = resources.getIdentifier(str, "mipmap", this.mContext.getPackageName());
            if (identifier2 != 0) {
                return identifier2;
            }
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 57);
            sb.append("Icon resource ");
            sb.append(str);
            sb.append(" not found. Notification will use app icon.");
            Log.w("FirebaseMessaging", sb.toString());
        }
        int i = this.mContext.getApplicationInfo().icon;
        if (i == 0) {
            return 17301651;
        }
        return i;
    }

    private Uri zzey(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if ("default".equals(str) || this.mContext.getResources().getIdentifier(str, "raw", this.mContext.getPackageName()) == 0) {
            return RingtoneManager.getDefaultUri(2);
        }
        String valueOf = String.valueOf(this.mContext.getPackageName());
        StringBuilder sb = new StringBuilder("android.resource://".length() + 5 + String.valueOf(valueOf).length() + String.valueOf(str).length());
        sb.append("android.resource://");
        sb.append(valueOf);
        sb.append("/raw/");
        sb.append(str);
        return Uri.parse(sb.toString());
    }

    static String zzf(Bundle bundle, String str) {
        String string = bundle.getString(str);
        return string == null ? bundle.getString(str.replace("gcm.n.", "gcm.notification.")) : string;
    }

    private String zzg(Bundle bundle, String str) {
        String zzf = zzf(bundle, str);
        if (!TextUtils.isEmpty(zzf)) {
            return zzf;
        }
        String zzh = zzh(bundle, str);
        if (TextUtils.isEmpty(zzh)) {
            return null;
        }
        Resources resources = this.mContext.getResources();
        int identifier = resources.getIdentifier(zzh, "string", this.mContext.getPackageName());
        if (identifier == 0) {
            String valueOf = String.valueOf(str);
            String valueOf2 = String.valueOf(zzew("_loc_key".length() != 0 ? valueOf.concat("_loc_key") : new String(valueOf)));
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf2).length() + 49 + String.valueOf(zzh).length());
            sb.append(valueOf2);
            sb.append(" resource not found: ");
            sb.append(zzh);
            sb.append(" Default value will be used.");
            Log.w("FirebaseMessaging", sb.toString());
            return null;
        }
        Object[] zzi = zzi(bundle, str);
        if (zzi == null) {
            return resources.getString(identifier);
        }
        try {
            return resources.getString(identifier, zzi);
        } catch (MissingFormatArgumentException e) {
            String valueOf3 = String.valueOf(Arrays.toString(zzi));
            StringBuilder sb2 = new StringBuilder(String.valueOf(zzh).length() + 58 + String.valueOf(valueOf3).length());
            sb2.append("Missing format argument for ");
            sb2.append(zzh);
            sb2.append(": ");
            sb2.append(valueOf3);
            sb2.append(" Default value will be used.");
            Log.w("FirebaseMessaging", sb2.toString(), e);
            return null;
        }
    }

    static String zzh(Bundle bundle, String str) {
        String valueOf = String.valueOf(str);
        return zzf(bundle, "_loc_key".length() != 0 ? valueOf.concat("_loc_key") : new String(valueOf));
    }

    static Object[] zzi(Bundle bundle, String str) {
        String valueOf = String.valueOf(str);
        String zzf = zzf(bundle, "_loc_args".length() != 0 ? valueOf.concat("_loc_args") : new String(valueOf));
        if (TextUtils.isEmpty(zzf)) {
            return null;
        }
        try {
            JSONArray jSONArray = new JSONArray(zzf);
            Object[] objArr = new String[jSONArray.length()];
            for (int i = 0; i < objArr.length; i++) {
                objArr[i] = jSONArray.opt(i);
            }
            return objArr;
        } catch (JSONException unused) {
            String valueOf2 = String.valueOf(str);
            String valueOf3 = String.valueOf(zzew("_loc_args".length() != 0 ? valueOf2.concat("_loc_args") : new String(valueOf2)));
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf3).length() + 41 + String.valueOf(zzf).length());
            sb.append("Malformed ");
            sb.append(valueOf3);
            sb.append(": ");
            sb.append(zzf);
            sb.append("  Default value will be used.");
            Log.w("FirebaseMessaging", sb.toString());
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public void zzQ(Bundle bundle) {
        zza(zzf(bundle, "gcm.n.tag"), zzD(bundle));
    }
}
