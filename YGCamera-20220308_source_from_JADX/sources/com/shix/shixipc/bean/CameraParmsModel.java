package com.shix.shixipc.bean;

import com.shix.shixipc.system.ContentCommon;
import com.shix.shixipc.utils.CommonUtil;
import org.json.JSONException;
import org.json.JSONObject;

public class CameraParmsModel {
    private int batstatus;
    private int batvalue;
    private int bright;
    private int clockScreen;
    private int cmd;
    private int contrast;
    private int icut;
    private int lamp;
    private int mic;
    private int online;
    private int pirstatu;
    private String qccid;
    private int result;
    private int rotmir;
    private int signal;
    private int spk;
    private int watch;

    public String getQccid() {
        return this.qccid;
    }

    public void setQccid(String str) {
        this.qccid = str;
    }

    public int getSignal() {
        return this.signal;
    }

    public void setSignal(int i) {
        this.signal = i;
    }

    public int getBatstatus() {
        return this.batstatus;
    }

    public void setBatstatus(int i) {
        this.batstatus = i;
    }

    public int getBatvalue() {
        return this.batvalue;
    }

    public void setBatvalue(int i) {
        this.batvalue = i;
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

    public int getIcut() {
        return this.icut;
    }

    public void setIcut(int i) {
        this.icut = i;
    }

    public int getPirstatu() {
        return this.pirstatu;
    }

    public void setPirstatu(int i) {
        this.pirstatu = i;
    }

    public int getMic() {
        return this.mic;
    }

    public void setMic(int i) {
        this.mic = i;
    }

    public int getSpk() {
        return this.spk;
    }

    public void setSpk(int i) {
        this.spk = i;
    }

    public int getOnline() {
        return this.online;
    }

    public void setOnline(int i) {
        this.online = i;
    }

    public int getWatch() {
        return this.watch;
    }

    public void setWatch(int i) {
        this.watch = i;
    }

    public int getRotmir() {
        return this.rotmir;
    }

    public void setRotmir(int i) {
        this.rotmir = i;
    }

    public int getBright() {
        return this.bright;
    }

    public void setBright(int i) {
        this.bright = i;
    }

    public int getContrast() {
        return this.contrast;
    }

    public void setContrast(int i) {
        this.contrast = i;
    }

    public int getClockScreen() {
        return this.clockScreen;
    }

    public void setClockScreen(int i) {
        this.clockScreen = i;
    }

    public int getLamp() {
        return this.lamp;
    }

    public void setLamp(int i) {
        this.lamp = i;
    }

    public static CameraParmsModel jsonToModel(String str) throws JSONException {
        CameraParmsModel cameraParmsModel = new CameraParmsModel();
        JSONObject jSONObject = new JSONObject(str);
        cameraParmsModel.setCmd(CommonUtil.jasonPaseInt(jSONObject, "cmd", ContentCommon.SHIXFINAL_ERRORINT));
        cameraParmsModel.setResult(CommonUtil.jasonPaseInt(jSONObject, "result", ContentCommon.SHIXFINAL_ERRORINT));
        try {
            cameraParmsModel.setQccid(CommonUtil.jasonPaseString(jSONObject, "qccid"));
            CommonUtil.Log(1, "setQccid:" + cameraParmsModel.getQccid());
        } catch (Exception unused) {
        }
        try {
            cameraParmsModel.setBright(CommonUtil.jasonPaseInt(jSONObject, "bright", ContentCommon.SHIXFINAL_ERRORINT));
            cameraParmsModel.setContrast(CommonUtil.jasonPaseInt(jSONObject, "contrast", ContentCommon.SHIXFINAL_ERRORINT));
            cameraParmsModel.setIcut(CommonUtil.jasonPaseInt(jSONObject, "icut", ContentCommon.SHIXFINAL_ERRORINT));
            cameraParmsModel.setRotmir(CommonUtil.jasonPaseInt(jSONObject, "rotmir", ContentCommon.SHIXFINAL_ERRORINT));
            cameraParmsModel.setPirstatu(CommonUtil.jasonPaseInt(jSONObject, "pirstatu", ContentCommon.SHIXFINAL_ERRORINT));
            cameraParmsModel.setMic(CommonUtil.jasonPaseInt(jSONObject, "mic", ContentCommon.SHIXFINAL_ERRORINT));
            cameraParmsModel.setSpk(CommonUtil.jasonPaseInt(jSONObject, "spk", ContentCommon.SHIXFINAL_ERRORINT));
            cameraParmsModel.setLamp(CommonUtil.jasonPaseInt(jSONObject, "lamp", ContentCommon.SHIXFINAL_ERRORINT));
            cameraParmsModel.setSignal(CommonUtil.jasonPaseInt(jSONObject, "signal", ContentCommon.SHIXFINAL_ERRORINT));
        } catch (Exception unused2) {
        }
        try {
            cameraParmsModel.setBatvalue(CommonUtil.jasonPaseInt(jSONObject, "batValue", ContentCommon.SHIXFINAL_ERRORINT));
            cameraParmsModel.setBatstatus(CommonUtil.jasonPaseInt(jSONObject, "batStatus", ContentCommon.SHIXFINAL_ERRORINT));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cameraParmsModel;
    }
}
