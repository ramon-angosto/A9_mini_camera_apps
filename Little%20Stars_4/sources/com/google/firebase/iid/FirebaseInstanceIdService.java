package com.google.firebase.iid;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.annotation.WorkerThread;
import android.util.Log;
import com.google.firebase.FirebaseApp;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.meizu.cloud.pushsdk.notification.model.NotifyType;
import java.io.IOException;

public class FirebaseInstanceIdService extends zzb {
    private static BroadcastReceiver zzbSI;
    private static final Object zzbSJ = new Object();
    private static boolean zzbSK = false;
    /* access modifiers changed from: private */
    public boolean zzbSL = false;

    private String zzC(Intent intent) {
        String stringExtra = intent.getStringExtra("subtype");
        return stringExtra == null ? "" : stringExtra;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0018, code lost:
        if (r3.zzUp().zzUu() != null) goto L_0x001b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001a, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x001b, code lost:
        zzbx(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x001e, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x000e, code lost:
        if (r3.zzUn() == null) goto L_0x001b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static void zza(android.content.Context r2, com.google.firebase.iid.FirebaseInstanceId r3) {
        /*
            java.lang.Object r0 = zzbSJ
            monitor-enter(r0)
            boolean r1 = zzbSK     // Catch:{ all -> 0x001f }
            if (r1 == 0) goto L_0x0009
            monitor-exit(r0)     // Catch:{ all -> 0x001f }
            return
        L_0x0009:
            monitor-exit(r0)     // Catch:{ all -> 0x001f }
            java.lang.String r0 = r3.zzUn()
            if (r0 == 0) goto L_0x001b
            com.google.firebase.iid.zze r3 = r3.zzUp()
            java.lang.String r3 = r3.zzUu()
            if (r3 != 0) goto L_0x001b
            return
        L_0x001b:
            zzbx(r2)
            return
        L_0x001f:
            r2 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x001f }
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.iid.FirebaseInstanceIdService.zza(android.content.Context, com.google.firebase.iid.FirebaseInstanceId):void");
    }

    private void zza(Intent intent, boolean z) {
        String str;
        String str2;
        synchronized (zzbSJ) {
            zzbSK = false;
        }
        FirebaseInstanceId instance = FirebaseInstanceId.getInstance();
        zze zzUp = instance.zzUp();
        if (instance.zzUn() == null) {
            try {
                if (instance.zzUo() != null) {
                    if (this.zzbSL) {
                        Log.d("FirebaseInstanceId", "get master token succeeded");
                    }
                    zza((Context) this, instance);
                    onTokenRefresh();
                    return;
                }
                zzd(intent, "returned token is null");
            } catch (IOException e) {
                zzd(intent, e.getMessage());
            } catch (SecurityException e2) {
                Log.e("FirebaseInstanceId", "Unable to get master token", e2);
            }
        } else {
            while (true) {
                String zzUu = zzUp.zzUu();
                if (zzUu != null) {
                    String[] split = zzUu.split("!");
                    if (split.length == 2) {
                        String str3 = split[0];
                        String str4 = split[1];
                        char c = 65535;
                        try {
                            int hashCode = str3.hashCode();
                            if (hashCode != 83) {
                                if (hashCode == 85) {
                                    if (str3.equals("U")) {
                                        c = 1;
                                    }
                                }
                            } else if (str3.equals("S")) {
                                c = 0;
                            }
                            if (c == 0) {
                                FirebaseInstanceId.getInstance().zziz(str4);
                                if (this.zzbSL) {
                                    str = "FirebaseInstanceId";
                                    str2 = "subscribe operation succeeded";
                                }
                            } else if (c == 1) {
                                FirebaseInstanceId.getInstance().zziA(str4);
                                if (this.zzbSL) {
                                    str = "FirebaseInstanceId";
                                    str2 = "unsubscribe operation succeeded";
                                }
                            }
                            Log.d(str, str2);
                        } catch (IOException e3) {
                            zzd(intent, e3.getMessage());
                            return;
                        }
                    }
                    zzUp.zziC(zzUu);
                } else {
                    Log.d("FirebaseInstanceId", "topic sync succeeded");
                    return;
                }
            }
        }
    }

    private int zzb(Intent intent, boolean z) {
        int intExtra = intent == null ? 10 : intent.getIntExtra("next_retry_delay_in_seconds", 0);
        if (intExtra < 10 && !z) {
            return 30;
        }
        if (intExtra < 10) {
            return 10;
        }
        if (intExtra > 28800) {
            return 28800;
        }
        return intExtra;
    }

    static void zzbx(Context context) {
        synchronized (zzbSJ) {
            if (!zzbSK) {
                context.sendBroadcast(zznF(0));
                zzbSK = true;
            }
        }
    }

    /* access modifiers changed from: private */
    public static boolean zzby(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    private void zzd(Intent intent, String str) {
        boolean zzby = zzby(this);
        final int zzb = zzb(intent, zzby);
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 47);
        sb.append("background sync failed: ");
        sb.append(str);
        sb.append(", retry in ");
        sb.append(zzb);
        sb.append(NotifyType.SOUND);
        Log.d("FirebaseInstanceId", sb.toString());
        synchronized (zzbSJ) {
            zznG(zzb);
            zzbSK = true;
        }
        if (!zzby) {
            if (this.zzbSL) {
                Log.d("FirebaseInstanceId", "device not connected. Connectivity change received registered");
            }
            if (zzbSI == null) {
                zzbSI = new BroadcastReceiver() {
                    public void onReceive(Context context, Intent intent) {
                        if (FirebaseInstanceIdService.zzby(context)) {
                            if (FirebaseInstanceIdService.this.zzbSL) {
                                Log.d("FirebaseInstanceId", "connectivity changed. starting background sync.");
                            }
                            FirebaseInstanceIdService.this.getApplicationContext().unregisterReceiver(this);
                            context.sendBroadcast(FirebaseInstanceIdService.zznF(zzb));
                        }
                    }
                };
            }
            getApplicationContext().registerReceiver(zzbSI, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        }
    }

    private zzd zziB(String str) {
        if (str == null) {
            return zzd.zzb(this, (Bundle) null);
        }
        Bundle bundle = new Bundle();
        bundle.putString("subtype", str);
        return zzd.zzb(this, bundle);
    }

    /* access modifiers changed from: private */
    public static Intent zznF(int i) {
        Context applicationContext = FirebaseApp.getInstance().getApplicationContext();
        Intent intent = new Intent("ACTION_TOKEN_REFRESH_RETRY");
        intent.putExtra("next_retry_delay_in_seconds", i);
        return FirebaseInstanceIdInternalReceiver.zzh(applicationContext, intent);
    }

    private void zznG(int i) {
        ((AlarmManager) getSystemService("alarm")).set(3, SystemClock.elapsedRealtime() + ((long) (i * PushConstants.PUSHSERVICE_INFO_SENDMESSAGE_BY_NOTIFICATIONSERVICE)), PendingIntent.getBroadcast(this, 0, zznF(i * 2), 268435456));
    }

    @WorkerThread
    public void onTokenRefresh() {
    }

    /* access modifiers changed from: protected */
    public int zzA(Intent intent) {
        this.zzbSL = Log.isLoggable("FirebaseInstanceId", 3);
        if (intent.getStringExtra("error") == null && intent.getStringExtra("registration_id") == null) {
            return super.zzA(intent);
        }
        String zzC = zzC(intent);
        if (this.zzbSL) {
            String valueOf = String.valueOf(zzC);
            Log.d("FirebaseInstanceId", valueOf.length() != 0 ? "Register result in service ".concat(valueOf) : new String("Register result in service "));
        }
        zziB(zzC).zzUt().zzu(intent);
        zzBL();
        return 2;
    }

    public void zzB(Intent intent) {
        String zzC = zzC(intent);
        zzd zziB = zziB(zzC);
        String stringExtra = intent.getStringExtra("CMD");
        if (this.zzbSL) {
            String valueOf = String.valueOf(intent.getExtras());
            StringBuilder sb = new StringBuilder(String.valueOf(zzC).length() + 18 + String.valueOf(stringExtra).length() + String.valueOf(valueOf).length());
            sb.append("Service command ");
            sb.append(zzC);
            sb.append(" ");
            sb.append(stringExtra);
            sb.append(" ");
            sb.append(valueOf);
            Log.d("FirebaseInstanceId", sb.toString());
        }
        if (intent.getStringExtra(PushConstants.EXTRA_UNREGISTERED) != null) {
            zzg zzUs = zziB.zzUs();
            if (zzC == null) {
                zzC = "";
            }
            zzUs.zzeG(zzC);
            zziB.zzUt().zzu(intent);
        } else if ("gcm.googleapis.com/refresh".equals(intent.getStringExtra("from"))) {
            zziB.zzUs().zzeG(zzC);
            zza(intent, false);
        } else {
            if ("RST".equals(stringExtra)) {
                zziB.zzCe();
            } else if ("RST_FULL".equals(stringExtra)) {
                if (!zziB.zzUs().isEmpty()) {
                    zziB.zzUs().zzCk();
                } else {
                    return;
                }
            } else if ("SYNC".equals(stringExtra)) {
                zziB.zzUs().zzeG(zzC);
                zza(intent, false);
                return;
            } else {
                "PING".equals(stringExtra);
                return;
            }
            zza(intent, true);
        }
    }

    public void zzm(Intent intent) {
        String action = intent.getAction();
        if (action == null) {
            action = "";
        }
        char c = 65535;
        if (action.hashCode() == -1737547627 && action.equals("ACTION_TOKEN_REFRESH_RETRY")) {
            c = 0;
        }
        if (c != 0) {
            zzB(intent);
        } else {
            zza(intent, false);
        }
    }

    /* access modifiers changed from: protected */
    public Intent zzz(Intent intent) {
        return FirebaseInstanceIdInternalReceiver.zzUq();
    }
}
