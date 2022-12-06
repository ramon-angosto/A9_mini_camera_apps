package com.huawei.hms.api;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.Fragment;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Build;
import android.os.Bundle;
import com.huawei.hmf.tasks.Task;
import com.huawei.hmf.tasks.TaskCompletionSource;
import com.huawei.hms.activity.BridgeActivity;
import com.huawei.hms.activity.EnableServiceActivity;
import com.huawei.hms.activity.ForegroundIntentBuilder;
import com.huawei.hms.activity.internal.BusResponseCallback;
import com.huawei.hms.activity.internal.BusResponseResult;
import com.huawei.hms.adapter.internal.CommonCode;
import com.huawei.hms.api.Api;
import com.huawei.hms.common.ErrorDialogFragment;
import com.huawei.hms.common.HuaweiApi;
import com.huawei.hms.common.api.AvailabilityException;
import com.huawei.hms.common.api.HuaweiApiCallable;
import com.huawei.hms.common.internal.ConnectionErrorMessages;
import com.huawei.hms.common.internal.DialogRedirect;
import com.huawei.hms.common.internal.Preconditions;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.update.manager.UpdateManager;
import com.huawei.hms.update.p024ui.UpdateBean;
import com.huawei.hms.utils.Checker;
import com.huawei.hms.utils.HMSPackageManager;
import com.huawei.hms.utils.PackageManagerHelper;
import com.huawei.hms.utils.ResourceLoaderUtil;
import com.huawei.hms.utils.Util;

/* renamed from: com.huawei.hms.api.b */
/* compiled from: HuaweiApiAvailabilityImpl */
final class C0629b extends HuaweiApiAvailability {

    /* renamed from: b */
    private static final C0629b f342b = new C0629b();

    /* renamed from: com.huawei.hms.api.b$a */
    /* compiled from: HuaweiApiAvailabilityImpl */
    class C0630a implements BusResponseCallback {

        /* renamed from: a */
        final /* synthetic */ TaskCompletionSource[] f343a;

        C0630a(C0629b bVar, TaskCompletionSource[] taskCompletionSourceArr) {
            this.f343a = taskCompletionSourceArr;
        }

        public BusResponseResult innerError(Activity activity, int i, String str) {
            HMSLog.m1377e("HuaweiApiAvailabilityImpl", "Test foreground bus error: resultCode " + i + ", errMessage" + str);
            this.f343a[0].setException(new AvailabilityException());
            return null;
        }

        public BusResponseResult succeedReturn(Activity activity, int i, Intent intent) {
            HMSLog.m1379i("HuaweiApiAvailabilityImpl", "Test foreground bus success: resultCode " + i + ", data" + intent);
            return null;
        }
    }

    private C0629b() {
    }

    /* renamed from: a */
    private static Intent m254a(Activity activity, String str) {
        return BridgeActivity.getIntentStartBridgeActivity(activity, str);
    }

    public static C0629b getInstance() {
        return f342b;
    }

    /* renamed from: b */
    public PendingIntent mo13212b(Context context, int i) {
        HMSLog.m1379i("HuaweiApiAvailabilityImpl", "Enter getResolveErrorPendingIntent, errorCode: " + i);
        Intent a = mo13211a(context, i);
        if (a != null) {
            return PendingIntent.getActivity(context, 0, a, 134217728);
        }
        return null;
    }

    public Task<Void> checkApiAccessible(HuaweiApi<?> huaweiApi, HuaweiApi<?>... huaweiApiArr) {
        Task<Void> task = new TaskCompletionSource().getTask();
        if (huaweiApi != null) {
            try {
                m257a((Object) huaweiApi);
            } catch (AvailabilityException e) {
                HMSLog.m1379i("HuaweiApiAvailabilityImpl", "checkApi has AvailabilityException " + e.getMessage());
            }
        }
        if (huaweiApiArr != null) {
            for (HuaweiApi<?> a : huaweiApiArr) {
                m257a((Object) a);
            }
        }
        return task;
    }

    public PendingIntent getErrPendingIntent(Context context, ConnectionResult connectionResult) {
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(connectionResult);
        return mo13212b(context, connectionResult.getErrorCode());
    }

    public Dialog getErrorDialog(Activity activity, int i, int i2) {
        Checker.checkNonNull(activity, "activity must not be null.");
        HMSLog.m1379i("HuaweiApiAvailabilityImpl", "Enter getErrorDialog, errorCode: " + i);
        return getErrorDialog(activity, i, i2, (DialogInterface.OnCancelListener) null);
    }

