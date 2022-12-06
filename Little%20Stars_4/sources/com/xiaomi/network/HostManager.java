package com.xiaomi.network;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.net.wifi.WifiManager;
import android.os.Process;
import android.support.v4.os.EnvironmentCompat;
import android.text.TextUtils;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.channel.commonutils.network.a;
import com.xiaomi.channel.commonutils.network.c;
import com.xiaomi.channel.commonutils.network.d;
import com.xiaomi.mipush.sdk.Constants;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import object.p2pipcam.utils.DataBaseHelper;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class HostManager {
    private static HostManagerFactory factory;
    protected static boolean hostLoaded = false;
    protected static Map<String, ArrayList<String>> mReservedHosts = new HashMap();
    private static String sAppName;
    private static String sAppVersion;
    private static HostManager sInstance;
    private final long MAX_REQUEST_FAILURE_CNT = 15;
    private String currentISP = "isp_prov_city_country_ip";
    private long lastRemoteRequestTimestamp = 0;
    protected Map<String, Fallbacks> mHostsMapping = new HashMap();
    private long remoteRequestFailureCount = 0;
    protected Context sAppContext;
    private HostFilter sHostFilter;
    protected HttpGet sHttpGetter;
    private String sUserId = PushConstants.PUSH_TYPE_NOTIFY;

    public interface HostManagerFactory {
        HostManager a(Context context, HostFilter hostFilter, HttpGet httpGet, String str);
    }

    public interface HttpGet {
        String a(String str);
    }

    protected HostManager(Context context, HostFilter hostFilter, HttpGet httpGet, String str, String str2, String str3) {
        this.sAppContext = context.getApplicationContext();
        if (this.sAppContext == null) {
            this.sAppContext = context;
        }
        this.sHttpGetter = httpGet;
        this.sHostFilter = hostFilter == null ? new a(this) : hostFilter;
        this.sUserId = str;
        sAppName = str2 == null ? context.getPackageName() : str2;
        sAppVersion = str3 == null ? getVersionName() : str3;
    }

    public static void addReservedHost(String str, String str2) {
        ArrayList arrayList = mReservedHosts.get(str);
        synchronized (mReservedHosts) {
            if (arrayList == null) {
                ArrayList arrayList2 = new ArrayList();
                arrayList2.add(str2);
                mReservedHosts.put(str, arrayList2);
            } else if (!arrayList.contains(str2)) {
                arrayList.add(str2);
            }
        }
    }

    public static synchronized HostManager getInstance() {
        HostManager hostManager;
        synchronized (HostManager.class) {
            if (sInstance != null) {
                hostManager = sInstance;
            } else {
                throw new IllegalStateException("the host manager is not initialized yet.");
            }
        }
        return hostManager;
    }

    private String getVersionName() {
        try {
            PackageInfo packageInfo = this.sAppContext.getPackageManager().getPackageInfo(this.sAppContext.getPackageName(), 16384);
            return packageInfo != null ? packageInfo.versionName : PushConstants.PUSH_TYPE_NOTIFY;
        } catch (Exception unused) {
            return PushConstants.PUSH_TYPE_NOTIFY;
        }
    }

    public static synchronized void init(Context context, HostFilter hostFilter, HttpGet httpGet, String str, String str2, String str3) {
        synchronized (HostManager.class) {
            if (sInstance == null) {
                if (factory == null) {
                    sInstance = new HostManager(context, hostFilter, httpGet, str, str2, str3);
                } else {
                    sInstance = factory.a(context, hostFilter, httpGet, str);
                }
            }
        }
    }

    public static <T> String join(Collection<T> collection, String str) {
        if (collection == null || collection.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        Iterator<T> it = collection.iterator();
        while (it.hasNext()) {
            sb.append(it.next());
            if (it.hasNext()) {
                sb.append(str);
            }
        }
        return sb.toString();
    }

    public static String join(String[] strArr, String str) {
        if (strArr == null || strArr.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(strArr[0]);
        for (int i = 1; i < strArr.length; i++) {
            sb.append(str);
            sb.append(strArr[i]);
        }
        return sb.toString();
    }

    private ArrayList<Fallback> requestRemoteFallbacks(ArrayList<String> arrayList) {
        JSONObject jSONObject;
        JSONObject jSONObject2;
        ArrayList<String> arrayList2 = arrayList;
        purge();
        synchronized (this.mHostsMapping) {
            checkHostMapping();
            for (String next : this.mHostsMapping.keySet()) {
                if (!arrayList2.contains(next)) {
                    arrayList2.add(next);
                }
            }
        }
        synchronized (mReservedHosts) {
            for (String next2 : mReservedHosts.keySet()) {
                if (!arrayList2.contains(next2)) {
                    arrayList2.add(next2);
                }
            }
        }
        if (!arrayList2.contains(getHost())) {
            arrayList2.add(getHost());
        }
        ArrayList<Fallback> arrayList3 = new ArrayList<>(arrayList.size());
        for (int i = 0; i < arrayList.size(); i++) {
            arrayList3.add((Object) null);
        }
        try {
            String str = d.f(this.sAppContext) ? "wifi" : "wap";
            String remoteFallbackJSON = getRemoteFallbackJSON(arrayList2, str, this.sUserId);
            if (!TextUtils.isEmpty(remoteFallbackJSON)) {
                JSONObject jSONObject3 = new JSONObject(remoteFallbackJSON);
                if ("OK".equalsIgnoreCase(jSONObject3.getString("S"))) {
                    JSONObject jSONObject4 = jSONObject3.getJSONObject("R");
                    String string = jSONObject4.getString("province");
                    String string2 = jSONObject4.getString("city");
                    String string3 = jSONObject4.getString("isp");
                    String string4 = jSONObject4.getString("ip");
                    String string5 = jSONObject4.getString("country");
                    JSONObject jSONObject5 = jSONObject4.getJSONObject(str);
                    if (str.equals("wap")) {
                        str = getActiveNetworkLabel();
                    }
                    b.a("get bucket: ip = " + string4 + " net = " + string3 + str + " hosts = " + jSONObject5.toString());
                    int i2 = 0;
                    while (i2 < arrayList.size()) {
                        String str2 = arrayList2.get(i2);
                        JSONArray optJSONArray = jSONObject5.optJSONArray(str2);
                        if (optJSONArray == null) {
                            b.a("no bucket found for " + str2);
                            jSONObject = jSONObject5;
                        } else {
                            Fallback fallback = new Fallback(str2);
                            int i3 = 0;
                            while (i3 < optJSONArray.length()) {
                                String string6 = optJSONArray.getString(i3);
                                if (!TextUtils.isEmpty(string6)) {
                                    jSONObject2 = jSONObject5;
                                    fallback.a(new c(string6, optJSONArray.length() - i3));
                                } else {
                                    jSONObject2 = jSONObject5;
                                }
                                i3++;
                                jSONObject5 = jSONObject2;
                            }
                            jSONObject = jSONObject5;
                            arrayList3.set(i2, fallback);
                            fallback.g = string5;
                            fallback.c = string;
                            fallback.e = string3;
                            fallback.f = string4;
                            fallback.d = string2;
                            if (jSONObject4.has("stat-percent")) {
                                fallback.a(jSONObject4.getDouble("stat-percent"));
                            }
                            if (jSONObject4.has("stat-domain")) {
                                fallback.b(jSONObject4.getString("stat-domain"));
                            }
                            if (jSONObject4.has("ttl")) {
                                fallback.a(((long) jSONObject4.getInt("ttl")) * 1000);
                            }
                            setCurrentISP(fallback.e());
                        }
                        i2++;
                        jSONObject5 = jSONObject;
                    }
                }
            }
        } catch (Exception e) {
            b.a("failed to get bucket " + e.getMessage());
        }
        for (int i4 = 0; i4 < arrayList.size(); i4++) {
            Fallback fallback2 = arrayList3.get(i4);
            if (fallback2 != null) {
                updateFallbacks(arrayList2.get(i4), fallback2);
            }
        }
        persist();
        return arrayList3;
    }

    public static synchronized void setHostManagerFactory(HostManagerFactory hostManagerFactory) {
        synchronized (HostManager.class) {
            factory = hostManagerFactory;
            sInstance = null;
        }
    }

    /* access modifiers changed from: protected */
    public boolean checkHostMapping() {
        synchronized (this.mHostsMapping) {
            if (hostLoaded) {
                return true;
            }
            hostLoaded = true;
            this.mHostsMapping.clear();
            try {
                String loadHosts = loadHosts();
                if (!TextUtils.isEmpty(loadHosts)) {
                    fromJSON(loadHosts);
                    b.a("loading the new hosts succeed");
                    return true;
                }
            } catch (Throwable th) {
                b.a("load host exception " + th.getMessage());
            }
        }
        return false;
    }

    public void clear() {
        synchronized (this.mHostsMapping) {
            this.mHostsMapping.clear();
        }
    }

    /* access modifiers changed from: protected */
    public void fromJSON(String str) {
        synchronized (this.mHostsMapping) {
            this.mHostsMapping.clear();
            JSONArray jSONArray = new JSONArray(str);
            for (int i = 0; i < jSONArray.length(); i++) {
                Fallbacks fromJSON = new Fallbacks().fromJSON(jSONArray.getJSONObject(i));
                this.mHostsMapping.put(fromJSON.getHost(), fromJSON);
            }
        }
    }

    public String getActiveNetworkLabel() {
        NetworkInfo activeNetworkInfo;
        Context context = this.sAppContext;
        if (context == null) {
            return EnvironmentCompat.MEDIA_UNKNOWN;
        }
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null) {
                return EnvironmentCompat.MEDIA_UNKNOWN;
            }
            if (activeNetworkInfo.getType() == 1) {
                WifiManager wifiManager = (WifiManager) this.sAppContext.getSystemService("wifi");
                if (!(wifiManager == null || wifiManager.getConnectionInfo() == null)) {
                    return "WIFI-" + wifiManager.getConnectionInfo().getSSID();
                }
                return EnvironmentCompat.MEDIA_UNKNOWN;
            }
            return activeNetworkInfo.getTypeName() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + activeNetworkInfo.getSubtypeName();
        } catch (Throwable unused) {
        }
    }

    public Fallback getFallbacksByHost(String str) {
        return getFallbacksByHost(str, true);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0027, code lost:
        r4 = requestRemoteFallback(r3);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.xiaomi.network.Fallback getFallbacksByHost(java.lang.String r3, boolean r4) {
        /*
            r2 = this;
            boolean r0 = android.text.TextUtils.isEmpty(r3)
            if (r0 != 0) goto L_0x0034
            com.xiaomi.network.HostFilter r0 = r2.sHostFilter
            boolean r0 = r0.a(r3)
            if (r0 != 0) goto L_0x0010
            r3 = 0
            return r3
        L_0x0010:
            com.xiaomi.network.Fallback r0 = r2.getLocalFallback(r3)
            if (r0 == 0) goto L_0x001d
            boolean r1 = r0.b()
            if (r1 == 0) goto L_0x001d
            return r0
        L_0x001d:
            if (r4 == 0) goto L_0x002e
            android.content.Context r4 = r2.sAppContext
            boolean r4 = com.xiaomi.channel.commonutils.network.d.d(r4)
            if (r4 == 0) goto L_0x002e
            com.xiaomi.network.Fallback r4 = r2.requestRemoteFallback(r3)
            if (r4 == 0) goto L_0x002e
            return r4
        L_0x002e:
            com.xiaomi.network.b r4 = new com.xiaomi.network.b
            r4.<init>(r2, r3, r0)
            return r4
        L_0x0034:
            java.lang.IllegalArgumentException r3 = new java.lang.IllegalArgumentException
            java.lang.String r4 = "the host is empty"
            r3.<init>(r4)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.network.HostManager.getFallbacksByHost(java.lang.String, boolean):com.xiaomi.network.Fallback");
    }

    public Fallback getFallbacksByURL(String str) {
        if (!TextUtils.isEmpty(str)) {
            return getFallbacksByHost(new URL(str).getHost(), true);
        }
        throw new IllegalArgumentException("the url is empty");
    }

    /* access modifiers changed from: protected */
    public String getHost() {
        return "resolver.gslb.mi-idc.com";
    }

    /* access modifiers changed from: protected */
    public Fallback getLocalFallback(String str) {
        Fallbacks fallbacks;
        Fallback fallback;
        synchronized (this.mHostsMapping) {
            checkHostMapping();
            fallbacks = this.mHostsMapping.get(str);
        }
        if (fallbacks == null || (fallback = fallbacks.getFallback()) == null) {
            return null;
        }
        return fallback;
    }

    /* access modifiers changed from: protected */
    public String getProcessName() {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) this.sAppContext.getSystemService(PushConstants.INTENT_ACTIVITY_NAME)).getRunningAppProcesses();
        if (runningAppProcesses == null) {
            return "com.xiaomi";
        }
        for (ActivityManager.RunningAppProcessInfo next : runningAppProcesses) {
            if (next.pid == Process.myPid()) {
                return next.processName;
            }
        }
        return "com.xiaomi";
    }

    /* access modifiers changed from: protected */
    public String getRemoteFallbackJSON(ArrayList<String> arrayList, String str, String str2) {
        ArrayList<String> arrayList2 = new ArrayList<>();
        ArrayList<c> arrayList3 = new ArrayList<>();
        arrayList3.add(new a(DataBaseHelper.KEY_TYPE, str));
        arrayList3.add(new a("uuid", str2));
        arrayList3.add(new a("list", join(arrayList, Constants.ACCEPT_TIME_SEPARATOR_SP)));
        Fallback localFallback = getLocalFallback("resolver.gslb.mi-idc.com");
        String format = String.format("http://%1$s/gslb/gslb/getbucket.asp?ver=3.0", new Object[]{"resolver.gslb.mi-idc.com"});
        if (localFallback == null) {
            arrayList2.add(format);
        } else {
            arrayList2 = localFallback.a(format);
        }
        Iterator<String> it = arrayList2.iterator();
        IOException e = null;
        while (it.hasNext()) {
            Uri.Builder buildUpon = Uri.parse(it.next()).buildUpon();
            for (c cVar : arrayList3) {
                buildUpon.appendQueryParameter(cVar.a(), cVar.b());
            }
            try {
                return this.sHttpGetter == null ? d.a(this.sAppContext, new URL(buildUpon.toString())) : this.sHttpGetter.a(buildUpon.toString());
            } catch (IOException e2) {
                e = e2;
                b.a("network ioErr: " + e.getMessage());
            }
        }
        if (e == null) {
            return null;
        }
        throw e;
    }

    /* access modifiers changed from: protected */
    public String loadHosts() {
        BufferedReader bufferedReader;
        try {
            File file = new File(this.sAppContext.getFilesDir(), getProcessName());
            if (file.isFile()) {
                bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
                try {
                    StringBuilder sb = new StringBuilder();
                    while (true) {
                        String readLine = bufferedReader.readLine();
                        if (readLine != null) {
                            sb.append(readLine);
                        } else {
                            String sb2 = sb.toString();
                            com.xiaomi.channel.commonutils.file.a.a((Reader) bufferedReader);
                            return sb2;
                        }
                    }
                } catch (Throwable th) {
                    th = th;
                    try {
                        b.a("load host exception " + th.getMessage());
                        com.xiaomi.channel.commonutils.file.a.a((Reader) bufferedReader);
                        return null;
                    } catch (Throwable th2) {
                        th = th2;
                        com.xiaomi.channel.commonutils.file.a.a((Reader) bufferedReader);
                        throw th;
                    }
                }
            } else {
                com.xiaomi.channel.commonutils.file.a.a((Reader) null);
                return null;
            }
        } catch (Throwable th3) {
            bufferedReader = null;
            th = th3;
            com.xiaomi.channel.commonutils.file.a.a((Reader) bufferedReader);
            throw th;
        }
    }

    public void persist() {
        purge();
        synchronized (this.mHostsMapping) {
            try {
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(this.sAppContext.openFileOutput(getProcessName(), 0)));
                String jSONArray = toJSON().toString();
                if (!TextUtils.isEmpty(jSONArray)) {
                    bufferedWriter.write(jSONArray);
                }
                bufferedWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e2) {
                e2.printStackTrace();
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        }
    }

    public void purge() {
        String next;
        synchronized (this.mHostsMapping) {
            for (Fallbacks purge : this.mHostsMapping.values()) {
                purge.purge(false);
            }
            while (true) {
                boolean z = false;
                while (!z) {
                    z = true;
                    Iterator<String> it = this.mHostsMapping.keySet().iterator();
                    while (true) {
                        if (it.hasNext()) {
                            next = it.next();
                            if (this.mHostsMapping.get(next).getFallbacks().isEmpty()) {
                                break;
                            }
                        }
                    }
                }
                this.mHostsMapping.remove(next);
            }
        }
    }

    public void refreshFallbacks() {
        ArrayList arrayList;
        synchronized (this.mHostsMapping) {
            checkHostMapping();
            arrayList = new ArrayList(this.mHostsMapping.keySet());
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                Fallbacks fallbacks = this.mHostsMapping.get(arrayList.get(size));
                if (!(fallbacks == null || fallbacks.getFallback() == null)) {
                    arrayList.remove(size);
                }
            }
        }
        ArrayList<Fallback> requestRemoteFallbacks = requestRemoteFallbacks(arrayList);
        for (int i = 0; i < arrayList.size(); i++) {
            if (requestRemoteFallbacks.get(i) != null) {
                updateFallbacks((String) arrayList.get(i), requestRemoteFallbacks.get(i));
            }
        }
    }

    /* access modifiers changed from: protected */
    public Fallback requestRemoteFallback(String str) {
        if (System.currentTimeMillis() - this.lastRemoteRequestTimestamp <= this.remoteRequestFailureCount * 60 * 1000) {
            return null;
        }
        this.lastRemoteRequestTimestamp = System.currentTimeMillis();
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        Fallback fallback = requestRemoteFallbacks(arrayList).get(0);
        if (fallback != null) {
            this.remoteRequestFailureCount = 0;
            return fallback;
        }
        long j = this.remoteRequestFailureCount;
        if (j >= 15) {
            return null;
        }
        this.remoteRequestFailureCount = j + 1;
        return null;
    }

    public void setCurrentISP(String str) {
        this.currentISP = str;
    }

    /* access modifiers changed from: protected */
    public JSONArray toJSON() {
        JSONArray jSONArray;
        synchronized (this.mHostsMapping) {
            jSONArray = new JSONArray();
            for (Fallbacks json : this.mHostsMapping.values()) {
                jSONArray.put(json.toJSON());
            }
        }
        return jSONArray;
    }

    public void updateFallbacks(String str, Fallback fallback) {
        if (TextUtils.isEmpty(str) || fallback == null) {
            throw new IllegalArgumentException("the argument is invalid " + str + ", " + fallback);
        } else if (this.sHostFilter.a(str)) {
            synchronized (this.mHostsMapping) {
                checkHostMapping();
                if (this.mHostsMapping.containsKey(str)) {
                    this.mHostsMapping.get(str).addFallback(fallback);
                } else {
                    Fallbacks fallbacks = new Fallbacks(str);
                    fallbacks.addFallback(fallback);
                    this.mHostsMapping.put(str, fallbacks);
                }
            }
        }
    }
}
