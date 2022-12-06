package com.mbridge.msdk.foundation.controller;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.tools.m;
import com.mbridge.msdk.foundation.tools.q;
import com.mbridge.msdk.foundation.tools.w;
import com.mbridge.msdk.foundation.tools.x;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: MBSDKContext */
public class a {
    public static final String a = a.class.getSimpleName();
    public static List<String> b = new ArrayList();
    private static a c;
    /* access modifiers changed from: private */
    public Context d;
    /* access modifiers changed from: private */
    public String e;
    private String f;
    private int g = 0;
    private JSONObject h;
    private int i;
    private boolean j = false;
    private int k;
    private WeakReference<Context> l;
    private WeakReference<Activity> m;
    private String n;

    /* compiled from: MBSDKContext */
    public interface b {
    }

    public final WeakReference<Activity> a() {
        return this.m;
    }

    public final void a(WeakReference<Activity> weakReference) {
        this.m = weakReference;
    }

    public final void a(int i2) {
        this.i = i2;
    }

    public final String b() {
        try {
            if (this.d != null) {
                return this.d.getPackageName();
            }
            return null;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public final Context c() {
        WeakReference<Context> weakReference = this.l;
        if (weakReference == null) {
            return null;
        }
        return (Context) weakReference.get();
    }

    public final void a(Context context) {
        this.l = new WeakReference<>(context);
    }

    public final void d() {
        try {
            if (this.l != null) {
                this.l.clear();
            }
        } catch (Throwable th) {
            q.d(a, th.getMessage());
        }
    }

    public final void a(String str) {
        try {
            this.n = str;
            if (!TextUtils.isEmpty(str) && this.d != null) {
                w.a(this.d, "applicationIds", str);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private a() {
    }

    public static synchronized a e() {
        a aVar;
        synchronized (a.class) {
            if (c == null) {
                c = new a();
            }
            aVar = c;
        }
        return aVar;
    }

    public final int f() {
        return this.k;
    }

    public final void b(int i2) {
        this.k = i2;
    }

    public final void a(b bVar, final Handler handler) {
        if (!this.j) {
            try {
                this.h = new JSONObject();
                this.h.put("webgl", 0);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            try {
                Object b2 = w.b(this.d, "ga_id", "-1");
                if (b2 != null && (b2 instanceof String)) {
                    String str = (String) b2;
                    if (x.b(str) && !"-1".equals(str) && com.mbridge.msdk.foundation.controller.authoritycontroller.a.a().a(MBridgeConstans.AUTHORITY_DEVICE_ID)) {
                        m.a(str);
                    }
                }
            } catch (Exception e3) {
                e3.printStackTrace();
            }
            new Thread(new Runnable() {
                /* JADX WARNING: Failed to process nested try/catch */
                /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0031 */
                /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0052 */
                /* JADX WARNING: Removed duplicated region for block: B:12:0x0064 A[Catch:{ Exception -> 0x007c }] */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public final void run() {
                    /*
                        r2 = this;
                        com.mbridge.msdk.foundation.controller.authoritycontroller.a r0 = com.mbridge.msdk.foundation.controller.authoritycontroller.a.a()
                        java.lang.String r1 = "authority_device_id"
                        boolean r0 = r0.a((java.lang.String) r1)
                        if (r0 == 0) goto L_0x0052
                        java.lang.String r0 = "com.google.android.gms.ads.identifier.AdvertisingIdClient"
                        java.lang.Class.forName(r0)     // Catch:{ Exception -> 0x0031, all -> 0x002c }
                        com.mbridge.msdk.foundation.controller.a r0 = com.mbridge.msdk.foundation.controller.a.this     // Catch:{ Exception -> 0x0031, all -> 0x002c }
                        android.content.Context r0 = r0.d     // Catch:{ Exception -> 0x0031, all -> 0x002c }
                        com.google.android.gms.ads.identifier.AdvertisingIdClient$Info r0 = com.google.android.gms.ads.identifier.AdvertisingIdClient.getAdvertisingIdInfo(r0)     // Catch:{ Exception -> 0x0031, all -> 0x002c }
                        java.lang.String r1 = r0.getId()     // Catch:{ Exception -> 0x0031, all -> 0x002c }
                        com.mbridge.msdk.foundation.tools.m.a((java.lang.String) r1)     // Catch:{ Exception -> 0x0031, all -> 0x002c }
                        com.mbridge.msdk.foundation.controller.a r1 = com.mbridge.msdk.foundation.controller.a.this     // Catch:{ Exception -> 0x0031, all -> 0x002c }
                        java.lang.String r0 = r0.getId()     // Catch:{ Exception -> 0x0031, all -> 0x002c }
                        com.mbridge.msdk.foundation.controller.a.a((com.mbridge.msdk.foundation.controller.a) r1, (java.lang.String) r0)     // Catch:{ Exception -> 0x0031, all -> 0x002c }
                        goto L_0x0052
                    L_0x002c:
                        r0 = move-exception
                        r0.printStackTrace()
                        goto L_0x0052
                    L_0x0031:
                        com.mbridge.msdk.foundation.controller.a$a r0 = new com.mbridge.msdk.foundation.controller.a$a     // Catch:{ Exception -> 0x0052 }
                        com.mbridge.msdk.foundation.controller.a r1 = com.mbridge.msdk.foundation.controller.a.this     // Catch:{ Exception -> 0x0052 }
                        r0.<init>()     // Catch:{ Exception -> 0x0052 }
                        com.mbridge.msdk.foundation.controller.a r1 = com.mbridge.msdk.foundation.controller.a.this     // Catch:{ Exception -> 0x0052 }
                        android.content.Context r1 = r1.d     // Catch:{ Exception -> 0x0052 }
                        com.mbridge.msdk.foundation.controller.a$a$a r0 = r0.a(r1)     // Catch:{ Exception -> 0x0052 }
                        java.lang.String r1 = r0.a()     // Catch:{ Exception -> 0x0052 }
                        com.mbridge.msdk.foundation.tools.m.a((java.lang.String) r1)     // Catch:{ Exception -> 0x0052 }
                        com.mbridge.msdk.foundation.controller.a r1 = com.mbridge.msdk.foundation.controller.a.this     // Catch:{ Exception -> 0x0052 }
                        java.lang.String r0 = r0.a()     // Catch:{ Exception -> 0x0052 }
                        com.mbridge.msdk.foundation.controller.a.a((com.mbridge.msdk.foundation.controller.a) r1, (java.lang.String) r0)     // Catch:{ Exception -> 0x0052 }
                    L_0x0052:
                        com.mbridge.msdk.b.b r0 = com.mbridge.msdk.b.b.a()     // Catch:{ Exception -> 0x007c }
                        com.mbridge.msdk.foundation.controller.a r1 = com.mbridge.msdk.foundation.controller.a.e()     // Catch:{ Exception -> 0x007c }
                        java.lang.String r1 = r1.h()     // Catch:{ Exception -> 0x007c }
                        com.mbridge.msdk.b.a r0 = r0.b(r1)     // Catch:{ Exception -> 0x007c }
                        if (r0 != 0) goto L_0x006c
                        com.mbridge.msdk.b.b r0 = com.mbridge.msdk.b.b.a()     // Catch:{ Exception -> 0x007c }
                        com.mbridge.msdk.b.a r0 = r0.b()     // Catch:{ Exception -> 0x007c }
                    L_0x006c:
                        android.os.Message r1 = android.os.Message.obtain()     // Catch:{ Exception -> 0x007c }
                        r1.obj = r0     // Catch:{ Exception -> 0x007c }
                        r0 = 9
                        r1.what = r0     // Catch:{ Exception -> 0x007c }
                        android.os.Handler r0 = r4     // Catch:{ Exception -> 0x007c }
                        r0.sendMessage(r1)     // Catch:{ Exception -> 0x007c }
                        goto L_0x0080
                    L_0x007c:
                        r0 = move-exception
                        r0.printStackTrace()
                    L_0x0080:
                        com.mbridge.msdk.foundation.controller.a r0 = com.mbridge.msdk.foundation.controller.a.this     // Catch:{ Exception -> 0x0099 }
                        android.content.Context r0 = r0.d     // Catch:{ Exception -> 0x0099 }
                        com.mbridge.msdk.foundation.tools.m.b((android.content.Context) r0)     // Catch:{ Exception -> 0x0099 }
                        com.mbridge.msdk.foundation.controller.a r0 = com.mbridge.msdk.foundation.controller.a.this     // Catch:{ Exception -> 0x0099 }
                        android.content.Context r0 = r0.d     // Catch:{ Exception -> 0x0099 }
                        com.mbridge.msdk.foundation.controller.a r1 = com.mbridge.msdk.foundation.controller.a.this     // Catch:{ Exception -> 0x0099 }
                        java.lang.String r1 = r1.e     // Catch:{ Exception -> 0x0099 }
                        com.mbridge.msdk.b.b.a((android.content.Context) r0, (java.lang.String) r1)     // Catch:{ Exception -> 0x0099 }
                        goto L_0x009d
                    L_0x0099:
                        r0 = move-exception
                        r0.printStackTrace()
                    L_0x009d:
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.controller.a.AnonymousClass1.run():void");
                }
            }).start();
        }
    }

    public final Context g() {
        return this.d;
    }

    public final void b(Context context) {
        this.d = context;
    }

    public final String h() {
        try {
            if (!TextUtils.isEmpty(this.e)) {
                return this.e;
            }
            if (this.d != null) {
                return (String) w.b(this.d, "sp_appId", "");
            }
            return "";
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final void b(String str) {
        try {
            this.e = str;
            if (!TextUtils.isEmpty(str) && this.d != null) {
                w.a(this.d, "sp_appId", str);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final String i() {
        if (!TextUtils.isEmpty(this.f)) {
            return this.f;
        }
        Context context = this.d;
        if (context != null) {
            return (String) w.b(context, "sp_appKey", "");
        }
        return null;
    }

    public final void c(String str) {
        try {
            this.f = str;
            if (!TextUtils.isEmpty(str) && this.d != null) {
                w.a(this.d, "sp_appKey", str);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* renamed from: com.mbridge.msdk.foundation.controller.a$a  reason: collision with other inner class name */
    /* compiled from: MBSDKContext */
    public class C0059a {
        public C0059a() {
        }

        /* renamed from: com.mbridge.msdk.foundation.controller.a$a$a  reason: collision with other inner class name */
        /* compiled from: MBSDKContext */
        public final class C0060a {
            private final String b;
            private final boolean c;

            C0060a(String str, boolean z) {
                this.b = str;
                this.c = z;
            }

            public final String a() {
                return this.b;
            }
        }

        public final C0060a a(Context context) throws Exception {
            if (Looper.myLooper() != Looper.getMainLooper()) {
                try {
                    context.getPackageManager().getPackageInfo("com.android.vending", 0);
                    b bVar = new b();
                    Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
                    intent.setPackage("com.google.android.gms");
                    if (context.bindService(intent, bVar, 1)) {
                        try {
                            c cVar = new c(bVar.a());
                            C0060a aVar = new C0060a(cVar.a(), cVar.a(true));
                            context.unbindService(bVar);
                            return aVar;
                        } catch (Exception e) {
                            throw e;
                        } catch (Throwable th) {
                            context.unbindService(bVar);
                            throw th;
                        }
                    } else {
                        throw new IOException("Google Play connection failed");
                    }
                } catch (Exception e2) {
                    throw e2;
                }
            } else {
                throw new IllegalStateException("Cannot be called from the main thread");
            }
        }

        /* renamed from: com.mbridge.msdk.foundation.controller.a$a$b */
        /* compiled from: MBSDKContext */
        private final class b implements ServiceConnection {
            boolean a;
            private final LinkedBlockingQueue<IBinder> c;

            public final void onServiceDisconnected(ComponentName componentName) {
            }

            private b() {
                this.a = false;
                this.c = new LinkedBlockingQueue<>(1);
            }

            public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                try {
                    this.c.put(iBinder);
                } catch (InterruptedException unused) {
                }
            }

            public final IBinder a() throws InterruptedException {
                if (!this.a) {
                    this.a = true;
                    return this.c.take();
                }
                throw new IllegalStateException();
            }
        }

        /* renamed from: com.mbridge.msdk.foundation.controller.a$a$c */
        /* compiled from: MBSDKContext */
        private final class c implements IInterface {
            private IBinder b;

            public c(IBinder iBinder) {
                this.b = iBinder;
            }

            public final IBinder asBinder() {
                return this.b;
            }

            /* JADX INFO: finally extract failed */
            public final String a() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                    this.b.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    String readString = obtain2.readString();
                    obtain2.recycle();
                    obtain.recycle();
                    return readString;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                    throw th;
                }
            }

            public final boolean a(boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                boolean z2 = false;
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                    obtain.writeInt(z ? 1 : 0);
                    this.b.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z2 = true;
                    }
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                    throw th;
                }
                obtain2.recycle();
                obtain.recycle();
                return z2;
            }
        }
    }

    public final int j() {
        return this.g;
    }

    public final void c(int i2) {
        this.g = i2;
    }

    public final JSONObject k() {
        return this.h;
    }

    public final void a(JSONObject jSONObject) {
        this.h = jSONObject;
    }

    static /* synthetic */ void a(a aVar, String str) {
        try {
            if (x.b(str)) {
                w.a(aVar.d, "ga_id", str);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
