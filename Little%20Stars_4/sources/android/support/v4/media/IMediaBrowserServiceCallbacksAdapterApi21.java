package android.support.v4.media;

import android.media.session.MediaSession;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class IMediaBrowserServiceCallbacksAdapterApi21 {
    private Method mAsBinderMethod;
    Object mCallbackObject;
    private Method mOnConnectFailedMethod;
    private Method mOnConnectMethod;
    private Method mOnLoadChildrenMethod;

    IMediaBrowserServiceCallbacksAdapterApi21(Object obj) {
        this.mCallbackObject = obj;
        try {
            Class<?> cls = Class.forName("android.service.media.IMediaBrowserServiceCallbacks");
            Class<?> cls2 = Class.forName("android.content.pm.ParceledListSlice");
            this.mAsBinderMethod = cls.getMethod("asBinder", new Class[0]);
            this.mOnConnectMethod = cls.getMethod("onConnect", new Class[]{String.class, MediaSession.Token.class, Bundle.class});
            this.mOnConnectFailedMethod = cls.getMethod("onConnectFailed", new Class[0]);
            this.mOnLoadChildrenMethod = cls.getMethod("onLoadChildren", new Class[]{String.class, cls2});
        } catch (ClassNotFoundException | NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    /* access modifiers changed from: package-private */
    public IBinder asBinder() {
        try {
            return (IBinder) this.mAsBinderMethod.invoke(this.mCallbackObject, new Object[0]);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public void onConnect(String str, Object obj, Bundle bundle) throws RemoteException {
        try {
            this.mOnConnectMethod.invoke(this.mCallbackObject, new Object[]{str, obj, bundle});
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    /* access modifiers changed from: package-private */
    public void onConnectFailed() throws RemoteException {
        try {
            this.mOnConnectFailedMethod.invoke(this.mCallbackObject, new Object[0]);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    /* access modifiers changed from: package-private */
    public void onLoadChildren(String str, Object obj) throws RemoteException {
        try {
            this.mOnLoadChildrenMethod.invoke(this.mCallbackObject, new Object[]{str, obj});
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    static class Stub {
        static Method sAsInterfaceMethod;

        Stub() {
        }

        static {
            try {
                sAsInterfaceMethod = Class.forName("android.service.media.IMediaBrowserServiceCallbacks$Stub").getMethod("asInterface", new Class[]{IBinder.class});
            } catch (ClassNotFoundException | NoSuchMethodException e) {
                e.printStackTrace();
            }
        }

        static Object asInterface(IBinder iBinder) {
            try {
                return sAsInterfaceMethod.invoke((Object) null, new Object[]{iBinder});
            } catch (IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
                return null;
            }
        }
    }
}
