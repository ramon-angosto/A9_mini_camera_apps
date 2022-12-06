package com.bytedance.sdk.openadsdk.l;

import android.text.TextUtils;
import com.bytedance.sdk.component.utils.l;
import com.bytedance.sdk.openadsdk.core.m;
import com.bytedance.sdk.openadsdk.core.model.n;
import java.util.Map;

/* compiled from: TTClientBiddingUtil */
public class s {
    public static void a(n nVar, Double d) {
        if (nVar != null && nVar.aj() != null) {
            Map<String, Object> aj = nVar.aj();
            try {
                Object obj = nVar.aj().get("sdk_bidding_type");
                if (obj == null) {
                    return;
                }
                if (Integer.parseInt(obj.toString()) == 2) {
                    String str = (String) aj.get("nurl");
                    if (!TextUtils.isEmpty(str)) {
                        if (d != null) {
                            str = str.replace("${AUCTION_BID_TO_WIN}", String.valueOf(d));
                        }
                        m.c().a(str);
                    }
                }
            } catch (Throwable unused) {
                l.d("report Win error");
            }
        }
    }

    public static void a(n nVar, Double d, String str, String str2) {
        if (nVar != null && nVar.aj() != null) {
            Map<String, Object> aj = nVar.aj();
            try {
                Object obj = nVar.aj().get("sdk_bidding_type");
                if (obj == null) {
                    return;
                }
                if (Integer.parseInt(obj.toString()) == 2) {
                    String str3 = (String) aj.get("lurl");
                    if (!TextUtils.isEmpty(str3)) {
                        if (d != null) {
                            str3 = str3.replace("${AUCTION_PRICE}", String.valueOf(d));
                        }
                        if (str != null) {
                            str3 = str3.replace("${AUCTION_LOSS}", str);
                        }
                        if (str2 != null) {
                            str3 = str3.replace("${AUCTION_WINNER}", str2);
                        }
                        m.c().a(str3);
                    }
                }
            } catch (Throwable unused) {
                l.d("report Loss error");
            }
        }
    }
}
