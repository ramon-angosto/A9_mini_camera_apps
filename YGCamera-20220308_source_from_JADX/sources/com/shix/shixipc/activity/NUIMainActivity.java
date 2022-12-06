package com.shix.shixipc.activity;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.app.NotificationManager;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.InstanceIdResult;
import com.huawei.agconnect.config.AGConnectServicesConfig;
import com.huawei.hms.aaid.HmsInstanceId;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.push.HmsMessaging;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.shix.shixipc.CrashApplication;
import com.shix.shixipc.activity.FragmentCameraList;
import com.shix.shixipc.activity.FragmentMe;
import com.shix.shixipc.system.ContentCommon;
import com.shix.shixipc.system.StyleCommon;
import com.shix.shixipc.system.SystemValue;
import com.shix.shixipc.utils.CommonUtil;
import com.shix.shixipc.utils.SystemBarTintManager;
import com.xiaomi.mipush.sdk.MiPushClient;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import object.p2pipcam.nativecaller.NativeCaller;
import org.json.JSONException;
import org.json.JSONObject;
import shix.cykj.camera.R;

public class NUIMainActivity extends AppCompatActivity implements View.OnTouchListener, View.OnClickListener, FragmentCameraList.NewUiMainInterface, FragmentMe.LogoutInterface {
    private static AddCameraInterface1 addCameraInterface;
    private static ConnectStatusInterface1 connectStatusInterface;
    private static IPPlayInterface ipPlayInterface;
    private static IpcamClientInterface ipcamClientInterface;
    private static PlayBackInterface playBackInterface;
    private static PlayInterface playInterface;
    private static SHIXCOMMONInterface shixOMMONInterface;
    /* access modifiers changed from: private */
    public String TAG = "NUIMainActivity";
    private LinearLayout bottom_tab;
    private FrameLayout container;
    private int devType;
    private FragmentCameraList fragmentCameraList;
    private FragmentFile fragmentFile;
    private FragmentManager fragmentManager;
    private FragmentMe fragmentMe;
    private ImageView imageView1;
    private ImageView imageView2;
    private ImageView imageView3;
    private ImageView imageView4;
    private boolean isGetSnap;
    private boolean isSnap;
    private LinearLayout layoutAbout;
    private LinearLayout layoutAlarm;
    private LinearLayout layoutPic;
    private LinearLayout layoutVid;
    private LinearLayout layoutVidicon;
    /* access modifiers changed from: private */
    public int mFinalCount = 0;
    private SharedPreferences preSHIX;
    /* access modifiers changed from: private */
    public SharedPreferences preuser;
    private int snapCount = 0;
    private TextView textView1;
    private TextView textView2;
    private TextView textView3;
    private TextView textView4;

    public interface AddCameraInterface1 {
        void callBackSearchResultData(int i, String str, String str2, String str3, String str4, int i2);
    }

    public interface ConnectStatusInterface1 {
        void BSCallBack_TYPEMODE(String str, String str2);

        void BSMsgNotifyData(String str, int i, int i2);
    }

    public interface IPPlayInterface {
        void callBaceVideoData(String str, byte[] bArr, int i, int i2, int i3, int i4);

        void callBackAudioData(byte[] bArr, int i);

        void callBackCameraParamNotify(String str, int i, int i2, int i3, int i4, int i5, int i6);

        void callBackH264Data(byte[] bArr, int i, int i2);

        void callBackMessageNotify(String str, int i, int i2);
    }

    public interface IpcamClientInterface {
        void BSMsgNotifyData(String str, int i, int i2);

        void BSSnapshotNotify(String str, byte[] bArr, int i);

        void callBaceVideoData(String str, byte[] bArr, int i, int i2, int i3, int i4);

        void callBackAudioData(byte[] bArr, int i);

        void callBackH264Data(String str, byte[] bArr, int i, int i2);

        void callBackMessageNotify(String str, int i, int i2);
    }

