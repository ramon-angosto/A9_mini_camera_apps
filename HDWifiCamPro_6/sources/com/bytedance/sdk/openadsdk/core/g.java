package com.bytedance.sdk.openadsdk.core;

import com.bytedance.sdk.component.utils.t;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import ms.bd.o.Pgl.c;

/* compiled from: ErrorCode */
public class g {
    public static String b(int i) {
        switch (i) {
            case c.COLLECT_MODE_FINANCE /*300*/:
                return "Missing title";
            case 301:
                return "Missing description";
            case IronSourceConstants.OFFERWALL_AVAILABLE /*302*/:
                return "Missing cta";
            case 303:
                return "Missing score";
            case 304:
                return "Missing comment";
            case IronSourceConstants.OFFERWALL_OPENED /*305*/:
                return "Missing icon";
            default:
                return "";
        }
    }

    public static String a(int i) {
        if (i == -100) {
            return t.a(m.a(), "tt_init_setting_config_not_complete");
        }
        if (i == 113) {
            return "dynamic1 parse error";
        }
        if (i == 123) {
            return "dynamic2 parse error";
        }
        if (i == 20001) {
            return t.a(m.a(), "tt_no_ad");
        }
        if (i == 50001) {
            return t.a(m.a(), "tt_sys_error");
        }
        if (i == 60007) {
            return t.a(m.a(), "tt_error_verify_reward");
        }
        if (i == -16) {
            return t.a(m.a(), "tt_error_ad_able_false_msg");
        }
        if (i == -15) {
            return t.a(m.a(), "tt_lack_android_manifest_configuration");
        }
        if (i == 117) {
            return "dynamic1 render time_out";
        }
        if (i == 118) {
            return "dynamic1 render error";
        }
        if (i == 127) {
            return "dynamic2 render time_out";
        }
        if (i == 128) {
            return "dynamic2 render error";
        }
        if (i == 201) {
            return t.a(m.a(), "tt_load_creative_icon_response_error");
        }
        if (i == 202) {
            return t.a(m.a(), "tt_load_creative_icon_error");
        }
        if (i == 10002) {
            return "load time out";
        }
        if (i == 10003) {
            return "resource error";
        }
        switch (i) {
            case -12:
                return t.a(m.a(), "tt_splash_not_have_cache_error");
            case -11:
                return t.a(m.a(), "tt_splash_cache_expired_error");
            case -10:
                return t.a(m.a(), "tt_splash_cache_parse_error");
            case -9:
                return t.a(m.a(), "tt_request_body_error");
            case -8:
                return t.a(m.a(), "tt_frequent_call_erroe");
            case -7:
                return t.a(m.a(), "tt_splash_ad_load_image_error");
            case -6:
                return t.a(m.a(), "tt_insert_ad_load_image_error");
            case C.RESULT_FORMAT_READ /*-5*/:
                return t.a(m.a(), "tt_banner_ad_load_image_error");
            case -4:
                return t.a(m.a(), "tt_ad_data_error");
            case -3:
                return t.a(m.a(), "tt_no_ad_parse");
            case -2:
                return t.a(m.a(), "tt_net_error");
            case -1:
                return t.a(m.a(), "tt_parse_fail");
            default:
                switch (i) {
                    case 101:
                        return t.a(m.a(), "tt_render_render_parse_error");
                    case 102:
                        return t.a(m.a(), "tt_render_main_template_invalid");
                    case 103:
                        return t.a(m.a(), "tt_render_diff_template_invalid");
                    case 104:
                        return t.a(m.a(), "tt_render_fail_meta_invalid");
                    case 105:
                        return t.a(m.a(), "tt_render_fail_template_parse_error");
                    case 106:
                        return t.a(m.a(), "tt_render_fail_unknown");
                    case 107:
                        return t.a(m.a(), "tt_render_fail_timeout");
                    case 108:
                        return t.a(m.a(), "tt_reder_ad_load_timeout");
                    case 109:
                        return t.a(m.a(), "tt_template_load_fail");
                    default:
                        switch (i) {
                            case 40000:
                                return t.a(m.a(), "tt_content_type");
                            case 40001:
                                return t.a(m.a(), "tt_request_pb_error");
                            case 40002:
                                return t.a(m.a(), "tt_app_empty");
                            case 40003:
                                return t.a(m.a(), "tt_wap_empty");
                            case 40004:
                                return t.a(m.a(), "tt_adslot_empty");
                            case 40005:
                                return t.a(m.a(), "tt_adslot_size_empty");
                            case 40006:
                                return t.a(m.a(), "tt_adslot_id_error");
                            case 40007:
                                return t.a(m.a(), "tt_error_code_adcount_error");
                            case 40008:
                                return t.a(m.a(), "tt_error_image_size");
                            case 40009:
                                return t.a(m.a(), "tt_error_media_id");
                            case 40010:
                                return t.a(m.a(), "tt_error_media_type");
                            case 40011:
                                return t.a(m.a(), "tt_error_ad_type");
                            case 40012:
                            case 40017:
                                return t.a(m.a(), "tt_error_access_method_pass");
                            case 40013:
                                return t.a(m.a(), "tt_error_splash_ad_type");
                            case 40014:
                                return t.a(m.a(), "tt_error_redirect");
                            case 40015:
                                return t.a(m.a(), "tt_error_request_invalid");
                            case 40016:
                                return t.a(m.a(), "tt_error_slot_id_app_id_differ");
                            case 40018:
                                return t.a(m.a(), "tt_error_package_name");
                            case 40019:
                                return t.a(m.a(), "tt_error_adtype_differ");
                            case 40020:
                                return t.a(m.a(), "tt_error_new_register_limit");
                            case 40021:
                                return t.a(m.a(), "tt_error_apk_sign_check_error");
                            case 40022:
                                return t.a(m.a(), "tt_error_origin_ad_error");
                            case 40023:
                                return t.a(m.a(), "tt_error_union_os_error");
                            case 40024:
                                return t.a(m.a(), "tt_error_union_sdk_too_old");
                            default:
                                switch (i) {
                                    case 60001:
                                        return t.a(m.a(), "tt_ror_code_show_event_error");
                                    case 60002:
                                        return t.a(m.a(), "tt_error_code_click_event_error");
                                    default:
                                        return t.a(m.a(), "tt_error_unknow");
                                }
                        }
                }
        }
    }
}
