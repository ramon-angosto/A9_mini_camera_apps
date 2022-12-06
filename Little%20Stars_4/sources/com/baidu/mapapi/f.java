package com.baidu.mapapi;

import android.content.Context;
import android.location.GpsSatellite;
import android.location.GpsStatus;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.wifi.ScanResult;
import android.os.Bundle;
import android.telephony.NeighboringCellInfo;
import android.util.Log;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import java.util.List;

class f {
    Location a = null;
    /* access modifiers changed from: private */
    public LocationManager b = null;
    private LocationListener c = null;
    /* access modifiers changed from: private */
    public Context d;
    private a e = null;
    /* access modifiers changed from: private */
    public int f = 0;
    /* access modifiers changed from: private */
    public GpsStatus g;

    private class a implements GpsStatus.Listener {
        private a() {
        }

        public void onGpsStatusChanged(int i) {
            if (i == 2) {
                Mj.UpdataGPS(0.0d, 0.0d, 0.0f, 0.0f, 0.0f, 0);
            } else if (i == 4) {
                if (f.this.b == null) {
                    f fVar = f.this;
                    LocationManager unused = fVar.b = (LocationManager) fVar.d.getSystemService(RequestParameters.SUBRESOURCE_LOCATION);
                }
                if (f.this.b != null) {
                    if (f.this.g == null) {
                        f fVar2 = f.this;
                        GpsStatus unused2 = fVar2.g = fVar2.b.getGpsStatus((GpsStatus) null);
                    } else {
                        f.this.b.getGpsStatus(f.this.g);
                    }
                }
                int i2 = 0;
                for (GpsSatellite usedInFix : f.this.g.getSatellites()) {
                    if (usedInFix.usedInFix()) {
                        i2++;
                    }
                }
                if (i2 < 3 && f.this.f >= 3) {
                    Mj.UpdataGPS(0.0d, 0.0d, 0.0f, 0.0f, 0.0f, 0);
                }
                int unused3 = f.this.f = i2;
            }
        }
    }

    public f(Context context) {
        this.d = context;
    }

    /* access modifiers changed from: package-private */
    public String a(int i, int i2, int i3, int i4, List<NeighboringCellInfo> list, String str) {
        if (i3 == 0 || i4 == 0) {
            return "";
        }
        return str.concat(String.format("%d|%d|%d|%d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}));
    }

    public String a(List<ScanResult> list, String str) {
        String str2;
        String str3;
        int size = list.size();
        if (list.size() > 10) {
            size = 10;
        }
        String str4 = "";
        for (int i = 0; i < size; i++) {
            if (i == 0) {
                if (list.get(i).level == 0) {
                } else {
                    str3 = str4.concat(list.get(i).BSSID.replace(":", ""));
                    str2 = String.format(";%d;", new Object[]{Integer.valueOf(list.get(i).level)});
                }
            } else if (list.get(i).level == 0) {
                break;
            } else {
                str3 = str4.concat("|").concat(list.get(i).BSSID.replace(":", ""));
                str2 = String.format(";%d;", new Object[]{Integer.valueOf(list.get(i).level)});
            }
            str4 = str3.concat(str2).concat(list.get(i).SSID);
        }
        return str4;
    }

    /* access modifiers changed from: package-private */
    public void a() {
        if (this.d != null) {
            Mj.UpdataGPS(0.0d, 0.0d, 0.0f, 0.0f, 0.0f, 0);
            if (this.c == null) {
                this.c = new LocationListener() {
                    public void onLocationChanged(Location location) {
                        if (location != null) {
                            Bundle extras = location.getExtras();
                            int i = extras != null ? extras.getInt("NumSatellite", 0) : 0;
                            float accuracy = location.hasAccuracy() ? location.getAccuracy() : 0.0f;
                            double longitude = location.getLongitude();
                            double latitude = location.getLatitude();
                            double speed = (double) location.getSpeed();
                            Double.isNaN(speed);
                            Mj.UpdataGPS(longitude, latitude, (float) (speed * 3.6d), location.getBearing(), accuracy, i);
                            f.this.a = location;
                        }
                    }

                    public void onProviderDisabled(String str) {
                        Mj.UpdataGPS(0.0d, 0.0d, 0.0f, 0.0f, 0.0f, 0);
                        f.this.a = null;
                    }

                    public void onProviderEnabled(String str) {
                    }

                    public void onStatusChanged(String str, int i, Bundle bundle) {
                        if (i == 0 || i == 1) {
                            Mj.UpdataGPS(0.0d, 0.0d, 0.0f, 0.0f, 0.0f, 0);
                            f.this.a = null;
                        }
                    }
                };
            }
            if (this.b == null) {
                this.b = (LocationManager) this.d.getSystemService(RequestParameters.SUBRESOURCE_LOCATION);
            }
            LocationManager locationManager = this.b;
            if (locationManager != null) {
                try {
                    locationManager.requestLocationUpdates("gps", 1000, 0.0f, this.c);
                    this.e = new a();
                    this.b.addGpsStatusListener(this.e);
                } catch (Exception e2) {
                    Log.d("InitGPS", e2.getMessage());
                }
            }
        }
    }

    public void a(int i, int i2, long j) {
        if (i == 5000) {
            if (i2 == 1) {
                a();
            } else {
                b();
            }
        }
    }

    public void a(List<ScanResult> list) {
        int size = list.size() - 1;
        boolean z = true;
        while (size >= 1 && z) {
            int i = 0;
            boolean z2 = false;
            while (i < size) {
                int i2 = i + 1;
                if (list.get(i).level < list.get(i2).level) {
                    list.set(i2, list.get(i));
                    list.set(i, list.get(i2));
                    z2 = true;
                }
                i = i2;
            }
            size--;
            z = z2;
        }
    }

    public boolean a(List<ScanResult> list, List<ScanResult> list2) {
        if (list == list2) {
            return true;
        }
        if (!(list == null || list2 == null)) {
            int size = list.size();
            int size2 = list2.size();
            if (!(size == 0 || size2 == 0)) {
                int i = 0;
                for (int i2 = 0; i2 < size; i2++) {
                    String str = list.get(i2).BSSID;
                    if (str != null) {
                        int i3 = 0;
                        while (true) {
                            if (i3 >= size2) {
                                break;
                            } else if (str.equals(list2.get(i3).BSSID)) {
                                i++;
                                break;
                            } else {
                                i3++;
                            }
                        }
                    }
                }
                if (i >= size / 2) {
                    return true;
                }
            }
        }
        return false;
    }

    public String b(List<ScanResult> list, String str) {
        int size = list.size();
        if (list.size() > 10) {
            size = 10;
        }
        String str2 = "";
        for (int i = 0; i < size; i++) {
            if (i == 0) {
                if (list.get(i).level == 0) {
                }
            } else if (list.get(i).level == 0) {
                break;
            } else {
                str2 = str2.concat("|");
            }
            str2 = str2.concat(list.get(i).BSSID.replace(":", ""));
        }
        return str2;
    }

    /* access modifiers changed from: package-private */
    public void b() {
        try {
            if (this.b != null) {
                this.b.removeUpdates(this.c);
            }
        } catch (Exception e2) {
            Log.d("UnInitGPS", e2.getMessage());
        }
        Mj.UpdataGPS(0.0d, 0.0d, 0.0f, 0.0f, 0.0f, 0);
    }
}
