package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.core.view.PointerIconCompat;
import com.huawei.hms.support.api.entity.auth.AuthCode;
import com.xiaomi.channel.commonutils.logger.C1524b;
import com.xiaomi.mipush.sdk.PushMessageHandler;
import com.xiaomi.push.C1663bo;
import com.xiaomi.push.C1671bw;
import com.xiaomi.push.C1712da;
import com.xiaomi.push.C1774et;
import com.xiaomi.push.C1776eu;
import com.xiaomi.push.C1788fe;
import com.xiaomi.push.C1868ho;
import com.xiaomi.push.C1873ht;
import com.xiaomi.push.C1878hy;
import com.xiaomi.push.C1881ia;
import com.xiaomi.push.C1882ib;
import com.xiaomi.push.C1883ic;
import com.xiaomi.push.C1885ie;
import com.xiaomi.push.C1886if;
import com.xiaomi.push.C1890ij;
import com.xiaomi.push.C1891ik;
import com.xiaomi.push.C1892il;
import com.xiaomi.push.C1893im;
import com.xiaomi.push.C1894in;
import com.xiaomi.push.C1896ip;
import com.xiaomi.push.C1898ir;
import com.xiaomi.push.C1900it;
import com.xiaomi.push.C1902iv;
import com.xiaomi.push.C1904ix;
import com.xiaomi.push.C1905iy;
import com.xiaomi.push.C1906iz;
import com.xiaomi.push.C1907j;
import com.xiaomi.push.C1913je;
import com.xiaomi.push.C1945s;
import com.xiaomi.push.service.C1974af;
import com.xiaomi.push.service.C1995at;
import com.xiaomi.push.service.C1997au;
import com.xiaomi.push.service.C2014bd;
import com.xiaomi.push.service.C2023bk;
import com.xiaomi.push.service.C2055e;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TimeZone;

/* renamed from: com.xiaomi.mipush.sdk.am */
public class C1566am {

    /* renamed from: a */
    private static C1566am f1660a;

    /* renamed from: a */
    private static Object f1661a = new Object();

    /* renamed from: a */
    private static Queue<String> f1662a;

    /* renamed from: a */
    private Context f1663a;

    private C1566am(Context context) {
        this.f1663a = context.getApplicationContext();
        if (this.f1663a == null) {
            this.f1663a = context;
        }
    }

    /* renamed from: a */
    public static Intent m2294a(Context context, String str, Map<String, String> map, int i) {
        return C1974af.m4936b(context, str, map, i);
    }

