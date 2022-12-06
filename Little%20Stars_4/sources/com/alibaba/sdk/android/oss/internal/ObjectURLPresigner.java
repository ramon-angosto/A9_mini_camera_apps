package com.alibaba.sdk.android.oss.internal;

import com.alibaba.sdk.android.oss.ClientException;
import com.alibaba.sdk.android.oss.common.auth.OSSCredentialProvider;
import com.alibaba.sdk.android.oss.common.auth.OSSCustomSignerCredentialProvider;
import com.alibaba.sdk.android.oss.common.auth.OSSFederationCredentialProvider;
import com.alibaba.sdk.android.oss.common.auth.OSSFederationToken;
import com.alibaba.sdk.android.oss.common.auth.OSSPlainTextAKSKCredentialProvider;
import com.alibaba.sdk.android.oss.common.auth.OSSStsTokenCredentialProvider;
import com.alibaba.sdk.android.oss.common.utils.DateUtil;
import com.alibaba.sdk.android.oss.common.utils.HttpUtil;
import com.alibaba.sdk.android.oss.common.utils.OSSUtils;
import java.net.URI;

public class ObjectURLPresigner {
    private OSSCredentialProvider credentialProvider;
    private URI endpoint;

    public ObjectURLPresigner(URI uri, OSSCredentialProvider oSSCredentialProvider) {
        this.endpoint = uri;
        this.credentialProvider = oSSCredentialProvider;
    }

    public String presignConstrainedURL(String str, String str2, long j) throws ClientException {
        OSSFederationToken oSSFederationToken;
        String str3;
        String str4 = "/" + str + "/" + str2;
        String valueOf = String.valueOf((DateUtil.getFixedSkewedTimeMillis() / 1000) + j);
        OSSCredentialProvider oSSCredentialProvider = this.credentialProvider;
        if (oSSCredentialProvider instanceof OSSFederationCredentialProvider) {
            oSSFederationToken = ((OSSFederationCredentialProvider) oSSCredentialProvider).getValidFederationToken();
            if (oSSFederationToken != null) {
                str4 = str4 + "?security-token=" + oSSFederationToken.getSecurityToken();
            } else {
                throw new ClientException("Can not get a federation token!");
            }
        } else if (oSSCredentialProvider instanceof OSSStsTokenCredentialProvider) {
            oSSFederationToken = ((OSSStsTokenCredentialProvider) oSSCredentialProvider).getFederationToken();
            str4 = str4 + "?security-token=" + oSSFederationToken.getSecurityToken();
        } else {
            oSSFederationToken = null;
        }
        String str5 = "GET\n\n\n" + valueOf + "\n" + str4;
        OSSCredentialProvider oSSCredentialProvider2 = this.credentialProvider;
        if ((oSSCredentialProvider2 instanceof OSSFederationCredentialProvider) || (oSSCredentialProvider2 instanceof OSSStsTokenCredentialProvider)) {
            str3 = OSSUtils.sign(oSSFederationToken.getTempAK(), oSSFederationToken.getTempSK(), str5);
        } else if (oSSCredentialProvider2 instanceof OSSPlainTextAKSKCredentialProvider) {
            str3 = OSSUtils.sign(((OSSPlainTextAKSKCredentialProvider) oSSCredentialProvider2).getAccessKeyId(), ((OSSPlainTextAKSKCredentialProvider) this.credentialProvider).getAccessKeySecret(), str5);
        } else if (oSSCredentialProvider2 instanceof OSSCustomSignerCredentialProvider) {
            str3 = ((OSSCustomSignerCredentialProvider) oSSCredentialProvider2).signContent(str5);
        } else {
            throw new ClientException("Unknown credentialProvider!");
        }
        String substring = str3.split(":")[0].substring(4);
        String str6 = str3.split(":")[1];
        String host = this.endpoint.getHost();
        if (!OSSUtils.isCname(host)) {
            host = str + "." + host;
        }
        String str7 = this.endpoint.getScheme() + "://" + host + "/" + HttpUtil.urlEncode(str2, "utf-8") + "?OSSAccessKeyId=" + HttpUtil.urlEncode(substring, "utf-8") + "&Expires=" + valueOf + "&Signature=" + HttpUtil.urlEncode(str6, "utf-8");
        OSSCredentialProvider oSSCredentialProvider3 = this.credentialProvider;
        if (!(oSSCredentialProvider3 instanceof OSSFederationCredentialProvider) && !(oSSCredentialProvider3 instanceof OSSStsTokenCredentialProvider)) {
            return str7;
        }
        return str7 + "&security-token=" + HttpUtil.urlEncode(oSSFederationToken.getSecurityToken(), "utf-8");
    }

    public String presignPublicURL(String str, String str2) {
        String host = this.endpoint.getHost();
        if (!OSSUtils.isCname(host)) {
            host = str + "." + host;
        }
        return this.endpoint.getScheme() + "://" + host + "/" + HttpUtil.urlEncode(str2, "utf-8");
    }
}