    public interface PlayBackInterface {
        void CallBackSHIXJasonCommon(String str, String str2);

        void callBackH264Data(String str, byte[] bArr, int i, int i2);

        void callBackPlaybackAudioData(byte[] bArr, int i);

        void callBackPlaybackVideoData(byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6, int i7);
    }

    public interface PlayInterface {
        void callBaceVideoData(String str, byte[] bArr, int i, int i2, int i3, int i4, int i5);

        void callBackAudioData(byte[] bArr, int i);

        void callBackCameraParamNotify(String str, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10);

        void callBackConnectLook(String str, int i, int i2);

        void callBackH264Data(String str, byte[] bArr, int i, int i2);

        void callBackMessageNotify(String str, int i, int i2);
    }

    public interface SHIXCOMMONInterface {
        void CallBackSHIXJasonCommon(String str, String str2);
    }

    private void CallBack_RecordFileSearchResult(String str, String str2, int i, int i2, int i3, int i4, int i5, int i6) {
    }

    public void CallBack_Checkhandle(String str, String str2, String str3, String str4, int i) {
    }

    public void CallBack_MJTCPTrans(String str, String str2) {
    }

    public void CallBack_VideoTrans_H264H265(String str, byte[] bArr, int i, int i2, int i3) {
    }

    public void MessageNotifyDNS(int i) {
    }

    static /* synthetic */ int access$008(NUIMainActivity nUIMainActivity) {
        int i = nUIMainActivity.mFinalCount;
        nUIMainActivity.mFinalCount = i + 1;
        return i;
    }

    static /* synthetic */ int access$010(NUIMainActivity nUIMainActivity) {
        int i = nUIMainActivity.mFinalCount;
        nUIMainActivity.mFinalCount = i - 1;
        return i;
    }

    public void LogOutClick() {
        SharedPreferences.Editor edit = this.preSHIX.edit();
        edit.putString(ContentCommon.SHIX_LONGIN_PWD, "");
        edit.commit();
        finish();
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        super.onStop();
        if (!isAppOnForeground()) {
            finish();
        }
    }

    public void AudioDataPlayBack(byte[] bArr, int i) {
        CommonUtil.Log(1, "AudioDataPlayBack");
    }

    public void AudioPCMDataPlayBack(byte[] bArr, int i, int i2) {
        CommonUtil.Log(1, "AudioPCMDataPlayBack");
        PlayBackInterface playBackInterface2 = playBackInterface;
        if (playBackInterface2 != null) {
            playBackInterface2.callBackPlaybackAudioData(bArr, i);
        }
    }

