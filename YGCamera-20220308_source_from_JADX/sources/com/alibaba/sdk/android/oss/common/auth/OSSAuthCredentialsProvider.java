package com.alibaba.sdk.android.oss.common.auth;

import com.alibaba.sdk.android.oss.ClientException;
import com.alibaba.sdk.android.oss.common.utils.IOUtils;
import com.huawei.hms.android.HwBuildEx;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;

public class OSSAuthCredentialsProvider extends OSSFederationCredentialProvider {
    private String mAuthServerUrl;
    private AuthDecoder mDecoder;

    public interface AuthDecoder {
        String decode(String str);
    }

    public OSSAuthCredentialsProvider(String str) {
        this.mAuthServerUrl = str;
    }

    public void setAuthServerUrl(String str) {
        this.mAuthServerUrl = str;
    }

    public void setDecoder(AuthDecoder authDecoder) {
        this.mDecoder = authDecoder;
    }

    public OSSFederationToken getFederationToken() throws ClientException {
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(this.mAuthServerUrl).openConnection();
            httpURLConnection.setConnectTimeout(HwBuildEx.VersionCodes.CUR_DEVELOPMENT);
            String readStreamAsString = IOUtils.readStreamAsString(httpURLConnection.getInputStream(), "utf-8");
            if (this.mDecoder != null) {
                readStreamAsString = this.mDecoder.decode(readStreamAsString);
            }
            JSONObject jSONObject = new JSONObject(readStreamAsString);
            if (jSONObject.getInt("StatusCode") == 200) {
                return new OSSFederationToken(jSONObject.getString("AccessKeyId"), jSONObject.getString("AccessKeySecret"), jSONObject.getString("SecurityToken"), jSONObject.getString("Expiration"));
            }
            String string = jSONObject.getString("ErrorCode");
            String string2 = jSONObject.getString("ErrorMessage");
            throw new ClientException("ErrorCode: " + string + "| ErrorMessage: " + string2);
        } catch (Exception e) {
            throw new ClientException((Throwable) e);
        }
    }
}
