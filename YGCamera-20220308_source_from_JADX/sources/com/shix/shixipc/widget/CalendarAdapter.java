package com.shix.shixipc.widget;

import android.app.Activity;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;
import shix.cykj.camera.R;

public class CalendarAdapter extends RecyclerView.Adapter<ViewHolder> {
    static OnItemClickListenr listenr;
    Activity activity;
    int mMonth;
    List<DateVo> vos = new ArrayList();

    public interface OnItemClickListenr {
        void onItemClick(DateVo dateVo);
    }

    public CalendarAdapter(Activity activity2) {
        this.activity = activity2;
    }

    public void setDatas(List<DateVo> list) {
        this.vos.clear();
        this.vos.addAll(list);
        notifyDataSetChanged();
    }

    public void setmMonth(int i) {
        this.mMonth = i;
    }

    public void setListenr(OnItemClickListenr onItemClickListenr) {
        listenr = onItemClickListenr;
    }

    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(this.activity).inflate(R.layout.layout_calendar_item, viewGroup, false));
    }

    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        DateVo dateVo = this.vos.get(i);
        TextView textView = viewHolder.mTvDay;
        textView.setText(dateVo.getDay() + "");
        if (this.mMonth == dateVo.getMonth()) {
            viewHolder.mTvDay.setTextColor(Color.parseColor("#000000"));
        } else {
            viewHolder.mTvDay.setTextColor(Color.parseColor("#aaaaaa"));
        }
        if (dateVo.isHasVedio()) {
            viewHolder.mTvDay.setBackgroundDrawable(this.activity.getResources().getDrawable(R.drawable.bg_for_calender_vedio));
            viewHolder.mTvDay.setTextColor(Color.parseColor("#ffffff"));
            if (dateVo.isSelect()) {
                viewHolder.mTvDay.setBackgroundDrawable(this.activity.getResources().getDrawable(R.drawable.bg_for_calender_select));
                viewHolder.mTvDay.setTextColor(Color.parseColor("#ffffff"));
            }
        }
        viewHolder.mTvDay.setOnClickListener(new OnclickListener(dateVo));
    }

    public int getItemCount() {
        return this.vos.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView mTvDay;

        public ViewHolder(View view) {
            super(view);
            this.mTvDay = (TextView) view.findViewById(R.id.tv_calendar_day);
        }
    }

    static class OnclickListener implements View.OnClickListener {

        /* renamed from: vo */
        DateVo f1573vo;

        public OnclickListener(DateVo dateVo) {
            this.f1573vo = dateVo;
        }

        public void onClick(View view) {
            CalendarAdapter.listenr.onItemClick(this.f1573vo);
        }
    }
}
