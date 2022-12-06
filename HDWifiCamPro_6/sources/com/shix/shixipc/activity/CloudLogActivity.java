package com.shix.shixipc.activity;

import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.core.content.FileProvider;
import com.alibaba.sdk.android.oss.ClientConfiguration;
import com.alibaba.sdk.android.oss.ClientException;
import com.alibaba.sdk.android.oss.OSS;
import com.alibaba.sdk.android.oss.OSSClient;
import com.alibaba.sdk.android.oss.ServiceException;
import com.alibaba.sdk.android.oss.callback.OSSCompletedCallback;
import com.alibaba.sdk.android.oss.common.auth.OSSCredentialProvider;
import com.alibaba.sdk.android.oss.common.auth.OSSPlainTextAKSKCredentialProvider;
import com.alibaba.sdk.android.oss.model.DeleteObjectRequest;
import com.alibaba.sdk.android.oss.model.DeleteObjectResult;
import com.alibaba.sdk.android.oss.model.ListObjectsRequest;
import com.alibaba.sdk.android.oss.model.ListObjectsResult;
import com.mbridge.msdk.playercommon.exoplayer2.DefaultLoadControl;
import com.shix.qhipc.R;
import com.shix.shixipc.BaseActivity;
import com.shix.shixipc.adapter.CloudLogAdapter;
import com.shix.shixipc.bean.CloudBean;
import com.shix.shixipc.system.ContentCommon;
import com.shix.shixipc.system.StyleCommon;
import com.shix.shixipc.utils.CommonUtil;
import com.shix.shixipc.view.Effectstype;
import com.shix.shixipc.view.NiftyDialogBuilder;
import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import object.p2pipcam.nativecaller.NativeCaller;

