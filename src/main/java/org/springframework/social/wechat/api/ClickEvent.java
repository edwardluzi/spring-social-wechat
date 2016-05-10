package org.springframework.social.wechat.api;

import java.util.Map;

public class ClickEvent extends EventMessage
{
	private String EventKey;

	public ClickEvent(Map<String, String> params) throws Exception
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
