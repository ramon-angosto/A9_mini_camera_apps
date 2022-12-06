package com.baidu.mapapi.cloud;

public class DetailSearchInfo {
    public String ak;
    public int id;
    public int scope = 1;
    public String sn;
    public int timeStamp = 0;

    /* access modifiers changed from: package-private */
    public String a() {
        if (this.id == 0) {
            return null;
        }
        StringBuilder sb = new StringBuilder("/");
        sb.append(this.id);
        sb.append('?');
        sb.append("scope=");
        sb.append(this.scope);
        if (this.ak != null) {
            sb.append("&ak=");
            sb.append(this.ak);
        }
        if (this.sn != null) {
            sb.append("&sn=");
            sb.append(this.sn);
            sb.append("&timestamp=");
            sb.append(this.timeStamp);
        }
        return sb.toString();
    }
}