public class CloudLogActivity extends BaseActivity implements View.OnClickListener {
    private final int BEND = 1;
    private final int BEND1 = 2;
    private Handler BitMapHandler = new Handler() {
        public void handleMessage(Message message) {
            if (message.what == 110) {
                CloudLogActivity.this.imageView.setImageBitmap(CloudLogActivity.this.bmp);
                CloudLogActivity.this.takePicture();
                return;
            }
            CloudLogActivity.this.textView_name.setText("/mnt/sdcard/HDWiFiCam/picVisitor/");
            CloudLogActivity.this.adapter.notifyDataSetChanged();
            Log.d(ContentCommon.SERVER_STRING, "savePicToSDcard4");
        }
    };
    String CloudPath111;
    int DownLoadCount = 0;
    String FileName111;
    private final int REFRESH = 3;
    private final int REFRESHAll = 4;
    /* access modifiers changed from: private */
    public CloudLogAdapter adapter;
    /* access modifiers changed from: private */
    public Bitmap bmp;
    private Button btnBack;
    /* access modifiers changed from: private */
    public Button buttonPlay;
    private String camName;
    /* access modifiers changed from: private */
    public int cloudSize = 0;
    private String dateTime = "";
    /* access modifiers changed from: private */
    public String delCloudPath = "";
    /* access modifiers changed from: private */
    public int delPosition = 0;
    private String delStrDid = "";
    /* access modifiers changed from: private */
    public String did;
    /* access modifiers changed from: private */
    public String downloadPath = "";
    private FrameLayout framelayout;
    /* access modifiers changed from: private */
    public ImageView imageView;
    /* access modifiers changed from: private */
    public boolean isDelAll = false;
    private LinearLayout linearLayout_buttom;
    /* access modifiers changed from: private */
    public ListView listView;
    /* access modifiers changed from: private */
    public Handler mHandler = new Handler() {
        public void handleMessage(Message message) {
            int i = message.what;
            if (i == 1) {
                String string = message.getData().getString("path");
                CommonUtil.Log(1, "path:" + string);
                String substring = string.substring(string.lastIndexOf("/") + 1);
                if (substring.length() >= 21) {
                    String substring2 = substring.substring(substring.lastIndexOf("-") + 1, substring.lastIndexOf("-") + 2);
                    CloudBean cloudBean = new CloudBean();
                    cloudBean.setCloudPath(string);
                    cloudBean.setStrDid(CloudLogActivity.this.did);
                    cloudBean.setFileName(substring);
                    cloudBean.setCreateTime(substring.substring(0, 10) + "  " + substring.substring(11, 19).replace("-", ":"));
                    cloudBean.setType(Integer.parseInt(substring2));
                    CloudLogActivity.this.adapter.addAlarmLog(cloudBean);
                }
            } else if (i == 2) {
                CommonUtil.Log(1, "------------------");
                if (CloudLogActivity.this.adapter.getCount() > 0) {
                    CloudLogActivity.this.listView.setVisibility(0);
                    CloudLogActivity.this.tvNoLog.setVisibility(8);
                } else {
                    CloudLogActivity.this.listView.setVisibility(8);
                    CloudLogActivity.this.tvNoLog.setVisibility(0);
                }
                CloudLogActivity.this.adapter.notifyDataSetChanged();
            } else if (i == 3) {
                CloudLogActivity.this.adapter.removeItem(CloudLogActivity.this.delPosition);
                CloudLogActivity.this.adapter.notifyDataSetChanged();
            } else if (i == 4) {
                CloudLogActivity.this.adapter.removeAll();
                CloudLogActivity.this.adapter.notifyDataSetChanged();
                if (CloudLogActivity.this.cloudSize == 1) {
                    CloudLogActivity.this.finish();
                    CloudLogActivity.this.startActivity(new Intent(CloudLogActivity.this, NUIMainActivity.class));
                    return;
                }
                CloudLogActivity.this.finish();
            }
        }
    };
    /* access modifiers changed from: private */
    public OSS oss;
    String pathTest;
    private int play_tag_log = 0;
    /* access modifiers changed from: private */
    public PopupWindow popupWindow_re;
    private View popv_re;
    /* access modifiers changed from: private */
    public String strTitle;
    String strdata;
    FileOutputStream testOS = null;
    private TextView textView;
    /* access modifiers changed from: private */
    public TextView textView_name;
    /* access modifiers changed from: private */
    public TextView tvNoLog;
    private TextView tv_camera_setting;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        setContentView(R.layout.cloudlog);
        this.strdata = getIntent().getStringExtra(ContentCommon.STR_CLOUD_DATE);
        this.cloudSize = getIntent().getIntExtra(ContentCommon.STR_CLOUD_ONEDAY, 0);
        findView();
        setListener();
        ((TextView) findViewById(R.id.tv_camera_setting)).setText(this.strdata);
        SetTab(this, StyleCommon.Color_All_Top_StatuBar_Bg);
        this.adapter = new CloudLogAdapter(this, this);
        this.listView.setAdapter(this.adapter);
        this.listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                CloudBean cloudBean = CloudLogActivity.this.adapter.getBeans().get(i);
                CloudLogActivity.this.showPic(i, cloudBean.getStrDid(), cloudBean.getFileName(), cloudBean.getCreateTime(), cloudBean.getCloudPath(), (String) null, cloudBean.getType());
            }
        });
        getDataFromOther();
        if (this.adapter.getCount() > 0) {
            this.listView.setVisibility(0);
            this.tvNoLog.setVisibility(8);
        } else {
            this.listView.setVisibility(8);
            this.tvNoLog.setVisibility(0);
        }
        if (this.play_tag_log == 1) {
            this.linearLayout_buttom.setVisibility(0);
            this.btnBack.setVisibility(8);
        }
        initExitPopupWindow_re();
        TextView textView2 = this.tv_camera_setting;
        textView2.setText(this.camName + " " + getResources().getString(R.string.cloud_log));
        String str = this.did;
        if (str == null || !str.startsWith(ContentCommon.SHIX_APPRE)) {
            this.did = this.did.toUpperCase().replace("-", "");
            if (this.did.indexOf("DGKC") >= 0 || this.did.indexOf(ContentCommon.SHIX_APPRE3) >= 0 || this.did.indexOf(ContentCommon.SHIX_APPRE4) >= 0 || this.did.indexOf("DGOC") >= 0 || this.did.indexOf("DGOD") >= 0) {
                this.did = this.did.substring(0, 4) + "-" + this.did.substring(4, 10) + "-" + this.did.substring(10);
            } else {
                this.did = this.did.substring(0, 3) + "-" + this.did.substring(3, 9) + "-" + this.did.substring(9);
            }
            CommonUtil.Log(1, "SHIXCLOUD  did:" + this.did);
            OSSPlainTextAKSKCredentialProvider oSSPlainTextAKSKCredentialProvider = new OSSPlainTextAKSKCredentialProvider(NativeCaller.SHIXGetAPPKey1(1), NativeCaller.SHIXGetAPPSer1(1));
            ClientConfiguration clientConfiguration = new ClientConfiguration();
            clientConfiguration.setConnectionTimeout(DefaultLoadControl.DEFAULT_MIN_BUFFER_MS);
            clientConfiguration.setSocketTimeout(DefaultLoadControl.DEFAULT_MIN_BUFFER_MS);
            clientConfiguration.setMaxConcurrentRequest(5);
            clientConfiguration.setMaxErrorRetry(2);
            this.oss = new OSSClient(getApplicationContext(), "http://oss-cn-shenzhen.aliyuncs.com", (OSSCredentialProvider) oSSPlainTextAKSKCredentialProvider);
            test();
            return;
        }
        this.did = this.did.toUpperCase().replace("-", "");
        if (this.did.indexOf("DGKC") >= 0 || this.did.indexOf(ContentCommon.SHIX_APPRE3) >= 0 || this.did.indexOf(ContentCommon.SHIX_APPRE4) >= 0 || this.did.indexOf("DGOC") >= 0 || this.did.indexOf("DGOD") >= 0 || this.did.indexOf("DGOE") >= 0 || this.did.indexOf("DGOF") >= 0) {
            this.did = this.did.substring(0, 4) + "-" + this.did.substring(4, 10) + "-" + this.did.substring(10);
        } else {
            this.did = this.did.substring(0, 3) + "-" + this.did.substring(3, 9) + "-" + this.did.substring(9);
        }
        CommonUtil.Log(1, "SHIXCLOUD  did:" + this.did);
        OSSPlainTextAKSKCredentialProvider oSSPlainTextAKSKCredentialProvider2 = new OSSPlainTextAKSKCredentialProvider(NativeCaller.SHIXGetAPPKey(), NativeCaller.SHIXGetAPPSer());
        ClientConfiguration clientConfiguration2 = new ClientConfiguration();
        clientConfiguration2.setConnectionTimeout(DefaultLoadControl.DEFAULT_MIN_BUFFER_MS);
        clientConfiguration2.setSocketTimeout(DefaultLoadControl.DEFAULT_MIN_BUFFER_MS);
        clientConfiguration2.setMaxConcurrentRequest(5);
        clientConfiguration2.setMaxErrorRetry(2);
        this.oss = new OSSClient(getApplicationContext(), "http://oss-cn-hongkong.aliyuncs.com", (OSSCredentialProvider) oSSPlainTextAKSKCredentialProvider2);
        test();
    }

    private void test() {
        String str = this.did;
        if (str == null || !str.startsWith(ContentCommon.SHIX_APPRE)) {
            ListObjectsRequest listObjectsRequest = new ListObjectsRequest(ContentCommon.CLOUDBUCKET);
            listObjectsRequest.setPrefix(this.did + "/photos/" + this.strdata + "/");
            listObjectsRequest.setMaxKeys(500);
            Log.d("OSS AyncListObjects", "OSS---start ");
            this.oss.asyncListObjects(listObjectsRequest, new OSSCompletedCallback<ListObjectsRequest, ListObjectsResult>() {
                public void onSuccess(ListObjectsRequest listObjectsRequest, ListObjectsResult listObjectsResult) {
                    Log.d("OSS AyncListObjects", "OSS Success!  size：" + listObjectsResult.getObjectSummaries().size());
                    for (int i = 0; i < listObjectsResult.getObjectSummaries().size(); i++) {
                        Log.d("OSS AyncListObjects", "OSS object: " + listObjectsResult.getObjectSummaries().get(i).getKey() + " " + listObjectsResult.getObjectSummaries().get(i).getETag() + " " + listObjectsResult.getObjectSummaries().get(i).getLastModified());
                        String key = listObjectsResult.getObjectSummaries().get(i).getKey();
                        Message obtainMessage = CloudLogActivity.this.mHandler.obtainMessage();
                        obtainMessage.what = 1;
                        Bundle bundle = new Bundle();
                        bundle.putString("path", key);
                        obtainMessage.setData(bundle);
                        CloudLogActivity.this.mHandler.sendMessage(obtainMessage);
                        if (i == listObjectsResult.getObjectSummaries().size() - 1) {
                            CloudLogActivity.this.mHandler.sendEmptyMessage(2);
                        }
                    }
                }

                public void onFailure(ListObjectsRequest listObjectsRequest, ClientException clientException, ServiceException serviceException) {
                    if (clientException != null) {
                        clientException.printStackTrace();
                    }
                    if (serviceException != null) {
                        Log.e("OSS ErrorCode", "OSS " + serviceException.getErrorCode());
                        Log.e("OSS RequestId", "OSS " + serviceException.getRequestId());
                        Log.e("OSS HostId", "OSS " + serviceException.getHostId());
                        Log.e("OSS RawMessage", "OSS " + serviceException.getRawMessage());
                    }
                    Log.d("OSS AyncListObjects", "OSS---end ");
                }
            }).waitUntilFinished();
            return;
        }
        ListObjectsRequest listObjectsRequest2 = new ListObjectsRequest(ContentCommon.CLOUDBUCKETHQ);
        listObjectsRequest2.setPrefix(this.did + "/photos/" + this.strdata + "/");
        listObjectsRequest2.setMaxKeys(500);
        Log.d("OSS AyncListObjects", "OSS---start ");
        this.oss.asyncListObjects(listObjectsRequest2, new OSSCompletedCallback<ListObjectsRequest, ListObjectsResult>() {
            public void onSuccess(ListObjectsRequest listObjectsRequest, ListObjectsResult listObjectsResult) {
                Log.d("OSS AyncListObjects", "OSS Success!  size：" + listObjectsResult.getObjectSummaries().size());
                for (int i = 0; i < listObjectsResult.getObjectSummaries().size(); i++) {
                    Log.d("OSS AyncListObjects", "OSS object: " + listObjectsResult.getObjectSummaries().get(i).getKey() + " " + listObjectsResult.getObjectSummaries().get(i).getETag() + " " + listObjectsResult.getObjectSummaries().get(i).getLastModified());
                    String key = listObjectsResult.getObjectSummaries().get(i).getKey();
                    Message obtainMessage = CloudLogActivity.this.mHandler.obtainMessage();
                    obtainMessage.what = 1;
                    Bundle bundle = new Bundle();
                    bundle.putString("path", key);
                    obtainMessage.setData(bundle);
                    CloudLogActivity.this.mHandler.sendMessage(obtainMessage);
                    if (i == listObjectsResult.getObjectSummaries().size() - 1) {
                        CloudLogActivity.this.mHandler.sendEmptyMessage(2);
                    }
                }
            }

            public void onFailure(ListObjectsRequest listObjectsRequest, ClientException clientException, ServiceException serviceException) {
                if (clientException != null) {
                    clientException.printStackTrace();
                }
                if (serviceException != null) {
                    Log.e("OSS ErrorCode", "OSS " + serviceException.getErrorCode());
                    Log.e("OSS RequestId", "OSS " + serviceException.getRequestId());
                    Log.e("OSS HostId", "OSS " + serviceException.getHostId());
                    Log.e("OSS RawMessage", "OSS " + serviceException.getRawMessage());
                }
                Log.d("OSS AyncListObjects", "OSS---end ");
            }
        }).waitUntilFinished();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x00ef, code lost:
        r6 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:?, code lost:
        r6.printStackTrace();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00f9, code lost:
        r6 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00fa, code lost:
        android.util.Log.e("RequestId", r6.getRequestId());
        android.util.Log.e("ErrorCode", r6.getErrorCode());
        android.util.Log.e("HostId", r6.getHostId());
        android.util.Log.e("RawMessage", r6.getRawMessage());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x011f, code lost:
        r6 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0120, code lost:
        r6.printStackTrace();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:?, code lost:
        return;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00f9 A[ExcHandler: ServiceException (r6v9 'e' com.alibaba.sdk.android.oss.ServiceException A[CUSTOM_DECLARE]), Splitter:B:14:0x0072] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x011f A[ExcHandler: ClientException (r6v8 'e' com.alibaba.sdk.android.oss.ClientException A[CUSTOM_DECLARE]), Splitter:B:14:0x0072] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void getObjectSample(java.lang.String r6, java.lang.String r7, java.lang.String r8) {
        /*
            r5 = this;
            java.io.File r0 = new java.io.File
            java.io.File r1 = com.shix.shixipc.utils.CommonUtil.getSDFilePath()
            java.lang.String r2 = "HDWiFiCam/cloud"
            r0.<init>(r1, r2)
            boolean r1 = r0.exists()
            if (r1 != 0) goto L_0x0014
            r0.mkdirs()
        L_0x0014:
            java.io.File r1 = new java.io.File
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r6)
            r2.append(r7)
            java.lang.String r6 = r2.toString()
            r1.<init>(r0, r6)
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = "getObjectSample path:"
            r6.append(r7)
            java.lang.String r7 = r1.getAbsolutePath()
            r6.append(r7)
            java.lang.String r6 = r6.toString()
            r7 = 1
            com.shix.shixipc.utils.CommonUtil.Log(r7, r6)
            java.io.FileOutputStream r6 = new java.io.FileOutputStream     // Catch:{ FileNotFoundException -> 0x0049 }
            r6.<init>(r1)     // Catch:{ FileNotFoundException -> 0x0049 }
            r5.testOS = r6     // Catch:{ FileNotFoundException -> 0x0049 }
            goto L_0x004d
        L_0x0049:
            r6 = move-exception
            r6.printStackTrace()
        L_0x004d:
            java.lang.String r6 = "testDown1"
            com.shix.shixipc.utils.CommonUtil.Log(r7, r6)
            com.alibaba.sdk.android.oss.model.GetObjectRequest r6 = new com.alibaba.sdk.android.oss.model.GetObjectRequest
            java.lang.String r0 = "shixdev"
            r6.<init>(r0, r8)
            java.lang.String r6 = r5.did
            if (r6 == 0) goto L_0x006d
            java.lang.String r1 = "DGK"
            boolean r6 = r6.startsWith(r1)
            if (r6 == 0) goto L_0x006d
            com.alibaba.sdk.android.oss.model.GetObjectRequest r6 = new com.alibaba.sdk.android.oss.model.GetObjectRequest
            java.lang.String r0 = "hdwificam"
            r6.<init>(r0, r8)
            goto L_0x0072
        L_0x006d:
            com.alibaba.sdk.android.oss.model.GetObjectRequest r6 = new com.alibaba.sdk.android.oss.model.GetObjectRequest
            r6.<init>(r0, r8)
        L_0x0072:
            com.alibaba.sdk.android.oss.OSS r8 = r5.oss     // Catch:{ ClientException -> 0x011f, ServiceException -> 0x00f9, IOException -> 0x00f4 }
            com.alibaba.sdk.android.oss.model.GetObjectResult r6 = r8.getObject(r6)     // Catch:{ ClientException -> 0x011f, ServiceException -> 0x00f9, IOException -> 0x00f4 }
            java.lang.String r8 = "Content-Length"
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ ClientException -> 0x011f, ServiceException -> 0x00f9, IOException -> 0x00f4 }
            r0.<init>()     // Catch:{ ClientException -> 0x011f, ServiceException -> 0x00f9, IOException -> 0x00f4 }
            java.lang.String r1 = ""
            r0.append(r1)     // Catch:{ ClientException -> 0x011f, ServiceException -> 0x00f9, IOException -> 0x00f4 }
            long r1 = r6.getContentLength()     // Catch:{ ClientException -> 0x011f, ServiceException -> 0x00f9, IOException -> 0x00f4 }
            r0.append(r1)     // Catch:{ ClientException -> 0x011f, ServiceException -> 0x00f9, IOException -> 0x00f4 }
            java.lang.String r0 = r0.toString()     // Catch:{ ClientException -> 0x011f, ServiceException -> 0x00f9, IOException -> 0x00f4 }
            android.util.Log.d(r8, r0)     // Catch:{ ClientException -> 0x011f, ServiceException -> 0x00f9, IOException -> 0x00f4 }
            java.io.InputStream r8 = r6.getObjectContent()     // Catch:{ ClientException -> 0x011f, ServiceException -> 0x00f9, IOException -> 0x00f4 }
            r0 = 2048(0x800, float:2.87E-42)
            byte[] r0 = new byte[r0]     // Catch:{ ClientException -> 0x011f, ServiceException -> 0x00f9, IOException -> 0x00f4 }
        L_0x009a:
            int r1 = r8.read(r0)     // Catch:{ ClientException -> 0x011f, ServiceException -> 0x00f9, IOException -> 0x00f4 }
            r2 = -1
            java.lang.String r3 = "asyncGetObjectSample"
            if (r1 == r2) goto L_0x00d2
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ ClientException -> 0x011f, ServiceException -> 0x00f9, IOException -> 0x00f4 }
            r2.<init>()     // Catch:{ ClientException -> 0x011f, ServiceException -> 0x00f9, IOException -> 0x00f4 }
            java.lang.String r4 = "read length: "
            r2.append(r4)     // Catch:{ ClientException -> 0x011f, ServiceException -> 0x00f9, IOException -> 0x00f4 }
            r2.append(r1)     // Catch:{ ClientException -> 0x011f, ServiceException -> 0x00f9, IOException -> 0x00f4 }
            java.lang.String r2 = r2.toString()     // Catch:{ ClientException -> 0x011f, ServiceException -> 0x00f9, IOException -> 0x00f4 }
            android.util.Log.d(r3, r2)     // Catch:{ ClientException -> 0x011f, ServiceException -> 0x00f9, IOException -> 0x00f4 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ ClientException -> 0x011f, ServiceException -> 0x00f9, IOException -> 0x00f4 }
            r2.<init>()     // Catch:{ ClientException -> 0x011f, ServiceException -> 0x00f9, IOException -> 0x00f4 }
            java.lang.String r3 = "len:"
            r2.append(r3)     // Catch:{ ClientException -> 0x011f, ServiceException -> 0x00f9, IOException -> 0x00f4 }
            r2.append(r1)     // Catch:{ ClientException -> 0x011f, ServiceException -> 0x00f9, IOException -> 0x00f4 }
            java.lang.String r2 = r2.toString()     // Catch:{ ClientException -> 0x011f, ServiceException -> 0x00f9, IOException -> 0x00f4 }
            com.shix.shixipc.utils.CommonUtil.Log(r7, r2)     // Catch:{ ClientException -> 0x011f, ServiceException -> 0x00f9, IOException -> 0x00f4 }
            java.io.FileOutputStream r2 = r5.testOS     // Catch:{ ClientException -> 0x011f, ServiceException -> 0x00f9, IOException -> 0x00f4 }
            r3 = 0
            r2.write(r0, r3, r1)     // Catch:{ ClientException -> 0x011f, ServiceException -> 0x00f9, IOException -> 0x00f4 }
            goto L_0x009a
        L_0x00d2:
            java.lang.String r7 = "download success."
            android.util.Log.d(r3, r7)     // Catch:{ ClientException -> 0x011f, ServiceException -> 0x00f9, IOException -> 0x00f4 }
            com.alibaba.sdk.android.oss.model.ObjectMetadata r6 = r6.getMetadata()     // Catch:{ ClientException -> 0x011f, ServiceException -> 0x00f9, IOException -> 0x00f4 }
            java.lang.String r7 = "ContentType"
            java.lang.String r6 = r6.getContentType()     // Catch:{ ClientException -> 0x011f, ServiceException -> 0x00f9, IOException -> 0x00f4 }
            android.util.Log.d(r7, r6)     // Catch:{ ClientException -> 0x011f, ServiceException -> 0x00f9, IOException -> 0x00f4 }
            java.io.FileOutputStream r6 = r5.testOS     // Catch:{ IOException -> 0x00ef, ClientException -> 0x011f, ServiceException -> 0x00f9 }
            r6.flush()     // Catch:{ IOException -> 0x00ef, ClientException -> 0x011f, ServiceException -> 0x00f9 }
            java.io.FileOutputStream r6 = r5.testOS     // Catch:{ IOException -> 0x00ef, ClientException -> 0x011f, ServiceException -> 0x00f9 }
            r6.close()     // Catch:{ IOException -> 0x00ef, ClientException -> 0x011f, ServiceException -> 0x00f9 }
            goto L_0x0123
        L_0x00ef:
            r6 = move-exception
            r6.printStackTrace()     // Catch:{ ClientException -> 0x011f, ServiceException -> 0x00f9, IOException -> 0x00f4 }
            goto L_0x0123
        L_0x00f4:
            r6 = move-exception
            r6.printStackTrace()
            goto L_0x0123
        L_0x00f9:
            r6 = move-exception
            java.lang.String r7 = r6.getRequestId()
            java.lang.String r8 = "RequestId"
            android.util.Log.e(r8, r7)
            java.lang.String r7 = r6.getErrorCode()
            java.lang.String r8 = "ErrorCode"
            android.util.Log.e(r8, r7)
            java.lang.String r7 = r6.getHostId()
            java.lang.String r8 = "HostId"
            android.util.Log.e(r8, r7)
            java.lang.String r6 = r6.getRawMessage()
            java.lang.String r7 = "RawMessage"
            android.util.Log.e(r7, r6)
            goto L_0x0123
        L_0x011f:
            r6 = move-exception
            r6.printStackTrace()
        L_0x0123:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shix.shixipc.activity.CloudLogActivity.getObjectSample(java.lang.String, java.lang.String, java.lang.String):void");
    }

    public void showPic(int i, String str, String str2, String str3, String str4, String str5, int i2) {
        this.pathTest = CommonUtil.getSDFilePath() + "/" + ContentCommon.SDCARD_PATH + "/cloud/" + this.did + str2;
        int i3 = i2 == 2 ? R.string.doorbell_fangke : i2 == 3 ? R.string.doorbell_alerm11 : R.string.doorbell_alerm;
        this.FileName111 = str2;
        this.CloudPath111 = str4;
        if (i2 != 1) {
            this.adapter.notifyDataSetChanged();
        }
        if (!new File(this.pathTest).exists()) {
            new AsyncTask<Void, Void, Void>() {
                /* access modifiers changed from: protected */
                public Void doInBackground(Void... voidArr) {
                    CloudLogActivity cloudLogActivity = CloudLogActivity.this;
                    cloudLogActivity.getObjectSample(cloudLogActivity.did, CloudLogActivity.this.FileName111, CloudLogActivity.this.CloudPath111);
                    return null;
                }

                /* access modifiers changed from: protected */
                public void onPostExecute(Void voidR) {
                    CommonUtil.Log(1, "--------pathTest:" + CloudLogActivity.this.pathTest);
                    try {
                        BitmapFactory.Options options = new BitmapFactory.Options();
                        options.inSampleSize = 1;
                        Bitmap decodeFile = BitmapFactory.decodeFile(CloudLogActivity.this.pathTest, options);
                        if (decodeFile != null) {
                            CloudLogActivity.this.imageView.setImageBitmap(decodeFile);
                            CloudLogActivity.this.adapter.notifyDataSetChanged();
                            return;
                        }
                        CloudLogActivity.this.imageView.setImageResource(R.mipmap.play_set_setting_picture_press);
                    } catch (Exception unused) {
                        CloudLogActivity.this.imageView.setImageResource(R.mipmap.play_set_setting_picture_press);
                    }
                }
            }.execute(new Void[0]);
        } else {
            try {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inSampleSize = 1;
                Bitmap decodeFile = BitmapFactory.decodeFile(this.pathTest, options);
                if (decodeFile != null) {
                    this.imageView.setImageBitmap(decodeFile);
                } else {
                    this.imageView.setImageResource(R.mipmap.play_set_setting_picture_press);
                }
            } catch (Exception unused) {
                this.imageView.setImageResource(R.mipmap.play_set_setting_picture_press);
            }
        }
        this.strTitle = getResources().getString(i3) + "  " + str3;
        TextView textView2 = this.textView;
        textView2.setText(getResources().getString(i3) + "  " + str3);
        this.buttonPlay.setVisibility(0);
        this.popupWindow_re.showAtLocation(this.btnBack, 17, 0, 0);
    }

    /* access modifiers changed from: private */
    public void takePicture() {
        new Thread() {
            public void run() {
                CloudLogActivity.this.savePicToSDcard();
            }
        }.start();
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00a3 A[SYNTHETIC, Splitter:B:38:0x00a3] */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00b9 A[SYNTHETIC, Splitter:B:47:0x00b9] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void savePicToSDcard() {
        /*
            r6 = this;
            monitor-enter(r6)
            r0 = 0
            java.lang.String r1 = "test"
            java.lang.String r2 = "savePicToSDcard1"
            android.util.Log.d(r1, r2)     // Catch:{ all -> 0x00ce }
            r1 = 111(0x6f, float:1.56E-43)
            java.io.File r2 = new java.io.File     // Catch:{ Exception -> 0x0096 }
            java.io.File r3 = com.shix.shixipc.utils.CommonUtil.getSDFilePath()     // Catch:{ Exception -> 0x0096 }
            java.lang.String r4 = "HDWiFiCam/picVisitor"
            r2.<init>(r3, r4)     // Catch:{ Exception -> 0x0096 }
            boolean r3 = r2.exists()     // Catch:{ Exception -> 0x0096 }
            if (r3 != 0) goto L_0x001f
            r2.mkdirs()     // Catch:{ Exception -> 0x0096 }
        L_0x001f:
            java.lang.String r2 = r6.dateTime     // Catch:{ Exception -> 0x0096 }
            java.lang.String r3 = " "
            java.lang.String r4 = "_"
            java.lang.String r2 = r2.replace(r3, r4)     // Catch:{ Exception -> 0x0096 }
            java.lang.String r3 = "-"
            java.lang.String r4 = "_"
            java.lang.String r2 = r2.replace(r3, r4)     // Catch:{ Exception -> 0x0096 }
            java.lang.String r3 = ":"
            java.lang.String r4 = "_"
            r2.replace(r3, r4)     // Catch:{ Exception -> 0x0096 }
            java.io.File r2 = new java.io.File     // Catch:{ Exception -> 0x0096 }
            java.lang.String r3 = r6.pathTest     // Catch:{ Exception -> 0x0096 }
            r2.<init>(r3)     // Catch:{ Exception -> 0x0096 }
            boolean r3 = r2.exists()     // Catch:{ Exception -> 0x0096 }
            if (r3 == 0) goto L_0x0047
            monitor-exit(r6)
            return
        L_0x0047:
            java.lang.String r3 = "test"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0096 }
            r4.<init>()     // Catch:{ Exception -> 0x0096 }
            java.lang.String r5 = "savePicToSDcard1---file:"
            r4.append(r5)     // Catch:{ Exception -> 0x0096 }
            java.lang.String r5 = r2.getAbsolutePath()     // Catch:{ Exception -> 0x0096 }
            r4.append(r5)     // Catch:{ Exception -> 0x0096 }
            java.lang.String r4 = r4.toString()     // Catch:{ Exception -> 0x0096 }
            android.util.Log.d(r3, r4)     // Catch:{ Exception -> 0x0096 }
            java.io.FileOutputStream r3 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x0096 }
            r3.<init>(r2)     // Catch:{ Exception -> 0x0096 }
            android.graphics.Bitmap r0 = r6.bmp     // Catch:{ Exception -> 0x0091, all -> 0x008e }
            if (r0 == 0) goto L_0x0079
            android.graphics.Bitmap r0 = r6.bmp     // Catch:{ Exception -> 0x0091, all -> 0x008e }
            android.graphics.Bitmap$CompressFormat r2 = android.graphics.Bitmap.CompressFormat.JPEG     // Catch:{ Exception -> 0x0091, all -> 0x008e }
            r4 = 60
            boolean r0 = r0.compress(r2, r4, r3)     // Catch:{ Exception -> 0x0091, all -> 0x008e }
            if (r0 == 0) goto L_0x0079
            r3.flush()     // Catch:{ Exception -> 0x0091, all -> 0x008e }
        L_0x0079:
            r3.close()     // Catch:{ IOException -> 0x007d }
            goto L_0x0081
        L_0x007d:
            r0 = move-exception
            r0.printStackTrace()     // Catch:{ all -> 0x00ce }
        L_0x0081:
            java.lang.String r0 = "test"
            java.lang.String r2 = "savePicToSDcard3"
            android.util.Log.d(r0, r2)     // Catch:{ all -> 0x00ce }
            android.os.Handler r0 = r6.BitMapHandler     // Catch:{ all -> 0x00ce }
        L_0x008a:
            r0.sendEmptyMessage(r1)     // Catch:{ all -> 0x00ce }
            goto L_0x00b5
        L_0x008e:
            r2 = move-exception
            r0 = r3
            goto L_0x00b7
        L_0x0091:
            r2 = move-exception
            r0 = r3
            goto L_0x0097
        L_0x0094:
            r2 = move-exception
            goto L_0x00b7
        L_0x0096:
            r2 = move-exception
        L_0x0097:
            r2.printStackTrace()     // Catch:{ all -> 0x0094 }
            java.lang.String r2 = "test"
            java.lang.String r3 = "savePicToSDcard2"
            android.util.Log.d(r2, r3)     // Catch:{ all -> 0x0094 }
            if (r0 == 0) goto L_0x00b5
            r0.close()     // Catch:{ IOException -> 0x00a7 }
            goto L_0x00ab
        L_0x00a7:
            r0 = move-exception
            r0.printStackTrace()     // Catch:{ all -> 0x00ce }
        L_0x00ab:
            java.lang.String r0 = "test"
            java.lang.String r2 = "savePicToSDcard3"
            android.util.Log.d(r0, r2)     // Catch:{ all -> 0x00ce }
            android.os.Handler r0 = r6.BitMapHandler     // Catch:{ all -> 0x00ce }
            goto L_0x008a
        L_0x00b5:
            monitor-exit(r6)
            return
        L_0x00b7:
            if (r0 == 0) goto L_0x00cd
            r0.close()     // Catch:{ IOException -> 0x00bd }
            goto L_0x00c1
        L_0x00bd:
            r0 = move-exception
            r0.printStackTrace()     // Catch:{ all -> 0x00ce }
        L_0x00c1:
            java.lang.String r0 = "test"
            java.lang.String r3 = "savePicToSDcard3"
            android.util.Log.d(r0, r3)     // Catch:{ all -> 0x00ce }
            android.os.Handler r0 = r6.BitMapHandler     // Catch:{ all -> 0x00ce }
            r0.sendEmptyMessage(r1)     // Catch:{ all -> 0x00ce }
        L_0x00cd:
            throw r2     // Catch:{ all -> 0x00ce }
        L_0x00ce:
            r0 = move-exception
            monitor-exit(r6)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shix.shixipc.activity.CloudLogActivity.savePicToSDcard():void");
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
    }

    public void initExitPopupWindow_re() {
        this.popv_re = LayoutInflater.from(this).inflate(R.layout.popup_cloud, (ViewGroup) null);
        this.textView = (TextView) this.popv_re.findViewById(R.id.textView);
        this.textView_name = (TextView) this.popv_re.findViewById(R.id.textView_name);
        this.imageView = (ImageView) this.popv_re.findViewById(R.id.imageView);
        this.framelayout = (FrameLayout) this.popv_re.findViewById(R.id.framelayout);
        this.buttonPlay = (Button) this.popv_re.findViewById(R.id.buttonPlay);
        this.popupWindow_re = new PopupWindow(this.popv_re, -1, -1);
        this.popupWindow_re.setAnimationStyle(R.style.AnimationPreview);
        this.popupWindow_re.setFocusable(true);
        this.popupWindow_re.setOutsideTouchable(true);
        this.popupWindow_re.setBackgroundDrawable(new ColorDrawable(0));
        ((Button) this.popv_re.findViewById(R.id.cancel)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                CloudLogActivity.this.popupWindow_re.dismiss();
            }
        });
        this.popv_re.findViewById(R.id.share).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (CloudLogActivity.this.pathTest != null) {
                    CloudLogActivity cloudLogActivity = CloudLogActivity.this;
                    cloudLogActivity.shareImage(cloudLogActivity.pathTest);
                }
            }
        });
        this.buttonPlay.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                String str;
                String replace = CloudLogActivity.this.CloudPath111.replace("photos", "records");
                if (replace.indexOf(".png") > 0) {
                    str = replace.replace(".png", ".mj");
                } else {
                    str = replace.replace(".jpg", ".mj");
                }
                String unused = CloudLogActivity.this.downloadPath = str;
                CloudLogActivity cloudLogActivity = CloudLogActivity.this;
                cloudLogActivity.DownLoadCount = 0;
                new MyAsyncTask().execute(new String[]{str});
            }
        });
        this.popupWindow_re.setOnDismissListener(new PopupWindow.OnDismissListener() {
            public void onDismiss() {
                CloudLogActivity.this.popupWindow_re.dismiss();
            }
        });
        this.popupWindow_re.setTouchInterceptor(new View.OnTouchListener() {
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() != 4) {
                    return false;
                }
                CloudLogActivity.this.popupWindow_re.dismiss();
                return false;
            }
        });
    }

    public void shareImage(String str) {
        try {
            Intent intent = new Intent("android.intent.action.SEND");
            intent.setType("image/*");
            Uri savePicToSDcard = savePicToSDcard(BitmapFactory.decodeFile(str));
            if (Build.VERSION.SDK_INT > 23) {
                intent.setFlags(1);
            }
            intent.putExtra("android.intent.extra.STREAM", savePicToSDcard);
            startActivity(Intent.createChooser(intent, getResources().getString(R.string.send_title)));
        } catch (Exception unused) {
        }
    }

    public void ShowDel(int i, String str, String str2, String str3) {
        if (ContentCommon.ISVISI.booleanValue()) {
            CommonUtil.Vibrate(this, 10);
        }
        this.delPosition = i;
        this.delStrDid = str;
        this.delCloudPath = str2;
        showDeleteDialog(str3, str3);
    }

    private void showDeleteDialog(String str, String str2) {
        final NiftyDialogBuilder instance = NiftyDialogBuilder.getInstance(this);
        instance.withTitle(str2).withMessage((CharSequence) getString(R.string.del_sucess_title)).withEffect(Effectstype.Slidetop).setButton1Click(new View.OnClickListener() {
            public void onClick(View view) {
                instance.dismiss();
            }
        }).setButton2Click(new View.OnClickListener() {
            public void onClick(View view) {
                instance.dismiss();
                if (CloudLogActivity.this.isDelAll) {
                    CloudLogActivity.this.delAllObject();
                    boolean unused = CloudLogActivity.this.isDelAll = false;
                    return;
                }
                CloudLogActivity.this.delObject();
            }
        }).show();
    }

    public void delObject() {
        DeleteObjectRequest deleteObjectRequest;
        new DeleteObjectRequest(ContentCommon.CLOUDBUCKET, this.delCloudPath);
        String str = this.did;
        if (str == null || !str.startsWith(ContentCommon.SHIX_APPRE)) {
            deleteObjectRequest = new DeleteObjectRequest(ContentCommon.CLOUDBUCKET, this.delCloudPath);
        } else {
            deleteObjectRequest = new DeleteObjectRequest(ContentCommon.CLOUDBUCKETHQ, this.delCloudPath);
        }
        this.oss.asyncDeleteObject(deleteObjectRequest, new OSSCompletedCallback<DeleteObjectRequest, DeleteObjectResult>() {
            public void onSuccess(DeleteObjectRequest deleteObjectRequest, DeleteObjectResult deleteObjectResult) {
                Log.d("asyncCopyAndDelObject", "success!:" + CloudLogActivity.this.delCloudPath);
                CloudLogActivity.this.mHandler.sendEmptyMessage(3);
            }

            public void onFailure(DeleteObjectRequest deleteObjectRequest, ClientException clientException, ServiceException serviceException) {
                if (clientException != null) {
                    clientException.printStackTrace();
                }
                if (serviceException != null) {
                    Log.e("ErrorCode", serviceException.getErrorCode());
                    Log.e("RequestId", serviceException.getRequestId());
                    Log.e("HostId", serviceException.getHostId());
                    Log.e("RawMessage", serviceException.getRawMessage());
                }
            }
        });
    }

    public void delAllObject() {
        DeleteObjectRequest deleteObjectRequest;
        new DeleteObjectRequest(ContentCommon.CLOUDBUCKET, this.did + "/dates/" + this.strdata);
        String str = this.did;
        if (str == null || !str.startsWith(ContentCommon.SHIX_APPRE)) {
            deleteObjectRequest = new DeleteObjectRequest(ContentCommon.CLOUDBUCKET, this.did + "/dates/" + this.strdata);
        } else {
            deleteObjectRequest = new DeleteObjectRequest(ContentCommon.CLOUDBUCKETHQ, this.did + "/dates/" + this.strdata);
        }
        this.oss.asyncDeleteObject(deleteObjectRequest, new OSSCompletedCallback<DeleteObjectRequest, DeleteObjectResult>() {
            public void onSuccess(DeleteObjectRequest deleteObjectRequest, DeleteObjectResult deleteObjectResult) {
                Log.d("asyncCopyAndDelObject", "success!:::" + CloudLogActivity.this.did + "/photos/" + CloudLogActivity.this.strdata + "/");
                CloudLogActivity.this.mHandler.sendEmptyMessage(4);
            }

            public void onFailure(DeleteObjectRequest deleteObjectRequest, ClientException clientException, ServiceException serviceException) {
                if (clientException != null) {
                    clientException.printStackTrace();
                }
                if (serviceException != null) {
                    Log.e("ErrorCode", serviceException.getErrorCode());
                    Log.e("RequestId", serviceException.getRequestId());
                    Log.e("HostId", serviceException.getHostId());
                    Log.e("RawMessage", serviceException.getRawMessage());
                }
            }
        });
    }

    private String getFilePathByContentResolver(Context context, Uri uri) {
        String str = null;
        if (uri == null) {
            return null;
        }
        Cursor query = context.getContentResolver().query(uri, (String[]) null, (String) null, (String[]) null, (String) null);
        if (query != null) {
            try {
                if (query.getCount() == 1) {
                    if (query.moveToFirst()) {
                        str = query.getString(query.getColumnIndexOrThrow("_data"));
                    }
                }
                return str;
            } finally {
                query.close();
            }
        } else {
            throw new IllegalArgumentException("Query on " + uri + " returns null result.");
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v0, resolved type: java.io.FileOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v3, resolved type: android.net.Uri} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: java.io.FileOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v4, resolved type: android.net.Uri} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v6, resolved type: android.net.Uri} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: java.io.FileOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v10, resolved type: android.net.Uri} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: java.io.FileOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v11, resolved type: android.net.Uri} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v5, resolved type: android.net.Uri} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v6, resolved type: java.io.FileOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v7, resolved type: java.io.FileOutputStream} */
    /* JADX WARNING: type inference failed for: r1v4, types: [android.net.Uri] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00ce A[SYNTHETIC, Splitter:B:37:0x00ce] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00da A[SYNTHETIC, Splitter:B:45:0x00da] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized android.net.Uri savePicToSDcard(android.graphics.Bitmap r7) {
        /*
            r6 = this;
            monitor-enter(r6)
            java.lang.String r0 = r6.getStrDate()     // Catch:{ all -> 0x00e3 }
            r1 = 0
            java.io.File r2 = new java.io.File     // Catch:{ Exception -> 0x00c7 }
            java.io.File r3 = com.shix.shixipc.utils.CommonUtil.getSDFilePath()     // Catch:{ Exception -> 0x00c7 }
            java.lang.String r4 = "LDDDD/pic"
            r2.<init>(r3, r4)     // Catch:{ Exception -> 0x00c7 }
            boolean r3 = r2.exists()     // Catch:{ Exception -> 0x00c7 }
            if (r3 != 0) goto L_0x001a
            r2.mkdirs()     // Catch:{ Exception -> 0x00c7 }
        L_0x001a:
            java.io.File r3 = new java.io.File     // Catch:{ Exception -> 0x00c7 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00c7 }
            r4.<init>()     // Catch:{ Exception -> 0x00c7 }
            r4.append(r0)     // Catch:{ Exception -> 0x00c7 }
            java.lang.String r0 = ".jpg"
            r4.append(r0)     // Catch:{ Exception -> 0x00c7 }
            java.lang.String r0 = r4.toString()     // Catch:{ Exception -> 0x00c7 }
            r3.<init>(r2, r0)     // Catch:{ Exception -> 0x00c7 }
            java.io.FileOutputStream r0 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x00c7 }
            r0.<init>(r3)     // Catch:{ Exception -> 0x00c7 }
            android.graphics.Bitmap$CompressFormat r2 = android.graphics.Bitmap.CompressFormat.JPEG     // Catch:{ Exception -> 0x00bf, all -> 0x00bd }
            r4 = 70
            boolean r2 = r7.compress(r2, r4, r0)     // Catch:{ Exception -> 0x00bf, all -> 0x00bd }
            if (r2 == 0) goto L_0x0042
            r0.flush()     // Catch:{ Exception -> 0x00bf, all -> 0x00bd }
        L_0x0042:
            java.lang.String r2 = r3.getPath()     // Catch:{ Exception -> 0x00bf, all -> 0x00bd }
            int r3 = android.os.Build.VERSION.SDK_INT     // Catch:{ Exception -> 0x00bf, all -> 0x00bd }
            r4 = 23
            if (r3 > r4) goto L_0x0095
            android.content.ContentResolver r2 = r6.getContentResolver()     // Catch:{ Exception -> 0x00bf, all -> 0x00bd }
            java.lang.String r3 = ""
            java.lang.String r4 = ""
            java.lang.String r7 = android.provider.MediaStore.Images.Media.insertImage(r2, r7, r3, r4)     // Catch:{ Exception -> 0x00bf, all -> 0x00bd }
            java.lang.String r2 = "test"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00bf, all -> 0x00bd }
            r3.<init>()     // Catch:{ Exception -> 0x00bf, all -> 0x00bd }
            java.lang.String r4 = "zhaogenghuai savepath:"
            r3.append(r4)     // Catch:{ Exception -> 0x00bf, all -> 0x00bd }
            r3.append(r7)     // Catch:{ Exception -> 0x00bf, all -> 0x00bd }
            java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x00bf, all -> 0x00bd }
            android.util.Log.d(r2, r3)     // Catch:{ Exception -> 0x00bf, all -> 0x00bd }
            if (r7 == 0) goto L_0x00b3
            int r2 = r7.length()     // Catch:{ Exception -> 0x00bf, all -> 0x00bd }
            if (r2 <= 0) goto L_0x00b3
            android.content.Intent r2 = new android.content.Intent     // Catch:{ Exception -> 0x00bf, all -> 0x00bd }
            java.lang.String r3 = "android.intent.action.MEDIA_SCANNER_SCAN_FILE"
            r2.<init>(r3)     // Catch:{ Exception -> 0x00bf, all -> 0x00bd }
            java.io.File r3 = new java.io.File     // Catch:{ Exception -> 0x00bf, all -> 0x00bd }
            android.net.Uri r7 = android.net.Uri.parse(r7)     // Catch:{ Exception -> 0x00bf, all -> 0x00bd }
            java.lang.String r7 = r6.getFilePathByContentResolver(r6, r7)     // Catch:{ Exception -> 0x00bf, all -> 0x00bd }
            r3.<init>(r7)     // Catch:{ Exception -> 0x00bf, all -> 0x00bd }
            android.net.Uri r1 = android.net.Uri.fromFile(r3)     // Catch:{ Exception -> 0x00bf, all -> 0x00bd }
            r2.setData(r1)     // Catch:{ Exception -> 0x00bf, all -> 0x00bd }
            r6.sendBroadcast(r2)     // Catch:{ Exception -> 0x00bf, all -> 0x00bd }
            goto L_0x00b3
        L_0x0095:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00bf, all -> 0x00bd }
            r7.<init>()     // Catch:{ Exception -> 0x00bf, all -> 0x00bd }
            java.lang.String r3 = r6.getPackageName()     // Catch:{ Exception -> 0x00bf, all -> 0x00bd }
            r7.append(r3)     // Catch:{ Exception -> 0x00bf, all -> 0x00bd }
            java.lang.String r3 = ".fileProvider"
            r7.append(r3)     // Catch:{ Exception -> 0x00bf, all -> 0x00bd }
            java.lang.String r7 = r7.toString()     // Catch:{ Exception -> 0x00bf, all -> 0x00bd }
            java.io.File r3 = new java.io.File     // Catch:{ Exception -> 0x00bf, all -> 0x00bd }
            r3.<init>(r2)     // Catch:{ Exception -> 0x00bf, all -> 0x00bd }
            android.net.Uri r1 = androidx.core.content.FileProvider.getUriForFile(r6, r7, r3)     // Catch:{ Exception -> 0x00bf, all -> 0x00bd }
        L_0x00b3:
            r0.close()     // Catch:{ IOException -> 0x00b7 }
            goto L_0x00bb
        L_0x00b7:
            r7 = move-exception
            r7.printStackTrace()     // Catch:{ all -> 0x00e3 }
        L_0x00bb:
            r0 = r1
            goto L_0x00d6
        L_0x00bd:
            r7 = move-exception
            goto L_0x00d8
        L_0x00bf:
            r7 = move-exception
            r5 = r1
            r1 = r0
            r0 = r5
            goto L_0x00c9
        L_0x00c4:
            r7 = move-exception
            r0 = r1
            goto L_0x00d8
        L_0x00c7:
            r7 = move-exception
            r0 = r1
        L_0x00c9:
            r7.printStackTrace()     // Catch:{ all -> 0x00c4 }
            if (r1 == 0) goto L_0x00d6
            r1.close()     // Catch:{ IOException -> 0x00d2 }
            goto L_0x00d6
        L_0x00d2:
            r7 = move-exception
            r7.printStackTrace()     // Catch:{ all -> 0x00e3 }
        L_0x00d6:
            monitor-exit(r6)
            return r0
        L_0x00d8:
            if (r0 == 0) goto L_0x00e2
            r0.close()     // Catch:{ IOException -> 0x00de }
            goto L_0x00e2
        L_0x00de:
            r0 = move-exception
            r0.printStackTrace()     // Catch:{ all -> 0x00e3 }
        L_0x00e2:
            throw r7     // Catch:{ all -> 0x00e3 }
        L_0x00e3:
            r7 = move-exception
            monitor-exit(r6)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shix.shixipc.activity.CloudLogActivity.savePicToSDcard(android.graphics.Bitmap):android.net.Uri");
    }

    private String getStrDate() {
        return new SimpleDateFormat("yyyy-MM-dd_HH_mm").format(new Date());
    }

    private void getDataFromOther() {
        Intent intent = getIntent();
        this.did = intent.getStringExtra(ContentCommon.STR_CAMERA_ID);
        this.camName = intent.getStringExtra(ContentCommon.STR_CAMERA_NAME);
        this.play_tag_log = intent.getIntExtra("play_tag_log", 0);
        initData();
    }

    private void initData() {
        this.adapter.clearAllAlarmLog();
    }

    private void setListener() {
        this.btnBack.setOnClickListener(this);
    }

    private void findView() {
        this.btnBack = (Button) findViewById(R.id.back);
        this.listView = (ListView) findViewById(R.id.listView1);
        this.tvNoLog = (TextView) findViewById(R.id.no_log);
        findViewById(R.id.cloud_remove).setOnClickListener(this);
        this.tv_camera_setting = (TextView) findViewById(R.id.tv_camera_setting);
    }

    /* access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        getDataFromOther();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        this.adapter = null;
        ((NotificationManager) getSystemService("notification")).cancel(110);
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.back) {
            finish();
        } else if (id == R.id.cloud_remove) {
            this.isDelAll = true;
            String str = this.strdata;
            showDeleteDialog(str, str);
        }
    }

    class MyAsyncTask extends AsyncTask<String, Integer, String> {
        private long allLen = 1;
        private long downLen = 0;

        MyAsyncTask() {
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            super.onPreExecute();
            this.downLen = 0;
            this.allLen = 1;
            CloudLogActivity.this.buttonPlay.setVisibility(8);
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: Code restructure failed: missing block: B:31:0x0181, code lost:
            r12 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:33:?, code lost:
            r12.printStackTrace();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:37:0x018b, code lost:
            r12 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:38:0x018c, code lost:
            android.util.Log.e("RequestId", r12.getRequestId());
            android.util.Log.e("ErrorCode", r12.getErrorCode());
            android.util.Log.e("HostId", r12.getHostId());
            android.util.Log.e("RawMessage", r12.getRawMessage());
         */
        /* JADX WARNING: Code restructure failed: missing block: B:39:0x01b0, code lost:
            return null;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:40:0x01b1, code lost:
            r12 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:41:0x01b2, code lost:
            r12.printStackTrace();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:42:0x01b5, code lost:
            return null;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Removed duplicated region for block: B:37:0x018b A[ExcHandler: ServiceException (r12v3 'e' com.alibaba.sdk.android.oss.ServiceException A[CUSTOM_DECLARE]), Splitter:B:21:0x00b1] */
        /* JADX WARNING: Removed duplicated region for block: B:40:0x01b1 A[ExcHandler: ClientException (r12v2 'e' com.alibaba.sdk.android.oss.ClientException A[CUSTOM_DECLARE]), Splitter:B:21:0x00b1] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.String doInBackground(java.lang.String... r12) {
            /*
                r11 = this;
                r0 = 0
                r12 = r12[r0]
                java.io.File r1 = new java.io.File
                java.io.File r2 = com.shix.shixipc.utils.CommonUtil.getSDFilePath()
                java.lang.String r3 = "HDWiFiCam/cloud"
                r1.<init>(r2, r3)
                boolean r2 = r1.exists()
                if (r2 != 0) goto L_0x0017
                r1.mkdirs()
            L_0x0017:
                java.lang.String r2 = "/"
                int r2 = r12.lastIndexOf(r2)
                r3 = 1
                int r2 = r2 + r3
                java.lang.String r2 = r12.substring(r2)
                int r4 = r2.length()
                r5 = 21
                r6 = 0
                if (r4 >= r5) goto L_0x002d
                return r6
            L_0x002d:
                java.io.File r4 = new java.io.File
                java.lang.StringBuilder r5 = new java.lang.StringBuilder
                r5.<init>()
                com.shix.shixipc.activity.CloudLogActivity r7 = com.shix.shixipc.activity.CloudLogActivity.this
                java.lang.String r7 = r7.did
                r5.append(r7)
                r5.append(r2)
                java.lang.String r2 = r5.toString()
                r4.<init>(r1, r2)
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r2 = "getObjectSample path:"
                r1.append(r2)
                java.lang.String r2 = r4.getAbsolutePath()
                r1.append(r2)
                java.lang.String r1 = r1.toString()
                com.shix.shixipc.utils.CommonUtil.Log(r3, r1)
                java.lang.String r1 = r4.getAbsolutePath()
                boolean r2 = r4.exists()
                if (r2 == 0) goto L_0x0074
                long r7 = r4.length()
                r9 = 1000(0x3e8, double:4.94E-321)
                int r2 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
                if (r2 <= 0) goto L_0x0074
                return r1
            L_0x0074:
                com.shix.shixipc.activity.CloudLogActivity r2 = com.shix.shixipc.activity.CloudLogActivity.this     // Catch:{ FileNotFoundException -> 0x007e }
                java.io.FileOutputStream r5 = new java.io.FileOutputStream     // Catch:{ FileNotFoundException -> 0x007e }
                r5.<init>(r4)     // Catch:{ FileNotFoundException -> 0x007e }
                r2.testOS = r5     // Catch:{ FileNotFoundException -> 0x007e }
                goto L_0x0082
            L_0x007e:
                r2 = move-exception
                r2.printStackTrace()
            L_0x0082:
                java.lang.String r2 = "testDown1"
                com.shix.shixipc.utils.CommonUtil.Log(r3, r2)
                com.alibaba.sdk.android.oss.model.GetObjectRequest r2 = new com.alibaba.sdk.android.oss.model.GetObjectRequest
                java.lang.String r4 = "shixdev"
                r2.<init>(r4, r12)
                com.shix.shixipc.activity.CloudLogActivity r2 = com.shix.shixipc.activity.CloudLogActivity.this
                java.lang.String r2 = r2.did
                if (r2 == 0) goto L_0x00ac
                com.shix.shixipc.activity.CloudLogActivity r2 = com.shix.shixipc.activity.CloudLogActivity.this
                java.lang.String r2 = r2.did
                java.lang.String r5 = "DGK"
                boolean r2 = r2.startsWith(r5)
                if (r2 == 0) goto L_0x00ac
                com.alibaba.sdk.android.oss.model.GetObjectRequest r2 = new com.alibaba.sdk.android.oss.model.GetObjectRequest
                java.lang.String r4 = "hdwificam"
                r2.<init>(r4, r12)
                goto L_0x00b1
            L_0x00ac:
                com.alibaba.sdk.android.oss.model.GetObjectRequest r2 = new com.alibaba.sdk.android.oss.model.GetObjectRequest
                r2.<init>(r4, r12)
            L_0x00b1:
                com.shix.shixipc.activity.CloudLogActivity r12 = com.shix.shixipc.activity.CloudLogActivity.this     // Catch:{ ClientException -> 0x01b1, ServiceException -> 0x018b, IOException -> 0x0186 }
                com.alibaba.sdk.android.oss.OSS r12 = r12.oss     // Catch:{ ClientException -> 0x01b1, ServiceException -> 0x018b, IOException -> 0x0186 }
                com.alibaba.sdk.android.oss.model.GetObjectResult r12 = r12.getObject(r2)     // Catch:{ ClientException -> 0x01b1, ServiceException -> 0x018b, IOException -> 0x0186 }
                long r4 = r12.getContentLength()     // Catch:{ ClientException -> 0x01b1, ServiceException -> 0x018b, IOException -> 0x0186 }
                r11.allLen = r4     // Catch:{ ClientException -> 0x01b1, ServiceException -> 0x018b, IOException -> 0x0186 }
                java.lang.String r2 = "Content-Length"
                java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ ClientException -> 0x01b1, ServiceException -> 0x018b, IOException -> 0x0186 }
                r4.<init>()     // Catch:{ ClientException -> 0x01b1, ServiceException -> 0x018b, IOException -> 0x0186 }
                java.lang.String r5 = "allLen:"
                r4.append(r5)     // Catch:{ ClientException -> 0x01b1, ServiceException -> 0x018b, IOException -> 0x0186 }
                long r7 = r11.allLen     // Catch:{ ClientException -> 0x01b1, ServiceException -> 0x018b, IOException -> 0x0186 }
                r4.append(r7)     // Catch:{ ClientException -> 0x01b1, ServiceException -> 0x018b, IOException -> 0x0186 }
                java.lang.String r4 = r4.toString()     // Catch:{ ClientException -> 0x01b1, ServiceException -> 0x018b, IOException -> 0x0186 }
                android.util.Log.d(r2, r4)     // Catch:{ ClientException -> 0x01b1, ServiceException -> 0x018b, IOException -> 0x0186 }
                java.io.InputStream r2 = r12.getObjectContent()     // Catch:{ ClientException -> 0x01b1, ServiceException -> 0x018b, IOException -> 0x0186 }
                r4 = 2048(0x800, float:2.87E-42)
                byte[] r4 = new byte[r4]     // Catch:{ ClientException -> 0x01b1, ServiceException -> 0x018b, IOException -> 0x0186 }
            L_0x00e1:
                int r5 = r2.read(r4)     // Catch:{ ClientException -> 0x01b1, ServiceException -> 0x018b, IOException -> 0x0186 }
                r7 = -1
                java.lang.String r8 = "asyncGetObjectSample"
                if (r5 == r7) goto L_0x0160
                java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ ClientException -> 0x01b1, ServiceException -> 0x018b, IOException -> 0x0186 }
                r7.<init>()     // Catch:{ ClientException -> 0x01b1, ServiceException -> 0x018b, IOException -> 0x0186 }
                java.lang.String r9 = "read length: "
                r7.append(r9)     // Catch:{ ClientException -> 0x01b1, ServiceException -> 0x018b, IOException -> 0x0186 }
                r7.append(r5)     // Catch:{ ClientException -> 0x01b1, ServiceException -> 0x018b, IOException -> 0x0186 }
                java.lang.String r7 = r7.toString()     // Catch:{ ClientException -> 0x01b1, ServiceException -> 0x018b, IOException -> 0x0186 }
                android.util.Log.d(r8, r7)     // Catch:{ ClientException -> 0x01b1, ServiceException -> 0x018b, IOException -> 0x0186 }
                java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ ClientException -> 0x01b1, ServiceException -> 0x018b, IOException -> 0x0186 }
                r7.<init>()     // Catch:{ ClientException -> 0x01b1, ServiceException -> 0x018b, IOException -> 0x0186 }
                java.lang.String r8 = "len:"
                r7.append(r8)     // Catch:{ ClientException -> 0x01b1, ServiceException -> 0x018b, IOException -> 0x0186 }
                r7.append(r5)     // Catch:{ ClientException -> 0x01b1, ServiceException -> 0x018b, IOException -> 0x0186 }
                java.lang.String r7 = r7.toString()     // Catch:{ ClientException -> 0x01b1, ServiceException -> 0x018b, IOException -> 0x0186 }
                com.shix.shixipc.utils.CommonUtil.Log(r3, r7)     // Catch:{ ClientException -> 0x01b1, ServiceException -> 0x018b, IOException -> 0x0186 }
                com.shix.shixipc.activity.CloudLogActivity r7 = com.shix.shixipc.activity.CloudLogActivity.this     // Catch:{ ClientException -> 0x01b1, ServiceException -> 0x018b, IOException -> 0x0186 }
                java.io.FileOutputStream r7 = r7.testOS     // Catch:{ ClientException -> 0x01b1, ServiceException -> 0x018b, IOException -> 0x0186 }
                r7.write(r4, r0, r5)     // Catch:{ ClientException -> 0x01b1, ServiceException -> 0x018b, IOException -> 0x0186 }
                long r7 = r11.downLen     // Catch:{ ClientException -> 0x01b1, ServiceException -> 0x018b, IOException -> 0x0186 }
                long r9 = (long) r5     // Catch:{ ClientException -> 0x01b1, ServiceException -> 0x018b, IOException -> 0x0186 }
                long r7 = r7 + r9
                r11.downLen = r7     // Catch:{ ClientException -> 0x01b1, ServiceException -> 0x018b, IOException -> 0x0186 }
                long r7 = r11.downLen     // Catch:{ ClientException -> 0x01b1, ServiceException -> 0x018b, IOException -> 0x0186 }
                float r5 = (float) r7     // Catch:{ ClientException -> 0x01b1, ServiceException -> 0x018b, IOException -> 0x0186 }
                long r7 = r11.allLen     // Catch:{ ClientException -> 0x01b1, ServiceException -> 0x018b, IOException -> 0x0186 }
                float r7 = (float) r7     // Catch:{ ClientException -> 0x01b1, ServiceException -> 0x018b, IOException -> 0x0186 }
                float r5 = r5 / r7
                java.lang.String r7 = "test"
                java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ ClientException -> 0x01b1, ServiceException -> 0x018b, IOException -> 0x0186 }
                r8.<init>()     // Catch:{ ClientException -> 0x01b1, ServiceException -> 0x018b, IOException -> 0x0186 }
                java.lang.String r9 = "process:"
                r8.append(r9)     // Catch:{ ClientException -> 0x01b1, ServiceException -> 0x018b, IOException -> 0x0186 }
                r8.append(r5)     // Catch:{ ClientException -> 0x01b1, ServiceException -> 0x018b, IOException -> 0x0186 }
                java.lang.String r9 = " downLen:"
                r8.append(r9)     // Catch:{ ClientException -> 0x01b1, ServiceException -> 0x018b, IOException -> 0x0186 }
                long r9 = r11.downLen     // Catch:{ ClientException -> 0x01b1, ServiceException -> 0x018b, IOException -> 0x0186 }
                r8.append(r9)     // Catch:{ ClientException -> 0x01b1, ServiceException -> 0x018b, IOException -> 0x0186 }
                java.lang.String r9 = "  allLen:"
                r8.append(r9)     // Catch:{ ClientException -> 0x01b1, ServiceException -> 0x018b, IOException -> 0x0186 }
                long r9 = r11.allLen     // Catch:{ ClientException -> 0x01b1, ServiceException -> 0x018b, IOException -> 0x0186 }
                r8.append(r9)     // Catch:{ ClientException -> 0x01b1, ServiceException -> 0x018b, IOException -> 0x0186 }
                java.lang.String r8 = r8.toString()     // Catch:{ ClientException -> 0x01b1, ServiceException -> 0x018b, IOException -> 0x0186 }
                android.util.Log.d(r7, r8)     // Catch:{ ClientException -> 0x01b1, ServiceException -> 0x018b, IOException -> 0x0186 }
                java.lang.Integer[] r7 = new java.lang.Integer[r3]     // Catch:{ ClientException -> 0x01b1, ServiceException -> 0x018b, IOException -> 0x0186 }
                r8 = 1120403456(0x42c80000, float:100.0)
                float r5 = r5 * r8
                int r5 = (int) r5     // Catch:{ ClientException -> 0x01b1, ServiceException -> 0x018b, IOException -> 0x0186 }
                java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ ClientException -> 0x01b1, ServiceException -> 0x018b, IOException -> 0x0186 }
                r7[r0] = r5     // Catch:{ ClientException -> 0x01b1, ServiceException -> 0x018b, IOException -> 0x0186 }
                r11.publishProgress(r7)     // Catch:{ ClientException -> 0x01b1, ServiceException -> 0x018b, IOException -> 0x0186 }
                goto L_0x00e1
            L_0x0160:
                java.lang.String r0 = "download success."
                android.util.Log.d(r8, r0)     // Catch:{ ClientException -> 0x01b1, ServiceException -> 0x018b, IOException -> 0x0186 }
                com.alibaba.sdk.android.oss.model.ObjectMetadata r12 = r12.getMetadata()     // Catch:{ ClientException -> 0x01b1, ServiceException -> 0x018b, IOException -> 0x0186 }
                java.lang.String r0 = "ContentType"
                java.lang.String r12 = r12.getContentType()     // Catch:{ ClientException -> 0x01b1, ServiceException -> 0x018b, IOException -> 0x0186 }
                android.util.Log.d(r0, r12)     // Catch:{ ClientException -> 0x01b1, ServiceException -> 0x018b, IOException -> 0x0186 }
                com.shix.shixipc.activity.CloudLogActivity r12 = com.shix.shixipc.activity.CloudLogActivity.this     // Catch:{ IOException -> 0x0181, ClientException -> 0x01b1, ServiceException -> 0x018b }
                java.io.FileOutputStream r12 = r12.testOS     // Catch:{ IOException -> 0x0181, ClientException -> 0x01b1, ServiceException -> 0x018b }
                r12.flush()     // Catch:{ IOException -> 0x0181, ClientException -> 0x01b1, ServiceException -> 0x018b }
                com.shix.shixipc.activity.CloudLogActivity r12 = com.shix.shixipc.activity.CloudLogActivity.this     // Catch:{ IOException -> 0x0181, ClientException -> 0x01b1, ServiceException -> 0x018b }
                java.io.FileOutputStream r12 = r12.testOS     // Catch:{ IOException -> 0x0181, ClientException -> 0x01b1, ServiceException -> 0x018b }
                r12.close()     // Catch:{ IOException -> 0x0181, ClientException -> 0x01b1, ServiceException -> 0x018b }
                goto L_0x018a
            L_0x0181:
                r12 = move-exception
                r12.printStackTrace()     // Catch:{ ClientException -> 0x01b1, ServiceException -> 0x018b, IOException -> 0x0186 }
                goto L_0x018a
            L_0x0186:
                r12 = move-exception
                r12.printStackTrace()
            L_0x018a:
                return r1
            L_0x018b:
                r12 = move-exception
                java.lang.String r0 = r12.getRequestId()
                java.lang.String r1 = "RequestId"
                android.util.Log.e(r1, r0)
                java.lang.String r0 = r12.getErrorCode()
                java.lang.String r1 = "ErrorCode"
                android.util.Log.e(r1, r0)
                java.lang.String r0 = r12.getHostId()
                java.lang.String r1 = "HostId"
                android.util.Log.e(r1, r0)
                java.lang.String r12 = r12.getRawMessage()
                java.lang.String r0 = "RawMessage"
                android.util.Log.e(r0, r12)
                return r6
            L_0x01b1:
                r12 = move-exception
                r12.printStackTrace()
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: com.shix.shixipc.activity.CloudLogActivity.MyAsyncTask.doInBackground(java.lang.String[]):java.lang.String");
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(String str) {
            Uri uri;
            super.onPostExecute(str);
            Log.d(ContentCommon.SERVER_STRING, "onPostExecute path:" + str);
            if (str == null || str.length() <= 5) {
                if (CloudLogActivity.this.downloadPath.indexOf(".mj") <= 0 || CloudLogActivity.this.DownLoadCount != 0) {
                    CloudLogActivity.this.showToast("No video");
                    return;
                }
                String replace = CloudLogActivity.this.CloudPath111.replace("photos", "records").replace(".jpg", ".avi");
                CloudLogActivity cloudLogActivity = CloudLogActivity.this;
                cloudLogActivity.DownLoadCount = 1;
                new MyAsyncTask().execute(new String[]{replace});
            } else if (str.indexOf(".mj") > 0) {
                CloudLogActivity.this.buttonPlay.setVisibility(0);
                Intent intent = new Intent(CloudLogActivity.this, CloudVideoMjActivity.class);
                intent.putExtra("filepath", str);
                intent.putExtra(ContentCommon.STR_CAMERA_NAME, CloudLogActivity.this.strTitle);
                CloudLogActivity.this.startActivity(intent);
                CloudLogActivity.this.overridePendingTransition(R.anim.in_from_right, R.anim.out_to_left);
            } else {
                Intent intent2 = new Intent("android.intent.action.VIEW");
                File file = new File(str);
                Log.d(ContentCommon.SERVER_STRING, "FILEpath:" + str);
                if (file.exists() && str.indexOf("avi") > 0) {
                    if (Build.VERSION.SDK_INT >= 24) {
                        CloudLogActivity cloudLogActivity2 = CloudLogActivity.this;
                        uri = FileProvider.getUriForFile(cloudLogActivity2, CloudLogActivity.this.getPackageName() + ".fileProvider", file);
                    } else {
                        uri = Uri.fromFile(file);
                    }
                    intent2.addFlags(268468224);
                    intent2.addFlags(1);
                    intent2.setDataAndType(uri, "video/*");
                    CloudLogActivity.this.startActivity(intent2);
                }
            }
        }

        /* access modifiers changed from: protected */
        public void onProgressUpdate(Integer... numArr) {
            super.onProgressUpdate(numArr);
            Log.d(ContentCommon.SERVER_STRING, "onProgressUpdate values:" + numArr[0]);
        }
    }
}
