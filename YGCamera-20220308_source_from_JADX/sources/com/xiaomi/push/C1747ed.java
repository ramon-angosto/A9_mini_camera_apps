package com.xiaomi.push;

/* renamed from: com.xiaomi.push.ed */
public final class C1747ed {

    /* renamed from: com.xiaomi.push.ed$a */
    public static final class C1748a extends C1742e {

        /* renamed from: a */
        private int f2098a = 0;

        /* renamed from: a */
        private long f2099a = 0;

        /* renamed from: a */
        private String f2100a = "";

        /* renamed from: a */
        private boolean f2101a;

        /* renamed from: b */
        private int f2102b = 1;

        /* renamed from: b */
        private String f2103b = "";

        /* renamed from: b */
        private boolean f2104b;

        /* renamed from: c */
        private int f2105c = 0;

        /* renamed from: c */
        private String f2106c = "";

        /* renamed from: c */
        private boolean f2107c;

        /* renamed from: d */
        private int f2108d = 0;

        /* renamed from: d */
        private String f2109d = "";

        /* renamed from: d */
        private boolean f2110d;

        /* renamed from: e */
        private int f2111e = -1;

        /* renamed from: e */
        private String f2112e = "";

        /* renamed from: e */
        private boolean f2113e;

        /* renamed from: f */
        private String f2114f = "";

        /* renamed from: f */
        private boolean f2115f;

        /* renamed from: g */
        private boolean f2116g;

        /* renamed from: h */
        private boolean f2117h;

        /* renamed from: i */
        private boolean f2118i;

        /* renamed from: j */
        private boolean f2119j;

        /* renamed from: k */
        private boolean f2120k;

        /* renamed from: a */
        public int mo17407a() {
            if (this.f2111e < 0) {
                mo17413b();
            }
            return this.f2111e;
        }

        /* renamed from: a */
        public long m3111a() {
            return this.f2099a;
        }

        /* renamed from: a */
        public C1748a m3113a() {
            this.f2115f = false;
            this.f2109d = "";
            return this;
        }

        /* renamed from: a */
        public C1748a mo17424a(int i) {
            this.f2101a = true;
            this.f2098a = i;
            return this;
        }

        /* renamed from: a */
        public C1748a mo17425a(long j) {
            this.f2104b = true;
            this.f2099a = j;
            return this;
        }

        /* renamed from: a */
        public C1748a m3116a(C1641b bVar) {
            while (true) {
                int a = bVar.mo17241a();
                switch (a) {
                    case 0:
                        return this;
                    case 8:
                        mo17424a(bVar.mo17244b());
                        break;
                    case 16:
                        mo17425a(bVar.mo17244b());
                        break;
                    case 26:
                        mo17426a(bVar.mo17241a());
                        break;
                    case 34:
                        mo17428b(bVar.mo17241a());
                        break;
                    case 42:
                        mo17431c(bVar.mo17241a());
                        break;
                    case 50:
                        mo17434d(bVar.mo17241a());
                        break;
                    case 58:
                        mo17436e(bVar.mo17241a());
                        break;
                    case 64:
                        mo17427b(bVar.mo17244b());
                        break;
                    case 72:
                        mo17430c(bVar.mo17244b());
                        break;
                    case 80:
                        mo17433d(bVar.mo17244b());
                        break;
                    case 90:
                        mo17438f(bVar.mo17241a());
                        break;
                    default:
                        if (mo17412a(bVar, a)) {
                            break;
                        } else {
                            return this;
                        }
                }
            }
        }

        /* renamed from: a */
        public C1748a mo17426a(String str) {
            this.f2107c = true;
            this.f2100a = str;
            return this;
        }

        /* renamed from: a */
        public String m3118a() {
            return this.f2100a;
        }

        /* renamed from: a */
        public void mo17411a(C1675c cVar) {
            if (mo17407a()) {
                cVar.mo17282a(1, mo17429c());
            }
            if (mo17413b()) {
                cVar.mo17298b(2, mo17407a());
            }
            if (mo17429c()) {
                cVar.mo17286a(3, mo17407a());
            }
            if (mo17432d()) {
                cVar.mo17286a(4, mo17413b());
            }
            if (mo17435e()) {
                cVar.mo17286a(5, mo17429c());
            }
            if (mo17437f()) {
                cVar.mo17286a(6, mo17432d());
            }
            if (mo17439g()) {
                cVar.mo17286a(7, mo17435e());
            }
            if (mo17440h()) {
                cVar.mo17282a(8, mo17432d());
            }
            if (mo17441i()) {
                cVar.mo17282a(9, mo17435e());
            }
            if (mo17442j()) {
                cVar.mo17282a(10, mo17437f());
            }
            if (mo17443k()) {
                cVar.mo17286a(11, mo17437f());
            }
        }

        /* renamed from: a */
        public boolean m3120a() {
            return this.f2101a;
        }

        /* renamed from: b */
        public int mo17413b() {
            int i = 0;
            if (mo17407a()) {
                i = 0 + C1675c.mo17282a(1, mo17429c());
            }
            if (mo17413b()) {
                i += C1675c.mo17298b(2, mo17407a());
            }
            if (mo17429c()) {
                i += C1675c.mo17286a(3, mo17407a());
            }
            if (mo17432d()) {
                i += C1675c.mo17286a(4, mo17413b());
            }
            if (mo17435e()) {
                i += C1675c.mo17286a(5, mo17429c());
            }
            if (mo17437f()) {
                i += C1675c.mo17286a(6, mo17432d());
            }
            if (mo17439g()) {
                i += C1675c.mo17286a(7, mo17435e());
            }
            if (mo17440h()) {
                i += C1675c.mo17282a(8, mo17432d());
            }
            if (mo17441i()) {
                i += C1675c.mo17282a(9, mo17435e());
            }
            if (mo17442j()) {
                i += C1675c.mo17282a(10, mo17437f());
            }
            if (mo17443k()) {
                i += C1675c.mo17286a(11, mo17437f());
            }
            this.f2111e = i;
            return i;
        }

