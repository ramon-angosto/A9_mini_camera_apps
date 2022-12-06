package object.p2pipcam.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.jxl.app.littlestars.project.R;
import java.util.ArrayList;
import object.p2pipcam.bean.CameraParamsBean;

public class AlarmActivityAdapter extends BaseAdapter {
    private Context context1;
    private ViewHolder holder;
    private LayoutInflater inflater;
    private ArrayList<CameraParamsBean> list = null;

    public long getItemId(int i) {
        return (long) i;
    }

    public AlarmActivityAdapter(Context context, ArrayList<CameraParamsBean> arrayList) {
        this.context1 = context;
        this.list = arrayList;
        this.inflater = LayoutInflater.from(context);
    }

    public int getCount() {
        return this.list.size();
    }

    public Object getItem(int i) {
        return Integer.valueOf(i);
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        int i2;
        if (view == null) {
            view = this.inflater.inflate(R.layout.alarmactivity_listitem, (ViewGroup) null);
            this.holder = new ViewHolder();
            this.holder.name = (TextView) view.findViewById(R.id.tv_name);
            this.holder.did = (TextView) view.findViewById(R.id.tv_did);
            view.setTag(this.holder);
        } else {
            this.holder = (ViewHolder) view.getTag();
        }
        CameraParamsBean cameraParamsBean = this.list.get(i);
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
        this.holder.name.setText(cameraParamsBean.getName());
        TextView textView = this.holder.did;
        textView.setText(cameraParamsBean.getDid() + "(" + this.context1.getResources().getString(i2) + ")");
        return view;
    }

    public CameraParamsBean getItemCam(int i) {
        return this.list.get(i);
    }

    private class ViewHolder {
        TextView did;
        TextView name;

        private ViewHolder() {
        }
    }
}
