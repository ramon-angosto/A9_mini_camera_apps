package android.support.v4.media;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.ResultReceiver;

class IMediaBrowserServiceAdapterApi21 {
    IMediaBrowserServiceAdapterApi21() {
    }

    static abstract class Stub extends Binder implements IInterface {
        private static final String DESCRIPTOR = "android.service.media.IMediaBrowserService";
        private static final int TRANSACTION_addSubscription = 3;
        private static final int TRANSACTION_connect = 1;
        private static final int TRANSACTION_disconnect = 2;
        private static final int TRANSACTION_getMediaItem = 5;
        private static final int TRANSACTION_removeSubscription = 4;

        public abstract void addSubscription(String str, Object obj);

        public IBinder asBinder() {
            return this;
        }

        public abstract void connect(String str, Bundle bundle, Object obj);

        public abstract void disconnect(Object obj);

        public abstract void getMediaItem(String str, ResultReceiver resultReceiver);

        public abstract void removeSubscription(String str, Object obj);

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v1, resolved type: android.os.Bundle} */
        /* JADX WARNING: type inference failed for: r0v0 */
        /* JADX WARNING: type inference failed for: r0v4, types: [android.os.ResultReceiver] */
        /* JADX WARNING: type inference failed for: r0v7 */
        /* JADX WARNING: type inference failed for: r0v8 */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean onTransact(int r5, android.os.Parcel r6, android.os.Parcel r7, int r8) throws android.os.RemoteException {
            /*
                r4 = this;
                r0 = 0
                java.lang.String r1 = "android.service.media.IMediaBrowserService"
                r2 = 1
                if (r5 == r2) goto L_0x006f
                r3 = 2
                if (r5 == r3) goto L_0x0060
                r3 = 3
                if (r5 == r3) goto L_0x004d
                r3 = 4
                if (r5 == r3) goto L_0x003a
                r3 = 5
                if (r5 == r3) goto L_0x0020
                r0 = 1598968902(0x5f4e5446, float:1.4867585E19)
                if (r5 == r0) goto L_0x001c
                boolean r5 = super.onTransact(r5, r6, r7, r8)
                return r5
            L_0x001c:
                r7.writeString(r1)
                return r2
            L_0x0020:
                r6.enforceInterface(r1)
                java.lang.String r5 = r6.readString()
                int r7 = r6.readInt()
                if (r7 == 0) goto L_0x0036
                android.os.Parcelable$Creator r7 = android.os.ResultReceiver.CREATOR
                java.lang.Object r6 = r7.createFromParcel(r6)
                r0 = r6
                android.os.ResultReceiver r0 = (android.os.ResultReceiver) r0
            L_0x0036:
                r4.getMediaItem(r5, r0)
                return r2
            L_0x003a:
                r6.enforceInterface(r1)
                java.lang.String r5 = r6.readString()
                android.os.IBinder r6 = r6.readStrongBinder()
                java.lang.Object r6 = android.support.v4.media.IMediaBrowserServiceCallbacksAdapterApi21.Stub.asInterface(r6)
                r4.removeSubscription(r5, r6)
                return r2
            L_0x004d:
                r6.enforceInterface(r1)
                java.lang.String r5 = r6.readString()
                android.os.IBinder r6 = r6.readStrongBinder()
                java.lang.Object r6 = android.support.v4.media.IMediaBrowserServiceCallbacksAdapterApi21.Stub.asInterface(r6)
                r4.addSubscription(r5, r6)
                return r2
            L_0x0060:
                r6.enforceInterface(r1)
                android.os.IBinder r5 = r6.readStrongBinder()
                java.lang.Object r5 = android.support.v4.media.IMediaBrowserServiceCallbacksAdapterApi21.Stub.asInterface(r5)
                r4.disconnect(r5)
                return r2
            L_0x006f:
                r6.enforceInterface(r1)
                java.lang.String r5 = r6.readString()
                int r7 = r6.readInt()
                if (r7 == 0) goto L_0x0085
                android.os.Parcelable$Creator r7 = android.os.Bundle.CREATOR
                java.lang.Object r7 = r7.createFromParcel(r6)
                r0 = r7
                android.os.Bundle r0 = (android.os.Bundle) r0
            L_0x0085:
                android.os.IBinder r6 = r6.readStrongBinder()
                java.lang.Object r6 = android.support.v4.media.IMediaBrowserServiceCallbacksAdapterApi21.Stub.asInterface(r6)
                r4.connect(r5, r0, r6)
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v4.media.IMediaBrowserServiceAdapterApi21.Stub.onTransact(int, android.os.Parcel, android.os.Parcel, int):boolean");
        }
    }
}
