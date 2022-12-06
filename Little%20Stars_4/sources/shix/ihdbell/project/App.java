package shix.ihdbell.project;

import android.app.ActivityManager;
import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.location.LocationManager;
import android.net.NetworkInfo;
import android.net.wifi.SupplicantState;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Parcelable;
import android.os.Process;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.google.firebase.iid.FirebaseInstanceIdInternalReceiver;
import com.jxl.app.littlestars.project.BuildConfig;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.shix.fcmpush1.FcmPush;
import com.tzh.ipcamera.view.delegate.IWiFiStateListener;
import java.util.List;
import shix.ihdbell.project.AppFrontBackHelper;

public class App extends Application {
    public static final int LOCATION_CONNECT_STATE_CONNECT = 1;
    public static final int LOCATION_CONNECT_STATE_DISCONNECT = 0;
    public static final int WIFI_CONNECT_STATE_CONNECT = 1;
    public static final int WIFI_CONNECT_STATE_DISCONNECT = 0;
    static Context context;
    BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (action.equals("android.net.wifi.WIFI_STATE_CHANGED")) {
                int intExtra = intent.getIntExtra("wifi_state", 0);
                Log.e("TAG", "wifiState:" + intExtra);
                if (intExtra == 1) {
                    int unused = App.this.mState = 0;
                    String unused2 = App.this.ssid = "";
                    if (App.this.listener != null) {
                        App.this.listener.onConnected(App.this.mState, "");
                    }
                }
            } else if (action.equals("android.net.wifi.STATE_CHANGE")) {
                Parcelable parcelableExtra = intent.getParcelableExtra("networkInfo");
                if (parcelableExtra != null) {
                    NetworkInfo.State state = ((NetworkInfo) parcelableExtra).getState();
                    WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
                    boolean z = state == NetworkInfo.State.CONNECTED;
                    Log.e("TAG", "###isConnected:" + z);
                    if (!z) {
                        int unused3 = App.this.mState = 0;
                        if (state == NetworkInfo.State.DISCONNECTED) {
                            String unused4 = App.this.ssid = "";
                            if (App.this.listener != null) {
                                App.this.listener.onConnected(App.this.mState, App.this.ssid);
                            }
                        }
                    } else if (((LocationManager) context.getSystemService(RequestParameters.SUBRESOURCE_LOCATION)).isProviderEnabled("gps") || Build.VERSION.SDK_INT < 26) {
                        int unused5 = App.this.mState = 1;
                        int unused6 = App.this.mLocationState = 1;
                        String unused7 = App.this.ssid = wifiManager.getConnectionInfo().getSSID();
                        if (App.this.ssid.equals("<unknown ssid>")) {
                            Log.e("App", "<unknown ssid>");
                        }
                        Log.e("App", "wifi get device ssid:" + App.this.ssid);
                        if (App.this.listener != null) {
                            App.this.listener.onConnected(App.this.mState, App.this.ssid);
                        }
                    } else {
                        String unused8 = App.this.ssid = "";
                        int unused9 = App.this.mState = 1;
                        int unused10 = App.this.mLocationState = 0;
                        if (App.this.listener != null) {
                            App.this.listener.onLocationClosed();
                        }
                    }
                }
            } else if (action.equals("android.net.conn.CONNECTIVITY_CHANGE")) {
                NetworkInfo networkInfo = (NetworkInfo) intent.getParcelableExtra("networkInfo");
                if (networkInfo != null && NetworkInfo.State.CONNECTED == networkInfo.getState() && networkInfo.isAvailable() && networkInfo.getType() != 1) {
                    networkInfo.getType();
                }
            } else if (action.equals("android.location.PROVIDERS_CHANGED") && App.this.mState == 1 && Build.VERSION.SDK_INT >= 26) {
                if (!((LocationManager) context.getSystemService(RequestParameters.SUBRESOURCE_LOCATION)).isProviderEnabled("gps")) {
                    String unused11 = App.this.ssid = "";
                    int unused12 = App.this.mState = 1;
                    int unused13 = App.this.mLocationState = 0;
                    if (App.this.listener != null) {
                        App.this.listener.onLocationClosed();
                        return;
                    }
                    return;
                }
                int unused14 = App.this.mState = 1;
                int unused15 = App.this.mLocationState = 1;
                String unused16 = App.this.ssid = ((WifiManager) context.getSystemService("wifi")).getConnectionInfo().getSSID();
                Log.e("App", "gps get device ssid:" + App.this.ssid);
                if (App.this.listener != null) {
                    App.this.listener.onConnected(App.this.mState, App.this.ssid);
                }
            }
        }
    };
    public String connectSSid = "";
    /* access modifiers changed from: private */
    public IWiFiStateListener listener = null;
    /* access modifiers changed from: private */
    public int mLocationState = 0;
    /* access modifiers changed from: private */
    public int mState = 0;
    /* access modifiers changed from: private */
    public String ssid = "";

    public boolean isMainProcess() {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) getSystemService(PushConstants.INTENT_ACTIVITY_NAME)).getRunningAppProcesses();
        String packageName = getPackageName();
        int myPid = Process.myPid();
        for (ActivityManager.RunningAppProcessInfo next : runningAppProcesses) {
            if (next.pid == myPid && packageName.equals(next.processName)) {
                return true;
            }
        }
        return false;
    }

    public void onCreate() {
        super.onCreate();
        context = this;
        FcmPush.init(this);
        Log.e("App", "####onCreate");
        new AppFrontBackHelper().register(this, new AppFrontBackHelper.OnAppStatusListener() {
            public void onFront() {
                App.this.getPackageManager().setComponentEnabledSetting(new ComponentName(BuildConfig.APPLICATION_ID, FirebaseInstanceIdInternalReceiver.class.getName()), 2, 1);
                if (ContextCompat.checkSelfPermission(App.context, "android.permission.ACCESS_FINE_LOCATION") == 0 && App.this.listener != null) {
                    String ssid = ((WifiManager) App.this.getApplicationContext().getSystemService("wifi")).getConnectionInfo().getSSID();
                    if (App.isWifiConnected(App.context)) {
                        int unused = App.this.mState = 1;
                        App.this.listener.onConnected(App.this.mState, ssid);
                        return;
                    }
                    int unused2 = App.this.mState = 0;
                }
            }

            public void onBack() {
                App.this.getPackageManager().setComponentEnabledSetting(new ComponentName(BuildConfig.APPLICATION_ID, FirebaseInstanceIdInternalReceiver.class.getName()), 2, 1);
            }
        });
    }

    public static boolean isWifiConnected(Context context2) {
        WifiInfo connectionInfo;
        WifiManager wifiManager = (WifiManager) context2.getApplicationContext().getSystemService("wifi");
        if (wifiManager == null || !wifiManager.isWifiEnabled() || (connectionInfo = wifiManager.getConnectionInfo()) == null || connectionInfo.getNetworkId() == -1 || connectionInfo.getSupplicantState() != SupplicantState.COMPLETED) {
            return false;
        }
        return true;
    }

    public void registerReciver() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
        intentFilter.addAction("android.net.wifi.STATE_CHANGE");
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        intentFilter.addAction("android.location.PROVIDERS_CHANGED");
        registerReceiver(this.broadcastReceiver, intentFilter);
    }

    public void unregisterReciver() {
        try {
            unregisterReceiver(this.broadcastReceiver);
        } catch (IllegalArgumentException unused) {
        }
    }

    public void OnDestroy() {
        FcmPush.unRegister();
        Log.e("App", "####onCreate");
    }

    public String getConnectWifi() {
        return this.ssid;
    }

    public void setOnReciveListener(IWiFiStateListener iWiFiStateListener) {
        this.listener = iWiFiStateListener;
        if (iWiFiStateListener != null) {
            iWiFiStateListener.onConnected(this.mState, this.ssid);
            if (this.mLocationState == 0 && this.mState == 1 && Build.VERSION.SDK_INT >= 26) {
                iWiFiStateListener.onLocationClosed();
            }
        }
    }

    public IWiFiStateListener getListener() {
        return this.listener;
    }
}
