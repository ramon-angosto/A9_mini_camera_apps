package com.mbridge.msdk.video.dynview.endcard.moffer;

import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.CampaignUnit;
import com.mbridge.msdk.foundation.same.net.e;
import com.mbridge.msdk.foundation.same.net.h.d;
import com.mbridge.msdk.foundation.same.net.l;
import com.mbridge.msdk.foundation.tools.SameMD5;
import com.mbridge.msdk.foundation.tools.k;
import com.mbridge.msdk.foundation.tools.m;
import com.mbridge.msdk.foundation.tools.u;
import com.mbridge.msdk.foundation.tools.y;
import com.mbridge.msdk.system.NoProGuard;
import com.mbridge.msdk.video.dynview.endcard.a.a;
import com.mbridge.msdk.video.dynview.endcard.adapter.MBMoreOfferAdapter;
import com.mbridge.msdk.video.dynview.endcard.c;
import com.mbridge.msdk.video.dynview.endcard.cloudview.TagCloudView;
import com.mbridge.msdk.video.dynview.f.b;
import com.mbridge.msdk.video.dynview.widget.MBridgeRecycleView;
import com.mbridge.msdk.video.dynview.widget.MBridgeRelativeLayout;
import com.mbridge.msdk.video.module.MBridgeNativeEndCardView;
import java.util.Arrays;
import java.util.List;
import org.json.JSONObject;

public class MOfferModel implements NoProGuard {
    private final String AD_NUM = "ad_num";
    private final String API_VERSION = "api_version";
    private final String APP_ID = "app_id";
    private final String CATEGORY = "category";
    private final String COUNTRY_CODE = "country_code";
    private final String CRT_CID = "crt_cid";
    private final String CRT_RID = "crt_rid";
    private final int DO_ACTION_IMPRESSION = 0;
    private final int DO_ACTION_ONLY_IMPRESSION = 1;
    private final String E = "e";
    private final String EC_ID = "ec_id";
    private final String H5_T = "h5_t";
    private final String H5_TYPE = "h5_type";
    private final String HTTP_REQ = "http_req";
    private final String IMEI = "imei";
    private final String I_FMD5 = "i_fmd5";
    private final String K = CampaignEx.JSON_KEY_AD_K;
    private final String MCC = "mcc";
    private final String MNC = "mnc";
    private final String MOF = "mof";
    private final String MOF_DATA = "mof_data";
    private final String MOF_T = "mof_t";
    private final String MOF_TEST_UID = "mof_testuid";
    private final String MOF_TYPE = "mof_type";
    private final String MOF_UID = "mof_uid";
    private final String MOF_VER = "mof_ver";
    private final String MORE_OFFER_CLICK = "more offer click";
    private final String MORE_OFFER_DEFAULT_APP_ID = "92762";
    private final String MORE_OFFER_DEFAULT_APP_KEY = "936dcbdd57fe235fd7cf61c2e93da3c4";
    private final String MORE_OFFER_DEFAULT_UNIT_ID = "117361";
    private final String MORE_OFFER_LOAD_FAILED = "more offer load failed";
    private final String MORE_OFFER_LOAD_SUCCESS = "more offer load success";
    private final String MORE_OFFER_SHOW = "more offer show";
    private final String MORE_OFFER_SHOW_FAILED = "more offer show fail";
    private final String OFFER_ID = "offer_id";
    private final String OFF_SET = "offset";
    private final String ONLY_IMPRESSION = "only_impression";
    private final String PARENT_UNIT = "parent_unit";
    private final String PING_MODE = "ping_mode";
    private final String RV_TID = "rv_tid";
    private final String R_ID = "r_id";
    private final String SIGN = "sign";
    private final String TNUM = "tnum";
    private final String TP_LGP = "tplgp";
    private final String UC_PARENT_UNIT = "uc_parent_unit";
    private final String UNIT_ID = MBridgeConstans.PROPERTIES_UNIT_ID;
    private final String VALUE_AD_NUM = "20";
    private final String VALUE_API_VERSION = "1.3";
    private final String VALUE_CATEGORY = MBridgeConstans.ENDCARD_URL_TYPE_PL;
    private final String VALUE_COUNTRY_CODE = "CN";
    private final String VALUE_H5_TYPE = "1";
    private final String VALUE_HTTP_REQ = "2";
    private final String VALUE_MOF = "1";
    private final String VALUE_MOF_TYPE = "1";
    private final String VALUE_MOF_VER = "1";
    private final String VALUE_OFF_SET = MBridgeConstans.ENDCARD_URL_TYPE_PL;
    private final String VALUE_ONLY_IMPRESSION = "1";
    private final String VALUE_PING_MODE = "1";
    private final String VALUE_TNUM = "20";
    private final String V_FMD5 = "v_fmd5";
    /* access modifiers changed from: private */
    public List<Integer> cacheImpressionReportList;
    /* access modifiers changed from: private */
    public List<Integer> cacheOnlyImpressionReportList;
    /* access modifiers changed from: private */
    public a exposeMonitor;
    /* access modifiers changed from: private */
    public volatile boolean hasReportMoreOfferLoad = false;
    /* access modifiers changed from: private */
    public volatile boolean hasReportMoreOfferShow = false;
    /* access modifiers changed from: private */
    public com.mbridge.msdk.video.dynview.endcard.adapter.a viewTagsAdapter;

