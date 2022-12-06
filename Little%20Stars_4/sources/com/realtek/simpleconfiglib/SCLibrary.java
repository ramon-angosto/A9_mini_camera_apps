package com.realtek.simpleconfiglib;

import android.content.Context;
import android.net.wifi.ScanResult;
import android.os.Handler;
import android.os.Message;
import android.os.Process;
import android.util.Log;
import com.realtek.simpleconfiglib.SCJNI;
import com.realtek.simpleconfiglib.SCParam;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class SCLibrary {
    public static byte EachPacketSendCounts = 1;
    public static int OldModeConfigTimeMs = 30000;
    public static boolean PackType = true;
    public static int PacketSendTimeIntervalMs = 0;
    public static byte ProfileSendRounds = 0;
    public static int ProfileSendTimeIntervalMs = 0;
    private static final String TAG = "SCLibrary";
    public static int TotalConfigTimeMs = 120000;
    /* access modifiers changed from: private */
    public boolean ConfigSuccess;
    /* access modifiers changed from: private */
    public boolean RecvEnable;
    private Thread RecvThread;
    /* access modifiers changed from: private */
    public SCNetworkOps SCNetOps;
    /* access modifiers changed from: private */
    public SCJNI.Args ScArgs;
    /* access modifiers changed from: private */
    public SCJNI ScJni = new SCJNI();
    public boolean SendEnable;
    /* access modifiers changed from: private */
    public boolean SendInProgress;
    private Thread SendThread;
    public Handler TreadMsgHandler;

    public void rtk_sc_build_profile() {
    }

    public SCLibrary() {
        SCJNI scjni = this.ScJni;
        scjni.getClass();
        this.ScArgs = new SCJNI.Args();
        this.ConfigSuccess = false;
        this.SendEnable = false;
        this.SendInProgress = false;
        this.RecvEnable = false;
    }

    static {
        System.loadLibrary("simpleconfiglib");
    }

    public void WifiInit(Context context) {
        this.SCNetOps.WifiInit(context);
    }

    public void WifiOpen() {
        this.SCNetOps.WifiOpen();
    }

    public boolean IsWifiApEnabled(Context context) {
        return this.SCNetOps.isApEnabled(context);
    }

    public void WifiStartScan() {
        this.SCNetOps.WifiStartScan();
    }

    public List<ScanResult> WifiGetScanResults() {
        return this.SCNetOps.WifiGetScanResults();
    }

    public int WifiStatus() {
        return this.SCNetOps.WifiStatus();
    }

    public String WifiAvailable() {
        return this.SCNetOps.WifiAvailable();
    }

    public boolean isWifiConnected(String str) {
        return this.SCNetOps.isWifiConnected(str);
    }

    public String getConnectedWifiSSID() {
        return this.SCNetOps.getConnectedWifiSSID();
    }

    public String getConnectedWifiBSSID() {
        return this.SCNetOps.getConnectedWifiBSSID();
    }

    public String WifiGetMacStr() {
        return this.SCNetOps.WifiGetMacStr();
    }

    public int WifiGetIpInt() {
        return this.SCNetOps.WifiGetIpInt();
    }

    public String WifiGetIpString(int i) {
        return this.SCNetOps.WifiGetIpString(i);
    }

    private void RtkSCNetInit() {
        this.SCNetOps = new SCNetworkOps();
        SCParam.UDPBcast.SrcPort = 18864;
        SCParam.UDPBcast.DestPort = 18864;
        this.SCNetOps.BroadcastSocketCreate();
        SCParam.UDPUcast.SrcPort = 8864;
        SCParam.UDPUcast.DestPort = 8864;
        this.SCNetOps.UnicastSocketCreate();
    }

    public void rtk_sc_reset() {
        this.ConfigSuccess = false;
        SCParam.RecvACK.MaxCfgNum = 0;
        Arrays.fill(SCParam.RecvACK.Status, (byte) 0);
        for (int i = 0; i < 32; i++) {
            Arrays.fill(SCParam.RecvACK.Mac[i], (byte) 0);
            Arrays.fill(SCParam.RecvACK.Type[i], (byte) 0);
            Arrays.fill(SCParam.RecvACK.IPBuf[i], (byte) 0);
            Arrays.fill(SCParam.RecvACK.NameBuf[i], (byte) 0);
        }
        SCParam.RecvACK.IP = new String[32];
        SCParam.RecvACK.Name = new String[32];
    }

    public void rtk_sc_init() {
        RtkSCNetInit();
        rtk_sc_reset();
        RtkSCRecvThread();
    }

    public void rtk_sc_exit() {
        this.SCNetOps.BroadcastSocketDestroy();
        this.SCNetOps.UnicastSocketDestroy();
        this.SendEnable = false;
        this.ScJni.StopConfig();
        this.RecvEnable = false;
        this.ConfigSuccess = false;
        this.RecvThread.interrupt();
    }

    public void rtk_sc_set_ssid(String str) {
        if (str != null) {
            SCParam.SC_SSID = str;
        }
    }

    public void rtk_sc_set_password(String str) {
        if (str != null) {
            SCParam.SC_PASSWD = str;
        }
    }

    public void rtk_sc_set_ip(int i) {
        SCParam.SC_IP = i;
    }

    public void rtk_sc_set_bssid(String str) {
        if (str == null) {
            Log.e(TAG, "BSSID is null\n");
        } else {
            SCParam.SC_BSSID = str;
        }
    }

    public void rtk_sc_set_default_pin(String str) {
        if (str == null || str.length() <= 0) {
            Log.e(TAG, "Invalid PIN");
        } else {
            SCParam.Default_PIN = str;
        }
    }

    public String rtk_sc_get_default_pin() {
        return SCParam.Default_PIN;
    }

    public void rtk_sc_set_pin(String str) {
        if (str == null || str.length() <= 0) {
            SCParam.SC_PIN = SCParam.Default_PIN;
            this.ScArgs.Mode = 2;
            return;
        }
        SCParam.SC_PIN = str;
        this.ScArgs.Mode = 3;
    }

    public void rtk_sc_start(String str, String str2, String str3, String str4, boolean z, boolean z2, int i, int i2, byte b, int i3, int i4, byte b2, String str5, String str6, String str7) {
        String str8 = str;
        String str9 = str2;
        final String str10 = str3;
        final String str11 = str4;
        final boolean z3 = z;
        final boolean z4 = z2;
        final int i5 = i;
        final int i6 = i2;
        final byte b3 = b;
        final int i7 = i3;
        final int i8 = i4;
        final byte b4 = b2;
        final String str12 = str5;
        final String str13 = str6;
        final String str14 = str7;
        Log.d(TAG, "hostip : " + str5);
        Log.d(TAG, "wifi_interface : " + str6);
        Log.d(TAG, "phoneMac : " + str7);
        this.SendEnable = true;
        String str15 = TAG;
        AnonymousClass1 r19 = r0;
        final String str16 = str;
        final String str17 = str2;
        AnonymousClass1 r0 = new Runnable(this) {
            final /* synthetic */ SCLibrary this$0;

            {
                this.this$0 = r3;
            }

            public void run() {
                this.this$0.SendInProgress = true;
                Process.setThreadPriority(0);
                long currentTimeMillis = System.currentTimeMillis();
                long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                this.this$0.ScArgs.SSID = str16.getBytes();
                this.this$0.ScArgs.SSIDLen = (byte) str16.getBytes().length;
                this.this$0.ScArgs.Passwd = str17.getBytes();
                this.this$0.ScArgs.PasswdLen = (byte) str17.getBytes().length;
                this.this$0.ScArgs.PIN = str10.getBytes();
                this.this$0.ScArgs.PINLen = (byte) str10.getBytes().length;
                this.this$0.ScArgs.BSSID = str11.getBytes();
                this.this$0.ScArgs.BSSIDLen = (byte) str11.getBytes().length;
                this.this$0.ScArgs.ProfileRounds = b3;
                this.this$0.ScArgs.ProfileInterval = i7;
                this.this$0.ScArgs.PacketInterval = i8;
                this.this$0.ScArgs.PacketCnts = b4;
                this.this$0.ScArgs.Pack_type = z3;
                this.this$0.ScArgs.isSoftApMode = z4;
                this.this$0.ScArgs.hostIP = str12.getBytes();
                this.this$0.ScArgs.HostIPLEN = (byte) str12.getBytes().length;
                this.this$0.ScArgs.wifiInterface = str13.getBytes();
                this.this$0.ScArgs.WifiInterfaceLEN = (byte) str13.getBytes().length;
                this.this$0.ScArgs.PhoneMac = str14.getBytes();
                this.this$0.ScArgs.PhoneMacLen = (byte) str14.getBytes().length;
                this.this$0.ScArgs.Length = this.this$0.ScArgs.SSIDLen + this.this$0.ScArgs.PasswdLen + 4 + 2;
                if (this.this$0.ScArgs.SSIDLen > 0) {
                    this.this$0.ScArgs.Length++;
                }
                while (this.this$0.SendEnable && !this.this$0.ConfigSuccess && currentTimeMillis2 < ((long) i6)) {
                    Log.i(SCLibrary.TAG, "Start old mode config...");
                    this.this$0.ScArgs.ConfigTime = i6;
                    this.this$0.ScArgs.SyncRounds = 1;
                    this.this$0.ScJni.StartConfig(this.this$0.ScArgs);
                    currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                }
                while (this.this$0.SendEnable && !this.this$0.ConfigSuccess && currentTimeMillis2 < ((long) i5)) {
                    Log.i(SCLibrary.TAG, "Start new mode config...");
                    this.this$0.ScArgs.ConfigTime = i5 - i6;
                    this.this$0.ScArgs.SyncRounds = 16;
                    this.this$0.ScArgs.Mode = 4;
                    this.this$0.ScJni.StartConfig(this.this$0.ScArgs);
                    currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                }
                long currentTimeMillis3 = System.currentTimeMillis() - currentTimeMillis;
                Log.i(SCLibrary.TAG, "Total Config Time Elapsed: " + currentTimeMillis3 + "ms");
                if (!this.this$0.ConfigSuccess && currentTimeMillis3 > ((long) i5)) {
                    Message obtain = Message.obtain();
                    obtain.obj = null;
                    obtain.what = -1;
                    this.this$0.TreadMsgHandler.sendMessage(obtain);
                }
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Message obtain2 = Message.obtain();
                obtain2.obj = Long.toString(currentTimeMillis3);
                obtain2.what = 5;
                this.this$0.TreadMsgHandler.sendMessage(obtain2);
                this.this$0.SendInProgress = false;
            }
        };
        this.SendThread = new Thread(r19);
        if (!this.SendInProgress) {
            this.SendThread.start();
        } else {
            Log.w(str15, "Config already in progress!");
        }
    }

    public void rtk_sc_start(String str, String str2) {
        SCParam.SC_WIFI_Interface = str;
        SCParam.SC_HOSTIP = str2;
        SCParam.SC_PHONE_MAC_ADDR = this.SCNetOps.WifiGetMacStr();
        SCParam.SC_SOFTAP_MODE = false;
        rtk_sc_start(SCParam.SC_SSID, SCParam.SC_PASSWD, SCParam.SC_PIN, SCParam.SC_BSSID, SCParam.SC_PKT_TYPE, SCParam.SC_SOFTAP_MODE, TotalConfigTimeMs, OldModeConfigTimeMs, ProfileSendRounds, ProfileSendTimeIntervalMs, PacketSendTimeIntervalMs, EachPacketSendCounts, SCParam.SC_HOSTIP, SCParam.SC_WIFI_Interface, SCParam.SC_PHONE_MAC_ADDR);
    }

    public void rtk_sc_stop() {
        this.SendEnable = false;
        this.ScJni.StopConfig();
        this.ConfigSuccess = false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x0134  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x01a1  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x01af  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x01bf  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0236  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x028e  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x02b5  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int HandleCfgACK(byte[] r21) {
        /*
            r20 = this;
            r1 = r20
            r2 = r21
            r3 = 1
            byte r0 = r2[r3]
            int r0 = r0 << 8
            r4 = 65280(0xff00, float:9.1477E-41)
            r0 = r0 & r4
            r4 = 2
            byte r5 = r2[r4]
            r5 = r5 & 255(0xff, float:3.57E-43)
            r5 = r5 | r0
            r0 = -1
            r6 = 13
            java.lang.String r7 = "SCLibrary"
            if (r5 >= r6) goto L_0x0020
            java.lang.String r2 = "Received format error\n"
            android.util.Log.e(r7, r2)
            return r0
        L_0x0020:
            int r8 = com.realtek.simpleconfiglib.SCParam.RecvACK.MaxCfgNum
            r9 = 32
            if (r8 <= r9) goto L_0x002c
            java.lang.String r2 = "Receive buf is full\n"
            android.util.Log.e(r7, r2)
            return r0
        L_0x002c:
            int r0 = com.realtek.simpleconfiglib.SCParam.RecvACK.MaxCfgNum
            r8 = 6
            r9 = 0
            if (r0 <= 0) goto L_0x0053
            r0 = 0
        L_0x0033:
            int r10 = com.realtek.simpleconfiglib.SCParam.RecvACK.MaxCfgNum
            if (r0 < r10) goto L_0x0038
            goto L_0x0054
        L_0x0038:
            r10 = 0
            r11 = 0
        L_0x003a:
            if (r10 < r8) goto L_0x0042
            if (r11 != r8) goto L_0x003f
            goto L_0x0055
        L_0x003f:
            int r0 = r0 + 1
            goto L_0x0033
        L_0x0042:
            int r12 = r10 + 3
            byte r12 = r2[r12]
            byte[][] r13 = com.realtek.simpleconfiglib.SCParam.RecvACK.Mac
            r13 = r13[r0]
            byte r13 = r13[r10]
            if (r12 != r13) goto L_0x0050
            int r11 = r11 + 1
        L_0x0050:
            int r10 = r10 + 1
            goto L_0x003a
        L_0x0053:
            r0 = 0
        L_0x0054:
            r11 = 0
        L_0x0055:
            r10 = 4
            byte[] r12 = new byte[r10]
            r13 = 12
            java.lang.System.arraycopy(r2, r13, r12, r9, r10)
            java.lang.Object[] r14 = new java.lang.Object[r10]
            byte r15 = r12[r9]
            r15 = r15 & 255(0xff, float:3.57E-43)
            java.lang.Integer r15 = java.lang.Integer.valueOf(r15)
            r14[r9] = r15
            byte r15 = r12[r3]
            r15 = r15 & 255(0xff, float:3.57E-43)
            java.lang.Integer r15 = java.lang.Integer.valueOf(r15)
            r14[r3] = r15
            byte r15 = r12[r4]
            r15 = r15 & 255(0xff, float:3.57E-43)
            java.lang.Integer r15 = java.lang.Integer.valueOf(r15)
            r14[r4] = r15
            r15 = 3
            byte r12 = r12[r15]
            r12 = r12 & 255(0xff, float:3.57E-43)
            java.lang.Integer r12 = java.lang.Integer.valueOf(r12)
            r14[r15] = r12
            java.lang.String r12 = "%d.%d.%d.%d"
            java.lang.String r14 = java.lang.String.format(r12, r14)
            java.lang.String[] r16 = com.realtek.simpleconfiglib.SCParam.RecvACK.IP
            r16 = r16[r0]
            java.lang.String r6 = "%02x"
            if (r16 == 0) goto L_0x0173
            java.lang.String[] r16 = com.realtek.simpleconfiglib.SCParam.RecvACK.IP
            r16 = r16[r0]
            int r16 = r16.length()
            if (r16 <= 0) goto L_0x0173
            java.lang.String[] r16 = com.realtek.simpleconfiglib.SCParam.RecvACK.IP
            r4 = r16[r0]
            boolean r4 = r4.equals(r14)
            if (r4 != 0) goto L_0x0173
            byte[][] r4 = com.realtek.simpleconfiglib.SCParam.RecvACK.Mac
            r4 = r4[r0]
            java.lang.System.arraycopy(r2, r15, r4, r9, r8)
            java.lang.String r4 = new java.lang.String
            r4.<init>()
            r14 = r4
            r4 = 0
        L_0x00b8:
            if (r4 < r8) goto L_0x0134
            byte[][] r4 = com.realtek.simpleconfiglib.SCParam.RecvACK.IPBuf
            r4 = r4[r0]
            java.lang.System.arraycopy(r2, r13, r4, r9, r10)
            java.lang.String[] r4 = com.realtek.simpleconfiglib.SCParam.RecvACK.IP
            java.lang.Object[] r13 = new java.lang.Object[r10]
            byte[][] r19 = com.realtek.simpleconfiglib.SCParam.RecvACK.IPBuf
            r19 = r19[r0]
            byte r10 = r19[r9]
            r10 = r10 & 255(0xff, float:3.57E-43)
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)
            r13[r9] = r10
            byte[][] r10 = com.realtek.simpleconfiglib.SCParam.RecvACK.IPBuf
            r10 = r10[r0]
            byte r10 = r10[r3]
            r10 = r10 & 255(0xff, float:3.57E-43)
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)
            r13[r3] = r10
            byte[][] r10 = com.realtek.simpleconfiglib.SCParam.RecvACK.IPBuf
            r10 = r10[r0]
            r17 = 2
            byte r10 = r10[r17]
            r10 = r10 & 255(0xff, float:3.57E-43)
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)
            r13[r17] = r10
            byte[][] r10 = com.realtek.simpleconfiglib.SCParam.RecvACK.IPBuf
            r10 = r10[r0]
            byte r10 = r10[r15]
            r10 = r10 & 255(0xff, float:3.57E-43)
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)
            r13[r15] = r10
            java.lang.String r10 = java.lang.String.format(r12, r13)
            r4[r0] = r10
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            java.lang.String r10 = "Refresh IP: "
            r4.<init>(r10)
            java.lang.String[] r10 = com.realtek.simpleconfiglib.SCParam.RecvACK.IP
            r0 = r10[r0]
            r4.append(r0)
            java.lang.String r0 = " of MAC: "
            r4.append(r0)
            r4.append(r14)
            java.lang.String r0 = r4.toString()
            android.util.Log.i(r7, r0)
            r20.rtk_sc_send_cfg_ack_packet()
            android.os.Message r0 = android.os.Message.obtain()
            r4 = 0
            r0.obj = r4
            r0.what = r9
            android.os.Handler r4 = r1.TreadMsgHandler
            r4.sendMessage(r0)
            goto L_0x0173
        L_0x0134:
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            java.lang.String r13 = java.lang.String.valueOf(r14)
            r10.<init>(r13)
            java.lang.Object[] r13 = new java.lang.Object[r3]
            byte[][] r14 = com.realtek.simpleconfiglib.SCParam.RecvACK.Mac
            r14 = r14[r0]
            byte r14 = r14[r4]
            java.lang.Byte r14 = java.lang.Byte.valueOf(r14)
            r13[r9] = r14
            java.lang.String r13 = java.lang.String.format(r6, r13)
            r10.append(r13)
            java.lang.String r10 = r10.toString()
            r13 = 5
            if (r4 >= r13) goto L_0x016b
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            java.lang.String r10 = java.lang.String.valueOf(r10)
            r13.<init>(r10)
            java.lang.String r10 = ":"
            r13.append(r10)
            java.lang.String r10 = r13.toString()
        L_0x016b:
            r14 = r10
            int r4 = r4 + 1
            r10 = 4
            r13 = 12
            goto L_0x00b8
        L_0x0173:
            int r0 = com.realtek.simpleconfiglib.SCParam.RecvACK.MaxCfgNum
            if (r0 <= 0) goto L_0x0178
            return r9
        L_0x0178:
            if (r11 != r8) goto L_0x017b
            return r9
        L_0x017b:
            byte[][] r0 = com.realtek.simpleconfiglib.SCParam.RecvACK.Mac
            int r4 = com.realtek.simpleconfiglib.SCParam.RecvACK.MaxCfgNum
            r0 = r0[r4]
            java.lang.System.arraycopy(r2, r15, r0, r9, r8)
            java.lang.String r0 = new java.lang.String
            r0.<init>()
            r4 = r0
            r0 = 0
        L_0x018b:
            if (r0 < r8) goto L_0x02b5
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r6 = "Added MAC: "
            r0.<init>(r6)
            r0.append(r4)
            java.lang.String r0 = r0.toString()
            android.util.Log.i(r7, r0)
            r0 = 7
            if (r5 < r0) goto L_0x01ab
            byte[] r0 = com.realtek.simpleconfiglib.SCParam.RecvACK.Status
            int r4 = com.realtek.simpleconfiglib.SCParam.RecvACK.MaxCfgNum
            r6 = 9
            byte r6 = r2[r6]
            r0[r4] = r6
        L_0x01ab:
            r0 = 9
            if (r5 < r0) goto L_0x01bb
            r0 = 10
            byte[][] r4 = com.realtek.simpleconfiglib.SCParam.RecvACK.Type
            int r6 = com.realtek.simpleconfiglib.SCParam.RecvACK.MaxCfgNum
            r4 = r4[r6]
            r6 = 2
            java.lang.System.arraycopy(r2, r0, r4, r9, r6)
        L_0x01bb:
            r10 = 13
            if (r5 < r10) goto L_0x0232
            byte[][] r0 = com.realtek.simpleconfiglib.SCParam.RecvACK.IPBuf
            int r4 = com.realtek.simpleconfiglib.SCParam.RecvACK.MaxCfgNum
            r0 = r0[r4]
            r11 = 12
            r13 = 4
            java.lang.System.arraycopy(r2, r11, r0, r9, r13)
            java.lang.String[] r0 = com.realtek.simpleconfiglib.SCParam.RecvACK.IP
            int r4 = com.realtek.simpleconfiglib.SCParam.RecvACK.MaxCfgNum
            java.lang.Object[] r6 = new java.lang.Object[r13]
            byte[][] r8 = com.realtek.simpleconfiglib.SCParam.RecvACK.IPBuf
            int r10 = com.realtek.simpleconfiglib.SCParam.RecvACK.MaxCfgNum
            r8 = r8[r10]
            byte r8 = r8[r9]
            r8 = r8 & 255(0xff, float:3.57E-43)
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)
            r6[r9] = r8
            byte[][] r8 = com.realtek.simpleconfiglib.SCParam.RecvACK.IPBuf
            int r10 = com.realtek.simpleconfiglib.SCParam.RecvACK.MaxCfgNum
            r8 = r8[r10]
            byte r8 = r8[r3]
            r8 = r8 & 255(0xff, float:3.57E-43)
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)
            r6[r3] = r8
            byte[][] r8 = com.realtek.simpleconfiglib.SCParam.RecvACK.IPBuf
            int r10 = com.realtek.simpleconfiglib.SCParam.RecvACK.MaxCfgNum
            r8 = r8[r10]
            r14 = 2
            byte r8 = r8[r14]
            r8 = r8 & 255(0xff, float:3.57E-43)
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)
            r6[r14] = r8
            byte[][] r8 = com.realtek.simpleconfiglib.SCParam.RecvACK.IPBuf
            int r10 = com.realtek.simpleconfiglib.SCParam.RecvACK.MaxCfgNum
            r8 = r8[r10]
            byte r8 = r8[r15]
            r8 = r8 & 255(0xff, float:3.57E-43)
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)
            r6[r15] = r8
            java.lang.String r6 = java.lang.String.format(r12, r6)
            r0[r4] = r6
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r4 = "IP: "
            r0.<init>(r4)
            java.lang.String[] r4 = com.realtek.simpleconfiglib.SCParam.RecvACK.IP
            int r6 = com.realtek.simpleconfiglib.SCParam.RecvACK.MaxCfgNum
            r4 = r4[r6]
            r0.append(r4)
            java.lang.String r0 = r0.toString()
            android.util.Log.i(r7, r0)
            r20.rtk_sc_send_cfg_ack_packet()
        L_0x0232:
            r0 = 77
            if (r5 < r0) goto L_0x028a
            r0 = 16
            byte[][] r4 = com.realtek.simpleconfiglib.SCParam.RecvACK.NameBuf
            int r6 = com.realtek.simpleconfiglib.SCParam.RecvACK.MaxCfgNum
            r4 = r4[r6]
            r6 = 64
            java.lang.System.arraycopy(r2, r0, r4, r9, r6)
            java.lang.String r0 = new java.lang.String     // Catch:{ UnsupportedEncodingException -> 0x0255 }
            byte[][] r4 = com.realtek.simpleconfiglib.SCParam.RecvACK.NameBuf     // Catch:{ UnsupportedEncodingException -> 0x0255 }
            int r6 = com.realtek.simpleconfiglib.SCParam.RecvACK.MaxCfgNum     // Catch:{ UnsupportedEncodingException -> 0x0255 }
            r4 = r4[r6]     // Catch:{ UnsupportedEncodingException -> 0x0255 }
            java.lang.String r6 = "UTF-8"
            r0.<init>(r4, r6)     // Catch:{ UnsupportedEncodingException -> 0x0255 }
            java.lang.String r4 = r0.trim()     // Catch:{ UnsupportedEncodingException -> 0x0255 }
            goto L_0x025f
        L_0x0255:
            r0 = move-exception
            java.lang.String r4 = "Get device's name error"
            android.util.Log.e(r7, r4)
            r0.printStackTrace()
            r4 = 0
        L_0x025f:
            int r0 = r4.length()
            if (r0 <= 0) goto L_0x026c
            java.lang.String[] r0 = com.realtek.simpleconfiglib.SCParam.RecvACK.Name
            int r6 = com.realtek.simpleconfiglib.SCParam.RecvACK.MaxCfgNum
            r0[r6] = r4
            goto L_0x0273
        L_0x026c:
            java.lang.String[] r0 = com.realtek.simpleconfiglib.SCParam.RecvACK.Name
            int r4 = com.realtek.simpleconfiglib.SCParam.RecvACK.MaxCfgNum
            r6 = 0
            r0[r4] = r6
        L_0x0273:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r4 = "Name: "
            r0.<init>(r4)
            java.lang.String[] r4 = com.realtek.simpleconfiglib.SCParam.RecvACK.Name
            int r6 = com.realtek.simpleconfiglib.SCParam.RecvACK.MaxCfgNum
            r4 = r4[r6]
            r0.append(r4)
            java.lang.String r0 = r0.toString()
            android.util.Log.i(r7, r0)
        L_0x028a:
            r0 = 78
            if (r5 < r0) goto L_0x02a1
            java.lang.Boolean[] r0 = com.realtek.simpleconfiglib.SCParam.RecvACK.UsePin
            int r4 = com.realtek.simpleconfiglib.SCParam.RecvACK.MaxCfgNum
            r5 = 80
            byte r2 = r2[r5]
            if (r2 <= 0) goto L_0x029a
            r2 = 1
            goto L_0x029b
        L_0x029a:
            r2 = 0
        L_0x029b:
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)
            r0[r4] = r2
        L_0x02a1:
            int r0 = com.realtek.simpleconfiglib.SCParam.RecvACK.MaxCfgNum
            int r0 = r0 + r3
            com.realtek.simpleconfiglib.SCParam.RecvACK.MaxCfgNum = r0
            android.os.Message r0 = android.os.Message.obtain()
            r2 = 0
            r0.obj = r2
            r0.what = r9
            android.os.Handler r2 = r1.TreadMsgHandler
            r2.sendMessage(r0)
            return r9
        L_0x02b5:
            r10 = 13
            r11 = 12
            r13 = 4
            r14 = 2
            r16 = 0
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            java.lang.String r4 = java.lang.String.valueOf(r4)
            r8.<init>(r4)
            java.lang.Object[] r4 = new java.lang.Object[r3]
            byte[][] r17 = com.realtek.simpleconfiglib.SCParam.RecvACK.Mac
            int r18 = com.realtek.simpleconfiglib.SCParam.RecvACK.MaxCfgNum
            r17 = r17[r18]
            byte r17 = r17[r0]
            java.lang.Byte r17 = java.lang.Byte.valueOf(r17)
            r4[r9] = r17
            java.lang.String r4 = java.lang.String.format(r6, r4)
            r8.append(r4)
            java.lang.String r4 = r8.toString()
            r8 = 5
            if (r0 >= r8) goto L_0x02f7
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = java.lang.String.valueOf(r4)
            r3.<init>(r4)
            java.lang.String r4 = ":"
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            r4 = r3
        L_0x02f7:
            int r0 = r0 + 1
            r3 = 1
            r8 = 6
            goto L_0x018b
        */
        throw new UnsupportedOperationException("Method not decompiled: com.realtek.simpleconfiglib.SCLibrary.HandleCfgACK(byte[]):int");
    }

    public void rtk_sc_send_cfg_ack_packet() {
        byte[] bArr = new byte[92];
        Arrays.fill(bArr, (byte) 0);
        bArr[0] = (byte) (bArr[0] + 0);
        bArr[0] = (byte) (bArr[0] + 0);
        bArr[0] = (byte) (bArr[0] + 4);
        bArr[1] = 0;
        bArr[2] = 90;
        bArr[3] = 0;
        if (SCParam.RecvACK.IP[0] != null && SCParam.RecvACK.IP[0].length() > 0 && !SCParam.RecvACK.IP[0].equals("0.0.0.0")) {
            SCParam.UDPUcast.IPAddr = SCParam.RecvACK.IP[0];
            SCParam.UDPUcast.SendLen = bArr.length;
            SCParam.UDPUcast.SendMsg = bArr;
            for (int i = 0; i < 8; i++) {
                this.SCNetOps.UDPUnicastSend();
            }
        }
        SCParam.UDPBcast.IPAddr = "255.255.255.255";
        SCParam.UDPBcast.SendLen = bArr.length;
        SCParam.UDPBcast.SendMsg = bArr;
        for (int i2 = 0; i2 < 8; i2++) {
            this.SCNetOps.UDPBroadcastSend();
        }
    }

    /* access modifiers changed from: private */
    public int RtkSCParseResult() {
        int i = SCParam.UDPUcast.RecvLen;
        byte[] bArr = new byte[i];
        System.arraycopy(SCParam.UDPUcast.RecvBuf, 0, bArr, 0, i);
        if (i < 9) {
            Log.e(TAG, "ACK too short\n");
            return -1;
        }
        byte b = bArr[0];
        if (((SCParam.BIT(7) | SCParam.BIT(6)) & b) != 0) {
            Log.e(TAG, "ACK version not match\n");
            return -1;
        } else if ((SCParam.BIT(5) & b) != 32) {
            return -1;
        } else {
            Message obtain = Message.obtain();
            byte b2 = b & 31;
            if (b2 != 0) {
                if (b2 == 1) {
                    obtain.obj = bArr;
                    obtain.what = 1;
                    this.TreadMsgHandler.sendMessage(obtain);
                } else if (b2 == 2) {
                    obtain.obj = bArr;
                    obtain.what = 2;
                    this.TreadMsgHandler.sendMessage(obtain);
                } else if (b2 == 3) {
                    obtain.obj = bArr;
                    obtain.what = 3;
                    this.TreadMsgHandler.sendMessage(obtain);
                } else if (b2 != 4) {
                    Log.e(TAG, "Unknow response");
                } else {
                    obtain.obj = bArr;
                    obtain.what = 4;
                    this.TreadMsgHandler.sendMessage(obtain);
                }
                return 0;
            }
            this.SendEnable = false;
            this.ConfigSuccess = true;
            this.ScJni.StopConfig();
            return HandleCfgACK(bArr);
        }
    }

    public void RtkSCRecvThread() {
        this.RecvEnable = true;
        this.RecvThread = new Thread(new Runnable() {
            public void run() {
                while (SCLibrary.this.RecvEnable) {
                    boolean z = false;
                    try {
                        z = SCLibrary.this.SCNetOps.UDPUnicastRecv();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    if (z) {
                        try {
                            int unused = SCLibrary.this.RtkSCParseResult();
                        } catch (Exception e2) {
                            e2.printStackTrace();
                            Log.e(SCLibrary.TAG, "Parse Result Error");
                            return;
                        }
                    }
                }
            }
        });
        this.RecvThread.start();
    }

    public int rtk_sc_get_connected_sta_num() {
        return SCParam.RecvACK.MaxCfgNum;
    }

    public int rtk_sc_get_connected_sta_info(List<HashMap<String, Object>> list) {
        for (int i = 0; i < SCParam.RecvACK.MaxCfgNum; i++) {
            String str = new String();
            HashMap hashMap = new HashMap();
            String str2 = str;
            for (int i2 = 0; i2 < 6; i2++) {
                str2 = String.valueOf(str2) + String.format("%02x", new Object[]{Byte.valueOf(SCParam.RecvACK.Mac[i][i2])});
                if (i2 < 5) {
                    str2 = String.valueOf(str2) + ":";
                }
            }
            hashMap.put("MAC", str2);
            new String();
            byte b = SCParam.RecvACK.Status[i];
            hashMap.put("Status", b != 1 ? b != 2 ? "Unkown status" : "Profile saved" : "Connected");
            new String();
            short s = (short) ((SCParam.RecvACK.Type[i][0] & 65280) + (SCParam.RecvACK.Type[i][1] & 255));
            hashMap.put("Type", s != 0 ? s != 1 ? s != 2 ? "Unkown type" : "Air conditioner" : "TV" : "Any type");
            hashMap.put("IP", SCParam.RecvACK.IP[i]);
            hashMap.put("Name", SCParam.RecvACK.Name[i]);
            hashMap.put("PIN", SCParam.RecvACK.UsePin[i]);
            list.add(hashMap);
        }
        return 0;
    }

    public int rtk_sc_send_discover_packet(byte[] bArr, String str) {
        try {
            SCParam.UDPBcast.IPAddr = str;
            SCParam.UDPBcast.SendLen = bArr.length;
            SCParam.UDPBcast.SendMsg = bArr;
            this.SCNetOps.UDPBroadcastSend();
            return 0;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int rtk_sc_send_control_packet(byte[] bArr, String str) {
        try {
            SCParam.UDPUcast.IPAddr = str;
            SCParam.UDPUcast.SendLen = bArr.length;
            SCParam.UDPUcast.SendMsg = bArr;
            this.SCNetOps.UDPUnicastSend();
            return 0;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public void rtk_sc_set_packet_type(boolean z) {
        SCParam.SC_PKT_TYPE = z;
    }

    public void rtk_sc_set_softap(boolean z) {
        SCParam.SC_SOFTAP_MODE = z;
    }

    public String rtk_sc_get_softap_ssid() {
        return this.SCNetOps.getWifiApSSID();
    }
}