    /* renamed from: a */
    private PushMessageHandler.C1552a m2295a(C1891ik ikVar, boolean z, byte[] bArr, String str, int i, Intent intent) {
        C1776eu a;
        String packageName;
        String a2;
        String str2;
        String str3;
        String str4;
        MiPushMessage miPushMessage;
        String str5;
        int i2;
        String str6;
        String str7;
        C1776eu euVar;
        C1891ik ikVar2 = ikVar;
        boolean z2 = z;
        byte[] bArr2 = bArr;
        String str8 = str;
        int i3 = i;
        ArrayList arrayList = null;
        try {
            C1906iz a3 = C1562ai.m2289a(this.f1663a, ikVar2);
            if (a3 == null) {
                C1524b.m2160d("receiving an un-recognized message. " + ikVar2.f3188a);
                C1776eu.m3405a(this.f1663a).mo17539b(this.f1663a.getPackageName(), C1774et.m3389a(i), str8, "18");
                C1597s.m2470c(this.f1663a, ikVar2, z2);
                return null;
            }
            C1868ho a4 = ikVar.mo18043a();
            C1524b.m2141a("processing a message, action=" + a4);
            switch (C1567an.f1664a[a4.ordinal()]) {
                case 1:
                    if (!ikVar.mo18052b()) {
                        C1524b.m2160d("receiving an un-encrypt message(SendMessage).");
                        return null;
                    } else if (!C1578b.m2373a(this.f1663a).mo17175e() || z2) {
                        C1898ir irVar = (C1898ir) a3;
                        C1881ia a5 = irVar.mo18204a();
                        if (a5 == null) {
                            C1524b.m2160d("receive an empty message without push content, drop it");
                            C1776eu.m3405a(this.f1663a).mo17539b(this.f1663a.getPackageName(), C1774et.m3389a(i), str8, "22");
                            C1597s.m2471d(this.f1663a, ikVar2, z2);
                            return null;
                        }
                        int intExtra = intent.getIntExtra("notification_click_button", 0);
                        if (z2) {
                            if (C1974af.m4915a(ikVar)) {
                                MiPushClient.reportIgnoreRegMessageClicked(this.f1663a, a5.mo17850a(), ikVar.mo18043a(), ikVar2.f3195b, a5.mo17852b());
                            } else {
                                C1882ib ibVar = ikVar.mo18043a() != null ? new C1882ib(ikVar.mo18043a()) : new C1882ib();
                                if (ibVar.mo17876a() == null) {
                                    ibVar.mo17880a((Map<String, String>) new HashMap());
                                }
                                ibVar.mo17876a().put("notification_click_button", String.valueOf(intExtra));
                                MiPushClient.reportMessageClicked(this.f1663a, a5.mo17850a(), ibVar, a5.mo17852b());
                            }
                        }
                        if (!z2) {
                            if (!TextUtils.isEmpty(irVar.mo18209d()) && MiPushClient.aliasSetTime(this.f1663a, irVar.mo18209d()) < 0) {
                                MiPushClient.addAlias(this.f1663a, irVar.mo18209d());
                            } else if (!TextUtils.isEmpty(irVar.mo18207c()) && MiPushClient.topicSubscribedTime(this.f1663a, irVar.mo18207c()) < 0) {
                                MiPushClient.addTopic(this.f1663a, irVar.mo18207c());
                            }
                        }
                        if (ikVar2.f3189a == null || ikVar2.f3189a.mo17876a() == null) {
                            str4 = null;
                            str3 = null;
                        } else {
                            str3 = ikVar2.f3189a.f3033a.get("jobkey");
                            str4 = str3;
                        }
                        if (TextUtils.isEmpty(str3)) {
                            str3 = a5.mo17850a();
                        }
                        if (z2 || !m2299a(this.f1663a, str3)) {
                            miPushMessage = PushMessageHelper.generateMessage(irVar, ikVar.mo18043a(), z2);
                            if (miPushMessage.getPassThrough() != 0 || z2 || !C1974af.m4897a(miPushMessage.getExtra())) {
                                C1524b.m2141a("receive a message, msgid=" + a5.mo17850a() + ", jobkey=" + str3 + ", btn=" + intExtra);
                                String a6 = C1974af.m4916a(miPushMessage.getExtra(), intExtra);
                                if (z2 && miPushMessage.getExtra() != null && !TextUtils.isEmpty(a6)) {
                                    Map<String, String> extra = miPushMessage.getExtra();
                                    if (!(intExtra == 0 || ikVar.mo18043a() == null)) {
                                        C1568ao.m2317a(this.f1663a).mo17135a(ikVar.mo18043a().mo17888c(), intExtra);
                                    }
                                    if (C1974af.m4915a(ikVar)) {
                                        Intent a7 = m2294a(this.f1663a, ikVar2.f3195b, extra, intExtra);
                                        a7.putExtra("eventMessageType", i3);
                                        a7.putExtra("messageId", str8);
                                        a7.putExtra("jobkey", str4);
                                        if (a7 == null) {
                                            C1524b.m2141a("Getting Intent fail from ignore reg message. ");
                                            C1776eu.m3405a(this.f1663a).mo17539b(this.f1663a.getPackageName(), C1774et.m3389a(i), str8, "23");
                                            return null;
                                        }
                                        String c = a5.mo17854c();
                                        if (!TextUtils.isEmpty(c)) {
                                            a7.putExtra("payload", c);
                                        }
                                        this.f1663a.startActivity(a7);
                                        C1597s.m2466a(this.f1663a, ikVar2);
                                        C1776eu.m3405a(this.f1663a).mo17537a(this.f1663a.getPackageName(), C1774et.m3389a(i), str, 3006, a6);
                                        return null;
                                    }
                                    Context context = this.f1663a;
                                    Intent a8 = m2294a(context, context.getPackageName(), extra, intExtra);
                                    if (a8 == null) {
                                        return null;
                                    }
                                    if (!a6.equals(C2014bd.f3784c)) {
                                        a8.putExtra(PushMessageHelper.KEY_MESSAGE, miPushMessage);
                                        a8.putExtra("eventMessageType", i3);
                                        a8.putExtra("messageId", str8);
                                        a8.putExtra("jobkey", str4);
                                    }
                                    this.f1663a.startActivity(a8);
                                    C1597s.m2466a(this.f1663a, ikVar2);
                                    C1524b.m2141a("start activity succ");
                                    C1776eu.m3405a(this.f1663a).mo17537a(this.f1663a.getPackageName(), C1774et.m3389a(i), str, PointerIconCompat.TYPE_CELL, a6);
                                    if (!a6.equals(C2014bd.f3784c)) {
                                        return null;
                                    }
                                    C1776eu.m3405a(this.f1663a).mo17538a(this.f1663a.getPackageName(), C1774et.m3389a(i), str8, "13");
                                    return null;
                                }
                            } else {
                                C1974af.m4908a(this.f1663a, ikVar2, bArr2);
                                return null;
                            }
                        } else {
                            C1524b.m2141a("drop a duplicate message, key=" + str3);
                            C1776eu a9 = C1776eu.m3405a(this.f1663a);
                            String packageName2 = this.f1663a.getPackageName();
                            String a10 = C1774et.m3389a(i);
                            a9.mo17540c(packageName2, a10, str8, "2:" + str3);
                            miPushMessage = null;
                        }
                        if (ikVar.mo18043a() == null && !z2) {
                            m2303a(irVar, ikVar2);
                        }
                        return miPushMessage;
                    } else {
                        C1524b.m2141a("receive a message in pause state. drop it");
                        C1776eu.m3405a(this.f1663a).mo17538a(this.f1663a.getPackageName(), C1774et.m3389a(i), str8, "12");
                        return null;
                    }
                case 2:
                    C1896ip ipVar = (C1896ip) a3;
                    String str9 = C1578b.m2373a(this.f1663a).f1697a;
                    if (TextUtils.isEmpty(str9) || !TextUtils.equals(str9, ipVar.mo18163a())) {
                        C1524b.m2141a("bad Registration result:");
                        C1776eu.m3405a(this.f1663a).mo17539b(this.f1663a.getPackageName(), C1774et.m3389a(i), str8, "21");
                        return null;
                    }
                    C1578b.m2373a(this.f1663a).f1697a = null;
                    int i4 = (ipVar.f3315a > 0 ? 1 : (ipVar.f3315a == 0 ? 0 : -1));
                    Context context2 = this.f1663a;
                    if (i4 == 0) {
                        C1578b.m2373a(context2).mo17172b(ipVar.f3325e, ipVar.f3326f, ipVar.f3332l);
                        euVar = C1776eu.m3405a(this.f1663a);
                        str7 = this.f1663a.getPackageName();
                        str6 = C1774et.m3389a(i);
                        i2 = AuthCode.StatusCode.PERMISSION_EXPIRED;
                        str5 = "1";
                    } else {
                        euVar = C1776eu.m3405a(context2);
                        str7 = this.f1663a.getPackageName();
                        str6 = C1774et.m3389a(i);
                        i2 = AuthCode.StatusCode.PERMISSION_EXPIRED;
                        str5 = "2";
                    }
                    euVar.mo17537a(str7, str6, str, i2, str5);
                    if (!TextUtils.isEmpty(ipVar.f3325e)) {
                        arrayList = new ArrayList();
                        arrayList.add(ipVar.f3325e);
                    }
                    MiPushCommandMessage generateCommandMessage = PushMessageHelper.generateCommandMessage(C1788fe.COMMAND_REGISTER.f2292a, arrayList, ipVar.f3315a, ipVar.f3324d, (String) null);
                    C1568ao.m2317a(this.f1663a).mo17156d();
                    return generateCommandMessage;
                case 3:
                    if (((C1902iv) a3).f3448a == 0) {
                        C1578b.m2373a(this.f1663a).mo17163a();
                        MiPushClient.clearExtras(this.f1663a);
                    }
                    PushMessageHandler.mo17007a();
                    break;
                case 4:
                    C1900it itVar = (C1900it) a3;
                    if (itVar.f3402a == 0) {
                        MiPushClient.addTopic(this.f1663a, itVar.mo18242b());
                    }
                    if (!TextUtils.isEmpty(itVar.mo18242b())) {
                        arrayList = new ArrayList();
                        arrayList.add(itVar.mo18242b());
                    }
                    C1524b.m2161e("resp-cmd:" + C1788fe.COMMAND_SUBSCRIBE_TOPIC + ", " + itVar.mo18240a());
                    return PushMessageHelper.generateCommandMessage(C1788fe.COMMAND_SUBSCRIBE_TOPIC.f2292a, arrayList, itVar.f3402a, itVar.f3408d, itVar.mo18243c());
                case 5:
                    C1904ix ixVar = (C1904ix) a3;
                    if (ixVar.f3485a == 0) {
                        MiPushClient.removeTopic(this.f1663a, ixVar.mo18316b());
                    }
                    if (!TextUtils.isEmpty(ixVar.mo18316b())) {
                        arrayList = new ArrayList();
                        arrayList.add(ixVar.mo18316b());
                    }
                    C1524b.m2161e("resp-cmd:" + C1788fe.COMMAND_UNSUBSCRIBE_TOPIC + ", " + ixVar.mo18314a());
                    return PushMessageHelper.generateCommandMessage(C1788fe.COMMAND_UNSUBSCRIBE_TOPIC.f2292a, arrayList, ixVar.f3485a, ixVar.f3491d, ixVar.mo18317c());
                case 6:
                    C1712da.m2971a(this.f1663a.getPackageName(), this.f1663a, a3, C1868ho.Command, bArr2.length);
                    C1890ij ijVar = (C1890ij) a3;
                    String b = ijVar.mo18028b();
                    List<String> a11 = ijVar.mo18026a();
                    if (ijVar.f3168a == 0) {
                        if (TextUtils.equals(b, C1788fe.COMMAND_SET_ACCEPT_TIME.f2292a) && a11 != null && a11.size() > 1) {
                            MiPushClient.addAcceptTime(this.f1663a, a11.get(0), a11.get(1));
                            if (!"00:00".equals(a11.get(0)) || !"00:00".equals(a11.get(1))) {
                                C1578b.m2373a(this.f1663a).mo17168a(false);
                            } else {
                                C1578b.m2373a(this.f1663a).mo17168a(true);
                            }
                            a11 = mo17132a(TimeZone.getTimeZone("GMT+08"), TimeZone.getDefault(), a11);
                        } else if (TextUtils.equals(b, C1788fe.COMMAND_SET_ALIAS.f2292a) && a11 != null && a11.size() > 0) {
                            MiPushClient.addAlias(this.f1663a, a11.get(0));
                        } else if (TextUtils.equals(b, C1788fe.COMMAND_UNSET_ALIAS.f2292a) && a11 != null && a11.size() > 0) {
                            MiPushClient.removeAlias(this.f1663a, a11.get(0));
                        } else if (TextUtils.equals(b, C1788fe.COMMAND_SET_ACCOUNT.f2292a) && a11 != null && a11.size() > 0) {
                            MiPushClient.addAccount(this.f1663a, a11.get(0));
                        } else if (TextUtils.equals(b, C1788fe.COMMAND_UNSET_ACCOUNT.f2292a) && a11 != null && a11.size() > 0) {
                            MiPushClient.removeAccount(this.f1663a, a11.get(0));
                        } else if (TextUtils.equals(b, C1788fe.COMMAND_CHK_VDEVID.f2292a)) {
                            if (a11 != null && a11.size() > 0) {
                                C1907j.m4555a(this.f1663a, a11.get(0));
                            }
                            return null;
                        }
                    }
                    C1524b.m2161e("resp-cmd:" + b + ", " + ijVar.mo18026a());
                    return PushMessageHelper.generateCommandMessage(b, a11, ijVar.f3168a, ijVar.f3176d, ijVar.mo18030c());
                case 7:
                    C1712da.m2971a(this.f1663a.getPackageName(), this.f1663a, a3, C1868ho.Notification, bArr2.length);
                    if (!(a3 instanceof C1886if)) {
                        if (a3 instanceof C1894in) {
                            C1894in inVar = (C1894in) a3;
                            if (!"registration id expired".equalsIgnoreCase(inVar.f3229d)) {
                                if (!C1878hy.ClientInfoUpdateOk.f2959a.equalsIgnoreCase(inVar.f3229d)) {
                                    if (!C1878hy.AwakeApp.f2959a.equalsIgnoreCase(inVar.f3229d)) {
                                        if (!C1878hy.NormalClientConfigUpdate.f2959a.equalsIgnoreCase(inVar.f3229d)) {
                                            if (!C1878hy.CustomClientConfigUpdate.f2959a.equalsIgnoreCase(inVar.f3229d)) {
                                                if (!C1878hy.SyncInfoResult.f2959a.equalsIgnoreCase(inVar.f3229d)) {
                                                    if (!C1878hy.ForceSync.f2959a.equalsIgnoreCase(inVar.f3229d)) {
                                                        if (!C1878hy.CancelPushMessage.f2959a.equals(inVar.f3229d)) {
                                                            if (!C1878hy.HybridRegisterResult.f2959a.equals(inVar.f3229d)) {
                                                                if (!C1878hy.HybridUnregisterResult.f2959a.equals(inVar.f3229d)) {
                                                                    if (!C1878hy.PushLogUpload.f2959a.equals(inVar.f3229d) && C2055e.m5214a(inVar)) {
                                                                        C1524b.m2158b("receive notification handle by cpra");
                                                                        break;
                                                                    }
                                                                } else {
                                                                    C1902iv ivVar = new C1902iv();
                                                                    C1905iy.m4542a(ivVar, inVar.mo18077a());
                                                                    MiPushClient4Hybrid.onReceiveUnregisterResult(this.f1663a, ivVar);
                                                                    break;
                                                                }
                                                            } else {
                                                                try {
                                                                    C1896ip ipVar2 = new C1896ip();
                                                                    C1905iy.m4542a(ipVar2, inVar.mo18077a());
                                                                    MiPushClient4Hybrid.onReceiveRegisterResult(this.f1663a, ipVar2);
                                                                    break;
                                                                } catch (C1913je e) {
                                                                    C1524b.m2155a((Throwable) e);
                                                                    break;
                                                                }
                                                            }
                                                        } else {
                                                            C1524b.m2161e("resp-type:" + inVar.f3229d + ", " + inVar.mo18077a());
                                                            if (inVar.mo18077a() != null) {
                                                                int i5 = -2;
                                                                if (inVar.mo18077a().containsKey(C2014bd.f3780L)) {
                                                                    String str10 = (String) inVar.mo18077a().get(C2014bd.f3780L);
                                                                    if (!TextUtils.isEmpty(str10)) {
                                                                        try {
                                                                            i5 = Integer.parseInt(str10);
                                                                        } catch (NumberFormatException e2) {
                                                                            e2.printStackTrace();
                                                                        }
                                                                    }
                                                                }
                                                                if (i5 >= -1) {
                                                                    MiPushClient.clearNotification(this.f1663a, i5);
                                                                } else {
                                                                    MiPushClient.clearNotification(this.f1663a, inVar.mo18077a().containsKey(C2014bd.f3778J) ? (String) inVar.mo18077a().get(C2014bd.f3778J) : "", inVar.mo18077a().containsKey(C2014bd.f3779K) ? (String) inVar.mo18077a().get(C2014bd.f3779K) : "");
                                                                }
                                                            }
                                                            m2302a(inVar);
                                                            break;
                                                        }
                                                    } else {
                                                        C1524b.m2141a("receive force sync notification");
                                                        C1576av.m2369a(this.f1663a, false);
                                                        break;
                                                    }
                                                } else {
                                                    C1576av.m2368a(this.f1663a, inVar);
                                                    break;
                                                }
                                            } else {
                                                C1892il ilVar = new C1892il();
                                                C1905iy.m4542a(ilVar, inVar.mo18077a());
                                                C1997au.m5062a(C1995at.m5047a(this.f1663a), ilVar);
                                                break;
                                            }
                                        } else {
                                            C1893im imVar = new C1893im();
                                            try {
                                                C1905iy.m4542a(imVar, inVar.mo18077a());
                                                C1997au.m5063a(C1995at.m5047a(this.f1663a), imVar);
                                                break;
                                            } catch (C1913je unused) {
                                                break;
                                            }
                                        }
                                    } else if (ikVar.mo18052b() && inVar.mo18077a() != null && inVar.mo18077a().containsKey("awake_info")) {
                                        Context context3 = this.f1663a;
                                        C1593o.m2461a(context3, C1578b.m2373a(context3).mo17163a(), C1995at.m5047a(this.f1663a).mo18465a(C1873ht.AwakeInfoUploadWaySwitch.mo17806a(), 0), (String) inVar.mo18077a().get("awake_info"));
                                        break;
                                    }
                                } else if (inVar.mo18077a() != null && inVar.mo18077a().containsKey(Constants.EXTRA_KEY_APP_VERSION)) {
                                    C1578b.m2373a(this.f1663a).mo17164a((String) inVar.mo18077a().get(Constants.EXTRA_KEY_APP_VERSION));
                                    break;
                                }
                            } else {
                                List<String> allAlias = MiPushClient.getAllAlias(this.f1663a);
                                List<String> allTopic = MiPushClient.getAllTopic(this.f1663a);
                                List<String> allUserAccount = MiPushClient.getAllUserAccount(this.f1663a);
                                String acceptTime = MiPushClient.getAcceptTime(this.f1663a);
                                C1524b.m2161e("resp-type:" + inVar.f3229d + ", " + inVar.mo18077a());
                                MiPushClient.reInitialize(this.f1663a, C1883ic.RegIdExpired);
                                for (String next : allAlias) {
                                    MiPushClient.removeAlias(this.f1663a, next);
                                    MiPushClient.setAlias(this.f1663a, next, (String) null);
                                }
                                for (String next2 : allTopic) {
                                    MiPushClient.removeTopic(this.f1663a, next2);
                                    MiPushClient.subscribe(this.f1663a, next2, (String) null);
                                }
                                for (String next3 : allUserAccount) {
                                    MiPushClient.removeAccount(this.f1663a, next3);
                                    MiPushClient.setUserAccount(this.f1663a, next3, (String) null);
                                }
                                String[] split = acceptTime.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                                if (split.length == 2) {
                                    MiPushClient.removeAcceptTime(this.f1663a);
                                    MiPushClient.addAcceptTime(this.f1663a, split[0], split[1]);
                                    break;
                                }
                            }
                        }
                    } else {
                        C1886if ifVar = (C1886if) a3;
                        String a12 = ifVar.mo17964a();
                        C1524b.m2161e("resp-type:" + ifVar.mo17967b() + ", code:" + ifVar.f3115a + ", " + a12);
                        if (!C1878hy.DisablePushMessage.f2959a.equalsIgnoreCase(ifVar.f3122d)) {
                            if (!C1878hy.EnablePushMessage.f2959a.equalsIgnoreCase(ifVar.f3122d)) {
                                if (!C1878hy.ThirdPartyRegUpdate.f2959a.equalsIgnoreCase(ifVar.f3122d)) {
                                    if (C1878hy.UploadTinyData.f2959a.equalsIgnoreCase(ifVar.f3122d)) {
                                        m2300a(ifVar);
                                        break;
                                    }
                                } else {
                                    m2307b(ifVar);
                                    break;
                                }
                            } else if (ifVar.f3115a != 0) {
                                if ("syncing".equals(C1559af.m2278a(this.f1663a).mo17126a(C1575au.ENABLE_PUSH))) {
                                    synchronized (C1559af.class) {
                                        if (C1559af.m2278a(this.f1663a).mo17125a(a12)) {
                                            if (C1559af.m2278a(this.f1663a).mo17125a(a12) < 10) {
                                                C1559af.m2278a(this.f1663a).mo17128b(a12);
                                                C1568ao.m2317a(this.f1663a).mo17152a(false, a12);
                                            } else {
                                                C1559af.m2278a(this.f1663a).mo17129c(a12);
                                            }
                                        }
                                    }
                                    break;
                                }
                            } else {
                                synchronized (C1559af.class) {
                                    if (C1559af.m2278a(this.f1663a).mo17125a(a12)) {
                                        C1559af.m2278a(this.f1663a).mo17129c(a12);
                                        if ("syncing".equals(C1559af.m2278a(this.f1663a).mo17126a(C1575au.ENABLE_PUSH))) {
                                            C1559af.m2278a(this.f1663a).mo17127a(C1575au.ENABLE_PUSH, "synced");
                                        }
                                    }
                                }
                                break;
                            }
                        } else if (ifVar.f3115a != 0) {
                            if ("syncing".equals(C1559af.m2278a(this.f1663a).mo17126a(C1575au.DISABLE_PUSH))) {
                                synchronized (C1559af.class) {
                                    if (C1559af.m2278a(this.f1663a).mo17125a(a12)) {
                                        if (C1559af.m2278a(this.f1663a).mo17125a(a12) < 10) {
                                            C1559af.m2278a(this.f1663a).mo17128b(a12);
                                            C1568ao.m2317a(this.f1663a).mo17152a(true, a12);
                                        } else {
                                            C1559af.m2278a(this.f1663a).mo17129c(a12);
                                        }
                                    }
                                }
                                break;
                            }
                        } else {
                            synchronized (C1559af.class) {
                                if (C1559af.m2278a(this.f1663a).mo17125a(a12)) {
                                    C1559af.m2278a(this.f1663a).mo17129c(a12);
                                    if ("syncing".equals(C1559af.m2278a(this.f1663a).mo17126a(C1575au.DISABLE_PUSH))) {
                                        C1559af.m2278a(this.f1663a).mo17127a(C1575au.DISABLE_PUSH, "synced");
                                        MiPushClient.clearNotification(this.f1663a);
                                        MiPushClient.clearLocalNotificationType(this.f1663a);
                                        PushMessageHandler.mo17007a();
                                        C1568ao.m2317a(this.f1663a).mo17153b();
                                    }
                                }
                            }
                            break;
                        }
                        C1559af.m2278a(this.f1663a).mo17129c(a12);
                        break;
                    }
                    break;
            }
            return null;
        } catch (C1599u e3) {
            C1524b.m2155a((Throwable) e3);
            m2301a(ikVar);
            a = C1776eu.m3405a(this.f1663a);
            packageName = this.f1663a.getPackageName();
            a2 = C1774et.m3389a(i);
            str2 = "19";
            a.mo17539b(packageName, a2, str8, str2);
            C1597s.m2470c(this.f1663a, ikVar2, z2);
            return null;
        } catch (C1913je e4) {
            C1524b.m2155a((Throwable) e4);
            C1524b.m2160d("receive a message which action string is not valid. is the reg expired?");
            a = C1776eu.m3405a(this.f1663a);
            packageName = this.f1663a.getPackageName();
            a2 = C1774et.m3389a(i);
            str2 = "20";
            a.mo17539b(packageName, a2, str8, str2);
            C1597s.m2470c(this.f1663a, ikVar2, z2);
            return null;
        }
    }