        /* renamed from: b */
        public C1748a mo17427b(int i) {
            this.f2117h = true;
            this.f2102b = i;
            return this;
        }

        /* renamed from: b */
        public C1748a mo17428b(String str) {
            this.f2110d = true;
            this.f2103b = str;
            return this;
        }

        /* renamed from: b */
        public String m3124b() {
            return this.f2103b;
        }

        /* renamed from: b */
        public boolean m3125b() {
            return this.f2104b;
        }

        /* renamed from: c */
        public int mo17429c() {
            return this.f2098a;
        }

        /* renamed from: c */
        public C1748a mo17430c(int i) {
            this.f2118i = true;
            this.f2105c = i;
            return this;
        }

        /* renamed from: c */
        public C1748a mo17431c(String str) {
            this.f2113e = true;
            this.f2106c = str;
            return this;
        }

        /* renamed from: c */
        public String m3129c() {
            return this.f2106c;
        }

        /* renamed from: c */
        public boolean m3130c() {
            return this.f2107c;
        }

        /* renamed from: d */
        public int mo17432d() {
            return this.f2102b;
        }

        /* renamed from: d */
        public C1748a mo17433d(int i) {
            this.f2119j = true;
            this.f2108d = i;
            return this;
        }

        /* renamed from: d */
        public C1748a mo17434d(String str) {
            this.f2115f = true;
            this.f2109d = str;
            return this;
        }

        /* renamed from: d */
        public String m3134d() {
            return this.f2109d;
        }

        /* renamed from: d */
        public boolean m3135d() {
            return this.f2110d;
        }

        /* renamed from: e */
        public int mo17435e() {
            return this.f2105c;
        }

        /* renamed from: e */
        public C1748a mo17436e(String str) {
            this.f2116g = true;
            this.f2112e = str;
            return this;
        }

        /* renamed from: e */
        public String m3138e() {
            return this.f2112e;
        }

        /* renamed from: e */
        public boolean m3139e() {
            return this.f2113e;
        }

        /* renamed from: f */
        public int mo17437f() {
            return this.f2108d;
        }

        /* renamed from: f */
        public C1748a mo17438f(String str) {
            this.f2120k = true;
            this.f2114f = str;
            return this;
        }

        /* renamed from: f */
        public String m3142f() {
            return this.f2114f;
        }

        /* renamed from: f */
        public boolean m3143f() {
            return this.f2115f;
        }

        /* renamed from: g */
        public boolean mo17439g() {
            return this.f2116g;
        }

        /* renamed from: h */
        public boolean mo17440h() {
            return this.f2117h;
        }

        /* renamed from: i */
        public boolean mo17441i() {
            return this.f2118i;
        }

        /* renamed from: j */
        public boolean mo17442j() {
            return this.f2119j;
        }

        /* renamed from: k */
        public boolean mo17443k() {
            return this.f2120k;
        }
    }

    /* renamed from: com.xiaomi.push.ed$b */
    public static final class C1749b extends C1742e {

        /* renamed from: a */
        private int f2121a = 0;

        /* renamed from: a */
        private boolean f2122a;

        /* renamed from: b */
        private int f2123b = 0;

        /* renamed from: b */
        private boolean f2124b = false;

        /* renamed from: c */
        private int f2125c = 0;

        /* renamed from: c */
        private boolean f2126c;

        /* renamed from: d */
        private int f2127d = -1;

        /* renamed from: d */
        private boolean f2128d;

        /* renamed from: e */
        private boolean f2129e;

        /* renamed from: a */
        public static C1749b m3149a(byte[] bArr) {
            return (C1749b) new C1749b().m3149a(bArr);
        }

        /* renamed from: a */
        public int mo17407a() {
            if (this.f2127d < 0) {
                mo17413b();
            }
            return this.f2127d;
        }

        /* renamed from: a */
        public C1749b mo17444a(int i) {
            this.f2126c = true;
            this.f2121a = i;
            return this;
        }

        /* renamed from: a */
        public C1749b m3153a(C1641b bVar) {
            while (true) {
                int a = bVar.mo17241a();
                if (a == 0) {
                    return this;
                }
                if (a == 8) {
                    mo17445a(bVar.mo17241a());
                } else if (a == 24) {
                    mo17444a(bVar.mo17244b());
                } else if (a == 32) {
                    mo17446b(bVar.mo17244b());
                } else if (a == 40) {
                    mo17448c(bVar.mo17244b());
                } else if (!mo17412a(bVar, a)) {
                    return this;
                }
            }
        }

        /* renamed from: a */
        public C1749b mo17445a(boolean z) {
            this.f2122a = true;
            this.f2124b = z;
            return this;
        }

        /* renamed from: a */
        public void mo17411a(C1675c cVar) {
            if (mo17413b()) {
                cVar.mo17287a(1, mo17407a());
            }
            if (mo17447c()) {
                cVar.mo17282a(3, mo17447c());
            }
            if (mo17449d()) {
                cVar.mo17282a(4, mo17449d());
            }
            if (mo17450e()) {
                cVar.mo17282a(5, mo17450e());
            }
        }

        /* renamed from: a */
        public boolean m3156a() {
            return this.f2124b;
        }

        /* renamed from: b */
        public int mo17413b() {
            int i = 0;
            if (mo17413b()) {
                i = 0 + C1675c.mo17287a(1, mo17407a());
            }
            if (mo17447c()) {
                i += C1675c.mo17282a(3, mo17447c());
            }
            if (mo17449d()) {
                i += C1675c.mo17282a(4, mo17449d());
            }
            if (mo17450e()) {
                i += C1675c.mo17282a(5, mo17450e());
            }
            this.f2127d = i;
            return i;
        }

        /* renamed from: b */
        public C1749b mo17446b(int i) {
            this.f2128d = true;
            this.f2123b = i;
            return this;
        }

