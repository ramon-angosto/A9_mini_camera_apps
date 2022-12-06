package com.google.android.gms.common.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-basement@@18.0.0 */
public interface IGmsServiceBroker extends IInterface {

    /* compiled from: com.google.android.gms:play-services-basement@@18.0.0 */
    public static abstract class Stub extends Binder implements IGmsServiceBroker {
        public Stub() {
            attachInterface(this, "com.google.android.gms.common.internal.IGmsServiceBroker");
        }

        public IBinder asBinder() {
            return this;
        }

        /* JADX WARNING: type inference failed for: r1v2, types: [android.os.IInterface] */
        /* JADX WARNING: Multi-variable type inference failed */
        /* JADX WARNING: Unknown variable types count: 1 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean onTransact(int r4, android.os.Parcel r5, android.os.Parcel r6, int r7) throws android.os.RemoteException {
            /*
                r3 = this;
                r0 = 16777215(0xffffff, float:2.3509886E-38)
                if (r4 <= r0) goto L_0x000a
                boolean r4 = super.onTransact(r4, r5, r6, r7)
                return r4
            L_0x000a:
                java.lang.String r7 = "com.google.android.gms.common.internal.IGmsServiceBroker"
                r5.enforceInterface(r7)
                android.os.IBinder r7 = r5.readStrongBinder()
                r0 = 0
                if (r7 != 0) goto L_0x0018
                r7 = r0
                goto L_0x002c
            L_0x0018:
                java.lang.String r1 = "com.google.android.gms.common.internal.IGmsCallbacks"
                android.os.IInterface r1 = r7.queryLocalInterface(r1)
                boolean r2 = r1 instanceof com.google.android.gms.common.internal.IGmsCallbacks
                if (r2 == 0) goto L_0x0026
                r7 = r1
                com.google.android.gms.common.internal.IGmsCallbacks r7 = (com.google.android.gms.common.internal.IGmsCallbacks) r7
                goto L_0x002c
            L_0x0026:
                com.google.android.gms.common.internal.zzaa r1 = new com.google.android.gms.common.internal.zzaa
                r1.<init>(r7)
                r7 = r1
            L_0x002c:
                r1 = 46
                r2 = 1
                if (r4 != r1) goto L_0x004a
                int r4 = r5.readInt()
                if (r4 == 0) goto L_0x0040
                android.os.Parcelable$Creator<com.google.android.gms.common.internal.GetServiceRequest> r4 = com.google.android.gms.common.internal.GetServiceRequest.CREATOR
                java.lang.Object r4 = r4.createFromParcel(r5)
                r0 = r4
                com.google.android.gms.common.internal.GetServiceRequest r0 = (com.google.android.gms.common.internal.GetServiceRequest) r0
            L_0x0040:
                r3.getService(r7, r0)
                com.google.android.gms.common.internal.Preconditions.checkNotNull(r6)
                r6.writeNoException()
                return r2
            L_0x004a:
                r6 = 47
                if (r4 != r6) goto L_0x0062
                int r4 = r5.readInt()
                if (r4 == 0) goto L_0x005c
                android.os.Parcelable$Creator<com.google.android.gms.common.internal.zzaj> r4 = com.google.android.gms.common.internal.zzaj.CREATOR
                java.lang.Object r4 = r4.createFromParcel(r5)
                com.google.android.gms.common.internal.zzaj r4 = (com.google.android.gms.common.internal.zzaj) r4
            L_0x005c:
                java.lang.UnsupportedOperationException r4 = new java.lang.UnsupportedOperationException
                r4.<init>()
                throw r4
            L_0x0062:
                r5.readInt()
                r6 = 4
                if (r4 == r6) goto L_0x010f
                r5.readString()
                if (r4 == r2) goto L_0x00f8
                r6 = 2
                if (r4 == r6) goto L_0x00e9
                r6 = 23
                if (r4 == r6) goto L_0x00e9
                r6 = 25
                if (r4 == r6) goto L_0x00e9
                r6 = 27
                if (r4 == r6) goto L_0x00e9
                r6 = 30
                if (r4 == r6) goto L_0x00d4
                r6 = 34
                if (r4 == r6) goto L_0x00d0
                r6 = 41
                if (r4 == r6) goto L_0x00e9
                r6 = 43
                if (r4 == r6) goto L_0x00e9
                r6 = 37
                if (r4 == r6) goto L_0x00e9
                r6 = 38
                if (r4 == r6) goto L_0x00e9
                switch(r4) {
                    case 5: goto L_0x00e9;
                    case 6: goto L_0x00e9;
                    case 7: goto L_0x00e9;
                    case 8: goto L_0x00e9;
                    case 9: goto L_0x00b2;
                    case 10: goto L_0x00ab;
                    case 11: goto L_0x00e9;
                    case 12: goto L_0x00e9;
                    case 13: goto L_0x00e9;
                    case 14: goto L_0x00e9;
                    case 15: goto L_0x00e9;
                    case 16: goto L_0x00e9;
                    case 17: goto L_0x00e9;
                    case 18: goto L_0x00e9;
                    case 19: goto L_0x0099;
                    case 20: goto L_0x00d4;
                    default: goto L_0x0097;
                }
            L_0x0097:
                goto L_0x010f
            L_0x0099:
                r5.readStrongBinder()
                int r4 = r5.readInt()
                if (r4 == 0) goto L_0x010f
                android.os.Parcelable$Creator r4 = android.os.Bundle.CREATOR
                java.lang.Object r4 = r4.createFromParcel(r5)
                android.os.Bundle r4 = (android.os.Bundle) r4
                goto L_0x010f
            L_0x00ab:
                r5.readString()
                r5.createStringArray()
                goto L_0x010f
            L_0x00b2:
                r5.readString()
                r5.createStringArray()
                r5.readString()
                r5.readStrongBinder()
                r5.readString()
                int r4 = r5.readInt()
                if (r4 == 0) goto L_0x010f
                android.os.Parcelable$Creator r4 = android.os.Bundle.CREATOR
                java.lang.Object r4 = r4.createFromParcel(r5)
                android.os.Bundle r4 = (android.os.Bundle) r4
                goto L_0x010f
            L_0x00d0:
                r5.readString()
                goto L_0x010f
            L_0x00d4:
                r5.createStringArray()
                r5.readString()
                int r4 = r5.readInt()
                if (r4 == 0) goto L_0x010f
                android.os.Parcelable$Creator r4 = android.os.Bundle.CREATOR
                java.lang.Object r4 = r4.createFromParcel(r5)
                android.os.Bundle r4 = (android.os.Bundle) r4
                goto L_0x010f
            L_0x00e9:
                int r4 = r5.readInt()
                if (r4 == 0) goto L_0x010f
                android.os.Parcelable$Creator r4 = android.os.Bundle.CREATOR
                java.lang.Object r4 = r4.createFromParcel(r5)
                android.os.Bundle r4 = (android.os.Bundle) r4
                goto L_0x010f
            L_0x00f8:
                r5.readString()
                r5.createStringArray()
                r5.readString()
                int r4 = r5.readInt()
                if (r4 == 0) goto L_0x010f
                android.os.Parcelable$Creator r4 = android.os.Bundle.CREATOR
                java.lang.Object r4 = r4.createFromParcel(r5)
                android.os.Bundle r4 = (android.os.Bundle) r4
            L_0x010f:
                java.lang.UnsupportedOperationException r4 = new java.lang.UnsupportedOperationException
                r4.<init>()
                throw r4
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.internal.IGmsServiceBroker.Stub.onTransact(int, android.os.Parcel, android.os.Parcel, int):boolean");
        }
    }

    void getService(IGmsCallbacks iGmsCallbacks, GetServiceRequest getServiceRequest) throws RemoteException;
}
