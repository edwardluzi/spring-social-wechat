package org.springframework.social.wechat.connect;

import org.springframework.social.oauth2.AbstractOAuth2ServiceProvider;
import org.springframework.social.oauth2.OAuth2Template;
import org.springframework.social.wechat.api.Wechat;
import org.springframework.social.wechat.api.impl.WechatTemplate;

public class WechatServiceProvider extends AbstractOAuth2ServiceProvider<Wechat>
{
    public WechatServiceProvider(String appId, String appSecret)
    {
        super(getOAuth2Template(appId, appSecret));
    }

    private static OAuth2Template getOAuth2Template(String appId, String appSecret)
    {
        OAuth2Template oauth2Template = new WechatOAuth2Template(appId, appSecret,
                "https://open.weixin.qq.com/connect/oauth2/authorize", "https://api.weixin.qq.com/cgi-bin/token");
        oauth2Template.setUseParametersForClientAuthentication(true);
        return oauth2Template;
    }

    @Override
    public Wechat getApi(String accessToken)
    {
        return new WechatTemplate(accessToken);
    }
}
