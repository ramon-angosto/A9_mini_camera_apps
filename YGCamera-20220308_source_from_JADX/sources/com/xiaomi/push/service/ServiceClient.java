package com.xiaomi.push.service;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.os.Bundle;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.C1524b;
import com.xiaomi.mipush.sdk.Constants;
import com.xiaomi.push.C1611ad;
import com.xiaomi.push.C1653bi;
import com.xiaomi.push.C1781ez;
import com.xiaomi.push.C1826gi;
import com.xiaomi.push.C1827gj;
import com.xiaomi.push.C1829gk;
import com.xiaomi.push.C1832gn;
import com.xiaomi.push.C1844gw;
import com.xiaomi.push.C1938m;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.http.NameValuePair;

public class ServiceClient {

    /* renamed from: a */
    private static long f3581a = 0;

    /* renamed from: a */
    private static ServiceClient f3582a;

    /* renamed from: a */
    private static String f3583a;

    /* renamed from: b */
    private static String f3584b = (C1844gw.m3800a(5) + Constants.ACCEPT_TIME_SEPARATOR_SERVER);

    /* renamed from: a */
    private Context f3585a;

    /* renamed from: a */
    private Messenger f3586a = null;

    /* renamed from: a */
    private List<Message> f3587a = new ArrayList();

    /* renamed from: a */
    private boolean f3588a = false;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public Messenger f3589b;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public boolean f3590b = false;

    private ServiceClient(Context context) {
        this.f3585a = context.getApplicationContext();
        if (m4745a()) {
            C1524b.m2159c("use miui push service");
            this.f3588a = true;
        }
    }

    /* renamed from: a */
    private Intent m4745a() {
        if (isMiuiPushServiceEnabled()) {
            Intent intent = new Intent();
            intent.setPackage("com.xiaomi.xmsf");
            intent.setClassName("com.xiaomi.xmsf", m4745a());
            intent.putExtra(C2014bd.f3769A, this.f3585a.getPackageName());
            m4745a();
            return intent;
        }
        Intent intent2 = new Intent(this.f3585a, XMPushService.class);
        intent2.putExtra(C2014bd.f3769A, this.f3585a.getPackageName());
        m4758b();
        return intent2;
    }

    /* renamed from: a */
    private Message m4746a(Intent intent) {
        Message obtain = Message.obtain();
        obtain.what = 17;
        obtain.obj = intent;
        return obtain;
    }

    /* renamed from: a */
    private String m4749a() {
        try {
            return this.f3585a.getPackageManager().getPackageInfo("com.xiaomi.xmsf", 4).versionCode >= 106 ? "com.xiaomi.push.service.XMPushService" : "com.xiaomi.xmsf.push.service.XMPushService";
        } catch (Exception unused) {
            return "com.xiaomi.xmsf.push.service.XMPushService";
        }
    }

    /* renamed from: a */
    private String m4750a(Map<String, String> map) {
        StringBuilder sb = new StringBuilder();
        int i = 1;
        for (Map.Entry next : map.entrySet()) {
            sb.append((String) next.getKey());
            sb.append(Constants.COLON_SEPARATOR);
            sb.append((String) next.getValue());
            if (i < map.size()) {
                sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
            }
            i++;
        }
        return sb.toString();
    }

    /* renamed from: a */
    private Map<String, String> m4752a(List<NameValuePair> list) {
        HashMap hashMap = new HashMap();
        if (list != null && list.size() > 0) {
            for (NameValuePair next : list) {
                if (next != null) {
                    hashMap.put(next.getName(), next.getValue());
                }
            }
        }
        return hashMap;
    }

    /* renamed from: a */
    private void m4753a() {
        this.f3585a.getPackageManager().setComponentEnabledSetting(new ComponentName(this.f3585a, XMPushService.class), 2, 1);
    }

    /* renamed from: a */
    private synchronized void m4754a(Intent intent) {
        if (this.f3590b) {
            Message a = m4746a(intent);
            if (this.f3587a.size() >= 50) {
                this.f3587a.remove(0);
            }
            this.f3587a.add(a);
            return;
        } else if (this.f3589b == null) {
            Context context = this.f3585a;
            C2026bn bnVar = new C2026bn(this);
            Context context2 = this.f3585a;
            context.bindService(intent, bnVar, 1);
            this.f3590b = true;
            this.f3587a.clear();
            this.f3587a.add(m4746a(intent));
        } else {
            try {
                this.f3589b.send(m4746a(intent));
            } catch (RemoteException unused) {
                this.f3589b = null;
                this.f3590b = false;
            }
        }
        return;
    }

    /* renamed from: a */
    private void m4755a(Intent intent, String str, String str2, String str3, String str4, String str5, boolean z, Map<String, String> map, Map<String, String> map2) {
        intent.putExtra(C2014bd.f3797p, str);
        intent.putExtra(C2014bd.f3800s, str2);
        intent.putExtra(C2014bd.f3802u, str3);
        intent.putExtra(C2014bd.f3804w, str5);
        intent.putExtra(C2014bd.f3803v, str4);
        intent.putExtra(C2014bd.f3805x, z);
        intent.putExtra(C2014bd.f3773E, f3583a);
        intent.putExtra(C2014bd.f3777I, this.f3586a);
        if (map != null && map.size() > 0) {
            String a = m4750a(map);
            if (!TextUtils.isEmpty(a)) {
                intent.putExtra(C2014bd.f3806y, a);
            }
        }
        if (map2 != null && map2.size() > 0) {
            String a2 = m4750a(map2);
            if (!TextUtils.isEmpty(a2)) {
                intent.putExtra(C2014bd.f3807z, a2);
            }
        }
    }

