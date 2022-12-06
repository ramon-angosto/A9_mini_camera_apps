package com.xiaomi.push.service;

import android.app.Notification;
import android.app.NotificationChannel;
import android.content.Context;
import android.graphics.drawable.Icon;
import android.os.Build;
import android.os.Bundle;
import android.service.notification.StatusBarNotification;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.C1524b;
import com.xiaomi.push.C1656bj;
import com.xiaomi.push.C1873ht;
import com.xiaomi.push.C1938m;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.xiaomi.push.service.ao */
class C1986ao {

    /* renamed from: a */
    private static C1986ao f3690a = new C1986ao();

    /* renamed from: com.xiaomi.push.service.ao$a */
    private class C1987a {

        /* renamed from: a */
        List<C1988b> f3692a;

        /* renamed from: b */
        List<C1988b> f3693b;

        private C1987a() {
            this.f3692a = new ArrayList();
            this.f3693b = new ArrayList();
        }
    }

    /* renamed from: com.xiaomi.push.service.ao$b */
    private class C1988b {

        /* renamed from: a */
        int f3694a;

        /* renamed from: a */
        Notification f3695a;

        public C1988b(int i, Notification notification) {
            this.f3694a = i;
            this.f3695a = notification;
        }

        public String toString() {
            return "id:" + this.f3694a;
        }
    }

    private C1986ao() {
    }

    /* renamed from: a */
    private int m4979a(String str, String str2) {
        return ("GroupSummary" + str + str2).hashCode();
    }

    /* renamed from: a */
    public static C1986ao m4980a() {
        return f3690a;
    }

    /* renamed from: a */
    private String m4981a(Notification notification) {
        if (notification == null || notification.extras == null) {
            return null;
        }
        return notification.extras.getString("push_src_group_name");
    }

    /* renamed from: a */
    private List<StatusBarNotification> m4982a(C1993ar arVar) {
        List<StatusBarNotification> b = arVar != null ? arVar.mo18462b() : null;
        if (b == null || b.size() == 0) {
            return null;
        }
        return b;
    }

    /* renamed from: a */
    private void m4983a(Context context, int i, Notification notification, boolean z) {
        String str;
        String c = C1994as.m5046c(notification);
        if (TextUtils.isEmpty(c)) {
            str = "group auto not extract pkg from notification:" + i;
        } else {
            List<StatusBarNotification> a = m4982a(C1993ar.m5005a(context, c));
            if (a == null) {
                str = "group auto not get notifications";
            } else {
                String b = m4990b(notification);
                HashMap hashMap = new HashMap();
                for (StatusBarNotification next : a) {
                    if (!(next.getNotification() == null || next.getId() == i)) {
                        m4986a((Map<String, C1987a>) hashMap, next);
                    }
                }
                for (Map.Entry entry : hashMap.entrySet()) {
                    String str2 = (String) entry.getKey();
                    if (!TextUtils.isEmpty(str2)) {
                        C1987a aVar = (C1987a) entry.getValue();
                        if (z && str2.equals(b) && !m4990b(notification)) {
                            (m4981a(notification) ? aVar.f3693b : aVar.f3692a).add(new C1988b(i, notification));
                        }
                        int size = aVar.f3692a.size();
                        if (aVar.f3693b.size() <= 0) {
                            if (z && size >= 2) {
                                m4985a(context, c, str2, aVar.f3692a.get(0).f3695a);
                            }
                        } else if (size <= 0) {
                            m4984a(context, c, str2);
                        }
                    }
                }
                return;
            }
        }
        C1524b.m2141a(str);
    }

    /* renamed from: a */
    private void m4984a(Context context, String str, String str2) {
        C1524b.m2158b("group cancel summary:" + str2);
        C1993ar.m5005a(context, str).mo18458a(m4979a(str, str2));
    }

    /* renamed from: a */
    private void m4985a(Context context, String str, String str2, Notification notification) {
        Notification.Builder builder;
        try {
            if (TextUtils.isEmpty(str2)) {
                C1524b.m2141a("group show summary group is null");
                return;
            }
            int a = C1994as.m5030a(context, str);
            if (a == 0) {
                C1524b.m2141a("group show summary not get icon from " + str);
                return;
            }
            C1993ar a2 = C1993ar.m5005a(context, str);
            if (Build.VERSION.SDK_INT >= 26) {
                String b = a2.mo18463b(notification.getChannelId(), "groupSummary");
                NotificationChannel a3 = a2.mo18456a(b);
                if ("groupSummary".equals(b) && a3 == null) {
                    a2.mo18460a(new NotificationChannel(b, "group_summary", 3));
                }
                builder = new Notification.Builder(context, b);
            } else {
                builder = new Notification.Builder(context).setPriority(0).setDefaults(-1);
            }
            C1994as.m5040a(builder, true);
            Notification build = builder.setContentTitle("GroupSummary").setContentText("GroupSummary").setSmallIcon(Icon.createWithResource(str, a)).setAutoCancel(true).setGroup(str2).setGroupSummary(true).build();
            if (!C1938m.m4729c() && "com.xiaomi.xmsf".equals(context.getPackageName())) {
                C1994as.m5031a(build, str);
            }
            int a4 = m4979a(str, str2);
            a2.mo18459a(a4, build);
            C1524b.m2158b("group show summary notify:" + a4);
        } catch (Exception e) {
            C1524b.m2141a("group show summary error " + e);
        }
    }

