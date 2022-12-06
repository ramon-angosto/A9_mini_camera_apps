package com.shix.shixipc.widget;

public class DateVo {
    int day;
    boolean hasVedio;
    boolean isSelect;
    int month;
    int year;

    public int getYear() {
        return this.year;
    }

    public void setYear(int i) {
        this.year = i;
    }

    public int getMonth() {
        return this.month;
    }

    public void setMonth(int i) {
        this.month = i;
    }

    public int getDay() {
        return this.day;
    }

    public void setDay(int i) {
        this.day = i;
    }

    public boolean isHasVedio() {
        return this.hasVedio;
    }

    public void setHasVedio(boolean z) {
        this.hasVedio = z;
    }

    public boolean isSelect() {
        return this.isSelect;
    }

    public void setSelect(boolean z) {
        this.isSelect = z;
    }
}
