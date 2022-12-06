package com.shix.shixipc.order;

import com.shix.shixipc.utils.CommonUtil;
import org.json.JSONException;
import org.json.JSONObject;

public class WXPayModel {
    private String appid;
    private String noncestr;
    private String orderNo;
    private String partnerid;
    private String prepayid;
    private String sign;
    private String timestamp;
    private String wxpackage;

    public String getWxpackage() {
        return this.wxpackage;
    }

    public void setWxpackage(String str) {
        this.wxpackage = str;
    }

    public String getOrderNo() {
        return this.orderNo;
    }

    public void setOrderNo(String str) {
        this.orderNo = str;
    }

    public String getAppid() {
        return this.appid;
    }

    public void setAppid(String str) {
        this.appid = str;
    }

    public String getSign() {
        return this.sign;
    }

    public void setSign(String str) {
        this.sign = str;
    }

    public String getPartnerid() {
        return this.partnerid;
    }

    public void setPartnerid(String str) {
        this.partnerid = str;
    }

    public String getPrepayid() {
        return this.prepayid;
    }

    public void setPrepayid(String str) {
        this.prepayid = str;
    }

    public String getNoncestr() {
        return this.noncestr;
    }

    public void setNoncestr(String str) {
        this.noncestr = str;
    }

    public String getTimestamp() {
        return this.timestamp;
    }

    public void setTimestamp(String str) {
        this.timestamp = str;
    }

    public static WXPayModel jsonToModel(String str) throws JSONException {
        WXPayModel wXPayModel = new WXPayModel();
        JSONObject jSONObject = new JSONObject(str);
        wXPayModel.setWxpackage(CommonUtil.jasonPaseString(jSONObject, "package"));
        wXPayModel.setOrderNo(CommonUtil.jasonPaseString(jSONObject, "orderNo"));
        wXPayModel.setAppid(CommonUtil.jasonPaseString(jSONObject, "appid"));
        wXPayModel.setSign(CommonUtil.jasonPaseString(jSONObject, "sign"));
        wXPayModel.setPartnerid(CommonUtil.jasonPaseString(jSONObject, "partnerid"));
        wXPayModel.setPrepayid(CommonUtil.jasonPaseString(jSONObject, "prepayid"));
        wXPayModel.setNoncestr(CommonUtil.jasonPaseString(jSONObject, "noncestr"));
        wXPayModel.setTimestamp(CommonUtil.jasonPaseString(jSONObject, "timestamp"));
        CommonUtil.Log(1, "WXPayModel package:" + wXPayModel.getWxpackage() + " \norderNo:" + wXPayModel.getOrderNo() + " \nappid:" + wXPayModel.getAppid() + " \nsign:" + wXPayModel.getSign() + " \npartnerid:" + wXPayModel.getPartnerid() + " \nprepayid:" + wXPayModel.getPrepayid() + " \nnoncestr:" + wXPayModel.getNoncestr() + " \ntimestamp:" + wXPayModel.getTimestamp() + " \n");
        return wXPayModel;
    }
}
