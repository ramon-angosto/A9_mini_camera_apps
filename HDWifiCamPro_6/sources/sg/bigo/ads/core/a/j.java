package sg.bigo.ads.core.a;

import android.util.SparseArray;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSchemeDataSource;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;
import sg.bigo.ads.common.f;
import sg.bigo.ads.common.f.c;
import sg.bigo.ads.common.utils.m;
import sg.bigo.ads.common.utils.o;

public final class j {
    /* access modifiers changed from: private */
    public static final long c = TimeUnit.SECONDS.toMillis(15);
    int a = 0;
    /* access modifiers changed from: private */
    public i b;
    private final f d;
    /* access modifiers changed from: private */
    public final SparseArray<Map<String, Long>> e = new SparseArray<>(3);

    public static class a implements Runnable {
        private final WeakReference<j> a;
        private final String b;
        private final long c;
        private final int d;
        private final int e;

        public a(j jVar, String str, long j, int i, int i2) {
            this.a = new WeakReference<>(jVar);
            this.b = str;
            this.c = j;
            this.d = i;
            this.e = i2;
        }

        public final void run() {
            j jVar = (j) this.a.get();
            if (jVar != null) {
                j.a(jVar, this.b, this.c, this.d, this.e);
            }
        }
    }

    public j(i iVar, f fVar) {
        this.d = fVar;
        this.b = iVar;
    }

    static /* synthetic */ void a(j jVar, String str, int i) {
        if (!o.b(str)) {
            synchronized (jVar.e) {
                Map map = jVar.e.get(i);
                if (map != null) {
                    map.remove(str);
                }
            }
        }
    }

    static /* synthetic */ void a(j jVar, String str, long j, int i, int i2) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject.putOpt("tgt_pkg_name", str);
            jSONObject.putOpt("install_time", Long.valueOf(j));
            jSONObject2.putOpt("inst_type", String.valueOf(i2));
            jSONObject.putOpt("log_extra", jSONObject2);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        String jSONObject3 = jSONObject.toString();
        if (!o.b(jSONObject3)) {
            String a2 = m.a(jSONObject3, jVar.b.d());
            sg.bigo.ads.common.k.a.a("encrption clearData: ", a2);
            sg.bigo.ads.common.k.a.a("after decryption clearData: ", m.b(a2, jVar.b.d()));
            sg.bigo.ads.common.k.a.a("clearData key:", jVar.b.d());
            if (!o.b(a2)) {
                HashMap hashMap = new HashMap();
                hashMap.put("cur_index", Integer.valueOf(jVar.b.c()));
                hashMap.put(DataSchemeDataSource.SCHEME_DATA, a2);
                final String str2 = str;
                final long j2 = j;
                final int i3 = i2;
                final int i4 = i;
                jVar.d.a(hashMap, new f.a() {
                    public final void a(int i, int i2, String str) {
                        sg.bigo.ads.common.k.a.a(0, 3, "BigoAdInsR", str2 + ":" + j2 + ", error. code=" + i + ", subCode=" + i2 + ", msg=" + str);
                        if (i2 == 3000 || i2 == 2000) {
                            sg.bigo.ads.common.k.a.a(0, "BigoAdInsR", "code:" + i + ", subCode=" + i2 + ", msg:" + str);
                            j.a(j.this, str2, i3);
                        } else if (i2 == -8) {
                            j.this.b.e();
                            sg.bigo.ads.common.k.a.a(0, "BigoAdInsR", "code:" + i + ", subCode=" + i2 + ", msg:" + str);
                            j.a(j.this, str2, i3);
                        } else if (((long) i4) >= 2) {
                            sg.bigo.ads.common.k.a.a(0, "BigoAdInsR", "report times(" + i4 + ") >= 2, return.");
                            j.a(j.this, str2, i3);
                        } else {
                            sg.bigo.ads.common.k.a.a(0, 3, "BigoAdInsR", "report retry, current times=" + i4);
                            c.a(1, new a(j.this, str2, j2, i4 + 1, i3), j.c);
                        }
                    }

                    public final void a(String str) {
                        sg.bigo.ads.common.k.a.a(0, 3, "BigoAdInsR", str2 + ":" + j2 + ", ok.");
                        j.a(j.this, str2, i3);
                        if (!o.b(str)) {
                            String b2 = m.b(str, j.this.b.d());
                            if (!o.b(b2)) {
                                try {
                                    sg.bigo.ads.common.k.a.a(0, 3, "BigoAdInsR", "Response data after sdk_report: ".concat(String.valueOf(b2)));
                                    JSONObject jSONObject = new JSONObject(b2);
                                    j.this.b.a(jSONObject.optInt("next_index"), jSONObject.optString("next_key"));
                                } catch (JSONException e2) {
                                    e2.printStackTrace();
                                }
                            }
                        }
                    }
                });
            }
        }
    }

    public final void a(int i, String str, long j) {
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    sg.bigo.ads.common.k.a.a(0, 3, "BigoAdInsR", "report disable, pkgName=" + str + ", unSupport installType=" + i);
                    return;
                } else if ((this.a & 4) != 4) {
                    sg.bigo.ads.common.k.a.a(0, 3, "BigoAdInsR", "report replace disable, pkgName=".concat(String.valueOf(str)));
                    return;
                }
            } else if ((this.a & 2) != 2) {
                sg.bigo.ads.common.k.a.a(0, 3, "BigoAdInsR", "report remove disable, pkgName=".concat(String.valueOf(str)));
                return;
            }
        } else if ((this.a & 1) != 1) {
            sg.bigo.ads.common.k.a.a(0, 3, "BigoAdInsR", "report install disable, pkgName=".concat(String.valueOf(str)));
            return;
        }
        final String str2 = str;
        final int i2 = i;
        final long j2 = j;
        c.a(1, new Runnable() {
            public final void run() {
                if (!o.b(str2)) {
                    synchronized (j.this.e) {
                        Map map = (Map) j.this.e.get(i2);
                        if (map == null || !map.containsKey(str2)) {
                            if (map == null) {
                                map = new HashMap();
                                j.this.e.put(i2, map);
                            }
                            map.put(str2, Long.valueOf(j2));
                            j.a(j.this, str2, j2, 0, i2);
                        }
                    }
                }
            }
        });
    }

    public final boolean a() {
        return (this.a & 7) != 0;
    }
}