        /* renamed from: b */
        public boolean m3159b() {
            return this.f2122a;
        }

        /* renamed from: c */
        public int mo17447c() {
            return this.f2121a;
        }

        /* renamed from: c */
        public C1749b mo17448c(int i) {
            this.f2129e = true;
            this.f2125c = i;
            return this;
        }

        /* renamed from: c */
        public boolean m3162c() {
            return this.f2126c;
        }

        /* renamed from: d */
        public int mo17449d() {
            return this.f2123b;
        }

        /* renamed from: d */
        public boolean m3164d() {
            return this.f2128d;
        }

        /* renamed from: e */
        public int mo17450e() {
            return this.f2125c;
        }

        /* renamed from: e */
        public boolean m3166e() {
            return this.f2129e;
        }
    }

    /* renamed from: com.xiaomi.push.ed$c */
    public static final class C1750c extends C1742e {

        /* renamed from: a */
        private int f2130a = -1;

        /* renamed from: a */
        private String f2131a = "";

        /* renamed from: a */
        private boolean f2132a;

        /* renamed from: b */
        private String f2133b = "";

        /* renamed from: b */
        private boolean f2134b;

        /* renamed from: c */
        private String f2135c = "";

        /* renamed from: c */
        private boolean f2136c;

        /* renamed from: d */
        private String f2137d = "";

        /* renamed from: d */
        private boolean f2138d;

        /* renamed from: e */
        private String f2139e = "";

        /* renamed from: e */
        private boolean f2140e;

        /* renamed from: f */
        private String f2141f = "";

        /* renamed from: f */
        private boolean f2142f;

        /* renamed from: a */
        public int mo17407a() {
            if (this.f2130a < 0) {
                mo17413b();
            }
            return this.f2130a;
        }

        /* renamed from: a */
        public C1750c m3169a(C1641b bVar) {
            while (true) {
                int a = bVar.mo17241a();
                if (a == 0) {
                    return this;
                }
                if (a == 10) {
                    mo17451a(bVar.mo17241a());
                } else if (a == 18) {
                    mo17452b(bVar.mo17241a());
                } else if (a == 26) {
                    mo17453c(bVar.mo17241a());
                } else if (a == 34) {
                    mo17455d(bVar.mo17241a());
                } else if (a == 42) {
                    mo17457e(bVar.mo17241a());
                } else if (a == 50) {
                    mo17459f(bVar.mo17241a());
                } else if (!mo17412a(bVar, a)) {
                    return this;
                }
            }
        }

        /* renamed from: a */
        public C1750c mo17451a(String str) {
            this.f2132a = true;
            this.f2131a = str;
            return this;
        }

        /* renamed from: a */
        public String m3171a() {
            return this.f2131a;
        }

        /* renamed from: a */
        public void mo17411a(C1675c cVar) {
            if (mo17407a()) {
                cVar.mo17286a(1, mo17407a());
            }
            if (mo17413b()) {
                cVar.mo17286a(2, mo17413b());
            }
            if (mo17454c()) {
                cVar.mo17286a(3, mo17454c());
            }
            if (mo17456d()) {
                cVar.mo17286a(4, mo17456d());
            }
            if (mo17458e()) {
                cVar.mo17286a(5, mo17458e());
            }
            if (mo17460f()) {
                cVar.mo17286a(6, mo17460f());
            }
        }

        /* renamed from: a */
        public boolean m3173a() {
            return this.f2132a;
        }

        /* renamed from: b */
        public int mo17413b() {
            int i = 0;
            if (mo17407a()) {
                i = 0 + C1675c.mo17286a(1, mo17407a());
            }
            if (mo17413b()) {
                i += C1675c.mo17286a(2, mo17413b());
            }
            if (mo17454c()) {
                i += C1675c.mo17286a(3, mo17454c());
            }
            if (mo17456d()) {
                i += C1675c.mo17286a(4, mo17456d());
            }
            if (mo17458e()) {
                i += C1675c.mo17286a(5, mo17458e());
            }
            if (mo17460f()) {
                i += C1675c.mo17286a(6, mo17460f());
            }
            this.f2130a = i;
            return i;
        }

        /* renamed from: b */
        public C1750c mo17452b(String str) {
            this.f2134b = true;
            this.f2133b = str;
            return this;
        }

        /* renamed from: b */
        public String m3176b() {
            return this.f2133b;
        }

        /* renamed from: b */
        public boolean m3177b() {
            return this.f2134b;
        }

        /* renamed from: c */
        public C1750c mo17453c(String str) {
            this.f2136c = true;
            this.f2135c = str;
            return this;
        }

        /* renamed from: c */
        public String mo17454c() {
            return this.f2135c;
        }

        /* renamed from: c */
        public boolean m3180c() {
            return this.f2136c;
        }

        /* renamed from: d */
        public C1750c mo17455d(String str) {
            this.f2138d = true;
            this.f2137d = str;
            return this;
        }

        /* renamed from: d */
        public String mo17456d() {
            return this.f2137d;
        }

        /* renamed from: d */
        public boolean m3183d() {
            return this.f2138d;
        }

        /* renamed from: e */
        public C1750c mo17457e(String str) {
            this.f2140e = true;
            this.f2139e = str;
            return this;
        }

        /* renamed from: e */
        public String mo17458e() {
            return this.f2139e;
        }

        /* renamed from: e */
        public boolean m3186e() {
            return this.f2140e;
        }

        /* renamed from: f */
        public C1750c mo17459f(String str) {
            this.f2142f = true;
            this.f2141f = str;
            return this;
        }

        /* renamed from: f */
        public String mo17460f() {
            return this.f2141f;
        }

        /* renamed from: f */
        public boolean m3189f() {
            return this.f2142f;
        }
    }

    /* renamed from: com.xiaomi.push.ed$d */
    public static final class C1751d extends C1742e {

        /* renamed from: a */
        private int f2143a = -1;

