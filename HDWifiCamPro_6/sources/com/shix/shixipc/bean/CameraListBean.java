package com.shix.shixipc.bean;

import com.shix.shixipc.system.SystemValue;
import com.shix.shixipc.utils.CommonUtil;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class CameraListBean implements Serializable {
    private static final long serialVersionUID = -1893938966606638094L;
    private int devCont;
    private List<String> devS = new ArrayList();

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getDevCont() {
        return this.devCont;
    }

    public void setDevCont(int i) {
        this.devCont = i;
    }

    public List<String> getDevS() {
        return this.devS;
    }

    public void setDevS(List<String> list) {
        this.devS = list;
    }

    public static CameraListBean jsonToModel(String str) throws JSONException {
        CameraListBean cameraListBean = new CameraListBean();
        JSONObject jSONObject = new JSONObject(str);
        int i = jSONObject.getInt("devCont");
        cameraListBean.setDevCont(i);
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < i; i2++) {
            arrayList.add(CommonUtil.jasonPaseString(jSONObject, "key[" + i2 + "]"));
        }
        cameraListBean.setDevS(arrayList);
        return cameraListBean;
    }

    public static String toJson() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("devCont", SystemValue.arrayList.size());
        for (int i = 0; i < SystemValue.arrayList.size(); i++) {
            jSONObject.put("key[" + i + "]", SystemValue.arrayList.get(i).getDev_Did());
        }
        return jSONObject.toString();
    }
}
