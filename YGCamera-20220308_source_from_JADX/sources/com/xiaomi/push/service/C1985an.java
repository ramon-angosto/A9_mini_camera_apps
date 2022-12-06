package com.xiaomi.push.service;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.media.AudioAttributes;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.xiaomi.channel.commonutils.logger.C1524b;
import com.xiaomi.push.C1816g;
import com.xiaomi.push.C1938m;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/* renamed from: com.xiaomi.push.service.an */
public class C1985an {

    /* renamed from: a */
    private static boolean f3689a = Log.isLoggable("NCHelper", 3);

    /* renamed from: a */
    private static NotificationChannel m4967a(String str, NotificationChannel notificationChannel) {
        NotificationChannel notificationChannel2 = new NotificationChannel(str, notificationChannel.getName(), notificationChannel.getImportance());
        notificationChannel2.setDescription(notificationChannel.getDescription());
        notificationChannel2.enableVibration(notificationChannel.shouldVibrate());
        notificationChannel2.enableLights(notificationChannel.shouldShowLights());
        notificationChannel2.setSound(notificationChannel.getSound(), notificationChannel.getAudioAttributes());
        notificationChannel2.setLockscreenVisibility(notificationChannel.getLockscreenVisibility());
        return notificationChannel2;
    }

    /* renamed from: a */
    private static SharedPreferences m4968a(Context context) {
        return context.getSharedPreferences("mipush_channel_copy_sp", 0);
    }

    /* renamed from: a */
    public static String m4969a(C1993ar arVar) {
        String b = arVar.mo18462b();
        try {
            NotificationChannel notificationChannel = new NotificationChannel(b, C1816g.m3669b(arVar.mo18457a(), arVar.mo18457a()), 3);
            if (f3689a) {
                m4974a("create default channel:" + notificationChannel);
            }
            m4973a(arVar, notificationChannel);
        } catch (Exception e) {
            C1524b.m2144a("NCHelper", "create default channel error " + e);
        }
        return b;
    }

    /* renamed from: a */
    public static String m4970a(C1993ar arVar, String str, CharSequence charSequence, String str2, int i, int i2, String str3) {
        String a = arVar.mo18456a(str);
        try {
            if (f3689a) {
                m4974a("createChannel: appChannelId:" + a + " serverChannelId:" + str + " serverChannelName:" + charSequence + " serverChannelDesc:" + str2 + " serverChannelNotifyType:" + i + " serverChannelName:" + charSequence + " serverChannelImportance:" + i2 + " channelSoundStr:" + str3);
            }
            NotificationChannel notificationChannel = new NotificationChannel(a, charSequence, i2);
            notificationChannel.setDescription(str2);
            boolean z = false;
            notificationChannel.enableVibration((i & 2) != 0);
            if ((i & 4) != 0) {
                z = true;
            }
            notificationChannel.enableLights(z);
            if ((i & 1) == 0) {
                notificationChannel.setSound((Uri) null, (AudioAttributes) null);
            } else if (!TextUtils.isEmpty(str3)) {
                if (str3.startsWith("android.resource://" + arVar.mo18457a())) {
                    notificationChannel.setSound(Uri.parse(str3), Notification.AUDIO_ATTRIBUTES_DEFAULT);
                }
            }
            if (f3689a) {
                m4974a("create channel:" + notificationChannel);
            }
            m4973a(arVar, notificationChannel);
        } catch (Exception e) {
            C1524b.m2144a("NCHelper", "create channel error " + e);
        }
        return a;
    }

    /* renamed from: a */
    public static void m4971a(Context context, String str) {
        if (C1938m.m4714a(context) && !TextUtils.isEmpty(str)) {
            try {
                C1993ar a = C1993ar.m5005a(context, str);
                Set<String> keySet = m4968a(context).getAll().keySet();
                ArrayList arrayList = new ArrayList();
                for (String next : keySet) {
                    if (a.mo18456a(next)) {
                        arrayList.add(next);
                        if (f3689a) {
                            m4974a("delete channel copy record:" + next);
                        }
                    }
                }
                m4972a(context, (List<String>) arrayList);
            } catch (Exception unused) {
            }
        }
    }

