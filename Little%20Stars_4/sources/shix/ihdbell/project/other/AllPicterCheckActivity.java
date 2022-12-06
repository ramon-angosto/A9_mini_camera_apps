package shix.ihdbell.project.other;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.util.DisplayMetrics;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.jxl.app.littlestars.project.R;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import object.p2pipcam.content.ContentCommon;
import object.p2pipcam.gridview.PullToRefreshBase;
import object.p2pipcam.gridview.PullToRefreshGridView;
import object.p2pipcam.utils.DataBaseHelper;
import shix.ihdbell.project.BaseActivity;
import shix.ihdbell.project.ShowLocalPictureActivity;

public class AllPicterCheckActivity extends BaseActivity {
    /* access modifiers changed from: private */
    public static ArrayList<Map<String, Object>> arrayList;
    /* access modifiers changed from: private */
    public GridAdapter adapter = null;
    private Button button_back = null;
    /* access modifiers changed from: private */
    public ProgressDialog dialog = null;
    /* access modifiers changed from: private */
    public GridView gridView = null;
    /* access modifiers changed from: private */
    public AdapterView.AdapterContextMenuInfo info = null;
    /* access modifiers changed from: private */
    public List<String> listpath = null;
    /* access modifiers changed from: private */
    public PullToRefreshGridView mPullRefreshGridView;
    /* access modifiers changed from: private */
    public ProgressBar progressBar = null;
    /* access modifiers changed from: private */
    public TextView textView = null;

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        setContentView(R.layout.sdcard_picter);
        this.mPullRefreshGridView = (PullToRefreshGridView) findViewById(R.id.sdcard_gridview);
        this.gridView = (GridView) this.mPullRefreshGridView.getRefreshableView();
        this.progressBar = (ProgressBar) findViewById(R.id.pict_progressBar1);
        this.button_back = (Button) findViewById(R.id.back);
        this.textView = (TextView) findViewById(R.id.picter_sum);
        getWindowManager().getDefaultDisplay().getMetrics(new DisplayMetrics());
        new MyAsySelect().execute(new Void[0]);
        this.gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                Intent intent = new Intent(AllPicterCheckActivity.this, ShowLocalPictureActivity.class);
                intent.putExtra(DataBaseHelper.KEY_DID, "");
                intent.putExtra("list", AllPicterCheckActivity.arrayList);
                intent.putExtra("date", "");
                intent.putExtra(RequestParameters.POSITION, i);
                intent.putExtra(ContentCommon.STR_CAMERA_NAME, "");
                AllPicterCheckActivity.this.startActivityForResult(intent, 1);
            }
        });
        this.button_back.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AllPicterCheckActivity.this.finish();
                AllPicterCheckActivity.this.overridePendingTransition(R.anim.out_to_right, R.anim.in_from_left);
            }
        });
        registerForContextMenu(this.gridView);
        this.mPullRefreshGridView.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener() {
            public void onRefresh() {
                new GetDataTask().execute(new Void[0]);
            }
        });
    }

    /* access modifiers changed from: private */
    public void getDataFromOther() {
        arrayList = new ArrayList<>();
        for (int i = 0; i < this.listpath.size(); i++) {
            HashMap hashMap = new HashMap();
            hashMap.put("path", this.listpath.get(i));
            hashMap.put("status", 0);
            arrayList.add(hashMap);
        }
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        contextMenu.setHeaderTitle(getResources().getString(R.string.exit_show));
        contextMenu.add(0, 2, 0, getResources().getString(R.string.exit_qu));
        contextMenu.add(0, 7, 0, getResources().getString(R.string.exit_qu_show));
    }

    public boolean onContextItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == 2) {
            this.info = (AdapterView.AdapterContextMenuInfo) menuItem.getMenuInfo();
            new AsyncTask<Void, Void, Void>() {
                /* access modifiers changed from: protected */
                public Void doInBackground(Void... voidArr) {
                    new File((String) AllPicterCheckActivity.this.listpath.get(AllPicterCheckActivity.this.info.position)).delete();
                    AllPicterCheckActivity.arrayList.remove(AllPicterCheckActivity.this.info.position);
                    AllPicterCheckActivity.this.listpath.remove(AllPicterCheckActivity.this.info.position);
                    return null;
                }

                /* access modifiers changed from: protected */
                public void onPostExecute(Void voidR) {
                    AllPicterCheckActivity allPicterCheckActivity = AllPicterCheckActivity.this;
                    GridAdapter unused = allPicterCheckActivity.adapter = new GridAdapter(allPicterCheckActivity, allPicterCheckActivity.listpath);
                    AllPicterCheckActivity.this.gridView.setAdapter(AllPicterCheckActivity.this.adapter);
                    TextView access$600 = AllPicterCheckActivity.this.textView;
                    access$600.setText(AllPicterCheckActivity.this.listpath.size() + "");
                    Toast.makeText(AllPicterCheckActivity.this.getApplicationContext(), AllPicterCheckActivity.this.getResources().getString(R.string.delect_sucss), 0).show();
                }
            }.execute(new Void[0]);
        }
        return false;
    }

    class MyAsySelect extends AsyncTask<Void, Void, Void> {
        MyAsySelect() {
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            super.onPreExecute();
            AllPicterCheckActivity allPicterCheckActivity = AllPicterCheckActivity.this;
            ProgressDialog unused = allPicterCheckActivity.dialog = new ProgressDialog(allPicterCheckActivity);
            AllPicterCheckActivity.this.dialog.setMessage("");
            AllPicterCheckActivity.this.dialog.show();
        }

        /* access modifiers changed from: protected */
        public Void doInBackground(Void... voidArr) {
            List unused = AllPicterCheckActivity.this.listpath = new FindImage(Environment.getExternalStorageDirectory() + "/IPcamer/pic").getList();
            return null;
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(Void voidR) {
            super.onPostExecute(voidR);
            if (AllPicterCheckActivity.this.listpath.size() != 0) {
                AllPicterCheckActivity allPicterCheckActivity = AllPicterCheckActivity.this;
                GridAdapter unused = allPicterCheckActivity.adapter = new GridAdapter(allPicterCheckActivity, allPicterCheckActivity.listpath);
                AllPicterCheckActivity.this.gridView.setAdapter(AllPicterCheckActivity.this.adapter);
                AllPicterCheckActivity.this.gridView.setSelector(R.drawable.grid_select_no);
                AllPicterCheckActivity.this.textView.setVisibility(0);
                TextView access$600 = AllPicterCheckActivity.this.textView;
                access$600.setText(AllPicterCheckActivity.this.listpath.size() + "");
                AllPicterCheckActivity.this.dialog.cancel();
                AllPicterCheckActivity.this.getDataFromOther();
                AllPicterCheckActivity.this.progressBar.setVisibility(8);
                return;
            }
            AllPicterCheckActivity.this.dialog.cancel();
            AllPicterCheckActivity.this.progressBar.setVisibility(8);
            AllPicterCheckActivity.this.showToast("");
        }
    }

    private class GetDataTask extends AsyncTask<Void, Void, Void> {
        private GetDataTask() {
        }

        /* access modifiers changed from: protected */
        public Void doInBackground(Void... voidArr) {
            if (AllPicterCheckActivity.this.adapter.count <= AllPicterCheckActivity.this.listpath.size() - 20) {
                AllPicterCheckActivity.this.adapter.count += 20;
            } else if (20 > AllPicterCheckActivity.this.listpath.size() - AllPicterCheckActivity.this.adapter.count) {
                AllPicterCheckActivity.this.adapter.count = AllPicterCheckActivity.this.listpath.size();
            }
            try {
                Thread.sleep(1000);
                return null;
            } catch (InterruptedException e) {
                e.printStackTrace();
                return null;
            }
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(Void voidR) {
            if (AllPicterCheckActivity.this.listpath.size() == AllPicterCheckActivity.this.adapter.count) {
                AllPicterCheckActivity.this.showToast("");
            }
            AllPicterCheckActivity.this.adapter.notifyDataSetChanged();
            AllPicterCheckActivity.this.mPullRefreshGridView.onRefreshComplete();
            super.onPostExecute(voidR);
        }
    }
}
