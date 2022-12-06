package com.huawei.hms.adapter.sysobs;

import android.content.Intent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class SystemManager {

    /* renamed from: a */
    public static SystemManager f255a = new SystemManager();

    /* renamed from: b */
    public static final Object f256b = new Object();

    /* renamed from: c */
    public static SystemNotifier f257c = new C0612a();

    public static SystemManager getInstance() {
        return f255a;
    }

    public static SystemNotifier getSystemNotifier() {
        return f257c;
    }

    public void notifyResolutionResult(Intent intent, String str) {
        f257c.notifyObservers(intent, str);
    }

    public void notifyUpdateResult(int i) {
        f257c.notifyObservers(i);
    }

    /* renamed from: com.huawei.hms.adapter.sysobs.SystemManager$a */
    public static class C0612a implements SystemNotifier {

        /* renamed from: a */
        public final List<SystemObserver> f258a = new ArrayList();

        public void notifyObservers(Intent intent, String str) {
            synchronized (SystemManager.f256b) {
                Iterator<SystemObserver> it = this.f258a.iterator();
                while (it.hasNext()) {
                    if (it.next().onSolutionResult(intent, str)) {
                        it.remove();
                    }
                }
            }
        }

        public void registerObserver(SystemObserver systemObserver) {
            if (systemObserver != null && !this.f258a.contains(systemObserver)) {
                synchronized (SystemManager.f256b) {
                    this.f258a.add(systemObserver);
                }
            }
        }

        public void unRegisterObserver(SystemObserver systemObserver) {
            synchronized (SystemManager.f256b) {
                this.f258a.remove(systemObserver);
            }
        }

        public void notifyObservers(int i) {
            synchronized (SystemManager.f256b) {
                Iterator<SystemObserver> it = this.f258a.iterator();
                while (it.hasNext()) {
                    if (it.next().onUpdateResult(i)) {
                        it.remove();
                    }
                }
            }
        }
    }
}
