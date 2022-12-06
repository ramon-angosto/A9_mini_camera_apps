package com.apm.insight.runtime;

import android.content.Context;
import com.apm.insight.entity.Header;
import com.apm.insight.h;
import com.apm.insight.l.i;
import com.apm.insight.l.o;
import com.apm.insight.l.q;
import com.apm.insight.runtime.a.b;
import com.mbridge.msdk.MBridgeConstans;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class s {
    private static s a;
    private File b;
    private File c;
    private File d;
    private Context e;
    private a f = null;

    private static class a {
        /* access modifiers changed from: private */
        public long a;
        /* access modifiers changed from: private */
        public long b;
        /* access modifiers changed from: private */
        public File c;
        private JSONObject d;

        private a(File file) {
            this.d = null;
            this.c = file;
            String[] split = file.getName().split("-|\\.");
            this.a = Long.parseLong(split[0]);
            this.b = Long.parseLong(split[1]);
        }

        private String a() {
            return this.a + "-" + this.b + ".ctx";
        }

        /* access modifiers changed from: private */
        public void a(long j) {
            this.b = j;
            this.c.renameTo(new File(this.c.getParent(), a()));
        }

        /* access modifiers changed from: private */
        public JSONObject b() {
            if (this.d == null) {
                try {
                    this.d = new JSONObject(i.c(this.c.getAbsolutePath()));
                } catch (Throwable unused) {
                }
                if (this.d == null) {
                    this.d = new JSONObject();
                }
            }
            return this.d;
        }

        /* access modifiers changed from: private */
        public boolean b(long j) {
            long j2 = this.a;
            if (j2 > j && j2 - j > 604800000) {
                return true;
            }
            long j3 = this.b;
            if (j3 >= j || j - j3 <= 604800000) {
                return this.c.lastModified() < j && j - this.c.lastModified() > 604800000;
            }
            return true;
        }

        /* access modifiers changed from: private */
        public void c() {
            this.c.delete();
        }
    }

    private s(Context context) {
        File c2 = o.c(context);
        if (!c2.exists() || (!c2.isDirectory() && c2.delete())) {
            c2.mkdirs();
            b.a();
        }
        this.b = c2;
        this.c = new File(c2, "did");
        this.d = new File(c2, "device_uuid");
        this.e = context;
    }

    public static int a(JSONObject jSONObject, JSONObject jSONObject2) {
        if (Header.c(jSONObject)) {
            return 2;
        }
        if (Header.c(jSONObject2)) {
            return 0;
        }
        return (!String.valueOf(jSONObject2.opt("update_version_code")).equals(String.valueOf(jSONObject.opt("update_version_code"))) || !Header.d(jSONObject)) ? 2 : 1;
    }

    public static s a() {
        if (a == null) {
            a = new s(h.g());
        }
        return a;
    }

    private void a(long j, long j2, JSONObject jSONObject, JSONArray jSONArray) {
        File file = this.b;
        File file2 = new File(file, "" + j + "-" + j2 + ".ctx");
        File file3 = this.b;
        File file4 = new File(file3, "" + j + "-" + j2 + ".allData");
        try {
            i.a(file2, jSONObject, false);
            i.a(file4, jSONArray, false);
            this.f = new a(file2);
        } catch (IOException e2) {
            com.apm.insight.b.a().a("NPTH_CATCH", (Throwable) e2);
        }
    }

    private a c() {
        if (this.f == null) {
            d(".ctx");
        }
        return this.f;
    }

    private void c(long j) {
        try {
            ArrayList<a> d2 = d("");
            if (d2.size() > 6) {
                Iterator<a> it = d2.iterator();
                while (it.hasNext()) {
                    a next = it.next();
                    if (next.b(j)) {
                        next.c();
                    }
                }
            }
        } catch (Throwable th) {
            com.apm.insight.b.a().a("NPTH_CATCH", th);
        }
    }

    private File d(long j) {
        Iterator<a> it = d(".ctx").iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (j >= next.a && j <= next.b) {
                return next.c;
            }
        }
        return null;
    }

    private ArrayList<a> d(final String str) {
        File[] listFiles = this.b.listFiles(new FilenameFilter() {
            public boolean accept(File file, String str) {
                return str.endsWith(str) && Pattern.compile("^\\d{1,13}-\\d{1,13}.*").matcher(str).matches();
            }
        });
        q.a((Object) "foundRuntimeContextFiles " + listFiles.length);
        ArrayList<a> arrayList = new ArrayList<>();
        if (listFiles == null) {
            return arrayList;
        }
        a aVar = null;
        for (File aVar2 : listFiles) {
            try {
                a aVar3 = new a(aVar2);
                arrayList.add(aVar3);
                if (this.f == null && ".ctx".equals(str)) {
                    if (aVar != null) {
                        if (aVar3.b < aVar.b) {
                        }
                    }
                    aVar = aVar3;
                }
            } catch (Throwable th) {
                com.apm.insight.b.a().a("NPTH_CATCH", th);
            }
        }
        if (this.f == null && aVar != null) {
            this.f = aVar;
        }
        return arrayList;
    }

    private File e(long j) {
        Iterator<a> it = d(".allData").iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (j >= next.a && j <= next.b) {
                return next.c;
            }
        }
        return null;
    }

    private File f(long j) {
        Iterator<a> it = d(".ctx").iterator();
        a aVar = null;
        while (it.hasNext()) {
            a next = it.next();
            if (aVar == null || Math.abs(aVar.b - j) > Math.abs(next.b - j)) {
                aVar = next;
            }
        }
        if (aVar == null) {
            return null;
        }
        return aVar.c;
    }

    private File g(long j) {
        Iterator<a> it = d(".allData").iterator();
        a aVar = null;
        while (it.hasNext()) {
            a next = it.next();
            if (aVar == null || Math.abs(aVar.b - j) > Math.abs(next.b - j)) {
                aVar = next;
            }
        }
        if (aVar == null) {
            return null;
        }
        return aVar.c;
    }

    public String a(String str) {
        try {
            return i.c(this.d.getAbsolutePath());
        } catch (Throwable unused) {
            return str;
        }
    }

    public JSONObject a(long j) {
        boolean z;
        String str;
        File d2 = d(j);
        if (d2 == null) {
            d2 = f(j);
            z = true;
        } else {
            z = false;
        }
        JSONObject jSONObject = null;
        if (d2 != null) {
            try {
                str = i.c(d2.getAbsolutePath());
                try {
                    jSONObject = new JSONObject(str);
                } catch (Throwable th) {
                    th = th;
                    com.apm.insight.b.a().a("NPTH_CATCH", (Throwable) new IOException("content :" + str, th));
                    try {
                        jSONObject.put("unauthentic_version", 1);
                    } catch (JSONException e2) {
                        com.apm.insight.b.a().a("NPTH_CATCH", (Throwable) e2);
                    }
                    return jSONObject;
                }
            } catch (Throwable th2) {
                th = th2;
                str = null;
                com.apm.insight.b.a().a("NPTH_CATCH", (Throwable) new IOException("content :" + str, th));
                jSONObject.put("unauthentic_version", 1);
                return jSONObject;
            }
        }
        if (jSONObject != null && z) {
            jSONObject.put("unauthentic_version", 1);
        }
        return jSONObject;
    }

    public void a(Map<String, Object> map, JSONArray jSONArray) {
        JSONObject a2 = Header.a(this.e).a(map);
        if (!Header.c(a2)) {
            long currentTimeMillis = System.currentTimeMillis();
            a c2 = c();
            if (c2 == null) {
                a(currentTimeMillis, currentTimeMillis, a2, jSONArray);
                return;
            }
            int a3 = a(c2.b(), a2);
            if (a3 == 1) {
                a(c2.a, currentTimeMillis, a2, jSONArray);
                i.a(c2.c);
            } else if (a3 == 2) {
                a(currentTimeMillis, currentTimeMillis, a2, jSONArray);
            } else if (a3 == 3) {
                c2.a(currentTimeMillis);
            }
            c(currentTimeMillis);
        }
    }

    /* access modifiers changed from: protected */
    public String b() {
        try {
            return i.c(this.c.getAbsolutePath());
        } catch (Throwable unused) {
            return MBridgeConstans.ENDCARD_URL_TYPE_PL;
        }
    }

    public JSONArray b(long j) {
        String str;
        File e2 = e(j);
        if (e2 == null) {
            e2 = g(j);
        }
        if (e2 == null) {
            return null;
        }
        try {
            str = i.c(e2.getAbsolutePath());
            try {
                return new JSONArray(str);
            } catch (Throwable th) {
                th = th;
                com.apm.insight.b.a().a("NPTH_CATCH", (Throwable) new IOException("content :" + str, th));
                return null;
            }
        } catch (Throwable th2) {
            th = th2;
            str = null;
            com.apm.insight.b.a().a("NPTH_CATCH", (Throwable) new IOException("content :" + str, th));
            return null;
        }
    }

    /* access modifiers changed from: protected */
    public void b(String str) {
        try {
            i.a(this.c, str, false);
        } catch (Throwable unused) {
        }
    }

    public void c(String str) {
        try {
            i.a(this.d, str, false);
        } catch (Throwable unused) {
        }
    }
}
