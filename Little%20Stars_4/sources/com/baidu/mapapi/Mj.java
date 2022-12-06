package com.baidu.mapapi;

import android.content.Context;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Proxy;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.telephony.NeighboringCellInfo;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;
import com.baidu.mapapi.cloud.GeoSearchListener;
import com.baidu.mapapi.cloud.c;
import java.io.File;
import java.lang.reflect.Method;
import java.net.ServerSocket;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Mj {
    private static b V = null;
    private static Method W = null;
    private static Method X = null;
    private static Class<?> Y = null;
    static f a;
    static final MKLocationManager b = new MKLocationManager();
    static int c = 2;
    static MapView d = null;
    static Context e = null;
    static ServerSocket f = null;
    static int g = 0;
    static int h = 0;
    static int i = 0;
    static float j = 1.0f;
    static String k = "";
    public static int l = 0;
    public static int m = 0;
    public static int n = 0;
    public static int o = 0;
    public static int p = 0;
    static boolean q;
    static boolean r;
    static int s = -1;
    private static Handler t = null;
    private static String u = "";
    private static String v = "";
    private static String w = "";
    private static String x = "";
    private j A = null;
    private j B = null;
    private j C = null;
    private j D = null;
    private c E = null;
    private String F;
    private String G;
    private String H;
    private final long I = 3;
    private final long J = 3;
    private List<NeighboringCellInfo> K = null;
    private long L = 0;
    private long M = 0;
    private int N = 0;
    private int O = 0;
    private int P = 0;
    private int Q = 0;
    private int R = 0;
    private int S = 0;
    private List<ScanResult> T = null;
    private List<ScanResult> U = null;
    /* access modifiers changed from: private */
    public Handler Z = new Handler();
    private ArrayList<b> aa = new ArrayList<>();
    private TelephonyManager y = null;
    private WifiManager z = null;

    class a {
        int a = 0;
        int b;
        int c;
        int d;

        a() {
        }
    }

    private class b implements Runnable {
        public int a;
        public int b;

        private b() {
        }

        public void run() {
            Mj.MsgMapProc(1, 8, this.a, 0);
            Mj.this.Z.postDelayed(this, (long) this.b);
        }
    }

    static {
        try {
            System.loadLibrary("BMapApiEngine_v1_3_5");
        } catch (UnsatisfiedLinkError e2) {
            Log.d("BMapApiEngine_v1_3_5", "BMapApiEngine_v1_3_5 library not found!");
            Log.d("BMapApiEngine_v1_3_5", e2.getLocalizedMessage());
        }
    }

    Mj(BMapManager bMapManager, Context context) {
        e = context;
        e();
    }

    public static native String AppendRecord(String str, String str2);

    public static native int DisableProviderCC(int i2);

    public static native int EnableProviderCC(int i2);

    public static native Bundle GetGPSStatus();

    public static native Bundle GetMapStatus();

    public static native Bundle GetNotifyInternal();

    public static native int InitLocationCC();

    public static native int InitMapControlCC(int i2, int i3);

    public static native int MapProc(int i2, int i3, int i4);

    public static native int MsgMapProc(int i2, int i3, int i4, int i5);

    public static native void SetCellData(int i2, int i3, int i4, int i5, String str, String str2, String str3);

    public static native void SetCellInfo(int i2, int i3, int i4, int i5, String str);

    public static native void SetLocationCoordinateType(int i2);

    public static native int SetNotifyInternal(int i2, int i3);

    public static native int SetProxyInfo(String str, int i2);

    public static native void SetUpdateWifi(String str);

    public static native void UpdataGPS(double d2, double d3, float f2, float f3, float f4, int i2);

    private static String a(NetworkInfo networkInfo) {
        if (networkInfo != null) {
            return networkInfo.getExtraInfo();
        }
        return null;
    }

    private void a(int i2) {
        for (int i3 = 0; i3 < this.aa.size(); i3++) {
            b bVar = this.aa.get(i3);
            if (bVar.a == i2) {
                if (BMapManager.c) {
                    this.Z.removeCallbacks(bVar);
                }
                this.aa.remove(i3);
                return;
            }
        }
    }

    private void a(int i2, int i3) {
        Iterator<b> it = this.aa.iterator();
        while (it.hasNext()) {
            if (it.next().a == i2) {
                return;
            }
        }
        b bVar = new b();
        bVar.a = i2;
        bVar.b = i3;
        if (BMapManager.c) {
            this.Z.postDelayed(bVar, 500);
        }
        this.aa.add(bVar);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0055, code lost:
        if (r1 == -1) goto L_0x0075;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0073, code lost:
        if (r1 == -1) goto L_0x0075;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0075, code lost:
        r1 = 80;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0077, code lost:
        SetProxyInfo(r0, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void changeGprsConnect() {
        /*
            android.content.Context r0 = e
            java.lang.String r1 = "connectivity"
            java.lang.Object r0 = r0.getSystemService(r1)
            android.net.ConnectivityManager r0 = (android.net.ConnectivityManager) r0
            android.net.NetworkInfo r0 = r0.getActiveNetworkInfo()
            if (r0 == 0) goto L_0x007a
            boolean r1 = r0.isAvailable()
            if (r1 == 0) goto L_0x007a
            java.lang.String r1 = r0.getTypeName()
            java.lang.String r1 = r1.toLowerCase()
            java.lang.String r2 = "wifi"
            boolean r1 = r1.equals(r2)
            r2 = 80
            java.lang.String r3 = "10.0.0.172"
            r4 = -1
            java.lang.String r5 = "wap"
            r6 = 0
            r7 = 0
            if (r1 == 0) goto L_0x0058
            r1 = 1
            int r8 = s
            if (r1 != r8) goto L_0x0038
        L_0x0034:
            SetProxyInfo(r7, r6)
            goto L_0x007a
        L_0x0038:
            if (r8 != 0) goto L_0x007a
            java.lang.String r0 = a((android.net.NetworkInfo) r0)
            if (r0 == 0) goto L_0x007a
            java.lang.String r0 = r0.toLowerCase()
            boolean r0 = r0.contains(r5)
            if (r0 == 0) goto L_0x0034
            java.lang.String r0 = android.net.Proxy.getDefaultHost()
            int r1 = android.net.Proxy.getDefaultPort()
            if (r0 != 0) goto L_0x0055
            r0 = r3
        L_0x0055:
            if (r1 != r4) goto L_0x0077
            goto L_0x0075
        L_0x0058:
            java.lang.String r0 = r0.getExtraInfo()
            if (r0 == 0) goto L_0x007a
            java.lang.String r0 = r0.toLowerCase()
            boolean r0 = r0.contains(r5)
            if (r0 == 0) goto L_0x0034
            java.lang.String r0 = android.net.Proxy.getDefaultHost()
            int r1 = android.net.Proxy.getDefaultPort()
            if (r0 != 0) goto L_0x0073
            r0 = r3
        L_0x0073:
            if (r1 != r4) goto L_0x0077
        L_0x0075:
            r1 = 80
        L_0x0077:
            SetProxyInfo(r0, r1)
        L_0x007a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mapapi.Mj.changeGprsConnect():void");
    }

    private int d() {
        try {
            Y = Class.forName("android.telephony.cdma.CdmaCellLocation");
            W = Y.getMethod("getBaseStationId", new Class[0]);
            X = Y.getMethod("getNetworkId", new Class[0]);
            return 0;
        } catch (Exception e2) {
            e2.printStackTrace();
            return -1;
        }
    }

    private void e() {
        Context context = e;
        if (context != null) {
            File filesDir = context.getFilesDir();
            if (filesDir != null) {
                x = filesDir.getAbsolutePath();
            }
            if (this.y == null) {
                this.y = (TelephonyManager) e.getSystemService("phone");
            }
            TelephonyManager telephonyManager = this.y;
            if (telephonyManager != null) {
                k = telephonyManager.getDeviceId();
                u = this.y.getSubscriberId();
                v = Build.MODEL;
                w = Build.VERSION.SDK;
            }
            WindowManager windowManager = (WindowManager) e.getSystemService("window");
            DisplayMetrics displayMetrics = new DisplayMetrics();
            if (windowManager != null) {
                Display defaultDisplay = windowManager.getDefaultDisplay();
                g = defaultDisplay.getWidth();
                h = defaultDisplay.getHeight();
                defaultDisplay.getMetrics(displayMetrics);
            }
            j = displayMetrics.density;
            if (Integer.parseInt(Build.VERSION.SDK) > 3) {
                try {
                    i = Class.forName("android.util.DisplayMetrics").getField("densityDpi").getInt(displayMetrics);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                this.G = e.getPackageManager().getPackageInfo(e.getPackageName(), 0).applicationInfo.loadLabel(e.getPackageManager()).toString();
                this.H = e.getPackageName();
            }
            i = 160;
            try {
                this.G = e.getPackageManager().getPackageInfo(e.getPackageName(), 0).applicationInfo.loadLabel(e.getPackageManager()).toString();
                this.H = e.getPackageName();
            } catch (Exception e3) {
                Log.d("baidumap", e3.getMessage());
                this.G = null;
            }
        }
    }

    private static void f() {
        String g2 = g();
        if (g2 == null || !g2.toLowerCase().contains("wap")) {
            SetProxyInfo((String) null, 0);
            return;
        }
        String defaultHost = Proxy.getDefaultHost();
        int defaultPort = Proxy.getDefaultPort();
        if (defaultHost == null) {
            defaultHost = "10.0.0.172";
        }
        if (defaultPort == -1) {
            defaultPort = 80;
        }
        SetProxyInfo(defaultHost, defaultPort);
    }

    private static String g() {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) e.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo != null && activeNetworkInfo.isAvailable()) {
            if (!activeNetworkInfo.getTypeName().toLowerCase().equals("wifi")) {
                return activeNetworkInfo.getExtraInfo();
            }
            int i2 = s;
            if (1 != i2 && i2 == 0) {
                return a(activeNetworkInfo);
            }
        }
        return null;
    }

    public static native Bundle getNewBundle(int i2, int i3, int i4);

    public static native int initOfflineCC();

    public static native int initSearchCC();

    public static native void nativeDone();

    public static native void nativeInit();

    public static native void nativeRender();

    public static native void nativeResize(int i2, int i3);

    public static native void renderBaiduMap(Bitmap bitmap);

    public static native void renderCalDisScreenPos(Bundle bundle);

    public static native void renderFlsScreenPos(Bundle bundle);

    public static native void renderUpdateScreen(short[] sArr, int i2, int i3);

    public static native int sendBundle(Bundle bundle);

    public static native void sendPhoneInfo(Bundle bundle);

    public native int InitMapApiEngine();

    public void JNI_MapcallBackProc(int i2, int i3, int i4, int i5) {
        a aVar = new a();
        aVar.a = i2;
        aVar.b = i3;
        aVar.c = i4;
        aVar.d = i5;
        Message obtainMessage = t.obtainMessage(1, 1, 1, aVar);
        if (obtainMessage != null) {
            t.sendMessage(obtainMessage);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:35:0x007a, code lost:
        if (r3.A == null) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x007c, code lost:
        r0 = new com.baidu.mapapi.MKEvent(r4 - 10000, r5, r6);
        r4 = r3.A;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0090, code lost:
        if (r3.B == null) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x0092, code lost:
        r0 = new com.baidu.mapapi.MKEvent(r4 - 10000, r5, r6);
        r4 = r3.B;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x009b, code lost:
        r4.a(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void JNI_callBackProc(int r4, int r5, int r6) {
        /*
            r3 = this;
            r0 = 9
            if (r4 == r0) goto L_0x00c1
            r0 = 5000(0x1388, float:7.006E-42)
            if (r4 == r0) goto L_0x00b8
            r0 = 505(0x1f9, float:7.08E-43)
            if (r4 == r0) goto L_0x00c1
            r0 = 506(0x1fa, float:7.09E-43)
            if (r4 == r0) goto L_0x00b4
            r0 = 511(0x1ff, float:7.16E-43)
            if (r4 == r0) goto L_0x00b0
            r0 = 512(0x200, float:7.175E-43)
            if (r4 == r0) goto L_0x00ac
            r0 = 10504(0x2908, float:1.4719E-41)
            if (r4 == r0) goto L_0x009f
            r0 = 10505(0x2909, float:1.472E-41)
            if (r4 == r0) goto L_0x009f
            switch(r4) {
                case 10001: goto L_0x008e;
                case 10002: goto L_0x008e;
                case 10003: goto L_0x008e;
                case 10004: goto L_0x008e;
                case 10005: goto L_0x0086;
                case 10006: goto L_0x008e;
                case 10007: goto L_0x0078;
                default: goto L_0x0023;
            }
        L_0x0023:
            switch(r4) {
                case 10009: goto L_0x0078;
                case 10010: goto L_0x008e;
                case 10011: goto L_0x008e;
                case 10012: goto L_0x008e;
                case 10013: goto L_0x0069;
                case 10014: goto L_0x0028;
                case 10015: goto L_0x008e;
                case 10016: goto L_0x008e;
                case 10017: goto L_0x008e;
                case 10018: goto L_0x008e;
                default: goto L_0x0026;
            }
        L_0x0026:
            goto L_0x00c8
        L_0x0028:
            com.baidu.mapapi.MapView r0 = d
            if (r0 == 0) goto L_0x0031
            r1 = 8020(0x1f54, float:1.1238E-41)
            r0.a((int) r1, (int) r5, (int) r6)
        L_0x0031:
            com.baidu.mapapi.j r0 = r3.D
            if (r0 == 0) goto L_0x00c8
            int r0 = l
            int r1 = n
            int r0 = r0 - r1
            int r0 = java.lang.Math.abs(r0)
            r1 = 2
            if (r0 > r1) goto L_0x0051
            int r0 = m
            int r2 = o
            int r0 = r0 - r2
            int r0 = java.lang.Math.abs(r0)
            if (r0 > r1) goto L_0x0051
            r0 = 1
            int r1 = p
            if (r0 != r1) goto L_0x005d
        L_0x0051:
            com.baidu.mapapi.MKEvent r0 = new com.baidu.mapapi.MKEvent
            int r4 = r4 + -10000
            r0.<init>(r4, r5, r6)
            com.baidu.mapapi.j r4 = r3.D
            r4.a(r0)
        L_0x005d:
            r4 = 0
            l = r4
            m = r4
            o = r4
            n = r4
            p = r4
            goto L_0x00c8
        L_0x0069:
            com.baidu.mapapi.j r4 = r3.C
            if (r4 == 0) goto L_0x00c8
            com.baidu.mapapi.MKEvent r4 = new com.baidu.mapapi.MKEvent
            r4.<init>(r5, r5, r6)
            com.baidu.mapapi.j r5 = r3.C
            r5.a(r4)
            goto L_0x00c8
        L_0x0078:
            com.baidu.mapapi.j r0 = r3.A
            if (r0 == 0) goto L_0x00c8
            com.baidu.mapapi.MKEvent r0 = new com.baidu.mapapi.MKEvent
            int r4 = r4 + -10000
            r0.<init>(r4, r5, r6)
            com.baidu.mapapi.j r4 = r3.A
            goto L_0x009b
        L_0x0086:
            com.baidu.mapapi.MKLocationManager r4 = b
            if (r4 == 0) goto L_0x00c8
            r4.c()
            goto L_0x00c8
        L_0x008e:
            com.baidu.mapapi.j r0 = r3.B
            if (r0 == 0) goto L_0x00c8
            com.baidu.mapapi.MKEvent r0 = new com.baidu.mapapi.MKEvent
            int r4 = r4 + -10000
            r0.<init>(r4, r5, r6)
            com.baidu.mapapi.j r4 = r3.B
        L_0x009b:
            r4.a(r0)
            goto L_0x00c8
        L_0x009f:
            com.baidu.mapapi.cloud.a r0 = new com.baidu.mapapi.cloud.a
            int r4 = r4 + -10000
            r0.<init>(r4, r5, r6)
            com.baidu.mapapi.cloud.c r4 = r3.E
            r4.a(r0)
            goto L_0x00c8
        L_0x00ac:
            r3.a((int) r5)
            goto L_0x00c8
        L_0x00b0:
            r3.a((int) r5, (int) r6)
            goto L_0x00c8
        L_0x00b4:
            r3.c()
            goto L_0x00c8
        L_0x00b8:
            com.baidu.mapapi.f r0 = a
            if (r0 == 0) goto L_0x00c8
            long r1 = (long) r6
            r0.a(r4, r5, r1)
            goto L_0x00c8
        L_0x00c1:
            com.baidu.mapapi.MapView r0 = d
            if (r0 == 0) goto L_0x00c8
            r0.a((int) r4, (int) r5, (int) r6)
        L_0x00c8:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mapapi.Mj.JNI_callBackProc(int, int, int):void");
    }

    public Bundle J_GetDevInfo(int i2) {
        String str;
        String str2;
        Bundle bundle = new Bundle();
        if (i2 == 1) {
            str = k;
            str2 = "im";
        } else if (i2 != 2) {
            if (i2 == 3) {
                bundle.putString("mb", v);
                bundle.putString("os", "Android_" + w);
                bundle.putInt("cx", g);
                bundle.putInt("cy", h);
                bundle.putInt("xd", i);
                bundle.putInt("yd", i);
            } else if (i2 == 4) {
                str = x;
                str2 = "na";
            }
            return bundle;
        } else {
            str = u;
            str2 = "is";
        }
        bundle.putString(str2, str);
        return bundle;
    }

    public native int SetCacheDirectoryCC(String str);

    public native int StartApiEngineCC(String str, String str2, String str3);

    public native int StopApiEngineCC();

    public native int UnInitMapApiEngine();

    /* access modifiers changed from: package-private */
    public void a(MKMapViewListener mKMapViewListener) {
        this.D = new i(mKMapViewListener);
    }

    /* access modifiers changed from: package-private */
    public void a(MKOfflineMapListener mKOfflineMapListener) {
        this.C = new k(mKOfflineMapListener);
    }

    /* access modifiers changed from: package-private */
    public void a(MKSearchListener mKSearchListener) {
        this.B = new m(mKSearchListener);
    }

    /* access modifiers changed from: package-private */
    public boolean a() {
        f();
        V = new b();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.wifi.STATE_CHANGE");
        intentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
        intentFilter.addAction("android.net.wifi.SCAN_RESULTS");
        e.registerReceiver(V, intentFilter, (String) null, (Handler) null);
        MKLocationManager mKLocationManager = b;
        if (mKLocationManager != null) {
            this.M = 0;
            this.U = null;
            this.S = 0;
            this.R = 0;
            mKLocationManager.a();
            UpdataGPS(0.0d, 0.0d, 0.0f, 0.0f, 0.0f, 0);
            SetCellData(0, 0, 0, 0, (String) null, (String) null, (String) null);
            if (q) {
                b.enableProvider(0);
            }
            if (r) {
                b.enableProvider(1);
            }
        }
        Iterator<b> it = this.aa.iterator();
        while (it.hasNext()) {
            this.Z.postDelayed(it.next(), 500);
        }
        if (StartApiEngineCC(this.F, this.G, this.H) != 0) {
            return true;
        }
        try {
            if (V != null) {
                e.unregisterReceiver(V);
                V = null;
            }
        } catch (Exception e2) {
            Log.d("baidumap", e2.getMessage());
            V = null;
        }
        Iterator<b> it2 = this.aa.iterator();
        while (it2.hasNext()) {
            this.Z.removeCallbacks(it2.next());
        }
        MKLocationManager mKLocationManager2 = b;
        if (mKLocationManager2 != null) {
            mKLocationManager2.b();
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public boolean a(String str, MKGeneralListener mKGeneralListener) {
        if (mKGeneralListener != null) {
            this.A = new g(mKGeneralListener);
        }
        this.F = str;
        if (a == null) {
            a = new f(e);
        }
        Context context = e;
        if (context != null) {
            if (this.y == null) {
                this.y = (TelephonyManager) context.getSystemService("phone");
            }
            if (this.z == null) {
                this.z = (WifiManager) e.getSystemService("wifi");
            }
            WifiManager wifiManager = this.z;
            if (wifiManager != null && wifiManager.isWifiEnabled()) {
                this.z.startScan();
            }
        }
        t = new Handler() {
            public void handleMessage(Message message) {
                a aVar = (a) message.obj;
                Mj.MsgMapProc(aVar.a, aVar.b, aVar.c, aVar.d);
                super.handleMessage(message);
            }
        };
        try {
            if (initClass(new Bundle(), 0) == 0 || InitMapApiEngine() == 0) {
                return false;
            }
            this.aa.clear();
            return true;
        } catch (UnsatisfiedLinkError e2) {
            e2.printStackTrace();
            return false;
        } catch (Exception e3) {
            e3.printStackTrace();
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    public boolean b() {
        try {
            if (V != null) {
                e.unregisterReceiver(V);
                V = null;
            }
        } catch (Exception e2) {
            Log.d("baidumap", e2.getMessage());
            V = null;
        }
        Iterator<b> it = this.aa.iterator();
        while (it.hasNext()) {
            this.Z.removeCallbacks(it.next());
        }
        MKLocationManager mKLocationManager = b;
        if (mKLocationManager != null) {
            mKLocationManager.b();
        }
        return StopApiEngineCC() != 0;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x016b, code lost:
        if (r0.size() > 0) goto L_0x0173;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean c() {
        /*
            r14 = this;
            com.baidu.mapapi.f r0 = a
            r1 = 0
            if (r0 != 0) goto L_0x0006
            return r1
        L_0x0006:
            android.telephony.TelephonyManager r0 = r14.y
            if (r0 != 0) goto L_0x0016
            android.content.Context r0 = e
            java.lang.String r2 = "phone"
            java.lang.Object r0 = r0.getSystemService(r2)
            android.telephony.TelephonyManager r0 = (android.telephony.TelephonyManager) r0
            r14.y = r0
        L_0x0016:
            android.telephony.TelephonyManager r0 = r14.y
            r2 = 3
            r4 = 1000(0x3e8, double:4.94E-321)
            if (r0 == 0) goto L_0x0120
            long r6 = java.lang.System.currentTimeMillis()
            long r6 = r6 / r4
            long r8 = r14.M
            long r8 = r6 - r8
            int r0 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1))
            if (r0 <= 0) goto L_0x0128
            android.telephony.TelephonyManager r0 = r14.y
            android.telephony.CellLocation r0 = r0.getCellLocation()
            r14.M = r6
            r6 = 5
            if (r0 == 0) goto L_0x0056
            boolean r7 = r0 instanceof android.telephony.gsm.GsmCellLocation
            if (r7 == 0) goto L_0x0056
            r7 = r0
            android.telephony.gsm.GsmCellLocation r7 = (android.telephony.gsm.GsmCellLocation) r7
            int r8 = r7.getCid()
            r14.Q = r8
            int r8 = r14.Q
            if (r8 >= 0) goto L_0x0049
            r14.Q = r1
        L_0x0049:
            int r7 = r7.getLac()
            r14.P = r7
            int r7 = r14.P
            if (r7 >= 0) goto L_0x00ab
            r14.P = r1
            goto L_0x00ab
        L_0x0056:
            java.lang.String r7 = android.os.Build.VERSION.SDK     // Catch:{ Exception -> 0x00a7 }
            int r7 = java.lang.Integer.parseInt(r7)     // Catch:{ Exception -> 0x00a7 }
            if (r7 < r6) goto L_0x00ab
            java.lang.Class<?> r7 = Y     // Catch:{ Exception -> 0x00a7 }
            if (r7 != 0) goto L_0x006a
            r7 = -1
            int r8 = r14.d()     // Catch:{ Exception -> 0x00a7 }
            if (r7 != r8) goto L_0x006a
            goto L_0x00ab
        L_0x006a:
            java.lang.Class<?> r7 = Y     // Catch:{ Exception -> 0x00a7 }
            boolean r7 = r7.isInstance(r0)     // Catch:{ Exception -> 0x00a7 }
            if (r7 == 0) goto L_0x00ab
            java.lang.reflect.Method r7 = W     // Catch:{ Exception -> 0x00a7 }
            java.lang.Object[] r8 = new java.lang.Object[r1]     // Catch:{ Exception -> 0x00a7 }
            java.lang.Object r7 = r7.invoke(r0, r8)     // Catch:{ Exception -> 0x00a7 }
            boolean r8 = r7 instanceof java.lang.Integer     // Catch:{ Exception -> 0x00a7 }
            if (r8 == 0) goto L_0x00ab
            java.lang.Integer r7 = (java.lang.Integer) r7     // Catch:{ Exception -> 0x00a7 }
            int r7 = r7.intValue()     // Catch:{ Exception -> 0x00a7 }
            r14.Q = r7     // Catch:{ Exception -> 0x00a7 }
            int r7 = r14.Q     // Catch:{ Exception -> 0x00a7 }
            if (r7 >= 0) goto L_0x008c
            r14.Q = r1     // Catch:{ Exception -> 0x00a7 }
        L_0x008c:
            java.lang.reflect.Method r7 = X     // Catch:{ Exception -> 0x00a7 }
            java.lang.Object[] r8 = new java.lang.Object[r1]     // Catch:{ Exception -> 0x00a7 }
            java.lang.Object r7 = r7.invoke(r0, r8)     // Catch:{ Exception -> 0x00a7 }
            boolean r8 = r7 instanceof java.lang.Integer     // Catch:{ Exception -> 0x00a7 }
            if (r8 == 0) goto L_0x00ab
            java.lang.Integer r7 = (java.lang.Integer) r7     // Catch:{ Exception -> 0x00a7 }
            int r7 = r7.intValue()     // Catch:{ Exception -> 0x00a7 }
            r14.P = r7     // Catch:{ Exception -> 0x00a7 }
            int r7 = r14.P     // Catch:{ Exception -> 0x00a7 }
            if (r7 >= 0) goto L_0x00ab
            r14.P = r1     // Catch:{ Exception -> 0x00a7 }
            goto L_0x00ab
        L_0x00a7:
            r7 = move-exception
            r7.printStackTrace()
        L_0x00ab:
            android.telephony.TelephonyManager r7 = r14.y
            java.lang.String r7 = r7.getNetworkOperator()
            if (r7 == 0) goto L_0x00f4
            int r8 = r7.length()
            if (r8 <= 0) goto L_0x00f4
            java.lang.String r8 = "null"
            boolean r8 = r8.equals(r7)
            if (r8 != 0) goto L_0x00f4
            int r8 = r7.length()     // Catch:{ NumberFormatException -> 0x00f0, Exception -> 0x00eb }
            r9 = 3
            if (r8 < r9) goto L_0x00d6
            java.lang.String r8 = r7.substring(r1, r9)     // Catch:{ NumberFormatException -> 0x00f0, Exception -> 0x00eb }
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)     // Catch:{ NumberFormatException -> 0x00f0, Exception -> 0x00eb }
            int r8 = r8.intValue()     // Catch:{ NumberFormatException -> 0x00f0, Exception -> 0x00eb }
            r14.N = r8     // Catch:{ NumberFormatException -> 0x00f0, Exception -> 0x00eb }
        L_0x00d6:
            int r8 = r7.length()     // Catch:{ NumberFormatException -> 0x00f0, Exception -> 0x00eb }
            if (r8 < r6) goto L_0x00f4
            java.lang.String r6 = r7.substring(r9, r6)     // Catch:{ NumberFormatException -> 0x00f0, Exception -> 0x00eb }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ NumberFormatException -> 0x00f0, Exception -> 0x00eb }
            int r6 = r6.intValue()     // Catch:{ NumberFormatException -> 0x00f0, Exception -> 0x00eb }
            r14.O = r6     // Catch:{ NumberFormatException -> 0x00f0, Exception -> 0x00eb }
            goto L_0x00f4
        L_0x00eb:
            r6 = move-exception
            r6.printStackTrace()
            goto L_0x00f4
        L_0x00f0:
            r6 = move-exception
            r6.printStackTrace()
        L_0x00f4:
            java.lang.Class<?> r6 = Y     // Catch:{ Exception -> 0x011b }
            if (r6 == 0) goto L_0x0128
            java.lang.Class<?> r6 = Y     // Catch:{ Exception -> 0x011b }
            boolean r6 = r6.isInstance(r0)     // Catch:{ Exception -> 0x011b }
            if (r6 == 0) goto L_0x0128
            java.lang.Class<?> r6 = Y     // Catch:{ Exception -> 0x011b }
            java.lang.String r7 = "getSystemId"
            java.lang.Class[] r8 = new java.lang.Class[r1]     // Catch:{ Exception -> 0x011b }
            java.lang.reflect.Method r6 = r6.getMethod(r7, r8)     // Catch:{ Exception -> 0x011b }
            java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch:{ Exception -> 0x011b }
            java.lang.Object r0 = r6.invoke(r0, r1)     // Catch:{ Exception -> 0x011b }
            java.lang.Integer r0 = (java.lang.Integer) r0     // Catch:{ Exception -> 0x011b }
            java.lang.Integer r0 = (java.lang.Integer) r0     // Catch:{ Exception -> 0x011b }
            int r0 = r0.intValue()     // Catch:{ Exception -> 0x011b }
            r14.O = r0     // Catch:{ Exception -> 0x011b }
            goto L_0x0128
        L_0x011b:
            r0 = move-exception
            r0.printStackTrace()
            goto L_0x0128
        L_0x0120:
            r14.Q = r1
            r14.P = r1
            r14.N = r1
            r14.O = r1
        L_0x0128:
            android.net.wifi.WifiManager r0 = r14.z
            if (r0 != 0) goto L_0x0138
            android.content.Context r0 = e
            java.lang.String r1 = "wifi"
            java.lang.Object r0 = r0.getSystemService(r1)
            android.net.wifi.WifiManager r0 = (android.net.wifi.WifiManager) r0
            r14.z = r0
        L_0x0138:
            android.net.wifi.WifiManager r0 = r14.z
            r1 = 0
            java.lang.String r6 = ""
            if (r0 == 0) goto L_0x016e
            boolean r0 = r0.isWifiEnabled()
            if (r0 == 0) goto L_0x016e
            long r7 = java.lang.System.currentTimeMillis()
            long r7 = r7 / r4
            long r4 = r14.L
            long r4 = r7 - r4
            int r0 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r0 <= 0) goto L_0x015b
            android.net.wifi.WifiManager r0 = r14.z
            r0.startScan()
            r14.T = r1
            r14.L = r7
        L_0x015b:
            android.net.wifi.WifiManager r0 = r14.z
            java.util.List r0 = r0.getScanResults()
            r14.T = r0
            java.util.List<android.net.wifi.ScanResult> r0 = r14.T
            if (r0 == 0) goto L_0x0170
            int r0 = r0.size()
            if (r0 > 0) goto L_0x0173
            goto L_0x0170
        L_0x016e:
            r14.T = r1
        L_0x0170:
            SetUpdateWifi(r6)
        L_0x0173:
            java.lang.String r13 = ""
            int r11 = r14.Q
            if (r11 <= 0) goto L_0x0195
            int r10 = r14.P
            if (r10 < 0) goto L_0x0195
            int r8 = r14.N
            if (r8 < 0) goto L_0x0195
            com.baidu.mapapi.f r7 = a
            int r9 = r14.O
            java.util.List<android.telephony.NeighboringCellInfo> r12 = r14.K
            java.lang.String r0 = r7.a(r8, r9, r10, r11, r12, r13)
            int r1 = r0.length()
            if (r1 <= 0) goto L_0x0193
            r11 = r0
            goto L_0x0197
        L_0x0193:
            r11 = r6
            goto L_0x0197
        L_0x0195:
            r11 = r6
            r0 = r13
        L_0x0197:
            java.util.List<android.net.wifi.ScanResult> r1 = r14.T
            if (r1 == 0) goto L_0x01d0
            int r1 = r1.size()
            if (r1 <= 0) goto L_0x01d0
            com.baidu.mapapi.f r1 = a
            java.util.List<android.net.wifi.ScanResult> r2 = r14.T
            r1.a((java.util.List<android.net.wifi.ScanResult>) r2)
            com.baidu.mapapi.f r1 = a
            java.util.List<android.net.wifi.ScanResult> r2 = r14.T
            java.lang.String r0 = r1.a((java.util.List<android.net.wifi.ScanResult>) r2, (java.lang.String) r0)
            int r1 = r0.length()
            if (r1 <= 0) goto L_0x01bb
            SetUpdateWifi(r0)
            r1 = r0
            goto L_0x01bc
        L_0x01bb:
            r1 = r6
        L_0x01bc:
            com.baidu.mapapi.f r2 = a
            java.util.List<android.net.wifi.ScanResult> r3 = r14.T
            java.lang.String r0 = r2.b(r3, r0)
            int r2 = r0.length()
            if (r2 <= 0) goto L_0x01cd
            r13 = r0
            r12 = r1
            goto L_0x01d2
        L_0x01cd:
            r12 = r1
            r13 = r6
            goto L_0x01d2
        L_0x01d0:
            r12 = r6
            r13 = r12
        L_0x01d2:
            int r0 = r14.S
            int r1 = r14.Q
            if (r0 != r1) goto L_0x01ea
            int r0 = r14.R
            int r1 = r14.P
            if (r0 != r1) goto L_0x01ea
            com.baidu.mapapi.f r0 = a
            java.util.List<android.net.wifi.ScanResult> r1 = r14.T
            java.util.List<android.net.wifi.ScanResult> r2 = r14.U
            boolean r0 = r0.a((java.util.List<android.net.wifi.ScanResult>) r1, (java.util.List<android.net.wifi.ScanResult>) r2)
            if (r0 != 0) goto L_0x01fd
        L_0x01ea:
            java.util.List<android.net.wifi.ScanResult> r0 = r14.T
            r14.U = r0
            int r7 = r14.Q
            r14.S = r7
            int r8 = r14.P
            r14.R = r8
            int r9 = r14.N
            int r10 = r14.O
            SetCellData(r7, r8, r9, r10, r11, r12, r13)
        L_0x01fd:
            r0 = 1
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mapapi.Mj.c():boolean");
    }

    public native int initClass(Object obj, int i2);

    public void initGeoListener(GeoSearchListener geoSearchListener) {
        this.E = new com.baidu.mapapi.cloud.b(geoSearchListener);
    }
}
