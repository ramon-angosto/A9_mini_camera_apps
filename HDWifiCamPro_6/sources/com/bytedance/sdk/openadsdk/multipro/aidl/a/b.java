package com.bytedance.sdk.openadsdk.multipro.aidl.a;

import android.os.RemoteCallbackList;
import android.os.RemoteException;
import com.bytedance.sdk.component.utils.l;
import com.bytedance.sdk.openadsdk.IAppOpenAdInteractionListener;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* compiled from: AppOpenAdListenerManagerImpl */
public class b extends a {
    private static Map<String, RemoteCallbackList<IAppOpenAdInteractionListener>> a = Collections.synchronizedMap(new HashMap());
    private static volatile b b;

    public static b a() {
        if (b == null) {
            synchronized (b.class) {
                if (b == null) {
                    b = new b();
                }
            }
        }
        return b;
    }

    public synchronized void registerAppOpenAdListener(String str, IAppOpenAdInteractionListener iAppOpenAdInteractionListener) throws RemoteException {
        RemoteCallbackList remoteCallbackList = new RemoteCallbackList();
        remoteCallbackList.register(iAppOpenAdInteractionListener);
        a.put(str, remoteCallbackList);
    }

    public void executeAppOpenAdCallback(String str, String str2) throws RemoteException {
        a(str, str2);
    }

    private synchronized void a(String str, String str2) {
        RemoteCallbackList remoteCallbackList;
        try {
            if (a != null) {
                if ("recycleRes".equals(str2)) {
                    remoteCallbackList = a.remove(str);
                } else {
                    remoteCallbackList = a.get(str);
                }
                if (remoteCallbackList != null) {
                    int beginBroadcast = remoteCallbackList.beginBroadcast();
                    for (int i = 0; i < beginBroadcast; i++) {
                        IAppOpenAdInteractionListener iAppOpenAdInteractionListener = (IAppOpenAdInteractionListener) remoteCallbackList.getBroadcastItem(i);
                        if (iAppOpenAdInteractionListener != null) {
                            if ("onAdShow".equals(str2)) {
                                iAppOpenAdInteractionListener.onAdShow();
                            } else if ("onAdClicked".equals(str2)) {
                                iAppOpenAdInteractionListener.onAdClicked();
                            } else if ("onAdSkip".equals(str2)) {
                                iAppOpenAdInteractionListener.onAdSkip();
                            } else if ("onAdTimeOver".equals(str2)) {
                                iAppOpenAdInteractionListener.onAdTimeOver();
                            } else if ("recycleRes".equals(str2)) {
                                iAppOpenAdInteractionListener.onDestroy();
                            }
                        }
                    }
                    remoteCallbackList.finishBroadcast();
                    if ("recycleRes".equals(str2)) {
                        remoteCallbackList.kill();
                    }
                }
            }
        } catch (Throwable th) {
            l.c("MultiProcess", "appOpenAd1 method " + str2 + " throws Exception :", th);
        }
        return;
    }
}
