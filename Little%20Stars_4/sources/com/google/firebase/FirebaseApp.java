package com.google.firebase;

import android.annotation.TargetApi;
import android.app.Application;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.UiThread;
import android.support.v4.util.ArrayMap;
import android.util.Log;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.common.internal.zzz;
import com.google.android.gms.common.util.zzc;
import com.google.android.gms.common.util.zzs;
import com.google.android.gms.internal.zzaiy;
import com.google.android.gms.internal.zzaiz;
import com.google.android.gms.internal.zzaja;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GetTokenResult;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import object.p2pipcam.utils.DataBaseHelper;

public class FirebaseApp {
    public static final String DEFAULT_APP_NAME = "[DEFAULT]";
    static final Map<String, FirebaseApp> zzaTZ = new ArrayMap();
    private static final List<String> zzbEC = Arrays.asList(new String[]{"com.google.firebase.auth.FirebaseAuth", "com.google.firebase.iid.FirebaseInstanceId"});
    private static final List<String> zzbED = Collections.singletonList("com.google.firebase.crash.FirebaseCrash");
    private static final List<String> zzbEE = Arrays.asList(new String[]{"com.google.android.gms.measurement.AppMeasurement"});
    private static final Set<String> zzbEF = Collections.emptySet();
    private static final Object zzrs = new Object();
    private final String mName;
    private final FirebaseOptions zzbEG;
    private final AtomicBoolean zzbEH = new AtomicBoolean(true);
    private final AtomicBoolean zzbEI = new AtomicBoolean();
    private final List<zza> zzbEJ = new CopyOnWriteArrayList();
    private final List<zzb> zzbEK = new CopyOnWriteArrayList();
    private final List<Object> zzbEL = new CopyOnWriteArrayList();
    protected zzaja zzbEM;
    private final Context zztm;

    public interface zza {
        void zzb(@NonNull zzaja zzaja, @Nullable FirebaseUser firebaseUser);
    }

    public interface zzb {
        void zzaI(boolean z);
    }

    protected FirebaseApp(Context context, String str, FirebaseOptions firebaseOptions) {
        this.zztm = (Context) zzaa.zzz(context);
        this.mName = zzaa.zzdl(str);
        this.zzbEG = (FirebaseOptions) zzaa.zzz(firebaseOptions);
    }

    public static List<FirebaseApp> getApps(Context context) {
        return new ArrayList(zzaTZ.values());
    }

    @Nullable
    public static FirebaseApp getInstance() {
        return getInstance(DEFAULT_APP_NAME);
    }

    public static FirebaseApp getInstance(@NonNull String str) {
        FirebaseApp firebaseApp;
        String str2;
        synchronized (zzrs) {
            firebaseApp = zzaTZ.get(zzhF(str));
            if (firebaseApp == null) {
                List<String> zzNW = zzNW();
                if (!zzNW.isEmpty()) {
                    String valueOf = String.valueOf(zzx.zzdk(", ").zza(zzNW));
                    str2 = valueOf.length() != 0 ? "Available app names: ".concat(valueOf) : new String("Available app names: ");
                } else {
                    str2 = "";
                }
                throw new IllegalStateException(String.format("FirebaseApp with name %s doesn't exist. %s", new Object[]{str, str2}));
            }
        }
        return firebaseApp;
    }

    public static FirebaseApp initializeApp(Context context, FirebaseOptions firebaseOptions) {
        return initializeApp(context, firebaseOptions, DEFAULT_APP_NAME);
    }

    public static FirebaseApp initializeApp(Context context, FirebaseOptions firebaseOptions, String str) {
        FirebaseApp firebaseApp;
        zzaiz zzbA = zzaiz.zzbA(context);
        zzbv(context);
        String zzhF = zzhF(str);
        Context applicationContext = context.getApplicationContext();
        synchronized (zzrs) {
            boolean z = !zzaTZ.containsKey(zzhF);
            StringBuilder sb = new StringBuilder(String.valueOf(zzhF).length() + 33);
            sb.append("FirebaseApp name ");
            sb.append(zzhF);
            sb.append(" already exists!");
            zzaa.zza(z, (Object) sb.toString());
            zzaa.zzb(applicationContext, (Object) "Application context cannot be null.");
            firebaseApp = new FirebaseApp(applicationContext, zzhF, firebaseOptions);
            zzaTZ.put(zzhF, firebaseApp);
        }
        zzbA.zzf(firebaseApp);
        zza(FirebaseApp.class, firebaseApp, zzbEC);
        if (firebaseApp.zzNU()) {
            zza(FirebaseApp.class, firebaseApp, zzbED);
            zza(Context.class, firebaseApp.getApplicationContext(), zzbEE);
        }
        return firebaseApp;
    }

    private void zzNT() {
        zzaa.zza(!this.zzbEI.get(), (Object) "FirebaseApp was deleted");
    }

    private static List<String> zzNW() {
        com.google.android.gms.common.util.zza zza2 = new com.google.android.gms.common.util.zza();
        synchronized (zzrs) {
            for (FirebaseApp name : zzaTZ.values()) {
                zza2.add(name.getName());
            }
            zzaiz zzUw = zzaiz.zzUw();
            if (zzUw != null) {
                zza2.addAll(zzUw.zzUx());
            }
        }
        ArrayList arrayList = new ArrayList(zza2);
        Collections.sort(arrayList);
        return arrayList;
    }