    /* renamed from: a */
    private void m4986a(Map<String, C1987a> map, StatusBarNotification statusBarNotification) {
        String b = m4990b(statusBarNotification.getNotification());
        C1987a aVar = map.get(b);
        if (aVar == null) {
            aVar = new C1987a();
            map.put(b, aVar);
        }
        (m4981a(statusBarNotification.getNotification()) ? aVar.f3693b : aVar.f3692a).add(new C1988b(statusBarNotification.getId(), statusBarNotification.getNotification()));
    }

    /* renamed from: a */
    private boolean m4987a() {
        return Build.VERSION.SDK_INT >= 24;
    }

    /* renamed from: a */
    private boolean m4988a(Notification notification) {
        if (notification == null) {
            return false;
        }
        Object a = C1656bj.m2697a((Object) notification, "isGroupSummary", (Object[]) null);
        if (a instanceof Boolean) {
            return ((Boolean) a).booleanValue();
        }
        return false;
    }

    /* renamed from: a */
    private boolean m4989a(Context context) {
        if (m4993b(context) && C1993ar.m5010a(context)) {
            return C1995at.m5047a(context).mo18472a(C1873ht.LatestNotificationNotIntoGroupSwitch.mo17806a(), false);
        }
        return false;
    }

    /* renamed from: b */
    private String m4990b(Notification notification) {
        if (notification == null) {
            return null;
        }
        return m4990b(notification) ? m4981a(notification) : notification.getGroup();
    }

    /* renamed from: b */
    private void m4991b(Context context, int i, Notification notification) {
        String str;
        String c = C1994as.m5046c(notification);
        if (TextUtils.isEmpty(c)) {
            str = "group restore not extract pkg from notification:" + i;
        } else {
            C1993ar a = C1993ar.m5005a(context, c);
            List<StatusBarNotification> a2 = m4982a(a);
            if (a2 == null) {
                str = "group restore not get notifications";
            } else {
                for (StatusBarNotification next : a2) {
                    Notification notification2 = next.getNotification();
                    if (!(notification2 == null || !m4990b(notification2) || next.getId() == i)) {
                        Notification.Builder recoverBuilder = Notification.Builder.recoverBuilder(context, next.getNotification());
                        recoverBuilder.setGroup(m4981a(notification2));
                        C1994as.m5040a(recoverBuilder, m4981a(notification2));
                        a.mo18459a(next.getId(), recoverBuilder.build());
                        C1524b.m2158b("group restore notification:" + next.getId());
                    }
                }
                return;
            }
        }
        C1524b.m2141a(str);
    }

    /* renamed from: b */
    private boolean m4992b(Notification notification) {
        if (notification == null || notification.getGroup() == null || notification.extras == null) {
            return false;
        }
        long j = notification.extras.getLong("push_src_group_time");
        String a = m4981a(notification);
        return notification.getGroup().equals(String.format("pushmask_%s_%s", new Object[]{Long.valueOf(j), a}));
    }

    /* renamed from: b */
    private boolean m4993b(Context context) {
        return C1995at.m5047a(context).mo18472a(C1873ht.NotificationAutoGroupSwitch.mo17806a(), true);
    }

    /* renamed from: a */
    public String mo18453a(Context context, Notification.Builder builder, String str) {
        if (!m4980a() || !m4989a(context)) {
            return str;
        }
        long currentTimeMillis = System.currentTimeMillis();
        Bundle extras = builder.getExtras();
        extras.putString("push_src_group_name", str);
        extras.putLong("push_src_group_time", currentTimeMillis);
        return String.format("pushmask_%s_%s", new Object[]{Long.valueOf(currentTimeMillis), str});
    }

    /* renamed from: a */
    public void mo18454a(Context context, int i, Notification notification) {
        if (m4980a()) {
            if (m4989a(context)) {
                try {
                    m4991b(context, i, notification);
                } catch (Exception e) {
                    C1524b.m2141a("group notify handle restore error " + e);
                }
            }
            if (m4993b(context)) {
                try {
                    m4983a(context, i, notification, true);
                } catch (Exception e2) {
                    C1524b.m2141a("group notify handle auto error " + e2);
                }
            }
        }
    }
}
