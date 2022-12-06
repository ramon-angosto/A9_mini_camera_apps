package com.mbridge.msdk.foundation.same.c;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.mbridge.msdk.b.a;
import com.mbridge.msdk.foundation.same.a.c;
import com.mbridge.msdk.foundation.same.c.d;
import com.mbridge.msdk.foundation.tools.q;
import com.mbridge.msdk.foundation.tools.t;
import com.mbridge.msdk.foundation.tools.u;
import java.io.File;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;

/* compiled from: CommonImageLoader */
public final class b {
    private static b a;
    private com.mbridge.msdk.foundation.same.e.b b;
    private c<String, Bitmap> c;
    /* access modifiers changed from: private */
    public LinkedHashMap<String, List<c>> d = new LinkedHashMap<>();
    /* access modifiers changed from: private */
    public Handler e = new Handler(Looper.getMainLooper()) {
        public final void handleMessage(Message message) {
            try {
                if (message.what == 1) {
                    String string = message.getData().getString("message_key");
                    Bitmap a2 = a.a(message.getData().getString("message_bitmap"));
                    b.this.a(string, a2);
                    LinkedList linkedList = (LinkedList) b.this.d.get(string);
                    if (linkedList != null) {
                        Iterator it = linkedList.iterator();
                        while (it.hasNext()) {
                            c cVar = (c) it.next();
                            if (cVar != null) {
                                cVar.onSuccessLoad(a2, string);
                            }
                        }
                    }
                    b.this.d.remove(string);
                } else if (message.what == 2) {
                    String string2 = message.getData().getString("message_key");
                    String string3 = message.getData().getString("message_message");
                    LinkedList linkedList2 = (LinkedList) b.this.d.get(string2);
                    if (linkedList2 != null) {
                        Iterator it2 = linkedList2.iterator();
                        while (it2.hasNext()) {
                            c cVar2 = (c) it2.next();
                            if (cVar2 != null) {
                                cVar2.onFailedLoad(string3, string2);
                            }
                        }
                    }
                    b.this.d.remove(string2);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    };

    public final void a(String str, Bitmap bitmap) {
        if (d(str) == null && bitmap != null) {
            this.c.a(str, bitmap);
        }
    }

    private Bitmap d(String str) {
        return this.c.b(str);
    }

    private b(Context context) {
        this.b = new com.mbridge.msdk.foundation.same.e.b(context);
        a f = com.mbridge.msdk.b.b.a().f(com.mbridge.msdk.foundation.controller.a.e().h());
        int f2 = f != null ? f.f() : 10;
        this.c = new com.mbridge.msdk.foundation.same.a.a(((int) Runtime.getRuntime().maxMemory()) / (f2 <= 0 ? 10 : f2));
    }

    public static b a(Context context) {
        if (a == null) {
            a = new b(context);
        }
        return a;
    }

    public final void a() {
        this.c.b();
        LinkedHashMap<String, List<c>> linkedHashMap = this.d;
        if (linkedHashMap != null) {
            linkedHashMap.clear();
        }
    }

    public static void b() {
        a.c();
    }

    public final void a(String str, c cVar) {
        String a2 = t.a(str);
        if (!u.a(str) && !u.a(str) && !u.a(a2)) {
            File file = new File(a2);
            Bitmap d2 = d(str);
            if (d2 != null && !d2.isRecycled()) {
                cVar.onSuccessLoad(d2, str);
            } else if (file.exists()) {
                Bitmap a3 = a.a(a2);
                if (a3 == null || a3.isRecycled()) {
                    a(str, str, a2, true, false, cVar);
                    return;
                }
                a(str, a3);
                cVar.onSuccessLoad(a3, str);
            } else {
                a(str, str, a2, false, false, cVar);
            }
        }
    }

    public final Bitmap a(String str) {
        Bitmap a2;
        if (u.a(str)) {
            return null;
        }
        String a3 = t.a(str);
        File file = new File(a3);
        if (d(str) != null) {
            return d(str);
        }
        if (!file.exists() || (a2 = a.a(a3)) == null) {
            return null;
        }
        a(str, a2);
        return a2;
    }

    public final boolean b(String str) {
        if (u.a(str)) {
            return false;
        }
        File file = new File(t.a(str));
        if (d(str) == null && !file.exists()) {
            return false;
        }
        return true;
    }

    private void a(String str, String str2, String str3, boolean z, boolean z2, c cVar) {
        if (!this.d.containsKey(str2)) {
            LinkedList linkedList = new LinkedList();
            linkedList.add(cVar);
            this.d.put(str2, linkedList);
            this.b.a(a(str, str2, str3, z, z2));
            return;
        }
        LinkedList linkedList2 = (LinkedList) this.d.get(str2);
        if (linkedList2 != null && !linkedList2.contains(cVar)) {
            linkedList2.add(cVar);
        }
    }

    private d a(String str, String str2, String str3, boolean z, boolean z2) {
        AnonymousClass2 r6 = new d.a() {
            public final void a(String str, String str2) {
                Message obtainMessage = b.this.e.obtainMessage();
                obtainMessage.what = 1;
                Bundle bundle = new Bundle();
                bundle.putString("message_key", str);
                bundle.putString("message_bitmap", str2);
                obtainMessage.setData(bundle);
                b.this.e.sendMessage(obtainMessage);
            }

            public final void b(String str, String str2) {
                Message obtainMessage = b.this.e.obtainMessage();
                obtainMessage.what = 2;
                Bundle bundle = new Bundle();
                bundle.putString("message_key", str);
                bundle.putString("message_message", str2);
                obtainMessage.setData(bundle);
                b.this.e.sendMessage(obtainMessage);
            }
        };
        d dVar = new d(str, str2, str3);
        dVar.a(z);
        dVar.a((d.a) r6);
        return dVar;
    }

    public final void c() {
        c<String, Bitmap> cVar = this.c;
        if (cVar != null) {
            cVar.b();
        }
    }

    public final void c(String str) {
        try {
            if (this.c != null && this.c.a().contains(str)) {
                this.c.a(str);
            }
        } catch (Throwable th) {
            q.d("ImageLoader", th.getMessage());
        }
    }
}