    public String getErrorString(int i) {
        HMSLog.m1379i("HuaweiApiAvailabilityImpl", "Enter getErrorString, errorCode: " + i);
        return ConnectionResult.m209a(i);
    }

    public Task<Void> getHuaweiServicesReady(Activity activity) {
        Preconditions.checkNotNull(activity);
        TaskCompletionSource[] taskCompletionSourceArr = {new TaskCompletionSource()};
        Task<Void> task = taskCompletionSourceArr[0].getTask();
        int isHuaweiMobileServicesAvailable = isHuaweiMobileServicesAvailable(activity.getApplicationContext(), 30000000);
        Intent resolveErrorIntent = getResolveErrorIntent(activity, isHuaweiMobileServicesAvailable);
        Intent intentStartBridgeActivity = BridgeActivity.getIntentStartBridgeActivity(activity, ResolutionDelegate.class.getName());
        if (resolveErrorIntent != null) {
            ForegroundIntentBuilder.registerResponseCallback(ResolutionDelegate.CALLBACK_METHOD, new C0630a(this, taskCompletionSourceArr));
            Bundle bundle = new Bundle();
            bundle.putParcelable(CommonCode.MapKey.HAS_RESOLUTION, resolveErrorIntent);
            intentStartBridgeActivity.putExtras(bundle);
            activity.startActivity(intentStartBridgeActivity);
        } else if (isHuaweiMobileServicesAvailable == 3) {
            Intent intent = new Intent();
            intent.setClass(activity, EnableServiceActivity.class);
            activity.startActivity(intent);
        } else if (isHuaweiMobileServicesAvailable == 0) {
            HMSLog.m1379i("HuaweiApiAvailabilityImpl", "The HMS service is available.");
        } else {
            HMSLog.m1377e("HuaweiApiAvailabilityImpl", "Framework can not solve the availability problem.");
            taskCompletionSourceArr[0].setException(new AvailabilityException());
        }
        return task;
    }

    public Intent getResolveErrorIntent(Activity activity, int i) {
        HMSLog.m1379i("HuaweiApiAvailabilityImpl", "Enter getResolveErrorIntent, errorCode: " + i);
        if (!Util.isAvailableLibExist(activity.getApplicationContext())) {
            return null;
        }
        if (i == 1 || i == 2) {
            UpdateBean updateBean = new UpdateBean();
            updateBean.setHmsOrApkUpgrade(true);
            updateBean.setClientPackageName(HMSPackageManager.getInstance(activity.getApplicationContext()).getHMSPackageName());
            updateBean.setClientVersionCode(HuaweiApiAvailability.getServicesVersionCode());
            updateBean.setClientAppId("C10132067");
            if (ResourceLoaderUtil.getmContext() == null) {
                ResourceLoaderUtil.setmContext(activity.getApplicationContext());
            }
            updateBean.setClientAppName(ResourceLoaderUtil.getString("hms_update_title"));
            return UpdateManager.getStartUpdateIntent(activity, updateBean);
        } else if (i != 6) {
            return null;
        } else {
            return m254a(activity, BindingFailedResolution.class.getName());
        }
    }

    public PendingIntent getResolveErrorPendingIntent(Activity activity, int i) {
        HMSLog.m1379i("HuaweiApiAvailabilityImpl", "Enter getResolveErrorPendingIntent, errorCode: " + i);
        Intent resolveErrorIntent = getResolveErrorIntent(activity, i);
        if (resolveErrorIntent != null) {
            return PendingIntent.getActivity(activity, 0, resolveErrorIntent, 134217728);
        }
        return null;
    }

    public int isHuaweiMobileNoticeAvailable(Context context) {
        Checker.checkNonNull(context, "context must not be null.");
        if (PackageManagerHelper.PackageStates.NOT_INSTALLED.equals(new PackageManagerHelper(context).getPackageStates(HMSPackageManager.getInstance(context).getHMSPackageName()))) {
            return 1;
        }
        return HMSPackageManager.getInstance(context).isApkUpdateNecessary(20600000) ? 2 : 0;
    }

    public int isHuaweiMobileServicesAvailable(Context context) {
        Checker.checkNonNull(context, "context must not be null.");
        return HuaweiMobileServicesUtil.isHuaweiMobileServicesAvailable(context, HuaweiApiAvailability.getServicesVersionCode());
    }