        /* renamed from: a */
        private String f2144a = "";

        /* renamed from: a */
        private boolean f2145a;

        /* renamed from: b */
        private String f2146b = "";

        /* renamed from: b */
        private boolean f2147b = false;

        /* renamed from: c */
        private String f2148c = "";

        /* renamed from: c */
        private boolean f2149c;

        /* renamed from: d */
        private boolean f2150d;

        /* renamed from: e */
        private boolean f2151e;

        /* renamed from: a */
        public static C1751d m3190a(byte[] bArr) {
            return (C1751d) new C1751d().m3190a(bArr);
        }

        /* renamed from: a */
        public int mo17407a() {
            if (this.f2143a < 0) {
                mo17413b();
            }
            return this.f2143a;
        }

        /* renamed from: a */
        public C1751d m3193a(C1641b bVar) {
            while (true) {
                int a = bVar.mo17241a();
                if (a == 0) {
                    return this;
                }
                if (a == 8) {
                    mo17462a(bVar.mo17241a());
                } else if (a == 18) {
                    mo17461a(bVar.mo17241a());
                } else if (a == 26) {
                    mo17463b(bVar.mo17241a());
                } else if (a == 34) {
                    mo17464c(bVar.mo17241a());
                } else if (!mo17412a(bVar, a)) {
                    return this;
                }
            }
        }

        /* renamed from: a */
        public C1751d mo17461a(String str) {
            this.f2149c = true;
            this.f2144a = str;
            return this;
        }

        /* renamed from: a */
        public C1751d mo17462a(boolean z) {
            this.f2145a = true;
            this.f2147b = z;
            return this;
        }

        /* renamed from: a */
        public String m3196a() {
            return this.f2144a;
        }

        /* renamed from: a */
        public void mo17411a(C1675c cVar) {
            if (mo17413b()) {
                cVar.mo17287a(1, mo17407a());
            }
            if (mo17465c()) {
                cVar.mo17286a(2, mo17407a());
            }
            if (mo17466d()) {
                cVar.mo17286a(3, mo17413b());
            }
            if (mo17467e()) {
                cVar.mo17286a(4, mo17465c());
            }
        }

        /* renamed from: a */
        public boolean m3198a() {
            return this.f2147b;
        }

        /* renamed from: b */
        public int mo17413b() {
            int i = 0;
            if (mo17413b()) {
                i = 0 + C1675c.mo17287a(1, mo17407a());
            }
            if (mo17465c()) {
                i += C1675c.mo17286a(2, mo17407a());
            }
            if (mo17466d()) {
                i += C1675c.mo17286a(3, mo17413b());
            }
            if (mo17467e()) {
                i += C1675c.mo17286a(4, mo17465c());
            }
            this.f2143a = i;
            return i;
        }

        /* renamed from: b */
        public C1751d mo17463b(String str) {
            this.f2150d = true;
            this.f2146b = str;
            return this;
        }

        /* renamed from: b */
        public String m3201b() {
            return this.f2146b;
        }

        /* renamed from: b */
        public boolean m3202b() {
            return this.f2145a;
        }

        /* renamed from: c */
        public C1751d mo17464c(String str) {
            this.f2151e = true;
            this.f2148c = str;
            return this;
        }

        /* renamed from: c */
        public String mo17465c() {
            return this.f2148c;
        }

        /* renamed from: c */
        public boolean m3205c() {
            return this.f2149c;
        }

        /* renamed from: d */
        public boolean mo17466d() {
            return this.f2150d;
        }

        /* renamed from: e */
        public boolean mo17467e() {
            return this.f2151e;
        }
    }

    /* renamed from: com.xiaomi.push.ed$e */
    public static final class C1752e extends C1742e {

        /* renamed from: a */
        private int f2152a = 0;

        /* renamed from: a */
        private C1749b f2153a = null;

        /* renamed from: a */
        private String f2154a = "";

        /* renamed from: a */
        private boolean f2155a;

        /* renamed from: b */
        private int f2156b = 0;

        /* renamed from: b */
        private String f2157b = "";

        /* renamed from: b */
        private boolean f2158b;

        /* renamed from: c */
        private int f2159c = 0;

        /* renamed from: c */
        private String f2160c = "";

        /* renamed from: c */
        private boolean f2161c;

        /* renamed from: d */
        private int f2162d = -1;

        /* renamed from: d */
        private String f2163d = "";

        /* renamed from: d */
        private boolean f2164d;

        /* renamed from: e */
        private String f2165e = "";

        /* renamed from: e */
        private boolean f2166e;

        /* renamed from: f */
        private String f2167f = "";

        /* renamed from: f */
        private boolean f2168f;

        /* renamed from: g */
        private boolean f2169g;

        /* renamed from: h */
        private boolean f2170h;

        /* renamed from: i */
        private boolean f2171i;

        /* renamed from: j */
        private boolean f2172j;

        /* renamed from: a */
        public int mo17407a() {
            if (this.f2162d < 0) {
                mo17413b();
            }
            return this.f2162d;
        }

        /* renamed from: a */
        public C1749b m3210a() {
            return this.f2153a;
        }

        /* renamed from: a */
        public C1752e mo17468a(int i) {
            this.f2155a = true;
            this.f2152a = i;
            return this;
        }

        /* renamed from: a */
        public C1752e m3212a(C1641b bVar) {
            while (true) {
                int a = bVar.mo17241a();
                switch (a) {
                    case 0:
                        return this;
                    case 8:
                        mo17468a(bVar.mo17246c());
                        break;
                    case 18:
                        mo17470a(bVar.mo17241a());
                        break;
                    case 26:
                        mo17472b(bVar.mo17241a());
                        break;
                    case 34:
                        mo17475c(bVar.mo17241a());
                        break;
                    case 40:
                        mo17471b(bVar.mo17244b());
                        break;
                    case 50:
                        mo17477d(bVar.mo17241a());
                        break;
                    case 58:
                        mo17479e(bVar.mo17241a());
                        break;
                    case 66:
                        mo17480f(bVar.mo17241a());
                        break;
                    case 74:
                        C1749b bVar2 = new C1749b();
                        bVar.mo17243a((C1742e) bVar2);
                        mo17469a(bVar2);
                        break;
                    case 80:
                        mo17474c(bVar.mo17244b());
                        break;
                    default:
                        if (mo17412a(bVar, a)) {
                            break;
                        } else {
                            return this;
                        }
                }
            }
        }

