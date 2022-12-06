package shix.ihdbell.project;

import android.app.NotificationManager;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.ColorDrawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.alibaba.sdk.android.oss.ClientException;
import com.alibaba.sdk.android.oss.OSS;
import com.alibaba.sdk.android.oss.OSSClient;
import com.alibaba.sdk.android.oss.ServiceException;
import com.alibaba.sdk.android.oss.callback.OSSCompletedCallback;
import com.alibaba.sdk.android.oss.common.auth.OSSPlainTextAKSKCredentialProvider;
import com.alibaba.sdk.android.oss.model.ListObjectsRequest;
import com.alibaba.sdk.android.oss.model.ListObjectsResult;
import com.jxl.app.littlestars.project.R;
import com.xiaomi.mipush.sdk.Constants;
import java.io.File;
import java.io.FileOutputStream;
import object.p2pipcam.adapter.CloudLogAdapter;
import object.p2pipcam.bean.CloudBean;
import object.p2pipcam.content.ContentCommon;
import object.p2pipcam.system.SystemValue;
import object.p2pipcam.utils.CommonUtil;
import object.p2pipcam.utils.DataBaseHelper;
import object.p2pipcam.view.RoundProgressBar;
import shix.ihdbell.project.BridgeService;

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
            CloudLogActivity.this.textView_name.setText("/mnt/sdcard/LittleStars/picVisitor/");
            CloudLogActivity.this.adapter.notifyDataSetChanged();
            Log.d("test", "savePicToSDcard4");
        }
    };
    String CloudPath111;
    String FileName111;
    /* access modifiers changed from: private */
    public CloudLogAdapter adapter;
    /* access modifiers changed from: private */
    public Bitmap bmp;
    private Button btnBack;
    /* access modifiers changed from: private */
    public Button buttonPlay;
    private Button button_cancel;
    private Button button_ok;
    private String camName;
    private String dateTime = "";
    /* access modifiers changed from: private */
    public String did;
    private FrameLayout framelayout;
    /* access modifiers changed from: private */
    public int iVer;
    /* access modifiers changed from: private */
    public ImageView imageView;
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
                    String substring2 = substring.substring(substring.lastIndexOf(Constants.ACCEPT_TIME_SEPARATOR_SERVER) + 1, substring.lastIndexOf(Constants.ACCEPT_TIME_SEPARATOR_SERVER) + 2);
                    CloudBean cloudBean = new CloudBean();
                    cloudBean.setCloudPath(string);
                    cloudBean.setStrDid(CloudLogActivity.this.did);
                    cloudBean.setFileName(substring);
                    cloudBean.setCreateTime(substring.substring(0, 10) + "  " + substring.substring(11, 19).replace(Constants.ACCEPT_TIME_SEPARATOR_SERVER, ":"));
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
    public RoundProgressBar roundProgressBar1_1;
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
        this.iVer = getIntent().getIntExtra("iVer", 36);
        CommonUtil.Log(1, "iVer:" + this.iVer);
        findView();
        setListener();
        this.adapter = new CloudLogAdapter(this, this);
        this.listView.setAdapter(this.adapter);
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
        if (SystemValue.isLitos) {
            this.did = this.did.toUpperCase().replace(Constants.ACCEPT_TIME_SEPARATOR_SERVER, "");
            this.oss = new OSSClient(getApplicationContext(), "http://oss-cn-hongkong.aliyuncs.com", new OSSPlainTextAKSKCredentialProvider("LTAIh62da6vQ1Ck3", "TZiTDt7yhWPbu1PluV1aryfIzT4QaP"));
        } else if (this.iVer < 36) {
            this.oss = new OSSClient(getApplicationContext(), "http://oss-cn-shenzhen.aliyuncs.com", new OSSPlainTextAKSKCredentialProvider("Ae9mSDpwKHlPQNJ2", "wW0pG66vhPiW6cCpHbTc72EWj0ZiCV"));
        } else {
            this.oss = new OSSClient(getApplicationContext(), "http://oss-cn-hongkong.aliyuncs.com", new OSSPlainTextAKSKCredentialProvider("LTAIh62da6vQ1Ck3", "TZiTDt7yhWPbu1PluV1aryfIzT4QaP"));
        }
        test();
    }

    private void test() {
        ListObjectsRequest listObjectsRequest;
        if (this.iVer < 36) {
            listObjectsRequest = new ListObjectsRequest(ContentCommon.CLOUDBUCKET);
        } else {
            listObjectsRequest = new ListObjectsRequest(ContentCommon.CLOUDBUCKETNEW);
        }
        if (SystemValue.isLitos) {
            listObjectsRequest = new ListObjectsRequest(ContentCommon.CLOUDBUCKELITEOS);
        }
        listObjectsRequest.setPrefix(this.did + "/photos/" + this.strdata + "/");
        Log.d("OSS AyncListObjects", "OSS---start ");
        this.oss.asyncListObjects(listObjectsRequest, new OSSCompletedCallback<ListObjectsRequest, ListObjectsResult>() {
            public void onSuccess(ListObjectsRequest listObjectsRequest, ListObjectsResult listObjectsResult) {
                Log.d("OSS AyncListObjects", "OSS Success!  size11" + listObjectsResult.getObjectSummaries().size());
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

    /* JADX WARNING: Code restructure failed: missing block: B:25:0x00ef, code lost:
        r6 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:?, code lost:
        r6.printStackTrace();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00f9, code lost:
        r6 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00fa, code lost:
        android.util.Log.e("RequestId", r6.getRequestId());
        android.util.Log.e("ErrorCode", r6.getErrorCode());
        android.util.Log.e("HostId", r6.getHostId());
        android.util.Log.e("RawMessage", r6.getRawMessage());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x011f, code lost:
        r6 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0120, code lost:
        r6.printStackTrace();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:?, code lost:
        return;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00f9 A[ExcHandler: ServiceException (r6v9 'e' com.alibaba.sdk.android.oss.ServiceException A[CUSTOM_DECLARE]), Splitter:B:15:0x0072] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x011f A[ExcHandler: ClientException (r6v8 'e' com.alibaba.sdk.android.oss.ClientException A[CUSTOM_DECLARE]), Splitter:B:15:0x0072] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void getObjectSample(java.lang.String r6, java.lang.String r7, java.lang.String r8) {
        /*
            r5 = this;
            java.io.File r0 = new java.io.File
            java.io.File r1 = android.os.Environment.getExternalStorageDirectory()
            java.lang.String r2 = "LittleStars/cloud"
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
            object.p2pipcam.utils.CommonUtil.Log(r7, r6)
            java.io.FileOutputStream r6 = new java.io.FileOutputStream     // Catch:{ FileNotFoundException -> 0x0049 }
            r6.<init>(r1)     // Catch:{ FileNotFoundException -> 0x0049 }
            r5.testOS = r6     // Catch:{ FileNotFoundException -> 0x0049 }
            goto L_0x004d
        L_0x0049:
            r6 = move-exception
            r6.printStackTrace()
        L_0x004d:
            java.lang.String r6 = "testDown1"
            object.p2pipcam.utils.CommonUtil.Log(r7, r6)
            int r6 = r5.iVer
            r0 = 36
            if (r6 >= r0) goto L_0x0060
            com.alibaba.sdk.android.oss.model.GetObjectRequest r6 = new com.alibaba.sdk.android.oss.model.GetObjectRequest
            java.lang.String r0 = "doorbell"
            r6.<init>(r0, r8)
            goto L_0x0067
        L_0x0060:
            com.alibaba.sdk.android.oss.model.GetObjectRequest r6 = new com.alibaba.sdk.android.oss.model.GetObjectRequest
            java.lang.String r0 = "ihdbell"
            r6.<init>(r0, r8)
        L_0x0067:
            boolean r0 = object.p2pipcam.system.SystemValue.isLitos
            if (r0 == 0) goto L_0x0072
            com.alibaba.sdk.android.oss.model.GetObjectRequest r6 = new com.alibaba.sdk.android.oss.model.GetObjectRequest
            java.lang.String r0 = "ihdtans"
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
            object.p2pipcam.utils.CommonUtil.Log(r7, r2)     // Catch:{ ClientException -> 0x011f, ServiceException -> 0x00f9, IOException -> 0x00f4 }
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
        throw new UnsupportedOperationException("Method not decompiled: shix.ihdbell.project.CloudLogActivity.getObjectSample(java.lang.String, java.lang.String, java.lang.String):void");
    }

    public void showPic(int i, String str, String str2, String str3, String str4, String str5, int i2) {
        CommonUtil.Log(1, "coudpath:" + str4);
        this.pathTest = Environment.getExternalStorageDirectory() + "/" + ContentCommon.SDCARD_PATH + "/cloud/" + this.did + str2;
        int i3 = i2 == 1 ? R.string.doorbell_fangke : i2 == 11 ? R.string.doorbell_alerm11 : R.string.doorbell_alerm;
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
                        CloudLogActivity.this.imageView.setImageResource(R.drawable.vidicon);
                    } catch (Exception unused) {
                        CloudLogActivity.this.imageView.setImageResource(R.drawable.vidicon);
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
                    this.imageView.setImageResource(R.drawable.vidicon);
                }
            } catch (Exception unused) {
                this.imageView.setImageResource(R.drawable.vidicon);
            }
        }
        this.strTitle = getResources().getString(i3) + "  " + str3;
        TextView textView2 = this.textView;
        textView2.setText(getResources().getString(i3) + "  " + str3);
        this.buttonPlay.setVisibility(0);
        this.roundProgressBar1_1.setVisibility(8);
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
            java.io.File r3 = android.os.Environment.getExternalStorageDirectory()     // Catch:{ Exception -> 0x0096 }
            java.lang.String r4 = "LittleStars/picVisitor"
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
            goto L_0x00d2
        L_0x00d1:
            throw r0
        L_0x00d2:
            goto L_0x00d1
        */
        throw new UnsupportedOperationException("Method not decompiled: shix.ihdbell.project.CloudLogActivity.savePicToSDcard():void");
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
        this.roundProgressBar1_1 = (RoundProgressBar) this.popv_re.findViewById(R.id.roundProgressBar);
        this.roundProgressBar1_1.setCricleProgressColor(SystemValue.TopBg);
        this.roundProgressBar1_1.setTextColor(SystemValue.TopBg);
        this.roundProgressBar1_1.setMax(100);
        this.roundProgressBar1_1.setProgress(50);
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
        this.buttonPlay.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                String replace = CloudLogActivity.this.CloudPath111.replace("photos", "records").replace(".jpg", ".h264");
                new MyAsyncTask().execute(new String[]{replace});
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
        this.button_cancel.setOnClickListener(this);
        this.button_ok.setOnClickListener(this);
    }

    private void findView() {
        this.btnBack = (Button) findViewById(R.id.back);
        this.listView = (ListView) findViewById(R.id.listView1);
        this.tvNoLog = (TextView) findViewById(R.id.no_log);
        this.button_cancel = (Button) findViewById(R.id.aler_cancel);
        this.button_ok = (Button) findViewById(R.id.aler_ok);
        this.linearLayout_buttom = (LinearLayout) findViewById(R.id.alarm_bottom_layout);
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
        BridgeService.setSnapShotInterface((BridgeService.SnapShotInterface) null);
        BridgeService.setLogsInterface((BridgeService.LogsInterface) null);
        ((NotificationManager) getSystemService("notification")).cancel(110);
        SystemValue.PushAlarmCount = 0;
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.aler_cancel:
                finish();
                overridePendingTransition(R.anim.out_to_right, R.anim.in_from_left);
                return;
            case R.id.back:
                finish();
                overridePendingTransition(R.anim.out_to_right, R.anim.in_from_left);
                return;
            default:
                return;
        }
    }

    private String retrunUser(String str) {
        int i = 0;
        while (i < SystemValue.arrayList.size()) {
            if (str == null || !str.equals(SystemValue.arrayList.get(i).getDid())) {
                i++;
            } else {
                Log.d("tag", "testuser:" + SystemValue.arrayList.get(i).getUser());
                return SystemValue.arrayList.get(i).getUser();
            }
        }
        return null;
    }

    private String retrunUserPWD(String str) {
        int i = 0;
        while (i < SystemValue.arrayList.size()) {
            if (str == null || !str.equals(SystemValue.arrayList.get(i).getDid())) {
                i++;
            } else {
                Log.d("tag", "testuserpwd:" + SystemValue.arrayList.get(i).getPwd());
                return SystemValue.arrayList.get(i).getPwd();
            }
        }
        return null;
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
            CloudLogActivity.this.roundProgressBar1_1.setVisibility(0);
            CloudLogActivity.this.roundProgressBar1_1.setProgress(0);
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: Code restructure failed: missing block: B:32:0x017c, code lost:
            r12 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:34:?, code lost:
            r12.printStackTrace();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:38:0x0186, code lost:
            r12 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:39:0x0187, code lost:
            android.util.Log.e("RequestId", r12.getRequestId());
            android.util.Log.e("ErrorCode", r12.getErrorCode());
            android.util.Log.e("HostId", r12.getHostId());
            android.util.Log.e("RawMessage", r12.getRawMessage());
         */
        /* JADX WARNING: Code restructure failed: missing block: B:40:0x01ab, code lost:
            return null;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:41:0x01ac, code lost:
            r12 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:42:0x01ad, code lost:
            r12.printStackTrace();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:43:0x01b0, code lost:
            return null;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Removed duplicated region for block: B:38:0x0186 A[ExcHandler: ServiceException (r12v3 'e' com.alibaba.sdk.android.oss.ServiceException A[CUSTOM_DECLARE]), Splitter:B:22:0x00ab] */
        /* JADX WARNING: Removed duplicated region for block: B:41:0x01ac A[ExcHandler: ClientException (r12v2 'e' com.alibaba.sdk.android.oss.ClientException A[CUSTOM_DECLARE]), Splitter:B:22:0x00ab] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.String doInBackground(java.lang.String... r12) {
            /*
                r11 = this;
                r0 = 0
                r12 = r12[r0]
                java.io.File r1 = new java.io.File
                java.io.File r2 = android.os.Environment.getExternalStorageDirectory()
                java.lang.String r3 = "LittleStars/cloud"
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
                shix.ihdbell.project.CloudLogActivity r7 = shix.ihdbell.project.CloudLogActivity.this
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
                object.p2pipcam.utils.CommonUtil.Log(r3, r1)
                java.lang.String r1 = r4.getAbsolutePath()
                boolean r2 = r4.exists()
                if (r2 == 0) goto L_0x0074
                long r7 = r4.length()
                r9 = 1000(0x3e8, double:4.94E-321)
                int r2 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
                if (r2 <= 0) goto L_0x0074
                return r1
            L_0x0074:
                shix.ihdbell.project.CloudLogActivity r2 = shix.ihdbell.project.CloudLogActivity.this     // Catch:{ FileNotFoundException -> 0x007e }
                java.io.FileOutputStream r5 = new java.io.FileOutputStream     // Catch:{ FileNotFoundException -> 0x007e }
                r5.<init>(r4)     // Catch:{ FileNotFoundException -> 0x007e }
                r2.testOS = r5     // Catch:{ FileNotFoundException -> 0x007e }
                goto L_0x0082
            L_0x007e:
                r2 = move-exception
                r2.printStackTrace()
            L_0x0082:
                java.lang.String r2 = "testDown1"
                object.p2pipcam.utils.CommonUtil.Log(r3, r2)
                shix.ihdbell.project.CloudLogActivity r2 = shix.ihdbell.project.CloudLogActivity.this
                int r2 = r2.iVer
                r4 = 36
                if (r2 >= r4) goto L_0x0099
                com.alibaba.sdk.android.oss.model.GetObjectRequest r2 = new com.alibaba.sdk.android.oss.model.GetObjectRequest
                java.lang.String r4 = "doorbell"
                r2.<init>(r4, r12)
                goto L_0x00a0
            L_0x0099:
                com.alibaba.sdk.android.oss.model.GetObjectRequest r2 = new com.alibaba.sdk.android.oss.model.GetObjectRequest
                java.lang.String r4 = "ihdbell"
                r2.<init>(r4, r12)
            L_0x00a0:
                boolean r4 = object.p2pipcam.system.SystemValue.isLitos
                if (r4 == 0) goto L_0x00ab
                com.alibaba.sdk.android.oss.model.GetObjectRequest r2 = new com.alibaba.sdk.android.oss.model.GetObjectRequest
                java.lang.String r4 = "ihdtans"
                r2.<init>(r4, r12)
            L_0x00ab:
                shix.ihdbell.project.CloudLogActivity r12 = shix.ihdbell.project.CloudLogActivity.this     // Catch:{ ClientException -> 0x01ac, ServiceException -> 0x0186, IOException -> 0x0181 }
                com.alibaba.sdk.android.oss.OSS r12 = r12.oss     // Catch:{ ClientException -> 0x01ac, ServiceException -> 0x0186, IOException -> 0x0181 }
                com.alibaba.sdk.android.oss.model.GetObjectResult r12 = r12.getObject(r2)     // Catch:{ ClientException -> 0x01ac, ServiceException -> 0x0186, IOException -> 0x0181 }
                long r4 = r12.getContentLength()     // Catch:{ ClientException -> 0x01ac, ServiceException -> 0x0186, IOException -> 0x0181 }
                r11.allLen = r4     // Catch:{ ClientException -> 0x01ac, ServiceException -> 0x0186, IOException -> 0x0181 }
                java.lang.String r2 = "Content-Length"
                java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ ClientException -> 0x01ac, ServiceException -> 0x0186, IOException -> 0x0181 }
                r4.<init>()     // Catch:{ ClientException -> 0x01ac, ServiceException -> 0x0186, IOException -> 0x0181 }
                java.lang.String r5 = "allLen:"
                r4.append(r5)     // Catch:{ ClientException -> 0x01ac, ServiceException -> 0x0186, IOException -> 0x0181 }
                long r7 = r11.allLen     // Catch:{ ClientException -> 0x01ac, ServiceException -> 0x0186, IOException -> 0x0181 }
                r4.append(r7)     // Catch:{ ClientException -> 0x01ac, ServiceException -> 0x0186, IOException -> 0x0181 }
                java.lang.String r4 = r4.toString()     // Catch:{ ClientException -> 0x01ac, ServiceException -> 0x0186, IOException -> 0x0181 }
                android.util.Log.d(r2, r4)     // Catch:{ ClientException -> 0x01ac, ServiceException -> 0x0186, IOException -> 0x0181 }
                java.io.InputStream r2 = r12.getObjectContent()     // Catch:{ ClientException -> 0x01ac, ServiceException -> 0x0186, IOException -> 0x0181 }
                r4 = 2048(0x800, float:2.87E-42)
                byte[] r4 = new byte[r4]     // Catch:{ ClientException -> 0x01ac, ServiceException -> 0x0186, IOException -> 0x0181 }
            L_0x00db:
                int r5 = r2.read(r4)     // Catch:{ ClientException -> 0x01ac, ServiceException -> 0x0186, IOException -> 0x0181 }
                r7 = -1
                java.lang.String r8 = "asyncGetObjectSample"
                if (r5 == r7) goto L_0x015b
                java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ ClientException -> 0x01ac, ServiceException -> 0x0186, IOException -> 0x0181 }
                r7.<init>()     // Catch:{ ClientException -> 0x01ac, ServiceException -> 0x0186, IOException -> 0x0181 }
                java.lang.String r9 = "read length: "
                r7.append(r9)     // Catch:{ ClientException -> 0x01ac, ServiceException -> 0x0186, IOException -> 0x0181 }
                r7.append(r5)     // Catch:{ ClientException -> 0x01ac, ServiceException -> 0x0186, IOException -> 0x0181 }
                java.lang.String r7 = r7.toString()     // Catch:{ ClientException -> 0x01ac, ServiceException -> 0x0186, IOException -> 0x0181 }
                android.util.Log.d(r8, r7)     // Catch:{ ClientException -> 0x01ac, ServiceException -> 0x0186, IOException -> 0x0181 }
                java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ ClientException -> 0x01ac, ServiceException -> 0x0186, IOException -> 0x0181 }
                r7.<init>()     // Catch:{ ClientException -> 0x01ac, ServiceException -> 0x0186, IOException -> 0x0181 }
                java.lang.String r8 = "len:"
                r7.append(r8)     // Catch:{ ClientException -> 0x01ac, ServiceException -> 0x0186, IOException -> 0x0181 }
                r7.append(r5)     // Catch:{ ClientException -> 0x01ac, ServiceException -> 0x0186, IOException -> 0x0181 }
                java.lang.String r7 = r7.toString()     // Catch:{ ClientException -> 0x01ac, ServiceException -> 0x0186, IOException -> 0x0181 }
                object.p2pipcam.utils.CommonUtil.Log(r3, r7)     // Catch:{ ClientException -> 0x01ac, ServiceException -> 0x0186, IOException -> 0x0181 }
                shix.ihdbell.project.CloudLogActivity r7 = shix.ihdbell.project.CloudLogActivity.this     // Catch:{ ClientException -> 0x01ac, ServiceException -> 0x0186, IOException -> 0x0181 }
                java.io.FileOutputStream r7 = r7.testOS     // Catch:{ ClientException -> 0x01ac, ServiceException -> 0x0186, IOException -> 0x0181 }
                r7.write(r4, r0, r5)     // Catch:{ ClientException -> 0x01ac, ServiceException -> 0x0186, IOException -> 0x0181 }
                long r7 = r11.downLen     // Catch:{ ClientException -> 0x01ac, ServiceException -> 0x0186, IOException -> 0x0181 }
                long r9 = (long) r5     // Catch:{ ClientException -> 0x01ac, ServiceException -> 0x0186, IOException -> 0x0181 }
                long r7 = r7 + r9
                r11.downLen = r7     // Catch:{ ClientException -> 0x01ac, ServiceException -> 0x0186, IOException -> 0x0181 }
                long r7 = r11.downLen     // Catch:{ ClientException -> 0x01ac, ServiceException -> 0x0186, IOException -> 0x0181 }
                float r5 = (float) r7     // Catch:{ ClientException -> 0x01ac, ServiceException -> 0x0186, IOException -> 0x0181 }
                long r7 = r11.allLen     // Catch:{ ClientException -> 0x01ac, ServiceException -> 0x0186, IOException -> 0x0181 }
                float r7 = (float) r7     // Catch:{ ClientException -> 0x01ac, ServiceException -> 0x0186, IOException -> 0x0181 }
                float r5 = r5 / r7
                java.lang.String r7 = "test"
                java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ ClientException -> 0x01ac, ServiceException -> 0x0186, IOException -> 0x0181 }
                r8.<init>()     // Catch:{ ClientException -> 0x01ac, ServiceException -> 0x0186, IOException -> 0x0181 }
                java.lang.String r9 = "process:"
                r8.append(r9)     // Catch:{ ClientException -> 0x01ac, ServiceException -> 0x0186, IOException -> 0x0181 }
                r8.append(r5)     // Catch:{ ClientException -> 0x01ac, ServiceException -> 0x0186, IOException -> 0x0181 }
                java.lang.String r9 = " downLen:"
                r8.append(r9)     // Catch:{ ClientException -> 0x01ac, ServiceException -> 0x0186, IOException -> 0x0181 }
                long r9 = r11.downLen     // Catch:{ ClientException -> 0x01ac, ServiceException -> 0x0186, IOException -> 0x0181 }
                r8.append(r9)     // Catch:{ ClientException -> 0x01ac, ServiceException -> 0x0186, IOException -> 0x0181 }
                java.lang.String r9 = "  allLen:"
                r8.append(r9)     // Catch:{ ClientException -> 0x01ac, ServiceException -> 0x0186, IOException -> 0x0181 }
                long r9 = r11.allLen     // Catch:{ ClientException -> 0x01ac, ServiceException -> 0x0186, IOException -> 0x0181 }
                r8.append(r9)     // Catch:{ ClientException -> 0x01ac, ServiceException -> 0x0186, IOException -> 0x0181 }
                java.lang.String r8 = r8.toString()     // Catch:{ ClientException -> 0x01ac, ServiceException -> 0x0186, IOException -> 0x0181 }
                android.util.Log.d(r7, r8)     // Catch:{ ClientException -> 0x01ac, ServiceException -> 0x0186, IOException -> 0x0181 }
                java.lang.Integer[] r7 = new java.lang.Integer[r3]     // Catch:{ ClientException -> 0x01ac, ServiceException -> 0x0186, IOException -> 0x0181 }
                r8 = 1120403456(0x42c80000, float:100.0)
                float r5 = r5 * r8
                int r5 = (int) r5     // Catch:{ ClientException -> 0x01ac, ServiceException -> 0x0186, IOException -> 0x0181 }
                java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ ClientException -> 0x01ac, ServiceException -> 0x0186, IOException -> 0x0181 }
                r7[r0] = r5     // Catch:{ ClientException -> 0x01ac, ServiceException -> 0x0186, IOException -> 0x0181 }
                r11.publishProgress(r7)     // Catch:{ ClientException -> 0x01ac, ServiceException -> 0x0186, IOException -> 0x0181 }
                goto L_0x00db
            L_0x015b:
                java.lang.String r0 = "download success."
                android.util.Log.d(r8, r0)     // Catch:{ ClientException -> 0x01ac, ServiceException -> 0x0186, IOException -> 0x0181 }
                com.alibaba.sdk.android.oss.model.ObjectMetadata r12 = r12.getMetadata()     // Catch:{ ClientException -> 0x01ac, ServiceException -> 0x0186, IOException -> 0x0181 }
                java.lang.String r0 = "ContentType"
                java.lang.String r12 = r12.getContentType()     // Catch:{ ClientException -> 0x01ac, ServiceException -> 0x0186, IOException -> 0x0181 }
                android.util.Log.d(r0, r12)     // Catch:{ ClientException -> 0x01ac, ServiceException -> 0x0186, IOException -> 0x0181 }
                shix.ihdbell.project.CloudLogActivity r12 = shix.ihdbell.project.CloudLogActivity.this     // Catch:{ IOException -> 0x017c, ClientException -> 0x01ac, ServiceException -> 0x0186 }
                java.io.FileOutputStream r12 = r12.testOS     // Catch:{ IOException -> 0x017c, ClientException -> 0x01ac, ServiceException -> 0x0186 }
                r12.flush()     // Catch:{ IOException -> 0x017c, ClientException -> 0x01ac, ServiceException -> 0x0186 }
                shix.ihdbell.project.CloudLogActivity r12 = shix.ihdbell.project.CloudLogActivity.this     // Catch:{ IOException -> 0x017c, ClientException -> 0x01ac, ServiceException -> 0x0186 }
                java.io.FileOutputStream r12 = r12.testOS     // Catch:{ IOException -> 0x017c, ClientException -> 0x01ac, ServiceException -> 0x0186 }
                r12.close()     // Catch:{ IOException -> 0x017c, ClientException -> 0x01ac, ServiceException -> 0x0186 }
                goto L_0x0185
            L_0x017c:
                r12 = move-exception
                r12.printStackTrace()     // Catch:{ ClientException -> 0x01ac, ServiceException -> 0x0186, IOException -> 0x0181 }
                goto L_0x0185
            L_0x0181:
                r12 = move-exception
                r12.printStackTrace()
            L_0x0185:
                return r1
            L_0x0186:
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
            L_0x01ac:
                r12 = move-exception
                r12.printStackTrace()
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: shix.ihdbell.project.CloudLogActivity.MyAsyncTask.doInBackground(java.lang.String[]):java.lang.String");
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(String str) {
            super.onPostExecute(str);
            Log.d("test", "onPostExecute path:" + str);
            CloudLogActivity.this.roundProgressBar1_1.setVisibility(8);
            if (str == null || str.length() <= 5) {
                CloudLogActivity.this.showToast("No video");
                return;
            }
            CloudLogActivity.this.buttonPlay.setVisibility(0);
            Intent intent = new Intent(CloudLogActivity.this, ShowLocalVideoActivity.class);
            intent.putExtra(DataBaseHelper.KEY_FILEPATH, str);
            intent.putExtra(ContentCommon.STR_CAMERA_NAME, CloudLogActivity.this.strTitle);
            CloudLogActivity.this.startActivity(intent);
            CloudLogActivity.this.overridePendingTransition(R.anim.in_from_right, R.anim.out_to_left);
        }

        /* access modifiers changed from: protected */
        public void onProgressUpdate(Integer... numArr) {
            super.onProgressUpdate(numArr);
            Log.d("test", "onProgressUpdate values:" + numArr[0]);
            CloudLogActivity.this.roundProgressBar1_1.setProgress(numArr[0].intValue());
        }
    }
}