    /* renamed from: a */
    private static void m4972a(Context context, List<String> list) {
        if (f3689a) {
            m4974a("deleteCopiedChannelRecord:" + list);
        }
        if (!list.isEmpty()) {
            SharedPreferences.Editor edit = m4968a(context).edit();
            for (String remove : list) {
                edit.remove(remove);
            }
            edit.apply();
        }
    }

    /* renamed from: a */
    private static void m4973a(C1993ar arVar, NotificationChannel notificationChannel) {
        if (arVar == null || notificationChannel == null) {
            throw new Exception("params cannot be null");
        } else if (!TextUtils.isEmpty(notificationChannel.getId())) {
            Context a = arVar.mo18457a();
            String id = notificationChannel.getId();
            String a2 = C1993ar.m5008a(id, arVar.mo18457a());
            if (f3689a) {
                m4974a("appChannelId:" + id + " oldChannelId:" + a2);
            }
            if (!C1938m.m4714a(a) || TextUtils.equals(id, a2)) {
                NotificationChannel a3 = arVar.mo18456a(id);
                if (f3689a) {
                    m4974a("elseLogic getNotificationChannel:" + a3);
                }
                if (a3 != null) {
                    return;
                }
            } else {
                NotificationManager notificationManager = (NotificationManager) a.getSystemService(RemoteMessageConst.NOTIFICATION);
                NotificationChannel notificationChannel2 = notificationManager.getNotificationChannel(a2);
                NotificationChannel a4 = arVar.mo18456a(id);
                if (f3689a) {
                    m4974a("xmsfChannel:" + notificationChannel2);
                    m4974a("appChannel:" + a4);
                }
                if (notificationChannel2 != null) {
                    NotificationChannel a5 = m4967a(id, notificationChannel2);
                    if (f3689a) {
                        m4974a("copyXmsf copyXmsfChannel:" + a5);
                    }
                    if (a4 != null) {
                        arVar.mo18461a(a5, !m4975a(a4));
                    } else {
                        arVar.mo18460a(a5);
                    }
                    m4978b(a, id);
                    notificationManager.deleteNotificationChannel(a2);
                    return;
                } else if (a4 != null) {
                    if (!m4971a(a, id) && m4976a(notificationChannel, a4)) {
                        if (f3689a) {
                            m4974a("appHack updateNotificationChannel:" + notificationChannel);
                        }
                        arVar.mo18461a(notificationChannel, !m4975a(a4));
                        return;
                    }
                    return;
                } else if (f3689a) {
                    m4974a("appHack createNotificationChannel:" + notificationChannel);
                }
            }
            arVar.mo18460a(notificationChannel);
        } else {
            throw new Exception("serverChannel id cannot be empty");
        }
    }