    public void bulidMofferAd(View view, CampaignEx campaignEx, com.mbridge.msdk.video.module.a.a aVar) {
        d dVar = new d();
        buildRequestParams(dVar, campaignEx);
        b bVar = new b(view.getContext());
        final d dVar2 = dVar;
        final CampaignEx campaignEx2 = campaignEx;
        final View view2 = view;
        final com.mbridge.msdk.video.module.a.a aVar2 = aVar;
        AnonymousClass1 r0 = new com.mbridge.msdk.video.dynview.f.a.a() {
            public final void a(List<com.mbridge.msdk.foundation.same.net.c.b> list, CampaignUnit campaignUnit) {
                String str = dVar2.b().get(MBridgeConstans.PROPERTIES_UNIT_ID);
                String str2 = dVar2.b().get("r_id");
                if (campaignUnit != null && campaignUnit.getAds() != null && campaignUnit.getAds().size() >= 5) {
                    if (!MOfferModel.this.hasReportMoreOfferLoad) {
                        com.mbridge.msdk.video.dynview.f.a.a(campaignEx2, com.mbridge.msdk.foundation.controller.a.e().g(), "more offer load success", str, str2);
                        boolean unused = MOfferModel.this.hasReportMoreOfferLoad = true;
                    }
                    MOfferModel.this.createMoreOfferView(view2, campaignUnit, campaignEx2, str, str2, aVar2);
                } else if (!MOfferModel.this.hasReportMoreOfferLoad) {
                    com.mbridge.msdk.video.dynview.f.a.a(campaignEx2, com.mbridge.msdk.foundation.controller.a.e().g(), "more offer load failed errorCode: -999 errorMsg: The campaign quantity less than 5.", str, str2);
                    boolean unused2 = MOfferModel.this.hasReportMoreOfferLoad = true;
                }
            }

            public final void a(int i, String str) {
                String str2 = dVar2.b().get(MBridgeConstans.PROPERTIES_UNIT_ID);
                String str3 = dVar2.b().get("r_id");
                if (!MOfferModel.this.hasReportMoreOfferLoad) {
                    CampaignEx campaignEx = campaignEx2;
                    Context g2 = com.mbridge.msdk.foundation.controller.a.e().g();
                    com.mbridge.msdk.video.dynview.f.a.a(campaignEx, g2, "more offer load failed errorCode:" + i + "errorMsg:" + str, str2, str3);
                    boolean unused = MOfferModel.this.hasReportMoreOfferLoad = true;
                }
            }
        };
        b bVar2 = bVar;
        bVar2.a(1, com.mbridge.msdk.foundation.same.net.g.d.c().f, dVar, (l) new com.mbridge.msdk.foundation.same.net.b(8000, 1), (e) r0);
    }

