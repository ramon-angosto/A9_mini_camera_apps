package com.bykv.vk.openvk.component.video.a.a.a;

import android.os.Build;
import android.text.TextUtils;
import com.bykv.vk.openvk.component.video.api.a.b;
import com.bykv.vk.openvk.component.video.api.f.c;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* compiled from: MediaCacheDirImpl */
public class a implements b {
    private String a = "video_reward_full";
    private String b = "video_brand";
    private String c = "video_splash";
    private String d = "video_default";
    private String e = null;
    private String f = null;
    private String g = null;
    private String h = null;
    private String i = null;

    public void a(String str) {
        this.e = str;
    }

    public String c() {
        if (this.i == null) {
            this.i = this.e + File.separator + this.d;
            File file = new File(this.i);
            if (!file.exists()) {
                file.mkdirs();
            }
        }
        return this.i;
    }

    public String a() {
        if (this.f == null) {
            this.f = this.e + File.separator + this.a;
            File file = new File(this.f);
            if (!file.exists()) {
                file.mkdirs();
            }
        }
        return this.f;
    }

    public String e() {
        if (this.g == null) {
            this.g = this.e + File.separator + this.b;
            File file = new File(this.g);
            if (!file.exists()) {
                file.mkdirs();
            }
        }
        return this.g;
    }

    public String b() {
        if (this.h == null) {
            this.h = this.e + File.separator + this.c;
            File file = new File(this.h);
            if (!file.exists()) {
                file.mkdirs();
            }
        }
        return this.h;
    }

    public synchronized void d() {
        c.b("Exec clear video cache ");
        c.b(this.e);
        List<com.bykv.vk.openvk.component.video.api.a.a> f2 = f();
        if (Build.VERSION.SDK_INT >= 23) {
            Set<String> set = null;
            for (com.bykv.vk.openvk.component.video.api.a.a next : f2) {
                File[] a2 = next.a();
                if (a2 != null && a2.length >= next.b()) {
                    if (set == null) {
                        set = g();
                    }
                    int b2 = next.b() - 2;
                    if (b2 < 0) {
                        b2 = 0;
                    }
                    a(next.a(), b2, set);
                }
            }
        }
    }

    public boolean a(com.bykv.vk.openvk.component.video.api.c.c cVar) {
        if (TextUtils.isEmpty(cVar.a()) || TextUtils.isEmpty(cVar.l())) {
            return false;
        }
        return new File(cVar.a(), cVar.l()).exists();
    }

    public long b(com.bykv.vk.openvk.component.video.api.c.c cVar) {
        if (TextUtils.isEmpty(cVar.a()) || TextUtils.isEmpty(cVar.l())) {
            return 0;
        }
        return com.bykv.vk.openvk.component.video.a.e.c.a(cVar.a(), cVar.l());
    }

    private static void a(File[] fileArr, int i2, Set<String> set) {
        if (i2 >= 0 && fileArr != null) {
            try {
                if (fileArr.length > i2) {
                    List asList = Arrays.asList(fileArr);
                    Collections.sort(asList, new Comparator<File>() {
                        /* renamed from: a */
                        public int compare(File file, File file2) {
                            int i = ((file2.lastModified() - file.lastModified()) > 0 ? 1 : ((file2.lastModified() - file.lastModified()) == 0 ? 0 : -1));
                            if (i == 0) {
                                return 0;
                            }
                            return i < 0 ? -1 : 1;
                        }
                    });
                    while (i2 < asList.size()) {
                        File file = (File) asList.get(i2);
                        if (set != null && !set.contains(file.getAbsolutePath())) {
                            ((File) asList.get(i2)).delete();
                        }
                        i2++;
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    private List<com.bykv.vk.openvk.component.video.api.a.a> f() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new com.bykv.vk.openvk.component.video.api.a.a(new File(a()).listFiles(), com.bykv.vk.openvk.component.video.a.a.c()));
        arrayList.add(new com.bykv.vk.openvk.component.video.api.a.a(new File(b()).listFiles(), com.bykv.vk.openvk.component.video.a.a.b()));
        arrayList.add(new com.bykv.vk.openvk.component.video.api.a.a(new File(e()).listFiles(), com.bykv.vk.openvk.component.video.a.a.d()));
        arrayList.add(new com.bykv.vk.openvk.component.video.api.a.a(new File(c()).listFiles(), com.bykv.vk.openvk.component.video.a.a.e()));
        return arrayList;
    }

    private Set<String> g() {
        HashSet hashSet = new HashSet();
        for (com.bykv.vk.openvk.component.video.a.a.a next : com.bykv.vk.openvk.component.video.a.a.a.a.values()) {
            if (!(next == null || next.a() == null)) {
                com.bykv.vk.openvk.component.video.api.c.c a2 = next.a();
                hashSet.add(com.bykv.vk.openvk.component.video.a.e.c.b(a2.a(), a2.l()).getAbsolutePath());
                hashSet.add(com.bykv.vk.openvk.component.video.a.e.c.c(a2.a(), a2.l()).getAbsolutePath());
            }
        }
        for (com.bykv.vk.openvk.component.video.a.a.b.b next2 : com.bykv.vk.openvk.component.video.a.a.b.c.a.values()) {
            if (!(next2 == null || next2.a() == null)) {
                com.bykv.vk.openvk.component.video.api.c.c a3 = next2.a();
                hashSet.add(com.bykv.vk.openvk.component.video.a.e.c.b(a3.a(), a3.l()).getAbsolutePath());
                hashSet.add(com.bykv.vk.openvk.component.video.a.e.c.c(a3.a(), a3.l()).getAbsolutePath());
            }
        }
        return hashSet;
    }
}