    /* renamed from: a */
    private static void m4974a(String str) {
        C1524b.m2144a("NCHelper", str);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x004c A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:13:? A[RETURN, SYNTHETIC] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean m4975a(android.app.NotificationChannel r4) {
        /*
            r0 = 0
            java.lang.String r1 = "getUserLockedFields"
            java.lang.Object[] r2 = new java.lang.Object[r0]     // Catch:{ Exception -> 0x0032 }
            java.lang.Object r1 = com.xiaomi.push.C1656bj.m2706b((java.lang.Object) r4, (java.lang.String) r1, (java.lang.Object[]) r2)     // Catch:{ Exception -> 0x0032 }
            java.lang.Integer r1 = (java.lang.Integer) r1     // Catch:{ Exception -> 0x0032 }
            int r1 = r1.intValue()     // Catch:{ Exception -> 0x0032 }
            boolean r2 = f3689a     // Catch:{ Exception -> 0x0030 }
            if (r2 == 0) goto L_0x004a
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0030 }
            r2.<init>()     // Catch:{ Exception -> 0x0030 }
            java.lang.String r3 = "isUserLockedChannel:"
            r2.append(r3)     // Catch:{ Exception -> 0x0030 }
            r2.append(r1)     // Catch:{ Exception -> 0x0030 }
            java.lang.String r3 = " "
            r2.append(r3)     // Catch:{ Exception -> 0x0030 }
            r2.append(r4)     // Catch:{ Exception -> 0x0030 }
            java.lang.String r4 = r2.toString()     // Catch:{ Exception -> 0x0030 }
            m4974a((java.lang.String) r4)     // Catch:{ Exception -> 0x0030 }
            goto L_0x004a
        L_0x0030:
            r4 = move-exception
            goto L_0x0034
        L_0x0032:
            r4 = move-exception
            r1 = 0
        L_0x0034:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "is user locked error"
            r2.append(r3)
            r2.append(r4)
            java.lang.String r4 = r2.toString()
            java.lang.String r2 = "NCHelper"
            com.xiaomi.channel.commonutils.logger.C1524b.m2144a((java.lang.String) r2, (java.lang.String) r4)
        L_0x004a:
            if (r1 <= 0) goto L_0x004d
            r0 = 1
        L_0x004d:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.service.C1985an.m4975a(android.app.NotificationChannel):boolean");
    }

    /* renamed from: a */
    private static boolean m4976a(NotificationChannel notificationChannel, NotificationChannel notificationChannel2) {
        boolean z;
        boolean z2 = false;
        if (notificationChannel == null || notificationChannel2 == null) {
            return false;
        }
        if (!TextUtils.equals(notificationChannel.getName(), notificationChannel2.getName())) {
            if (f3689a) {
                m4974a("appHack channelConfigLowerCompare:getName");
            }
            z = true;
        } else {
            z = false;
        }
        if (!TextUtils.equals(notificationChannel.getDescription(), notificationChannel2.getDescription())) {
            if (f3689a) {
                m4974a("appHack channelConfigLowerCompare:getDescription");
            }
            z = true;
        }
        if (notificationChannel.getImportance() != notificationChannel2.getImportance()) {
            notificationChannel.setImportance(Math.min(notificationChannel.getImportance(), notificationChannel2.getImportance()));
            if (f3689a) {
                m4974a("appHack channelConfigLowerCompare:getImportance  " + notificationChannel.getImportance() + " " + notificationChannel2.getImportance());
            }
            z = true;
        }
        if (notificationChannel.shouldVibrate() != notificationChannel2.shouldVibrate()) {
            notificationChannel.enableVibration(false);
            if (f3689a) {
                m4974a("appHack channelConfigLowerCompare:enableVibration");
            }
            z = true;
        }
        if (notificationChannel.shouldShowLights() != notificationChannel2.shouldShowLights()) {
            notificationChannel.enableLights(false);
            if (f3689a) {
                m4974a("appHack channelConfigLowerCompare:enableLights");
            }
            z = true;
        }
        boolean z3 = notificationChannel.getSound() != null;
        if (notificationChannel2.getSound() != null) {
            z2 = true;
        }
        if (z3 != z2) {
            notificationChannel.setSound((Uri) null, (AudioAttributes) null);
            if (f3689a) {
                m4974a("appHack channelConfigLowerCompare:setSound");
            }
            z = true;
        }
        if (f3689a) {
            m4974a("appHack channelConfigLowerCompare:isDifferent:" + z);
        }
        return z;
    }

    /* renamed from: a */
    private static boolean m4977a(Context context, String str) {
        if (f3689a) {
            m4974a("checkCopeidChannel:newFullChannelId:" + str + "  " + m4968a(context).getBoolean(str, false));
        }
        return m4968a(context).getBoolean(str, false);
    }

    /* renamed from: b */
    private static void m4978b(Context context, String str) {
        if (f3689a) {
            m4974a("recordCopiedChannel:" + str);
        }
        m4968a(context).edit().putBoolean(str, true).apply();
    }
}
