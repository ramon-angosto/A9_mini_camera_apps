package com.huawei.hms.hatool;

import java.util.List;
import java.util.Map;

/* renamed from: com.huawei.hms.hatool.i0 */
public class C0802i0 implements C0814m0 {

    /* renamed from: a */
    public byte[] f640a;

    /* renamed from: b */
    public String f641b;

    /* renamed from: c */
    public String f642c;

    /* renamed from: d */
    public String f643d;

    /* renamed from: e */
    public String f644e;

    /* renamed from: f */
    public List<C0823q> f645f;

    public C0802i0(byte[] bArr, String str, String str2, String str3, String str4, List<C0823q> list) {
        this.f640a = (byte[]) bArr.clone();
        this.f641b = str;
        this.f642c = str2;
        this.f644e = str3;
        this.f643d = str4;
        this.f645f = list;
    }

    /* renamed from: a */
    public final C0778b0 mo13983a(Map<String, String> map) {
        return C0774a0.m714a(this.f641b, this.f640a, map);
    }

    /* renamed from: a */
    public final Map<String, String> mo13984a() {
        return C0779b1.m739b(this.f642c, this.f644e, this.f643d);
    }

    /* renamed from: b */
    public final void mo13985b() {
        C0817n0.m971b().mo14082a(new C0811l0(this.f645f, this.f642c, this.f643d, this.f644e));
    }

    public void run() {
        C0841y.m1087c("hmsSdk", "send data running");
        int a = mo13983a(mo13984a()).mo13922a();
        if (a != 200) {
            mo13985b();
            return;
        }
        C0841y.m1085b("hmsSdk", "events PostRequest sendevent TYPE : %s, TAG : %s, resultCode: %d ,reqID:" + this.f643d, this.f644e, this.f642c, Integer.valueOf(a));
    }
}
