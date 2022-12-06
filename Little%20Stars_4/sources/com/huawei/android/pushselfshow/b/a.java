package com.huawei.android.pushselfshow.b;

import com.huawei.android.pushagent.c.a.e;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.meizu.cloud.pushsdk.notification.model.NotifyType;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class a implements Serializable {
    public String A;
    public String B;
    public String C;
    public String D;
    public String E = "";
    public int F = 1;
    public int G = 0;
    public String H;
    public String I;
    public String J;
    public int K = com.huawei.android.pushselfshow.c.a.STYLE_1.ordinal();
    public int L = 0;
    public String[] M = null;
    public String[] N = null;
    public String[] O = null;
    public int P = 0;
    public String[] Q = null;
    public String R = "";
    public String S = "";
    public String a;
    public String b;
    public String c;
    public String d;
    public int e;
    public String f;
    public int g;
    public String h;
    public int i;
    public int j;
    public String k;
    public String l = "";
    public String m;
    public String n;
    public String o;
    public String p;
    public String q = "";
    public String r;
    public String s;
    public String t;
    public String u;
    public String v;
    public String w;
    public String x;
    public String y = "";
    public String z;

    /* renamed from: com.huawei.android.pushselfshow.b.a$1  reason: invalid class name */
    /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] a = new int[com.huawei.android.pushselfshow.c.a.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(10:0|1|2|3|4|5|6|7|8|10) */
        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002a */
        static {
            /*
                com.huawei.android.pushselfshow.c.a[] r0 = com.huawei.android.pushselfshow.c.a.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                a = r0
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x0014 }
                com.huawei.android.pushselfshow.c.a r1 = com.huawei.android.pushselfshow.c.a.STYLE_4     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x001f }
                com.huawei.android.pushselfshow.c.a r1 = com.huawei.android.pushselfshow.c.a.STYLE_5     // Catch:{ NoSuchFieldError -> 0x001f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x002a }
                com.huawei.android.pushselfshow.c.a r1 = com.huawei.android.pushselfshow.c.a.STYLE_6     // Catch:{ NoSuchFieldError -> 0x002a }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x0035 }
                com.huawei.android.pushselfshow.c.a r1 = com.huawei.android.pushselfshow.c.a.STYLE_8     // Catch:{ NoSuchFieldError -> 0x0035 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0035 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0035 }
            L_0x0035:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.huawei.android.pushselfshow.b.a.AnonymousClass1.<clinit>():void");
        }
    }

    public a() {
    }

    public a(byte[] bArr, byte[] bArr2) {
        try {
            this.I = new String(bArr, "UTF-8");
            this.J = new String(bArr2, "UTF-8");
        } catch (Exception unused) {
            e.d("PushSelfShowLog", "get msg byte arr error");
        }
    }

    private boolean a(JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = jSONObject.getJSONObject("param");
            if (jSONObject2.has("autoClear")) {
                this.e = jSONObject2.getInt("autoClear");
            } else {
                this.e = 0;
            }
            if (!PushConstants.EXTRA_APPLICATION_PENDING_INTENT.equals(this.o)) {
                if (!"cosa".equals(this.o)) {
                    if ("email".equals(this.o)) {
                        if (!jSONObject2.has("emailAddr") || !jSONObject2.has("emailSubject")) {
                            e.a("PushSelfShowLog", "emailAddr or emailSubject is null");
                            return false;
                        }
                        this.w = jSONObject2.getString("emailAddr");
                        this.x = jSONObject2.getString("emailSubject");
                        if (!jSONObject2.has("emailContent")) {
                            return true;
                        }
                        this.y = jSONObject2.getString("emailContent");
                        return true;
                    } else if ("phone".equals(this.o)) {
                        if (jSONObject2.has("phoneNum")) {
                            this.v = jSONObject2.getString("phoneNum");
                            return true;
                        }
                        e.a("PushSelfShowLog", "phoneNum is null");
                        return false;
                    } else if (PushConstants.WEB_URL.equals(this.o)) {
                        if (jSONObject2.has(PushConstants.WEB_URL)) {
                            this.B = jSONObject2.getString(PushConstants.WEB_URL);
                            if (jSONObject2.has("inBrowser")) {
                                this.F = jSONObject2.getInt("inBrowser");
                            }
                            if (jSONObject2.has("needUserId")) {
                                this.G = jSONObject2.getInt("needUserId");
                            }
                            if (jSONObject2.has("sign")) {
                                this.H = jSONObject2.getString("sign");
                            }
                            if (!jSONObject2.has("rpt") || !jSONObject2.has("rpl")) {
                                return true;
                            }
                            this.C = jSONObject2.getString("rpl");
                            this.D = jSONObject2.getString("rpt");
                            if (!jSONObject2.has("rpct")) {
                                return true;
                            }
                            this.E = jSONObject2.getString("rpct");
                            return true;
                        }
                        e.a("PushSelfShowLog", "url is null");
                        return false;
                    } else if (!"rp".equals(this.o)) {
                        return true;
                    } else {
                        if (!jSONObject2.has("rpt") || !jSONObject2.has("rpl")) {
                            e.a("PushSelfShowLog", "rpl or rpt is null");
                            return false;
                        }
                        this.C = jSONObject2.getString("rpl");
                        this.D = jSONObject2.getString("rpt");
                        if (jSONObject2.has("rpct")) {
                            this.E = jSONObject2.getString("rpct");
                        }
                        if (!jSONObject2.has("needUserId")) {
                            return true;
                        }
                        this.G = jSONObject2.getInt("needUserId");
                        return true;
                    }
                }
            }
            if (jSONObject2.has("acn")) {
                this.A = jSONObject2.getString("acn");
                this.f = this.A;
            }
            if (jSONObject2.has("intentUri")) {
                this.f = jSONObject2.getString("intentUri");
            }
            if (jSONObject2.has("appPackageName")) {
                this.z = jSONObject2.getString("appPackageName");
                return true;
            }
            e.a("PushSelfShowLog", "appPackageName is null");
            return false;
        } catch (Exception e2) {
            e.c("PushSelfShowLog", "ParseParam error ", e2);
            return false;
        }
    }

    private boolean b(JSONObject jSONObject) {
        String str;
        e.a("PushSelfShowLog", "enter parseNotifyParam");
        try {
            JSONObject jSONObject2 = jSONObject.getJSONObject("notifyParam");
            if (!jSONObject2.has("style")) {
                return false;
            }
            this.K = jSONObject2.getInt("style");
            e.a("PushSelfShowLog", "style:" + this.K);
            if (jSONObject2.has("btnCount")) {
                this.L = jSONObject2.getInt("btnCount");
            }
            if (this.L > 0) {
                if (this.L > 3) {
                    this.L = 3;
                }
                e.a("PushSelfShowLog", "btnCount:" + this.L);
                this.M = new String[this.L];
                this.N = new String[this.L];
                this.O = new String[this.L];
                int i2 = 0;
                while (i2 < this.L) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("btn");
                    int i3 = i2 + 1;
                    sb.append(i3);
                    sb.append("Text");
                    String sb2 = sb.toString();
                    String str2 = "btn" + i3 + "Image";
                    String str3 = "btn" + i3 + "Event";
                    if (jSONObject2.has(sb2)) {
                        this.M[i2] = jSONObject2.getString(sb2);
                    }
                    if (jSONObject2.has(str2)) {
                        this.N[i2] = jSONObject2.getString(str2);
                    }
                    if (jSONObject2.has(str3)) {
                        this.O[i2] = jSONObject2.getString(str3);
                    }
                    i2 = i3;
                }
            }
            com.huawei.android.pushselfshow.c.a aVar = com.huawei.android.pushselfshow.c.a.STYLE_1;
            if (this.K >= 0 && this.K < com.huawei.android.pushselfshow.c.a.values().length) {
                aVar = com.huawei.android.pushselfshow.c.a.values()[this.K];
            }
            int i4 = AnonymousClass1.a[aVar.ordinal()];
            if (i4 != 1) {
                if (i4 != 2) {
                    if (i4 == 3 || i4 == 4) {
                        if (jSONObject2.has("bigPic")) {
                            this.S = jSONObject2.getString("bigPic");
                            str = "bigPicUrl:" + this.S;
                        }
                    }
                } else if (jSONObject2.has("subTitle")) {
                    this.R = jSONObject2.getString("subTitle");
                    str = "subTitle:" + this.R;
                }
                e.a("PushSelfShowLog", str);
            } else {
                if (jSONObject2.has("iconCount")) {
                    this.P = jSONObject2.getInt("iconCount");
                }
                if (this.P > 0) {
                    if (this.P > 6) {
                        this.P = 6;
                    }
                    e.a("PushSelfShowLog", "iconCount:" + this.P);
                    this.Q = new String[this.P];
                    int i5 = 0;
                    while (i5 < this.P) {
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append("icon");
                        int i6 = i5 + 1;
                        sb3.append(i6);
                        String sb4 = sb3.toString();
                        if (jSONObject2.has(sb4)) {
                            this.Q[i5] = jSONObject2.getString(sb4);
                        }
                        i5 = i6;
                    }
                }
            }
            return true;
        } catch (JSONException e2) {
            e.b("PushSelfShowLog", e2.toString());
            return false;
        }
    }

    public String a() {
        e.a("PushSelfShowLog", "msgId =" + this.l);
        return this.l;
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x0087 A[Catch:{ Exception -> 0x0184 }] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0093 A[Catch:{ Exception -> 0x0184 }] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x009a A[Catch:{ Exception -> 0x0184 }] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00a2 A[Catch:{ Exception -> 0x0184 }] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00a9 A[Catch:{ Exception -> 0x0184 }] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00b1 A[Catch:{ Exception -> 0x0184 }] */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00ee A[Catch:{ Exception -> 0x0184 }] */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x0104 A[Catch:{ Exception -> 0x0184 }, RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x0105 A[Catch:{ Exception -> 0x0184 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean b() {
        /*
            r15 = this;
            java.lang.String r0 = "statusIcon"
            java.lang.String r1 = "notifyIcon"
            java.lang.String r2 = "content"
            java.lang.String r3 = "psContent"
            java.lang.String r4 = "extras"
            java.lang.String r5 = "ap"
            java.lang.String r6 = "fm"
            java.lang.String r7 = "rtn"
            java.lang.String r8 = "dispPkgName"
            java.lang.String r9 = "msgId"
            java.lang.String r10 = "PushSelfShowLog"
            r11 = 0
            java.lang.String r12 = r15.J     // Catch:{ Exception -> 0x0184 }
            if (r12 == 0) goto L_0x017e
            java.lang.String r12 = r15.J     // Catch:{ Exception -> 0x0184 }
            int r12 = r12.length()     // Catch:{ Exception -> 0x0184 }
            if (r12 != 0) goto L_0x0025
            goto L_0x017e
        L_0x0025:
            java.lang.String r12 = r15.J     // Catch:{ Exception -> 0x0184 }
            r15.h = r12     // Catch:{ Exception -> 0x0184 }
            java.lang.String r12 = r15.I     // Catch:{ Exception -> 0x0184 }
            if (r12 == 0) goto L_0x0178
            java.lang.String r12 = r15.I     // Catch:{ Exception -> 0x0184 }
            int r12 = r12.length()     // Catch:{ Exception -> 0x0184 }
            if (r12 != 0) goto L_0x0037
            goto L_0x0178
        L_0x0037:
            org.json.JSONObject r12 = new org.json.JSONObject     // Catch:{ Exception -> 0x0184 }
            java.lang.String r13 = r15.I     // Catch:{ Exception -> 0x0184 }
            r12.<init>(r13)     // Catch:{ Exception -> 0x0184 }
            java.lang.String r13 = "msgType"
            int r13 = r12.getInt(r13)     // Catch:{ Exception -> 0x0184 }
            r15.g = r13     // Catch:{ Exception -> 0x0184 }
            int r13 = r15.g     // Catch:{ Exception -> 0x0184 }
            r14 = 1
            if (r13 == r14) goto L_0x0051
            java.lang.String r0 = "not a selefShowMsg"
            com.huawei.android.pushagent.c.a.e.a(r10, r0)     // Catch:{ Exception -> 0x0184 }
            return r11
        L_0x0051:
            java.lang.String r13 = "msgContent"
            org.json.JSONObject r12 = r12.getJSONObject(r13)     // Catch:{ Exception -> 0x0184 }
            if (r12 != 0) goto L_0x005f
            java.lang.String r0 = "msgObj == null"
            com.huawei.android.pushagent.c.a.e.b(r10, r0)     // Catch:{ Exception -> 0x0184 }
            return r11
        L_0x005f:
            boolean r13 = r12.has(r9)     // Catch:{ Exception -> 0x0184 }
            if (r13 == 0) goto L_0x0172
            java.lang.Object r9 = r12.get(r9)     // Catch:{ Exception -> 0x0184 }
            boolean r13 = r9 instanceof java.lang.String     // Catch:{ Exception -> 0x0184 }
            if (r13 == 0) goto L_0x0072
            java.lang.String r9 = (java.lang.String) r9     // Catch:{ Exception -> 0x0184 }
        L_0x006f:
            r15.l = r9     // Catch:{ Exception -> 0x0184 }
            goto L_0x0081
        L_0x0072:
            boolean r13 = r9 instanceof java.lang.Integer     // Catch:{ Exception -> 0x0184 }
            if (r13 == 0) goto L_0x0081
            java.lang.Integer r9 = (java.lang.Integer) r9     // Catch:{ Exception -> 0x0184 }
            int r9 = r9.intValue()     // Catch:{ Exception -> 0x0184 }
            java.lang.String r9 = java.lang.String.valueOf(r9)     // Catch:{ Exception -> 0x0184 }
            goto L_0x006f
        L_0x0081:
            boolean r9 = r12.has(r8)     // Catch:{ Exception -> 0x0184 }
            if (r9 == 0) goto L_0x008d
            java.lang.String r8 = r12.getString(r8)     // Catch:{ Exception -> 0x0184 }
            r15.m = r8     // Catch:{ Exception -> 0x0184 }
        L_0x008d:
            boolean r8 = r12.has(r7)     // Catch:{ Exception -> 0x0184 }
            if (r8 == 0) goto L_0x009a
            int r7 = r12.getInt(r7)     // Catch:{ Exception -> 0x0184 }
            r15.j = r7     // Catch:{ Exception -> 0x0184 }
            goto L_0x009c
        L_0x009a:
            r15.j = r14     // Catch:{ Exception -> 0x0184 }
        L_0x009c:
            boolean r7 = r12.has(r6)     // Catch:{ Exception -> 0x0184 }
            if (r7 == 0) goto L_0x00a9
            int r6 = r12.getInt(r6)     // Catch:{ Exception -> 0x0184 }
            r15.i = r6     // Catch:{ Exception -> 0x0184 }
            goto L_0x00ab
        L_0x00a9:
            r15.i = r14     // Catch:{ Exception -> 0x0184 }
        L_0x00ab:
            boolean r6 = r12.has(r5)     // Catch:{ Exception -> 0x0184 }
            if (r6 == 0) goto L_0x00e8
            java.lang.String r5 = r12.getString(r5)     // Catch:{ Exception -> 0x0184 }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0184 }
            r6.<init>()     // Catch:{ Exception -> 0x0184 }
            boolean r7 = android.text.TextUtils.isEmpty(r5)     // Catch:{ Exception -> 0x0184 }
            r8 = 48
            if (r7 != 0) goto L_0x00e3
            int r7 = r5.length()     // Catch:{ Exception -> 0x0184 }
            if (r7 >= r8) goto L_0x00e3
            r7 = 0
        L_0x00c9:
            int r9 = r5.length()     // Catch:{ Exception -> 0x0184 }
            int r9 = 48 - r9
            if (r7 >= r9) goto L_0x00d9
            java.lang.String r9 = "0"
            r6.append(r9)     // Catch:{ Exception -> 0x0184 }
            int r7 = r7 + 1
            goto L_0x00c9
        L_0x00d9:
            r6.append(r5)     // Catch:{ Exception -> 0x0184 }
            java.lang.String r5 = r6.toString()     // Catch:{ Exception -> 0x0184 }
        L_0x00e0:
            r15.k = r5     // Catch:{ Exception -> 0x0184 }
            goto L_0x00e8
        L_0x00e3:
            java.lang.String r5 = r5.substring(r11, r8)     // Catch:{ Exception -> 0x0184 }
            goto L_0x00e0
        L_0x00e8:
            boolean r5 = r12.has(r4)     // Catch:{ Exception -> 0x0184 }
            if (r5 == 0) goto L_0x00f8
            org.json.JSONArray r4 = r12.getJSONArray(r4)     // Catch:{ Exception -> 0x0184 }
            java.lang.String r4 = r4.toString()     // Catch:{ Exception -> 0x0184 }
            r15.n = r4     // Catch:{ Exception -> 0x0184 }
        L_0x00f8:
            boolean r4 = r12.has(r3)     // Catch:{ Exception -> 0x0184 }
            if (r4 == 0) goto L_0x0171
            org.json.JSONObject r3 = r12.getJSONObject(r3)     // Catch:{ Exception -> 0x0184 }
            if (r3 != 0) goto L_0x0105
            return r11
        L_0x0105:
            java.lang.String r4 = "cmd"
            java.lang.String r4 = r3.getString(r4)     // Catch:{ Exception -> 0x0184 }
            r15.o = r4     // Catch:{ Exception -> 0x0184 }
            boolean r4 = r3.has(r2)     // Catch:{ Exception -> 0x0184 }
            java.lang.String r5 = ""
            if (r4 == 0) goto L_0x011c
            java.lang.String r2 = r3.getString(r2)     // Catch:{ Exception -> 0x0184 }
            r15.p = r2     // Catch:{ Exception -> 0x0184 }
            goto L_0x011e
        L_0x011c:
            r15.p = r5     // Catch:{ Exception -> 0x0184 }
        L_0x011e:
            boolean r2 = r3.has(r1)     // Catch:{ Exception -> 0x0184 }
            if (r2 == 0) goto L_0x012b
            java.lang.String r1 = r3.getString(r1)     // Catch:{ Exception -> 0x0184 }
        L_0x0128:
            r15.q = r1     // Catch:{ Exception -> 0x0184 }
            goto L_0x013d
        L_0x012b:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0184 }
            r1.<init>()     // Catch:{ Exception -> 0x0184 }
            r1.append(r5)     // Catch:{ Exception -> 0x0184 }
            java.lang.String r2 = r15.l     // Catch:{ Exception -> 0x0184 }
            r1.append(r2)     // Catch:{ Exception -> 0x0184 }
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x0184 }
            goto L_0x0128
        L_0x013d:
            boolean r1 = r3.has(r0)     // Catch:{ Exception -> 0x0184 }
            if (r1 == 0) goto L_0x0149
            java.lang.String r0 = r3.getString(r0)     // Catch:{ Exception -> 0x0184 }
            r15.s = r0     // Catch:{ Exception -> 0x0184 }
        L_0x0149:
            java.lang.String r0 = "notifyTitle"
            boolean r0 = r3.has(r0)     // Catch:{ Exception -> 0x0184 }
            if (r0 == 0) goto L_0x0159
            java.lang.String r0 = "notifyTitle"
            java.lang.String r0 = r3.getString(r0)     // Catch:{ Exception -> 0x0184 }
            r15.r = r0     // Catch:{ Exception -> 0x0184 }
        L_0x0159:
            java.lang.String r0 = "notifyParam"
            boolean r0 = r3.has(r0)     // Catch:{ Exception -> 0x0184 }
            if (r0 == 0) goto L_0x0164
            r15.b(r3)     // Catch:{ Exception -> 0x0184 }
        L_0x0164:
            java.lang.String r0 = "param"
            boolean r0 = r3.has(r0)     // Catch:{ Exception -> 0x0184 }
            if (r0 == 0) goto L_0x0171
            boolean r0 = r15.a(r3)     // Catch:{ Exception -> 0x0184 }
            return r0
        L_0x0171:
            return r11
        L_0x0172:
            java.lang.String r0 = "msgId == null"
            com.huawei.android.pushagent.c.a.e.b(r10, r0)     // Catch:{ Exception -> 0x0184 }
            return r11
        L_0x0178:
            java.lang.String r0 = "msg is null"
            com.huawei.android.pushagent.c.a.e.a(r10, r0)     // Catch:{ Exception -> 0x0184 }
            return r11
        L_0x017e:
            java.lang.String r0 = "token is null"
            com.huawei.android.pushagent.c.a.e.a(r10, r0)     // Catch:{ Exception -> 0x0184 }
            return r11
        L_0x0184:
            r0 = move-exception
            java.lang.String r1 = r0.toString()
            com.huawei.android.pushagent.c.a.e.a((java.lang.String) r10, (java.lang.String) r1, (java.lang.Throwable) r0)
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.android.pushselfshow.b.a.b():boolean");
    }

    public byte[] c() {
        String str;
        try {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            JSONObject jSONObject3 = new JSONObject();
            JSONObject jSONObject4 = new JSONObject();
            jSONObject4.put("autoClear", this.e);
            jSONObject4.put(NotifyType.SOUND, this.a);
            jSONObject4.put("r", this.b);
            jSONObject4.put("smsC", this.c);
            jSONObject4.put("mmsUrl", this.d);
            jSONObject4.put(PushConstants.WEB_URL, this.B);
            jSONObject4.put("inBrowser", this.F);
            jSONObject4.put("needUserId", this.G);
            jSONObject4.put("sign", this.H);
            jSONObject4.put("rpl", this.C);
            jSONObject4.put("rpt", this.D);
            jSONObject4.put("rpct", this.E);
            jSONObject4.put("appPackageName", this.z);
            jSONObject4.put("acn", this.A);
            jSONObject4.put("intentUri", this.f);
            jSONObject4.put("emailAddr", this.w);
            jSONObject4.put("emailSubject", this.x);
            jSONObject4.put("emailContent", this.y);
            jSONObject4.put("phoneNum", this.v);
            jSONObject4.put("replyToSms", this.u);
            jSONObject4.put("smsNum", this.t);
            jSONObject3.put("cmd", this.o);
            jSONObject3.put("content", this.p);
            jSONObject3.put("notifyIcon", this.q);
            jSONObject3.put("notifyTitle", this.r);
            jSONObject3.put("statusIcon", this.s);
            jSONObject3.put("param", jSONObject4);
            jSONObject2.put("dispPkgName", this.m);
            jSONObject2.put("msgId", this.l);
            jSONObject2.put("fm", this.i);
            jSONObject2.put("ap", this.k);
            jSONObject2.put("rtn", this.j);
            jSONObject2.put("psContent", jSONObject3);
            if (this.n != null && this.n.length() > 0) {
                jSONObject2.put("extras", new JSONArray(this.n));
            }
            jSONObject.put("msgType", this.g);
            jSONObject.put("msgContent", jSONObject2);
            return jSONObject.toString().getBytes("UTF-8");
        } catch (JSONException e2) {
            e = e2;
            str = "getMsgData failed JSONException:";
            e.a("PushSelfShowLog", str, e);
            return new byte[0];
        } catch (UnsupportedEncodingException e3) {
            e = e3;
            str = "getMsgData failed UnsupportedEncodingException:";
            e.a("PushSelfShowLog", str, e);
            return new byte[0];
        }
    }

    public byte[] d() {
        try {
            if (this.h != null && this.h.length() > 0) {
                return this.h.getBytes("UTF-8");
            }
        } catch (Exception e2) {
            e.a("PushSelfShowLog", "getToken getByte failed ", (Throwable) e2);
        }
        return new byte[0];
    }
}
