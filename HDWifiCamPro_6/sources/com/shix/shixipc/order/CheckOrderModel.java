package com.shix.shixipc.order;

import com.shix.shixipc.system.ContentCommon;
import com.shix.shixipc.utils.CommonUtil;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.json.JSONException;
import org.json.JSONObject;

public class CheckOrderModel implements Comparable<CheckOrderModel> {
    private long LCreateTime;
    private long LOverTime;
    private long LPayTime;
    private String createTime;
    private String goodsDay;
    private int goodsId;
    private String orderAmout;
    private int orderId;
    private String orderNo;
    private String orderStatus;
    private String overTime;
    private String payTime;
    private String supplier;
    private String transactionId;
    private int userId;

    public long getLCreateTime() {
        return this.LCreateTime;
    }

    public void setLCreateTime(long j) {
        this.LCreateTime = j;
    }

    public long getLPayTime() {
        return this.LPayTime;
    }

    public void setLPayTime(long j) {
        this.LPayTime = j;
    }

    public long getLOverTime() {
        return this.LOverTime;
    }

    public void setLOverTime(long j) {
        this.LOverTime = j;
    }

    public void setOrderId(int i) {
        this.orderId = i;
    }

    public int getOrderId() {
        return this.orderId;
    }

    public void setGoodsId(int i) {
        this.goodsId = i;
    }

    public int getGoodsId() {
        return this.goodsId;
    }

    public void setOrderNo(String str) {
        this.orderNo = str;
    }

    public String getOrderNo() {
        return this.orderNo;
    }

    public void setTransactionId(String str) {
        this.transactionId = str;
    }

    public String getTransactionId() {
        return this.transactionId;
    }

    public void setOrderStatus(String str) {
        this.orderStatus = str;
    }

    public String getOrderStatus() {
        return this.orderStatus;
    }

    public void setOrderAmout(String str) {
        this.orderAmout = str;
    }

    public String getOrderAmout() {
        return this.orderAmout;
    }

    public void setGoodsDay(String str) {
        this.goodsDay = str;
    }

    public String getGoodsDay() {
        return this.goodsDay;
    }

    public void setCreateTime(String str) {
        this.createTime = str;
    }

    public String getCreateTime() {
        return this.createTime;
    }

    public void setPayTime(String str) {
        this.payTime = str;
    }

    public String getPayTime() {
        return this.payTime;
    }

    public void setOverTime(String str) {
        this.overTime = str;
    }

    public String getOverTime() {
        return this.overTime;
    }

    public void setUserId(int i) {
        this.userId = i;
    }

    public int getUserId() {
        return this.userId;
    }

    public void setSupplier(String str) {
        this.supplier = str;
    }

    public String getSupplier() {
        return this.supplier;
    }

    public static CheckOrderModel jsonToModel(String str) throws JSONException {
        CheckOrderModel checkOrderModel = new CheckOrderModel();
        JSONObject jSONObject = new JSONObject(str);
        checkOrderModel.setOrderId(CommonUtil.jasonPaseInt(jSONObject, "orderId", ContentCommon.SHIXFINAL_ERRORINT));
        checkOrderModel.setGoodsId(CommonUtil.jasonPaseInt(jSONObject, "goodsId", ContentCommon.SHIXFINAL_ERRORINT));
        checkOrderModel.setUserId(CommonUtil.jasonPaseInt(jSONObject, "userId", ContentCommon.SHIXFINAL_ERRORINT));
        checkOrderModel.setOrderNo(CommonUtil.jasonPaseString(jSONObject, "orderNo"));
        checkOrderModel.setTransactionId(CommonUtil.jasonPaseString(jSONObject, "transactionId"));
        checkOrderModel.setOrderStatus(CommonUtil.jasonPaseString(jSONObject, "orderStatus"));
        checkOrderModel.setOrderAmout(CommonUtil.jasonPaseString(jSONObject, "orderAmout"));
        checkOrderModel.setGoodsDay(CommonUtil.jasonPaseString(jSONObject, "goodsDay"));
        checkOrderModel.setCreateTime(CommonUtil.jasonPaseString(jSONObject, "createTime"));
        checkOrderModel.setPayTime(CommonUtil.jasonPaseString(jSONObject, "payTime"));
        checkOrderModel.setOverTime(CommonUtil.jasonPaseString(jSONObject, "overTime"));
        checkOrderModel.setSupplier(CommonUtil.jasonPaseString(jSONObject, "supplier"));
        if (checkOrderModel.getCreateTime() != null && checkOrderModel.getCreateTime().length() > 5) {
            checkOrderModel.setLCreateTime(getTimeFormStr(checkOrderModel.getCreateTime()));
        }
        if (checkOrderModel.getPayTime() != null && checkOrderModel.getPayTime().length() > 5) {
            checkOrderModel.setLPayTime(getTimeFormStr(checkOrderModel.getPayTime()));
        }
        if ((checkOrderModel.getOverTime() == null || checkOrderModel.getOverTime().length() < 5) && checkOrderModel.getGoodsDay() != null && checkOrderModel.getGoodsDay().length() > 0) {
            checkOrderModel.setLOverTime(checkOrderModel.getLPayTime() + (((long) Integer.parseInt(checkOrderModel.getGoodsDay())) * 86400));
            checkOrderModel.setOverTime(getTimeStrFromLong(checkOrderModel.getLOverTime()));
        }
        CommonUtil.Log(1, "CheckOrderModel orderId:" + checkOrderModel.getOrderId() + " \norderNo:" + checkOrderModel.getOrderNo() + " \ngoodsId:" + checkOrderModel.getGoodsId() + " \ntransactionId:" + checkOrderModel.getTransactionId() + " \ngoodsDay:" + checkOrderModel.getGoodsDay() + " \norderStatus:" + checkOrderModel.getOrderStatus() + " \norderAmout:" + checkOrderModel.getOrderAmout() + " \ncreateTime:" + checkOrderModel.getCreateTime() + " \npayTime:" + checkOrderModel.getPayTime() + " \noverTime:" + checkOrderModel.getOverTime() + " \nuserId:" + checkOrderModel.getUserId() + " \nsupplier:" + checkOrderModel.getSupplier() + " \nLCreateTime:" + checkOrderModel.getLCreateTime() + " \nLPayTime:" + checkOrderModel.getLPayTime() + " \nLOverTime:" + checkOrderModel.getLOverTime() + " \n");
        return checkOrderModel;
    }

    public int compareTo(CheckOrderModel checkOrderModel) {
        return (int) (this.LPayTime - checkOrderModel.getLPayTime());
    }

    public static long getTimeFormStr(String str) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(str).getTime() / 1000;
        } catch (ParseException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static String getTimeStrFromLong(long j) {
        String format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(1000 * j));
        CommonUtil.Log(1, "getTimeStrFromLong:" + j + " dateString:" + format);
        return format;
    }
}
