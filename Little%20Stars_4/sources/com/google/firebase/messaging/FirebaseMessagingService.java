package com.google.firebase.messaging;

import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.WorkerThread;
import android.util.Log;
import com.google.firebase.iid.FirebaseInstanceIdInternalReceiver;
import com.google.firebase.iid.FirebaseInstanceIdReceiver;
import com.google.firebase.iid.zzb;
import com.xiaomi.mipush.sdk.PushMessageHelper;
import java.util.Iterator;

public class FirebaseMessagingService extends zzb {
    private void zzD(Intent intent) {
        PendingIntent pendingIntent = (PendingIntent) intent.getParcelableExtra("pending_intent");
        if (pendingIntent != null) {
            try {
                pendingIntent.send();
            } catch (PendingIntent.CanceledException unused) {
                Log.e("FirebaseMessaging", "Notification pending intent canceled");
            }
        }
        if (zzT(intent.getExtras())) {
            zzb.zzm(this, intent);
        }
    }

    private String zzE(Intent intent) {
        String stringExtra = intent.getStringExtra("google.message_id");
        return stringExtra == null ? intent.getStringExtra("message_id") : stringExtra;
    }

    static boolean zzT(Bundle bundle) {
        return "1".equals(bundle.getString("google.c.a.e"));
    }

    private void zzn(Intent intent) {
        String stringExtra = intent.getStringExtra(PushMessageHelper.MESSAGE_TYPE);
        if (stringExtra == null) {
            stringExtra = "gcm";
        }
        char c = 65535;
        switch (stringExtra.hashCode()) {
            case -2062414158:
                if (stringExtra.equals("deleted_messages")) {
                    c = 1;
                    break;
                }
                break;
            case 102161:
                if (stringExtra.equals("gcm")) {
                    c = 0;
                    break;
                }
                break;
            case 814694033:
                if (stringExtra.equals("send_error")) {
                    c = 3;
                    break;
                }
                break;
            case 814800675:
                if (stringExtra.equals("send_event")) {
                    c = 2;
                    break;
                }
                break;
        }
        if (c == 0) {
            if (zzT(intent.getExtras())) {
                zzb.zzl(this, intent);
            }
            zzo(intent);
        } else if (c == 1) {
            onDeletedMessages();
        } else if (c == 2) {
            onMessageSent(intent.getStringExtra("google.message_id"));
        } else if (c != 3) {
            String valueOf = String.valueOf(stringExtra);
            Log.w("FirebaseMessaging", valueOf.length() != 0 ? "Received message with unknown type: ".concat(valueOf) : new String("Received message with unknown type: "));
        } else {
            onSendError(zzE(intent), new SendException(intent.getStringExtra("error")));
        }
    }

    private void zzo(Intent intent) {
        Bundle extras = intent.getExtras();
        extras.remove("android.support.content.wakelockid");
        if (zza.zzA(extras)) {
            if (!zza.zzaR(this)) {
                zza.zzbB(this).zzQ(extras);
                return;
            } else if (zzT(intent.getExtras())) {
                zzb.zzo(this, intent);
            }
        }
        onMessageReceived(new RemoteMessage(extras));
    }

    static void zzz(Bundle bundle) {
        Iterator it = bundle.keySet().iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            if (str != null && str.startsWith("google.c.")) {
                it.remove();
            }
        }
    }

    @WorkerThread
    public void onDeletedMessages() {
    }

    @WorkerThread
    public void onMessageReceived(RemoteMessage remoteMessage) {
    }

    @WorkerThread
    public void onMessageSent(String str) {
    }

    @WorkerThread
    public void onSendError(String str, Exception exc) {
    }

    /* access modifiers changed from: protected */
    public int zzA(Intent intent) {
        if (!"com.google.firebase.messaging.NOTIFICATION_OPEN".equals(intent.getAction())) {
            return super.zzA(intent);
        }
        zzD(intent);
        zzBL();
        FirebaseInstanceIdReceiver.completeWakefulIntent(intent);
        return 3;
    }

    public void zzm(Intent intent) {
        try {
            String action = intent.getAction();
            char c = 65535;
            int hashCode = action.hashCode();
            if (hashCode != 75300319) {
                if (hashCode == 366519424) {
                    if (action.equals("com.google.android.c2dm.intent.RECEIVE")) {
                        c = 0;
                    }
                }
            } else if (action.equals("com.google.firebase.messaging.NOTIFICATION_DISMISS")) {
                c = 1;
            }
            if (c == 0) {
                zzn(intent);
            } else if (c != 1) {
                String valueOf = String.valueOf(intent.getAction());
                Log.d("FirebaseMessaging", valueOf.length() != 0 ? "Unknown intent action: ".concat(valueOf) : new String("Unknown intent action: "));
            } else if (zzT(intent.getExtras())) {
                zzb.zzn(this, intent);
            }
            zzBL();
        } finally {
            FirebaseInstanceIdReceiver.completeWakefulIntent(intent);
        }
    }

    /* access modifiers changed from: protected */
    public Intent zzz(Intent intent) {
        return FirebaseInstanceIdInternalReceiver.zzUr();
    }
}
