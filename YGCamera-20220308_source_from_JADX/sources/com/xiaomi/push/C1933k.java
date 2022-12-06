package com.xiaomi.push;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import java.io.IOException;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/* renamed from: com.xiaomi.push.k */
final class C1933k {

    /* renamed from: com.xiaomi.push.k$a */
    static final class C1934a {

        /* renamed from: a */
        private final String f3553a;

        /* renamed from: a */
        private final boolean f3554a;

        C1934a(String str, boolean z) {
            this.f3553a = str;
            this.f3554a = z;
        }

        /* renamed from: a */
        public String mo18365a() {
            return this.f3553a;
        }
    }

    /* renamed from: com.xiaomi.push.k$b */
    private static final class C1935b implements ServiceConnection {

        /* renamed from: a */
        private final LinkedBlockingQueue<IBinder> f3555a;

        /* renamed from: a */
        boolean f3556a;

        private C1935b() {
            this.f3556a = false;
            this.f3555a = new LinkedBlockingQueue<>(1);
        }

        /* renamed from: a */
        public IBinder mo18366a() {
            if (!this.f3556a) {
                this.f3556a = true;
                return this.f3555a.poll(30000, TimeUnit.MILLISECONDS);
            }
            throw new IllegalStateException();
        }

        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                this.f3555a.put(iBinder);
            } catch (InterruptedException unused) {
            }
        }

        public void onServiceDisconnected(ComponentName componentName) {
        }
    }

    /* renamed from: com.xiaomi.push.k$c */
    private static final class C1936c implements IInterface {

        /* renamed from: a */
        private IBinder f3557a;

        public C1936c(IBinder iBinder) {
            this.f3557a = iBinder;
        }

        /* renamed from: a */
        public String mo18369a() {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                this.f3557a.transact(1, obtain, obtain2, 0);
                obtain2.readException();
                return obtain2.readString();
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        public IBinder asBinder() {
            return this.f3557a;
        }
    }

    /* renamed from: a */
    public static C1934a m4709a(Context context) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            try {
                context.getPackageManager().getPackageInfo("com.android.vending", 0);
                C1935b bVar = new C1935b();
                Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
                intent.setPackage("com.google.android.gms");
                if (context.bindService(intent, bVar, 1)) {
                    try {
                        IBinder a = bVar.mo18366a();
                        if (a != null) {
                            C1934a aVar = new C1934a(new C1936c(a).mo18369a(), false);
                            context.unbindService(bVar);
                            return aVar;
                        }
                        context.unbindService(bVar);
                    } catch (Exception e) {
                        throw e;
                    } catch (Throwable th) {
                        context.unbindService(bVar);
                        throw th;
                    }
                }
                throw new IOException("Google Play connection failed");
            } catch (Exception e2) {
                throw e2;
            }
        } else {
            throw new IllegalStateException("Cannot be called from the main thread");
        }
    }
}
