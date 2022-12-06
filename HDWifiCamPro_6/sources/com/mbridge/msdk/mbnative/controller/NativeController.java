package com.mbridge.msdk.mbnative.controller;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.room.RoomMasterTable;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.db.i;
import com.mbridge.msdk.foundation.db.p;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.CampaignUnit;
import com.mbridge.msdk.foundation.entity.j;
import com.mbridge.msdk.foundation.entity.m;
import com.mbridge.msdk.foundation.same.e.a;
import com.mbridge.msdk.foundation.tools.SameMD5;
import com.mbridge.msdk.foundation.tools.l;
import com.mbridge.msdk.foundation.tools.o;
import com.mbridge.msdk.foundation.tools.q;
import com.mbridge.msdk.foundation.tools.u;
import com.mbridge.msdk.mbnative.controller.a;
import com.mbridge.msdk.out.Campaign;
import com.mbridge.msdk.out.Frame;
import com.mbridge.msdk.out.NativeListener;
import com.mbridge.msdk.out.OnImageLoadListener;
import com.mbridge.msdk.playercommon.exoplayer2.source.chunk.ChunkedTrackBlacklistUtil;
import com.mbridge.msdk.videocommon.download.g;
import com.mbridge.msdk.videocommon.download.k;
import com.vungle.warren.model.AdvertisementDBAdapter;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class NativeController {
    /* access modifiers changed from: private */
    public static boolean A;
    public static Map<String, Long> c = new HashMap();
    /* access modifiers changed from: private */
    public static final String e = NativeController.class.getSimpleName();
    private int B = 0;
    private int C = 0;
    private int D = 0;
    private int E = 0;
    private com.mbridge.msdk.foundation.same.e.b F;
    private List<a> G;
    private List<a.C0066a> H;
    /* access modifiers changed from: private */
    public CopyOnWriteArrayList<com.mbridge.msdk.foundation.same.e.a> I = new CopyOnWriteArrayList<>();
    private int J = 1;
    private int K = 2;
    private a L;
    private boolean M;
    private boolean N;
    private Timer O;
    /* access modifiers changed from: private */
    public String P = "";
    /* access modifiers changed from: private */
    public String Q = "";
    private com.mbridge.msdk.b.d R;
    private long S;
    /* access modifiers changed from: private */
    public int T;
    private int U;
    /* access modifiers changed from: private */
    public boolean V;
    /* access modifiers changed from: private */
    public int W;
    /* access modifiers changed from: private */
    public int X;
    private boolean Y;
    protected List<Integer> a;
    protected List<Integer> b;
    Map<String, Object> d;
    private com.mbridge.msdk.b.c f;
    /* access modifiers changed from: private */
    public com.mbridge.msdk.mbnative.c.a g;
    private NativeListener.NativeTrackingListener h;
    /* access modifiers changed from: private */
    public Context i;
    /* access modifiers changed from: private */
    public String j;
    private String k;
    private Queue<Integer> l;
    private Queue<Long> m;
    private String n;
    /* access modifiers changed from: private */
    public e o;
    /* access modifiers changed from: private */
    public com.mbridge.msdk.foundation.same.report.c p;
    /* access modifiers changed from: private */
    public String q;
    /* access modifiers changed from: private */
    public com.mbridge.msdk.click.a r;
    private int s = 1;
    /* access modifiers changed from: private */
    public int t = 1;
    /* access modifiers changed from: private */
    public int u = -1;
    /* access modifiers changed from: private */
    public int v = 0;
    private String w;
    /* access modifiers changed from: private */
    public boolean x = false;
    /* access modifiers changed from: private */
    public boolean y = false;
    private boolean z = false;

    public interface b {
        void a();
    }

    private static class e extends Handler {
        private WeakReference<NativeController> a;

        public e(NativeController nativeController) {
            this.a = new WeakReference<>(nativeController);
        }

        public final void handleMessage(Message message) {
            NativeController nativeController;
            super.handleMessage(message);
            try {
                if (!(message.what != 0 || this.a == null || (nativeController = (NativeController) this.a.get()) == null)) {
                    nativeController.p.a(message.arg1, (String) message.obj);
                }
                if (message.what == 1) {
                    NativeController nativeController2 = null;
                    if (!(this.a == null || this.a.get() == null)) {
                        nativeController2 = (NativeController) this.a.get();
                    }
                    if (nativeController2 != null) {
                        boolean unused = nativeController2.y = true;
                        List<Campaign> b = nativeController2.b(nativeController2.j, nativeController2.t, nativeController2.P);
                        if (!nativeController2.x) {
                            boolean unused2 = nativeController2.a(b);
                        }
                    }
                }
            } catch (Exception e) {
                q.d(NativeController.e, com.mbridge.msdk.mbnative.b.a.a(e));
            }
        }
    }

    public NativeController(com.mbridge.msdk.mbnative.c.a aVar, NativeListener.NativeTrackingListener nativeTrackingListener, Map<String, Object> map, Context context) {
        List list;
        com.mbridge.msdk.mbnative.a.b<String, List<Campaign>> a2;
        this.i = context;
        this.d = map;
        this.f = new com.mbridge.msdk.b.c();
        this.g = aVar;
        this.h = nativeTrackingListener;
        this.G = new ArrayList();
        this.H = new ArrayList();
        this.j = (String) map.get(MBridgeConstans.PROPERTIES_UNIT_ID);
        if (!TextUtils.isEmpty(this.j)) {
            if (!map.containsKey(MBridgeConstans.PLACEMENT_ID) || map.get(MBridgeConstans.PLACEMENT_ID) == null) {
                this.k = "";
            } else {
                this.k = (String) map.get(MBridgeConstans.PLACEMENT_ID);
            }
            if (map.containsKey(MBridgeConstans.PREIMAGE)) {
                A = ((Boolean) map.get(MBridgeConstans.PREIMAGE)).booleanValue();
            }
            this.l = new LinkedList();
            this.m = new LinkedList();
            this.F = new com.mbridge.msdk.foundation.same.e.b(this.i);
            if (Looper.myLooper() == null) {
                Looper.prepare();
            }
            this.o = new e(this);
            if (map.containsKey(MBridgeConstans.PROPERTIES_API_REUQEST_CATEGORY)) {
                this.w = (String) map.get(MBridgeConstans.PROPERTIES_API_REUQEST_CATEGORY);
            }
            try {
                if (!(b.b().containsKey(this.j) ? b.b().get(this.j).booleanValue() : false)) {
                    if (map.containsKey("ad_num")) {
                        int intValue = ((Integer) map.get("ad_num")).intValue();
                        intValue = intValue < 1 ? 1 : intValue;
                        intValue = intValue > 10 ? 10 : intValue;
                        this.t = intValue;
                        this.s = intValue;
                    }
                    if (map.containsKey(MBridgeConstans.PROPERTIES_AD_FRAME_NUM)) {
                        this.D = ((Integer) map.get(MBridgeConstans.PROPERTIES_AD_FRAME_NUM)).intValue();
                    }
                } else if (b.d().containsKey(this.j)) {
                    this.t = b.d().get(this.j).intValue();
                    if (map.containsKey("ad_num")) {
                        int intValue2 = ((Integer) map.get("ad_num")).intValue();
                        this.B = intValue2;
                        this.s = intValue2;
                    }
                    if (map.containsKey(MBridgeConstans.PROPERTIES_AD_FRAME_NUM)) {
                        int intValue3 = ((Integer) map.get(MBridgeConstans.PROPERTIES_AD_FRAME_NUM)).intValue();
                        this.C = intValue3;
                        this.D = intValue3;
                    }
                }
            } catch (Exception e2) {
                q.d(e, com.mbridge.msdk.mbnative.b.a.a(e2));
            }
            this.p = new com.mbridge.msdk.foundation.same.report.c(this.i);
            this.r = new com.mbridge.msdk.click.a(this.i, this.j);
            try {
                Class.forName("com.mbridge.msdk.nativex.view.MBMediaView");
                Class.forName("com.mbridge.msdk.videocommon.download.c");
                this.N = true;
                if (this.d != null && (this.d.containsKey(MBridgeConstans.NATIVE_VIDEO_WIDTH) || this.d.containsKey(MBridgeConstans.NATIVE_VIDEO_HEIGHT) || map.containsKey(MBridgeConstans.NATIVE_VIDEO_SUPPORT))) {
                    this.M = true;
                }
                c.a(this.i, this.j);
                o.b();
                if (!TextUtils.isEmpty(this.j)) {
                    com.mbridge.msdk.foundation.db.e.a((com.mbridge.msdk.foundation.db.f) com.mbridge.msdk.foundation.db.g.a(this.i)).a();
                    int a3 = a(map.containsKey(MBridgeConstans.NATIVE_INFO) ? (String) map.get(MBridgeConstans.NATIVE_INFO) : null);
                    String str = this.j;
                    a3 = a3 <= 0 ? this.s : a3;
                    this.R = com.mbridge.msdk.b.b.a().e("", str);
                    if (this.R == null) {
                        this.R = com.mbridge.msdk.b.d.d(str);
                    }
                    this.a = this.R.q();
                    if (this.a == null || this.a.size() <= 0 || !this.a.contains(1) || (a2 = com.mbridge.msdk.mbnative.a.c.a(1)) == null) {
                        list = null;
                    } else {
                        list = a2.b(str, a3);
                    }
                    if (list != null) {
                        ArrayList arrayList = new ArrayList();
                        for (int i2 = 0; i2 < list.size(); i2++) {
                            CampaignEx campaignEx = (CampaignEx) list.get(i2);
                            if (!TextUtils.isEmpty(campaignEx.getVideoUrlEncode())) {
                                arrayList.add(campaignEx);
                            }
                        }
                        if (arrayList.size() > 0) {
                            Class<?> cls = Class.forName("com.mbridge.msdk.videocommon.download.c");
                            Class<?> cls2 = Class.forName("com.mbridge.msdk.videocommon.listener.a");
                            Object invoke = cls.getMethod("getInstance", new Class[0]).invoke((Object) null, new Object[0]);
                            cls.getMethod("createUnitCache", new Class[]{Context.class, String.class, List.class, Integer.TYPE, cls2}).invoke(invoke, new Object[]{context, this.j, arrayList, 1, null});
                            cls.getMethod("load", new Class[]{String.class}).invoke(invoke, new Object[]{this.j});
                        }
                    }
                }
            } catch (Throwable unused) {
                q.d(e, "please import the nativex aar");
            }
        }
    }

    public NativeController() {
    }

    private int a(String str) {
        if (str == null) {
            return 0;
        }
        try {
            JSONArray jSONArray = new JSONArray(str);
            if (jSONArray.length() > 0) {
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    JSONObject jSONObject = (JSONObject) jSONArray.opt(i2);
                    if (2 == jSONObject.optInt("id", 0)) {
                        return jSONObject.optInt("ad_num");
                    }
                }
            }
        } catch (Exception e2) {
            q.d(e, com.mbridge.msdk.mbnative.b.a.a(e2));
        }
        return 0;
    }

    public final void a(int i2, String str) {
        String str2;
        this.x = false;
        this.y = false;
        this.z = false;
        this.V = false;
        this.P = str;
        this.g.a(!TextUtils.isEmpty(str));
        String str3 = null;
        this.L = null;
        Map<String, Long> map = c;
        if (map != null && map.size() > 0) {
            c.clear();
        }
        if (!((b.b() == null || !b.b().containsKey(this.j)) ? false : b.b().get(this.j).booleanValue()) || i2 != 1 || !a(i2)) {
            if (!this.d.containsKey("app_id") || !this.d.containsKey(MBridgeConstans.APP_KEY) || !this.d.containsKey(MBridgeConstans.KEY_WORD)) {
                str2 = null;
            } else {
                str3 = (String) this.d.get("app_id");
                str2 = (String) this.d.get(MBridgeConstans.APP_KEY);
            }
            this.f.a(this.i, str3, str2, this.j);
            this.R = com.mbridge.msdk.b.b.a().e(str3, this.j);
            if (this.R == null) {
                this.R = com.mbridge.msdk.b.d.d(this.j);
            }
            b.e().put(this.j, Integer.valueOf(this.R.u() * this.t));
            this.a = this.R.q();
            this.b = this.R.r();
            this.U = this.R.o();
            this.T = this.R.p();
            this.t = this.s;
            List<Integer> list = this.a;
            if (list == null || list.size() == 0) {
                com.mbridge.msdk.mbnative.c.a aVar = this.g;
                if (aVar != null) {
                    this.x = true;
                    aVar.onAdLoadError("don't have sorceList");
                    return;
                }
                return;
            }
            if (this.d.containsKey(MBridgeConstans.NATIVE_INFO) && this.n == null) {
                this.n = (String) this.d.get(MBridgeConstans.NATIVE_INFO);
                try {
                    if (this.n != null) {
                        JSONArray jSONArray = new JSONArray(this.n);
                        if (jSONArray.length() > 0) {
                            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                                JSONObject jSONObject = (JSONObject) jSONArray.opt(i3);
                                int optInt = jSONObject.optInt("id", 0);
                                if (2 == optInt) {
                                    this.W = jSONObject.optInt("ad_num");
                                    if (this.U > 0) {
                                        jSONObject.remove("ad_num");
                                        jSONObject.put("ad_num", this.U);
                                    }
                                } else if (3 == optInt) {
                                    this.X = jSONObject.optInt("ad_num");
                                    if (this.U > 0) {
                                        jSONObject.remove("ad_num");
                                        jSONObject.put("ad_num", this.U);
                                    }
                                }
                            }
                        }
                        this.J = Math.max(this.W, this.X);
                        this.n = jSONArray.toString();
                    }
                } catch (JSONException e2) {
                    q.d(e, com.mbridge.msdk.mbnative.b.a.a(e2));
                }
            }
            if ((this.a.contains(1) && this.a.get(0).intValue() != 1) || i2 != 0 || !a(b(this.j, this.t, this.P))) {
                this.Y = true;
                if (this.a.contains(1) && i2 == 0 && this.a.get(0).intValue() != 1) {
                    int intValue = this.a.get(0).intValue();
                    com.mbridge.msdk.mbnative.a.b<String, List<Campaign>> a2 = com.mbridge.msdk.mbnative.a.c.a(intValue);
                    if (intValue != 2 || !this.d.containsKey(MBridgeConstans.NATIVE_INFO)) {
                        this.t = this.s;
                    } else {
                        this.t = this.J;
                    }
                    if (a2 == null || !a(a(intValue, d(a2.b(this.j, this.t))))) {
                        this.Y = false;
                        try {
                            b(1, (long) (this.b.get(this.a.indexOf(1)).intValue() * 1000), i2, this.P);
                        } catch (Exception unused) {
                        }
                    } else {
                        return;
                    }
                }
                this.o.sendEmptyMessageDelayed(1, (long) (this.R.l() * 1000));
                List<Integer> list2 = this.a;
                if (list2 != null && list2.size() > 0) {
                    Queue<Integer> queue = this.l;
                    if (queue != null && queue.size() > 0) {
                        this.l.clear();
                    }
                    for (Integer next : this.a) {
                        Queue<Integer> queue2 = this.l;
                        if (queue2 != null) {
                            queue2.add(next);
                        }
                    }
                }
                List<Integer> list3 = this.b;
                if (list3 != null && list3.size() > 0) {
                    Queue<Long> queue3 = this.m;
                    if (queue3 != null && queue3.size() > 0) {
                        this.m.clear();
                    }
                    for (Integer next2 : this.b) {
                        Queue<Long> queue4 = this.m;
                        if (queue4 != null) {
                            queue4.add(Long.valueOf((long) (next2.intValue() * 1000)));
                        }
                    }
                }
                b(i2, this.P);
            }
        }
    }

    private boolean a(int i2) {
        int i3;
        int i4;
        int i5;
        com.mbridge.msdk.mbnative.c.a aVar;
        int i6 = 0;
        if (b.b().containsKey(this.j) && b.b().get(this.j).booleanValue()) {
            Map<String, Map<Long, Object>> a2 = b.a();
            Map map = a2.get(i2 + "_" + this.j);
            Integer num = b.d().get(this.j);
            com.mbridge.msdk.b.a b2 = com.mbridge.msdk.b.b.a().b(com.mbridge.msdk.foundation.controller.a.e().h());
            if (num != null) {
                this.t = num.intValue();
            }
            if (map != null && map.size() > 0) {
                Long l2 = (Long) map.keySet().iterator().next();
                long currentTimeMillis = System.currentTimeMillis();
                if (b2 == null) {
                    b2 = com.mbridge.msdk.b.b.a().b();
                }
                if (currentTimeMillis - l2.longValue() >= b2.B() * 1000) {
                    a2.remove(i2 + "_" + this.j);
                } else if (i2 == 1) {
                    List<Frame> list = (List) map.get(l2);
                    if (list == null || list.size() <= 0 || (aVar = this.g) == null) {
                        return false;
                    }
                    if (this.D >= list.size()) {
                        a2.remove(i2 + "_" + this.j);
                        aVar.onAdFramesLoaded(list);
                        return true;
                    } else if (this.D == 0) {
                        return false;
                    } else {
                        List subList = list.subList(0, this.C);
                        aVar.onAdFramesLoaded(list);
                        list.removeAll(subList);
                        map.put(l2, subList);
                        ArrayList arrayList = new ArrayList();
                        for (Frame frame : list) {
                            if (i6 >= this.D) {
                                arrayList.add(frame);
                            }
                            i6++;
                        }
                        map.put(l2, arrayList);
                        a2.put(i2 + "_" + this.j, map);
                        aVar.onAdFramesLoaded(subList);
                        return true;
                    }
                } else {
                    List list2 = (List) map.get(l2);
                    if (list2 != null && list2.size() > 0) {
                        ArrayList arrayList2 = new ArrayList();
                        if (((CampaignEx) list2.get(0)).getType() == 1) {
                            if (TextUtils.isEmpty(this.n)) {
                                i3 = Math.min(this.B, list2.size());
                            } else {
                                try {
                                    JSONArray jSONArray = new JSONArray(this.n);
                                    if (jSONArray.length() > 0) {
                                        i5 = 0;
                                        i4 = 0;
                                        for (int i7 = 0; i7 < jSONArray.length(); i7++) {
                                            JSONObject jSONObject = (JSONObject) jSONArray.opt(i7);
                                            int optInt = jSONObject.optInt("id", 0);
                                            if (2 == optInt) {
                                                i5 = jSONObject.optInt("ad_num");
                                            } else if (3 == optInt) {
                                                i4 = jSONObject.optInt("ad_num");
                                            }
                                        }
                                    } else {
                                        i5 = 0;
                                        i4 = 0;
                                    }
                                    if (3 == ((CampaignEx) list2.get(0)).getTemplate()) {
                                        i3 = Math.min(i4, list2.size());
                                    } else {
                                        i3 = Math.min(i5, list2.size());
                                    }
                                } catch (Exception unused) {
                                    q.d(e, "load from catch error in get nativeinfo adnum");
                                    i3 = 0;
                                }
                            }
                            if (i3 <= 0) {
                                return false;
                            }
                            Iterator it = list2.iterator();
                            while (it.hasNext() && i6 != i3) {
                                CampaignEx campaignEx = (CampaignEx) it.next();
                                campaignEx.getTemplate();
                                arrayList2.add(campaignEx);
                                it.remove();
                                i6++;
                            }
                        } else {
                            int min = Math.min(this.B, list2.size());
                            if (min > 0) {
                                Iterator it2 = list2.iterator();
                                while (it2.hasNext() && i6 != min) {
                                    CampaignEx campaignEx2 = (CampaignEx) it2.next();
                                    campaignEx2.getTemplate();
                                    arrayList2.add(campaignEx2);
                                    it2.remove();
                                    i6++;
                                }
                            }
                        }
                        a((List<Campaign>) arrayList2);
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private void b(int i2, String str) {
        com.mbridge.msdk.mbnative.c.a aVar;
        Queue<Integer> queue = this.l;
        if (queue != null && queue.size() > 0) {
            int intValue = this.l.poll().intValue();
            this.S = (long) MBridgeConstans.REQUEST_TIME_OUT;
            Queue<Long> queue2 = this.m;
            if (queue2 != null && queue2.size() > 0) {
                this.S = this.m.poll().longValue();
            }
            a(intValue, this.S, i2, str);
        } else if (!this.x && (aVar = this.g) != null) {
            this.x = true;
            aVar.onAdLoadError("no ad source");
        }
    }

    private void a(int i2, long j2, int i3, String str) {
        com.mbridge.msdk.mbnative.a.b<String, List<Campaign>> a2;
        if (i3 == 0 && (a2 = com.mbridge.msdk.mbnative.a.c.a(i2)) != null) {
            if ((i2 == 1 || i2 == 2) && this.d.containsKey(MBridgeConstans.NATIVE_INFO)) {
                this.t = this.J;
            } else {
                this.t = this.s;
            }
            if (a(a(i2, d(a2.b(this.j, this.t))))) {
                return;
            }
        }
        if (i2 == 1) {
            b(1, j2, i3, this.P);
        } else if (i2 != 2) {
            b(i2, j2, i3, str);
        } else {
            b(2, j2, i3, str);
        }
    }

    public final void a(String str, int i2, String str2) {
        Queue<Integer> queue = this.l;
        if ((queue == null || queue.size() > 0) && this.l != null) {
            b(i2, str2);
            return;
        }
        com.mbridge.msdk.mbnative.c.a aVar = this.g;
        if (aVar != null && !this.x) {
            this.x = true;
            aVar.onAdLoadError(str);
        }
    }

    private synchronized void b(int i2, long j2, int i3, String str) {
        j jVar;
        if (this.d.containsKey(MBridgeConstans.NATIVE_INFO)) {
            this.t = Math.max(this.W, this.X);
        }
        if (i3 == 0) {
            com.mbridge.msdk.mbnative.a.b<String, List<Campaign>> a2 = com.mbridge.msdk.mbnative.a.c.a(i2);
            if (a2 == null || !a(a(1, d(a2.b(this.j, this.t))))) {
                try {
                    if (this.L != null && !this.V) {
                        this.L.b(true);
                    }
                    if (this.V && !this.x) {
                        a("mb load failed", i3, str);
                    }
                    if (!this.Y) {
                        return;
                    }
                } catch (Exception e2) {
                    q.d(e, com.mbridge.msdk.mbnative.b.a.a(e2));
                    q.d(e, e2.getMessage());
                }
            } else {
                return;
            }
        }
        if (this.u == -1) {
            this.u = i2;
        } else if (this.u != i2) {
            this.v = 0;
        }
        com.mbridge.msdk.foundation.db.e.a((com.mbridge.msdk.foundation.db.f) com.mbridge.msdk.foundation.db.g.a(this.i)).a();
        com.mbridge.msdk.mbnative.e.a.a aVar = new com.mbridge.msdk.mbnative.e.a.a(this.i);
        com.mbridge.msdk.foundation.same.net.h.d dVar = new com.mbridge.msdk.foundation.same.net.h.d();
        String h2 = com.mbridge.msdk.foundation.controller.a.e().h();
        String i4 = com.mbridge.msdk.foundation.controller.a.e().i();
        if (this.d != null && this.d.containsKey("app_id") && this.d.containsKey(MBridgeConstans.APP_KEY) && this.d.containsKey(MBridgeConstans.KEY_WORD) && this.d.get(MBridgeConstans.KEY_WORD) != null) {
            String str2 = null;
            if (this.d.get("app_id") instanceof String) {
                h2 = (String) this.d.get("app_id");
            }
            if (this.d.get(MBridgeConstans.APP_KEY) instanceof String) {
                i4 = (String) this.d.get(MBridgeConstans.APP_KEY);
            }
            if (this.d.get(MBridgeConstans.KEY_WORD) instanceof String) {
                str2 = (String) this.d.get(MBridgeConstans.KEY_WORD);
            }
            if (!TextUtils.isEmpty(str2)) {
                dVar.a("smart", l.a(str2));
            }
        }
        dVar.a("app_id", h2);
        dVar.a(MBridgeConstans.PROPERTIES_UNIT_ID, this.j);
        if (!TextUtils.isEmpty(this.k)) {
            dVar.a(MBridgeConstans.PLACEMENT_ID, this.k);
        }
        dVar.a("req_type", "2");
        if (!TextUtils.isEmpty(this.w)) {
            dVar.a("category", this.w);
        }
        dVar.a("sign", SameMD5.getMD5(h2 + i4));
        if (this.U <= 0 || i3 != 0) {
            dVar.a("ad_num", this.s + "");
        } else {
            dVar.a("ad_num", this.U + "");
        }
        String e3 = u.e(this.j);
        if (!TextUtils.isEmpty(e3)) {
            dVar.a("j", e3);
        }
        dVar.a("only_impression", "1");
        dVar.a("ping_mode", "1");
        if (this.D != 0) {
            dVar.a("frame_num", this.D + "");
        }
        if (!TextUtils.isEmpty(this.n)) {
            dVar.a(MBridgeConstans.NATIVE_INFO, this.n);
            if (i2 == 1 && !com.mbridge.msdk.click.a.a) {
                dVar.a("tnum", this.J + "");
            }
        } else if (i2 == 1 && !com.mbridge.msdk.click.a.a) {
            dVar.a("tnum", this.s + "");
        }
        String a3 = com.mbridge.msdk.foundation.same.a.d.a(this.j, "native");
        if (!TextUtils.isEmpty(a3)) {
            dVar.a(com.mbridge.msdk.foundation.same.net.h.d.b, a3);
        }
        if (Build.VERSION.SDK_INT >= 14) {
            if (this.d.containsKey(MBridgeConstans.NATIVE_VIDEO_WIDTH) && (this.d.get(MBridgeConstans.NATIVE_VIDEO_WIDTH) instanceof Integer)) {
                dVar.a(AdvertisementDBAdapter.AdvertisementColumns.COLUMN_VIDEO_WIDTH, ((Integer) this.d.get(MBridgeConstans.NATIVE_VIDEO_WIDTH)).intValue() + "");
            }
            if (this.d.containsKey(MBridgeConstans.NATIVE_VIDEO_HEIGHT) && (this.d.get(MBridgeConstans.NATIVE_VIDEO_HEIGHT) instanceof Integer)) {
                dVar.a(AdvertisementDBAdapter.AdvertisementColumns.COLUMN_VIDEO_HEIGHT, ((Integer) this.d.get(MBridgeConstans.NATIVE_VIDEO_HEIGHT)).intValue() + "");
            }
            if (this.d.containsKey(MBridgeConstans.NATIVE_VIDEO_SUPPORT) && (this.d.get(MBridgeConstans.NATIVE_VIDEO_SUPPORT) instanceof Boolean)) {
                ((Boolean) this.d.get(MBridgeConstans.NATIVE_VIDEO_SUPPORT)).booleanValue();
            }
            dVar.a("video_version", MBridgeConstans.NATIVE_VIDEO_VERSION);
        }
        if (com.mbridge.msdk.b.b.a().b(com.mbridge.msdk.foundation.controller.a.e().h()) == null) {
            com.mbridge.msdk.b.b.a().b();
        }
        if (!a(this.d)) {
            JSONArray a4 = u.a(this.i, this.j);
            if (a4.length() > 0) {
                dVar.a(com.mbridge.msdk.foundation.same.net.h.d.c, u.a(a4));
            }
        }
        if (b.b().containsKey(this.j) && b.b().get(this.j).booleanValue() && b.c().get(this.j) != null && (jVar = b.c().get(this.j)) != null) {
            if (i2 == 1) {
                this.v = jVar.b();
            } else if (i2 == 2) {
                this.v = jVar.a();
            }
        }
        dVar.a("offset", this.v + "");
        dVar.a("ad_type", RoomMasterTable.DEFAULT_ID);
        dVar.a(CampaignEx.JSON_KEY_AD_SOURCE_ID, i2 + "");
        if (!TextUtils.isEmpty(this.q)) {
            dVar.a(com.mbridge.msdk.foundation.same.net.h.d.a, this.q);
        }
        a aVar2 = new a();
        aVar2.a(b(this.d));
        aVar2.d = this.j;
        aVar2.e = this.k;
        aVar2.f = 42;
        aVar2.b(true);
        c cVar = new c(1, aVar2, i3, str);
        aVar2.a((Runnable) cVar);
        aVar2.g(i3);
        aVar2.a(str);
        if (i3 == 0) {
            if (!TextUtils.isEmpty(str)) {
                dVar.a("token", str);
            }
            if (!com.mbridge.msdk.foundation.same.net.g.d.c().b() || !TextUtils.isEmpty(str)) {
                aVar.a(1, com.mbridge.msdk.foundation.same.net.g.d.c().a(str), dVar, aVar2);
            } else {
                aVar.b(1, com.mbridge.msdk.foundation.same.net.g.d.c().a(str), dVar, aVar2);
            }
        }
        if (i3 == 1) {
            aVar.a(1, com.mbridge.msdk.foundation.same.net.g.d.c().g, dVar, aVar2);
        }
        this.o.postDelayed(cVar, j2);
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:8:0x0023 */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x002c A[Catch:{ Exception -> 0x0089 }] */
    /* JADX WARNING: Removed duplicated region for block: B:39:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(com.mbridge.msdk.out.Campaign r5, android.view.View r6, java.util.List<android.view.View> r7) {
        /*
            r4 = this;
            com.mbridge.msdk.out.NativeListener$NativeTrackingListener r0 = r4.h     // Catch:{ Exception -> 0x0089 }
            if (r0 == 0) goto L_0x000b
            com.mbridge.msdk.click.a r0 = r4.r     // Catch:{ Exception -> 0x0089 }
            com.mbridge.msdk.out.NativeListener$NativeTrackingListener r1 = r4.h     // Catch:{ Exception -> 0x0089 }
            r0.a((com.mbridge.msdk.out.NativeListener.NativeTrackingListener) r1)     // Catch:{ Exception -> 0x0089 }
        L_0x000b:
            int r0 = r5.getType()     // Catch:{ Exception -> 0x0089 }
            com.mbridge.msdk.mbnative.a.b r0 = com.mbridge.msdk.mbnative.a.c.a(r0)     // Catch:{ Exception -> 0x0089 }
            java.lang.String r1 = r4.j     // Catch:{ Exception -> 0x0089 }
            java.lang.String r2 = r4.P     // Catch:{ Exception -> 0x0089 }
            r0.a((java.lang.String) r1, (com.mbridge.msdk.out.Campaign) r5, (java.lang.String) r2)     // Catch:{ Exception -> 0x0089 }
            com.mbridge.msdk.foundation.entity.CampaignEx r5 = (com.mbridge.msdk.foundation.entity.CampaignEx) r5     // Catch:{ Exception -> 0x0089 }
            r0 = 0
            java.lang.String r1 = "com.mbridge.msdk.nativex.view.MBMediaView"
            java.lang.Class r0 = java.lang.Class.forName(r1)     // Catch:{ all -> 0x0023 }
        L_0x0023:
            java.lang.String r1 = r4.j     // Catch:{ Exception -> 0x0089 }
            java.lang.String r2 = "native"
            com.mbridge.msdk.foundation.same.a.d.a((java.lang.String) r1, (com.mbridge.msdk.foundation.entity.CampaignEx) r5, (java.lang.String) r2)     // Catch:{ Exception -> 0x0089 }
            if (r5 == 0) goto L_0x0090
            if (r6 == 0) goto L_0x003f
            if (r0 == 0) goto L_0x0037
            boolean r1 = r0.isInstance(r6)     // Catch:{ Exception -> 0x0089 }
            if (r1 == 0) goto L_0x0037
            return
        L_0x0037:
            com.mbridge.msdk.mbnative.controller.NativeController$1 r1 = new com.mbridge.msdk.mbnative.controller.NativeController$1     // Catch:{ Exception -> 0x0089 }
            r1.<init>(r5)     // Catch:{ Exception -> 0x0089 }
            r6.setOnClickListener(r1)     // Catch:{ Exception -> 0x0089 }
        L_0x003f:
            if (r7 == 0) goto L_0x0069
            int r1 = r7.size()     // Catch:{ Exception -> 0x0089 }
            if (r1 <= 0) goto L_0x0069
            java.util.Iterator r1 = r7.iterator()     // Catch:{ Exception -> 0x0089 }
        L_0x004b:
            boolean r2 = r1.hasNext()     // Catch:{ Exception -> 0x0089 }
            if (r2 == 0) goto L_0x0069
            java.lang.Object r2 = r1.next()     // Catch:{ Exception -> 0x0089 }
            android.view.View r2 = (android.view.View) r2     // Catch:{ Exception -> 0x0089 }
            if (r0 == 0) goto L_0x0060
            boolean r3 = r0.isInstance(r2)     // Catch:{ Exception -> 0x0089 }
            if (r3 == 0) goto L_0x0060
            goto L_0x0069
        L_0x0060:
            com.mbridge.msdk.mbnative.controller.NativeController$4 r3 = new com.mbridge.msdk.mbnative.controller.NativeController$4     // Catch:{ Exception -> 0x0089 }
            r3.<init>(r5)     // Catch:{ Exception -> 0x0089 }
            r2.setOnClickListener(r3)     // Catch:{ Exception -> 0x0089 }
            goto L_0x004b
        L_0x0069:
            boolean r0 = r5.isReport()     // Catch:{ Exception -> 0x0089 }
            if (r0 != 0) goto L_0x0090
            r4.a((com.mbridge.msdk.foundation.entity.CampaignEx) r5, (android.view.View) r6, (java.util.List<android.view.View>) r7)     // Catch:{ Exception -> 0x0089 }
            java.lang.String r6 = e     // Catch:{ Exception -> 0x0089 }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0089 }
            r7.<init>()     // Catch:{ Exception -> 0x0089 }
            java.lang.String r0 = "sendImpression"
            r7.append(r0)     // Catch:{ Exception -> 0x0089 }
            r7.append(r5)     // Catch:{ Exception -> 0x0089 }
            java.lang.String r5 = r7.toString()     // Catch:{ Exception -> 0x0089 }
            android.util.Log.e(r6, r5)     // Catch:{ Exception -> 0x0089 }
            goto L_0x0090
        L_0x0089:
            java.lang.String r5 = e
            java.lang.String r6 = "registerview exception!"
            com.mbridge.msdk.foundation.tools.q.d(r5, r6)
        L_0x0090:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.mbnative.controller.NativeController.a(com.mbridge.msdk.out.Campaign, android.view.View, java.util.List):void");
    }

    public final void a(Campaign campaign, View view) {
        try {
            if (this.h != null) {
                this.r.a(this.h);
            }
            com.mbridge.msdk.mbnative.a.c.a(campaign.getType()).a(this.j, campaign, this.P);
            final CampaignEx campaignEx = (CampaignEx) campaign;
            com.mbridge.msdk.foundation.same.a.d.a(this.j, campaignEx, "native");
            if (campaignEx != null) {
                AnonymousClass5 r0 = new com.mbridge.msdk.widget.a() {
                    /* access modifiers changed from: protected */
                    public final void a(View view) {
                        com.mbridge.msdk.click.a unused = NativeController.this.r;
                        com.mbridge.msdk.click.a.a = false;
                        NativeController.this.r.a(campaignEx, (NativeListener.NativeAdListener) NativeController.this.g);
                        NativeController.a(NativeController.this, campaignEx);
                    }
                };
                try {
                    a(view, (View.OnClickListener) r0, (Class) Class.forName("com.mbridge.msdk.nativex.view.MBMediaView"));
                } catch (Throwable unused) {
                    a(view, (View.OnClickListener) r0, (Class) null);
                }
                if (!campaignEx.isReport()) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(view);
                    a(campaignEx, view, (List<View>) arrayList);
                    String str = e;
                    q.b(str, "sendImpression" + campaignEx);
                }
            }
        } catch (Exception unused2) {
            q.d(e, "registerview exception!");
        }
    }

    private void a(CampaignEx campaignEx, View view, List<View> list) {
        int i2 = 0;
        try {
            if (this.R != null) {
                i2 = this.R.d();
            }
            final f fVar = new f(campaignEx, view, list, this);
            if (this.I == null) {
                this.I = new CopyOnWriteArrayList<>();
            }
            this.I.add(fVar);
            fVar.d = new a.b() {
                public final void a(a.C0062a aVar) {
                    if (aVar == a.C0062a.FINISH && NativeController.this.I != null && NativeController.this.I.size() > 0 && NativeController.this.I.contains(fVar)) {
                        NativeController.this.I.remove(fVar);
                    }
                }
            };
            if (this.o != null) {
                this.o.postDelayed(fVar, (long) (i2 * 1000));
            }
        } catch (Exception e2) {
            q.d(e, com.mbridge.msdk.mbnative.b.a.a(e2));
        }
    }

    private void a(View view, View.OnClickListener onClickListener, Class cls) {
        if (view != null && onClickListener != null) {
            if (cls != null) {
                try {
                    if (cls.isInstance(view)) {
                        return;
                    }
                } catch (Throwable unused) {
                    return;
                }
            }
            view.setOnClickListener(onClickListener);
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
                    a(viewGroup.getChildAt(i2), onClickListener, cls);
                }
            }
        }
    }

    private static class f extends com.mbridge.msdk.foundation.same.e.a {
        private CampaignEx a;
        private WeakReference<View> e;
        private WeakReference<List<View>> f;
        private WeakReference<NativeController> g;

        public final void b() {
        }

        public f(CampaignEx campaignEx, View view, List<View> list, NativeController nativeController) {
            this.a = campaignEx;
            this.e = new WeakReference<>(view);
            this.f = new WeakReference<>(list);
            this.g = new WeakReference<>(nativeController);
        }

        public final void a() {
            try {
                if (this.g != null && this.e != null && this.f != null) {
                    View view = (View) this.e.get();
                    List list = (List) this.f.get();
                    NativeController nativeController = (NativeController) this.g.get();
                    if (view != null && nativeController != null) {
                        NativeController.a(nativeController, this.a, view, list);
                    }
                }
            } catch (Exception e2) {
                q.d(NativeController.e, com.mbridge.msdk.mbnative.b.a.a(e2));
            }
        }
    }

    public final void b(Campaign campaign, View view) {
        b(campaign, view, (List<View>) null);
    }

    public final void b(Campaign campaign, View view, List<View> list) {
        if (campaign != null) {
            int type = campaign.getType();
            if (type == 1 || type == 2) {
                Class<?> cls = null;
                try {
                    cls = Class.forName("com.mbridge.msdk.nativex.view.MBMediaView");
                } catch (Throwable unused) {
                }
                if (list != null && list.size() > 0) {
                    for (View a2 : list) {
                        a(a2, (Class) cls);
                    }
                } else if (view != null) {
                    a(view, (Class) cls);
                }
            }
        }
    }

    private void a(View view, Class cls) {
        if (view != null) {
            if (cls != null) {
                try {
                    if (cls.isInstance(view)) {
                        return;
                    }
                } catch (Throwable unused) {
                    return;
                }
            }
            view.setOnClickListener((View.OnClickListener) null);
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
                    a(viewGroup.getChildAt(i2), cls);
                }
            }
        }
    }

    public final void a() {
        com.mbridge.msdk.foundation.same.e.a next;
        com.mbridge.msdk.foundation.same.e.b bVar = this.F;
        if (bVar != null) {
            bVar.a();
            this.F = null;
        }
        e eVar = this.o;
        if (eVar != null) {
            eVar.removeCallbacksAndMessages((Object) null);
        }
        this.h = null;
        this.r.a();
        try {
            if (this.i != null) {
                com.mbridge.msdk.foundation.same.c.b.a(this.i).c();
            }
            if (this.G != null && this.G.size() > 0) {
                for (a a2 : this.G) {
                    a2.a();
                }
                this.G.clear();
                this.G = null;
            }
            if (this.H != null && this.H.size() > 0) {
                for (a.C0066a next2 : this.H) {
                }
                this.H.clear();
                this.H = null;
            }
            if (this.I != null && this.I.size() > 0) {
                Iterator<com.mbridge.msdk.foundation.same.e.a> it = this.I.iterator();
                if (it.hasNext() && (next = it.next()) != null) {
                    next.d();
                    this.o.removeCallbacks(next);
                }
                this.I.clear();
            }
        } catch (Exception unused) {
        }
    }

    public class c implements Runnable {
        private int b;
        private com.mbridge.msdk.foundation.same.e.c c;
        private int d;
        private String e;

        public c(int i, com.mbridge.msdk.foundation.same.e.c cVar, int i2, String str) {
            this.b = i;
            this.c = cVar;
            this.d = i2;
            this.e = str;
        }

        public final void run() {
            this.c.a(true);
            int i = this.b;
            if (i == 1) {
                boolean unused = NativeController.this.V = true;
                NativeController.this.a("REQUEST_TIMEOUT", this.d, this.e);
            } else if (i == 2) {
                if (!NativeController.this.x || this.d == 1) {
                    NativeController.this.a("REQUEST_TIMEOUT", this.d, this.e);
                }
            }
        }
    }

    public class a extends com.mbridge.msdk.mbnative.e.a.b implements com.mbridge.msdk.foundation.same.e.c {
        private boolean b = false;
        private Runnable c;
        private boolean g = true;
        private List<String> h = null;

        public a() {
        }

        public final void b(boolean z) {
            this.g = z;
        }

        public final void a(boolean z) {
            this.b = z;
        }

        public final void a(List<String> list) {
            this.h = list;
        }

        public final void a(List<com.mbridge.msdk.foundation.same.net.c.b> list, CampaignUnit campaignUnit) {
            int i = 1;
            boolean unused = NativeController.this.V = true;
            com.mbridge.msdk.foundation.db.j a2 = com.mbridge.msdk.foundation.db.j.a((com.mbridge.msdk.foundation.db.f) com.mbridge.msdk.foundation.db.g.a(NativeController.this.i));
            a2.b();
            if (this.c != null) {
                NativeController.this.o.removeCallbacks(this.c);
            }
            if (campaignUnit == null || campaignUnit.getAds() == null || campaignUnit.getAds().size() <= 0) {
                this.d = "0_" + this.d;
                b.b(NativeController.this.u, this.d);
                int unused2 = NativeController.this.v = 0;
                return;
            }
            String unused3 = NativeController.this.q = campaignUnit.getSessionId();
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            if (NativeController.this.T <= 0) {
                if (NativeController.this.T == -3) {
                    int unused4 = NativeController.this.T = campaignUnit.getAds().size();
                } else {
                    NativeController nativeController = NativeController.this;
                    int unused5 = nativeController.T = nativeController.t;
                }
                if (NativeController.this.W != 0 && campaignUnit.getTemplate() == 2) {
                    NativeController nativeController2 = NativeController.this;
                    int unused6 = nativeController2.T = nativeController2.W;
                }
                if (NativeController.this.X != 0 && campaignUnit.getTemplate() == 3) {
                    NativeController nativeController3 = NativeController.this;
                    int unused7 = nativeController3.T = nativeController3.X;
                }
            }
            for (int i2 = 0; i2 < campaignUnit.getAds().size(); i2++) {
                CampaignEx campaignEx = campaignUnit.getAds().get(i2);
                campaignEx.setCampaignUnitId(this.d);
                if (!TextUtils.isEmpty(NativeController.this.P)) {
                    campaignEx.setBidToken(NativeController.this.P);
                    campaignEx.setIsBidCampaign(true);
                }
                if (NativeController.A) {
                    campaignEx.loadIconUrlAsyncWithBlock((OnImageLoadListener) null);
                    campaignEx.loadImageUrlAsyncWithBlock((OnImageLoadListener) null);
                }
                if (campaignEx != null) {
                    boolean c2 = u.c(NativeController.this.i, campaignEx.getPackageName());
                    if (i2 < NativeController.this.t && campaignEx.getOfferType() != 99) {
                        if (u.b(campaignEx)) {
                            campaignEx.setRtinsType(c2 ? 1 : 2);
                        }
                        if (campaignEx.getWtick() == 1 || !c2) {
                            arrayList.add(campaignEx);
                            if (!TextUtils.isEmpty(campaignEx.getVideoUrlEncode())) {
                                arrayList3.add(campaignEx);
                            }
                        } else if (u.b(campaignEx)) {
                            arrayList.add(campaignEx);
                            if (!TextUtils.isEmpty(campaignEx.getVideoUrlEncode())) {
                                arrayList3.add(campaignEx);
                            }
                        } else {
                            u.a(this.d, campaignEx, com.mbridge.msdk.foundation.same.a.v);
                        }
                    }
                    if (i2 < NativeController.this.T && campaignEx.getOfferType() != 99) {
                        if (u.b(campaignEx)) {
                            campaignEx.setRtinsType(c2 ? 1 : 2);
                        }
                        if (!c2) {
                            arrayList2.add(campaignEx);
                        } else if (u.b(campaignEx)) {
                            arrayList2.add(campaignEx);
                        }
                    }
                    if (!a2.a(campaignEx.getId())) {
                        com.mbridge.msdk.foundation.entity.f fVar = new com.mbridge.msdk.foundation.entity.f();
                        fVar.a(campaignEx.getId());
                        fVar.a(campaignEx.getFca());
                        fVar.b(campaignEx.getFcb());
                        fVar.d(0);
                        fVar.c(0);
                        fVar.a(System.currentTimeMillis());
                        a2.a(fVar);
                    }
                    com.mbridge.msdk.click.b.a(NativeController.this.i, campaignEx.getMaitve(), campaignEx.getMaitve_src());
                }
            }
            NativeController.b(NativeController.this, (List) arrayList3);
            int type = campaignUnit.getAds().get(0) != null ? campaignUnit.getAds().get(0).getType() : 1;
            com.mbridge.msdk.mbnative.a.b<String, List<Campaign>> a3 = com.mbridge.msdk.mbnative.a.c.a(type);
            if (a3 != null) {
                a3.a(this.d, arrayList2, NativeController.this.P);
            }
            if (arrayList.size() == 0) {
                NativeController.this.a("APP ALREADY INSTALLED", g(), f());
                return;
            }
            NativeController nativeController4 = NativeController.this;
            boolean unused8 = nativeController4.a((List<Campaign>) nativeController4.a(type, (List<Campaign>) nativeController4.d((List<Campaign>) arrayList)));
            if (!b.b().containsKey(this.d) || !b.b().get(this.d).booleanValue()) {
                if (b.e().containsKey(this.d)) {
                    i = b.e().get(this.d).intValue();
                }
                int c3 = NativeController.this.t + NativeController.this.v;
                if (c3 > i) {
                    c3 = 0;
                }
                int unused9 = NativeController.this.v = c3;
                return;
            }
            b.a(NativeController.this.u, this.d);
        }

        public final void a(int i, String str) {
            boolean unused = NativeController.this.V = true;
            if (!this.b) {
                if (i == -1) {
                    b.b(NativeController.this.u, this.d);
                    int unused2 = NativeController.this.v = 0;
                }
                if (this.c != null) {
                    NativeController.this.o.removeCallbacks(this.c);
                }
                if (NativeController.this.x) {
                    return;
                }
                if (g() == 1 || this.g) {
                    NativeController.this.a(str, g(), f());
                }
            } else if (!NativeController.this.x && this.g) {
                NativeController.this.a(str, g(), f());
            }
        }

        public final void a(Runnable runnable) {
            this.c = runnable;
        }

        public final void b(List<Frame> list) {
            if (!this.b) {
                if (this.c != null) {
                    NativeController.this.o.removeCallbacks(this.c);
                }
                if (list != null && list.size() != 0) {
                    for (Frame campaigns : list) {
                        List<CampaignEx> campaigns2 = campaigns.getCampaigns();
                        if (campaigns2 != null && campaigns2.size() != 0) {
                            for (Campaign next : campaigns2) {
                                if (NativeController.A) {
                                    next.loadImageUrlAsyncWithBlock((OnImageLoadListener) null);
                                    next.loadIconUrlAsyncWithBlock((OnImageLoadListener) null);
                                }
                            }
                        } else if (NativeController.this.g != null) {
                            boolean unused = NativeController.this.x = true;
                            NativeController.this.g.onAdLoadError("ads in frame is empty");
                            return;
                        } else {
                            return;
                        }
                    }
                    if (NativeController.this.g != null) {
                        NativeController.this.g.onAdFramesLoaded(list);
                    }
                } else if (NativeController.this.g != null) {
                    boolean unused2 = NativeController.this.x = true;
                    NativeController.this.g.onAdLoadError("frame is empty");
                }
            }
        }
    }

    public final List<Campaign> b(String str, int i2, String str2) {
        int i3;
        int i4;
        List<Integer> list = this.a;
        List<Campaign> list2 = null;
        if (list != null) {
            ArrayList arrayList = new ArrayList(list);
            List<Campaign> list3 = null;
            for (int i5 = 0; i5 < arrayList.size(); i5++) {
                com.mbridge.msdk.mbnative.a.b<String, List<Campaign>> a2 = com.mbridge.msdk.mbnative.a.c.a(((Integer) arrayList.get(i5)).intValue());
                if (a2 != null) {
                    if ((((Integer) arrayList.get(i5)).intValue() == 1 || ((Integer) arrayList.get(i5)).intValue() == 2) && this.d.containsKey(MBridgeConstans.NATIVE_INFO)) {
                        i4 = this.J;
                    } else {
                        i4 = this.s;
                    }
                    list3 = a(((Integer) arrayList.get(i5)).intValue(), a2.b(str, i4));
                    if (list3 != null) {
                        break;
                    }
                }
            }
            list2 = list3;
            if (list2 == null) {
                for (int i6 = 0; i6 < arrayList.size(); i6++) {
                    com.mbridge.msdk.mbnative.a.b<String, List<Campaign>> a3 = com.mbridge.msdk.mbnative.a.c.a(((Integer) arrayList.get(i6)).intValue());
                    if ((((Integer) arrayList.get(i6)).intValue() == 1 || ((Integer) arrayList.get(i6)).intValue() == 2) && this.d.containsKey(MBridgeConstans.NATIVE_INFO)) {
                        i3 = this.J;
                    } else {
                        i3 = this.s;
                    }
                    list2 = a(((Integer) arrayList.get(i6)).intValue(), a3.a(str, i3));
                    if (list2 != null) {
                        break;
                    }
                }
            }
        }
        return d(list2);
    }

    /* access modifiers changed from: private */
    public boolean a(final List<Campaign> list) {
        if ((!TextUtils.isEmpty(this.P) && list != null && list.size() == 0) || list == null || list.size() <= 0) {
            return false;
        }
        final com.mbridge.msdk.mbnative.c.a aVar = this.g;
        if (aVar == null) {
            return true;
        }
        CampaignEx campaignEx = (CampaignEx) list.get(0);
        final int template = campaignEx != null ? campaignEx.getTemplate() : 2;
        com.mbridge.msdk.foundation.db.j a2 = com.mbridge.msdk.foundation.db.j.a((com.mbridge.msdk.foundation.db.f) com.mbridge.msdk.foundation.db.g.a(this.i));
        a2.b();
        for (int i2 = 0; i2 < list.size(); i2++) {
            CampaignEx campaignEx2 = (CampaignEx) list.get(i2);
            if (!a2.a(campaignEx2.getId())) {
                com.mbridge.msdk.foundation.entity.f fVar = new com.mbridge.msdk.foundation.entity.f();
                fVar.a(campaignEx2.getId());
                fVar.a(campaignEx2.getFca());
                fVar.b(campaignEx2.getFcb());
                fVar.d(0);
                fVar.c(0);
                fVar.a(System.currentTimeMillis());
                a2.a(fVar);
            }
        }
        campaignEx.getType();
        if (!this.N || !this.M) {
            if (list == null || list.size() <= 0) {
                a((NativeListener.NativeAdListener) aVar, "has no ads");
                return true;
            }
            for (Campaign videoLength : list) {
                videoLength.setVideoLength(0);
            }
            a(list, template, (NativeListener.NativeAdListener) aVar);
            return true;
        } else if (e().g() == 3) {
            final List<Campaign> b2 = b(list);
            if (list == null || list.size() <= 0) {
                a((NativeListener.NativeAdListener) aVar, "has no ads");
                return true;
            }
            a(list, (b) new b() {
                public final void a() {
                    List a2 = NativeController.a(NativeController.this, b2, true);
                    if (a2 == null || a2.size() <= 0) {
                        NativeController.this.a(aVar, "has no ads");
                    } else {
                        NativeController.this.a((List<Campaign>) a2, template, aVar);
                    }
                }
            });
            return true;
        } else {
            List<Campaign> c2 = c(list);
            if (c2 == null || c2.size() <= 0) {
                a(list, template, (NativeListener.NativeAdListener) aVar);
                return true;
            }
            a(c2, (b) new b() {
                public final void a() {
                    List a2 = NativeController.a(NativeController.this, list, false);
                    if (a2 == null || a2.size() <= 0) {
                        NativeController.this.a(aVar, "has no ads");
                    } else {
                        NativeController.this.a((List<Campaign>) a2, template, aVar);
                    }
                }
            });
            return true;
        }
    }

    /* access modifiers changed from: private */
    public void a(final List<Campaign> list, final int i2, final NativeListener.NativeAdListener nativeAdListener) {
        this.o.post(new Runnable() {
            public final void run() {
                List list = list;
                if (list != null && list.size() > 0) {
                    String unused = NativeController.this.Q = ((CampaignEx) list.get(0)).getRequestId();
                }
                boolean unused2 = NativeController.this.x = true;
                nativeAdListener.onAdLoaded(list, i2);
                com.mbridge.msdk.mbnative.d.a.a(NativeController.this.i, list, NativeController.this.j);
            }
        });
    }

    /* access modifiers changed from: private */
    public void a(final NativeListener.NativeAdListener nativeAdListener, final String str) {
        this.o.post(new Runnable() {
            public final void run() {
                nativeAdListener.onAdLoadError(str);
            }
        });
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0039, code lost:
        r0 = r4.size();
        r1 = r2.X;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.List<com.mbridge.msdk.out.Campaign> a(int r3, java.util.List<com.mbridge.msdk.out.Campaign> r4) {
        /*
            r2 = this;
            r0 = 1
            if (r3 != r0) goto L_0x0045
            java.util.Map<java.lang.String, java.lang.Object> r3 = r2.d
            java.lang.String r1 = "native_info"
            boolean r3 = r3.containsKey(r1)
            if (r3 == 0) goto L_0x0045
            if (r4 == 0) goto L_0x0045
            int r3 = r4.size()
            if (r3 <= 0) goto L_0x0045
            r3 = 0
            java.lang.Object r1 = r4.get(r3)
            com.mbridge.msdk.foundation.entity.CampaignEx r1 = (com.mbridge.msdk.foundation.entity.CampaignEx) r1
            if (r1 == 0) goto L_0x0022
            int r0 = r1.getTemplate()
        L_0x0022:
            r1 = 2
            if (r0 != r1) goto L_0x0034
            if (r4 == 0) goto L_0x0045
            int r0 = r4.size()
            int r1 = r2.W
            if (r0 < r1) goto L_0x0045
            java.util.List r4 = r4.subList(r3, r1)
            goto L_0x0045
        L_0x0034:
            r1 = 3
            if (r0 != r1) goto L_0x0045
            if (r4 == 0) goto L_0x0045
            int r0 = r4.size()
            int r1 = r2.X
            if (r0 < r1) goto L_0x0045
            java.util.List r4 = r4.subList(r3, r1)
        L_0x0045:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.mbnative.controller.NativeController.a(int, java.util.List):java.util.List");
    }

    public static boolean a(Map<String, Object> map) {
        if (map == null) {
            return false;
        }
        try {
            if (!map.containsKey("app_id") || !map.containsKey(MBridgeConstans.APP_KEY) || !map.containsKey(MBridgeConstans.KEY_WORD) || map.get(MBridgeConstans.KEY_WORD) == null) {
                return false;
            }
            return true;
        } catch (Exception e2) {
            q.d(e, com.mbridge.msdk.mbnative.b.a.a(e2));
            return false;
        }
    }

    public static List<String> b(Map<String, Object> map) {
        ArrayList arrayList;
        try {
            if (!(map.get(MBridgeConstans.KEY_WORD) instanceof String)) {
                return null;
            }
            String str = (String) map.get(MBridgeConstans.KEY_WORD);
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            JSONArray jSONArray = new JSONArray(str);
            if (jSONArray.length() == 0) {
                return null;
            }
            arrayList = new ArrayList();
            int i2 = 0;
            while (i2 < jSONArray.length()) {
                try {
                    JSONObject optJSONObject = jSONArray.optJSONObject(i2);
                    if (optJSONObject != null) {
                        String optString = optJSONObject.optString(TtmlNode.TAG_P);
                        if (!TextUtils.isEmpty(optString)) {
                            arrayList.add(optString);
                        }
                    }
                    i2++;
                } catch (Exception e2) {
                    e = e2;
                    q.d(e, com.mbridge.msdk.mbnative.b.a.a(e));
                    return arrayList;
                }
            }
            return arrayList;
        } catch (Exception e3) {
            e = e3;
            arrayList = null;
            q.d(e, com.mbridge.msdk.mbnative.b.a.a(e));
            return arrayList;
        }
    }

    private static class d implements g.b {
        private String a;
        private CampaignEx b;
        private long c = System.currentTimeMillis();
        private boolean d = true;

        public d(String str, CampaignEx campaignEx, boolean z) {
            this.a = str;
            this.b = campaignEx;
            this.d = z;
        }

        public final void a(String str) {
            try {
                if (this.d) {
                    long currentTimeMillis = System.currentTimeMillis() - this.c;
                    p.a((com.mbridge.msdk.foundation.db.f) com.mbridge.msdk.foundation.db.g.a(com.mbridge.msdk.foundation.controller.a.e().g()));
                    m mVar = new m("2000043", 20, currentTimeMillis + "", str, this.b.getId(), this.a, "", "2");
                    if (this.b != null && !TextUtils.isEmpty(this.b.getId())) {
                        mVar.n(this.b.getId());
                    }
                    if (this.b != null) {
                        mVar.k(this.b.getRequestId());
                        mVar.l(this.b.getRequestIdNotice());
                        mVar.b(this.b.getAdSpaceT());
                    }
                    mVar.h("1");
                    com.mbridge.msdk.foundation.same.report.b.a(mVar, this.a);
                }
            } catch (Exception e) {
                q.d(NativeController.e, com.mbridge.msdk.mbnative.b.a.a(e));
            }
        }

        public final void a(String str, String str2) {
            try {
                if (this.d) {
                    long currentTimeMillis = System.currentTimeMillis() - this.c;
                    p.a((com.mbridge.msdk.foundation.db.f) com.mbridge.msdk.foundation.db.g.a(com.mbridge.msdk.foundation.controller.a.e().g()));
                    m mVar = new m("2000043", 21, currentTimeMillis + "", str, this.b.getId(), this.a, str2, "2");
                    mVar.k(this.b.getRequestId());
                    mVar.l(this.b.getRequestIdNotice());
                    if (this.b != null && !TextUtils.isEmpty(this.b.getId())) {
                        mVar.n(this.b.getId());
                    }
                    if (this.b != null) {
                        mVar.b(this.b.getAdSpaceT());
                    }
                    mVar.h("1");
                    com.mbridge.msdk.foundation.same.report.b.a(mVar, this.a);
                }
            } catch (Exception e) {
                q.d(NativeController.e, com.mbridge.msdk.mbnative.b.a.a(e));
            }
        }
    }

    private static final class g implements g.d {
        String a;
        CampaignEx b;
        private long c = System.currentTimeMillis();
        private boolean d = true;

        public g(String str, CampaignEx campaignEx, boolean z) {
            this.a = str;
            this.b = campaignEx;
            this.d = z;
        }

        public final void a(String str) {
            try {
                if (this.d) {
                    long currentTimeMillis = System.currentTimeMillis() - this.c;
                    p.a((com.mbridge.msdk.foundation.db.f) com.mbridge.msdk.foundation.db.g.a(com.mbridge.msdk.foundation.controller.a.e().g()));
                    m mVar = new m("2000043", 14, currentTimeMillis + "", str, this.b.getId(), this.a, "", "1");
                    if (this.b != null && !TextUtils.isEmpty(this.b.getId())) {
                        mVar.n(this.b.getId());
                    }
                    if (this.b != null) {
                        mVar.k(this.b.getRequestId());
                        mVar.l(this.b.getRequestIdNotice());
                        mVar.b(this.b.getAdSpaceT());
                    }
                    mVar.h("2");
                    com.mbridge.msdk.foundation.same.report.b.a(mVar, this.a);
                }
            } catch (Exception e) {
                q.d(NativeController.e, com.mbridge.msdk.mbnative.b.a.a(e));
            }
        }

        public final void a(String str, String str2) {
            try {
                if (this.d) {
                    long currentTimeMillis = System.currentTimeMillis() - this.c;
                    p.a((com.mbridge.msdk.foundation.db.f) com.mbridge.msdk.foundation.db.g.a(com.mbridge.msdk.foundation.controller.a.e().g()));
                    m mVar = new m("2000043", 3, currentTimeMillis + "", str2, this.b.getId(), this.a, str, "1");
                    if (this.b != null && !TextUtils.isEmpty(this.b.getId())) {
                        mVar.n(this.b.getId());
                    }
                    if (this.b != null) {
                        mVar.k(this.b.getRequestId());
                        mVar.l(this.b.getRequestIdNotice());
                        mVar.b(this.b.getAdSpaceT());
                    }
                    mVar.h("2");
                    com.mbridge.msdk.foundation.same.report.b.a(mVar, this.a);
                }
            } catch (Exception e) {
                q.d(NativeController.e, com.mbridge.msdk.mbnative.b.a.a(e));
            }
        }
    }

    public static void insertExcludeId(String str, CampaignEx campaignEx) {
        if (!TextUtils.isEmpty(str) && campaignEx != null && com.mbridge.msdk.foundation.controller.a.e().g() != null) {
            i a2 = i.a((com.mbridge.msdk.foundation.db.f) com.mbridge.msdk.foundation.db.g.a(com.mbridge.msdk.foundation.controller.a.e().g()));
            com.mbridge.msdk.foundation.entity.e eVar = new com.mbridge.msdk.foundation.entity.e();
            eVar.a(System.currentTimeMillis());
            eVar.b(str);
            eVar.a(campaignEx.getId());
            a2.a(eVar);
        }
    }

    /* access modifiers changed from: private */
    public com.mbridge.msdk.b.d e() {
        this.R = com.mbridge.msdk.b.b.a().e("", this.j);
        if (this.R == null) {
            this.R = com.mbridge.msdk.b.d.d(this.j);
        }
        return this.R;
    }

    private List<Campaign> b(List<Campaign> list) {
        if (list != null) {
            CampaignEx campaignEx = null;
            for (int size = list.size() - 1; size >= 0; size--) {
                try {
                    campaignEx = (CampaignEx) list.get(size);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
                if (campaignEx != null && TextUtils.isEmpty(campaignEx.getVideoUrlEncode())) {
                    Campaign remove = list.remove(size);
                    com.mbridge.msdk.mbnative.a.c.a(campaignEx.getType()).a(this.j, remove, this.P);
                    q.a(e, "remove no videoURL ads:" + remove);
                }
            }
        }
        return list;
    }

    private List<Campaign> c(List<Campaign> list) {
        ArrayList arrayList = null;
        if (list != null) {
            for (Campaign next : list) {
                if (next instanceof CampaignEx) {
                    CampaignEx campaignEx = (CampaignEx) next;
                    if (TextUtils.isEmpty(campaignEx.getImageUrl()) && !TextUtils.isEmpty(campaignEx.getVideoUrlEncode())) {
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                        }
                        arrayList.add(next);
                    }
                }
            }
        }
        return arrayList;
    }

    private void a(List<Campaign> list, b bVar) {
        f();
        final long currentTimeMillis = System.currentTimeMillis();
        this.O = new Timer();
        final b bVar2 = bVar;
        final List<Campaign> list2 = list;
        this.O.schedule(new TimerTask() {
            public final void run() {
                boolean z;
                if (System.currentTimeMillis() - currentTimeMillis >= ChunkedTrackBlacklistUtil.DEFAULT_TRACK_BLACKLIST_MS) {
                    bVar2.a();
                    NativeController.this.f();
                    return;
                }
                int n = com.mbridge.msdk.foundation.tools.m.n(NativeController.this.i);
                int j = NativeController.this.e().j();
                if (n != 9 && j == 2) {
                    bVar2.a();
                    NativeController.this.f();
                } else if (j == 3) {
                    bVar2.a();
                    NativeController.this.f();
                } else {
                    loop0:
                    while (true) {
                        z = false;
                        for (Campaign campaign : list2) {
                            String id = campaign.getId();
                            if (campaign instanceof CampaignEx) {
                                StringBuilder sb = new StringBuilder();
                                sb.append(id);
                                CampaignEx campaignEx = (CampaignEx) campaign;
                                sb.append(campaignEx.getVideoUrlEncode());
                                sb.append(campaignEx.getBidToken());
                                id = sb.toString();
                            }
                            com.mbridge.msdk.videocommon.download.a a2 = com.mbridge.msdk.videocommon.download.c.getInstance().a(NativeController.this.j, id);
                            if (a2 != null && k.a(a2, NativeController.this.e().e())) {
                                z = true;
                            }
                        }
                        break loop0;
                    }
                    if (z) {
                        bVar2.a();
                        NativeController.this.f();
                    }
                }
            }
        }, 0, 1000);
    }

    /* access modifiers changed from: private */
    public void f() {
        Timer timer = this.O;
        if (timer != null) {
            timer.cancel();
            this.O = null;
        }
    }

    public final String b() {
        return this.Q;
    }

    /* access modifiers changed from: private */
    public List<Campaign> d(List<Campaign> list) {
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(list.size());
        ArrayList arrayList2 = new ArrayList(list.size());
        for (Campaign next : list) {
            if (next instanceof CampaignEx) {
                CampaignEx campaignEx = (CampaignEx) next;
                if (TextUtils.isEmpty(this.P) && TextUtils.isEmpty(campaignEx.getBidToken()) && !campaignEx.isBidCampaign()) {
                    arrayList2.add(campaignEx);
                } else if (!TextUtils.isEmpty(this.P) && TextUtils.equals(campaignEx.getBidToken(), this.P)) {
                    arrayList.add(next);
                }
            } else {
                arrayList2.add(next);
            }
        }
        return TextUtils.isEmpty(this.P) ? arrayList2 : arrayList;
    }

    static /* synthetic */ void a(NativeController nativeController, CampaignEx campaignEx) {
        if (!campaignEx.isReportClick()) {
            campaignEx.setReportClick(true);
            if (campaignEx != null && campaignEx.getNativeVideoTracking() != null && campaignEx.getNativeVideoTracking().e() != null) {
                com.mbridge.msdk.click.a.a(nativeController.i, campaignEx, campaignEx.getCampaignUnitId(), campaignEx.getNativeVideoTracking().e(), false, false);
            }
        }
    }

    static /* synthetic */ void a(NativeController nativeController, final CampaignEx campaignEx, View view, List list) {
        try {
            AnonymousClass7 r0 = new a.C0066a() {
                public final void a(ArrayList<View> arrayList, ArrayList<View> arrayList2) {
                    if (arrayList != null && arrayList.size() > 0) {
                        com.mbridge.msdk.mbnative.d.b.a(campaignEx, NativeController.this.i, NativeController.this.j, NativeController.this.g);
                    }
                }
            };
            a aVar = new a(list, r0, new Handler(Looper.getMainLooper()));
            aVar.a(view);
            if (nativeController.G != null) {
                nativeController.G.add(aVar);
            }
            if (nativeController.H != null) {
                nativeController.H.add(r0);
            }
        } catch (Exception unused) {
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:29|30|44) */
    /* JADX WARNING: Code restructure failed: missing block: B:30:?, code lost:
        com.mbridge.msdk.foundation.tools.q.d(e, "please import the videocommon and nativex aar");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:?, code lost:
        return;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x0103 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ void b(com.mbridge.msdk.mbnative.controller.NativeController r12, java.util.List r13) {
        /*
            java.lang.String r0 = "com.mbridge.msdk.videocommon.download.c"
            if (r13 == 0) goto L_0x0113
            int r1 = r13.size()     // Catch:{ all -> 0x010b }
            if (r1 <= 0) goto L_0x0113
            java.lang.String r1 = "com.mbridge.msdk.nativex.view.MBMediaView"
            java.lang.Class.forName(r1)     // Catch:{ all -> 0x0103 }
            java.lang.Class.forName(r0)     // Catch:{ all -> 0x0103 }
            java.lang.Class r0 = java.lang.Class.forName(r0)     // Catch:{ all -> 0x0103 }
            java.lang.String r1 = "com.mbridge.msdk.videocommon.listener.a"
            java.lang.Class r1 = java.lang.Class.forName(r1)     // Catch:{ all -> 0x0103 }
            java.lang.String r2 = "getInstance"
            r3 = 0
            java.lang.Class[] r4 = new java.lang.Class[r3]     // Catch:{ all -> 0x0103 }
            java.lang.reflect.Method r2 = r0.getMethod(r2, r4)     // Catch:{ all -> 0x0103 }
            java.lang.Object[] r4 = new java.lang.Object[r3]     // Catch:{ all -> 0x0103 }
            r5 = 0
            java.lang.Object r2 = r2.invoke(r5, r4)     // Catch:{ all -> 0x0103 }
            if (r2 == 0) goto L_0x0079
            java.lang.String r4 = "createUnitCache"
            r6 = 5
            java.lang.Class[] r7 = new java.lang.Class[r6]     // Catch:{ all -> 0x0103 }
            java.lang.Class<android.content.Context> r8 = android.content.Context.class
            r7[r3] = r8     // Catch:{ all -> 0x0103 }
            java.lang.Class<java.lang.String> r8 = java.lang.String.class
            r9 = 1
            r7[r9] = r8     // Catch:{ all -> 0x0103 }
            java.lang.Class<java.util.List> r8 = java.util.List.class
            r10 = 2
            r7[r10] = r8     // Catch:{ all -> 0x0103 }
            java.lang.Class r8 = java.lang.Integer.TYPE     // Catch:{ all -> 0x0103 }
            r11 = 3
            r7[r11] = r8     // Catch:{ all -> 0x0103 }
            r8 = 4
            r7[r8] = r1     // Catch:{ all -> 0x0103 }
            java.lang.reflect.Method r1 = r0.getMethod(r4, r7)     // Catch:{ all -> 0x0103 }
            java.lang.Object[] r4 = new java.lang.Object[r6]     // Catch:{ all -> 0x0103 }
            android.content.Context r6 = r12.i     // Catch:{ all -> 0x0103 }
            r4[r3] = r6     // Catch:{ all -> 0x0103 }
            java.lang.String r6 = r12.j     // Catch:{ all -> 0x0103 }
            r4[r9] = r6     // Catch:{ all -> 0x0103 }
            r4[r10] = r13     // Catch:{ all -> 0x0103 }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r9)     // Catch:{ all -> 0x0103 }
            r4[r11] = r6     // Catch:{ all -> 0x0103 }
            r4[r8] = r5     // Catch:{ all -> 0x0103 }
            r1.invoke(r2, r4)     // Catch:{ all -> 0x0103 }
            java.lang.String r1 = "load"
            java.lang.Class[] r4 = new java.lang.Class[r9]     // Catch:{ all -> 0x0103 }
            java.lang.Class<java.lang.String> r5 = java.lang.String.class
            r4[r3] = r5     // Catch:{ all -> 0x0103 }
            java.lang.reflect.Method r0 = r0.getMethod(r1, r4)     // Catch:{ all -> 0x0103 }
            java.lang.Object[] r1 = new java.lang.Object[r9]     // Catch:{ all -> 0x0103 }
            java.lang.String r4 = r12.j     // Catch:{ all -> 0x0103 }
            r1[r3] = r4     // Catch:{ all -> 0x0103 }
            r0.invoke(r2, r1)     // Catch:{ all -> 0x0103 }
        L_0x0079:
            java.util.Iterator r13 = r13.iterator()     // Catch:{ all -> 0x0103 }
        L_0x007d:
            boolean r0 = r13.hasNext()     // Catch:{ all -> 0x0103 }
            if (r0 == 0) goto L_0x0113
            java.lang.Object r0 = r13.next()     // Catch:{ all -> 0x0103 }
            com.mbridge.msdk.foundation.entity.CampaignEx r0 = (com.mbridge.msdk.foundation.entity.CampaignEx) r0     // Catch:{ all -> 0x0103 }
            if (r0 == 0) goto L_0x00ad
            java.lang.String r1 = r0.getImageUrl()     // Catch:{ all -> 0x0103 }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ all -> 0x0103 }
            if (r1 != 0) goto L_0x00ad
            com.mbridge.msdk.foundation.controller.a r1 = com.mbridge.msdk.foundation.controller.a.e()     // Catch:{ all -> 0x0103 }
            android.content.Context r1 = r1.g()     // Catch:{ all -> 0x0103 }
            com.mbridge.msdk.foundation.same.c.b r1 = com.mbridge.msdk.foundation.same.c.b.a((android.content.Context) r1)     // Catch:{ all -> 0x0103 }
            java.lang.String r2 = r0.getImageUrl()     // Catch:{ all -> 0x0103 }
            com.mbridge.msdk.mbnative.controller.NativeController$2 r3 = new com.mbridge.msdk.mbnative.controller.NativeController$2     // Catch:{ all -> 0x0103 }
            r3.<init>()     // Catch:{ all -> 0x0103 }
            r1.a((java.lang.String) r2, (com.mbridge.msdk.foundation.same.c.c) r3)     // Catch:{ all -> 0x0103 }
        L_0x00ad:
            java.lang.String r1 = "com.mbridge.msdk.videocommon.download.g"
            java.lang.Class.forName(r1)     // Catch:{ Exception -> 0x007d }
            java.lang.String r1 = r0.getendcard_url()     // Catch:{ Exception -> 0x007d }
            boolean r2 = android.text.TextUtils.isEmpty(r1)     // Catch:{ Exception -> 0x007d }
            if (r2 != 0) goto L_0x007d
            java.lang.String r2 = ".zip"
            boolean r2 = r1.contains(r2)     // Catch:{ Exception -> 0x007d }
            if (r2 == 0) goto L_0x00e7
            java.lang.String r2 = "md5filename"
            boolean r2 = r1.contains(r2)     // Catch:{ Exception -> 0x007d }
            if (r2 == 0) goto L_0x00e7
            com.mbridge.msdk.videocommon.download.g r2 = com.mbridge.msdk.videocommon.download.g.a()     // Catch:{ Exception -> 0x007d }
            java.lang.String r2 = r2.b((java.lang.String) r1)     // Catch:{ Exception -> 0x007d }
            boolean r2 = android.text.TextUtils.isEmpty(r2)     // Catch:{ Exception -> 0x007d }
            com.mbridge.msdk.mbnative.controller.NativeController$g r3 = new com.mbridge.msdk.mbnative.controller.NativeController$g     // Catch:{ Exception -> 0x007d }
            java.lang.String r4 = r12.j     // Catch:{ Exception -> 0x007d }
            r3.<init>(r4, r0, r2)     // Catch:{ Exception -> 0x007d }
            com.mbridge.msdk.videocommon.download.g r0 = com.mbridge.msdk.videocommon.download.g.a()     // Catch:{ Exception -> 0x007d }
            r0.b(r1, r3)     // Catch:{ Exception -> 0x007d }
            goto L_0x007d
        L_0x00e7:
            com.mbridge.msdk.videocommon.download.h r2 = com.mbridge.msdk.videocommon.download.h.a()     // Catch:{ Exception -> 0x007d }
            java.lang.String r2 = r2.b(r1)     // Catch:{ Exception -> 0x007d }
            boolean r2 = android.text.TextUtils.isEmpty(r2)     // Catch:{ Exception -> 0x007d }
            com.mbridge.msdk.mbnative.controller.NativeController$d r3 = new com.mbridge.msdk.mbnative.controller.NativeController$d     // Catch:{ Exception -> 0x007d }
            java.lang.String r4 = r12.j     // Catch:{ Exception -> 0x007d }
            r3.<init>(r4, r0, r2)     // Catch:{ Exception -> 0x007d }
            com.mbridge.msdk.videocommon.download.g r0 = com.mbridge.msdk.videocommon.download.g.a()     // Catch:{ Exception -> 0x007d }
            r0.b(r1, r3)     // Catch:{ Exception -> 0x007d }
            goto L_0x007d
        L_0x0103:
            java.lang.String r12 = e     // Catch:{ all -> 0x010b }
            java.lang.String r13 = "please import the videocommon and nativex aar"
            com.mbridge.msdk.foundation.tools.q.d(r12, r13)     // Catch:{ all -> 0x010b }
            goto L_0x0113
        L_0x010b:
            r12 = move-exception
            boolean r13 = com.mbridge.msdk.MBridgeConstans.DEBUG
            if (r13 == 0) goto L_0x0113
            r12.printStackTrace()
        L_0x0113:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.mbnative.controller.NativeController.b(com.mbridge.msdk.mbnative.controller.NativeController, java.util.List):void");
    }

    static /* synthetic */ List a(NativeController nativeController, List list, boolean z2) {
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                Campaign campaign = (Campaign) list.get(size);
                String id = campaign.getId();
                boolean z3 = campaign instanceof CampaignEx;
                if (z3) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(id);
                    CampaignEx campaignEx = (CampaignEx) campaign;
                    sb.append(campaignEx.getVideoUrlEncode());
                    sb.append(campaignEx.getBidToken());
                    id = sb.toString();
                }
                com.mbridge.msdk.videocommon.download.a a2 = com.mbridge.msdk.videocommon.download.c.getInstance().a(nativeController.j, id);
                if (z2) {
                    if (a2 == null || !k.a(a2, nativeController.e().e())) {
                        com.mbridge.msdk.mbnative.a.c.a(campaign.getType()).a(nativeController.j, (Campaign) list.remove(size), nativeController.P);
                    }
                } else if (z3) {
                    CampaignEx campaignEx2 = (CampaignEx) campaign;
                    if (TextUtils.isEmpty(campaignEx2.getImageUrl()) && !TextUtils.isEmpty(campaignEx2.getVideoUrlEncode()) && (a2 == null || !k.a(a2, nativeController.e().e()))) {
                        com.mbridge.msdk.mbnative.a.c.a(campaign.getType()).a(nativeController.j, (Campaign) list.remove(size), nativeController.P);
                    }
                }
            }
        }
        return list;
    }
}
