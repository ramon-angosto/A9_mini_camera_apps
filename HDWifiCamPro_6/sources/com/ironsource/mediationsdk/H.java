package com.ironsource.mediationsdk;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.ironsource.environment.ContextProvider;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.M;
import com.ironsource.mediationsdk.a.c;
import com.ironsource.mediationsdk.a.d;
import com.ironsource.mediationsdk.adunit.c.g;
import com.ironsource.mediationsdk.adunit.c.h;
import com.ironsource.mediationsdk.config.ConfigFile;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.logger.IronSourceLogger;
import com.ironsource.mediationsdk.logger.IronSourceLoggerManager;
import com.ironsource.mediationsdk.logger.LogListener;
import com.ironsource.mediationsdk.metadata.MetaData;
import com.ironsource.mediationsdk.metadata.MetaDataUtils;
import com.ironsource.mediationsdk.model.InterstitialPlacement;
import com.ironsource.mediationsdk.model.NetworkSettings;
import com.ironsource.mediationsdk.model.Placement;
import com.ironsource.mediationsdk.model.e;
import com.ironsource.mediationsdk.model.f;
import com.ironsource.mediationsdk.model.j;
import com.ironsource.mediationsdk.model.o;
import com.ironsource.mediationsdk.sdk.ISDemandOnlyInterstitialListener;
import com.ironsource.mediationsdk.sdk.ISDemandOnlyRewardedVideoListener;
import com.ironsource.mediationsdk.sdk.InitializationListener;
import com.ironsource.mediationsdk.sdk.RewardedVideoListener;
import com.ironsource.mediationsdk.sdk.RewardedVideoManualListener;
import com.ironsource.mediationsdk.server.HttpFunctions;
import com.ironsource.mediationsdk.server.ServerURL;
import com.ironsource.mediationsdk.utils.ErrorBuilder;
import com.ironsource.mediationsdk.utils.IronSourceAES;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.ironsource.mediationsdk.utils.IronSourceUtils;
import com.ironsource.mediationsdk.utils.i;
import com.ironsource.mediationsdk.utils.k;
import com.ironsource.mediationsdk.utils.l;
import com.ironsource.mediationsdk.utils.p;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

public final class H implements i {
    private static boolean ap = false;
    S A;
    P B;
    g C;
    h D;
    boolean E;
    boolean F;
    boolean G;
    boolean H;
    boolean I;
    boolean J;
    boolean K;
    int L;
    C0166s M;
    C0164q N;
    com.ironsource.mediationsdk.impressionData.a O;
    private final String P;
    private final String Q;
    private AbstractAdapter R;
    private AtomicBoolean S;
    private final Object T;
    private AtomicBoolean U;
    private boolean V;
    private List<IronSource.AD_UNIT> W;
    private Set<IronSource.AD_UNIT> X;
    private Set<IronSource.AD_UNIT> Y;
    private boolean Z;
    final String a;
    private final String aa;
    private boolean ab;
    private boolean ac;
    private Boolean ad;
    private IronSourceBannerLayout ae;
    private String af;
    private InitializationListener ag;
    private AtomicBoolean ah;
    private boolean ai;
    private CopyOnWriteArraySet<String> aj;
    private CopyOnWriteArraySet<String> ak;
    private CopyOnWriteArraySet<String> al;
    private C0168u am;
    private com.ironsource.d.b an;
    private ai ao;
    ab b;
    E c;
    O d;
    C0158k e;
    IronSourceLoggerManager f;
    com.ironsource.mediationsdk.sdk.i g;
    com.ironsource.mediationsdk.logger.b h;
    l i;
    public String j;
    public String k;
    String l;
    public String m;
    public Map<String, String> n;
    public String o;
    public String p;
    Context q;
    Boolean r;
    IronSourceSegment s;
    int t;
    boolean u;
    boolean v;
    boolean w;
    boolean x;
    Boolean y;
    C0173z z;

