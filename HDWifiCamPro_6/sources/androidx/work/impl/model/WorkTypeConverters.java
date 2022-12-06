package androidx.work.impl.model;

import android.os.Build;
import androidx.work.BackoffPolicy;
import androidx.work.NetworkType;
import androidx.work.OutOfQuotaPolicy;
import androidx.work.WorkInfo;

public class WorkTypeConverters {

    public interface BackoffPolicyIds {
        public static final int EXPONENTIAL = 0;
        public static final int LINEAR = 1;
    }

    public interface NetworkTypeIds {
        public static final int CONNECTED = 1;
        public static final int METERED = 4;
        public static final int NOT_REQUIRED = 0;
        public static final int NOT_ROAMING = 3;
        public static final int TEMPORARILY_UNMETERED = 5;
        public static final int UNMETERED = 2;
    }

    public interface OutOfPolicyIds {
        public static final int DROP_WORK_REQUEST = 1;
        public static final int RUN_AS_NON_EXPEDITED_WORK_REQUEST = 0;
    }

    public interface StateIds {
        public static final int BLOCKED = 4;
        public static final int CANCELLED = 5;
        public static final String COMPLETED_STATES = "(2, 3, 5)";
        public static final int ENQUEUED = 0;
        public static final int FAILED = 3;
        public static final int RUNNING = 1;
        public static final int SUCCEEDED = 2;
    }

    public static int stateToInt(WorkInfo.State state) {
        switch (state) {
            case ENQUEUED:
                return 0;
            case RUNNING:
                return 1;
            case SUCCEEDED:
                return 2;
            case FAILED:
                return 3;
            case BLOCKED:
                return 4;
            case CANCELLED:
                return 5;
            default:
                throw new IllegalArgumentException("Could not convert " + state + " to int");
        }
    }

    public static WorkInfo.State intToState(int i) {
        if (i == 0) {
            return WorkInfo.State.ENQUEUED;
        }
        if (i == 1) {
            return WorkInfo.State.RUNNING;
        }
        if (i == 2) {
            return WorkInfo.State.SUCCEEDED;
        }
        if (i == 3) {
            return WorkInfo.State.FAILED;
        }
        if (i == 4) {
            return WorkInfo.State.BLOCKED;
        }
        if (i == 5) {
            return WorkInfo.State.CANCELLED;
        }
        throw new IllegalArgumentException("Could not convert " + i + " to State");
    }

    public static int backoffPolicyToInt(BackoffPolicy backoffPolicy) {
        int i = AnonymousClass1.$SwitchMap$androidx$work$BackoffPolicy[backoffPolicy.ordinal()];
        if (i == 1) {
            return 0;
        }
        if (i == 2) {
            return 1;
        }
        throw new IllegalArgumentException("Could not convert " + backoffPolicy + " to int");
    }

    public static BackoffPolicy intToBackoffPolicy(int i) {
        if (i == 0) {
            return BackoffPolicy.EXPONENTIAL;
        }
        if (i == 1) {
            return BackoffPolicy.LINEAR;
        }
        throw new IllegalArgumentException("Could not convert " + i + " to BackoffPolicy");
    }

    public static int networkTypeToInt(NetworkType networkType) {
        int i = AnonymousClass1.$SwitchMap$androidx$work$NetworkType[networkType.ordinal()];
        if (i == 1) {
            return 0;
        }
        if (i == 2) {
            return 1;
        }
        if (i == 3) {
            return 2;
        }
        if (i == 4) {
            return 3;
        }
        if (i == 5) {
            return 4;
        }
        if (Build.VERSION.SDK_INT >= 30 && networkType == NetworkType.TEMPORARILY_UNMETERED) {
            return 5;
        }
        throw new IllegalArgumentException("Could not convert " + networkType + " to int");
    }

    public static NetworkType intToNetworkType(int i) {
        if (i == 0) {
            return NetworkType.NOT_REQUIRED;
        }
        if (i == 1) {
            return NetworkType.CONNECTED;
        }
        if (i == 2) {
            return NetworkType.UNMETERED;
        }
        if (i == 3) {
            return NetworkType.NOT_ROAMING;
        }
        if (i == 4) {
            return NetworkType.METERED;
        }
        if (Build.VERSION.SDK_INT >= 30 && i == 5) {
            return NetworkType.TEMPORARILY_UNMETERED;
        }
        throw new IllegalArgumentException("Could not convert " + i + " to NetworkType");
    }

