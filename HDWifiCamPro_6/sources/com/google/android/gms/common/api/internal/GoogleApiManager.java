package com.google.android.gms.common.api.internal;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import androidx.collection.ArraySet;
import androidx.work.PeriodicWorkRequest;
import androidx.work.WorkRequest;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.HasApiKey;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.internal.GmsClientSupervisor;
import com.google.android.gms.common.internal.MethodInvocation;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.RootTelemetryConfigManager;
import com.google.android.gms.common.internal.RootTelemetryConfiguration;
import com.google.android.gms.common.internal.TelemetryData;
import com.google.android.gms.common.internal.TelemetryLogging;
import com.google.android.gms.common.internal.TelemetryLoggingClient;
import com.google.android.gms.common.internal.zal;
import com.google.android.gms.common.util.DeviceProperties;
import com.google.android.gms.internal.base.zaq;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.mbridge.msdk.playercommon.exoplayer2.DefaultRenderersFactory;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;
import org.checkerframework.checker.initialization.qual.NotOnlyInitialized;

/* compiled from: com.google.android.gms:play-services-base@@18.0.0 */
public class GoogleApiManager implements Handler.Callback {
    public static final Status zaa = new Status(4, "Sign-out occurred while this API call was in progress.");
    /* access modifiers changed from: private */
    public static final Status zab = new Status(4, "The user must be signed in to make this API call.");
    /* access modifiers changed from: private */
    public static final Object zac = new Object();
    private static GoogleApiManager zad;
    /* access modifiers changed from: private */
    public long zae = DefaultRenderersFactory.DEFAULT_ALLOWED_VIDEO_JOINING_TIME_MS;
    /* access modifiers changed from: private */
    public long zaf = 120000;
    /* access modifiers changed from: private */
    public long zag = WorkRequest.MIN_BACKOFF_MILLIS;
    /* access modifiers changed from: private */
    public boolean zah = false;
    private TelemetryData zai;
    private TelemetryLoggingClient zaj;
    /* access modifiers changed from: private */
    public final Context zak;
    /* access modifiers changed from: private */
    public final GoogleApiAvailability zal;
    /* access modifiers changed from: private */
    public final zal zam;
    private final AtomicInteger zan = new AtomicInteger(1);
    private final AtomicInteger zao = new AtomicInteger(0);
    /* access modifiers changed from: private */
    public final Map<ApiKey<?>, zabq<?>> zap = new ConcurrentHashMap(5, 0.75f, 1);
    /* access modifiers changed from: private */
    public zaae zaq = null;
    /* access modifiers changed from: private */
    public final Set<ApiKey<?>> zar = new ArraySet();
    private final Set<ApiKey<?>> zas = new ArraySet();
    /* access modifiers changed from: private */
    @NotOnlyInitialized
    public final Handler zat;
    /* access modifiers changed from: private */
    public volatile boolean zau = true;

    private GoogleApiManager(Context context, Looper looper, GoogleApiAvailability googleApiAvailability) {
        this.zak = context;
        this.zat = new zaq(looper, this);
        this.zal = googleApiAvailability;
        this.zam = new zal(googleApiAvailability);
        if (DeviceProperties.isAuto(context)) {
            this.zau = false;
        }
        Handler handler = this.zat;
        handler.sendMessage(handler.obtainMessage(6));
    }

    public static void reportSignOut() {
        synchronized (zac) {
            GoogleApiManager googleApiManager = zad;
            if (googleApiManager != null) {
                googleApiManager.zao.incrementAndGet();
                Handler handler = googleApiManager.zat;
                handler.sendMessageAtFrontOfQueue(handler.obtainMessage(10));
            }
        }
    }

    /* access modifiers changed from: private */
    public static Status zaH(ApiKey<?> apiKey, ConnectionResult connectionResult) {
        String zab2 = apiKey.zab();
        String valueOf = String.valueOf(connectionResult);
        StringBuilder sb = new StringBuilder(String.valueOf(zab2).length() + 63 + String.valueOf(valueOf).length());
        sb.append("API: ");
        sb.append(zab2);
        sb.append(" is not available on this device. Connection failed with: ");
        sb.append(valueOf);
        return new Status(connectionResult, sb.toString());
    }

    private final zabq<?> zaI(GoogleApi<?> googleApi) {
        ApiKey<?> apiKey = googleApi.getApiKey();
        zabq<?> zabq = this.zap.get(apiKey);
        if (zabq == null) {
            zabq = new zabq<>(this, googleApi);
            this.zap.put(apiKey, zabq);
        }
        if (zabq.zaz()) {
            this.zas.add(apiKey);
        }
        zabq.zao();
        return zabq;
    }

