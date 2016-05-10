package org.springframework.social.wechat.api;

import java.util.HashMap;
import java.util.Map;

public abstract class WechatObject
{
	private Map<String, Object> extraData;

	public WechatObject()
	{
		this.extraData = new HashMap<String, Object>();
	}

	public Map<String, Object> getExtraData()
	{
		return this.extraData;
	}

	protected void add(String key, Object value)
	{
		this.extraData.put(key, value);
	}
}
