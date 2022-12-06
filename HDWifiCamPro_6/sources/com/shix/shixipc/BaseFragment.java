package com.shix.shixipc;

import android.os.Environment;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.shix.qhipc.R;
import com.shix.shixipc.system.ContentCommon;
import com.shix.shixipc.system.SystemValue;
import com.shix.shixipc.utils.CommonAppUtil;
import com.shix.shixipc.utils.CommonUtil;
import com.shix.shixipc.utils.PayHttpUtils;
import java.io.IOException;
import object.p2pipcam.nativecaller.NativeCaller;
import org.json.JSONException;
import org.json.JSONObject;

public class BaseFragment extends Fragment {
    JSONObject objA = null;
    JSONObject objB = null;
    JSONObject objC = null;
    String rStr = "";
    String testIP = "120.76.133.14:80";
    String token = "";

    public boolean checkChina(String str, int i) {
        return false;
    }

    public boolean isTestApp(String str, int i) {
        return false;
    }

    public void showToast(String str) {
        Toast.makeText(getActivity(), str, 0).show();
    }

    public void showToast(int i) {
        Toast.makeText(getActivity(), getResources().getString(i), 0).show();
    }

    public void showToastLong(String str) {
        Toast.makeText(getActivity(), str, 1).show();
    }

    public void showToastLong(int i) {
        Toast.makeText(getActivity(), getResources().getString(i), 1).show();
    }

    public String returnString(int i) {
        return getResources().getString(i);
    }

    public void StartPPPP(String str, String str2, String str3, String str4) {
        String str5;
        String substring = str.substring(0, 3);
        if (substring.equalsIgnoreCase("GBE")) {
            str5 = "EBGAEIBIKHJJGFJKEOGIFKEFHCMCHMNBG";
        } else {
            str5 = substring.equalsIgnoreCase("OBJ") ? "EBGAEOBOKHJMHMJMENGKFIEEHBMDHNNEGNEBBCCCBII" : "EBGAEIBIKHJJGFJJEEHOFAENHLNBHGNMHMFDAADAAOJNKNKG";
        }
        if (str.startsWith("THPC") || str.startsWith("ACCQ") || str.startsWith("THC") || str.startsWith("TH") || str.startsWith("DGN") || str.startsWith("ACCQ")) {
            NativeCaller.StartPPPP(str, str2, str3, str5, 1);
        } else {
            NativeCaller.StartPPPP(str, str2, str3, str5, 0);
        }
    }

    public void StartPPPP(String str, String str2, String str3) {
        if (str.startsWith("THPC") || str.startsWith("ACCQ") || str.startsWith("THC") || str.startsWith("TH") || str.startsWith("DGN")) {
            NativeCaller.StartPPPP(str, str2, str3, ContentCommon.SERVER_STRING, 1);
        } else {
            NativeCaller.StartPPPP(str, str2, str3, ContentCommon.SERVER_STRING, 0);
        }
    }

    public void StopPPPP(String str) {
        CommonUtil.Log(1, "StartPPPP--StopPPPP停止连接 " + str);
        NativeCaller.StopPPPP(str);
    }

    class MyStopThread extends Thread {
        private String strdidTest;

        public MyStopThread(String str) {
            this.strdidTest = str;
        }

        public void run() {
            NativeCaller.StopPPPP(this.strdidTest);
            super.run();
        }
    }

    class MyStartThread extends Thread {
        private String strdidTest;
        private String strpwdTest;
        private String strserverTest;
        private String struserTest;

        public MyStartThread(String str, String str2, String str3, String str4) {
            this.strdidTest = str;
            this.struserTest = str2;
            this.strpwdTest = str3;
            this.strserverTest = str4;
        }

        public void run() {
            CommonUtil.Log(1, "SHIXDEV---StartPPP1 strdidTest:" + this.strdidTest);
            if (this.strdidTest.startsWith("THPC") || this.strdidTest.startsWith("ACCQ") || this.strdidTest.startsWith("THC") || this.strdidTest.startsWith("TH") || this.strdidTest.startsWith("DGN")) {
                NativeCaller.StartPPPP(this.strdidTest, this.struserTest, this.strpwdTest, this.strserverTest, 1);
            } else {
                NativeCaller.StartPPPP(this.strdidTest, this.struserTest, this.strpwdTest, this.strserverTest, 0);
            }
            super.run();
        }
    }

