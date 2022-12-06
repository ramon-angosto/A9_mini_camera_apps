package com.xiaomi.push.service;

/* renamed from: com.xiaomi.push.service.bd */
public abstract class C2014bd {

    /* renamed from: A */
    public static String f3769A = "ext_pkg_name";

    /* renamed from: B */
    public static String f3770B = "ext_notify_id";

    /* renamed from: C */
    public static String f3771C = "ext_clicked_button";

    /* renamed from: D */
    public static String f3772D = "ext_notify_type";

    /* renamed from: E */
    public static String f3773E = "ext_session";

    /* renamed from: F */
    public static String f3774F = "sig";

    /* renamed from: G */
    public static String f3775G = "ext_notify_title";

    /* renamed from: H */
    public static String f3776H = "ext_notify_description";

    /* renamed from: I */
    public static String f3777I = "ext_messenger";

    /* renamed from: J */
    public static String f3778J = "title";

    /* renamed from: K */
    public static String f3779K = "description";

    /* renamed from: L */
    public static String f3780L = "notifyId";

    /* renamed from: M */
    public static String f3781M = "dump";

    /* renamed from: a */
    public static String f3782a = "1";

    /* renamed from: b */
    public static String f3783b = "2";

    /* renamed from: c */
    public static String f3784c = "3";

    /* renamed from: d */
    public static String f3785d = "com.xiaomi.push.OPEN_CHANNEL";

    /* renamed from: e */
    public static String f3786e = "com.xiaomi.push.SEND_MESSAGE";

    /* renamed from: f */
    public static String f3787f = "com.xiaomi.push.SEND_IQ";

    /* renamed from: g */
    public static String f3788g = "com.xiaomi.push.BATCH_SEND_MESSAGE";

    /* renamed from: h */
    public static String f3789h = "com.xiaomi.push.SEND_PRES";

    /* renamed from: i */
    public static String f3790i = "com.xiaomi.push.CLOSE_CHANNEL";

    /* renamed from: j */
    public static String f3791j = "com.xiaomi.push.FORCE_RECONN";

    /* renamed from: k */
    public static String f3792k = "com.xiaomi.push.RESET_CONN";

    /* renamed from: l */
    public static String f3793l = "com.xiaomi.push.UPDATE_CHANNEL_INFO";

    /* renamed from: m */
    public static String f3794m = "com.xiaomi.push.SEND_STATS";

    /* renamed from: n */
    public static String f3795n = "com.xiaomi.push.CHANGE_HOST";

    /* renamed from: o */
    public static String f3796o = "com.xiaomi.push.PING_TIMER";

    /* renamed from: p */
    public static String f3797p = "ext_user_id";

    /* renamed from: q */
    public static String f3798q = "ext_user_server";

    /* renamed from: r */
    public static String f3799r = "ext_user_res";

    /* renamed from: s */
    public static String f3800s = "ext_chid";

    /* renamed from: t */
    public static String f3801t = "ext_sid";

    /* renamed from: u */
    public static String f3802u = "ext_token";

    /* renamed from: v */
    public static String f3803v = "ext_auth_method";

    /* renamed from: w */
    public static String f3804w = "ext_security";

    /* renamed from: x */
    public static String f3805x = "ext_kick";

    /* renamed from: y */
    public static String f3806y = "ext_client_attr";

    /* renamed from: z */
    public static String f3807z = "ext_cloud_attr";

    /* renamed from: a */
    public static String m5114a(int i) {
        switch (i) {
            case 0:
                return "ERROR_OK";
            case 1:
                return "ERROR_SERVICE_NOT_INSTALLED";
            case 2:
                return "ERROR_NETWORK_NOT_AVAILABLE";
            case 3:
                return "ERROR_NETWORK_FAILED";
            case 4:
                return "ERROR_ACCESS_DENIED";
            case 5:
                return "ERROR_AUTH_FAILED";
            case 6:
                return "ERROR_MULTI_LOGIN";
            case 7:
                return "ERROR_SERVER_ERROR";
            case 8:
                return "ERROR_RECEIVE_TIMEOUT";
            case 9:
                return "ERROR_READ_ERROR";
            case 10:
                return "ERROR_SEND_ERROR";
            case 11:
                return "ERROR_RESET";
            case 12:
                return "ERROR_NO_CLIENT";
            case 13:
                return "ERROR_SERVER_STREAM";
            case 14:
                return "ERROR_THREAD_BLOCK";
            case 15:
                return "ERROR_SERVICE_DESTROY";
            case 16:
                return "ERROR_SESSION_CHANGED";
            case 17:
                return "ERROR_READ_TIMEOUT";
            case 18:
                return "ERROR_CONNECTIING_TIMEOUT";
            case 19:
                return "ERROR_USER_BLOCKED";
            case 20:
                return "ERROR_REDIRECT";
            case 21:
                return "ERROR_BIND_TIMEOUT";
            case 22:
                return "ERROR_PING_TIMEOUT";
            default:
                return String.valueOf(i);
        }
    }
}
