package com.shix.shixipc.bean;

import com.shix.shixipc.CrashApplication;
import com.shix.shixipc.utils.CommonAppUtil;
import com.shix.shixipc.utils.CommonUtil;

public class appBean {
    private int cloudLDays = 3;
    private int isCloudL = 0;
    private int newVer = 0;
    private String upPath = "";
    private String verName = "";

    public String getVerName() {
        return this.verName;
    }

    public void setVerName(String str) {
        this.verName = str;
    }

    public String getUpPath() {
        return this.upPath;
    }

    public void setUpPath(String str) {
        this.upPath = str;
    }

    public int getNewVer() {
        return this.newVer;
    }

    public void setNewVer(int i) {
        this.newVer = i;
    }

    public int getIsCloudL() {
        return this.isCloudL;
    }

    public void setIsCloudL(int i) {
        this.isCloudL = i;
    }

    public int getCloudLDays() {
        return this.cloudLDays;
    }

    public void setCloudLDays(int i) {
        this.cloudLDays = i;
    }

    public void save() {
        CommonUtil.SaveCommonShare(CrashApplication.getContext(), CommonAppUtil.SHIXAPP_UPPATH, getUpPath(), 0);
        CommonUtil.SaveCommonShare(CrashApplication.getContext(), CommonAppUtil.SHIXAPP_VERNAME, getVerName(), 0);
        CommonUtil.SaveCommonShare(CrashApplication.getContext(), CommonAppUtil.SHIXAPP_NEWVER, (String) null, getNewVer());
        CommonUtil.SaveCommonShare(CrashApplication.getContext(), CommonAppUtil.SHIXAPP_ISCLOUDL, (String) null, getIsCloudL());
        CommonUtil.SaveCommonShare(CrashApplication.getContext(), CommonAppUtil.SHIXAPP_CLOUDLDAYS, (String) null, getCloudLDays());
        String GetCommonShareStringValue = CommonUtil.GetCommonShareStringValue(CrashApplication.getContext(), CommonAppUtil.SHIXAPP_UPPATH, "");
        String GetCommonShareStringValue2 = CommonUtil.GetCommonShareStringValue(CrashApplication.getContext(), CommonAppUtil.SHIXAPP_VERNAME, "");
        int GetCommonShareIntValue = CommonUtil.GetCommonShareIntValue(CrashApplication.getContext(), CommonAppUtil.SHIXAPP_NEWVER, 0);
        int GetCommonShareIntValue2 = CommonUtil.GetCommonShareIntValue(CrashApplication.getContext(), CommonAppUtil.SHIXAPP_ISCLOUDL, 0);
        int GetCommonShareIntValue3 = CommonUtil.GetCommonShareIntValue(CrashApplication.getContext(), CommonAppUtil.SHIXAPP_CLOUDLDAYS, 0);
        CommonUtil.Log(2, "SHIXAPP t_newVer:" + GetCommonShareIntValue + "  t_verName:" + GetCommonShareStringValue2 + "  t_isCloudL:" + GetCommonShareIntValue2 + "  t_cloudLDays:" + GetCommonShareIntValue3 + "  t_upPath:" + GetCommonShareStringValue + " \n");
    }
}
