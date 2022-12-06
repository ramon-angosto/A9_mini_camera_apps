package shix.ihdbell.project;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.jxl.app.littlestars.project.R;
import object.p2pipcam.content.ContentCommon;
import object.p2pipcam.nativecaller.NativeCaller;
import object.p2pipcam.system.SystemValue;
import object.p2pipcam.utils.CommonUtil;
import object.p2pipcam.utils.VibratorUtil;
import shix.ihdbell.project.BridgeService;

public class SettingUserActivity extends BaseActivity implements View.OnClickListener, BridgeService.DoorBellUserInterface, BridgeService.UserInterface {
    private final int PARMS = 110;
    /* access modifiers changed from: private */
    public int admin;
    private String adminIsWho = "";
    private String alias;
    private Button btn_cancel;
    private Button btn_create;
    /* access modifiers changed from: private */
    public Button btn_del1;
    /* access modifiers changed from: private */
    public Button btn_del2;
    /* access modifiers changed from: private */
    public Button btn_del3;
    /* access modifiers changed from: private */
    public Button btn_del4;
    /* access modifiers changed from: private */
    public Button btn_del5;
    /* access modifiers changed from: private */
    public Button btn_del6;
    /* access modifiers changed from: private */
    public Button btn_del7;
    /* access modifiers changed from: private */
    public Button btn_del8;
    /* access modifiers changed from: private */
    public Button btn_edit1;
    /* access modifiers changed from: private */
    public Button btn_edit2;
    /* access modifiers changed from: private */
    public Button btn_edit3;
    /* access modifiers changed from: private */
    public Button btn_edit4;
    /* access modifiers changed from: private */
    public Button btn_edit5;
    /* access modifiers changed from: private */
    public Button btn_edit6;
    /* access modifiers changed from: private */
    public Button btn_edit7;
    /* access modifiers changed from: private */
    public Button btn_edit8;
    private Button button_cancel;
    /* access modifiers changed from: private */
    public Button button_ok;
    /* access modifiers changed from: private */
    public String cameraName = null;
    private EditText editText_GroupName;
    private EditText editText_GroupName_pass;
    /* access modifiers changed from: private */
    public Handler handler = new Handler() {
        public void handleMessage(Message message) {
            if (message.what == 110) {
                if (SettingUserActivity.this.user1 == null || SettingUserActivity.this.user1.length() <= 3) {
                    SettingUserActivity.this.liner_user1.setVisibility(8);
                } else {
                    SettingUserActivity.this.liner_user1.setVisibility(0);
                    TextView access$200 = SettingUserActivity.this.tv_user_show1;
                    access$200.setText(SettingUserActivity.this.getResources().getString(R.string.doorbell_setting_user) + "1");
                    SettingUserActivity.this.tv_user1.setText(SettingUserActivity.this.user1);
                    if (SettingUserActivity.this.s1 == 0) {
                        SettingUserActivity.this.tv_statu1.setText(R.string.doorbell_setting_user_statu0);
                    } else if (SettingUserActivity.this.s1 == 1) {
                        SettingUserActivity.this.tv_statu1.setText(R.string.doorbell_setting_user_statu1);
                    } else if (SettingUserActivity.this.s1 == 2) {
                        SettingUserActivity.this.tv_statu1.setText(R.string.doorbell_setting_user_statu2);
                    } else {
                        SettingUserActivity.this.tv_statu1.setText(R.string.doorbell_setting_user_statu3);
                    }
                    if (SystemValue.isLitos) {
                        SettingUserActivity.this.tv_statu1.setVisibility(8);
                    }
                    if (SettingUserActivity.this.user1.equalsIgnoreCase(SystemValue.doorBellAdmin)) {
                        SettingUserActivity.this.btn_edit1.setVisibility(0);
                    } else {
                        SettingUserActivity.this.btn_edit1.setVisibility(8);
                    }
                }
                if (SettingUserActivity.this.user2 == null || SettingUserActivity.this.user2.length() <= 3) {
                    SettingUserActivity.this.liner_user2.setVisibility(8);
                } else {
                    SettingUserActivity.this.liner_user2.setVisibility(0);
                    TextView access$900 = SettingUserActivity.this.tv_user_show2;
                    access$900.setText(SettingUserActivity.this.getResources().getString(R.string.doorbell_setting_user) + "2");
                    SettingUserActivity.this.tv_user2.setText(SettingUserActivity.this.user2);
                    if (SettingUserActivity.this.s2 == 0) {
                        SettingUserActivity.this.tv_statu2.setText(R.string.doorbell_setting_user_statu0);
                    } else if (SettingUserActivity.this.s2 == 1) {
                        SettingUserActivity.this.tv_statu2.setText(R.string.doorbell_setting_user_statu1);
                    } else if (SettingUserActivity.this.s2 == 2) {
                        SettingUserActivity.this.tv_statu2.setText(R.string.doorbell_setting_user_statu2);
                    } else {
                        SettingUserActivity.this.tv_statu2.setText(R.string.doorbell_setting_user_statu3);
                    }
                    if (SettingUserActivity.this.user2.equalsIgnoreCase(SystemValue.doorBellAdmin)) {
                        SettingUserActivity.this.btn_edit2.setVisibility(0);
                    } else {
                        SettingUserActivity.this.btn_edit2.setVisibility(8);
                    }
                    if (SystemValue.isLitos) {
                        SettingUserActivity.this.tv_statu2.setVisibility(8);
                        SettingUserActivity.this.btn_edit2.setVisibility(8);
                    }
                }
                if (SettingUserActivity.this.user3 == null || SettingUserActivity.this.user3.length() <= 3) {
                    SettingUserActivity.this.liner_user3.setVisibility(8);
                } else {
                    SettingUserActivity.this.liner_user3.setVisibility(0);
                    TextView access$1600 = SettingUserActivity.this.tv_user_show3;
                    access$1600.setText(SettingUserActivity.this.getResources().getString(R.string.doorbell_setting_user) + "3");
                    SettingUserActivity.this.tv_user3.setText(SettingUserActivity.this.user3);
                    if (SettingUserActivity.this.s3 == 0) {
                        SettingUserActivity.this.tv_statu3.setText(R.string.doorbell_setting_user_statu0);
                    } else if (SettingUserActivity.this.s3 == 1) {
                        SettingUserActivity.this.tv_statu3.setText(R.string.doorbell_setting_user_statu1);
                    } else if (SettingUserActivity.this.s3 == 2) {
                        SettingUserActivity.this.tv_statu3.setText(R.string.doorbell_setting_user_statu2);
                    } else {
                        SettingUserActivity.this.tv_statu3.setText(R.string.doorbell_setting_user_statu3);
                    }
                    if (SettingUserActivity.this.user3.equalsIgnoreCase(SystemValue.doorBellAdmin)) {
                        SettingUserActivity.this.btn_edit3.setVisibility(0);
                    } else {
                        SettingUserActivity.this.btn_edit3.setVisibility(8);
                    }
                    if (SystemValue.isLitos) {
                        SettingUserActivity.this.tv_statu3.setVisibility(8);
                        SettingUserActivity.this.btn_edit3.setVisibility(8);
                    }
                }
                if (SettingUserActivity.this.user4 == null || SettingUserActivity.this.user4.length() <= 3) {
                    SettingUserActivity.this.liner_user4.setVisibility(8);
                } else {
                    SettingUserActivity.this.liner_user4.setVisibility(0);
                    TextView access$2300 = SettingUserActivity.this.tv_user_show4;
                    access$2300.setText(SettingUserActivity.this.getResources().getString(R.string.doorbell_setting_user) + "4");
                    SettingUserActivity.this.tv_user4.setText(SettingUserActivity.this.user4);
                    if (SettingUserActivity.this.s4 == 0) {
                        SettingUserActivity.this.tv_statu4.setText(R.string.doorbell_setting_user_statu0);
                    } else if (SettingUserActivity.this.s4 == 1) {
                        SettingUserActivity.this.tv_statu4.setText(R.string.doorbell_setting_user_statu1);
                    } else if (SettingUserActivity.this.s4 == 2) {
                        SettingUserActivity.this.tv_statu4.setText(R.string.doorbell_setting_user_statu2);
                    } else {
                        SettingUserActivity.this.tv_statu4.setText(R.string.doorbell_setting_user_statu3);
                    }
                    if (SettingUserActivity.this.user4.equalsIgnoreCase(SystemValue.doorBellAdmin)) {
                        SettingUserActivity.this.btn_edit4.setVisibility(0);
                    } else {
                        SettingUserActivity.this.btn_edit4.setVisibility(8);
                    }
                }
                if (SettingUserActivity.this.user5 == null || SettingUserActivity.this.user5.length() <= 3) {
                    SettingUserActivity.this.liner_user5.setVisibility(8);
                } else {
                    SettingUserActivity.this.liner_user5.setVisibility(0);
                    TextView access$3000 = SettingUserActivity.this.tv_user_show5;
                    access$3000.setText(SettingUserActivity.this.getResources().getString(R.string.doorbell_setting_user) + "5");
                    SettingUserActivity.this.tv_user5.setText(SettingUserActivity.this.user5);
                    if (SettingUserActivity.this.s5 == 0) {
                        SettingUserActivity.this.tv_statu5.setText(R.string.doorbell_setting_user_statu0);
                    } else if (SettingUserActivity.this.s5 == 1) {
                        SettingUserActivity.this.tv_statu5.setText(R.string.doorbell_setting_user_statu1);
                    } else if (SettingUserActivity.this.s5 == 2) {
                        SettingUserActivity.this.tv_statu5.setText(R.string.doorbell_setting_user_statu2);
                    } else {
                        SettingUserActivity.this.tv_statu5.setText(R.string.doorbell_setting_user_statu3);
                    }
                    if (SettingUserActivity.this.user5.equalsIgnoreCase(SystemValue.doorBellAdmin)) {
                        SettingUserActivity.this.btn_edit5.setVisibility(0);
                    } else {
                        SettingUserActivity.this.btn_edit5.setVisibility(8);
                    }
                }
                if (SettingUserActivity.this.user6 == null || SettingUserActivity.this.user6.length() <= 3) {
                    SettingUserActivity.this.liner_user6.setVisibility(8);
                } else {
                    SettingUserActivity.this.liner_user6.setVisibility(0);
                    TextView access$3700 = SettingUserActivity.this.tv_user_show6;
                    access$3700.setText(SettingUserActivity.this.getResources().getString(R.string.doorbell_setting_user) + "6");
                    SettingUserActivity.this.tv_user6.setText(SettingUserActivity.this.user6);
                    if (SettingUserActivity.this.s6 == 0) {
                        SettingUserActivity.this.tv_statu6.setText(R.string.doorbell_setting_user_statu0);
                    } else if (SettingUserActivity.this.s6 == 1) {
                        SettingUserActivity.this.tv_statu6.setText(R.string.doorbell_setting_user_statu1);
                    } else if (SettingUserActivity.this.s6 == 2) {
                        SettingUserActivity.this.tv_statu6.setText(R.string.doorbell_setting_user_statu2);
                    } else {
                        SettingUserActivity.this.tv_statu6.setText(R.string.doorbell_setting_user_statu3);
                    }
                    if (SettingUserActivity.this.user6.equalsIgnoreCase(SystemValue.doorBellAdmin)) {
                        SettingUserActivity.this.btn_edit6.setVisibility(0);
                    } else {
                        SettingUserActivity.this.btn_edit6.setVisibility(8);
                    }
                }
                if (SettingUserActivity.this.user7 == null || SettingUserActivity.this.user7.length() <= 3) {
                    SettingUserActivity.this.liner_user7.setVisibility(8);
                } else {
                    SettingUserActivity.this.liner_user7.setVisibility(0);
                    TextView access$4400 = SettingUserActivity.this.tv_user_show7;
                    access$4400.setText(SettingUserActivity.this.getResources().getString(R.string.doorbell_setting_user) + "7");
                    SettingUserActivity.this.tv_user7.setText(SettingUserActivity.this.user7);
                    if (SettingUserActivity.this.s7 == 0) {
                        SettingUserActivity.this.tv_statu7.setText(R.string.doorbell_setting_user_statu0);
                    } else if (SettingUserActivity.this.s7 == 1) {
                        SettingUserActivity.this.tv_statu7.setText(R.string.doorbell_setting_user_statu1);
                    } else if (SettingUserActivity.this.s7 == 2) {
                        SettingUserActivity.this.tv_statu7.setText(R.string.doorbell_setting_user_statu2);
                    } else {
                        SettingUserActivity.this.tv_statu7.setText(R.string.doorbell_setting_user_statu3);
                    }
                    if (SettingUserActivity.this.user7.equalsIgnoreCase(SystemValue.doorBellAdmin)) {
                        SettingUserActivity.this.btn_edit7.setVisibility(0);
                    } else {
                        SettingUserActivity.this.btn_edit7.setVisibility(8);
                    }
                }
                if (SettingUserActivity.this.user8 == null || SettingUserActivity.this.user8.length() <= 3) {
                    SettingUserActivity.this.liner_user8.setVisibility(8);
                } else {
                    SettingUserActivity.this.liner_user8.setVisibility(0);
                    TextView access$5100 = SettingUserActivity.this.tv_user_show8;
                    access$5100.setText(SettingUserActivity.this.getResources().getString(R.string.doorbell_setting_user) + "8");
                    SettingUserActivity.this.tv_user8.setText(SettingUserActivity.this.user8);
                    if (SettingUserActivity.this.s8 == 0) {
                        SettingUserActivity.this.tv_statu8.setText(R.string.doorbell_setting_user_statu0);
                    } else if (SettingUserActivity.this.s8 == 1) {
                        SettingUserActivity.this.tv_statu8.setText(R.string.doorbell_setting_user_statu1);
                    } else if (SettingUserActivity.this.s8 == 2) {
                        SettingUserActivity.this.tv_statu8.setText(R.string.doorbell_setting_user_statu2);
                    } else {
                        SettingUserActivity.this.tv_statu8.setText(R.string.doorbell_setting_user_statu3);
                    }
                    if (SettingUserActivity.this.user8.equalsIgnoreCase(SystemValue.doorBellAdmin)) {
                        SettingUserActivity.this.btn_edit8.setVisibility(0);
                    } else {
                        SettingUserActivity.this.btn_edit8.setVisibility(8);
                    }
                }
                if (SettingUserActivity.this.admin == 1) {
                    SettingUserActivity.this.tv_user_show1.setText(R.string.doorbell_setting_admin);
                    SettingUserActivity.this.tv_user_show1.setTextColor(-313086);
                    SettingUserActivity.this.btn_del1.setVisibility(8);
                    if (SystemValue.doorBellAdmin.equalsIgnoreCase(SettingUserActivity.this.user1)) {
                        SettingUserActivity.this.btn_edit1.setVisibility(0);
                        SettingUserActivity.this.btn_del2.setVisibility(0);
                        SettingUserActivity.this.btn_del3.setVisibility(0);
                        SettingUserActivity.this.btn_del4.setVisibility(0);
                        SettingUserActivity.this.btn_del5.setVisibility(0);
                        SettingUserActivity.this.btn_del6.setVisibility(0);
                        SettingUserActivity.this.btn_del7.setVisibility(0);
                        SettingUserActivity.this.btn_del8.setVisibility(0);
                    } else {
                        SettingUserActivity.this.button_ok.setVisibility(8);
                    }
                } else if (SettingUserActivity.this.admin == 2) {
                    SettingUserActivity.this.tv_user_show2.setText(R.string.doorbell_setting_admin);
                    SettingUserActivity.this.tv_user_show2.setTextColor(-313086);
                    SettingUserActivity.this.btn_del2.setVisibility(8);
                    if (SystemValue.doorBellAdmin.equalsIgnoreCase(SettingUserActivity.this.user2)) {
                        SettingUserActivity.this.btn_edit2.setVisibility(0);
                        SettingUserActivity.this.btn_del1.setVisibility(0);
                        SettingUserActivity.this.btn_del3.setVisibility(0);
                        SettingUserActivity.this.btn_del4.setVisibility(0);
                        SettingUserActivity.this.btn_del5.setVisibility(0);
                        SettingUserActivity.this.btn_del6.setVisibility(0);
                        SettingUserActivity.this.btn_del7.setVisibility(0);
                        SettingUserActivity.this.btn_del8.setVisibility(0);
                    } else {
                        SettingUserActivity.this.button_ok.setVisibility(8);
                    }
                } else if (SettingUserActivity.this.admin == 3) {
                    SettingUserActivity.this.tv_user_show3.setText(R.string.doorbell_setting_admin);
                    SettingUserActivity.this.tv_user_show3.setTextColor(-313086);
                    SettingUserActivity.this.btn_del3.setVisibility(8);
                    if (SystemValue.doorBellAdmin.equalsIgnoreCase(SettingUserActivity.this.user3)) {
                        SettingUserActivity.this.btn_edit3.setVisibility(0);
                        SettingUserActivity.this.btn_del2.setVisibility(0);
                        SettingUserActivity.this.btn_del1.setVisibility(0);
                        SettingUserActivity.this.btn_del4.setVisibility(0);
                        SettingUserActivity.this.btn_del5.setVisibility(0);
                        SettingUserActivity.this.btn_del6.setVisibility(0);
                        SettingUserActivity.this.btn_del7.setVisibility(0);
                        SettingUserActivity.this.btn_del8.setVisibility(0);
                    } else {
                        SettingUserActivity.this.button_ok.setVisibility(8);
                    }
                } else if (SettingUserActivity.this.admin == 4) {
                    SettingUserActivity.this.tv_user_show4.setText(R.string.doorbell_setting_admin);
                    SettingUserActivity.this.tv_user_show4.setTextColor(-313086);
                    SettingUserActivity.this.btn_del4.setVisibility(8);
                    if (SystemValue.doorBellAdmin.equalsIgnoreCase(SettingUserActivity.this.user4)) {
                        SettingUserActivity.this.btn_edit4.setVisibility(0);
                        SettingUserActivity.this.btn_del2.setVisibility(0);
                        SettingUserActivity.this.btn_del3.setVisibility(0);
                        SettingUserActivity.this.btn_del1.setVisibility(0);
                        SettingUserActivity.this.btn_del5.setVisibility(0);
                        SettingUserActivity.this.btn_del6.setVisibility(0);
                        SettingUserActivity.this.btn_del7.setVisibility(0);
                        SettingUserActivity.this.btn_del8.setVisibility(0);
                    } else {
                        SettingUserActivity.this.button_ok.setVisibility(8);
                    }
                } else if (SettingUserActivity.this.admin == 5) {
                    SettingUserActivity.this.tv_user_show5.setText(R.string.doorbell_setting_admin);
                    SettingUserActivity.this.tv_user_show5.setTextColor(-313086);
                    SettingUserActivity.this.btn_del5.setVisibility(8);
                    if (SystemValue.doorBellAdmin.equalsIgnoreCase(SettingUserActivity.this.user5)) {
                        SettingUserActivity.this.btn_edit5.setVisibility(0);
                        SettingUserActivity.this.btn_del2.setVisibility(0);
                        SettingUserActivity.this.btn_del3.setVisibility(0);
                        SettingUserActivity.this.btn_del4.setVisibility(0);
                        SettingUserActivity.this.btn_del1.setVisibility(0);
                        SettingUserActivity.this.btn_del6.setVisibility(0);
                        SettingUserActivity.this.btn_del7.setVisibility(0);
                        SettingUserActivity.this.btn_del8.setVisibility(0);
                    } else {
                        SettingUserActivity.this.button_ok.setVisibility(8);
                    }
                } else if (SettingUserActivity.this.admin == 6) {
                    SettingUserActivity.this.tv_user_show6.setText(R.string.doorbell_setting_admin);
                    SettingUserActivity.this.tv_user_show6.setTextColor(-313086);
                    SettingUserActivity.this.btn_del6.setVisibility(8);
                    if (SystemValue.doorBellAdmin.equalsIgnoreCase(SettingUserActivity.this.user6)) {
                        SettingUserActivity.this.btn_edit6.setVisibility(0);
                        SettingUserActivity.this.btn_del2.setVisibility(0);
                        SettingUserActivity.this.btn_del3.setVisibility(0);
                        SettingUserActivity.this.btn_del4.setVisibility(0);
                        SettingUserActivity.this.btn_del5.setVisibility(0);
                        SettingUserActivity.this.btn_del1.setVisibility(0);
                        SettingUserActivity.this.btn_del7.setVisibility(0);
                        SettingUserActivity.this.btn_del8.setVisibility(0);
                    } else {
                        SettingUserActivity.this.button_ok.setVisibility(8);
                    }
                } else if (SettingUserActivity.this.admin == 7) {
                    SettingUserActivity.this.tv_user_show7.setText(R.string.doorbell_setting_admin);
                    SettingUserActivity.this.tv_user_show7.setTextColor(-313086);
                    SettingUserActivity.this.btn_del7.setVisibility(8);
                    if (SystemValue.doorBellAdmin.equalsIgnoreCase(SettingUserActivity.this.user7)) {
                        SettingUserActivity.this.btn_edit7.setVisibility(0);
                        SettingUserActivity.this.btn_del2.setVisibility(0);
                        SettingUserActivity.this.btn_del3.setVisibility(0);
                        SettingUserActivity.this.btn_del4.setVisibility(0);
                        SettingUserActivity.this.btn_del5.setVisibility(0);
                        SettingUserActivity.this.btn_del6.setVisibility(0);
                        SettingUserActivity.this.btn_del1.setVisibility(0);
                        SettingUserActivity.this.btn_del8.setVisibility(0);
                    } else {
                        SettingUserActivity.this.button_ok.setVisibility(8);
                    }
                } else if (SettingUserActivity.this.admin == 8) {
                    SettingUserActivity.this.tv_user_show8.setText(R.string.doorbell_setting_admin);
                    SettingUserActivity.this.tv_user_show8.setTextColor(-313086);
                    SettingUserActivity.this.btn_del8.setVisibility(8);
                    if (SystemValue.doorBellAdmin.equalsIgnoreCase(SettingUserActivity.this.user8)) {
                        SettingUserActivity.this.btn_edit8.setVisibility(0);
                        SettingUserActivity.this.btn_del2.setVisibility(0);
                        SettingUserActivity.this.btn_del3.setVisibility(0);
                        SettingUserActivity.this.btn_del4.setVisibility(0);
                        SettingUserActivity.this.btn_del5.setVisibility(0);
                        SettingUserActivity.this.btn_del6.setVisibility(0);
                        SettingUserActivity.this.btn_del7.setVisibility(0);
                        SettingUserActivity.this.btn_del1.setVisibility(0);
                    } else {
                        SettingUserActivity.this.button_ok.setVisibility(8);
                    }
                }
                if (SettingUserActivity.this.tag == 1) {
                    if (!SettingUserActivity.this.setPwd.equals(SettingUserActivity.this.pwd1) || SettingUserActivity.this.user1 != SystemValue.doorBellAdmin) {
                        SettingUserActivity.this.showToast((int) R.string.setting_user_admin_sucess);
                        final Intent intent = new Intent(ContentCommon.STR_CAMERA_INFO_RECEIVER);
                        intent.putExtra(ContentCommon.STR_CAMERA_NAME, SettingUserActivity.this.cameraName);
                        intent.putExtra(ContentCommon.STR_CAMERA_ID, SettingUserActivity.this.strDID);
                        intent.putExtra(ContentCommon.STR_CAMERA_USER, SettingUserActivity.this.user1);
                        intent.putExtra(ContentCommon.STR_CAMERA_PWD, SettingUserActivity.this.pwd1);
                        intent.putExtra(ContentCommon.STR_CAMERA_OLD_ID, SettingUserActivity.this.strDID);
                        intent.putExtra(ContentCommon.CAMERA_OPTION, 2);
                        SettingUserActivity.this.handler.postDelayed(new Runnable() {
                            public void run() {
                                SettingUserActivity.this.sendBroadcast(intent);
                            }
                        }, 3000);
                        SettingUserActivity.this.sendBroadcast(new Intent("myback"));
                        SettingUserActivity.this.finish();
                    }
                } else if (SettingUserActivity.this.tag == 2) {
                    if (!SettingUserActivity.this.setPwd.equals(SettingUserActivity.this.pwd2)) {
                        SettingUserActivity.this.showToast((int) R.string.biz_add_edit_show_sucess);
                        final Intent intent2 = new Intent(ContentCommon.STR_CAMERA_INFO_RECEIVER);
                        intent2.putExtra(ContentCommon.STR_CAMERA_NAME, SettingUserActivity.this.cameraName);
                        intent2.putExtra(ContentCommon.STR_CAMERA_ID, SettingUserActivity.this.strDID);
                        intent2.putExtra(ContentCommon.STR_CAMERA_USER, SettingUserActivity.this.user2);
                        intent2.putExtra(ContentCommon.STR_CAMERA_PWD, SettingUserActivity.this.pwd2);
                        intent2.putExtra(ContentCommon.STR_CAMERA_OLD_ID, SettingUserActivity.this.strDID);
                        intent2.putExtra(ContentCommon.CAMERA_OPTION, 2);
                        SettingUserActivity.this.handler.postDelayed(new Runnable() {
                            public void run() {
                                SettingUserActivity.this.sendBroadcast(intent2);
                            }
                        }, 3000);
                        SettingUserActivity.this.sendBroadcast(new Intent("myback"));
                        SettingUserActivity.this.finish();
                    }
                } else if (SettingUserActivity.this.tag == 3) {
                    if (!SettingUserActivity.this.setPwd.equals(SettingUserActivity.this.pwd3)) {
                        SettingUserActivity.this.showToast((int) R.string.biz_add_edit_show_sucess);
                        final Intent intent3 = new Intent(ContentCommon.STR_CAMERA_INFO_RECEIVER);
                        intent3.putExtra(ContentCommon.STR_CAMERA_NAME, SettingUserActivity.this.cameraName);
                        intent3.putExtra(ContentCommon.STR_CAMERA_ID, SettingUserActivity.this.strDID);
                        intent3.putExtra(ContentCommon.STR_CAMERA_USER, SettingUserActivity.this.user3);
                        intent3.putExtra(ContentCommon.STR_CAMERA_PWD, SettingUserActivity.this.pwd3);
                        intent3.putExtra(ContentCommon.STR_CAMERA_OLD_ID, SettingUserActivity.this.strDID);
                        intent3.putExtra(ContentCommon.CAMERA_OPTION, 2);
                        SettingUserActivity.this.handler.postDelayed(new Runnable() {
                            public void run() {
                                SettingUserActivity.this.sendBroadcast(intent3);
                            }
                        }, 3000);
                        SettingUserActivity.this.sendBroadcast(new Intent("myback"));
                        SettingUserActivity.this.finish();
                    }
                } else if (SettingUserActivity.this.tag == 4) {
                    if (!SettingUserActivity.this.setPwd.equals(SettingUserActivity.this.pwd4)) {
                        SettingUserActivity.this.showToast((int) R.string.biz_add_edit_show_sucess);
                        final Intent intent4 = new Intent(ContentCommon.STR_CAMERA_INFO_RECEIVER);
                        intent4.putExtra(ContentCommon.STR_CAMERA_NAME, SettingUserActivity.this.cameraName);
                        intent4.putExtra(ContentCommon.STR_CAMERA_ID, SettingUserActivity.this.strDID);
                        intent4.putExtra(ContentCommon.STR_CAMERA_USER, SettingUserActivity.this.user4);
                        intent4.putExtra(ContentCommon.STR_CAMERA_PWD, SettingUserActivity.this.pwd4);
                        intent4.putExtra(ContentCommon.STR_CAMERA_OLD_ID, SettingUserActivity.this.strDID);
                        intent4.putExtra(ContentCommon.CAMERA_OPTION, 2);
                        SettingUserActivity.this.handler.postDelayed(new Runnable() {
                            public void run() {
                                SettingUserActivity.this.sendBroadcast(intent4);
                            }
                        }, 3000);
                        SettingUserActivity.this.sendBroadcast(new Intent("myback"));
                        SettingUserActivity.this.finish();
                    }
                } else if (SettingUserActivity.this.tag == 5) {
                    if (!SettingUserActivity.this.setPwd.equals(SettingUserActivity.this.pwd5)) {
                        SettingUserActivity.this.showToast((int) R.string.biz_add_edit_show_sucess);
                        final Intent intent5 = new Intent(ContentCommon.STR_CAMERA_INFO_RECEIVER);
                        intent5.putExtra(ContentCommon.STR_CAMERA_NAME, SettingUserActivity.this.cameraName);
                        intent5.putExtra(ContentCommon.STR_CAMERA_ID, SettingUserActivity.this.strDID);
                        intent5.putExtra(ContentCommon.STR_CAMERA_USER, SettingUserActivity.this.user5);
                        intent5.putExtra(ContentCommon.STR_CAMERA_PWD, SettingUserActivity.this.pwd5);
                        intent5.putExtra(ContentCommon.STR_CAMERA_OLD_ID, SettingUserActivity.this.strDID);
                        intent5.putExtra(ContentCommon.CAMERA_OPTION, 2);
                        SettingUserActivity.this.handler.postDelayed(new Runnable() {
                            public void run() {
                                SettingUserActivity.this.sendBroadcast(intent5);
                            }
                        }, 3000);
                        SettingUserActivity.this.sendBroadcast(new Intent("myback"));
                        SettingUserActivity.this.finish();
                    }
                } else if (SettingUserActivity.this.tag == 6) {
                    if (!SettingUserActivity.this.setPwd.equals(SettingUserActivity.this.pwd6)) {
                        SettingUserActivity.this.showToast((int) R.string.biz_add_edit_show_sucess);
                        final Intent intent6 = new Intent(ContentCommon.STR_CAMERA_INFO_RECEIVER);
                        intent6.putExtra(ContentCommon.STR_CAMERA_NAME, SettingUserActivity.this.cameraName);
                        intent6.putExtra(ContentCommon.STR_CAMERA_ID, SettingUserActivity.this.strDID);
                        intent6.putExtra(ContentCommon.STR_CAMERA_USER, SettingUserActivity.this.user6);
                        intent6.putExtra(ContentCommon.STR_CAMERA_PWD, SettingUserActivity.this.pwd6);
                        intent6.putExtra(ContentCommon.STR_CAMERA_OLD_ID, SettingUserActivity.this.strDID);
                        intent6.putExtra(ContentCommon.CAMERA_OPTION, 2);
                        SettingUserActivity.this.handler.postDelayed(new Runnable() {
                            public void run() {
                                SettingUserActivity.this.sendBroadcast(intent6);
                            }
                        }, 3000);
                        SettingUserActivity.this.sendBroadcast(new Intent("myback"));
                        SettingUserActivity.this.finish();
                    }
                } else if (SettingUserActivity.this.tag == 7) {
                    if (!SettingUserActivity.this.setPwd.equals(SettingUserActivity.this.pwd7)) {
                        SettingUserActivity.this.showToast((int) R.string.biz_add_edit_show_sucess);
                        final Intent intent7 = new Intent(ContentCommon.STR_CAMERA_INFO_RECEIVER);
                        intent7.putExtra(ContentCommon.STR_CAMERA_NAME, SettingUserActivity.this.cameraName);
                        intent7.putExtra(ContentCommon.STR_CAMERA_ID, SettingUserActivity.this.strDID);
                        intent7.putExtra(ContentCommon.STR_CAMERA_USER, SettingUserActivity.this.user7);
                        intent7.putExtra(ContentCommon.STR_CAMERA_PWD, SettingUserActivity.this.pwd7);
                        intent7.putExtra(ContentCommon.STR_CAMERA_OLD_ID, SettingUserActivity.this.strDID);
                        intent7.putExtra(ContentCommon.CAMERA_OPTION, 2);
                        SettingUserActivity.this.handler.postDelayed(new Runnable() {
                            public void run() {
                                SettingUserActivity.this.sendBroadcast(intent7);
                            }
                        }, 3000);
                        SettingUserActivity.this.sendBroadcast(new Intent("myback"));
                        SettingUserActivity.this.finish();
                    }
                } else if (SettingUserActivity.this.tag == 8 && !SettingUserActivity.this.setPwd.equals(SettingUserActivity.this.pwd8)) {
                    SettingUserActivity.this.showToast((int) R.string.biz_add_edit_show_sucess);
                    final Intent intent8 = new Intent(ContentCommon.STR_CAMERA_INFO_RECEIVER);
                    intent8.putExtra(ContentCommon.STR_CAMERA_NAME, SettingUserActivity.this.cameraName);
                    intent8.putExtra(ContentCommon.STR_CAMERA_ID, SettingUserActivity.this.strDID);
                    intent8.putExtra(ContentCommon.STR_CAMERA_USER, SettingUserActivity.this.user8);
                    intent8.putExtra(ContentCommon.STR_CAMERA_PWD, SettingUserActivity.this.pwd8);
                    intent8.putExtra(ContentCommon.STR_CAMERA_OLD_ID, SettingUserActivity.this.strDID);
                    intent8.putExtra(ContentCommon.CAMERA_OPTION, 2);
                    SettingUserActivity.this.handler.postDelayed(new Runnable() {
                        public void run() {
                            SettingUserActivity.this.sendBroadcast(intent8);
                        }
                    }, 3000);
                    SettingUserActivity.this.sendBroadcast(new Intent("myback"));
                    SettingUserActivity.this.finish();
                }
            }
        }
    };
    private boolean isAdminEdit = false;
    /* access modifiers changed from: private */
    public LinearLayout liner_user1;
    /* access modifiers changed from: private */
    public LinearLayout liner_user2;
    /* access modifiers changed from: private */
    public LinearLayout liner_user3;
    /* access modifiers changed from: private */
    public LinearLayout liner_user4;
    /* access modifiers changed from: private */
    public LinearLayout liner_user5;
    /* access modifiers changed from: private */
    public LinearLayout liner_user6;
    /* access modifiers changed from: private */
    public LinearLayout liner_user7;
    /* access modifiers changed from: private */
    public LinearLayout liner_user8;
    /* access modifiers changed from: private */
    public PopupWindow popupWindow_group;
    private View popv_group;
    /* access modifiers changed from: private */
    public String pwd1;
    /* access modifiers changed from: private */
    public String pwd2;
    /* access modifiers changed from: private */
    public String pwd3;
    /* access modifiers changed from: private */
    public String pwd4;
    /* access modifiers changed from: private */
    public String pwd5;
    /* access modifiers changed from: private */
    public String pwd6;
    /* access modifiers changed from: private */
    public String pwd7;
    /* access modifiers changed from: private */
    public String pwd8;
    /* access modifiers changed from: private */
    public int s1;
    /* access modifiers changed from: private */
    public int s2;
    /* access modifiers changed from: private */
    public int s3;
    /* access modifiers changed from: private */
    public int s4;
    /* access modifiers changed from: private */
    public int s5;
    /* access modifiers changed from: private */
    public int s6;
    /* access modifiers changed from: private */
    public int s7;
    /* access modifiers changed from: private */
    public int s8;
    /* access modifiers changed from: private */
    public String setPwd = "";
    /* access modifiers changed from: private */
    public String strDID = null;
    /* access modifiers changed from: private */
    public int tag = 0;
    private TextView title;
    private TextView title_show;
    /* access modifiers changed from: private */
    public TextView tv_statu1;
    /* access modifiers changed from: private */
    public TextView tv_statu2;
    /* access modifiers changed from: private */
    public TextView tv_statu3;
    /* access modifiers changed from: private */
    public TextView tv_statu4;
    /* access modifiers changed from: private */
    public TextView tv_statu5;
    /* access modifiers changed from: private */
    public TextView tv_statu6;
    /* access modifiers changed from: private */
    public TextView tv_statu7;
    /* access modifiers changed from: private */
    public TextView tv_statu8;
    /* access modifiers changed from: private */
    public TextView tv_user1;
    /* access modifiers changed from: private */
    public TextView tv_user2;
    /* access modifiers changed from: private */
    public TextView tv_user3;
    /* access modifiers changed from: private */
    public TextView tv_user4;
    /* access modifiers changed from: private */
    public TextView tv_user5;
    /* access modifiers changed from: private */
    public TextView tv_user6;
    /* access modifiers changed from: private */
    public TextView tv_user7;
    /* access modifiers changed from: private */
    public TextView tv_user8;
    /* access modifiers changed from: private */
    public TextView tv_user_show1;
    /* access modifiers changed from: private */
    public TextView tv_user_show2;
    /* access modifiers changed from: private */
    public TextView tv_user_show3;
    /* access modifiers changed from: private */
    public TextView tv_user_show4;
    /* access modifiers changed from: private */
    public TextView tv_user_show5;
    /* access modifiers changed from: private */
    public TextView tv_user_show6;
    /* access modifiers changed from: private */
    public TextView tv_user_show7;
    /* access modifiers changed from: private */
    public TextView tv_user_show8;
    /* access modifiers changed from: private */
    public String user1;
    /* access modifiers changed from: private */
    public String user2;
    /* access modifiers changed from: private */
    public String user3;
    /* access modifiers changed from: private */
    public String user4;
    /* access modifiers changed from: private */
    public String user5;
    /* access modifiers changed from: private */
    public String user6;
    /* access modifiers changed from: private */
    public String user7;
    /* access modifiers changed from: private */
    public String user8;

