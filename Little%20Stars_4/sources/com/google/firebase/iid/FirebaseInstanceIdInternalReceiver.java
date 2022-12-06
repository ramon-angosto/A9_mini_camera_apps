package com.google.firebase.iid;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.support.v4.content.WakefulBroadcastReceiver;
import android.util.Log;
import java.util.LinkedList;
import java.util.Queue;

public final class FirebaseInstanceIdInternalReceiver extends WakefulBroadcastReceiver {
    private static final Queue<Intent> zzbSG = new LinkedList();
    private static final Queue<Intent> zzbSH = new LinkedList();

    public static Intent zzUq() {
        return zzbSG.poll();
    }

    public static Intent zzUr() {
        return zzbSH.poll();
    }

    private static Intent zza(Context context, String str, Intent intent) {
        Intent intent2 = new Intent(context, FirebaseInstanceIdInternalReceiver.class);
        intent2.setAction(str);
        intent2.putExtra("wrapped_intent", intent);
        return intent2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0027  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x004b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static int zzb(android.content.Context r3, java.lang.String r4, android.content.Intent r5) {
        /*
            int r0 = r4.hashCode()
            r1 = -842411455(0xffffffffcdc9d241, float:-4.23249952E8)
            r2 = 1
            if (r0 == r1) goto L_0x001a
            r1 = 41532704(0x279bd20, float:1.8347907E-37)
            if (r0 == r1) goto L_0x0010
            goto L_0x0024
        L_0x0010:
            java.lang.String r0 = "com.google.firebase.MESSAGING_EVENT"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x0024
            r0 = 1
            goto L_0x0025
        L_0x001a:
            java.lang.String r0 = "com.google.firebase.INSTANCE_ID_EVENT"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x0024
            r0 = 0
            goto L_0x0025
        L_0x0024:
            r0 = -1
        L_0x0025:
            if (r0 == 0) goto L_0x004b
            if (r0 == r2) goto L_0x0048
            java.lang.String r3 = "Unknown service action: "
            java.lang.String r4 = java.lang.String.valueOf(r4)
            int r5 = r4.length()
            if (r5 == 0) goto L_0x003a
            java.lang.String r3 = r3.concat(r4)
            goto L_0x0040
        L_0x003a:
            java.lang.String r4 = new java.lang.String
            r4.<init>(r3)
            r3 = r4
        L_0x0040:
            java.lang.String r4 = "FirebaseInstanceId"
            android.util.Log.w(r4, r3)
            r3 = 500(0x1f4, float:7.0E-43)
            return r3
        L_0x0048:
            java.util.Queue<android.content.Intent> r0 = zzbSH
            goto L_0x004d
        L_0x004b:
            java.util.Queue<android.content.Intent> r0 = zzbSG
        L_0x004d:
            r0.offer(r5)
            android.content.Intent r5 = new android.content.Intent
            r5.<init>(r4)
            java.lang.String r4 = r3.getPackageName()
            r5.setPackage(r4)
            int r3 = zzj(r3, r5)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.iid.FirebaseInstanceIdInternalReceiver.zzb(android.content.Context, java.lang.String, android.content.Intent):int");
    }

    private static void zzg(Context context, Intent intent) {
        ResolveInfo resolveService = context.getPackageManager().resolveService(intent, 0);
        if (resolveService == null || resolveService.serviceInfo == null) {
            Log.e("FirebaseInstanceId", "Failed to resolve target intent service, skipping classname enforcement");
            return;
        }
        ServiceInfo serviceInfo = resolveService.serviceInfo;
        if (!context.getPackageName().equals(serviceInfo.packageName) || serviceInfo.name == null) {
            String valueOf = String.valueOf(serviceInfo.packageName);
            String valueOf2 = String.valueOf(serviceInfo.name);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 94 + String.valueOf(valueOf2).length());
            sb.append("Error resolving target intent service, skipping classname enforcement. Resolved service was: ");
            sb.append(valueOf);
            sb.append("/");
            sb.append(valueOf2);
            Log.e("FirebaseInstanceId", sb.toString());
            return;
        }
        String str = serviceInfo.name;
        if (str.startsWith(".")) {
            String valueOf3 = String.valueOf(context.getPackageName());
            String valueOf4 = String.valueOf(str);
            str = valueOf4.length() != 0 ? valueOf3.concat(valueOf4) : new String(valueOf3);
        }
        if (Log.isLoggable("FirebaseInstanceId", 3)) {
            String valueOf5 = String.valueOf(str);
            Log.d("FirebaseInstanceId", valueOf5.length() != 0 ? "Restricting intent to a specific service: ".concat(valueOf5) : new String("Restricting intent to a specific service: "));
        }
        intent.setClassName(context.getPackageName(), str);
    }

    public static Intent zzh(Context context, Intent intent) {
        return zza(context, "com.google.firebase.INSTANCE_ID_EVENT", intent);
    }

    public static Intent zzi(Context context, Intent intent) {
        return zza(context, "com.google.firebase.MESSAGING_EVENT", intent);
    }

    private static int zzj(Context context, Intent intent) {
        ComponentName componentName;
        zzg(context, intent);
        try {
            if (context.checkCallingOrSelfPermission("android.permission.WAKE_LOCK") == 0) {
                componentName = startWakefulService(context, intent);
            } else {
                componentName = context.startService(intent);
                Log.d("FirebaseInstanceId", "Missing wake lock permission, service start may be delayed");
            }
            if (componentName != null) {
                return -1;
            }
            Log.e("FirebaseInstanceId", "Error while delivering the message: ServiceIntent not found.");
            return 404;
        } catch (SecurityException e) {
            Log.e("FirebaseInstanceId", "Error while delivering the message to the serviceIntent", e);
            return 401;
        }
    }

    public void onReceive(Context context, Intent intent) {
        if (intent != null) {
            Intent intent2 = (Intent) intent.getParcelableExtra("wrapped_intent");
            if (intent2 == null) {
                Log.w("FirebaseInstanceId", "Missing wrapped intent");
            } else {
                zzb(context, intent.getAction(), intent2);
            }
        }
    }
}
