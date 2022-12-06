package com.huawei.hms.framework.network.grs;

import android.content.Context;
import android.text.TextUtils;
import com.bumptech.glide.load.Key;
import com.huawei.hms.framework.common.ContainerUtils;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.network.grs.local.model.C0768a;
import com.huawei.hms.framework.network.grs.p014a.C0728c;
import com.huawei.hms.framework.network.grs.p015b.C0731b;
import com.huawei.hms.framework.network.grs.p019d.C0760b;
import com.xiaomi.mipush.sdk.Constants;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class GrsBaseInfo implements Cloneable {
    private static final String TAG = "GrsBaseInfo";
    private String androidVersion;
    private String appName;
    private String countrySource;
    private String deviceModel;
    private String issueCountry;
    private String regCountry;
    private String romVersion;
    private String serCountry;
    private String uid;
    private String versionName;

    public @interface CountryCodeSource {
        public static final String APP = "APP";
        public static final String LOCALE_INFO = "LOCALE_INFO";
        public static final String NETWORK_COUNTRY = "NETWORK_COUNTRY";
        public static final String SIM_COUNTRY = "SIM_COUNTRY";
        public static final String UNKNOWN = "UNKNOWN";
        public static final String VENDOR_COUNTRY = "VENDOR_COUNTRY";
    }

    public GrsBaseInfo() {
    }

    public GrsBaseInfo(Context context) {
        this.issueCountry = GrsApp.getInstance().getIssueCountryCode(context);
    }

    private StringBuffer getStringBuffer(StringBuffer stringBuffer, boolean z, Context context) {
        String androidVersion2 = getAndroidVersion();
        if (!TextUtils.isEmpty(androidVersion2)) {
            if (!TextUtils.isEmpty(stringBuffer.toString())) {
                stringBuffer.append(ContainerUtils.FIELD_DELIMITER);
            }
            stringBuffer.append("android_version");
            stringBuffer.append(ContainerUtils.KEY_VALUE_DELIMITER);
            stringBuffer.append(androidVersion2);
        }
        String romVersion2 = getRomVersion();
        if (!TextUtils.isEmpty(romVersion2)) {
            if (!TextUtils.isEmpty(stringBuffer.toString())) {
                stringBuffer.append(ContainerUtils.FIELD_DELIMITER);
            }
            stringBuffer.append("rom_version");
            stringBuffer.append(ContainerUtils.KEY_VALUE_DELIMITER);
            stringBuffer.append(romVersion2);
        }
        String deviceModel2 = getDeviceModel();
        if (!TextUtils.isEmpty(deviceModel2)) {
            if (!TextUtils.isEmpty(stringBuffer.toString())) {
                stringBuffer.append(ContainerUtils.FIELD_DELIMITER);
            }
            stringBuffer.append("device_model");
            stringBuffer.append(ContainerUtils.KEY_VALUE_DELIMITER);
            stringBuffer.append(deviceModel2);
        }
        String b = new C0728c(context, "share_pre_grs_conf_").mo13808b();
        if (!TextUtils.isEmpty(b) && !z) {
            try {
                String encode = URLEncoder.encode(b, Key.STRING_CHARSET_NAME);
                if (!TextUtils.isEmpty(stringBuffer.toString())) {
                    stringBuffer.append(ContainerUtils.FIELD_DELIMITER);
                }
                stringBuffer.append("cp");
                stringBuffer.append(ContainerUtils.KEY_VALUE_DELIMITER);
                stringBuffer.append(encode);
            } catch (UnsupportedEncodingException e) {
                Logger.m472e(TAG, "cp UnsupportedEncodingException.", (Throwable) e);
            }
        }
        String countrySource2 = getCountrySource();
        if (!TextUtils.isEmpty(countrySource2)) {
            if (!TextUtils.isEmpty(stringBuffer.toString())) {
                stringBuffer.append(ContainerUtils.FIELD_DELIMITER);
            }
            stringBuffer.append("country_source");
            stringBuffer.append(ContainerUtils.KEY_VALUE_DELIMITER);
            stringBuffer.append(countrySource2);
        }
        return stringBuffer;
    }

    private boolean isEqual(String str, String str2) {
        if (str == null && str2 == null) {
            return true;
        }
        return (str == null || str2 == null || !str.equals(str2)) ? false : true;
    }

    public GrsBaseInfo clone() {
        return (GrsBaseInfo) super.clone();
    }

    public boolean compare(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || GrsBaseInfo.class != obj.getClass() || !(obj instanceof GrsBaseInfo)) {
            return false;
        }
        GrsBaseInfo grsBaseInfo = (GrsBaseInfo) obj;
        return isEqual(this.serCountry, grsBaseInfo.serCountry) && isEqual(this.versionName, grsBaseInfo.versionName) && isEqual(this.appName, grsBaseInfo.appName) && isEqual(this.uid, grsBaseInfo.uid) && isEqual(this.regCountry, grsBaseInfo.regCountry) && isEqual(this.issueCountry, grsBaseInfo.issueCountry) && isEqual(this.androidVersion, grsBaseInfo.androidVersion) && isEqual(this.romVersion, grsBaseInfo.romVersion) && isEqual(this.deviceModel, grsBaseInfo.deviceModel) && isEqual(this.countrySource, grsBaseInfo.countrySource);
    }

    public GrsBaseInfo copy() {
        GrsBaseInfo grsBaseInfo = new GrsBaseInfo();
        grsBaseInfo.setAppName(this.appName);
        grsBaseInfo.setSerCountry(this.serCountry);
        grsBaseInfo.setRegCountry(this.regCountry);
        grsBaseInfo.setIssueCountry(this.issueCountry);
        grsBaseInfo.setCountrySource(this.countrySource);
        grsBaseInfo.setAndroidVersion(this.androidVersion);
        grsBaseInfo.setDeviceModel(this.deviceModel);
        grsBaseInfo.setRomVersion(this.romVersion);
        grsBaseInfo.setUid(this.uid);
        grsBaseInfo.setVersionName(this.versionName);
        return grsBaseInfo;
    }

    public String getAndroidVersion() {
        return this.androidVersion;
    }

    public String getAppName() {
        return this.appName;
    }

    public String getCountrySource() {
        return this.countrySource;
    }

    public String getDeviceModel() {
        return this.deviceModel;
    }

    public String getGrsParasKey(boolean z, boolean z2, Context context) {
        StringBuffer stringBuffer = new StringBuffer();
        C0731b a = C0731b.m539a(context.getPackageName(), this);
        C0768a a2 = a != null ? a.mo13825a() : null;
        String b = a2 != null ? a2.mo13903b() : "";
        String appName2 = getAppName();
        if (!TextUtils.isEmpty(appName2) && TextUtils.isEmpty(b)) {
            stringBuffer.append("app_name");
            stringBuffer.append(ContainerUtils.KEY_VALUE_DELIMITER);
            stringBuffer.append(appName2);
        }
        String grsReqParamJoint = getGrsReqParamJoint(z, z2, b, context);
        if (!TextUtils.isEmpty(grsReqParamJoint)) {
            if (!TextUtils.isEmpty(stringBuffer.toString())) {
                stringBuffer.append(ContainerUtils.FIELD_DELIMITER);
            }
            stringBuffer.append(grsReqParamJoint);
        }
        return stringBuffer.toString();
    }

    public String getGrsParasTag(boolean z, boolean z2, Context context) {
        return getGrsParasKey(z, z2, context);
    }

    public String getGrsReqParamJoint(boolean z, boolean z2, String str, Context context) {
        String a;
        StringBuffer stringBuffer = new StringBuffer();
        if ("1.0".equals(str)) {
            Logger.m476v(TAG, "1.0 interface has no query param appname");
        } else {
            if (!TextUtils.isEmpty(str)) {
                stringBuffer.append("app_name");
                stringBuffer.append(ContainerUtils.KEY_VALUE_DELIMITER);
            } else if (!TextUtils.isEmpty(getAppName())) {
                stringBuffer.append("app_name");
                stringBuffer.append(ContainerUtils.KEY_VALUE_DELIMITER);
                str = getAppName();
            }
            stringBuffer.append(str);
        }
        String versionName2 = getVersionName();
        if (!TextUtils.isEmpty(versionName2)) {
            if (!TextUtils.isEmpty(stringBuffer.toString())) {
                stringBuffer.append(ContainerUtils.FIELD_DELIMITER);
            }
            stringBuffer.append(Constants.EXTRA_KEY_APP_VERSION);
            stringBuffer.append(ContainerUtils.KEY_VALUE_DELIMITER);
            stringBuffer.append(versionName2);
        }
        String uid2 = getUid();
        if (!TextUtils.isEmpty(uid2)) {
            if (!TextUtils.isEmpty(stringBuffer.toString())) {
                stringBuffer.append(ContainerUtils.FIELD_DELIMITER);
            }
            stringBuffer.append("uid");
            stringBuffer.append(ContainerUtils.KEY_VALUE_DELIMITER);
            if (z) {
                a = C0760b.m670b(uid2);
            } else if (z2) {
                a = C0760b.m667a(uid2);
            } else {
                stringBuffer.append(uid2);
            }
            stringBuffer.append(a);
        }
        String regCountry2 = getRegCountry();
        if (!TextUtils.isEmpty(regCountry2) && !CountryCodeSource.UNKNOWN.equals(regCountry2)) {
            if (!TextUtils.isEmpty(stringBuffer.toString())) {
                stringBuffer.append(ContainerUtils.FIELD_DELIMITER);
            }
            stringBuffer.append("reg_country");
            stringBuffer.append(ContainerUtils.KEY_VALUE_DELIMITER);
            stringBuffer.append(regCountry2);
        }
        String serCountry2 = getSerCountry();
        if (!TextUtils.isEmpty(serCountry2) && !CountryCodeSource.UNKNOWN.equals(serCountry2)) {
            if (!TextUtils.isEmpty(stringBuffer.toString())) {
                stringBuffer.append(ContainerUtils.FIELD_DELIMITER);
            }
            stringBuffer.append("ser_country");
            stringBuffer.append(ContainerUtils.KEY_VALUE_DELIMITER);
            stringBuffer.append(serCountry2);
        }
        String issueCountry2 = getIssueCountry();
        if (!TextUtils.isEmpty(issueCountry2) && !CountryCodeSource.UNKNOWN.equals(issueCountry2)) {
            if (!TextUtils.isEmpty(stringBuffer.toString())) {
                stringBuffer.append(ContainerUtils.FIELD_DELIMITER);
            }
            stringBuffer.append("issue_country");
            stringBuffer.append(ContainerUtils.KEY_VALUE_DELIMITER);
            stringBuffer.append(issueCountry2);
        }
        return getStringBuffer(stringBuffer, z2, context).toString();
    }

    public String getIssueCountry() {
        return this.issueCountry;
    }

    public String getRegCountry() {
        return this.regCountry;
    }

    public String getRomVersion() {
        return this.romVersion;
    }

    public String getSerCountry() {
        return this.serCountry;
    }

    public String getUid() {
        return this.uid;
    }

    public String getVersionName() {
        return this.versionName;
    }

    public void setAndroidVersion(String str) {
        this.androidVersion = str;
    }

    public void setAppName(String str) {
        this.appName = str;
    }

    public void setCountrySource(String str) {
        this.countrySource = str;
    }

    public void setDeviceModel(String str) {
        this.deviceModel = str;
    }

    @Deprecated
    public void setIssueCountry(String str) {
        this.issueCountry = str;
    }

    public void setRegCountry(String str) {
        this.regCountry = str;
    }

    public void setRomVersion(String str) {
        this.romVersion = str;
    }

    public void setSerCountry(String str) {
        this.serCountry = str;
    }

    public void setUid(String str) {
        this.uid = str;
    }

    public void setVersionName(String str) {
        this.versionName = str;
    }

    public int uniqueCode() {
        return (this.appName + "#" + this.serCountry + "#" + this.regCountry + "#" + this.issueCountry).hashCode();
    }
}