    /* renamed from: a */
    private PushMessageHandler.C1552a m2296a(C1891ik ikVar, byte[] bArr) {
        String str;
        String str2 = null;
        try {
            C1906iz a = C1562ai.m2289a(this.f1663a, ikVar);
            if (a == null) {
                C1524b.m2160d("message arrived: receiving an un-recognized message. " + ikVar.f3188a);
                return null;
            }
            C1868ho a2 = ikVar.mo18043a();
            C1524b.m2141a("message arrived: processing an arrived message, action=" + a2);
            if (C1567an.f1664a[a2.ordinal()] != 1) {
                return null;
            }
            if (!ikVar.mo18052b()) {
                str = "message arrived: receiving an un-encrypt message(SendMessage).";
            } else {
                C1898ir irVar = (C1898ir) a;
                C1881ia a3 = irVar.mo18204a();
                if (a3 == null) {
                    str = "message arrived: receive an empty message without push content, drop it";
                } else {
                    if (!(ikVar.f3189a == null || ikVar.f3189a.mo17876a() == null)) {
                        str2 = ikVar.f3189a.f3033a.get("jobkey");
                    }
                    MiPushMessage generateMessage = PushMessageHelper.generateMessage(irVar, ikVar.mo18043a(), false);
                    generateMessage.setArrivedMessage(true);
                    C1524b.m2141a("message arrived: receive a message, msgid=" + a3.mo17850a() + ", jobkey=" + str2);
                    return generateMessage;
                }
            }
            C1524b.m2160d(str);
            return null;
        } catch (C1599u e) {
            C1524b.m2155a((Throwable) e);
            str = "message arrived: receive a message but decrypt failed. report when click.";
        } catch (C1913je e2) {
            C1524b.m2155a((Throwable) e2);
            str = "message arrived: receive a message which action string is not valid. is the reg expired?";
        }
    }

