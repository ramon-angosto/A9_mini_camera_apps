package com.mbridge.msdk.foundation.entity;

import android.net.Uri;
import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.click.CommonJumpLoader;
import com.mbridge.msdk.foundation.tools.q;
import com.mbridge.msdk.foundation.tools.u;
import com.mbridge.msdk.foundation.tools.x;
import com.mbridge.msdk.system.NoProGuard;
import com.vungle.warren.model.AdvertisementDBAdapter;
import java.io.Serializable;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class CampaignEx extends DomainCampaignEx implements NoProGuard, Serializable {
    public static final int CAMPAIN_NV_T2_VALUE_3 = 3;
    public static final int CAMPAIN_NV_T2_VALUE_4 = 4;
    public static final String CLICKMODE_ON = "5";
    public static final int CLICK_TIMEOUT_INTERVAL_DEFAULT_VALUE = 2;
    public static final int C_UA_DEFAULT_VALUE = 1;
    private static final int DEFAULT_READY_RATE = 100;
    public static final String ENDCARD_URL = "endcard_url";
    public static final int FLAG_DEFAULT_SPARE_OFFER = -1;
    public static final int FLAG_IS_SPARE_OFFER = 1;
    public static final int FLAG_NOT_SPARE_OFFER = 0;
    public static final int IMP_UA_DEFAULT_VALUE = 1;
    public static final String JSON_AD_IMP_KEY = "sec";
    public static final String JSON_AD_IMP_VALUE = "url";
    public static final String JSON_KEY_ADVIMP = "adv_imp";
    public static final String JSON_KEY_AD_AKS = "aks";
    public static final String JSON_KEY_AD_AL = "al";
    public static final String JSON_KEY_AD_HTML = "ad_html";
    public static final String JSON_KEY_AD_K = "k";
    public static final String JSON_KEY_AD_MP = "mp";
    public static final String JSON_KEY_AD_Q = "q";
    public static final String JSON_KEY_AD_R = "r";
    public static final String JSON_KEY_AD_SOURCE_ID = "ad_source_id";
    public static final String JSON_KEY_AD_TMP_IDS = "tmp_ids";
    public static final String JSON_KEY_AD_TRACKING_DROPOUT_TRACK = "dropout_track";
    public static final String JSON_KEY_AD_TRACKING_IMPRESSION_T2 = "impression_t2";
    public static final String JSON_KEY_AD_TRACKING_PLYCMPT_TRACK = "plycmpt_track";
    public static final String JSON_KEY_AD_URL_LIST = "ad_url_list";
    public static final String JSON_KEY_AD_ZIP = "ad_tpl_url";
    public static final String JSON_KEY_APP_SIZE = "app_size";
    public static final String JSON_KEY_BANNER_HTML = "banner_html";
    public static final String JSON_KEY_BANNER_URL = "banner_url";
    public static final String JSON_KEY_BTY = "ctype";
    public static final String JSON_KEY_CAMPAIGN_UNITID = "unitId";
    public static final String JSON_KEY_CLICK_INTERVAL = "c_ct";
    public static final String JSON_KEY_CLICK_MODE = "click_mode";
    public static final String JSON_KEY_CLICK_TIMEOUT_INTERVAL = "c_toi";
    public static final String JSON_KEY_CLICK_URL = "click_url";
    public static final String JSON_KEY_CREATIVE_ID = "creative_id";
    public static final String JSON_KEY_CTA_TEXT = "ctatext";
    public static final String JSON_KEY_C_UA = "c_ua";
    public static final String JSON_KEY_DEEP_LINK_URL = "deep_link";
    public static final String JSON_KEY_DESC = "desc";
    public static final String JSON_KEY_ENCRYPT_PRICE = "encrypt_p";
    public static final String JSON_KEY_ENDCARD_CLICK = "endcard_click_result";
    public static final String JSON_KEY_EXT_DATA = "ext_data";
    public static final String JSON_KEY_FCA = "fca";
    public static final String JSON_KEY_FCB = "fcb";
    public static final String JSON_KEY_FLB = "flb";
    public static final String JSON_KEY_FLB_SKIP_TIME = "flb_skiptime";
    public static final String JSON_KEY_GIF_URL = "gif_url";
    public static final String JSON_KEY_GUIDELINES = "guidelines";
    public static final String JSON_KEY_HASMBTPLMARK = "hasMBTplMark";
    public static final String JSON_KEY_HB = "hb";
    public static final String JSON_KEY_ICON_URL = "icon_url";
    public static final String JSON_KEY_ID = "id";
    public static final String JSON_KEY_IMAGE_SIZE = "image_size";
    public static final String JSON_KEY_IMAGE_URL = "image_url";
    public static final String JSON_KEY_IMPRESSION_URL = "impression_url";
    public static final String JSON_KEY_IMP_UA = "imp_ua";
    public static final String JSON_KEY_JM_PD = "jm_pd";
    public static final String JSON_KEY_LANDING_TYPE = "landing_type";
    public static final String JSON_KEY_LINK_TYPE = "link_type";
    public static final String JSON_KEY_MAITVE = "maitve";
    public static final String JSON_KEY_MAITVESRC = "maitve_src";
    public static final String JSON_KEY_MRAID = "mraid";
    public static final String JSON_KEY_MRAIDFORH5 = "mraid_src";
    public static final String JSON_KEY_NEW_INTERSTITIAL_AD_SPACE_T = "adspace_t";
    public static final String JSON_KEY_NEW_INTERSTITIAL_CBD = "cbd";
    public static final String JSON_KEY_NEW_INTERSTITIAL_VST = "vst";
    public static final String JSON_KEY_NOTICE_URL = "notice_url";
    public static final String JSON_KEY_NUMBER_RATING = "number_rating";
    public static final String JSON_KEY_NV_T2 = "nv_t2";
    public static final String JSON_KEY_OFFER_TYPE = "offer_type";
    public static final String JSON_KEY_PACKAGE_NAME = "package_name";
    public static final String JSON_KEY_PLCT = "plct";
    public static final String JSON_KEY_PLCTB = "plctb";
    public static final String JSON_KEY_PV_URLS = "pv_urls";
    public static final String JSON_KEY_READY_RATE = "ready_rate";
    public static final String JSON_KEY_RETARGET_OFFER = "retarget_offer";
    public static final String JSON_KEY_RETARGET_TYPE = "rtins_type";
    public static final String JSON_KEY_REWARD_AMOUNT = "reward_amount";
    public static final String JSON_KEY_REWARD_NAME = "reward_name";
    public static final String JSON_KEY_REWARD_PLUS = "rw_pl";
    public static final String JSON_KEY_REWARD_TEMPLATE = "rv";
    public static final String JSON_KEY_REWARD_VIDEO_MD5 = "md5_file";
    public static final String JSON_KEY_RS_IGNORE_CHECK_RULE = "rs_ignc_r";
    public static final String JSON_KEY_STAR = "rating";
    public static final String JSON_KEY_ST_IEX = "iex";
    public static final String JSON_KEY_ST_TS = "ts";
    public static final String JSON_KEY_TEMPLATE = "template";
    public static final String JSON_KEY_TIMESTAMP = "timestamp";
    public static final String JSON_KEY_TITLE = "title";
    public static final String JSON_KEY_TOKEN_RULE = "token_r";
    public static final String JSON_KEY_T_IMP = "t_imp";
    public static final String JSON_KEY_USER_ACTIVATION = "user_activation";
    public static final String JSON_KEY_VCN = "vcn";
    public static final String JSON_KEY_VIDEO_CHECK_TYPE = "vck_t";
    public static final String JSON_KEY_VIDEO_COMPLETE_TIME = "view_com_time";
    public static final String JSON_KEY_VIDEO_CTN_TYPE = "vctn_t";
    public static final String JSON_KEY_VIDEO_LENGTHL = "video_length";
    public static final String JSON_KEY_VIDEO_RESOLUTION = "video_resolution";
    public static final String JSON_KEY_VIDEO_SIZE = "video_size";
    public static final String JSON_KEY_VIDEO_URL = "video_url";
    public static final String JSON_KEY_WATCH_MILE = "watch_mile";
    public static final String JSON_KEY_WITHOUT_INSTALL_CHECK = "wtick";
    public static final String JSON_NATIVE_VIDEO_AD_TRACKING = "ad_tracking";
    public static final String JSON_NATIVE_VIDEO_CLICK = "click";
    public static final String JSON_NATIVE_VIDEO_CLOSE = "close";
    public static final String JSON_NATIVE_VIDEO_COMPLETE = "complete";
    public static final String JSON_NATIVE_VIDEO_ENDCARD = "endcard";
    public static final String JSON_NATIVE_VIDEO_ENDCARD_SHOW = "endcard_show";
    public static final String JSON_NATIVE_VIDEO_ERROR = "error";
    public static final String JSON_NATIVE_VIDEO_FIRST_QUARTILE = "first_quartile";
    public static final String JSON_NATIVE_VIDEO_MIDPOINT = "midpoint";
    public static final String JSON_NATIVE_VIDEO_MUTE = "mute";
    public static final String JSON_NATIVE_VIDEO_PAUSE = "pause";
    public static final String JSON_NATIVE_VIDEO_PLAY_PERCENTAGE = "play_percentage";
    public static final String JSON_NATIVE_VIDEO_RESUME = "resume";
    public static final String JSON_NATIVE_VIDEO_START = "start";
    public static final String JSON_NATIVE_VIDEO_THIRD_QUARTILE = "third_quartile";
    public static final String JSON_NATIVE_VIDEO_UNMUTE = "unmute";
    public static final String JSON_NATIVE_VIDEO_VIDEO_CLICK = "video_click";
    public static final String JSON_NATIVE_VIDOE_IMPRESSION = "impression";
    public static final String KEY_ADCHOICE = "adchoice";
    public static final String KEY_AD_TYPE = "ad_type";
    public static final String KEY_IA_CACHE = "ia_cache";
    public static final String KEY_IA_EXT1 = "ia_ext1";
    public static final String KEY_IA_EXT2 = "ia_ext2";
    public static final String KEY_IA_ICON = "ia_icon";
    public static final String KEY_IA_ORI = "ia_ori";
    public static final String KEY_IA_RST = "ia_rst";
    public static final String KEY_IA_URL = "ia_url";
    public static final String KEY_IS_CMPT_ENTRY = "cmpt=1";
    public static final String KEY_IS_DOWNLOAD = "is_download_zip";
    public static final String KEY_OC_TIME = "oc_time";
    public static final String KEY_OC_TYPE = "oc_type";
    public static final String KEY_OMID = "omid";
    public static final String KEY_T_LIST = "t_list";
    public static final int LANDING_TYPE_VALUE_OPEN_BROWSER = 1;
    public static final int LANDING_TYPE_VALUE_OPEN_GP_BY_PACKAGE = 3;
    public static final int LANDING_TYPE_VALUE_OPEN_WEBVIEW = 2;
    public static final int LINK_TYPE_1 = 1;
    public static final int LINK_TYPE_2 = 2;
    public static final int LINK_TYPE_3 = 3;
    public static final int LINK_TYPE_4 = 4;
    public static final int LINK_TYPE_8 = 8;
    public static final int LINK_TYPE_9 = 9;
    public static final int NEW_INTERSTITIAL_DEFAULT_AD_SPACE_T = 1;
    public static final int NEW_INTERSTITIAL_DEFAULT_CBD = -2;
    public static final int NEW_INTERSTITIAL_DEFAULT_VST = -2;
    public static final String PLAYABLE_ADS_WITHOUT_VIDEO = "playable_ads_without_video";
    public static final int PLAYABLE_ADS_WITHOUT_VIDEO_DEFAULT = 1;
    public static final int PLAYABLE_ADS_WITHOUT_VIDEO_ENDCARD = 2;
    public static final int RETAR_GETING_IS = 1;
    public static final int RETAR_GETING_NOT = 2;
    public static final int RTINS_TYPE_DONE = 1;
    public static final int RTINS_TYPE_NOT_DONE = 2;
    public static final String TAG = CampaignEx.class.getSimpleName();
    public static final String VIDEO_END_TYPE = "video_end_type";
    public static final int VIDEO_END_TYPE_BROWSER = 5;
    public static final int VIDEO_END_TYPE_DEFAULT = 2;
    public static final int VIDEO_END_TYPE_FINISH = 1;
    public static final int VIDEO_END_TYPE_NATIVE = 100;
    public static final int VIDEO_END_TYPE_REULSE = 2;
    public static final int VIDEO_END_TYPE_VAST = 3;
    public static final int VIDEO_END_TYPE_WEBVIEW = 4;
    private static final long serialVersionUID = 1;
    private String CMPTEntryUrl;
    private String adHtml = "";
    private int adSpaceT;
    private int adType;
    private String adZip = "";
    private String ad_url_list;
    private a adchoice;
    private String advImp;
    private HashMap<String, String> aks;
    private String al;
    private String bannerHtml = "";
    private String bannerUrl = "";
    private String bidToken = "";
    private int bty;
    private int cUA = 1;
    private long cVersionCode;
    private int cacheLevel;
    private String campaignUnitId;
    private boolean canStart2C1Anim = false;
    private boolean canStartMoreOfferAnim = false;
    private int cbd = -2;
    private int cbt;
    private int clickInterval;
    private int clickTimeOutInterval = 2;
    private String clickURL = "";
    private String click_mode;
    private long creativeId = 0;
    private String deepLinkUrl = "";
    private String encryptPrice = "";
    private String endScreenUrl;
    private int endcard_click_result;
    private String endcard_url;
    private String ext_data;
    private int fca;
    private int fcb;
    private int flb;
    private int flbSkipTime;
    private String gifUrl;
    private String guidelines;
    private boolean hasMBTplMark;
    private boolean hasReportAdTrackPause = false;
    private String htmlUrl;
    private String ia_ext1;
    private String ia_ext2;
    private int iex;
    private String imageSize = "";
    private int impUA = 1;
    private String impressionURL = "";
    private String interactiveCache;
    private int isAddSuccesful;
    private boolean isBidCampaign;
    private boolean isCallBackImpression = false;
    private boolean isCallbacked;
    private int isClick;
    private int isDeleted;
    private int isDownLoadZip;
    private boolean isDynamicView = false;
    private boolean isMraid;
    private boolean isReady = false;
    private boolean isReport;
    private boolean isReportClick;
    private int isTimeoutCheckVideoStatus = -1;
    private int jmPd;
    private CommonJumpLoader.JumpLoaderResult jumpResult;
    private String k;
    private String keyIaIcon;
    private int keyIaOri;
    private int keyIaRst;
    private String keyIaUrl;
    private String label;
    private String landingType;
    private int linkType;
    private int loadTimeoutState = 0;
    private int maitve;
    private String maitve_src;
    private b mediaViewHolder;
    private String mof_template_url;
    private int mof_tplid;
    private String mp;
    private String mraid;
    private i nativeVideoTracking;
    private String nativeVideoTrackingString;
    private String noticeUrl = "";
    private int nscpt = 1;
    private int nvT2 = 6;
    private int oc_time;
    private int oc_type = 0;
    private int offerType;
    private String omid = null;
    private String onlyImpressionURL = "";
    private String pkgSource;
    private String placementId;
    private int playable_ads_without_video = 1;
    private long plct = 0;
    private long plctb = 0;
    private List<String> pv_urls;
    private String q;
    private String r;
    private int readyState = 1;
    private int ready_rate = -1;
    private String req_ext_data;
    private String requestId;
    private String requestIdNotice;
    private int retarget_offer;
    private int rewardAmount;
    private int rewardPlayStatus;
    public RewardPlus rewardPlus;
    private c rewardTemplateMode;
    private String reward_name;
    private ArrayList<Integer> rsIgnoreCheckRule;
    private int rtinsType;
    private int spareOfferFlag = -1;
    private int t_imp;
    private String t_list;
    private int tab = -1;
    private int template;
    private int tokenRule = 0;
    private long ts;
    private boolean userActivation = false;
    private int vcn = 0;
    private int videoCheckType = 2;
    private int videoCompleteTime = 0;
    private int videoCtnType = 1;
    public String videoMD5Value = "";
    private String videoResolution;
    private int videoSize;
    private String videoUrlEncode = "";
    private int video_end_type = 2;
    private int vst = -2;
    private int watchMile;
    private int wtick = 0;

    public static final class b implements Serializable {
        public boolean a = false;
        public boolean b = false;
        public boolean c = false;
        public boolean d = false;
        public boolean e = false;
        public boolean f = false;
        public boolean g = false;
        public boolean h = false;
        public boolean i = false;
        public boolean j = false;
        public boolean k = false;
        public Map<Integer, String> l;
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

    public void setPv_urls(List<String> list) {
        this.pv_urls = list;
    }

    public List<String> getPv_urls() {
        return this.pv_urls;
    }

    public int getReadyState() {
        return this.readyState;
    }

    public int getAdSpaceT() {
        return this.adSpaceT;
    }

    public void setAdSpaceT(int i) {
        this.adSpaceT = i;
    }

    public int getCbd() {
        return this.cbd;
    }

    public void setCbd(int i) {
        this.cbd = i;
    }

    public int getVst() {
        return this.vst;
    }

    public void setVst(int i) {
        this.vst = i;
    }

    public int getVideoCompleteTime() {
        return this.videoCompleteTime;
    }

    public void setVideoCompleteTime(int i) {
        this.videoCompleteTime = i;
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
        if (i > 0) {
            return i;
        }
        return 1;
    }

    public void setVcn(int i) {
        this.vcn = i;
    }

    public boolean isDynamicView() {
        return this.isDynamicView;
    }

    public void setDynamicView(boolean z) {
        this.isDynamicView = z;
    }

    public int getSpareOfferFlag() {
        return this.spareOfferFlag;
    }

    public void setSpareOfferFlag(int i) {
        this.spareOfferFlag = i;
    }

    public long getPlct() {
        return this.plct;
    }

    public void setPlct(long j) {
        this.plct = j;
    }

    public long getPlctb() {
        return this.plctb;
    }

    public void setPlctb(long j) {
        this.plctb = j;
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

    public long getCreativeId() {
        return this.creativeId;
    }

    public void setCreativeId(long j) {
        this.creativeId = j;
    }

    public boolean isHasMBTplMark() {
        return this.hasMBTplMark;
    }

    public void setHasMBTplMark(boolean z) {
        this.hasMBTplMark = z;
    }

    public int getFlb() {
        return this.flb;
    }

    public void setFlb(int i) {
        this.flb = i;
    }

    public int getFlbSkipTime() {
        return this.flbSkipTime;
    }

    public void setFlbSkipTime(int i) {
        this.flbSkipTime = i;
    }

    public a getAdchoice() {
        return this.adchoice;
    }

    public void setAdchoice(a aVar) {
        this.adchoice = aVar;
    }

    public RewardPlus getRewardPlus() {
        return this.rewardPlus;
    }

    public void setRewardPlus(RewardPlus rewardPlus2) {
        this.rewardPlus = rewardPlus2;
    }

    public int getOc_type() {
        return this.oc_type;
    }

    public void setOc_type(int i) {
        this.oc_type = i;
    }

    public int getOc_time() {
        return this.oc_time;
    }

    public void setOc_time(int i) {
        this.oc_time = i;
    }

    public String getT_list() {
        return this.t_list;
    }

    public void setT_list(String str) {
        this.t_list = str;
    }

    public String getInteractiveCache() {
        return this.interactiveCache;
    }

    public void setInteractiveCache(String str) {
        this.interactiveCache = str;
    }

    public int getIsDownLoadZip() {
        return this.isDownLoadZip;
    }

    public void setIsDownLoadZip(int i) {
        this.isDownLoadZip = i;
    }

    public int getAdType() {
        return this.adType;
    }

    public void setAdType(int i) {
        this.adType = i;
    }

    public String getIa_ext1() {
        return this.ia_ext1;
    }

    public void setIa_ext1(String str) {
        this.ia_ext1 = str;
    }

    public String getIa_ext2() {
        return this.ia_ext2;
    }

    public void setIa_ext2(String str) {
        this.ia_ext2 = str;
    }

    public String getKeyIaIcon() {
        return this.keyIaIcon;
    }

    public void setKeyIaIcon(String str) {
        this.keyIaIcon = str;
    }

    public int getKeyIaRst() {
        return this.keyIaRst;
    }

    public void setKeyIaRst(int i) {
        this.keyIaRst = i;
    }

    public String getKeyIaUrl() {
        return this.keyIaUrl;
    }

    public void setKeyIaUrl(String str) {
        this.keyIaUrl = str;
    }

    public int getKeyIaOri() {
        return this.keyIaOri;
    }

    public void setKeyIaOri(int i) {
        this.keyIaOri = i;
    }

    public int getIsAddSuccesful() {
        return this.isAddSuccesful;
    }

    public void setIsAddSuccesful(int i) {
        this.isAddSuccesful = i;
    }

    public int getJmPd() {
        return this.jmPd;
    }

    public int getIsDeleted() {
        return this.isDeleted;
    }

    public void setIsDeleted(int i) {
        this.isDeleted = i;
    }

    public int getIsClick() {
        return this.isClick;
    }

    public void setIsClick(int i) {
        this.isClick = i;
    }

    public void setJmPd(int i) {
        this.jmPd = i;
    }

    public int getNvT2() {
        return this.nvT2;
    }

    public void setNvT2(int i) {
        this.nvT2 = i;
    }

    public String getGifUrl() {
        return this.gifUrl;
    }

    public void setGifUrl(String str) {
        this.gifUrl = str;
    }

    public int getRtinsType() {
        return this.rtinsType;
    }

    public void setRtinsType(int i) {
        this.rtinsType = i;
    }

    public HashMap<String, String> getAks() {
        return this.aks;
    }

    public void setAks(HashMap<String, String> hashMap) {
        this.aks = hashMap;
    }

    public String getK() {
        return this.k;
    }

    public void setK(String str) {
        this.k = str;
    }

    public String getQ() {
        return this.q;
    }

    public void setQ(String str) {
        this.q = str;
    }

    public String getR() {
        return this.r;
    }

    public void setR(String str) {
        this.r = str;
    }

    public String getAl() {
        return this.al;
    }

    public void setAl(String str) {
        this.al = str;
    }

    public String getMp() {
        return this.mp;
    }

    public void setMp(String str) {
        this.mp = str;
    }

    public boolean isBidCampaign() {
        return this.isBidCampaign;
    }

    public void setIsBidCampaign(boolean z) {
        this.isBidCampaign = z;
    }

    public String getBidToken() {
        return this.bidToken;
    }

    public void setBidToken(String str) {
        this.bidToken = str;
    }

    public int getEndcard_click_result() {
        return this.endcard_click_result;
    }

    public void setEndcard_click_result(int i) {
        this.endcard_click_result = i;
    }

    public int getImpUA() {
        return this.impUA;
    }

    public void setImpUA(int i) {
        this.impUA = i;
    }

    public int getcUA() {
        return this.cUA;
    }

    public void setcUA(int i) {
        this.cUA = i;
    }

    public String getVideoMD5Value() {
        return this.videoMD5Value;
    }

    public void setVideoMD5Value(String str) {
        this.videoMD5Value = str;
    }

    public int getVideo_end_type() {
        return this.video_end_type;
    }

    public void setVideo_end_type(int i) {
        this.video_end_type = i;
    }

    public String getMraid() {
        return this.mraid;
    }

    public void setMraid(String str) {
        this.mraid = str;
    }

    public boolean isMraid() {
        return this.isMraid;
    }

    public void setIsMraid(boolean z) {
        this.isMraid = z;
    }

    public String getendcard_url() {
        return this.endcard_url;
    }

    public void setendcard_url(String str) {
        c cVar;
        this.endcard_url = str;
        if (TextUtils.isEmpty(this.mof_template_url) && (((cVar = this.rewardTemplateMode) == null || TextUtils.isEmpty(cVar.e)) && !TextUtils.isEmpty(str) && str.contains(KEY_IS_CMPT_ENTRY))) {
            setCMPTEntryUrl(str);
        }
        setCanStartMoreOfferAnim(u.h(str));
    }

    public int getPlayable_ads_without_video() {
        return this.playable_ads_without_video;
    }

    public void setPlayable_ads_without_video(int i) {
        this.playable_ads_without_video = i;
    }

    public String getCampaignUnitId() {
        return this.campaignUnitId;
    }

    public void setCampaignUnitId(String str) {
        this.campaignUnitId = str;
    }

    public String getNativeVideoTrackingString() {
        return this.nativeVideoTrackingString;
    }

    public void setNativeVideoTrackingString(String str) {
        this.nativeVideoTrackingString = str;
    }

    public i getNativeVideoTracking() {
        return this.nativeVideoTracking;
    }

    public void setNativeVideoTracking(i iVar) {
        this.nativeVideoTracking = iVar;
    }

    public String getAd_url_list() {
        return this.ad_url_list;
    }

    public void setAd_url_list(String str) {
        this.ad_url_list = str;
    }

    public String getLabel() {
        return this.label;
    }

    public void setLabel(String str) {
        this.label = str;
    }

    public String getPkgSource() {
        return this.pkgSource;
    }

    public void setPkgSource(String str) {
        this.pkgSource = str;
    }

    public int getIex() {
        return this.iex;
    }

    public void setIex(int i) {
        this.iex = i;
    }

    public long getTs() {
        return this.ts;
    }

    public void setTs(long j) {
        this.ts = j;
    }

    public b getMediaViewHolder() {
        return this.mediaViewHolder;
    }

    public void setMediaViewHolder(b bVar) {
        this.mediaViewHolder = bVar;
    }

    public c getRewardTemplateMode() {
        return this.rewardTemplateMode;
    }

    public void setRewardTemplateMode(c cVar) {
        this.rewardTemplateMode = cVar;
        if (cVar != null && !TextUtils.isEmpty(cVar.e())) {
            if (TextUtils.isEmpty(this.mof_template_url) && cVar.e().contains(KEY_IS_CMPT_ENTRY)) {
                setCMPTEntryUrl(cVar.e());
            }
            setDynamicView(u.f(cVar.e()));
        }
    }

    public int getRetarget_offer() {
        return this.retarget_offer;
    }

    public void setRetarget_offer(int i) {
        this.retarget_offer = i;
    }

    public int getRewardPlayStatus() {
        return this.rewardPlayStatus;
    }

    public void setRewardPlayStatus(int i) {
        this.rewardPlayStatus = i;
    }

    public String getGuidelines() {
        return this.guidelines;
    }

    public void setGuidelines(String str) {
        this.guidelines = str;
    }

    public int getOfferType() {
        return this.offerType;
    }

    public void setOfferType(int i) {
        this.offerType = i;
    }

    public String getHtmlUrl() {
        return this.htmlUrl;
    }

    public void setHtmlUrl(String str) {
        this.htmlUrl = str;
    }

    public String getEndScreenUrl() {
        return this.endScreenUrl;
    }

    public void setEndScreenUrl(String str) {
        this.endScreenUrl = str;
    }

    public int getRewardAmount() {
        return this.rewardAmount;
    }

    public void setRewardAmount(int i) {
        this.rewardAmount = i;
    }

    public String getRewardName() {
        return this.reward_name;
    }

    public void setRewardName(String str) {
        this.reward_name = str;
    }

    public int getLinkType() {
        return this.linkType;
    }

    public void setLinkType(int i) {
        this.linkType = i;
    }

    public void setAdCall(String str) {
        if (TextUtils.isEmpty(str)) {
            str = this.linkType != 2 ? "learn more" : "install";
        }
        super.setAdCall(str);
    }

    public int getBty() {
        return this.bty;
    }

    public void setBty(int i) {
        this.bty = i;
    }

    public String getAdvImp() {
        return this.advImp;
    }

    public void setAdvImp(String str) {
        this.advImp = str;
    }

    public Map<Integer, String> getAdvImpList() {
        return generateAdImpression(this.advImp);
    }

    public int getTImp() {
        return this.t_imp;
    }

    public void setTImp(int i) {
        this.t_imp = i;
    }

    public String getVideoUrlEncode() {
        return this.videoUrlEncode;
    }

    public void setVideoUrlEncode(String str) {
        this.videoUrlEncode = str;
    }

    public int getVideoSize() {
        return this.videoSize;
    }

    public void setVideoSize(int i) {
        this.videoSize = i;
    }

    public String getVideoResolution() {
        return this.videoResolution;
    }

    public void setVideoResolution(String str) {
        this.videoResolution = str;
    }

    public int getWatchMile() {
        return this.watchMile;
    }

    public void setWatchMile(int i) {
        this.watchMile = i;
    }

    public int getCacheLevel() {
        return this.cacheLevel;
    }

    public void setCacheLevel(int i) {
        this.cacheLevel = i;
    }

    public boolean isCallBackImpression() {
        return this.isCallBackImpression;
    }

    public void setCallBackImpression(boolean z) {
        this.isCallBackImpression = z;
    }

    public void setReport(boolean z) {
        this.isReport = z;
    }

    public boolean isReport() {
        return this.isReport;
    }

    public boolean isReportClick() {
        return this.isReportClick;
    }

    public void setReportClick(boolean z) {
        this.isReportClick = z;
    }

    public int getClickInterval() {
        return this.clickInterval;
    }

    public void setClickInterval(int i) {
        this.clickInterval = i;
    }

    public int getClickTimeOutInterval() {
        return this.clickTimeOutInterval;
    }

    public void setClickTimeOutInterval(int i) {
        this.clickTimeOutInterval = i;
    }

    public String getRequestId() {
        try {
            if (!TextUtils.isEmpty(this.requestId)) {
                return this.requestId;
            }
            if (TextUtils.isEmpty(this.onlyImpressionURL)) {
                return null;
            }
            Uri parse = Uri.parse(this.onlyImpressionURL);
            if (parse != null) {
                this.requestId = parse.getQueryParameter(JSON_KEY_AD_K);
                setRequestId(this.requestId);
            }
            return this.requestId;
        } catch (Exception unused) {
            return null;
        }
    }

    public void setRequestId(String str) {
        this.requestId = str;
    }

    public String getRequestIdNotice() {
        try {
            if (!TextUtils.isEmpty(this.requestIdNotice)) {
                return this.requestIdNotice;
            }
            if (TextUtils.isEmpty(this.noticeUrl)) {
                return "";
            }
            Uri parse = Uri.parse(this.noticeUrl);
            if (parse != null) {
                this.requestIdNotice = parse.getQueryParameter(JSON_KEY_AD_K);
                setRequestIdNotice(this.requestIdNotice);
            }
            return this.requestIdNotice;
        } catch (Exception unused) {
            return "";
        }
    }

    public void setRequestIdNotice(String str) {
        this.requestIdNotice = str;
    }

    public String getClick_mode() {
        return this.click_mode;
    }

    public void setClick_mode(String str) {
        this.click_mode = str;
    }

    public String getLandingType() {
        return this.landingType;
    }

    public void setLandingType(String str) {
        this.landingType = str;
    }

    public int getFca() {
        return this.fca;
    }

    public void setFca(int i) {
        this.fca = i;
    }

    public int getFcb() {
        return this.fcb;
    }

    public void setFcb(int i) {
        this.fcb = i;
    }

    public int getTab() {
        return this.tab;
    }

    public void setTab(int i) {
        this.tab = i;
    }

    public String getClickURL() {
        return this.clickURL;
    }

    public void setClickURL(String str) {
        this.clickURL = str;
    }

    public int getWtick() {
        return this.wtick;
    }

    public void setWtick(int i) {
        this.wtick = i;
    }

    public String getDeepLinkURL() {
        return this.deepLinkUrl;
    }

    public void setDeepLinkUrl(String str) {
        this.deepLinkUrl = str;
    }

    public void setUserActivation(boolean z) {
        this.userActivation = z;
    }

    public boolean getUserActivation() {
        return this.userActivation;
    }

    public String getImpressionURL() {
        return this.impressionURL;
    }

    public void setImpressionURL(String str) {
        this.impressionURL = str;
    }

    public String getNoticeUrl() {
        return this.noticeUrl;
    }

    public void setNoticeUrl(String str) {
        this.noticeUrl = str;
    }

    public String getOnlyImpressionURL() {
        return this.onlyImpressionURL;
    }

    public void setOnlyImpressionURL(String str) {
        this.onlyImpressionURL = str;
    }

    public CommonJumpLoader.JumpLoaderResult getJumpResult() {
        return this.jumpResult;
    }

    public void setJumpResult(CommonJumpLoader.JumpLoaderResult jumpLoaderResult) {
        this.jumpResult = jumpLoaderResult;
    }

    public int getTemplate() {
        return this.template;
    }

    public void setTemplate(int i) {
        this.template = i;
    }

    public String getImageSize() {
        return this.imageSize;
    }

    public void setImageSize(String str) {
        this.imageSize = str;
    }

    public String getHost() {
        if (!TextUtils.isEmpty(getNoticeUrl())) {
            try {
                URL url = new URL(getNoticeUrl());
                return url.getProtocol() + "://" + url.getHost();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return "";
    }

    public static CampaignEx parseSettingCampaign(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        CampaignEx campaignEx = new CampaignEx();
        campaignEx.setId(jSONObject.optString("campaignid"));
        campaignEx.setPackageName(jSONObject.optString("packageName"));
        campaignEx.setAppName(jSONObject.optString(JSON_KEY_TITLE));
        campaignEx.setAdCall(jSONObject.optString("cta"));
        campaignEx.setAppDesc(jSONObject.optString(JSON_KEY_DESC));
        campaignEx.setImpressionURL(jSONObject.optString(JSON_KEY_IMPRESSION_URL));
        campaignEx.setImageUrl(jSONObject.optString(JSON_KEY_IMAGE_URL));
        campaignEx.setPlct(jSONObject.optLong(JSON_KEY_PLCT));
        campaignEx.setPlctb(jSONObject.optLong(JSON_KEY_PLCTB));
        campaignEx.setAdHtml(jSONObject.optString(JSON_KEY_AD_HTML));
        campaignEx.setAdZip(jSONObject.optString(JSON_KEY_AD_ZIP));
        campaignEx.setBannerUrl(jSONObject.optString(JSON_KEY_BANNER_URL));
        campaignEx.setBannerHtml(jSONObject.optString(JSON_KEY_BANNER_HTML));
        campaignEx.setCreativeId((long) jSONObject.optInt(JSON_KEY_CREATIVE_ID));
        campaignEx.setPlacementId(jSONObject.optString(MBridgeConstans.PLACEMENT_ID));
        return campaignEx;
    }

    private static boolean isBreakCampainOrSetItByEndCard(CampaignEx campaignEx, String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (com.mbridge.msdk.foundation.controller.a.e().j() == 2 && "1".equals(Uri.parse(str).getQueryParameter("dpwgl"))) {
            return true;
        }
        campaignEx.setendcard_url(str);
        return false;
    }

    public static CampaignEx parseCampaignWithBackData(JSONObject jSONObject) {
        CampaignEx campaignEx;
        ArrayList arrayList;
        CampaignEx campaignEx2 = null;
        if (jSONObject == null) {
            return null;
        }
        try {
            campaignEx = new CampaignEx();
            try {
                campaignEx.setId(jSONObject.optString("id"));
                campaignEx.setAppName(jSONObject.optString(JSON_KEY_TITLE));
                campaignEx.setAppDesc(jSONObject.optString(JSON_KEY_DESC));
                campaignEx.setPackageName(jSONObject.optString(JSON_KEY_PACKAGE_NAME));
                campaignEx.setRtinsType(jSONObject.optInt(JSON_KEY_RETARGET_TYPE));
                campaignEx.setIconUrl(jSONObject.optString(JSON_KEY_ICON_URL));
                campaignEx.setImageUrl(jSONObject.optString(JSON_KEY_IMAGE_URL));
                campaignEx.setSize(jSONObject.optString(JSON_KEY_APP_SIZE));
                campaignEx.setImageSize(jSONObject.optString(JSON_KEY_IMAGE_SIZE));
                campaignEx.setImpressionURL(jSONObject.optString(JSON_KEY_IMPRESSION_URL));
                campaignEx.setClickURL(jSONObject.optString("click_url"));
                campaignEx.setRewardPlus(RewardPlus.parseByString(jSONObject.optString(JSON_KEY_REWARD_PLUS)));
                campaignEx.setWtick(jSONObject.optInt(JSON_KEY_WITHOUT_INSTALL_CHECK));
                campaignEx.setDeepLinkUrl(jSONObject.optString(JSON_KEY_DEEP_LINK_URL));
                campaignEx.setUserActivation(jSONObject.optBoolean(JSON_KEY_USER_ACTIVATION, false));
                campaignEx.setNoticeUrl(jSONObject.optString(JSON_KEY_NOTICE_URL));
                campaignEx.setTemplate(jSONObject.optInt("template"));
                campaignEx.setType(jSONObject.optInt(JSON_KEY_AD_SOURCE_ID, 1));
                campaignEx.setFca(jSONObject.optInt(JSON_KEY_FCA));
                campaignEx.setFcb(jSONObject.optInt(JSON_KEY_FCB));
                campaignEx.setEndcard_click_result(jSONObject.optInt(JSON_KEY_ENDCARD_CLICK));
                if (!TextUtils.isEmpty(jSONObject.optString(JSON_KEY_STAR))) {
                    campaignEx.setRating(Double.parseDouble(jSONObject.optString(JSON_KEY_STAR, MBridgeConstans.ENDCARD_URL_TYPE_PL)));
                }
                if (!TextUtils.isEmpty(jSONObject.optString(JSON_KEY_NUMBER_RATING))) {
                    campaignEx.setNumberRating(jSONObject.optInt(JSON_KEY_NUMBER_RATING, 333333));
                }
                campaignEx.setClick_mode(jSONObject.optString(JSON_KEY_CLICK_MODE));
                campaignEx.setLandingType(jSONObject.optString(JSON_KEY_LANDING_TYPE));
                campaignEx.setLinkType(jSONObject.optInt(JSON_KEY_LINK_TYPE, 4));
                campaignEx.setClickInterval(jSONObject.optInt(JSON_KEY_CLICK_INTERVAL));
                campaignEx.setAdCall(jSONObject.optString(JSON_KEY_CTA_TEXT));
                campaignEx.setAd_url_list(jSONObject.optString(JSON_KEY_AD_URL_LIST));
                campaignEx.setRetarget_offer(jSONObject.optInt(JSON_KEY_RETARGET_OFFER, 2));
                campaignEx.setVideoUrlEncode(jSONObject.optString("video_url"));
                campaignEx.setVideoLength(jSONObject.optInt(JSON_KEY_VIDEO_LENGTHL));
                campaignEx.setVideoSize(jSONObject.optInt(JSON_KEY_VIDEO_SIZE));
                campaignEx.setVideoResolution(jSONObject.optString(JSON_KEY_VIDEO_RESOLUTION));
                campaignEx.setWatchMile(jSONObject.optInt(JSON_KEY_WATCH_MILE));
                campaignEx.setTimestamp(System.currentTimeMillis());
                campaignEx.setBty(jSONObject.optInt(JSON_KEY_BTY));
                campaignEx.setAdvImp(jSONObject.optString(JSON_KEY_ADVIMP));
                campaignEx.setTImp(jSONObject.optInt(JSON_KEY_T_IMP));
                campaignEx.setHtmlUrl(jSONObject.optString(CampaignUnit.JSON_KEY_HTML_URL));
                campaignEx.setEndScreenUrl(jSONObject.optString(CampaignUnit.JSON_KEY_END_SCREEN_URL));
                campaignEx.setGuidelines(jSONObject.optString(JSON_KEY_GUIDELINES));
                campaignEx.setOfferType(jSONObject.optInt(JSON_KEY_OFFER_TYPE));
                campaignEx.setRewardName(jSONObject.optString(JSON_KEY_REWARD_NAME));
                campaignEx.setRewardAmount(jSONObject.optInt(JSON_KEY_REWARD_AMOUNT));
                try {
                    if (jSONObject.has(JSON_NATIVE_VIDEO_AD_TRACKING)) {
                        String optString = jSONObject.optString(JSON_NATIVE_VIDEO_AD_TRACKING);
                        if (!TextUtils.isEmpty(optString)) {
                            campaignEx.setNativeVideoTrackingString(optString);
                            campaignEx.setNativeVideoTracking(TrackingStr2Object(optString));
                        }
                    }
                } catch (Exception unused) {
                }
                try {
                    campaignEx.setReady_rate(jSONObject.optInt(JSON_KEY_READY_RATE, -1));
                    JSONObject optJSONObject = jSONObject.optJSONObject(JSON_KEY_EXT_DATA);
                    if (optJSONObject != null) {
                        campaignEx.setExt_data(optJSONObject.toString());
                    }
                    campaignEx.setMof_tplid(jSONObject.optInt(CampaignUnit.JSON_KEY_MOF_TPLID));
                    campaignEx.setMof_template_url(jSONObject.optString(CampaignUnit.JSON_KEY_MOF_TEMPLATE_URL));
                    campaignEx.setNscpt(jSONObject.optInt(CampaignUnit.JSON_KEY_NSCPT));
                    new JSONArray();
                    JSONArray optJSONArray = jSONObject.optJSONArray("pv_urls");
                    if (optJSONArray == null || optJSONArray.length() <= 0) {
                        arrayList = null;
                    } else {
                        arrayList = new ArrayList(optJSONArray.length());
                        for (int i = 0; i < optJSONArray.length(); i++) {
                            arrayList.add(optJSONArray.optString(i));
                        }
                    }
                    campaignEx.setPv_urls(arrayList);
                    JSONObject optJSONObject2 = jSONObject.optJSONObject(CampaignUnit.JSON_KEY_REQ_EXT_DATA);
                    if (optJSONObject2 != null) {
                        campaignEx.setReq_ext_data(optJSONObject2.toString());
                    }
                } catch (Exception unused2) {
                }
                campaignEx.setVideo_end_type(jSONObject.optInt(VIDEO_END_TYPE, 2));
                if (isBreakCampainOrSetItByEndCard(campaignEx, jSONObject.optString(ENDCARD_URL))) {
                    return null;
                }
                campaignEx.setPlayable_ads_without_video(jSONObject.optInt(PLAYABLE_ADS_WITHOUT_VIDEO, 1));
                if (jSONObject.has(JSON_KEY_REWARD_VIDEO_MD5)) {
                    campaignEx.setVideoMD5Value(jSONObject.optString(JSON_KEY_REWARD_VIDEO_MD5));
                }
                if (jSONObject.has(JSON_KEY_NV_T2)) {
                    campaignEx.setNvT2(jSONObject.optInt(JSON_KEY_NV_T2));
                }
                if (jSONObject.has(JSON_KEY_GIF_URL)) {
                    campaignEx.setGifUrl(jSONObject.optString(JSON_KEY_GIF_URL));
                }
                campaignEx.setRewardTemplateMode(c.a(jSONObject.optJSONObject(JSON_KEY_REWARD_TEMPLATE)));
                campaignEx.setClickTimeOutInterval(jSONObject.optInt(JSON_KEY_CLICK_TIMEOUT_INTERVAL, 2));
                campaignEx.setImpUA(jSONObject.optInt(JSON_KEY_IMP_UA, 1));
                campaignEx.setcUA(jSONObject.optInt(JSON_KEY_C_UA, 1));
                campaignEx.setJmPd(jSONObject.optInt(JSON_KEY_JM_PD));
                campaignEx.setKeyIaIcon(jSONObject.optString("ia_icon"));
                campaignEx.setKeyIaRst(jSONObject.optInt("ia_rst"));
                campaignEx.setKeyIaUrl(jSONObject.optString("ia_url"));
                campaignEx.setKeyIaOri(jSONObject.optInt("ia_ori"));
                campaignEx.setAdType(jSONObject.optInt("ad_type"));
                campaignEx.setIa_ext1(jSONObject.optString(KEY_IA_EXT1));
                campaignEx.setIa_ext2(jSONObject.optString(KEY_IA_EXT2));
                campaignEx.setIsDownLoadZip(jSONObject.optInt(KEY_IS_DOWNLOAD));
                campaignEx.setInteractiveCache(jSONObject.optString(KEY_IA_CACHE));
                campaignEx.setOc_time(jSONObject.optInt(KEY_OC_TIME));
                campaignEx.setOc_type(jSONObject.optInt(KEY_OC_TYPE));
                campaignEx.setT_list(jSONObject.optString(KEY_T_LIST));
                campaignEx.setAdchoice(a.a(jSONObject.optString(KEY_ADCHOICE, "")));
                campaignEx.setPlct(jSONObject.optLong(JSON_KEY_PLCT));
                campaignEx.setPlctb(jSONObject.optLong(JSON_KEY_PLCTB));
                JSONArray optJSONArray2 = jSONObject.optJSONArray(KEY_OMID);
                if (optJSONArray2 != null) {
                    campaignEx.setOmid(optJSONArray2.toString());
                } else if (!TextUtils.isEmpty(jSONObject.optString(KEY_OMID))) {
                    campaignEx.setOmid(jSONObject.optString(KEY_OMID));
                } else {
                    campaignEx.setOmid((String) null);
                }
                campaignEx.setCreativeId((long) jSONObject.optInt(JSON_KEY_CREATIVE_ID));
                String optString2 = jSONObject.optString("cam_tpl_url");
                Uri parse = Uri.parse(optString2);
                if (TextUtils.isEmpty(parse.getPath()) || (!parse.getPath().endsWith(".zip") && !parse.getPath().endsWith(".ZIP"))) {
                    campaignEx.setBannerUrl(optString2);
                } else {
                    campaignEx.setAdZip(optString2);
                }
                campaignEx.setBannerHtml(jSONObject.optString("cam_html"));
                campaignEx.setAdHtml(jSONObject.optString("cam_html"));
                campaignEx.setCampaignUnitId(jSONObject.optString(JSON_KEY_CAMPAIGN_UNITID));
                String optString3 = jSONObject.optString(JSON_KEY_MRAID);
                if (TextUtils.isEmpty(optString3)) {
                    optString3 = jSONObject.optString(JSON_KEY_MRAIDFORH5);
                }
                if (!TextUtils.isEmpty(optString3)) {
                    campaignEx.setIsMraid(true);
                    campaignEx.setMraid(optString3);
                } else if (TextUtils.isEmpty(campaignEx.getAdHtml()) || campaignEx.getAdHtml().contains("<MBTPLMARK>")) {
                    campaignEx.setIsMraid(false);
                } else {
                    campaignEx.setIsMraid(true);
                }
                try {
                    String optString4 = jSONObject.optString(CampaignUnit.JSON_KEY_ONLY_IMPRESSION_URL);
                    if (!TextUtils.isEmpty(optString4)) {
                        campaignEx.setOnlyImpressionURL(optString4);
                        Uri parse2 = Uri.parse(optString4);
                        if (parse2 != null) {
                            campaignEx.setRequestId(parse2.getQueryParameter(JSON_KEY_AD_K));
                        }
                    }
                    String optString5 = jSONObject.optString(JSON_KEY_NOTICE_URL);
                    if (!TextUtils.isEmpty(optString5)) {
                        campaignEx.setNoticeUrl(optString5);
                        Uri parse3 = Uri.parse(optString5);
                        if (parse3 != null) {
                            campaignEx.setRequestIdNotice(parse3.getQueryParameter(JSON_KEY_AD_K));
                        }
                    }
                } catch (Exception unused3) {
                }
                campaignEx.setIsBidCampaign(jSONObject.optBoolean(JSON_KEY_HB, false));
                campaignEx.setPlacementId(jSONObject.optString(MBridgeConstans.PLACEMENT_ID));
                campaignEx.setMaitve(jSONObject.optInt(JSON_KEY_MAITVE));
                campaignEx.setMaitve_src(jSONObject.optString(JSON_KEY_MAITVESRC));
                campaignEx.setFlb(jSONObject.optInt(JSON_KEY_FLB));
                campaignEx.setFlbSkipTime(jSONObject.optInt(JSON_KEY_FLB_SKIP_TIME));
                campaignEx.setCbd(jSONObject.optInt(JSON_KEY_NEW_INTERSTITIAL_CBD, -2));
                campaignEx.setVst(jSONObject.optInt(JSON_KEY_NEW_INTERSTITIAL_VST, -2));
                campaignEx.setAdSpaceT(jSONObject.optInt(JSON_KEY_NEW_INTERSTITIAL_AD_SPACE_T, 1));
                campaignEx2 = parseCampaignWithBackData(jSONObject, campaignEx);
                campaignEx2.setVcn(jSONObject.optInt("vcn"));
                campaignEx2.setTokenRule(jSONObject.optInt("token_r"));
                campaignEx2.setEncryptPrice(jSONObject.optString("encrypt_p"));
                campaignEx2.setVideoCompleteTime(jSONObject.optInt(JSON_KEY_VIDEO_COMPLETE_TIME));
                campaignEx2.setVideoCheckType(jSONObject.optInt(JSON_KEY_VIDEO_CHECK_TYPE, 2));
                campaignEx2.setVideoCtnType(jSONObject.optInt(JSON_KEY_VIDEO_CTN_TYPE, 1));
                JSONArray optJSONArray3 = jSONObject.optJSONArray(JSON_KEY_RS_IGNORE_CHECK_RULE);
                if (optJSONArray3 != null && optJSONArray3.length() > 0) {
                    ArrayList arrayList2 = new ArrayList();
                    for (int i2 = 0; i2 < optJSONArray3.length(); i2++) {
                        arrayList2.add(Integer.valueOf(optJSONArray3.optInt(i2)));
                    }
                    if (arrayList2.size() > 0) {
                        campaignEx2.setRsIgnoreCheckRule(arrayList2);
                    }
                }
                return campaignEx2;
            } catch (Exception e) {
                e = e;
                e.printStackTrace();
                return campaignEx;
            }
        } catch (Exception e2) {
            e = e2;
            campaignEx = campaignEx2;
            e.printStackTrace();
            return campaignEx;
        }
    }

    private static JSONObject dealV5Temp(JSONObject jSONObject) {
        JSONArray optJSONArray;
        try {
            if (!jSONObject.has(JSON_KEY_AD_TMP_IDS) || (optJSONArray = jSONObject.optJSONArray(JSON_KEY_AD_TMP_IDS)) == null || optJSONArray.length() <= 0) {
                return jSONObject;
            }
            jSONObject.remove(JSON_KEY_AD_TMP_IDS);
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject a2 = com.mbridge.msdk.foundation.db.a.a.a().a(optJSONArray.getString(i));
                if (a2 != null) {
                    Iterator<String> keys = a2.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        jSONObject.put(next, a2.opt(next));
                    }
                }
            }
            return jSONObject;
        } catch (JSONException unused) {
            return null;
        }
    }

    public static CampaignEx parseCampaign(JSONObject jSONObject, String str, String str2, String str3, boolean z, CampaignUnit campaignUnit) {
        return parseCampaign(jSONObject, str, str2, str3, z, campaignUnit, "");
    }

    /* JADX WARNING: Removed duplicated region for block: B:109:0x0521 A[Catch:{ Exception -> 0x0539 }, LOOP:2: B:107:0x051b->B:109:0x0521, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:112:0x0535 A[Catch:{ Exception -> 0x0539 }] */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x0467 A[Catch:{ Exception -> 0x053c }] */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x047e A[Catch:{ Exception -> 0x053c }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.mbridge.msdk.foundation.entity.CampaignEx parseCampaign(org.json.JSONObject r17, java.lang.String r18, java.lang.String r19, java.lang.String r20, boolean r21, com.mbridge.msdk.foundation.entity.CampaignUnit r22, java.lang.String r23) {
        /*
            r0 = r22
            java.lang.String r1 = "cam_html"
            java.lang.String r2 = "gif_url"
            java.lang.String r3 = "nv_t2"
            java.lang.String r4 = "md5_file"
            java.lang.String r5 = "ad_tracking"
            java.lang.String r6 = "number_rating"
            java.lang.String r7 = "rating"
            java.lang.String r8 = ""
            java.lang.String r9 = "omid"
            org.json.JSONObject r10 = dealV5Temp(r17)
            if (r10 == 0) goto L_0x0544
            com.mbridge.msdk.foundation.entity.CampaignEx r12 = new com.mbridge.msdk.foundation.entity.CampaignEx     // Catch:{ Exception -> 0x053e }
            r12.<init>()     // Catch:{ Exception -> 0x053e }
            java.lang.String r13 = "aks"
            java.lang.String r13 = r10.optString(r13)     // Catch:{ Exception -> 0x053c }
            boolean r14 = android.text.TextUtils.isEmpty(r13)     // Catch:{ Exception -> 0x053c }
            if (r14 != 0) goto L_0x0058
            org.json.JSONObject r14 = new org.json.JSONObject     // Catch:{ Exception -> 0x053c }
            r14.<init>(r13)     // Catch:{ Exception -> 0x053c }
            java.util.Iterator r13 = r14.keys()     // Catch:{ Exception -> 0x053c }
            java.util.HashMap r15 = new java.util.HashMap     // Catch:{ Exception -> 0x053c }
            r15.<init>()     // Catch:{ Exception -> 0x053c }
        L_0x0039:
            if (r13 == 0) goto L_0x0055
            boolean r16 = r13.hasNext()     // Catch:{ Exception -> 0x053c }
            if (r16 == 0) goto L_0x0055
            java.lang.Object r16 = r13.next()     // Catch:{ Exception -> 0x053c }
            r11 = r16
            java.lang.String r11 = (java.lang.String) r11     // Catch:{ Exception -> 0x053c }
            r16 = r13
            java.lang.String r13 = r14.optString(r11)     // Catch:{ Exception -> 0x053c }
            r15.put(r11, r13)     // Catch:{ Exception -> 0x053c }
            r13 = r16
            goto L_0x0039
        L_0x0055:
            r12.setAks(r15)     // Catch:{ Exception -> 0x053c }
        L_0x0058:
            boolean r11 = android.text.TextUtils.isEmpty(r23)     // Catch:{ Exception -> 0x053c }
            r13 = 1
            if (r11 != 0) goto L_0x0067
            r11 = r23
            r12.setBidToken(r11)     // Catch:{ Exception -> 0x053c }
            r12.setIsBidCampaign(r13)     // Catch:{ Exception -> 0x053c }
        L_0x0067:
            java.lang.String r14 = "ready_rate"
            r15 = -1
            int r14 = r10.optInt(r14, r15)     // Catch:{ Exception -> 0x00db }
            r12.setReady_rate(r14)     // Catch:{ Exception -> 0x00db }
            java.lang.String r14 = "ext_data"
            org.json.JSONObject r14 = r10.optJSONObject(r14)     // Catch:{ Exception -> 0x00db }
            if (r14 == 0) goto L_0x0080
            java.lang.String r14 = r14.toString()     // Catch:{ Exception -> 0x00db }
            r12.setExt_data(r14)     // Catch:{ Exception -> 0x00db }
        L_0x0080:
            java.lang.String r14 = "mof_tplid"
            int r14 = r10.optInt(r14)     // Catch:{ Exception -> 0x00db }
            r12.setMof_tplid(r14)     // Catch:{ Exception -> 0x00db }
            java.lang.String r14 = "mof_template_url"
            java.lang.String r14 = r10.optString(r14)     // Catch:{ Exception -> 0x00db }
            r12.setMof_template_url(r14)     // Catch:{ Exception -> 0x00db }
            java.lang.String r14 = "nscpt"
            int r14 = r10.optInt(r14)     // Catch:{ Exception -> 0x00db }
            r12.setNscpt(r14)     // Catch:{ Exception -> 0x00db }
            org.json.JSONArray r14 = new org.json.JSONArray     // Catch:{ Exception -> 0x00db }
            r14.<init>()     // Catch:{ Exception -> 0x00db }
            java.lang.String r14 = "pv_urls"
            org.json.JSONArray r14 = r10.optJSONArray(r14)     // Catch:{ Exception -> 0x00db }
            if (r14 == 0) goto L_0x00c8
            int r15 = r14.length()     // Catch:{ Exception -> 0x00db }
            if (r15 <= 0) goto L_0x00c8
            java.util.ArrayList r15 = new java.util.ArrayList     // Catch:{ Exception -> 0x00db }
            int r13 = r14.length()     // Catch:{ Exception -> 0x00db }
            r15.<init>(r13)     // Catch:{ Exception -> 0x00db }
            r13 = 0
        L_0x00b8:
            int r11 = r14.length()     // Catch:{ Exception -> 0x00db }
            if (r13 >= r11) goto L_0x00c9
            java.lang.String r11 = r14.optString(r13)     // Catch:{ Exception -> 0x00db }
            r15.add(r11)     // Catch:{ Exception -> 0x00db }
            int r13 = r13 + 1
            goto L_0x00b8
        L_0x00c8:
            r15 = 0
        L_0x00c9:
            r12.setPv_urls(r15)     // Catch:{ Exception -> 0x00db }
            java.lang.String r11 = "req_ext_data"
            org.json.JSONObject r11 = r10.optJSONObject(r11)     // Catch:{ Exception -> 0x00db }
            if (r11 == 0) goto L_0x00db
            java.lang.String r11 = r11.toString()     // Catch:{ Exception -> 0x00db }
            r12.setReq_ext_data(r11)     // Catch:{ Exception -> 0x00db }
        L_0x00db:
            java.lang.String r11 = "id"
            java.lang.String r11 = r10.optString(r11)     // Catch:{ Exception -> 0x053c }
            r12.setId(r11)     // Catch:{ Exception -> 0x053c }
            java.lang.String r11 = "title"
            java.lang.String r11 = r10.optString(r11)     // Catch:{ Exception -> 0x053c }
            r12.setAppName(r11)     // Catch:{ Exception -> 0x053c }
            java.lang.String r11 = "unitId"
            java.lang.String r11 = r10.optString(r11, r8)     // Catch:{ Exception -> 0x053c }
            r12.setCampaignUnitId(r11)     // Catch:{ Exception -> 0x053c }
            java.lang.String r11 = "desc"
            java.lang.String r11 = r10.optString(r11)     // Catch:{ Exception -> 0x053c }
            r12.setAppDesc(r11)     // Catch:{ Exception -> 0x053c }
            java.lang.String r11 = "package_name"
            java.lang.String r11 = r10.optString(r11)     // Catch:{ Exception -> 0x053c }
            r12.setPackageName(r11)     // Catch:{ Exception -> 0x053c }
            java.lang.String r11 = "rtins_type"
            int r11 = r10.optInt(r11)     // Catch:{ Exception -> 0x053c }
            r12.setRtinsType(r11)     // Catch:{ Exception -> 0x053c }
            java.lang.String r11 = "icon_url"
            java.lang.String r11 = r10.optString(r11)     // Catch:{ Exception -> 0x053c }
            r12.setIconUrl(r11)     // Catch:{ Exception -> 0x053c }
            java.lang.String r11 = "image_url"
            java.lang.String r11 = r10.optString(r11)     // Catch:{ Exception -> 0x053c }
            r12.setImageUrl(r11)     // Catch:{ Exception -> 0x053c }
            java.lang.String r11 = "app_size"
            java.lang.String r11 = r10.optString(r11)     // Catch:{ Exception -> 0x053c }
            r12.setSize(r11)     // Catch:{ Exception -> 0x053c }
            java.lang.String r11 = "image_size"
            java.lang.String r11 = r10.optString(r11)     // Catch:{ Exception -> 0x053c }
            r12.setImageSize(r11)     // Catch:{ Exception -> 0x053c }
            java.lang.String r11 = "impression_url"
            java.lang.String r11 = r10.optString(r11)     // Catch:{ Exception -> 0x053c }
            java.lang.String r11 = replaceValueByKey(r0, r12, r11)     // Catch:{ Exception -> 0x053c }
            r12.setImpressionURL(r11)     // Catch:{ Exception -> 0x053c }
            java.lang.String r11 = "click_url"
            java.lang.String r11 = r10.optString(r11)     // Catch:{ Exception -> 0x053c }
            java.lang.String r11 = replaceValueByKey(r0, r12, r11)     // Catch:{ Exception -> 0x053c }
            r12.setClickURL(r11)     // Catch:{ Exception -> 0x053c }
            java.lang.String r11 = "rw_pl"
            java.lang.String r11 = r10.optString(r11)     // Catch:{ Exception -> 0x053c }
            com.mbridge.msdk.foundation.entity.RewardPlus r11 = com.mbridge.msdk.foundation.entity.RewardPlus.parseByString(r11)     // Catch:{ Exception -> 0x053c }
            r12.setRewardPlus(r11)     // Catch:{ Exception -> 0x053c }
            java.lang.String r11 = "wtick"
            int r11 = r10.optInt(r11)     // Catch:{ Exception -> 0x053c }
            r12.setWtick(r11)     // Catch:{ Exception -> 0x053c }
            java.lang.String r11 = "deep_link"
            java.lang.String r11 = r10.optString(r11)     // Catch:{ Exception -> 0x053c }
            java.lang.String r11 = replaceValueByKey(r0, r12, r11)     // Catch:{ Exception -> 0x053c }
            r12.setDeepLinkUrl(r11)     // Catch:{ Exception -> 0x053c }
            java.lang.String r11 = "user_activation"
            r13 = 0
            boolean r11 = r10.optBoolean(r11, r13)     // Catch:{ Exception -> 0x053c }
            r12.setUserActivation(r11)     // Catch:{ Exception -> 0x053c }
            java.lang.String r11 = "notice_url"
            java.lang.String r11 = r10.optString(r11)     // Catch:{ Exception -> 0x053c }
            java.lang.String r11 = replaceValueByKey(r0, r12, r11)     // Catch:{ Exception -> 0x053c }
            r12.setNoticeUrl(r11)     // Catch:{ Exception -> 0x053c }
            java.lang.String r11 = "template"
            int r11 = r10.optInt(r11)     // Catch:{ Exception -> 0x053c }
            r12.setTemplate(r11)     // Catch:{ Exception -> 0x053c }
            java.lang.String r11 = "ad_source_id"
            r13 = 1
            int r11 = r10.optInt(r11, r13)     // Catch:{ Exception -> 0x053c }
            r12.setType(r11)     // Catch:{ Exception -> 0x053c }
            java.lang.String r11 = "fca"
            int r11 = r10.optInt(r11)     // Catch:{ Exception -> 0x053c }
            r12.setFca(r11)     // Catch:{ Exception -> 0x053c }
            java.lang.String r11 = "fcb"
            int r11 = r10.optInt(r11)     // Catch:{ Exception -> 0x053c }
            r12.setFcb(r11)     // Catch:{ Exception -> 0x053c }
            java.lang.String r11 = "endcard_click_result"
            int r11 = r10.optInt(r11)     // Catch:{ Exception -> 0x053c }
            r12.setEndcard_click_result(r11)     // Catch:{ Exception -> 0x053c }
            java.lang.String r11 = r10.optString(r7)     // Catch:{ Exception -> 0x053c }
            boolean r11 = android.text.TextUtils.isEmpty(r11)     // Catch:{ Exception -> 0x053c }
            if (r11 != 0) goto L_0x01ce
            java.lang.String r11 = "0"
            java.lang.String r7 = r10.optString(r7, r11)     // Catch:{ Exception -> 0x053c }
            double r13 = java.lang.Double.parseDouble(r7)     // Catch:{ Exception -> 0x053c }
            r12.setRating(r13)     // Catch:{ Exception -> 0x053c }
        L_0x01ce:
            java.lang.String r7 = r10.optString(r6)     // Catch:{ Exception -> 0x053c }
            boolean r7 = android.text.TextUtils.isEmpty(r7)     // Catch:{ Exception -> 0x053c }
            if (r7 != 0) goto L_0x01e2
            r7 = 333333(0x51615, float:4.67099E-40)
            int r6 = r10.optInt(r6, r7)     // Catch:{ Exception -> 0x053c }
            r12.setNumberRating(r6)     // Catch:{ Exception -> 0x053c }
        L_0x01e2:
            java.lang.String r6 = "click_mode"
            java.lang.String r6 = r10.optString(r6)     // Catch:{ Exception -> 0x053c }
            r12.setClick_mode(r6)     // Catch:{ Exception -> 0x053c }
            java.lang.String r6 = "landing_type"
            java.lang.String r6 = r10.optString(r6)     // Catch:{ Exception -> 0x053c }
            r12.setLandingType(r6)     // Catch:{ Exception -> 0x053c }
            java.lang.String r6 = "link_type"
            r7 = 4
            int r6 = r10.optInt(r6, r7)     // Catch:{ Exception -> 0x053c }
            r12.setLinkType(r6)     // Catch:{ Exception -> 0x053c }
            java.lang.String r6 = "c_ct"
            int r6 = r10.optInt(r6)     // Catch:{ Exception -> 0x053c }
            r12.setClickInterval(r6)     // Catch:{ Exception -> 0x053c }
            java.lang.String r6 = "ctatext"
            java.lang.String r6 = r10.optString(r6)     // Catch:{ Exception -> 0x053c }
            r12.setAdCall(r6)     // Catch:{ Exception -> 0x053c }
            java.lang.String r6 = "ad_url_list"
            java.lang.String r6 = r10.optString(r6)     // Catch:{ Exception -> 0x053c }
            r12.setAd_url_list(r6)     // Catch:{ Exception -> 0x053c }
            java.lang.String r6 = "retarget_offer"
            r7 = 2
            int r6 = r10.optInt(r6, r7)     // Catch:{ Exception -> 0x053c }
            r12.setRetarget_offer(r6)     // Catch:{ Exception -> 0x053c }
            java.lang.String r6 = "video_url"
            java.lang.String r6 = r10.optString(r6)     // Catch:{ Exception -> 0x053c }
            boolean r11 = android.text.TextUtils.isEmpty(r6)     // Catch:{ Exception -> 0x053c }
            if (r11 != 0) goto L_0x023c
            if (r21 == 0) goto L_0x0235
            r12.setVideoUrlEncode(r6)     // Catch:{ Exception -> 0x053c }
            goto L_0x023c
        L_0x0235:
            java.lang.String r6 = com.mbridge.msdk.foundation.tools.l.b(r6)     // Catch:{ Exception -> 0x053c }
            r12.setVideoUrlEncode(r6)     // Catch:{ Exception -> 0x053c }
        L_0x023c:
            java.lang.String r6 = "view_com_time"
            int r6 = r10.optInt(r6)     // Catch:{ Exception -> 0x053c }
            r12.setVideoCompleteTime(r6)     // Catch:{ Exception -> 0x053c }
            java.lang.String r6 = "video_length"
            int r6 = r10.optInt(r6)     // Catch:{ Exception -> 0x053c }
            r12.setVideoLength(r6)     // Catch:{ Exception -> 0x053c }
            java.lang.String r6 = "video_size"
            int r6 = r10.optInt(r6)     // Catch:{ Exception -> 0x053c }
            r12.setVideoSize(r6)     // Catch:{ Exception -> 0x053c }
            java.lang.String r6 = "video_resolution"
            java.lang.String r6 = r10.optString(r6)     // Catch:{ Exception -> 0x053c }
            r12.setVideoResolution(r6)     // Catch:{ Exception -> 0x053c }
            java.lang.String r6 = "watch_mile"
            int r6 = r10.optInt(r6)     // Catch:{ Exception -> 0x053c }
            r12.setWatchMile(r6)     // Catch:{ Exception -> 0x053c }
            long r13 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x053c }
            r12.setTimestamp(r13)     // Catch:{ Exception -> 0x053c }
            r6 = r18
            java.lang.String r6 = replaceValueByKey(r0, r12, r6)     // Catch:{ Exception -> 0x053c }
            r12.setOnlyImpressionURL(r6)     // Catch:{ Exception -> 0x053c }
            java.lang.String r6 = "ctype"
            int r6 = r10.optInt(r6)     // Catch:{ Exception -> 0x053c }
            r12.setBty(r6)     // Catch:{ Exception -> 0x053c }
            java.lang.String r6 = "adv_imp"
            java.lang.String r6 = r10.optString(r6)     // Catch:{ Exception -> 0x053c }
            r12.setAdvImp(r6)     // Catch:{ Exception -> 0x053c }
            java.lang.String r6 = "t_imp"
            int r6 = r10.optInt(r6)     // Catch:{ Exception -> 0x053c }
            r12.setTImp(r6)     // Catch:{ Exception -> 0x053c }
            r6 = r19
            r12.setHtmlUrl(r6)     // Catch:{ Exception -> 0x053c }
            r6 = r20
            r12.setEndScreenUrl(r6)     // Catch:{ Exception -> 0x053c }
            java.lang.String r6 = "guidelines"
            java.lang.String r6 = r10.optString(r6)     // Catch:{ Exception -> 0x053c }
            r12.setGuidelines(r6)     // Catch:{ Exception -> 0x053c }
            java.lang.String r6 = "offer_type"
            int r6 = r10.optInt(r6)     // Catch:{ Exception -> 0x053c }
            r12.setOfferType(r6)     // Catch:{ Exception -> 0x053c }
            java.lang.String r6 = "reward_name"
            java.lang.String r6 = r10.optString(r6)     // Catch:{ Exception -> 0x053c }
            r12.setRewardName(r6)     // Catch:{ Exception -> 0x053c }
            java.lang.String r6 = "reward_amount"
            int r6 = r10.optInt(r6)     // Catch:{ Exception -> 0x053c }
            r12.setRewardAmount(r6)     // Catch:{ Exception -> 0x053c }
            boolean r6 = r10.has(r5)     // Catch:{ Exception -> 0x02e0 }
            if (r6 == 0) goto L_0x02e0
            java.lang.String r5 = r10.optString(r5)     // Catch:{ Exception -> 0x02e0 }
            java.lang.String r5 = replaceValueByKey(r0, r12, r5)     // Catch:{ Exception -> 0x02e0 }
            boolean r6 = android.text.TextUtils.isEmpty(r5)     // Catch:{ Exception -> 0x02e0 }
            if (r6 != 0) goto L_0x02e0
            r12.setNativeVideoTrackingString(r5)     // Catch:{ Exception -> 0x02e0 }
            com.mbridge.msdk.foundation.entity.i r5 = TrackingStr2Object(r5)     // Catch:{ Exception -> 0x02e0 }
            r12.setNativeVideoTracking(r5)     // Catch:{ Exception -> 0x02e0 }
        L_0x02e0:
            java.lang.String r5 = "video_end_type"
            int r5 = r10.optInt(r5, r7)     // Catch:{ Exception -> 0x053c }
            r12.setVideo_end_type(r5)     // Catch:{ Exception -> 0x053c }
            java.lang.String r5 = "endcard_url"
            java.lang.String r5 = r10.optString(r5)     // Catch:{ Exception -> 0x053c }
            boolean r5 = isBreakCampainOrSetItByEndCard(r12, r5)     // Catch:{ Exception -> 0x053c }
            if (r5 == 0) goto L_0x02f7
            r5 = 0
            return r5
        L_0x02f7:
            java.lang.String r5 = "playable_ads_without_video"
            r6 = 1
            int r5 = r10.optInt(r5, r6)     // Catch:{ Exception -> 0x053c }
            r12.setPlayable_ads_without_video(r5)     // Catch:{ Exception -> 0x053c }
            boolean r5 = r10.has(r4)     // Catch:{ Exception -> 0x053c }
            if (r5 == 0) goto L_0x030e
            java.lang.String r4 = r10.optString(r4)     // Catch:{ Exception -> 0x053c }
            r12.setVideoMD5Value(r4)     // Catch:{ Exception -> 0x053c }
        L_0x030e:
            boolean r4 = r10.has(r3)     // Catch:{ Exception -> 0x053c }
            if (r4 == 0) goto L_0x031b
            int r3 = r10.optInt(r3)     // Catch:{ Exception -> 0x053c }
            r12.setNvT2(r3)     // Catch:{ Exception -> 0x053c }
        L_0x031b:
            boolean r3 = r10.has(r2)     // Catch:{ Exception -> 0x053c }
            if (r3 == 0) goto L_0x0328
            java.lang.String r2 = r10.optString(r2)     // Catch:{ Exception -> 0x053c }
            r12.setGifUrl(r2)     // Catch:{ Exception -> 0x053c }
        L_0x0328:
            java.lang.String r2 = "rv"
            org.json.JSONObject r2 = r10.optJSONObject(r2)     // Catch:{ Exception -> 0x053c }
            com.mbridge.msdk.foundation.entity.CampaignEx$c r2 = com.mbridge.msdk.foundation.entity.CampaignEx.c.a((org.json.JSONObject) r2)     // Catch:{ Exception -> 0x053c }
            r12.setRewardTemplateMode(r2)     // Catch:{ Exception -> 0x053c }
            java.lang.String r2 = "c_toi"
            int r2 = r10.optInt(r2, r7)     // Catch:{ Exception -> 0x053c }
            r12.setClickTimeOutInterval(r2)     // Catch:{ Exception -> 0x053c }
            java.lang.String r2 = "imp_ua"
            r3 = 1
            int r2 = r10.optInt(r2, r3)     // Catch:{ Exception -> 0x053c }
            r12.setImpUA(r2)     // Catch:{ Exception -> 0x053c }
            java.lang.String r2 = "c_ua"
            int r2 = r10.optInt(r2, r3)     // Catch:{ Exception -> 0x053c }
            r12.setcUA(r2)     // Catch:{ Exception -> 0x053c }
            java.lang.String r2 = "jm_pd"
            int r2 = r10.optInt(r2)     // Catch:{ Exception -> 0x053c }
            r12.setJmPd(r2)     // Catch:{ Exception -> 0x053c }
            java.lang.String r2 = "ia_icon"
            java.lang.String r2 = r10.optString(r2)     // Catch:{ Exception -> 0x053c }
            r12.setKeyIaIcon(r2)     // Catch:{ Exception -> 0x053c }
            java.lang.String r2 = "ia_rst"
            int r2 = r10.optInt(r2)     // Catch:{ Exception -> 0x053c }
            r12.setKeyIaRst(r2)     // Catch:{ Exception -> 0x053c }
            java.lang.String r2 = "ia_url"
            java.lang.String r2 = r10.optString(r2)     // Catch:{ Exception -> 0x053c }
            r12.setKeyIaUrl(r2)     // Catch:{ Exception -> 0x053c }
            java.lang.String r2 = "ia_ori"
            int r2 = r10.optInt(r2)     // Catch:{ Exception -> 0x053c }
            r12.setKeyIaOri(r2)     // Catch:{ Exception -> 0x053c }
            int r0 = r22.getAdType()     // Catch:{ Exception -> 0x053c }
            r12.setAdType(r0)     // Catch:{ Exception -> 0x053c }
            java.lang.String r0 = "ia_ext1"
            java.lang.String r0 = r10.optString(r0)     // Catch:{ Exception -> 0x053c }
            r12.setIa_ext1(r0)     // Catch:{ Exception -> 0x053c }
            java.lang.String r0 = "ia_ext2"
            java.lang.String r0 = r10.optString(r0)     // Catch:{ Exception -> 0x053c }
            r12.setIa_ext2(r0)     // Catch:{ Exception -> 0x053c }
            java.lang.String r0 = "is_download_zip"
            int r0 = r10.optInt(r0)     // Catch:{ Exception -> 0x053c }
            r12.setIsDownLoadZip(r0)     // Catch:{ Exception -> 0x053c }
            java.lang.String r0 = "ia_cache"
            java.lang.String r0 = r10.optString(r0)     // Catch:{ Exception -> 0x053c }
            r12.setInteractiveCache(r0)     // Catch:{ Exception -> 0x053c }
            java.lang.String r0 = "oc_time"
            int r0 = r10.optInt(r0)     // Catch:{ Exception -> 0x053c }
            r12.setOc_time(r0)     // Catch:{ Exception -> 0x053c }
            java.lang.String r0 = "oc_type"
            int r0 = r10.optInt(r0)     // Catch:{ Exception -> 0x053c }
            r12.setOc_type(r0)     // Catch:{ Exception -> 0x053c }
            java.lang.String r0 = "t_list"
            java.lang.String r0 = r10.optString(r0)     // Catch:{ Exception -> 0x053c }
            r12.setT_list(r0)     // Catch:{ Exception -> 0x053c }
            java.lang.String r0 = "adchoice"
            java.lang.String r0 = r10.optString(r0, r8)     // Catch:{ Exception -> 0x053c }
            com.mbridge.msdk.foundation.entity.CampaignEx$a r0 = com.mbridge.msdk.foundation.entity.CampaignEx.a.a((java.lang.String) r0)     // Catch:{ Exception -> 0x053c }
            r12.setAdchoice(r0)     // Catch:{ Exception -> 0x053c }
            java.lang.String r0 = "plct"
            long r2 = r10.optLong(r0)     // Catch:{ Exception -> 0x053c }
            r12.setPlct(r2)     // Catch:{ Exception -> 0x053c }
            java.lang.String r0 = "plctb"
            long r2 = r10.optLong(r0)     // Catch:{ Exception -> 0x053c }
            r12.setPlctb(r2)     // Catch:{ Exception -> 0x053c }
            java.lang.String r0 = "creative_id"
            long r2 = r10.optLong(r0)     // Catch:{ Exception -> 0x053c }
            r12.setCreativeId(r2)     // Catch:{ Exception -> 0x053c }
            java.lang.String r0 = "cam_tpl_url"
            java.lang.String r0 = r10.optString(r0)     // Catch:{ Exception -> 0x053c }
            android.net.Uri r2 = android.net.Uri.parse(r0)     // Catch:{ Exception -> 0x053c }
            java.lang.String r3 = r2.getPath()     // Catch:{ Exception -> 0x053c }
            boolean r3 = android.text.TextUtils.isEmpty(r3)     // Catch:{ Exception -> 0x053c }
            if (r3 != 0) goto L_0x041c
            java.lang.String r3 = r2.getPath()     // Catch:{ Exception -> 0x053c }
            java.lang.String r4 = ".zip"
            boolean r3 = r3.endsWith(r4)     // Catch:{ Exception -> 0x053c }
            if (r3 != 0) goto L_0x0418
            java.lang.String r2 = r2.getPath()     // Catch:{ Exception -> 0x053c }
            java.lang.String r3 = ".ZIP"
            boolean r2 = r2.endsWith(r3)     // Catch:{ Exception -> 0x053c }
            if (r2 == 0) goto L_0x041c
        L_0x0418:
            r12.setAdZip(r0)     // Catch:{ Exception -> 0x053c }
            goto L_0x041f
        L_0x041c:
            r12.setBannerUrl(r0)     // Catch:{ Exception -> 0x053c }
        L_0x041f:
            java.lang.String r0 = r10.optString(r1)     // Catch:{ Exception -> 0x053c }
            r12.setBannerHtml(r0)     // Catch:{ Exception -> 0x053c }
            java.lang.String r0 = r10.optString(r1)     // Catch:{ Exception -> 0x053c }
            r12.setAdHtml(r0)     // Catch:{ Exception -> 0x053c }
            java.lang.String r0 = "mraid"
            java.lang.String r0 = r10.optString(r0)     // Catch:{ Exception -> 0x053c }
            boolean r1 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x053c }
            if (r1 != 0) goto L_0x0442
            r1 = 1
            r12.setIsMraid(r1)     // Catch:{ Exception -> 0x053c }
            r12.setMraid(r0)     // Catch:{ Exception -> 0x053c }
        L_0x0440:
            r13 = 0
            goto L_0x0461
        L_0x0442:
            java.lang.String r0 = r12.getAdHtml()     // Catch:{ Exception -> 0x053c }
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x053c }
            if (r0 != 0) goto L_0x045d
            java.lang.String r0 = r12.getAdHtml()     // Catch:{ Exception -> 0x053c }
            java.lang.String r1 = "<MBTPLMARK>"
            boolean r0 = r0.contains(r1)     // Catch:{ Exception -> 0x053c }
            if (r0 != 0) goto L_0x045d
            r1 = 1
            r12.setIsMraid(r1)     // Catch:{ Exception -> 0x053c }
            goto L_0x0440
        L_0x045d:
            r13 = 0
            r12.setIsMraid(r13)     // Catch:{ Exception -> 0x053c }
        L_0x0461:
            org.json.JSONArray r0 = r10.optJSONArray(r9)     // Catch:{ Exception -> 0x053c }
            if (r0 != 0) goto L_0x047e
            java.lang.String r0 = r10.optString(r9)     // Catch:{ Exception -> 0x053c }
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x053c }
            if (r0 != 0) goto L_0x0479
            java.lang.String r0 = r10.optString(r9)     // Catch:{ Exception -> 0x053c }
            r12.setOmid(r0)     // Catch:{ Exception -> 0x053c }
            goto L_0x0485
        L_0x0479:
            r1 = 0
            r12.setOmid(r1)     // Catch:{ Exception -> 0x053c }
            goto L_0x0485
        L_0x047e:
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x053c }
            r12.setOmid(r0)     // Catch:{ Exception -> 0x053c }
        L_0x0485:
            java.lang.String r0 = com.mbridge.msdk.MBridgeConstans.PLACEMENT_ID     // Catch:{ Exception -> 0x053c }
            java.lang.String r0 = r10.optString(r0)     // Catch:{ Exception -> 0x053c }
            r12.setPlacementId(r0)     // Catch:{ Exception -> 0x053c }
            java.lang.String r0 = "maitve"
            int r0 = r10.optInt(r0)     // Catch:{ Exception -> 0x053c }
            r12.setMaitve(r0)     // Catch:{ Exception -> 0x053c }
            java.lang.String r0 = "maitve_src"
            java.lang.String r0 = r10.optString(r0)     // Catch:{ Exception -> 0x053c }
            r12.setMaitve_src(r0)     // Catch:{ Exception -> 0x053c }
            java.lang.String r0 = "flb"
            int r0 = r10.optInt(r0)     // Catch:{ Exception -> 0x053c }
            r12.setFlb(r0)     // Catch:{ Exception -> 0x053c }
            java.lang.String r0 = "cbd"
            r1 = -2
            int r0 = r10.optInt(r0, r1)     // Catch:{ Exception -> 0x053c }
            r12.setCbd(r0)     // Catch:{ Exception -> 0x053c }
            java.lang.String r0 = "vst"
            int r0 = r10.optInt(r0, r1)     // Catch:{ Exception -> 0x053c }
            r12.setVst(r0)     // Catch:{ Exception -> 0x053c }
            java.lang.String r0 = "adspace_t"
            r1 = 1
            int r0 = r10.optInt(r0, r1)     // Catch:{ Exception -> 0x053c }
            r12.setAdSpaceT(r0)     // Catch:{ Exception -> 0x053c }
            java.lang.String r0 = "flb_skiptime"
            int r0 = r10.optInt(r0)     // Catch:{ Exception -> 0x053c }
            r12.setFlbSkipTime(r0)     // Catch:{ Exception -> 0x053c }
            com.mbridge.msdk.foundation.entity.CampaignEx r11 = parseCampaign(r10, r12)     // Catch:{ Exception -> 0x053c }
            com.mbridge.msdk.foundation.controller.a r0 = com.mbridge.msdk.foundation.controller.a.e()     // Catch:{ Exception -> 0x04eb }
            android.content.Context r0 = r0.g()     // Catch:{ Exception -> 0x04eb }
            java.lang.String r1 = r11.getPackageName()     // Catch:{ Exception -> 0x04eb }
            java.lang.String r2 = r11.getImpressionURL()     // Catch:{ Exception -> 0x04eb }
            java.lang.String r0 = com.mbridge.msdk.foundation.tools.u.a((android.content.Context) r0, (java.lang.String) r1, (java.lang.String) r2)     // Catch:{ Exception -> 0x04eb }
            r11.setImpressionURL(r0)     // Catch:{ Exception -> 0x04eb }
            goto L_0x04f5
        L_0x04eb:
            r0 = move-exception
            java.lang.String r1 = "campaign"
            java.lang.String r0 = r0.getMessage()     // Catch:{ Exception -> 0x0539 }
            com.mbridge.msdk.foundation.tools.q.d(r1, r0)     // Catch:{ Exception -> 0x0539 }
        L_0x04f5:
            java.lang.String r0 = "vck_t"
            int r0 = r10.optInt(r0, r7)     // Catch:{ Exception -> 0x0539 }
            r11.setVideoCheckType(r0)     // Catch:{ Exception -> 0x0539 }
            java.lang.String r0 = "vctn_t"
            r1 = 1
            int r0 = r10.optInt(r0, r1)     // Catch:{ Exception -> 0x0539 }
            r11.setVideoCtnType(r0)     // Catch:{ Exception -> 0x0539 }
            java.lang.String r0 = "rs_ignc_r"
            org.json.JSONArray r0 = r10.optJSONArray(r0)     // Catch:{ Exception -> 0x0539 }
            if (r0 == 0) goto L_0x0538
            int r1 = r0.length()     // Catch:{ Exception -> 0x0539 }
            if (r1 <= 0) goto L_0x0538
            java.util.ArrayList r1 = new java.util.ArrayList     // Catch:{ Exception -> 0x0539 }
            r1.<init>()     // Catch:{ Exception -> 0x0539 }
        L_0x051b:
            int r2 = r0.length()     // Catch:{ Exception -> 0x0539 }
            if (r13 >= r2) goto L_0x052f
            int r2 = r0.optInt(r13)     // Catch:{ Exception -> 0x0539 }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ Exception -> 0x0539 }
            r1.add(r2)     // Catch:{ Exception -> 0x0539 }
            int r13 = r13 + 1
            goto L_0x051b
        L_0x052f:
            int r0 = r1.size()     // Catch:{ Exception -> 0x0539 }
            if (r0 <= 0) goto L_0x0538
            r11.setRsIgnoreCheckRule(r1)     // Catch:{ Exception -> 0x0539 }
        L_0x0538:
            return r11
        L_0x0539:
            r0 = move-exception
            r12 = r11
            goto L_0x0540
        L_0x053c:
            r0 = move-exception
            goto L_0x0540
        L_0x053e:
            r0 = move-exception
            r12 = 0
        L_0x0540:
            r0.printStackTrace()
            return r12
        L_0x0544:
            r1 = 0
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.entity.CampaignEx.parseCampaign(org.json.JSONObject, java.lang.String, java.lang.String, java.lang.String, boolean, com.mbridge.msdk.foundation.entity.CampaignUnit, java.lang.String):com.mbridge.msdk.foundation.entity.CampaignEx");
    }

    public static i TrackingStr2Object(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                JSONObject jSONObject = new JSONObject(str);
                i iVar = new i();
                iVar.o(processNativeVideoTrackingArray(jSONObject.optJSONArray("impression")));
                iVar.d(processNativeVideoTrackingArray(jSONObject.optJSONArray("start")));
                iVar.e(processNativeVideoTrackingArray(jSONObject.optJSONArray(JSON_NATIVE_VIDEO_FIRST_QUARTILE)));
                iVar.f(processNativeVideoTrackingArray(jSONObject.optJSONArray(JSON_NATIVE_VIDEO_MIDPOINT)));
                iVar.g(processNativeVideoTrackingArray(jSONObject.optJSONArray(JSON_NATIVE_VIDEO_THIRD_QUARTILE)));
                iVar.h(processNativeVideoTrackingArray(jSONObject.optJSONArray(JSON_NATIVE_VIDEO_COMPLETE)));
                iVar.a(parsePlayCentage(jSONObject.optJSONArray(JSON_NATIVE_VIDEO_PLAY_PERCENTAGE)));
                iVar.i(processNativeVideoTrackingArray(jSONObject.optJSONArray("mute")));
                iVar.j(processNativeVideoTrackingArray(jSONObject.optJSONArray("unmute")));
                iVar.k(processNativeVideoTrackingArray(jSONObject.optJSONArray(JSON_NATIVE_VIDEO_CLICK)));
                iVar.l(processNativeVideoTrackingArray(jSONObject.optJSONArray(JSON_NATIVE_VIDEO_PAUSE)));
                iVar.m(processNativeVideoTrackingArray(jSONObject.optJSONArray(JSON_NATIVE_VIDEO_RESUME)));
                iVar.n(processNativeVideoTrackingArray(jSONObject.optJSONArray(JSON_NATIVE_VIDEO_ERROR)));
                iVar.p(processNativeVideoTrackingArray(jSONObject.optJSONArray(JSON_NATIVE_VIDEO_ENDCARD)));
                iVar.r(processNativeVideoTrackingArray(jSONObject.optJSONArray("close")));
                iVar.q(processNativeVideoTrackingArray(jSONObject.optJSONArray(JSON_NATIVE_VIDEO_ENDCARD_SHOW)));
                iVar.s(processNativeVideoTrackingArray(jSONObject.optJSONArray("video_click")));
                iVar.c(processNativeVideoTrackingArray(jSONObject.optJSONArray(JSON_KEY_AD_TRACKING_IMPRESSION_T2)));
                iVar.a(processNativeVideoTrackingArray(jSONObject.optJSONArray(JSON_KEY_AD_TRACKING_DROPOUT_TRACK)));
                iVar.b(processNativeVideoTrackingArray(jSONObject.optJSONArray(JSON_KEY_AD_TRACKING_PLYCMPT_TRACK)));
                return trackingStr2Object(jSONObject, iVar);
            }
        } catch (JSONException unused) {
        }
        return null;
    }

    protected static String[] processNativeVideoTrackingArray(JSONArray jSONArray) {
        if (jSONArray == null || jSONArray.length() <= 0) {
            return null;
        }
        String[] strArr = new String[jSONArray.length()];
        for (int i = 0; i < jSONArray.length(); i++) {
            strArr[i] = jSONArray.optString(i);
        }
        return strArr;
    }

    private Map<Integer, String> generateAdImpression(String str) {
        HashMap hashMap = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONArray jSONArray = new JSONArray(str);
            if (jSONArray.length() <= 0) {
                return null;
            }
            HashMap hashMap2 = new HashMap();
            int i = 0;
            while (i < jSONArray.length()) {
                try {
                    JSONObject optJSONObject = jSONArray.optJSONObject(i);
                    int optInt = optJSONObject.optInt(JSON_AD_IMP_KEY);
                    hashMap2.put(Integer.valueOf(optInt), optJSONObject.optString("url"));
                    i++;
                } catch (Exception e) {
                    e = e;
                    hashMap = hashMap2;
                    e.printStackTrace();
                    return hashMap;
                }
            }
            return hashMap2;
        } catch (Exception e2) {
            e = e2;
            e.printStackTrace();
            return hashMap;
        }
    }

    public List<String> getAdUrlList() {
        String ad_url_list2 = getAd_url_list();
        ArrayList arrayList = null;
        try {
            if (!TextUtils.isEmpty(ad_url_list2)) {
                JSONArray jSONArray = new JSONArray(ad_url_list2);
                ArrayList arrayList2 = new ArrayList();
                int i = 0;
                while (i < jSONArray.length()) {
                    try {
                        arrayList2.add(jSONArray.optString(i));
                        i++;
                    } catch (Exception e) {
                        Exception exc = e;
                        arrayList = arrayList2;
                        e = exc;
                        e.printStackTrace();
                        return arrayList;
                    }
                }
                return arrayList2;
            }
        } catch (Exception e2) {
            e = e2;
            e.printStackTrace();
            return arrayList;
        }
        return arrayList;
    }

    public static JSONArray parseCamplistToJson(List<CampaignEx> list) {
        JSONArray jSONArray = null;
        if (list != null) {
            try {
                if (list.size() > 0) {
                    JSONArray jSONArray2 = new JSONArray();
                    try {
                        for (CampaignEx campaignToJsonObject : list) {
                            try {
                                jSONArray2.put(campaignToJsonObject(campaignToJsonObject));
                            } catch (Throwable th) {
                                th.printStackTrace();
                            }
                        }
                        return jSONArray2;
                    } catch (Exception e) {
                        e = e;
                        jSONArray = jSONArray2;
                    }
                }
            } catch (Exception e2) {
                e = e2;
                e.printStackTrace();
                return jSONArray;
            }
        }
        return jSONArray;
    }

    public static JSONObject campaignToJsonObject(CampaignEx campaignEx, boolean z, boolean z2) throws JSONException {
        JSONObject campaignToJsonObject = campaignToJsonObject(campaignEx);
        campaignToJsonObject.put("isReady", z);
        campaignToJsonObject.put("expired", z2);
        return campaignToJsonObject;
    }

    public static JSONObject campaignToJsonObject(CampaignEx campaignEx) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("id", campaignEx.getId());
        jSONObject.put(JSON_KEY_FLB, campaignEx.getFlb());
        jSONObject.put(JSON_KEY_FLB_SKIP_TIME, campaignEx.getFlbSkipTime());
        jSONObject.put(JSON_KEY_NEW_INTERSTITIAL_AD_SPACE_T, campaignEx.getAdSpaceT());
        jSONObject.put(JSON_KEY_NEW_INTERSTITIAL_VST, campaignEx.getVst());
        jSONObject.put(JSON_KEY_NEW_INTERSTITIAL_CBD, campaignEx.getCbd());
        if (!TextUtils.isEmpty(campaignEx.getCampaignUnitId())) {
            jSONObject.put(JSON_KEY_CAMPAIGN_UNITID, campaignEx.getCampaignUnitId());
        }
        if (!TextUtils.isEmpty(campaignEx.getExt_data())) {
            try {
                jSONObject.put(JSON_KEY_EXT_DATA, new JSONObject(campaignEx.getExt_data()));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        if (!TextUtils.isEmpty(campaignEx.getReq_ext_data())) {
            try {
                jSONObject.put(CampaignUnit.JSON_KEY_REQ_EXT_DATA, new JSONObject(campaignEx.getReq_ext_data()));
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        if (campaignEx.getPv_urls() != null && campaignEx.getPv_urls().size() > 0) {
            try {
                JSONArray jSONArray = new JSONArray();
                for (String put : campaignEx.getPv_urls()) {
                    jSONArray.put(put);
                }
                jSONObject.put("pv_urls", jSONArray);
            } catch (JSONException e3) {
                e3.printStackTrace();
            }
        }
        if (!TextUtils.isEmpty(campaignEx.getMof_template_url())) {
            jSONObject.put(CampaignUnit.JSON_KEY_MOF_TPLID, campaignEx.getMof_tplid());
            jSONObject.put(CampaignUnit.JSON_KEY_MOF_TEMPLATE_URL, campaignEx.getMof_template_url());
            jSONObject.put(CampaignUnit.JSON_KEY_NSCPT, campaignEx.getNscpt());
        }
        jSONObject.put(JSON_KEY_READY_RATE, campaignEx.getReady_rate());
        jSONObject.put(JSON_KEY_TITLE, campaignEx.getAppName());
        jSONObject.put(JSON_KEY_DESC, campaignEx.getAppDesc());
        jSONObject.put(JSON_KEY_PACKAGE_NAME, campaignEx.getPackageName());
        jSONObject.put(JSON_KEY_RETARGET_TYPE, campaignEx.getRtinsType());
        jSONObject.put(JSON_KEY_ICON_URL, campaignEx.getIconUrl());
        jSONObject.put(JSON_KEY_IMAGE_URL, campaignEx.getImageUrl());
        jSONObject.put(JSON_KEY_APP_SIZE, campaignEx.getSize());
        jSONObject.put(JSON_KEY_IMAGE_SIZE, campaignEx.getImageSize());
        jSONObject.put(JSON_KEY_IMPRESSION_URL, campaignEx.getImpressionURL());
        jSONObject.put("click_url", campaignEx.getClickURL());
        if (campaignEx.getRewardPlus() != null) {
            jSONObject.put(JSON_KEY_REWARD_PLUS, campaignEx.getRewardPlus().toJsonObject());
        }
        jSONObject.put(JSON_KEY_WITHOUT_INSTALL_CHECK, campaignEx.getWtick());
        jSONObject.put(JSON_KEY_DEEP_LINK_URL, campaignEx.getDeepLinkURL());
        jSONObject.put(JSON_KEY_USER_ACTIVATION, campaignEx.getUserActivation());
        jSONObject.put(JSON_KEY_NOTICE_URL, campaignEx.getNoticeUrl());
        jSONObject.put("template", campaignEx.getTemplate());
        jSONObject.put(JSON_KEY_AD_SOURCE_ID, campaignEx.getType());
        jSONObject.put(JSON_KEY_FCA, campaignEx.getFca());
        jSONObject.put(JSON_KEY_FCB, campaignEx.getFcb());
        jSONObject.put(JSON_KEY_STAR, campaignEx.getRating() + "");
        jSONObject.put(JSON_KEY_NUMBER_RATING, campaignEx.getNumberRating());
        jSONObject.put(JSON_KEY_CLICK_MODE, campaignEx.getClick_mode());
        jSONObject.put(JSON_KEY_LANDING_TYPE, campaignEx.getLandingType());
        jSONObject.put(JSON_KEY_LINK_TYPE, campaignEx.getLinkType());
        jSONObject.put(JSON_KEY_CLICK_INTERVAL, campaignEx.getClickInterval());
        jSONObject.put(JSON_KEY_CTA_TEXT, campaignEx.getAdCall());
        jSONObject.put(JSON_KEY_ENDCARD_CLICK, campaignEx.getEndcard_click_result());
        jSONObject.put(JSON_KEY_RETARGET_OFFER, campaignEx.getRetarget_offer());
        jSONObject.put("video_url", campaignEx.getVideoUrlEncode());
        jSONObject.put(JSON_KEY_VIDEO_LENGTHL, campaignEx.getVideoLength());
        jSONObject.put(JSON_KEY_VIDEO_SIZE, campaignEx.getVideoSize());
        jSONObject.put(JSON_KEY_VIDEO_RESOLUTION, campaignEx.getVideoResolution());
        jSONObject.put(JSON_KEY_WATCH_MILE, campaignEx.getWatchMile());
        jSONObject.put(JSON_KEY_AD_URL_LIST, campaignEx.getAd_url_list());
        jSONObject.put(CampaignUnit.JSON_KEY_ONLY_IMPRESSION_URL, campaignEx.getOnlyImpressionURL());
        jSONObject.put(JSON_KEY_BTY, campaignEx.getBty());
        jSONObject.put(JSON_KEY_T_IMP, campaignEx.getTImp());
        jSONObject.put(JSON_KEY_ADVIMP, campaignEx.getAdvImp());
        jSONObject.put(CampaignUnit.JSON_KEY_HTML_URL, campaignEx.getHtmlUrl());
        jSONObject.put(CampaignUnit.JSON_KEY_END_SCREEN_URL, campaignEx.getEndScreenUrl());
        jSONObject.put(JSON_KEY_GUIDELINES, campaignEx.getGuidelines());
        jSONObject.put(JSON_KEY_OFFER_TYPE, campaignEx.getOfferType());
        jSONObject.put(JSON_KEY_REWARD_AMOUNT, campaignEx.getRewardAmount());
        jSONObject.put(JSON_KEY_REWARD_NAME, campaignEx.getRewardName());
        jSONObject.put(JSON_KEY_GIF_URL, campaignEx.getGifUrl());
        if (x.b(campaignEx.getNativeVideoTrackingString())) {
            jSONObject.put(JSON_NATIVE_VIDEO_AD_TRACKING, new JSONObject(campaignEx.getNativeVideoTrackingString()));
        }
        jSONObject.put(VIDEO_END_TYPE, campaignEx.getVideo_end_type());
        jSONObject.put(ENDCARD_URL, campaignEx.getendcard_url());
        jSONObject.put(PLAYABLE_ADS_WITHOUT_VIDEO, campaignEx.getPlayable_ads_without_video());
        if (!(campaignEx == null || campaignEx.getRewardTemplateMode() == null || !x.b(campaignEx.getRewardTemplateMode().a()))) {
            jSONObject.put(JSON_KEY_REWARD_TEMPLATE, new JSONObject(campaignEx.getRewardTemplateMode().a()));
        }
        jSONObject.put(JSON_KEY_REWARD_VIDEO_MD5, campaignEx.getVideoMD5Value());
        jSONObject.put(JSON_KEY_CLICK_TIMEOUT_INTERVAL, campaignEx.getClickTimeOutInterval());
        jSONObject.put(JSON_KEY_C_UA, campaignEx.getcUA());
        jSONObject.put(JSON_KEY_IMP_UA, campaignEx.getImpUA());
        jSONObject.put(JSON_KEY_JM_PD, campaignEx.getJmPd());
        jSONObject.put("ia_icon", campaignEx.getKeyIaIcon());
        jSONObject.put("ia_rst", campaignEx.getKeyIaRst());
        jSONObject.put("ia_url", campaignEx.getKeyIaUrl());
        jSONObject.put("ia_ori", campaignEx.getKeyIaOri());
        jSONObject.put("ad_type", campaignEx.getAdType());
        jSONObject.put(KEY_IA_EXT1, campaignEx.getIa_ext1());
        jSONObject.put(KEY_IA_EXT2, campaignEx.getIa_ext2());
        jSONObject.put(KEY_IS_DOWNLOAD, campaignEx.getIsDownLoadZip());
        jSONObject.put(KEY_IA_CACHE, campaignEx.getInteractiveCache());
        jSONObject.put(KEY_OC_TYPE, campaignEx.getOc_type());
        jSONObject.put(KEY_OC_TIME, campaignEx.getOc_time());
        jSONObject.put(KEY_T_LIST, campaignEx.getT_list());
        a adchoice2 = campaignEx.getAdchoice();
        if (adchoice2 != null) {
            jSONObject.put(KEY_ADCHOICE, new JSONObject(adchoice2.c()));
        }
        jSONObject.put(JSON_KEY_PLCT, campaignEx.getPlct());
        jSONObject.put(JSON_KEY_PLCTB, campaignEx.getPlctb());
        jSONObject.put(KEY_OMID, campaignEx.getOmid());
        jSONObject.put(JSON_KEY_CREATIVE_ID, campaignEx.getCreativeId());
        jSONObject.put("cam_html", campaignEx.getBannerHtml());
        jSONObject.put("cam_tpl_url", campaignEx.getBannerUrl() != null ? campaignEx.getBannerUrl() : campaignEx.getAdZip());
        jSONObject.put(JSON_KEY_MRAID, campaignEx.getMraid());
        jSONObject.put(JSON_KEY_MRAIDFORH5, campaignEx.getMraid());
        jSONObject.put("timestamp", campaignEx.getTimestamp());
        jSONObject.put(JSON_KEY_HB, campaignEx.isBidCampaign);
        jSONObject.put(MBridgeConstans.PLACEMENT_ID, campaignEx.getPlacementId());
        jSONObject.put(JSON_KEY_MAITVE, campaignEx.getMaitve());
        jSONObject.put(JSON_KEY_MAITVESRC, campaignEx.getMaitve_src());
        jSONObject.put("vcn", campaignEx.getVcn());
        jSONObject.put("token_r", campaignEx.getTokenRule());
        jSONObject.put("encrypt_p", campaignEx.getEncryptPrice());
        jSONObject.put(JSON_KEY_VIDEO_COMPLETE_TIME, campaignEx.getVideoCompleteTime());
        jSONObject.put(JSON_KEY_RS_IGNORE_CHECK_RULE, campaignEx.getRsIgnoreCheckRule());
        jSONObject.put(JSON_KEY_VIDEO_CHECK_TYPE, campaignEx.getVideoCheckType());
        jSONObject.put(JSON_KEY_VIDEO_CTN_TYPE, campaignEx.getVideoCtnType());
        try {
            jSONObject.put("misk_spt", u.c());
            jSONObject.put("misk_spt_det", u.d());
        } catch (JSONException unused) {
        }
        return campaignToJsonObject(jSONObject, campaignEx);
    }

    private static List<Map<Integer, String>> parsePlayCentage(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        if (jSONArray != null) {
            int i = 0;
            while (i < jSONArray.length()) {
                try {
                    String string = jSONArray.getString(i);
                    if (!TextUtils.isEmpty(string)) {
                        JSONObject jSONObject = new JSONObject(string);
                        HashMap hashMap = new HashMap();
                        int i2 = jSONObject.getInt("rate");
                        hashMap.put(Integer.valueOf(i2), jSONObject.getString("url"));
                        arrayList.add(hashMap);
                    }
                    i++;
                } catch (Throwable unused) {
                }
            }
        }
        return arrayList;
    }

    public boolean isCallbacked() {
        return this.isCallbacked;
    }

    public void setCallbacked(boolean z) {
        this.isCallbacked = z;
    }

    public int getReady_rate() {
        return this.ready_rate;
    }

    public void setReady_rate(int i) {
        this.ready_rate = i;
    }

    public String getExt_data() {
        return this.ext_data;
    }

    public void setExt_data(String str) {
        this.ext_data = str;
    }

    public int getNscpt() {
        return this.nscpt;
    }

    public void setNscpt(int i) {
        this.nscpt = i;
    }

    public String getMof_template_url() {
        return this.mof_template_url;
    }

    public void setMof_template_url(String str) {
        this.mof_template_url = str;
        if (!TextUtils.isEmpty(str)) {
            setCMPTEntryUrl(str);
            setDynamicView(u.f(str));
            setCanStart2C1Anim(u.h(str));
        }
    }

    public String getCMPTEntryUrl() {
        return this.CMPTEntryUrl;
    }

    public void setCMPTEntryUrl(String str) {
        this.CMPTEntryUrl = str;
    }

    public int getMof_tplid() {
        return this.mof_tplid;
    }

    public void setMof_tplid(int i) {
        this.mof_tplid = i;
    }

    public String getReq_ext_data() {
        return this.req_ext_data;
    }

    public void setReq_ext_data(String str) {
        this.req_ext_data = str;
    }

    public void setReadyState(int i) {
        this.readyState = i;
    }

    public boolean isReady() {
        return this.isReady;
    }

    public void setReady(boolean z) {
        this.isReady = z;
    }

    public int getLoadTimeoutState() {
        return this.loadTimeoutState;
    }

    public void setLoadTimeoutState(int i) {
        this.loadTimeoutState = i;
    }

    public int getMaitve() {
        return this.maitve;
    }

    public void setMaitve(int i) {
        this.maitve = i;
    }

    public String getMaitve_src() {
        return this.maitve_src;
    }

    public void setMaitve_src(String str) {
        this.maitve_src = str;
    }

    public static final class c implements Serializable {
        private String a;
        private int b;
        private int c;
        private String d;
        /* access modifiers changed from: private */
        public String e;
        private List<a> f;

        public static final class a implements Serializable {
            public String a;
            public List<String> b = new ArrayList();
        }

        private c(String str) {
            this.a = str;
        }

        public final String a() {
            return this.a;
        }

        public final int b() {
            return this.b;
        }

        public final int c() {
            return this.c;
        }

        public final String d() {
            return this.d;
        }

        public final String e() {
            return this.e;
        }

        public final List<a> f() {
            return this.f;
        }

        public static c a(String str) {
            try {
                if (x.b(str)) {
                    return a(new JSONObject(str));
                }
                return null;
            } catch (Throwable unused) {
                return null;
            }
        }

        public static c a(JSONObject jSONObject) {
            if (jSONObject == null) {
                return null;
            }
            try {
                if (!x.b(jSONObject.toString())) {
                    return null;
                }
                c cVar = new c(jSONObject.toString());
                cVar.b = jSONObject.optInt("video_template", 1);
                cVar.e = jSONObject.optString(AdvertisementDBAdapter.AdvertisementColumns.COLUMN_TEMPLATE_URL);
                cVar.c = jSONObject.optInt("orientation");
                cVar.d = jSONObject.optString("paused_url");
                JSONObject optJSONObject = jSONObject.optJSONObject("image");
                if (optJSONObject != null) {
                    ArrayList arrayList = new ArrayList();
                    Iterator<String> keys = optJSONObject.keys();
                    while (keys != null && keys.hasNext()) {
                        String next = keys.next();
                        List<String> b2 = u.b(optJSONObject.optJSONArray(next));
                        if (b2 != null && b2.size() > 0) {
                            a aVar = new a();
                            aVar.a = next;
                            aVar.b.addAll(b2);
                            arrayList.add(aVar);
                        }
                    }
                    cVar.f = arrayList;
                }
                return cVar;
            } catch (Throwable unused) {
                return null;
            }
        }
    }

    public boolean isHasReportAdTrackPause() {
        return this.hasReportAdTrackPause;
    }

    public void setHasReportAdTrackPause(boolean z) {
        this.hasReportAdTrackPause = z;
    }

    public static final class a implements Serializable {
        private String a = "";
        private String b = "";
        private String c = "";
        private String d = "";
        private String e = "";
        private String f = "";
        private String g = "";
        private String h = "";
        private int i = 0;
        private int j = 0;
        private String k = "";

        public final int a() {
            return this.i;
        }

        public final int b() {
            return this.j;
        }

        public final String c() {
            return this.k;
        }

        public final String d() {
            return this.b;
        }

        public final String e() {
            return this.c;
        }

        public final String f() {
            return this.d;
        }

        public static a a(String str) {
            try {
                if (TextUtils.isEmpty(str)) {
                    return null;
                }
                return a(new JSONObject(str));
            } catch (Exception e2) {
                if (MBridgeConstans.DEBUG) {
                    e2.printStackTrace();
                }
                return null;
            } catch (Throwable th) {
                if (MBridgeConstans.DEBUG) {
                    th.printStackTrace();
                }
                return null;
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:13:0x0065  */
        /* JADX WARNING: Removed duplicated region for block: B:21:? A[RETURN, SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private static com.mbridge.msdk.foundation.entity.CampaignEx.a a(org.json.JSONObject r3) {
            /*
                r0 = 0
                if (r3 == 0) goto L_0x0073
                com.mbridge.msdk.foundation.entity.CampaignEx$a r1 = new com.mbridge.msdk.foundation.entity.CampaignEx$a     // Catch:{ Exception -> 0x0069, all -> 0x005f }
                r1.<init>()     // Catch:{ Exception -> 0x0069, all -> 0x005f }
                java.lang.String r0 = "adchoice_icon"
                java.lang.String r0 = r3.optString(r0)     // Catch:{ Exception -> 0x005d, all -> 0x005b }
                r1.c = r0     // Catch:{ Exception -> 0x005d, all -> 0x005b }
                java.lang.String r0 = "adchoice_link"
                java.lang.String r0 = r3.optString(r0)     // Catch:{ Exception -> 0x005d, all -> 0x005b }
                r1.b = r0     // Catch:{ Exception -> 0x005d, all -> 0x005b }
                java.lang.String r0 = "adchoice_size"
                java.lang.String r0 = r3.optString(r0)     // Catch:{ Exception -> 0x005d, all -> 0x005b }
                r1.d = r0     // Catch:{ Exception -> 0x005d, all -> 0x005b }
                java.lang.String r2 = "ad_logo_link"
                java.lang.String r2 = r3.optString(r2)     // Catch:{ Exception -> 0x005d, all -> 0x005b }
                r1.a = r2     // Catch:{ Exception -> 0x005d, all -> 0x005b }
                java.lang.String r2 = "adv_logo"
                java.lang.String r2 = r3.optString(r2)     // Catch:{ Exception -> 0x005d, all -> 0x005b }
                r1.h = r2     // Catch:{ Exception -> 0x005d, all -> 0x005b }
                java.lang.String r2 = "adv_name"
                java.lang.String r2 = r3.optString(r2)     // Catch:{ Exception -> 0x005d, all -> 0x005b }
                r1.g = r2     // Catch:{ Exception -> 0x005d, all -> 0x005b }
                java.lang.String r2 = "platform_logo"
                java.lang.String r2 = r3.optString(r2)     // Catch:{ Exception -> 0x005d, all -> 0x005b }
                r1.f = r2     // Catch:{ Exception -> 0x005d, all -> 0x005b }
                java.lang.String r2 = "platform_name"
                java.lang.String r2 = r3.optString(r2)     // Catch:{ Exception -> 0x005d, all -> 0x005b }
                r1.e = r2     // Catch:{ Exception -> 0x005d, all -> 0x005b }
                int r2 = b(r0)     // Catch:{ Exception -> 0x005d, all -> 0x005b }
                r1.j = r2     // Catch:{ Exception -> 0x005d, all -> 0x005b }
                int r0 = c(r0)     // Catch:{ Exception -> 0x005d, all -> 0x005b }
                r1.i = r0     // Catch:{ Exception -> 0x005d, all -> 0x005b }
                java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x005d, all -> 0x005b }
                r1.k = r3     // Catch:{ Exception -> 0x005d, all -> 0x005b }
                goto L_0x0074
            L_0x005b:
                r3 = move-exception
                goto L_0x0061
            L_0x005d:
                r3 = move-exception
                goto L_0x006b
            L_0x005f:
                r3 = move-exception
                r1 = r0
            L_0x0061:
                boolean r0 = com.mbridge.msdk.MBridgeConstans.DEBUG
                if (r0 == 0) goto L_0x0074
                r3.printStackTrace()
                goto L_0x0074
            L_0x0069:
                r3 = move-exception
                r1 = r0
            L_0x006b:
                boolean r0 = com.mbridge.msdk.MBridgeConstans.DEBUG
                if (r0 == 0) goto L_0x0074
                r3.printStackTrace()
                goto L_0x0074
            L_0x0073:
                r1 = r0
            L_0x0074:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.entity.CampaignEx.a.a(org.json.JSONObject):com.mbridge.msdk.foundation.entity.CampaignEx$a");
        }

        private static int b(String str) {
            String[] split;
            if (TextUtils.isEmpty(str)) {
                return 0;
            }
            try {
                if (str.contains("x") && (split = str.split("x")) != null && split.length > 1) {
                    return Integer.parseInt(split[1]);
                }
            } catch (Exception | NumberFormatException unused) {
            }
            return 0;
        }

        private static int c(String str) {
            String[] split;
            if (TextUtils.isEmpty(str)) {
                return 0;
            }
            try {
                if (str.contains("x") && (split = str.split("x")) != null && split.length > 0) {
                    return Integer.parseInt(split[0]);
                }
            } catch (Exception | NumberFormatException unused) {
            }
            return 0;
        }
    }

    public boolean isSpareOffer(long j, long j2) {
        if (isEffectiveOffer(j)) {
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (getPlctb() > 0) {
            if (getTimestamp() + (getPlctb() * 1000) >= currentTimeMillis) {
                return true;
            }
            return false;
        } else if (getTimestamp() + j2 >= currentTimeMillis) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isEffectiveOffer(long j) {
        long currentTimeMillis = System.currentTimeMillis();
        if (getPlct() > 0) {
            if (getTimestamp() + (getPlct() * 1000) >= currentTimeMillis) {
                return true;
            }
            return false;
        } else if (getTimestamp() + j >= currentTimeMillis) {
            return true;
        } else {
            return false;
        }
    }

    public String getOmid() {
        return this.omid;
    }

    public void setOmid(String str) {
        this.omid = str;
    }

    public boolean isActiveOm() {
        return !TextUtils.isEmpty(this.omid) && !TextUtils.isEmpty(MBridgeConstans.OMID_JS_SERVICE_URL);
    }

    public int getCbt() {
        return this.cbt;
    }

    public void setCbt(int i) {
        this.cbt = i;
    }

    public String getPlacementId() {
        return this.placementId;
    }

    public void setPlacementId(String str) {
        this.placementId = str;
    }

    public boolean needShowIDialog() {
        return super.needShowIDialog(this);
    }

    public long getcVersionCode() {
        return this.cVersionCode;
    }

    public void setcVersionCode(long j) {
        this.cVersionCode = j;
    }

    public ArrayList<Integer> getRsIgnoreCheckRule() {
        return this.rsIgnoreCheckRule;
    }

    public String getRsIgnoreCheckRuleString() {
        if (getRsIgnoreCheckRule() == null || getRsIgnoreCheckRule().size() <= 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        try {
            Iterator<Integer> it = getRsIgnoreCheckRule().iterator();
            while (it.hasNext()) {
                sb.append(it.next());
                sb.append(",");
            }
            if (sb.length() > 0) {
                sb.delete(sb.length() - 1, sb.length());
            }
            if (!TextUtils.isEmpty(sb)) {
                return sb.toString();
            }
            return "";
        } catch (Throwable th) {
            q.d(TAG, th.getMessage());
            return "";
        }
    }

    public void setRsIgnoreCheckRule(ArrayList<Integer> arrayList) {
        this.rsIgnoreCheckRule = arrayList;
    }

    public void setRsIgnoreCheckRuleByString(String str) {
        if (!TextUtils.isEmpty(str)) {
            String[] split = str.split(",");
            if (split.length > 0) {
                ArrayList arrayList = new ArrayList();
                for (String parseInt : split) {
                    arrayList.add(Integer.valueOf(Integer.parseInt(parseInt)));
                }
                setRsIgnoreCheckRule(arrayList);
            }
        }
    }

    public int getVideoCheckType() {
        return this.videoCheckType;
    }

    public void setVideoCheckType(int i) {
        if (i > 2 || i < 1) {
            this.videoCheckType = 2;
        } else {
            this.videoCheckType = i;
        }
    }

    public int getVideoCtnType() {
        return this.videoCtnType;
    }

    public void setVideoCtnType(int i) {
        if (i > 2 || i < 1) {
            this.videoCtnType = 1;
        } else {
            this.videoCtnType = i;
        }
    }

    public int getIsTimeoutCheckVideoStatus() {
        return this.isTimeoutCheckVideoStatus;
    }

    public void setIsTimeoutCheckVideoStatus(int i) {
        this.isTimeoutCheckVideoStatus = i;
    }

    public void setCanStart2C1Anim(boolean z) {
        this.canStart2C1Anim = z;
    }

    public boolean getCanStart2C1Anim() {
        return this.canStart2C1Anim;
    }

    public void setCanStartMoreOfferAnim(boolean z) {
        this.canStartMoreOfferAnim = z;
    }

    public boolean getCanStartMoreOfferAnim() {
        return this.canStartMoreOfferAnim;
    }
}
