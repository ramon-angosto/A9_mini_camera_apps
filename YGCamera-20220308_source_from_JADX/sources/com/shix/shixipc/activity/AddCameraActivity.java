package com.shix.shixipc.activity;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.ContentUris;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import com.dommy.qrcode.util.Constant;
import com.google.zxing.activity.CaptureActivity;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.shix.shixipc.BaseActivity;
import com.shix.shixipc.system.ContentCommon;
import com.shix.shixipc.system.StyleCommon;
import com.shix.shixipc.system.SystemValue;
import com.shix.shixipc.utils.CommonUtil;
import com.xiaomi.mipush.sdk.Constants;
import java.io.File;
import object.p2pipcam.nativecaller.NativeCaller;
import shix.cykj.camera.R;

public class AddCameraActivity extends BaseActivity implements View.OnClickListener {
    public static final int REQUEST_CODE_CAMERA_ADD = 0;
    private static final int SEARCH_TIME = 3000;
    private static DeleInterface deleInterface;
    private int CameraType = 1;
    private final int REQUEST_CHOOSEFILE = 110;
    private Button back;
    private Button btnScanId;
    private Button btnSearchCamera;
    private Button delbtn;
    private EditText devNameEdit = null;
    private EditText didEdit = null;
    private Button done;
    private ImageButton done1;
    private boolean isSearched;
    private int option = 65535;
    /* access modifiers changed from: private */
    public ProgressDialog progressdlg = null;
    private int pushTypeInt = 0;
    private EditText pwdEdit = null;
    private String strName = "";
    private String strOldDID = "";
    private String strPwd = "";
    private String strUser = "";
    private TextView textViewAddCamera = null;
    Handler updateListHandler = new Handler() {
        public void handleMessage(Message message) {
            int i = message.what;
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
    private EditText userEdit = null;

    public interface DeleInterface {
        void CallBackDel(String str, String str2);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        setContentView(R.layout.add_camera);
        Intent intent = getIntent();
        this.option = intent.getIntExtra(ContentCommon.CAMERA_OPTION, 65535);
        this.pushTypeInt = intent.getIntExtra("pushTypeInt", 0);
        if (this.option != 65535 || this.pushTypeInt == 110) {
            this.strName = intent.getStringExtra(ContentCommon.STR_CAMERA_NAME);
            this.strOldDID = intent.getStringExtra(ContentCommon.STR_CAMERA_ID);
            this.strUser = intent.getStringExtra(ContentCommon.STR_CAMERA_USER);
            this.strPwd = intent.getStringExtra(ContentCommon.STR_CAMERA_PWD);
        }
        this.progressdlg = new ProgressDialog(this);
        this.progressdlg.setProgressStyle(0);
        this.progressdlg.setMessage(getString(R.string.searching_tip));
        findView();
        InitParams();
        SetTab(this, StyleCommon.Color_All_Top_StatuBar_Bg);
        if (this.option == 2) {
            this.btnScanId.setVisibility(8);
            this.btnSearchCamera.setVisibility(8);
            this.done1.setVisibility(4);
            this.delbtn.setVisibility(0);
            this.didEdit.setEnabled(false);
            return;
        }
        this.delbtn.setVisibility(8);
    }

    private void hideSof(EditText editText) {
        ((InputMethodManager) getSystemService("input_method")).hideSoftInputFromWindow(editText.getWindowToken(), 0);
    }

    public static void hideSoftKeyboard(Activity activity) {
        View currentFocus = activity.getCurrentFocus();
        if (currentFocus != null) {
            ((InputMethodManager) activity.getSystemService("input_method")).hideSoftInputFromWindow(currentFocus.getWindowToken(), 2);
        }
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        hideSoftKeyboard(this);
        super.onPause();
    }

    private void InitParams() {
        if (this.option == 2) {
            this.textViewAddCamera.setText(R.string.edit_camera);
        } else {
            this.textViewAddCamera.setText(R.string.add_camera);
        }
        if (this.option != 65535) {
            this.devNameEdit.setText(this.strName);
            this.userEdit.setText(this.strUser);
            this.pwdEdit.setText(this.strPwd);
            this.didEdit.setText(this.strOldDID);
        }
        this.back.setOnClickListener(this);
        this.done.setOnClickListener(this);
        this.done1.setOnClickListener(this);
        this.btnScanId.setOnClickListener(this);
        this.btnSearchCamera.setOnClickListener(this);
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        super.onStop();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
    }

    private void findView() {
        this.delbtn = (Button) findViewById(R.id.delbtn);
        this.delbtn.setOnClickListener(this);
        this.done1 = (ImageButton) findViewById(R.id.done1);
        this.back = (Button) findViewById(R.id.back);
        this.done = (Button) findViewById(R.id.done);
        this.devNameEdit = (EditText) findViewById(R.id.editDevName);
        this.userEdit = (EditText) findViewById(R.id.editUser);
        this.pwdEdit = (EditText) findViewById(R.id.editPwd);
        this.didEdit = (EditText) findViewById(R.id.editDID);
        this.btnScanId = (Button) findViewById(R.id.scanID);
        this.btnSearchCamera = (Button) findViewById(R.id.btn_searchCamera);
        this.textViewAddCamera = (TextView) findViewById(R.id.textview_add_camera);
        if (this.pushTypeInt == 110) {
            this.devNameEdit.setText(this.strName);
            this.didEdit.setText(this.strOldDID);
            this.userEdit.setText(this.strUser);
            this.pwdEdit.setText(this.strPwd);
        }
    }

    public void onClick(View view) {
        if (ContentCommon.ISVISI.booleanValue()) {
            CommonUtil.Vibrate(this, 10);
        }
        switch (view.getId()) {
            case R.id.back /*2131165270*/:
                finish();
                return;
            case R.id.btn_searchCamera /*2131165305*/:
                if (ContentCommon.ISVISI.booleanValue()) {
                    CommonUtil.Vibrate(this, 10);
                }
                startActivityForResult(new Intent(this, SertchActivity.class), 0);
                return;
            case R.id.delbtn /*2131165410*/:
                DeleInterface deleInterface2 = deleInterface;
                if (deleInterface2 != null) {
                    deleInterface2.CallBackDel(this.strOldDID, this.strName);
                }
                finish();
                return;
            case R.id.done /*2131165417*/:
                done();
                return;
            case R.id.done1 /*2131165418*/:
            case R.id.scanID /*2131165735*/:
                this.progressdlg.setMessage(getResources().getString(R.string.add_twodimensioncode));
                this.progressdlg.setCancelable(false);
                this.progressdlg.show();
                startActivityForResult(new Intent(this, CaptureActivity.class), Constant.REQ_QR_CODE);
                return;
            default:
                return;
        }
    }

    /* access modifiers changed from: protected */
    public void onRestart() {
        super.onRestart();
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        ProgressDialog progressDialog = this.progressdlg;
        if (progressDialog != null && progressDialog.isShowing()) {
            this.progressdlg.cancel();
        }
        super.onResume();
    }

    private void hiddenInputMethod() {
        ((InputMethodManager) getSystemService("input_method")).toggleSoftInput(0, 2);
    }

    private void done() {
        boolean z;
        Intent intent = new Intent();
        String obj = this.devNameEdit.getText().toString();
        String obj2 = this.userEdit.getText().toString();
        String obj3 = this.pwdEdit.getText().toString();
        String upperCase = this.didEdit.getText().toString().toUpperCase();
        if (obj.length() == 0) {
            showToast((int) R.string.input_camera_name);
        } else if (upperCase.length() == 0) {
            showToast((int) R.string.input_camera_id);
        } else {
            int i = 0;
            String substring = upperCase.length() > 8 ? upperCase.substring(0, 8) : upperCase;
            int i2 = 0;
            while (true) {
                if (i2 >= substring.length()) {
                    z = false;
                    break;
                }
                StringBuilder sb = new StringBuilder();
                sb.append("test:");
                sb.append(substring.charAt(i2) >= '0');
                sb.append(substring.charAt(i2) <= '9');
                sb.append("  str:");
                sb.append(substring);
                Log.d(RemoteMessageConst.Notification.TAG, sb.toString());
                if (substring.charAt(i2) >= '0' && substring.charAt(i2) <= '9') {
                    z = true;
                    break;
                }
                i2++;
            }
            if (!z) {
                showToast((int) R.string.add_camer_invi);
                return;
            }
            while (i < SystemValue.arrayList.size()) {
                if (this.strOldDID.endsWith(upperCase) || !upperCase.equalsIgnoreCase(SystemValue.arrayList.get(i).getDev_Did())) {
                    i++;
                } else {
                    showToast((int) R.string.input_camera_all_include);
                    return;
                }
            }
            if (obj2.length() == 0) {
                showToast((int) R.string.input_camera_user);
                return;
            }
            intent.setAction(ContentCommon.STR_CAMERA_INFO_RECEIVER);
            if (this.option == 65535) {
                this.option = 1;
            }
            intent.putExtra(ContentCommon.CAMERA_OPTION, this.option);
            if (this.option != 65535) {
                intent.putExtra(ContentCommon.STR_CAMERA_OLD_ID, this.strOldDID);
            }
            intent.putExtra(ContentCommon.STR_CAMERA_NAME, obj);
            intent.putExtra(ContentCommon.STR_CAMERA_ID, upperCase.replace(Constants.ACCEPT_TIME_SEPARATOR_SERVER, "").trim());
            intent.putExtra(ContentCommon.STR_CAMERA_USER, obj2);
            intent.putExtra(ContentCommon.STR_CAMERA_PWD, obj3);
            intent.putExtra(ContentCommon.STR_CAMERA_TYPE, this.CameraType);
            sendBroadcast(intent);
            Log.e("zhaogenghuai1", "sendBroadcast");
            finish();
        }
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        Uri data;
        String path;
        super.onActivityResult(i, i2, intent);
        if (i == 11002 && i2 == -1) {
            this.didEdit.setText(intent.getExtras().getString(Constant.INTENT_EXTRA_KEY_QR_SCAN));
        }
        if (i2 != -1) {
            return;
        }
        if (i == 0) {
            this.didEdit.setText(intent.getStringExtra("mUID"));
        } else if (i == 110 && (data = intent.getData()) != null && (path = getPath(this, data)) != null) {
            File file = new File(path);
            if (file.exists()) {
                String file2 = file.toString();
                String name = file.getName();
                Log.d("", "?????????????????????" + file2 + "  upLoadFileName:" + name);
            }
        }
    }

    public String getPath(Context context, Uri uri) {
        Uri uri2 = null;
        if (!(Build.VERSION.SDK_INT >= 19) || !DocumentsContract.isDocumentUri(context, uri)) {
            if (RemoteMessageConst.Notification.CONTENT.equalsIgnoreCase(uri.getScheme())) {
                return getDataColumn(context, uri, (String) null, (String[]) null);
            }
            if ("file".equalsIgnoreCase(uri.getScheme())) {
                return uri.getPath();
            }
        } else if (isExternalStorageDocument(uri)) {
            String[] split = DocumentsContract.getDocumentId(uri).split(Constants.COLON_SEPARATOR);
            if ("primary".equalsIgnoreCase(split[0])) {
                return Environment.getExternalStorageDirectory() + "/" + split[1];
            }
        } else if (isDownloadsDocument(uri)) {
            return getDataColumn(context, ContentUris.withAppendedId(Uri.parse("content://downloads/public_downloads"), Long.valueOf(DocumentsContract.getDocumentId(uri)).longValue()), (String) null, (String[]) null);
        } else if (isMediaDocument(uri)) {
            String[] split2 = DocumentsContract.getDocumentId(uri).split(Constants.COLON_SEPARATOR);
            String str = split2[0];
            if ("image".equals(str)) {
                uri2 = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
            } else if ("video".equals(str)) {
                uri2 = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
            } else if ("audio".equals(str)) {
                uri2 = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
            }
            return getDataColumn(context, uri2, "_id=?", new String[]{split2[1]});
        }
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0035  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String getDataColumn(android.content.Context r9, android.net.Uri r10, java.lang.String r11, java.lang.String[] r12) {
        /*
            r8 = this;
            java.lang.String r0 = "_data"
            java.lang.String[] r3 = new java.lang.String[]{r0}
            r7 = 0
            android.content.ContentResolver r1 = r9.getContentResolver()     // Catch:{ all -> 0x0031 }
            r6 = 0
            r2 = r10
            r4 = r11
            r5 = r12
            android.database.Cursor r9 = r1.query(r2, r3, r4, r5, r6)     // Catch:{ all -> 0x0031 }
            if (r9 == 0) goto L_0x002b
            boolean r10 = r9.moveToFirst()     // Catch:{ all -> 0x0029 }
            if (r10 == 0) goto L_0x002b
            int r10 = r9.getColumnIndexOrThrow(r0)     // Catch:{ all -> 0x0029 }
            java.lang.String r10 = r9.getString(r10)     // Catch:{ all -> 0x0029 }
            if (r9 == 0) goto L_0x0028
            r9.close()
        L_0x0028:
            return r10
        L_0x0029:
            r10 = move-exception
            goto L_0x0033
        L_0x002b:
            if (r9 == 0) goto L_0x0030
            r9.close()
        L_0x0030:
            return r7
        L_0x0031:
            r10 = move-exception
            r9 = r7
        L_0x0033:
            if (r9 == 0) goto L_0x0038
            r9.close()
        L_0x0038:
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shix.shixipc.activity.AddCameraActivity.getDataColumn(android.content.Context, android.net.Uri, java.lang.String, java.lang.String[]):java.lang.String");
    }

    public boolean isExternalStorageDocument(Uri uri) {
        return "com.android.externalstorage.documents".equals(uri.getAuthority());
    }

    public boolean isDownloadsDocument(Uri uri) {
        return "com.android.providers.downloads.documents".equals(uri.getAuthority());
    }

    public boolean isMediaDocument(Uri uri) {
        return "com.android.providers.media.documents".equals(uri.getAuthority());
    }

    public static void setDeleInterface(DeleInterface deleInterface2) {
        deleInterface = deleInterface2;
    }
}