    /* renamed from: a */
    public static C1566am m2297a(Context context) {
        if (f1660a == null) {
            f1660a = new C1566am(context);
        }
        return f1660a;
    }

    /* renamed from: a */
    private void m2298a() {
        SharedPreferences sharedPreferences = this.f1663a.getSharedPreferences("mipush_extra", 0);
        long currentTimeMillis = System.currentTimeMillis();
        if (Math.abs(currentTimeMillis - sharedPreferences.getLong(Constants.SP_KEY_LAST_REINITIALIZE, 0)) > 1800000) {
            MiPushClient.reInitialize(this.f1663a, C1883ic.PackageUnregistered);
            sharedPreferences.edit().putLong(Constants.SP_KEY_LAST_REINITIALIZE, currentTimeMillis).commit();
        }
    }

    /* renamed from: a */
    public static void m2299a(Context context, String str) {
        synchronized (f1661a) {
            f1662a.remove(str);
            C1578b.m2373a(context);
            SharedPreferences a = C1578b.m2373a(context);
            String a2 = C1663bo.m2729a((Collection<?>) f1662a, Constants.ACCEPT_TIME_SEPARATOR_SP);
            SharedPreferences.Editor edit = a.edit();
            edit.putString("pref_msg_ids", a2);
            C1945s.m4744a(edit);
        }
    }

