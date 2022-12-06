package com.huawei.agconnect.core.p007a;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import android.util.Log;
import com.huawei.agconnect.core.Service;
import com.huawei.agconnect.core.ServiceDiscovery;
import com.huawei.agconnect.core.ServiceRegistrar;
import com.xiaomi.mipush.sdk.Constants;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.huawei.agconnect.core.a.f */
public class C0558f {

    /* renamed from: a */
    private Context f128a;

    /* renamed from: com.huawei.agconnect.core.a.f$a */
    private static class C0559a implements Comparator<Map.Entry<String, Integer>>, Serializable {
        private C0559a() {
        }

        /* renamed from: a */
        public int compare(Map.Entry<String, Integer> entry, Map.Entry<String, Integer> entry2) {
            return entry.getValue().intValue() - entry2.getValue().intValue();
        }
    }

    C0558f(Context context) {
        this.f128a = context;
    }

    /* renamed from: a */
    private <T extends ServiceRegistrar> T m78a(String str) {
        String str2;
        String str3;
        StringBuilder sb;
        try {
            Class<?> cls = Class.forName(str);
            if (ServiceRegistrar.class.isAssignableFrom(cls)) {
                return (ServiceRegistrar) Class.forName(str).newInstance();
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append(cls);
            sb2.append(" must extends from ServiceRegistrar.");
            Log.e("ServiceRegistrarParser", sb2.toString());
            return null;
        } catch (ClassNotFoundException e) {
            str2 = "Can not found service class, " + e.getMessage();
            Log.e("ServiceRegistrarParser", str2);
            return null;
        } catch (InstantiationException e2) {
            sb = new StringBuilder();
            sb.append("instantiate service class exception ");
            str3 = e2.getLocalizedMessage();
            sb.append(str3);
            str2 = sb.toString();
            Log.e("ServiceRegistrarParser", str2);
            return null;
        } catch (IllegalAccessException e3) {
            sb = new StringBuilder();
            sb.append("instantiate service class exception ");
            str3 = e3.getLocalizedMessage();
            sb.append(str3);
            str2 = sb.toString();
            Log.e("ServiceRegistrarParser", str2);
            return null;
        }
    }

    /* renamed from: b */
    private Bundle m79b() {
        PackageManager packageManager = this.f128a.getPackageManager();
        if (packageManager == null) {
            return null;
        }
        try {
            ServiceInfo serviceInfo = packageManager.getServiceInfo(new ComponentName(this.f128a, ServiceDiscovery.class), 128);
            if (serviceInfo != null) {
                return serviceInfo.metaData;
            }
            Log.e("ServiceRegistrarParser", "Can not found ServiceDiscovery service.");
            return null;
        } catch (PackageManager.NameNotFoundException e) {
            Log.e("ServiceRegistrarParser", "get ServiceDiscovery exception." + e.getLocalizedMessage());
        }
    }

    /* renamed from: c */
    private List<String> m80c() {
        StringBuilder sb;
        ArrayList arrayList = new ArrayList();
        Bundle b = m79b();
        if (b == null) {
            return arrayList;
        }
        HashMap hashMap = new HashMap(10);
        for (String str : b.keySet()) {
            if ("com.huawei.agconnect.core.ServiceRegistrar".equals(b.getString(str))) {
                String[] split = str.split(Constants.COLON_SEPARATOR);
                if (split.length == 2) {
                    try {
                        hashMap.put(split[0], Integer.valueOf(split[1]));
                    } catch (NumberFormatException e) {
                        sb = new StringBuilder();
                        sb.append("registrar configuration format error:");
                        str = e.getMessage();
                    }
                } else if (split.length == 1) {
                    hashMap.put(split[0], 1000);
                } else {
                    sb = new StringBuilder();
                    sb.append("registrar configuration error, ");
                    sb.append(str);
                    Log.e("ServiceRegistrarParser", sb.toString());
                }
            }
        }
        ArrayList<Map.Entry> arrayList2 = new ArrayList<>(hashMap.entrySet());
        Collections.sort(arrayList2, new C0559a());
        for (Map.Entry key : arrayList2) {
            arrayList.add(key.getKey());
        }
        return arrayList;
    }

    /* renamed from: a */
    public List<Service> mo12765a() {
        Log.i("ServiceRegistrarParser", "getServices");
        List<String> c = m80c();
        ArrayList arrayList = new ArrayList();
        for (String a : c) {
            ServiceRegistrar a2 = m78a(a);
            if (a2 != null) {
                a2.initialize(this.f128a);
                List<Service> services = a2.getServices(this.f128a);
                if (services != null) {
                    arrayList.addAll(services);
                }
            }
        }
        Log.i("ServiceRegistrarParser", "services:" + Integer.valueOf(arrayList.size()));
        return arrayList;
    }
}
