package com.bytedance.sdk.openadsdk.multipro.aidl.a;

import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.text.TextUtils;
import com.bytedance.sdk.component.utils.l;
import com.bytedance.sdk.openadsdk.IDislikeClosedListener;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: DislikeClosedListenerManagerImpl */
public class d extends a {
    public static ConcurrentHashMap<String, RemoteCallbackList<IDislikeClosedListener>> a = new ConcurrentHashMap<>();
    private static volatile d b;

    public static d a() {
        if (b == null) {
            synchronized (d.class) {
                if (b == null) {
                    b = new d();
                }
            }
        }
        return b;
    }

    public synchronized void registerDisLikeClosedListener(String str, IDislikeClosedListener iDislikeClosedListener) throws RemoteException {
        RemoteCallbackList remoteCallbackList = new RemoteCallbackList();
        remoteCallbackList.register(iDislikeClosedListener);
        a.put(str, remoteCallbackList);
    }

    public void unregisterDisLikeClosedListener(String str) throws RemoteException {
        if (!TextUtils.isEmpty(str)) {
            a.remove(str);
        }
    }

    public void executeDisLikeClosedCallback(String str, String str2) throws RemoteException {
        a(str, str2);
    }

    private synchronized void a(String str, String str2) {
        RemoteCallbackList remoteCallbackList;
        try {
            if (!(a == null || (remoteCallbackList = a.get(str)) == null)) {
                int beginBroadcast = remoteCallbackList.beginBroadcast();
                for (int i = 0; i < beginBroadcast; i++) {
                    IDislikeClosedListener iDislikeClosedListener = (IDislikeClosedListener) remoteCallbackList.getBroadcastItem(i);
                    if (iDislikeClosedListener != null && "onItemClickClosed".equals(str2)) {
                        iDislikeClosedListener.onItemClickClosed();
                    }
                }
                remoteCallbackList.finishBroadcast();
            }
        } catch (Throwable th) {
            l.c("MultiProcess", "dislike '" + str2 + "'  throws Exception :", th);
        }
        return;
    }
}
