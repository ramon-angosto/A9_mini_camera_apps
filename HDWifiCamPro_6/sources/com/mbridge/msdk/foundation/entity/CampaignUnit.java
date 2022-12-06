package com.mbridge.msdk.foundation.entity;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.controller.authoritycontroller.a;
import com.mbridge.msdk.foundation.tools.l;
import com.mbridge.msdk.foundation.tools.m;
import com.mbridge.msdk.foundation.tools.q;
import com.mbridge.msdk.out.Frame;
import com.mbridge.msdk.out.MBConfiguration;
import com.mbridge.msdk.system.NoProGuard;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class CampaignUnit implements NoProGuard, Serializable {
    public static final String JSON_KEY_ADS = "ads";
    public static final String JSON_KEY_AD_HTML = "cam_html";
    public static final String JSON_KEY_AD_TYPE = "ad_type";
    public static final String JSON_KEY_AD_ZIP = "cam_tpl_url";
    public static final String JSON_KEY_BANNER_HTML = "cam_html";
    public static final String JSON_KEY_BANNER_URL = "cam_tpl_url";
    public static final String JSON_KEY_CSP = "csp";
    public static final String JSON_KEY_DO = "do";
    public static final String JSON_KEY_ENCRYPT_PRICE = "encrypt_p";
    public static final String JSON_KEY_END_SCREEN_URL = "end_screen_url";
    public static final String JSON_KEY_FRAME_ADS = "frames";
    public static final String JSON_KEY_HTML_URL = "html_url";
    public static final String JSON_KEY_IA_EXT1 = "ia_all_ext1";
    public static final String JSON_KEY_IA_EXT2 = "ia_all_ext2";
    public static final String JSON_KEY_IA_ICON = "ia_icon";
    public static final String JSON_KEY_IA_ORI = "ia_ori";
    public static final String JSON_KEY_IA_RST = "ia_rst";
    public static final String JSON_KEY_IA_URL = "ia_url";
    public static final String JSON_KEY_JM_DO = "jm_do";
    public static final String JSON_KEY_MOF_TEMPLATE_URL = "mof_template_url";
    public static final String JSON_KEY_MOF_TPLID = "mof_tplid";
    public static final String JSON_KEY_NSCPT = "nscpt";
    public static final String JSON_KEY_ONLY_IMPRESSION_URL = "only_impression_url";
    public static final String JSON_KEY_PARENT_SESSION_ID = "parent_session_id";
    public static final String JSON_KEY_PV_URLS = "pv_urls";
    public static final String JSON_KEY_REPLACE_TMP = "replace_tmp";
    public static final String JSON_KEY_REQ_EXT_DATA = "req_ext_data";
    public static final String JSON_KEY_RKS = "rks";
    public static final String JSON_KEY_SESSION_ID = "a";
    public static final String JSON_KEY_SH = "sh";
    public static final String JSON_KEY_TEMPLATE = "template";
    public static final String JSON_KEY_TOKEN_RULE = "token_r";
    public static final String JSON_KEY_UNIT_SIZE = "unit_size";
    public static final String JSON_KEY_VCN = "vcn";
    public static final String KEY_IRLFA = "irlfa";
    private static final String TAG = CampaignUnit.class.getSimpleName();
    private static final long serialVersionUID = 1;
    private String adHtml;
    private int adType;
    private String adZip;
    public ArrayList<CampaignEx> ads;
    private String bannerHtml;
    private String bannerUrl;
    private StringBuffer cParams = new StringBuffer();
    private String csp;
    private String domain;
    private String encryptPrice = "";
    private HashMap<String, String> epMap;
    private String htmlUrl;
    private String ia_all_ext1;
    private String ia_all_ext2;
    private String ia_icon;
    private int ia_ori;
    private int ia_rst;
    private String ia_url;
    private int jmDo;
    private List<Frame> listFrames;
    private String msg = "";
    private String onlyImpressionUrl;
    private String parentSessionId;
    private String requestId;
    private HashMap<String, String> rks;
    private String sessionId;
    private String sh;
    private int template;
    private int tokenRule;
    private String unitSize;
    private int vcn;

    private Object nullToEmpty(Object obj) {
        return obj == null ? "" : obj;
    }

    public String getMsg() {
        return this.msg;
    }

    public void setMsg(String str) {
        this.msg = str;
    }

    public String getAdZip() {
        return this.adZip;
    }

    public void setAdZip(String str) {
        this.adZip = str;
    }

    public String getAdHtml() {
        return this.adHtml;
    }

    public void setAdHtml(String str) {
        this.adHtml = str;
    }

    public String getBannerUrl() {
        return this.bannerUrl;
    }

    public void setBannerUrl(String str) {
        this.bannerUrl = str;
    }

    public String getBannerHtml() {
        return this.bannerHtml;
    }

    public void setBannerHtml(String str) {
        this.bannerHtml = str;
    }

    public String getIa_icon() {
        return this.ia_icon;
    }

    public void setIa_icon(String str) {
        this.ia_icon = str;
    }

    public int getIa_rst() {
        return this.ia_rst;
    }

    public void setIa_rst(int i) {
        this.ia_rst = i;
    }

    public String getIa_url() {
        return this.ia_url;
    }

    public void setIa_url(String str) {
        this.ia_url = str;
    }

    public int getIa_ori() {
        return this.ia_ori;
    }

    public void setIa_ori(int i) {
        this.ia_ori = i;
    }

    public String getIa_all_ext1() {
        return this.ia_all_ext1;
    }

    public void setIa_all_ext1(String str) {
        this.ia_all_ext1 = str;
    }

    public String getIa_all_ext2() {
        return this.ia_all_ext2;
    }

    public void setIa_all_ext2(String str) {
        this.ia_all_ext2 = str;
    }

    public HashMap<String, String> getRks() {
        return this.rks;
    }

    public void setRks(HashMap<String, String> hashMap) {
        this.rks = hashMap;
    }

    public HashMap<String, String> getEpMap() {
        return this.epMap;
    }

    public void setEpMap(HashMap<String, String> hashMap) {
        this.epMap = hashMap;
    }

    public String getCsp() {
        return this.csp;
    }

    public void setCsp(String str) {
        this.csp = str;
    }

    public String getDomain() {
        return this.domain;
    }

    public void setDomain(String str) {
        this.domain = str;
    }

    public String getEncryptPrice() {
        return this.encryptPrice;
    }

    public void setEncryptPrice(String str) {
        this.encryptPrice = str;
    }

    public int getTokenRule() {
        int i = this.tokenRule;
        if (i == 1) {
            return i;
        }
        return 0;
    }

    public void setTokenRule(int i) {
        this.tokenRule = i;
    }

    public int getVcn() {
        int i = this.vcn;
        if (i > 1) {
            return i;
        }
        return 1;
    }

    public void setVcn(int i) {
        this.vcn = i;
    }

    public String getSh() {
        return this.sh;
    }

    public void setSh(String str) {
        this.sh = str;
    }

    public int getJmDo() {
        return this.jmDo;
    }

    public void setJmDo(int i) {
        this.jmDo = i;
    }

    public List<Frame> getListFrames() {
        return this.listFrames;
    }

    public void setListFrames(List<Frame> list) {
        this.listFrames = list;
    }

    public String getSessionId() {
        return this.sessionId;
    }

    public void setSessionId(String str) {
        this.sessionId = str;
    }

    public String getParentSessionId() {
        return this.parentSessionId;
    }

    public void setParentSessionId(String str) {
        this.parentSessionId = str;
    }

    public int getAdType() {
        return this.adType;
    }

    public void setAdType(int i) {
        this.adType = i;
    }

    public String getUnitSize() {
        return this.unitSize;
    }

    public void setUnitSize(String str) {
        this.unitSize = str;
    }

    public String getHtmlUrl() {
        return this.htmlUrl;
    }

    public void setHtmlUrl(String str) {
        this.htmlUrl = str;
    }

    public String getOnlyImpressionUrl() {
        return this.onlyImpressionUrl;
    }

    public void setOnlyImpressionUrl(String str) {
        this.onlyImpressionUrl = str;
    }

    public ArrayList<CampaignEx> getAds() {
        return this.ads;
    }

    public void setAds(ArrayList<CampaignEx> arrayList) {
        this.ads = arrayList;
    }

    public int getTemplate() {
        return this.template;
    }

    public void setTemplate(int i) {
        this.template = i;
    }

    public String assembCParams() {
        String str;
        String str2;
        StringBuffer stringBuffer = this.cParams;
        if (stringBuffer != null && stringBuffer.length() > 0) {
            return this.cParams.toString();
        }
        try {
            String i = m.i();
            if (a.a().a(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
                str2 = String.valueOf(m.n(com.mbridge.msdk.foundation.controller.a.e().g()));
                str = m.h(com.mbridge.msdk.foundation.controller.a.e().g()) + "x" + m.i(com.mbridge.msdk.foundation.controller.a.e().g());
            } else {
                str2 = "";
                str = str2;
            }
            StringBuffer stringBuffer2 = this.cParams;
            stringBuffer2.append(getAdType());
            stringBuffer2.append("|");
            stringBuffer2.append(nullToEmpty("1"));
            stringBuffer2.append("|");
            stringBuffer2.append(nullToEmpty(Build.VERSION.RELEASE));
            stringBuffer2.append("|");
            stringBuffer2.append(nullToEmpty(MBConfiguration.SDK_VERSION));
            stringBuffer2.append("|");
            stringBuffer2.append(nullToEmpty(m.a()));
            stringBuffer2.append("|");
            stringBuffer2.append(nullToEmpty(str));
            stringBuffer2.append("|");
            stringBuffer2.append(nullToEmpty(Integer.valueOf(m.d(com.mbridge.msdk.foundation.controller.a.e().g()))));
            stringBuffer2.append("|");
            stringBuffer2.append(nullToEmpty(m.c(com.mbridge.msdk.foundation.controller.a.e().g())));
            stringBuffer2.append("|");
            stringBuffer2.append(nullToEmpty(str2));
            stringBuffer2.append("|");
            stringBuffer2.append("|");
            stringBuffer2.append("|");
            stringBuffer2.append("|");
            stringBuffer2.append("|");
            stringBuffer2.append(nullToEmpty(i));
            stringBuffer2.append("|");
            stringBuffer2.append(nullToEmpty(""));
            stringBuffer2.append("|");
            stringBuffer2.append(nullToEmpty(m.c()));
            stringBuffer2.append("|");
            stringBuffer2.append(nullToEmpty(""));
            stringBuffer2.append("|");
            stringBuffer2.append("");
            stringBuffer2.append("|");
            stringBuffer2.append(nullToEmpty(""));
            stringBuffer2.append("|");
            stringBuffer2.append(nullToEmpty(com.mbridge.msdk.foundation.same.a.k + "," + com.mbridge.msdk.foundation.same.a.l));
            stringBuffer2.append("|");
            this.cParams = stringBuffer2;
        } catch (Throwable th) {
            q.a(TAG, th.getMessage(), th);
        }
        return this.cParams.toString();
    }

    public static CampaignUnit parseV5CampaignUnit(JSONObject jSONObject) {
        return parseV5CampaignUnit(jSONObject, "");
    }

    public static CampaignUnit parseV5CampaignUnit(JSONObject jSONObject, String str) {
        return parseCampaignUnit(jSONObject, str);
    }

    public static CampaignUnit parseCampaignUnit(JSONObject jSONObject) {
        return parseCampaignUnit(jSONObject, "");
    }

    public String getRequestId() {
        try {
            if (!TextUtils.isEmpty(this.requestId)) {
                return this.requestId;
            }
            if (TextUtils.isEmpty(this.onlyImpressionUrl)) {
                return "";
            }
            Uri parse = Uri.parse(this.onlyImpressionUrl);
            if (parse != null) {
                this.requestId = parse.getQueryParameter(CampaignEx.JSON_KEY_AD_K);
            }
            return this.requestId;
        } catch (Exception unused) {
            return "";
        }
    }

    private static void getSysIDAndBKUPID(JSONObject jSONObject) {
        try {
            Context g = com.mbridge.msdk.foundation.controller.a.e().g();
            if (jSONObject != null && g != null) {
                String optString = jSONObject.optString("b");
                if (!TextUtils.isEmpty(optString)) {
                    if (!TextUtils.equals(com.mbridge.msdk.foundation.same.a.k, optString)) {
                        com.mbridge.msdk.foundation.same.a.k = optString;
                        com.mbridge.msdk.foundation.a.a.a.a().a("b", com.mbridge.msdk.foundation.same.a.k);
                        SharedPreferences sharedPreferences = g.getSharedPreferences(l.b("H+tU+FeXHM=="), 0);
                        if (sharedPreferences != null) {
                            SharedPreferences.Editor edit = sharedPreferences.edit();
                            edit.putString(l.b("H+tU+bfPhM=="), com.mbridge.msdk.foundation.same.a.k);
                            edit.apply();
                        }
                    }
                }
                String optString2 = jSONObject.optString("c");
                if (!TextUtils.isEmpty(optString2) && !TextUtils.equals(com.mbridge.msdk.foundation.same.a.l, optString2)) {
                    com.mbridge.msdk.foundation.same.a.l = optString2;
                    com.mbridge.msdk.foundation.a.a.a.a().a("c", com.mbridge.msdk.foundation.same.a.l);
                    SharedPreferences sharedPreferences2 = g.getSharedPreferences(l.b("H+tU+FeXHM=="), 0);
                    if (sharedPreferences2 != null) {
                        SharedPreferences.Editor edit2 = sharedPreferences2.edit();
                        edit2.putString(l.b("H+tU+Fz8"), com.mbridge.msdk.foundation.same.a.l);
                        edit2.apply();
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static CampaignUnit parseCampaignUnit(JSONObject jSONObject, String str) {
        String str2;
        String str3;
        ArrayList arrayList;
        CampaignUnit campaignUnit;
        CampaignUnit campaignUnit2;
        String str4;
        String str5;
        CampaignUnit campaignUnit3;
        int i;
        String str6;
        String str7;
        JSONObject jSONObject2 = jSONObject;
        String str8 = JSON_KEY_ADS;
        String str9 = "template";
        String str10 = JSON_KEY_ONLY_IMPRESSION_URL;
        String str11 = JSON_KEY_HTML_URL;
        if (jSONObject2 != null) {
            try {
                CampaignUnit campaignUnit4 = new CampaignUnit();
                try {
                    String optString = jSONObject2.optString(JSON_KEY_RKS);
                    if (!TextUtils.isEmpty(optString)) {
                        JSONObject jSONObject3 = new JSONObject(optString);
                        Iterator<String> keys = jSONObject3.keys();
                        HashMap hashMap = new HashMap();
                        while (keys != null && keys.hasNext()) {
                            String next = keys.next();
                            hashMap.put(next, jSONObject3.optString(next));
                        }
                        campaignUnit4.setRks(hashMap);
                    }
                    String str12 = "";
                    if (!TextUtils.isEmpty(str)) {
                        HashMap hashMap2 = new HashMap();
                        hashMap2.put("encrypt_p", str12);
                        hashMap2.put(KEY_IRLFA, str12);
                        campaignUnit4.setEpMap(hashMap2);
                    }
                    JSONObject optJSONObject = jSONObject2.optJSONObject(JSON_KEY_REQ_EXT_DATA);
                    int optInt = jSONObject2.optInt(JSON_KEY_NSCPT, 1);
                    String optString2 = jSONObject2.optString(JSON_KEY_MOF_TEMPLATE_URL, str12);
                    int optInt2 = jSONObject2.optInt(JSON_KEY_MOF_TPLID, 0);
                    if (optJSONObject != null) {
                        str12 = optJSONObject.toString();
                    }
                    new JSONArray();
                    JSONArray optJSONArray = jSONObject2.optJSONArray("pv_urls");
                    if (optJSONArray == null || optJSONArray.length() <= 0) {
                        str3 = str12;
                        str2 = optString2;
                        arrayList = null;
                    } else {
                        str3 = str12;
                        arrayList = new ArrayList(optJSONArray.length());
                        str2 = optString2;
                        for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                            arrayList.add(optJSONArray.getString(i2));
                        }
                    }
                    com.mbridge.msdk.foundation.db.a.a.a().a(jSONObject2.optJSONObject(JSON_KEY_REPLACE_TMP), true);
                    getSysIDAndBKUPID(jSONObject);
                    campaignUnit4.setSessionId(jSONObject2.optString(JSON_KEY_SESSION_ID));
                    campaignUnit4.setParentSessionId(jSONObject2.optString(JSON_KEY_PARENT_SESSION_ID));
                    campaignUnit4.setAdType(jSONObject2.optInt("ad_type"));
                    campaignUnit4.setUnitSize(jSONObject2.optString(JSON_KEY_UNIT_SIZE));
                    campaignUnit4.setHtmlUrl(jSONObject2.optString(str11));
                    campaignUnit4.setOnlyImpressionUrl(jSONObject2.optString(str10));
                    campaignUnit4.setTemplate(jSONObject2.optInt(str9));
                    campaignUnit4.setJmDo(jSONObject2.optInt(JSON_KEY_JM_DO));
                    campaignUnit4.setIa_icon(jSONObject2.optString("ia_icon"));
                    campaignUnit4.setIa_rst(jSONObject2.optInt("ia_rst"));
                    campaignUnit4.setIa_url(jSONObject2.optString("ia_url"));
                    campaignUnit4.setIa_ori(jSONObject2.optInt("ia_ori"));
                    campaignUnit4.setIa_all_ext1(jSONObject2.optString(JSON_KEY_IA_EXT1));
                    campaignUnit4.setIa_all_ext2(jSONObject2.optString(JSON_KEY_IA_EXT2));
                    campaignUnit4.setVcn(jSONObject2.optInt("vcn"));
                    campaignUnit4.setTokenRule(jSONObject2.optInt("token_r"));
                    campaignUnit4.setEncryptPrice(jSONObject2.optString("encrypt_p"));
                    JSONArray optJSONArray2 = jSONObject2.optJSONArray(str8);
                    JSONArray optJSONArray3 = jSONObject2.optJSONArray(JSON_KEY_FRAME_ADS);
                    String str13 = JSON_KEY_END_SCREEN_URL;
                    if (optJSONArray3 != null) {
                        try {
                            if (optJSONArray3.length() > 0) {
                                ArrayList arrayList2 = new ArrayList();
                                String str14 = "web env is not support";
                                ArrayList arrayList3 = arrayList;
                                int i3 = 0;
                                while (i3 < optJSONArray3.length()) {
                                    JSONObject optJSONObject2 = optJSONArray3.optJSONObject(i3);
                                    int i4 = i3;
                                    JSONArray jSONArray = optJSONObject2.getJSONArray(str8);
                                    String str15 = str8;
                                    ArrayList arrayList4 = new ArrayList();
                                    String str16 = str9;
                                    JSONObject jSONObject4 = optJSONObject2;
                                    int i5 = 0;
                                    while (i5 < jSONArray.length()) {
                                        JSONObject optJSONObject3 = jSONArray.optJSONObject(i5);
                                        String optString3 = jSONObject2.optString(str10);
                                        String optString4 = jSONObject2.optString(str11);
                                        String optString5 = jSONObject2.optString(str13);
                                        String str17 = str13;
                                        JSONObject jSONObject5 = optJSONObject3;
                                        String str18 = str14;
                                        JSONObject jSONObject6 = jSONObject4;
                                        String str19 = optString3;
                                        JSONArray jSONArray2 = optJSONArray3;
                                        String str20 = str3;
                                        String str21 = str11;
                                        String str22 = str2;
                                        String str23 = str10;
                                        int i6 = i4;
                                        ArrayList arrayList5 = arrayList2;
                                        ArrayList arrayList6 = arrayList3;
                                        JSONArray jSONArray3 = jSONArray;
                                        int i7 = optInt;
                                        campaignUnit2 = campaignUnit4;
                                        try {
                                            CampaignEx parseCampaign = CampaignEx.parseCampaign(jSONObject5, str19, optString4, optString5, false, campaignUnit4, str);
                                            if (parseCampaign != null) {
                                                try {
                                                    parseCampaign.setKeyIaUrl(campaignUnit2.getIa_url());
                                                    parseCampaign.setKeyIaOri(campaignUnit2.getIa_ori());
                                                    parseCampaign.setKeyIaRst(campaignUnit2.getIa_rst());
                                                    parseCampaign.setKeyIaIcon(campaignUnit2.getIa_icon());
                                                    parseCampaign.setAdType(jSONObject2.optInt("ad_type"));
                                                    parseCampaign.setIa_ext1(jSONObject2.optString(CampaignEx.KEY_IA_EXT1));
                                                    parseCampaign.setIa_ext2(jSONObject2.optString(CampaignEx.KEY_IA_EXT2));
                                                    parseCampaign.setVcn(campaignUnit2.getVcn());
                                                    parseCampaign.setTokenRule(campaignUnit2.getTokenRule());
                                                    parseCampaign.setEncryptPrice(campaignUnit2.getEncryptPrice());
                                                    parseCampaign.setMof_tplid(optInt2);
                                                    parseCampaign.setMof_template_url(str22);
                                                    i = i7;
                                                    parseCampaign.setNscpt(i);
                                                    parseCampaign.setPv_urls(arrayList6);
                                                    str6 = str20;
                                                    parseCampaign.setReq_ext_data(str6);
                                                    arrayList4.add(parseCampaign);
                                                    campaignUnit = campaignUnit2;
                                                    str7 = str18;
                                                } catch (Exception unused) {
                                                    return campaignUnit2;
                                                }
                                            } else {
                                                str6 = str20;
                                                i = i7;
                                                campaignUnit = campaignUnit2;
                                                str7 = str18;
                                                try {
                                                    campaignUnit.setMsg(str7);
                                                } catch (Exception unused2) {
                                                }
                                            }
                                            i5++;
                                            arrayList2 = arrayList5;
                                            str13 = str17;
                                            jSONObject4 = jSONObject6;
                                            i4 = i6;
                                            JSONArray jSONArray4 = jSONArray3;
                                            arrayList3 = arrayList6;
                                            str10 = str23;
                                            str2 = str22;
                                            str11 = str21;
                                            str3 = str6;
                                            optInt = i;
                                            campaignUnit4 = campaignUnit;
                                            jSONArray = jSONArray4;
                                            JSONArray jSONArray5 = jSONArray2;
                                            str14 = str7;
                                            optJSONArray3 = jSONArray5;
                                        } catch (Exception unused3) {
                                            campaignUnit = campaignUnit2;
                                        }
                                    }
                                    String str24 = str13;
                                    CampaignUnit campaignUnit5 = campaignUnit4;
                                    int i8 = optInt;
                                    String str25 = str3;
                                    String str26 = str11;
                                    String str27 = str14;
                                    JSONArray jSONArray6 = optJSONArray3;
                                    String str28 = str27;
                                    Frame frame = new Frame();
                                    frame.setParentSessionId(jSONObject2.optString(JSON_KEY_PARENT_SESSION_ID));
                                    frame.setSessionId(jSONObject2.optString(JSON_KEY_SESSION_ID));
                                    frame.setCampaigns(arrayList4);
                                    String str29 = str16;
                                    frame.setTemplate(jSONObject4.optInt(str29));
                                    ArrayList arrayList7 = arrayList2;
                                    arrayList7.add(frame);
                                    arrayList2 = arrayList7;
                                    arrayList3 = arrayList3;
                                    str10 = str10;
                                    str8 = str15;
                                    str2 = str2;
                                    str11 = str26;
                                    str3 = str25;
                                    optInt = i8;
                                    campaignUnit4 = campaignUnit5;
                                    i3 = i4 + 1;
                                    str9 = str29;
                                    str13 = str24;
                                    JSONArray jSONArray7 = jSONArray6;
                                    str14 = str28;
                                    optJSONArray3 = jSONArray7;
                                }
                                campaignUnit = campaignUnit4;
                                campaignUnit.setListFrames(arrayList2);
                                return campaignUnit;
                            }
                        } catch (Exception unused4) {
                            campaignUnit = campaignUnit4;
                        }
                    }
                    String str30 = str13;
                    String str31 = "web env is not support";
                    String str32 = str2;
                    String str33 = str10;
                    ArrayList arrayList8 = arrayList;
                    campaignUnit = campaignUnit4;
                    int i9 = optInt;
                    String str34 = str3;
                    String str35 = str11;
                    String str36 = str32;
                    if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                        ArrayList arrayList9 = new ArrayList();
                        int i10 = 0;
                        while (i10 < optJSONArray2.length()) {
                            JSONObject optJSONObject4 = optJSONArray2.optJSONObject(i10);
                            String str37 = str33;
                            String optString6 = jSONObject2.optString(str37);
                            String str38 = str35;
                            campaignUnit2 = campaignUnit;
                            String str39 = str30;
                            String str40 = str31;
                            String optString7 = jSONObject2.optString(str38);
                            JSONArray jSONArray8 = optJSONArray2;
                            String optString8 = jSONObject2.optString(str39);
                            String str41 = str39;
                            CampaignUnit campaignUnit6 = campaignUnit2;
                            String str42 = str34;
                            int i11 = i9;
                            try {
                                CampaignEx parseCampaign2 = CampaignEx.parseCampaign(optJSONObject4, optString6, optString7, optString8, false, campaignUnit6, str);
                                if (parseCampaign2 != null) {
                                    parseCampaign2.setMof_tplid(optInt2);
                                    parseCampaign2.setMof_template_url(str36);
                                    parseCampaign2.setNscpt(i11);
                                    parseCampaign2.setPv_urls(arrayList8);
                                    str4 = str42;
                                    parseCampaign2.setReq_ext_data(str4);
                                    parseCampaign2.setVcn(campaignUnit6.getVcn());
                                    parseCampaign2.setTokenRule(campaignUnit6.getTokenRule());
                                    parseCampaign2.setEncryptPrice(campaignUnit6.getEncryptPrice());
                                    arrayList9.add(parseCampaign2);
                                    campaignUnit3 = campaignUnit6;
                                    str5 = str40;
                                } else {
                                    str4 = str42;
                                    campaignUnit3 = campaignUnit6;
                                    str5 = str40;
                                    try {
                                        campaignUnit3.setMsg(str5);
                                    } catch (Exception unused5) {
                                        return campaignUnit3;
                                    }
                                }
                                i10++;
                                i9 = i11;
                                str33 = str37;
                                str35 = str38;
                                optJSONArray2 = jSONArray8;
                                campaignUnit = campaignUnit3;
                                str34 = str4;
                                str30 = str41;
                                jSONObject2 = jSONObject;
                                str31 = str5;
                            } catch (Exception unused6) {
                                return campaignUnit6;
                            }
                        }
                        CampaignUnit campaignUnit7 = campaignUnit;
                        campaignUnit7.setAds(arrayList9);
                        return campaignUnit7;
                    }
                    return campaignUnit;
                } catch (Exception unused7) {
                    return campaignUnit4;
                }
            } catch (Exception unused8) {
            }
        }
        return null;
    }
}
