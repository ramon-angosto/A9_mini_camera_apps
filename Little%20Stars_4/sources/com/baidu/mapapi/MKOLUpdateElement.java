package com.baidu.mapapi;

public class MKOLUpdateElement {
    public static final int DOWNLOADING = 1;
    public static final int FINISHED = 4;
    public static final int SUSPENDED = 3;
    public static final int UNDEFINED = 0;
    public static final int WAITING = 2;
    public int cityID;
    public String cityName;
    public GeoPoint geoPt;
    public int ratio;
    public int serversize;
    public int size;
    public int status;
    public boolean update;
}
