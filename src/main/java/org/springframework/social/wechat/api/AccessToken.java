package org.springframework.social.wechat.api;

import java.io.Serializable;

public class AccessToken extends WechatObject implements Serializable
{
	private static final long serialVersionUID = -8917170810298579662L;

	private String accessToken;

	private Integer expiresIn;

	public String getAccessToken()
	{
		return accessToken;
	}

	public void setAccessToken(String accessToken)
	{
		this.accessToken = accessToken;
	}

	public Integer getExpiresIn()
	{
		return expiresIn;
	}

	public void setExpiresIn(Integer expiresIn)
	{
		this.expiresIn = expiresIn;
	}
}
