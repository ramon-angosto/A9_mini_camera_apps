package com.baidu.mapapi;

import android.content.Context;
import android.util.Log;
import java.io.IOException;

public class BMapManager {
    static Context b = null;
    static boolean c = false;
    Mj a = null;

    public BMapManager(Context context) {
        b = context;
    }

    private Mj getMj() {
        return this.a;
    }

    public void destroy() {
        if (c) {
            stop();
        }
        c = false;
        if (this.a != null) {
            if (Mj.f != null) {
                try {
                    Mj.f.close();
                    Mj.f = null;
                } catch (IOException e) {
                    Log.d("baidumap", e.getMessage());
                    Mj.f = null;
                }
            }
            this.a.UnInitMapApiEngine();
            this.a = null;
        }
    }

    public MKLocationManager getLocationManager() {
        return Mj.b;
    }

    public boolean init(String str, MKGeneralListener mKGeneralListener) {
        if (str == null) {
            return false;
        }
        c = false;
        if (getMj() != null) {
            return false;
        }
        this.a = new Mj(this, b);
        if (!this.a.a(str, mKGeneralListener)) {
            this.a = null;
            return false;
        }
        if (Mj.b.a(this)) {
            Mj.b.b();
        }
        d.a(b);
        s.a().a(b);
        return true;
    }

    public boolean start() {
        if (c) {
            return true;
        }
        Mj mj = this.a;
        if (mj == null || !mj.a()) {
            return false;
        }
        c = true;
        return true;
    }

    public boolean stop() {
        if (!c) {
            return true;
        }
        Mj mj = this.a;
        if (mj == null || !mj.b()) {
            return false;
        }
        c = false;
        return true;
    }
}
