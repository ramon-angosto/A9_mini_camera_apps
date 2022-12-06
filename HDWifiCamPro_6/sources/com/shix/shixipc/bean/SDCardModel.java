package com.shix.shixipc.bean;

import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.shix.shixipc.system.ContentCommon;
import com.shix.shixipc.utils.CommonUtil;
import org.json.JSONException;
import org.json.JSONObject;

public class SDCardModel {
    private int cmd;
    private int coverage;
    private int free;
    private int isShowCapacity = 1;
    private int recMode;
    private int result;
    private int sdstatu;
    private int total;

    public int getIsShowCapacity() {
        return this.isShowCapacity;
    }

    public void setIsShowCapacity(int i) {
        this.isShowCapacity = i;
    }

    public int getRecMode() {
        return this.recMode;
    }

    public void setRecMode(int i) {
        this.recMode = i;
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

    public int getTotal() {
        return this.total;
    }

    public void setTotal(int i) {
        this.total = i;
    }

    public int getFree() {
        return this.free;
    }

    public void setFree(int i) {
        this.free = i;
    }

    public int getCoverage() {
        return this.coverage;
    }

    public void setCoverage(int i) {
        this.coverage = i;
    }

    public int getSdstatu() {
        return this.sdstatu;
    }

    public void setSdstatu(int i) {
        this.sdstatu = i;
    }

    public static SDCardModel jsonToModel(String str) throws JSONException {
        SDCardModel sDCardModel = new SDCardModel();
        JSONObject jSONObject = new JSONObject(str);
        sDCardModel.setCmd(CommonUtil.jasonPaseInt(jSONObject, "cmd", ContentCommon.SHIXFINAL_ERRORINT));
        sDCardModel.setResult(CommonUtil.jasonPaseInt(jSONObject, IronSourceConstants.EVENTS_RESULT, ContentCommon.SHIXFINAL_ERRORINT));
        sDCardModel.setTotal(CommonUtil.jasonPaseInt(jSONObject, "total", 0));
        sDCardModel.setFree(CommonUtil.jasonPaseInt(jSONObject, "free", 0));
        sDCardModel.setCoverage(CommonUtil.jasonPaseInt(jSONObject, "coverage", ContentCommon.SHIXFINAL_ERRORINT));
        sDCardModel.setSdstatu(CommonUtil.jasonPaseInt(jSONObject, "sdstatu", ContentCommon.SHIXFINAL_ERRORINT));
        try {
            sDCardModel.setRecMode(CommonUtil.jasonPaseInt(jSONObject, "recMode", ContentCommon.SHIXFINAL_ERRORINT));
        } catch (Exception unused) {
        }
        sDCardModel.setIsShowCapacity(0);
        return sDCardModel;
    }

    public static String toJson(SDCardModel sDCardModel, String str, String str2) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("pro", "set_sd");
        jSONObject.put("cmd", 110);
        jSONObject.put("user", str);
        jSONObject.put("pwd", str2);
        jSONObject.put("coverage", sDCardModel.getCoverage());
        jSONObject.put("format", 0);
        return jSONObject.toString();
    }
}
