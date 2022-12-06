package com.google.android.gms.ads;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.ads.internal.client.zzaw;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzbzc;
import com.google.android.gms.internal.ads.zzcgp;

/* compiled from: com.google.android.gms:play-services-ads-lite@@21.3.0 */
public final class AdActivity extends Activity {
    public static final String CLASS_NAME = "com.google.android.gms.ads.AdActivity";
    private zzbzc zza;

    private final void zza() {
        zzbzc zzbzc = this.zza;
        if (zzbzc != null) {
            try {
                zzbzc.zzv();
            } catch (RemoteException e) {
                zzcgp.zzl("#007 Could not call remote method.", e);
            }
        }
    }

    /* access modifiers changed from: protected */
    public final void onActivityResult(int i, int i2, Intent intent) {
        try {
            zzbzc zzbzc = this.zza;
            if (zzbzc != null) {
                zzbzc.zzg(i, i2, intent);
            }
        } catch (Exception e) {
            zzcgp.zzl("#007 Could not call remote method.", e);
        }
        super.onActivityResult(i, i2, intent);
    }

    public final void onBackPressed() {
        try {
            zzbzc zzbzc = this.zza;
            if (zzbzc != null && !zzbzc.zzE()) {
                return;
            }
        } catch (RemoteException e) {
            zzcgp.zzl("#007 Could not call remote method.", e);
        }
        super.onBackPressed();
        try {
            zzbzc zzbzc2 = this.zza;
            if (zzbzc2 != null) {
                zzbzc2.zzh();
            }
        } catch (RemoteException e2) {
            zzcgp.zzl("#007 Could not call remote method.", e2);
        }
    }

    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        try {
            zzbzc zzbzc = this.zza;
            if (zzbzc != null) {
                zzbzc.zzj(ObjectWrapper.wrap(configuration));
            }
        } catch (RemoteException e) {
            zzcgp.zzl("#007 Could not call remote method.", e);
        }
    }

    /* access modifiers changed from: protected */
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.zza = zzaw.zza().zzn(this);
        zzbzc zzbzc = this.zza;
        if (zzbzc != null) {
            try {
                zzbzc.zzk(bundle);
            } catch (RemoteException e) {
                zzcgp.zzl("#007 Could not call remote method.", e);
                finish();
            }
        } else {
            zzcgp.zzl("#007 Could not call remote method.", (Throwable) null);
            finish();
        }
    }

    /* access modifiers changed from: protected */
    public final void onDestroy() {
        try {
            zzbzc zzbzc = this.zza;
            if (zzbzc != null) {
                zzbzc.zzl();
            }
        } catch (RemoteException e) {
            zzcgp.zzl("#007 Could not call remote method.", e);
        }
        super.onDestroy();
    }

    /* access modifiers changed from: protected */
    public final void onPause() {
        try {
            zzbzc zzbzc = this.zza;
            if (zzbzc != null) {
                zzbzc.zzn();
            }
        } catch (RemoteException e) {
            zzcgp.zzl("#007 Could not call remote method.", e);
            finish();
        }
        super.onPause();
    }

    /* access modifiers changed from: protected */
    public final void onRestart() {
        super.onRestart();
        try {
            zzbzc zzbzc = this.zza;
            if (zzbzc != null) {
                zzbzc.zzo();
            }
        } catch (RemoteException e) {
            zzcgp.zzl("#007 Could not call remote method.", e);
            finish();
        }
    }

    /* access modifiers changed from: protected */
    public final void onResume() {
        super.onResume();
        try {
            zzbzc zzbzc = this.zza;
            if (zzbzc != null) {
                zzbzc.zzp();
            }
        } catch (RemoteException e) {
            zzcgp.zzl("#007 Could not call remote method.", e);
            finish();
        }
    }

    /* access modifiers changed from: protected */
    public final void onSaveInstanceState(Bundle bundle) {
        try {
            zzbzc zzbzc = this.zza;
            if (zzbzc != null) {
                zzbzc.zzq(bundle);
            }
        } catch (RemoteException e) {
            zzcgp.zzl("#007 Could not call remote method.", e);
            finish();
        }
        super.onSaveInstanceState(bundle);
    }

    /* access modifiers changed from: protected */
    public final void onStart() {
        super.onStart();
        try {
            zzbzc zzbzc = this.zza;
            if (zzbzc != null) {
                zzbzc.zzr();
            }
        } catch (RemoteException e) {
            zzcgp.zzl("#007 Could not call remote method.", e);
            finish();
        }
    }

    /* access modifiers changed from: protected */
    public final void onStop() {
        try {
            zzbzc zzbzc = this.zza;
            if (zzbzc != null) {
                zzbzc.zzs();
            }
        } catch (RemoteException e) {
            zzcgp.zzl("#007 Could not call remote method.", e);
            finish();
        }
        super.onStop();
    }

    /* access modifiers changed from: protected */
    public final void onUserLeaveHint() {
        super.onUserLeaveHint();
        try {
            zzbzc zzbzc = this.zza;
            if (zzbzc != null) {
                zzbzc.zzt();
            }
        } catch (RemoteException e) {
            zzcgp.zzl("#007 Could not call remote method.", e);
        }
    }

    public final void setContentView(int i) {
        super.setContentView(i);
        zza();
    }

    public final void setContentView(View view) {
        super.setContentView(view);
        zza();
    }

    public final void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        super.setContentView(view, layoutParams);
        zza();
    }
}
