package com.xiaomi.push;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.os.IBinder;
import android.os.Parcel;

/* renamed from: com.xiaomi.push.ar */
class C1629ar implements C1633at {

    /* renamed from: a */
    private static boolean f1788a;
    /* access modifiers changed from: private */

    /* renamed from: a */
    public volatile int f1789a = 0;

    /* renamed from: a */
    private Context f1790a;

    /* renamed from: a */
    private ServiceConnection f1791a;

    /* renamed from: a */
    private final Object f1792a = new Object();
    /* access modifiers changed from: private */

    /* renamed from: a */
    public volatile String f1793a = null;

    /* renamed from: b */
    private volatile String f1794b = null;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public volatile boolean f1795b = false;

    /* renamed from: com.xiaomi.push.ar$a */
    private class C1630a implements ServiceConnection {
        private C1630a() {
        }

        /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x0052 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x0073 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:8:0x0030 */
        /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onServiceConnected(android.content.ComponentName r3, android.os.IBinder r4) {
            /*
                r2 = this;
                r3 = 2
                com.xiaomi.push.ar r0 = com.xiaomi.push.C1629ar.this     // Catch:{ Exception -> 0x0056, all -> 0x0034 }
                java.lang.String r1 = com.xiaomi.push.C1629ar.C1631b.m2566a((android.os.IBinder) r4)     // Catch:{ Exception -> 0x0056, all -> 0x0034 }
                java.lang.String unused = r0.f1793a = r1     // Catch:{ Exception -> 0x0056, all -> 0x0034 }
                com.xiaomi.push.ar r0 = com.xiaomi.push.C1629ar.this     // Catch:{ Exception -> 0x0056, all -> 0x0034 }
                boolean r4 = com.xiaomi.push.C1629ar.C1631b.m2566a((android.os.IBinder) r4)     // Catch:{ Exception -> 0x0056, all -> 0x0034 }
                boolean unused = r0.f1795b = r4     // Catch:{ Exception -> 0x0056, all -> 0x0034 }
                com.xiaomi.push.ar r4 = com.xiaomi.push.C1629ar.this
                com.xiaomi.push.C1629ar.m2552a((com.xiaomi.push.C1629ar) r4)
                com.xiaomi.push.ar r4 = com.xiaomi.push.C1629ar.this
                int unused = r4.f1789a = r3
                com.xiaomi.push.ar r3 = com.xiaomi.push.C1629ar.this
                java.lang.Object r4 = com.xiaomi.push.C1629ar.m2552a((com.xiaomi.push.C1629ar) r3)
                monitor-enter(r4)
                com.xiaomi.push.ar r3 = com.xiaomi.push.C1629ar.this     // Catch:{ Exception -> 0x0030 }
                java.lang.Object r3 = com.xiaomi.push.C1629ar.m2552a((com.xiaomi.push.C1629ar) r3)     // Catch:{ Exception -> 0x0030 }
                r3.notifyAll()     // Catch:{ Exception -> 0x0030 }
                goto L_0x0030
            L_0x002e:
                r3 = move-exception
                goto L_0x0032
            L_0x0030:
                monitor-exit(r4)     // Catch:{ all -> 0x002e }
                goto L_0x0074
            L_0x0032:
                monitor-exit(r4)     // Catch:{ all -> 0x002e }
                throw r3
            L_0x0034:
                r4 = move-exception
                com.xiaomi.push.ar r0 = com.xiaomi.push.C1629ar.this
                com.xiaomi.push.C1629ar.m2552a((com.xiaomi.push.C1629ar) r0)
                com.xiaomi.push.ar r0 = com.xiaomi.push.C1629ar.this
                int unused = r0.f1789a = r3
                com.xiaomi.push.ar r3 = com.xiaomi.push.C1629ar.this
                java.lang.Object r0 = com.xiaomi.push.C1629ar.m2552a((com.xiaomi.push.C1629ar) r3)
                monitor-enter(r0)
                com.xiaomi.push.ar r3 = com.xiaomi.push.C1629ar.this     // Catch:{ Exception -> 0x0052 }
                java.lang.Object r3 = com.xiaomi.push.C1629ar.m2552a((com.xiaomi.push.C1629ar) r3)     // Catch:{ Exception -> 0x0052 }
                r3.notifyAll()     // Catch:{ Exception -> 0x0052 }
                goto L_0x0052
            L_0x0050:
                r3 = move-exception
                goto L_0x0054
            L_0x0052:
                monitor-exit(r0)     // Catch:{ all -> 0x0050 }
                throw r4
            L_0x0054:
                monitor-exit(r0)     // Catch:{ all -> 0x0050 }
                throw r3
            L_0x0056:
                com.xiaomi.push.ar r4 = com.xiaomi.push.C1629ar.this
                com.xiaomi.push.C1629ar.m2552a((com.xiaomi.push.C1629ar) r4)
                com.xiaomi.push.ar r4 = com.xiaomi.push.C1629ar.this
                int unused = r4.f1789a = r3
                com.xiaomi.push.ar r3 = com.xiaomi.push.C1629ar.this
                java.lang.Object r3 = com.xiaomi.push.C1629ar.m2552a((com.xiaomi.push.C1629ar) r3)
                monitor-enter(r3)
                com.xiaomi.push.ar r4 = com.xiaomi.push.C1629ar.this     // Catch:{ Exception -> 0x0073 }
                java.lang.Object r4 = com.xiaomi.push.C1629ar.m2552a((com.xiaomi.push.C1629ar) r4)     // Catch:{ Exception -> 0x0073 }
                r4.notifyAll()     // Catch:{ Exception -> 0x0073 }
                goto L_0x0073
            L_0x0071:
                r4 = move-exception
                goto L_0x0075
            L_0x0073:
                monitor-exit(r3)     // Catch:{ all -> 0x0071 }
            L_0x0074:
                return
            L_0x0075:
                monitor-exit(r3)     // Catch:{ all -> 0x0071 }
                throw r4
            */
            throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.C1629ar.C1630a.onServiceConnected(android.content.ComponentName, android.os.IBinder):void");
        }

