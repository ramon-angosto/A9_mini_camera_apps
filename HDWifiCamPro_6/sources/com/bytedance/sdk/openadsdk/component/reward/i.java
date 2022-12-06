package com.bytedance.sdk.openadsdk.component.reward;

import android.app.Activity;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.core.b;
import com.bytedance.sdk.openadsdk.core.m;
import com.bytedance.sdk.openadsdk.core.model.h;
import com.bytedance.sdk.openadsdk.core.model.n;
import com.mbridge.msdk.foundation.download.database.DownloadModel;
import java.net.URLEncoder;
import org.json.JSONObject;

/* compiled from: PlayableVerityHelper */
public class i {
    private static String a = "{\n\t\t\"ad_id\": \"1639941324071955\",\n\t\t\"app\": {\n\t\t\t\"app_name\": \"Mortals cultivate Immortals\",\n\t\t\t\"app_size\": 117644467,\n\t\t\t\"appleid\": \"0\",\n\t\t\t\"comment_num\": 7676,\n\t\t\t\"download_url\": \"\",\n\t\t\t\"package_name\": \"com.xyjx.frxx_190\",\n\t\t\t\"score\": 4\n\t\t},\n\t\t\"appstore_jump_type\": 0,\n\t\t\"button_text\": \"Click me to try\",\n\t\t\"click_url\": [],\n\t\t\"creative_type\": 6,\n\t\t\"description\": \"Open up for cultivating immortals, transform into gods in one day, ascend in two days, and a half-step immortal emperor in three days!\",\n\t\t\"download_conf\": {\n\t\t\t\"auto_control\": \"0\",\n\t\t\t\"auto_open\": 1,\n\t\t\t\"download_mode\": 0,\n\t\t\t\"download_type\": 1,\n\t\t\t\"if_suspend_download\": 1,\n\t\t\t\"support_multiple\": 0\n\t\t},\n\t\t\"ext\": \"{\\\"uid\\\": 65999808247, \\\"package_name\\\": \\\"com.union_test.toutiao\\\", \\\"rit\\\": 901121375, \\\"orit\\\": 900000000, \\\"ad_type\\\": 1, \\\"height\\\": 1920, \\\"pack_time\\\": 1563973281.779855, \\\"pricing\\\": 9, \\\"device_type\\\": \\\"ONEPLUS A3010\\\", \\\"promotion_type\\\": 0, \\\"is_sdk\\\": true, \\\"app_name\\\": \\\"APP\\\\u6d4b\\\\u8bd5\\\\u5a92\\\\u4f53\\\", \\\"uuid\\\": \\\"862561035200672\\\", \\\"os_version\\\": \\\"8.0.0\\\", \\\"creative_id\\\": 1639941324071955, \\\"version_code\\\": \\\"2.3.0\\\", \\\"vid\\\": \\\"1024067,1016869,994044,994829,774109,657281,1001615,995476,1000478,1031346,945702,1025028,953637,987200,1034690,1025294,936646,1022401,1022406,774117,777874,1025520,762536\\\", \\\"uuid_md5\\\": \\\"83d508d01db531b4cf4843d2e41348ed\\\", \\\"width\\\": 1080, \\\"template_rate\\\": 0, \\\"src_type\\\": \\\"app\\\", \\\"img_gen_type\\\": 0, \\\"ad_id\\\": 1639940885031987, \\\"convert_id\\\": 1639938850817027, \\\"img_md5\\\": \\\"\\\", \\\"ad_price\\\": \\\"XThCVgADKYpdOEJWAAMpijdExKKDLYCp1GNXWw\\\", \\\"app_id\\\": \\\"5001121\\\", \\\"source_type\\\": 1, \\\"mac\\\": \\\"C0:EE:FB:F1:D4:80\\\", \\\"imei\\\": \\\"862561035200672\\\", \\\"ug_creative_id\\\": \\\"\\\", \\\"device_id\\\": 38167681029, \\\"landing_type\\\": 3, \\\"language\\\": \\\"golang\\\", \\\"cid\\\": 1639941324071955, \\\"ut\\\": 12, \\\"interaction_type\\\": 4, \\\"open_udid\\\": \\\"\\\", \\\"pos\\\": 5, \\\"req_id\\\": \\\"0781feb2-bf4b-4ff8-be68-9149e288a420u6714\\\", \\\"is_dsp_ad\\\": false, \\\"ad_slot_type\\\": 8, \\\"os_type\\\": null, \\\"os\\\": \\\"android\\\", \\\"template_id\\\": 7000003}\",\n\t\t\"filter_words\": [{\n\t\t\t\"id\": \"4:2\",\n\t\t\t\"is_selected\": false,\n\t\t\t\"name\": \"seen it already\"\n\t\t}, {\n\t\t\t\"id\": \"4:1\",\n\t\t\t\"is_selected\": false,\n\t\t\t\"name\": \"not interested\"\n\t\t}, {\n\t\t\t\"id\": \"4:3\",\n\t\t\t\"is_selected\": false,\n\t\t\t\"name\": \"Too many ads\"\n\t\t}, {\n\t\t\t\"id\": \"6:0\",\n\t\t\t\"is_selected\": false,\n\t\t\t\"name\": \"Report spam\",\n\t\t\t\"options\": [{\n\t\t\t\t\"id\": \"6:1\",\n\t\t\t\t\"is_selected\": false,\n\t\t\t\t\"name\": \"Vulgar porn\"\n\t\t\t}, {\n\t\t\t\t\"id\": \"6:2\",\n\t\t\t\t\"is_selected\": false,\n\t\t\t\t\"name\": \"False fraud\"\n\t\t\t}, {\n\t\t\t\t\"id\": \"6:3\",\n\t\t\t\t\"is_selected\": false,\n\t\t\t\t\"name\": \"Headline exaggeration\"\n\t\t\t}, {\n\t\t\t\t\"id\": \"6:4\",\n\t\t\t\t\"is_selected\": false,\n\t\t\t\t\"name\": \"Suspected plagiarism\"\n\t\t\t}]\n\t\t}],\n\t\t\"image_mode\": 15,\n\t\t\"in_app\": true,\n\t\t\"interaction_type\": 4,\n\t\t\"intercept_flag\": 1,\n\t\t\"is_playable\": true,\n\t\t\"media_ext\": {\n\t\t\t\"price\": 6027\n\t\t},\n\t\t\"play_bar_show_time\": -1,\n\t\t\"play_bar_style\": 0,\n\t\t\"screenshot\": false,\n\t\t\"show_url\": [],\n\t\t\"target_url\": \"\",\n\t\t\"temp_extra_info\": \"{\\\"img_gen_type\\\":0,\\\"img_md5\\\":\\\"\\\",\\\"template_id\\\":7000003}\",\n\t\t\"template_id\": 0,\n\t\t\"title\": \"Open up for cultivating immortals, transform into gods in one day, ascend in two days, and a half-step immortal emperor in three days!\",\n\t\t\"union_special\": 1,\n\t\t\"video\": {\n\t\t\t\"cover_height\": 1280,\n\t\t\t\"cover_url\": \"https://p16-sign-sg.tiktokcdn.com/v0201/fd71964ced204df586b63b9d8fa3198a~tplv-noop.image?x-expires=1618223773&x-signature=kFdR%2FbhUPOk2d9%2BYONSV0inUEMk%3D\",\n\t\t\t\"cover_width\": 720,\n\t\t\t\"endcard\": \"https://api16-endcard-pack-sg.pangle.io/union/endcard/1695802627329057/?rit=901121365&req_id=68ebda22-9cbd-423f-98ce-78f571b6308bu5599&ad_sdk_version=3.6.0.0&os=android&lang=zh&union_imei=702f89a658bd1f189c6e8e24587cd9ce&app_version=%E8%A1%A5%E5%85%85%E4%B8%AD&app_name=&developer_name=%E8%A1%A5%E5%85%85%E4%B8%AD%EF%BC%8C%E5%8F%AF%E4%BA%8E%E5%BA%94%E7%94%A8%E5%AE%98%E7%BD%91%E6%9F%A5%E7%9C%8B&is_dsp=False&lpt=1&style_id=1535776&comment_num=92&like_num=109&share_num=96\",\n\t\t\t\"file_hash\": \"eb321fa50173a95c041b0389a565b006\",\n\t\t\t\"resolution\": \"720x1280\",\n\t\t\t\"size\": 3410585,\n\t\t\t\"video_duration\": 7,\n\t\t\t\"video_url\": \"https://sf16-scmcdn-sg.ibytedtos.com/obj/goofy-sg/ad/pangle/homepage/_next/static/assets/images/reward.c7cdf2f9.mp4\"\n\t\t}\n\t}";

