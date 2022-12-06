package com.xiaomi.push;

import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/* renamed from: com.xiaomi.push.gi */
public class C1826gi implements C1831gm {

    /* renamed from: a */
    private String f2491a;

    /* renamed from: a */
    private List<C1826gi> f2492a = null;

    /* renamed from: a */
    private String[] f2493a = null;

    /* renamed from: b */
    private String f2494b;

    /* renamed from: b */
    private String[] f2495b = null;

    /* renamed from: c */
    private String f2496c;

    public C1826gi(String str, String str2, String[] strArr, String[] strArr2) {
        this.f2491a = str;
        this.f2494b = str2;
        this.f2493a = strArr;
        this.f2495b = strArr2;
    }

    public C1826gi(String str, String str2, String[] strArr, String[] strArr2, String str3, List<C1826gi> list) {
        this.f2491a = str;
        this.f2494b = str2;
        this.f2493a = strArr;
        this.f2495b = strArr2;
        this.f2496c = str3;
        this.f2492a = list;
    }

    /* renamed from: a */
    public static C1826gi m3706a(Bundle bundle) {
        ArrayList arrayList;
        String string = bundle.getString("ext_ele_name");
        String string2 = bundle.getString("ext_ns");
        String string3 = bundle.getString("ext_text");
        Bundle bundle2 = bundle.getBundle("attributes");
        Set<String> keySet = bundle2.keySet();
        String[] strArr = new String[keySet.size()];
        String[] strArr2 = new String[keySet.size()];
        int i = 0;
        for (String str : keySet) {
            strArr[i] = str;
            strArr2[i] = bundle2.getString(str);
            i++;
        }
        if (bundle.containsKey("children")) {
            Parcelable[] parcelableArray = bundle.getParcelableArray("children");
            ArrayList arrayList2 = new ArrayList(parcelableArray.length);
            for (Parcelable parcelable : parcelableArray) {
                arrayList2.add(m3706a((Bundle) parcelable));
            }
            arrayList = arrayList2;
        } else {
            arrayList = null;
        }
        return new C1826gi(string, string2, strArr, strArr2, string3, arrayList);
    }

    /* renamed from: a */
    public static Parcelable[] m3707a(List<C1826gi> list) {
        return m3708a((C1826gi[]) list.toArray(new C1826gi[list.size()]));
    }

    /* renamed from: a */
    public static Parcelable[] m3708a(C1826gi[] giVarArr) {
        if (giVarArr == null) {
            return null;
        }
        Parcelable[] parcelableArr = new Parcelable[giVarArr.length];
        for (int i = 0; i < giVarArr.length; i++) {
            parcelableArr[i] = giVarArr[i].mo17691a();
        }
        return parcelableArr;
    }

    /* renamed from: a */
    public Bundle mo17691a() {
        Bundle bundle = new Bundle();
        bundle.putString("ext_ele_name", this.f2491a);
        bundle.putString("ext_ns", this.f2494b);
        bundle.putString("ext_text", this.f2496c);
        Bundle bundle2 = new Bundle();
        String[] strArr = this.f2493a;
        if (strArr != null && strArr.length > 0) {
            int i = 0;
            while (true) {
                String[] strArr2 = this.f2493a;
                if (i >= strArr2.length) {
                    break;
                }
                bundle2.putString(strArr2[i], this.f2495b[i]);
                i++;
            }
        }
        bundle.putBundle("attributes", bundle2);
        List<C1826gi> list = this.f2492a;
        if (list != null && list.size() > 0) {
            bundle.putParcelableArray("children", m3707a(this.f2492a));
        }
        return bundle;
    }

    /* renamed from: a */
    public Parcelable m3710a() {
        return mo17691a();
    }

    /* renamed from: a */
    public String m3711a() {
        return this.f2491a;
    }

    /* renamed from: a */
    public String mo17692a(String str) {
        if (str == null) {
            throw new IllegalArgumentException();
        } else if (this.f2493a == null) {
            return null;
        } else {
            int i = 0;
            while (true) {
                String[] strArr = this.f2493a;
                if (i >= strArr.length) {
                    return null;
                }
                if (str.equals(strArr[i])) {
                    return this.f2495b[i];
                }
                i++;
            }
        }
    }

    /* renamed from: a */
    public void mo17693a(C1826gi giVar) {
        if (this.f2492a == null) {
            this.f2492a = new ArrayList();
        }
        if (!this.f2492a.contains(giVar)) {
            this.f2492a.add(giVar);
        }
    }

    /* renamed from: a */
    public void m3714a(String str) {
        if (!TextUtils.isEmpty(str)) {
            str = C1844gw.m3801a(str);
        }
        this.f2496c = str;
    }

    /* renamed from: b */
    public String mo17694b() {
        return this.f2494b;
    }

    /* renamed from: c */
    public String mo17695c() {
        return !TextUtils.isEmpty(this.f2496c) ? C1844gw.m3804b(this.f2496c) : this.f2496c;
    }

    /* renamed from: d */
    public String mo17696d() {
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        sb.append(this.f2491a);
        if (!TextUtils.isEmpty(this.f2494b)) {
            sb.append(" ");
            sb.append("xmlns=");
            sb.append("\"");
            sb.append(this.f2494b);
            sb.append("\"");
        }
        String[] strArr = this.f2493a;
        if (strArr != null && strArr.length > 0) {
            for (int i = 0; i < this.f2493a.length; i++) {
                if (!TextUtils.isEmpty(this.f2495b[i])) {
                    sb.append(" ");
                    sb.append(this.f2493a[i]);
                    sb.append("=\"");
                    sb.append(C1844gw.m3801a(this.f2495b[i]));
                    sb.append("\"");
                }
            }
        }
        if (!TextUtils.isEmpty(this.f2496c)) {
            sb.append(">");
            sb.append(this.f2496c);
        } else {
            List<C1826gi> list = this.f2492a;
            if (list == null || list.size() <= 0) {
                sb.append("/>");
                return sb.toString();
            }
            sb.append(">");
            for (C1826gi d : this.f2492a) {
                sb.append(d.mo17696d());
            }
        }
        sb.append("</");
        sb.append(this.f2491a);
        sb.append(">");
        return sb.toString();
    }

    public String toString() {
        return mo17696d();
    }
}
