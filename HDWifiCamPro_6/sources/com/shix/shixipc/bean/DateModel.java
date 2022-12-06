package com.shix.shixipc.bean;

import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.shix.shixipc.system.ContentCommon;
import com.shix.shixipc.utils.CommonUtil;
import org.json.JSONException;
import org.json.JSONObject;

public class DateModel {
    private int apiVer;
    private int cmd;
    private int dstSwitch;
    private String ntpServer;
    private int ntpSwitch;
    private int result;
    private int time;
    private int timeHour;
    private float timeZone;

    public int getApiVer() {
        return this.apiVer;
    }

    public void setApiVer(int i) {
        this.apiVer = i;
    }

    public int getTimeHour() {
        return this.timeHour;
    }

    public void setTimeHour(int i) {
        this.timeHour = i;
    }

    public int getCmd() {
        return this.cmd;
    }

    public void setCmd(int i) {
        this.cmd = i;
    }

    public int getResult() {
        return this.result;
    }

    public void setResult(int i) {
        this.result = i;
    }

    public int getNtpSwitch() {
        return this.ntpSwitch;
    }

    public void setNtpSwitch(int i) {
        this.ntpSwitch = i;
    }

    public int getDstSwitch() {
        return this.dstSwitch;
    }

    public void setDstSwitch(int i) {
        this.dstSwitch = i;
    }

    public float getTimeZone() {
        return this.timeZone;
    }

    public void setTimeZone(float f) {
        this.timeZone = f;
    }

    public int getTime() {
        return this.time;
    }

    public void setTime(int i) {
        this.time = i;
    }

    public String getNtpServer() {
        return this.ntpServer;
    }

    public void setNtpServer(String str) {
        this.ntpServer = str;
    }

    public static DateModel jsonToModel(String str) throws JSONException {
        DateModel dateModel = new DateModel();
        JSONObject jSONObject = new JSONObject(str);
        dateModel.setCmd(CommonUtil.jasonPaseInt(jSONObject, "cmd", ContentCommon.SHIXFINAL_ERRORINT));
        dateModel.setResult(CommonUtil.jasonPaseInt(jSONObject, IronSourceConstants.EVENTS_RESULT, ContentCommon.SHIXFINAL_ERRORINT));
        dateModel.setApiVer(CommonUtil.jasonPaseInt(jSONObject, "apiVer", ContentCommon.SHIXFINAL_ERRORINT));
        dateModel.setNtpSwitch(CommonUtil.jasonPaseInt(jSONObject, "ntpSwitch", ContentCommon.SHIXFINAL_ERRORINT));
        dateModel.setDstSwitch(CommonUtil.jasonPaseInt(jSONObject, "dstSwitch", ContentCommon.SHIXFINAL_ERRORINT));
        if (dateModel.getApiVer() == 1) {
            dateModel.setTimeZone(CommonUtil.jasonPaseFloat(jSONObject, "timeZone", -110.0f));
        } else {
            dateModel.setTimeZone((float) CommonUtil.jasonPaseInt(jSONObject, "timeZone", ContentCommon.SHIXFINAL_ERRORINT));
        }
        dateModel.setTime(CommonUtil.jasonPaseInt(jSONObject, "time", ContentCommon.SHIXFINAL_ERRORINT));
        dateModel.setTimeHour(CommonUtil.jasonPaseInt(jSONObject, "timeHour", ContentCommon.SHIXFINAL_ERRORINT));
        dateModel.setNtpServer(CommonUtil.jasonPaseString(jSONObject, "ntpServer"));
        return dateModel;
    }

    public static String toJson(DateModel dateModel, String str, String str2) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("pro", "set_datetime");
        jSONObject.put("cmd", 126);
        jSONObject.put("user", str);
        jSONObject.put("pwd", str2);
        jSONObject.put("ntpSwitch", dateModel.getNtpSwitch());
        jSONObject.put("dstSwitch", dateModel.getDstSwitch());
        if (dateModel.getApiVer() == 1) {
            jSONObject.put("timeZone", (double) dateModel.getTimeZone());
        } else {
            jSONObject.put("timeZone", (int) dateModel.getTimeZone());
        }
        jSONObject.put("time", dateModel.getTime());
        jSONObject.put("ntpServer", dateModel.getNtpServer());
        jSONObject.put("timeHour", dateModel.getTimeHour());
        return jSONObject.toString();
    }
}
