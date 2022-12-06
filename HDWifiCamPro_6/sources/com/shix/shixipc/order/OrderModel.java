package com.shix.shixipc.order;

import com.shix.shixipc.system.ContentCommon;
import com.shix.shixipc.utils.CommonUtil;
import org.json.JSONException;
import org.json.JSONObject;

public class OrderModel {
    private String createTime;
    private String description;
    private String discountPrice;
    private String goodsDay;
    private String name;
    private float salesPrice;
    private int spuId;
    private String updateTime;

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String str) {
        this.description = str;
    }

    public String getCreateTime() {
        return this.createTime;
    }

    public void setCreateTime(String str) {
        this.createTime = str;
    }

    public String getUpdateTime() {
        return this.updateTime;
    }

    public void setUpdateTime(String str) {
        this.updateTime = str;
    }

    public String getGoodsDay() {
        return this.goodsDay;
    }

    public void setGoodsDay(String str) {
        this.goodsDay = str;
    }

    public String getDiscountPrice() {
        return this.discountPrice;
    }

    public void setDiscountPrice(String str) {
        this.discountPrice = str;
    }

    public int getSpuId() {
        return this.spuId;
    }

    public void setSpuId(int i) {
        this.spuId = i;
    }

    public float getSalesPrice() {
        return this.salesPrice;
    }

    public void setSalesPrice(float f) {
        this.salesPrice = f;
    }

    public static OrderModel jsonToModel(String str) throws JSONException {
        OrderModel orderModel = new OrderModel();
        JSONObject jSONObject = new JSONObject(str);
        orderModel.setName(CommonUtil.jasonPaseString(jSONObject, "name"));
        orderModel.setDescription(CommonUtil.jasonPaseString(jSONObject, "description"));
        orderModel.setCreateTime(CommonUtil.jasonPaseString(jSONObject, "createTime"));
        orderModel.setUpdateTime(CommonUtil.jasonPaseString(jSONObject, "updateTime"));
        orderModel.setGoodsDay(CommonUtil.jasonPaseString(jSONObject, "goodsDay"));
        orderModel.setDiscountPrice(CommonUtil.jasonPaseString(jSONObject, "discountPrice"));
        orderModel.setSpuId(CommonUtil.jasonPaseInt(jSONObject, "spuId", ContentCommon.SHIXFINAL_ERRORINT));
        orderModel.setSalesPrice(CommonUtil.jasonPaseFloat(jSONObject, "salesPrice", 0.1f));
        CommonUtil.Log(1, "OrderModel Name:" + orderModel.getName() + " \ndescription:" + orderModel.getDescription() + " \ncreateTime:" + orderModel.getCreateTime() + " \nupdateTime:" + orderModel.getUpdateTime() + " \ngoodsDay:" + orderModel.getGoodsDay() + " \ndiscountPrice:" + orderModel.getDiscountPrice() + " \nspuId:" + orderModel.getSpuId() + " \nsalesPrice:" + orderModel.getSalesPrice() + " \n");
        return orderModel;
    }
}
