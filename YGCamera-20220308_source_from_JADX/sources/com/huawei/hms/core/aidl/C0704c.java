package com.huawei.hms.core.aidl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* renamed from: com.huawei.hms.core.aidl.c */
/* compiled from: IAIDLCallback */
public interface C0704c extends IInterface {

    /* renamed from: com.huawei.hms.core.aidl.c$a */
    /* compiled from: IAIDLCallback */
    public static abstract class C0705a extends Binder implements C0704c {

        /* renamed from: com.huawei.hms.core.aidl.c$a$a */
        /* compiled from: IAIDLCallback */
        private static class C0706a implements C0704c {

            /* renamed from: b */
            public static C0704c f440b;

            /* renamed from: a */
            private IBinder f441a;

            C0706a(IBinder iBinder) {
                this.f441a = iBinder;
            }

            public IBinder asBinder() {
                return this.f441a;
            }
        }

        public C0705a() {
            attachInterface(this, "com.huawei.hms.core.aidl.IAIDLCallback");
        }

        public static C0704c asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.huawei.hms.core.aidl.IAIDLCallback");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof C0704c)) {
                return new C0706a(iBinder);
            }
            return (C0704c) queryLocalInterface;
        }

        public static C0704c getDefaultImpl() {
            return C0706a.f440b;
        }

        public static boolean setDefaultImpl(C0704c cVar) {
            if (C0706a.f440b != null || cVar == null) {
                return false;
            }
            C0706a.f440b = cVar;
            return true;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface("com.huawei.hms.core.aidl.IAIDLCallback");
                call(parcel.readInt() != 0 ? C0702b.CREATOR.createFromParcel(parcel) : null);
                return true;
            } else if (i != 1598968902) {
                return super.onTransact(i, parcel, parcel2, i2);
            } else {
                parcel2.writeString("com.huawei.hms.core.aidl.IAIDLCallback");
                return true;
            }
        }
    }

    void call(C0702b bVar) throws RemoteException;
}
