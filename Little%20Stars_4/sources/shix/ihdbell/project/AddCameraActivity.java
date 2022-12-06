package shix.ihdbell.project;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewCompat;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.jxl.app.littlestars.project.R;
import com.tzh.ipcamera.view.VC.LoginLocalWiFiAty;
import com.xiaomi.mipush.sdk.Constants;
import java.util.Map;
import object.p2pipcam.adapter.SearchListAdapter;
import object.p2pipcam.content.ContentCommon;
import object.p2pipcam.nativecaller.NativeCaller;
import object.p2pipcam.system.SystemValue;
import object.p2pipcam.utils.VibratorUtil;
import object.p2pipcam.zxingtwodimensioncode.CaptureActivity;
import shix.ihdbell.project.BridgeService;

public class AddCameraActivity extends BaseActivity implements View.OnClickListener, BridgeService.AddCameraInterface, SensorEventListener {
    private static final int SEARCH_TIME = 3000;
    private int CameraType = 1;
    private int SSID_REQUIST_CODE = 5;
    private TextView back;
    private LinearLayout btnScanId;
    /* access modifiers changed from: private */
    public int count = 0;
    private EditText devNameEdit = null;
    /* access modifiers changed from: private */
    public EditText didEdit = null;
    private Button done;
    /* access modifiers changed from: private */
    public boolean isSearched;
    /* access modifiers changed from: private */
    public boolean isStart = false;
    /* access modifiers changed from: private */
    public SearchListAdapter listAdapter = null;
    private LinearLayout lyEditPwd = null;
    private LinearLayout lyEditUser = null;
    Runnable mResetRunnable = new Runnable() {
        public void run() {
            if (AddCameraActivity.this.resetState >= 0) {
                AddCameraActivity.this.progressdlg.dismiss();
                AddCameraActivity.this.showToast((int) R.string.camera_modify_success);
                AddCameraActivity.this.progressdlg.dismiss();
                AddCameraActivity.this.setNewParam();
                AddCameraActivity.this.exitActivity();
                return;
            }
            AddCameraActivity.access$308(AddCameraActivity.this);
            if (AddCameraActivity.this.count >= 8) {
                int unused = AddCameraActivity.this.count = 0;
                int unused2 = AddCameraActivity.this.resetState = -1;
                AddCameraActivity.this.progressdlg.dismiss();
                AddCameraActivity.this.showToast((int) R.string.camera_modify_failed);
                return;
            }
            AddCameraActivity.this.updateListHandler.postDelayed(AddCameraActivity.this.mResetRunnable, 500);
        }
    };
    private int model = 0;
    private LinearLayout onekey;
    private int option = 65535;
    /* access modifiers changed from: private */
    public ProgressDialog progressdlg = null;
    /* access modifiers changed from: private */
    public EditText pwdEdit = null;
    /* access modifiers changed from: private */
    public int resetState = -2;
    private String strDID = "";
    private String strDevName = "";
    private String strName = "";
    private String strOldDID = "";
    private String strOldPwd = "";
    private String strOldUser = "";
    private String strPwd = "";
    private String strUser = "";
    private TextView textViewAddCamera = null;
    Handler updateListHandler = new Handler() {
        public void handleMessage(Message message) {
            if (message.what == 1) {
                AddCameraActivity.this.listAdapter.notifyDataSetChanged();
                if (AddCameraActivity.this.listAdapter.getCount() > 0) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(AddCameraActivity.this);
                    builder.setTitle(AddCameraActivity.this.getResources().getString(R.string.add_search_result));
                    builder.setCancelable(false);
                    builder.setPositiveButton(AddCameraActivity.this.getResources().getString(R.string.refresh), new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialogInterface, int i) {
                            AddCameraActivity.this.startSearch();
                        }
                    });
                    builder.setNegativeButton(AddCameraActivity.this.getResources().getString(R.string.str_cancel), new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.cancel();
                            boolean unused = AddCameraActivity.this.isStart = false;
                        }
                    });
                    builder.setAdapter(AddCameraActivity.this.listAdapter, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Map<String, Object> itemContent = AddCameraActivity.this.listAdapter.getItemContent(i);
                            if (itemContent != null) {
                                String str = (String) itemContent.get(ContentCommon.STR_CAMERA_NAME);
                                AddCameraActivity.this.userEdit.setText(ContentCommon.DEFAULT_USER_NAME);
                                AddCameraActivity.this.pwdEdit.setText("");
                                AddCameraActivity.this.didEdit.setText((String) itemContent.get(ContentCommon.STR_CAMERA_ID));
                                boolean unused = AddCameraActivity.this.isStart = false;
                            }
                        }
                    });
                    builder.show();
                    return;
                }
                AddCameraActivity addCameraActivity = AddCameraActivity.this;
                Toast.makeText(addCameraActivity, addCameraActivity.getResources().getString(R.string.add_search_no), 1).show();
                boolean unused = AddCameraActivity.this.isSearched = false;
                boolean unused2 = AddCameraActivity.this.isStart = false;
            }
        }
    };
    Runnable updateThread = new Runnable() {
        public void run() {
            NativeCaller.StopSearch();
            AddCameraActivity.this.progressdlg.dismiss();
            Message obtainMessage = AddCameraActivity.this.updateListHandler.obtainMessage();
            obtainMessage.what = 1;
            AddCameraActivity.this.updateListHandler.sendMessage(obtainMessage);
        }
    };
    /* access modifiers changed from: private */
    public EditText userEdit = null;

    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    public void onSensorChanged(SensorEvent sensorEvent) {
    }

    static /* synthetic */ int access$308(AddCameraActivity addCameraActivity) {
        int i = addCameraActivity.count;
        addCameraActivity.count = i + 1;
        return i;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        setContentView(R.layout.add_camera);
        findView();
        Intent intent = getIntent();
        this.option = intent.getIntExtra(ContentCommon.CAMERA_OPTION, 65535);
        if (this.option != 65535) {
            this.strName = intent.getStringExtra(ContentCommon.STR_CAMERA_NAME);
            this.strOldDID = intent.getStringExtra(ContentCommon.STR_CAMERA_ID);
            String stringExtra = intent.getStringExtra(ContentCommon.STR_CAMERA_USER);
            this.strUser = stringExtra;
            this.strOldUser = stringExtra;
            String stringExtra2 = intent.getStringExtra(ContentCommon.STR_CAMERA_PWD);
            this.strPwd = stringExtra2;
            this.strOldPwd = stringExtra2;
            this.didEdit.setFocusable(false);
            this.didEdit.setTextColor(-1879048192);
        } else {
            this.didEdit.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        }
        Log.e(AddCameraActivity.class.getSimpleName(), "startAdd CameraActivity!");
        this.progressdlg = new ProgressDialog(this);
        this.progressdlg.setProgressStyle(0);
        this.progressdlg.setMessage(getString(R.string.searching_tip));
        this.listAdapter = new SearchListAdapter(this);
        InitParams();
        BridgeService.setAddCameraInterface(this);
        SetTab(this);
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        this.didEdit.setText(((App) getApplication()).connectSSid);
    }

    private void hideSof(EditText editText) {
        ((InputMethodManager) getSystemService("input_method")).hideSoftInputFromWindow(editText.getWindowToken(), 0);
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        hideSof(this.didEdit);
        super.onPause();
    }

    private void InitParams() {
        if (this.option == 2) {
            this.textViewAddCamera.setText(R.string.edit_camera);
            this.onekey.setVisibility(8);
            this.model = 1;
        } else {
            this.textViewAddCamera.setText(R.string.add_camera);
            this.userEdit.setEnabled(false);
            this.pwdEdit.setEnabled(false);
            this.model = 0;
        }
        if (this.option != 65535) {
            this.devNameEdit.setText(this.strName);
            this.userEdit.setText(this.strUser);
            this.pwdEdit.setText(this.strPwd);
            this.didEdit.setText(this.strOldDID);
        }
        this.back.setOnClickListener(this);
        this.done.setOnClickListener(this);
        this.btnScanId.setOnClickListener(this);
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        this.progressdlg.dismiss();
        NativeCaller.StopSearch();
        super.onStop();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        BridgeService.setAddCameraInterface((BridgeService.AddCameraInterface) null);
        super.onDestroy();
    }

    /* access modifiers changed from: private */
    public void startSearch() {
        this.listAdapter.ClearAll();
        this.progressdlg.setMessage(getString(R.string.searching_tip));
        this.progressdlg.setCancelable(false);
        this.progressdlg.show();
        new Thread(new SearchThread()).start();
        this.updateListHandler.postDelayed(this.updateThread, 3000);
    }

    private void startSearch1() {
        this.isStart = true;
        this.listAdapter.ClearAll();
        this.progressdlg.setMessage(getString(R.string.searching_tip));
        this.progressdlg.setCancelable(false);
        this.progressdlg.show();
        new Thread(new SearchThread()).start();
        this.updateListHandler.postDelayed(this.updateThread, 3000);
    }

    private void findView() {
        this.back = (TextView) findViewById(R.id.back);
        this.done = (Button) findViewById(R.id.done);
        this.devNameEdit = (EditText) findViewById(R.id.editDevName);
        this.userEdit = (EditText) findViewById(R.id.editUser);
        this.pwdEdit = (EditText) findViewById(R.id.editPwd);
        this.didEdit = (EditText) findViewById(R.id.editDID);
        this.btnScanId = (LinearLayout) findViewById(R.id.scanID);
        this.textViewAddCamera = (TextView) findViewById(R.id.textview_add_camera);
        this.onekey = (LinearLayout) findViewById(R.id.btn_onekey);
        this.onekey.setOnClickListener(this);
    }

    public void onClick(View view) {
        VibratorUtil.Vibrate(this, 20);
        switch (view.getId()) {
            case R.id.back:
                ((App) getApplication()).connectSSid = "";
                finish();
                overridePendingTransition(R.anim.out_to_right, R.anim.in_from_left);
                return;
            case R.id.btn_onekey:
                Intent intent = new Intent(this, LoginLocalWiFiAty.class);
                intent.putExtra("wifiSSID", "");
                intent.putExtra("wifiPwd", "");
                startActivityForResult(intent, this.SSID_REQUIST_CODE);
                overridePendingTransition(R.anim.in_from_right, R.anim.out_to_left);
                return;
            case R.id.done:
                Log.e("AddCamera", "add camera done!");
                done();
                overridePendingTransition(R.anim.out_to_right, R.anim.in_from_left);
                return;
            case R.id.scanID:
                this.progressdlg.setMessage(getResources().getString(R.string.add_twodimensioncode));
                this.progressdlg.setCancelable(false);
                this.progressdlg.show();
                startActivityForResult(new Intent(this, CaptureActivity.class), 0);
                overridePendingTransition(R.anim.in_from_right, R.anim.out_to_left);
                return;
            default:
                return;
        }
    }

    private void hiddenInputMethod() {
        ((InputMethodManager) getSystemService("input_method")).toggleSoftInput(0, 2);
    }

    private void searchCamera() {
        if (!this.isSearched) {
            this.isSearched = true;
            startSearch();
            return;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(getResources().getString(R.string.add_search_result));
        builder.setCancelable(false);
        builder.setPositiveButton(getResources().getString(R.string.refresh), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                AddCameraActivity.this.startSearch();
            }
        });
        builder.setNegativeButton(getResources().getString(R.string.str_cancel), (DialogInterface.OnClickListener) null);
        builder.setAdapter(this.listAdapter, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                Map<String, Object> itemContent = AddCameraActivity.this.listAdapter.getItemContent(i);
                if (itemContent != null) {
                    String str = (String) itemContent.get(ContentCommon.STR_CAMERA_NAME);
                    AddCameraActivity.this.userEdit.setText(ContentCommon.DEFAULT_USER_NAME);
                    AddCameraActivity.this.pwdEdit.setText("");
                    AddCameraActivity.this.didEdit.setText((String) itemContent.get(ContentCommon.STR_CAMERA_ID));
                }
            }
        });
        builder.show();
    }

    private void done() {
        boolean z;
        this.strDevName = this.devNameEdit.getText().toString();
        this.strUser = this.userEdit.getText().toString();
        this.strPwd = this.pwdEdit.getText().toString();
        this.strDID = this.didEdit.getText().toString().toUpperCase();
        if (this.strDevName.length() == 0) {
            showToast((int) R.string.input_camera_name);
        } else if (this.strDID.length() == 0) {
            showToast((int) R.string.input_camera_id);
        } else if (this.strDID.length() > 8) {
            String substring = this.strDID.substring(0, 8);
            if (this.strUser.length() < 5) {
                showToast(getString(R.string.biz_add_show_user));
            } else if (this.strPwd.length() < 5) {
                showToast(getString(R.string.biz_add_show_pwd));
            } else if (!this.strPwd.equals(this.strOldPwd) || !this.strUser.equals(this.strOldUser)) {
                int i = 0;
                while (true) {
                    if (i >= substring.length()) {
                        z = false;
                        break;
                    }
                    StringBuilder sb = new StringBuilder();
                    sb.append("test:");
                    sb.append(substring.charAt(i) >= '0');
                    sb.append(substring.charAt(i) <= '9');
                    sb.append("  str:");
                    sb.append(substring);
                    Log.d("tag", sb.toString());
                    if (substring.charAt(i) >= '0' && substring.charAt(i) <= '9') {
                        z = true;
                        break;
                    }
                    i++;
                }
                if (!z) {
                    showToast((int) R.string.add_camer_invi);
                } else if (this.strDID.indexOf("OBJ") >= 0 && Integer.parseInt(this.strDID.replaceAll("[^\\d]+", "")) > 33333) {
                    showToast((int) R.string.add_camer_invi);
                } else if (this.strDID.indexOf("ZSKJ") < 0 || Integer.parseInt(this.strDID.replaceAll("[^\\d]+", "")) <= 3110) {
                    int i2 = 0;
                    while (i2 < SystemValue.arrayList.size()) {
                        if (this.strOldDID.endsWith(this.strDID) || !this.strDID.equalsIgnoreCase(SystemValue.arrayList.get(i2).getDid())) {
                            i2++;
                        } else {
                            showToast((int) R.string.input_camera_all_include);
                            return;
                        }
                    }
                    if (this.strUser.length() == 0) {
                        showToast((int) R.string.input_camera_user);
                    } else if (this.model == 0 && this.strUser.equals(ContentCommon.DEFAULT_USER_NAME) && this.strPwd.equals(ContentCommon.DEFAULT_USER_NAME)) {
                        Intent intent = new Intent();
                        intent.setAction(ContentCommon.STR_CAMERA_INFO_RECEIVER);
                        if (this.option == 65535) {
                            Log.e(AddCameraActivity.class.getSimpleName(), "ContentCommon.INVALID_OPTION");
                            this.option = 1;
                        }
                        intent.putExtra(ContentCommon.CAMERA_OPTION, this.option);
                        if (this.option != 65535) {
                            String simpleName = AddCameraActivity.class.getSimpleName();
                            Log.e(simpleName, "ContentCommon.STR_CAMERA_OLD_ID:" + this.strOldDID);
                            intent.putExtra(ContentCommon.STR_CAMERA_OLD_ID, this.strOldDID);
                        }
                        String simpleName2 = AddCameraActivity.class.getSimpleName();
                        Log.e(simpleName2, "name:" + this.strDevName);
                        String simpleName3 = AddCameraActivity.class.getSimpleName();
                        Log.e(simpleName3, "id:" + this.strDID.replace(Constants.ACCEPT_TIME_SEPARATOR_SERVER, ""));
                        String simpleName4 = AddCameraActivity.class.getSimpleName();
                        Log.e(simpleName4, "user:" + this.strUser);
                        String simpleName5 = AddCameraActivity.class.getSimpleName();
                        Log.e(simpleName5, "passwd:" + this.strPwd);
                        intent.putExtra(ContentCommon.STR_CAMERA_NAME, this.strDevName);
                        intent.putExtra(ContentCommon.STR_CAMERA_ID, this.strDID.replace(Constants.ACCEPT_TIME_SEPARATOR_SERVER, ""));
                        intent.putExtra(ContentCommon.STR_CAMERA_USER, this.strUser);
                        intent.putExtra(ContentCommon.STR_CAMERA_PWD, this.strPwd);
                        intent.putExtra(ContentCommon.STR_CAMERA_TYPE, this.CameraType);
                        sendBroadcast(intent);
                        ((App) getApplication()).connectSSid = "";
                        exitActivity();
                    } else if (!this.strUser.equals(this.strOldUser) || !this.strPwd.equals(this.strOldPwd)) {
                        this.resetState = -2;
                        NativeCaller.TransferMessage(this.strDID, String.format("/rename.cgi?next_url=&user=" + this.strOldUser + "&pwd=" + this.strOldPwd + "&newuser=" + this.strUser + "&newpas=" + this.strPwd, new Object[0]), 1);
                        NativeCaller.PPPPGetSystemParams(this.strDID, 59);
                        this.progressdlg.setMessage(getString(R.string.camera_modify_ing));
                        this.progressdlg.setCancelable(false);
                        this.progressdlg.show();
                        this.updateListHandler.post(this.mResetRunnable);
                        Log.e("AddCamera111", "###oldUser:" + this.strOldUser + " oldPwd:" + this.strOldPwd + " User:" + this.strUser + " pwd:" + this.strPwd);
                    } else {
                        exitActivity();
                    }
                } else {
                    showToast((int) R.string.add_camer_invi);
                }
            } else {
                showToast(getString(R.string.biz_add_poup_modify));
            }
        } else {
            String str = this.strDID;
            showToast((int) R.string.add_camer_invi);
        }
    }

    /* access modifiers changed from: package-private */
    public void exitActivity() {
        finish();
    }

    /* access modifiers changed from: private */
    public void setNewParam() {
        Intent intent = new Intent();
        intent.setAction(ContentCommon.STR_CAMERA_INFO_RECEIVER);
        if (this.option == 65535) {
            Log.e(AddCameraActivity.class.getSimpleName(), "ContentCommon.INVALID_OPTION");
            this.option = 1;
        }
        intent.putExtra(ContentCommon.CAMERA_OPTION, this.option);
        if (this.option != 65535) {
            String simpleName = AddCameraActivity.class.getSimpleName();
            Log.e(simpleName, "ContentCommon.STR_CAMERA_OLD_ID:" + this.strOldDID);
            intent.putExtra(ContentCommon.STR_CAMERA_OLD_ID, this.strOldDID);
        }
        String simpleName2 = AddCameraActivity.class.getSimpleName();
        Log.e(simpleName2, "name:" + this.strDevName);
        String simpleName3 = AddCameraActivity.class.getSimpleName();
        Log.e(simpleName3, "id:" + this.strDID.replace(Constants.ACCEPT_TIME_SEPARATOR_SERVER, ""));
        String simpleName4 = AddCameraActivity.class.getSimpleName();
        Log.e(simpleName4, "user:" + this.strOldUser);
        String simpleName5 = AddCameraActivity.class.getSimpleName();
        Log.e(simpleName5, "passwd:" + this.strOldPwd);
        intent.putExtra(ContentCommon.STR_CAMERA_NAME, this.strDevName);
        intent.putExtra(ContentCommon.STR_CAMERA_ID, this.strDID.replace(Constants.ACCEPT_TIME_SEPARATOR_SERVER, ""));
        intent.putExtra(ContentCommon.STR_CAMERA_USER, this.strUser);
        intent.putExtra(ContentCommon.STR_CAMERA_PWD, this.strPwd);
        intent.putExtra(ContentCommon.STR_CAMERA_TYPE, this.CameraType);
        sendBroadcast(intent);
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            this.didEdit.setText(intent.getExtras().getString("result"));
        } else if (i != this.SSID_REQUIST_CODE) {
        } else {
            if (intent == null) {
                Log.e(AddCameraActivity.class.getSimpleName(), "data is null");
                return;
            }
            String string = intent.getExtras().getString(ContentCommon.STR_CAMERA_ID);
            String simpleName = AddCameraActivity.class.getSimpleName();
            Log.e(simpleName, "cameraname is " + string);
            if (!string.isEmpty()) {
                this.didEdit.setText(string);
            }
        }
    }

    public void callBackSearchResultData(int i, String str, String str2, String str3, String str4, int i2) {
        if (!this.listAdapter.AddCamera(str, str2, str3.replace(Constants.ACCEPT_TIME_SEPARATOR_SERVER, ""))) {
        }
    }

    public void callBackResetResultData(int i) {
        Log.e("AddCameraActivity", "### you have recive:" + i);
        this.resetState = i;
    }

    private class SearchThread implements Runnable {
        private SearchThread() {
        }

        public void run() {
            Log.d("tag", "startSearch");
            NativeCaller.StartSearch();
        }
    }
}