    public static boolean hasSdcard() {
        return Environment.getExternalStorageState().equals("mounted");
    }

    public boolean checkChinaDID(String str) {
        return str == null || !str.startsWith("DGKC");
    }

    public boolean checkChina1(String str, int i) {
        if ((str != null && str.equalsIgnoreCase("DGK139142YMCCH")) || str.startsWith("THPC") || str.startsWith("ACCQ") || str.startsWith("THC") || str.startsWith("TH") || str.startsWith("DGN") || str.startsWith("IKB") || i == 0) {
            return false;
        }
        if (SystemValue.isInCn != 1 && !CommonUtil.isCN(getContext()) && !getResources().getString(R.string.app_name_show).equalsIgnoreCase("HDWIFI")) {
            return false;
        }
        return true;
    }

    public void delPhoneKey(String str) {
        String deuIp = CommonAppUtil.getDeuIp();
        int deuPort = CommonAppUtil.getDeuPort();
        CommonUtil.LogAPP(2, "SHIX_RegistCyPushCloud t_IP1:" + deuIp + "  t_Port1:" + deuPort);
        StringBuilder sb = new StringBuilder();
        sb.append(deuIp);
        sb.append(":");
        sb.append(deuPort);
        this.testIP = sb.toString();
        this.objA = new JSONObject();
        this.objC = new JSONObject();
        try {
            this.objA.put("userName", "admin");
            this.objA.put("passwd", "admin123");
            this.objC.put("app_id", str);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        new Thread() {
            public void run() {
                super.run();
                PayHttpUtils payHttpUtils = new PayHttpUtils();
                try {
                    String post = payHttpUtils.post("http://" + BaseFragment.this.testIP + "/push/login", BaseFragment.this.objA.toString(), "", "");
                    if (post != null) {
                        if (post.length() >= 1) {
                            BaseFragment.this.rStr = post;
                            CommonUtil.Log(1, "PUSHZHAO_宸云推送登录：rStr：" + BaseFragment.this.rStr);
                            try {
                                JSONObject jSONObject = new JSONObject(BaseFragment.this.rStr);
                                String string = jSONObject.getString("status");
                                if (string != null && string.equalsIgnoreCase("ok")) {
                                    BaseFragment.this.token = jSONObject.getString(IronSourceConstants.EVENTS_RESULT);
                                }
                                if (BaseFragment.this.token != null && BaseFragment.this.token.length() > 10) {
                                    String postA = payHttpUtils.postA("http://" + BaseFragment.this.testIP + "/message/app/appid", BaseFragment.this.objC.toString(), BaseFragment.this.token);
                                    if (postA != null) {
                                        if (postA.length() >= 1) {
                                            BaseFragment.this.rStr = postA;
                                        }
                                    }
                                    BaseFragment.this.rStr = "null";
                                }
                                CommonUtil.Log(1, "PUSHZHAO_宸云推送删除：rStr：" + BaseFragment.this.rStr);
                                return;
                            } catch (JSONException e) {
                                e.printStackTrace();
                                return;
                            }
                        }
                    }
                    BaseFragment.this.rStr = "null";
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
            }
        }.start();
    }

    public void RegistCyPush(String str, String str2, String str3, String str4, String str5) {
        this.testIP = str;
        this.objA = new JSONObject();
        this.objB = new JSONObject();
        try {
            this.objA.put("userName", "admin");
            this.objA.put("passwd", "admin123");
            JSONObject jSONObject = new JSONObject();
            CommonUtil.Log(2, "-------------------PushUtils.PHONETYPE:" + PushUtils.PHONETYPE);
            if (PushUtils.PHONETYPE != 1) {
                if (PushUtils.PHONETYPE != 3) {
                    if (PushUtils.PHONETYPE != 4) {
                        jSONObject.put("packageName", "com.shix.qhipc");
                        jSONObject.put("appSecret", ContentCommon.XM_APP_Secret);
                        jSONObject.put("targetAccount", ContentCommon.XM_REGID);
                        this.objB.put("phoneType", "xiaomi");
                        CommonUtil.Log(2, "-------------------2");
                        this.objB.put("devId", str2);
                        this.objB.put("devKey", str3);
                        this.objB.put("devName", str4);
                        JSONObject jSONObject2 = this.objB;
                        jSONObject2.put("phoneKey", str5 + str2);
                        this.objB.put("platformType", "android");
                        this.objB.put("pushParameter", jSONObject.toString());
                        new Thread() {
                            public void run() {
                                super.run();
                                PayHttpUtils payHttpUtils = new PayHttpUtils();
                                try {
                                    String post = payHttpUtils.post("http://" + BaseFragment.this.testIP + "/push/login", BaseFragment.this.objA.toString(), "", "");
                                    if (post != null) {
                                        if (post.length() >= 1) {
                                            BaseFragment.this.rStr = post;
                                            CommonUtil.Log(1, "宸云推送登录：rStr：" + BaseFragment.this.rStr);
                                            try {
                                                JSONObject jSONObject = new JSONObject(BaseFragment.this.rStr);
                                                String string = jSONObject.getString("status");
                                                if (string != null && string.equalsIgnoreCase("ok")) {
                                                    BaseFragment.this.token = jSONObject.getString(IronSourceConstants.EVENTS_RESULT);
                                                }
                                                if (BaseFragment.this.token != null && BaseFragment.this.token.length() > 10) {
                                                    String postA = payHttpUtils.postA("http://" + BaseFragment.this.testIP + "/push/dev/add", BaseFragment.this.objB.toString(), BaseFragment.this.token);
                                                    if (postA != null) {
                                                        if (postA.length() >= 1) {
                                                            BaseFragment.this.rStr = post;
                                                        }
                                                    }
                                                    BaseFragment.this.rStr = "null";
                                                }
                                                CommonUtil.Log(1, "宸云推送注册：rStr：" + BaseFragment.this.rStr);
                                                return;
                                            } catch (JSONException e) {
                                                e.printStackTrace();
                                                return;
                                            }
                                        }
                                    }
                                    BaseFragment.this.rStr = "null";
                                } catch (IOException e2) {
                                    e2.printStackTrace();
                                }
                            }
                        }.start();
                    }
                }
            }
            jSONObject.put("hw_app_id", ContentCommon.HW_APP_ID);
            jSONObject.put("hw_app_secret", ContentCommon.HW_APPSECRET);
            jSONObject.put("hw_token", ContentCommon.HW_STRING);
            this.objB.put("phoneType", "huawei");
            CommonUtil.Log(2, "-------------------1");
            this.objB.put("devId", str2);
            this.objB.put("devKey", str3);
            this.objB.put("devName", str4);
            JSONObject jSONObject22 = this.objB;
            jSONObject22.put("phoneKey", str5 + str2);
            this.objB.put("platformType", "android");
            this.objB.put("pushParameter", jSONObject.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        new Thread() {
            public void run() {
                super.run();
                PayHttpUtils payHttpUtils = new PayHttpUtils();
                try {
                    String post = payHttpUtils.post("http://" + BaseFragment.this.testIP + "/push/login", BaseFragment.this.objA.toString(), "", "");
                    if (post != null) {
                        if (post.length() >= 1) {
                            BaseFragment.this.rStr = post;
                            CommonUtil.Log(1, "宸云推送登录：rStr：" + BaseFragment.this.rStr);
                            try {
                                JSONObject jSONObject = new JSONObject(BaseFragment.this.rStr);
                                String string = jSONObject.getString("status");
                                if (string != null && string.equalsIgnoreCase("ok")) {
                                    BaseFragment.this.token = jSONObject.getString(IronSourceConstants.EVENTS_RESULT);
                                }
                                if (BaseFragment.this.token != null && BaseFragment.this.token.length() > 10) {
                                    String postA = payHttpUtils.postA("http://" + BaseFragment.this.testIP + "/push/dev/add", BaseFragment.this.objB.toString(), BaseFragment.this.token);
                                    if (postA != null) {
                                        if (postA.length() >= 1) {
                                            BaseFragment.this.rStr = post;
                                        }
                                    }
                                    BaseFragment.this.rStr = "null";
                                }
                                CommonUtil.Log(1, "宸云推送注册：rStr：" + BaseFragment.this.rStr);
                                return;
                            } catch (JSONException e) {
                                e.printStackTrace();
                                return;
                            }
                        }
                    }
                    BaseFragment.this.rStr = "null";
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
            }
        }.start();
    }
}
