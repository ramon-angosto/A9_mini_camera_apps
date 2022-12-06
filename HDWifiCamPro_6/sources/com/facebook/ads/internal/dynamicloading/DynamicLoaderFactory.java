package com.facebook.ads.internal.dynamicloading;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.facebook.ads.AudienceNetworkAds;
import com.facebook.ads.BuildConfig;
import com.facebook.ads.internal.settings.MultithreadedBundleWrapper;
import com.facebook.ads.internal.util.common.Preconditions;
import dalvik.system.DexClassLoader;
import dalvik.system.InMemoryDexClassLoader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public class DynamicLoaderFactory {
    private static final String AUDIENCE_NETWORK_CODE_PATH = "audience_network";
    public static final String AUDIENCE_NETWORK_DEX = "audience_network.dex";
    private static final String CODE_CACHE_DIR = "code_cache";
    static final String DEX_LOADING_ERROR_MESSAGE = "Can't load Audience Network Dex. Please, check that audience_network.dex is inside of assets folder.";
    private static final int DEX_LOAD_RETRY_COUNT = 3;
    private static final int DEX_LOAD_RETRY_DELAY_MS = 200;
    private static final String DYNAMIC_LOADING_BUILD_TYPE = "releaseDL";
    public static final boolean LOAD_FROM_ASSETS = "releaseDL".equals(BuildConfig.BUILD_TYPE);
    private static final String OPTIMIZED_DEX_PATH = "optimized";
    private static final AtomicReference<DynamicLoader> sDynamicLoader = new AtomicReference<>();
    private static boolean sFallbackMode;
    /* access modifiers changed from: private */
    public static final AtomicBoolean sInitializing = new AtomicBoolean();
    private static boolean sUseLegacyClassLoader = true;

    public static synchronized DynamicLoader makeLoaderUnsafe() {
        synchronized (DynamicLoaderFactory.class) {
            if (sDynamicLoader.get() == null) {
                Context applicationContextViaReflection = getApplicationContextViaReflection();
                if (applicationContextViaReflection != null) {
                    DynamicLoader makeLoader = makeLoader(applicationContextViaReflection, true);
                    return makeLoader;
                }
                throw new RuntimeException("You must call AudienceNetworkAds.buildInitSettings(Context).initialize() before you can use Audience Network SDK.");
            }
            DynamicLoader dynamicLoader = sDynamicLoader.get();
            return dynamicLoader;
        }
    }

    public static void initialize(final Context context, final MultithreadedBundleWrapper multithreadedBundleWrapper, final AudienceNetworkAds.InitListener initListener, final boolean z) {
        if (z || !sInitializing.getAndSet(true)) {
            new Thread(new Runnable() {
                /* JADX WARNING: Code restructure failed: missing block: B:17:0x003a, code lost:
                    r5 = r1;
                 */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public void run() {
                    /*
                        r10 = this;
                        android.content.Context r0 = r2
                        com.facebook.ads.internal.util.common.ANActivityLifecycleCallbacksListener.registerActivityCallbacks(r0)
                        java.lang.Class<com.facebook.ads.internal.dynamicloading.DynamicLoaderFactory> r0 = com.facebook.ads.internal.dynamicloading.DynamicLoaderFactory.class
                        monitor-enter(r0)
                        r1 = 0
                        r2 = 0
                        r6 = r1
                        r3 = r2
                    L_0x000c:
                        r4 = 3
                        if (r3 >= r4) goto L_0x003a
                        android.content.Context r4 = r2     // Catch:{ all -> 0x0016 }
                        com.facebook.ads.internal.dynamicloading.DynamicLoader r1 = com.facebook.ads.internal.dynamicloading.DynamicLoaderFactory.doMakeLoader(r4, r2)     // Catch:{ all -> 0x0016 }
                        goto L_0x003a
                    L_0x0016:
                        r4 = move-exception
                        r5 = 2
                        if (r3 != r5) goto L_0x0032
                        boolean r5 = r5     // Catch:{ all -> 0x004f }
                        if (r5 != 0) goto L_0x0030
                        android.content.Context r5 = r2     // Catch:{ all -> 0x004f }
                        java.lang.String r6 = com.facebook.ads.internal.dynamicloading.DynamicLoaderFactory.createErrorMessage(r4)     // Catch:{ all -> 0x004f }
                        r7 = 4591870180066957722(0x3fb999999999999a, double:0.1)
                        com.facebook.ads.internal.dynamicloading.DexLoadErrorReporter.reportDexLoadingIssue(r5, r6, r7)     // Catch:{ all -> 0x004f }
                        r5 = 1
                        com.facebook.ads.internal.dynamicloading.DynamicLoaderFactory.setFallbackMode(r5)     // Catch:{ all -> 0x004f }
                    L_0x0030:
                        r6 = r4
                        goto L_0x0037
                    L_0x0032:
                        r4 = 200(0xc8, double:9.9E-322)
                        android.os.SystemClock.sleep(r4)     // Catch:{ all -> 0x004f }
                    L_0x0037:
                        int r3 = r3 + 1
                        goto L_0x000c
                    L_0x003a:
                        r5 = r1
                        monitor-exit(r0)     // Catch:{ all -> 0x004f }
                        android.content.Context r4 = r2
                        boolean r7 = r5
                        com.facebook.ads.internal.settings.MultithreadedBundleWrapper r8 = r3
                        com.facebook.ads.AudienceNetworkAds$InitListener r9 = r4
                        com.facebook.ads.internal.dynamicloading.DynamicLoaderFactory.doCallInitialize(r4, r5, r6, r7, r8, r9)
                        java.util.concurrent.atomic.AtomicBoolean r0 = com.facebook.ads.internal.dynamicloading.DynamicLoaderFactory.sInitializing
                        r0.set(r2)
                        return
                    L_0x004f:
                        r1 = move-exception
                        monitor-exit(r0)     // Catch:{ all -> 0x004f }
                        throw r1
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.internal.dynamicloading.DynamicLoaderFactory.AnonymousClass1.run():void");
                }
            }).start();
        }
    }

    /* access modifiers changed from: private */
    public static void doCallInitialize(Context context, DynamicLoader dynamicLoader, final Throwable th, boolean z, MultithreadedBundleWrapper multithreadedBundleWrapper, final AudienceNetworkAds.InitListener initListener) {
        if (th != null) {
            if (initListener != null) {
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                    public void run() {
                        AudienceNetworkAds.InitListener.this.onInitialized(DynamicLoaderFactory.createErrorInitResult(th));
                    }
                }, 100);
            } else {
                Log.e(AudienceNetworkAds.TAG, DEX_LOADING_ERROR_MESSAGE, th);
            }
        } else if (dynamicLoader == null) {
        } else {
            if (z) {
                dynamicLoader.createAudienceNetworkAdsApi().onContentProviderCreated(context);
            } else {
                dynamicLoader.createAudienceNetworkAdsApi().initialize(context, multithreadedBundleWrapper, initListener);
            }
        }
    }

    /* access modifiers changed from: private */
    public static AudienceNetworkAds.InitResult createErrorInitResult(final Throwable th) {
        return new AudienceNetworkAds.InitResult() {
            public boolean isSuccess() {
                return false;
            }

            public String getMessage() {
                return DynamicLoaderFactory.createErrorMessage(th);
            }
        };
    }

    /* access modifiers changed from: private */
    public static String createErrorMessage(Throwable th) {
        return "Can't load Audience Network Dex. Please, check that audience_network.dex is inside of assets folder.\n" + stackTraceToString(th);
    }

    public static synchronized DynamicLoader makeLoader(Context context) {
        DynamicLoader makeLoader;
        synchronized (DynamicLoaderFactory.class) {
            makeLoader = makeLoader(context, true);
        }
        return makeLoader;
    }

    public static synchronized DynamicLoader makeLoader(Context context, boolean z) {
        DynamicLoader doMakeLoader;
        synchronized (DynamicLoaderFactory.class) {
            Preconditions.checkNotNull(context, "Context can not be null.");
            try {
                doMakeLoader = doMakeLoader(context, z);
            } catch (Throwable th) {
                Log.e(AudienceNetworkAds.TAG, DEX_LOADING_ERROR_MESSAGE, th);
                DexLoadErrorReporter.reportDexLoadingIssue(context, createErrorMessage(th), 0.1d);
                DynamicLoader makeFallbackLoader = DynamicLoaderFallback.makeFallbackLoader();
                sDynamicLoader.set(makeFallbackLoader);
                sFallbackMode = true;
                return makeFallbackLoader;
            }
        }
        return doMakeLoader;
    }

    /* access modifiers changed from: private */
    public static DynamicLoader doMakeLoader(Context context, boolean z) throws Exception {
        DynamicLoader dynamicLoader = sDynamicLoader.get();
        if (dynamicLoader == null) {
            if (!LOAD_FROM_ASSETS) {
                dynamicLoader = (DynamicLoader) Class.forName("com.facebook.ads.internal.dynamicloading.DynamicLoaderImpl").newInstance();
            } else {
                long currentTimeMillis = System.currentTimeMillis();
                dynamicLoader = (DynamicLoader) makeAdsSdkClassLoader(context.getApplicationContext()).loadClass("com.facebook.ads.internal.dynamicloading.DynamicLoaderImpl").newInstance();
                Log.d(AudienceNetworkAds.TAG, "SDK dex loading time: " + (System.currentTimeMillis() - currentTimeMillis));
            }
            if (z) {
                dynamicLoader.maybeInitInternally(context);
            }
            sDynamicLoader.set(dynamicLoader);
        }
        return dynamicLoader;
    }

    public static synchronized void setFallbackMode(boolean z) {
        synchronized (DynamicLoaderFactory.class) {
            if (z) {
                sDynamicLoader.set(DynamicLoaderFallback.makeFallbackLoader());
                sFallbackMode = true;
            } else {
                sDynamicLoader.set((Object) null);
                sFallbackMode = false;
            }
        }
    }

    public static void setUseLegacyClassLoader(boolean z) {
        sUseLegacyClassLoader = z;
    }

    public static synchronized boolean isFallbackMode() {
        boolean z;
        synchronized (DynamicLoaderFactory.class) {
            z = sFallbackMode;
        }
        return z;
    }

    public static DynamicLoader getDynamicLoader() {
        return sDynamicLoader.get();
    }

    private static DexClassLoader makeLegacyAdsSdkClassLoader(Context context) throws Exception {
        String str = context.getFilesDir().getPath() + File.separator + AUDIENCE_NETWORK_DEX;
        InputStream open = context.getAssets().open(AUDIENCE_NETWORK_DEX);
        FileOutputStream fileOutputStream = new FileOutputStream(str);
        byte[] bArr = new byte[1024];
        while (true) {
            int read = open.read(bArr);
            if (read > 0) {
                fileOutputStream.write(bArr, 0, read);
            } else {
                open.close();
                fileOutputStream.flush();
                fileOutputStream.close();
                return new DexClassLoader(str, context.getDir(OPTIMIZED_DEX_PATH, 0).getPath(), (String) null, DynamicLoaderFactory.class.getClassLoader());
            }
        }
    }

    private static ClassLoader makeAdsSdkClassLoader(Context context) throws Exception {
        if (Build.VERSION.SDK_INT >= 30) {
            return createInMemoryClassLoader(context);
        }
        if (sUseLegacyClassLoader) {
            return makeLegacyAdsSdkClassLoader(context);
        }
        File secondaryDir = getSecondaryDir(getCodeCacheDir(context, new File(context.getApplicationInfo().dataDir)));
        String str = secondaryDir.getPath() + File.separator + AUDIENCE_NETWORK_DEX;
        InputStream open = context.getAssets().open(AUDIENCE_NETWORK_DEX);
        FileOutputStream fileOutputStream = new FileOutputStream(str);
        byte[] bArr = new byte[1024];
        while (true) {
            int read = open.read(bArr);
            if (read > 0) {
                fileOutputStream.write(bArr, 0, read);
            } else {
                open.close();
                fileOutputStream.flush();
                fileOutputStream.close();
                File file = new File(secondaryDir.getPath() + File.separator + OPTIMIZED_DEX_PATH);
                mkdirChecked(file);
                return new DexClassLoader(str, file.getPath(), (String) null, context.getClassLoader());
            }
        }
    }

    private static ClassLoader createInMemoryClassLoader(Context context) throws IOException {
        InputStream open = context.getAssets().open(AUDIENCE_NETWORK_DEX);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[1024];
        while (true) {
            int read = open.read(bArr);
            if (read > 0) {
                byteArrayOutputStream.write(bArr, 0, read);
            } else {
                open.close();
                byteArrayOutputStream.flush();
                byteArrayOutputStream.close();
                return new InMemoryDexClassLoader(ByteBuffer.wrap(byteArrayOutputStream.toByteArray()), DynamicLoaderFactory.class.getClassLoader());
            }
        }
    }

    private static Context getApplicationContextViaReflection() {
        try {
            return (Context) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke((Object) null, (Object[]) null);
        } catch (Throwable th) {
            Log.e(AudienceNetworkAds.TAG, "Failed to fetch Context from  ActivityThread. Audience Network SDK won't work unless you call AudienceNetworkAds.buildInitSettings().withListener(InitListener).initialize().", th);
            return null;
        }
    }

    private static File getCodeCacheDir(Context context, File file) throws IOException {
        if (Build.VERSION.SDK_INT >= 21) {
            return context.getCodeCacheDir();
        }
        return getCacheCodeDirLegacy(context, file);
    }

    private static File getCacheCodeDirLegacy(Context context, File file) throws IOException {
        File file2 = new File(file, CODE_CACHE_DIR);
        try {
            mkdirChecked(file2);
            return file2;
        } catch (IOException unused) {
            File dir = context.getDir(CODE_CACHE_DIR, 0);
            mkdirChecked(dir);
            return dir;
        }
    }

    private static File getSecondaryDir(File file) throws IOException {
        File file2 = new File(file, AUDIENCE_NETWORK_CODE_PATH);
        mkdirChecked(file2);
        return file2;
    }

    private static void mkdirChecked(File file) throws IOException {
        String str;
        file.mkdir();
        if (!file.isDirectory()) {
            File parentFile = file.getParentFile();
            if (parentFile == null) {
                str = "Failed to create dir " + file.getPath() + ". Parent file is null.";
            } else {
                str = "Failed to create dir " + file.getPath() + ". parent file is a dir " + parentFile.isDirectory() + ", a file " + parentFile.isFile() + ", exists " + parentFile.exists() + ", readable " + parentFile.canRead() + ", writable " + parentFile.canWrite();
            }
            Log.e(AudienceNetworkAds.TAG, str);
            throw new IOException("Failed to create directory " + file.getPath() + ", detailed message: " + str);
        }
    }

    private static String stackTraceToString(Throwable th) {
        return Log.getStackTraceString(th);
    }
}
