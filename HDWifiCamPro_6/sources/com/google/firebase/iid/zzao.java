package com.google.firebase.iid;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcelable;
import android.util.Log;
import androidx.collection.SimpleArrayMap;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.iid.zzf;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: com.google.firebase:firebase-iid@@20.0.0 */
final class zzao {
    private static int zza;
    private static PendingIntent zzb;
    private final SimpleArrayMap<String, TaskCompletionSource<Bundle>> zzc = new SimpleArrayMap<>();
    private final Context zzd;
    private final zzai zze;
    private Messenger zzf;
    private Messenger zzg;
    private zzf zzh;

    public zzao(Context context, zzai zzai) {
        this.zzd = context;
        this.zze = zzai;
        this.zzf = new Messenger(new zzar(this, Looper.getMainLooper()));
    }

    /* access modifiers changed from: private */
    public final void zza(Message message) {
        if (message == null || !(message.obj instanceof Intent)) {
            Log.w("FirebaseInstanceId", "Dropping invalid message");
            return;
        }
        Intent intent = (Intent) message.obj;
        intent.setExtrasClassLoader(new zzf.zza());
        if (intent.hasExtra("google.messenger")) {
            Parcelable parcelableExtra = intent.getParcelableExtra("google.messenger");
            if (parcelableExtra instanceof zzf) {
                this.zzh = (zzf) parcelableExtra;
            }
            if (parcelableExtra instanceof Messenger) {
                this.zzg = (Messenger) parcelableExtra;
            }
        }
        Intent intent2 = (Intent) message.obj;
        String action = intent2.getAction();
        if ("com.google.android.c2dm.intent.REGISTRATION".equals(action)) {
            String stringExtra = intent2.getStringExtra("registration_id");
            if (stringExtra == null) {
                stringExtra = intent2.getStringExtra("unregistered");
            }
            if (stringExtra == null) {
                String stringExtra2 = intent2.getStringExtra(CampaignEx.JSON_NATIVE_VIDEO_ERROR);
                if (stringExtra2 == null) {
                    String valueOf = String.valueOf(intent2.getExtras());
                    StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 49);
                    sb.append("Unexpected response, no error or registration id ");
                    sb.append(valueOf);
                    Log.w("FirebaseInstanceId", sb.toString());
                    return;
                }
                if (Log.isLoggable("FirebaseInstanceId", 3)) {
                    String valueOf2 = String.valueOf(stringExtra2);
                    Log.d("FirebaseInstanceId", valueOf2.length() != 0 ? "Received InstanceID error ".concat(valueOf2) : new String("Received InstanceID error "));
                }
                if (stringExtra2.startsWith("|")) {
                    String[] split = stringExtra2.split("\\|");
                    if (split.length <= 2 || !"ID".equals(split[1])) {
                        String valueOf3 = String.valueOf(stringExtra2);
                        Log.w("FirebaseInstanceId", valueOf3.length() != 0 ? "Unexpected structured response ".concat(valueOf3) : new String("Unexpected structured response "));
                        return;
                    }
                    String str = split[2];
                    String str2 = split[3];
                    if (str2.startsWith(":")) {
                        str2 = str2.substring(1);
                    }
                    zza(str, intent2.putExtra(CampaignEx.JSON_NATIVE_VIDEO_ERROR, str2).getExtras());
                    return;
                }
                synchronized (this.zzc) {
                    for (int i = 0; i < this.zzc.size(); i++) {
                        zza(this.zzc.keyAt(i), intent2.getExtras());
                    }
                }
                return;
            }
            Matcher matcher = Pattern.compile("\\|ID\\|([^|]+)\\|:?+(.*)").matcher(stringExtra);
            if (matcher.matches()) {
                String group = matcher.group(1);
                String group2 = matcher.group(2);
                Bundle extras = intent2.getExtras();
                extras.putString("registration_id", group2);
                zza(group, extras);
            } else if (Log.isLoggable("FirebaseInstanceId", 3)) {
                String valueOf4 = String.valueOf(stringExtra);
                Log.d("FirebaseInstanceId", valueOf4.length() != 0 ? "Unexpected response string: ".concat(valueOf4) : new String("Unexpected response string: "));
            }
        } else if (Log.isLoggable("FirebaseInstanceId", 3)) {
            String valueOf5 = String.valueOf(action);
            Log.d("FirebaseInstanceId", valueOf5.length() != 0 ? "Unexpected response action: ".concat(valueOf5) : new String("Unexpected response action: "));
        }
    }

    private static synchronized void zza(Context context, Intent intent) {
        synchronized (zzao.class) {
            if (zzb == null) {
                Intent intent2 = new Intent();
                intent2.setPackage("com.google.example.invalidpackage");
                zzb = PendingIntent.getBroadcast(context, 0, intent2, 0);
            }
            intent.putExtra("app", zzb);
        }
    }

    private final void zza(String str, Bundle bundle) {
        synchronized (this.zzc) {
            TaskCompletionSource remove = this.zzc.remove(str);
            if (remove == null) {
                String valueOf = String.valueOf(str);
                Log.w("FirebaseInstanceId", valueOf.length() != 0 ? "Missing callback for ".concat(valueOf) : new String("Missing callback for "));
                return;
            }
            remove.setResult(bundle);
        }
    }

    /* access modifiers changed from: package-private */
    public final Bundle zza(Bundle bundle) throws IOException {
        if (this.zze.zzd() < 12000000) {
            return zzb(bundle);
        }
        try {
            return (Bundle) Tasks.await(zzv.zza(this.zzd).zzb(1, bundle));
        } catch (InterruptedException | ExecutionException e) {
            if (Log.isLoggable("FirebaseInstanceId", 3)) {
                String valueOf = String.valueOf(e);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 22);
                sb.append("Error making request: ");
                sb.append(valueOf);
                Log.d("FirebaseInstanceId", sb.toString());
            }
            if (!(e.getCause() instanceof zzag) || ((zzag) e.getCause()).zza() != 4) {
                return null;
            }
            return zzb(bundle);
        }
    }

    private final Bundle zzb(Bundle bundle) throws IOException {
        Bundle zzc2 = zzc(bundle);
        if (zzc2 == null || !zzc2.containsKey("google.messenger")) {
            return zzc2;
        }
        Bundle zzc3 = zzc(bundle);
        if (zzc3 == null || !zzc3.containsKey("google.messenger")) {
            return zzc3;
        }
        return null;
    }

    private static synchronized String zza() {
        String num;
        synchronized (zzao.class) {
            int i = zza;
            zza = i + 1;
            num = Integer.toString(i);
        }
        return num;
    }

    /*  JADX ERROR: IndexOutOfBoundsException in pass: RegionMakerVisitor
        java.lang.IndexOutOfBoundsException: Index: 0, Size: 0
        	at java.util.ArrayList.rangeCheck(ArrayList.java:659)
        	at java.util.ArrayList.get(ArrayList.java:435)
        	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:101)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:611)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:693)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
        */
    private final android.os.Bundle zzc(android.os.Bundle r8) throws java.io.IOException {
        /*
            r7 = this;
            java.lang.String r0 = zza()
            com.google.android.gms.tasks.TaskCompletionSource r1 = new com.google.android.gms.tasks.TaskCompletionSource
            r1.<init>()
            androidx.collection.SimpleArrayMap<java.lang.String, com.google.android.gms.tasks.TaskCompletionSource<android.os.Bundle>> r2 = r7.zzc
            monitor-enter(r2)
            androidx.collection.SimpleArrayMap<java.lang.String, com.google.android.gms.tasks.TaskCompletionSource<android.os.Bundle>> r3 = r7.zzc     // Catch:{ all -> 0x0125 }
            r3.put(r0, r1)     // Catch:{ all -> 0x0125 }
            monitor-exit(r2)     // Catch:{ all -> 0x0125 }
            com.google.firebase.iid.zzai r2 = r7.zze
            int r2 = r2.zza()
            if (r2 == 0) goto L_0x011d
            android.content.Intent r2 = new android.content.Intent
            r2.<init>()
            java.lang.String r3 = "com.google.android.gms"
            r2.setPackage(r3)
            com.google.firebase.iid.zzai r3 = r7.zze
            int r3 = r3.zza()
            r4 = 2
            if (r3 != r4) goto L_0x0033
            java.lang.String r3 = "com.google.iid.TOKEN_REQUEST"
            r2.setAction(r3)
            goto L_0x0038
        L_0x0033:
            java.lang.String r3 = "com.google.android.c2dm.intent.REGISTER"
            r2.setAction(r3)
        L_0x0038:
            r2.putExtras(r8)
            android.content.Context r8 = r7.zzd
            zza((android.content.Context) r8, (android.content.Intent) r2)
            java.lang.String r8 = java.lang.String.valueOf(r0)
            int r8 = r8.length()
            int r8 = r8 + 5
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r8)
            java.lang.String r8 = "|ID|"
            r3.append(r8)
            r3.append(r0)
            java.lang.String r8 = "|"
            r3.append(r8)
            java.lang.String r8 = r3.toString()
            java.lang.String r3 = "kid"
            r2.putExtra(r3, r8)
            r8 = 3
            java.lang.String r3 = "FirebaseInstanceId"
            boolean r3 = android.util.Log.isLoggable(r3, r8)
            if (r3 == 0) goto L_0x0096
            android.os.Bundle r3 = r2.getExtras()
            java.lang.String r3 = java.lang.String.valueOf(r3)
            java.lang.String r5 = java.lang.String.valueOf(r3)
            int r5 = r5.length()
            int r5 = r5 + 8
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>(r5)
            java.lang.String r5 = "Sending "
            r6.append(r5)
            r6.append(r3)
            java.lang.String r3 = r6.toString()
            java.lang.String r5 = "FirebaseInstanceId"
            android.util.Log.d(r5, r3)
        L_0x0096:
            android.os.Messenger r3 = r7.zzf
            java.lang.String r5 = "google.messenger"
            r2.putExtra(r5, r3)
            android.os.Messenger r3 = r7.zzg
            if (r3 != 0) goto L_0x00a5
            com.google.firebase.iid.zzf r3 = r7.zzh
            if (r3 == 0) goto L_0x00ca
        L_0x00a5:
            android.os.Message r3 = android.os.Message.obtain()
            r3.obj = r2
            android.os.Messenger r5 = r7.zzg     // Catch:{ RemoteException -> 0x00bb }
            if (r5 == 0) goto L_0x00b5
            android.os.Messenger r5 = r7.zzg     // Catch:{ RemoteException -> 0x00bb }
            r5.send(r3)     // Catch:{ RemoteException -> 0x00bb }
            goto L_0x00dd
        L_0x00b5:
            com.google.firebase.iid.zzf r5 = r7.zzh     // Catch:{ RemoteException -> 0x00bb }
            r5.zza(r3)     // Catch:{ RemoteException -> 0x00bb }
            goto L_0x00dd
        L_0x00bb:
            java.lang.String r3 = "FirebaseInstanceId"
            boolean r8 = android.util.Log.isLoggable(r3, r8)
            if (r8 == 0) goto L_0x00ca
            java.lang.String r8 = "FirebaseInstanceId"
            java.lang.String r3 = "Messenger failed, fallback to startService"
            android.util.Log.d(r8, r3)
        L_0x00ca:
            com.google.firebase.iid.zzai r8 = r7.zze
            int r8 = r8.zza()
            if (r8 != r4) goto L_0x00d8
            android.content.Context r8 = r7.zzd
            r8.sendBroadcast(r2)
            goto L_0x00dd
        L_0x00d8:
            android.content.Context r8 = r7.zzd
            r8.startService(r2)
        L_0x00dd:
            com.google.android.gms.tasks.Task r8 = r1.getTask()     // Catch:{ InterruptedException | TimeoutException -> 0x0101, ExecutionException -> 0x00fa }
            r1 = 30000(0x7530, double:1.4822E-319)
            java.util.concurrent.TimeUnit r3 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch:{ InterruptedException | TimeoutException -> 0x0101, ExecutionException -> 0x00fa }
            java.lang.Object r8 = com.google.android.gms.tasks.Tasks.await(r8, r1, r3)     // Catch:{ InterruptedException | TimeoutException -> 0x0101, ExecutionException -> 0x00fa }
            android.os.Bundle r8 = (android.os.Bundle) r8     // Catch:{ InterruptedException | TimeoutException -> 0x0101, ExecutionException -> 0x00fa }
            androidx.collection.SimpleArrayMap<java.lang.String, com.google.android.gms.tasks.TaskCompletionSource<android.os.Bundle>> r1 = r7.zzc
            monitor-enter(r1)
            androidx.collection.SimpleArrayMap<java.lang.String, com.google.android.gms.tasks.TaskCompletionSource<android.os.Bundle>> r2 = r7.zzc     // Catch:{ all -> 0x00f5 }
            r2.remove(r0)     // Catch:{ all -> 0x00f5 }
            monitor-exit(r1)     // Catch:{ all -> 0x00f5 }
            return r8
        L_0x00f5:
            r8 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x00f5 }
            throw r8
        L_0x00f8:
            r8 = move-exception
            goto L_0x0110
        L_0x00fa:
            r8 = move-exception
            java.io.IOException r1 = new java.io.IOException     // Catch:{ all -> 0x00f8 }
            r1.<init>(r8)     // Catch:{ all -> 0x00f8 }
            throw r1     // Catch:{ all -> 0x00f8 }
        L_0x0101:
            java.lang.String r8 = "FirebaseInstanceId"
            java.lang.String r1 = "No response"
            android.util.Log.w(r8, r1)     // Catch:{ all -> 0x00f8 }
            java.io.IOException r8 = new java.io.IOException     // Catch:{ all -> 0x00f8 }
            java.lang.String r1 = "TIMEOUT"
            r8.<init>(r1)     // Catch:{ all -> 0x00f8 }
            throw r8     // Catch:{ all -> 0x00f8 }
        L_0x0110:
            androidx.collection.SimpleArrayMap<java.lang.String, com.google.android.gms.tasks.TaskCompletionSource<android.os.Bundle>> r1 = r7.zzc
            monitor-enter(r1)
            androidx.collection.SimpleArrayMap<java.lang.String, com.google.android.gms.tasks.TaskCompletionSource<android.os.Bundle>> r2 = r7.zzc     // Catch:{ all -> 0x011a }
            r2.remove(r0)     // Catch:{ all -> 0x011a }
            monitor-exit(r1)     // Catch:{ all -> 0x011a }
            throw r8
        L_0x011a:
            r8 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x011a }
            throw r8
        L_0x011d:
            java.io.IOException r8 = new java.io.IOException
            java.lang.String r0 = "MISSING_INSTANCEID_SERVICE"
            r8.<init>(r0)
            throw r8
        L_0x0125:
            r8 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x0125 }
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.iid.zzao.zzc(android.os.Bundle):android.os.Bundle");
    }
}
