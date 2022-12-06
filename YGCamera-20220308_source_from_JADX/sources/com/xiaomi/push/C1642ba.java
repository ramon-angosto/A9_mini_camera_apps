package com.xiaomi.push;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import android.os.Build;
import android.os.IBinder;
import android.os.Parcel;
import java.security.MessageDigest;

/* renamed from: com.xiaomi.push.ba */
class C1642ba implements C1633at {

    /* renamed from: a */
    private static boolean f1841a;
    /* access modifiers changed from: private */

    /* renamed from: a */
    public volatile int f1842a = 0;

    /* renamed from: a */
    private Context f1843a;

    /* renamed from: a */
    private ServiceConnection f1844a;
    /* access modifiers changed from: private */

    /* renamed from: a */
    public volatile C1643a f1845a = null;

    /* renamed from: a */
    private final Object f1846a = new Object();

    /* renamed from: com.xiaomi.push.ba$a */
    private class C1643a {

        /* renamed from: a */
        String f1848a;

        /* renamed from: b */
        String f1849b;

        /* renamed from: c */
        String f1850c;

        /* renamed from: d */
        String f1851d;

        private C1643a() {
            this.f1848a = null;
            this.f1849b = null;
            this.f1850c = null;
            this.f1851d = null;
        }
    }

    /* renamed from: com.xiaomi.push.ba$b */
    private class C1644b implements ServiceConnection {
        private C1644b() {
        }

        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            if (C1642ba.m2635a(C1642ba.this) == null) {
                new Thread(new C1647bc(this, iBinder)).start();
            }
        }

        public void onServiceDisconnected(ComponentName componentName) {
        }
    }

    /* renamed from: com.xiaomi.push.ba$c */
    private static class C1645c {
        /* renamed from: a */
        static String m2651a(IBinder iBinder, String str, String str2, String str3) {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.heytap.openid.IOpenID");
                obtain.writeString(str);
                obtain.writeString(str2);
                obtain.writeString(str3);
                iBinder.transact(1, obtain, obtain2, 0);
                obtain2.readException();
                return obtain2.readString();
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }
    }

    public C1642ba(Context context) {
        this.f1843a = context;
        mo17232a();
    }

    /* renamed from: a */
    private void mo17232a() {
        boolean z;
        this.f1844a = new C1644b();
        Intent intent = new Intent();
        intent.setClassName("com.heytap.openid", "com.heytap.openid.IdentifyService");
        intent.setAction("action.com.heytap.openid.OPEN_ID_SERVICE");
        int i = 1;
        try {
            z = this.f1843a.bindService(intent, this.f1844a, 1);
        } catch (Exception unused) {
            z = false;
        }
        if (!z) {
            i = 2;
        }
        this.f1842a = i;
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0035 */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m2642a(java.lang.String r4) {
        /*
            r3 = this;
            int r0 = r3.f1842a
            r1 = 1
            if (r0 != r1) goto L_0x0039
            android.os.Looper r0 = android.os.Looper.myLooper()
            android.os.Looper r1 = android.os.Looper.getMainLooper()
            if (r0 == r1) goto L_0x0039
            java.lang.Object r0 = r3.f1846a
            monitor-enter(r0)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0035 }
            r1.<init>()     // Catch:{ Exception -> 0x0035 }
            java.lang.String r2 = "oppo's "
            r1.append(r2)     // Catch:{ Exception -> 0x0035 }
            r1.append(r4)     // Catch:{ Exception -> 0x0035 }
            java.lang.String r4 = " wait..."
            r1.append(r4)     // Catch:{ Exception -> 0x0035 }
            java.lang.String r4 = r1.toString()     // Catch:{ Exception -> 0x0035 }
            com.xiaomi.channel.commonutils.logger.C1524b.m2141a((java.lang.String) r4)     // Catch:{ Exception -> 0x0035 }
            java.lang.Object r4 = r3.f1846a     // Catch:{ Exception -> 0x0035 }
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
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.C1642ba.m2642a(java.lang.String):void");
    }

    /* renamed from: a */
    public static boolean m2643a(Context context) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo("com.heytap.openid", 128);
            if (packageInfo != null) {
                long longVersionCode = Build.VERSION.SDK_INT >= 28 ? packageInfo.getLongVersionCode() : (long) packageInfo.versionCode;
                boolean z = (packageInfo.applicationInfo.flags & 1) != 0;
                f1841a = longVersionCode >= 1;
                if (z) {
                    return true;
                }
            }
        } catch (Exception unused) {
        }
        return false;
    }

    /* renamed from: b */
    private void mo17233b() {
        ServiceConnection serviceConnection = this.f1844a;
        if (serviceConnection != null) {
            try {
                this.f1843a.unbindService(serviceConnection);
            } catch (Exception unused) {
            }
        }
    }

    /* renamed from: e */
    private String m2645e() {
        try {
            Signature[] signatureArr = this.f1843a.getPackageManager().getPackageInfo(this.f1843a.getPackageName(), 64).signatures;
            MessageDigest instance = MessageDigest.getInstance("SHA1");
            StringBuilder sb = new StringBuilder();
            byte[] digest = instance.digest(signatureArr[0].toByteArray());
            for (byte b : digest) {
                sb.append(Integer.toHexString((b & 255) | 256).substring(1, 3));
            }
            return sb.toString();
        } catch (Exception unused) {
            return "";
        }
    }

    /* renamed from: a */
    public String m2646a() {
        m2642a("getUDID");
        if (this.f1845a == null) {
            return null;
        }
        return this.f1845a.f1848a;
    }

    /* renamed from: a */
    public boolean m2647a() {
        return f1841a;
    }

    /* renamed from: b */
    public String m2648b() {
        m2642a("getOAID");
        if (this.f1845a == null) {
            return null;
        }
        return this.f1845a.f1849b;
    }

    /* renamed from: c */
    public String mo17234c() {
        m2642a("getVAID");
        if (this.f1845a == null) {
            return null;
        }
        return this.f1845a.f1850c;
    }

    /* renamed from: d */
    public String mo17235d() {
        m2642a("getAAID");
        if (this.f1845a == null) {
            return null;
        }
        return this.f1845a.f1851d;
    }
}