    public static void a(String str, int i, String str2, String str3, String str4) {
        try {
            n a2 = b.a(new JSONObject(a));
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("id", "1641194171089955");
            jSONObject.put("pkg_name", URLEncoder.encode(str3));
            jSONObject.put(DownloadModel.DOWNLOAD_URL, Uri.encode(str2, "/"));
            jSONObject.put("external_url", "");
            jSONObject.put("name", URLEncoder.encode("Eliminate the virus"));
            String str5 = str + "?is_test_tool=1&toutiao_card_params=" + URLEncoder.encode(jSONObject.toString());
            if (a2 != null) {
                if (a2.J() != null) {
                    a2.J().d(str5);
                }
                if (a2.aa() != null) {
                    if (!TextUtils.isEmpty(str2)) {
                        a2.aa().a(str2);
                        a2.aa().b("Test the downloaded app");
                    } else {
                        a2.aa().a((String) null);
                        a2.aa().b("");
                    }
                    if (!TextUtils.isEmpty(str2)) {
                        a2.aa().c(str3);
                    } else {
                        str2 = str4;
                    }
                    if (!TextUtils.isEmpty(str2)) {
                        if (a2.ab() != null) {
                            a2.ab().a(str2);
                        } else {
                            h hVar = new h();
                            hVar.a(str2);
                            a2.a(hVar);
                        }
                    }
                }
                if (i == 1) {
                    a2.s(15);
                } else {
                    a2.s(5);
                }
            }
            o oVar = new o(m.a(), a2, new AdSlot.Builder().build());
            oVar.a(true);
            oVar.showFullScreenVideoAd((Activity) null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
