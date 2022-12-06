package com.mbridge.msdk.system;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.MBridgeSDK;
import com.mbridge.msdk.foundation.controller.authoritycontroller.AuthorityInfoBean;
import com.mbridge.msdk.foundation.controller.authoritycontroller.CallBackForDeveloper;
import com.mbridge.msdk.foundation.controller.b;
import com.mbridge.msdk.foundation.db.g;
import com.mbridge.msdk.foundation.download.MBDownloadConfig;
import com.mbridge.msdk.foundation.download.MBDownloadManager;
import com.mbridge.msdk.foundation.download.database.IDatabaseOpenHelper;
import com.mbridge.msdk.foundation.download.resource.ResourceConfig;
import com.mbridge.msdk.foundation.download.utils.ILogger;
import com.mbridge.msdk.foundation.same.net.n;
import com.mbridge.msdk.foundation.same.report.d;
import com.mbridge.msdk.foundation.tools.i;
import com.mbridge.msdk.foundation.tools.q;
import com.mbridge.msdk.out.SDKInitStatusListener;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* compiled from: MBridgeSDKImpl */
public final class a implements MBridgeSDK {
    public static Map<String, String> a;
    private static final Lock b = new ReentrantReadWriteLock().writeLock();
    private volatile MBridgeSDK.PLUGIN_LOAD_STATUS c = MBridgeSDK.PLUGIN_LOAD_STATUS.INITIAL;
    private Context d;
    private SDKInitStatusListener e;
    private boolean f = false;
    private final Application.ActivityLifecycleCallbacks g = new Application.ActivityLifecycleCallbacks() {
        public final void onActivityPaused(Activity activity) {
        }

        public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        public final void onActivityCreated(Activity activity, Bundle bundle) {
            i.a().c();
        }

        public final void onActivityStarted(Activity activity) {
            int f = com.mbridge.msdk.foundation.controller.a.e().f();
            if (f == 0) {
                d.a("1");
            }
            com.mbridge.msdk.foundation.controller.a.e().b(f + 1);
        }

        public final void onActivityResumed(Activity activity) {
            com.mbridge.msdk.foundation.controller.a.e().a((Context) activity);
        }

        public final void onActivityStopped(Activity activity) {
            int f = com.mbridge.msdk.foundation.controller.a.e().f();
            if (f <= 1) {
                d.a("2");
            }
            com.mbridge.msdk.foundation.controller.a.e().b(f - 1);
        }

        public final void onActivityDestroyed(Activity activity) {
            i.a().d();
            com.mbridge.msdk.foundation.controller.a.e().d();
        }
    };

    public final void setThirdPartyFeatures(Map<String, Object> map) {
    }

    public final void showUserPrivateInfoTips(Context context, CallBackForDeveloper callBackForDeveloper) {
    }

    private void a() {
        b.lock();
        this.f = false;
        try {
            if (this.d instanceof Application) {
                ((Application) this.d).registerActivityLifecycleCallbacks(this.g);
            }
            n.a(this.d);
            b.a().a((Map) a, this.d);
            this.c = MBridgeSDK.PLUGIN_LOAD_STATUS.COMPLETED;
            com.mbridge.msdk.foundation.same.net.g.d.c().d();
            HandlerThread handlerThread = new HandlerThread("mb_db_thread");
            handlerThread.start();
            Handler handler = new Handler(handlerThread.getLooper());
            MBDownloadConfig.Builder builder = new MBDownloadConfig.Builder();
            builder.setDatabaseHandler(handler);
            builder.setDatabaseOpenHelper(new IDatabaseOpenHelper() {
                public final SQLiteDatabase getReadableDatabase() {
                    return g.a(com.mbridge.msdk.foundation.controller.a.e().g()).a();
                }

                public final SQLiteDatabase getWritableDatabase() {
                    return g.a(com.mbridge.msdk.foundation.controller.a.e().g()).b();
                }
            });
            builder.setLogger(new ILogger() {
                public final void log(String str, String str2) {
                    q.a(str, str2);
                }

                public final void log(String str, Exception exc) {
                    q.a(str, exc.getMessage());
                }
            });
            MBDownloadManager.getInstance().initialize(com.mbridge.msdk.foundation.controller.a.e().g(), builder.build(), new ResourceConfig.Builder().setMaxStorageSpace(100).setMaxStorageTime(259200000).build());
            com.mbridge.msdk.foundation.same.report.a.a().b();
            if (this.e != null && !this.f) {
                this.f = true;
                this.e.onInitSuccess();
            }
            try {
                i.a().a(this.d.getApplicationContext());
            } catch (Exception e2) {
                q.a("com.mbridge.msdk", "INIT", e2);
            }
        } catch (Exception e3) {
            if (MBridgeConstans.DEBUG) {
                q.a("com.mbridge.msdk", "INIT FAIL", e3);
                e3.printStackTrace();
            }
            SDKInitStatusListener sDKInitStatusListener = this.e;
            if (sDKInitStatusListener != null && !this.f) {
                this.f = true;
                sDKInitStatusListener.onInitFail(e3.getMessage());
            }
        }
        b.unlock();
    }

