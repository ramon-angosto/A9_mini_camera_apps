package com.shix.shixipc.widget;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.shix.shixipc.widget.CalendarAdapter;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import shix.cykj.camera.R;

public class DialogForCalendar implements View.OnClickListener {
    static Activity activity;
    static DialogForCalendar instance;
    CalendarAdapter adapter;
    Calendar calendar;
    int currentMonth;
    int currentYear;
    List<DateVo> dates;
    AlertDialog dialog;
    Calendar mCalendar;
    LinearLayout mLinNext;
    LinearLayout mLinPre;
    TextView mTvYear;
    GridLayoutManager manager;
    int month;
    WindowManager.LayoutParams params;
    RecyclerView rcy_calendar;
    int selectDay;
    int selectMonth;
    int selectYear;
    String strDID;
    View viewRoot;
    int weekDay;
    int year;

    private DialogForCalendar(Activity activity2) {
        activity = activity2;
        initData();
    }

    public static DialogForCalendar getInstance(Activity activity2) {
        instance = new DialogForCalendar(activity2);
        return instance;
    }

    /* access modifiers changed from: package-private */
    public void initData() {
        this.manager = new GridLayoutManager(activity, 7);
        this.calendar = Calendar.getInstance();
        this.selectYear = this.calendar.get(1);
        this.selectMonth = this.calendar.get(2) + 1;
        this.selectDay = this.calendar.get(5);
        this.viewRoot = LayoutInflater.from(activity).inflate(R.layout.layout_dialog_calendar, (ViewGroup) null);
        this.adapter = new CalendarAdapter(activity);
        this.rcy_calendar = (RecyclerView) this.viewRoot.findViewById(R.id.rcv_calendar);
        this.mLinNext = (LinearLayout) this.viewRoot.findViewById(R.id.lin_next_day);
        this.mLinPre = (LinearLayout) this.viewRoot.findViewById(R.id.lin_previous_day);
        this.rcy_calendar.setLayoutManager(this.manager);
        this.rcy_calendar.setAdapter(this.adapter);
        this.mTvYear = (TextView) this.viewRoot.findViewById(R.id.tv_day_year);
        this.dates = new ArrayList();
        this.dialog = new AlertDialog.Builder(activity).create();
        this.params = this.dialog.getWindow().getAttributes();
        WindowManager.LayoutParams layoutParams = this.params;
        layoutParams.width = -2;
        layoutParams.height = -2;
        this.dialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
            public void onDismiss(DialogInterface dialogInterface) {
                DialogForCalendar.this.manager = null;
            }
        });
    }

    public void setStrDID(String str) {
        this.strDID = str;
    }

    public void showCalender() {
        LinearLayout linearLayout = this.mLinPre;
        if (linearLayout != null) {
            linearLayout.setOnClickListener(this);
        }
        LinearLayout linearLayout2 = this.mLinNext;
        if (linearLayout2 != null) {
            linearLayout2.setOnClickListener(this);
        }
        AlertDialog alertDialog = this.dialog;
        if (alertDialog != null) {
            alertDialog.show();
            this.dialog.getWindow().setAttributes(this.params);
            this.dialog.getWindow().getDecorView().setBackgroundColor(Color.parseColor("#00ffffff"));
        }
        if (this.viewRoot != null && !this.dialog.getWindow().hasChildren()) {
            this.dialog.setContentView(this.viewRoot);
        }
    }

    public void dismiss() {
        AlertDialog alertDialog = this.dialog;
        if (alertDialog != null && alertDialog.isShowing()) {
            this.dialog.dismiss();
        }
    }

    public void addOnItemClickListener(final CalendarAdapter.OnItemClickListenr onItemClickListenr) {
        this.adapter.setListenr(new CalendarAdapter.OnItemClickListenr() {
            public void onItemClick(DateVo dateVo) {
                DialogForCalendar.this.selectYear = dateVo.getYear();
                DialogForCalendar.this.selectMonth = dateVo.getMonth();
                DialogForCalendar.this.selectDay = dateVo.getDay();
                DialogForCalendar.this.setDate();
                CalendarAdapter.OnItemClickListenr onItemClickListenr = onItemClickListenr;
                if (onItemClickListenr != null) {
                    onItemClickListenr.onItemClick(dateVo);
                }
            }
        });
    }

    public void setDate() {
        this.dates.clear();
        this.mCalendar = (Calendar) this.calendar.clone();
        int i = this.mCalendar.get(1);
        int i2 = this.mCalendar.get(2) + 1;
        this.year = i;
        this.month = i2;
        this.currentYear = i;
        this.currentMonth = i2;
        TextView textView = this.mTvYear;
        if (textView != null) {
            textView.setText(i + Constants.ACCEPT_TIME_SEPARATOR_SERVER + String.format("%02d", new Object[]{Integer.valueOf(i2)}));
        }
        this.mCalendar.set(5, 1);
        this.weekDay = this.mCalendar.get(7) - 1;
        this.mCalendar.add(5, -this.weekDay);
        while (this.dates.size() < 42) {
            int i3 = this.mCalendar.get(1);
            int i4 = this.mCalendar.get(2) + 1;
            int i5 = this.mCalendar.get(5);
            DateVo dateVo = new DateVo();
            dateVo.setYear(i3);
            dateVo.setMonth(i4);
            dateVo.setDay(i5);
            if (i3 == this.selectYear && i4 == this.selectMonth && i5 == this.selectDay) {
                dateVo.setSelect(true);
            } else {
                dateVo.setSelect(false);
            }
            dateVo.setHasVedio(getd(i4, i5));
            this.dates.add(dateVo);
            this.mCalendar.add(5, 1);
        }
        this.adapter.setmMonth(i2);
        this.adapter.setDatas(this.dates);
    }

    private boolean getd(int i, int i2) {
        for (String next : VideoVo.keys) {
            if (i == Integer.parseInt(next.substring(5, 7)) && i2 == Integer.parseInt(next.substring(8, 10))) {
                return true;
            }
        }
        return false;
    }

    private void setData(boolean z) {
        this.mCalendar.set(1, this.year);
        this.mCalendar.set(2, this.month - 1);
        if (!z) {
            this.mCalendar.add(2, -1);
        } else if (this.currentYear != this.year) {
            this.mCalendar.add(2, 1);
        } else if (this.currentMonth > this.month) {
            this.mCalendar.add(2, 1);
        } else {
            return;
        }
        this.dates.clear();
        int i = this.mCalendar.get(1);
        int i2 = this.mCalendar.get(2) + 1;
        this.year = i;
        this.month = i2;
        TextView textView = this.mTvYear;
        if (textView != null) {
            textView.setText(i + Constants.ACCEPT_TIME_SEPARATOR_SERVER + String.format("%02d", new Object[]{Integer.valueOf(i2)}));
        }
        this.mCalendar.set(5, 1);
        this.weekDay = this.mCalendar.get(7) - 1;
        this.mCalendar.add(5, -this.weekDay);
        while (this.dates.size() < 42) {
            int i3 = this.mCalendar.get(1);
            int i4 = this.mCalendar.get(2) + 1;
            int i5 = this.mCalendar.get(5);
            DateVo dateVo = new DateVo();
            dateVo.setYear(i3);
            dateVo.setMonth(i4);
            dateVo.setDay(i5);
            dateVo.setHasVedio(getd(i4, i5));
            this.dates.add(dateVo);
            this.mCalendar.add(5, 1);
        }
        this.adapter.setmMonth(i2);
        this.adapter.setDatas(this.dates);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.lin_next_day /*2131165579*/:
                setData(true);
                return;
            case R.id.lin_previous_day /*2131165580*/:
                setData(false);
                return;
            default:
                return;
        }
    }
}