        /* renamed from: a */
        public C1752e mo17469a(C1749b bVar) {
            if (bVar != null) {
                this.f2171i = true;
                this.f2153a = bVar;
                return this;
            }
            throw new NullPointerException();
        }

        /* renamed from: a */
        public C1752e mo17470a(String str) {
            this.f2158b = true;
            this.f2154a = str;
            return this;
        }

        /* renamed from: a */
        public String m3215a() {
            return this.f2154a;
        }

        /* renamed from: a */
        public void mo17411a(C1675c cVar) {
            if (mo17407a()) {
                cVar.mo17297b(1, mo17473c());
            }
            if (mo17413b()) {
                cVar.mo17286a(2, mo17407a());
            }
            if (mo17473c()) {
                cVar.mo17286a(3, mo17413b());
            }
            if (mo17476d()) {
                cVar.mo17286a(4, mo17473c());
            }
            if (mo17478e()) {
                cVar.mo17282a(5, mo17476d());
            }
            if (mo17481f()) {
                cVar.mo17286a(6, mo17476d());
            }
            if (mo17482g()) {
                cVar.mo17286a(7, mo17478e());
            }
            if (mo17483h()) {
                cVar.mo17286a(8, mo17481f());
            }
            if (mo17484i()) {
                cVar.mo17285a(9, (C1742e) mo17407a());
            }
            if (mo17485j()) {
                cVar.mo17282a(10, mo17478e());
            }
        }

        /* renamed from: a */
        public boolean m3217a() {
            return this.f2155a;
        }

        /* renamed from: b */
        public int mo17413b() {
            int i = 0;
            if (mo17407a()) {
                i = 0 + C1675c.mo17297b(1, mo17473c());
            }
            if (mo17413b()) {
                i += C1675c.mo17286a(2, mo17407a());
            }
            if (mo17473c()) {
                i += C1675c.mo17286a(3, mo17413b());
            }
            if (mo17476d()) {
                i += C1675c.mo17286a(4, mo17473c());
            }
            if (mo17478e()) {
                i += C1675c.mo17282a(5, mo17476d());
            }
            if (mo17481f()) {
                i += C1675c.mo17286a(6, mo17476d());
            }
            if (mo17482g()) {
                i += C1675c.mo17286a(7, mo17478e());
            }
            if (mo17483h()) {
                i += C1675c.mo17286a(8, mo17481f());
            }
            if (mo17484i()) {
                i += C1675c.mo17285a(9, (C1742e) mo17407a());
            }
            if (mo17485j()) {
                i += C1675c.mo17282a(10, mo17478e());
            }
            this.f2162d = i;
            return i;
        }

        /* renamed from: b */
        public C1752e mo17471b(int i) {
            this.f2166e = true;
            this.f2156b = i;
            return this;
        }

        /* renamed from: b */
        public C1752e mo17472b(String str) {
            this.f2161c = true;
            this.f2157b = str;
            return this;
        }

        /* renamed from: b */
        public String m3221b() {
            return this.f2157b;
        }

        /* renamed from: b */
        public boolean m3222b() {
            return this.f2158b;
        }

        /* renamed from: c */
        public int mo17473c() {
            return this.f2152a;
        }

        /* renamed from: c */
        public C1752e mo17474c(int i) {
            this.f2172j = true;
            this.f2159c = i;
            return this;
        }

        /* renamed from: c */
        public C1752e mo17475c(String str) {
            this.f2164d = true;
            this.f2160c = str;
            return this;
        }

        /* renamed from: c */
        public String m3226c() {
            return this.f2160c;
        }

        /* renamed from: c */
        public boolean m3227c() {
            return this.f2161c;
        }

        /* renamed from: d */
        public int mo17476d() {
            return this.f2156b;
        }

        /* renamed from: d */
        public C1752e mo17477d(String str) {
            this.f2168f = true;
            this.f2163d = str;
            return this;
        }

        /* renamed from: d */
        public String m3230d() {
            return this.f2163d;
        }

        /* renamed from: d */
        public boolean m3231d() {
            return this.f2164d;
        }

        /* renamed from: e */
        public int mo17478e() {
            return this.f2159c;
        }

        /* renamed from: e */
        public C1752e mo17479e(String str) {
            this.f2169g = true;
            this.f2165e = str;
            return this;
        }

        /* renamed from: e */
        public String m3234e() {
            return this.f2165e;
        }

        /* renamed from: e */
        public boolean m3235e() {
            return this.f2166e;
        }

        /* renamed from: f */
        public C1752e mo17480f(String str) {
            this.f2170h = true;
            this.f2167f = str;
            return this;
        }

        /* renamed from: f */
        public String mo17481f() {
            return this.f2167f;
        }

        /* renamed from: f */
        public boolean m3238f() {
            return this.f2168f;
        }

        /* renamed from: g */
        public boolean mo17482g() {
            return this.f2169g;
        }

        /* renamed from: h */
        public boolean mo17483h() {
            return this.f2170h;
        }

        /* renamed from: i */
        public boolean mo17484i() {
            return this.f2171i;
        }

        /* renamed from: j */
        public boolean mo17485j() {
            return this.f2172j;
        }
    }

    /* renamed from: com.xiaomi.push.ed$f */
    public static final class C1753f extends C1742e {

        /* renamed from: a */
        private int f2173a = -1;

        /* renamed from: a */
        private C1749b f2174a = null;

        /* renamed from: a */
        private String f2175a = "";

