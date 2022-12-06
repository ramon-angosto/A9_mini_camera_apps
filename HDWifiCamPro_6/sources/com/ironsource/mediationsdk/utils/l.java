package com.ironsource.mediationsdk.utils;

import android.content.Context;
import android.text.TextUtils;
import androidx.work.WorkRequest;
import com.ironsource.mediationsdk.C;
import com.ironsource.mediationsdk.logger.IronSourceLogger;
import com.ironsource.mediationsdk.logger.IronSourceLoggerManager;
import com.ironsource.mediationsdk.model.NetworkSettings;
import com.ironsource.mediationsdk.model.g;
import com.ironsource.mediationsdk.model.k;
import com.ironsource.mediationsdk.model.m;
import com.ironsource.mediationsdk.model.n;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.playercommon.exoplayer2.DefaultLoadControl;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import com.vungle.warren.model.ReportDBAdapter;
import ms.bd.o.Pgl.c;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class l {
    private final String A = "configurations";
    private final String B = IronSourceConstants.EVENTS_GENERIC_PARAMS;
    private final String C = "adUnits";
    private final String D = "providerLoadName";
    private final String E = MimeTypes.BASE_TYPE_APPLICATION;
    private final String F = "rewardedVideo";
    private final String G = IronSourceConstants.AD_UNIT_IS_MEDIATION_STATE;
    private final String H = "offerwall";
    private final String I = "banner";
    private final String J = "integration";
    private final String K = "loggers";
    private final String L = "segment";
    private final String M = "events";
    private final String N = "crashReporter";
    private final String O = "token";
    private final String P = "external";
    private final String Q = "mediationTypes";
    private final String R = "providerDefaultInstance";
    private final String S = "settings";
    private final String T = "maxNumOfAdaptersToLoadOnStart";
    private final String U = "advancedLoading";
    private final String V = "adapterTimeOutInSeconds";
    private final String W = "atim";
    private final String X = "bannerInterval";
    private final String Y = "loadRVInterval";
    private final String Z = "expiredDurationInMinutes";
    public m a;
    private final String aA = "maxImpressions";
    private final String aB = "numOfSeconds";
    private final String aC = "unit";
    private final String aD = "virtualItemName";
    private final String aE = "virtualItemCount";
    private final String aF = "backFill";
    private final String aG = "premium";
    private final String aH = "uuidEnabled";
    private final String aI = "abt";
    private final String aJ = "delayLoadFailure";
    private final String aK = "keysToInclude";
    private final String aL = "reporterURL";
    private final String aM = "reporterKeyword";
    private final String aN = "includeANR";
    private final String aO = "timeout";
    private final String aP = "setIgnoreDebugger";
    private final String aQ = "adSourceName";
    private final String aR = "spId";
    private final String aS = "mpis";
    private final String aT = "auction";
    private final String aU = "auctionData";
    private final String aV = "auctioneerURL";
    private final String aW = IronSourceConstants.EVENTS_PROGRAMMATIC;
    private final String aX = "objectPerWaterfall";
    private final String aY = "minTimeBeforeFirstAuction";
    private final String aZ = "timeToWaitBeforeAuction";
    private final String aa = "server";
    private final String ab = "publisher";
    private final String ac = "console";
    private final String ad = "sendUltraEvents";
    private final String ae = "sendEventsToggle";
    private final String af = "eventsCompression";
    private final String ag = "serverEventsURL";
    private final String ah = "serverEventsType";
    private final String ai = "backupThreshold";
    private final String aj = "maxNumberOfEvents";
    private final String ak = "maxEventsPerBatch";
    private final String al = "optOut";
    private final String am = "optIn";
    private final String an = "triggerEvents";
    private final String ao = "nonConnectivityEvents";
    private final String ap = "pixel";
    private final String aq = "pixelEventsUrl";
    private final String ar = "pixelEventsEnabled";
    private final String as = "placements";
    private final String at = ReportDBAdapter.ReportColumns.COLUMN_PLACEMENT_ID;
    private final String au = "placementName";
    private final String av = "delivery";
    private final String aw = "isDefault";
    private final String ax = "capping";
    private final String ay = "pacing";
    private final String az = "enabled";
    public n b;
    private final String ba = "timeToWaitBeforeLoad";
    private final String bb = "auctionRetryInterval";
    private final String bc = "isAuctionOnShowStart";
    private final String bd = "isLoadWhileShow";
    private final String be = IronSourceConstants.AUCTION_TRIALS;
    private final String bf = "auctionTimeout";
    private final String bg = "auctionSavedHistory";
    private final String bh = "disableLoadWhileShowSupportFor";
    private final String bi = "timeToDeleteOldWaterfallAfterAuction";
    private final String bj = "compressAuctionRequest";
    private final String bk = "compressAuctionResponse";
    private final String bl = "encryptionVersion";
    private final String bm = "shouldSendBannerBURLFromImpression";
    private final String bn = "optInKeys";
    private final String bo = "tokenGenericParams";
    private final String bp = "oneToken";
    private final String bq = "compressToken";
    private final String br = "isExternalArmEventsEnabled";
    private final String bs = "externalArmEventsUrl";
    private final String bt = "compressExternalToken";
    private String bu;
    private String bv;
    private Context bw;
    public g c;
    public JSONObject d;
    public int e = a.a;
    private final String f = CampaignEx.JSON_NATIVE_VIDEO_ERROR;
    private final int g = 3;
    private final int h = 2;
    private final int i = 60;
    private final int j = 10000;
    private final int k = DefaultLoadControl.DEFAULT_BUFFER_FOR_PLAYBACK_AFTER_REBUFFER_MS;
    private final int l = c.COLLECT_MODE_FINANCE;
    private final int m = 3;
    private final int n = 3;
    private final int o = 3;
    private final int p = 2;
    private final int q = 15;
    private final long r = WorkRequest.MIN_BACKOFF_MILLIS;
    private final int s = 0;
    private final boolean t = false;
    private final int u = 30000;
    private final int v = -1;
    private final int w = DefaultLoadControl.DEFAULT_BUFFER_FOR_PLAYBACK_AFTER_REBUFFER_MS;
    private final int x = 1;
    private final String y = "providerOrder";
    private final String z = "providerSettings";

    public enum a {
        ;
        
        public static final int a = 1;
        public static final int b = 2;
        public static final int c = 3;

        static {
            d = new int[]{1, 2, 3};
        }
    }

    public l(Context context, String str, String str2, String str3) {
        this.bw = context;
        try {
            this.d = TextUtils.isEmpty(str3) ? new JSONObject() : new JSONObject(str3);
            h();
            i();
            g();
            this.bu = TextUtils.isEmpty(str) ? "" : str;
            this.bv = TextUtils.isEmpty(str2) ? "" : str2;
        } catch (JSONException e2) {
            e2.printStackTrace();
            e();
        }
    }

    public l(l lVar) {
        try {
            this.bw = lVar.bw;
            this.d = new JSONObject(lVar.d.toString());
            this.bu = lVar.bu;
            this.bv = lVar.bv;
            this.a = lVar.a;
            this.b = lVar.b;
            this.c = lVar.c;
            this.e = lVar.e;
        } catch (Exception unused) {
            e();
        }
    }

    private static int a(JSONObject jSONObject, JSONObject jSONObject2, String str, int i2) {
        int optInt = jSONObject.has(str) ? jSONObject.optInt(str, 0) : jSONObject2.has(str) ? jSONObject2.optInt(str, 0) : 0;
        return optInt == 0 ? i2 : optInt;
    }

    private static k a(JSONObject jSONObject) {
        com.ironsource.mediationsdk.model.l lVar = null;
        if (jSONObject == null) {
            return null;
        }
        k.a aVar = new k.a();
        boolean z2 = true;
        aVar.a = jSONObject.optBoolean("delivery", true);
        JSONObject optJSONObject = jSONObject.optJSONObject("capping");
        if (optJSONObject != null) {
            String optString = optJSONObject.optString("unit");
            if (!TextUtils.isEmpty(optString)) {
                if (com.ironsource.mediationsdk.model.l.PER_DAY.toString().equals(optString)) {
                    lVar = com.ironsource.mediationsdk.model.l.PER_DAY;
                } else if (com.ironsource.mediationsdk.model.l.PER_HOUR.toString().equals(optString)) {
                    lVar = com.ironsource.mediationsdk.model.l.PER_HOUR;
                }
            }
            int optInt = optJSONObject.optInt("maxImpressions", 0);
            aVar.a(optJSONObject.optBoolean("enabled", false) && optInt > 0, lVar, optInt);
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("pacing");
        if (optJSONObject2 != null) {
            int optInt2 = optJSONObject2.optInt("numOfSeconds", 0);
            if (!optJSONObject2.optBoolean("enabled", false) || optInt2 <= 0) {
                z2 = false;
            }
            aVar.a(z2, optInt2);
        }
        return aVar.a();
    }

    private static int[] a(JSONObject jSONObject, String str) {
        JSONArray optJSONArray = jSONObject.optJSONArray(str);
        if (optJSONArray == null) {
            return null;
        }
        int[] iArr = new int[optJSONArray.length()];
        for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
            iArr[i2] = optJSONArray.optInt(i2);
        }
        return iArr;
    }

    private static JSONObject b(JSONObject jSONObject, String str) {
        if (jSONObject != null) {
            return jSONObject.optJSONObject(str);
        }
        return null;
    }

    private void e() {
        this.d = new JSONObject();
        this.bu = "";
        this.bv = "";
        this.a = new m();
        this.b = n.a();
        this.c = new g();
    }

    private boolean f() {
        JSONArray names = b(this.d, "providerOrder").names();
        if (names == null) {
            return true;
        }
        JSONObject b2 = b(b(this.d, "configurations"), "adUnits");
        for (int i2 = 0; i2 < names.length(); i2++) {
            JSONArray optJSONArray = b(b2, names.optString(i2)).optJSONArray("placements");
            if (optJSONArray == null || optJSONArray.length() == 0) {
                return false;
            }
        }
        return true;
    }

    private void g() {
        try {
            JSONObject b2 = b(this.d, "providerOrder");
            JSONArray optJSONArray = b2.optJSONArray("rewardedVideo");
            JSONArray optJSONArray2 = b2.optJSONArray(IronSourceConstants.AD_UNIT_IS_MEDIATION_STATE);
            JSONArray optJSONArray3 = b2.optJSONArray("banner");
            this.a = new m();
            if (!(optJSONArray == null || this.c == null || this.c.a == null)) {
                String str = this.c.a.f;
                String str2 = this.c.a.g;
                for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                    String optString = optJSONArray.optString(i2);
                    if (optString.equals(str)) {
                        this.a.b = str;
                    } else {
                        if (optString.equals(str2)) {
                            this.a.c = str2;
                        }
                        m mVar = this.a;
                        if (!TextUtils.isEmpty(optString)) {
                            mVar.a.add(optString);
                        }
                        NetworkSettings a2 = n.a().a(optString);
                        if (a2 != null) {
                            a2.setRewardedVideoPriority(i2);
                        }
                    }
                }
            }
            if (!(optJSONArray2 == null || this.c == null || this.c.b == null)) {
                String str3 = this.c.b.g;
                String str4 = this.c.b.h;
                for (int i3 = 0; i3 < optJSONArray2.length(); i3++) {
                    String optString2 = optJSONArray2.optString(i3);
                    if (optString2.equals(str3)) {
                        this.a.f = str3;
                    } else {
                        if (optString2.equals(str4)) {
                            this.a.g = str4;
                        }
                        m mVar2 = this.a;
                        if (!TextUtils.isEmpty(optString2)) {
                            mVar2.d.add(optString2);
                        }
                        NetworkSettings a3 = n.a().a(optString2);
                        if (a3 != null) {
                            a3.setInterstitialPriority(i3);
                        }
                    }
                }
            }
            if (optJSONArray3 != null) {
                for (int i4 = 0; i4 < optJSONArray3.length(); i4++) {
                    String optString3 = optJSONArray3.optString(i4);
                    m mVar3 = this.a;
                    if (!TextUtils.isEmpty(optString3)) {
                        mVar3.e.add(optString3);
                    }
                    NetworkSettings a4 = n.a().a(optString3);
                    if (a4 != null) {
                        a4.setBannerPriority(i4);
                    }
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x00e5 A[Catch:{ Exception -> 0x015f }] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0135 A[Catch:{ Exception -> 0x015f }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void h() {
        /*
            r18 = this;
            r1 = r18
            java.lang.String r0 = "Mediation"
            com.ironsource.mediationsdk.model.n r2 = com.ironsource.mediationsdk.model.n.a()     // Catch:{ Exception -> 0x015f }
            r1.b = r2     // Catch:{ Exception -> 0x015f }
            org.json.JSONObject r2 = r1.d     // Catch:{ Exception -> 0x015f }
            java.lang.String r3 = "providerSettings"
            org.json.JSONObject r2 = b(r2, r3)     // Catch:{ Exception -> 0x015f }
            java.util.Iterator r3 = r2.keys()     // Catch:{ Exception -> 0x015f }
        L_0x0016:
            boolean r4 = r3.hasNext()     // Catch:{ Exception -> 0x015f }
            if (r4 == 0) goto L_0x0159
            java.lang.Object r4 = r3.next()     // Catch:{ Exception -> 0x015f }
            r6 = r4
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ Exception -> 0x015f }
            org.json.JSONObject r4 = r2.optJSONObject(r6)     // Catch:{ Exception -> 0x015f }
            if (r4 == 0) goto L_0x014f
            java.lang.String r5 = "mpis"
            r7 = 0
            boolean r13 = r4.optBoolean(r5, r7)     // Catch:{ Exception -> 0x015f }
            java.lang.String r5 = "spId"
            java.lang.String r8 = "0"
            java.lang.String r14 = r4.optString(r5, r8)     // Catch:{ Exception -> 0x015f }
            java.lang.String r5 = "adSourceName"
            r8 = 0
            java.lang.String r15 = r4.optString(r5, r8)     // Catch:{ Exception -> 0x015f }
            java.lang.String r5 = "providerLoadName"
            java.lang.String r8 = r4.optString(r5, r6)     // Catch:{ Exception -> 0x015f }
            java.lang.String r5 = "providerDefaultInstance"
            java.lang.String r9 = r4.optString(r5, r8)     // Catch:{ Exception -> 0x015f }
            java.lang.String r5 = "adUnits"
            org.json.JSONObject r5 = b(r4, r5)     // Catch:{ Exception -> 0x015f }
            java.lang.String r10 = "application"
            org.json.JSONObject r4 = b(r4, r10)     // Catch:{ Exception -> 0x015f }
            java.lang.String r10 = "rewardedVideo"
            org.json.JSONObject r10 = b(r5, r10)     // Catch:{ Exception -> 0x015f }
            java.lang.String r11 = "interstitial"
            org.json.JSONObject r11 = b(r5, r11)     // Catch:{ Exception -> 0x015f }
            java.lang.String r12 = "banner"
            org.json.JSONObject r5 = b(r5, r12)     // Catch:{ Exception -> 0x015f }
            org.json.JSONObject r10 = com.ironsource.mediationsdk.utils.IronSourceUtils.mergeJsons(r10, r4)     // Catch:{ Exception -> 0x015f }
            org.json.JSONObject r11 = com.ironsource.mediationsdk.utils.IronSourceUtils.mergeJsons(r11, r4)     // Catch:{ Exception -> 0x015f }
            org.json.JSONObject r12 = com.ironsource.mediationsdk.utils.IronSourceUtils.mergeJsons(r5, r4)     // Catch:{ Exception -> 0x015f }
            com.ironsource.mediationsdk.model.n r5 = r1.b     // Catch:{ Exception -> 0x015f }
            boolean r5 = r5.b(r6)     // Catch:{ Exception -> 0x015f }
            if (r5 == 0) goto L_0x00af
            com.ironsource.mediationsdk.model.n r4 = r1.b     // Catch:{ Exception -> 0x015f }
            com.ironsource.mediationsdk.model.NetworkSettings r4 = r4.a((java.lang.String) r6)     // Catch:{ Exception -> 0x015f }
            org.json.JSONObject r5 = r4.getRewardedVideoSettings()     // Catch:{ Exception -> 0x015f }
            org.json.JSONObject r6 = r4.getInterstitialSettings()     // Catch:{ Exception -> 0x015f }
            org.json.JSONObject r7 = r4.getBannerSettings()     // Catch:{ Exception -> 0x015f }
            org.json.JSONObject r5 = com.ironsource.mediationsdk.utils.IronSourceUtils.mergeJsons(r5, r10)     // Catch:{ Exception -> 0x015f }
            r4.setRewardedVideoSettings(r5)     // Catch:{ Exception -> 0x015f }
            org.json.JSONObject r5 = com.ironsource.mediationsdk.utils.IronSourceUtils.mergeJsons(r6, r11)     // Catch:{ Exception -> 0x015f }
            r4.setInterstitialSettings(r5)     // Catch:{ Exception -> 0x015f }
            org.json.JSONObject r5 = com.ironsource.mediationsdk.utils.IronSourceUtils.mergeJsons(r7, r12)     // Catch:{ Exception -> 0x015f }
            r4.setBannerSettings(r5)     // Catch:{ Exception -> 0x015f }
            r4.setIsMultipleInstances(r13)     // Catch:{ Exception -> 0x015f }
            r4.setSubProviderId(r14)     // Catch:{ Exception -> 0x015f }
            r4.setAdSourceNameForEvents(r15)     // Catch:{ Exception -> 0x015f }
            goto L_0x0016
        L_0x00af:
            java.util.Locale r5 = java.util.Locale.ENGLISH     // Catch:{ Exception -> 0x015f }
            java.lang.String r5 = r8.toLowerCase(r5)     // Catch:{ Exception -> 0x015f }
            com.ironsource.mediationsdk.model.n r7 = r1.b     // Catch:{ Exception -> 0x015f }
            boolean r7 = r7.b(r0)     // Catch:{ Exception -> 0x015f }
            if (r7 == 0) goto L_0x00df
            java.lang.String r7 = "SupersonicAds"
            r17 = r2
            java.util.Locale r2 = java.util.Locale.ENGLISH     // Catch:{ Exception -> 0x015f }
            java.lang.String r2 = r7.toLowerCase(r2)     // Catch:{ Exception -> 0x015f }
            boolean r2 = r2.equals(r5)     // Catch:{ Exception -> 0x015f }
            if (r2 != 0) goto L_0x00db
            java.lang.String r2 = "IronSource"
            java.util.Locale r7 = java.util.Locale.ENGLISH     // Catch:{ Exception -> 0x015f }
            java.lang.String r2 = r2.toLowerCase(r7)     // Catch:{ Exception -> 0x015f }
            boolean r2 = r2.equals(r5)     // Catch:{ Exception -> 0x015f }
            if (r2 == 0) goto L_0x00e1
        L_0x00db:
            r7 = 1
            r16 = r7
            goto L_0x00e3
        L_0x00df:
            r17 = r2
        L_0x00e1:
            r16 = 0
        L_0x00e3:
            if (r16 == 0) goto L_0x0135
            com.ironsource.mediationsdk.model.n r2 = r1.b     // Catch:{ Exception -> 0x015f }
            com.ironsource.mediationsdk.model.NetworkSettings r2 = r2.a((java.lang.String) r0)     // Catch:{ Exception -> 0x015f }
            org.json.JSONObject r5 = r2.getRewardedVideoSettings()     // Catch:{ Exception -> 0x015f }
            org.json.JSONObject r7 = r2.getInterstitialSettings()     // Catch:{ Exception -> 0x015f }
            org.json.JSONObject r2 = r2.getBannerSettings()     // Catch:{ Exception -> 0x015f }
            r16 = r0
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ Exception -> 0x015f }
            java.lang.String r5 = r5.toString()     // Catch:{ Exception -> 0x015f }
            r0.<init>(r5)     // Catch:{ Exception -> 0x015f }
            org.json.JSONObject r5 = new org.json.JSONObject     // Catch:{ Exception -> 0x015f }
            java.lang.String r7 = r7.toString()     // Catch:{ Exception -> 0x015f }
            r5.<init>(r7)     // Catch:{ Exception -> 0x015f }
            org.json.JSONObject r7 = new org.json.JSONObject     // Catch:{ Exception -> 0x015f }
            java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x015f }
            r7.<init>(r2)     // Catch:{ Exception -> 0x015f }
            org.json.JSONObject r10 = com.ironsource.mediationsdk.utils.IronSourceUtils.mergeJsons(r0, r10)     // Catch:{ Exception -> 0x015f }
            org.json.JSONObject r11 = com.ironsource.mediationsdk.utils.IronSourceUtils.mergeJsons(r5, r11)     // Catch:{ Exception -> 0x015f }
            org.json.JSONObject r12 = com.ironsource.mediationsdk.utils.IronSourceUtils.mergeJsons(r7, r12)     // Catch:{ Exception -> 0x015f }
            com.ironsource.mediationsdk.model.NetworkSettings r0 = new com.ironsource.mediationsdk.model.NetworkSettings     // Catch:{ Exception -> 0x015f }
            r5 = r0
            r7 = r8
            r8 = r9
            r9 = r4
            r5.<init>(r6, r7, r8, r9, r10, r11, r12)     // Catch:{ Exception -> 0x015f }
            r0.setIsMultipleInstances(r13)     // Catch:{ Exception -> 0x015f }
            r0.setSubProviderId(r14)     // Catch:{ Exception -> 0x015f }
            r0.setAdSourceNameForEvents(r15)     // Catch:{ Exception -> 0x015f }
            com.ironsource.mediationsdk.model.n r2 = r1.b     // Catch:{ Exception -> 0x015f }
            goto L_0x014b
        L_0x0135:
            r16 = r0
            com.ironsource.mediationsdk.model.NetworkSettings r0 = new com.ironsource.mediationsdk.model.NetworkSettings     // Catch:{ Exception -> 0x015f }
            r5 = r0
            r7 = r8
            r8 = r9
            r9 = r4
            r5.<init>(r6, r7, r8, r9, r10, r11, r12)     // Catch:{ Exception -> 0x015f }
            r0.setIsMultipleInstances(r13)     // Catch:{ Exception -> 0x015f }
            r0.setSubProviderId(r14)     // Catch:{ Exception -> 0x015f }
            r0.setAdSourceNameForEvents(r15)     // Catch:{ Exception -> 0x015f }
            com.ironsource.mediationsdk.model.n r2 = r1.b     // Catch:{ Exception -> 0x015f }
        L_0x014b:
            r2.a((com.ironsource.mediationsdk.model.NetworkSettings) r0)     // Catch:{ Exception -> 0x015f }
            goto L_0x0153
        L_0x014f:
            r16 = r0
            r17 = r2
        L_0x0153:
            r0 = r16
            r2 = r17
            goto L_0x0016
        L_0x0159:
            com.ironsource.mediationsdk.model.n r0 = r1.b     // Catch:{ Exception -> 0x015f }
            r0.b()     // Catch:{ Exception -> 0x015f }
            return
        L_0x015f:
            r0 = move-exception
            r0.printStackTrace()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.mediationsdk.utils.l.h():void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:159:0x0525 A[Catch:{ Exception -> 0x0a72 }] */
    /* JADX WARNING: Removed duplicated region for block: B:242:0x0751 A[Catch:{ Exception -> 0x0a72 }] */
    /* JADX WARNING: Removed duplicated region for block: B:299:0x088b A[Catch:{ Exception -> 0x0a72 }] */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x0304 A[Catch:{ Exception -> 0x0a72 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void i() {
        /*
            r77 = this;
            r1 = r77
            java.lang.String r2 = "events"
            org.json.JSONObject r3 = r1.d     // Catch:{ Exception -> 0x0a72 }
            java.lang.String r4 = "configurations"
            org.json.JSONObject r3 = b(r3, r4)     // Catch:{ Exception -> 0x0a72 }
            java.lang.String r4 = "adUnits"
            org.json.JSONObject r4 = b(r3, r4)     // Catch:{ Exception -> 0x0a72 }
            java.lang.String r5 = "application"
            org.json.JSONObject r3 = b(r3, r5)     // Catch:{ Exception -> 0x0a72 }
            java.lang.String r5 = "rewardedVideo"
            org.json.JSONObject r5 = b(r4, r5)     // Catch:{ Exception -> 0x0a72 }
            java.lang.String r6 = "interstitial"
            org.json.JSONObject r6 = b(r4, r6)     // Catch:{ Exception -> 0x0a72 }
            java.lang.String r7 = "offerwall"
            org.json.JSONObject r7 = b(r4, r7)     // Catch:{ Exception -> 0x0a72 }
            java.lang.String r8 = "banner"
            org.json.JSONObject r4 = b(r4, r8)     // Catch:{ Exception -> 0x0a72 }
            org.json.JSONObject r8 = b(r3, r2)     // Catch:{ Exception -> 0x0a72 }
            java.lang.String r9 = "loggers"
            org.json.JSONObject r9 = b(r3, r9)     // Catch:{ Exception -> 0x0a72 }
            java.lang.String r10 = "token"
            org.json.JSONObject r10 = b(r3, r10)     // Catch:{ Exception -> 0x0a72 }
            java.lang.String r11 = "segment"
            org.json.JSONObject r11 = b(r3, r11)     // Catch:{ Exception -> 0x0a72 }
            java.lang.String r12 = "auction"
            org.json.JSONObject r12 = b(r3, r12)     // Catch:{ Exception -> 0x0a72 }
            java.lang.String r13 = "crashReporter"
            org.json.JSONObject r13 = b(r3, r13)     // Catch:{ Exception -> 0x0a72 }
            java.lang.String r14 = "settings"
            org.json.JSONObject r14 = b(r3, r14)     // Catch:{ Exception -> 0x0a72 }
            java.lang.String r15 = "external"
            org.json.JSONObject r15 = b(r3, r15)     // Catch:{ Exception -> 0x0a72 }
            r16 = r15
            java.lang.String r15 = "pixel"
            org.json.JSONObject r15 = b(r8, r15)     // Catch:{ Exception -> 0x0a72 }
            r17 = r14
            r14 = 1
            if (r3 == 0) goto L_0x007d
            r18 = r11
            java.lang.String r11 = "uuidEnabled"
            boolean r11 = r3.optBoolean(r11, r14)     // Catch:{ Exception -> 0x0a72 }
            android.content.Context r14 = r1.bw     // Catch:{ Exception -> 0x0a72 }
            r19 = r13
            java.lang.String r13 = "uuidEnabled"
            com.ironsource.mediationsdk.utils.IronSourceUtils.saveBooleanToSharedPrefs(r14, r13, r11)     // Catch:{ Exception -> 0x0a72 }
            goto L_0x0081
        L_0x007d:
            r18 = r11
            r19 = r13
        L_0x0081:
            if (r8 == 0) goto L_0x009b
            java.lang.String r11 = "abt"
            java.lang.String r11 = r8.optString(r11)     // Catch:{ Exception -> 0x0a72 }
            boolean r13 = android.text.TextUtils.isEmpty(r11)     // Catch:{ Exception -> 0x0a72 }
            if (r13 != 0) goto L_0x009b
            com.ironsource.mediationsdk.a.d r13 = com.ironsource.mediationsdk.a.d.e()     // Catch:{ Exception -> 0x0a72 }
            r13.p = r11     // Catch:{ Exception -> 0x0a72 }
            com.ironsource.mediationsdk.a.h r13 = com.ironsource.mediationsdk.a.h.e()     // Catch:{ Exception -> 0x0a72 }
            r13.p = r11     // Catch:{ Exception -> 0x0a72 }
        L_0x009b:
            java.lang.String r11 = "sendEventsToggle"
            java.lang.String r13 = "placements"
            java.lang.String r14 = "optIn"
            r20 = r9
            java.lang.String r9 = "optOut"
            r21 = r15
            java.lang.String r15 = "eventsCompression"
            r22 = r10
            java.lang.String r10 = ""
            r24 = 0
            r25 = r7
            if (r5 == 0) goto L_0x032d
            org.json.JSONArray r7 = r5.optJSONArray(r13)     // Catch:{ Exception -> 0x0a72 }
            r26 = r4
            org.json.JSONObject r4 = b(r5, r2)     // Catch:{ Exception -> 0x0a72 }
            r27 = r2
            java.lang.String r2 = "maxNumOfAdaptersToLoadOnStart"
            r28 = r13
            r13 = 2
            int r2 = a(r5, r3, r2, r13)     // Catch:{ Exception -> 0x0a72 }
            java.lang.String r13 = "advancedLoading"
            r29 = r2
            r2 = 0
            int r13 = a(r5, r3, r13, r2)     // Catch:{ Exception -> 0x0a72 }
            if (r13 <= 0) goto L_0x00d8
            r31 = r13
            r32 = 1
            goto L_0x00dc
        L_0x00d8:
            r31 = r29
            r32 = 0
        L_0x00dc:
            java.lang.String r2 = "adapterTimeOutInSeconds"
            r13 = 60
            int r33 = a(r5, r3, r2, r13)     // Catch:{ Exception -> 0x0a72 }
            java.lang.String r2 = "loadRVInterval"
            r13 = 300(0x12c, float:4.2E-43)
            int r34 = a(r5, r3, r2, r13)     // Catch:{ Exception -> 0x0a72 }
            java.lang.String r2 = "expiredDurationInMinutes"
            r13 = -1
            int r35 = a(r5, r3, r2, r13)     // Catch:{ Exception -> 0x0a72 }
            java.lang.String r2 = "delayLoadFailure"
            r13 = 3
            int r38 = a(r5, r3, r2, r13)     // Catch:{ Exception -> 0x0a72 }
            org.json.JSONObject r2 = com.ironsource.mediationsdk.utils.IronSourceUtils.mergeJsons(r4, r8)     // Catch:{ Exception -> 0x0a72 }
            java.lang.String r4 = "sendUltraEvents"
            r13 = 0
            boolean r40 = r2.optBoolean(r4, r13)     // Catch:{ Exception -> 0x0a72 }
            boolean r41 = r2.optBoolean(r11, r13)     // Catch:{ Exception -> 0x0a72 }
            boolean r42 = r2.optBoolean(r15, r13)     // Catch:{ Exception -> 0x0a72 }
            java.lang.String r4 = "serverEventsURL"
            java.lang.String r43 = r2.optString(r4, r10)     // Catch:{ Exception -> 0x0a72 }
            java.lang.String r4 = "serverEventsType"
            java.lang.String r44 = r2.optString(r4, r10)     // Catch:{ Exception -> 0x0a72 }
            java.lang.String r4 = "backupThreshold"
            r13 = -1
            int r45 = r2.optInt(r4, r13)     // Catch:{ Exception -> 0x0a72 }
            java.lang.String r4 = "maxNumberOfEvents"
            int r46 = r2.optInt(r4, r13)     // Catch:{ Exception -> 0x0a72 }
            java.lang.String r4 = "maxEventsPerBatch"
            r13 = 5000(0x1388, float:7.006E-42)
            int r47 = r2.optInt(r4, r13)     // Catch:{ Exception -> 0x0a72 }
            org.json.JSONArray r4 = r2.optJSONArray(r9)     // Catch:{ Exception -> 0x0a72 }
            if (r4 == 0) goto L_0x0151
            int r13 = r4.length()     // Catch:{ Exception -> 0x0a72 }
            int[] r13 = new int[r13]     // Catch:{ Exception -> 0x0a72 }
            r29 = r9
            r52 = r15
            r9 = 0
        L_0x013f:
            int r15 = r4.length()     // Catch:{ Exception -> 0x0a72 }
            if (r9 >= r15) goto L_0x014e
            int r15 = r4.optInt(r9)     // Catch:{ Exception -> 0x0a72 }
            r13[r9] = r15     // Catch:{ Exception -> 0x0a72 }
            int r9 = r9 + 1
            goto L_0x013f
        L_0x014e:
            r48 = r13
            goto L_0x0157
        L_0x0151:
            r29 = r9
            r52 = r15
            r48 = r24
        L_0x0157:
            org.json.JSONArray r4 = r2.optJSONArray(r14)     // Catch:{ Exception -> 0x0a72 }
            if (r4 == 0) goto L_0x0176
            int r9 = r4.length()     // Catch:{ Exception -> 0x0a72 }
            int[] r9 = new int[r9]     // Catch:{ Exception -> 0x0a72 }
            r13 = 0
        L_0x0164:
            int r15 = r4.length()     // Catch:{ Exception -> 0x0a72 }
            if (r13 >= r15) goto L_0x0173
            int r15 = r4.optInt(r13)     // Catch:{ Exception -> 0x0a72 }
            r9[r13] = r15     // Catch:{ Exception -> 0x0a72 }
            int r13 = r13 + 1
            goto L_0x0164
        L_0x0173:
            r49 = r9
            goto L_0x0178
        L_0x0176:
            r49 = r24
        L_0x0178:
            java.lang.String r4 = "triggerEvents"
            org.json.JSONArray r4 = r2.optJSONArray(r4)     // Catch:{ Exception -> 0x0a72 }
            if (r4 == 0) goto L_0x0199
            int r9 = r4.length()     // Catch:{ Exception -> 0x0a72 }
            int[] r9 = new int[r9]     // Catch:{ Exception -> 0x0a72 }
            r13 = 0
        L_0x0187:
            int r15 = r4.length()     // Catch:{ Exception -> 0x0a72 }
            if (r13 >= r15) goto L_0x0196
            int r15 = r4.optInt(r13)     // Catch:{ Exception -> 0x0a72 }
            r9[r13] = r15     // Catch:{ Exception -> 0x0a72 }
            int r13 = r13 + 1
            goto L_0x0187
        L_0x0196:
            r50 = r9
            goto L_0x019b
        L_0x0199:
            r50 = r24
        L_0x019b:
            java.lang.String r4 = "nonConnectivityEvents"
            org.json.JSONArray r2 = r2.optJSONArray(r4)     // Catch:{ Exception -> 0x0a72 }
            if (r2 == 0) goto L_0x01bc
            int r4 = r2.length()     // Catch:{ Exception -> 0x0a72 }
            int[] r4 = new int[r4]     // Catch:{ Exception -> 0x0a72 }
            r9 = 0
        L_0x01aa:
            int r13 = r2.length()     // Catch:{ Exception -> 0x0a72 }
            if (r9 >= r13) goto L_0x01b9
            int r13 = r2.optInt(r9)     // Catch:{ Exception -> 0x0a72 }
            r4[r9] = r13     // Catch:{ Exception -> 0x0a72 }
            int r9 = r9 + 1
            goto L_0x01aa
        L_0x01b9:
            r51 = r4
            goto L_0x01be
        L_0x01bc:
            r51 = r24
        L_0x01be:
            com.ironsource.sdk.g.d r2 = new com.ironsource.sdk.g.d     // Catch:{ Exception -> 0x0a72 }
            r39 = r2
            r39.<init>(r40, r41, r42, r43, r44, r45, r46, r47, r48, r49, r50, r51)     // Catch:{ Exception -> 0x0a72 }
            if (r12 == 0) goto L_0x0286
            java.lang.String r4 = "rewardedVideo"
            org.json.JSONObject r4 = b(r12, r4)     // Catch:{ Exception -> 0x0a72 }
            java.lang.String r9 = "auctionData"
            java.lang.String r54 = r12.optString(r9, r10)     // Catch:{ Exception -> 0x0a72 }
            java.lang.String r9 = "auctioneerURL"
            java.lang.String r55 = r12.optString(r9, r10)     // Catch:{ Exception -> 0x0a72 }
            java.lang.String r9 = "auctionTrials"
            r13 = 2
            int r56 = r12.optInt(r9, r13)     // Catch:{ Exception -> 0x0a72 }
            java.lang.String r9 = "auctionTimeout"
            r15 = r14
            r13 = 10000(0x2710, double:4.9407E-320)
            long r58 = r12.optLong(r9, r13)     // Catch:{ Exception -> 0x0a72 }
            java.lang.String r9 = "auctionSavedHistory"
            r13 = 15
            int r57 = r12.optInt(r9, r13)     // Catch:{ Exception -> 0x0a72 }
            java.lang.String r9 = "compressAuctionRequest"
            r13 = 0
            boolean r72 = r12.optBoolean(r9, r13)     // Catch:{ Exception -> 0x0a72 }
            java.lang.String r9 = "compressAuctionResponse"
            boolean r73 = r12.optBoolean(r9, r13)     // Catch:{ Exception -> 0x0a72 }
            java.lang.String r9 = "encryptionVersion"
            r14 = 1
            int r75 = r12.optInt(r9, r14)     // Catch:{ Exception -> 0x0a72 }
            java.lang.String r9 = "programmatic"
            boolean r60 = r4.optBoolean(r9, r13)     // Catch:{ Exception -> 0x0a72 }
            java.lang.String r9 = "minTimeBeforeFirstAuction"
            r13 = 2000(0x7d0, float:2.803E-42)
            int r9 = r4.optInt(r9, r13)     // Catch:{ Exception -> 0x0a72 }
            java.lang.String r13 = "auctionRetryInterval"
            r14 = 30000(0x7530, float:4.2039E-41)
            int r13 = r4.optInt(r13, r14)     // Catch:{ Exception -> 0x0a72 }
            java.lang.String r14 = "timeToWaitBeforeAuction"
            r39 = r15
            r15 = 5000(0x1388, float:7.006E-42)
            int r14 = r4.optInt(r14, r15)     // Catch:{ Exception -> 0x0a72 }
            java.lang.String r15 = "timeToWaitBeforeLoad"
            r40 = r12
            r12 = 50
            int r12 = r4.optInt(r15, r12)     // Catch:{ Exception -> 0x0a72 }
            java.lang.String r15 = "isAuctionOnShowStart"
            r41 = r11
            r11 = 0
            boolean r69 = r4.optBoolean(r15, r11)     // Catch:{ Exception -> 0x0a72 }
            java.lang.String r15 = "objectPerWaterfall"
            boolean r74 = r4.optBoolean(r15, r11)     // Catch:{ Exception -> 0x0a72 }
            java.lang.String r15 = "isLoadWhileShow"
            boolean r70 = r4.optBoolean(r15, r11)     // Catch:{ Exception -> 0x0a72 }
            java.lang.String r11 = "timeToDeleteOldWaterfallAfterAuction"
            r15 = 30000(0x7530, float:4.2039E-41)
            int r71 = r4.optInt(r11, r15)     // Catch:{ Exception -> 0x0a72 }
            com.ironsource.mediationsdk.utils.c r11 = new com.ironsource.mediationsdk.utils.c     // Catch:{ Exception -> 0x0a72 }
            r15 = r8
            long r8 = (long) r9     // Catch:{ Exception -> 0x0a72 }
            r61 = r8
            long r8 = (long) r13     // Catch:{ Exception -> 0x0a72 }
            r63 = r8
            long r8 = (long) r14     // Catch:{ Exception -> 0x0a72 }
            r65 = r8
            long r8 = (long) r12     // Catch:{ Exception -> 0x0a72 }
            r67 = r8
            r76 = 0
            r53 = r11
            r53.<init>(r54, r55, r56, r57, r58, r60, r61, r63, r65, r67, r69, r70, r71, r72, r73, r74, r75, r76)     // Catch:{ Exception -> 0x0a72 }
            java.lang.String r8 = "disableLoadWhileShowSupportFor"
            org.json.JSONArray r4 = r4.optJSONArray(r8)     // Catch:{ Exception -> 0x0a72 }
            if (r4 == 0) goto L_0x0283
            r8 = 0
        L_0x026b:
            int r9 = r4.length()     // Catch:{ Exception -> 0x0a72 }
            if (r8 >= r9) goto L_0x0283
            java.lang.String r9 = r4.optString(r8)     // Catch:{ Exception -> 0x0a72 }
            boolean r12 = android.text.TextUtils.isEmpty(r9)     // Catch:{ Exception -> 0x0a72 }
            if (r12 != 0) goto L_0x0280
            java.util.ArrayList<java.lang.String> r12 = r11.o     // Catch:{ Exception -> 0x0a72 }
            r12.add(r9)     // Catch:{ Exception -> 0x0a72 }
        L_0x0280:
            int r8 = r8 + 1
            goto L_0x026b
        L_0x0283:
            r37 = r11
            goto L_0x0294
        L_0x0286:
            r15 = r8
            r41 = r11
            r40 = r12
            r39 = r14
            com.ironsource.mediationsdk.utils.c r4 = new com.ironsource.mediationsdk.utils.c     // Catch:{ Exception -> 0x0a72 }
            r4.<init>()     // Catch:{ Exception -> 0x0a72 }
            r37 = r4
        L_0x0294:
            com.ironsource.mediationsdk.model.o r4 = new com.ironsource.mediationsdk.model.o     // Catch:{ Exception -> 0x0a72 }
            r30 = r4
            r36 = r2
            r30.<init>(r31, r32, r33, r34, r35, r36, r37, r38)     // Catch:{ Exception -> 0x0a72 }
            if (r7 == 0) goto L_0x030e
            r2 = 0
        L_0x02a0:
            int r8 = r7.length()     // Catch:{ Exception -> 0x0a72 }
            if (r2 >= r8) goto L_0x030e
            org.json.JSONObject r8 = r7.optJSONObject(r2)     // Catch:{ Exception -> 0x0a72 }
            if (r8 == 0) goto L_0x02f2
            java.lang.String r9 = "placementId"
            r11 = -1
            int r31 = r8.optInt(r9, r11)     // Catch:{ Exception -> 0x0a72 }
            java.lang.String r9 = "placementName"
            java.lang.String r32 = r8.optString(r9, r10)     // Catch:{ Exception -> 0x0a72 }
            java.lang.String r9 = "isDefault"
            r11 = 0
            boolean r33 = r8.optBoolean(r9, r11)     // Catch:{ Exception -> 0x0a72 }
            java.lang.String r9 = "virtualItemName"
            java.lang.String r34 = r8.optString(r9, r10)     // Catch:{ Exception -> 0x0a72 }
            java.lang.String r9 = "virtualItemCount"
            r11 = -1
            int r35 = r8.optInt(r9, r11)     // Catch:{ Exception -> 0x0a72 }
            com.ironsource.mediationsdk.model.k r8 = a((org.json.JSONObject) r8)     // Catch:{ Exception -> 0x0a72 }
            if (r31 < 0) goto L_0x02f2
            boolean r9 = android.text.TextUtils.isEmpty(r32)     // Catch:{ Exception -> 0x0a72 }
            if (r9 != 0) goto L_0x02f2
            boolean r9 = android.text.TextUtils.isEmpty(r34)     // Catch:{ Exception -> 0x0a72 }
            if (r9 != 0) goto L_0x02f2
            if (r35 <= 0) goto L_0x02f2
            com.ironsource.mediationsdk.model.Placement r9 = new com.ironsource.mediationsdk.model.Placement     // Catch:{ Exception -> 0x0a72 }
            r30 = r9
            r36 = r8
            r30.<init>(r31, r32, r33, r34, r35, r36)     // Catch:{ Exception -> 0x0a72 }
            if (r8 == 0) goto L_0x02f4
            android.content.Context r8 = r1.bw     // Catch:{ Exception -> 0x0a72 }
            com.ironsource.mediationsdk.utils.k.a((android.content.Context) r8, (com.ironsource.mediationsdk.model.Placement) r9)     // Catch:{ Exception -> 0x0a72 }
            goto L_0x02f4
        L_0x02f2:
            r9 = r24
        L_0x02f4:
            if (r9 == 0) goto L_0x030b
            if (r9 == 0) goto L_0x030b
            java.util.ArrayList<com.ironsource.mediationsdk.model.Placement> r8 = r4.a     // Catch:{ Exception -> 0x0a72 }
            r8.add(r9)     // Catch:{ Exception -> 0x0a72 }
            com.ironsource.mediationsdk.model.Placement r8 = r4.k     // Catch:{ Exception -> 0x0a72 }
            if (r8 != 0) goto L_0x0304
        L_0x0301:
            r4.k = r9     // Catch:{ Exception -> 0x0a72 }
            goto L_0x030b
        L_0x0304:
            int r8 = r9.getPlacementId()     // Catch:{ Exception -> 0x0a72 }
            if (r8 != 0) goto L_0x030b
            goto L_0x0301
        L_0x030b:
            int r2 = r2 + 1
            goto L_0x02a0
        L_0x030e:
            java.lang.String r2 = "backFill"
            java.lang.String r2 = r5.optString(r2)     // Catch:{ Exception -> 0x0a72 }
            boolean r7 = android.text.TextUtils.isEmpty(r2)     // Catch:{ Exception -> 0x0a72 }
            if (r7 != 0) goto L_0x031c
            r4.f = r2     // Catch:{ Exception -> 0x0a72 }
        L_0x031c:
            java.lang.String r2 = "premium"
            java.lang.String r2 = r5.optString(r2)     // Catch:{ Exception -> 0x0a72 }
            boolean r5 = android.text.TextUtils.isEmpty(r2)     // Catch:{ Exception -> 0x0a72 }
            if (r5 != 0) goto L_0x032a
            r4.g = r2     // Catch:{ Exception -> 0x0a72 }
        L_0x032a:
            r31 = r4
            goto L_0x0340
        L_0x032d:
            r27 = r2
            r26 = r4
            r29 = r9
            r41 = r11
            r40 = r12
            r28 = r13
            r39 = r14
            r52 = r15
            r15 = r8
            r31 = r24
        L_0x0340:
            if (r6 == 0) goto L_0x0554
            r2 = r28
            org.json.JSONArray r4 = r6.optJSONArray(r2)     // Catch:{ Exception -> 0x0a72 }
            r5 = r27
            org.json.JSONObject r7 = b(r6, r5)     // Catch:{ Exception -> 0x0a72 }
            java.lang.String r8 = "maxNumOfAdaptersToLoadOnStart"
            r9 = 2
            int r8 = a(r6, r3, r8, r9)     // Catch:{ Exception -> 0x0a72 }
            java.lang.String r9 = "advancedLoading"
            r11 = 0
            int r9 = a(r6, r3, r9, r11)     // Catch:{ Exception -> 0x0a72 }
            if (r9 <= 0) goto L_0x0363
            r33 = r9
            r34 = 1
            goto L_0x0367
        L_0x0363:
            r33 = r8
            r34 = 0
        L_0x0367:
            java.lang.String r8 = "adapterTimeOutInSeconds"
            r9 = 60
            int r35 = a(r6, r3, r8, r9)     // Catch:{ Exception -> 0x0a72 }
            java.lang.String r8 = "delayLoadFailure"
            r9 = 3
            int r38 = a(r6, r3, r8, r9)     // Catch:{ Exception -> 0x0a72 }
            r8 = r15
            org.json.JSONObject r7 = com.ironsource.mediationsdk.utils.IronSourceUtils.mergeJsons(r7, r8)     // Catch:{ Exception -> 0x0a72 }
            r9 = r41
            r11 = 0
            boolean r55 = r7.optBoolean(r9, r11)     // Catch:{ Exception -> 0x0a72 }
            r12 = r52
            boolean r56 = r7.optBoolean(r12, r11)     // Catch:{ Exception -> 0x0a72 }
            java.lang.String r11 = "serverEventsURL"
            java.lang.String r57 = r7.optString(r11, r10)     // Catch:{ Exception -> 0x0a72 }
            java.lang.String r11 = "serverEventsType"
            java.lang.String r58 = r7.optString(r11, r10)     // Catch:{ Exception -> 0x0a72 }
            java.lang.String r11 = "backupThreshold"
            r13 = -1
            int r59 = r7.optInt(r11, r13)     // Catch:{ Exception -> 0x0a72 }
            java.lang.String r11 = "maxNumberOfEvents"
            int r60 = r7.optInt(r11, r13)     // Catch:{ Exception -> 0x0a72 }
            java.lang.String r11 = "maxEventsPerBatch"
            r13 = 5000(0x1388, float:7.006E-42)
            int r61 = r7.optInt(r11, r13)     // Catch:{ Exception -> 0x0a72 }
            r11 = r29
            org.json.JSONArray r13 = r7.optJSONArray(r11)     // Catch:{ Exception -> 0x0a72 }
            if (r13 == 0) goto L_0x03cc
            int r14 = r13.length()     // Catch:{ Exception -> 0x0a72 }
            int[] r14 = new int[r14]     // Catch:{ Exception -> 0x0a72 }
            r29 = r11
            r15 = 0
        L_0x03ba:
            int r11 = r13.length()     // Catch:{ Exception -> 0x0a72 }
            if (r15 >= r11) goto L_0x03c9
            int r11 = r13.optInt(r15)     // Catch:{ Exception -> 0x0a72 }
            r14[r15] = r11     // Catch:{ Exception -> 0x0a72 }
            int r15 = r15 + 1
            goto L_0x03ba
        L_0x03c9:
            r62 = r14
            goto L_0x03d0
        L_0x03cc:
            r29 = r11
            r62 = r24
        L_0x03d0:
            r11 = r39
            org.json.JSONArray r13 = r7.optJSONArray(r11)     // Catch:{ Exception -> 0x0a72 }
            if (r13 == 0) goto L_0x03f3
            int r14 = r13.length()     // Catch:{ Exception -> 0x0a72 }
            int[] r14 = new int[r14]     // Catch:{ Exception -> 0x0a72 }
            r39 = r11
            r15 = 0
        L_0x03e1:
            int r11 = r13.length()     // Catch:{ Exception -> 0x0a72 }
            if (r15 >= r11) goto L_0x03f0
            int r11 = r13.optInt(r15)     // Catch:{ Exception -> 0x0a72 }
            r14[r15] = r11     // Catch:{ Exception -> 0x0a72 }
            int r15 = r15 + 1
            goto L_0x03e1
        L_0x03f0:
            r63 = r14
            goto L_0x03f7
        L_0x03f3:
            r39 = r11
            r63 = r24
        L_0x03f7:
            java.lang.String r11 = "triggerEvents"
            org.json.JSONArray r11 = r7.optJSONArray(r11)     // Catch:{ Exception -> 0x0a72 }
            if (r11 == 0) goto L_0x0418
            int r13 = r11.length()     // Catch:{ Exception -> 0x0a72 }
            int[] r13 = new int[r13]     // Catch:{ Exception -> 0x0a72 }
            r14 = 0
        L_0x0406:
            int r15 = r11.length()     // Catch:{ Exception -> 0x0a72 }
            if (r14 >= r15) goto L_0x0415
            int r15 = r11.optInt(r14)     // Catch:{ Exception -> 0x0a72 }
            r13[r14] = r15     // Catch:{ Exception -> 0x0a72 }
            int r14 = r14 + 1
            goto L_0x0406
        L_0x0415:
            r64 = r13
            goto L_0x041a
        L_0x0418:
            r64 = r24
        L_0x041a:
            java.lang.String r11 = "nonConnectivityEvents"
            org.json.JSONArray r7 = r7.optJSONArray(r11)     // Catch:{ Exception -> 0x0a72 }
            if (r7 == 0) goto L_0x043b
            int r11 = r7.length()     // Catch:{ Exception -> 0x0a72 }
            int[] r11 = new int[r11]     // Catch:{ Exception -> 0x0a72 }
            r13 = 0
        L_0x0429:
            int r14 = r7.length()     // Catch:{ Exception -> 0x0a72 }
            if (r13 >= r14) goto L_0x0438
            int r14 = r7.optInt(r13)     // Catch:{ Exception -> 0x0a72 }
            r11[r13] = r14     // Catch:{ Exception -> 0x0a72 }
            int r13 = r13 + 1
            goto L_0x0429
        L_0x0438:
            r65 = r11
            goto L_0x043d
        L_0x043b:
            r65 = r24
        L_0x043d:
            com.ironsource.sdk.g.d r7 = new com.ironsource.sdk.g.d     // Catch:{ Exception -> 0x0a72 }
            r54 = 0
            r53 = r7
            r53.<init>(r54, r55, r56, r57, r58, r59, r60, r61, r62, r63, r64, r65)     // Catch:{ Exception -> 0x0a72 }
            if (r40 == 0) goto L_0x04ba
            java.lang.String r11 = "interstitial"
            r13 = r40
            org.json.JSONObject r11 = b(r13, r11)     // Catch:{ Exception -> 0x0a72 }
            java.lang.String r14 = "auctionData"
            java.lang.String r41 = r13.optString(r14, r10)     // Catch:{ Exception -> 0x0a72 }
            java.lang.String r14 = "auctioneerURL"
            java.lang.String r42 = r13.optString(r14, r10)     // Catch:{ Exception -> 0x0a72 }
            java.lang.String r14 = "auctionTrials"
            r15 = 2
            int r43 = r13.optInt(r14, r15)     // Catch:{ Exception -> 0x0a72 }
            java.lang.String r14 = "auctionSavedHistory"
            r15 = 15
            int r44 = r13.optInt(r14, r15)     // Catch:{ Exception -> 0x0a72 }
            java.lang.String r14 = "auctionTimeout"
            r15 = r8
            r27 = r9
            r8 = 10000(0x2710, double:4.9407E-320)
            long r45 = r13.optLong(r14, r8)     // Catch:{ Exception -> 0x0a72 }
            java.lang.String r8 = "compressAuctionRequest"
            r9 = 0
            boolean r59 = r13.optBoolean(r8, r9)     // Catch:{ Exception -> 0x0a72 }
            java.lang.String r8 = "compressAuctionResponse"
            boolean r60 = r13.optBoolean(r8, r9)     // Catch:{ Exception -> 0x0a72 }
            java.lang.String r8 = "encryptionVersion"
            r14 = 1
            int r62 = r13.optInt(r8, r14)     // Catch:{ Exception -> 0x0a72 }
            java.lang.String r8 = "programmatic"
            boolean r47 = r11.optBoolean(r8, r9)     // Catch:{ Exception -> 0x0a72 }
            java.lang.String r8 = "objectPerWaterfall"
            boolean r61 = r11.optBoolean(r8, r9)     // Catch:{ Exception -> 0x0a72 }
            java.lang.String r8 = "minTimeBeforeFirstAuction"
            r9 = 2000(0x7d0, float:2.803E-42)
            int r8 = r11.optInt(r8, r9)     // Catch:{ Exception -> 0x0a72 }
            com.ironsource.mediationsdk.utils.c r9 = new com.ironsource.mediationsdk.utils.c     // Catch:{ Exception -> 0x0a72 }
            r11 = r15
            long r14 = (long) r8     // Catch:{ Exception -> 0x0a72 }
            r48 = r14
            r50 = 0
            r52 = 0
            r54 = 0
            r56 = 1
            r57 = 1
            r58 = 0
            r63 = 0
            r40 = r9
            r40.<init>(r41, r42, r43, r44, r45, r47, r48, r50, r52, r54, r56, r57, r58, r59, r60, r61, r62, r63)     // Catch:{ Exception -> 0x0a72 }
            r37 = r9
            goto L_0x04c6
        L_0x04ba:
            r11 = r8
            r27 = r9
            r13 = r40
            com.ironsource.mediationsdk.utils.c r8 = new com.ironsource.mediationsdk.utils.c     // Catch:{ Exception -> 0x0a72 }
            r8.<init>()     // Catch:{ Exception -> 0x0a72 }
            r37 = r8
        L_0x04c6:
            com.ironsource.mediationsdk.model.h r8 = new com.ironsource.mediationsdk.model.h     // Catch:{ Exception -> 0x0a72 }
            r32 = r8
            r36 = r7
            r32.<init>(r33, r34, r35, r36, r37, r38)     // Catch:{ Exception -> 0x0a72 }
            if (r4 == 0) goto L_0x0533
            r7 = 0
        L_0x04d2:
            int r9 = r4.length()     // Catch:{ Exception -> 0x0a72 }
            if (r7 >= r9) goto L_0x0533
            org.json.JSONObject r9 = r4.optJSONObject(r7)     // Catch:{ Exception -> 0x0a72 }
            if (r9 == 0) goto L_0x050f
            java.lang.String r14 = "placementId"
            r15 = -1
            int r14 = r9.optInt(r14, r15)     // Catch:{ Exception -> 0x0a72 }
            java.lang.String r15 = "placementName"
            java.lang.String r15 = r9.optString(r15, r10)     // Catch:{ Exception -> 0x0a72 }
            r28 = r4
            java.lang.String r4 = "isDefault"
            r30 = r11
            r11 = 0
            boolean r4 = r9.optBoolean(r4, r11)     // Catch:{ Exception -> 0x0a72 }
            com.ironsource.mediationsdk.model.k r9 = a((org.json.JSONObject) r9)     // Catch:{ Exception -> 0x0a72 }
            if (r14 < 0) goto L_0x0513
            boolean r11 = android.text.TextUtils.isEmpty(r15)     // Catch:{ Exception -> 0x0a72 }
            if (r11 != 0) goto L_0x0513
            com.ironsource.mediationsdk.model.InterstitialPlacement r11 = new com.ironsource.mediationsdk.model.InterstitialPlacement     // Catch:{ Exception -> 0x0a72 }
            r11.<init>(r14, r15, r4, r9)     // Catch:{ Exception -> 0x0a72 }
            if (r9 == 0) goto L_0x0515
            android.content.Context r4 = r1.bw     // Catch:{ Exception -> 0x0a72 }
            com.ironsource.mediationsdk.utils.k.a((android.content.Context) r4, (com.ironsource.mediationsdk.model.InterstitialPlacement) r11)     // Catch:{ Exception -> 0x0a72 }
            goto L_0x0515
        L_0x050f:
            r28 = r4
            r30 = r11
        L_0x0513:
            r11 = r24
        L_0x0515:
            if (r11 == 0) goto L_0x052c
            if (r11 == 0) goto L_0x052c
            java.util.ArrayList<com.ironsource.mediationsdk.model.InterstitialPlacement> r4 = r8.a     // Catch:{ Exception -> 0x0a72 }
            r4.add(r11)     // Catch:{ Exception -> 0x0a72 }
            com.ironsource.mediationsdk.model.InterstitialPlacement r4 = r8.j     // Catch:{ Exception -> 0x0a72 }
            if (r4 != 0) goto L_0x0525
        L_0x0522:
            r8.j = r11     // Catch:{ Exception -> 0x0a72 }
            goto L_0x052c
        L_0x0525:
            int r4 = r11.getPlacementId()     // Catch:{ Exception -> 0x0a72 }
            if (r4 != 0) goto L_0x052c
            goto L_0x0522
        L_0x052c:
            int r7 = r7 + 1
            r4 = r28
            r11 = r30
            goto L_0x04d2
        L_0x0533:
            r30 = r11
            java.lang.String r4 = "backFill"
            java.lang.String r4 = r6.optString(r4)     // Catch:{ Exception -> 0x0a72 }
            boolean r7 = android.text.TextUtils.isEmpty(r4)     // Catch:{ Exception -> 0x0a72 }
            if (r7 != 0) goto L_0x0543
            r8.g = r4     // Catch:{ Exception -> 0x0a72 }
        L_0x0543:
            java.lang.String r4 = "premium"
            java.lang.String r4 = r6.optString(r4)     // Catch:{ Exception -> 0x0a72 }
            boolean r6 = android.text.TextUtils.isEmpty(r4)     // Catch:{ Exception -> 0x0a72 }
            if (r6 != 0) goto L_0x0551
            r8.h = r4     // Catch:{ Exception -> 0x0a72 }
        L_0x0551:
            r32 = r8
            goto L_0x0562
        L_0x0554:
            r30 = r15
            r5 = r27
            r2 = r28
            r13 = r40
            r27 = r41
            r12 = r52
            r32 = r24
        L_0x0562:
            if (r26 == 0) goto L_0x0764
            r4 = r26
            org.json.JSONArray r6 = r4.optJSONArray(r2)     // Catch:{ Exception -> 0x0a72 }
            org.json.JSONObject r7 = b(r4, r5)     // Catch:{ Exception -> 0x0a72 }
            java.lang.String r8 = "maxNumOfAdaptersToLoadOnStart"
            r9 = 1
            int r41 = a(r4, r3, r8, r9)     // Catch:{ Exception -> 0x0a72 }
            java.lang.String r8 = "atim"
            boolean r9 = r4.has(r8)     // Catch:{ Exception -> 0x0a72 }
            r14 = 0
            if (r9 == 0) goto L_0x0584
            long r8 = r4.optLong(r8, r14)     // Catch:{ Exception -> 0x0a72 }
            goto L_0x0590
        L_0x0584:
            boolean r9 = r3.has(r8)     // Catch:{ Exception -> 0x0a72 }
            if (r9 == 0) goto L_0x058f
            long r8 = r3.optLong(r8, r14)     // Catch:{ Exception -> 0x0a72 }
            goto L_0x0590
        L_0x058f:
            r8 = r14
        L_0x0590:
            int r11 = (r8 > r14 ? 1 : (r8 == r14 ? 0 : -1))
            if (r11 != 0) goto L_0x0596
            r8 = 10000(0x2710, double:4.9407E-320)
        L_0x0596:
            r42 = r8
            java.lang.String r8 = "delayLoadFailure"
            r9 = 3
            int r47 = a(r4, r3, r8, r9)     // Catch:{ Exception -> 0x0a72 }
            java.lang.String r8 = "bannerInterval"
            r9 = 60
            int r45 = a(r4, r3, r8, r9)     // Catch:{ Exception -> 0x0a72 }
            r4 = r30
            org.json.JSONObject r7 = com.ironsource.mediationsdk.utils.IronSourceUtils.mergeJsons(r7, r4)     // Catch:{ Exception -> 0x0a72 }
            r8 = r27
            r9 = 0
            boolean r50 = r7.optBoolean(r8, r9)     // Catch:{ Exception -> 0x0a72 }
            boolean r51 = r7.optBoolean(r12, r9)     // Catch:{ Exception -> 0x0a72 }
            java.lang.String r9 = "serverEventsURL"
            java.lang.String r52 = r7.optString(r9, r10)     // Catch:{ Exception -> 0x0a72 }
            java.lang.String r9 = "serverEventsType"
            java.lang.String r53 = r7.optString(r9, r10)     // Catch:{ Exception -> 0x0a72 }
            java.lang.String r9 = "backupThreshold"
            r11 = -1
            int r54 = r7.optInt(r9, r11)     // Catch:{ Exception -> 0x0a72 }
            java.lang.String r9 = "maxNumberOfEvents"
            int r55 = r7.optInt(r9, r11)     // Catch:{ Exception -> 0x0a72 }
            java.lang.String r9 = "maxEventsPerBatch"
            r11 = 5000(0x1388, float:7.006E-42)
            int r56 = r7.optInt(r9, r11)     // Catch:{ Exception -> 0x0a72 }
            r9 = r29
            org.json.JSONArray r11 = r7.optJSONArray(r9)     // Catch:{ Exception -> 0x0a72 }
            if (r11 == 0) goto L_0x05fc
            int r14 = r11.length()     // Catch:{ Exception -> 0x0a72 }
            int[] r14 = new int[r14]     // Catch:{ Exception -> 0x0a72 }
            r26 = r3
            r15 = 0
        L_0x05ea:
            int r3 = r11.length()     // Catch:{ Exception -> 0x0a72 }
            if (r15 >= r3) goto L_0x05f9
            int r3 = r11.optInt(r15)     // Catch:{ Exception -> 0x0a72 }
            r14[r15] = r3     // Catch:{ Exception -> 0x0a72 }
            int r15 = r15 + 1
            goto L_0x05ea
        L_0x05f9:
            r57 = r14
            goto L_0x0600
        L_0x05fc:
            r26 = r3
            r57 = r24
        L_0x0600:
            r3 = r39
            org.json.JSONArray r11 = r7.optJSONArray(r3)     // Catch:{ Exception -> 0x0a72 }
            if (r11 == 0) goto L_0x0623
            int r14 = r11.length()     // Catch:{ Exception -> 0x0a72 }
            int[] r14 = new int[r14]     // Catch:{ Exception -> 0x0a72 }
            r28 = r2
            r15 = 0
        L_0x0611:
            int r2 = r11.length()     // Catch:{ Exception -> 0x0a72 }
            if (r15 >= r2) goto L_0x0620
            int r2 = r11.optInt(r15)     // Catch:{ Exception -> 0x0a72 }
            r14[r15] = r2     // Catch:{ Exception -> 0x0a72 }
            int r15 = r15 + 1
            goto L_0x0611
        L_0x0620:
            r58 = r14
            goto L_0x0627
        L_0x0623:
            r28 = r2
            r58 = r24
        L_0x0627:
            java.lang.String r2 = "triggerEvents"
            org.json.JSONArray r2 = r7.optJSONArray(r2)     // Catch:{ Exception -> 0x0a72 }
            if (r2 == 0) goto L_0x0648
            int r11 = r2.length()     // Catch:{ Exception -> 0x0a72 }
            int[] r11 = new int[r11]     // Catch:{ Exception -> 0x0a72 }
            r14 = 0
        L_0x0636:
            int r15 = r2.length()     // Catch:{ Exception -> 0x0a72 }
            if (r14 >= r15) goto L_0x0645
            int r15 = r2.optInt(r14)     // Catch:{ Exception -> 0x0a72 }
            r11[r14] = r15     // Catch:{ Exception -> 0x0a72 }
            int r14 = r14 + 1
            goto L_0x0636
        L_0x0645:
            r59 = r11
            goto L_0x064a
        L_0x0648:
            r59 = r24
        L_0x064a:
            java.lang.String r2 = "nonConnectivityEvents"
            org.json.JSONArray r2 = r7.optJSONArray(r2)     // Catch:{ Exception -> 0x0a72 }
            if (r2 == 0) goto L_0x066b
            int r7 = r2.length()     // Catch:{ Exception -> 0x0a72 }
            int[] r7 = new int[r7]     // Catch:{ Exception -> 0x0a72 }
            r11 = 0
        L_0x0659:
            int r14 = r2.length()     // Catch:{ Exception -> 0x0a72 }
            if (r11 >= r14) goto L_0x0668
            int r14 = r2.optInt(r11)     // Catch:{ Exception -> 0x0a72 }
            r7[r11] = r14     // Catch:{ Exception -> 0x0a72 }
            int r11 = r11 + 1
            goto L_0x0659
        L_0x0668:
            r60 = r7
            goto L_0x066d
        L_0x066b:
            r60 = r24
        L_0x066d:
            com.ironsource.sdk.g.d r2 = new com.ironsource.sdk.g.d     // Catch:{ Exception -> 0x0a72 }
            r49 = 0
            r48 = r2
            r48.<init>(r49, r50, r51, r52, r53, r54, r55, r56, r57, r58, r59, r60)     // Catch:{ Exception -> 0x0a72 }
            if (r13 == 0) goto L_0x06eb
            java.lang.String r7 = "banner"
            org.json.JSONObject r7 = b(r13, r7)     // Catch:{ Exception -> 0x0a72 }
            if (r7 == 0) goto L_0x06e5
            java.lang.String r11 = "auctionData"
            java.lang.String r49 = r13.optString(r11, r10)     // Catch:{ Exception -> 0x0a72 }
            java.lang.String r11 = "auctioneerURL"
            java.lang.String r50 = r13.optString(r11, r10)     // Catch:{ Exception -> 0x0a72 }
            java.lang.String r11 = "auctionTrials"
            r14 = 2
            int r51 = r13.optInt(r11, r14)     // Catch:{ Exception -> 0x0a72 }
            java.lang.String r11 = "auctionSavedHistory"
            r14 = 15
            int r52 = r13.optInt(r11, r14)     // Catch:{ Exception -> 0x0a72 }
            java.lang.String r11 = "auctionTimeout"
            r14 = 10000(0x2710, double:4.9407E-320)
            long r53 = r13.optLong(r11, r14)     // Catch:{ Exception -> 0x0a72 }
            java.lang.String r11 = "compressAuctionRequest"
            r14 = 0
            boolean r67 = r13.optBoolean(r11, r14)     // Catch:{ Exception -> 0x0a72 }
            java.lang.String r11 = "compressAuctionResponse"
            boolean r68 = r13.optBoolean(r11, r14)     // Catch:{ Exception -> 0x0a72 }
            java.lang.String r11 = "encryptionVersion"
            r15 = 1
            int r70 = r13.optInt(r11, r15)     // Catch:{ Exception -> 0x0a72 }
            java.lang.String r11 = "programmatic"
            boolean r55 = r7.optBoolean(r11, r14)     // Catch:{ Exception -> 0x0a72 }
            java.lang.String r11 = "minTimeBeforeFirstAuction"
            r14 = 2000(0x7d0, float:2.803E-42)
            int r11 = r7.optInt(r11, r14)     // Catch:{ Exception -> 0x0a72 }
            java.lang.String r14 = "shouldSendBannerBURLFromImpression"
            r15 = 1
            boolean r71 = r7.optBoolean(r14, r15)     // Catch:{ Exception -> 0x0a72 }
            com.ironsource.mediationsdk.utils.c r7 = new com.ironsource.mediationsdk.utils.c     // Catch:{ Exception -> 0x0a72 }
            long r14 = (long) r11     // Catch:{ Exception -> 0x0a72 }
            r56 = r14
            r58 = 0
            r60 = 0
            r62 = 0
            r64 = 1
            r65 = 1
            r66 = 0
            r69 = 0
            r48 = r7
            r48.<init>(r49, r50, r51, r52, r53, r55, r56, r58, r60, r62, r64, r65, r66, r67, r68, r69, r70, r71)     // Catch:{ Exception -> 0x0a72 }
            goto L_0x06f0
        L_0x06e5:
            com.ironsource.mediationsdk.utils.c r7 = new com.ironsource.mediationsdk.utils.c     // Catch:{ Exception -> 0x0a72 }
            r7.<init>()     // Catch:{ Exception -> 0x0a72 }
            goto L_0x06f0
        L_0x06eb:
            com.ironsource.mediationsdk.utils.c r7 = new com.ironsource.mediationsdk.utils.c     // Catch:{ Exception -> 0x0a72 }
            r7.<init>()     // Catch:{ Exception -> 0x0a72 }
        L_0x06f0:
            r46 = r7
            com.ironsource.mediationsdk.model.e r7 = new com.ironsource.mediationsdk.model.e     // Catch:{ Exception -> 0x0a72 }
            r40 = r7
            r44 = r2
            r40.<init>(r41, r42, r44, r45, r46, r47)     // Catch:{ Exception -> 0x0a72 }
            if (r6 == 0) goto L_0x075f
            r2 = 0
        L_0x06fe:
            int r11 = r6.length()     // Catch:{ Exception -> 0x0a72 }
            if (r2 >= r11) goto L_0x075f
            org.json.JSONObject r11 = r6.optJSONObject(r2)     // Catch:{ Exception -> 0x0a72 }
            if (r11 == 0) goto L_0x073b
            java.lang.String r14 = "placementId"
            r15 = -1
            int r14 = r11.optInt(r14, r15)     // Catch:{ Exception -> 0x0a72 }
            java.lang.String r15 = "placementName"
            java.lang.String r15 = r11.optString(r15, r10)     // Catch:{ Exception -> 0x0a72 }
            r23 = r6
            java.lang.String r6 = "isDefault"
            r40 = r13
            r13 = 0
            boolean r6 = r11.optBoolean(r6, r13)     // Catch:{ Exception -> 0x0a72 }
            com.ironsource.mediationsdk.model.k r11 = a((org.json.JSONObject) r11)     // Catch:{ Exception -> 0x0a72 }
            if (r14 < 0) goto L_0x073f
            boolean r13 = android.text.TextUtils.isEmpty(r15)     // Catch:{ Exception -> 0x0a72 }
            if (r13 != 0) goto L_0x073f
            com.ironsource.mediationsdk.model.f r13 = new com.ironsource.mediationsdk.model.f     // Catch:{ Exception -> 0x0a72 }
            r13.<init>(r14, r15, r6, r11)     // Catch:{ Exception -> 0x0a72 }
            if (r11 == 0) goto L_0x0741
            android.content.Context r6 = r1.bw     // Catch:{ Exception -> 0x0a72 }
            com.ironsource.mediationsdk.utils.k.a((android.content.Context) r6, (com.ironsource.mediationsdk.model.f) r13)     // Catch:{ Exception -> 0x0a72 }
            goto L_0x0741
        L_0x073b:
            r23 = r6
            r40 = r13
        L_0x073f:
            r13 = r24
        L_0x0741:
            if (r13 == 0) goto L_0x0758
            if (r13 == 0) goto L_0x0758
            java.util.ArrayList<com.ironsource.mediationsdk.model.f> r6 = r7.c     // Catch:{ Exception -> 0x0a72 }
            r6.add(r13)     // Catch:{ Exception -> 0x0a72 }
            com.ironsource.mediationsdk.model.f r6 = r7.d     // Catch:{ Exception -> 0x0a72 }
            if (r6 != 0) goto L_0x0751
        L_0x074e:
            r7.d = r13     // Catch:{ Exception -> 0x0a72 }
            goto L_0x0758
        L_0x0751:
            int r6 = r13.getPlacementId()     // Catch:{ Exception -> 0x0a72 }
            if (r6 != 0) goto L_0x0758
            goto L_0x074e
        L_0x0758:
            int r2 = r2 + 1
            r6 = r23
            r13 = r40
            goto L_0x06fe
        L_0x075f:
            r40 = r13
            r34 = r7
            goto L_0x0774
        L_0x0764:
            r28 = r2
            r26 = r3
            r40 = r13
            r8 = r27
            r9 = r29
            r4 = r30
            r3 = r39
            r34 = r24
        L_0x0774:
            if (r25 == 0) goto L_0x0896
            r2 = r25
            org.json.JSONObject r6 = b(r2, r5)     // Catch:{ Exception -> 0x0a72 }
            org.json.JSONObject r6 = com.ironsource.mediationsdk.utils.IronSourceUtils.mergeJsons(r6, r4)     // Catch:{ Exception -> 0x0a72 }
            r7 = 0
            boolean r43 = r6.optBoolean(r8, r7)     // Catch:{ Exception -> 0x0a72 }
            boolean r44 = r6.optBoolean(r12, r7)     // Catch:{ Exception -> 0x0a72 }
            java.lang.String r7 = "serverEventsURL"
            java.lang.String r45 = r6.optString(r7, r10)     // Catch:{ Exception -> 0x0a72 }
            java.lang.String r7 = "serverEventsType"
            java.lang.String r46 = r6.optString(r7, r10)     // Catch:{ Exception -> 0x0a72 }
            java.lang.String r7 = "backupThreshold"
            r8 = -1
            int r47 = r6.optInt(r7, r8)     // Catch:{ Exception -> 0x0a72 }
            java.lang.String r7 = "maxNumberOfEvents"
            int r48 = r6.optInt(r7, r8)     // Catch:{ Exception -> 0x0a72 }
            java.lang.String r7 = "maxEventsPerBatch"
            r8 = 5000(0x1388, float:7.006E-42)
            int r49 = r6.optInt(r7, r8)     // Catch:{ Exception -> 0x0a72 }
            org.json.JSONArray r7 = r6.optJSONArray(r9)     // Catch:{ Exception -> 0x0a72 }
            if (r7 == 0) goto L_0x07c9
            int r8 = r7.length()     // Catch:{ Exception -> 0x0a72 }
            int[] r8 = new int[r8]     // Catch:{ Exception -> 0x0a72 }
            r11 = 0
        L_0x07b7:
            int r13 = r7.length()     // Catch:{ Exception -> 0x0a72 }
            if (r11 >= r13) goto L_0x07c6
            int r13 = r7.optInt(r11)     // Catch:{ Exception -> 0x0a72 }
            r8[r11] = r13     // Catch:{ Exception -> 0x0a72 }
            int r11 = r11 + 1
            goto L_0x07b7
        L_0x07c6:
            r50 = r8
            goto L_0x07cb
        L_0x07c9:
            r50 = r24
        L_0x07cb:
            org.json.JSONArray r7 = r6.optJSONArray(r3)     // Catch:{ Exception -> 0x0a72 }
            if (r7 == 0) goto L_0x07ea
            int r8 = r7.length()     // Catch:{ Exception -> 0x0a72 }
            int[] r8 = new int[r8]     // Catch:{ Exception -> 0x0a72 }
            r11 = 0
        L_0x07d8:
            int r13 = r7.length()     // Catch:{ Exception -> 0x0a72 }
            if (r11 >= r13) goto L_0x07e7
            int r13 = r7.optInt(r11)     // Catch:{ Exception -> 0x0a72 }
            r8[r11] = r13     // Catch:{ Exception -> 0x0a72 }
            int r11 = r11 + 1
            goto L_0x07d8
        L_0x07e7:
            r51 = r8
            goto L_0x07ec
        L_0x07ea:
            r51 = r24
        L_0x07ec:
            java.lang.String r7 = "triggerEvents"
            org.json.JSONArray r7 = r6.optJSONArray(r7)     // Catch:{ Exception -> 0x0a72 }
            if (r7 == 0) goto L_0x080d
            int r8 = r7.length()     // Catch:{ Exception -> 0x0a72 }
            int[] r8 = new int[r8]     // Catch:{ Exception -> 0x0a72 }
            r11 = 0
        L_0x07fb:
            int r13 = r7.length()     // Catch:{ Exception -> 0x0a72 }
            if (r11 >= r13) goto L_0x080a
            int r13 = r7.optInt(r11)     // Catch:{ Exception -> 0x0a72 }
            r8[r11] = r13     // Catch:{ Exception -> 0x0a72 }
            int r11 = r11 + 1
            goto L_0x07fb
        L_0x080a:
            r52 = r8
            goto L_0x080f
        L_0x080d:
            r52 = r24
        L_0x080f:
            java.lang.String r7 = "nonConnectivityEvents"
            org.json.JSONArray r6 = r6.optJSONArray(r7)     // Catch:{ Exception -> 0x0a72 }
            if (r6 == 0) goto L_0x0830
            int r7 = r6.length()     // Catch:{ Exception -> 0x0a72 }
            int[] r7 = new int[r7]     // Catch:{ Exception -> 0x0a72 }
            r8 = 0
        L_0x081e:
            int r11 = r6.length()     // Catch:{ Exception -> 0x0a72 }
            if (r8 >= r11) goto L_0x082d
            int r11 = r6.optInt(r8)     // Catch:{ Exception -> 0x0a72 }
            r7[r8] = r11     // Catch:{ Exception -> 0x0a72 }
            int r8 = r8 + 1
            goto L_0x081e
        L_0x082d:
            r53 = r7
            goto L_0x0832
        L_0x0830:
            r53 = r24
        L_0x0832:
            com.ironsource.sdk.g.d r6 = new com.ironsource.sdk.g.d     // Catch:{ Exception -> 0x0a72 }
            r42 = 0
            r41 = r6
            r41.<init>(r42, r43, r44, r45, r46, r47, r48, r49, r50, r51, r52, r53)     // Catch:{ Exception -> 0x0a72 }
            com.ironsource.mediationsdk.model.i r7 = new com.ironsource.mediationsdk.model.i     // Catch:{ Exception -> 0x0a72 }
            r7.<init>(r6)     // Catch:{ Exception -> 0x0a72 }
            r7.d = r2     // Catch:{ Exception -> 0x0a72 }
            r6 = r28
            org.json.JSONArray r2 = r2.optJSONArray(r6)     // Catch:{ Exception -> 0x0a72 }
            if (r2 == 0) goto L_0x0893
            r6 = 0
        L_0x084b:
            int r8 = r2.length()     // Catch:{ Exception -> 0x0a72 }
            if (r6 >= r8) goto L_0x0893
            org.json.JSONObject r8 = r2.optJSONObject(r6)     // Catch:{ Exception -> 0x0a72 }
            if (r8 == 0) goto L_0x0879
            java.lang.String r11 = "placementId"
            r13 = -1
            int r11 = r8.optInt(r11, r13)     // Catch:{ Exception -> 0x0a72 }
            java.lang.String r14 = "placementName"
            java.lang.String r14 = r8.optString(r14, r10)     // Catch:{ Exception -> 0x0a72 }
            java.lang.String r15 = "isDefault"
            r13 = 0
            boolean r8 = r8.optBoolean(r15, r13)     // Catch:{ Exception -> 0x0a72 }
            if (r11 < 0) goto L_0x0879
            boolean r13 = android.text.TextUtils.isEmpty(r14)     // Catch:{ Exception -> 0x0a72 }
            if (r13 != 0) goto L_0x0879
            com.ironsource.mediationsdk.model.j r13 = new com.ironsource.mediationsdk.model.j     // Catch:{ Exception -> 0x0a72 }
            r13.<init>(r11, r14, r8)     // Catch:{ Exception -> 0x0a72 }
            goto L_0x087b
        L_0x0879:
            r13 = r24
        L_0x087b:
            if (r13 == 0) goto L_0x0890
            if (r13 == 0) goto L_0x0890
            java.util.ArrayList<com.ironsource.mediationsdk.model.j> r8 = r7.a     // Catch:{ Exception -> 0x0a72 }
            r8.add(r13)     // Catch:{ Exception -> 0x0a72 }
            com.ironsource.mediationsdk.model.j r8 = r7.b     // Catch:{ Exception -> 0x0a72 }
            if (r8 != 0) goto L_0x088b
        L_0x0888:
            r7.b = r13     // Catch:{ Exception -> 0x0a72 }
            goto L_0x0890
        L_0x088b:
            int r8 = r13.a     // Catch:{ Exception -> 0x0a72 }
            if (r8 != 0) goto L_0x0890
            goto L_0x0888
        L_0x0890:
            int r6 = r6 + 1
            goto L_0x084b
        L_0x0893:
            r33 = r7
            goto L_0x0898
        L_0x0896:
            r33 = r24
        L_0x0898:
            com.ironsource.mediationsdk.utils.p r2 = new com.ironsource.mediationsdk.utils.p     // Catch:{ Exception -> 0x0a72 }
            r2.<init>()     // Catch:{ Exception -> 0x0a72 }
            if (r22 == 0) goto L_0x08de
            java.lang.String r6 = "optInKeys"
            r7 = r22
            org.json.JSONArray r6 = r7.optJSONArray(r6)     // Catch:{ Exception -> 0x0a72 }
            if (r6 == 0) goto L_0x08c2
            r8 = 0
        L_0x08aa:
            int r11 = r6.length()     // Catch:{ Exception -> 0x0a72 }
            if (r8 >= r11) goto L_0x08c2
            java.lang.String r11 = r6.optString(r8)     // Catch:{ Exception -> 0x0a72 }
            boolean r13 = android.text.TextUtils.isEmpty(r11)     // Catch:{ Exception -> 0x0a72 }
            if (r13 != 0) goto L_0x08bf
            java.util.ArrayList<java.lang.String> r13 = r2.a     // Catch:{ Exception -> 0x0a72 }
            r13.add(r11)     // Catch:{ Exception -> 0x0a72 }
        L_0x08bf:
            int r8 = r8 + 1
            goto L_0x08aa
        L_0x08c2:
            java.lang.String r6 = "tokenGenericParams"
            org.json.JSONObject r6 = r7.optJSONObject(r6)     // Catch:{ Exception -> 0x0a72 }
            if (r6 == 0) goto L_0x08cc
            r2.c = r6     // Catch:{ Exception -> 0x0a72 }
        L_0x08cc:
            java.lang.String r6 = "oneToken"
            r8 = 0
            boolean r6 = r7.optBoolean(r6, r8)     // Catch:{ Exception -> 0x0a72 }
            r2.d = r6     // Catch:{ Exception -> 0x0a72 }
            java.lang.String r6 = "compressToken"
            r8 = 1
            boolean r6 = r7.optBoolean(r6, r8)     // Catch:{ Exception -> 0x0a72 }
            r2.e = r6     // Catch:{ Exception -> 0x0a72 }
        L_0x08de:
            com.ironsource.mediationsdk.utils.j r6 = new com.ironsource.mediationsdk.utils.j     // Catch:{ Exception -> 0x0a72 }
            r6.<init>()     // Catch:{ Exception -> 0x0a72 }
            if (r21 == 0) goto L_0x08fe
            java.lang.String r7 = "pixelEventsUrl"
            java.lang.String r8 = "https://outcome-ssp.supersonicads.com/mediation?adUnit=3"
            r11 = r21
            java.lang.String r7 = r11.optString(r7, r8)     // Catch:{ Exception -> 0x0a72 }
            java.lang.String r8 = "pixelEventsEnabled"
            r13 = 1
            boolean r14 = r11.optBoolean(r8, r13)     // Catch:{ Exception -> 0x0a72 }
            java.lang.String r8 = "<set-?>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r8)     // Catch:{ Exception -> 0x0a72 }
            r6.b = r7     // Catch:{ Exception -> 0x0a72 }
            goto L_0x08ff
        L_0x08fe:
            r14 = 1
        L_0x08ff:
            r6.a = r14     // Catch:{ Exception -> 0x0a72 }
            if (r14 == 0) goto L_0x0916
            int[] r7 = a(r4, r9)     // Catch:{ Exception -> 0x0a72 }
            r6.d = r7     // Catch:{ Exception -> 0x0a72 }
            int[] r3 = a(r4, r3)     // Catch:{ Exception -> 0x0a72 }
            r6.e = r3     // Catch:{ Exception -> 0x0a72 }
            r3 = 0
            boolean r7 = r4.optBoolean(r12, r3)     // Catch:{ Exception -> 0x0a72 }
            r6.c = r7     // Catch:{ Exception -> 0x0a72 }
        L_0x0916:
            java.lang.String r3 = "server"
            r7 = r20
            r8 = 3
            int r3 = r7.optInt(r3, r8)     // Catch:{ Exception -> 0x0a72 }
            java.lang.String r9 = "publisher"
            int r9 = r7.optInt(r9, r8)     // Catch:{ Exception -> 0x0a72 }
            java.lang.String r11 = "console"
            int r7 = r7.optInt(r11, r8)     // Catch:{ Exception -> 0x0a72 }
            com.ironsource.mediationsdk.model.d r8 = new com.ironsource.mediationsdk.model.d     // Catch:{ Exception -> 0x0a72 }
            r8.<init>(r3, r9, r7)     // Catch:{ Exception -> 0x0a72 }
            com.ironsource.sdk.controller.u r3 = new com.ironsource.sdk.controller.u     // Catch:{ Exception -> 0x0a72 }
            r3.<init>()     // Catch:{ Exception -> 0x0a72 }
            if (r19 == 0) goto L_0x098d
            java.lang.String r7 = "enabled"
            r9 = r19
            r11 = 0
            boolean r7 = r9.optBoolean(r7, r11)     // Catch:{ Exception -> 0x0a72 }
            r3.a((boolean) r7)     // Catch:{ Exception -> 0x0a72 }
            java.lang.String r7 = "reporterURL"
            java.lang.String r7 = r9.optString(r7, r10)     // Catch:{ Exception -> 0x0a72 }
            r3.b((java.lang.String) r7)     // Catch:{ Exception -> 0x0a72 }
            java.lang.String r7 = "reporterKeyword"
            java.lang.String r7 = r9.optString(r7, r10)     // Catch:{ Exception -> 0x0a72 }
            r3.c((java.lang.String) r7)     // Catch:{ Exception -> 0x0a72 }
            java.lang.String r7 = "includeANR"
            r11 = 0
            boolean r7 = r9.optBoolean(r7, r11)     // Catch:{ Exception -> 0x0a72 }
            r3.b((boolean) r7)     // Catch:{ Exception -> 0x0a72 }
            java.lang.String r7 = "timeout"
            r11 = 5000(0x1388, float:7.006E-42)
            int r7 = r9.optInt(r7, r11)     // Catch:{ Exception -> 0x0a72 }
            r3.a((int) r7)     // Catch:{ Exception -> 0x0a72 }
            java.lang.String r7 = "setIgnoreDebugger"
            r11 = 0
            boolean r7 = r9.optBoolean(r7, r11)     // Catch:{ Exception -> 0x0a72 }
            r3.c((boolean) r7)     // Catch:{ Exception -> 0x0a72 }
            java.lang.String r7 = "keysToInclude"
            org.json.JSONArray r7 = r9.optJSONArray(r7)     // Catch:{ Exception -> 0x0a72 }
            if (r7 == 0) goto L_0x098d
            r9 = 0
        L_0x097d:
            int r11 = r7.length()     // Catch:{ Exception -> 0x0a72 }
            if (r9 >= r11) goto L_0x098d
            java.lang.String r11 = r7.optString(r9)     // Catch:{ Exception -> 0x0a72 }
            r3.a((java.lang.String) r11)     // Catch:{ Exception -> 0x0a72 }
            int r9 = r9 + 1
            goto L_0x097d
        L_0x098d:
            if (r18 == 0) goto L_0x09ad
            java.lang.String r7 = "name"
            r9 = r18
            java.lang.String r7 = r9.optString(r7, r10)     // Catch:{ Exception -> 0x0a72 }
            java.lang.String r10 = "id"
            java.lang.String r11 = "-1"
            java.lang.String r10 = r9.optString(r10, r11)     // Catch:{ Exception -> 0x0a72 }
            java.lang.String r11 = "custom"
            org.json.JSONObject r9 = r9.optJSONObject(r11)     // Catch:{ Exception -> 0x0a72 }
            com.ironsource.mediationsdk.model.p r11 = new com.ironsource.mediationsdk.model.p     // Catch:{ Exception -> 0x0a72 }
            r11.<init>(r7, r10, r9)     // Catch:{ Exception -> 0x0a72 }
            r43 = r11
            goto L_0x09af
        L_0x09ad:
            r43 = r24
        L_0x09af:
            com.ironsource.mediationsdk.utils.b r7 = new com.ironsource.mediationsdk.utils.b     // Catch:{ Exception -> 0x0a72 }
            r7.<init>()     // Catch:{ Exception -> 0x0a72 }
            if (r17 == 0) goto L_0x09d5
            java.lang.String r7 = "isExternalArmEventsEnabled"
            r9 = r17
            r10 = 1
            boolean r7 = r9.optBoolean(r7, r10)     // Catch:{ Exception -> 0x0a72 }
            java.lang.String r11 = "externalArmEventsUrl"
            java.lang.String r12 = "https://outcome-arm-ext-med-ext.sonic-us.supersonicads.com/aemData"
            java.lang.String r11 = r9.optString(r11, r12)     // Catch:{ Exception -> 0x0a72 }
            java.lang.String r12 = "sid"
            boolean r9 = r9.optBoolean(r12, r10)     // Catch:{ Exception -> 0x0a72 }
            com.ironsource.mediationsdk.utils.b r10 = new com.ironsource.mediationsdk.utils.b     // Catch:{ Exception -> 0x0a72 }
            r10.<init>(r7, r11, r9)     // Catch:{ Exception -> 0x0a72 }
            r47 = r10
            goto L_0x09d7
        L_0x09d5:
            r47 = r7
        L_0x09d7:
            com.ironsource.mediationsdk.model.c r7 = new com.ironsource.mediationsdk.model.c     // Catch:{ Exception -> 0x0a72 }
            r7.<init>()     // Catch:{ Exception -> 0x0a72 }
            if (r16 == 0) goto L_0x09fc
            java.lang.String r7 = "mediationTypes"
            r9 = r16
            org.json.JSONObject r7 = r9.optJSONObject(r7)     // Catch:{ Exception -> 0x0a72 }
            java.util.HashMap r10 = new java.util.HashMap     // Catch:{ Exception -> 0x0a72 }
            r10.<init>()     // Catch:{ Exception -> 0x0a72 }
            if (r7 == 0) goto L_0x09f1
            java.util.Map r10 = com.ironsource.mediationsdk.utils.IronSourceUtils.parseJsonToStringMap(r7)     // Catch:{ Exception -> 0x0a72 }
        L_0x09f1:
            java.lang.String r7 = "compressExternalToken"
            r11 = 0
            r9.optBoolean(r7, r11)     // Catch:{ Exception -> 0x0a72 }
            com.ironsource.mediationsdk.model.c r7 = new com.ironsource.mediationsdk.model.c     // Catch:{ Exception -> 0x0a72 }
            r7.<init>(r10)     // Catch:{ Exception -> 0x0a72 }
        L_0x09fc:
            r48 = r7
            com.ironsource.mediationsdk.model.b r7 = new com.ironsource.mediationsdk.model.b     // Catch:{ Exception -> 0x0a72 }
            r7.<init>()     // Catch:{ Exception -> 0x0a72 }
            if (r40 == 0) goto L_0x0a15
            java.lang.String r7 = "auctionData"
            r9 = r40
            java.lang.String r7 = r9.optString(r7)     // Catch:{ Exception -> 0x0a72 }
            com.ironsource.mediationsdk.model.b r9 = new com.ironsource.mediationsdk.model.b     // Catch:{ Exception -> 0x0a72 }
            r9.<init>(r7)     // Catch:{ Exception -> 0x0a72 }
            r50 = r9
            goto L_0x0a17
        L_0x0a15:
            r50 = r7
        L_0x0a17:
            java.lang.String r7 = "integration"
            r9 = r26
            r10 = 0
            boolean r45 = r9.optBoolean(r7, r10)     // Catch:{ Exception -> 0x0a72 }
            com.ironsource.sdk.f.a r7 = new com.ironsource.sdk.f.a     // Catch:{ Exception -> 0x0a72 }
            r41 = r7
            r42 = r8
            r44 = r2
            r46 = r3
            r49 = r6
            r41.<init>(r42, r43, r44, r45, r46, r47, r48, r49, r50)     // Catch:{ Exception -> 0x0a72 }
            com.ironsource.mediationsdk.model.g r2 = new com.ironsource.mediationsdk.model.g     // Catch:{ Exception -> 0x0a72 }
            r30 = r2
            r35 = r7
            r30.<init>(r31, r32, r33, r34, r35)     // Catch:{ Exception -> 0x0a72 }
            r1.c = r2     // Catch:{ Exception -> 0x0a72 }
            java.lang.String r2 = "genericParams"
            org.json.JSONObject r2 = b(r4, r2)     // Catch:{ Exception -> 0x0a72 }
            if (r2 == 0) goto L_0x0a5d
            org.json.JSONObject r3 = b(r2, r5)     // Catch:{ Exception -> 0x0a72 }
            if (r3 == 0) goto L_0x0a5d
            r2.remove(r5)     // Catch:{ Exception -> 0x0a72 }
            java.util.Map r3 = com.ironsource.mediationsdk.utils.IronSourceUtils.parseJsonToStringMap(r3)     // Catch:{ Exception -> 0x0a72 }
            com.ironsource.mediationsdk.a.h r4 = com.ironsource.mediationsdk.a.h.e()     // Catch:{ Exception -> 0x0a72 }
            r4.b((java.util.Map<java.lang.String, java.lang.String>) r3)     // Catch:{ Exception -> 0x0a72 }
            com.ironsource.mediationsdk.a.d r4 = com.ironsource.mediationsdk.a.d.e()     // Catch:{ Exception -> 0x0a72 }
            r4.b((java.util.Map<java.lang.String, java.lang.String>) r3)     // Catch:{ Exception -> 0x0a72 }
        L_0x0a5d:
            if (r2 == 0) goto L_0x0a71
            java.util.Map r2 = com.ironsource.mediationsdk.utils.IronSourceUtils.parseJsonToStringMap(r2)     // Catch:{ Exception -> 0x0a72 }
            com.ironsource.mediationsdk.a.h r3 = com.ironsource.mediationsdk.a.h.e()     // Catch:{ Exception -> 0x0a72 }
            r3.a((java.util.Map<java.lang.String, java.lang.String>) r2)     // Catch:{ Exception -> 0x0a72 }
            com.ironsource.mediationsdk.a.d r3 = com.ironsource.mediationsdk.a.d.e()     // Catch:{ Exception -> 0x0a72 }
            r3.a((java.util.Map<java.lang.String, java.lang.String>) r2)     // Catch:{ Exception -> 0x0a72 }
        L_0x0a71:
            return
        L_0x0a72:
            r0 = move-exception
            r2 = r0
            r2.printStackTrace()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.mediationsdk.utils.l.i():void");
    }

    public final C a() {
        return new C(this.bu, this.bv);
    }

    public final void a(int i2) {
        this.e = i2;
    }

    public final boolean b() {
        return (((((this.d != null) && !this.d.has(CampaignEx.JSON_NATIVE_VIDEO_ERROR)) && this.a != null) && this.b != null) && this.c != null) && f();
    }

    public final String c() {
        try {
            return this.a.b;
        } catch (Exception e2) {
            IronSourceLoggerManager.getLogger().logException(IronSourceLogger.IronSourceTag.INTERNAL, "getRVBackFillProvider", e2);
            return null;
        }
    }

    public final String d() {
        try {
            return this.a.c;
        } catch (Exception e2) {
            IronSourceLoggerManager.getLogger().logException(IronSourceLogger.IronSourceTag.INTERNAL, "getRVPremiumProvider", e2);
            return null;
        }
    }

    public final String toString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("appKey", this.bu);
            jSONObject.put("userId", this.bv);
            jSONObject.put("response", this.d);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject.toString();
    }
}
