package com.mbridge.msdk.video.module.b;

import android.content.Context;
import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.net.g.d;
import com.mbridge.msdk.foundation.same.report.d.b;
import com.mbridge.msdk.foundation.tools.l;
import com.mbridge.msdk.foundation.tools.q;
import com.mbridge.msdk.videocommon.b.c;
import com.vungle.warren.model.ReportDBAdapter;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: VideoViewReport */
public final class a {
    public static HashMap<String, ArrayList<String>> a = new HashMap<>();

    public static void a(String str) {
        a.remove(str);
    }

    public static void a(String str, String str2) {
        try {
            if (com.mbridge.msdk.foundation.controller.a.e().g() != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                new com.mbridge.msdk.foundation.same.report.d.a(com.mbridge.msdk.foundation.controller.a.e().g()).c(0, d.c().a, com.mbridge.msdk.foundation.same.report.d.a(str, com.mbridge.msdk.foundation.controller.a.e().g(), str2), new b() {
                    public final void a(String str) {
                        q.d("VideoViewReport", str);
                    }

                    public final void b(String str) {
                        q.d("VideoViewReport", str);
                    }
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
            q.d("VideoViewReport", e.getMessage());
        }
    }

    public static void a(Context context, CampaignEx campaignEx) {
        if (campaignEx != null && campaignEx.getNativeVideoTracking() != null && campaignEx.getNativeVideoTracking().i() != null) {
            com.mbridge.msdk.click.a.a(context, campaignEx, campaignEx.getCampaignUnitId(), campaignEx.getNativeVideoTracking().i(), false, false);
        }
    }

    public static void b(Context context, CampaignEx campaignEx) {
        if (campaignEx != null && campaignEx.getNativeVideoTracking() != null && campaignEx.getNativeVideoTracking().c() != null) {
            com.mbridge.msdk.click.a.a(context, campaignEx, campaignEx.getCampaignUnitId(), campaignEx.getNativeVideoTracking().c(), false, false);
        }
    }

    public static void c(Context context, CampaignEx campaignEx) {
        if (campaignEx != null && campaignEx.getNativeVideoTracking() != null && campaignEx.getNativeVideoTracking().d() != null) {
            com.mbridge.msdk.click.a.a(context, campaignEx, campaignEx.getCampaignUnitId(), campaignEx.getNativeVideoTracking().d(), false, false);
        }
    }

    public static void d(Context context, CampaignEx campaignEx) {
        if (campaignEx != null && campaignEx.getNativeVideoTracking() != null && campaignEx.getNativeVideoTracking().e() != null) {
            String campaignUnitId = campaignEx.getCampaignUnitId();
            ArrayList arrayList = a.get(campaignUnitId);
            if (arrayList == null) {
                arrayList = new ArrayList();
                a.put(campaignUnitId, arrayList);
            }
            if (!arrayList.contains(campaignEx.getId())) {
                com.mbridge.msdk.click.a.a(context, campaignEx, campaignEx.getCampaignUnitId(), campaignEx.getNativeVideoTracking().e(), false, false);
                arrayList.add(campaignEx.getId());
            }
        }
    }

    public static void a(Context context, CampaignEx campaignEx, int i, int i2) {
        String str;
        try {
            String[] j = campaignEx.getNativeVideoTracking().j();
            if (campaignEx != null && campaignEx.getNativeVideoTracking() != null && j != null) {
                String[] strArr = new String[j.length];
                for (int i3 = 0; i3 < j.length; i3++) {
                    String str2 = j[i3];
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("endscreen_type", i);
                    String jSONObject2 = jSONObject.toString();
                    String str3 = str2 + "&value=" + URLEncoder.encode(l.a(jSONObject2));
                    if (campaignEx.getSpareOfferFlag() == 1) {
                        str = str3 + "&to=1&cbt=" + campaignEx.getCbt() + "&tmorl=" + i2;
                    } else {
                        str = str3 + "&to=0&cbt=" + campaignEx.getCbt() + "&tmorl=" + i2;
                    }
                    strArr[i3] = str;
                }
                com.mbridge.msdk.click.a.a(context, campaignEx, campaignEx.getCampaignUnitId(), strArr, false, true);
            }
        } catch (Throwable unused) {
            q.d("VideoViewReport", "reportEndcardshowData error");
        }
    }

    public static void e(Context context, CampaignEx campaignEx) {
        if (campaignEx != null && campaignEx.getNativeVideoTracking() != null && campaignEx.getNativeVideoTracking().k() != null) {
            com.mbridge.msdk.click.a.a(context, campaignEx, campaignEx.getCampaignUnitId(), campaignEx.getNativeVideoTracking().k(), false, false);
        }
    }

    public static void f(Context context, CampaignEx campaignEx) {
        if (campaignEx != null && campaignEx.getNativeVideoTracking() != null && campaignEx.getNativeVideoTracking().f() != null) {
            com.mbridge.msdk.click.a.a(context, campaignEx, campaignEx.getCampaignUnitId(), campaignEx.getNativeVideoTracking().f(), false, false);
        }
    }

    public static void a(Context context, CampaignEx campaignEx, int i, int i2, int i3) {
        int i4;
        String str;
        int i5 = i3;
        if (i2 != 0 && context != null && campaignEx != null) {
            try {
                List<Map<Integer, String>> b = campaignEx.getNativeVideoTracking().b();
                int i6 = ((i + 1) * 100) / i2;
                if (b != null) {
                    for (int i7 = 0; i7 < b.size(); i7 = i4 + 1) {
                        Map map = b.get(i7);
                        if (map == null || map.size() <= 0) {
                            i4 = i7;
                        } else {
                            Iterator it = map.entrySet().iterator();
                            i4 = i7;
                            while (it.hasNext()) {
                                Map.Entry entry = (Map.Entry) it.next();
                                int intValue = ((Integer) entry.getKey()).intValue();
                                String str2 = (String) entry.getValue();
                                if (campaignEx.getSpareOfferFlag() == 1) {
                                    str = str2 + "&to=1&cbt=" + campaignEx.getCbt() + "&tmorl=" + i5;
                                } else {
                                    str = str2 + "&to=0&cbt=" + campaignEx.getCbt() + "&tmorl=" + i5;
                                }
                                if (intValue <= i6 && !TextUtils.isEmpty(str)) {
                                    com.mbridge.msdk.click.a.a(context, campaignEx, campaignEx.getCampaignUnitId(), new String[]{str}, false, true);
                                    it.remove();
                                    b.remove(i4);
                                    i4--;
                                }
                            }
                        }
                    }
                }
            } catch (Throwable unused) {
                q.d("VideoViewReport", "reportPlayPercentageData error");
            }
        }
    }

    public static void a(CampaignEx campaignEx, Map<Integer, String> map, String str, int i) {
        if (campaignEx != null && map != null) {
            try {
                if (map.size() > 0) {
                    Iterator<Map.Entry<Integer, String>> it = map.entrySet().iterator();
                    while (it.hasNext()) {
                        Map.Entry next = it.next();
                        String str2 = (String) next.getValue();
                        if (i == ((Integer) next.getKey()).intValue() && !TextUtils.isEmpty(str2)) {
                            com.mbridge.msdk.click.a.a(com.mbridge.msdk.foundation.controller.a.e().g(), campaignEx, str, str2, false, false);
                            it.remove();
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void a(CampaignEx campaignEx, String str) {
        if (campaignEx != null) {
            try {
                if (campaignEx.getAdUrlList() != null && campaignEx.getAdUrlList().size() > 0) {
                    for (String next : campaignEx.getAdUrlList()) {
                        if (!TextUtils.isEmpty(next)) {
                            com.mbridge.msdk.click.a.a(com.mbridge.msdk.foundation.controller.a.e().g(), campaignEx, str, next, false, false);
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void a(CampaignEx campaignEx, c cVar, String str, String str2, String str3) {
        String str4 = "&";
        String str5 = "";
        if (campaignEx != null && cVar != null) {
            try {
                com.mbridge.msdk.video.module.c.a aVar = new com.mbridge.msdk.video.module.c.a(com.mbridge.msdk.foundation.controller.a.e().g());
                com.mbridge.msdk.foundation.same.net.h.d dVar = new com.mbridge.msdk.foundation.same.net.h.d();
                dVar.a(ReportDBAdapter.ReportColumns.COLUMN_USER_ID, l.a(str2));
                dVar.a("cb_type", "1");
                dVar.a(CampaignEx.JSON_KEY_REWARD_NAME, cVar.a());
                dVar.a(CampaignEx.JSON_KEY_REWARD_AMOUNT, cVar.b() + str5);
                dVar.a(MBridgeConstans.PROPERTIES_UNIT_ID, str);
                dVar.a("click_id", campaignEx.getRequestIdNotice());
                if (!TextUtils.isEmpty(str3)) {
                    dVar.a("extra", str3);
                }
                aVar.a(str5, dVar);
                String str6 = campaignEx.getHost() + "/addReward?";
                String trim = dVar.a().trim();
                if (!TextUtils.isEmpty(trim)) {
                    if (!str6.endsWith("?") && !str6.endsWith(str4)) {
                        StringBuilder sb = new StringBuilder();
                        sb.append(str6);
                        if (!str6.contains("?")) {
                            str4 = "?";
                        }
                        sb.append(str4);
                        str6 = sb.toString();
                    }
                    str5 = str6 + trim;
                }
                String str7 = str5;
                q.d("VideoViewReport", "rewardUrl:" + str7);
                com.mbridge.msdk.click.a.a(com.mbridge.msdk.foundation.controller.a.e().g(), campaignEx, campaignEx.getCampaignUnitId(), str7, false, false);
            } catch (Throwable th) {
                q.a("VideoViewReport", th.getMessage(), th);
            }
        }
    }
}
