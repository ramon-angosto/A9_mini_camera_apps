package com.huawei.agconnect.config.p006a;

import android.content.Context;
import com.huawei.agconnect.config.AGConnectServicesConfig;
import com.huawei.agconnect.config.LazyInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.huawei.agconnect.config.a.c */
public class C0543c extends AGConnectServicesConfig {

    /* renamed from: a */
    private final Context f100a;

    /* renamed from: b */
    private final String f101b;

    /* renamed from: c */
    private LazyInputStream f102c;

    /* renamed from: d */
    private volatile C0544d f103d;

    /* renamed from: e */
    private final Object f104e = new Object();

    /* renamed from: f */
    private Map<String, String> f105f = new HashMap();

    public C0543c(Context context, String str) {
        this.f100a = context;
        this.f101b = str;
    }

    /* renamed from: a */
    private static LazyInputStream m53a(Context context, InputStream inputStream) {
        return new C0542b(context, inputStream);
    }

    /* renamed from: a */
    private static String m54a(String str) {
        int i = 0;
        if (str.length() > 0) {
            while (str.charAt(i) == '/') {
                i++;
            }
        }
        return '/' + str.substring(i);
    }

    public boolean getBoolean(String str) {
        return getBoolean(str, false);
    }

    public boolean getBoolean(String str, boolean z) {
        return Boolean.parseBoolean(getString(str, String.valueOf(z)));
    }

    public int getInt(String str) {
        return getInt(str, 0);
    }

    public int getInt(String str, int i) {
        try {
            return Integer.parseInt(getString(str, String.valueOf(i)));
        } catch (NumberFormatException unused) {
            return i;
        }
    }

    public String getString(String str) {
        return getString(str, (String) null);
    }

    public String getString(String str, String str2) {
        if (str != null) {
            if (this.f103d == null) {
                synchronized (this.f104e) {
                    if (this.f103d == null) {
                        if (this.f102c != null) {
                            this.f103d = new C0546f(this.f102c.loadInputStream());
                            this.f102c.close();
                            this.f102c = null;
                        } else {
                            this.f103d = new C0549i(this.f100a, this.f101b);
                        }
                    }
                }
            }
            String a = m54a(str);
            return this.f105f.containsKey(a) ? this.f105f.get(a) != null ? this.f105f.get(a) : str2 : this.f103d.getString(a, str2);
        }
        throw new NullPointerException("path must not be null.");
    }

    public void overlayWith(LazyInputStream lazyInputStream) {
        this.f102c = lazyInputStream;
    }

    public void overlayWith(InputStream inputStream) {
        overlayWith(m53a(this.f100a, inputStream));
    }

    public void setParam(String str, String str2) {
        this.f105f.put(str, str2);
    }
}
