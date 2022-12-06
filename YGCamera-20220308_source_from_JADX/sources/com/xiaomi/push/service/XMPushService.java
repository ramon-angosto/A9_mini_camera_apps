package com.xiaomi.push.service;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.ContentObserver;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Messenger;
import android.os.Parcelable;
import android.os.Process;
import android.os.SystemClock;
import android.provider.Settings;
import android.text.TextUtils;
import com.huawei.hms.support.api.entity.auth.AuthCode;
import com.xiaomi.channel.commonutils.logger.C1523a;
import com.xiaomi.channel.commonutils.logger.C1524b;
import com.xiaomi.mipush.sdk.Constants;
import com.xiaomi.mipush.sdk.ErrorCode;
import com.xiaomi.push.C1611ad;
import com.xiaomi.push.C1618ak;
import com.xiaomi.push.C1628aq;
import com.xiaomi.push.C1653bi;
import com.xiaomi.push.C1662bn;
import com.xiaomi.push.C1702cu;
import com.xiaomi.push.C1715dd;
import com.xiaomi.push.C1722dk;
import com.xiaomi.push.C1764ej;
import com.xiaomi.push.C1768en;
import com.xiaomi.push.C1776eu;
import com.xiaomi.push.C1783fa;
import com.xiaomi.push.C1793fj;
import com.xiaomi.push.C1804fq;
import com.xiaomi.push.C1809fu;
import com.xiaomi.push.C1811fv;
import com.xiaomi.push.C1813fx;
import com.xiaomi.push.C1814fy;
import com.xiaomi.push.C1815fz;
import com.xiaomi.push.C1818ga;
import com.xiaomi.push.C1823gf;
import com.xiaomi.push.C1825gh;
import com.xiaomi.push.C1829gk;
import com.xiaomi.push.C1830gl;
import com.xiaomi.push.C1847gz;
import com.xiaomi.push.C1857hg;
import com.xiaomi.push.C1860hi;
import com.xiaomi.push.C1862hj;
import com.xiaomi.push.C1866hm;
import com.xiaomi.push.C1867hn;
import com.xiaomi.push.C1868ho;
import com.xiaomi.push.C1873ht;
import com.xiaomi.push.C1891ik;
import com.xiaomi.push.C1894in;
import com.xiaomi.push.C1895io;
import com.xiaomi.push.C1905iy;
import com.xiaomi.push.C1907j;
import com.xiaomi.push.C1913je;
import com.xiaomi.push.C1938m;
import com.xiaomi.push.C1941p;
import com.xiaomi.push.C2087u;
import com.xiaomi.push.service.C2003az;
import com.xiaomi.push.service.C2062j;
import com.xiaomi.push.service.C2072o;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class XMPushService extends Service implements C1813fx {

    /* renamed from: a */
    private int f3596a = 0;

    /* renamed from: a */
    private long f3597a = 0;

    /* renamed from: a */
    private ContentObserver f3598a;

    /* renamed from: a */
    Messenger f3599a = null;

    /* renamed from: a */
    private C1804fq f3600a;
    /* access modifiers changed from: private */

    /* renamed from: a */
    public C1809fu f3601a;

    /* renamed from: a */
    private C1811fv f3602a;

    /* renamed from: a */
    private C1815fz f3603a = new C2040bz(this);

    /* renamed from: a */
    private C1952e f3604a;

    /* renamed from: a */
    private C1963p f3605a;

    /* renamed from: a */
    private C1965r f3606a;

    /* renamed from: a */
    private C2000ax f3607a = null;

    /* renamed from: a */
    private C2022bj f3608a;

    /* renamed from: a */
    private C2058f f3609a;

    /* renamed from: a */
    private C2062j f3610a = null;

    /* renamed from: a */
    protected Class f3611a = XMJobService.class;

    /* renamed from: a */
    private String f3612a;

    /* renamed from: a */
    private ArrayList<C1959l> f3613a = new ArrayList<>();

    /* renamed from: a */
    private Collection<C1983al> f3614a = Collections.synchronizedCollection(new ArrayList());

    /* renamed from: b */
    private int f3615b = 0;

    /* renamed from: b */
    private ContentObserver f3616b;

    /* renamed from: com.xiaomi.push.service.XMPushService$a */
    class C1948a extends C1956i {

        /* renamed from: a */
        C2003az.C2005b f3618a = null;

        public C1948a(C2003az.C2005b bVar) {
            super(9);
            this.f3618a = bVar;
        }

        /* renamed from: a */
        public String mo17683a() {
            return "bind the client. " + this.f3618a.f3748g;
        }

        /* renamed from: a */
        public void m4834a() {
            String str;
            try {
                if (!XMPushService.this.mo18423c()) {
                    C1524b.m2160d("trying bind while the connection is not created, quit!");
                    return;
                }
                C2003az.C2005b a = C2003az.mo18481a().mo18482a(this.f3618a.f3748g, this.f3618a.f3742b);
                if (a == null) {
                    str = "ignore bind because the channel " + this.f3618a.f3748g + " is removed ";
                } else if (a.f3736a == C2003az.C2009c.unbind) {
                    a.mo18494a(C2003az.C2009c.binding, 0, 0, (String) null, (String) null);
                    XMPushService.m4759a(XMPushService.this).mo17643a(a);
                    C1860hi.m3865a(XMPushService.this, a);
                    return;
                } else {
                    str = "trying duplicate bind, ingore! " + a.f3736a;
                }
                C1524b.m2141a(str);
            } catch (Exception e) {
                C1524b.m2160d("Meet error when trying to bind. " + e);
                XMPushService.this.mo18410a(10, e);
            } catch (Throwable unused) {
            }
        }
    }

    /* renamed from: com.xiaomi.push.service.XMPushService$b */
    static class C1949b extends C1956i {

        /* renamed from: a */
        private final C2003az.C2005b f3619a;

        public C1949b(C2003az.C2005b bVar) {
            super(12);
            this.f3619a = bVar;
        }

        /* renamed from: a */
        public String mo17683a() {
            return "bind time out. chid=" + this.f3619a.f3748g;
        }

        /* renamed from: a */
        public void m4836a() {
            this.f3619a.mo18494a(C2003az.C2009c.unbind, 1, 21, (String) null, (String) null);
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof C1949b)) {
                return false;
            }
            return TextUtils.equals(((C1949b) obj).f3619a.f3748g, this.f3619a.f3748g);
        }

        public int hashCode() {
            return this.f3619a.f3748g.hashCode();
        }
    }

    /* renamed from: com.xiaomi.push.service.XMPushService$c */
    class C1950c extends C1956i {

        /* renamed from: a */
        private C1793fj f3620a = null;

        public C1950c(C1793fj fjVar) {
            super(8);
            this.f3620a = fjVar;
        }

        /* renamed from: a */
        public String mo17683a() {
            return "receive a message.";
        }

        /* renamed from: a */
        public void m4838a() {
            XMPushService.m4759a(XMPushService.this).mo18477a(this.f3620a);
        }
    }

    /* renamed from: com.xiaomi.push.service.XMPushService$d */
    public class C1951d extends C1956i {
        C1951d() {
            super(1);
        }

        /* renamed from: a */
        public String mo17683a() {
            return "do reconnect..";
        }

        /* renamed from: a */
        public void m4840a() {
            if (XMPushService.this.mo18408a()) {
                XMPushService xMPushService = XMPushService.this;
                if (xMPushService.m4776a(xMPushService.getApplicationContext())) {
                    XMPushService.this.m4796f();
                    return;
                }
            }
            C1524b.m2141a("should not connect. quit the job.");
        }
    }

    /* renamed from: com.xiaomi.push.service.XMPushService$e */
    class C1952e extends BroadcastReceiver {
        C1952e() {
        }

        public void onReceive(Context context, Intent intent) {
            C1524b.m2141a("network changed, " + C1938m.m4717a(intent));
            XMPushService.this.onStart(intent, 1);
        }
    }

    /* renamed from: com.xiaomi.push.service.XMPushService$f */
    public class C1953f extends C1956i {

        /* renamed from: a */
        public Exception f3625a;

        /* renamed from: b */
        public int f3626b;

        C1953f(int i, Exception exc) {
            super(2);
            this.f3626b = i;
            this.f3625a = exc;
        }

        /* renamed from: a */
        public String mo17683a() {
            return "disconnect the connection.";
        }

        /* renamed from: a */
        public void m4842a() {
            XMPushService.this.mo18410a(this.f3626b, this.f3625a);
        }
    }

    /* renamed from: com.xiaomi.push.service.XMPushService$g */
    class C1954g extends C1956i {
        C1954g() {
            super(65535);
        }

        /* renamed from: a */
        public String mo17683a() {
            return "Init Job";
        }

        /* renamed from: a */
        public void m4844a() {
            XMPushService.m4783b(XMPushService.this);
        }
    }

    /* renamed from: com.xiaomi.push.service.XMPushService$h */
    class C1955h extends C1956i {

        /* renamed from: a */
        private Intent f3628a = null;

        public C1955h(Intent intent) {
            super(15);
            this.f3628a = intent;
        }

        /* renamed from: a */
        public String mo17683a() {
            return "Handle intent action = " + this.f3628a.getAction();
        }

        /* renamed from: a */
        public void m4846a() {
            XMPushService.this.m4792d(this.f3628a);
        }
    }

    /* renamed from: com.xiaomi.push.service.XMPushService$i */
    public static abstract class C1956i extends C2062j.C2064b {
        public C1956i(int i) {
            super(i);
        }

        /* renamed from: a */
        public abstract String mo17683a();

        /* renamed from: a */
        public abstract void m4848a();

        public void run() {
            if (!(this.f3903a == 4 || this.f3903a == 8)) {
                C1524b.m2144a(C1523a.f1574a, mo17683a());
            }
            mo17683a();
        }
    }

    /* renamed from: com.xiaomi.push.service.XMPushService$j */
    class C1957j extends C1956i {
        public C1957j() {
            super(5);
        }

        /* renamed from: a */
        public String mo17683a() {
            return "ask the job queue to quit";
        }

        /* renamed from: a */
        public void m4850a() {
            XMPushService.m4759a(XMPushService.this).mo18537a();
        }
    }

    /* renamed from: com.xiaomi.push.service.XMPushService$k */
    class C1958k extends C1956i {

        /* renamed from: a */
        private C1830gl f3631a = null;

        public C1958k(C1830gl glVar) {
            super(8);
            this.f3631a = glVar;
        }

        /* renamed from: a */
        public String mo17683a() {
            return "receive a message.";
        }

        /* renamed from: a */
        public void m4852a() {
            XMPushService.m4759a(XMPushService.this).mo18478a(this.f3631a);
        }
    }

    /* renamed from: com.xiaomi.push.service.XMPushService$l */
    public interface C1959l {
        /* renamed from: a */
        void mo17759a();
    }

    /* renamed from: com.xiaomi.push.service.XMPushService$m */
    class C1960m extends C1956i {

        /* renamed from: a */
        boolean f3634a;

        public C1960m(boolean z) {
            super(4);
            this.f3634a = z;
        }

        /* renamed from: a */
        public String mo17683a() {
            return "send ping..";
        }

        /* renamed from: a */
        public void m4855a() {
            if (XMPushService.this.mo18423c()) {
                try {
                    if (!this.f3634a) {
                        C1860hi.m3860a();
                    }
                    XMPushService.m4759a(XMPushService.this).mo17665b(this.f3634a);
                } catch (C1823gf e) {
                    C1524b.m2155a((Throwable) e);
                    XMPushService.this.mo18410a(10, (Exception) e);
                }
            }
        }
    }

    /* renamed from: com.xiaomi.push.service.XMPushService$n */
    class C1961n extends C1956i {

        /* renamed from: a */
        C2003az.C2005b f3636a = null;

        public C1961n(C2003az.C2005b bVar) {
            super(4);
            this.f3636a = bVar;
        }

        /* renamed from: a */
        public String mo17683a() {
            return "rebind the client. " + this.f3636a.f3748g;
        }

        /* renamed from: a */
        public void m4857a() {
            try {
                this.f3636a.mo18494a(C2003az.C2009c.unbind, 1, 16, (String) null, (String) null);
                XMPushService.m4759a(XMPushService.this).mo17644a(this.f3636a.f3748g, this.f3636a.f3742b);
                XMPushService.this.mo18413a((C1956i) new C1948a(this.f3636a), 300);
            } catch (C1823gf e) {
                C1524b.m2155a((Throwable) e);
                XMPushService.this.mo18410a(10, (Exception) e);
            }
        }
    }

    /* renamed from: com.xiaomi.push.service.XMPushService$o */
    class C1962o extends C1956i {
        C1962o() {
            super(3);
        }

        /* renamed from: a */
        public String mo17683a() {
            return "reset the connection.";
        }

        /* renamed from: a */
        public void m4859a() {
            XMPushService.this.mo18410a(11, (Exception) null);
            if (XMPushService.this.mo18408a()) {
                XMPushService xMPushService = XMPushService.this;
                if (xMPushService.m4776a(xMPushService.getApplicationContext())) {
                    XMPushService.this.m4796f();
                }
            }
        }
    }

    /* renamed from: com.xiaomi.push.service.XMPushService$p */
    class C1963p extends BroadcastReceiver {
        C1963p() {
        }

        public void onReceive(Context context, Intent intent) {
            XMPushService.this.onStart(intent, 1);
        }
    }

    /* renamed from: com.xiaomi.push.service.XMPushService$q */
    class C1964q extends C1956i {

        /* renamed from: a */
        C2003az.C2005b f3640a = null;

        /* renamed from: a */
        String f3641a;

        /* renamed from: b */
        int f3642b;

        /* renamed from: b */
        String f3643b;

        public C1964q(C2003az.C2005b bVar, int i, String str, String str2) {
            super(9);
            this.f3640a = bVar;
            this.f3642b = i;
            this.f3641a = str;
            this.f3643b = str2;
        }

        /* renamed from: a */
        public String mo17683a() {
            return "unbind the channel. " + this.f3640a.f3748g;
        }

        /* renamed from: a */
        public void m4861a() {
            if (!(this.f3640a.f3736a == C2003az.C2009c.unbind || XMPushService.m4759a(XMPushService.this) == null)) {
                try {
                    XMPushService.m4759a(XMPushService.this).mo17644a(this.f3640a.f3748g, this.f3640a.f3742b);
                } catch (C1823gf e) {
                    C1524b.m2155a((Throwable) e);
                    XMPushService.this.mo18410a(10, (Exception) e);
                }
            }
            this.f3640a.mo18494a(C2003az.C2009c.unbind, this.f3642b, 0, this.f3643b, this.f3641a);
        }
    }

    /* renamed from: com.xiaomi.push.service.XMPushService$r */
    class C1965r extends BroadcastReceiver {
        C1965r() {
        }

        public void onReceive(Context context, Intent intent) {
            C1524b.m2141a("[HB] wifi changed, " + C1938m.m4717a(intent));
            XMPushService.this.onStart(intent, 1);
        }
    }

    /* renamed from: a */
    private C1830gl m4762a(C1830gl glVar, String str, String str2) {
        StringBuilder sb;
        String str3;
        C2003az a = C2003az.mo18481a();
        List a2 = a.mo18483a(str);
        if (a2.isEmpty()) {
            sb = new StringBuilder();
            str3 = "open channel should be called first before sending a packet, pkg=";
        } else {
            glVar.mo17736o(str);
            str = glVar.mo17727k();
            if (TextUtils.isEmpty(str)) {
                str = (String) a2.get(0);
                glVar.mo17730l(str);
            }
            C2003az.C2005b a3 = a.mo18482a(str, glVar.mo17731m());
            if (!mo18423c()) {
                sb = new StringBuilder();
                str3 = "drop a packet as the channel is not connected, chid=";
            } else if (a3 == null || a3.f3736a != C2003az.C2009c.binded) {
                sb = new StringBuilder();
                str3 = "drop a packet as the channel is not opened, chid=";
            } else if (TextUtils.equals(str2, a3.f3750i)) {
                return glVar;
            } else {
                sb = new StringBuilder();
                sb.append("invalid session. ");
                sb.append(str2);
                C1524b.m2141a(sb.toString());
                return null;
            }
        }
        sb.append(str3);
        sb.append(str);
        C1524b.m2141a(sb.toString());
        return null;
    }

    /* renamed from: a */
    private C2003az.C2005b m4764a(String str, Intent intent) {
        C2003az.C2005b a = C2003az.mo18481a().mo18482a(str, intent.getStringExtra(C2014bd.f3797p));
        if (a == null) {
            a = new C2003az.C2005b(this);
        }
        a.f3748g = intent.getStringExtra(C2014bd.f3800s);
        a.f3742b = intent.getStringExtra(C2014bd.f3797p);
        a.f3744c = intent.getStringExtra(C2014bd.f3802u);
        a.f3738a = intent.getStringExtra(C2014bd.f3769A);
        a.f3746e = intent.getStringExtra(C2014bd.f3806y);
        a.f3747f = intent.getStringExtra(C2014bd.f3807z);
        a.f3740a = intent.getBooleanExtra(C2014bd.f3805x, false);
        a.f3749h = intent.getStringExtra(C2014bd.f3804w);
        a.f3750i = intent.getStringExtra(C2014bd.f3773E);
        a.f3745d = intent.getStringExtra(C2014bd.f3803v);
        a.f3737a = this.f3609a;
        a.mo18492a((Messenger) intent.getParcelableExtra(C2014bd.f3777I));
        a.f3730a = getApplicationContext();
        C2003az.mo18481a().mo18487a(a);
        return a;
    }

    /* renamed from: a */
    private String mo18408a() {
        String a = C1938m.m4715a("ro.miui.region");
        return TextUtils.isEmpty(a) ? C1938m.m4715a("ro.product.locale.region") : a;
    }

    /* renamed from: a */
    private void m4768a(BroadcastReceiver broadcastReceiver) {
        if (broadcastReceiver != null) {
            try {
                unregisterReceiver(broadcastReceiver);
            } catch (IllegalArgumentException e) {
                C1524b.m2155a((Throwable) e);
            }
        }
    }

    /* renamed from: a */
    private void m4769a(Intent intent) {
        Bundle extras;
        if (intent != null && (extras = intent.getExtras()) != null) {
            C2061i.m5236a(getApplicationContext()).mo18533a(extras.getString("digest"));
        }
    }

    /* renamed from: a */
    private void m4770a(Intent intent, int i) {
        byte[] byteArrayExtra = intent.getByteArrayExtra("mipush_payload");
        boolean booleanExtra = intent.getBooleanExtra("com.xiaomi.mipush.MESSAGE_CACHE", true);
        C1894in inVar = new C1894in();
        try {
            C1905iy.m4542a(inVar, byteArrayExtra);
            C1618ak.m2518a(getApplicationContext()).mo17215a((C1618ak.C1619a) new C2010b(inVar, new WeakReference(this), booleanExtra), i);
        } catch (C1913je unused) {
            C1524b.m2160d("aw_ping : send help app ping  error");
        }
    }

    /* renamed from: a */
    private void m4773a(C1966a aVar) {
        String str;
        String str2;
        if (aVar == null || !TextUtils.isEmpty(aVar.mo18438b()) || TextUtils.isEmpty(aVar.mo18436a())) {
            str = "no need to check country code";
        } else {
            String a = "com.xiaomi.xmsf".equals(getPackageName()) ? mo18408a() : C1938m.m4725b();
            if (!TextUtils.isEmpty(a)) {
                String name = C1938m.m4715a(a).name();
                if (TextUtils.equals(name, aVar.mo18436a())) {
                    aVar.mo18439b(a);
                    str2 = "update country code";
                } else {
                    str2 = "not update country code, because not equals " + name;
                }
                C1524b.m2141a(str2);
                return;
            }
            str = "check no country code";
        }
        C1524b.m2158b(str);
    }

    /* renamed from: a */
    private static void m4774a(String str) {
        String str2;
        if (C1941p.China.name().equals(str)) {
            C1702cu.m2915a("cn.app.chat.xiaomi.net", "cn.app.chat.xiaomi.net");
            C1702cu.m2915a("cn.app.chat.xiaomi.net", "111.13.141.211:443");
            C1702cu.m2915a("cn.app.chat.xiaomi.net", "39.156.81.172:443");
            C1702cu.m2915a("cn.app.chat.xiaomi.net", "111.202.1.250:443");
            C1702cu.m2915a("cn.app.chat.xiaomi.net", "123.125.102.213:443");
            C1702cu.m2915a("resolver.msg.xiaomi.net", "111.13.142.153:443");
            C1702cu.m2915a("resolver.msg.xiaomi.net", "111.202.1.252:443");
            return;
        }
        if (C1941p.Global.name().equals(str)) {
            str2 = "app.chat.global.xiaomi.net";
        } else if (C1941p.Europe.name().equals(str)) {
            str2 = "fr.app.chat.global.xiaomi.net";
        } else {
            if (C1941p.Russia.name().equals(str)) {
                C1702cu.m2915a("ru.app.chat.global.xiaomi.net", "ru.app.chat.global.xiaomi.net");
            } else if (C1941p.India.name().equals(str)) {
                C1702cu.m2915a("ru.app.chat.global.xiaomi.net", "idmb.app.chat.global.xiaomi.net");
            } else {
                return;
            }
            C1702cu.m2915a("resolver.msg.global.xiaomi.net", "161.117.97.14:443");
            C1702cu.m2915a("resolver.msg.global.xiaomi.net", "161.117.180.178:443");
        }
        C1702cu.m2915a(str2, str2);
        C1702cu.m2915a("resolver.msg.global.xiaomi.net", "161.117.97.14:443");
        C1702cu.m2915a("resolver.msg.global.xiaomi.net", "161.117.180.178:443");
    }

    /* renamed from: a */
    private void m4775a(String str, int i) {
        Collection<C2003az.C2005b> a = C2003az.mo18481a().mo18483a(str);
        if (a != null) {
            for (C2003az.C2005b bVar : a) {
                if (bVar != null) {
                    mo18412a((C1956i) new C1964q(bVar, i, (String) null, (String) null));
                }
            }
        }
        C2003az.mo18481a().mo18483a(str);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public boolean m4776a(Context context) {
        try {
            C1628aq.m2550a();
            for (int i = 100; i > 0; i--) {
                if (C1653bi.m2686c(context)) {
                    C1524b.m2141a("network connectivity ok.");
                    return true;
                }
                try {
                    Thread.sleep(100);
                } catch (Exception unused) {
                }
            }
            return false;
        } catch (Exception unused2) {
            return true;
        }
    }

    /* renamed from: a */
    private boolean m4779a(String str, Intent intent) {
        C2003az.C2005b a = C2003az.mo18481a().mo18482a(str, intent.getStringExtra(C2014bd.f3797p));
        boolean z = false;
        if (a == null || str == null) {
            return false;
        }
        String stringExtra = intent.getStringExtra(C2014bd.f3773E);
        String stringExtra2 = intent.getStringExtra(C2014bd.f3804w);
        if (!TextUtils.isEmpty(a.f3750i) && !TextUtils.equals(stringExtra, a.f3750i)) {
            C1524b.m2141a("session changed. old session=" + a.f3750i + ", new session=" + stringExtra + " chid = " + str);
            z = true;
        }
        if (stringExtra2.equals(a.f3749h)) {
            return z;
        }
        C1524b.m2141a("security changed. chid = " + str + " sechash = " + C1662bn.m2724a(stringExtra2));
        return true;
    }

    /* renamed from: a */
    private int[] m4780a() {
        String[] split;
        String a = C1995at.m5047a(getApplicationContext()).mo18467a(C1873ht.FallDownTimeRange.mo17806a(), "");
        if (!TextUtils.isEmpty(a) && (split = a.split(Constants.ACCEPT_TIME_SEPARATOR_SP)) != null && split.length >= 2) {
            int[] iArr = new int[2];
            try {
                iArr[0] = Integer.valueOf(split[0]).intValue();
                iArr[1] = Integer.valueOf(split[1]).intValue();
                if (iArr[0] < 0 || iArr[0] > 23 || iArr[1] < 0 || iArr[1] > 23 || iArr[0] == iArr[1]) {
                    return null;
                }
                return iArr;
            } catch (NumberFormatException e) {
                C1524b.m2160d("parse falldown time range failure: " + e);
            }
        }
        return null;
    }

    /* renamed from: b */
    private String mo18421b() {
        String str;
        C1628aq.m2550a();
        long elapsedRealtime = SystemClock.elapsedRealtime();
        Object obj = new Object();
        String str2 = null;
        if ("com.xiaomi.xmsf".equals(getPackageName())) {
            C2019bg a = C2019bg.m5124a(this);
            str = null;
            while (true) {
                if (!TextUtils.isEmpty(str) && a.mo18500a() != 0) {
                    break;
                }
                if (TextUtils.isEmpty(str)) {
                    str = mo18408a();
                }
                try {
                    synchronized (obj) {
                        obj.wait(100);
                    }
                } catch (InterruptedException unused) {
                }
            }
        } else {
            str = C1938m.m4725b();
        }
        if (!TextUtils.isEmpty(str)) {
            C1966a.m4862a(getApplicationContext()).mo18439b(str);
            str2 = C1938m.m4715a(str).name();
        }
        C1524b.m2141a("wait region :" + str2 + " cost = " + (SystemClock.elapsedRealtime() - elapsedRealtime));
        return str2;
    }

    /* renamed from: b */
    private void m4782b(Intent intent) {
        long j;
        String stringExtra = intent.getStringExtra(C2014bd.f3769A);
        String stringExtra2 = intent.getStringExtra(C2014bd.f3773E);
        Bundle bundleExtra = intent.getBundleExtra("ext_packet");
        C2003az a = C2003az.mo18481a();
        C1793fj fjVar = null;
        if (bundleExtra != null) {
            C1829gk gkVar = (C1829gk) m4762a((C1830gl) new C1829gk(bundleExtra), stringExtra, stringExtra2);
            if (gkVar != null) {
                fjVar = C1793fj.m3532a((C1830gl) gkVar, a.mo18482a(gkVar.mo17727k(), gkVar.mo17731m()).f3749h);
            } else {
                return;
            }
        } else {
            byte[] byteArrayExtra = intent.getByteArrayExtra("ext_raw_packet");
            if (byteArrayExtra != null) {
                try {
                    j = Long.parseLong(intent.getStringExtra(C2014bd.f3797p));
                } catch (NumberFormatException unused) {
                    j = 0;
                }
                String stringExtra3 = intent.getStringExtra(C2014bd.f3798q);
                String stringExtra4 = intent.getStringExtra(C2014bd.f3799r);
                String stringExtra5 = intent.getStringExtra("ext_chid");
                C2003az.C2005b a2 = a.mo18482a(stringExtra5, String.valueOf(j));
                if (a2 != null) {
                    C1793fj fjVar2 = new C1793fj();
                    try {
                        fjVar2.mo17617a(Integer.parseInt(stringExtra5));
                    } catch (NumberFormatException unused2) {
                    }
                    fjVar2.mo17620a("SECMSG", (String) null);
                    if (TextUtils.isEmpty(stringExtra3)) {
                        stringExtra3 = "xiaomi.com";
                    }
                    fjVar2.mo17618a(j, stringExtra3, stringExtra4);
                    fjVar2.mo17619a(intent.getStringExtra("ext_pkt_id"));
                    fjVar2.mo17622a(byteArrayExtra, a2.f3749h);
                    C1524b.m2141a("send a message: chid=" + stringExtra5 + ", packetId=" + intent.getStringExtra("ext_pkt_id"));
                    fjVar = fjVar2;
                }
            }
        }
        if (fjVar != null) {
            m4788c((C1956i) new C2025bm(this, fjVar));
        }
    }

    /* renamed from: b */
    private void m4784b(boolean z) {
        this.f3597a = System.currentTimeMillis();
        if (mo18423c()) {
            if (C1653bi.m2685b(this)) {
                m4788c((C1956i) new C1960m(z));
                return;
            }
            m4788c((C1956i) new C1953f(17, (Exception) null));
        }
        mo18418a(true);
    }

    /* renamed from: c */
    private void mo18423c() {
        String str;
        C1966a a = C1966a.m4862a(getApplicationContext());
        String a2 = a.mo18436a();
        C1524b.m2141a("region of cache is " + a2);
        if (TextUtils.isEmpty(a2)) {
            a2 = mo18421b();
        } else {
            m4773a(a);
        }
        if (!TextUtils.isEmpty(a2)) {
            this.f3612a = a2;
            a.mo18437a(a2);
            if (C1941p.Global.name().equals(this.f3612a)) {
                str = "app.chat.global.xiaomi.net";
            } else if (C1941p.Europe.name().equals(this.f3612a)) {
                str = "fr.app.chat.global.xiaomi.net";
            } else if (C1941p.Russia.name().equals(this.f3612a)) {
                str = "ru.app.chat.global.xiaomi.net";
            } else if (C1941p.India.name().equals(this.f3612a)) {
                str = "idmb.app.chat.global.xiaomi.net";
            }
            C1811fv.m3642a(str);
        } else {
            this.f3612a = C1941p.China.name();
        }
        if (C1941p.China.name().equals(this.f3612a)) {
            C1811fv.m3642a("cn.app.chat.xiaomi.net");
        }
        m4774a(this.f3612a);
        if (m4800h()) {
            C2050ci ciVar = new C2050ci(this, 11);
            mo18412a((C1956i) ciVar);
            C2072o.m5309a((C2072o.C2073a) new C2051cj(this, ciVar));
        }
        try {
            if (C2087u.m5371a()) {
                this.f3609a.mo18523a((Context) this);
            }
        } catch (Exception e) {
            C1524b.m2155a((Throwable) e);
        }
    }

    /* renamed from: c */
    private void m4787c(Intent intent) {
        String stringExtra = intent.getStringExtra(C2014bd.f3769A);
        String stringExtra2 = intent.getStringExtra(C2014bd.f3773E);
        Parcelable[] parcelableArrayExtra = intent.getParcelableArrayExtra("ext_packets");
        C1829gk[] gkVarArr = new C1829gk[parcelableArrayExtra.length];
        intent.getBooleanExtra("ext_encrypt", true);
        int i = 0;
        while (i < parcelableArrayExtra.length) {
            gkVarArr[i] = new C1829gk((Bundle) parcelableArrayExtra[i]);
            gkVarArr[i] = (C1829gk) m4762a((C1830gl) gkVarArr[i], stringExtra, stringExtra2);
            if (gkVarArr[i] != null) {
                i++;
            } else {
                return;
            }
        }
        C2003az a = C2003az.mo18481a();
        C1793fj[] fjVarArr = new C1793fj[gkVarArr.length];
        for (int i2 = 0; i2 < gkVarArr.length; i2++) {
            C1829gk gkVar = gkVarArr[i2];
            fjVarArr[i2] = C1793fj.m3532a((C1830gl) gkVar, a.mo18482a(gkVar.mo17727k(), gkVar.mo17731m()).f3749h);
        }
        m4788c((C1956i) new C2041c(this, fjVarArr));
    }

    /* renamed from: c */
    private void m4788c(C1956i iVar) {
        this.f3610a.mo18540a((C2062j.C2064b) iVar);
    }

    /* renamed from: c */
    private void m4790c(boolean z) {
        try {
            if (!C2087u.m5371a()) {
                return;
            }
            if (z) {
                sendBroadcast(new Intent("miui.intent.action.NETWORK_CONNECTED"));
                for (C1983al a : (C1983al[]) this.f3614a.toArray(new C1983al[0])) {
                    a.mo18449a();
                }
                return;
            }
            sendBroadcast(new Intent("miui.intent.action.NETWORK_BLOCKED"));
        } catch (Exception e) {
            C1524b.m2155a((Throwable) e);
        }
    }

    /* renamed from: d */
    private void mo18424d() {
        NetworkInfo networkInfo;
        try {
            networkInfo = ((ConnectivityManager) getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (Exception e) {
            C1524b.m2155a((Throwable) e);
            networkInfo = null;
        }
        C2061i.m5236a(getApplicationContext()).mo18532a(networkInfo);
        if (networkInfo != null) {
            StringBuilder sb = new StringBuilder();
            sb.append("network changed,");
            sb.append("[" + "type: " + networkInfo.getTypeName() + "[" + networkInfo.getSubtypeName() + "], state: " + networkInfo.getState() + "/" + networkInfo.getDetailedState());
            C1524b.m2141a(sb.toString());
            NetworkInfo.State state = networkInfo.getState();
            if (state == NetworkInfo.State.SUSPENDED || state == NetworkInfo.State.UNKNOWN) {
                return;
            }
        } else {
            C1524b.m2141a("network changed, no active network");
        }
        if (C1857hg.mo17753a() != null) {
            C1857hg.mo17753a().mo17752a();
        }
        C1847gz.m3809a((Context) this);
        this.f3600a.mo17667d();
        if (C1653bi.m2685b(this)) {
            if (mo18423c() && m4793e()) {
                m4784b(false);
            }
            if (!mo18423c() && !mo18424d()) {
                this.f3610a.mo18538a(1);
                mo18412a((C1956i) new C1951d());
            }
            C1722dk.m3009a((Context) this).mo17389a();
        } else {
            mo18412a((C1956i) new C1953f(2, (Exception) null));
        }
        m4793e();
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v10, resolved type: com.xiaomi.push.service.XMPushService$n} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v11, resolved type: com.xiaomi.push.service.XMPushService$a} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v44, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v50, resolved type: com.xiaomi.push.service.az$b} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v88, resolved type: com.xiaomi.push.service.XMPushService$o} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v102, resolved type: com.xiaomi.push.service.ck} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v103, resolved type: com.xiaomi.push.service.ck} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v159, resolved type: com.xiaomi.push.service.ck} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v104, resolved type: com.xiaomi.push.service.ck} */
    /* JADX WARNING: type inference failed for: r12v14, types: [com.xiaomi.push.service.XMPushService$i] */
    /* JADX WARNING: type inference failed for: r2v8 */
    /* JADX WARNING: type inference failed for: r2v46 */
    /* JADX WARNING: type inference failed for: r2v63 */
    /* JADX WARNING: type inference failed for: r2v64 */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:147:0x040b  */
    /* JADX WARNING: Removed duplicated region for block: B:158:0x046a  */
    /* JADX WARNING: Removed duplicated region for block: B:338:? A[RETURN, SYNTHETIC] */
    /* renamed from: d */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void m4792d(android.content.Intent r12) {
        /*
            r11 = this;
            com.xiaomi.push.service.az r0 = com.xiaomi.push.service.C2003az.mo18481a()
            java.lang.String r1 = com.xiaomi.push.service.C2014bd.f3785d
            java.lang.String r2 = r12.getAction()
            boolean r1 = r1.equalsIgnoreCase(r2)
            r2 = 2
            r3 = 1
            r4 = 0
            if (r1 != 0) goto L_0x0817
            java.lang.String r1 = com.xiaomi.push.service.C2014bd.f3791j
            java.lang.String r5 = r12.getAction()
            boolean r1 = r1.equalsIgnoreCase(r5)
            if (r1 == 0) goto L_0x0021
            goto L_0x0817
        L_0x0021:
            java.lang.String r1 = com.xiaomi.push.service.C2014bd.f3790i
            java.lang.String r5 = r12.getAction()
            boolean r1 = r1.equalsIgnoreCase(r5)
            if (r1 == 0) goto L_0x0091
            java.lang.String r1 = com.xiaomi.push.service.C2014bd.f3769A
            java.lang.String r1 = r12.getStringExtra(r1)
            java.lang.String r3 = com.xiaomi.push.service.C2014bd.f3800s
            java.lang.String r5 = r12.getStringExtra(r3)
            java.lang.String r3 = com.xiaomi.push.service.C2014bd.f3797p
            java.lang.String r6 = r12.getStringExtra(r3)
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            java.lang.String r3 = "Service called close channel chid = "
            r12.append(r3)
            r12.append(r5)
            java.lang.String r3 = " res = "
            r12.append(r3)
            java.lang.String r3 = com.xiaomi.push.service.C2003az.C2005b.m5091a((java.lang.String) r6)
            r12.append(r3)
            java.lang.String r12 = r12.toString()
            com.xiaomi.channel.commonutils.logger.C1524b.m2141a((java.lang.String) r12)
            boolean r12 = android.text.TextUtils.isEmpty(r5)
            if (r12 == 0) goto L_0x007d
            java.util.List r12 = r0.mo18483a((java.lang.String) r1)
            java.util.Iterator r12 = r12.iterator()
        L_0x006d:
            boolean r0 = r12.hasNext()
            if (r0 == 0) goto L_0x0893
            java.lang.Object r0 = r12.next()
            java.lang.String r0 = (java.lang.String) r0
            r11.m4775a((java.lang.String) r0, (int) r2)
            goto L_0x006d
        L_0x007d:
            boolean r12 = android.text.TextUtils.isEmpty(r6)
            if (r12 == 0) goto L_0x0088
            r11.m4775a((java.lang.String) r5, (int) r2)
            goto L_0x0893
        L_0x0088:
            r7 = 2
            r8 = 0
            r9 = 0
            r4 = r11
            r4.mo18416a(r5, r6, r7, r8, r9)
            goto L_0x0893
        L_0x0091:
            java.lang.String r1 = com.xiaomi.push.service.C2014bd.f3786e
            java.lang.String r2 = r12.getAction()
            boolean r1 = r1.equalsIgnoreCase(r2)
            if (r1 == 0) goto L_0x00a2
            r11.m4782b((android.content.Intent) r12)
            goto L_0x0893
        L_0x00a2:
            java.lang.String r1 = com.xiaomi.push.service.C2014bd.f3788g
            java.lang.String r2 = r12.getAction()
            boolean r1 = r1.equalsIgnoreCase(r2)
            if (r1 == 0) goto L_0x00b3
            r11.m4787c((android.content.Intent) r12)
            goto L_0x0893
        L_0x00b3:
            java.lang.String r1 = com.xiaomi.push.service.C2014bd.f3787f
            java.lang.String r2 = r12.getAction()
            boolean r1 = r1.equalsIgnoreCase(r2)
            java.lang.String r2 = "ext_packet"
            if (r1 == 0) goto L_0x00f8
            java.lang.String r1 = com.xiaomi.push.service.C2014bd.f3769A
            java.lang.String r1 = r12.getStringExtra(r1)
            java.lang.String r3 = com.xiaomi.push.service.C2014bd.f3773E
            java.lang.String r3 = r12.getStringExtra(r3)
            android.os.Bundle r12 = r12.getBundleExtra(r2)
            com.xiaomi.push.gj r2 = new com.xiaomi.push.gj
            r2.<init>(r12)
            com.xiaomi.push.gl r12 = r11.m4762a((com.xiaomi.push.C1830gl) r2, (java.lang.String) r1, (java.lang.String) r3)
            if (r12 == 0) goto L_0x0893
            java.lang.String r1 = r12.mo17727k()
            java.lang.String r2 = r12.mo17731m()
            com.xiaomi.push.service.az$b r0 = r0.mo18482a((java.lang.String) r1, (java.lang.String) r2)
            java.lang.String r0 = r0.f3749h
            com.xiaomi.push.fj r12 = com.xiaomi.push.C1793fj.m3532a((com.xiaomi.push.C1830gl) r12, (java.lang.String) r0)
            com.xiaomi.push.service.bm r0 = new com.xiaomi.push.service.bm
            r0.<init>(r11, r12)
        L_0x00f3:
            r11.m4788c((com.xiaomi.push.service.XMPushService.C1956i) r0)
            goto L_0x0893
        L_0x00f8:
            java.lang.String r1 = com.xiaomi.push.service.C2014bd.f3789h
            java.lang.String r5 = r12.getAction()
            boolean r1 = r1.equalsIgnoreCase(r5)
            if (r1 == 0) goto L_0x0137
            java.lang.String r1 = com.xiaomi.push.service.C2014bd.f3769A
            java.lang.String r1 = r12.getStringExtra(r1)
            java.lang.String r3 = com.xiaomi.push.service.C2014bd.f3773E
            java.lang.String r3 = r12.getStringExtra(r3)
            android.os.Bundle r12 = r12.getBundleExtra(r2)
            com.xiaomi.push.gn r2 = new com.xiaomi.push.gn
            r2.<init>((android.os.Bundle) r12)
            com.xiaomi.push.gl r12 = r11.m4762a((com.xiaomi.push.C1830gl) r2, (java.lang.String) r1, (java.lang.String) r3)
            if (r12 == 0) goto L_0x0893
            java.lang.String r1 = r12.mo17727k()
            java.lang.String r2 = r12.mo17731m()
            com.xiaomi.push.service.az$b r0 = r0.mo18482a((java.lang.String) r1, (java.lang.String) r2)
            java.lang.String r0 = r0.f3749h
            com.xiaomi.push.fj r12 = com.xiaomi.push.C1793fj.m3532a((com.xiaomi.push.C1830gl) r12, (java.lang.String) r0)
            com.xiaomi.push.service.bm r0 = new com.xiaomi.push.service.bm
            r0.<init>(r11, r12)
            goto L_0x00f3
        L_0x0137:
            java.lang.String r1 = com.xiaomi.push.service.C2014bd.f3792k
            java.lang.String r2 = r12.getAction()
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x01a0
            java.lang.String r0 = com.xiaomi.push.service.C2014bd.f3800s
            java.lang.String r0 = r12.getStringExtra(r0)
            java.lang.String r1 = com.xiaomi.push.service.C2014bd.f3797p
            java.lang.String r1 = r12.getStringExtra(r1)
            if (r0 == 0) goto L_0x0893
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "request reset connection from chid = "
            r2.append(r3)
            r2.append(r0)
            java.lang.String r2 = r2.toString()
            com.xiaomi.channel.commonutils.logger.C1524b.m2141a((java.lang.String) r2)
            com.xiaomi.push.service.az r2 = com.xiaomi.push.service.C2003az.mo18481a()
            com.xiaomi.push.service.az$b r0 = r2.mo18482a((java.lang.String) r0, (java.lang.String) r1)
            if (r0 == 0) goto L_0x0893
            java.lang.String r1 = r0.f3749h
            java.lang.String r2 = com.xiaomi.push.service.C2014bd.f3804w
            java.lang.String r12 = r12.getStringExtra(r2)
            boolean r12 = r1.equals(r12)
            if (r12 == 0) goto L_0x0893
            com.xiaomi.push.service.az$c r12 = r0.f3736a
            com.xiaomi.push.service.az$c r0 = com.xiaomi.push.service.C2003az.C2009c.binded
            if (r12 != r0) goto L_0x0893
            com.xiaomi.push.fu r12 = r11.mo18408a()
            if (r12 == 0) goto L_0x0196
            long r0 = java.lang.System.currentTimeMillis()
            r2 = 15000(0x3a98, double:7.411E-320)
            long r0 = r0 - r2
            boolean r12 = r12.mo17660a((long) r0)
            if (r12 != 0) goto L_0x0893
        L_0x0196:
            com.xiaomi.push.service.XMPushService$o r12 = new com.xiaomi.push.service.XMPushService$o
            r12.<init>()
        L_0x019b:
            r11.m4788c((com.xiaomi.push.service.XMPushService.C1956i) r12)
            goto L_0x0893
        L_0x01a0:
            java.lang.String r1 = com.xiaomi.push.service.C2014bd.f3793l
            java.lang.String r2 = r12.getAction()
            boolean r1 = r1.equals(r2)
            r2 = 0
            if (r1 == 0) goto L_0x0230
            java.lang.String r1 = com.xiaomi.push.service.C2014bd.f3769A
            java.lang.String r1 = r12.getStringExtra(r1)
            java.util.List r3 = r0.mo18483a((java.lang.String) r1)
            boolean r5 = r3.isEmpty()
            if (r5 == 0) goto L_0x01d2
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            java.lang.String r0 = "open channel should be called first before update info, pkg="
            r12.append(r0)
            r12.append(r1)
            java.lang.String r12 = r12.toString()
        L_0x01ce:
            com.xiaomi.channel.commonutils.logger.C1524b.m2141a((java.lang.String) r12)
            return
        L_0x01d2:
            java.lang.String r1 = com.xiaomi.push.service.C2014bd.f3800s
            java.lang.String r1 = r12.getStringExtra(r1)
            java.lang.String r5 = com.xiaomi.push.service.C2014bd.f3797p
            java.lang.String r5 = r12.getStringExtra(r5)
            boolean r6 = android.text.TextUtils.isEmpty(r1)
            if (r6 == 0) goto L_0x01ea
            java.lang.Object r1 = r3.get(r4)
            java.lang.String r1 = (java.lang.String) r1
        L_0x01ea:
            boolean r3 = android.text.TextUtils.isEmpty(r5)
            if (r3 == 0) goto L_0x0208
            java.util.Collection r0 = r0.mo18483a((java.lang.String) r1)
            if (r0 == 0) goto L_0x020c
            boolean r1 = r0.isEmpty()
            if (r1 != 0) goto L_0x020c
            java.util.Iterator r0 = r0.iterator()
            java.lang.Object r0 = r0.next()
            r2 = r0
            com.xiaomi.push.service.az$b r2 = (com.xiaomi.push.service.C2003az.C2005b) r2
            goto L_0x020c
        L_0x0208:
            com.xiaomi.push.service.az$b r2 = r0.mo18482a((java.lang.String) r1, (java.lang.String) r5)
        L_0x020c:
            if (r2 == 0) goto L_0x0893
            java.lang.String r0 = com.xiaomi.push.service.C2014bd.f3806y
            boolean r0 = r12.hasExtra(r0)
            if (r0 == 0) goto L_0x021e
            java.lang.String r0 = com.xiaomi.push.service.C2014bd.f3806y
            java.lang.String r0 = r12.getStringExtra(r0)
            r2.f3746e = r0
        L_0x021e:
            java.lang.String r0 = com.xiaomi.push.service.C2014bd.f3807z
            boolean r0 = r12.hasExtra(r0)
            if (r0 == 0) goto L_0x0893
            java.lang.String r0 = com.xiaomi.push.service.C2014bd.f3807z
            java.lang.String r12 = r12.getStringExtra(r0)
            r2.f3747f = r12
            goto L_0x0893
        L_0x0230:
            java.lang.String r0 = r12.getAction()
            java.lang.String r1 = "android.intent.action.SCREEN_ON"
            boolean r0 = r1.equals(r0)
            java.lang.String r5 = "android.intent.action.SCREEN_OFF"
            if (r0 != 0) goto L_0x07ce
            java.lang.String r0 = r12.getAction()
            boolean r0 = r5.equals(r0)
            if (r0 == 0) goto L_0x024a
            goto L_0x07ce
        L_0x024a:
            java.lang.String r0 = r12.getAction()
            java.lang.String r1 = "com.xiaomi.mipush.REGISTER_APP"
            boolean r0 = r1.equals(r0)
            java.lang.String r1 = "com.xiaomi.xmsf"
            java.lang.String r5 = "mipush_payload"
            java.lang.String r6 = "mipush_app_package"
            if (r0 == 0) goto L_0x02c8
            android.content.Context r0 = r11.getApplicationContext()
            com.xiaomi.push.service.bg r0 = com.xiaomi.push.service.C2019bg.m5124a(r0)
            boolean r0 = r0.mo18500a()
            if (r0 == 0) goto L_0x028f
            android.content.Context r0 = r11.getApplicationContext()
            com.xiaomi.push.service.bg r0 = com.xiaomi.push.service.C2019bg.m5124a(r0)
            int r0 = r0.mo18500a()
            if (r0 != 0) goto L_0x028f
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "register without being provisioned. "
            r0.append(r1)
            java.lang.String r12 = r12.getStringExtra(r6)
            r0.append(r12)
            java.lang.String r12 = r0.toString()
            goto L_0x01ce
        L_0x028f:
            byte[] r5 = r12.getByteArrayExtra(r5)
            java.lang.String r6 = r12.getStringExtra(r6)
            java.lang.String r0 = "mipush_env_chanage"
            boolean r0 = r12.getBooleanExtra(r0, r4)
            java.lang.String r2 = "mipush_env_type"
            int r3 = r12.getIntExtra(r2, r3)
            com.xiaomi.push.service.p r12 = com.xiaomi.push.service.C2074p.m5312a((android.content.Context) r11)
            r12.mo18559d(r6)
            if (r0 == 0) goto L_0x02c3
            java.lang.String r12 = r11.getPackageName()
            boolean r12 = r1.equals(r12)
            if (r12 != 0) goto L_0x02c3
            com.xiaomi.push.service.ck r12 = new com.xiaomi.push.service.ck
            r2 = 14
            r0 = r12
            r1 = r11
            r4 = r5
            r5 = r6
            r0.<init>(r1, r2, r3, r4, r5)
            goto L_0x019b
        L_0x02c3:
            r11.mo18419a((byte[]) r5, (java.lang.String) r6)
            goto L_0x0893
        L_0x02c8:
            java.lang.String r0 = r12.getAction()
            java.lang.String r7 = "com.xiaomi.mipush.SEND_MESSAGE"
            boolean r0 = r7.equals(r0)
            java.lang.String r7 = "com.xiaomi.mipush.UNREGISTER_APP"
            if (r0 != 0) goto L_0x079d
            java.lang.String r0 = r12.getAction()
            boolean r0 = r7.equals(r0)
            if (r0 == 0) goto L_0x02e2
            goto L_0x079d
        L_0x02e2:
            java.lang.String r0 = com.xiaomi.push.service.C2020bh.f3813a
            java.lang.String r7 = r12.getAction()
            boolean r0 = r0.equals(r7)
            java.lang.String r7 = "pref_registered_pkg_names"
            if (r0 == 0) goto L_0x03c8
            java.lang.String r0 = "uninstall_pkg_name"
            java.lang.String r12 = r12.getStringExtra(r0)
            if (r12 == 0) goto L_0x03c7
            java.lang.String r0 = r12.trim()
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L_0x0304
            goto L_0x03c7
        L_0x0304:
            android.content.pm.PackageManager r0 = r11.getPackageManager()     // Catch:{ NameNotFoundException -> 0x0333 }
            android.content.pm.PackageInfo r0 = r0.getPackageInfo(r12, r4)     // Catch:{ NameNotFoundException -> 0x0333 }
            if (r0 == 0) goto L_0x0331
            android.content.pm.ApplicationInfo r1 = r0.applicationInfo     // Catch:{ NameNotFoundException -> 0x0333 }
            if (r1 == 0) goto L_0x0331
            android.content.pm.ApplicationInfo r0 = r0.applicationInfo     // Catch:{ NameNotFoundException -> 0x0333 }
            int r0 = r0.uid     // Catch:{ NameNotFoundException -> 0x0333 }
            boolean r0 = com.xiaomi.push.C1907j.m4547a((int) r0)     // Catch:{ NameNotFoundException -> 0x0333 }
            if (r0 == 0) goto L_0x0331
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ NameNotFoundException -> 0x0333 }
            r0.<init>()     // Catch:{ NameNotFoundException -> 0x0333 }
            java.lang.String r1 = "xspace's app fake uninstalled "
            r0.append(r1)     // Catch:{ NameNotFoundException -> 0x0333 }
            r0.append(r12)     // Catch:{ NameNotFoundException -> 0x0333 }
            java.lang.String r0 = r0.toString()     // Catch:{ NameNotFoundException -> 0x0333 }
            com.xiaomi.channel.commonutils.logger.C1524b.m2141a((java.lang.String) r0)     // Catch:{ NameNotFoundException -> 0x0333 }
            goto L_0x0334
        L_0x0331:
            r3 = 0
            goto L_0x0334
        L_0x0333:
        L_0x0334:
            java.lang.String r0 = "com.xiaomi.channel"
            boolean r0 = r0.equals(r12)
            if (r0 == 0) goto L_0x0357
            com.xiaomi.push.service.az r0 = com.xiaomi.push.service.C2003az.mo18481a()
            java.lang.String r1 = "1"
            java.util.Collection r0 = r0.mo18483a((java.lang.String) r1)
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L_0x0357
            if (r3 == 0) goto L_0x0357
            java.lang.String r12 = "1"
            r11.m4775a((java.lang.String) r12, (int) r4)
            java.lang.String r12 = "close the miliao channel as the app is uninstalled."
            goto L_0x01ce
        L_0x0357:
            android.content.SharedPreferences r0 = r11.getSharedPreferences(r7, r4)
            java.lang.String r1 = r0.getString(r12, r2)
            boolean r2 = android.text.TextUtils.isEmpty(r1)
            if (r2 != 0) goto L_0x0893
            if (r3 == 0) goto L_0x0893
            android.content.SharedPreferences$Editor r0 = r0.edit()
            r0.remove(r12)
            r0.commit()
            boolean r0 = com.xiaomi.push.service.C1974af.m4934b((android.content.Context) r11, (java.lang.String) r12)
            if (r0 == 0) goto L_0x037a
            com.xiaomi.push.service.C1974af.m4934b((android.content.Context) r11, (java.lang.String) r12)
        L_0x037a:
            com.xiaomi.push.service.C1974af.m4894a((android.content.Context) r11, (java.lang.String) r12)
            boolean r0 = r11.mo18423c()
            if (r0 == 0) goto L_0x0893
            if (r1 == 0) goto L_0x0893
            com.xiaomi.push.ik r0 = com.xiaomi.push.service.C1970ab.m4879a((java.lang.String) r12, (java.lang.String) r1)     // Catch:{ gf -> 0x03a7 }
            com.xiaomi.push.service.C1970ab.m4885a((com.xiaomi.push.service.XMPushService) r11, (com.xiaomi.push.C1891ik) r0)     // Catch:{ gf -> 0x03a7 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ gf -> 0x03a7 }
            r0.<init>()     // Catch:{ gf -> 0x03a7 }
            java.lang.String r1 = "uninstall "
            r0.append(r1)     // Catch:{ gf -> 0x03a7 }
            r0.append(r12)     // Catch:{ gf -> 0x03a7 }
            java.lang.String r12 = " msg sent"
            r0.append(r12)     // Catch:{ gf -> 0x03a7 }
            java.lang.String r12 = r0.toString()     // Catch:{ gf -> 0x03a7 }
            com.xiaomi.channel.commonutils.logger.C1524b.m2141a((java.lang.String) r12)     // Catch:{ gf -> 0x03a7 }
            goto L_0x0893
        L_0x03a7:
            r12 = move-exception
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Fail to send Message: "
            r0.append(r1)
            java.lang.String r1 = r12.getMessage()
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            com.xiaomi.channel.commonutils.logger.C1524b.m2160d(r0)
            r0 = 10
            r11.mo18410a((int) r0, (java.lang.Exception) r12)
            goto L_0x0893
        L_0x03c7:
            return
        L_0x03c8:
            java.lang.String r0 = com.xiaomi.push.service.C2020bh.f3814b
            java.lang.String r8 = r12.getAction()
            boolean r0 = r0.equals(r8)
            if (r0 == 0) goto L_0x046f
            java.lang.String r0 = "data_cleared_pkg_name"
            java.lang.String r12 = r12.getStringExtra(r0)
            boolean r0 = android.text.TextUtils.isEmpty(r12)
            if (r0 == 0) goto L_0x03e1
            return
        L_0x03e1:
            android.content.SharedPreferences r0 = r11.getSharedPreferences(r7, r4)     // Catch:{ all -> 0x03ef }
            if (r0 == 0) goto L_0x0405
            java.lang.String r1 = r0.getString(r12, r2)     // Catch:{ all -> 0x03ed }
            r2 = r1
            goto L_0x0405
        L_0x03ed:
            r1 = move-exception
            goto L_0x03f1
        L_0x03ef:
            r1 = move-exception
            r0 = r2
        L_0x03f1:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "Fail to get sp or appId : "
            r3.append(r4)
            r3.append(r1)
            java.lang.String r1 = r3.toString()
            com.xiaomi.channel.commonutils.logger.C1524b.m2141a((java.lang.String) r1)
        L_0x0405:
            boolean r1 = android.text.TextUtils.isEmpty(r2)
            if (r1 != 0) goto L_0x045d
            android.content.SharedPreferences$Editor r0 = r0.edit()
            r0.remove(r12)
            r0.commit()
            boolean r0 = com.xiaomi.push.service.C1974af.m4934b((android.content.Context) r11, (java.lang.String) r12)
            if (r0 == 0) goto L_0x041e
            com.xiaomi.push.service.C1974af.m4934b((android.content.Context) r11, (java.lang.String) r12)
        L_0x041e:
            com.xiaomi.push.service.C1974af.m4894a((android.content.Context) r11, (java.lang.String) r12)
            boolean r0 = r11.mo18423c()
            if (r0 == 0) goto L_0x045d
            com.xiaomi.push.ik r0 = com.xiaomi.push.service.C1970ab.m4889b(r12, r2)     // Catch:{ gf -> 0x0443 }
            com.xiaomi.push.service.C1970ab.m4885a((com.xiaomi.push.service.XMPushService) r11, (com.xiaomi.push.C1891ik) r0)     // Catch:{ gf -> 0x0443 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ gf -> 0x0443 }
            r0.<init>()     // Catch:{ gf -> 0x0443 }
            java.lang.String r1 = "send app data cleared Message pkgName is : "
            r0.append(r1)     // Catch:{ gf -> 0x0443 }
            r0.append(r12)     // Catch:{ gf -> 0x0443 }
            java.lang.String r0 = r0.toString()     // Catch:{ gf -> 0x0443 }
            com.xiaomi.channel.commonutils.logger.C1524b.m2141a((java.lang.String) r0)     // Catch:{ gf -> 0x0443 }
            goto L_0x045d
        L_0x0443:
            r0 = move-exception
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Fail to send Message: "
            r1.append(r2)
            r1.append(r0)
            java.lang.String r1 = r1.toString()
            com.xiaomi.channel.commonutils.logger.C1524b.m2160d(r1)
            r1 = 10
            r11.mo18410a((int) r1, (java.lang.Exception) r0)
        L_0x045d:
            com.xiaomi.push.service.C1985an.m4971a((android.content.Context) r11, (java.lang.String) r12)
            android.content.Context r0 = r11.getApplicationContext()
            boolean r0 = com.xiaomi.push.C1938m.m4714a((android.content.Context) r0)
            if (r0 == 0) goto L_0x0893
            com.xiaomi.push.service.C1967aa.m4870a((java.lang.String) r12)
            goto L_0x0893
        L_0x046f:
            java.lang.String r0 = r12.getAction()
            java.lang.String r7 = "com.xiaomi.mipush.CLEAR_NOTIFICATION"
            boolean r0 = r7.equals(r0)
            if (r0 == 0) goto L_0x04ad
            java.lang.String r0 = com.xiaomi.push.service.C2014bd.f3769A
            java.lang.String r0 = r12.getStringExtra(r0)
            java.lang.String r1 = com.xiaomi.push.service.C2014bd.f3770B
            r2 = -2
            int r1 = r12.getIntExtra(r1, r2)
            boolean r2 = android.text.TextUtils.isEmpty(r0)
            if (r2 != 0) goto L_0x0893
            r2 = -1
            if (r1 < r2) goto L_0x049c
            java.lang.String r3 = com.xiaomi.push.service.C2014bd.f3771C
            int r12 = r12.getIntExtra(r3, r2)
            com.xiaomi.push.service.C1974af.m4921a((android.content.Context) r11, (java.lang.String) r0, (int) r1, (int) r12)
            goto L_0x0893
        L_0x049c:
            java.lang.String r1 = com.xiaomi.push.service.C2014bd.f3775G
            java.lang.String r1 = r12.getStringExtra(r1)
            java.lang.String r2 = com.xiaomi.push.service.C2014bd.f3776H
            java.lang.String r12 = r12.getStringExtra(r2)
            com.xiaomi.push.service.C1974af.m4923a((android.content.Context) r11, (java.lang.String) r0, (java.lang.String) r1, (java.lang.String) r12)
            goto L_0x0893
        L_0x04ad:
            java.lang.String r0 = r12.getAction()
            java.lang.String r7 = "com.xiaomi.mipush.SET_NOTIFICATION_TYPE"
            boolean r0 = r7.equals(r0)
            if (r0 == 0) goto L_0x051c
            java.lang.String r0 = com.xiaomi.push.service.C2014bd.f3769A
            java.lang.String r0 = r12.getStringExtra(r0)
            java.lang.String r1 = com.xiaomi.push.service.C2014bd.f3774F
            java.lang.String r1 = r12.getStringExtra(r1)
            java.lang.String r2 = com.xiaomi.push.service.C2014bd.f3772D
            boolean r2 = r12.hasExtra(r2)
            if (r2 == 0) goto L_0x04e8
            java.lang.String r2 = com.xiaomi.push.service.C2014bd.f3772D
            int r12 = r12.getIntExtra(r2, r4)
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r0)
            r2.append(r12)
            java.lang.String r2 = r2.toString()
            java.lang.String r2 = com.xiaomi.push.C1662bn.m2725b(r2)
            r3 = 0
            goto L_0x04ed
        L_0x04e8:
            java.lang.String r2 = com.xiaomi.push.C1662bn.m2725b(r0)
            r12 = 0
        L_0x04ed:
            boolean r4 = android.text.TextUtils.isEmpty(r0)
            if (r4 != 0) goto L_0x0506
            boolean r1 = android.text.TextUtils.equals(r1, r2)
            if (r1 != 0) goto L_0x04fa
            goto L_0x0506
        L_0x04fa:
            if (r3 == 0) goto L_0x0501
            com.xiaomi.push.service.C1974af.m4934b((android.content.Context) r11, (java.lang.String) r0)
            goto L_0x0893
        L_0x0501:
            com.xiaomi.push.service.C1974af.m4940b(r11, r0, r12)
            goto L_0x0893
        L_0x0506:
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            java.lang.String r1 = "invalid notification for "
            r12.append(r1)
            r12.append(r0)
            java.lang.String r12 = r12.toString()
        L_0x0517:
            com.xiaomi.channel.commonutils.logger.C1524b.m2160d(r12)
            goto L_0x0893
        L_0x051c:
            java.lang.String r0 = r12.getAction()
            java.lang.String r7 = "com.xiaomi.mipush.DISABLE_PUSH"
            boolean r0 = r7.equals(r0)
            if (r0 == 0) goto L_0x0550
            java.lang.String r12 = r12.getStringExtra(r6)
            boolean r0 = android.text.TextUtils.isEmpty(r12)
            if (r0 != 0) goto L_0x0539
            com.xiaomi.push.service.p r0 = com.xiaomi.push.service.C2074p.m5312a((android.content.Context) r11)
            r0.mo18557b((java.lang.String) r12)
        L_0x0539:
            java.lang.String r12 = r11.getPackageName()
            boolean r12 = r1.equals(r12)
            if (r12 != 0) goto L_0x0893
            r12 = 19
            r11.mo18410a((int) r12, (java.lang.Exception) r2)
            r11.m4793e()
            r11.stopSelf()
            goto L_0x0893
        L_0x0550:
            java.lang.String r0 = r12.getAction()
            java.lang.String r2 = "com.xiaomi.mipush.DISABLE_PUSH_MESSAGE"
            boolean r0 = r2.equals(r0)
            java.lang.String r2 = "com.xiaomi.mipush.ENABLE_PUSH_MESSAGE"
            if (r0 != 0) goto L_0x0721
            java.lang.String r0 = r12.getAction()
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x056a
            goto L_0x0721
        L_0x056a:
            java.lang.String r0 = r12.getAction()
            java.lang.String r2 = "com.xiaomi.mipush.SEND_TINYDATA"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x0595
            java.lang.String r0 = r12.getStringExtra(r6)
            byte[] r12 = r12.getByteArrayExtra(r5)
            com.xiaomi.push.hs r1 = new com.xiaomi.push.hs
            r1.<init>()
            com.xiaomi.push.C1905iy.m4542a(r1, (byte[]) r12)     // Catch:{ je -> 0x058f }
            com.xiaomi.push.hm r12 = com.xiaomi.push.C1866hm.m3887a(r11)     // Catch:{ je -> 0x058f }
            r12.mo17763a((com.xiaomi.push.C1872hs) r1, (java.lang.String) r0)     // Catch:{ je -> 0x058f }
            goto L_0x0893
        L_0x058f:
            r12 = move-exception
            com.xiaomi.channel.commonutils.logger.C1524b.m2155a((java.lang.Throwable) r12)
            goto L_0x0893
        L_0x0595:
            java.lang.String r0 = r12.getAction()
            java.lang.String r2 = "com.xiaomi.push.timer"
            boolean r0 = r2.equalsIgnoreCase(r0)
            if (r0 == 0) goto L_0x05c0
            java.lang.String r12 = "Service called on timer"
            com.xiaomi.channel.commonutils.logger.C1524b.m2141a((java.lang.String) r12)
            boolean r12 = r11.m4802i()
            if (r12 == 0) goto L_0x05b6
            boolean r12 = com.xiaomi.push.C1783fa.m3471a()
            if (r12 == 0) goto L_0x0893
            java.lang.String r12 = "enter falldown mode, stop alarm"
            goto L_0x080f
        L_0x05b6:
            com.xiaomi.push.C1783fa.m3474a((boolean) r4)
            boolean r12 = r11.m4793e()
            if (r12 == 0) goto L_0x0893
            goto L_0x05d7
        L_0x05c0:
            java.lang.String r0 = r12.getAction()
            java.lang.String r2 = "com.xiaomi.push.check_alive"
            boolean r0 = r2.equalsIgnoreCase(r0)
            if (r0 == 0) goto L_0x05dc
            java.lang.String r12 = "Service called on check alive."
            com.xiaomi.channel.commonutils.logger.C1524b.m2141a((java.lang.String) r12)
            boolean r12 = r11.m4793e()
            if (r12 == 0) goto L_0x0893
        L_0x05d7:
            r11.m4784b((boolean) r4)
            goto L_0x0893
        L_0x05dc:
            java.lang.String r0 = r12.getAction()
            java.lang.String r2 = "com.xiaomi.mipush.thirdparty"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x060d
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "on thirdpart push :"
            r0.append(r1)
            java.lang.String r1 = "com.xiaomi.mipush.thirdparty_DESC"
            java.lang.String r1 = r12.getStringExtra(r1)
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            com.xiaomi.channel.commonutils.logger.C1524b.m2141a((java.lang.String) r0)
            java.lang.String r0 = "com.xiaomi.mipush.thirdparty_LEVEL"
            int r12 = r12.getIntExtra(r0, r4)
            com.xiaomi.push.C1783fa.m3473a(r11, r12)
            goto L_0x0893
        L_0x060d:
            java.lang.String r0 = r12.getAction()
            java.lang.String r2 = "android.net.conn.CONNECTIVITY_CHANGE"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x061e
            r11.mo18424d()
            goto L_0x0893
        L_0x061e:
            java.lang.String r0 = r12.getAction()
            java.lang.String r2 = "miui.net.wifi.DIGEST_INFORMATION_CHANGED"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x062f
            r11.m4769a((android.content.Intent) r12)
            goto L_0x0893
        L_0x062f:
            java.lang.String r0 = r12.getAction()
            java.lang.String r2 = "action_cr_config"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x06b9
            java.lang.String r0 = "action_cr_event_switch"
            boolean r0 = r12.getBooleanExtra(r0, r4)
            r5 = 86400(0x15180, double:4.26873E-319)
            java.lang.String r2 = "action_cr_event_frequency"
            long r5 = r12.getLongExtra(r2, r5)
            java.lang.String r2 = "action_cr_perf_switch"
            boolean r2 = r12.getBooleanExtra(r2, r4)
            r7 = 86400(0x15180, double:4.26873E-319)
            java.lang.String r4 = "action_cr_perf_frequency"
            long r7 = r12.getLongExtra(r4, r7)
            java.lang.String r4 = "action_cr_event_en"
            boolean r3 = r12.getBooleanExtra(r4, r3)
            r9 = 1048576(0x100000, double:5.180654E-318)
            java.lang.String r4 = "action_cr_max_file_size"
            long r9 = r12.getLongExtra(r4, r9)
            com.xiaomi.clientreport.data.Config$Builder r12 = com.xiaomi.clientreport.data.Config.getBuilder()
            com.xiaomi.clientreport.data.Config$Builder r12 = r12.setEventUploadSwitchOpen(r0)
            com.xiaomi.clientreport.data.Config$Builder r12 = r12.setEventUploadFrequency(r5)
            com.xiaomi.clientreport.data.Config$Builder r12 = r12.setPerfUploadSwitchOpen(r2)
            com.xiaomi.clientreport.data.Config$Builder r12 = r12.setPerfUploadFrequency(r7)
            android.content.Context r0 = r11.getApplicationContext()
            java.lang.String r0 = com.xiaomi.push.C1667bs.m2746a((android.content.Context) r0)
            com.xiaomi.clientreport.data.Config$Builder r12 = r12.setAESKey(r0)
            com.xiaomi.clientreport.data.Config$Builder r12 = r12.setEventEncrypted(r3)
            com.xiaomi.clientreport.data.Config$Builder r12 = r12.setMaxFileLength(r9)
            android.content.Context r0 = r11.getApplicationContext()
            com.xiaomi.clientreport.data.Config r12 = r12.build(r0)
            java.lang.String r0 = r11.getPackageName()
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x0893
            r0 = 0
            int r2 = (r5 > r0 ? 1 : (r5 == r0 ? 0 : -1))
            if (r2 <= 0) goto L_0x0893
            int r2 = (r7 > r0 ? 1 : (r7 == r0 ? 0 : -1))
            if (r2 <= 0) goto L_0x0893
            int r2 = (r9 > r0 ? 1 : (r9 == r0 ? 0 : -1))
            if (r2 <= 0) goto L_0x0893
            android.content.Context r0 = r11.getApplicationContext()
            com.xiaomi.push.C1774et.m3400a((android.content.Context) r0, (com.xiaomi.clientreport.data.Config) r12)
            goto L_0x0893
        L_0x06b9:
            java.lang.String r0 = r12.getAction()
            java.lang.String r2 = "action_help_ping"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x0710
            java.lang.String r0 = "extra_help_ping_switch"
            boolean r0 = r12.getBooleanExtra(r0, r4)
            java.lang.String r2 = "extra_help_ping_frequency"
            int r2 = r12.getIntExtra(r2, r4)
            if (r2 < 0) goto L_0x06de
            r3 = 30
            if (r2 >= r3) goto L_0x06de
            java.lang.String r2 = "aw_ping: frquency need > 30s."
            com.xiaomi.channel.commonutils.logger.C1524b.m2159c(r2)
            r2 = 30
        L_0x06de:
            if (r2 >= 0) goto L_0x06e1
            r0 = 0
        L_0x06e1:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "aw_ping: receive a aw_ping message. switch: "
            r3.append(r4)
            r3.append(r0)
            java.lang.String r4 = " frequency: "
            r3.append(r4)
            r3.append(r2)
            java.lang.String r3 = r3.toString()
            com.xiaomi.channel.commonutils.logger.C1524b.m2141a((java.lang.String) r3)
            if (r0 == 0) goto L_0x0893
            if (r2 <= 0) goto L_0x0893
            java.lang.String r0 = r11.getPackageName()
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x0893
            r11.m4770a((android.content.Intent) r12, (int) r2)
            goto L_0x0893
        L_0x0710:
            java.lang.String r0 = r12.getAction()
            java.lang.String r1 = "action_aw_app_logic"
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L_0x0893
            r11.m4794e(r12)
            goto L_0x0893
        L_0x0721:
            java.lang.String r0 = r12.getStringExtra(r6)
            byte[] r8 = r12.getByteArrayExtra(r5)
            java.lang.String r1 = "mipush_app_id"
            java.lang.String r6 = r12.getStringExtra(r1)
            java.lang.String r1 = "mipush_app_token"
            java.lang.String r7 = r12.getStringExtra(r1)
            java.lang.String r1 = r12.getAction()
            java.lang.String r3 = "com.xiaomi.mipush.DISABLE_PUSH_MESSAGE"
            boolean r1 = r3.equals(r1)
            if (r1 == 0) goto L_0x0748
            com.xiaomi.push.service.p r1 = com.xiaomi.push.service.C2074p.m5312a((android.content.Context) r11)
            r1.mo18558c((java.lang.String) r0)
        L_0x0748:
            java.lang.String r1 = r12.getAction()
            boolean r1 = r2.equals(r1)
            if (r1 == 0) goto L_0x0760
            com.xiaomi.push.service.p r1 = com.xiaomi.push.service.C2074p.m5312a((android.content.Context) r11)
            r1.mo18560e(r0)
            com.xiaomi.push.service.p r1 = com.xiaomi.push.service.C2074p.m5312a((android.content.Context) r11)
            r1.mo18561f(r0)
        L_0x0760:
            if (r8 != 0) goto L_0x076c
            r12 = 70000003(0x42c1d83, float:2.0232054E-36)
            java.lang.String r1 = "null payload"
            com.xiaomi.push.service.C2076r.m5325a(r11, r0, r8, r12, r1)
            goto L_0x0893
        L_0x076c:
            com.xiaomi.push.service.C2076r.m5329b(r0, r8)
            com.xiaomi.push.service.q r1 = new com.xiaomi.push.service.q
            r3 = r1
            r4 = r11
            r5 = r0
            r3.<init>(r4, r5, r6, r7, r8)
            r11.mo18412a((com.xiaomi.push.service.XMPushService.C1956i) r1)
            java.lang.String r12 = r12.getAction()
            boolean r12 = r2.equals(r12)
            if (r12 == 0) goto L_0x0893
            com.xiaomi.push.service.XMPushService$e r12 = r11.f3604a
            if (r12 != 0) goto L_0x0893
            com.xiaomi.push.service.XMPushService$e r12 = new com.xiaomi.push.service.XMPushService$e
            r12.<init>()
            r11.f3604a = r12
            android.content.IntentFilter r12 = new android.content.IntentFilter
            java.lang.String r0 = "android.net.conn.CONNECTIVITY_CHANGE"
            r12.<init>(r0)
            com.xiaomi.push.service.XMPushService$e r0 = r11.f3604a
            r11.registerReceiver(r0, r12)
            goto L_0x0893
        L_0x079d:
            java.lang.String r0 = r12.getStringExtra(r6)
            byte[] r1 = r12.getByteArrayExtra(r5)
            java.lang.String r2 = "com.xiaomi.mipush.MESSAGE_CACHE"
            boolean r2 = r12.getBooleanExtra(r2, r3)
            java.lang.String r12 = r12.getAction()
            boolean r12 = r7.equals(r12)
            if (r12 == 0) goto L_0x07c9
            com.xiaomi.push.service.p r12 = com.xiaomi.push.service.C2074p.m5312a((android.content.Context) r11)
            r12.mo18556a((java.lang.String) r0)
            android.content.Context r12 = r11.getApplicationContext()
            boolean r12 = com.xiaomi.push.C1938m.m4714a((android.content.Context) r12)
            if (r12 == 0) goto L_0x07c9
            com.xiaomi.push.service.C1967aa.m4870a((java.lang.String) r0)
        L_0x07c9:
            r11.mo18417a((java.lang.String) r0, (byte[]) r1, (boolean) r2)
            goto L_0x0893
        L_0x07ce:
            java.lang.String r0 = r12.getAction()
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L_0x07f7
            boolean r12 = r11.m4802i()
            if (r12 != 0) goto L_0x0893
            java.lang.String r12 = "exit falldown mode, activate alarm."
            com.xiaomi.channel.commonutils.logger.C1524b.m2141a((java.lang.String) r12)
            r11.m4793e()
            boolean r12 = r11.mo18423c()
            if (r12 != 0) goto L_0x0893
            boolean r12 = r11.mo18424d()
            if (r12 != 0) goto L_0x0893
        L_0x07f2:
            r11.mo18418a((boolean) r3)
            goto L_0x0893
        L_0x07f7:
            java.lang.String r12 = r12.getAction()
            boolean r12 = r5.equals(r12)
            if (r12 == 0) goto L_0x0893
            boolean r12 = r11.m4802i()
            if (r12 == 0) goto L_0x0893
            boolean r12 = com.xiaomi.push.C1783fa.m3471a()
            if (r12 == 0) goto L_0x0893
            java.lang.String r12 = "enter falldown mode, stop alarm."
        L_0x080f:
            com.xiaomi.channel.commonutils.logger.C1524b.m2141a((java.lang.String) r12)
            com.xiaomi.push.C1783fa.m3471a()
            goto L_0x0893
        L_0x0817:
            java.lang.String r0 = com.xiaomi.push.service.C2014bd.f3800s
            java.lang.String r0 = r12.getStringExtra(r0)
            java.lang.String r1 = com.xiaomi.push.service.C2014bd.f3804w
            java.lang.String r1 = r12.getStringExtra(r1)
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 == 0) goto L_0x082c
            java.lang.String r12 = "security is empty. ignore."
            goto L_0x0880
        L_0x082c:
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            if (r1 != 0) goto L_0x088f
            boolean r1 = r11.m4764a((java.lang.String) r0, (android.content.Intent) r12)
            com.xiaomi.push.service.az$b r7 = r11.m4764a((java.lang.String) r0, (android.content.Intent) r12)
            boolean r12 = com.xiaomi.push.C1653bi.m2686c(r11)
            if (r12 != 0) goto L_0x084a
            com.xiaomi.push.service.f r5 = r11.f3609a
            r8 = 0
            r9 = 2
        L_0x0844:
            r10 = 0
            r6 = r11
            r5.mo18526a(r6, r7, r8, r9, r10)
            goto L_0x0893
        L_0x084a:
            boolean r12 = r11.mo18423c()
            if (r12 == 0) goto L_0x07f2
            com.xiaomi.push.service.az$c r12 = r7.f3736a
            com.xiaomi.push.service.az$c r0 = com.xiaomi.push.service.C2003az.C2009c.unbind
            if (r12 != r0) goto L_0x085d
            com.xiaomi.push.service.XMPushService$a r12 = new com.xiaomi.push.service.XMPushService$a
            r12.<init>(r7)
            goto L_0x019b
        L_0x085d:
            if (r1 == 0) goto L_0x0866
            com.xiaomi.push.service.XMPushService$n r12 = new com.xiaomi.push.service.XMPushService$n
            r12.<init>(r7)
            goto L_0x019b
        L_0x0866:
            com.xiaomi.push.service.az$c r12 = r7.f3736a
            com.xiaomi.push.service.az$c r0 = com.xiaomi.push.service.C2003az.C2009c.binding
            if (r12 != r0) goto L_0x0884
            java.lang.Object[] r12 = new java.lang.Object[r2]
            java.lang.String r0 = r7.f3748g
            r12[r4] = r0
            java.lang.String r0 = r7.f3742b
            java.lang.String r0 = com.xiaomi.push.service.C2003az.C2005b.m5091a((java.lang.String) r0)
            r12[r3] = r0
            java.lang.String r0 = "the client is binding. %1$s %2$s."
            java.lang.String r12 = java.lang.String.format(r0, r12)
        L_0x0880:
            com.xiaomi.channel.commonutils.logger.C1524b.m2141a((java.lang.String) r12)
            goto L_0x0893
        L_0x0884:
            com.xiaomi.push.service.az$c r12 = r7.f3736a
            com.xiaomi.push.service.az$c r0 = com.xiaomi.push.service.C2003az.C2009c.binded
            if (r12 != r0) goto L_0x0893
            com.xiaomi.push.service.f r5 = r11.f3609a
            r8 = 1
            r9 = 0
            goto L_0x0844
        L_0x088f:
            java.lang.String r12 = "channel id is empty, do nothing!"
            goto L_0x0517
        L_0x0893:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.service.XMPushService.m4792d(android.content.Intent):void");
    }

    /* renamed from: e */
    private void m4793e() {
        if (!mo18408a()) {
            C1783fa.m3471a();
        } else if (!C1783fa.m3471a()) {
            C1783fa.m3474a(true);
        }
    }

    /* renamed from: e */
    private void m4794e(Intent intent) {
        int i;
        try {
            C1764ej.m3355a(getApplicationContext()).mo17527a((C1768en) new C2018bf());
            String stringExtra = intent.getStringExtra("mipush_app_package");
            byte[] byteArrayExtra = intent.getByteArrayExtra("mipush_payload");
            if (byteArrayExtra != null) {
                C1894in inVar = new C1894in();
                C1905iy.m4542a(inVar, byteArrayExtra);
                String b = inVar.mo18085b();
                Map a = inVar.mo18077a();
                if (a != null) {
                    String str = (String) a.get("extra_help_aw_info");
                    String str2 = (String) a.get("extra_aw_app_online_cmd");
                    if (!TextUtils.isEmpty(str2)) {
                        try {
                            i = Integer.parseInt(str2);
                        } catch (NumberFormatException unused) {
                            i = 0;
                        }
                        if (!TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(b) && !TextUtils.isEmpty(str)) {
                            C1764ej.m3355a(getApplicationContext()).mo17525a(this, str, i, stringExtra, b);
                        }
                    }
                }
            }
        } catch (C1913je e) {
            C1524b.m2160d("aw_logic: translate fail. " + e.getMessage());
        }
    }

    /* renamed from: e */
    private boolean m4795e() {
        if (System.currentTimeMillis() - this.f3597a < 30000) {
            return false;
        }
        return C1653bi.m2687d(this);
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public void m4796f() {
        String str;
        C1809fu fuVar = this.f3601a;
        if (fuVar == null || !fuVar.mo17661b()) {
            C1809fu fuVar2 = this.f3601a;
            if (fuVar2 == null || !fuVar2.mo17666c()) {
                this.f3602a.mo17673b(C1653bi.m2669a((Context) this));
                m4798g();
                if (this.f3601a == null) {
                    C2003az.mo18481a().mo18484a((Context) this);
                    m4790c(false);
                    return;
                }
                return;
            }
            str = "try to connect while is connected.";
        } else {
            str = "try to connect while connecting.";
        }
        C1524b.m2160d(str);
    }

    /* renamed from: f */
    private boolean m4797f() {
        return "com.xiaomi.xmsf".equals(getPackageName()) && Settings.Secure.getInt(getContentResolver(), "EXTREME_POWER_MODE_ENABLE", 0) == 1;
    }

    /* renamed from: g */
    private void m4798g() {
        try {
            this.f3600a.mo17658a(this.f3603a, (C1825gh) new C2044cc(this));
            this.f3600a.mo17680e();
            this.f3601a = this.f3600a;
        } catch (C1823gf e) {
            C1524b.m2154a("fail to create Slim connection", (Throwable) e);
            this.f3600a.mo17662b(3, e);
        }
    }

    /* renamed from: g */
    private boolean m4799g() {
        return "com.xiaomi.xmsf".equals(getPackageName()) && Settings.System.getInt(getContentResolver(), "power_supersave_mode_open", 0) == 1;
    }

    /* renamed from: h */
    private void m4800h() {
    }

    /* renamed from: h */
    private boolean m4801h() {
        return "com.xiaomi.xmsf".equals(getPackageName()) || !C2074p.m5312a((Context) this).mo18557b(getPackageName());
    }

    /* renamed from: i */
    private void m4802i() {
        synchronized (this.f3613a) {
            this.f3613a.clear();
        }
    }

    /* renamed from: i */
    private boolean m4803i() {
        return getApplicationContext().getPackageName().equals("com.xiaomi.xmsf") && m4804j() && !C1907j.m4562b((Context) this) && !C1907j.m4553a(getApplicationContext());
    }

    /* renamed from: j */
    private boolean m4804j() {
        int intValue = Integer.valueOf(String.format("%tH", new Object[]{new Date()})).intValue();
        int i = this.f3596a;
        int i2 = this.f3615b;
        if (i <= i2) {
            return i < i2 && intValue >= i && intValue < i2;
        }
        if (intValue >= i || intValue < i2) {
            return true;
        }
    }

    /* renamed from: k */
    private boolean m4805k() {
        if (TextUtils.equals(getPackageName(), "com.xiaomi.xmsf")) {
            return false;
        }
        return C1995at.m5047a((Context) this).mo18472a(C1873ht.ForegroundServiceSwitch.mo17806a(), false);
    }

    /* renamed from: a */
    public C1809fu m4806a() {
        return this.f3601a;
    }

    /* renamed from: a */
    public C2058f m4807a() {
        return new C2058f();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void m4808a() {
        if (System.currentTimeMillis() - this.f3597a >= ((long) C1818ga.m3676a()) && C1653bi.m2687d(this)) {
            m4784b(true);
        }
    }

    /* renamed from: a */
    public void mo18409a(int i) {
        this.f3610a.mo18538a(i);
    }

    /* renamed from: a */
    public void mo18410a(int i, Exception exc) {
        StringBuilder sb = new StringBuilder();
        sb.append("disconnect ");
        sb.append(hashCode());
        sb.append(", ");
        C1809fu fuVar = this.f3601a;
        sb.append(fuVar == null ? null : Integer.valueOf(fuVar.hashCode()));
        C1524b.m2141a(sb.toString());
        C1809fu fuVar2 = this.f3601a;
        if (fuVar2 != null) {
            fuVar2.mo17662b(i, exc);
            this.f3601a = null;
        }
        mo18409a(7);
        mo18409a(4);
        C2003az.mo18481a().mo18485a((Context) this, i);
    }

    /* renamed from: a */
    public void mo18411a(C1793fj fjVar) {
        C1809fu fuVar = this.f3601a;
        if (fuVar != null) {
            fuVar.mo17647b(fjVar);
            return;
        }
        throw new C1823gf("try send msg while connection is null.");
    }

    /* renamed from: a */
    public void mo17652a(C1809fu fuVar) {
        C1524b.m2159c("begin to connect...");
        C1857hg.mo17753a().mo17652a(fuVar);
    }

    /* renamed from: a */
    public void mo17653a(C1809fu fuVar, int i, Exception exc) {
        C1857hg.mo17753a().mo17653a(fuVar, i, exc);
        if (!m4802i()) {
            mo18418a(false);
        }
    }

    /* renamed from: a */
    public void mo17654a(C1809fu fuVar, Exception exc) {
        C1857hg.mo17753a().mo17654a(fuVar, exc);
        m4790c(false);
        if (!m4802i()) {
            mo18418a(false);
        }
    }

    /* renamed from: a */
    public void mo18412a(C1956i iVar) {
        mo18413a(iVar, 0);
    }

    /* renamed from: a */
    public void mo18413a(C1956i iVar, long j) {
        try {
            this.f3610a.mo18541a((C2062j.C2064b) iVar, j);
        } catch (IllegalStateException e) {
            C1524b.m2141a("can't execute job err = " + e.getMessage());
        }
    }

    /* renamed from: a */
    public void mo18414a(C1959l lVar) {
        synchronized (this.f3613a) {
            this.f3613a.add(lVar);
        }
    }

    /* renamed from: a */
    public void mo18415a(C2003az.C2005b bVar) {
        if (bVar != null) {
            long a = bVar.mo18490a();
            C1524b.m2141a("schedule rebind job in " + (a / 1000));
            mo18413a((C1956i) new C1948a(bVar), a);
        }
    }

    /* renamed from: a */
    public void mo18416a(String str, String str2, int i, String str3, String str4) {
        C2003az.C2005b a = C2003az.mo18481a().mo18482a(str, str2);
        if (a != null) {
            mo18412a((C1956i) new C1964q(a, i, str4, str3));
        }
        C2003az.mo18481a().mo18482a(str, str2);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo18417a(String str, byte[] bArr, boolean z) {
        Collection a = C2003az.mo18481a().mo18483a("5");
        if (a.isEmpty()) {
            if (!z) {
                return;
            }
        } else if (((C2003az.C2005b) a.iterator().next()).f3736a == C2003az.C2009c.binded) {
            mo18412a((C1956i) new C2042ca(this, 4, str, bArr));
            return;
        } else if (!z) {
            return;
        }
        C2076r.m5329b(str, bArr);
    }

    /* renamed from: a */
    public void mo18418a(boolean z) {
        this.f3608a.mo18503a(z);
    }

    /* renamed from: a */
    public void mo18419a(byte[] bArr, String str) {
        if (bArr == null) {
            C2076r.m5325a(this, str, bArr, ErrorCode.ERROR_INVALID_PAYLOAD, "null payload");
            C1524b.m2141a("register request without payload");
            return;
        }
        C1891ik ikVar = new C1891ik();
        try {
            C1905iy.m4542a(ikVar, bArr);
            if (ikVar.f3188a == C1868ho.Registration) {
                C1895io ioVar = new C1895io();
                try {
                    C1905iy.m4542a(ioVar, ikVar.mo18043a());
                    C2076r.m5327a(ikVar.mo18052b(), bArr);
                    mo18412a((C1956i) new C2075q(this, ikVar.mo18052b(), ioVar.mo18118b(), ioVar.mo18122c(), bArr));
                    C1776eu.m3405a(getApplicationContext()).mo17537a(ikVar.mo18052b(), "E100003", ioVar.mo18114a(), AuthCode.StatusCode.AUTH_INFO_NOT_EXIST, (String) null);
                } catch (C1913je e) {
                    C1524b.m2160d("app register error. " + e);
                    C2076r.m5325a(this, str, bArr, ErrorCode.ERROR_INVALID_PAYLOAD, " data action error.");
                }
            } else {
                C2076r.m5325a(this, str, bArr, ErrorCode.ERROR_INVALID_PAYLOAD, " registration action required.");
                C1524b.m2141a("register request with invalid payload");
            }
        } catch (C1913je e2) {
            C1524b.m2160d("app register fail. " + e2);
            C2076r.m5325a(this, str, bArr, ErrorCode.ERROR_INVALID_PAYLOAD, " data container error.");
        }
    }

    /* renamed from: a */
    public void mo18420a(C1793fj[] fjVarArr) {
        C1809fu fuVar = this.f3601a;
        if (fuVar != null) {
            fuVar.mo17646a(fjVarArr);
            return;
        }
        throw new C1823gf("try send msg while connection is null.");
    }

    /* renamed from: a */
    public boolean m4824a() {
        boolean b = C1653bi.m2685b(this);
        boolean z = C2003az.mo18481a().mo18481a() > 0;
        boolean z2 = !mo18421b();
        boolean h = m4800h();
        boolean z3 = !m4798g();
        boolean z4 = !m4796f();
        boolean z5 = b && z && z2 && h && z3 && z4;
        if (!z5) {
            C1524b.m2161e(String.format("not conn, net=%s;cnt=%s;!dis=%s;enb=%s;!spm=%s;!eps=%s", new Object[]{Boolean.valueOf(b), Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(h), Boolean.valueOf(z3), Boolean.valueOf(z4)}));
        }
        return z5;
    }

    /* renamed from: a */
    public boolean m4825a(int i) {
        return this.f3610a.mo18538a(i);
    }

    /* renamed from: b */
    public C2058f m4826b() {
        return this.f3609a;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void m4827b() {
        C2061i.m5236a(getApplicationContext()).mo18536d();
        Iterator it = new ArrayList(this.f3613a).iterator();
        while (it.hasNext()) {
            ((C1959l) it.next()).mo17759a();
        }
    }

    /* renamed from: b */
    public void mo17655b(C1809fu fuVar) {
        C1857hg.mo17753a().mo17655b(fuVar);
        m4790c(true);
        this.f3608a.mo18502a();
        if (!C1783fa.m3471a() && !m4802i()) {
            C1524b.m2141a("reconnection successful, reactivate alarm.");
            C1783fa.m3474a(true);
        }
        Iterator it = C2003az.mo18481a().mo18481a().iterator();
        while (it.hasNext()) {
            mo18412a((C1956i) new C1948a((C2003az.C2005b) it.next()));
        }
    }

    /* renamed from: b */
    public void mo18422b(C1956i iVar) {
        this.f3610a.mo18539a(iVar.f3903a, (C2062j.C2064b) iVar);
    }

    /* renamed from: b */
    public boolean m4830b() {
        try {
            Class<?> a = C2087u.m5373a(this, "miui.os.Build");
            return a.getField("IS_CM_CUSTOMIZATION_TEST").getBoolean((Object) null) || a.getField("IS_CU_CUSTOMIZATION_TEST").getBoolean((Object) null) || a.getField("IS_CT_CUSTOMIZATION_TEST").getBoolean((Object) null);
        } catch (Throwable unused) {
            return false;
        }
    }

    /* renamed from: c */
    public boolean m4831c() {
        C1809fu fuVar = this.f3601a;
        return fuVar != null && fuVar.mo17666c();
    }

    /* renamed from: d */
    public boolean m4832d() {
        C1809fu fuVar = this.f3601a;
        return fuVar != null && fuVar.mo17661b();
    }

    public IBinder onBind(Intent intent) {
        return this.f3599a.getBinder();
    }

    public void onCreate() {
        String[] split;
        super.onCreate();
        C1524b.m2149a(getApplicationContext());
        C2087u.m5375a((Context) this);
        C2071n a = C2072o.m5301a((Context) this);
        if (a != null) {
            C1611ad.m2505a(a.f3925a);
        }
        this.f3599a = new Messenger(new C2045cd(this));
        C2015be.m5115a(this);
        this.f3602a = new C2046ce(this, (Map) null, 5222, "xiaomi.com", (C1814fy) null);
        this.f3602a.mo17671a(true);
        this.f3600a = new C1804fq(this, this.f3602a);
        this.f3609a = mo18408a();
        C1783fa.m3472a((Context) this);
        this.f3600a.mo17657a((C1813fx) this);
        this.f3607a = new C2000ax(this);
        this.f3608a = new C2022bj(this);
        new C2059g().mo18529a();
        C1857hg.mo17753a().mo17756a(this);
        this.f3610a = new C2062j("Connection Controller Thread");
        C2003az a2 = C2003az.mo18481a();
        a2.mo18488b();
        a2.mo18486a((C2003az.C2004a) new C2047cf(this));
        if (m4805k()) {
            m4800h();
        }
        C1866hm.m3887a(this).mo17762a((C1867hn) new C2069l(this), "UPLOADER_PUSH_CHANNEL");
        mo18414a((C1959l) new C1862hj(this));
        mo18414a((C1959l) new C2038bx(this));
        if (C1938m.m4714a((Context) this)) {
            mo18414a((C1959l) new C2001ay());
        }
        mo18412a((C1956i) new C1954g());
        this.f3614a.add(C2030bq.m5168a((Context) this));
        if (m4800h()) {
            this.f3604a = new C1952e();
            registerReceiver(this.f3604a, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        }
        if (C1938m.m4714a(getApplicationContext())) {
            this.f3606a = new C1965r();
            registerReceiver(this.f3606a, new IntentFilter("miui.net.wifi.DIGEST_INFORMATION_CHANGED"), "miui.net.wifi.permission.ACCESS_WIFI_DIGEST_INFO", (Handler) null);
        }
        C2061i.m5236a(getApplicationContext()).mo18531a();
        if ("com.xiaomi.xmsf".equals(getPackageName())) {
            Uri uriFor = Settings.Secure.getUriFor("EXTREME_POWER_MODE_ENABLE");
            if (uriFor != null) {
                this.f3598a = new C2048cg(this, new Handler(Looper.getMainLooper()));
                try {
                    getContentResolver().registerContentObserver(uriFor, false, this.f3598a);
                } catch (Throwable th) {
                    C1524b.m2141a("register observer err:" + th.getMessage());
                }
            }
            Uri uriFor2 = Settings.System.getUriFor("power_supersave_mode_open");
            if (uriFor2 != null) {
                this.f3616b = new C2049ch(this, new Handler(Looper.getMainLooper()));
                try {
                    getContentResolver().registerContentObserver(uriFor2, false, this.f3616b);
                } catch (Throwable th2) {
                    C1524b.m2160d("register super-power-mode observer err:" + th2.getMessage());
                }
            }
            int[] a3 = mo18408a();
            if (a3 != null) {
                this.f3605a = new C1963p();
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.intent.action.SCREEN_ON");
                intentFilter.addAction("android.intent.action.SCREEN_OFF");
                registerReceiver(this.f3605a, intentFilter);
                this.f3596a = a3[0];
                this.f3615b = a3[1];
                C1524b.m2141a("falldown initialized: " + this.f3596a + Constants.ACCEPT_TIME_SEPARATOR_SP + this.f3615b);
            }
        }
        String str = "";
        if (a != null) {
            try {
                if (!TextUtils.isEmpty(a.f3926a) && (split = a.f3926a.split("@")) != null && split.length > 0) {
                    str = split[0];
                }
            } catch (Exception unused) {
            }
        }
        C1715dd.m2973a((Context) this);
        C1524b.m2161e("XMPushService created. pid=" + Process.myPid() + ", uid=" + Process.myUid() + ", uuid=" + str);
    }

    public void onDestroy() {
        C1952e eVar = this.f3604a;
        if (eVar != null) {
            m4768a((BroadcastReceiver) eVar);
            this.f3604a = null;
        }
        C1965r rVar = this.f3606a;
        if (rVar != null) {
            m4768a((BroadcastReceiver) rVar);
            this.f3606a = null;
        }
        C1963p pVar = this.f3605a;
        if (pVar != null) {
            m4768a((BroadcastReceiver) pVar);
            this.f3605a = null;
        }
        if ("com.xiaomi.xmsf".equals(getPackageName()) && this.f3598a != null) {
            try {
                getContentResolver().unregisterContentObserver(this.f3598a);
            } catch (Throwable th) {
                C1524b.m2141a("unregister observer err:" + th.getMessage());
            }
        }
        if ("com.xiaomi.xmsf".equals(getPackageName()) && this.f3616b != null) {
            try {
                getContentResolver().unregisterContentObserver(this.f3616b);
            } catch (Throwable th2) {
                C1524b.m2160d("unregister super-power-mode err:" + th2.getMessage());
            }
        }
        this.f3614a.clear();
        this.f3610a.mo18542b();
        mo18412a((C1956i) new C2043cb(this, 2));
        mo18412a((C1956i) new C1957j());
        C2003az.mo18481a().mo18488b();
        C2003az.mo18481a().mo18485a((Context) this, 15);
        C2003az.mo18481a().mo18481a();
        this.f3600a.mo17663b((C1813fx) this);
        C2027bo.mo18506a().mo18506a();
        C1783fa.m3471a();
        m4802i();
        super.onDestroy();
        C1524b.m2141a("Service destroyed");
    }

    public void onStart(Intent intent, int i) {
        C1955h hVar;
        long currentTimeMillis = System.currentTimeMillis();
        if (intent == null) {
            C1524b.m2160d("onStart() with intent NULL");
        } else {
            C1524b.m2141a(String.format("onStart() with intent.Action = %s, chid = %s, pkg = %s|%s", new Object[]{intent.getAction(), intent.getStringExtra(C2014bd.f3800s), intent.getStringExtra(C2014bd.f3769A), intent.getStringExtra("mipush_app_package")}));
        }
        if (!(intent == null || intent.getAction() == null)) {
            if ("com.xiaomi.push.timer".equalsIgnoreCase(intent.getAction()) || "com.xiaomi.push.check_alive".equalsIgnoreCase(intent.getAction())) {
                if (this.f3610a.mo18537a()) {
                    C1524b.m2160d("ERROR, the job controller is blocked.");
                    C2003az.mo18481a().mo18485a((Context) this, 14);
                    stopSelf();
                } else {
                    hVar = new C1955h(intent);
                }
            } else if (!"com.xiaomi.push.network_status_changed".equalsIgnoreCase(intent.getAction())) {
                hVar = new C1955h(intent);
            }
            mo18412a((C1956i) hVar);
        }
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        if (currentTimeMillis2 > 50) {
            C1524b.m2159c("[Prefs] spend " + currentTimeMillis2 + " ms, too more times.");
        }
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        onStart(intent, i2);
        return 1;
    }
}
