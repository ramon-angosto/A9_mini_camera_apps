package com.meizu.cloud.pushsdk;

import android.content.Context;
import android.content.Intent;
import com.meizu.cloud.pushinternal.DebugLogger;
import com.meizu.cloud.pushsdk.handler.a.b;
import com.meizu.cloud.pushsdk.handler.a.d;
import com.meizu.cloud.pushsdk.handler.a.e;
import com.meizu.cloud.pushsdk.handler.a.f;
import com.meizu.cloud.pushsdk.handler.c;
import com.meizu.cloud.pushsdk.notification.PushNotificationBuilder;
import com.meizu.cloud.pushsdk.platform.message.PushSwitchStatus;
import com.meizu.cloud.pushsdk.platform.message.RegisterStatus;
import com.meizu.cloud.pushsdk.platform.message.SubAliasStatus;
import com.meizu.cloud.pushsdk.platform.message.SubTagsStatus;
import com.meizu.cloud.pushsdk.platform.message.UnRegisterStatus;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class a {
    static volatile a a;
    private Context b;
    private Map<Integer, c> c;
    /* access modifiers changed from: private */
    public Map<String, com.meizu.cloud.pushsdk.handler.a> d;

    public a(Context context) {
        this(context, (List<c>) null);
    }

    public a(Context context, List<c> list) {
        this(context, list, (com.meizu.cloud.pushsdk.handler.a) null);
    }

    public a(Context context, List<c> list, com.meizu.cloud.pushsdk.handler.a aVar) {
        this.c = new HashMap();
        this.d = null;
        if (context != null) {
            this.b = context.getApplicationContext();
            this.d = new HashMap();
            C0039a aVar2 = new C0039a();
            if (list == null) {
                a((c) new com.meizu.cloud.pushsdk.handler.a.c(context, aVar2));
                a((c) new b(context, aVar2));
                a((c) new e(context, aVar2));
                a((c) new com.meizu.cloud.pushsdk.handler.a.a.a(context, aVar2));
                a((c) new d(context, aVar2));
                a((c) new f(context, aVar2));
                a((c) new com.meizu.cloud.pushsdk.handler.a.a.b(context, aVar2));
                a((c) new com.meizu.cloud.pushsdk.handler.a.b.a(context, aVar2));
                a((c) new com.meizu.cloud.pushsdk.handler.a.b.c(context, aVar2));
                a((c) new com.meizu.cloud.pushsdk.handler.a.b.f(context, aVar2));
                a((c) new com.meizu.cloud.pushsdk.handler.a.b.d(context, aVar2));
                a((c) new com.meizu.cloud.pushsdk.handler.a.b.e(context, aVar2));
                a((c) new com.meizu.cloud.pushsdk.handler.a.c.a(context, aVar2));
                a((c) new com.meizu.cloud.pushsdk.handler.a.b.b(context, aVar2));
                return;
            }
            a(list);
            return;
        }
        throw new IllegalArgumentException("Context must not be null.");
    }

    public static a a(Context context) {
        if (a == null) {
            synchronized (a.class) {
                if (a == null) {
                    DebugLogger.i("PushMessageProxy", "PushMessageProxy init");
                    a = new a(context);
                }
            }
        }
        return a;
    }

    public a a(String str, com.meizu.cloud.pushsdk.handler.a aVar) {
        this.d.put(str, aVar);
        return this;
    }

    public a a(c cVar) {
        this.c.put(Integer.valueOf(cVar.a()), cVar);
        return this;
    }

    public a a(List<c> list) {
        if (list != null) {
            for (c a2 : list) {
                a(a2);
            }
            return this;
        }
        throw new IllegalArgumentException("messageManagerList must not be null.");
    }

    /* JADX WARNING: Removed duplicated region for block: B:1:0x0024 A[LOOP:0: B:1:0x0024->B:4:0x003a, LOOP_START] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(android.content.Intent r3) {
        /*
            r2 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "is onMainThread "
            r0.append(r1)
            boolean r1 = r2.a()
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "PushMessageProxy"
            com.meizu.cloud.pushinternal.DebugLogger.e(r1, r0)
            java.util.Map<java.lang.Integer, com.meizu.cloud.pushsdk.handler.c> r0 = r2.c
            java.util.Set r0 = r0.entrySet()
            java.util.Iterator r0 = r0.iterator()
        L_0x0024:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x003c
            java.lang.Object r1 = r0.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            java.lang.Object r1 = r1.getValue()
            com.meizu.cloud.pushsdk.handler.c r1 = (com.meizu.cloud.pushsdk.handler.c) r1
            boolean r1 = r1.b(r3)
            if (r1 == 0) goto L_0x0024
        L_0x003c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.cloud.pushsdk.a.a(android.content.Intent):void");
    }

    /* access modifiers changed from: protected */
    public boolean a() {
        return Thread.currentThread() == this.b.getMainLooper().getThread();
    }

    /* renamed from: com.meizu.cloud.pushsdk.a$a  reason: collision with other inner class name */
    public class C0039a extends com.meizu.cloud.pushsdk.handler.a {
        public C0039a() {
        }

        public void a(Context context, Intent intent) {
            for (Map.Entry value : a.this.d.entrySet()) {
                com.meizu.cloud.pushsdk.handler.a aVar = (com.meizu.cloud.pushsdk.handler.a) value.getValue();
                if (aVar != null) {
                    aVar.a(context, intent);
                }
            }
        }

        public void a(Context context, String str) {
            for (Map.Entry value : a.this.d.entrySet()) {
                com.meizu.cloud.pushsdk.handler.a aVar = (com.meizu.cloud.pushsdk.handler.a) value.getValue();
                if (aVar != null) {
                    aVar.a(context, str);
                }
            }
        }

        public void b(Context context, String str) {
            for (Map.Entry value : a.this.d.entrySet()) {
                com.meizu.cloud.pushsdk.handler.a aVar = (com.meizu.cloud.pushsdk.handler.a) value.getValue();
                if (aVar != null) {
                    aVar.b(context, str);
                }
            }
        }

        public void a(Context context, boolean z) {
            for (Map.Entry value : a.this.d.entrySet()) {
                com.meizu.cloud.pushsdk.handler.a aVar = (com.meizu.cloud.pushsdk.handler.a) value.getValue();
                if (aVar != null) {
                    aVar.a(context, z);
                }
            }
        }

        public void a(PushNotificationBuilder pushNotificationBuilder) {
            for (Map.Entry value : a.this.d.entrySet()) {
                com.meizu.cloud.pushsdk.handler.a aVar = (com.meizu.cloud.pushsdk.handler.a) value.getValue();
                if (aVar != null) {
                    aVar.a(pushNotificationBuilder);
                }
            }
        }

        public void a(Context context, PushSwitchStatus pushSwitchStatus) {
            for (Map.Entry value : a.this.d.entrySet()) {
                com.meizu.cloud.pushsdk.handler.a aVar = (com.meizu.cloud.pushsdk.handler.a) value.getValue();
                if (aVar != null) {
                    aVar.a(context, pushSwitchStatus);
                }
            }
        }

        public void a(Context context, RegisterStatus registerStatus) {
            for (Map.Entry value : a.this.d.entrySet()) {
                com.meizu.cloud.pushsdk.handler.a aVar = (com.meizu.cloud.pushsdk.handler.a) value.getValue();
                if (aVar != null) {
                    aVar.a(context, registerStatus);
                }
            }
        }

        public void a(Context context, UnRegisterStatus unRegisterStatus) {
            for (Map.Entry value : a.this.d.entrySet()) {
                com.meizu.cloud.pushsdk.handler.a aVar = (com.meizu.cloud.pushsdk.handler.a) value.getValue();
                if (aVar != null) {
                    aVar.a(context, unRegisterStatus);
                }
            }
        }

        public void a(Context context, SubTagsStatus subTagsStatus) {
            for (Map.Entry value : a.this.d.entrySet()) {
                com.meizu.cloud.pushsdk.handler.a aVar = (com.meizu.cloud.pushsdk.handler.a) value.getValue();
                if (aVar != null) {
                    aVar.a(context, subTagsStatus);
                }
            }
        }

        public void a(Context context, SubAliasStatus subAliasStatus) {
            for (Map.Entry value : a.this.d.entrySet()) {
                com.meizu.cloud.pushsdk.handler.a aVar = (com.meizu.cloud.pushsdk.handler.a) value.getValue();
                if (aVar != null) {
                    aVar.a(context, subAliasStatus);
                }
            }
        }

        public void a(Context context, String str, String str2, String str3) {
            for (Map.Entry value : a.this.d.entrySet()) {
                com.meizu.cloud.pushsdk.handler.a aVar = (com.meizu.cloud.pushsdk.handler.a) value.getValue();
                if (aVar != null) {
                    aVar.a(context, str, str2, str3);
                }
            }
        }

        public void b(Context context, String str, String str2, String str3) {
            for (Map.Entry value : a.this.d.entrySet()) {
                com.meizu.cloud.pushsdk.handler.a aVar = (com.meizu.cloud.pushsdk.handler.a) value.getValue();
                if (aVar != null) {
                    aVar.b(context, str, str2, str3);
                }
            }
        }

        public void c(Context context, String str, String str2, String str3) {
            for (Map.Entry value : a.this.d.entrySet()) {
                com.meizu.cloud.pushsdk.handler.a aVar = (com.meizu.cloud.pushsdk.handler.a) value.getValue();
                if (aVar != null) {
                    aVar.c(context, str, str2, str3);
                }
            }
        }

        public void c(Context context, String str) {
            for (Map.Entry value : a.this.d.entrySet()) {
                com.meizu.cloud.pushsdk.handler.a aVar = (com.meizu.cloud.pushsdk.handler.a) value.getValue();
                if (aVar != null) {
                    aVar.c(context, str);
                }
            }
        }
    }
}
