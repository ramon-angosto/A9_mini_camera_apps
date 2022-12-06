package com.iab.omid.library.bigosg.c;

import android.app.KeyguardManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import java.util.Collections;

public final class b {
    private static b f = new b();
    public Context a;
    public BroadcastReceiver b;
    public boolean c;
    public boolean d;
    public a e;

    public interface a {
        void a(boolean z);
    }

    private b() {
    }

    public static b a() {
        return f;
    }

    static /* synthetic */ void a(b bVar, boolean z) {
        if (bVar.d != z) {
            bVar.d = z;
            if (bVar.c) {
                bVar.d();
                a aVar = bVar.e;
                if (aVar != null) {
                    aVar.a(bVar.c());
                }
            }
        }
    }

    private void d() {
        boolean z = !this.d;
        for (T t : Collections.unmodifiableCollection(a.a().a)) {
            com.iab.omid.library.bigosg.g.a aVar = t.c;
            if (aVar.a.get() != null) {
                e.a().a(aVar.c(), "setState", z ? "foregrounded" : "backgrounded");
            }
        }
    }

    public final void b() {
        this.b = new BroadcastReceiver() {
            public final void onReceive(Context context, Intent intent) {
                KeyguardManager keyguardManager;
                if (intent != null) {
                    if ("android.intent.action.SCREEN_OFF".equals(intent.getAction())) {
                        b.a(b.this, true);
                    } else if ("android.intent.action.USER_PRESENT".equals(intent.getAction())) {
                        b.a(b.this, false);
                    } else if ("android.intent.action.SCREEN_ON".equals(intent.getAction()) && (keyguardManager = (KeyguardManager) context.getSystemService("keyguard")) != null && !keyguardManager.inKeyguardRestrictedInputMode()) {
                        b.a(b.this, false);
                    }
                }
            }
        };
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        intentFilter.addAction("android.intent.action.SCREEN_ON");
        intentFilter.addAction("android.intent.action.USER_PRESENT");
        this.a.registerReceiver(this.b, intentFilter);
        this.c = true;
        d();
    }

    public final boolean c() {
        return !this.d;
    }
}
