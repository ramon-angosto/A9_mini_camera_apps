package com.meizu.cloud.pushsdk.platform.message;

import android.text.TextUtils;
import com.meizu.cloud.pushinternal.DebugLogger;
import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class BasicPushStatus implements Serializable {
    public static final String SUCCESS_CODE = "200";
    public static final String TAG = "BasicPushStatus";
    public String code;
    public String message;

    public abstract void parseValueData(JSONObject jSONObject) throws JSONException;

    public BasicPushStatus() {
    }

    public BasicPushStatus(String str) {
        JSONObject parse = parse(str);
        if (parse != null && SUCCESS_CODE.equals(this.code) && !parse.isNull("value")) {
            try {
                parseValueData(parse.getJSONObject("value"));
            } catch (JSONException e) {
                DebugLogger.e(TAG, "parse value data error " + e.getMessage() + " json " + str);
            }
        }
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String str) {
        this.code = str;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public String getMessage() {
        return this.message;
    }

    /* access modifiers changed from: protected */
    public JSONObject parse(String str) {
        JSONObject jSONObject = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObject2 = new JSONObject(str);
            try {
                if (!jSONObject2.isNull("code")) {
                    setCode(jSONObject2.getString("code"));
                }
                if (!jSONObject2.isNull("message")) {
                    setMessage(jSONObject2.getString("message"));
                }
                return jSONObject2;
            } catch (JSONException e) {
                e = e;
                jSONObject = jSONObject2;
                DebugLogger.e(TAG, "covert json error " + e.getMessage());
                return jSONObject;
            }
        } catch (JSONException e2) {
            e = e2;
            DebugLogger.e(TAG, "covert json error " + e.getMessage());
            return jSONObject;
        }
    }

    public String toString() {
        return "BasicPushStatus{code='" + this.code + '\'' + ", message='" + this.message + '\'' + '}';
    }
}
