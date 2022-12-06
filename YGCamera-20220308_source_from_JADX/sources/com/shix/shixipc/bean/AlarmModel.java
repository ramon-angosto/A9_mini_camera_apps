package com.shix.shixipc.bean;

import com.shix.shixipc.system.ContentCommon;
import com.shix.shixipc.utils.CommonUtil;
import org.json.JSONException;
import org.json.JSONObject;

public class AlarmModel {
    private int cmd;
    private int pirPush;
    private int pirdelaytime;
    private int pirenable;
    private int pirsensitive;
    private int pirvideo;
    private int pirvideotime;
    private int result;

    public int getPirPush() {
        return this.pirPush;
    }

    public void setPirPush(int i) {
        this.pirPush = i;
    }

    public int getPirdelaytime() {
        return this.pirdelaytime;
    }

    public void setPirdelaytime(int i) {
        this.pirdelaytime = i;
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

    public int getPirenable() {
        return this.pirenable;
    }

    public void setPirenable(int i) {
        this.pirenable = i;
    }

    public int getPirsensitive() {
        return this.pirsensitive;
    }

    public void setPirsensitive(int i) {
        this.pirsensitive = i;
    }

    public int getPirvideo() {
        return this.pirvideo;
    }

    public void setPirvideo(int i) {
        this.pirvideo = i;
    }

    public int getPirvideotime() {
        return this.pirvideotime;
    }

    public void setPirvideotime(int i) {
        this.pirvideotime = i;
    }

    public static AlarmModel jsonToModel(String str) throws JSONException {
        AlarmModel alarmModel = new AlarmModel();
        JSONObject jSONObject = new JSONObject(str);
        alarmModel.setCmd(CommonUtil.jasonPaseInt(jSONObject, "cmd", ContentCommon.SHIXFINAL_ERRORINT));
        alarmModel.setResult(CommonUtil.jasonPaseInt(jSONObject, "result", ContentCommon.SHIXFINAL_ERRORINT));
        alarmModel.setPirenable(CommonUtil.jasonPaseInt(jSONObject, "pirenable", ContentCommon.SHIXFINAL_ERRORINT));
        alarmModel.setPirvideo(CommonUtil.jasonPaseInt(jSONObject, "pirvideo", ContentCommon.SHIXFINAL_ERRORINT));
        alarmModel.setPirvideotime(CommonUtil.jasonPaseInt(jSONObject, "pirvideotime", ContentCommon.SHIXFINAL_ERRORINT));
        alarmModel.setPirsensitive(CommonUtil.jasonPaseInt(jSONObject, "pirsensitive", ContentCommon.SHIXFINAL_ERRORINT));
        alarmModel.setPirdelaytime(CommonUtil.jasonPaseInt(jSONObject, "pirDelayTime", ContentCommon.SHIXFINAL_ERRORINT));
        alarmModel.setPirPush(CommonUtil.jasonPaseInt(jSONObject, "pirPush", ContentCommon.SHIXFINAL_ERRORINT));
        if (alarmModel.getPirsensitive() == -110) {
            if (alarmModel.getPirenable() > 0) {
                alarmModel.setPirsensitive(alarmModel.getPirenable());
            } else {
                alarmModel.setPirsensitive(2);
            }
        }
        return alarmModel;
    }

    public static String toJson(AlarmModel alarmModel, String str, String str2) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("pro", "set_alarm");
        jSONObject.put("cmd", 108);
        jSONObject.put("user", str);
        jSONObject.put("pwd", str2);
        jSONObject.put("pirenable", alarmModel.getPirenable());
        jSONObject.put("pirsensitive", alarmModel.getPirsensitive());
        jSONObject.put("pirvideo", alarmModel.getPirvideo());
        jSONObject.put("pirvideotime", alarmModel.getPirvideotime());
        jSONObject.put("pirDelayTime", alarmModel.getPirdelaytime());
        jSONObject.put("pirPush", alarmModel.getPirPush());
        return jSONObject.toString();
    }
}
