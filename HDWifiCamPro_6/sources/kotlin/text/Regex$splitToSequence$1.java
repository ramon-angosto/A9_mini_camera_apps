package kotlin.text;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.sequences.SequenceScope;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlin/sequences/SequenceScope;", ""}, k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "kotlin.text.Regex$splitToSequence$1", f = "Regex.kt", i = {1, 1, 1}, l = {276, 284, 288}, m = "invokeSuspend", n = {"$this$sequence", "matcher", "splitCount"}, s = {"L$0", "L$1", "I$0"})
/* compiled from: Regex.kt */
final class Regex$splitToSequence$1 extends RestrictedSuspendLambda implements Function2<SequenceScope<? super String>, Continuation<? super Unit>, Object> {
    final /* synthetic */ CharSequence $input;
    final /* synthetic */ int $limit;
    int I$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ Regex this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    Regex$splitToSequence$1(Regex regex, CharSequence charSequence, int i, Continuation<? super Regex$splitToSequence$1> continuation) {
        super(2, continuation);
        this.this$0 = regex;
        this.$input = charSequence;
        this.$limit = i;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Regex$splitToSequence$1 regex$splitToSequence$1 = new Regex$splitToSequence$1(this.this$0, this.$input, this.$limit, continuation);
        regex$splitToSequence$1.L$0 = obj;
        return regex$splitToSequence$1;
    }

    public final Object invoke(SequenceScope<? super String> sequenceScope, Continuation<? super Unit> continuation) {
        return ((Regex$splitToSequence$1) create(sequenceScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x00a6 A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r11) {
        /*
            r10 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r10.label
            r2 = 0
            r3 = 3
            r4 = 2
            r5 = 1
            if (r1 == 0) goto L_0x0036
            if (r1 == r5) goto L_0x0031
            if (r1 == r4) goto L_0x001f
            if (r1 != r3) goto L_0x0017
            kotlin.ResultKt.throwOnFailure(r11)
            goto L_0x00a7
        L_0x0017:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r0)
            throw r11
        L_0x001f:
            int r1 = r10.I$0
            java.lang.Object r2 = r10.L$1
            java.util.regex.Matcher r2 = (java.util.regex.Matcher) r2
            java.lang.Object r6 = r10.L$0
            kotlin.sequences.SequenceScope r6 = (kotlin.sequences.SequenceScope) r6
            kotlin.ResultKt.throwOnFailure(r11)
            r11 = r10
            r7 = r0
            r0 = r1
            r1 = r2
            goto L_0x0078
        L_0x0031:
            kotlin.ResultKt.throwOnFailure(r11)
            goto L_0x00bc
        L_0x0036:
            kotlin.ResultKt.throwOnFailure(r11)
            java.lang.Object r11 = r10.L$0
            kotlin.sequences.SequenceScope r11 = (kotlin.sequences.SequenceScope) r11
            kotlin.text.Regex r1 = r10.this$0
            java.util.regex.Pattern r1 = r1.nativePattern
            java.lang.CharSequence r6 = r10.$input
            java.util.regex.Matcher r1 = r1.matcher(r6)
            int r6 = r10.$limit
            if (r6 == r5) goto L_0x00aa
            boolean r6 = r1.find()
            if (r6 != 0) goto L_0x0054
            goto L_0x00aa
        L_0x0054:
            r6 = r11
            r7 = r0
            r0 = r2
            r11 = r10
        L_0x0058:
            java.lang.CharSequence r8 = r11.$input
            int r9 = r1.start()
            java.lang.CharSequence r2 = r8.subSequence(r2, r9)
            java.lang.String r2 = r2.toString()
            r8 = r11
            kotlin.coroutines.Continuation r8 = (kotlin.coroutines.Continuation) r8
            r11.L$0 = r6
            r11.L$1 = r1
            r11.I$0 = r0
            r11.label = r4
            java.lang.Object r2 = r6.yield(r2, r8)
            if (r2 != r7) goto L_0x0078
            return r7
        L_0x0078:
            int r2 = r1.end()
            int r0 = r0 + r5
            int r8 = r11.$limit
            int r8 = r8 - r5
            if (r0 == r8) goto L_0x0088
            boolean r8 = r1.find()
            if (r8 != 0) goto L_0x0058
        L_0x0088:
            java.lang.CharSequence r0 = r11.$input
            int r1 = r0.length()
            java.lang.CharSequence r0 = r0.subSequence(r2, r1)
            java.lang.String r0 = r0.toString()
            r1 = r11
            kotlin.coroutines.Continuation r1 = (kotlin.coroutines.Continuation) r1
            r2 = 0
            r11.L$0 = r2
            r11.L$1 = r2
            r11.label = r3
            java.lang.Object r11 = r6.yield(r0, r1)
            if (r11 != r7) goto L_0x00a7
            return r7
        L_0x00a7:
            kotlin.Unit r11 = kotlin.Unit.INSTANCE
            return r11
        L_0x00aa:
            java.lang.CharSequence r1 = r10.$input
            java.lang.String r1 = r1.toString()
            r2 = r10
            kotlin.coroutines.Continuation r2 = (kotlin.coroutines.Continuation) r2
            r10.label = r5
            java.lang.Object r11 = r11.yield(r1, r2)
            if (r11 != r0) goto L_0x00bc
            return r0
        L_0x00bc:
            kotlin.Unit r11 = kotlin.Unit.INSTANCE
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.text.Regex$splitToSequence$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