    /* renamed from: com.ironsource.mediationsdk.H$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] a = new int[IronSource.AD_UNIT.values().length];
        static final /* synthetic */ int[] b = new int[k.a.a().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(19:0|1|2|3|(2:5|6)|7|(2:9|10)|11|(2:13|14)|15|17|18|19|20|21|22|23|24|26) */
        /* JADX WARNING: Can't wrap try/catch for region: R(20:0|1|2|3|(2:5|6)|7|9|10|11|(2:13|14)|15|17|18|19|20|21|22|23|24|26) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x0039 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0043 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x004d */
        static {
            /*
                int[] r0 = com.ironsource.mediationsdk.utils.k.a.a()
                int r0 = r0.length
                int[] r0 = new int[r0]
                b = r0
                r0 = 1
                int[] r1 = b     // Catch:{ NoSuchFieldError -> 0x0011 }
                int r2 = com.ironsource.mediationsdk.utils.k.a.a     // Catch:{ NoSuchFieldError -> 0x0011 }
                r2 = 0
                r1[r2] = r0     // Catch:{ NoSuchFieldError -> 0x0011 }
            L_0x0011:
                r1 = 2
                int[] r2 = b     // Catch:{ NoSuchFieldError -> 0x0018 }
                int r3 = com.ironsource.mediationsdk.utils.k.a.b     // Catch:{ NoSuchFieldError -> 0x0018 }
                r2[r0] = r1     // Catch:{ NoSuchFieldError -> 0x0018 }
            L_0x0018:
                r2 = 3
                int[] r3 = b     // Catch:{ NoSuchFieldError -> 0x001f }
                int r4 = com.ironsource.mediationsdk.utils.k.a.c     // Catch:{ NoSuchFieldError -> 0x001f }
                r3[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                r3 = 4
                int[] r4 = b     // Catch:{ NoSuchFieldError -> 0x0026 }
                int r5 = com.ironsource.mediationsdk.utils.k.a.d     // Catch:{ NoSuchFieldError -> 0x0026 }
                r4[r2] = r3     // Catch:{ NoSuchFieldError -> 0x0026 }
            L_0x0026:
                com.ironsource.mediationsdk.IronSource$AD_UNIT[] r4 = com.ironsource.mediationsdk.IronSource.AD_UNIT.values()
                int r4 = r4.length
                int[] r4 = new int[r4]
                a = r4
                int[] r4 = a     // Catch:{ NoSuchFieldError -> 0x0039 }
                com.ironsource.mediationsdk.IronSource$AD_UNIT r5 = com.ironsource.mediationsdk.IronSource.AD_UNIT.REWARDED_VIDEO     // Catch:{ NoSuchFieldError -> 0x0039 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0039 }
                r4[r5] = r0     // Catch:{ NoSuchFieldError -> 0x0039 }
            L_0x0039:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x0043 }
                com.ironsource.mediationsdk.IronSource$AD_UNIT r4 = com.ironsource.mediationsdk.IronSource.AD_UNIT.INTERSTITIAL     // Catch:{ NoSuchFieldError -> 0x0043 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0043 }
                r0[r4] = r1     // Catch:{ NoSuchFieldError -> 0x0043 }
            L_0x0043:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x004d }
                com.ironsource.mediationsdk.IronSource$AD_UNIT r1 = com.ironsource.mediationsdk.IronSource.AD_UNIT.OFFERWALL     // Catch:{ NoSuchFieldError -> 0x004d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x004d }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x004d }
            L_0x004d:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x0057 }
                com.ironsource.mediationsdk.IronSource$AD_UNIT r1 = com.ironsource.mediationsdk.IronSource.AD_UNIT.BANNER     // Catch:{ NoSuchFieldError -> 0x0057 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0057 }
                r0[r1] = r3     // Catch:{ NoSuchFieldError -> 0x0057 }
            L_0x0057:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.ironsource.mediationsdk.H.AnonymousClass1.<clinit>():void");
        }
    }

    public interface a {
        void a(String str);
    }

    static class b {
        static volatile H a = new H((byte) 0);
    }

    private H() {
        this.a = getClass().getName();
        this.P = "!SDK-VERSION-STRING!:com.ironsource:mediationsdk:​7.2.1.1";
        this.Q = "Activity=";
        this.T = new Object();
        this.i = null;
        this.j = null;
        this.k = null;
        this.l = null;
        this.m = null;
        this.n = null;
        this.o = null;
        this.V = false;
        this.p = null;
        this.r = null;
        this.Z = true;
        this.aa = IronSourceConstants.KEY_SESSION_DEPTH;
        this.y = null;
        this.f = IronSourceLoggerManager.getLogger(0);
        this.h = new com.ironsource.mediationsdk.logger.b((LogListener) null, 1);
        this.f.addLogger(this.h);
        this.g = new com.ironsource.mediationsdk.sdk.i();
        this.b = new ab();
        this.b.m = this.g;
        this.c = new E();
        E e2 = this.c;
        com.ironsource.mediationsdk.sdk.i iVar = this.g;
        e2.m = iVar;
        e2.n.a = iVar;
        this.d = new O();
        this.d.b = this.g;
        this.S = new AtomicBoolean();
        this.X = new HashSet();
        this.Y = new HashSet();
        this.v = false;
        this.u = false;
        this.ab = false;
        this.U = new AtomicBoolean(true);
        this.ah = new AtomicBoolean(false);
        this.t = 0;
        this.w = false;
        this.x = false;
        this.ac = false;
        this.p = UUID.randomUUID().toString();
        this.ad = Boolean.FALSE;
        this.J = false;
        this.af = null;
        this.z = null;
        this.A = null;
        this.ag = null;
        this.B = null;
        this.E = false;
        this.F = false;
        this.H = false;
        this.K = false;
        this.aj = new CopyOnWriteArraySet<>();
        this.ak = new CopyOnWriteArraySet<>();
        this.al = new CopyOnWriteArraySet<>();
        this.M = null;
        this.am = null;
        this.N = null;
        this.e = null;
        this.L = 1;
        this.O = new com.ironsource.mediationsdk.impressionData.a();
        this.an = new com.ironsource.d.b();
        this.ao = new ai();
    }

    /* synthetic */ H(byte b2) {
        this();
    }

    private void A() {
        this.f.log(IronSourceLogger.IronSourceTag.INTERNAL, "Banner started in demand only mode", 0);
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < this.i.a.e.size(); i2++) {
            String str = this.i.a.e.get(i2);
            if (!TextUtils.isEmpty(str)) {
                arrayList.add(this.i.b.a(str));
            }
        }
        if (arrayList.size() > 0) {
            synchronized (this.al) {
                this.N = new C0164q(arrayList, this.i.c.d, this.j, this.k);
            }
            this.al.clear();
            return;
        }
        JSONObject mediationAdditionalData = IronSourceUtils.getMediationAdditionalData(false, false, 1);
        a(mediationAdditionalData, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, 1010}});
        b(IronSourceConstants.TROUBLESHOOTING_BN_INIT_FAILED, mediationAdditionalData);
        a(IronSource.AD_UNIT.BANNER, false);
    }

    private void B() {
        if (this.ad.booleanValue()) {
            this.ad = Boolean.FALSE;
            a(this.ae, this.af);
            this.ae = null;
            this.af = null;
        }
    }

    private boolean C() {
        l lVar = this.i;
        return (lVar == null || lVar.c == null || this.i.c.d == null) ? false : true;
    }

    private static boolean D() {
        return ContextProvider.getInstance().getCurrentActiveActivity() != null;
    }

    private void E() {
        if (this.ag != null && this.ah.compareAndSet(false, true)) {
            IronLog.CALLBACK.verbose("onInitializationCompleted()");
            com.ironsource.mediationsdk.a.h.e().b(new c(IronSourceConstants.TROUBLESHOOTING_INIT_COMPLETED, IronSourceUtils.getMediationAdditionalData(false)));
            this.ag.onInitializationComplete();
        }
    }

    private int a(o oVar) {
        return !this.ai && !this.F && oVar.l.n ? 2 : 1;
    }

    public static H a() {
        return b.a;
    }

    private l a(Context context, String str) {
        if (IronSourceUtils.isInitResponseCached(context)) {
            String cachedValueByKeyOfCachedInitResponse = IronSourceUtils.getCachedValueByKeyOfCachedInitResponse(context, "appKey");
            String cachedValueByKeyOfCachedInitResponse2 = IronSourceUtils.getCachedValueByKeyOfCachedInitResponse(context, "userId");
            String cachedValueByKeyOfCachedInitResponse3 = IronSourceUtils.getCachedValueByKeyOfCachedInitResponse(context, "response");
            String str2 = this.j;
            if (str2 != null && cachedValueByKeyOfCachedInitResponse.equals(str2) && cachedValueByKeyOfCachedInitResponse2.equals(str)) {
                l lVar = new l(context, cachedValueByKeyOfCachedInitResponse, cachedValueByKeyOfCachedInitResponse2, cachedValueByKeyOfCachedInitResponse3);
                lVar.e = l.a.b;
                return lVar;
            }
        }
        return null;
    }

    public static String a(Context context) {
        String[] C2 = com.ironsource.environment.h.C(context);
        return (C2 == null || C2.length != 2) ? "" : C2[0];
    }

    private static String a(String str, int i2) {
        if (i2 == 0) {
            return null;
        }
        int i3 = AnonymousClass1.b[i2 - 1];
        if (i3 != 1 && i3 != 2 && i3 != 3) {
            return null;
        }
        return "placement " + str + " is capped";
    }

    static void a(int i2, JSONObject jSONObject) {
        com.ironsource.mediationsdk.a.h.e().b(new c(i2, jSONObject));
    }

    private void a(IronSource.AD_UNIT ad_unit) {
        String str = ad_unit + " ad unit has already been initialized";
        this.f.log(IronSourceLogger.IronSourceTag.API, str, 3);
        IronSourceUtils.sendAutomationLog(str);
    }

    private void a(IronSource.AD_UNIT ad_unit, boolean z2) {
        int i2 = AnonymousClass1.a[ad_unit.ordinal()];
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 != 3) {
                    if (i2 == 4) {
                        synchronized (this.ad) {
                            if (this.ad.booleanValue()) {
                                this.ad = Boolean.FALSE;
                                C0157j.a().a(this.ae, new IronSourceError(IronSourceError.ERROR_BN_INIT_FAILED_AFTER_LOAD, "Init had failed"));
                                this.ae = null;
                                this.af = null;
                            }
                        }
                    }
                } else if (z2 || i() || this.Y.contains(ad_unit)) {
                    this.g.onOfferwallAvailable(false);
                }
            } else if (this.v) {
                Iterator<String> it = this.aj.iterator();
                while (it.hasNext()) {
                    A.a().a(it.next(), ErrorBuilder.buildInitFailedError("initISDemandOnly() had failed", IronSourceConstants.INTERSTITIAL_AD_UNIT));
                }
                this.aj.clear();
            } else if (this.J) {
                this.J = false;
                C0163p.a().a(IronSource.AD_UNIT.INTERSTITIAL, ErrorBuilder.buildInitFailedError("init() had failed", IronSourceConstants.INTERSTITIAL_AD_UNIT));
            }
        } else if (this.u) {
            Iterator<String> it2 = this.ak.iterator();
            while (it2.hasNext()) {
                Z.a().a(it2.next(), ErrorBuilder.buildInitFailedError("initISDemandOnly() had failed", IronSourceConstants.REWARDED_VIDEO_AD_UNIT));
            }
            this.ak.clear();
        } else if (this.F) {
            if (this.G) {
                this.G = false;
                C0163p.a().a(IronSource.AD_UNIT.REWARDED_VIDEO, ErrorBuilder.buildInitFailedError("init() had failed", IronSourceConstants.REWARDED_VIDEO_AD_UNIT));
            }
        } else if (z2 || d() || this.Y.contains(ad_unit)) {
            this.g.onRewardedVideoAvailabilityChanged(false);
        }
    }

    public static void a(ISDemandOnlyInterstitialListener iSDemandOnlyInterstitialListener) {
        A.a().a = iSDemandOnlyInterstitialListener;
    }

    static void a(ISDemandOnlyRewardedVideoListener iSDemandOnlyRewardedVideoListener) {
        Z.a().a = iSDemandOnlyRewardedVideoListener;
    }

    static void a(String str, com.ironsource.d.a aVar) {
        if (str != null) {
            try {
                if (str.length() > 64) {
                    aVar.a(ErrorBuilder.buildInvalidKeyValueError("segment", IronSourceConstants.SUPERSONIC_CONFIG_NAME, "segment value should not exceed 64 characters."));
                }
            } catch (Exception unused) {
                aVar.a(ErrorBuilder.buildInvalidKeyValueError("segment", IronSourceConstants.SUPERSONIC_CONFIG_NAME, "segment value should not exceed 64 characters."));
            }
        }
    }

    public static void a(String str, JSONObject jSONObject) {
        String str2 = "networkKey = " + str;
        if (jSONObject != null) {
            str2 = str2 + " networkData = " + jSONObject;
        }
        IronLog.API.verbose(str2);
        C0151d.a().a(str, jSONObject);
    }

    private void a(ArrayList<NetworkSettings> arrayList) {
        this.f.log(IronSourceLogger.IronSourceTag.INTERNAL, "Banner started in programmatic mode", 0);
        this.B = new P(arrayList, new com.ironsource.mediationsdk.c.b(this.j, IronSourceUtils.getUserIdForNetworks(), this.i.c.d), k.a().b(), this.s);
        B();
    }

    static void a(JSONObject jSONObject, Object[][] objArr) {
        int i2 = 0;
        while (i2 <= 0) {
            try {
                Object[] objArr2 = objArr[0];
                jSONObject.put(objArr2[0].toString(), objArr2[1]);
                i2++;
            } catch (Exception e2) {
                IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.INTERNAL, "IronSourceObject addToDictionary: " + Log.getStackTraceString(e2), 3);
                return;
            }
        }
    }

    public static void a(boolean z2) {
        IronSourceLoggerManager logger = IronSourceLoggerManager.getLogger();
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.API;
        logger.log(ironSourceTag, "setAdaptersDebug : " + z2, 1);
        C0151d.a().b(z2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:107:0x01d9, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0050, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x0115, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized void a(boolean r10, com.ironsource.mediationsdk.IronSource.AD_UNIT... r11) {
        /*
            r9 = this;
            monitor-enter(r9)
            int r0 = r11.length     // Catch:{ all -> 0x01da }
            r1 = 0
            r2 = r1
        L_0x0004:
            r3 = 1
            if (r2 >= r0) goto L_0x002c
            r4 = r11[r2]     // Catch:{ all -> 0x01da }
            com.ironsource.mediationsdk.IronSource$AD_UNIT r5 = com.ironsource.mediationsdk.IronSource.AD_UNIT.INTERSTITIAL     // Catch:{ all -> 0x01da }
            boolean r5 = r4.equals(r5)     // Catch:{ all -> 0x01da }
            if (r5 == 0) goto L_0x0014
            r9.x = r3     // Catch:{ all -> 0x01da }
            goto L_0x0029
        L_0x0014:
            com.ironsource.mediationsdk.IronSource$AD_UNIT r5 = com.ironsource.mediationsdk.IronSource.AD_UNIT.BANNER     // Catch:{ all -> 0x01da }
            boolean r5 = r4.equals(r5)     // Catch:{ all -> 0x01da }
            if (r5 == 0) goto L_0x001f
            r9.ac = r3     // Catch:{ all -> 0x01da }
            goto L_0x0029
        L_0x001f:
            com.ironsource.mediationsdk.IronSource$AD_UNIT r5 = com.ironsource.mediationsdk.IronSource.AD_UNIT.REWARDED_VIDEO     // Catch:{ all -> 0x01da }
            boolean r4 = r4.equals(r5)     // Catch:{ all -> 0x01da }
            if (r4 == 0) goto L_0x0029
            r9.w = r3     // Catch:{ all -> 0x01da }
        L_0x0029:
            int r2 = r2 + 1
            goto L_0x0004
        L_0x002c:
            com.ironsource.mediationsdk.M r0 = com.ironsource.mediationsdk.M.a()     // Catch:{ all -> 0x01da }
            com.ironsource.mediationsdk.M$a r0 = r0.b()     // Catch:{ all -> 0x01da }
            com.ironsource.mediationsdk.M$a r2 = com.ironsource.mediationsdk.M.a.INIT_FAILED     // Catch:{ all -> 0x01da }
            if (r0 != r2) goto L_0x0057
            com.ironsource.mediationsdk.sdk.i r10 = r9.g     // Catch:{ Exception -> 0x0051 }
            if (r10 == 0) goto L_0x004f
            int r10 = r11.length     // Catch:{ Exception -> 0x0051 }
        L_0x003d:
            if (r1 >= r10) goto L_0x004f
            r0 = r11[r1]     // Catch:{ Exception -> 0x0051 }
            java.util.Set<com.ironsource.mediationsdk.IronSource$AD_UNIT> r2 = r9.X     // Catch:{ Exception -> 0x0051 }
            boolean r2 = r2.contains(r0)     // Catch:{ Exception -> 0x0051 }
            if (r2 != 0) goto L_0x004c
            r9.a((com.ironsource.mediationsdk.IronSource.AD_UNIT) r0, (boolean) r3)     // Catch:{ Exception -> 0x0051 }
        L_0x004c:
            int r1 = r1 + 1
            goto L_0x003d
        L_0x004f:
            monitor-exit(r9)
            return
        L_0x0051:
            r10 = move-exception
            r10.printStackTrace()     // Catch:{ all -> 0x01da }
            monitor-exit(r9)
            return
        L_0x0057:
            boolean r0 = r9.V     // Catch:{ all -> 0x01da }
            r2 = 14
            if (r0 != 0) goto L_0x0116
            org.json.JSONObject r10 = com.ironsource.mediationsdk.utils.IronSourceUtils.getMediationAdditionalData(r10)     // Catch:{ all -> 0x01da }
            int r0 = r11.length     // Catch:{ all -> 0x01da }
            r4 = r1
        L_0x0063:
            if (r1 >= r0) goto L_0x00a3
            r5 = r11[r1]     // Catch:{ all -> 0x01da }
            java.util.Set<com.ironsource.mediationsdk.IronSource$AD_UNIT> r6 = r9.X     // Catch:{ all -> 0x01da }
            boolean r6 = r6.contains(r5)     // Catch:{ all -> 0x01da }
            if (r6 != 0) goto L_0x0087
            java.util.Set<com.ironsource.mediationsdk.IronSource$AD_UNIT> r4 = r9.X     // Catch:{ all -> 0x01da }
            r4.add(r5)     // Catch:{ all -> 0x01da }
            java.util.Set<com.ironsource.mediationsdk.IronSource$AD_UNIT> r4 = r9.Y     // Catch:{ all -> 0x01da }
            r4.add(r5)     // Catch:{ all -> 0x01da }
            java.lang.String r4 = r5.toString()     // Catch:{ Exception -> 0x0081 }
            r10.put(r4, r3)     // Catch:{ Exception -> 0x0081 }
            goto L_0x0085
        L_0x0081:
            r4 = move-exception
            r4.printStackTrace()     // Catch:{ all -> 0x01da }
        L_0x0085:
            r4 = r3
            goto L_0x00a0
        L_0x0087:
            com.ironsource.mediationsdk.logger.IronSourceLoggerManager r6 = r9.f     // Catch:{ all -> 0x01da }
            com.ironsource.mediationsdk.logger.IronSourceLogger$IronSourceTag r7 = com.ironsource.mediationsdk.logger.IronSourceLogger.IronSourceTag.API     // Catch:{ all -> 0x01da }
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ all -> 0x01da }
            r8.<init>()     // Catch:{ all -> 0x01da }
            r8.append(r5)     // Catch:{ all -> 0x01da }
            java.lang.String r5 = " ad unit has started initializing."
            r8.append(r5)     // Catch:{ all -> 0x01da }
            java.lang.String r5 = r8.toString()     // Catch:{ all -> 0x01da }
            r8 = 3
            r6.log(r7, r5, r8)     // Catch:{ all -> 0x01da }
        L_0x00a0:
            int r1 = r1 + 1
            goto L_0x0063
        L_0x00a3:
            if (r4 == 0) goto L_0x0114
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0104 }
            r11.<init>()     // Catch:{ Exception -> 0x0104 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0104 }
            java.lang.String r1 = ",androidx="
            r0.<init>(r1)     // Catch:{ Exception -> 0x0104 }
            boolean r1 = com.ironsource.mediationsdk.utils.IronSourceUtils.isAndroidXAvailable()     // Catch:{ Exception -> 0x0104 }
            r0.append(r1)     // Catch:{ Exception -> 0x0104 }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x0104 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0104 }
            java.lang.String r4 = ",Activity="
            r1.<init>(r4)     // Catch:{ Exception -> 0x0104 }
            boolean r4 = D()     // Catch:{ Exception -> 0x0104 }
            r1.append(r4)     // Catch:{ Exception -> 0x0104 }
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x0104 }
            boolean r4 = com.ironsource.environment.a.AnonymousClass1.d()     // Catch:{ Exception -> 0x0104 }
            if (r4 == 0) goto L_0x00e1
            java.lang.String r4 = "appLanguage=Kotlin"
            r11.append(r4)     // Catch:{ Exception -> 0x0104 }
            java.lang.String r4 = com.ironsource.environment.a.AnonymousClass1.c()     // Catch:{ Exception -> 0x0104 }
        L_0x00dd:
            r11.append(r4)     // Catch:{ Exception -> 0x0104 }
            goto L_0x00e4
        L_0x00e1:
            java.lang.String r4 = "appLanguage=Java"
            goto L_0x00dd
        L_0x00e4:
            r11.append(r0)     // Catch:{ Exception -> 0x0104 }
            boolean r0 = r9.m()     // Catch:{ Exception -> 0x0104 }
            if (r0 == 0) goto L_0x00f0
            r11.append(r1)     // Catch:{ Exception -> 0x0104 }
        L_0x00f0:
            java.lang.String r0 = "ext1"
            java.lang.String r11 = r11.toString()     // Catch:{ Exception -> 0x0104 }
            r10.put(r0, r11)     // Catch:{ Exception -> 0x0104 }
            java.lang.String r11 = "sessionDepth"
            int r0 = r9.t     // Catch:{ Exception -> 0x0104 }
            int r0 = r0 + r3
            r9.t = r0     // Catch:{ Exception -> 0x0104 }
            r10.put(r11, r0)     // Catch:{ Exception -> 0x0104 }
            goto L_0x0108
        L_0x0104:
            r11 = move-exception
            r11.printStackTrace()     // Catch:{ all -> 0x01da }
        L_0x0108:
            com.ironsource.mediationsdk.a.c r11 = new com.ironsource.mediationsdk.a.c     // Catch:{ all -> 0x01da }
            r11.<init>(r2, r10)     // Catch:{ all -> 0x01da }
            com.ironsource.mediationsdk.a.h r10 = com.ironsource.mediationsdk.a.h.e()     // Catch:{ all -> 0x01da }
            r10.b((com.ironsource.mediationsdk.a.c) r11)     // Catch:{ all -> 0x01da }
        L_0x0114:
            monitor-exit(r9)
            return
        L_0x0116:
            com.ironsource.mediationsdk.M r0 = com.ironsource.mediationsdk.M.a()     // Catch:{ all -> 0x01da }
            r0.b(r10)     // Catch:{ all -> 0x01da }
            java.util.List<com.ironsource.mediationsdk.IronSource$AD_UNIT> r0 = r9.W     // Catch:{ all -> 0x01da }
            if (r0 != 0) goto L_0x0123
            monitor-exit(r9)
            return
        L_0x0123:
            org.json.JSONObject r10 = com.ironsource.mediationsdk.utils.IronSourceUtils.getMediationAdditionalData(r10)     // Catch:{ all -> 0x01da }
            int r0 = r11.length     // Catch:{ all -> 0x01da }
            r4 = r1
            r5 = r4
        L_0x012a:
            if (r4 >= r0) goto L_0x0167
            r6 = r11[r4]     // Catch:{ all -> 0x01da }
            java.util.Set<com.ironsource.mediationsdk.IronSource$AD_UNIT> r7 = r9.X     // Catch:{ all -> 0x01da }
            boolean r7 = r7.contains(r6)     // Catch:{ all -> 0x01da }
            if (r7 != 0) goto L_0x0161
            java.util.Set<com.ironsource.mediationsdk.IronSource$AD_UNIT> r5 = r9.X     // Catch:{ all -> 0x01da }
            r5.add(r6)     // Catch:{ all -> 0x01da }
            java.util.Set<com.ironsource.mediationsdk.IronSource$AD_UNIT> r5 = r9.Y     // Catch:{ all -> 0x01da }
            r5.add(r6)     // Catch:{ all -> 0x01da }
            java.lang.String r5 = r6.toString()     // Catch:{ Exception -> 0x0148 }
            r10.put(r5, r3)     // Catch:{ Exception -> 0x0148 }
            goto L_0x014c
        L_0x0148:
            r5 = move-exception
            r5.printStackTrace()     // Catch:{ all -> 0x01da }
        L_0x014c:
            java.util.List<com.ironsource.mediationsdk.IronSource$AD_UNIT> r5 = r9.W     // Catch:{ all -> 0x01da }
            if (r5 == 0) goto L_0x015c
            java.util.List<com.ironsource.mediationsdk.IronSource$AD_UNIT> r5 = r9.W     // Catch:{ all -> 0x01da }
            boolean r5 = r5.contains(r6)     // Catch:{ all -> 0x01da }
            if (r5 == 0) goto L_0x015c
            r9.b((com.ironsource.mediationsdk.IronSource.AD_UNIT) r6)     // Catch:{ all -> 0x01da }
            goto L_0x015f
        L_0x015c:
            r9.a((com.ironsource.mediationsdk.IronSource.AD_UNIT) r6, (boolean) r1)     // Catch:{ all -> 0x01da }
        L_0x015f:
            r5 = r3
            goto L_0x0164
        L_0x0161:
            r9.a((com.ironsource.mediationsdk.IronSource.AD_UNIT) r6)     // Catch:{ all -> 0x01da }
        L_0x0164:
            int r4 = r4 + 1
            goto L_0x012a
        L_0x0167:
            if (r5 == 0) goto L_0x01d8
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x01c8 }
            r11.<init>()     // Catch:{ Exception -> 0x01c8 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x01c8 }
            java.lang.String r1 = ",androidx="
            r0.<init>(r1)     // Catch:{ Exception -> 0x01c8 }
            boolean r1 = com.ironsource.mediationsdk.utils.IronSourceUtils.isAndroidXAvailable()     // Catch:{ Exception -> 0x01c8 }
            r0.append(r1)     // Catch:{ Exception -> 0x01c8 }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x01c8 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x01c8 }
            java.lang.String r4 = ",Activity="
            r1.<init>(r4)     // Catch:{ Exception -> 0x01c8 }
            boolean r4 = D()     // Catch:{ Exception -> 0x01c8 }
            r1.append(r4)     // Catch:{ Exception -> 0x01c8 }
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x01c8 }
            boolean r4 = com.ironsource.environment.a.AnonymousClass1.d()     // Catch:{ Exception -> 0x01c8 }
            if (r4 == 0) goto L_0x01a5
            java.lang.String r4 = "appLanguage=Kotlin"
            r11.append(r4)     // Catch:{ Exception -> 0x01c8 }
            java.lang.String r4 = com.ironsource.environment.a.AnonymousClass1.c()     // Catch:{ Exception -> 0x01c8 }
        L_0x01a1:
            r11.append(r4)     // Catch:{ Exception -> 0x01c8 }
            goto L_0x01a8
        L_0x01a5:
            java.lang.String r4 = "appLanguage=Java"
            goto L_0x01a1
        L_0x01a8:
            r11.append(r0)     // Catch:{ Exception -> 0x01c8 }
            boolean r0 = r9.m()     // Catch:{ Exception -> 0x01c8 }
            if (r0 == 0) goto L_0x01b4
            r11.append(r1)     // Catch:{ Exception -> 0x01c8 }
        L_0x01b4:
            java.lang.String r0 = "ext1"
            java.lang.String r11 = r11.toString()     // Catch:{ Exception -> 0x01c8 }
            r10.put(r0, r11)     // Catch:{ Exception -> 0x01c8 }
            java.lang.String r11 = "sessionDepth"
            int r0 = r9.t     // Catch:{ Exception -> 0x01c8 }
            int r0 = r0 + r3
            r9.t = r0     // Catch:{ Exception -> 0x01c8 }
            r10.put(r11, r0)     // Catch:{ Exception -> 0x01c8 }
            goto L_0x01cc
        L_0x01c8:
            r11 = move-exception
            r11.printStackTrace()     // Catch:{ all -> 0x01da }
        L_0x01cc:
            com.ironsource.mediationsdk.a.c r11 = new com.ironsource.mediationsdk.a.c     // Catch:{ all -> 0x01da }
            r11.<init>(r2, r10)     // Catch:{ all -> 0x01da }
            com.ironsource.mediationsdk.a.h r10 = com.ironsource.mediationsdk.a.h.e()     // Catch:{ all -> 0x01da }
            r10.b((com.ironsource.mediationsdk.a.c) r11)     // Catch:{ all -> 0x01da }
        L_0x01d8:
            monitor-exit(r9)
            return
        L_0x01da:
            r10 = move-exception
            monitor-exit(r9)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.mediationsdk.H.a(boolean, com.ironsource.mediationsdk.IronSource$AD_UNIT[]):void");
    }

    private static boolean a(C0149b bVar) {
        return bVar.k > 0 && bVar.l > 0;
    }

    private static boolean a(String str, int i2, int i3) {
        return str != null && str.length() >= i2 && str.length() <= i3;
    }

    private l b(Context context, String str, a aVar) {
        l lVar;
        if (!IronSourceUtils.isNetworkConnected(context)) {
            return null;
        }
        try {
            String a2 = a(context);
            if (TextUtils.isEmpty(a2)) {
                a2 = com.ironsource.environment.h.x(context);
                IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.INTERNAL, "using custom identifier", 1);
            }
            String stringFromURL = HttpFunctions.getStringFromURL(ServerURL.getCPVProvidersURL(context, this.j, str, a2, this.o, this.F, this.s != null ? this.s.a() : null), aVar);
            if (stringFromURL == null) {
                IronLog.INTERNAL.warning("serverResponseString is null");
                return null;
            }
            if (IronSourceUtils.getSerr() == 1) {
                IronLog.INTERNAL.verbose("encrypt");
                String optString = new JSONObject(stringFromURL).optString("response", (String) null);
                if (TextUtils.isEmpty(optString)) {
                    IronLog.INTERNAL.warning("encryptedResponse is empty - return null");
                    return null;
                }
                stringFromURL = IronSourceAES.decode(com.ironsource.mediationsdk.utils.g.a().b(), optString);
                if (TextUtils.isEmpty(stringFromURL)) {
                    IronLog.INTERNAL.warning("encoded response invalid - return null");
                    if (!ap) {
                        ap = true;
                        JSONObject mediationAdditionalData = IronSourceUtils.getMediationAdditionalData(false);
                        try {
                            mediationAdditionalData.put("status", "false");
                            mediationAdditionalData.put(IronSourceConstants.EVENTS_ERROR_CODE, 1);
                        } catch (JSONException e2) {
                            e2.printStackTrace();
                        }
                        com.ironsource.mediationsdk.a.h.e().b(new c(114, mediationAdditionalData));
                    }
                    return null;
                }
            }
            lVar = new l(context, this.j, str, stringFromURL);
            try {
                lVar.e = l.a.c;
                if (!lVar.b()) {
                    IronLog.INTERNAL.warning("response invalid - return null");
                    return null;
                }
            } catch (Exception e3) {
                e = e3;
                IronLog.INTERNAL.warning("exception = " + e);
                e.printStackTrace();
                return lVar;
            }
            return lVar;
        } catch (Exception e4) {
            e = e4;
            lVar = null;
            IronLog.INTERNAL.warning("exception = " + e);
            e.printStackTrace();
            return lVar;
        }
    }

    private static void b(int i2, JSONObject jSONObject) {
        d.e().b(new c(i2, jSONObject));
    }

    private void b(IronSource.AD_UNIT ad_unit) {
        int i2 = AnonymousClass1.a[ad_unit.ordinal()];
        if (i2 == 1) {
            q();
        } else if (i2 == 2) {
            y();
        } else if (i2 == 3) {
            this.d.a(this.j, this.k);
        } else if (i2 == 4) {
            z();
        }
    }

    /* JADX WARNING: type inference failed for: r0v10, types: [com.ironsource.mediationsdk.z] */
    /* JADX WARNING: type inference failed for: r4v4, types: [com.ironsource.mediationsdk.V] */
    /* JADX WARNING: type inference failed for: r4v5, types: [com.ironsource.mediationsdk.I] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void n() {
        /*
            r11 = this;
            com.ironsource.mediationsdk.logger.IronSourceLoggerManager r0 = r11.f
            com.ironsource.mediationsdk.logger.IronSourceLogger$IronSourceTag r1 = com.ironsource.mediationsdk.logger.IronSourceLogger.IronSourceTag.INTERNAL
            r2 = 0
            java.lang.String r3 = "Rewarded Video started in programmatic mode"
            r0.log(r1, r3, r2)
            java.util.List r5 = r11.s()
            int r0 = r5.size()
            if (r0 <= 0) goto L_0x007a
            com.ironsource.mediationsdk.utils.l r0 = r11.i
            com.ironsource.mediationsdk.model.g r0 = r0.c
            com.ironsource.mediationsdk.model.o r0 = r0.a
            com.ironsource.mediationsdk.utils.c r0 = r0.l
            boolean r0 = r0.n
            if (r0 == 0) goto L_0x003d
            com.ironsource.mediationsdk.I r0 = new com.ironsource.mediationsdk.I
            com.ironsource.mediationsdk.utils.l r1 = r11.i
            com.ironsource.mediationsdk.model.g r1 = r1.c
            com.ironsource.mediationsdk.model.o r6 = r1.a
            java.lang.String r7 = r11.j
            java.lang.String r8 = com.ironsource.mediationsdk.utils.IronSourceUtils.getUserIdForNetworks()
            com.ironsource.mediationsdk.utils.k r1 = com.ironsource.mediationsdk.utils.k.a()
            java.util.HashSet r9 = r1.b()
            com.ironsource.mediationsdk.IronSourceSegment r10 = r11.s
            r4 = r0
            r4.<init>(r5, r6, r7, r8, r9, r10)
            goto L_0x0059
        L_0x003d:
            com.ironsource.mediationsdk.V r0 = new com.ironsource.mediationsdk.V
            com.ironsource.mediationsdk.utils.l r1 = r11.i
            com.ironsource.mediationsdk.model.g r1 = r1.c
            com.ironsource.mediationsdk.model.o r6 = r1.a
            java.lang.String r7 = r11.j
            java.lang.String r8 = com.ironsource.mediationsdk.utils.IronSourceUtils.getUserIdForNetworks()
            com.ironsource.mediationsdk.utils.k r1 = com.ironsource.mediationsdk.utils.k.a()
            java.util.HashSet r9 = r1.b()
            com.ironsource.mediationsdk.IronSourceSegment r10 = r11.s
            r4 = r0
            r4.<init>(r5, r6, r7, r8, r9, r10)
        L_0x0059:
            r11.z = r0
            java.lang.Boolean r0 = r11.r
            if (r0 == 0) goto L_0x00a2
            com.ironsource.mediationsdk.z r1 = r11.z
            android.content.Context r3 = r11.q
            boolean r0 = r0.booleanValue()
            r1.a(r3, r0)
            java.lang.Boolean r0 = r11.r
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L_0x00a2
            com.ironsource.mediationsdk.ab r0 = r11.b
            android.content.Context r1 = r11.q
            r0.a((android.content.Context) r1, (boolean) r2)
            return
        L_0x007a:
            int r0 = r11.L
            r1 = 1
            org.json.JSONObject r0 = com.ironsource.mediationsdk.utils.IronSourceUtils.getMediationAdditionalData(r2, r1, r0)
            java.lang.Object[][] r3 = new java.lang.Object[r1][]
            r4 = 2
            java.lang.Object[] r4 = new java.lang.Object[r4]
            java.lang.String r5 = "errorCode"
            r4[r2] = r5
            r5 = 1010(0x3f2, float:1.415E-42)
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            r4[r1] = r5
            r3[r2] = r4
            a((org.json.JSONObject) r0, (java.lang.Object[][]) r3)
            r1 = 81314(0x13da2, float:1.13945E-40)
            a((int) r1, (org.json.JSONObject) r0)
            com.ironsource.mediationsdk.IronSource$AD_UNIT r0 = com.ironsource.mediationsdk.IronSource.AD_UNIT.REWARDED_VIDEO
            r11.a((com.ironsource.mediationsdk.IronSource.AD_UNIT) r0, (boolean) r2)
        L_0x00a2:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.mediationsdk.H.n():void");
    }

    private void o() {
        this.f.log(IronSourceLogger.IronSourceTag.INTERNAL, "Rewarded Video started in demand only mode", 0);
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < this.i.a.a.size(); i2++) {
            String str = this.i.a.a.get(i2);
            if (!TextUtils.isEmpty(str)) {
                arrayList.add(this.i.b.a(str));
            }
        }
        if (arrayList.size() > 0) {
            synchronized (this.ak) {
                this.am = new C0168u(arrayList, this.i.c.a, this.j, this.k);
            }
            if (ContextProvider.getInstance().getCurrentActiveActivity() == null) {
                a(IronSource.AD_UNIT.REWARDED_VIDEO, false);
                return;
            }
            Iterator<String> it = this.ak.iterator();
            while (it.hasNext()) {
                this.am.a(it.next(), (String) null, false);
            }
            this.ak.clear();
            return;
        }
        a(IronSource.AD_UNIT.REWARDED_VIDEO, false);
    }

    private Placement p(String str) {
        o oVar = this.i.c.a;
        if (oVar != null) {
            Iterator<Placement> it = oVar.a.iterator();
            while (it.hasNext()) {
                Placement next = it.next();
                if (next.getPlacementName().equals(str)) {
                    return next;
                }
            }
        }
        return null;
    }

    private void p() {
        NetworkSettings a2;
        NetworkSettings a3;
        NetworkSettings a4;
        o oVar = this.i.c.a;
        int i2 = oVar.e;
        for (int i3 = 0; i3 < this.i.a.a.size(); i3++) {
            String str = this.i.a.a.get(i3);
            if (!TextUtils.isEmpty(str) && (a4 = this.i.b.a(str)) != null) {
                ac acVar = new ac(a4, i2);
                if (a((C0149b) acVar)) {
                    ab abVar = this.b;
                    acVar.s = abVar;
                    acVar.n = i3 + 1;
                    abVar.a(acVar);
                }
            }
        }
        if (this.b.c.size() > 0) {
            this.b.n = oVar.b.a();
            this.b.b = oVar.c;
            this.b.o = oVar.h;
            String c2 = this.i.c();
            if (!TextUtils.isEmpty(c2) && (a3 = this.i.b.a(c2)) != null) {
                ac acVar2 = new ac(a3, i2);
                if (a((C0149b) acVar2)) {
                    ab abVar2 = this.b;
                    acVar2.s = abVar2;
                    abVar2.h.log(IronSourceLogger.IronSourceTag.INTERNAL, acVar2.d + " is set as backfill", 0);
                    abVar2.d = acVar2;
                }
            }
            String d2 = this.i.d();
            if (!TextUtils.isEmpty(d2) && (a2 = this.i.b.a(d2)) != null) {
                ac acVar3 = new ac(a2, i2);
                if (a((C0149b) acVar3)) {
                    ab abVar3 = this.b;
                    acVar3.s = abVar3;
                    abVar3.h.log(IronSourceLogger.IronSourceTag.INTERNAL, acVar3.d + " is set as premium", 0);
                    abVar3.e = acVar3;
                }
            }
            ab abVar4 = this.b;
            abVar4.p = new C0171x(oVar.i, abVar4);
            this.b.a(this.j, IronSourceUtils.getUserIdForNetworks());
            return;
        }
        JSONObject mediationAdditionalData = IronSourceUtils.getMediationAdditionalData(false, false, this.L);
        a(mediationAdditionalData, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, 1010}});
        a((int) IronSourceConstants.TROUBLESHOOTING_RV_INIT_FAILED, mediationAdditionalData);
        a(IronSource.AD_UNIT.REWARDED_VIDEO, false);
    }

    private void q() {
        if (this.u) {
            o();
            return;
        }
        o oVar = this.i.c.a;
        this.E = oVar.l.a || this.F;
        this.ai = oVar.l.b;
        this.L = a(oVar);
        a((int) IronSourceConstants.TROUBLESHOOTING_RV_FORK, IronSourceUtils.getMediationAdditionalData(false, this.E, this.L));
        if (this.F || this.ai) {
            r();
        } else if (this.E) {
            n();
        } else {
            p();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x003d  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0043  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void q(java.lang.String r6) {
        /*
            r5 = this;
            r0 = 3
            com.ironsource.mediationsdk.model.Placement r6 = r5.p(r6)     // Catch:{ Exception -> 0x0026 }
            if (r6 != 0) goto L_0x000e
            com.ironsource.mediationsdk.model.Placement r6 = r5.b()     // Catch:{ Exception -> 0x000c }
            goto L_0x000e
        L_0x000c:
            r1 = move-exception
            goto L_0x0028
        L_0x000e:
            if (r6 != 0) goto L_0x0031
            java.lang.String r1 = "showProgrammaticRewardedVideo error: empty default placement in response"
            com.ironsource.mediationsdk.logger.IronSourceLoggerManager r2 = r5.f     // Catch:{ Exception -> 0x000c }
            com.ironsource.mediationsdk.logger.IronSourceLogger$IronSourceTag r3 = com.ironsource.mediationsdk.logger.IronSourceLogger.IronSourceTag.INTERNAL     // Catch:{ Exception -> 0x000c }
            r2.log(r3, r1, r0)     // Catch:{ Exception -> 0x000c }
            com.ironsource.mediationsdk.logger.IronSourceError r2 = new com.ironsource.mediationsdk.logger.IronSourceError     // Catch:{ Exception -> 0x000c }
            r3 = 1021(0x3fd, float:1.431E-42)
            r2.<init>(r3, r1)     // Catch:{ Exception -> 0x000c }
            com.ironsource.mediationsdk.sdk.i r1 = r5.g     // Catch:{ Exception -> 0x000c }
            r1.onRewardedVideoAdShowFailed(r2)     // Catch:{ Exception -> 0x000c }
            return
        L_0x0026:
            r1 = move-exception
            r6 = 0
        L_0x0028:
            com.ironsource.mediationsdk.logger.IronSourceLoggerManager r2 = r5.f
            com.ironsource.mediationsdk.logger.IronSourceLogger$IronSourceTag r3 = com.ironsource.mediationsdk.logger.IronSourceLogger.IronSourceTag.API
            java.lang.String r4 = "showProgrammaticRewardedVideo()"
            r2.logException(r3, r4, r1)
        L_0x0031:
            com.ironsource.mediationsdk.adunit.c.h r1 = r5.D
            if (r1 == 0) goto L_0x0043
            boolean r1 = r5.F
            if (r1 != 0) goto L_0x003d
            boolean r1 = r5.ai
            if (r1 == 0) goto L_0x0043
        L_0x003d:
            com.ironsource.mediationsdk.adunit.c.h r0 = r5.D
            r0.a((com.ironsource.mediationsdk.model.Placement) r6)
            return
        L_0x0043:
            com.ironsource.mediationsdk.z r1 = r5.z
            if (r1 == 0) goto L_0x004b
            r1.a(r6)
            return
        L_0x004b:
            java.lang.String r6 = "showProgrammaticRewardedVideo - show called before init completed, managers not initiated yet"
            com.ironsource.mediationsdk.logger.IronSourceLoggerManager r1 = r5.f
            com.ironsource.mediationsdk.logger.IronSourceLogger$IronSourceTag r2 = com.ironsource.mediationsdk.logger.IronSourceLogger.IronSourceTag.API
            r1.log(r2, r6, r0)
            com.ironsource.mediationsdk.logger.IronSourceError r0 = new com.ironsource.mediationsdk.logger.IronSourceError
            r1 = 1023(0x3ff, float:1.434E-42)
            r0.<init>(r1, r6)
            com.ironsource.mediationsdk.sdk.i r6 = r5.g
            r6.onRewardedVideoAdShowFailed(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.mediationsdk.H.q(java.lang.String):void");
    }

    private Placement r(String str) {
        Placement p2 = p(str);
        if (p2 == null) {
            this.f.log(IronSourceLogger.IronSourceTag.API, "Placement is not valid, please make sure you are using the right placements, using the default placement.", 3);
            p2 = b();
            if (p2 == null) {
                this.f.log(IronSourceLogger.IronSourceTag.API, "Default placement was not found, please make sure you are using the right placements.", 3);
                return null;
            }
        }
        String a2 = a(p2.getPlacementName(), k.b(ContextProvider.getInstance().getApplicationContext(), p2));
        if (TextUtils.isEmpty(a2)) {
            return p2;
        }
        this.f.log(IronSourceLogger.IronSourceTag.API, a2, 1);
        this.g.onRewardedVideoAdShowFailed(ErrorBuilder.buildCappedPerPlacementError(a2));
        return null;
    }

    private void r() {
        IronLog.INTERNAL.verbose("");
        List<NetworkSettings> s2 = s();
        if (s2.size() > 0) {
            this.D = new h(s2, this.i.c.a, IronSourceUtils.getUserIdForNetworks(), this.F, k.a().b(), this.s);
            Boolean bool = this.r;
            if (bool != null) {
                this.D.b(bool.booleanValue());
            }
            if (this.G && this.F) {
                this.G = false;
                this.D.e();
                return;
            }
            return;
        }
        JSONObject mediationAdditionalData = IronSourceUtils.getMediationAdditionalData(false, true, this.L);
        a(mediationAdditionalData, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, 1010}});
        a((int) IronSourceConstants.TROUBLESHOOTING_RV_INIT_FAILED, mediationAdditionalData);
        a(IronSource.AD_UNIT.REWARDED_VIDEO, false);
    }

    private InterstitialPlacement s(String str) {
        com.ironsource.mediationsdk.model.h hVar = this.i.c.b;
        if (hVar != null) {
            Iterator<InterstitialPlacement> it = hVar.a.iterator();
            while (it.hasNext()) {
                InterstitialPlacement next = it.next();
                if (next.getPlacementName().equals(str)) {
                    return next;
                }
            }
        }
        return null;
    }

    private List<NetworkSettings> s() {
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < this.i.a.a.size(); i2++) {
            String str = this.i.a.a.get(i2);
            if (!TextUtils.isEmpty(str)) {
                arrayList.add(this.i.b.a(str));
            }
        }
        return arrayList;
    }

    private List<NetworkSettings> t() {
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < this.i.a.d.size(); i2++) {
            String str = this.i.a.d.get(i2);
            if (!TextUtils.isEmpty(str)) {
                arrayList.add(this.i.b.a(str));
            }
        }
        return arrayList;
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0040  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void t(java.lang.String r5) {
        /*
            r4 = this;
            com.ironsource.mediationsdk.model.InterstitialPlacement r5 = r4.s(r5)     // Catch:{ Exception -> 0x0026 }
            if (r5 != 0) goto L_0x000d
            com.ironsource.mediationsdk.model.InterstitialPlacement r5 = r4.e()     // Catch:{ Exception -> 0x000b }
            goto L_0x000d
        L_0x000b:
            r0 = move-exception
            goto L_0x0028
        L_0x000d:
            if (r5 != 0) goto L_0x0031
            java.lang.String r0 = "showProgrammaticInterstitial error: empty default placement in response"
            com.ironsource.mediationsdk.logger.IronSourceLoggerManager r1 = r4.f     // Catch:{ Exception -> 0x000b }
            com.ironsource.mediationsdk.logger.IronSourceLogger$IronSourceTag r2 = com.ironsource.mediationsdk.logger.IronSourceLogger.IronSourceTag.INTERNAL     // Catch:{ Exception -> 0x000b }
            r3 = 3
            r1.log(r2, r0, r3)     // Catch:{ Exception -> 0x000b }
            com.ironsource.mediationsdk.logger.IronSourceError r1 = new com.ironsource.mediationsdk.logger.IronSourceError     // Catch:{ Exception -> 0x000b }
            r2 = 1020(0x3fc, float:1.43E-42)
            r1.<init>(r2, r0)     // Catch:{ Exception -> 0x000b }
            com.ironsource.mediationsdk.sdk.i r0 = r4.g     // Catch:{ Exception -> 0x000b }
            r0.onInterstitialAdShowFailed(r1)     // Catch:{ Exception -> 0x000b }
            return
        L_0x0026:
            r0 = move-exception
            r5 = 0
        L_0x0028:
            com.ironsource.mediationsdk.logger.IronSourceLoggerManager r1 = r4.f
            com.ironsource.mediationsdk.logger.IronSourceLogger$IronSourceTag r2 = com.ironsource.mediationsdk.logger.IronSourceLogger.IronSourceTag.API
            java.lang.String r3 = "showProgrammaticInterstitial()"
            r1.logException(r2, r3, r0)
        L_0x0031:
            boolean r0 = r4.I
            if (r0 == 0) goto L_0x0040
            com.ironsource.mediationsdk.adunit.c.g r0 = r4.C
            com.ironsource.mediationsdk.model.Placement r1 = new com.ironsource.mediationsdk.model.Placement
            r1.<init>(r5)
            r0.a((com.ironsource.mediationsdk.model.Placement) r1)
            return
        L_0x0040:
            com.ironsource.mediationsdk.S r0 = r4.A
            java.lang.String r5 = r5.getPlacementName()
            r0.a((java.lang.String) r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.mediationsdk.H.t(java.lang.String):void");
    }

    private InterstitialPlacement u(String str) {
        InterstitialPlacement s2 = s(str);
        if (s2 == null) {
            this.f.log(IronSourceLogger.IronSourceTag.API, "Placement is not valid, please make sure you are using the right placements, using the default placement.", 3);
            s2 = e();
            if (s2 == null) {
                this.f.log(IronSourceLogger.IronSourceTag.API, "Default placement was not found, please make sure you are using the right placements.", 3);
                return null;
            }
        }
        String a2 = a(s2.getPlacementName(), w(s2.getPlacementName()));
        if (TextUtils.isEmpty(a2)) {
            return s2;
        }
        this.f.log(IronSourceLogger.IronSourceTag.API, a2, 1);
        com.ironsource.mediationsdk.sdk.i iVar = this.g;
        iVar.e = s2;
        iVar.onInterstitialAdShowFailed(ErrorBuilder.buildCappedPerPlacementError(a2));
        return null;
    }

    private void u() {
        IronLog.INTERNAL.verbose("");
        List<NetworkSettings> t2 = t();
        if (t2.size() > 0) {
            this.C = new g(t2, this.i.c.b, IronSourceUtils.getUserIdForNetworks(), k.a().b(), this.s);
            Boolean bool = this.r;
            if (bool != null) {
                this.C.b(bool.booleanValue());
            }
            if (this.J) {
                this.J = false;
                this.C.e();
                return;
            }
            return;
        }
        JSONObject mediationAdditionalData = IronSourceUtils.getMediationAdditionalData(false, true, 1);
        a(mediationAdditionalData, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, 1010}});
        b(IronSourceConstants.TROUBLESHOOTING_IS_INIT_FAILED, mediationAdditionalData);
        a(IronSource.AD_UNIT.INTERSTITIAL, false);
    }

    private void v() {
        this.f.log(IronSourceLogger.IronSourceTag.INTERNAL, "Adunit: Interstitial is now initiated - programmatic mode", 0);
        List<NetworkSettings> t2 = t();
        if (t2.size() > 0) {
            this.A = new S(t2, this.i.c.b, this.j, IronSourceUtils.getUserIdForNetworks(), this.i.c.b.f, k.a().b(), this.s);
            Boolean bool = this.r;
            if (bool != null) {
                this.A.a(bool.booleanValue());
                if (this.r.booleanValue()) {
                    this.c.a(this.q, false);
                }
            }
            if (this.J) {
                this.J = false;
                this.A.d();
                return;
            }
            return;
        }
        JSONObject mediationAdditionalData = IronSourceUtils.getMediationAdditionalData(false, true, 1);
        a(mediationAdditionalData, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, 1010}});
        b(IronSourceConstants.TROUBLESHOOTING_IS_INIT_FAILED, mediationAdditionalData);
        a(IronSource.AD_UNIT.INTERSTITIAL, false);
    }

    private static boolean v(String str) {
        if (str == null) {
            return false;
        }
        return str.matches("^[a-zA-Z0-9]*$");
    }

    private int w(String str) {
        l lVar = this.i;
        if (lVar == null || lVar.c == null || this.i.c.b == null) {
            return k.a.d;
        }
        InterstitialPlacement interstitialPlacement = null;
        try {
            interstitialPlacement = s(str);
            if (interstitialPlacement == null && (interstitialPlacement = e()) == null) {
                this.f.log(IronSourceLogger.IronSourceTag.API, "Default placement was not found", 3);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return interstitialPlacement == null ? k.a.d : k.b(ContextProvider.getInstance().getApplicationContext(), interstitialPlacement);
    }

    private void w() {
        NetworkSettings a2;
        com.ironsource.mediationsdk.model.h hVar = this.i.c.b;
        int i2 = hVar.e;
        this.c.n.a(IronSource.AD_UNIT.INTERSTITIAL, hVar.f);
        for (int i3 = 0; i3 < this.i.a.d.size(); i3++) {
            String str = this.i.a.d.get(i3);
            if (!TextUtils.isEmpty(str) && (a2 = this.i.b.a(str)) != null) {
                F f2 = new F(a2, i2);
                if (a((C0149b) f2)) {
                    E e2 = this.c;
                    f2.s = e2;
                    f2.n = i3 + 1;
                    e2.a(f2);
                }
            }
        }
        if (this.c.c.size() > 0) {
            int i4 = hVar.c;
            E e3 = this.c;
            e3.b = i4;
            e3.a(this.j, IronSourceUtils.getUserIdForNetworks());
            if (this.J) {
                this.J = false;
                this.c.c();
                return;
            }
            return;
        }
        JSONObject mediationAdditionalData = IronSourceUtils.getMediationAdditionalData(false, false, 1);
        a(mediationAdditionalData, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, 1010}});
        b(IronSourceConstants.TROUBLESHOOTING_IS_INIT_FAILED, mediationAdditionalData);
        a(IronSource.AD_UNIT.INTERSTITIAL, false);
    }

    private f x(String str) {
        e eVar = this.i.c.d;
        if (eVar == null) {
            return null;
        }
        if (TextUtils.isEmpty(str)) {
            return eVar.a();
        }
        f a2 = eVar.a(str);
        return a2 != null ? a2 : eVar.a();
    }

    private void x() {
        this.f.log(IronSourceLogger.IronSourceTag.INTERNAL, "Interstitial started in demand only mode", 0);
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < this.i.a.d.size(); i2++) {
            String str = this.i.a.d.get(i2);
            if (!TextUtils.isEmpty(str)) {
                arrayList.add(this.i.b.a(str));
            }
        }
        if (arrayList.size() > 0) {
            synchronized (this.aj) {
                this.M = new C0166s(arrayList, this.i.c.b, this.j, this.k);
            }
            Iterator<String> it = this.aj.iterator();
            while (it.hasNext()) {
                this.M.a(it.next(), (String) null, false);
            }
            this.aj.clear();
            return;
        }
        JSONObject mediationAdditionalData = IronSourceUtils.getMediationAdditionalData(false, false, 1);
        a(mediationAdditionalData, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, 1010}});
        b(IronSourceConstants.TROUBLESHOOTING_IS_INIT_FAILED, mediationAdditionalData);
        a(IronSource.AD_UNIT.INTERSTITIAL, false);
    }

    private void y() {
        if (this.v) {
            x();
            return;
        }
        com.ironsource.mediationsdk.model.h hVar = this.i.c.b;
        this.H = hVar.i.a;
        this.I = hVar.i.b;
        b(IronSourceConstants.TROUBLESHOOTING_IS_FORK, IronSourceUtils.getMediationAdditionalData(false, this.H, 1));
        if (!this.H) {
            w();
        } else if (this.I) {
            u();
        } else {
            v();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:26:0x00e4, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void z() {
        /*
            r13 = this;
            boolean r0 = r13.ab
            if (r0 == 0) goto L_0x0008
            r13.A()
            return
        L_0x0008:
            java.lang.Boolean r0 = r13.ad
            monitor-enter(r0)
            com.ironsource.mediationsdk.utils.l r1 = r13.i     // Catch:{ all -> 0x00e5 }
            com.ironsource.mediationsdk.model.g r1 = r1.c     // Catch:{ all -> 0x00e5 }
            com.ironsource.mediationsdk.model.e r1 = r1.d     // Catch:{ all -> 0x00e5 }
            com.ironsource.mediationsdk.utils.c r1 = r1.g     // Catch:{ all -> 0x00e5 }
            boolean r1 = r1.a     // Catch:{ all -> 0x00e5 }
            r13.K = r1     // Catch:{ all -> 0x00e5 }
            com.ironsource.mediationsdk.logger.IronLog r1 = com.ironsource.mediationsdk.logger.IronLog.INTERNAL     // Catch:{ all -> 0x00e5 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x00e5 }
            java.lang.String r3 = "mIsBnProgrammatic = "
            r2.<init>(r3)     // Catch:{ all -> 0x00e5 }
            boolean r3 = r13.K     // Catch:{ all -> 0x00e5 }
            r2.append(r3)     // Catch:{ all -> 0x00e5 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x00e5 }
            r1.verbose(r2)     // Catch:{ all -> 0x00e5 }
            com.ironsource.mediationsdk.logger.IronLog r1 = com.ironsource.mediationsdk.logger.IronLog.INTERNAL     // Catch:{ all -> 0x00e5 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x00e5 }
            java.lang.String r3 = "mIsBnLoadBeforeInitCompleted = "
            r2.<init>(r3)     // Catch:{ all -> 0x00e5 }
            java.lang.Boolean r3 = r13.ad     // Catch:{ all -> 0x00e5 }
            r2.append(r3)     // Catch:{ all -> 0x00e5 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x00e5 }
            r1.verbose(r2)     // Catch:{ all -> 0x00e5 }
            r1 = 83000(0x14438, float:1.16308E-40)
            boolean r2 = r13.K     // Catch:{ all -> 0x00e5 }
            r3 = 1
            r4 = 0
            org.json.JSONObject r2 = com.ironsource.mediationsdk.utils.IronSourceUtils.getMediationAdditionalData(r4, r2, r3)     // Catch:{ all -> 0x00e5 }
            b(r1, r2)     // Catch:{ all -> 0x00e5 }
            java.util.ArrayList r6 = new java.util.ArrayList     // Catch:{ all -> 0x00e5 }
            r6.<init>()     // Catch:{ all -> 0x00e5 }
            r1 = r4
        L_0x0055:
            com.ironsource.mediationsdk.utils.l r2 = r13.i     // Catch:{ all -> 0x00e5 }
            com.ironsource.mediationsdk.model.m r2 = r2.a     // Catch:{ all -> 0x00e5 }
            java.util.ArrayList<java.lang.String> r2 = r2.e     // Catch:{ all -> 0x00e5 }
            int r2 = r2.size()     // Catch:{ all -> 0x00e5 }
            if (r1 >= r2) goto L_0x0083
            com.ironsource.mediationsdk.utils.l r2 = r13.i     // Catch:{ all -> 0x00e5 }
            com.ironsource.mediationsdk.model.m r2 = r2.a     // Catch:{ all -> 0x00e5 }
            java.util.ArrayList<java.lang.String> r2 = r2.e     // Catch:{ all -> 0x00e5 }
            java.lang.Object r2 = r2.get(r1)     // Catch:{ all -> 0x00e5 }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ all -> 0x00e5 }
            boolean r5 = android.text.TextUtils.isEmpty(r2)     // Catch:{ all -> 0x00e5 }
            if (r5 != 0) goto L_0x0080
            com.ironsource.mediationsdk.utils.l r5 = r13.i     // Catch:{ all -> 0x00e5 }
            com.ironsource.mediationsdk.model.n r5 = r5.b     // Catch:{ all -> 0x00e5 }
            com.ironsource.mediationsdk.model.NetworkSettings r2 = r5.a((java.lang.String) r2)     // Catch:{ all -> 0x00e5 }
            if (r2 == 0) goto L_0x0080
            r6.add(r2)     // Catch:{ all -> 0x00e5 }
        L_0x0080:
            int r1 = r1 + 1
            goto L_0x0055
        L_0x0083:
            int r1 = r6.size()     // Catch:{ all -> 0x00e5 }
            if (r1 <= 0) goto L_0x00bc
            boolean r1 = r13.K     // Catch:{ all -> 0x00e5 }
            if (r1 == 0) goto L_0x0092
            r13.a((java.util.ArrayList<com.ironsource.mediationsdk.model.NetworkSettings>) r6)     // Catch:{ all -> 0x00e5 }
            monitor-exit(r0)     // Catch:{ all -> 0x00e5 }
            return
        L_0x0092:
            com.ironsource.mediationsdk.utils.l r1 = r13.i     // Catch:{ all -> 0x00e5 }
            com.ironsource.mediationsdk.model.g r1 = r1.c     // Catch:{ all -> 0x00e5 }
            com.ironsource.mediationsdk.model.e r1 = r1.d     // Catch:{ all -> 0x00e5 }
            long r9 = r1.b     // Catch:{ all -> 0x00e5 }
            com.ironsource.mediationsdk.utils.l r1 = r13.i     // Catch:{ all -> 0x00e5 }
            com.ironsource.mediationsdk.model.g r1 = r1.c     // Catch:{ all -> 0x00e5 }
            com.ironsource.mediationsdk.model.e r1 = r1.d     // Catch:{ all -> 0x00e5 }
            int r11 = r1.e     // Catch:{ all -> 0x00e5 }
            com.ironsource.mediationsdk.utils.l r1 = r13.i     // Catch:{ all -> 0x00e5 }
            com.ironsource.mediationsdk.model.g r1 = r1.c     // Catch:{ all -> 0x00e5 }
            com.ironsource.mediationsdk.model.e r1 = r1.d     // Catch:{ all -> 0x00e5 }
            int r12 = r1.f     // Catch:{ all -> 0x00e5 }
            com.ironsource.mediationsdk.k r1 = new com.ironsource.mediationsdk.k     // Catch:{ all -> 0x00e5 }
            java.lang.String r7 = r13.j     // Catch:{ all -> 0x00e5 }
            java.lang.String r8 = com.ironsource.mediationsdk.utils.IronSourceUtils.getUserIdForNetworks()     // Catch:{ all -> 0x00e5 }
            r5 = r1
            r5.<init>(r6, r7, r8, r9, r11, r12)     // Catch:{ all -> 0x00e5 }
            r13.e = r1     // Catch:{ all -> 0x00e5 }
            r13.B()     // Catch:{ all -> 0x00e5 }
            goto L_0x00e3
        L_0x00bc:
            boolean r1 = r13.K     // Catch:{ all -> 0x00e5 }
            org.json.JSONObject r1 = com.ironsource.mediationsdk.utils.IronSourceUtils.getMediationAdditionalData(r4, r1, r3)     // Catch:{ all -> 0x00e5 }
            java.lang.Object[][] r2 = new java.lang.Object[r3][]     // Catch:{ all -> 0x00e5 }
            r5 = 2
            java.lang.Object[] r5 = new java.lang.Object[r5]     // Catch:{ all -> 0x00e5 }
            java.lang.String r6 = "errorCode"
            r5[r4] = r6     // Catch:{ all -> 0x00e5 }
            r6 = 1010(0x3f2, float:1.415E-42)
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ all -> 0x00e5 }
            r5[r3] = r6     // Catch:{ all -> 0x00e5 }
            r2[r4] = r5     // Catch:{ all -> 0x00e5 }
            a((org.json.JSONObject) r1, (java.lang.Object[][]) r2)     // Catch:{ all -> 0x00e5 }
            r2 = 83314(0x14572, float:1.16748E-40)
            b(r2, r1)     // Catch:{ all -> 0x00e5 }
            com.ironsource.mediationsdk.IronSource$AD_UNIT r1 = com.ironsource.mediationsdk.IronSource.AD_UNIT.BANNER     // Catch:{ all -> 0x00e5 }
            r13.a((com.ironsource.mediationsdk.IronSource.AD_UNIT) r1, (boolean) r4)     // Catch:{ all -> 0x00e5 }
        L_0x00e3:
            monitor-exit(r0)     // Catch:{ all -> 0x00e5 }
            return
        L_0x00e5:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x00e5 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.mediationsdk.H.z():void");
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x033b, code lost:
        return r13;
     */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x01fb  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x027f  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x030f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.ironsource.mediationsdk.utils.l a(android.content.Context r11, java.lang.String r12, com.ironsource.mediationsdk.H.a r13) {
        /*
            r10 = this;
            java.lang.Object r0 = r10.T
            monitor-enter(r0)
            com.ironsource.mediationsdk.utils.l r1 = r10.i     // Catch:{ all -> 0x033c }
            if (r1 == 0) goto L_0x0010
            com.ironsource.mediationsdk.utils.l r11 = new com.ironsource.mediationsdk.utils.l     // Catch:{ all -> 0x033c }
            com.ironsource.mediationsdk.utils.l r12 = r10.i     // Catch:{ all -> 0x033c }
            r11.<init>(r12)     // Catch:{ all -> 0x033c }
            monitor-exit(r0)     // Catch:{ all -> 0x033c }
            return r11
        L_0x0010:
            com.ironsource.mediationsdk.utils.l r13 = r10.b((android.content.Context) r11, (java.lang.String) r12, (com.ironsource.mediationsdk.H.a) r13)     // Catch:{ all -> 0x033c }
            r1 = 1
            r2 = 0
            if (r13 == 0) goto L_0x001e
            boolean r3 = r13.b()     // Catch:{ all -> 0x033c }
            if (r3 != 0) goto L_0x006a
        L_0x001e:
            com.ironsource.mediationsdk.logger.IronSourceLoggerManager r13 = com.ironsource.mediationsdk.logger.IronSourceLoggerManager.getLogger()     // Catch:{ all -> 0x033c }
            com.ironsource.mediationsdk.logger.IronSourceLogger$IronSourceTag r3 = com.ironsource.mediationsdk.logger.IronSourceLogger.IronSourceTag.INTERNAL     // Catch:{ all -> 0x033c }
            java.lang.String r4 = "Null or invalid response. Trying to get cached response"
            r13.log(r3, r4, r2)     // Catch:{ all -> 0x033c }
            com.ironsource.mediationsdk.utils.l r13 = r10.a((android.content.Context) r11, (java.lang.String) r12)     // Catch:{ all -> 0x033c }
            if (r13 == 0) goto L_0x006a
            java.lang.String r3 = r10.j     // Catch:{ all -> 0x033c }
            com.ironsource.mediationsdk.logger.IronSourceError r12 = com.ironsource.mediationsdk.utils.ErrorBuilder.buildUsingCachedConfigurationError(r3, r12)     // Catch:{ all -> 0x033c }
            com.ironsource.mediationsdk.logger.IronSourceLoggerManager r3 = r10.f     // Catch:{ all -> 0x033c }
            com.ironsource.mediationsdk.logger.IronSourceLogger$IronSourceTag r4 = com.ironsource.mediationsdk.logger.IronSourceLogger.IronSourceTag.INTERNAL     // Catch:{ all -> 0x033c }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x033c }
            r5.<init>()     // Catch:{ all -> 0x033c }
            java.lang.String r12 = r12.toString()     // Catch:{ all -> 0x033c }
            r5.append(r12)     // Catch:{ all -> 0x033c }
            java.lang.String r12 = ": "
            r5.append(r12)     // Catch:{ all -> 0x033c }
            java.lang.String r12 = r13.toString()     // Catch:{ all -> 0x033c }
            r5.append(r12)     // Catch:{ all -> 0x033c }
            java.lang.String r12 = r5.toString()     // Catch:{ all -> 0x033c }
            r3.log(r4, r12, r1)     // Catch:{ all -> 0x033c }
            org.json.JSONObject r12 = com.ironsource.mediationsdk.utils.IronSourceUtils.getMediationAdditionalData(r2)     // Catch:{ all -> 0x033c }
            com.ironsource.mediationsdk.a.c r3 = new com.ironsource.mediationsdk.a.c     // Catch:{ all -> 0x033c }
            r4 = 140(0x8c, float:1.96E-43)
            r3.<init>(r4, r12)     // Catch:{ all -> 0x033c }
            com.ironsource.mediationsdk.a.h r12 = com.ironsource.mediationsdk.a.h.e()     // Catch:{ all -> 0x033c }
            r12.b((com.ironsource.mediationsdk.a.c) r3)     // Catch:{ all -> 0x033c }
        L_0x006a:
            if (r13 == 0) goto L_0x033a
            r10.i = r13     // Catch:{ all -> 0x033c }
            java.lang.String r12 = r13.toString()     // Catch:{ all -> 0x033c }
            com.ironsource.mediationsdk.utils.IronSourceUtils.saveLastResponse(r11, r12)     // Catch:{ all -> 0x033c }
            com.ironsource.mediationsdk.utils.l r12 = r10.i     // Catch:{ all -> 0x033c }
            com.ironsource.mediationsdk.logger.b r3 = r10.h     // Catch:{ all -> 0x033c }
            com.ironsource.mediationsdk.model.g r4 = r12.c     // Catch:{ all -> 0x033c }
            com.ironsource.sdk.f.a r4 = r4.e     // Catch:{ all -> 0x033c }
            com.ironsource.mediationsdk.model.d r4 = r4.a()     // Catch:{ all -> 0x033c }
            int r4 = r4.a     // Catch:{ all -> 0x033c }
            r3.setDebugLevel(r4)     // Catch:{ all -> 0x033c }
            com.ironsource.mediationsdk.logger.IronSourceLoggerManager r3 = r10.f     // Catch:{ all -> 0x033c }
            java.lang.String r4 = "console"
            com.ironsource.mediationsdk.model.g r5 = r12.c     // Catch:{ all -> 0x033c }
            com.ironsource.sdk.f.a r5 = r5.e     // Catch:{ all -> 0x033c }
            com.ironsource.mediationsdk.model.d r5 = r5.a()     // Catch:{ all -> 0x033c }
            int r5 = r5.b     // Catch:{ all -> 0x033c }
            r3.setLoggerDebugLevel(r4, r5)     // Catch:{ all -> 0x033c }
            boolean r3 = r10.d()     // Catch:{ all -> 0x033c }
            if (r3 == 0) goto L_0x00a8
            com.ironsource.mediationsdk.model.g r3 = r12.c     // Catch:{ all -> 0x033c }
            com.ironsource.mediationsdk.model.o r3 = r3.a     // Catch:{ all -> 0x033c }
            com.ironsource.sdk.g.d r3 = r3.b     // Catch:{ all -> 0x033c }
            boolean r3 = r3.b()     // Catch:{ all -> 0x033c }
            goto L_0x00a9
        L_0x00a8:
            r3 = r2
        L_0x00a9:
            boolean r4 = r10.h()     // Catch:{ all -> 0x033c }
            if (r4 == 0) goto L_0x00ba
            com.ironsource.mediationsdk.model.g r4 = r12.c     // Catch:{ all -> 0x033c }
            com.ironsource.mediationsdk.model.h r4 = r4.b     // Catch:{ all -> 0x033c }
            com.ironsource.sdk.g.d r4 = r4.b     // Catch:{ all -> 0x033c }
            boolean r4 = r4.b()     // Catch:{ all -> 0x033c }
            goto L_0x00bb
        L_0x00ba:
            r4 = r2
        L_0x00bb:
            boolean r5 = r10.C()     // Catch:{ all -> 0x033c }
            if (r5 == 0) goto L_0x00cc
            com.ironsource.mediationsdk.model.g r5 = r12.c     // Catch:{ all -> 0x033c }
            com.ironsource.mediationsdk.model.e r5 = r5.d     // Catch:{ all -> 0x033c }
            com.ironsource.sdk.g.d r5 = r5.a     // Catch:{ all -> 0x033c }
            boolean r5 = r5.b()     // Catch:{ all -> 0x033c }
            goto L_0x00cd
        L_0x00cc:
            r5 = r2
        L_0x00cd:
            boolean r6 = r10.i()     // Catch:{ all -> 0x033c }
            if (r6 == 0) goto L_0x00de
            com.ironsource.mediationsdk.model.g r6 = r12.c     // Catch:{ all -> 0x033c }
            com.ironsource.mediationsdk.model.i r6 = r6.c     // Catch:{ all -> 0x033c }
            com.ironsource.sdk.g.d r6 = r6.c     // Catch:{ all -> 0x033c }
            boolean r6 = r6.b()     // Catch:{ all -> 0x033c }
            goto L_0x00df
        L_0x00de:
            r6 = r2
        L_0x00df:
            com.ironsource.mediationsdk.model.g r7 = r12.c     // Catch:{ all -> 0x033c }
            com.ironsource.sdk.f.a r7 = r7.e     // Catch:{ all -> 0x033c }
            com.ironsource.mediationsdk.utils.j r7 = r7.h()     // Catch:{ all -> 0x033c }
            boolean r8 = r7.a     // Catch:{ all -> 0x033c }
            if (r3 == 0) goto L_0x016f
            com.ironsource.mediationsdk.model.g r3 = r12.c     // Catch:{ all -> 0x033c }
            com.ironsource.mediationsdk.model.o r3 = r3.a     // Catch:{ all -> 0x033c }
            com.ironsource.sdk.g.d r3 = r3.b     // Catch:{ all -> 0x033c }
            com.ironsource.mediationsdk.a.h r6 = com.ironsource.mediationsdk.a.h.e()     // Catch:{ all -> 0x033c }
            java.lang.String r9 = r3.e()     // Catch:{ all -> 0x033c }
            r6.b((java.lang.String) r9, (android.content.Context) r11)     // Catch:{ all -> 0x033c }
            com.ironsource.mediationsdk.a.h r6 = com.ironsource.mediationsdk.a.h.e()     // Catch:{ all -> 0x033c }
            java.lang.String r9 = r3.d()     // Catch:{ all -> 0x033c }
            r6.a((java.lang.String) r9, (android.content.Context) r11)     // Catch:{ all -> 0x033c }
            com.ironsource.mediationsdk.a.h r6 = com.ironsource.mediationsdk.a.h.e()     // Catch:{ all -> 0x033c }
            int r9 = r3.g()     // Catch:{ all -> 0x033c }
            r6.b((int) r9)     // Catch:{ all -> 0x033c }
            com.ironsource.mediationsdk.a.h r6 = com.ironsource.mediationsdk.a.h.e()     // Catch:{ all -> 0x033c }
            int r9 = r3.h()     // Catch:{ all -> 0x033c }
            r6.c((int) r9)     // Catch:{ all -> 0x033c }
            com.ironsource.mediationsdk.a.h r6 = com.ironsource.mediationsdk.a.h.e()     // Catch:{ all -> 0x033c }
            int r9 = r3.f()     // Catch:{ all -> 0x033c }
            r6.a((int) r9)     // Catch:{ all -> 0x033c }
            com.ironsource.mediationsdk.a.h r6 = com.ironsource.mediationsdk.a.h.e()     // Catch:{ all -> 0x033c }
            int[] r9 = r3.i()     // Catch:{ all -> 0x033c }
            r6.a((int[]) r9, (android.content.Context) r11)     // Catch:{ all -> 0x033c }
            com.ironsource.mediationsdk.a.h r6 = com.ironsource.mediationsdk.a.h.e()     // Catch:{ all -> 0x033c }
            int[] r9 = r3.j()     // Catch:{ all -> 0x033c }
            r6.b((int[]) r9, (android.content.Context) r11)     // Catch:{ all -> 0x033c }
            com.ironsource.mediationsdk.a.h r6 = com.ironsource.mediationsdk.a.h.e()     // Catch:{ all -> 0x033c }
            int[] r9 = r3.k()     // Catch:{ all -> 0x033c }
            r6.c(r9, r11)     // Catch:{ all -> 0x033c }
            com.ironsource.mediationsdk.a.h r6 = com.ironsource.mediationsdk.a.h.e()     // Catch:{ all -> 0x033c }
            int[] r9 = r3.l()     // Catch:{ all -> 0x033c }
            r6.d(r9, r11)     // Catch:{ all -> 0x033c }
            com.ironsource.mediationsdk.a.h r6 = com.ironsource.mediationsdk.a.h.e()     // Catch:{ all -> 0x033c }
            com.ironsource.mediationsdk.model.g r9 = r12.c     // Catch:{ all -> 0x033c }
            com.ironsource.sdk.f.a r9 = r9.e     // Catch:{ all -> 0x033c }
            com.ironsource.mediationsdk.model.p r9 = r9.b()     // Catch:{ all -> 0x033c }
            r6.a((com.ironsource.mediationsdk.model.p) r9)     // Catch:{ all -> 0x033c }
            com.ironsource.mediationsdk.a.h r6 = com.ironsource.mediationsdk.a.h.e()     // Catch:{ all -> 0x033c }
            boolean r3 = r3.c()     // Catch:{ all -> 0x033c }
        L_0x016b:
            r6.c = r3     // Catch:{ all -> 0x033c }
            goto L_0x01f9
        L_0x016f:
            if (r6 == 0) goto L_0x01f3
            com.ironsource.mediationsdk.model.g r3 = r12.c     // Catch:{ all -> 0x033c }
            com.ironsource.mediationsdk.model.i r3 = r3.c     // Catch:{ all -> 0x033c }
            com.ironsource.sdk.g.d r3 = r3.c     // Catch:{ all -> 0x033c }
            com.ironsource.mediationsdk.a.h r6 = com.ironsource.mediationsdk.a.h.e()     // Catch:{ all -> 0x033c }
            java.lang.String r9 = r3.e()     // Catch:{ all -> 0x033c }
            r6.b((java.lang.String) r9, (android.content.Context) r11)     // Catch:{ all -> 0x033c }
            com.ironsource.mediationsdk.a.h r6 = com.ironsource.mediationsdk.a.h.e()     // Catch:{ all -> 0x033c }
            java.lang.String r9 = r3.d()     // Catch:{ all -> 0x033c }
            r6.a((java.lang.String) r9, (android.content.Context) r11)     // Catch:{ all -> 0x033c }
            com.ironsource.mediationsdk.a.h r6 = com.ironsource.mediationsdk.a.h.e()     // Catch:{ all -> 0x033c }
            int r9 = r3.g()     // Catch:{ all -> 0x033c }
            r6.b((int) r9)     // Catch:{ all -> 0x033c }
            com.ironsource.mediationsdk.a.h r6 = com.ironsource.mediationsdk.a.h.e()     // Catch:{ all -> 0x033c }
            int r9 = r3.h()     // Catch:{ all -> 0x033c }
            r6.c((int) r9)     // Catch:{ all -> 0x033c }
            com.ironsource.mediationsdk.a.h r6 = com.ironsource.mediationsdk.a.h.e()     // Catch:{ all -> 0x033c }
            int r9 = r3.f()     // Catch:{ all -> 0x033c }
            r6.a((int) r9)     // Catch:{ all -> 0x033c }
            com.ironsource.mediationsdk.a.h r6 = com.ironsource.mediationsdk.a.h.e()     // Catch:{ all -> 0x033c }
            int[] r9 = r3.i()     // Catch:{ all -> 0x033c }
            r6.a((int[]) r9, (android.content.Context) r11)     // Catch:{ all -> 0x033c }
            com.ironsource.mediationsdk.a.h r6 = com.ironsource.mediationsdk.a.h.e()     // Catch:{ all -> 0x033c }
            int[] r9 = r3.j()     // Catch:{ all -> 0x033c }
            r6.b((int[]) r9, (android.content.Context) r11)     // Catch:{ all -> 0x033c }
            com.ironsource.mediationsdk.a.h r6 = com.ironsource.mediationsdk.a.h.e()     // Catch:{ all -> 0x033c }
            int[] r9 = r3.k()     // Catch:{ all -> 0x033c }
            r6.c(r9, r11)     // Catch:{ all -> 0x033c }
            com.ironsource.mediationsdk.a.h r6 = com.ironsource.mediationsdk.a.h.e()     // Catch:{ all -> 0x033c }
            int[] r9 = r3.l()     // Catch:{ all -> 0x033c }
            r6.d(r9, r11)     // Catch:{ all -> 0x033c }
            com.ironsource.mediationsdk.a.h r6 = com.ironsource.mediationsdk.a.h.e()     // Catch:{ all -> 0x033c }
            com.ironsource.mediationsdk.model.g r9 = r12.c     // Catch:{ all -> 0x033c }
            com.ironsource.sdk.f.a r9 = r9.e     // Catch:{ all -> 0x033c }
            com.ironsource.mediationsdk.model.p r9 = r9.b()     // Catch:{ all -> 0x033c }
            r6.a((com.ironsource.mediationsdk.model.p) r9)     // Catch:{ all -> 0x033c }
            com.ironsource.mediationsdk.a.h r6 = com.ironsource.mediationsdk.a.h.e()     // Catch:{ all -> 0x033c }
            boolean r3 = r3.c()     // Catch:{ all -> 0x033c }
            goto L_0x016b
        L_0x01f3:
            com.ironsource.mediationsdk.a.h r3 = com.ironsource.mediationsdk.a.h.e()     // Catch:{ all -> 0x033c }
            r3.f = r2     // Catch:{ all -> 0x033c }
        L_0x01f9:
            if (r4 == 0) goto L_0x027f
            com.ironsource.mediationsdk.model.g r2 = r12.c     // Catch:{ all -> 0x033c }
            com.ironsource.mediationsdk.model.h r2 = r2.b     // Catch:{ all -> 0x033c }
            com.ironsource.sdk.g.d r2 = r2.b     // Catch:{ all -> 0x033c }
            com.ironsource.mediationsdk.a.d r3 = com.ironsource.mediationsdk.a.d.e()     // Catch:{ all -> 0x033c }
            java.lang.String r4 = r2.e()     // Catch:{ all -> 0x033c }
            r3.b((java.lang.String) r4, (android.content.Context) r11)     // Catch:{ all -> 0x033c }
            com.ironsource.mediationsdk.a.d r3 = com.ironsource.mediationsdk.a.d.e()     // Catch:{ all -> 0x033c }
            java.lang.String r4 = r2.d()     // Catch:{ all -> 0x033c }
            r3.a((java.lang.String) r4, (android.content.Context) r11)     // Catch:{ all -> 0x033c }
            com.ironsource.mediationsdk.a.d r3 = com.ironsource.mediationsdk.a.d.e()     // Catch:{ all -> 0x033c }
            int r4 = r2.g()     // Catch:{ all -> 0x033c }
            r3.b((int) r4)     // Catch:{ all -> 0x033c }
            com.ironsource.mediationsdk.a.d r3 = com.ironsource.mediationsdk.a.d.e()     // Catch:{ all -> 0x033c }
            int r4 = r2.h()     // Catch:{ all -> 0x033c }
            r3.c((int) r4)     // Catch:{ all -> 0x033c }
            com.ironsource.mediationsdk.a.d r3 = com.ironsource.mediationsdk.a.d.e()     // Catch:{ all -> 0x033c }
            int r4 = r2.f()     // Catch:{ all -> 0x033c }
            r3.a((int) r4)     // Catch:{ all -> 0x033c }
            com.ironsource.mediationsdk.a.d r3 = com.ironsource.mediationsdk.a.d.e()     // Catch:{ all -> 0x033c }
            int[] r4 = r2.i()     // Catch:{ all -> 0x033c }
            r3.a((int[]) r4, (android.content.Context) r11)     // Catch:{ all -> 0x033c }
            com.ironsource.mediationsdk.a.d r3 = com.ironsource.mediationsdk.a.d.e()     // Catch:{ all -> 0x033c }
            int[] r4 = r2.j()     // Catch:{ all -> 0x033c }
            r3.b((int[]) r4, (android.content.Context) r11)     // Catch:{ all -> 0x033c }
            com.ironsource.mediationsdk.a.d r3 = com.ironsource.mediationsdk.a.d.e()     // Catch:{ all -> 0x033c }
            int[] r4 = r2.k()     // Catch:{ all -> 0x033c }
            r3.c(r4, r11)     // Catch:{ all -> 0x033c }
            com.ironsource.mediationsdk.a.d r3 = com.ironsource.mediationsdk.a.d.e()     // Catch:{ all -> 0x033c }
            int[] r4 = r2.l()     // Catch:{ all -> 0x033c }
            r3.d(r4, r11)     // Catch:{ all -> 0x033c }
            com.ironsource.mediationsdk.a.d r3 = com.ironsource.mediationsdk.a.d.e()     // Catch:{ all -> 0x033c }
            com.ironsource.mediationsdk.model.g r12 = r12.c     // Catch:{ all -> 0x033c }
            com.ironsource.sdk.f.a r12 = r12.e     // Catch:{ all -> 0x033c }
            com.ironsource.mediationsdk.model.p r12 = r12.b()     // Catch:{ all -> 0x033c }
            r3.a((com.ironsource.mediationsdk.model.p) r12)     // Catch:{ all -> 0x033c }
            com.ironsource.mediationsdk.a.d r12 = com.ironsource.mediationsdk.a.d.e()     // Catch:{ all -> 0x033c }
            boolean r2 = r2.c()     // Catch:{ all -> 0x033c }
        L_0x027b:
            r12.c = r2     // Catch:{ all -> 0x033c }
            goto L_0x0309
        L_0x027f:
            if (r5 == 0) goto L_0x0303
            com.ironsource.mediationsdk.model.g r2 = r12.c     // Catch:{ all -> 0x033c }
            com.ironsource.mediationsdk.model.e r2 = r2.d     // Catch:{ all -> 0x033c }
            com.ironsource.sdk.g.d r2 = r2.a     // Catch:{ all -> 0x033c }
            com.ironsource.mediationsdk.a.d r3 = com.ironsource.mediationsdk.a.d.e()     // Catch:{ all -> 0x033c }
            java.lang.String r4 = r2.e()     // Catch:{ all -> 0x033c }
            r3.b((java.lang.String) r4, (android.content.Context) r11)     // Catch:{ all -> 0x033c }
            com.ironsource.mediationsdk.a.d r3 = com.ironsource.mediationsdk.a.d.e()     // Catch:{ all -> 0x033c }
            java.lang.String r4 = r2.d()     // Catch:{ all -> 0x033c }
            r3.a((java.lang.String) r4, (android.content.Context) r11)     // Catch:{ all -> 0x033c }
            com.ironsource.mediationsdk.a.d r3 = com.ironsource.mediationsdk.a.d.e()     // Catch:{ all -> 0x033c }
            int r4 = r2.g()     // Catch:{ all -> 0x033c }
            r3.b((int) r4)     // Catch:{ all -> 0x033c }
            com.ironsource.mediationsdk.a.d r3 = com.ironsource.mediationsdk.a.d.e()     // Catch:{ all -> 0x033c }
            int r4 = r2.h()     // Catch:{ all -> 0x033c }
            r3.c((int) r4)     // Catch:{ all -> 0x033c }
            com.ironsource.mediationsdk.a.d r3 = com.ironsource.mediationsdk.a.d.e()     // Catch:{ all -> 0x033c }
            int r4 = r2.f()     // Catch:{ all -> 0x033c }
            r3.a((int) r4)     // Catch:{ all -> 0x033c }
            com.ironsource.mediationsdk.a.d r3 = com.ironsource.mediationsdk.a.d.e()     // Catch:{ all -> 0x033c }
            int[] r4 = r2.i()     // Catch:{ all -> 0x033c }
            r3.a((int[]) r4, (android.content.Context) r11)     // Catch:{ all -> 0x033c }
            com.ironsource.mediationsdk.a.d r3 = com.ironsource.mediationsdk.a.d.e()     // Catch:{ all -> 0x033c }
            int[] r4 = r2.j()     // Catch:{ all -> 0x033c }
            r3.b((int[]) r4, (android.content.Context) r11)     // Catch:{ all -> 0x033c }
            com.ironsource.mediationsdk.a.d r3 = com.ironsource.mediationsdk.a.d.e()     // Catch:{ all -> 0x033c }
            int[] r4 = r2.k()     // Catch:{ all -> 0x033c }
            r3.c(r4, r11)     // Catch:{ all -> 0x033c }
            com.ironsource.mediationsdk.a.d r3 = com.ironsource.mediationsdk.a.d.e()     // Catch:{ all -> 0x033c }
            int[] r4 = r2.l()     // Catch:{ all -> 0x033c }
            r3.d(r4, r11)     // Catch:{ all -> 0x033c }
            com.ironsource.mediationsdk.a.d r3 = com.ironsource.mediationsdk.a.d.e()     // Catch:{ all -> 0x033c }
            com.ironsource.mediationsdk.model.g r12 = r12.c     // Catch:{ all -> 0x033c }
            com.ironsource.sdk.f.a r12 = r12.e     // Catch:{ all -> 0x033c }
            com.ironsource.mediationsdk.model.p r12 = r12.b()     // Catch:{ all -> 0x033c }
            r3.a((com.ironsource.mediationsdk.model.p) r12)     // Catch:{ all -> 0x033c }
            com.ironsource.mediationsdk.a.d r12 = com.ironsource.mediationsdk.a.d.e()     // Catch:{ all -> 0x033c }
            boolean r2 = r2.c()     // Catch:{ all -> 0x033c }
            goto L_0x027b
        L_0x0303:
            com.ironsource.mediationsdk.a.d r12 = com.ironsource.mediationsdk.a.d.e()     // Catch:{ all -> 0x033c }
            r12.f = r2     // Catch:{ all -> 0x033c }
        L_0x0309:
            com.ironsource.mediationsdk.a.g r12 = com.ironsource.mediationsdk.a.g.w     // Catch:{ all -> 0x033c }
            r12.f = r8     // Catch:{ all -> 0x033c }
            if (r8 == 0) goto L_0x032a
            java.lang.String r12 = r7.b     // Catch:{ all -> 0x033c }
            com.ironsource.mediationsdk.a.g r2 = com.ironsource.mediationsdk.a.g.w     // Catch:{ all -> 0x033c }
            r2.a((java.lang.String) r12, (android.content.Context) r11)     // Catch:{ all -> 0x033c }
            com.ironsource.mediationsdk.a.g r12 = com.ironsource.mediationsdk.a.g.w     // Catch:{ all -> 0x033c }
            int[] r2 = r7.d     // Catch:{ all -> 0x033c }
            r12.a((int[]) r2, (android.content.Context) r11)     // Catch:{ all -> 0x033c }
            com.ironsource.mediationsdk.a.g r12 = com.ironsource.mediationsdk.a.g.w     // Catch:{ all -> 0x033c }
            int[] r2 = r7.e     // Catch:{ all -> 0x033c }
            r12.b((int[]) r2, (android.content.Context) r11)     // Catch:{ all -> 0x033c }
            com.ironsource.mediationsdk.a.g r11 = com.ironsource.mediationsdk.a.g.w     // Catch:{ all -> 0x033c }
            boolean r12 = r7.c     // Catch:{ all -> 0x033c }
            r11.c = r12     // Catch:{ all -> 0x033c }
        L_0x032a:
            com.ironsource.mediationsdk.a.d r11 = com.ironsource.mediationsdk.a.d.e()     // Catch:{ all -> 0x033c }
            r11.a = r1     // Catch:{ all -> 0x033c }
            com.ironsource.mediationsdk.a.h r11 = com.ironsource.mediationsdk.a.h.e()     // Catch:{ all -> 0x033c }
            r11.a = r1     // Catch:{ all -> 0x033c }
            com.ironsource.mediationsdk.a.g r11 = com.ironsource.mediationsdk.a.g.w     // Catch:{ all -> 0x033c }
            r11.a = r1     // Catch:{ all -> 0x033c }
        L_0x033a:
            monitor-exit(r0)     // Catch:{ all -> 0x033c }
            return r13
        L_0x033c:
            r11 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x033c }
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.mediationsdk.H.a(android.content.Context, java.lang.String, com.ironsource.mediationsdk.H$a):com.ironsource.mediationsdk.utils.l");
    }

    /*  JADX ERROR: IndexOutOfBoundsException in pass: RegionMakerVisitor
        java.lang.IndexOutOfBoundsException: Index: 0, Size: 0
        	at java.util.ArrayList.rangeCheck(ArrayList.java:659)
        	at java.util.ArrayList.get(ArrayList.java:435)
        	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:101)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:611)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:698)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:693)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:698)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:698)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:698)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:698)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:598)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
        */
    public final synchronized void a(android.app.Activity r9, com.ironsource.mediationsdk.IronSourceBannerLayout r10, java.lang.String r11, java.lang.String r12) {
        /*
            r8 = this;
            monitor-enter(r8)
            r0 = 3
            if (r12 != 0) goto L_0x0012
            java.lang.String r9 = "adm cannot be null"
            com.ironsource.mediationsdk.logger.IronSourceLoggerManager r10 = r8.f     // Catch:{ all -> 0x000f }
            com.ironsource.mediationsdk.logger.IronSourceLogger$IronSourceTag r11 = com.ironsource.mediationsdk.logger.IronSourceLogger.IronSourceTag.API     // Catch:{ all -> 0x000f }
            r10.log(r11, r9, r0)     // Catch:{ all -> 0x000f }
            monitor-exit(r8)
            return
        L_0x000f:
            r9 = move-exception
            goto L_0x0258
        L_0x0012:
            r1 = 510(0x1fe, float:7.15E-43)
            boolean r2 = r8.ac     // Catch:{ all -> 0x0240 }
            if (r2 != 0) goto L_0x002b
            java.lang.String r9 = "initISDemandOnly() must be called before loadISDemandOnlyBannerWithAdm()"
            com.ironsource.mediationsdk.logger.IronSourceLoggerManager r11 = r8.f     // Catch:{ all -> 0x0240 }
            com.ironsource.mediationsdk.logger.IronSourceLogger$IronSourceTag r12 = com.ironsource.mediationsdk.logger.IronSourceLogger.IronSourceTag.API     // Catch:{ all -> 0x0240 }
            r11.log(r12, r9, r0)     // Catch:{ all -> 0x0240 }
            com.ironsource.mediationsdk.logger.IronSourceError r11 = new com.ironsource.mediationsdk.logger.IronSourceError     // Catch:{ all -> 0x0240 }
            r11.<init>(r1, r9)     // Catch:{ all -> 0x0240 }
            r10.a((com.ironsource.mediationsdk.logger.IronSourceError) r11)     // Catch:{ all -> 0x0240 }
            monitor-exit(r8)
            return
        L_0x002b:
            boolean r2 = r8.ab     // Catch:{ all -> 0x0240 }
            if (r2 != 0) goto L_0x0042
            java.lang.String r9 = "Banner was initialized in mediation mode. Use loadBanner instead"
            com.ironsource.mediationsdk.logger.IronSourceLoggerManager r11 = r8.f     // Catch:{ all -> 0x0240 }
            com.ironsource.mediationsdk.logger.IronSourceLogger$IronSourceTag r12 = com.ironsource.mediationsdk.logger.IronSourceLogger.IronSourceTag.API     // Catch:{ all -> 0x0240 }
            r11.log(r12, r9, r0)     // Catch:{ all -> 0x0240 }
            com.ironsource.mediationsdk.logger.IronSourceError r11 = new com.ironsource.mediationsdk.logger.IronSourceError     // Catch:{ all -> 0x0240 }
            r11.<init>(r1, r9)     // Catch:{ all -> 0x0240 }
            r10.a((com.ironsource.mediationsdk.logger.IronSourceError) r11)     // Catch:{ all -> 0x0240 }
            monitor-exit(r8)
            return
        L_0x0042:
            r2 = 0
            r3 = 1
            if (r9 == 0) goto L_0x004e
            com.ironsource.environment.ContextProvider r4 = com.ironsource.environment.ContextProvider.getInstance()     // Catch:{ all -> 0x0240 }
            r4.updateActivity(r9)     // Catch:{ all -> 0x0240 }
            goto L_0x007b
        L_0x004e:
            com.ironsource.environment.ContextProvider r9 = com.ironsource.environment.ContextProvider.getInstance()     // Catch:{ all -> 0x0240 }
            android.app.Activity r9 = r9.getCurrentActiveActivity()     // Catch:{ all -> 0x0240 }
            if (r9 != 0) goto L_0x007b
            if (r12 != 0) goto L_0x005b
            goto L_0x005c
        L_0x005b:
            r2 = r3
        L_0x005c:
            org.json.JSONObject r9 = com.ironsource.mediationsdk.utils.IronSourceUtils.getMediationAdditionalData(r3, r2, r3)     // Catch:{ all -> 0x0240 }
            r11 = 83321(0x14579, float:1.16758E-40)
            b(r11, r9)     // Catch:{ all -> 0x0240 }
            java.lang.String r9 = "Banner was initialized and loaded without Activity"
            com.ironsource.mediationsdk.logger.IronSourceLoggerManager r11 = r8.f     // Catch:{ all -> 0x0240 }
            com.ironsource.mediationsdk.logger.IronSourceLogger$IronSourceTag r12 = com.ironsource.mediationsdk.logger.IronSourceLogger.IronSourceTag.API     // Catch:{ all -> 0x0240 }
            r11.log(r12, r9, r0)     // Catch:{ all -> 0x0240 }
            com.ironsource.mediationsdk.logger.IronSourceError r11 = new com.ironsource.mediationsdk.logger.IronSourceError     // Catch:{ all -> 0x0240 }
            r12 = 1062(0x426, float:1.488E-42)
            r11.<init>(r12, r9)     // Catch:{ all -> 0x0240 }
            r10.a((com.ironsource.mediationsdk.logger.IronSourceError) r11)     // Catch:{ all -> 0x0240 }
            monitor-exit(r8)
            return
        L_0x007b:
            com.ironsource.mediationsdk.M r9 = com.ironsource.mediationsdk.M.a()     // Catch:{ all -> 0x0240 }
            com.ironsource.mediationsdk.M$a r9 = r9.b()     // Catch:{ all -> 0x0240 }
            com.ironsource.mediationsdk.M$a r4 = com.ironsource.mediationsdk.M.a.INIT_FAILED     // Catch:{ all -> 0x0240 }
            if (r9 != r4) goto L_0x009d
            com.ironsource.mediationsdk.logger.IronSourceLoggerManager r9 = r8.f     // Catch:{ all -> 0x0240 }
            com.ironsource.mediationsdk.logger.IronSourceLogger$IronSourceTag r11 = com.ironsource.mediationsdk.logger.IronSourceLogger.IronSourceTag.API     // Catch:{ all -> 0x0240 }
            java.lang.String r12 = "init() had failed"
            r9.log(r11, r12, r0)     // Catch:{ all -> 0x0240 }
            java.lang.String r9 = "init() had failed"
            java.lang.String r11 = "Banner"
            com.ironsource.mediationsdk.logger.IronSourceError r9 = com.ironsource.mediationsdk.utils.ErrorBuilder.buildInitFailedError(r9, r11)     // Catch:{ all -> 0x0240 }
            r10.a((com.ironsource.mediationsdk.logger.IronSourceError) r9)     // Catch:{ all -> 0x0240 }
            monitor-exit(r8)
            return
        L_0x009d:
            com.ironsource.mediationsdk.M$a r4 = com.ironsource.mediationsdk.M.a.INIT_IN_PROGRESS     // Catch:{ all -> 0x0240 }
            r5 = 83004(0x1443c, float:1.16313E-40)
            if (r9 != r4) goto L_0x00db
            com.ironsource.mediationsdk.M r9 = com.ironsource.mediationsdk.M.a()     // Catch:{ all -> 0x0240 }
            boolean r9 = r9.c()     // Catch:{ all -> 0x0240 }
            if (r9 == 0) goto L_0x00c4
            com.ironsource.mediationsdk.logger.IronSourceLoggerManager r9 = r8.f     // Catch:{ all -> 0x0240 }
            com.ironsource.mediationsdk.logger.IronSourceLogger$IronSourceTag r11 = com.ironsource.mediationsdk.logger.IronSourceLogger.IronSourceTag.API     // Catch:{ all -> 0x0240 }
            java.lang.String r12 = "init() had failed"
            r9.log(r11, r12, r0)     // Catch:{ all -> 0x0240 }
            java.lang.String r9 = "init() had failed"
            java.lang.String r11 = "Banner"
            com.ironsource.mediationsdk.logger.IronSourceError r9 = com.ironsource.mediationsdk.utils.ErrorBuilder.buildInitFailedError(r9, r11)     // Catch:{ all -> 0x0240 }
            r10.a((com.ironsource.mediationsdk.logger.IronSourceError) r9)     // Catch:{ all -> 0x0240 }
            monitor-exit(r8)
            return
        L_0x00c4:
            java.lang.Boolean r9 = r8.ad     // Catch:{ all -> 0x0240 }
            monitor-enter(r9)     // Catch:{ all -> 0x0240 }
            java.util.concurrent.CopyOnWriteArraySet<java.lang.String> r0 = r8.al     // Catch:{ all -> 0x00d8 }
            r0.add(r11)     // Catch:{ all -> 0x00d8 }
            monitor-exit(r9)     // Catch:{ all -> 0x00d8 }
            if (r12 == 0) goto L_0x00d6
            org.json.JSONObject r9 = com.ironsource.mediationsdk.utils.IronSourceUtils.getMediationAdditionalData(r3, r3, r3)     // Catch:{ all -> 0x0240 }
            b(r5, r9)     // Catch:{ all -> 0x0240 }
        L_0x00d6:
            monitor-exit(r8)
            return
        L_0x00d8:
            r11 = move-exception
            monitor-exit(r9)     // Catch:{ all -> 0x00d8 }
            throw r11     // Catch:{ all -> 0x0240 }
        L_0x00db:
            java.util.concurrent.CopyOnWriteArraySet<java.lang.String> r9 = r8.al     // Catch:{ all -> 0x0240 }
            monitor-enter(r9)     // Catch:{ all -> 0x0240 }
            com.ironsource.mediationsdk.q r4 = r8.N     // Catch:{ all -> 0x023d }
            if (r4 != 0) goto L_0x00f3
            java.util.concurrent.CopyOnWriteArraySet<java.lang.String> r0 = r8.al     // Catch:{ all -> 0x023d }
            r0.add(r11)     // Catch:{ all -> 0x023d }
            if (r12 == 0) goto L_0x00f0
            org.json.JSONObject r11 = com.ironsource.mediationsdk.utils.IronSourceUtils.getMediationAdditionalData(r3, r3, r3)     // Catch:{ all -> 0x023d }
            b(r5, r11)     // Catch:{ all -> 0x023d }
        L_0x00f0:
            monitor-exit(r9)     // Catch:{ all -> 0x023d }
            monitor-exit(r8)
            return
        L_0x00f3:
            monitor-exit(r9)     // Catch:{ all -> 0x023d }
            boolean r9 = r8.C()     // Catch:{ all -> 0x0240 }
            if (r9 != 0) goto L_0x0110
            com.ironsource.mediationsdk.logger.IronSourceLoggerManager r9 = r8.f     // Catch:{ all -> 0x0240 }
            com.ironsource.mediationsdk.logger.IronSourceLogger$IronSourceTag r11 = com.ironsource.mediationsdk.logger.IronSourceLogger.IronSourceTag.API     // Catch:{ all -> 0x0240 }
            java.lang.String r12 = "No Banner configurations found"
            r9.log(r11, r12, r0)     // Catch:{ all -> 0x0240 }
            java.lang.String r9 = "the server response does not contain Banner data"
            java.lang.String r11 = "Banner"
            com.ironsource.mediationsdk.logger.IronSourceError r9 = com.ironsource.mediationsdk.utils.ErrorBuilder.buildInitFailedError(r9, r11)     // Catch:{ all -> 0x0240 }
            r10.a((com.ironsource.mediationsdk.logger.IronSourceError) r9)     // Catch:{ all -> 0x0240 }
            monitor-exit(r8)
            return
        L_0x0110:
            if (r12 == 0) goto L_0x0227
            com.ironsource.mediationsdk.q r9 = r8.N     // Catch:{ all -> 0x0240 }
            r9.b = r10     // Catch:{ all -> 0x0240 }
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.ironsource.mediationsdk.r> r0 = r9.c     // Catch:{ all -> 0x0240 }
            boolean r0 = r0.containsKey(r11)     // Catch:{ all -> 0x0240 }
            if (r0 != 0) goto L_0x0134
            r12 = 3503(0xdaf, float:4.909E-42)
            com.ironsource.mediationsdk.C0164q.a((int) r12, (java.lang.String) r11)     // Catch:{ all -> 0x0240 }
            java.lang.String r11 = "Banner"
            com.ironsource.mediationsdk.logger.IronSourceError r11 = com.ironsource.mediationsdk.utils.ErrorBuilder.buildNonExistentInstanceError(r11)     // Catch:{ all -> 0x0240 }
            com.ironsource.mediationsdk.IronSourceBannerLayout r12 = r9.b     // Catch:{ all -> 0x0240 }
            if (r12 == 0) goto L_0x023b
            com.ironsource.mediationsdk.IronSourceBannerLayout r9 = r9.b     // Catch:{ all -> 0x0240 }
        L_0x012f:
            r9.a((com.ironsource.mediationsdk.logger.IronSourceError) r11)     // Catch:{ all -> 0x0240 }
            goto L_0x023b
        L_0x0134:
            r0 = 3504(0xdb0, float:4.91E-42)
            if (r10 != 0) goto L_0x013c
        L_0x0138:
            com.ironsource.mediationsdk.C0164q.a((int) r0, (java.lang.String) r11)     // Catch:{ all -> 0x0240 }
            goto L_0x0144
        L_0x013c:
            boolean r4 = r10.isDestroyed()     // Catch:{ all -> 0x0240 }
            if (r4 == 0) goto L_0x0143
            goto L_0x0138
        L_0x0143:
            r2 = r3
        L_0x0144:
            if (r2 != 0) goto L_0x0153
            java.lang.String r11 = "validateBannerLayout fail"
            com.ironsource.mediationsdk.logger.IronSourceError r11 = com.ironsource.mediationsdk.utils.ErrorBuilder.buildGenericError(r11)     // Catch:{ all -> 0x0240 }
            com.ironsource.mediationsdk.IronSourceBannerLayout r12 = r9.b     // Catch:{ all -> 0x0240 }
            if (r12 == 0) goto L_0x023b
            com.ironsource.mediationsdk.IronSourceBannerLayout r9 = r9.b     // Catch:{ all -> 0x0240 }
            goto L_0x012f
        L_0x0153:
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.ironsource.mediationsdk.r> r0 = r9.c     // Catch:{ all -> 0x0240 }
            java.lang.Object r11 = r0.get(r11)     // Catch:{ all -> 0x0240 }
            r2 = r11
            com.ironsource.mediationsdk.r r2 = (com.ironsource.mediationsdk.C0165r) r2     // Catch:{ all -> 0x0240 }
            r9.a = r2     // Catch:{ all -> 0x0240 }
            if (r2 != 0) goto L_0x0176
            java.lang.String r11 = "loadISDemandOnlyBannerWithAdm smash is no exist"
            com.ironsource.mediationsdk.logger.IronSourceError r11 = com.ironsource.mediationsdk.utils.ErrorBuilder.buildLoadFailedError(r11)     // Catch:{ all -> 0x0240 }
            com.ironsource.mediationsdk.logger.IronLog r12 = com.ironsource.mediationsdk.logger.IronLog.INTERNAL     // Catch:{ all -> 0x0240 }
            java.lang.String r0 = r11.getErrorMessage()     // Catch:{ all -> 0x0240 }
            r12.error(r0)     // Catch:{ all -> 0x0240 }
            com.ironsource.mediationsdk.IronSourceBannerLayout r12 = r9.b     // Catch:{ all -> 0x0240 }
            if (r12 == 0) goto L_0x023b
            com.ironsource.mediationsdk.IronSourceBannerLayout r9 = r9.b     // Catch:{ all -> 0x0240 }
            goto L_0x012f
        L_0x0176:
            boolean r11 = r2.i()     // Catch:{ all -> 0x0240 }
            r0 = 3300(0xce4, float:4.624E-42)
            if (r11 != 0) goto L_0x0198
            java.lang.String r11 = "loadISDemandOnlyBannerWithAdm in IAB flow must be called by bidder instances"
            com.ironsource.mediationsdk.logger.IronSourceError r11 = com.ironsource.mediationsdk.utils.ErrorBuilder.buildLoadFailedError(r11)     // Catch:{ all -> 0x0240 }
            com.ironsource.mediationsdk.logger.IronLog r12 = com.ironsource.mediationsdk.logger.IronLog.INTERNAL     // Catch:{ all -> 0x0240 }
            java.lang.String r3 = r11.getErrorMessage()     // Catch:{ all -> 0x0240 }
            r12.error(r3)     // Catch:{ all -> 0x0240 }
            r12 = 0
            com.ironsource.mediationsdk.C0164q.a((int) r0, (com.ironsource.mediationsdk.C0165r) r2, (java.lang.Object[][]) r12)     // Catch:{ all -> 0x0240 }
            com.ironsource.mediationsdk.IronSourceBannerLayout r12 = r9.b     // Catch:{ all -> 0x0240 }
            if (r12 == 0) goto L_0x023b
            com.ironsource.mediationsdk.IronSourceBannerLayout r9 = r9.b     // Catch:{ all -> 0x0240 }
            goto L_0x012f
        L_0x0198:
            com.ironsource.mediationsdk.C0153f.a()     // Catch:{ all -> 0x0240 }
            org.json.JSONObject r11 = com.ironsource.mediationsdk.C0153f.a((java.lang.String) r12)     // Catch:{ all -> 0x0240 }
            com.ironsource.mediationsdk.f$a r12 = new com.ironsource.mediationsdk.f$a     // Catch:{ all -> 0x0240 }
            r12.<init>()     // Catch:{ all -> 0x0240 }
            com.ironsource.mediationsdk.C0153f.a()     // Catch:{ Exception -> 0x01ac }
            com.ironsource.mediationsdk.f$a r12 = com.ironsource.mediationsdk.C0153f.a((org.json.JSONObject) r11)     // Catch:{ Exception -> 0x01ac }
            goto L_0x01d5
        L_0x01ac:
            r11 = move-exception
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0240 }
            java.lang.String r4 = "loadISDemandOnlyBannerWithAdm: unable to get auction data from response. Exception="
            r3.<init>(r4)     // Catch:{ all -> 0x0240 }
            java.lang.String r11 = r11.getLocalizedMessage()     // Catch:{ all -> 0x0240 }
            r3.append(r11)     // Catch:{ all -> 0x0240 }
            java.lang.String r11 = r3.toString()     // Catch:{ all -> 0x0240 }
            com.ironsource.mediationsdk.logger.IronSourceError r11 = com.ironsource.mediationsdk.utils.ErrorBuilder.buildLoadFailedError(r11)     // Catch:{ all -> 0x0240 }
            com.ironsource.mediationsdk.logger.IronLog r3 = com.ironsource.mediationsdk.logger.IronLog.INTERNAL     // Catch:{ all -> 0x0240 }
            java.lang.String r4 = r11.getErrorMessage()     // Catch:{ all -> 0x0240 }
            r3.error(r4)     // Catch:{ all -> 0x0240 }
            com.ironsource.mediationsdk.IronSourceBannerLayout r3 = r9.b     // Catch:{ all -> 0x0240 }
            if (r3 == 0) goto L_0x01d5
            com.ironsource.mediationsdk.IronSourceBannerLayout r3 = r9.b     // Catch:{ all -> 0x0240 }
            r3.a((com.ironsource.mediationsdk.logger.IronSourceError) r11)     // Catch:{ all -> 0x0240 }
        L_0x01d5:
            com.ironsource.mediationsdk.C0153f.a()     // Catch:{ all -> 0x0240 }
            java.lang.String r11 = r2.d()     // Catch:{ all -> 0x0240 }
            java.util.List<com.ironsource.mediationsdk.server.b> r3 = r12.b     // Catch:{ all -> 0x0240 }
            com.ironsource.mediationsdk.server.b r11 = com.ironsource.mediationsdk.C0153f.a((java.lang.String) r11, (java.util.List<com.ironsource.mediationsdk.server.b>) r3)     // Catch:{ all -> 0x0240 }
            if (r11 == 0) goto L_0x020b
            java.lang.String r0 = r11.b()     // Catch:{ all -> 0x0240 }
            r2.a((java.lang.String) r0)     // Catch:{ all -> 0x0240 }
            java.lang.String r0 = r12.a     // Catch:{ all -> 0x0240 }
            r2.b(r0)     // Catch:{ all -> 0x0240 }
            org.json.JSONObject r0 = r12.d     // Catch:{ all -> 0x0240 }
            r2.a((org.json.JSONObject) r0)     // Catch:{ all -> 0x0240 }
            r0 = 3002(0xbba, float:4.207E-42)
            r9.a((int) r0, (com.ironsource.mediationsdk.C0165r) r2)     // Catch:{ all -> 0x0240 }
            java.lang.String r4 = r11.b()     // Catch:{ all -> 0x0240 }
            java.lang.String r5 = r12.a     // Catch:{ all -> 0x0240 }
            org.json.JSONObject r6 = r12.d     // Catch:{ all -> 0x0240 }
            java.util.List r7 = r11.d()     // Catch:{ all -> 0x0240 }
            r3 = r10
            r2.a(r3, r4, r5, r6, r7)     // Catch:{ all -> 0x0240 }
            goto L_0x023b
        L_0x020b:
            java.lang.String r11 = "loadISDemandOnlyBannerWithAdm invalid enriched adm"
            com.ironsource.mediationsdk.logger.IronSourceError r11 = com.ironsource.mediationsdk.utils.ErrorBuilder.buildLoadFailedError(r11)     // Catch:{ all -> 0x0240 }
            com.ironsource.mediationsdk.logger.IronLog r12 = com.ironsource.mediationsdk.logger.IronLog.INTERNAL     // Catch:{ all -> 0x0240 }
            java.lang.String r3 = r11.getErrorMessage()     // Catch:{ all -> 0x0240 }
            r12.error(r3)     // Catch:{ all -> 0x0240 }
            r9.a((int) r0, (com.ironsource.mediationsdk.C0165r) r2)     // Catch:{ all -> 0x0240 }
            com.ironsource.mediationsdk.IronSourceBannerLayout r12 = r9.b     // Catch:{ all -> 0x0240 }
            if (r12 == 0) goto L_0x0256
            com.ironsource.mediationsdk.IronSourceBannerLayout r9 = r9.b     // Catch:{ all -> 0x0240 }
            r9.a((com.ironsource.mediationsdk.logger.IronSourceError) r11)     // Catch:{ all -> 0x0240 }
            goto L_0x0256
        L_0x0227:
            com.ironsource.mediationsdk.logger.IronSourceLoggerManager r9 = r8.f     // Catch:{ all -> 0x0240 }
            com.ironsource.mediationsdk.logger.IronSourceLogger$IronSourceTag r11 = com.ironsource.mediationsdk.logger.IronSourceLogger.IronSourceTag.API     // Catch:{ all -> 0x0240 }
            java.lang.String r12 = "Banner support bidding mode only"
            r9.log(r11, r12, r0)     // Catch:{ all -> 0x0240 }
            java.lang.String r9 = "Banner support bidding mode only"
            java.lang.String r11 = "Banner"
            com.ironsource.mediationsdk.logger.IronSourceError r9 = com.ironsource.mediationsdk.utils.ErrorBuilder.buildInitFailedError(r9, r11)     // Catch:{ all -> 0x0240 }
            r10.a((com.ironsource.mediationsdk.logger.IronSourceError) r9)     // Catch:{ all -> 0x0240 }
        L_0x023b:
            monitor-exit(r8)
            return
        L_0x023d:
            r11 = move-exception
            monitor-exit(r9)     // Catch:{ all -> 0x023d }
            throw r11     // Catch:{ all -> 0x0240 }
        L_0x0240:
            r9 = move-exception
            com.ironsource.mediationsdk.logger.IronSourceLoggerManager r11 = r8.f     // Catch:{ all -> 0x000f }
            com.ironsource.mediationsdk.logger.IronSourceLogger$IronSourceTag r12 = com.ironsource.mediationsdk.logger.IronSourceLogger.IronSourceTag.API     // Catch:{ all -> 0x000f }
            java.lang.String r0 = "loadDemandOnlyBanner"
            r11.logException(r12, r0, r9)     // Catch:{ all -> 0x000f }
            com.ironsource.mediationsdk.logger.IronSourceError r11 = new com.ironsource.mediationsdk.logger.IronSourceError     // Catch:{ all -> 0x000f }
            java.lang.String r9 = r9.getMessage()     // Catch:{ all -> 0x000f }
            r11.<init>(r1, r9)     // Catch:{ all -> 0x000f }
            r10.a((com.ironsource.mediationsdk.logger.IronSourceError) r11)     // Catch:{ all -> 0x000f }
        L_0x0256:
            monitor-exit(r8)
            return
        L_0x0258:
            monitor-exit(r8)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.mediationsdk.H.a(android.app.Activity, com.ironsource.mediationsdk.IronSourceBannerLayout, java.lang.String, java.lang.String):void");
    }

    public final synchronized void a(Activity activity, String str, String str2) {
        if (str2 == null) {
            this.f.log(IronSourceLogger.IronSourceTag.API, "adm cannot be null", 3);
            Z.a().a(str, new IronSourceError(IronSourceError.ERROR_CODE_GENERIC, "adm cannot be null"));
            return;
        }
        b(activity, str, str2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:50:0x00bf  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00de  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void a(android.content.Context r8, java.lang.String r9, com.ironsource.mediationsdk.sdk.InitializationListener r10, com.ironsource.mediationsdk.IronSource.AD_UNIT... r11) {
        /*
            r7 = this;
            monitor-enter(r7)
            java.util.ArrayList r10 = new java.util.ArrayList     // Catch:{ all -> 0x00f5 }
            r10.<init>()     // Catch:{ all -> 0x00f5 }
            r0 = 1
            if (r11 == 0) goto L_0x008a
            int r1 = r11.length     // Catch:{ all -> 0x00f5 }
            if (r1 != 0) goto L_0x000e
            goto L_0x008a
        L_0x000e:
            int r1 = r11.length     // Catch:{ all -> 0x00f5 }
            r2 = 0
        L_0x0010:
            if (r2 >= r1) goto L_0x00bd
            r3 = r11[r2]     // Catch:{ all -> 0x00f5 }
            com.ironsource.mediationsdk.IronSource$AD_UNIT r4 = com.ironsource.mediationsdk.IronSource.AD_UNIT.OFFERWALL     // Catch:{ all -> 0x00f5 }
            boolean r4 = r3.equals(r4)     // Catch:{ all -> 0x00f5 }
            if (r4 == 0) goto L_0x0036
            com.ironsource.mediationsdk.logger.IronSourceLoggerManager r4 = r7.f     // Catch:{ all -> 0x00f5 }
            com.ironsource.mediationsdk.logger.IronSourceLogger$IronSourceTag r5 = com.ironsource.mediationsdk.logger.IronSourceLogger.IronSourceTag.API     // Catch:{ all -> 0x00f5 }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x00f5 }
            r6.<init>()     // Catch:{ all -> 0x00f5 }
            r6.append(r3)     // Catch:{ all -> 0x00f5 }
            java.lang.String r3 = " ad unit cannot be initialized in demand only mode"
            r6.append(r3)     // Catch:{ all -> 0x00f5 }
            java.lang.String r3 = r6.toString()     // Catch:{ all -> 0x00f5 }
            r6 = 3
            r4.log(r5, r3, r6)     // Catch:{ all -> 0x00f5 }
            goto L_0x0087
        L_0x0036:
            com.ironsource.mediationsdk.IronSource$AD_UNIT r4 = com.ironsource.mediationsdk.IronSource.AD_UNIT.INTERSTITIAL     // Catch:{ all -> 0x00f5 }
            boolean r4 = r3.equals(r4)     // Catch:{ all -> 0x00f5 }
            if (r4 == 0) goto L_0x0051
            boolean r4 = r7.x     // Catch:{ all -> 0x00f5 }
            if (r4 == 0) goto L_0x0046
            r7.a((com.ironsource.mediationsdk.IronSource.AD_UNIT) r3)     // Catch:{ all -> 0x00f5 }
            goto L_0x0051
        L_0x0046:
            r7.v = r0     // Catch:{ all -> 0x00f5 }
            boolean r4 = r10.contains(r3)     // Catch:{ all -> 0x00f5 }
            if (r4 != 0) goto L_0x0051
            r10.add(r3)     // Catch:{ all -> 0x00f5 }
        L_0x0051:
            com.ironsource.mediationsdk.IronSource$AD_UNIT r4 = com.ironsource.mediationsdk.IronSource.AD_UNIT.REWARDED_VIDEO     // Catch:{ all -> 0x00f5 }
            boolean r4 = r3.equals(r4)     // Catch:{ all -> 0x00f5 }
            if (r4 == 0) goto L_0x006c
            boolean r4 = r7.w     // Catch:{ all -> 0x00f5 }
            if (r4 == 0) goto L_0x0061
            r7.a((com.ironsource.mediationsdk.IronSource.AD_UNIT) r3)     // Catch:{ all -> 0x00f5 }
            goto L_0x006c
        L_0x0061:
            r7.u = r0     // Catch:{ all -> 0x00f5 }
            boolean r4 = r10.contains(r3)     // Catch:{ all -> 0x00f5 }
            if (r4 != 0) goto L_0x006c
            r10.add(r3)     // Catch:{ all -> 0x00f5 }
        L_0x006c:
            com.ironsource.mediationsdk.IronSource$AD_UNIT r4 = com.ironsource.mediationsdk.IronSource.AD_UNIT.BANNER     // Catch:{ all -> 0x00f5 }
            boolean r4 = r3.equals(r4)     // Catch:{ all -> 0x00f5 }
            if (r4 == 0) goto L_0x0087
            boolean r4 = r7.ac     // Catch:{ all -> 0x00f5 }
            if (r4 == 0) goto L_0x007c
            r7.a((com.ironsource.mediationsdk.IronSource.AD_UNIT) r3)     // Catch:{ all -> 0x00f5 }
            goto L_0x0087
        L_0x007c:
            r7.ab = r0     // Catch:{ all -> 0x00f5 }
            boolean r4 = r10.contains(r3)     // Catch:{ all -> 0x00f5 }
            if (r4 != 0) goto L_0x0087
            r10.add(r3)     // Catch:{ all -> 0x00f5 }
        L_0x0087:
            int r2 = r2 + 1
            goto L_0x0010
        L_0x008a:
            boolean r11 = r7.w     // Catch:{ all -> 0x00f5 }
            if (r11 == 0) goto L_0x0094
            com.ironsource.mediationsdk.IronSource$AD_UNIT r11 = com.ironsource.mediationsdk.IronSource.AD_UNIT.REWARDED_VIDEO     // Catch:{ all -> 0x00f5 }
            r7.a((com.ironsource.mediationsdk.IronSource.AD_UNIT) r11)     // Catch:{ all -> 0x00f5 }
            goto L_0x009b
        L_0x0094:
            r7.u = r0     // Catch:{ all -> 0x00f5 }
            com.ironsource.mediationsdk.IronSource$AD_UNIT r11 = com.ironsource.mediationsdk.IronSource.AD_UNIT.REWARDED_VIDEO     // Catch:{ all -> 0x00f5 }
            r10.add(r11)     // Catch:{ all -> 0x00f5 }
        L_0x009b:
            boolean r11 = r7.x     // Catch:{ all -> 0x00f5 }
            if (r11 == 0) goto L_0x00a5
            com.ironsource.mediationsdk.IronSource$AD_UNIT r11 = com.ironsource.mediationsdk.IronSource.AD_UNIT.INTERSTITIAL     // Catch:{ all -> 0x00f5 }
            r7.a((com.ironsource.mediationsdk.IronSource.AD_UNIT) r11)     // Catch:{ all -> 0x00f5 }
            goto L_0x00ac
        L_0x00a5:
            r7.v = r0     // Catch:{ all -> 0x00f5 }
            com.ironsource.mediationsdk.IronSource$AD_UNIT r11 = com.ironsource.mediationsdk.IronSource.AD_UNIT.INTERSTITIAL     // Catch:{ all -> 0x00f5 }
            r10.add(r11)     // Catch:{ all -> 0x00f5 }
        L_0x00ac:
            boolean r11 = r7.ac     // Catch:{ all -> 0x00f5 }
            if (r11 == 0) goto L_0x00b6
            com.ironsource.mediationsdk.IronSource$AD_UNIT r11 = com.ironsource.mediationsdk.IronSource.AD_UNIT.BANNER     // Catch:{ all -> 0x00f5 }
            r7.a((com.ironsource.mediationsdk.IronSource.AD_UNIT) r11)     // Catch:{ all -> 0x00f5 }
            goto L_0x00bd
        L_0x00b6:
            r7.ab = r0     // Catch:{ all -> 0x00f5 }
            com.ironsource.mediationsdk.IronSource$AD_UNIT r11 = com.ironsource.mediationsdk.IronSource.AD_UNIT.BANNER     // Catch:{ all -> 0x00f5 }
            r10.add(r11)     // Catch:{ all -> 0x00f5 }
        L_0x00bd:
            if (r8 == 0) goto L_0x00d8
            boolean r11 = r8 instanceof android.app.Activity     // Catch:{ all -> 0x00f5 }
            if (r11 == 0) goto L_0x00cd
            com.ironsource.environment.ContextProvider r11 = com.ironsource.environment.ContextProvider.getInstance()     // Catch:{ all -> 0x00f5 }
            r0 = r8
            android.app.Activity r0 = (android.app.Activity) r0     // Catch:{ all -> 0x00f5 }
            r11.updateActivity(r0)     // Catch:{ all -> 0x00f5 }
        L_0x00cd:
            com.ironsource.environment.ContextProvider r11 = com.ironsource.environment.ContextProvider.getInstance()     // Catch:{ all -> 0x00f5 }
            android.content.Context r0 = r8.getApplicationContext()     // Catch:{ all -> 0x00f5 }
            r11.updateAppContext(r0)     // Catch:{ all -> 0x00f5 }
        L_0x00d8:
            int r11 = r10.size()     // Catch:{ all -> 0x00f5 }
            if (r11 <= 0) goto L_0x00f3
            int r11 = r10.size()     // Catch:{ all -> 0x00f5 }
            com.ironsource.mediationsdk.IronSource$AD_UNIT[] r11 = new com.ironsource.mediationsdk.IronSource.AD_UNIT[r11]     // Catch:{ all -> 0x00f5 }
            java.lang.Object[] r10 = r10.toArray(r11)     // Catch:{ all -> 0x00f5 }
            r5 = r10
            com.ironsource.mediationsdk.IronSource$AD_UNIT[] r5 = (com.ironsource.mediationsdk.IronSource.AD_UNIT[]) r5     // Catch:{ all -> 0x00f5 }
            r3 = 1
            r4 = 0
            r0 = r7
            r1 = r8
            r2 = r9
            r0.a(r1, r2, r3, r4, r5)     // Catch:{ all -> 0x00f5 }
        L_0x00f3:
            monitor-exit(r7)
            return
        L_0x00f5:
            r8 = move-exception
            monitor-exit(r7)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.mediationsdk.H.a(android.content.Context, java.lang.String, com.ironsource.mediationsdk.sdk.InitializationListener, com.ironsource.mediationsdk.IronSource$AD_UNIT[]):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:118:0x02e9, code lost:
        return;
     */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0085 A[Catch:{ Exception -> 0x0284 }] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00bf A[Catch:{ Exception -> 0x0284 }] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00e3 A[Catch:{ Exception -> 0x0284 }] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00f3 A[Catch:{ Exception -> 0x0284 }] */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0137 A[Catch:{ Exception -> 0x0284 }] */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x0156 A[Catch:{ Exception -> 0x0284 }] */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x01ad A[Catch:{ Exception -> 0x0284 }] */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x01eb A[SYNTHETIC, Splitter:B:78:0x01eb] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void a(android.content.Context r9, java.lang.String r10, boolean r11, com.ironsource.mediationsdk.sdk.InitializationListener r12, com.ironsource.mediationsdk.IronSource.AD_UNIT... r13) {
        /*
            r8 = this;
            monitor-enter(r8)
            com.ironsource.mediationsdk.logger.IronLog r0 = com.ironsource.mediationsdk.logger.IronLog.INTERNAL     // Catch:{ all -> 0x02ea }
            java.lang.String r1 = ""
            r0.verbose(r1)     // Catch:{ all -> 0x02ea }
            if (r12 == 0) goto L_0x000c
            r8.ag = r12     // Catch:{ all -> 0x02ea }
        L_0x000c:
            java.util.concurrent.atomic.AtomicBoolean r12 = r8.U     // Catch:{ all -> 0x02ea }
            if (r12 == 0) goto L_0x02c6
            java.util.concurrent.atomic.AtomicBoolean r12 = r8.U     // Catch:{ all -> 0x02ea }
            r0 = 0
            r1 = 1
            boolean r12 = r12.compareAndSet(r1, r0)     // Catch:{ all -> 0x02ea }
            if (r12 == 0) goto L_0x02c6
            if (r13 == 0) goto L_0x0051
            int r12 = r13.length     // Catch:{ all -> 0x02ea }
            if (r12 != 0) goto L_0x0020
            goto L_0x0051
        L_0x0020:
            int r12 = r13.length     // Catch:{ all -> 0x02ea }
            r2 = r0
        L_0x0022:
            if (r2 >= r12) goto L_0x0069
            r3 = r13[r2]     // Catch:{ all -> 0x02ea }
            java.util.Set<com.ironsource.mediationsdk.IronSource$AD_UNIT> r4 = r8.X     // Catch:{ all -> 0x02ea }
            r4.add(r3)     // Catch:{ all -> 0x02ea }
            java.util.Set<com.ironsource.mediationsdk.IronSource$AD_UNIT> r4 = r8.Y     // Catch:{ all -> 0x02ea }
            r4.add(r3)     // Catch:{ all -> 0x02ea }
            com.ironsource.mediationsdk.IronSource$AD_UNIT r4 = com.ironsource.mediationsdk.IronSource.AD_UNIT.INTERSTITIAL     // Catch:{ all -> 0x02ea }
            boolean r4 = r3.equals(r4)     // Catch:{ all -> 0x02ea }
            if (r4 == 0) goto L_0x003a
            r8.x = r1     // Catch:{ all -> 0x02ea }
        L_0x003a:
            com.ironsource.mediationsdk.IronSource$AD_UNIT r4 = com.ironsource.mediationsdk.IronSource.AD_UNIT.BANNER     // Catch:{ all -> 0x02ea }
            boolean r4 = r3.equals(r4)     // Catch:{ all -> 0x02ea }
            if (r4 == 0) goto L_0x0044
            r8.ac = r1     // Catch:{ all -> 0x02ea }
        L_0x0044:
            com.ironsource.mediationsdk.IronSource$AD_UNIT r4 = com.ironsource.mediationsdk.IronSource.AD_UNIT.REWARDED_VIDEO     // Catch:{ all -> 0x02ea }
            boolean r3 = r3.equals(r4)     // Catch:{ all -> 0x02ea }
            if (r3 == 0) goto L_0x004e
            r8.w = r1     // Catch:{ all -> 0x02ea }
        L_0x004e:
            int r2 = r2 + 1
            goto L_0x0022
        L_0x0051:
            com.ironsource.mediationsdk.IronSource$AD_UNIT[] r12 = com.ironsource.mediationsdk.IronSource.AD_UNIT.values()     // Catch:{ all -> 0x02ea }
            int r2 = r12.length     // Catch:{ all -> 0x02ea }
            r3 = r0
        L_0x0057:
            if (r3 >= r2) goto L_0x0063
            r4 = r12[r3]     // Catch:{ all -> 0x02ea }
            java.util.Set<com.ironsource.mediationsdk.IronSource$AD_UNIT> r5 = r8.X     // Catch:{ all -> 0x02ea }
            r5.add(r4)     // Catch:{ all -> 0x02ea }
            int r3 = r3 + 1
            goto L_0x0057
        L_0x0063:
            r8.w = r1     // Catch:{ all -> 0x02ea }
            r8.x = r1     // Catch:{ all -> 0x02ea }
            r8.ac = r1     // Catch:{ all -> 0x02ea }
        L_0x0069:
            com.ironsource.mediationsdk.logger.IronLog r12 = com.ironsource.mediationsdk.logger.IronLog.API     // Catch:{ all -> 0x02ea }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x02ea }
            java.lang.String r3 = "init(appKey:"
            r2.<init>(r3)     // Catch:{ all -> 0x02ea }
            r2.append(r10)     // Catch:{ all -> 0x02ea }
            java.lang.String r3 = ")"
            r2.append(r3)     // Catch:{ all -> 0x02ea }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x02ea }
            r12.info(r2)     // Catch:{ all -> 0x02ea }
            boolean r12 = r9 instanceof android.app.Activity     // Catch:{ all -> 0x02ea }
            if (r12 == 0) goto L_0x008f
            com.ironsource.environment.ContextProvider r12 = com.ironsource.environment.ContextProvider.getInstance()     // Catch:{ all -> 0x02ea }
            r2 = r9
            android.app.Activity r2 = (android.app.Activity) r2     // Catch:{ all -> 0x02ea }
            r12.updateActivity(r2)     // Catch:{ all -> 0x02ea }
        L_0x008f:
            com.ironsource.environment.ContextProvider r12 = com.ironsource.environment.ContextProvider.getInstance()     // Catch:{ all -> 0x02ea }
            android.content.Context r2 = r9.getApplicationContext()     // Catch:{ all -> 0x02ea }
            r12.updateAppContext(r2)     // Catch:{ all -> 0x02ea }
            com.ironsource.environment.h.q()     // Catch:{ all -> 0x02ea }
            com.ironsource.d.b r12 = r8.an     // Catch:{ all -> 0x02ea }
            java.lang.String r2 = com.ironsource.mediationsdk.utils.IronSourceUtils.getSDKVersion()     // Catch:{ all -> 0x02ea }
            r12.b((java.lang.String) r2)     // Catch:{ all -> 0x02ea }
            com.ironsource.d.b r12 = r8.an     // Catch:{ all -> 0x02ea }
            com.ironsource.c.b r2 = com.ironsource.c.a.a()     // Catch:{ all -> 0x02ea }
            r12.a((com.ironsource.c.b) r2)     // Catch:{ all -> 0x02ea }
            com.ironsource.d.b r12 = r8.an     // Catch:{ all -> 0x02ea }
            boolean r2 = com.ironsource.mediationsdk.utils.IronSourceUtils.isGooglePlayInstalled(r9)     // Catch:{ all -> 0x02ea }
            r12.b((boolean) r2)     // Catch:{ all -> 0x02ea }
            com.ironsource.d.a r12 = new com.ironsource.d.a     // Catch:{ all -> 0x02ea }
            r12.<init>()     // Catch:{ all -> 0x02ea }
            if (r10 == 0) goto L_0x00e3
            r2 = 5
            r3 = 10
            boolean r2 = a((java.lang.String) r10, (int) r2, (int) r3)     // Catch:{ all -> 0x02ea }
            if (r2 == 0) goto L_0x00da
            boolean r2 = v(r10)     // Catch:{ all -> 0x02ea }
            if (r2 != 0) goto L_0x00ed
            java.lang.String r2 = "appKey"
            java.lang.String r3 = "should contain only english characters and numbers"
            com.ironsource.mediationsdk.logger.IronSourceError r2 = com.ironsource.mediationsdk.utils.ErrorBuilder.buildInvalidCredentialsError(r2, r10, r3)     // Catch:{ all -> 0x02ea }
        L_0x00d6:
            r12.a((com.ironsource.mediationsdk.logger.IronSourceError) r2)     // Catch:{ all -> 0x02ea }
            goto L_0x00ed
        L_0x00da:
            java.lang.String r2 = "appKey"
            java.lang.String r3 = "length should be between 5-10 characters"
            com.ironsource.mediationsdk.logger.IronSourceError r2 = com.ironsource.mediationsdk.utils.ErrorBuilder.buildInvalidCredentialsError(r2, r10, r3)     // Catch:{ all -> 0x02ea }
            goto L_0x00d6
        L_0x00e3:
            com.ironsource.mediationsdk.logger.IronSourceError r2 = new com.ironsource.mediationsdk.logger.IronSourceError     // Catch:{ all -> 0x02ea }
            r3 = 506(0x1fa, float:7.09E-43)
            java.lang.String r4 = "Init Fail - appKey is missing"
            r2.<init>(r3, r4)     // Catch:{ all -> 0x02ea }
            goto L_0x00d6
        L_0x00ed:
            boolean r2 = r12.a()     // Catch:{ all -> 0x02ea }
            if (r2 == 0) goto L_0x00f5
            r8.j = r10     // Catch:{ all -> 0x02ea }
        L_0x00f5:
            com.ironsource.environment.ContextProvider r2 = com.ironsource.environment.ContextProvider.getInstance()     // Catch:{ all -> 0x02ea }
            android.content.Context r2 = r2.getApplicationContext()     // Catch:{ all -> 0x02ea }
            boolean r3 = com.ironsource.mediationsdk.utils.IronSourceUtils.isInitResponseCached(r2)     // Catch:{ all -> 0x02ea }
            long r4 = com.ironsource.mediationsdk.utils.IronSourceUtils.getFirstSessionTimestamp(r2)     // Catch:{ all -> 0x02ea }
            if (r3 != 0) goto L_0x0127
            r6 = -1
            int r3 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r3 != 0) goto L_0x0127
            long r3 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x02ea }
            com.ironsource.mediationsdk.logger.IronLog r5 = com.ironsource.mediationsdk.logger.IronLog.INTERNAL     // Catch:{ all -> 0x02ea }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x02ea }
            java.lang.String r7 = "get first session timestamp = "
            r6.<init>(r7)     // Catch:{ all -> 0x02ea }
            r6.append(r3)     // Catch:{ all -> 0x02ea }
            java.lang.String r6 = r6.toString()     // Catch:{ all -> 0x02ea }
            r5.verbose(r6)     // Catch:{ all -> 0x02ea }
            com.ironsource.mediationsdk.utils.IronSourceUtils.saveFirstSessionTimestamp(r2, r3)     // Catch:{ all -> 0x02ea }
        L_0x0127:
            com.ironsource.environment.ContextProvider r2 = com.ironsource.environment.ContextProvider.getInstance()     // Catch:{ all -> 0x02ea }
            android.content.Context r2 = r2.getApplicationContext()     // Catch:{ all -> 0x02ea }
            java.lang.String r3 = r8.k     // Catch:{ all -> 0x02ea }
            com.ironsource.mediationsdk.utils.l r2 = r8.a((android.content.Context) r2, (java.lang.String) r3)     // Catch:{ all -> 0x02ea }
            if (r2 == 0) goto L_0x0146
            com.ironsource.environment.g r3 = com.ironsource.environment.g.a     // Catch:{ all -> 0x02ea }
            com.ironsource.mediationsdk.model.g r2 = r2.c     // Catch:{ all -> 0x02ea }
            com.ironsource.sdk.f.a r2 = r2.e     // Catch:{ all -> 0x02ea }
            com.ironsource.mediationsdk.utils.b r2 = r2.f()     // Catch:{ all -> 0x02ea }
            boolean r2 = r2.c     // Catch:{ all -> 0x02ea }
            com.ironsource.environment.g.a(r2)     // Catch:{ all -> 0x02ea }
        L_0x0146:
            com.ironsource.mediationsdk.utils.k r2 = com.ironsource.mediationsdk.utils.k.a()     // Catch:{ all -> 0x02ea }
            java.util.concurrent.ConcurrentHashMap r2 = r2.d()     // Catch:{ all -> 0x02ea }
            java.lang.String r3 = "is_deviceid_optout"
            boolean r3 = r2.containsKey(r3)     // Catch:{ all -> 0x02ea }
            if (r3 == 0) goto L_0x0178
            java.lang.String r3 = "is_deviceid_optout"
            java.lang.Object r2 = r2.get(r3)     // Catch:{ all -> 0x02ea }
            java.util.List r2 = (java.util.List) r2     // Catch:{ all -> 0x02ea }
            java.lang.Object r2 = r2.get(r0)     // Catch:{ all -> 0x02ea }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ all -> 0x02ea }
            boolean r3 = android.text.TextUtils.isEmpty(r2)     // Catch:{ all -> 0x02ea }
            if (r3 != 0) goto L_0x0178
            boolean r2 = com.ironsource.mediationsdk.metadata.MetaDataUtils.getMetaDataBooleanValue(r2)     // Catch:{ all -> 0x02ea }
            if (r2 != 0) goto L_0x0172
            r2 = r1
            goto L_0x0173
        L_0x0172:
            r2 = r0
        L_0x0173:
            com.ironsource.environment.g r3 = com.ironsource.environment.g.a     // Catch:{ all -> 0x02ea }
            com.ironsource.environment.g.b(r2)     // Catch:{ all -> 0x02ea }
        L_0x0178:
            java.util.concurrent.atomic.AtomicBoolean r2 = r8.S     // Catch:{ all -> 0x02ea }
            if (r2 == 0) goto L_0x01a9
            java.util.concurrent.atomic.AtomicBoolean r2 = r8.S     // Catch:{ all -> 0x02ea }
            boolean r2 = r2.compareAndSet(r0, r1)     // Catch:{ all -> 0x02ea }
            if (r2 == 0) goto L_0x01a9
            com.ironsource.mediationsdk.a.i r2 = com.ironsource.mediationsdk.a.i.a()     // Catch:{ all -> 0x02ea }
            com.ironsource.mediationsdk.utils.h r3 = new com.ironsource.mediationsdk.utils.h     // Catch:{ all -> 0x02ea }
            r3.<init>(r9)     // Catch:{ all -> 0x02ea }
            r2.a(r3)     // Catch:{ all -> 0x02ea }
            com.ironsource.mediationsdk.a.d r2 = com.ironsource.mediationsdk.a.d.e()     // Catch:{ all -> 0x02ea }
            com.ironsource.mediationsdk.IronSourceSegment r3 = r8.s     // Catch:{ all -> 0x02ea }
            r2.a((android.content.Context) r9, (com.ironsource.mediationsdk.IronSourceSegment) r3)     // Catch:{ all -> 0x02ea }
            com.ironsource.mediationsdk.a.h r2 = com.ironsource.mediationsdk.a.h.e()     // Catch:{ all -> 0x02ea }
            com.ironsource.mediationsdk.IronSourceSegment r3 = r8.s     // Catch:{ all -> 0x02ea }
            r2.a((android.content.Context) r9, (com.ironsource.mediationsdk.IronSourceSegment) r3)     // Catch:{ all -> 0x02ea }
            com.ironsource.mediationsdk.a.g r2 = com.ironsource.mediationsdk.a.g.w     // Catch:{ all -> 0x02ea }
            com.ironsource.mediationsdk.IronSourceSegment r3 = r8.s     // Catch:{ all -> 0x02ea }
            r2.a((android.content.Context) r9, (com.ironsource.mediationsdk.IronSourceSegment) r3)     // Catch:{ all -> 0x02ea }
        L_0x01a9:
            java.lang.String r2 = r8.j     // Catch:{ all -> 0x02ea }
            if (r2 != 0) goto L_0x01eb
            com.ironsource.mediationsdk.M r9 = com.ironsource.mediationsdk.M.a()     // Catch:{ all -> 0x02ea }
            com.ironsource.mediationsdk.M$a r10 = com.ironsource.mediationsdk.M.a.INIT_FAILED     // Catch:{ all -> 0x02ea }
            r9.a((com.ironsource.mediationsdk.M.a) r10)     // Catch:{ all -> 0x02ea }
            java.util.Set<com.ironsource.mediationsdk.IronSource$AD_UNIT> r9 = r8.X     // Catch:{ all -> 0x02ea }
            com.ironsource.mediationsdk.IronSource$AD_UNIT r10 = com.ironsource.mediationsdk.IronSource.AD_UNIT.REWARDED_VIDEO     // Catch:{ all -> 0x02ea }
            boolean r9 = r9.contains(r10)     // Catch:{ all -> 0x02ea }
            if (r9 == 0) goto L_0x01c5
            com.ironsource.mediationsdk.sdk.i r9 = r8.g     // Catch:{ all -> 0x02ea }
            r9.onRewardedVideoAvailabilityChanged(r0)     // Catch:{ all -> 0x02ea }
        L_0x01c5:
            java.util.Set<com.ironsource.mediationsdk.IronSource$AD_UNIT> r9 = r8.X     // Catch:{ all -> 0x02ea }
            com.ironsource.mediationsdk.IronSource$AD_UNIT r10 = com.ironsource.mediationsdk.IronSource.AD_UNIT.OFFERWALL     // Catch:{ all -> 0x02ea }
            boolean r9 = r9.contains(r10)     // Catch:{ all -> 0x02ea }
            if (r9 == 0) goto L_0x01d8
            com.ironsource.mediationsdk.sdk.i r9 = r8.g     // Catch:{ all -> 0x02ea }
            com.ironsource.mediationsdk.logger.IronSourceError r10 = r12.b()     // Catch:{ all -> 0x02ea }
            r9.a((boolean) r0, (com.ironsource.mediationsdk.logger.IronSourceError) r10)     // Catch:{ all -> 0x02ea }
        L_0x01d8:
            com.ironsource.mediationsdk.logger.IronSourceLoggerManager r9 = com.ironsource.mediationsdk.logger.IronSourceLoggerManager.getLogger()     // Catch:{ all -> 0x02ea }
            com.ironsource.mediationsdk.logger.IronSourceLogger$IronSourceTag r10 = com.ironsource.mediationsdk.logger.IronSourceLogger.IronSourceTag.API     // Catch:{ all -> 0x02ea }
            com.ironsource.mediationsdk.logger.IronSourceError r11 = r12.b()     // Catch:{ all -> 0x02ea }
            java.lang.String r11 = r11.toString()     // Catch:{ all -> 0x02ea }
            r9.log(r10, r11, r1)     // Catch:{ all -> 0x02ea }
            monitor-exit(r8)
            return
        L_0x01eb:
            com.ironsource.d.b r12 = r8.an     // Catch:{ all -> 0x02ea }
            r12.a((android.content.Context) r9)     // Catch:{ all -> 0x02ea }
            com.ironsource.d.b r12 = r8.an     // Catch:{ all -> 0x02ea }
            java.lang.String r2 = r8.j     // Catch:{ all -> 0x02ea }
            r12.a((java.lang.String) r2)     // Catch:{ all -> 0x02ea }
            com.ironsource.d.b r12 = r8.an     // Catch:{ all -> 0x02ea }
            java.lang.String r2 = r8.p     // Catch:{ all -> 0x02ea }
            r12.c(r2)     // Catch:{ all -> 0x02ea }
            com.ironsource.d.b r12 = r8.an     // Catch:{ all -> 0x02ea }
            com.ironsource.mediationsdk.config.ConfigFile r2 = com.ironsource.mediationsdk.config.ConfigFile.getConfigFile()     // Catch:{ all -> 0x02ea }
            java.lang.String r2 = r2.getPluginType()     // Catch:{ all -> 0x02ea }
            r12.d(r2)     // Catch:{ all -> 0x02ea }
            boolean r12 = r8.Z     // Catch:{ all -> 0x02ea }
            if (r12 == 0) goto L_0x0298
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ all -> 0x02ea }
            r12.<init>()     // Catch:{ all -> 0x02ea }
            org.json.JSONObject r11 = com.ironsource.mediationsdk.utils.IronSourceUtils.getMediationAdditionalData(r11)     // Catch:{ all -> 0x02ea }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0284 }
            java.lang.String r3 = ",androidx="
            r2.<init>(r3)     // Catch:{ Exception -> 0x0284 }
            boolean r3 = com.ironsource.mediationsdk.utils.IronSourceUtils.isAndroidXAvailable()     // Catch:{ Exception -> 0x0284 }
            r2.append(r3)     // Catch:{ Exception -> 0x0284 }
            java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x0284 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0284 }
            java.lang.String r4 = ",Activity="
            r3.<init>(r4)     // Catch:{ Exception -> 0x0284 }
            boolean r4 = D()     // Catch:{ Exception -> 0x0284 }
            r3.append(r4)     // Catch:{ Exception -> 0x0284 }
            java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x0284 }
            boolean r4 = com.ironsource.environment.a.AnonymousClass1.d()     // Catch:{ Exception -> 0x0284 }
            if (r4 == 0) goto L_0x024f
            java.lang.String r4 = "appLanguage=Kotlin"
            r12.append(r4)     // Catch:{ Exception -> 0x0284 }
            java.lang.String r4 = com.ironsource.environment.a.AnonymousClass1.c()     // Catch:{ Exception -> 0x0284 }
        L_0x024b:
            r12.append(r4)     // Catch:{ Exception -> 0x0284 }
            goto L_0x0252
        L_0x024f:
            java.lang.String r4 = "appLanguage=Java"
            goto L_0x024b
        L_0x0252:
            r12.append(r2)     // Catch:{ Exception -> 0x0284 }
            boolean r2 = r8.m()     // Catch:{ Exception -> 0x0284 }
            if (r2 == 0) goto L_0x025e
            r12.append(r3)     // Catch:{ Exception -> 0x0284 }
        L_0x025e:
            java.lang.String r2 = "ext1"
            java.lang.String r12 = r12.toString()     // Catch:{ Exception -> 0x0284 }
            r11.put(r2, r12)     // Catch:{ Exception -> 0x0284 }
            if (r13 == 0) goto L_0x0279
            int r12 = r13.length     // Catch:{ Exception -> 0x0284 }
            r2 = r0
        L_0x026b:
            if (r2 >= r12) goto L_0x0279
            r3 = r13[r2]     // Catch:{ Exception -> 0x0284 }
            java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x0284 }
            r11.put(r3, r1)     // Catch:{ Exception -> 0x0284 }
            int r2 = r2 + 1
            goto L_0x026b
        L_0x0279:
            java.lang.String r12 = "sessionDepth"
            int r13 = r8.t     // Catch:{ Exception -> 0x0284 }
            int r13 = r13 + r1
            r8.t = r13     // Catch:{ Exception -> 0x0284 }
            r11.put(r12, r13)     // Catch:{ Exception -> 0x0284 }
            goto L_0x0288
        L_0x0284:
            r12 = move-exception
            r12.printStackTrace()     // Catch:{ all -> 0x02ea }
        L_0x0288:
            com.ironsource.mediationsdk.a.c r12 = new com.ironsource.mediationsdk.a.c     // Catch:{ all -> 0x02ea }
            r13 = 14
            r12.<init>(r13, r11)     // Catch:{ all -> 0x02ea }
            com.ironsource.mediationsdk.a.h r11 = com.ironsource.mediationsdk.a.h.e()     // Catch:{ all -> 0x02ea }
            r11.b((com.ironsource.mediationsdk.a.c) r12)     // Catch:{ all -> 0x02ea }
            r8.Z = r0     // Catch:{ all -> 0x02ea }
        L_0x0298:
            java.util.Set<com.ironsource.mediationsdk.IronSource$AD_UNIT> r11 = r8.X     // Catch:{ all -> 0x02ea }
            com.ironsource.mediationsdk.IronSource$AD_UNIT r12 = com.ironsource.mediationsdk.IronSource.AD_UNIT.INTERSTITIAL     // Catch:{ all -> 0x02ea }
            boolean r11 = r11.contains(r12)     // Catch:{ all -> 0x02ea }
            if (r11 == 0) goto L_0x02ab
            com.ironsource.mediationsdk.M r11 = com.ironsource.mediationsdk.M.a()     // Catch:{ all -> 0x02ea }
            com.ironsource.mediationsdk.E r12 = r8.c     // Catch:{ all -> 0x02ea }
            r11.a((com.ironsource.mediationsdk.utils.i) r12)     // Catch:{ all -> 0x02ea }
        L_0x02ab:
            com.ironsource.mediationsdk.M r11 = com.ironsource.mediationsdk.M.a()     // Catch:{ all -> 0x02ea }
            r11.a((com.ironsource.mediationsdk.utils.i) r8)     // Catch:{ all -> 0x02ea }
            com.ironsource.mediationsdk.M r11 = com.ironsource.mediationsdk.M.a()     // Catch:{ all -> 0x02ea }
            com.ironsource.mediationsdk.impressionData.a r12 = r8.O     // Catch:{ all -> 0x02ea }
            r11.a((com.ironsource.mediationsdk.utils.i) r12)     // Catch:{ all -> 0x02ea }
            com.ironsource.mediationsdk.M r11 = com.ironsource.mediationsdk.M.a()     // Catch:{ all -> 0x02ea }
            java.lang.String r12 = r8.k     // Catch:{ all -> 0x02ea }
            r11.a(r9, r10, r12)     // Catch:{ all -> 0x02ea }
            monitor-exit(r8)
            return
        L_0x02c6:
            if (r13 == 0) goto L_0x02de
            r8.a((boolean) r11, (com.ironsource.mediationsdk.IronSource.AD_UNIT[]) r13)     // Catch:{ all -> 0x02ea }
            com.ironsource.mediationsdk.M r9 = com.ironsource.mediationsdk.M.a()     // Catch:{ all -> 0x02ea }
            com.ironsource.mediationsdk.M$a r9 = r9.b()     // Catch:{ all -> 0x02ea }
            com.ironsource.mediationsdk.M$a r10 = com.ironsource.mediationsdk.M.a.INITIATED     // Catch:{ all -> 0x02ea }
            if (r9 != r10) goto L_0x02e8
            if (r11 != 0) goto L_0x02e8
            r8.E()     // Catch:{ all -> 0x02ea }
            monitor-exit(r8)
            return
        L_0x02de:
            com.ironsource.mediationsdk.logger.IronSourceLoggerManager r9 = r8.f     // Catch:{ all -> 0x02ea }
            com.ironsource.mediationsdk.logger.IronSourceLogger$IronSourceTag r10 = com.ironsource.mediationsdk.logger.IronSourceLogger.IronSourceTag.API     // Catch:{ all -> 0x02ea }
            java.lang.String r11 = "Multiple calls to init without ad units are not allowed"
            r12 = 3
            r9.log(r10, r11, r12)     // Catch:{ all -> 0x02ea }
        L_0x02e8:
            monitor-exit(r8)
            return
        L_0x02ea:
            r9 = move-exception
            monitor-exit(r8)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.mediationsdk.H.a(android.content.Context, java.lang.String, boolean, com.ironsource.mediationsdk.sdk.InitializationListener, com.ironsource.mediationsdk.IronSource$AD_UNIT[]):void");
    }

    /* access modifiers changed from: package-private */
    public final synchronized void a(AbstractAdapter abstractAdapter) {
        this.R = abstractAdapter;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00e3, code lost:
        if (C() != false) goto L_0x00ff;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00e5, code lost:
        r3.f.log(com.ironsource.mediationsdk.logger.IronSourceLogger.IronSourceTag.API, "No banner configurations found", 3);
        com.ironsource.mediationsdk.C0157j.a().a(r4, new com.ironsource.mediationsdk.logger.IronSourceError(com.ironsource.mediationsdk.logger.IronSourceError.ERROR_BN_LOAD_NO_CONFIG, "No banner configurations found"));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00fe, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x0101, code lost:
        if (r3.K != false) goto L_0x010d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x0103, code lost:
        r3.e.a(r4, x(r5));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x010c, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x010d, code lost:
        r3.B.a(r4, x(r5));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x0116, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(com.ironsource.mediationsdk.IronSourceBannerLayout r4, java.lang.String r5) {
        /*
            r3 = this;
            com.ironsource.mediationsdk.logger.IronLog r0 = com.ironsource.mediationsdk.logger.IronLog.INTERNAL
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "placementName = "
            r1.<init>(r2)
            r1.append(r5)
            java.lang.String r1 = r1.toString()
            r0.verbose(r1)
            r0 = 3
            if (r4 == 0) goto L_0x011a
            boolean r1 = r4.isDestroyed()
            if (r1 == 0) goto L_0x001e
            goto L_0x011a
        L_0x001e:
            boolean r1 = r3.ac
            if (r1 != 0) goto L_0x0037
            java.lang.String r5 = "init() must be called before loadBanner()"
            com.ironsource.mediationsdk.logger.IronSourceLoggerManager r1 = r3.f
            com.ironsource.mediationsdk.logger.IronSourceLogger$IronSourceTag r2 = com.ironsource.mediationsdk.logger.IronSourceLogger.IronSourceTag.API
            r1.log(r2, r5, r0)
            com.ironsource.mediationsdk.j r0 = com.ironsource.mediationsdk.C0157j.a()
            com.ironsource.mediationsdk.logger.IronSourceError r5 = com.ironsource.mediationsdk.utils.ErrorBuilder.buildLoadFailedError(r5)
            r0.a(r4, r5)
            return
        L_0x0037:
            com.ironsource.mediationsdk.ISBannerSize r1 = r4.getSize()
            java.lang.String r1 = r1.getDescription()
            java.lang.String r2 = "CUSTOM"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0072
            com.ironsource.mediationsdk.ISBannerSize r1 = r4.getSize()
            int r1 = r1.getWidth()
            if (r1 <= 0) goto L_0x005b
            com.ironsource.mediationsdk.ISBannerSize r1 = r4.getSize()
            int r1 = r1.getHeight()
            if (r1 > 0) goto L_0x0072
        L_0x005b:
            com.ironsource.mediationsdk.logger.IronSourceLoggerManager r5 = r3.f
            com.ironsource.mediationsdk.logger.IronSourceLogger$IronSourceTag r1 = com.ironsource.mediationsdk.logger.IronSourceLogger.IronSourceTag.API
            java.lang.String r2 = "loadBanner: Unsupported banner size. Height and width must be bigger than 0"
            r5.log(r1, r2, r0)
            com.ironsource.mediationsdk.j r5 = com.ironsource.mediationsdk.C0157j.a()
            java.lang.String r0 = ""
            com.ironsource.mediationsdk.logger.IronSourceError r0 = com.ironsource.mediationsdk.utils.ErrorBuilder.unsupportedBannerSize(r0)
            r5.a(r4, r0)
            return
        L_0x0072:
            com.ironsource.mediationsdk.M r1 = com.ironsource.mediationsdk.M.a()
            com.ironsource.mediationsdk.M$a r1 = r1.b()
            com.ironsource.mediationsdk.M$a r2 = com.ironsource.mediationsdk.M.a.INIT_FAILED
            if (r1 != r2) goto L_0x0098
            com.ironsource.mediationsdk.logger.IronSourceLoggerManager r5 = r3.f
            com.ironsource.mediationsdk.logger.IronSourceLogger$IronSourceTag r1 = com.ironsource.mediationsdk.logger.IronSourceLogger.IronSourceTag.API
            java.lang.String r2 = "init() had failed"
            r5.log(r1, r2, r0)
            com.ironsource.mediationsdk.j r5 = com.ironsource.mediationsdk.C0157j.a()
            com.ironsource.mediationsdk.logger.IronSourceError r0 = new com.ironsource.mediationsdk.logger.IronSourceError
            r1 = 600(0x258, float:8.41E-43)
            java.lang.String r2 = "Init() had failed"
            r0.<init>(r1, r2)
            r5.a(r4, r0)
            return
        L_0x0098:
            com.ironsource.mediationsdk.M$a r2 = com.ironsource.mediationsdk.M.a.INIT_IN_PROGRESS
            if (r1 != r2) goto L_0x00c9
            com.ironsource.mediationsdk.M r1 = com.ironsource.mediationsdk.M.a()
            boolean r1 = r1.c()
            if (r1 == 0) goto L_0x00c0
            com.ironsource.mediationsdk.logger.IronSourceLoggerManager r5 = r3.f
            com.ironsource.mediationsdk.logger.IronSourceLogger$IronSourceTag r1 = com.ironsource.mediationsdk.logger.IronSourceLogger.IronSourceTag.API
            java.lang.String r2 = "init() had failed"
            r5.log(r1, r2, r0)
            com.ironsource.mediationsdk.j r5 = com.ironsource.mediationsdk.C0157j.a()
            com.ironsource.mediationsdk.logger.IronSourceError r0 = new com.ironsource.mediationsdk.logger.IronSourceError
            r1 = 601(0x259, float:8.42E-43)
            java.lang.String r2 = "Init had failed"
            r0.<init>(r1, r2)
            r5.a(r4, r0)
            return
        L_0x00c0:
            r3.ae = r4
            java.lang.Boolean r4 = java.lang.Boolean.TRUE
            r3.ad = r4
            r3.af = r5
            return
        L_0x00c9:
            java.lang.Boolean r1 = r3.ad
            monitor-enter(r1)
            com.ironsource.mediationsdk.k r2 = r3.e     // Catch:{ all -> 0x0117 }
            if (r2 != 0) goto L_0x00de
            com.ironsource.mediationsdk.P r2 = r3.B     // Catch:{ all -> 0x0117 }
            if (r2 != 0) goto L_0x00de
            r3.ae = r4     // Catch:{ all -> 0x0117 }
            java.lang.Boolean r4 = java.lang.Boolean.TRUE     // Catch:{ all -> 0x0117 }
            r3.ad = r4     // Catch:{ all -> 0x0117 }
            r3.af = r5     // Catch:{ all -> 0x0117 }
            monitor-exit(r1)     // Catch:{ all -> 0x0117 }
            return
        L_0x00de:
            monitor-exit(r1)     // Catch:{ all -> 0x0117 }
            boolean r1 = r3.C()
            if (r1 != 0) goto L_0x00ff
            com.ironsource.mediationsdk.logger.IronSourceLoggerManager r5 = r3.f
            com.ironsource.mediationsdk.logger.IronSourceLogger$IronSourceTag r1 = com.ironsource.mediationsdk.logger.IronSourceLogger.IronSourceTag.API
            java.lang.String r2 = "No banner configurations found"
            r5.log(r1, r2, r0)
            com.ironsource.mediationsdk.j r5 = com.ironsource.mediationsdk.C0157j.a()
            com.ironsource.mediationsdk.logger.IronSourceError r0 = new com.ironsource.mediationsdk.logger.IronSourceError
            r1 = 615(0x267, float:8.62E-43)
            java.lang.String r2 = "No banner configurations found"
            r0.<init>(r1, r2)
            r5.a(r4, r0)
            return
        L_0x00ff:
            boolean r0 = r3.K
            if (r0 != 0) goto L_0x010d
            com.ironsource.mediationsdk.k r0 = r3.e
            com.ironsource.mediationsdk.model.f r5 = r3.x(r5)
            r0.a((com.ironsource.mediationsdk.IronSourceBannerLayout) r4, (com.ironsource.mediationsdk.model.f) r5)
            return
        L_0x010d:
            com.ironsource.mediationsdk.P r0 = r3.B
            com.ironsource.mediationsdk.model.f r5 = r3.x(r5)
            r0.a((com.ironsource.mediationsdk.IronSourceBannerLayout) r4, (com.ironsource.mediationsdk.model.f) r5)
            return
        L_0x0117:
            r4 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x0117 }
            throw r4
        L_0x011a:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.String r1 = "loadBanner can't be called - "
            r5.<init>(r1)
            if (r4 != 0) goto L_0x0126
            java.lang.String r1 = "banner layout is null "
            goto L_0x0128
        L_0x0126:
            java.lang.String r1 = "banner layout is destroyed"
        L_0x0128:
            r5.append(r1)
            java.lang.String r5 = r5.toString()
            com.ironsource.mediationsdk.logger.IronSourceLoggerManager r1 = r3.f
            com.ironsource.mediationsdk.logger.IronSourceLogger$IronSourceTag r2 = com.ironsource.mediationsdk.logger.IronSourceLogger.IronSourceTag.API
            r1.log(r2, r5, r0)
            com.ironsource.mediationsdk.j r0 = com.ironsource.mediationsdk.C0157j.a()
            com.ironsource.mediationsdk.logger.IronSourceError r5 = com.ironsource.mediationsdk.utils.ErrorBuilder.buildLoadFailedError(r5)
            r0.a(r4, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.mediationsdk.H.a(com.ironsource.mediationsdk.IronSourceBannerLayout, java.lang.String):void");
    }

    public final void a(RewardedVideoListener rewardedVideoListener) {
        this.f.log(IronSourceLogger.IronSourceTag.API, rewardedVideoListener == null ? "setRewardedVideoListener(RVListener:null)" : "setRewardedVideoListener(RVListener)", 1);
        this.g.a = rewardedVideoListener;
        aa.a().a = rewardedVideoListener;
    }

    public final synchronized void a(RewardedVideoManualListener rewardedVideoManualListener) {
        if (this.w) {
            IronLog.API.error("setManualLoadRewardedVideo - this method needs to be called before init");
        } else if (rewardedVideoManualListener == null) {
            IronLog.API.error("setManualLoadRewardedVideo - listener can not be null");
            this.F = false;
        } else {
            this.f.log(IronSourceLogger.IronSourceTag.API, "setting RewardedVideo to manual mode", 1);
            this.F = true;
            C0163p.a().b = rewardedVideoManualListener;
            a((RewardedVideoListener) rewardedVideoManualListener);
        }
    }

    public final void a(String str) {
        try {
            IronSourceLoggerManager ironSourceLoggerManager = this.f;
            IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.API;
            ironSourceLoggerManager.log(ironSourceTag, "onInitFailed(reason:" + str + ")", 1);
            IronSourceUtils.sendAutomationLog("Mediation init failed");
            if (this.g != null) {
                for (IronSource.AD_UNIT a2 : this.X) {
                    a(a2, true);
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final void a(String str, List<String> list) {
        IronLog ironLog = IronLog.API;
        ironLog.verbose("key = " + str + ", values = " + list.toString());
        String checkMetaDataKeyValidity = MetaDataUtils.checkMetaDataKeyValidity(str);
        String checkMetaDataValueValidity = MetaDataUtils.checkMetaDataValueValidity(list);
        if (checkMetaDataKeyValidity.length() > 0) {
            IronLog.API.verbose(checkMetaDataKeyValidity);
        } else if (checkMetaDataValueValidity.length() > 0) {
            IronLog.API.verbose(checkMetaDataValueValidity);
        } else {
            MetaData formatMetaData = MetaDataUtils.formatMetaData(str, list);
            String metaDataKey = formatMetaData.getMetaDataKey();
            List<String> metaDataValue = formatMetaData.getMetaDataValue();
            if (!MetaDataUtils.isMediationOnlyKey(metaDataKey)) {
                C0151d.a().a(metaDataKey, metaDataValue);
            } else if (M.a().b() != M.a.INITIATED || !MetaDataUtils.isMediationKeysBeforeInit(metaDataKey)) {
                k.a().a(metaDataKey, metaDataValue);
            } else {
                IronLog ironLog2 = IronLog.API;
                ironLog2.error("setMetaData with key = " + metaDataKey + " must to be called before init");
            }
            try {
                ConcurrentHashMap<String, List<String>> concurrentHashMap = C0151d.a().c;
                concurrentHashMap.putAll(k.a().d());
                JSONObject jSONObject = new JSONObject();
                for (Map.Entry next : concurrentHashMap.entrySet()) {
                    jSONObject.put((String) next.getKey(), next.getValue());
                }
                this.an.a(jSONObject);
            } catch (JSONException e2) {
                IronLog ironLog3 = IronLog.INTERNAL;
                ironLog3.error("got the following error " + e2.getMessage());
                e2.printStackTrace();
            }
            com.ironsource.mediationsdk.a.h.e().b(new c(M.a().b() == M.a.INITIATED ? 51 : 50, IronSourceUtils.getJsonForMetaData(str, list, metaDataValue)));
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(String str, boolean z2) {
        IronLog ironLog = IronLog.API;
        ironLog.verbose("userId = " + str + ", isFromPublisher = " + z2);
        this.k = str;
        if (z2) {
            com.ironsource.mediationsdk.a.h.e().b(new c(52, IronSourceUtils.getJsonForUserId(false)));
        }
    }

    public final void a(List<IronSource.AD_UNIT> list, boolean z2, com.ironsource.mediationsdk.model.g gVar) {
        IronLog.INTERNAL.verbose("");
        try {
            this.W = list;
            this.V = true;
            this.f.log(IronSourceLogger.IronSourceTag.API, "onInitSuccess()", 1);
            IronSourceUtils.sendAutomationLog("init success");
            if (z2) {
                JSONObject mediationAdditionalData = IronSourceUtils.getMediationAdditionalData(false);
                try {
                    mediationAdditionalData.put("revived", true);
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
                com.ironsource.mediationsdk.a.h.e().b(new c(114, mediationAdditionalData));
            }
            Activity currentActiveActivity = ContextProvider.getInstance().getCurrentActiveActivity();
            if (currentActiveActivity != null) {
                String screenSizeParams = AdapterUtils.getScreenSizeParams(currentActiveActivity);
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put(IronSourceConstants.EVENTS_EXT1, screenSizeParams);
                } catch (JSONException e3) {
                    e3.printStackTrace();
                }
                d.e().b(new c(IronSourceConstants.TROUBLESHOOTING_SCREEN_SIZE, jSONObject));
            }
            d.e().d();
            com.ironsource.mediationsdk.a.h.e().d();
            C0151d a2 = C0151d.a();
            String str = this.j;
            String str2 = this.k;
            a2.a = str;
            a2.b = str2;
            for (IronSource.AD_UNIT ad_unit : IronSource.AD_UNIT.values()) {
                if (this.X.contains(ad_unit)) {
                    if (list.contains(ad_unit)) {
                        b(ad_unit);
                    } else {
                        a(ad_unit, false);
                    }
                }
            }
            E();
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    /* access modifiers changed from: package-private */
    public final synchronized AbstractAdapter b(String str) {
        try {
            if (this.R != null && this.R.getProviderName().equals(str)) {
                return this.R;
            }
        } catch (Exception e2) {
            IronSourceLoggerManager ironSourceLoggerManager = this.f;
            IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.INTERNAL;
            ironSourceLoggerManager.log(ironSourceTag, "getOfferwallAdapter exception: " + e2, 1);
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public Placement b() {
        o oVar = this.i.c.a;
        if (oVar != null) {
            return oVar.a();
        }
        return null;
    }

    public final String b(Context context) {
        String str;
        p pVar;
        JSONObject jSONObject;
        a((int) IronSourceConstants.TROUBLESHOOTING_DO_GET_BIDDING_DATA_CALLED, (JSONObject) null);
        if (context == null) {
            IronLog.API.error("bidding data cannot be retrieved, context required");
            return null;
        }
        M.a b2 = M.a().b();
        if (b2 == M.a.NOT_INIT) {
            IronLog.API.error("bidding data cannot be retrieved, SDK not initialized");
            a((int) IronSourceConstants.TROUBLESHOOTING_DO_GET_BIDDING_DATA_RETURNED_NULL, (JSONObject) null);
            return null;
        } else if (b2 == M.a.INIT_FAILED) {
            IronLog.API.error("bidding data cannot be retrieved, SDK failed to initialize");
            a((int) IronSourceConstants.TROUBLESHOOTING_DO_GET_BIDDING_DATA_RETURNED_NULL, (JSONObject) null);
            return null;
        } else {
            try {
                l a2 = this.i != null ? this.i : D.a(context);
                if (b2 == M.a.NOT_INIT) {
                    this.an.a(context);
                    this.an.b(IronSourceUtils.getSDKVersion());
                    this.an.c(this.p);
                    this.an.d(ConfigFile.getConfigFile().getPluginType());
                    this.an.a(com.ironsource.c.a.a());
                    this.an.b(IronSourceUtils.isGooglePlayInstalled(context));
                }
                if (b2 != M.a.INITIATED) {
                    M.a().a(a2);
                    if (a2 != null) {
                        M.a().a(context, a2);
                    }
                }
                if (a2 == null || !a2.b()) {
                    pVar = new p();
                } else {
                    pVar = a2.c.e.c();
                    if (!pVar.d) {
                        pVar.b = a2.b.a(IronSourceConstants.IRONSOURCE_CONFIG_NAME);
                    }
                }
                Intrinsics.checkNotNullParameter(context, "context");
                Intrinsics.checkNotNullParameter(pVar, "tokenSettings");
                if (pVar.d) {
                    com.ironsource.environment.f.b bVar = new com.ironsource.environment.f.b();
                    Intrinsics.checkNotNullParameter(context, "context");
                    JSONObject a3 = C0160m.a(context, bVar.a);
                    Intrinsics.checkNotNullExpressionValue(a3, "mGlobalDataReader.getDat…s(context, mTokenKeyList)");
                    jSONObject = com.ironsource.environment.f.b.a(a3);
                } else {
                    NetworkSettings networkSettings = pVar.b;
                    if (networkSettings != null) {
                        C0151d a4 = C0151d.a();
                        Intrinsics.checkNotNullExpressionValue(networkSettings, "it");
                        AbstractAdapter a5 = a4.a(networkSettings, networkSettings.getApplicationSettings(), true, false);
                        if (a5 != null) {
                            jSONObject = C0153f.a().a(a5.getPlayerBiddingData(), pVar.c, (List<String>) pVar.a);
                        }
                    }
                    jSONObject = null;
                }
                C0153f.a().a(jSONObject, true);
                str = pVar.e ? IronSourceAES.compressAndEncrypt(jSONObject.toString()) : IronSourceAES.encrypt(jSONObject.toString());
            } catch (Throwable th) {
                a((int) IronSourceConstants.TROUBLESHOOTING_DO_GET_BIDDING_DATA_ENRICH_TOKEN_ERROR, (JSONObject) null);
                IronLog.API.error("got error during token creation: " + th.getMessage());
                str = null;
            }
            if (str == null) {
                a((int) IronSourceConstants.TROUBLESHOOTING_DO_GET_BIDDING_DATA_RETURNED_NULL, (JSONObject) null);
            }
            return str;
        }
    }

    /*  JADX ERROR: IndexOutOfBoundsException in pass: RegionMakerVisitor
        java.lang.IndexOutOfBoundsException: Index: 0, Size: 0
        	at java.util.ArrayList.rangeCheck(ArrayList.java:659)
        	at java.util.ArrayList.get(ArrayList.java:435)
        	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:101)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:611)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:698)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:693)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:698)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:698)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:698)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:598)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
        */
    public final synchronized void b(android.app.Activity r6, java.lang.String r7, java.lang.String r8) {
        /*
            r5 = this;
            monitor-enter(r5)
            com.ironsource.mediationsdk.logger.IronSourceLoggerManager r0 = r5.f     // Catch:{ all -> 0x0162 }
            com.ironsource.mediationsdk.logger.IronSourceLogger$IronSourceTag r1 = com.ironsource.mediationsdk.logger.IronSourceLogger.IronSourceTag.API     // Catch:{ all -> 0x0162 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0162 }
            java.lang.String r3 = "loadISDemandOnlyRewardedVideo() instanceId="
            r2.<init>(r3)     // Catch:{ all -> 0x0162 }
            r2.append(r7)     // Catch:{ all -> 0x0162 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0162 }
            r3 = 1
            r0.log(r1, r2, r3)     // Catch:{ all -> 0x0162 }
            boolean r0 = r5.w     // Catch:{ all -> 0x0144 }
            r1 = 508(0x1fc, float:7.12E-43)
            r2 = 3
            if (r0 != 0) goto L_0x0035
            java.lang.String r6 = "initISDemandOnly() must be called before loadISDemandOnlyRewardedVideo()"
            com.ironsource.mediationsdk.logger.IronSourceLoggerManager r8 = r5.f     // Catch:{ all -> 0x0144 }
            com.ironsource.mediationsdk.logger.IronSourceLogger$IronSourceTag r0 = com.ironsource.mediationsdk.logger.IronSourceLogger.IronSourceTag.API     // Catch:{ all -> 0x0144 }
            r8.log(r0, r6, r2)     // Catch:{ all -> 0x0144 }
            com.ironsource.mediationsdk.Z r8 = com.ironsource.mediationsdk.Z.a()     // Catch:{ all -> 0x0144 }
            com.ironsource.mediationsdk.logger.IronSourceError r0 = new com.ironsource.mediationsdk.logger.IronSourceError     // Catch:{ all -> 0x0144 }
            r0.<init>(r1, r6)     // Catch:{ all -> 0x0144 }
            r8.a((java.lang.String) r7, (com.ironsource.mediationsdk.logger.IronSourceError) r0)     // Catch:{ all -> 0x0144 }
            monitor-exit(r5)
            return
        L_0x0035:
            boolean r0 = r5.u     // Catch:{ all -> 0x0144 }
            if (r0 != 0) goto L_0x0050
            java.lang.String r6 = "Rewarded video was initialized in mediation mode"
            com.ironsource.mediationsdk.logger.IronSourceLoggerManager r8 = r5.f     // Catch:{ all -> 0x0144 }
            com.ironsource.mediationsdk.logger.IronSourceLogger$IronSourceTag r0 = com.ironsource.mediationsdk.logger.IronSourceLogger.IronSourceTag.API     // Catch:{ all -> 0x0144 }
            r8.log(r0, r6, r2)     // Catch:{ all -> 0x0144 }
            com.ironsource.mediationsdk.Z r8 = com.ironsource.mediationsdk.Z.a()     // Catch:{ all -> 0x0144 }
            com.ironsource.mediationsdk.logger.IronSourceError r0 = new com.ironsource.mediationsdk.logger.IronSourceError     // Catch:{ all -> 0x0144 }
            r0.<init>(r1, r6)     // Catch:{ all -> 0x0144 }
            r8.a((java.lang.String) r7, (com.ironsource.mediationsdk.logger.IronSourceError) r0)     // Catch:{ all -> 0x0144 }
            monitor-exit(r5)
            return
        L_0x0050:
            r0 = 0
            if (r6 == 0) goto L_0x005b
            com.ironsource.environment.ContextProvider r1 = com.ironsource.environment.ContextProvider.getInstance()     // Catch:{ all -> 0x0144 }
            r1.updateActivity(r6)     // Catch:{ all -> 0x0144 }
            goto L_0x008c
        L_0x005b:
            com.ironsource.environment.ContextProvider r6 = com.ironsource.environment.ContextProvider.getInstance()     // Catch:{ all -> 0x0144 }
            android.app.Activity r6 = r6.getCurrentActiveActivity()     // Catch:{ all -> 0x0144 }
            if (r6 != 0) goto L_0x008c
            if (r8 != 0) goto L_0x0068
            goto L_0x0069
        L_0x0068:
            r0 = r3
        L_0x0069:
            org.json.JSONObject r6 = com.ironsource.mediationsdk.utils.IronSourceUtils.getMediationAdditionalData(r3, r0, r3)     // Catch:{ all -> 0x0144 }
            r8 = 81321(0x13da9, float:1.13955E-40)
            a((int) r8, (org.json.JSONObject) r6)     // Catch:{ all -> 0x0144 }
            java.lang.String r6 = "Rewarded video was initialized and loaded without Activity"
            com.ironsource.mediationsdk.logger.IronSourceLoggerManager r8 = r5.f     // Catch:{ all -> 0x0144 }
            com.ironsource.mediationsdk.logger.IronSourceLogger$IronSourceTag r0 = com.ironsource.mediationsdk.logger.IronSourceLogger.IronSourceTag.API     // Catch:{ all -> 0x0144 }
            r8.log(r0, r6, r2)     // Catch:{ all -> 0x0144 }
            com.ironsource.mediationsdk.Z r8 = com.ironsource.mediationsdk.Z.a()     // Catch:{ all -> 0x0144 }
            com.ironsource.mediationsdk.logger.IronSourceError r0 = new com.ironsource.mediationsdk.logger.IronSourceError     // Catch:{ all -> 0x0144 }
            r1 = 1060(0x424, float:1.485E-42)
            r0.<init>(r1, r6)     // Catch:{ all -> 0x0144 }
            r8.a((java.lang.String) r7, (com.ironsource.mediationsdk.logger.IronSourceError) r0)     // Catch:{ all -> 0x0144 }
            monitor-exit(r5)
            return
        L_0x008c:
            com.ironsource.mediationsdk.M r6 = com.ironsource.mediationsdk.M.a()     // Catch:{ all -> 0x0144 }
            com.ironsource.mediationsdk.M$a r6 = r6.b()     // Catch:{ all -> 0x0144 }
            com.ironsource.mediationsdk.M$a r1 = com.ironsource.mediationsdk.M.a.INIT_FAILED     // Catch:{ all -> 0x0144 }
            if (r6 != r1) goto L_0x00b2
            com.ironsource.mediationsdk.logger.IronSourceLoggerManager r6 = r5.f     // Catch:{ all -> 0x0144 }
            com.ironsource.mediationsdk.logger.IronSourceLogger$IronSourceTag r8 = com.ironsource.mediationsdk.logger.IronSourceLogger.IronSourceTag.API     // Catch:{ all -> 0x0144 }
            java.lang.String r0 = "init() had failed"
            r6.log(r8, r0, r2)     // Catch:{ all -> 0x0144 }
            com.ironsource.mediationsdk.Z r6 = com.ironsource.mediationsdk.Z.a()     // Catch:{ all -> 0x0144 }
            java.lang.String r8 = "init() had failed"
            java.lang.String r0 = "Rewarded Video"
            com.ironsource.mediationsdk.logger.IronSourceError r8 = com.ironsource.mediationsdk.utils.ErrorBuilder.buildInitFailedError(r8, r0)     // Catch:{ all -> 0x0144 }
            r6.a((java.lang.String) r7, (com.ironsource.mediationsdk.logger.IronSourceError) r8)     // Catch:{ all -> 0x0144 }
            monitor-exit(r5)
            return
        L_0x00b2:
            com.ironsource.mediationsdk.M$a r1 = com.ironsource.mediationsdk.M.a.INIT_IN_PROGRESS     // Catch:{ all -> 0x0144 }
            r4 = 83002(0x1443a, float:1.1631E-40)
            if (r6 != r1) goto L_0x00f6
            com.ironsource.mediationsdk.M r6 = com.ironsource.mediationsdk.M.a()     // Catch:{ all -> 0x0144 }
            boolean r6 = r6.c()     // Catch:{ all -> 0x0144 }
            if (r6 == 0) goto L_0x00dd
            com.ironsource.mediationsdk.logger.IronSourceLoggerManager r6 = r5.f     // Catch:{ all -> 0x0144 }
            com.ironsource.mediationsdk.logger.IronSourceLogger$IronSourceTag r8 = com.ironsource.mediationsdk.logger.IronSourceLogger.IronSourceTag.API     // Catch:{ all -> 0x0144 }
            java.lang.String r0 = "init() had failed"
            r6.log(r8, r0, r2)     // Catch:{ all -> 0x0144 }
            com.ironsource.mediationsdk.Z r6 = com.ironsource.mediationsdk.Z.a()     // Catch:{ all -> 0x0144 }
            java.lang.String r8 = "init() had failed"
            java.lang.String r0 = "Rewarded Video"
            com.ironsource.mediationsdk.logger.IronSourceError r8 = com.ironsource.mediationsdk.utils.ErrorBuilder.buildInitFailedError(r8, r0)     // Catch:{ all -> 0x0144 }
            r6.a((java.lang.String) r7, (com.ironsource.mediationsdk.logger.IronSourceError) r8)     // Catch:{ all -> 0x0144 }
            monitor-exit(r5)
            return
        L_0x00dd:
            java.util.concurrent.CopyOnWriteArraySet<java.lang.String> r6 = r5.ak     // Catch:{ all -> 0x0144 }
            monitor-enter(r6)     // Catch:{ all -> 0x0144 }
            java.util.concurrent.CopyOnWriteArraySet<java.lang.String> r0 = r5.ak     // Catch:{ all -> 0x00f3 }
            r0.add(r7)     // Catch:{ all -> 0x00f3 }
            monitor-exit(r6)     // Catch:{ all -> 0x00f3 }
            if (r8 == 0) goto L_0x00f1
            int r6 = r5.L     // Catch:{ all -> 0x0144 }
            org.json.JSONObject r6 = com.ironsource.mediationsdk.utils.IronSourceUtils.getMediationAdditionalData(r3, r3, r6)     // Catch:{ all -> 0x0144 }
            a((int) r4, (org.json.JSONObject) r6)     // Catch:{ all -> 0x0144 }
        L_0x00f1:
            monitor-exit(r5)
            return
        L_0x00f3:
            r8 = move-exception
            monitor-exit(r6)     // Catch:{ all -> 0x00f3 }
            throw r8     // Catch:{ all -> 0x0144 }
        L_0x00f6:
            java.util.concurrent.CopyOnWriteArraySet<java.lang.String> r6 = r5.ak     // Catch:{ all -> 0x0144 }
            monitor-enter(r6)     // Catch:{ all -> 0x0144 }
            com.ironsource.mediationsdk.u r1 = r5.am     // Catch:{ all -> 0x0141 }
            if (r1 != 0) goto L_0x0110
            java.util.concurrent.CopyOnWriteArraySet<java.lang.String> r0 = r5.ak     // Catch:{ all -> 0x0141 }
            r0.add(r7)     // Catch:{ all -> 0x0141 }
            if (r8 == 0) goto L_0x010d
            int r8 = r5.L     // Catch:{ all -> 0x0141 }
            org.json.JSONObject r8 = com.ironsource.mediationsdk.utils.IronSourceUtils.getMediationAdditionalData(r3, r3, r8)     // Catch:{ all -> 0x0141 }
            a((int) r4, (org.json.JSONObject) r8)     // Catch:{ all -> 0x0141 }
        L_0x010d:
            monitor-exit(r6)     // Catch:{ all -> 0x0141 }
            monitor-exit(r5)
            return
        L_0x0110:
            monitor-exit(r6)     // Catch:{ all -> 0x0141 }
            boolean r6 = r5.d()     // Catch:{ all -> 0x0144 }
            if (r6 != 0) goto L_0x0131
            com.ironsource.mediationsdk.logger.IronSourceLoggerManager r6 = r5.f     // Catch:{ all -> 0x0144 }
            com.ironsource.mediationsdk.logger.IronSourceLogger$IronSourceTag r8 = com.ironsource.mediationsdk.logger.IronSourceLogger.IronSourceTag.API     // Catch:{ all -> 0x0144 }
            java.lang.String r0 = "No rewarded video configurations found"
            r6.log(r8, r0, r2)     // Catch:{ all -> 0x0144 }
            com.ironsource.mediationsdk.Z r6 = com.ironsource.mediationsdk.Z.a()     // Catch:{ all -> 0x0144 }
            java.lang.String r8 = "the server response does not contain rewarded video data"
            java.lang.String r0 = "Rewarded Video"
            com.ironsource.mediationsdk.logger.IronSourceError r8 = com.ironsource.mediationsdk.utils.ErrorBuilder.buildInitFailedError(r8, r0)     // Catch:{ all -> 0x0144 }
            r6.a((java.lang.String) r7, (com.ironsource.mediationsdk.logger.IronSourceError) r8)     // Catch:{ all -> 0x0144 }
            monitor-exit(r5)
            return
        L_0x0131:
            if (r8 != 0) goto L_0x013a
            com.ironsource.mediationsdk.u r6 = r5.am     // Catch:{ all -> 0x0144 }
            r8 = 0
            r6.a((java.lang.String) r7, (java.lang.String) r8, (boolean) r0)     // Catch:{ all -> 0x0144 }
            goto L_0x0160
        L_0x013a:
            com.ironsource.mediationsdk.u r6 = r5.am     // Catch:{ all -> 0x0144 }
            r6.a((java.lang.String) r7, (java.lang.String) r8, (boolean) r3)     // Catch:{ all -> 0x0144 }
            monitor-exit(r5)
            return
        L_0x0141:
            r8 = move-exception
            monitor-exit(r6)     // Catch:{ all -> 0x0141 }
            throw r8     // Catch:{ all -> 0x0144 }
        L_0x0144:
            r6 = move-exception
            com.ironsource.mediationsdk.logger.IronSourceLoggerManager r8 = r5.f     // Catch:{ all -> 0x0162 }
            com.ironsource.mediationsdk.logger.IronSourceLogger$IronSourceTag r0 = com.ironsource.mediationsdk.logger.IronSourceLogger.IronSourceTag.API     // Catch:{ all -> 0x0162 }
            java.lang.String r1 = "loadISDemandOnlyRewardedVideo"
            r8.logException(r0, r1, r6)     // Catch:{ all -> 0x0162 }
            com.ironsource.mediationsdk.Z r8 = com.ironsource.mediationsdk.Z.a()     // Catch:{ all -> 0x0162 }
            com.ironsource.mediationsdk.logger.IronSourceError r0 = new com.ironsource.mediationsdk.logger.IronSourceError     // Catch:{ all -> 0x0162 }
            r1 = 510(0x1fe, float:7.15E-43)
            java.lang.String r6 = r6.getMessage()     // Catch:{ all -> 0x0162 }
            r0.<init>(r1, r6)     // Catch:{ all -> 0x0162 }
            r8.a((java.lang.String) r7, (com.ironsource.mediationsdk.logger.IronSourceError) r0)     // Catch:{ all -> 0x0162 }
        L_0x0160:
            monitor-exit(r5)
            return
        L_0x0162:
            r6 = move-exception
            monitor-exit(r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.mediationsdk.H.b(android.app.Activity, java.lang.String, java.lang.String):void");
    }

    public final void b(boolean z2) {
        this.y = Boolean.valueOf(z2);
        IronSourceLoggerManager logger = IronSourceLoggerManager.getLogger();
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.API;
        logger.log(ironSourceTag, "setConsent : " + z2, 1);
        C0151d.a().a(z2);
        if (this.R != null) {
            IronSourceLoggerManager ironSourceLoggerManager = this.f;
            IronSourceLogger.IronSourceTag ironSourceTag2 = IronSourceLogger.IronSourceTag.ADAPTER_API;
            ironSourceLoggerManager.log(ironSourceTag2, "Offerwall | setConsent(consent:" + z2 + ")", 1);
            this.R.setConsent(z2);
        }
        int i2 = 40;
        if (!z2) {
            i2 = 41;
        }
        this.an.a(z2);
        com.ironsource.mediationsdk.a.h.e().b(new c(i2, IronSourceUtils.getMediationAdditionalData(false)));
    }

    public final synchronized void c(Activity activity, String str, String str2) {
        if (str2 == null) {
            this.f.log(IronSourceLogger.IronSourceTag.API, "adm cannot be null", 3);
            A.a().a(str, new IronSourceError(IronSourceError.ERROR_CODE_GENERIC, "adm cannot be null"));
            return;
        }
        d(activity, str, str2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x002a, code lost:
        if (r8.z.a_() != false) goto L_0x002c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x002c, code lost:
        r3 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0041, code lost:
        if (r8.D.b() != false) goto L_0x002c;
     */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x004c A[Catch:{ all -> 0x008a }] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0066 A[Catch:{ all -> 0x008a }] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0069 A[Catch:{ all -> 0x008a }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean c() {
        /*
            r8 = this;
            java.lang.String r0 = "isRewardedVideoAvailable():"
            r1 = 1
            r2 = 0
            boolean r3 = r8.u     // Catch:{ all -> 0x008c }
            if (r3 == 0) goto L_0x0013
            com.ironsource.mediationsdk.logger.IronSourceLoggerManager r3 = r8.f     // Catch:{ all -> 0x008c }
            com.ironsource.mediationsdk.logger.IronSourceLogger$IronSourceTag r4 = com.ironsource.mediationsdk.logger.IronSourceLogger.IronSourceTag.API     // Catch:{ all -> 0x008c }
            java.lang.String r5 = "Rewarded Video was initialized in demand only mode. Use isISDemandOnlyRewardedVideoAvailable instead"
            r6 = 3
            r3.log(r4, r5, r6)     // Catch:{ all -> 0x008c }
            return r2
        L_0x0013:
            boolean r3 = r8.F     // Catch:{ all -> 0x008c }
            if (r3 != 0) goto L_0x0037
            boolean r3 = r8.ai     // Catch:{ all -> 0x008c }
            if (r3 == 0) goto L_0x001c
            goto L_0x0037
        L_0x001c:
            boolean r3 = r8.E     // Catch:{ all -> 0x008c }
            if (r3 == 0) goto L_0x0030
            com.ironsource.mediationsdk.z r3 = r8.z     // Catch:{ all -> 0x008c }
            if (r3 == 0) goto L_0x002e
            com.ironsource.mediationsdk.z r3 = r8.z     // Catch:{ all -> 0x008c }
            boolean r3 = r3.a_()     // Catch:{ all -> 0x008c }
            if (r3 == 0) goto L_0x002e
        L_0x002c:
            r3 = r1
            goto L_0x0044
        L_0x002e:
            r3 = r2
            goto L_0x0044
        L_0x0030:
            com.ironsource.mediationsdk.ab r3 = r8.b     // Catch:{ all -> 0x008c }
            boolean r3 = r3.c()     // Catch:{ all -> 0x008c }
            goto L_0x0044
        L_0x0037:
            com.ironsource.mediationsdk.adunit.c.h r3 = r8.D     // Catch:{ all -> 0x008c }
            if (r3 == 0) goto L_0x002e
            com.ironsource.mediationsdk.adunit.c.h r3 = r8.D     // Catch:{ all -> 0x008c }
            boolean r3 = r3.b()     // Catch:{ all -> 0x008c }
            if (r3 == 0) goto L_0x002e
            goto L_0x002c
        L_0x0044:
            org.json.JSONObject r4 = com.ironsource.mediationsdk.utils.IronSourceUtils.getMediationAdditionalData(r2)     // Catch:{ all -> 0x008a }
            boolean r5 = r8.E     // Catch:{ all -> 0x008a }
            if (r5 == 0) goto L_0x0062
            java.lang.Object[][] r5 = new java.lang.Object[r1][]     // Catch:{ all -> 0x008a }
            r6 = 2
            java.lang.Object[] r6 = new java.lang.Object[r6]     // Catch:{ all -> 0x008a }
            java.lang.String r7 = "programmatic"
            r6[r2] = r7     // Catch:{ all -> 0x008a }
            int r7 = r8.L     // Catch:{ all -> 0x008a }
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)     // Catch:{ all -> 0x008a }
            r6[r1] = r7     // Catch:{ all -> 0x008a }
            r5[r2] = r6     // Catch:{ all -> 0x008a }
            a((org.json.JSONObject) r4, (java.lang.Object[][]) r5)     // Catch:{ all -> 0x008a }
        L_0x0062:
            com.ironsource.mediationsdk.a.c r5 = new com.ironsource.mediationsdk.a.c     // Catch:{ all -> 0x008a }
            if (r3 == 0) goto L_0x0069
            r6 = 1101(0x44d, float:1.543E-42)
            goto L_0x006b
        L_0x0069:
            r6 = 1102(0x44e, float:1.544E-42)
        L_0x006b:
            r5.<init>(r6, r4)     // Catch:{ all -> 0x008a }
            com.ironsource.mediationsdk.a.h r4 = com.ironsource.mediationsdk.a.h.e()     // Catch:{ all -> 0x008a }
            r4.b((com.ironsource.mediationsdk.a.c) r5)     // Catch:{ all -> 0x008a }
            com.ironsource.mediationsdk.logger.IronSourceLoggerManager r4 = r8.f     // Catch:{ all -> 0x008a }
            com.ironsource.mediationsdk.logger.IronSourceLogger$IronSourceTag r5 = com.ironsource.mediationsdk.logger.IronSourceLogger.IronSourceTag.API     // Catch:{ all -> 0x008a }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x008a }
            r6.<init>(r0)     // Catch:{ all -> 0x008a }
            r6.append(r3)     // Catch:{ all -> 0x008a }
            java.lang.String r6 = r6.toString()     // Catch:{ all -> 0x008a }
            r4.log(r5, r6, r1)     // Catch:{ all -> 0x008a }
            r2 = r3
            goto L_0x00ab
        L_0x008a:
            r4 = move-exception
            goto L_0x008f
        L_0x008c:
            r3 = move-exception
            r4 = r3
            r3 = r2
        L_0x008f:
            com.ironsource.mediationsdk.logger.IronSourceLoggerManager r5 = r8.f
            com.ironsource.mediationsdk.logger.IronSourceLogger$IronSourceTag r6 = com.ironsource.mediationsdk.logger.IronSourceLogger.IronSourceTag.API
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>(r0)
            r7.append(r3)
            java.lang.String r0 = r7.toString()
            r5.log(r6, r0, r1)
            com.ironsource.mediationsdk.logger.IronSourceLoggerManager r0 = r8.f
            com.ironsource.mediationsdk.logger.IronSourceLogger$IronSourceTag r1 = com.ironsource.mediationsdk.logger.IronSourceLogger.IronSourceTag.API
            java.lang.String r3 = "isRewardedVideoAvailable()"
            r0.logException(r1, r3, r4)
        L_0x00ab:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.mediationsdk.H.c():boolean");
    }

    public final boolean c(String str) {
        try {
            this.f.log(IronSourceLogger.IronSourceTag.API, this.a + ":setDynamicUserId(dynamicUserId:" + str + ")", 1);
            com.ironsource.d.a aVar = new com.ironsource.d.a();
            if (!a(str, 1, 128)) {
                aVar.a(ErrorBuilder.buildInvalidKeyValueError(IronSourceConstants.EVENTS_DYNAMIC_USER_ID, IronSourceConstants.SUPERSONIC_CONFIG_NAME, "dynamicUserId is invalid, should be between 1-128 chars in length."));
            }
            if (aVar.a()) {
                this.m = str;
                com.ironsource.mediationsdk.a.h.e().b(new c(52, IronSourceUtils.getJsonForUserId(true)));
                return true;
            }
            IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.API, aVar.b().toString(), 2);
            return false;
        } catch (Exception e2) {
            IronSourceLoggerManager ironSourceLoggerManager = this.f;
            IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.API;
            ironSourceLoggerManager.logException(ironSourceTag, this.a + ":setDynamicUserId(dynamicUserId:" + str + ")", e2);
            return false;
        }
    }

    /*  JADX ERROR: IndexOutOfBoundsException in pass: RegionMakerVisitor
        java.lang.IndexOutOfBoundsException: Index: 0, Size: 0
        	at java.util.ArrayList.rangeCheck(ArrayList.java:659)
        	at java.util.ArrayList.get(ArrayList.java:435)
        	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:101)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:611)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:698)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:693)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:698)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:698)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:698)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:598)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
        */
    public final synchronized void d(android.app.Activity r7, java.lang.String r8, java.lang.String r9) {
        /*
            r6 = this;
            monitor-enter(r6)
            com.ironsource.mediationsdk.logger.IronSourceLoggerManager r0 = r6.f     // Catch:{ all -> 0x015c }
            com.ironsource.mediationsdk.logger.IronSourceLogger$IronSourceTag r1 = com.ironsource.mediationsdk.logger.IronSourceLogger.IronSourceTag.API     // Catch:{ all -> 0x015c }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x015c }
            java.lang.String r3 = "loadISDemandOnlyInterstitial() instanceId="
            r2.<init>(r3)     // Catch:{ all -> 0x015c }
            r2.append(r8)     // Catch:{ all -> 0x015c }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x015c }
            r3 = 1
            r0.log(r1, r2, r3)     // Catch:{ all -> 0x015c }
            r0 = 510(0x1fe, float:7.15E-43)
            boolean r1 = r6.x     // Catch:{ all -> 0x0140 }
            r2 = 3
            if (r1 != 0) goto L_0x0035
            java.lang.String r7 = "initISDemandOnly() must be called before loadISDemandOnlyInterstitial()"
            com.ironsource.mediationsdk.logger.IronSourceLoggerManager r9 = r6.f     // Catch:{ all -> 0x0140 }
            com.ironsource.mediationsdk.logger.IronSourceLogger$IronSourceTag r1 = com.ironsource.mediationsdk.logger.IronSourceLogger.IronSourceTag.API     // Catch:{ all -> 0x0140 }
            r9.log(r1, r7, r2)     // Catch:{ all -> 0x0140 }
            com.ironsource.mediationsdk.A r9 = com.ironsource.mediationsdk.A.a()     // Catch:{ all -> 0x0140 }
            com.ironsource.mediationsdk.logger.IronSourceError r1 = new com.ironsource.mediationsdk.logger.IronSourceError     // Catch:{ all -> 0x0140 }
            r1.<init>(r0, r7)     // Catch:{ all -> 0x0140 }
            r9.a((java.lang.String) r8, (com.ironsource.mediationsdk.logger.IronSourceError) r1)     // Catch:{ all -> 0x0140 }
            monitor-exit(r6)
            return
        L_0x0035:
            boolean r1 = r6.v     // Catch:{ all -> 0x0140 }
            if (r1 != 0) goto L_0x0050
            java.lang.String r7 = "Interstitial was initialized in mediation mode. Use loadInterstitial instead"
            com.ironsource.mediationsdk.logger.IronSourceLoggerManager r9 = r6.f     // Catch:{ all -> 0x0140 }
            com.ironsource.mediationsdk.logger.IronSourceLogger$IronSourceTag r1 = com.ironsource.mediationsdk.logger.IronSourceLogger.IronSourceTag.API     // Catch:{ all -> 0x0140 }
            r9.log(r1, r7, r2)     // Catch:{ all -> 0x0140 }
            com.ironsource.mediationsdk.A r9 = com.ironsource.mediationsdk.A.a()     // Catch:{ all -> 0x0140 }
            com.ironsource.mediationsdk.logger.IronSourceError r1 = new com.ironsource.mediationsdk.logger.IronSourceError     // Catch:{ all -> 0x0140 }
            r1.<init>(r0, r7)     // Catch:{ all -> 0x0140 }
            r9.a((java.lang.String) r8, (com.ironsource.mediationsdk.logger.IronSourceError) r1)     // Catch:{ all -> 0x0140 }
            monitor-exit(r6)
            return
        L_0x0050:
            r1 = 0
            if (r7 == 0) goto L_0x005b
            com.ironsource.environment.ContextProvider r4 = com.ironsource.environment.ContextProvider.getInstance()     // Catch:{ all -> 0x0140 }
            r4.updateActivity(r7)     // Catch:{ all -> 0x0140 }
            goto L_0x008c
        L_0x005b:
            com.ironsource.environment.ContextProvider r7 = com.ironsource.environment.ContextProvider.getInstance()     // Catch:{ all -> 0x0140 }
            android.app.Activity r7 = r7.getCurrentActiveActivity()     // Catch:{ all -> 0x0140 }
            if (r7 != 0) goto L_0x008c
            if (r9 != 0) goto L_0x0068
            goto L_0x0069
        L_0x0068:
            r1 = r3
        L_0x0069:
            org.json.JSONObject r7 = com.ironsource.mediationsdk.utils.IronSourceUtils.getMediationAdditionalData(r3, r1, r3)     // Catch:{ all -> 0x0140 }
            r9 = 82321(0x14191, float:1.15356E-40)
            b(r9, r7)     // Catch:{ all -> 0x0140 }
            java.lang.String r7 = "Interstitial was initialized and loaded without Activity"
            com.ironsource.mediationsdk.logger.IronSourceLoggerManager r9 = r6.f     // Catch:{ all -> 0x0140 }
            com.ironsource.mediationsdk.logger.IronSourceLogger$IronSourceTag r1 = com.ironsource.mediationsdk.logger.IronSourceLogger.IronSourceTag.API     // Catch:{ all -> 0x0140 }
            r9.log(r1, r7, r2)     // Catch:{ all -> 0x0140 }
            com.ironsource.mediationsdk.A r9 = com.ironsource.mediationsdk.A.a()     // Catch:{ all -> 0x0140 }
            com.ironsource.mediationsdk.logger.IronSourceError r1 = new com.ironsource.mediationsdk.logger.IronSourceError     // Catch:{ all -> 0x0140 }
            r2 = 1061(0x425, float:1.487E-42)
            r1.<init>(r2, r7)     // Catch:{ all -> 0x0140 }
            r9.a((java.lang.String) r8, (com.ironsource.mediationsdk.logger.IronSourceError) r1)     // Catch:{ all -> 0x0140 }
            monitor-exit(r6)
            return
        L_0x008c:
            com.ironsource.mediationsdk.M r7 = com.ironsource.mediationsdk.M.a()     // Catch:{ all -> 0x0140 }
            com.ironsource.mediationsdk.M$a r7 = r7.b()     // Catch:{ all -> 0x0140 }
            com.ironsource.mediationsdk.M$a r4 = com.ironsource.mediationsdk.M.a.INIT_FAILED     // Catch:{ all -> 0x0140 }
            if (r7 != r4) goto L_0x00b2
            com.ironsource.mediationsdk.logger.IronSourceLoggerManager r7 = r6.f     // Catch:{ all -> 0x0140 }
            com.ironsource.mediationsdk.logger.IronSourceLogger$IronSourceTag r9 = com.ironsource.mediationsdk.logger.IronSourceLogger.IronSourceTag.API     // Catch:{ all -> 0x0140 }
            java.lang.String r1 = "init() had failed"
            r7.log(r9, r1, r2)     // Catch:{ all -> 0x0140 }
            com.ironsource.mediationsdk.A r7 = com.ironsource.mediationsdk.A.a()     // Catch:{ all -> 0x0140 }
            java.lang.String r9 = "init() had failed"
            java.lang.String r1 = "Interstitial"
            com.ironsource.mediationsdk.logger.IronSourceError r9 = com.ironsource.mediationsdk.utils.ErrorBuilder.buildInitFailedError(r9, r1)     // Catch:{ all -> 0x0140 }
            r7.a((java.lang.String) r8, (com.ironsource.mediationsdk.logger.IronSourceError) r9)     // Catch:{ all -> 0x0140 }
            monitor-exit(r6)
            return
        L_0x00b2:
            com.ironsource.mediationsdk.M$a r4 = com.ironsource.mediationsdk.M.a.INIT_IN_PROGRESS     // Catch:{ all -> 0x0140 }
            r5 = 83003(0x1443b, float:1.16312E-40)
            if (r7 != r4) goto L_0x00f4
            com.ironsource.mediationsdk.M r7 = com.ironsource.mediationsdk.M.a()     // Catch:{ all -> 0x0140 }
            boolean r7 = r7.c()     // Catch:{ all -> 0x0140 }
            if (r7 == 0) goto L_0x00dd
            com.ironsource.mediationsdk.logger.IronSourceLoggerManager r7 = r6.f     // Catch:{ all -> 0x0140 }
            com.ironsource.mediationsdk.logger.IronSourceLogger$IronSourceTag r9 = com.ironsource.mediationsdk.logger.IronSourceLogger.IronSourceTag.API     // Catch:{ all -> 0x0140 }
            java.lang.String r1 = "init() had failed"
            r7.log(r9, r1, r2)     // Catch:{ all -> 0x0140 }
            com.ironsource.mediationsdk.A r7 = com.ironsource.mediationsdk.A.a()     // Catch:{ all -> 0x0140 }
            java.lang.String r9 = "init() had failed"
            java.lang.String r1 = "Interstitial"
            com.ironsource.mediationsdk.logger.IronSourceError r9 = com.ironsource.mediationsdk.utils.ErrorBuilder.buildInitFailedError(r9, r1)     // Catch:{ all -> 0x0140 }
            r7.a((java.lang.String) r8, (com.ironsource.mediationsdk.logger.IronSourceError) r9)     // Catch:{ all -> 0x0140 }
            monitor-exit(r6)
            return
        L_0x00dd:
            java.util.concurrent.CopyOnWriteArraySet<java.lang.String> r7 = r6.aj     // Catch:{ all -> 0x0140 }
            monitor-enter(r7)     // Catch:{ all -> 0x0140 }
            java.util.concurrent.CopyOnWriteArraySet<java.lang.String> r1 = r6.aj     // Catch:{ all -> 0x00f1 }
            r1.add(r8)     // Catch:{ all -> 0x00f1 }
            monitor-exit(r7)     // Catch:{ all -> 0x00f1 }
            if (r9 == 0) goto L_0x00ef
            org.json.JSONObject r7 = com.ironsource.mediationsdk.utils.IronSourceUtils.getMediationAdditionalData(r3, r3, r3)     // Catch:{ all -> 0x0140 }
            b(r5, r7)     // Catch:{ all -> 0x0140 }
        L_0x00ef:
            monitor-exit(r6)
            return
        L_0x00f1:
            r9 = move-exception
            monitor-exit(r7)     // Catch:{ all -> 0x00f1 }
            throw r9     // Catch:{ all -> 0x0140 }
        L_0x00f4:
            java.util.concurrent.CopyOnWriteArraySet<java.lang.String> r7 = r6.aj     // Catch:{ all -> 0x0140 }
            monitor-enter(r7)     // Catch:{ all -> 0x0140 }
            com.ironsource.mediationsdk.s r4 = r6.M     // Catch:{ all -> 0x013d }
            if (r4 != 0) goto L_0x010c
            java.util.concurrent.CopyOnWriteArraySet<java.lang.String> r1 = r6.aj     // Catch:{ all -> 0x013d }
            r1.add(r8)     // Catch:{ all -> 0x013d }
            if (r9 == 0) goto L_0x0109
            org.json.JSONObject r9 = com.ironsource.mediationsdk.utils.IronSourceUtils.getMediationAdditionalData(r3, r3, r3)     // Catch:{ all -> 0x013d }
            b(r5, r9)     // Catch:{ all -> 0x013d }
        L_0x0109:
            monitor-exit(r7)     // Catch:{ all -> 0x013d }
            monitor-exit(r6)
            return
        L_0x010c:
            monitor-exit(r7)     // Catch:{ all -> 0x013d }
            boolean r7 = r6.h()     // Catch:{ all -> 0x0140 }
            if (r7 != 0) goto L_0x012d
            com.ironsource.mediationsdk.logger.IronSourceLoggerManager r7 = r6.f     // Catch:{ all -> 0x0140 }
            com.ironsource.mediationsdk.logger.IronSourceLogger$IronSourceTag r9 = com.ironsource.mediationsdk.logger.IronSourceLogger.IronSourceTag.API     // Catch:{ all -> 0x0140 }
            java.lang.String r1 = "No interstitial configurations found"
            r7.log(r9, r1, r2)     // Catch:{ all -> 0x0140 }
            com.ironsource.mediationsdk.A r7 = com.ironsource.mediationsdk.A.a()     // Catch:{ all -> 0x0140 }
            java.lang.String r9 = "the server response does not contain interstitial data"
            java.lang.String r1 = "Interstitial"
            com.ironsource.mediationsdk.logger.IronSourceError r9 = com.ironsource.mediationsdk.utils.ErrorBuilder.buildInitFailedError(r9, r1)     // Catch:{ all -> 0x0140 }
            r7.a((java.lang.String) r8, (com.ironsource.mediationsdk.logger.IronSourceError) r9)     // Catch:{ all -> 0x0140 }
            monitor-exit(r6)
            return
        L_0x012d:
            if (r9 != 0) goto L_0x0136
            com.ironsource.mediationsdk.s r7 = r6.M     // Catch:{ all -> 0x0140 }
            r9 = 0
            r7.a((java.lang.String) r8, (java.lang.String) r9, (boolean) r1)     // Catch:{ all -> 0x0140 }
            goto L_0x015a
        L_0x0136:
            com.ironsource.mediationsdk.s r7 = r6.M     // Catch:{ all -> 0x0140 }
            r7.a((java.lang.String) r8, (java.lang.String) r9, (boolean) r3)     // Catch:{ all -> 0x0140 }
            monitor-exit(r6)
            return
        L_0x013d:
            r9 = move-exception
            monitor-exit(r7)     // Catch:{ all -> 0x013d }
            throw r9     // Catch:{ all -> 0x0140 }
        L_0x0140:
            r7 = move-exception
            com.ironsource.mediationsdk.logger.IronSourceLoggerManager r9 = r6.f     // Catch:{ all -> 0x015c }
            com.ironsource.mediationsdk.logger.IronSourceLogger$IronSourceTag r1 = com.ironsource.mediationsdk.logger.IronSourceLogger.IronSourceTag.API     // Catch:{ all -> 0x015c }
            java.lang.String r2 = "loadDemandOnlyInterstitial"
            r9.logException(r1, r2, r7)     // Catch:{ all -> 0x015c }
            com.ironsource.mediationsdk.A r9 = com.ironsource.mediationsdk.A.a()     // Catch:{ all -> 0x015c }
            com.ironsource.mediationsdk.logger.IronSourceError r1 = new com.ironsource.mediationsdk.logger.IronSourceError     // Catch:{ all -> 0x015c }
            java.lang.String r7 = r7.getMessage()     // Catch:{ all -> 0x015c }
            r1.<init>(r0, r7)     // Catch:{ all -> 0x015c }
            r9.a((java.lang.String) r8, (com.ironsource.mediationsdk.logger.IronSourceError) r1)     // Catch:{ all -> 0x015c }
        L_0x015a:
            monitor-exit(r6)
            return
        L_0x015c:
            r7 = move-exception
            monitor-exit(r6)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.mediationsdk.H.d(android.app.Activity, java.lang.String, java.lang.String):void");
    }

    public final void d(String str) {
        try {
            this.f.log(IronSourceLogger.IronSourceTag.INTERNAL, this.a + ":setMediationType(mediationType:" + str + ")", 1);
            if (!a(str, 1, 64) || !v(str)) {
                this.f.log(IronSourceLogger.IronSourceTag.INTERNAL, " mediationType value is invalid - should be alphanumeric and 1-64 chars in length", 1);
            } else {
                this.o = str;
            }
        } catch (Exception e2) {
            IronSourceLoggerManager ironSourceLoggerManager = this.f;
            IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.API;
            ironSourceLoggerManager.logException(ironSourceTag, this.a + ":setMediationType(mediationType:" + str + ")", e2);
        }
    }

    /* access modifiers changed from: package-private */
    public boolean d() {
        l lVar = this.i;
        return (lVar == null || lVar.c == null || this.i.c.a == null) ? false : true;
    }

    /* access modifiers changed from: package-private */
    public InterstitialPlacement e() {
        com.ironsource.mediationsdk.model.h hVar = this.i.c.b;
        if (hVar != null) {
            return hVar.a();
        }
        return null;
    }

    public final void e(String str) {
        String str2 = "showRewardedVideo(" + str + ")";
        this.f.log(IronSourceLogger.IronSourceTag.API, str2, 1);
        try {
            if (this.u) {
                this.f.log(IronSourceLogger.IronSourceTag.API, "Rewarded Video was initialized in demand only mode. Use showISDemandOnlyRewardedVideo instead", 3);
                this.g.onRewardedVideoAdShowFailed(ErrorBuilder.buildInitFailedError("Rewarded Video was initialized in demand only mode. Use showISDemandOnlyRewardedVideo instead", IronSourceConstants.REWARDED_VIDEO_AD_UNIT));
            } else if (!d()) {
                this.g.onRewardedVideoAdShowFailed(ErrorBuilder.buildInitFailedError("showRewardedVideo can't be called before the Rewarded Video ad unit initialization completed successfully", IronSourceConstants.REWARDED_VIDEO_AD_UNIT));
            } else if (this.E) {
                q(str);
            } else {
                Placement r2 = r(str);
                if (r2 != null) {
                    this.b.a(r2);
                    this.b.a(r2.getPlacementName());
                }
            }
        } catch (Exception e2) {
            this.f.logException(IronSourceLogger.IronSourceTag.API, str2, e2);
            this.g.onRewardedVideoAdShowFailed(new IronSourceError(IronSourceError.ERROR_CODE_GENERIC, e2.getMessage()));
        }
    }

    public final void f() {
        synchronized (this.ad) {
            if (this.ad.booleanValue()) {
                this.ad = Boolean.FALSE;
                C0157j.a().a(this.ae, new IronSourceError(603, "init had failed"));
                this.ae = null;
                this.af = null;
            }
        }
        if (this.J) {
            this.J = false;
            C0163p.a().a(IronSource.AD_UNIT.INTERSTITIAL, ErrorBuilder.buildInitFailedError("init() had failed", IronSourceConstants.INTERSTITIAL_AD_UNIT));
        }
        if (this.G) {
            this.G = false;
            C0163p.a().a(IronSource.AD_UNIT.REWARDED_VIDEO, ErrorBuilder.buildInitFailedError("init() had failed", IronSourceConstants.REWARDED_VIDEO_AD_UNIT));
        }
        synchronized (this.aj) {
            Iterator<String> it = this.aj.iterator();
            while (it.hasNext()) {
                A.a().a(it.next(), ErrorBuilder.buildInitFailedError("init() had failed", IronSourceConstants.INTERSTITIAL_AD_UNIT));
            }
            this.aj.clear();
        }
        synchronized (this.ak) {
            Iterator<String> it2 = this.ak.iterator();
            while (it2.hasNext()) {
                Z.a().a(it2.next(), ErrorBuilder.buildInitFailedError("init() had failed", IronSourceConstants.REWARDED_VIDEO_AD_UNIT));
            }
            this.ak.clear();
        }
    }

    public final synchronized void f(String str) {
        IronSourceLoggerManager ironSourceLoggerManager = this.f;
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.API;
        ironSourceLoggerManager.log(ironSourceTag, "showISDemandOnlyRewardedVideo() instanceId=" + str, 1);
        try {
            if (!this.u) {
                this.f.log(IronSourceLogger.IronSourceTag.API, "Rewarded video was initialized in mediation mode. Use showRewardedVideo instead", 3);
                Z.a().b(str, new IronSourceError(IronSourceError.ERROR_CODE_INIT_FAILED, "Rewarded video was initialized in mediation mode. Use showRewardedVideo instead"));
                return;
            } else if (this.am == null) {
                this.f.log(IronSourceLogger.IronSourceTag.API, "Rewarded video was not initiated", 3);
                Z.a().b(str, new IronSourceError(IronSourceError.ERROR_CODE_INIT_FAILED, "Rewarded video was not initiated"));
                return;
            } else {
                C0168u uVar = this.am;
                if (!uVar.a.containsKey(str)) {
                    C0168u.a(1500, str);
                    Z.a().b(str, ErrorBuilder.buildNonExistentInstanceError(IronSourceConstants.REWARDED_VIDEO_AD_UNIT));
                } else {
                    C0169v vVar = uVar.a.get(str);
                    uVar.a((int) IronSourceConstants.RV_INSTANCE_SHOW, vVar);
                    vVar.a();
                    return;
                }
            }
        } catch (Exception e2) {
            this.f.logException(IronSourceLogger.IronSourceTag.API, "showISDemandOnlyRewardedVideo", e2);
            Z.a().b(str, new IronSourceError(IronSourceError.ERROR_CODE_GENERIC, e2.getMessage()));
        }
        return;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0025, code lost:
        if (r9.C.b() != false) goto L_0x0027;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0042, code lost:
        if (r9.c.e() != false) goto L_0x0027;
     */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x004f A[Catch:{ all -> 0x0073 }] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0052 A[Catch:{ all -> 0x0073 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean g() {
        /*
            r9 = this;
            java.lang.String r0 = "isInterstitialReady():"
            r1 = 1
            r2 = 0
            boolean r3 = r9.v     // Catch:{ all -> 0x0078 }
            if (r3 == 0) goto L_0x0013
            com.ironsource.mediationsdk.logger.IronSourceLoggerManager r3 = r9.f     // Catch:{ all -> 0x0078 }
            com.ironsource.mediationsdk.logger.IronSourceLogger$IronSourceTag r4 = com.ironsource.mediationsdk.logger.IronSourceLogger.IronSourceTag.API     // Catch:{ all -> 0x0078 }
            java.lang.String r5 = "Interstitial was initialized in demand only mode. Use isISDemandOnlyInterstitialReady instead"
            r6 = 3
            r3.log(r4, r5, r6)     // Catch:{ all -> 0x0078 }
            return r2
        L_0x0013:
            boolean r3 = r9.H     // Catch:{ all -> 0x0078 }
            if (r3 == 0) goto L_0x0038
            boolean r3 = r9.I     // Catch:{ all -> 0x0078 }
            if (r3 == 0) goto L_0x002b
            com.ironsource.mediationsdk.adunit.c.g r3 = r9.C     // Catch:{ all -> 0x0078 }
            if (r3 == 0) goto L_0x0029
            com.ironsource.mediationsdk.adunit.c.g r3 = r9.C     // Catch:{ all -> 0x0078 }
            boolean r3 = r3.b()     // Catch:{ all -> 0x0078 }
            if (r3 == 0) goto L_0x0029
        L_0x0027:
            r3 = r1
            goto L_0x0045
        L_0x0029:
            r3 = r2
            goto L_0x0045
        L_0x002b:
            com.ironsource.mediationsdk.S r3 = r9.A     // Catch:{ all -> 0x0078 }
            if (r3 == 0) goto L_0x0029
            com.ironsource.mediationsdk.S r3 = r9.A     // Catch:{ all -> 0x0078 }
            boolean r3 = r3.e()     // Catch:{ all -> 0x0078 }
            if (r3 == 0) goto L_0x0029
            goto L_0x0027
        L_0x0038:
            com.ironsource.mediationsdk.E r3 = r9.c     // Catch:{ all -> 0x0078 }
            if (r3 == 0) goto L_0x0029
            com.ironsource.mediationsdk.E r3 = r9.c     // Catch:{ all -> 0x0078 }
            boolean r3 = r3.e()     // Catch:{ all -> 0x0078 }
            if (r3 == 0) goto L_0x0029
            goto L_0x0027
        L_0x0045:
            boolean r4 = r9.H     // Catch:{ all -> 0x0073 }
            org.json.JSONObject r4 = com.ironsource.mediationsdk.utils.IronSourceUtils.getMediationAdditionalData(r2, r4, r1)     // Catch:{ all -> 0x0073 }
            com.ironsource.mediationsdk.a.c r5 = new com.ironsource.mediationsdk.a.c     // Catch:{ all -> 0x0073 }
            if (r3 == 0) goto L_0x0052
            r6 = 2101(0x835, float:2.944E-42)
            goto L_0x0054
        L_0x0052:
            r6 = 2102(0x836, float:2.946E-42)
        L_0x0054:
            r5.<init>(r6, r4)     // Catch:{ all -> 0x0073 }
            com.ironsource.mediationsdk.a.d r4 = com.ironsource.mediationsdk.a.d.e()     // Catch:{ all -> 0x0073 }
            r4.b((com.ironsource.mediationsdk.a.c) r5)     // Catch:{ all -> 0x0073 }
            com.ironsource.mediationsdk.logger.IronSourceLoggerManager r4 = r9.f     // Catch:{ all -> 0x0073 }
            com.ironsource.mediationsdk.logger.IronSourceLogger$IronSourceTag r5 = com.ironsource.mediationsdk.logger.IronSourceLogger.IronSourceTag.API     // Catch:{ all -> 0x0073 }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x0073 }
            r6.<init>(r0)     // Catch:{ all -> 0x0073 }
            r6.append(r3)     // Catch:{ all -> 0x0073 }
            java.lang.String r6 = r6.toString()     // Catch:{ all -> 0x0073 }
            r4.log(r5, r6, r1)     // Catch:{ all -> 0x0073 }
            r2 = r3
            goto L_0x0096
        L_0x0073:
            r4 = move-exception
            r8 = r4
            r4 = r3
            r3 = r8
            goto L_0x007a
        L_0x0078:
            r3 = move-exception
            r4 = r2
        L_0x007a:
            com.ironsource.mediationsdk.logger.IronSourceLoggerManager r5 = r9.f
            com.ironsource.mediationsdk.logger.IronSourceLogger$IronSourceTag r6 = com.ironsource.mediationsdk.logger.IronSourceLogger.IronSourceTag.API
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>(r0)
            r7.append(r4)
            java.lang.String r0 = r7.toString()
            r5.log(r6, r0, r1)
            com.ironsource.mediationsdk.logger.IronSourceLoggerManager r0 = r9.f
            com.ironsource.mediationsdk.logger.IronSourceLogger$IronSourceTag r1 = com.ironsource.mediationsdk.logger.IronSourceLogger.IronSourceTag.API
            java.lang.String r4 = "isInterstitialReady()"
            r0.logException(r1, r4, r3)
        L_0x0096:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.mediationsdk.H.g():boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0039, code lost:
        return false;
     */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0036 A[DONT_GENERATE] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized boolean g(java.lang.String r5) {
        /*
            r4 = this;
            monitor-enter(r4)
            com.ironsource.mediationsdk.u r0 = r4.am     // Catch:{ all -> 0x003a }
            r1 = 0
            if (r0 == 0) goto L_0x0038
            com.ironsource.mediationsdk.u r0 = r4.am     // Catch:{ all -> 0x003a }
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.ironsource.mediationsdk.v> r2 = r0.a     // Catch:{ all -> 0x003a }
            boolean r2 = r2.containsKey(r5)     // Catch:{ all -> 0x003a }
            r3 = 1
            if (r2 != 0) goto L_0x0018
            r0 = 1500(0x5dc, float:2.102E-42)
            com.ironsource.mediationsdk.C0168u.a((int) r0, (java.lang.String) r5)     // Catch:{ all -> 0x003a }
        L_0x0016:
            r5 = r1
            goto L_0x0034
        L_0x0018:
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.ironsource.mediationsdk.v> r0 = r0.a     // Catch:{ all -> 0x003a }
            java.lang.Object r5 = r0.get(r5)     // Catch:{ all -> 0x003a }
            com.ironsource.mediationsdk.v r5 = (com.ironsource.mediationsdk.C0169v) r5     // Catch:{ all -> 0x003a }
            boolean r0 = r5.b()     // Catch:{ all -> 0x003a }
            r2 = 0
            if (r0 == 0) goto L_0x002e
            r0 = 1210(0x4ba, float:1.696E-42)
            com.ironsource.mediationsdk.C0168u.a((int) r0, (com.ironsource.mediationsdk.C0169v) r5, (java.lang.Object[][]) r2)     // Catch:{ all -> 0x003a }
            r5 = r3
            goto L_0x0034
        L_0x002e:
            r0 = 1211(0x4bb, float:1.697E-42)
            com.ironsource.mediationsdk.C0168u.a((int) r0, (com.ironsource.mediationsdk.C0169v) r5, (java.lang.Object[][]) r2)     // Catch:{ all -> 0x003a }
            goto L_0x0016
        L_0x0034:
            if (r5 == 0) goto L_0x0038
            monitor-exit(r4)
            return r3
        L_0x0038:
            monitor-exit(r4)
            return r1
        L_0x003a:
            r5 = move-exception
            monitor-exit(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.mediationsdk.H.g(java.lang.String):boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x006b, code lost:
        if (android.text.TextUtils.isEmpty(r7) == false) goto L_0x0063;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void h(java.lang.String r7) {
        /*
            r6 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "showInterstitial("
            r0.<init>(r1)
            r0.append(r7)
            java.lang.String r1 = ")"
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            com.ironsource.mediationsdk.logger.IronSourceLoggerManager r1 = r6.f
            com.ironsource.mediationsdk.logger.IronSourceLogger$IronSourceTag r2 = com.ironsource.mediationsdk.logger.IronSourceLogger.IronSourceTag.API
            r3 = 1
            r1.log(r2, r0, r3)
            r1 = 510(0x1fe, float:7.15E-43)
            boolean r2 = r6.v     // Catch:{ Exception -> 0x0090 }
            if (r2 == 0) goto L_0x0036
            java.lang.String r7 = "Interstitial was initialized in demand only mode. Use showISDemandOnlyInterstitial instead"
            com.ironsource.mediationsdk.logger.IronSourceLoggerManager r2 = r6.f     // Catch:{ Exception -> 0x0090 }
            com.ironsource.mediationsdk.logger.IronSourceLogger$IronSourceTag r3 = com.ironsource.mediationsdk.logger.IronSourceLogger.IronSourceTag.API     // Catch:{ Exception -> 0x0090 }
            r4 = 3
            r2.log(r3, r7, r4)     // Catch:{ Exception -> 0x0090 }
            com.ironsource.mediationsdk.sdk.i r2 = r6.g     // Catch:{ Exception -> 0x0090 }
            com.ironsource.mediationsdk.logger.IronSourceError r3 = new com.ironsource.mediationsdk.logger.IronSourceError     // Catch:{ Exception -> 0x0090 }
            r3.<init>(r1, r7)     // Catch:{ Exception -> 0x0090 }
            r2.onInterstitialAdShowFailed(r3)     // Catch:{ Exception -> 0x0090 }
            return
        L_0x0036:
            boolean r2 = r6.h()     // Catch:{ Exception -> 0x0090 }
            if (r2 != 0) goto L_0x004a
            com.ironsource.mediationsdk.sdk.i r7 = r6.g     // Catch:{ Exception -> 0x0090 }
            java.lang.String r2 = "showInterstitial can't be called before the Interstitial ad unit initialization completed successfully"
            java.lang.String r3 = "Interstitial"
            com.ironsource.mediationsdk.logger.IronSourceError r2 = com.ironsource.mediationsdk.utils.ErrorBuilder.buildInitFailedError(r2, r3)     // Catch:{ Exception -> 0x0090 }
            r7.onInterstitialAdShowFailed(r2)     // Catch:{ Exception -> 0x0090 }
            return
        L_0x004a:
            boolean r2 = r6.H     // Catch:{ Exception -> 0x0090 }
            if (r2 == 0) goto L_0x0052
            r6.t(r7)     // Catch:{ Exception -> 0x0090 }
            return
        L_0x0052:
            com.ironsource.mediationsdk.model.InterstitialPlacement r2 = r6.u(r7)     // Catch:{ Exception -> 0x0090 }
            r3 = 0
            org.json.JSONObject r3 = com.ironsource.mediationsdk.utils.IronSourceUtils.getMediationAdditionalData(r3)     // Catch:{ Exception -> 0x0090 }
            java.lang.String r4 = "placement"
            if (r2 == 0) goto L_0x0067
            java.lang.String r7 = r2.getPlacementName()     // Catch:{ JSONException -> 0x006e }
        L_0x0063:
            r3.put(r4, r7)     // Catch:{ JSONException -> 0x006e }
            goto L_0x0072
        L_0x0067:
            boolean r5 = android.text.TextUtils.isEmpty(r7)     // Catch:{ JSONException -> 0x006e }
            if (r5 != 0) goto L_0x0072
            goto L_0x0063
        L_0x006e:
            r7 = move-exception
            r7.printStackTrace()     // Catch:{ Exception -> 0x0090 }
        L_0x0072:
            com.ironsource.mediationsdk.a.c r7 = new com.ironsource.mediationsdk.a.c     // Catch:{ Exception -> 0x0090 }
            r4 = 2100(0x834, float:2.943E-42)
            r7.<init>(r4, r3)     // Catch:{ Exception -> 0x0090 }
            com.ironsource.mediationsdk.a.d r3 = com.ironsource.mediationsdk.a.d.e()     // Catch:{ Exception -> 0x0090 }
            r3.b((com.ironsource.mediationsdk.a.c) r7)     // Catch:{ Exception -> 0x0090 }
            if (r2 == 0) goto L_0x008f
            com.ironsource.mediationsdk.E r7 = r6.c     // Catch:{ Exception -> 0x0090 }
            r7.a((com.ironsource.mediationsdk.model.InterstitialPlacement) r2)     // Catch:{ Exception -> 0x0090 }
            com.ironsource.mediationsdk.E r7 = r6.c     // Catch:{ Exception -> 0x0090 }
            r2.getPlacementName()     // Catch:{ Exception -> 0x0090 }
            r7.d()     // Catch:{ Exception -> 0x0090 }
        L_0x008f:
            return
        L_0x0090:
            r7 = move-exception
            com.ironsource.mediationsdk.logger.IronSourceLoggerManager r2 = r6.f
            com.ironsource.mediationsdk.logger.IronSourceLogger$IronSourceTag r3 = com.ironsource.mediationsdk.logger.IronSourceLogger.IronSourceTag.API
            r2.logException(r3, r0, r7)
            com.ironsource.mediationsdk.sdk.i r0 = r6.g
            com.ironsource.mediationsdk.logger.IronSourceError r2 = new com.ironsource.mediationsdk.logger.IronSourceError
            java.lang.String r7 = r7.getMessage()
            r2.<init>(r1, r7)
            r0.onInterstitialAdShowFailed(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.mediationsdk.H.h(java.lang.String):void");
    }

    /* access modifiers changed from: package-private */
    public boolean h() {
        l lVar = this.i;
        return (lVar == null || lVar.c == null || this.i.c.b == null) ? false : true;
    }

    /* access modifiers changed from: package-private */
    public boolean i() {
        l lVar = this.i;
        return (lVar == null || lVar.c == null || this.i.c.c == null) ? false : true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0039, code lost:
        return false;
     */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0036 A[DONT_GENERATE] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized boolean i(java.lang.String r5) {
        /*
            r4 = this;
            monitor-enter(r4)
            com.ironsource.mediationsdk.s r0 = r4.M     // Catch:{ all -> 0x003a }
            r1 = 0
            if (r0 == 0) goto L_0x0038
            com.ironsource.mediationsdk.s r0 = r4.M     // Catch:{ all -> 0x003a }
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.ironsource.mediationsdk.t> r2 = r0.a     // Catch:{ all -> 0x003a }
            boolean r2 = r2.containsKey(r5)     // Catch:{ all -> 0x003a }
            r3 = 1
            if (r2 != 0) goto L_0x0018
            r0 = 2500(0x9c4, float:3.503E-42)
            com.ironsource.mediationsdk.C0166s.a((int) r0, (java.lang.String) r5)     // Catch:{ all -> 0x003a }
        L_0x0016:
            r5 = r1
            goto L_0x0034
        L_0x0018:
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.ironsource.mediationsdk.t> r0 = r0.a     // Catch:{ all -> 0x003a }
            java.lang.Object r5 = r0.get(r5)     // Catch:{ all -> 0x003a }
            com.ironsource.mediationsdk.t r5 = (com.ironsource.mediationsdk.C0167t) r5     // Catch:{ all -> 0x003a }
            boolean r0 = r5.b()     // Catch:{ all -> 0x003a }
            r2 = 0
            if (r0 == 0) goto L_0x002e
            r0 = 2211(0x8a3, float:3.098E-42)
            com.ironsource.mediationsdk.C0166s.a((int) r0, (com.ironsource.mediationsdk.C0167t) r5, (java.lang.Object[][]) r2)     // Catch:{ all -> 0x003a }
            r5 = r3
            goto L_0x0034
        L_0x002e:
            r0 = 2212(0x8a4, float:3.1E-42)
            com.ironsource.mediationsdk.C0166s.a((int) r0, (com.ironsource.mediationsdk.C0167t) r5, (java.lang.Object[][]) r2)     // Catch:{ all -> 0x003a }
            goto L_0x0016
        L_0x0034:
            if (r5 == 0) goto L_0x0038
            monitor-exit(r4)
            return r3
        L_0x0038:
            monitor-exit(r4)
            return r1
        L_0x003a:
            r5 = move-exception
            monitor-exit(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.mediationsdk.H.i(java.lang.String):boolean");
    }

    public final void j(String str) {
        String str2 = "showOfferwall(" + str + ")";
        this.f.log(IronSourceLogger.IronSourceTag.API, str2, 1);
        try {
            if (!i()) {
                this.g.onOfferwallShowFailed(ErrorBuilder.buildInitFailedError("showOfferwall can't be called before the Offerwall ad unit initialization completed successfully", IronSourceConstants.OFFERWALL_AD_UNIT));
                return;
            }
            j a2 = this.i.c.c.a(str);
            if (a2 == null) {
                this.f.log(IronSourceLogger.IronSourceTag.API, "Placement is not valid, please make sure you are using the right placements, using the default placement.", 3);
                a2 = this.i.c.c.a();
                if (a2 == null) {
                    this.f.log(IronSourceLogger.IronSourceTag.API, "Default placement was not found, please make sure you are using the right placements.", 3);
                    return;
                }
            }
            this.d.a(a2.b);
        } catch (Exception e2) {
            this.f.logException(IronSourceLogger.IronSourceTag.API, str2, e2);
            this.g.onOfferwallShowFailed(ErrorBuilder.buildInitFailedError("showOfferwall can't be called before the Offerwall ad unit initialization completed successfully", IronSourceConstants.OFFERWALL_AD_UNIT));
        }
    }

    public final boolean j() {
        try {
            if (this.d != null) {
                return this.d.a();
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    public final InterstitialPlacement k(String str) {
        try {
            InterstitialPlacement s2 = s(str);
            if (s2 == null) {
                try {
                    this.f.log(IronSourceLogger.IronSourceTag.API, "Placement is not valid, please make sure you are using the right placements, using the default placement.", 2);
                    s2 = e();
                } catch (Exception unused) {
                    return s2;
                }
            }
            IronSourceLoggerManager ironSourceLoggerManager = this.f;
            IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.API;
            ironSourceLoggerManager.log(ironSourceTag, "getPlacementInfo(placement: " + str + "):" + s2, 1);
            return s2;
        } catch (Exception unused2) {
            return null;
        }
    }

    public final String k() {
        return this.j;
    }

    public final Placement l(String str) {
        try {
            Placement p2 = p(str);
            if (p2 == null) {
                try {
                    this.f.log(IronSourceLogger.IronSourceTag.API, "Placement is not valid, please make sure you are using the right placements, using the default placement.", 2);
                    p2 = b();
                } catch (Exception unused) {
                    return p2;
                }
            }
            IronSourceLoggerManager ironSourceLoggerManager = this.f;
            IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.API;
            ironSourceLoggerManager.log(ironSourceTag, "getPlacementInfo(placement: " + str + "):" + p2, 1);
            return p2;
        } catch (Exception unused2) {
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x00f1  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String l() {
        /*
            r8 = this;
            r0 = 0
            r1 = 83005(0x1443d, float:1.16315E-40)
            a((int) r1, (org.json.JSONObject) r0)
            com.ironsource.mediationsdk.logger.IronLog r1 = com.ironsource.mediationsdk.logger.IronLog.API
            java.lang.String r2 = ""
            r1.info(r2)
            com.ironsource.mediationsdk.utils.l r1 = r8.i
            if (r1 != 0) goto L_0x001b
            com.ironsource.mediationsdk.logger.IronLog r1 = com.ironsource.mediationsdk.logger.IronLog.API
            java.lang.String r2 = "bidding data cannot be retrieved, SDK not initialized"
            r1.error(r2)
            goto L_0x00ee
        L_0x001b:
            com.ironsource.mediationsdk.model.n r1 = r1.b
            java.lang.String r2 = "IronSource"
            com.ironsource.mediationsdk.model.NetworkSettings r1 = r1.a((java.lang.String) r2)
            if (r1 == 0) goto L_0x00ee
            org.json.JSONObject r2 = new org.json.JSONObject
            r2.<init>()
            com.ironsource.mediationsdk.d r3 = com.ironsource.mediationsdk.C0151d.a()
            org.json.JSONObject r4 = r1.getApplicationSettings()
            r5 = 0
            r6 = 1
            com.ironsource.mediationsdk.AbstractAdapter r1 = r3.a(r1, r4, r6, r5)
            if (r1 == 0) goto L_0x003e
            org.json.JSONObject r2 = r1.getPlayerBiddingData()     // Catch:{ Exception -> 0x00cd }
        L_0x003e:
            com.ironsource.mediationsdk.utils.l r1 = r8.i     // Catch:{ Exception -> 0x00cd }
            com.ironsource.mediationsdk.model.g r1 = r1.c     // Catch:{ Exception -> 0x00cd }
            com.ironsource.sdk.f.a r1 = r1.e     // Catch:{ Exception -> 0x00cd }
            com.ironsource.mediationsdk.utils.p r1 = r1.c()     // Catch:{ Exception -> 0x00cd }
            boolean r3 = r1.d     // Catch:{ Exception -> 0x00cd }
            if (r3 == 0) goto L_0x005d
            com.ironsource.environment.f.b r2 = new com.ironsource.environment.f.b     // Catch:{ Exception -> 0x00cd }
            r2.<init>()     // Catch:{ Exception -> 0x00cd }
            org.json.JSONObject r2 = r2.a()     // Catch:{ Exception -> 0x00cd }
            com.ironsource.mediationsdk.f r3 = com.ironsource.mediationsdk.C0153f.a()     // Catch:{ Exception -> 0x00cd }
            r3.a((org.json.JSONObject) r2, (boolean) r6)     // Catch:{ Exception -> 0x00cd }
            goto L_0x0069
        L_0x005d:
            com.ironsource.mediationsdk.f r3 = com.ironsource.mediationsdk.C0153f.a()     // Catch:{ Exception -> 0x00cd }
            org.json.JSONObject r4 = r1.c     // Catch:{ Exception -> 0x00cd }
            java.util.ArrayList<java.lang.String> r5 = r1.a     // Catch:{ Exception -> 0x00cd }
            org.json.JSONObject r2 = r3.a((org.json.JSONObject) r2, (org.json.JSONObject) r4, (java.util.List<java.lang.String>) r5)     // Catch:{ Exception -> 0x00cd }
        L_0x0069:
            com.ironsource.mediationsdk.logger.IronLog r3 = com.ironsource.mediationsdk.logger.IronLog.INTERNAL     // Catch:{ Exception -> 0x00cd }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00cd }
            java.lang.String r5 = "bidding data: "
            r4.<init>(r5)     // Catch:{ Exception -> 0x00cd }
            r4.append(r2)     // Catch:{ Exception -> 0x00cd }
            java.lang.String r4 = r4.toString()     // Catch:{ Exception -> 0x00cd }
            r3.verbose(r4)     // Catch:{ Exception -> 0x00cd }
            if (r2 == 0) goto L_0x00ee
            com.ironsource.mediationsdk.logger.IronLog r3 = com.ironsource.mediationsdk.logger.IronLog.INTERNAL     // Catch:{ Exception -> 0x00cd }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00cd }
            java.lang.String r5 = "raw biddingData length: "
            r4.<init>(r5)     // Catch:{ Exception -> 0x00cd }
            java.lang.String r5 = r2.toString()     // Catch:{ Exception -> 0x00cd }
            int r5 = r5.length()     // Catch:{ Exception -> 0x00cd }
            r4.append(r5)     // Catch:{ Exception -> 0x00cd }
            java.lang.String r4 = r4.toString()     // Catch:{ Exception -> 0x00cd }
            r3.verbose(r4)     // Catch:{ Exception -> 0x00cd }
            boolean r1 = r1.e     // Catch:{ Exception -> 0x00cd }
            if (r1 == 0) goto L_0x00a6
            java.lang.String r1 = r2.toString()     // Catch:{ Exception -> 0x00cd }
            java.lang.String r1 = com.ironsource.mediationsdk.utils.IronSourceAES.compressAndEncrypt(r1)     // Catch:{ Exception -> 0x00cd }
            goto L_0x00ae
        L_0x00a6:
            java.lang.String r1 = r2.toString()     // Catch:{ Exception -> 0x00cd }
            java.lang.String r1 = com.ironsource.mediationsdk.utils.IronSourceAES.encrypt(r1)     // Catch:{ Exception -> 0x00cd }
        L_0x00ae:
            if (r1 == 0) goto L_0x00ef
            com.ironsource.mediationsdk.logger.IronLog r2 = com.ironsource.mediationsdk.logger.IronLog.INTERNAL     // Catch:{ Exception -> 0x00c8 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00c8 }
            java.lang.String r4 = "biddingData length: "
            r3.<init>(r4)     // Catch:{ Exception -> 0x00c8 }
            int r4 = r1.length()     // Catch:{ Exception -> 0x00c8 }
            r3.append(r4)     // Catch:{ Exception -> 0x00c8 }
            java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x00c8 }
            r2.verbose(r3)     // Catch:{ Exception -> 0x00c8 }
            goto L_0x00ef
        L_0x00c8:
            r2 = move-exception
            r7 = r2
            r2 = r1
            r1 = r7
            goto L_0x00cf
        L_0x00cd:
            r1 = move-exception
            r2 = r0
        L_0x00cf:
            r3 = 83007(0x1443f, float:1.16318E-40)
            a((int) r3, (org.json.JSONObject) r0)
            com.ironsource.mediationsdk.logger.IronLog r3 = com.ironsource.mediationsdk.logger.IronLog.API
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            java.lang.String r5 = "got error during creating the token: "
            r4.<init>(r5)
            java.lang.String r1 = r1.getMessage()
            r4.append(r1)
            java.lang.String r1 = r4.toString()
            r3.error(r1)
            r1 = r2
            goto L_0x00ef
        L_0x00ee:
            r1 = r0
        L_0x00ef:
            if (r1 != 0) goto L_0x00f7
            r2 = 83006(0x1443e, float:1.16316E-40)
            a((int) r2, (org.json.JSONObject) r0)
        L_0x00f7:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.mediationsdk.H.l():java.lang.String");
    }

    /* access modifiers changed from: package-private */
    public final boolean m() {
        return this.u || this.v;
    }

    /* access modifiers changed from: package-private */
    public final boolean m(String str) {
        boolean z2 = false;
        if (this.v) {
            return false;
        }
        if (w(str) != k.a.d) {
            z2 = true;
        }
        if (z2) {
            JSONObject mediationAdditionalData = IronSourceUtils.getMediationAdditionalData(this.v, this.H, 1);
            try {
                mediationAdditionalData.put("placement", str);
                if (this.H) {
                    mediationAdditionalData.put(IronSourceConstants.EVENTS_PROGRAMMATIC, 1);
                }
            } catch (Exception unused) {
            }
            d.e().b(new c(IronSourceConstants.IS_CHECK_CAPPED_TRUE, mediationAdditionalData));
        }
        return z2;
    }

    /* access modifiers changed from: package-private */
    public final boolean n(String str) {
        if (!C()) {
            return false;
        }
        f fVar = null;
        try {
            fVar = this.i.c.d.a(str);
            if (fVar == null && (fVar = this.i.c.d.a()) == null) {
                this.f.log(IronSourceLogger.IronSourceTag.API, "Banner default placement was not found", 3);
                return false;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        if (fVar == null) {
            return false;
        }
        return k.b(ContextProvider.getInstance().getApplicationContext(), fVar.getPlacementName());
    }

    /* access modifiers changed from: package-private */
    public int o(String str) {
        l lVar = this.i;
        if (lVar == null || lVar.c == null || this.i.c.a == null) {
            return k.a.d;
        }
        Placement placement = null;
        try {
            placement = p(str);
            if (placement == null && (placement = b()) == null) {
                this.f.log(IronSourceLogger.IronSourceTag.API, "Default placement was not found", 3);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return placement == null ? k.a.d : k.b(ContextProvider.getInstance().getApplicationContext(), placement);
    }
}
