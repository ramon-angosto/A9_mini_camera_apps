package object.p2pipcam.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;
import object.p2pipcam.bean.WifiScanBean;

public class WifiSetting {
    private static final String TAG = "WifiSetting";
    private Context context1;
    private List<WifiScanBean> listAllSSID = new ArrayList();
    private List<ScanResult> listResult;
    private ScanResult mScanResult;
    private StringBuffer mStringBuffer = new StringBuffer();
    private List<WifiConfiguration> mWifiConfiguration;
    private WifiInfo mWifiInfo;
    WifiManager.WifiLock mWifiLock;
    private WifiManager mWifiManager;
    private WifiScanBean wifiScanBeanAoni;

    public WifiSetting(Context context) {
        this.context1 = context;
        this.mWifiManager = (WifiManager) context.getSystemService("wifi");
        this.mWifiInfo = this.mWifiManager.getConnectionInfo();
    }

    public static boolean isWiFiActive(Context context) {
        NetworkInfo[] allNetworkInfo;
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getApplicationContext().getSystemService("connectivity");
        if (!(connectivityManager == null || (allNetworkInfo = connectivityManager.getAllNetworkInfo()) == null)) {
            for (int i = 0; i < allNetworkInfo.length; i++) {
                if (allNetworkInfo[i].getTypeName().equals("WIFI") && allNetworkInfo[i].isConnected()) {
                    return true;
                }
            }
        }
        return false;
    }

    public WifiManager getWifiManager() {
        WifiManager wifiManager = this.mWifiManager;
        return wifiManager == null ? (WifiManager) this.context1.getSystemService("wifi") : wifiManager;
    }

    public void openNetCard() {
        if (!this.mWifiManager.isWifiEnabled()) {
            this.mWifiManager.setWifiEnabled(true);
        }
    }

    public void closeNetCard() {
        if (this.mWifiManager.isWifiEnabled()) {
            this.mWifiManager.setWifiEnabled(false);
        }
    }

    public void checkNetCardState() {
        Log.i(TAG, "checkNetCardState " + this.mWifiManager.getWifiState());
    }

    public void scan() {
        this.mWifiManager.startScan();
        this.listResult = this.mWifiManager.getScanResults();
        if (this.listResult != null) {
            Log.i(TAG, "scan list result not null");
        } else {
            Log.i(TAG, "scan null");
        }
    }

    public String getScanResult() {
        if (this.mStringBuffer != null) {
            this.mStringBuffer = new StringBuffer();
        }
        scan();
        this.listResult = this.mWifiManager.getScanResults();
        if (this.listResult != null) {
            int i = 0;
            while (i < this.listResult.size()) {
                this.mScanResult = this.listResult.get(i);
                StringBuffer stringBuffer = this.mStringBuffer;
                stringBuffer.append("NO.");
                i++;
                stringBuffer.append(i);
                stringBuffer.append(" :");
                stringBuffer.append(this.mScanResult.SSID);
                stringBuffer.append("->");
                stringBuffer.append(this.mScanResult.BSSID);
                stringBuffer.append("->");
                stringBuffer.append(this.mScanResult.capabilities);
                stringBuffer.append("->");
                stringBuffer.append(this.mScanResult.frequency);
                stringBuffer.append("->");
                stringBuffer.append(this.mScanResult.level);
                stringBuffer.append("->");
                stringBuffer.append(this.mScanResult.describeContents());
                stringBuffer.append("\n\n");
                this.mStringBuffer = stringBuffer;
            }
        }
        Log.i(TAG, this.mStringBuffer.toString());
        return this.mStringBuffer.toString();
    }

    public List<WifiScanBean> getScanSSIDResult() {
        return this.listAllSSID;
    }

    public void connect() {
        this.mWifiInfo = this.mWifiManager.getConnectionInfo();
    }

    public void disconnectWifi() {
        this.mWifiManager.disableNetwork(getNetworkId());
        this.mWifiManager.disconnect();
        this.mWifiInfo = null;
    }

    public void checkNetWorkState() {
        if (this.mWifiInfo != null) {
            Log.i(TAG, "checkNetWorkState not null");
        } else {
            Log.i(TAG, "checkNetWorkState null");
        }
    }

    public int getNetworkId() {
        WifiInfo wifiInfo = this.mWifiInfo;
        if (wifiInfo == null) {
            return 0;
        }
        return wifiInfo.getNetworkId();
    }

    public String getNowWifiSSID() {
        WifiInfo wifiInfo = this.mWifiInfo;
        if (wifiInfo == null) {
            return null;
        }
        return wifiInfo.getSSID();
    }

    public int getIPAddress() {
        WifiInfo wifiInfo = this.mWifiInfo;
        if (wifiInfo == null) {
            return 0;
        }
        return wifiInfo.getIpAddress();
    }

    public void acquireWifiLock() {
        this.mWifiLock.acquire();
    }

    public void releaseWifiLock() {
        if (this.mWifiLock.isHeld()) {
            this.mWifiLock.acquire();
        }
    }

    public void creatWifiLock() {
        this.mWifiLock = this.mWifiManager.createWifiLock("Test");
    }

    public List<WifiConfiguration> getConfiguration() {
        return this.mWifiConfiguration;
    }

    public void connectConfiguration(int i) {
        if (i < this.mWifiConfiguration.size()) {
            this.mWifiManager.enableNetwork(this.mWifiConfiguration.get(i).networkId, true);
        }
    }

    public String getMacAddress() {
        WifiInfo wifiInfo = this.mWifiInfo;
        return wifiInfo == null ? "NULL" : wifiInfo.getMacAddress();
    }

    public String getBSSID() {
        WifiInfo wifiInfo = this.mWifiInfo;
        return wifiInfo == null ? "NULL" : wifiInfo.getBSSID();
    }

    public String getWifiInfo() {
        WifiInfo wifiInfo = this.mWifiInfo;
        return wifiInfo == null ? "NULL" : wifiInfo.toString();
    }

    public int addNetwork(WifiConfiguration wifiConfiguration) {
        int addNetwork = this.mWifiManager.addNetwork(this.mWifiConfiguration.get(3));
        this.mWifiManager.enableNetwork(addNetwork, true);
        return addNetwork;
    }
}