    private static <T> void zza(Class<T> cls, T t, Iterable<String> iterable) {
        for (String next : iterable) {
            try {
                Class<?> cls2 = Class.forName(next);
                Method method = cls2.getMethod("getInstance", new Class[]{cls});
                if ((method.getModifiers() & 9) == 9) {
                    method.invoke((Object) null, new Object[]{t});
                }
                String valueOf = String.valueOf(cls2);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 13);
                sb.append("Initialized ");
                sb.append(valueOf);
                sb.append(".");
                Log.d("FirebaseApp", sb.toString());
            } catch (ClassNotFoundException unused) {
                if (!zzbEF.contains(next)) {
                    Log.d("FirebaseApp", String.valueOf(next).concat(" is not linked. Skipping initialization."));
                } else {
                    throw new IllegalStateException(String.valueOf(next).concat(" is missing, but is required. Check if it has been removed by Proguard."));
                }
            } catch (NoSuchMethodException unused2) {
                throw new IllegalStateException(String.valueOf(next).concat("#getInstance has been removed by Proguard. Add keep rule to prevent it."));
            } catch (InvocationTargetException e) {
                Log.wtf("FirebaseApp", "Firebase API initialization failure.", e);
            } catch (IllegalAccessException e2) {
                String valueOf2 = String.valueOf(next);
                Log.wtf("FirebaseApp", valueOf2.length() != 0 ? "Failed to initialize ".concat(valueOf2) : new String("Failed to initialize "), e2);
            }
        }
    }

    public static void zzaI(boolean z) {
        synchronized (zzrs) {
            Iterator it = new ArrayList(zzaTZ.values()).iterator();
            while (it.hasNext()) {
                FirebaseApp firebaseApp = (FirebaseApp) it.next();
                if (firebaseApp.zzbEH.get()) {
                    firebaseApp.zzaJ(z);
                }
            }
        }
    }

    private void zzaJ(boolean z) {
        Log.d("FirebaseApp", "Notifying background state change listeners.");
        for (zzb zzaI : this.zzbEK) {
            zzaI.zzaI(z);
        }
    }

    public static FirebaseApp zzbu(Context context) {
        FirebaseOptions fromResource = FirebaseOptions.fromResource(context);
        if (fromResource == null) {
            return null;
        }
        return initializeApp(context, fromResource);
    }

    @TargetApi(14)
    private static void zzbv(Context context) {
        if (zzs.zzva() && (context.getApplicationContext() instanceof Application)) {
            zzaiy.zza((Application) context.getApplicationContext());
        }
    }

    private static String zzhF(@NonNull String str) {
        return str.trim();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof FirebaseApp)) {
            return false;
        }
        return this.mName.equals(((FirebaseApp) obj).getName());
    }

    @NonNull
    public Context getApplicationContext() {
        zzNT();
        return this.zztm;
    }

    @NonNull
    public String getName() {
        zzNT();
        return this.mName;
    }

    @NonNull
    public FirebaseOptions getOptions() {
        zzNT();
        return this.zzbEG;
    }

    public Task<GetTokenResult> getToken(boolean z) {
        zzNT();
        zzaja zzaja = this.zzbEM;
        return zzaja == null ? Tasks.forException(new FirebaseApiNotAvailableException("firebase-auth is not linked, please fall back to unauthenticated mode.")) : zzaja.zza(zzaja.getCurrentUser(), z);
    }

    public int hashCode() {
        return this.mName.hashCode();
    }

    public String toString() {
        return zzz.zzy(this).zzg(DataBaseHelper.KEY_NAME, this.mName).zzg("options", this.zzbEG).toString();
    }

    public zzaja zzNS() {
        zzNT();
        return this.zzbEM;
    }

    public boolean zzNU() {
        return DEFAULT_APP_NAME.equals(getName());
    }

    public String zzNV() {
        String valueOf = String.valueOf(zzc.zzm(getName().getBytes()));
        String valueOf2 = String.valueOf(zzc.zzm(getOptions().getApplicationId().getBytes()));
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 1 + String.valueOf(valueOf2).length());
        sb.append(valueOf);
        sb.append("+");
        sb.append(valueOf2);
        return sb.toString();
    }

    public void zza(@NonNull zzaja zzaja) {
        this.zzbEM = (zzaja) zzaa.zzz(zzaja);
    }

    @UiThread
    public void zza(zzaja zzaja, FirebaseUser firebaseUser) {
        Log.d("FirebaseApp", "Notifying auth state listeners.");
        int i = 0;
        for (zza zzb2 : this.zzbEJ) {
            zzb2.zzb(zzaja, firebaseUser);
            i++;
        }
        Log.d("FirebaseApp", String.format("Notified %d auth state listeners.", new Object[]{Integer.valueOf(i)}));
    }

    public void zza(@NonNull zza zza2) {
        zzNT();
        zzaa.zzz(zza2);
        this.zzbEJ.add(zza2);
    }
}
