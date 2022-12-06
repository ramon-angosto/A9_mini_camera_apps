package sg.bigo.ads.common.e;

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

final class c {

    static final class a implements ServiceConnection {
        long a;
        boolean b = false;
        final LinkedBlockingQueue<IBinder> c = new LinkedBlockingQueue<>(1);

        public a(long j) {
            this.a = j;
        }

        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                this.c.put(iBinder);
            } catch (InterruptedException unused) {
            }
        }

        public final void onServiceDisconnected(ComponentName componentName) {
        }
    }

    static final class b implements IInterface {
        private IBinder a;

        public b(IBinder iBinder) {
            this.a = iBinder;
        }

        public final String a() {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                this.a.transact(1, obtain, obtain2, 0);
                obtain2.readException();
                return obtain2.readString();
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        public final IBinder asBinder() {
            return this.a;
        }

        public final Boolean b() {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                boolean z = true;
                obtain.writeInt(1);
                this.a.transact(2, obtain, obtain2, 0);
                obtain2.readException();
                if (obtain2.readInt() == 0) {
                    z = false;
                }
                return Boolean.valueOf(z);
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }
    }

    public static sg.bigo.ads.common.a a(Context context, long j) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            try {
                context.getPackageManager().getPackageInfo("com.android.vending", 0);
                a aVar = new a(j);
                Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
                intent.setPackage("com.google.android.gms");
                if (context.bindService(intent, aVar, 1)) {
                    try {
                        if (!aVar.b) {
                            aVar.b = true;
                            b bVar = new b(aVar.c.poll(aVar.a, TimeUnit.MILLISECONDS));
                            String a2 = bVar.a();
                            Boolean b2 = bVar.b();
                            if (a2 == null || b2 == null) {
                                context.unbindService(aVar);
                                return null;
                            }
                            sg.bigo.ads.common.a aVar2 = new sg.bigo.ads.common.a(a2, b2.booleanValue());
                            context.unbindService(aVar);
                            return aVar2;
                        }
                        throw new IllegalStateException();
                    } catch (Exception e) {
                        throw e;
                    } catch (Throwable th) {
                        context.unbindService(aVar);
                        throw th;
                    }
                } else {
                    throw new IOException("Google Play connection failed");
                }
            } catch (Exception e2) {
                throw e2;
            }
        } else {
            throw new IllegalStateException("Google Play Services info can't be accessed from the main thread");
        }
    }
}
