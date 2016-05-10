package org.springframework.social.wechat.api;

import java.io.Serializable;

public class ValueColorPair extends WechatObject implements Serializable
{
	private static final long serialVersionUID = -3899390835251973061L;

	private String value;

	private String color;

	public String getValue()
	{
		return value;
	}

	public void setValue(String value)
	{
		this.value = value;
	}

	public String getColor()
	{
		return color;
	}

	public void setColor(String color)
	{
		this.color = color;
	}

	public ValueColorPair(String value, String color)
	{
		this.value = value;
		this.color = color;
	}
}