        /* renamed from: a */
        private boolean f2176a;

        /* renamed from: b */
        private String f2177b = "";

        /* renamed from: b */
        private boolean f2178b;

        /* renamed from: c */
        private boolean f2179c;

        /* renamed from: a */
        public static C1753f m3243a(byte[] bArr) {
            return (C1753f) new C1753f().m3243a(bArr);
        }

        /* renamed from: a */
        public int mo17407a() {
            if (this.f2173a < 0) {
                mo17413b();
            }
            return this.f2173a;
        }

        /* renamed from: a */
        public C1749b m3246a() {
            return this.f2174a;
        }

        /* renamed from: a */
        public C1753f m3247a(C1641b bVar) {
            while (true) {
                int a = bVar.mo17241a();
                if (a == 0) {
                    return this;
                }
                if (a == 10) {
                    mo17487a(bVar.mo17241a());
                } else if (a == 18) {
                    mo17488b(bVar.mo17241a());
                } else if (a == 26) {
                    C1749b bVar2 = new C1749b();
                    bVar.mo17243a((C1742e) bVar2);
                    mo17486a(bVar2);
                } else if (!mo17412a(bVar, a)) {
                    return this;
                }
            }
        }

        /* renamed from: a */
        public C1753f mo17486a(C1749b bVar) {
            if (bVar != null) {
                this.f2179c = true;
                this.f2174a = bVar;
                return this;
            }
            throw new NullPointerException();
        }

        /* renamed from: a */
        public C1753f mo17487a(String str) {
            this.f2176a = true;
            this.f2175a = str;
            return this;
        }

        /* renamed from: a */
        public String m3250a() {
            return this.f2175a;
        }

        /* renamed from: a */
        public void mo17411a(C1675c cVar) {
            if (mo17407a()) {
                cVar.mo17286a(1, mo17407a());
            }
            if (mo17413b()) {
                cVar.mo17286a(2, mo17413b());
            }
            if (mo17489c()) {
                cVar.mo17285a(3, (C1742e) mo17407a());
            }
        }

        /* renamed from: a */
        public boolean m3252a() {
            return this.f2176a;
        }

        /* renamed from: b */
        public int mo17413b() {
            int i = 0;
            if (mo17407a()) {
                i = 0 + C1675c.mo17286a(1, mo17407a());
            }
            if (mo17413b()) {
                i += C1675c.mo17286a(2, mo17413b());
            }
            if (mo17489c()) {
                i += C1675c.mo17285a(3, (C1742e) mo17407a());
            }
            this.f2173a = i;
            return i;
        }

        /* renamed from: b */
        public C1753f mo17488b(String str) {
            this.f2178b = true;
            this.f2177b = str;
            return this;
        }

        /* renamed from: b */
        public String m3255b() {
            return this.f2177b;
        }

        /* renamed from: b */
        public boolean m3256b() {
            return this.f2178b;
        }

        /* renamed from: c */
        public boolean mo17489c() {
            return this.f2179c;
        }
    }

    /* renamed from: com.xiaomi.push.ed$g */
    public static final class C1754g extends C1742e {

        /* renamed from: a */
        private int f2180a = -1;

        /* renamed from: a */
        private String f2181a = "";

        /* renamed from: a */
        private boolean f2182a;

        /* renamed from: b */
        private String f2183b = "";

        /* renamed from: b */
        private boolean f2184b;

        /* renamed from: c */
        private String f2185c = "";

        /* renamed from: c */
        private boolean f2186c;

        /* renamed from: a */
        public static C1754g m3258a(byte[] bArr) {
            return (C1754g) new C1754g().m3258a(bArr);
        }

        /* renamed from: a */
        public int mo17407a() {
            if (this.f2180a < 0) {
                mo17413b();
            }
            return this.f2180a;
        }

        /* renamed from: a */
        public C1754g m3261a(C1641b bVar) {
            while (true) {
                int a = bVar.mo17241a();
                if (a == 0) {
                    return this;
                }
                if (a == 10) {
                    mo17490a(bVar.mo17241a());
                } else if (a == 18) {
                    mo17491b(bVar.mo17241a());
                } else if (a == 26) {
                    mo17492c(bVar.mo17241a());
                } else if (!mo17412a(bVar, a)) {
                    return this;
                }
            }
        }

        /* renamed from: a */
        public C1754g mo17490a(String str) {
            this.f2182a = true;
            this.f2181a = str;
            return this;
        }

        /* renamed from: a */
        public String m3263a() {
            return this.f2181a;
        }

        /* renamed from: a */
        public void mo17411a(C1675c cVar) {
            if (mo17407a()) {
                cVar.mo17286a(1, mo17407a());
            }
            if (mo17413b()) {
                cVar.mo17286a(2, mo17413b());
            }
            if (mo17493c()) {
                cVar.mo17286a(3, mo17493c());
            }
        }

        /* renamed from: a */
        public boolean m3265a() {
            return this.f2182a;
        }

        /* renamed from: b */
        public int mo17413b() {
            int i = 0;
            if (mo17407a()) {
                i = 0 + C1675c.mo17286a(1, mo17407a());
            }
            if (mo17413b()) {
                i += C1675c.mo17286a(2, mo17413b());
            }
            if (mo17493c()) {
                i += C1675c.mo17286a(3, mo17493c());
            }
            this.f2180a = i;
            return i;
        }

        /* renamed from: b */
        public C1754g mo17491b(String str) {
            this.f2184b = true;
            this.f2183b = str;
            return this;
        }

        /* renamed from: b */
        public String m3268b() {
            return this.f2183b;
        }

        /* renamed from: b */
        public boolean m3269b() {
            return this.f2184b;
        }

        /* renamed from: c */
        public C1754g mo17492c(String str) {
            this.f2186c = true;
            this.f2185c = str;
            return this;
        }

        /* renamed from: c */
        public String mo17493c() {
            return this.f2185c;
        }

