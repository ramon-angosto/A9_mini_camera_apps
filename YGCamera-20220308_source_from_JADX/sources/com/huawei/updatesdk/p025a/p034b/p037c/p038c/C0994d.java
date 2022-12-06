package com.huawei.updatesdk.p025a.p034b.p037c.p038c;

/* renamed from: com.huawei.updatesdk.a.b.c.c.d */
public class C0994d extends C0991b {
    public static final int ERROR = 1;
    public static final int NETWORK_ERROR = 3;

    /* renamed from: OK */
    public static final int f1337OK = 0;
    public static final int PROGUARD_ERROR = 6;
    public static final int REQ_PARAM_ERROR = 5;
    public static final int RTN_CODE_OK = 0;
    public static final int TIMEOUT = 2;
    private C0995a errCause = C0995a.NORMAL;
    private int httpRespondeCode = 0;
    private String reason;
    private int responseCode = 1;
    private int rtnCode_ = 0;

    /* renamed from: com.huawei.updatesdk.a.b.c.c.d$a */
    public enum C0995a {
        NORMAL,
        NO_NETWORK,
        JSON_ERROR,
        PARAM_ERROR,
        IO_EXCEPTION,
        CONNECT_EXCEPTION,
        UNKNOWN_EXCEPTION,
        NO_PROGUARD
    }

    /* renamed from: a */
    public C0995a mo14927a() {
        return this.errCause;
    }

    /* renamed from: a */
    public void mo14928a(int i) {
        this.httpRespondeCode = i;
    }

    /* renamed from: a */
    public void mo14929a(C0995a aVar) {
        this.errCause = aVar;
    }

    /* renamed from: a */
    public void mo14930a(String str) {
        this.reason = str;
    }

    /* renamed from: b */
    public int mo14931b() {
        return this.httpRespondeCode;
    }

    /* renamed from: b */
    public void mo14932b(int i) {
        this.responseCode = i;
    }

    /* renamed from: c */
    public String mo14933c() {
        return this.reason;
    }

    /* renamed from: d */
    public int mo14934d() {
        return this.responseCode;
    }

    /* renamed from: e */
    public int mo14935e() {
        return this.rtnCode_;
    }

    /* renamed from: f */
    public boolean mo14936f() {
        return mo14934d() == 0 && mo14935e() == 0;
    }

    public String toString() {
        return " { \n\tresponseCode: " + mo14934d() + "\n\trtnCode_: " + mo14935e() + "\n\terrCause: " + mo14927a() + "\n}";
    }
}
