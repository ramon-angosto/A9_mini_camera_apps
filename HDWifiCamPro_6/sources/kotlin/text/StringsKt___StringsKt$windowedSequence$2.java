package kotlin.text;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "R", "index", "", "invoke", "(I)Ljava/lang/Object;"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: _Strings.kt */
final class StringsKt___StringsKt$windowedSequence$2 extends Lambda implements Function1<Integer, R> {
    final /* synthetic */ int $size;
    final /* synthetic */ CharSequence $this_windowedSequence;
    final /* synthetic */ Function1<CharSequence, R> $transform;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    StringsKt___StringsKt$windowedSequence$2(int i, CharSequence charSequence, Function1<? super CharSequence, ? extends R> function1) {
        super(1);
        this.$size = i;
        this.$this_windowedSequence = charSequence;
        this.$transform = function1;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return invoke(((Number) obj).intValue());
    }

    public final R invoke(int i) {
        int i2 = this.$size + i;
        if (i2 < 0 || i2 > this.$this_windowedSequence.length()) {
            i2 = this.$this_windowedSequence.length();
        }
        return this.$transform.invoke(this.$this_windowedSequence.subSequence(i, i2));
    }
}
