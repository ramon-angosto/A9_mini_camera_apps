package ms.bd.o.Pgl;

import com.bytedance.retrofit2.Call;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.mime.TypedByteArray;
import com.bytedance.retrofit2.mime.TypedInput;
import java.util.List;

public interface a {
    Call<TypedInput> a(String str, List<Header> list);

    Call<TypedInput> a(String str, List<Header> list, TypedByteArray typedByteArray);
}
