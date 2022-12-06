package com.shix.shixipc.order;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.shix.qhipc.R;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class OrderAdapter extends BaseAdapter {
    private Context context;
    private ViewHolder holder;
    private LayoutInflater inflater;
    private List<OrderModel> listDates = new ArrayList();
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public long getItemId(int i) {
        return (long) i;
    }

    public OrderAdapter(Context context2) {
        this.context = context2;
        this.inflater = LayoutInflater.from(this.context);
    }

    public int getCount() {
        return this.listDates.size();
    }

    public Object getItem(int i) {
        return Integer.valueOf(i);
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            View inflate = this.inflater.inflate(R.layout.order_listitem, (ViewGroup) null);
            this.holder = new ViewHolder();
            this.holder.name = (TextView) inflate.findViewById(R.id.tv_name);
            this.holder.did = (TextView) inflate.findViewById(R.id.tv_did);
            this.holder.status = (TextView) inflate.findViewById(R.id.tv_status);
            this.holder.imgSnapShot = (ImageView) inflate.findViewById(R.id.imgSnapshot);
            inflate.setTag(this.holder);
            return inflate;
        }
        this.holder = (ViewHolder) view.getTag();
        return view;
    }

    public OrderModel getItemCam(int i) {
        return this.listDates.get(i);
    }

    private class ViewHolder {
        TextView did;
        ImageView imgSnapShot;
        TextView name;
        TextView status;

        private ViewHolder() {
        }
    }
}
