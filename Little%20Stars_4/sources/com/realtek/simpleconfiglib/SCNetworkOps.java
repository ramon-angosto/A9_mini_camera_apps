package com.realtek.simpleconfiglib;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.util.Log;
import com.realtek.simpleconfiglib.SCParam;
import java.io.IOException;
import java.io.PrintStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Enumeration;
import java.util.List;

public class SCNetworkOps {
    private static final String TAG = "SCNetworkOps";
    private static final int WIFI_AP_STATE_DISABLED = 11;
    private static final int WIFI_AP_STATE_DISABLING = 10;
    private static final int WIFI_AP_STATE_ENABLED = 13;
    private static final int WIFI_AP_STATE_ENABLING = 12;
    private static final int WIFI_AP_STATE_FAILED = 14;
    private static String macAddr;
    private boolean IsWifiApEnabled = false;
    private final String METHOD_GET_WIFI_AP_CONFIGURATION = "getWifiApConfiguration";
    private final String METHOD_GET_WIFI_AP_STATE = "getWifiApState";
    private final String METHOD_SET_WIFI_AP_CONFIG = "setWifiApConfig";
    private final String METHOD_SET_WIFI_AP_CONFIGURATION = "setWifiApConfiguration";
    private final String METHOD_SET_WIFI_AP_ENABLED = "setWifiApEnabled";
    private WifiInfo SCWifiInfo;
    private WifiManager SCWifiMngr;
    private Context context;
    private WifiConfiguration wifiApConf;

    public String WifiAvailable() {
        return "android.net.wifi.SCAN_RESULTS";
    }

    public static byte[] int2byteLE(int i) {
        return new byte[]{(byte) (i & 255), (byte) ((i >> 8) & 255), (byte) ((i >> 16) & 255), (byte) ((i >> 24) & 255)};
    }

    public static byte[] int2byteBE(int i) {
        byte[] bArr = new byte[4];
        bArr[3] = (byte) (i & 255);
        bArr[2] = (byte) ((i >> 8) & 255);
        bArr[1] = (byte) ((i >> 16) & 255);
        bArr[0] = (byte) ((i >> 24) & 255);
        return bArr;
    }

    public static long IPStr2IntegerBE(String str) {
        String[] split = str.split("\\.");
        return (Long.valueOf(split[0]).longValue() << 24) | (Long.valueOf(split[1]).longValue() << 16) | (Long.valueOf(split[2]).longValue() << 8) | Long.valueOf(split[3]).longValue();
    }

    public static String IntegerLE2IPStr(int i) {
        return (i & 255) + "." + ((i >> 8) & 255) + "." + ((i >> 16) & 255) + "." + ((i >> 24) & 255);
    }

    public static String IntegerBE2IPStr(int i) {
        return ((i >> 24) & 255) + "." + ((i >> 16) & 255) + "." + ((i >> 8) & 255) + "." + (i & 255);
    }

    public void WifiInit(Context context2) {
        this.context = context2;
        this.SCWifiMngr = (WifiManager) context2.getSystemService("wifi");
        this.SCWifiInfo = this.SCWifiMngr.getConnectionInfo();
        WifiInfo wifiInfo = this.SCWifiInfo;
        macAddr = wifiInfo == null ? null : wifiInfo.getMacAddress();
        Log.e(TAG, "mac(from java) is " + macAddr);
    }

    public void WifiOpen() {
        if (!this.SCWifiMngr.isWifiEnabled()) {
            this.SCWifiMngr.setWifiEnabled(true);
        }
    }

    public boolean isApEnabled(Context context2) {
        int wifiApState = getWifiApState(context2);
        return 12 == wifiApState || 13 == wifiApState;
    }

    public int getWifiApState(Context context2) {
        try {
            return ((Integer) this.SCWifiMngr.getClass().getMethod("getWifiApState", new Class[0]).invoke(this.SCWifiMngr, new Object[0])).intValue();
        } catch (Exception e) {
            e.printStackTrace();
            Log.e(TAG, "Cannot get WiFi AP state: " + e);
            return 14;
        }
    }

