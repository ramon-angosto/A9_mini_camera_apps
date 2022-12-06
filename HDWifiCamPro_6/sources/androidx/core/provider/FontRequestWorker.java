package androidx.core.provider;

import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Typeface;
import android.os.CancellationSignal;
import androidx.collection.LruCache;
import androidx.collection.SimpleArrayMap;
import androidx.core.graphics.TypefaceCompat;
import androidx.core.provider.FontsContractCompat;
import androidx.core.util.Consumer;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;

class FontRequestWorker {
    private static final ExecutorService DEFAULT_EXECUTOR_SERVICE = RequestExecutor.createDefaultExecutor("fonts-androidx", 10, 10000);
    static final Object LOCK = new Object();
    static final SimpleArrayMap<String, ArrayList<Consumer<TypefaceResult>>> PENDING_REPLIES = new SimpleArrayMap<>();
    static final LruCache<String, Typeface> sTypefaceCache = new LruCache<>(16);

    private FontRequestWorker() {
    }

    static void resetTypefaceCache() {
        sTypefaceCache.evictAll();
    }

    static Typeface requestFontSync(final Context context, final FontRequest fontRequest, CallbackWithHandler callbackWithHandler, final int i, int i2) {
        final String createCacheId = createCacheId(fontRequest, i);
        Typeface typeface = sTypefaceCache.get(createCacheId);
        if (typeface != null) {
            callbackWithHandler.onTypefaceResult(new TypefaceResult(typeface));
            return typeface;
        } else if (i2 == -1) {
            TypefaceResult fontSync = getFontSync(createCacheId, context, fontRequest, i);
            callbackWithHandler.onTypefaceResult(fontSync);
            return fontSync.mTypeface;
        } else {
            try {
                TypefaceResult typefaceResult = (TypefaceResult) RequestExecutor.submit(DEFAULT_EXECUTOR_SERVICE, new Callable<TypefaceResult>() {
                    public TypefaceResult call() {
                        return FontRequestWorker.getFontSync(createCacheId, context, fontRequest, i);
                    }
                }, i2);
                callbackWithHandler.onTypefaceResult(typefaceResult);
                return typefaceResult.mTypeface;
            } catch (InterruptedException unused) {
                callbackWithHandler.onTypefaceResult(new TypefaceResult(-3));
                return null;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x003d, code lost:
        r8 = new androidx.core.provider.FontRequestWorker.AnonymousClass3();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0042, code lost:
        if (r7 != null) goto L_0x0046;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0044, code lost:
        r7 = DEFAULT_EXECUTOR_SERVICE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0046, code lost:
        androidx.core.provider.RequestExecutor.execute(r7, r8, new androidx.core.provider.FontRequestWorker.AnonymousClass4());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x004e, code lost:
        return null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static android.graphics.Typeface requestFontAsync(final android.content.Context r4, final androidx.core.provider.FontRequest r5, final int r6, java.util.concurrent.Executor r7, final androidx.core.provider.CallbackWithHandler r8) {
        /*
            java.lang.String r0 = createCacheId(r5, r6)
            androidx.collection.LruCache<java.lang.String, android.graphics.Typeface> r1 = sTypefaceCache
            java.lang.Object r1 = r1.get(r0)
            android.graphics.Typeface r1 = (android.graphics.Typeface) r1
            if (r1 == 0) goto L_0x0017
            androidx.core.provider.FontRequestWorker$TypefaceResult r4 = new androidx.core.provider.FontRequestWorker$TypefaceResult
            r4.<init>((android.graphics.Typeface) r1)
            r8.onTypefaceResult(r4)
            return r1
        L_0x0017:
            androidx.core.provider.FontRequestWorker$2 r1 = new androidx.core.provider.FontRequestWorker$2
            r1.<init>()
            java.lang.Object r8 = LOCK
            monitor-enter(r8)
            androidx.collection.SimpleArrayMap<java.lang.String, java.util.ArrayList<androidx.core.util.Consumer<androidx.core.provider.FontRequestWorker$TypefaceResult>>> r2 = PENDING_REPLIES     // Catch:{ all -> 0x004f }
            java.lang.Object r2 = r2.get(r0)     // Catch:{ all -> 0x004f }
            java.util.ArrayList r2 = (java.util.ArrayList) r2     // Catch:{ all -> 0x004f }
            r3 = 0
            if (r2 == 0) goto L_0x002f
            r2.add(r1)     // Catch:{ all -> 0x004f }
            monitor-exit(r8)     // Catch:{ all -> 0x004f }
            return r3
        L_0x002f:
            java.util.ArrayList r2 = new java.util.ArrayList     // Catch:{ all -> 0x004f }
            r2.<init>()     // Catch:{ all -> 0x004f }
            r2.add(r1)     // Catch:{ all -> 0x004f }
            androidx.collection.SimpleArrayMap<java.lang.String, java.util.ArrayList<androidx.core.util.Consumer<androidx.core.provider.FontRequestWorker$TypefaceResult>>> r1 = PENDING_REPLIES     // Catch:{ all -> 0x004f }
            r1.put(r0, r2)     // Catch:{ all -> 0x004f }
            monitor-exit(r8)     // Catch:{ all -> 0x004f }
            androidx.core.provider.FontRequestWorker$3 r8 = new androidx.core.provider.FontRequestWorker$3
            r8.<init>(r0, r4, r5, r6)
            if (r7 != 0) goto L_0x0046
            java.util.concurrent.ExecutorService r7 = DEFAULT_EXECUTOR_SERVICE
        L_0x0046:
            androidx.core.provider.FontRequestWorker$4 r4 = new androidx.core.provider.FontRequestWorker$4
            r4.<init>(r0)
            androidx.core.provider.RequestExecutor.execute(r7, r8, r4)
            return r3
        L_0x004f:
            r4 = move-exception
            monitor-exit(r8)     // Catch:{ all -> 0x004f }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.provider.FontRequestWorker.requestFontAsync(android.content.Context, androidx.core.provider.FontRequest, int, java.util.concurrent.Executor, androidx.core.provider.CallbackWithHandler):android.graphics.Typeface");
    }

    private static String createCacheId(FontRequest fontRequest, int i) {
        return fontRequest.getId() + "-" + i;
    }

    static TypefaceResult getFontSync(String str, Context context, FontRequest fontRequest, int i) {
        Typeface typeface = sTypefaceCache.get(str);
        if (typeface != null) {
            return new TypefaceResult(typeface);
        }
        try {
            FontsContractCompat.FontFamilyResult fontFamilyResult = FontProvider.getFontFamilyResult(context, fontRequest, (CancellationSignal) null);
            int fontFamilyResultStatus = getFontFamilyResultStatus(fontFamilyResult);
            if (fontFamilyResultStatus != 0) {
                return new TypefaceResult(fontFamilyResultStatus);
            }
            Typeface createFromFontInfo = TypefaceCompat.createFromFontInfo(context, (CancellationSignal) null, fontFamilyResult.getFonts(), i);
            if (createFromFontInfo == null) {
                return new TypefaceResult(-3);
            }
            sTypefaceCache.put(str, createFromFontInfo);
            return new TypefaceResult(createFromFontInfo);
        } catch (PackageManager.NameNotFoundException unused) {
            return new TypefaceResult(-1);
        }
    }

    private static int getFontFamilyResultStatus(FontsContractCompat.FontFamilyResult fontFamilyResult) {
        int i = 1;
        if (fontFamilyResult.getStatusCode() == 0) {
            FontsContractCompat.FontInfo[] fonts = fontFamilyResult.getFonts();
            if (!(fonts == null || fonts.length == 0)) {
                int length = fonts.length;
                i = 0;
                int i2 = 0;
                while (i2 < length) {
                    int resultCode = fonts[i2].getResultCode();
                    if (resultCode == 0) {
                        i2++;
                    } else if (resultCode < 0) {
                        return -3;
                    } else {
                        return resultCode;
                    }
                }
            }
            return i;
        } else if (fontFamilyResult.getStatusCode() != 1) {
            return -3;
        } else {
            return -2;
        }
    }

    static final class TypefaceResult {
        final int mResult;
        final Typeface mTypeface;

        TypefaceResult(int i) {
            this.mTypeface = null;
            this.mResult = i;
        }

        TypefaceResult(Typeface typeface) {
            this.mTypeface = typeface;
            this.mResult = 0;
        }

        /* access modifiers changed from: package-private */
        public boolean isSuccess() {
            return this.mResult == 0;
        }
    }
}
