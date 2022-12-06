package com.bytedance.sdk.component.e.a;

import android.content.ContentValues;
import android.net.Uri;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.HashMap;
import java.util.Map;

/* compiled from: IListenerEventManager */
public interface g extends IInterface {
    int a(Uri uri, ContentValues contentValues, String str, String[] strArr) throws RemoteException;

    int a(Uri uri, String str, String[] strArr) throws RemoteException;

    String a(Uri uri) throws RemoteException;

    String a(Uri uri, ContentValues contentValues) throws RemoteException;

    Map a(Uri uri, String[] strArr, String str, String[] strArr2, String str2) throws RemoteException;

    /* compiled from: IListenerEventManager */
    public static abstract class a extends Binder implements g {
        public IBinder asBinder() {
            return this;
        }

        public a() {
            attachInterface(this, "com.bytedance.sdk.component.log.impl.IListenerEventManager");
        }

        public static g a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.bytedance.sdk.component.log.impl.IListenerEventManager");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof g)) {
                return new C0034a(iBinder);
            }
            return (g) queryLocalInterface;
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v4, resolved type: android.net.Uri} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v7, resolved type: android.content.ContentValues} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v10, resolved type: android.net.Uri} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v13, resolved type: android.content.ContentValues} */
        /* JADX WARNING: type inference failed for: r0v0 */
        /* JADX WARNING: type inference failed for: r0v1 */
        /* JADX WARNING: type inference failed for: r0v16 */
        /* JADX WARNING: type inference failed for: r0v17 */
        /* JADX WARNING: type inference failed for: r0v18 */
        /* JADX WARNING: type inference failed for: r0v19 */
        /* JADX WARNING: type inference failed for: r0v20 */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean onTransact(int r9, android.os.Parcel r10, android.os.Parcel r11, int r12) throws android.os.RemoteException {
            /*
                r8 = this;
                r0 = 0
                r1 = 1
                java.lang.String r2 = "com.bytedance.sdk.component.log.impl.IListenerEventManager"
                if (r9 == r1) goto L_0x00c4
                r3 = 2
                if (r9 == r3) goto L_0x00a7
                r3 = 3
                if (r9 == r3) goto L_0x007a
                r3 = 4
                if (r9 == r3) goto L_0x0055
                r3 = 5
                if (r9 == r3) goto L_0x0020
                r0 = 1598968902(0x5f4e5446, float:1.4867585E19)
                if (r9 == r0) goto L_0x001c
                boolean r9 = super.onTransact(r9, r10, r11, r12)
                return r9
            L_0x001c:
                r11.writeString(r2)
                return r1
            L_0x0020:
                r10.enforceInterface(r2)
                int r9 = r10.readInt()
                if (r9 == 0) goto L_0x0032
                android.os.Parcelable$Creator r9 = android.net.Uri.CREATOR
                java.lang.Object r9 = r9.createFromParcel(r10)
                android.net.Uri r9 = (android.net.Uri) r9
                goto L_0x0033
            L_0x0032:
                r9 = r0
            L_0x0033:
                int r12 = r10.readInt()
                if (r12 == 0) goto L_0x0042
                android.os.Parcelable$Creator r12 = android.content.ContentValues.CREATOR
                java.lang.Object r12 = r12.createFromParcel(r10)
                r0 = r12
                android.content.ContentValues r0 = (android.content.ContentValues) r0
            L_0x0042:
                java.lang.String r12 = r10.readString()
                java.lang.String[] r10 = r10.createStringArray()
                int r9 = r8.a(r9, r0, r12, r10)
                r11.writeNoException()
                r11.writeInt(r9)
                return r1
            L_0x0055:
                r10.enforceInterface(r2)
                int r9 = r10.readInt()
                if (r9 == 0) goto L_0x0067
                android.os.Parcelable$Creator r9 = android.net.Uri.CREATOR
                java.lang.Object r9 = r9.createFromParcel(r10)
                r0 = r9
                android.net.Uri r0 = (android.net.Uri) r0
            L_0x0067:
                java.lang.String r9 = r10.readString()
                java.lang.String[] r10 = r10.createStringArray()
                int r9 = r8.a(r0, r9, r10)
                r11.writeNoException()
                r11.writeInt(r9)
                return r1
            L_0x007a:
                r10.enforceInterface(r2)
                int r9 = r10.readInt()
                if (r9 == 0) goto L_0x008c
                android.os.Parcelable$Creator r9 = android.net.Uri.CREATOR
                java.lang.Object r9 = r9.createFromParcel(r10)
                android.net.Uri r9 = (android.net.Uri) r9
                goto L_0x008d
            L_0x008c:
                r9 = r0
            L_0x008d:
                int r12 = r10.readInt()
                if (r12 == 0) goto L_0x009c
                android.os.Parcelable$Creator r12 = android.content.ContentValues.CREATOR
                java.lang.Object r10 = r12.createFromParcel(r10)
                r0 = r10
                android.content.ContentValues r0 = (android.content.ContentValues) r0
            L_0x009c:
                java.lang.String r9 = r8.a(r9, r0)
                r11.writeNoException()
                r11.writeString(r9)
                return r1
            L_0x00a7:
                r10.enforceInterface(r2)
                int r9 = r10.readInt()
                if (r9 == 0) goto L_0x00b9
                android.os.Parcelable$Creator r9 = android.net.Uri.CREATOR
                java.lang.Object r9 = r9.createFromParcel(r10)
                r0 = r9
                android.net.Uri r0 = (android.net.Uri) r0
            L_0x00b9:
                java.lang.String r9 = r8.a(r0)
                r11.writeNoException()
                r11.writeString(r9)
                return r1
            L_0x00c4:
                r10.enforceInterface(r2)
                int r9 = r10.readInt()
                if (r9 == 0) goto L_0x00d6
                android.os.Parcelable$Creator r9 = android.net.Uri.CREATOR
                java.lang.Object r9 = r9.createFromParcel(r10)
                r0 = r9
                android.net.Uri r0 = (android.net.Uri) r0
            L_0x00d6:
                r3 = r0
                java.lang.String[] r4 = r10.createStringArray()
                java.lang.String r5 = r10.readString()
                java.lang.String[] r6 = r10.createStringArray()
                java.lang.String r7 = r10.readString()
                r2 = r8
                java.util.Map r9 = r2.a(r3, r4, r5, r6, r7)
                r11.writeNoException()
                r11.writeMap(r9)
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.e.a.g.a.onTransact(int, android.os.Parcel, android.os.Parcel, int):boolean");
        }

        /* renamed from: com.bytedance.sdk.component.e.a.g$a$a  reason: collision with other inner class name */
        /* compiled from: IListenerEventManager */
        private static class C0034a implements g {
            public static g a;
            private IBinder b;

            C0034a(IBinder iBinder) {
                this.b = iBinder;
            }

            public IBinder asBinder() {
                return this.b;
            }

            public Map a(Uri uri, String[] strArr, String str, String[] strArr2, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bytedance.sdk.component.log.impl.IListenerEventManager");
                    if (uri != null) {
                        obtain.writeInt(1);
                        uri.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStringArray(strArr);
                    obtain.writeString(str);
                    obtain.writeStringArray(strArr2);
                    obtain.writeString(str2);
                    if (!this.b.transact(1, obtain, obtain2, 0) && a.a() != null) {
                        return a.a().a(uri, strArr, str, strArr2, str2);
                    }
                    obtain2.readException();
                    HashMap readHashMap = obtain2.readHashMap(getClass().getClassLoader());
                    obtain2.recycle();
                    obtain.recycle();
                    return readHashMap;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String a(Uri uri) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bytedance.sdk.component.log.impl.IListenerEventManager");
                    if (uri != null) {
                        obtain.writeInt(1);
                        uri.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!this.b.transact(2, obtain, obtain2, 0) && a.a() != null) {
                        return a.a().a(uri);
                    }
                    obtain2.readException();
                    String readString = obtain2.readString();
                    obtain2.recycle();
                    obtain.recycle();
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String a(Uri uri, ContentValues contentValues) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bytedance.sdk.component.log.impl.IListenerEventManager");
                    if (uri != null) {
                        obtain.writeInt(1);
                        uri.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (contentValues != null) {
                        obtain.writeInt(1);
                        contentValues.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!this.b.transact(3, obtain, obtain2, 0) && a.a() != null) {
                        return a.a().a(uri, contentValues);
                    }
                    obtain2.readException();
                    String readString = obtain2.readString();
                    obtain2.recycle();
                    obtain.recycle();
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int a(Uri uri, String str, String[] strArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bytedance.sdk.component.log.impl.IListenerEventManager");
                    if (uri != null) {
                        obtain.writeInt(1);
                        uri.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeString(str);
                    obtain.writeStringArray(strArr);
                    if (!this.b.transact(4, obtain, obtain2, 0) && a.a() != null) {
                        return a.a().a(uri, str, strArr);
                    }
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    obtain2.recycle();
                    obtain.recycle();
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int a(Uri uri, ContentValues contentValues, String str, String[] strArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bytedance.sdk.component.log.impl.IListenerEventManager");
                    if (uri != null) {
                        obtain.writeInt(1);
                        uri.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (contentValues != null) {
                        obtain.writeInt(1);
                        contentValues.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeString(str);
                    obtain.writeStringArray(strArr);
                    if (!this.b.transact(5, obtain, obtain2, 0) && a.a() != null) {
                        return a.a().a(uri, contentValues, str, strArr);
                    }
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    obtain2.recycle();
                    obtain.recycle();
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static g a() {
            return C0034a.a;
        }
    }
}
