package org.springframework.social.wechat.api;

import java.util.Map;

public class ViewEvent extends Message
{
	private String EventKey;

	public ViewEvent(Map<String, String> params) throws Exception
	{
		super(params);

		if (params.containsKey("EventKey"))
		{
			this.EventKey = params.get("EventKey");
		}
	}

	public String getEventKey()
	{
		return EventKey;
	}
}
