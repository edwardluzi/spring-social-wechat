package org.springframework.social.wechat.connect;

import org.springframework.social.oauth2.AccessGrant;
import org.springframework.social.oauth2.OAuth2Template;
import org.springframework.util.MultiValueMap;

public class WechatOAuth2Template extends OAuth2Template
{
    public WechatOAuth2Template(String clientId, String clientSecret, String authorizeUrl, String accessTokenUrl)
    {
        super(clientId, clientSecret, authorizeUrl, accessTokenUrl);
    }

    public WechatOAuth2Template(String clientId, String clientSecret, String authorizeUrl, String authenticateUrl,
            String accessTokenUrl)
    {
        super(clientId, clientSecret, authorizeUrl, authenticateUrl, accessTokenUrl);
    }

    @Override
    protected AccessGrant postForAccessGrant(String accessTokenUrl, MultiValueMap<String, String> parameters)
    {
        if ("client_credentials".equals(parameters.getFirst("grant_type")))
        {
            parameters.set("appid", parameters.getFirst("client_id"));
            parameters.set("secret", parameters.getFirst("client_secret"));
            parameters.set("grant_type", "client_credential");
            parameters.remove("client_id");
            parameters.remove("client_secret");
        }

        return super.postForAccessGrant(accessTokenUrl, parameters);
    }
}