        /* renamed from: c */
        public boolean m3272c() {
            return this.f2186c;
        }
    }

    /* renamed from: com.xiaomi.push.ed$h */
    public static final class C1755h extends C1742e {

        /* renamed from: a */
        private int f2187a = 0;

        /* renamed from: a */
        private String f2188a = "";

        /* renamed from: a */
        private boolean f2189a;

        /* renamed from: b */
        private int f2190b = -1;

        /* renamed from: b */
        private boolean f2191b;

        /* renamed from: a */
        public static C1755h m3273a(byte[] bArr) {
            return (C1755h) new C1755h().m3273a(bArr);
        }

        /* renamed from: a */
        public int mo17407a() {
            if (this.f2190b < 0) {
                mo17413b();
            }
            return this.f2190b;
        }

        /* renamed from: a */
        public C1755h mo17494a(int i) {
            this.f2189a = true;
            this.f2187a = i;
            return this;
        }

        /* renamed from: a */
        public C1755h m3277a(C1641b bVar) {
            while (true) {
                int a = bVar.mo17241a();
                if (a == 0) {
                    return this;
                }
                if (a == 8) {
                    mo17494a(bVar.mo17244b());
                } else if (a == 18) {
                    mo17495a(bVar.mo17241a());
                } else if (!mo17412a(bVar, a)) {
                    return this;
                }
            }
        }

        /* renamed from: a */
        public C1755h mo17495a(String str) {
            this.f2191b = true;
            this.f2188a = str;
            return this;
        }

        /* renamed from: a */
        public String m3279a() {
            return this.f2188a;
        }

        /* renamed from: a */
        public void mo17411a(C1675c cVar) {
            if (mo17407a()) {
                cVar.mo17282a(1, mo17496c());
            }
            if (mo17413b()) {
                cVar.mo17286a(2, mo17407a());
            }
        }

        /* renamed from: a */
        public boolean m3281a() {
            return this.f2189a;
        }

        /* renamed from: b */
        public int mo17413b() {
            int i = 0;
            if (mo17407a()) {
                i = 0 + C1675c.mo17282a(1, mo17496c());
            }
            if (mo17413b()) {
                i += C1675c.mo17286a(2, mo17407a());
            }
            this.f2190b = i;
            return i;
        }

        /* renamed from: b */
        public boolean m3283b() {
            return this.f2191b;
        }

        /* renamed from: c */
        public int mo17496c() {
            return this.f2187a;
        }
    }

    /* renamed from: com.xiaomi.push.ed$i */
    public static final class C1756i extends C1742e {

        /* renamed from: a */
        private int f2192a = -1;

        /* renamed from: a */
        private C1607a f2193a = C1607a.f1750a;

        /* renamed from: a */
        private boolean f2194a;

        /* renamed from: a */
        public static C1756i m3285a(byte[] bArr) {
            return (C1756i) new C1756i().m3285a(bArr);
        }

        /* renamed from: a */
        public int mo17407a() {
            if (this.f2192a < 0) {
                mo17413b();
            }
            return this.f2192a;
        }

        /* renamed from: a */
        public C1607a m3287a() {
            return this.f2193a;
        }

        /* renamed from: a */
        public C1756i mo17497a(C1607a aVar) {
            this.f2194a = true;
            this.f2193a = aVar;
            return this;
        }

        /* renamed from: a */
        public C1756i m3290a(C1641b bVar) {
            while (true) {
                int a = bVar.mo17241a();
                if (a == 0) {
                    return this;
                }
                if (a == 10) {
                    mo17497a(bVar.mo17241a());
                } else if (!mo17412a(bVar, a)) {
                    return this;
                }
            }
        }

        /* renamed from: a */
        public void mo17411a(C1675c cVar) {
            if (mo17407a()) {
                cVar.mo17284a(1, mo17407a());
            }
        }

        /* renamed from: a */
        public boolean m3292a() {
            return this.f2194a;
        }

        /* renamed from: b */
        public int mo17413b() {
            int i = 0;
            if (mo17407a()) {
                i = 0 + C1675c.mo17284a(1, mo17407a());
            }
            this.f2192a = i;
            return i;
        }
    }

    /* renamed from: com.xiaomi.push.ed$j */
    public static final class C1757j extends C1742e {

        /* renamed from: a */
        private int f2195a = -1;

        /* renamed from: a */
        private C1607a f2196a = C1607a.f1750a;

        /* renamed from: a */
        private C1749b f2197a = null;

        /* renamed from: a */
        private boolean f2198a;

        /* renamed from: b */
        private boolean f2199b;

        /* renamed from: a */
        public static C1757j m3294a(byte[] bArr) {
            return (C1757j) new C1757j().m3294a(bArr);
        }

        /* renamed from: a */
        public int mo17407a() {
            if (this.f2195a < 0) {
                mo17413b();
            }
            return this.f2195a;
        }

        /* renamed from: a */
        public C1607a m3296a() {
            return this.f2196a;
        }

        /* renamed from: a */
        public C1749b m3298a() {
            return this.f2197a;
        }

        /* renamed from: a */
        public C1757j mo17498a(C1607a aVar) {
            this.f2198a = true;
            this.f2196a = aVar;
            return this;
        }

        /* renamed from: a */
        public C1757j m3300a(C1641b bVar) {
            while (true) {
                int a = bVar.mo17241a();
                if (a == 0) {
                    return this;
                }
                if (a == 10) {
                    mo17498a(bVar.mo17241a());
                } else if (a == 18) {
                    C1749b bVar2 = new C1749b();
                    bVar.mo17243a((C1742e) bVar2);
                    mo17499a(bVar2);
                } else if (!mo17412a(bVar, a)) {
                    return this;
                }
            }
        }

        /* renamed from: a */
        public C1757j mo17499a(C1749b bVar) {
            if (bVar != null) {
                this.f2199b = true;
                this.f2197a = bVar;
                return this;
            }
            throw new NullPointerException();
        }

