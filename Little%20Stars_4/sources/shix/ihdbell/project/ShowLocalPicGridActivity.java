package shix.ihdbell.project;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.jxl.app.littlestars.project.R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import object.p2pipcam.adapter.ShowLocPicGridViewAdapter;
import object.p2pipcam.content.ContentCommon;
import object.p2pipcam.utils.DataBaseHelper;
import shix.ihdbell.project.ShowLocalPictureActivity;

public class ShowLocalPicGridActivity extends BaseActivity implements View.OnClickListener, AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener, ShowLocalPictureActivity.DeletePicInterface {
    public static ArrayList<Map<String, Object>> arrayList;
    private ArrayList<String> aList;
    public boolean bthread = true;
    private Button btnDel;
    private Button btnEdit;
    private Button btnSelectAll;
    private Button btnSelectReverse;
    /* access modifiers changed from: private */
    public ArrayList<Map<String, Object>> delPics = null;
    private GridView gridView;
    /* access modifiers changed from: private */
    public Handler handler = new Handler() {
        public void handleMessage(Message message) {
            ShowLocalPicGridActivity.this.mAdapter.notifyDataSetChanged();
        }
    };
    /* access modifiers changed from: private */
    public boolean isEditing = false;
    /* access modifiers changed from: private */
    public LinearLayout layoutDel;
    /* access modifiers changed from: private */
    public ShowLocPicGridViewAdapter mAdapter;
    private Matrix matrix;
    private int position = -1;
    /* access modifiers changed from: private */
    public ProgressDialog progressDialog;
    /* access modifiers changed from: private */
    public int seletNum;
    private String strCameraName;
    private String strDID;
    private String strDate;
    /* access modifiers changed from: private */
    public int tag = 1;
    private Thread thread = null;
    private TextView tvBack;
    /* access modifiers changed from: private */
    public TextView tvNoPics;
    /* access modifiers changed from: private */
    public TextView tvSelectSum;
    private TextView tvTakePicTime;

