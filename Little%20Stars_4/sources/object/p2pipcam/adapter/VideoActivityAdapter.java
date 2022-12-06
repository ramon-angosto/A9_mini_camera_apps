package object.p2pipcam.adapter;

import android.content.Context;
import android.support.v4.internal.view.SupportMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.jxl.app.littlestars.project.R;
import java.util.ArrayList;
import object.p2pipcam.bean.CameraParamsBean;

public class VideoActivityAdapter extends BaseAdapter {
    public final int PHONE = 1;
    public final int REMOTE = 2;
    private Context context;
    private ViewHolder holder;
    private LayoutInflater inflater;
    private boolean isOver = false;
    public int mode = 1;
    private ArrayList<CameraParamsBean> videoList = new ArrayList<>();

    public long getItemId(int i) {
        return (long) i;
    }

    public VideoActivityAdapter(Context context2, ArrayList<CameraParamsBean> arrayList) {
        this.context = context2;
        this.videoList = arrayList;
        this.inflater = LayoutInflater.from(context2);
    }

    public int getCount() {
        return this.videoList.size();
    }

    public Object getItem(int i) {
        return Integer.valueOf(i);
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        int i2;
        if (view == null) {
            view = this.inflater.inflate(R.layout.video_only_listitem, (ViewGroup) null);
            this.holder = new ViewHolder();
            this.holder.name = (TextView) view.findViewById(R.id.tv_name);
            this.holder.id = (TextView) view.findViewById(R.id.tv_did);
            this.holder.status = (TextView) view.findViewById(R.id.tv_status);
            this.holder.number = (TextView) view.findViewById(R.id.tv_pic_num);
            view.setTag(this.holder);
        } else {
            this.holder = (ViewHolder) view.getTag();
        }
        CameraParamsBean cameraParamsBean = this.videoList.get(i);
        int sum = cameraParamsBean.getSum();
        TextView textView = this.holder.number;
        textView.setText("(" + sum + ")");
        String did = cameraParamsBean.getDid();
        String name = cameraParamsBean.getName();
        int i3 = -1873408;
        switch (cameraParamsBean.getStatus()) {
            case 0:
                i2 = R.string.pppp_status_connecting;
                break;
            case 1:
                i2 = R.string.pppp_status_initialing;
                break;
            case 2:
                i2 = R.string.pppp_status_online;
                break;
            case 3:
                i2 = R.string.pppp_status_connect_failed;
                break;
            case 4:
                i2 = R.string.pppp_status_disconnect;
                break;
            case 5:
                i2 = R.string.pppp_status_invalid_id;
                break;
            case 6:
                i2 = R.string.device_not_on_line;
                break;
            case 7:
                i2 = R.string.pppp_status_connect_timeout;
                break;
            case 8:
                i2 = R.string.pppp_status_connect_log_errer;
                break;
            case 9:
                i2 = R.string.pppp_status_connect_user_login;
                break;
            case 10:
                i2 = R.string.pppp_status_connect_pwd_cuo;
                break;
            default:
                i2 = R.string.pppp_status_unknown;
                break;
        }
        i3 = SupportMenu.CATEGORY_MASK;
        this.holder.status.setText(i2);
        this.holder.status.setTextColor(i3);
        this.holder.id.setText(did);
        this.holder.name.setText(name);
        int i4 = this.mode;
        if (i4 == 1) {
            this.holder.number.setVisibility(0);
            this.holder.status.setVisibility(8);
        } else if (i4 == 2) {
            this.holder.number.setVisibility(8);
            this.holder.status.setVisibility(0);
        }
        return view;
    }

    public void setOver(boolean z) {
        this.isOver = z;
    }

    public int getMode() {
        return this.mode;
    }

    public void setMode(int i) {
        this.mode = i;
    }

    private class ViewHolder {
        TextView id;
        TextView name;
        TextView number;
        TextView status;

        private ViewHolder() {
        }
    }
}
