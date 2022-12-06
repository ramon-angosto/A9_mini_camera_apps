package ms.bd.o.Pgl;

import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import java.util.HashMap;
import java.util.Map;

public class c {
    public static final int CLIENT_TYPE_BUSINESS = 1;
    public static final int CLIENT_TYPE_INHOUSE = 0;
    public static final int CLIENT_TYPE_UNKNOWN = -1;
    public static final int COLLECT_MODE_DEFAULT = 99999;
    public static final int COLLECT_MODE_FINANCE = 300;
    public static final int COLLECT_MODE_HELO = 315;
    public static final int COLLECT_MODE_MINIMIZE = 5;
    public static final int COLLECT_MODE_ML_MINIMIZE = 290;
    public static final int COLLECT_MODE_ML_PGL_AL = 810;
    public static final int COLLECT_MODE_ML_TEEN = 280;
    public static final int COLLECT_MODE_OV_MINIMIZE = 5;
    public static final int COLLECT_MODE_RESSO = 315;
    public static final int COLLECT_MODE_TIKTOK = 503;
    public static final int COLLECT_MODE_TIKTOKLITE = 330;
    public static final int COLLECT_MODE_TIKTOK_BASE = 10;
    public static final int COLLECT_MODE_TIKTOK_GUEST = 504;
    public static final int COLLECT_MODE_TIKTOK_INIT = 5;
    public static final int COLLECT_MODE_TIKTOK_NONUSEA = 603;
    public static final int COLLECT_MODE_TIKTOK_U13 = 10;
    public static final int COLLECT_MODE_TIKTOK_USEA = 503;
    public static final int COLLECT_MODE_TIKTOK_USUNREGISTER = 10;
    public static final int OVREGION_TYPE_SG = 0;
    public static final int OVREGION_TYPE_UNKNOWN = -1;
    public static final int OVREGION_TYPE_VA = 1;
    protected String a = "";
    protected String b = "";
    protected String c = "";
    protected String d = "";
    protected String e = "";
    protected String f = "";
    protected String g = "";
    protected String h = "";
    protected String i = "";
    protected int j = -1;
    protected int k = -1;
    protected int l = COLLECT_MODE_DEFAULT;
    protected Map<String, String> m = new HashMap();
    protected Map<String, String> n = new HashMap();

    public interface pblb {
    }

    public static abstract class pgla<T extends pblb> extends c implements pblb {
        public pgla(String str, String str2) {
            this(str, str2, (int) c.COLLECT_MODE_DEFAULT);
        }

        public pgla(String str, String str2, int i) {
            this.a = str;
            this.i = str2;
            this.l = i;
            if (TextUtils.isEmpty(str) || MBridgeConstans.ENDCARD_URL_TYPE_PL.equals(str) || TextUtils.isEmpty(str2)) {
                throw new IllegalArgumentException("appID or license must be set.");
            }
        }

        public pgla(String str, String str2, String str3) {
            this(str, str2, str3, c.COLLECT_MODE_DEFAULT);
        }

        public pgla(String str, String str2, String str3, int i) {
            this.g = str;
            this.h = str2;
            this.i = str3;
            this.l = i;
            if (TextUtils.isEmpty(str) || MBridgeConstans.ENDCARD_URL_TYPE_PL.equals(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
                throw new IllegalArgumentException("sdkID or license must be set.");
            }
        }

        /* access modifiers changed from: protected */
        public c a() {
            if (this.j != -1) {
                return this;
            }
            throw new IllegalArgumentException("MSConfig init error");
        }

        public T addAdvanceInfo0(String str, String str2) {
            this.n.put(str, str2);
            return this;
        }

        public T setBDDeviceID0(String str) {
            this.d = str;
            return this;
        }

        public T setChannel0(String str) {
            this.b = str;
            return this;
        }

        public T setClientType0(int i) {
            this.j = i;
            return this;
        }

        public T setCustomInfo0(Map<String, String> map) {
            if (map == null) {
                map = new HashMap<>();
            }
            this.m = map;
            return this;
        }

        public T setDeviceID0(String str) {
            this.c = str;
            return this;
        }

        public T setInstallID0(String str) {
            this.e = str;
            return this;
        }

        public T setOVRegionType0(int i) {
            this.k = i;
            return this;
        }

        public T setSecssionID0(String str) {
            this.f = str;
            return this;
        }
    }

    protected c() {
    }

    /* access modifiers changed from: package-private */
    public String a(Object obj) {
        return (obj == null || !(obj instanceof String)) ? "" : ((String) obj).trim();
    }
}
