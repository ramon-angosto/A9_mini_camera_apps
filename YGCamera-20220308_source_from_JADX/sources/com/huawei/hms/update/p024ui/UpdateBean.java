package com.huawei.hms.update.p024ui;

import java.io.Serializable;
import java.util.ArrayList;

/* renamed from: com.huawei.hms.update.ui.UpdateBean */
public class UpdateBean implements Serializable {

    /* renamed from: a */
    public boolean f1001a;

    /* renamed from: b */
    public String f1002b;

    /* renamed from: c */
    public int f1003c;

    /* renamed from: d */
    public String f1004d;

    /* renamed from: e */
    public String f1005e;

    /* renamed from: f */
    public ArrayList f1006f;

    /* renamed from: g */
    public boolean f1007g = true;

    /* renamed from: a */
    public static <T> T m1395a(T t) {
        return t;
    }

    /* renamed from: a */
    public String mo14627a() {
        return (String) m1395a(this.f1004d);
    }

    /* renamed from: b */
    public String mo14628b() {
        return (String) m1395a(this.f1002b);
    }

    /* renamed from: c */
    public int mo14629c() {
        return ((Integer) m1395a(Integer.valueOf(this.f1003c))).intValue();
    }

    /* renamed from: d */
    public boolean mo14630d() {
        return ((Boolean) m1395a(Boolean.valueOf(this.f1001a))).booleanValue();
    }

    public String getClientAppName() {
        return (String) m1395a(this.f1005e);
    }

    public ArrayList getTypeList() {
        return (ArrayList) m1395a(this.f1006f);
    }

    public boolean isNeedConfirm() {
        return ((Boolean) m1395a(Boolean.valueOf(this.f1007g))).booleanValue();
    }

    public void setClientAppId(String str) {
        this.f1004d = str;
    }

    public void setClientAppName(String str) {
        this.f1005e = str;
    }

    public void setClientPackageName(String str) {
        this.f1002b = str;
    }

    public void setClientVersionCode(int i) {
        this.f1003c = i;
    }

    public void setHmsOrApkUpgrade(boolean z) {
        this.f1001a = z;
    }

    public void setNeedConfirm(boolean z) {
        this.f1007g = z;
    }

    public void setTypeList(ArrayList arrayList) {
        this.f1006f = arrayList;
    }
}
