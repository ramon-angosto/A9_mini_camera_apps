package com.xiaomi.push;

import com.xiaomi.push.C1722dk;
import java.io.File;
import java.util.Date;

/* renamed from: com.xiaomi.push.dl */
class C1726dl extends C1722dk.C1724b {

    /* renamed from: a */
    final /* synthetic */ int f2047a;

    /* renamed from: a */
    final /* synthetic */ C1722dk f2048a;

    /* renamed from: a */
    File f2049a;

    /* renamed from: a */
    final /* synthetic */ String f2050a;

    /* renamed from: a */
    final /* synthetic */ Date f2051a;

    /* renamed from: a */
    final /* synthetic */ boolean f2052a;

    /* renamed from: b */
    final /* synthetic */ String f2053b;

    /* renamed from: b */
    final /* synthetic */ Date f2054b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C1726dl(C1722dk dkVar, int i, Date date, Date date2, String str, String str2, boolean z) {
        super();
        this.f2048a = dkVar;
        this.f2047a = i;
        this.f2051a = date;
        this.f2054b = date2;
        this.f2050a = str;
        this.f2053b = str2;
        this.f2052a = z;
    }

    /* renamed from: b */
    public void mo17228b() {
        if (C1610ac.m2503d()) {
            try {
                File file = new File(C1722dk.m3008a(this.f2048a).getExternalFilesDir((String) null) + "/.logcache");
                file.mkdirs();
                if (file.isDirectory()) {
                    C1721dj djVar = new C1721dj();
                    djVar.mo17388a(this.f2047a);
                    this.f2049a = djVar.mo17387a(C1722dk.m3008a(this.f2048a), this.f2051a, this.f2054b, file);
                }
            } catch (NullPointerException unused) {
            }
        }
    }

    /* renamed from: c */
    public void mo17229c() {
        File file = this.f2049a;
        if (file != null && file.exists()) {
            C1722dk.m3008a(this.f2048a).add(new C1722dk.C1725c(this.f2050a, this.f2053b, this.f2049a, this.f2052a));
        }
        this.f2048a.m3011a(0);
    }
}
