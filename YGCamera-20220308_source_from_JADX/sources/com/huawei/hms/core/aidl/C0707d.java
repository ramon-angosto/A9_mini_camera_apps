package com.huawei.hms.core.aidl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* renamed from: com.huawei.hms.core.aidl.d */
/* compiled from: IAIDLInvoke */
public interface C0707d extends IInterface {
    /* renamed from: a */
    void mo13634a(C0702b bVar, C0704c cVar) throws RemoteException;

    /* renamed from: com.huawei.hms.core.aidl.d$a */
    /* compiled from: IAIDLInvoke */
    public static abstract class C0708a extends Binder implements C0707d {

        /* renamed from: com.huawei.hms.core.aidl.d$a$a */
        /* compiled from: IAIDLInvoke */
        private static class C0709a implements C0707d {

            /* renamed from: b */
            public static C0707d f442b;

            /* renamed from: a */
            private IBinder f443a;

            C0709a(IBinder iBinder) {
                this.f443a = iBinder;
            }

            /* renamed from: a */
            public void mo13634a(C0702b bVar, C0704c cVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.huawei.hms.core.aidl.IAIDLInvoke");
                    if (bVar != null) {
                        obtain.writeInt(1);
                        bVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(cVar != null ? cVar.asBinder() : null);
                    if (this.f443a.transact(2, obtain, (Parcel) null, 1) || C0708a.m431a() == null) {
                        obtain.recycle();
                    } else {
                        C0708a.m431a().mo13634a(bVar, cVar);
                    }
                } finally {
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.f443a;
            }
        }

        /* renamed from: a */
        public static C0707d m432a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.huawei.hms.core.aidl.IAIDLInvoke");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof C0707d)) {
                return new C0709a(iBinder);
            }
            return (C0707d) queryLocalInterface;
        }

        /* renamed from: a */
        public static C0707d m431a() {
            return C0709a.f442b;
        }
    }
}