    public boolean isAppOnForeground() {
        String packageName = getApplicationContext().getPackageName();
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) getApplicationContext().getSystemService("activity")).getRunningAppProcesses();
        if (runningAppProcesses == null) {
            return false;
        }
        for (ActivityManager.RunningAppProcessInfo next : runningAppProcesses) {
            if (next.processName.equals(packageName) && next.importance == 100) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.aictivity_nuimain);
        CommonUtil.checkPermissionAll(this);
        SystemValue.isInCn = 0;
        this.preuser = getSharedPreferences("shix_zhao_user", 0);
        this.preSHIX = getSharedPreferences(ContentCommon.SHIXLOGUSERPWD, 0);
        SystemValue.isInCn = this.preuser.getInt("isInCn", 0);
        this.fragmentManager = getSupportFragmentManager();
        if (SystemValue.isInCn != 1) {
            GetNetIpSOHU();
        }
        getFCMToken();
        findViewInit();
        setTabSelection(0);
        this.bottom_tab = (LinearLayout) findViewById(R.id.bottom_tab);
        getToken();
        CommonUtil.Log(1, "FCMTOKEN:" + "");
        NativeCaller.PPPPSetCallbackContext(this);
        FragmentMe.setLogoutInterface(this);
        this.isGetSnap = true;
        this.isSnap = true;
        this.snapCount = 0;
        int do1 = CommonUtil.do1(CommonUtil.do1(0, 4), 5);
        CommonUtil.Log(1, "pustType:" + do1);
        FragmentCameraList.setNewUiMainInterface(this);
        SystemValue.isExitBackGoudExit = true;
        CrashApplication.getInstance().registerActivityLifecycleCallbacks(new Application.ActivityLifecycleCallbacks() {
            public void onActivityCreated(Activity activity, Bundle bundle) {
            }

            public void onActivityDestroyed(Activity activity) {
            }

            public void onActivityPaused(Activity activity) {
            }

            public void onActivityResumed(Activity activity) {
            }

            public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            }

            public void onActivityStarted(Activity activity) {
                NUIMainActivity.access$008(NUIMainActivity.this);
            }

            public void onActivityStopped(Activity activity) {
                NUIMainActivity.access$010(NUIMainActivity.this);
                if (NUIMainActivity.this.mFinalCount == 0) {
                    CommonUtil.Log(1, "进入后台运行");
                    boolean z = SystemValue.isExitBackGoudExit;
                }
            }
        });
    }

    private void getFCMToken() {
        ContentCommon.FCM_TOKEN = CommonUtil.GetCommonShareStringValue(this, "FCMTOKEN", "");
        FirebaseInstanceId.getInstance().getInstanceId().addOnCompleteListener(new OnCompleteListener<InstanceIdResult>() {
            public void onComplete(Task<InstanceIdResult> task) {
                if (!task.isSuccessful()) {
                    Log.w(NUIMainActivity.this.TAG, "getInstanceId failed", task.getException());
                    return;
                }
                String token = task.getResult().getToken();
                ContentCommon.FCM_TOKEN = token;
                if (token != null) {
                    CommonUtil.SaveCommonShare(NUIMainActivity.this, "FCMTOKEN", token, -1);
                }
                String access$100 = NUIMainActivity.this.TAG;
                Log.d(access$100, "FCMTOKEN:" + token);
            }
        });
    }

    private void getToken() {
        new Thread() {
            public void run() {
                try {
                    ContentCommon.XM_REGID = MiPushClient.getRegId(NUIMainActivity.this);
                    CommonUtil.Log(1, "小米推送 XM_REGID：" + ContentCommon.XM_REGID);
                    String string = AGConnectServicesConfig.fromContext(NUIMainActivity.this).getString("client/app_id");
                    String access$100 = NUIMainActivity.this.TAG;
                    Log.i(access$100, "get token:    appId:" + string + "   tokenScope:" + HmsMessaging.DEFAULT_TOKEN_SCOPE);
                    String token = HmsInstanceId.getInstance(NUIMainActivity.this).getToken(string, HmsMessaging.DEFAULT_TOKEN_SCOPE);
                    String access$1002 = NUIMainActivity.this.TAG;
                    Log.i(access$1002, "get token: " + token + "   appId:" + string + "   tokenScope:" + HmsMessaging.DEFAULT_TOKEN_SCOPE);
                    if (ContentCommon.HW_STRING == null || ContentCommon.HW_STRING.length() < 5) {
                        ContentCommon.HW_STRING = token;
                    }
                    if (!TextUtils.isEmpty(token)) {
                        NUIMainActivity.this.sendRegTokenToServer(token);
                    }
                } catch (ApiException e) {
                    String access$1003 = NUIMainActivity.this.TAG;
                    Log.e(access$1003, "get token failed, " + e);
                }
            }
        }.start();
    }

    /* access modifiers changed from: private */
    public void sendRegTokenToServer(String str) {
        String str2 = this.TAG;
        Log.i(str2, "sending token to server. token:" + str);
    }

    public void GetNetIpSOHU() {
        new Thread() {
            public void run() {
                try {
                    HttpURLConnection httpURLConnection = (HttpURLConnection) new URL("http://pv.sohu.com/cityjson?ie=utf-8").openConnection();
                    if (httpURLConnection.getResponseCode() == 200) {
                        InputStream inputStream = httpURLConnection.getInputStream();
                        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "utf-8"));
                        StringBuilder sb = new StringBuilder();
                        while (true) {
                            String readLine = bufferedReader.readLine();
                            if (readLine == null) {
                                break;
                            }
                            sb.append(readLine + "\n");
                        }
                        inputStream.close();
                        String substring = sb.substring(sb.indexOf("{"), sb.indexOf("}") + 1);
                        if (substring != null) {
                            try {
                                String optString = new JSONObject(substring).optString("cname");
                                CommonUtil.Log(1, "CHANA line:" + optString);
                                if (optString != null && optString.length() > 0) {
                                    if (CommonUtil.isContainChinese(optString)) {
                                        SystemValue.isInCn = 1;
                                    } else {
                                        SystemValue.isInCn = 2;
                                    }
                                    CommonUtil.Log(1, "CHANA SystemValue.isInCn:" + SystemValue.isInCn);
                                    SharedPreferences.Editor edit = NUIMainActivity.this.preuser.edit();
                                    edit.putInt("isInCn", SystemValue.isInCn);
                                    edit.commit();
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                } catch (MalformedURLException e2) {
                    e2.printStackTrace();
                } catch (IOException e3) {
                    e3.printStackTrace();
                }
                NUIMainActivity.this.GetNetIp();
            }
        }.start();
    }

    public String GetNetIp() {
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL("http://ip.taobao.com/service/getIpInfo2.php?ip=myip").openConnection();
            httpURLConnection.setUseCaches(false);
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setRequestProperty("user-agent", "Mozilla/5.0 (Windows NT 6.3; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2704.7 Safari/537.36");
            if (httpURLConnection.getResponseCode() == 200) {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
                StringBuilder sb = new StringBuilder();
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    sb.append(readLine + "\n");
                }
                JSONObject jSONObject = new JSONObject(sb.toString());
                String string = jSONObject.getString("code");
                Log.e("", "提示：" + sb.toString());
                if (string.equals("0")) {
                    String string2 = jSONObject.getJSONObject(RemoteMessageConst.DATA).getString("country");
                    CommonUtil.Log(1, "CHANA IP:" + string2);
                    if (string2 != null && string2.length() > 0) {
                        if (!CommonUtil.isContainChinese(string2) && !string2.equalsIgnoreCase("中国")) {
                            if (!string2.equalsIgnoreCase("cn")) {
                                SystemValue.isInCn = 2;
                                CommonUtil.Log(1, "CHANA IP isInCn:" + SystemValue.isInCn);
                                SharedPreferences.Editor edit = this.preuser.edit();
                                edit.putInt("isInCn", SystemValue.isInCn);
                                edit.commit();
                            }
                        }
                        SystemValue.isInCn = 1;
                        CommonUtil.Log(1, "CHANA IP isInCn:" + SystemValue.isInCn);
                        SharedPreferences.Editor edit2 = this.preuser.edit();
                        edit2.putInt("isInCn", SystemValue.isInCn);
                        edit2.commit();
                    }
                    Log.e("提示", "您的IP地址是：" + string2);
                    return string2;
                }
                Log.e("提示", "IP接口异常，无法获取IP地址！");
                return "";
            }
            Log.e("提示", "网络连接异常，无法获取IP地址！");
            return "";
        } catch (Exception e) {
            Log.e("提示", "获取IP地址时出现异常，异常信息是：" + e.toString());
            return "";
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (ContentCommon.ISVISI.booleanValue()) {
            CommonUtil.Vibrate(this, 10);
        }
        if (i == 82) {
            return false;
        }
        if (i != 4) {
            return super.onKeyDown(i, keyEvent);
        }
        finish();
        return true;
    }

    private void setTranslucentStatus(Activity activity, boolean z) {
        Window window = activity.getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        if (z) {
            attributes.flags |= 67108864;
        } else {
            attributes.flags &= -67108865;
        }
        window.setAttributes(attributes);
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        if (Build.VERSION.SDK_INT >= 19) {
            setTranslucentStatus(this, true);
        }
        SystemBarTintManager systemBarTintManager = new SystemBarTintManager(this);
        systemBarTintManager.setStatusBarTintEnabled(true);
        systemBarTintManager.setStatusBarTintResource(StyleCommon.Color_All_Backgroud);
        this.isGetSnap = true;
        super.onResume();
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        this.isGetSnap = false;
        super.onPause();
    }

    private void findViewInit() {
        this.layoutVidicon = (LinearLayout) findViewById(R.id.main_layout_vidicon);
        this.layoutAlarm = (LinearLayout) findViewById(R.id.main_layout_alarm);
        this.layoutPic = (LinearLayout) findViewById(R.id.main_layout_pic);
        this.layoutVid = (LinearLayout) findViewById(R.id.main_layout_vid);
        this.layoutAbout = (LinearLayout) findViewById(R.id.main_layout_about);
        this.container = (FrameLayout) findViewById(R.id.content);
        this.layoutVidicon.setOnTouchListener(this);
        this.layoutAlarm.setOnTouchListener(this);
        this.layoutPic.setOnTouchListener(this);
        this.layoutVid.setOnTouchListener(this);
        this.layoutAbout.setOnTouchListener(this);
        this.imageView1 = (ImageView) findViewById(R.id.main_img_vidicon);
        this.imageView2 = (ImageView) findViewById(R.id.main_img_alarm);
        this.imageView3 = (ImageView) findViewById(R.id.main_img_picture);
        this.imageView4 = (ImageView) findViewById(R.id.main_img_vid);
        this.textView1 = (TextView) findViewById(R.id.main_tv_vidicon);
        this.textView2 = (TextView) findViewById(R.id.main_tv_alarm);
        this.textView3 = (TextView) findViewById(R.id.main_tv_picture);
        this.textView4 = (TextView) findViewById(R.id.main_tv_vid);
    }

    public void onClick(View view) {
        if (ContentCommon.ISVISI.booleanValue()) {
            CommonUtil.Vibrate(this, 10);
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        NativeCaller.Free();
        SystemValue.checkSDStatu = 0;
        ((NotificationManager) getSystemService(RemoteMessageConst.NOTIFICATION)).cancel(1514);
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (ContentCommon.ISVISI.booleanValue()) {
            CommonUtil.Vibrate(this, 10);
        }
        if (motionEvent.getAction() == 0) {
            switch (view.getId()) {
                case R.id.main_layout_pic /*2131165656*/:
                    this.isGetSnap = false;
                    setTabSelection(1);
                    break;
                case R.id.main_layout_vid /*2131165657*/:
                    this.isGetSnap = false;
                    setTabSelection(2);
                    break;
                case R.id.main_layout_vidicon /*2131165658*/:
                    this.isGetSnap = true;
                    setTabSelection(0);
                    break;
            }
        }
        return false;
    }

    private void setTabSelection(int i) {
        clearSelection();
        FragmentTransaction beginTransaction = this.fragmentManager.beginTransaction();
        hideFragments(beginTransaction);
        if (i == 0) {
            this.imageView1.setImageResource(StyleCommon.IMG_Menu_Camera_Press);
            this.textView1.setTextColor(getResources().getColor(StyleCommon.Color_Menu_Press));
            FragmentCameraList fragmentCameraList2 = this.fragmentCameraList;
            if (fragmentCameraList2 == null) {
                this.fragmentCameraList = new FragmentCameraList();
                beginTransaction.add((int) R.id.content, (Fragment) this.fragmentCameraList);
            } else {
                beginTransaction.show(fragmentCameraList2);
            }
        } else if (i == 1) {
            this.imageView3.setImageResource(StyleCommon.IMG_Menu_Alarm_Press);
            this.textView3.setTextColor(getResources().getColor(StyleCommon.Color_Menu_Press));
            FragmentFile fragmentFile2 = this.fragmentFile;
            if (fragmentFile2 == null) {
                this.fragmentFile = new FragmentFile();
                beginTransaction.add((int) R.id.content, (Fragment) this.fragmentFile);
            } else {
                beginTransaction.show(fragmentFile2);
            }
        } else if (i != 2) {
            this.imageView4.setImageResource(StyleCommon.IMG_Menu_Video_Press);
            this.textView4.setTextColor(getResources().getColor(StyleCommon.Color_Menu_Press));
        } else {
            this.imageView4.setImageResource(StyleCommon.IMG_Menu_Pic_Press);
            this.textView4.setTextColor(getResources().getColor(StyleCommon.Color_Menu_Press));
            FragmentMe fragmentMe2 = this.fragmentMe;
            if (fragmentMe2 == null) {
                this.fragmentMe = new FragmentMe();
                beginTransaction.add((int) R.id.content, (Fragment) this.fragmentMe);
            } else {
                beginTransaction.show(fragmentMe2);
            }
        }
        beginTransaction.commit();
    }

    private void clearSelection() {
        this.imageView1.setImageResource(StyleCommon.IMG_Menu_Camera);
        this.imageView2.setImageResource(StyleCommon.IMG_Menu_Alarm);
        this.imageView3.setImageResource(StyleCommon.IMG_Menu_Pic);
        this.imageView4.setImageResource(StyleCommon.IMG_Menu_Video);
        this.textView1.setTextColor(getResources().getColor(StyleCommon.Color_Menu_Normal));
        this.textView2.setTextColor(getResources().getColor(StyleCommon.Color_Menu_Normal));
        this.textView3.setTextColor(getResources().getColor(StyleCommon.Color_Menu_Normal));
        this.textView4.setTextColor(getResources().getColor(StyleCommon.Color_Menu_Normal));
    }

    private void hideFragments(FragmentTransaction fragmentTransaction) {
        FragmentFile fragmentFile2 = this.fragmentFile;
        if (fragmentFile2 != null) {
            fragmentTransaction.hide(fragmentFile2);
        }
        FragmentCameraList fragmentCameraList2 = this.fragmentCameraList;
        if (fragmentCameraList2 != null) {
            fragmentTransaction.hide(fragmentCameraList2);
        }
        FragmentMe fragmentMe2 = this.fragmentMe;
        if (fragmentMe2 != null) {
            fragmentTransaction.hide(fragmentMe2);
        }
    }

    public void CallBackStyle(int i) {
        StyleCommon.COM_STYLE = i;
        if (StyleCommon.COM_STYLE == 1) {
            this.bottom_tab.setVisibility(8);
        } else {
            this.bottom_tab.setVisibility(0);
        }
    }

    public void CallBackTransferMessage(String str, String str2, int i) {
        CommonUtil.Log(1, "SHIXCONNET SHIXTRANS did:" + str + "  buffer:" + str2);
        String substring = str2.substring(str2.indexOf("{"), str2.indexOf("}") + 1);
        CommonUtil.Log(1, "SHIXCONNET SHIXTRANS did:" + str + "  strJason:" + substring + "LEN:" + substring.length());
        SHIXCOMMONInterface sHIXCOMMONInterface = shixOMMONInterface;
        if (sHIXCOMMONInterface != null) {
            sHIXCOMMONInterface.CallBackSHIXJasonCommon(str, str2);
        }
        PlayBackInterface playBackInterface2 = playBackInterface;
        if (playBackInterface2 != null) {
            playBackInterface2.CallBackSHIXJasonCommon(str, str2);
        }
    }

    public void CallBack_TYPEMODE(String str, String str2) {
        ConnectStatusInterface1 connectStatusInterface1 = connectStatusInterface;
        if (connectStatusInterface1 != null) {
            connectStatusInterface1.BSCallBack_TYPEMODE(str, str2);
        }
    }

    private void VideoData(String str, byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6) {
        byte[] bArr2 = bArr;
        String str2 = this.TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("SHIXCONNET VideoData...h264Data: ");
        int i7 = i;
        sb.append(i);
        sb.append(" len: ");
        sb.append(i2);
        sb.append(" videobuf len: ");
        sb.append(bArr2.length);
        sb.append("  time==");
        sb.append(i5);
        Log.d(str2, sb.toString());
        IpcamClientInterface ipcamClientInterface2 = ipcamClientInterface;
        if (ipcamClientInterface2 != null) {
            ipcamClientInterface2.callBaceVideoData(str, bArr, i, i2, i3, i4);
        }
        PlayInterface playInterface2 = playInterface;
        if (playInterface2 != null) {
            playInterface2.callBaceVideoData(str, bArr, i, bArr2.length, i3, i4, i5);
        }
        IPPlayInterface iPPlayInterface = ipPlayInterface;
        if (iPPlayInterface != null) {
            iPPlayInterface.callBaceVideoData(str, bArr, i, i2, i3, i4);
        }
    }

    public void MessageNotify(String str, int i, int i2) {
        Log.d("test_four_2", "SHIXCONNET MessageNotify did: " + str + " msgType: " + i + " param: " + i2);
    }

    public void AudioData(byte[] bArr, int i) {
        String str = this.TAG;
        Log.d(str, "SHIXCONNET AudioData: len :+ " + i);
        IpcamClientInterface ipcamClientInterface2 = ipcamClientInterface;
        if (ipcamClientInterface2 != null) {
            ipcamClientInterface2.callBackAudioData(bArr, i);
        }
        PlayInterface playInterface2 = playInterface;
        if (playInterface2 != null) {
            playInterface2.callBackAudioData(bArr, i);
        }
        PlayBackInterface playBackInterface2 = playBackInterface;
        if (playBackInterface2 != null) {
            playBackInterface2.callBackPlaybackAudioData(bArr, i);
        }
    }

    public void PPPPMsgNotify(String str, int i, int i2) {
        String str2 = this.TAG;
        Log.d(str2, "SHIXCONNET PPPPMsgNotify  did:" + str + " type:" + i + " param:" + i2);
        PlayInterface playInterface2 = playInterface;
        if (playInterface2 != null) {
            playInterface2.callBackMessageNotify(str, i, i2);
        }
        IPPlayInterface iPPlayInterface = ipPlayInterface;
        if (iPPlayInterface != null) {
            iPPlayInterface.callBackMessageNotify(str, i, i2);
        }
        IpcamClientInterface ipcamClientInterface2 = ipcamClientInterface;
        if (ipcamClientInterface2 != null) {
            ipcamClientInterface2.BSMsgNotifyData(str, i, i2);
        }
        ConnectStatusInterface1 connectStatusInterface1 = connectStatusInterface;
        if (connectStatusInterface1 != null) {
            connectStatusInterface1.BSMsgNotifyData(str, i, i2);
        }
    }

    public void SearchResult(int i, String str, String str2, String str3, String str4, int i2) {
        AddCameraInterface1 addCameraInterface1;
        String str5 = this.TAG;
        Log.d(str5, "SHIXCONNET SearchResult1: " + str4 + " " + i2);
        if (str3.length() != 0 && (addCameraInterface1 = addCameraInterface) != null) {
            addCameraInterface1.callBackSearchResultData(i, str, str2, str3, str4, i2);
        }
    }

    private void PPPPSnapshotNotify(String str, byte[] bArr, int i) {
        String str2 = this.TAG;
        Log.d(str2, "SHIXCONNET did:" + str + " len:" + i);
        IpcamClientInterface ipcamClientInterface2 = ipcamClientInterface;
        if (ipcamClientInterface2 != null) {
            ipcamClientInterface2.BSSnapshotNotify(str, bArr, i);
        }
    }

    public void CallBack_Snapshot(String str, byte[] bArr, int i) {
        Log.d("ddd", "SHIXCONNET CallBack_Snapshot");
        IpcamClientInterface ipcamClientInterface2 = ipcamClientInterface;
        if (ipcamClientInterface2 != null) {
            ipcamClientInterface2.BSSnapshotNotify(str, bArr, i);
        }
    }

    public void CallBack_AlarmNotifyDoorBell(String str, String str2, String str3, String str4) {
        Log.e(ContentCommon.SERVER_STRING, "doorbell:db_did:" + str3 + "  db_type:" + str4 + "  db_time:" + str2);
    }

    public void CallBack_AlarmNotify(String str, int i) {
        Log.d(RemoteMessageConst.Notification.TAG, "callBack_AlarmNotify did:" + str + " alarmtype:" + i);
    }

    public void CallBack_AlarmNotify(String str, String str2) {
        Log.d(RemoteMessageConst.Notification.TAG, "callBack_AlarmNotify did:" + str + " alarmtype:" + str2);
    }

    public void CallBack_PlaybackVideoData(String str, byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        StringBuilder sb = new StringBuilder();
        sb.append("CallBack_PlaybackVideoData  len:");
        int i9 = i2;
        sb.append(i2);
        sb.append(" width:");
        sb.append(i3);
        sb.append(" height:");
        sb.append(i4);
        sb.append("  time:");
        sb.append(i5);
        Log.e("zhaogenghuai", sb.toString());
        PlayBackInterface playBackInterface2 = playBackInterface;
        if (playBackInterface2 != null) {
            playBackInterface2.callBackPlaybackVideoData(bArr, i, i2, i3, i4, i5, i7, i8);
        }
    }

    public void CallBack_H264Data(String str, byte[] bArr, int i, int i2, int i3) {
        Log.e(RemoteMessageConst.Notification.TAG, "did=" + str + "  h264=" + bArr.length);
        IpcamClientInterface ipcamClientInterface2 = ipcamClientInterface;
        if (ipcamClientInterface2 != null) {
            ipcamClientInterface2.callBackH264Data(str, bArr, i, i2);
        }
        PlayInterface playInterface2 = playInterface;
        if (playInterface2 != null) {
            playInterface2.callBackH264Data(str, bArr, i, i2);
        }
        PlayBackInterface playBackInterface2 = playBackInterface;
        if (playBackInterface2 != null) {
            playBackInterface2.callBackH264Data(str, bArr, i, i2);
        }
    }

    public static void setIpcamClientInterface(IpcamClientInterface ipcamClientInterface2) {
        ipcamClientInterface = ipcamClientInterface2;
    }

    public static void setAddCameraInterface1(AddCameraInterface1 addCameraInterface1) {
        addCameraInterface = addCameraInterface1;
    }

    public static void setSHIXCOMMONInterface(SHIXCOMMONInterface sHIXCOMMONInterface) {
        shixOMMONInterface = sHIXCOMMONInterface;
    }

    public static void setConnectStatusInterface1(ConnectStatusInterface1 connectStatusInterface1) {
        connectStatusInterface = connectStatusInterface1;
    }

    public static void setPlayInterface(PlayInterface playInterface2) {
        playInterface = playInterface2;
    }

    public static void setIpPlayInterface(IPPlayInterface iPPlayInterface) {
        ipPlayInterface = iPPlayInterface;
    }

    public static void setPlayBackInterface(PlayBackInterface playBackInterface2) {
        playBackInterface = playBackInterface2;
    }
}