        public void onServiceDisconnected(ComponentName componentName) {
        }
    }

    /* renamed from: com.xiaomi.push.ar$b */
    private static class C1631b {
        /* renamed from: a */
        static String m2566a(IBinder iBinder) {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
                iBinder.transact(1, obtain, obtain2, 0);
                obtain2.readException();
                return obtain2.readString();
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        /* renamed from: a */
        static boolean m2567a(IBinder iBinder) {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
                boolean z = false;
                iBinder.transact(2, obtain, obtain2, 0);
                obtain2.readException();
                if (obtain2.readInt() != 0) {
                    z = true;
                }
                return z;
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }
    }

    public C1629ar(Context context) {
        this.f1790a = context;
        mo17232a();
    }

    /* renamed from: a */
    private static String m2553a(Context context) {
        String str;
        String str2;
        try {
            if (Build.VERSION.SDK_INT >= 24) {
                str2 = context.createDeviceProtectedStorageContext().getSharedPreferences("aaid", 0).getString("aaid", (String) null);
                if (str2 != null) {
                    return str2;
                }
            } else {
                str2 = null;
            }
            try {
                str = context.getSharedPreferences("aaid", 0).getString("aaid", (String) null);
            } catch (Exception unused) {
                str = str2;
            }
        } catch (Exception unused2) {
            str = null;
        }
        return str == null ? "" : str;
    }

    /* renamed from: a */
    private void mo17232a() {
        boolean z;
        this.f1791a = new C1630a();
        Intent intent = new Intent("com.uodis.opendevice.OPENIDS_SERVICE");
        intent.setPackage("com.huawei.hwid");
        int i = 1;
        try {
            z = this.f1790a.bindService(intent, this.f1791a, 1);
        } catch (Exception unused) {
            z = false;
        }
        if (!z) {
            i = 2;
        }
        this.f1789a = i;
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0035 */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m2557a(java.lang.String r4) {
        /*
            r3 = this;
            int r0 = r3.f1789a
            r1 = 1
            if (r0 != r1) goto L_0x0039
            android.os.Looper r0 = android.os.Looper.myLooper()
            android.os.Looper r1 = android.os.Looper.getMainLooper()
            if (r0 == r1) goto L_0x0039
            java.lang.Object r0 = r3.f1792a
            monitor-enter(r0)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0035 }
            r1.<init>()     // Catch:{ Exception -> 0x0035 }
            java.lang.String r2 = "huawei's "
            r1.append(r2)     // Catch:{ Exception -> 0x0035 }
            r1.append(r4)     // Catch:{ Exception -> 0x0035 }
            java.lang.String r4 = " wait..."
            r1.append(r4)     // Catch:{ Exception -> 0x0035 }
            java.lang.String r4 = r1.toString()     // Catch:{ Exception -> 0x0035 }
            com.xiaomi.channel.commonutils.logger.C1524b.m2141a((java.lang.String) r4)     // Catch:{ Exception -> 0x0035 }
            java.lang.Object r4 = r3.f1792a     // Catch:{ Exception -> 0x0035 }
            r1 = 3000(0xbb8, double:1.482E-320)
            r4.wait(r1)     // Catch:{ Exception -> 0x0035 }
            goto L_0x0035
        L_0x0033:
            r4 = move-exception
            goto L_0x0037
        L_0x0035:
            monitor-exit(r0)     // Catch:{ all -> 0x0033 }
            goto L_0x0039
        L_0x0037:
            monitor-exit(r0)     // Catch:{ all -> 0x0033 }
            throw r4
        L_0x0039:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.C1629ar.m2557a(java.lang.String):void");
    }

    /* renamed from: a */
    public static boolean m2558a(Context context) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo("com.huawei.hwid", 128);
            boolean z = (packageInfo.applicationInfo.flags & 1) != 0;
            f1788a = packageInfo.versionCode >= 20602000;
            return z;
        } catch (Exception unused) {
        }
    }

    /* renamed from: b */
    private void mo17233b() {
        ServiceConnection serviceConnection = this.f1791a;
        if (serviceConnection != null) {
            try {
                this.f1790a.unbindService(serviceConnection);
            } catch (Exception unused) {
            }
        }
    }

    /* renamed from: a */
    public String m2561a() {
        return null;
    }

    /* renamed from: a */
    public boolean m2562a() {
        return f1788a;
    }

    /* renamed from: b */
    public String m2563b() {
        m2557a("getOAID");
        return this.f1793a;
    }

    /* renamed from: c */
    public String mo17234c() {
        return null;
    }

    /* renamed from: d */
    public String mo17235d() {
        if (this.f1794b == null) {
            synchronized (this) {
                if (this.f1794b == null) {
                    this.f1794b = m2553a(this.f1790a);
                }
            }
        }
        return this.f1794b;
    }
}