    public WifiConfiguration getWifiApConfiguration() {
        try {
            return (WifiConfiguration) this.SCWifiMngr.getClass().getMethod("getWifiApConfiguration", new Class[0]).invoke(this.SCWifiMngr, new Object[0]);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public String getWifiApSSID() {
        WifiConfiguration wifiApConfiguration = getWifiApConfiguration();
        String str = wifiApConfiguration.SSID;
        Log.e(TAG, "softAP ssid =" + str);
        if (wifiApConfiguration == null) {
            return null;
        }
        return str;
    }

    public void WifiClose() {
        if (this.SCWifiMngr.isWifiEnabled()) {
            this.SCWifiMngr.setWifiEnabled(false);
        }
    }

    public void WifiStartScan() {
        this.SCWifiMngr.startScan();
    }

    public List<ScanResult> WifiGetScanResults() {
        return this.SCWifiMngr.getScanResults();
    }

    public List<WifiConfiguration> WifiGetConfiguredNetworks() {
        return this.SCWifiMngr.getConfiguredNetworks();
    }

    public int WifiStatus() {
        return this.SCWifiMngr.getWifiState();
    }

    public boolean isWifiConnected(String str) {
        String ssid = this.SCWifiMngr.getConnectionInfo().getSSID();
        if (ssid == null) {
            Log.e(TAG, "Get SSID Error");
            return false;
        }
        if ((ssid.equals(new String("\"" + str + "\"")) || ssid.equals(new String(str))) && ((ConnectivityManager) this.context.getSystemService("connectivity")).getNetworkInfo(1).isConnected()) {
            return true;
        }
        return false;
    }

    public String getConnectedWifiSSID() {
        return this.SCWifiMngr.getConnectionInfo().getSSID();
    }

    public String getConnectedWifiBSSID() {
        return this.SCWifiMngr.getConnectionInfo().getBSSID();
    }

    public String WifiGetMacStr() {
        return macAddr;
    }

    public int WifiGetIpInt() {
        WifiInfo connectionInfo = this.SCWifiMngr.getConnectionInfo();
        if (connectionInfo == null) {
            return 0;
        }
        return connectionInfo.getIpAddress();
    }

    public String WifiGetIpString(int i) {
        return (i & 255) + "." + ((i >> 8) & 255) + "." + ((i >> 16) & 255) + "." + ((i >> 24) & 255);
    }

    public int SoftApGetInt() throws SocketException {
        Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
        if (!networkInterfaces.hasMoreElements()) {
            return 0;
        }
        Enumeration<InetAddress> inetAddresses = networkInterfaces.nextElement().getInetAddresses();
        while (inetAddresses.hasMoreElements()) {
            InetAddress nextElement = inetAddresses.nextElement();
            if (nextElement.getHostAddress().length() > 9 && nextElement.getHostAddress().length() <= 15 && !nextElement.getHostAddress().equals("127.0.0.1")) {
                String str = nextElement.getHostAddress().toString();
                int parseInt = Integer.parseInt(str);
                PrintStream printStream = System.out;
                printStream.println("SoftAp ipStr:" + str);
                PrintStream printStream2 = System.out;
                printStream2.println("SoftAp int format:" + parseInt);
                return parseInt;
            }
        }
        return 0;
    }

    public void BroadcastSocketCreate() {
        try {
            SCParam.UDPBcast.BcastSock = new DatagramSocket(SCParam.UDPBcast.SrcPort);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.printf("Broadcast Socket Create Error", new Object[0]);
        }
    }

    public void BroadcastSocketDestroy() {
        if (SCParam.UDPBcast.BcastSock != null) {
            SCParam.UDPBcast.BcastSock.close();
        }
    }

    public void UnicastSocketCreate() {
        try {
            SCParam.UDPUcast.UcastSock = new DatagramSocket(SCParam.UDPUcast.SrcPort);
        } catch (SocketException e) {
            e.printStackTrace();
            Log.e(TAG, "Unicast Socket Create Error");
        }
    }

    public void UnicastSocketDestroy() {
        if (SCParam.UDPUcast.UcastSock != null) {
            SCParam.UDPUcast.UcastSock.close();
        }
    }

    public void UDPBroadcastSend() {
        InetAddress inetAddress;
        try {
            inetAddress = InetAddress.getByName(SCParam.UDPBcast.IPAddr);
        } catch (UnknownHostException e) {
            e.printStackTrace();
            inetAddress = null;
        }
        if (inetAddress == null) {
            System.out.printf("Get InetAddress error!", new Object[0]);
            return;
        }
        try {
            SCParam.UDPBcast.BcastSock.send(new DatagramPacket(SCParam.UDPBcast.SendMsg, SCParam.UDPBcast.SendLen, inetAddress, SCParam.UDPBcast.DestPort));
        } catch (IOException unused) {
            Log.e(TAG, "UDP Broadcast Send Error");
        }
    }

    public void UDPUnicastSend() {
        InetAddress inetAddress;
        try {
            inetAddress = InetAddress.getByName(SCParam.UDPUcast.IPAddr);
        } catch (UnknownHostException e) {
            e.printStackTrace();
            inetAddress = null;
        }
        if (inetAddress == null) {
            System.out.printf("Get InetAddress error!", new Object[0]);
            return;
        }
        try {
            SCParam.UDPUcast.UcastSock.send(new DatagramPacket(SCParam.UDPUcast.SendMsg, SCParam.UDPUcast.SendLen, inetAddress, SCParam.UDPUcast.DestPort));
        } catch (IOException unused) {
            Log.e(TAG, "UDP Send Error");
        }
    }

    public boolean UDPUnicastRecv() {
        try {
            DatagramPacket datagramPacket = new DatagramPacket(SCParam.UDPUcast.RecvBuf, SCParam.UDPUcast.RecvBuf.length);
            SCParam.UDPUcast.UcastSock.receive(datagramPacket);
            SCParam.UDPUcast.RecvLen = datagramPacket.getLength();
            return true;
        } catch (IOException unused) {
            Log.e(TAG, "UDP Receive Error");
            return false;
        }
    }
}