    /* renamed from: a */
    private void m2300a(C1886if ifVar) {
        String a = ifVar.mo17964a();
        C1524b.m2158b("receive ack " + a);
        Map a2 = ifVar.mo17964a();
        if (a2 != null) {
            String str = (String) a2.get("real_source");
            if (!TextUtils.isEmpty(str)) {
                C1524b.m2158b("receive ack : messageId = " + a + "  realSource = " + str);
                C1671bw.m2760a(this.f1663a).mo17274a(a, str, Boolean.valueOf(ifVar.f3115a == 0));
            }
        }
    }

    /* renamed from: a */
    private void m2301a(C1891ik ikVar) {
        C1524b.m2141a("receive a message but decrypt failed. report now.");
        C1894in inVar = new C1894in(ikVar.mo18043a().f3031a, false);
        inVar.mo18087c(C1878hy.DecryptMessageFail.f2959a);
        inVar.mo18084b(ikVar.mo18043a());
        inVar.mo18091d(ikVar.f3195b);
        inVar.f3224a = new HashMap();
        inVar.f3224a.put("regid", MiPushClient.getRegId(this.f1663a));
        C1568ao.m2317a(this.f1663a).mo17143a(inVar, C1868ho.Notification, false, (C1882ib) null);
    }

    /* renamed from: a */
    private void m2302a(C1894in inVar) {
        C1886if ifVar = new C1886if();
        ifVar.mo17968c(C1878hy.CancelPushMessageACK.f2959a);
        ifVar.mo17963a(inVar.mo18077a());
        ifVar.mo17962a(inVar.mo18077a());
        ifVar.mo17966b(inVar.mo18085b());
        ifVar.mo17973e(inVar.mo18088c());
        ifVar.mo17961a(0);
        ifVar.mo17971d("success clear push message.");
        C1568ao.m2317a(this.f1663a).mo17147a(ifVar, C1868ho.Notification, false, true, (C1882ib) null, false, this.f1663a.getPackageName(), C1578b.m2373a(this.f1663a).mo17163a(), false);
    }