    public void callBackPPPPMsgNotifyData(String str, int i, int i2) {
    }

    public void callBackSetSystemParamsResult(String str, int i, int i2) {
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        StartHeat(this.strDID, SystemValue.doorBellAdmin, SystemValue.doorBellPass);
        super.onResume();
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        StopHeat();
        super.onStop();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        getDataFromOther();
        setContentView(R.layout.settinguser);
        findView();
        BridgeService.setDoorBellUserInterface(this);
        NativeCaller.TransferMessage(this.strDID, "get_user_config.cgi?&loginuse=" + SystemValue.doorBellAdmin + "&loginpas=" + SystemValue.doorBellPass + "&user=" + SystemValue.doorBellAdmin + "&pwd=" + SystemValue.doorBellPass, 1);
        initExitPopupWindow_Group();
        this.tag = 0;
        this.isAdminEdit = false;
        BridgeService.setUserInterface(this);
        NativeCaller.PPPPGetSystemParams(this.strDID, 4);
        SetTab(this);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        BridgeService.setDoorBellUserInterface((BridgeService.DoorBellUserInterface) null);
        super.onDestroy();
    }

    private void findView() {
        this.button_cancel = (Button) findViewById(R.id.user_cancel);
        this.button_cancel.setOnClickListener(this);
        this.button_ok = (Button) findViewById(R.id.user_ok);
        this.button_ok.setOnClickListener(this);
        this.liner_user1 = (LinearLayout) findViewById(R.id.liner_user1);
        this.tv_user_show1 = (TextView) findViewById(R.id.tv_user_show1);
        this.tv_user1 = (TextView) findViewById(R.id.tv_user1);
        this.tv_statu1 = (TextView) findViewById(R.id.tv_statu1);
        this.btn_del1 = (Button) findViewById(R.id.btn_del1);
        this.btn_edit1 = (Button) findViewById(R.id.btn_edit1);
        this.btn_del1.setOnClickListener(this);
        this.btn_edit1.setOnClickListener(this);
        this.liner_user2 = (LinearLayout) findViewById(R.id.liner_user2);
        this.tv_user_show2 = (TextView) findViewById(R.id.tv_user_show2);
        this.tv_user2 = (TextView) findViewById(R.id.tv_user2);
        this.tv_statu2 = (TextView) findViewById(R.id.tv_statu2);
        this.btn_del2 = (Button) findViewById(R.id.btn_del2);
        this.btn_edit2 = (Button) findViewById(R.id.btn_edit2);
        this.btn_del2.setOnClickListener(this);
        this.btn_edit2.setOnClickListener(this);
        this.liner_user3 = (LinearLayout) findViewById(R.id.liner_user3);
        this.tv_user_show3 = (TextView) findViewById(R.id.tv_user_show3);
        this.tv_user3 = (TextView) findViewById(R.id.tv_user3);
        this.tv_statu3 = (TextView) findViewById(R.id.tv_statu3);
        this.btn_del3 = (Button) findViewById(R.id.btn_del3);
        this.btn_edit3 = (Button) findViewById(R.id.btn_edit3);
        this.btn_del3.setOnClickListener(this);
        this.btn_edit3.setOnClickListener(this);
        this.liner_user4 = (LinearLayout) findViewById(R.id.liner_user4);
        this.tv_user_show4 = (TextView) findViewById(R.id.tv_user_show4);
        this.tv_user4 = (TextView) findViewById(R.id.tv_user4);
        this.tv_statu4 = (TextView) findViewById(R.id.tv_statu4);
        this.btn_del4 = (Button) findViewById(R.id.btn_del4);
        this.btn_edit4 = (Button) findViewById(R.id.btn_edit4);
        this.btn_del4.setOnClickListener(this);
        this.btn_edit4.setOnClickListener(this);
        this.liner_user5 = (LinearLayout) findViewById(R.id.liner_user5);
        this.tv_user_show5 = (TextView) findViewById(R.id.tv_user_show5);
        this.tv_user5 = (TextView) findViewById(R.id.tv_user5);
        this.tv_statu5 = (TextView) findViewById(R.id.tv_statu5);
        this.btn_del5 = (Button) findViewById(R.id.btn_del5);
        this.btn_edit5 = (Button) findViewById(R.id.btn_edit5);
        this.btn_del5.setOnClickListener(this);
        this.btn_edit5.setOnClickListener(this);
        this.liner_user6 = (LinearLayout) findViewById(R.id.liner_user6);
        this.tv_user_show6 = (TextView) findViewById(R.id.tv_user_show6);
        this.tv_user6 = (TextView) findViewById(R.id.tv_user6);
        this.tv_statu6 = (TextView) findViewById(R.id.tv_statu6);
        this.btn_del6 = (Button) findViewById(R.id.btn_del6);
        this.btn_edit6 = (Button) findViewById(R.id.btn_edit6);
        this.btn_del6.setOnClickListener(this);
        this.btn_edit6.setOnClickListener(this);
        this.liner_user7 = (LinearLayout) findViewById(R.id.liner_user7);
        this.tv_user_show7 = (TextView) findViewById(R.id.tv_user_show7);
        this.tv_user7 = (TextView) findViewById(R.id.tv_user7);
        this.tv_statu7 = (TextView) findViewById(R.id.tv_statu7);
        this.btn_del7 = (Button) findViewById(R.id.btn_del7);
        this.btn_edit7 = (Button) findViewById(R.id.btn_edit7);
        this.btn_del7.setOnClickListener(this);
        this.btn_edit7.setOnClickListener(this);
        this.liner_user8 = (LinearLayout) findViewById(R.id.liner_user8);
        this.tv_user_show8 = (TextView) findViewById(R.id.tv_user_show8);
        this.tv_user8 = (TextView) findViewById(R.id.tv_user8);
        this.tv_statu8 = (TextView) findViewById(R.id.tv_statu8);
        this.btn_del8 = (Button) findViewById(R.id.btn_del8);
        this.btn_edit8 = (Button) findViewById(R.id.btn_edit8);
        this.btn_del8.setOnClickListener(this);
        this.btn_edit8.setOnClickListener(this);
    }