    private final TelemetryLoggingClient zaJ() {
        if (this.zaj == null) {
            this.zaj = TelemetryLogging.getClient(this.zak);
        }
        return this.zaj;
    }

    private final void zaK() {
        TelemetryData telemetryData = this.zai;
        if (telemetryData != null) {
            if (telemetryData.zaa() > 0 || zaF()) {
                zaJ().log(telemetryData);
            }
            this.zai = null;
        }
    }

    private final <T> void zaL(TaskCompletionSource<T> taskCompletionSource, int i, GoogleApi googleApi) {
        zacd zaa2;
        if (i != 0 && (zaa2 = zacd.zaa(this, i, googleApi.getApiKey())) != null) {
            Task<T> task = taskCompletionSource.getTask();
            Handler handler = this.zat;
            handler.getClass();
            task.addOnCompleteListener((Executor) new zabk(handler), (OnCompleteListener<T>) zaa2);
        }
    }

    public static GoogleApiManager zal() {
        GoogleApiManager googleApiManager;
        synchronized (zac) {
            Preconditions.checkNotNull(zad, "Must guarantee manager is non-null before using getInstance");
            googleApiManager = zad;
        }
        return googleApiManager;
    }

    public static GoogleApiManager zam(Context context) {
        GoogleApiManager googleApiManager;
        synchronized (zac) {
            if (zad == null) {
                zad = new GoogleApiManager(context.getApplicationContext(), GmsClientSupervisor.getOrStartHandlerThread().getLooper(), GoogleApiAvailability.getInstance());
            }
            googleApiManager = zad;
        }
        return googleApiManager;
    }