    /* renamed from: a */
    private void m2303a(C1898ir irVar, C1891ik ikVar) {
        C1882ib a = ikVar.mo18043a();
        if (a != null) {
            a = C2023bk.m5141a(a.mo17876a());
        }
        C1885ie ieVar = new C1885ie();
        ieVar.mo17930b(irVar.mo18206b());
        ieVar.mo17926a(irVar.mo18204a());
        ieVar.mo17925a(irVar.mo18204a().mo17850a());
        if (!TextUtils.isEmpty(irVar.mo18207c())) {
            ieVar.mo17933c(irVar.mo18207c());
        }
        if (!TextUtils.isEmpty(irVar.mo18209d())) {
            ieVar.mo17937d(irVar.mo18209d());
        }
        ieVar.mo17927a(C1905iy.m4541a(this.f1663a, ikVar));
        C1568ao.m2317a(this.f1663a).mo17141a(ieVar, C1868ho.AckMessage, a);
    }

    /* renamed from: a */
    private void m2304a(String str, long j, C1582e eVar) {
        C1575au a = C1589l.m2448a(eVar);
        if (a != null) {
            if (j == 0) {
                synchronized (C1559af.class) {
                    if (C1559af.m2278a(this.f1663a).mo17125a(str)) {
                        C1559af.m2278a(this.f1663a).mo17129c(str);
                        if ("syncing".equals(C1559af.m2278a(this.f1663a).mo17126a(a))) {
                            C1559af.m2278a(this.f1663a).mo17127a(a, "synced");
                        }
                    }
                }
            } else if ("syncing".equals(C1559af.m2278a(this.f1663a).mo17126a(a))) {
                synchronized (C1559af.class) {
                    if (C1559af.m2278a(this.f1663a).mo17125a(str)) {
                        if (C1559af.m2278a(this.f1663a).mo17125a(str) < 10) {
                            C1559af.m2278a(this.f1663a).mo17128b(str);
                            C1568ao.m2317a(this.f1663a).mo17149a(str, a, eVar);
                        } else {
                            C1559af.m2278a(this.f1663a).mo17129c(str);
                        }
                    }
                }
            } else {
                C1559af.m2278a(this.f1663a).mo17129c(str);
            }
        }
    }

    /* renamed from: a */
    private static boolean m2305a(Context context, String str) {
        synchronized (f1661a) {
            C1578b.m2373a(context);
            SharedPreferences a = C1578b.m2373a(context);
            if (f1662a == null) {
                String[] split = a.getString("pref_msg_ids", "").split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                f1662a = new LinkedList();
                for (String add : split) {
                    f1662a.add(add);
                }
            }
            if (f1662a.contains(str)) {
                return true;
            }
            f1662a.add(str);
            if (f1662a.size() > 25) {
                f1662a.poll();
            }
            String a2 = C1663bo.m2729a((Collection<?>) f1662a, Constants.ACCEPT_TIME_SEPARATOR_SP);
            SharedPreferences.Editor edit = a.edit();
            edit.putString("pref_msg_ids", a2);
            C1945s.m4744a(edit);
            return false;
        }
    }

    /* renamed from: a */
    private boolean m2306a(C1891ik ikVar) {
        Map a = ikVar.mo18043a() == null ? null : ikVar.mo18043a().mo17876a();
        if (a == null) {
            return false;
        }
        String str = (String) a.get(Constants.EXTRA_KEY_PUSH_SERVER_ACTION);
        return TextUtils.equals(str, Constants.EXTRA_VALUE_HYBRID_MESSAGE) || TextUtils.equals(str, Constants.EXTRA_VALUE_PLATFORM_MESSAGE);
    }

