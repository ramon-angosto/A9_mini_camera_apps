package com.meizu.cloud.pushsdk.platform.a;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.meizu.cloud.pushinternal.DebugLogger;
import com.meizu.cloud.pushsdk.a.c.a;
import com.meizu.cloud.pushsdk.a.e.k;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.meizu.cloud.pushsdk.platform.PlatformMessageSender;
import com.meizu.cloud.pushsdk.platform.message.BasicPushStatus;
import com.meizu.cloud.pushsdk.platform.message.PushSwitchStatus;
import com.meizu.cloud.pushsdk.platform.message.RegisterStatus;
import com.meizu.cloud.pushsdk.platform.message.SubAliasStatus;
import com.meizu.cloud.pushsdk.platform.message.SubTagsStatus;
import com.meizu.cloud.pushsdk.platform.message.UnRegisterStatus;
import com.meizu.cloud.pushsdk.util.MzSystemUtils;
import com.meizu.cloud.pushsdk.util.c;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class b {
    private static b a;
    private ExecutorService b = Executors.newSingleThreadExecutor();
    /* access modifiers changed from: private */
    public Handler c = new Handler(this.d.getMainLooper()) {
        public void handleMessage(Message message) {
            String string = message.getData().getString("deviceId");
            String string2 = message.getData().getString("appId");
            String string3 = message.getData().getString("appKey");
            int i = message.what;
            if (i == 0) {
                b.this.a(string2, string3, string);
            } else if (i == 1) {
                b.this.b(string2, string3, string);
            } else if (i == 2) {
                b.this.c(message.getData().getString("packageName"), string);
            }
        }
    };
    /* access modifiers changed from: private */
    public Context d;
    private a e;

    public b(Context context) {
        this.d = context;
        this.e = new a(context);
    }

    public static synchronized b a(Context context) {
        b bVar;
        synchronized (b.class) {
            if (a == null) {
                a = new b(context);
            }
            bVar = a;
        }
        return bVar;
    }

    public void a(String str, String str2) {
        String a2 = c.a(this.d);
        int b2 = c.b(this.d);
        if (!TextUtils.isEmpty(a2)) {
            long j = (long) b2;
            if (System.currentTimeMillis() / 1000 < j) {
                RegisterStatus registerStatus = new RegisterStatus();
                registerStatus.setCode(BasicPushStatus.SUCCESS_CODE);
                registerStatus.setMessage("already register PushId,dont register frequently");
                registerStatus.setPushId(a2);
                registerStatus.setExpireTime((int) (j - (System.currentTimeMillis() / 1000)));
                PlatformMessageSender.a(this.d, registerStatus);
                return;
            }
        }
        a(0, str, str2);
    }

    public void a(String str, String str2, String str3) {
        this.e.a(str, str2, str3, new k() {
            public void a(com.meizu.cloud.pushsdk.a.d.k kVar, String str) {
                DebugLogger.e("PushPlatformManager", str.toString());
                RegisterStatus registerStatus = new RegisterStatus(str.toString());
                DebugLogger.e("PushPlatformManager", "registerStatus " + registerStatus);
                PlatformMessageSender.a(b.this.d, registerStatus);
            }

            public void a(a aVar) {
                if (aVar.a() != null) {
                    DebugLogger.e("PushPlatformManager", "status code=" + aVar.c() + " data=" + aVar.a());
                }
                RegisterStatus registerStatus = new RegisterStatus();
                registerStatus.setCode(String.valueOf(aVar.c()));
                registerStatus.setMessage(aVar.e());
                DebugLogger.e("PushPlatformManager", "registerStatus " + registerStatus);
                PlatformMessageSender.a(b.this.d, registerStatus);
            }
        });
    }

    public void b(String str, String str2) {
        if (TextUtils.isEmpty(c.a(this.d))) {
            UnRegisterStatus unRegisterStatus = new UnRegisterStatus();
            unRegisterStatus.setCode(BasicPushStatus.SUCCESS_CODE);
            unRegisterStatus.setMessage("already unRegister PushId,dont unRegister frequently");
            unRegisterStatus.setIsUnRegisterSuccess(true);
            PlatformMessageSender.a(this.d, unRegisterStatus);
            return;
        }
        a(1, str, str2);
    }

    public void b(String str, String str2, String str3) {
        this.e.b(str, str2, str3, new k() {
            public void a(com.meizu.cloud.pushsdk.a.d.k kVar, String str) {
                DebugLogger.e("PushPlatformManager", "unRegister" + str.toString());
                UnRegisterStatus unRegisterStatus = new UnRegisterStatus(str.toString());
                DebugLogger.e("PushPlatformManager", "unRegisterStatus " + unRegisterStatus);
                PlatformMessageSender.a(b.this.d, unRegisterStatus);
            }

            public void a(a aVar) {
                UnRegisterStatus unRegisterStatus = new UnRegisterStatus();
                unRegisterStatus.setCode(String.valueOf(aVar.c()));
                unRegisterStatus.setIsUnRegisterSuccess(false);
                unRegisterStatus.setMessage(aVar.e());
                DebugLogger.e("PushPlatformManager", "unRegisterStatus " + unRegisterStatus);
                PlatformMessageSender.a(b.this.d, unRegisterStatus);
            }
        });
    }

    public void a(final String str) {
        this.b.execute(new Runnable() {
            public void run() {
                String b2 = MzSystemUtils.b(b.this.d);
                Message obtainMessage = b.this.c.obtainMessage();
                Bundle bundle = new Bundle();
                bundle.putString("deviceId", b2);
                bundle.putString("packageName", str);
                obtainMessage.setData(bundle);
                obtainMessage.what = 2;
                DebugLogger.e("PushPlatformManager", "deviceId " + b2 + "packageName " + str);
                b.this.c.sendMessage(obtainMessage);
            }
        });
    }

    public void c(final String str, String str2) {
        this.e.a(str, str2, new k() {
            public void a(com.meizu.cloud.pushsdk.a.d.k kVar, String str) {
                DebugLogger.e("PushPlatformManager", "unregisetr advance pakcage " + str + " result " + str);
            }

            public void a(a aVar) {
                DebugLogger.e("PushPlatformManager", "unregisetr advance pakcage " + str + " error " + aVar.e());
            }
        });
    }

    public void c(String str, String str2, String str3) {
        this.e.c(str, str2, str3, new k() {
            public void a(com.meizu.cloud.pushsdk.a.d.k kVar, String str) {
                DebugLogger.e("PushPlatformManager", "checkPush" + str.toString());
                PushSwitchStatus pushSwitchStatus = new PushSwitchStatus(str.toString());
                DebugLogger.e("PushPlatformManager", "pushSwitchStatus " + pushSwitchStatus);
                PlatformMessageSender.a(b.this.d, pushSwitchStatus);
            }

            public void a(a aVar) {
                PushSwitchStatus pushSwitchStatus = new PushSwitchStatus();
                pushSwitchStatus.setCode(String.valueOf(aVar.c()));
                pushSwitchStatus.setMessage(aVar.e());
                DebugLogger.e("PushPlatformManager", "pushSwitchStatus " + pushSwitchStatus);
                PlatformMessageSender.a(b.this.d, pushSwitchStatus);
            }
        });
    }

    public void a(String str, String str2, String str3, int i, boolean z) {
        if (i == 0) {
            Context context = this.d;
            c.a(context, context.getPackageName(), z);
        } else if (i == 1) {
            Context context2 = this.d;
            c.b(context2, context2.getPackageName(), z);
        }
        if (TextUtils.isEmpty(str3)) {
            str3 = PushConstants.PUSH_TYPE_NOTIFY;
        }
        this.e.a(str, str2, str3, i, z, new k() {
            public void a(com.meizu.cloud.pushsdk.a.d.k kVar, String str) {
                DebugLogger.e("PushPlatformManager", "switchPush" + str.toString());
                PushSwitchStatus pushSwitchStatus = new PushSwitchStatus(str.toString());
                DebugLogger.e("PushPlatformManager", "switchPush" + pushSwitchStatus);
                PlatformMessageSender.a(b.this.d, pushSwitchStatus);
            }

            public void a(a aVar) {
                PushSwitchStatus pushSwitchStatus = new PushSwitchStatus();
                pushSwitchStatus.setCode(String.valueOf(aVar.c()));
                pushSwitchStatus.setMessage(aVar.e());
                DebugLogger.e("PushPlatformManager", "pushSwitchStatus " + pushSwitchStatus);
                PlatformMessageSender.a(b.this.d, pushSwitchStatus);
            }
        });
        Context context3 = this.d;
        PlatformMessageSender.a(context3, i, z, context3.getPackageName());
    }

    public void a(String str, String str2, String str3, String str4) {
        this.e.a(str, str2, str3, str4, new k() {
            public void a(com.meizu.cloud.pushsdk.a.d.k kVar, String str) {
                DebugLogger.e("PushPlatformManager", "subScribeTags" + str.toString());
                SubTagsStatus subTagsStatus = new SubTagsStatus(str.toString());
                DebugLogger.e("PushPlatformManager", "subScribeTags " + subTagsStatus.getTagList());
                PlatformMessageSender.a(b.this.d, subTagsStatus);
            }

            public void a(a aVar) {
                SubTagsStatus subTagsStatus = new SubTagsStatus();
                subTagsStatus.setCode(String.valueOf(aVar.c()));
                subTagsStatus.setMessage(aVar.e());
                DebugLogger.e("PushPlatformManager", "subScribeTags " + subTagsStatus);
                PlatformMessageSender.a(b.this.d, subTagsStatus);
            }
        });
    }

    public void b(String str, String str2, String str3, String str4) {
        this.e.b(str, str2, str3, str4, new k() {
            public void a(com.meizu.cloud.pushsdk.a.d.k kVar, String str) {
                DebugLogger.e("PushPlatformManager", "unSubScribeTags " + str.toString());
                SubTagsStatus subTagsStatus = new SubTagsStatus(str.toString());
                DebugLogger.e("PushPlatformManager", "unSubScribeTags " + subTagsStatus);
                PlatformMessageSender.a(b.this.d, subTagsStatus);
            }

            public void a(a aVar) {
                SubTagsStatus subTagsStatus = new SubTagsStatus();
                subTagsStatus.setCode(String.valueOf(aVar.c()));
                subTagsStatus.setMessage(aVar.e());
                DebugLogger.e("PushPlatformManager", "subScribeTags " + subTagsStatus);
                PlatformMessageSender.a(b.this.d, subTagsStatus);
            }
        });
    }

    public void d(String str, String str2, String str3) {
        this.e.d(str, str2, str3, new k() {
            public void a(com.meizu.cloud.pushsdk.a.d.k kVar, String str) {
                DebugLogger.e("PushPlatformManager", "checkSubScribeTags " + str.toString());
                SubTagsStatus subTagsStatus = new SubTagsStatus(str.toString());
                DebugLogger.e("PushPlatformManager", "checkSubScribeTags " + subTagsStatus);
                PlatformMessageSender.a(b.this.d, subTagsStatus);
            }

            public void a(a aVar) {
                SubTagsStatus subTagsStatus = new SubTagsStatus();
                subTagsStatus.setCode(String.valueOf(aVar.c()));
                subTagsStatus.setMessage(aVar.b() + aVar.e());
                DebugLogger.e("PushPlatformManager", "subScribeTags " + subTagsStatus);
                PlatformMessageSender.a(b.this.d, subTagsStatus);
            }
        });
    }

    public void c(String str, String str2, String str3, String str4) {
        this.e.c(str, str2, str3, str4, new k() {
            public void a(com.meizu.cloud.pushsdk.a.d.k kVar, String str) {
                DebugLogger.e("PushPlatformManager", "subScribeAlias " + str.toString());
                SubAliasStatus subAliasStatus = new SubAliasStatus(str.toString());
                DebugLogger.e("PushPlatformManager", "subScribeAlias " + subAliasStatus);
                PlatformMessageSender.a(b.this.d, subAliasStatus);
            }

            public void a(a aVar) {
                SubAliasStatus subAliasStatus = new SubAliasStatus();
                subAliasStatus.setCode(String.valueOf(aVar.c()));
                subAliasStatus.setMessage(aVar.b() + " " + aVar.e());
                StringBuilder sb = new StringBuilder();
                sb.append("subScribeAlias ");
                sb.append(subAliasStatus);
                DebugLogger.e("PushPlatformManager", sb.toString());
                PlatformMessageSender.a(b.this.d, subAliasStatus);
            }
        });
    }

    public void d(String str, String str2, String str3, String str4) {
        this.e.d(str, str2, str3, str4, new k() {
            public void a(com.meizu.cloud.pushsdk.a.d.k kVar, String str) {
                DebugLogger.e("PushPlatformManager", "unSubScribeAlias " + str.toString());
                SubAliasStatus subAliasStatus = new SubAliasStatus(str.toString());
                DebugLogger.e("PushPlatformManager", "unSubScribeAlias " + subAliasStatus);
                PlatformMessageSender.a(b.this.d, subAliasStatus);
            }

            public void a(a aVar) {
                SubAliasStatus subAliasStatus = new SubAliasStatus();
                subAliasStatus.setCode(String.valueOf(aVar.c()));
                subAliasStatus.setMessage(aVar.e());
                DebugLogger.e("PushPlatformManager", "subScribeAlias " + subAliasStatus);
                PlatformMessageSender.a(b.this.d, subAliasStatus);
            }
        });
    }

    public void e(String str, String str2, String str3) {
        this.e.e(str, str2, str3, new k() {
            public void a(com.meizu.cloud.pushsdk.a.d.k kVar, String str) {
                DebugLogger.e("PushPlatformManager", "checkSubScribeAlias " + str.toString());
                SubAliasStatus subAliasStatus = new SubAliasStatus(str.toString());
                DebugLogger.e("PushPlatformManager", "checkSubScribeAlias " + subAliasStatus);
                PlatformMessageSender.a(b.this.d, subAliasStatus);
            }

            public void a(a aVar) {
                SubAliasStatus subAliasStatus = new SubAliasStatus();
                subAliasStatus.setCode(String.valueOf(aVar.c()));
                subAliasStatus.setMessage(aVar.e());
                DebugLogger.e("PushPlatformManager", "subScribeAlias " + subAliasStatus);
                PlatformMessageSender.a(b.this.d, subAliasStatus);
            }
        });
    }

    private void a(final int i, final String str, final String str2) {
        this.b.execute(new Runnable() {
            public void run() {
                String b2 = MzSystemUtils.b(b.this.d);
                Message obtainMessage = b.this.c.obtainMessage();
                Bundle bundle = new Bundle();
                bundle.putString("deviceId", b2);
                bundle.putString("appId", str);
                bundle.putString("appKey", str2);
                obtainMessage.setData(bundle);
                obtainMessage.what = i;
                DebugLogger.e("PushPlatformManager", "deviceId " + b2);
                b.this.c.sendMessage(obtainMessage);
                if (!TextUtils.isEmpty(b2)) {
                    DebugLogger.i("PushPlatformManager", "put deviceId " + b2 + " to preference");
                    c.b(b.this.d, b2);
                }
            }
        });
    }
}