    /* renamed from: a */
    private boolean m4756a() {
        if (C1611ad.f1760e) {
            return false;
        }
        try {
            PackageInfo packageInfo = this.f3585a.getPackageManager().getPackageInfo("com.xiaomi.xmsf", 4);
            return packageInfo != null && packageInfo.versionCode >= 104;
        } catch (Exception unused) {
            return false;
        }
    }

    /* renamed from: b */
    private void m4758b() {
        this.f3585a.getPackageManager().setComponentEnabledSetting(new ComponentName(this.f3585a, XMPushService.class), 1, 1);
    }

    public static ServiceClient getInstance(Context context) {
        if (f3582a == null) {
            f3582a = new ServiceClient(context);
        }
        return f3582a;
    }

    public static String getSession() {
        return f3583a;
    }

    public static void setSession(String str) {
        f3583a = str;
    }

    public boolean batchSendMessage(C1829gk[] gkVarArr, boolean z) {
        if (!C1653bi.m2685b(this.f3585a)) {
            return false;
        }
        Intent a = m4745a();
        Bundle[] bundleArr = new Bundle[gkVarArr.length];
        for (int i = 0; i < gkVarArr.length; i++) {
            String a2 = C1781ez.m3467a();
            if (!TextUtils.isEmpty(a2)) {
                String[] strArr = null;
                C1826gi giVar = new C1826gi("pf", (String) null, strArr, strArr);
                C1826gi giVar2 = new C1826gi("sent", (String) null, strArr, strArr);
                giVar2.mo17692a(a2);
                giVar.mo17693a(giVar2);
                gkVarArr[i].mo17724a(giVar);
            }
            C1524b.m2159c("SEND:" + gkVarArr[i].mo17698a());
            bundleArr[i] = gkVarArr[i].mo17698a();
        }
        if (bundleArr.length <= 0) {
            return false;
        }
        a.setAction(C2014bd.f3788g);
        a.putExtra(C2014bd.f3773E, f3583a);
        a.putExtra("ext_packets", bundleArr);
        a.putExtra("ext_encrypt", z);
        return startServiceSafely(a);
    }

    public void checkAlive() {
        Intent a = m4745a();
        a.setAction("com.xiaomi.push.check_alive");
        startServiceSafely(a);
    }

    public boolean closeChannel() {
        Intent a = m4745a();
        a.setAction(C2014bd.f3790i);
        return startServiceSafely(a);
    }

    public boolean closeChannel(String str) {
        Intent a = m4745a();
        a.setAction(C2014bd.f3790i);
        a.putExtra(C2014bd.f3800s, str);
        return startServiceSafely(a);
    }

    public boolean closeChannel(String str, String str2) {
        Intent a = m4745a();
        a.setAction(C2014bd.f3790i);
        a.putExtra(C2014bd.f3800s, str);
        a.putExtra(C2014bd.f3797p, str2);
        return startServiceSafely(a);
    }

    @Deprecated
    public boolean forceReconnection(String str, String str2, String str3, String str4, String str5, boolean z, List<NameValuePair> list, List<NameValuePair> list2) {
        return forceReconnection(str, str2, str3, str4, str5, z, m4752a(list), m4752a(list2));
    }

    public boolean forceReconnection(String str, String str2, String str3, String str4, String str5, boolean z, Map<String, String> map, Map<String, String> map2) {
        Intent a = m4745a();
        a.setAction(C2014bd.f3791j);
        m4755a(a, str, str2, str3, str4, str5, z, map, map2);
        return startServiceSafely(a);
    }

    public boolean isMiuiPushServiceEnabled() {
        return this.f3588a;
    }

    public int openChannel(String str, String str2, String str3, String str4, String str5, Map<String, String> map, Map<String, String> map2, boolean z) {
        Intent a = m4745a();
        a.setAction(C2014bd.f3785d);
        m4755a(a, str, str2, str3, str4, str5, z, map, map2);
        startServiceSafely(a);
        return 0;
    }

    @Deprecated
    public int openChannel(String str, String str2, String str3, String str4, String str5, boolean z, List<NameValuePair> list, List<NameValuePair> list2) {
        return openChannel(str, str2, str3, str4, str5, m4752a(list), m4752a(list2), z);
    }

    @Deprecated
    public void resetConnection(String str, String str2, String str3, String str4, String str5, boolean z, List<NameValuePair> list, List<NameValuePair> list2) {
        resetConnection(str, str2, str3, str4, str5, z, m4752a(list), m4752a(list2));
    }