    /* renamed from: b */
    private void m2307b(C1886if ifVar) {
        long j;
        C1582e eVar;
        C1524b.m2159c("ASSEMBLE_PUSH : " + ifVar.toString());
        String a = ifVar.mo17964a();
        Map a2 = ifVar.mo17964a();
        if (a2 != null) {
            String str = (String) a2.get(Constants.ASSEMBLE_PUSH_REG_INFO);
            if (!TextUtils.isEmpty(str)) {
                if (str.contains("brand:" + C1560ag.f1653c.name())) {
                    C1524b.m2141a("ASSEMBLE_PUSH : receive fcm token sync ack");
                    C1586i.m2444b(this.f1663a, C1582e.ASSEMBLE_PUSH_FCM, str);
                    j = ifVar.f3115a;
                    eVar = C1582e.ASSEMBLE_PUSH_FCM;
                } else {
                    if (str.contains("brand:" + C1560ag.HUAWEI.name())) {
                        C1524b.m2141a("ASSEMBLE_PUSH : receive hw token sync ack");
                        C1586i.m2444b(this.f1663a, C1582e.ASSEMBLE_PUSH_HUAWEI, str);
                        j = ifVar.f3115a;
                        eVar = C1582e.ASSEMBLE_PUSH_HUAWEI;
                    } else {
                        if (str.contains("brand:" + C1560ag.f1654d.name())) {
                            C1524b.m2141a("ASSEMBLE_PUSH : receive COS token sync ack");
                            C1586i.m2444b(this.f1663a, C1582e.ASSEMBLE_PUSH_COS, str);
                            j = ifVar.f3115a;
                            eVar = C1582e.ASSEMBLE_PUSH_COS;
                        } else {
                            if (str.contains("brand:" + C1560ag.f1655e.name())) {
                                C1524b.m2141a("ASSEMBLE_PUSH : receive FTOS token sync ack");
                                C1586i.m2444b(this.f1663a, C1582e.ASSEMBLE_PUSH_FTOS, str);
                                j = ifVar.f3115a;
                                eVar = C1582e.ASSEMBLE_PUSH_FTOS;
                            } else {
                                return;
                            }
                        }
                    }
                }
                m2304a(a, j, eVar);
            }
        }
    }

    /* renamed from: b */
    private void m2308b(C1891ik ikVar) {
        C1882ib a = ikVar.mo18043a();
        if (a != null) {
            a = C2023bk.m5141a(a.mo17876a());
        }
        C1885ie ieVar = new C1885ie();
        ieVar.mo17930b(ikVar.mo18043a());
        ieVar.mo17926a(a.mo17876a());
        ieVar.mo17925a(a.mo17876a());
        if (!TextUtils.isEmpty(a.mo17883b())) {
            ieVar.mo17933c(a.mo17883b());
        }
        ieVar.mo17927a(C1905iy.m4541a(this.f1663a, ikVar));
        C1568ao.m2317a(this.f1663a).mo17143a(ieVar, C1868ho.AckMessage, false, a);
    }

