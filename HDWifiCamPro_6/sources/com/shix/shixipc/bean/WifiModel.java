package com.shix.shixipc.bean;

import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.shix.shixipc.system.ContentCommon;
import com.shix.shixipc.utils.CommonUtil;
import org.json.JSONException;
import org.json.JSONObject;

public class WifiModel {
    private int cmd;
    private int conmode;
    private int encryption;
    private int result;
    private int signal;
    private String ssid;
    private String wifipwd;

    public int getConmode() {
        return this.conmode;
    }

    public void setConmode(int i) {
        this.conmode = i;
    }

    public int getSignal() {
        return this.signal;
    }

    public void setSignal(int i) {
        this.signal = i;
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

    public String getSsid() {
        return this.ssid;
    }

    public void setSsid(String str) {
        this.ssid = str;
    }

    public String getWifipwd() {
        return this.wifipwd;
    }

    public void setWifipwd(String str) {
        this.wifipwd = str;
    }

    public int getEncryption() {
        return this.encryption;
    }

    public void setEncryption(int i) {
        this.encryption = i;
    }

    public static WifiModel jsonToModel(String str) throws JSONException {
        WifiModel wifiModel = new WifiModel();
        JSONObject jSONObject = new JSONObject(str);
        wifiModel.setCmd(CommonUtil.jasonPaseInt(jSONObject, "cmd", ContentCommon.SHIXFINAL_ERRORINT));
        wifiModel.setResult(CommonUtil.jasonPaseInt(jSONObject, IronSourceConstants.EVENTS_RESULT, ContentCommon.SHIXFINAL_ERRORINT));
        wifiModel.setSsid(CommonUtil.jasonPaseString(jSONObject, "ssid"));
        wifiModel.setSignal(CommonUtil.jasonPaseInt(jSONObject, "signal", ContentCommon.SHIXFINAL_ERRORINT));
        wifiModel.setEncryption(CommonUtil.jasonPaseInt(jSONObject, "encryption", ContentCommon.SHIXFINAL_ERRORINT));
        wifiModel.setConmode(CommonUtil.jasonPaseInt(jSONObject, "conmode", ContentCommon.SHIXFINAL_ERRORINT));
        return wifiModel;
    }

    public static String toJson(WifiModel wifiModel, String str, String str2) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("pro", "set_sd");
        jSONObject.put("cmd", 114);
        jSONObject.put("user", str);
        jSONObject.put("pwd", str2);
        jSONObject.put("ssid", wifiModel.getSsid());
        jSONObject.put("wifipwd", wifiModel.getWifipwd());
        jSONObject.put("encryption", wifiModel.getEncryption());
        return jSONObject.toString();
    }
}
