package com.mbridge.msdk.click;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.e.b;
import com.mbridge.msdk.system.NoProGuard;
import java.io.Serializable;

public final class CommonJumpLoader extends c {
    JumpLoaderResult a = null;
    private int b = 0;
    private String c = null;
    private d d = null;
    private boolean e = true;
    private b f;
    private g g;
    private Handler h = new Handler(Looper.getMainLooper());

    public CommonJumpLoader(Context context) {
        this.f = new b(context);
        this.g = new g(context);
    }

    public final void a(String str, CampaignEx campaignEx, d dVar, String str2, boolean z, boolean z2) {
        String str3;
        this.c = str2;
        this.d = dVar;
        this.a = null;
        boolean z3 = false;
        if (campaignEx != null) {
            if ("5".equals(campaignEx.getClick_mode()) || "6".equals(campaignEx.getClick_mode())) {
                z3 = true;
            }
            str3 = campaignEx.getId();
        } else {
            str3 = "";
        }
        String str4 = str3;
        this.g.a(str2, dVar, z3, str4, str, campaignEx, z, z2);
    }

    public final void a(String str, CampaignEx campaignEx, d dVar) {
        this.c = new String(campaignEx.getClickURL());
        this.d = dVar;
        this.a = null;
        this.g.a(campaignEx.getClickURL(), dVar, "5".equals(campaignEx.getClick_mode()) || "6".equals(campaignEx.getClick_mode()), campaignEx.getId(), str, campaignEx, true, false);
    }

    public final void a() {
        this.e = false;
    }

    public static class JumpLoaderResult implements NoProGuard, Serializable {
        public static final int CODE_DOWNLOAD = 3;
        public static final int CODE_LINK = 2;
        public static final int CODE_MARKET = 1;
        public static final int CODE_NULL = 4;
        private static final long serialVersionUID = 1;
        private int code;
        private String content;
        private String exceptionMsg;
        private String header;
        private boolean is302Jump;
        private boolean jumpDone;
        private String msg;
        private String noticeurl;
        private int statusCode;
        private boolean success;
        private int type;
        private String url;

        public int getStatusCode() {
            return this.statusCode;
        }

        public void setStatusCode(int i) {
            this.statusCode = i;
        }

        public boolean isIs302Jump() {
            return this.is302Jump;
        }

        public void setIs302Jump(boolean z) {
            this.is302Jump = z;
        }

        public int getType() {
            return this.type;
        }

        public void setType(int i) {
            this.type = i;
        }

        public String getHeader() {
            return this.header;
        }

        public void setHeader(String str) {
            this.header = str;
        }

        public String getExceptionMsg() {
            return this.exceptionMsg;
        }

        public void setExceptionMsg(String str) {
            this.exceptionMsg = str;
        }

        public String getContent() {
            return this.content;
        }

        public void setContent(String str) {
            this.content = str;
        }

        public String getNoticeurl() {
            return this.noticeurl;
        }

        public void setNoticeurl(String str) {
            this.noticeurl = str;
        }

        public boolean isSuccess() {
            return this.success;
        }

        public void setSuccess(boolean z) {
            this.success = z;
        }

        public String getMsg() {
            return this.msg;
        }

        public void setMsg(String str) {
            this.msg = str;
        }

        public int getCode() {
            return this.code;
        }

        public void setCode(int i) {
            this.code = i;
        }

        public String getUrl() {
            return this.url;
        }

        public void setUrl(String str) {
            this.url = str;
        }

        public boolean isjumpDone() {
            return this.jumpDone;
        }

        public void setjumpDone(boolean z) {
            this.jumpDone = z;
        }
    }
}
