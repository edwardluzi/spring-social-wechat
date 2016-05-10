package org.springframework.social.wechat.api;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AccessToken
{
	@JsonProperty("access_token")
	private String accessToken;
	@JsonProperty("expires_in")
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
