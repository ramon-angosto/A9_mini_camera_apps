package com.huawei.hms.api;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.view.View;
import com.huawei.hms.api.Api;
import com.huawei.hms.common.internal.AutoLifecycleFragment;
import com.huawei.hms.common.internal.Preconditions;
import com.huawei.hms.support.api.client.AidlApiClient;
import com.huawei.hms.support.api.client.PendingResult;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.api.client.SubAppInfo;
import com.huawei.hms.support.api.entity.auth.PermissionInfo;
import com.huawei.hms.support.api.entity.auth.Scope;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.huawei.hms.support.hianalytics.HiAnalyticsUtil;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.Checker;
import com.huawei.hms.utils.HMSBIInitializer;
import com.huawei.hms.utils.ResourceLoaderUtil;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public abstract class HuaweiApiClient implements AidlApiClient {

    public interface ConnectionCallbacks {
        public static final int CAUSE_API_CLIENT_EXPIRED = 3;
        public static final int CAUSE_NETWORK_LOST = 2;
        public static final int CAUSE_SERVICE_DISCONNECTED = 1;

        void onConnected();

        void onConnectionSuspended(int i);
    }

    public interface OnConnectionFailedListener {
        void onConnectionFailed(ConnectionResult connectionResult);
    }

    public abstract void checkUpdate(Activity activity, CheckUpdatelistener checkUpdatelistener);

    public void connect(int i) {
        throw new UnsupportedOperationException();
    }

    public abstract void connect(Activity activity);

    public abstract void connectForeground();

    public abstract void disableLifeCycleManagement(Activity activity);

    public abstract PendingResult<Status> discardAndReconnect();

    public abstract void disconnect();

    public abstract Map<Api<?>, Api.ApiOptions> getApiMap();

    public abstract ConnectionResult getConnectionResult(Api<?> api);

    public abstract List<PermissionInfo> getPermissionInfos();

    public abstract List<Scope> getScopes();

    public abstract Activity getTopActivity();

    public abstract boolean hasConnectedApi(Api<?> api);

    public abstract boolean hasConnectionFailureListener(OnConnectionFailedListener onConnectionFailedListener);

    public abstract boolean hasConnectionSuccessListener(ConnectionCallbacks connectionCallbacks);

    public abstract ConnectionResult holdUpConnect();

    public abstract ConnectionResult holdUpConnect(long j, TimeUnit timeUnit);

    public abstract boolean isConnected();

    public abstract boolean isConnecting();

    public abstract void onPause(Activity activity);

    public abstract void onResume(Activity activity);

    public abstract void print(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);

    public abstract void reconnect();

    public abstract void removeConnectionFailureListener(OnConnectionFailedListener onConnectionFailedListener);

    public abstract void removeConnectionSuccessListener(ConnectionCallbacks connectionCallbacks);

    public abstract void setConnectionCallbacks(ConnectionCallbacks connectionCallbacks);

    public abstract void setConnectionFailedListener(OnConnectionFailedListener onConnectionFailedListener);

    public abstract boolean setSubAppInfo(SubAppInfo subAppInfo);

    public static final class Builder {

        /* renamed from: a */
        private final Context f281a;

        /* renamed from: b */
        private final List<Scope> f282b = new ArrayList();

        /* renamed from: c */
        private final List<PermissionInfo> f283c = new ArrayList();

        /* renamed from: d */
        private final Map<Api<?>, Api.ApiOptions> f284d = new HashMap();

        /* renamed from: e */
        private OnConnectionFailedListener f285e;

        /* renamed from: f */
        private ConnectionCallbacks f286f;

        /* renamed from: g */
        private int f287g;

        /* renamed from: h */
        private Activity f288h;

        public Builder(Context context) throws NullPointerException {
            Checker.checkNonNull(context, "context must not be null.");
            this.f281a = context.getApplicationContext();
            this.f287g = -1;
            ResourceLoaderUtil.setmContext(this.f281a);
            m210a(context);
        }

        /* renamed from: a */
        private void m210a(Context context) {
            HMSBIInitializer.getInstance(context).initBI();
        }

        public Builder addApi(Api<? extends Api.ApiOptions.NotRequiredOptions> api) {
            this.f284d.put(api, (Object) null);
            if (HuaweiApiAvailability.HMS_API_NAME_GAME.equals(api.getApiName())) {
                HiAnalyticsUtil instance = HiAnalyticsUtil.getInstance();
                Context applicationContext = this.f281a.getApplicationContext();
                instance.onEvent(applicationContext, HiAnalyticsConstant.KeyAndValue.GAME_INIT_KEY, HiAnalyticsConstant.REPORT_VAL_SEPARATOR + System.currentTimeMillis());
            }
            return this;
        }

        public Builder addApiWithScope(Api<? extends Api.ApiOptions.NotRequiredOptions> api, Scope... scopeArr) {
            Checker.checkNonNull(api, "Api must not be null");
            Checker.checkNonNull(scopeArr, "Scopes must not be null");
            this.f284d.put(api, (Object) null);
            this.f282b.addAll(new ArrayList(Arrays.asList(scopeArr)));
            return this;
        }

        public Builder addConnectionCallbacks(ConnectionCallbacks connectionCallbacks) {
            Checker.checkNonNull(connectionCallbacks, "listener must not be null.");
            this.f286f = connectionCallbacks;
            return this;
        }

        public Builder addOnConnectionFailedListener(OnConnectionFailedListener onConnectionFailedListener) {
            Checker.checkNonNull(onConnectionFailedListener, "listener must not be null.");
            this.f285e = onConnectionFailedListener;
            return this;
        }

        public Builder addScope(Scope scope) {
            Checker.checkNonNull(scope, "scope must not be null.");
            this.f282b.add(scope);
            return this;
        }

        public Builder allowLifeCycleManagement(Activity activity, int i, OnConnectionFailedListener onConnectionFailedListener) {
            if (i >= 0) {
                this.f287g = i;
                this.f288h = (Activity) Preconditions.checkNotNull(activity, "activity must not be Null.");
                return this;
            }
            throw new IllegalArgumentException("allowLifeCycleManagement id should be positive");
        }

        public Builder applyDefaultAccount() {
            return this;
        }

        public HuaweiApiClient build() {
            addApi(new Api("Core.API"));
            HuaweiApiClientImpl huaweiApiClientImpl = new HuaweiApiClientImpl(this.f281a);
            huaweiApiClientImpl.setScopes(this.f282b);
            huaweiApiClientImpl.setPermissionInfos(this.f283c);
            huaweiApiClientImpl.setApiMap(this.f284d);
            huaweiApiClientImpl.setConnectionCallbacks(this.f286f);
            huaweiApiClientImpl.setConnectionFailedListener(this.f285e);
            huaweiApiClientImpl.setAutoLifecycleClientId(this.f287g);
            if (this.f287g >= 0) {
                m211a((HuaweiApiClient) huaweiApiClientImpl);
            }
            return huaweiApiClientImpl;
        }

        public Builder setAccountName(String str) {
            return this;
        }

        public Builder setHandler(Handler handler) {
            return this;
        }

        public Builder setPopupsGravity(int i) {
            return this;
        }

        public Builder setViewForPopups(View view) {
            return this;
        }

        /* renamed from: a */
        private void m211a(HuaweiApiClient huaweiApiClient) {
            AutoLifecycleFragment instance = AutoLifecycleFragment.getInstance(this.f288h);
            if (instance == null) {
                HMSLog.m1377e("HuaweiApiClient.builder", "lifecycleFragment must not be NULL here");
            } else {
                instance.startAutoMange(this.f287g, huaweiApiClient);
            }
        }

        public Builder allowLifeCycleManagement(Activity activity, OnConnectionFailedListener onConnectionFailedListener) {
            return allowLifeCycleManagement(activity, 0, onConnectionFailedListener);
        }

        public <O extends Api.ApiOptions.HasOptions> Builder addApiWithScope(Api<O> api, O o, Scope... scopeArr) {
            Checker.checkNonNull(api, "Api must not be null");
            Checker.checkNonNull(o, "Null options are not permitted for this Api");
            Checker.checkNonNull(scopeArr, "Scopes must not be null");
            this.f284d.put(api, o);
            if (api.getOptions() != null) {
                this.f282b.addAll(api.getOptions().getScopeList(o));
                this.f283c.addAll(api.getOptions().getPermissionInfoList(o));
            }
            this.f282b.addAll(new ArrayList(Arrays.asList(scopeArr)));
            return this;
        }

        public <O extends Api.ApiOptions.HasOptions> Builder addApi(Api<O> api, O o) {
            Checker.checkNonNull(api, "Api must not be null");
            Checker.checkNonNull(o, "Null options are not permitted for this Api");
            this.f284d.put(api, o);
            if (api.getOptions() != null) {
                this.f282b.addAll(api.getOptions().getScopeList(o));
                this.f283c.addAll(api.getOptions().getPermissionInfoList(o));
            }
            return this;
        }
    }
}
