package com.mbridge.msdk.foundation.entity;

import android.text.TextUtils;
import com.mbridge.msdk.system.NoProGuard;
import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;

public class RewardPlus implements NoProGuard, Serializable {
    public static final String AMOUNT = "amount";
    public static final String AMOUNT_MAX = "amount_max";
    public static final String CALLBACK_RULE = "callback_rule";
    public static final String CURRENCY_ID = "currency_id";
    public static final String ICON = "icon";
    public static final String NAME = "name";
    public static final String VIRTUAL_CURRENCY = "virtual_currency";
    private int amount = 1;
    private int amountMax = 0;
    private int callbackRule = 1;
    private int currencyId = 1;
    private String icon = "";
    private String name = "Virtual Item";
    private String virtualCurrency = "";

    public int getAmountMax() {
        return this.amountMax;
    }

    public int getCallbackRule() {
        return this.callbackRule;
    }

    public String getVirtualCurrency() {
        return this.virtualCurrency;
    }

    public int getAmount() {
        return this.amount;
    }

    public String getIcon() {
        return this.icon;
    }

    public int getCurrencyId() {
        return this.currencyId;
    }

    public String getName() {
        return this.name;
    }

    public void setAmountMax(int i) {
        this.amountMax = i;
    }

    public void setCallbackRule(int i) {
        this.callbackRule = i;
    }

    public void setVirtualCurrency(String str) {
        this.virtualCurrency = str;
    }

    public void setAmount(int i) {
        this.amount = i;
    }

    public void setIcon(String str) {
        this.icon = str;
    }

    public void setCurrencyId(int i) {
        this.currencyId = i;
    }

    public void setName(String str) {
        this.name = str;
    }

    public JSONObject toJsonObject() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(AMOUNT_MAX, this.amountMax);
            jSONObject.put(CALLBACK_RULE, this.callbackRule);
            jSONObject.put(VIRTUAL_CURRENCY, this.virtualCurrency);
            jSONObject.put(AMOUNT, this.amount);
            jSONObject.put(ICON, this.icon);
            jSONObject.put(CURRENCY_ID, this.currencyId);
            jSONObject.put("name", this.name);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    public static RewardPlus parseByString(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                return parse(new JSONObject(str));
            }
            return null;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static RewardPlus parse(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        RewardPlus rewardPlus = new RewardPlus();
        rewardPlus.setAmountMax(jSONObject.optInt(AMOUNT_MAX, 0));
        rewardPlus.setCallbackRule(jSONObject.optInt(CALLBACK_RULE, 1));
        rewardPlus.setVirtualCurrency(jSONObject.optString(VIRTUAL_CURRENCY, ""));
        rewardPlus.setIcon(jSONObject.optString(ICON, ""));
        rewardPlus.setCurrencyId(jSONObject.optInt(CURRENCY_ID, 1));
        if (jSONObject.has(AMOUNT)) {
            rewardPlus.setAmount(jSONObject.optInt(AMOUNT, 1));
        }
        if (!jSONObject.has("name")) {
            return rewardPlus;
        }
        rewardPlus.setName(jSONObject.optString("name", "Virtual Item"));
        return rewardPlus;
    }
}
