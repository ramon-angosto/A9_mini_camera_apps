package com.huawei.appgallery.serviceverifykit.api;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.Signature;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.bumptech.glide.load.Key;
import com.huawei.appgallery.serviceverifykit.p008a.C0571a;
import com.huawei.appgallery.serviceverifykit.p009b.C0573a;
import com.huawei.appgallery.serviceverifykit.p009b.C0574b;
import com.huawei.appgallery.serviceverifykit.p009b.C0575c;
import com.huawei.appgallery.serviceverifykit.p009b.p010d.C0577b;
import com.huawei.hms.framework.common.ContainerUtils;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ServiceVerifyKit {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public Context f136a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public String f137b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public String f138c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public String f139d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public String f140e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public String f141f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public Map<String, String[]> f142g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public Map<String, Integer> f143h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public int f144i;

    /* renamed from: j */
    private int f145j;

    /* renamed from: k */
    private int f146k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public String f147l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public String f148m;

    /* renamed from: n */
    private String f149n;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public Intent f150o;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public Builder.ComponentType f151p;

    public static class Builder {

        /* renamed from: a */
        private String f152a;

        /* renamed from: b */
        private String f153b = "AppGallery Verification";

        /* renamed from: c */
        private String f154c = "Huawei CBG Cloud Security Signer";

        /* renamed from: d */
        private String f155d = "com.huawei.appgallery.fingerprint_signature";

        /* renamed from: e */
        private String f156e = "com.huawei.appgallery.sign_certchain";

        /* renamed from: f */
        private Map<String, String[]> f157f = new HashMap();

        /* renamed from: g */
        private Map<String, Integer> f158g = new HashMap();

        /* renamed from: h */
        private Context f159h;

        /* renamed from: i */
        private int f160i;

        /* renamed from: j */
        private int f161j = 0;

        /* renamed from: k */
        private Intent f162k;

        /* renamed from: l */
        private ComponentType f163l;

        /* renamed from: m */
        private String f164m = "verify_match_property";

        /* renamed from: n */
        private String f165n;

        public enum ComponentType {
            ACTIVITY,
            SERVICE,
            BROADCAST
        }

        public Builder addLegacyInfo(String str, String str2) {
            this.f157f.put(str, ServiceVerifyKit.m110b(this.f157f.get(str), str2));
            this.f158g.put(str, Integer.valueOf(this.f161j));
            return this;
        }

        public Builder addLegacyInfo(String str, String str2, int i) {
            this.f157f.put(str, ServiceVerifyKit.m110b(this.f157f.get(str), str2));
            this.f158g.put(str, Integer.valueOf(i));
            return this;
        }

        public Builder addMatchProperty(String str) {
            if (TextUtils.isEmpty(str)) {
                C0577b.f170b.mo12804a("ServiceVerifyKit", "error input propertyName");
            } else {
                this.f165n = str;
            }
            return this;
        }

        public String genVerifiedPackageName() {
            ServiceVerifyKit serviceVerifyKit = new ServiceVerifyKit();
            Context unused = serviceVerifyKit.f136a = this.f159h;
            String unused2 = serviceVerifyKit.f138c = this.f153b;
            String unused3 = serviceVerifyKit.f139d = this.f154c;
            String unused4 = serviceVerifyKit.f137b = this.f152a;
            serviceVerifyKit.f142g.putAll(this.f157f);
            serviceVerifyKit.f143h.putAll(this.f158g);
            int unused5 = serviceVerifyKit.f144i = this.f160i;
            String unused6 = serviceVerifyKit.f147l = this.f164m;
            String unused7 = serviceVerifyKit.f148m = this.f165n;
            Intent unused8 = serviceVerifyKit.f150o = this.f162k;
            ComponentType unused9 = serviceVerifyKit.f151p = this.f163l;
            String unused10 = serviceVerifyKit.f141f = this.f156e;
            String unused11 = serviceVerifyKit.f140e = this.f155d;
            return serviceVerifyKit.m96a();
        }

        public Builder setCN(String str) {
            if (TextUtils.isEmpty(str)) {
                C0577b.f170b.mo12804a("ServiceVerifyKit", "error input CN");
            } else {
                this.f153b = str;
            }
            return this;
        }

        public Builder setCertChainKey(String str) {
            if (TextUtils.isEmpty(str)) {
                C0577b.f170b.mo12804a("ServiceVerifyKit", "error input chain key");
            } else {
                this.f156e = str;
            }
            return this;
        }

        public Builder setCertSignerKey(String str) {
            if (TextUtils.isEmpty(str)) {
                C0577b.f170b.mo12804a("ServiceVerifyKit", "error input signer key");
            } else {
                this.f155d = str;
            }
            return this;
        }

        public Builder setContext(Context context) {
            this.f159h = context.getApplicationContext();
            return this;
        }

        public Builder setFlag(int i) {
            this.f160i = i;
            return this;
        }

        public Builder setMatchMetaDataKey(String str) {
            if (TextUtils.isEmpty(str)) {
                C0577b.f170b.mo12804a("ServiceVerifyKit", "error input propertyKey");
            } else {
                this.f164m = str;
            }
            return this;
        }

        public Builder setOU(String str) {
            if (TextUtils.isEmpty(str)) {
                C0577b.f170b.mo12804a("ServiceVerifyKit", "error input OU");
            } else {
                this.f154c = str;
            }
            return this;
        }

        public Builder setServiceName(String str) {
            this.f152a = str;
            return this;
        }

        public Builder setTargetComponent(Intent intent, ComponentType componentType) {
            if (intent == null) {
                C0577b.f170b.mo12804a("ServiceVerifyKit", "error input intent");
            } else {
                this.f162k = intent;
            }
            if (componentType == null) {
                C0577b.f170b.mo12804a("ServiceVerifyKit", "error input type");
            } else {
                this.f163l = componentType;
            }
            return this;
        }
    }

    private ServiceVerifyKit() {
        this.f142g = new HashMap();
        this.f143h = new HashMap();
        this.f145j = 0;
        this.f146k = 0;
    }

    /* renamed from: a */
    private int m90a(Bundle bundle, String str) {
        if (bundle.containsKey(this.f147l)) {
            return bundle.getString(this.f147l).equalsIgnoreCase(str) ? 1 : -1;
        }
        return 0;
    }

    /* renamed from: a */
    private C0571a m94a(PackageInfo packageInfo, String str, String str2, int i) {
        C0577b bVar;
        StringBuilder sb;
        String str3;
        Bundle bundle = packageInfo.applicationInfo.metaData;
        if (bundle == null) {
            bVar = C0577b.f170b;
            sb = new StringBuilder();
            sb.append("skip package ");
            sb.append(str2);
            str2 = " for metadata is null";
        } else {
            int a = m90a(bundle, this.f149n);
            if (bundle.containsKey(this.f140e) || bundle.containsKey(this.f141f)) {
                if (!m103a(bundle, str2, str)) {
                    bVar = C0577b.f170b;
                    sb = new StringBuilder();
                    str3 = "checkSinger failed, packageName is ";
                } else {
                    this.f145j = i;
                    return new C0571a(str2, this.f145j, this.f146k, a);
                }
            } else if (m104a(str2, str)) {
                this.f146k = 1;
                this.f145j = this.f143h.get(str2).intValue();
                return new C0571a(str2, this.f145j, this.f146k, a);
            } else {
                bVar = C0577b.f170b;
                sb = new StringBuilder();
                str3 = "Legacy is false, packageName is ";
            }
            sb.append(str3);
        }
        sb.append(str2);
        bVar.mo12804a("ServiceVerifyKit", sb.toString());
        return null;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public String m96a() {
        StringBuilder sb;
        String str;
        C0577b bVar;
        PackageManager packageManager = this.f136a.getPackageManager();
        List<ResolveInfo> a = m101a(packageManager);
        if (a.size() == 0) {
            return null;
        }
        this.f149n = TextUtils.isEmpty(this.f148m) ? Build.MANUFACTURER : m100a(this.f148m);
        ArrayList arrayList = new ArrayList();
        int i = this.f144i | 128 | 64;
        for (ResolveInfo next : a) {
            String a2 = m97a(next);
            try {
                PackageInfo packageInfo = packageManager.getPackageInfo(a2, i);
                if (packageInfo.applicationInfo == null) {
                    bVar = C0577b.f170b;
                    sb = new StringBuilder();
                    sb.append("skip package ");
                    sb.append(a2);
                    str = " for ApplicationInfo is null";
                } else {
                    Signature[] signatureArr = packageInfo.signatures;
                    if (signatureArr == null || signatureArr.length <= 0) {
                        bVar = C0577b.f170b;
                        sb = new StringBuilder();
                        sb.append("skip package ");
                        sb.append(a2);
                        str = " for no sign";
                    } else {
                        byte[] byteArray = signatureArr[0].toByteArray();
                        if (byteArray.length == 0) {
                            bVar = C0577b.f170b;
                            sb = new StringBuilder();
                            sb.append("skip package ");
                            sb.append(a2);
                            str = " for sign is empty";
                        } else {
                            try {
                                C0571a a3 = m94a(packageInfo, C0574b.m122b(MessageDigest.getInstance("SHA-256").digest(byteArray), true), a2, next.priority);
                                if (a3 != null) {
                                    arrayList.add(a3);
                                }
                            } catch (NoSuchAlgorithmException unused) {
                                bVar = C0577b.f170b;
                                sb = new StringBuilder();
                                sb.append("skip package ");
                                sb.append(a2);
                                str = " for AlgorithmException";
                            }
                        }
                    }
                }
            } catch (PackageManager.NameNotFoundException unused2) {
                bVar = C0577b.f170b;
                sb = new StringBuilder();
                sb.append("skip package ");
                sb.append(a2);
                str = " for PackageInfo is null";
            }
            sb.append(str);
            bVar.mo12804a("ServiceVerifyKit", sb.toString());
        }
        return m108b((List<C0571a>) arrayList);
    }

    /* renamed from: a */
    private String m97a(ResolveInfo resolveInfo) {
        Builder.ComponentType componentType = this.f151p;
        return ((componentType == Builder.ComponentType.ACTIVITY || componentType == Builder.ComponentType.BROADCAST) ? resolveInfo.activityInfo.applicationInfo : resolveInfo.serviceInfo.applicationInfo).packageName;
    }

    /* renamed from: a */
    public static String m100a(String str) {
        C0577b bVar;
        String str2;
        try {
            return (String) Class.forName("android.os.SystemProperties").getMethod("get", new Class[]{String.class}).invoke((Object) null, new Object[]{str});
        } catch (ClassNotFoundException unused) {
            bVar = C0577b.f170b;
            str2 = "getSystemProperties ClassNotFoundException";
            bVar.mo12804a("ServiceVerifyKit", str2);
            return "";
        } catch (Exception unused2) {
            bVar = C0577b.f170b;
            str2 = "getSystemProperties Exception while getting system property";
            bVar.mo12804a("ServiceVerifyKit", str2);
            return "";
        }
    }

    /* renamed from: a */
    private List<ResolveInfo> m101a(PackageManager packageManager) {
        Intent intent;
        Builder.ComponentType componentType = this.f151p;
        if (componentType == null) {
            intent = new Intent(this.f137b);
        } else if (componentType == Builder.ComponentType.ACTIVITY) {
            return packageManager.queryIntentActivities(this.f150o, this.f144i);
        } else {
            if (componentType == Builder.ComponentType.BROADCAST) {
                return packageManager.queryBroadcastReceivers(this.f150o, this.f144i);
            }
            intent = this.f150o;
        }
        return packageManager.queryIntentServices(intent, this.f144i);
    }

    /* renamed from: a */
    private List<C0571a> m102a(List<C0571a> list) {
        ArrayList arrayList = new ArrayList();
        for (C0571a next : list) {
            if (next.mo12787a() == 0) {
                arrayList.add(next);
            }
        }
        return !arrayList.isEmpty() ? arrayList : list;
    }

    /* renamed from: a */
    private boolean m103a(Bundle bundle, String str, String str2) {
        C0577b bVar;
        String str3;
        if (!bundle.containsKey(this.f140e) || !bundle.containsKey(this.f141f)) {
            bVar = C0577b.f170b;
            str3 = "skip package " + str + " for no signer or no certChain";
        } else {
            if (m105a(str + ContainerUtils.FIELD_DELIMITER + str2, bundle.getString(this.f140e), bundle.getString(this.f141f))) {
                return true;
            }
            bVar = C0577b.f170b;
            str3 = "checkSinger failed";
        }
        bVar.mo12804a("ServiceVerifyKit", str3);
        return false;
    }

    /* renamed from: a */
    private boolean m104a(String str, String str2) {
        String[] strArr;
        if (this.f142g.containsKey(str) && (strArr = this.f142g.get(str)) != null) {
            for (String equals : strArr) {
                if (str2.equals(equals)) {
                    return true;
                }
            }
        }
        return false;
    }

    /* renamed from: a */
    private boolean m105a(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
            C0577b.f170b.mo12804a("ServiceVerifyKit", "args is invalid");
            return false;
        }
        List<X509Certificate> b = C0575c.m133b(str3);
        if (b.size() == 0) {
            C0577b.f170b.mo12804a("ServiceVerifyKit", "certChain is empty");
            return false;
        } else if (!C0575c.m130a(C0575c.m124a(this.f136a), b)) {
            C0577b.f170b.mo12804a("ServiceVerifyKit", "failed to verify cert chain");
            return false;
        } else {
            X509Certificate x509Certificate = b.get(0);
            if (!C0575c.m128a(x509Certificate, this.f138c)) {
                C0577b.f170b.mo12804a("ServiceVerifyKit", "CN is invalid");
                return false;
            } else if (!C0575c.m135b(x509Certificate, this.f139d)) {
                C0577b.f170b.mo12804a("ServiceVerifyKit", "OU is invalid");
                return false;
            } else {
                byte[] bArr = null;
                try {
                    bArr = str.getBytes(Key.STRING_CHARSET_NAME);
                } catch (UnsupportedEncodingException e) {
                    C0577b.f170b.mo12805a("ServiceVerifyKit", "checkCertChain UnsupportedEncodingException:", e);
                }
                if (C0575c.m131a(x509Certificate, bArr, C0573a.m118a(str2))) {
                    return true;
                }
                C0577b bVar = C0577b.f170b;
                bVar.mo12804a("ServiceVerifyKit", "signature is invalid: " + str);
                return false;
            }
        }
    }

    /* renamed from: b */
    private String m108b(List<C0571a> list) {
        List<C0571a> a = m102a(m112c(list));
        String str = "";
        if (a.size() > 0) {
            int i = 0;
            for (C0571a next : a) {
                if (next.mo12790d() >= i) {
                    i = next.mo12790d();
                    str = next.mo12789c();
                }
            }
        }
        return str;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static String[] m110b(String[] strArr, String str) {
        if (strArr == null) {
            return new String[]{str};
        }
        for (String equals : strArr) {
            if (TextUtils.equals(equals, str)) {
                return strArr;
            }
        }
        String[] strArr2 = new String[(r1 + 1)];
        System.arraycopy(strArr, 0, strArr2, 0, r1);
        strArr2[r1] = str;
        return strArr2;
    }

    /* renamed from: c */
    private List<C0571a> m112c(List<C0571a> list) {
        ArrayList arrayList = new ArrayList();
        for (C0571a next : list) {
            if (next.mo12788b() > -1) {
                arrayList.add(next);
            }
        }
        return !arrayList.isEmpty() ? arrayList : list;
    }
}