    public void resetConnection(String str, String str2, String str3, String str4, String str5, boolean z, Map<String, String> map, Map<String, String> map2) {
        Intent a = m4745a();
        a.setAction(C2014bd.f3792k);
        m4755a(a, str, str2, str3, str4, str5, z, map, map2);
        startServiceSafely(a);
    }

    public boolean sendIQ(C1827gj gjVar) {
        if (!C1653bi.m2685b(this.f3585a)) {
            return false;
        }
        Intent a = m4745a();
        Bundle a2 = gjVar.mo17698a();
        if (a2 == null) {
            return false;
        }
        C1524b.m2159c("SEND:" + gjVar.mo17698a());
        a.setAction(C2014bd.f3787f);
        a.putExtra(C2014bd.f3773E, f3583a);
        a.putExtra("ext_packet", a2);
        return startServiceSafely(a);
    }

    public boolean sendMessage(C1829gk gkVar, boolean z) {
        if (!C1653bi.m2685b(this.f3585a)) {
            return false;
        }
        Intent a = m4745a();
        String a2 = C1781ez.m3467a();
        if (!TextUtils.isEmpty(a2)) {
            String[] strArr = null;
            C1826gi giVar = new C1826gi("pf", (String) null, strArr, strArr);
            C1826gi giVar2 = new C1826gi("sent", (String) null, strArr, strArr);
            giVar2.mo17692a(a2);
            giVar.mo17693a(giVar2);
            gkVar.mo17724a(giVar);
        }
        Bundle a3 = gkVar.mo17698a();
        if (a3 == null) {
            return false;
        }
        C1524b.m2159c("SEND:" + gkVar.mo17698a());
        a.setAction(C2014bd.f3786e);
        a.putExtra(C2014bd.f3773E, f3583a);
        a.putExtra("ext_packet", a3);
        a.putExtra("ext_encrypt", z);
        return startServiceSafely(a);
    }

    public boolean sendMessage(byte[] bArr, String str, String str2) {
        String str3;
        if (!C1653bi.m2685b(this.f3585a) || bArr == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            C1524b.m2141a("Failed to send message: message|userId|chid may be empty, or the network is unavailable.");
            return false;
        }
        Intent a = m4745a();
        if (bArr == null) {
            return false;
        }
        a.setAction(C2014bd.f3786e);
        a.putExtra(C2014bd.f3773E, f3583a);
        a.putExtra("ext_raw_packet", bArr);
        int indexOf = str.indexOf("@");
        String str4 = null;
        String substring = indexOf != -1 ? str.substring(0, indexOf) : null;
        int lastIndexOf = str.lastIndexOf("/");
        if (lastIndexOf != -1) {
            str4 = str.substring(indexOf + 1, lastIndexOf);
            str3 = str.substring(lastIndexOf + 1);
        } else {
            str3 = null;
        }
        a.putExtra(C2014bd.f3797p, substring);
        a.putExtra(C2014bd.f3798q, str4);
        a.putExtra(C2014bd.f3799r, str3);
        StringBuilder sb = new StringBuilder();
        sb.append(f3584b);
        long j = f3581a;
        f3581a = 1 + j;
        sb.append(j);
        String sb2 = sb.toString();
        a.putExtra("ext_pkt_id", sb2);
        a.putExtra("ext_chid", str2);
        C1524b.m2161e("SEND: chid=" + str2 + ", packetId=" + sb2);
        return startServiceSafely(a);
    }

    public boolean sendPresence(C1832gn gnVar) {
        if (!C1653bi.m2685b(this.f3585a)) {
            return false;
        }
        Intent a = m4745a();
        Bundle a2 = gnVar.mo17698a();
        if (a2 == null) {
            return false;
        }
        C1524b.m2159c("SEND:" + gnVar.mo17698a());
        a.setAction(C2014bd.f3789h);
        a.putExtra(C2014bd.f3773E, f3583a);
        a.putExtra("ext_packet", a2);
        return startServiceSafely(a);
    }

    public void setMessenger(Messenger messenger) {
        this.f3586a = messenger;
    }

    public boolean startServiceSafely(Intent intent) {
        try {
            if (C1938m.m4713a() || Build.VERSION.SDK_INT < 26) {
                this.f3585a.startService(intent);
                return true;
            }
            m4746a(intent);
            return true;
        } catch (Exception e) {
            C1524b.m2155a((Throwable) e);
            return false;
        }
    }

    @Deprecated
    public void updateChannelInfo(String str, List<NameValuePair> list, List<NameValuePair> list2) {
        updateChannelInfo(str, m4752a(list), m4752a(list2));
    }

    public void updateChannelInfo(String str, Map<String, String> map, Map<String, String> map2) {
        Intent a = m4745a();
        a.setAction(C2014bd.f3793l);
        if (map != null) {
            String a2 = m4750a(map);
            if (!TextUtils.isEmpty(a2)) {
                a.putExtra(C2014bd.f3806y, a2);
            }
        }
        if (map2 != null) {
            String a3 = m4750a(map2);
            if (!TextUtils.isEmpty(a3)) {
                a.putExtra(C2014bd.f3807z, a3);
            }
        }
        a.putExtra(C2014bd.f3800s, str);
        startServiceSafely(a);
    }
}