    /* renamed from: androidx.work.impl.model.WorkTypeConverters$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$androidx$work$BackoffPolicy = new int[BackoffPolicy.values().length];
        static final /* synthetic */ int[] $SwitchMap$androidx$work$NetworkType = new int[NetworkType.values().length];
        static final /* synthetic */ int[] $SwitchMap$androidx$work$OutOfQuotaPolicy = new int[OutOfQuotaPolicy.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(31:0|(2:1|2)|3|(2:5|6)|7|9|10|(2:11|12)|13|15|16|17|(2:19|20)|21|(2:23|24)|25|27|28|(2:29|30)|31|33|34|35|36|37|38|39|40|41|42|(3:43|44|46)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(33:0|1|2|3|(2:5|6)|7|9|10|(2:11|12)|13|15|16|17|19|20|21|(2:23|24)|25|27|28|(2:29|30)|31|33|34|35|36|37|38|39|40|41|42|(3:43|44|46)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(38:0|1|2|3|5|6|7|9|10|11|12|13|15|16|17|19|20|21|23|24|25|27|28|(2:29|30)|31|33|34|35|36|37|38|39|40|41|42|43|44|46) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0032 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x0070 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:35:0x008d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:37:0x0097 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:39:0x00a1 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:41:0x00ab */
        /* JADX WARNING: Missing exception handler attribute for start block: B:43:0x00b5 */
        static {
            /*
                androidx.work.OutOfQuotaPolicy[] r0 = androidx.work.OutOfQuotaPolicy.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$androidx$work$OutOfQuotaPolicy = r0
                r0 = 1
                int[] r1 = $SwitchMap$androidx$work$OutOfQuotaPolicy     // Catch:{ NoSuchFieldError -> 0x0014 }
                androidx.work.OutOfQuotaPolicy r2 = androidx.work.OutOfQuotaPolicy.RUN_AS_NON_EXPEDITED_WORK_REQUEST     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r1[r2] = r0     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                r1 = 2
                int[] r2 = $SwitchMap$androidx$work$OutOfQuotaPolicy     // Catch:{ NoSuchFieldError -> 0x001f }
                androidx.work.OutOfQuotaPolicy r3 = androidx.work.OutOfQuotaPolicy.DROP_WORK_REQUEST     // Catch:{ NoSuchFieldError -> 0x001f }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2[r3] = r1     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                androidx.work.NetworkType[] r2 = androidx.work.NetworkType.values()
                int r2 = r2.length
                int[] r2 = new int[r2]
                $SwitchMap$androidx$work$NetworkType = r2
                int[] r2 = $SwitchMap$androidx$work$NetworkType     // Catch:{ NoSuchFieldError -> 0x0032 }
                androidx.work.NetworkType r3 = androidx.work.NetworkType.NOT_REQUIRED     // Catch:{ NoSuchFieldError -> 0x0032 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0032 }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x0032 }
            L_0x0032:
                int[] r2 = $SwitchMap$androidx$work$NetworkType     // Catch:{ NoSuchFieldError -> 0x003c }
                androidx.work.NetworkType r3 = androidx.work.NetworkType.CONNECTED     // Catch:{ NoSuchFieldError -> 0x003c }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x003c }
                r2[r3] = r1     // Catch:{ NoSuchFieldError -> 0x003c }
            L_0x003c:
                r2 = 3
                int[] r3 = $SwitchMap$androidx$work$NetworkType     // Catch:{ NoSuchFieldError -> 0x0047 }
                androidx.work.NetworkType r4 = androidx.work.NetworkType.UNMETERED     // Catch:{ NoSuchFieldError -> 0x0047 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0047 }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x0047 }
            L_0x0047:
                r3 = 4
                int[] r4 = $SwitchMap$androidx$work$NetworkType     // Catch:{ NoSuchFieldError -> 0x0052 }
                androidx.work.NetworkType r5 = androidx.work.NetworkType.NOT_ROAMING     // Catch:{ NoSuchFieldError -> 0x0052 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0052 }
                r4[r5] = r3     // Catch:{ NoSuchFieldError -> 0x0052 }
            L_0x0052:
                r4 = 5
                int[] r5 = $SwitchMap$androidx$work$NetworkType     // Catch:{ NoSuchFieldError -> 0x005d }
                androidx.work.NetworkType r6 = androidx.work.NetworkType.METERED     // Catch:{ NoSuchFieldError -> 0x005d }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x005d }
                r5[r6] = r4     // Catch:{ NoSuchFieldError -> 0x005d }
            L_0x005d:
                androidx.work.BackoffPolicy[] r5 = androidx.work.BackoffPolicy.values()
                int r5 = r5.length
                int[] r5 = new int[r5]
                $SwitchMap$androidx$work$BackoffPolicy = r5
                int[] r5 = $SwitchMap$androidx$work$BackoffPolicy     // Catch:{ NoSuchFieldError -> 0x0070 }
                androidx.work.BackoffPolicy r6 = androidx.work.BackoffPolicy.EXPONENTIAL     // Catch:{ NoSuchFieldError -> 0x0070 }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x0070 }
                r5[r6] = r0     // Catch:{ NoSuchFieldError -> 0x0070 }
            L_0x0070:
                int[] r5 = $SwitchMap$androidx$work$BackoffPolicy     // Catch:{ NoSuchFieldError -> 0x007a }
                androidx.work.BackoffPolicy r6 = androidx.work.BackoffPolicy.LINEAR     // Catch:{ NoSuchFieldError -> 0x007a }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x007a }
                r5[r6] = r1     // Catch:{ NoSuchFieldError -> 0x007a }
            L_0x007a:
                androidx.work.WorkInfo$State[] r5 = androidx.work.WorkInfo.State.values()
                int r5 = r5.length
                int[] r5 = new int[r5]
                $SwitchMap$androidx$work$WorkInfo$State = r5
                int[] r5 = $SwitchMap$androidx$work$WorkInfo$State     // Catch:{ NoSuchFieldError -> 0x008d }
                androidx.work.WorkInfo$State r6 = androidx.work.WorkInfo.State.ENQUEUED     // Catch:{ NoSuchFieldError -> 0x008d }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x008d }
                r5[r6] = r0     // Catch:{ NoSuchFieldError -> 0x008d }
            L_0x008d:
                int[] r0 = $SwitchMap$androidx$work$WorkInfo$State     // Catch:{ NoSuchFieldError -> 0x0097 }
                androidx.work.WorkInfo$State r5 = androidx.work.WorkInfo.State.RUNNING     // Catch:{ NoSuchFieldError -> 0x0097 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0097 }
                r0[r5] = r1     // Catch:{ NoSuchFieldError -> 0x0097 }
            L_0x0097:
                int[] r0 = $SwitchMap$androidx$work$WorkInfo$State     // Catch:{ NoSuchFieldError -> 0x00a1 }
                androidx.work.WorkInfo$State r1 = androidx.work.WorkInfo.State.SUCCEEDED     // Catch:{ NoSuchFieldError -> 0x00a1 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00a1 }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00a1 }
            L_0x00a1:
                int[] r0 = $SwitchMap$androidx$work$WorkInfo$State     // Catch:{ NoSuchFieldError -> 0x00ab }
                androidx.work.WorkInfo$State r1 = androidx.work.WorkInfo.State.FAILED     // Catch:{ NoSuchFieldError -> 0x00ab }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00ab }
                r0[r1] = r3     // Catch:{ NoSuchFieldError -> 0x00ab }
            L_0x00ab:
                int[] r0 = $SwitchMap$androidx$work$WorkInfo$State     // Catch:{ NoSuchFieldError -> 0x00b5 }
                androidx.work.WorkInfo$State r1 = androidx.work.WorkInfo.State.BLOCKED     // Catch:{ NoSuchFieldError -> 0x00b5 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00b5 }
                r0[r1] = r4     // Catch:{ NoSuchFieldError -> 0x00b5 }
            L_0x00b5:
                int[] r0 = $SwitchMap$androidx$work$WorkInfo$State     // Catch:{ NoSuchFieldError -> 0x00c0 }
                androidx.work.WorkInfo$State r1 = androidx.work.WorkInfo.State.CANCELLED     // Catch:{ NoSuchFieldError -> 0x00c0 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00c0 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00c0 }
            L_0x00c0:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.work.impl.model.WorkTypeConverters.AnonymousClass1.<clinit>():void");
        }
    }

    public static int outOfQuotaPolicyToInt(OutOfQuotaPolicy outOfQuotaPolicy) {
        int i = AnonymousClass1.$SwitchMap$androidx$work$OutOfQuotaPolicy[outOfQuotaPolicy.ordinal()];
        if (i == 1) {
            return 0;
        }
        if (i == 2) {
            return 1;
        }
        throw new IllegalArgumentException("Could not convert " + outOfQuotaPolicy + " to int");
    }

    public static OutOfQuotaPolicy intToOutOfQuotaPolicy(int i) {
        if (i == 0) {
            return OutOfQuotaPolicy.RUN_AS_NON_EXPEDITED_WORK_REQUEST;
        }
        if (i == 1) {
            return OutOfQuotaPolicy.DROP_WORK_REQUEST;
        }
        throw new IllegalArgumentException("Could not convert " + i + " to OutOfQuotaPolicy");
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x005a A[SYNTHETIC, Splitter:B:26:0x005a] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0071 A[SYNTHETIC, Splitter:B:37:0x0071] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:30:0x0062=Splitter:B:30:0x0062, B:15:0x0048=Splitter:B:15:0x0048} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static byte[] contentUriTriggersToByteArray(androidx.work.ContentUriTriggers r4) {
        /*
            int r0 = r4.size()
            r1 = 0
            if (r0 != 0) goto L_0x0008
            return r1
        L_0x0008:
            java.io.ByteArrayOutputStream r0 = new java.io.ByteArrayOutputStream
            r0.<init>()
            java.io.ObjectOutputStream r2 = new java.io.ObjectOutputStream     // Catch:{ IOException -> 0x0054 }
            r2.<init>(r0)     // Catch:{ IOException -> 0x0054 }
            int r1 = r4.size()     // Catch:{ IOException -> 0x004e, all -> 0x004c }
            r2.writeInt(r1)     // Catch:{ IOException -> 0x004e, all -> 0x004c }
            java.util.Set r4 = r4.getTriggers()     // Catch:{ IOException -> 0x004e, all -> 0x004c }
            java.util.Iterator r4 = r4.iterator()     // Catch:{ IOException -> 0x004e, all -> 0x004c }
        L_0x0021:
            boolean r1 = r4.hasNext()     // Catch:{ IOException -> 0x004e, all -> 0x004c }
            if (r1 == 0) goto L_0x0040
            java.lang.Object r1 = r4.next()     // Catch:{ IOException -> 0x004e, all -> 0x004c }
            androidx.work.ContentUriTriggers$Trigger r1 = (androidx.work.ContentUriTriggers.Trigger) r1     // Catch:{ IOException -> 0x004e, all -> 0x004c }
            android.net.Uri r3 = r1.getUri()     // Catch:{ IOException -> 0x004e, all -> 0x004c }
            java.lang.String r3 = r3.toString()     // Catch:{ IOException -> 0x004e, all -> 0x004c }
            r2.writeUTF(r3)     // Catch:{ IOException -> 0x004e, all -> 0x004c }
            boolean r1 = r1.shouldTriggerForDescendants()     // Catch:{ IOException -> 0x004e, all -> 0x004c }
            r2.writeBoolean(r1)     // Catch:{ IOException -> 0x004e, all -> 0x004c }
            goto L_0x0021
        L_0x0040:
            r2.close()     // Catch:{ IOException -> 0x0044 }
            goto L_0x0048
        L_0x0044:
            r4 = move-exception
            r4.printStackTrace()
        L_0x0048:
            r0.close()     // Catch:{ IOException -> 0x0066 }
            goto L_0x006a
        L_0x004c:
            r4 = move-exception
            goto L_0x006f
        L_0x004e:
            r4 = move-exception
            r1 = r2
            goto L_0x0055
        L_0x0051:
            r4 = move-exception
            r2 = r1
            goto L_0x006f
        L_0x0054:
            r4 = move-exception
        L_0x0055:
            r4.printStackTrace()     // Catch:{ all -> 0x0051 }
            if (r1 == 0) goto L_0x0062
            r1.close()     // Catch:{ IOException -> 0x005e }
            goto L_0x0062
        L_0x005e:
            r4 = move-exception
            r4.printStackTrace()
        L_0x0062:
            r0.close()     // Catch:{ IOException -> 0x0066 }
            goto L_0x006a
        L_0x0066:
            r4 = move-exception
            r4.printStackTrace()
        L_0x006a:
            byte[] r4 = r0.toByteArray()
            return r4
        L_0x006f:
            if (r2 == 0) goto L_0x0079
            r2.close()     // Catch:{ IOException -> 0x0075 }
            goto L_0x0079
        L_0x0075:
            r1 = move-exception
            r1.printStackTrace()
        L_0x0079:
            r0.close()     // Catch:{ IOException -> 0x007d }
            goto L_0x0081
        L_0x007d:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0081:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.work.impl.model.WorkTypeConverters.contentUriTriggersToByteArray(androidx.work.ContentUriTriggers):byte[]");
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x0046 A[SYNTHETIC, Splitter:B:25:0x0046] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x005a A[SYNTHETIC, Splitter:B:36:0x005a] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:15:0x0033=Splitter:B:15:0x0033, B:29:0x004e=Splitter:B:29:0x004e} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static androidx.work.ContentUriTriggers byteArrayToContentUriTriggers(byte[] r6) {
        /*
            androidx.work.ContentUriTriggers r0 = new androidx.work.ContentUriTriggers
            r0.<init>()
            if (r6 != 0) goto L_0x0008
            return r0
        L_0x0008:
            java.io.ByteArrayInputStream r1 = new java.io.ByteArrayInputStream
            r1.<init>(r6)
            r6 = 0
            java.io.ObjectInputStream r2 = new java.io.ObjectInputStream     // Catch:{ IOException -> 0x003d, all -> 0x0039 }
            r2.<init>(r1)     // Catch:{ IOException -> 0x003d, all -> 0x0039 }
            int r6 = r2.readInt()     // Catch:{ IOException -> 0x0037 }
        L_0x0017:
            if (r6 <= 0) goto L_0x002b
            java.lang.String r3 = r2.readUTF()     // Catch:{ IOException -> 0x0037 }
            android.net.Uri r3 = android.net.Uri.parse(r3)     // Catch:{ IOException -> 0x0037 }
            boolean r4 = r2.readBoolean()     // Catch:{ IOException -> 0x0037 }
            r0.add(r3, r4)     // Catch:{ IOException -> 0x0037 }
            int r6 = r6 + -1
            goto L_0x0017
        L_0x002b:
            r2.close()     // Catch:{ IOException -> 0x002f }
            goto L_0x0033
        L_0x002f:
            r6 = move-exception
            r6.printStackTrace()
        L_0x0033:
            r1.close()     // Catch:{ IOException -> 0x0052 }
            goto L_0x0056
        L_0x0037:
            r6 = move-exception
            goto L_0x0041
        L_0x0039:
            r0 = move-exception
            r2 = r6
            r6 = r0
            goto L_0x0058
        L_0x003d:
            r2 = move-exception
            r5 = r2
            r2 = r6
            r6 = r5
        L_0x0041:
            r6.printStackTrace()     // Catch:{ all -> 0x0057 }
            if (r2 == 0) goto L_0x004e
            r2.close()     // Catch:{ IOException -> 0x004a }
            goto L_0x004e
        L_0x004a:
            r6 = move-exception
            r6.printStackTrace()
        L_0x004e:
            r1.close()     // Catch:{ IOException -> 0x0052 }
            goto L_0x0056
        L_0x0052:
            r6 = move-exception
            r6.printStackTrace()
        L_0x0056:
            return r0
        L_0x0057:
            r6 = move-exception
        L_0x0058:
            if (r2 == 0) goto L_0x0062
            r2.close()     // Catch:{ IOException -> 0x005e }
            goto L_0x0062
        L_0x005e:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0062:
            r1.close()     // Catch:{ IOException -> 0x0066 }
            goto L_0x006a
        L_0x0066:
            r0 = move-exception
            r0.printStackTrace()
        L_0x006a:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.work.impl.model.WorkTypeConverters.byteArrayToContentUriTriggers(byte[]):androidx.work.ContentUriTriggers");
    }

    private WorkTypeConverters() {
    }
}