    public boolean isUserResolvableError(int i) {
        return isUserResolvableError(i, (PendingIntent) null);
    }

    public boolean isUserResolvableError(int i, PendingIntent pendingIntent) {
        if (i == 0) {
            return false;
        }
        return pendingIntent != null || i == 1 || i == 2 || i == 6;
    }

    public void popupErrNotification(Context context, ConnectionResult connectionResult) {
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(connectionResult);
        showErrorNotification(context, connectionResult.getErrorCode());
    }

    public void resolveError(Activity activity, int i, int i2) {
        resolveError(activity, i, i2, (PendingIntent) null);
    }

    public boolean showErrorDialogFragment(Activity activity, int i, int i2) {
        return showErrorDialogFragment(activity, i, i2, (DialogInterface.OnCancelListener) null);
    }

    public void showErrorNotification(Context context, int i) {
        Checker.checkNonNull(context, "context must not be null.");
        HMSLog.m1379i("HuaweiApiAvailabilityImpl", "Enter showErrorNotification, errorCode: " + i);
        Dialog errorDialog = getErrorDialog((Activity) context, i, 0);
        if (errorDialog == null) {
            HMSLog.m1379i("HuaweiApiAvailabilityImpl", "showErrorNotification errorDialog can not be null");
        } else {
            errorDialog.show();
        }
    }

    /* renamed from: a */
    private static Intent m255a(Context context, String str) {
        return BridgeActivity.getIntentStartBridgeActivity(context, str);
    }

    public void resolveError(Activity activity, int i, int i2, PendingIntent pendingIntent) {
        Checker.checkNonNull(activity, "activity must not be null.");
        if (pendingIntent != null) {
            HMSLog.m1379i("HuaweiApiAvailabilityImpl", "Enter resolveError, param pendingIntent is not null. and.errorCode: " + i);
        } else {
            HMSLog.m1379i("HuaweiApiAvailabilityImpl", "Enter resolveError, param pendingIntent is  null. get pendingIntent from error code.and.errorCode: " + i);
            pendingIntent = getResolveErrorPendingIntent(activity, i);
        }
        if (pendingIntent != null) {
            HMSLog.m1379i("HuaweiApiAvailabilityImpl", "In resolveError, start pingding intent.errorCode: " + i);
            try {
                activity.startIntentSenderForResult(pendingIntent.getIntentSender(), i2, (Intent) null, 0, 0, 0);
            } catch (IntentSender.SendIntentException unused) {
                HMSLog.m1377e("HuaweiApiAvailabilityImpl", "Enter resolveError, start pendingIntent failed.errorCode: " + i);
            }
        }
    }

    public boolean showErrorDialogFragment(Activity activity, int i, int i2, DialogInterface.OnCancelListener onCancelListener) {
        Dialog errorDialog = getErrorDialog(activity, i, i2, onCancelListener);
        if (errorDialog == null) {
            return false;
        }
        m256a(activity, errorDialog, HuaweiMobileServicesUtil.HMS_ERROR_DIALOG, onCancelListener);
        return true;
    }

    /* renamed from: a */
    public Intent mo13211a(Context context, int i) {
        HMSLog.m1379i("HuaweiApiAvailabilityImpl", "Enter getResolveErrorIntent, errorCode: " + i);
        if (i == 1 || i == 2) {
            UpdateBean updateBean = new UpdateBean();
            updateBean.setHmsOrApkUpgrade(true);
            updateBean.setClientPackageName(HMSPackageManager.getInstance(context.getApplicationContext()).getHMSPackageName());
            updateBean.setClientVersionCode(HuaweiApiAvailability.getServicesVersionCode());
            updateBean.setClientAppId("C10132067");
            if (ResourceLoaderUtil.getmContext() == null) {
                ResourceLoaderUtil.setmContext(context.getApplicationContext());
            }
            updateBean.setClientAppName(ResourceLoaderUtil.getString("hms_update_title"));
            return UpdateManager.getStartUpdateIntent(context, updateBean);
        } else if (i != 6) {
            return null;
        } else {
            return m255a(context, BindingFailedResolution.class.getName());
        }
    }

    public Dialog getErrorDialog(Activity activity, int i, int i2, DialogInterface.OnCancelListener onCancelListener) {
        Checker.checkNonNull(activity, "activity must not be null.");
        HMSLog.m1379i("HuaweiApiAvailabilityImpl", "Enter getErrorDialog, errorCode: " + i);
        return m252a(activity, i, DialogRedirect.getInstance(activity, m253a(activity, i), i2), onCancelListener);
    }

