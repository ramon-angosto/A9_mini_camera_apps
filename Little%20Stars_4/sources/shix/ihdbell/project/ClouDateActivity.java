package shix.ihdbell.project;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
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
import java.util.ArrayList;
import java.util.List;
import object.p2pipcam.adapter.CloudDateAdapter;
import object.p2pipcam.content.ContentCommon;
import object.p2pipcam.system.SystemValue;
import object.p2pipcam.utils.CommonUtil;

public class ClouDateActivity extends BaseActivity implements View.OnClickListener, AdapterView.OnItemClickListener {
    private final int BEND = 1;
    private final int BEND1 = 2;
    private Button btnBack;
    private String camName;
    private String clouddate;
    private String did;
    /* access modifiers changed from: private */
    public Handler handler = new Handler() {
        public void handleMessage(Message message) {
            int i = message.what;
            if (i == 1) {
                String string = message.getData().getString("path");
                CommonUtil.Log(1, "path:" + string);
                if (string != null && string.length() >= 10) {
                    string.indexOf("/");
                    ClouDateActivity.this.listDate.add(string.substring(string.lastIndexOf("/") + 1));
                }
            } else if (i == 2) {
                ClouDateActivity clouDateActivity = ClouDateActivity.this;
                CloudDateAdapter unused = clouDateActivity.mAdapter = new CloudDateAdapter(clouDateActivity, clouDateActivity.listDate);
                ClouDateActivity.this.listView.setAdapter(ClouDateActivity.this.mAdapter);
            }
        }
    };
    int iVer = 37;
    /* access modifiers changed from: private */
    public List<String> listDate;
    /* access modifiers changed from: private */
    public ListView listView;
    /* access modifiers changed from: private */
    public CloudDateAdapter mAdapter;
    private OSS oss;
    String strServe;

    private void setListener() {
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        String str;
        super.onCreate(bundle);
        requestWindowFeature(1);
        Intent intent = getIntent();
        this.did = intent.getStringExtra(ContentCommon.STR_CAMERA_ID);
        this.camName = intent.getStringExtra(ContentCommon.STR_CAMERA_NAME);
        this.strServe = intent.getStringExtra("strServe");
        setContentView(R.layout.clouddateactivity);
        if (!SystemValue.isLitos && (str = this.strServe) != null && str.length() > 2 && this.strServe.indexOf(".") > 0) {
            String str2 = this.strServe;
            this.iVer = Integer.parseInt(str2.substring(str2.length() - 2));
            CommonUtil.Log(1, "iVer:" + this.iVer + "  sysver:" + this.strServe);
        }
        this.listDate = new ArrayList();
        findView();
        setListener();
        this.listView.setOnItemClickListener(this);
        this.handler.sendEmptyMessageDelayed(3, 1000);
        if (SystemValue.isLitos) {
            this.did = this.did.toUpperCase().replace(Constants.ACCEPT_TIME_SEPARATOR_SERVER, "");
            this.oss = new OSSClient(getApplicationContext(), "http://oss-cn-hongkong.aliyuncs.com", new OSSPlainTextAKSKCredentialProvider("LTAIh62da6vQ1Ck3", "TZiTDt7yhWPbu1PluV1aryfIzT4QaP"));
        } else if (this.iVer < 36) {
            this.did = this.did.toUpperCase().replace(Constants.ACCEPT_TIME_SEPARATOR_SERVER, "");
            this.oss = new OSSClient(getApplicationContext(), "http://oss-cn-shenzhen.aliyuncs.com", new OSSPlainTextAKSKCredentialProvider("Ae9mSDpwKHlPQNJ2", "wW0pG66vhPiW6cCpHbTc72EWj0ZiCV"));
        } else {
            this.did = this.did.toUpperCase().replace(Constants.ACCEPT_TIME_SEPARATOR_SERVER, "");
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
        listObjectsRequest.setPrefix(this.did + "/dates/");
        Log.d("OSS AyncListObjects", "OSS---start ");
        this.oss.asyncListObjects(listObjectsRequest, new OSSCompletedCallback<ListObjectsRequest, ListObjectsResult>() {
            public void onSuccess(ListObjectsRequest listObjectsRequest, ListObjectsResult listObjectsResult) {
                Log.d("OSS AyncListObjects", "OSS Success!  size��" + listObjectsResult.getObjectSummaries().size());
                for (int i = 0; i < listObjectsResult.getObjectSummaries().size(); i++) {
                    Log.d("OSS AyncListObjects", "OSS object: " + listObjectsResult.getObjectSummaries().get(i).getKey() + " " + listObjectsResult.getObjectSummaries().get(i).getETag() + " " + listObjectsResult.getObjectSummaries().get(i).getLastModified());
                    String key = listObjectsResult.getObjectSummaries().get(i).getKey();
                    Message obtainMessage = ClouDateActivity.this.handler.obtainMessage();
                    obtainMessage.what = 1;
                    Bundle bundle = new Bundle();
                    bundle.putString("path", key);
                    obtainMessage.setData(bundle);
                    ClouDateActivity.this.handler.sendMessage(obtainMessage);
                    if (i == listObjectsResult.getObjectSummaries().size() - 1) {
                        ClouDateActivity.this.handler.sendEmptyMessage(2);
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

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
    }

    private void findView() {
        this.listView = (ListView) findViewById(R.id.piclistview);
        ((TextView) findViewById(R.id.tv_title)).setText(this.camName + " " + getResources().getString(R.string.cloud_log));
        this.btnBack = (Button) findViewById(R.id.back);
        this.btnBack.setOnClickListener(this);
    }

    public void onClick(View view) {
        if (view.getId() == R.id.back) {
            finish();
            overridePendingTransition(R.anim.out_to_right, R.anim.in_from_left);
        }
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        Intent intent = new Intent(this, CloudLogActivity.class);
        intent.putExtra(ContentCommon.STR_CAMERA_ID, this.did);
        intent.putExtra(ContentCommon.STR_CAMERA_NAME, this.camName);
        intent.putExtra(ContentCommon.STR_CLOUD_DATE, this.listDate.get(i));
        intent.putExtra("iVer", this.iVer);
        startActivity(intent);
        overridePendingTransition(R.anim.in_from_right, R.anim.out_to_left);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
    }
}
