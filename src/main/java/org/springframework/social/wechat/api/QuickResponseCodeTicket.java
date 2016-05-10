package org.springframework.social.wechat.api;

import java.io.Serializable;

public class QuickResponseCodeTicket extends WechatObject implements Serializable
{
	private static final long serialVersionUID = 7438480647931127709L;

	private String ticket;

	private Integer expireSeconds;

	private String url;

	public String getTicket()
	{
		return ticket;
	}

	public void setTicket(String ticket)
	{
		this.ticket = ticket;
	}

	public Integer getExpireSeconds()
	{
		return expireSeconds;
	}

	public void setExpireSeconds(Integer expireSeconds)
	{
		this.expireSeconds = expireSeconds;
	}

	public String getUrl()
	{
		return url;
	}

	public void setUrl(String url)
	{
		this.url = url;
	}
}
