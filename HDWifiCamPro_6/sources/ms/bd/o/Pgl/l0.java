package ms.bd.o.Pgl;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import ms.bd.o.Pgl.pblb;
import org.json.JSONArray;

public class l0 {
    private static volatile boolean a;
    private static final Map<String, c> b = new ConcurrentHashMap();

    public interface pgla {
        Map<String, String> frameSign(String str, int i);

        Map<String, String> getFeatureHash(String str, byte[] bArr);

        Map<String, String> getReportRaw(String str, int i, Map<String, String> map);

        String getToken();

        void report(String str);

        void setBDDeviceID(String str);

        void setCollectMode(int i);

        void setDeviceID(String str);

        void setInstallID(String str);

        void setSessionID(String str);
    }

    public static String a() {
        return (String) pblb.a(67108867);
    }

    public static synchronized pgla a(String str) {
        synchronized (l0.class) {
            if (str == null) {
                throw new NullPointerException((String) pblk.a(16777217, 0, 0, "50af32", new byte[]{37, 34, 2, 59, 40, 101, 59, 4, 35, 34, 100, 48, 23, 82, 31, 32, 34}));
            } else if (!a) {
                return null;
            } else {
                Object a2 = pblb.a(67108866, str);
                if (a2 == null) {
                    return null;
                }
                c cVar = b.get(str);
                if (cVar == null) {
                    return null;
                }
                k0 k0Var = new k0(cVar, pgla.a().b(), ((Long) a2).longValue());
                return k0Var;
            }
        }
    }

