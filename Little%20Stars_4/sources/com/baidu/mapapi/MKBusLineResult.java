package com.baidu.mapapi;

public class MKBusLineResult {
    private String a;
    private String b;
    private int c;
    private String d;
    private String e;
    private MKRoute f = new MKRoute();

    /* access modifiers changed from: package-private */
    public void a(String str) {
        this.d = str;
    }

    /* access modifiers changed from: package-private */
    public void a(String str, String str2, int i) {
        this.a = str;
        this.b = str2;
        this.c = i;
    }

    /* access modifiers changed from: package-private */
    public void b(String str) {
        this.e = str;
    }

    public String getBusCompany() {
        return this.a;
    }

    public String getBusName() {
        return this.b;
    }

    public MKRoute getBusRoute() {
        return this.f;
    }

    public String getEndTime() {
        return this.e;
    }

    public String getStartTime() {
        return this.d;
    }

    public MKStep getStation(int i) {
        return this.f.getStep(i);
    }

    public int isMonTicket() {
        return this.c;
    }
}
