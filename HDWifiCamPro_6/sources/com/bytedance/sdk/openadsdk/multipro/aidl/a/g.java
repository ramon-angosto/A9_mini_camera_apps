package com.bytedance.sdk.openadsdk.multipro.aidl.a;

import android.os.RemoteCallbackList;
import android.os.RemoteException;
import com.bytedance.sdk.component.utils.l;
import com.bytedance.sdk.openadsdk.IRewardAdInteractionListener;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* compiled from: RewardAdVideoListenerManagerImpl */
public class g extends a {
    private static Map<String, RemoteCallbackList<IRewardAdInteractionListener>> a = Collections.synchronizedMap(new HashMap());
    private static volatile g b;

    public static g a() {
        if (b == null) {
            synchronized (g.class) {
                if (b == null) {
                    b = new g();
                }
            }
        }
        return b;
    }

    public synchronized void registerRewardVideoListener(String str, IRewardAdInteractionListener iRewardAdInteractionListener) throws RemoteException {
        RemoteCallbackList remoteCallbackList = new RemoteCallbackList();
        remoteCallbackList.register(iRewardAdInteractionListener);
        a.put(str, remoteCallbackList);
    }

    public void executeRewardVideoCallback(String str, String str2, boolean z, int i, String str3, int i2, String str4) throws RemoteException {
        a(str, str2, z, i, str3, i2, str4);
    }

    private synchronized void a(String str, String str2, boolean z, int i, String str3, int i2, String str4) {
        RemoteCallbackList remoteCallbackList;
        String str5 = str;
        String str6 = str2;
        synchronized (this) {
            try {
                if (a != null) {
                    if ("recycleRes".equals(str2)) {
                        remoteCallbackList = a.remove(str);
                    } else {
                        remoteCallbackList = a.get(str);
                    }
                    RemoteCallbackList remoteCallbackList2 = remoteCallbackList;
                    if (remoteCallbackList2 != null) {
                        int beginBroadcast = remoteCallbackList2.beginBroadcast();
                        for (int i3 = 0; i3 < beginBroadcast; i3++) {
                            IRewardAdInteractionListener iRewardAdInteractionListener = (IRewardAdInteractionListener) remoteCallbackList2.getBroadcastItem(i3);
                            if (iRewardAdInteractionListener != null) {
                                if ("onAdShow".equals(str2)) {
                                    iRewardAdInteractionListener.onAdShow();
                                } else if ("onAdClose".equals(str2)) {
                                    iRewardAdInteractionListener.onAdClose();
                                } else if ("onVideoComplete".equals(str2)) {
                                    iRewardAdInteractionListener.onVideoComplete();
                                } else if ("onVideoError".equals(str2)) {
                                    iRewardAdInteractionListener.onVideoError();
                                } else if ("onAdVideoBarClick".equals(str2)) {
                                    iRewardAdInteractionListener.onAdVideoBarClick();
                                } else if ("onRewardVerify".equals(str2)) {
                                    iRewardAdInteractionListener.onRewardVerify(z, i, str3, i2, str4);
                                } else if ("onSkippedVideo".equals(str2)) {
                                    iRewardAdInteractionListener.onSkippedVideo();
                                } else if ("recycleRes".equals(str2)) {
                                    iRewardAdInteractionListener.onDestroy();
                                }
                            }
                        }
                        remoteCallbackList2.finishBroadcast();
                        if ("recycleRes".equals(str2)) {
                            remoteCallbackList2.kill();
                        }
                    }
                }
            } catch (Throwable th) {
                l.c("MultiProcess", "reward2 '" + str2 + "'  throws Exception :", th);
            }
        }
        return;
    }
}