    /* access modifiers changed from: private */
    public Bitmap returnBitmap(Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        if (bitmap.getWidth() < 650 || bitmap.getHeight() < 490) {
            return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), this.matrix, true);
        }
        Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, 640, 480);
        return Bitmap.createBitmap(createBitmap, 0, 0, createBitmap.getWidth(), createBitmap.getHeight(), this.matrix, true);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getDataFromOther();
        requestWindowFeature(1);
        setContentView(R.layout.showlocalpicgrid);
        findView();
        setListener();
        this.mAdapter = new ShowLocPicGridViewAdapter(this, this.strDID);
        this.mAdapter.setMode(1);
        this.gridView.setAdapter(this.mAdapter);
        this.gridView.setOnItemClickListener(this);
        this.gridView.setOnItemLongClickListener(this);
        this.thread = new MyThread();
        this.thread.start();
        ShowLocalPictureActivity.setDeletePicInterface(this);
        this.matrix = new Matrix();
        this.matrix.postScale(0.4f, 0.3f);
        this.progressDialog = new ProgressDialog(this);
        this.progressDialog.setMessage(getResources().getString(R.string.main_show_delecting));
        this.progressDialog.setCancelable(false);
        SetTab(this);
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        Log.d("tag", "onStart  arrayList.size:" + arrayList.size());
        this.tvTakePicTime.setText(this.strDate);
        if (arrayList.size() == 0) {
            finish();
        }
    }

    private void setListener() {
        this.tvBack.setOnClickListener(this);
        this.btnSelectAll.setOnClickListener(this);
        this.btnSelectReverse.setOnClickListener(this);
        this.btnDel.setOnClickListener(this);
        this.btnEdit.setOnClickListener(this);
    }

    private void findView() {
        this.tvBack = (TextView) findViewById(R.id.back);
        this.tvTakePicTime = (TextView) findViewById(R.id.tv_time);
        this.tvSelectSum = (TextView) findViewById(R.id.tv_select_sum);
        this.gridView = (GridView) findViewById(R.id.gridView1);
        this.btnSelectAll = (Button) findViewById(R.id.selectall);
        this.btnSelectReverse = (Button) findViewById(R.id.selectreverse);
        this.btnDel = (Button) findViewById(R.id.delete);
        this.tvNoPics = (TextView) findViewById(R.id.localpic_tv_nopic);
        this.btnEdit = (Button) findViewById(R.id.edit);
        this.layoutDel = (LinearLayout) findViewById(R.id.del_bottom_layout);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || !this.isEditing) {
            return super.onKeyDown(i, keyEvent);
        }
        ProgressDialog progressDialog2 = this.progressDialog;
        if (progressDialog2 != null) {
            progressDialog2.cancel();
        }
        this.seletNum = 0;
        this.tvSelectSum.setVisibility(8);
        this.isEditing = false;
        this.layoutDel.setVisibility(8);
        ArrayList<Map<String, Object>> arrayPics = this.mAdapter.getArrayPics();
        for (int i2 = 0; i2 < arrayPics.size(); i2++) {
            arrayPics.get(i2).put("status", 0);
        }
        this.mAdapter.notifyDataSetChanged();
        return true;
    }

    public void onClick(View view) {
        int i = 0;
        switch (view.getId()) {
            case R.id.back:
                if (this.isEditing) {
                    this.seletNum = 0;
                    this.tvSelectSum.setVisibility(8);
                    this.isEditing = false;
                    this.layoutDel.setVisibility(8);
                    ArrayList<Map<String, Object>> arrayPics = this.mAdapter.getArrayPics();
                    while (i < arrayPics.size()) {
                        arrayPics.get(i).put("status", 0);
                        i++;
                    }
                    this.mAdapter.notifyDataSetChanged();
                    return;
                }
                finish();
                overridePendingTransition(R.anim.out_to_right, R.anim.in_from_left);
                return;
            case R.id.delete:
                Log.d("tag", RequestParameters.SUBRESOURCE_DELETE);
                this.seletNum = 0;
                this.tvSelectSum.setVisibility(8);
                new AsyncTask<Void, Void, Void>() {
                    /* access modifiers changed from: protected */
                    public void onPreExecute() {
                        int unused = ShowLocalPicGridActivity.this.seletNum = 0;
                        ShowLocalPicGridActivity.this.tvSelectSum.setVisibility(8);
                        if (ShowLocalPicGridActivity.this.progressDialog != null) {
                            ShowLocalPicGridActivity.this.progressDialog.show();
                        }
                        super.onPreExecute();
                    }

                    /* access modifiers changed from: protected */
                    public Void doInBackground(Void... voidArr) {
                        ShowLocalPicGridActivity showLocalPicGridActivity = ShowLocalPicGridActivity.this;
                        ArrayList unused = showLocalPicGridActivity.delPics = showLocalPicGridActivity.mAdapter.DelPics();
                        return null;
                    }

                    /* access modifiers changed from: protected */
                    public void onPostExecute(Void voidR) {
                        int unused = ShowLocalPicGridActivity.this.tag = 1;
                        if (ShowLocalPicGridActivity.this.delPics.size() == 0) {
                            ShowLocalPicGridActivity.this.tvNoPics.setVisibility(0);
                            boolean unused2 = ShowLocalPicGridActivity.this.isEditing = false;
                            ShowLocalPicGridActivity.this.layoutDel.setVisibility(8);
                        } else {
                            boolean z = true;
                            for (int i = 0; i < ShowLocalPicGridActivity.this.delPics.size() && z; i++) {
                                if (((Integer) ((Map) ShowLocalPicGridActivity.this.delPics.get(i)).get("status")).intValue() == 1) {
                                    z = false;
                                }
                            }
                            if (z) {
                                boolean unused3 = ShowLocalPicGridActivity.this.isEditing = false;
                                ShowLocalPicGridActivity.this.layoutDel.setVisibility(8);
                            }
                        }
                        if (ShowLocalPicGridActivity.this.progressDialog != null && ShowLocalPicGridActivity.this.progressDialog.isShowing()) {
                            ShowLocalPicGridActivity.this.progressDialog.cancel();
                        }
                        ShowLocalPicGridActivity.this.mAdapter.notifyDataSetChanged();
                        super.onPostExecute(voidR);
                    }
                }.execute(new Void[0]);
                return;
            case R.id.edit:
                if (this.isEditing) {
                    Log.e("##EditOnclick", "edit  ###");
                    this.btnEdit.setText(getResources().getString(R.string.main_edit));
                    this.layoutDel.setVisibility(8);
                    this.isEditing = false;
                    return;
                }
                this.btnEdit.setText(getResources().getString(R.string.done));
                this.layoutDel.setVisibility(0);
                this.isEditing = true;
                this.layoutDel.setVisibility(8);
                return;
            case R.id.selectall:
                ArrayList<Map<String, Object>> arrayPics2 = this.mAdapter.getArrayPics();
                while (i < arrayPics2.size()) {
                    Map map = arrayPics2.get(i);
                    Map map2 = arrayList.get(i);
                    if (((Integer) map.get("status")).intValue() != 1) {
                        map.put("status", 1);
                        map2.put("status", 1);
                    }
                    i++;
                }
                this.seletNum = arrayPics2.size();
                this.tvSelectSum.setText(String.valueOf(this.seletNum));
                this.mAdapter.notifyDataSetChanged();
                return;
            case R.id.selectreverse:
                ArrayList<Map<String, Object>> arrayPics3 = this.mAdapter.getArrayPics();
                this.seletNum = 0;
                while (i < arrayPics3.size()) {
                    Map map3 = arrayPics3.get(i);
                    Map map4 = arrayList.get(i);
                    int intValue = ((Integer) map3.get("status")).intValue();
                    if (intValue == 0) {
                        this.seletNum++;
                        map4.put("status", 1);
                        map3.put("status", 1);
                    } else if (intValue == 1) {
                        map3.put("status", 0);
                        map4.put("status", 0);
                    }
                    i++;
                }
                this.tvSelectSum.setText(String.valueOf(this.seletNum));
                this.mAdapter.notifyDataSetChanged();
                return;
            default:
                return;
        }
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        ProgressDialog progressDialog2 = this.progressDialog;
        if (progressDialog2 != null && progressDialog2.isShowing()) {
            this.progressDialog.cancel();
        }
        super.onPause();
    }

    private void getDataFromOther() {
        Intent intent = getIntent();
        this.strDID = intent.getStringExtra(DataBaseHelper.KEY_DID);
        this.strDate = intent.getStringExtra("date");
        this.strCameraName = intent.getStringExtra(ContentCommon.STR_CAMERA_NAME);
        this.aList = (ArrayList) intent.getSerializableExtra("list");
        arrayList = new ArrayList<>();
        int i = 0;
        if (this.aList.size() > 1000) {
            while (i < 1001) {
                HashMap hashMap = new HashMap();
                hashMap.put("path", this.aList.get(i));
                hashMap.put("status", 0);
                arrayList.add(hashMap);
                i++;
            }
            return;
        }
        while (i < this.aList.size()) {
            HashMap hashMap2 = new HashMap();
            hashMap2.put("path", this.aList.get(i));
            hashMap2.put("status", 0);
            arrayList.add(hashMap2);
            i++;
        }
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        Log.d("tag", "onItemClick");
        Log.d("tag", "this.position:" + this.position);
        if (!this.isEditing) {
            if (this.position != i) {
                this.position = -1;
                Intent intent = new Intent(this, ShowLocalPictureActivity.class);
                intent.putExtra(DataBaseHelper.KEY_DID, this.strDID);
                intent.putExtra("list", arrayList);
                intent.putExtra("date", this.strDate);
                intent.putExtra(RequestParameters.POSITION, i);
                intent.putExtra(ContentCommon.STR_CAMERA_NAME, this.strCameraName);
                startActivityForResult(intent, 1);
                return;
            }
            this.position = -1;
        } else if (this.position != i) {
            this.position = -1;
            Map map = this.mAdapter.getArrayPics().get(i);
            Map map2 = arrayList.get(i);
            if (((Integer) map.get("status")).intValue() == 0) {
                map.put("status", 1);
                map2.put("status", 1);
                this.seletNum++;
            } else {
                this.seletNum--;
                map.put("status", 0);
                map2.put("status", 0);
            }
            this.tvSelectSum.setText(String.valueOf(this.seletNum));
            this.mAdapter.notifyDataSetChanged();
            checkSelect();
        } else {
            this.position = -1;
        }
    }

    private void checkSelect() {
        int i = 0;
        while (i < arrayList.size()) {
            int intValue = ((Integer) arrayList.get(i).get("status")).intValue();
            Log.d("tag", "checkSelect status:" + intValue);
            if (intValue != 1) {
                i++;
            } else {
                return;
            }
        }
        this.tvSelectSum.setVisibility(8);
        this.layoutDel.setVisibility(8);
        this.isEditing = false;
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        this.bthread = false;
        super.onDestroy();
    }

    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        this.position = i;
        this.layoutDel.setVisibility(0);
        this.isEditing = true;
        Log.d("tag", "onItemLongClick");
        ArrayList<Map<String, Object>> arrayPics = this.mAdapter.getArrayPics();
        Map map = arrayList.get(i);
        Map map2 = arrayPics.get(i);
        int intValue = ((Integer) map2.get("status")).intValue();
        Log.d("tag", "status:" + intValue);
        if (intValue == 0) {
            this.seletNum++;
            map2.put("status", 1);
            map.put("status", 1);
        } else {
            this.seletNum--;
            map2.put("status", 0);
            map.put("status", 0);
        }
        this.tvSelectSum.setVisibility(0);
        this.tvSelectSum.setText(String.valueOf(this.seletNum));
        this.mAdapter.notifyDataSetChanged();
        checkSelect();
        return false;
    }

    public void delPic(String str, boolean z) {
        Log.d("tag", "ShowLocalPicGrid  path:" + str);
        if (!z) {
            ArrayList<Map<String, Object>> arrayPics = this.mAdapter.getArrayPics();
            for (int i = 0; i < arrayPics.size(); i++) {
                Map map = arrayPics.get(i);
                if (str.equals((String) map.get("path"))) {
                    map.clear();
                    arrayPics.remove(i);
                    arrayList.remove(i);
                    this.mAdapter.notifyDataSetChanged();
                    return;
                }
            }
            return;
        }
        this.mAdapter.clearAll();
        this.mAdapter.notifyDataSetChanged();
    }

    class MyThread extends Thread {
        MyThread() {
        }

        public void run() {
            for (int i = 0; i < ShowLocalPicGridActivity.arrayList.size() && ShowLocalPicGridActivity.this.bthread; i++) {
                String str = (String) ShowLocalPicGridActivity.arrayList.get(i).get("path");
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inSampleSize = 6;
                Bitmap access$900 = ShowLocalPicGridActivity.this.returnBitmap(BitmapFactory.decodeFile(str, options));
                if (access$900 != null) {
                    ShowLocalPicGridActivity.this.mAdapter.addBitmap(access$900, str, 0);
                    if (ShowLocalPicGridActivity.this.bthread) {
                        ShowLocalPicGridActivity.this.handler.sendEmptyMessage(1);
                    }
                }
            }
            super.run();
        }
    }
}
