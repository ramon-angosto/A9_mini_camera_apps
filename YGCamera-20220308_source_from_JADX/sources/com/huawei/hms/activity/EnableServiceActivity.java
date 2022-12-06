package com.huawei.hms.activity;

import android.app.Activity;
import android.os.Bundle;
import com.huawei.hms.base.p013ui.C0688R;

public class EnableServiceActivity extends Activity {
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        setContentView(C0688R.layout.activity_endisable_service);
    }
}
