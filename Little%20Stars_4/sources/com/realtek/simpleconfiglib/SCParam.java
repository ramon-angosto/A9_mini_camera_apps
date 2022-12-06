package com.realtek.simpleconfiglib;

import java.lang.reflect.Array;
import java.net.DatagramSocket;

public class SCParam {
    protected static final int BROADCAST_DPORT = 18864;
    protected static final int BROADCAST_SPORT = 18864;
    public static String Default_PIN = "57289961";
    public static final int MAX_CLIENTS_NUM = 32;
    public static final byte MODE_1 = 2;
    public static final byte MODE_2 = 3;
    public static final byte MODE_3 = 4;
    public static String SC_BSSID = new String();
    public static String SC_HOSTIP = new String();
    public static int SC_IP = 0;
    public static String SC_PASSWD = new String();
    public static String SC_PHONE_MAC_ADDR = new String();
    public static String SC_PIN = new String();
    public static boolean SC_PKT_TYPE = false;
    public static boolean SC_SOFTAP_MODE = false;
    public static String SC_SSID = new String();
    public static String SC_WIFI_Interface = new String();
    protected static final int UNICAST_DPORT = 8864;
    protected static final int UNICAST_SPORT = 8864;

    public static int BIT(int i) {
        return 1 << i;
    }

    private SCParam() {
    }

    public static class UDPBcast {
        public static DatagramSocket BcastSock;
        public static int DestPort;
        public static String IPAddr;
        public static int SendLen;
        public static byte[] SendMsg;
        public static int SrcPort;

        private UDPBcast() {
        }
    }

    public static class UDPUcast {
        public static int DestPort = 0;
        public static String IPAddr = null;
        public static final byte MIN_ACK_LENGTH = 9;
        public static byte[] RecvBuf = new byte[512];
        public static int RecvLen;
        public static int SendLen;
        public static byte[] SendMsg;
        public static int SrcPort;
        public static DatagramSocket UcastSock;

        private UDPUcast() {
        }
    }

    public static class Flag {
        public static final int CFGTimeSendBack = 5;
        public static final int CfgSuccessACK = 0;
        public static final int DelProf = 2;
        public static final int DelProfACK = 3;
        public static final int Discover = 0;
        public static final int DiscoverACK = 1;
        public static final int PackFail = 6;
        public static final int RenameDev = 3;
        public static final int RenameDevACK = 4;
        public static final int RequestFlag = 0;
        public static final int ResponseFlag = 32;
        public static final int ReturnACK = 4;
        public static final int SaveProf = 1;
        public static final int SaveProfACK = 2;
        public static final int Version = 0;

        private Flag() {
        }
    }

    public static class RecvACK {
        public static String[] IP = new String[32];
        public static byte[][] IPBuf = ((byte[][]) Array.newInstance(byte.class, new int[]{32, 4}));
        public static byte[][] Mac = ((byte[][]) Array.newInstance(byte.class, new int[]{32, 6}));
        public static int MaxCfgNum;
        public static String[] Name = new String[32];
        public static byte[][] NameBuf = ((byte[][]) Array.newInstance(byte.class, new int[]{32, 64}));
        public static byte[] Status = new byte[32];
        public static byte[][] Type = ((byte[][]) Array.newInstance(byte.class, new int[]{32, 2}));
        public static Boolean[] UsePin = new Boolean[32];

        private RecvACK() {
        }
    }
}