    private void getDataFromOther() {
        Intent intent = getIntent();
        this.strDID = intent.getStringExtra(ContentCommon.STR_CAMERA_ID);
        this.cameraName = intent.getStringExtra(ContentCommon.STR_CAMERA_NAME);
    }

    public void onClick(View view) {
        String str;
        String str2;
        String str3;
        VibratorUtil.Vibrate(this, 20);
        this.isAdminEdit = false;
        int id = view.getId();
        switch (id) {
            case R.id.btn_del1:
                if (!SystemValue.isLitos) {
                    NativeCaller.TransferMessage(this.strDID, "set_user_config.cgi?&mod=1&newuser=" + this.user1 + "&newpwd=" + this.pwd1 + "&loginuse=" + SystemValue.doorBellAdmin + "&loginpas=" + SystemValue.doorBellPass + "&user=" + SystemValue.doorBellAdmin + "&pwd=" + SystemValue.doorBellPass, 1);
                    return;
                }
                return;
            case R.id.btn_del2:
                if (SystemValue.isLitos) {
                    String str4 = this.user2;
                    if (str4 != null && str4.length() > 1) {
                        String str5 = "set_users.cgi?&deluser=" + this.user2 + "&loginuse=" + SystemValue.doorBellAdmin + "&loginpas=" + SystemValue.doorBellPass + "&user=" + SystemValue.doorBellAdmin + "&pwd=" + SystemValue.doorBellPass;
                        CommonUtil.Log(1, "strDID:" + this.strDID + "  get_alarm_config:" + str5);
                        NativeCaller.TransferMessage(this.strDID, str5, 1);
                        return;
                    }
                    return;
                }
                NativeCaller.TransferMessage(this.strDID, "set_user_config.cgi?&mod=1&newuser=" + this.user2 + "&newpwd=" + this.pwd2 + "&loginuse=" + SystemValue.doorBellAdmin + "&loginpas=" + SystemValue.doorBellPass + "&user=" + SystemValue.doorBellAdmin + "&pwd=" + SystemValue.doorBellPass, 1);
                return;
            case R.id.btn_del3:
                if (SystemValue.isLitos) {
                    String str6 = this.user3;
                    if (str6 != null && str6.length() > 1) {
                        String str7 = "set_users.cgi?&deluser=" + this.user3 + "&loginuse=" + SystemValue.doorBellAdmin + "&loginpas=" + SystemValue.doorBellPass + "&user=" + SystemValue.doorBellAdmin + "&pwd=" + SystemValue.doorBellPass;
                        CommonUtil.Log(1, "strDID:" + this.strDID + "  get_alarm_config:" + str7);
                        NativeCaller.TransferMessage(this.strDID, str7, 1);
                        return;
                    }
                    return;
                }
                NativeCaller.TransferMessage(this.strDID, "set_user_config.cgi?&mod=1&newuser=" + this.user3 + "&newpwd=" + this.pwd3 + "&loginuse=" + SystemValue.doorBellAdmin + "&loginpas=" + SystemValue.doorBellPass + "&user=" + SystemValue.doorBellAdmin + "&pwd=" + SystemValue.doorBellPass, 1);
                return;
            case R.id.btn_del4:
                if (SystemValue.isLitos) {
                    String str8 = this.user4;
                    if (str8 != null && str8.length() > 1) {
                        NativeCaller.TransferMessage(this.strDID, "set_users.cgi?&deluser=" + this.user4 + "&loginuse=" + SystemValue.doorBellAdmin + "&loginpas=" + SystemValue.doorBellPass + "&user=" + SystemValue.doorBellAdmin + "&pwd=" + SystemValue.doorBellPass, 1);
                        return;
                    }
                    return;
                }
                NativeCaller.TransferMessage(this.strDID, "set_user_config.cgi?&mod=1&newuser=" + this.user4 + "&newpwd=" + this.pwd4 + "&loginuse=" + SystemValue.doorBellAdmin + "&loginpas=" + SystemValue.doorBellPass + "&user=" + SystemValue.doorBellAdmin + "&pwd=" + SystemValue.doorBellPass, 1);
                return;
            case R.id.btn_del5:
                NativeCaller.TransferMessage(this.strDID, "set_user_config.cgi?&mod=1&newuser=" + this.user5 + "&newpwd=" + this.pwd5 + "&loginuse=" + SystemValue.doorBellAdmin + "&loginpas=" + SystemValue.doorBellPass + "&user=" + SystemValue.doorBellAdmin + "&pwd=" + SystemValue.doorBellPass, 1);
                return;
            case R.id.btn_del6:
                NativeCaller.TransferMessage(this.strDID, "set_user_config.cgi?&mod=1&newuser=" + this.user6 + "&newpwd=" + this.pwd6 + "&loginuse=" + SystemValue.doorBellAdmin + "&loginpas=" + SystemValue.doorBellPass + "&user=" + SystemValue.doorBellAdmin + "&pwd=" + SystemValue.doorBellPass, 1);
                return;
            case R.id.btn_del7:
                NativeCaller.TransferMessage(this.strDID, "set_user_config.cgi?&mod=1&newuser=" + this.user7 + "&newpwd=" + this.pwd7 + "&loginuse=" + SystemValue.doorBellAdmin + "&loginpas=" + SystemValue.doorBellPass + "&user=" + SystemValue.doorBellAdmin + "&pwd=" + SystemValue.doorBellPass, 1);
                return;
            case R.id.btn_del8:
                NativeCaller.TransferMessage(this.strDID, "set_user_config.cgi?&mod=1&newuser=" + this.user8 + "&newpwd=" + this.pwd8 + "&loginuse=" + SystemValue.doorBellAdmin + "&loginpas=" + SystemValue.doorBellPass + "&user=" + SystemValue.doorBellAdmin + "&pwd=" + SystemValue.doorBellPass, 1);
                return;
            default:
                switch (id) {
                    case R.id.btn_edit1:
                        this.tag = 1;
                        this.editText_GroupName.setVisibility(8);
                        this.title.setText(R.string.biz_add_poup_show111);
                        this.title_show.setText(R.string.biz_add_edit_show2);
                        this.popupWindow_group.showAtLocation(this.button_cancel, 17, 0, 0);
                        return;
                    case R.id.btn_edit2:
                        this.tag = 2;
                        this.editText_GroupName.setVisibility(8);
                        this.title.setText(R.string.biz_add_poup_show2);
                        this.title_show.setText(R.string.biz_add_edit_show2);
                        this.popupWindow_group.showAtLocation(this.button_cancel, 17, 0, 0);
                        return;
                    case R.id.btn_edit3:
                        this.tag = 3;
                        this.editText_GroupName.setVisibility(8);
                        this.title.setText(R.string.biz_add_poup_show2);
                        this.title_show.setText(R.string.biz_add_edit_show2);
                        this.popupWindow_group.showAtLocation(this.button_cancel, 17, 0, 0);
                        return;
                    case R.id.btn_edit4:
                        this.tag = 4;
                        this.editText_GroupName.setVisibility(8);
                        this.title.setText(R.string.biz_add_poup_show2);
                        this.title_show.setText(R.string.biz_add_edit_show2);
                        this.popupWindow_group.showAtLocation(this.button_cancel, 17, 0, 0);
                        return;
                    case R.id.btn_edit5:
                        this.tag = 5;
                        this.editText_GroupName.setVisibility(8);
                        this.title.setText(R.string.biz_add_poup_show2);
                        this.title_show.setText(R.string.biz_add_edit_show2);
                        this.popupWindow_group.showAtLocation(this.button_cancel, 17, 0, 0);
                        return;
                    case R.id.btn_edit6:
                        this.tag = 6;
                        this.editText_GroupName.setVisibility(8);
                        this.title.setText(R.string.biz_add_poup_show2);
                        this.title_show.setText(R.string.biz_add_edit_show2);
                        this.popupWindow_group.showAtLocation(this.button_cancel, 17, 0, 0);
                        return;
                    case R.id.btn_edit7:
                        this.tag = 7;
                        this.editText_GroupName.setVisibility(8);
                        this.title.setText(R.string.biz_add_poup_show2);
                        this.title_show.setText(R.string.biz_add_edit_show2);
                        this.popupWindow_group.showAtLocation(this.button_cancel, 17, 0, 0);
                        return;
                    case R.id.btn_edit8:
                        this.tag = 8;
                        this.editText_GroupName.setVisibility(8);
                        this.title.setText(R.string.biz_add_poup_show2);
                        this.title_show.setText(R.string.biz_add_edit_show2);
                        this.popupWindow_group.showAtLocation(this.button_cancel, 17, 0, 0);
                        return;
                    default:
                        switch (id) {
                            case R.id.popup_create_group_cancel:
                                this.tag = 0;
                                this.editText_GroupName.setText("");
                                this.editText_GroupName_pass.setText("");
                                this.popupWindow_group.dismiss();
                                return;
                            case R.id.popup_create_group_create:
                                String trim = this.editText_GroupName.getText().toString().trim();
                                String trim2 = this.editText_GroupName_pass.getText().toString().trim();
                                int i = this.tag;
                                if (i == 0) {
                                    if (trim == null || trim.length() < 5) {
                                        showToast((int) R.string.biz_add_show_user);
                                        return;
                                    } else if (trim.equalsIgnoreCase(this.user1) || trim.equalsIgnoreCase(this.user2) || trim.equalsIgnoreCase(this.user3) || trim.equalsIgnoreCase(this.user4) || trim.equalsIgnoreCase(this.user5) || trim.equalsIgnoreCase(this.user6) || trim.equalsIgnoreCase(this.user7) || trim.equalsIgnoreCase(this.user8)) {
                                        showToast((int) R.string.door_white_list_check_show);
                                        return;
                                    } else if (trim2 == null || trim2.length() < 6) {
                                        showToast((int) R.string.biz_add_show_pwd);
                                        return;
                                    } else if (SystemValue.isLitos) {
                                        String str9 = this.user1;
                                        if (str9 == null || str9.length() <= 1 || (str = this.user2) == null || str.length() <= 1 || (str2 = this.user3) == null || str2.length() <= 1 || (str3 = this.user4) == null || str3.length() <= 1) {
                                            String str10 = this.user2;
                                            if (str10 == null || str10.length() < 1) {
                                                NativeCaller.TransferMessage(this.strDID, "set_users.cgi?&user2=" + trim + "&pwd2=" + trim2 + "&loginuse=" + SystemValue.doorBellAdmin + "&loginpas=" + SystemValue.doorBellPass + "&user=" + SystemValue.doorBellAdmin + "&pwd=" + SystemValue.doorBellPass, 1);
                                            } else {
                                                String str11 = this.user3;
                                                if (str11 == null || str11.length() < 1) {
                                                    NativeCaller.TransferMessage(this.strDID, "set_users.cgi?&user3=" + trim + "&pwd3=" + trim2 + "&loginuse=" + SystemValue.doorBellAdmin + "&loginpas=" + SystemValue.doorBellPass + "&user=" + SystemValue.doorBellAdmin + "&pwd=" + SystemValue.doorBellPass, 1);
                                                } else {
                                                    String str12 = this.user4;
                                                    if (str12 == null || str12.length() < 1) {
                                                        NativeCaller.TransferMessage(this.strDID, "set_users.cgi?&user4=" + trim + "&pwd4=" + trim2 + "&loginuse=" + SystemValue.doorBellAdmin + "&loginpas=" + SystemValue.doorBellPass + "&user=" + SystemValue.doorBellAdmin + "&pwd=" + SystemValue.doorBellPass, 1);
                                                    }
                                                }
                                            }
                                        } else {
                                            showToast("");
                                            return;
                                        }
                                    } else {
                                        NativeCaller.TransferMessage(this.strDID, "set_user_config.cgi?&mod=0&newuser=" + trim + "&newpwd=" + trim2 + "&loginuse=" + SystemValue.doorBellAdmin + "&loginpas=" + SystemValue.doorBellPass + "&user=" + SystemValue.doorBellAdmin + "&pwd=" + SystemValue.doorBellPass, 1);
                                    }
                                } else if (i == 1) {
                                    this.setPwd = this.pwd1;
                                    if (trim2 == null || trim2.length() < 6) {
                                        showToast((int) R.string.biz_add_show_pwd);
                                        return;
                                    }
                                    NativeCaller.TransferMessage(this.strDID, "set_user_config.cgi?&mod=4&newuser=" + SystemValue.doorBellAdmin + "&newpwd=" + trim2 + "&loginuse=" + SystemValue.doorBellAdmin + "&loginpas=" + SystemValue.doorBellPass + "&user=" + SystemValue.doorBellAdmin + "&pwd=" + SystemValue.doorBellPass, 1);
                                    NativeCaller.PPPPGetSystemParams(this.strDID, 59);
                                    this.isAdminEdit = true;
                                } else if (i == 2) {
                                    this.setPwd = this.pwd2;
                                    if (trim2 == null || trim2.length() < 6) {
                                        showToast((int) R.string.biz_add_show_pwd);
                                        return;
                                    }
                                    NativeCaller.TransferMessage(this.strDID, "set_user_config.cgi?&mod=4&newuser=" + this.user2 + "&newpwd=" + trim2 + "&loginuse=" + SystemValue.doorBellAdmin + "&loginpas=" + SystemValue.doorBellPass + "&user=" + SystemValue.doorBellAdmin + "&pwd=" + SystemValue.doorBellPass, 1);
                                    NativeCaller.PPPPGetSystemParams(this.strDID, 59);
                                } else if (i == 3) {
                                    this.setPwd = this.pwd3;
                                    if (trim2 == null || trim2.length() < 6) {
                                        showToast((int) R.string.biz_add_show_pwd);
                                        return;
                                    }
                                    NativeCaller.TransferMessage(this.strDID, "set_user_config.cgi?&mod=4&newuser=" + this.user3 + "&newpwd=" + trim2 + "&loginuse=" + SystemValue.doorBellAdmin + "&loginpas=" + SystemValue.doorBellPass + "&user=" + SystemValue.doorBellAdmin + "&pwd=" + SystemValue.doorBellPass, 1);
                                    NativeCaller.PPPPGetSystemParams(this.strDID, 59);
                                } else if (i == 4) {
                                    this.setPwd = this.pwd4;
                                    if (trim2 == null || trim2.length() < 6) {
                                        showToast((int) R.string.biz_add_show_pwd);
                                        return;
                                    }
                                    NativeCaller.TransferMessage(this.strDID, "set_user_config.cgi?&mod=4&newuser=" + this.user4 + "&newpwd=" + trim2 + "&loginuse=" + SystemValue.doorBellAdmin + "&loginpas=" + SystemValue.doorBellPass + "&user=" + SystemValue.doorBellAdmin + "&pwd=" + SystemValue.doorBellPass, 1);
                                    NativeCaller.PPPPGetSystemParams(this.strDID, 59);
                                } else if (i == 5) {
                                    this.setPwd = this.pwd5;
                                    if (trim2 == null || trim2.length() < 6) {
                                        showToast((int) R.string.biz_add_show_pwd);
                                        return;
                                    }
                                    NativeCaller.TransferMessage(this.strDID, "set_user_config.cgi?&mod=4&newuser=" + this.user5 + "&newpwd=" + trim2 + "&loginuse=" + SystemValue.doorBellAdmin + "&loginpas=" + SystemValue.doorBellPass + "&user=" + SystemValue.doorBellAdmin + "&pwd=" + SystemValue.doorBellPass, 1);
                                    NativeCaller.PPPPGetSystemParams(this.strDID, 59);
                                } else if (i == 6) {
                                    this.setPwd = this.pwd6;
                                    if (trim2 == null || trim2.length() < 6) {
                                        showToast((int) R.string.biz_add_show_pwd);
                                        return;
                                    }
                                    NativeCaller.TransferMessage(this.strDID, "set_user_config.cgi?&mod=4&newuser=" + this.user6 + "&newpwd=" + trim2 + "&loginuse=" + SystemValue.doorBellAdmin + "&loginpas=" + SystemValue.doorBellPass + "&user=" + SystemValue.doorBellAdmin + "&pwd=" + SystemValue.doorBellPass, 1);
                                    NativeCaller.PPPPGetSystemParams(this.strDID, 59);
                                } else if (i == 7) {
                                    this.setPwd = this.pwd7;
                                    if (trim2 == null || trim2.length() < 6) {
                                        showToast((int) R.string.biz_add_show_pwd);
                                        return;
                                    }
                                    NativeCaller.TransferMessage(this.strDID, "set_user_config.cgi?&mod=4&newuser=" + this.user7 + "&newpwd=" + trim2 + "&loginuse=" + SystemValue.doorBellAdmin + "&loginpas=" + SystemValue.doorBellPass + "&user=" + SystemValue.doorBellAdmin + "&pwd=" + SystemValue.doorBellPass, 1);
                                    NativeCaller.PPPPGetSystemParams(this.strDID, 59);
                                } else if (i == 8) {
                                    this.setPwd = this.pwd8;
                                    if (trim2 == null || trim2.length() < 6) {
                                        showToast((int) R.string.biz_add_show_pwd);
                                        return;
                                    }
                                    NativeCaller.TransferMessage(this.strDID, "set_user_config.cgi?&mod=4&newuser=" + this.user8 + "&newpwd=" + trim2 + "&loginuse=" + SystemValue.doorBellAdmin + "&loginpas=" + SystemValue.doorBellPass + "&user=" + SystemValue.doorBellAdmin + "&pwd=" + SystemValue.doorBellPass, 1);
                                    NativeCaller.PPPPGetSystemParams(this.strDID, 59);
                                }
                                this.editText_GroupName.setText("");
                                this.editText_GroupName_pass.setText("");
                                this.popupWindow_group.dismiss();
                                return;
                            default:
                                switch (id) {
                                    case R.id.user_cancel:
                                        finish();
                                        overridePendingTransition(R.anim.out_to_right, R.anim.in_from_left);
                                        return;
                                    case R.id.user_ok:
                                        this.tag = 0;
                                        this.editText_GroupName.setVisibility(0);
                                        this.title.setText(R.string.biz_add_poup_show);
                                        this.title_show.setText(R.string.biz_add_edit_show);
                                        this.popupWindow_group.showAtLocation(this.button_cancel, 17, 0, 0);
                                        return;
                                    default:
                                        return;
                                }
                        }
                }
        }
    }