    private void buildRequestParams(d dVar, CampaignEx campaignEx) {
        d dVar2 = dVar;
        String campaignUnitId = campaignEx.getCampaignUnitId();
        String id = campaignEx.getId();
        String a = y.a(campaignEx.getNoticeUrl(), CampaignEx.JSON_KEY_AD_K);
        String a2 = y.a(campaignEx.getendcard_url(), "mof_testuid");
        if (TextUtils.isEmpty(a2)) {
            a2 = y.a(campaignEx.getendcard_url(), "mof_uid");
        }
        String a3 = y.a(campaignEx.getendcard_url(), "mcc");
        String a4 = y.a(campaignEx.getendcard_url(), "mnc");
        String a5 = y.a(campaignEx.getendcard_url(), "rv_tid");
        String a6 = y.a(campaignEx.getendcard_url(), "ec_id");
        String a7 = y.a(campaignEx.getendcard_url(), "tplgp");
        String str = "v_fmd5";
        String a8 = y.a(campaignEx.getendcard_url(), "v_fmd5");
        String a9 = y.a(campaignEx.getendcard_url(), "i_fmd5");
        String str2 = "i_fmd5";
        com.mbridge.msdk.foundation.same.net.g.b.a(dVar2, "app_id", com.mbridge.msdk.foundation.controller.a.e().h());
        StringBuilder sb = new StringBuilder();
        String str3 = "app_id";
        sb.append(com.mbridge.msdk.foundation.controller.a.e().h());
        sb.append(com.mbridge.msdk.foundation.controller.a.e().i());
        com.mbridge.msdk.foundation.same.net.g.b.a(dVar2, "sign", SameMD5.getMD5(sb.toString()));
        com.mbridge.msdk.foundation.same.net.g.b.a(dVar2, "r_id", a);
        String str4 = "sign";
        com.mbridge.msdk.foundation.same.net.g.b.a(dVar2, "e", Arrays.toString(new String[]{id}));
        com.mbridge.msdk.foundation.same.net.g.b.a(dVar2, "mof_type", "1");
        com.mbridge.msdk.foundation.same.net.g.b.a(dVar2, "h5_type", "1");
        com.mbridge.msdk.foundation.same.net.g.b.a(dVar2, "mof", "1");
        String str5 = "tplgp";
        com.mbridge.msdk.foundation.same.net.g.b.a(dVar2, "country_code", "CN");
        com.mbridge.msdk.foundation.same.net.g.b.a(dVar2, "mof_ver", "1");
        if (TextUtils.isEmpty(a2)) {
            com.mbridge.msdk.foundation.same.net.g.b.a(dVar2, "uc_parent_unit", campaignUnitId);
        } else {
            com.mbridge.msdk.foundation.same.net.g.b.a(dVar2, "parent_unit", campaignUnitId);
        }
        com.mbridge.msdk.foundation.same.net.g.b.a(dVar2, "mnc", a4);
        com.mbridge.msdk.foundation.same.net.g.b.a(dVar2, "mcc", a3);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("crt_cid", id);
            jSONObject.put("crt_rid", a);
            jSONObject.put("rv_tid", a5);
            jSONObject.put("ec_id", a6);
            jSONObject.put(str5, a7);
            jSONObject.put(str, a8);
            jSONObject.put(str2, a9);
            jSONObject.put("h5_t", 1);
            jSONObject.put("mof_t", 1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        com.mbridge.msdk.foundation.same.net.g.b.a(dVar2, "mof_data", com.mbridge.msdk.foundation.tools.l.a(jSONObject.toString().getBytes()));
        com.mbridge.msdk.foundation.same.net.g.b.a(dVar2, "imei", "");
        com.mbridge.msdk.foundation.same.net.g.b.a(dVar2, "offer_id", id);
        com.mbridge.msdk.foundation.same.net.g.b.a(dVar2, "offset", MBridgeConstans.ENDCARD_URL_TYPE_PL);
        com.mbridge.msdk.foundation.same.net.g.b.a(dVar2, "category", MBridgeConstans.ENDCARD_URL_TYPE_PL);
        com.mbridge.msdk.foundation.same.net.g.b.a(dVar2, "only_impression", "1");
        com.mbridge.msdk.foundation.same.net.g.b.a(dVar2, "ping_mode", "1");
        com.mbridge.msdk.foundation.same.net.g.b.a(dVar2, "http_req", "2");
        com.mbridge.msdk.foundation.same.net.g.b.a(dVar2, "ad_num", "20");
        com.mbridge.msdk.foundation.same.net.g.b.a(dVar2, "tnum", "20");
        com.mbridge.msdk.foundation.same.net.g.b.a(dVar2, "api_version", "1.3");
        if (TextUtils.isEmpty(a2)) {
            com.mbridge.msdk.foundation.same.net.g.b.a(dVar2, str3, "92762");
            com.mbridge.msdk.foundation.same.net.g.b.a(dVar2, str4, SameMD5.getMD5("92762936dcbdd57fe235fd7cf61c2e93da3c4"));
            a2 = "117361";
        }
        com.mbridge.msdk.foundation.same.net.g.b.a(dVar2, MBridgeConstans.PROPERTIES_UNIT_ID, a2);
    }

    /* access modifiers changed from: private */
    public void createMoreOfferView(View view, CampaignUnit campaignUnit, CampaignEx campaignEx, String str, String str2, com.mbridge.msdk.video.module.a.a aVar) {
        Context context;
        View view2 = view;
        if (campaignUnit != null && view2 != null && campaignUnit.getAds() != null && campaignUnit.getAds().size() > 0 && (context = view.getContext()) != null) {
            MBridgeRelativeLayout mBridgeRelativeLayout = (MBridgeRelativeLayout) view.findViewById(findID("mbridge_reward_end_card_more_offer_rl"));
            if (mBridgeRelativeLayout != null) {
                final CampaignEx campaignEx2 = campaignEx;
                final View view3 = view;
                final String str3 = str;
                final String str4 = str2;
                final CampaignUnit campaignUnit2 = campaignUnit;
                mBridgeRelativeLayout.setMoreOfferCacheReportCallBack(new com.mbridge.msdk.video.dynview.endcard.a() {
                    public final void a() {
                        if (MOfferModel.this.cacheImpressionReportList != null) {
                            for (int i = 0; i < MOfferModel.this.cacheImpressionReportList.size(); i++) {
                                if (!MOfferModel.this.hasReportMoreOfferShow) {
                                    com.mbridge.msdk.video.dynview.f.a.a(campaignEx2, view3.getContext(), "more offer show", str3, str4);
                                    boolean unused = MOfferModel.this.hasReportMoreOfferShow = true;
                                }
                                com.mbridge.msdk.video.dynview.f.a.a(campaignUnit2, ((Integer) MOfferModel.this.cacheImpressionReportList.get(i)).intValue(), 0, "117361");
                            }
                        }
                        if (MOfferModel.this.cacheOnlyImpressionReportList != null) {
                            for (int i2 = 0; i2 < MOfferModel.this.cacheOnlyImpressionReportList.size(); i2++) {
                                com.mbridge.msdk.video.dynview.f.a.a(campaignUnit2, ((Integer) MOfferModel.this.cacheOnlyImpressionReportList.get(i2)).intValue(), 1, "117361");
                            }
                        }
                        MOfferModel.this.release();
                    }
                });
                final MBridgeRelativeLayout mBridgeRelativeLayout2 = mBridgeRelativeLayout;
                final CampaignEx campaignEx3 = campaignEx;
                final View view4 = view;
                final String str5 = str;
                final String str6 = str2;
                mBridgeRelativeLayout.setMoreOfferShowFailedCallBack(new c() {
                    public final void a() {
                        MBridgeRelativeLayout mBridgeRelativeLayout = mBridgeRelativeLayout2;
                        if (!(mBridgeRelativeLayout == null || mBridgeRelativeLayout.getVisibility() == 0)) {
                            com.mbridge.msdk.video.dynview.f.a.a(campaignEx3, view4.getContext(), "more offer show fail", str5, str6);
                        }
                        MOfferModel.this.release();
                        if (MOfferModel.this.exposeMonitor != null) {
                            MOfferModel.this.exposeMonitor.a();
                        }
                    }
                });
            }
            MBridgeRecycleView mBridgeRecycleView = (MBridgeRecycleView) view.findViewById(findID("mbridge_reward_end_card_list_rlv"));
            if (mBridgeRecycleView != null) {
                buildAdapter(context, view, mBridgeRecycleView, mBridgeRelativeLayout, campaignEx, campaignUnit, str, str2, aVar);
                addLikeTextView(view, mBridgeRecycleView);
            }
        }
    }

    private void buildAdapter(Context context, View view, MBridgeRecycleView mBridgeRecycleView, MBridgeRelativeLayout mBridgeRelativeLayout, CampaignEx campaignEx, CampaignUnit campaignUnit, String str, String str2, com.mbridge.msdk.video.module.a.a aVar) {
        Context context2 = context;
        View view2 = view;
        MBridgeRecycleView mBridgeRecycleView2 = mBridgeRecycleView;
        if (campaignEx == null || !campaignEx.getCanStartMoreOfferAnim()) {
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
            linearLayoutManager.setOrientation(0);
            mBridgeRecycleView2.setLayoutManager(linearLayoutManager);
        } else {
            com.mbridge.msdk.video.dynview.e.a aVar2 = new com.mbridge.msdk.video.dynview.e.a(context);
            aVar2.setOrientation(0);
            aVar2.a(campaignEx.getCanStartMoreOfferAnim());
            mBridgeRecycleView2.setLayoutManager(aVar2);
            mBridgeRecycleView2.a((LinearLayoutManager) aVar2);
        }
        this.exposeMonitor = new a();
        final MBridgeRelativeLayout mBridgeRelativeLayout2 = mBridgeRelativeLayout;
        final CampaignEx campaignEx2 = campaignEx;
        final String str3 = str;
        final String str4 = str2;
        final CampaignUnit campaignUnit2 = campaignUnit;
        this.exposeMonitor.a(mBridgeRecycleView2, new com.mbridge.msdk.video.dynview.endcard.a.b() {
        });
        MBMoreOfferAdapter mBMoreOfferAdapter = new MBMoreOfferAdapter();
        final View view3 = view;
        final CampaignEx campaignEx3 = campaignEx;
        final MBridgeRecycleView mBridgeRecycleView3 = mBridgeRecycleView;
        final String str5 = str;
        final String str6 = str2;
        mBMoreOfferAdapter.setMoreOfferShowCallBack(new com.mbridge.msdk.video.dynview.endcard.b() {
            public final void a(List<View> list) {
                if (mBridgeRelativeLayout2 != null) {
                    new com.mbridge.msdk.video.dynview.h.b().a((RelativeLayout) view3.findViewById(MOfferModel.this.findID("mbridge_native_ec_layout")), 0, u.b(com.mbridge.msdk.foundation.controller.a.e().g(), 100.0f), 500);
                }
                new com.mbridge.msdk.video.dynview.h.b().a(mBridgeRelativeLayout2, 0, u.h(com.mbridge.msdk.foundation.controller.a.e().g()), 0, u.b(com.mbridge.msdk.foundation.controller.a.e().g(), 90.0f), 0);
                CampaignEx campaignEx = campaignEx3;
                if (campaignEx == null || !campaignEx.getCanStartMoreOfferAnim() || Build.VERSION.SDK_INT < 26) {
                    ((TextView) view3.findViewById(MOfferModel.this.findID("mbridge_reward_end_card_like_tv"))).setVisibility(0);
                    return;
                }
                TagCloudView tagCloudView = (TagCloudView) view3.findViewById(MOfferModel.this.findID("mbridge_cloud_view"));
                if (tagCloudView != null) {
                    tagCloudView.setAdapter(MOfferModel.this.viewTagsAdapter);
                    tagCloudView.setScrollSpeed(1.5f);
                    tagCloudView.setOnClickListener(new View.OnClickListener() {
                        public final void onClick(View view) {
                            new com.mbridge.msdk.video.dynview.h.b().a((View) mBridgeRecycleView3, 500);
                        }
                    });
                    new com.mbridge.msdk.video.dynview.h.b().c((View) tagCloudView, 500);
                }
            }

            public final void a(String str) {
                CampaignEx campaignEx = campaignEx3;
                Context g2 = com.mbridge.msdk.foundation.controller.a.e().g();
                com.mbridge.msdk.video.dynview.f.a.a(campaignEx, g2, "More Offer show fail : " + str, str5, str6);
            }
        });
        mBMoreOfferAdapter.setMoreOfferData(campaignUnit.getAds());
        if (campaignEx != null) {
            mBMoreOfferAdapter.setRewardEndCardurl(campaignEx.getendcard_url());
        }
        mBridgeRecycleView2.setAdapter(mBMoreOfferAdapter);
        final CampaignUnit campaignUnit3 = campaignUnit;
        final com.mbridge.msdk.video.module.a.a aVar3 = aVar;
        final CampaignEx campaignEx4 = campaignEx;
        final String str7 = str;
        final String str8 = str2;
        mBMoreOfferAdapter.setOnItemClickListener(new MBMoreOfferAdapter.a() {
            public final void a(int i) {
                CampaignEx campaignEx;
                CampaignUnit campaignUnit = campaignUnit3;
                if (campaignUnit != null && campaignUnit.ads != null && campaignUnit3.ads.size() > 0 && (campaignEx = campaignUnit3.ads.get(i)) != null) {
                    com.mbridge.msdk.video.module.a.a aVar = aVar3;
                    if (aVar != null) {
                        MOfferModel.this.callBackClick(aVar);
                    }
                    com.mbridge.msdk.video.dynview.f.a.a(campaignEx4, com.mbridge.msdk.foundation.controller.a.e().g(), "more offer click", str7, str8);
                    com.mbridge.msdk.video.dynview.f.a.a(com.mbridge.msdk.foundation.controller.a.e().g(), campaignEx, str7);
                }
            }
        });
        if (campaignEx == null || !campaignEx.getCanStartMoreOfferAnim()) {
            mBridgeRecycleView2.a(false);
        } else {
            mBridgeRecycleView2.a(true);
            mBridgeRecycleView.a();
        }
        this.viewTagsAdapter = new com.mbridge.msdk.video.dynview.endcard.adapter.a();
        this.viewTagsAdapter.a((List<CampaignEx>) campaignUnit.getAds());
        try {
            if (view2 instanceof MBridgeNativeEndCardView) {
                ((MBridgeNativeEndCardView) view2).setMoreOfferCampaignUnit(campaignUnit);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void addLikeTextView(View view, final RecyclerView recyclerView) {
        TextView textView = (TextView) view.findViewById(findID("mbridge_reward_end_card_like_tv"));
        if (textView != null) {
            textView.setTextColor(Color.parseColor("#FF000000"));
            textView.setTextSize(10.0f);
            if (m.c(com.mbridge.msdk.foundation.controller.a.e().g()).contains("zh")) {
                textView.setEms(1);
                textView.getLayoutParams().width = u.b(com.mbridge.msdk.foundation.controller.a.e().g(), 30.0f);
                textView.setText("猜你喜欢");
            } else {
                textView.setText("Just\nfor\nYou");
            }
            textView.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    new com.mbridge.msdk.video.dynview.h.b().a((View) recyclerView, 300);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public void callBackClick(com.mbridge.msdk.video.module.a.a aVar) {
        aVar.a(128, "");
    }

    /* access modifiers changed from: private */
    public int findID(String str) {
        return k.a(com.mbridge.msdk.foundation.controller.a.e().g(), str, "id");
    }

    /* access modifiers changed from: private */
    public void release() {
        List<Integer> list = this.cacheImpressionReportList;
        if (list != null) {
            list.clear();
            this.cacheImpressionReportList = null;
        }
        List<Integer> list2 = this.cacheOnlyImpressionReportList;
        if (list2 != null) {
            list2.clear();
            this.cacheOnlyImpressionReportList = null;
        }
    }
}