    public final boolean handleMessage(Message message) {
        zabq zabq;
        int i = message.what;
        long j = PeriodicWorkRequest.MIN_PERIODIC_FLEX_MILLIS;
        switch (i) {
            case 1:
                if (true == ((Boolean) message.obj).booleanValue()) {
                    j = WorkRequest.MIN_BACKOFF_MILLIS;
                }
                this.zag = j;
                this.zat.removeMessages(12);
                for (ApiKey<?> obtainMessage : this.zap.keySet()) {
                    Handler handler = this.zat;
                    handler.sendMessageDelayed(handler.obtainMessage(12, obtainMessage), this.zag);
                }
                break;
            case 2:
                zal zal2 = (zal) message.obj;
                Iterator<ApiKey<?>> it = zal2.zab().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    } else {
                        ApiKey next = it.next();
                        zabq zabq2 = this.zap.get(next);
                        if (zabq2 == null) {
                            zal2.zac(next, new ConnectionResult(13), (String) null);
                            break;
                        } else if (zabq2.zay()) {
                            zal2.zac(next, ConnectionResult.RESULT_SUCCESS, zabq2.zaf().getEndpointPackageName());
                        } else {
                            ConnectionResult zad2 = zabq2.zad();
                            if (zad2 != null) {
                                zal2.zac(next, zad2, (String) null);
                            } else {
                                zabq2.zat(zal2);
                                zabq2.zao();
                            }
                        }
                    }
                }
            case 3:
                for (zabq next2 : this.zap.values()) {
                    next2.zan();
                    next2.zao();
                }
                break;
            case 4:
            case 8:
            case 13:
                zach zach = (zach) message.obj;
                zabq<?> zabq3 = this.zap.get(zach.zac.getApiKey());
                if (zabq3 == null) {
                    zabq3 = zaI(zach.zac);
                }
                if (zabq3.zaz() && this.zao.get() != zach.zab) {
                    zach.zaa.zad(zaa);
                    zabq3.zav();
                    break;
                } else {
                    zabq3.zap(zach.zaa);
                    break;
                }
                break;
            case 5:
                int i2 = message.arg1;
                ConnectionResult connectionResult = (ConnectionResult) message.obj;
                Iterator<zabq<?>> it2 = this.zap.values().iterator();
                while (true) {
                    if (it2.hasNext()) {
                        zabq = it2.next();
                        if (zabq.zab() == i2) {
                        }
                    } else {
                        zabq = null;
                    }
                }
                if (zabq != null) {
                    if (connectionResult.getErrorCode() != 13) {
                        zabq.zaD(zaH(zabq.zad, connectionResult));
                        break;
                    } else {
                        String errorString = this.zal.getErrorString(connectionResult.getErrorCode());
                        String errorMessage = connectionResult.getErrorMessage();
                        StringBuilder sb = new StringBuilder(String.valueOf(errorString).length() + 69 + String.valueOf(errorMessage).length());
                        sb.append("Error resolution was canceled by the user, original error message: ");
                        sb.append(errorString);
                        sb.append(": ");
                        sb.append(errorMessage);
                        zabq.zaD(new Status(17, sb.toString()));
                        break;
                    }
                } else {
                    StringBuilder sb2 = new StringBuilder(76);
                    sb2.append("Could not find API instance ");
                    sb2.append(i2);
                    sb2.append(" while trying to fail enqueued calls.");
                    Log.wtf("GoogleApiManager", sb2.toString(), new Exception());
                    break;
                }
            case 6:
                if (this.zak.getApplicationContext() instanceof Application) {
                    BackgroundDetector.initialize((Application) this.zak.getApplicationContext());
                    BackgroundDetector.getInstance().addListener(new zabl(this));
                    if (!BackgroundDetector.getInstance().readCurrentStateIfPossible(true)) {
                        this.zag = PeriodicWorkRequest.MIN_PERIODIC_FLEX_MILLIS;
                        break;
                    }
                }
                break;
            case 7:
                zaI((GoogleApi) message.obj);
                break;
            case 9:
                if (this.zap.containsKey(message.obj)) {
                    this.zap.get(message.obj).zau();
                    break;
                }
                break;
            case 10:
                for (ApiKey<?> remove : this.zas) {
                    zabq remove2 = this.zap.remove(remove);
                    if (remove2 != null) {
                        remove2.zav();
                    }
                }
                this.zas.clear();
                break;
            case 11:
                if (this.zap.containsKey(message.obj)) {
                    this.zap.get(message.obj).zaw();
                    break;
                }
                break;
            case 12:
                if (this.zap.containsKey(message.obj)) {
                    this.zap.get(message.obj).zaA();
                    break;
                }
                break;
            case 14:
                zaaf zaaf = (zaaf) message.obj;
                ApiKey<?> zaa2 = zaaf.zaa();
                if (this.zap.containsKey(zaa2)) {
                    zaaf.zab().setResult(Boolean.valueOf(this.zap.get(zaa2).zaN(false)));
                    break;
                } else {
                    zaaf.zab().setResult(false);
                    break;
                }
            case 15:
                zabs zabs = (zabs) message.obj;
                if (this.zap.containsKey(zabs.zaa)) {
                    zabq.zal(this.zap.get(zabs.zaa), zabs);
                    break;
                }
                break;
            case 16:
                zabs zabs2 = (zabs) message.obj;
                if (this.zap.containsKey(zabs2.zaa)) {
                    zabq.zam(this.zap.get(zabs2.zaa), zabs2);
                    break;
                }
                break;
            case 17:
                zaK();
                break;
            case 18:
                zace zace = (zace) message.obj;
                if (zace.zac != 0) {
                    TelemetryData telemetryData = this.zai;
                    if (telemetryData != null) {
                        List<MethodInvocation> zab2 = telemetryData.zab();
                        if (telemetryData.zaa() != zace.zab || (zab2 != null && zab2.size() >= zace.zad)) {
                            this.zat.removeMessages(17);
                            zaK();
                        } else {
                            this.zai.zac(zace.zaa);
                        }
                    }
                    if (this.zai == null) {
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(zace.zaa);
                        this.zai = new TelemetryData(zace.zab, arrayList);
                        Handler handler2 = this.zat;
                        handler2.sendMessageDelayed(handler2.obtainMessage(17), zace.zac);
                        break;
                    }
                } else {
                    zaJ().log(new TelemetryData(zace.zab, Arrays.asList(new MethodInvocation[]{zace.zaa})));
                    break;
                }
                break;
            case 19:
                this.zah = false;
                break;
            default:
                int i3 = message.what;
                StringBuilder sb3 = new StringBuilder(31);
                sb3.append("Unknown message id: ");
                sb3.append(i3);
                Log.w("GoogleApiManager", sb3.toString());
                return false;
        }
        return true;
    }

    public final void zaA() {
        Handler handler = this.zat;
        handler.sendMessage(handler.obtainMessage(3));
    }

    public final void zaB(GoogleApi<?> googleApi) {
        Handler handler = this.zat;
        handler.sendMessage(handler.obtainMessage(7, googleApi));
    }

    public final void zaC(zaae zaae) {
        synchronized (zac) {
            if (this.zaq != zaae) {
                this.zaq = zaae;
                this.zar.clear();
            }
            this.zar.addAll(zaae.zaa());
        }
    }

    /* access modifiers changed from: package-private */
    public final void zaD(zaae zaae) {
        synchronized (zac) {
            if (this.zaq == zaae) {
                this.zaq = null;
                this.zar.clear();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean zaF() {
        if (this.zah) {
            return false;
        }
        RootTelemetryConfiguration config = RootTelemetryConfigManager.getInstance().getConfig();
        if (config != null && !config.getMethodInvocationTelemetryEnabled()) {
            return false;
        }
        int zaa2 = this.zam.zaa(this.zak, 203400000);
        if (zaa2 == -1 || zaa2 == 0) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public final boolean zaG(ConnectionResult connectionResult, int i) {
        return this.zal.zah(this.zak, connectionResult, i);
    }

    public final int zaa() {
        return this.zan.getAndIncrement();
    }

    /* access modifiers changed from: package-private */
    public final zabq zak(ApiKey<?> apiKey) {
        return this.zap.get(apiKey);
    }

    public final Task<Map<ApiKey<?>, String>> zao(Iterable<? extends HasApiKey<?>> iterable) {
        zal zal2 = new zal(iterable);
        Handler handler = this.zat;
        handler.sendMessage(handler.obtainMessage(2, zal2));
        return zal2.zaa();
    }

    public final Task<Boolean> zap(GoogleApi<?> googleApi) {
        zaaf zaaf = new zaaf(googleApi.getApiKey());
        Handler handler = this.zat;
        handler.sendMessage(handler.obtainMessage(14, zaaf));
        return zaaf.zab().getTask();
    }

    public final <O extends Api.ApiOptions> Task<Void> zaq(GoogleApi<O> googleApi, RegisterListenerMethod<Api.AnyClient, ?> registerListenerMethod, UnregisterListenerMethod<Api.AnyClient, ?> unregisterListenerMethod, Runnable runnable) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        zaL(taskCompletionSource, registerListenerMethod.zaa(), googleApi);
        zaf zaf2 = new zaf(new zaci(registerListenerMethod, unregisterListenerMethod, runnable), taskCompletionSource);
        Handler handler = this.zat;
        handler.sendMessage(handler.obtainMessage(8, new zach(zaf2, this.zao.get(), googleApi)));
        return taskCompletionSource.getTask();
    }

    public final <O extends Api.ApiOptions> Task<Boolean> zar(GoogleApi<O> googleApi, ListenerHolder.ListenerKey listenerKey, int i) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        zaL(taskCompletionSource, i, googleApi);
        zah zah2 = new zah(listenerKey, taskCompletionSource);
        Handler handler = this.zat;
        handler.sendMessage(handler.obtainMessage(13, new zach(zah2, this.zao.get(), googleApi)));
        return taskCompletionSource.getTask();
    }

    public final <O extends Api.ApiOptions> void zaw(GoogleApi<O> googleApi, int i, BaseImplementation.ApiMethodImpl<? extends Result, Api.AnyClient> apiMethodImpl) {
        zae zae2 = new zae(i, apiMethodImpl);
        Handler handler = this.zat;
        handler.sendMessage(handler.obtainMessage(4, new zach(zae2, this.zao.get(), googleApi)));
    }

    public final <O extends Api.ApiOptions, ResultT> void zax(GoogleApi<O> googleApi, int i, TaskApiCall<Api.AnyClient, ResultT> taskApiCall, TaskCompletionSource<ResultT> taskCompletionSource, StatusExceptionMapper statusExceptionMapper) {
        zaL(taskCompletionSource, taskApiCall.zaa(), googleApi);
        zag zag2 = new zag(i, taskApiCall, taskCompletionSource, statusExceptionMapper);
        Handler handler = this.zat;
        handler.sendMessage(handler.obtainMessage(4, new zach(zag2, this.zao.get(), googleApi)));
    }

    /* access modifiers changed from: package-private */
    public final void zay(MethodInvocation methodInvocation, int i, long j, int i2) {
        Handler handler = this.zat;
        handler.sendMessage(handler.obtainMessage(18, new zace(methodInvocation, i, j, i2)));
    }

    public final void zaz(ConnectionResult connectionResult, int i) {
        if (!zaG(connectionResult, i)) {
            Handler handler = this.zat;
            handler.sendMessage(handler.obtainMessage(5, i, 0, connectionResult));
        }
    }
}