    public void initExitPopupWindow_Group() {
        this.popv_group = LayoutInflater.from(this).inflate(R.layout.popup_create_group, (ViewGroup) null);
        this.title = (TextView) this.popv_group.findViewById(R.id.title);
        this.title_show = (TextView) this.popv_group.findViewById(R.id.title_show);
        this.btn_create = (Button) this.popv_group.findViewById(R.id.popup_create_group_create);
        this.btn_cancel = (Button) this.popv_group.findViewById(R.id.popup_create_group_cancel);
        this.editText_GroupName = (EditText) this.popv_group.findViewById(R.id.popup_create_group_edittext);
        this.editText_GroupName_pass = (EditText) this.popv_group.findViewById(R.id.popup_create_group_edittext_pass);
        this.btn_create.setOnClickListener(this);
        this.btn_cancel.setOnClickListener(this);
        this.popupWindow_group = new PopupWindow(this.popv_group, -1, -1);
        this.popupWindow_group.setFocusable(true);
        this.popupWindow_group.setInputMethodMode(1);
        this.popupWindow_group.setSoftInputMode(16);
        this.popupWindow_group.setOutsideTouchable(true);
        this.popupWindow_group.setBackgroundDrawable(new ColorDrawable(0));
        this.popupWindow_group.setOnDismissListener(new PopupWindow.OnDismissListener() {
            public void onDismiss() {
                SettingUserActivity.this.popupWindow_group.dismiss();
            }
        });
        this.popupWindow_group.setTouchInterceptor(new View.OnTouchListener() {
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() != 4) {
                    return false;
                }
                SettingUserActivity.this.popupWindow_group.dismiss();
                return false;
            }
        });
    }

    public void CallBackUserParms(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, String str17, String str18, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        String str19 = str17;
        int i10 = i9;
        Log.d("test", "pwd8:" + str19 + "  s8:" + i10);
        this.user1 = str2;
        this.pwd1 = str3;
        this.user2 = str4;
        this.pwd2 = str5;
        this.user3 = str6;
        this.pwd3 = str7;
        this.user4 = str8;
        this.pwd4 = str9;
        this.user5 = str10;
        this.pwd5 = str11;
        this.user6 = str12;
        this.pwd6 = str13;
        this.user7 = str14;
        this.pwd7 = str15;
        this.user8 = str16;
        this.pwd8 = str19;
        this.admin = i;
        this.s1 = i2;
        this.s2 = i3;
        this.s3 = i4;
        this.s4 = i5;
        this.s5 = i6;
        this.s6 = i7;
        this.s7 = i8;
        this.s8 = i10;
        this.handler.sendEmptyMessage(110);
    }

    public void callBackUserParams(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9) {
        CommonUtil.Log(1, "callBackUserParams user1:" + str2 + "  user2:" + str4 + " user3:" + str6 + "  pwd4:" + str9);
        this.user1 = str2;
        this.pwd1 = str3;
        this.user2 = str4;
        this.pwd2 = str5;
        this.user3 = str6;
        this.pwd3 = str7;
        this.user4 = str8;
        this.pwd4 = str9;
        this.admin = 1;
        this.s1 = 1;
        this.s2 = 1;
        this.s3 = 1;
        this.s4 = 1;
        this.handler.sendEmptyMessage(110);
    }
}
