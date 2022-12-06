package com.bykv.vk.openvk.component.video.a.b.e;

import com.bykv.vk.openvk.component.video.a.b.i;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import java.io.InputStream;
import java.util.List;
import ms.bd.o.Pgl.c;

/* compiled from: AbsResponseWrapper */
public abstract class a {
    List<i.b> a;
    e b;

    public abstract int a();

    /* access modifiers changed from: protected */
    public String a(int i) {
        switch (i) {
            case 200:
                return "OK";
            case 201:
                return "Created";
            case 202:
                return "Accepted";
            case 203:
                return "Non-Authoritative";
            case 204:
                return "No Content";
            case 205:
                return "Reset Content";
            case 206:
                return "Partial Content";
            default:
                switch (i) {
                    case c.COLLECT_MODE_FINANCE /*300*/:
                        return "Multiple Choices";
                    case 301:
                        return "Moved Permanently";
                    case IronSourceConstants.OFFERWALL_AVAILABLE /*302*/:
                        return "Temporary Redirect";
                    case 303:
                        return "See Other";
                    case 304:
                        return "Not Modified";
                    case IronSourceConstants.OFFERWALL_OPENED /*305*/:
                        return "Use Proxy";
                    default:
                        switch (i) {
                            case 400:
                                return "Bad Request";
                            case TTAdConstant.MATE_IS_NULL_CODE /*401*/:
                                return "Unauthorized";
                            case TTAdConstant.AD_ID_IS_NULL_CODE /*402*/:
                                return "Payment Required";
                            case TTAdConstant.DEEPLINK_UNAVAILABLE_CODE /*403*/:
                                return "Forbidden";
                            case TTAdConstant.DEEPLINK_FALLBACK_CODE /*404*/:
                                return "Not Found";
                            case TTAdConstant.DEEPLINK_FALLBACK_TYPE_CODE /*405*/:
                                return "Method Not Allowed";
                            case TTAdConstant.LANDING_PAGE_TYPE_CODE /*406*/:
                                return "Not Acceptable";
                            case TTAdConstant.DOWNLOAD_APP_INFO_CODE /*407*/:
                                return "Proxy Authentication Required";
                            case TTAdConstant.DOWNLOAD_URL_CODE /*408*/:
                                return "Request Time-Out";
                            case TTAdConstant.IMAGE_LIST_CODE /*409*/:
                                return "Conflict";
                            case TTAdConstant.IMAGE_LIST_SIZE_CODE /*410*/:
                                return "Gone";
                            case TTAdConstant.IMAGE_CODE /*411*/:
                                return "Length Required";
                            case TTAdConstant.IMAGE_URL_CODE /*412*/:
                                return "Precondition Failed";
                            case TTAdConstant.VIDEO_INFO_CODE /*413*/:
                                return "Request Entity Too Large";
                            case TTAdConstant.VIDEO_URL_CODE /*414*/:
                                return "Request-URI Too Large";
                            case TTAdConstant.VIDEO_COVER_URL_CODE /*415*/:
                                return "Unsupported Media Type";
                            default:
                                switch (i) {
                                    case 500:
                                        return "Internal Server Error";
                                    case IronSourceError.ERROR_CODE_NO_CONFIGURATION_AVAILABLE /*501*/:
                                        return "Not Implemented";
                                    case IronSourceError.ERROR_CODE_USING_CACHED_CONFIGURATION /*502*/:
                                        return "Bad Gateway";
                                    case 503:
                                        return "Service Unavailable";
                                    case c.COLLECT_MODE_TIKTOK_GUEST /*504*/:
                                        return "Gateway Timeout";
                                    case IronSourceError.ERROR_CODE_KEY_NOT_SET /*505*/:
                                        return "HTTP Version Not Supported";
                                    default:
                                        return "";
                                }
                        }
                }
        }
    }

    public abstract String a(String str, String str2);

    public abstract boolean b();

    public abstract List<i.b> c();

    public abstract InputStream d();

    public abstract String e();

    public abstract String f();

    public e g() {
        return this.b;
    }

    /* access modifiers changed from: protected */
    public i.b a(String str) {
        List<i.b> list;
        if (!(str == null || (list = this.a) == null || list.size() <= 0)) {
            for (i.b next : this.a) {
                if (str.equals(next.a)) {
                    return next;
                }
            }
        }
        return null;
    }
}
