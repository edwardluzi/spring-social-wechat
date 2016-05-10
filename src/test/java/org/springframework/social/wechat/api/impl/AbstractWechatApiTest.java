package org.springframework.social.wechat.api.impl;

import org.junit.Before;
import org.springframework.social.wechat.api.AccessToken;

public class AbstractWechatApiTest
{
	protected WechatTemplate wechat;

	@Before
	public void setup()
	{
		wechat = createWechatTemplate();
	}

	protected String getAccessToken()
	{
		String appid = System.getenv("wechat.appid");
		String secret = System.getenv("wechat.secret");

		AccessToken accessToken = WechatTemplate.getAccessToken(appid, secret);

		return accessToken.getAccessToken();
	}

	protected WechatTemplate createWechatTemplate()
	{
		return new WechatTemplate(getAccessToken());
	}
}