        /* renamed from: a */
        public void mo17411a(C1675c cVar) {
            if (mo17407a()) {
                cVar.mo17284a(1, mo17407a());
            }
            if (mo17413b()) {
                cVar.mo17285a(2, (C1742e) mo17407a());
            }
        }

        /* renamed from: a */
        public boolean m3303a() {
            return this.f2198a;
        }

        /* renamed from: b */
        public int mo17413b() {
            int i = 0;
            if (mo17407a()) {
                i = 0 + C1675c.mo17284a(1, mo17407a());
            }
            if (mo17413b()) {
                i += C1675c.mo17285a(2, (C1742e) mo17407a());
            }
            this.f2195a = i;
            return i;
        }

        /* renamed from: b */
        public boolean m3305b() {
            return this.f2199b;
        }
    }

    /* renamed from: com.xiaomi.push.ed$k */
    public static final class C1758k extends C1742e {

        /* renamed from: a */
        private int f2200a = 0;

        /* renamed from: a */
        private long f2201a = 0;

        /* renamed from: a */
        private String f2202a = "";

        /* renamed from: a */
        private boolean f2203a;

        /* renamed from: b */
        private int f2204b = -1;

        /* renamed from: b */
        private long f2205b = 0;

        /* renamed from: b */
        private String f2206b = "";

        /* renamed from: b */
        private boolean f2207b;

        /* renamed from: c */
        private boolean f2208c;

        /* renamed from: d */
        private boolean f2209d;

        /* renamed from: e */
        private boolean f2210e;

        /* renamed from: f */
        private boolean f2211f = false;

        /* renamed from: g */
        private boolean f2212g;

        /* renamed from: a */
        public static C1758k m3306a(byte[] bArr) {
            return (C1758k) new C1758k().m3306a(bArr);
        }

        /* renamed from: a */
        public int mo17407a() {
            if (this.f2204b < 0) {
                mo17413b();
            }
            return this.f2204b;
        }

        /* renamed from: a */
        public long m3308a() {
            return this.f2201a;
        }

        /* renamed from: a */
        public C1758k mo17500a(int i) {
            this.f2212g = true;
            this.f2200a = i;
            return this;
        }

        /* renamed from: a */
        public C1758k mo17501a(long j) {
            this.f2208c = true;
            this.f2201a = j;
            return this;
        }

        /* renamed from: a */
        public C1758k m3312a(C1641b bVar) {
            while (true) {
                int a = bVar.mo17241a();
                if (a == 0) {
                    return this;
                }
                if (a == 10) {
                    mo17502a(bVar.mo17241a());
                } else if (a == 18) {
                    mo17505b(bVar.mo17241a());
                } else if (a == 24) {
                    mo17501a(bVar.mo17241a());
                } else if (a == 32) {
                    mo17504b(bVar.mo17241a());
                } else if (a == 40) {
                    mo17503a(bVar.mo17241a());
                } else if (a == 48) {
                    mo17500a(bVar.mo17244b());
                } else if (!mo17412a(bVar, a)) {
                    return this;
                }
            }
        }

        /* renamed from: a */
        public C1758k mo17502a(String str) {
            this.f2203a = true;
            this.f2202a = str;
            return this;
        }

        /* renamed from: a */
        public C1758k mo17503a(boolean z) {
            this.f2210e = true;
            this.f2211f = z;
            return this;
        }

        /* renamed from: a */
        public String m3315a() {
            return this.f2202a;
        }

        /* renamed from: a */
        public void mo17411a(C1675c cVar) {
            if (mo17407a()) {
                cVar.mo17286a(1, mo17407a());
            }
            if (mo17413b()) {
                cVar.mo17286a(2, mo17413b());
            }
            if (mo17506c()) {
                cVar.mo17283a(3, mo17407a());
            }
            if (mo17507d()) {
                cVar.mo17283a(4, mo17413b());
            }
            if (mo17509f()) {
                cVar.mo17287a(5, mo17508e());
            }
            if (mo17510g()) {
                cVar.mo17282a(6, mo17506c());
            }
        }

        /* renamed from: a */
        public boolean m3317a() {
            return this.f2203a;
        }

        /* renamed from: b */
        public int mo17413b() {
            int i = 0;
            if (mo17407a()) {
                i = 0 + C1675c.mo17286a(1, mo17407a());
            }
            if (mo17413b()) {
                i += C1675c.mo17286a(2, mo17413b());
            }
            if (mo17506c()) {
                i += C1675c.mo17283a(3, mo17407a());
            }
            if (mo17507d()) {
                i += C1675c.mo17283a(4, mo17413b());
            }
            if (mo17509f()) {
                i += C1675c.mo17287a(5, mo17508e());
            }
            if (mo17510g()) {
                i += C1675c.mo17282a(6, mo17506c());
            }
            this.f2204b = i;
            return i;
        }

        /* renamed from: b */
        public long m3319b() {
            return this.f2205b;
        }

        /* renamed from: b */
        public C1758k mo17504b(long j) {
            this.f2209d = true;
            this.f2205b = j;
            return this;
        }

        /* renamed from: b */
        public C1758k mo17505b(String str) {
            this.f2207b = true;
            this.f2206b = str;
            return this;
        }

        /* renamed from: b */
        public String m3322b() {
            return this.f2206b;
        }

        /* renamed from: b */
        public boolean m3323b() {
            return this.f2207b;
        }

        /* renamed from: c */
        public int mo17506c() {
            return this.f2200a;
        }

        /* renamed from: c */
        public boolean m3325c() {
            return this.f2208c;
        }

        /* renamed from: d */
        public boolean mo17507d() {
            return this.f2209d;
        }

        /* renamed from: e */
        public boolean mo17508e() {
            return this.f2211f;
        }

        /* renamed from: f */
        public boolean mo17509f() {
            return this.f2210e;
        }

        /* renamed from: g */
        public boolean mo17510g() {
            return this.f2212g;
        }
    }
}
