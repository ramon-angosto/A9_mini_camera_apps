package com.bytedance.sdk.openadsdk.multipro.aidl.a;

import android.os.RemoteCallbackList;
import android.os.RemoteException;
import com.bytedance.sdk.component.utils.l;
import com.bytedance.sdk.openadsdk.ICommonPermissionListener;
import java.util.HashMap;

/* compiled from: CommonPermissionListenerManagerImpl */
public class c extends a {
    private static HashMap<String, RemoteCallbackList<ICommonPermissionListener>> a = new HashMap<>();
    private static volatile c b;

    public static c a() {
        if (b == null) {
            synchronized (c.class) {
                if (b == null) {
                    b = new c();
                }
            }
        }
        return b;
    }

    public void registerPermissionListener(String str, ICommonPermissionListener iCommonPermissionListener) throws RemoteException {
        if (iCommonPermissionListener != null) {
            l.b("MultiProcess", "CommonPermissionListenerManagerImpl registerPermissionListener");
            RemoteCallbackList remoteCallbackList = new RemoteCallbackList();
            remoteCallbackList.register(iCommonPermissionListener);
            a.put(str, remoteCallbackList);
        }
    }

    public void broadcastPermissionListener(String str, String str2) throws RemoteException {
        l.b("MultiProcess", "00000 CommonPermissionListenerManagerImpl broadcastDialogListener: 00000" + String.valueOf(str) + ", " + str2);
        RemoteCallbackList remove = a.remove(str);
        if (remove != null) {
            int beginBroadcast = remove.beginBroadcast();
            for (int i = 0; i < beginBroadcast; i++) {
                ICommonPermissionListener iCommonPermissionListener = (ICommonPermissionListener) remove.getBroadcastItem(i);
                if (iCommonPermissionListener != null) {
                    l.b("MultiProcess", "CommonPermissionListenerManagerImpl broadcastDialogListener: " + String.valueOf(str) + ", " + str2);
                    if (str2 == null) {
                        iCommonPermissionListener.onGranted();
                    } else {
                        iCommonPermissionListener.onDenied(str2);
                    }
                }
            }
            remove.finishBroadcast();
            remove.kill();
        }
    }
}
