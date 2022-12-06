package com.realtek.simpleconfiglib;

public class SCJNI {
    public native void StartConfig(Args args);

    public native void StopConfig();

    public class Args {
        public byte[] BSSID;
        public byte BSSIDLen;
        public int ConfigTime;
        public byte HostIPLEN;
        public int Length;
        public byte Mode;
        public byte[] PIN;
        public byte PINLen;
        public boolean Pack_type;
        public byte PacketCnts;
        public int PacketInterval;
        public byte[] Passwd;
        public byte PasswdLen;
        public byte[] PhoneMac;
        public byte PhoneMacLen;
        public int ProfileInterval;
        public byte ProfileRounds;
        public byte[] SSID;
        public byte SSIDLen;
        public byte SyncRounds;
        public byte WifiInterfaceLEN;
        public byte[] hostIP;
        public boolean isSoftApMode;
        public byte[] wifiInterface;

        public Args() {
        }
    }
}
