package com.ironsource.sdk.controller;

import android.app.Activity;
import android.text.TextUtils;
import com.ironsource.environment.a;
import com.ironsource.sdk.c.c;
import com.ironsource.sdk.c.d;
import com.ironsource.sdk.c.e;
import com.ironsource.sdk.controller.x;
import com.ironsource.sdk.g.f;
import com.ironsource.sdk.utils.Logger;
import org.json.JSONObject;

public final class a implements com.ironsource.sdk.b.a {
    y a;
    private d b = d.a();
    private c c;

    /* renamed from: com.ironsource.sdk.controller.a$a  reason: collision with other inner class name */
    static class C0093a {
        String a;
        JSONObject b;
        String c;
        String d;

        private C0093a() {
        }

        /* synthetic */ C0093a(byte b2) {
            this();
        }
    }

    public a(c cVar) {
        this.c = cVar;
    }

    /* access modifiers changed from: package-private */
    public final void a(String str, x.d.a aVar) {
        JSONObject jSONObject = new JSONObject(str);
        C0093a aVar2 = new C0093a((byte) 0);
        aVar2.a = jSONObject.optString("functionName");
        aVar2.b = jSONObject.optJSONObject("functionParams");
        aVar2.c = jSONObject.optString("success");
        aVar2.d = jSONObject.optString("fail");
        f fVar = new f();
        try {
            String str2 = aVar2.a;
            char c2 = 65535;
            switch (str2.hashCode()) {
                case -1384357108:
                    if (str2.equals("removeAdView")) {
                        c2 = 2;
                        break;
                    }
                    break;
                case 691453791:
                    if (str2.equals("sendMessage")) {
                        c2 = 1;
                        break;
                    }
                    break;
                case 842351363:
                    if (str2.equals("loadWithUrl")) {
                        c2 = 0;
                        break;
                    }
                    break;
                case 1182065477:
                    if (str2.equals("handleGetViewVisibility")) {
                        c2 = 3;
                        break;
                    }
                    break;
                case 1491535759:
                    if (str2.equals("webviewAction")) {
                        c2 = 4;
                        break;
                    }
                    break;
            }
            if (c2 == 0) {
                d dVar = this.b;
                JSONObject jSONObject2 = aVar2.b;
                Activity a2 = this.c.a();
                String str3 = aVar2.c;
                String str4 = aVar2.d;
                String string = jSONObject2.getString("adViewId");
                if (!string.isEmpty()) {
                    com.ironsource.sdk.a c3 = dVar.c(jSONObject2);
                    if (!dVar.b.containsKey(string)) {
                        c cVar = new c(this, a2, string, c3);
                        com.ironsource.environment.e.a.a.a(new Runnable(str4, jSONObject2, str3) {
                            private /* synthetic */ String a;
                            private /* synthetic */ JSONObject b;
                            private /* synthetic */ String c;

                            public final void run(
/*
Method generation error in method: com.ironsource.sdk.c.c.1.run():void, dex: classes2.dex
                            jadx.core.utils.exceptions.JadxRuntimeException: Method args not loaded: com.ironsource.sdk.c.c.1.run():void, class status: UNLOADED
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
                            	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                            	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:142)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                            	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                            	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:142)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                            	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                            	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:142)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                            	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                            	at jadx.core.codegen.RegionGen.makeTryCatch(RegionGen.java:311)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:68)
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
                        });
                        if (d.b(jSONObject2)) {
                            com.ironsource.environment.e.a.a.a(new Runnable(cVar, a2, string) {
                                private /* synthetic */ c a;
                                private /* synthetic */ Activity b;
                                private /* synthetic */ String c;

                                public final void run(
/*
Method generation error in method: com.ironsource.sdk.c.d.1.run():void, dex: classes2.dex
                                jadx.core.utils.exceptions.JadxRuntimeException: Method args not loaded: com.ironsource.sdk.c.d.1.run():void, class status: UNLOADED
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
                                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:142)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:142)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:142)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:142)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                                	at jadx.core.codegen.RegionGen.makeTryCatch(RegionGen.java:311)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:68)
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
                            });
                        } else {
                            dVar.b.put(string, cVar);
                        }
                    } else {
                        Logger.i(d.a, "sendMessageToAd fail - collection already contain adViewId");
                        throw new Exception("collection already contain adViewId");
                    }
                } else {
                    Logger.i(d.a, "loadWithUrl fail - adViewId is empty");
                    throw new Exception("adViewId is empty");
                }
            } else if (c2 == 1) {
                d dVar2 = this.b;
                JSONObject jSONObject3 = aVar2.b;
                String str5 = aVar2.c;
                String str6 = aVar2.d;
                String string2 = new JSONObject(jSONObject3.getString("params")).getString("adViewId");
                if (string2.isEmpty()) {
                    Logger.i(d.a, "sendMessageToAd fail - adViewId is empty");
                    throw new Exception("adViewId is empty");
                } else if (dVar2.b.containsKey(string2)) {
                    e eVar = dVar2.b.get(string2);
                    if (eVar != null) {
                        eVar.b(jSONObject3, str5, str6);
                    }
                } else {
                    Logger.i(d.a, "sendMessageToAd fail - collection does not contain adViewId");
                    throw new Exception("collection does not contain adViewId");
                }
            } else if (c2 == 2) {
                d dVar3 = this.b;
                JSONObject jSONObject4 = aVar2.b;
                String str7 = aVar2.c;
                String str8 = aVar2.d;
                String string3 = jSONObject4.getString("adViewId");
                if (string3.isEmpty()) {
                    Logger.i(d.a, "removeAdView fail - adViewId is empty");
                    throw new Exception("adViewId is empty");
                } else if (dVar3.b.containsKey(string3)) {
                    e eVar2 = dVar3.b.get(string3);
                    dVar3.b.remove(string3);
                    if (eVar2 != null) {
                        eVar2.a(str7, str8);
                    }
                } else {
                    Logger.i(d.a, "removeAdView fail - collection does not contain adViewId");
                    throw new Exception("collection does not contain adViewId");
                }
            } else if (c2 == 3) {
                d dVar4 = this.b;
                JSONObject jSONObject5 = aVar2.b;
                String str9 = aVar2.c;
                String str10 = aVar2.d;
                String string4 = jSONObject5.getString("adViewId");
                if (string4.isEmpty()) {
                    Logger.i(d.a, "removeAdView fail - adViewId is empty");
                    throw new Exception("adViewId is empty");
                } else if (dVar4.b.containsKey(string4)) {
                    e eVar3 = dVar4.b.get(string4);
                    if (eVar3 != null) {
                        eVar3.a(jSONObject5, str9, str10);
                    }
                } else {
                    Logger.i(d.a, "removeAdView fail - collection does not contain adViewId");
                    throw new Exception("collection does not contain adViewId");
                }
            } else if (c2 == 4) {
                d dVar5 = this.b;
                JSONObject jSONObject6 = aVar2.b;
                String str11 = aVar2.c;
                String str12 = aVar2.d;
                String string5 = jSONObject6.getString("adViewId");
                if (string5.isEmpty()) {
                    Logger.i(d.a, "performWebViewAction fail - adViewId is empty");
                    throw new Exception("adViewId is empty");
                } else if (dVar5.b.containsKey(string5)) {
                    e eVar4 = dVar5.b.get(string5);
                    String string6 = jSONObject6.getString("actionName");
                    if (eVar4 != null) {
                        eVar4.a(string6, str11, str12);
                    }
                } else {
                    Logger.i(d.a, "performWebViewAction fail - collection does not contain adViewId");
                    throw new Exception("collection does not contain adViewId");
                }
            } else {
                throw new IllegalArgumentException(String.format("%s | unsupported AdViews API", new Object[]{aVar2.a}));
            }
        } catch (Exception e) {
            fVar.a("errMsg", e.getMessage());
            String a3 = d.a(aVar2.b);
            if (!TextUtils.isEmpty(a3)) {
                fVar.a("adViewId", a3);
            }
            aVar.a(false, aVar2.d, fVar);
        }
    }

    public final void a(String str, String str2, String str3) {
        a(str, a.AnonymousClass1.b(str2, str3));
    }

    public final void a(String str, JSONObject jSONObject) {
        if (this.a != null && !TextUtils.isEmpty(str)) {
            this.a.a(str, jSONObject);
        }
    }
}
