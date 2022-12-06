package sg.bigo.ads.common.g;

import android.content.Context;
import android.content.Intent;
import android.os.RemoteException;
import java.util.concurrent.TimeUnit;
import sg.bigo.ads.common.a;

final class d {
    private final Context a;
    private final long b;

    private d(Context context, long j) {
        this.a = context;
        this.b = j;
    }

    private synchronized a a() {
        f a2;
        e a3 = a(this.a);
        if (a3 != null) {
            a2 = a3.a(this.b, TimeUnit.MILLISECONDS);
            if (a2 != null) {
            } else {
                a3.a();
                throw new b();
            }
        } else {
            throw new b();
        }
        return new a(a2.a(), a2.b());
    }

    public static a a(Context context, long j) {
        try {
            return new d(context, j).a();
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static e a(Context context) {
        e a2 = e.a(context);
        if (!a2.a.isEmpty()) {
            return a2;
        }
        Intent intent = new Intent("com.uodis.opendevice.OPENIDS_SERVICE");
        intent.setPackage("com.huawei.hwid");
        try {
            a2.b = true;
            boolean bindService = context.bindService(intent, a2, 1);
            if (bindService) {
                if (!bindService) {
                    a2.a();
                }
                return a2;
            }
            if (bindService) {
                return null;
            }
            a2.a();
            return null;
        } catch (Exception e) {
            e.printStackTrace();
        } catch (Throwable th) {
            a2.a();
            throw th;
        }
    }
}
