package com.shix.shixipc.bean;

import java.io.Serializable;

public class SdcardBean implements Serializable {
    private static final long serialVersionUID = 1;
    private String did;
    private int record_conver_enable;
    private int record_sd_status;
    private int record_size;
    private int record_time_enable;
    private int record_timer;
    private int record_void_enable;
    private int sdfree;
    private int sdtotal;

    public static long getSerialversionuid() {
        return 1;
    }

    public int getRecord_void_enable() {
        return this.record_void_enable;
    }

    public void setRecord_void_enable(int i) {
        this.record_void_enable = i;
    }

    public String getDid() {
        return this.did;
    }

    public void setDid(String str) {
        this.did = str;
    }

    public int getRecord_conver_enable() {
        return this.record_conver_enable;
    }

    public void setRecord_conver_enable(int i) {
        this.record_conver_enable = i;
    }

    public int getRecord_timer() {
        return this.record_timer;
    }

    public void setRecord_timer(int i) {
        this.record_timer = i;
    }

    public int getRecord_size() {
        return this.record_size;
    }

    public void setRecord_size(int i) {
        this.record_size = i;
    }

    public int getRecord_time_enable() {
        return this.record_time_enable;
    }

    public void setRecord_time_enable(int i) {
        this.record_time_enable = i;
    }

    public int getRecord_sd_status() {
        return this.record_sd_status;
    }

    public void setRecord_sd_status(int i) {
        this.record_sd_status = i;
    }

    public int getSdtotal() {
        return this.sdtotal;
    }

    public void setSdtotal(int i) {
        this.sdtotal = i;
    }

    public int getSdfree() {
        return this.sdfree;
    }

    public void setSdfree(int i) {
        this.sdfree = i;
    }
}
