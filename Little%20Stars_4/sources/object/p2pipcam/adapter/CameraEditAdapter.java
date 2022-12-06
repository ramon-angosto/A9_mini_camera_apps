package object.p2pipcam.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import com.jxl.app.littlestars.project.R;
import java.util.ArrayList;
import java.util.Iterator;
import object.p2pipcam.bean.CameraParamsBean;
import object.p2pipcam.system.SystemValue;

public class CameraEditAdapter extends BaseAdapter {
    public boolean hasSelect = false;
    private ViewHolder holder;
    private LayoutInflater inflater;
    /* access modifiers changed from: private */
    public int selectCount = 0;

    public long getItemId(int i) {
        return (long) i;
    }

    static /* synthetic */ int access$108(CameraEditAdapter cameraEditAdapter) {
        int i = cameraEditAdapter.selectCount;
        cameraEditAdapter.selectCount = i + 1;
        return i;
    }

    static /* synthetic */ int access$110(CameraEditAdapter cameraEditAdapter) {
        int i = cameraEditAdapter.selectCount;
        cameraEditAdapter.selectCount = i - 1;
        return i;
    }

    public CameraEditAdapter(Context context) {
        this.inflater = LayoutInflater.from(context);
    }

    public int getCount() {
        return SystemValue.arrayList.size();
    }

    public Object getItem(int i) {
        return Integer.valueOf(i);
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = this.inflater.inflate(R.layout.camera_edit_listitem, (ViewGroup) null);
            this.holder = new ViewHolder();
            this.holder.cbx = (CheckBox) view.findViewById(R.id.camera_edit_cbx);
            this.holder.tvID = (TextView) view.findViewById(R.id.camera_id);
            this.holder.tvName = (TextView) view.findViewById(R.id.camera_name);
            view.setTag(this.holder);
        } else {
            this.holder = (ViewHolder) view.getTag();
        }
        this.holder.cbx.setOnCheckedChangeListener(new MyCheckListener(i));
        CameraParamsBean cameraParamsBean = SystemValue.arrayList.get(i);
        this.holder.tvID.setText(cameraParamsBean.getDid());
        this.holder.tvName.setText(cameraParamsBean.getName());
        if (cameraParamsBean.isSelected()) {
            this.holder.cbx.setChecked(true);
        } else {
            this.holder.cbx.setChecked(false);
        }
        return view;
    }

    public boolean modifyCamera(String str, String str2, String str3, String str4, String str5) {
        Iterator<CameraParamsBean> it = SystemValue.arrayList.iterator();
        while (it.hasNext()) {
            CameraParamsBean next = it.next();
            if (next.getDid().equals(str)) {
                next.setName(str3);
                next.setUser(str4);
                next.setDid(str2);
                next.setPwd(str5);
                next.setAuthority(false);
                return true;
            }
        }
        return false;
    }

    public void selectAll(boolean z) {
        Iterator<CameraParamsBean> it = SystemValue.arrayList.iterator();
        while (it.hasNext()) {
            it.next().setSelected(true);
        }
    }

    public void reverseSelect(boolean z) {
        int size = SystemValue.arrayList.size();
        for (int i = 0; i < size; i++) {
            CameraParamsBean cameraParamsBean = SystemValue.arrayList.get(i);
            if (cameraParamsBean.isSelected()) {
                cameraParamsBean.setSelected(false);
            } else {
                cameraParamsBean.setSelected(true);
            }
        }
    }

    public void addCamera(String str, String str2, String str3, String str4) {
        if (checkRepeatID(str2)) {
            CameraParamsBean cameraParamsBean = new CameraParamsBean();
            cameraParamsBean.setDid(str2);
            cameraParamsBean.setName(str);
            cameraParamsBean.setUser(str3);
            cameraParamsBean.setPwd(str4);
            cameraParamsBean.setSelected(false);
            cameraParamsBean.setAuthority(false);
            SystemValue.arrayList.add(cameraParamsBean);
        }
    }

    public ArrayList<String> delCameraSize() {
        ArrayList<String> arrayList = new ArrayList<>();
        Iterator<CameraParamsBean> it = SystemValue.arrayList.iterator();
        while (it.hasNext()) {
            CameraParamsBean next = it.next();
            boolean isSelected = next.isSelected();
            String did = next.getDid();
            if (isSelected) {
                arrayList.add(did);
            }
        }
        return arrayList;
    }

    public ArrayList<String> delCamera() {
        ArrayList<String> arrayList = new ArrayList<>();
        Iterator<CameraParamsBean> it = SystemValue.arrayList.iterator();
        while (it.hasNext()) {
            CameraParamsBean next = it.next();
            boolean isSelected = next.isSelected();
            String did = next.getDid();
            if (isSelected) {
                arrayList.add(did);
            }
        }
        for (int i = 0; i < arrayList.size(); i++) {
            String str = arrayList.get(i);
            boolean z = true;
            int i2 = 0;
            while (i < SystemValue.arrayList.size() && z) {
                if (str.equals(SystemValue.arrayList.get(i2).getDid())) {
                    SystemValue.arrayList.remove(i2);
                    z = false;
                }
                i2++;
            }
        }
        return arrayList;
    }

    public CameraParamsBean getItemCamera(int i) {
        return SystemValue.arrayList.get(i);
    }

    private boolean checkRepeatID(String str) {
        Iterator<CameraParamsBean> it = SystemValue.arrayList.iterator();
        while (it.hasNext()) {
            if (it.next().getDid().equals(str)) {
                return false;
            }
        }
        return true;
    }

    private class MyCheckListener implements CompoundButton.OnCheckedChangeListener {
        private int position;

        public MyCheckListener(int i) {
            this.position = i;
        }

        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            CameraParamsBean cameraParamsBean = SystemValue.arrayList.get(this.position);
            if (z) {
                CameraEditAdapter cameraEditAdapter = CameraEditAdapter.this;
                cameraEditAdapter.hasSelect = true;
                CameraEditAdapter.access$108(cameraEditAdapter);
                cameraParamsBean.setSelected(true);
                return;
            }
            if (CameraEditAdapter.this.selectCount > 0) {
                CameraEditAdapter.access$110(CameraEditAdapter.this);
            }
            if (CameraEditAdapter.this.selectCount == 0) {
                CameraEditAdapter.this.hasSelect = false;
            }
            cameraParamsBean.setSelected(false);
        }
    }

    private class ViewHolder {
        CheckBox cbx;
        TextView tvID;
        TextView tvName;

        private ViewHolder() {
        }
    }
}
