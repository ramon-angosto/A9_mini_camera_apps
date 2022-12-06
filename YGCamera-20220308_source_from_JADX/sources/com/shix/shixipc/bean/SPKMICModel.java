package com.shix.shixipc.bean;

import com.shix.shixipc.system.ContentCommon;
import com.shix.shixipc.utils.CommonUtil;
import org.json.JSONException;
import org.json.JSONObject;

public class SPKMICModel {
    private int batstatus;
    private int batvalue;
    private int cmd;
    private int mic;
    private int result;
    private int spk;

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

    public int getSpk() {
        return this.spk;
    }

    public void setSpk(int i) {
        this.spk = i;
    }

    public int getMic() {
        return this.mic;
    }

    public void setMic(int i) {
        this.mic = i;
    }

    public static SPKMICModel jsonToModel(String str) throws JSONException {
        SPKMICModel sPKMICModel = new SPKMICModel();
        JSONObject jSONObject = new JSONObject(str);
        sPKMICModel.setCmd(CommonUtil.jasonPaseInt(jSONObject, "cmd", ContentCommon.SHIXFINAL_ERRORINT));
        sPKMICModel.setResult(CommonUtil.jasonPaseInt(jSONObject, "result", ContentCommon.SHIXFINAL_ERRORINT));
        sPKMICModel.setSpk(CommonUtil.jasonPaseInt(jSONObject, "outputvol", ContentCommon.SHIXFINAL_ERRORINT));
        sPKMICModel.setMic(CommonUtil.jasonPaseInt(jSONObject, "inputvol", ContentCommon.SHIXFINAL_ERRORINT));
        sPKMICModel.setBatvalue(CommonUtil.jasonPaseInt(jSONObject, "batvalue", ContentCommon.SHIXFINAL_ERRORINT));
        sPKMICModel.setBatstatus(CommonUtil.jasonPaseInt(jSONObject, "batstatus", ContentCommon.SHIXFINAL_ERRORINT));
        return sPKMICModel;
    }
}
