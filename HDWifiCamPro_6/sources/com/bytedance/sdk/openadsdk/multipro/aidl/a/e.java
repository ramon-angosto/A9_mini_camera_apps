package com.bytedance.sdk.openadsdk.multipro.aidl.a;

import android.os.RemoteCallbackList;
import android.os.RemoteException;
import com.bytedance.sdk.component.utils.l;
import com.bytedance.sdk.openadsdk.IFullScreenVideoAdInteractionListener;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* compiled from: FullScreenVideoListenerManagerImpl */
public class e extends a {
    private static Map<String, RemoteCallbackList<IFullScreenVideoAdInteractionListener>> a = Collections.synchronizedMap(new HashMap());
    private static volatile e b;

    public static e a() {
        if (b == null) {
            synchronized (e.class) {
                if (b == null) {
                    b = new e();
                }
            }
        }
        return b;
    }

    public synchronized void registerFullVideoListener(String str, IFullScreenVideoAdInteractionListener iFullScreenVideoAdInteractionListener) throws RemoteException {
        RemoteCallbackList remoteCallbackList = new RemoteCallbackList();
        remoteCallbackList.register(iFullScreenVideoAdInteractionListener);
        a.put(str, remoteCallbackList);
    }

    public void executeFullVideoCallback(String str, String str2) throws RemoteException {
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
                        IFullScreenVideoAdInteractionListener iFullScreenVideoAdInteractionListener = (IFullScreenVideoAdInteractionListener) remoteCallbackList.getBroadcastItem(i);
                        if (iFullScreenVideoAdInteractionListener != null) {
                            if ("onAdShow".equals(str2)) {
                                iFullScreenVideoAdInteractionListener.onAdShow();
                            } else if ("onAdClose".equals(str2)) {
                                iFullScreenVideoAdInteractionListener.onAdClose();
                            } else if ("onVideoComplete".equals(str2)) {
                                iFullScreenVideoAdInteractionListener.onVideoComplete();
                            } else if ("onSkippedVideo".equals(str2)) {
                                iFullScreenVideoAdInteractionListener.onSkippedVideo();
                            } else if ("onAdVideoBarClick".equals(str2)) {
                                iFullScreenVideoAdInteractionListener.onAdVideoBarClick();
                            } else if ("recycleRes".equals(str2)) {
                                iFullScreenVideoAdInteractionListener.onDestroy();
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
            l.c("MultiProcess", "fullScreen1 method " + str2 + " throws Exception :", th);
        }
        return;
    }
}
