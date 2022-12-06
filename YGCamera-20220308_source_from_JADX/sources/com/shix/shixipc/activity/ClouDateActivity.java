package com.shix.shixipc.activity;

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
import com.alibaba.sdk.android.oss.ClientConfiguration;
import com.alibaba.sdk.android.oss.ClientException;
import com.alibaba.sdk.android.oss.OSS;
import com.alibaba.sdk.android.oss.OSSClient;
import com.alibaba.sdk.android.oss.ServiceException;
import com.alibaba.sdk.android.oss.callback.OSSCompletedCallback;
import com.alibaba.sdk.android.oss.common.auth.OSSCredentialProvider;
import com.alibaba.sdk.android.oss.common.auth.OSSPlainTextAKSKCredentialProvider;
import com.alibaba.sdk.android.oss.model.ListObjectsRequest;
import com.alibaba.sdk.android.oss.model.ListObjectsResult;
import com.shix.shixipc.BaseActivity;
import com.shix.shixipc.adapter.CloudDateAdapter;
import com.shix.shixipc.system.ContentCommon;
import com.shix.shixipc.system.StyleCommon;
import com.shix.shixipc.utils.CommonUtil;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.List;
import object.p2pipcam.nativecaller.NativeCaller;
import shix.cykj.camera.R;

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
    /* access modifiers changed from: private */
    public List<String> listDate;
    /* access modifiers changed from: private */
    public ListView listView;
    /* access modifiers changed from: private */
    public CloudDateAdapter mAdapter;
    private OSS oss;

    private void setListener() {
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        Intent intent = getIntent();
        this.did = intent.getStringExtra(ContentCommon.STR_CAMERA_ID);
        this.camName = intent.getStringExtra(ContentCommon.STR_CAMERA_NAME);
        setContentView(R.layout.clouddateactivity);
        this.listDate = new ArrayList();
        findView();
        setListener();
        ((TextView) findViewById(R.id.tv_camera_setting)).setText(this.camName + "  " + getResources().getString(R.string.cloud_log));
        SetTab(this, StyleCommon.Color_All_Top_StatuBar_Bg);
        this.listView.setOnItemClickListener(this);
        this.handler.sendEmptyMessageDelayed(3, 1000);
        this.did = this.did.toUpperCase().replace(Constants.ACCEPT_TIME_SEPARATOR_SERVER, "");
        this.did = this.did.substring(0, 3) + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.did.substring(3, 9) + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.did.substring(9);
        StringBuilder sb = new StringBuilder();
        sb.append("SHIXCLOUD  did:");
        sb.append(this.did);
        CommonUtil.Log(1, sb.toString());
        OSSPlainTextAKSKCredentialProvider oSSPlainTextAKSKCredentialProvider = new OSSPlainTextAKSKCredentialProvider(NativeCaller.SHIXGetAPPKey1(1), NativeCaller.SHIXGetAPPSer1(1));
        ClientConfiguration clientConfiguration = new ClientConfiguration();
        clientConfiguration.setConnectionTimeout(15000);
        clientConfiguration.setSocketTimeout(15000);
        clientConfiguration.setMaxConcurrentRequest(5);
        clientConfiguration.setMaxErrorRetry(2);
        this.oss = new OSSClient(getApplicationContext(), "http://oss-cn-shenzhen.aliyuncs.com", (OSSCredentialProvider) oSSPlainTextAKSKCredentialProvider);
        test();
    }

    private void test() {
        ListObjectsRequest listObjectsRequest = new ListObjectsRequest(ContentCommon.CLOUDBUCKET);
        listObjectsRequest.setPrefix(this.did + "/dates/");
        Log.d("OSS AyncListObjects", "OSS---start ");
        this.oss.asyncListObjects(listObjectsRequest, new OSSCompletedCallback<ListObjectsRequest, ListObjectsResult>() {
            public void onSuccess(ListObjectsRequest listObjectsRequest, ListObjectsResult listObjectsResult) {
                Log.d("OSS AyncListObjects", "OSS Success!  size锟斤拷" + listObjectsResult.getObjectSummaries().size());
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
        startActivity(intent);
        overridePendingTransition(R.anim.in_from_right, R.anim.out_to_left);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
    }
}