    public static synchronized boolean a(Context context, c cVar, String str, String str2) {
        c cVar2 = cVar;
        synchronized (l0.class) {
            if (context == null) {
                throw new NullPointerException((String) pblk.a(16777217, 0, 0, "c3c598", new byte[]{113, 62, 30, 85, 3, 55, 116, 82, 49, 106, 103, 61, 20, 1, 8, 32, 116, 82, 48, 96, 50, 63, 5, 77, 10}));
            } else if (cVar2 != null) {
                String str3 = cVar2.a;
                String str4 = (str3 == null || str3.length() <= 0) ? cVar2.g : cVar2.a;
                if (str4 == null || str4.length() <= 0) {
                    throw new NullPointerException((String) pblk.a(16777217, 0, 0, "8b4cf5", new byte[]{40, 112, 87, 62, 125, 98, 54, 86, 118, 39, 105, 98, 66, 87, 74, 39, 47}));
                }
                synchronized (l0.class) {
                    if (!a) {
                        Context applicationContext = context.getApplicationContext();
                        pgla.a().a(applicationContext);
                        try {
                            pblu.a(applicationContext, str2);
                        } catch (Throwable unused) {
                        }
                        pblu.a(applicationContext, str);
                        String str5 = (String) pblk.a(16777217, 0, 0, "ac6ae2", new byte[]{62, 108, 86});
                        pblb.a(16777218, (pblb.pgla) new n());
                        pblb.a(16777217, (pblb.pgla) new y());
                        String str6 = (String) pblk.a(16777217, 0, 0, "48316a", new byte[]{107, 55, 68});
                        pblb.a(16777219, (pblb.pgla) new d0());
                        pblb.a(16777221, (pblb.pgla) new e0());
                        pblb.a(16777222, (pblb.pgla) new f0());
                        pblb.a(16777223, (pblb.pgla) new g0());
                        pblb.a(16777224, (pblb.pgla) new h0());
                        pblb.a(16777225, (pblb.pgla) new i0());
                        pblb.a(16777226, (pblb.pgla) new j0());
                        pblb.a(16777228, (pblb.pgla) new d());
                        pblb.a((int) InputDeviceCompat.SOURCE_JOYSTICK, (pblb.pgla) new e());
                        pblb.a(16777233, (pblb.pgla) new f());
                        pblb.a(16777235, (pblb.pgla) new g());
                        pblb.a(16777238, (pblb.pgla) new h());
                        pblb.a(16777239, (pblb.pgla) new i());
                        pblb.a(16777241, (pblb.pgla) new j());
                        pblb.a(16777242, (pblb.pgla) new k());
                        pblb.a(16777243, (pblb.pgla) new l());
                        pblb.a(16777244, (pblb.pgla) new m());
                        pblb.a(16777245, (pblb.pgla) new o());
                        pblb.a(16777246, (pblb.pgla) new p());
                        pblb.a(16777247, (pblb.pgla) new q());
                        pblb.a(16777248, (pblb.pgla) new r());
                        pblb.a(16777249, (pblb.pgla) new s());
                        pblb.a(16777250, (pblb.pgla) new t());
                        pblb.a(16777251, (pblb.pgla) new u());
                        pblb.a(16777240, (pblb.pgla) new v());
                        pblb.a(16777252, (pblb.pgla) new w());
                        pblb.a(16777253, (pblb.pgla) new x());
                        pblb.a(16777254, (pblb.pgla) new z());
                        pblb.a(16777255, (pblb.pgla) new a0());
                        pblb.a(16777256, (pblb.pgla) new b0());
                        pblb.a(16777257, (pblb.pgla) new c0());
                        pblb.a((int) InputDeviceCompat.SOURCE_HDMI, pbly.b() ? new p0() : new n0());
                        pblb.a(33554434, (pblb.pgla) new q0());
                        pblj.a();
                        com.bytedance.mobsec.metasec.ov.pgla.a();
                        pblk.a(16777219, 0, 0, (String) null, applicationContext);
                        pblk.a(16777220, 0, 0, (String) null, (Object) null);
                        a = true;
                    }
                }
                if (b.containsKey(str4)) {
                    return false;
                }
                JSONArray jSONArray = new JSONArray();
                jSONArray.put(cVar2.a(cVar2.a));
                jSONArray.put(cVar2.a(cVar2.h));
                jSONArray.put(cVar2.a(cVar2.g));
                jSONArray.put(cVar2.a(cVar2.i));
                jSONArray.put(cVar2.a(x0.a()));
                jSONArray.put(cVar2.a(cVar2.b));
                jSONArray.put(cVar2.a(cVar2.c));
                jSONArray.put(cVar2.a(cVar2.d));
                jSONArray.put(cVar2.a(cVar2.e));
                jSONArray.put(cVar2.a(cVar2.f));
                jSONArray.put(String.valueOf(cVar2.j));
                jSONArray.put(String.valueOf(cVar2.k));
                jSONArray.put(String.valueOf(cVar2.l));
                JSONArray jSONArray2 = new JSONArray();
                for (Map.Entry next : cVar2.m.entrySet()) {
                    if (!TextUtils.isEmpty((CharSequence) next.getKey())) {
                        jSONArray2.put(cVar2.a(next.getKey()));
                        jSONArray2.put(cVar2.a(next.getValue()));
                    }
                }
                jSONArray.put(jSONArray2);
                JSONArray jSONArray3 = new JSONArray();
                for (Map.Entry next2 : cVar2.n.entrySet()) {
                    if (!TextUtils.isEmpty((CharSequence) next2.getKey())) {
                        jSONArray3.put(cVar2.a(next2.getKey()));
                        jSONArray3.put(cVar2.a(next2.getValue()));
                    }
                }
                jSONArray.put(jSONArray3);
                if (!((Boolean) pblb.a(67108865, jSONArray.toString())).booleanValue()) {
                    return false;
                }
                b.put(str4, cVar2);
                return true;
            } else {
                throw new NullPointerException((String) pblk.a(16777217, 0, 0, "c20a0c", new byte[]{113, 63, 77, 19, 6, 115, 32, 16, 110, 36, 126, 52, 3, 27, 0, 96, 32, 17, 100, 113, 124, 37, 79, 25}));
            }
        }
    }
}