    public PendingIntent getErrPendingIntent(Context context, int i, int i2) {
        HMSLog.m1379i("HuaweiApiAvailabilityImpl", "Enter getResolveErrorPendingIntent, errorCode: " + i + " requestCode: " + i2);
        Intent a = mo13211a(context, i);
        if (a != null) {
            return PendingIntent.getActivity(context, i2, a, 134217728);
        }
        return null;
    }

    public int isHuaweiMobileServicesAvailable(Context context, int i) {
        Checker.checkNonNull(context, "context must not be null.");
        return HuaweiMobileServicesUtil.isHuaweiMobileServicesAvailable(context, i);
    }

    public boolean showErrorDialogFragment(Activity activity, int i, Fragment fragment, int i2, DialogInterface.OnCancelListener onCancelListener) {
        return showErrorDialogFragment(activity, i, i2, onCancelListener);
    }

    public Task<Void> checkApiAccessible(HuaweiApiCallable huaweiApiCallable, HuaweiApiCallable... huaweiApiCallableArr) {
        Task<Void> task = new TaskCompletionSource().getTask();
        if (huaweiApiCallable != null) {
            try {
                m257a((Object) huaweiApiCallable);
            } catch (AvailabilityException e) {
                HMSLog.m1379i("HuaweiApiAvailabilityImpl", "HuaweiApiCallable checkApi has AvailabilityException " + e.getMessage());
            }
        }
        if (huaweiApiCallableArr != null) {
            for (HuaweiApiCallable a : huaweiApiCallableArr) {
                m257a((Object) a);
            }
        }
        return task;
    }

    /* renamed from: a */
    private Intent m253a(Activity activity, int i) {
        if (!Util.isAvailableLibExist(activity.getApplicationContext())) {
            return null;
        }
        if (i == 1 || i == 2) {
            return UpdateManager.startUpdateIntent(activity);
        }
        if (i != 6) {
            return null;
        }
        return BridgeActivity.getIntentStartBridgeActivity(activity, BindingFailedResolution.class.getName());
    }

    /* renamed from: a */
    protected static int m250a(Activity activity) {
        return (m251a((Context) activity) == 0 || Build.VERSION.SDK_INT < 16) ? 3 : 0;
    }

    /* renamed from: a */
    private static int m251a(Context context) {
        if (context == null) {
            return 0;
        }
        return context.getResources().getIdentifier("androidhwext:style/Theme.Emui", (String) null, (String) null);
    }

    /* renamed from: a */
    private static Dialog m252a(Activity activity, int i, DialogRedirect dialogRedirect, DialogInterface.OnCancelListener onCancelListener) {
        if (i == 0) {
            return null;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(activity, m250a(activity));
        builder.setMessage(ConnectionErrorMessages.getErrorMessage(activity, i));
        if (onCancelListener != null) {
            builder.setOnCancelListener(onCancelListener);
        }
        builder.setPositiveButton(ConnectionErrorMessages.getErrorDialogButtonMessage(activity, i), dialogRedirect);
        String errorTitle = ConnectionErrorMessages.getErrorTitle(activity, i);
        if (errorTitle != null) {
            builder.setTitle(errorTitle);
        }
        return builder.create();
    }

    /* renamed from: a */
    private static void m256a(Activity activity, Dialog dialog, String str, DialogInterface.OnCancelListener onCancelListener) {
        Checker.checkNonNull(activity, "activity must not be null.");
        ErrorDialogFragment.newInstance(dialog, onCancelListener).show(activity.getFragmentManager(), str);
    }

    /* renamed from: a */
    private void m257a(Object obj) throws AvailabilityException {
        ConnectionResult connectionResult;
        AvailabilityException availabilityException = new AvailabilityException();
        if (obj instanceof HuaweiApi) {
            connectionResult = availabilityException.getConnectionResult((HuaweiApi<? extends Api.ApiOptions>) (HuaweiApi) obj);
        } else {
            connectionResult = availabilityException.getConnectionResult((HuaweiApiCallable) obj);
        }
        if (connectionResult.getErrorCode() != 0) {
            HMSLog.m1379i("HuaweiApiAvailabilityImpl", "The service is unavailable: " + availabilityException.getMessage());
            throw availabilityException;
        }
    }
}
