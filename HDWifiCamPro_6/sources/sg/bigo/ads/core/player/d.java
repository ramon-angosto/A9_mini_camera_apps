package sg.bigo.ads.core.player;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import sg.bigo.ads.api.core.a;
import sg.bigo.ads.common.f.c;
import sg.bigo.ads.common.p.b;

public final class d implements a.C0119a, b.a {
    public boolean a;
    final Handler b;
    private final ArrayList<WeakReference<View>> c;
    private final Runnable d;

    public static class a {
        /* access modifiers changed from: private */
        public static final d a = new d((byte) 0);
    }

    private d() {
        this.a = false;
        this.b = new Handler(Looper.getMainLooper());
        this.c = new ArrayList<>();
        this.d = new Runnable() {
            public final void run() {
                if (d.this.c()) {
                    d.this.b.postDelayed(this, 500);
                }
            }
        };
        c.a(2, new Runnable(this) {
            final /* synthetic */ C0119a a;

            public final void run(
/*
Method generation error in method: sg.bigo.ads.api.core.a.1.run():void, dex: classes3.dex
            jadx.core.utils.exceptions.JadxRuntimeException: Method args not loaded: sg.bigo.ads.api.core.a.1.run():void, class status: UNLOADED
            	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:278)
            	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:116)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:313)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
            	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
            	at java.util.ArrayList.forEach(ArrayList.java:1259)
            	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
            	at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:483)
            	at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:472)
            	at java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
            	at java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
            	at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
            	at java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:485)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
            	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:676)
            	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:607)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:364)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:231)
            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:123)
            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:107)
            	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:787)
            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:728)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:368)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:250)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:221)
            	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:109)
            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
            	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:211)
            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:204)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:318)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
            	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
            	at java.util.ArrayList.forEach(ArrayList.java:1259)
            	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
            	at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:483)
            	at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:472)
            	at java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
            	at java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
            	at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
            	at java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:485)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:112)
            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:78)
            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:44)
            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:33)
            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:21)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:61)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
            
*/
        }, 1);
    }

    /* synthetic */ d(byte b2) {
        this();
    }

    private synchronized void d() {
        e();
        sg.bigo.ads.common.k.a.a(0, 3, "VideoPlayerManager", "startCheckTask called");
        this.b.post(this.d);
    }

    private synchronized void e() {
        sg.bigo.ads.common.k.a.a(0, 3, "VideoPlayerManager", "removeCheckTask called");
        this.b.removeCallbacksAndMessages((Object) null);
        c();
    }

    public final void a() {
        d();
        sg.bigo.ads.common.k.a.a(0, 3, "VideoPlayerManager", "onActivityResumed");
    }

    public final void a(int i) {
        if (i == 1) {
            d();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0062, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void a(sg.bigo.ads.core.player.b.b r5) {
        /*
            r4 = this;
            monitor-enter(r4)
            java.util.ArrayList<java.lang.ref.WeakReference<android.view.View>> r0 = r4.c     // Catch:{ all -> 0x0063 }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ all -> 0x0063 }
        L_0x0007:
            boolean r1 = r0.hasNext()     // Catch:{ all -> 0x0063 }
            r2 = 1
            r3 = 0
            if (r1 == 0) goto L_0x0025
            java.lang.Object r1 = r0.next()     // Catch:{ all -> 0x0063 }
            java.lang.ref.WeakReference r1 = (java.lang.ref.WeakReference) r1     // Catch:{ all -> 0x0063 }
            java.lang.Object r1 = r1.get()     // Catch:{ all -> 0x0063 }
            android.view.View r1 = (android.view.View) r1     // Catch:{ all -> 0x0063 }
            if (r1 != 0) goto L_0x0021
            r0.remove()     // Catch:{ all -> 0x0063 }
            goto L_0x0007
        L_0x0021:
            if (r1 != r5) goto L_0x0007
            r0 = r2
            goto L_0x0026
        L_0x0025:
            r0 = r3
        L_0x0026:
            if (r0 == 0) goto L_0x0031
            java.lang.String r5 = "VideoPlayerManager"
            java.lang.String r0 = "register playerView exist already"
            sg.bigo.ads.common.k.a.b(r5, r0)     // Catch:{ all -> 0x0063 }
            monitor-exit(r4)
            return
        L_0x0031:
            java.util.ArrayList<java.lang.ref.WeakReference<android.view.View>> r0 = r4.c     // Catch:{ all -> 0x0063 }
            java.lang.ref.WeakReference r1 = new java.lang.ref.WeakReference     // Catch:{ all -> 0x0063 }
            r1.<init>(r5)     // Catch:{ all -> 0x0063 }
            r0.add(r1)     // Catch:{ all -> 0x0063 }
            java.lang.String r5 = "VideoPlayerManager"
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0063 }
            java.lang.String r1 = "register playerView, size = "
            r0.<init>(r1)     // Catch:{ all -> 0x0063 }
            java.util.ArrayList<java.lang.ref.WeakReference<android.view.View>> r1 = r4.c     // Catch:{ all -> 0x0063 }
            int r1 = r1.size()     // Catch:{ all -> 0x0063 }
            r0.append(r1)     // Catch:{ all -> 0x0063 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0063 }
            r1 = 3
            sg.bigo.ads.common.k.a.a(r3, r1, r5, r0)     // Catch:{ all -> 0x0063 }
            r4.d()     // Catch:{ all -> 0x0063 }
            boolean r5 = r4.a     // Catch:{ all -> 0x0063 }
            if (r5 != 0) goto L_0x0061
            r4.a = r2     // Catch:{ all -> 0x0063 }
            sg.bigo.ads.common.p.b.a((sg.bigo.ads.common.p.b.a) r4)     // Catch:{ all -> 0x0063 }
        L_0x0061:
            monitor-exit(r4)
            return
        L_0x0063:
            r5 = move-exception
            monitor-exit(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: sg.bigo.ads.core.player.d.a(sg.bigo.ads.core.player.b.b):void");
    }

    public final void b() {
        sg.bigo.ads.common.k.a.a(0, 3, "VideoPlayerManager", "onActivityPaused");
        e();
    }

    public final synchronized void b(sg.bigo.ads.core.player.b.b bVar) {
        Iterator<WeakReference<View>> it = this.c.iterator();
        while (it.hasNext()) {
            View view = (View) it.next().get();
            if (view != null) {
                if (view == bVar) {
                    ((sg.bigo.ads.core.player.b.b) view).i();
                }
            }
            it.remove();
        }
        sg.bigo.ads.common.k.a.a(0, 3, "VideoPlayerManager", "unregister player, size = " + this.c.size());
        if (this.c.isEmpty()) {
            e();
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00b0, code lost:
        return r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized boolean c() {
        /*
            r14 = this;
            monitor-enter(r14)
            java.util.ArrayList<java.lang.ref.WeakReference<android.view.View>> r0 = r14.c     // Catch:{ all -> 0x00b1 }
            boolean r0 = r0.isEmpty()     // Catch:{ all -> 0x00b1 }
            r1 = 0
            if (r0 == 0) goto L_0x000c
            monitor-exit(r14)
            return r1
        L_0x000c:
            android.content.Context r0 = sg.bigo.ads.common.b.a.a     // Catch:{ all -> 0x00b1 }
            if (r0 == 0) goto L_0x0018
            boolean r2 = sg.bigo.ads.common.p.b.a()     // Catch:{ all -> 0x00b1 }
            if (r2 == 0) goto L_0x0018
            r2 = 1
            goto L_0x0019
        L_0x0018:
            r2 = r1
        L_0x0019:
            r3 = 0
            java.util.ArrayList<java.lang.ref.WeakReference<android.view.View>> r4 = r14.c     // Catch:{ all -> 0x00b1 }
            java.util.Iterator r4 = r4.iterator()     // Catch:{ all -> 0x00b1 }
            r5 = r1
        L_0x0021:
            boolean r6 = r4.hasNext()     // Catch:{ all -> 0x00b1 }
            if (r6 == 0) goto L_0x009c
            java.lang.Object r6 = r4.next()     // Catch:{ all -> 0x00b1 }
            java.lang.ref.WeakReference r6 = (java.lang.ref.WeakReference) r6     // Catch:{ all -> 0x00b1 }
            java.lang.Object r6 = r6.get()     // Catch:{ all -> 0x00b1 }
            android.view.View r6 = (android.view.View) r6     // Catch:{ all -> 0x00b1 }
            boolean r7 = r6 instanceof sg.bigo.ads.core.player.b.b     // Catch:{ all -> 0x00b1 }
            r8 = 3
            if (r7 != 0) goto L_0x0043
            r4.remove()     // Catch:{ all -> 0x00b1 }
            java.lang.String r6 = "VideoPlayerManager"
            java.lang.String r7 = "playView is recycled, remove it"
            sg.bigo.ads.common.k.a.a(r1, r8, r6, r7)     // Catch:{ all -> 0x00b1 }
            goto L_0x0021
        L_0x0043:
            if (r0 != 0) goto L_0x0049
            android.content.Context r0 = r6.getContext()     // Catch:{ all -> 0x00b1 }
        L_0x0049:
            r7 = 1120403456(0x42c80000, float:100.0)
            android.graphics.Rect r9 = new android.graphics.Rect     // Catch:{ all -> 0x00b1 }
            r9.<init>()     // Catch:{ all -> 0x00b1 }
            boolean r10 = sg.bigo.ads.common.q.a.a(r6, r9)     // Catch:{ all -> 0x00b1 }
            r11 = 0
            if (r10 != 0) goto L_0x0058
            goto L_0x0080
        L_0x0058:
            int r10 = r6.getHeight()     // Catch:{ all -> 0x00b1 }
            float r10 = (float) r10     // Catch:{ all -> 0x00b1 }
            r12 = 1065353216(0x3f800000, float:1.0)
            float r10 = r10 * r12
            int r13 = r6.getWidth()     // Catch:{ all -> 0x00b1 }
            float r13 = (float) r13     // Catch:{ all -> 0x00b1 }
            float r10 = r10 * r13
            int r13 = r9.height()     // Catch:{ all -> 0x00b1 }
            float r13 = (float) r13     // Catch:{ all -> 0x00b1 }
            float r13 = r13 * r12
            int r9 = r9.width()     // Catch:{ all -> 0x00b1 }
            float r9 = (float) r9     // Catch:{ all -> 0x00b1 }
            float r13 = r13 * r9
            int r9 = (r10 > r11 ? 1 : (r10 == r11 ? 0 : -1))
            if (r9 > 0) goto L_0x007e
            java.lang.String r9 = "ImpressionChecker"
            java.lang.String r10 = "adView is not visible, width or height is 0"
            sg.bigo.ads.common.k.a.a(r1, r8, r9, r10)     // Catch:{ all -> 0x00b1 }
            goto L_0x0080
        L_0x007e:
            float r11 = r13 / r10
        L_0x0080:
            float r7 = r7 * r11
            int r7 = (int) r7     // Catch:{ all -> 0x00b1 }
            if (r7 < r5) goto L_0x0096
            r8 = 50
            if (r7 < r8) goto L_0x0096
            if (r2 != 0) goto L_0x008b
            goto L_0x0096
        L_0x008b:
            if (r7 != r5) goto L_0x0093
            sg.bigo.ads.core.player.b.b r3 = (sg.bigo.ads.core.player.b.b) r3     // Catch:{ all -> 0x00b1 }
            r3.i()     // Catch:{ all -> 0x00b1 }
            goto L_0x0094
        L_0x0093:
            r5 = r7
        L_0x0094:
            r3 = r6
            goto L_0x0021
        L_0x0096:
            sg.bigo.ads.core.player.b.b r6 = (sg.bigo.ads.core.player.b.b) r6     // Catch:{ all -> 0x00b1 }
            r6.i()     // Catch:{ all -> 0x00b1 }
            goto L_0x0021
        L_0x009c:
            if (r3 == 0) goto L_0x00af
            sg.bigo.ads.core.player.b.b r3 = (sg.bigo.ads.core.player.b.b) r3     // Catch:{ all -> 0x00b1 }
            int r0 = r3.getPlayStatus()     // Catch:{ all -> 0x00b1 }
            r1 = 2
            if (r0 == r1) goto L_0x00af
            r1 = 5
            if (r0 == r1) goto L_0x00af
            if (r0 == 0) goto L_0x00af
            r3.h()     // Catch:{ all -> 0x00b1 }
        L_0x00af:
            monitor-exit(r14)
            return r2
        L_0x00b1:
            r0 = move-exception
            monitor-exit(r14)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: sg.bigo.ads.core.player.d.c():boolean");
    }
}
