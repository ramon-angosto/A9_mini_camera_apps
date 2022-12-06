package com.baidu.mapapi.cloud;

import android.content.ContentValues;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Map;

public class RegionSearchInfo {
    public String ak;
    public int cityID;
    public String cityName;
    public ContentValues filter = new ContentValues();
    public int pageIndex = 0;
    public int pageSize = 10;
    public String queryWords;
    public int scope = 1;
    public String sn;
    public int timeStamp = 0;

    /* access modifiers changed from: package-private */
    public String a() {
        if (this.queryWords == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder("?");
        if (this.queryWords != null) {
            try {
                sb.append("q=");
                sb.append(URLEncoder.encode(this.queryWords, "UTF-8"));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        if (this.cityID != 0) {
            sb.append("&region=");
            sb.append(this.cityID);
        } else if (this.cityName != null) {
            try {
                sb.append("&region=");
                sb.append(URLEncoder.encode(this.cityName, "UTF-8"));
            } catch (UnsupportedEncodingException e2) {
                e2.printStackTrace();
            }
        }
        if (this.filter.size() > 0) {
            sb.append("&filter=");
            Iterator<Map.Entry<String, Object>> it = this.filter.valueSet().iterator();
            if (it.hasNext()) {
                Map.Entry next = it.next();
                Object value = next.getValue();
                sb.append((String) next.getKey());
                while (true) {
                    sb.append(':');
                    sb.append(value);
                    if (!it.hasNext()) {
                        break;
                    }
                    Map.Entry next2 = it.next();
                    value = next2.getValue();
                    sb.append('|');
                    sb.append((String) next2.getKey());
                }
            }
        }
        sb.append("&page_index=");
        sb.append(this.pageIndex);
        sb.append("&scope=");
        sb.append(this.scope);
        sb.append("&page_size=");
        sb.append(this.pageSize);
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
