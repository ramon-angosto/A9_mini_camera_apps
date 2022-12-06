package sg.bigo.ads.common.l.b;

import android.text.TextUtils;
import androidx.browser.trusted.sharing.ShareTarget;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import sg.bigo.ads.common.b.a;
import sg.bigo.ads.common.l.f;

public abstract class c {
    public final int c;
    public final String d;
    public String e;
    public long f = 15000;
    public final Map<String, Set<String>> g = new HashMap();

    public c(int i, String str) {
        this.c = i;
        this.d = str;
        a("BIGO-Ad-Request-Id", String.valueOf(this.c));
        a("User-Agent", sg.bigo.ads.common.p.c.d(a.a));
    }

    private Set<String> b(String str) {
        Set<String> set = this.g.get(str);
        if (set != null) {
            return set;
        }
        HashSet hashSet = new HashSet();
        this.g.put(str, hashSet);
        return hashSet;
    }

    public String a() {
        return ShareTarget.METHOD_GET;
    }

    public final void a(String str) {
        b(str).clear();
    }

    public final void a(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            b(str).add(str2);
        }
    }

    public f b() {
        return null;
    }

    public byte[] c() {
        return null;
    }

    public String d() {
        return null;
    }

    public int e() {
        return -1;
    }

    public final String f() {
        return !TextUtils.isEmpty(this.e) ? this.e : this.d;
    }
}