    public final MBridgeSDK.PLUGIN_LOAD_STATUS getStatus() {
        return this.c;
    }

    public final void preload(Map<String, Object> map) {
        if (this.c == MBridgeSDK.PLUGIN_LOAD_STATUS.COMPLETED) {
            b.a().a(map, 0);
        }
    }

    public final void setUserPrivateInfoType(Context context, String str, int i) {
        a(context);
        com.mbridge.msdk.foundation.controller.authoritycontroller.a.a().a(str, i);
    }

    public final void setDoNotTrackStatus(boolean z) {
        com.mbridge.msdk.foundation.controller.authoritycontroller.a.a().b(z ? 1 : 0);
    }

    public final void setDoNotTrackStatus(Context context, boolean z) {
        a(context);
        com.mbridge.msdk.foundation.controller.authoritycontroller.a.a().b(z ? 1 : 0);
    }

    public final AuthorityInfoBean userPrivateInfo(Context context) {
        a(context);
        return com.mbridge.msdk.foundation.controller.authoritycontroller.a.a().b();
    }

    public final void setConsentStatus(Context context, int i) {
        a(context);
        com.mbridge.msdk.foundation.controller.authoritycontroller.a.a().a(i);
    }

    public final boolean getConsentStatus(Context context) {
        a(context);
        return com.mbridge.msdk.foundation.controller.authoritycontroller.a.a().d();
    }

    public final void preloadFrame(Map<String, Object> map) {
        b.a().a(map, 1);
    }

    public final Map<String, String> getMBConfigurationMap(String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put(MBridgeConstans.ID_MBRIDGE_APPID, str);
        hashMap.put(MBridgeConstans.ID_MBRIDGE_APPKEY, str2);
        hashMap.put(MBridgeConstans.ID_MBRIDGE_STARTUPCRASH, String.valueOf(1));
        return hashMap;
    }

    public final void release() {
        if (this.c == MBridgeSDK.PLUGIN_LOAD_STATUS.COMPLETED) {
            b.a().b();
        }
        Context context = this.d;
        if (context instanceof Application) {
            ((Application) context).unregisterActivityLifecycleCallbacks(this.g);
        }
    }

    public final void init(Map<String, String> map, Application application) {
        this.d = application.getApplicationContext();
        a = map;
        a();
    }

    public final void initAsync(Map<String, String> map, Application application) {
        this.d = application.getApplicationContext();
        a = map;
        a();
    }

    public final void init(Map<String, String> map, Context context) {
        this.d = context.getApplicationContext();
        a = map;
        a();
    }

    public final void initAsync(Map<String, String> map, Context context) {
        this.d = context.getApplicationContext();
        a = map;
        a();
    }

    public final void init(Map<String, String> map, Application application, SDKInitStatusListener sDKInitStatusListener) {
        this.d = application;
        this.e = sDKInitStatusListener;
        a = map;
        a();
    }

    public final void initAsync(Map<String, String> map, Application application, SDKInitStatusListener sDKInitStatusListener) {
        this.d = application;
        this.e = sDKInitStatusListener;
        a = map;
        a();
    }

    public final void init(Map<String, String> map, Context context, SDKInitStatusListener sDKInitStatusListener) {
        this.d = context.getApplicationContext();
        this.e = sDKInitStatusListener;
        a = map;
        a();
    }

    public final void initAsync(Map<String, String> map, Context context, SDKInitStatusListener sDKInitStatusListener) {
        this.d = context.getApplicationContext();
        this.e = sDKInitStatusListener;
        a = map;
        a();
    }

    private void a(Context context) {
        if (com.mbridge.msdk.foundation.controller.a.e().g() == null && context != null) {
            com.mbridge.msdk.foundation.controller.a.e().b(context);
        }
    }

    public final void updateDialogWeakActivity(WeakReference<Activity> weakReference) {
        com.mbridge.msdk.foundation.controller.a.e().a(weakReference);
    }
}
