package com.unad.sdk;

import android.content.Context;
import android.os.Build;
import com.aliyun.sls.android.producer.Log;
import com.aliyun.sls.android.producer.LogProducerCallback;
import com.aliyun.sls.android.producer.LogProducerClient;
import com.aliyun.sls.android.producer.LogProducerConfig;
import com.mbridge.msdk.MBridgeConstans;
import com.unad.sdk.dto.AlyLogDTO;
import java.util.Locale;

/* compiled from: AlyLogs */
public class b {
    private static b c;
    private LogProducerConfig a;
    private LogProducerClient b;

    /* compiled from: AlyLogs */
    class a implements LogProducerCallback {
        a(b bVar) {
        }

        public void onCall(int i, String str, String str2, int i2, int i3) {
        }
    }

    private b() {
    }

    public static b a() {
        if (c == null) {
            c = new b();
        }
        return c;
    }

    private void b(AlyLogDTO alyLogDTO, Context context) {
        try {
            if (UNAD.isOpenLogsBoolean) {
                Log a2 = a(alyLogDTO, context);
                LogProducerClient logProducerClient = this.b;
                if (logProducerClient != null) {
                    logProducerClient.addLog(a2, 1);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* access modifiers changed from: protected */
    public void c(Context context, String str, String str2, String str3, String str4) {
        if (context != null) {
            AlyLogDTO a2 = a(context, str4, str);
            a2.setShow_ad(str2);
            a2.setQuantity_request_valid("1");
            a2.setReal_request_valid("1");
            if (!a(str3)) {
                a2.setRequest_error(str3);
            }
            b(a2, context);
        }
    }

    /* access modifiers changed from: protected */
    public void d(Context context, String str, String str2, String str3, String str4) {
        if (context != null) {
            AlyLogDTO a2 = a(context, str4, str);
            a2.setShow_ad(str2);
            a2.setQuantity_reward("1");
            a2.setReal_reward("1");
            if (!a(str3)) {
                a2.setRequest_error(str3);
            }
            b(a2, context);
        }
    }

    /* access modifiers changed from: protected */
    public void e(Context context, String str, String str2, String str3, String str4) {
        if (context != null) {
            AlyLogDTO a2 = a(context, str4, str);
            a2.setShow_ad(str2);
            a2.setQuantity_show("1");
            a2.setReal_show("1");
            if (!a(str3)) {
                a2.setRequest_error(str3);
            }
            b(a2, context);
        }
    }

    /* access modifiers changed from: protected */
    public void a(Context context, String str) {
        if (UNAD.isOpenLogsBoolean) {
            try {
                LogProducerConfig logProducerConfig = new LogProducerConfig("https://cn-guangzhou.log.aliyuncs.com", "adgotest", "adgotest", "LTAI5t8GX5Bw9oFVBW3HoV38", "pgkLaz70GFIIT1dFxm53n6BxeE7In6");
                this.a = logProducerConfig;
                logProducerConfig.setPersistent(1);
                LogProducerConfig logProducerConfig2 = this.a;
                logProducerConfig2.setPersistentFilePath(context.getFilesDir() + "/" + str + "unadGWlog.dat");
                this.a.setPersistentForceFlush(1);
                this.a.setPersistentMaxFileCount(10);
                this.a.setPersistentMaxFileSize(1048576);
                this.a.setPersistentMaxLogCount(65536);
                this.b = new LogProducerClient(this.a, new a(this));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* access modifiers changed from: protected */
    public void b(Context context, String str, String str2, String str3, String str4) {
        if (context != null && !a(str2)) {
            AlyLogDTO a2 = a(context, str3, str);
            a2.setShow_ad(str4);
            a2.setRequest_error(str2);
            b(a2, context);
            new com.unad.sdk.util.b(context).a(com.unad.sdk.util.b.f, "");
        }
    }

    /* access modifiers changed from: protected */
    public AlyLogDTO a(Context context, String str, String str2) {
        AlyLogDTO alyLogDTO = new AlyLogDTO();
        alyLogDTO.setSdk_version(UNAD.VERSION);
        alyLogDTO.setApp_version(c.b(context));
        alyLogDTO.setClient_id(c.a(context));
        alyLogDTO.setService_id(UNAD.serviceId);
        alyLogDTO.setAd_type(str);
        alyLogDTO.setSpace_id(str2);
        return alyLogDTO;
    }

    private Log a(AlyLogDTO alyLogDTO, Context context) {
        Log log = new Log();
        log.putContent("sdk_version", alyLogDTO.getSdk_version());
        log.putContent("app_version", alyLogDTO.getApp_version());
        Locale locale = context.getResources().getConfiguration().locale;
        log.putContent("country", (locale.getCountry() + "").toUpperCase());
        if (alyLogDTO.getClient_id() != null) {
            log.putContent("client_id", alyLogDTO.getClient_id());
        }
        if (alyLogDTO.getService_id() != null && alyLogDTO.getService_id().length() > 0) {
            log.putContent("service_id", alyLogDTO.getService_id());
        }
        if (alyLogDTO.getApp_id() != null) {
            log.putContent("app_id", alyLogDTO.getApp_id());
        }
        log.putContent("space_id", alyLogDTO.getSpace_id());
        log.putContent("adtime", alyLogDTO.getAdtime());
        if (alyLogDTO.getQuantity_request() != null) {
            log.putContent("quantity_request", alyLogDTO.getQuantity_request() + "");
        }
        if (alyLogDTO.getReal_request() != null) {
            log.putContent("real_request", alyLogDTO.getReal_request() + "");
        }
        if (alyLogDTO.getQuantity_request_valid() != null) {
            log.putContent("quantity_request_valid", alyLogDTO.getQuantity_request_valid() + "");
        }
        if (alyLogDTO.getQuantity_show() != null) {
            log.putContent("quantity_show", alyLogDTO.getQuantity_show() + "");
        }
        if (alyLogDTO.getQuantity_click() != null) {
            log.putContent("quantity_click", alyLogDTO.getQuantity_click() + "");
        }
        if (alyLogDTO.getReal_request_valid() != null) {
            log.putContent("real_request_valid", alyLogDTO.getReal_request_valid() + "");
        }
        if (alyLogDTO.getReal_show() != null) {
            log.putContent("real_show", alyLogDTO.getReal_show() + "");
        }
        if (alyLogDTO.getReal_click() != null) {
            log.putContent("real_click", alyLogDTO.getReal_click() + "");
        }
        if (alyLogDTO.getDevice() != null) {
            log.putContent("device", alyLogDTO.getDevice());
        }
        if (alyLogDTO.getAd_type() != null) {
            log.putContent("ad_type", alyLogDTO.getAd_type());
        }
        if (alyLogDTO.getShow_ad() != null) {
            log.putContent("show_ad", alyLogDTO.getShow_ad() + "");
        }
        if (alyLogDTO.getQuantity_reward() != null) {
            log.putContent("quantity_reward", alyLogDTO.getQuantity_reward() + "");
        }
        if (alyLogDTO.getReal_reward() != null) {
            log.putContent("real_reward", alyLogDTO.getReal_reward() + "");
        }
        if (alyLogDTO.getRequest_error() != null) {
            log.putContent("request_error", alyLogDTO.getRequest_error() + ("##" + Build.VERSION.RELEASE + " " + Build.MODEL + " " + Build.BRAND));
        }
        return log;
    }

    private boolean a(String str) {
        return str == null || str.trim().length() == 0;
    }

    /* access modifiers changed from: protected */
    public void a(Context context, String str, String str2, String str3, String str4) {
        if (context != null) {
            AlyLogDTO a2 = a(context, str4, str);
            a2.setShow_ad(str2);
            a2.setQuantity_click("1");
            a2.setReal_click("1");
            if (!a(str3)) {
                a2.setRequest_error(str3);
            }
            b(a2, context);
        }
    }

    /* access modifiers changed from: protected */
    public void a(Context context, String str, boolean z, String str2, String str3) {
        if (context != null) {
            b a2 = a();
            AlyLogDTO a3 = a2.a(context, str3, str);
            if (z) {
                a3.setQuantity_request(MBridgeConstans.ENDCARD_URL_TYPE_PL);
            } else {
                a3.setQuantity_request("1");
            }
            a3.setReal_request("1");
            a3.setShow_ad(str2);
            a2.b(a3, context);
        }
    }
}