    /* renamed from: a */
    public PushMessageHandler.C1552a mo17131a(Intent intent) {
        String str;
        String str2;
        String str3;
        C1776eu euVar;
        C1776eu a;
        String packageName;
        String format;
        String action = intent.getAction();
        C1524b.m2141a("receive an intent from server, action=" + action);
        String stringExtra = intent.getStringExtra("mrt");
        if (stringExtra == null) {
            stringExtra = Long.toString(System.currentTimeMillis());
        }
        String stringExtra2 = intent.getStringExtra("messageId");
        int intExtra = intent.getIntExtra("eventMessageType", -1);
        if ("com.xiaomi.mipush.RECEIVE_MESSAGE".equals(action)) {
            byte[] byteArrayExtra = intent.getByteArrayExtra("mipush_payload");
            boolean booleanExtra = intent.getBooleanExtra("mipush_notified", false);
            if (byteArrayExtra == null) {
                C1524b.m2160d("receiving an empty message, drop");
                C1776eu.m3405a(this.f1663a).mo17535a(this.f1663a.getPackageName(), intent, "12");
                return null;
            }
            C1891ik ikVar = new C1891ik();
            try {
                C1905iy.m4542a(ikVar, byteArrayExtra);
                C1578b a2 = C1578b.m2373a(this.f1663a);
                C1882ib a3 = ikVar.mo18043a();
                if (ikVar.mo18043a() == C1868ho.SendMessage && a3 != null && !a2.mo17175e() && !booleanExtra) {
                    a3.mo17881a("mrt", stringExtra);
                    a3.mo17881a("mat", Long.toString(System.currentTimeMillis()));
                    if (!m2301a(ikVar)) {
                        m2308b(ikVar);
                    } else {
                        C1524b.m2158b("this is a mina's message, ack later");
                        a3.mo17881a(Constants.EXTRA_KEY_HYBRID_MESSAGE_TS, String.valueOf(a3.mo17876a()));
                        a3.mo17881a(Constants.EXTRA_KEY_HYBRID_DEVICE_STATUS, String.valueOf(C1905iy.m4541a(this.f1663a, ikVar)));
                    }
                }
                String str4 = "";
                if (ikVar.mo18043a() == C1868ho.SendMessage) {
                    if (!ikVar.mo18052b()) {
                        if (C1974af.m4915a(ikVar)) {
                            Object[] objArr = new Object[2];
                            objArr[0] = ikVar.mo18052b();
                            if (a3 != null) {
                                str4 = a3.mo17876a();
                            }
                            objArr[1] = str4;
                            C1524b.m2141a(String.format("drop an un-encrypted wake-up messages. %1$s, %2$s", objArr));
                            a = C1776eu.m3405a(this.f1663a);
                            packageName = this.f1663a.getPackageName();
                            format = String.format("13: %1$s", new Object[]{ikVar.mo18052b()});
                        } else {
                            Object[] objArr2 = new Object[2];
                            objArr2[0] = ikVar.mo18052b();
                            if (a3 != null) {
                                str4 = a3.mo17876a();
                            }
                            objArr2[1] = str4;
                            C1524b.m2141a(String.format("drop an un-encrypted messages. %1$s, %2$s", objArr2));
                            a = C1776eu.m3405a(this.f1663a);
                            packageName = this.f1663a.getPackageName();
                            format = String.format("14: %1$s", new Object[]{ikVar.mo18052b()});
                        }
                        a.mo17535a(packageName, intent, format);
                        C1597s.m2467a(this.f1663a, ikVar, booleanExtra);
                        return null;
                    }
                }
                if (ikVar.mo18043a() == C1868ho.SendMessage && ikVar.mo18052b() && C1974af.m4915a(ikVar)) {
                    if (!booleanExtra || a3 == null || a3.mo17876a() == null || !a3.mo17876a().containsKey("notify_effect")) {
                        Object[] objArr3 = new Object[2];
                        objArr3[0] = ikVar.mo18052b();
                        if (a3 != null) {
                            str4 = a3.mo17876a();
                        }
                        objArr3[1] = str4;
                        C1524b.m2141a(String.format("drop a wake-up messages which not has 'notify_effect' attr. %1$s, %2$s", objArr3));
                        C1776eu.m3405a(this.f1663a).mo17535a(this.f1663a.getPackageName(), intent, String.format("25: %1$s", new Object[]{ikVar.mo18052b()}));
                        C1597s.m2469b(this.f1663a, ikVar, booleanExtra);
                        return null;
                    }
                }
                if (a2.mo17173c() || ikVar.f3188a == C1868ho.Registration) {
                    if (!a2.mo17173c() || !a2.mo17176f()) {
                        return m2295a(ikVar, booleanExtra, byteArrayExtra, stringExtra2, intExtra, intent);
                    }
                    if (ikVar.f3188a == C1868ho.UnRegistration) {
                        a2.mo17163a();
                        MiPushClient.clearExtras(this.f1663a);
                        PushMessageHandler.mo17007a();
                    } else {
                        C1597s.m2472e(this.f1663a, ikVar, booleanExtra);
                        MiPushClient.unregisterPush(this.f1663a);
                    }
                } else if (C1974af.m4915a(ikVar)) {
                    return m2295a(ikVar, booleanExtra, byteArrayExtra, stringExtra2, intExtra, intent);
                } else {
                    C1597s.m2472e(this.f1663a, ikVar, booleanExtra);
                    boolean d = a2.mo17174d();
                    C1524b.m2160d("receive message without registration. need re-register!registered?" + d);
                    C1776eu.m3405a(this.f1663a).mo17535a(this.f1663a.getPackageName(), intent, "15");
                    if (d) {
                        m2298a();
                    }
                }
            } catch (C1913je e) {
                e = e;
                euVar = C1776eu.m3405a(this.f1663a);
                str3 = this.f1663a.getPackageName();
                str2 = "16";
                euVar.mo17535a(str3, intent, str2);
                C1524b.m2155a(e);
                return null;
            } catch (Exception e2) {
                e = e2;
                euVar = C1776eu.m3405a(this.f1663a);
                str3 = this.f1663a.getPackageName();
                str2 = "17";
                euVar.mo17535a(str3, intent, str2);
                C1524b.m2155a(e);
                return null;
            }
        } else if ("com.xiaomi.mipush.ERROR".equals(action)) {
            MiPushCommandMessage miPushCommandMessage = new MiPushCommandMessage();
            C1891ik ikVar2 = new C1891ik();
            try {
                byte[] byteArrayExtra2 = intent.getByteArrayExtra("mipush_payload");
                if (byteArrayExtra2 != null) {
                    C1905iy.m4542a(ikVar2, byteArrayExtra2);
                }
            } catch (C1913je unused) {
            }
            miPushCommandMessage.setCommand(String.valueOf(ikVar2.mo18043a()));
            miPushCommandMessage.setResultCode((long) intent.getIntExtra("mipush_error_code", 0));
            miPushCommandMessage.setReason(intent.getStringExtra("mipush_error_msg"));
            C1524b.m2160d("receive a error message. code = " + intent.getIntExtra("mipush_error_code", 0) + ", msg= " + intent.getStringExtra("mipush_error_msg"));
            return miPushCommandMessage;
        } else if ("com.xiaomi.mipush.MESSAGE_ARRIVED".equals(action)) {
            byte[] byteArrayExtra3 = intent.getByteArrayExtra("mipush_payload");
            if (byteArrayExtra3 == null) {
                C1524b.m2160d("message arrived: receiving an empty message, drop");
                return null;
            }
            C1891ik ikVar3 = new C1891ik();
            try {
                C1905iy.m4542a(ikVar3, byteArrayExtra3);
                C1578b a4 = C1578b.m2373a(this.f1663a);
                if (C1974af.m4915a(ikVar3)) {
                    str = "message arrived: receive ignore reg message, ignore!";
                } else if (!a4.mo17173c()) {
                    str = "message arrived: receive message without registration. need unregister or re-register!";
                } else if (!a4.mo17173c() || !a4.mo17176f()) {
                    return m2296a(ikVar3, byteArrayExtra3);
                } else {
                    str = "message arrived: app info is invalidated";
                }
                C1524b.m2160d(str);
            } catch (Exception e3) {
                C1524b.m2160d("fail to deal with arrived message. " + e3);
            }
        }
        return null;
    }

    /* renamed from: a */
    public List<String> mo17132a(TimeZone timeZone, TimeZone timeZone2, List<String> list) {
        List<String> list2 = list;
        if (timeZone.equals(timeZone2)) {
            return list2;
        }
        long rawOffset = (long) (((timeZone.getRawOffset() - timeZone2.getRawOffset()) / 1000) / 60);
        long parseLong = Long.parseLong(list2.get(0).split(Constants.COLON_SEPARATOR)[0]);
        long parseLong2 = Long.parseLong(list2.get(0).split(Constants.COLON_SEPARATOR)[1]);
        long j = ((((parseLong * 60) + parseLong2) - rawOffset) + 1440) % 1440;
        long parseLong3 = ((((Long.parseLong(list2.get(1).split(Constants.COLON_SEPARATOR)[0]) * 60) + Long.parseLong(list2.get(1).split(Constants.COLON_SEPARATOR)[1])) - rawOffset) + 1440) % 1440;
        ArrayList arrayList = new ArrayList();
        arrayList.add(String.format("%1$02d:%2$02d", new Object[]{Long.valueOf(j / 60), Long.valueOf(j % 60)}));
        arrayList.add(String.format("%1$02d:%2$02d", new Object[]{Long.valueOf(parseLong3 / 60), Long.valueOf(parseLong3 % 60)}));
        return arrayList;
    }
}
