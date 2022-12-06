package com.apm.insight.l;

import java.net.BindException;
import java.net.ConnectException;
import java.net.NoRouteToHostException;
import java.net.PortUnreachableException;
import java.net.ProtocolException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.HashSet;
import java.util.Set;
import javax.net.ssl.SSLException;
import org.apache.http.conn.ConnectTimeoutException;

public final class j {
    private static final Set<String> a = new HashSet();

    static {
        a.add("HeapTaskDaemon");
        a.add("ThreadPlus");
        a.add("ApiDispatcher");
        a.add("ApiLocalDispatcher");
        a.add("AsyncLoader");
        a.add("AsyncTask");
        a.add("Binder");
        a.add("PackageProcessor");
        a.add("SettingsObserver");
        a.add("WifiManager");
        a.add("JavaBridge");
        a.add("Compiler");
        a.add("Signal Catcher");
        a.add("GC");
        a.add("ReferenceQueueDaemon");
        a.add("FinalizerDaemon");
        a.add("FinalizerWatchdogDaemon");
        a.add("CookieSyncManager");
        a.add("RefQueueWorker");
        a.add("CleanupReference");
        a.add("VideoManager");
        a.add("DBHelper-AsyncOp");
        a.add("InstalledAppTracker2");
        a.add("AppData-AsyncOp");
        a.add("IdleConnectionMonitor");
        a.add("LogReaper");
        a.add("ActionReaper");
        a.add("Okio Watchdog");
        a.add("CheckWaitingQueue");
        a.add("NPTH-CrashTimer");
        a.add("NPTH-JavaCallback");
        a.add("NPTH-LocalParser");
        a.add("ANR_FILE_MODIFY");
    }

    public static Set<String> a() {
        return a;
    }

    public static boolean a(Throwable th) {
        if (th == null) {
            return true;
        }
        try {
            return (th instanceof ConnectTimeoutException) || (th instanceof SocketTimeoutException) || (th instanceof BindException) || (th instanceof ConnectException) || (th instanceof NoRouteToHostException) || (th instanceof PortUnreachableException) || (th instanceof SocketException) || (th instanceof UnknownHostException) || (th instanceof ProtocolException) || (th instanceof SSLException);
        } catch (Throwable th2) {
            th2.printStackTrace();
            return false;
        }
    }
}
