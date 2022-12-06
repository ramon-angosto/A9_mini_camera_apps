package shix.ihdbell.project;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import com.jxl.app.littlestars.project.R;
import com.tzh.ipcamera.presenter.LogUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import object.p2pipcam.adapter.PictureActivityAdapter;
import object.p2pipcam.bean.CameraParamsBean;
import object.p2pipcam.content.ContentCommon;
import object.p2pipcam.system.SystemValue;
import object.p2pipcam.utils.DataBaseHelper;

public class PictureActivity extends BaseActivity implements View.OnClickListener, AdapterView.OnItemClickListener {
    /* access modifiers changed from: private */
    public ArrayList<CameraParamsBean> arrayList = new ArrayList<>();
    private MyStatusBroadCast broadcast;
    /* access modifiers changed from: private */
    public Handler handler = new Handler() {
        public void handleMessage(Message message) {
            int i = message.what;
            if (i == 2) {
                PictureActivity.this.mAdapter.setOver(true);
            } else if (i == 3) {
                PictureActivity.this.sendBroadcast(new Intent("other"));
                return;
            }
            PictureActivity.this.mAdapter.notifyDataSetChanged();
        }
    };
    /* access modifiers changed from: private */
    public DataBaseHelper helper;
    /* access modifiers changed from: private */
    public boolean isFirst = true;
    private ListView listView;
    LogUtils logUtils = LogUtils.setLogger(PictureActivity.class);
    /* access modifiers changed from: private */
    public PictureActivityAdapter mAdapter;
    private int timeOne = 0;
    private int timeTag = 0;
    private int timeTwo = 0;

    private void setListener() {
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Log.d("tag", "PictureActivity  onCreate");
        requestWindowFeature(1);
        setContentView(R.layout.pictureactivity);
        findView();
        setListener();
        this.helper = DataBaseHelper.getInstance(this);
        ap_bean_init();
        Iterator<CameraParamsBean> it = SystemValue.arrayList.iterator();
        while (it.hasNext()) {
            CameraParamsBean next = it.next();
            this.arrayList.add(next);
            LogUtils logUtils2 = this.logUtils;
            logUtils2.e("###add bean:" + next.getName());
        }
        this.arrayList.add(SystemValue.ApModelBean);
        LogUtils logUtils3 = this.logUtils;
        logUtils3.e("###PictureaActivity bean:" + this.arrayList.size());
        this.mAdapter = new PictureActivityAdapter(this, this.arrayList);
        this.listView.setAdapter(this.mAdapter);
        this.mAdapter.notifyDataSetChanged();
        this.listView.setOnItemClickListener(this);
        this.handler.sendEmptyMessageDelayed(3, 1000);
        this.broadcast = new MyStatusBroadCast();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("camera_status_change");
        registerReceiver(this.broadcast, intentFilter);
    }

    private void ap_bean_init() {
        SystemValue.ApModelBean.setAuthority(false);
        SystemValue.ApModelBean.setName("APCamera");
        SystemValue.ApModelBean.setDid("APCAMERA0000000");
        SystemValue.ApModelBean.setUser("");
        SystemValue.ApModelBean.setPwd("");
        SystemValue.ApModelBean.setStatus(-1);
        SystemValue.ApModelBean.setMode(-1);
        SystemValue.ApModelBean.setBmp((Bitmap) null);
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        if (this.arrayList.size() == 0) {
            this.listView.setVisibility(8);
        } else {
            this.listView.setVisibility(0);
        }
        if (hasSdcard()) {
            initBmpAndSum();
        } else {
            showToast((int) R.string.local_picture_show_sd);
        }
    }

    private void initBmpAndSum() {
        new Thread() {
            public void run() {
                synchronized (PictureActivity.this) {
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    for (int i = 0; i < PictureActivity.this.arrayList.size(); i++) {
                        CameraParamsBean cameraParamsBean = (CameraParamsBean) PictureActivity.this.arrayList.get(i);
                        String did = cameraParamsBean.getDid();
                        Cursor queryAllPicture = PictureActivity.this.helper.queryAllPicture(did);
                        int count = queryAllPicture.getCount();
                        Bitmap bitmap = null;
                        boolean unused = PictureActivity.this.isFirst = true;
                        while (queryAllPicture.moveToNext()) {
                            String string = queryAllPicture.getString(queryAllPicture.getColumnIndex(DataBaseHelper.KEY_FILEPATH));
                            if (!new File(string).exists()) {
                                count--;
                                Log.d("tag", "delResult:" + PictureActivity.this.helper.deleteVideoOrPicture(did, string, DataBaseHelper.TYPE_PICTURE));
                            } else if (PictureActivity.this.isFirst) {
                                BitmapFactory.Options options = new BitmapFactory.Options();
                                options.inSampleSize = 5;
                                bitmap = BitmapFactory.decodeFile(string, options);
                                boolean unused2 = PictureActivity.this.isFirst = false;
                            }
                        }
                        if (queryAllPicture != null) {
                            queryAllPicture.close();
                        }
                        cameraParamsBean.setBmp(bitmap);
                        cameraParamsBean.setSum_pic(count);
                        PictureActivity.this.handler.sendEmptyMessage(1);
                    }
                    PictureActivity.this.handler.sendEmptyMessage(2);
                }
            }
        }.start();
    }

    private void findView() {
        this.listView = (ListView) findViewById(R.id.piclistview);
        findViewById(R.id.back).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                PictureActivity.this.finish();
                PictureActivity.this.overridePendingTransition(R.anim.out_to_right, R.anim.in_from_left);
            }
        });
    }

    public void onClick(View view) {
        view.getId();
        this.mAdapter.notifyDataSetChanged();
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        CameraParamsBean cameraParamsBean = this.arrayList.get(i);
        String did = cameraParamsBean.getDid();
        String name = cameraParamsBean.getName();
        cameraParamsBean.getStatus();
        if (this.mAdapter.getMode() == 1) {
            Intent intent = new Intent(this, LocalPictureListActivity.class);
            intent.putExtra(ContentCommon.STR_CAMERA_NAME, name);
            intent.putExtra(ContentCommon.STR_CAMERA_ID, did);
            startActivity(intent);
            overridePendingTransition(R.anim.in_from_right, R.anim.out_to_left);
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 82) {
            sendBroadcast(new Intent(ContentCommon.MAIN_KEY_MENU));
            return false;
        } else if (i != 4) {
            return super.onKeyDown(i, keyEvent);
        } else {
            sendBroadcast(new Intent(ContentCommon.MAIN_KEY_BACK));
            return true;
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        unregisterReceiver(this.broadcast);
    }

    private class MyStatusBroadCast extends BroadcastReceiver {
        private MyStatusBroadCast() {
        }

        public void onReceive(Context context, Intent intent) {
            if ("camera_status_change".equals(intent.getAction())) {
                PictureActivity.this.mAdapter.notifyDataSetChanged();
            }
        }
    }
}
